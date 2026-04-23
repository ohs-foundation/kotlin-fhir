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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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

internal object AppointmentResponseSerializer : KSerializer<AppointmentResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AppointmentResponse") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("appointment", Reference.serializer().descriptor, isOptional = true)
      element("proposedNewTime", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_proposedNewTime", Element.serializer().descriptor, isOptional = true)
      element("start", String.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("end", String.serializer().descriptor, isOptional = true)
      element("_end", Element.serializer().descriptor, isOptional = true)
      element(
        "participantType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("actor", Reference.serializer().descriptor, isOptional = true)
      element("participantStatus", String.serializer().descriptor, isOptional = true)
      element("_participantStatus", Element.serializer().descriptor, isOptional = true)
      element("comment", String.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("recurring", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_recurring", Element.serializer().descriptor, isOptional = true)
      element("occurrenceDate", String.serializer().descriptor, isOptional = true)
      element("_occurrenceDate", Element.serializer().descriptor, isOptional = true)
      element("recurrenceId", Int.serializer().descriptor, isOptional = true)
      element("_recurrenceId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AppointmentResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AppointmentResponse) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): AppointmentResponse {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 ->
          appointment =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.appointmentSer, null)
        13 -> proposedNewTime = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _proposedNewTime =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> start = decoder.decodeStringElement(__desc, 15)
        16 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 -> end = decoder.decodeStringElement(__desc, 17)
        18 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          participantType =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.participantTypeSer, null)
        20 ->
          actor =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.appointmentSer, null)
        21 -> participantStatus = decoder.decodeStringElement(__desc, 21)
        22 ->
          _participantStatus =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> comment = decoder.decodeStringElement(__desc, 23)
        24 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 -> recurring = decoder.decodeBooleanElement(__desc, 25)
        26 ->
          _recurring =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 -> occurrenceDate = decoder.decodeStringElement(__desc, 27)
        28 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.implicitRulesSer, null)
        29 -> recurrenceId = decoder.decodeIntElement(__desc, 29)
        30 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding AppointmentResponse: " + __i)
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
      appointment = appointment!!,
      proposedNewTime = R5Boolean.of(proposedNewTime, _proposedNewTime),
      start = Instant.of(FhirDateTime.fromString(start), _start),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      participantType = participantType ?: listOf(),
      actor = actor,
      participantStatus =
        Enumeration.of(
          AppointmentResponse.AppointmentResponseStatus.fromCode(participantStatus!!),
          _participantStatus,
        ),
      comment = Markdown.of(comment, _comment),
      recurring = R5Boolean.of(recurring, _recurring),
      occurrenceDate = Date.of(FhirDate.fromString(occurrenceDate), _occurrenceDate),
      recurrenceId = PositiveInt.of(recurrenceId, _recurrenceId),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: AppointmentResponse) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "AppointmentResponse")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.appointment)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.appointmentSer, it)
    }
    ((value.proposedNewTime?.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.proposedNewTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.participantType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.participantTypeSer,
        value.participantType,
      )
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.appointmentSer, it) }
    ((value.participantStatus.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 21, it)
    }
    (value.participantStatus.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    ((value.recurring?.value))?.let { encoder.encodeBooleanElement(__desc, 25, it) }
    (value.recurring?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    ((value.occurrenceDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 27, it) }
    (value.occurrenceDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.implicitRulesSer, it)
    }
    ((value.recurrenceId?.value))?.let { encoder.encodeIntElement(__desc, 29, it) }
    (value.recurrenceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val appointmentSer: KSerializer<Reference> = Reference.serializer()

    public val participantTypeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val participantTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.participantTypeSerInner)
  }
}
