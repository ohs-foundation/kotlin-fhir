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
import com.google.fhir.model.r5.MessageHeader
import com.google.fhir.model.r5.surrogates.MessageHeaderDestinationEndpointSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderDestinationSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderEventSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderResponseSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderSourceEndpointSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderSourceSurrogate
import com.google.fhir.model.r5.surrogates.MessageHeaderSurrogate
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

public object MessageHeaderDestinationSerializer : KSerializer<MessageHeader.Destination> {
  internal val surrogateSerializer: KSerializer<MessageHeaderDestinationSurrogate> by lazy {
    MessageHeaderDestinationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("endpoint")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Destination", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Destination {
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

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MessageHeaderDestinationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MessageHeaderSourceSerializer : KSerializer<MessageHeader.Source> {
  internal val surrogateSerializer: KSerializer<MessageHeaderSourceSurrogate> by lazy {
    MessageHeaderSourceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("endpoint")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Source", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Source {
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

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MessageHeaderSourceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MessageHeaderResponseSerializer : KSerializer<MessageHeader.Response> {
  internal val surrogateSerializer: KSerializer<MessageHeaderResponseSurrogate> by lazy {
    MessageHeaderResponseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Response", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Response =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Response) {
    surrogateSerializer.serialize(encoder, MessageHeaderResponseSurrogate.fromModel(value))
  }
}

public object MessageHeaderEventSerializer : KSerializer<MessageHeader.Event> {
  internal val surrogateSerializer: KSerializer<MessageHeaderEventSurrogate> by lazy {
    MessageHeaderEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Event =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Event) {
    surrogateSerializer.serialize(encoder, MessageHeaderEventSurrogate.fromModel(value))
  }
}

public object MessageHeaderDestinationEndpointSerializer :
  KSerializer<MessageHeader.Destination.Endpoint> {
  internal val surrogateSerializer: KSerializer<MessageHeaderDestinationEndpointSurrogate> by lazy {
    MessageHeaderDestinationEndpointSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Endpoint", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Destination.Endpoint =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Destination.Endpoint) {
    surrogateSerializer.serialize(
      encoder,
      MessageHeaderDestinationEndpointSurrogate.fromModel(value),
    )
  }
}

public object MessageHeaderSourceEndpointSerializer : KSerializer<MessageHeader.Source.Endpoint> {
  internal val surrogateSerializer: KSerializer<MessageHeaderSourceEndpointSurrogate> by lazy {
    MessageHeaderSourceEndpointSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Endpoint", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader.Source.Endpoint =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageHeader.Source.Endpoint) {
    surrogateSerializer.serialize(encoder, MessageHeaderSourceEndpointSurrogate.fromModel(value))
  }
}

public object MessageHeaderSerializer : KSerializer<MessageHeader> {
  internal val surrogateSerializer: KSerializer<MessageHeaderSurrogate> by lazy {
    MessageHeaderSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("event")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MessageHeader", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageHeader {
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

  override fun serialize(encoder: Encoder, `value`: MessageHeader) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MessageHeaderSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
