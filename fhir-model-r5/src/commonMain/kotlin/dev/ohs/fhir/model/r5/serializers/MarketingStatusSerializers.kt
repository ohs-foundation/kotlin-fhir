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
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.MarketingStatus
import dev.ohs.fhir.model.r5.Period
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

internal object MarketingStatusSerializer : KSerializer<MarketingStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MarketingStatus") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("country", CodeableConcept.serializer().descriptor, isOptional = true)
      element("jurisdiction", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("dateRange", Period.serializer().descriptor, isOptional = true)
      element("restoreDate", String.serializer().descriptor, isOptional = true)
      element("_restoreDate", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MarketingStatus =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MarketingStatus) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MarketingStatus {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          country =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        5 ->
          status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        6 ->
          dateRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dateRangeSer, null)
        7 -> restoreDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _restoreDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.restoreDateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MarketingStatus: " + i)
      }
    }
    return MarketingStatus(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      country = country,
      jurisdiction = jurisdiction,
      status = status!!,
      dateRange = dateRange,
      restoreDate = DateTime.of(FhirDateTime.fromString(restoreDate), _restoreDate),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MarketingStatus) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.country)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.countrySer, it)
    }
    (value.jurisdiction)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.countrySer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.countrySer, value.status)
    (value.dateRange)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.dateRangeSer, it)
    }
    ((value.restoreDate?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.restoreDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.restoreDateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val countrySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val dateRangeSer: KSerializer<Period> = Period.serializer()

    public val restoreDateSer: KSerializer<Element> = Element.serializer()
  }
}
