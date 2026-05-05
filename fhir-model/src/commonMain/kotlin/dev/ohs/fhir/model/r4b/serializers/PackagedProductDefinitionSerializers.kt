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
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.MarketingStatus
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PackagedProductDefinition
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

internal object PackagedProductDefinitionLegalStatusOfSupplySerializer :
  KSerializer<PackagedProductDefinition.LegalStatusOfSupply> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("LegalStatusOfSupply") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("jurisdiction", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.LegalStatusOfSupply =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.LegalStatusOfSupply) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.LegalStatusOfSupply {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding LegalStatusOfSupply: " + __i)
      }
    }
    return PackagedProductDefinition.LegalStatusOfSupply(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      jurisdiction = jurisdiction,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.LegalStatusOfSupply,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.jurisdiction)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PackagedProductDefinitionPackageSerializer :
  KSerializer<PackagedProductDefinition.Package> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Package") {
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
      element("quantity", Int.serializer().descriptor, isOptional = true)
      element("_quantity", Element.serializer().descriptor, isOptional = true)
      element(
        "material",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "alternateMaterial",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "shelfLifeStorage",
        listSerialDescriptor(
          lazyDescriptor {
            PackagedProductDefinition.Package.ShelfLifeStorage.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "property",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.Package.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "containedItem",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.Package.ContainedItem.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "package",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.Package.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PackagedProductDefinition.Package {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var material: List<CodeableConcept>? = null
    var alternateMaterial: List<CodeableConcept>? = null
    var shelfLifeStorage: List<PackagedProductDefinition.Package.ShelfLifeStorage>? = null
    var manufacturer: List<Reference>? = null
    var `property`: List<PackagedProductDefinition.Package.Property>? = null
    var containedItem: List<PackagedProductDefinition.Package.ContainedItem>? = null
    var `package`: List<PackagedProductDefinition.Package>? = null
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
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> quantity = decoder.decodeIntElement(__desc, __i)
        6 ->
          _quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        7 ->
          material =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
        8 ->
          alternateMaterial =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.materialSer, null)
        9 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.shelfLifeStorageSer,
              null,
            )
        10 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manufacturerSer, null)
        11 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        12 ->
          containedItem =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedItemSer, null)
        13 ->
          `package` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Package: " + __i)
      }
    }
    return PackagedProductDefinition.Package(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type,
      quantity = Integer.of(quantity, _quantity),
      material = material ?: listOf(),
      alternateMaterial = alternateMaterial ?: listOf(),
      shelfLifeStorage = shelfLifeStorage ?: listOf(),
      manufacturer = manufacturer ?: listOf(),
      `property` = `property` ?: listOf(),
      containedItem = containedItem ?: listOf(),
      `package` = `package` ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PackagedProductDefinition.Package) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    ((value.quantity?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.quantity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.quantitySer, it)
    }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.materialSer, value.material)
    if (value.alternateMaterial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.materialSer, value.alternateMaterial)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.manufacturerSer, value.manufacturer)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.propertySer, value.`property`)
    if (value.containedItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.containedItemSer, value.containedItem)
    if (value.`package`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.packageSer, value.`package`)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Element> = Element.serializer()

    public val materialSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val shelfLifeStorageSerInner:
      KSerializer<PackagedProductDefinition.Package.ShelfLifeStorage> =
      PackagedProductDefinition.Package.ShelfLifeStorage.serializer()

    public val shelfLifeStorageSer:
      KSerializer<List<PackagedProductDefinition.Package.ShelfLifeStorage>> =
      ListSerializer(Hoisted.shelfLifeStorageSerInner)

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val propertySerInner: KSerializer<PackagedProductDefinition.Package.Property> =
      PackagedProductDefinition.Package.Property.serializer()

    public val propertySer: KSerializer<List<PackagedProductDefinition.Package.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val containedItemSerInner: KSerializer<PackagedProductDefinition.Package.ContainedItem> =
      PackagedProductDefinition.Package.ContainedItem.serializer()

    public val containedItemSer:
      KSerializer<List<PackagedProductDefinition.Package.ContainedItem>> =
      ListSerializer(Hoisted.containedItemSerInner)

    public val packageSerInner: KSerializer<PackagedProductDefinition.Package> =
      PackagedProductDefinition.Package.serializer()

    public val packageSer: KSerializer<List<PackagedProductDefinition.Package>> =
      ListSerializer(Hoisted.packageSerInner)
  }
}

internal object PackagedProductDefinitionPackageShelfLifeStorageSerializer :
  KSerializer<PackagedProductDefinition.Package.ShelfLifeStorage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ShelfLifeStorage") {
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
      element("periodDuration", Duration.serializer().descriptor, isOptional = true)
      element("periodString", KotlinString.serializer().descriptor, isOptional = true)
      element("_periodString", Element.serializer().descriptor, isOptional = true)
      element(
        "specialPrecautionsForStorage",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ShelfLifeStorage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Package.ShelfLifeStorage {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var periodDuration: Duration? = null
    var periodString: KotlinString? = null
    var _periodString: Element? = null
    var specialPrecautionsForStorage: List<CodeableConcept>? = null
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
          periodDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodDurationSer, null)
        5 -> periodString = decoder.decodeStringElement(__desc, __i)
        6 ->
          _periodString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodStringSer, null)
        7 ->
          specialPrecautionsForStorage =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.specialPrecautionsForStorageSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ShelfLifeStorage: " + __i)
      }
    }
    return PackagedProductDefinition.Package.ShelfLifeStorage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      period =
        PackagedProductDefinition.Package.ShelfLifeStorage.Period.from(
          periodDuration,
          R4bString.of(periodString, _periodString),
        ),
      specialPrecautionsForStorage = specialPrecautionsForStorage ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.period) {
      null -> {}
      is PackagedProductDefinition.Package.ShelfLifeStorage.Period.Duration -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.periodDurationSer, __d.value)
      }
      is PackagedProductDefinition.Package.ShelfLifeStorage.Period.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.periodStringSer, it)
        }
      }
    }
    if (value.specialPrecautionsForStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.specialPrecautionsForStorageSer,
        value.specialPrecautionsForStorage,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodDurationSer: KSerializer<Duration> = Duration.serializer()

    public val periodStringSer: KSerializer<Element> = Element.serializer()

    public val specialPrecautionsForStorageSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)
  }
}

internal object PackagedProductDefinitionPackagePropertySerializer :
  KSerializer<PackagedProductDefinition.Package.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
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

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Package.Property {
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
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return PackagedProductDefinition.Package.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        PackagedProductDefinition.Package.Property.Value.from(
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
    `value`: PackagedProductDefinition.Package.Property,
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
      is PackagedProductDefinition.Package.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is PackagedProductDefinition.Package.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is PackagedProductDefinition.Package.Property.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Package.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Package.Property.Value.Attachment -> {
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

internal object PackagedProductDefinitionPackageContainedItemSerializer :
  KSerializer<PackagedProductDefinition.Package.ContainedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContainedItem") {
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
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ContainedItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ContainedItem,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Package.ContainedItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContainedItem: " + __i)
      }
    }
    return PackagedProductDefinition.Package.ContainedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item!!,
      amount = amount,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Package.ContainedItem,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.itemSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object PackagedProductDefinitionSerializer : KSerializer<PackagedProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PackagedProductDefinition") {
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
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "packageFor",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_statusDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "containedItemQuantity",
      listSerialDescriptor(Quantity.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "legalStatusOfSupply",
      listSerialDescriptor(
        lazyDescriptor { PackagedProductDefinition.LegalStatusOfSupply.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "marketingStatus",
      listSerialDescriptor(MarketingStatus.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("copackagedIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_copackagedIndicator", Element.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "package",
      lazyDescriptor { PackagedProductDefinition.Package.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PackagedProductDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): PackagedProductDefinition {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var type: CodeableConcept? = null
    var packageFor: List<Reference>? = null
    var status: CodeableConcept? = null
    var statusDate: KotlinString? = null
    var _statusDate: Element? = null
    var containedItemQuantity: List<Quantity>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var legalStatusOfSupply: List<PackagedProductDefinition.LegalStatusOfSupply>? = null
    var marketingStatus: List<MarketingStatus>? = null
    var characteristic: List<CodeableConcept>? = null
    var copackagedIndicator: KotlinBoolean? = null
    var _copackagedIndicator: Element? = null
    var manufacturer: List<Reference>? = null
    var `package`: PackagedProductDefinition.Package? = null
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
        11 -> name = decoder.decodeStringElement(__desc, __i)
        12 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        14 ->
          packageFor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packageForSer, null)
        15 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        16 -> statusDate = decoder.decodeStringElement(__desc, __i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        18 ->
          containedItemQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.containedItemQuantitySer,
              null,
            )
        19 -> description = decoder.decodeStringElement(__desc, __i)
        20 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.legalStatusOfSupplySer,
              null,
            )
        22 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.marketingStatusSer, null)
        23 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.characteristicSer, null)
        24 -> copackagedIndicator = decoder.decodeBooleanElement(__desc, __i)
        25 ->
          _copackagedIndicator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        26 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packageForSer, null)
        27 ->
          `package` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.packageSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding PackagedProductDefinition: " + __i
          )
      }
    }
    return PackagedProductDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      name = R4bString.of(name, _name),
      type = type,
      packageFor = packageFor ?: listOf(),
      status = status,
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      containedItemQuantity = containedItemQuantity ?: listOf(),
      description = Markdown.of(description, _description),
      legalStatusOfSupply = legalStatusOfSupply ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      characteristic = characteristic ?: listOf(),
      copackagedIndicator = R4bBoolean.of(copackagedIndicator, _copackagedIndicator),
      manufacturer = manufacturer ?: listOf(),
      `package` = `package`,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: PackagedProductDefinition,
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.typeSer, it) }
    if (value.packageFor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.packageForSer, value.packageFor)
    (value.status)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.typeSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 16 + __off, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.containedItemQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        18 + __off,
        Hoisted.containedItemQuantitySer,
        value.containedItemQuantity,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.legalStatusOfSupply.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21 + __off,
        Hoisted.legalStatusOfSupplySer,
        value.legalStatusOfSupply,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22 + __off,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23 + __off,
        Hoisted.characteristicSer,
        value.characteristic,
      )
    ((value.copackagedIndicator?.value))?.let {
      encoder.encodeBooleanElement(__desc, 24 + __off, it)
    }
    (value.copackagedIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26 + __off,
        Hoisted.packageForSer,
        value.manufacturer,
      )
    (value.`package`)?.let {
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.packageSer, it)
    }
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

    public val packageForSerInner: KSerializer<Reference> = Reference.serializer()

    public val packageForSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.packageForSerInner)

    public val containedItemQuantitySerInner: KSerializer<Quantity> = Quantity.serializer()

    public val containedItemQuantitySer: KSerializer<List<Quantity>> =
      ListSerializer(Hoisted.containedItemQuantitySerInner)

    public val legalStatusOfSupplySerInner:
      KSerializer<PackagedProductDefinition.LegalStatusOfSupply> =
      PackagedProductDefinition.LegalStatusOfSupply.serializer()

    public val legalStatusOfSupplySer:
      KSerializer<List<PackagedProductDefinition.LegalStatusOfSupply>> =
      ListSerializer(Hoisted.legalStatusOfSupplySerInner)

    public val marketingStatusSerInner: KSerializer<MarketingStatus> = MarketingStatus.serializer()

    public val marketingStatusSer: KSerializer<List<MarketingStatus>> =
      ListSerializer(Hoisted.marketingStatusSerInner)

    public val characteristicSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)

    public val packageSer: KSerializer<PackagedProductDefinition.Package> =
      PackagedProductDefinition.Package.serializer()
  }
}

internal object PackagedProductDefinitionPolymorphicSerializer :
  KSerializer<PackagedProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PackagedProductDefinition") {
      PackagedProductDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    encoder.encodeStructure(descriptor) {
      PackagedProductDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    decoder.decodeStructure(descriptor) {
      PackagedProductDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
