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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Encounter
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.Uri
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

internal object EncounterStatusHistorySerializer : KSerializer<Encounter.StatusHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusHistory") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("status", String.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.StatusHistory>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.StatusHistory =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var status: String? = null
      var _status: Element? = null
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
          3 -> status = decodeStringElement(descriptor, i)
          4 -> _status = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StatusHistory: " + i)
        }
      }
      Encounter.StatusHistory(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        status =
          Enumeration.of(
            if (status != null) Encounter.EncounterStatus.fromCode(status) else null,
            _status,
          )
            ?: throw SerializationException(
              "Missing required property 'status' on Encounter.StatusHistory"
            ),
        period =
          period
            ?: throw SerializationException(
              "Missing required property 'period' on Encounter.StatusHistory"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.StatusHistory) {
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
      encodeStringIfNotNull(descriptor, 3, value.status.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.status)
      encodeSerializableElement(descriptor, 5, PeriodSerializer, value.period)
    }
  }
}

internal object EncounterClassHistorySerializer : KSerializer<Encounter.ClassHistory> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ClassHistory") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("class", CodingSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.ClassHistory>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.ClassHistory =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `class`: Coding? = null
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
          3 -> `class` = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ClassHistory: " + i)
        }
      }
      Encounter.ClassHistory(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `class` =
          `class`
            ?: throw SerializationException(
              "Missing required property 'class' on Encounter.ClassHistory"
            ),
        period =
          period
            ?: throw SerializationException(
              "Missing required property 'period' on Encounter.ClassHistory"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.ClassHistory) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.`class`)
      encodeSerializableElement(descriptor, 4, PeriodSerializer, value.period)
    }
  }
}

internal object EncounterParticipantSerializer : KSerializer<Encounter.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("individual", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Participant =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: List<CodeableConcept>? = null
      var period: Period? = null
      var individual: Reference? = null
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
          5 ->
            individual = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
        individual = individual,
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
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.individual)
    }
  }
}

internal object EncounterDiagnosisSerializer : KSerializer<Encounter.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("condition", ReferenceSerializer.descriptor)
      optionalElement("use", CodeableConceptSerializer.descriptor)
      optionalElement("rank", Int.serializer().descriptor)
      optionalElement("_rank", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Diagnosis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Diagnosis =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var condition: Reference? = null
      var use: CodeableConcept? = null
      var rank: Int? = null
      var _rank: Element? = null
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
            condition = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            use = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> rank = decodeIntElement(descriptor, i)
          6 -> _rank = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
        }
      }
      Encounter.Diagnosis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        condition =
          condition
            ?: throw SerializationException(
              "Missing required property 'condition' on Encounter.Diagnosis"
            ),
        use = use,
        rank = PositiveInt.of(rank, _rank),
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.condition)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.use)
      encodeIntIfNotNull(descriptor, 5, value.rank?.value)
      encodeElementIfNotNull(descriptor, 6, value.rank)
    }
  }
}

internal object EncounterHospitalizationSerializer : KSerializer<Encounter.Hospitalization> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Hospitalization") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("preAdmissionIdentifier", IdentifierSerializer.descriptor)
      optionalElement("origin", ReferenceSerializer.descriptor)
      optionalElement("admitSource", CodeableConceptSerializer.descriptor)
      optionalElement("reAdmission", CodeableConceptSerializer.descriptor)
      optionalElement("dietPreference", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("specialCourtesy", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("specialArrangement", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("destination", ReferenceSerializer.descriptor)
      optionalElement("dischargeDisposition", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Encounter.Hospitalization>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Encounter.Hospitalization =
    decoder.decodeStructure(descriptor) {
      var id: String? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var preAdmissionIdentifier: Identifier? = null
      var origin: Reference? = null
      var admitSource: CodeableConcept? = null
      var reAdmission: CodeableConcept? = null
      var dietPreference: List<CodeableConcept>? = null
      var specialCourtesy: List<CodeableConcept>? = null
      var specialArrangement: List<CodeableConcept>? = null
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
            dietPreference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            specialCourtesy =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            specialArrangement =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          10 ->
            destination =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          11 ->
            dischargeDisposition =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Hospitalization: " + i)
        }
      }
      Encounter.Hospitalization(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        preAdmissionIdentifier = preAdmissionIdentifier,
        origin = origin,
        admitSource = admitSource,
        reAdmission = reAdmission,
        dietPreference = dietPreference ?: listOf(),
        specialCourtesy = specialCourtesy ?: listOf(),
        specialArrangement = specialArrangement ?: listOf(),
        destination = destination,
        dischargeDisposition = dischargeDisposition,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Encounter.Hospitalization) {
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
      if (value.dietPreference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.dietPreference,
        )
      if (value.specialCourtesy.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.specialCourtesy,
        )
      if (value.specialArrangement.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.specialArrangement,
        )
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.destination)
      encodeSerializableIfNotNull(
        descriptor,
        11,
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
      optionalElement("physicalType", CodeableConceptSerializer.descriptor)
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
      var physicalType: CodeableConcept? = null
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
            physicalType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
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
        physicalType = physicalType,
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
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.physicalType)
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
    b.optionalElement("statusHistory", EncounterStatusHistorySerializer.listSerializer.descriptor)
    b.optionalElement("class", CodingSerializer.descriptor)
    b.optionalElement("classHistory", EncounterClassHistorySerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("serviceType", CodeableConceptSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("episodeOfCare", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("participant", EncounterParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("appointment", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("length", DurationSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("diagnosis", EncounterDiagnosisSerializer.listSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("hospitalization", EncounterHospitalizationSerializer.descriptor)
    b.optionalElement("location", EncounterLocationSerializer.listSerializer.descriptor)
    b.optionalElement("serviceProvider", ReferenceSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.descriptor)
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
    var statusHistory: List<Encounter.StatusHistory>? = null
    var `class`: Coding? = null
    var classHistory: List<Encounter.ClassHistory>? = null
    var type: List<CodeableConcept>? = null
    var serviceType: CodeableConcept? = null
    var priority: CodeableConcept? = null
    var subject: Reference? = null
    var episodeOfCare: List<Reference>? = null
    var basedOn: List<Reference>? = null
    var participant: List<Encounter.Participant>? = null
    var appointment: List<Reference>? = null
    var period: Period? = null
    var length: Duration? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var diagnosis: List<Encounter.Diagnosis>? = null
    var account: List<Reference>? = null
    var hospitalization: Encounter.Hospitalization? = null
    var location: List<Encounter.Location>? = null
    var serviceProvider: Reference? = null
    var partOf: Reference? = null
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
          statusHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterStatusHistorySerializer.listSerializer,
              null,
            )
        14 ->
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        15 ->
          classHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterClassHistorySerializer.listSerializer,
              null,
            )
        16 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          serviceType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          episodeOfCare =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        21 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterParticipantSerializer.listSerializer,
              null,
            )
        23 ->
          appointment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        25 ->
          length =
            decoder.decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
        26 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        27 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterDiagnosisSerializer.listSerializer,
              null,
            )
        29 ->
          account =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          hospitalization =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterHospitalizationSerializer,
              null,
            )
        31 ->
          location =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EncounterLocationSerializer.listSerializer,
              null,
            )
        32 ->
          serviceProvider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        33 ->
          partOf =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
      statusHistory = statusHistory ?: listOf(),
      `class` =
        `class` ?: throw SerializationException("Missing required property 'class' on Encounter"),
      classHistory = classHistory ?: listOf(),
      type = type ?: listOf(),
      serviceType = serviceType,
      priority = priority,
      subject = subject,
      episodeOfCare = episodeOfCare ?: listOf(),
      basedOn = basedOn ?: listOf(),
      participant = participant ?: listOf(),
      appointment = appointment ?: listOf(),
      period = period,
      length = length,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      account = account ?: listOf(),
      hospitalization = hospitalization,
      location = location ?: listOf(),
      serviceProvider = serviceProvider,
      partOf = partOf,
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
    if (value.statusHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        EncounterStatusHistorySerializer.listSerializer,
        value.statusHistory,
      )
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodingSerializer,
      value.`class`,
    )
    if (value.classHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        EncounterClassHistorySerializer.listSerializer,
        value.classHistory,
      )
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.serviceType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.episodeOfCare.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.episodeOfCare,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        EncounterParticipantSerializer.listSerializer,
        value.participant,
      )
    if (value.appointment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.appointment,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      DurationSerializer,
      value.length,
    )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        EncounterDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.account.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.account,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      EncounterHospitalizationSerializer,
      value.hospitalization,
    )
    if (value.location.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        EncounterLocationSerializer.listSerializer,
        value.location,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.serviceProvider,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.partOf,
    )
  }
}
