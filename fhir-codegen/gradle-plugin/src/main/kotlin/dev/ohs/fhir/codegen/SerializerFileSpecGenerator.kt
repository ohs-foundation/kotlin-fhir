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
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.backboneElements
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.serializer.SerializerDecodeEmitter
import dev.ohs.fhir.codegen.serializer.SerializerDescriptorEmitter
import dev.ohs.fhir.codegen.serializer.SerializerEncodeEmitter
import dev.ohs.fhir.codegen.serializer.SerializerHoister
import dev.ohs.fhir.codegen.serializer.WireField
import dev.ohs.fhir.codegen.serializer.buildClassSerialDescriptorMemberName
import dev.ohs.fhir.codegen.serializer.buildJsonWireFields
import dev.ohs.fhir.codegen.serializer.decodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.decoderClassName
import dev.ohs.fhir.codegen.serializer.encodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.encoderClassName
import dev.ohs.fhir.codegen.serializer.serialDescriptorClassName
import kotlinx.serialization.KSerializer

/** Generates a streaming `KSerializer<X>` per FHIR type over the flat wire shape. */
class SerializerFileSpecGenerator(val codegenContext: CodegenContext) {

  private val descriptorEmitter = SerializerDescriptorEmitter(codegenContext)
  private val encodeEmitter = SerializerEncodeEmitter(codegenContext)
  private val decodeEmitter = SerializerDecodeEmitter(codegenContext)

  fun generate(structureDefinition: StructureDefinition): FileSpec {
    val modelClassName = codegenContext.getModelClassName(structureDefinition)
    val builder = modelClassName.toSerializerFileSpecBuilder()
    // Backbone-element serializers.
    structureDefinition.backboneElements.forEach { (backboneElement, elements) ->
      val simpleNames = backboneElement.path.split('.').map { it.capitalized() }
      val backboneClassName = ClassName(modelClassName.packageName, simpleNames)
      createModelSerializerTypeSpecs(backboneClassName, elements, isResource = false).forEach {
        builder.addType(it)
      }
    }
    // Choice-type sealed interfaces (e.g. Patient.Deceased) get no per-class serializer:
    // the parent resource serializer fully inlines the per-expansion keys on encode/decode, so a
    // standalone KSerializer<Patient.Deceased> is never invoked.
    // Root model serializer.
    createModelSerializerTypeSpecs(
        modelClassName,
        structureDefinition.rootElements,
        isResource = structureDefinition.kind == StructureDefinition.Kind.RESOURCE,
        resourceTypeName = structureDefinition.name,
      )
      .forEach { builder.addType(it) }
    return builder.build()
  }

  /**
   * Emits one serializer object per model type (`XSerializer`). Streaming encode/decode over the
   * flat FHIR wire shape — one descriptor slot per JSON key on the wire, including per-expansion
   * expansions for `[x]` choice types (e.g. `deceasedBoolean` / `_deceasedBoolean` /
   * `deceasedDateTime` / `_deceasedDateTime`). Choice types are handled inline against the parent's
   * composite encoder: `emitChoiceTypeExpansionEncoding` writes the matched expansion's keys on
   * encode; decode reads them into per-expansion locals and synthesizes the sealed value via the
   * companion `from(…)` factory during `emitModelConstruction`.
   *
   * Resource types additionally get a thin `XPolymorphicSerializer` (`resourceType` omitted from
   * its descriptor) for use as a subclass entry in `ResourcePolymorphicSerializer`.
   */
  private fun createModelSerializerTypeSpecs(
    className: ClassName,
    elements: List<Element>,
    isResource: Boolean,
    resourceTypeName: String? = null,
  ): List<TypeSpec> {
    val wireFields = codegenContext.buildJsonWireFields(className, elements)
    return buildList {
      add(
        createStreamingSerializerTypeSpec(
          className,
          className.toSerializerClassName(),
          elements,
          wireFields,
          includeResourceType = isResource,
          resourceTypeName = resourceTypeName,
        )
      )
      if (isResource) {
        add(createPolymorphicSerializerTypeSpec(className))
      }
    }
  }

  /**
   * Thin `XPolymorphicSerializer` whose descriptor omits `resourceType`. Forwards `serialize` /
   * `deserialize` to `XSerializer`'s shared helpers; on the polymorphic path kotlinx-json's
   * `discriminatorHolder` consumes the `resourceType` key before
   * `XSerializer.deserializeInternal`'s slot-0 case ever fires.
   */
  private fun createPolymorphicSerializerTypeSpec(className: ClassName): TypeSpec {
    val xSerClassName = className.toSerializerClassName()
    val descriptorProp =
      PropertySpec.builder("descriptor", serialDescriptorClassName)
        .addModifiers(KModifier.OVERRIDE)
        .initializer(
          "%M(%S) { %T.buildDescriptor(this) }",
          buildClassSerialDescriptorMemberName,
          className.simpleName,
          xSerClassName,
        )
        .build()
    // Pass `descriptor` (XPolymorphicSerializer's own — wire fields at slots 0..N-1) and offset 0.
    // The shared body in `XSerializer.serializeInternal` / `deserializeInternal` reads its slot
    // indices as
    // `<wireIdx> + descriptorOffset`, so encode/decode use the same descriptor that
    // `encodeStructure` /
    // `decodeStructure` opened — required for tag-based formats (ProtoBuf) that resolve fields by
    // descriptor slot index, not by name.
    val serializeFn =
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoderClassName)
        .addParameter("value", className)
        .addCode(
          "encoder.%M(descriptor) {\n  %T.serializeInternal(this, descriptor, 0, value)\n}\n",
          encodeStructureMemberName,
          xSerClassName,
        )
        .build()
    val deserializeFn =
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderClassName)
        .returns(className)
        .addCode(
          "return decoder.%M(descriptor) {\n  %T.deserializeInternal(this, descriptor, 0)\n}\n",
          decodeStructureMemberName,
          xSerClassName,
        )
        .build()
    return TypeSpec.objectBuilder(className.toPolymorphicSerializerClassName())
      .addModifiers(KModifier.INTERNAL)
      .addSuperinterface(KSerializer::class.asClassName().parameterizedBy(className))
      .addProperty(descriptorProp)
      .addFunction(serializeFn)
      .addFunction(deserializeFn)
      .build()
  }

  /** The streaming serializer object — does the actual `encodeStructure`/`decodeStructure` work. */
  private fun createStreamingSerializerTypeSpec(
    className: ClassName,
    serializerClassName: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    includeResourceType: Boolean,
    resourceTypeName: String?,
  ): TypeSpec {
    val hoister = SerializerHoister()
    val builder =
      TypeSpec.objectBuilder(serializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addSuperinterface(KSerializer::class.asClassName().parameterizedBy(className))
        .addProperty(
          descriptorEmitter.buildDescriptorProperty(className, wireFields, includeResourceType)
        )
    if (includeResourceType) {
      builder.addFunction(descriptorEmitter.buildBuildDescriptorFun(className, wireFields))
    }
    val functions =
      buildSerializerFunctions(
        className,
        elements,
        wireFields,
        includeResourceType,
        resourceTypeName,
        hoister,
      )
    hoister.eagerPropertyDefinitions().forEach { builder.addProperty(it) }
    functions.forEach { builder.addFunction(it) }
    hoister.deferredObjectTypeSpec()?.let { builder.addType(it) }
    return builder.build()
  }

  /**
   * Builds the four serializer functions: the public `serialize` / `deserialize` overrides plus the
   * private `serializeInternal` / `deserializeInternal` bodies they delegate to. For resource types
   * the internal bodies are `internal` (not `private`) so `XPolymorphicSerializer` can reuse them
   * with a different descriptor + offset.
   */
  private fun buildSerializerFunctions(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    includeResourceType: Boolean,
    resourceTypeName: String?,
    hoister: SerializerHoister,
  ): List<FunSpec> {
    // For resources we share `serializeInternal`/`deserializeInternal` between `XSerializer`
    // (descriptor:
    // resourceType@0, wireFields@1..N) and `XPolymorphicSerializer` (descriptor:
    // wireFields@0..N-1).
    // The body takes the descriptor + a wire-field offset (`descriptorOffset`) at runtime; encode
    // emits
    // `<wireIdx> + descriptorOffset` for the descriptor index, decode rebases the dispatch via
    // `when (i - descriptorOffset)` so case labels stay constant. Non-resource types keep the
    // simple
    // unparameterized form.
    val parameterized = includeResourceType
    // Case labels in the decode `when` — always wire-field index (0-based). For non-resources
    // this also equals the absolute descriptor slot since there's no `resourceType` prefix.
    val nameToCaseLabel =
      wireFields.withIndex().associate { (index, wireField) -> wireField.name to index }
    // Encode-side index expression: literal `<wireIdx>` for non-resources, `<wireIdx> +
    // descriptorOffset`
    // for resources. Substituted into emit calls via `%L`.
    val nameToIdx: Map<String, CodeBlock> = nameToCaseLabel.mapValues { (_, i) ->
      if (parameterized) CodeBlock.of("%L + descriptorOffset", i) else CodeBlock.of("%L", i)
    }
    val functions = mutableListOf<FunSpec>()
    // `deserialize(decoder)` streams via `decodeStructure { deserializeInternal(this) }`. The same
    // body
    // services both `StreamingJsonDecoder` and `JsonTreeDecoder` because every read inside the
    // `deserializeInternal` loop goes through the `CompositeDecoder` interface
    // (`decodeElementIndex`,
    // `decodeXxxElement`, `decodeSerializableElement`) — kotlinx picks the decoder, we walk it.
    val deserializeBody =
      if (parameterized) {
        // Pass `descriptor` (XSerializer's, with resourceType@0) and offset 1 so the body's
        // wire-field cases land at slots 1..N.
        CodeBlock.of(
          "return decoder.%M(descriptor) {\n  deserializeInternal(this, descriptor, 1)\n}\n",
          decodeStructureMemberName,
        )
      } else {
        CodeBlock.of(
          "return decoder.%M(descriptor) {\n  deserializeInternal(this)\n}\n",
          decodeStructureMemberName,
        )
      }
    functions +=
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderClassName)
        .returns(className)
        .addCode(deserializeBody)
        .build()
    val serializeBody =
      if (parameterized && resourceTypeName != null) {
        // Outer wrapper writes `resourceType` at slot 0; the body — same one
        // `XPolymorphicSerializer` reuses with offset 0 — handles every other field.
        CodeBlock.of(
          "encoder.%M(descriptor) {\n  encodeStringElement(descriptor, 0, %S)\n" +
            "  serializeInternal(this, descriptor, 1, value)\n}\n",
          encodeStructureMemberName,
          resourceTypeName,
        )
      } else {
        CodeBlock.of(
          "encoder.%M(descriptor) {\n  serializeInternal(this, value)\n}\n",
          encodeStructureMemberName,
        )
      }
    functions +=
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoderClassName)
        .addParameter("value", className)
        .addCode(serializeBody)
        .build()
    functions +=
      decodeEmitter.buildDeserializeInternal(
        className,
        elements,
        wireFields,
        parameterized,
        nameToCaseLabel,
        hoister,
      )
    functions +=
      encodeEmitter.buildSerializeInternal(className, elements, parameterized, nameToIdx, hoister)
    return functions
  }
}

/** Returns the [ClassName] for the generated serializer object. */
fun ClassName.toSerializerClassName(): ClassName =
  ClassName("${packageName}.serializers", simpleNames.joinToString("").plus("Serializer"))

/**
 * Returns the [ClassName] for the polymorphic-variant serializer object (resource types only).
 * Descriptor omits `resourceType`; used as a subclass entry in `ResourcePolymorphicSerializer`,
 * where kotlinx-json injects the discriminator itself.
 */
fun ClassName.toPolymorphicSerializerClassName(): ClassName =
  ClassName(
    "${packageName}.serializers",
    simpleNames.joinToString("").plus("PolymorphicSerializer"),
  )

private fun ClassName.toSerializerFileSpecBuilder(): FileSpec.Builder =
  FileSpec.builder("${packageName}.serializers", simpleName.plus("Serializers"))
    .addSuppressAnnotation()
    .addAnnotation(
      AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
        .addMember("%T::class", ClassName("kotlinx.serialization", "ExperimentalSerializationApi"))
        .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
        .build()
    )
