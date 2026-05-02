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

package com.google.fhir.model.r4.serializers

import com.google.fhir.model.r4.Encounter
import com.google.fhir.model.r4.surrogates.EncounterClassHistorySurrogate
import com.google.fhir.model.r4.surrogates.EncounterDiagnosisSurrogate
import com.google.fhir.model.r4.surrogates.EncounterHospitalizationSurrogate
import com.google.fhir.model.r4.surrogates.EncounterLocationSurrogate
import com.google.fhir.model.r4.surrogates.EncounterParticipantSurrogate
import com.google.fhir.model.r4.surrogates.EncounterStatusHistorySurrogate
import com.google.fhir.model.r4.surrogates.EncounterSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object EncounterStatusHistorySerializer : KSerializer<Encounter.StatusHistory> {
  internal val surrogateSerializer: KSerializer<EncounterStatusHistorySurrogate> by lazy {
    EncounterStatusHistorySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StatusHistory", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.StatusHistory =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.StatusHistory) {
    surrogateSerializer.serialize(encoder, EncounterStatusHistorySurrogate.fromModel(value))
  }
}

public object EncounterClassHistorySerializer : KSerializer<Encounter.ClassHistory> {
  internal val surrogateSerializer: KSerializer<EncounterClassHistorySurrogate> by lazy {
    EncounterClassHistorySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ClassHistory", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.ClassHistory =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.ClassHistory) {
    surrogateSerializer.serialize(encoder, EncounterClassHistorySurrogate.fromModel(value))
  }
}

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

public object EncounterHospitalizationSerializer : KSerializer<Encounter.Hospitalization> {
  internal val surrogateSerializer: KSerializer<EncounterHospitalizationSurrogate> by lazy {
    EncounterHospitalizationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Hospitalization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Encounter.Hospitalization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Encounter.Hospitalization) {
    surrogateSerializer.serialize(encoder, EncounterHospitalizationSurrogate.fromModel(value))
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
