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

import dev.ohs.fhir.model.r5.Availability
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
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

internal object AvailabilityAvailableTimeSerializer : KSerializer<Availability.AvailableTime> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AvailableTime") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "daysOfWeek",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_daysOfWeek",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element("allDay", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allDay", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("availableStartTime", LocalTimeSerializer.descriptor, isOptional = true)
      element(
        "_availableStartTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("availableEndTime", LocalTimeSerializer.descriptor, isOptional = true)
      element(
        "_availableEndTime",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Availability.AvailableTime =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Availability.AvailableTime) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Availability.AvailableTime {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer, null)
        3 ->
          _daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer2, null)
        4 -> allDay = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _allDay =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        6 ->
          availableStartTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        7 ->
          _availableStartTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        8 ->
          availableEndTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        9 ->
          _availableEndTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AvailableTime: " + __i)
      }
    }
    return Availability.AvailableTime(
      id = id,
      extension = extension ?: listOf(),
      daysOfWeek =
        (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { __i ->
          Enumeration.of(
            Availability.DaysOfWeek.fromCode(daysOfWeek?.getOrNull(__i)!!),
            _daysOfWeek?.getOrNull(__i),
          )
        }),
      allDay = R5Boolean.of(allDay, _allDay),
      availableStartTime = Time.of(availableStartTime, _availableStartTime),
      availableEndTime = Time.of(availableEndTime, _availableEndTime),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Availability.AvailableTime) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    (value.daysOfWeek.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 2, Hoisted.daysOfWeekSer, it)
    }
    (value.daysOfWeek.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.daysOfWeekSer2, it)
    }
    ((value.allDay?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.allDay?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.availableStartTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, LocalTimeSerializer, it)
    }
    (value.availableStartTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.availableEndTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 8, LocalTimeSerializer, it)
    }
    (value.availableEndTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.daysOfWeekSerInner2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val daysOfWeekSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val daysOfWeekSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.daysOfWeekSerInner).nullable)

    public val daysOfWeekSerInner2: KSerializer<Element> = Element.serializer()

    public val daysOfWeekSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.daysOfWeekSerInner2).nullable)
  }
}

internal object AvailabilityNotAvailableTimeSerializer :
  KSerializer<Availability.NotAvailableTime> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotAvailableTime") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("during", lazyDescriptor { Period.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Availability.NotAvailableTime =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Availability.NotAvailableTime) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Availability.NotAvailableTime {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var during: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> description = decoder.decodeStringElement(__desc, __i)
        3 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        4 ->
          during = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.duringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotAvailableTime: " + __i)
      }
    }
    return Availability.NotAvailableTime(
      id = id,
      extension = extension ?: listOf(),
      description = R5String.of(description, _description),
      during = during,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Availability.NotAvailableTime) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.descriptionSer, it)
    }
    (value.during)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.duringSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val duringSer: KSerializer<Period> = Period.serializer()
  }
}

internal object AvailabilitySerializer : KSerializer<Availability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Availability") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "availableTime",
        listSerialDescriptor(lazyDescriptor { Availability.AvailableTime.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "notAvailableTime",
        listSerialDescriptor(
          lazyDescriptor { Availability.NotAvailableTime.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Availability =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Availability) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Availability {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var availableTime: List<Availability.AvailableTime>? = null
    var notAvailableTime: List<Availability.NotAvailableTime>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          availableTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.availableTimeSer, null)
        3 ->
          notAvailableTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.notAvailableTimeSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Availability: " + __i)
      }
    }
    return Availability(
      id = id,
      extension = extension ?: listOf(),
      availableTime = availableTime ?: listOf(),
      notAvailableTime = notAvailableTime ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Availability) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.availableTime.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.availableTimeSer, value.availableTime)
    if (value.notAvailableTime.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        3,
        Hoisted.notAvailableTimeSer,
        value.notAvailableTime,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val availableTimeSerInner: KSerializer<Availability.AvailableTime> =
      Availability.AvailableTime.serializer()

    public val availableTimeSer: KSerializer<List<Availability.AvailableTime>> =
      ListSerializer(Hoisted.availableTimeSerInner)

    public val notAvailableTimeSerInner: KSerializer<Availability.NotAvailableTime> =
      Availability.NotAvailableTime.serializer()

    public val notAvailableTimeSer: KSerializer<List<Availability.NotAvailableTime>> =
      ListSerializer(Hoisted.notAvailableTimeSerInner)
  }
}
