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
import kotlin.Boolean as KotlinBoolean
import kotlin.OptIn
import kotlin.String as KotlinString
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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object AvailabilityAvailableTimeSerializer : KSerializer<Availability.AvailableTime> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AvailableTime") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("daysOfWeek", stringNullableListSerializer.descriptor)
      optionalElement("_daysOfWeek", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("allDay", KotlinBoolean.serializer().descriptor)
      optionalElement("_allDay", ElementSerializer.descriptor)
      optionalElement("availableStartTime", LocalTimeSerializer.descriptor)
      optionalElement("_availableStartTime", ElementSerializer.descriptor)
      optionalElement("availableEndTime", LocalTimeSerializer.descriptor)
      optionalElement("_availableEndTime", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Availability.AvailableTime>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Availability.AvailableTime =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            daysOfWeek =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          3 ->
            _daysOfWeek =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          4 -> allDay = decodeBooleanElement(descriptor, i)
          5 -> _allDay = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            availableStartTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          7 ->
            _availableStartTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            availableEndTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          9 ->
            _availableEndTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AvailableTime: " + i)
        }
      }
      Availability.AvailableTime(
        id = id,
        extension = extension ?: listOf(),
        daysOfWeek =
          (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { index ->
            Enumeration.of(
              daysOfWeek?.getOrNull(index)?.let { Availability.DaysOfWeek.fromCode(it) },
              _daysOfWeek?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'daysOfWeek' on Availability.AvailableTime has neither a value nor an id/extension"
              )
          }),
        allDay = R5Boolean.of(allDay, _allDay),
        availableStartTime = Time.of(availableStartTime, _availableStartTime),
        availableEndTime = Time.of(availableEndTime, _availableEndTime),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Availability.AvailableTime) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.daysOfWeek.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          2,
          stringNullableListSerializer,
          value.daysOfWeek.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 3, value.daysOfWeek)
      }
      encodeBooleanIfNotNull(descriptor, 4, value.allDay?.value)
      encodeElementIfNotNull(descriptor, 5, value.allDay)
      encodeSerializableIfNotNull(
        descriptor,
        6,
        LocalTimeSerializer,
        value.availableStartTime?.value,
      )
      encodeElementIfNotNull(descriptor, 7, value.availableStartTime)
      encodeSerializableIfNotNull(descriptor, 8, LocalTimeSerializer, value.availableEndTime?.value)
      encodeElementIfNotNull(descriptor, 9, value.availableEndTime)
    }
  }
}

internal object AvailabilityNotAvailableTimeSerializer :
  KSerializer<Availability.NotAvailableTime> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotAvailableTime") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("during", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Availability.NotAvailableTime>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Availability.NotAvailableTime =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var during: Period? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 -> description = decodeStringElement(descriptor, i)
          3 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> during = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NotAvailableTime: " + i)
        }
      }
      Availability.NotAvailableTime(
        id = id,
        extension = extension ?: listOf(),
        description = R5String.of(description, _description),
        during = during,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Availability.NotAvailableTime) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.description?.value)
      encodeElementIfNotNull(descriptor, 3, value.description)
      encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.during)
    }
  }
}

internal object AvailabilitySerializer : KSerializer<Availability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Availability") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "availableTime",
        AvailabilityAvailableTimeSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "notAvailableTime",
        AvailabilityNotAvailableTimeSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Availability>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Availability =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var availableTime: List<Availability.AvailableTime>? = null
      var notAvailableTime: List<Availability.NotAvailableTime>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            availableTime =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AvailabilityAvailableTimeSerializer.listSerializer,
                null,
              )
          3 ->
            notAvailableTime =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AvailabilityNotAvailableTimeSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Availability: " + i)
        }
      }
      Availability(
        id = id,
        extension = extension ?: listOf(),
        availableTime = availableTime ?: listOf(),
        notAvailableTime = notAvailableTime ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Availability) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.availableTime.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          AvailabilityAvailableTimeSerializer.listSerializer,
          value.availableTime,
        )
      if (value.notAvailableTime.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          AvailabilityNotAvailableTimeSerializer.listSerializer,
          value.notAvailableTime,
        )
    }
  }
}
