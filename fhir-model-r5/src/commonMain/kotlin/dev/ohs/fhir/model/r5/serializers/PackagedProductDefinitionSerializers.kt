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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.LegalStatusOfSupply) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.LegalStatusOfSupply {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LegalStatusOfSupply: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.LegalStatusOfSupply,
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
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    (value.jurisdiction)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it)
    }
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Packaging) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PackagedProductDefinition.Packaging {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> componentPart = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _componentPart =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentPartSer, null)
        7 -> quantity = decoder.decodeIntElement(descriptor, i)
        8 ->
          _quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentPartSer, null)
        9 ->
          material =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialSer, null)
        10 ->
          alternateMaterial =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialSer, null)
        11 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.shelfLifeStorageSer,
              null,
            )
        12 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        13 ->
          `property` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.propertySer, null)
        14 ->
          containedItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedItemSer, null)
        15 ->
          packaging =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packagingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Packaging: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    ((value.componentPart?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.componentPart?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.componentPartSer, it)
    }
    ((value.quantity?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.quantity?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.componentPartSer, it)
    }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.materialSer, value.material)
    if (value.alternateMaterial.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        Hoisted.materialSer,
        value.alternateMaterial,
      )
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.manufacturerSer, value.manufacturer)
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.propertySer, value.`property`)
    if (value.containedItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        Hoisted.containedItemSer,
        value.containedItem,
      )
    if (value.packaging.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.packagingSer, value.packaging)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Packaging.Property) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Packaging.Property {
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging.Property,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      null -> {}
      is PackagedProductDefinition.Packaging.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, choice.value)
      }
      is PackagedProductDefinition.Packaging.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueQuantitySer, choice.value)
      }
      is PackagedProductDefinition.Packaging.Property.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Packaging.Property.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueDateSer, it)
        }
      }
      is PackagedProductDefinition.Packaging.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueAttachmentSer, choice.value)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Packaging.ContainedItem,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): PackagedProductDefinition.Packaging.ContainedItem {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: Quantity? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContainedItem: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PackagedProductDefinition.Packaging.ContainedItem,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemSer, value.item)
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, it) }
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
    b.element("copackagedIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_copackagedIndicator", Element.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "attachedDocument",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "packaging",
      lazyDescriptor { PackagedProductDefinition.Packaging.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(
        lazyDescriptor { PackagedProductDefinition.Packaging.Property.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PackagedProductDefinition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PackagedProductDefinition {
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
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 ->
          packageFor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packageForSer, null)
        15 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        16 -> statusDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          containedItemQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.containedItemQuantitySer,
              null,
            )
        19 -> description = decoder.decodeStringElement(descriptor, i)
        20 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.legalStatusOfSupplySer,
              null,
            )
        22 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.marketingStatusSer,
              null,
            )
        23 -> copackagedIndicator = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _copackagedIndicator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packageForSer, null)
        26 ->
          attachedDocument =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packageForSer, null)
        27 ->
          packaging =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packagingSer, null)
        28 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicSer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding PackagedProductDefinition: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PackagedProductDefinition,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.packageFor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.packageForSer,
        value.packageFor,
      )
    (value.status)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.statusDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.statusDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.containedItemQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.containedItemQuantitySer,
        value.containedItemQuantity,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.legalStatusOfSupply.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.legalStatusOfSupplySer,
        value.legalStatusOfSupply,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    ((value.copackagedIndicator?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.copackagedIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.packageForSer,
        value.manufacturer,
      )
    if (value.attachedDocument.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.packageForSer,
        value.attachedDocument,
      )
    (value.packaging)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.packagingSer, it)
    }
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
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

internal object PackagedProductDefinitionPolymorphicSerializer :
  KSerializer<PackagedProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PackagedProductDefinition") {
      PackagedProductDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    encoder.encodeStructure(descriptor) {
      PackagedProductDefinitionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    decoder.decodeStructure(descriptor) {
      PackagedProductDefinitionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
