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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Citation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
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

internal object CitationSummarySerializer : KSerializer<Citation.Summary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Summary") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("style", CodeableConceptSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.Summary>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.Summary =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var style: CodeableConcept? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
            style =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> text = decodeStringElement(descriptor, i)
          5 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Summary: " + i)
        }
      }
      Citation.Summary(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        style = style,
        text =
          Markdown.of(text, _text)
            ?: throw SerializationException("Missing required property 'text' on Citation.Summary"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.Summary) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.style)
      encodeStringIfNotNull(descriptor, 4, value.text.value)
      encodeElementIfNotNull(descriptor, 5, value.text)
    }
  }
}

internal object CitationClassificationSerializer : KSerializer<Citation.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.Classification>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.Classification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var classifier: List<CodeableConcept>? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            classifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Classification: " + i)
        }
      }
      Citation.Classification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        classifier = classifier ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.Classification) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.classifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.classifier,
        )
    }
  }
}

internal object CitationStatusDateSerializer : KSerializer<Citation.StatusDate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusDate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("activity", CodeableConceptSerializer.descriptor)
      optionalElement("actual", KotlinBoolean.serializer().descriptor)
      optionalElement("_actual", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.StatusDate>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.StatusDate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var activity: CodeableConcept? = null
      var `actual`: KotlinBoolean? = null
      var _actual: Element? = null
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
            activity =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `actual` = decodeBooleanElement(descriptor, i)
          5 -> _actual = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StatusDate: " + i)
        }
      }
      Citation.StatusDate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        activity =
          activity
            ?: throw SerializationException(
              "Missing required property 'activity' on Citation.StatusDate"
            ),
        `actual` = R4bBoolean.of(`actual`, _actual),
        period =
          period
            ?: throw SerializationException(
              "Missing required property 'period' on Citation.StatusDate"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.StatusDate) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.activity)
      encodeBooleanIfNotNull(descriptor, 4, value.`actual`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`actual`)
      encodeSerializableElement(descriptor, 6, PeriodSerializer, value.period)
    }
  }
}

internal object CitationRelatesToSerializer : KSerializer<Citation.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
      optionalElement("targetClassifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("targetUri", KotlinString.serializer().descriptor)
      optionalElement("_targetUri", ElementSerializer.descriptor)
      optionalElement("targetIdentifier", IdentifierSerializer.descriptor)
      optionalElement("targetReference", ReferenceSerializer.descriptor)
      optionalElement("targetAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.RelatesTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.RelatesTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var relationshipType: CodeableConcept? = null
      var targetClassifier: List<CodeableConcept>? = null
      var targetUri: KotlinString? = null
      var _targetUri: Element? = null
      var targetIdentifier: Identifier? = null
      var targetReference: Reference? = null
      var targetAttachment: Attachment? = null
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
            relationshipType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            targetClassifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> targetUri = decodeStringElement(descriptor, i)
          6 ->
            _targetUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            targetIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          8 ->
            targetReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            targetAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
        }
      }
      Citation.RelatesTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        relationshipType =
          relationshipType
            ?: throw SerializationException(
              "Missing required property 'relationshipType' on Citation.RelatesTo"
            ),
        targetClassifier = targetClassifier ?: listOf(),
        target =
          Citation.RelatesTo.Target.from(
            Uri.of(targetUri, _targetUri),
            targetIdentifier,
            targetReference,
            targetAttachment,
          )
            ?: throw SerializationException(
              "Missing required property 'target' on Citation.RelatesTo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.RelatesTo) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.relationshipType)
      if (value.targetClassifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.targetClassifier,
        )
      when (val choice = value.target) {
        is Citation.RelatesTo.Target.Uri -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Citation.RelatesTo.Target.Identifier -> {
          encodeSerializableElement(descriptor, 7, IdentifierSerializer, choice.value)
        }
        is Citation.RelatesTo.Target.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
        is Citation.RelatesTo.Target.Attachment -> {
          encodeSerializableElement(descriptor, 9, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object CitationCitedArtifactSerializer : KSerializer<Citation.CitedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CitedArtifact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("relatedIdentifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("dateAccessed", KotlinString.serializer().descriptor)
      optionalElement("_dateAccessed", ElementSerializer.descriptor)
      optionalElement("version", CitationCitedArtifactVersionSerializer.descriptor)
      optionalElement("currentState", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "statusDate",
        CitationCitedArtifactStatusDateSerializer.listSerializer.descriptor,
      )
      optionalElement("title", CitationCitedArtifactTitleSerializer.listSerializer.descriptor)
      optionalElement("abstract", CitationCitedArtifactAbstractSerializer.listSerializer.descriptor)
      optionalElement("part", CitationCitedArtifactPartSerializer.descriptor)
      optionalElement(
        "relatesTo",
        CitationCitedArtifactRelatesToSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "publicationForm",
        CitationCitedArtifactPublicationFormSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "webLocation",
        CitationCitedArtifactWebLocationSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "classification",
        CitationCitedArtifactClassificationSerializer.listSerializer.descriptor,
      )
      optionalElement("contributorship", CitationCitedArtifactContributorshipSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var relatedIdentifier: List<Identifier>? = null
      var dateAccessed: KotlinString? = null
      var _dateAccessed: Element? = null
      var version: Citation.CitedArtifact.Version? = null
      var currentState: List<CodeableConcept>? = null
      var statusDate: List<Citation.CitedArtifact.StatusDate>? = null
      var title: List<Citation.CitedArtifact.Title>? = null
      var `abstract`: List<Citation.CitedArtifact.Abstract>? = null
      var part: Citation.CitedArtifact.Part? = null
      var relatesTo: List<Citation.CitedArtifact.RelatesTo>? = null
      var publicationForm: List<Citation.CitedArtifact.PublicationForm>? = null
      var webLocation: List<Citation.CitedArtifact.WebLocation>? = null
      var classification: List<Citation.CitedArtifact.Classification>? = null
      var contributorship: Citation.CitedArtifact.Contributorship? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            relatedIdentifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          5 -> dateAccessed = decodeStringElement(descriptor, i)
          6 ->
            _dateAccessed =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            version =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactVersionSerializer,
                null,
              )
          8 ->
            currentState =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            statusDate =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactStatusDateSerializer.listSerializer,
                null,
              )
          10 ->
            title =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactTitleSerializer.listSerializer,
                null,
              )
          11 ->
            `abstract` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactAbstractSerializer.listSerializer,
                null,
              )
          12 ->
            part =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactPartSerializer,
                null,
              )
          13 ->
            relatesTo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactRelatesToSerializer.listSerializer,
                null,
              )
          14 ->
            publicationForm =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactPublicationFormSerializer.listSerializer,
                null,
              )
          15 ->
            webLocation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactWebLocationSerializer.listSerializer,
                null,
              )
          16 ->
            classification =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactClassificationSerializer.listSerializer,
                null,
              )
          17 ->
            contributorship =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactContributorshipSerializer,
                null,
              )
          18 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CitedArtifact: " + i)
        }
      }
      Citation.CitedArtifact(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        relatedIdentifier = relatedIdentifier ?: listOf(),
        dateAccessed =
          DateTime.of(
            if (dateAccessed != null) FhirDateTime.fromString(dateAccessed) else null,
            _dateAccessed,
          ),
        version = version,
        currentState = currentState ?: listOf(),
        statusDate = statusDate ?: listOf(),
        title = title ?: listOf(),
        `abstract` = `abstract` ?: listOf(),
        part = part,
        relatesTo = relatesTo ?: listOf(),
        publicationForm = publicationForm ?: listOf(),
        webLocation = webLocation ?: listOf(),
        classification = classification ?: listOf(),
        contributorship = contributorship,
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      if (value.relatedIdentifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          IdentifierSerializer.listSerializer,
          value.relatedIdentifier,
        )
      encodeStringIfNotNull(descriptor, 5, value.dateAccessed?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.dateAccessed)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        CitationCitedArtifactVersionSerializer,
        value.version,
      )
      if (value.currentState.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.currentState,
        )
      if (value.statusDate.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CitationCitedArtifactStatusDateSerializer.listSerializer,
          value.statusDate,
        )
      if (value.title.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CitationCitedArtifactTitleSerializer.listSerializer,
          value.title,
        )
      if (value.`abstract`.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CitationCitedArtifactAbstractSerializer.listSerializer,
          value.`abstract`,
        )
      encodeSerializableIfNotNull(descriptor, 12, CitationCitedArtifactPartSerializer, value.part)
      if (value.relatesTo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          CitationCitedArtifactRelatesToSerializer.listSerializer,
          value.relatesTo,
        )
      if (value.publicationForm.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          CitationCitedArtifactPublicationFormSerializer.listSerializer,
          value.publicationForm,
        )
      if (value.webLocation.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          CitationCitedArtifactWebLocationSerializer.listSerializer,
          value.webLocation,
        )
      if (value.classification.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CitationCitedArtifactClassificationSerializer.listSerializer,
          value.classification,
        )
      encodeSerializableIfNotNull(
        descriptor,
        17,
        CitationCitedArtifactContributorshipSerializer,
        value.contributorship,
      )
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 18, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object CitationCitedArtifactVersionSerializer :
  KSerializer<Citation.CitedArtifact.Version> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Version") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("baseCitation", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Version>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Version =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
      var baseCitation: Reference? = null
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
          3 -> `value` = decodeStringElement(descriptor, i)
          4 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            baseCitation =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Version: " + i)
        }
      }
      Citation.CitedArtifact.Version(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          R4bString.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on Citation.CitedArtifact.Version"
            ),
        baseCitation = baseCitation,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Version) {
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
      encodeStringIfNotNull(descriptor, 3, value.`value`.value)
      encodeElementIfNotNull(descriptor, 4, value.`value`)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.baseCitation)
    }
  }
}

internal object CitationCitedArtifactStatusDateSerializer :
  KSerializer<Citation.CitedArtifact.StatusDate> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StatusDate") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("activity", CodeableConceptSerializer.descriptor)
      optionalElement("actual", KotlinBoolean.serializer().descriptor)
      optionalElement("_actual", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.StatusDate>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.StatusDate =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var activity: CodeableConcept? = null
      var `actual`: KotlinBoolean? = null
      var _actual: Element? = null
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
            activity =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `actual` = decodeBooleanElement(descriptor, i)
          5 -> _actual = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StatusDate: " + i)
        }
      }
      Citation.CitedArtifact.StatusDate(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        activity =
          activity
            ?: throw SerializationException(
              "Missing required property 'activity' on Citation.CitedArtifact.StatusDate"
            ),
        `actual` = R4bBoolean.of(`actual`, _actual),
        period =
          period
            ?: throw SerializationException(
              "Missing required property 'period' on Citation.CitedArtifact.StatusDate"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.StatusDate) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.activity)
      encodeBooleanIfNotNull(descriptor, 4, value.`actual`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`actual`)
      encodeSerializableElement(descriptor, 6, PeriodSerializer, value.period)
    }
  }
}

internal object CitationCitedArtifactTitleSerializer : KSerializer<Citation.CitedArtifact.Title> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Title") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Title>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Title =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: List<CodeableConcept>? = null
      var language: CodeableConcept? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
          4 ->
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Title: " + i)
        }
      }
      Citation.CitedArtifact.Title(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type ?: listOf(),
        language = language,
        text =
          Markdown.of(text, _text)
            ?: throw SerializationException(
              "Missing required property 'text' on Citation.CitedArtifact.Title"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Title) {
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.language)
      encodeStringIfNotNull(descriptor, 5, value.text.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
    }
  }
}

internal object CitationCitedArtifactAbstractSerializer :
  KSerializer<Citation.CitedArtifact.Abstract> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Abstract") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("copyright", KotlinString.serializer().descriptor)
      optionalElement("_copyright", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Abstract>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Abstract =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var language: CodeableConcept? = null
      var text: KotlinString? = null
      var _text: Element? = null
      var copyright: KotlinString? = null
      var _copyright: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> copyright = decodeStringElement(descriptor, i)
          8 ->
            _copyright = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Abstract: " + i)
        }
      }
      Citation.CitedArtifact.Abstract(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        language = language,
        text =
          Markdown.of(text, _text)
            ?: throw SerializationException(
              "Missing required property 'text' on Citation.CitedArtifact.Abstract"
            ),
        copyright = Markdown.of(copyright, _copyright),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Abstract) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.language)
      encodeStringIfNotNull(descriptor, 5, value.text.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
      encodeStringIfNotNull(descriptor, 7, value.copyright?.value)
      encodeElementIfNotNull(descriptor, 8, value.copyright)
    }
  }
}

internal object CitationCitedArtifactPartSerializer : KSerializer<Citation.CitedArtifact.Part> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Part") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("baseCitation", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Part>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Part =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
      var baseCitation: Reference? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `value` = decodeStringElement(descriptor, i)
          5 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            baseCitation =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Part: " + i)
        }
      }
      Citation.CitedArtifact.Part(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        `value` = R4bString.of(`value`, _value),
        baseCitation = baseCitation,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Part) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.`value`?.value)
      encodeElementIfNotNull(descriptor, 5, value.`value`)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.baseCitation)
    }
  }
}

internal object CitationCitedArtifactRelatesToSerializer :
  KSerializer<Citation.CitedArtifact.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
      optionalElement("targetClassifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("targetUri", KotlinString.serializer().descriptor)
      optionalElement("_targetUri", ElementSerializer.descriptor)
      optionalElement("targetIdentifier", IdentifierSerializer.descriptor)
      optionalElement("targetReference", ReferenceSerializer.descriptor)
      optionalElement("targetAttachment", AttachmentSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.RelatesTo>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var relationshipType: CodeableConcept? = null
      var targetClassifier: List<CodeableConcept>? = null
      var targetUri: KotlinString? = null
      var _targetUri: Element? = null
      var targetIdentifier: Identifier? = null
      var targetReference: Reference? = null
      var targetAttachment: Attachment? = null
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
            relationshipType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            targetClassifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> targetUri = decodeStringElement(descriptor, i)
          6 ->
            _targetUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            targetIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          8 ->
            targetReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            targetAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
        }
      }
      Citation.CitedArtifact.RelatesTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        relationshipType =
          relationshipType
            ?: throw SerializationException(
              "Missing required property 'relationshipType' on Citation.CitedArtifact.RelatesTo"
            ),
        targetClassifier = targetClassifier ?: listOf(),
        target =
          Citation.CitedArtifact.RelatesTo.Target.from(
            Uri.of(targetUri, _targetUri),
            targetIdentifier,
            targetReference,
            targetAttachment,
          )
            ?: throw SerializationException(
              "Missing required property 'target' on Citation.CitedArtifact.RelatesTo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.relationshipType)
      if (value.targetClassifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.targetClassifier,
        )
      when (val choice = value.target) {
        is Citation.CitedArtifact.RelatesTo.Target.Uri -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Citation.CitedArtifact.RelatesTo.Target.Identifier -> {
          encodeSerializableElement(descriptor, 7, IdentifierSerializer, choice.value)
        }
        is Citation.CitedArtifact.RelatesTo.Target.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
        is Citation.CitedArtifact.RelatesTo.Target.Attachment -> {
          encodeSerializableElement(descriptor, 9, AttachmentSerializer, choice.value)
        }
      }
    }
  }
}

internal object CitationCitedArtifactPublicationFormSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PublicationForm") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "publishedIn",
        CitationCitedArtifactPublicationFormPublishedInSerializer.descriptor,
      )
      optionalElement(
        "periodicRelease",
        CitationCitedArtifactPublicationFormPeriodicReleaseSerializer.descriptor,
      )
      optionalElement("articleDate", KotlinString.serializer().descriptor)
      optionalElement("_articleDate", ElementSerializer.descriptor)
      optionalElement("lastRevisionDate", KotlinString.serializer().descriptor)
      optionalElement("_lastRevisionDate", ElementSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("accessionNumber", KotlinString.serializer().descriptor)
      optionalElement("_accessionNumber", ElementSerializer.descriptor)
      optionalElement("pageString", KotlinString.serializer().descriptor)
      optionalElement("_pageString", ElementSerializer.descriptor)
      optionalElement("firstPage", KotlinString.serializer().descriptor)
      optionalElement("_firstPage", ElementSerializer.descriptor)
      optionalElement("lastPage", KotlinString.serializer().descriptor)
      optionalElement("_lastPage", ElementSerializer.descriptor)
      optionalElement("pageCount", KotlinString.serializer().descriptor)
      optionalElement("_pageCount", ElementSerializer.descriptor)
      optionalElement("copyright", KotlinString.serializer().descriptor)
      optionalElement("_copyright", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.PublicationForm>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var publishedIn: Citation.CitedArtifact.PublicationForm.PublishedIn? = null
      var periodicRelease: Citation.CitedArtifact.PublicationForm.PeriodicRelease? = null
      var articleDate: KotlinString? = null
      var _articleDate: Element? = null
      var lastRevisionDate: KotlinString? = null
      var _lastRevisionDate: Element? = null
      var language: List<CodeableConcept>? = null
      var accessionNumber: KotlinString? = null
      var _accessionNumber: Element? = null
      var pageString: KotlinString? = null
      var _pageString: Element? = null
      var firstPage: KotlinString? = null
      var _firstPage: Element? = null
      var lastPage: KotlinString? = null
      var _lastPage: Element? = null
      var pageCount: KotlinString? = null
      var _pageCount: Element? = null
      var copyright: KotlinString? = null
      var _copyright: Element? = null
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
            publishedIn =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactPublicationFormPublishedInSerializer,
                null,
              )
          4 ->
            periodicRelease =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactPublicationFormPeriodicReleaseSerializer,
                null,
              )
          5 -> articleDate = decodeStringElement(descriptor, i)
          6 ->
            _articleDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> lastRevisionDate = decodeStringElement(descriptor, i)
          8 ->
            _lastRevisionDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            language =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          10 -> accessionNumber = decodeStringElement(descriptor, i)
          11 ->
            _accessionNumber =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> pageString = decodeStringElement(descriptor, i)
          13 ->
            _pageString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> firstPage = decodeStringElement(descriptor, i)
          15 ->
            _firstPage = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> lastPage = decodeStringElement(descriptor, i)
          17 ->
            _lastPage = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 -> pageCount = decodeStringElement(descriptor, i)
          19 ->
            _pageCount = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> copyright = decodeStringElement(descriptor, i)
          21 ->
            _copyright = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PublicationForm: " + i)
        }
      }
      Citation.CitedArtifact.PublicationForm(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        publishedIn = publishedIn,
        periodicRelease = periodicRelease,
        articleDate =
          DateTime.of(
            if (articleDate != null) FhirDateTime.fromString(articleDate) else null,
            _articleDate,
          ),
        lastRevisionDate =
          DateTime.of(
            if (lastRevisionDate != null) FhirDateTime.fromString(lastRevisionDate) else null,
            _lastRevisionDate,
          ),
        language = language ?: listOf(),
        accessionNumber = R4bString.of(accessionNumber, _accessionNumber),
        pageString = R4bString.of(pageString, _pageString),
        firstPage = R4bString.of(firstPage, _firstPage),
        lastPage = R4bString.of(lastPage, _lastPage),
        pageCount = R4bString.of(pageCount, _pageCount),
        copyright = Markdown.of(copyright, _copyright),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.PublicationForm) {
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
      encodeSerializableIfNotNull(
        descriptor,
        3,
        CitationCitedArtifactPublicationFormPublishedInSerializer,
        value.publishedIn,
      )
      encodeSerializableIfNotNull(
        descriptor,
        4,
        CitationCitedArtifactPublicationFormPeriodicReleaseSerializer,
        value.periodicRelease,
      )
      encodeStringIfNotNull(descriptor, 5, value.articleDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.articleDate)
      encodeStringIfNotNull(descriptor, 7, value.lastRevisionDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 8, value.lastRevisionDate)
      if (value.language.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.language,
        )
      encodeStringIfNotNull(descriptor, 10, value.accessionNumber?.value)
      encodeElementIfNotNull(descriptor, 11, value.accessionNumber)
      encodeStringIfNotNull(descriptor, 12, value.pageString?.value)
      encodeElementIfNotNull(descriptor, 13, value.pageString)
      encodeStringIfNotNull(descriptor, 14, value.firstPage?.value)
      encodeElementIfNotNull(descriptor, 15, value.firstPage)
      encodeStringIfNotNull(descriptor, 16, value.lastPage?.value)
      encodeElementIfNotNull(descriptor, 17, value.lastPage)
      encodeStringIfNotNull(descriptor, 18, value.pageCount?.value)
      encodeElementIfNotNull(descriptor, 19, value.pageCount)
      encodeStringIfNotNull(descriptor, 20, value.copyright?.value)
      encodeElementIfNotNull(descriptor, 21, value.copyright)
    }
  }
}

internal object CitationCitedArtifactPublicationFormPublishedInSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PublishedIn> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PublishedIn") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("publisher", ReferenceSerializer.descriptor)
      optionalElement("publisherLocation", KotlinString.serializer().descriptor)
      optionalElement("_publisherLocation", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PublishedIn>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm.PublishedIn =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var identifier: List<Identifier>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var publisher: Reference? = null
      var publisherLocation: KotlinString? = null
      var _publisherLocation: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          5 -> title = decodeStringElement(descriptor, i)
          6 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            publisher = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 -> publisherLocation = decodeStringElement(descriptor, i)
          9 ->
            _publisherLocation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PublishedIn: " + i)
        }
      }
      Citation.CitedArtifact.PublicationForm.PublishedIn(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        identifier = identifier ?: listOf(),
        title = R4bString.of(title, _title),
        publisher = publisher,
        publisherLocation = R4bString.of(publisherLocation, _publisherLocation),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PublishedIn,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeStringIfNotNull(descriptor, 5, value.title?.value)
      encodeElementIfNotNull(descriptor, 6, value.title)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.publisher)
      encodeStringIfNotNull(descriptor, 8, value.publisherLocation?.value)
      encodeElementIfNotNull(descriptor, 9, value.publisherLocation)
    }
  }
}

internal object CitationCitedArtifactPublicationFormPeriodicReleaseSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PeriodicRelease") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("citedMedium", CodeableConceptSerializer.descriptor)
      optionalElement("volume", KotlinString.serializer().descriptor)
      optionalElement("_volume", ElementSerializer.descriptor)
      optionalElement("issue", KotlinString.serializer().descriptor)
      optionalElement("_issue", ElementSerializer.descriptor)
      optionalElement(
        "dateOfPublication",
        CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer.descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PeriodicRelease>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var citedMedium: CodeableConcept? = null
      var volume: KotlinString? = null
      var _volume: Element? = null
      var issue: KotlinString? = null
      var _issue: Element? = null
      var dateOfPublication:
        Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication? =
        null
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
            citedMedium =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> volume = decodeStringElement(descriptor, i)
          5 -> _volume = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> issue = decodeStringElement(descriptor, i)
          7 -> _issue = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            dateOfPublication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PeriodicRelease: " + i)
        }
      }
      Citation.CitedArtifact.PublicationForm.PeriodicRelease(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        citedMedium = citedMedium,
        volume = R4bString.of(volume, _volume),
        issue = R4bString.of(issue, _issue),
        dateOfPublication = dateOfPublication,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PeriodicRelease,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.citedMedium)
      encodeStringIfNotNull(descriptor, 4, value.volume?.value)
      encodeElementIfNotNull(descriptor, 5, value.volume)
      encodeStringIfNotNull(descriptor, 6, value.issue?.value)
      encodeElementIfNotNull(descriptor, 7, value.issue)
      encodeSerializableIfNotNull(
        descriptor,
        8,
        CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer,
        value.dateOfPublication,
      )
    }
  }
}

internal object CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer :
  KSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("DateOfPublication") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("year", KotlinString.serializer().descriptor)
      optionalElement("_year", ElementSerializer.descriptor)
      optionalElement("month", KotlinString.serializer().descriptor)
      optionalElement("_month", ElementSerializer.descriptor)
      optionalElement("day", KotlinString.serializer().descriptor)
      optionalElement("_day", ElementSerializer.descriptor)
      optionalElement("season", KotlinString.serializer().descriptor)
      optionalElement("_season", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var year: KotlinString? = null
      var _year: Element? = null
      var month: KotlinString? = null
      var _month: Element? = null
      var day: KotlinString? = null
      var _day: Element? = null
      var season: KotlinString? = null
      var _season: Element? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
          3 -> date = decodeStringElement(descriptor, i)
          4 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> year = decodeStringElement(descriptor, i)
          6 -> _year = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> month = decodeStringElement(descriptor, i)
          8 -> _month = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> day = decodeStringElement(descriptor, i)
          10 -> _day = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> season = decodeStringElement(descriptor, i)
          12 -> _season = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> text = decodeStringElement(descriptor, i)
          14 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding DateOfPublication: " + i)
        }
      }
      Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
        year = R4bString.of(year, _year),
        month = R4bString.of(month, _month),
        day = R4bString.of(day, _day),
        season = R4bString.of(season, _season),
        text = R4bString.of(text, _text),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.date)
      encodeStringIfNotNull(descriptor, 5, value.year?.value)
      encodeElementIfNotNull(descriptor, 6, value.year)
      encodeStringIfNotNull(descriptor, 7, value.month?.value)
      encodeElementIfNotNull(descriptor, 8, value.month)
      encodeStringIfNotNull(descriptor, 9, value.day?.value)
      encodeElementIfNotNull(descriptor, 10, value.day)
      encodeStringIfNotNull(descriptor, 11, value.season?.value)
      encodeElementIfNotNull(descriptor, 12, value.season)
      encodeStringIfNotNull(descriptor, 13, value.text?.value)
      encodeElementIfNotNull(descriptor, 14, value.text)
    }
  }
}

internal object CitationCitedArtifactWebLocationSerializer :
  KSerializer<Citation.CitedArtifact.WebLocation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WebLocation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.WebLocation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.WebLocation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var url: KotlinString? = null
      var _url: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> url = decodeStringElement(descriptor, i)
          5 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding WebLocation: " + i)
        }
      }
      Citation.CitedArtifact.WebLocation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        url = Uri.of(url, _url),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.WebLocation) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.url?.value)
      encodeElementIfNotNull(descriptor, 5, value.url)
    }
  }
}

internal object CitationCitedArtifactClassificationSerializer :
  KSerializer<Citation.CitedArtifact.Classification> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Classification") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement(
        "whoClassified",
        CitationCitedArtifactClassificationWhoClassifiedSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Classification>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var classifier: List<CodeableConcept>? = null
      var whoClassified: Citation.CitedArtifact.Classification.WhoClassified? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            classifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            whoClassified =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactClassificationWhoClassifiedSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Classification: " + i)
        }
      }
      Citation.CitedArtifact.Classification(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        classifier = classifier ?: listOf(),
        whoClassified = whoClassified,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Classification) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      if (value.classifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.classifier,
        )
      encodeSerializableIfNotNull(
        descriptor,
        5,
        CitationCitedArtifactClassificationWhoClassifiedSerializer,
        value.whoClassified,
      )
    }
  }
}

internal object CitationCitedArtifactClassificationWhoClassifiedSerializer :
  KSerializer<Citation.CitedArtifact.Classification.WhoClassified> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WhoClassified") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("person", ReferenceSerializer.descriptor)
      optionalElement("organization", ReferenceSerializer.descriptor)
      optionalElement("publisher", ReferenceSerializer.descriptor)
      optionalElement("classifierCopyright", KotlinString.serializer().descriptor)
      optionalElement("_classifierCopyright", ElementSerializer.descriptor)
      optionalElement("freeToShare", KotlinBoolean.serializer().descriptor)
      optionalElement("_freeToShare", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Classification.WhoClassified>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification.WhoClassified =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var person: Reference? = null
      var organization: Reference? = null
      var publisher: Reference? = null
      var classifierCopyright: KotlinString? = null
      var _classifierCopyright: Element? = null
      var freeToShare: KotlinBoolean? = null
      var _freeToShare: Element? = null
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
          3 -> person = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            organization =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            publisher = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> classifierCopyright = decodeStringElement(descriptor, i)
          7 ->
            _classifierCopyright =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> freeToShare = decodeBooleanElement(descriptor, i)
          9 ->
            _freeToShare = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding WhoClassified: " + i)
        }
      }
      Citation.CitedArtifact.Classification.WhoClassified(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        person = person,
        organization = organization,
        publisher = publisher,
        classifierCopyright = R4bString.of(classifierCopyright, _classifierCopyright),
        freeToShare = R4bBoolean.of(freeToShare, _freeToShare),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Classification.WhoClassified,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.person)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.organization)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.publisher)
      encodeStringIfNotNull(descriptor, 6, value.classifierCopyright?.value)
      encodeElementIfNotNull(descriptor, 7, value.classifierCopyright)
      encodeBooleanIfNotNull(descriptor, 8, value.freeToShare?.value)
      encodeElementIfNotNull(descriptor, 9, value.freeToShare)
    }
  }
}

internal object CitationCitedArtifactContributorshipSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contributorship") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("complete", KotlinBoolean.serializer().descriptor)
      optionalElement("_complete", ElementSerializer.descriptor)
      optionalElement(
        "entry",
        CitationCitedArtifactContributorshipEntrySerializer.listSerializer.descriptor,
      )
      optionalElement(
        "summary",
        CitationCitedArtifactContributorshipSummarySerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var complete: KotlinBoolean? = null
      var _complete: Element? = null
      var entry: List<Citation.CitedArtifact.Contributorship.Entry>? = null
      var summary: List<Citation.CitedArtifact.Contributorship.Summary>? = null
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
          3 -> complete = decodeBooleanElement(descriptor, i)
          4 -> _complete = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            entry =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactContributorshipEntrySerializer.listSerializer,
                null,
              )
          6 ->
            summary =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactContributorshipSummarySerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contributorship: " + i)
        }
      }
      Citation.CitedArtifact.Contributorship(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        complete = R4bBoolean.of(complete, _complete),
        entry = entry ?: listOf(),
        summary = summary ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.complete?.value)
      encodeElementIfNotNull(descriptor, 4, value.complete)
      if (value.entry.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CitationCitedArtifactContributorshipEntrySerializer.listSerializer,
          value.entry,
        )
      if (value.summary.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CitationCitedArtifactContributorshipSummarySerializer.listSerializer,
          value.summary,
        )
    }
  }
}

internal object CitationCitedArtifactContributorshipEntrySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", HumanNameSerializer.descriptor)
      optionalElement("initials", KotlinString.serializer().descriptor)
      optionalElement("_initials", ElementSerializer.descriptor)
      optionalElement("collectiveName", KotlinString.serializer().descriptor)
      optionalElement("_collectiveName", ElementSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement(
        "affiliationInfo",
        CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer
          .descriptor,
      )
      optionalElement("address", AddressSerializer.listSerializer.descriptor)
      optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
      optionalElement("contributionType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement(
        "contributionInstance",
        CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer
          .descriptor,
      )
      optionalElement("correspondingContact", KotlinBoolean.serializer().descriptor)
      optionalElement("_correspondingContact", ElementSerializer.descriptor)
      optionalElement("listOrder", Int.serializer().descriptor)
      optionalElement("_listOrder", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship.Entry>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Entry =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: HumanName? = null
      var initials: KotlinString? = null
      var _initials: Element? = null
      var collectiveName: KotlinString? = null
      var _collectiveName: Element? = null
      var identifier: List<Identifier>? = null
      var affiliationInfo: List<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo>? =
        null
      var address: List<Address>? = null
      var telecom: List<ContactPoint>? = null
      var contributionType: List<CodeableConcept>? = null
      var role: CodeableConcept? = null
      var contributionInstance:
        List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>? =
        null
      var correspondingContact: KotlinBoolean? = null
      var _correspondingContact: Element? = null
      var listOrder: Int? = null
      var _listOrder: Element? = null
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
          3 -> name = decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          4 -> initials = decodeStringElement(descriptor, i)
          5 -> _initials = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> collectiveName = decodeStringElement(descriptor, i)
          7 ->
            _collectiveName =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          9 ->
            affiliationInfo =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer,
                null,
              )
          10 ->
            address =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AddressSerializer.listSerializer,
                null,
              )
          11 ->
            telecom =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContactPointSerializer.listSerializer,
                null,
              )
          12 ->
            contributionType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          13 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            contributionInstance =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CitationCitedArtifactContributorshipEntryContributionInstanceSerializer
                  .listSerializer,
                null,
              )
          15 -> correspondingContact = decodeBooleanElement(descriptor, i)
          16 ->
            _correspondingContact =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> listOrder = decodeIntElement(descriptor, i)
          18 ->
            _listOrder = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Entry: " + i)
        }
      }
      Citation.CitedArtifact.Contributorship.Entry(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = name,
        initials = R4bString.of(initials, _initials),
        collectiveName = R4bString.of(collectiveName, _collectiveName),
        identifier = identifier ?: listOf(),
        affiliationInfo = affiliationInfo ?: listOf(),
        address = address ?: listOf(),
        telecom = telecom ?: listOf(),
        contributionType = contributionType ?: listOf(),
        role = role,
        contributionInstance = contributionInstance ?: listOf(),
        correspondingContact = R4bBoolean.of(correspondingContact, _correspondingContact),
        listOrder = PositiveInt.of(listOrder, _listOrder),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship.Entry) {
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
      encodeSerializableIfNotNull(descriptor, 3, HumanNameSerializer, value.name)
      encodeStringIfNotNull(descriptor, 4, value.initials?.value)
      encodeElementIfNotNull(descriptor, 5, value.initials)
      encodeStringIfNotNull(descriptor, 6, value.collectiveName?.value)
      encodeElementIfNotNull(descriptor, 7, value.collectiveName)
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      if (value.affiliationInfo.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer,
          value.affiliationInfo,
        )
      if (value.address.isNotEmpty())
        encodeSerializableElement(descriptor, 10, AddressSerializer.listSerializer, value.address)
      if (value.telecom.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          ContactPointSerializer.listSerializer,
          value.telecom,
        )
      if (value.contributionType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CodeableConceptSerializer.listSerializer,
          value.contributionType,
        )
      encodeSerializableIfNotNull(descriptor, 13, CodeableConceptSerializer, value.role)
      if (value.contributionInstance.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer,
          value.contributionInstance,
        )
      encodeBooleanIfNotNull(descriptor, 15, value.correspondingContact?.value)
      encodeElementIfNotNull(descriptor, 16, value.correspondingContact)
      encodeIntIfNotNull(descriptor, 17, value.listOrder?.value)
      encodeElementIfNotNull(descriptor, 18, value.listOrder)
    }
  }
}

internal object CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AffiliationInfo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("affiliation", KotlinString.serializer().descriptor)
      optionalElement("_affiliation", ElementSerializer.descriptor)
      optionalElement("role", KotlinString.serializer().descriptor)
      optionalElement("_role", ElementSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var affiliation: KotlinString? = null
      var _affiliation: Element? = null
      var role: KotlinString? = null
      var _role: Element? = null
      var identifier: List<Identifier>? = null
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
          3 -> affiliation = decodeStringElement(descriptor, i)
          4 ->
            _affiliation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> role = decodeStringElement(descriptor, i)
          6 -> _role = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AffiliationInfo: " + i)
        }
      }
      Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        affiliation = R4bString.of(affiliation, _affiliation),
        role = R4bString.of(role, _role),
        identifier = identifier ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.affiliation?.value)
      encodeElementIfNotNull(descriptor, 4, value.affiliation)
      encodeStringIfNotNull(descriptor, 5, value.role?.value)
      encodeElementIfNotNull(descriptor, 6, value.role)
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
    }
  }
}

internal object CitationCitedArtifactContributorshipEntryContributionInstanceSerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContributionInstance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("time", KotlinString.serializer().descriptor)
      optionalElement("_time", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var time: KotlinString? = null
      var _time: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> time = decodeStringElement(descriptor, i)
          5 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ContributionInstance: " + i)
        }
      }
      Citation.CitedArtifact.Contributorship.Entry.ContributionInstance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on Citation.CitedArtifact.Contributorship.Entry.ContributionInstance"
            ),
        time = DateTime.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 4, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 5, value.time)
    }
  }
}

internal object CitationCitedArtifactContributorshipSummarySerializer :
  KSerializer<Citation.CitedArtifact.Contributorship.Summary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Summary") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("style", CodeableConceptSerializer.descriptor)
      optionalElement("source", CodeableConceptSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship.Summary>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Summary =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var style: CodeableConcept? = null
      var source: CodeableConcept? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            style =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            source =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> `value` = decodeStringElement(descriptor, i)
          7 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Summary: " + i)
        }
      }
      Citation.CitedArtifact.Contributorship.Summary(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        style = style,
        source = source,
        `value` =
          Markdown.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on Citation.CitedArtifact.Contributorship.Summary"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Summary,
  ) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.style)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.source)
      encodeStringIfNotNull(descriptor, 6, value.`value`.value)
      encodeElementIfNotNull(descriptor, 7, value.`value`)
    }
  }
}

internal object CitationSerializer : FhirResourceSerializer<Citation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Citation")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("summary", CitationSummarySerializer.listSerializer.descriptor)
    b.optionalElement("classification", CitationClassificationSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("currentState", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("statusDate", CitationStatusDateSerializer.listSerializer.descriptor)
    b.optionalElement("relatesTo", CitationRelatesToSerializer.listSerializer.descriptor)
    b.optionalElement("citedArtifact", CitationCitedArtifactSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Citation {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var summary: List<Citation.Summary>? = null
    var classification: List<Citation.Classification>? = null
    var note: List<Annotation>? = null
    var currentState: List<CodeableConcept>? = null
    var statusDate: List<Citation.StatusDate>? = null
    var relatesTo: List<Citation.RelatesTo>? = null
    var citedArtifact: Citation.CitedArtifact? = null
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
        19 -> status = decoder.decodeStringElement(descriptor, i)
        20 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 -> date = decoder.decodeStringElement(descriptor, i)
        24 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> publisher = decoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = decoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = decoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> copyright = decoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        37 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        39 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        41 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        42 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        43 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        44 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        45 ->
          summary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationSummarySerializer.listSerializer,
              null,
            )
        46 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationClassificationSerializer.listSerializer,
              null,
            )
        47 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        48 ->
          currentState =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        49 ->
          statusDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationStatusDateSerializer.listSerializer,
              null,
            )
        50 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationRelatesToSerializer.listSerializer,
              null,
            )
        51 ->
          citedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Citation: " + i)
      }
    }
    return Citation(
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
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Citation"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
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
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      summary = summary ?: listOf(),
      classification = classification ?: listOf(),
      note = note ?: listOf(),
      currentState = currentState ?: listOf(),
      statusDate = statusDate ?: listOf(),
      relatesTo = relatesTo ?: listOf(),
      citedArtifact = citedArtifact,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Citation,
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
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 21 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.summary.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        CitationSummarySerializer.listSerializer,
        value.summary,
      )
    if (value.classification.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        CitationClassificationSerializer.listSerializer,
        value.classification,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.currentState.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.currentState,
      )
    if (value.statusDate.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        CitationStatusDateSerializer.listSerializer,
        value.statusDate,
      )
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        CitationRelatesToSerializer.listSerializer,
        value.relatesTo,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      CitationCitedArtifactSerializer,
      value.citedArtifact,
    )
  }
}
