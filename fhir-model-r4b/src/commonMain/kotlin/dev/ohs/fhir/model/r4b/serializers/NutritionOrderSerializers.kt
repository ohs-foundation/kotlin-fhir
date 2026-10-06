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
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.NutritionOrder
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
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
      optionalElement("schedule", TimingSerializer.listSerializer.descriptor)
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
      var schedule: List<Timing>? = null
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
                TimingSerializer.listSerializer,
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
        schedule = schedule ?: listOf(),
        nutrient = nutrient ?: listOf(),
        texture = texture ?: listOf(),
        fluidConsistencyType = fluidConsistencyType ?: listOf(),
        instruction = R4bString.of(instruction, _instruction),
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
      if (value.schedule.isNotEmpty())
        encodeSerializableElement(descriptor, 4, TimingSerializer.listSerializer, value.schedule)
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
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("productName", KotlinString.serializer().descriptor)
      optionalElement("_productName", ElementSerializer.descriptor)
      optionalElement("schedule", TimingSerializer.listSerializer.descriptor)
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
      var type: CodeableConcept? = null
      var productName: KotlinString? = null
      var _productName: Element? = null
      var schedule: List<Timing>? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> productName = decodeStringElement(descriptor, i)
          5 ->
            _productName = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            schedule =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TimingSerializer.listSerializer,
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
        productName = R4bString.of(productName, _productName),
        schedule = schedule ?: listOf(),
        quantity = quantity,
        instruction = R4bString.of(instruction, _instruction),
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.productName?.value)
      encodeElementIfNotNull(descriptor, 5, value.productName)
      if (value.schedule.isNotEmpty())
        encodeSerializableElement(descriptor, 6, TimingSerializer.listSerializer, value.schedule)
      encodeSerializableIfNotNull(descriptor, 7, QuantitySerializer, value.quantity)
      encodeStringIfNotNull(descriptor, 8, value.instruction?.value)
      encodeElementIfNotNull(descriptor, 9, value.instruction)
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
      optionalElement("baseFormulaType", CodeableConceptSerializer.descriptor)
      optionalElement("baseFormulaProductName", KotlinString.serializer().descriptor)
      optionalElement("_baseFormulaProductName", ElementSerializer.descriptor)
      optionalElement("additiveType", CodeableConceptSerializer.descriptor)
      optionalElement("additiveProductName", KotlinString.serializer().descriptor)
      optionalElement("_additiveProductName", ElementSerializer.descriptor)
      optionalElement("caloricDensity", QuantitySerializer.descriptor)
      optionalElement("routeofAdministration", CodeableConceptSerializer.descriptor)
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
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> baseFormulaProductName = decodeStringElement(descriptor, i)
          5 ->
            _baseFormulaProductName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            additiveType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> additiveProductName = decodeStringElement(descriptor, i)
          8 ->
            _additiveProductName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            caloricDensity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 ->
            routeofAdministration =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 ->
            administration =
              decodeNullableSerializableElement(
                descriptor,
                i,
                NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
                null,
              )
          12 ->
            maxVolumeToDeliver =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          13 -> administrationInstruction = decodeStringElement(descriptor, i)
          14 ->
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.baseFormulaType)
      encodeStringIfNotNull(descriptor, 4, value.baseFormulaProductName?.value)
      encodeElementIfNotNull(descriptor, 5, value.baseFormulaProductName)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.additiveType)
      encodeStringIfNotNull(descriptor, 7, value.additiveProductName?.value)
      encodeElementIfNotNull(descriptor, 8, value.additiveProductName)
      encodeSerializableIfNotNull(descriptor, 9, QuantitySerializer, value.caloricDensity)
      encodeSerializableIfNotNull(
        descriptor,
        10,
        CodeableConceptSerializer,
        value.routeofAdministration,
      )
      if (value.administration.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          NutritionOrderEnteralFormulaAdministrationSerializer.listSerializer,
          value.administration,
        )
      encodeSerializableIfNotNull(descriptor, 12, QuantitySerializer, value.maxVolumeToDeliver)
      encodeStringIfNotNull(descriptor, 13, value.administrationInstruction?.value)
      encodeElementIfNotNull(descriptor, 14, value.administrationInstruction)
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
      optionalElement("schedule", TimingSerializer.descriptor)
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
      var schedule: Timing? = null
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
          3 -> schedule = decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
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
      encodeSerializableIfNotNull(descriptor, 3, TimingSerializer, value.schedule)
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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("intent", KotlinString.serializer().descriptor)
    b.optionalElement("_intent", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("dateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_dateTime", ElementSerializer.descriptor)
    b.optionalElement("orderer", ReferenceSerializer.descriptor)
    b.optionalElement("allergyIntolerance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("foodPreferenceModifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("excludeFoodModifier", CodeableConceptSerializer.listSerializer.descriptor)
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
        17 -> status = decoder.decodeStringElement(descriptor, i)
        18 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> intent = decoder.decodeStringElement(descriptor, i)
        20 ->
          _intent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 -> dateTime = decoder.decodeStringElement(descriptor, i)
        24 ->
          _dateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          orderer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          allergyIntolerance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          foodPreferenceModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        28 ->
          excludeFoodModifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        29 ->
          oralDiet =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderOralDietSerializer,
              null,
            )
        30 ->
          supplement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderSupplementSerializer.listSerializer,
              null,
            )
        31 ->
          enteralFormula =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NutritionOrderEnteralFormulaSerializer,
              null,
            )
        32 ->
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
      patient =
        patient
          ?: throw SerializationException("Missing required property 'patient' on NutritionOrder"),
      encounter = encounter,
      dateTime =
        DateTime.of(if (dateTime != null) FhirDateTime.fromString(dateTime) else null, _dateTime)
          ?: throw SerializationException("Missing required property 'dateTime' on NutritionOrder"),
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
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.intent.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.intent)
    encoder.encodeSerializableElement(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.dateTime.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.dateTime)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.orderer,
    )
    if (value.allergyIntolerance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.allergyIntolerance,
      )
    if (value.foodPreferenceModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.foodPreferenceModifier,
      )
    if (value.excludeFoodModifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.excludeFoodModifier,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      NutritionOrderOralDietSerializer,
      value.oralDiet,
    )
    if (value.supplement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        NutritionOrderSupplementSerializer.listSerializer,
        value.supplement,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      NutritionOrderEnteralFormulaSerializer,
      value.enteralFormula,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
