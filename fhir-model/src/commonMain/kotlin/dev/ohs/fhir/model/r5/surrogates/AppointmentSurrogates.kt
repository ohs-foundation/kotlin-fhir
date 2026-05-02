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

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Annotation
import com.google.fhir.model.r5.Appointment
import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.CodeableReference
import com.google.fhir.model.r5.Coding
import com.google.fhir.model.r5.Date
import com.google.fhir.model.r5.DateTime
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.FhirDate
import com.google.fhir.model.r5.FhirDateTime
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.Instant
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.VirtualServiceDetail
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
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
  public var period: Period? = null,
  public var actor: Reference? = null,
  public var required: KotlinBoolean? = null,
  public var _required: Element? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
) {
  public fun toModel(): Appointment.Participant =
    Appointment.Participant(
      id = this@AppointmentParticipantSurrogate.id,
      extension = this@AppointmentParticipantSurrogate.extension ?: listOf(),
      modifierExtension = this@AppointmentParticipantSurrogate.modifierExtension ?: listOf(),
      type = this@AppointmentParticipantSurrogate.type ?: listOf(),
      period = this@AppointmentParticipantSurrogate.period,
      actor = this@AppointmentParticipantSurrogate.actor,
      required =
        R5Boolean.of(
          this@AppointmentParticipantSurrogate.required,
          this@AppointmentParticipantSurrogate._required,
        ),
      status =
        Enumeration.of(
          Appointment.ParticipationStatus.fromCode(this@AppointmentParticipantSurrogate.status!!),
          this@AppointmentParticipantSurrogate._status,
        ),
    )

  public companion object {
    public fun fromModel(model: Appointment.Participant): AppointmentParticipantSurrogate =
      with(model) {
        AppointmentParticipantSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type.takeIf { it.isNotEmpty() },
          period = this@with.period,
          actor = this@with.actor,
          required = this@with.required?.value,
          _required = this@with.required?.toElement(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
        )
      }
  }
}

@Serializable
internal data class AppointmentRecurrenceTemplateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var timezone: CodeableConcept? = null,
  public var recurrenceType: CodeableConcept,
  public var lastOccurrenceDate: KotlinString? = null,
  public var _lastOccurrenceDate: Element? = null,
  public var occurrenceCount: Int? = null,
  public var _occurrenceCount: Element? = null,
  public var occurrenceDate: List<KotlinString?>? = null,
  public var _occurrenceDate: List<Element?>? = null,
  public var weeklyTemplate: Appointment.RecurrenceTemplate.WeeklyTemplate? = null,
  public var monthlyTemplate: Appointment.RecurrenceTemplate.MonthlyTemplate? = null,
  public var yearlyTemplate: Appointment.RecurrenceTemplate.YearlyTemplate? = null,
  public var excludingDate: List<KotlinString?>? = null,
  public var _excludingDate: List<Element?>? = null,
  public var excludingRecurrenceId: List<Int?>? = null,
  public var _excludingRecurrenceId: List<Element?>? = null,
) {
  public fun toModel(): Appointment.RecurrenceTemplate =
    Appointment.RecurrenceTemplate(
      id = this@AppointmentRecurrenceTemplateSurrogate.id,
      extension = this@AppointmentRecurrenceTemplateSurrogate.extension ?: listOf(),
      modifierExtension = this@AppointmentRecurrenceTemplateSurrogate.modifierExtension ?: listOf(),
      timezone = this@AppointmentRecurrenceTemplateSurrogate.timezone,
      recurrenceType = this@AppointmentRecurrenceTemplateSurrogate.recurrenceType,
      lastOccurrenceDate =
        Date.of(
          FhirDate.fromString(this@AppointmentRecurrenceTemplateSurrogate.lastOccurrenceDate),
          this@AppointmentRecurrenceTemplateSurrogate._lastOccurrenceDate,
        ),
      occurrenceCount =
        PositiveInt.of(
          this@AppointmentRecurrenceTemplateSurrogate.occurrenceCount,
          this@AppointmentRecurrenceTemplateSurrogate._occurrenceCount,
        ),
      occurrenceDate =
        if (
          this@AppointmentRecurrenceTemplateSurrogate.occurrenceDate == null &&
            this@AppointmentRecurrenceTemplateSurrogate._occurrenceDate == null
        ) {
          listOf()
        } else {
          (this@AppointmentRecurrenceTemplateSurrogate.occurrenceDate
              ?: List(this@AppointmentRecurrenceTemplateSurrogate._occurrenceDate!!.size) { null })
            .zip(
              this@AppointmentRecurrenceTemplateSurrogate._occurrenceDate
                ?: List(this@AppointmentRecurrenceTemplateSurrogate.occurrenceDate!!.size) { null }
            )
            .map { (value, element) -> Date.of(FhirDate.fromString(value), element)!! }
            .toList()
        },
      weeklyTemplate = this@AppointmentRecurrenceTemplateSurrogate.weeklyTemplate,
      monthlyTemplate = this@AppointmentRecurrenceTemplateSurrogate.monthlyTemplate,
      yearlyTemplate = this@AppointmentRecurrenceTemplateSurrogate.yearlyTemplate,
      excludingDate =
        if (
          this@AppointmentRecurrenceTemplateSurrogate.excludingDate == null &&
            this@AppointmentRecurrenceTemplateSurrogate._excludingDate == null
        ) {
          listOf()
        } else {
          (this@AppointmentRecurrenceTemplateSurrogate.excludingDate
              ?: List(this@AppointmentRecurrenceTemplateSurrogate._excludingDate!!.size) { null })
            .zip(
              this@AppointmentRecurrenceTemplateSurrogate._excludingDate
                ?: List(this@AppointmentRecurrenceTemplateSurrogate.excludingDate!!.size) { null }
            )
            .map { (value, element) -> Date.of(FhirDate.fromString(value), element)!! }
            .toList()
        },
      excludingRecurrenceId =
        if (
          this@AppointmentRecurrenceTemplateSurrogate.excludingRecurrenceId == null &&
            this@AppointmentRecurrenceTemplateSurrogate._excludingRecurrenceId == null
        ) {
          listOf()
        } else {
          (this@AppointmentRecurrenceTemplateSurrogate.excludingRecurrenceId
              ?: List(this@AppointmentRecurrenceTemplateSurrogate._excludingRecurrenceId!!.size) {
                null
              })
            .zip(
              this@AppointmentRecurrenceTemplateSurrogate._excludingRecurrenceId
                ?: List(this@AppointmentRecurrenceTemplateSurrogate.excludingRecurrenceId!!.size) {
                  null
                }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: Appointment.RecurrenceTemplate
    ): AppointmentRecurrenceTemplateSurrogate =
      with(model) {
        AppointmentRecurrenceTemplateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          timezone = this@with.timezone,
          recurrenceType = this@with.recurrenceType,
          lastOccurrenceDate = this@with.lastOccurrenceDate?.value?.toString(),
          _lastOccurrenceDate = this@with.lastOccurrenceDate?.toElement(),
          occurrenceCount = this@with.occurrenceCount?.value,
          _occurrenceCount = this@with.occurrenceCount?.toElement(),
          occurrenceDate =
            this@with.occurrenceDate
              .map { it.value?.toString() }
              .toList()
              .takeUnless { it.all { it == null } },
          _occurrenceDate =
            this@with.occurrenceDate
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          weeklyTemplate = this@with.weeklyTemplate,
          monthlyTemplate = this@with.monthlyTemplate,
          yearlyTemplate = this@with.yearlyTemplate,
          excludingDate =
            this@with.excludingDate
              .map { it.value?.toString() }
              .toList()
              .takeUnless { it.all { it == null } },
          _excludingDate =
            this@with.excludingDate
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          excludingRecurrenceId =
            this@with.excludingRecurrenceId
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _excludingRecurrenceId =
            this@with.excludingRecurrenceId
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class AppointmentRecurrenceTemplateWeeklyTemplateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var monday: KotlinBoolean? = null,
  public var _monday: Element? = null,
  public var tuesday: KotlinBoolean? = null,
  public var _tuesday: Element? = null,
  public var wednesday: KotlinBoolean? = null,
  public var _wednesday: Element? = null,
  public var thursday: KotlinBoolean? = null,
  public var _thursday: Element? = null,
  public var friday: KotlinBoolean? = null,
  public var _friday: Element? = null,
  public var saturday: KotlinBoolean? = null,
  public var _saturday: Element? = null,
  public var sunday: KotlinBoolean? = null,
  public var _sunday: Element? = null,
  public var weekInterval: Int? = null,
  public var _weekInterval: Element? = null,
) {
  public fun toModel(): Appointment.RecurrenceTemplate.WeeklyTemplate =
    Appointment.RecurrenceTemplate.WeeklyTemplate(
      id = this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.id,
      extension = this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.modifierExtension ?: listOf(),
      monday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.monday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._monday,
        ),
      tuesday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.tuesday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._tuesday,
        ),
      wednesday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.wednesday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._wednesday,
        ),
      thursday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.thursday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._thursday,
        ),
      friday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.friday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._friday,
        ),
      saturday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.saturday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._saturday,
        ),
      sunday =
        R5Boolean.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.sunday,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._sunday,
        ),
      weekInterval =
        PositiveInt.of(
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.weekInterval,
          this@AppointmentRecurrenceTemplateWeeklyTemplateSurrogate._weekInterval,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Appointment.RecurrenceTemplate.WeeklyTemplate
    ): AppointmentRecurrenceTemplateWeeklyTemplateSurrogate =
      with(model) {
        AppointmentRecurrenceTemplateWeeklyTemplateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          monday = this@with.monday?.value,
          _monday = this@with.monday?.toElement(),
          tuesday = this@with.tuesday?.value,
          _tuesday = this@with.tuesday?.toElement(),
          wednesday = this@with.wednesday?.value,
          _wednesday = this@with.wednesday?.toElement(),
          thursday = this@with.thursday?.value,
          _thursday = this@with.thursday?.toElement(),
          friday = this@with.friday?.value,
          _friday = this@with.friday?.toElement(),
          saturday = this@with.saturday?.value,
          _saturday = this@with.saturday?.toElement(),
          sunday = this@with.sunday?.value,
          _sunday = this@with.sunday?.toElement(),
          weekInterval = this@with.weekInterval?.value,
          _weekInterval = this@with.weekInterval?.toElement(),
        )
      }
  }
}

@Serializable
internal data class AppointmentRecurrenceTemplateMonthlyTemplateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var dayOfMonth: Int? = null,
  public var _dayOfMonth: Element? = null,
  public var nthWeekOfMonth: Coding? = null,
  public var dayOfWeek: Coding? = null,
  public var monthInterval: Int? = null,
  public var _monthInterval: Element? = null,
) {
  public fun toModel(): Appointment.RecurrenceTemplate.MonthlyTemplate =
    Appointment.RecurrenceTemplate.MonthlyTemplate(
      id = this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.id,
      extension = this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.modifierExtension ?: listOf(),
      dayOfMonth =
        PositiveInt.of(
          this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.dayOfMonth,
          this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate._dayOfMonth,
        ),
      nthWeekOfMonth = this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.nthWeekOfMonth,
      dayOfWeek = this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.dayOfWeek,
      monthInterval =
        PositiveInt.of(
          this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.monthInterval,
          this@AppointmentRecurrenceTemplateMonthlyTemplateSurrogate._monthInterval,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: Appointment.RecurrenceTemplate.MonthlyTemplate
    ): AppointmentRecurrenceTemplateMonthlyTemplateSurrogate =
      with(model) {
        AppointmentRecurrenceTemplateMonthlyTemplateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          dayOfMonth = this@with.dayOfMonth?.value,
          _dayOfMonth = this@with.dayOfMonth?.toElement(),
          nthWeekOfMonth = this@with.nthWeekOfMonth,
          dayOfWeek = this@with.dayOfWeek,
          monthInterval = this@with.monthInterval.value,
          _monthInterval = this@with.monthInterval.toElement(),
        )
      }
  }
}

@Serializable
internal data class AppointmentRecurrenceTemplateYearlyTemplateSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var yearInterval: Int? = null,
  public var _yearInterval: Element? = null,
) {
  public fun toModel(): Appointment.RecurrenceTemplate.YearlyTemplate =
    Appointment.RecurrenceTemplate.YearlyTemplate(
      id = this@AppointmentRecurrenceTemplateYearlyTemplateSurrogate.id,
      extension = this@AppointmentRecurrenceTemplateYearlyTemplateSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AppointmentRecurrenceTemplateYearlyTemplateSurrogate.modifierExtension ?: listOf(),
      yearInterval =
        PositiveInt.of(
          this@AppointmentRecurrenceTemplateYearlyTemplateSurrogate.yearInterval,
          this@AppointmentRecurrenceTemplateYearlyTemplateSurrogate._yearInterval,
        )!!,
    )

  public companion object {
    public fun fromModel(
      model: Appointment.RecurrenceTemplate.YearlyTemplate
    ): AppointmentRecurrenceTemplateYearlyTemplateSurrogate =
      with(model) {
        AppointmentRecurrenceTemplateYearlyTemplateSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          yearInterval = this@with.yearInterval.value,
          _yearInterval = this@with.yearInterval.toElement(),
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
  public var cancellationReason: CodeableConcept? = null,
  public var `class`: List<CodeableConcept>? = null,
  public var serviceCategory: List<CodeableConcept>? = null,
  public var serviceType: List<CodeableReference>? = null,
  public var specialty: List<CodeableConcept>? = null,
  public var appointmentType: CodeableConcept? = null,
  public var reason: List<CodeableReference>? = null,
  public var priority: CodeableConcept? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var replaces: List<Reference>? = null,
  public var virtualService: List<VirtualServiceDetail>? = null,
  public var supportingInformation: List<Reference>? = null,
  public var previousAppointment: Reference? = null,
  public var originatingAppointment: Reference? = null,
  public var start: KotlinString? = null,
  public var _start: Element? = null,
  public var end: KotlinString? = null,
  public var _end: Element? = null,
  public var minutesDuration: Int? = null,
  public var _minutesDuration: Element? = null,
  public var requestedPeriod: List<Period>? = null,
  public var slot: List<Reference>? = null,
  public var account: List<Reference>? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var cancellationDate: KotlinString? = null,
  public var _cancellationDate: Element? = null,
  public var note: List<Annotation>? = null,
  public var patientInstruction: List<CodeableReference>? = null,
  public var basedOn: List<Reference>? = null,
  public var subject: Reference? = null,
  public var participant: List<Appointment.Participant>? = null,
  public var recurrenceId: Int? = null,
  public var _recurrenceId: Element? = null,
  public var occurrenceChanged: KotlinBoolean? = null,
  public var _occurrenceChanged: Element? = null,
  public var recurrenceTemplate: List<Appointment.RecurrenceTemplate>? = null,
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
      cancellationReason = this@AppointmentSurrogate.cancellationReason,
      `class` = this@AppointmentSurrogate.`class` ?: listOf(),
      serviceCategory = this@AppointmentSurrogate.serviceCategory ?: listOf(),
      serviceType = this@AppointmentSurrogate.serviceType ?: listOf(),
      specialty = this@AppointmentSurrogate.specialty ?: listOf(),
      appointmentType = this@AppointmentSurrogate.appointmentType,
      reason = this@AppointmentSurrogate.reason ?: listOf(),
      priority = this@AppointmentSurrogate.priority,
      description =
        R5String.of(this@AppointmentSurrogate.description, this@AppointmentSurrogate._description),
      replaces = this@AppointmentSurrogate.replaces ?: listOf(),
      virtualService = this@AppointmentSurrogate.virtualService ?: listOf(),
      supportingInformation = this@AppointmentSurrogate.supportingInformation ?: listOf(),
      previousAppointment = this@AppointmentSurrogate.previousAppointment,
      originatingAppointment = this@AppointmentSurrogate.originatingAppointment,
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
      requestedPeriod = this@AppointmentSurrogate.requestedPeriod ?: listOf(),
      slot = this@AppointmentSurrogate.slot ?: listOf(),
      account = this@AppointmentSurrogate.account ?: listOf(),
      created =
        DateTime.of(
          FhirDateTime.fromString(this@AppointmentSurrogate.created),
          this@AppointmentSurrogate._created,
        ),
      cancellationDate =
        DateTime.of(
          FhirDateTime.fromString(this@AppointmentSurrogate.cancellationDate),
          this@AppointmentSurrogate._cancellationDate,
        ),
      note = this@AppointmentSurrogate.note ?: listOf(),
      patientInstruction = this@AppointmentSurrogate.patientInstruction ?: listOf(),
      basedOn = this@AppointmentSurrogate.basedOn ?: listOf(),
      subject = this@AppointmentSurrogate.subject,
      participant = this@AppointmentSurrogate.participant ?: listOf(),
      recurrenceId =
        PositiveInt.of(
          this@AppointmentSurrogate.recurrenceId,
          this@AppointmentSurrogate._recurrenceId,
        ),
      occurrenceChanged =
        R5Boolean.of(
          this@AppointmentSurrogate.occurrenceChanged,
          this@AppointmentSurrogate._occurrenceChanged,
        ),
      recurrenceTemplate = this@AppointmentSurrogate.recurrenceTemplate ?: listOf(),
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
          cancellationReason = this@with.cancellationReason,
          `class` = this@with.`class`.takeIf { it.isNotEmpty() },
          serviceCategory = this@with.serviceCategory.takeIf { it.isNotEmpty() },
          serviceType = this@with.serviceType.takeIf { it.isNotEmpty() },
          specialty = this@with.specialty.takeIf { it.isNotEmpty() },
          appointmentType = this@with.appointmentType,
          reason = this@with.reason.takeIf { it.isNotEmpty() },
          priority = this@with.priority,
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          replaces = this@with.replaces.takeIf { it.isNotEmpty() },
          virtualService = this@with.virtualService.takeIf { it.isNotEmpty() },
          supportingInformation = this@with.supportingInformation.takeIf { it.isNotEmpty() },
          previousAppointment = this@with.previousAppointment,
          originatingAppointment = this@with.originatingAppointment,
          start = this@with.start?.value?.toString(),
          _start = this@with.start?.toElement(),
          end = this@with.end?.value?.toString(),
          _end = this@with.end?.toElement(),
          minutesDuration = this@with.minutesDuration?.value,
          _minutesDuration = this@with.minutesDuration?.toElement(),
          requestedPeriod = this@with.requestedPeriod.takeIf { it.isNotEmpty() },
          slot = this@with.slot.takeIf { it.isNotEmpty() },
          account = this@with.account.takeIf { it.isNotEmpty() },
          created = this@with.created?.value?.toString(),
          _created = this@with.created?.toElement(),
          cancellationDate = this@with.cancellationDate?.value?.toString(),
          _cancellationDate = this@with.cancellationDate?.toElement(),
          note = this@with.note.takeIf { it.isNotEmpty() },
          patientInstruction = this@with.patientInstruction.takeIf { it.isNotEmpty() },
          basedOn = this@with.basedOn.takeIf { it.isNotEmpty() },
          subject = this@with.subject,
          participant = this@with.participant.takeIf { it.isNotEmpty() },
          recurrenceId = this@with.recurrenceId?.value,
          _recurrenceId = this@with.recurrenceId?.toElement(),
          occurrenceChanged = this@with.occurrenceChanged?.value,
          _occurrenceChanged = this@with.occurrenceChanged?.toElement(),
          recurrenceTemplate = this@with.recurrenceTemplate.takeIf { it.isNotEmpty() },
        )
      }
  }
}
