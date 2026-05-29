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
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Dosage
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object DosageDoseAndRateSerializer : KSerializer<Dosage.DoseAndRate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DoseAndRate") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("type", lazyDescriptor { CodeableConcept.serializer().descriptor }, isOptional = true)
      element("doseRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "doseQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element("rateRatio", lazyDescriptor { Ratio.serializer().descriptor }, isOptional = true)
      element("rateRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "rateQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Dosage.DoseAndRate =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Dosage.DoseAndRate) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Dosage.DoseAndRate {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: CodeableConcept? = null
    var doseRange: Range? = null
    var doseQuantity: Quantity? = null
    var rateRatio: Ratio? = null
    var rateRange: Range? = null
    var rateQuantity: Quantity? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        3 ->
          doseRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseRangeSer, null)
        4 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseQuantitySer, null)
        5 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rateRatioSer, null)
        6 ->
          rateRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseRangeSer, null)
        7 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DoseAndRate: " + i)
      }
    }
    return Dosage.DoseAndRate(
      id = id,
      extension = extension ?: listOf(),
      type = type,
      dose = Dosage.DoseAndRate.Dose.from(doseRange, doseQuantity),
      rate = Dosage.DoseAndRate.Rate.from(rateRatio, rateRange, rateQuantity),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Dosage.DoseAndRate) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 2, Hoisted.typeSer, it) }
    when (val choice = value.dose) {
      null -> {}
      is Dosage.DoseAndRate.Dose.Range -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.doseRangeSer, choice.value)
      }
      is Dosage.DoseAndRate.Dose.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.doseQuantitySer, choice.value)
      }
    }
    when (val choice = value.rate) {
      null -> {}
      is Dosage.DoseAndRate.Rate.Ratio -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.rateRatioSer, choice.value)
      }
      is Dosage.DoseAndRate.Rate.Range -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.doseRangeSer, choice.value)
      }
      is Dosage.DoseAndRate.Rate.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.doseQuantitySer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val doseRangeSer: KSerializer<Range> = Range.serializer()

    public val doseQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val rateRatioSer: KSerializer<Ratio> = Ratio.serializer()
  }
}

internal object DosageSerializer : KSerializer<Dosage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element(
        "additionalInstruction",
        listSerialDescriptor(lazyDescriptor { CodeableConcept.serializer().descriptor }),
        isOptional = true,
      )
      element("patientInstruction", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_patientInstruction",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("timing", lazyDescriptor { Timing.serializer().descriptor }, isOptional = true)
      element("asNeededBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element(
        "_asNeededBoolean",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element(
        "asNeededCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element("site", lazyDescriptor { CodeableConcept.serializer().descriptor }, isOptional = true)
      element(
        "route",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "method",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
      element(
        "doseAndRate",
        listSerialDescriptor(lazyDescriptor { Dosage.DoseAndRate.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "maxDosePerPeriod",
        lazyDescriptor { Ratio.serializer().descriptor },
        isOptional = true,
      )
      element(
        "maxDosePerAdministration",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
      element(
        "maxDosePerLifetime",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Dosage =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Dosage) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Dosage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var additionalInstruction: List<CodeableConcept>? = null
    var patientInstruction: KotlinString? = null
    var _patientInstruction: Element? = null
    var timing: Timing? = null
    var asNeededBoolean: KotlinBoolean? = null
    var _asNeededBoolean: Element? = null
    var asNeededCodeableConcept: CodeableConcept? = null
    var site: CodeableConcept? = null
    var route: CodeableConcept? = null
    var method: CodeableConcept? = null
    var doseAndRate: List<Dosage.DoseAndRate>? = null
    var maxDosePerPeriod: Ratio? = null
    var maxDosePerAdministration: Quantity? = null
    var maxDosePerLifetime: Quantity? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 ->
          _text =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        7 ->
          additionalInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInstructionSer,
              null,
            )
        8 -> patientInstruction = decoder.decodeStringElement(descriptor, i)
        9 ->
          _patientInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        10 ->
          timing = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timingSer, null)
        11 -> asNeededBoolean = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        13 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        14 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        15 ->
          route =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        16 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        17 ->
          doseAndRate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doseAndRateSer, null)
        18 ->
          maxDosePerPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maxDosePerPeriodSer,
              null,
            )
        19 ->
          maxDosePerAdministration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maxDosePerAdministrationSer,
              null,
            )
        20 ->
          maxDosePerLifetime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maxDosePerAdministrationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + i)
      }
    }
    return Dosage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = Integer.of(sequence, _sequence),
      text = R4bString.of(text, _text),
      additionalInstruction = additionalInstruction ?: listOf(),
      patientInstruction = R4bString.of(patientInstruction, _patientInstruction),
      timing = timing,
      asNeeded =
        Dosage.AsNeeded.from(
          R4bBoolean.of(asNeededBoolean, _asNeededBoolean),
          asNeededCodeableConcept,
        ),
      site = site,
      route = route,
      method = method,
      doseAndRate = doseAndRate ?: listOf(),
      maxDosePerPeriod = maxDosePerPeriod,
      maxDosePerAdministration = maxDosePerAdministration,
      maxDosePerLifetime = maxDosePerLifetime,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Dosage) {
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
    ((value.sequence?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.sequenceSer, it)
    }
    if (value.additionalInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        Hoisted.additionalInstructionSer,
        value.additionalInstruction,
      )
    ((value.patientInstruction?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.patientInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.sequenceSer, it)
    }
    (value.timing)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.timingSer, it) }
    when (val choice = value.asNeeded) {
      null -> {}
      is Dosage.AsNeeded.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.sequenceSer, it)
        }
      }
      is Dosage.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          13,
          Hoisted.additionalInstructionSerInner,
          choice.value,
        )
      }
    }
    (value.site)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.additionalInstructionSerInner, it)
    }
    (value.route)?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.additionalInstructionSerInner, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.additionalInstructionSerInner, it)
    }
    if (value.doseAndRate.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.doseAndRateSer, value.doseAndRate)
    (value.maxDosePerPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.maxDosePerPeriodSer, it)
    }
    (value.maxDosePerAdministration)?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.maxDosePerAdministrationSer, it)
    }
    (value.maxDosePerLifetime)?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.maxDosePerAdministrationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val additionalInstructionSerInner: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val additionalInstructionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.additionalInstructionSerInner)

    public val timingSer: KSerializer<Timing> = Timing.serializer()

    public val doseAndRateSerInner: KSerializer<Dosage.DoseAndRate> =
      Dosage.DoseAndRate.serializer()

    public val doseAndRateSer: KSerializer<List<Dosage.DoseAndRate>> =
      ListSerializer(Hoisted.doseAndRateSerInner)

    public val maxDosePerPeriodSer: KSerializer<Ratio> = Ratio.serializer()

    public val maxDosePerAdministrationSer: KSerializer<Quantity> = Quantity.serializer()
  }
}
