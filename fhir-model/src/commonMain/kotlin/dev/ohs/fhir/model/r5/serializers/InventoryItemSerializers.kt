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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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

  override fun deserialize(decoder: Decoder): InventoryItem.Name =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Name) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.Name {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var nameType: Coding? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
          nameType = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.nameTypeSer, null)
        4 -> language = decoder.decodeStringElement(__desc, 4)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.languageSer, null)
        6 -> name = decoder.decodeStringElement(__desc, 6)
        7 -> _name = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Name: " + __i)
      }
    }
    return InventoryItem.Name(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      nameType = nameType!!,
      language = Enumeration.of(InventoryItem.CommonLanguages.fromCode(language!!), _language),
      name = R5String.of(name, _name)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem.Name) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.nameType)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.nameTypeSer, it) }
    ((value.language.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.language.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.languageSer, it)
    }
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameTypeSer: KSerializer<Coding> = Coding.serializer()

    public val languageSer: KSerializer<Element> = Element.serializer()
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

  override fun deserialize(decoder: Decoder): InventoryItem.ResponsibleOrganization =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.ResponsibleOrganization) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.ResponsibleOrganization {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var organization: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.organizationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ResponsibleOrganization: " + __i)
      }
    }
    return InventoryItem.ResponsibleOrganization(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role!!,
      organization = organization!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: InventoryItem.ResponsibleOrganization,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, it) }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.organizationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val organizationSer: KSerializer<Reference> = Reference.serializer()
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

  override fun deserialize(decoder: Decoder): InventoryItem.Description =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Description) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.Description {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> language = decoder.decodeStringElement(__desc, 3)
        4 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.languageSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.languageSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Description: " + __i)
      }
    }
    return InventoryItem.Description(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      language =
        language?.let { Enumeration.of(InventoryItem.CommonLanguages.fromCode(it), _language) },
      description = R5String.of(description, _description),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem.Description) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.language?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.languageSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.languageSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val languageSer: KSerializer<Element> = Element.serializer()
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

  override fun deserialize(decoder: Decoder): InventoryItem.Association =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Association) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.Association {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var associationType: CodeableConcept? = null
    var relatedItem: Reference? = null
    var quantity: Ratio? = null
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
          associationType =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.associationTypeSer, null)
        4 ->
          relatedItem =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.relatedItemSer, null)
        5 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.quantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Association: " + __i)
      }
    }
    return InventoryItem.Association(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      associationType = associationType!!,
      relatedItem = relatedItem!!,
      quantity = quantity!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem.Association) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.associationType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.associationTypeSer, it)
    }
    (value.relatedItem)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.relatedItemSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.quantitySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val associationTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val relatedItemSer: KSerializer<Reference> = Reference.serializer()

    public val quantitySer: KSerializer<Ratio> = Ratio.serializer()
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
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
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

  override fun deserialize(decoder: Decoder): InventoryItem.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.Characteristic {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var characteristicType: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDecimal: BigDecimal? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          characteristicType =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.characteristicTypeSer,
              null,
            )
        4 -> valueString = decoder.decodeStringElement(__desc, 4)
        5 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueStringSer, null)
        6 -> valueInteger = decoder.decodeIntElement(__desc, 6)
        7 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueStringSer, null)
        8 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueStringSer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueStringSer, null)
        12 -> valueUrl = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueUrl =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueStringSer, null)
        14 -> valueDateTime = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.valueStringSer, null)
        16 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueQuantitySer, null)
        17 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueRangeSer, null)
        18 ->
          valueRatio =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valueRatioSer, null)
        19 ->
          valueAnnotation =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.valueAnnotationSer, null)
        20 ->
          valueAddress =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.valueAddressSer, null)
        21 ->
          valueDuration =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.valueDurationSer, null)
        22 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              22,
              Hoisted.characteristicTypeSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return InventoryItem.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      characteristicType = characteristicType!!,
      `value` =
        InventoryItem.Characteristic.Value.from(
          R5String.of(valueString, _valueString),
          Integer.of(valueInteger, _valueInteger),
          Decimal.of(valueDecimal, _valueDecimal),
          R5Boolean.of(valueBoolean, _valueBoolean),
          Url.of(valueUrl, _valueUrl),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          valueQuantity,
          valueRange,
          valueRatio,
          valueAnnotation,
          valueAddress,
          valueDuration,
          valueCodeableConcept,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem.Characteristic) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.characteristicType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.characteristicTypeSer, it)
    }
    when (val __d = value.`value`) {
      null -> {}
      is InventoryItem.Characteristic.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 11, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Url -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.valueStringSer, it)
        }
      }
      is InventoryItem.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.valueQuantitySer, __d.value)
      }
      is InventoryItem.Characteristic.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.valueRangeSer, __d.value)
      }
      is InventoryItem.Characteristic.Value.Ratio -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.valueRatioSer, __d.value)
      }
      is InventoryItem.Characteristic.Value.Annotation -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.valueAnnotationSer, __d.value)
      }
      is InventoryItem.Characteristic.Value.Address -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.valueAddressSer, __d.value)
      }
      is InventoryItem.Characteristic.Value.Duration -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.valueDurationSer, __d.value)
      }
      is InventoryItem.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.characteristicTypeSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val characteristicTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val valueAnnotationSer: KSerializer<Annotation> = Annotation.serializer()

    public val valueAddressSer: KSerializer<Address> = Address.serializer()

    public val valueDurationSer: KSerializer<Duration> = Duration.serializer()
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

  override fun deserialize(decoder: Decoder): InventoryItem.Instance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem.Instance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): InventoryItem.Instance {
    val __desc = descriptor
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
        4 -> lotNumber = decoder.decodeStringElement(__desc, 4)
        5 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.lotNumberSer, null)
        6 -> expiry = decoder.decodeStringElement(__desc, 6)
        7 ->
          _expiry = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.lotNumberSer, null)
        8 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.subjectSer, null)
        9 ->
          location = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.subjectSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + __i)
      }
    }
    return InventoryItem.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expiry = DateTime.of(FhirDateTime.fromString(expiry), _expiry),
      subject = subject,
      location = location,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem.Instance) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.lotNumberSer, it)
    }
    ((value.expiry?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.expiry?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.lotNumberSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.subjectSer, it) }
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.subjectSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val lotNumberSer: KSerializer<Element> = Element.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object InventoryItemSerializer : KSerializer<InventoryItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InventoryItem") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "name",
        listSerialDescriptor(lazyDescriptor { InventoryItem.Name.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "responsibleOrganization",
        listSerialDescriptor(
          lazyDescriptor { InventoryItem.ResponsibleOrganization.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "description",
        lazyDescriptor { InventoryItem.Description.serializer().descriptor },
        isOptional = true,
      )
      element(
        "inventoryStatus",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("baseUnit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("netContent", Quantity.serializer().descriptor, isOptional = true)
      element(
        "association",
        listSerialDescriptor(lazyDescriptor { InventoryItem.Association.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { InventoryItem.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "instance",
        lazyDescriptor { InventoryItem.Instance.serializer().descriptor },
        isOptional = true,
      )
      element("productReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InventoryItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: InventoryItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): InventoryItem {
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 ->
          code = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 -> name = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.nameSer, null)
        17 ->
          responsibleOrganization =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.responsibleOrganizationSer,
              null,
            )
        18 ->
          description =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.descriptionSer, null)
        19 ->
          inventoryStatus =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.categorySer, null)
        20 ->
          baseUnit =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.categorySerInner, null)
        21 ->
          netContent =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.netContentSer, null)
        22 ->
          association =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.associationSer, null)
        23 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.characteristicSer, null)
        24 ->
          instance =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.instanceSer, null)
        25 ->
          productReference =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.productReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding InventoryItem: " + __i)
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
      status = Enumeration.of(InventoryItem.InventoryItemStatusCodes.fromCode(status!!), _status),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: InventoryItem) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "InventoryItem")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, value.category)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.code)
    if (value.name.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.nameSer, value.name)
    if (value.responsibleOrganization.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        17,
        Hoisted.responsibleOrganizationSer,
        value.responsibleOrganization,
      )
    (value.description)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.descriptionSer, it)
    }
    if (value.inventoryStatus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.categorySer, value.inventoryStatus)
    (value.baseUnit)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.categorySerInner, it)
    }
    (value.netContent)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.netContentSer, it)
    }
    if (value.association.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.associationSer, value.association)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.characteristicSer, value.characteristic)
    (value.instance)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.instanceSer, it) }
    (value.productReference)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.productReferenceSer, it)
    }
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

    public val categorySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.categorySerInner)

    public val nameSerInner: KSerializer<InventoryItem.Name> = InventoryItem.Name.serializer()

    public val nameSer: KSerializer<List<InventoryItem.Name>> = ListSerializer(Hoisted.nameSerInner)

    public val responsibleOrganizationSerInner: KSerializer<InventoryItem.ResponsibleOrganization> =
      InventoryItem.ResponsibleOrganization.serializer()

    public val responsibleOrganizationSer:
      KSerializer<List<InventoryItem.ResponsibleOrganization>> =
      ListSerializer(Hoisted.responsibleOrganizationSerInner)

    public val descriptionSer: KSerializer<InventoryItem.Description> =
      InventoryItem.Description.serializer()

    public val netContentSer: KSerializer<Quantity> = Quantity.serializer()

    public val associationSerInner: KSerializer<InventoryItem.Association> =
      InventoryItem.Association.serializer()

    public val associationSer: KSerializer<List<InventoryItem.Association>> =
      ListSerializer(Hoisted.associationSerInner)

    public val characteristicSerInner: KSerializer<InventoryItem.Characteristic> =
      InventoryItem.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<InventoryItem.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)

    public val instanceSer: KSerializer<InventoryItem.Instance> =
      InventoryItem.Instance.serializer()

    public val productReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}
