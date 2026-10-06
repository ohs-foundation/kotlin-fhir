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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CodeableReference
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.NutritionProduct
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
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

  override fun deserialize(decoder: Decoder): NutritionProduct.Nutrient =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var item: CodeableReference? = null
      var amount: List<Ratio>? = null
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
          4 ->
            amount =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer.listSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Nutrient: " + i)
        }
      }
      NutritionProduct.Nutrient(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        item = item,
        amount = amount ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Nutrient) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.item)
      if (value.amount.isNotEmpty())
        encodeSerializableElement(descriptor, 4, RatioSerializer.listSerializer, value.amount)
    }
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

  override fun deserialize(decoder: Decoder): NutritionProduct.Ingredient =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var item: CodeableReference? = null
      var amount: List<Ratio>? = null
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
          4 ->
            amount =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer.listSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
        }
      }
      NutritionProduct.Ingredient(
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
      if (value.amount.isNotEmpty())
        encodeSerializableElement(descriptor, 4, RatioSerializer.listSerializer, value.amount)
    }
  }
}

internal object NutritionProductProductCharacteristicSerializer :
  KSerializer<NutritionProduct.ProductCharacteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProductCharacteristic") {
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

  internal val listSerializer: KSerializer<List<NutritionProduct.ProductCharacteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.ProductCharacteristic =
    decoder.decodeStructure(descriptor) {
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
          5 -> valueString = decodeStringElement(descriptor, i)
          6 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 -> valueBase64Binary = decodeStringElement(descriptor, i)
          9 ->
            _valueBase64Binary =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          11 -> valueBoolean = decodeBooleanElement(descriptor, i)
          12 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ProductCharacteristic: " + i)
        }
      }
      NutritionProduct.ProductCharacteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on NutritionProduct.ProductCharacteristic"
            ),
        `value` =
          NutritionProduct.ProductCharacteristic.Value.from(
            valueCodeableConcept,
            R4bString.of(valueString, _valueString),
            valueQuantity,
            Base64Binary.of(valueBase64Binary, _valueBase64Binary),
            valueAttachment,
            R4bBoolean.of(valueBoolean, _valueBoolean),
          )
            ?: throw SerializationException(
              "Missing required property 'value' on NutritionProduct.ProductCharacteristic"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.ProductCharacteristic) {
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
        is NutritionProduct.ProductCharacteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is NutritionProduct.ProductCharacteristic.Value.String -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is NutritionProduct.ProductCharacteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 7, QuantitySerializer, choice.value)
        }
        is NutritionProduct.ProductCharacteristic.Value.Base64Binary -> {
          encodeStringIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is NutritionProduct.ProductCharacteristic.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
        is NutritionProduct.ProductCharacteristic.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
      }
    }
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
      optionalElement("lotNumber", KotlinString.serializer().descriptor)
      optionalElement("_lotNumber", ElementSerializer.descriptor)
      optionalElement("expiry", KotlinString.serializer().descriptor)
      optionalElement("_expiry", ElementSerializer.descriptor)
      optionalElement("useBy", KotlinString.serializer().descriptor)
      optionalElement("_useBy", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionProduct.Instance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionProduct.Instance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var quantity: Quantity? = null
      var identifier: List<Identifier>? = null
      var lotNumber: KotlinString? = null
      var _lotNumber: Element? = null
      var expiry: KotlinString? = null
      var _expiry: Element? = null
      var useBy: KotlinString? = null
      var _useBy: Element? = null
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
          3 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          5 -> lotNumber = decodeStringElement(descriptor, i)
          6 ->
            _lotNumber = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> expiry = decodeStringElement(descriptor, i)
          8 -> _expiry = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> useBy = decodeStringElement(descriptor, i)
          10 -> _useBy = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Instance: " + i)
        }
      }
      NutritionProduct.Instance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        quantity = quantity,
        identifier = identifier ?: listOf(),
        lotNumber = R4bString.of(lotNumber, _lotNumber),
        expiry =
          DateTime.of(if (expiry != null) FhirDateTime.fromString(expiry) else null, _expiry),
        useBy = DateTime.of(if (useBy != null) FhirDateTime.fromString(useBy) else null, _useBy),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Instance) {
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
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.quantity)
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeStringIfNotNull(descriptor, 5, value.lotNumber?.value)
      encodeElementIfNotNull(descriptor, 6, value.lotNumber)
      encodeStringIfNotNull(descriptor, 7, value.expiry?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.expiry)
      encodeStringIfNotNull(descriptor, 9, value.useBy?.value?.toString())
      encodeElementIfNotNull(descriptor, 10, value.useBy)
    }
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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("nutrient", NutritionProductNutrientSerializer.listSerializer.descriptor)
    b.optionalElement("ingredient", NutritionProductIngredientSerializer.listSerializer.descriptor)
    b.optionalElement("knownAllergen", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "productCharacteristic",
      NutritionProductProductCharacteristicSerializer.listSerializer.descriptor,
    )
    b.optionalElement("instance", NutritionProductInstanceSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var status: KotlinString? = null
    var _status: Element? = null
    var category: List<CodeableConcept>? = null
    var code: CodeableConcept? = null
    var manufacturer: List<Reference>? = null
    var nutrient: List<NutritionProduct.Nutrient>? = null
    var ingredient: List<NutritionProduct.Ingredient>? = null
    var knownAllergen: List<CodeableReference>? = null
    var productCharacteristic: List<NutritionProduct.ProductCharacteristic>? = null
    var instance: NutritionProduct.Instance? = null
    var note: List<Annotation>? = null
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
        10 -> status = decoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          nutrient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductNutrientSerializer.listSerializer,
              null,
            )
        16 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductIngredientSerializer.listSerializer,
              null,
            )
        17 ->
          knownAllergen =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          productCharacteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductProductCharacteristicSerializer.listSerializer,
              null,
            )
        19 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionProductInstanceSerializer,
              null,
            )
        20 ->
          note =
            decoder.decodeNullableSerializableElement(
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
      status =
        Enumeration.of(
          if (status != null) NutritionProduct.NutritionProductStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on NutritionProduct"),
      category = category ?: listOf(),
      code = code,
      manufacturer = manufacturer ?: listOf(),
      nutrient = nutrient ?: listOf(),
      ingredient = ingredient ?: listOf(),
      knownAllergen = knownAllergen ?: listOf(),
      productCharacteristic = productCharacteristic ?: listOf(),
      instance = instance,
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionProduct,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.status)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.nutrient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        NutritionProductNutrientSerializer.listSerializer,
        value.nutrient,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        NutritionProductIngredientSerializer.listSerializer,
        value.ingredient,
      )
    if (value.knownAllergen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.knownAllergen,
      )
    if (value.productCharacteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        NutritionProductProductCharacteristicSerializer.listSerializer,
        value.productCharacteristic,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      NutritionProductInstanceSerializer,
      value.instance,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
