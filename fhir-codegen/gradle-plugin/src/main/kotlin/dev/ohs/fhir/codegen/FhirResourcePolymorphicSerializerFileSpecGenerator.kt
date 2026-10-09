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
import com.squareup.kotlinpoet.TypeVariableName
import com.squareup.kotlinpoet.WildcardTypeName
import dev.ohs.fhir.codegen.serializer.buildClassSerialDescriptorMemberName
import dev.ohs.fhir.codegen.serializer.buildListSerializerProperty
import dev.ohs.fhir.codegen.serializer.compositeDecoderClassName
import dev.ohs.fhir.codegen.serializer.decodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.decoderClassName
import dev.ohs.fhir.codegen.serializer.encodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.encoderClassName
import dev.ohs.fhir.codegen.serializer.serialDescriptorClassName

/**
 * Emits `ResourcePolymorphicSerializer.kt`, containing:
 * - `FhirResourceSerializer<T : Resource>`: interface implemented by each concrete resource's
 *   `XSerializer` exposing its shared descriptor builder, the `serializeInternal` /
 *   `deserializeInternal` bodies (which take the descriptor to use plus a `descriptorOffset`), and
 *   default standalone `serialize` / `deserialize` implementations. The standalone descriptor
 *   carries `resourceType` at slot 0 (offset 1); the polymorphic wrapper's has no such slot (offset
 *   0).
 * - `FhirResourcePolymorphicSerializer<T : Resource>`: a single wrapper `KSerializer<T>` whose
 *   descriptor has no `resourceType` slot (used as the subclass serializer in
 *   `ResourcePolymorphicSerializer` instead of generating 150+ per-resource polymorphic serializer
 *   objects).
 * - `ResourcePolymorphicSerializer`: an `AbstractPolymorphicSerializer<Resource>` with name/class
 *   dispatch maps and a manually-built descriptor.
 */
object FhirResourcePolymorphicSerializerFileSpecGenerator {
  fun generate(packageName: String, subclasses: List<ClassName>): FileSpec {
    val sorted = subclasses.sorted()
    val serializersPackage = "$packageName.serializers"
    val resourceClassName = ClassName(packageName, "Resource")
    val fhirResourceSerializerClassName = ClassName(packageName, "FhirResourceSerializer")
    val polymorphicResourceSerializerClassName =
      ClassName(packageName, "FhirResourcePolymorphicSerializer")

    val abstractPolymorphicSerializerClassName =
      ClassName("kotlinx.serialization.internal", "AbstractPolymorphicSerializer")
    val internalSerializationApiClassName =
      ClassName("kotlinx.serialization", "InternalSerializationApi")
    val experimentalSerializationApiClassName =
      ClassName("kotlinx.serialization", "ExperimentalSerializationApi")
    val kSerializerClassName = ClassName("kotlinx.serialization", "KSerializer")
    val deserializationStrategyClassName =
      ClassName("kotlinx.serialization", "DeserializationStrategy")
    val serializationStrategyClassName = ClassName("kotlinx.serialization", "SerializationStrategy")
    val polymorphicKindClassName = ClassName("kotlinx.serialization.descriptors", "PolymorphicKind")
    val serialKindClassName = ClassName("kotlinx.serialization.descriptors", "SerialKind")
    val buildSerialDescriptorMemberName =
      MemberName("kotlinx.serialization.descriptors", "buildSerialDescriptor")
    val builtinsSerializerMemberName = MemberName("kotlinx.serialization.builtins", "serializer")
    val compositeEncoderClassName = ClassName("kotlinx.serialization.encoding", "CompositeEncoder")
    val kClassClassName = ClassName("kotlin.reflect", "KClass")
    val mapClassName = ClassName("kotlin.collections", "Map")
    val mapOfMemberName = MemberName("kotlin.collections", "mapOf")
    val associateByMemberName = MemberName("kotlin.collections", "associateBy")
    val jsonClassDiscriminatorClassName =
      ClassName("kotlinx.serialization.json", "JsonClassDiscriminator")
    val stringClassName = ClassName("kotlin", "String")

    val typeVarT = TypeVariableName("T", resourceClassName)

    // `resourceType` is slot 0 of the standalone descriptor so that, for formats that key on
    // descriptor position (ProtoBuf field numbers), the discriminator is always field 1 whatever
    // the resource. The shared `serializeInternal` / `deserializeInternal` bodies therefore take a
    // `descriptorOffset`: 1 here, 0 in `FhirResourcePolymorphicSerializer` whose descriptor has no
    // such slot.
    val fhirResourceSerializerSpec =
      TypeSpec.interfaceBuilder(fhirResourceSerializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addTypeVariable(typeVarT)
        .addSuperinterface(
          ClassName(serializersPackage, "FhirSerializer").parameterizedBy(typeVarT)
        )
        .addFunction(
          FunSpec.builder("buildResourceDescriptor")
            .addParameter("serialName", stringClassName)
            .returns(serialDescriptorClassName)
            .addCode(
              "return %M(serialName) {\n" +
                "  element(%S, %M, isOptional = false)\n" +
                "  buildDescriptor(this)\n" +
                "}\n",
              buildClassSerialDescriptorMemberName,
              "resourceType",
              MemberName(serializersPackage, "stringDescriptor"),
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("deserializeInternal")
            .addModifiers(KModifier.ABSTRACT)
            .addParameter("compositeDecoder", compositeDecoderClassName)
            .addParameter("descriptor", serialDescriptorClassName)
            .addParameter("descriptorOffset", Int::class)
            .returns(typeVarT)
            .build()
        )
        .addFunction(
          FunSpec.builder("serializeInternal")
            .addModifiers(KModifier.ABSTRACT)
            .addParameter("compositeEncoder", compositeEncoderClassName)
            .addParameter("descriptor", serialDescriptorClassName)
            .addParameter("descriptorOffset", Int::class)
            .addParameter("value", typeVarT)
            .build()
        )
        .addFunction(
          FunSpec.builder("deserialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("decoder", decoderClassName)
            .returns(typeVarT)
            .addCode(
              "return decoder.%M(descriptor) {\n  deserializeInternal(this, descriptor, 1)\n}\n",
              decodeStructureMemberName,
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("serialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("encoder", encoderClassName)
            .addParameter("value", typeVarT)
            .addCode(
              "encoder.%M(descriptor) {\n" +
                "  encodeStringElement(descriptor, 0, descriptor.serialName)\n" +
                "  serializeInternal(this, descriptor, 1, value)\n" +
                "}\n",
              encodeStructureMemberName,
            )
            .build()
        )
        .build()

    val delegateParamType = fhirResourceSerializerClassName.parameterizedBy(typeVarT)
    val polymorphicResourceSerializerSpec =
      TypeSpec.classBuilder(polymorphicResourceSerializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addTypeVariable(typeVarT)
        .addSuperinterface(kSerializerClassName.parameterizedBy(typeVarT))
        .primaryConstructor(
          FunSpec.constructorBuilder().addParameter("delegate", delegateParamType).build()
        )
        .addProperty(
          PropertySpec.builder("delegate", delegateParamType, KModifier.PRIVATE)
            .initializer("delegate")
            .build()
        )
        .addProperty(
          PropertySpec.builder("descriptor", serialDescriptorClassName, KModifier.OVERRIDE)
            .initializer(
              "%M(delegate.descriptor.serialName) { delegate.buildDescriptor(this) }",
              buildClassSerialDescriptorMemberName,
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("serialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("encoder", encoderClassName)
            .addParameter("value", typeVarT)
            .addCode(
              "encoder.%M(descriptor) {\n  delegate.serializeInternal(this, descriptor, 0, value)\n}\n",
              encodeStructureMemberName,
            )
            .build()
        )
        .addFunction(
          FunSpec.builder("deserialize")
            .addModifiers(KModifier.OVERRIDE)
            .addParameter("decoder", decoderClassName)
            .returns(typeVarT)
            .addCode(
              "return decoder.%M(descriptor) {\n  delegate.deserializeInternal(this, descriptor, 0)\n}\n",
              decodeStructureMemberName,
            )
            .build()
        )
        .build()

    val kSerializerOutResourceTN =
      kSerializerClassName.parameterizedBy(WildcardTypeName.producerOf(resourceClassName))

    val baseClassProp =
      PropertySpec.builder("baseClass", kClassClassName.parameterizedBy(resourceClassName))
        .addModifiers(KModifier.OVERRIDE)
        .initializer("%T::class", resourceClassName)
        .build()

    val byClassInit =
      CodeBlock.builder()
        .apply {
          add("%M(\n", mapOfMemberName)
          indent()
          for (sc in sorted) {
            val concreteClassName = ClassName(packageName, sc.simpleName)
            val serClassName = ClassName(serializersPackage, "${sc.simpleName}Serializer")
            add(
              "%T::class to %T(%T),\n",
              concreteClassName,
              polymorphicResourceSerializerClassName,
              serClassName,
            )
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

    val byNameProp =
      PropertySpec.builder(
          "byName",
          mapClassName.parameterizedBy(stringClassName, kSerializerOutResourceTN),
        )
        .addModifiers(KModifier.PRIVATE)
        .initializer("byClass.values.%M { it.descriptor.serialName }", associateByMemberName)
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
        .addProperty(byClassProp)
        .addProperty(byNameProp)
        .addProperty(descriptorProp)
        .addProperty(buildListSerializerProperty(resourceClassName))
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
      .addType(fhirResourceSerializerSpec)
      .addType(polymorphicResourceSerializerSpec)
      .addType(objectSpec)
      .build()
  }
}
