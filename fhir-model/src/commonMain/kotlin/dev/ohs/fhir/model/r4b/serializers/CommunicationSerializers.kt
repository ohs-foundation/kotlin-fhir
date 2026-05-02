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

import com.google.fhir.model.r4b.Communication
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.CommunicationPayloadContentSurrogate
import com.google.fhir.model.r4b.surrogates.CommunicationPayloadSurrogate
import com.google.fhir.model.r4b.surrogates.CommunicationSurrogate
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

public object CommunicationPayloadSerializer : KSerializer<Communication.Payload> {
  internal val surrogateSerializer: KSerializer<CommunicationPayloadSurrogate> by lazy {
    CommunicationPayloadSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("content")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Payload", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Communication.Payload {
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

  override fun serialize(encoder: Encoder, `value`: Communication.Payload) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CommunicationPayloadSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CommunicationPayloadContentSerializer : KSerializer<Communication.Payload.Content> {
  internal val surrogateSerializer: KSerializer<CommunicationPayloadContentSurrogate> by lazy {
    CommunicationPayloadContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Communication.Payload.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Communication.Payload.Content) {
    surrogateSerializer.serialize(encoder, CommunicationPayloadContentSurrogate.fromModel(value))
  }
}

public object CommunicationSerializer : KSerializer<Communication> {
  internal val surrogateSerializer: KSerializer<CommunicationSurrogate> by lazy {
    CommunicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Communication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Communication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Communication) {
    surrogateSerializer.serialize(encoder, CommunicationSurrogate.fromModel(value))
  }
}
