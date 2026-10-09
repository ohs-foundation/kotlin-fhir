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

import java.io.File

/**
 * Emits `SerializerHelpers.kt`, the hand-written-style support file every generated serializer
 * leans on: the `FhirSerializer` interface and `buildDescriptor` entry point, cached primitive and
 * lazy `Element` descriptors, the `str` / `prim` / `primList` descriptor registration helpers,
 * nullable primitive list serializers, `CompositeEncoder` helpers, and the branch-free decode
 * helpers (`listOrEmpty`, `required`, `entryRequired`, `at`, `maxSize`, `unknownIndex`).
 */
object SerializerHelpersFileSpecGenerator {
  fun writeTo(outputDir: File, serializersPackageName: String) {
    val modelPackageName = serializersPackageName.substringBeforeLast('.')
    val packagePath = serializersPackageName.replace('.', '/')
    val target = File(outputDir, "$packagePath/SerializerHelpers.kt")
    target.parentFile.mkdirs()
    target.writeText(
      """
@file:Suppress("RedundantVisibilityModifier")
@file:OptIn(ExperimentalSerializationApi::class)

package $serializersPackageName

import $modelPackageName.Element
import $modelPackageName.ExtensibleEnumeration
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeEncoder

/**
 * Common supertype of all generated streaming serializers. [buildDescriptor] registers the flat
 * wire-shape elements on a [ClassSerialDescriptorBuilder]; keeping it as a virtual method (rather
 * than a per-serializer lambda) avoids an `invokedynamic` site and bootstrap entry in every
 * generated serializer class.
 */
internal interface FhirSerializer<T> : KSerializer<T> {
  public fun buildDescriptor(b: ClassSerialDescriptorBuilder)
}

/** Builds the class descriptor for a non-resource [FhirSerializer]. */
internal fun buildDescriptor(serialName: String, serializer: FhirSerializer<*>): SerialDescriptor =
  buildClassSerialDescriptor(serialName) { serializer.buildDescriptor(this) }

@JvmField internal val stringDescriptor: SerialDescriptor = String.serializer().descriptor

@JvmField internal val booleanDescriptor: SerialDescriptor = Boolean.serializer().descriptor

@JvmField internal val intDescriptor: SerialDescriptor = Int.serializer().descriptor

@JvmField
internal val booleanNullableListSerializer: KSerializer<List<Boolean?>> =
  ListSerializer(Boolean.serializer().nullable)

@JvmField
internal val intNullableListSerializer: KSerializer<List<Int?>> =
  ListSerializer(Int.serializer().nullable)

@JvmField
internal val stringNullableListSerializer: KSerializer<List<String?>> =
  ListSerializer(String.serializer().nullable)

/**
 * Descriptor of the `_field` companion `Element` carrying id/extensions for a primitive. Resolved
 * lazily so that referencing it from a serializer's initializer never triggers `ElementSerializer`
 * class initialization (which would recurse into `ExtensionSerializer` and back). Nothing in this
 * file's own initializer may read through it either: `ElementSerializer`'s initializer calls back
 * into this file (`buildDescriptor`, `str`), so eagerly resolving it here would create a two-way
 * class-initialization cycle.
 */
@JvmField
internal val lazyElementDescriptor: SerialDescriptor =
  lazyDescriptor(LazyDescriptorId.ElementSerializer)

/**
 * Descriptor of the `_field` companion list (`List<Element?>`) for a repeating primitive. The
 * element descriptor is deliberately NOT wrapped with `.nullable`: that wrapper reads
 * `serialName` / `isNullable` from the delegate eagerly, which would resolve `ElementSerializer`
 * during this file's initialization. kotlinx-json never inspects nested list-element nullability,
 * so the non-nullable element descriptor is wire-equivalent (and matches what cyclic references
 * always used).
 */
@JvmField
internal val lazyElementListDescriptor: SerialDescriptor =
  listSerialDescriptor(lazyElementDescriptor)

internal fun ClassSerialDescriptorBuilder.optionalElement(
  elementName: String,
  descriptor: SerialDescriptor,
) {
  element(elementName, descriptor, isOptional = true)
}

internal fun ClassSerialDescriptorBuilder.str(elementName: String) {
  element(elementName, stringDescriptor, isOptional = true)
}

/** Registers `name` (with [valueDescriptor]) and its `_name` companion `Element` slot. */
internal fun ClassSerialDescriptorBuilder.prim(elementName: String, valueDescriptor: SerialDescriptor) {
  element(elementName, valueDescriptor, isOptional = true)
  element("_" + elementName, lazyElementDescriptor, isOptional = true)
}

internal fun ClassSerialDescriptorBuilder.strPrim(elementName: String) {
  prim(elementName, stringDescriptor)
}

internal fun ClassSerialDescriptorBuilder.boolPrim(elementName: String) {
  prim(elementName, booleanDescriptor)
}

internal fun ClassSerialDescriptorBuilder.intPrim(elementName: String) {
  prim(elementName, intDescriptor)
}

/** Registers a repeating primitive: `name` (with [valueListDescriptor]) and its `_name` list. */
internal fun ClassSerialDescriptorBuilder.primList(
  elementName: String,
  valueListDescriptor: SerialDescriptor,
) {
  element(elementName, valueListDescriptor, isOptional = true)
  element("_" + elementName, lazyElementListDescriptor, isOptional = true)
}

internal fun ClassSerialDescriptorBuilder.strPrimList(elementName: String) {
  primList(elementName, stringNullableListSerializer.descriptor)
}

internal fun ClassSerialDescriptorBuilder.boolPrimList(elementName: String) {
  primList(elementName, booleanNullableListSerializer.descriptor)
}

internal fun ClassSerialDescriptorBuilder.intPrimList(elementName: String) {
  primList(elementName, intNullableListSerializer.descriptor)
}

// ── Decode-side helpers ─────────────────────────────────────────────────────────────────────────
//
// These exist so that the generated `return Model(...)` expression contains no branches: a branch
// evaluated while earlier constructor arguments sit on the operand stack forces the JVM to emit a
// `full_frame` stack-map entry listing every local of the (very large) deserialize method.

internal fun <T> listOrEmpty(list: List<T>?): List<T> = list ?: emptyList()

internal fun <T : Any> required(value: T?, model: String, name: String): T =
  value ?: throw SerializationException("Missing required property '${'$'}name' on ${'$'}model")

internal fun <T : Any> entryRequired(value: T?, model: String, name: String): T =
  value
    ?: throw SerializationException(
      "An entry of '${'$'}name' on ${'$'}model has neither a value nor an id/extension"
    )

internal fun <T> at(list: List<T>?, index: Int): T? = list?.getOrNull(index)

/** Thrown from the decode loop's `else` branch; shared so no serializer carries its own message. */
internal fun unknownIndex(descriptor: SerialDescriptor, index: Int): Nothing =
  throw SerializationException(
    "Unexpected index decoding ${'$'}{descriptor.serialName}: ${'$'}index"
  )

internal fun maxSize(a: List<*>?, b: List<*>?): Int = maxOf(a?.size ?: 0, b?.size ?: 0)

// ── Encode-side helpers ─────────────────────────────────────────────────────────────────────────

internal fun CompositeEncoder.encodeStringIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  value: String?,
) {
  if (value != null) encodeStringElement(descriptor, index, value)
}

internal fun CompositeEncoder.encodeBooleanIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  value: Boolean?,
) {
  if (value != null) encodeBooleanElement(descriptor, index, value)
}

internal fun CompositeEncoder.encodeIntIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  value: Int?,
) {
  if (value != null) encodeIntElement(descriptor, index, value)
}

internal fun <T : Any> CompositeEncoder.encodeSerializableIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  serializer: SerializationStrategy<T>,
  value: T?,
) {
  if (value != null) encodeSerializableElement(descriptor, index, serializer, value)
}

internal fun <T> CompositeEncoder.encodeListIfNotEmpty(
  descriptor: SerialDescriptor,
  index: Int,
  serializer: SerializationStrategy<List<T>>,
  values: List<T>,
) {
  if (!values.isEmpty()) encodeSerializableElement(descriptor, index, serializer, values)
}

internal fun CompositeEncoder.encodeElementIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  element: Element?,
) {
  if (element != null && (element.id != null || element.extension.isNotEmpty())) {
    encodeSerializableElement(
      descriptor,
      index,
      ElementSerializer,
      Element(element.id, element.extension),
    )
  }
}

internal fun CompositeEncoder.encodeElementIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  element: ExtensibleEnumeration<*>?,
) {
  val e = element?.toElement()
  if (e != null) {
    encodeSerializableElement(descriptor, index, ElementSerializer, e)
  }
}

internal fun <T : Any> CompositeEncoder.encodeNullableListIfNotNull(
  descriptor: SerialDescriptor,
  index: Int,
  serializer: SerializationStrategy<List<T?>>,
  values: List<T?>,
) {
  if (values.any { it != null }) {
    encodeSerializableElement(descriptor, index, serializer, values)
  }
}

internal fun CompositeEncoder.encodePrimitiveElementList(
  descriptor: SerialDescriptor,
  index: Int,
  elements: List<Element>,
) {
  if (elements.any { it.id != null || it.extension.isNotEmpty() }) {
    encodeSerializableElement(
      descriptor,
      index,
      ElementSerializer.nullableListSerializer,
      elements.map {
        if (it.id != null || it.extension.isNotEmpty()) Element(it.id, it.extension) else null
      },
    )
  }
}

@JvmName("encodeExtensiblePrimitiveElementList")
internal fun CompositeEncoder.encodePrimitiveElementList(
  descriptor: SerialDescriptor,
  index: Int,
  elements: List<ExtensibleEnumeration<*>>,
) {
  if (elements.any { it.id != null || it.extension.isNotEmpty() }) {
    encodeSerializableElement(
      descriptor,
      index,
      ElementSerializer.nullableListSerializer,
      elements.map { it.toElement() },
    )
  }
}
"""
        .trimStart()
    )
  }
}
