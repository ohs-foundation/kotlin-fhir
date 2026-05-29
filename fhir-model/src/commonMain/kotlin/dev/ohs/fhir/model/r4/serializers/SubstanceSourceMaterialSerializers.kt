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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
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
import kotlinx.serialization.builtins.nullable
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("fraction", KotlinString.serializer().descriptor, isOptional = true)
      element("_fraction", Element.serializer().descriptor, isOptional = true)
      element("materialType", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.FractionDescription =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.FractionDescription) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSourceMaterial.FractionDescription {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var fraction: KotlinString? = null
    var _fraction: Element? = null
    var materialType: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> fraction = decoder.decodeStringElement(descriptor, i)
        4 ->
          _fraction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fractionSer, null)
        5 ->
          materialType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding FractionDescription: " + i)
      }
    }
    return SubstanceSourceMaterial.FractionDescription(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      fraction = R4String.of(fraction, _fraction),
      materialType = materialType,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.FractionDescription,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.fraction?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.fraction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.fractionSer, it)
    }
    (value.materialType)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.materialTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val fractionSer: KSerializer<Element> = Element.serializer()

    public val materialTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object SubstanceSourceMaterialOrganismSerializer :
  KSerializer<SubstanceSourceMaterial.Organism> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Organism") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("family", CodeableConcept.serializer().descriptor, isOptional = true)
      element("genus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("species", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intraspecificType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intraspecificDescription", KotlinString.serializer().descriptor, isOptional = true)
      element("_intraspecificDescription", Element.serializer().descriptor, isOptional = true)
      element(
        "author",
        listSerialDescriptor(
          lazyDescriptor { SubstanceSourceMaterial.Organism.Author.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "hybrid",
        lazyDescriptor { SubstanceSourceMaterial.Organism.Hybrid.serializer().descriptor },
        isOptional = true,
      )
      element(
        "organismGeneral",
        lazyDescriptor { SubstanceSourceMaterial.Organism.OrganismGeneral.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubstanceSourceMaterial.Organism {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          family = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.familySer, null)
        4 ->
          genus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.familySer, null)
        5 ->
          species =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.familySer, null)
        6 ->
          intraspecificType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.familySer, null)
        7 -> intraspecificDescription = decoder.decodeStringElement(descriptor, i)
        8 ->
          _intraspecificDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.intraspecificDescriptionSer,
              null,
            )
        9 ->
          author = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorSer, null)
        10 ->
          hybrid = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hybridSer, null)
        11 ->
          organismGeneral =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.organismGeneralSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Organism: " + i)
      }
    }
    return SubstanceSourceMaterial.Organism(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.Organism,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.family)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.familySer, it) }
    (value.genus)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.familySer, it) }
    (value.species)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.familySer, it) }
    (value.intraspecificType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.familySer, it)
    }
    ((value.intraspecificDescription?.value))?.let {
      encoder.encodeStringElement(descriptor, 7, it)
    }
    (value.intraspecificDescription?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.intraspecificDescriptionSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.authorSer, value.author)
    (value.hybrid)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.hybridSer, it) }
    (value.organismGeneral)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.organismGeneralSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val familySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val intraspecificDescriptionSer: KSerializer<Element> = Element.serializer()

    public val authorSerInner: KSerializer<SubstanceSourceMaterial.Organism.Author> =
      SubstanceSourceMaterial.Organism.Author.serializer()

    public val authorSer: KSerializer<List<SubstanceSourceMaterial.Organism.Author>> =
      ListSerializer(Hoisted.authorSerInner)

    public val hybridSer: KSerializer<SubstanceSourceMaterial.Organism.Hybrid> =
      SubstanceSourceMaterial.Organism.Hybrid.serializer()

    public val organismGeneralSer: KSerializer<SubstanceSourceMaterial.Organism.OrganismGeneral> =
      SubstanceSourceMaterial.Organism.OrganismGeneral.serializer()
  }
}

internal object SubstanceSourceMaterialOrganismAuthorSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Author> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Author") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("authorType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("authorDescription", KotlinString.serializer().descriptor, isOptional = true)
      element("_authorDescription", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Author =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Author) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSourceMaterial.Organism.Author {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var authorType: CodeableConcept? = null
    var authorDescription: KotlinString? = null
    var _authorDescription: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          authorType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.authorTypeSer, null)
        4 -> authorDescription = decoder.decodeStringElement(descriptor, i)
        5 ->
          _authorDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.authorDescriptionSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Author: " + i)
      }
    }
    return SubstanceSourceMaterial.Organism.Author(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      authorType = authorType,
      authorDescription = R4String.of(authorDescription, _authorDescription),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.Organism.Author,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.authorType)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.authorTypeSer, it)
    }
    ((value.authorDescription?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.authorDescription?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.authorDescriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val authorTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val authorDescriptionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubstanceSourceMaterialOrganismHybridSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Hybrid> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Hybrid") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("maternalOrganismId", KotlinString.serializer().descriptor, isOptional = true)
      element("_maternalOrganismId", Element.serializer().descriptor, isOptional = true)
      element("maternalOrganismName", KotlinString.serializer().descriptor, isOptional = true)
      element("_maternalOrganismName", Element.serializer().descriptor, isOptional = true)
      element("paternalOrganismId", KotlinString.serializer().descriptor, isOptional = true)
      element("_paternalOrganismId", Element.serializer().descriptor, isOptional = true)
      element("paternalOrganismName", KotlinString.serializer().descriptor, isOptional = true)
      element("_paternalOrganismName", Element.serializer().descriptor, isOptional = true)
      element("hybridType", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Hybrid =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Hybrid) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSourceMaterial.Organism.Hybrid {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> maternalOrganismId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _maternalOrganismId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maternalOrganismIdSer,
              null,
            )
        5 -> maternalOrganismName = decoder.decodeStringElement(descriptor, i)
        6 ->
          _maternalOrganismName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maternalOrganismIdSer,
              null,
            )
        7 -> paternalOrganismId = decoder.decodeStringElement(descriptor, i)
        8 ->
          _paternalOrganismId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maternalOrganismIdSer,
              null,
            )
        9 -> paternalOrganismName = decoder.decodeStringElement(descriptor, i)
        10 ->
          _paternalOrganismName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maternalOrganismIdSer,
              null,
            )
        11 ->
          hybridType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.hybridTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Hybrid: " + i)
      }
    }
    return SubstanceSourceMaterial.Organism.Hybrid(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.Organism.Hybrid,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.maternalOrganismId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.maternalOrganismId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.maternalOrganismIdSer, it)
    }
    ((value.maternalOrganismName?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.maternalOrganismName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.maternalOrganismIdSer, it)
    }
    ((value.paternalOrganismId?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.paternalOrganismId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.maternalOrganismIdSer, it)
    }
    ((value.paternalOrganismName?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.paternalOrganismName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.maternalOrganismIdSer, it)
    }
    (value.hybridType)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.hybridTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val maternalOrganismIdSer: KSerializer<Element> = Element.serializer()

    public val hybridTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object SubstanceSourceMaterialOrganismOrganismGeneralSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.OrganismGeneral> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OrganismGeneral") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("kingdom", CodeableConcept.serializer().descriptor, isOptional = true)
      element("phylum", CodeableConcept.serializer().descriptor, isOptional = true)
      element("class", CodeableConcept.serializer().descriptor, isOptional = true)
      element("order", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.OrganismGeneral =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSourceMaterial.Organism.OrganismGeneral,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSourceMaterial.Organism.OrganismGeneral {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var kingdom: CodeableConcept? = null
    var phylum: CodeableConcept? = null
    var `class`: CodeableConcept? = null
    var order: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          kingdom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kingdomSer, null)
        4 ->
          phylum =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kingdomSer, null)
        5 ->
          `class` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kingdomSer, null)
        6 ->
          order = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.kingdomSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OrganismGeneral: " + i)
      }
    }
    return SubstanceSourceMaterial.Organism.OrganismGeneral(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      kingdom = kingdom,
      phylum = phylum,
      `class` = `class`,
      order = order,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.Organism.OrganismGeneral,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.kingdom)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.kingdomSer, it)
    }
    (value.phylum)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.kingdomSer, it) }
    (value.`class`)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.kingdomSer, it)
    }
    (value.order)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.kingdomSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val kingdomSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object SubstanceSourceMaterialPartDescriptionSerializer :
  KSerializer<SubstanceSourceMaterial.PartDescription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PartDescription") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("part", CodeableConcept.serializer().descriptor, isOptional = true)
      element("partLocation", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.PartDescription =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.PartDescription) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): SubstanceSourceMaterial.PartDescription {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: CodeableConcept? = null
    var partLocation: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> part = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partSer, null)
        4 ->
          partLocation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PartDescription: " + i)
      }
    }
    return SubstanceSourceMaterial.PartDescription(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      part = part,
      partLocation = partLocation,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubstanceSourceMaterial.PartDescription,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.part)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.partSer, it) }
    (value.partLocation)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.partSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val partSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object SubstanceSourceMaterialSerializer : KSerializer<SubstanceSourceMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceSourceMaterial") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("sourceMaterialClass", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("sourceMaterialType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("sourceMaterialState", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("organismId", Identifier.serializer().descriptor, isOptional = true)
    b.element("organismName", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_organismName", Element.serializer().descriptor, isOptional = true)
    b.element(
      "parentSubstanceId",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "parentSubstanceName",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_parentSubstanceName",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "countryOfOrigin",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "geographicalLocation",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_geographicalLocation",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("developmentStage", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "fractionDescription",
      listSerialDescriptor(
        lazyDescriptor { SubstanceSourceMaterial.FractionDescription.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "organism",
      lazyDescriptor { SubstanceSourceMaterial.Organism.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "partDescription",
      listSerialDescriptor(
        lazyDescriptor { SubstanceSourceMaterial.PartDescription.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubstanceSourceMaterial")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          sourceMaterialClass =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceMaterialClassSer,
              null,
            )
        11 ->
          sourceMaterialType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceMaterialClassSer,
              null,
            )
        12 ->
          sourceMaterialState =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceMaterialClassSer,
              null,
            )
        13 ->
          organismId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.organismIdSer, null)
        14 -> organismName = decoder.decodeStringElement(descriptor, i)
        15 ->
          _organismName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          parentSubstanceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parentSubstanceIdSer,
              null,
            )
        17 ->
          parentSubstanceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parentSubstanceNameSer,
              null,
            )
        18 ->
          _parentSubstanceName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parentSubstanceNameSer2,
              null,
            )
        19 ->
          countryOfOrigin =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.countryOfOriginSer,
              null,
            )
        20 ->
          geographicalLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parentSubstanceNameSer,
              null,
            )
        21 ->
          _geographicalLocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.parentSubstanceNameSer2,
              null,
            )
        22 ->
          developmentStage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sourceMaterialClassSer,
              null,
            )
        23 ->
          fractionDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.fractionDescriptionSer,
              null,
            )
        24 ->
          organism =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.organismSer, null)
        25 ->
          partDescription =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.partDescriptionSer,
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
          R4String.of(
            parentSubstanceName?.getOrNull(index)?.let { it },
            _parentSubstanceName?.getOrNull(index),
          )!!
        }),
      countryOfOrigin = countryOfOrigin ?: listOf(),
      geographicalLocation =
        (kotlin.collections.List(
          maxOf(geographicalLocation?.size ?: 0, _geographicalLocation?.size ?: 0)
        ) { index ->
          R4String.of(
            geographicalLocation?.getOrNull(index)?.let { it },
            _geographicalLocation?.getOrNull(index),
          )!!
        }),
      developmentStage = developmentStage,
      fractionDescription = fractionDescription ?: listOf(),
      organism = organism,
      partDescription = partDescription ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubstanceSourceMaterial,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.sourceMaterialClass)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.sourceMaterialClassSer,
        it,
      )
    }
    (value.sourceMaterialType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.sourceMaterialClassSer,
        it,
      )
    }
    (value.sourceMaterialState)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.sourceMaterialClassSer,
        it,
      )
    }
    (value.organismId)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.organismIdSer,
        it,
      )
    }
    ((value.organismName?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.organismName?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.parentSubstanceId.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.parentSubstanceIdSer,
        value.parentSubstanceId,
      )
    (value.parentSubstanceName.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.parentSubstanceNameSer,
        it,
      )
    }
    (value.parentSubstanceName.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.parentSubstanceNameSer2,
        it,
      )
    }
    if (value.countryOfOrigin.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.countryOfOriginSer,
        value.countryOfOrigin,
      )
    (value.geographicalLocation.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.parentSubstanceNameSer,
        it,
      )
    }
    (value.geographicalLocation.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.parentSubstanceNameSer2,
        it,
      )
    }
    (value.developmentStage)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.sourceMaterialClassSer,
        it,
      )
    }
    if (value.fractionDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.fractionDescriptionSer,
        value.fractionDescription,
      )
    (value.organism)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.organismSer, it)
    }
    if (value.partDescription.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.partDescriptionSer,
        value.partDescription,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sourceMaterialClassSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val organismIdSer: KSerializer<Identifier> = Identifier.serializer()

    public val parentSubstanceIdSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.organismIdSer)

    public val parentSubstanceNameSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val parentSubstanceNameSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.parentSubstanceNameSerInner).nullable)

    public val parentSubstanceNameSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val countryOfOriginSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.sourceMaterialClassSer)

    public val fractionDescriptionSerInner:
      KSerializer<SubstanceSourceMaterial.FractionDescription> =
      SubstanceSourceMaterial.FractionDescription.serializer()

    public val fractionDescriptionSer:
      KSerializer<List<SubstanceSourceMaterial.FractionDescription>> =
      ListSerializer(Hoisted.fractionDescriptionSerInner)

    public val organismSer: KSerializer<SubstanceSourceMaterial.Organism> =
      SubstanceSourceMaterial.Organism.serializer()

    public val partDescriptionSerInner: KSerializer<SubstanceSourceMaterial.PartDescription> =
      SubstanceSourceMaterial.PartDescription.serializer()

    public val partDescriptionSer: KSerializer<List<SubstanceSourceMaterial.PartDescription>> =
      ListSerializer(Hoisted.partDescriptionSerInner)
  }
}

internal object SubstanceSourceMaterialPolymorphicSerializer :
  KSerializer<SubstanceSourceMaterial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubstanceSourceMaterial") {
      SubstanceSourceMaterialSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial) {
    encoder.encodeStructure(descriptor) {
      SubstanceSourceMaterialSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial =
    decoder.decodeStructure(descriptor) {
      SubstanceSourceMaterialSerializer.deserializeInternal(this, descriptor, 0)
    }
}
