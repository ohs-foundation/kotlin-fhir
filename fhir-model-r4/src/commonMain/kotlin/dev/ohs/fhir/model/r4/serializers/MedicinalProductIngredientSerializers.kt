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

internal object MedicinalProductIngredientSpecifiedSubstanceSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecifiedSubstance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("group", CodeableConceptSerializer.descriptor)
      optionalElement("confidentiality", CodeableConceptSerializer.descriptor)
      optionalElement(
        "strength",
        MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.SpecifiedSubstance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var group: CodeableConcept? = null
      var confidentiality: CodeableConcept? = null
      var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            group =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            confidentiality =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            strength =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SpecifiedSubstance: " + i)
        }
      }
      MedicinalProductIngredient.SpecifiedSubstance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicinalProductIngredient.SpecifiedSubstance"
            ),
        group =
          group
            ?: throw SerializationException(
              "Missing required property 'group' on MedicinalProductIngredient.SpecifiedSubstance"
            ),
        confidentiality = confidentiality,
        strength = strength ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.SpecifiedSubstance) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.group)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.confidentiality)
      if (value.strength.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
          value.strength,
        )
    }
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Strength") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("presentation", RatioSerializer.descriptor)
      optionalElement("presentationLowLimit", RatioSerializer.descriptor)
      optionalElement("concentration", RatioSerializer.descriptor)
      optionalElement("concentrationLowLimit", RatioSerializer.descriptor)
      optionalElement("measurementPoint", KotlinString.serializer().descriptor)
      optionalElement("_measurementPoint", ElementSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "referenceStrength",
        MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer
          .listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength =
    decoder.decodeStructure(descriptor) {
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
            presentation = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          4 ->
            presentationLowLimit =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          5 ->
            concentration = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          6 ->
            concentrationLowLimit =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
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
          10 ->
            referenceStrength =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Strength: " + i)
        }
      }
      MedicinalProductIngredient.SpecifiedSubstance.Strength(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        presentation =
          presentation
            ?: throw SerializationException(
              "Missing required property 'presentation' on MedicinalProductIngredient.SpecifiedSubstance.Strength"
            ),
        presentationLowLimit = presentationLowLimit,
        concentration = concentration,
        concentrationLowLimit = concentrationLowLimit,
        measurementPoint = R4String.of(measurementPoint, _measurementPoint),
        country = country ?: listOf(),
        referenceStrength = referenceStrength ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
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
      encodeSerializableElement(descriptor, 3, RatioSerializer, value.presentation)
      encodeSerializableIfNotNull(descriptor, 4, RatioSerializer, value.presentationLowLimit)
      encodeSerializableIfNotNull(descriptor, 5, RatioSerializer, value.concentration)
      encodeSerializableIfNotNull(descriptor, 6, RatioSerializer, value.concentrationLowLimit)
      encodeStringIfNotNull(descriptor, 7, value.measurementPoint?.value)
      encodeElementIfNotNull(descriptor, 8, value.measurementPoint)
      if (value.country.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.country,
        )
      if (value.referenceStrength.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer
            .listSerializer,
          value.referenceStrength,
        )
    }
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceStrength") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substance", CodeableConceptSerializer.descriptor)
      optionalElement("strength", RatioSerializer.descriptor)
      optionalElement("strengthLowLimit", RatioSerializer.descriptor)
      optionalElement("measurementPoint", KotlinString.serializer().descriptor)
      optionalElement("_measurementPoint", ElementSerializer.descriptor)
      optionalElement("country", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength =
    decoder.decodeStructure(descriptor) {
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
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> strength = decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          5 ->
            strengthLowLimit =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          6 -> measurementPoint = decodeStringElement(descriptor, i)
          7 ->
            _measurementPoint =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
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
      MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substance = substance,
        strength =
          strength
            ?: throw SerializationException(
              "Missing required property 'strength' on MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength"
            ),
        strengthLowLimit = strengthLowLimit,
        measurementPoint = R4String.of(measurementPoint, _measurementPoint),
        country = country ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.substance)
      encodeSerializableElement(descriptor, 4, RatioSerializer, value.strength)
      encodeSerializableIfNotNull(descriptor, 5, RatioSerializer, value.strengthLowLimit)
      encodeStringIfNotNull(descriptor, 6, value.measurementPoint?.value)
      encodeElementIfNotNull(descriptor, 7, value.measurementPoint)
      if (value.country.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.country,
        )
    }
  }
}

internal object MedicinalProductIngredientSubstanceSerializer :
  KSerializer<MedicinalProductIngredient.Substance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement(
        "strength",
        MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MedicinalProductIngredient.Substance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.Substance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            strength =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Substance: " + i)
        }
      }
      MedicinalProductIngredient.Substance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicinalProductIngredient.Substance"
            ),
        strength = strength ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.Substance) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      if (value.strength.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer.listSerializer,
          value.strength,
        )
    }
  }
}

internal object MedicinalProductIngredientSerializer :
  FhirResourceSerializer<MedicinalProductIngredient> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MedicinalProductIngredient")

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
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("allergenicIndicator", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_allergenicIndicator", ElementSerializer.descriptor)
    b.optionalElement("manufacturer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "specifiedSubstance",
      MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("substance", MedicinalProductIngredientSubstanceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
        11 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> allergenicIndicator = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          specifiedSubstance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer,
              null,
            )
        16 ->
          substance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductIngredientSubstanceSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding MedicinalProductIngredient: " + i)
      }
    }
    return MedicinalProductIngredient(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      role =
        role
          ?: throw SerializationException(
            "Missing required property 'role' on MedicinalProductIngredient"
          ),
      allergenicIndicator = R4Boolean.of(allergenicIndicator, _allergenicIndicator),
      manufacturer = manufacturer ?: listOf(),
      specifiedSubstance = specifiedSubstance ?: listOf(),
      substance = substance,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductIngredient,
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.role,
    )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.allergenicIndicator?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.allergenicIndicator)
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.manufacturer,
      )
    if (value.specifiedSubstance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        MedicinalProductIngredientSpecifiedSubstanceSerializer.listSerializer,
        value.specifiedSubstance,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      MedicinalProductIngredientSubstanceSerializer,
      value.substance,
    )
  }
}
