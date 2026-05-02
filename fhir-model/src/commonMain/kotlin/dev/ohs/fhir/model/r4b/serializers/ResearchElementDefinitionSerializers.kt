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

import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.ResearchElementDefinition
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionCharacteristicDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionCharacteristicSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionSubjectSurrogate
import com.google.fhir.model.r4b.surrogates.ResearchElementDefinitionSurrogate
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

public object ResearchElementDefinitionCharacteristicSerializer :
  KSerializer<ResearchElementDefinition.Characteristic> {
  internal val surrogateSerializer:
    KSerializer<ResearchElementDefinitionCharacteristicSurrogate> by lazy {
    ResearchElementDefinitionCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> =
    listOf("definition", "studyEffective", "participantEffective")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic {
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

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Characteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ResearchElementDefinitionCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ResearchElementDefinitionSubjectSerializer :
  KSerializer<ResearchElementDefinition.Subject> {
  internal val surrogateSerializer: KSerializer<ResearchElementDefinitionSubjectSurrogate> by lazy {
    ResearchElementDefinitionSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Subject) {
    surrogateSerializer.serialize(
      encoder,
      ResearchElementDefinitionSubjectSurrogate.fromModel(value),
    )
  }
}

public object ResearchElementDefinitionCharacteristicDefinitionSerializer :
  KSerializer<ResearchElementDefinition.Characteristic.Definition> {
  internal val surrogateSerializer:
    KSerializer<ResearchElementDefinitionCharacteristicDefinitionSurrogate> by lazy {
    ResearchElementDefinitionCharacteristicDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Definition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic.Definition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ResearchElementDefinition.Characteristic.Definition,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ResearchElementDefinitionCharacteristicDefinitionSurrogate.fromModel(value),
    )
  }
}

public object ResearchElementDefinitionCharacteristicStudyEffectiveSerializer :
  KSerializer<ResearchElementDefinition.Characteristic.StudyEffective> {
  internal val surrogateSerializer:
    KSerializer<ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate> by lazy {
    ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StudyEffective", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ResearchElementDefinition.Characteristic.StudyEffective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ResearchElementDefinition.Characteristic.StudyEffective,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ResearchElementDefinitionCharacteristicStudyEffectiveSurrogate.fromModel(value),
    )
  }
}

public object ResearchElementDefinitionCharacteristicParticipantEffectiveSerializer :
  KSerializer<ResearchElementDefinition.Characteristic.ParticipantEffective> {
  internal val surrogateSerializer:
    KSerializer<ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate> by lazy {
    ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ParticipantEffective", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): ResearchElementDefinition.Characteristic.ParticipantEffective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ResearchElementDefinition.Characteristic.ParticipantEffective,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ResearchElementDefinitionCharacteristicParticipantEffectiveSurrogate.fromModel(value),
    )
  }
}

public object ResearchElementDefinitionSerializer : KSerializer<ResearchElementDefinition> {
  internal val surrogateSerializer: KSerializer<ResearchElementDefinitionSurrogate> by lazy {
    ResearchElementDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ResearchElementDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition {
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

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ResearchElementDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
