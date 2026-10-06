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
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.CodegenContext

/**
 * Builds the `descriptor` property and the shared `buildDescriptor` helper for a streaming
 * serializer. The descriptor mirrors the flat FHIR JSON wire shape — one element per JSON key,
 * including `_field` Element pairs and choice-type expansions. Cross-type descriptor cycles are
 * broken via `lazyDescriptor { ... }` where [TypeGraphAnalyzer] flags an edge as cyclic.
 */
internal class SerializerDescriptorEmitter(private val codegenContext: CodegenContext) {

  /**
   * Emits `override val descriptor` as a flat `buildClassSerialDescriptor(name) { element(...) ...
   * }` reflecting the actual JSON wire shape (one element per JSON key, including `_field` Element
   * pairs and choice type expansions). For resource types, `resourceType` is descriptor[0].
   *
   * Every element is marked `isOptional = true` — FHIR JSON omits absent keys, and streaming
   * encoders skip optional elements when we don't call `encodeXxxElement`, so this matches the wire
   * shape cleanly.
   *
   * Plain `val`, not `by lazy` — the streaming encoder/decoder reads `descriptor.getElementIndex` /
   * `getElementName` on every field, so deferring construction would move cost to first use rather
   * than eliminate it. Cross-type descriptor cycles are broken at the element level via
   * `lazyDescriptor { … }` where [TypeGraphAnalyzer] flags an edge as cyclic.
   */
  fun buildDescriptorProperty(
    className: ClassName,
    wireFields: List<WireField>,
    includeResourceType: Boolean,
  ): PropertySpec {
    val body =
      if (includeResourceType) {
        // Delegate to `FhirResourceSerializer.buildResourceDescriptor` (which adds slot-0
        // `resourceType` and calls `buildDescriptor(this)`) to avoid emitting a per-resource
        // `buildClassSerialDescriptor` lambda on every resource serializer class.
        CodeBlock.of("buildResourceDescriptor(%S)", className.simpleName)
      } else {
        val optionalElement = optionalElementMemberName(className)
        val builder = CodeBlock.builder()
        builder.add("%M(%S) {\n", buildClassSerialDescriptorMemberName, className.simpleName)
        builder.indent()
        for (wireField in wireFields) {
          builder.add(
            "%M(%S, %L)\n",
            optionalElement,
            wireField.name,
            descriptorFor(wireField.typeName, className),
          )
        }
        builder.unindent()
        builder.add("}\n")
        builder.build()
      }
    return PropertySpec.builder("descriptor", serialDescriptorClassName)
      .addModifiers(KModifier.OVERRIDE)
      .initializer(body)
      .build()
  }

  /** `override fun buildDescriptor(b)` — wire-field elements only, shared between both variants. */
  fun buildBuildDescriptorFun(className: ClassName, wireFields: List<WireField>): FunSpec {
    val optionalElement = optionalElementMemberName(className)
    val classSerialDescriptorBuilderClassName =
      ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "ClassSerialDescriptorBuilder")
    val codeBlock = CodeBlock.builder()
    for (wireField in wireFields) {
      codeBlock.add(
        "b.%M(%S, %L)\n",
        optionalElement,
        wireField.name,
        descriptorFor(wireField.typeName, className),
      )
    }
    return FunSpec.builder("buildDescriptor")
      .addModifiers(KModifier.OVERRIDE)
      .addParameter("b", classSerialDescriptorBuilderClassName)
      .addCode(codeBlock.build())
      .build()
  }

  /**
   * Descriptor expression for a wire-field. For non-cyclic cross-type references we emit the
   * child's real descriptor directly (`XSerializer.descriptor` /
   * `XSerializer.listSerializer.descriptor`) — avoiding `X$Companion` lookups and redundant
   * `ArrayListClassDesc` allocations. For cyclic references we fall back to `lazyDescriptor { ...
   * }` to break recursive class-init. SCC info from [TypeGraphAnalyzer] classifies which edges are
   * which.
   */
  private fun descriptorFor(typeName: TypeName, parentClass: ClassName): CodeBlock {
    return when (val nonNull = typeName.copy(nullable = false)) {
      is ClassName -> {
        if (isCyclicRef(parentClass, nonNull)) {
          CodeBlock.of(
            "%M { %L.descriptor }",
            lazyDescriptorMemberName(parentClass),
            serializerRefForClass(nonNull, parentClass),
          )
        } else {
          CodeBlock.of("%L.descriptor", serializerRefForClass(nonNull, parentClass))
        }
      }
      is ParameterizedTypeName -> {
        when (nonNull.rawType) {
          ClassName("kotlin.collections", "List"),
          ClassName("kotlin.collections", "MutableList") -> {
            val inner = nonNull.typeArguments.single()
            val innerClass = inner.copy(nullable = false) as ClassName
            if (isCyclicRef(parentClass, innerClass)) {
              CodeBlock.of("%M(%L)", listDescMemberName, descriptorFor(inner, parentClass))
            } else {
              CodeBlock.of(
                "%L.descriptor",
                listSerializerRefForClass(
                  innerClass,
                  parentClass,
                  nullableElement = inner.isNullable,
                ),
              )
            }
          }
          else -> {
            val raw = nonNull.rawType
            if (isCyclicRef(parentClass, raw)) {
              CodeBlock.of(
                "%M { %L.descriptor }",
                lazyDescriptorMemberName(parentClass),
                serializerRefForClass(raw, parentClass),
              )
            } else {
              CodeBlock.of("%L.descriptor", serializerRefForClass(raw, parentClass))
            }
          }
        }
      }
      else -> error("Unexpected TypeName: $nonNull")
    }
  }

  private fun isCyclicRef(parent: ClassName, target: ClassName): Boolean {
    if (target.packageName != parent.packageName || customSerializerFor(target, parent) != null) {
      return false
    }
    val parentRoot = parent.simpleNames.first()
    val targetRoot = target.simpleNames.first()
    // `ElementSerializer` only eagerly references `String.serializer()`, breaking its `Extension`
    // reference via `lazyDescriptor`, so it has no eager outgoing dependencies and cannot cycle.
    if (targetRoot == "Element") return false
    // `ElementSerializer` and `ExtensionSerializer` break all non-`Element` outgoing references via
    // `lazyDescriptor`, so `ExtensionSerializer` also has no eager outgoing dependencies on other
    // complex types and can be referenced directly everywhere else.
    if (parentRoot == "Element" || parentRoot == "Extension") return true
    if (targetRoot == "Extension") return false
    // `Resource` is always treated as cyclic from any subclass: `ResourcePolymorphicSerializer`
    // eagerly references every `XSerializer`, so any resource `<clinit>` touching
    // `ResourcePolymorphicSerializer.descriptor` would recurse into a half-initialized object.
    if (targetRoot == "Resource") return true
    // Within the same root type, referencing `XSerializer` directly does not initialize the outer
    // model class. Parent-to-child backbone references (`parent.simpleNames.size <
    // target.simpleNames.size`) strictly increase tree depth and cannot cycle; self-references or
    // upward/sibling `contentReference` edges may cycle and use `lazyDescriptor`.
    if (targetRoot == parentRoot) {
      return parent.simpleNames.size >= target.simpleNames.size
    }
    return codegenContext.typeGraph.isCyclicReference(parentRoot, targetRoot)
  }
}
