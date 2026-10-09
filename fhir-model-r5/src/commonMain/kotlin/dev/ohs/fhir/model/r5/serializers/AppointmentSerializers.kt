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
import dev.ohs.fhir.model.r5.terminologies.AppointmentStatus
import dev.ohs.fhir.model.r5.terminologies.ParticipationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object AppointmentParticipantSerializer : FhirSerializer<Appointment.Participant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Participant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Appointment.Participant>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("actor", ReferenceSerializer.descriptor)
    b.boolPrim("required")
    b.strPrim("status")
  }

  override fun deserialize(decoder: Decoder): Appointment.Participant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var period: Period? = null
    var actor: Reference? = null
    var required: KotlinBoolean? = null
    var _required: Element? = null
    var status: ParticipationStatus? = null
    var _status: Element? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        5 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> required = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _required =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          status = ParticipationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        9 ->
          _status =
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
    return Appointment.Participant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = listOrEmpty(type),
      period = period,
      actor = actor,
      required = R5Boolean.of(required, _required),
      status = required(Enumeration.of(status, _status), "Appointment.Participant", "status"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableConceptSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.actor)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, value.required?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.required)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.status.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.status)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AppointmentRecurrenceTemplateSerializer :
  FhirSerializer<Appointment.RecurrenceTemplate> {
  override val descriptor: SerialDescriptor = buildDescriptor("RecurrenceTemplate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("timezone", CodeableConceptSerializer.descriptor)
    b.optionalElement("recurrenceType", CodeableConceptSerializer.descriptor)
    b.strPrim("lastOccurrenceDate")
    b.intPrim("occurrenceCount")
    b.strPrimList("occurrenceDate")
    b.optionalElement(
      "weeklyTemplate",
      AppointmentRecurrenceTemplateWeeklyTemplateSerializer.descriptor,
    )
    b.optionalElement(
      "monthlyTemplate",
      AppointmentRecurrenceTemplateMonthlyTemplateSerializer.descriptor,
    )
    b.optionalElement(
      "yearlyTemplate",
      AppointmentRecurrenceTemplateYearlyTemplateSerializer.descriptor,
    )
    b.strPrimList("excludingDate")
    b.intPrimList("excludingRecurrenceId")
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var timezone: CodeableConcept? = null
    var recurrenceType: CodeableConcept? = null
    var lastOccurrenceDate: FhirDate? = null
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
          timezone =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          recurrenceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          lastOccurrenceDate =
            FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _lastOccurrenceDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> occurrenceCount = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _occurrenceCount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          occurrenceDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _occurrenceDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          weeklyTemplate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
              null,
            )
        12 ->
          monthlyTemplate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
              null,
            )
        13 ->
          yearlyTemplate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateYearlyTemplateSerializer,
              null,
            )
        14 ->
          excludingDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        15 ->
          _excludingDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        16 ->
          excludingRecurrenceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        17 ->
          _excludingRecurrenceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val occurrenceDate_ =
      List(maxSize(occurrenceDate, _occurrenceDate)) { index ->
        entryRequired(
          Date.of(
            at(occurrenceDate, index)?.let { FhirDate.fromString(it) },
            at(_occurrenceDate, index),
          ),
          "Appointment.RecurrenceTemplate",
          "occurrenceDate",
        )
      }
    val excludingDate_ =
      List(maxSize(excludingDate, _excludingDate)) { index ->
        entryRequired(
          Date.of(
            at(excludingDate, index)?.let { FhirDate.fromString(it) },
            at(_excludingDate, index),
          ),
          "Appointment.RecurrenceTemplate",
          "excludingDate",
        )
      }
    val excludingRecurrenceId_ =
      List(maxSize(excludingRecurrenceId, _excludingRecurrenceId)) { index ->
        entryRequired(
          PositiveInt.of(at(excludingRecurrenceId, index), at(_excludingRecurrenceId, index)),
          "Appointment.RecurrenceTemplate",
          "excludingRecurrenceId",
        )
      }
    return Appointment.RecurrenceTemplate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      timezone = timezone,
      recurrenceType = required(recurrenceType, "Appointment.RecurrenceTemplate", "recurrenceType"),
      lastOccurrenceDate = Date.of(lastOccurrenceDate, _lastOccurrenceDate),
      occurrenceCount = PositiveInt.of(occurrenceCount, _occurrenceCount),
      occurrenceDate = occurrenceDate_,
      weeklyTemplate = weeklyTemplate,
      monthlyTemplate = monthlyTemplate,
      yearlyTemplate = yearlyTemplate,
      excludingDate = excludingDate_,
      excludingRecurrenceId = excludingRecurrenceId_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.timezone,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.recurrenceType,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      5,
      value.lastOccurrenceDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.lastOccurrenceDate)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.occurrenceCount?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.occurrenceCount)
    if (!value.occurrenceDate.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.occurrenceDate.map { it.value?.toString() },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.occurrenceDate)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
      value.weeklyTemplate,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
      value.monthlyTemplate,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      AppointmentRecurrenceTemplateYearlyTemplateSerializer,
      value.yearlyTemplate,
    )
    if (!value.excludingDate.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        14,
        stringNullableListSerializer,
        value.excludingDate.map { it.value?.toString() },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 15, value.excludingDate)
    }
    if (!value.excludingRecurrenceId.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16,
        intNullableListSerializer,
        value.excludingRecurrenceId.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17, value.excludingRecurrenceId)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AppointmentRecurrenceTemplateWeeklyTemplateSerializer :
  FhirSerializer<Appointment.RecurrenceTemplate.WeeklyTemplate> {
  override val descriptor: SerialDescriptor = buildDescriptor("WeeklyTemplate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.WeeklyTemplate>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("monday")
    b.boolPrim("tuesday")
    b.boolPrim("wednesday")
    b.boolPrim("thursday")
    b.boolPrim("friday")
    b.boolPrim("saturday")
    b.boolPrim("sunday")
    b.intPrim("weekInterval")
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.WeeklyTemplate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> monday = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _monday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> tuesday = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _tuesday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> wednesday = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _wednesday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> thursday = compositeDecoder.decodeBooleanElement(descriptor, i)
        10 ->
          _thursday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> friday = compositeDecoder.decodeBooleanElement(descriptor, i)
        12 ->
          _friday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> saturday = compositeDecoder.decodeBooleanElement(descriptor, i)
        14 ->
          _saturday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> sunday = compositeDecoder.decodeBooleanElement(descriptor, i)
        16 ->
          _sunday =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> weekInterval = compositeDecoder.decodeIntElement(descriptor, i)
        18 ->
          _weekInterval =
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
    return Appointment.RecurrenceTemplate.WeeklyTemplate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.monday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.monday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.tuesday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.tuesday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.wednesday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.wednesday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 9, value.thursday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.thursday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 11, value.friday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.friday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 13, value.saturday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.saturday)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 15, value.sunday?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.sunday)
    compositeEncoder.encodeIntIfNotNull(descriptor, 17, value.weekInterval?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.weekInterval)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AppointmentRecurrenceTemplateMonthlyTemplateSerializer :
  FhirSerializer<Appointment.RecurrenceTemplate.MonthlyTemplate> {
  override val descriptor: SerialDescriptor = buildDescriptor("MonthlyTemplate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.MonthlyTemplate>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("dayOfMonth")
    b.optionalElement("nthWeekOfMonth", CodingSerializer.descriptor)
    b.optionalElement("dayOfWeek", CodingSerializer.descriptor)
    b.intPrim("monthInterval")
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.MonthlyTemplate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> dayOfMonth = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _dayOfMonth =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          nthWeekOfMonth =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        6 ->
          dayOfWeek =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        7 -> monthInterval = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _monthInterval =
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
    return Appointment.RecurrenceTemplate.MonthlyTemplate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      dayOfMonth = PositiveInt.of(dayOfMonth, _dayOfMonth),
      nthWeekOfMonth = nthWeekOfMonth,
      dayOfWeek = dayOfWeek,
      monthInterval =
        required(
          PositiveInt.of(monthInterval, _monthInterval),
          "Appointment.RecurrenceTemplate.MonthlyTemplate",
          "monthInterval",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.dayOfMonth?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.dayOfMonth)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodingSerializer,
      value.nthWeekOfMonth,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, CodingSerializer, value.dayOfWeek)
    compositeEncoder.encodeIntIfNotNull(descriptor, 7, value.monthInterval.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.monthInterval)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AppointmentRecurrenceTemplateYearlyTemplateSerializer :
  FhirSerializer<Appointment.RecurrenceTemplate.YearlyTemplate> {
  override val descriptor: SerialDescriptor = buildDescriptor("YearlyTemplate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.YearlyTemplate>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("yearInterval")
  }

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.YearlyTemplate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var yearInterval: Int? = null
    var _yearInterval: Element? = null
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
        3 -> yearInterval = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _yearInterval =
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
    return Appointment.RecurrenceTemplate.YearlyTemplate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      yearInterval =
        required(
          PositiveInt.of(yearInterval, _yearInterval),
          "Appointment.RecurrenceTemplate.YearlyTemplate",
          "yearInterval",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.YearlyTemplate) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.yearInterval.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.yearInterval)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AppointmentSerializer : FhirResourceSerializer<Appointment> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Appointment")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("cancellationReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("class", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceCategory", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceType", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("specialty", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("appointmentType", CodeableConceptSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("replaces", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("virtualService", VirtualServiceDetailSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInformation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("previousAppointment", ReferenceSerializer.descriptor)
    b.optionalElement("originatingAppointment", ReferenceSerializer.descriptor)
    b.strPrim("start")
    b.strPrim("end")
    b.intPrim("minutesDuration")
    b.optionalElement("requestedPeriod", PeriodSerializer.listSerializer.descriptor)
    b.optionalElement("slot", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.listSerializer.descriptor)
    b.strPrim("created")
    b.strPrim("cancellationDate")
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("patientInstruction", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("participant", AppointmentParticipantSerializer.listSerializer.descriptor)
    b.intPrim("recurrenceId")
    b.boolPrim("occurrenceChanged")
    b.optionalElement(
      "recurrenceTemplate",
      AppointmentRecurrenceTemplateSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: AppointmentStatus? = null
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
    var start: FhirDateTime? = null
    var _start: Element? = null
    var end: FhirDateTime? = null
    var _end: Element? = null
    var minutesDuration: Int? = null
    var _minutesDuration: Element? = null
    var requestedPeriod: List<Period>? = null
    var slot: List<Reference>? = null
    var account: List<Reference>? = null
    var created: FhirDateTime? = null
    var _created: Element? = null
    var cancellationDate: FhirDateTime? = null
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          status = AppointmentStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          cancellationReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          `class` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          serviceCategory =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          serviceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          specialty =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 ->
          appointmentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          replaces =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          virtualService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VirtualServiceDetailSerializer.listSerializer,
              null,
            )
        25 ->
          supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          previousAppointment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 ->
          originatingAppointment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        28 -> start = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        29 ->
          _start =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> end = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        31 ->
          _end =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> minutesDuration = compositeDecoder.decodeIntElement(descriptor, i)
        33 ->
          _minutesDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          requestedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        35 ->
          slot =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          account =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 -> created = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        38 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 ->
          cancellationDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        40 ->
          _cancellationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        42 ->
          patientInstruction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        43 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        44 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        45 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentParticipantSerializer.listSerializer,
              null,
            )
        46 -> recurrenceId = compositeDecoder.decodeIntElement(descriptor, i)
        47 ->
          _recurrenceId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 -> occurrenceChanged = compositeDecoder.decodeBooleanElement(descriptor, i)
        49 ->
          _occurrenceChanged =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        50 ->
          recurrenceTemplate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Appointment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "Appointment", "status"),
      cancellationReason = cancellationReason,
      `class` = listOrEmpty(`class`),
      serviceCategory = listOrEmpty(serviceCategory),
      serviceType = listOrEmpty(serviceType),
      specialty = listOrEmpty(specialty),
      appointmentType = appointmentType,
      reason = listOrEmpty(reason),
      priority = priority,
      description = R5String.of(description, _description),
      replaces = listOrEmpty(replaces),
      virtualService = listOrEmpty(virtualService),
      supportingInformation = listOrEmpty(supportingInformation),
      previousAppointment = previousAppointment,
      originatingAppointment = originatingAppointment,
      start = Instant.of(start, _start),
      end = Instant.of(end, _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      requestedPeriod = listOrEmpty(requestedPeriod),
      slot = listOrEmpty(slot),
      account = listOrEmpty(account),
      created = DateTime.of(created, _created),
      cancellationDate = DateTime.of(cancellationDate, _cancellationDate),
      note = listOrEmpty(note),
      patientInstruction = listOrEmpty(patientInstruction),
      basedOn = listOrEmpty(basedOn),
      subject = subject,
      participant = listOrEmpty(participant),
      recurrenceId = PositiveInt.of(recurrenceId, _recurrenceId),
      occurrenceChanged = R5Boolean.of(occurrenceChanged, _occurrenceChanged),
      recurrenceTemplate = listOrEmpty(recurrenceTemplate),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Appointment,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.cancellationReason,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.`class`,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.serviceCategory,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.serviceType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.specialty,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.appointmentType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.reason,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.replaces,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      24 + descriptorOffset,
      VirtualServiceDetailSerializer.listSerializer,
      value.virtualService,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.supportingInformation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.previousAppointment,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.originatingAppointment,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.start?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.start)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.end?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.end)
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.minutesDuration?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.minutesDuration,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      PeriodSerializer.listSerializer,
      value.requestedPeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.slot,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.account,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.created?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.created)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.cancellationDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      40 + descriptorOffset,
      value.cancellationDate,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      CodeableReferenceSerializer.listSerializer,
      value.patientInstruction,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      43 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.basedOn,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      AppointmentParticipantSerializer.listSerializer,
      value.participant,
    )
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      46 + descriptorOffset,
      value.recurrenceId?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.recurrenceId)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.occurrenceChanged?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      49 + descriptorOffset,
      value.occurrenceChanged,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      AppointmentRecurrenceTemplateSerializer.listSerializer,
      value.recurrenceTemplate,
    )
  }
}
