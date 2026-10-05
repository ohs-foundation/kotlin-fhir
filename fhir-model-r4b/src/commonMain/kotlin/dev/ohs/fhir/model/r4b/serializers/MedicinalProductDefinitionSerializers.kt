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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("contact", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Contact>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Contact =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Contact) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicinalProductDefinition.Contact {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var contact: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contact: " + i)
      }
    }
    return MedicinalProductDefinition.Contact(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Contact,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.contact)
  }
}

internal object MedicinalProductDefinitionNameSerializer :
  KSerializer<MedicinalProductDefinition.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
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
      element("productName", KotlinString.serializer().descriptor, isOptional = true)
      element("_productName", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "namePart",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Name.NamePart.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "countryLanguage",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Name.CountryLanguage.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicinalProductDefinition.Name {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var type: CodeableConcept? = null
    var namePart: List<MedicinalProductDefinition.Name.NamePart>? = null
    var countryLanguage: List<MedicinalProductDefinition.Name.CountryLanguage>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> productName = decoder.decodeStringElement(descriptor, i)
        4 ->
          _productName =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          namePart =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionNameNamePartSerializer.listSerializer,
              null,
            )
        7 ->
          countryLanguage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductDefinitionNameCountryLanguageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + i)
      }
    }
    return MedicinalProductDefinition.Name(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.productName.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.productName.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    if (value.namePart.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        MedicinalProductDefinitionNameNamePartSerializer.listSerializer,
        value.namePart,
      )
    if (value.countryLanguage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        MedicinalProductDefinitionNameCountryLanguageSerializer.listSerializer,
        value.countryLanguage,
      )
  }
}

internal object MedicinalProductDefinitionNameNamePartSerializer :
  KSerializer<MedicinalProductDefinition.Name.NamePart> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NamePart") {
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
      element("part", KotlinString.serializer().descriptor, isOptional = true)
      element("_part", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name.NamePart>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.NamePart =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.NamePart) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Name.NamePart {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: KotlinString? = null
    var _part: Element? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> part = decoder.decodeStringElement(descriptor, i)
        4 ->
          _part = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NamePart: " + i)
      }
    }
    return MedicinalProductDefinition.Name.NamePart(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name.NamePart,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.part.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.part.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
  }
}

internal object MedicinalProductDefinitionNameCountryLanguageSerializer :
  KSerializer<MedicinalProductDefinition.Name.CountryLanguage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CountryLanguage") {
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
      element("country", CodeableConcept.serializer().descriptor, isOptional = true)
      element("jurisdiction", CodeableConcept.serializer().descriptor, isOptional = true)
      element("language", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Name.CountryLanguage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.CountryLanguage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Name.CountryLanguage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var country: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          country =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          language =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CountryLanguage: " + i)
      }
    }
    return MedicinalProductDefinition.Name.CountryLanguage(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.country)
    (value.jurisdiction)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.language)
  }
}

internal object MedicinalProductDefinitionCrossReferenceSerializer :
  KSerializer<MedicinalProductDefinition.CrossReference> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CrossReference") {
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
      element("product", CodeableReference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.CrossReference>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.CrossReference =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.CrossReference) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.CrossReference {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var product: CodeableReference? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          product =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CrossReference: " + i)
      }
    }
    return MedicinalProductDefinition.CrossReference(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.CrossReference,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.product)
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
  }
}

internal object MedicinalProductDefinitionOperationSerializer :
  KSerializer<MedicinalProductDefinition.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
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
      element("type", CodeableReference.serializer().descriptor, isOptional = true)
      element("effectiveDate", Period.serializer().descriptor, isOptional = true)
      element(
        "organization",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "confidentialityIndicator",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicinalProductDefinition.Operation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableReference? = null
    var effectiveDate: Period? = null
    var organization: List<Reference>? = null
    var confidentialityIndicator: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          effectiveDate =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        5 ->
          organization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        6 ->
          confidentialityIndicator =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return MedicinalProductDefinition.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      effectiveDate = effectiveDate,
      organization = organization ?: listOf(),
      confidentialityIndicator = confidentialityIndicator,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Operation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, it)
    }
    (value.effectiveDate)?.let {
      encoder.encodeSerializableElement(descriptor, 4, PeriodSerializer, it)
    }
    if (value.organization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        ReferenceSerializer.listSerializer,
        value.organization,
      )
    (value.confidentialityIndicator)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
  }
}

internal object MedicinalProductDefinitionCharacteristicSerializer :
  KSerializer<MedicinalProductDefinition.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductDefinition.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Characteristic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Characteristic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        6 -> valueDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    return MedicinalProductDefinition.Characteristic(
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
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Characteristic,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      null -> {}
      is MedicinalProductDefinition.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
      }
      is MedicinalProductDefinition.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
      }
      is MedicinalProductDefinition.Characteristic.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
      }
    }
  }
}

internal object MedicinalProductDefinitionSerializer : KSerializer<MedicinalProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductDefinition") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "combinedPharmaceuticalDoseForm",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element(
      "route",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("indication", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_indication", Element.serializer().descriptor, isOptional = true)
    b.element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "additionalMonitoringIndicator",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element(
      "specialMeasures",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("pediatricUseIndicator", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "classification",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "marketingStatus",
      listSerialDescriptor(MarketingStatus.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "packagedMedicinalProduct",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "ingredient",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "impurity",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "attachedDocument",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "masterFile",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "contact",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductDefinition.Contact.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "clinicalTrial",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element(
      "name",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductDefinition.Name.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "crossReference",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductDefinition.CrossReference.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "operation",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductDefinition.Operation.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductDefinition.Characteristic.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
      statusDate = DateTime.of(statusDate?.let { FhirDateTime.fromString(it) }, _statusDate),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductDefinition,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.domain)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    (value.status)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ElementSerializer, it)
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, ElementSerializer, it)
    }
    (value.combinedPharmaceuticalDoseForm)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.route.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.route,
      )
    ((value.indication?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.indication?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.additionalMonitoringIndicator)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.specialMeasures.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialMeasures,
      )
    (value.pediatricUseIndicator)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
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

internal object MedicinalProductDefinitionPolymorphicSerializer :
  KSerializer<MedicinalProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductDefinition") {
      MedicinalProductDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition =
    decoder.decodeStructure(descriptor) {
      MedicinalProductDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
