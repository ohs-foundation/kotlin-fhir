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

import com.google.fhir.model.r5.ExplanationOfBenefit
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAccidentLocationSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAccidentSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemBodySiteSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemDetailSubDetailSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemDetailSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemLocationSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemServicedSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitAddItemSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitBenefitBalanceFinancialSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitBenefitBalanceSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitCareTeamSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitDiagnosisDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitEventSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitEventWhenSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitInsuranceSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemAdjudicationSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemBodySiteSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemDetailSubDetailSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemDetailSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemLocationSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemReviewOutcomeSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemServicedSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitItemSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitPayeeSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitPaymentSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitProcedureProcedureSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitProcedureSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitProcessNoteSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitRelatedSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitSupportingInfoSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitSupportingInfoTimingSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitSupportingInfoValueSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitSurrogate
import com.google.fhir.model.r5.surrogates.ExplanationOfBenefitTotalSurrogate
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

public object ExplanationOfBenefitRelatedSerializer : KSerializer<ExplanationOfBenefit.Related> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitRelatedSurrogate> by lazy {
    ExplanationOfBenefitRelatedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Related", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Related =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Related) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitRelatedSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitEventSerializer : KSerializer<ExplanationOfBenefit.Event> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitEventSurrogate> by lazy {
    ExplanationOfBenefitEventSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("when")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Event {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Event) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitEventSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitPayeeSerializer : KSerializer<ExplanationOfBenefit.Payee> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitPayeeSurrogate> by lazy {
    ExplanationOfBenefitPayeeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Payee", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payee =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payee) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitPayeeSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitCareTeamSerializer : KSerializer<ExplanationOfBenefit.CareTeam> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitCareTeamSurrogate> by lazy {
    ExplanationOfBenefitCareTeamSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CareTeam", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.CareTeam =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.CareTeam) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitCareTeamSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitSupportingInfoSerializer :
  KSerializer<ExplanationOfBenefit.SupportingInfo> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitSupportingInfoSurrogate> by lazy {
    ExplanationOfBenefitSupportingInfoSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("timing", "value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupportingInfo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitSupportingInfoSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitDiagnosisSerializer :
  KSerializer<ExplanationOfBenefit.Diagnosis> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitDiagnosisSurrogate> by lazy {
    ExplanationOfBenefitDiagnosisSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("diagnosis")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Diagnosis {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitDiagnosisSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitProcedureSerializer :
  KSerializer<ExplanationOfBenefit.Procedure> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitProcedureSurrogate> by lazy {
    ExplanationOfBenefitProcedureSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("procedure")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Procedure {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitProcedureSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitInsuranceSerializer :
  KSerializer<ExplanationOfBenefit.Insurance> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitInsuranceSurrogate> by lazy {
    ExplanationOfBenefitInsuranceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Insurance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Insurance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Insurance) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitInsuranceSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitAccidentSerializer : KSerializer<ExplanationOfBenefit.Accident> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitAccidentSurrogate> by lazy {
    ExplanationOfBenefitAccidentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("location")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Accident", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Accident {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitAccidentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitItemSerializer : KSerializer<ExplanationOfBenefit.Item> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitItemSurrogate> by lazy {
    ExplanationOfBenefitItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced", "location")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.Item.BodySite> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitItemBodySiteSurrogate> by lazy {
    ExplanationOfBenefitItemBodySiteSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BodySite", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.BodySite =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.BodySite) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemBodySiteSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitItemReviewOutcomeSerializer :
  KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitItemReviewOutcomeSurrogate> by lazy {
    ExplanationOfBenefitItemReviewOutcomeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReviewOutcome", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.ReviewOutcome =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.ReviewOutcome) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemReviewOutcomeSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitItemAdjudicationSerializer :
  KSerializer<ExplanationOfBenefit.Item.Adjudication> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitItemAdjudicationSurrogate> by lazy {
    ExplanationOfBenefitItemAdjudicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Adjudication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Adjudication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Adjudication) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemAdjudicationSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitItemDetailSurrogate> by lazy {
    ExplanationOfBenefitItemDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitItemDetailSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail.SubDetail> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitItemDetailSubDetailSurrogate> by lazy {
    ExplanationOfBenefitItemDetailSubDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubDetail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail.SubDetail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail.SubDetail) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemDetailSubDetailSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAddItemSerializer : KSerializer<ExplanationOfBenefit.AddItem> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitAddItemSurrogate> by lazy {
    ExplanationOfBenefitAddItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced", "location")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AddItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitAddItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitAddItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.BodySite> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAddItemBodySiteSurrogate> by lazy {
    ExplanationOfBenefitAddItemBodySiteSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BodySite", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.BodySite =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.BodySite) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAddItemBodySiteSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAddItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAddItemDetailSurrogate> by lazy {
    ExplanationOfBenefitAddItemDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAddItemDetailSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAddItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail.SubDetail> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAddItemDetailSubDetailSurrogate> by lazy {
    ExplanationOfBenefitAddItemDetailSubDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubDetail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail.SubDetail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAddItemDetailSubDetailSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitTotalSerializer : KSerializer<ExplanationOfBenefit.Total> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitTotalSurrogate> by lazy {
    ExplanationOfBenefitTotalSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Total", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Total =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Total) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitTotalSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitPaymentSerializer : KSerializer<ExplanationOfBenefit.Payment> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitPaymentSurrogate> by lazy {
    ExplanationOfBenefitPaymentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Payment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payment =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payment) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitPaymentSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitProcessNoteSerializer :
  KSerializer<ExplanationOfBenefit.ProcessNote> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitProcessNoteSurrogate> by lazy {
    ExplanationOfBenefitProcessNoteSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ProcessNote", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.ProcessNote =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.ProcessNote) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitProcessNoteSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitBenefitBalanceSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitBenefitBalanceSurrogate> by lazy {
    ExplanationOfBenefitBenefitBalanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BenefitBalance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitBenefitBalanceSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitBenefitBalanceFinancialSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance.Financial> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitBenefitBalanceFinancialSurrogate> by lazy {
    ExplanationOfBenefitBenefitBalanceFinancialSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("allowed", "used")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Financial", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance.Financial {
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

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance.Financial) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExplanationOfBenefitBenefitBalanceFinancialSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExplanationOfBenefitEventWhenSerializer :
  KSerializer<ExplanationOfBenefit.Event.When> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitEventWhenSurrogate> by lazy {
    ExplanationOfBenefitEventWhenSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("When", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Event.When =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Event.When) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitEventWhenSurrogate.fromModel(value))
  }
}

public object ExplanationOfBenefitSupportingInfoTimingSerializer :
  KSerializer<ExplanationOfBenefit.SupportingInfo.Timing> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitSupportingInfoTimingSurrogate> by lazy {
    ExplanationOfBenefitSupportingInfoTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo.Timing) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitSupportingInfoTimingSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitSupportingInfoValueSerializer :
  KSerializer<ExplanationOfBenefit.SupportingInfo.Value> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitSupportingInfoValueSurrogate> by lazy {
    ExplanationOfBenefitSupportingInfoValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo.Value) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitSupportingInfoValueSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitDiagnosisDiagnosisSerializer :
  KSerializer<ExplanationOfBenefit.Diagnosis.Diagnosis> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitDiagnosisDiagnosisSurrogate> by lazy {
    ExplanationOfBenefitDiagnosisDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Diagnosis.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis.Diagnosis) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitDiagnosisDiagnosisSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitProcedureProcedureSerializer :
  KSerializer<ExplanationOfBenefit.Procedure.Procedure> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitProcedureProcedureSurrogate> by lazy {
    ExplanationOfBenefitProcedureProcedureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Procedure.Procedure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure.Procedure) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitProcedureProcedureSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAccidentLocationSerializer :
  KSerializer<ExplanationOfBenefit.Accident.Location> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAccidentLocationSurrogate> by lazy {
    ExplanationOfBenefitAccidentLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Accident.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident.Location) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAccidentLocationSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitItemServicedSerializer :
  KSerializer<ExplanationOfBenefit.Item.Serviced> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitItemServicedSurrogate> by lazy {
    ExplanationOfBenefitItemServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Serviced) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemServicedSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitItemLocationSerializer :
  KSerializer<ExplanationOfBenefit.Item.Location> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitItemLocationSurrogate> by lazy {
    ExplanationOfBenefitItemLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Location) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitItemLocationSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAddItemServicedSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Serviced> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAddItemServicedSurrogate> by lazy {
    ExplanationOfBenefitAddItemServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Serviced) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAddItemServicedSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitAddItemLocationSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Location> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitAddItemLocationSurrogate> by lazy {
    ExplanationOfBenefitAddItemLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Location) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitAddItemLocationSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitBenefitBalanceFinancialAllowedSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance.Financial.Allowed> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate> by lazy {
    ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Allowed", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ExplanationOfBenefit.BenefitBalance.Financial.Allowed =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ExplanationOfBenefit.BenefitBalance.Financial.Allowed,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitBenefitBalanceFinancialUsedSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance.Financial.Used> {
  internal val surrogateSerializer:
    KSerializer<ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate> by lazy {
    ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Used", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance.Financial.Used =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ExplanationOfBenefit.BenefitBalance.Financial.Used,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate.fromModel(value),
    )
  }
}

public object ExplanationOfBenefitSerializer : KSerializer<ExplanationOfBenefit> {
  internal val surrogateSerializer: KSerializer<ExplanationOfBenefitSurrogate> by lazy {
    ExplanationOfBenefitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ExplanationOfBenefit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit) {
    surrogateSerializer.serialize(encoder, ExplanationOfBenefitSurrogate.fromModel(value))
  }
}
