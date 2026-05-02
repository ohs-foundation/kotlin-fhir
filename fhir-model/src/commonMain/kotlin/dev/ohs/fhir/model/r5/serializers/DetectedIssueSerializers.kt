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

import com.google.fhir.model.r4b.DetectedIssue
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.DetectedIssueEvidenceSurrogate
import com.google.fhir.model.r4b.surrogates.DetectedIssueIdentifiedSurrogate
import com.google.fhir.model.r4b.surrogates.DetectedIssueMitigationSurrogate
import com.google.fhir.model.r4b.surrogates.DetectedIssueSurrogate
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

public object DetectedIssueEvidenceSerializer : KSerializer<DetectedIssue.Evidence> {
  internal val surrogateSerializer: KSerializer<DetectedIssueEvidenceSurrogate> by lazy {
    DetectedIssueEvidenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Evidence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DetectedIssue.Evidence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Evidence) {
    surrogateSerializer.serialize(encoder, DetectedIssueEvidenceSurrogate.fromModel(value))
  }
}

public object DetectedIssueMitigationSerializer : KSerializer<DetectedIssue.Mitigation> {
  internal val surrogateSerializer: KSerializer<DetectedIssueMitigationSurrogate> by lazy {
    DetectedIssueMitigationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Mitigation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DetectedIssue.Mitigation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Mitigation) {
    surrogateSerializer.serialize(encoder, DetectedIssueMitigationSurrogate.fromModel(value))
  }
}

public object DetectedIssueIdentifiedSerializer : KSerializer<DetectedIssue.Identified> {
  internal val surrogateSerializer: KSerializer<DetectedIssueIdentifiedSurrogate> by lazy {
    DetectedIssueIdentifiedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Identified", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DetectedIssue.Identified =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DetectedIssue.Identified) {
    surrogateSerializer.serialize(encoder, DetectedIssueIdentifiedSurrogate.fromModel(value))
  }
}

public object DetectedIssueSerializer : KSerializer<DetectedIssue> {
  internal val surrogateSerializer: KSerializer<DetectedIssueSurrogate> by lazy {
    DetectedIssueSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("identified")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DetectedIssue", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DetectedIssue {
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

  override fun serialize(encoder: Encoder, `value`: DetectedIssue) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DetectedIssueSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
