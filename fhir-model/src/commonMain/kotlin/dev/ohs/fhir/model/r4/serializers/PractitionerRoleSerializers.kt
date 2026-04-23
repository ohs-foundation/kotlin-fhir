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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Uri
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

internal object PractitionerRoleAvailableTimeSerializer :
  KSerializer<PractitionerRole.AvailableTime> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AvailableTime") {
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
        "daysOfWeek",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_daysOfWeek",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("allDay", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_allDay", Element.serializer().descriptor, isOptional = true)
      element("availableStartTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_availableStartTime", Element.serializer().descriptor, isOptional = true)
      element("availableEndTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_availableEndTime", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PractitionerRole.AvailableTime =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.AvailableTime) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PractitionerRole.AvailableTime {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
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
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.daysOfWeekSer, null)
        4 ->
          _daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.daysOfWeekSer2, null)
        5 -> allDay = decoder.decodeBooleanElement(__desc, 5)
        6 ->
          _allDay =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.daysOfWeekSerInner2, null)
        7 ->
          availableStartTime =
            decoder.decodeNullableSerializableElement(__desc, 7, LocalTimeSerializer, null)
        8 ->
          _availableStartTime =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.daysOfWeekSerInner2, null)
        9 ->
          availableEndTime =
            decoder.decodeNullableSerializableElement(__desc, 9, LocalTimeSerializer, null)
        10 ->
          _availableEndTime =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.daysOfWeekSerInner2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AvailableTime: " + __i)
      }
    }
    return PractitionerRole.AvailableTime(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      daysOfWeek =
        (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { __i ->
          Enumeration.of(
            PractitionerRole.DaysOfWeek.fromCode(daysOfWeek?.getOrNull(__i)!!),
            _daysOfWeek?.getOrNull(__i),
          )
        }),
      allDay = R4Boolean.of(allDay, _allDay),
      availableStartTime = Time.of(availableStartTime, _availableStartTime),
      availableEndTime = Time.of(availableEndTime, _availableEndTime),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PractitionerRole.AvailableTime) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.daysOfWeek.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.daysOfWeekSer, it)
    }
    (value.daysOfWeek.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.daysOfWeekSer2, it)
    }
    ((value.allDay?.value))?.let { encoder.encodeBooleanElement(__desc, 5, it) }
    (value.allDay?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.availableStartTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 7, LocalTimeSerializer, it)
    }
    (value.availableStartTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.daysOfWeekSerInner2, it)
    }
    ((value.availableEndTime?.value))?.let {
      encoder.encodeSerializableElement(__desc, 9, LocalTimeSerializer, it)
    }
    (value.availableEndTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.daysOfWeekSerInner2, it)
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

internal object PractitionerRoleNotAvailableSerializer :
  KSerializer<PractitionerRole.NotAvailable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotAvailable") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("during", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PractitionerRole.NotAvailable =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.NotAvailable) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PractitionerRole.NotAvailable {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var during: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> during = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.duringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotAvailable: " + __i)
      }
    }
    return PractitionerRole.NotAvailable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4String.of(description, _description)!!,
      during = during,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PractitionerRole.NotAvailable) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    (value.during)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.duringSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()

    public val duringSer: KSerializer<Period> = Period.serializer()
  }
}

internal object PractitionerRoleSerializer : KSerializer<PractitionerRole> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PractitionerRole") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_active", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("practitioner", Reference.serializer().descriptor, isOptional = true)
      element("organization", Reference.serializer().descriptor, isOptional = true)
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "specialty",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "location",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "healthcareService",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "telecom",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element(
        "availableTime",
        listSerialDescriptor(
          lazyDescriptor { PractitionerRole.AvailableTime.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "notAvailable",
        listSerialDescriptor(
          lazyDescriptor { PractitionerRole.NotAvailable.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("availabilityExceptions", KotlinString.serializer().descriptor, isOptional = true)
      element("_availabilityExceptions", Element.serializer().descriptor, isOptional = true)
      element(
        "endpoint",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PractitionerRole =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): PractitionerRole {
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
    var active: KotlinBoolean? = null
    var _active: Element? = null
    var period: Period? = null
    var practitioner: Reference? = null
    var organization: Reference? = null
    var code: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var location: List<Reference>? = null
    var healthcareService: List<Reference>? = null
    var telecom: List<ContactPoint>? = null
    var availableTime: List<PractitionerRole.AvailableTime>? = null
    var notAvailable: List<PractitionerRole.NotAvailable>? = null
    var availabilityExceptions: KotlinString? = null
    var _availabilityExceptions: Element? = null
    var endpoint: List<Reference>? = null
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
        12 -> active = decoder.decodeBooleanElement(__desc, 12)
        13 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          period = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.periodSer, null)
        15 ->
          practitioner =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.practitionerSer, null)
        16 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.practitionerSer, null)
        17 -> code = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.codeSer, null)
        18 ->
          specialty = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.codeSer, null)
        19 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.locationSer, null)
        20 ->
          healthcareService =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.locationSer, null)
        21 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.telecomSer, null)
        22 ->
          availableTime =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.availableTimeSer, null)
        23 ->
          notAvailable =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.notAvailableSer, null)
        24 -> availabilityExceptions = decoder.decodeStringElement(__desc, 24)
        25 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.locationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PractitionerRole: " + __i)
      }
    }
    return PractitionerRole(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      active = R4Boolean.of(active, _active),
      period = period,
      practitioner = practitioner,
      organization = organization,
      code = code ?: listOf(),
      specialty = specialty ?: listOf(),
      location = location ?: listOf(),
      healthcareService = healthcareService ?: listOf(),
      telecom = telecom ?: listOf(),
      availableTime = availableTime ?: listOf(),
      notAvailable = notAvailable ?: listOf(),
      availabilityExceptions = R4String.of(availabilityExceptions, _availabilityExceptions),
      endpoint = endpoint ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PractitionerRole) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "PractitionerRole")
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
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 12, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.periodSer, it) }
    (value.practitioner)?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.practitionerSer, it)
    }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.practitionerSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.codeSer, value.code)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.codeSer, value.specialty)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.locationSer, value.location)
    if (value.healthcareService.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.locationSer, value.healthcareService)
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.telecomSer, value.telecom)
    if (value.availableTime.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.availableTimeSer, value.availableTime)
    if (value.notAvailable.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.notAvailableSer, value.notAvailable)
    ((value.availabilityExceptions?.value))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.availabilityExceptions?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.locationSer, value.endpoint)
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

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val practitionerSer: KSerializer<Reference> = Reference.serializer()

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val locationSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.practitionerSer)

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val availableTimeSerInner: KSerializer<PractitionerRole.AvailableTime> =
      PractitionerRole.AvailableTime.serializer()

    public val availableTimeSer: KSerializer<List<PractitionerRole.AvailableTime>> =
      ListSerializer(Hoisted.availableTimeSerInner)

    public val notAvailableSerInner: KSerializer<PractitionerRole.NotAvailable> =
      PractitionerRole.NotAvailable.serializer()

    public val notAvailableSer: KSerializer<List<PractitionerRole.NotAvailable>> =
      ListSerializer(Hoisted.notAvailableSerInner)
  }
}
