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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.MarketingStatus
import dev.ohs.fhir.model.r4b.Period
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

internal object MarketingStatusSerializer : KSerializer<MarketingStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MarketingStatus") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("dateRange", PeriodSerializer.descriptor)
      optionalElement("restoreDate", String.serializer().descriptor)
      optionalElement("_restoreDate", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MarketingStatus>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MarketingStatus =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var country: CodeableConcept? = null
      var jurisdiction: CodeableConcept? = null
      var status: CodeableConcept? = null
      var dateRange: Period? = null
      var restoreDate: String? = null
      var _restoreDate: Element? = null
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            country =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            jurisdiction =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> dateRange = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          7 -> restoreDate = decodeStringElement(descriptor, i)
          8 ->
            _restoreDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MarketingStatus: " + i)
        }
      }
      MarketingStatus(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        country = country,
        jurisdiction = jurisdiction,
        status =
          status
            ?: throw SerializationException(
              "Missing required property 'status' on MarketingStatus"
            ),
        dateRange = dateRange,
        restoreDate =
          DateTime.of(
            if (restoreDate != null) FhirDateTime.fromString(restoreDate) else null,
            _restoreDate,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MarketingStatus) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.country)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.jurisdiction)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.status)
      encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.dateRange)
      encodeStringIfNotNull(descriptor, 7, value.restoreDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.restoreDate)
    }
  }
}
