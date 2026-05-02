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

import com.google.fhir.model.r5.CommunicationRequest
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.CommunicationRequestOccurrenceSurrogate
import com.google.fhir.model.r5.surrogates.CommunicationRequestPayloadContentSurrogate
import com.google.fhir.model.r5.surrogates.CommunicationRequestPayloadSurrogate
import com.google.fhir.model.r5.surrogates.CommunicationRequestSurrogate
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

public object CommunicationRequestPayloadSerializer : KSerializer<CommunicationRequest.Payload> {
  internal val surrogateSerializer: KSerializer<CommunicationRequestPayloadSurrogate> by lazy {
    CommunicationRequestPayloadSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("content")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Payload", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest.Payload {
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

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Payload) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CommunicationRequestPayloadSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CommunicationRequestPayloadContentSerializer :
  KSerializer<CommunicationRequest.Payload.Content> {
  internal val surrogateSerializer:
    KSerializer<CommunicationRequestPayloadContentSurrogate> by lazy {
    CommunicationRequestPayloadContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest.Payload.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Payload.Content) {
    surrogateSerializer.serialize(
      encoder,
      CommunicationRequestPayloadContentSurrogate.fromModel(value),
    )
  }
}

public object CommunicationRequestOccurrenceSerializer :
  KSerializer<CommunicationRequest.Occurrence> {
  internal val surrogateSerializer: KSerializer<CommunicationRequestOccurrenceSurrogate> by lazy {
    CommunicationRequestOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest.Occurrence) {
    surrogateSerializer.serialize(encoder, CommunicationRequestOccurrenceSurrogate.fromModel(value))
  }
}

public object CommunicationRequestSerializer : KSerializer<CommunicationRequest> {
  internal val surrogateSerializer: KSerializer<CommunicationRequestSurrogate> by lazy {
    CommunicationRequestSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CommunicationRequest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CommunicationRequest {
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

  override fun serialize(encoder: Encoder, `value`: CommunicationRequest) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CommunicationRequestSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
