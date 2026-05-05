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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.IngredientManufacturerRole
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
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

internal object IngredientManufacturerSerializer : KSerializer<Ingredient.Manufacturer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Manufacturer") {
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
      element("role", KotlinString.serializer().descriptor, isOptional = true)
      element("_role", Element.serializer().descriptor, isOptional = true)
      element("manufacturer", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Ingredient.Manufacturer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Manufacturer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Ingredient.Manufacturer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: KotlinString? = null
    var _role: Element? = null
    var manufacturer: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeStringElement(__desc, __i)
        4 -> _role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        5 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manufacturerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Manufacturer: " + __i)
      }
    }
    return Ingredient.Manufacturer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role?.let { Enumeration.of(IngredientManufacturerRole.fromCode(it), _role) },
      manufacturer = manufacturer!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Ingredient.Manufacturer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.role?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.role?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it)
    }
    (value.manufacturer)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.manufacturerSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<Element> = Element.serializer()

    public val manufacturerSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object IngredientSubstanceSerializer : KSerializer<Ingredient.Substance> {
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
      element("code", CodeableReference.serializer().descriptor, isOptional = true)
      element(
        "strength",
        listSerialDescriptor(
          lazyDescriptor { Ingredient.Substance.Strength.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Ingredient.Substance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Ingredient.Substance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableReference? = null
    var strength: List<Ingredient.Substance.Strength>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          strength =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Substance: " + __i)
      }
    }
    return Ingredient.Substance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      strength = strength ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Ingredient.Substance) {
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

    public val codeSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val strengthSerInner: KSerializer<Ingredient.Substance.Strength> =
      Ingredient.Substance.Strength.serializer()

    public val strengthSer: KSerializer<List<Ingredient.Substance.Strength>> =
      ListSerializer(Hoisted.strengthSerInner)
  }
}

internal object IngredientSubstanceStrengthSerializer : KSerializer<Ingredient.Substance.Strength> {
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
      element("presentationRatio", Ratio.serializer().descriptor, isOptional = true)
      element("presentationRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element(
        "presentationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("presentationQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("textPresentation", KotlinString.serializer().descriptor, isOptional = true)
      element("_textPresentation", Element.serializer().descriptor, isOptional = true)
      element("concentrationRatio", Ratio.serializer().descriptor, isOptional = true)
      element("concentrationRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element(
        "concentrationCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("concentrationQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("textConcentration", KotlinString.serializer().descriptor, isOptional = true)
      element("_textConcentration", Element.serializer().descriptor, isOptional = true)
      element("basis", CodeableConcept.serializer().descriptor, isOptional = true)
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
          lazyDescriptor { Ingredient.Substance.Strength.ReferenceStrength.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Ingredient.Substance.Strength) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Ingredient.Substance.Strength {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          presentationRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationRatioSer,
              null,
            )
        4 ->
          presentationRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationRatioRangeSer,
              null,
            )
        5 ->
          presentationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationCodeableConceptSer,
              null,
            )
        6 ->
          presentationQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationQuantitySer,
              null,
            )
        7 -> textPresentation = decoder.decodeStringElement(__desc, __i)
        8 ->
          _textPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.textPresentationSer,
              null,
            )
        9 ->
          concentrationRatio =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationRatioSer,
              null,
            )
        10 ->
          concentrationRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationRatioRangeSer,
              null,
            )
        11 ->
          concentrationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationCodeableConceptSer,
              null,
            )
        12 ->
          concentrationQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationQuantitySer,
              null,
            )
        13 -> textConcentration = decoder.decodeStringElement(__desc, __i)
        14 ->
          _textConcentration =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.textPresentationSer,
              null,
            )
        15 ->
          basis =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.presentationCodeableConceptSer,
              null,
            )
        16 -> measurementPoint = decoder.decodeStringElement(__desc, __i)
        17 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.textPresentationSer,
              null,
            )
        18 ->
          country = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countrySer, null)
        19 ->
          referenceStrength =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.referenceStrengthSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Strength: " + __i)
      }
    }
    return Ingredient.Substance.Strength(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Ingredient.Substance.Strength) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.presentation) {
      null -> {}
      is Ingredient.Substance.Strength.Presentation.Ratio -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.presentationRatioSer, __d.value)
      }
      is Ingredient.Substance.Strength.Presentation.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.presentationRatioRangeSer, __d.value)
      }
      is Ingredient.Substance.Strength.Presentation.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          5,
          Hoisted.presentationCodeableConceptSer,
          __d.value,
        )
      }
      is Ingredient.Substance.Strength.Presentation.Quantity -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.presentationQuantitySer, __d.value)
      }
    }
    ((value.textPresentation?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.textPresentation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.textPresentationSer, it)
    }
    when (val __d = value.concentration) {
      null -> {}
      is Ingredient.Substance.Strength.Concentration.Ratio -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.presentationRatioSer, __d.value)
      }
      is Ingredient.Substance.Strength.Concentration.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.presentationRatioRangeSer, __d.value)
      }
      is Ingredient.Substance.Strength.Concentration.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          11,
          Hoisted.presentationCodeableConceptSer,
          __d.value,
        )
      }
      is Ingredient.Substance.Strength.Concentration.Quantity -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.presentationQuantitySer, __d.value)
      }
    }
    ((value.textConcentration?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.textConcentration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.textPresentationSer, it)
    }
    (value.basis)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.presentationCodeableConceptSer, it)
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.textPresentationSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.countrySer, value.country)
    if (value.referenceStrength.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.referenceStrengthSer,
        value.referenceStrength,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val presentationRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val presentationRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val presentationCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val presentationQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val textPresentationSer: KSerializer<Element> = Element.serializer()

    public val countrySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.presentationCodeableConceptSer)

    public val referenceStrengthSerInner:
      KSerializer<Ingredient.Substance.Strength.ReferenceStrength> =
      Ingredient.Substance.Strength.ReferenceStrength.serializer()

    public val referenceStrengthSer:
      KSerializer<List<Ingredient.Substance.Strength.ReferenceStrength>> =
      ListSerializer(Hoisted.referenceStrengthSerInner)
  }
}

internal object IngredientSubstanceStrengthReferenceStrengthSerializer :
  KSerializer<Ingredient.Substance.Strength.ReferenceStrength> {
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
      element("substance", CodeableReference.serializer().descriptor, isOptional = true)
      element("strengthRatio", Ratio.serializer().descriptor, isOptional = true)
      element("strengthRatioRange", RatioRange.serializer().descriptor, isOptional = true)
      element("strengthQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("measurementPoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_measurementPoint", Element.serializer().descriptor, isOptional = true)
      element(
        "country",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Ingredient.Substance.Strength.ReferenceStrength =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: Ingredient.Substance.Strength.ReferenceStrength,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): Ingredient.Substance.Strength.ReferenceStrength {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          substance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.substanceSer, null)
        4 ->
          strengthRatio =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.strengthRatioSer, null)
        5 ->
          strengthRatioRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.strengthRatioRangeSer,
              null,
            )
        6 ->
          strengthQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.strengthQuantitySer,
              null,
            )
        7 -> measurementPoint = decoder.decodeStringElement(__desc, __i)
        8 ->
          _measurementPoint =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.measurementPointSer,
              null,
            )
        9 ->
          country = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countrySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceStrength: " + __i)
      }
    }
    return Ingredient.Substance.Strength.ReferenceStrength(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance!!,
      strength =
        Ingredient.Substance.Strength.ReferenceStrength.Strength.from(
          strengthRatio,
          strengthRatioRange,
          strengthQuantity,
        )!!,
      measurementPoint = R5String.of(measurementPoint, _measurementPoint),
      country = country ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Ingredient.Substance.Strength.ReferenceStrength,
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
    when (val __d = value.strength) {
      null -> {}
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.Ratio -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.strengthRatioSer, __d.value)
      }
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.RatioRange -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.strengthRatioRangeSer, __d.value)
      }
      is Ingredient.Substance.Strength.ReferenceStrength.Strength.Quantity -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.strengthQuantitySer, __d.value)
      }
    }
    ((value.measurementPoint?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.measurementPoint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.measurementPointSer, it)
    }
    if (value.country.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.countrySer, value.country)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val substanceSer: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val strengthRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val strengthRatioRangeSer: KSerializer<RatioRange> = RatioRange.serializer()

    public val strengthQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val measurementPointSer: KSerializer<Element> = Element.serializer()

    public val countrySerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val countrySer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.countrySerInner)
  }
}

internal object IngredientSerializer : KSerializer<Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("for", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "function",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("group", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("allergenicIndicator", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_allergenicIndicator", Element.serializer().descriptor, isOptional = true)
    b.element("comment", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_comment", Element.serializer().descriptor, isOptional = true)
    b.element(
      "manufacturer",
      listSerialDescriptor(lazyDescriptor { Ingredient.Manufacturer.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "substance",
      lazyDescriptor { Ingredient.Substance.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Ingredient =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Ingredient) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Ingredient")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Ingredient {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> `for` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.forSer, null)
        14 -> role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        15 ->
          function =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.functionSer, null)
        16 -> group = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        17 -> allergenicIndicator = decoder.decodeBooleanElement(__desc, __i)
        18 ->
          _allergenicIndicator =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        19 -> comment = decoder.decodeStringElement(__desc, __i)
        20 ->
          _comment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          manufacturer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.manufacturerSer, null)
        22 ->
          substance =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.substanceSer, null)
        else -> throw SerializationException("Unexpected index decoding Ingredient: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      `for` = `for` ?: listOf(),
      role = role!!,
      function = function ?: listOf(),
      group = group,
      allergenicIndicator = R5Boolean.of(allergenicIndicator, _allergenicIndicator),
      comment = Markdown.of(comment, _comment),
      manufacturer = manufacturer ?: listOf(),
      substance = substance!!,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Ingredient,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.`for`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.forSer, value.`for`)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.roleSer, it) }
    if (value.function.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.functionSer, value.function)
    (value.group)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.roleSer, it)
    }
    ((value.allergenicIndicator?.value))?.let {
      encoder.encodeBooleanElement(__desc, 17 + __off, it)
    }
    (value.allergenicIndicator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.comment?.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.manufacturer.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21 + __off,
        Hoisted.manufacturerSer,
        value.manufacturer,
      )
    (value.substance)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.substanceSer, it)
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

    public val forSerInner: KSerializer<Reference> = Reference.serializer()

    public val forSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.forSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val functionSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.roleSer)

    public val manufacturerSerInner: KSerializer<Ingredient.Manufacturer> =
      Ingredient.Manufacturer.serializer()

    public val manufacturerSer: KSerializer<List<Ingredient.Manufacturer>> =
      ListSerializer(Hoisted.manufacturerSerInner)

    public val substanceSer: KSerializer<Ingredient.Substance> = Ingredient.Substance.serializer()
  }
}

internal object IngredientPolymorphicSerializer : KSerializer<Ingredient> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Ingredient") { IngredientSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Ingredient) {
    encoder.encodeStructure(descriptor) {
      IngredientSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Ingredient =
    decoder.decodeStructure(descriptor) {
      IngredientSerializer.deserializeJson(this, descriptor, 0)
    }
}
