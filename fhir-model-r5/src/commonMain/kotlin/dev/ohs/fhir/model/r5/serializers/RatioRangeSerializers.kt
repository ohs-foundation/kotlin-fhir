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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.RatioRange
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object RatioRangeSerializer : KSerializer<RatioRange> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RatioRange") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("lowNumerator", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("highNumerator", lazyDescriptor { QuantitySerializer.descriptor })
      optionalElement("denominator", lazyDescriptor { QuantitySerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<RatioRange>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RatioRange =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var lowNumerator: Quantity? = null
      var highNumerator: Quantity? = null
      var denominator: Quantity? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            lowNumerator =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          3 ->
            highNumerator =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 ->
            denominator = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RatioRange: " + i)
        }
      }
      RatioRange(
        id = id,
        extension = extension ?: listOf(),
        lowNumerator = lowNumerator,
        highNumerator = highNumerator,
        denominator = denominator,
      )
    }

  override fun serialize(encoder: Encoder, `value`: RatioRange) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, QuantitySerializer, value.lowNumerator)
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.highNumerator)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.denominator)
    }
  }
}
