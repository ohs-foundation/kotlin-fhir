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
import com.google.fhir.model.r5.SubscriptionTopic
import com.google.fhir.model.r5.surrogates.SubscriptionTopicCanFilterBySurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicEventTriggerSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicNotificationShapeSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicResourceTriggerQueryCriteriaSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicResourceTriggerSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionTopicVersionAlgorithmSurrogate
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

public object SubscriptionTopicResourceTriggerSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger> {
  internal val surrogateSerializer: KSerializer<SubscriptionTopicResourceTriggerSurrogate> by lazy {
    SubscriptionTopicResourceTriggerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ResourceTrigger", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.ResourceTrigger) {
    surrogateSerializer.serialize(
      encoder,
      SubscriptionTopicResourceTriggerSurrogate.fromModel(value),
    )
  }
}

public object SubscriptionTopicResourceTriggerQueryCriteriaSerializer :
  KSerializer<SubscriptionTopic.ResourceTrigger.QueryCriteria> {
  internal val surrogateSerializer:
    KSerializer<SubscriptionTopicResourceTriggerQueryCriteriaSurrogate> by lazy {
    SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("QueryCriteria", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.ResourceTrigger.QueryCriteria =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubscriptionTopic.ResourceTrigger.QueryCriteria,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubscriptionTopicResourceTriggerQueryCriteriaSurrogate.fromModel(value),
    )
  }
}

public object SubscriptionTopicEventTriggerSerializer :
  KSerializer<SubscriptionTopic.EventTrigger> {
  internal val surrogateSerializer: KSerializer<SubscriptionTopicEventTriggerSurrogate> by lazy {
    SubscriptionTopicEventTriggerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EventTrigger", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.EventTrigger =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.EventTrigger) {
    surrogateSerializer.serialize(encoder, SubscriptionTopicEventTriggerSurrogate.fromModel(value))
  }
}

public object SubscriptionTopicCanFilterBySerializer : KSerializer<SubscriptionTopic.CanFilterBy> {
  internal val surrogateSerializer: KSerializer<SubscriptionTopicCanFilterBySurrogate> by lazy {
    SubscriptionTopicCanFilterBySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CanFilterBy", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.CanFilterBy =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.CanFilterBy) {
    surrogateSerializer.serialize(encoder, SubscriptionTopicCanFilterBySurrogate.fromModel(value))
  }
}

public object SubscriptionTopicNotificationShapeSerializer :
  KSerializer<SubscriptionTopic.NotificationShape> {
  internal val surrogateSerializer:
    KSerializer<SubscriptionTopicNotificationShapeSurrogate> by lazy {
    SubscriptionTopicNotificationShapeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NotificationShape", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.NotificationShape =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.NotificationShape) {
    surrogateSerializer.serialize(
      encoder,
      SubscriptionTopicNotificationShapeSurrogate.fromModel(value),
    )
  }
}

public object SubscriptionTopicVersionAlgorithmSerializer :
  KSerializer<SubscriptionTopic.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<SubscriptionTopicVersionAlgorithmSurrogate> by lazy {
    SubscriptionTopicVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      SubscriptionTopicVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object SubscriptionTopicSerializer : KSerializer<SubscriptionTopic> {
  internal val surrogateSerializer: KSerializer<SubscriptionTopicSurrogate> by lazy {
    SubscriptionTopicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubscriptionTopic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionTopic {
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

  override fun serialize(encoder: Encoder, `value`: SubscriptionTopic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubscriptionTopicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
