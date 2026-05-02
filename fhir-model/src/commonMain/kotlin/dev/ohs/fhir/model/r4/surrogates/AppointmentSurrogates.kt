/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Appointment
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Instant
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.PositiveInt
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AppointmentParticipantSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: List<CodeableConcept>? = null,
  public var actor: Reference? = null,
  public var required: KotlinString? = null,
  public var _required: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var period: Period? = null,
) {
  public fun toModel(): Appointment.Participant =
    Appointment.Participant(
      id = this@AppointmentParticipantSurrogate.id,
      extension = this@AppointmentParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@AppointmentParticipantSurrogate.modifierExtension ?: listOf(),
      type = this@AppointmentParticipantSurrogate.type ?: listOf(),
      actor = this@AppointmentParticipantSurrogate.actor,
      required =
        this@AppointmentParticipantSurrogate.required?.let {
          Enumeration.of(
            Appointment.ParticipantRequired.fromCode(it),
            this@AppointmentParticipantSurrogate._required,
          )
        },
      status =
        Enumeration.of(
          Appointment.ParticipationStatus.fromCode(this@AppointmentParticipantSurrogate.status!!),
          this@AppointmentParticipantSurrogate._status,
        ),
      period = this@AppointmentParticipantSurrogate.period,
    )

  public companion object {
    public fun fromModel(model: Appointment.Participant): AppointmentParticipantSurrogate =
      with(model) {
        AppointmentParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          actor = this@with.actor,
          required = this@with.required?.value?.getCode(),
          _required = this@with.required?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class AppointmentSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var cancelationReason: CodeableConcept? = null,
  public var serviceCategory: List<CodeableConcept>? = null,
  public var serviceType: List<CodeableConcept>? = null,
  public var specialty: List<CodeableConcept>? = null,
  public var appointmentType: CodeableConcept? = null,
  public var reasonCode: List<CodeableConcept>? = null,
  public var reasonReference: List<Reference>? = null,
  public var priority: Int? = null,
  public var _priority: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var supportingInformation: List<Reference>? = null,
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var minutesDuration: Int? = null,
  public var _minutesDuration: Element? = null,
  public var slot: List<Reference>? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
  public var patientInstruction: KotlinString? = null,
  public var _patientInstruction: Element? = null,
  public var basedOn: List<Reference>? = null,
  public var participant: List<Appointment.Participant>? = null,
  public var requestedPeriod: List<Period>? = null,
) {
  public fun toModel(): Appointment =
    Appointment(
      id = this@AppointmentSurrogate.id,
      meta = this@AppointmentSurrogate.meta,
      implicitRules =
        Uri.of(this@AppointmentSurrogate.implicitRules, this@AppointmentSurrogate._implicitRules),
      language = Code.of(this@AppointmentSurrogate.language, this@AppointmentSurrogate._language),
      text = this@AppointmentSurrogate.text,
      contained = this@AppointmentSurrogate.contained ?: listOf(),
      extension = this@AppointmentSurrogate.extension ?: listOf(),
      modifierExtension = this@AppointmentSurrogate.modifierExtension ?: listOf(),
      identifier = this@AppointmentSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Appointment.AppointmentStatus.fromCode(this@AppointmentSurrogate.status!!),
          this@AppointmentSurrogate._status,
        ),
      cancelationReason = this@AppointmentSurrogate.cancelationReason,
      serviceCategory = this@AppointmentSurrogate.serviceCategory ?: listOf(),
      serviceType = this@AppointmentSurrogate.serviceType ?: listOf(),
      specialty = this@AppointmentSurrogate.specialty ?: listOf(),
      appointmentType = this@AppointmentSurrogate.appointmentType,
      reasonCode = this@AppointmentSurrogate.reasonCode ?: listOf(),
      reasonReference = this@AppointmentSurrogate.reasonReference ?: listOf(),
      priority =
        UnsignedInt.of(this@AppointmentSurrogate.priority, this@AppointmentSurrogate._priority),
      description =
        R4String.of(this@AppointmentSurrogate.description, this@AppointmentSurrogate._description),
      supportingInformation = this@AppointmentSurrogate.supportingInformation ?: listOf(),
      start =
        Instant.of(
          FhirDateTime.fromString(this@AppointmentSurrogate.start),
          this@AppointmentSurrogate._start,
        ),
      end =
        Instant.of(
          FhirDateTime.fromString(this@AppointmentSurrogate.end),
          this@AppointmentSurrogate._end,
        ),
      minutesDuration =
        PositiveInt.of(
          this@AppointmentSurrogate.minutesDuration,
          this@AppointmentSurrogate._minutesDuration,
        ),
      slot = this@AppointmentSurrogate.slot ?: listOf(),
      created =
        DateTime.of(
          FhirDateTime.fromString(this@AppointmentSurrogate.created),
          this@AppointmentSurrogate._created,
        ),
      comment = R4String.of(this@AppointmentSurrogate.comment, this@AppointmentSurrogate._comment),
      patientInstruction =
        R4String.of(
          this@AppointmentSurrogate.patientInstruction,
          this@AppointmentSurrogate._patientInstruction,
        ),
      basedOn = this@AppointmentSurrogate.basedOn ?: listOf(),
      participant = this@AppointmentSurrogate.participant ?: listOf(),
      requestedPeriod = this@AppointmentSurrogate.requestedPeriod ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Appointment): AppointmentSurrogate =
      with(model) {
        AppointmentSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          cancelationReason = this@with.cancelationReason,
          serviceCategory = this@with.serviceCategory.takeIf { it.isNotEmpty() },
          serviceType = this@with.serviceType.takeIf { it.isNotEmpty() },
          specialty = this@with.specialty.takeIf { it.isNotEmpty() },
          appointmentType = this@with.appointmentType,
          reasonCode = this@with.reasonCode.takeIf { it.isNotEmpty() },
          reasonReference = this@with.reasonReference.takeIf { it.isNotEmpty() },
          priority = this@with.priority?.value,
          _priority = this@with.priority?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          start = this@with.start?.value?.toString(),
          _start = this@with.start?.toElement(),
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
          minutesDuration = this@with.minutesDuration?.value,
          _minutesDuration = this@with.minutesDuration?.toElement(),
          slot = this@with.slot.takeIf { it.isNotEmpty() },
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
          patientInstruction = this@with.patientInstruction?.value,
          _patientInstruction = this@with.patientInstruction?.toElement(),
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          requestedPeriod = this@with.requestedPeriod.takeIf { it.isNotEmpty() },
        )
      }
  }
}
