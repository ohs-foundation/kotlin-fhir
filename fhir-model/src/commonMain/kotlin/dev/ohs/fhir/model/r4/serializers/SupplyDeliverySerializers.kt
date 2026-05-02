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
import com.google.fhir.model.r5.SupplyDelivery
import com.google.fhir.model.r5.surrogates.SupplyDeliveryOccurrenceSurrogate
import com.google.fhir.model.r5.surrogates.SupplyDeliverySuppliedItemItemSurrogate
import com.google.fhir.model.r5.surrogates.SupplyDeliverySuppliedItemSurrogate
import com.google.fhir.model.r5.surrogates.SupplyDeliverySurrogate
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

public object SupplyDeliverySuppliedItemSerializer : KSerializer<SupplyDelivery.SuppliedItem> {
  internal val surrogateSerializer: KSerializer<SupplyDeliverySuppliedItemSurrogate> by lazy {
    SupplyDeliverySuppliedItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SuppliedItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery.SuppliedItem {
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

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery.SuppliedItem) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SupplyDeliverySuppliedItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SupplyDeliverySuppliedItemItemSerializer :
  KSerializer<SupplyDelivery.SuppliedItem.Item> {
  internal val surrogateSerializer: KSerializer<SupplyDeliverySuppliedItemItemSurrogate> by lazy {
    SupplyDeliverySuppliedItemItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery.SuppliedItem.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery.SuppliedItem.Item) {
    surrogateSerializer.serialize(encoder, SupplyDeliverySuppliedItemItemSurrogate.fromModel(value))
  }
}

public object SupplyDeliveryOccurrenceSerializer : KSerializer<SupplyDelivery.Occurrence> {
  internal val surrogateSerializer: KSerializer<SupplyDeliveryOccurrenceSurrogate> by lazy {
    SupplyDeliveryOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery.Occurrence) {
    surrogateSerializer.serialize(encoder, SupplyDeliveryOccurrenceSurrogate.fromModel(value))
  }
}

public object SupplyDeliverySerializer : KSerializer<SupplyDelivery> {
  internal val surrogateSerializer: KSerializer<SupplyDeliverySurrogate> by lazy {
    SupplyDeliverySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupplyDelivery", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyDelivery {
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

  override fun serialize(encoder: Encoder, `value`: SupplyDelivery) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SupplyDeliverySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
