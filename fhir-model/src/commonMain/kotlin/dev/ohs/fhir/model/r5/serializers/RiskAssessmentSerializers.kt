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

import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.RiskAssessment
import com.google.fhir.model.r4.surrogates.RiskAssessmentOccurrenceSurrogate
import com.google.fhir.model.r4.surrogates.RiskAssessmentPredictionProbabilitySurrogate
import com.google.fhir.model.r4.surrogates.RiskAssessmentPredictionSurrogate
import com.google.fhir.model.r4.surrogates.RiskAssessmentPredictionWhenSurrogate
import com.google.fhir.model.r4.surrogates.RiskAssessmentSurrogate
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

public object RiskAssessmentPredictionSerializer : KSerializer<RiskAssessment.Prediction> {
  internal val surrogateSerializer: KSerializer<RiskAssessmentPredictionSurrogate> by lazy {
    RiskAssessmentPredictionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("probability", "when")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Prediction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction {
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

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RiskAssessmentPredictionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RiskAssessmentOccurrenceSerializer : KSerializer<RiskAssessment.Occurrence> {
  internal val surrogateSerializer: KSerializer<RiskAssessmentOccurrenceSurrogate> by lazy {
    RiskAssessmentOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Occurrence) {
    surrogateSerializer.serialize(encoder, RiskAssessmentOccurrenceSurrogate.fromModel(value))
  }
}

public object RiskAssessmentPredictionProbabilitySerializer :
  KSerializer<RiskAssessment.Prediction.Probability> {
  internal val surrogateSerializer:
    KSerializer<RiskAssessmentPredictionProbabilitySurrogate> by lazy {
    RiskAssessmentPredictionProbabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Probability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction.Probability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction.Probability) {
    surrogateSerializer.serialize(
      encoder,
      RiskAssessmentPredictionProbabilitySurrogate.fromModel(value),
    )
  }
}

public object RiskAssessmentPredictionWhenSerializer : KSerializer<RiskAssessment.Prediction.When> {
  internal val surrogateSerializer: KSerializer<RiskAssessmentPredictionWhenSurrogate> by lazy {
    RiskAssessmentPredictionWhenSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("When", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction.When =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction.When) {
    surrogateSerializer.serialize(encoder, RiskAssessmentPredictionWhenSurrogate.fromModel(value))
  }
}

public object RiskAssessmentSerializer : KSerializer<RiskAssessment> {
  internal val surrogateSerializer: KSerializer<RiskAssessmentSurrogate> by lazy {
    RiskAssessmentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RiskAssessment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment {
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

  override fun serialize(encoder: Encoder, `value`: RiskAssessment) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RiskAssessmentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
