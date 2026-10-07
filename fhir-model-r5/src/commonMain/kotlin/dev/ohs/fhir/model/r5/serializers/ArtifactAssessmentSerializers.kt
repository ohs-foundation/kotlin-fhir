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

import dev.ohs.fhir.model.r5.ArtifactAssessment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
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
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object ArtifactAssessmentContentSerializer : KSerializer<ArtifactAssessment.Content> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Content") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("informationType", KotlinString.serializer().descriptor)
      optionalElement("_informationType", ElementSerializer.descriptor)
      optionalElement("summary", KotlinString.serializer().descriptor)
      optionalElement("_summary", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("classifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("author", ReferenceSerializer.descriptor)
      optionalElement("path", stringNullableListSerializer.descriptor)
      optionalElement("_path", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
      optionalElement("freeToShare", KotlinBoolean.serializer().descriptor)
      optionalElement("_freeToShare", ElementSerializer.descriptor)
      optionalElement(
        "component",
        listSerialDescriptor(lazyDescriptor { ArtifactAssessmentContentSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<ArtifactAssessment.Content>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ArtifactAssessment.Content {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var informationType: KotlinString? = null
    var _informationType: Element? = null
    var summary: KotlinString? = null
    var _summary: Element? = null
    var type: CodeableConcept? = null
    var classifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var author: Reference? = null
    var path: List<KotlinString?>? = null
    var _path: List<Element?>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var freeToShare: KotlinBoolean? = null
    var _freeToShare: Element? = null
    var component: List<ArtifactAssessment.Content>? = null
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
        3 -> informationType = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _informationType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> summary = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _summary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          classifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        10 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        11 ->
          path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _path =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          relatedArtifact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        14 -> freeToShare = compositeDecoder.decodeBooleanElement(descriptor, i)
        15 ->
          _freeToShare =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          component =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ArtifactAssessmentContentSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Content: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ArtifactAssessment.Content(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      informationType =
        Enumeration.of(
          if (informationType != null)
            ArtifactAssessment.ArtifactAssessmentInformationType.fromCode(informationType)
          else null,
          _informationType,
        ),
      summary = Markdown.of(summary, _summary),
      type = type,
      classifier = classifier ?: listOf(),
      quantity = quantity,
      author = author,
      path =
        (kotlin.collections.List(maxOf(path?.size ?: 0, _path?.size ?: 0)) { index ->
          Uri.of(path?.getOrNull(index), _path?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'path' on ArtifactAssessment.Content has neither a value nor an id/extension"
            )
        }),
      relatedArtifact = relatedArtifact ?: listOf(),
      freeToShare = R5Boolean.of(freeToShare, _freeToShare),
      component = component ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ArtifactAssessment.Content) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.informationType?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.informationType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.summary?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.summary)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.classifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.classifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.author)
    if (value.path.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        stringNullableListSerializer,
        value.path.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.path)
    }
    if (value.relatedArtifact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 14, value.freeToShare?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.freeToShare)
    if (value.component.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16,
        ArtifactAssessmentContentSerializer.listSerializer,
        value.component,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ArtifactAssessmentSerializer : FhirResourceSerializer<ArtifactAssessment> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ArtifactAssessment")

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
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("citeAsReference", ReferenceSerializer.descriptor)
    b.optionalElement("citeAsMarkdown", KotlinString.serializer().descriptor)
    b.optionalElement("_citeAsMarkdown", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("artifactReference", ReferenceSerializer.descriptor)
    b.optionalElement("artifactCanonical", KotlinString.serializer().descriptor)
    b.optionalElement("_artifactCanonical", ElementSerializer.descriptor)
    b.optionalElement("artifactUri", KotlinString.serializer().descriptor)
    b.optionalElement("_artifactUri", ElementSerializer.descriptor)
    b.optionalElement("content", ArtifactAssessmentContentSerializer.listSerializer.descriptor)
    b.optionalElement("workflowStatus", KotlinString.serializer().descriptor)
    b.optionalElement("_workflowStatus", ElementSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ArtifactAssessment {
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
    var title: KotlinString? = null
    var _title: Element? = null
    var citeAsReference: Reference? = null
    var citeAsMarkdown: KotlinString? = null
    var _citeAsMarkdown: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var artifactReference: Reference? = null
    var artifactCanonical: KotlinString? = null
    var _artifactCanonical: Element? = null
    var artifactUri: KotlinString? = null
    var _artifactUri: Element? = null
    var content: List<ArtifactAssessment.Content>? = null
    var workflowStatus: KotlinString? = null
    var _workflowStatus: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
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
        11 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          citeAsReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 -> citeAsMarkdown = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _citeAsMarkdown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> approvalDate = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 -> lastReviewDate = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          artifactReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 -> artifactCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _artifactCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> artifactUri = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _artifactUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          content =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ArtifactAssessmentContentSerializer.listSerializer,
              null,
            )
        30 -> workflowStatus = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _workflowStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> disposition = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _disposition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ArtifactAssessment: " + i)
      }
    }
    return ArtifactAssessment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      title = R5String.of(title, _title),
      citeAs =
        ArtifactAssessment.CiteAs.from(
          citeAsReference,
          Markdown.of(citeAsMarkdown, _citeAsMarkdown),
        ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
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
      artifact =
        ArtifactAssessment.Artifact.from(
          artifactReference,
          Canonical.of(artifactCanonical, _artifactCanonical),
          Uri.of(artifactUri, _artifactUri),
        )
          ?: throw SerializationException(
            "Missing required property 'artifact' on ArtifactAssessment"
          ),
      content = content ?: listOf(),
      workflowStatus =
        Enumeration.of(
          if (workflowStatus != null)
            ArtifactAssessment.ArtifactAssessmentWorkflowStatus.fromCode(workflowStatus)
          else null,
          _workflowStatus,
        ),
      disposition =
        Enumeration.of(
          if (disposition != null)
            ArtifactAssessment.ArtifactAssessmentDisposition.fromCode(disposition)
          else null,
          _disposition,
        ),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ArtifactAssessment,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.title)
    when (val choice = value.citeAs) {
      null -> {}
      is ArtifactAssessment.CiteAs.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          13 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ArtifactAssessment.CiteAs.Markdown -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          14 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.lastReviewDate)
    when (val choice = value.artifact) {
      is ArtifactAssessment.Artifact.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is ArtifactAssessment.Artifact.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          25 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, choice.value)
      }
      is ArtifactAssessment.Artifact.Uri -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          27 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, choice.value)
      }
    }
    if (value.content.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ArtifactAssessmentContentSerializer.listSerializer,
        value.content,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.workflowStatus?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.workflowStatus)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.disposition?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.disposition)
  }
}
