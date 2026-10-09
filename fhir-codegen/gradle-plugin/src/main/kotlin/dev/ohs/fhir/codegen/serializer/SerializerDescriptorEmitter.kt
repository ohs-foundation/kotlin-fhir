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
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.CodegenContext

/**
 * Builds the `descriptor` property and the `buildDescriptor(b)` override for a streaming
 * serializer. The descriptor mirrors the flat FHIR JSON wire shape — one element per JSON key,
 * including `_field` Element pairs and choice-type expansions. Cross-type descriptor cycles are
 * broken via `lazyDescriptor(LazyDescriptorId.X)` where [TypeGraphAnalyzer] flags an edge as
 * cyclic.
 */
internal class SerializerDescriptorEmitter(private val codegenContext: CodegenContext) {

  /**
   * Emits `override val descriptor`. Resource serializers delegate to
   * `FhirResourceSerializer.buildResourceDescriptor` (which registers the leading `resourceType`
   * slot 0); everything else delegates to the shared `buildDescriptor(name, this)` helper. Both
   * call back into [buildBuildDescriptorFun], so no generated serializer carries its own
   * `buildClassSerialDescriptor { … }` lambda (and `invokedynamic` bootstrap entry).
   *
   * Plain `val`, not `by lazy` — the streaming encoder/decoder reads `descriptor.getElementIndex` /
   * `getElementName` on every field, so deferring construction would move cost to first use rather
   * than eliminate it.
   */
  fun buildDescriptorProperty(className: ClassName, includeResourceType: Boolean): PropertySpec {
    val body =
      if (includeResourceType) {
        CodeBlock.of("buildResourceDescriptor(%S)", className.simpleName)
      } else {
        CodeBlock.of(
          "%M(%S, this)",
          helperMemberName(className, "buildDescriptor"),
          className.simpleName,
        )
      }
    return PropertySpec.builder("descriptor", serialDescriptorClassName)
      .addModifiers(KModifier.OVERRIDE)
      .initializer(body)
      .build()
  }

  /**
   * `override fun buildDescriptor(b)` — registers the wire-field elements. Every element is marked
   * `isOptional = true` — FHIR JSON omits absent keys, and streaming encoders skip optional
   * elements when we don't call `encodeXxxElement`, so this matches the wire shape cleanly.
   *
   * A primitive's `x` + `_x` pair is registered with a single `prim`-style helper call so the `_x`
   * name never appears as a string constant in the serializer class; stdlib `String` / `Boolean` /
   * `Int` slots use the `str` / `strPrim` / … shorthands which read a cached descriptor instead of
   * calling `String.serializer().descriptor` per slot.
   */
  fun buildBuildDescriptorFun(className: ClassName, wireFields: List<WireField>): FunSpec {
    val classSerialDescriptorBuilderClassName =
      ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "ClassSerialDescriptorBuilder")
    val codeBlock = CodeBlock.builder()
    var i = 0
    while (i < wireFields.size) {
      val wireField = wireFields[i]
      val next = wireFields.getOrNull(i + 1)
      val paired = next != null && next.isElementField && next.name == "_${wireField.name}"
      val valueClass = elementClassOf(wireField.typeName)
      val shorthand = stdlibShorthand(valueClass)
      if (paired) {
        val suffix = if (wireField.isList) "PrimList" else "Prim"
        if (shorthand != null) {
          codeBlock.add(
            "b.%M(%S)\n",
            helperMemberName(className, shorthand + suffix),
            wireField.name,
          )
        } else {
          codeBlock.add(
            "b.%M(%S, %L)\n",
            helperMemberName(className, suffix.replaceFirstChar { it.lowercase() }),
            wireField.name,
            descriptorFor(wireField.typeName, className),
          )
        }
        i += 2
      } else {
        if (shorthand == "str" && !wireField.isList) {
          codeBlock.add("b.%M(%S)\n", helperMemberName(className, "str"), wireField.name)
        } else {
          codeBlock.add(
            "b.%M(%S, %L)\n",
            optionalElementMemberName(className),
            wireField.name,
            descriptorFor(wireField.typeName, className),
          )
        }
        i += 1
      }
    }
    return FunSpec.builder("buildDescriptor")
      .addModifiers(KModifier.OVERRIDE)
      .addParameter("b", classSerialDescriptorBuilderClassName)
      .addCode(codeBlock.build())
      .build()
  }

  /** Element class of a slot: the list element type for lists, the slot type otherwise. */
  private fun elementClassOf(typeName: TypeName): ClassName? {
    val nonNull = typeName.copy(nullable = false)
    return when (nonNull) {
      is ClassName -> nonNull
      is ParameterizedTypeName ->
        nonNull.typeArguments.singleOrNull()?.copy(nullable = false) as? ClassName
      else -> null
    }
  }

  private fun stdlibShorthand(className: ClassName?): String? =
    when (className) {
      String::class.asClassName() -> "str"
      Boolean::class.asClassName() -> "bool"
      Int::class.asClassName() -> "int"
      else -> null
    }

  /**
   * Descriptor expression for a wire-field. For non-cyclic cross-type references we emit the
   * child's real descriptor directly (`XSerializer.descriptor` /
   * `XSerializer.listSerializer.descriptor`) — avoiding `X$Companion` lookups and redundant
   * `ArrayListClassDesc` allocations. For cyclic references we fall back to
   * `lazyDescriptor(LazyDescriptorId.XSerializer)` to break recursive class-init. SCC info from
   * [TypeGraphAnalyzer] classifies which edges are which.
   */
  private fun descriptorFor(typeName: TypeName, parentClass: ClassName): CodeBlock {
    return when (val nonNull = typeName.copy(nullable = false)) {
      is ClassName -> descriptorForClass(nonNull, parentClass)
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
          else -> descriptorForClass(nonNull.rawType, parentClass)
        }
      }
      else -> error("Unexpected TypeName: $nonNull")
    }
  }

  private fun descriptorForClass(className: ClassName, parentClass: ClassName): CodeBlock =
    if (isCyclicRef(parentClass, className)) {
      val serializerObject =
        serializerObjectForClass(className, parentClass)
          ?: error("Cyclic reference to $className without a generated serializer")
      CodeBlock.of(
        "%M(%T)",
        lazyDescriptorMemberName(parentClass),
        codegenContext.lazyDescriptorId(serializerObject),
      )
    } else {
      CodeBlock.of("%L.descriptor", serializerRefForClass(className, parentClass))
    }

  private fun isCyclicRef(parent: ClassName, target: ClassName): Boolean {
    if (target.packageName != parent.packageName || customSerializerFor(target, parent) != null) {
      return false
    }
    val parentRoot = parent.simpleNames.first()
    val targetRoot = target.simpleNames.first()
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
