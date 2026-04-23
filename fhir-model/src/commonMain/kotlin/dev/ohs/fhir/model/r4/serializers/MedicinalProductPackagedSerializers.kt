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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.BatchIdentifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductPackaged.BatchIdentifier {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outerPackaging: Identifier? = null
    var immediatePackaging: Identifier? = null
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
          outerPackaging =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.outerPackagingSer, null)
        4 ->
          immediatePackaging =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.outerPackagingSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BatchIdentifier: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPackaged.BatchIdentifier,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.outerPackaging)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.outerPackagingSer, it)
    }
    (value.immediatePackaging)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.outerPackagingSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.PackageItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductPackaged.PackageItem {
    val __desc = descriptor
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
          quantity = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.quantitySer, null)
        6 ->
          material = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.materialSer, null)
        7 ->
          alternateMaterial =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.materialSer, null)
        8 -> device = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.deviceSer, null)
        9 ->
          manufacturedItem =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.deviceSer, null)
        10 ->
          packageItem =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.packageItemSer, null)
        11 ->
          physicalCharacteristics =
            decoder.decodeNullableSerializableElement(
              __desc,
              11,
              Hoisted.physicalCharacteristicsSer,
              null,
            )
        12 ->
          otherCharacteristics =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.materialSer, null)
        13 ->
          shelfLifeStorage =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.shelfLifeStorageSer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.deviceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PackageItem: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPackaged.PackageItem,
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
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.quantitySer, it) }
    if (value.material.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.materialSer, value.material)
    if (value.alternateMaterial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.materialSer, value.alternateMaterial)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.deviceSer, value.device)
    if (value.manufacturedItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.deviceSer, value.manufacturedItem)
    if (value.packageItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.packageItemSer, value.packageItem)
    (value.physicalCharacteristics)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.physicalCharacteristicsSer, it)
    }
    if (value.otherCharacteristics.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.materialSer, value.otherCharacteristics)
    if (value.shelfLifeStorage.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        13,
        Hoisted.shelfLifeStorageSer,
        value.shelfLifeStorage,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.deviceSer, value.manufacturer)
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
      element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("legalStatusOfSupply", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "marketingStatus",
        listSerialDescriptor(MarketingStatus.serializer().descriptor),
        isOptional = true,
      )
      element("marketingAuthorization", Reference.serializer().descriptor, isOptional = true)
      element(
        "manufacturer",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "batchIdentifier",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductPackaged.BatchIdentifier.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "packageItem",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductPackaged.PackageItem.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductPackaged {
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
        12 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.subjectSer, null)
        13 -> description = decoder.decodeStringElement(__desc, 13)
        14 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.legalStatusOfSupplySer,
              null,
            )
        16 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.marketingStatusSer, null)
        17 ->
          marketingAuthorization =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSerInner, null)
        18 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 ->
          batchIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.batchIdentifierSer, null)
        20 ->
          packageItem =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.packageItemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding MedicinalProductPackaged: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductPackaged) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicinalProductPackaged")
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
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.subjectSer, value.subject)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.legalStatusOfSupply)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.legalStatusOfSupplySer, it)
    }
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16,
        Hoisted.marketingStatusSer,
        value.marketingStatus,
      )
    (value.marketingAuthorization)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSerInner, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, value.manufacturer)
    if (value.batchIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.batchIdentifierSer,
        value.batchIdentifier,
      )
    if (value.packageItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.packageItemSer, value.packageItem)
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
