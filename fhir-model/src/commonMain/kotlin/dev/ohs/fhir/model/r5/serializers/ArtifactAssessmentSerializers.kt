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

import com.google.fhir.model.r5.ArtifactAssessment
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ArtifactAssessmentArtifactSurrogate
import com.google.fhir.model.r5.surrogates.ArtifactAssessmentCiteAsSurrogate
import com.google.fhir.model.r5.surrogates.ArtifactAssessmentContentSurrogate
import com.google.fhir.model.r5.surrogates.ArtifactAssessmentSurrogate
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

public object ArtifactAssessmentContentSerializer : KSerializer<ArtifactAssessment.Content> {
  internal val surrogateSerializer: KSerializer<ArtifactAssessmentContentSurrogate> by lazy {
    ArtifactAssessmentContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment.Content) {
    surrogateSerializer.serialize(encoder, ArtifactAssessmentContentSurrogate.fromModel(value))
  }
}

public object ArtifactAssessmentCiteAsSerializer : KSerializer<ArtifactAssessment.CiteAs> {
  internal val surrogateSerializer: KSerializer<ArtifactAssessmentCiteAsSurrogate> by lazy {
    ArtifactAssessmentCiteAsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CiteAs", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment.CiteAs =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment.CiteAs) {
    surrogateSerializer.serialize(encoder, ArtifactAssessmentCiteAsSurrogate.fromModel(value))
  }
}

public object ArtifactAssessmentArtifactSerializer : KSerializer<ArtifactAssessment.Artifact> {
  internal val surrogateSerializer: KSerializer<ArtifactAssessmentArtifactSurrogate> by lazy {
    ArtifactAssessmentArtifactSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Artifact", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment.Artifact =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment.Artifact) {
    surrogateSerializer.serialize(encoder, ArtifactAssessmentArtifactSurrogate.fromModel(value))
  }
}

public object ArtifactAssessmentSerializer : KSerializer<ArtifactAssessment> {
  internal val surrogateSerializer: KSerializer<ArtifactAssessmentSurrogate> by lazy {
    ArtifactAssessmentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("citeAs", "artifact")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ArtifactAssessment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ArtifactAssessment {
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

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ArtifactAssessmentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
