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
import com.google.fhir.model.r4b.MedicinalProductDefinition
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionCharacteristicSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionCharacteristicValueSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionContactSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionCrossReferenceSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionNameCountryLanguageSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionNameNamePartSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionNameSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionOperationSurrogate
import com.google.fhir.model.r4b.surrogates.MedicinalProductDefinitionSurrogate
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

public object MedicinalProductDefinitionNameNamePartSerializer :
  KSerializer<MedicinalProductDefinition.Name.NamePart> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionNameNamePartSurrogate> by lazy {
    MedicinalProductDefinitionNameNamePartSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NamePart", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.NamePart =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.NamePart) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionNameNamePartSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductDefinitionNameCountryLanguageSerializer :
  KSerializer<MedicinalProductDefinition.Name.CountryLanguage> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductDefinitionNameCountryLanguageSurrogate> by lazy {
    MedicinalProductDefinitionNameCountryLanguageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CountryLanguage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.CountryLanguage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductDefinitionNameCountryLanguageSurrogate.fromModel(value),
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
