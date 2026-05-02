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

package com.google.fhir.model.r4.serializers

import com.google.fhir.model.r4.EvidenceVariable
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.EvidenceVariableCharacteristicDefinitionSurrogate
import com.google.fhir.model.r4.surrogates.EvidenceVariableCharacteristicParticipantEffectiveSurrogate
import com.google.fhir.model.r4.surrogates.EvidenceVariableCharacteristicSurrogate
import com.google.fhir.model.r4.surrogates.EvidenceVariableSurrogate
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

public object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableCharacteristicSurrogate> by lazy {
    EvidenceVariableCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("definition", "participantEffective")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic {
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

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceVariableCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object EvidenceVariableCharacteristicDefinitionSerializer :
  KSerializer<EvidenceVariable.Characteristic.Definition> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicDefinitionSurrogate> by lazy {
    EvidenceVariableCharacteristicDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Definition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.Definition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.Definition) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicDefinitionSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicParticipantEffectiveSerializer :
  KSerializer<EvidenceVariable.Characteristic.ParticipantEffective> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicParticipantEffectiveSurrogate> by lazy {
    EvidenceVariableCharacteristicParticipantEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ParticipantEffective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.ParticipantEffective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.ParticipantEffective,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicParticipantEffectiveSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableSerializer : KSerializer<EvidenceVariable> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableSurrogate> by lazy {
    EvidenceVariableSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EvidenceVariable", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    surrogateSerializer.serialize(encoder, EvidenceVariableSurrogate.fromModel(value))
  }
}
