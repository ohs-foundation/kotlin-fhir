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
    val body = run {
      val builder = CodeBlock.builder()
      builder.add("%M(%S) {\n", buildClassSerialDescriptorMemberName, className.simpleName)
      builder.indent()
      if (includeResourceType) {
        builder.add(
          "element(%S, %T.serializer().descriptor, isOptional = false)\n",
          "resourceType",
          ClassName("kotlin", "String"),
        )
        // Wire fields go through the shared `buildDescriptor` helper so `XPolymorphicSerializer`
        // can reuse the same element list.
        builder.add("buildDescriptor(this)\n")
      } else {
        for (wireField in wireFields) {
          builder.add(
            "element(%S, %L, isOptional = true)\n",
            wireField.name,
            descriptorFor(wireField.typeName, className),
          )
        }
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

  /** `internal fun buildDescriptor(b)` — wire-field elements only, shared between both variants. */
  fun buildBuildDescriptorFun(className: ClassName, wireFields: List<WireField>): FunSpec {
    val classSerialDescriptorBuilderClassName =
      ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "ClassSerialDescriptorBuilder")
    val codeBlock = CodeBlock.builder()
    for (wireField in wireFields) {
      codeBlock.add(
        "b.element(%S, %L, isOptional = true)\n",
        wireField.name,
        descriptorFor(wireField.typeName, className),
      )
    }
    return FunSpec.builder("buildDescriptor")
      .addModifiers(KModifier.INTERNAL)
      .addParameter("b", classSerialDescriptorBuilderClassName)
      .addCode(codeBlock.build())
      .build()
  }

  /**
   * Descriptor expression for a wire-field. For non-cyclic cross-type references we emit the
   * child's real descriptor directly (`X.serializer().descriptor`) — compiles to a single
   * `getstatic`. For cyclic references we fall back to `lazyDescriptor { ... }` to break recursive
   * class-init. SCC info from [TypeGraphAnalyzer] classifies which edges are which.
   */
  private fun descriptorFor(typeName: TypeName, parentClass: ClassName): CodeBlock {
    return when (val nonNull = typeName.copy(nullable = false)) {
      is ClassName -> {
        val custom = customSerializerFor(nonNull, parentClass)
        if (custom != null) {
          CodeBlock.of("%T.descriptor", custom)
        } else if (isStdlibSerializableType(nonNull)) {
          CodeBlock.of("%L.descriptor", serializerForClassName(nonNull))
        } else if (isCyclicRef(parentClass, nonNull)) {
          CodeBlock.of(
            "%M { %T.serializer().descriptor }",
            lazyDescriptorMemberName(parentClass),
            nonNull,
          )
        } else {
          CodeBlock.of("%T.serializer().descriptor", nonNull)
        }
      }
      is ParameterizedTypeName -> {
        when (nonNull.rawType) {
          ClassName("kotlin.collections", "List"),
          ClassName("kotlin.collections", "MutableList") -> {
            val inner = nonNull.typeArguments.single()
            CodeBlock.of("%M(%L)", listDescMemberName, descriptorFor(inner, parentClass))
          }
          else -> {
            val raw = nonNull.rawType
            if (isCyclicRef(parentClass, raw))
              CodeBlock.of(
                "%M { %T.serializer().descriptor }",
                lazyDescriptorMemberName(parentClass),
                raw,
              )
            else CodeBlock.of("%T.serializer().descriptor", raw)
          }
        }
      }
      else -> error("Unexpected TypeName: $nonNull")
    }
  }

  private fun isCyclicRef(parent: ClassName, target: ClassName): Boolean {
    // Nested class reference (e.g. `CodeSystem` → `CodeSystem.Concept`): always cyclic. Accessing
    // a nested class's `serializer()` during the outer class's static init triggers outer init
    // recursively. Our SCC graph tracks only top-level types and can't see this, so handle here.
    if (target.simpleNames.size > 1 || parent.simpleNames.size > 1) {
      val targetRoot = target.simpleNames.first()
      val parentRoot = parent.simpleNames.first()
      if (targetRoot == parentRoot) return true
    }
    // `Resource` is always treated as cyclic from any subclass: `ResourcePolymorphicSerializer`
    // eagerly references every `XPolymorphicSerializer`, so any subclass `<clinit>` touching
    // `Resource.serializer().descriptor` would recurse into a half-initialized object.
    if (target.simpleNames.first() == "Resource") return true
    return codegenContext.typeGraph.isCyclicReference(
      parent.simpleNames.first(),
      target.simpleNames.first(),
    )
  }
}
