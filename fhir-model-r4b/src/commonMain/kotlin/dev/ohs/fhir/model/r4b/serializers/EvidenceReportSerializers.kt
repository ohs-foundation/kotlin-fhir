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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.EvidenceReport
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.RelatedArtifact
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

internal object EvidenceReportSubjectSerializer : KSerializer<EvidenceReport.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subject") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "characteristic",
        EvidenceReportSubjectCharacteristicSerializer.listSerializer.descriptor,
      )
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceReport.Subject>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceReport.Subject =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var characteristic: List<EvidenceReport.Subject.Characteristic>? = null
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
            characteristic =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceReportSubjectCharacteristicSerializer.listSerializer,
                null,
              )
          4 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Subject: " + i)
        }
      }
      EvidenceReport.Subject(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        characteristic = characteristic ?: listOf(),
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Subject) {
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
      if (value.characteristic.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          EvidenceReportSubjectCharacteristicSerializer.listSerializer,
          value.characteristic,
        )
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 4, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object EvidenceReportSubjectCharacteristicSerializer :
  KSerializer<EvidenceReport.Subject.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("exclude", KotlinBoolean.serializer().descriptor)
      optionalElement("_exclude", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceReport.Subject.Characteristic>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceReport.Subject.Characteristic =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var valueReference: Reference? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueQuantity: Quantity? = null
      var valueRange: Range? = null
      var exclude: KotlinBoolean? = null
      var _exclude: Element? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> valueBoolean = decodeBooleanElement(descriptor, i)
          7 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          10 -> exclude = decodeBooleanElement(descriptor, i)
          11 -> _exclude = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristic: " + i)
        }
      }
      EvidenceReport.Subject.Characteristic(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on EvidenceReport.Subject.Characteristic"
            ),
        `value` =
          EvidenceReport.Subject.Characteristic.Value.from(
            valueReference,
            valueCodeableConcept,
            R4bBoolean.of(valueBoolean, _valueBoolean),
            valueQuantity,
            valueRange,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on EvidenceReport.Subject.Characteristic"
            ),
        exclude = R4bBoolean.of(exclude, _exclude),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Subject.Characteristic) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      when (val choice = value.`value`) {
        is EvidenceReport.Subject.Characteristic.Value.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
        is EvidenceReport.Subject.Characteristic.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is EvidenceReport.Subject.Characteristic.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is EvidenceReport.Subject.Characteristic.Value.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is EvidenceReport.Subject.Characteristic.Value.Range -> {
          encodeSerializableElement(descriptor, 9, RangeSerializer, choice.value)
        }
      }
      encodeBooleanIfNotNull(descriptor, 10, value.exclude?.value)
      encodeElementIfNotNull(descriptor, 11, value.exclude)
      encodeSerializableIfNotNull(descriptor, 12, PeriodSerializer, value.period)
    }
  }
}

internal object EvidenceReportRelatesToSerializer : KSerializer<EvidenceReport.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", KotlinString.serializer().descriptor)
      optionalElement("_code", ElementSerializer.descriptor)
      optionalElement("targetIdentifier", IdentifierSerializer.descriptor)
      optionalElement("targetReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<EvidenceReport.RelatesTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceReport.RelatesTo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: KotlinString? = null
      var _code: Element? = null
      var targetIdentifier: Identifier? = null
      var targetReference: Reference? = null
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
          3 -> code = decodeStringElement(descriptor, i)
          4 -> _code = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            targetIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          6 ->
            targetReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
        }
      }
      EvidenceReport.RelatesTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Enumeration.of(
            if (code != null) EvidenceReport.ReportRelationshipType.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on EvidenceReport.RelatesTo"
            ),
        target =
          EvidenceReport.RelatesTo.Target.from(targetIdentifier, targetReference)
            ?: throw SerializationException(
              "Missing required property 'target' on EvidenceReport.RelatesTo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.RelatesTo) {
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
      encodeStringIfNotNull(descriptor, 3, value.code.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.code)
      when (val choice = value.target) {
        is EvidenceReport.RelatesTo.Target.Identifier -> {
          encodeSerializableElement(descriptor, 5, IdentifierSerializer, choice.value)
        }
        is EvidenceReport.RelatesTo.Target.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object EvidenceReportSectionSerializer : KSerializer<EvidenceReport.Section> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Section") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("focus", CodeableConceptSerializer.descriptor)
      optionalElement("focusReference", ReferenceSerializer.descriptor)
      optionalElement("author", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("text", NarrativeSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("orderedBy", CodeableConceptSerializer.descriptor)
      optionalElement("entryClassifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("entryReference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("entryQuantity", QuantitySerializer.listSerializer.descriptor)
      optionalElement("emptyReason", CodeableConceptSerializer.descriptor)
      optionalElement(
        "section",
        listSerialDescriptor(lazyDescriptor { EvidenceReportSectionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<EvidenceReport.Section>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): EvidenceReport.Section =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var focus: CodeableConcept? = null
      var focusReference: Reference? = null
      var author: List<Reference>? = null
      var text: Narrative? = null
      var mode: KotlinString? = null
      var _mode: Element? = null
      var orderedBy: CodeableConcept? = null
      var entryClassifier: List<CodeableConcept>? = null
      var entryReference: List<Reference>? = null
      var entryQuantity: List<Quantity>? = null
      var emptyReason: CodeableConcept? = null
      var section: List<EvidenceReport.Section>? = null
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
          3 -> title = decodeStringElement(descriptor, i)
          4 -> _title = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            focus =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            focusReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            author =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          8 -> text = decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
          9 -> mode = decodeStringElement(descriptor, i)
          10 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            orderedBy =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            entryClassifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          13 ->
            entryReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          14 ->
            entryQuantity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuantitySerializer.listSerializer,
                null,
              )
          15 ->
            emptyReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 ->
            section =
              decodeNullableSerializableElement(
                descriptor,
                i,
                EvidenceReportSectionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Section: " + i)
        }
      }
      EvidenceReport.Section(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R4bString.of(title, _title),
        focus = focus,
        focusReference = focusReference,
        author = author ?: listOf(),
        text = text,
        mode =
          Enumeration.of(if (mode != null) EvidenceReport.ListMode.fromCode(mode) else null, _mode),
        orderedBy = orderedBy,
        entryClassifier = entryClassifier ?: listOf(),
        entryReference = entryReference ?: listOf(),
        entryQuantity = entryQuantity ?: listOf(),
        emptyReason = emptyReason,
        section = section ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Section) {
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
      encodeStringIfNotNull(descriptor, 3, value.title?.value)
      encodeElementIfNotNull(descriptor, 4, value.title)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.focus)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.focusReference)
      if (value.author.isNotEmpty())
        encodeSerializableElement(descriptor, 7, ReferenceSerializer.listSerializer, value.author)
      encodeSerializableIfNotNull(descriptor, 8, NarrativeSerializer, value.text)
      encodeStringIfNotNull(descriptor, 9, value.mode?.value?.code)
      encodeElementIfNotNull(descriptor, 10, value.mode)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.orderedBy)
      if (value.entryClassifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CodeableConceptSerializer.listSerializer,
          value.entryClassifier,
        )
      if (value.entryReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ReferenceSerializer.listSerializer,
          value.entryReference,
        )
      if (value.entryQuantity.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          QuantitySerializer.listSerializer,
          value.entryQuantity,
        )
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.emptyReason)
      if (value.section.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          EvidenceReportSectionSerializer.listSerializer,
          value.section,
        )
    }
  }
}

internal object EvidenceReportSerializer : FhirResourceSerializer<EvidenceReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("EvidenceReport")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("relatedIdentifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("citeAsReference", ReferenceSerializer.descriptor)
    b.optionalElement("citeAsMarkdown", KotlinString.serializer().descriptor)
    b.optionalElement("_citeAsMarkdown", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("relatedArtifact", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("subject", EvidenceReportSubjectSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("author", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("editor", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("reviewer", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("endorser", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("relatesTo", EvidenceReportRelatesToSerializer.listSerializer.descriptor)
    b.optionalElement("section", EvidenceReportSectionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): EvidenceReport {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var useContext: List<UsageContext>? = null
    var identifier: List<Identifier>? = null
    var relatedIdentifier: List<Identifier>? = null
    var citeAsReference: Reference? = null
    var citeAsMarkdown: KotlinString? = null
    var _citeAsMarkdown: Element? = null
    var type: CodeableConcept? = null
    var note: List<Annotation>? = null
    var relatedArtifact: List<RelatedArtifact>? = null
    var subject: EvidenceReport.Subject? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var author: List<ContactDetail>? = null
    var editor: List<ContactDetail>? = null
    var reviewer: List<ContactDetail>? = null
    var endorser: List<ContactDetail>? = null
    var relatesTo: List<EvidenceReport.RelatesTo>? = null
    var section: List<EvidenceReport.Section>? = null
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
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        15 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        16 ->
          relatedIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        17 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> citeAsMarkdown = decoder.decodeStringElement(descriptor, i)
        19 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        21 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        22 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        23 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceReportSubjectSerializer,
              null,
            )
        24 -> publisher = decoder.decodeStringElement(descriptor, i)
        25 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        27 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        28 ->
          editor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        29 ->
          reviewer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        30 ->
          endorser =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        31 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceReportRelatesToSerializer.listSerializer,
              null,
            )
        32 ->
          section =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              EvidenceReportSectionSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding EvidenceReport: " + i)
      }
    }
    return EvidenceReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on EvidenceReport"),
      useContext = useContext ?: listOf(),
      identifier = identifier ?: listOf(),
      relatedIdentifier = relatedIdentifier ?: listOf(),
      citeAs =
        EvidenceReport.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      type = type,
      note = note ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on EvidenceReport"),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      author = author ?: listOf(),
      editor = editor ?: listOf(),
      reviewer = reviewer ?: listOf(),
      endorser = endorser ?: listOf(),
      relatesTo = relatesTo ?: listOf(),
      section = section ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: EvidenceReport,
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
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.relatedIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.relatedIdentifier,
      )
    when (val choice = value.citeAs) {
      null -> {}
      is EvidenceReport.CiteAs.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
      is EvidenceReport.CiteAs.Markdown -> {
        encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatedArtifact,
      )
    encoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      EvidenceReportSubjectSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.author,
      )
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.editor,
      )
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.reviewer,
      )
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.endorser,
      )
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        EvidenceReportRelatesToSerializer.listSerializer,
        value.relatesTo,
      )
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        EvidenceReportSectionSerializer.listSerializer,
        value.section,
      )
  }
}
