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

import com.google.fhir.model.r5.ImmunizationRecommendation
import com.google.fhir.model.r5.surrogates.ImmunizationRecommendationRecommendationDateCriterionSurrogate
import com.google.fhir.model.r5.surrogates.ImmunizationRecommendationRecommendationSurrogate
import com.google.fhir.model.r5.surrogates.ImmunizationRecommendationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ImmunizationRecommendationRecommendationSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationRecommendationRecommendationSurrogate> by lazy {
    ImmunizationRecommendationRecommendationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Recommendation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation.Recommendation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation.Recommendation) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationRecommendationRecommendationSurrogate.fromModel(value),
    )
  }
}

public object ImmunizationRecommendationRecommendationDateCriterionSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation.DateCriterion> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationRecommendationRecommendationDateCriterionSurrogate> by lazy {
    ImmunizationRecommendationRecommendationDateCriterionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DateCriterion", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ImmunizationRecommendation.Recommendation.DateCriterion =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ImmunizationRecommendation.Recommendation.DateCriterion,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationRecommendationRecommendationDateCriterionSurrogate.fromModel(value),
    )
  }
}

public object ImmunizationRecommendationSerializer : KSerializer<ImmunizationRecommendation> {
  internal val surrogateSerializer: KSerializer<ImmunizationRecommendationSurrogate> by lazy {
    ImmunizationRecommendationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ImmunizationRecommendation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation) {
    surrogateSerializer.serialize(encoder, ImmunizationRecommendationSurrogate.fromModel(value))
  }
}
