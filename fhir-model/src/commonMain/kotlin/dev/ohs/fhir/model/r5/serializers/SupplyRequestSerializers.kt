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
import com.google.fhir.model.r5.SupplyRequest
import com.google.fhir.model.r5.surrogates.SupplyRequestOccurrenceSurrogate
import com.google.fhir.model.r5.surrogates.SupplyRequestParameterSurrogate
import com.google.fhir.model.r5.surrogates.SupplyRequestParameterValueSurrogate
import com.google.fhir.model.r5.surrogates.SupplyRequestSurrogate
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

public object SupplyRequestParameterSerializer : KSerializer<SupplyRequest.Parameter> {
  internal val surrogateSerializer: KSerializer<SupplyRequestParameterSurrogate> by lazy {
    SupplyRequestParameterSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyRequest.Parameter {
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

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Parameter) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SupplyRequestParameterSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SupplyRequestParameterValueSerializer : KSerializer<SupplyRequest.Parameter.Value> {
  internal val surrogateSerializer: KSerializer<SupplyRequestParameterValueSurrogate> by lazy {
    SupplyRequestParameterValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyRequest.Parameter.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Parameter.Value) {
    surrogateSerializer.serialize(encoder, SupplyRequestParameterValueSurrogate.fromModel(value))
  }
}

public object SupplyRequestOccurrenceSerializer : KSerializer<SupplyRequest.Occurrence> {
  internal val surrogateSerializer: KSerializer<SupplyRequestOccurrenceSurrogate> by lazy {
    SupplyRequestOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyRequest.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SupplyRequest.Occurrence) {
    surrogateSerializer.serialize(encoder, SupplyRequestOccurrenceSurrogate.fromModel(value))
  }
}

public object SupplyRequestSerializer : KSerializer<SupplyRequest> {
  internal val surrogateSerializer: KSerializer<SupplyRequestSurrogate> by lazy {
    SupplyRequestSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupplyRequest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SupplyRequest {
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

  override fun serialize(encoder: Encoder, `value`: SupplyRequest) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SupplyRequestSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
