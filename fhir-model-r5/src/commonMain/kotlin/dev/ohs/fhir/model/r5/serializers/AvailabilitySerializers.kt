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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.terminologies.DaysOfWeek
import kotlin.Boolean as KotlinBoolean
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object AvailabilityAvailableTimeSerializer : FhirSerializer<Availability.AvailableTime> {
  override val descriptor: SerialDescriptor = buildDescriptor("AvailableTime", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Availability.AvailableTime>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrimList("daysOfWeek")
    b.boolPrim("allDay")
    b.prim("availableStartTime", LocalTimeSerializer.descriptor)
    b.prim("availableEndTime", LocalTimeSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Availability.AvailableTime {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var daysOfWeek: List<KotlinString?>? = null
    var _daysOfWeek: List<Element?>? = null
    var allDay: KotlinBoolean? = null
    var _allDay: Element? = null
    var availableStartTime: LocalTime? = null
    var _availableStartTime: Element? = null
    var availableEndTime: LocalTime? = null
    var _availableEndTime: Element? = null
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
          daysOfWeek =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        3 ->
          _daysOfWeek =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        4 -> allDay = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _allDay =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          availableStartTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        7 ->
          _availableStartTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          availableEndTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        9 ->
          _availableEndTime =
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
    val daysOfWeek_ =
      List(maxSize(daysOfWeek, _daysOfWeek)) { index ->
        entryRequired(
          Enumeration.of(
            at(daysOfWeek, index)?.let { DaysOfWeek.fromCode(it) },
            at(_daysOfWeek, index),
          ),
          "Availability.AvailableTime",
          "daysOfWeek",
        )
      }
    return Availability.AvailableTime(
      id = id,
      extension = listOrEmpty(extension),
      daysOfWeek = daysOfWeek_,
      allDay = R5Boolean.of(allDay, _allDay),
      availableStartTime = Time.of(availableStartTime, _availableStartTime),
      availableEndTime = Time.of(availableEndTime, _availableEndTime),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Availability.AvailableTime) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    if (!value.daysOfWeek.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        2,
        stringNullableListSerializer,
        value.daysOfWeek.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 3, value.daysOfWeek)
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.allDay?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.allDay)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      LocalTimeSerializer,
      value.availableStartTime?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.availableStartTime)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      LocalTimeSerializer,
      value.availableEndTime?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.availableEndTime)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AvailabilityNotAvailableTimeSerializer :
  FhirSerializer<Availability.NotAvailableTime> {
  override val descriptor: SerialDescriptor = buildDescriptor("NotAvailableTime", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Availability.NotAvailableTime>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("description")
    b.optionalElement("during", lazyDescriptor(LazyDescriptorId.PeriodSerializer))
  }

  override fun deserialize(decoder: Decoder): Availability.NotAvailableTime {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var during: Period? = null
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
        2 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          during =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Availability.NotAvailableTime(
      id = id,
      extension = listOrEmpty(extension),
      description = R5String.of(description, _description),
      during = during,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Availability.NotAvailableTime) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.description)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.during)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AvailabilitySerializer : FhirSerializer<Availability> {
  override val descriptor: SerialDescriptor = buildDescriptor("Availability", this)

  @JvmField internal val listSerializer: KSerializer<List<Availability>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.optionalElement(
      "availableTime",
      AvailabilityAvailableTimeSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "notAvailableTime",
      AvailabilityNotAvailableTimeSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): Availability {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var availableTime: List<Availability.AvailableTime>? = null
    var notAvailableTime: List<Availability.NotAvailableTime>? = null
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
          availableTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilityAvailableTimeSerializer.listSerializer,
              null,
            )
        3 ->
          notAvailableTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AvailabilityNotAvailableTimeSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Availability(
      id = id,
      extension = listOrEmpty(extension),
      availableTime = listOrEmpty(availableTime),
      notAvailableTime = listOrEmpty(notAvailableTime),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Availability) {
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
      AvailabilityAvailableTimeSerializer.listSerializer,
      value.availableTime,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      AvailabilityNotAvailableTimeSerializer.listSerializer,
      value.notAvailableTime,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
