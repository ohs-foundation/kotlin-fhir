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
import dev.ohs.fhir.codegen.serializer.WireField
import dev.ohs.fhir.codegen.serializer.buildJsonWireFields
import dev.ohs.fhir.codegen.serializer.buildListSerializerProperty
import dev.ohs.fhir.codegen.serializer.decodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.decoderClassName
import dev.ohs.fhir.codegen.serializer.encodeStructureMemberName
import dev.ohs.fhir.codegen.serializer.encoderClassName
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
      builder.addType(
        createModelSerializerTypeSpec(backboneClassName, elements, isResource = false)
      )
    }
    // Choice-type sealed interfaces (e.g. Patient.Deceased) get no per-class serializer:
    // the parent resource serializer fully inlines the per-expansion keys on encode/decode, so a
    // standalone KSerializer<Patient.Deceased> is never invoked.
    // Root model serializer.
    builder.addType(
      createModelSerializerTypeSpec(
        modelClassName,
        structureDefinition.rootElements,
        isResource = structureDefinition.kind == StructureDefinition.Kind.RESOURCE,
      )
    )
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
   * Resource types implement `FhirResourceSerializer<X>` so `FhirResourcePolymorphicSerializer` in
   * `ResourcePolymorphicSerializer` can reuse their descriptor and encode/decode bodies without
   * generating a separate `XPolymorphicSerializer` object per resource.
   */
  private fun createModelSerializerTypeSpec(
    className: ClassName,
    elements: List<Element>,
    isResource: Boolean,
  ): TypeSpec {
    val wireFields = codegenContext.buildJsonWireFields(className, elements)
    return createStreamingSerializerTypeSpec(
      className,
      className.toSerializerClassName(),
      elements,
      wireFields,
      includeResourceType = isResource,
    )
  }

  /** The streaming serializer object — does the actual `encodeStructure`/`decodeStructure` work. */
  private fun createStreamingSerializerTypeSpec(
    className: ClassName,
    serializerClassName: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    includeResourceType: Boolean,
  ): TypeSpec {
    val superinterface =
      if (includeResourceType) {
        ClassName(className.packageName, "FhirResourceSerializer").parameterizedBy(className)
      } else {
        KSerializer::class.asClassName().parameterizedBy(className)
      }
    val builder =
      TypeSpec.objectBuilder(serializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addSuperinterface(superinterface)
        .addProperty(
          descriptorEmitter.buildDescriptorProperty(className, wireFields, includeResourceType)
        )
    // Pre-allocate `ListSerializer(this)` on the provider serializer right after `descriptor`.
    // Because `ListSerializer(this)` only reads `this.descriptor` (already initialized above), it
    // cannot trigger cross-serializer `<clinit>` cycles and lets all consumers share a single
    // `XSerializer.listSerializer` instance without per-serializer `$Hoisted` holder classes.
    if (!includeResourceType) {
      builder.addProperty(buildListSerializerProperty(className))
      if (className.simpleNames == listOf("Element")) {
        builder.addProperty(buildListSerializerProperty(className, nullableElement = true))
      }
    }
    if (includeResourceType) {
      builder.addFunction(descriptorEmitter.buildBuildDescriptorFun(className, wireFields))
    }
    val functions =
      buildSerializerFunctions(
        className,
        elements,
        wireFields,
        includeResourceType,
      )
    functions.forEach { builder.addFunction(it) }
    return builder.build()
  }

  /**
   * Builds the serializer functions: `serializeInternal` / `deserializeInternal` plus (for
   * non-resource types) the public `serialize` / `deserialize` overrides. For resource types,
   * `serialize` / `deserialize` are inherited from `FhirResourceSerializer` and the internal bodies
   * override `FhirResourceSerializer` so `FhirResourcePolymorphicSerializer` can reuse them with a
   * different descriptor + offset.
   */
  private fun buildSerializerFunctions(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    includeResourceType: Boolean,
  ): List<FunSpec> {
    // For resources we share `serializeInternal`/`deserializeInternal` between `XSerializer`
    // (descriptor:
    // resourceType@0, wireFields@1..N) and `FhirResourcePolymorphicSerializer` (descriptor:
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
    // Non-resource serializers emit their own `deserialize` / `serialize` overrides. Resource
    // serializers inherit them from `FhirResourceSerializer` (compiled as Java 8 default methods
    // under `JvmDefaultMode.NO_COMPATIBILITY`).
    if (!parameterized) {
      functions +=
        FunSpec.builder("deserialize")
          .addModifiers(KModifier.OVERRIDE)
          .addParameter("decoder", decoderClassName)
          .returns(className)
          .addCode(
            CodeBlock.of(
              "return decoder.%M(descriptor) {\n  deserializeInternal(this)\n}\n",
              decodeStructureMemberName,
            )
          )
          .build()
      functions +=
        FunSpec.builder("serialize")
          .addModifiers(KModifier.OVERRIDE)
          .addParameter("encoder", encoderClassName)
          .addParameter("value", className)
          .addCode(
            CodeBlock.of(
              "encoder.%M(descriptor) {\n  serializeInternal(this, value)\n}\n",
              encodeStructureMemberName,
            )
          )
          .build()
    }
    functions +=
      decodeEmitter.buildDeserializeInternal(
        className,
        elements,
        wireFields,
        parameterized,
        nameToCaseLabel,
      )
    functions += encodeEmitter.buildSerializeInternal(className, elements, parameterized, nameToIdx)
    return functions
  }
}

/** Returns the [ClassName] for the generated serializer object. */
fun ClassName.toSerializerClassName(): ClassName =
  ClassName("${packageName}.serializers", simpleNames.joinToString("").plus("Serializer"))

private fun ClassName.toSerializerFileSpecBuilder(): FileSpec.Builder =
  FileSpec.builder("${packageName}.serializers", simpleName.plus("Serializers"))
    .addSuppressAnnotation()
    .addAnnotation(
      AnnotationSpec.builder(ClassName("kotlin", "OptIn"))
        .addMember("%T::class", ClassName("kotlinx.serialization", "ExperimentalSerializationApi"))
        .useSiteTarget(AnnotationSpec.UseSiteTarget.FILE)
        .build()
    )
