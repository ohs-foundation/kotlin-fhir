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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.MonetaryComponent
import dev.ohs.fhir.model.r5.Money
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

internal object MonetaryComponentSerializer : KSerializer<MonetaryComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonetaryComponent") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", String.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MonetaryComponent>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MonetaryComponent =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var type: String? = null
      var _type: Element? = null
      var code: CodeableConcept? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var amount: Money? = null
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          6 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MonetaryComponent: " + i)
        }
      }
      MonetaryComponent(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) MonetaryComponent.PriceComponentType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on MonetaryComponent"
            ),
        code = code,
        factor = Decimal.of(factor, _factor),
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MonetaryComponent) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 5, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 6, value.factor)
      encodeSerializableIfNotNull(descriptor, 7, MoneySerializer, value.amount)
    }
  }
}
