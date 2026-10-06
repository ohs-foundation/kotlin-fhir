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
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Composition
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
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
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

internal object CompositionAttesterSerializer : KSerializer<Composition.Attester> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Attester") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", CodeableConceptSerializer.descriptor)
      optionalElement("time", KotlinString.serializer().descriptor)
      optionalElement("_time", ElementSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Composition.Attester>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Attester =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var mode: CodeableConcept? = null
      var time: KotlinString? = null
      var _time: Element? = null
      var party: Reference? = null
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
            mode = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> time = decodeStringElement(descriptor, i)
          5 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Attester: " + i)
        }
      }
      Composition.Attester(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          mode
            ?: throw SerializationException(
              "Missing required property 'mode' on Composition.Attester"
            ),
        time = DateTime.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
        party = party,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Attester) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.mode)
      encodeStringIfNotNull(descriptor, 4, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 5, value.time)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.party)
    }
  }
}

internal object CompositionEventSerializer : KSerializer<Composition.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("detail", CodeableReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Composition.Event>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Event =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var period: Period? = null
      var detail: List<CodeableReference>? = null
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
          3 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          4 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Event: " + i)
        }
      }
      Composition.Event(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        period = period,
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Event) {
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
      encodeSerializableIfNotNull(descriptor, 3, PeriodSerializer, value.period)
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableReferenceSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object CompositionSectionSerializer : KSerializer<Composition.Section> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Section") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("title", KotlinString.serializer().descriptor)
      optionalElement("_title", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("author", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("focus", ReferenceSerializer.descriptor)
      optionalElement("text", NarrativeSerializer.descriptor)
      optionalElement("orderedBy", CodeableConceptSerializer.descriptor)
      optionalElement("entry", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("emptyReason", CodeableConceptSerializer.descriptor)
      optionalElement(
        "section",
        listSerialDescriptor(lazyDescriptor { CompositionSectionSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Composition.Section>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Section =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var title: KotlinString? = null
      var _title: Element? = null
      var code: CodeableConcept? = null
      var author: List<Reference>? = null
      var focus: Reference? = null
      var text: Narrative? = null
      var orderedBy: CodeableConcept? = null
      var entry: List<Reference>? = null
      var emptyReason: CodeableConcept? = null
      var section: List<Composition.Section>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            author =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          7 -> focus = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 -> text = decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
          9 ->
            orderedBy =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            entry =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          11 ->
            emptyReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            section =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CompositionSectionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Section: " + i)
        }
      }
      Composition.Section(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        title = R5String.of(title, _title),
        code = code,
        author = author ?: listOf(),
        focus = focus,
        text = text,
        orderedBy = orderedBy,
        entry = entry ?: listOf(),
        emptyReason = emptyReason,
        section = section ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Section) {
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
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      if (value.author.isNotEmpty())
        encodeSerializableElement(descriptor, 6, ReferenceSerializer.listSerializer, value.author)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.focus)
      encodeSerializableIfNotNull(descriptor, 8, NarrativeSerializer, value.text)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.orderedBy)
      if (value.entry.isNotEmpty())
        encodeSerializableElement(descriptor, 10, ReferenceSerializer.listSerializer, value.entry)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.emptyReason)
      if (value.section.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CompositionSectionSerializer.listSerializer,
          value.section,
        )
    }
  }
}

internal object CompositionSerializer : FhirResourceSerializer<Composition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Composition")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("attester", CompositionAttesterSerializer.listSerializer.descriptor)
    b.optionalElement("custodian", ReferenceSerializer.descriptor)
    b.optionalElement("relatesTo", RelatedArtifactSerializer.listSerializer.descriptor)
    b.optionalElement("event", CompositionEventSerializer.listSerializer.descriptor)
    b.optionalElement("section", CompositionSectionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Composition {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var subject: List<Reference>? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var useContext: List<UsageContext>? = null
    var author: List<Reference>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var note: List<Annotation>? = null
    var attester: List<Composition.Attester>? = null
    var custodian: Reference? = null
    var relatesTo: List<RelatedArtifact>? = null
    var event: List<Composition.Event>? = null
    var section: List<Composition.Section>? = null
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
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> date = decoder.decodeStringElement(descriptor, i)
        22 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        24 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 -> name = decoder.decodeStringElement(descriptor, i)
        26 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> title = decoder.decodeStringElement(descriptor, i)
        28 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        30 ->
          attester =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionAttesterSerializer.listSerializer,
              null,
            )
        31 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RelatedArtifactSerializer.listSerializer,
              null,
            )
        33 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionEventSerializer.listSerializer,
              null,
            )
        34 ->
          section =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionSectionSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Composition: " + i)
      }
    }
    return Composition(
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
      version = R5String.of(version, _version),
      status =
        Enumeration.of(
          if (status != null) Composition.CompositionStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Composition"),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Composition"),
      category = category ?: listOf(),
      subject = subject ?: listOf(),
      encounter = encounter,
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException("Missing required property 'date' on Composition"),
      useContext = useContext ?: listOf(),
      author = author ?: listOf(),
      name = R5String.of(name, _name),
      title =
        R5String.of(title, _title)
          ?: throw SerializationException("Missing required property 'title' on Composition"),
      note = note ?: listOf(),
      attester = attester ?: listOf(),
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      event = event ?: listOf(),
      section = section ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Composition,
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.date.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.date)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.author,
      )
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.title.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.title)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        CompositionAttesterSerializer.listSerializer,
        value.attester,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.custodian,
    )
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        RelatedArtifactSerializer.listSerializer,
        value.relatesTo,
      )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        CompositionEventSerializer.listSerializer,
        value.event,
      )
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        CompositionSectionSerializer.listSerializer,
        value.section,
      )
  }
}
