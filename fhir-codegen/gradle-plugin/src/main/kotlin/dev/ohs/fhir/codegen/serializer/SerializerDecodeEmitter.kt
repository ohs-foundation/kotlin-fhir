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

package dev.ohs.fhir.codegen.serializer

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.CodegenContext
import dev.ohs.fhir.codegen.ModelConstructionHelpers
import dev.ohs.fhir.codegen.getEnumClass
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.isExtensibleBinding
import dev.ohs.fhir.codegen.schema.typeShouldBindToEnum

/** Emits the decode half of a generated serializer; see [buildDeserializeInternal]. */
internal class SerializerDecodeEmitter(private val codegenContext: CodegenContext) {

  /**
   * Emits `deserialize(decoder)` (non-resources) or `deserializeInternal(compositeDecoder,
   * descriptor)` (resources, shared with `FhirResourcePolymorphicSerializer`) — a while-loop over
   * `decodeElementIndex(descriptor)` with an index-dispatching `when`. Each case reads one flat
   * wire field via `decodeXxxElement` (specialized) or `decodeNullableSerializableElement` (for
   * complex/list/element types), converting single primitive values to their model type right there
   * (`FhirDate.fromString(...)`, `XEnum.fromCode(...)`) so the locals are already model-typed; the
   * loop terminates on `DECODE_DONE`.
   *
   * After the loop, repeating primitives are merged into locals, then the model is constructed from
   * the assembled locals with a branch-free argument list (see [ModelConstructionHelpers]).
   */
  fun buildDeserializeInternal(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    isResource: Boolean,
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    if (!isResource) {
      // Local copy: every `descriptor` read below becomes a local load instead of a getter call.
      codeBlock.add("val descriptor = this.descriptor\n")
      codeBlock.add("val compositeDecoder = decoder.beginStructure(descriptor)\n")
    }
    // One local per flat wire field — choice types expand into per-expansion value + element
    // (`_field`) locals (e.g. `deceasedBoolean`, `_deceasedBoolean`, `deceasedDateTime`, …).
    for (wireField in wireFields) {
      codeBlock.add(
        "var %N: %T = %L\n",
        wireField.name,
        localType(wireField, className).copy(nullable = true),
        wireField.defaultValue ?: "null",
      )
    }
    codeBlock.add("while (true) {\n").indent()
    if (isResource) {
      // Standalone resource descriptors carry `resourceType` at slot 0 (`descriptorOffset` = 1);
      // the polymorphic wrapper's descriptor has no such slot (`descriptorOffset` = 0) because
      // kotlinx-json consumes the discriminator key itself. `DECODE_DONE` must be tested before
      // the subtraction, since `-1 - 0` would collide with the `resourceType` case.
      codeBlock.add("val i = compositeDecoder.decodeElementIndex(descriptor)\n")
      codeBlock.add("if (i == %T.DECODE_DONE) break\n", compositeDecoderClassName)
      codeBlock.add("when (i - descriptorOffset) {\n").indent()
      codeBlock.add("-1 -> compositeDecoder.decodeStringElement(descriptor, i)\n")
    } else {
      codeBlock.add("when (val i = compositeDecoder.decodeElementIndex(descriptor)) {\n").indent()
    }
    wireFields.forEachIndexed { index, wireField ->
      codeBlock.add(
        "%L -> %N = %L\n",
        index,
        wireField.name,
        decodeElementCall(wireField, className),
      )
    }
    if (!isResource) {
      codeBlock.add("%T.DECODE_DONE -> break\n", compositeDecoderClassName)
    }
    codeBlock.add("else -> %M(descriptor, i)\n", helperMemberName(className, "unknownIndex"))
    codeBlock.unindent().add("}\n")
    codeBlock.unindent().add("}\n")
    if (!isResource) {
      codeBlock.add("compositeDecoder.endStructure(descriptor)\n")
    }
    codeBlock.add(emitModelConstruction(className, elements))
    return if (isResource) {
      FunSpec.builder("deserializeInternal")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("compositeDecoder", compositeDecoderClassName)
        .addParameter("descriptor", serialDescriptorClassName)
        .addParameter("descriptorOffset", Int::class)
        .returns(className)
        .addCode(codeBlock.build())
        .build()
    } else {
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderClassName)
        .returns(className)
        .addCode(codeBlock.build())
        .build()
    }
  }

  /**
   * Enum class for a single-type primitive slot bound to a required (non-extensible) value set —
   * such slots are decoded straight into the enum via `fromCode`. Null otherwise.
   */
  private fun enumClassFor(wireField: WireField, parentClass: ClassName): ClassName? {
    val element = wireField.element
    if (wireField.isElementField || wireField.isList || wireField.fhirTypeCode == null) return null
    if (element.type?.size != 1) return null
    if (!element.typeShouldBindToEnum(codegenContext.valueSetMap) || element.isExtensibleBinding) {
      return null
    }
    return element.getEnumClass(parentClass, codegenContext.valueSetMap)
  }

  /**
   * Type of the per-field local: the model-side value type for single primitive values (`FhirDate`
   * for `date`, the enum for a required binding, `Long` for `integer64`), the wire type otherwise.
   */
  private fun localType(wireField: WireField, parentClass: ClassName): TypeName {
    enumClassFor(wireField, parentClass)?.let {
      return it
    }
    val fhirTypeCode = wireField.fhirTypeCode
    if (wireField.isElementField || wireField.isList || fhirTypeCode == null)
      return wireField.typeName
    return FhirPathType.getFromFhirTypeCode(fhirTypeCode)!!.getDataModelType(
      parentClass.packageName
    )
  }

  /**
   * Decode-one-element call for [wireField] against the descriptor index just returned by
   * `decodeElementIndex` (read from the local `i`). Specialized `decodeXxxElement` for stdlib
   * primitives, `decodeNullableSerializableElement` otherwise, wrapped in the wire→model conversion
   * for single primitive values.
   */
  private fun decodeElementCall(wireField: WireField, parentClass: ClassName): CodeBlock {
    val wireCall = wireDecodeCall(wireField, parentClass)
    enumClassFor(wireField, parentClass)?.let {
      return CodeBlock.of("%T.fromCode(%L)", it, wireCall)
    }
    val fhirTypeCode = wireField.fhirTypeCode
    if (wireField.isElementField || wireField.isList || fhirTypeCode == null) return wireCall
    val builder = CodeBlock.builder()
    FhirPathType.getFromFhirTypeCode(fhirTypeCode)!!.addCodeToDecodeWireElementToModel(
      builder,
      parentClass.packageName,
      wireCall,
    )
    return builder.build()
  }

  private fun wireDecodeCall(wireField: WireField, parentClass: ClassName): CodeBlock {
    // The descriptor index always comes from `i` — the value just returned by
    // `decodeElementIndex` — so the same body works against both the standalone resource
    // descriptor and `FhirResourcePolymorphicSerializer`'s (which share wire-field indices).
    val nonNull = wireField.typeName.copy(nullable = false)
    if (nonNull is ClassName && nonNull.packageName == "kotlin") {
      when (nonNull.simpleName) {
        "String" -> return CodeBlock.of("compositeDecoder.decodeStringElement(descriptor, i)")
        "Boolean" -> return CodeBlock.of("compositeDecoder.decodeBooleanElement(descriptor, i)")
        "Int" -> return CodeBlock.of("compositeDecoder.decodeIntElement(descriptor, i)")
        "Long" -> return CodeBlock.of("compositeDecoder.decodeLongElement(descriptor, i)")
        "Double" -> return CodeBlock.of("compositeDecoder.decodeDoubleElement(descriptor, i)")
        "Char" -> return CodeBlock.of("compositeDecoder.decodeCharElement(descriptor, i)")
      }
    }
    val ser = serializerRefForTypeName(wireField.typeName, parentClass)
    // Explicit `previousValue = null` — 4-arg form — so Kotlin emits a direct interface call
    // instead of the `decodeNullableSerializableElement$default` static synthetic bridge.
    return CodeBlock.of(
      "compositeDecoder.decodeNullableSerializableElement(descriptor, i, %L, null)",
      ser,
    )
  }

  /**
   * Builds the merged-list locals and the `return ModelType(...)` expression after the decode loop
   * has populated locals.
   */
  private fun emitModelConstruction(className: ClassName, elements: List<Element>): CodeBlock {
    val helpers = ModelConstructionHelpers(codegenContext)
    val preamble = CodeBlock.builder()
    val codeBlock = CodeBlock.builder()
    codeBlock.add("return %T(\n", className)
    codeBlock.indent()
    elements.forEach { element ->
      codeBlock.add("%N = ", element.getElementName())
      with(helpers) {
        codeBlock.addParamToModelClassConstructor(
          className,
          element,
          expandPolymorphicProperties = true,
          preamble = preamble,
        )
      }
      codeBlock.add(",\n")
    }
    codeBlock.unindent().add(")\n")
    return preamble.add(codeBlock.build()).build()
  }
}
