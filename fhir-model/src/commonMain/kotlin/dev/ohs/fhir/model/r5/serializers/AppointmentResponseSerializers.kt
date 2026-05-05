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
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("appointment", Reference.serializer().descriptor, isOptional = true)
    b.element("proposedNewTime", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_proposedNewTime", Element.serializer().descriptor, isOptional = true)
    b.element("start", String.serializer().descriptor, isOptional = true)
    b.element("_start", Element.serializer().descriptor, isOptional = true)
    b.element("end", String.serializer().descriptor, isOptional = true)
    b.element("_end", Element.serializer().descriptor, isOptional = true)
    b.element(
      "participantType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("actor", Reference.serializer().descriptor, isOptional = true)
    b.element("participantStatus", String.serializer().descriptor, isOptional = true)
    b.element("_participantStatus", Element.serializer().descriptor, isOptional = true)
    b.element("comment", String.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element("recurring", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_recurring", Element.serializer().descriptor, isOptional = true)
    b.element("occurrenceDate", String.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDate", Element.serializer().descriptor, isOptional = true)
    b.element("recurrenceId", Int.serializer().descriptor, isOptional = true)
    b.element("_recurrenceId", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): AppointmentResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: AppointmentResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AppointmentResponse")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): AppointmentResponse {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          appointment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.appointmentSer, null)
        12 -> proposedNewTime = decoder.decodeBooleanElement(__desc, __i)
        13 ->
          _proposedNewTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        14 -> start = decoder.decodeStringElement(__desc, __i)
        15 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 -> end = decoder.decodeStringElement(__desc, __i)
        17 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 ->
          participantType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.participantTypeSer, null)
        19 ->
          actor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.appointmentSer, null)
        20 -> participantStatus = decoder.decodeStringElement(__desc, __i)
        21 ->
          _participantStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 -> comment = decoder.decodeStringElement(__desc, __i)
        23 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 -> recurring = decoder.decodeBooleanElement(__desc, __i)
        25 ->
          _recurring =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 -> occurrenceDate = decoder.decodeStringElement(__desc, __i)
        27 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        28 -> recurrenceId = decoder.decodeIntElement(__desc, __i)
        29 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: AppointmentResponse,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.appointment)?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.appointmentSer, it)
    }
    ((value.proposedNewTime?.value))?.let { encoder.encodeBooleanElement(__desc, 12 + __off, it) }
    (value.proposedNewTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16 + __off, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.participantType.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        18 + __off,
        Hoisted.participantTypeSer,
        value.participantType,
      )
    (value.actor)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.appointmentSer, it)
    }
    ((value.participantStatus.value?.getCode()))?.let {
      encoder.encodeStringElement(__desc, 20 + __off, it)
    }
    (value.participantStatus.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 22 + __off, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.recurring?.value))?.let { encoder.encodeBooleanElement(__desc, 24 + __off, it) }
    (value.recurring?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.occurrenceDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 26 + __off, it)
    }
    (value.occurrenceDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.recurrenceId?.value))?.let { encoder.encodeIntElement(__desc, 28 + __off, it) }
    (value.recurrenceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.implicitRulesSer, it)
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

internal object AppointmentResponsePolymorphicSerializer : KSerializer<AppointmentResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AppointmentResponse") {
      AppointmentResponseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: AppointmentResponse) {
    encoder.encodeStructure(descriptor) {
      AppointmentResponseSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AppointmentResponse =
    decoder.decodeStructure(descriptor) {
      AppointmentResponseSerializer.deserializeJson(this, descriptor, 0)
    }
}
