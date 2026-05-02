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
import com.google.fhir.model.r5.MedicinalProductDefinition
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionCharacteristicSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionCharacteristicValueSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionContactSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionCrossReferenceSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionNamePartSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionNameSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionNameUsageSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionOperationSurrogate
import com.google.fhir.model.r5.surrogates.MedicinalProductDefinitionSurrogate
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

public object MedicinalProductDefinitionContactSerializer :
  KSerializer<MedicinalProductDefinition.Contact> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionContactSurrogate> by lazy {
    MedicinalProductDefinitionContactSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Contact", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Contact =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Contact) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionContactSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionNameSerializer :
  KSerializer<MedicinalProductDefinition.Name> {
  internal val surrogateSerializer: KSerializer<MedicinalProductDefinitionNameSurrogate> by lazy {
    MedicinalProductDefinitionNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Name", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name) {
    surrogateSerializer.serialize(encoder, MedicinalProductDefinitionNameSurrogate.fromModel(value))
  }
}

public object MedicinalProductDefinitionNamePartSerializer :
  KSerializer<MedicinalProductDefinition.Name.Part> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionNamePartSurrogate> by lazy {
    MedicinalProductDefinitionNamePartSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Part", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.Part =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.Part) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionNamePartSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionNameUsageSerializer :
  KSerializer<MedicinalProductDefinition.Name.Usage> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionNameUsageSurrogate> by lazy {
    MedicinalProductDefinitionNameUsageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Usage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.Usage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.Usage) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionNameUsageSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionCrossReferenceSerializer :
  KSerializer<MedicinalProductDefinition.CrossReference> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionCrossReferenceSurrogate> by lazy {
    MedicinalProductDefinitionCrossReferenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CrossReference", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.CrossReference =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.CrossReference) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionCrossReferenceSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionOperationSerializer :
  KSerializer<MedicinalProductDefinition.Operation> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionOperationSurrogate> by lazy {
    MedicinalProductDefinitionOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Operation) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionOperationSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionCharacteristicSerializer :
  KSerializer<MedicinalProductDefinition.Characteristic> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionCharacteristicSurrogate> by lazy {
    MedicinalProductDefinitionCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic {
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

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Characteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicinalProductDefinitionCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MedicinalProductDefinitionCharacteristicValueSerializer :
  KSerializer<MedicinalProductDefinition.Characteristic.Value> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionCharacteristicValueSurrogate> by lazy {
    MedicinalProductDefinitionCharacteristicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Characteristic.Value,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionCharacteristicValueSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionSerializer : KSerializer<MedicinalProductDefinition> {
  internal val surrogateSerializer: KSerializer<MedicinalProductDefinitionSurrogate> by lazy {
    MedicinalProductDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition) {
    surrogateSerializer.serialize(encoder, MedicinalProductDefinitionSurrogate.fromModel(value))
  }
}
