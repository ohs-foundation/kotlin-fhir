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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VirtualServiceDetail
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
      optionalElement("required", KotlinBoolean.serializer().descriptor)
      optionalElement("_required", ElementSerializer.descriptor)
      optionalElement("status", KotlinString.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Appointment.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.Participant =
    decoder.decodeStructure(descriptor) {
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          5 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> required = decodeBooleanElement(descriptor, i)
          7 -> _required = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> status = decodeStringElement(descriptor, i)
          9 -> _status = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      Appointment.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type ?: listOf(),
        period = period,
        actor = actor,
        required = R5Boolean.of(required, _required),
        status =
          Enumeration.of(
            if (status != null) Appointment.ParticipationStatus.fromCode(status) else null,
            _status,
          )
            ?: throw SerializationException(
              "Missing required property 'status' on Appointment.Participant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.actor)
      encodeBooleanIfNotNull(descriptor, 6, value.required?.value)
      encodeElementIfNotNull(descriptor, 7, value.required)
      encodeStringIfNotNull(descriptor, 8, value.status.value?.code)
      encodeElementIfNotNull(descriptor, 9, value.status)
    }
  }
}

internal object AppointmentRecurrenceTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RecurrenceTemplate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("timezone", CodeableConceptSerializer.descriptor)
      optionalElement("recurrenceType", CodeableConceptSerializer.descriptor)
      optionalElement("lastOccurrenceDate", KotlinString.serializer().descriptor)
      optionalElement("_lastOccurrenceDate", ElementSerializer.descriptor)
      optionalElement("occurrenceCount", Int.serializer().descriptor)
      optionalElement("_occurrenceCount", ElementSerializer.descriptor)
      optionalElement("occurrenceDate", stringNullableListSerializer.descriptor)
      optionalElement("_occurrenceDate", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "weeklyTemplate",
        AppointmentRecurrenceTemplateWeeklyTemplateSerializer.descriptor,
      )
      optionalElement(
        "monthlyTemplate",
        AppointmentRecurrenceTemplateMonthlyTemplateSerializer.descriptor,
      )
      optionalElement(
        "yearlyTemplate",
        AppointmentRecurrenceTemplateYearlyTemplateSerializer.descriptor,
      )
      optionalElement("excludingDate", stringNullableListSerializer.descriptor)
      optionalElement("_excludingDate", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("excludingRecurrenceId", intNullableListSerializer.descriptor)
      optionalElement("_excludingRecurrenceId", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate =
    decoder.decodeStructure(descriptor) {
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            timezone =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            recurrenceType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> lastOccurrenceDate = decodeStringElement(descriptor, i)
          6 ->
            _lastOccurrenceDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> occurrenceCount = decodeIntElement(descriptor, i)
          8 ->
            _occurrenceCount =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            occurrenceDate =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _occurrenceDate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          11 ->
            weeklyTemplate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
                null,
              )
          12 ->
            monthlyTemplate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
                null,
              )
          13 ->
            yearlyTemplate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AppointmentRecurrenceTemplateYearlyTemplateSerializer,
                null,
              )
          14 ->
            excludingDate =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          15 ->
            _excludingDate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          16 ->
            excludingRecurrenceId =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          17 ->
            _excludingRecurrenceId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RecurrenceTemplate: " + i)
        }
      }
      Appointment.RecurrenceTemplate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        timezone = timezone,
        recurrenceType =
          recurrenceType
            ?: throw SerializationException(
              "Missing required property 'recurrenceType' on Appointment.RecurrenceTemplate"
            ),
        lastOccurrenceDate =
          Date.of(
            if (lastOccurrenceDate != null) FhirDate.fromString(lastOccurrenceDate) else null,
            _lastOccurrenceDate,
          ),
        occurrenceCount = PositiveInt.of(occurrenceCount, _occurrenceCount),
        occurrenceDate =
          (kotlin.collections.List(maxOf(occurrenceDate?.size ?: 0, _occurrenceDate?.size ?: 0)) {
            index ->
            Date.of(
              occurrenceDate?.getOrNull(index)?.let { FhirDate.fromString(it) },
              _occurrenceDate?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'occurrenceDate' on Appointment.RecurrenceTemplate has neither a value nor an id/extension"
              )
          }),
        weeklyTemplate = weeklyTemplate,
        monthlyTemplate = monthlyTemplate,
        yearlyTemplate = yearlyTemplate,
        excludingDate =
          (kotlin.collections.List(maxOf(excludingDate?.size ?: 0, _excludingDate?.size ?: 0)) {
            index ->
            Date.of(
              excludingDate?.getOrNull(index)?.let { FhirDate.fromString(it) },
              _excludingDate?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'excludingDate' on Appointment.RecurrenceTemplate has neither a value nor an id/extension"
              )
          }),
        excludingRecurrenceId =
          (kotlin.collections.List(
            maxOf(excludingRecurrenceId?.size ?: 0, _excludingRecurrenceId?.size ?: 0)
          ) { index ->
            PositiveInt.of(
              excludingRecurrenceId?.getOrNull(index),
              _excludingRecurrenceId?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'excludingRecurrenceId' on Appointment.RecurrenceTemplate has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.timezone)
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.recurrenceType)
      encodeStringIfNotNull(descriptor, 5, value.lastOccurrenceDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.lastOccurrenceDate)
      encodeIntIfNotNull(descriptor, 7, value.occurrenceCount?.value)
      encodeElementIfNotNull(descriptor, 8, value.occurrenceCount)
      if (value.occurrenceDate.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.occurrenceDate.map { it.value?.toString() },
        )
        encodePrimitiveElementList(descriptor, 10, value.occurrenceDate)
      }
      encodeSerializableIfNotNull(
        descriptor,
        11,
        AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
        value.weeklyTemplate,
      )
      encodeSerializableIfNotNull(
        descriptor,
        12,
        AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
        value.monthlyTemplate,
      )
      encodeSerializableIfNotNull(
        descriptor,
        13,
        AppointmentRecurrenceTemplateYearlyTemplateSerializer,
        value.yearlyTemplate,
      )
      if (value.excludingDate.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          14,
          stringNullableListSerializer,
          value.excludingDate.map { it.value?.toString() },
        )
        encodePrimitiveElementList(descriptor, 15, value.excludingDate)
      }
      if (value.excludingRecurrenceId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          16,
          intNullableListSerializer,
          value.excludingRecurrenceId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 17, value.excludingRecurrenceId)
      }
    }
  }
}

internal object AppointmentRecurrenceTemplateWeeklyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.WeeklyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WeeklyTemplate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("monday", KotlinBoolean.serializer().descriptor)
      optionalElement("_monday", ElementSerializer.descriptor)
      optionalElement("tuesday", KotlinBoolean.serializer().descriptor)
      optionalElement("_tuesday", ElementSerializer.descriptor)
      optionalElement("wednesday", KotlinBoolean.serializer().descriptor)
      optionalElement("_wednesday", ElementSerializer.descriptor)
      optionalElement("thursday", KotlinBoolean.serializer().descriptor)
      optionalElement("_thursday", ElementSerializer.descriptor)
      optionalElement("friday", KotlinBoolean.serializer().descriptor)
      optionalElement("_friday", ElementSerializer.descriptor)
      optionalElement("saturday", KotlinBoolean.serializer().descriptor)
      optionalElement("_saturday", ElementSerializer.descriptor)
      optionalElement("sunday", KotlinBoolean.serializer().descriptor)
      optionalElement("_sunday", ElementSerializer.descriptor)
      optionalElement("weekInterval", Int.serializer().descriptor)
      optionalElement("_weekInterval", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.WeeklyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.WeeklyTemplate =
    decoder.decodeStructure(descriptor) {
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> monday = decodeBooleanElement(descriptor, i)
          4 -> _monday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> tuesday = decodeBooleanElement(descriptor, i)
          6 -> _tuesday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> wednesday = decodeBooleanElement(descriptor, i)
          8 ->
            _wednesday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> thursday = decodeBooleanElement(descriptor, i)
          10 ->
            _thursday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> friday = decodeBooleanElement(descriptor, i)
          12 -> _friday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> saturday = decodeBooleanElement(descriptor, i)
          14 ->
            _saturday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> sunday = decodeBooleanElement(descriptor, i)
          16 -> _sunday = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> weekInterval = decodeIntElement(descriptor, i)
          18 ->
            _weekInterval =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding WeeklyTemplate: " + i)
        }
      }
      Appointment.RecurrenceTemplate.WeeklyTemplate(
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

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.WeeklyTemplate) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeBooleanIfNotNull(descriptor, 3, value.monday?.value)
      encodeElementIfNotNull(descriptor, 4, value.monday)
      encodeBooleanIfNotNull(descriptor, 5, value.tuesday?.value)
      encodeElementIfNotNull(descriptor, 6, value.tuesday)
      encodeBooleanIfNotNull(descriptor, 7, value.wednesday?.value)
      encodeElementIfNotNull(descriptor, 8, value.wednesday)
      encodeBooleanIfNotNull(descriptor, 9, value.thursday?.value)
      encodeElementIfNotNull(descriptor, 10, value.thursday)
      encodeBooleanIfNotNull(descriptor, 11, value.friday?.value)
      encodeElementIfNotNull(descriptor, 12, value.friday)
      encodeBooleanIfNotNull(descriptor, 13, value.saturday?.value)
      encodeElementIfNotNull(descriptor, 14, value.saturday)
      encodeBooleanIfNotNull(descriptor, 15, value.sunday?.value)
      encodeElementIfNotNull(descriptor, 16, value.sunday)
      encodeIntIfNotNull(descriptor, 17, value.weekInterval?.value)
      encodeElementIfNotNull(descriptor, 18, value.weekInterval)
    }
  }
}

internal object AppointmentRecurrenceTemplateMonthlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.MonthlyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MonthlyTemplate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("dayOfMonth", Int.serializer().descriptor)
      optionalElement("_dayOfMonth", ElementSerializer.descriptor)
      optionalElement("nthWeekOfMonth", CodingSerializer.descriptor)
      optionalElement("dayOfWeek", CodingSerializer.descriptor)
      optionalElement("monthInterval", Int.serializer().descriptor)
      optionalElement("_monthInterval", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.MonthlyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.MonthlyTemplate =
    decoder.decodeStructure(descriptor) {
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> dayOfMonth = decodeIntElement(descriptor, i)
          4 ->
            _dayOfMonth = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            nthWeekOfMonth =
              decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 -> dayOfWeek = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          7 -> monthInterval = decodeIntElement(descriptor, i)
          8 ->
            _monthInterval =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding MonthlyTemplate: " + i)
        }
      }
      Appointment.RecurrenceTemplate.MonthlyTemplate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        dayOfMonth = PositiveInt.of(dayOfMonth, _dayOfMonth),
        nthWeekOfMonth = nthWeekOfMonth,
        dayOfWeek = dayOfWeek,
        monthInterval =
          PositiveInt.of(monthInterval, _monthInterval)
            ?: throw SerializationException(
              "Missing required property 'monthInterval' on Appointment.RecurrenceTemplate.MonthlyTemplate"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeIntIfNotNull(descriptor, 3, value.dayOfMonth?.value)
      encodeElementIfNotNull(descriptor, 4, value.dayOfMonth)
      encodeSerializableIfNotNull(descriptor, 5, CodingSerializer, value.nthWeekOfMonth)
      encodeSerializableIfNotNull(descriptor, 6, CodingSerializer, value.dayOfWeek)
      encodeIntIfNotNull(descriptor, 7, value.monthInterval.value)
      encodeElementIfNotNull(descriptor, 8, value.monthInterval)
    }
  }
}

internal object AppointmentRecurrenceTemplateYearlyTemplateSerializer :
  KSerializer<Appointment.RecurrenceTemplate.YearlyTemplate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("YearlyTemplate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("yearInterval", Int.serializer().descriptor)
      optionalElement("_yearInterval", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.YearlyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.YearlyTemplate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var yearInterval: Int? = null
      var _yearInterval: Element? = null
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
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> yearInterval = decodeIntElement(descriptor, i)
          4 ->
            _yearInterval =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding YearlyTemplate: " + i)
        }
      }
      Appointment.RecurrenceTemplate.YearlyTemplate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        yearInterval =
          PositiveInt.of(yearInterval, _yearInterval)
            ?: throw SerializationException(
              "Missing required property 'yearInterval' on Appointment.RecurrenceTemplate.YearlyTemplate"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.YearlyTemplate) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeIntIfNotNull(descriptor, 3, value.yearInterval.value)
      encodeElementIfNotNull(descriptor, 4, value.yearInterval)
    }
  }
}

internal object AppointmentSerializer : FhirResourceSerializer<Appointment> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Appointment")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("cancellationReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("class", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceCategory", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceType", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("specialty", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("appointmentType", CodeableConceptSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("virtualService", VirtualServiceDetailSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("previousAppointment", ReferenceSerializer.descriptor)
    b.optionalElement("originatingAppointment", ReferenceSerializer.descriptor)
    b.optionalElement("start", KotlinString.serializer().descriptor)
    b.optionalElement("_start", ElementSerializer.descriptor)
    b.optionalElement("end", KotlinString.serializer().descriptor)
    b.optionalElement("_end", ElementSerializer.descriptor)
    b.optionalElement("minutesDuration", Int.serializer().descriptor)
    b.optionalElement("_minutesDuration", ElementSerializer.descriptor)
    b.optionalElement("requestedPeriod", PeriodSerializer.listSerializer.descriptor)
    b.optionalElement("slot", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("cancellationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_cancellationDate", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("patientInstruction", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("participant", AppointmentParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("recurrenceId", Int.serializer().descriptor)
    b.optionalElement("_recurrenceId", ElementSerializer.descriptor)
    b.optionalElement("occurrenceChanged", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_occurrenceChanged", ElementSerializer.descriptor)
    b.optionalElement(
      "recurrenceTemplate",
      AppointmentRecurrenceTemplateSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Appointment {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          cancellationReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          `class` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          serviceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          specialty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          virtualService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VirtualServiceDetailSerializer.listSerializer,
              null,
            )
        25 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          previousAppointment =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          originatingAppointment =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 -> start = decoder.decodeStringElement(descriptor, i)
        29 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> end = decoder.decodeStringElement(descriptor, i)
        31 ->
          _end = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> minutesDuration = decoder.decodeIntElement(descriptor, i)
        33 ->
          _minutesDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        35 ->
          slot =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          account =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 -> created = decoder.decodeStringElement(descriptor, i)
        38 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> cancellationDate = decoder.decodeStringElement(descriptor, i)
        40 ->
          _cancellationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        42 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        43 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        44 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        45 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentParticipantSerializer.listSerializer,
              null,
            )
        46 -> recurrenceId = decoder.decodeIntElement(descriptor, i)
        47 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        48 -> occurrenceChanged = decoder.decodeBooleanElement(descriptor, i)
        49 ->
          _occurrenceChanged =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        50 ->
          recurrenceTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Appointment: " + i)
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
      status =
        Enumeration.of(
          if (status != null) Appointment.AppointmentStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Appointment"),
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
      start = Instant.of(if (start != null) FhirDateTime.fromString(start) else null, _start),
      end = Instant.of(if (end != null) FhirDateTime.fromString(end) else null, _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      requestedPeriod = requestedPeriod ?: listOf(),
      slot = slot ?: listOf(),
      account = account ?: listOf(),
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created),
      cancellationDate =
        DateTime.of(
          if (cancellationDate != null) FhirDateTime.fromString(cancellationDate) else null,
          _cancellationDate,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Appointment,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.cancellationReason,
    )
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.`class`,
      )
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.serviceType,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialty,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.appointmentType,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.description)
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.replaces,
      )
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        VirtualServiceDetailSerializer.listSerializer,
        value.virtualService,
      )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInformation,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.previousAppointment,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.originatingAppointment,
    )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.start?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.start)
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.end?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.end)
    encoder.encodeIntIfNotNull(descriptor, 32 + descriptorOffset, value.minutesDuration?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.minutesDuration)
    if (value.requestedPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        PeriodSerializer.listSerializer,
        value.requestedPeriod,
      )
    if (value.slot.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.slot,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.account,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.created?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.created)
    encoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.cancellationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.cancellationDate)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.patientInstruction,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        AppointmentParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeIntIfNotNull(descriptor, 46 + descriptorOffset, value.recurrenceId?.value)
    encoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.recurrenceId)
    encoder.encodeBooleanIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.occurrenceChanged?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.occurrenceChanged)
    if (value.recurrenceTemplate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        AppointmentRecurrenceTemplateSerializer.listSerializer,
        value.recurrenceTemplate,
      )
  }
}
