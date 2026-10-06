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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.HealthcareService
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
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

internal object HealthcareServiceEligibilitySerializer :
  KSerializer<HealthcareService.Eligibility> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Eligibility") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<HealthcareService.Eligibility>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): HealthcareService.Eligibility =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var comment: KotlinString? = null
      var _comment: Element? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> comment = decodeStringElement(descriptor, i)
          5 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Eligibility: " + i)
        }
      }
      HealthcareService.Eligibility(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code,
        comment = Markdown.of(comment, _comment),
      )
    }

  override fun serialize(encoder: Encoder, `value`: HealthcareService.Eligibility) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeStringIfNotNull(descriptor, 4, value.comment?.value)
      encodeElementIfNotNull(descriptor, 5, value.comment)
    }
  }
}

internal object HealthcareServiceAvailableTimeSerializer :
  KSerializer<HealthcareService.AvailableTime> {
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

  internal val listSerializer: KSerializer<List<HealthcareService.AvailableTime>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): HealthcareService.AvailableTime =
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
      HealthcareService.AvailableTime(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        daysOfWeek =
          (kotlin.collections.List(maxOf(daysOfWeek?.size ?: 0, _daysOfWeek?.size ?: 0)) { index ->
            Enumeration.of(
              daysOfWeek?.getOrNull(index)?.let { HealthcareService.DaysOfWeek.fromCode(it) },
              _daysOfWeek?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'daysOfWeek' on HealthcareService.AvailableTime has neither a value nor an id/extension"
              )
          }),
        allDay = R4Boolean.of(allDay, _allDay),
        availableStartTime = Time.of(availableStartTime, _availableStartTime),
        availableEndTime = Time.of(availableEndTime, _availableEndTime),
      )
    }

  override fun serialize(encoder: Encoder, `value`: HealthcareService.AvailableTime) {
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

internal object HealthcareServiceNotAvailableSerializer :
  KSerializer<HealthcareService.NotAvailable> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotAvailable") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("during", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<HealthcareService.NotAvailable>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): HealthcareService.NotAvailable =
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
      HealthcareService.NotAvailable(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description =
          R4String.of(description, _description)
            ?: throw SerializationException(
              "Missing required property 'description' on HealthcareService.NotAvailable"
            ),
        during = during,
      )
    }

  override fun serialize(encoder: Encoder, `value`: HealthcareService.NotAvailable) {
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

internal object HealthcareServiceSerializer : FhirResourceSerializer<HealthcareService> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("HealthcareService")

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
    b.optionalElement("providedBy", ReferenceSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("specialty", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("comment", KotlinString.serializer().descriptor)
    b.optionalElement("_comment", ElementSerializer.descriptor)
    b.optionalElement("extraDetails", KotlinString.serializer().descriptor)
    b.optionalElement("_extraDetails", ElementSerializer.descriptor)
    b.optionalElement("photo", AttachmentSerializer.descriptor)
    b.optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("coverageArea", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("serviceProvisionCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "eligibility",
      HealthcareServiceEligibilitySerializer.listSerializer.descriptor,
    )
    b.optionalElement("program", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("characteristic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("communication", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("referralMethod", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("appointmentRequired", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_appointmentRequired", ElementSerializer.descriptor)
    b.optionalElement(
      "availableTime",
      HealthcareServiceAvailableTimeSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "notAvailable",
      HealthcareServiceNotAvailableSerializer.listSerializer.descriptor,
    )
    b.optionalElement("availabilityExceptions", KotlinString.serializer().descriptor)
    b.optionalElement("_availabilityExceptions", ElementSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): HealthcareService {
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
    var providedBy: Reference? = null
    var category: List<CodeableConcept>? = null
    var type: List<CodeableConcept>? = null
    var specialty: List<CodeableConcept>? = null
    var location: List<Reference>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var comment: KotlinString? = null
    var _comment: Element? = null
    var extraDetails: KotlinString? = null
    var _extraDetails: Element? = null
    var photo: Attachment? = null
    var telecom: List<ContactPoint>? = null
    var coverageArea: List<Reference>? = null
    var serviceProvisionCode: List<CodeableConcept>? = null
    var eligibility: List<HealthcareService.Eligibility>? = null
    var program: List<CodeableConcept>? = null
    var characteristic: List<CodeableConcept>? = null
    var communication: List<CodeableConcept>? = null
    var referralMethod: List<CodeableConcept>? = null
    var appointmentRequired: KotlinBoolean? = null
    var _appointmentRequired: Element? = null
    var availableTime: List<HealthcareService.AvailableTime>? = null
    var notAvailable: List<HealthcareService.NotAvailable>? = null
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
          providedBy =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        16 ->
          specialty =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> comment = decoder.decodeStringElement(descriptor, i)
        21 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> extraDetails = decoder.decodeStringElement(descriptor, i)
        23 ->
          _extraDetails =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          photo =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        25 ->
          telecom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        26 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          serviceProvisionCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        28 ->
          eligibility =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HealthcareServiceEligibilitySerializer.listSerializer,
              null,
            )
        29 ->
          program =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        30 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        31 ->
          communication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 ->
          referralMethod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        33 -> appointmentRequired = decoder.decodeBooleanElement(descriptor, i)
        34 ->
          _appointmentRequired =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          availableTime =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HealthcareServiceAvailableTimeSerializer.listSerializer,
              null,
            )
        36 ->
          notAvailable =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HealthcareServiceNotAvailableSerializer.listSerializer,
              null,
            )
        37 -> availabilityExceptions = decoder.decodeStringElement(descriptor, i)
        38 ->
          _availabilityExceptions =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding HealthcareService: " + i)
      }
    }
    return HealthcareService(
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
      providedBy = providedBy,
      category = category ?: listOf(),
      type = type ?: listOf(),
      specialty = specialty ?: listOf(),
      location = location ?: listOf(),
      name = R4String.of(name, _name),
      comment = R4String.of(comment, _comment),
      extraDetails = Markdown.of(extraDetails, _extraDetails),
      photo = photo,
      telecom = telecom ?: listOf(),
      coverageArea = coverageArea ?: listOf(),
      serviceProvisionCode = serviceProvisionCode ?: listOf(),
      eligibility = eligibility ?: listOf(),
      program = program ?: listOf(),
      characteristic = characteristic ?: listOf(),
      communication = communication ?: listOf(),
      referralMethod = referralMethod ?: listOf(),
      appointmentRequired = R4Boolean.of(appointmentRequired, _appointmentRequired),
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
    `value`: HealthcareService,
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
      ReferenceSerializer,
      value.providedBy,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.specialty.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialty,
      )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.location,
      )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.comment?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.comment)
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.extraDetails?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.extraDetails)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      AttachmentSerializer,
      value.photo,
    )
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.telecom,
      )
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.coverageArea,
      )
    if (value.serviceProvisionCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.serviceProvisionCode,
      )
    if (value.eligibility.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        HealthcareServiceEligibilitySerializer.listSerializer,
        value.eligibility,
      )
    if (value.program.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.program,
      )
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.characteristic,
      )
    if (value.communication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.communication,
      )
    if (value.referralMethod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.referralMethod,
      )
    encoder.encodeBooleanIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.appointmentRequired?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.appointmentRequired)
    if (value.availableTime.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        HealthcareServiceAvailableTimeSerializer.listSerializer,
        value.availableTime,
      )
    if (value.notAvailable.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        HealthcareServiceNotAvailableSerializer.listSerializer,
        value.notAvailable,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.availabilityExceptions?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.availabilityExceptions)
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
  }
}
