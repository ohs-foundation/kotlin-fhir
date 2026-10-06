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

internal object MedicinalProductPackagedBatchIdentifierSerializer :
  KSerializer<MedicinalProductPackaged.BatchIdentifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BatchIdentifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("outerPackaging", IdentifierSerializer.descriptor)
      optionalElement("immediatePackaging", IdentifierSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductPackaged.BatchIdentifier>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.BatchIdentifier =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var outerPackaging: Identifier? = null
      var immediatePackaging: Identifier? = null
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
            outerPackaging =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            immediatePackaging =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding BatchIdentifier: " + i)
        }
      }
      MedicinalProductPackaged.BatchIdentifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        outerPackaging =
          outerPackaging
            ?: throw SerializationException(
              "Missing required property 'outerPackaging' on MedicinalProductPackaged.BatchIdentifier"
            ),
        immediatePackaging = immediatePackaging,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.BatchIdentifier) {
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
      encodeSerializableElement(descriptor, 3, IdentifierSerializer, value.outerPackaging)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.immediatePackaging)
    }
  }
}

internal object MedicinalProductPackagedPackageItemSerializer :
  KSerializer<MedicinalProductPackaged.PackageItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PackageItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("material", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("alternateMaterial", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("manufacturedItem", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "packageItem",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductPackagedPackageItemSerializer.descriptor }
        ),
      )
      optionalElement("physicalCharacteristics", ProdCharacteristicSerializer.descriptor)
      optionalElement("otherCharacteristics", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("shelfLifeStorage", ProductShelfLifeSerializer.listSerializer.descriptor)
      optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductPackaged.PackageItem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.PackageItem =
    decoder.decodeStructure(descriptor) {
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 ->
            material =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          7 ->
            alternateMaterial =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            device =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          9 ->
            manufacturedItem =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          10 ->
            packageItem =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductPackagedPackageItemSerializer.listSerializer,
                null,
              )
          11 ->
            physicalCharacteristics =
              decodeNullableSerializableElement(descriptor, i, ProdCharacteristicSerializer, null)
          12 ->
            otherCharacteristics =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          13 ->
            shelfLifeStorage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ProductShelfLifeSerializer.listSerializer,
                null,
              )
          14 ->
            manufacturer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PackageItem: " + i)
        }
      }
      MedicinalProductPackaged.PackageItem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on MedicinalProductPackaged.PackageItem"
            ),
        quantity =
          quantity
            ?: throw SerializationException(
              "Missing required property 'quantity' on MedicinalProductPackaged.PackageItem"
            ),
        material = material ?: listOf(),
        alternateMaterial = alternateMaterial ?: listOf(),
        device = device ?: listOf(),
        manufacturedItem = manufacturedItem ?: listOf(),
        packageItem = packageItem ?: listOf(),
        physicalCharacteristics = physicalCharacteristics,
        otherCharacteristics = otherCharacteristics ?: listOf(),
        shelfLifeStorage = shelfLifeStorage ?: listOf(),
        manufacturer = manufacturer ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.PackageItem) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeSerializableElement(descriptor, 5, QuantitySerializer, value.quantity)
      if (value.material.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.material,
        )
      if (value.alternateMaterial.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.alternateMaterial,
        )
      if (value.device.isNotEmpty())
        encodeSerializableElement(descriptor, 8, ReferenceSerializer.listSerializer, value.device)
      if (value.manufacturedItem.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          ReferenceSerializer.listSerializer,
          value.manufacturedItem,
        )
      if (value.packageItem.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          MedicinalProductPackagedPackageItemSerializer.listSerializer,
          value.packageItem,
        )
      encodeSerializableIfNotNull(
        descriptor,
        11,
        ProdCharacteristicSerializer,
        value.physicalCharacteristics,
      )
      if (value.otherCharacteristics.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CodeableConceptSerializer.listSerializer,
          value.otherCharacteristics,
        )
      if (value.shelfLifeStorage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ProductShelfLifeSerializer.listSerializer,
          value.shelfLifeStorage,
        )
      if (value.manufacturer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          ReferenceSerializer.listSerializer,
          value.manufacturer,
        )
    }
  }
}

internal object MedicinalProductPackagedSerializer :
  FhirResourceSerializer<MedicinalProductPackaged> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProductPackaged")

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
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
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
    decoder: CompositeDecoder,
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
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 -> description = decoder.decodeStringElement(descriptor, i)
        13 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        16 ->
          marketingAuthorization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          batchIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPackagedBatchIdentifierSerializer.listSerializer,
              null,
            )
        19 ->
          packageItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPackagedPackageItemSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding MedicinalProductPackaged: " + i)
      }
    }
    return MedicinalProductPackaged(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      subject = subject ?: listOf(),
      description = R4String.of(description, _description),
      legalStatusOfSupply = legalStatusOfSupply,
      marketingStatus = marketingStatus ?: listOf(),
      marketingAuthorization = marketingAuthorization,
      manufacturer = manufacturer ?: listOf(),
      batchIdentifier = batchIdentifier ?: listOf(),
      packageItem = packageItem ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPackaged,
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
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.description)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalStatusOfSupply,
    )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        MarketingStatusSerializer.listSerializer,
        value.marketingStatus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.marketingAuthorization,
    )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.batchIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        MedicinalProductPackagedBatchIdentifierSerializer.listSerializer,
        value.batchIdentifier,
      )
    if (value.packageItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        MedicinalProductPackagedPackageItemSerializer.listSerializer,
        value.packageItem,
      )
  }
}
