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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
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
      element("outerPackaging", Identifier.serializer().descriptor, isOptional = true)
      element("immediatePackaging", Identifier.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.BatchIdentifier =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.BatchIdentifier) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductPackaged.BatchIdentifier {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outerPackaging: Identifier? = null
    var immediatePackaging: Identifier? = null
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
          outerPackaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.outerPackagingSer,
              null,
            )
        4 ->
          immediatePackaging =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.outerPackagingSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BatchIdentifier: " + i)
      }
    }
    return MedicinalProductPackaged.BatchIdentifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      outerPackaging = outerPackaging!!,
      immediatePackaging = immediatePackaging,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPackaged.BatchIdentifier,
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
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.outerPackagingSer,
      value.outerPackaging,
    )
    (value.immediatePackaging)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.outerPackagingSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val outerPackagingSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object MedicinalProductPackagedPackageItemSerializer :
  KSerializer<MedicinalProductPackaged.PackageItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PackageItem") {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
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
      element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "manufacturedItem",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "packageItem",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductPackaged.PackageItem.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "physicalCharacteristics",
        ProdCharacteristic.serializer().descriptor,
        isOptional = true,
      )
      element(
        "otherCharacteristics",
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
    }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.PackageItem =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.PackageItem) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicinalProductPackaged.PackageItem {
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
        5 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        6 ->
          material =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialSer, null)
        7 ->
          alternateMaterial =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialSer, null)
        8 ->
          device = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        9 ->
          manufacturedItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        10 ->
          packageItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packageItemSer, null)
        11 ->
          physicalCharacteristics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.physicalCharacteristicsSer,
              null,
            )
        12 ->
          otherCharacteristics =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.materialSer, null)
        13 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.shelfLifeStorageSer,
              null,
            )
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.deviceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PackageItem: " + i)
      }
    }
    return MedicinalProductPackaged.PackageItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type!!,
      quantity = quantity!!,
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPackaged.PackageItem,
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
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, value.type)
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.quantitySer, value.quantity)
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.materialSer, value.material)
    if (value.alternateMaterial.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.materialSer, value.alternateMaterial)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.deviceSer, value.device)
    if (value.manufacturedItem.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.deviceSer, value.manufacturedItem)
    if (value.packageItem.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.packageItemSer, value.packageItem)
    (value.physicalCharacteristics)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.physicalCharacteristicsSer, it)
    }
    if (value.otherCharacteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        Hoisted.materialSer,
        value.otherCharacteristics,
      )
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.deviceSer, value.manufacturer)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val materialSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val deviceSerInner: KSerializer<Reference> = Reference.serializer()

    public val deviceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.deviceSerInner)

    public val packageItemSerInner: KSerializer<MedicinalProductPackaged.PackageItem> =
      MedicinalProductPackaged.PackageItem.serializer()

    public val packageItemSer: KSerializer<List<MedicinalProductPackaged.PackageItem>> =
      ListSerializer(Hoisted.packageItemSerInner)

    public val physicalCharacteristicsSer: KSerializer<ProdCharacteristic> =
      ProdCharacteristic.serializer()

    public val shelfLifeStorageSerInner: KSerializer<ProductShelfLife> =
      ProductShelfLife.serializer()

    public val shelfLifeStorageSer: KSerializer<List<ProductShelfLife>> =
      ListSerializer(Hoisted.shelfLifeStorageSerInner)
  }
}

internal object MedicinalProductPackagedSerializer : KSerializer<MedicinalProductPackaged> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductPackaged") {
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
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "marketingStatus",
      listSerialDescriptor(MarketingStatus.serializer().descriptor),
      isOptional = true,
    )
    b.element("marketingAuthorization", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "batchIdentifier",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductPackaged.BatchIdentifier.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "packageItem",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductPackaged.PackageItem.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductPackaged")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        11 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        12 -> description = decoder.decodeStringElement(descriptor, i)
        13 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.legalStatusOfSupplySer,
              null,
            )
        15 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.marketingStatusSer,
              null,
            )
        16 ->
          marketingAuthorization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSerInner, null)
        17 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 ->
          batchIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.batchIdentifierSer,
              null,
            )
        19 ->
          packageItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.packageItemSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPackaged,
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
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.subjectSer,
        value.subject,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.legalStatusOfSupplySer,
        it,
      )
    }
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    (value.marketingAuthorization)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.subjectSerInner,
        it,
      )
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.subjectSer,
        value.manufacturer,
      )
    if (value.batchIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.batchIdentifierSer,
        value.batchIdentifier,
      )
    if (value.packageItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.packageItemSer,
        value.packageItem,
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

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val legalStatusOfSupplySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val marketingStatusSerInner: KSerializer<MarketingStatus> = MarketingStatus.serializer()

    public val marketingStatusSer: KSerializer<List<MarketingStatus>> =
      ListSerializer(Hoisted.marketingStatusSerInner)

    public val batchIdentifierSerInner: KSerializer<MedicinalProductPackaged.BatchIdentifier> =
      MedicinalProductPackaged.BatchIdentifier.serializer()

    public val batchIdentifierSer: KSerializer<List<MedicinalProductPackaged.BatchIdentifier>> =
      ListSerializer(Hoisted.batchIdentifierSerInner)

    public val packageItemSerInner: KSerializer<MedicinalProductPackaged.PackageItem> =
      MedicinalProductPackaged.PackageItem.serializer()

    public val packageItemSer: KSerializer<List<MedicinalProductPackaged.PackageItem>> =
      ListSerializer(Hoisted.packageItemSerInner)
  }
}

internal object MedicinalProductPackagedPolymorphicSerializer :
  KSerializer<MedicinalProductPackaged> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductPackaged") {
      MedicinalProductPackagedSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductPackagedSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged =
    decoder.decodeStructure(descriptor) {
      MedicinalProductPackagedSerializer.deserializeInternal(this, descriptor, 0)
    }
}
