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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MarketingStatus
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object MedicinalProductNameSerializer : KSerializer<MedicinalProduct.Name> {
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
      element(
        "namePart",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProduct.Name.NamePart.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "countryLanguage",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProduct.Name.CountryLanguage.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProduct.Name {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var namePart: List<MedicinalProduct.Name.NamePart>? = null
    var countryLanguage: List<MedicinalProduct.Name.CountryLanguage>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> productName = decoder.decodeStringElement(__desc, 3)
        4 ->
          _productName =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.productNameSer, null)
        5 ->
          namePart = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.namePartSer, null)
        6 ->
          countryLanguage =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.countryLanguageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
      }
    }
    return MedicinalProduct.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productName = R4String.of(productName, _productName)!!,
      namePart = namePart ?: listOf(),
      countryLanguage = countryLanguage ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProduct.Name) {
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
    if (value.namePart.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.namePartSer, value.namePart)
    if (value.countryLanguage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        6,
        Hoisted.countryLanguageSer,
        value.countryLanguage,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productNameSer: KSerializer<Element> = Element.serializer()

    public val namePartSerInner: KSerializer<MedicinalProduct.Name.NamePart> =
      MedicinalProduct.Name.NamePart.serializer()

    public val namePartSer: KSerializer<List<MedicinalProduct.Name.NamePart>> =
      ListSerializer(Hoisted.namePartSerInner)

    public val countryLanguageSerInner: KSerializer<MedicinalProduct.Name.CountryLanguage> =
      MedicinalProduct.Name.CountryLanguage.serializer()

    public val countryLanguageSer: KSerializer<List<MedicinalProduct.Name.CountryLanguage>> =
      ListSerializer(Hoisted.countryLanguageSerInner)
  }
}

internal object MedicinalProductNameNamePartSerializer :
  KSerializer<MedicinalProduct.Name.NamePart> {
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
      element("type", Coding.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.NamePart =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.NamePart) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProduct.Name.NamePart {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: KotlinString? = null
    var _part: Element? = null
    var type: Coding? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> part = decoder.decodeStringElement(__desc, 3)
        4 -> _part = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.partSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NamePart: " + __i)
      }
    }
    return MedicinalProduct.Name.NamePart(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      part = R4String.of(part, _part)!!,
      type = type!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProduct.Name.NamePart) {
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

    public val typeSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object MedicinalProductNameCountryLanguageSerializer :
  KSerializer<MedicinalProduct.Name.CountryLanguage> {
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

  override fun deserialize(decoder: Decoder): MedicinalProduct.Name.CountryLanguage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.Name.CountryLanguage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProduct.Name.CountryLanguage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var country: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    var language: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          country = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.countrySer, null)
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.countrySer, null)
        5 ->
          language = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.countrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CountryLanguage: " + __i)
      }
    }
    return MedicinalProduct.Name.CountryLanguage(
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
    `value`: MedicinalProduct.Name.CountryLanguage,
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

internal object MedicinalProductManufacturingBusinessOperationSerializer :
  KSerializer<MedicinalProduct.ManufacturingBusinessOperation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ManufacturingBusinessOperation") {
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
      element("operationType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("authorisationReferenceNumber", Identifier.serializer().descriptor, isOptional = true)
      element("effectiveDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveDate", Element.serializer().descriptor, isOptional = true)
      element(
        "confidentialityIndicator",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("regulator", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProduct.ManufacturingBusinessOperation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProduct.ManufacturingBusinessOperation,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProduct.ManufacturingBusinessOperation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          operationType =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationTypeSer, null)
        4 ->
          authorisationReferenceNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.authorisationReferenceNumberSer,
              null,
            )
        5 -> effectiveDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _effectiveDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.effectiveDateSer, null)
        7 ->
          confidentialityIndicator =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.operationTypeSer, null)
        8 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.manufacturerSer, null)
        9 ->
          regulator =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.manufacturerSerInner, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding ManufacturingBusinessOperation: " + __i
          )
      }
    }
    return MedicinalProduct.ManufacturingBusinessOperation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operationType = operationType,
      authorisationReferenceNumber = authorisationReferenceNumber,
      effectiveDate = DateTime.of(FhirDateTime.fromString(effectiveDate), _effectiveDate),
      confidentialityIndicator = confidentialityIndicator,
      manufacturer = manufacturer ?: listOf(),
      regulator = regulator,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProduct.ManufacturingBusinessOperation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operationType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationTypeSer, it)
    }
    (value.authorisationReferenceNumber)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.authorisationReferenceNumberSer, it)
    }
    ((value.effectiveDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.effectiveDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.effectiveDateSer, it)
    }
    (value.confidentialityIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.operationTypeSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.manufacturerSer, value.manufacturer)
    (value.regulator)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.manufacturerSerInner, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val authorisationReferenceNumberSer: KSerializer<Identifier> = Identifier.serializer()

    public val effectiveDateSer: KSerializer<Element> = Element.serializer()

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)
  }
}

internal object MedicinalProductSpecialDesignationSerializer :
  KSerializer<MedicinalProduct.SpecialDesignation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecialDesignation") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("intendedUse", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "indicationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("indicationReference", Reference.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("species", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProduct.SpecialDesignation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct.SpecialDesignation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProduct.SpecialDesignation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 ->
          intendedUse = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 ->
          indicationCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 ->
          indicationReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.indicationReferenceSer,
              null,
            )
        8 -> status = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        9 -> date = decoder.decodeStringElement(__desc, 9)
        10 -> _date = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.dateSer, null)
        11 -> species = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SpecialDesignation: " + __i)
      }
    }
    return MedicinalProduct.SpecialDesignation(
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
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      species = species,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProduct.SpecialDesignation,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.intendedUse)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    when (val __d = value.indication) {
      null -> {}
      is MedicinalProduct.SpecialDesignation.Indication.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, __d.value)
      }
      is MedicinalProduct.SpecialDesignation.Indication.Reference -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.indicationReferenceSer, __d.value)
      }
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.dateSer, it)
    }
    (value.species)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val indicationReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MedicinalProductSerializer : KSerializer<MedicinalProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProduct") {
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
    b.element("domain", Coding.serializer().descriptor, isOptional = true)
    b.element(
      "combinedPharmaceuticalDoseForm",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "additionalMonitoringIndicator",
      CodeableConcept.serializer().descriptor,
      isOptional = true,
    )
    b.element(
      "specialMeasures",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_specialMeasures",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("paediatricUseIndicator", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "productClassification",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "marketingStatus",
      listSerialDescriptor(MarketingStatus.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "pharmaceuticalProduct",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "packagedMedicinalProduct",
      listSerialDescriptor(Reference.serializer().descriptor),
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
    b.element("contact", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "clinicalTrial",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "name",
      listSerialDescriptor(lazyDescriptor { MedicinalProduct.Name.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "crossReference",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "manufacturingBusinessOperation",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProduct.ManufacturingBusinessOperation.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "specialDesignation",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProduct.SpecialDesignation.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProduct")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProduct {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> type = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeSer, null)
        13 ->
          domain = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.domainSer, null)
        14 ->
          combinedPharmaceuticalDoseForm =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 ->
          additionalMonitoringIndicator =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 ->
          specialMeasures =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.specialMeasuresSer, null)
        18 ->
          _specialMeasures =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.specialMeasuresSer2, null)
        19 ->
          paediatricUseIndicator =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.typeSer, null)
        20 ->
          productClassification =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.productClassificationSer,
              null,
            )
        21 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.marketingStatusSer, null)
        22 ->
          pharmaceuticalProduct =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        23 ->
          packagedMedicinalProduct =
            decoder.decodeNullableSerializableElement(
              __desc,
              23,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        24 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(
              __desc,
              24,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        25 ->
          masterFile =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(
              __desc,
              26,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        27 ->
          clinicalTrial =
            decoder.decodeNullableSerializableElement(
              __desc,
              27,
              Hoisted.pharmaceuticalProductSer,
              null,
            )
        28 -> name = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.nameSer, null)
        29 ->
          crossReference =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.identifierSer, null)
        30 ->
          manufacturingBusinessOperation =
            decoder.decodeNullableSerializableElement(
              __desc,
              30,
              Hoisted.manufacturingBusinessOperationSer,
              null,
            )
        31 ->
          specialDesignation =
            decoder.decodeNullableSerializableElement(
              __desc,
              31,
              Hoisted.specialDesignationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MedicinalProduct: " + __i)
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
          __i ->
          R4String.of(
            specialMeasures?.getOrNull(__i)?.let { it },
            _specialMeasures?.getOrNull(__i),
          )!!
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProduct) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.typeSer, it) }
    (value.domain)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.domainSer, it) }
    (value.combinedPharmaceuticalDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it)
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it)
    }
    (value.additionalMonitoringIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it)
    }
    (value.specialMeasures.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.specialMeasuresSer, it)
    }
    (value.specialMeasures.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.specialMeasuresSer2, it)
    }
    (value.paediatricUseIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.typeSer, it)
    }
    if (value.productClassification.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20,
        Hoisted.productClassificationSer,
        value.productClassification,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.pharmaceuticalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.pharmaceuticalProductSer,
        value.pharmaceuticalProduct,
      )
    if (value.packagedMedicinalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.pharmaceuticalProductSer,
        value.packagedMedicinalProduct,
      )
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        24,
        Hoisted.pharmaceuticalProductSer,
        value.attachedDocument,
      )
    if (value.masterFile.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25,
        Hoisted.pharmaceuticalProductSer,
        value.masterFile,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.pharmaceuticalProductSer, value.contact)
    if (value.clinicalTrial.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        27,
        Hoisted.pharmaceuticalProductSer,
        value.clinicalTrial,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.nameSer, value.name)
    if (value.crossReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.identifierSer, value.crossReference)
    if (value.manufacturingBusinessOperation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30,
        Hoisted.manufacturingBusinessOperationSer,
        value.manufacturingBusinessOperation,
      )
    if (value.specialDesignation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31,
        Hoisted.specialDesignationSer,
        value.specialDesignation,
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

    public val domainSer: KSerializer<Coding> = Coding.serializer()

    public val specialMeasuresSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val specialMeasuresSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.specialMeasuresSerInner).nullable)

    public val specialMeasuresSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val productClassificationSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)

    public val marketingStatusSerInner: KSerializer<MarketingStatus> = MarketingStatus.serializer()

    public val marketingStatusSer: KSerializer<List<MarketingStatus>> =
      ListSerializer(Hoisted.marketingStatusSerInner)

    public val pharmaceuticalProductSerInner: KSerializer<Reference> = Reference.serializer()

    public val pharmaceuticalProductSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.pharmaceuticalProductSerInner)

    public val nameSerInner: KSerializer<MedicinalProduct.Name> = MedicinalProduct.Name.serializer()

    public val nameSer: KSerializer<List<MedicinalProduct.Name>> =
      ListSerializer(Hoisted.nameSerInner)

    public val manufacturingBusinessOperationSerInner:
      KSerializer<MedicinalProduct.ManufacturingBusinessOperation> =
      MedicinalProduct.ManufacturingBusinessOperation.serializer()

    public val manufacturingBusinessOperationSer:
      KSerializer<List<MedicinalProduct.ManufacturingBusinessOperation>> =
      ListSerializer(Hoisted.manufacturingBusinessOperationSerInner)

    public val specialDesignationSerInner: KSerializer<MedicinalProduct.SpecialDesignation> =
      MedicinalProduct.SpecialDesignation.serializer()

    public val specialDesignationSer: KSerializer<List<MedicinalProduct.SpecialDesignation>> =
      ListSerializer(Hoisted.specialDesignationSerInner)
  }
}

internal object MedicinalProductPolymorphicSerializer : KSerializer<MedicinalProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProduct") {
      MedicinalProductSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProduct) {
    encoder.encodeStructure(descriptor) { MedicinalProductSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): MedicinalProduct =
    decoder.decodeStructure(descriptor) { MedicinalProductSerializer.deserializeJson(this) }
}
