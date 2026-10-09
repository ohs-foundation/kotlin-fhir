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
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
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
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
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

internal object PackagedProductDefinitionLegalStatusOfSupplySerializer :
  FhirSerializer<PackagedProductDefinition.LegalStatusOfSupply> {
  override val descriptor: SerialDescriptor = buildDescriptor("LegalStatusOfSupply", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PackagedProductDefinition.LegalStatusOfSupply>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.LegalStatusOfSupply {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var jurisdiction: CodeableConcept? = null
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
          code =
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
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PackagedProductDefinition.LegalStatusOfSupply(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = code,
      jurisdiction = jurisdiction,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.LegalStatusOfSupply) {
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
      value.code,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.jurisdiction,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PackagedProductDefinitionPackageSerializer :
  FhirSerializer<PackagedProductDefinition.Package> {
  override val descriptor: SerialDescriptor = buildDescriptor("Package", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.intPrim("quantity")
    b.optionalElement("material", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("alternateMaterial", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "shelfLifeStorage",
      PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer.descriptor,
    )
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "property",
      PackagedProductDefinitionPackagePropertySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "containedItem",
      PackagedProductDefinitionPackageContainedItemSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "package",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.PackagedProductDefinitionPackageSerializer)
      ),
    )
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        5 -> quantity = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          material =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          alternateMaterial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          shelfLifeStorage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer,
              null,
            )
        10 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        11 ->
          `property` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackagePropertySerializer.listSerializer,
              null,
            )
        12 ->
          containedItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackageContainedItemSerializer.listSerializer,
              null,
            )
        13 ->
          `package` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackageSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PackagedProductDefinition.Package(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = type,
      quantity = Integer.of(quantity, _quantity),
      material = listOrEmpty(material),
      alternateMaterial = listOrEmpty(alternateMaterial),
      shelfLifeStorage = listOrEmpty(shelfLifeStorage),
      manufacturer = listOrEmpty(manufacturer),
      `property` = listOrEmpty(`property`),
      containedItem = listOrEmpty(containedItem),
      `package` = listOrEmpty(`package`),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.quantity?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.quantity)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.material,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CodeableConceptSerializer.listSerializer,
      value.alternateMaterial,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer,
      value.shelfLifeStorage,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      PackagedProductDefinitionPackagePropertySerializer.listSerializer,
      value.`property`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      PackagedProductDefinitionPackageContainedItemSerializer.listSerializer,
      value.containedItem,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      PackagedProductDefinitionPackageSerializer.listSerializer,
      value.`package`,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PackagedProductDefinitionPackageShelfLifeStorageSerializer :
  FhirSerializer<PackagedProductDefinition.Package.ShelfLifeStorage> {
  override val descriptor: SerialDescriptor = buildDescriptor("ShelfLifeStorage", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<PackagedProductDefinition.Package.ShelfLifeStorage>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("periodDuration", DurationSerializer.descriptor)
    b.strPrim("periodString")
    b.optionalElement(
      "specialPrecautionsForStorage",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ShelfLifeStorage {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var periodDuration: Duration? = null
    var periodString: KotlinString? = null
    var _periodString: Element? = null
    var specialPrecautionsForStorage: List<CodeableConcept>? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          periodDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        5 -> periodString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _periodString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          specialPrecautionsForStorage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PackagedProductDefinition.Package.ShelfLifeStorage(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      period =
        PackagedProductDefinition.Package.ShelfLifeStorage.Period.from(
          periodDuration,
          R4bString.of(periodString, _periodString),
        ),
      specialPrecautionsForStorage = listOrEmpty(specialPrecautionsForStorage),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage,
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
      value.type,
    )
    when (val choice = value.period) {
      null -> {}
      is PackagedProductDefinition.Package.ShelfLifeStorage.Period.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, DurationSerializer, choice.value)
      }
      is PackagedProductDefinition.Package.ShelfLifeStorage.Period.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.specialPrecautionsForStorage,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PackagedProductDefinitionPackagePropertySerializer :
  FhirSerializer<PackagedProductDefinition.Package.Property> {
  override val descriptor: SerialDescriptor = buildDescriptor("Property", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package.Property>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.strPrim("valueDate")
    b.boolPrim("valueBoolean")
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.Property {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueAttachment: Attachment? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        7 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PackagedProductDefinition.Package.Property(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "PackagedProductDefinition.Package.Property", "type"),
      `value` =
        PackagedProductDefinition.Package.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(valueDate, _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package.Property) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      null -> {}
      is PackagedProductDefinition.Package.Property.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is PackagedProductDefinition.Package.Property.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
      }
      is PackagedProductDefinition.Package.Property.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is PackagedProductDefinition.Package.Property.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is PackagedProductDefinition.Package.Property.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          10,
          AttachmentSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PackagedProductDefinitionPackageContainedItemSerializer :
  FhirSerializer<PackagedProductDefinition.Package.ContainedItem> {
  override val descriptor: SerialDescriptor = buildDescriptor("ContainedItem", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package.ContainedItem>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("item", CodeableReferenceSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ContainedItem {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: Quantity? = null
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
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PackagedProductDefinition.Package.ContainedItem(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      item = required(item, "PackagedProductDefinition.Package.ContainedItem", "item"),
      amount = amount,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ContainedItem,
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.item,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PackagedProductDefinitionSerializer :
  FhirResourceSerializer<PackagedProductDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PackagedProductDefinition")

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
    b.strPrim("name")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("packageFor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.strPrim("statusDate")
    b.optionalElement("containedItemQuantity", QuantitySerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement(
      "legalStatusOfSupply",
      PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer.descriptor,
    )
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement("characteristic", CodeableConceptSerializer.listSerializer.descriptor)
    b.boolPrim("copackagedIndicator")
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("package", PackagedProductDefinitionPackageSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var statusDate: FhirDateTime? = null
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
        11 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          packageFor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          statusDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          containedItemQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        19 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          legalStatusOfSupply =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer,
              null,
            )
        22 ->
          marketingStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        23 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        24 -> copackagedIndicator = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _copackagedIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          `package` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackageSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return PackagedProductDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      name = R4bString.of(name, _name),
      type = type,
      packageFor = listOrEmpty(packageFor),
      status = status,
      statusDate = DateTime.of(statusDate, _statusDate),
      containedItemQuantity = listOrEmpty(containedItemQuantity),
      description = Markdown.of(description, _description),
      legalStatusOfSupply = listOrEmpty(legalStatusOfSupply),
      marketingStatus = listOrEmpty(marketingStatus),
      characteristic = listOrEmpty(characteristic),
      copackagedIndicator = R4bBoolean.of(copackagedIndicator, _copackagedIndicator),
      manufacturer = listOrEmpty(manufacturer),
      `package` = `package`,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PackagedProductDefinition,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.packageFor,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusDate)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      QuantitySerializer.listSerializer,
      value.containedItemQuantity,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer,
      value.legalStatusOfSupply,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      22 + descriptorOffset,
      MarketingStatusSerializer.listSerializer,
      value.marketingStatus,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.characteristic,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.copackagedIndicator?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.copackagedIndicator,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      PackagedProductDefinitionPackageSerializer,
      value.`package`,
    )
  }
}
