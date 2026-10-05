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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object AddressSerializer : KSerializer<Address> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Address") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("line", listSerialDescriptor(KotlinString.serializer().descriptor), isOptional = true)
      element(
        "_line",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("city", KotlinString.serializer().descriptor, isOptional = true)
      element("_city", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("district", KotlinString.serializer().descriptor, isOptional = true)
      element("_district", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("state", KotlinString.serializer().descriptor, isOptional = true)
      element("_state", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("postalCode", KotlinString.serializer().descriptor, isOptional = true)
      element("_postalCode", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("country", KotlinString.serializer().descriptor, isOptional = true)
      element("_country", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Address>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Address =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Address) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Address {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> use = decoder.decodeStringElement(descriptor, i)
        3 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> type = decoder.decodeStringElement(descriptor, i)
        5 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> text = decoder.decodeStringElement(descriptor, i)
        7 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          line =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _line =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 -> city = decoder.decodeStringElement(descriptor, i)
        11 ->
          _city = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 -> district = decoder.decodeStringElement(descriptor, i)
        13 ->
          _district =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> state = decoder.decodeStringElement(descriptor, i)
        15 ->
          _state = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> postalCode = decoder.decodeStringElement(descriptor, i)
        17 ->
          _postalCode =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> country = decoder.decodeStringElement(descriptor, i)
        19 ->
          _country =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Address: " + i)
      }
    }
    return Address(
      id = id,
      extension = extension ?: listOf(),
      use = Enumeration.of(use?.let { Address.AddressUse.fromCode(it) }, _use),
      type = Enumeration.of(type?.let { Address.AddressType.fromCode(it) }, _type),
      text = R5String.of(text, _text),
      line =
        (kotlin.collections.List(maxOf(line?.size ?: 0, _line?.size ?: 0)) { index ->
          R5String.of(line?.getOrNull(index)?.let { it }, _line?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'line' on Address has neither a value nor an id/extension"
            )
        }),
      city = R5String.of(city, _city),
      district = R5String.of(district, _district),
      state = R5String.of(state, _state),
      postalCode = R5String.of(postalCode, _postalCode),
      country = R5String.of(country, _country),
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Address) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    ((value.use?.value?.code))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.use?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, ElementSerializer, it)
    }
    ((value.type?.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.line.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, stringNullableListSerializer, it)
    }
    (value.line.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer.nullableListSerializer, it)
    }
    ((value.city?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.city?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
    ((value.district?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.district?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    ((value.state?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.state?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, ElementSerializer, it)
    }
    ((value.postalCode?.value))?.let { encoder.encodeStringElement(descriptor, 16, it) }
    (value.postalCode?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, ElementSerializer, it)
    }
    ((value.country?.value))?.let { encoder.encodeStringElement(descriptor, 18, it) }
    (value.country?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, ElementSerializer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 20, PeriodSerializer, it) }
  }
}
