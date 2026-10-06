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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("jurisdiction", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PackagedProductDefinition.LegalStatusOfSupply>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.LegalStatusOfSupply =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var jurisdiction: CodeableConcept? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            jurisdiction =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding LegalStatusOfSupply: " + i)
        }
      }
      PackagedProductDefinition.LegalStatusOfSupply(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        jurisdiction = jurisdiction,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.LegalStatusOfSupply) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.jurisdiction)
    }
  }
}

internal object PackagedProductDefinitionPackageSerializer :
  KSerializer<PackagedProductDefinition.Package> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Package") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("quantity", Int.serializer().descriptor)
      optionalElement("_quantity", ElementSerializer.descriptor)
      optionalElement("material", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("alternateMaterial", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "shelfLifeStorage",
        PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer.descriptor,
      )
      optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "property",
        PackagedProductDefinitionPackagePropertySerializer.listSerializer.descriptor,
      )
      optionalElement(
        "containedItem",
        PackagedProductDefinitionPackageContainedItemSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "package",
        listSerialDescriptor(
          lazyDescriptor { PackagedProductDefinitionPackageSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package =
    decoder.decodeStructure(descriptor) {
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
          5 -> quantity = decodeIntElement(descriptor, i)
          6 -> _quantity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            material =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            alternateMaterial =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            shelfLifeStorage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer,
                null,
              )
          10 ->
            manufacturer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          11 ->
            `property` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PackagedProductDefinitionPackagePropertySerializer.listSerializer,
                null,
              )
          12 ->
            containedItem =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PackagedProductDefinitionPackageContainedItemSerializer.listSerializer,
                null,
              )
          13 ->
            `package` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PackagedProductDefinitionPackageSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Package: " + i)
        }
      }
      PackagedProductDefinition.Package(
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

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package) {
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      encodeIntIfNotNull(descriptor, 5, value.quantity?.value)
      encodeElementIfNotNull(descriptor, 6, value.quantity)
      if (value.material.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.material,
        )
      if (value.alternateMaterial.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.alternateMaterial,
        )
      if (value.shelfLifeStorage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          PackagedProductDefinitionPackageShelfLifeStorageSerializer.listSerializer,
          value.shelfLifeStorage,
        )
      if (value.manufacturer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          ReferenceSerializer.listSerializer,
          value.manufacturer,
        )
      if (value.`property`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          PackagedProductDefinitionPackagePropertySerializer.listSerializer,
          value.`property`,
        )
      if (value.containedItem.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          PackagedProductDefinitionPackageContainedItemSerializer.listSerializer,
          value.containedItem,
        )
      if (value.`package`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          PackagedProductDefinitionPackageSerializer.listSerializer,
          value.`package`,
        )
    }
  }
}

internal object PackagedProductDefinitionPackageShelfLifeStorageSerializer :
  KSerializer<PackagedProductDefinition.Package.ShelfLifeStorage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ShelfLifeStorage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("periodDuration", DurationSerializer.descriptor)
      optionalElement("periodString", KotlinString.serializer().descriptor)
      optionalElement("_periodString", ElementSerializer.descriptor)
      optionalElement(
        "specialPrecautionsForStorage",
        CodeableConceptSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<PackagedProductDefinition.Package.ShelfLifeStorage>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ShelfLifeStorage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var periodDuration: Duration? = null
      var periodString: KotlinString? = null
      var _periodString: Element? = null
      var specialPrecautionsForStorage: List<CodeableConcept>? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            periodDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          5 -> periodString = decodeStringElement(descriptor, i)
          6 ->
            _periodString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            specialPrecautionsForStorage =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ShelfLifeStorage: " + i)
        }
      }
      PackagedProductDefinition.Package.ShelfLifeStorage(
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

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.period) {
        null -> {}
        is PackagedProductDefinition.Package.ShelfLifeStorage.Period.Duration -> {
          encodeSerializableElement(descriptor, 4, DurationSerializer, choice.value)
        }
        is PackagedProductDefinition.Package.ShelfLifeStorage.Period.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
      }
      if (value.specialPrecautionsForStorage.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.specialPrecautionsForStorage,
        )
    }
  }
}

internal object PackagedProductDefinitionPackagePropertySerializer :
  KSerializer<PackagedProductDefinition.Package.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.Property =
    decoder.decodeStructure(descriptor) {
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueDate = decodeStringElement(descriptor, i)
          7 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      PackagedProductDefinition.Package.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on PackagedProductDefinition.Package.Property"
            ),
        `value` =
          PackagedProductDefinition.Package.Property.Value.from(
            valueCodeableConcept,
            valueQuantity,
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            R4bBoolean.of(valueBoolean, _valueBoolean),
            valueAttachment,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package.Property) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`value`) {
        null -> {}
        is PackagedProductDefinition.Package.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is PackagedProductDefinition.Package.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is PackagedProductDefinition.Package.Property.Value.Date -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is PackagedProductDefinition.Package.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is PackagedProductDefinition.Package.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object PackagedProductDefinitionPackageContainedItemSerializer :
  KSerializer<PackagedProductDefinition.Package.ContainedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContainedItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PackagedProductDefinition.Package.ContainedItem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ContainedItem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var item: CodeableReference? = null
      var amount: Quantity? = null
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
            item =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 -> amount = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContainedItem: " + i)
        }
      }
      PackagedProductDefinition.Package.ContainedItem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item =
          item
            ?: throw SerializationException(
              "Missing required property 'item' on PackagedProductDefinition.Package.ContainedItem"
            ),
        amount = amount,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ContainedItem,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.item)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.amount)
    }
  }
}

internal object PackagedProductDefinitionSerializer :
  FhirResourceSerializer<PackagedProductDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PackagedProductDefinition")

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
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("packageFor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
    b.optionalElement("statusDate", KotlinString.serializer().descriptor)
    b.optionalElement("_statusDate", ElementSerializer.descriptor)
    b.optionalElement("containedItemQuantity", QuantitySerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement(
      "legalStatusOfSupply",
      PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer.descriptor,
    )
    b.optionalElement("marketingStatus", MarketingStatusSerializer.listSerializer.descriptor)
    b.optionalElement("characteristic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("copackagedIndicator", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_copackagedIndicator", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("package", PackagedProductDefinitionPackageSerializer.descriptor)
  }

  override fun deserializeInternal(
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
    var characteristic: List<CodeableConcept>? = null
    var copackagedIndicator: KotlinBoolean? = null
    var _copackagedIndicator: Element? = null
    var manufacturer: List<Reference>? = null
    var `package`: PackagedProductDefinition.Package? = null
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
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          packageFor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> statusDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _statusDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          containedItemQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer.listSerializer,
              null,
            )
        19 -> description = decoder.decodeStringElement(descriptor, i)
        20 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          legalStatusOfSupply =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer,
              null,
            )
        22 ->
          marketingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MarketingStatusSerializer.listSerializer,
              null,
            )
        23 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        24 -> copackagedIndicator = decoder.decodeBooleanElement(descriptor, i)
        25 ->
          _copackagedIndicator =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          `package` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PackagedProductDefinitionPackageSerializer,
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
      name = R4bString.of(name, _name),
      type = type,
      packageFor = packageFor ?: listOf(),
      status = status,
      statusDate =
        DateTime.of(
          if (statusDate != null) FhirDateTime.fromString(statusDate) else null,
          _statusDate,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PackagedProductDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.packageFor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.packageFor,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.status,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.statusDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.statusDate)
    if (value.containedItemQuantity.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        QuantitySerializer.listSerializer,
        value.containedItemQuantity,
      )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.description)
    if (value.legalStatusOfSupply.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        PackagedProductDefinitionLegalStatusOfSupplySerializer.listSerializer,
        value.legalStatusOfSupply,
      )
    if (value.marketingStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        MarketingStatusSerializer.listSerializer,
        value.marketingStatus,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.characteristic,
      )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.copackagedIndicator?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.copackagedIndicator)
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      PackagedProductDefinitionPackageSerializer,
      value.`package`,
    )
  }
}
