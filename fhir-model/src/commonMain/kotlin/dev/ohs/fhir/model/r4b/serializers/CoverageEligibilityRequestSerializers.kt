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

import com.google.fhir.model.r4b.CoverageEligibilityRequest
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestInsuranceSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestItemDiagnosisSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestItemSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestServicedSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestSupportingInfoSurrogate
import com.google.fhir.model.r4b.surrogates.CoverageEligibilityRequestSurrogate
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

public object CoverageEligibilityRequestSupportingInfoSerializer :
  KSerializer<CoverageEligibilityRequest.SupportingInfo> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityRequestSupportingInfoSurrogate> by lazy {
    CoverageEligibilityRequestSupportingInfoSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupportingInfo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.SupportingInfo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.SupportingInfo) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityRequestSupportingInfoSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityRequestInsuranceSerializer :
  KSerializer<CoverageEligibilityRequest.Insurance> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityRequestInsuranceSurrogate> by lazy {
    CoverageEligibilityRequestInsuranceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Insurance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Insurance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Insurance) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityRequestInsuranceSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityRequestItemSerializer :
  KSerializer<CoverageEligibilityRequest.Item> {
  internal val surrogateSerializer: KSerializer<CoverageEligibilityRequestItemSurrogate> by lazy {
    CoverageEligibilityRequestItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item) {
    surrogateSerializer.serialize(encoder, CoverageEligibilityRequestItemSurrogate.fromModel(value))
  }
}

public object CoverageEligibilityRequestItemDiagnosisSerializer :
  KSerializer<CoverageEligibilityRequest.Item.Diagnosis> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityRequestItemDiagnosisSurrogate> by lazy {
    CoverageEligibilityRequestItemDiagnosisSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("diagnosis")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item.Diagnosis {
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item.Diagnosis) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageEligibilityRequestItemDiagnosisSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CoverageEligibilityRequestServicedSerializer :
  KSerializer<CoverageEligibilityRequest.Serviced> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityRequestServicedSurrogate> by lazy {
    CoverageEligibilityRequestServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Serviced) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityRequestServicedSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityRequestItemDiagnosisDiagnosisSerializer :
  KSerializer<CoverageEligibilityRequest.Item.Diagnosis.Diagnosis> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate> by lazy {
    CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Diagnosis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item.Diagnosis.Diagnosis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityRequest.Item.Diagnosis.Diagnosis,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityRequestSerializer : KSerializer<CoverageEligibilityRequest> {
  internal val surrogateSerializer: KSerializer<CoverageEligibilityRequestSurrogate> by lazy {
    CoverageEligibilityRequestSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CoverageEligibilityRequest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest {
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageEligibilityRequestSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
