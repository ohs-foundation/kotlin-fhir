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
import com.google.fhir.model.r5.MessageDefinition
import com.google.fhir.model.r5.surrogates.MessageDefinitionAllowedResponseSurrogate
import com.google.fhir.model.r5.surrogates.MessageDefinitionEventSurrogate
import com.google.fhir.model.r5.surrogates.MessageDefinitionFocusSurrogate
import com.google.fhir.model.r5.surrogates.MessageDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.MessageDefinitionVersionAlgorithmSurrogate
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

public object MessageDefinitionFocusSerializer : KSerializer<MessageDefinition.Focus> {
  internal val surrogateSerializer: KSerializer<MessageDefinitionFocusSurrogate> by lazy {
    MessageDefinitionFocusSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Focus", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition.Focus =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.Focus) {
    surrogateSerializer.serialize(encoder, MessageDefinitionFocusSurrogate.fromModel(value))
  }
}

public object MessageDefinitionAllowedResponseSerializer :
  KSerializer<MessageDefinition.AllowedResponse> {
  internal val surrogateSerializer: KSerializer<MessageDefinitionAllowedResponseSurrogate> by lazy {
    MessageDefinitionAllowedResponseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AllowedResponse", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition.AllowedResponse =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.AllowedResponse) {
    surrogateSerializer.serialize(
      encoder,
      MessageDefinitionAllowedResponseSurrogate.fromModel(value),
    )
  }
}

public object MessageDefinitionVersionAlgorithmSerializer :
  KSerializer<MessageDefinition.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<MessageDefinitionVersionAlgorithmSurrogate> by lazy {
    MessageDefinitionVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      MessageDefinitionVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object MessageDefinitionEventSerializer : KSerializer<MessageDefinition.Event> {
  internal val surrogateSerializer: KSerializer<MessageDefinitionEventSurrogate> by lazy {
    MessageDefinitionEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition.Event =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MessageDefinition.Event) {
    surrogateSerializer.serialize(encoder, MessageDefinitionEventSurrogate.fromModel(value))
  }
}

public object MessageDefinitionSerializer : KSerializer<MessageDefinition> {
  internal val surrogateSerializer: KSerializer<MessageDefinitionSurrogate> by lazy {
    MessageDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm", "event")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MessageDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MessageDefinition {
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

  override fun serialize(encoder: Encoder, `value`: MessageDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MessageDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
