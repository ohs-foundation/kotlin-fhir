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

import dev.ohs.fhir.model.r4b.Appointment
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Appointment.Participant {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        5 -> required = decoder.decodeStringElement(descriptor, i)
        6 ->
          _required =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        7 -> status = decoder.decodeStringElement(descriptor, i)
        8 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        9 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Appointment.Participant) {
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
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.actor)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.actorSer, it) }
    ((value.required?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.requiredSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.requiredSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.periodSer, it) }
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("cancelationReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "serviceCategory",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specialty",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("appointmentType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "reasonCode",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reasonReference",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", Int.serializer().descriptor, isOptional = true)
    b.element("_priority", Element.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("start", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_start", Element.serializer().descriptor, isOptional = true)
    b.element("end", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_end", Element.serializer().descriptor, isOptional = true)
    b.element("minutesDuration", Int.serializer().descriptor, isOptional = true)
    b.element("_minutesDuration", Element.serializer().descriptor, isOptional = true)
    b.element("slot", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element("patientInstruction", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_patientInstruction", Element.serializer().descriptor, isOptional = true)
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { Appointment.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "requestedPeriod",
      listSerialDescriptor(Period.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Appointment")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Appointment {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          cancelationReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.cancelationReasonSer,
              null,
            )
        14 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        15 ->
          serviceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        16 ->
          specialty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        17 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.cancelationReasonSer,
              null,
            )
        18 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.serviceCategorySer,
              null,
            )
        19 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        20 -> priority = decoder.decodeIntElement(descriptor, i)
        21 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> description = decoder.decodeStringElement(descriptor, i)
        23 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        25 -> start = decoder.decodeStringElement(descriptor, i)
        26 ->
          _start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> end = decoder.decodeStringElement(descriptor, i)
        28 ->
          _end =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> minutesDuration = decoder.decodeIntElement(descriptor, i)
        30 ->
          _minutesDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          slot =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        32 -> created = decoder.decodeStringElement(descriptor, i)
        33 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> comment = decoder.decodeStringElement(descriptor, i)
        35 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 -> patientInstruction = decoder.decodeStringElement(descriptor, i)
        37 ->
          _patientInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        38 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.reasonReferenceSer,
              null,
            )
        39 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        40 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPeriodSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Appointment: " + i)
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
      description = R4bString.of(description, _description),
      supportingInformation = supportingInformation ?: listOf(),
      start = Instant.of(FhirDateTime.fromString(start), _start),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      slot = slot ?: listOf(),
      created = DateTime.of(FhirDateTime.fromString(created), _created),
      comment = R4bString.of(comment, _comment),
      patientInstruction = R4bString.of(patientInstruction, _patientInstruction),
      basedOn = basedOn ?: listOf(),
      participant = participant ?: listOf(),
      requestedPeriod = requestedPeriod ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Appointment,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.cancelationReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.cancelationReasonSer,
        it,
      )
    }
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.serviceType,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.specialty,
      )
    (value.appointmentType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.cancelationReasonSer,
        it,
      )
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.serviceCategorySer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    ((value.priority?.value))?.let {
      encoder.encodeIntElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.priority?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.supportingInformation,
      )
    ((value.start?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.end?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.minutesDuration?.value))?.let {
      encoder.encodeIntElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.minutesDuration?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.slot.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.slot,
      )
    ((value.created?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.comment?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.patientInstruction?.value))?.let {
      encoder.encodeStringElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.patientInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.reasonReferenceSer,
        value.basedOn,
      )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    if (value.requestedPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
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

internal object AppointmentPolymorphicSerializer : KSerializer<Appointment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Appointment") { AppointmentSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) {
      AppointmentSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) {
      AppointmentSerializer.deserializeInternal(this, descriptor, 0)
    }
}
