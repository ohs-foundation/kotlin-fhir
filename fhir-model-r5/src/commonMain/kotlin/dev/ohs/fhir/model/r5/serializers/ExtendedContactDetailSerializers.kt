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
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.HumanName
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
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

internal object ExtendedContactDetailSerializer : KSerializer<ExtendedContactDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExtendedContactDetail") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "purpose",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "name",
        listSerialDescriptor(lazyDescriptor { HumanName.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "telecom",
        listSerialDescriptor(lazyDescriptor { ContactPoint.serializer().descriptor }),
        isOptional = true,
      )
      element("address", lazyDescriptor { Address.serializer().descriptor }, isOptional = true)
      element(
        "organization",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("period", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<ExtendedContactDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExtendedContactDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ExtendedContactDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ExtendedContactDetail {
    var id: String? = null
    var extension: List<Extension>? = null
    var purpose: CodeableConcept? = null
    var name: List<HumanName>? = null
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
    var organization: Reference? = null
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
        2 ->
          purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        3 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer.listSerializer,
              null,
            )
        4 ->
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        5 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        6 ->
          organization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        7 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ExtendedContactDetail: " + i)
      }
    }
    return ExtendedContactDetail(
      id = id,
      extension = extension ?: listOf(),
      purpose = purpose,
      name = name ?: listOf(),
      telecom = telecom ?: listOf(),
      address = address,
      organization = organization,
      period = period,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ExtendedContactDetail) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    (value.purpose)?.let {
      encoder.encodeSerializableElement(descriptor, 2, CodeableConceptSerializer, it)
    }
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        HumanNameSerializer.listSerializer,
        value.name,
      )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    (value.address)?.let { encoder.encodeSerializableElement(descriptor, 5, AddressSerializer, it) }
    (value.organization)?.let {
      encoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 7, PeriodSerializer, it) }
  }
}
