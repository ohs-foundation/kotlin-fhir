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

import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.terminologies.Currencies
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MoneySerializer : FhirSerializer<Money> {
  override val descriptor: SerialDescriptor = buildDescriptor("Money", this)

  @JvmField internal val listSerializer: KSerializer<List<Money>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.prim("value", FhirDecimalSerializer.descriptor)
    b.strPrim("currency")
  }

  override fun deserialize(decoder: Decoder): Money {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var `value`: FhirDecimal? = null
    var _value: Element? = null
    var currency: Currencies? = null
    var _currency: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        3 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> currency = Currencies.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _currency =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Money(
      id = id,
      extension = listOrEmpty(extension),
      `value` = Decimal.of(`value`, _value),
      currency = Enumeration.of(currency, _currency),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Money) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      2,
      FhirDecimalSerializer,
      value.`value`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.currency?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.currency)
    compositeEncoder.endStructure(descriptor)
  }
}
