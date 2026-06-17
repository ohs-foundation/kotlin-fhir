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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.NutritionProduct
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("amount", listSerialDescriptor(Ratio.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionProduct.Nutrient =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Nutrient) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionProduct.Nutrient {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: List<Ratio>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Nutrient: " + i)
      }
    }
    return NutritionProduct.Nutrient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item,
      amount = amount ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionProduct.Nutrient) {
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
    (value.item)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemSer, it) }
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, value.amount)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val amountSerInner: KSerializer<Ratio> = Ratio.serializer()

    public val amountSer: KSerializer<List<Ratio>> = ListSerializer(Hoisted.amountSerInner)
  }
}

internal object NutritionProductIngredientSerializer : KSerializer<NutritionProduct.Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
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
      element("item", CodeableReference.serializer().descriptor, isOptional = true)
      element("amount", listSerialDescriptor(Ratio.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionProduct.Ingredient =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Ingredient) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionProduct.Ingredient {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var item: CodeableReference? = null
    var amount: List<Ratio>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    return NutritionProduct.Ingredient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      item = item!!,
      amount = amount ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionProduct.Ingredient) {
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.itemSer, value.item)
    if (value.amount.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, value.amount)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val itemSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val amountSerInner: KSerializer<Ratio> = Ratio.serializer()

    public val amountSer: KSerializer<List<Ratio>> = ListSerializer(Hoisted.amountSerInner)
  }
}

internal object NutritionProductCharacteristicSerializer :
  KSerializer<NutritionProduct.Characteristic> {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueBase64Binary", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueBase64Binary", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionProduct.Characteristic =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Characteristic) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionProduct.Characteristic {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> valueString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        7 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        8 -> valueBase64Binary = decoder.decodeStringElement(descriptor, i)
        9 ->
          _valueBase64Binary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        11 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
      }
    }
    return NutritionProduct.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        NutritionProduct.Characteristic.Value.from(
          valueCodeableConcept,
          R5String.of(valueString, _valueString),
          valueQuantity,
          Base64Binary.of(valueBase64Binary, _valueBase64Binary),
          valueAttachment,
          R5Boolean.of(valueBoolean, _valueBoolean),
        )!!,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: NutritionProduct.Characteristic,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.`value`) {
      is NutritionProduct.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, choice.value)
      }
      is NutritionProduct.Characteristic.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueStringSer, it)
        }
      }
      is NutritionProduct.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueQuantitySer, choice.value)
      }
      is NutritionProduct.Characteristic.Value.Base64Binary -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueStringSer, it)
        }
      }
      is NutritionProduct.Characteristic.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueAttachmentSer, choice.value)
      }
      is NutritionProduct.Characteristic.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueStringSer, it)
        }
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueStringSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object NutritionProductInstanceSerializer : KSerializer<NutritionProduct.Instance> {
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("lotNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_lotNumber", Element.serializer().descriptor, isOptional = true)
      element("expiry", KotlinString.serializer().descriptor, isOptional = true)
      element("_expiry", Element.serializer().descriptor, isOptional = true)
      element("useBy", KotlinString.serializer().descriptor, isOptional = true)
      element("_useBy", Element.serializer().descriptor, isOptional = true)
      element("biologicalSourceEvent", Identifier.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionProduct.Instance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Instance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionProduct.Instance {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        4 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 -> name = decoder.decodeStringElement(descriptor, i)
        6 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 -> lotNumber = decoder.decodeStringElement(descriptor, i)
        8 ->
          _lotNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        9 -> expiry = decoder.decodeStringElement(descriptor, i)
        10 ->
          _expiry = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        11 -> useBy = decoder.decodeStringElement(descriptor, i)
        12 ->
          _useBy = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        13 ->
          biologicalSourceEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Instance: " + i)
      }
    }
    return NutritionProduct.Instance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      quantity = quantity,
      identifier = identifier ?: listOf(),
      name = R5String.of(name, _name),
      lotNumber = R5String.of(lotNumber, _lotNumber),
      expiry = DateTime.of(FhirDateTime.fromString(expiry), _expiry),
      useBy = DateTime.of(FhirDateTime.fromString(useBy), _useBy),
      biologicalSourceEvent = biologicalSourceEvent,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionProduct.Instance) {
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
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.quantitySer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, value.identifier)
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    ((value.lotNumber?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.lotNumber?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.nameSer, it)
    }
    ((value.expiry?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.expiry?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.nameSer, it)
    }
    ((value.useBy?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.useBy?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.nameSer, it)
    }
    (value.biologicalSourceEvent)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.identifierSerInner, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}

internal object NutritionProductSerializer : KSerializer<NutritionProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionProduct") {
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
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "nutrient",
      listSerialDescriptor(lazyDescriptor { NutritionProduct.Nutrient.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "ingredient",
      listSerialDescriptor(lazyDescriptor { NutritionProduct.Ingredient.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "knownAllergen",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "characteristic",
      listSerialDescriptor(
        lazyDescriptor { NutritionProduct.Characteristic.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "instance",
      listSerialDescriptor(lazyDescriptor { NutritionProduct.Instance.serializer().descriptor }),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "NutritionProduct")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        10 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        15 ->
          nutrient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nutrientSer, null)
        16 ->
          ingredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        17 ->
          knownAllergen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.knownAllergenSer, null)
        18 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicSer,
              null,
            )
        19 ->
          instance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instanceSer, null)
        20 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
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
      status = Enumeration.of(NutritionProduct.NutritionProductStatus.fromCode(status!!), _status),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionProduct,
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
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 10 + descriptorOffset, Hoisted.codeSer, it)
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.categorySer,
        value.category,
      )
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.manufacturerSer,
        value.manufacturer,
      )
    if (value.nutrient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.nutrientSer,
        value.nutrient,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.ingredientSer,
        value.ingredient,
      )
    if (value.knownAllergen.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.knownAllergenSer,
        value.knownAllergen,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.characteristicSer,
        value.characteristic,
      )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.instanceSer,
        value.instance,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSer)

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val nutrientSerInner: KSerializer<NutritionProduct.Nutrient> =
      NutritionProduct.Nutrient.serializer()

    public val nutrientSer: KSerializer<List<NutritionProduct.Nutrient>> =
      ListSerializer(Hoisted.nutrientSerInner)

    public val ingredientSerInner: KSerializer<NutritionProduct.Ingredient> =
      NutritionProduct.Ingredient.serializer()

    public val ingredientSer: KSerializer<List<NutritionProduct.Ingredient>> =
      ListSerializer(Hoisted.ingredientSerInner)

    public val knownAllergenSerInner: KSerializer<CodeableReference> =
      CodeableReference.serializer()

    public val knownAllergenSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.knownAllergenSerInner)

    public val characteristicSerInner: KSerializer<NutritionProduct.Characteristic> =
      NutritionProduct.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<NutritionProduct.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)

    public val instanceSerInner: KSerializer<NutritionProduct.Instance> =
      NutritionProduct.Instance.serializer()

    public val instanceSer: KSerializer<List<NutritionProduct.Instance>> =
      ListSerializer(Hoisted.instanceSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object NutritionProductPolymorphicSerializer : KSerializer<NutritionProduct> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionProduct") {
      NutritionProductSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: NutritionProduct) {
    encoder.encodeStructure(descriptor) {
      NutritionProductSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): NutritionProduct =
    decoder.decodeStructure(descriptor) {
      NutritionProductSerializer.deserializeInternal(this, descriptor, 0)
    }
}
