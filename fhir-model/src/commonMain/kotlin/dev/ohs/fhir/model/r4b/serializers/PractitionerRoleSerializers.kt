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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer, null)
        4 ->
          _daysOfWeek =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.daysOfWeekSer2, null)
        5 -> allDay = decoder.decodeBooleanElement(__desc, __i)
        6 ->
          _allDay =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        7 ->
          availableStartTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        8 ->
          _availableStartTime =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.daysOfWeekSerInner2,
              null,
            )
        9 ->
          availableEndTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        10 ->
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
      allDay = R4bBoolean.of(allDay, _allDay),
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, __i)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.descriptionSer, null)
        5 ->
          during = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.duringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotAvailable: " + __i)
      }
    }
    return PractitionerRole.NotAvailable(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description)!!,
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
    b.element("active", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_active", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("practitioner", Reference.serializer().descriptor, isOptional = true)
    b.element("organization", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "code",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "specialty",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "location",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "healthcareService",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "telecom",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "availableTime",
      listSerialDescriptor(
        lazyDescriptor { PractitionerRole.AvailableTime.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "notAvailable",
      listSerialDescriptor(
        lazyDescriptor { PractitionerRole.NotAvailable.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("availabilityExceptions", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_availabilityExceptions", Element.serializer().descriptor, isOptional = true)
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PractitionerRole =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PractitionerRole")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): PractitionerRole {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> active = decoder.decodeBooleanElement(__desc, __i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        14 ->
          practitioner =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.practitionerSer, null)
        15 ->
          organization =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.practitionerSer, null)
        16 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        17 ->
          specialty = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        18 ->
          location =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        19 ->
          healthcareService =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
        20 ->
          telecom = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.telecomSer, null)
        21 ->
          availableTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.availableTimeSer, null)
        22 ->
          notAvailable =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.notAvailableSer, null)
        23 -> availabilityExceptions = decoder.decodeStringElement(__desc, __i)
        24 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          endpoint =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.locationSer, null)
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
      active = R4bBoolean.of(active, _active),
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
      availabilityExceptions = R4bString.of(availabilityExceptions, _availabilityExceptions),
      endpoint = endpoint ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: PractitionerRole,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.active?.value))?.let { encoder.encodeBooleanElement(__desc, 11 + __off, it) }
    (value.active?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.periodSer, it)
    }
    (value.practitioner)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.practitionerSer, it)
    }
    (value.organization)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.practitionerSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.codeSer, value.code)
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.codeSer, value.specialty)
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.locationSer, value.location)
    if (value.healthcareService.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19 + __off,
        Hoisted.locationSer,
        value.healthcareService,
      )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.telecomSer, value.telecom)
    if (value.availableTime.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        21 + __off,
        Hoisted.availableTimeSer,
        value.availableTime,
      )
    if (value.notAvailable.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        22 + __off,
        Hoisted.notAvailableSer,
        value.notAvailable,
      )
    ((value.availabilityExceptions?.value))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.availabilityExceptions?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.locationSer, value.endpoint)
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

internal object PractitionerRolePolymorphicSerializer : KSerializer<PractitionerRole> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PractitionerRole") {
      PractitionerRoleSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole) {
    encoder.encodeStructure(descriptor) {
      PractitionerRoleSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PractitionerRole =
    decoder.decodeStructure(descriptor) {
      PractitionerRoleSerializer.deserializeJson(this, descriptor, 0)
    }
}
