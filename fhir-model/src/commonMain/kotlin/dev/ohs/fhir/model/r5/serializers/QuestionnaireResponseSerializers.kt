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
import com.google.fhir.model.r4.QuestionnaireResponse
import com.google.fhir.model.r4.surrogates.QuestionnaireResponseItemAnswerSurrogate
import com.google.fhir.model.r4.surrogates.QuestionnaireResponseItemAnswerValueSurrogate
import com.google.fhir.model.r4.surrogates.QuestionnaireResponseItemSurrogate
import com.google.fhir.model.r4.surrogates.QuestionnaireResponseSurrogate
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

public object QuestionnaireResponseItemSerializer : KSerializer<QuestionnaireResponse.Item> {
  internal val surrogateSerializer: KSerializer<QuestionnaireResponseItemSurrogate> by lazy {
    QuestionnaireResponseItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item) {
    surrogateSerializer.serialize(encoder, QuestionnaireResponseItemSurrogate.fromModel(value))
  }
}

public object QuestionnaireResponseItemAnswerSerializer :
  KSerializer<QuestionnaireResponse.Item.Answer> {
  internal val surrogateSerializer: KSerializer<QuestionnaireResponseItemAnswerSurrogate> by lazy {
    QuestionnaireResponseItemAnswerSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Answer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item.Answer {
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

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item.Answer) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = QuestionnaireResponseItemAnswerSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object QuestionnaireResponseItemAnswerValueSerializer :
  KSerializer<QuestionnaireResponse.Item.Answer.Value> {
  internal val surrogateSerializer:
    KSerializer<QuestionnaireResponseItemAnswerValueSurrogate> by lazy {
    QuestionnaireResponseItemAnswerValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item.Answer.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item.Answer.Value) {
    surrogateSerializer.serialize(
      encoder,
      QuestionnaireResponseItemAnswerValueSurrogate.fromModel(value),
    )
  }
}

public object QuestionnaireResponseSerializer : KSerializer<QuestionnaireResponse> {
  internal val surrogateSerializer: KSerializer<QuestionnaireResponseSurrogate> by lazy {
    QuestionnaireResponseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("QuestionnaireResponse", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse) {
    surrogateSerializer.serialize(encoder, QuestionnaireResponseSurrogate.fromModel(value))
  }
}
