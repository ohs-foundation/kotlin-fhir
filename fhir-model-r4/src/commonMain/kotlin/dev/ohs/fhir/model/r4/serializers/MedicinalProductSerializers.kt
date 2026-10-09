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
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MarketingStatus
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MedicinalProductNameSerializer : FhirSerializer<MedicinalProduct.Name> {
  override val descriptor: SerialDescriptor = buildDescriptor("Name", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProduct.Name>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("productName")
    b.optionalElement("namePart", MedicinalProductNameNamePartSerializer.listSerializer.descriptor)
    b.optionalElement(
      "countryLanguage",
      MedicinalProductNameCountryLanguageSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var namePart: List<MedicinalProduct.Name.NamePart>? = null
    var countryLanguage: List<MedicinalProduct.Name.CountryLanguage>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> productName = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _productName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          namePart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductNameNamePartSerializer.listSerializer,
              null,
            )
        6 ->
          countryLanguage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductNameCountryLanguageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProduct.Name(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      productName =
        required(R4String.of(productName, _productName), "MedicinalProduct.Name", "productName"),
      namePart = listOrEmpty(namePart),
      countryLanguage = listOrEmpty(countryLanguage),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.productName.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.productName)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      MedicinalProductNameNamePartSerializer.listSerializer,
      value.namePart,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      MedicinalProductNameCountryLanguageSerializer.listSerializer,
      value.countryLanguage,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductNameNamePartSerializer :
  FhirSerializer<MedicinalProduct.Name.NamePart> {
  override val descriptor: SerialDescriptor = buildDescriptor("NamePart", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProduct.Name.NamePart>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("part")
    b.optionalElement("type", CodingSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.NamePart {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: KotlinString? = null
    var _part: Element? = null
    var type: Coding? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> part = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProduct.Name.NamePart(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      part = required(R4String.of(part, _part), "MedicinalProduct.Name.NamePart", "part"),
      type = required(type, "MedicinalProduct.Name.NamePart", "type"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.NamePart) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.part.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.part)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.type)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductNameCountryLanguageSerializer :
  FhirSerializer<MedicinalProduct.Name.CountryLanguage> {
  override val descriptor: SerialDescriptor = buildDescriptor("CountryLanguage", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProduct.Name.CountryLanguage>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("country", CodeableConceptSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
    b.optionalElement("language", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.CountryLanguage {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var country: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          country =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProduct.Name.CountryLanguage(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      country = required(country, "MedicinalProduct.Name.CountryLanguage", "country"),
      jurisdiction = jurisdiction,
      language = required(language, "MedicinalProduct.Name.CountryLanguage", "language"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.CountryLanguage) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.country,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductManufacturingBusinessOperationSerializer :
  FhirSerializer<MedicinalProduct.ManufacturingBusinessOperation> {
  override val descriptor: SerialDescriptor =
    buildDescriptor("ManufacturingBusinessOperation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProduct.ManufacturingBusinessOperation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operationType", CodeableConceptSerializer.descriptor)
    b.optionalElement("authorisationReferenceNumber", IdentifierSerializer.descriptor)
    b.strPrim("effectiveDate")
    b.optionalElement("confidentialityIndicator", CodeableConceptSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("regulator", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct.ManufacturingBusinessOperation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operationType: CodeableConcept? = null
    var authorisationReferenceNumber: Identifier? = null
    var effectiveDate: FhirDateTime? = null
    var _effectiveDate: Element? = null
    var confidentialityIndicator: CodeableConcept? = null
    var manufacturer: List<Reference>? = null
    var regulator: Reference? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operationType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          authorisationReferenceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        5 ->
          effectiveDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _effectiveDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          confidentialityIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        9 ->
          regulator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProduct.ManufacturingBusinessOperation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operationType = operationType,
      authorisationReferenceNumber = authorisationReferenceNumber,
      effectiveDate = DateTime.of(effectiveDate, _effectiveDate),
      confidentialityIndicator = confidentialityIndicator,
      manufacturer = listOrEmpty(manufacturer),
      regulator = regulator,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProduct.ManufacturingBusinessOperation,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.operationType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      IdentifierSerializer,
      value.authorisationReferenceNumber,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.effectiveDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.effectiveDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.confidentialityIndicator,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      ReferenceSerializer,
      value.regulator,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductSpecialDesignationSerializer :
  FhirSerializer<MedicinalProduct.SpecialDesignation> {
  override val descriptor: SerialDescriptor = buildDescriptor("SpecialDesignation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProduct.SpecialDesignation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("intendedUse", CodeableConceptSerializer.descriptor)
    b.optionalElement("indicationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("indicationReference", ReferenceSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("species", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct.SpecialDesignation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var intendedUse: CodeableConcept? = null
    var indicationCodeableConcept: CodeableConcept? = null
    var indicationReference: Reference? = null
    var status: CodeableConcept? = null
    var date: FhirDateTime? = null
    var _date: Element? = null
    var species: CodeableConcept? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          intendedUse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          indicationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          indicationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          species =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProduct.SpecialDesignation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = type,
      intendedUse = intendedUse,
      indication =
        MedicinalProduct.SpecialDesignation.Indication.from(
          indicationCodeableConcept,
          indicationReference,
        ),
      status = status,
      date = DateTime.of(date, _date),
      species = species,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.SpecialDesignation) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.intendedUse,
    )
    when (val choice = value.indication) {
      null -> {}
      is MedicinalProduct.SpecialDesignation.Indication.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MedicinalProduct.SpecialDesignation.Indication.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.species,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductSerializer : FhirResourceSerializer<MedicinalProduct> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProduct")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("domain", CodingSerializer.descriptor)
    b.optionalElement("combinedPharmaceuticalDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("legalStatusOfSupply", CodeableConceptSerializer.descriptor)
    b.optionalElement("additionalMonitoringIndicator", CodeableConceptSerializer.descriptor)
    b.strPrimList("specialMeasures")
    b.optionalElement("paediatricUseIndicator", CodeableConceptSerializer.descriptor)
    b.optionalElement("productClassification", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement("pharmaceuticalProduct", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("packagedMedicinalProduct", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("attachedDocument", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("masterFile", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("contact", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("clinicalTrial", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("name", MedicinalProductNameSerializer.listSerializer.descriptor)
    b.optionalElement("crossReference", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement(
      "manufacturingBusinessOperation",
      MedicinalProductManufacturingBusinessOperationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "specialDesignation",
      MedicinalProductSpecialDesignationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProduct {
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
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var domain: Coding? = null
    var combinedPharmaceuticalDoseForm: CodeableConcept? = null
    var legalStatusOfSupply: CodeableConcept? = null
    var additionalMonitoringIndicator: CodeableConcept? = null
    var specialMeasures: List<KotlinString?>? = null
    var _specialMeasures: List<Element?>? = null
    var paediatricUseIndicator: CodeableConcept? = null
    var productClassification: List<CodeableConcept>? = null
    var marketingStatus: List<MarketingStatus>? = null
    var pharmaceuticalProduct: List<Reference>? = null
    var packagedMedicinalProduct: List<Reference>? = null
    var attachedDocument: List<Reference>? = null
    var masterFile: List<Reference>? = null
    var contact: List<Reference>? = null
    var clinicalTrial: List<Reference>? = null
    var name: List<MedicinalProduct.Name>? = null
    var crossReference: List<Identifier>? = null
    var manufacturingBusinessOperation: List<MedicinalProduct.ManufacturingBusinessOperation>? =
      null
    var specialDesignation: List<MedicinalProduct.SpecialDesignation>? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          domain =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        13 ->
          combinedPharmaceuticalDoseForm =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          legalStatusOfSupply =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          additionalMonitoringIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          specialMeasures =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _specialMeasures =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          paediatricUseIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          productClassification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          marketingStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        21 ->
          pharmaceuticalProduct =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          packagedMedicinalProduct =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          attachedDocument =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          masterFile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          clinicalTrial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductNameSerializer.listSerializer,
              null,
            )
        28 ->
          crossReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        29 ->
          manufacturingBusinessOperation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductManufacturingBusinessOperationSerializer.listSerializer,
              null,
            )
        30 ->
          specialDesignation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductSpecialDesignationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val specialMeasures_ =
      List(maxSize(specialMeasures, _specialMeasures)) { index ->
        entryRequired(
          R4String.of(at(specialMeasures, index), at(_specialMeasures, index)),
          "MedicinalProduct",
          "specialMeasures",
        )
      }
    return MedicinalProduct(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = type,
      domain = domain,
      combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm,
      legalStatusOfSupply = legalStatusOfSupply,
      additionalMonitoringIndicator = additionalMonitoringIndicator,
      specialMeasures = specialMeasures_,
      paediatricUseIndicator = paediatricUseIndicator,
      productClassification = listOrEmpty(productClassification),
      marketingStatus = listOrEmpty(marketingStatus),
      pharmaceuticalProduct = listOrEmpty(pharmaceuticalProduct),
      packagedMedicinalProduct = listOrEmpty(packagedMedicinalProduct),
      attachedDocument = listOrEmpty(attachedDocument),
      masterFile = listOrEmpty(masterFile),
      contact = listOrEmpty(contact),
      clinicalTrial = listOrEmpty(clinicalTrial),
      name = listOrEmpty(name),
      crossReference = listOrEmpty(crossReference),
      manufacturingBusinessOperation = listOrEmpty(manufacturingBusinessOperation),
      specialDesignation = listOrEmpty(specialDesignation),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProduct,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodingSerializer,
      value.domain,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.combinedPharmaceuticalDoseForm,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalStatusOfSupply,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.additionalMonitoringIndicator,
    )
    if (!value.specialMeasures.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.specialMeasures.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        17 + descriptorOffset,
        value.specialMeasures,
      )
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.paediatricUseIndicator,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.productClassification,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20 + descriptorOffset,
      MarketingStatusSerializer.listSerializer,
      value.marketingStatus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.pharmaceuticalProduct,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.packagedMedicinalProduct,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.attachedDocument,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.masterFile,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.clinicalTrial,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      MedicinalProductNameSerializer.listSerializer,
      value.name,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.crossReference,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      MedicinalProductManufacturingBusinessOperationSerializer.listSerializer,
      value.manufacturingBusinessOperation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      MedicinalProductSpecialDesignationSerializer.listSerializer,
      value.specialDesignation,
    )
  }
}
