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

internal object NutritionOrderOralDietSerializer : KSerializer<NutritionOrder.OralDiet> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("OralDiet") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("schedule", NutritionOrderOralDietScheduleSerializer.descriptor)
      optionalElement(
        "nutrient",
        NutritionOrderOralDietNutrientSerializer.listSerializer.descriptor,
      )
      optionalElement("texture", NutritionOrderOralDietTextureSerializer.listSerializer.descriptor)
      optionalElement("fluidConsistencyType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("instruction", KotlinString.serializer().descriptor)
      optionalElement("_instruction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet =
    decoder.decodeStructure(descriptor) {
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
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            schedule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderOralDietScheduleSerializer,
                null,
              )
          5 ->
            nutrient =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderOralDietNutrientSerializer.listSerializer,
                null,
              )
          6 ->
            texture =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderOralDietTextureSerializer.listSerializer,
                null,
              )
          7 ->
            fluidConsistencyType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> instruction = decodeStringElement(descriptor, i)
          9 ->
            _instruction = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding OralDiet: " + i)
        }
      }
      NutritionOrder.OralDiet(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type ?: listOf(),
        schedule = schedule,
        nutrient = nutrient ?: listOf(),
        texture = texture ?: listOf(),
        fluidConsistencyType = fluidConsistencyType ?: listOf(),
        instruction = R5String.of(instruction, _instruction),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet) {
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
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeSerializableIfNotNull(
        descriptor,
        4,
        NutritionOrderOralDietScheduleSerializer,
        value.schedule,
      )
      if (value.nutrient.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          NutritionOrderOralDietNutrientSerializer.listSerializer,
          value.nutrient,
        )
      if (value.texture.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          NutritionOrderOralDietTextureSerializer.listSerializer,
          value.texture,
        )
      if (value.fluidConsistencyType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.fluidConsistencyType,
        )
      encodeStringIfNotNull(descriptor, 8, value.instruction?.value)
      encodeElementIfNotNull(descriptor, 9, value.instruction)
    }
  }
}

internal object NutritionOrderOralDietScheduleSerializer :
  KSerializer<NutritionOrder.OralDiet.Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("timing", TimingSerializer.listSerializer.descriptor)
      optionalElement("asNeeded", KotlinBoolean.serializer().descriptor)
      optionalElement("_asNeeded", ElementSerializer.descriptor)
      optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Schedule>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Schedule =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var timing: List<Timing>? = null
      var asNeeded: KotlinBoolean? = null
      var _asNeeded: Element? = null
      var asNeededFor: CodeableConcept? = null
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
            timing =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TimingSerializer.listSerializer,
                null,
              )
          4 -> asNeeded = decodeBooleanElement(descriptor, i)
          5 -> _asNeeded = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            asNeededFor =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
        }
      }
      NutritionOrder.OralDiet.Schedule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        timing = timing ?: listOf(),
        asNeeded = R5Boolean.of(asNeeded, _asNeeded),
        asNeededFor = asNeededFor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Schedule) {
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
      if (value.timing.isNotEmpty())
        encodeSerializableElement(descriptor, 3, TimingSerializer.listSerializer, value.timing)
      encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
      encodeElementIfNotNull(descriptor, 5, value.asNeeded)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.asNeededFor)
    }
  }
}

internal object NutritionOrderOralDietNutrientSerializer :
  KSerializer<NutritionOrder.OralDiet.Nutrient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Nutrient") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.descriptor)
      optionalElement("amount", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Nutrient>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Nutrient =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var modifier: CodeableConcept? = null
      var amount: Quantity? = null
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
            modifier =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> amount = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Nutrient: " + i)
        }
      }
      NutritionOrder.OralDiet.Nutrient(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        modifier = modifier,
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Nutrient) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.modifier)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.amount)
    }
  }
}

internal object NutritionOrderOralDietTextureSerializer :
  KSerializer<NutritionOrder.OralDiet.Texture> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Texture") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.descriptor)
      optionalElement("foodType", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.OralDiet.Texture>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.OralDiet.Texture =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var modifier: CodeableConcept? = null
      var foodType: CodeableConcept? = null
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
            modifier =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            foodType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Texture: " + i)
        }
      }
      NutritionOrder.OralDiet.Texture(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        modifier = modifier,
        foodType = foodType,
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.OralDiet.Texture) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.modifier)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.foodType)
    }
  }
}

internal object NutritionOrderSupplementSerializer : KSerializer<NutritionOrder.Supplement> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Supplement") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableReferenceSerializer.descriptor)
      optionalElement("productName", KotlinString.serializer().descriptor)
      optionalElement("_productName", ElementSerializer.descriptor)
      optionalElement("schedule", NutritionOrderSupplementScheduleSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("instruction", KotlinString.serializer().descriptor)
      optionalElement("_instruction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.Supplement>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.Supplement =
    decoder.decodeStructure(descriptor) {
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
            type =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 -> productName = decodeStringElement(descriptor, i)
          5 ->
            _productName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            schedule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderSupplementScheduleSerializer,
                null,
              )
          7 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          8 -> instruction = decodeStringElement(descriptor, i)
          9 ->
            _instruction = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Supplement: " + i)
        }
      }
      NutritionOrder.Supplement(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        productName = R5String.of(productName, _productName),
        schedule = schedule,
        quantity = quantity,
        instruction = R5String.of(instruction, _instruction),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.productName?.value)
      encodeElementIfNotNull(descriptor, 5, value.productName)
      encodeSerializableIfNotNull(
        descriptor,
        6,
        NutritionOrderSupplementScheduleSerializer,
        value.schedule,
      )
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.quantity)
      encodeStringIfNotNull(descriptor, 8, value.instruction?.value)
      encodeElementIfNotNull(descriptor, 9, value.instruction)
    }
  }
}

internal object NutritionOrderSupplementScheduleSerializer :
  KSerializer<NutritionOrder.Supplement.Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("timing", TimingSerializer.listSerializer.descriptor)
      optionalElement("asNeeded", KotlinBoolean.serializer().descriptor)
      optionalElement("_asNeeded", ElementSerializer.descriptor)
      optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.Supplement.Schedule>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.Supplement.Schedule =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var timing: List<Timing>? = null
      var asNeeded: KotlinBoolean? = null
      var _asNeeded: Element? = null
      var asNeededFor: CodeableConcept? = null
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
            timing =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TimingSerializer.listSerializer,
                null,
              )
          4 -> asNeeded = decodeBooleanElement(descriptor, i)
          5 -> _asNeeded = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            asNeededFor =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
        }
      }
      NutritionOrder.Supplement.Schedule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        timing = timing ?: listOf(),
        asNeeded = R5Boolean.of(asNeeded, _asNeeded),
        asNeededFor = asNeededFor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.Supplement.Schedule) {
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
      if (value.timing.isNotEmpty())
        encodeSerializableElement(descriptor, 3, TimingSerializer.listSerializer, value.timing)
      encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
      encodeElementIfNotNull(descriptor, 5, value.asNeeded)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.asNeededFor)
    }
  }
}

internal object NutritionOrderEnteralFormulaSerializer :
  KSerializer<NutritionOrder.EnteralFormula> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnteralFormula") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("baseFormulaType", CodeableReferenceSerializer.descriptor)
      optionalElement("baseFormulaProductName", KotlinString.serializer().descriptor)
      optionalElement("_baseFormulaProductName", ElementSerializer.descriptor)
      optionalElement("deliveryDevice", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "additive",
        NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer.descriptor,
      )
      optionalElement("caloricDensity", QuantitySerializer.descriptor)
      optionalElement("routeOfAdministration", CodeableConceptSerializer.descriptor)
      optionalElement(
        "administration",
        NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer.descriptor,
      )
      optionalElement("maxVolumeToDeliver", QuantitySerializer.descriptor)
      optionalElement("administrationInstruction", KotlinString.serializer().descriptor)
      optionalElement("_administrationInstruction", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula =
    decoder.decodeStructure(descriptor) {
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
            baseFormulaType =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 -> baseFormulaProductName = decodeStringElement(descriptor, i)
          5 ->
            _baseFormulaProductName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            deliveryDevice =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          7 ->
            additive =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer,
                null,
              )
          8 ->
            caloricDensity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 ->
            routeOfAdministration =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            administration =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
                null,
              )
          11 ->
            maxVolumeToDeliver =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          12 -> administrationInstruction = decodeStringElement(descriptor, i)
          13 ->
            _administrationInstruction =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding EnteralFormula: " + i)
        }
      }
      NutritionOrder.EnteralFormula(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        baseFormulaType = baseFormulaType,
        baseFormulaProductName = R5String.of(baseFormulaProductName, _baseFormulaProductName),
        deliveryDevice = deliveryDevice ?: listOf(),
        additive = additive ?: listOf(),
        caloricDensity = caloricDensity,
        routeOfAdministration = routeOfAdministration,
        administration = administration ?: listOf(),
        maxVolumeToDeliver = maxVolumeToDeliver,
        administrationInstruction =
          Markdown.of(administrationInstruction, _administrationInstruction),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.baseFormulaType)
      encodeStringIfNotNull(descriptor, 4, value.baseFormulaProductName?.value)
      encodeElementIfNotNull(descriptor, 5, value.baseFormulaProductName)
      if (value.deliveryDevice.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableReferenceSerializer.listSerializer,
          value.deliveryDevice,
        )
      if (value.additive.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          NutritionOrderEnteralFormulaAdditiveSerializer.listSerializer,
          value.additive,
        )
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.caloricDensity)
      encodeSerializableIfNotNull(
        descriptor,
        9,
        CodeableConceptSerializer,
        value.routeOfAdministration,
      )
      if (value.administration.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
          value.administration,
        )
      encodeSerializableIfNotNull(descriptor, 11, QuantitySerializer, value.maxVolumeToDeliver)
      encodeStringIfNotNull(descriptor, 12, value.administrationInstruction?.value)
      encodeElementIfNotNull(descriptor, 13, value.administrationInstruction)
    }
  }
}

internal object NutritionOrderEnteralFormulaAdditiveSerializer :
  KSerializer<NutritionOrder.EnteralFormula.Additive> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Additive") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableReferenceSerializer.descriptor)
      optionalElement("productName", KotlinString.serializer().descriptor)
      optionalElement("_productName", ElementSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula.Additive>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula.Additive =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableReference? = null
      var productName: KotlinString? = null
      var _productName: Element? = null
      var quantity: Quantity? = null
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
            type =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 -> productName = decodeStringElement(descriptor, i)
          5 ->
            _productName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Additive: " + i)
        }
      }
      NutritionOrder.EnteralFormula.Additive(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        productName = R5String.of(productName, _productName),
        quantity = quantity,
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Additive) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableReferenceSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.productName?.value)
      encodeElementIfNotNull(descriptor, 5, value.productName)
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.quantity)
    }
  }
}

internal object NutritionOrderEnteralFormulaAdministrationSerializer :
  KSerializer<NutritionOrder.EnteralFormula.Administration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Administration") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "schedule",
        NutritionOrderEnteralFormulaAdministrationScheduleSerializer.descriptor,
      )
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("rateQuantity", QuantitySerializer.descriptor)
      optionalElement("rateRatio", RatioSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<NutritionOrder.EnteralFormula.Administration>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): NutritionOrder.EnteralFormula.Administration =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var schedule: NutritionOrder.EnteralFormula.Administration.Schedule? = null
      var quantity: Quantity? = null
      var rateQuantity: Quantity? = null
      var rateRatio: Ratio? = null
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
            schedule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderEnteralFormulaAdministrationScheduleSerializer,
                null,
              )
          4 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            rateQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> rateRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Administration: " + i)
        }
      }
      NutritionOrder.EnteralFormula.Administration(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        schedule = schedule,
        quantity = quantity,
        rate = NutritionOrder.EnteralFormula.Administration.Rate.from(rateQuantity, rateRatio),
      )
    }

  override fun serialize(encoder: Encoder, `value`: NutritionOrder.EnteralFormula.Administration) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        NutritionOrderEnteralFormulaAdministrationScheduleSerializer,
        value.schedule,
      )
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.quantity)
      when (val choice = value.rate) {
        null -> {}
        is NutritionOrder.EnteralFormula.Administration.Rate.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is NutritionOrder.EnteralFormula.Administration.Rate.Ratio -> {
          encodeSerializableElement(descriptor, 6, RatioSerializer, choice.value)
        }
      }
    }
  }
}

internal object NutritionOrderEnteralFormulaAdministrationScheduleSerializer :
  KSerializer<NutritionOrder.EnteralFormula.Administration.Schedule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Schedule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("timing", TimingSerializer.listSerializer.descriptor)
      optionalElement("asNeeded", KotlinBoolean.serializer().descriptor)
      optionalElement("_asNeeded", ElementSerializer.descriptor)
      optionalElement("asNeededFor", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<NutritionOrder.EnteralFormula.Administration.Schedule>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): NutritionOrder.EnteralFormula.Administration.Schedule =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var timing: List<Timing>? = null
      var asNeeded: KotlinBoolean? = null
      var _asNeeded: Element? = null
      var asNeededFor: CodeableConcept? = null
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
            timing =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TimingSerializer.listSerializer,
                null,
              )
          4 -> asNeeded = decodeBooleanElement(descriptor, i)
          5 -> _asNeeded = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            asNeededFor =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Schedule: " + i)
        }
      }
      NutritionOrder.EnteralFormula.Administration.Schedule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        timing = timing ?: listOf(),
        asNeeded = R5Boolean.of(asNeeded, _asNeeded),
        asNeededFor = asNeededFor,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: NutritionOrder.EnteralFormula.Administration.Schedule,
  ) {
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
      if (value.timing.isNotEmpty())
        encodeSerializableElement(descriptor, 3, TimingSerializer.listSerializer, value.timing)
      encodeBooleanIfNotNull(descriptor, 4, value.asNeeded?.value)
      encodeElementIfNotNull(descriptor, 5, value.asNeeded)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.asNeededFor)
    }
  }
}

internal object NutritionOrderSerializer : FhirResourceSerializer<NutritionOrder> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("NutritionOrder")

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
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiates", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiates", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("groupIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("priority", KotlinString.serializer().descriptor)
    b.optionalElement("_priority", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("dateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_dateTime", ElementSerializer.descriptor)
    b.optionalElement("orderer", ReferenceSerializer.descriptor)
    b.optionalElement("performer", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("allergyIntolerance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("foodPreferenceModifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("excludeFoodModifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("outsideFoodAllowed", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_outsideFoodAllowed", ElementSerializer.descriptor)
    b.optionalElement("oralDiet", NutritionOrderOralDietSerializer.descriptor)
    b.optionalElement("supplement", NutritionOrderSupplementSerializer.listSerializer.descriptor)
    b.optionalElement("enteralFormula", NutritionOrderEnteralFormulaSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
    var basedOn: List<Reference>? = null
    var groupIdentifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var intent: KotlinString? = null
    var _intent: Element? = null
    var priority: KotlinString? = null
    var _priority: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var supportingInformation: List<Reference>? = null
    var dateTime: KotlinString? = null
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
        11 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        16 ->
          _instantiates =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        17 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          groupIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> intent = decoder.decodeStringElement(descriptor, i)
        22 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> priority = decoder.decodeStringElement(descriptor, i)
        24 ->
          _priority =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 -> dateTime = decoder.decodeStringElement(descriptor, i)
        29 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          orderer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          performer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        32 ->
          allergyIntolerance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          foodPreferenceModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        34 ->
          excludeFoodModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> outsideFoodAllowed = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _outsideFoodAllowed =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          oralDiet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietSerializer,
              null,
            )
        38 ->
          supplement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderSupplementSerializer.listSerializer,
              null,
            )
        39 ->
          enteralFormula =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaSerializer,
              null,
            )
        40 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
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
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on NutritionOrder has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on NutritionOrder has neither a value nor an id/extension"
            )
        }),
      instantiates =
        (kotlin.collections.List(maxOf(instantiates?.size ?: 0, _instantiates?.size ?: 0)) { index
          ->
          Uri.of(instantiates?.getOrNull(index), _instantiates?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiates' on NutritionOrder has neither a value nor an id/extension"
            )
        }),
      basedOn = basedOn ?: listOf(),
      groupIdentifier = groupIdentifier,
      status =
        Enumeration.of(
          if (status != null) NutritionOrder.RequestStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on NutritionOrder"),
      intent =
        Enumeration.of(
          if (intent != null) NutritionOrder.RequestIntent.fromCode(intent) else null,
          _intent,
        ) ?: throw SerializationException("Missing required property 'intent' on NutritionOrder"),
      priority =
        Enumeration.of(
          if (priority != null) NutritionOrder.RequestPriority.fromCode(priority) else null,
          _priority,
        ),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on NutritionOrder"),
      encounter = encounter,
      supportingInformation = supportingInformation ?: listOf(),
      dateTime =
        DateTime.of(if (dateTime != null) FhirDateTime.fromString(dateTime) else null, _dateTime)
          ?: throw SerializationException("Missing required property 'dateTime' on NutritionOrder"),
      orderer = orderer,
      performer = performer ?: listOf(),
      allergyIntolerance = allergyIntolerance ?: listOf(),
      foodPreferenceModifier = foodPreferenceModifier ?: listOf(),
      excludeFoodModifier = excludeFoodModifier ?: listOf(),
      outsideFoodAllowed = R5Boolean.of(outsideFoodAllowed, _outsideFoodAllowed),
      oralDiet = oralDiet,
      supplement = supplement ?: listOf(),
      enteralFormula = enteralFormula,
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: NutritionOrder,
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
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    if (value.instantiates.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        15 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiates.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 16 + descriptorOffset, value.instantiates)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      IdentifierSerializer,
      value.groupIdentifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.intent)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.priority?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.priority)
    encoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.dateTime.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.dateTime)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.orderer,
    )
    if (value.performer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.performer,
      )
    if (value.allergyIntolerance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.allergyIntolerance,
      )
    if (value.foodPreferenceModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.foodPreferenceModifier,
      )
    if (value.excludeFoodModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.excludeFoodModifier,
      )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.outsideFoodAllowed?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.outsideFoodAllowed)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      NutritionOrderOralDietSerializer,
      value.oralDiet,
    )
    if (value.supplement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        NutritionOrderSupplementSerializer.listSerializer,
        value.supplement,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      NutritionOrderEnteralFormulaSerializer,
      value.enteralFormula,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
