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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.NutritionProductStatus
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

internal object NutritionProductNutrientSerializer : KSerializer<NutritionProduct.Nutrient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Nutrient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
      optionalElement("amount", RatioSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionProduct.Nutrient>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.Nutrient {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: List<Ratio>? = null
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
              RatioSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Nutrient: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionProduct.Nutrient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item,
      amount = amount ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Nutrient) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.item,
    )
    if (value.amount.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        RatioSerializer.listSerializer,
        value.amount,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionProductIngredientSerializer : KSerializer<NutritionProduct.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("item", CodeableReferenceSerializer.descriptor)
      optionalElement("amount", RatioSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionProduct.Ingredient>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.Ingredient {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: List<Ratio>? = null
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
              RatioSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionProduct.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item =
        item
          ?: throw SerializationException(
            "Missing required property 'item' on NutritionProduct.Ingredient"
          ),
      amount = amount ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Ingredient) {
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
      CodeableReferenceSerializer,
      value.item,
    )
    if (value.amount.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        RatioSerializer.listSerializer,
        value.amount,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionProductCharacteristicSerializer :
  KSerializer<NutritionProduct.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueBase64Binary", KotlinString.serializer().descriptor)
      optionalElement("_valueBase64Binary", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionProduct.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.Characteristic {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueQuantity: Quantity? = null
    var valueBase64Binary: KotlinString? = null
    var _valueBase64Binary: Element? = null
    var valueAttachment: Attachment? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
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
        5 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 -> valueBase64Binary = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _valueBase64Binary =
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
        11 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionProduct.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on NutritionProduct.Characteristic"
          ),
      `value` =
        NutritionProduct.Characteristic.Value.from(
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          valueQuantity,
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          valueAttachment,
          R5Boolean.of(valueBoolean, _valueBoolean),
        )
          ?: throw SerializationException(
            "Missing required property 'value' on NutritionProduct.Characteristic"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Characteristic) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`value`) {
      is NutritionProduct.Characteristic.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is NutritionProduct.Characteristic.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is NutritionProduct.Characteristic.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
      }
      is NutritionProduct.Characteristic.Value.Base64Binary -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 8, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 9, choice.value)
      }
      is NutritionProduct.Characteristic.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          10,
          AttachmentSerializer,
          choice.value,
        )
      }
      is NutritionProduct.Characteristic.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionProductInstanceSerializer : KSerializer<NutritionProduct.Instance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Instance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("lotNumber", KotlinString.serializer().descriptor)
      optionalElement("_lotNumber", ElementSerializer.descriptor)
      optionalElement("expiry", KotlinString.serializer().descriptor)
      optionalElement("_expiry", ElementSerializer.descriptor)
      optionalElement("useBy", KotlinString.serializer().descriptor)
      optionalElement("_useBy", ElementSerializer.descriptor)
      optionalElement("biologicalSourceEvent", IdentifierSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionProduct.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.Instance {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var quantity: Quantity? = null
    var identifier: List<Identifier>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var lotNumber: KotlinString? = null
    var _lotNumber: Element? = null
    var expiry: KotlinString? = null
    var _expiry: Element? = null
    var useBy: KotlinString? = null
    var _useBy: Element? = null
    var biologicalSourceEvent: Identifier? = null
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
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        4 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        5 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> lotNumber = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _lotNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> expiry = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _expiry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> useBy = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _useBy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          biologicalSourceEvent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionProduct.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity,
      identifier = identifier ?: listOf(),
      name = R5String.of(name, _name),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expiry = DateTime.of(if (expiry != null) FhirDateTime.fromString(expiry) else null, _expiry),
      useBy = DateTime.of(if (useBy != null) FhirDateTime.fromString(useBy) else null, _useBy),
      biologicalSourceEvent = biologicalSourceEvent,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Instance) {
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.quantity)
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.lotNumber?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.lotNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.expiry?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.expiry)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.useBy?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.useBy)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      IdentifierSerializer,
      value.biologicalSourceEvent,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionProductSerializer : FhirResourceSerializer<NutritionProduct> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("NutritionProduct")

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
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("nutrient", NutritionProductNutrientSerializer.listSerializer.descriptor)
    b.optionalElement("ingredient", NutritionProductIngredientSerializer.listSerializer.descriptor)
    b.optionalElement("knownAllergen", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      NutritionProductCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("instance", NutritionProductInstanceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): NutritionProduct {
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
    var code: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var manufacturer: List<Reference>? = null
    var nutrient: List<NutritionProduct.Nutrient>? = null
    var ingredient: List<NutritionProduct.Ingredient>? = null
    var knownAllergen: List<CodeableReference>? = null
    var characteristic: List<NutritionProduct.Characteristic>? = null
    var instance: List<NutritionProduct.Instance>? = null
    var note: List<Annotation>? = null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          nutrient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductNutrientSerializer.listSerializer,
              null,
            )
        16 ->
          ingredient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductIngredientSerializer.listSerializer,
              null,
            )
        17 ->
          knownAllergen =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductCharacteristicSerializer.listSerializer,
              null,
            )
        19 ->
          instance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductInstanceSerializer.listSerializer,
              null,
            )
        20 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding NutritionProduct: " + i)
      }
    }
    return NutritionProduct(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code,
      status =
        Enumeration.of(
          if (status != null) NutritionProductStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on NutritionProduct"),
      category = category ?: listOf(),
      manufacturer = manufacturer ?: listOf(),
      nutrient = nutrient ?: listOf(),
      ingredient = ingredient ?: listOf(),
      knownAllergen = knownAllergen ?: listOf(),
      characteristic = characteristic ?: listOf(),
      instance = instance ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionProduct,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
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
    if (value.manufacturer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.nutrient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        NutritionProductNutrientSerializer.listSerializer,
        value.nutrient,
      )
    if (value.ingredient.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        NutritionProductIngredientSerializer.listSerializer,
        value.ingredient,
      )
    if (value.knownAllergen.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.knownAllergen,
      )
    if (value.characteristic.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        NutritionProductCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
    if (value.instance.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        NutritionProductInstanceSerializer.listSerializer,
        value.instance,
      )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
