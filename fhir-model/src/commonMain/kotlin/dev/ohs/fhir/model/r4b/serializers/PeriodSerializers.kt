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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Period
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object PeriodSerializer : KSerializer<Period> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Period") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("start", String.serializer().descriptor, isOptional = true)
      element("_start", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("end", String.serializer().descriptor, isOptional = true)
      element("_end", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Period =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Period) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Period {
    var id: String? = null
    var extension: List<Extension>? = null
    var start: String? = null
    var _start: Element? = null
    var end: String? = null
    var _end: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> start = decoder.decodeStringElement(descriptor, i)
        3 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        4 -> end = decoder.decodeStringElement(descriptor, i)
        5 -> _end = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Period: " + i)
      }
    }
    return Period(
      id = id,
      extension = extension ?: listOf(),
      start = DateTime.of(FhirDateTime.fromString(start), _start),
      end = DateTime.of(FhirDateTime.fromString(end), _end),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Period) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.startSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.startSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val startSer: KSerializer<Element> = Element.serializer()
  }
}
