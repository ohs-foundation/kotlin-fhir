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

import com.google.fhir.model.r5.CapabilityStatement
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.CapabilityStatementDocumentSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementImplementationSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementMessagingEndpointSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementMessagingSupportedMessageSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementMessagingSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestInteractionSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestResourceInteractionSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestResourceOperationSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestResourceSearchParamSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestResourceSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestSecuritySurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementRestSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementSoftwareSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementSurrogate
import com.google.fhir.model.r5.surrogates.CapabilityStatementVersionAlgorithmSurrogate
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

public object CapabilityStatementSoftwareSerializer : KSerializer<CapabilityStatement.Software> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementSoftwareSurrogate> by lazy {
    CapabilityStatementSoftwareSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Software", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Software =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Software) {
    surrogateSerializer.serialize(encoder, CapabilityStatementSoftwareSurrogate.fromModel(value))
  }
}

public object CapabilityStatementImplementationSerializer :
  KSerializer<CapabilityStatement.Implementation> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementImplementationSurrogate> by lazy {
    CapabilityStatementImplementationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Implementation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Implementation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Implementation) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementImplementationSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestSerializer : KSerializer<CapabilityStatement.Rest> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementRestSurrogate> by lazy {
    CapabilityStatementRestSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Rest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest) {
    surrogateSerializer.serialize(encoder, CapabilityStatementRestSurrogate.fromModel(value))
  }
}

public object CapabilityStatementRestSecuritySerializer :
  KSerializer<CapabilityStatement.Rest.Security> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementRestSecuritySurrogate> by lazy {
    CapabilityStatementRestSecuritySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Security", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Security =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Security) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestSecuritySurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestResourceSerializer :
  KSerializer<CapabilityStatement.Rest.Resource> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementRestResourceSurrogate> by lazy {
    CapabilityStatementRestResourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Resource", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestResourceSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestResourceInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Interaction> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementRestResourceInteractionSurrogate> by lazy {
    CapabilityStatementRestResourceInteractionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Interaction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Interaction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Interaction) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestResourceInteractionSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestResourceSearchParamSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.SearchParam> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementRestResourceSearchParamSurrogate> by lazy {
    CapabilityStatementRestResourceSearchParamSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SearchParam", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.SearchParam =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.SearchParam) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestResourceSearchParamSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestResourceOperationSerializer :
  KSerializer<CapabilityStatement.Rest.Resource.Operation> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementRestResourceOperationSurrogate> by lazy {
    CapabilityStatementRestResourceOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Resource.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Resource.Operation) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestResourceOperationSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementRestInteractionSerializer :
  KSerializer<CapabilityStatement.Rest.Interaction> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementRestInteractionSurrogate> by lazy {
    CapabilityStatementRestInteractionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Interaction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Rest.Interaction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Rest.Interaction) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementRestInteractionSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementMessagingSerializer : KSerializer<CapabilityStatement.Messaging> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementMessagingSurrogate> by lazy {
    CapabilityStatementMessagingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Messaging", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging) {
    surrogateSerializer.serialize(encoder, CapabilityStatementMessagingSurrogate.fromModel(value))
  }
}

public object CapabilityStatementMessagingEndpointSerializer :
  KSerializer<CapabilityStatement.Messaging.Endpoint> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementMessagingEndpointSurrogate> by lazy {
    CapabilityStatementMessagingEndpointSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Endpoint", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.Endpoint =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Messaging.Endpoint) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementMessagingEndpointSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementMessagingSupportedMessageSerializer :
  KSerializer<CapabilityStatement.Messaging.SupportedMessage> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementMessagingSupportedMessageSurrogate> by lazy {
    CapabilityStatementMessagingSupportedMessageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupportedMessage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Messaging.SupportedMessage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: CapabilityStatement.Messaging.SupportedMessage,
  ) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementMessagingSupportedMessageSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementDocumentSerializer : KSerializer<CapabilityStatement.Document> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementDocumentSurrogate> by lazy {
    CapabilityStatementDocumentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Document", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.Document =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.Document) {
    surrogateSerializer.serialize(encoder, CapabilityStatementDocumentSurrogate.fromModel(value))
  }
}

public object CapabilityStatementVersionAlgorithmSerializer :
  KSerializer<CapabilityStatement.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<CapabilityStatementVersionAlgorithmSurrogate> by lazy {
    CapabilityStatementVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      CapabilityStatementVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object CapabilityStatementSerializer : KSerializer<CapabilityStatement> {
  internal val surrogateSerializer: KSerializer<CapabilityStatementSurrogate> by lazy {
    CapabilityStatementSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CapabilityStatement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CapabilityStatement {
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

  override fun serialize(encoder: Encoder, `value`: CapabilityStatement) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CapabilityStatementSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
