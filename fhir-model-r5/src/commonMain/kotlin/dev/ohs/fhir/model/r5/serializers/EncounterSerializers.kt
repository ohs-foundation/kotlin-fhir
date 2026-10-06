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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Encounter
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.VirtualServiceDetail
import kotlin.Int
import kotlin.OptIn
import kotlin.String
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

internal object EncounterParticipantSerializer : KSerializer<Encounter.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Participant =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: List<CodeableConcept>? = null
      var period: Period? = null
      var actor: Reference? = null
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      Encounter.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type ?: listOf(),
        period = period,
        actor = actor,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Participant) {
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
    }
  }
}

internal object EncounterReasonSerializer : KSerializer<Encounter.Reason> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reason") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("use", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("value", CodeableReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Reason>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Reason =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var use: List<CodeableConcept>? = null
      var `value`: List<CodeableReference>? = null
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
            use =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            `value` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Reason: " + i)
        }
      }
      Encounter.Reason(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        use = use ?: listOf(),
        `value` = `value` ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Reason) {
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
      if (value.use.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.use,
        )
      if (value.`value`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableReferenceSerializer.listSerializer,
          value.`value`,
        )
    }
  }
}

internal object EncounterDiagnosisSerializer : KSerializer<Encounter.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("condition", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("use", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Diagnosis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Diagnosis =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var condition: List<CodeableReference>? = null
      var use: List<CodeableConcept>? = null
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
            condition =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            use =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
        }
      }
      Encounter.Diagnosis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        condition = condition ?: listOf(),
        use = use ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Diagnosis) {
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
      if (value.condition.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableReferenceSerializer.listSerializer,
          value.condition,
        )
      if (value.use.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.use,
        )
    }
  }
}

internal object EncounterAdmissionSerializer : KSerializer<Encounter.Admission> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Admission") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("preAdmissionIdentifier", IdentifierSerializer.descriptor)
      optionalElement("origin", ReferenceSerializer.descriptor)
      optionalElement("admitSource", CodeableConceptSerializer.descriptor)
      optionalElement("reAdmission", CodeableConceptSerializer.descriptor)
      optionalElement("destination", ReferenceSerializer.descriptor)
      optionalElement("dischargeDisposition", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Admission>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Admission =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var preAdmissionIdentifier: Identifier? = null
      var origin: Reference? = null
      var admitSource: CodeableConcept? = null
      var reAdmission: CodeableConcept? = null
      var destination: Reference? = null
      var dischargeDisposition: CodeableConcept? = null
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
            preAdmissionIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 -> origin = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            admitSource =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            reAdmission =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            destination =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            dischargeDisposition =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Admission: " + i)
        }
      }
      Encounter.Admission(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        preAdmissionIdentifier = preAdmissionIdentifier,
        origin = origin,
        admitSource = admitSource,
        reAdmission = reAdmission,
        destination = destination,
        dischargeDisposition = dischargeDisposition,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Admission) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.preAdmissionIdentifier)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.origin)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.admitSource)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.reAdmission)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.destination)
      encodeSerializableIfNotNull(
        descriptor,
        8,
        CodeableConceptSerializer,
        value.dischargeDisposition,
      )
    }
  }
}

internal object EncounterLocationSerializer : KSerializer<Encounter.Location> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Location") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("location", ReferenceSerializer.descriptor)
      optionalElement("status", String.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
      optionalElement("form", CodeableConceptSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Location>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Location =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var location: Reference? = null
      var status: String? = null
      var _status: Element? = null
      var form: CodeableConcept? = null
      var period: Period? = null
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
            location = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> status = decodeStringElement(descriptor, i)
          5 -> _status = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            form = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Location: " + i)
        }
      }
      Encounter.Location(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        location =
          location
            ?: throw SerializationException(
              "Missing required property 'location' on Encounter.Location"
            ),
        status =
          Enumeration.of(
            if (status != null) Encounter.EncounterLocationStatus.fromCode(status) else null,
            _status,
          ),
        form = form,
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Location) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.location)
      encodeStringIfNotNull(descriptor, 4, value.status?.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.status)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.form)
      encodeSerializableIfNotNull(descriptor, 7, PeriodSerializer, value.period)
    }
  }
}

internal object EncounterSerializer : FhirResourceSerializer<Encounter> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Encounter")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", String.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", String.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", String.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("status", String.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("class", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceType", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("subjectStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("episodeOfCare", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("careTeam", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.descriptor)
    b.optionalElement("serviceProvider", ReferenceSerializer.descriptor)
    b.optionalElement("participant", EncounterParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("appointment", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("virtualService", VirtualServiceDetailSerializer.listSerializer.descriptor)
    b.optionalElement("actualPeriod", PeriodSerializer.descriptor)
    b.optionalElement("plannedStartDate", String.serializer().descriptor)
    b.optionalElement("_plannedStartDate", ElementSerializer.descriptor)
    b.optionalElement("plannedEndDate", String.serializer().descriptor)
    b.optionalElement("_plannedEndDate", ElementSerializer.descriptor)
    b.optionalElement("length", DurationSerializer.descriptor)
    b.optionalElement("reason", EncounterReasonSerializer.listSerializer.descriptor)
    b.optionalElement("diagnosis", EncounterDiagnosisSerializer.listSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("dietPreference", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("specialArrangement", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("specialCourtesy", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("admission", EncounterAdmissionSerializer.descriptor)
    b.optionalElement("location", EncounterLocationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Encounter {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var `class`: List<CodeableConcept>? = null
    var priority: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var serviceType: List<CodeableReference>? = null
    var subject: Reference? = null
    var subjectStatus: CodeableConcept? = null
    var episodeOfCare: List<Reference>? = null
    var basedOn: List<Reference>? = null
    var careTeam: List<Reference>? = null
    var partOf: Reference? = null
    var serviceProvider: Reference? = null
    var participant: List<Encounter.Participant>? = null
    var appointment: List<Reference>? = null
    var virtualService: List<VirtualServiceDetail>? = null
    var actualPeriod: Period? = null
    var plannedStartDate: String? = null
    var _plannedStartDate: Element? = null
    var plannedEndDate: String? = null
    var _plannedEndDate: Element? = null
    var length: Duration? = null
    var reason: List<Encounter.Reason>? = null
    var diagnosis: List<Encounter.Diagnosis>? = null
    var account: List<Reference>? = null
    var dietPreference: List<CodeableConcept>? = null
    var specialArrangement: List<CodeableConcept>? = null
    var specialCourtesy: List<CodeableConcept>? = null
    var admission: Encounter.Admission? = null
    var location: List<Encounter.Location>? = null
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
          `class` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          serviceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          subjectStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          episodeOfCare =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          serviceProvider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterParticipantSerializer.listSerializer,
              null,
            )
        25 ->
          appointment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          virtualService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              VirtualServiceDetailSerializer.listSerializer,
              null,
            )
        27 ->
          actualPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        28 -> plannedStartDate = decoder.decodeStringElement(descriptor, i)
        29 ->
          _plannedStartDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> plannedEndDate = decoder.decodeStringElement(descriptor, i)
        31 ->
          _plannedEndDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          length =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        33 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterReasonSerializer.listSerializer,
              null,
            )
        34 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterDiagnosisSerializer.listSerializer,
              null,
            )
        35 ->
          account =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        36 ->
          dietPreference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        37 ->
          specialArrangement =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        38 ->
          specialCourtesy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        39 ->
          admission =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterAdmissionSerializer,
              null,
            )
        40 ->
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterLocationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Encounter: " + i)
      }
    }
    return Encounter(
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
          if (status != null) Encounter.EncounterStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Encounter"),
      `class` = `class` ?: listOf(),
      priority = priority,
      type = type ?: listOf(),
      serviceType = serviceType ?: listOf(),
      subject = subject,
      subjectStatus = subjectStatus,
      episodeOfCare = episodeOfCare ?: listOf(),
      basedOn = basedOn ?: listOf(),
      careTeam = careTeam ?: listOf(),
      partOf = partOf,
      serviceProvider = serviceProvider,
      participant = participant ?: listOf(),
      appointment = appointment ?: listOf(),
      virtualService = virtualService ?: listOf(),
      actualPeriod = actualPeriod,
      plannedStartDate =
        DateTime.of(
          if (plannedStartDate != null) FhirDateTime.fromString(plannedStartDate) else null,
          _plannedStartDate,
        ),
      plannedEndDate =
        DateTime.of(
          if (plannedEndDate != null) FhirDateTime.fromString(plannedEndDate) else null,
          _plannedEndDate,
        ),
      length = length,
      reason = reason ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      account = account ?: listOf(),
      dietPreference = dietPreference ?: listOf(),
      specialArrangement = specialArrangement ?: listOf(),
      specialCourtesy = specialCourtesy ?: listOf(),
      admission = admission,
      location = location ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Encounter,
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
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.`class`,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.serviceType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.serviceType,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.subjectStatus,
    )
    if (value.episodeOfCare.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.episodeOfCare,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.careTeam,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.partOf,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.serviceProvider,
    )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        EncounterParticipantSerializer.listSerializer,
        value.participant,
      )
    if (value.appointment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.appointment,
      )
    if (value.virtualService.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        VirtualServiceDetailSerializer.listSerializer,
        value.virtualService,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      PeriodSerializer,
      value.actualPeriod,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.plannedStartDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.plannedStartDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.plannedEndDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.plannedEndDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      DurationSerializer,
      value.length,
    )
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        EncounterReasonSerializer.listSerializer,
        value.reason,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        EncounterDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.account,
      )
    if (value.dietPreference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.dietPreference,
      )
    if (value.specialArrangement.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialArrangement,
      )
    if (value.specialCourtesy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.specialCourtesy,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      EncounterAdmissionSerializer,
      value.admission,
    )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        EncounterLocationSerializer.listSerializer,
        value.location,
      )
  }
}
