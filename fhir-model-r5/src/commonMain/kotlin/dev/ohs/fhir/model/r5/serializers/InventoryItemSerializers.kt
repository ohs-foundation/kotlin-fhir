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
import dev.ohs.fhir.model.r5.terminologies.CommonLanguages
import dev.ohs.fhir.model.r5.terminologies.InventoryItemStatusCodes
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

  override fun deserialize(decoder: Decoder): InventoryItem.Name {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nameType: Coding? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
          nameType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
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
        6 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.Name(
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
          if (language != null) CommonLanguages.fromCode(language) else null,
          _language,
        )
          ?: throw SerializationException(
            "Missing required property 'language' on InventoryItem.Name"
          ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on InventoryItem.Name"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Name) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.nameType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.language.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.language)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.name)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): InventoryItem.ResponsibleOrganization {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var organization: Reference? = null
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
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          organization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ResponsibleOrganization: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.ResponsibleOrganization(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.role)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      ReferenceSerializer,
      value.organization,
    )
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): InventoryItem.Description {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
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
        3 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Description: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.Description(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language =
        Enumeration.of(
          if (language != null) CommonLanguages.fromCode(language) else null,
          _language,
        ),
      description = R5String.of(description, _description),
    )
  }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Description) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.language?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.language)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): InventoryItem.Association {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var associationType: CodeableConcept? = null
    var relatedItem: Reference? = null
    var quantity: Ratio? = null
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
          associationType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          relatedItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Association: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.Association(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.associationType,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      ReferenceSerializer,
      value.relatedItem,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 5, RatioSerializer, value.quantity)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          characteristicType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        9 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueUrl = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _valueUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> valueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        17 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        18 ->
          valueRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        19 ->
          valueAnnotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer,
              null,
            )
        20 ->
          valueAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        21 ->
          valueDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        22 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.Characteristic(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.characteristicType,
    )
    when (val choice = value.`value`) {
      is InventoryItem.Characteristic.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is InventoryItem.Characteristic.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is InventoryItem.Characteristic.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          8,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is InventoryItem.Characteristic.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is InventoryItem.Characteristic.Value.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is InventoryItem.Characteristic.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is InventoryItem.Characteristic.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 16, QuantitySerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 17, RangeSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 18, RatioSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Annotation -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19,
          AnnotationSerializer,
          choice.value,
        )
      }
      is InventoryItem.Characteristic.Value.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, AddressSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, DurationSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          22,
          CodeableConceptSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): InventoryItem.Instance {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        4 -> lotNumber = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _lotNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> expiry = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _expiry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return InventoryItem.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expiry = DateTime.of(if (expiry != null) FhirDateTime.fromString(expiry) else null, _expiry),
      subject = subject,
      location = location,
    )
  }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Instance) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.lotNumber?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.lotNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.expiry?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.expiry)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.subject)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.location)
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemNameSerializer.listSerializer,
              null,
            )
        16 ->
          responsibleOrganization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemResponsibleOrganizationSerializer.listSerializer,
              null,
            )
        17 ->
          description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemDescriptionSerializer,
              null,
            )
        18 ->
          inventoryStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          baseUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          netContent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        21 ->
          association =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemAssociationSerializer.listSerializer,
              null,
            )
        22 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemCharacteristicSerializer.listSerializer,
              null,
            )
        23 ->
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InventoryItemInstanceSerializer,
              null,
            )
        24 ->
          productReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
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
          if (status != null) InventoryItemStatusCodes.fromCode(status) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InventoryItem,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.code.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    if (value.name.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        InventoryItemNameSerializer.listSerializer,
        value.name,
      )
    if (value.responsibleOrganization.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        InventoryItemResponsibleOrganizationSerializer.listSerializer,
        value.responsibleOrganization,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      InventoryItemDescriptionSerializer,
      value.description,
    )
    if (value.inventoryStatus.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.inventoryStatus,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.baseUnit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      QuantitySerializer,
      value.netContent,
    )
    if (value.association.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        InventoryItemAssociationSerializer.listSerializer,
        value.association,
      )
    if (value.characteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        InventoryItemCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      InventoryItemInstanceSerializer,
      value.instance,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.productReference,
    )
  }
}
