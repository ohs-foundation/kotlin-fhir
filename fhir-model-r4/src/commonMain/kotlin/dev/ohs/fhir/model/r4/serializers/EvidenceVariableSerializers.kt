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

import dev.ohs.fhir.model.r4.Annotation
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
import dev.ohs.fhir.model.r4.EvidenceVariable
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
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Timing
import dev.ohs.fhir.model.r4.TriggerDefinition
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
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

internal object EvidenceVariableCharacteristicSerializer :
  KSerializer<EvidenceVariable.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("definitionReference", ReferenceSerializer.descriptor)
      optionalElement("definitionCanonical", KotlinString.serializer().descriptor)
      optionalElement("_definitionCanonical", ElementSerializer.descriptor)
      optionalElement("definitionCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("definitionExpression", ExpressionSerializer.descriptor)
      optionalElement("definitionDataRequirement", DataRequirementSerializer.descriptor)
      optionalElement("definitionTriggerDefinition", TriggerDefinitionSerializer.descriptor)
      optionalElement("usageContext", UsageContextSerializer.listSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement("participantEffectiveDateTime", KotlinString.serializer().descriptor)
      optionalElement("_participantEffectiveDateTime", ElementSerializer.descriptor)
      optionalElement("participantEffectivePeriod", PeriodSerializer.descriptor)
      optionalElement("participantEffectiveDuration", DurationSerializer.descriptor)
      optionalElement("participantEffectiveTiming", TimingSerializer.descriptor)
      optionalElement("timeFromStart", DurationSerializer.descriptor)
      optionalElement("groupMeasure", KotlinString.serializer().descriptor)
      optionalElement("_groupMeasure", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceVariable.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceVariable.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var definitionReference: Reference? = null
      var definitionCanonical: KotlinString? = null
      var _definitionCanonical: Element? = null
      var definitionCodeableConcept: CodeableConcept? = null
      var definitionExpression: Expression? = null
      var definitionDataRequirement: DataRequirement? = null
      var definitionTriggerDefinition: TriggerDefinition? = null
      var usageContext: List<UsageContext>? = null
      var exclude: KotlinBoolean? = null
      var _exclude: Element? = null
      var participantEffectiveDateTime: KotlinString? = null
      var _participantEffectiveDateTime: Element? = null
      var participantEffectivePeriod: Period? = null
      var participantEffectiveDuration: Duration? = null
      var participantEffectiveTiming: Timing? = null
      var timeFromStart: Duration? = null
      var groupMeasure: KotlinString? = null
      var _groupMeasure: Element? = null
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
          5 ->
            definitionReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> definitionCanonical = decodeStringElement(descriptor, i)
          7 ->
            _definitionCanonical =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            definitionCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            definitionExpression =
              decodeNullableSerializableElement(descriptor, i, ExpressionSerializer, null)
          10 ->
            definitionDataRequirement =
              decodeNullableSerializableElement(descriptor, i, DataRequirementSerializer, null)
          11 ->
            definitionTriggerDefinition =
              decodeNullableSerializableElement(descriptor, i, TriggerDefinitionSerializer, null)
          12 ->
            usageContext =
              decodeNullableSerializableElement(
                descriptor,
                i,
                UsageContextSerializer.listSerializer,
                null,
              )
          13 -> exclude = decodeBooleanElement(descriptor, i)
          14 -> _exclude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> participantEffectiveDateTime = decodeStringElement(descriptor, i)
          16 ->
            _participantEffectiveDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            participantEffectivePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          18 ->
            participantEffectiveDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          19 ->
            participantEffectiveTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          20 ->
            timeFromStart =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          21 -> groupMeasure = decodeStringElement(descriptor, i)
          22 ->
            _groupMeasure =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      EvidenceVariable.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4String.of(description, _description),
        definition =
          EvidenceVariable.Characteristic.Definition.from(
            definitionReference,
            Canonical.of(definitionCanonical, _definitionCanonical),
            definitionCodeableConcept,
            definitionExpression,
            definitionDataRequirement,
            definitionTriggerDefinition,
          )
            ?: throw SerializationException(
              "Missing required property 'definition' on EvidenceVariable.Characteristic"
            ),
        usageContext = usageContext ?: listOf(),
        exclude = R4Boolean.of(exclude, _exclude),
        participantEffective =
          EvidenceVariable.Characteristic.ParticipantEffective.from(
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
        timeFromStart = timeFromStart,
        groupMeasure =
          Enumeration.of(
            if (groupMeasure != null) EvidenceVariable.GroupMeasure.fromCode(groupMeasure)
            else null,
            _groupMeasure,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceVariable.Characteristic) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      when (val choice = value.definition) {
        is EvidenceVariable.Characteristic.Definition.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.Canonical -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.Expression -> {
          encodeSerializableElement(descriptor, 9, ExpressionSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.DataRequirement -> {
          encodeSerializableElement(descriptor, 10, DataRequirementSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.Definition.TriggerDefinition -> {
          encodeSerializableElement(descriptor, 11, TriggerDefinitionSerializer, choice.value)
        }
      }
      if (value.usageContext.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          UsageContextSerializer.listSerializer,
          value.usageContext,
        )
      encodeBooleanIfNotNull(descriptor, 13, value.exclude?.value)
      encodeElementIfNotNull(descriptor, 14, value.exclude)
      when (val choice = value.participantEffective) {
        null -> {}
        is EvidenceVariable.Characteristic.ParticipantEffective.DateTime -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is EvidenceVariable.Characteristic.ParticipantEffective.Period -> {
          encodeSerializableElement(descriptor, 17, PeriodSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.ParticipantEffective.Duration -> {
          encodeSerializableElement(descriptor, 18, DurationSerializer, choice.value)
        }
        is EvidenceVariable.Characteristic.ParticipantEffective.Timing -> {
          encodeSerializableElement(descriptor, 19, TimingSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 20, DurationSerializer, value.timeFromStart)
      encodeStringIfNotNull(descriptor, 21, value.groupMeasure?.value?.code)
      encodeElementIfNotNull(descriptor, 22, value.groupMeasure)
    }
  }
}

internal object EvidenceVariableSerializer : FhirResourceSerializer<EvidenceVariable> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("EvidenceVariable")

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
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
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
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement(
      "characteristic",
      EvidenceVariableCharacteristicSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EvidenceVariable {
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
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var note: List<Annotation>? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
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
    var type: KotlinString? = null
    var _type: Element? = null
    var characteristic: List<EvidenceVariable.Characteristic>? = null
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
        25 -> date = decoder.decodeStringElement(descriptor, i)
        26 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> publisher = decoder.decodeStringElement(descriptor, i)
        28 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        30 -> description = decoder.decodeStringElement(descriptor, i)
        31 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        33 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> copyright = decoder.decodeStringElement(descriptor, i)
        36 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        38 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        40 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        42 ->
          topic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        43 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        44 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        45 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        46 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        47 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        48 -> type = decoder.decodeStringElement(descriptor, i)
        49 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        50 ->
          characteristic =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceVariableCharacteristicSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding EvidenceVariable: " + i)
      }
    }
    return EvidenceVariable(
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      shortTitle = R4String.of(shortTitle, _shortTitle),
      subtitle = R4String.of(subtitle, _subtitle),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on EvidenceVariable"),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      note = note ?: listOf(),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
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
      type =
        Enumeration.of(
          if (type != null) EvidenceVariable.EvidenceVariableType.fromCode(type) else null,
          _type,
        ),
      characteristic = characteristic ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EvidenceVariable,
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
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.description)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.topic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.topic,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeStringIfNotNull(descriptor, 48 + descriptorOffset, value.type?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 49 + descriptorOffset, value.type)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        EvidenceVariableCharacteristicSerializer.listSerializer,
        value.characteristic,
      )
  }
}
