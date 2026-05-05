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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.UnsignedInt
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Timing.Repeat {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          boundsDuration =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.boundsDurationSer, null)
        3 ->
          boundsRange =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.boundsRangeSer, null)
        4 ->
          boundsPeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.boundsPeriodSer, null)
        5 -> count = decoder.decodeIntElement(__desc, __i)
        6 -> _count = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        7 -> countMax = decoder.decodeIntElement(__desc, __i)
        8 ->
          _countMax = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        9 ->
          duration =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        10 ->
          _duration = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        11 ->
          durationMax =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        12 ->
          _durationMax =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        13 -> durationUnit = decoder.decodeStringElement(__desc, __i)
        14 ->
          _durationUnit =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        15 -> frequency = decoder.decodeIntElement(__desc, __i)
        16 ->
          _frequency =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        17 -> frequencyMax = decoder.decodeIntElement(__desc, __i)
        18 ->
          _frequencyMax =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        19 ->
          period =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        20 ->
          _period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        21 ->
          periodMax =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        22 ->
          _periodMax =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        23 -> periodUnit = decoder.decodeStringElement(__desc, __i)
        24 ->
          _periodUnit =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        25 ->
          dayOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dayOfWeekSer, null)
        26 ->
          _dayOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dayOfWeekSer2, null)
        27 ->
          timeOfDay =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.timeOfDaySer, null)
        28 ->
          _timeOfDay =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dayOfWeekSer2, null)
        29 ->
          `when` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dayOfWeekSer, null)
        30 ->
          _when =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dayOfWeekSer2, null)
        31 -> offset = decoder.decodeIntElement(__desc, __i)
        32 ->
          _offset = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.countSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repeat: " + __i)
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
        (kotlin.collections.List(maxOf(dayOfWeek?.size ?: 0, _dayOfWeek?.size ?: 0)) { __i ->
          Enumeration.of(
            Timing.DaysOfWeek.fromCode(dayOfWeek?.getOrNull(__i)!!),
            _dayOfWeek?.getOrNull(__i),
          )
        }),
      timeOfDay =
        (kotlin.collections.List(maxOf(timeOfDay?.size ?: 0, _timeOfDay?.size ?: 0)) { __i ->
          Time.of(timeOfDay?.getOrNull(__i)?.let { it }, _timeOfDay?.getOrNull(__i))!!
        }),
      `when` =
        (kotlin.collections.List(maxOf(`when`?.size ?: 0, _when?.size ?: 0)) { __i ->
          Enumeration.of(
            Timing.EventTiming.fromCode(`when`?.getOrNull(__i)!!),
            _when?.getOrNull(__i),
          )
        }),
      offset = UnsignedInt.of(offset, _offset),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Timing.Repeat) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    when (val __d = value.bounds) {
      null -> {}
      is Timing.Repeat.Bounds.Duration -> {
        encoder.encodeSerializableElement(__desc, 2, Hoisted.boundsDurationSer, __d.value)
      }
      is Timing.Repeat.Bounds.Range -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.boundsRangeSer, __d.value)
      }
      is Timing.Repeat.Bounds.Period -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.boundsPeriodSer, __d.value)
      }
    }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.countSer, it)
    }
    ((value.countMax?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.countMax?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.countSer, it)
    }
    ((value.duration?.value))?.let {
      encoder.encodeSerializableElement(__desc, 9, BigDecimalSerializer, it)
    }
    (value.duration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.countSer, it)
    }
    ((value.durationMax?.value))?.let {
      encoder.encodeSerializableElement(__desc, 11, BigDecimalSerializer, it)
    }
    (value.durationMax?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.countSer, it)
    }
    ((value.durationUnit?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.durationUnit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.countSer, it)
    }
    ((value.frequency?.value))?.let { encoder.encodeIntElement(__desc, 15, it) }
    (value.frequency?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.countSer, it)
    }
    ((value.frequencyMax?.value))?.let { encoder.encodeIntElement(__desc, 17, it) }
    (value.frequencyMax?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.countSer, it)
    }
    ((value.period?.value))?.let {
      encoder.encodeSerializableElement(__desc, 19, BigDecimalSerializer, it)
    }
    (value.period?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.countSer, it)
    }
    ((value.periodMax?.value))?.let {
      encoder.encodeSerializableElement(__desc, 21, BigDecimalSerializer, it)
    }
    (value.periodMax?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.countSer, it)
    }
    ((value.periodUnit?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.periodUnit?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.countSer, it)
    }
    (value.dayOfWeek.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.dayOfWeekSer, it)
    }
    (value.dayOfWeek.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.dayOfWeekSer2, it)
    }
    (value.timeOfDay.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.timeOfDaySer, it)
    }
    (value.timeOfDay.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.dayOfWeekSer2, it)
    }
    (value.`when`.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.dayOfWeekSer, it)
    }
    (value.`when`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.dayOfWeekSer2, it)
    }
    ((value.offset?.value))?.let { encoder.encodeIntElement(__desc, 31, it) }
    (value.offset?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.countSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Timing) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Timing {
    val __desc = descriptor
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var event: List<String?>? = null
    var _event: List<Element?>? = null
    var repeat: Timing.Repeat? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> event = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventSer, null)
        4 ->
          _event = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.eventSer2, null)
        5 ->
          repeat = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.repeatSer, null)
        6 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Timing: " + __i)
      }
    }
    return Timing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      event =
        (kotlin.collections.List(maxOf(event?.size ?: 0, _event?.size ?: 0)) { __i ->
          DateTime.of(
            event?.getOrNull(__i)?.let { FhirDateTime.fromString(it) },
            _event?.getOrNull(__i),
          )!!
        }),
      repeat = repeat,
      code = code,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Timing) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.event.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.eventSer, it)
    }
    (value.event.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.eventSer2, it)
    }
    (value.repeat)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.repeatSer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, it) }
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
