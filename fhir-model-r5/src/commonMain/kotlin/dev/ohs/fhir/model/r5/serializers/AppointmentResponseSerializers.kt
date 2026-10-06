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

import dev.ohs.fhir.model.r5.AppointmentResponse
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder

internal object AppointmentResponseSerializer : FhirResourceSerializer<AppointmentResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AppointmentResponse")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("appointment", ReferenceSerializer.descriptor)
    b.optionalElement("proposedNewTime", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_proposedNewTime", ElementSerializer.descriptor)
    b.optionalElement("start", String.serializer().descriptor)
    b.optionalElement("_start", ElementSerializer.descriptor)
    b.optionalElement("end", String.serializer().descriptor)
    b.optionalElement("_end", ElementSerializer.descriptor)
    b.optionalElement("participantType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
    b.optionalElement("participantStatus", String.serializer().descriptor)
    b.optionalElement("_participantStatus", ElementSerializer.descriptor)
    b.optionalElement("comment", String.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("recurring", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_recurring", ElementSerializer.descriptor)
    b.optionalElement("occurrenceDate", String.serializer().descriptor)
    b.optionalElement("_occurrenceDate", ElementSerializer.descriptor)
    b.optionalElement("recurrenceId", Int.serializer().descriptor)
    b.optionalElement("_recurrenceId", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AppointmentResponse {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var appointment: Reference? = null
    var proposedNewTime: KotlinBoolean? = null
    var _proposedNewTime: Element? = null
    var start: String? = null
    var _start: Element? = null
    var end: String? = null
    var _end: Element? = null
    var participantType: List<CodeableConcept>? = null
    var actor: Reference? = null
    var participantStatus: String? = null
    var _participantStatus: Element? = null
    var comment: String? = null
    var _comment: Element? = null
    var recurring: KotlinBoolean? = null
    var _recurring: Element? = null
    var occurrenceDate: String? = null
    var _occurrenceDate: Element? = null
    var recurrenceId: Int? = null
    var _recurrenceId: Element? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          appointment =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        12 -> proposedNewTime = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _proposedNewTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> start = decoder.decodeStringElement(descriptor, i)
        15 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 -> end = decoder.decodeStringElement(descriptor, i)
        17 ->
          _end = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          participantType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          actor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 -> participantStatus = decoder.decodeStringElement(descriptor, i)
        21 ->
          _participantStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> comment = decoder.decodeStringElement(descriptor, i)
        23 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 -> recurring = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _recurring =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> occurrenceDate = decoder.decodeStringElement(descriptor, i)
        27 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> recurrenceId = decoder.decodeIntElement(descriptor, i)
        29 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        else -> throw SerializationException("Unexpected index decoding AppointmentResponse: " + i)
      }
    }
    return AppointmentResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      appointment =
        appointment
          ?: throw SerializationException(
            "Missing required property 'appointment' on AppointmentResponse"
          ),
      proposedNewTime = R5Boolean.of(proposedNewTime, _proposedNewTime),
      start = Instant.of(if (start != null) FhirDateTime.fromString(start) else null, _start),
      end = Instant.of(if (end != null) FhirDateTime.fromString(end) else null, _end),
      participantType = participantType ?: listOf(),
      actor = actor,
      participantStatus =
        Enumeration.of(
          if (participantStatus != null)
            AppointmentResponse.AppointmentResponseStatus.fromCode(participantStatus)
          else null,
          _participantStatus,
        )
          ?: throw SerializationException(
            "Missing required property 'participantStatus' on AppointmentResponse"
          ),
      comment = Markdown.of(comment, _comment),
      recurring = R5Boolean.of(recurring, _recurring),
      occurrenceDate =
        Date.of(
          if (occurrenceDate != null) FhirDate.fromString(occurrenceDate) else null,
          _occurrenceDate,
        ),
      recurrenceId = PositiveInt.of(recurrenceId, _recurrenceId),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AppointmentResponse,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.appointment,
    )
    encoder.encodeBooleanIfNotNull(descriptor, 12 + descriptorOffset, value.proposedNewTime?.value)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.proposedNewTime)
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.start?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.start)
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.end?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.end)
    if (value.participantType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.participantType,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.actor,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.participantStatus.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.participantStatus)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.comment)
    encoder.encodeBooleanIfNotNull(descriptor, 24 + descriptorOffset, value.recurring?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.recurring)
    encoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.occurrenceDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.occurrenceDate)
    encoder.encodeIntIfNotNull(descriptor, 28 + descriptorOffset, value.recurrenceId?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.recurrenceId)
  }
}
