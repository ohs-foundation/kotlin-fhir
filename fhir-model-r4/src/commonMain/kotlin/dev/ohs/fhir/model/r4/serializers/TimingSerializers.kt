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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.UnsignedInt
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TimingRepeatSerializer : KSerializer<Timing.Repeat> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repeat") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("boundsDuration", lazyDescriptor { DurationSerializer.descriptor })
      optionalElement("boundsRange", lazyDescriptor { RangeSerializer.descriptor })
      optionalElement("boundsPeriod", lazyDescriptor { PeriodSerializer.descriptor })
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("countMax", Int.serializer().descriptor)
      optionalElement("_countMax", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("duration", FhirDecimalSerializer.descriptor)
      optionalElement("_duration", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("durationMax", FhirDecimalSerializer.descriptor)
      optionalElement("_durationMax", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("durationUnit", String.serializer().descriptor)
      optionalElement("_durationUnit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("frequency", Int.serializer().descriptor)
      optionalElement("_frequency", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("frequencyMax", Int.serializer().descriptor)
      optionalElement("_frequencyMax", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("period", FhirDecimalSerializer.descriptor)
      optionalElement("_period", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("periodMax", FhirDecimalSerializer.descriptor)
      optionalElement("_periodMax", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("periodUnit", String.serializer().descriptor)
      optionalElement("_periodUnit", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("dayOfWeek", stringNullableListSerializer.descriptor)
      optionalElement(
        "_dayOfWeek",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("timeOfDay", LocalTimeSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "_timeOfDay",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("when", stringNullableListSerializer.descriptor)
      optionalElement(
        "_when",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("offset", Int.serializer().descriptor)
      optionalElement("_offset", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Timing.Repeat>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Timing.Repeat {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var boundsDuration: Duration? = null
    var boundsRange: Range? = null
    var boundsPeriod: Period? = null
    var count: Int? = null
    var _count: Element? = null
    var countMax: Int? = null
    var _countMax: Element? = null
    var duration: FhirDecimal? = null
    var _duration: Element? = null
    var durationMax: FhirDecimal? = null
    var _durationMax: Element? = null
    var durationUnit: String? = null
    var _durationUnit: Element? = null
    var frequency: Int? = null
    var _frequency: Element? = null
    var frequencyMax: Int? = null
    var _frequencyMax: Element? = null
    var period: FhirDecimal? = null
    var _period: Element? = null
    var periodMax: FhirDecimal? = null
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
          boundsDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        3 ->
          boundsRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        4 ->
          boundsPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        5 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> countMax = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _countMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          duration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        10 ->
          _duration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          durationMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        12 ->
          _durationMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> durationUnit = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _durationUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> frequency = compositeDecoder.decodeIntElement(descriptor, i)
        16 ->
          _frequency =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> frequencyMax = compositeDecoder.decodeIntElement(descriptor, i)
        18 ->
          _frequencyMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        20 ->
          _period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          periodMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        22 ->
          _periodMax =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> periodUnit = compositeDecoder.decodeStringElement(descriptor, i)
        24 ->
          _periodUnit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          dayOfWeek =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        26 ->
          _dayOfWeek =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        27 ->
          timeOfDay =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer.nullableListSerializer,
              null,
            )
        28 ->
          _timeOfDay =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        29 ->
          `when` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        30 ->
          _when =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        31 -> offset = compositeDecoder.decodeIntElement(descriptor, i)
        32 ->
          _offset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repeat: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Timing.Repeat(
      id = id,
      extension = extension ?: listOf(),
      bounds = Timing.Repeat.Bounds.from(boundsDuration, boundsRange, boundsPeriod),
      count = PositiveInt.of(count, _count),
      countMax = PositiveInt.of(countMax, _countMax),
      duration = Decimal.of(duration, _duration),
      durationMax = Decimal.of(durationMax, _durationMax),
      durationUnit =
        Enumeration.of(
          if (durationUnit != null) Timing.UnitsOfTime.fromCode(durationUnit) else null,
          _durationUnit,
        ),
      frequency = PositiveInt.of(frequency, _frequency),
      frequencyMax = PositiveInt.of(frequencyMax, _frequencyMax),
      period = Decimal.of(period, _period),
      periodMax = Decimal.of(periodMax, _periodMax),
      periodUnit =
        Enumeration.of(
          if (periodUnit != null) Timing.UnitsOfTime.fromCode(periodUnit) else null,
          _periodUnit,
        ),
      dayOfWeek =
        (kotlin.collections.List(maxOf(dayOfWeek?.size ?: 0, _dayOfWeek?.size ?: 0)) { index ->
          Enumeration.of(
            dayOfWeek?.getOrNull(index)?.let { Timing.DaysOfWeek.fromCode(it) },
            _dayOfWeek?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'dayOfWeek' on Timing.Repeat has neither a value nor an id/extension"
            )
        }),
      timeOfDay =
        (kotlin.collections.List(maxOf(timeOfDay?.size ?: 0, _timeOfDay?.size ?: 0)) { index ->
          Time.of(timeOfDay?.getOrNull(index), _timeOfDay?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'timeOfDay' on Timing.Repeat has neither a value nor an id/extension"
            )
        }),
      `when` =
        (kotlin.collections.List(maxOf(`when`?.size ?: 0, _when?.size ?: 0)) { index ->
          Enumeration.of(
            `when`?.getOrNull(index)?.let { Timing.EventTiming.fromCode(it) },
            _when?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'when' on Timing.Repeat has neither a value nor an id/extension"
            )
        }),
      offset = UnsignedInt.of(offset, _offset),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    when (val choice = value.bounds) {
      null -> {}
      is Timing.Repeat.Bounds.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 2, DurationSerializer, choice.value)
      }
      is Timing.Repeat.Bounds.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 3, RangeSerializer, choice.value)
      }
      is Timing.Repeat.Bounds.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, PeriodSerializer, choice.value)
      }
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.count)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.countMax?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.countMax)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      FhirDecimalSerializer,
      value.duration?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.duration)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      FhirDecimalSerializer,
      value.durationMax?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.durationMax)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.durationUnit?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.durationUnit)
    compositeEncoder.encodeIntIfNotNull(descriptor, 15, value.frequency?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.frequency)
    compositeEncoder.encodeIntIfNotNull(descriptor, 17, value.frequencyMax?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.frequencyMax)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19,
      FhirDecimalSerializer,
      value.period?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.period)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21,
      FhirDecimalSerializer,
      value.periodMax?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.periodMax)
    compositeEncoder.encodeStringIfNotNull(descriptor, 23, value.periodUnit?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24, value.periodUnit)
    if (value.dayOfWeek.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        25,
        stringNullableListSerializer,
        value.dayOfWeek.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 26, value.dayOfWeek)
    }
    if (value.timeOfDay.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        27,
        LocalTimeSerializer.nullableListSerializer,
        value.timeOfDay.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 28, value.timeOfDay)
    }
    if (value.`when`.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        29,
        stringNullableListSerializer,
        value.`when`.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 30, value.`when`)
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 31, value.offset?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 32, value.offset)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TimingSerializer : KSerializer<Timing> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Timing") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement(
        "modifierExtension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("event", stringNullableListSerializer.descriptor)
      optionalElement(
        "_event",
        listSerialDescriptor(lazyDescriptor { ElementSerializer.descriptor }),
      )
      optionalElement("repeat", TimingRepeatSerializer.descriptor)
      optionalElement("code", lazyDescriptor { CodeableConceptSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Timing>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Timing {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var event: List<String?>? = null
    var _event: List<Element?>? = null
    var repeat: Timing.Repeat? = null
    var code: CodeableConcept? = null
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
          event =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        4 ->
          _event =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          repeat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingRepeatSerializer,
              null,
            )
        6 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Timing: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Timing(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      event =
        (kotlin.collections.List(maxOf(event?.size ?: 0, _event?.size ?: 0)) { index ->
          DateTime.of(
            event?.getOrNull(index)?.let { FhirDateTime.fromString(it) },
            _event?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'event' on Timing has neither a value nor an id/extension"
            )
        }),
      repeat = repeat,
      code = code,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Timing) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.event.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        stringNullableListSerializer,
        value.event.map { it.value?.toString() },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.event)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      TimingRepeatSerializer,
      value.repeat,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
