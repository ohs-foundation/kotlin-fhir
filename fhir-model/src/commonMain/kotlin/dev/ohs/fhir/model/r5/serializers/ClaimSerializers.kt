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

import com.google.fhir.model.r5.Claim
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ClaimAccidentLocationSurrogate
import com.google.fhir.model.r5.surrogates.ClaimAccidentSurrogate
import com.google.fhir.model.r5.surrogates.ClaimCareTeamSurrogate
import com.google.fhir.model.r5.surrogates.ClaimDiagnosisDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.ClaimDiagnosisSurrogate
import com.google.fhir.model.r5.surrogates.ClaimEventSurrogate
import com.google.fhir.model.r5.surrogates.ClaimEventWhenSurrogate
import com.google.fhir.model.r5.surrogates.ClaimInsuranceSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemBodySiteSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemDetailSubDetailSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemDetailSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemLocationSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemServicedSurrogate
import com.google.fhir.model.r5.surrogates.ClaimItemSurrogate
import com.google.fhir.model.r5.surrogates.ClaimPayeeSurrogate
import com.google.fhir.model.r5.surrogates.ClaimProcedureProcedureSurrogate
import com.google.fhir.model.r5.surrogates.ClaimProcedureSurrogate
import com.google.fhir.model.r5.surrogates.ClaimRelatedSurrogate
import com.google.fhir.model.r5.surrogates.ClaimSupportingInfoSurrogate
import com.google.fhir.model.r5.surrogates.ClaimSupportingInfoTimingSurrogate
import com.google.fhir.model.r5.surrogates.ClaimSupportingInfoValueSurrogate
import com.google.fhir.model.r5.surrogates.ClaimSurrogate
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

public object ClaimRelatedSerializer : KSerializer<Claim.Related> {
  internal val surrogateSerializer: KSerializer<ClaimRelatedSurrogate> by lazy {
    ClaimRelatedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Related", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Related =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Related) {
    surrogateSerializer.serialize(encoder, ClaimRelatedSurrogate.fromModel(value))
  }
}

public object ClaimPayeeSerializer : KSerializer<Claim.Payee> {
  internal val surrogateSerializer: KSerializer<ClaimPayeeSurrogate> by lazy {
    ClaimPayeeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Payee", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Payee =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Payee) {
    surrogateSerializer.serialize(encoder, ClaimPayeeSurrogate.fromModel(value))
  }
}

public object ClaimEventSerializer : KSerializer<Claim.Event> {
  internal val surrogateSerializer: KSerializer<ClaimEventSurrogate> by lazy {
    ClaimEventSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("when")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Event {
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

  override fun serialize(encoder: Encoder, `value`: Claim.Event) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimEventSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimCareTeamSerializer : KSerializer<Claim.CareTeam> {
  internal val surrogateSerializer: KSerializer<ClaimCareTeamSurrogate> by lazy {
    ClaimCareTeamSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CareTeam", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.CareTeam =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.CareTeam) {
    surrogateSerializer.serialize(encoder, ClaimCareTeamSurrogate.fromModel(value))
  }
}

public object ClaimSupportingInfoSerializer : KSerializer<Claim.SupportingInfo> {
  internal val surrogateSerializer: KSerializer<ClaimSupportingInfoSurrogate> by lazy {
    ClaimSupportingInfoSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("timing", "value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupportingInfo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo {
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

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimSupportingInfoSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimDiagnosisSerializer : KSerializer<Claim.Diagnosis> {
  internal val surrogateSerializer: KSerializer<ClaimDiagnosisSurrogate> by lazy {
    ClaimDiagnosisSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("diagnosis")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Diagnosis {
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

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimDiagnosisSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimProcedureSerializer : KSerializer<Claim.Procedure> {
  internal val surrogateSerializer: KSerializer<ClaimProcedureSurrogate> by lazy {
    ClaimProcedureSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("procedure")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Procedure {
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

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimProcedureSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimInsuranceSerializer : KSerializer<Claim.Insurance> {
  internal val surrogateSerializer: KSerializer<ClaimInsuranceSurrogate> by lazy {
    ClaimInsuranceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Insurance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Insurance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Insurance) {
    surrogateSerializer.serialize(encoder, ClaimInsuranceSurrogate.fromModel(value))
  }
}

public object ClaimAccidentSerializer : KSerializer<Claim.Accident> {
  internal val surrogateSerializer: KSerializer<ClaimAccidentSurrogate> by lazy {
    ClaimAccidentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("location")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Accident", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Accident {
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

  override fun serialize(encoder: Encoder, `value`: Claim.Accident) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimAccidentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimItemSerializer : KSerializer<Claim.Item> {
  internal val surrogateSerializer: KSerializer<ClaimItemSurrogate> by lazy {
    ClaimItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced", "location")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item {
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

  override fun serialize(encoder: Encoder, `value`: Claim.Item) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClaimItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ClaimItemBodySiteSerializer : KSerializer<Claim.Item.BodySite> {
  internal val surrogateSerializer: KSerializer<ClaimItemBodySiteSurrogate> by lazy {
    ClaimItemBodySiteSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BodySite", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.BodySite =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Item.BodySite) {
    surrogateSerializer.serialize(encoder, ClaimItemBodySiteSurrogate.fromModel(value))
  }
}

public object ClaimItemDetailSerializer : KSerializer<Claim.Item.Detail> {
  internal val surrogateSerializer: KSerializer<ClaimItemDetailSurrogate> by lazy {
    ClaimItemDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail) {
    surrogateSerializer.serialize(encoder, ClaimItemDetailSurrogate.fromModel(value))
  }
}

public object ClaimItemDetailSubDetailSerializer : KSerializer<Claim.Item.Detail.SubDetail> {
  internal val surrogateSerializer: KSerializer<ClaimItemDetailSubDetailSurrogate> by lazy {
    ClaimItemDetailSubDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubDetail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail.SubDetail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail.SubDetail) {
    surrogateSerializer.serialize(encoder, ClaimItemDetailSubDetailSurrogate.fromModel(value))
  }
}

public object ClaimEventWhenSerializer : KSerializer<Claim.Event.When> {
  internal val surrogateSerializer: KSerializer<ClaimEventWhenSurrogate> by lazy {
    ClaimEventWhenSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("When", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Event.When =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Event.When) {
    surrogateSerializer.serialize(encoder, ClaimEventWhenSurrogate.fromModel(value))
  }
}

public object ClaimSupportingInfoTimingSerializer : KSerializer<Claim.SupportingInfo.Timing> {
  internal val surrogateSerializer: KSerializer<ClaimSupportingInfoTimingSurrogate> by lazy {
    ClaimSupportingInfoTimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo.Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo.Timing) {
    surrogateSerializer.serialize(encoder, ClaimSupportingInfoTimingSurrogate.fromModel(value))
  }
}

public object ClaimSupportingInfoValueSerializer : KSerializer<Claim.SupportingInfo.Value> {
  internal val surrogateSerializer: KSerializer<ClaimSupportingInfoValueSurrogate> by lazy {
    ClaimSupportingInfoValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo.Value) {
    surrogateSerializer.serialize(encoder, ClaimSupportingInfoValueSurrogate.fromModel(value))
  }
}

public object ClaimDiagnosisDiagnosisSerializer : KSerializer<Claim.Diagnosis.Diagnosis> {
  internal val surrogateSerializer: KSerializer<ClaimDiagnosisDiagnosisSurrogate> by lazy {
    ClaimDiagnosisDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Diagnosis.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis.Diagnosis) {
    surrogateSerializer.serialize(encoder, ClaimDiagnosisDiagnosisSurrogate.fromModel(value))
  }
}

public object ClaimProcedureProcedureSerializer : KSerializer<Claim.Procedure.Procedure> {
  internal val surrogateSerializer: KSerializer<ClaimProcedureProcedureSurrogate> by lazy {
    ClaimProcedureProcedureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Procedure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Procedure.Procedure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure.Procedure) {
    surrogateSerializer.serialize(encoder, ClaimProcedureProcedureSurrogate.fromModel(value))
  }
}

public object ClaimAccidentLocationSerializer : KSerializer<Claim.Accident.Location> {
  internal val surrogateSerializer: KSerializer<ClaimAccidentLocationSurrogate> by lazy {
    ClaimAccidentLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Accident.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Accident.Location) {
    surrogateSerializer.serialize(encoder, ClaimAccidentLocationSurrogate.fromModel(value))
  }
}

public object ClaimItemServicedSerializer : KSerializer<Claim.Item.Serviced> {
  internal val surrogateSerializer: KSerializer<ClaimItemServicedSurrogate> by lazy {
    ClaimItemServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Serviced) {
    surrogateSerializer.serialize(encoder, ClaimItemServicedSurrogate.fromModel(value))
  }
}

public object ClaimItemLocationSerializer : KSerializer<Claim.Item.Location> {
  internal val surrogateSerializer: KSerializer<ClaimItemLocationSurrogate> by lazy {
    ClaimItemLocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Location) {
    surrogateSerializer.serialize(encoder, ClaimItemLocationSurrogate.fromModel(value))
  }
}

public object ClaimSerializer : KSerializer<Claim> {
  internal val surrogateSerializer: KSerializer<ClaimSurrogate> by lazy {
    ClaimSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Claim", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Claim) {
    surrogateSerializer.serialize(encoder, ClaimSurrogate.fromModel(value))
  }
}
