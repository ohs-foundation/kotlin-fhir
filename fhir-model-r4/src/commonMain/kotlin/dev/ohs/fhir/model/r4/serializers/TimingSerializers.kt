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
import dev.ohs.fhir.model.r4.terminologies.DaysOfWeek
import dev.ohs.fhir.model.r4.terminologies.EventTiming
import dev.ohs.fhir.model.r4.terminologies.UnitsOfTime
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TimingRepeatSerializer : FhirSerializer<Timing.Repeat> {
  override val descriptor: SerialDescriptor = buildDescriptor("Repeat", this)

  @JvmField internal val listSerializer: KSerializer<List<Timing.Repeat>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement("boundsDuration", lazyDescriptor(LazyDescriptorId.DurationSerializer))
    b.optionalElement("boundsRange", lazyDescriptor(LazyDescriptorId.RangeSerializer))
    b.optionalElement("boundsPeriod", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
    b.intPrim("count")
    b.intPrim("countMax")
    b.prim("duration", FhirDecimalSerializer.descriptor)
    b.prim("durationMax", FhirDecimalSerializer.descriptor)
    b.strPrim("durationUnit")
    b.intPrim("frequency")
    b.intPrim("frequencyMax")
    b.prim("period", FhirDecimalSerializer.descriptor)
    b.prim("periodMax", FhirDecimalSerializer.descriptor)
    b.strPrim("periodUnit")
    b.strPrimList("dayOfWeek")
    b.primList("timeOfDay", LocalTimeSerializer.nullableListSerializer.descriptor)
    b.strPrimList("when")
    b.intPrim("offset")
  }

  override fun deserialize(decoder: Decoder): Timing.Repeat {
    val descriptor = this.descriptor
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
    var durationUnit: UnitsOfTime? = null
    var _durationUnit: Element? = null
    var frequency: Int? = null
    var _frequency: Element? = null
    var frequencyMax: Int? = null
    var _frequencyMax: Element? = null
    var period: FhirDecimal? = null
    var _period: Element? = null
    var periodMax: FhirDecimal? = null
    var _periodMax: Element? = null
    var periodUnit: UnitsOfTime? = null
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
        13 ->
          durationUnit = UnitsOfTime.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        23 -> periodUnit = UnitsOfTime.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val dayOfWeek_ =
      List(maxSize(dayOfWeek, _dayOfWeek)) { index ->
        entryRequired(
          Enumeration.of(
            at(dayOfWeek, index)?.let { DaysOfWeek.fromCode(it) },
            at(_dayOfWeek, index),
          ),
          "Timing.Repeat",
          "dayOfWeek",
        )
      }
    val timeOfDay_ =
      List(maxSize(timeOfDay, _timeOfDay)) { index ->
        entryRequired(
          Time.of(at(timeOfDay, index), at(_timeOfDay, index)),
          "Timing.Repeat",
          "timeOfDay",
        )
      }
    val when_ =
      List(maxSize(`when`, _when)) { index ->
        entryRequired(
          Enumeration.of(at(`when`, index)?.let { EventTiming.fromCode(it) }, at(_when, index)),
          "Timing.Repeat",
          "when",
        )
      }
    return Timing.Repeat(
      id = id,
      extension = listOrEmpty(extension),
      bounds = Timing.Repeat.Bounds.from(boundsDuration, boundsRange, boundsPeriod),
      count = PositiveInt.of(count, _count),
      countMax = PositiveInt.of(countMax, _countMax),
      duration = Decimal.of(duration, _duration),
      durationMax = Decimal.of(durationMax, _durationMax),
      durationUnit = Enumeration.of(durationUnit, _durationUnit),
      frequency = PositiveInt.of(frequency, _frequency),
      frequencyMax = PositiveInt.of(frequencyMax, _frequencyMax),
      period = Decimal.of(period, _period),
      periodMax = Decimal.of(periodMax, _periodMax),
      periodUnit = Enumeration.of(periodUnit, _periodUnit),
      dayOfWeek = dayOfWeek_,
      timeOfDay = timeOfDay_,
      `when` = when_,
      offset = UnsignedInt.of(offset, _offset),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
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
    if (!value.dayOfWeek.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        25,
        stringNullableListSerializer,
        value.dayOfWeek.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 26, value.dayOfWeek)
    }
    if (!value.timeOfDay.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        27,
        LocalTimeSerializer.nullableListSerializer,
        value.timeOfDay.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 28, value.timeOfDay)
    }
    if (!value.`when`.isEmpty()) {
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

internal object TimingSerializer : FhirSerializer<Timing> {
  override val descriptor: SerialDescriptor = buildDescriptor("Timing", this)

  @JvmField internal val listSerializer: KSerializer<List<Timing>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement(
      "modifierExtension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrimList("event")
    b.optionalElement("repeat", TimingRepeatSerializer.descriptor)
    b.optionalElement("code", lazyDescriptor(LazyDescriptorId.CodeableConceptSerializer))
  }

  override fun deserialize(decoder: Decoder): Timing {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val event_ =
      List(maxSize(event, _event)) { index ->
        entryRequired(
          DateTime.of(at(event, index)?.let { FhirDateTime.fromString(it) }, at(_event, index)),
          "Timing",
          "event",
        )
      }
    return Timing(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      event = event_,
      repeat = repeat,
      code = code,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Timing) {
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
    if (!value.event.isEmpty()) {
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
