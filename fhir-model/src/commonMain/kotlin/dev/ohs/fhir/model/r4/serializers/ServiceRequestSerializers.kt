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
import com.google.fhir.model.r4.ServiceRequest
import com.google.fhir.model.r4.surrogates.ServiceRequestAsNeededSurrogate
import com.google.fhir.model.r4.surrogates.ServiceRequestOccurrenceSurrogate
import com.google.fhir.model.r4.surrogates.ServiceRequestQuantitySurrogate
import com.google.fhir.model.r4.surrogates.ServiceRequestSurrogate
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

public object ServiceRequestQuantitySerializer : KSerializer<ServiceRequest.Quantity> {
  internal val surrogateSerializer: KSerializer<ServiceRequestQuantitySurrogate> by lazy {
    ServiceRequestQuantitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Quantity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ServiceRequest.Quantity =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.Quantity) {
    surrogateSerializer.serialize(encoder, ServiceRequestQuantitySurrogate.fromModel(value))
  }
}

public object ServiceRequestOccurrenceSerializer : KSerializer<ServiceRequest.Occurrence> {
  internal val surrogateSerializer: KSerializer<ServiceRequestOccurrenceSurrogate> by lazy {
    ServiceRequestOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ServiceRequest.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.Occurrence) {
    surrogateSerializer.serialize(encoder, ServiceRequestOccurrenceSurrogate.fromModel(value))
  }
}

public object ServiceRequestAsNeededSerializer : KSerializer<ServiceRequest.AsNeeded> {
  internal val surrogateSerializer: KSerializer<ServiceRequestAsNeededSurrogate> by lazy {
    ServiceRequestAsNeededSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AsNeeded", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ServiceRequest.AsNeeded =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ServiceRequest.AsNeeded) {
    surrogateSerializer.serialize(encoder, ServiceRequestAsNeededSurrogate.fromModel(value))
  }
}

public object ServiceRequestSerializer : KSerializer<ServiceRequest> {
  internal val surrogateSerializer: KSerializer<ServiceRequestSurrogate> by lazy {
    ServiceRequestSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("quantity", "occurrence", "asNeeded")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ServiceRequest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ServiceRequest {
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

  override fun serialize(encoder: Encoder, `value`: ServiceRequest) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ServiceRequestSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
