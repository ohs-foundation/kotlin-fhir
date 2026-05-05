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
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Contact =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Contact) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Contact {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var contact: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contact: " + __i)
      }
    }
    return MedicinalProductDefinition.Contact(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      contact = contact!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Contact,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.contact)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.contactSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val contactSer: KSerializer<Reference> = Reference.serializer()
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Name {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var type: CodeableConcept? = null
    var namePart: List<MedicinalProductDefinition.Name.NamePart>? = null
    var countryLanguage: List<MedicinalProductDefinition.Name.CountryLanguage>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> productName = decoder.decodeStringElement(__desc, __i)
        4 ->
          _productName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productNameSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          namePart =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.namePartSer, null)
        7 ->
          countryLanguage =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countryLanguageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
      }
    }
    return MedicinalProductDefinition.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productName = R4bString.of(productName, _productName)!!,
      type = type,
      namePart = namePart ?: listOf(),
      countryLanguage = countryLanguage ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductDefinition.Name) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.productName.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.productName.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.productNameSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    if (value.namePart.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.namePartSer, value.namePart)
    if (value.countryLanguage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.countryLanguageSer,
        value.countryLanguage,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productNameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val namePartSerInner: KSerializer<MedicinalProductDefinition.Name.NamePart> =
      MedicinalProductDefinition.Name.NamePart.serializer()

    public val namePartSer: KSerializer<List<MedicinalProductDefinition.Name.NamePart>> =
      ListSerializer(Hoisted.namePartSerInner)

    public val countryLanguageSerInner:
      KSerializer<MedicinalProductDefinition.Name.CountryLanguage> =
      MedicinalProductDefinition.Name.CountryLanguage.serializer()

    public val countryLanguageSer:
      KSerializer<List<MedicinalProductDefinition.Name.CountryLanguage>> =
      ListSerializer(Hoisted.countryLanguageSerInner)
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.NamePart =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.NamePart) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Name.NamePart {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: KotlinString? = null
    var _part: Element? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> part = decoder.decodeStringElement(__desc, __i)
        4 -> _part = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NamePart: " + __i)
      }
    }
    return MedicinalProductDefinition.Name.NamePart(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      part = R4bString.of(part, _part)!!,
      type = type!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name.NamePart,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.part.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.part.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.partSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val partSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.CountryLanguage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Name.CountryLanguage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var country: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          country = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countrySer, null)
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countrySer, null)
        5 ->
          language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CountryLanguage: " + __i)
      }
    }
    return MedicinalProductDefinition.Name.CountryLanguage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      country = country!!,
      jurisdiction = jurisdiction,
      language = language!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name.CountryLanguage,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.country)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.countrySer, it) }
    (value.jurisdiction)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.countrySer, it)
    }
    (value.language)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.countrySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val countrySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.CrossReference =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.CrossReference) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.CrossReference {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var product: CodeableReference? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          product = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CrossReference: " + __i)
      }
    }
    return MedicinalProductDefinition.CrossReference(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      product = product!!,
      type = type,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.CrossReference,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.product)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.productSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Operation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Operation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Operation {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableReference? = null
    var effectiveDate: Period? = null
    var organization: List<Reference>? = null
    var confidentialityIndicator: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          effectiveDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveDateSer, null)
        5 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.organizationSer, null)
        6 ->
          confidentialityIndicator =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.confidentialityIndicatorSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Operation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.effectiveDate)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.effectiveDateSer, it)
    }
    if (value.organization.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.organizationSer, value.organization)
    (value.confidentialityIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.confidentialityIndicatorSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val effectiveDateSer: KSerializer<Period> = Period.serializer()

    public val organizationSerInner: KSerializer<Reference> = Reference.serializer()

    public val organizationSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.organizationSerInner)

    public val confidentialityIndicatorSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Characteristic {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, __i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return MedicinalProductDefinition.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        MedicinalProductDefinition.Characteristic.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Characteristic,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is MedicinalProductDefinition.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is MedicinalProductDefinition.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicinalProductDefinition.Characteristic.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueDateSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): MedicinalProductDefinition {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        12 -> domain = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        16 -> statusDate = decoder.decodeStringElement(__desc, __i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 -> description = decoder.decodeStringElement(__desc, __i)
        19 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        20 ->
          combinedPharmaceuticalDoseForm =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        21 -> route = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.routeSer, null)
        22 -> indication = decoder.decodeStringElement(__desc, __i)
        23 ->
          _indication =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        25 ->
          additionalMonitoringIndicator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        26 ->
          specialMeasures =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.routeSer, null)
        27 ->
          pediatricUseIndicator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        28 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.routeSer, null)
        29 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.marketingStatusSer, null)
        30 ->
          packagedMedicinalProduct =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.routeSer, null)
        31 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.routeSer, null)
        32 ->
          impurity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.impuritySer, null)
        33 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.attachedDocumentSer,
              null,
            )
        34 ->
          masterFile =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.attachedDocumentSer,
              null,
            )
        35 ->
          contact = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contactSer, null)
        36 ->
          clinicalTrial =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.attachedDocumentSer,
              null,
            )
        37 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        38 -> name = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nameSer, null)
        39 ->
          crossReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.crossReferenceSer, null)
        40 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.operationSer, null)
        41 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.characteristicSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductDefinition: " + __i
          )
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
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: MedicinalProductDefinition,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.typeSer, it) }
    (value.domain)?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.typeSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.status)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.typeSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 16 + __off, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 18 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.combinedPharmaceuticalDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.typeSer, it)
    }
    if (value.route.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.routeSer, value.route)
    ((value.indication?.value))?.let { encoder.encodeStringElement(__desc, 22 + __off, it) }
    (value.indication?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.typeSer, it)
    }
    (value.additionalMonitoringIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.typeSer, it)
    }
    if (value.specialMeasures.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.routeSer, value.specialMeasures)
    (value.pediatricUseIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.typeSer, it)
    }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.routeSer, value.classification)
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.packagedMedicinalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30 + __off,
        Hoisted.routeSer,
        value.packagedMedicinalProduct,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.routeSer, value.ingredient)
    if (value.impurity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.impuritySer, value.impurity)
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        33 + __off,
        Hoisted.attachedDocumentSer,
        value.attachedDocument,
      )
    if (value.masterFile.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        34 + __off,
        Hoisted.attachedDocumentSer,
        value.masterFile,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.contactSer, value.contact)
    if (value.clinicalTrial.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        36 + __off,
        Hoisted.attachedDocumentSer,
        value.clinicalTrial,
      )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.codeSer, value.code)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.nameSer, value.name)
    if (value.crossReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        39 + __off,
        Hoisted.crossReferenceSer,
        value.crossReference,
      )
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.operationSer, value.operation)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        41 + __off,
        Hoisted.characteristicSer,
        value.characteristic,
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val routeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val marketingStatusSerInner: KSerializer<MarketingStatus> = MarketingStatus.serializer()

    public val marketingStatusSer: KSerializer<List<MarketingStatus>> =
      ListSerializer(Hoisted.marketingStatusSerInner)

    public val impuritySerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val impuritySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.impuritySerInner)

    public val attachedDocumentSerInner: KSerializer<Reference> = Reference.serializer()

    public val attachedDocumentSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.attachedDocumentSerInner)

    public val contactSerInner: KSerializer<MedicinalProductDefinition.Contact> =
      MedicinalProductDefinition.Contact.serializer()

    public val contactSer: KSerializer<List<MedicinalProductDefinition.Contact>> =
      ListSerializer(Hoisted.contactSerInner)

    public val codeSerInner: KSerializer<Coding> = Coding.serializer()

    public val codeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codeSerInner)

    public val nameSerInner: KSerializer<MedicinalProductDefinition.Name> =
      MedicinalProductDefinition.Name.serializer()

    public val nameSer: KSerializer<List<MedicinalProductDefinition.Name>> =
      ListSerializer(Hoisted.nameSerInner)

    public val crossReferenceSerInner: KSerializer<MedicinalProductDefinition.CrossReference> =
      MedicinalProductDefinition.CrossReference.serializer()

    public val crossReferenceSer: KSerializer<List<MedicinalProductDefinition.CrossReference>> =
      ListSerializer(Hoisted.crossReferenceSerInner)

    public val operationSerInner: KSerializer<MedicinalProductDefinition.Operation> =
      MedicinalProductDefinition.Operation.serializer()

    public val operationSer: KSerializer<List<MedicinalProductDefinition.Operation>> =
      ListSerializer(Hoisted.operationSerInner)

    public val characteristicSerInner: KSerializer<MedicinalProductDefinition.Characteristic> =
      MedicinalProductDefinition.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<MedicinalProductDefinition.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)
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
      MedicinalProductDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition =
    decoder.decodeStructure(descriptor) {
      MedicinalProductDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
