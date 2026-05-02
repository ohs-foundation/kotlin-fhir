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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.serializers

import com.google.fhir.model.r5.Appointment
import com.google.fhir.model.r5.surrogates.AppointmentParticipantSurrogate
import com.google.fhir.model.r5.surrogates.AppointmentRecurrenceTemplateMonthlyTemplateSurrogate
import com.google.fhir.model.r5.surrogates.AppointmentRecurrenceTemplateSurrogate
import com.google.fhir.model.r5.surrogates.AppointmentRecurrenceTemplateWeeklyTemplateSurrogate
import com.google.fhir.model.r5.surrogates.AppointmentRecurrenceTemplateYearlyTemplateSurrogate
import com.google.fhir.model.r5.surrogates.AppointmentSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object AppointmentParticipantSerializer : KSerializer<Appointment.Participant> {
  internal val surrogateSerializer: KSerializer<AppointmentParticipantSurrogate> by lazy {
    AppointmentParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    surrogateSerializer.serialize(encoder, AppointmentParticipantSurrogate.fromModel(value))
  }
}

public object AppointmentRecurrenceTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate> {
  internal val surrogateSerializer: KSerializer<AppointmentRecurrenceTemplateSurrogate> by lazy {
    AppointmentRecurrenceTemplateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RecurrenceTemplate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate) {
    surrogateSerializer.serialize(encoder, AppointmentRecurrenceTemplateSurrogate.fromModel(value))
  }
}

public object AppointmentRecurrenceTemplateWeeklyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.WeeklyTemplate> {
  internal val surrogateSerializer:
    KSerializer<AppointmentRecurrenceTemplateWeeklyTemplateSurrogate> by lazy {
    AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("WeeklyTemplate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.WeeklyTemplate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.WeeklyTemplate) {
    surrogateSerializer.serialize(
      encoder,
      AppointmentRecurrenceTemplateWeeklyTemplateSurrogate.fromModel(value),
    )
  }
}

public object AppointmentRecurrenceTemplateMonthlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.MonthlyTemplate> {
  internal val surrogateSerializer:
    KSerializer<AppointmentRecurrenceTemplateMonthlyTemplateSurrogate> by lazy {
    AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MonthlyTemplate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.MonthlyTemplate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    surrogateSerializer.serialize(
      encoder,
      AppointmentRecurrenceTemplateMonthlyTemplateSurrogate.fromModel(value),
    )
  }
}

public object AppointmentRecurrenceTemplateYearlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.YearlyTemplate> {
  internal val surrogateSerializer:
    KSerializer<AppointmentRecurrenceTemplateYearlyTemplateSurrogate> by lazy {
    AppointmentRecurrenceTemplateYearlyTemplateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("YearlyTemplate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.YearlyTemplate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.YearlyTemplate) {
    surrogateSerializer.serialize(
      encoder,
      AppointmentRecurrenceTemplateYearlyTemplateSurrogate.fromModel(value),
    )
  }
}

public object AppointmentSerializer : KSerializer<Appointment> {
  internal val surrogateSerializer: KSerializer<AppointmentSurrogate> by lazy {
    AppointmentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Appointment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Appointment =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    surrogateSerializer.serialize(encoder, AppointmentSurrogate.fromModel(value))
  }
}
