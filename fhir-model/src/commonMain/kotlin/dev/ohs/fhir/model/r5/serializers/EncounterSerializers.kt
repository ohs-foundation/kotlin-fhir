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

import com.google.fhir.model.r5.Encounter
import com.google.fhir.model.r5.surrogates.EncounterAdmissionSurrogate
import com.google.fhir.model.r5.surrogates.EncounterDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.EncounterLocationSurrogate
import com.google.fhir.model.r5.surrogates.EncounterParticipantSurrogate
import com.google.fhir.model.r5.surrogates.EncounterReasonSurrogate
import com.google.fhir.model.r5.surrogates.EncounterSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object EncounterParticipantSerializer : KSerializer<Encounter.Participant> {
  internal val surrogateSerializer: KSerializer<EncounterParticipantSurrogate> by lazy {
    EncounterParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Participant) {
    surrogateSerializer.serialize(encoder, EncounterParticipantSurrogate.fromModel(value))
  }
}

public object EncounterReasonSerializer : KSerializer<Encounter.Reason> {
  internal val surrogateSerializer: KSerializer<EncounterReasonSurrogate> by lazy {
    EncounterReasonSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Reason", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Reason =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Reason) {
    surrogateSerializer.serialize(encoder, EncounterReasonSurrogate.fromModel(value))
  }
}

public object EncounterDiagnosisSerializer : KSerializer<Encounter.Diagnosis> {
  internal val surrogateSerializer: KSerializer<EncounterDiagnosisSurrogate> by lazy {
    EncounterDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Diagnosis) {
    surrogateSerializer.serialize(encoder, EncounterDiagnosisSurrogate.fromModel(value))
  }
}

public object EncounterAdmissionSerializer : KSerializer<Encounter.Admission> {
  internal val surrogateSerializer: KSerializer<EncounterAdmissionSurrogate> by lazy {
    EncounterAdmissionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Admission", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Admission =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Admission) {
    surrogateSerializer.serialize(encoder, EncounterAdmissionSurrogate.fromModel(value))
  }
}

public object EncounterLocationSerializer : KSerializer<Encounter.Location> {
  internal val surrogateSerializer: KSerializer<EncounterLocationSurrogate> by lazy {
    EncounterLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Location) {
    surrogateSerializer.serialize(encoder, EncounterLocationSurrogate.fromModel(value))
  }
}

public object EncounterSerializer : KSerializer<Encounter> {
  internal val surrogateSerializer: KSerializer<EncounterSurrogate> by lazy {
    EncounterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Encounter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter) {
    surrogateSerializer.serialize(encoder, EncounterSurrogate.fromModel(value))
  }
}
