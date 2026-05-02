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
import com.google.fhir.model.r4.RequestGroup
import com.google.fhir.model.r4.surrogates.RequestGroupActionConditionSurrogate
import com.google.fhir.model.r4.surrogates.RequestGroupActionRelatedActionOffsetSurrogate
import com.google.fhir.model.r4.surrogates.RequestGroupActionRelatedActionSurrogate
import com.google.fhir.model.r4.surrogates.RequestGroupActionSurrogate
import com.google.fhir.model.r4.surrogates.RequestGroupActionTimingSurrogate
import com.google.fhir.model.r4.surrogates.RequestGroupSurrogate
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

public object RequestGroupActionSerializer : KSerializer<RequestGroup.Action> {
  internal val surrogateSerializer: KSerializer<RequestGroupActionSurrogate> by lazy {
    RequestGroupActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("timing")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action {
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

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RequestGroupActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RequestGroupActionConditionSerializer : KSerializer<RequestGroup.Action.Condition> {
  internal val surrogateSerializer: KSerializer<RequestGroupActionConditionSurrogate> by lazy {
    RequestGroupActionConditionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Condition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.Condition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Condition) {
    surrogateSerializer.serialize(encoder, RequestGroupActionConditionSurrogate.fromModel(value))
  }
}

public object RequestGroupActionRelatedActionSerializer :
  KSerializer<RequestGroup.Action.RelatedAction> {
  internal val surrogateSerializer: KSerializer<RequestGroupActionRelatedActionSurrogate> by lazy {
    RequestGroupActionRelatedActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("offset")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatedAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.RelatedAction {
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

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RequestGroupActionRelatedActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RequestGroupActionRelatedActionOffsetSerializer :
  KSerializer<RequestGroup.Action.RelatedAction.Offset> {
  internal val surrogateSerializer:
    KSerializer<RequestGroupActionRelatedActionOffsetSurrogate> by lazy {
    RequestGroupActionRelatedActionOffsetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Offset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.RelatedAction.Offset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.RelatedAction.Offset) {
    surrogateSerializer.serialize(
      encoder,
      RequestGroupActionRelatedActionOffsetSurrogate.fromModel(value),
    )
  }
}

public object RequestGroupActionTimingSerializer : KSerializer<RequestGroup.Action.Timing> {
  internal val surrogateSerializer: KSerializer<RequestGroupActionTimingSurrogate> by lazy {
    RequestGroupActionTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup.Action.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestGroup.Action.Timing) {
    surrogateSerializer.serialize(encoder, RequestGroupActionTimingSurrogate.fromModel(value))
  }
}

public object RequestGroupSerializer : KSerializer<RequestGroup> {
  internal val surrogateSerializer: KSerializer<RequestGroupSurrogate> by lazy {
    RequestGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RequestGroup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestGroup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestGroup) {
    surrogateSerializer.serialize(encoder, RequestGroupSurrogate.fromModel(value))
  }
}
