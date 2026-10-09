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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Citation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.RelatedArtifactTypeExpanded
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
      `actual` = R5Boolean.of(`actual`, _actual),
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
      `value` = required(R5String.of(`value`, _value), "Citation.CitedArtifact.Version", "value"),
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
      `actual` = R5Boolean.of(`actual`, _actual),
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
      `value` = R5String.of(`value`, _value),
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
    b.strPrim("type")
    b.optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("label")
    b.strPrim("display")
    b.strPrim("citation")
    b.optionalElement("document", AttachmentSerializer.descriptor)
    b.strPrim("resource")
    b.optionalElement("resourceReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.RelatesTo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: RelatedArtifactTypeExpanded? = null
    var _type: Element? = null
    var classifier: List<CodeableConcept>? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var citation: KotlinString? = null
    var _citation: Element? = null
    var document: Attachment? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
    var resourceReference: Reference? = null
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
            RelatedArtifactTypeExpanded.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> citation = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _citation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          document =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        13 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          resourceReference =
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
    return Citation.CitedArtifact.RelatesTo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "Citation.CitedArtifact.RelatesTo", "type"),
      classifier = listOrEmpty(classifier),
      label = R5String.of(label, _label),
      display = R5String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      document = document,
      resource = Canonical.of(resource, _resource),
      resourceReference = resourceReference,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableConceptSerializer.listSerializer,
      value.classifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.label)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.citation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.citation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      AttachmentSerializer,
      value.document,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.resource?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.resource)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      ReferenceSerializer,
      value.resourceReference,
    )
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
    b.optionalElement("citedMedium", CodeableConceptSerializer.descriptor)
    b.strPrim("volume")
    b.strPrim("issue")
    b.strPrim("articleDate")
    b.strPrim("publicationDateText")
    b.strPrim("publicationDateSeason")
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
    var citedMedium: CodeableConcept? = null
    var volume: KotlinString? = null
    var _volume: Element? = null
    var issue: KotlinString? = null
    var _issue: Element? = null
    var articleDate: FhirDateTime? = null
    var _articleDate: Element? = null
    var publicationDateText: KotlinString? = null
    var _publicationDateText: Element? = null
    var publicationDateSeason: KotlinString? = null
    var _publicationDateSeason: Element? = null
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
          citedMedium =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> volume = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _volume =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> issue = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _issue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          articleDate = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _articleDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> publicationDateText = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _publicationDateText =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> publicationDateSeason = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _publicationDateSeason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          lastRevisionDate =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _lastRevisionDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 -> accessionNumber = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _accessionNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> pageString = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _pageString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> firstPage = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _firstPage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> lastPage = compositeDecoder.decodeStringElement(descriptor, i)
        25 ->
          _lastPage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> pageCount = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _pageCount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
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
      citedMedium = citedMedium,
      volume = R5String.of(volume, _volume),
      issue = R5String.of(issue, _issue),
      articleDate = DateTime.of(articleDate, _articleDate),
      publicationDateText = R5String.of(publicationDateText, _publicationDateText),
      publicationDateSeason = R5String.of(publicationDateSeason, _publicationDateSeason),
      lastRevisionDate = DateTime.of(lastRevisionDate, _lastRevisionDate),
      language = listOrEmpty(language),
      accessionNumber = R5String.of(accessionNumber, _accessionNumber),
      pageString = R5String.of(pageString, _pageString),
      firstPage = R5String.of(firstPage, _firstPage),
      lastPage = R5String.of(lastPage, _lastPage),
      pageCount = R5String.of(pageCount, _pageCount),
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
      CodeableConceptSerializer,
      value.citedMedium,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.volume?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.volume)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.issue?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.issue)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.articleDate?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.articleDate)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.publicationDateText?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.publicationDateText)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.publicationDateSeason?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.publicationDateSeason)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15,
      value.lastRevisionDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.lastRevisionDate)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17,
      CodeableConceptSerializer.listSerializer,
      value.language,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 18, value.accessionNumber?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.accessionNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20, value.pageString?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.pageString)
    compositeEncoder.encodeStringIfNotNull(descriptor, 22, value.firstPage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.firstPage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 24, value.lastPage?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 25, value.lastPage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 26, value.pageCount?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 27, value.pageCount)
    compositeEncoder.encodeStringIfNotNull(descriptor, 28, value.copyright?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 29, value.copyright)
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
      title = R5String.of(title, _title),
      publisher = publisher,
      publisherLocation = R5String.of(publisherLocation, _publisherLocation),
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
    b.optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.WebLocation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var classifier: List<CodeableConcept>? = null
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
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
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
      classifier = listOrEmpty(classifier),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableConceptSerializer.listSerializer,
      value.classifier,
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
    b.optionalElement("artifactAssessment", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Classification {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    var artifactAssessment: List<Reference>? = null
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
          artifactAssessment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
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
      artifactAssessment = listOrEmpty(artifactAssessment),
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      ReferenceSerializer.listSerializer,
      value.artifactAssessment,
    )
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
      complete = R5Boolean.of(complete, _complete),
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
    b.optionalElement("contributor", ReferenceSerializer.descriptor)
    b.strPrim("forenameInitials")
    b.optionalElement("affiliation", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("contributionType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "contributionInstance",
      CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer
        .descriptor,
    )
    b.boolPrim("correspondingContact")
    b.intPrim("rankingOrder")
  }

  override fun deserialize(decoder: Decoder): Citation.CitedArtifact.Contributorship.Entry {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contributor: Reference? = null
    var forenameInitials: KotlinString? = null
    var _forenameInitials: Element? = null
    var affiliation: List<Reference>? = null
    var contributionType: List<CodeableConcept>? = null
    var role: CodeableConcept? = null
    var contributionInstance:
      List<Citation.CitedArtifact.Contributorship.Entry.ContributionInstance>? =
      null
    var correspondingContact: KotlinBoolean? = null
    var _correspondingContact: Element? = null
    var rankingOrder: Int? = null
    var _rankingOrder: Element? = null
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
          contributor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> forenameInitials = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _forenameInitials =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          affiliation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          contributionType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          contributionInstance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationCitedArtifactContributorshipEntryContributionInstanceSerializer
                .listSerializer,
              null,
            )
        10 -> correspondingContact = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _correspondingContact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> rankingOrder = compositeDecoder.decodeIntElement(descriptor, i)
        13 ->
          _rankingOrder =
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
      contributor =
        required(contributor, "Citation.CitedArtifact.Contributorship.Entry", "contributor"),
      forenameInitials = R5String.of(forenameInitials, _forenameInitials),
      affiliation = listOrEmpty(affiliation),
      contributionType = listOrEmpty(contributionType),
      role = role,
      contributionInstance = listOrEmpty(contributionInstance),
      correspondingContact = R5Boolean.of(correspondingContact, _correspondingContact),
      rankingOrder = PositiveInt.of(rankingOrder, _rankingOrder),
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      ReferenceSerializer,
      value.contributor,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.forenameInitials?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.forenameInitials)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      ReferenceSerializer.listSerializer,
      value.affiliation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodeableConceptSerializer.listSerializer,
      value.contributionType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      CitationCitedArtifactContributorshipEntryContributionInstanceSerializer.listSerializer,
      value.contributionInstance,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, value.correspondingContact?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.correspondingContact)
    compositeEncoder.encodeIntIfNotNull(descriptor, 12, value.rankingOrder?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.rankingOrder)
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
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
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
    b.strPrim("copyrightLabel")
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
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
    var relatedArtifact: List<RelatedArtifact>? = null
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
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        23 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        25 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        34 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        35 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        42 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        44 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        46 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        47 ->
          editor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        48 ->
          reviewer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        49 ->
          endorser =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        50 ->
          summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationSummarySerializer.listSerializer,
              null,
            )
        51 ->
          classification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationClassificationSerializer.listSerializer,
              null,
            )
        52 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        53 ->
          currentState =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        54 ->
          statusDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CitationStatusDateSerializer.listSerializer,
              null,
            )
        55 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        56 ->
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        Citation.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      status = required(Enumeration.of(status, _status), "Citation", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
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
      relatedArtifact = listOrEmpty(relatedArtifact),
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
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Citation.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is Citation.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.experimental)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      45 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      46 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.author,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.editor,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      48 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.reviewer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.endorser,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      CitationSummarySerializer.listSerializer,
      value.summary,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      CitationClassificationSerializer.listSerializer,
      value.classification,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      52 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      53 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.currentState,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      54 + descriptorOffset,
      CitationStatusDateSerializer.listSerializer,
      value.statusDate,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      55 + descriptorOffset,
      RelatedArtifactSerializer.listSerializer,
      value.relatedArtifact,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      CitationCitedArtifactSerializer,
      value.citedArtifact,
    )
  }
}
