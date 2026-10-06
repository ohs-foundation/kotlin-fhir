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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.terminologies.Currencies
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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MoneySerializer : KSerializer<Money> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Money") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", FhirDecimalSerializer.descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("currency", String.serializer().descriptor)
      optionalElement("_currency", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Money>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Money =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var `value`: FhirDecimal? = null
      var _value: Element? = null
      var currency: String? = null
      var _currency: Element? = null
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
            `value` = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          3 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> currency = decodeStringElement(descriptor, i)
          5 -> _currency = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Money: " + i)
        }
      }
      Money(
        id = id,
        extension = extension ?: listOf(),
        `value` = Decimal.of(`value`, _value),
        currency =
          Enumeration.of(if (currency != null) Currencies.fromCode(currency) else null, _currency),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Money) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, FhirDecimalSerializer, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 3, value.`value`)
      encodeStringIfNotNull(descriptor, 4, value.currency?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.currency)
    }
  }
}
