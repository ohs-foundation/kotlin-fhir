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
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        5 ->
          actor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actorSer, null)
        6 -> required = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _required =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
        8 -> status = decoder.decodeStringElement(descriptor, i)
        9 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requiredSer, null)
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
        Enumeration.of(
          Appointment.ParticipationStatus.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on Appointment.Participant"
              )
          ),
          _status,
        ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Appointment.Participant) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.actorSer, it) }
    ((value.required?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.requiredSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.requiredSer, it)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          timezone =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timezoneSer, null)
        4 ->
          recurrenceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.timezoneSer, null)
        5 -> lastOccurrenceDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _lastOccurrenceDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.lastOccurrenceDateSer,
              null,
            )
        7 -> occurrenceCount = decoder.decodeIntElement(descriptor, i)
        8 ->
          _occurrenceCount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.lastOccurrenceDateSer,
              null,
            )
        9 ->
          occurrenceDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceDateSer,
              null,
            )
        10 ->
          _occurrenceDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceDateSer2,
              null,
            )
        11 ->
          weeklyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.weeklyTemplateSer,
              null,
            )
        12 ->
          monthlyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.monthlyTemplateSer,
              null,
            )
        13 ->
          yearlyTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.yearlyTemplateSer,
              null,
            )
        14 ->
          excludingDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceDateSer,
              null,
            )
        15 ->
          _excludingDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceDateSer2,
              null,
            )
        16 ->
          excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.excludingRecurrenceIdSer,
              null,
            )
        17 ->
          _excludingRecurrenceId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceDateSer2,
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
          )!!
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
          )!!
        }),
      excludingRecurrenceId =
        (kotlin.collections.List(
          maxOf(excludingRecurrenceId?.size ?: 0, _excludingRecurrenceId?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            excludingRecurrenceId?.getOrNull(index)?.let { it },
            _excludingRecurrenceId?.getOrNull(index),
          )!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Appointment.RecurrenceTemplate,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.timezone)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.timezoneSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.timezoneSer, value.recurrenceType)
    ((value.lastOccurrenceDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 5, it)
    }
    (value.lastOccurrenceDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.lastOccurrenceDateSer, it)
    }
    ((value.occurrenceCount?.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.occurrenceCount?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.lastOccurrenceDateSer, it)
    }
    (value.occurrenceDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.occurrenceDateSer, it)
    }
    (value.occurrenceDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.occurrenceDateSer2, it)
    }
    (value.weeklyTemplate)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.weeklyTemplateSer, it)
    }
    (value.monthlyTemplate)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.monthlyTemplateSer, it)
    }
    (value.yearlyTemplate)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.yearlyTemplateSer, it)
    }
    (value.excludingDate.map { it.value?.toString() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.occurrenceDateSer, it)
    }
    (value.excludingDate.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.occurrenceDateSer2, it)
    }
    (value.excludingRecurrenceId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.excludingRecurrenceIdSer, it)
    }
    (value.excludingRecurrenceId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.occurrenceDateSer2, it)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> monday = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _monday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        5 -> tuesday = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _tuesday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        7 -> wednesday = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _wednesday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        9 -> thursday = decoder.decodeBooleanElement(descriptor, i)
        10 ->
          _thursday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        11 -> friday = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _friday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        13 -> saturday = decoder.decodeBooleanElement(descriptor, i)
        14 ->
          _saturday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        15 -> sunday = decoder.decodeBooleanElement(descriptor, i)
        16 ->
          _sunday =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
        17 -> weekInterval = decoder.decodeIntElement(descriptor, i)
        18 ->
          _weekInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.mondaySer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.monday?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.monday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.mondaySer, it)
    }
    ((value.tuesday?.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.tuesday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.mondaySer, it)
    }
    ((value.wednesday?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.wednesday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.mondaySer, it)
    }
    ((value.thursday?.value))?.let { encoder.encodeBooleanElement(descriptor, 9, it) }
    (value.thursday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.mondaySer, it)
    }
    ((value.friday?.value))?.let { encoder.encodeBooleanElement(descriptor, 11, it) }
    (value.friday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.mondaySer, it)
    }
    ((value.saturday?.value))?.let { encoder.encodeBooleanElement(descriptor, 13, it) }
    (value.saturday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.mondaySer, it)
    }
    ((value.sunday?.value))?.let { encoder.encodeBooleanElement(descriptor, 15, it) }
    (value.sunday?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.mondaySer, it)
    }
    ((value.weekInterval?.value))?.let { encoder.encodeIntElement(descriptor, 17, it) }
    (value.weekInterval?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.mondaySer, it)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> dayOfMonth = decoder.decodeIntElement(descriptor, i)
        4 ->
          _dayOfMonth =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfMonthSer, null)
        5 ->
          nthWeekOfMonth =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.nthWeekOfMonthSer,
              null,
            )
        6 ->
          dayOfWeek =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.nthWeekOfMonthSer,
              null,
            )
        7 -> monthInterval = decoder.decodeIntElement(descriptor, i)
        8 ->
          _monthInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.dayOfMonthSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.dayOfMonth?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.dayOfMonth?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.dayOfMonthSer, it)
    }
    (value.nthWeekOfMonth)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nthWeekOfMonthSer, it)
    }
    (value.dayOfWeek)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nthWeekOfMonthSer, it)
    }
    ((value.monthInterval.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
    (value.monthInterval.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.dayOfMonthSer, it)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> yearInterval = decoder.decodeIntElement(descriptor, i)
        4 ->
          _yearInterval =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.yearIntervalSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.yearInterval.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.yearInterval.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.yearIntervalSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Appointment) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Appointment")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          cancellationReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.cancellationReasonSer,
              null,
            )
        14 ->
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        15 ->
          serviceCategory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        16 ->
          serviceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceTypeSer, null)
        17 ->
          specialty =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        18 ->
          appointmentType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.cancellationReasonSer,
              null,
            )
        19 ->
          reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceTypeSer, null)
        20 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.cancellationReasonSer,
              null,
            )
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          replaces =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSer, null)
        24 ->
          virtualService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.virtualServiceSer,
              null,
            )
        25 ->
          supportingInformation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSer, null)
        26 ->
          previousAppointment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSerInner, null)
        27 ->
          originatingAppointment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSerInner, null)
        28 -> start = decoder.decodeStringElement(descriptor, i)
        29 ->
          _start =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> end = decoder.decodeStringElement(descriptor, i)
        31 ->
          _end =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 -> minutesDuration = decoder.decodeIntElement(descriptor, i)
        33 ->
          _minutesDuration =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 ->
          requestedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.requestedPeriodSer,
              null,
            )
        35 ->
          slot = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSer, null)
        36 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSer, null)
        37 -> created = decoder.decodeStringElement(descriptor, i)
        38 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> cancellationDate = decoder.decodeStringElement(descriptor, i)
        40 ->
          _cancellationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        42 ->
          patientInstruction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.serviceTypeSer, null)
        43 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSer, null)
        44 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.replacesSerInner, null)
        45 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        46 -> recurrenceId = decoder.decodeIntElement(descriptor, i)
        47 ->
          _recurrenceId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        48 -> occurrenceChanged = decoder.decodeBooleanElement(descriptor, i)
        49 ->
          _occurrenceChanged =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        50 ->
          recurrenceTemplate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.recurrenceTemplateSer,
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
          Appointment.AppointmentStatus.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on Appointment")
          ),
          _status,
        ),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Appointment,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.cancellationReason)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.cancellationReasonSer,
        it,
      )
    }
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.classSer,
        value.`class`,
      )
    if (value.serviceCategory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.classSer,
        value.serviceCategory,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.serviceTypeSer,
        value.serviceType,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.classSer,
        value.specialty,
      )
    (value.appointmentType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.cancellationReasonSer,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.serviceTypeSer,
        value.reason,
      )
    (value.priority)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.cancellationReasonSer,
        it,
      )
    }
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.replaces.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.replacesSer,
        value.replaces,
      )
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.virtualServiceSer,
        value.virtualService,
      )
    if (value.supportingInformation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.replacesSer,
        value.supportingInformation,
      )
    (value.previousAppointment)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.replacesSerInner,
        it,
      )
    }
    (value.originatingAppointment)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.replacesSerInner,
        it,
      )
    }
    ((value.start?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.end?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.minutesDuration?.value))?.let {
      encoder.encodeIntElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.minutesDuration?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.requestedPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.requestedPeriodSer,
        value.requestedPeriod,
      )
    if (value.slot.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.replacesSer,
        value.slot,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.replacesSer,
        value.account,
      )
    ((value.created?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.created?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.cancellationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.cancellationDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
      )
    if (value.patientInstruction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.serviceTypeSer,
        value.patientInstruction,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.replacesSer,
        value.basedOn,
      )
    (value.subject)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.replacesSerInner,
        it,
      )
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    ((value.recurrenceId?.value))?.let {
      encoder.encodeIntElement(descriptor, 46 + descriptorOffset, it)
    }
    (value.recurrenceId?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.occurrenceChanged?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 48 + descriptorOffset, it)
    }
    (value.occurrenceChanged?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.recurrenceTemplate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
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
    encoder.encodeStructure(descriptor) {
      AppointmentSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Appointment =
    decoder.decodeStructure(descriptor) {
      AppointmentSerializer.deserializeInternal(this, descriptor, 0)
    }
}
