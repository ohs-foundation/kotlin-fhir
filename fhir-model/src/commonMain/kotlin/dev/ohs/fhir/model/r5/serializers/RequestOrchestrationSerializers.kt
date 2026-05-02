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
import com.google.fhir.model.r5.RequestOrchestration
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionConditionSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionDynamicValueSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionInputSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionOutputSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionParticipantActorSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionParticipantSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionRelatedActionOffsetSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionRelatedActionSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationActionTimingSurrogate
import com.google.fhir.model.r5.surrogates.RequestOrchestrationSurrogate
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

public object RequestOrchestrationActionSerializer : KSerializer<RequestOrchestration.Action> {
  internal val surrogateSerializer: KSerializer<RequestOrchestrationActionSurrogate> by lazy {
    RequestOrchestrationActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("timing", "definition")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action {
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

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RequestOrchestrationActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RequestOrchestrationActionConditionSerializer :
  KSerializer<RequestOrchestration.Action.Condition> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionConditionSurrogate> by lazy {
    RequestOrchestrationActionConditionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Condition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Condition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Condition) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionConditionSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionInputSerializer :
  KSerializer<RequestOrchestration.Action.Input> {
  internal val surrogateSerializer: KSerializer<RequestOrchestrationActionInputSurrogate> by lazy {
    RequestOrchestrationActionInputSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Input", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Input =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Input) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionInputSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionOutputSerializer :
  KSerializer<RequestOrchestration.Action.Output> {
  internal val surrogateSerializer: KSerializer<RequestOrchestrationActionOutputSurrogate> by lazy {
    RequestOrchestrationActionOutputSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Output", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Output =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Output) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionOutputSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionRelatedActionSerializer :
  KSerializer<RequestOrchestration.Action.RelatedAction> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionRelatedActionSurrogate> by lazy {
    RequestOrchestrationActionRelatedActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("offset")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatedAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction {
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

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.RelatedAction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RequestOrchestrationActionRelatedActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RequestOrchestrationActionParticipantSerializer :
  KSerializer<RequestOrchestration.Action.Participant> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionParticipantSurrogate> by lazy {
    RequestOrchestrationActionParticipantSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("actor")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant {
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

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Participant) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = RequestOrchestrationActionParticipantSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object RequestOrchestrationActionDynamicValueSerializer :
  KSerializer<RequestOrchestration.Action.DynamicValue> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionDynamicValueSurrogate> by lazy {
    RequestOrchestrationActionDynamicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DynamicValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.DynamicValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.DynamicValue) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionDynamicValueSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionRelatedActionOffsetSerializer :
  KSerializer<RequestOrchestration.Action.RelatedAction.Offset> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionRelatedActionOffsetSurrogate> by lazy {
    RequestOrchestrationActionRelatedActionOffsetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Offset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.RelatedAction.Offset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: RequestOrchestration.Action.RelatedAction.Offset,
  ) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionRelatedActionOffsetSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionTimingSerializer :
  KSerializer<RequestOrchestration.Action.Timing> {
  internal val surrogateSerializer: KSerializer<RequestOrchestrationActionTimingSurrogate> by lazy {
    RequestOrchestrationActionTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Timing) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionTimingSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionParticipantActorSerializer :
  KSerializer<RequestOrchestration.Action.Participant.Actor> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionParticipantActorSurrogate> by lazy {
    RequestOrchestrationActionParticipantActorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Actor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Participant.Actor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Participant.Actor) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionParticipantActorSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationActionDefinitionSerializer :
  KSerializer<RequestOrchestration.Action.Definition> {
  internal val surrogateSerializer:
    KSerializer<RequestOrchestrationActionDefinitionSurrogate> by lazy {
    RequestOrchestrationActionDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Definition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration.Action.Definition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration.Action.Definition) {
    surrogateSerializer.serialize(
      encoder,
      RequestOrchestrationActionDefinitionSurrogate.fromModel(value),
    )
  }
}

public object RequestOrchestrationSerializer : KSerializer<RequestOrchestration> {
  internal val surrogateSerializer: KSerializer<RequestOrchestrationSurrogate> by lazy {
    RequestOrchestrationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RequestOrchestration", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RequestOrchestration =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RequestOrchestration) {
    surrogateSerializer.serialize(encoder, RequestOrchestrationSurrogate.fromModel(value))
  }
}
