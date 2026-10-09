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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
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
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.NutritionOrder
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.RequestIntent
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.RequestStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object NutritionOrderOralDietSerializer : FhirSerializer<NutritionOrder.OralDiet> {
  override val descriptor: SerialDescriptor = buildDescriptor("OralDiet", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("schedule", NutritionOrderOralDietScheduleSerializer.descriptor)
    b.optionalElement(
      "nutrient",
      NutritionOrderOralDietNutrientSerializer.listSerializer.descriptor,
    )
    b.optionalElement("texture", NutritionOrderOralDietTextureSerializer.listSerializer.descriptor)
    b.optionalElement("fluidConsistencyType", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("instruction")
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var schedule: NutritionOrder.OralDiet.Schedule? = null
    var nutrient: List<NutritionOrder.OralDiet.Nutrient>? = null
    var texture: List<NutritionOrder.OralDiet.Texture>? = null
    var fluidConsistencyType: List<CodeableConcept>? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
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
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          schedule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietScheduleSerializer,
              null,
            )
        5 ->
          nutrient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietNutrientSerializer.listSerializer,
              null,
            )
        6 ->
          texture =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietTextureSerializer.listSerializer,
              null,
            )
        7 ->
          fluidConsistencyType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 -> instruction = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _instruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.OralDiet(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = listOrEmpty(type),
      schedule = schedule,
      nutrient = listOrEmpty(nutrient),
      texture = listOrEmpty(texture),
      fluidConsistencyType = listOrEmpty(fluidConsistencyType),
      instruction = R5String.of(instruction, _instruction),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableConceptSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      NutritionOrderOralDietScheduleSerializer,
      value.schedule,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      NutritionOrderOralDietNutrientSerializer.listSerializer,
      value.nutrient,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      NutritionOrderOralDietTextureSerializer.listSerializer,
      value.texture,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.fluidConsistencyType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.instruction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.instruction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderOralDietScheduleSerializer :
  FhirSerializer<NutritionOrder.OralDiet.Schedule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Schedule", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Schedule>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("timing", TimingSerializer.listSerializer.descriptor)
    b.boolPrim("asNeeded")
    b.optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Schedule {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var timing: List<Timing>? = null
    var asNeeded: KotlinBoolean? = null
    var _asNeeded: Element? = null
    var asNeededFor: CodeableConcept? = null
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
          timing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer.listSerializer,
              null,
            )
        4 -> asNeeded = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _asNeeded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          asNeededFor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.OralDiet.Schedule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      timing = listOrEmpty(timing),
      asNeeded = R5Boolean.of(asNeeded, _asNeeded),
      asNeededFor = asNeededFor,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Schedule) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TimingSerializer.listSerializer,
      value.timing,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.asNeeded)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.asNeededFor,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderOralDietNutrientSerializer :
  FhirSerializer<NutritionOrder.OralDiet.Nutrient> {
  override val descriptor: SerialDescriptor = buildDescriptor("Nutrient", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Nutrient>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.descriptor)
    b.optionalElement("amount", QuantitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Nutrient {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var amount: Quantity? = null
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
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.OralDiet.Nutrient(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      modifier = modifier,
      amount = amount,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Nutrient) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.modifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderOralDietTextureSerializer :
  FhirSerializer<NutritionOrder.OralDiet.Texture> {
  override val descriptor: SerialDescriptor = buildDescriptor("Texture", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Texture>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.descriptor)
    b.optionalElement("foodType", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Texture {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var modifier: CodeableConcept? = null
    var foodType: CodeableConcept? = null
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
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          foodType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.OralDiet.Texture(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      modifier = modifier,
      foodType = foodType,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Texture) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.modifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.foodType,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderSupplementSerializer : FhirSerializer<NutritionOrder.Supplement> {
  override val descriptor: SerialDescriptor = buildDescriptor("Supplement", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.Supplement>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableReferenceSerializer.descriptor)
    b.strPrim("productName")
    b.optionalElement("schedule", NutritionOrderSupplementScheduleSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.strPrim("instruction")
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.Supplement {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableReference? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var schedule: NutritionOrder.Supplement.Schedule? = null
    var quantity: Quantity? = null
    var instruction: KotlinString? = null
    var _instruction: Element? = null
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
              CodeableReferenceSerializer,
              null,
            )
        4 -> productName = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _productName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          schedule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderSupplementScheduleSerializer,
              null,
            )
        7 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        8 -> instruction = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _instruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.Supplement(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      productName = R5String.of(productName, _productName),
      schedule = schedule,
      quantity = quantity,
      instruction = R5String.of(instruction, _instruction),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.productName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.productName)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      NutritionOrderSupplementScheduleSerializer,
      value.schedule,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.quantity)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.instruction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.instruction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderSupplementScheduleSerializer :
  FhirSerializer<NutritionOrder.Supplement.Schedule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Schedule", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.Supplement.Schedule>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("timing", TimingSerializer.listSerializer.descriptor)
    b.boolPrim("asNeeded")
    b.optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.Supplement.Schedule {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var timing: List<Timing>? = null
    var asNeeded: KotlinBoolean? = null
    var _asNeeded: Element? = null
    var asNeededFor: CodeableConcept? = null
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
          timing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer.listSerializer,
              null,
            )
        4 -> asNeeded = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _asNeeded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          asNeededFor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.Supplement.Schedule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      timing = listOrEmpty(timing),
      asNeeded = R5Boolean.of(asNeeded, _asNeeded),
      asNeededFor = asNeededFor,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement.Schedule) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TimingSerializer.listSerializer,
      value.timing,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.asNeeded)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.asNeededFor,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderEnteralFormulaSerializer :
  FhirSerializer<NutritionOrder.EnteralFormula> {
  override val descriptor: SerialDescriptor = buildDescriptor("EnteralFormula", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("baseFormulaType", CodeableReferenceSerializer.descriptor)
    b.strPrim("baseFormulaProductName")
    b.optionalElement("deliveryDevice", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "additive",
      NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer.descriptor,
    )
    b.optionalElement("caloricDensity", QuantitySerializer.descriptor)
    b.optionalElement("routeOfAdministration", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "administration",
      NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("maxVolumeToDeliver", QuantitySerializer.descriptor)
    b.strPrim("administrationInstruction")
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var baseFormulaType: CodeableReference? = null
    var baseFormulaProductName: KotlinString? = null
    var _baseFormulaProductName: Element? = null
    var deliveryDevice: List<CodeableReference>? = null
    var additive: List<NutritionOrder.EnteralFormula.Additive>? = null
    var caloricDensity: Quantity? = null
    var routeOfAdministration: CodeableConcept? = null
    var administration: List<NutritionOrder.EnteralFormula.Administration>? = null
    var maxVolumeToDeliver: Quantity? = null
    var administrationInstruction: KotlinString? = null
    var _administrationInstruction: Element? = null
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
          baseFormulaType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 -> baseFormulaProductName = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _baseFormulaProductName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          deliveryDevice =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          additive =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer,
              null,
            )
        8 ->
          caloricDensity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          routeOfAdministration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          administration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
              null,
            )
        11 ->
          maxVolumeToDeliver =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        12 -> administrationInstruction = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _administrationInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.EnteralFormula(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      baseFormulaType = baseFormulaType,
      baseFormulaProductName = R5String.of(baseFormulaProductName, _baseFormulaProductName),
      deliveryDevice = listOrEmpty(deliveryDevice),
      additive = listOrEmpty(additive),
      caloricDensity = caloricDensity,
      routeOfAdministration = routeOfAdministration,
      administration = listOrEmpty(administration),
      maxVolumeToDeliver = maxVolumeToDeliver,
      administrationInstruction =
        Markdown.of(administrationInstruction, _administrationInstruction),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.baseFormulaType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.baseFormulaProductName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.baseFormulaProductName)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CodeableReferenceSerializer.listSerializer,
      value.deliveryDevice,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer,
      value.additive,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      QuantitySerializer,
      value.caloricDensity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.routeOfAdministration,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
      value.administration,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      QuantitySerializer,
      value.maxVolumeToDeliver,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.administrationInstruction?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.administrationInstruction)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderEnteralFormulaAdditiveSerializer :
  FhirSerializer<NutritionOrder.EnteralFormula.Additive> {
  override val descriptor: SerialDescriptor = buildDescriptor("Additive", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula.Additive>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableReferenceSerializer.descriptor)
    b.strPrim("productName")
    b.optionalElement("quantity", QuantitySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula.Additive {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableReference? = null
    var productName: KotlinString? = null
    var _productName: Element? = null
    var quantity: Quantity? = null
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
              CodeableReferenceSerializer,
              null,
            )
        4 -> productName = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _productName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.EnteralFormula.Additive(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      productName = R5String.of(productName, _productName),
      quantity = quantity,
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Additive) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.productName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.productName)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.quantity)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderEnteralFormulaAdministrationSerializer :
  FhirSerializer<NutritionOrder.EnteralFormula.Administration> {
  override val descriptor: SerialDescriptor = buildDescriptor("Administration", this)

  @JvmField
  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula.Administration>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "schedule",
      NutritionOrderEnteralFormulaAdministrationScheduleSerializer.descriptor,
    )
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("rateQuantity", QuantitySerializer.descriptor)
    b.optionalElement("rateRatio", RatioSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula.Administration {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var schedule: NutritionOrder.EnteralFormula.Administration.Schedule? = null
    var quantity: Quantity? = null
    var rateQuantity: Quantity? = null
    var rateRatio: Ratio? = null
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
          schedule =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaAdministrationScheduleSerializer,
              null,
            )
        4 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          rateQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          rateRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.EnteralFormula.Administration(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      schedule = schedule,
      quantity = quantity,
      rate = NutritionOrder.EnteralFormula.Administration.Rate.from(rateQuantity, rateRatio),
    )
  }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Administration) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      NutritionOrderEnteralFormulaAdministrationScheduleSerializer,
      value.schedule,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.quantity)
    when (val choice = value.rate) {
      null -> {}
      is NutritionOrder.EnteralFormula.Administration.Rate.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
      }
      is NutritionOrder.EnteralFormula.Administration.Rate.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, RatioSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderEnteralFormulaAdministrationScheduleSerializer :
  FhirSerializer<NutritionOrder.EnteralFormula.Administration.Schedule> {
  override val descriptor: SerialDescriptor = buildDescriptor("Schedule", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<NutritionOrder.EnteralFormula.Administration.Schedule>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("timing", TimingSerializer.listSerializer.descriptor)
    b.boolPrim("asNeeded")
    b.optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): NutritionOrder.EnteralFormula.Administration.Schedule {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var timing: List<Timing>? = null
    var asNeeded: KotlinBoolean? = null
    var _asNeeded: Element? = null
    var asNeededFor: CodeableConcept? = null
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
          timing =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer.listSerializer,
              null,
            )
        4 -> asNeeded = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _asNeeded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          asNeededFor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return NutritionOrder.EnteralFormula.Administration.Schedule(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      timing = listOrEmpty(timing),
      asNeeded = R5Boolean.of(asNeeded, _asNeeded),
      asNeededFor = asNeededFor,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: NutritionOrder.EnteralFormula.Administration.Schedule,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TimingSerializer.listSerializer,
      value.timing,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.asNeeded)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.asNeededFor,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object NutritionOrderSerializer : FhirResourceSerializer<NutritionOrder> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("NutritionOrder")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrimList("instantiatesCanonical")
    b.strPrimList("instantiatesUri")
    b.strPrimList("instantiates")
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.strPrim("status")
    b.strPrim("intent")
    b.strPrim("priority")
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("dateTime")
    b.optionalElement("orderer", ReferenceSerializer.descriptor)
    b.optionalElement("performer", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("allergyIntolerance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("foodPreferenceModifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("excludeFoodModifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.boolPrim("outsideFoodAllowed")
    b.optionalElement("oralDiet", NutritionOrderOralDietSerializer.descriptor)
    b.optionalElement("supplement", NutritionOrderSupplementSerializer.listSerializer.descriptor)
    b.optionalElement("enteralFormula", NutritionOrderEnteralFormulaSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var basedOn: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: RequestStatus? = null
    var _status: Element? = null
    var intent: RequestIntent? = null
    var _intent: Element? = null
    var priority: RequestPriority? = null
    var _priority: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var dateTime: FhirDateTime? = null
    var _dateTime: Element? = null
    var orderer: Reference? = null
    var performer: List<CodeableReference>? = null
    var allergyIntolerance: List<Reference>? = null
    var foodPreferenceModifier: List<CodeableConcept>? = null
    var excludeFoodModifier: List<CodeableConcept>? = null
    var outsideFoodAllowed: KotlinBoolean? = null
    var _outsideFoodAllowed: Element? = null
    var oralDiet: NutritionOrder.OralDiet? = null
    var supplement: List<NutritionOrder.Supplement>? = null
    var enteralFormula: NutritionOrder.EnteralFormula? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          instantiates =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        16 ->
          _instantiates =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        17 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          groupIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        19 -> status = RequestStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> intent = RequestIntent.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _intent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          priority = RequestPriority.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        26 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 ->
          supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          dateTime = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _dateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          orderer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        31 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          allergyIntolerance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          foodPreferenceModifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        34 ->
          excludeFoodModifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> outsideFoodAllowed = compositeDecoder.decodeBooleanElement(descriptor, i)
        36 ->
          _outsideFoodAllowed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 ->
          oralDiet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietSerializer,
              null,
            )
        38 ->
          supplement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderSupplementSerializer.listSerializer,
              null,
            )
        39 ->
          enteralFormula =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaSerializer,
              null,
            )
        40 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val instantiatesCanonical_ =
      List(maxSize(instantiatesCanonical, _instantiatesCanonical)) { index ->
        entryRequired(
          Canonical.of(at(instantiatesCanonical, index), at(_instantiatesCanonical, index)),
          "NutritionOrder",
          "instantiatesCanonical",
        )
      }
    val instantiatesUri_ =
      List(maxSize(instantiatesUri, _instantiatesUri)) { index ->
        entryRequired(
          Uri.of(at(instantiatesUri, index), at(_instantiatesUri, index)),
          "NutritionOrder",
          "instantiatesUri",
        )
      }
    val instantiates_ =
      List(maxSize(instantiates, _instantiates)) { index ->
        entryRequired(
          Uri.of(at(instantiates, index), at(_instantiates, index)),
          "NutritionOrder",
          "instantiates",
        )
      }
    return NutritionOrder(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instantiatesCanonical = instantiatesCanonical_,
      instantiatesUri = instantiatesUri_,
      instantiates = instantiates_,
      basedOn = listOrEmpty(basedOn),
      groupIdentifier = groupIdentifier,
      status = required(Enumeration.of(status, _status), "NutritionOrder", "status"),
      intent = required(Enumeration.of(intent, _intent), "NutritionOrder", "intent"),
      priority = Enumeration.of(priority, _priority),
      subject = required(subject, "NutritionOrder", "subject"),
      encounter = encounter,
      supportingInformation = listOrEmpty(supportingInformation),
      dateTime = required(DateTime.of(dateTime, _dateTime), "NutritionOrder", "dateTime"),
      orderer = orderer,
      performer = listOrEmpty(performer),
      allergyIntolerance = listOrEmpty(allergyIntolerance),
      foodPreferenceModifier = listOrEmpty(foodPreferenceModifier),
      excludeFoodModifier = listOrEmpty(excludeFoodModifier),
      outsideFoodAllowed = R5Boolean.of(outsideFoodAllowed, _outsideFoodAllowed),
      oralDiet = oralDiet,
      supplement = listOrEmpty(supplement),
      enteralFormula = enteralFormula,
      note = listOrEmpty(note),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionOrder,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    if (!value.instantiatesCanonical.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (!value.instantiatesUri.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.instantiatesUri,
      )
    }
    if (!value.instantiates.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        15 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiates.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        16 + descriptorOffset,
        value.instantiates,
      )
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.intent.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.intent)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.priority?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.priority)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.supportingInformation,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.dateTime.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.dateTime)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.orderer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.performer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.allergyIntolerance,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.foodPreferenceModifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.excludeFoodModifier,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.outsideFoodAllowed?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.outsideFoodAllowed,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      NutritionOrderOralDietSerializer,
      value.oralDiet,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      38 + descriptorOffset,
      NutritionOrderSupplementSerializer.listSerializer,
      value.supplement,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      NutritionOrderEnteralFormulaSerializer,
      value.enteralFormula,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
  }
}
