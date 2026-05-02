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

import com.google.fhir.model.r5.Condition
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ConditionAbatementSurrogate
import com.google.fhir.model.r5.surrogates.ConditionOnsetSurrogate
import com.google.fhir.model.r5.surrogates.ConditionParticipantSurrogate
import com.google.fhir.model.r5.surrogates.ConditionStageSurrogate
import com.google.fhir.model.r5.surrogates.ConditionSurrogate
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

public object ConditionParticipantSerializer : KSerializer<Condition.Participant> {
  internal val surrogateSerializer: KSerializer<ConditionParticipantSurrogate> by lazy {
    ConditionParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Condition.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Condition.Participant) {
    surrogateSerializer.serialize(encoder, ConditionParticipantSurrogate.fromModel(value))
  }
}

public object ConditionStageSerializer : KSerializer<Condition.Stage> {
  internal val surrogateSerializer: KSerializer<ConditionStageSurrogate> by lazy {
    ConditionStageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Condition.Stage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Condition.Stage) {
    surrogateSerializer.serialize(encoder, ConditionStageSurrogate.fromModel(value))
  }
}

public object ConditionOnsetSerializer : KSerializer<Condition.Onset> {
  internal val surrogateSerializer: KSerializer<ConditionOnsetSurrogate> by lazy {
    ConditionOnsetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Onset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Condition.Onset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Condition.Onset) {
    surrogateSerializer.serialize(encoder, ConditionOnsetSurrogate.fromModel(value))
  }
}

public object ConditionAbatementSerializer : KSerializer<Condition.Abatement> {
  internal val surrogateSerializer: KSerializer<ConditionAbatementSurrogate> by lazy {
    ConditionAbatementSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Abatement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Condition.Abatement =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Condition.Abatement) {
    surrogateSerializer.serialize(encoder, ConditionAbatementSurrogate.fromModel(value))
  }
}

public object ConditionSerializer : KSerializer<Condition> {
  internal val surrogateSerializer: KSerializer<ConditionSurrogate> by lazy {
    ConditionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("onset", "abatement")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Condition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Condition {
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

  override fun serialize(encoder: Encoder, `value`: Condition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ConditionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
