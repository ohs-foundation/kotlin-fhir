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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.SpecifiedSubstance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var group: CodeableConcept? = null
    var confidentiality: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> group = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 ->
          confidentiality =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          strength = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SpecifiedSubstance: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.group)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
    (value.confidentiality)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it)
    }
    if (value.strength.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.strengthSer, value.strength)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          presentation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.presentationSer, null)
        4 ->
          presentationLowLimit =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.presentationSer, null)
        5 ->
          concentration =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.presentationSer, null)
        6 ->
          concentrationLowLimit =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.presentationSer, null)
        7 -> measurementPoint = decoder.decodeStringElement(__desc, 7)
        8 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.measurementPointSer, null)
        9 ->
          country = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.countrySer, null)
        10 ->
          referenceStrength =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.referenceStrengthSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Strength: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.presentation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.presentationSer, it)
    }
    (value.presentationLowLimit)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.presentationSer, it)
    }
    (value.concentration)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.presentationSer, it)
    }
    (value.concentrationLowLimit)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.presentationSer, it)
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.measurementPointSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.countrySer, value.country)
    if (value.referenceStrength.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          substance =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.substanceSer, null)
        4 ->
          strength = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.strengthSer, null)
        5 ->
          strengthLowLimit =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.strengthSer, null)
        6 -> measurementPoint = decoder.decodeStringElement(__desc, 6)
        7 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.measurementPointSer, null)
        8 ->
          country = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.countrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceStrength: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.substance)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.substanceSer, it)
    }
    (value.strength)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.strengthSer, it) }
    (value.strengthLowLimit)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.strengthSer, it)
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.measurementPointSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.countrySer, value.country)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.Substance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MedicinalProductIngredient.Substance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var strength: List<MedicinalProductIngredient.SpecifiedSubstance.Strength>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          strength = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substance: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductIngredient.Substance,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.strength.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.strengthSer, value.strength)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductIngredient")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductIngredient {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> role = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.roleSer, null)
        13 -> allergenicIndicator = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.manufacturerSer, null)
        16 ->
          specifiedSubstance =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.specifiedSubstanceSer,
              null,
            )
        17 ->
          substance =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.substanceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductIngredient: " + __i
          )
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductIngredient) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, it)
    }
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.roleSer, it) }
    ((value.allergenicIndicator?.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.allergenicIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.manufacturerSer, value.manufacturer)
    if (value.specifiedSubstance.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16,
        Hoisted.specifiedSubstanceSer,
        value.specifiedSubstance,
      )
    (value.substance)?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.substanceSer, it)
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
      MedicinalProductIngredientSerializer.serializeJson(this, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient =
    decoder.decodeStructure(descriptor) {
      MedicinalProductIngredientSerializer.deserializeJson(this)
    }
}
