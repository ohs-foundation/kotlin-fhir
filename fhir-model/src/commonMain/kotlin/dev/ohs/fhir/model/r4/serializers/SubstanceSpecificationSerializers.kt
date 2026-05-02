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

import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.SubstanceSpecification
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationCodeSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationMoietyAmountSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationMoietySurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationNameOfficialSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationNameSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationPropertyAmountSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationPropertyDefiningSubstanceSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationPropertySurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationRelationshipAmountSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationRelationshipSubstanceSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationRelationshipSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationStructureIsotopeSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationStructureRepresentationSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationStructureSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceSpecificationSurrogate
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

public object SubstanceSpecificationMoietySerializer : KSerializer<SubstanceSpecification.Moiety> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationMoietySurrogate> by lazy {
    SubstanceSpecificationMoietySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Moiety", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Moiety {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Moiety) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceSpecificationMoietySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceSpecificationPropertySerializer :
  KSerializer<SubstanceSpecification.Property> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationPropertySurrogate> by lazy {
    SubstanceSpecificationPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("definingSubstance", "amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceSpecificationPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceSpecificationStructureSerializer :
  KSerializer<SubstanceSpecification.Structure> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationStructureSurrogate> by lazy {
    SubstanceSpecificationStructureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Structure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationStructureSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationStructureIsotopeSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationStructureIsotopeSurrogate> by lazy {
    SubstanceSpecificationStructureIsotopeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Isotope", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Isotope =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Structure.Isotope) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationStructureIsotopeSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationStructureIsotopeMolecularWeightSerializer :
  KSerializer<SubstanceSpecification.Structure.Isotope.MolecularWeight> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate> by lazy {
    SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MolecularWeight", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstanceSpecification.Structure.Isotope.MolecularWeight =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Isotope.MolecularWeight,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationStructureIsotopeMolecularWeightSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationStructureRepresentationSerializer :
  KSerializer<SubstanceSpecification.Structure.Representation> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationStructureRepresentationSurrogate> by lazy {
    SubstanceSpecificationStructureRepresentationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Representation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Structure.Representation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Structure.Representation,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationStructureRepresentationSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationCodeSerializer : KSerializer<SubstanceSpecification.Code> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationCodeSurrogate> by lazy {
    SubstanceSpecificationCodeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Code", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Code =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Code) {
    surrogateSerializer.serialize(encoder, SubstanceSpecificationCodeSurrogate.fromModel(value))
  }
}

public object SubstanceSpecificationNameSerializer : KSerializer<SubstanceSpecification.Name> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationNameSurrogate> by lazy {
    SubstanceSpecificationNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Name", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name) {
    surrogateSerializer.serialize(encoder, SubstanceSpecificationNameSurrogate.fromModel(value))
  }
}

public object SubstanceSpecificationNameOfficialSerializer :
  KSerializer<SubstanceSpecification.Name.Official> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationNameOfficialSurrogate> by lazy {
    SubstanceSpecificationNameOfficialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Official", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Name.Official =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Name.Official) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationNameOfficialSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationRelationshipSerializer :
  KSerializer<SubstanceSpecification.Relationship> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationRelationshipSurrogate> by lazy {
    SubstanceSpecificationRelationshipSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("substance", "amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Relationship", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceSpecificationRelationshipSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceSpecificationMoietyAmountSerializer :
  KSerializer<SubstanceSpecification.Moiety.Amount> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationMoietyAmountSurrogate> by lazy {
    SubstanceSpecificationMoietyAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Moiety.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Moiety.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationMoietyAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationPropertyDefiningSubstanceSerializer :
  KSerializer<SubstanceSpecification.Property.DefiningSubstance> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationPropertyDefiningSubstanceSurrogate> by lazy {
    SubstanceSpecificationPropertyDefiningSubstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DefiningSubstance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property.DefiningSubstance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSpecification.Property.DefiningSubstance,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationPropertyDefiningSubstanceSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationPropertyAmountSerializer :
  KSerializer<SubstanceSpecification.Property.Amount> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationPropertyAmountSurrogate> by lazy {
    SubstanceSpecificationPropertyAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Property.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Property.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationPropertyAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationRelationshipSubstanceSerializer :
  KSerializer<SubstanceSpecification.Relationship.Substance> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationRelationshipSubstanceSurrogate> by lazy {
    SubstanceSpecificationRelationshipSubstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Substance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship.Substance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship.Substance) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationRelationshipSubstanceSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationRelationshipAmountSerializer :
  KSerializer<SubstanceSpecification.Relationship.Amount> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSpecificationRelationshipAmountSurrogate> by lazy {
    SubstanceSpecificationRelationshipAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification.Relationship.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification.Relationship.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSpecificationRelationshipAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSpecificationSerializer : KSerializer<SubstanceSpecification> {
  internal val surrogateSerializer: KSerializer<SubstanceSpecificationSurrogate> by lazy {
    SubstanceSpecificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceSpecification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSpecification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSpecification) {
    surrogateSerializer.serialize(encoder, SubstanceSpecificationSurrogate.fromModel(value))
  }
}
