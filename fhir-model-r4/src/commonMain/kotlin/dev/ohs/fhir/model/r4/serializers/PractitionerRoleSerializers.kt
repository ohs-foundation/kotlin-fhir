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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("daysOfWeek", stringNullableListSerializer.descriptor)
      optionalElement("_daysOfWeek", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("allDay", KotlinBoolean.serializer().descriptor)
      optionalElement("_allDay", ElementSerializer.descriptor)
      optionalElement("availableStartTime", LocalTimeSerializer.descriptor)
      optionalElement("_availableStartTime", ElementSerializer.descriptor)
      optionalElement("availableEndTime", LocalTimeSerializer.descriptor)
      optionalElement("_availableEndTime", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PractitionerRole.AvailableTime>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PractitionerRole.AvailableTime =
    decoder.decodeStructure(descriptor) {
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
            daysOfWeek =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          4 ->
            _daysOfWeek =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 -> allDay = decodeBooleanElement(descriptor, i)
          6 -> _allDay = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            availableStartTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          8 ->
            _availableStartTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            availableEndTime =
              decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          10 ->
            _availableEndTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AvailableTime: " + i)
        }
      }
      PractitionerRole.AvailableTime(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        daysOfWeek =
          (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { index ->
            Enumeration.of(
              daysOfWeek?.getOrNull(index)?.let { PractitionerRole.DaysOfWeek.fromCode(it) },
              _daysOfWeek?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'daysOfWeek' on PractitionerRole.AvailableTime has neither a value nor an id/extension"
              )
          }),
        allDay = R4Boolean.of(allDay, _allDay),
        availableStartTime = Time.of(availableStartTime, _availableStartTime),
        availableEndTime = Time.of(availableEndTime, _availableEndTime),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.AvailableTime) {
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
      if (value.daysOfWeek.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          stringNullableListSerializer,
          value.daysOfWeek.map { it.value?.code },
        )
        encodePrimitiveElementList(descriptor, 4, value.daysOfWeek)
      }
      encodeBooleanIfNotNull(descriptor, 5, value.allDay?.value)
      encodeElementIfNotNull(descriptor, 6, value.allDay)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        LocalTimeSerializer,
        value.availableStartTime?.value,
      )
      encodeElementIfNotNull(descriptor, 8, value.availableStartTime)
      encodeSerializableIfNotNull(descriptor, 9, LocalTimeSerializer, value.availableEndTime?.value)
      encodeElementIfNotNull(descriptor, 10, value.availableEndTime)
    }
  }
}

internal object PractitionerRoleNotAvailableSerializer :
  KSerializer<PractitionerRole.NotAvailable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotAvailable") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("during", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PractitionerRole.NotAvailable>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PractitionerRole.NotAvailable =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
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
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> during = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NotAvailable: " + i)
        }
      }
      PractitionerRole.NotAvailable(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description =
          R4String.of(description, _description)
            ?: throw SerializationException(
              "Missing required property 'description' on PractitionerRole.NotAvailable"
            ),
        during = during,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.NotAvailable) {
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
      encodeStringIfNotNull(descriptor, 3, value.description.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeSerializableIfNotNull(descriptor, 5, PeriodSerializer, value.during)
    }
  }
}

internal object PractitionerRoleSerializer : FhirResourceSerializer<PractitionerRole> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PractitionerRole")

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
    b.optionalElement("active", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_active", ElementSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("practitioner", ReferenceSerializer.descriptor)
    b.optionalElement("organization", ReferenceSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("specialty", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("healthcareService", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement(
      "availableTime",
      PractitionerRoleAvailableTimeSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "notAvailable",
      PractitionerRoleNotAvailableSerializer.listSerializer.descriptor,
    )
    b.optionalElement("availabilityExceptions", KotlinString.serializer().descriptor)
    b.optionalElement("_availabilityExceptions", ElementSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PractitionerRole {
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
        11 -> active = decoder.decodeBooleanElement(descriptor, i)
        12 ->
          _active =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        14 ->
          practitioner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        15 ->
          organization =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
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
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          healthcareService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        21 ->
          availableTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PractitionerRoleAvailableTimeSerializer.listSerializer,
              null,
            )
        22 ->
          notAvailable =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PractitionerRoleNotAvailableSerializer.listSerializer,
              null,
            )
        23 -> availabilityExceptions = decoder.decodeStringElement(descriptor, i)
        24 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding PractitionerRole: " + i)
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PractitionerRole,
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
    encoder.encodeBooleanIfNotNull(descriptor, 11 + descriptorOffset, value.active?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.active)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.practitioner,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.organization,
    )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialty,
      )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.location,
      )
    if (value.healthcareService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.healthcareService,
      )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    if (value.availableTime.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        PractitionerRoleAvailableTimeSerializer.listSerializer,
        value.availableTime,
      )
    if (value.notAvailable.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        PractitionerRoleNotAvailableSerializer.listSerializer,
        value.notAvailable,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.availabilityExceptions?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.availabilityExceptions)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
  }
}
