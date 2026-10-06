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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.DataRequirement
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.ResearchElementDefinition
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object ResearchElementDefinitionCharacteristicSerializer :
  KSerializer<ResearchElementDefinition.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("definitionCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionExpression", ExpressionSerializer.descriptor)
      optionalElement("definitionDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("usageContext", UsageContextSerializer.listSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement("unitOfMeasure", CodeableConceptSerializer.descriptor)
      optionalElement("studyEffectiveDescription", KotlinString.serializer().descriptor)
      optionalElement("_studyEffectiveDescription", ElementSerializer.descriptor)
      optionalElement("studyEffectiveDateTime", KotlinString.serializer().descriptor)
      optionalElement("_studyEffectiveDateTime", ElementSerializer.descriptor)
      optionalElement("studyEffectivePeriod", PeriodSerializer.descriptor)
      optionalElement("studyEffectiveDuration", DurationSerializer.descriptor)
      optionalElement("studyEffectiveTiming", TimingSerializer.descriptor)
      optionalElement("studyEffectiveTimeFromStart", DurationSerializer.descriptor)
      optionalElement("studyEffectiveGroupMeasure", KotlinString.serializer().descriptor)
      optionalElement("_studyEffectiveGroupMeasure", ElementSerializer.descriptor)
      optionalElement("participantEffectiveDescription", KotlinString.serializer().descriptor)
      optionalElement("_participantEffectiveDescription", ElementSerializer.descriptor)
      optionalElement("participantEffectiveDateTime", KotlinString.serializer().descriptor)
      optionalElement("_participantEffectiveDateTime", ElementSerializer.descriptor)
      optionalElement("participantEffectivePeriod", PeriodSerializer.descriptor)
      optionalElement("participantEffectiveDuration", DurationSerializer.descriptor)
      optionalElement("participantEffectiveTiming", TimingSerializer.descriptor)
      optionalElement("participantEffectiveTimeFromStart", DurationSerializer.descriptor)
      optionalElement("participantEffectiveGroupMeasure", KotlinString.serializer().descriptor)
      optionalElement("_participantEffectiveGroupMeasure", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ResearchElementDefinition.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var definitionCodeableConcept: CodeableConcept? = null
      var definitionCanonical: KotlinString? = null
      var _definitionCanonical: Element? = null
      var definitionExpression: Expression? = null
      var definitionDataRequirement: DataRequirement? = null
      var usageContext: List<UsageContext>? = null
      var exclude: KotlinBoolean? = null
      var _exclude: Element? = null
      var unitOfMeasure: CodeableConcept? = null
      var studyEffectiveDescription: KotlinString? = null
      var _studyEffectiveDescription: Element? = null
      var studyEffectiveDateTime: KotlinString? = null
      var _studyEffectiveDateTime: Element? = null
      var studyEffectivePeriod: Period? = null
      var studyEffectiveDuration: Duration? = null
      var studyEffectiveTiming: Timing? = null
      var studyEffectiveTimeFromStart: Duration? = null
      var studyEffectiveGroupMeasure: KotlinString? = null
      var _studyEffectiveGroupMeasure: Element? = null
      var participantEffectiveDescription: KotlinString? = null
      var _participantEffectiveDescription: Element? = null
      var participantEffectiveDateTime: KotlinString? = null
      var _participantEffectiveDateTime: Element? = null
      var participantEffectivePeriod: Period? = null
      var participantEffectiveDuration: Duration? = null
      var participantEffectiveTiming: Timing? = null
      var participantEffectiveTimeFromStart: Duration? = null
      var participantEffectiveGroupMeasure: KotlinString? = null
      var _participantEffectiveGroupMeasure: Element? = null
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
            definitionCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> definitionCanonical = decodeStringElement(descriptor, i)
          5 ->
            _definitionCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            definitionExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          7 ->
            definitionDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          8 ->
            usageContext =
              decodeNullableSerializableElement(
                descriptor,
                i,
                UsageContextSerializer.listSerializer,
                null,
              )
          9 -> exclude = decodeBooleanElement(descriptor, i)
          10 -> _exclude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            unitOfMeasure =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 -> studyEffectiveDescription = decodeStringElement(descriptor, i)
          13 ->
            _studyEffectiveDescription =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> studyEffectiveDateTime = decodeStringElement(descriptor, i)
          15 ->
            _studyEffectiveDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            studyEffectivePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          17 ->
            studyEffectiveDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          18 ->
            studyEffectiveTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          19 ->
            studyEffectiveTimeFromStart =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          20 -> studyEffectiveGroupMeasure = decodeStringElement(descriptor, i)
          21 ->
            _studyEffectiveGroupMeasure =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 -> participantEffectiveDescription = decodeStringElement(descriptor, i)
          23 ->
            _participantEffectiveDescription =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 -> participantEffectiveDateTime = decodeStringElement(descriptor, i)
          25 ->
            _participantEffectiveDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 ->
            participantEffectivePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          27 ->
            participantEffectiveDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          28 ->
            participantEffectiveTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          29 ->
            participantEffectiveTimeFromStart =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          30 -> participantEffectiveGroupMeasure = decodeStringElement(descriptor, i)
          31 ->
            _participantEffectiveGroupMeasure =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      ResearchElementDefinition.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        definition =
          ResearchElementDefinition.Characteristic.Definition.from(
            definitionCodeableConcept,
            Canonical.of(definitionCanonical, _definitionCanonical),
            definitionExpression,
            definitionDataRequirement,
          )
            ?: throw SerializationException(
              "Missing required property 'definition' on ResearchElementDefinition.Characteristic"
            ),
        usageContext = usageContext ?: listOf(),
        exclude = R4bBoolean.of(exclude, _exclude),
        unitOfMeasure = unitOfMeasure,
        studyEffectiveDescription =
          R4bString.of(studyEffectiveDescription, _studyEffectiveDescription),
        studyEffective =
          ResearchElementDefinition.Characteristic.StudyEffective.from(
            DateTime.of(
              if (studyEffectiveDateTime != null) FhirDateTime.fromString(studyEffectiveDateTime)
              else null,
              _studyEffectiveDateTime,
            ),
            studyEffectivePeriod,
            studyEffectiveDuration,
            studyEffectiveTiming,
          ),
        studyEffectiveTimeFromStart = studyEffectiveTimeFromStart,
        studyEffectiveGroupMeasure =
          Enumeration.of(
            if (studyEffectiveGroupMeasure != null)
              ResearchElementDefinition.GroupMeasure.fromCode(studyEffectiveGroupMeasure)
            else null,
            _studyEffectiveGroupMeasure,
          ),
        participantEffectiveDescription =
          R4bString.of(participantEffectiveDescription, _participantEffectiveDescription),
        participantEffective =
          ResearchElementDefinition.Characteristic.ParticipantEffective.from(
            DateTime.of(
              if (participantEffectiveDateTime != null)
                FhirDateTime.fromString(participantEffectiveDateTime)
              else null,
              _participantEffectiveDateTime,
            ),
            participantEffectivePeriod,
            participantEffectiveDuration,
            participantEffectiveTiming,
          ),
        participantEffectiveTimeFromStart = participantEffectiveTimeFromStart,
        participantEffectiveGroupMeasure =
          Enumeration.of(
            if (participantEffectiveGroupMeasure != null)
              ResearchElementDefinition.GroupMeasure.fromCode(participantEffectiveGroupMeasure)
            else null,
            _participantEffectiveGroupMeasure,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Characteristic) {
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
      when (val choice = value.definition) {
        is ResearchElementDefinition.Characteristic.Definition.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.Definition.Canonical -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is ResearchElementDefinition.Characteristic.Definition.Expression -> {
          encodeSerializableElement(descriptor, 6, ExpressionSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.Definition.DataRequirement -> {
          encodeSerializableElement(descriptor, 7, DataRequirementSerializer, choice.value)
        }
      }
      if (value.usageContext.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          UsageContextSerializer.listSerializer,
          value.usageContext,
        )
      encodeBooleanIfNotNull(descriptor, 9, value.exclude?.value)
      encodeElementIfNotNull(descriptor, 10, value.exclude)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.unitOfMeasure)
      encodeStringIfNotNull(descriptor, 12, value.studyEffectiveDescription?.value)
      encodeElementIfNotNull(descriptor, 13, value.studyEffectiveDescription)
      when (val choice = value.studyEffective) {
        null -> {}
        is ResearchElementDefinition.Characteristic.StudyEffective.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is ResearchElementDefinition.Characteristic.StudyEffective.Period -> {
          encodeSerializableElement(descriptor, 16, PeriodSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.StudyEffective.Duration -> {
          encodeSerializableElement(descriptor, 17, DurationSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.StudyEffective.Timing -> {
          encodeSerializableElement(descriptor, 18, TimingSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(
        descriptor,
        19,
        DurationSerializer,
        value.studyEffectiveTimeFromStart,
      )
      encodeStringIfNotNull(descriptor, 20, value.studyEffectiveGroupMeasure?.value?.code)
      encodeElementIfNotNull(descriptor, 21, value.studyEffectiveGroupMeasure)
      encodeStringIfNotNull(descriptor, 22, value.participantEffectiveDescription?.value)
      encodeElementIfNotNull(descriptor, 23, value.participantEffectiveDescription)
      when (val choice = value.participantEffective) {
        null -> {}
        is ResearchElementDefinition.Characteristic.ParticipantEffective.DateTime -> {
          encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 25, choice.value)
        }
        is ResearchElementDefinition.Characteristic.ParticipantEffective.Period -> {
          encodeSerializableElement(descriptor, 26, PeriodSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.ParticipantEffective.Duration -> {
          encodeSerializableElement(descriptor, 27, DurationSerializer, choice.value)
        }
        is ResearchElementDefinition.Characteristic.ParticipantEffective.Timing -> {
          encodeSerializableElement(descriptor, 28, TimingSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(
        descriptor,
        29,
        DurationSerializer,
        value.participantEffectiveTimeFromStart,
      )
      encodeStringIfNotNull(descriptor, 30, value.participantEffectiveGroupMeasure?.value?.code)
      encodeElementIfNotNull(descriptor, 31, value.participantEffectiveGroupMeasure)
    }
  }
}

internal object ResearchElementDefinitionSerializer :
  FhirResourceSerializer<ResearchElementDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ResearchElementDefinition")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("shortTitle", KotlinString.serializer().descriptor)
    b.optionalElement("_shortTitle", ElementSerializer.descriptor)
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("comment", stringNullableListSerializer.descriptor)
    b.optionalElement("_comment", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("usage", KotlinString.serializer().descriptor)
    b.optionalElement("_usage", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("library", stringNullableListSerializer.descriptor)
    b.optionalElement("_library", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("variableType", KotlinString.serializer().descriptor)
    b.optionalElement("_variableType", ElementSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      ResearchElementDefinitionCharacteristicSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ResearchElementDefinition {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var shortTitle: KotlinString? = null
    var _shortTitle: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var comment: List<KotlinString?>? = null
    var _comment: List<Element?>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var usage: KotlinString? = null
    var _usage: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var topic: List<CodeableConcept>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var library: List<KotlinString?>? = null
    var _library: List<Element?>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var variableType: KotlinString? = null
    var _variableType: Element? = null
    var characteristic: List<ResearchElementDefinition.Characteristic>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> shortTitle = decoder.decodeStringElement(descriptor, i)
        20 ->
          _shortTitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> subtitle = decoder.decodeStringElement(descriptor, i)
        22 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> status = decoder.decodeStringElement(descriptor, i)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          subjectCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          subjectReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 -> date = decoder.decodeStringElement(descriptor, i)
        30 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> publisher = decoder.decodeStringElement(descriptor, i)
        32 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        34 -> description = decoder.decodeStringElement(descriptor, i)
        35 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          comment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        37 ->
          _comment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        38 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        39 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        40 -> purpose = decoder.decodeStringElement(descriptor, i)
        41 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> usage = decoder.decodeStringElement(descriptor, i)
        43 ->
          _usage = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 -> copyright = decoder.decodeStringElement(descriptor, i)
        45 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        46 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        47 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        48 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        49 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        50 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        51 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        52 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        53 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        54 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        55 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        56 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        57 ->
          library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        58 ->
          _library =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        59 -> type = decoder.decodeStringElement(descriptor, i)
        60 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        61 -> variableType = decoder.decodeStringElement(descriptor, i)
        62 ->
          _variableType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        63 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchElementDefinitionCharacteristicSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding ResearchElementDefinition: " + i)
      }
    }
    return ResearchElementDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      shortTitle = R4bString.of(shortTitle, _shortTitle),
      subtitle = R4bString.of(subtitle, _subtitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ResearchElementDefinition"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      subject = ResearchElementDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      comment =
        (kotlin.collections.List(maxOf(comment?.size ?: 0, _comment?.size ?: 0)) { index ->
          R4bString.of(comment?.getOrNull(index), _comment?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'comment' on ResearchElementDefinition has neither a value nor an id/extension"
            )
        }),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4bString.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      topic = topic ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      library =
        (kotlin.collections.List(maxOf(library?.size ?: 0, _library?.size ?: 0)) { index ->
          Canonical.of(library?.getOrNull(index), _library?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'library' on ResearchElementDefinition has neither a value nor an id/extension"
            )
        }),
      type =
        Enumeration.of(
          if (type != null) ResearchElementDefinition.ResearchElementType.fromCode(type) else null,
          _type,
        )
          ?: throw SerializationException(
            "Missing required property 'type' on ResearchElementDefinition"
          ),
      variableType =
        Enumeration.of(
          if (variableType != null) ResearchElementDefinition.VariableType.fromCode(variableType)
          else null,
          _variableType,
        ),
      characteristic = characteristic ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchElementDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.shortTitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.shortTitle)
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.subtitle)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 25 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is ResearchElementDefinition.Subject.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Subject.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          28 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.description)
    if (value.comment.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        36 + descriptorOffset,
        stringNullableListSerializer,
        value.comment.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 37 + descriptorOffset, value.comment)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 40 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 42 + descriptorOffset, value.usage?.value)
    encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.usage)
    encoder.encodeStringIfNotNull(descriptor, 44 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      46 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      50 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        54 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        55 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    if (value.library.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        57 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 58 + descriptorOffset, value.library)
    }
    encoder.encodeStringIfNotNull(descriptor, 59 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 60 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(
      descriptor,
      61 + descriptorOffset,
      value.variableType?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 62 + descriptorOffset, value.variableType)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        ResearchElementDefinitionCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
  }
}
