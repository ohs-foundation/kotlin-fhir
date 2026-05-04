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

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import dev.ohs.fhir.codegen.primitives.FhirPathType
import dev.ohs.fhir.codegen.schema.Element
import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.Type
import dev.ohs.fhir.codegen.schema.backboneElements
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.getContentReferenceType
import dev.ohs.fhir.codegen.schema.getElementName
import dev.ohs.fhir.codegen.schema.getPathSimpleNames
import dev.ohs.fhir.codegen.schema.isBackboneElement
import dev.ohs.fhir.codegen.schema.rootElements
import dev.ohs.fhir.codegen.schema.typeIsEnumeratedCode
import kotlinx.serialization.KSerializer

private const val KOTLINX_SERIALIZATION_DESCRIPTORS = "kotlinx.serialization.descriptors"
private const val KOTLINX_SERIALIZATION_ENCODING = "kotlinx.serialization.encoding"
private const val KOTLINX_SERIALIZATION_BUILTINS = "kotlinx.serialization.builtins"

private val decoderCN = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Decoder")
private val encoderCN = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Encoder")
private val serialDescriptorCN = ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "SerialDescriptor")

private val buildClassSerialDescriptorMN =
  MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "buildClassSerialDescriptor")
private val decodeStructureMN = MemberName(KOTLINX_SERIALIZATION_ENCODING, "decodeStructure")
private val encodeStructureMN = MemberName(KOTLINX_SERIALIZATION_ENCODING, "encodeStructure")
private val compositeDecoderCN = ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeDecoder")
private val listSerializerMN = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer")
private val nullableMN = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "nullable")

/** Generates a streaming `KSerializer<X>` per FHIR type over the flat wire shape. */
class SerializerFileSpecGenerator(val codegenContext: CodegenContext) {

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
    // the parent resource serializer fully inlines the per-arm keys on encode/decode, so a
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
   * flat FHIR wire shape — one descriptor slot per JSON key on the wire, including per-arm
   * expansions for `[x]` choice types (e.g. `deceasedBoolean` / `_deceasedBoolean` /
   * `deceasedDateTime` / `_deceasedDateTime`). Choice types are handled inline against the parent's
   * composite encoder: `emitChoiceArmEncodingInline` writes the matched arm's keys on encode;
   * decode reads them into per-arm locals and synthesizes the sealed value via the companion
   * `from(…)` factory during `emitModelConstruction`.
   */
  private fun createModelSerializerTypeSpecs(
    className: ClassName,
    elements: List<Element>,
    isResource: Boolean,
    resourceTypeName: String? = null,
  ): List<TypeSpec> {
    // One serializer per type, operating on the flat FHIR wire shape. Choice-bearing types do not
    // get a separate per-arm wrapper — per-arm keys are emitted directly against the parent's
    // composite encoder on both encode and decode paths.
    val wireFields = buildJsonWireFields(className, elements)
    return listOf(
      createStreamingSerializerTypeSpec(
        className,
        className.toSerializerClassName(),
        elements,
        wireFields,
        isResource,
        resourceTypeName,
      )
    )
  }

  /** The streaming serializer object — does the actual `encodeStructure`/`decodeStructure` work. */
  private fun createStreamingSerializerTypeSpec(
    className: ClassName,
    serializerClassName: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    isResource: Boolean,
    resourceTypeName: String?,
  ): TypeSpec {
    val hoister = SerializerHoister()
    val builder =
      TypeSpec.objectBuilder(serializerClassName)
        .addModifiers(KModifier.INTERNAL)
        .addSuperinterface(KSerializer::class.asClassName().parameterizedBy(className))
        .addProperty(buildDescriptorProperty(className, wireFields, isResource))
    val functions =
      buildSerializerFunctions(
        className,
        elements,
        wireFields,
        isResource,
        resourceTypeName,
        hoister,
      )
    hoister.eagerPropertyDefinitions().forEach { builder.addProperty(it) }
    functions.forEach { builder.addFunction(it) }
    hoister.deferredObjectTypeSpec()?.let { builder.addType(it) }
    return builder.build()
  }

  /**
   * Collects non-trivial serializer expressions (List, Nullable, etc.) used by the encode/decode
   * functions and emits them as `private val` singletons on the serializer object. Avoids
   * re-allocating `ListSerializer(...)` / `NullableSerializer(...)` on every decode call.
   */
  internal class SerializerHoister {
    private data class Entry(
      val name: String,
      val expression: CodeBlock,
      val resultType: TypeName,
      /**
       * If true, emit this entry on a nested `private object Hoisted { ... }` instead of directly
       * on the outer serializer object. Nested objects initialize via JVM class-init on first
       * property access (not with the enclosing object), so expressions that eagerly dereference a
       * still-initializing sibling's `descriptor` (e.g. `ListSerializer(Extension.serializer())`
       * from inside `ExtensionSerializer`'s own init — `ArrayListSerializer`'s constructor reads
       * `element.descriptor`, which is null during our own init) are deferred until encode/decode
       * starts. No `Lazy` monitor — just a `getstatic` after the one-time init.
       */
      val deferred: Boolean,
    )

    private val byKey = linkedMapOf<String, Entry>()

    /**
     * Return a [CodeBlock] referencing a private val whose value is [expression]. [resultType] is
     * the T in `KSerializer<T>` — used so the emitted val has a concrete type, letting the compiler
     * infer types at call sites without `UNCHECKED_CAST`.
     */
    fun ref(expression: CodeBlock, preferredName: String, resultType: TypeName): CodeBlock =
      refInternal(expression, preferredName, resultType, deferred = false)

    /**
     * Variant of [ref] that places the val on a nested `Hoisted` object so its expression runs
     * lazily (first access). Use for wrappers that would trigger a class-init cycle if evaluated
     * during the outer serializer's own init.
     */
    fun refLazy(expression: CodeBlock, preferredName: String, resultType: TypeName): CodeBlock =
      refInternal(expression, preferredName, resultType, deferred = true)

    private fun refInternal(
      expression: CodeBlock,
      preferredName: String,
      resultType: TypeName,
      deferred: Boolean,
    ): CodeBlock {
      val key = expression.toString() + if (deferred) "@deferred" else ""
      val entry =
        byKey.getOrPut(key) {
          val base = sanitizeName(preferredName)
          var candidate = base
          var n = 2
          val existingNames = byKey.values.map { it.name }.toSet()
          while (candidate in existingNames) {
            candidate = "$base$n"
            n++
          }
          Entry(candidate, expression, resultType, deferred)
        }
      return if (deferred) CodeBlock.of("Hoisted.%N", entry.name)
      else CodeBlock.of("%N", entry.name)
    }

    private fun sanitizeName(s: String): String {
      val cleaned = s.replace(Regex("[^A-Za-z0-9]"), "")
      return if (cleaned.isEmpty()) "ser" else cleaned
    }

    /** Eager hoisted props — placed directly on the outer serializer object. */
    fun eagerPropertyDefinitions(): List<PropertySpec> {
      val kserializer = KSerializer::class.asClassName()
      return byKey.values
        .filterNot { it.deferred }
        .map { (name, expr, resultType, _) ->
          PropertySpec.builder(name, kserializer.parameterizedBy(resultType))
            .addModifiers(KModifier.PRIVATE)
            .initializer(expr)
            .build()
        }
    }

    /**
     * Nested `private object Hoisted { ... }` holding deferred entries. Returns null if no deferred
     * entries are hoisted (keep the outer object tidy).
     */
    fun deferredObjectTypeSpec(): TypeSpec? {
      val deferred = byKey.values.filter { it.deferred }
      if (deferred.isEmpty()) return null
      val kserializer = KSerializer::class.asClassName()
      val builder = TypeSpec.objectBuilder("Hoisted").addModifiers(KModifier.PRIVATE)
      for ((name, expr, resultType, _) in deferred) {
        builder.addProperty(
          PropertySpec.builder(name, kserializer.parameterizedBy(resultType))
            .initializer(expr)
            .build()
        )
      }
      return builder.build()
    }
  }

  // ==============================================================================================
  // Field models
  // ==============================================================================================

  /**
   * A single wire-level field — one slot in the streaming encode/decode descriptor.
   *
   * Mapping from FHIR elements to wire fields:
   * - Primitive → `(value, _sidecar)` pair of `WireField`s.
   * - Choice type (`foo[x]`) → per-arm pairs (`fooBoolean` + `_fooBoolean`, `fooDateTime` +
   *   `_fooDateTime`, …) expanded directly into the flat wire shape. Encode dispatches via
   *   `emitChoiceArmEncodingInline`; decode reads arm locals and synthesizes the sealed value via
   *   the companion `from(…)` factory in `emitModelConstruction`.
   * - Complex / list → single `WireField`.
   *
   * For resource types, `resourceType` is handled separately as descriptor[0] — NOT included here.
   */
  internal data class WireField(
    val name: String,
    val typeName: TypeName,
    /** Owning parent element. */
    val element: Element,
    /** Is this the `_field` sidecar (carries id/extension for a primitive). */
    val isElementSidecar: Boolean = false,
    val defaultValue: String? = "null",
  )

  /**
   * Wire fields matching the FLAT FHIR JSON wire shape exactly — every top-level key that appears
   * on the wire is a separate entry. Choice types expand to per-arm pairs (`deceasedBoolean`,
   * `_deceasedBoolean`, `deceasedDateTime`, …). Encode writes these slots directly via
   * `emitChoiceArmEncodingInline`; decode reads them into locals and synthesizes the sealed value
   * via the companion `from(…)` factory.
   */
  private fun buildJsonWireFields(
    modelClassName: ClassName,
    elements: List<Element>,
  ): List<WireField> {
    val propertyMapper =
      PropertyMapper(PropertyMapper.MappingContext.WIRE, modelClassName, codegenContext.valueSetMap)
    return elements.flatMap { element ->
      propertyMapper.mapToProperties(element).map { info ->
        WireField(
          name = info.name,
          typeName = info.typeName,
          element = element,
          isElementSidecar = info.name.startsWith("_"),
          defaultValue = info.defaultValue,
        )
      }
    }
  }

  // ==============================================================================================
  // Descriptor
  // ==============================================================================================

  /**
   * Emits `override val descriptor` as a flat `buildClassSerialDescriptor(name) { element(...) ...
   * }` reflecting the actual JSON wire shape (one element per JSON key, including `_sidecar` pairs
   * and choice-type arms). For resource types, `resourceType` is descriptor[0].
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
  private fun buildDescriptorProperty(
    className: ClassName,
    wireFields: List<WireField>,
    isResource: Boolean,
  ): PropertySpec {
    val body = run {
      val b = CodeBlock.builder()
      b.add("%M(%S) {\n", buildClassSerialDescriptorMN, className.simpleName)
      b.indent()
      if (isResource) {
        b.add(
          "element(%S, %T.serializer().descriptor, isOptional = false)\n",
          "resourceType",
          ClassName("kotlin", "String"),
        )
      }
      for (f in wireFields) {
        b.add("element(%S, %L, isOptional = true)\n", f.name, descriptorFor(f.typeName, className))
      }
      b.unindent()
      b.add("}\n")
      b.build()
    }
    return PropertySpec.builder("descriptor", serialDescriptorCN)
      .addModifiers(KModifier.OVERRIDE)
      .initializer(body)
      .build()
  }

  private val listDescMN = MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "listSerialDescriptor")

  private fun lazyDescriptorMN(className: ClassName): MemberName =
    MemberName("${className.packageName}.serializers", "lazyDescriptor")

  /**
   * Certain stdlib / external types are serialized via a FHIR-specific custom serializer (e.g.
   * `LocalTime` → `LocalTimeSerializer` which always includes seconds; `Double` →
   * `DoubleSerializer` which strips trailing zeros). Returns the custom serializer's [ClassName]
   * for JSON + proto encode/decode, or null for types that use the default kotlinx serializer.
   */
  private fun customSerializerFor(className: ClassName, parentClass: ClassName): ClassName? {
    val pkg = "${parentClass.packageName}.serializers"
    return when {
      className.packageName == "kotlinx.datetime" && className.simpleName == "LocalTime" ->
        ClassName(pkg, "LocalTimeSerializer")
      className.packageName == "com.ionspin.kotlin.bignum.decimal" &&
        className.simpleName == "BigDecimal" -> ClassName(pkg, "BigDecimalSerializer")
      className.packageName == parentClass.packageName && className.simpleName == "FhirDate" ->
        ClassName(pkg, "FhirDateSerializer")
      className.packageName == parentClass.packageName && className.simpleName == "FhirDateTime" ->
        ClassName(pkg, "FhirDateTimeSerializer")
      else -> null
    }
  }

  /**
   * Serializer expression ([ClassName] reference or `.serializer()` call), respecting custom
   * serializers.
   */
  private fun serializerRefFor(className: ClassName, parentClass: ClassName): CodeBlock {
    customSerializerFor(className, parentClass)?.let {
      return CodeBlock.of("%T", it)
    }
    return serializerForClassName(className)
  }

  /**
   * Descriptor expression for a wire-field. For non-cyclic cross-type references we emit the
   * child's real descriptor directly (`X.serializer().descriptor`) — compiles to a single
   * `getstatic`. For cyclic references we fall back to `lazyDescriptor { ... }` to break recursive
   * class-init. SCC info from [TypeGraphAnalyzer] classifies which edges are which.
   */
  private fun descriptorFor(typeName: TypeName, parentClass: ClassName): CodeBlock {
    val nonNull = typeName.copy(nullable = false)
    return when (nonNull) {
      is ClassName -> {
        val custom = customSerializerFor(nonNull, parentClass)
        if (custom != null) {
          CodeBlock.of("%T.descriptor", custom)
        } else if (
          nonNull.packageName == "kotlin" && stdlibSerializableTypes.contains(nonNull.simpleName)
        ) {
          CodeBlock.of("%L.descriptor", serializerForClassName(nonNull))
        } else if (isCyclicRef(parentClass, nonNull)) {
          CodeBlock.of("%M { %T.serializer().descriptor }", lazyDescriptorMN(parentClass), nonNull)
        } else {
          CodeBlock.of("%T.serializer().descriptor", nonNull)
        }
      }
      is com.squareup.kotlinpoet.ParameterizedTypeName -> {
        when (nonNull.rawType) {
          ClassName("kotlin.collections", "List"),
          ClassName("kotlin.collections", "MutableList") -> {
            val inner = nonNull.typeArguments.single()
            CodeBlock.of("%M(%L)", listDescMN, descriptorFor(inner, parentClass))
          }
          else -> {
            val raw = nonNull.rawType
            if (isCyclicRef(parentClass, raw))
              CodeBlock.of("%M { %T.serializer().descriptor }", lazyDescriptorMN(parentClass), raw)
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
    val g = codegenContext.typeGraph ?: return true
    return g.isCyclicReference(parent.simpleNames.first(), target.simpleNames.first())
  }

  // ==============================================================================================
  // Helpers
  // ==============================================================================================

  private fun serializerExpression(typeName: TypeName): CodeBlock = serializerForTypeName(typeName)

  // ==============================================================================================
  // Custom serializer (single-entry) — all 4 methods
  // ==============================================================================================

  // The simpler way to compose the object: emit a TypeSpec whose functions include the branch fn
  // AND the four private helpers. Build them side-by-side.

  private fun buildSerializerFunctions(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    isResource: Boolean,
    resourceTypeName: String?,
    hoister: SerializerHoister,
  ): List<FunSpec> {
    // Per-field descriptor index. `resourceType` is at 0 for resources; wireFields start at 0 or 1.
    val indexOffset = if (isResource) 1 else 0
    val nameToIdx = wireFields.withIndex().associate { (i, f) -> f.name to (i + indexOffset) }
    val functions = mutableListOf<FunSpec>()
    // `deserialize(decoder)` streams via `decodeStructure { deserializeJson(this) }`. The same body
    // services both `StreamingJsonDecoder` and `JsonTreeDecoder` because every read inside the
    // `deserializeJson` loop goes through the `CompositeDecoder` interface (`decodeElementIndex`,
    // `decodeXxxElement`, `decodeSerializableElement`) — kotlinx picks the decoder, we walk it.
    functions +=
      FunSpec.builder("deserialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("decoder", decoderCN)
        .returns(className)
        .addCode("return decoder.%M(descriptor) {\n  deserializeJson(this)\n}\n", decodeStructureMN)
        .build()
    functions +=
      FunSpec.builder("serialize")
        .addModifiers(KModifier.OVERRIDE)
        .addParameter("encoder", encoderCN)
        .addParameter("value", className)
        .addCode("encoder.%M(descriptor) {\n  serializeJson(this, value)\n}\n", encodeStructureMN)
        .build()
    functions +=
      buildDeserializeJsonFun(className, elements, wireFields, isResource, nameToIdx, hoister)
    functions +=
      buildSerializeJsonFun(className, elements, isResource, resourceTypeName, nameToIdx, hoister)
    return functions
  }

  // --- JSON decode (streaming) ------------------------------------------------------------------

  /**
   * Emits `private fun deserializeJson(decoder: CompositeDecoder): X` — a while-loop over
   * `decodeElementIndex(descriptor)` with an index-dispatching `when`. Each case reads one flat
   * wire field via `decodeXxxElement` (specialized) or `decodeNullableSerializableElement` (for
   * complex/list/sidecar types), then the loop terminates on `DECODE_DONE`.
   *
   * After the loop, sealed-type (choice) locals are synthesized from their arm transients; then the
   * model is constructed from the assembled locals.
   */
  private fun buildDeserializeJsonFun(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    isResource: Boolean,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ): FunSpec {
    val cb = CodeBlock.builder()
    // Hoist `descriptor` into a local so each `decodeElementIndex` / `decode*Element` call
    // compiles to `aload <local>` rather than `getstatic INSTANCE + invokevirtual getDescriptor()`.
    // This matches plugin-gen bytecode, which stores the descriptor in a local once.
    cb.add("val __desc = descriptor\n")
    // One local per flat wire field — choice types expand into per-arm value+sidecar locals
    // (e.g. `deceasedBoolean`, `_deceasedBoolean`, `deceasedDateTime`, `_deceasedDateTime`).
    for (f in wireFields) {
      cb.add(
        "var %N: %T = %L\n",
        f.name,
        f.typeName.copy(nullable = true),
        f.defaultValue ?: "null",
      )
    }

    // While-loop driven by decodeElementIndex.
    cb.add("while (true) {\n").indent()
    cb.add("when (val __i = decoder.decodeElementIndex(__desc)) {\n").indent()
    if (isResource) {
      // resourceType is at index 0 for resources. When called by ResourcePolymorphicSerializer
      // mid-stream, `resourceType` has already been consumed; this branch only fires on the
      // standalone decode path, where we read and discard (the polymorphic dispatch already
      // picked the right subclass).
      cb.add("0 -> decoder.decodeStringElement(__desc, 0)\n")
    }
    for (f in wireFields) {
      val idx = nameToIdx.getValue(f.name)
      cb.add("%L -> %N = %L\n", idx, f.name, jsonDecodeElementCall(f, idx, className, hoister))
    }
    cb.add("%T.DECODE_DONE -> break\n", compositeDecoderCN)
    cb.add(
      "else -> throw %T(%S + __i)\n",
      ClassName("kotlinx.serialization", "SerializationException"),
      "Unexpected index decoding ${className.simpleName}: ",
    )
    cb.unindent().add("}\n")
    cb.unindent().add("}\n")

    // Construct the model — synthesize sealed (choice) values from arm locals via `X.from(...)`.
    cb.add("return ")
    cb.add(emitModelConstruction(className, elements, expandPolymorphic = true))
    // Resource types need `deserializeJson` reachable from ResourcePolymorphicSerializer (which
    // peeks `resourceType` via `beginStructure` + `decodeElementIndex` and then hands the
    // mid-stream `CompositeDecoder` here to finish the streaming loop). Other types keep it
    // private.
    return FunSpec.builder("deserializeJson")
      .addModifiers(if (isResource) KModifier.INTERNAL else KModifier.PRIVATE)
      .addParameter("decoder", compositeDecoderCN)
      .returns(className)
      .addCode(cb.build())
      .build()
  }

  /**
   * Decode-one-element call for wire field [f] at descriptor index [index]. Uses the specialized
   * `decodeXxxElement` for stdlib primitives (fastest path), and
   * `decodeNullableSerializableElement` for complex/list/sidecar types (matches the plugin-gen
   * pattern and handles explicit JSON `null` gracefully).
   */
  private fun jsonDecodeElementCall(
    f: WireField,
    index: Int,
    parentClass: ClassName,
    hoister: SerializerHoister,
  ): CodeBlock {
    val nonNull = f.typeName.copy(nullable = false)
    if (nonNull is ClassName && nonNull.packageName == "kotlin") {
      when (nonNull.simpleName) {
        "String" -> return CodeBlock.of("decoder.decodeStringElement(__desc, %L)", index)
        "Boolean" -> return CodeBlock.of("decoder.decodeBooleanElement(__desc, %L)", index)
        "Int" -> return CodeBlock.of("decoder.decodeIntElement(__desc, %L)", index)
        "Long" -> return CodeBlock.of("decoder.decodeLongElement(__desc, %L)", index)
        "Double" -> return CodeBlock.of("decoder.decodeDoubleElement(__desc, %L)", index)
        "Char" -> return CodeBlock.of("decoder.decodeCharElement(__desc, %L)", index)
      }
    }
    val ser = serializerExpressionIn(f.typeName, parentClass, hoister, "${f.name}Ser")
    // Explicit `previousValue = null` — 4-arg form — so Kotlin emits a direct interface call
    // instead of the `decodeNullableSerializableElement$default` static synthetic bridge.
    return CodeBlock.of(
      "decoder.decodeNullableSerializableElement(__desc, %L, %L, null)",
      index,
      ser,
    )
  }

  /**
   * Serializer expression for [typeName] suitable for a decode/encode call site.
   *
   * Every reference — bare `X.serializer()`, `ListSerializer(...)`, `.nullable` wrappers — goes
   * through the deferred hoister, landing on the nested `Hoisted` object. The call site compiles to
   * a single `getstatic Hoisted.$fooSer`; plugin-gen emits an equivalent `getstatic
   * childSerializers$lazy[i] + invokevirtual getValue()` shape. Nested-object init fires on first
   * access (not with the outer object's `<clinit>`), so self-referential types don't dereference a
   * still-initializing sibling's `descriptor` during construction.
   *
   * Custom FHIR serializers (`LocalTimeSerializer`, `DoubleSerializer`) are singletons — already a
   * single `getstatic`, no hoist needed.
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
    if (nonNull is com.squareup.kotlinpoet.ParameterizedTypeName) {
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

  // --- JSON encode (streaming) ------------------------------------------------------------------

  /**
   * Emits `private fun serializeJson(encoder: CompositeEncoder, value: X)` — writes each field
   * directly to the structure encoder via [CompositeEncoder.encodeXxxElement] /
   * [CompositeEncoder.encodeSerializableElement], with no intermediate `JsonObject` tree.
   */
  private fun buildSerializeJsonFun(
    className: ClassName,
    elements: List<Element>,
    isResource: Boolean,
    resourceTypeName: String?,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ): FunSpec {
    val cb = CodeBlock.builder()
    // Hoist `descriptor` into a local (see deserializeJson comment for rationale).
    cb.add("val __desc = descriptor\n")
    if (isResource && resourceTypeName != null) {
      cb.add("encoder.encodeStringElement(__desc, 0, %S)\n", resourceTypeName)
    }
    elements.forEach { element ->
      emitJsonEncodeForElement(cb, element, className, nameToIdx, hoister)
    }
    return FunSpec.builder("serializeJson")
      .addModifiers(KModifier.PRIVATE)
      .addParameter("encoder", ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeEncoder"))
      .addParameter("value", className)
      .addCode(cb.build())
      .build()
  }

  private fun emitJsonEncodeForElement(
    cb: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    // Choice type: emit per-arm flat keys inline against the parent's composite encoder.
    // Each arm's value / sidecar is written to a flat descriptor slot on the parent instead
    // of via a nested sub-object — there is no standalone choice-type serializer.
    if (element.type != null && element.type.size > 1) {
      emitChoiceArmEncodingInline(cb, element, modelClassName, nameToIdx, hoister)
      return
    }
    val typeCode = element.type?.singleOrNull()?.code ?: ""
    val isFhirPrimitive = FhirPathType.containsFhirTypeCode(typeCode)
    val isFhirPathUri = FhirPathType.getUris().contains(typeCode)
    if (element.max == "*" || propertyName == "extension") {
      if (isFhirPrimitive) {
        emitJsonEncodePrimitiveList(cb, element, propertyName, modelClassName, nameToIdx, hoister)
      } else {
        val elemCls = typeForComplexElement(element, modelClassName)
        val idx = nameToIdx.getValue(propertyName)
        val innerSer =
          hoistedSerializerForClass(
            elemCls,
            modelClassName,
            hoister,
            "${elemCls.simpleName.lowercase()}Ser",
          )
        val listSer =
          hoister.refLazy(
            CodeBlock.of("%M(%L)", listSerializerMN, innerSer),
            "${propertyName}ListSer",
            ClassName("kotlin.collections", "List").parameterizedBy(elemCls),
          )
        cb.add(
          "if (value.%N.isNotEmpty()) encoder.encodeSerializableElement(__desc, %L, %L, value.%N)\n",
          propertyName,
          idx,
          listSer,
          propertyName,
        )
      }
      return
    }
    if (isFhirPrimitive) {
      emitJsonEncodeSinglePrimitive(cb, element, propertyName, modelClassName, nameToIdx, hoister)
    } else if (isFhirPathUri) {
      val kotlinType =
        FhirPathType.getFromUri(typeCode)!!.getTypeInModelClass(modelClassName.packageName)
          as ClassName
      val idx = nameToIdx.getValue(propertyName)
      emitPrimitiveOrSerializableEncode(
        cb,
        encoderExpr = "encoder",
        idx,
        kotlinType,
        CodeBlock.of("value.%N", propertyName),
        modelClassName,
        hoister,
        "${propertyName}Ser",
      )
    } else {
      val singleType = typeForComplexElement(element, modelClassName)
      val idx = nameToIdx.getValue(propertyName)
      val ser =
        hoistedSerializerForClass(
          singleType,
          modelClassName,
          hoister,
          "${singleType.simpleName.lowercase()}Ser",
        )
      cb.add(
        "(value.%N)?.let·{ encoder.encodeSerializableElement(__desc, %L, %L, it) }\n",
        propertyName,
        idx,
        ser,
      )
    }
  }

  /**
   * Name of the specialized `encodeXxxElement` on [CompositeEncoder] for a stdlib primitive, or
   * null if no specialized call exists (fall back to `encodeSerializableElement`).
   */
  private fun specializedEncodeElementCall(className: ClassName): String? =
    if (className.packageName != "kotlin") null
    else
      when (className.simpleName) {
        "String" -> "encodeStringElement"
        "Boolean" -> "encodeBooleanElement"
        "Int" -> "encodeIntElement"
        "Long" -> "encodeLongElement"
        "Double" -> "encodeDoubleElement"
        "Char" -> "encodeCharElement"
        else -> null
      }

  /**
   * Emits `(valueExpr)?.let { encoder.encodeXxxElement(descriptor, idx, it) }` using the
   * specialized primitive call when [type] is a stdlib primitive, falling back to
   * `encodeSerializableElement` with a hoisted serializer reference otherwise.
   */
  private fun emitPrimitiveOrSerializableEncode(
    cb: CodeBlock.Builder,
    encoderExpr: String,
    idx: Int,
    type: ClassName,
    valueExpr: CodeBlock,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
  ) {
    val specialized = specializedEncodeElementCall(type)
    if (specialized != null) {
      cb.add("(%L)?.let·{ %N.%N(__desc, %L, it) }\n", valueExpr, encoderExpr, specialized, idx)
      return
    }
    val ser = hoistedSerializerForClass(type, parentClass, hoister, nameHint)
    cb.add(
      "(%L)?.let·{ %N.encodeSerializableElement(__desc, %L, %L, it) }\n",
      valueExpr,
      encoderExpr,
      idx,
      ser,
    )
  }

  /**
   * Serializer reference for [className] at a call site — hoisted via the deferred `Hoisted` object
   * so every call site compiles to a single `getstatic Hoisted.$nameHint`. See
   * [serializerExpressionIn] kdoc for why deferred hoisting avoids class-init cycles.
   */
  private fun hoistedSerializerForClass(
    className: ClassName,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
  ): CodeBlock {
    customSerializerFor(className, parentClass)?.let {
      return CodeBlock.of("%T", it)
    }
    return hoister.refLazy(serializerForClassName(className), nameHint, className)
  }

  /**
   * Emits the full `when (val __d = value.field) { is Arm -> … }` dispatch for a choice-type
   * element, writing each arm's flat wire keys (e.g., `deceasedBoolean` + `_deceasedBoolean`)
   * directly into the parent's composite encoder using its flat descriptor slots. Replaces the old
   * "encode nested via sealed serializer, then flatten" pipeline.
   */
  private fun emitChoiceArmEncodingInline(
    cb: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    val sealedTypeClass = ClassName(modelClassName.packageName, element.getPathSimpleNames())
    cb.add("when (val __d = value.%N) {\n", propertyName)
    cb.indent()
    cb.add("null -> {}\n")
    for (type in element.type!!) {
      val armCN = sealedTypeClass.nestedClass(sealedChoiceArmName(type))
      val armBaseName = "$propertyName${type.code.capitalized()}"
      cb.add("is %T -> {\n", armCN)
      cb.indent()
      emitJsonEncodeChoiceArm(cb, type, armBaseName, modelClassName, nameToIdx, hoister)
      cb.unindent()
      cb.add("}\n")
    }
    cb.unindent()
    cb.add("}\n")
  }

  /** Writes both arm keys (`deceasedBoolean` + `_deceasedBoolean`) for a matched choice arm. */
  private fun emitJsonEncodeChoiceArm(
    cb: CodeBlock.Builder,
    type: Type,
    choiceFieldBaseName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ) {
    val typeCode = type.code
    val valueIdx = nameToIdx.getValue(choiceFieldBaseName)
    val elementIdx = nameToIdx["_$choiceFieldBaseName"]
    if (FhirPathType.containsFhirTypeCode(typeCode)) {
      val fpt = FhirPathType.getFromFhirTypeCode(typeCode)!!
      val primCN = fpt.wireType
      // Value arm
      val valueExpr =
        CodeBlock.builder()
          .apply {
            add("(__d.value")
            fpt.addCodeToEncodeModelToWire(this)
            add(")")
          }
          .build()
      emitPrimitiveOrSerializableEncode(
        cb,
        "encoder",
        valueIdx,
        primCN,
        valueExpr,
        modelClassName,
        hoister,
        "${choiceFieldBaseName}Ser",
      )
      // Sidecar arm
      if (elementIdx != null) {
        val elementCN = ClassName(modelClassName.packageName, "Element")
        val elementSer = hoistedSerializerForClass(elementCN, modelClassName, hoister, "elementSer")
        cb.add(
          "(__d.value.toElement())?.let·{ encoder.encodeSerializableElement(__desc, %L, %L, it) }\n",
          elementIdx,
          elementSer,
        )
      }
    } else {
      // Complex arm — e.g. Annotation.authorReference
      val complexCN = ClassName(modelClassName.packageName, typeCode.capitalized())
      val complexSer =
        hoistedSerializerForClass(
          complexCN,
          modelClassName,
          hoister,
          "${complexCN.simpleName.lowercase()}Ser",
        )
      cb.add("encoder.encodeSerializableElement(__desc, %L, %L, __d.value)\n", valueIdx, complexSer)
    }
  }

  private fun emitJsonEncodeSinglePrimitive(
    cb: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fpt = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val isRequired = element.min == 1 && element.max == "1"
    val surrCN: ClassName = fpt.wireType
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueType: ClassName = if (isEnum) String::class.asClassName() else surrCN
    val valueExpr =
      CodeBlock.builder()
        .apply {
          add("(")
          if (isEnum) {
            add(
              if (isRequired) "value.%N.value?.getCode()" else "value.%N?.value?.getCode()",
              propertyName,
            )
          } else {
            add("value.%N", propertyName)
            if (!isRequired) add("?")
            fpt.addCodeToEncodeModelToWire(this)
          }
          add(")")
        }
        .build()
    emitPrimitiveOrSerializableEncode(
      cb,
      "encoder",
      valueIdx,
      valueType,
      valueExpr,
      modelClassName,
      hoister,
      "${propertyName}Ser",
    )
    val elementCN = ClassName(modelClassName.packageName, "Element")
    val elementSer = hoistedSerializerForClass(elementCN, modelClassName, hoister, "elementSer")
    cb.add("(value.%N", propertyName)
    if (!isRequired) cb.add("?")
    cb.add(
      ".toElement())?.let·{ encoder.encodeSerializableElement(__desc, %L, %L, it) }\n",
      elementIdx,
      elementSer,
    )
  }

  private fun emitJsonEncodePrimitiveList(
    cb: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, Int>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fpt = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val surrCN: ClassName = fpt.wireType
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueInnerType: ClassName = if (isEnum) String::class.asClassName() else surrCN
    val valueInnerSer =
      if (isEnum)
        hoistedSerializerForClass(String::class.asClassName(), modelClassName, hoister, "stringSer")
      else
        customSerializerFor(surrCN, modelClassName)?.let { CodeBlock.of("%T", it) }
          ?: hoistedSerializerForClass(
            surrCN,
            modelClassName,
            hoister,
            "${surrCN.simpleName.lowercase()}Ser",
          )
    val listOfNullableType: (ClassName) -> TypeName = { inner ->
      ClassName("kotlin.collections", "List").parameterizedBy(inner.copy(nullable = true))
    }
    val valueListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMN, valueInnerSer, nullableMN),
        "${propertyName}ListSer",
        listOfNullableType(valueInnerType),
      )
    val elementCN = ClassName(modelClassName.packageName, "Element")
    val elementSer = hoistedSerializerForClass(elementCN, modelClassName, hoister, "elementSer")
    val elementListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMN, elementSer, nullableMN),
        "_${propertyName}ListSer",
        listOfNullableType(elementCN),
      )
    // values
    cb.add("(")
    if (isEnum) {
      cb.add(
        "value.%N.map·{·it.value?.getCode()·}.takeUnless·{·it.all·{·it == null·}·}",
        propertyName,
      )
    } else {
      cb.add("value.%N.map·{·it", propertyName)
      fpt.addCodeToEncodeModelToWire(cb)
      cb.add("·}.takeUnless·{·it.all·{·it == null·}·}")
    }
    cb.add(
      ")?.let·{ encoder.encodeSerializableElement(__desc, %L, %L, it) }\n",
      valueIdx,
      valueListSer,
    )
    // element sidecars
    cb.add(
      "(value.%N.map·{·it.toElement()·}.takeUnless·{·it.all·{·it == null·}·})?.let·{ encoder.encodeSerializableElement(__desc, %L, %L, it) }\n",
      propertyName,
      elementIdx,
      elementListSer,
    )
  }

  // --- Model construction (JSON decode path) ----------------------------------------------------

  private fun emitModelConstruction(
    className: ClassName,
    elements: List<Element>,
    expandPolymorphic: Boolean,
  ): CodeBlock {
    val helpers = ModelConstructionHelpers(codegenContext)
    val cb = CodeBlock.builder()
    cb.add("%T(\n", className)
    cb.indent()
    elements.forEach { element ->
      cb.add("%N = ", element.getElementName())
      with(helpers) {
        cb.addParamToModelClassConstructor(
          className,
          element,
          expandPolymorphicProperties = expandPolymorphic,
        )
      }
      cb.add(",\n")
    }
    cb.unindent().add(")\n")
    return cb.build()
  }

  // ==============================================================================================
  // Complex type resolution (backbone / content reference / complex)
  // ==============================================================================================

  private fun typeForComplexElement(element: Element, modelClassName: ClassName): ClassName {
    element.getContentReferenceType(modelClassName.packageName)?.let {
      return it as ClassName
    }
    if (element.isBackboneElement()) {
      val simpleNames = element.path.split('.').map { it.capitalized() }
      return ClassName(modelClassName.packageName, simpleNames)
    }
    val typeCode = element.type?.singleOrNull()?.code
    if (typeCode != null) {
      return ClassName(modelClassName.packageName, typeCode.capitalized())
    }
    val simpleNames = element.path.split('.').map { it.capitalized() }
    return ClassName(modelClassName.packageName, simpleNames)
  }
}

/** Returns the [ClassName] for the generated serializer object. */
fun ClassName.toSerializerClassName(): ClassName =
  ClassName("${packageName}.serializers", simpleNames.joinToString("").plus("Serializer"))

private fun ClassName.toSerializerFileSpecBuilder(): FileSpec.Builder =
  FileSpec.builder("${packageName}.serializers", simpleName.plus("Serializers"))
    .addSuppressAnnotation()

// ================================================================================================
// Serializer-expression helpers (shared with callers).
// ================================================================================================

private val stdlibSerializableTypes =
  setOf("String", "Int", "Long", "Double", "Boolean", "Char", "Byte", "Short", "Float")

internal fun serializerForClassName(className: ClassName): CodeBlock =
  if (className.packageName == "kotlin" && stdlibSerializableTypes.contains(className.simpleName)) {
    CodeBlock.of("%T.%M()", className, MemberName(KOTLINX_SERIALIZATION_BUILTINS, "serializer"))
  } else {
    CodeBlock.of("%T.serializer()", className)
  }

internal fun serializerForTypeName(typeName: TypeName): CodeBlock {
  val nonNull = typeName.copy(nullable = false)
  return when (nonNull) {
    is ClassName -> serializerForClassName(nonNull)
    is com.squareup.kotlinpoet.ParameterizedTypeName -> {
      when (nonNull.rawType) {
        ClassName("kotlin.collections", "List"),
        ClassName("kotlin.collections", "MutableList") -> {
          val inner = nonNull.typeArguments.single()
          val innerSer = serializerForTypeName(inner)
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
        }
        else -> serializerForClassName(nonNull.rawType)
      }
    }
    else -> error("Unexpected TypeName: $typeName")
  }
}
