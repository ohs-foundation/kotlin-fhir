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
import com.google.fhir.model.r4b.SubstanceDefinition
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionCodeSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionMoietyAmountSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionMoietySurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionMolecularWeightSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionNameOfficialSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionNameSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionPropertySurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionPropertyValueSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionRelationshipAmountSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionRelationshipSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionSourceMaterialSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionStructureRepresentationSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionStructureSurrogate
import com.google.fhir.model.r4b.surrogates.SubstanceDefinitionSurrogate
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

public object SubstanceDefinitionMoietySerializer : KSerializer<SubstanceDefinition.Moiety> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionMoietySurrogate> by lazy {
    SubstanceDefinitionMoietySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Moiety", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Moiety {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Moiety) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceDefinitionMoietySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceDefinitionPropertySerializer : KSerializer<SubstanceDefinition.Property> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionPropertySurrogate> by lazy {
    SubstanceDefinitionPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Property {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceDefinitionPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceDefinitionMolecularWeightSerializer :
  KSerializer<SubstanceDefinition.MolecularWeight> {
  internal val surrogateSerializer:
    KSerializer<SubstanceDefinitionMolecularWeightSurrogate> by lazy {
    SubstanceDefinitionMolecularWeightSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MolecularWeight", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.MolecularWeight =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.MolecularWeight) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionMolecularWeightSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionStructureSerializer : KSerializer<SubstanceDefinition.Structure> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionStructureSurrogate> by lazy {
    SubstanceDefinitionStructureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Structure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure) {
    surrogateSerializer.serialize(encoder, SubstanceDefinitionStructureSurrogate.fromModel(value))
  }
}

public object SubstanceDefinitionStructureRepresentationSerializer :
  KSerializer<SubstanceDefinition.Structure.Representation> {
  internal val surrogateSerializer:
    KSerializer<SubstanceDefinitionStructureRepresentationSurrogate> by lazy {
    SubstanceDefinitionStructureRepresentationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Representation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Structure.Representation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Structure.Representation) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionStructureRepresentationSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionCodeSerializer : KSerializer<SubstanceDefinition.Code> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionCodeSurrogate> by lazy {
    SubstanceDefinitionCodeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Code", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Code =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Code) {
    surrogateSerializer.serialize(encoder, SubstanceDefinitionCodeSurrogate.fromModel(value))
  }
}

public object SubstanceDefinitionNameSerializer : KSerializer<SubstanceDefinition.Name> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionNameSurrogate> by lazy {
    SubstanceDefinitionNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Name", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name) {
    surrogateSerializer.serialize(encoder, SubstanceDefinitionNameSurrogate.fromModel(value))
  }
}

public object SubstanceDefinitionNameOfficialSerializer :
  KSerializer<SubstanceDefinition.Name.Official> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionNameOfficialSurrogate> by lazy {
    SubstanceDefinitionNameOfficialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Official", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Name.Official =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Name.Official) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionNameOfficialSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionRelationshipSerializer :
  KSerializer<SubstanceDefinition.Relationship> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionRelationshipSurrogate> by lazy {
    SubstanceDefinitionRelationshipSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("substanceDefinition", "amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Relationship", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceDefinitionRelationshipSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceDefinitionSourceMaterialSerializer :
  KSerializer<SubstanceDefinition.SourceMaterial> {
  internal val surrogateSerializer:
    KSerializer<SubstanceDefinitionSourceMaterialSurrogate> by lazy {
    SubstanceDefinitionSourceMaterialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SourceMaterial", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.SourceMaterial =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.SourceMaterial) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionSourceMaterialSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionMoietyAmountSerializer :
  KSerializer<SubstanceDefinition.Moiety.Amount> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionMoietyAmountSurrogate> by lazy {
    SubstanceDefinitionMoietyAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Moiety.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Moiety.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionMoietyAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionPropertyValueSerializer :
  KSerializer<SubstanceDefinition.Property.Value> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionPropertyValueSurrogate> by lazy {
    SubstanceDefinitionPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Property.Value) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionPropertyValueSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionRelationshipSubstanceDefinitionSerializer :
  KSerializer<SubstanceDefinition.Relationship.SubstanceDefinition> {
  internal val surrogateSerializer:
    KSerializer<SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate> by lazy {
    SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship.SubstanceDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceDefinition.Relationship.SubstanceDefinition,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionRelationshipSubstanceDefinitionSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionRelationshipAmountSerializer :
  KSerializer<SubstanceDefinition.Relationship.Amount> {
  internal val surrogateSerializer:
    KSerializer<SubstanceDefinitionRelationshipAmountSurrogate> by lazy {
    SubstanceDefinitionRelationshipAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition.Relationship.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition.Relationship.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceDefinitionRelationshipAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceDefinitionSerializer : KSerializer<SubstanceDefinition> {
  internal val surrogateSerializer: KSerializer<SubstanceDefinitionSurrogate> by lazy {
    SubstanceDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceDefinition) {
    surrogateSerializer.serialize(encoder, SubstanceDefinitionSurrogate.fromModel(value))
  }
}
