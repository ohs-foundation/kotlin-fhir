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

import com.google.fhir.model.r5.CoverageEligibilityResponse
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseErrorSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseEventSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseEventWhenSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseInsuranceItemBenefitSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseInsuranceItemSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseInsuranceSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseServicedSurrogate
import com.google.fhir.model.r5.surrogates.CoverageEligibilityResponseSurrogate
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

public object CoverageEligibilityResponseEventSerializer :
  KSerializer<CoverageEligibilityResponse.Event> {
  internal val surrogateSerializer: KSerializer<CoverageEligibilityResponseEventSurrogate> by lazy {
    CoverageEligibilityResponseEventSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("when")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Event {
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Event) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageEligibilityResponseEventSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CoverageEligibilityResponseInsuranceSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseInsuranceSurrogate> by lazy {
    CoverageEligibilityResponseInsuranceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Insurance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseInsuranceSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseInsuranceItemSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseInsuranceItemSurrogate> by lazy {
    CoverageEligibilityResponseInsuranceItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance.Item) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseInsuranceItemSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseInsuranceItemBenefitSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseInsuranceItemBenefitSurrogate> by lazy {
    CoverageEligibilityResponseInsuranceItemBenefitSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("allowed", "used")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Benefit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item.Benefit {
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

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageEligibilityResponseInsuranceItemBenefitSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CoverageEligibilityResponseErrorSerializer :
  KSerializer<CoverageEligibilityResponse.Error> {
  internal val surrogateSerializer: KSerializer<CoverageEligibilityResponseErrorSurrogate> by lazy {
    CoverageEligibilityResponseErrorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Error", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Error =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Error) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseErrorSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseEventWhenSerializer :
  KSerializer<CoverageEligibilityResponse.Event.When> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseEventWhenSurrogate> by lazy {
    CoverageEligibilityResponseEventWhenSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("When", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Event.When =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Event.When) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseEventWhenSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseServicedSerializer :
  KSerializer<CoverageEligibilityResponse.Serviced> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseServicedSurrogate> by lazy {
    CoverageEligibilityResponseServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Serviced) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseServicedSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseInsuranceItemBenefitAllowedSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate> by lazy {
    CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Allowed", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseInsuranceItemBenefitUsedSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit.Used> {
  internal val surrogateSerializer:
    KSerializer<CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate> by lazy {
    CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Used", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): CoverageEligibilityResponse.Insurance.Item.Benefit.Used =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit.Used,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate.fromModel(value),
    )
  }
}

public object CoverageEligibilityResponseSerializer : KSerializer<CoverageEligibilityResponse> {
  internal val surrogateSerializer: KSerializer<CoverageEligibilityResponseSurrogate> by lazy {
    CoverageEligibilityResponseSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CoverageEligibilityResponse", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse {
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageEligibilityResponseSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
