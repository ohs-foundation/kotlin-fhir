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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.RatioRange
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

internal object RatioRangeSerializer : KSerializer<RatioRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RatioRange") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "lowNumerator",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element(
        "highNumerator",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("denominator", lazyDescriptor { Quantity.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RatioRange =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RatioRange) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RatioRange {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var lowNumerator: Quantity? = null
    var highNumerator: Quantity? = null
    var denominator: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          lowNumerator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lowNumeratorSer, null)
        3 ->
          highNumerator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lowNumeratorSer, null)
        4 ->
          denominator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.lowNumeratorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RatioRange: " + __i)
      }
    }
    return RatioRange(
      id = id,
      extension = extension ?: listOf(),
      lowNumerator = lowNumerator,
      highNumerator = highNumerator,
      denominator = denominator,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RatioRange) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.lowNumerator)?.let {
      encoder.encodeSerializableElement(__desc, 2, Hoisted.lowNumeratorSer, it)
    }
    (value.highNumerator)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.lowNumeratorSer, it)
    }
    (value.denominator)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.lowNumeratorSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val lowNumeratorSer: KSerializer<Quantity> = Quantity.serializer()
  }
}
