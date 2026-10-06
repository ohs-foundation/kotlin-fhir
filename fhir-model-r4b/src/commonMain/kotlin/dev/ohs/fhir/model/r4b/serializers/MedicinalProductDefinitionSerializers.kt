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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MarketingStatus
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object MedicinalProductDefinitionContactSerializer :
  KSerializer<MedicinalProductDefinition.Contact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("contact", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Contact>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Contact =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var contact: Reference? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> contact = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contact: " + i)
        }
      }
      MedicinalProductDefinition.Contact(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        contact =
          contact
            ?: throw SerializationException(
              "Missing required property 'contact' on MedicinalProductDefinition.Contact"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Contact) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.contact)
    }
  }
}

internal object MedicinalProductDefinitionNameSerializer :
  KSerializer<MedicinalProductDefinition.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("productName", KotlinString.serializer().descriptor)
      optionalElement("_productName", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement(
        "namePart",
        MedicinalProductDefinitionNameNamePartSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "countryLanguage",
        MedicinalProductDefinitionNameCountryLanguageSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var productName: KotlinString? = null
      var _productName: Element? = null
      var type: CodeableConcept? = null
      var namePart: List<MedicinalProductDefinition.Name.NamePart>? = null
      var countryLanguage: List<MedicinalProductDefinition.Name.CountryLanguage>? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            namePart =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductDefinitionNameNamePartSerializer.listSerializer,
                null,
              )
          7 ->
            countryLanguage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductDefinitionNameCountryLanguageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Name: " + i)
        }
      }
      MedicinalProductDefinition.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        productName =
          R4bString.of(productName, _productName)
            ?: throw SerializationException(
              "Missing required property 'productName' on MedicinalProductDefinition.Name"
            ),
        type = type,
        namePart = namePart ?: listOf(),
        countryLanguage = countryLanguage ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name) {
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      if (value.namePart.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicinalProductDefinitionNameNamePartSerializer.listSerializer,
          value.namePart,
        )
      if (value.countryLanguage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MedicinalProductDefinitionNameCountryLanguageSerializer.listSerializer,
          value.countryLanguage,
        )
    }
  }
}

internal object MedicinalProductDefinitionNameNamePartSerializer :
  KSerializer<MedicinalProductDefinition.Name.NamePart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NamePart") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("part", KotlinString.serializer().descriptor)
      optionalElement("_part", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name.NamePart>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.NamePart =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var part: KotlinString? = null
      var _part: Element? = null
      var type: CodeableConcept? = null
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
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NamePart: " + i)
        }
      }
      MedicinalProductDefinition.Name.NamePart(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        part =
          R4bString.of(part, _part)
            ?: throw SerializationException(
              "Missing required property 'part' on MedicinalProductDefinition.Name.NamePart"
            ),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicinalProductDefinition.Name.NamePart"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.NamePart) {
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
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
    }
  }
}

internal object MedicinalProductDefinitionNameCountryLanguageSerializer :
  KSerializer<MedicinalProductDefinition.Name.CountryLanguage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CountryLanguage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name.CountryLanguage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.CountryLanguage =
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
      MedicinalProductDefinition.Name.CountryLanguage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        country =
          country
            ?: throw SerializationException(
              "Missing required property 'country' on MedicinalProductDefinition.Name.CountryLanguage"
            ),
        jurisdiction = jurisdiction,
        language =
          language
            ?: throw SerializationException(
              "Missing required property 'language' on MedicinalProductDefinition.Name.CountryLanguage"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.country)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.jurisdiction)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.language)
    }
  }
}

internal object MedicinalProductDefinitionCrossReferenceSerializer :
  KSerializer<MedicinalProductDefinition.CrossReference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CrossReference") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("product", CodeableReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.CrossReference>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.CrossReference =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var product: CodeableReference? = null
      var type: CodeableConcept? = null
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
            product =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CrossReference: " + i)
        }
      }
      MedicinalProductDefinition.CrossReference(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        product =
          product
            ?: throw SerializationException(
              "Missing required property 'product' on MedicinalProductDefinition.CrossReference"
            ),
        type = type,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.CrossReference) {
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.product)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
    }
  }
}

internal object MedicinalProductDefinitionOperationSerializer :
  KSerializer<MedicinalProductDefinition.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableReferenceSerializer.descriptor)
      optionalElement("effectiveDate", PeriodSerializer.descriptor)
      optionalElement("organization", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("confidentialityIndicator", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Operation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableReference? = null
      var effectiveDate: Period? = null
      var organization: List<Reference>? = null
      var confidentialityIndicator: CodeableConcept? = null
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
            type =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            effectiveDate = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          5 ->
            organization =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            confidentialityIndicator =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Operation: " + i)
        }
      }
      MedicinalProductDefinition.Operation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        effectiveDate = effectiveDate,
        organization = organization ?: listOf(),
        confidentialityIndicator = confidentialityIndicator,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Operation) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.effectiveDate)
      if (value.organization.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ReferenceSerializer.listSerializer,
          value.organization,
        )
      encodeSerializableIfNotNull(
        descriptor,
        6,
        CodeableConceptSerializer,
        value.confidentialityIndicator,
      )
    }
  }
}

internal object MedicinalProductDefinitionCharacteristicSerializer :
  KSerializer<MedicinalProductDefinition.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueDate: KotlinString? = null
      var _valueDate: Element? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueAttachment: Attachment? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueDate = decodeStringElement(descriptor, i)
          7 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      MedicinalProductDefinition.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicinalProductDefinition.Characteristic"
            ),
        `value` =
          MedicinalProductDefinition.Characteristic.Value.from(
            valueCodeableConcept,
            valueQuantity,
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            R4bBoolean.of(valueBoolean, _valueBoolean),
            valueAttachment,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Characteristic) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        null -> {}
        is MedicinalProductDefinition.Characteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Date -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object MedicinalProductDefinitionSerializer :
  FhirResourceSerializer<MedicinalProductDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProductDefinition")

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
    b.optionalElement("domain", CodeableConceptSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("statusDate", KotlinString.serializer().descriptor)
    b.optionalElement("_statusDate", ElementSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("combinedPharmaceuticalDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("route", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("indication", KotlinString.serializer().descriptor)
    b.optionalElement("_indication", ElementSerializer.descriptor)
    b.optionalElement("legalStatusOfSupply", CodeableConceptSerializer.descriptor)
    b.optionalElement("additionalMonitoringIndicator", CodeableConceptSerializer.descriptor)
    b.optionalElement("specialMeasures", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("pediatricUseIndicator", CodeableConceptSerializer.descriptor)
    b.optionalElement("classification", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement(
      "packagedMedicinalProduct",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.optionalElement("ingredient", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("impurity", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("attachedDocument", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("masterFile", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "contact",
      MedicinalProductDefinitionContactSerializer.listSerializer.descriptor,
    )
    b.optionalElement("clinicalTrial", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodingSerializer.listSerializer.descriptor)
    b.optionalElement("name", MedicinalProductDefinitionNameSerializer.listSerializer.descriptor)
    b.optionalElement(
      "crossReference",
      MedicinalProductDefinitionCrossReferenceSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "operation",
      MedicinalProductDefinitionOperationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "characteristic",
      MedicinalProductDefinitionCharacteristicSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProductDefinition {
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
    var domain: CodeableConcept? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var status: CodeableConcept? = null
    var statusDate: KotlinString? = null
    var _statusDate: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var combinedPharmaceuticalDoseForm: CodeableConcept? = null
    var route: List<CodeableConcept>? = null
    var indication: KotlinString? = null
    var _indication: Element? = null
    var legalStatusOfSupply: CodeableConcept? = null
    var additionalMonitoringIndicator: CodeableConcept? = null
    var specialMeasures: List<CodeableConcept>? = null
    var pediatricUseIndicator: CodeableConcept? = null
    var classification: List<CodeableConcept>? = null
    var marketingStatus: List<MarketingStatus>? = null
    var packagedMedicinalProduct: List<CodeableConcept>? = null
    var ingredient: List<CodeableConcept>? = null
    var impurity: List<CodeableReference>? = null
    var attachedDocument: List<Reference>? = null
    var masterFile: List<Reference>? = null
    var contact: List<MedicinalProductDefinition.Contact>? = null
    var clinicalTrial: List<Reference>? = null
    var code: List<Coding>? = null
    var name: List<MedicinalProductDefinition.Name>? = null
    var crossReference: List<MedicinalProductDefinition.CrossReference>? = null
    var operation: List<MedicinalProductDefinition.Operation>? = null
    var characteristic: List<MedicinalProductDefinition.Characteristic>? = null
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
          domain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> statusDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 -> description = decoder.decodeStringElement(descriptor, i)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          combinedPharmaceuticalDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          route =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 -> indication = decoder.decodeStringElement(descriptor, i)
        23 ->
          _indication =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          additionalMonitoringIndicator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          specialMeasures =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        27 ->
          pediatricUseIndicator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        30 ->
          packagedMedicinalProduct =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 ->
          impurity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        34 ->
          masterFile =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionContactSerializer.listSerializer,
              null,
            )
        36 ->
          clinicalTrial =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        38 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionNameSerializer.listSerializer,
              null,
            )
        39 ->
          crossReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionCrossReferenceSerializer.listSerializer,
              null,
            )
        40 ->
          operation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionOperationSerializer.listSerializer,
              null,
            )
        41 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionCharacteristicSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding MedicinalProductDefinition: " + i)
      }
    }
    return MedicinalProductDefinition(
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
      version = R4bString.of(version, _version),
      status = status,
      statusDate =
        DateTime.of(
          if (statusDate != null) FhirDateTime.fromString(statusDate) else null,
          _statusDate,
        ),
      description = Markdown.of(description, _description),
      combinedPharmaceuticalDoseForm = combinedPharmaceuticalDoseForm,
      route = route ?: listOf(),
      indication = Markdown.of(indication, _indication),
      legalStatusOfSupply = legalStatusOfSupply,
      additionalMonitoringIndicator = additionalMonitoringIndicator,
      specialMeasures = specialMeasures ?: listOf(),
      pediatricUseIndicator = pediatricUseIndicator,
      classification = classification ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      packagedMedicinalProduct = packagedMedicinalProduct ?: listOf(),
      ingredient = ingredient ?: listOf(),
      impurity = impurity ?: listOf(),
      attachedDocument = attachedDocument ?: listOf(),
      masterFile = masterFile ?: listOf(),
      contact = contact ?: listOf(),
      clinicalTrial = clinicalTrial ?: listOf(),
      code = code ?: listOf(),
      name = name ?: listOf(),
      crossReference = crossReference ?: listOf(),
      operation = operation ?: listOf(),
      characteristic = characteristic ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductDefinition,
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
      CodeableConceptSerializer,
      value.domain,
    )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusDate)
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.description)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.combinedPharmaceuticalDoseForm,
    )
    if (value.route.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.route,
      )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.indication?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.indication)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalStatusOfSupply,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.additionalMonitoringIndicator,
    )
    if (value.specialMeasures.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialMeasures,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.pediatricUseIndicator,
    )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.classification,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MarketingStatusSerializer.listSerializer,
        value.marketingStatus,
      )
    if (value.packagedMedicinalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.packagedMedicinalProduct,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.ingredient,
      )
    if (value.impurity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.impurity,
      )
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.attachedDocument,
      )
    if (value.masterFile.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.masterFile,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        MedicinalProductDefinitionContactSerializer.listSerializer,
        value.contact,
      )
    if (value.clinicalTrial.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.clinicalTrial,
      )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        MedicinalProductDefinitionNameSerializer.listSerializer,
        value.name,
      )
    if (value.crossReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        MedicinalProductDefinitionCrossReferenceSerializer.listSerializer,
        value.crossReference,
      )
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        MedicinalProductDefinitionOperationSerializer.listSerializer,
        value.operation,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        MedicinalProductDefinitionCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
  }
}
