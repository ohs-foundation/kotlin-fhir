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

import com.google.fhir.model.r5.EvidenceVariable
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.EvidenceVariableCategorySurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCategoryValueSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicDefinitionByCombinationSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicDefinitionByTypeAndValueSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicDurationSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicInstancesSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicTimeFromEventEventSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableCharacteristicTimeFromEventSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableSurrogate
import com.google.fhir.model.r5.surrogates.EvidenceVariableVersionAlgorithmSurrogate
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

  private val multiChoiceProperties: List<String> = listOf("instances", "duration")

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

public object EvidenceVariableCharacteristicDefinitionByTypeAndValueSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByTypeAndValue> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicDefinitionByTypeAndValueSurrogate> by lazy {
    EvidenceVariableCharacteristicDefinitionByTypeAndValueSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DefinitionByTypeAndValue", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue {
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

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceVariableCharacteristicDefinitionByTypeAndValueSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object EvidenceVariableCharacteristicDefinitionByCombinationSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByCombination> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicDefinitionByCombinationSurrogate> by lazy {
    EvidenceVariableCharacteristicDefinitionByCombinationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DefinitionByCombination", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByCombination =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByCombination,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicDefinitionByCombinationSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicTimeFromEventSerializer :
  KSerializer<EvidenceVariable.Characteristic.TimeFromEvent> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicTimeFromEventSurrogate> by lazy {
    EvidenceVariableCharacteristicTimeFromEventSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("event")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TimeFromEvent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.TimeFromEvent {
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

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.TimeFromEvent) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceVariableCharacteristicTimeFromEventSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object EvidenceVariableCategorySerializer : KSerializer<EvidenceVariable.Category> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableCategorySurrogate> by lazy {
    EvidenceVariableCategorySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Category", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Category {
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

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceVariableCategorySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object EvidenceVariableVersionAlgorithmSerializer :
  KSerializer<EvidenceVariable.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableVersionAlgorithmSurrogate> by lazy {
    EvidenceVariableVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSerializer :
  KSerializer<EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSurrogate> by lazy {
    EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.DefinitionByTypeAndValue.Value,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicDefinitionByTypeAndValueValueSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicInstancesSerializer :
  KSerializer<EvidenceVariable.Characteristic.Instances> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicInstancesSurrogate> by lazy {
    EvidenceVariableCharacteristicInstancesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instances", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.Instances =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.Instances) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicInstancesSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicDurationSerializer :
  KSerializer<EvidenceVariable.Characteristic.Duration> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicDurationSurrogate> by lazy {
    EvidenceVariableCharacteristicDurationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Duration", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.Duration =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic.Duration) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicDurationSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCharacteristicTimeFromEventEventSerializer :
  KSerializer<EvidenceVariable.Characteristic.TimeFromEvent.Event> {
  internal val surrogateSerializer:
    KSerializer<EvidenceVariableCharacteristicTimeFromEventEventSurrogate> by lazy {
    EvidenceVariableCharacteristicTimeFromEventEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic.TimeFromEvent.Event =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EvidenceVariable.Characteristic.TimeFromEvent.Event,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceVariableCharacteristicTimeFromEventEventSurrogate.fromModel(value),
    )
  }
}

public object EvidenceVariableCategoryValueSerializer :
  KSerializer<EvidenceVariable.Category.Value> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableCategoryValueSurrogate> by lazy {
    EvidenceVariableCategoryValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable.Category.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Category.Value) {
    surrogateSerializer.serialize(encoder, EvidenceVariableCategoryValueSurrogate.fromModel(value))
  }
}

public object EvidenceVariableSerializer : KSerializer<EvidenceVariable> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableSurrogate> by lazy {
    EvidenceVariableSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EvidenceVariable", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EvidenceVariable {
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

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceVariableSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
