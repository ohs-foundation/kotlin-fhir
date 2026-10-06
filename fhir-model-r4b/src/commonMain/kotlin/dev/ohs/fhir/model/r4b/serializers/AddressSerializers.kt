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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.String as R4bString
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object AddressSerializer : KSerializer<Address> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Address") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("line", stringNullableListSerializer.descriptor)
      optionalElement("_line", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("city", KotlinString.serializer().descriptor)
      optionalElement("_city", ElementSerializer.descriptor)
      optionalElement("district", KotlinString.serializer().descriptor)
      optionalElement("_district", ElementSerializer.descriptor)
      optionalElement("state", KotlinString.serializer().descriptor)
      optionalElement("_state", ElementSerializer.descriptor)
      optionalElement("postalCode", KotlinString.serializer().descriptor)
      optionalElement("_postalCode", ElementSerializer.descriptor)
      optionalElement("country", KotlinString.serializer().descriptor)
      optionalElement("_country", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Address>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Address =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var use: KotlinString? = null
      var _use: Element? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var text: KotlinString? = null
      var _text: Element? = null
      var line: List<KotlinString?>? = null
      var _line: List<Element?>? = null
      var city: KotlinString? = null
      var _city: Element? = null
      var district: KotlinString? = null
      var _district: Element? = null
      var state: KotlinString? = null
      var _state: Element? = null
      var postalCode: KotlinString? = null
      var _postalCode: Element? = null
      var country: KotlinString? = null
      var _country: Element? = null
      var period: Period? = null
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
          2 -> use = decodeStringElement(descriptor, i)
          3 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> type = decodeStringElement(descriptor, i)
          5 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> text = decodeStringElement(descriptor, i)
          7 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            line =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _line =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 -> city = decodeStringElement(descriptor, i)
          11 -> _city = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> district = decodeStringElement(descriptor, i)
          13 ->
            _district = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> state = decodeStringElement(descriptor, i)
          15 -> _state = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> postalCode = decodeStringElement(descriptor, i)
          17 ->
            _postalCode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> country = decodeStringElement(descriptor, i)
          19 -> _country = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Address: " + i)
        }
      }
      Address(
        id = id,
        extension = extension ?: listOf(),
        use = Enumeration.of(if (use != null) Address.AddressUse.fromCode(use) else null, _use),
        type =
          Enumeration.of(if (type != null) Address.AddressType.fromCode(type) else null, _type),
        text = R4bString.of(text, _text),
        line =
          (kotlin.collections.List(maxOf(line?.size ?: 0, _line?.size ?: 0)) { index ->
            R4bString.of(line?.getOrNull(index), _line?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'line' on Address has neither a value nor an id/extension"
              )
          }),
        city = R4bString.of(city, _city),
        district = R4bString.of(district, _district),
        state = R4bString.of(state, _state),
        postalCode = R4bString.of(postalCode, _postalCode),
        country = R4bString.of(country, _country),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Address) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.use?.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.use)
      encodeStringIfNotNull(descriptor, 4, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.type)
      encodeStringIfNotNull(descriptor, 6, value.text?.value)
      encodeElementIfNotNull(descriptor, 7, value.text)
      if (value.line.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.line.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 9, value.line)
      }
      encodeStringIfNotNull(descriptor, 10, value.city?.value)
      encodeElementIfNotNull(descriptor, 11, value.city)
      encodeStringIfNotNull(descriptor, 12, value.district?.value)
      encodeElementIfNotNull(descriptor, 13, value.district)
      encodeStringIfNotNull(descriptor, 14, value.state?.value)
      encodeElementIfNotNull(descriptor, 15, value.state)
      encodeStringIfNotNull(descriptor, 16, value.postalCode?.value)
      encodeElementIfNotNull(descriptor, 17, value.postalCode)
      encodeStringIfNotNull(descriptor, 18, value.country?.value)
      encodeElementIfNotNull(descriptor, 19, value.country)
      encodeSerializableIfNotNull(descriptor, 20, PeriodSerializer, value.period)
    }
  }
}
