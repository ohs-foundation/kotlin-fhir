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

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Composition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
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
      var mode: KotlinString? = null
      var _mode: Element? = null
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
          3 -> mode = decodeStringElement(descriptor, i)
          4 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> time = decodeStringElement(descriptor, i)
          6 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Attester: " + i)
        }
      }
      Composition.Attester(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        mode =
          Enumeration.of(
            if (mode != null) Composition.CompositionAttestationMode.fromCode(mode) else null,
            _mode,
          )
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
      encodeStringIfNotNull(descriptor, 3, value.mode.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.mode)
      encodeStringIfNotNull(descriptor, 5, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.time)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.party)
    }
  }
}

internal object CompositionRelatesToSerializer : KSerializer<Composition.RelatesTo> {
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

  internal val listSerializer: KSerializer<List<Composition.RelatesTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.RelatesTo =
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
      Composition.RelatesTo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          Enumeration.of(
            if (code != null) Composition.DocumentRelationshipType.fromCode(code) else null,
            _code,
          )
            ?: throw SerializationException(
              "Missing required property 'code' on Composition.RelatesTo"
            ),
        target =
          Composition.RelatesTo.Target.from(targetIdentifier, targetReference)
            ?: throw SerializationException(
              "Missing required property 'target' on Composition.RelatesTo"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo) {
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
        is Composition.RelatesTo.Target.Identifier -> {
          encodeSerializableElement(descriptor, 5, IdentifierSerializer, choice.value)
        }
        is Composition.RelatesTo.Target.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object CompositionEventSerializer : KSerializer<Composition.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
      optionalElement("detail", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Composition.Event>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Event =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: List<CodeableConcept>? = null
      var period: Period? = null
      var detail: List<Reference>? = null
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
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          5 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
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
        code = code ?: listOf(),
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
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
      if (value.detail.isNotEmpty())
        encodeSerializableElement(descriptor, 5, ReferenceSerializer.listSerializer, value.detail)
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
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
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
      var mode: KotlinString? = null
      var _mode: Element? = null
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
          9 -> mode = decodeStringElement(descriptor, i)
          10 -> _mode = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            orderedBy =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            entry =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          13 ->
            emptyReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
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
        title = R4String.of(title, _title),
        code = code,
        author = author ?: listOf(),
        focus = focus,
        text = text,
        mode =
          Enumeration.of(if (mode != null) Composition.ListMode.fromCode(mode) else null, _mode),
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
      encodeStringIfNotNull(descriptor, 9, value.mode?.value?.code)
      encodeElementIfNotNull(descriptor, 10, value.mode)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.orderedBy)
      if (value.entry.isNotEmpty())
        encodeSerializableElement(descriptor, 12, ReferenceSerializer.listSerializer, value.entry)
      encodeSerializableIfNotNull(descriptor, 13, CodeableConceptSerializer, value.emptyReason)
      if (value.section.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
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
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("confidentiality", KotlinString.serializer().descriptor)
    b.optionalElement("_confidentiality", ElementSerializer.descriptor)
    b.optionalElement("attester", CompositionAttesterSerializer.listSerializer.descriptor)
    b.optionalElement("custodian", ReferenceSerializer.descriptor)
    b.optionalElement("relatesTo", CompositionRelatesToSerializer.listSerializer.descriptor)
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
    var identifier: Identifier? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var author: List<Reference>? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var confidentiality: KotlinString? = null
    var _confidentiality: Element? = null
    var attester: List<Composition.Attester>? = null
    var custodian: Reference? = null
    var relatesTo: List<Composition.RelatesTo>? = null
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        15 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 -> date = decoder.decodeStringElement(descriptor, i)
        18 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> confidentiality = decoder.decodeStringElement(descriptor, i)
        23 ->
          _confidentiality =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          attester =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionAttesterSerializer.listSerializer,
              null,
            )
        25 ->
          custodian =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionRelatesToSerializer.listSerializer,
              null,
            )
        27 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionEventSerializer.listSerializer,
              null,
            )
        28 ->
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
      identifier = identifier,
      status =
        Enumeration.of(
          if (status != null) Composition.CompositionStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Composition"),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Composition"),
      category = category ?: listOf(),
      subject = subject,
      encounter = encounter,
      date =
        DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date)
          ?: throw SerializationException("Missing required property 'date' on Composition"),
      author = author ?: listOf(),
      title =
        R4String.of(title, _title)
          ?: throw SerializationException("Missing required property 'title' on Composition"),
      confidentiality =
        Enumeration.of(
          if (confidentiality != null)
            Composition.V3ConfidentialityClassification.fromCode(confidentiality)
          else null,
          _confidentiality,
        ),
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.date.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.date)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.author,
      )
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.confidentiality?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.confidentiality)
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CompositionAttesterSerializer.listSerializer,
        value.attester,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.custodian,
    )
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CompositionRelatesToSerializer.listSerializer,
        value.relatesTo,
      )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CompositionEventSerializer.listSerializer,
        value.event,
      )
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CompositionSectionSerializer.listSerializer,
        value.section,
      )
  }
}
