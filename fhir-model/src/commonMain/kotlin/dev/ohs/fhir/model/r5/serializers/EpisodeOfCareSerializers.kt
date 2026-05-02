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

import com.google.fhir.model.r5.EpisodeOfCare
import com.google.fhir.model.r5.surrogates.EpisodeOfCareDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.EpisodeOfCareReasonSurrogate
import com.google.fhir.model.r5.surrogates.EpisodeOfCareStatusHistorySurrogate
import com.google.fhir.model.r5.surrogates.EpisodeOfCareSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object EpisodeOfCareStatusHistorySerializer : KSerializer<EpisodeOfCare.StatusHistory> {
  internal val surrogateSerializer: KSerializer<EpisodeOfCareStatusHistorySurrogate> by lazy {
    EpisodeOfCareStatusHistorySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StatusHistory", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.StatusHistory =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.StatusHistory) {
    surrogateSerializer.serialize(encoder, EpisodeOfCareStatusHistorySurrogate.fromModel(value))
  }
}

public object EpisodeOfCareReasonSerializer : KSerializer<EpisodeOfCare.Reason> {
  internal val surrogateSerializer: KSerializer<EpisodeOfCareReasonSurrogate> by lazy {
    EpisodeOfCareReasonSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Reason", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.Reason =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.Reason) {
    surrogateSerializer.serialize(encoder, EpisodeOfCareReasonSurrogate.fromModel(value))
  }
}

public object EpisodeOfCareDiagnosisSerializer : KSerializer<EpisodeOfCare.Diagnosis> {
  internal val surrogateSerializer: KSerializer<EpisodeOfCareDiagnosisSurrogate> by lazy {
    EpisodeOfCareDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare.Diagnosis) {
    surrogateSerializer.serialize(encoder, EpisodeOfCareDiagnosisSurrogate.fromModel(value))
  }
}

public object EpisodeOfCareSerializer : KSerializer<EpisodeOfCare> {
  internal val surrogateSerializer: KSerializer<EpisodeOfCareSurrogate> by lazy {
    EpisodeOfCareSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EpisodeOfCare", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EpisodeOfCare =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EpisodeOfCare) {
    surrogateSerializer.serialize(encoder, EpisodeOfCareSurrogate.fromModel(value))
  }
}
