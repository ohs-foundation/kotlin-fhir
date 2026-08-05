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
    val resourceClassName = ClassName(packageName, "Resource")

    val abstractPolymorphicSerializerClassName =
      ClassName("kotlinx.serialization.internal", "AbstractPolymorphicSerializer")
    val internalSerializationApiClassName =
      ClassName("kotlinx.serialization", "InternalSerializationApi")
    val experimentalSerializationApiClassName =
      ClassName("kotlinx.serialization", "ExperimentalSerializationApi")
    val deserializationStrategyClassName =
      ClassName("kotlinx.serialization", "DeserializationStrategy")
    val serializationStrategyClassName = ClassName("kotlinx.serialization", "SerializationStrategy")
    val serialDescriptorClassName =
      ClassName("kotlinx.serialization.descriptors", "SerialDescriptor")
    val polymorphicKindClassName = ClassName("kotlinx.serialization.descriptors", "PolymorphicKind")
    val serialKindClassName = ClassName("kotlinx.serialization.descriptors", "SerialKind")
    val buildSerialDescriptorMemberName =
      MemberName("kotlinx.serialization.descriptors", "buildSerialDescriptor")
    val builtinsSerializerMemberName = MemberName("kotlinx.serialization.builtins", "serializer")
    val compositeDecoderClassName = ClassName("kotlinx.serialization.encoding", "CompositeDecoder")
    val encoderClassName = ClassName("kotlinx.serialization.encoding", "Encoder")
    val kClassClassName = ClassName("kotlin.reflect", "KClass")
    val mapClassName = ClassName("kotlin.collections", "Map")
    val mapOfMemberName = MemberName("kotlin.collections", "mapOf")
    val jsonClassDiscriminatorClassName =
      ClassName("kotlinx.serialization.json", "JsonClassDiscriminator")
    val stringClassName = ClassName("kotlin", "String")

    val kSerializerOutResourceTN =
      ClassName("kotlinx.serialization", "KSerializer")
        .parameterizedBy(WildcardTypeName.producerOf(resourceClassName))

    val baseClassProp =
      PropertySpec.builder("baseClass", kClassClassName.parameterizedBy(resourceClassName))
        .addModifiers(KModifier.OVERRIDE)
        .initializer("%T::class", resourceClassName)
        .build()

    val byNameInit =
      CodeBlock.builder()
        .apply {
          add("%M(\n", mapOfMemberName)
          indent()
          for (sc in sorted) {
            val polySerClassName =
              ClassName(serializersPackage, "${sc.simpleName}PolymorphicSerializer")
            add("%S to %T,\n", sc.simpleName, polySerClassName)
          }
          unindent()
          add(")")
        }
        .build()
    val byNameProp =
      PropertySpec.builder(
          "byName",
          mapClassName.parameterizedBy(stringClassName, kSerializerOutResourceTN),
        )
        .addModifiers(KModifier.PRIVATE)
        .initializer(byNameInit)
        .build()

    val byClassInit =
      CodeBlock.builder()
        .apply {
          add("%M(\n", mapOfMemberName)
          indent()
          for (sc in sorted) {
            val concreteClassName = ClassName(packageName, sc.simpleName)
            val polySerClassName =
              ClassName(serializersPackage, "${sc.simpleName}PolymorphicSerializer")
            add("%T::class to %T,\n", concreteClassName, polySerClassName)
          }
          unindent()
          add(")")
        }
        .build()
    val byClassProp =
      PropertySpec.builder(
          "byClass",
          mapClassName.parameterizedBy(
            kClassClassName.parameterizedBy(STAR),
            kSerializerOutResourceTN,
          ),
        )
        .addModifiers(KModifier.PRIVATE)
        .initializer(byClassInit)
        .build()

    // Mirrors `SealedClassSerializer.descriptor`'s `type`/`value` pair shape; the
    // `JsonClassDiscriminator` is what `Polymorphic.kt:97` reads to get `"resourceType"`.
    val descriptorInit =
      CodeBlock.builder()
        .apply {
          add(
            "%M(%S, %T.SEALED) {\n",
            buildSerialDescriptorMemberName,
            "Resource",
            polymorphicKindClassName,
          )
          indent()
          add("// `SealedClassSerializer` convention: slot 0 is named \"type\" even when\n")
          add("// `@JsonClassDiscriminator` overrides the wire key — kotlinx-json reads the\n")
          add("// actual key from `descriptor.annotations`, not from this slot's name.\n")
          add(
            "element(%S, %T.%M().descriptor)\n",
            "type",
            stringClassName,
            builtinsSerializerMemberName,
          )
          add(
            "val valueDesc = %M(%S, %T.CONTEXTUAL) {\n",
            buildSerialDescriptorMemberName,
            "kotlinx.serialization.Sealed<Resource>",
            serialKindClassName,
          )
          indent()
          add("for ((name, ser) in byName) element(name, ser.descriptor)\n")
          unindent()
          add("}\n")
          add("element(%S, valueDesc)\n", "value")
          add("annotations = listOf(%T(%S))\n", jsonClassDiscriminatorClassName, "resourceType")
          unindent()
          add("}")
        }
        .build()
    val descriptorProp =
      PropertySpec.builder("descriptor", serialDescriptorClassName)
        .addModifiers(KModifier.OVERRIDE)
        .initializer(descriptorInit)
        .build()

    val findEncodeFn =
      FunSpec.builder("findPolymorphicSerializerOrNull")
        .addModifiers(KModifier.OVERRIDE)
        .addAnnotation(
          AnnotationSpec.builder(Suppress::class).addMember("%S", "UNCHECKED_CAST").build()
        )
        .addParameter("encoder", encoderClassName)
        .addParameter("value", resourceClassName)
        .returns(
          serializationStrategyClassName.parameterizedBy(resourceClassName).copy(nullable = true)
        )
        // `byClass[…]` returns `KSerializer<out Resource>?`; the override needs the invariant
        // `SerializationStrategy<Resource>?`. We've already looked up by `value::class`, so the
        // cast is sound.
        .addCode(
          "return (byClass[value::class] ?: super.findPolymorphicSerializerOrNull(encoder, value))" +
            " as %T?\n",
          serializationStrategyClassName.parameterizedBy(resourceClassName),
        )
        .build()

    val findDecodeFn =
      FunSpec.builder("findPolymorphicSerializerOrNull")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", compositeDecoderClassName)
        .addParameter("klassName", stringClassName.copy(nullable = true))
        .returns(
          deserializationStrategyClassName.parameterizedBy(resourceClassName).copy(nullable = true)
        )
        .addCode(
          "return byName[klassName] ?: super.findPolymorphicSerializerOrNull(decoder, klassName)\n"
        )
        .build()

    val objectSpec =
      TypeSpec.objectBuilder("ResourcePolymorphicSerializer")
        .addModifiers(KModifier.INTERNAL)
        .addAnnotation(
          AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
            .addMember("%T::class", internalSerializationApiClassName)
            .addMember("%T::class", experimentalSerializationApiClassName)
            .build()
        )
        .superclass(abstractPolymorphicSerializerClassName.parameterizedBy(resourceClassName))
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
          .addMember("%S", "INVISIBLE_MEMBER")
          .addMember("%S", "INVISIBLE_REFERENCE")
          .build()
      )
      .addType(objectSpec)
      .build()
  }
}
