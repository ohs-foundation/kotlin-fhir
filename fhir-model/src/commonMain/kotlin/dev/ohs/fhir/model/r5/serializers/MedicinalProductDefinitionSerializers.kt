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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.MarketingStatus
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.contactSer, null)
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
        "part",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Name.Part.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "usage",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Name.Usage.serializer().descriptor }
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
    var part: List<MedicinalProductDefinition.Name.Part>? = null
    var usage: List<MedicinalProductDefinition.Name.Usage>? = null
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
        5 -> type = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> part = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.partSer, null)
        7 -> usage = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.usageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
      }
    }
    return MedicinalProductDefinition.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productName = R5String.of(productName, _productName)!!,
      type = type,
      part = part ?: listOf(),
      usage = usage ?: listOf(),
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
    if (value.part.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.partSer, value.part)
    if (value.usage.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.usageSer, value.usage)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val productNameSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val partSerInner: KSerializer<MedicinalProductDefinition.Name.Part> =
      MedicinalProductDefinition.Name.Part.serializer()

    public val partSer: KSerializer<List<MedicinalProductDefinition.Name.Part>> =
      ListSerializer(Hoisted.partSerInner)

    public val usageSerInner: KSerializer<MedicinalProductDefinition.Name.Usage> =
      MedicinalProductDefinition.Name.Usage.serializer()

    public val usageSer: KSerializer<List<MedicinalProductDefinition.Name.Usage>> =
      ListSerializer(Hoisted.usageSerInner)
  }
}

internal object MedicinalProductDefinitionNamePartSerializer :
  KSerializer<MedicinalProductDefinition.Name.Part> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Part") {
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.Part =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.Part) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Name.Part {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var part: KotlinString? = null
    var _part: Element? = null
    var type: CodeableConcept? = null
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
        else -> throw SerializationException("Unexpected index decoding Part: " + __i)
      }
    }
    return MedicinalProductDefinition.Name.Part(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      part = R5String.of(part, _part)!!,
      type = type!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductDefinition.Name.Part,
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

internal object MedicinalProductDefinitionNameUsageSerializer :
  KSerializer<MedicinalProductDefinition.Name.Usage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Usage") {
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

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Name.Usage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition.Name.Usage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition.Name.Usage {
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
        else -> throw SerializationException("Unexpected index decoding Usage: " + __i)
      }
    }
    return MedicinalProductDefinition.Name.Usage(
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
    `value`: MedicinalProductDefinition.Name.Usage,
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          product = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.productSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          effectiveDate =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.effectiveDateSer, null)
        5 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.organizationSer, null)
        6 ->
          confidentialityIndicator =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
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
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
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
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueQuantity: Quantity? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> valueMarkdown = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueMarkdownSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueQuantitySer, null)
        8 -> valueInteger = decoder.decodeIntElement(__desc, 8)
        9 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueMarkdownSer, null)
        10 -> valueDate = decoder.decodeStringElement(__desc, 10)
        11 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueMarkdownSer, null)
        12 -> valueBoolean = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueMarkdownSer, null)
        14 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueAttachmentSer, null)
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
          Markdown.of(valueMarkdown, _valueMarkdown),
          valueQuantity,
          Integer.of(valueInteger, _valueInteger),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R5Boolean.of(valueBoolean, _valueBoolean),
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
      is MedicinalProductDefinition.Characteristic.Value.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueMarkdownSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueQuantitySer, __d.value)
      }
      is MedicinalProductDefinition.Characteristic.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueMarkdownSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueMarkdownSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueMarkdownSer, it)
        }
      }
      is MedicinalProductDefinition.Characteristic.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.valueAttachmentSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueMarkdownSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object MedicinalProductDefinitionCharacteristicValueSerializer :
  KSerializer<MedicinalProductDefinition.Characteristic.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductDefinition.Characteristic.Value") {
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueMarkdown", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueMarkdown", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductDefinition.Characteristic.Value,
  ) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is MedicinalProductDefinition.Characteristic.Value.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueCodeableConceptSer, __d.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Markdown -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
        is MedicinalProductDefinition.Characteristic.Value.Quantity -> {
          encodeSerializableElement(__desc, 3, Hoisted.valueQuantitySer, __d.value)
        }
        is MedicinalProductDefinition.Characteristic.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is MedicinalProductDefinition.Characteristic.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is MedicinalProductDefinition.Characteristic.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is MedicinalProductDefinition.Characteristic.Value.Attachment -> {
          encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition.Characteristic.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductDefinition.Characteristic.Value {
    val __desc = descriptor
    var valueCodeableConcept: CodeableConcept? = null
    var valueMarkdown: KotlinString? = null
    var _valueMarkdown: Element? = null
    var valueQuantity: Quantity? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        1 -> valueMarkdown = decoder.decodeStringElement(__desc, 1)
        2 ->
          _valueMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        3 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.valueQuantitySer, null)
        4 -> valueInteger = decoder.decodeIntElement(__desc, 4)
        5 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductDefinition.Characteristic.Value: " + __i
          )
      }
    }
    return MedicinalProductDefinition.Characteristic.Value.from(
      valueCodeableConcept,
      Markdown.of(valueMarkdown, _valueMarkdown),
      valueQuantity,
      Integer.of(valueInteger, _valueInteger),
      Date.of(FhirDate.fromString(valueDate), _valueDate),
      R5Boolean.of(valueBoolean, _valueBoolean),
      valueAttachment,
    )!!
  }

  private object Hoisted {
    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object MedicinalProductDefinitionSerializer : KSerializer<MedicinalProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductDefinition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("domain", CodeableConcept.serializer().descriptor, isOptional = true)
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "combinedPharmaceuticalDoseForm",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "route",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("indication", KotlinString.serializer().descriptor, isOptional = true)
      element("_indication", Element.serializer().descriptor, isOptional = true)
      element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "additionalMonitoringIndicator",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "specialMeasures",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("pediatricUseIndicator", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "classification",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "marketingStatus",
        listSerialDescriptor(MarketingStatus.serializer().descriptor),
        isOptional = true,
      )
      element(
        "packagedMedicinalProduct",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "comprisedOf",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "ingredient",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "impurity",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "attachedDocument",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "masterFile",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "contact",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Contact.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "clinicalTrial",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element(
        "name",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Name.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "crossReference",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.CrossReference.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "operation",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Operation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductDefinition.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductDefinition {
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
    var comprisedOf: List<Reference>? = null
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
        13 -> domain = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> status = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 -> statusDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 -> description = decoder.decodeStringElement(__desc, 19)
        20 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          combinedPharmaceuticalDoseForm =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.typeSer, null)
        22 -> route = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.routeSer, null)
        23 -> indication = decoder.decodeStringElement(__desc, 23)
        24 ->
          _indication =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.typeSer, null)
        26 ->
          additionalMonitoringIndicator =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.typeSer, null)
        27 ->
          specialMeasures =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.routeSer, null)
        28 ->
          pediatricUseIndicator =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.typeSer, null)
        29 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.routeSer, null)
        30 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.marketingStatusSer, null)
        31 ->
          packagedMedicinalProduct =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.routeSer, null)
        32 ->
          comprisedOf =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.comprisedOfSer, null)
        33 ->
          ingredient = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.routeSer, null)
        34 ->
          impurity =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.impuritySer, null)
        35 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.comprisedOfSer, null)
        36 ->
          masterFile =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.comprisedOfSer, null)
        37 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.contactSer, null)
        38 ->
          clinicalTrial =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.comprisedOfSer, null)
        39 -> code = decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.codeSer, null)
        40 -> name = decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.nameSer, null)
        41 ->
          crossReference =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.crossReferenceSer, null)
        42 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.operationSer, null)
        43 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.characteristicSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      version = R5String.of(version, _version),
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
      comprisedOf = comprisedOf ?: listOf(),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicinalProductDefinition")
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
    (value.domain)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it) }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    (value.combinedPharmaceuticalDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.typeSer, it)
    }
    if (value.route.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.routeSer, value.route)
    ((value.indication?.value))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.indication?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.typeSer, it)
    }
    (value.additionalMonitoringIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.typeSer, it)
    }
    if (value.specialMeasures.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.routeSer, value.specialMeasures)
    (value.pediatricUseIndicator)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.typeSer, it)
    }
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.routeSer, value.classification)
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.packagedMedicinalProduct.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31,
        Hoisted.routeSer,
        value.packagedMedicinalProduct,
      )
    if (value.comprisedOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.comprisedOfSer, value.comprisedOf)
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.routeSer, value.ingredient)
    if (value.impurity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.impuritySer, value.impurity)
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.comprisedOfSer, value.attachedDocument)
    if (value.masterFile.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.comprisedOfSer, value.masterFile)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.contactSer, value.contact)
    if (value.clinicalTrial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 38, Hoisted.comprisedOfSer, value.clinicalTrial)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 39, Hoisted.codeSer, value.code)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 40, Hoisted.nameSer, value.name)
    if (value.crossReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 41, Hoisted.crossReferenceSer, value.crossReference)
    if (value.operation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.operationSer, value.operation)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43, Hoisted.characteristicSer, value.characteristic)
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

    public val comprisedOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val comprisedOfSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.comprisedOfSerInner)

    public val impuritySerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val impuritySer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.impuritySerInner)

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
