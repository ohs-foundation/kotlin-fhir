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

import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.Questionnaire
import com.google.fhir.model.r5.surrogates.QuestionnaireItemAnswerOptionSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemAnswerOptionValueSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemEnableWhenAnswerSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemEnableWhenSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemInitialSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemInitialValueSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireItemSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireSurrogate
import com.google.fhir.model.r5.surrogates.QuestionnaireVersionAlgorithmSurrogate
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

public object QuestionnaireItemSerializer : KSerializer<Questionnaire.Item> {
  internal val surrogateSerializer: KSerializer<QuestionnaireItemSurrogate> by lazy {
    QuestionnaireItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item) {
    surrogateSerializer.serialize(encoder, QuestionnaireItemSurrogate.fromModel(value))
  }
}

public object QuestionnaireItemEnableWhenSerializer : KSerializer<Questionnaire.Item.EnableWhen> {
  internal val surrogateSerializer: KSerializer<QuestionnaireItemEnableWhenSurrogate> by lazy {
    QuestionnaireItemEnableWhenSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("answer")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EnableWhen", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = QuestionnaireItemEnableWhenSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object QuestionnaireItemAnswerOptionSerializer :
  KSerializer<Questionnaire.Item.AnswerOption> {
  internal val surrogateSerializer: KSerializer<QuestionnaireItemAnswerOptionSurrogate> by lazy {
    QuestionnaireItemAnswerOptionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AnswerOption", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = QuestionnaireItemAnswerOptionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object QuestionnaireItemInitialSerializer : KSerializer<Questionnaire.Item.Initial> {
  internal val surrogateSerializer: KSerializer<QuestionnaireItemInitialSurrogate> by lazy {
    QuestionnaireItemInitialSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Initial", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = QuestionnaireItemInitialSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object QuestionnaireVersionAlgorithmSerializer :
  KSerializer<Questionnaire.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<QuestionnaireVersionAlgorithmSurrogate> by lazy {
    QuestionnaireVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Questionnaire.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, QuestionnaireVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object QuestionnaireItemEnableWhenAnswerSerializer :
  KSerializer<Questionnaire.Item.EnableWhen.Answer> {
  internal val surrogateSerializer:
    KSerializer<QuestionnaireItemEnableWhenAnswerSurrogate> by lazy {
    QuestionnaireItemEnableWhenAnswerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Answer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen.Answer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen.Answer) {
    surrogateSerializer.serialize(
      encoder,
      QuestionnaireItemEnableWhenAnswerSurrogate.fromModel(value),
    )
  }
}

public object QuestionnaireItemAnswerOptionValueSerializer :
  KSerializer<Questionnaire.Item.AnswerOption.Value> {
  internal val surrogateSerializer:
    KSerializer<QuestionnaireItemAnswerOptionValueSurrogate> by lazy {
    QuestionnaireItemAnswerOptionValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption.Value) {
    surrogateSerializer.serialize(
      encoder,
      QuestionnaireItemAnswerOptionValueSurrogate.fromModel(value),
    )
  }
}

public object QuestionnaireItemInitialValueSerializer :
  KSerializer<Questionnaire.Item.Initial.Value> {
  internal val surrogateSerializer: KSerializer<QuestionnaireItemInitialValueSurrogate> by lazy {
    QuestionnaireItemInitialValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial.Value) {
    surrogateSerializer.serialize(encoder, QuestionnaireItemInitialValueSurrogate.fromModel(value))
  }
}

public object QuestionnaireSerializer : KSerializer<Questionnaire> {
  internal val surrogateSerializer: KSerializer<QuestionnaireSurrogate> by lazy {
    QuestionnaireSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Questionnaire", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = QuestionnaireSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
