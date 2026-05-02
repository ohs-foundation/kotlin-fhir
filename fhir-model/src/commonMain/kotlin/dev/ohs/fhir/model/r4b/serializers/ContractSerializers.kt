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

import com.google.fhir.model.r4b.Contract
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.ContractContentDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.ContractFriendlyContentSurrogate
import com.google.fhir.model.r4b.surrogates.ContractFriendlySurrogate
import com.google.fhir.model.r4b.surrogates.ContractLegalContentSurrogate
import com.google.fhir.model.r4b.surrogates.ContractLegalSurrogate
import com.google.fhir.model.r4b.surrogates.ContractLegallyBindingSurrogate
import com.google.fhir.model.r4b.surrogates.ContractRuleContentSurrogate
import com.google.fhir.model.r4b.surrogates.ContractRuleSurrogate
import com.google.fhir.model.r4b.surrogates.ContractSignerSurrogate
import com.google.fhir.model.r4b.surrogates.ContractSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermActionOccurrenceSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermActionSubjectSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermActionSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermAssetContextSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermAssetSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermAssetValuedItemEntitySurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermAssetValuedItemSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermOfferAnswerSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermOfferAnswerValueSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermOfferPartySurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermOfferSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermSecurityLabelSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTermTopicSurrogate
import com.google.fhir.model.r4b.surrogates.ContractTopicSurrogate
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

public object ContractContentDefinitionSerializer : KSerializer<Contract.ContentDefinition> {
  internal val surrogateSerializer: KSerializer<ContractContentDefinitionSurrogate> by lazy {
    ContractContentDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContentDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.ContentDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.ContentDefinition) {
    surrogateSerializer.serialize(encoder, ContractContentDefinitionSurrogate.fromModel(value))
  }
}

public object ContractTermSerializer : KSerializer<Contract.Term> {
  internal val surrogateSerializer: KSerializer<ContractTermSurrogate> by lazy {
    ContractTermSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("topic")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Term", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractTermSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractTermSecurityLabelSerializer : KSerializer<Contract.Term.SecurityLabel> {
  internal val surrogateSerializer: KSerializer<ContractTermSecurityLabelSurrogate> by lazy {
    ContractTermSecurityLabelSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SecurityLabel", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.SecurityLabel =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.SecurityLabel) {
    surrogateSerializer.serialize(encoder, ContractTermSecurityLabelSurrogate.fromModel(value))
  }
}

public object ContractTermOfferSerializer : KSerializer<Contract.Term.Offer> {
  internal val surrogateSerializer: KSerializer<ContractTermOfferSurrogate> by lazy {
    ContractTermOfferSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Offer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Offer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer) {
    surrogateSerializer.serialize(encoder, ContractTermOfferSurrogate.fromModel(value))
  }
}

public object ContractTermOfferPartySerializer : KSerializer<Contract.Term.Offer.Party> {
  internal val surrogateSerializer: KSerializer<ContractTermOfferPartySurrogate> by lazy {
    ContractTermOfferPartySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Party", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Party =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Party) {
    surrogateSerializer.serialize(encoder, ContractTermOfferPartySurrogate.fromModel(value))
  }
}

public object ContractTermOfferAnswerSerializer : KSerializer<Contract.Term.Offer.Answer> {
  internal val surrogateSerializer: KSerializer<ContractTermOfferAnswerSurrogate> by lazy {
    ContractTermOfferAnswerSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Answer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Answer {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Answer) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractTermOfferAnswerSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractTermAssetSerializer : KSerializer<Contract.Term.Asset> {
  internal val surrogateSerializer: KSerializer<ContractTermAssetSurrogate> by lazy {
    ContractTermAssetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Asset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Asset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset) {
    surrogateSerializer.serialize(encoder, ContractTermAssetSurrogate.fromModel(value))
  }
}

public object ContractTermAssetContextSerializer : KSerializer<Contract.Term.Asset.Context> {
  internal val surrogateSerializer: KSerializer<ContractTermAssetContextSurrogate> by lazy {
    ContractTermAssetContextSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Context", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.Context =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.Context) {
    surrogateSerializer.serialize(encoder, ContractTermAssetContextSurrogate.fromModel(value))
  }
}

public object ContractTermAssetValuedItemSerializer : KSerializer<Contract.Term.Asset.ValuedItem> {
  internal val surrogateSerializer: KSerializer<ContractTermAssetValuedItemSurrogate> by lazy {
    ContractTermAssetValuedItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("entity")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ValuedItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.ValuedItem {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.ValuedItem) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractTermAssetValuedItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractTermActionSerializer : KSerializer<Contract.Term.Action> {
  internal val surrogateSerializer: KSerializer<ContractTermActionSurrogate> by lazy {
    ContractTermActionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Action {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractTermActionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractTermActionSubjectSerializer : KSerializer<Contract.Term.Action.Subject> {
  internal val surrogateSerializer: KSerializer<ContractTermActionSubjectSurrogate> by lazy {
    ContractTermActionSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Action.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action.Subject) {
    surrogateSerializer.serialize(encoder, ContractTermActionSubjectSurrogate.fromModel(value))
  }
}

public object ContractSignerSerializer : KSerializer<Contract.Signer> {
  internal val surrogateSerializer: KSerializer<ContractSignerSurrogate> by lazy {
    ContractSignerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Signer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Signer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Signer) {
    surrogateSerializer.serialize(encoder, ContractSignerSurrogate.fromModel(value))
  }
}

public object ContractFriendlySerializer : KSerializer<Contract.Friendly> {
  internal val surrogateSerializer: KSerializer<ContractFriendlySurrogate> by lazy {
    ContractFriendlySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("content")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Friendly", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Friendly {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Friendly) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractFriendlySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractLegalSerializer : KSerializer<Contract.Legal> {
  internal val surrogateSerializer: KSerializer<ContractLegalSurrogate> by lazy {
    ContractLegalSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("content")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Legal", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Legal {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Legal) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractLegalSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractRuleSerializer : KSerializer<Contract.Rule> {
  internal val surrogateSerializer: KSerializer<ContractRuleSurrogate> by lazy {
    ContractRuleSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("content")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Rule", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Rule {
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

  override fun serialize(encoder: Encoder, `value`: Contract.Rule) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractRuleSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ContractTopicSerializer : KSerializer<Contract.Topic> {
  internal val surrogateSerializer: KSerializer<ContractTopicSurrogate> by lazy {
    ContractTopicSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Topic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Topic =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Topic) {
    surrogateSerializer.serialize(encoder, ContractTopicSurrogate.fromModel(value))
  }
}

public object ContractTermTopicSerializer : KSerializer<Contract.Term.Topic> {
  internal val surrogateSerializer: KSerializer<ContractTermTopicSurrogate> by lazy {
    ContractTermTopicSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Topic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Topic =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Topic) {
    surrogateSerializer.serialize(encoder, ContractTermTopicSurrogate.fromModel(value))
  }
}

public object ContractTermOfferAnswerValueSerializer :
  KSerializer<Contract.Term.Offer.Answer.Value> {
  internal val surrogateSerializer: KSerializer<ContractTermOfferAnswerValueSurrogate> by lazy {
    ContractTermOfferAnswerValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Answer.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Answer.Value) {
    surrogateSerializer.serialize(encoder, ContractTermOfferAnswerValueSurrogate.fromModel(value))
  }
}

public object ContractTermAssetValuedItemEntitySerializer :
  KSerializer<Contract.Term.Asset.ValuedItem.Entity> {
  internal val surrogateSerializer:
    KSerializer<ContractTermAssetValuedItemEntitySurrogate> by lazy {
    ContractTermAssetValuedItemEntitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Entity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.ValuedItem.Entity =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.ValuedItem.Entity) {
    surrogateSerializer.serialize(
      encoder,
      ContractTermAssetValuedItemEntitySurrogate.fromModel(value),
    )
  }
}

public object ContractTermActionOccurrenceSerializer :
  KSerializer<Contract.Term.Action.Occurrence> {
  internal val surrogateSerializer: KSerializer<ContractTermActionOccurrenceSurrogate> by lazy {
    ContractTermActionOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Term.Action.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action.Occurrence) {
    surrogateSerializer.serialize(encoder, ContractTermActionOccurrenceSurrogate.fromModel(value))
  }
}

public object ContractFriendlyContentSerializer : KSerializer<Contract.Friendly.Content> {
  internal val surrogateSerializer: KSerializer<ContractFriendlyContentSurrogate> by lazy {
    ContractFriendlyContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Friendly.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Friendly.Content) {
    surrogateSerializer.serialize(encoder, ContractFriendlyContentSurrogate.fromModel(value))
  }
}

public object ContractLegalContentSerializer : KSerializer<Contract.Legal.Content> {
  internal val surrogateSerializer: KSerializer<ContractLegalContentSurrogate> by lazy {
    ContractLegalContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Legal.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Legal.Content) {
    surrogateSerializer.serialize(encoder, ContractLegalContentSurrogate.fromModel(value))
  }
}

public object ContractRuleContentSerializer : KSerializer<Contract.Rule.Content> {
  internal val surrogateSerializer: KSerializer<ContractRuleContentSurrogate> by lazy {
    ContractRuleContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.Rule.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.Rule.Content) {
    surrogateSerializer.serialize(encoder, ContractRuleContentSurrogate.fromModel(value))
  }
}

public object ContractLegallyBindingSerializer : KSerializer<Contract.LegallyBinding> {
  internal val surrogateSerializer: KSerializer<ContractLegallyBindingSurrogate> by lazy {
    ContractLegallyBindingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("LegallyBinding", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract.LegallyBinding =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Contract.LegallyBinding) {
    surrogateSerializer.serialize(encoder, ContractLegallyBindingSurrogate.fromModel(value))
  }
}

public object ContractSerializer : KSerializer<Contract> {
  internal val surrogateSerializer: KSerializer<ContractSurrogate> by lazy {
    ContractSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("topic", "legallyBinding")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Contract", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Contract {
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

  override fun serialize(encoder: Encoder, `value`: Contract) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ContractSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
