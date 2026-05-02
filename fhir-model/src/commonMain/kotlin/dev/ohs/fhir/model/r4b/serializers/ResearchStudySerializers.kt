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

import com.google.fhir.model.r4b.ResearchStudy
import com.google.fhir.model.r4b.surrogates.ResearchStudyArmSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchStudyObjectiveSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchStudySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ResearchStudyArmSerializer : KSerializer<ResearchStudy.Arm> {
  internal val surrogateSerializer: KSerializer<ResearchStudyArmSurrogate> by lazy {
    ResearchStudyArmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Arm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.Arm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Arm) {
    surrogateSerializer.serialize(encoder, ResearchStudyArmSurrogate.fromModel(value))
  }
}

public object ResearchStudyObjectiveSerializer : KSerializer<ResearchStudy.Objective> {
  internal val surrogateSerializer: KSerializer<ResearchStudyObjectiveSurrogate> by lazy {
    ResearchStudyObjectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Objective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.Objective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Objective) {
    surrogateSerializer.serialize(encoder, ResearchStudyObjectiveSurrogate.fromModel(value))
  }
}

public object ResearchStudySerializer : KSerializer<ResearchStudy> {
  internal val surrogateSerializer: KSerializer<ResearchStudySurrogate> by lazy {
    ResearchStudySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ResearchStudy", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy) {
    surrogateSerializer.serialize(encoder, ResearchStudySurrogate.fromModel(value))
  }
}
