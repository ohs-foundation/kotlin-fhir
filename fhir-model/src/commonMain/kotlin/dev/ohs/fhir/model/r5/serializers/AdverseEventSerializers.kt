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

import com.google.fhir.model.r5.AdverseEvent
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.AdverseEventContributingFactorItemSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventContributingFactorSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventMitigatingActionItemSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventMitigatingActionSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventOccurrenceSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventParticipantSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventPreventiveActionItemSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventPreventiveActionSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSupportingInfoItemSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSupportingInfoSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSuspectEntityCausalitySurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSuspectEntityInstanceSurrogate
import com.google.fhir.model.r5.surrogates.AdverseEventSuspectEntitySurrogate
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

public object AdverseEventParticipantSerializer : KSerializer<AdverseEvent.Participant> {
  internal val surrogateSerializer: KSerializer<AdverseEventParticipantSurrogate> by lazy {
    AdverseEventParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Participant) {
    surrogateSerializer.serialize(encoder, AdverseEventParticipantSurrogate.fromModel(value))
  }
}

public object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  internal val surrogateSerializer: KSerializer<AdverseEventSuspectEntitySurrogate> by lazy {
    AdverseEventSuspectEntitySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("instance")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SuspectEntity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventSuspectEntitySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  internal val surrogateSerializer:
    KSerializer<AdverseEventSuspectEntityCausalitySurrogate> by lazy {
    AdverseEventSuspectEntityCausalitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Causality", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventSuspectEntityCausalitySurrogate.fromModel(value),
    )
  }
}

public object AdverseEventContributingFactorSerializer :
  KSerializer<AdverseEvent.ContributingFactor> {
  internal val surrogateSerializer: KSerializer<AdverseEventContributingFactorSurrogate> by lazy {
    AdverseEventContributingFactorSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContributingFactor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.ContributingFactor {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventContributingFactorSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object AdverseEventPreventiveActionSerializer : KSerializer<AdverseEvent.PreventiveAction> {
  internal val surrogateSerializer: KSerializer<AdverseEventPreventiveActionSurrogate> by lazy {
    AdverseEventPreventiveActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PreventiveAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.PreventiveAction {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventPreventiveActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object AdverseEventMitigatingActionSerializer : KSerializer<AdverseEvent.MitigatingAction> {
  internal val surrogateSerializer: KSerializer<AdverseEventMitigatingActionSurrogate> by lazy {
    AdverseEventMitigatingActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MitigatingAction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.MitigatingAction {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventMitigatingActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object AdverseEventSupportingInfoSerializer : KSerializer<AdverseEvent.SupportingInfo> {
  internal val surrogateSerializer: KSerializer<AdverseEventSupportingInfoSurrogate> by lazy {
    AdverseEventSupportingInfoSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupportingInfo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SupportingInfo {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventSupportingInfoSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object AdverseEventOccurrenceSerializer : KSerializer<AdverseEvent.Occurrence> {
  internal val surrogateSerializer: KSerializer<AdverseEventOccurrenceSurrogate> by lazy {
    AdverseEventOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.Occurrence) {
    surrogateSerializer.serialize(encoder, AdverseEventOccurrenceSurrogate.fromModel(value))
  }
}

public object AdverseEventSuspectEntityInstanceSerializer :
  KSerializer<AdverseEvent.SuspectEntity.Instance> {
  internal val surrogateSerializer:
    KSerializer<AdverseEventSuspectEntityInstanceSurrogate> by lazy {
    AdverseEventSuspectEntityInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Instance) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventSuspectEntityInstanceSurrogate.fromModel(value),
    )
  }
}

public object AdverseEventContributingFactorItemSerializer :
  KSerializer<AdverseEvent.ContributingFactor.Item> {
  internal val surrogateSerializer:
    KSerializer<AdverseEventContributingFactorItemSurrogate> by lazy {
    AdverseEventContributingFactorItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.ContributingFactor.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.ContributingFactor.Item) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventContributingFactorItemSurrogate.fromModel(value),
    )
  }
}

public object AdverseEventPreventiveActionItemSerializer :
  KSerializer<AdverseEvent.PreventiveAction.Item> {
  internal val surrogateSerializer: KSerializer<AdverseEventPreventiveActionItemSurrogate> by lazy {
    AdverseEventPreventiveActionItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.PreventiveAction.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.PreventiveAction.Item) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventPreventiveActionItemSurrogate.fromModel(value),
    )
  }
}

public object AdverseEventMitigatingActionItemSerializer :
  KSerializer<AdverseEvent.MitigatingAction.Item> {
  internal val surrogateSerializer: KSerializer<AdverseEventMitigatingActionItemSurrogate> by lazy {
    AdverseEventMitigatingActionItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.MitigatingAction.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.MitigatingAction.Item) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventMitigatingActionItemSurrogate.fromModel(value),
    )
  }
}

public object AdverseEventSupportingInfoItemSerializer :
  KSerializer<AdverseEvent.SupportingInfo.Item> {
  internal val surrogateSerializer: KSerializer<AdverseEventSupportingInfoItemSurrogate> by lazy {
    AdverseEventSupportingInfoItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SupportingInfo.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SupportingInfo.Item) {
    surrogateSerializer.serialize(encoder, AdverseEventSupportingInfoItemSurrogate.fromModel(value))
  }
}

public object AdverseEventSerializer : KSerializer<AdverseEvent> {
  internal val surrogateSerializer: KSerializer<AdverseEventSurrogate> by lazy {
    AdverseEventSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AdverseEvent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent {
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

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AdverseEventSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
