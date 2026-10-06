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

internal object MedicinalProductNameSerializer : KSerializer<MedicinalProduct.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("productName", KotlinString.serializer().descriptor)
      optionalElement("_productName", ElementSerializer.descriptor)
      optionalElement("namePart", MedicinalProductNameNamePartSerializer.listSerializer.descriptor)
      optionalElement(
        "countryLanguage",
        MedicinalProductNameCountryLanguageSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProduct.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var productName: KotlinString? = null
      var _productName: Element? = null
      var namePart: List<MedicinalProduct.Name.NamePart>? = null
      var countryLanguage: List<MedicinalProduct.Name.CountryLanguage>? = null
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
          3 -> productName = decodeStringElement(descriptor, i)
          4 ->
            _productName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            namePart =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductNameNamePartSerializer.listSerializer,
                null,
              )
          6 ->
            countryLanguage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductNameCountryLanguageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Name: " + i)
        }
      }
      MedicinalProduct.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        productName =
          R4String.of(productName, _productName)
            ?: throw SerializationException(
              "Missing required property 'productName' on MedicinalProduct.Name"
            ),
        namePart = namePart ?: listOf(),
        countryLanguage = countryLanguage ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name) {
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
      encodeStringIfNotNull(descriptor, 3, value.productName.value)
      encodeElementIfNotNull(descriptor, 4, value.productName)
      if (value.namePart.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          MedicinalProductNameNamePartSerializer.listSerializer,
          value.namePart,
        )
      if (value.countryLanguage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicinalProductNameCountryLanguageSerializer.listSerializer,
          value.countryLanguage,
        )
    }
  }
}

internal object MedicinalProductNameNamePartSerializer :
  KSerializer<MedicinalProduct.Name.NamePart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NamePart") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("part", KotlinString.serializer().descriptor)
      optionalElement("_part", ElementSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProduct.Name.NamePart>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.NamePart =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var part: KotlinString? = null
      var _part: Element? = null
      var type: Coding? = null
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
          3 -> part = decodeStringElement(descriptor, i)
          4 -> _part = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> type = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NamePart: " + i)
        }
      }
      MedicinalProduct.Name.NamePart(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        part =
          R4String.of(part, _part)
            ?: throw SerializationException(
              "Missing required property 'part' on MedicinalProduct.Name.NamePart"
            ),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicinalProduct.Name.NamePart"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.NamePart) {
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
      encodeStringIfNotNull(descriptor, 3, value.part.value)
      encodeElementIfNotNull(descriptor, 4, value.part)
      encodeSerializableElement(descriptor, 5, CodingSerializer, value.type)
    }
  }
}

internal object MedicinalProductNameCountryLanguageSerializer :
  KSerializer<MedicinalProduct.Name.CountryLanguage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CountryLanguage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProduct.Name.CountryLanguage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.CountryLanguage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var country: CodeableConcept? = null
      var jurisdiction: CodeableConcept? = null
      var language: CodeableConcept? = null
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
            country =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            jurisdiction =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CountryLanguage: " + i)
        }
      }
      MedicinalProduct.Name.CountryLanguage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        country =
          country
            ?: throw SerializationException(
              "Missing required property 'country' on MedicinalProduct.Name.CountryLanguage"
            ),
        jurisdiction = jurisdiction,
        language =
          language
            ?: throw SerializationException(
              "Missing required property 'language' on MedicinalProduct.Name.CountryLanguage"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.CountryLanguage) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.country)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.jurisdiction)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.language)
    }
  }
}

internal object MedicinalProductManufacturingBusinessOperationSerializer :
  KSerializer<MedicinalProduct.ManufacturingBusinessOperation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturingBusinessOperation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operationType", CodeableConceptSerializer.descriptor)
      optionalElement("authorisationReferenceNumber", IdentifierSerializer.descriptor)
      optionalElement("effectiveDate", KotlinString.serializer().descriptor)
      optionalElement("_effectiveDate", ElementSerializer.descriptor)
      optionalElement("confidentialityIndicator", CodeableConceptSerializer.descriptor)
      optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("regulator", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProduct.ManufacturingBusinessOperation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProduct.ManufacturingBusinessOperation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var operationType: CodeableConcept? = null
      var authorisationReferenceNumber: Identifier? = null
      var effectiveDate: KotlinString? = null
      var _effectiveDate: Element? = null
      var confidentialityIndicator: CodeableConcept? = null
      var manufacturer: List<Reference>? = null
      var regulator: Reference? = null
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
            operationType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            authorisationReferenceNumber =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 -> effectiveDate = decodeStringElement(descriptor, i)
          6 ->
            _effectiveDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            confidentialityIndicator =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            manufacturer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          9 ->
            regulator = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException(
              "Unexpected index decoding ManufacturingBusinessOperation: " + i
            )
        }
      }
      MedicinalProduct.ManufacturingBusinessOperation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        operationType = operationType,
        authorisationReferenceNumber = authorisationReferenceNumber,
        effectiveDate =
          DateTime.of(
            if (effectiveDate != null) FhirDateTime.fromString(effectiveDate) else null,
            _effectiveDate,
          ),
        confidentialityIndicator = confidentialityIndicator,
        manufacturer = manufacturer ?: listOf(),
        regulator = regulator,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProduct.ManufacturingBusinessOperation,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.operationType)
      encodeSerializableIfNotNull(
        descriptor,
        4,
        IdentifierSerializer,
        value.authorisationReferenceNumber,
      )
      encodeStringIfNotNull(descriptor, 5, value.effectiveDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.effectiveDate)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        CodeableConceptSerializer,
        value.confidentialityIndicator,
      )
      if (value.manufacturer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ReferenceSerializer.listSerializer,
          value.manufacturer,
        )
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.regulator)
    }
  }
}

internal object MedicinalProductSpecialDesignationSerializer :
  KSerializer<MedicinalProduct.SpecialDesignation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecialDesignation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("intendedUse", CodeableConceptSerializer.descriptor)
      optionalElement("indicationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("indicationReference", ReferenceSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("species", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProduct.SpecialDesignation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProduct.SpecialDesignation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var type: CodeableConcept? = null
      var intendedUse: CodeableConcept? = null
      var indicationCodeableConcept: CodeableConcept? = null
      var indicationReference: Reference? = null
      var status: CodeableConcept? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var species: CodeableConcept? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            intendedUse =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            indicationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            indicationReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 -> date = decodeStringElement(descriptor, i)
          10 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            species =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SpecialDesignation: " + i)
        }
      }
      MedicinalProduct.SpecialDesignation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        type = type,
        intendedUse = intendedUse,
        indication =
          MedicinalProduct.SpecialDesignation.Indication.from(
            indicationCodeableConcept,
            indicationReference,
          ),
        status = status,
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
        species = species,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.SpecialDesignation) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.intendedUse)
      when (val choice = value.indication) {
        null -> {}
        is MedicinalProduct.SpecialDesignation.Indication.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is MedicinalProduct.SpecialDesignation.Indication.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.status)
      encodeStringIfNotNull(descriptor, 9, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 10, value.date)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.species)
    }
  }
}

internal object MedicinalProductSerializer : FhirResourceSerializer<MedicinalProduct> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProduct")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("domain", CodingSerializer.descriptor)
    b.optionalElement("combinedPharmaceuticalDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("legalStatusOfSupply", CodeableConceptSerializer.descriptor)
    b.optionalElement("additionalMonitoringIndicator", CodeableConceptSerializer.descriptor)
    b.optionalElement("specialMeasures", stringNullableListSerializer.descriptor)
    b.optionalElement("_specialMeasures", ElementSerializer.nullableListSerializer.descriptor)
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
    decoder: CompositeDecoder,
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
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          domain = decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        13 ->
          combinedPharmaceuticalDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          additionalMonitoringIndicator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          specialMeasures =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _specialMeasures =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          paediatricUseIndicator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          productClassification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        21 ->
          pharmaceuticalProduct =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          packagedMedicinalProduct =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        23 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          masterFile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          clinicalTrial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductNameSerializer.listSerializer,
              null,
            )
        28 ->
          crossReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        29 ->
          manufacturingBusinessOperation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductManufacturingBusinessOperationSerializer.listSerializer,
              null,
            )
        30 ->
          specialDesignation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductSpecialDesignationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MedicinalProduct: " + i)
      }
    }
    return MedicinalProduct(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type,
      domain = domain,
      combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm,
      legalStatusOfSupply = legalStatusOfSupply,
      additionalMonitoringIndicator = additionalMonitoringIndicator,
      specialMeasures =
        (kotlin.collections.List(maxOf(specialMeasures?.size ?: 0, _specialMeasures?.size ?: 0)) {
          index ->
          R4String.of(specialMeasures?.getOrNull(index), _specialMeasures?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'specialMeasures' on MedicinalProduct has neither a value nor an id/extension"
            )
        }),
      paediatricUseIndicator = paediatricUseIndicator,
      productClassification = productClassification ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      pharmaceuticalProduct = pharmaceuticalProduct ?: listOf(),
      packagedMedicinalProduct = packagedMedicinalProduct ?: listOf(),
      attachedDocument = attachedDocument ?: listOf(),
      masterFile = masterFile ?: listOf(),
      contact = contact ?: listOf(),
      clinicalTrial = clinicalTrial ?: listOf(),
      name = name ?: listOf(),
      crossReference = crossReference ?: listOf(),
      manufacturingBusinessOperation = manufacturingBusinessOperation ?: listOf(),
      specialDesignation = specialDesignation ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProduct,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodingSerializer,
      value.domain,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.combinedPharmaceuticalDoseForm,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalStatusOfSupply,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.additionalMonitoringIndicator,
    )
    if (value.specialMeasures.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.specialMeasures.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.specialMeasures)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.paediatricUseIndicator,
    )
    if (value.productClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.productClassification,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        MarketingStatusSerializer.listSerializer,
        value.marketingStatus,
      )
    if (value.pharmaceuticalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.pharmaceuticalProduct,
      )
    if (value.packagedMedicinalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.packagedMedicinalProduct,
      )
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.attachedDocument,
      )
    if (value.masterFile.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.masterFile,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contact,
      )
    if (value.clinicalTrial.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.clinicalTrial,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MedicinalProductNameSerializer.listSerializer,
        value.name,
      )
    if (value.crossReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.crossReference,
      )
    if (value.manufacturingBusinessOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MedicinalProductManufacturingBusinessOperationSerializer.listSerializer,
        value.manufacturingBusinessOperation,
      )
    if (value.specialDesignation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        MedicinalProductSpecialDesignationSerializer.listSerializer,
        value.specialDesignation,
      )
  }
}
