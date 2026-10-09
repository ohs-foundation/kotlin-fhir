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
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MarketingStatus
import dev.ohs.fhir.model.r4.MedicinalProductPackaged
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.ProdCharacteristic
import dev.ohs.fhir.model.r4.ProductShelfLife
import dev.ohs.fhir.model.r4.Quantity
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

internal object MedicinalProductPackagedBatchIdentifierSerializer :
  FhirSerializer<MedicinalProductPackaged.BatchIdentifier> {
  override val descriptor: SerialDescriptor = buildDescriptor("BatchIdentifier", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProductPackaged.BatchIdentifier>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("outerPackaging", IdentifierSerializer.descriptor)
    b.optionalElement("immediatePackaging", IdentifierSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.BatchIdentifier {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outerPackaging: Identifier? = null
    var immediatePackaging: Identifier? = null
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
          outerPackaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        4 ->
          immediatePackaging =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPackaged.BatchIdentifier(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      outerPackaging =
        required(outerPackaging, "MedicinalProductPackaged.BatchIdentifier", "outerPackaging"),
      immediatePackaging = immediatePackaging,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.BatchIdentifier) {
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
      IdentifierSerializer,
      value.outerPackaging,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      IdentifierSerializer,
      value.immediatePackaging,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPackagedPackageItemSerializer :
  FhirSerializer<MedicinalProductPackaged.PackageItem> {
  override val descriptor: SerialDescriptor = buildDescriptor("PackageItem", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProductPackaged.PackageItem>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("material", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("alternateMaterial", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("manufacturedItem", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "packageItem",
      listSerialDescriptor(
        lazyDescriptor(LazyDescriptorId.MedicinalProductPackagedPackageItemSerializer)
      ),
    )
    b.optionalElement("physicalCharacteristics", ProdCharacteristicSerializer.descriptor)
    b.optionalElement("otherCharacteristics", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("shelfLifeStorage", ProductShelfLifeSerializer.listSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.PackageItem {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var type: CodeableConcept? = null
    var quantity: Quantity? = null
    var material: List<CodeableConcept>? = null
    var alternateMaterial: List<CodeableConcept>? = null
    var device: List<Reference>? = null
    var manufacturedItem: List<Reference>? = null
    var packageItem: List<MedicinalProductPackaged.PackageItem>? = null
    var physicalCharacteristics: ProdCharacteristic? = null
    var otherCharacteristics: List<CodeableConcept>? = null
    var shelfLifeStorage: List<ProductShelfLife>? = null
    var manufacturer: List<Reference>? = null
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
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          material =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        7 ->
          alternateMaterial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        9 ->
          manufacturedItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        10 ->
          packageItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPackagedPackageItemSerializer.listSerializer,
              null,
            )
        11 ->
          physicalCharacteristics =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProdCharacteristicSerializer,
              null,
            )
        12 ->
          otherCharacteristics =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          shelfLifeStorage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ProductShelfLifeSerializer.listSerializer,
              null,
            )
        14 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPackaged.PackageItem(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = required(type, "MedicinalProductPackaged.PackageItem", "type"),
      quantity = required(quantity, "MedicinalProductPackaged.PackageItem", "quantity"),
      material = listOrEmpty(material),
      alternateMaterial = listOrEmpty(alternateMaterial),
      device = listOrEmpty(device),
      manufacturedItem = listOrEmpty(manufacturedItem),
      packageItem = listOrEmpty(packageItem),
      physicalCharacteristics = physicalCharacteristics,
      otherCharacteristics = listOrEmpty(otherCharacteristics),
      shelfLifeStorage = listOrEmpty(shelfLifeStorage),
      manufacturer = listOrEmpty(manufacturer),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.PackageItem) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, value.quantity)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CodeableConceptSerializer.listSerializer,
      value.material,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.alternateMaterial,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      ReferenceSerializer.listSerializer,
      value.device,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ReferenceSerializer.listSerializer,
      value.manufacturedItem,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      MedicinalProductPackagedPackageItemSerializer.listSerializer,
      value.packageItem,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      ProdCharacteristicSerializer,
      value.physicalCharacteristics,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      CodeableConceptSerializer.listSerializer,
      value.otherCharacteristics,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      ProductShelfLifeSerializer.listSerializer,
      value.shelfLifeStorage,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPackagedSerializer :
  FhirResourceSerializer<MedicinalProductPackaged> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProductPackaged")

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
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("legalStatusOfSupply", CodeableConceptSerializer.descriptor)
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement("marketingAuthorization", ReferenceSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "batchIdentifier",
      MedicinalProductPackagedBatchIdentifierSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "packageItem",
      MedicinalProductPackagedPackageItemSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProductPackaged {
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
    var subject: List<Reference>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var legalStatusOfSupply: CodeableConcept? = null
    var marketingStatus: List<MarketingStatus>? = null
    var marketingAuthorization: Reference? = null
    var manufacturer: List<Reference>? = null
    var batchIdentifier: List<MedicinalProductPackaged.BatchIdentifier>? = null
    var packageItem: List<MedicinalProductPackaged.PackageItem>? = null
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
        11 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          legalStatusOfSupply =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          marketingStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        16 ->
          marketingAuthorization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          batchIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPackagedBatchIdentifierSerializer.listSerializer,
              null,
            )
        19 ->
          packageItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPackagedPackageItemSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MedicinalProductPackaged(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      subject = listOrEmpty(subject),
      description = R4String.of(description, _description),
      legalStatusOfSupply = legalStatusOfSupply,
      marketingStatus = listOrEmpty(marketingStatus),
      marketingAuthorization = marketingAuthorization,
      manufacturer = listOrEmpty(manufacturer),
      batchIdentifier = listOrEmpty(batchIdentifier),
      packageItem = listOrEmpty(packageItem),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPackaged,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.subject,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalStatusOfSupply,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      MarketingStatusSerializer.listSerializer,
      value.marketingStatus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.marketingAuthorization,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18 + descriptorOffset,
      MedicinalProductPackagedBatchIdentifierSerializer.listSerializer,
      value.batchIdentifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      MedicinalProductPackagedPackageItemSerializer.listSerializer,
      value.packageItem,
    )
  }
}
