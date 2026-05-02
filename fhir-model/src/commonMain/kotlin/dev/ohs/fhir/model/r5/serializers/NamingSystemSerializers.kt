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
import com.google.fhir.model.r5.NamingSystem
import com.google.fhir.model.r5.surrogates.NamingSystemSurrogate
import com.google.fhir.model.r5.surrogates.NamingSystemUniqueIdSurrogate
import com.google.fhir.model.r5.surrogates.NamingSystemVersionAlgorithmSurrogate
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

public object NamingSystemUniqueIdSerializer : KSerializer<NamingSystem.UniqueId> {
  internal val surrogateSerializer: KSerializer<NamingSystemUniqueIdSurrogate> by lazy {
    NamingSystemUniqueIdSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("UniqueId", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NamingSystem.UniqueId =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NamingSystem.UniqueId) {
    surrogateSerializer.serialize(encoder, NamingSystemUniqueIdSurrogate.fromModel(value))
  }
}

public object NamingSystemVersionAlgorithmSerializer : KSerializer<NamingSystem.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<NamingSystemVersionAlgorithmSurrogate> by lazy {
    NamingSystemVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NamingSystem.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NamingSystem.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, NamingSystemVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object NamingSystemSerializer : KSerializer<NamingSystem> {
  internal val surrogateSerializer: KSerializer<NamingSystemSurrogate> by lazy {
    NamingSystemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NamingSystem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NamingSystem {
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

  override fun serialize(encoder: Encoder, `value`: NamingSystem) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = NamingSystemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
