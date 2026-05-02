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
import com.google.fhir.model.r5.OperationDefinition
import com.google.fhir.model.r5.surrogates.OperationDefinitionOverloadSurrogate
import com.google.fhir.model.r5.surrogates.OperationDefinitionParameterBindingSurrogate
import com.google.fhir.model.r5.surrogates.OperationDefinitionParameterReferencedFromSurrogate
import com.google.fhir.model.r5.surrogates.OperationDefinitionParameterSurrogate
import com.google.fhir.model.r5.surrogates.OperationDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.OperationDefinitionVersionAlgorithmSurrogate
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

public object OperationDefinitionParameterSerializer : KSerializer<OperationDefinition.Parameter> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionParameterSurrogate> by lazy {
    OperationDefinitionParameterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
    surrogateSerializer.serialize(encoder, OperationDefinitionParameterSurrogate.fromModel(value))
  }
}

public object OperationDefinitionParameterBindingSerializer :
  KSerializer<OperationDefinition.Parameter.Binding> {
  internal val surrogateSerializer:
    KSerializer<OperationDefinitionParameterBindingSurrogate> by lazy {
    OperationDefinitionParameterBindingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Binding", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
    surrogateSerializer.serialize(
      encoder,
      OperationDefinitionParameterBindingSurrogate.fromModel(value),
    )
  }
}

public object OperationDefinitionParameterReferencedFromSerializer :
  KSerializer<OperationDefinition.Parameter.ReferencedFrom> {
  internal val surrogateSerializer:
    KSerializer<OperationDefinitionParameterReferencedFromSurrogate> by lazy {
    OperationDefinitionParameterReferencedFromSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferencedFrom", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
    surrogateSerializer.serialize(
      encoder,
      OperationDefinitionParameterReferencedFromSurrogate.fromModel(value),
    )
  }
}

public object OperationDefinitionOverloadSerializer : KSerializer<OperationDefinition.Overload> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionOverloadSurrogate> by lazy {
    OperationDefinitionOverloadSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Overload", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
    surrogateSerializer.serialize(encoder, OperationDefinitionOverloadSurrogate.fromModel(value))
  }
}

public object OperationDefinitionVersionAlgorithmSerializer :
  KSerializer<OperationDefinition.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<OperationDefinitionVersionAlgorithmSurrogate> by lazy {
    OperationDefinitionVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      OperationDefinitionVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object OperationDefinitionSerializer : KSerializer<OperationDefinition> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionSurrogate> by lazy {
    OperationDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("OperationDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition {
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

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = OperationDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
