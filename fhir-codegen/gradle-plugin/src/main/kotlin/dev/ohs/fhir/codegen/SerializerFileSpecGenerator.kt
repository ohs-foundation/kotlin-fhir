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
import com.squareup.kotlinpoet.ParameterizedTypeName
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

private val decoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Decoder")
private val encoderClassName = ClassName(KOTLINX_SERIALIZATION_ENCODING, "Encoder")
private val serialDescriptorClassName =
  ClassName(KOTLINX_SERIALIZATION_DESCRIPTORS, "SerialDescriptor")

private val buildClassSerialDescriptorMemberName =
  MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "buildClassSerialDescriptor")
private val decodeStructureMemberName =
  MemberName(KOTLINX_SERIALIZATION_ENCODING, "decodeStructure")
private val encodeStructureMemberName =
  MemberName(KOTLINX_SERIALIZATION_ENCODING, "encodeStructure")
private val compositeDecoderClassName =
  ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeDecoder")
private val listSerializerMemberName = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "ListSerializer")
private val nullableMemberName = MemberName(KOTLINX_SERIALIZATION_BUILTINS, "nullable")

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
    val wireFields = buildJsonWireFields(className, elements)
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
        .addProperty(buildDescriptorProperty(className, wireFields, includeResourceType))
    if (includeResourceType) {
      builder.addFunction(buildBuildDescriptorFun(className, wireFields))
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
          var suffix = 2
          val existingNames = byKey.values.map { it.name }.toSet()
          while (candidate in existingNames) {
            candidate = "$base$suffix"
            suffix++
          }
          Entry(candidate, expression, resultType, deferred)
        }
      return if (deferred) CodeBlock.of("Hoisted.%N", entry.name)
      else CodeBlock.of("%N", entry.name)
    }

    private fun sanitizeName(name: String): String {
      val cleaned = name.replace(Regex("[^A-Za-z0-9]"), "")
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
   * - Choice type (`foo[x]`) → per-expansion pairs (`fooBoolean` + `_fooBoolean`, `fooDateTime` +
   *   `_fooDateTime`, …) expanded directly into the flat wire shape. Encode dispatches via
   *   `emitChoiceTypeExpansionEncoding`; decode reads expansion locals and synthesizes the sealed
   *   value via the companion `from(…)` factory in `emitModelConstruction`.
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
   * on the wire is a separate entry. Choice types expand to per-expansion pairs (`deceasedBoolean`,
   * `_deceasedBoolean`, `deceasedDateTime`, …). Encode writes these slots directly via
   * `emitChoiceTypeExpansionEncoding`; decode reads them into locals and synthesizes the sealed
   * value via the companion `from(…)` factory.
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
   * and choice type expansions). For resource types, `resourceType` is descriptor[0].
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
  private fun buildBuildDescriptorFun(className: ClassName, wireFields: List<WireField>): FunSpec {
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

  private val listDescMemberName =
    MemberName(KOTLINX_SERIALIZATION_DESCRIPTORS, "listSerialDescriptor")

  private fun lazyDescriptorMemberName(className: ClassName): MemberName =
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

  // ==============================================================================================
  // Custom serializer (single-entry) — all 4 methods
  // ==============================================================================================

  // The simpler way to compose the object: emit a TypeSpec whose functions include the branch fn
  // AND the four private helpers. Build them side-by-side.

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
    val nameToIdx: Map<String, CodeBlock> =
      nameToCaseLabel.mapValues { (_, i) ->
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
      buildDeserializeInternalFun(
        className,
        elements,
        wireFields,
        parameterized,
        nameToCaseLabel,
        hoister,
      )
    functions += buildSerializeJsonFun(className, elements, parameterized, nameToIdx, hoister)
    return functions
  }

  // --- JSON decode (streaming) ------------------------------------------------------------------

  /**
   * Emits `private fun deserializeInternal(decoder: CompositeDecoder): X` — a while-loop over
   * `decodeElementIndex(descriptor)` with an index-dispatching `when`. Each case reads one flat
   * wire field via `decodeXxxElement` (specialized) or `decodeNullableSerializableElement` (for
   * complex/list/sidecar types), then the loop terminates on `DECODE_DONE`.
   *
   * After the loop, sealed-type (choice) locals are synthesized from their expansion transients;
   * then the model is constructed from the assembled locals.
   */
  private fun buildDeserializeInternalFun(
    className: ClassName,
    elements: List<Element>,
    wireFields: List<WireField>,
    parameterized: Boolean,
    nameToCaseLabel: Map<String, Int>,
    hoister: SerializerHoister,
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    // One local per flat wire field — choice types expand into per-expansion value+sidecar locals
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
    codeBlock.add(emitModelConstruction(className, elements, expandPolymorphic = true))
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

  // --- JSON encode (streaming) ------------------------------------------------------------------

  /**
   * Emits `private fun serializeInternal(encoder: CompositeEncoder, value: X)` — writes each field
   * directly to the structure encoder via [CompositeEncoder.encodeXxxElement] /
   * [CompositeEncoder.encodeSerializableElement], with no intermediate `JsonObject` tree.
   */
  private fun buildSerializeJsonFun(
    className: ClassName,
    elements: List<Element>,
    parameterized: Boolean,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ): FunSpec {
    val codeBlock = CodeBlock.builder()
    // `resourceType` is written by the outer `serialize` wrapper, not here — keeps this body
    // reusable from `XPolymorphicSerializer` (polymorphic path injects the discriminator itself).
    elements.forEach { element ->
      emitJsonEncodeForElement(codeBlock, element, className, nameToIdx, hoister)
    }
    val builder =
      FunSpec.builder("serializeInternal")
        .addModifiers(if (parameterized) KModifier.INTERNAL else KModifier.PRIVATE)
        .addParameter("encoder", ClassName(KOTLINX_SERIALIZATION_ENCODING, "CompositeEncoder"))
    if (parameterized) {
      builder.addParameter("descriptor", serialDescriptorClassName)
      builder.addParameter("descriptorOffset", Int::class)
    }
    return builder.addParameter("value", className).addCode(codeBlock.build()).build()
  }

  private fun emitJsonEncodeForElement(
    codeBlock: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    // Choice type: emit per-expansion flat keys inline against the parent's composite encoder.
    // Each expansion's value / sidecar is written to a flat descriptor slot on the parent instead
    // of via a nested sub-object — there is no standalone choice-type serializer.
    if (element.type != null && element.type.size > 1) {
      emitChoiceTypeExpansionEncoding(codeBlock, element, modelClassName, nameToIdx, hoister)
      return
    }
    val typeCode = element.type?.singleOrNull()?.code ?: ""
    val isFhirPrimitive = FhirPathType.containsFhirTypeCode(typeCode)
    val isFhirPathUri = FhirPathType.getUris().contains(typeCode)
    if (element.max == "*" || propertyName == "extension") {
      if (isFhirPrimitive) {
        emitJsonEncodePrimitiveList(
          codeBlock,
          element,
          propertyName,
          modelClassName,
          nameToIdx,
          hoister,
        )
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
            CodeBlock.of("%M(%L)", listSerializerMemberName, innerSer),
            "${propertyName}ListSer",
            ClassName("kotlin.collections", "List").parameterizedBy(elemCls),
          )
        codeBlock.add(
          "if (value.%N.isNotEmpty()) encoder.encodeSerializableElement(descriptor, %L, %L, value.%N)\n",
          propertyName,
          idx,
          listSer,
          propertyName,
        )
      }
      return
    }
    if (isFhirPrimitive) {
      emitJsonEncodeSinglePrimitive(
        codeBlock,
        element,
        propertyName,
        modelClassName,
        nameToIdx,
        hoister,
      )
    } else if (isFhirPathUri) {
      val kotlinType =
        FhirPathType.getFromUri(typeCode)!!.getTypeInModelClass(modelClassName.packageName)
      val idx = nameToIdx.getValue(propertyName)
      emitPrimitiveOrSerializableEncode(
        codeBlock,
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
      codeBlock.add(
        "(value.%N)?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
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
    codeBlock: CodeBlock.Builder,
    encoderExpr: String,
    idx: CodeBlock,
    type: ClassName,
    valueExpr: CodeBlock,
    parentClass: ClassName,
    hoister: SerializerHoister,
    nameHint: String,
  ) {
    val specialized = specializedEncodeElementCall(type)
    if (specialized != null) {
      codeBlock.add(
        "(%L)?.let·{ %N.%N(descriptor, %L, it) }\n",
        valueExpr,
        encoderExpr,
        specialized,
        idx,
      )
      return
    }
    val ser = hoistedSerializerForClass(type, parentClass, hoister, nameHint)
    codeBlock.add(
      "(%L)?.let·{ %N.encodeSerializableElement(descriptor, %L, %L, it) }\n",
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
   * Emits the full `when (val choice = value.field) { is Arm -> … }` dispatch for a choice-type
   * element, writing each expansion's flat wire keys (e.g., `deceasedBoolean` + `_deceasedBoolean`)
   * directly into the parent's composite encoder using its flat descriptor slots. Replaces the old
   * "encode nested via sealed serializer, then flatten" pipeline.
   */
  private fun emitChoiceTypeExpansionEncoding(
    codeBlock: CodeBlock.Builder,
    element: Element,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val propertyName = element.getElementName()
    val sealedTypeClass = ClassName(modelClassName.packageName, element.getPathSimpleNames())
    codeBlock.add("when (val choice = value.%N) {\n", propertyName)
    codeBlock.indent()
    codeBlock.add("null -> {}\n")
    for (type in element.type!!) {
      val expansionClassName = sealedTypeClass.nestedClass(choiceTypeExpansionName(type))
      val expansionBaseName = "$propertyName${type.code.capitalized()}"
      codeBlock.add("is %T -> {\n", expansionClassName)
      codeBlock.indent()
      emitJsonEncodeChoiceTypeExpansion(
        codeBlock,
        type,
        expansionBaseName,
        modelClassName,
        nameToIdx,
        hoister,
      )
      codeBlock.unindent()
      codeBlock.add("}\n")
    }
    codeBlock.unindent()
    codeBlock.add("}\n")
  }

  /**
   * Writes both expansion keys (`deceasedBoolean` + `_deceasedBoolean`) for a matched choice type
   * expansion.
   */
  private fun emitJsonEncodeChoiceTypeExpansion(
    codeBlock: CodeBlock.Builder,
    type: Type,
    choiceFieldBaseName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = type.code
    val valueIdx = nameToIdx.getValue(choiceFieldBaseName)
    val elementIdx = nameToIdx["_$choiceFieldBaseName"]
    if (FhirPathType.containsFhirTypeCode(typeCode)) {
      val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
      val primClassName = fhirPathType.wireType
      // Value expansion
      val valueExpr =
        CodeBlock.builder()
          .apply {
            add("(choice.value")
            fhirPathType.addCodeToEncodeModelToWire(this)
            add(")")
          }
          .build()
      emitPrimitiveOrSerializableEncode(
        codeBlock,
        "encoder",
        valueIdx,
        primClassName,
        valueExpr,
        modelClassName,
        hoister,
        "${choiceFieldBaseName}Ser",
      )
      // Sidecar expansion
      if (elementIdx != null) {
        val elementClassName = ClassName(modelClassName.packageName, "Element")
        val elementSer =
          hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
        codeBlock.add(
          "(choice.value.toElement())?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
          elementIdx,
          elementSer,
        )
      }
    } else {
      // Complex expansion — e.g. Annotation.authorReference
      val complexClassName = ClassName(modelClassName.packageName, typeCode.capitalized())
      val complexSer =
        hoistedSerializerForClass(
          complexClassName,
          modelClassName,
          hoister,
          "${complexClassName.simpleName.lowercase()}Ser",
        )
      codeBlock.add(
        "encoder.encodeSerializableElement(descriptor, %L, %L, choice.value)\n",
        valueIdx,
        complexSer,
      )
    }
  }

  private fun emitJsonEncodeSinglePrimitive(
    codeBlock: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val isRequired = element.min == 1 && element.max == "1"
    val surrClassName: ClassName = fhirPathType.wireType
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueType: ClassName = if (isEnum) String::class.asClassName() else surrClassName
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
            fhirPathType.addCodeToEncodeModelToWire(this)
          }
          add(")")
        }
        .build()
    emitPrimitiveOrSerializableEncode(
      codeBlock,
      "encoder",
      valueIdx,
      valueType,
      valueExpr,
      modelClassName,
      hoister,
      "${propertyName}Ser",
    )
    val elementClassName = ClassName(modelClassName.packageName, "Element")
    val elementSer =
      hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
    codeBlock.add("(value.%N", propertyName)
    if (!isRequired) codeBlock.add("?")
    codeBlock.add(
      ".toElement())?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
      elementIdx,
      elementSer,
    )
  }

  private fun emitJsonEncodePrimitiveList(
    codeBlock: CodeBlock.Builder,
    element: Element,
    propertyName: String,
    modelClassName: ClassName,
    nameToIdx: Map<String, CodeBlock>,
    hoister: SerializerHoister,
  ) {
    val typeCode = element.type!!.single().code
    val fhirPathType = FhirPathType.getFromFhirTypeCode(typeCode)!!
    val isEnum = element.typeIsEnumeratedCode(codegenContext.valueSetMap)
    val surrClassName: ClassName = fhirPathType.wireType
    val valueIdx = nameToIdx.getValue(propertyName)
    val elementIdx = nameToIdx.getValue("_$propertyName")
    val valueInnerType: ClassName = if (isEnum) String::class.asClassName() else surrClassName
    val valueInnerSer =
      if (isEnum)
        hoistedSerializerForClass(String::class.asClassName(), modelClassName, hoister, "stringSer")
      else
        customSerializerFor(surrClassName, modelClassName)?.let { CodeBlock.of("%T", it) }
          ?: hoistedSerializerForClass(
            surrClassName,
            modelClassName,
            hoister,
            "${surrClassName.simpleName.lowercase()}Ser",
          )
    val listOfNullableType: (ClassName) -> TypeName = { inner ->
      ClassName("kotlin.collections", "List").parameterizedBy(inner.copy(nullable = true))
    }
    val valueListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMemberName, valueInnerSer, nullableMemberName),
        "${propertyName}ListSer",
        listOfNullableType(valueInnerType),
      )
    val elementClassName = ClassName(modelClassName.packageName, "Element")
    val elementSer =
      hoistedSerializerForClass(elementClassName, modelClassName, hoister, "elementSer")
    val elementListSer =
      hoister.refLazy(
        CodeBlock.of("%M((%L).%M)", listSerializerMemberName, elementSer, nullableMemberName),
        "_${propertyName}ListSer",
        listOfNullableType(elementClassName),
      )
    // values
    codeBlock.add("(")
    if (isEnum) {
      codeBlock.add(
        "value.%N.map·{·it.value?.getCode()·}.takeUnless·{·it.all·{·it == null·}·}",
        propertyName,
      )
    } else {
      codeBlock.add("value.%N.map·{·it", propertyName)
      fhirPathType.addCodeToEncodeModelToWire(codeBlock)
      codeBlock.add("·}.takeUnless·{·it.all·{·it == null·}·}")
    }
    codeBlock.add(
      ")?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
      valueIdx,
      valueListSer,
    )
    // element sidecars
    codeBlock.add(
      "(value.%N.map·{·it.toElement()·}.takeUnless·{·it.all·{·it == null·}·})?.let·{ encoder.encodeSerializableElement(descriptor, %L, %L, it) }\n",
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
    val codeBlock = CodeBlock.builder()
    codeBlock.add("%T(\n", className)
    codeBlock.indent()
    elements.forEach { element ->
      codeBlock.add("%N = ", element.getElementName())
      with(helpers) {
        codeBlock.addParamToModelClassConstructor(
          className,
          element,
          expandPolymorphicProperties = expandPolymorphic,
        )
      }
      codeBlock.add(",\n")
    }
    codeBlock.unindent().add(")\n")
    return codeBlock.build()
  }

  // ==============================================================================================
  // Complex type resolution (backbone / content reference / complex)
  // ==============================================================================================

  private fun typeForComplexElement(element: Element, modelClassName: ClassName): ClassName {
    element.getContentReferenceType(modelClassName.packageName)?.let {
      return it
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
    is ParameterizedTypeName -> {
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
