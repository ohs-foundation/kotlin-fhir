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

import com.google.fhir.model.r5.ChargeItemDefinition
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ChargeItemDefinitionApplicabilitySurrogate
import com.google.fhir.model.r5.surrogates.ChargeItemDefinitionPropertyGroupSurrogate
import com.google.fhir.model.r5.surrogates.ChargeItemDefinitionSurrogate
import com.google.fhir.model.r5.surrogates.ChargeItemDefinitionVersionAlgorithmSurrogate
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

public object ChargeItemDefinitionApplicabilitySerializer :
  KSerializer<ChargeItemDefinition.Applicability> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionApplicabilitySurrogate> by lazy {
    ChargeItemDefinitionApplicabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Applicability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.Applicability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.Applicability) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionApplicabilitySurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionPropertyGroupSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionPropertyGroupSurrogate> by lazy {
    ChargeItemDefinitionPropertyGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PropertyGroup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.PropertyGroup) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionPropertyGroupSurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionVersionAlgorithmSerializer :
  KSerializer<ChargeItemDefinition.VersionAlgorithm> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionVersionAlgorithmSurrogate> by lazy {
    ChargeItemDefinitionVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionSerializer : KSerializer<ChargeItemDefinition> {
  internal val surrogateSerializer: KSerializer<ChargeItemDefinitionSurrogate> by lazy {
    ChargeItemDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ChargeItemDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition {
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

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ChargeItemDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
