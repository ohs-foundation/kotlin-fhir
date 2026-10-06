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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.InventoryItem
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
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

internal object InventoryItemNameSerializer : KSerializer<InventoryItem.Name> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Name") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("nameType", CodingSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Name =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var nameType: Coding? = null
      var language: KotlinString? = null
      var _language: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
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
          3 -> nameType = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> language = decodeStringElement(descriptor, i)
          5 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> name = decodeStringElement(descriptor, i)
          7 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Name: " + i)
        }
      }
      InventoryItem.Name(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        nameType =
          nameType
            ?: throw SerializationException(
              "Missing required property 'nameType' on InventoryItem.Name"
            ),
        language =
          Enumeration.of(
            if (language != null) InventoryItem.CommonLanguages.fromCode(language) else null,
            _language,
          )
            ?: throw SerializationException(
              "Missing required property 'language' on InventoryItem.Name"
            ),
        name =
          R5String.of(name, _name)
            ?: throw SerializationException(
              "Missing required property 'name' on InventoryItem.Name"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Name) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.nameType)
      encodeStringIfNotNull(descriptor, 4, value.language.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.language)
      encodeStringIfNotNull(descriptor, 6, value.name.value)
      encodeElementIfNotNull(descriptor, 7, value.name)
    }
  }
}

internal object InventoryItemResponsibleOrganizationSerializer :
  KSerializer<InventoryItem.ResponsibleOrganization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResponsibleOrganization") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("organization", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.ResponsibleOrganization>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.ResponsibleOrganization =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: CodeableConcept? = null
      var organization: Reference? = null
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
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            organization =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ResponsibleOrganization: " + i)
        }
      }
      InventoryItem.ResponsibleOrganization(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role =
          role
            ?: throw SerializationException(
              "Missing required property 'role' on InventoryItem.ResponsibleOrganization"
            ),
        organization =
          organization
            ?: throw SerializationException(
              "Missing required property 'organization' on InventoryItem.ResponsibleOrganization"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.ResponsibleOrganization) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.organization)
    }
  }
}

internal object InventoryItemDescriptionSerializer : KSerializer<InventoryItem.Description> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Description") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Description>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Description =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var language: KotlinString? = null
      var _language: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
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
          3 -> language = decodeStringElement(descriptor, i)
          4 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Description: " + i)
        }
      }
      InventoryItem.Description(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        language =
          Enumeration.of(
            if (language != null) InventoryItem.CommonLanguages.fromCode(language) else null,
            _language,
          ),
        description = R5String.of(description, _description),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Description) {
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
      encodeStringIfNotNull(descriptor, 3, value.language?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.language)
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
    }
  }
}

internal object InventoryItemAssociationSerializer : KSerializer<InventoryItem.Association> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Association") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("associationType", CodeableConceptSerializer.descriptor)
      optionalElement("relatedItem", ReferenceSerializer.descriptor)
      optionalElement("quantity", RatioSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Association>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Association =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var associationType: CodeableConcept? = null
      var relatedItem: Reference? = null
      var quantity: Ratio? = null
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
            associationType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            relatedItem =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 -> quantity = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Association: " + i)
        }
      }
      InventoryItem.Association(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        associationType =
          associationType
            ?: throw SerializationException(
              "Missing required property 'associationType' on InventoryItem.Association"
            ),
        relatedItem =
          relatedItem
            ?: throw SerializationException(
              "Missing required property 'relatedItem' on InventoryItem.Association"
            ),
        quantity =
          quantity
            ?: throw SerializationException(
              "Missing required property 'quantity' on InventoryItem.Association"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Association) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.associationType)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.relatedItem)
      encodeSerializableElement(descriptor, 5, RatioSerializer, value.quantity)
    }
  }
}

internal object InventoryItemCharacteristicSerializer : KSerializer<InventoryItem.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("characteristicType", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueUrl", KotlinString.serializer().descriptor)
      optionalElement("_valueUrl", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueRatio", RatioSerializer.descriptor)
      optionalElement("valueAnnotation", AnnotationSerializer.descriptor)
      optionalElement("valueAddress", AddressSerializer.descriptor)
      optionalElement("valueDuration", DurationSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var characteristicType: CodeableConcept? = null
      var valueString: KotlinString? = null
      var _valueString: Element? = null
      var valueInteger: Int? = null
      var _valueInteger: Element? = null
      var valueDecimal: FhirDecimal? = null
      var _valueDecimal: Element? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueUrl: KotlinString? = null
      var _valueUrl: Element? = null
      var valueDateTime: KotlinString? = null
      var _valueDateTime: Element? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
      var valueRatio: Ratio? = null
      var valueAnnotation: Annotation? = null
      var valueAddress: Address? = null
      var valueDuration: Duration? = null
      var valueCodeableConcept: CodeableConcept? = null
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
            characteristicType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> valueString = decodeStringElement(descriptor, i)
          5 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> valueInteger = decodeIntElement(descriptor, i)
          7 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          9 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> valueBoolean = decodeBooleanElement(descriptor, i)
          11 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueUrl = decodeStringElement(descriptor, i)
          13 ->
            _valueUrl = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> valueDateTime = decodeStringElement(descriptor, i)
          15 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          17 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          18 -> valueRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          19 ->
            valueAnnotation =
              decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
          20 ->
            valueAddress = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          21 ->
            valueDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          22 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      InventoryItem.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        characteristicType =
          characteristicType
            ?: throw SerializationException(
              "Missing required property 'characteristicType' on InventoryItem.Characteristic"
            ),
        `value` =
          InventoryItem.Characteristic.Value.from(
            R5String.of(valueString, _valueString),
            Integer.of(valueInteger, _valueInteger),
            Decimal.of(valueDecimal, _valueDecimal),
            R5Boolean.of(valueBoolean, _valueBoolean),
            Url.of(valueUrl, _valueUrl),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            valueQuantity,
            valueRange,
            valueRatio,
            valueAnnotation,
            valueAddress,
            valueDuration,
            valueCodeableConcept,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on InventoryItem.Characteristic"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Characteristic) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.characteristicType)
      when (val choice = value.`value`) {
        is InventoryItem.Characteristic.Value.String -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is InventoryItem.Characteristic.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is InventoryItem.Characteristic.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 8, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is InventoryItem.Characteristic.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is InventoryItem.Characteristic.Value.Url -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is InventoryItem.Characteristic.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is InventoryItem.Characteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 16, QuantitySerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.Range -> {
          encodeSerializableElement(descriptor, 17, RangeSerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.Ratio -> {
          encodeSerializableElement(descriptor, 18, RatioSerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.Annotation -> {
          encodeSerializableElement(descriptor, 19, AnnotationSerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.Address -> {
          encodeSerializableElement(descriptor, 20, AddressSerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.Duration -> {
          encodeSerializableElement(descriptor, 21, DurationSerializer, choice.value)
        }
        is InventoryItem.Characteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 22, CodeableConceptSerializer, choice.value)
        }
      }
    }
  }
}

internal object InventoryItemInstanceSerializer : KSerializer<InventoryItem.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("lotNumber", KotlinString.serializer().descriptor)
      optionalElement("_lotNumber", ElementSerializer.descriptor)
      optionalElement("expiry", KotlinString.serializer().descriptor)
      optionalElement("_expiry", ElementSerializer.descriptor)
      optionalElement("subject", ReferenceSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Instance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var lotNumber: KotlinString? = null
      var _lotNumber: Element? = null
      var expiry: KotlinString? = null
      var _expiry: Element? = null
      var subject: Reference? = null
      var location: Reference? = null
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
          4 -> lotNumber = decodeStringElement(descriptor, i)
          5 ->
            _lotNumber = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> expiry = decodeStringElement(descriptor, i)
          7 -> _expiry = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> subject = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Instance: " + i)
        }
      }
      InventoryItem.Instance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        lotNumber = R5String.of(lotNumber, _lotNumber),
        expiry =
          DateTime.of(if (expiry != null) FhirDateTime.fromString(expiry) else null, _expiry),
        subject = subject,
        location = location,
      )
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Instance) {
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
      encodeStringIfNotNull(descriptor, 4, value.lotNumber?.value)
      encodeElementIfNotNull(descriptor, 5, value.lotNumber)
      encodeStringIfNotNull(descriptor, 6, value.expiry?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.expiry)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.subject)
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.location)
    }
  }
}

internal object InventoryItemSerializer : FhirResourceSerializer<InventoryItem> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("InventoryItem")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("name", InventoryItemNameSerializer.listSerializer.descriptor)
    b.optionalElement(
      "responsibleOrganization",
      InventoryItemResponsibleOrganizationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("description", InventoryItemDescriptionSerializer.descriptor)
    b.optionalElement("inventoryStatus", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("baseUnit", CodeableConceptSerializer.descriptor)
    b.optionalElement("netContent", QuantitySerializer.descriptor)
    b.optionalElement("association", InventoryItemAssociationSerializer.listSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      InventoryItemCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("instance", InventoryItemInstanceSerializer.descriptor)
    b.optionalElement("productReference", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): InventoryItem {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: List<CodeableConcept>? = null
    var name: List<InventoryItem.Name>? = null
    var responsibleOrganization: List<InventoryItem.ResponsibleOrganization>? = null
    var description: InventoryItem.Description? = null
    var inventoryStatus: List<CodeableConcept>? = null
    var baseUnit: CodeableConcept? = null
    var netContent: Quantity? = null
    var association: List<InventoryItem.Association>? = null
    var characteristic: List<InventoryItem.Characteristic>? = null
    var instance: InventoryItem.Instance? = null
    var productReference: Reference? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          name =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemNameSerializer.listSerializer,
              null,
            )
        16 ->
          responsibleOrganization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemResponsibleOrganizationSerializer.listSerializer,
              null,
            )
        17 ->
          description =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemDescriptionSerializer,
              null,
            )
        18 ->
          inventoryStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          baseUnit =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          netContent =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        21 ->
          association =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemAssociationSerializer.listSerializer,
              null,
            )
        22 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemCharacteristicSerializer.listSerializer,
              null,
            )
        23 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemInstanceSerializer,
              null,
            )
        24 ->
          productReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        else -> throw SerializationException("Unexpected index decoding InventoryItem: " + i)
      }
    }
    return InventoryItem(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) InventoryItem.InventoryItemStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on InventoryItem"),
      category = category ?: listOf(),
      code = code ?: listOf(),
      name = name ?: listOf(),
      responsibleOrganization = responsibleOrganization ?: listOf(),
      description = description,
      inventoryStatus = inventoryStatus ?: listOf(),
      baseUnit = baseUnit,
      netContent = netContent,
      association = association ?: listOf(),
      characteristic = characteristic ?: listOf(),
      instance = instance,
      productReference = productReference,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InventoryItem,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        InventoryItemNameSerializer.listSerializer,
        value.name,
      )
    if (value.responsibleOrganization.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        InventoryItemResponsibleOrganizationSerializer.listSerializer,
        value.responsibleOrganization,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      InventoryItemDescriptionSerializer,
      value.description,
    )
    if (value.inventoryStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.inventoryStatus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.baseUnit,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      QuantitySerializer,
      value.netContent,
    )
    if (value.association.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        InventoryItemAssociationSerializer.listSerializer,
        value.association,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        InventoryItemCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      InventoryItemInstanceSerializer,
      value.instance,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.productReference,
    )
  }
}
