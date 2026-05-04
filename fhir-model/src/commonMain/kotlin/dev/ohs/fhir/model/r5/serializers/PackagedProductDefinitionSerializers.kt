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
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PackagedProductDefinition
import dev.ohs.fhir.model.r5.ProductShelfLife
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          jurisdiction = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
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

internal object PackagedProductDefinitionPackagingSerializer :
  KSerializer<PackagedProductDefinition.Packaging> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Packaging") {
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
      element("componentPart", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_componentPart", Element.serializer().descriptor, isOptional = true)
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
        listSerialDescriptor(ProductShelfLife.serializer().descriptor),
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
          lazyDescriptor { PackagedProductDefinition.Packaging.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "containedItem",
        listSerialDescriptor(
          lazyDescriptor {
            PackagedProductDefinition.Packaging.ContainedItem.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "packaging",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.Packaging.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Packaging =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Packaging) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PackagedProductDefinition.Packaging {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var componentPart: KotlinBoolean? = null
    var _componentPart: Element? = null
    var quantity: Int? = null
    var _quantity: Element? = null
    var material: List<CodeableConcept>? = null
    var alternateMaterial: List<CodeableConcept>? = null
    var shelfLifeStorage: List<ProductShelfLife>? = null
    var manufacturer: List<Reference>? = null
    var `property`: List<PackagedProductDefinition.Packaging.Property>? = null
    var containedItem: List<PackagedProductDefinition.Packaging.ContainedItem>? = null
    var packaging: List<PackagedProductDefinition.Packaging>? = null
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
        5 -> componentPart = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _componentPart =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.componentPartSer, null)
        7 -> quantity = decoder.decodeIntElement(__desc, 7)
        8 ->
          _quantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.componentPartSer, null)
        9 ->
          material = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.materialSer, null)
        10 ->
          alternateMaterial =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.materialSer, null)
        11 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.shelfLifeStorageSer, null)
        12 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.manufacturerSer, null)
        13 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.propertySer, null)
        14 ->
          containedItem =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.containedItemSer, null)
        15 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.packagingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + __i)
      }
    }
    return PackagedProductDefinition.Packaging(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type,
      componentPart = R5Boolean.of(componentPart, _componentPart),
      quantity = Integer.of(quantity, _quantity),
      material = material ?: listOf(),
      alternateMaterial = alternateMaterial ?: listOf(),
      shelfLifeStorage = shelfLifeStorage ?: listOf(),
      manufacturer = manufacturer ?: listOf(),
      `property` = `property` ?: listOf(),
      containedItem = containedItem ?: listOf(),
      packaging = packaging ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging,
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
    ((value.componentPart?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.componentPart?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.componentPartSer, it)
    }
    ((value.quantity?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.quantity?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.componentPartSer, it)
    }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.materialSer, value.material)
    if (value.alternateMaterial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.materialSer, value.alternateMaterial)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        11,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.manufacturerSer, value.manufacturer)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.propertySer, value.`property`)
    if (value.containedItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.containedItemSer, value.containedItem)
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.packagingSer, value.packaging)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val componentPartSer: KSerializer<Element> = Element.serializer()

    public val materialSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val shelfLifeStorageSerInner: KSerializer<ProductShelfLife> =
      ProductShelfLife.serializer()

    public val shelfLifeStorageSer: KSerializer<List<ProductShelfLife>> =
      ListSerializer(Hoisted.shelfLifeStorageSerInner)

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val propertySerInner: KSerializer<PackagedProductDefinition.Packaging.Property> =
      PackagedProductDefinition.Packaging.Property.serializer()

    public val propertySer: KSerializer<List<PackagedProductDefinition.Packaging.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val containedItemSerInner:
      KSerializer<PackagedProductDefinition.Packaging.ContainedItem> =
      PackagedProductDefinition.Packaging.ContainedItem.serializer()

    public val containedItemSer:
      KSerializer<List<PackagedProductDefinition.Packaging.ContainedItem>> =
      ListSerializer(Hoisted.containedItemSerInner)

    public val packagingSerInner: KSerializer<PackagedProductDefinition.Packaging> =
      PackagedProductDefinition.Packaging.serializer()

    public val packagingSer: KSerializer<List<PackagedProductDefinition.Packaging>> =
      ListSerializer(Hoisted.packagingSerInner)
  }
}

internal object PackagedProductDefinitionPackagingPropertySerializer :
  KSerializer<PackagedProductDefinition.Packaging.Property> {
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

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Packaging.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Packaging.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Packaging.Property {
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
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, 8)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return PackagedProductDefinition.Packaging.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        PackagedProductDefinition.Packaging.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging.Property,
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
      is PackagedProductDefinition.Packaging.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is PackagedProductDefinition.Packaging.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is PackagedProductDefinition.Packaging.Property.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Packaging.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Packaging.Property.Value.Attachment -> {
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

internal object PackagedProductDefinitionPackagingContainedItemSerializer :
  KSerializer<PackagedProductDefinition.Packaging.ContainedItem> {
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

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Packaging.ContainedItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Packaging.ContainedItem,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Packaging.ContainedItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.itemSer, null)
        4 -> amount = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContainedItem: " + __i)
      }
    }
    return PackagedProductDefinition.Packaging.ContainedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item!!,
      amount = amount,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging.ContainedItem,
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "packageFor",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("statusDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_statusDate", Element.serializer().descriptor, isOptional = true)
      element(
        "containedItemQuantity",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "legalStatusOfSupply",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.LegalStatusOfSupply.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "marketingStatus",
        listSerialDescriptor(MarketingStatus.serializer().descriptor),
        isOptional = true,
      )
      element("copackagedIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_copackagedIndicator", Element.serializer().descriptor, isOptional = true)
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "attachedDocument",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "packaging",
        lazyDescriptor { PackagedProductDefinition.Packaging.serializer().descriptor },
        isOptional = true,
      )
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinition.Packaging.Property.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): PackagedProductDefinition {
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
    var copackagedIndicator: KotlinBoolean? = null
    var _copackagedIndicator: Element? = null
    var manufacturer: List<Reference>? = null
    var attachedDocument: List<Reference>? = null
    var packaging: PackagedProductDefinition.Packaging? = null
    var characteristic: List<PackagedProductDefinition.Packaging.Property>? = null
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
        12 -> name = decoder.decodeStringElement(__desc, 12)
        13 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 ->
          packageFor =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.packageForSer, null)
        16 -> status = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 -> statusDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          containedItemQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.containedItemQuantitySer,
              null,
            )
        20 -> description = decoder.decodeStringElement(__desc, 20)
        21 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.legalStatusOfSupplySer,
              null,
            )
        23 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.marketingStatusSer, null)
        24 -> copackagedIndicator = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _copackagedIndicator =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.packageForSer, null)
        27 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.packageForSer, null)
        28 ->
          packaging =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.packagingSer, null)
        29 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.characteristicSer, null)
        CompositeDecoder.DECODE_DONE -> break
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
      name = R5String.of(name, _name),
      type = type,
      packageFor = packageFor ?: listOf(),
      status = status,
      statusDate = DateTime.of(FhirDateTime.fromString(statusDate), _statusDate),
      containedItemQuantity = containedItemQuantity ?: listOf(),
      description = Markdown.of(description, _description),
      legalStatusOfSupply = legalStatusOfSupply ?: listOf(),
      marketingStatus = marketingStatus ?: listOf(),
      copackagedIndicator = R5Boolean.of(copackagedIndicator, _copackagedIndicator),
      manufacturer = manufacturer ?: listOf(),
      attachedDocument = attachedDocument ?: listOf(),
      packaging = packaging,
      characteristic = characteristic ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PackagedProductDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "PackagedProductDefinition")
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it) }
    if (value.packageFor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.packageForSer, value.packageFor)
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    ((value.statusDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    if (value.containedItemQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.containedItemQuantitySer,
        value.containedItemQuantity,
      )
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    if (value.legalStatusOfSupply.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22,
        Hoisted.legalStatusOfSupplySer,
        value.legalStatusOfSupply,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    ((value.copackagedIndicator?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.copackagedIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.packageForSer, value.manufacturer)
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.packageForSer, value.attachedDocument)
    (value.packaging)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.packagingSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.characteristicSer, value.characteristic)
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

    public val packagingSer: KSerializer<PackagedProductDefinition.Packaging> =
      PackagedProductDefinition.Packaging.serializer()

    public val characteristicSerInner: KSerializer<PackagedProductDefinition.Packaging.Property> =
      PackagedProductDefinition.Packaging.Property.serializer()

    public val characteristicSer: KSerializer<List<PackagedProductDefinition.Packaging.Property>> =
      ListSerializer(Hoisted.characteristicSerInner)
  }
}
