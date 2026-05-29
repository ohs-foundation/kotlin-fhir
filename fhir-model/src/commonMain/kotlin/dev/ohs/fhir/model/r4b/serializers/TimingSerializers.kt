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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.UnsignedInt
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object TimingRepeatSerializer : KSerializer<Timing.Repeat> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repeat") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "boundsDuration",
        lazyDescriptor { Duration.serializer().descriptor },
        isOptional = true,
      )
      element("boundsRange", lazyDescriptor { Range.serializer().descriptor }, isOptional = true)
      element("boundsPeriod", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("countMax", Int.serializer().descriptor, isOptional = true)
      element("_countMax", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("duration", BigDecimalSerializer.descriptor, isOptional = true)
      element("_duration", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("durationMax", BigDecimalSerializer.descriptor, isOptional = true)
      element("_durationMax", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("durationUnit", String.serializer().descriptor, isOptional = true)
      element(
        "_durationUnit",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("frequency", Int.serializer().descriptor, isOptional = true)
      element("_frequency", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("frequencyMax", Int.serializer().descriptor, isOptional = true)
      element(
        "_frequencyMax",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("period", BigDecimalSerializer.descriptor, isOptional = true)
      element("_period", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("periodMax", BigDecimalSerializer.descriptor, isOptional = true)
      element("_periodMax", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("periodUnit", String.serializer().descriptor, isOptional = true)
      element("_periodUnit", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("dayOfWeek", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
      element(
        "_dayOfWeek",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("timeOfDay", listSerialDescriptor(LocalTimeSerializer.descriptor), isOptional = true)
      element(
        "_timeOfDay",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("when", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
      element(
        "_when",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("offset", Int.serializer().descriptor, isOptional = true)
      element("_offset", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Timing.Repeat =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Timing.Repeat {
    var id: String? = null
    var extension: List<Extension>? = null
    var boundsDuration: Duration? = null
    var boundsRange: Range? = null
    var boundsPeriod: Period? = null
    var count: Int? = null
    var _count: Element? = null
    var countMax: Int? = null
    var _countMax: Element? = null
    var duration: BigDecimal? = null
    var _duration: Element? = null
    var durationMax: BigDecimal? = null
    var _durationMax: Element? = null
    var durationUnit: String? = null
    var _durationUnit: Element? = null
    var frequency: Int? = null
    var _frequency: Element? = null
    var frequencyMax: Int? = null
    var _frequencyMax: Element? = null
    var period: BigDecimal? = null
    var _period: Element? = null
    var periodMax: BigDecimal? = null
    var _periodMax: Element? = null
    var periodUnit: String? = null
    var _periodUnit: Element? = null
    var dayOfWeek: List<String?>? = null
    var _dayOfWeek: List<Element?>? = null
    var timeOfDay: List<LocalTime?>? = null
    var _timeOfDay: List<Element?>? = null
    var `when`: List<String?>? = null
    var _when: List<Element?>? = null
    var offset: Int? = null
    var _offset: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          boundsDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.boundsDurationSer,
              null,
            )
        3 ->
          boundsRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.boundsRangeSer, null)
        4 ->
          boundsPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.boundsPeriodSer, null)
        5 -> count = decoder.decodeIntElement(descriptor, i)
        6 ->
          _count = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        7 -> countMax = decoder.decodeIntElement(descriptor, i)
        8 ->
          _countMax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        9 ->
          duration =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        10 ->
          _duration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        11 ->
          durationMax =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        12 ->
          _durationMax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        13 -> durationUnit = decoder.decodeStringElement(descriptor, i)
        14 ->
          _durationUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        15 -> frequency = decoder.decodeIntElement(descriptor, i)
        16 ->
          _frequency =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        17 -> frequencyMax = decoder.decodeIntElement(descriptor, i)
        18 ->
          _frequencyMax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        19 ->
          period =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        20 ->
          _period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        21 ->
          periodMax =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        22 ->
          _periodMax =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        23 -> periodUnit = decoder.decodeStringElement(descriptor, i)
        24 ->
          _periodUnit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        25 ->
          dayOfWeek =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfWeekSer, null)
        26 ->
          _dayOfWeek =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfWeekSer2, null)
        27 ->
          timeOfDay =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timeOfDaySer, null)
        28 ->
          _timeOfDay =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfWeekSer2, null)
        29 ->
          `when` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfWeekSer, null)
        30 ->
          _when =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfWeekSer2, null)
        31 -> offset = decoder.decodeIntElement(descriptor, i)
        32 ->
          _offset = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.countSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repeat: " + i)
      }
    }
    return Timing.Repeat(
      id = id,
      extension = extension ?: listOf(),
      bounds = Timing.Repeat.Bounds.from(boundsDuration, boundsRange, boundsPeriod),
      count = PositiveInt.of(count, _count),
      countMax = PositiveInt.of(countMax, _countMax),
      duration = Decimal.of(duration, _duration),
      durationMax = Decimal.of(durationMax, _durationMax),
      durationUnit =
        durationUnit?.let { Enumeration.of(Timing.UnitsOfTime.fromCode(it), _durationUnit) },
      frequency = PositiveInt.of(frequency, _frequency),
      frequencyMax = PositiveInt.of(frequencyMax, _frequencyMax),
      period = Decimal.of(period, _period),
      periodMax = Decimal.of(periodMax, _periodMax),
      periodUnit = periodUnit?.let { Enumeration.of(Timing.UnitsOfTime.fromCode(it), _periodUnit) },
      dayOfWeek =
        (kotlin.collections.List(maxOf(dayOfWeek?.size ?: 0, _dayOfWeek?.size ?: 0)) { index ->
          Enumeration.of(
            Timing.DaysOfWeek.fromCode(dayOfWeek?.getOrNull(index)!!),
            _dayOfWeek?.getOrNull(index),
          )
        }),
      timeOfDay =
        (kotlin.collections.List(maxOf(timeOfDay?.size ?: 0, _timeOfDay?.size ?: 0)) { index ->
          Time.of(timeOfDay?.getOrNull(index)?.let { it }, _timeOfDay?.getOrNull(index))!!
        }),
      `when` =
        (kotlin.collections.List(maxOf(`when`?.size ?: 0, _when?.size ?: 0)) { index ->
          Enumeration.of(
            Timing.EventTiming.fromCode(`when`?.getOrNull(index)!!),
            _when?.getOrNull(index),
          )
        }),
      offset = UnsignedInt.of(offset, _offset),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Timing.Repeat) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    when (val choice = value.bounds) {
      null -> {}
      is Timing.Repeat.Bounds.Duration -> {
        encoder.encodeSerializableElement(descriptor, 2, Hoisted.boundsDurationSer, choice.value)
      }
      is Timing.Repeat.Bounds.Range -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.boundsRangeSer, choice.value)
      }
      is Timing.Repeat.Bounds.Period -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.boundsPeriodSer, choice.value)
      }
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.countSer, it)
    }
    ((value.countMax?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.countMax?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.countSer, it)
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 9, BigDecimalSerializer, it)
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.countSer, it)
    }
    ((value.durationMax?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 11, BigDecimalSerializer, it)
    }
    (value.durationMax?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.countSer, it)
    }
    ((value.durationUnit?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13, it)
    }
    (value.durationUnit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.countSer, it)
    }
    ((value.frequency?.value))?.let { encoder.encodeIntElement(descriptor, 15, it) }
    (value.frequency?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.countSer, it)
    }
    ((value.frequencyMax?.value))?.let { encoder.encodeIntElement(descriptor, 17, it) }
    (value.frequencyMax?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.countSer, it)
    }
    ((value.period?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 19, BigDecimalSerializer, it)
    }
    (value.period?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.countSer, it)
    }
    ((value.periodMax?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 21, BigDecimalSerializer, it)
    }
    (value.periodMax?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.countSer, it)
    }
    ((value.periodUnit?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 23, it) }
    (value.periodUnit?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.countSer, it)
    }
    (value.dayOfWeek.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.dayOfWeekSer, it)
    }
    (value.dayOfWeek.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.dayOfWeekSer2, it)
    }
    (value.timeOfDay.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.timeOfDaySer, it)
    }
    (value.timeOfDay.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.dayOfWeekSer2, it)
    }
    (value.`when`.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.dayOfWeekSer, it)
    }
    (value.`when`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.dayOfWeekSer2, it)
    }
    ((value.offset?.value))?.let { encoder.encodeIntElement(descriptor, 31, it) }
    (value.offset?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 32, Hoisted.countSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val boundsDurationSer: KSerializer<Duration> = Duration.serializer()

    public val boundsRangeSer: KSerializer<Range> = Range.serializer()

    public val boundsPeriodSer: KSerializer<Period> = Period.serializer()

    public val countSer: KSerializer<Element> = Element.serializer()

    public val dayOfWeekSerInner: KSerializer<String> = String.serializer()

    public val dayOfWeekSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.dayOfWeekSerInner).nullable)

    public val dayOfWeekSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.countSer).nullable)

    public val timeOfDaySer: KSerializer<List<LocalTime?>> =
      ListSerializer((LocalTimeSerializer).nullable)
  }
}

internal object TimingSerializer : KSerializer<Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Timing") {
      element("id", String.serializer().descriptor, isOptional = true)
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
      element("event", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
      element(
        "_event",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("repeat", lazyDescriptor { Timing.Repeat.serializer().descriptor }, isOptional = true)
      element("code", lazyDescriptor { CodeableConcept.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Timing =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Timing) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Timing {
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var event: List<String?>? = null
    var _event: List<Element?>? = null
    var repeat: Timing.Repeat? = null
    var code: CodeableConcept? = null
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
          event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer, null)
        4 ->
          _event = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventSer2, null)
        5 ->
          repeat = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.repeatSer, null)
        6 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Timing: " + i)
      }
    }
    return Timing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      event =
        (kotlin.collections.List(maxOf(event?.size ?: 0, _event?.size ?: 0)) { index ->
          DateTime.of(
            event?.getOrNull(index)?.let { FhirDateTime.fromString(it) },
            _event?.getOrNull(index),
          )!!
        }),
      repeat = repeat,
      code = code,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Timing) {
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
    (value.event.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.eventSer, it)
    }
    (value.event.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.eventSer2, it)
    }
    (value.repeat)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.repeatSer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val eventSerInner: KSerializer<String> = String.serializer()

    public val eventSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.eventSerInner).nullable)

    public val eventSerInner2: KSerializer<Element> = Element.serializer()

    public val eventSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.eventSerInner2).nullable)

    public val repeatSer: KSerializer<Timing.Repeat> = Timing.Repeat.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}
