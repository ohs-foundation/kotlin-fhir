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

internal object CitationSummarySerializer : FhirSerializer<Citation.Summary> {
  override val descriptor: SerialDescriptor = buildDescriptor("Summary", this)

  @JvmField internal val listSerializer: KSerializer<List<Citation.Summary>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("style", CodeableConceptSerializer.descriptor)
    b.strPrim("text")
  }

  override fun deserialize(decoder: Decoder): Citation.Summary {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var style: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
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
          style =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _text =
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
    return Citation.Summary(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      style = style,
      text = required(Markdown.of(text, _text), "Citation.Summary", "text"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.Summary) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.style,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.text.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.text)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationClassificationSerializer : FhirSerializer<Citation.Classification> {
  override val descriptor: SerialDescriptor = buildDescriptor("Classification", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.Classification>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.Classification {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.Classification(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      classifier = listOrEmpty(classifier),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.Classification) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.classifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationStatusDateSerializer : FhirSerializer<Citation.StatusDate> {
  override val descriptor: SerialDescriptor = buildDescriptor("StatusDate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.StatusDate>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("activity", CodeableConceptSerializer.descriptor)
    b.boolPrim("actual")
    b.optionalElement("period", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.StatusDate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var activity: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
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
          activity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> `actual` = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _actual =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.StatusDate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      activity = required(activity, "Citation.StatusDate", "activity"),
      `actual` = R4bBoolean.of(`actual`, _actual),
      period = required(period, "Citation.StatusDate", "period"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.StatusDate) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.activity,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.`actual`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`actual`)
    compositeEncoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationRelatesToSerializer : FhirSerializer<Citation.RelatesTo> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatesTo", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.RelatesTo>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
    b.optionalElement("targetClassifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("targetUri")
    b.optionalElement("targetIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("targetReference", ReferenceSerializer.descriptor)
    b.optionalElement("targetAttachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.RelatesTo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          relationshipType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          targetClassifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 -> targetUri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _targetUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          targetIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        8 ->
          targetReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          targetAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.RelatesTo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      relationshipType = required(relationshipType, "Citation.RelatesTo", "relationshipType"),
      targetClassifier = listOrEmpty(targetClassifier),
      target =
        required(
          Citation.RelatesTo.Target.from(
            Uri.of(targetUri, _targetUri),
            targetIdentifier,
            targetReference,
            targetAttachment,
          ),
          "Citation.RelatesTo",
          "target",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.RelatesTo) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.relationshipType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.targetClassifier,
    )
    when (val choice = value.target) {
      is Citation.RelatesTo.Target.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Citation.RelatesTo.Target.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          7,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Citation.RelatesTo.Target.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
      }
      is Citation.RelatesTo.Target.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          9,
          AttachmentSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactSerializer : FhirSerializer<Citation.CitedArtifact> {
  override val descriptor: SerialDescriptor = buildDescriptor("CitedArtifact", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("relatedIdentifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("dateAccessed")
    b.optionalElement("version", CitationCitedArtifactVersionSerializer.descriptor)
    b.optionalElement("currentState", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "statusDate",
      CitationCitedArtifactStatusDateSerializer.listSerializer.descriptor,
    )
    b.optionalElement("title", CitationCitedArtifactTitleSerializer.listSerializer.descriptor)
    b.optionalElement("abstract", CitationCitedArtifactAbstractSerializer.listSerializer.descriptor)
    b.optionalElement("part", CitationCitedArtifactPartSerializer.descriptor)
    b.optionalElement(
      "relatesTo",
      CitationCitedArtifactRelatesToSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "publicationForm",
      CitationCitedArtifactPublicationFormSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "webLocation",
      CitationCitedArtifactWebLocationSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "classification",
      CitationCitedArtifactClassificationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("contributorship", CitationCitedArtifactContributorshipSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var relatedIdentifier: List<Identifier>? = null
    var dateAccessed: FhirDateTime? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 ->
          relatedIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        5 ->
          dateAccessed =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _dateAccessed =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactVersionSerializer,
              null,
            )
        8 ->
          currentState =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactStatusDateSerializer.listSerializer,
              null,
            )
        10 ->
          title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactTitleSerializer.listSerializer,
              null,
            )
        11 ->
          `abstract` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactAbstractSerializer.listSerializer,
              null,
            )
        12 ->
          part =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactPartSerializer,
              null,
            )
        13 ->
          relatesTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactRelatesToSerializer.listSerializer,
              null,
            )
        14 ->
          publicationForm =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactPublicationFormSerializer.listSerializer,
              null,
            )
        15 ->
          webLocation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactWebLocationSerializer.listSerializer,
              null,
            )
        16 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactClassificationSerializer.listSerializer,
              null,
            )
        17 ->
          contributorship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipSerializer,
              null,
            )
        18 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      relatedIdentifier = listOrEmpty(relatedIdentifier),
      dateAccessed = DateTime.of(dateAccessed, _dateAccessed),
      version = version,
      currentState = listOrEmpty(currentState),
      statusDate = listOrEmpty(statusDate),
      title = listOrEmpty(title),
      `abstract` = listOrEmpty(`abstract`),
      part = part,
      relatesTo = listOrEmpty(relatesTo),
      publicationForm = listOrEmpty(publicationForm),
      webLocation = listOrEmpty(webLocation),
      classification = listOrEmpty(classification),
      contributorship = contributorship,
      note = listOrEmpty(note),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      IdentifierSerializer.listSerializer,
      value.relatedIdentifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.dateAccessed?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.dateAccessed)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CitationCitedArtifactVersionSerializer,
      value.version,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      CodeableConceptSerializer.listSerializer,
      value.currentState,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CitationCitedArtifactStatusDateSerializer.listSerializer,
      value.statusDate,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CitationCitedArtifactTitleSerializer.listSerializer,
      value.title,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CitationCitedArtifactAbstractSerializer.listSerializer,
      value.`abstract`,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      CitationCitedArtifactPartSerializer,
      value.part,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13,
      CitationCitedArtifactRelatesToSerializer.listSerializer,
      value.relatesTo,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      CitationCitedArtifactPublicationFormSerializer.listSerializer,
      value.publicationForm,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      CitationCitedArtifactWebLocationSerializer.listSerializer,
      value.webLocation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16,
      CitationCitedArtifactClassificationSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17,
      CitationCitedArtifactContributorshipSerializer,
      value.contributorship,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactVersionSerializer :
  FhirSerializer<Citation.CitedArtifact.Version> {
  override val descriptor: SerialDescriptor = buildDescriptor("Version", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Version>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("value")
    b.optionalElement("baseCitation", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Version {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var baseCitation: Reference? = null
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
        3 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          baseCitation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.Version(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` = required(R4bString.of(`value`, _value), "Citation.CitedArtifact.Version", "value"),
      baseCitation = baseCitation,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Version) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.`value`)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ReferenceSerializer,
      value.baseCitation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactStatusDateSerializer :
  FhirSerializer<Citation.CitedArtifact.StatusDate> {
  override val descriptor: SerialDescriptor = buildDescriptor("StatusDate", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.StatusDate>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("activity", CodeableConceptSerializer.descriptor)
    b.boolPrim("actual")
    b.optionalElement("period", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.StatusDate {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var activity: CodeableConcept? = null
    var `actual`: KotlinBoolean? = null
    var _actual: Element? = null
    var period: Period? = null
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
          activity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> `actual` = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _actual =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.StatusDate(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      activity = required(activity, "Citation.CitedArtifact.StatusDate", "activity"),
      `actual` = R4bBoolean.of(`actual`, _actual),
      period = required(period, "Citation.CitedArtifact.StatusDate", "period"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.StatusDate) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.activity,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.`actual`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`actual`)
    compositeEncoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactTitleSerializer :
  FhirSerializer<Citation.CitedArtifact.Title> {
  override val descriptor: SerialDescriptor = buildDescriptor("Title", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Title>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("language", CodeableConceptSerializer.descriptor)
    b.strPrim("text")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Title {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: List<CodeableConcept>? = null
    var language: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _text =
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
    return Citation.CitedArtifact.Title(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = listOrEmpty(type),
      language = language,
      text = required(Markdown.of(text, _text), "Citation.CitedArtifact.Title", "text"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Title) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableConceptSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.text.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.text)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactAbstractSerializer :
  FhirSerializer<Citation.CitedArtifact.Abstract> {
  override val descriptor: SerialDescriptor = buildDescriptor("Abstract", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Abstract>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("language", CodeableConceptSerializer.descriptor)
    b.strPrim("text")
    b.strPrim("copyright")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Abstract {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _copyright =
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
    return Citation.CitedArtifact.Abstract(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      language = language,
      text = required(Markdown.of(text, _text), "Citation.CitedArtifact.Abstract", "text"),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Abstract) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.text.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.text)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.copyright?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.copyright)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactPartSerializer : FhirSerializer<Citation.CitedArtifact.Part> {
  override val descriptor: SerialDescriptor = buildDescriptor("Part", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Part>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("value")
    b.optionalElement("baseCitation", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Part {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var baseCitation: Reference? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          baseCitation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.Part(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      `value` = R4bString.of(`value`, _value),
      baseCitation = baseCitation,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Part) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.`value`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`value`)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ReferenceSerializer,
      value.baseCitation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactRelatesToSerializer :
  FhirSerializer<Citation.CitedArtifact.RelatesTo> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatesTo", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.RelatesTo>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("relationshipType", CodeableConceptSerializer.descriptor)
    b.optionalElement("targetClassifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("targetUri")
    b.optionalElement("targetIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("targetReference", ReferenceSerializer.descriptor)
    b.optionalElement("targetAttachment", AttachmentSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          relationshipType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          targetClassifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 -> targetUri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _targetUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          targetIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        8 ->
          targetReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          targetAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.RelatesTo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      relationshipType =
        required(relationshipType, "Citation.CitedArtifact.RelatesTo", "relationshipType"),
      targetClassifier = listOrEmpty(targetClassifier),
      target =
        required(
          Citation.CitedArtifact.RelatesTo.Target.from(
            Uri.of(targetUri, _targetUri),
            targetIdentifier,
            targetReference,
            targetAttachment,
          ),
          "Citation.CitedArtifact.RelatesTo",
          "target",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.RelatesTo) {
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.relationshipType,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.targetClassifier,
    )
    when (val choice = value.target) {
      is Citation.CitedArtifact.RelatesTo.Target.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Citation.CitedArtifact.RelatesTo.Target.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          7,
          IdentifierSerializer,
          choice.value,
        )
      }
      is Citation.CitedArtifact.RelatesTo.Target.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
      }
      is Citation.CitedArtifact.RelatesTo.Target.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          9,
          AttachmentSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactPublicationFormSerializer :
  FhirSerializer<Citation.CitedArtifact.PublicationForm> {
  override val descriptor: SerialDescriptor = buildDescriptor("PublicationForm", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.PublicationForm>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "publishedIn",
      CitationCitedArtifactPublicationFormPublishedInSerializer.descriptor,
    )
    b.optionalElement(
      "periodicRelease",
      CitationCitedArtifactPublicationFormPeriodicReleaseSerializer.descriptor,
    )
    b.strPrim("articleDate")
    b.strPrim("lastRevisionDate")
    b.optionalElement("language", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("accessionNumber")
    b.strPrim("pageString")
    b.strPrim("firstPage")
    b.strPrim("lastPage")
    b.strPrim("pageCount")
    b.strPrim("copyright")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var publishedIn: Citation.CitedArtifact.PublicationForm.PublishedIn? = null
    var periodicRelease: Citation.CitedArtifact.PublicationForm.PeriodicRelease? = null
    var articleDate: FhirDateTime? = null
    var _articleDate: Element? = null
    var lastRevisionDate: FhirDateTime? = null
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
          publishedIn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactPublicationFormPublishedInSerializer,
              null,
            )
        4 ->
          periodicRelease =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactPublicationFormPeriodicReleaseSerializer,
              null,
            )
        5 ->
          articleDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _articleDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          lastRevisionDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _lastRevisionDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 -> accessionNumber = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _accessionNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> pageString = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _pageString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> firstPage = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _firstPage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> lastPage = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _lastPage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> pageCount = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _pageCount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _copyright =
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
    return Citation.CitedArtifact.PublicationForm(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      publishedIn = publishedIn,
      periodicRelease = periodicRelease,
      articleDate = DateTime.of(articleDate, _articleDate),
      lastRevisionDate = DateTime.of(lastRevisionDate, _lastRevisionDate),
      language = listOrEmpty(language),
      accessionNumber = R4bString.of(accessionNumber, _accessionNumber),
      pageString = R4bString.of(pageString, _pageString),
      firstPage = R4bString.of(firstPage, _firstPage),
      lastPage = R4bString.of(lastPage, _lastPage),
      pageCount = R4bString.of(pageCount, _pageCount),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.PublicationForm) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CitationCitedArtifactPublicationFormPublishedInSerializer,
      value.publishedIn,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CitationCitedArtifactPublicationFormPeriodicReleaseSerializer,
      value.periodicRelease,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.articleDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.articleDate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.lastRevisionDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.lastRevisionDate)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CodeableConceptSerializer.listSerializer,
      value.language,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.accessionNumber?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.accessionNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.pageString?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.pageString)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.firstPage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.firstPage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 16, value.lastPage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.lastPage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 18, value.pageCount?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.pageCount)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20, value.copyright?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.copyright)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactPublicationFormPublishedInSerializer :
  FhirSerializer<Citation.CitedArtifact.PublicationForm.PublishedIn> {
  override val descriptor: SerialDescriptor = buildDescriptor("PublishedIn", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PublishedIn>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("title")
    b.optionalElement("publisher", ReferenceSerializer.descriptor)
    b.strPrim("publisherLocation")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.PublicationForm.PublishedIn {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        5 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 -> publisherLocation = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _publisherLocation =
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
    return Citation.CitedArtifact.PublicationForm.PublishedIn(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      identifier = listOrEmpty(identifier),
      title = R4bString.of(title, _title),
      publisher = publisher,
      publisherLocation = R4bString.of(publisherLocation, _publisherLocation),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.PublicationForm.PublishedIn,
  ) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.title)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      ReferenceSerializer,
      value.publisher,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.publisherLocation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.publisherLocation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactPublicationFormPeriodicReleaseSerializer :
  FhirSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease> {
  override val descriptor: SerialDescriptor = buildDescriptor("PeriodicRelease", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PeriodicRelease>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("citedMedium", CodeableConceptSerializer.descriptor)
    b.strPrim("volume")
    b.strPrim("issue")
    b.optionalElement(
      "dateOfPublication",
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer.descriptor,
    )
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          citedMedium =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> volume = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _volume =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> issue = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _issue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          dateOfPublication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.PublicationForm.PeriodicRelease(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.citedMedium,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.volume?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.volume)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.issue?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.issue)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer,
      value.dateOfPublication,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactPublicationFormPeriodicReleaseDateOfPublicationSerializer :
  FhirSerializer<Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication> {
  override val descriptor: SerialDescriptor = buildDescriptor("DateOfPublication", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("year")
    b.strPrim("month")
    b.strPrim("day")
    b.strPrim("season")
    b.strPrim("text")
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: FhirDate? = null
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
        3 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> year = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _year =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> month = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _month =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> day = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _day =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> season = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _season =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _text =
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
    return Citation.CitedArtifact.PublicationForm.PeriodicRelease.DateOfPublication(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      date = Date.of(date, _date),
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.date)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.year?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.year)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.month?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.month)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.day?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.day)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.season?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.season)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.text)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactWebLocationSerializer :
  FhirSerializer<Citation.CitedArtifact.WebLocation> {
  override val descriptor: SerialDescriptor = buildDescriptor("WebLocation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.WebLocation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.WebLocation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var url: KotlinString? = null
    var _url: Element? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _url =
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
    return Citation.CitedArtifact.WebLocation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      url = Uri.of(url, _url),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.WebLocation) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactClassificationSerializer :
  FhirSerializer<Citation.CitedArtifact.Classification> {
  override val descriptor: SerialDescriptor = buildDescriptor("Classification", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Classification>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement(
      "whoClassified",
      CitationCitedArtifactClassificationWhoClassifiedSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    var whoClassified: Citation.CitedArtifact.Classification.WhoClassified? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          whoClassified =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactClassificationWhoClassifiedSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.Classification(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      classifier = listOrEmpty(classifier),
      whoClassified = whoClassified,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Classification) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.classifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CitationCitedArtifactClassificationWhoClassifiedSerializer,
      value.whoClassified,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactClassificationWhoClassifiedSerializer :
  FhirSerializer<Citation.CitedArtifact.Classification.WhoClassified> {
  override val descriptor: SerialDescriptor = buildDescriptor("WhoClassified", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Classification.WhoClassified>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("person", ReferenceSerializer.descriptor)
    b.optionalElement("organization", ReferenceSerializer.descriptor)
    b.optionalElement("publisher", ReferenceSerializer.descriptor)
    b.strPrim("classifierCopyright")
    b.boolPrim("freeToShare")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification.WhoClassified {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          person =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          organization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        5 ->
          publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> classifierCopyright = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _classifierCopyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> freeToShare = compositeDecoder.decodeBooleanElement(descriptor, i)
        9 ->
          _freeToShare =
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
    return Citation.CitedArtifact.Classification.WhoClassified(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.person)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      ReferenceSerializer,
      value.organization,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      ReferenceSerializer,
      value.publisher,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.classifierCopyright?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.classifierCopyright)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 8, value.freeToShare?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.freeToShare)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactContributorshipSerializer :
  FhirSerializer<Citation.CitedArtifact.Contributorship> {
  override val descriptor: SerialDescriptor = buildDescriptor("Contributorship", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("complete")
    b.optionalElement(
      "entry",
      CitationCitedArtifactContributorshipEntrySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "summary",
      CitationCitedArtifactContributorshipSummarySerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var complete: KotlinBoolean? = null
    var _complete: Element? = null
    var entry: List<Citation.CitedArtifact.Contributorship.Entry>? = null
    var summary: List<Citation.CitedArtifact.Contributorship.Summary>? = null
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
        3 -> complete = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _complete =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          entry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipEntrySerializer.listSerializer,
              null,
            )
        6 ->
          summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipSummarySerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.Contributorship(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      complete = R4bBoolean.of(complete, _complete),
      entry = listOrEmpty(entry),
      summary = listOrEmpty(summary),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship) {
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
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.complete?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.complete)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CitationCitedArtifactContributorshipEntrySerializer.listSerializer,
      value.entry,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      CitationCitedArtifactContributorshipSummarySerializer.listSerializer,
      value.summary,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactContributorshipEntrySerializer :
  FhirSerializer<Citation.CitedArtifact.Contributorship.Entry> {
  override val descriptor: SerialDescriptor = buildDescriptor("Entry", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship.Entry>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("name", HumanNameSerializer.descriptor)
    b.strPrim("initials")
    b.strPrim("collectiveName")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement(
      "affiliationInfo",
      CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer.descriptor,
    )
    b.optionalElement("address", AddressSerializer.listSerializer.descriptor)
    b.optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("contributionType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "contributionInstance",
      CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer
        .descriptor,
    )
    b.boolPrim("correspondingContact")
    b.intPrim("listOrder")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Entry {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: HumanName? = null
    var initials: KotlinString? = null
    var _initials: Element? = null
    var collectiveName: KotlinString? = null
    var _collectiveName: Element? = null
    var identifier: List<Identifier>? = null
    var affiliationInfo: List<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo>? = null
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
          name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              HumanNameSerializer,
              null,
            )
        4 -> initials = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _initials =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> collectiveName = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _collectiveName =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        9 ->
          affiliationInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer,
              null,
            )
        10 ->
          address =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer.listSerializer,
              null,
            )
        11 ->
          telecom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        12 ->
          contributionType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          contributionInstance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipEntryContributionInstanceSerializer
                .listSerializer,
              null,
            )
        15 -> correspondingContact = compositeDecoder.decodeBooleanElement(descriptor, i)
        16 ->
          _correspondingContact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> listOrder = compositeDecoder.decodeIntElement(descriptor, i)
        18 ->
          _listOrder =
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
    return Citation.CitedArtifact.Contributorship.Entry(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = name,
      initials = R4bString.of(initials, _initials),
      collectiveName = R4bString.of(collectiveName, _collectiveName),
      identifier = listOrEmpty(identifier),
      affiliationInfo = listOrEmpty(affiliationInfo),
      address = listOrEmpty(address),
      telecom = listOrEmpty(telecom),
      contributionType = listOrEmpty(contributionType),
      role = role,
      contributionInstance = listOrEmpty(contributionInstance),
      correspondingContact = R4bBoolean.of(correspondingContact, _correspondingContact),
      listOrder = PositiveInt.of(listOrder, _listOrder),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Citation.CitedArtifact.Contributorship.Entry) {
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
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, HumanNameSerializer, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.initials?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.initials)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.collectiveName?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.collectiveName)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer.listSerializer,
      value.affiliationInfo,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      AddressSerializer.listSerializer,
      value.address,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      ContactPointSerializer.listSerializer,
      value.telecom,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      CodeableConceptSerializer.listSerializer,
      value.contributionType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer,
      value.contributionInstance,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 15, value.correspondingContact?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.correspondingContact)
    compositeEncoder.encodeIntIfNotNull(descriptor, 17, value.listOrder?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.listOrder)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactContributorshipEntryAffiliationInfoSerializer :
  FhirSerializer<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo> {
  override val descriptor: SerialDescriptor = buildDescriptor("AffiliationInfo", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("affiliation")
    b.strPrim("role")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var affiliation: KotlinString? = null
    var _affiliation: Element? = null
    var role: KotlinString? = null
    var _role: Element? = null
    var identifier: List<Identifier>? = null
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
        3 -> affiliation = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _affiliation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> role = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      affiliation = R4bString.of(affiliation, _affiliation),
      role = R4bString.of(role, _role),
      identifier = listOrEmpty(identifier),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.AffiliationInfo,
  ) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.affiliation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.affiliation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.role?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.role)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactContributorshipEntryContributionInstanceSerializer :
  FhirSerializer<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance> {
  override val descriptor: SerialDescriptor = buildDescriptor("ContributionInstance", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("time")
  }

  override fun deserialize(
    decoder: Decoder
  ): Citation.CitedArtifact.Contributorship.Entry.ContributionInstance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var time: FhirDateTime? = null
    var _time: Element? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> time = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _time =
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
    return Citation.CitedArtifact.Contributorship.Entry.ContributionInstance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type =
        required(type, "Citation.CitedArtifact.Contributorship.Entry.ContributionInstance", "type"),
      time = DateTime.of(time, _time),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Entry.ContributionInstance,
  ) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.time?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.time)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationCitedArtifactContributorshipSummarySerializer :
  FhirSerializer<Citation.CitedArtifact.Contributorship.Summary> {
  override val descriptor: SerialDescriptor = buildDescriptor("Summary", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Citation.CitedArtifact.Contributorship.Summary>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("style", CodeableConceptSerializer.descriptor)
    b.optionalElement("source", CodeableConceptSerializer.descriptor)
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Summary {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var style: CodeableConcept? = null
    var source: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          style =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _value =
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
    return Citation.CitedArtifact.Contributorship.Summary(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = type,
      style = style,
      source = source,
      `value` =
        required(
          Markdown.of(`value`, _value),
          "Citation.CitedArtifact.Contributorship.Summary",
          "value",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: Citation.CitedArtifact.Contributorship.Summary,
  ) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.style,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.source,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CitationSerializer : FhirResourceSerializer<Citation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Citation")

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
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
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
    compositeDecoder: CompositeDecoder,
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
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: FhirDateTime? = null
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
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
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
        19 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        31 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        35 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        37 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        39 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        40 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        41 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        42 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        43 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        44 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        45 ->
          summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationSummarySerializer.listSerializer,
              null,
            )
        46 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationClassificationSerializer.listSerializer,
              null,
            )
        47 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        48 ->
          currentState =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        49 ->
          statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationStatusDateSerializer.listSerializer,
              null,
            )
        50 ->
          relatesTo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationRelatesToSerializer.listSerializer,
              null,
            )
        51 ->
          citedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Citation(
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
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      status = required(Enumeration.of(status, _status), "Citation", "status"),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      author = listOrEmpty(author),
      editor = listOrEmpty(editor),
      reviewer = listOrEmpty(reviewer),
      endorser = listOrEmpty(endorser),
      summary = listOrEmpty(summary),
      classification = listOrEmpty(classification),
      note = listOrEmpty(note),
      currentState = listOrEmpty(currentState),
      statusDate = listOrEmpty(statusDate),
      relatesTo = listOrEmpty(relatesTo),
      citedArtifact = citedArtifact,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Citation,
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
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      36 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      41 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.author,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      42 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.editor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      43 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.reviewer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      44 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.endorser,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      CitationSummarySerializer.listSerializer,
      value.summary,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      46 + descriptorOffset,
      CitationClassificationSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.currentState,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49 + descriptorOffset,
      CitationStatusDateSerializer.listSerializer,
      value.statusDate,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      CitationRelatesToSerializer.listSerializer,
      value.relatesTo,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      51 + descriptorOffset,
      CitationCitedArtifactSerializer,
      value.citedArtifact,
    )
  }
}
