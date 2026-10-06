/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.SubstanceSourceMaterial
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object SubstanceSourceMaterialFractionDescriptionSerializer :
  KSerializer<SubstanceSourceMaterial.FractionDescription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FractionDescription") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("fraction", KotlinString.serializer().descriptor)
      optionalElement("_fraction", ElementSerializer.descriptor)
      optionalElement("materialType", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.FractionDescription>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.FractionDescription =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var fraction: KotlinString? = null
      var _fraction: Element? = null
      var materialType: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> fraction = decodeStringElement(descriptor, i)
          4 -> _fraction = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            materialType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding FractionDescription: " + i)
        }
      }
      SubstanceSourceMaterial.FractionDescription(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        fraction = R4String.of(fraction, _fraction),
        materialType = materialType,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.FractionDescription) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.fraction?.value)
      encodeElementIfNotNull(descriptor, 4, value.fraction)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.materialType)
    }
  }
}

internal object SubstanceSourceMaterialOrganismSerializer :
  KSerializer<SubstanceSourceMaterial.Organism> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Organism") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("family", CodeableConceptSerializer.descriptor)
      optionalElement("genus", CodeableConceptSerializer.descriptor)
      optionalElement("species", CodeableConceptSerializer.descriptor)
      optionalElement("intraspecificType", CodeableConceptSerializer.descriptor)
      optionalElement("intraspecificDescription", KotlinString.serializer().descriptor)
      optionalElement("_intraspecificDescription", ElementSerializer.descriptor)
      optionalElement(
        "author",
        SubstanceSourceMaterialOrganismAuthorSerializer.listSerializer.descriptor,
      )
      optionalElement("hybrid", SubstanceSourceMaterialOrganismHybridSerializer.descriptor)
      optionalElement(
        "organismGeneral",
        SubstanceSourceMaterialOrganismOrganismGeneralSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.Organism>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var family: CodeableConcept? = null
      var genus: CodeableConcept? = null
      var species: CodeableConcept? = null
      var intraspecificType: CodeableConcept? = null
      var intraspecificDescription: KotlinString? = null
      var _intraspecificDescription: Element? = null
      var author: List<SubstanceSourceMaterial.Organism.Author>? = null
      var hybrid: SubstanceSourceMaterial.Organism.Hybrid? = null
      var organismGeneral: SubstanceSourceMaterial.Organism.OrganismGeneral? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            family =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            genus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            species =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            intraspecificType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> intraspecificDescription = decodeStringElement(descriptor, i)
          8 ->
            _intraspecificDescription =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            author =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSourceMaterialOrganismAuthorSerializer.listSerializer,
                null,
              )
          10 ->
            hybrid =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSourceMaterialOrganismHybridSerializer,
                null,
              )
          11 ->
            organismGeneral =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SubstanceSourceMaterialOrganismOrganismGeneralSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Organism: " + i)
        }
      }
      SubstanceSourceMaterial.Organism(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        family = family,
        genus = genus,
        species = species,
        intraspecificType = intraspecificType,
        intraspecificDescription = R4String.of(intraspecificDescription, _intraspecificDescription),
        author = author ?: listOf(),
        hybrid = hybrid,
        organismGeneral = organismGeneral,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.family)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.genus)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.species)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.intraspecificType)
      encodeStringIfNotNull(descriptor, 7, value.intraspecificDescription?.value)
      encodeElementIfNotNull(descriptor, 8, value.intraspecificDescription)
      if (value.author.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          SubstanceSourceMaterialOrganismAuthorSerializer.listSerializer,
          value.author,
        )
      encodeSerializableIfNotNull(
        descriptor,
        10,
        SubstanceSourceMaterialOrganismHybridSerializer,
        value.hybrid,
      )
      encodeSerializableIfNotNull(
        descriptor,
        11,
        SubstanceSourceMaterialOrganismOrganismGeneralSerializer,
        value.organismGeneral,
      )
    }
  }
}

internal object SubstanceSourceMaterialOrganismAuthorSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Author> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Author") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("authorType", CodeableConceptSerializer.descriptor)
      optionalElement("authorDescription", KotlinString.serializer().descriptor)
      optionalElement("_authorDescription", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.Organism.Author>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Author =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var authorType: CodeableConcept? = null
      var authorDescription: KotlinString? = null
      var _authorDescription: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            authorType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> authorDescription = decodeStringElement(descriptor, i)
          5 ->
            _authorDescription =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Author: " + i)
        }
      }
      SubstanceSourceMaterial.Organism.Author(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        authorType = authorType,
        authorDescription = R4String.of(authorDescription, _authorDescription),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Author) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.authorType)
      encodeStringIfNotNull(descriptor, 4, value.authorDescription?.value)
      encodeElementIfNotNull(descriptor, 5, value.authorDescription)
    }
  }
}

internal object SubstanceSourceMaterialOrganismHybridSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Hybrid> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Hybrid") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("maternalOrganismId", KotlinString.serializer().descriptor)
      optionalElement("_maternalOrganismId", ElementSerializer.descriptor)
      optionalElement("maternalOrganismName", KotlinString.serializer().descriptor)
      optionalElement("_maternalOrganismName", ElementSerializer.descriptor)
      optionalElement("paternalOrganismId", KotlinString.serializer().descriptor)
      optionalElement("_paternalOrganismId", ElementSerializer.descriptor)
      optionalElement("paternalOrganismName", KotlinString.serializer().descriptor)
      optionalElement("_paternalOrganismName", ElementSerializer.descriptor)
      optionalElement("hybridType", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.Organism.Hybrid>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Hybrid =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var maternalOrganismId: KotlinString? = null
      var _maternalOrganismId: Element? = null
      var maternalOrganismName: KotlinString? = null
      var _maternalOrganismName: Element? = null
      var paternalOrganismId: KotlinString? = null
      var _paternalOrganismId: Element? = null
      var paternalOrganismName: KotlinString? = null
      var _paternalOrganismName: Element? = null
      var hybridType: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> maternalOrganismId = decodeStringElement(descriptor, i)
          4 ->
            _maternalOrganismId =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> maternalOrganismName = decodeStringElement(descriptor, i)
          6 ->
            _maternalOrganismName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> paternalOrganismId = decodeStringElement(descriptor, i)
          8 ->
            _paternalOrganismId =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> paternalOrganismName = decodeStringElement(descriptor, i)
          10 ->
            _paternalOrganismName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            hybridType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Hybrid: " + i)
        }
      }
      SubstanceSourceMaterial.Organism.Hybrid(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        maternalOrganismId = R4String.of(maternalOrganismId, _maternalOrganismId),
        maternalOrganismName = R4String.of(maternalOrganismName, _maternalOrganismName),
        paternalOrganismId = R4String.of(paternalOrganismId, _paternalOrganismId),
        paternalOrganismName = R4String.of(paternalOrganismName, _paternalOrganismName),
        hybridType = hybridType,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Hybrid) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.maternalOrganismId?.value)
      encodeElementIfNotNull(descriptor, 4, value.maternalOrganismId)
      encodeStringIfNotNull(descriptor, 5, value.maternalOrganismName?.value)
      encodeElementIfNotNull(descriptor, 6, value.maternalOrganismName)
      encodeStringIfNotNull(descriptor, 7, value.paternalOrganismId?.value)
      encodeElementIfNotNull(descriptor, 8, value.paternalOrganismId)
      encodeStringIfNotNull(descriptor, 9, value.paternalOrganismName?.value)
      encodeElementIfNotNull(descriptor, 10, value.paternalOrganismName)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.hybridType)
    }
  }
}

internal object SubstanceSourceMaterialOrganismOrganismGeneralSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.OrganismGeneral> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OrganismGeneral") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("kingdom", CodeableConceptSerializer.descriptor)
      optionalElement("phylum", CodeableConceptSerializer.descriptor)
      optionalElement("class", CodeableConceptSerializer.descriptor)
      optionalElement("order", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.Organism.OrganismGeneral>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.OrganismGeneral =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var kingdom: CodeableConcept? = null
      var phylum: CodeableConcept? = null
      var `class`: CodeableConcept? = null
      var order: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            kingdom =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            phylum =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            `class` =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            order =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding OrganismGeneral: " + i)
        }
      }
      SubstanceSourceMaterial.Organism.OrganismGeneral(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        kingdom = kingdom,
        phylum = phylum,
        `class` = `class`,
        order = order,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSourceMaterial.Organism.OrganismGeneral,
  ) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.kingdom)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.phylum)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.`class`)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.order)
    }
  }
}

internal object SubstanceSourceMaterialPartDescriptionSerializer :
  KSerializer<SubstanceSourceMaterial.PartDescription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PartDescription") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("part", CodeableConceptSerializer.descriptor)
      optionalElement("partLocation", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubstanceSourceMaterial.PartDescription>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.PartDescription =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var part: CodeableConcept? = null
      var partLocation: CodeableConcept? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            part = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            partLocation =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PartDescription: " + i)
        }
      }
      SubstanceSourceMaterial.PartDescription(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        part = part,
        partLocation = partLocation,
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.PartDescription) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.part)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.partLocation)
    }
  }
}

internal object SubstanceSourceMaterialSerializer :
  FhirResourceSerializer<SubstanceSourceMaterial> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubstanceSourceMaterial")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("sourceMaterialClass", CodeableConceptSerializer.descriptor)
    b.optionalElement("sourceMaterialType", CodeableConceptSerializer.descriptor)
    b.optionalElement("sourceMaterialState", CodeableConceptSerializer.descriptor)
    b.optionalElement("organismId", IdentifierSerializer.descriptor)
    b.optionalElement("organismName", KotlinString.serializer().descriptor)
    b.optionalElement("_organismName", ElementSerializer.descriptor)
    b.optionalElement("parentSubstanceId", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("parentSubstanceName", stringNullableListSerializer.descriptor)
    b.optionalElement("_parentSubstanceName", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("countryOfOrigin", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("geographicalLocation", stringNullableListSerializer.descriptor)
    b.optionalElement("_geographicalLocation", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("developmentStage", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "fractionDescription",
      SubstanceSourceMaterialFractionDescriptionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("organism", SubstanceSourceMaterialOrganismSerializer.descriptor)
    b.optionalElement(
      "partDescription",
      SubstanceSourceMaterialPartDescriptionSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubstanceSourceMaterial {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sourceMaterialClass: CodeableConcept? = null
    var sourceMaterialType: CodeableConcept? = null
    var sourceMaterialState: CodeableConcept? = null
    var organismId: Identifier? = null
    var organismName: KotlinString? = null
    var _organismName: Element? = null
    var parentSubstanceId: List<Identifier>? = null
    var parentSubstanceName: List<KotlinString?>? = null
    var _parentSubstanceName: List<Element?>? = null
    var countryOfOrigin: List<CodeableConcept>? = null
    var geographicalLocation: List<KotlinString?>? = null
    var _geographicalLocation: List<Element?>? = null
    var developmentStage: CodeableConcept? = null
    var fractionDescription: List<SubstanceSourceMaterial.FractionDescription>? = null
    var organism: SubstanceSourceMaterial.Organism? = null
    var partDescription: List<SubstanceSourceMaterial.PartDescription>? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          sourceMaterialClass =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          sourceMaterialType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          sourceMaterialState =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          organismId =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        14 -> organismName = decoder.decodeStringElement(descriptor, i)
        15 ->
          _organismName =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          parentSubstanceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        17 ->
          parentSubstanceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        18 ->
          _parentSubstanceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        19 ->
          countryOfOrigin =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          geographicalLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        21 ->
          _geographicalLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        22 ->
          developmentStage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        23 ->
          fractionDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSourceMaterialFractionDescriptionSerializer.listSerializer,
              null,
            )
        24 ->
          organism =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSourceMaterialOrganismSerializer,
              null,
            )
        25 ->
          partDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubstanceSourceMaterialPartDescriptionSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding SubstanceSourceMaterial: " + i)
      }
    }
    return SubstanceSourceMaterial(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sourceMaterialClass = sourceMaterialClass,
      sourceMaterialType = sourceMaterialType,
      sourceMaterialState = sourceMaterialState,
      organismId = organismId,
      organismName = R4String.of(organismName, _organismName),
      parentSubstanceId = parentSubstanceId ?: listOf(),
      parentSubstanceName =
        (kotlin.collections.List(
          maxOf(parentSubstanceName?.size ?: 0, _parentSubstanceName?.size ?: 0)
        ) { index ->
          R4String.of(parentSubstanceName?.getOrNull(index), _parentSubstanceName?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'parentSubstanceName' on SubstanceSourceMaterial has neither a value nor an id/extension"
            )
        }),
      countryOfOrigin = countryOfOrigin ?: listOf(),
      geographicalLocation =
        (kotlin.collections.List(
          maxOf(geographicalLocation?.size ?: 0, _geographicalLocation?.size ?: 0)
        ) { index ->
          R4String.of(
            geographicalLocation?.getOrNull(index),
            _geographicalLocation?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'geographicalLocation' on SubstanceSourceMaterial has neither a value nor an id/extension"
            )
        }),
      developmentStage = developmentStage,
      fractionDescription = fractionDescription ?: listOf(),
      organism = organism,
      partDescription = partDescription ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceSourceMaterial,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.sourceMaterialClass,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.sourceMaterialType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.sourceMaterialState,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      IdentifierSerializer,
      value.organismId,
    )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.organismName?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.organismName)
    if (value.parentSubstanceId.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.parentSubstanceId,
      )
    if (value.parentSubstanceName.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        17 + descriptorOffset,
        stringNullableListSerializer,
        value.parentSubstanceName.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        18 + descriptorOffset,
        value.parentSubstanceName,
      )
    }
    if (value.countryOfOrigin.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.countryOfOrigin,
      )
    if (value.geographicalLocation.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        20 + descriptorOffset,
        stringNullableListSerializer,
        value.geographicalLocation.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        21 + descriptorOffset,
        value.geographicalLocation,
      )
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      CodeableConceptSerializer,
      value.developmentStage,
    )
    if (value.fractionDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        SubstanceSourceMaterialFractionDescriptionSerializer.listSerializer,
        value.fractionDescription,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      SubstanceSourceMaterialOrganismSerializer,
      value.organism,
    )
    if (value.partDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        SubstanceSourceMaterialPartDescriptionSerializer.listSerializer,
        value.partDescription,
      )
  }
}
