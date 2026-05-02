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

import com.google.fhir.model.r4.CarePlan
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.CarePlanActivityDetailProductSurrogate
import com.google.fhir.model.r4.surrogates.CarePlanActivityDetailScheduledSurrogate
import com.google.fhir.model.r4.surrogates.CarePlanActivityDetailSurrogate
import com.google.fhir.model.r4.surrogates.CarePlanActivitySurrogate
import com.google.fhir.model.r4.surrogates.CarePlanSurrogate
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

public object CarePlanActivitySerializer : KSerializer<CarePlan.Activity> {
  internal val surrogateSerializer: KSerializer<CarePlanActivitySurrogate> by lazy {
    CarePlanActivitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Activity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CarePlan.Activity =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity) {
    surrogateSerializer.serialize(encoder, CarePlanActivitySurrogate.fromModel(value))
  }
}

public object CarePlanActivityDetailSerializer : KSerializer<CarePlan.Activity.Detail> {
  internal val surrogateSerializer: KSerializer<CarePlanActivityDetailSurrogate> by lazy {
    CarePlanActivityDetailSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("scheduled", "product")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CarePlan.Activity.Detail {
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

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity.Detail) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CarePlanActivityDetailSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CarePlanActivityDetailScheduledSerializer :
  KSerializer<CarePlan.Activity.Detail.Scheduled> {
  internal val surrogateSerializer: KSerializer<CarePlanActivityDetailScheduledSurrogate> by lazy {
    CarePlanActivityDetailScheduledSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Scheduled", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CarePlan.Activity.Detail.Scheduled =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity.Detail.Scheduled) {
    surrogateSerializer.serialize(
      encoder,
      CarePlanActivityDetailScheduledSurrogate.fromModel(value),
    )
  }
}

public object CarePlanActivityDetailProductSerializer :
  KSerializer<CarePlan.Activity.Detail.Product> {
  internal val surrogateSerializer: KSerializer<CarePlanActivityDetailProductSurrogate> by lazy {
    CarePlanActivityDetailProductSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Product", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CarePlan.Activity.Detail.Product =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CarePlan.Activity.Detail.Product) {
    surrogateSerializer.serialize(encoder, CarePlanActivityDetailProductSurrogate.fromModel(value))
  }
}

public object CarePlanSerializer : KSerializer<CarePlan> {
  internal val surrogateSerializer: KSerializer<CarePlanSurrogate> by lazy {
    CarePlanSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CarePlan", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CarePlan =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CarePlan) {
    surrogateSerializer.serialize(encoder, CarePlanSurrogate.fromModel(value))
  }
}
