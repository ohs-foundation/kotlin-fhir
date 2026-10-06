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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ExtendedContactDetailSerializer : KSerializer<ExtendedContactDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ExtendedContactDetail") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("purpose", CodeableConceptSerializer.descriptor)
      optionalElement("name", HumanNameSerializer.listSerializer.descriptor)
      optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
      optionalElement("address", AddressSerializer.descriptor)
      optionalElement("organization", ReferenceSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExtendedContactDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExtendedContactDetail =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var purpose: CodeableConcept? = null
      var name: List<HumanName>? = null
      var telecom: List<ContactPoint>? = null
      var address: Address? = null
      var organization: Reference? = null
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
          2 ->
            purpose =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          3 ->
            name =
              decodeNullableSerializableElement(
                descriptor,
                i,
                HumanNameSerializer.listSerializer,
                null,
              )
          4 ->
            telecom =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContactPointSerializer.listSerializer,
                null,
              )
          5 -> address = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          6 ->
            organization =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ExtendedContactDetail: " + i)
        }
      }
      ExtendedContactDetail(
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

  override fun serialize(encoder: Encoder, `value`: ExtendedContactDetail) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeSerializableIfNotNull(descriptor, 2, CodeableConceptSerializer, value.purpose)
      if (value.name.isNotEmpty())
        encodeSerializableElement(descriptor, 3, HumanNameSerializer.listSerializer, value.name)
      if (value.telecom.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ContactPointSerializer.listSerializer,
          value.telecom,
        )
      encodeSerializableIfNotNull(descriptor, 5, AddressSerializer, value.address)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.organization)
      encodeSerializableIfNotNull(descriptor, 7, PeriodSerializer, value.period)
    }
  }
}
