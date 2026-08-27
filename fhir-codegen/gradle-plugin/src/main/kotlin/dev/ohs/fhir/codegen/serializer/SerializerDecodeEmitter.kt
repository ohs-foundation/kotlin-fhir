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
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.CodegenContext
import dev.ohs.fhir.codegen.ModelConstructionHelpers
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.getElementName

/**
 * Emits the streaming-decode side of a serializer object — `deserializeInternal(decoder)` and the
 * supporting per-field decode-call helper. Walks the wire shape via
 * `CompositeDecoder.decodeElementIndex` and dispatches each slot to a specialized
 * `decodeXxxElement` (stdlib primitives) or `decodeNullableSerializableElement` (everything else).
 */
internal class SerializerDecodeEmitter(private val codegenContext: CodegenContext) {

  /**
   * Emits `private fun deserializeInternal(decoder: CompositeDecoder): X` — a while-loop over
   * `decodeElementIndex(descriptor)` with an index-dispatching `when`. Each case reads one flat
   * wire field via `decodeXxxElement` (specialized) or `decodeNullableSerializableElement` (for
   * complex/list/element types), then the loop terminates on `DECODE_DONE`.
   *
   * After the loop, sealed-type (choice) locals are synthesized from their expansion transients;
   * then the model is constructed from the assembled locals.
   */
  fun buildDeserializeInternal(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    parameterized: Boolean,
    nameToCaseLabel: Map<String, Int>,
    hoister: SerializerHoister,
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    // One local per flat wire field — choice types expand into per-expansion value + element
    // (`_field`) locals
    // (e.g. `deceasedBoolean`, `_deceasedBoolean`, `deceasedDateTime`, `_deceasedDateTime`).
    for (wireField in wireFields) {
      codeBlock.add(
        "var %N: %T = %L\n",
        wireField.name,
        wireField.typeName.copy(nullable = true),
        wireField.defaultValue ?: "null",
      )
    }

    if (parameterized) {
      // Rebased dispatch: `i - descriptorOffset` makes case labels constants (wire-field index,
      // 0-based)
      // regardless of whether the descriptor has `resourceType` at slot 0 (off=1) or not (off=0).
      // The `-1` branch fires only when off=1 and i=0 — i.e., the standalone path saw
      // `resourceType` as a real field; on the polymorphic path kotlinx-json's
      // `discriminatorHolder` consumes that key before we ever see slot 0, so the branch is dead
      // but harmless there.
      codeBlock.add("while (true) {\n").indent()
      codeBlock.add("val i = decoder.decodeElementIndex(descriptor)\n")
      codeBlock.add("if (i == %T.DECODE_DONE) break\n", compositeDecoderClassName)
      codeBlock.add("when (i - descriptorOffset) {\n").indent()
      codeBlock.add("-1 -> decoder.decodeStringElement(descriptor, i)\n")
      for (wireField in wireFields) {
        val label = nameToCaseLabel.getValue(wireField.name)
        codeBlock.add(
          "%L -> %N = %L\n",
          label,
          wireField.name,
          jsonDecodeElementCall(wireField, className, hoister),
        )
      }
      codeBlock.add(
        "else -> throw %T(%S + i)\n",
        ClassName("kotlinx.serialization", "SerializationException"),
        "Unexpected index decoding ${className.simpleName}: ",
      )
      codeBlock.unindent().add("}\n")
      codeBlock.unindent().add("}\n")
    } else {
      codeBlock.add("while (true) {\n").indent()
      codeBlock.add("when (val i = decoder.decodeElementIndex(descriptor)) {\n").indent()
      for (wireField in wireFields) {
        val label = nameToCaseLabel.getValue(wireField.name)
        codeBlock.add(
          "%L -> %N = %L\n",
          label,
          wireField.name,
          jsonDecodeElementCall(wireField, className, hoister),
        )
      }
      codeBlock.add("%T.DECODE_DONE -> break\n", compositeDecoderClassName)
      codeBlock.add(
        "else -> throw %T(%S + i)\n",
        ClassName("kotlinx.serialization", "SerializationException"),
        "Unexpected index decoding ${className.simpleName}: ",
      )
      codeBlock.unindent().add("}\n")
      codeBlock.unindent().add("}\n")
    }

    codeBlock.add("return ")
    codeBlock.add(emitModelConstruction(className, elements))
    val builder =
      FunSpec.builder("deserializeInternal")
        .addModifiers(if (parameterized) KModifier.INTERNAL else KModifier.PRIVATE)
        .addParameter("decoder", compositeDecoderClassName)
    if (parameterized) {
      builder.addParameter("descriptor", serialDescriptorClassName)
      builder.addParameter("descriptorOffset", Int::class)
    }
    return builder.returns(className).addCode(codeBlock.build()).build()
  }

  /**
   * Decode-one-element call for [wireField] against the descriptor index just returned by
   * `decodeElementIndex` (read from the local `i`). Specialized `decodeXxxElement` for stdlib
   * primitives, `decodeNullableSerializableElement` otherwise.
   */
  private fun jsonDecodeElementCall(
    wireField: WireField,
    parentClass: ClassName,
    hoister: SerializerHoister,
  ): CodeBlock {
    // The descriptor index always comes from `i` — the value just returned by
    // `decodeElementIndex`. Encoding it as a literal here (instead of `i`) would lock the
    // generated body to the descriptor whose slot indices match those literals; threading `i`
    // keeps the body correct whether it's called against `XSerializer.descriptor` (resourceType
    // at slot 0, wire fields shifted by 1) or `XPolymorphicSerializer.descriptor` (no shift).
    val nonNull = wireField.typeName.copy(nullable = false)
    if (nonNull is ClassName && nonNull.packageName == "kotlin") {
      when (nonNull.simpleName) {
        "String" -> return CodeBlock.of("decoder.decodeStringElement(descriptor, i)")
        "Boolean" -> return CodeBlock.of("decoder.decodeBooleanElement(descriptor, i)")
        "Int" -> return CodeBlock.of("decoder.decodeIntElement(descriptor, i)")
        "Long" -> return CodeBlock.of("decoder.decodeLongElement(descriptor, i)")
        "Double" -> return CodeBlock.of("decoder.decodeDoubleElement(descriptor, i)")
        "Char" -> return CodeBlock.of("decoder.decodeCharElement(descriptor, i)")
      }
    }
    val ser =
      serializerExpressionIn(wireField.typeName, parentClass, hoister, "${wireField.name}Ser")
    // Explicit `previousValue = null` — 4-arg form — so Kotlin emits a direct interface call
    // instead of the `decodeNullableSerializableElement$default` static synthetic bridge.
    return CodeBlock.of("decoder.decodeNullableSerializableElement(descriptor, i, %L, null)", ser)
  }

  /**
   * Serializer expression for [typeName] suitable for a decode call site.
   *
   * Every reference — bare `X.serializer()`, `ListSerializer(...)`, `.nullable` wrappers — goes
   * through the deferred hoister, landing on the nested `Hoisted` object. The call site compiles to
   * a single `getstatic Hoisted.$fooSer`; plugin-gen emits an equivalent `getstatic
   * childSerializers$lazy[i] + invokevirtual getValue()` shape. Nested-object init fires on first
   * access (not with the outer object's `<clinit>`), so self-referential types don't dereference a
   * still-initializing sibling's `descriptor` during construction.
   *
   * Custom FHIR serializers (`LocalTimeSerializer`, `BigDecimalSerializer`) are singletons —
   * already a single `getstatic`, no hoist needed.
   */
  private fun serializerExpressionIn(
    typeName: TypeName,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
  ): CodeBlock {
    val nonNull = typeName.copy(nullable = false)
    if (nonNull is ClassName) {
      customSerializerFor(nonNull, parentClass)?.let {
        return CodeBlock.of("%T", it)
      }
      return hoister.refLazy(serializerForClassName(nonNull), nameHint, nonNull)
    }
    if (nonNull is ParameterizedTypeName) {
      when (nonNull.rawType) {
        ClassName("kotlin.collections", "List"),
        ClassName("kotlin.collections", "MutableList") -> {
          val inner = nonNull.typeArguments.single()
          val innerSer = serializerExpressionIn(inner, parentClass, hoister, "${nameHint}Inner")
          val listExpr =
            if (inner.isNullable) {
              CodeBlock.of(
                "%M((%L).%M)",
                MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer"),
                innerSer,
                MemberName(KOTLINX_SERIALIZATION_BUILTINS, "nullable"),
              )
            } else {
              CodeBlock.of(
                "%M(%L)",
                MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer"),
                innerSer,
              )
            }
          return hoister.refLazy(listExpr, nameHint, nonNull)
        }
      }
    }
    return serializerForTypeName(typeName)
  }

  /** Builds the `return ModelType(...)` expression after the decode loop has populated locals. */
  private fun emitModelConstruction(className: ClassName, elements: List<Element>): CodeBlock {
    val helpers = ModelConstructionHelpers(codegenContext)
    val codeBlock = CodeBlock.builder()
    codeBlock.add("%T(\n", className)
    codeBlock.indent()
    elements.forEach { element ->
      codeBlock.add("%N = ", element.getElementName())
      with(helpers) {
        codeBlock.addParamToModelClassConstructor(
          className,
          element,
          expandPolymorphicProperties = true,
        )
      }
      codeBlock.add(",\n")
    }
    codeBlock.unindent().add(")\n")
    return codeBlock.build()
  }
}
