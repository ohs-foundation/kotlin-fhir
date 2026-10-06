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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.AllergyIntolerance
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object AllergyIntoleranceParticipantSerializer :
  KSerializer<AllergyIntolerance.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AllergyIntolerance.Participant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
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
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      AllergyIntolerance.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on AllergyIntolerance.Participant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object AllergyIntoleranceReactionSerializer : KSerializer<AllergyIntolerance.Reaction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Reaction") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("substance", CodeableConceptSerializer.descriptor)
      optionalElement("manifestation", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("onset", KotlinString.serializer().descriptor)
      optionalElement("_onset", ElementSerializer.descriptor)
      optionalElement("severity", KotlinString.serializer().descriptor)
      optionalElement("_severity", ElementSerializer.descriptor)
      optionalElement("exposureRoute", CodeableConceptSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AllergyIntolerance.Reaction>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Reaction =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var substance: CodeableConcept? = null
      var manifestation: List<CodeableReference>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var onset: KotlinString? = null
      var _onset: Element? = null
      var severity: KotlinString? = null
      var _severity: Element? = null
      var exposureRoute: CodeableConcept? = null
      var note: List<Annotation>? = null
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
            substance =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            manifestation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> onset = decodeStringElement(descriptor, i)
          8 -> _onset = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> severity = decodeStringElement(descriptor, i)
          10 ->
            _severity = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            exposureRoute =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Reaction: " + i)
        }
      }
      AllergyIntolerance.Reaction(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        substance = substance,
        manifestation = manifestation ?: listOf(),
        description = R5String.of(description, _description),
        onset = DateTime.of(if (onset != null) FhirDateTime.fromString(onset) else null, _onset),
        severity =
          Enumeration.of(
            if (severity != null) AllergyIntolerance.AllergyIntoleranceSeverity.fromCode(severity)
            else null,
            _severity,
          ),
        exposureRoute = exposureRoute,
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Reaction) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.substance)
      if (value.manifestation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableReferenceSerializer.listSerializer,
          value.manifestation,
        )
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      encodeStringIfNotNull(descriptor, 7, value.onset?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.onset)
      encodeStringIfNotNull(descriptor, 9, value.severity?.value?.code)
      encodeElementIfNotNull(descriptor, 10, value.severity)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.exposureRoute)
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 12, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object AllergyIntoleranceSerializer : FhirResourceSerializer<AllergyIntolerance> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("AllergyIntolerance")

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
    b.optionalElement("clinicalStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("verificationStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", stringNullableListSerializer.descriptor)
    b.optionalElement("_category", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("criticality", KotlinString.serializer().descriptor)
    b.optionalElement("_criticality", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("onsetDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_onsetDateTime", ElementSerializer.descriptor)
    b.optionalElement("onsetAge", AgeSerializer.descriptor)
    b.optionalElement("onsetPeriod", PeriodSerializer.descriptor)
    b.optionalElement("onsetRange", RangeSerializer.descriptor)
    b.optionalElement("onsetString", KotlinString.serializer().descriptor)
    b.optionalElement("_onsetString", ElementSerializer.descriptor)
    b.optionalElement("recordedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_recordedDate", ElementSerializer.descriptor)
    b.optionalElement(
      "participant",
      AllergyIntoleranceParticipantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("lastOccurrence", KotlinString.serializer().descriptor)
    b.optionalElement("_lastOccurrence", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("reaction", AllergyIntoleranceReactionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AllergyIntolerance {
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
    var clinicalStatus: CodeableConcept? = null
    var verificationStatus: CodeableConcept? = null
    var type: CodeableConcept? = null
    var category: List<KotlinString?>? = null
    var _category: List<Element?>? = null
    var criticality: KotlinString? = null
    var _criticality: Element? = null
    var code: CodeableConcept? = null
    var patient: Reference? = null
    var encounter: Reference? = null
    var onsetDateTime: KotlinString? = null
    var _onsetDateTime: Element? = null
    var onsetAge: Age? = null
    var onsetPeriod: Period? = null
    var onsetRange: Range? = null
    var onsetString: KotlinString? = null
    var _onsetString: Element? = null
    var recordedDate: KotlinString? = null
    var _recordedDate: Element? = null
    var participant: List<AllergyIntolerance.Participant>? = null
    var lastOccurrence: KotlinString? = null
    var _lastOccurrence: Element? = null
    var note: List<Annotation>? = null
    var reaction: List<AllergyIntolerance.Reaction>? = null
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
        11 ->
          clinicalStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          verificationStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        15 ->
          _category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        16 -> criticality = decoder.decodeStringElement(descriptor, i)
        17 ->
          _criticality =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> onsetDateTime = decoder.decodeStringElement(descriptor, i)
        22 ->
          _onsetDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          onsetAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        24 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        25 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        26 -> onsetString = decoder.decodeStringElement(descriptor, i)
        27 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        29 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AllergyIntoleranceParticipantSerializer.listSerializer,
              null,
            )
        31 -> lastOccurrence = decoder.decodeStringElement(descriptor, i)
        32 ->
          _lastOccurrence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        34 ->
          reaction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AllergyIntoleranceReactionSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding AllergyIntolerance: " + i)
      }
    }
    return AllergyIntolerance(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      clinicalStatus = clinicalStatus,
      verificationStatus = verificationStatus,
      type = type,
      category =
        (kotlin.collections.List(maxOf(category?.size ?: 0, _category?.size ?: 0)) { index ->
          Enumeration.of(
            category?.getOrNull(index)?.let {
              AllergyIntolerance.AllergyIntoleranceCategory.fromCode(it)
            },
            _category?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'category' on AllergyIntolerance has neither a value nor an id/extension"
            )
        }),
      criticality =
        Enumeration.of(
          if (criticality != null)
            AllergyIntolerance.AllergyIntoleranceCriticality.fromCode(criticality)
          else null,
          _criticality,
        ),
      code = code,
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on AllergyIntolerance"
          ),
      encounter = encounter,
      onset =
        AllergyIntolerance.Onset.from(
          DateTime.of(
            if (onsetDateTime != null) FhirDateTime.fromString(onsetDateTime) else null,
            _onsetDateTime,
          ),
          onsetAge,
          onsetPeriod,
          onsetRange,
          R5String.of(onsetString, _onsetString),
        ),
      recordedDate =
        DateTime.of(
          if (recordedDate != null) FhirDateTime.fromString(recordedDate) else null,
          _recordedDate,
        ),
      participant = participant ?: listOf(),
      lastOccurrence =
        DateTime.of(
          if (lastOccurrence != null) FhirDateTime.fromString(lastOccurrence) else null,
          _lastOccurrence,
        ),
      note = note ?: listOf(),
      reaction = reaction ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AllergyIntolerance,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.clinicalStatus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.verificationStatus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.category.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        14 + descriptorOffset,
        stringNullableListSerializer,
        value.category.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 15 + descriptorOffset, value.category)
    }
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.criticality?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.criticality)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.onset) {
      null -> {}
      is AllergyIntolerance.Onset.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is AllergyIntolerance.Onset.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.String -> {
        encoder.encodeStringIfNotNull(descriptor, 26 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.recordedDate)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AllergyIntoleranceParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.lastOccurrence?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.lastOccurrence)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.reaction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AllergyIntoleranceReactionSerializer.listSerializer,
        value.reaction,
      )
  }
}
