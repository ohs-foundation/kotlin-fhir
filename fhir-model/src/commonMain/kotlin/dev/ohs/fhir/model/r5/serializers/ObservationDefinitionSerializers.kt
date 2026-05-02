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
import com.google.fhir.model.r5.ObservationDefinition
import com.google.fhir.model.r5.surrogates.ObservationDefinitionComponentSurrogate
import com.google.fhir.model.r5.surrogates.ObservationDefinitionQualifiedValueSurrogate
import com.google.fhir.model.r5.surrogates.ObservationDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.ObservationDefinitionVersionAlgorithmSurrogate
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

public object ObservationDefinitionQualifiedValueSerializer :
  KSerializer<ObservationDefinition.QualifiedValue> {
  internal val surrogateSerializer:
    KSerializer<ObservationDefinitionQualifiedValueSurrogate> by lazy {
    ObservationDefinitionQualifiedValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("QualifiedValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedValue =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedValue) {
    surrogateSerializer.serialize(
      encoder,
      ObservationDefinitionQualifiedValueSurrogate.fromModel(value),
    )
  }
}

public object ObservationDefinitionComponentSerializer :
  KSerializer<ObservationDefinition.Component> {
  internal val surrogateSerializer: KSerializer<ObservationDefinitionComponentSurrogate> by lazy {
    ObservationDefinitionComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition.Component =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.Component) {
    surrogateSerializer.serialize(encoder, ObservationDefinitionComponentSurrogate.fromModel(value))
  }
}

public object ObservationDefinitionVersionAlgorithmSerializer :
  KSerializer<ObservationDefinition.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<ObservationDefinitionVersionAlgorithmSurrogate> by lazy {
    ObservationDefinitionVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      ObservationDefinitionVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object ObservationDefinitionSerializer : KSerializer<ObservationDefinition> {
  internal val surrogateSerializer: KSerializer<ObservationDefinitionSurrogate> by lazy {
    ObservationDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ObservationDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition {
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

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ObservationDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
