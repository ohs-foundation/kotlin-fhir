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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductIngredient
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object MedicinalProductIngredientSpecifiedSubstanceSerializer :
  FhirSerializer<MedicinalProductIngredient.SpecifiedSubstance> {
  override val descriptor: SerialDescriptor = buildDescriptor("SpecifiedSubstance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("group", CodeableConceptSerializer.descriptor)
    b.optionalElement("confidentiality", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "strength",
      MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.SpecifiedSubstance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var group: CodeableConcept? = null
    var confidentiality: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
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
              CodeableConceptSerializer,
              null,
            )
        4 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          confidentiality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductIngredient.SpecifiedSubstance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "MedicinalProductIngredient.SpecifiedSubstance", "code"),
      group = required(group, "MedicinalProductIngredient.SpecifiedSubstance", "group"),
      confidentiality = confidentiality,
      strength = listOrEmpty(strength),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.SpecifiedSubstance) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.group,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.confidentiality,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
      value.strength,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer :
  FhirSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> {
  override val descriptor: SerialDescriptor = buildDescriptor("Strength", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("presentation", RatioSerializer.descriptor)
    b.optionalElement("presentationLowLimit", RatioSerializer.descriptor)
    b.optionalElement("concentration", RatioSerializer.descriptor)
    b.optionalElement("concentrationLowLimit", RatioSerializer.descriptor)
    b.strPrim("measurementPoint")
    b.optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "referenceStrength",
      MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer.listSerializer
        .descriptor,
    )
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var presentation: Ratio? = null
    var presentationLowLimit: Ratio? = null
    var concentration: Ratio? = null
    var concentrationLowLimit: Ratio? = null
    var measurementPoint: KotlinString? = null
    var _measurementPoint: Element? = null
    var country: List<CodeableConcept>? = null
    var referenceStrength:
      List<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength>? =
      null
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
          presentation =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        4 ->
          presentationLowLimit =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        5 ->
          concentration =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        6 ->
          concentrationLowLimit =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
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
        10 ->
          referenceStrength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer
                .listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductIngredient.SpecifiedSubstance.Strength(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      presentation =
        required(
          presentation,
          "MedicinalProductIngredient.SpecifiedSubstance.Strength",
          "presentation",
        ),
      presentationLowLimit = presentationLowLimit,
      concentration = concentration,
      concentrationLowLimit = concentrationLowLimit,
      measurementPoint = R4String.of(measurementPoint, _measurementPoint),
      country = listOrEmpty(country),
      referenceStrength = listOrEmpty(referenceStrength),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, RatioSerializer, value.presentation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      RatioSerializer,
      value.presentationLowLimit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      RatioSerializer,
      value.concentration,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      RatioSerializer,
      value.concentrationLowLimit,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.measurementPoint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.measurementPoint)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CodeableConceptSerializer.listSerializer,
      value.country,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer
        .listSerializer,
      value.referenceStrength,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer :
  FhirSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength> {
  override val descriptor: SerialDescriptor = buildDescriptor("ReferenceStrength", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("substance", CodeableConceptSerializer.descriptor)
    b.optionalElement("strength", RatioSerializer.descriptor)
    b.optionalElement("strengthLowLimit", RatioSerializer.descriptor)
    b.strPrim("measurementPoint")
    b.optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var substance: CodeableConcept? = null
    var strength: Ratio? = null
    var strengthLowLimit: Ratio? = null
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
              CodeableConceptSerializer,
              null,
            )
        4 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        5 ->
          strengthLowLimit =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        6 -> measurementPoint = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _measurementPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
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
    return MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      substance = substance,
      strength =
        required(
          strength,
          "MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength",
          "strength",
        ),
      strengthLowLimit = strengthLowLimit,
      measurementPoint = R4String.of(measurementPoint, _measurementPoint),
      country = listOrEmpty(country),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.substance,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, RatioSerializer, value.strength)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      RatioSerializer,
      value.strengthLowLimit,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.measurementPoint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.measurementPoint)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CodeableConceptSerializer.listSerializer,
      value.country,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductIngredientSubstanceSerializer :
  FhirSerializer<MedicinalProductIngredient.Substance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Substance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProductIngredient.Substance>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "strength",
      MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.Substance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
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
              CodeableConceptSerializer,
              null,
            )
        4 ->
          strength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductIngredient.Substance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "MedicinalProductIngredient.Substance", "code"),
      strength = listOrEmpty(strength),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.Substance) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
      value.strength,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductIngredientSerializer :
  FhirResourceSerializer<MedicinalProductIngredient> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProductIngredient")

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
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.boolPrim("allergenicIndicator")
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "specifiedSubstance",
      MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("substance", MedicinalProductIngredientSubstanceSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProductIngredient {
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
    var role: CodeableConcept? = null
    var allergenicIndicator: KotlinBoolean? = null
    var _allergenicIndicator: Element? = null
    var manufacturer: List<Reference>? = null
    var specifiedSubstance: List<MedicinalProductIngredient.SpecifiedSubstance>? = null
    var substance: MedicinalProductIngredient.Substance? = null
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
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> allergenicIndicator = compositeDecoder.decodeBooleanElement(descriptor, i)
        13 ->
          _allergenicIndicator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
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
          specifiedSubstance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer,
              null,
            )
        16 ->
          substance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSubstanceSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MedicinalProductIngredient(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      role = required(role, "MedicinalProductIngredient", "role"),
      allergenicIndicator = R4Boolean.of(allergenicIndicator, _allergenicIndicator),
      manufacturer = listOrEmpty(manufacturer),
      specifiedSubstance = listOrEmpty(specifiedSubstance),
      substance = substance,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductIngredient,
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.allergenicIndicator?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.allergenicIndicator,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.manufacturer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer,
      value.specifiedSubstance,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      MedicinalProductIngredientSubstanceSerializer,
      value.substance,
    )
  }
}
