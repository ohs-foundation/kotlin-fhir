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

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.NutritionOrder
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionOrder.OralDiet {
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
          schedule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scheduleSer, null)
        5 ->
          nutrient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nutrientSer, null)
        6 ->
          texture =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textureSer, null)
        7 ->
          fluidConsistencyType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> instruction = decoder.decodeStringElement(descriptor, i)
        9 ->
          _instruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.instructionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding OralDiet: " + i)
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
      instruction = R4String.of(instruction, _instruction),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionOrder.OralDiet) {
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
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.scheduleSer, value.schedule)
    if (value.nutrient.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nutrientSer, value.nutrient)
    if (value.texture.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.textureSer, value.texture)
    if (value.fluidConsistencyType.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, value.fluidConsistencyType)
    ((value.instruction?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.instructionSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Nutrient) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionOrder.OralDiet.Nutrient {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var amount: Quantity? = null
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
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        4 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Nutrient: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: NutritionOrder.OralDiet.Nutrient,
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
    (value.modifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.modifierSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.amountSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Texture) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionOrder.OralDiet.Texture {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var foodType: CodeableConcept? = null
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
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        4 ->
          foodType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Texture: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: NutritionOrder.OralDiet.Texture,
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
    (value.modifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.modifierSer, it)
    }
    (value.foodType)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modifierSer, it)
    }
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionOrder.Supplement {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> productName = decoder.decodeStringElement(descriptor, i)
        5 ->
          _productName =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productNameSer, null)
        6 ->
          schedule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scheduleSer, null)
        7 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        8 -> instruction = decoder.decodeStringElement(descriptor, i)
        9 ->
          _instruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.productNameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Supplement: " + i)
      }
    }
    return NutritionOrder.Supplement(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      productName = R4String.of(productName, _productName),
      schedule = schedule ?: listOf(),
      quantity = quantity,
      instruction = R4String.of(instruction, _instruction),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionOrder.Supplement) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.productName?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.productName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.productNameSer, it)
    }
    if (value.schedule.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.scheduleSer, value.schedule)
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.quantitySer, it)
    }
    ((value.instruction?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.instruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.productNameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): NutritionOrder.EnteralFormula {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          baseFormulaType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaTypeSer,
              null,
            )
        4 -> baseFormulaProductName = decoder.decodeStringElement(descriptor, i)
        5 ->
          _baseFormulaProductName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        6 ->
          additiveType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaTypeSer,
              null,
            )
        7 -> additiveProductName = decoder.decodeStringElement(descriptor, i)
        8 ->
          _additiveProductName =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        9 ->
          caloricDensity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.caloricDensitySer,
              null,
            )
        10 ->
          routeofAdministration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaTypeSer,
              null,
            )
        11 ->
          administration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.administrationSer,
              null,
            )
        12 ->
          maxVolumeToDeliver =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.caloricDensitySer,
              null,
            )
        13 -> administrationInstruction = decoder.decodeStringElement(descriptor, i)
        14 ->
          _administrationInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.baseFormulaProductNameSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EnteralFormula: " + i)
      }
    }
    return NutritionOrder.EnteralFormula(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      baseFormulaType = baseFormulaType,
      baseFormulaProductName = R4String.of(baseFormulaProductName, _baseFormulaProductName),
      additiveType = additiveType,
      additiveProductName = R4String.of(additiveProductName, _additiveProductName),
      caloricDensity = caloricDensity,
      routeofAdministration = routeofAdministration,
      administration = administration ?: listOf(),
      maxVolumeToDeliver = maxVolumeToDeliver,
      administrationInstruction = R4String.of(administrationInstruction, _administrationInstruction),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: NutritionOrder.EnteralFormula) {
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
    (value.baseFormulaType)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.baseFormulaTypeSer, it)
    }
    ((value.baseFormulaProductName?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.baseFormulaProductName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.baseFormulaProductNameSer, it)
    }
    (value.additiveType)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.baseFormulaTypeSer, it)
    }
    ((value.additiveProductName?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.additiveProductName?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.baseFormulaProductNameSer, it)
    }
    (value.caloricDensity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.caloricDensitySer, it)
    }
    (value.routeofAdministration)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.baseFormulaTypeSer, it)
    }
    if (value.administration.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        Hoisted.administrationSer,
        value.administration,
      )
    (value.maxVolumeToDeliver)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.caloricDensitySer, it)
    }
    ((value.administrationInstruction?.value))?.let {
      encoder.encodeStringElement(descriptor, 13, it)
    }
    (value.administrationInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.baseFormulaProductNameSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Administration) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): NutritionOrder.EnteralFormula.Administration {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: Timing? = null
    var quantity: Quantity? = null
    var rateQuantity: Quantity? = null
    var rateRatio: Ratio? = null
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
          schedule =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scheduleSer, null)
        4 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        5 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        6 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rateRatioSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Administration: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: NutritionOrder.EnteralFormula.Administration,
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
    (value.schedule)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.scheduleSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.quantitySer, it)
    }
    when (val __d = value.rate) {
      null -> {}
      is NutritionOrder.EnteralFormula.Administration.Rate.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.quantitySer, __d.value)
      }
      is NutritionOrder.EnteralFormula.Administration.Rate.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.rateRatioSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "NutritionOrder")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): NutritionOrder {
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        15 ->
          instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        16 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer2,
              null,
            )
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> intent = decoder.decodeStringElement(descriptor, i)
        20 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        23 -> dateTime = decoder.decodeStringElement(descriptor, i)
        24 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          orderer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        26 ->
          allergyIntolerance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allergyIntoleranceSer,
              null,
            )
        27 ->
          foodPreferenceModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.foodPreferenceModifierSer,
              null,
            )
        28 ->
          excludeFoodModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.foodPreferenceModifierSer,
              null,
            )
        29 ->
          oralDiet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.oralDietSer, null)
        30 ->
          supplement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.supplementSer, null)
        31 ->
          enteralFormula =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.enteralFormulaSer,
              null,
            )
        32 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding NutritionOrder: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionOrder,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    (value.instantiatesCanonical.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesCanonical.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    (value.instantiatesUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiatesUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    (value.instantiates.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.instantiates.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer2,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.intent.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.intent.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.patientSer, it)
    }
    ((value.dateTime.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.dateTime.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.orderer)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.allergyIntolerance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.allergyIntoleranceSer,
        value.allergyIntolerance,
      )
    if (value.foodPreferenceModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.foodPreferenceModifierSer,
        value.foodPreferenceModifier,
      )
    if (value.excludeFoodModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.foodPreferenceModifierSer,
        value.excludeFoodModifier,
      )
    (value.oralDiet)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.oralDietSer, it)
    }
    if (value.supplement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.supplementSer,
        value.supplement,
      )
    (value.enteralFormula)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.enteralFormulaSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
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
      NutritionOrderSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): NutritionOrder =
    decoder.decodeStructure(descriptor) {
      NutritionOrderSerializer.deserializeInternal(this, descriptor, 0)
    }
}
