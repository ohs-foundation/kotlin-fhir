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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.terminologies.Currencies
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
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object MoneySerializer : KSerializer<Money> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Money") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("value", BigDecimalSerializer.descriptor, isOptional = true)
      element("_value", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("currency", String.serializer().descriptor, isOptional = true)
      element("_currency", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Money =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Money) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Money {
    var id: String? = null
    var extension: List<Extension>? = null
    var `value`: BigDecimal? = null
    var _value: Element? = null
    var currency: String? = null
    var _currency: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          `value` =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        3 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        4 -> currency = decoder.decodeStringElement(descriptor, i)
        5 ->
          _currency =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Money: " + i)
      }
    }
    return Money(
      id = id,
      extension = extension ?: listOf(),
      `value` = Decimal.of(`value`, _value),
      currency = currency?.let { Enumeration.of(Currencies.fromCode(it), _currency) },
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Money) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.`value`?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 2, BigDecimalSerializer, it)
    }
    (value.`value`?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.valueSer, it)
    }
    ((value.currency?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.currency?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}
