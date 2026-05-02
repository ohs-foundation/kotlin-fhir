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
import com.google.fhir.model.r4.PlanDefinition
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionConditionSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionDefinitionSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionDynamicValueSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionParticipantSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionRelatedActionOffsetSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionRelatedActionSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionSubjectSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionActionTimingSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionGoalSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionGoalTargetDetailSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionGoalTargetSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionSubjectSurrogate
import com.google.fhir.model.r4.surrogates.PlanDefinitionSurrogate
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

public object PlanDefinitionGoalSerializer : KSerializer<PlanDefinition.Goal> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionGoalSurrogate> by lazy {
    PlanDefinitionGoalSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Goal", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal) {
    surrogateSerializer.serialize(encoder, PlanDefinitionGoalSurrogate.fromModel(value))
  }
}

public object PlanDefinitionGoalTargetSerializer : KSerializer<PlanDefinition.Goal.Target> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionGoalTargetSurrogate> by lazy {
    PlanDefinitionGoalTargetSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("detail")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target {
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

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PlanDefinitionGoalTargetSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object PlanDefinitionActionSerializer : KSerializer<PlanDefinition.Action> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionSurrogate> by lazy {
    PlanDefinitionActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject", "timing", "definition")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action {
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

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PlanDefinitionActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object PlanDefinitionActionConditionSerializer :
  KSerializer<PlanDefinition.Action.Condition> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionConditionSurrogate> by lazy {
    PlanDefinitionActionConditionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Condition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Condition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Condition) {
    surrogateSerializer.serialize(encoder, PlanDefinitionActionConditionSurrogate.fromModel(value))
  }
}

public object PlanDefinitionActionRelatedActionSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction> {
  internal val surrogateSerializer:
    KSerializer<PlanDefinitionActionRelatedActionSurrogate> by lazy {
    PlanDefinitionActionRelatedActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("offset")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatedAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction {
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

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PlanDefinitionActionRelatedActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object PlanDefinitionActionParticipantSerializer :
  KSerializer<PlanDefinition.Action.Participant> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionParticipantSurrogate> by lazy {
    PlanDefinitionActionParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Participant) {
    surrogateSerializer.serialize(
      encoder,
      PlanDefinitionActionParticipantSurrogate.fromModel(value),
    )
  }
}

public object PlanDefinitionActionDynamicValueSerializer :
  KSerializer<PlanDefinition.Action.DynamicValue> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionDynamicValueSurrogate> by lazy {
    PlanDefinitionActionDynamicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DynamicValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.DynamicValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.DynamicValue) {
    surrogateSerializer.serialize(
      encoder,
      PlanDefinitionActionDynamicValueSurrogate.fromModel(value),
    )
  }
}

public object PlanDefinitionSubjectSerializer : KSerializer<PlanDefinition.Subject> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionSubjectSurrogate> by lazy {
    PlanDefinitionSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Subject) {
    surrogateSerializer.serialize(encoder, PlanDefinitionSubjectSurrogate.fromModel(value))
  }
}

public object PlanDefinitionGoalTargetDetailSerializer :
  KSerializer<PlanDefinition.Goal.Target.Detail> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionGoalTargetDetailSurrogate> by lazy {
    PlanDefinitionGoalTargetDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Goal.Target.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Goal.Target.Detail) {
    surrogateSerializer.serialize(encoder, PlanDefinitionGoalTargetDetailSurrogate.fromModel(value))
  }
}

public object PlanDefinitionActionSubjectSerializer : KSerializer<PlanDefinition.Action.Subject> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionSubjectSurrogate> by lazy {
    PlanDefinitionActionSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Subject) {
    surrogateSerializer.serialize(encoder, PlanDefinitionActionSubjectSurrogate.fromModel(value))
  }
}

public object PlanDefinitionActionRelatedActionOffsetSerializer :
  KSerializer<PlanDefinition.Action.RelatedAction.Offset> {
  internal val surrogateSerializer:
    KSerializer<PlanDefinitionActionRelatedActionOffsetSurrogate> by lazy {
    PlanDefinitionActionRelatedActionOffsetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Offset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.RelatedAction.Offset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.RelatedAction.Offset) {
    surrogateSerializer.serialize(
      encoder,
      PlanDefinitionActionRelatedActionOffsetSurrogate.fromModel(value),
    )
  }
}

public object PlanDefinitionActionTimingSerializer : KSerializer<PlanDefinition.Action.Timing> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionTimingSurrogate> by lazy {
    PlanDefinitionActionTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Timing) {
    surrogateSerializer.serialize(encoder, PlanDefinitionActionTimingSurrogate.fromModel(value))
  }
}

public object PlanDefinitionActionDefinitionSerializer :
  KSerializer<PlanDefinition.Action.Definition> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionActionDefinitionSurrogate> by lazy {
    PlanDefinitionActionDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Definition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition.Action.Definition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PlanDefinition.Action.Definition) {
    surrogateSerializer.serialize(encoder, PlanDefinitionActionDefinitionSurrogate.fromModel(value))
  }
}

public object PlanDefinitionSerializer : KSerializer<PlanDefinition> {
  internal val surrogateSerializer: KSerializer<PlanDefinitionSurrogate> by lazy {
    PlanDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PlanDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PlanDefinition {
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

  override fun serialize(encoder: Encoder, `value`: PlanDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PlanDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
