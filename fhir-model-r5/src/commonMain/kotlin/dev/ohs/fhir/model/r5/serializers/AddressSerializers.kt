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
import dev.ohs.fhir.model.r5.terminologies.AddressType
import dev.ohs.fhir.model.r5.terminologies.AddressUse
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object AddressSerializer : FhirSerializer<Address> {
  override val descriptor: SerialDescriptor = buildDescriptor("Address", this)

  @JvmField internal val listSerializer: KSerializer<List<Address>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("use")
    b.strPrim("type")
    b.strPrim("text")
    b.strPrimList("line")
    b.strPrim("city")
    b.strPrim("district")
    b.strPrim("state")
    b.strPrim("postalCode")
    b.strPrim("country")
    b.optionalElement("period", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
  }

  override fun deserialize(decoder: Decoder): Address {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var use: AddressUse? = null
    var _use: Element? = null
    var type: AddressType? = null
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
        2 -> use = AddressUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> type = AddressType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          line =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _line =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 -> city = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _city =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> district = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _district =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> state = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _state =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> postalCode = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _postalCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> country = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _country =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val line_ =
      List(maxSize(line, _line)) { index ->
        entryRequired(R5String.of(at(line, index), at(_line, index)), "Address", "line")
      }
    return Address(
      id = id,
      extension = listOrEmpty(extension),
      use = Enumeration.of(use, _use),
      type = Enumeration.of(type, _type),
      text = R5String.of(text, _text),
      line = line_,
      city = R5String.of(city, _city),
      district = R5String.of(district, _district),
      state = R5String.of(state, _state),
      postalCode = R5String.of(postalCode, _postalCode),
      country = R5String.of(country, _country),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Address) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.use?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.use)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.text)
    if (!value.line.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.line.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.line)
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.city?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.city)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.district?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.district)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.state?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.state)
    compositeEncoder.encodeStringIfNotNull(descriptor, 16, value.postalCode?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.postalCode)
    compositeEncoder.encodeStringIfNotNull(descriptor, 18, value.country?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.country)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 20, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}
