/*
 * Copyright 2025-2026 Open Health Stack Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.ohs.fhir.codegen

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.WildcardTypeName

/**
 * Emits `ResourcePolymorphicSerializer.kt`, an `AbstractPolymorphicSerializer<Resource>` with
 * hand-rolled name/class dispatch maps and a manually-built descriptor.
 */
object FhirResourcePolymorphicSerializerFileSpecGenerator {
  fun generate(packageName: String, subclasses: List<ClassName>): FileSpec {
    val sorted = subclasses.sorted()
    val serializersPackage = "$packageName.serializers"
    val resourceCN = ClassName(packageName, "Resource")

    val abstractPolymorphicSerializerCN =
      ClassName("kotlinx.serialization.internal", "AbstractPolymorphicSerializer")
    val internalSerializationApiCN = ClassName("kotlinx.serialization", "InternalSerializationApi")
    val experimentalSerializationApiCN =
      ClassName("kotlinx.serialization", "ExperimentalSerializationApi")
    val deserializationStrategyCN = ClassName("kotlinx.serialization", "DeserializationStrategy")
    val serializationStrategyCN = ClassName("kotlinx.serialization", "SerializationStrategy")
    val serialDescriptorCN = ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val polymorphicKindCN = ClassName("kotlinx.serialization.descriptors", "PolymorphicKind")
    val serialKindCN = ClassName("kotlinx.serialization.descriptors", "SerialKind")
    val buildSerialDescriptorMN =
      MemberName("kotlinx.serialization.descriptors", "buildSerialDescriptor")
    val builtinsSerializerMN = MemberName("kotlinx.serialization.builtins", "serializer")
    val compositeDecoderCN = ClassName("kotlinx.serialization.encoding", "CompositeDecoder")
    val encoderCN = ClassName("kotlinx.serialization.encoding", "Encoder")
    val kClassCN = ClassName("kotlin.reflect", "KClass")
    val mapCN = ClassName("kotlin.collections", "Map")
    val mapOfMN = MemberName("kotlin.collections", "mapOf")
    val jsonClassDiscriminatorCN = ClassName("kotlinx.serialization.json", "JsonClassDiscriminator")
    val stringCN = ClassName("kotlin", "String")

    val kSerializerOutResourceTN =
      ClassName("kotlinx.serialization", "KSerializer")
        .parameterizedBy(WildcardTypeName.producerOf(resourceCN))

    val baseClassProp =
      PropertySpec.builder("baseClass", kClassCN.parameterizedBy(resourceCN))
        .addModifiers(KModifier.OVERRIDE)
        .initializer("%T::class", resourceCN)
        .build()

    val byNameInit =
      CodeBlock.builder()
        .apply {
          add("%M(\n", mapOfMN)
          indent()
          for (sc in sorted) {
            val polySerCN = ClassName(serializersPackage, "${sc.simpleName}PolymorphicSerializer")
            add("%S to %T,\n", sc.simpleName, polySerCN)
          }
          unindent()
          add(")")
        }
        .build()
    val byNameProp =
      PropertySpec.builder("byName", mapCN.parameterizedBy(stringCN, kSerializerOutResourceTN))
        .addModifiers(KModifier.PRIVATE)
        .initializer(byNameInit)
        .build()

    val byClassInit =
      CodeBlock.builder()
        .apply {
          add("%M(\n", mapOfMN)
          indent()
          for (sc in sorted) {
            val concreteCN = ClassName(packageName, sc.simpleName)
            val polySerCN = ClassName(serializersPackage, "${sc.simpleName}PolymorphicSerializer")
            add("%T::class to %T,\n", concreteCN, polySerCN)
          }
          unindent()
          add(")")
        }
        .build()
    val byClassProp =
      PropertySpec.builder(
          "byClass",
          mapCN.parameterizedBy(kClassCN.parameterizedBy(STAR), kSerializerOutResourceTN),
        )
        .addModifiers(KModifier.PRIVATE)
        .initializer(byClassInit)
        .build()

    // Mirrors `SealedClassSerializer.descriptor`'s `type`/`value` pair shape; the
    // `JsonClassDiscriminator` is what `Polymorphic.kt:97` reads to get `"resourceType"`.
    val descriptorInit =
      CodeBlock.builder()
        .apply {
          add("%M(%S, %T.SEALED) {\n", buildSerialDescriptorMN, "Resource", polymorphicKindCN)
          indent()
          add("// `SealedClassSerializer` convention: slot 0 is named \"type\" even when\n")
          add("// `@JsonClassDiscriminator` overrides the wire key — kotlinx-json reads the\n")
          add("// actual key from `descriptor.annotations`, not from this slot's name.\n")
          add("element(%S, %T.%M().descriptor)\n", "type", stringCN, builtinsSerializerMN)
          add(
            "val valueDesc = %M(%S, %T.CONTEXTUAL) {\n",
            buildSerialDescriptorMN,
            "kotlinx.serialization.Sealed<Resource>",
            serialKindCN,
          )
          indent()
          add("for ((name, ser) in byName) element(name, ser.descriptor)\n")
          unindent()
          add("}\n")
          add("element(%S, valueDesc)\n", "value")
          add("annotations = listOf(%T(%S))\n", jsonClassDiscriminatorCN, "resourceType")
          unindent()
          add("}")
        }
        .build()
    val descriptorProp =
      PropertySpec.builder("descriptor", serialDescriptorCN)
        .addModifiers(KModifier.OVERRIDE)
        .initializer(descriptorInit)
        .build()

    val findEncodeFn =
      FunSpec.builder("findPolymorphicSerializerOrNull")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(
          AnnotationSpec.builder(Suppress::class).addMember("%S", "UNCHECKED_CAST").build()
        )
        .addParameter("encoder", encoderCN)
        .addParameter("value", resourceCN)
        .returns(serializationStrategyCN.parameterizedBy(resourceCN).copy(nullable = true))
        // `byClass[…]` returns `KSerializer<out Resource>?`; the override needs the invariant
        // `SerializationStrategy<Resource>?`. We've already looked up by `value::class`, so the
        // cast is sound.
        .addCode(
          "return (byClass[value::class] ?: super.findPolymorphicSerializerOrNull(encoder, value))" +
            " as %T?\n",
          serializationStrategyCN.parameterizedBy(resourceCN),
        )
        .build()

    val findDecodeFn =
      FunSpec.builder("findPolymorphicSerializerOrNull")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", compositeDecoderCN)
        .addParameter("klassName", stringCN.copy(nullable = true))
        .returns(deserializationStrategyCN.parameterizedBy(resourceCN).copy(nullable = true))
        .addCode(
          "return byName[klassName] ?: super.findPolymorphicSerializerOrNull(decoder, klassName)\n"
        )
        .build()

    val objectSpec =
      TypeSpec.objectBuilder("ResourcePolymorphicSerializer")
        .addModifiers(KModifier.INTERNAL)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", internalSerializationApiCN)
            .addMember("%T::class", experimentalSerializationApiCN)
            .build()
        )
        .superclass(abstractPolymorphicSerializerCN.parameterizedBy(resourceCN))
        .addProperty(baseClassProp)
        .addProperty(byNameProp)
        .addProperty(byClassProp)
        .addProperty(descriptorProp)
        .addFunction(findEncodeFn)
        .addFunction(findDecodeFn)
        .build()

    return FileSpec.builder(packageName, "ResourcePolymorphicSerializer")
      .addAnnotation(
        AnnotationSpec.builder(Suppress::class)
          .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
          .addMember("%S, %S", "INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
          .build()
      )
      .addType(objectSpec)
      .build()
  }
}
