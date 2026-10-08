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
import dev.ohs.fhir.model.r5.terminologies.AllergyIntoleranceCategory
import dev.ohs.fhir.model.r5.terminologies.AllergyIntoleranceCriticality
import dev.ohs.fhir.model.r5.terminologies.AllergyIntoleranceSeverity
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

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Participant {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
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
          function =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AllergyIntolerance.Participant(
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
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.function,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    compositeEncoder.endStructure(descriptor)
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

  override fun deserialize(decoder: Decoder): AllergyIntolerance.Reaction {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          substance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          manifestation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> onset = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _onset =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> severity = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _severity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          exposureRoute =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Reaction: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return AllergyIntolerance.Reaction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      substance = substance,
      manifestation = manifestation ?: listOf(),
      description = R5String.of(description, _description),
      onset = DateTime.of(if (onset != null) FhirDateTime.fromString(onset) else null, _onset),
      severity =
        Enumeration.of(
          if (severity != null) AllergyIntoleranceSeverity.fromCode(severity) else null,
          _severity,
        ),
      exposureRoute = exposureRoute,
      note = note ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: AllergyIntolerance.Reaction) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.substance,
    )
    if (value.manifestation.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableReferenceSerializer.listSerializer,
        value.manifestation,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.onset?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.onset)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.severity?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.severity)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.exposureRoute,
    )
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
          clinicalStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          verificationStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        15 ->
          _category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        16 -> criticality = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _criticality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        19 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 -> onsetDateTime = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _onsetDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          onsetAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        24 ->
          onsetPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        25 ->
          onsetRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        26 -> onsetString = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _onsetString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> recordedDate = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _recordedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AllergyIntoleranceParticipantSerializer.listSerializer,
              null,
            )
        31 -> lastOccurrence = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _lastOccurrence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        34 ->
          reaction =
            compositeDecoder.decodeNullableSerializableElement(
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
            category?.getOrNull(index)?.let { AllergyIntoleranceCategory.fromCode(it) },
            _category?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'category' on AllergyIntolerance has neither a value nor an id/extension"
            )
        }),
      criticality =
        Enumeration.of(
          if (criticality != null) AllergyIntoleranceCriticality.fromCode(criticality) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AllergyIntolerance,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.clinicalStatus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.verificationStatus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.category.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        14 + descriptorOffset,
        stringNullableListSerializer,
        value.category.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 15 + descriptorOffset, value.category)
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.criticality?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.criticality)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.onset) {
      null -> {}
      is AllergyIntolerance.Onset.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          21 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, choice.value)
      }
      is AllergyIntolerance.Onset.Age -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.Range -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is AllergyIntolerance.Onset.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          26 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.recordedDate)
    if (value.participant.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AllergyIntoleranceParticipantSerializer.listSerializer,
        value.participant,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.lastOccurrence?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.lastOccurrence)
    if (value.note.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.reaction.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AllergyIntoleranceReactionSerializer.listSerializer,
        value.reaction,
      )
  }
}
