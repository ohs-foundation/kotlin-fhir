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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Period
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Period) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Period {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var start: String? = null
    var _start: Element? = null
    var end: String? = null
    var _end: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> start = decoder.decodeStringElement(__desc, 2)
        3 -> _start = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.startSer, null)
        4 -> end = decoder.decodeStringElement(__desc, 4)
        5 -> _end = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.startSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Period: " + __i)
      }
    }
    return Period(
      id = id,
      extension = extension ?: listOf(),
      start = DateTime.of(FhirDateTime.fromString(start), _start),
      end = DateTime.of(FhirDateTime.fromString(end), _end),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Period) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.startSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.startSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val startSer: KSerializer<Element> = Element.serializer()
  }
}
