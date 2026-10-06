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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Ingredient
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Ratio
import dev.ohs.fhir.model.r5.RatioRange
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.IngredientManufacturerRole
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object IngredientManufacturerSerializer : KSerializer<Ingredient.Manufacturer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manufacturer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", KotlinString.serializer().descriptor)
      optionalElement("_role", ElementSerializer.descriptor)
      optionalElement("manufacturer", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Ingredient.Manufacturer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Ingredient.Manufacturer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: KotlinString? = null
      var _role: Element? = null
      var manufacturer: Reference? = null
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
          3 -> role = decodeStringElement(descriptor, i)
          4 -> _role = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            manufacturer =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Manufacturer: " + i)
        }
      }
      Ingredient.Manufacturer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role =
          Enumeration.of(
            if (role != null) IngredientManufacturerRole.fromCode(role) else null,
            _role,
          ),
        manufacturer =
          manufacturer
            ?: throw SerializationException(
              "Missing required property 'manufacturer' on Ingredient.Manufacturer"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Manufacturer) {
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
      encodeStringIfNotNull(descriptor, 3, value.role?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.role)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.manufacturer)
    }
  }
}

internal object IngredientSubstanceSerializer : KSerializer<Ingredient.Substance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableReferenceSerializer.descriptor)
      optionalElement("strength", IngredientSubstanceStrengthSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Ingredient.Substance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Ingredient.Substance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableReference? = null
      var strength: List<Ingredient.Substance.Strength>? = null
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
            code =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            strength =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IngredientSubstanceStrengthSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Substance: " + i)
        }
      }
      Ingredient.Substance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on Ingredient.Substance"
            ),
        strength = strength ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance) {
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.code)
      if (value.strength.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          IngredientSubstanceStrengthSerializer.listSerializer,
          value.strength,
        )
    }
  }
}

internal object IngredientSubstanceStrengthSerializer : KSerializer<Ingredient.Substance.Strength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Strength") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("presentationRatio", RatioSerializer.descriptor)
      optionalElement("presentationRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("presentationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("presentationQuantity", QuantitySerializer.descriptor)
      optionalElement("textPresentation", KotlinString.serializer().descriptor)
      optionalElement("_textPresentation", ElementSerializer.descriptor)
      optionalElement("concentrationRatio", RatioSerializer.descriptor)
      optionalElement("concentrationRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("concentrationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("concentrationQuantity", QuantitySerializer.descriptor)
      optionalElement("textConcentration", KotlinString.serializer().descriptor)
      optionalElement("_textConcentration", ElementSerializer.descriptor)
      optionalElement("basis", CodeableConceptSerializer.descriptor)
      optionalElement("measurementPoint", KotlinString.serializer().descriptor)
      optionalElement("_measurementPoint", ElementSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "referenceStrength",
        IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Ingredient.Substance.Strength>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var presentationRatio: Ratio? = null
      var presentationRatioRange: RatioRange? = null
      var presentationCodeableConcept: CodeableConcept? = null
      var presentationQuantity: Quantity? = null
      var textPresentation: KotlinString? = null
      var _textPresentation: Element? = null
      var concentrationRatio: Ratio? = null
      var concentrationRatioRange: RatioRange? = null
      var concentrationCodeableConcept: CodeableConcept? = null
      var concentrationQuantity: Quantity? = null
      var textConcentration: KotlinString? = null
      var _textConcentration: Element? = null
      var basis: CodeableConcept? = null
      var measurementPoint: KotlinString? = null
      var _measurementPoint: Element? = null
      var country: List<CodeableConcept>? = null
      var referenceStrength: List<Ingredient.Substance.Strength.ReferenceStrength>? = null
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
            presentationRatio =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          4 ->
            presentationRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          5 ->
            presentationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            presentationQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 -> textPresentation = decodeStringElement(descriptor, i)
          8 ->
            _textPresentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            concentrationRatio =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          10 ->
            concentrationRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          11 ->
            concentrationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            concentrationQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          13 -> textConcentration = decodeStringElement(descriptor, i)
          14 ->
            _textConcentration =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 ->
            basis =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 -> measurementPoint = decodeStringElement(descriptor, i)
          17 ->
            _measurementPoint =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            country =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          19 ->
            referenceStrength =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Strength: " + i)
        }
      }
      Ingredient.Substance.Strength(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        presentation =
          Ingredient.Substance.Strength.Presentation.from(
            presentationRatio,
            presentationRatioRange,
            presentationCodeableConcept,
            presentationQuantity,
          ),
        textPresentation = R5String.of(textPresentation, _textPresentation),
        concentration =
          Ingredient.Substance.Strength.Concentration.from(
            concentrationRatio,
            concentrationRatioRange,
            concentrationCodeableConcept,
            concentrationQuantity,
          ),
        textConcentration = R5String.of(textConcentration, _textConcentration),
        basis = basis,
        measurementPoint = R5String.of(measurementPoint, _measurementPoint),
        country = country ?: listOf(),
        referenceStrength = referenceStrength ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance.Strength) {
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
      when (val choice = value.presentation) {
        null -> {}
        is Ingredient.Substance.Strength.Presentation.Ratio -> {
          encodeSerializableElement(descriptor, 3, RatioSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Presentation.RatioRange -> {
          encodeSerializableElement(descriptor, 4, RatioRangeSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Presentation.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Presentation.Quantity -> {
          encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 7, value.textPresentation?.value)
      encodeElementIfNotNull(descriptor, 8, value.textPresentation)
      when (val choice = value.concentration) {
        null -> {}
        is Ingredient.Substance.Strength.Concentration.Ratio -> {
          encodeSerializableElement(descriptor, 9, RatioSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Concentration.RatioRange -> {
          encodeSerializableElement(descriptor, 10, RatioRangeSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Concentration.CodeableConcept -> {
          encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.Concentration.Quantity -> {
          encodeSerializableElement(descriptor, 12, QuantitySerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 13, value.textConcentration?.value)
      encodeElementIfNotNull(descriptor, 14, value.textConcentration)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.basis)
      encodeStringIfNotNull(descriptor, 16, value.measurementPoint?.value)
      encodeElementIfNotNull(descriptor, 17, value.measurementPoint)
      if (value.country.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          CodeableConceptSerializer.listSerializer,
          value.country,
        )
      if (value.referenceStrength.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer,
          value.referenceStrength,
        )
    }
  }
}

internal object IngredientSubstanceStrengthReferenceStrengthSerializer :
  KSerializer<Ingredient.Substance.Strength.ReferenceStrength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceStrength") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substance", CodeableReferenceSerializer.descriptor)
      optionalElement("strengthRatio", RatioSerializer.descriptor)
      optionalElement("strengthRatioRange", RatioRangeSerializer.descriptor)
      optionalElement("strengthQuantity", QuantitySerializer.descriptor)
      optionalElement("measurementPoint", KotlinString.serializer().descriptor)
      optionalElement("_measurementPoint", ElementSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Ingredient.Substance.Strength.ReferenceStrength>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength.ReferenceStrength =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var substance: CodeableReference? = null
      var strengthRatio: Ratio? = null
      var strengthRatioRange: RatioRange? = null
      var strengthQuantity: Quantity? = null
      var measurementPoint: KotlinString? = null
      var _measurementPoint: Element? = null
      var country: List<CodeableConcept>? = null
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
            substance =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          4 ->
            strengthRatio = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          5 ->
            strengthRatioRange =
              decodeNullableSerializableElement(descriptor, i, RatioRangeSerializer, null)
          6 ->
            strengthQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 -> measurementPoint = decodeStringElement(descriptor, i)
          8 ->
            _measurementPoint =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            country =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReferenceStrength: " + i)
        }
      }
      Ingredient.Substance.Strength.ReferenceStrength(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substance =
          substance
            ?: throw SerializationException(
              "Missing required property 'substance' on Ingredient.Substance.Strength.ReferenceStrength"
            ),
        strength =
          Ingredient.Substance.Strength.ReferenceStrength.Strength.from(
            strengthRatio,
            strengthRatioRange,
            strengthQuantity,
          )
            ?: throw SerializationException(
              "Missing required property 'strength' on Ingredient.Substance.Strength.ReferenceStrength"
            ),
        measurementPoint = R5String.of(measurementPoint, _measurementPoint),
        country = country ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Ingredient.Substance.Strength.ReferenceStrength,
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
      encodeSerializableElement(descriptor, 3, CodeableReferenceSerializer, value.substance)
      when (val choice = value.strength) {
        is Ingredient.Substance.Strength.ReferenceStrength.Strength.Ratio -> {
          encodeSerializableElement(descriptor, 4, RatioSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.ReferenceStrength.Strength.RatioRange -> {
          encodeSerializableElement(descriptor, 5, RatioRangeSerializer, choice.value)
        }
        is Ingredient.Substance.Strength.ReferenceStrength.Strength.Quantity -> {
          encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 7, value.measurementPoint?.value)
      encodeElementIfNotNull(descriptor, 8, value.measurementPoint)
      if (value.country.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.country,
        )
    }
  }
}

internal object IngredientSerializer : FhirResourceSerializer<Ingredient> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Ingredient")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("for", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("group", CodeableConceptSerializer.descriptor)
    b.optionalElement("allergenicIndicator", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_allergenicIndicator", ElementSerializer.descriptor)
    b.optionalElement("comment", KotlinString.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", IngredientManufacturerSerializer.listSerializer.descriptor)
    b.optionalElement("substance", IngredientSubstanceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Ingredient {
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
    var identifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var `for`: List<Reference>? = null
    var role: CodeableConcept? = null
    var function: List<CodeableConcept>? = null
    var group: CodeableConcept? = null
    var allergenicIndicator: KotlinBoolean? = null
    var _allergenicIndicator: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var manufacturer: List<Ingredient.Manufacturer>? = null
    var substance: Ingredient.Substance? = null
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
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          `for` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          function =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          group =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> allergenicIndicator = decoder.decodeBooleanElement(descriptor, i)
        18 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> comment = decoder.decodeStringElement(descriptor, i)
        20 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientManufacturerSerializer.listSerializer,
              null,
            )
        22 ->
          substance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientSubstanceSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + i)
      }
    }
    return Ingredient(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Ingredient"),
      `for` = `for` ?: listOf(),
      role = role ?: throw SerializationException("Missing required property 'role' on Ingredient"),
      function = function ?: listOf(),
      group = group,
      allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
      comment = Markdown.of(comment, _comment),
      manufacturer = manufacturer ?: listOf(),
      substance =
        substance
          ?: throw SerializationException("Missing required property 'substance' on Ingredient"),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Ingredient,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.`for`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.`for`,
      )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.role,
    )
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.function,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.group,
    )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.allergenicIndicator?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.allergenicIndicator)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.comment)
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        IngredientManufacturerSerializer.listSerializer,
        value.manufacturer,
      )
    encoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      IngredientSubstanceSerializer,
      value.substance,
    )
  }
}
