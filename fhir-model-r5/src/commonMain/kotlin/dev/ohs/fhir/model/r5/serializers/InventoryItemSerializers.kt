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
      element("nameType", Coding.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Name>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Name =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Name) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryItem.Name {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nameType: Coding? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          nameType =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + i)
      }
    }
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
        Enumeration.of(language?.let { InventoryItem.CommonLanguages.fromCode(it) }, _language)
          ?: throw SerializationException(
            "Missing required property 'language' on InventoryItem.Name"
          ),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on InventoryItem.Name"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InventoryItem.Name) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.nameType)
    ((value.language.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.language.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
  }
}

internal object InventoryItemResponsibleOrganizationSerializer :
  KSerializer<InventoryItem.ResponsibleOrganization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ResponsibleOrganization") {
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
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("organization", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.ResponsibleOrganization>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.ResponsibleOrganization =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.ResponsibleOrganization) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): InventoryItem.ResponsibleOrganization {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var organization: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          organization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ResponsibleOrganization: " + i)
      }
    }
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InventoryItem.ResponsibleOrganization,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.role)
    encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.organization)
  }
}

internal object InventoryItemDescriptionSerializer : KSerializer<InventoryItem.Description> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Description") {
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
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Description>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Description =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Description) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryItem.Description {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> language = decoder.decodeStringElement(descriptor, i)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Description: " + i)
      }
    }
    return InventoryItem.Description(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language =
        Enumeration.of(language?.let { InventoryItem.CommonLanguages.fromCode(it) }, _language),
      description = R5String.of(description, _description),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InventoryItem.Description) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.language?.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object InventoryItemAssociationSerializer : KSerializer<InventoryItem.Association> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Association") {
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
      element("associationType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("relatedItem", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Ratio.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Association>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Association =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Association) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryItem.Association {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var associationType: CodeableConcept? = null
    var relatedItem: Reference? = null
    var quantity: Ratio? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          associationType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          relatedItem =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        5 ->
          quantity = decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Association: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InventoryItem.Association) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.associationType,
    )
    encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.relatedItem)
    encoder.encodeSerializableElement(descriptor, 5, RatioSerializer, value.quantity)
  }
}

internal object InventoryItemCharacteristicSerializer : KSerializer<InventoryItem.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("characteristicType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUrl", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueRatio", Ratio.serializer().descriptor, isOptional = true)
      element("valueAnnotation", Annotation.serializer().descriptor, isOptional = true)
      element("valueAddress", Address.serializer().descriptor, isOptional = true)
      element("valueDuration", Duration.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Characteristic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryItem.Characteristic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          characteristicType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> valueString = decoder.decodeStringElement(descriptor, i)
        5 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        9 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 -> valueUrl = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        17 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        18 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        19 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(descriptor, i, AnnotationSerializer, null)
        20 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        21 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        22 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
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
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InventoryItem.Characteristic) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.characteristicType,
    )
    when (val choice = value.`value`) {
      is InventoryItem.Characteristic.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 8, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, ElementSerializer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 16, QuantitySerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 17, RangeSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 18, RatioSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Annotation -> {
        encoder.encodeSerializableElement(descriptor, 19, AnnotationSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Address -> {
        encoder.encodeSerializableElement(descriptor, 20, AddressSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.Duration -> {
        encoder.encodeSerializableElement(descriptor, 21, DurationSerializer, choice.value)
      }
      is InventoryItem.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 22, CodeableConceptSerializer, choice.value)
      }
    }
  }
}

internal object InventoryItemInstanceSerializer : KSerializer<InventoryItem.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
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
      element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_lotNumber", Element.serializer().descriptor, isOptional = true)
      element("expiry", KotlinString.serializer().descriptor, isOptional = true)
      element("_expiry", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<InventoryItem.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InventoryItem.Instance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Instance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InventoryItem.Instance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        5 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 -> expiry = decoder.decodeStringElement(descriptor, i)
        7 ->
          _expiry =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        9 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    return InventoryItem.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expiry = DateTime.of(expiry?.let { FhirDateTime.fromString(it) }, _expiry),
      subject = subject,
      location = location,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InventoryItem.Instance) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    ((value.expiry?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.expiry?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, it)
    }
  }
}

internal object InventoryItemSerializer : KSerializer<InventoryItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryItem") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "code",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "name",
      listSerialDescriptor(lazyDescriptor { InventoryItem.Name.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "responsibleOrganization",
      listSerialDescriptor(
        lazyDescriptor { InventoryItem.ResponsibleOrganization.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "description",
      lazyDescriptor { InventoryItem.Description.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "inventoryStatus",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("baseUnit", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("netContent", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "association",
      listSerialDescriptor(lazyDescriptor { InventoryItem.Association.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(lazyDescriptor { InventoryItem.Characteristic.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "instance",
      lazyDescriptor { InventoryItem.Instance.serializer().descriptor },
      isOptional = true,
    )
    b.element("productReference", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): InventoryItem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: InventoryItem) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "InventoryItem")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        Enumeration.of(status?.let { InventoryItem.InventoryItemStatusCodes.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on InventoryItem"),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InventoryItem,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
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
    (value.description)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        InventoryItemDescriptionSerializer,
        it,
      )
    }
    if (value.inventoryStatus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.inventoryStatus,
      )
    (value.baseUnit)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.netContent)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, QuantitySerializer, it)
    }
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
    (value.instance)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        InventoryItemInstanceSerializer,
        it,
      )
    }
    (value.productReference)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, ReferenceSerializer, it)
    }
  }
}

internal object InventoryItemPolymorphicSerializer : KSerializer<InventoryItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryItem") { InventoryItemSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem) {
    encoder.encodeStructure(descriptor) {
      InventoryItemSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): InventoryItem =
    decoder.decodeStructure(descriptor) {
      InventoryItemSerializer.deserializeInternal(this, descriptor, 0)
    }
}
