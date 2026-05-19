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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductIngredient
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("group", CodeableConcept.serializer().descriptor, isOptional = true)
      element("confidentiality", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "strength",
        listSerialDescriptor(
          lazyDescriptor {
            MedicinalProductIngredient.SpecifiedSubstance.Strength.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.SpecifiedSubstance =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.SpecifiedSubstance) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var group: CodeableConcept? = null
    var confidentiality: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 -> group = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 ->
          confidentiality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 ->
          strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SpecifiedSubstance: " + i)
      }
    }
    return MedicinalProductIngredient.SpecifiedSubstance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      group = group!!,
      confidentiality = confidentiality,
      strength = strength ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance,
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
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    (value.group)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
    (value.confidentiality)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it)
    }
    if (value.strength.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.strengthSer, value.strength)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val strengthSerInner:
      KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> =
      MedicinalProductIngredient.SpecifiedSubstance.Strength.serializer()

    public val strengthSer:
      KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength>> =
      ListSerializer(Hoisted.strengthSerInner)
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Strength") {
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
      element("presentation", Ratio.serializer().descriptor, isOptional = true)
      element("presentationLowLimit", Ratio.serializer().descriptor, isOptional = true)
      element("concentration", Ratio.serializer().descriptor, isOptional = true)
      element("concentrationLowLimit", Ratio.serializer().descriptor, isOptional = true)
      element("measurementPoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_measurementPoint", Element.serializer().descriptor, isOptional = true)
      element(
        "country",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "referenceStrength",
        listSerialDescriptor(
          lazyDescriptor {
            MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength.serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          presentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.presentationSer, null)
        4 ->
          presentationLowLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.presentationSer, null)
        5 ->
          concentration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.presentationSer, null)
        6 ->
          concentrationLowLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.presentationSer, null)
        7 -> measurementPoint = decoder.decodeStringElement(descriptor, i)
        8 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measurementPointSer,
              null,
            )
        9 ->
          country =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        10 ->
          referenceStrength =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referenceStrengthSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Strength: " + i)
      }
    }
    return MedicinalProductIngredient.SpecifiedSubstance.Strength(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      presentation = presentation!!,
      presentationLowLimit = presentationLowLimit,
      concentration = concentration,
      concentrationLowLimit = concentrationLowLimit,
      measurementPoint = R4String.of(measurementPoint, _measurementPoint),
      country = country ?: listOf(),
      referenceStrength = referenceStrength ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
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
    (value.presentation)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.presentationSer, it)
    }
    (value.presentationLowLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.presentationSer, it)
    }
    (value.concentration)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.presentationSer, it)
    }
    (value.concentrationLowLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.presentationSer, it)
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.measurementPointSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.countrySer, value.country)
    if (value.referenceStrength.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        Hoisted.referenceStrengthSer,
        value.referenceStrength,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val presentationSer: KSerializer<Ratio> = Ratio.serializer()

    public val measurementPointSer: KSerializer<Element> = Element.serializer()

    public val countrySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countrySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.countrySerInner)

    public val referenceStrengthSerInner:
      KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength> =
      MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength.serializer()

    public val referenceStrengthSer:
      KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength>> =
      ListSerializer(Hoisted.referenceStrengthSerInner)
  }
}

internal object MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceStrength") {
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
      element("substance", CodeableConcept.serializer().descriptor, isOptional = true)
      element("strength", Ratio.serializer().descriptor, isOptional = true)
      element("strengthLowLimit", Ratio.serializer().descriptor, isOptional = true)
      element("measurementPoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_measurementPoint", Element.serializer().descriptor, isOptional = true)
      element(
        "country",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          substance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substanceSer, null)
        4 ->
          strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        5 ->
          strengthLowLimit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        6 -> measurementPoint = decoder.decodeStringElement(descriptor, i)
        7 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measurementPointSer,
              null,
            )
        8 ->
          country =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceStrength: " + i)
      }
    }
    return MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance,
      strength = strength!!,
      strengthLowLimit = strengthLowLimit,
      measurementPoint = R4String.of(measurementPoint, _measurementPoint),
      country = country ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
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
    (value.substance)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.substanceSer, it)
    }
    (value.strength)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.strengthSer, it)
    }
    (value.strengthLowLimit)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.strengthSer, it)
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.measurementPointSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.countrySer, value.country)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val strengthSer: KSerializer<Ratio> = Ratio.serializer()

    public val measurementPointSer: KSerializer<Element> = Element.serializer()

    public val countrySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.substanceSer)
  }
}

internal object MedicinalProductIngredientSubstanceSerializer :
  KSerializer<MedicinalProductIngredient.Substance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Substance") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "strength",
        listSerialDescriptor(
          lazyDescriptor {
            MedicinalProductIngredient.SpecifiedSubstance.Strength.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.Substance =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.Substance) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MedicinalProductIngredient.Substance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          strength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substance: " + i)
      }
    }
    return MedicinalProductIngredient.Substance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      strength = strength ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.Substance,
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
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, it) }
    if (value.strength.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.strengthSer, value.strength)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val strengthSerInner:
      KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> =
      MedicinalProductIngredient.SpecifiedSubstance.Strength.serializer()

    public val strengthSer:
      KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance.Strength>> =
      ListSerializer(Hoisted.strengthSerInner)
  }
}

internal object MedicinalProductIngredientSerializer : KSerializer<MedicinalProductIngredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductIngredient") {
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
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("allergenicIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_allergenicIndicator", Element.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specifiedSubstance",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductIngredient.SpecifiedSubstance.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "substance",
      lazyDescriptor { MedicinalProductIngredient.Substance.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductIngredient")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        11 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
        12 -> allergenicIndicator = decoder.decodeBooleanElement(descriptor, i)
        13 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.manufacturerSer, null)
        15 ->
          specifiedSubstance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.specifiedSubstanceSer,
              null,
            )
        16 ->
          substance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.substanceSer, null)
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
      role = role!!,
      allergenicIndicator = R4Boolean.of(allergenicIndicator, _allergenicIndicator),
      manufacturer = manufacturer ?: listOf(),
      specifiedSubstance = specifiedSubstance ?: listOf(),
      substance = substance,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductIngredient,
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    (value.role)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.roleSer, it)
    }
    ((value.allergenicIndicator?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.allergenicIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.manufacturerSer,
        value.manufacturer,
      )
    if (value.specifiedSubstance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.specifiedSubstanceSer,
        value.specifiedSubstance,
      )
    (value.substance)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.substanceSer, it)
    }
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val manufacturerSerInner: KSerializer<Reference> = Reference.serializer()

    public val manufacturerSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val specifiedSubstanceSerInner:
      KSerializer<MedicinalProductIngredient.SpecifiedSubstance> =
      MedicinalProductIngredient.SpecifiedSubstance.serializer()

    public val specifiedSubstanceSer:
      KSerializer<List<MedicinalProductIngredient.SpecifiedSubstance>> =
      ListSerializer(Hoisted.specifiedSubstanceSerInner)

    public val substanceSer: KSerializer<MedicinalProductIngredient.Substance> =
      MedicinalProductIngredient.Substance.serializer()
  }
}

internal object MedicinalProductIngredientPolymorphicSerializer :
  KSerializer<MedicinalProductIngredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductIngredient") {
      MedicinalProductIngredientSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductIngredientSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient =
    decoder.decodeStructure(descriptor) {
      MedicinalProductIngredientSerializer.deserializeInternal(this, descriptor, 0)
    }
}
