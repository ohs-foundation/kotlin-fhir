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
import com.google.fhir.model.r4b.Goal
import com.google.fhir.model.r4b.surrogates.GoalStartSurrogate
import com.google.fhir.model.r4b.surrogates.GoalSurrogate
import com.google.fhir.model.r4b.surrogates.GoalTargetDetailSurrogate
import com.google.fhir.model.r4b.surrogates.GoalTargetDueSurrogate
import com.google.fhir.model.r4b.surrogates.GoalTargetSurrogate
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

public object GoalTargetSerializer : KSerializer<Goal.Target> {
  internal val surrogateSerializer: KSerializer<GoalTargetSurrogate> by lazy {
    GoalTargetSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("detail", "due")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Goal.Target {
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

  override fun serialize(encoder: Encoder, `value`: Goal.Target) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = GoalTargetSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object GoalStartSerializer : KSerializer<Goal.Start> {
  internal val surrogateSerializer: KSerializer<GoalStartSurrogate> by lazy {
    GoalStartSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Start", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Goal.Start =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Goal.Start) {
    surrogateSerializer.serialize(encoder, GoalStartSurrogate.fromModel(value))
  }
}

public object GoalTargetDetailSerializer : KSerializer<Goal.Target.Detail> {
  internal val surrogateSerializer: KSerializer<GoalTargetDetailSurrogate> by lazy {
    GoalTargetDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Goal.Target.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Goal.Target.Detail) {
    surrogateSerializer.serialize(encoder, GoalTargetDetailSurrogate.fromModel(value))
  }
}

public object GoalTargetDueSerializer : KSerializer<Goal.Target.Due> {
  internal val surrogateSerializer: KSerializer<GoalTargetDueSurrogate> by lazy {
    GoalTargetDueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Due", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Goal.Target.Due =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Goal.Target.Due) {
    surrogateSerializer.serialize(encoder, GoalTargetDueSurrogate.fromModel(value))
  }
}

public object GoalSerializer : KSerializer<Goal> {
  internal val surrogateSerializer: KSerializer<GoalSurrogate> by lazy {
    GoalSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("start")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Goal", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Goal {
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

  override fun serialize(encoder: Encoder, `value`: Goal) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = GoalSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
