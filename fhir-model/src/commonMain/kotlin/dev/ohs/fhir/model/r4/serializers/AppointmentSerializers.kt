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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Appointment
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String as KotlinString
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

internal object AppointmentParticipantSerializer : KSerializer<Appointment.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
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
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("actor", Reference.serializer().descriptor, isOptional = true)
      element("required", KotlinString.serializer().descriptor, isOptional = true)
      element("_required", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Appointment.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Appointment.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var actor: Reference? = null
    var required: KotlinString? = null
    var _required: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var period: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        5 -> required = decoder.decodeStringElement(__desc, 5)
        6 ->
          _required =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.requiredSer, null)
        7 -> status = decoder.decodeStringElement(__desc, 7)
        8 ->
          _status = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.requiredSer, null)
        9 -> period = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return Appointment.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      actor = actor,
      required =
        required?.let { Enumeration.of(Appointment.ParticipantRequired.fromCode(it), _required) },
      status = Enumeration.of(Appointment.ParticipationStatus.fromCode(status!!), _status),
      period = period,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Appointment.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, value.type)
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
    ((value.required?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.requiredSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.requiredSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val actorSer: KSerializer<Reference> = Reference.serializer()

    public val requiredSer: KSerializer<Element> = Element.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object AppointmentSerializer : KSerializer<Appointment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Appointment") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("cancelationReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "serviceCategory",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "serviceType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialty",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("appointmentType", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("priority", Int.serializer().descriptor, isOptional = true)
      element("_priority", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "supportingInformation",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("start", KotlinString.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("end", KotlinString.serializer().descriptor, isOptional = true)
      element("_end", Element.serializer().descriptor, isOptional = true)
      element("minutesDuration", Int.serializer().descriptor, isOptional = true)
      element("_minutesDuration", Element.serializer().descriptor, isOptional = true)
      element("slot", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
      element("patientInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_patientInstruction", Element.serializer().descriptor, isOptional = true)
      element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "participant",
        listSerialDescriptor(lazyDescriptor { Appointment.Participant.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "requestedPeriod",
        listSerialDescriptor(Period.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Appointment {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var cancelationReason: CodeableConcept? = null
    var serviceCategory: List<CodeableConcept>? = null
    var serviceType: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var appointmentType: CodeableConcept? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var priority: Int? = null
    var _priority: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var supportingInformation: List<Reference>? = null
    var start: KotlinString? = null
    var _start: Element? = null
    var end: KotlinString? = null
    var _end: Element? = null
    var minutesDuration: Int? = null
    var _minutesDuration: Element? = null
    var slot: List<Reference>? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var patientInstruction: KotlinString? = null
    var _patientInstruction: Element? = null
    var basedOn: List<Reference>? = null
    var participant: List<Appointment.Participant>? = null
    var requestedPeriod: List<Period>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          cancelationReason =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.cancelationReasonSer,
              null,
            )
        15 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.serviceCategorySer, null)
        16 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.serviceCategorySer, null)
        17 ->
          specialty =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.serviceCategorySer, null)
        18 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(
              __desc,
              18,
              Hoisted.cancelationReasonSer,
              null,
            )
        19 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.serviceCategorySer, null)
        20 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.reasonReferenceSer, null)
        21 -> priority = decoder.decodeIntElement(__desc, 21)
        22 ->
          _priority =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> description = decoder.decodeStringElement(__desc, 23)
        24 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.reasonReferenceSer, null)
        26 -> start = decoder.decodeStringElement(__desc, 26)
        27 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> end = decoder.decodeStringElement(__desc, 28)
        29 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> minutesDuration = decoder.decodeIntElement(__desc, 30)
        31 ->
          _minutesDuration =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          slot =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.reasonReferenceSer, null)
        33 -> created = decoder.decodeStringElement(__desc, 33)
        34 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> comment = decoder.decodeStringElement(__desc, 35)
        36 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 -> patientInstruction = decoder.decodeStringElement(__desc, 37)
        38 ->
          _patientInstruction =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 ->
          basedOn =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.reasonReferenceSer, null)
        40 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.participantSer, null)
        41 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.requestedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Appointment: " + __i)
      }
    }
    return Appointment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Appointment.AppointmentStatus.fromCode(status!!), _status),
      cancelationReason = cancelationReason,
      serviceCategory = serviceCategory ?: listOf(),
      serviceType = serviceType ?: listOf(),
      specialty = specialty ?: listOf(),
      appointmentType = appointmentType,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      priority = UnsignedInt.of(priority, _priority),
      description = R4String.of(description, _description),
      supportingInformation = supportingInformation ?: listOf(),
      start = Instant.of(FhirDateTime.fromString(start), _start),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      slot = slot ?: listOf(),
      created = DateTime.of(FhirDateTime.fromString(created), _created),
      comment = R4String.of(comment, _comment),
      patientInstruction = R4String.of(patientInstruction, _patientInstruction),
      basedOn = basedOn ?: listOf(),
      participant = participant ?: listOf(),
      requestedPeriod = requestedPeriod ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Appointment) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Appointment")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.cancelationReason)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.cancelationReasonSer, it)
    }
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        15,
        Hoisted.serviceCategorySer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.serviceCategorySer, value.serviceType)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.serviceCategorySer, value.specialty)
    (value.appointmentType)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.cancelationReasonSer, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.serviceCategorySer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    ((value.priority?.value))?.let { encoder.encodeIntElement(__desc, 21, it) }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25,
        Hoisted.reasonReferenceSer,
        value.supportingInformation,
      )
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.minutesDuration?.value))?.let { encoder.encodeIntElement(__desc, 30, it) }
    (value.minutesDuration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.slot.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.reasonReferenceSer, value.slot)
    ((value.created?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    ((value.patientInstruction?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.patientInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.reasonReferenceSer, value.basedOn)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.participantSer, value.participant)
    if (value.requestedPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        41,
        Hoisted.requestedPeriodSer,
        value.requestedPeriod,
      )
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

    public val cancelationReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val serviceCategorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.cancelationReasonSer)

    public val reasonReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val reasonReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.reasonReferenceSerInner)

    public val participantSerInner: KSerializer<Appointment.Participant> =
      Appointment.Participant.serializer()

    public val participantSer: KSerializer<List<Appointment.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val requestedPeriodSerInner: KSerializer<Period> = Period.serializer()

    public val requestedPeriodSer: KSerializer<List<Period>> =
      ListSerializer(Hoisted.requestedPeriodSerInner)
  }
}
