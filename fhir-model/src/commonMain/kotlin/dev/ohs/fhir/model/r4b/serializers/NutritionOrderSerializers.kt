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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object NutritionOrderOralDietSerializer : KSerializer<NutritionOrder.OralDiet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OralDiet") {
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
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("schedule", listSerialDescriptor(Timing.serializer().descriptor), isOptional = true)
      element(
        "nutrient",
        listSerialDescriptor(
          lazyDescriptor { NutritionOrder.OralDiet.Nutrient.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "texture",
        listSerialDescriptor(
          lazyDescriptor { NutritionOrder.OralDiet.Texture.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "fluidConsistencyType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("instruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_instruction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionOrder.OralDiet {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var schedule: List<Timing>? = null
    var nutrient: List<NutritionOrder.OralDiet.Nutrient>? = null
    var texture: List<NutritionOrder.OralDiet.Texture>? = null
    var fluidConsistencyType: List<CodeableConcept>? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          schedule =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.scheduleSer, null)
        5 ->
          nutrient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.nutrientSer, null)
        6 ->
          texture = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textureSer, null)
        7 ->
          fluidConsistencyType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        8 -> instruction = decoder.decodeStringElement(__desc, __i)
        9 ->
          _instruction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.instructionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OralDiet: " + __i)
      }
    }
    return NutritionOrder.OralDiet(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      schedule = schedule ?: listOf(),
      nutrient = nutrient ?: listOf(),
      texture = texture ?: listOf(),
      fluidConsistencyType = fluidConsistencyType ?: listOf(),
      instruction = R4bString.of(instruction, _instruction),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionOrder.OralDiet) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, value.type)
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.scheduleSer, value.schedule)
    if (value.nutrient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.nutrientSer, value.nutrient)
    if (value.texture.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.textureSer, value.texture)
    if (value.fluidConsistencyType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, value.fluidConsistencyType)
    ((value.instruction?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.instructionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val scheduleSerInner: KSerializer<Timing> = Timing.serializer()

    public val scheduleSer: KSerializer<List<Timing>> = ListSerializer(Hoisted.scheduleSerInner)

    public val nutrientSerInner: KSerializer<NutritionOrder.OralDiet.Nutrient> =
      NutritionOrder.OralDiet.Nutrient.serializer()

    public val nutrientSer: KSerializer<List<NutritionOrder.OralDiet.Nutrient>> =
      ListSerializer(Hoisted.nutrientSerInner)

    public val textureSerInner: KSerializer<NutritionOrder.OralDiet.Texture> =
      NutritionOrder.OralDiet.Texture.serializer()

    public val textureSer: KSerializer<List<NutritionOrder.OralDiet.Texture>> =
      ListSerializer(Hoisted.textureSerInner)

    public val instructionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object NutritionOrderOralDietNutrientSerializer :
  KSerializer<NutritionOrder.OralDiet.Nutrient> {
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
      element("modifier", CodeableConcept.serializer().descriptor, isOptional = true)
      element("amount", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Nutrient =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Nutrient) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionOrder.OralDiet.Nutrient {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var amount: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modifierSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Nutrient: " + __i)
      }
    }
    return NutritionOrder.OralDiet.Nutrient(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      modifier = modifier,
      amount = amount,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionOrder.OralDiet.Nutrient) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.modifier)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.modifierSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modifierSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object NutritionOrderOralDietTextureSerializer :
  KSerializer<NutritionOrder.OralDiet.Texture> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Texture") {
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
      element("modifier", CodeableConcept.serializer().descriptor, isOptional = true)
      element("foodType", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Texture =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Texture) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionOrder.OralDiet.Texture {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var foodType: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          modifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modifierSer, null)
        4 ->
          foodType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.modifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Texture: " + __i)
      }
    }
    return NutritionOrder.OralDiet.Texture(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      modifier = modifier,
      foodType = foodType,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionOrder.OralDiet.Texture) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.modifier)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.modifierSer, it) }
    (value.foodType)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.modifierSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modifierSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object NutritionOrderSupplementSerializer : KSerializer<NutritionOrder.Supplement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Supplement") {
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
      element("productName", KotlinString.serializer().descriptor, isOptional = true)
      element("_productName", Element.serializer().descriptor, isOptional = true)
      element("schedule", listSerialDescriptor(Timing.serializer().descriptor), isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("instruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_instruction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.Supplement =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionOrder.Supplement {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var schedule: List<Timing>? = null
    var quantity: Quantity? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> productName = decoder.decodeStringElement(__desc, __i)
        5 ->
          _productName =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productNameSer, null)
        6 ->
          schedule =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.scheduleSer, null)
        7 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        8 -> instruction = decoder.decodeStringElement(__desc, __i)
        9 ->
          _instruction =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.productNameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Supplement: " + __i)
      }
    }
    return NutritionOrder.Supplement(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      productName = R4bString.of(productName, _productName),
      schedule = schedule ?: listOf(),
      quantity = quantity,
      instruction = R4bString.of(instruction, _instruction),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionOrder.Supplement) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    ((value.productName?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.productName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.productNameSer, it)
    }
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.scheduleSer, value.schedule)
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.quantitySer, it) }
    ((value.instruction?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.productNameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val productNameSer: KSerializer<Element> = Element.serializer()

    public val scheduleSerInner: KSerializer<Timing> = Timing.serializer()

    public val scheduleSer: KSerializer<List<Timing>> = ListSerializer(Hoisted.scheduleSerInner)

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object NutritionOrderEnteralFormulaSerializer :
  KSerializer<NutritionOrder.EnteralFormula> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnteralFormula") {
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
      element("baseFormulaType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("baseFormulaProductName", KotlinString.serializer().descriptor, isOptional = true)
      element("_baseFormulaProductName", Element.serializer().descriptor, isOptional = true)
      element("additiveType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("additiveProductName", KotlinString.serializer().descriptor, isOptional = true)
      element("_additiveProductName", Element.serializer().descriptor, isOptional = true)
      element("caloricDensity", Quantity.serializer().descriptor, isOptional = true)
      element("routeofAdministration", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "administration",
        listSerialDescriptor(
          lazyDescriptor { NutritionOrder.EnteralFormula.Administration.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("maxVolumeToDeliver", Quantity.serializer().descriptor, isOptional = true)
      element("administrationInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element("_administrationInstruction", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): NutritionOrder.EnteralFormula {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var baseFormulaType: CodeableConcept? = null
    var baseFormulaProductName: KotlinString? = null
    var _baseFormulaProductName: Element? = null
    var additiveType: CodeableConcept? = null
    var additiveProductName: KotlinString? = null
    var _additiveProductName: Element? = null
    var caloricDensity: Quantity? = null
    var routeofAdministration: CodeableConcept? = null
    var administration: List<NutritionOrder.EnteralFormula.Administration>? = null
    var maxVolumeToDeliver: Quantity? = null
    var administrationInstruction: KotlinString? = null
    var _administrationInstruction: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          baseFormulaType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.baseFormulaTypeSer, null)
        4 -> baseFormulaProductName = decoder.decodeStringElement(__desc, __i)
        5 ->
          _baseFormulaProductName =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        6 ->
          additiveType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.baseFormulaTypeSer, null)
        7 -> additiveProductName = decoder.decodeStringElement(__desc, __i)
        8 ->
          _additiveProductName =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        9 ->
          caloricDensity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.caloricDensitySer, null)
        10 ->
          routeofAdministration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.baseFormulaTypeSer, null)
        11 ->
          administration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.administrationSer, null)
        12 ->
          maxVolumeToDeliver =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.caloricDensitySer, null)
        13 -> administrationInstruction = decoder.decodeStringElement(__desc, __i)
        14 ->
          _administrationInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EnteralFormula: " + __i)
      }
    }
    return NutritionOrder.EnteralFormula(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      baseFormulaType = baseFormulaType,
      baseFormulaProductName = R4bString.of(baseFormulaProductName, _baseFormulaProductName),
      additiveType = additiveType,
      additiveProductName = R4bString.of(additiveProductName, _additiveProductName),
      caloricDensity = caloricDensity,
      routeofAdministration = routeofAdministration,
      administration = administration ?: listOf(),
      maxVolumeToDeliver = maxVolumeToDeliver,
      administrationInstruction =
        R4bString.of(administrationInstruction, _administrationInstruction),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: NutritionOrder.EnteralFormula) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.baseFormulaType)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.baseFormulaTypeSer, it)
    }
    ((value.baseFormulaProductName?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.baseFormulaProductName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.baseFormulaProductNameSer, it)
    }
    (value.additiveType)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.baseFormulaTypeSer, it)
    }
    ((value.additiveProductName?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.additiveProductName?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.baseFormulaProductNameSer, it)
    }
    (value.caloricDensity)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.caloricDensitySer, it)
    }
    (value.routeofAdministration)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.baseFormulaTypeSer, it)
    }
    if (value.administration.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.administrationSer, value.administration)
    (value.maxVolumeToDeliver)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.caloricDensitySer, it)
    }
    ((value.administrationInstruction?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.administrationInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.baseFormulaProductNameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val baseFormulaTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val baseFormulaProductNameSer: KSerializer<Element> = Element.serializer()

    public val caloricDensitySer: KSerializer<Quantity> = Quantity.serializer()

    public val administrationSerInner: KSerializer<NutritionOrder.EnteralFormula.Administration> =
      NutritionOrder.EnteralFormula.Administration.serializer()

    public val administrationSer: KSerializer<List<NutritionOrder.EnteralFormula.Administration>> =
      ListSerializer(Hoisted.administrationSerInner)
  }
}

internal object NutritionOrderEnteralFormulaAdministrationSerializer :
  KSerializer<NutritionOrder.EnteralFormula.Administration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Administration") {
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
      element("schedule", Timing.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("rateQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("rateRatio", Ratio.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula.Administration =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Administration) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): NutritionOrder.EnteralFormula.Administration {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: Timing? = null
    var quantity: Quantity? = null
    var rateQuantity: Quantity? = null
    var rateRatio: Ratio? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          schedule =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.scheduleSer, null)
        4 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        5 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        6 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.rateRatioSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Administration: " + __i)
      }
    }
    return NutritionOrder.EnteralFormula.Administration(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      schedule = schedule,
      quantity = quantity,
      rate = NutritionOrder.EnteralFormula.Administration.Rate.from(rateQuantity, rateRatio),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: NutritionOrder.EnteralFormula.Administration,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.schedule)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.scheduleSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.quantitySer, it) }
    when (val __d = value.rate) {
      null -> {}
      is NutritionOrder.EnteralFormula.Administration.Rate.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.quantitySer, __d.value)
      }
      is NutritionOrder.EnteralFormula.Administration.Rate.Ratio -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.rateRatioSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val scheduleSer: KSerializer<Timing> = Timing.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val rateRatioSer: KSerializer<Ratio> = Ratio.serializer()
  }
}

internal object NutritionOrderSerializer : KSerializer<NutritionOrder> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionOrder") {
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
    b.element(
      "instantiatesCanonical",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesCanonical",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiatesUri",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiatesUri",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "instantiates",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_instantiates",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("intent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_intent", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("dateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_dateTime", Element.serializer().descriptor, isOptional = true)
    b.element("orderer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "allergyIntolerance",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "foodPreferenceModifier",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "excludeFoodModifier",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "oralDiet",
      lazyDescriptor { NutritionOrder.OralDiet.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "supplement",
      listSerialDescriptor(lazyDescriptor { NutritionOrder.Supplement.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "enteralFormula",
      lazyDescriptor { NutritionOrder.EnteralFormula.serializer().descriptor },
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "NutritionOrder")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): NutritionOrder {
    val __desc = desc
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
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var instantiates: List<KotlinString?>? = null
    var _instantiates: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var dateTime: KotlinString? = null
    var _dateTime: Element? = null
    var orderer: Reference? = null
    var allergyIntolerance: List<Reference>? = null
    var foodPreferenceModifier: List<CodeableConcept>? = null
    var excludeFoodModifier: List<CodeableConcept>? = null
    var oralDiet: NutritionOrder.OralDiet? = null
    var supplement: List<NutritionOrder.Supplement>? = null
    var enteralFormula: NutritionOrder.EnteralFormula? = null
    var note: List<Annotation>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          instantiates =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        16 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        17 -> status = decoder.decodeStringElement(__desc, __i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> intent = decoder.decodeStringElement(__desc, __i)
        20 ->
          _intent =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          patient = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        22 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        23 -> dateTime = decoder.decodeStringElement(__desc, __i)
        24 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          orderer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.patientSer, null)
        26 ->
          allergyIntolerance =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.allergyIntoleranceSer,
              null,
            )
        27 ->
          foodPreferenceModifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.foodPreferenceModifierSer,
              null,
            )
        28 ->
          excludeFoodModifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.foodPreferenceModifierSer,
              null,
            )
        29 ->
          oralDiet =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.oralDietSer, null)
        30 ->
          supplement =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.supplementSer, null)
        31 ->
          enteralFormula =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.enteralFormulaSer, null)
        32 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding NutritionOrder: " + __i)
      }
    }
    return NutritionOrder(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { __i ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(__i)?.let { it },
            _instantiatesCanonical?.getOrNull(__i),
          )!!
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          __i ->
          Uri.of(instantiatesUri?.getOrNull(__i)?.let { it }, _instantiatesUri?.getOrNull(__i))!!
        }),
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { __i ->
          Uri.of(instantiates?.getOrNull(__i)?.let { it }, _instantiates?.getOrNull(__i))!!
        }),
      status = Enumeration.of(NutritionOrder.RequestStatus.fromCode(status!!), _status),
      intent = Enumeration.of(NutritionOrder.RequestIntent.fromCode(intent!!), _intent),
      patient = patient!!,
      encounter = encounter,
      dateTime = DateTime.of(FhirDateTime.fromString(dateTime), _dateTime)!!,
      orderer = orderer,
      allergyIntolerance = allergyIntolerance ?: listOf(),
      foodPreferenceModifier = foodPreferenceModifier ?: listOf(),
      excludeFoodModifier = excludeFoodModifier ?: listOf(),
      oralDiet = oralDiet,
      supplement = supplement ?: listOf(),
      enteralFormula = enteralFormula,
      note = note ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: NutritionOrder,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.instantiatesCanonicalSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.intent.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.patientSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.patientSer, it)
    }
    ((value.dateTime.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.dateTime.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.orderer)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.patientSer, it)
    }
    if (value.allergyIntolerance.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26 + __off,
        Hoisted.allergyIntoleranceSer,
        value.allergyIntolerance,
      )
    if (value.foodPreferenceModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        27 + __off,
        Hoisted.foodPreferenceModifierSer,
        value.foodPreferenceModifier,
      )
    if (value.excludeFoodModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        28 + __off,
        Hoisted.foodPreferenceModifierSer,
        value.excludeFoodModifier,
      )
    (value.oralDiet)?.let {
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.oralDietSer, it)
    }
    if (value.supplement.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30 + __off, Hoisted.supplementSer, value.supplement)
    (value.enteralFormula)?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.enteralFormulaSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32 + __off, Hoisted.noteSer, value.note)
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

    public val instantiatesCanonicalSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val instantiatesCanonicalSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.instantiatesCanonicalSerInner).nullable)

    public val instantiatesCanonicalSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val allergyIntoleranceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.patientSer)

    public val foodPreferenceModifierSerInner: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val foodPreferenceModifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.foodPreferenceModifierSerInner)

    public val oralDietSer: KSerializer<NutritionOrder.OralDiet> =
      NutritionOrder.OralDiet.serializer()

    public val supplementSerInner: KSerializer<NutritionOrder.Supplement> =
      NutritionOrder.Supplement.serializer()

    public val supplementSer: KSerializer<List<NutritionOrder.Supplement>> =
      ListSerializer(Hoisted.supplementSerInner)

    public val enteralFormulaSer: KSerializer<NutritionOrder.EnteralFormula> =
      NutritionOrder.EnteralFormula.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object NutritionOrderPolymorphicSerializer : KSerializer<NutritionOrder> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NutritionOrder") { NutritionOrderSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder) {
    encoder.encodeStructure(descriptor) {
      NutritionOrderSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): NutritionOrder =
    decoder.decodeStructure(descriptor) {
      NutritionOrderSerializer.deserializeJson(this, descriptor, 0)
    }
}
