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

import com.google.fhir.model.r4.CareTeam
import com.google.fhir.model.r4.surrogates.CareTeamParticipantSurrogate
import com.google.fhir.model.r4.surrogates.CareTeamSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object CareTeamParticipantSerializer : KSerializer<CareTeam.Participant> {
  internal val surrogateSerializer: KSerializer<CareTeamParticipantSurrogate> by lazy {
    CareTeamParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CareTeam.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CareTeam.Participant) {
    surrogateSerializer.serialize(encoder, CareTeamParticipantSurrogate.fromModel(value))
  }
}

public object CareTeamSerializer : KSerializer<CareTeam> {
  internal val surrogateSerializer: KSerializer<CareTeamSurrogate> by lazy {
    CareTeamSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CareTeam", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CareTeam =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CareTeam) {
    surrogateSerializer.serialize(encoder, CareTeamSurrogate.fromModel(value))
  }
}
