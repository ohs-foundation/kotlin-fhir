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

import com.google.fhir.model.r5.ResearchStudy
import com.google.fhir.model.r5.surrogates.ResearchStudyAssociatedPartySurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyComparisonGroupSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyLabelSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyObjectiveSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyOutcomeMeasureSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyProgressStatusSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudyRecruitmentSurrogate
import com.google.fhir.model.r5.surrogates.ResearchStudySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ResearchStudyLabelSerializer : KSerializer<ResearchStudy.Label> {
  internal val surrogateSerializer: KSerializer<ResearchStudyLabelSurrogate> by lazy {
    ResearchStudyLabelSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Label", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.Label =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Label) {
    surrogateSerializer.serialize(encoder, ResearchStudyLabelSurrogate.fromModel(value))
  }
}

public object ResearchStudyAssociatedPartySerializer : KSerializer<ResearchStudy.AssociatedParty> {
  internal val surrogateSerializer: KSerializer<ResearchStudyAssociatedPartySurrogate> by lazy {
    ResearchStudyAssociatedPartySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AssociatedParty", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.AssociatedParty =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.AssociatedParty) {
    surrogateSerializer.serialize(encoder, ResearchStudyAssociatedPartySurrogate.fromModel(value))
  }
}

public object ResearchStudyProgressStatusSerializer : KSerializer<ResearchStudy.ProgressStatus> {
  internal val surrogateSerializer: KSerializer<ResearchStudyProgressStatusSurrogate> by lazy {
    ResearchStudyProgressStatusSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ProgressStatus", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.ProgressStatus =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ProgressStatus) {
    surrogateSerializer.serialize(encoder, ResearchStudyProgressStatusSurrogate.fromModel(value))
  }
}

public object ResearchStudyRecruitmentSerializer : KSerializer<ResearchStudy.Recruitment> {
  internal val surrogateSerializer: KSerializer<ResearchStudyRecruitmentSurrogate> by lazy {
    ResearchStudyRecruitmentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Recruitment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.Recruitment =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.Recruitment) {
    surrogateSerializer.serialize(encoder, ResearchStudyRecruitmentSurrogate.fromModel(value))
  }
}

public object ResearchStudyComparisonGroupSerializer : KSerializer<ResearchStudy.ComparisonGroup> {
  internal val surrogateSerializer: KSerializer<ResearchStudyComparisonGroupSurrogate> by lazy {
    ResearchStudyComparisonGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ComparisonGroup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.ComparisonGroup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.ComparisonGroup) {
    surrogateSerializer.serialize(encoder, ResearchStudyComparisonGroupSurrogate.fromModel(value))
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

public object ResearchStudyOutcomeMeasureSerializer : KSerializer<ResearchStudy.OutcomeMeasure> {
  internal val surrogateSerializer: KSerializer<ResearchStudyOutcomeMeasureSurrogate> by lazy {
    ResearchStudyOutcomeMeasureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("OutcomeMeasure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchStudy.OutcomeMeasure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchStudy.OutcomeMeasure) {
    surrogateSerializer.serialize(encoder, ResearchStudyOutcomeMeasureSurrogate.fromModel(value))
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
