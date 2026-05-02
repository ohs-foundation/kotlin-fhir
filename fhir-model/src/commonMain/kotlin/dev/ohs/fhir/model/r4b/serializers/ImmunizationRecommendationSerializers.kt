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

import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.ImmunizationRecommendation
import com.google.fhir.model.r4b.surrogates.ImmunizationRecommendationRecommendationDateCriterionSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationRecommendationRecommendationDoseNumberSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationRecommendationRecommendationSeriesDosesSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationRecommendationRecommendationSurrogate
import com.google.fhir.model.r4b.surrogates.ImmunizationRecommendationSurrogate
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

public object ImmunizationRecommendationRecommendationSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationRecommendationRecommendationSurrogate> by lazy {
    ImmunizationRecommendationRecommendationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("doseNumber", "seriesDoses")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Recommendation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation.Recommendation {
    val jsonDecoder =
      decoder as? JsonDecoder ?: error("This serializer only supports JSON decoding")
    val oldJsonObject =
      JsonObject(
        jsonDecoder.decodeJsonElement().jsonObject.toMutableMap().apply { remove("resourceType") }
      )
    val unflattenedJsonObject = FhirJsonTransformer.unflatten(oldJsonObject, multiChoiceProperties)
    val surrogate =
      jsonDecoder.json.decodeFromJsonElement(surrogateSerializer, unflattenedJsonObject)
    return surrogate.toModel()
  }

  override fun serialize(encoder: Encoder, `value`: ImmunizationRecommendation.Recommendation) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ImmunizationRecommendationRecommendationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
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

public object ImmunizationRecommendationRecommendationDoseNumberSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation.DoseNumber> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationRecommendationRecommendationDoseNumberSurrogate> by lazy {
    ImmunizationRecommendationRecommendationDoseNumberSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DoseNumber", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImmunizationRecommendation.Recommendation.DoseNumber =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ImmunizationRecommendation.Recommendation.DoseNumber,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationRecommendationRecommendationDoseNumberSurrogate.fromModel(value),
    )
  }
}

public object ImmunizationRecommendationRecommendationSeriesDosesSerializer :
  KSerializer<ImmunizationRecommendation.Recommendation.SeriesDoses> {
  internal val surrogateSerializer:
    KSerializer<ImmunizationRecommendationRecommendationSeriesDosesSurrogate> by lazy {
    ImmunizationRecommendationRecommendationSeriesDosesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SeriesDoses", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ImmunizationRecommendation.Recommendation.SeriesDoses =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ImmunizationRecommendation.Recommendation.SeriesDoses,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ImmunizationRecommendationRecommendationSeriesDosesSurrogate.fromModel(value),
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
