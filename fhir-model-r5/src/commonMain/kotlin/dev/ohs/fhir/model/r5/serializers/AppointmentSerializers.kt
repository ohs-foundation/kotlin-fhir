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

  internal val listSerializer: KSerializer<List<Appointment.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Appointment.Participant {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        5 ->
          actor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 -> required = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _required =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 -> status = decoder.decodeStringElement(descriptor, i)
        9 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
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
      status =
        Enumeration.of(status?.let { Appointment.ParticipationStatus.fromCode(it) }, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on Appointment.Participant"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Appointment.Participant) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, PeriodSerializer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, it) }
    ((value.required?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    ((value.status.value?.code))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Appointment.RecurrenceTemplate {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          timezone =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          recurrenceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> lastOccurrenceDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _lastOccurrenceDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> occurrenceCount = decoder.decodeIntElement(descriptor, i)
        8 ->
          _occurrenceCount =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          occurrenceDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          weeklyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
              null,
            )
        12 ->
          monthlyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
              null,
            )
        13 ->
          yearlyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AppointmentRecurrenceTemplateYearlyTemplateSerializer,
              null,
            )
        14 ->
          excludingDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        15 ->
          _excludingDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        16 ->
          excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        17 ->
          _excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RecurrenceTemplate: " + i)
      }
    }
    return Appointment.RecurrenceTemplate(
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
        Date.of(lastOccurrenceDate?.let { FhirDate.fromString(it) }, _lastOccurrenceDate),
      occurrenceCount = PositiveInt.of(occurrenceCount, _occurrenceCount),
      occurrenceDate =
        (kotlin.collections.List(maxOf(occurrenceDate?.size ?: 0, _occurrenceDate?.size ?: 0)) {
          index ->
          Date.of(
            occurrenceDate?.getOrNull(index)?.let { it?.let { FhirDate.fromString(it) } },
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
        (kotlin.collections.List(maxOf(excludingDate?.size ?: 0, _excludingDate?.size ?: 0)) { index
          ->
          Date.of(
            excludingDate?.getOrNull(index)?.let { it?.let { FhirDate.fromString(it) } },
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
            excludingRecurrenceId?.getOrNull(index)?.let { it },
            _excludingRecurrenceId?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'excludingRecurrenceId' on Appointment.RecurrenceTemplate has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.timezone)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.recurrenceType,
    )
    ((value.lastOccurrenceDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 5, it)
    }
    (value.lastOccurrenceDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.occurrenceCount?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.occurrenceCount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    (value.occurrenceDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, stringNullableListSerializer, it)
    }
    (value.occurrenceDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.weeklyTemplate)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11,
        AppointmentRecurrenceTemplateWeeklyTemplateSerializer,
        it,
      )
    }
    (value.monthlyTemplate)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12,
        AppointmentRecurrenceTemplateMonthlyTemplateSerializer,
        it,
      )
    }
    (value.yearlyTemplate)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13,
        AppointmentRecurrenceTemplateYearlyTemplateSerializer,
        it,
      )
    }
    (value.excludingDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, stringNullableListSerializer, it)
    }
    (value.excludingDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.excludingRecurrenceId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, intNullableListSerializer, it)
    }
    (value.excludingRecurrenceId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
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

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.WeeklyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.WeeklyTemplate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.WeeklyTemplate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.WeeklyTemplate {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> monday = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _monday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> tuesday = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _tuesday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> wednesday = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _wednesday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 -> thursday = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _thursday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 -> friday = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _friday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> saturday = decoder.decodeBooleanElement(descriptor, i)
        14 ->
          _saturday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> sunday = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _sunday =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> weekInterval = decoder.decodeIntElement(descriptor, i)
        18 ->
          _weekInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WeeklyTemplate: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.WeeklyTemplate,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.monday?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.monday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.tuesday?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.tuesday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.wednesday?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.wednesday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    ((value.thursday?.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
    (value.thursday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    ((value.friday?.value))?.let { encoder.encodeBooleanElement(descriptor, 11, it) }
    (value.friday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    ((value.saturday?.value))?.let { encoder.encodeBooleanElement(descriptor, 13, it) }
    (value.saturday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
    }
    ((value.sunday?.value))?.let { encoder.encodeBooleanElement(descriptor, 15, it) }
    (value.sunday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
    }
    ((value.weekInterval?.value))?.let { encoder.encodeIntElement(descriptor, 17, it) }
    (value.weekInterval?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.MonthlyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.MonthlyTemplate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.MonthlyTemplate {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> dayOfMonth = decoder.decodeIntElement(descriptor, i)
        4 ->
          _dayOfMonth =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          nthWeekOfMonth =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        6 ->
          dayOfWeek =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        7 -> monthInterval = decoder.decodeIntElement(descriptor, i)
        8 ->
          _monthInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MonthlyTemplate: " + i)
      }
    }
    return Appointment.RecurrenceTemplate.MonthlyTemplate(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.MonthlyTemplate,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.dayOfMonth?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.dayOfMonth?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.nthWeekOfMonth)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodingSerializer, it)
    }
    (value.dayOfWeek)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodingSerializer, it)
    }
    ((value.monthInterval.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.monthInterval.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
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

  internal val listSerializer: KSerializer<List<Appointment.RecurrenceTemplate.YearlyTemplate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Appointment.RecurrenceTemplate.YearlyTemplate =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment.RecurrenceTemplate.YearlyTemplate) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): Appointment.RecurrenceTemplate.YearlyTemplate {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var yearInterval: Int? = null
    var _yearInterval: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> yearInterval = decoder.decodeIntElement(descriptor, i)
        4 ->
          _yearInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding YearlyTemplate: " + i)
      }
    }
    return Appointment.RecurrenceTemplate.YearlyTemplate(
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate.YearlyTemplate,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.yearInterval.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.yearInterval.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
  }
}

internal object AppointmentSerializer : FhirResourceSerializer<Appointment> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Appointment")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
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
        Enumeration.of(status?.let { Appointment.AppointmentStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Appointment"),
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
      start = Instant.of(start?.let { FhirDateTime.fromString(it) }, _start),
      end = Instant.of(end?.let { FhirDateTime.fromString(it) }, _end),
      minutesDuration = PositiveInt.of(minutesDuration, _minutesDuration),
      requestedPeriod = requestedPeriod ?: listOf(),
      slot = slot ?: listOf(),
      account = account ?: listOf(),
      created = DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created),
      cancellationDate =
        DateTime.of(cancellationDate?.let { FhirDateTime.fromString(it) }, _cancellationDate),
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
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
    (value.cancellationReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
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
    (value.appointmentType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    (value.priority)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, ElementSerializer, it)
    }
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
    (value.previousAppointment)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.originatingAppointment)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.start?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ElementSerializer, it)
    }
    ((value.end?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, ElementSerializer, it)
    }
    ((value.minutesDuration?.value))?.let {
      encoder.encodeIntElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.minutesDuration?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ElementSerializer, it)
    }
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
    ((value.created?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ElementSerializer, it)
    }
    ((value.cancellationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.cancellationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 40 + descriptorOffset, ElementSerializer, it)
    }
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
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 44 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        AppointmentParticipantSerializer.listSerializer,
        value.participant,
      )
    ((value.recurrenceId?.value))?.let {
      encoder.encodeIntElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.recurrenceId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 47 + descriptorOffset, ElementSerializer, it)
    }
    ((value.occurrenceChanged?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 48 + descriptorOffset, it)
    }
    (value.occurrenceChanged?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 49 + descriptorOffset, ElementSerializer, it)
    }
    if (value.recurrenceTemplate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        AppointmentRecurrenceTemplateSerializer.listSerializer,
        value.recurrenceTemplate,
      )
  }
}
