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

package com.google.fhir.model.r4b.serializers

import com.google.fhir.model.r4b.Appointment
import com.google.fhir.model.r4b.surrogates.AppointmentParticipantSurrogate
import com.google.fhir.model.r4b.surrogates.AppointmentSurrogate
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
