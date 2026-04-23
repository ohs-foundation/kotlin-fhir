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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Dosage.DoseAndRate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Dosage.DoseAndRate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: CodeableConcept? = null
    var doseRange: Range? = null
    var doseQuantity: Quantity? = null
    var rateRatio: Ratio? = null
    var rateRange: Range? = null
    var rateQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.typeSer, null)
        3 ->
          doseRange =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.doseRangeSer, null)
        4 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.doseQuantitySer, null)
        5 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.rateRatioSer, null)
        6 ->
          rateRange =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.doseRangeSer, null)
        7 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.doseQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding DoseAndRate: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Dosage.DoseAndRate) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.typeSer, it) }
    when (val __d = value.dose) {
      null -> {}
      is Dosage.DoseAndRate.Dose.Range -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.doseRangeSer, __d.value)
      }
      is Dosage.DoseAndRate.Dose.Quantity -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.doseQuantitySer, __d.value)
      }
    }
    when (val __d = value.rate) {
      null -> {}
      is Dosage.DoseAndRate.Rate.Ratio -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.rateRatioSer, __d.value)
      }
      is Dosage.DoseAndRate.Rate.Range -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.doseRangeSer, __d.value)
      }
      is Dosage.DoseAndRate.Rate.Quantity -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.doseQuantitySer, __d.value)
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

internal object DosageAsNeededSerializer : KSerializer<Dosage.AsNeeded> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage.AsNeeded") {
      element("asNeededBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_asNeededBoolean", Element.serializer().descriptor, isOptional = true)
      element(
        "asNeededCodeableConcept",
        lazyDescriptor { CodeableConcept.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Dosage.AsNeeded) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Dosage.AsNeeded.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Dosage.AsNeeded.CodeableConcept -> {
          encodeSerializableElement(__desc, 2, Hoisted.asNeededCodeableConceptSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Dosage.AsNeeded =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Dosage.AsNeeded {
    val __desc = descriptor
    var asNeededBoolean: KotlinBoolean? = null
    var _asNeededBoolean: Element? = null
    var asNeededCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> asNeededBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.asNeededCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage.AsNeeded: " + __i)
      }
    }
    return Dosage.AsNeeded.from(
      R4bBoolean.of(asNeededBoolean, _asNeededBoolean),
      asNeededCodeableConcept,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val asNeededCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
  }
}

internal object DosageDoseAndRateDoseSerializer : KSerializer<Dosage.DoseAndRate.Dose> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage.DoseAndRate.Dose") {
      element("doseRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "doseQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Dosage.DoseAndRate.Dose) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Dosage.DoseAndRate.Dose.Range -> {
          encodeSerializableElement(__desc, 0, Hoisted.doseRangeSer, __d.value)
        }
        is Dosage.DoseAndRate.Dose.Quantity -> {
          encodeSerializableElement(__desc, 1, Hoisted.doseQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Dosage.DoseAndRate.Dose =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Dosage.DoseAndRate.Dose {
    val __desc = descriptor
    var doseRange: Range? = null
    var doseQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          doseRange =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.doseRangeSer, null)
        1 ->
          doseQuantity =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.doseQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Dosage.DoseAndRate.Dose: " + __i)
      }
    }
    return Dosage.DoseAndRate.Dose.from(doseRange, doseQuantity)!!
  }

  private object Hoisted {
    public val doseRangeSer: KSerializer<Range> = Range.serializer()

    public val doseQuantitySer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object DosageDoseAndRateRateSerializer : KSerializer<Dosage.DoseAndRate.Rate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Dosage.DoseAndRate.Rate") {
      element("rateRatio", lazyDescriptor { Ratio.serializer().descriptor }, isOptional = true)
      element("rateRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element(
        "rateQuantity",
        lazyDescriptor { Quantity.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Dosage.DoseAndRate.Rate) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Dosage.DoseAndRate.Rate.Ratio -> {
          encodeSerializableElement(__desc, 0, Hoisted.rateRatioSer, __d.value)
        }
        is Dosage.DoseAndRate.Rate.Range -> {
          encodeSerializableElement(__desc, 1, Hoisted.rateRangeSer, __d.value)
        }
        is Dosage.DoseAndRate.Rate.Quantity -> {
          encodeSerializableElement(__desc, 2, Hoisted.rateQuantitySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Dosage.DoseAndRate.Rate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Dosage.DoseAndRate.Rate {
    val __desc = descriptor
    var rateRatio: Ratio? = null
    var rateRange: Range? = null
    var rateQuantity: Quantity? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          rateRatio =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.rateRatioSer, null)
        1 ->
          rateRange =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.rateRangeSer, null)
        2 ->
          rateQuantity =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.rateQuantitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding Dosage.DoseAndRate.Rate: " + __i)
      }
    }
    return Dosage.DoseAndRate.Rate.from(rateRatio, rateRange, rateQuantity)!!
  }

  private object Hoisted {
    public val rateRatioSer: KSerializer<Ratio> = Ratio.serializer()

    public val rateRangeSer: KSerializer<Range> = Range.serializer()

    public val rateQuantitySer: KSerializer<Quantity> = Quantity.serializer()
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Dosage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Dosage {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 -> text = decoder.decodeStringElement(__desc, 5)
        6 -> _text = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sequenceSer, null)
        7 ->
          additionalInstruction =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.additionalInstructionSer,
              null,
            )
        8 -> patientInstruction = decoder.decodeStringElement(__desc, 8)
        9 ->
          _patientInstruction =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.sequenceSer, null)
        10 ->
          timing = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.timingSer, null)
        11 -> asNeededBoolean = decoder.decodeBooleanElement(__desc, 11)
        12 ->
          _asNeededBoolean =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.sequenceSer, null)
        13 ->
          asNeededCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        14 ->
          site =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        15 ->
          route =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        16 ->
          method =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.additionalInstructionSerInner,
              null,
            )
        17 ->
          doseAndRate =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.doseAndRateSer, null)
        18 ->
          maxDosePerPeriod =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.maxDosePerPeriodSer, null)
        19 ->
          maxDosePerAdministration =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.maxDosePerAdministrationSer,
              null,
            )
        20 ->
          maxDosePerLifetime =
            decoder.decodeNullableSerializableElement(
              __desc,
              20,
              Hoisted.maxDosePerAdministrationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Dosage: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Dosage) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sequenceSer, it)
    }
    if (value.additionalInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        7,
        Hoisted.additionalInstructionSer,
        value.additionalInstruction,
      )
    ((value.patientInstruction?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.patientInstruction?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.sequenceSer, it)
    }
    (value.timing)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.timingSer, it) }
    when (val __d = value.asNeeded) {
      null -> {}
      is Dosage.AsNeeded.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.sequenceSer, it)
        }
      }
      is Dosage.AsNeeded.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          13,
          Hoisted.additionalInstructionSerInner,
          __d.value,
        )
      }
    }
    (value.site)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.additionalInstructionSerInner, it)
    }
    (value.route)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.additionalInstructionSerInner, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.additionalInstructionSerInner, it)
    }
    if (value.doseAndRate.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.doseAndRateSer, value.doseAndRate)
    (value.maxDosePerPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.maxDosePerPeriodSer, it)
    }
    (value.maxDosePerAdministration)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.maxDosePerAdministrationSer, it)
    }
    (value.maxDosePerLifetime)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.maxDosePerAdministrationSer, it)
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
