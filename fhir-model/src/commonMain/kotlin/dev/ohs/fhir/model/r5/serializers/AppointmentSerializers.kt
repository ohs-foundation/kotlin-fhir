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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Appointment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VirtualServiceDetail
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object AppointmentParticipantSerializer : KSerializer<Appointment.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
      element("required", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_required", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Appointment.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Appointment.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var period: Period? = null
    var actor: Reference? = null
    var required: KotlinBoolean? = null
    var _required: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        5 -> actor = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.actorSer, null)
        6 -> required = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _required =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.requiredSer, null)
        8 -> status = decoder.decodeStringElement(__desc, 8)
        9 ->
          _status = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.requiredSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return Appointment.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type ?: listOf(),
      period = period,
      actor = actor,
      required = R5Boolean.of(required, _required),
      status = Enumeration.of(Appointment.ParticipationStatus.fromCode(status!!), _status),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Appointment.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, value.type)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.actorSer, it) }
    ((value.required?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.requiredSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.requiredSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()

    public val requiredSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AppointmentRecurrenceTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RecurrenceTemplate") {
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
      element("timezone", CodeableConcept.serializer().descriptor, isOptional = true)
      element("recurrenceType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("lastOccurrenceDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastOccurrenceDate", Element.serializer().descriptor, isOptional = true)
      element("occurrenceCount", Int.serializer().descriptor, isOptional = true)
      element("_occurrenceCount", Element.serializer().descriptor, isOptional = true)
      element(
        "occurrenceDate",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_occurrenceDate",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "weeklyTemplate",
        lazyDescriptor { Appointment.RecurrenceTemplate.WeeklyTemplate.serializer().descriptor },
        isOptional = true,
      )
      element(
        "monthlyTemplate",
        lazyDescriptor { Appointment.RecurrenceTemplate.MonthlyTemplate.serializer().descriptor },
        isOptional = true,
      )
      element(
        "yearlyTemplate",
        lazyDescriptor { Appointment.RecurrenceTemplate.YearlyTemplate.serializer().descriptor },
        isOptional = true,
      )
      element(
        "excludingDate",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_excludingDate",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "excludingRecurrenceId",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_excludingRecurrenceId",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Appointment.RecurrenceTemplate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var timezone: CodeableConcept? = null
    var recurrenceType: CodeableConcept? = null
    var lastOccurrenceDate: KotlinString? = null
    var _lastOccurrenceDate: Element? = null
    var occurrenceCount: Int? = null
    var _occurrenceCount: Element? = null
    var occurrenceDate: List<KotlinString?>? = null
    var _occurrenceDate: List<Element?>? = null
    var weeklyTemplate: Appointment.RecurrenceTemplate.WeeklyTemplate? = null
    var monthlyTemplate: Appointment.RecurrenceTemplate.MonthlyTemplate? = null
    var yearlyTemplate: Appointment.RecurrenceTemplate.YearlyTemplate? = null
    var excludingDate: List<KotlinString?>? = null
    var _excludingDate: List<Element?>? = null
    var excludingRecurrenceId: List<Int?>? = null
    var _excludingRecurrenceId: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          timezone = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.timezoneSer, null)
        4 ->
          recurrenceType =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.timezoneSer, null)
        5 -> lastOccurrenceDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _lastOccurrenceDate =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.lastOccurrenceDateSer,
              null,
            )
        7 -> occurrenceCount = decoder.decodeIntElement(__desc, 7)
        8 ->
          _occurrenceCount =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.lastOccurrenceDateSer,
              null,
            )
        9 ->
          occurrenceDate =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.occurrenceDateSer, null)
        10 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.occurrenceDateSer2, null)
        11 ->
          weeklyTemplate =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.weeklyTemplateSer, null)
        12 ->
          monthlyTemplate =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.monthlyTemplateSer, null)
        13 ->
          yearlyTemplate =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.yearlyTemplateSer, null)
        14 ->
          excludingDate =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.occurrenceDateSer, null)
        15 ->
          _excludingDate =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.occurrenceDateSer2, null)
        16 ->
          excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(
              __desc,
              16,
              Hoisted.excludingRecurrenceIdSer,
              null,
            )
        17 ->
          _excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.occurrenceDateSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RecurrenceTemplate: " + __i)
      }
    }
    return Appointment.RecurrenceTemplate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      timezone = timezone,
      recurrenceType = recurrenceType!!,
      lastOccurrenceDate = Date.of(FhirDate.fromString(lastOccurrenceDate), _lastOccurrenceDate),
      occurrenceCount = PositiveInt.of(occurrenceCount, _occurrenceCount),
      occurrenceDate =
        (kotlin.collections.List(maxOf(occurrenceDate?.size ?: 0, _occurrenceDate?.size ?: 0)) { __i
          ->
          Date.of(
            occurrenceDate?.getOrNull(__i)?.let { FhirDate.fromString(it) },
            _occurrenceDate?.getOrNull(__i),
          )!!
        }),
      weeklyTemplate = weeklyTemplate,
      monthlyTemplate = monthlyTemplate,
      yearlyTemplate = yearlyTemplate,
      excludingDate =
        (kotlin.collections.List(maxOf(excludingDate?.size ?: 0, _excludingDate?.size ?: 0)) { __i
          ->
          Date.of(
            excludingDate?.getOrNull(__i)?.let { FhirDate.fromString(it) },
            _excludingDate?.getOrNull(__i),
          )!!
        }),
      excludingRecurrenceId =
        (kotlin.collections.List(
          maxOf(excludingRecurrenceId?.size ?: 0, _excludingRecurrenceId?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            excludingRecurrenceId?.getOrNull(__i)?.let { it },
            _excludingRecurrenceId?.getOrNull(__i),
          )!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Appointment.RecurrenceTemplate) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.timezone)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.timezoneSer, it) }
    (value.recurrenceType)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.timezoneSer, it)
    }
    ((value.lastOccurrenceDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 5, it)
    }
    (value.lastOccurrenceDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.lastOccurrenceDateSer, it)
    }
    ((value.occurrenceCount?.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.occurrenceCount?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.lastOccurrenceDateSer, it)
    }
    (value.occurrenceDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.occurrenceDateSer, it)
    }
    (value.occurrenceDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.occurrenceDateSer2, it)
    }
    (value.weeklyTemplate)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.weeklyTemplateSer, it)
    }
    (value.monthlyTemplate)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.monthlyTemplateSer, it)
    }
    (value.yearlyTemplate)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.yearlyTemplateSer, it)
    }
    (value.excludingDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.occurrenceDateSer, it)
    }
    (value.excludingDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.occurrenceDateSer2, it)
    }
    (value.excludingRecurrenceId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.excludingRecurrenceIdSer, it)
    }
    (value.excludingRecurrenceId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.occurrenceDateSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val timezoneSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val lastOccurrenceDateSer: KSerializer<Element> = Element.serializer()

    public val occurrenceDateSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val occurrenceDateSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.occurrenceDateSerInner).nullable)

    public val occurrenceDateSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.lastOccurrenceDateSer).nullable)

    public val weeklyTemplateSer: KSerializer<Appointment.RecurrenceTemplate.WeeklyTemplate> =
      Appointment.RecurrenceTemplate.WeeklyTemplate.serializer()

    public val monthlyTemplateSer: KSerializer<Appointment.RecurrenceTemplate.MonthlyTemplate> =
      Appointment.RecurrenceTemplate.MonthlyTemplate.serializer()

    public val yearlyTemplateSer: KSerializer<Appointment.RecurrenceTemplate.YearlyTemplate> =
      Appointment.RecurrenceTemplate.YearlyTemplate.serializer()

    public val excludingRecurrenceIdSerInner: KSerializer<Int> = Int.serializer()

    public val excludingRecurrenceIdSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.excludingRecurrenceIdSerInner).nullable)
  }
}

internal object AppointmentRecurrenceTemplateWeeklyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.WeeklyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WeeklyTemplate") {
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
      element("monday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_monday", Element.serializer().descriptor, isOptional = true)
      element("tuesday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_tuesday", Element.serializer().descriptor, isOptional = true)
      element("wednesday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_wednesday", Element.serializer().descriptor, isOptional = true)
      element("thursday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_thursday", Element.serializer().descriptor, isOptional = true)
      element("friday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_friday", Element.serializer().descriptor, isOptional = true)
      element("saturday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_saturday", Element.serializer().descriptor, isOptional = true)
      element("sunday", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_sunday", Element.serializer().descriptor, isOptional = true)
      element("weekInterval", Int.serializer().descriptor, isOptional = true)
      element("_weekInterval", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.WeeklyTemplate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.WeeklyTemplate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.WeeklyTemplate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var monday: KotlinBoolean? = null
    var _monday: Element? = null
    var tuesday: KotlinBoolean? = null
    var _tuesday: Element? = null
    var wednesday: KotlinBoolean? = null
    var _wednesday: Element? = null
    var thursday: KotlinBoolean? = null
    var _thursday: Element? = null
    var friday: KotlinBoolean? = null
    var _friday: Element? = null
    var saturday: KotlinBoolean? = null
    var _saturday: Element? = null
    var sunday: KotlinBoolean? = null
    var _sunday: Element? = null
    var weekInterval: Int? = null
    var _weekInterval: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> monday = decoder.decodeBooleanElement(__desc, 3)
        4 -> _monday = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.mondaySer, null)
        5 -> tuesday = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _tuesday = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.mondaySer, null)
        7 -> wednesday = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _wednesday = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.mondaySer, null)
        9 -> thursday = decoder.decodeBooleanElement(__desc, 9)
        10 ->
          _thursday = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.mondaySer, null)
        11 -> friday = decoder.decodeBooleanElement(__desc, 11)
        12 ->
          _friday = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.mondaySer, null)
        13 -> saturday = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _saturday = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.mondaySer, null)
        15 -> sunday = decoder.decodeBooleanElement(__desc, 15)
        16 ->
          _sunday = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.mondaySer, null)
        17 -> weekInterval = decoder.decodeIntElement(__desc, 17)
        18 ->
          _weekInterval =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.mondaySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WeeklyTemplate: " + __i)
      }
    }
    return Appointment.RecurrenceTemplate.WeeklyTemplate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      monday = R5Boolean.of(monday, _monday),
      tuesday = R5Boolean.of(tuesday, _tuesday),
      wednesday = R5Boolean.of(wednesday, _wednesday),
      thursday = R5Boolean.of(thursday, _thursday),
      friday = R5Boolean.of(friday, _friday),
      saturday = R5Boolean.of(saturday, _saturday),
      sunday = R5Boolean.of(sunday, _sunday),
      weekInterval = PositiveInt.of(weekInterval, _weekInterval),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.WeeklyTemplate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.monday?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.monday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.mondaySer, it)
    }
    ((value.tuesday?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.tuesday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.mondaySer, it)
    }
    ((value.wednesday?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.wednesday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.mondaySer, it)
    }
    ((value.thursday?.value))?.let { encoder.encodeBooleanElement(__desc, 9, it) }
    (value.thursday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.mondaySer, it)
    }
    ((value.friday?.value))?.let { encoder.encodeBooleanElement(__desc, 11, it) }
    (value.friday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.mondaySer, it)
    }
    ((value.saturday?.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.saturday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.mondaySer, it)
    }
    ((value.sunday?.value))?.let { encoder.encodeBooleanElement(__desc, 15, it) }
    (value.sunday?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.mondaySer, it)
    }
    ((value.weekInterval?.value))?.let { encoder.encodeIntElement(__desc, 17, it) }
    (value.weekInterval?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.mondaySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val mondaySer: KSerializer<Element> = Element.serializer()
  }
}

internal object AppointmentRecurrenceTemplateMonthlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.MonthlyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonthlyTemplate") {
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
      element("dayOfMonth", Int.serializer().descriptor, isOptional = true)
      element("_dayOfMonth", Element.serializer().descriptor, isOptional = true)
      element("nthWeekOfMonth", Coding.serializer().descriptor, isOptional = true)
      element("dayOfWeek", Coding.serializer().descriptor, isOptional = true)
      element("monthInterval", Int.serializer().descriptor, isOptional = true)
      element("_monthInterval", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.MonthlyTemplate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.MonthlyTemplate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var dayOfMonth: Int? = null
    var _dayOfMonth: Element? = null
    var nthWeekOfMonth: Coding? = null
    var dayOfWeek: Coding? = null
    var monthInterval: Int? = null
    var _monthInterval: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> dayOfMonth = decoder.decodeIntElement(__desc, 3)
        4 ->
          _dayOfMonth =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.dayOfMonthSer, null)
        5 ->
          nthWeekOfMonth =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.nthWeekOfMonthSer, null)
        6 ->
          dayOfWeek =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nthWeekOfMonthSer, null)
        7 -> monthInterval = decoder.decodeIntElement(__desc, 7)
        8 ->
          _monthInterval =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.dayOfMonthSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonthlyTemplate: " + __i)
      }
    }
    return Appointment.RecurrenceTemplate.MonthlyTemplate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      dayOfMonth = PositiveInt.of(dayOfMonth, _dayOfMonth),
      nthWeekOfMonth = nthWeekOfMonth,
      dayOfWeek = dayOfWeek,
      monthInterval = PositiveInt.of(monthInterval, _monthInterval)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.dayOfMonth?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.dayOfMonth?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.dayOfMonthSer, it)
    }
    (value.nthWeekOfMonth)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.nthWeekOfMonthSer, it)
    }
    (value.dayOfWeek)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nthWeekOfMonthSer, it)
    }
    ((value.monthInterval.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
    (value.monthInterval.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.dayOfMonthSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val dayOfMonthSer: KSerializer<Element> = Element.serializer()

    public val nthWeekOfMonthSer: KSerializer<Coding> = Coding.serializer()
  }
}

internal object AppointmentRecurrenceTemplateYearlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.YearlyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("YearlyTemplate") {
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
      element("yearInterval", Int.serializer().descriptor, isOptional = true)
      element("_yearInterval", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.YearlyTemplate =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.YearlyTemplate) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.YearlyTemplate {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var yearInterval: Int? = null
    var _yearInterval: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> yearInterval = decoder.decodeIntElement(__desc, 3)
        4 ->
          _yearInterval =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.yearIntervalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding YearlyTemplate: " + __i)
      }
    }
    return Appointment.RecurrenceTemplate.YearlyTemplate(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      yearInterval = PositiveInt.of(yearInterval, _yearInterval)!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.YearlyTemplate,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.yearInterval.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.yearInterval.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.yearIntervalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val yearIntervalSer: KSerializer<Element> = Element.serializer()
  }
}

internal object AppointmentSerializer : KSerializer<Appointment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Appointment") {
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("cancellationReason", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "class",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceCategory",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "serviceType",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specialty",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("appointmentType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "replaces",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "virtualService",
      listSerialDescriptor(VirtualServiceDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "supportingInformation",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("previousAppointment", Reference.serializer().descriptor, isOptional = true)
    b.element("originatingAppointment", Reference.serializer().descriptor, isOptional = true)
    b.element("start", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_start", Element.serializer().descriptor, isOptional = true)
    b.element("end", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_end", Element.serializer().descriptor, isOptional = true)
    b.element("minutesDuration", Int.serializer().descriptor, isOptional = true)
    b.element("_minutesDuration", Element.serializer().descriptor, isOptional = true)
    b.element(
      "requestedPeriod",
      listSerialDescriptor(Period.serializer().descriptor),
      isOptional = true,
    )
    b.element("slot", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("account", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("cancellationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_cancellationDate", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "patientInstruction",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { Appointment.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element("recurrenceId", Int.serializer().descriptor, isOptional = true)
    b.element("_recurrenceId", Element.serializer().descriptor, isOptional = true)
    b.element("occurrenceChanged", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_occurrenceChanged", Element.serializer().descriptor, isOptional = true)
    b.element(
      "recurrenceTemplate",
      listSerialDescriptor(
        lazyDescriptor { Appointment.RecurrenceTemplate.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Appointment")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Appointment {
    val __desc = descriptor
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
    var identifier: List<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var cancellationReason: CodeableConcept? = null
    var `class`: List<CodeableConcept>? = null
    var serviceCategory: List<CodeableConcept>? = null
    var serviceType: List<CodeableReference>? = null
    var specialty: List<CodeableConcept>? = null
    var appointmentType: CodeableConcept? = null
    var reason: List<CodeableReference>? = null
    var priority: CodeableConcept? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var replaces: List<Reference>? = null
    var virtualService: List<VirtualServiceDetail>? = null
    var supportingInformation: List<Reference>? = null
    var previousAppointment: Reference? = null
    var originatingAppointment: Reference? = null
    var start: KotlinString? = null
    var _start: Element? = null
    var end: KotlinString? = null
    var _end: Element? = null
    var minutesDuration: Int? = null
    var _minutesDuration: Element? = null
    var requestedPeriod: List<Period>? = null
    var slot: List<Reference>? = null
    var account: List<Reference>? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var cancellationDate: KotlinString? = null
    var _cancellationDate: Element? = null
    var note: List<Annotation>? = null
    var patientInstruction: List<CodeableReference>? = null
    var basedOn: List<Reference>? = null
    var subject: Reference? = null
    var participant: List<Appointment.Participant>? = null
    var recurrenceId: Int? = null
    var _recurrenceId: Element? = null
    var occurrenceChanged: KotlinBoolean? = null
    var _occurrenceChanged: Element? = null
    var recurrenceTemplate: List<Appointment.RecurrenceTemplate>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          cancellationReason =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.cancellationReasonSer,
              null,
            )
        15 ->
          `class` = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.classSer, null)
        16 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.classSer, null)
        17 ->
          serviceType =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.serviceTypeSer, null)
        18 ->
          specialty = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.classSer, null)
        19 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(
              __desc,
              19,
              Hoisted.cancellationReasonSer,
              null,
            )
        20 ->
          reason =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.serviceTypeSer, null)
        21 ->
          priority =
            decoder.decodeNullableSerializableElement(
              __desc,
              21,
              Hoisted.cancellationReasonSer,
              null,
            )
        22 -> description = decoder.decodeStringElement(__desc, 22)
        23 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.replacesSer, null)
        25 ->
          virtualService =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.virtualServiceSer, null)
        26 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.replacesSer, null)
        27 ->
          previousAppointment =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.replacesSerInner, null)
        28 ->
          originatingAppointment =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.replacesSerInner, null)
        29 -> start = decoder.decodeStringElement(__desc, 29)
        30 ->
          _start =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> end = decoder.decodeStringElement(__desc, 31)
        32 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> minutesDuration = decoder.decodeIntElement(__desc, 33)
        34 ->
          _minutesDuration =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.requestedPeriodSer, null)
        36 ->
          slot = decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.replacesSer, null)
        37 ->
          account = decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.replacesSer, null)
        38 -> created = decoder.decodeStringElement(__desc, 38)
        39 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> cancellationDate = decoder.decodeStringElement(__desc, 40)
        41 ->
          _cancellationDate =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> note = decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.noteSer, null)
        43 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.serviceTypeSer, null)
        44 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.replacesSer, null)
        45 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.replacesSerInner, null)
        46 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.participantSer, null)
        47 -> recurrenceId = decoder.decodeIntElement(__desc, 47)
        48 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.implicitRulesSer, null)
        49 -> occurrenceChanged = decoder.decodeBooleanElement(__desc, 49)
        50 ->
          _occurrenceChanged =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.implicitRulesSer, null)
        51 ->
          recurrenceTemplate =
            decoder.decodeNullableSerializableElement(
              __desc,
              51,
              Hoisted.recurrenceTemplateSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Appointment: " + __i)
      }
    }
    return Appointment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Appointment.AppointmentStatus.fromCode(status!!), _status),
      cancellationReason = cancellationReason,
      `class` = `class` ?: listOf(),
      serviceCategory = serviceCategory ?: listOf(),
      serviceType = serviceType ?: listOf(),
      specialty = specialty ?: listOf(),
      appointmentType = appointmentType,
      reason = reason ?: listOf(),
      priority = priority,
      description = R5String.of(description, _description),
      replaces = replaces ?: listOf(),
      virtualService = virtualService ?: listOf(),
      supportingInformation = supportingInformation ?: listOf(),
      previousAppointment = previousAppointment,
      originatingAppointment = originatingAppointment,
      start = Instant.of(FhirDateTime.fromString(start), _start),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      requestedPeriod = requestedPeriod ?: listOf(),
      slot = slot ?: listOf(),
      account = account ?: listOf(),
      created = DateTime.of(FhirDateTime.fromString(created), _created),
      cancellationDate = DateTime.of(FhirDateTime.fromString(cancellationDate), _cancellationDate),
      note = note ?: listOf(),
      patientInstruction = patientInstruction ?: listOf(),
      basedOn = basedOn ?: listOf(),
      subject = subject,
      participant = participant ?: listOf(),
      recurrenceId = PositiveInt.of(recurrenceId, _recurrenceId),
      occurrenceChanged = R5Boolean.of(occurrenceChanged, _occurrenceChanged),
      recurrenceTemplate = recurrenceTemplate ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: Appointment) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.cancellationReason)?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.cancellationReasonSer, it)
    }
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.classSer, value.`class`)
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.classSer, value.serviceCategory)
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.serviceTypeSer, value.serviceType)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.classSer, value.specialty)
    (value.appointmentType)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.cancellationReasonSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.serviceTypeSer, value.reason)
    (value.priority)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.cancellationReasonSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.replacesSer, value.replaces)
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.virtualServiceSer, value.virtualService)
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26,
        Hoisted.replacesSer,
        value.supportingInformation,
      )
    (value.previousAppointment)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.replacesSerInner, it)
    }
    (value.originatingAppointment)?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.replacesSerInner, it)
    }
    ((value.start?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 31, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    ((value.minutesDuration?.value))?.let { encoder.encodeIntElement(__desc, 33, it) }
    (value.minutesDuration?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.requestedPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        35,
        Hoisted.requestedPeriodSer,
        value.requestedPeriod,
      )
    if (value.slot.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.replacesSer, value.slot)
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 37, Hoisted.replacesSer, value.account)
    ((value.created?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.cancellationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 40, it)
    }
    (value.cancellationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 42, Hoisted.noteSer, value.note)
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        43,
        Hoisted.serviceTypeSer,
        value.patientInstruction,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 44, Hoisted.replacesSer, value.basedOn)
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.replacesSerInner, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.participantSer, value.participant)
    ((value.recurrenceId?.value))?.let { encoder.encodeIntElement(__desc, 47, it) }
    (value.recurrenceId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 48, Hoisted.implicitRulesSer, it)
    }
    ((value.occurrenceChanged?.value))?.let { encoder.encodeBooleanElement(__desc, 49, it) }
    (value.occurrenceChanged?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 50, Hoisted.implicitRulesSer, it)
    }
    if (value.recurrenceTemplate.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        51,
        Hoisted.recurrenceTemplateSer,
        value.recurrenceTemplate,
      )
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val cancellationReasonSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val classSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.cancellationReasonSer)

    public val serviceTypeSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val serviceTypeSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.serviceTypeSerInner)

    public val replacesSerInner: KSerializer<Reference> = Reference.serializer()

    public val replacesSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.replacesSerInner)

    public val virtualServiceSerInner: KSerializer<VirtualServiceDetail> =
      VirtualServiceDetail.serializer()

    public val virtualServiceSer: KSerializer<List<VirtualServiceDetail>> =
      ListSerializer(Hoisted.virtualServiceSerInner)

    public val requestedPeriodSerInner: KSerializer<Period> = Period.serializer()

    public val requestedPeriodSer: KSerializer<List<Period>> =
      ListSerializer(Hoisted.requestedPeriodSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val participantSerInner: KSerializer<Appointment.Participant> =
      Appointment.Participant.serializer()

    public val participantSer: KSerializer<List<Appointment.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val recurrenceTemplateSerInner: KSerializer<Appointment.RecurrenceTemplate> =
      Appointment.RecurrenceTemplate.serializer()

    public val recurrenceTemplateSer: KSerializer<List<Appointment.RecurrenceTemplate>> =
      ListSerializer(Hoisted.recurrenceTemplateSerInner)
  }
}

internal object AppointmentPolymorphicSerializer : KSerializer<Appointment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Appointment") { AppointmentSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) { AppointmentSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) { AppointmentSerializer.deserializeJson(this) }
}
