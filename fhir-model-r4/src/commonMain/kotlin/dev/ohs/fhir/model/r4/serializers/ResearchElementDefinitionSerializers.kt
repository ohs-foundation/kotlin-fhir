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
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.DataRequirement
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Expression
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.ResearchElementDefinition
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.EvidenceVariableType
import dev.ohs.fhir.model.r4.terminologies.GroupMeasure
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResearchElementType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ResearchElementDefinitionCharacteristicSerializer :
  FhirSerializer<ResearchElementDefinition.Characteristic> {
  override val descriptor: SerialDescriptor = buildDescriptor("Characteristic", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ResearchElementDefinition.Characteristic>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("definitionCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("definitionCanonical")
    b.optionalElement("definitionExpression", ExpressionSerializer.descriptor)
    b.optionalElement("definitionDataRequirement", DataRequirementSerializer.descriptor)
    b.optionalElement("usageContext", UsageContextSerializer.listSerializer.descriptor)
    b.boolPrim("exclude")
    b.optionalElement("unitOfMeasure", CodeableConceptSerializer.descriptor)
    b.strPrim("studyEffectiveDescription")
    b.strPrim("studyEffectiveDateTime")
    b.optionalElement("studyEffectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("studyEffectiveDuration", DurationSerializer.descriptor)
    b.optionalElement("studyEffectiveTiming", TimingSerializer.descriptor)
    b.optionalElement("studyEffectiveTimeFromStart", DurationSerializer.descriptor)
    b.strPrim("studyEffectiveGroupMeasure")
    b.strPrim("participantEffectiveDescription")
    b.strPrim("participantEffectiveDateTime")
    b.optionalElement("participantEffectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("participantEffectiveDuration", DurationSerializer.descriptor)
    b.optionalElement("participantEffectiveTiming", TimingSerializer.descriptor)
    b.optionalElement("participantEffectiveTimeFromStart", DurationSerializer.descriptor)
    b.strPrim("participantEffectiveGroupMeasure")
  }

  override fun deserialize(decoder: Decoder): ResearchElementDefinition.Characteristic {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var studyEffectiveDateTime: FhirDateTime? = null
    var _studyEffectiveDateTime: Element? = null
    var studyEffectivePeriod: Period? = null
    var studyEffectiveDuration: Duration? = null
    var studyEffectiveTiming: Timing? = null
    var studyEffectiveTimeFromStart: Duration? = null
    var studyEffectiveGroupMeasure: GroupMeasure? = null
    var _studyEffectiveGroupMeasure: Element? = null
    var participantEffectiveDescription: KotlinString? = null
    var _participantEffectiveDescription: Element? = null
    var participantEffectiveDateTime: FhirDateTime? = null
    var _participantEffectiveDateTime: Element? = null
    var participantEffectivePeriod: Period? = null
    var participantEffectiveDuration: Duration? = null
    var participantEffectiveTiming: Timing? = null
    var participantEffectiveTimeFromStart: Duration? = null
    var participantEffectiveGroupMeasure: GroupMeasure? = null
    var _participantEffectiveGroupMeasure: Element? = null
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
          definitionCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> definitionCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _definitionCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          definitionExpression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExpressionSerializer,
              null,
            )
        7 ->
          definitionDataRequirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DataRequirementSerializer,
              null,
            )
        8 ->
          usageContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        9 -> exclude = compositeDecoder.decodeBooleanElement(descriptor, i)
        10 ->
          _exclude =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          unitOfMeasure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> studyEffectiveDescription = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _studyEffectiveDescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          studyEffectiveDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        15 ->
          _studyEffectiveDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          studyEffectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        17 ->
          studyEffectiveDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        18 ->
          studyEffectiveTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        19 ->
          studyEffectiveTimeFromStart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        20 ->
          studyEffectiveGroupMeasure =
            GroupMeasure.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _studyEffectiveGroupMeasure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> participantEffectiveDescription = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _participantEffectiveDescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          participantEffectiveDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _participantEffectiveDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          participantEffectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        27 ->
          participantEffectiveDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        28 ->
          participantEffectiveTiming =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TimingSerializer,
              null,
            )
        29 ->
          participantEffectiveTimeFromStart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        30 ->
          participantEffectiveGroupMeasure =
            GroupMeasure.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        31 ->
          _participantEffectiveGroupMeasure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ResearchElementDefinition.Characteristic(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      definition =
        required(
          ResearchElementDefinition.Characteristic.Definition.from(
            definitionCodeableConcept,
            Canonical.of(definitionCanonical, _definitionCanonical),
            definitionExpression,
            definitionDataRequirement,
          ),
          "ResearchElementDefinition.Characteristic",
          "definition",
        ),
      usageContext = listOrEmpty(usageContext),
      exclude = R4Boolean.of(exclude, _exclude),
      unitOfMeasure = unitOfMeasure,
      studyEffectiveDescription =
        R4String.of(studyEffectiveDescription, _studyEffectiveDescription),
      studyEffective =
        ResearchElementDefinition.Characteristic.StudyEffective.from(
          DateTime.of(studyEffectiveDateTime, _studyEffectiveDateTime),
          studyEffectivePeriod,
          studyEffectiveDuration,
          studyEffectiveTiming,
        ),
      studyEffectiveTimeFromStart = studyEffectiveTimeFromStart,
      studyEffectiveGroupMeasure =
        Enumeration.of(studyEffectiveGroupMeasure, _studyEffectiveGroupMeasure),
      participantEffectiveDescription =
        R4String.of(participantEffectiveDescription, _participantEffectiveDescription),
      participantEffective =
        ResearchElementDefinition.Characteristic.ParticipantEffective.from(
          DateTime.of(participantEffectiveDateTime, _participantEffectiveDateTime),
          participantEffectivePeriod,
          participantEffectiveDuration,
          participantEffectiveTiming,
        ),
      participantEffectiveTimeFromStart = participantEffectiveTimeFromStart,
      participantEffectiveGroupMeasure =
        Enumeration.of(participantEffectiveGroupMeasure, _participantEffectiveGroupMeasure),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ResearchElementDefinition.Characteristic) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.definition) {
      is ResearchElementDefinition.Characteristic.Definition.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.Definition.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is ResearchElementDefinition.Characteristic.Definition.Expression -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          ExpressionSerializer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Characteristic.Definition.DataRequirement -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          7,
          DataRequirementSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      UsageContextSerializer.listSerializer,
      value.usageContext,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 9, value.exclude?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.exclude)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.unitOfMeasure,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.studyEffectiveDescription?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.studyEffectiveDescription)
    when (val choice = value.studyEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.StudyEffective.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 15, choice.value)
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 16, PeriodSerializer, choice.value)
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 17, DurationSerializer, choice.value)
      }
      is ResearchElementDefinition.Characteristic.StudyEffective.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 18, TimingSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19,
      DurationSerializer,
      value.studyEffectiveTimeFromStart,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20,
      value.studyEffectiveGroupMeasure?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.studyEffectiveGroupMeasure)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22,
      value.participantEffectiveDescription?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.participantEffectiveDescription)
    when (val choice = value.participantEffective) {
      null -> {}
      is ResearchElementDefinition.Characteristic.ParticipantEffective.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 24, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 25, choice.value)
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 26, PeriodSerializer, choice.value)
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 27, DurationSerializer, choice.value)
      }
      is ResearchElementDefinition.Characteristic.ParticipantEffective.Timing -> {
        compositeEncoder.encodeSerializableElement(descriptor, 28, TimingSerializer, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29,
      DurationSerializer,
      value.participantEffectiveTimeFromStart,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30,
      value.participantEffectiveGroupMeasure?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31, value.participantEffectiveGroupMeasure)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ResearchElementDefinitionSerializer :
  FhirResourceSerializer<ResearchElementDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ResearchElementDefinition")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("url")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("name")
    b.strPrim("title")
    b.strPrim("shortTitle")
    b.strPrim("subtitle")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.optionalElement("subjectCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("subjectReference", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.strPrimList("comment")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("usage")
    b.strPrim("copyright")
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("topic", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.strPrimList("library")
    b.strPrim("type")
    b.strPrim("variableType")
    b.optionalElement(
      "characteristic",
      ResearchElementDefinitionCharacteristicSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectCodeableConcept: CodeableConcept? = null
    var subjectReference: Reference? = null
    var date: FhirDateTime? = null
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
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
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
    var type: ResearchElementType? = null
    var _type: Element? = null
    var variableType: EvidenceVariableType? = null
    var _variableType: Element? = null
    var characteristic: List<ResearchElementDefinition.Characteristic>? = null
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
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> shortTitle = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _shortTitle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> subtitle = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _subtitle =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        26 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          subjectCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          subjectReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        30 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        34 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        37 ->
          _comment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        38 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        39 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        40 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        41 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> usage = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _usage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        45 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        46 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        47 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        49 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        50 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        51 ->
          topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        52 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        53 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        54 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        55 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        56 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        57 ->
          library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        58 ->
          _library =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        59 ->
          type = ResearchElementType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        60 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        61 ->
          variableType =
            EvidenceVariableType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        62 ->
          _variableType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        63 ->
          characteristic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResearchElementDefinitionCharacteristicSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val comment_ =
      List(maxSize(comment, _comment)) { index ->
        entryRequired(
          R4String.of(at(comment, index), at(_comment, index)),
          "ResearchElementDefinition",
          "comment",
        )
      }
    val library_ =
      List(maxSize(library, _library)) { index ->
        entryRequired(
          Canonical.of(at(library, index), at(_library, index)),
          "ResearchElementDefinition",
          "library",
        )
      }
    return ResearchElementDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      shortTitle = R4String.of(shortTitle, _shortTitle),
      subtitle = R4String.of(subtitle, _subtitle),
      status = required(Enumeration.of(status, _status), "ResearchElementDefinition", "status"),
      experimental = R4Boolean.of(experimental, _experimental),
      subject = ResearchElementDefinition.Subject.from(subjectCodeableConcept, subjectReference),
      date = DateTime.of(date, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      comment = comment_,
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      usage = R4String.of(usage, _usage),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      topic = listOrEmpty(topic),
      author = listOrEmpty(author),
      editor = listOrEmpty(editor),
      reviewer = listOrEmpty(reviewer),
      endorser = listOrEmpty(endorser),
      relatedArtifact = listOrEmpty(relatedArtifact),
      library = library_,
      type = required(Enumeration.of(type, _type), "ResearchElementDefinition", "type"),
      variableType = Enumeration.of(variableType, _variableType),
      characteristic = listOrEmpty(characteristic),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ResearchElementDefinition,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.shortTitle?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.shortTitle)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.subtitle?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.subtitle)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.experimental)
    when (val choice = value.subject) {
      null -> {}
      is ResearchElementDefinition.Subject.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          27 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ResearchElementDefinition.Subject.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          28 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.description)
    if (!value.comment.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        36 + descriptorOffset,
        stringNullableListSerializer,
        value.comment.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 37 + descriptorOffset, value.comment)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      38 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 40 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(descriptor, 42 + descriptorOffset, value.usage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, value.usage)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      44 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 45 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      46 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      48 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      50 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.topic,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.author,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.editor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      54 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.reviewer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      55 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.endorser,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      56 + descriptorOffset,
      RelatedArtifactSerializer.listSerializer,
      value.relatedArtifact,
    )
    if (!value.library.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        57 + descriptorOffset,
        stringNullableListSerializer,
        value.library.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 58 + descriptorOffset, value.library)
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      59 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 60 + descriptorOffset, value.type)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      61 + descriptorOffset,
      value.variableType?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 62 + descriptorOffset, value.variableType)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      63 + descriptorOffset,
      ResearchElementDefinitionCharacteristicSerializer.listSerializer,
      value.characteristic,
    )
  }
}
