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

import com.google.fhir.model.r5.AllergyIntolerance
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.AllergyIntoleranceOnsetSurrogate
import com.google.fhir.model.r5.surrogates.AllergyIntoleranceParticipantSurrogate
import com.google.fhir.model.r5.surrogates.AllergyIntoleranceReactionSurrogate
import com.google.fhir.model.r5.surrogates.AllergyIntoleranceSurrogate
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

public object AllergyIntoleranceParticipantSerializer :
  KSerializer<AllergyIntolerance.Participant> {
  internal val surrogateSerializer: KSerializer<AllergyIntoleranceParticipantSurrogate> by lazy {
    AllergyIntoleranceParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Participant) {
    surrogateSerializer.serialize(encoder, AllergyIntoleranceParticipantSurrogate.fromModel(value))
  }
}

public object AllergyIntoleranceReactionSerializer : KSerializer<AllergyIntolerance.Reaction> {
  internal val surrogateSerializer: KSerializer<AllergyIntoleranceReactionSurrogate> by lazy {
    AllergyIntoleranceReactionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Reaction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Reaction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Reaction) {
    surrogateSerializer.serialize(encoder, AllergyIntoleranceReactionSurrogate.fromModel(value))
  }
}

public object AllergyIntoleranceOnsetSerializer : KSerializer<AllergyIntolerance.Onset> {
  internal val surrogateSerializer: KSerializer<AllergyIntoleranceOnsetSurrogate> by lazy {
    AllergyIntoleranceOnsetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Onset", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Onset =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Onset) {
    surrogateSerializer.serialize(encoder, AllergyIntoleranceOnsetSurrogate.fromModel(value))
  }
}

public object AllergyIntoleranceSerializer : KSerializer<AllergyIntolerance> {
  internal val surrogateSerializer: KSerializer<AllergyIntoleranceSurrogate> by lazy {
    AllergyIntoleranceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("onset")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AllergyIntolerance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AllergyIntolerance {
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

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = AllergyIntoleranceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
