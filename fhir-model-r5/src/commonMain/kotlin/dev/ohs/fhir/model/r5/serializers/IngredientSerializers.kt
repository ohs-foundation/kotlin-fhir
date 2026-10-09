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

internal object IngredientManufacturerSerializer : FhirSerializer<Ingredient.Manufacturer> {
  override val descriptor: SerialDescriptor = buildDescriptor("Manufacturer", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Ingredient.Manufacturer>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("role")
    b.optionalElement("manufacturer", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Ingredient.Manufacturer {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: IngredientManufacturerRole? = null
    var _role: Element? = null
    var manufacturer: Reference? = null
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
          role =
            IngredientManufacturerRole.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Ingredient.Manufacturer(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      role = Enumeration.of(role, _role),
      manufacturer = required(manufacturer, "Ingredient.Manufacturer", "manufacturer"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Manufacturer) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.role?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.role)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      ReferenceSerializer,
      value.manufacturer,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object IngredientSubstanceSerializer : FhirSerializer<Ingredient.Substance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Substance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Ingredient.Substance>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableReferenceSerializer.descriptor)
    b.optionalElement("strength", IngredientSubstanceStrengthSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Ingredient.Substance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableReference? = null
    var strength: List<Ingredient.Substance.Strength>? = null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientSubstanceStrengthSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Ingredient.Substance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "Ingredient.Substance", "code"),
      strength = listOrEmpty(strength),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      IngredientSubstanceStrengthSerializer.listSerializer,
      value.strength,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object IngredientSubstanceStrengthSerializer :
  FhirSerializer<Ingredient.Substance.Strength> {
  override val descriptor: SerialDescriptor = buildDescriptor("Strength", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Ingredient.Substance.Strength>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("presentationRatio", RatioSerializer.descriptor)
    b.optionalElement("presentationRatioRange", RatioRangeSerializer.descriptor)
    b.optionalElement("presentationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("presentationQuantity", QuantitySerializer.descriptor)
    b.strPrim("textPresentation")
    b.optionalElement("concentrationRatio", RatioSerializer.descriptor)
    b.optionalElement("concentrationRatioRange", RatioRangeSerializer.descriptor)
    b.optionalElement("concentrationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("concentrationQuantity", QuantitySerializer.descriptor)
    b.strPrim("textConcentration")
    b.optionalElement("basis", CodeableConceptSerializer.descriptor)
    b.strPrim("measurementPoint")
    b.optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "referenceStrength",
      IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          presentationRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        4 ->
          presentationRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        5 ->
          presentationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          presentationQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 -> textPresentation = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _textPresentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          concentrationRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        10 ->
          concentrationRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        11 ->
          concentrationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          concentrationQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        13 -> textConcentration = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _textConcentration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          basis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> measurementPoint = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _measurementPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          country =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          referenceStrength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Ingredient.Substance.Strength(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      country = listOrEmpty(country),
      referenceStrength = listOrEmpty(referenceStrength),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance.Strength) {
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
    when (val choice = value.presentation) {
      null -> {}
      is Ingredient.Substance.Strength.Presentation.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, RatioSerializer, choice.value)
      }
      is Ingredient.Substance.Strength.Presentation.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          4,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Ingredient.Substance.Strength.Presentation.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Ingredient.Substance.Strength.Presentation.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.textPresentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.textPresentation)
    when (val choice = value.concentration) {
      null -> {}
      is Ingredient.Substance.Strength.Concentration.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, RatioSerializer, choice.value)
      }
      is Ingredient.Substance.Strength.Concentration.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          10,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Ingredient.Substance.Strength.Concentration.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Ingredient.Substance.Strength.Concentration.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, QuantitySerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.textConcentration?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.textConcentration)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      CodeableConceptSerializer,
      value.basis,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 16, value.measurementPoint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.measurementPoint)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18,
      CodeableConceptSerializer.listSerializer,
      value.country,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      IngredientSubstanceStrengthReferenceStrengthSerializer.listSerializer,
      value.referenceStrength,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object IngredientSubstanceStrengthReferenceStrengthSerializer :
  FhirSerializer<Ingredient.Substance.Strength.ReferenceStrength> {
  override val descriptor: SerialDescriptor = buildDescriptor("ReferenceStrength", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Ingredient.Substance.Strength.ReferenceStrength>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("substance", CodeableReferenceSerializer.descriptor)
    b.optionalElement("strengthRatio", RatioSerializer.descriptor)
    b.optionalElement("strengthRatioRange", RatioRangeSerializer.descriptor)
    b.optionalElement("strengthQuantity", QuantitySerializer.descriptor)
    b.strPrim("measurementPoint")
    b.optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength.ReferenceStrength {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          substance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        4 ->
          strengthRatio =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        5 ->
          strengthRatioRange =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RatioRangeSerializer,
              null,
            )
        6 ->
          strengthQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 -> measurementPoint = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _measurementPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          country =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Ingredient.Substance.Strength.ReferenceStrength(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      substance =
        required(substance, "Ingredient.Substance.Strength.ReferenceStrength", "substance"),
      strength =
        required(
          Ingredient.Substance.Strength.ReferenceStrength.Strength.from(
            strengthRatio,
            strengthRatioRange,
            strengthQuantity,
          ),
          "Ingredient.Substance.Strength.ReferenceStrength",
          "strength",
        ),
      measurementPoint = R5String.of(measurementPoint, _measurementPoint),
      country = listOrEmpty(country),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Ingredient.Substance.Strength.ReferenceStrength,
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableReferenceSerializer,
      value.substance,
    )
    when (val choice = value.strength) {
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.Ratio -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, RatioSerializer, choice.value)
      }
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.RatioRange -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          RatioRangeSerializer,
          choice.value,
        )
      }
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.measurementPoint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.measurementPoint)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CodeableConceptSerializer.listSerializer,
      value.country,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object IngredientSerializer : FhirResourceSerializer<Ingredient> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Ingredient")

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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("for", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("function", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("group", CodeableConceptSerializer.descriptor)
    b.boolPrim("allergenicIndicator")
    b.strPrim("comment")
    b.optionalElement("manufacturer", IngredientManufacturerSerializer.listSerializer.descriptor)
    b.optionalElement("substance", IngredientSubstanceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: PublicationStatus? = null
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
              IdentifierSerializer,
              null,
            )
        11 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          `for` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 -> allergenicIndicator = compositeDecoder.decodeBooleanElement(descriptor, i)
        18 ->
          _allergenicIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> comment = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          manufacturer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientManufacturerSerializer.listSerializer,
              null,
            )
        22 ->
          substance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IngredientSubstanceSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Ingredient(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      status = required(Enumeration.of(status, _status), "Ingredient", "status"),
      `for` = listOrEmpty(`for`),
      role = required(role, "Ingredient", "role"),
      function = listOrEmpty(function),
      group = group,
      allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
      comment = Markdown.of(comment, _comment),
      manufacturer = listOrEmpty(manufacturer),
      substance = required(substance, "Ingredient", "substance"),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Ingredient,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.`for`,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.group,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.allergenicIndicator?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.allergenicIndicator,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.comment?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.comment)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      IngredientManufacturerSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      IngredientSubstanceSerializer,
      value.substance,
    )
  }
}
