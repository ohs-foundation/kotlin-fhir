/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress("RedundantVisibilityModifier")

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.ExtensibleEnumeration
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.jvm.JvmName
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.CompositeEncoder

internal fun ClassSerialDescriptorBuilder.optionalElement(
  elementName: String,
  descriptor: SerialDescriptor,
) {
  element(elementName, descriptor, isOptional = true)
}

internal val booleanNullableListSerializer: KSerializer<List<Boolean?>> =
  ListSerializer(Boolean.serializer().nullable)

internal val intNullableListSerializer: KSerializer<List<Int?>> =
  ListSerializer(Int.serializer().nullable)

internal val stringNullableListSerializer: KSerializer<List<String?>> =
  ListSerializer(String.serializer().nullable)

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
