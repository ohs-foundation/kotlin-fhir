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
import com.google.fhir.model.r5.StructureDefinition
import com.google.fhir.model.r5.surrogates.StructureDefinitionContextSurrogate
import com.google.fhir.model.r5.surrogates.StructureDefinitionDifferentialSurrogate
import com.google.fhir.model.r5.surrogates.StructureDefinitionMappingSurrogate
import com.google.fhir.model.r5.surrogates.StructureDefinitionSnapshotSurrogate
import com.google.fhir.model.r5.surrogates.StructureDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.StructureDefinitionVersionAlgorithmSurrogate
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

public object StructureDefinitionMappingSerializer : KSerializer<StructureDefinition.Mapping> {
  internal val surrogateSerializer: KSerializer<StructureDefinitionMappingSurrogate> by lazy {
    StructureDefinitionMappingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Mapping", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition.Mapping =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Mapping) {
    surrogateSerializer.serialize(encoder, StructureDefinitionMappingSurrogate.fromModel(value))
  }
}

public object StructureDefinitionContextSerializer : KSerializer<StructureDefinition.Context> {
  internal val surrogateSerializer: KSerializer<StructureDefinitionContextSurrogate> by lazy {
    StructureDefinitionContextSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Context", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition.Context =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Context) {
    surrogateSerializer.serialize(encoder, StructureDefinitionContextSurrogate.fromModel(value))
  }
}

public object StructureDefinitionSnapshotSerializer : KSerializer<StructureDefinition.Snapshot> {
  internal val surrogateSerializer: KSerializer<StructureDefinitionSnapshotSurrogate> by lazy {
    StructureDefinitionSnapshotSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Snapshot", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition.Snapshot =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Snapshot) {
    surrogateSerializer.serialize(encoder, StructureDefinitionSnapshotSurrogate.fromModel(value))
  }
}

public object StructureDefinitionDifferentialSerializer :
  KSerializer<StructureDefinition.Differential> {
  internal val surrogateSerializer: KSerializer<StructureDefinitionDifferentialSurrogate> by lazy {
    StructureDefinitionDifferentialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Differential", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition.Differential =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.Differential) {
    surrogateSerializer.serialize(
      encoder,
      StructureDefinitionDifferentialSurrogate.fromModel(value),
    )
  }
}

public object StructureDefinitionVersionAlgorithmSerializer :
  KSerializer<StructureDefinition.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<StructureDefinitionVersionAlgorithmSurrogate> by lazy {
    StructureDefinitionVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: StructureDefinition.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      StructureDefinitionVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object StructureDefinitionSerializer : KSerializer<StructureDefinition> {
  internal val surrogateSerializer: KSerializer<StructureDefinitionSurrogate> by lazy {
    StructureDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StructureDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): StructureDefinition {
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

  override fun serialize(encoder: Encoder, `value`: StructureDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = StructureDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
