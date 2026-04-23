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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.RelatedArtifact
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("mode", CodeableConcept.serializer().descriptor, isOptional = true)
      element("time", KotlinString.serializer().descriptor, isOptional = true)
      element("_time", Element.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Composition.Attester =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Composition.Attester) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Composition.Attester {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: CodeableConcept? = null
    var time: KotlinString? = null
    var _time: Element? = null
    var party: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.modeSer, null)
        4 -> time = decoder.decodeStringElement(__desc, 4)
        5 -> _time = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.timeSer, null)
        6 -> party = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attester: " + __i)
      }
    }
    return Composition.Attester(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = mode!!,
      time = DateTime.of(FhirDateTime.fromString(time), _time),
      party = party,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition.Attester) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.mode)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.modeSer, it) }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.timeSer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.partySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val timeSer: KSerializer<Element> = Element.serializer()

    public val partySer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CompositionEventSerializer : KSerializer<Composition.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element(
        "detail",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Composition.Event =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Composition.Event) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Composition.Event {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var period: Period? = null
    var detail: List<CodeableReference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> period = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.periodSer, null)
        4 -> detail = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + __i)
      }
    }
    return Composition.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      period = period,
      detail = detail ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition.Event) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.periodSer, it) }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val detailSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val detailSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.detailSerInner)
  }
}

internal object CompositionSectionSerializer : KSerializer<Composition.Section> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Section") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("focus", Reference.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element("orderedBy", CodeableConcept.serializer().descriptor, isOptional = true)
      element("entry", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("emptyReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "section",
        listSerialDescriptor(lazyDescriptor { Composition.Section.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Composition.Section =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Composition.Section) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Composition.Section {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> title = decoder.decodeStringElement(__desc, 3)
        4 -> _title = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.titleSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 -> author = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.authorSer, null)
        7 ->
          focus = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.authorSerInner, null)
        8 -> text = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.textSer, null)
        9 -> orderedBy = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.codeSer, null)
        10 -> entry = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.authorSer, null)
        11 ->
          emptyReason = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 ->
          section = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.sectionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Section: " + __i)
      }
    }
    return Composition.Section(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition.Section) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.titleSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.authorSer, value.author)
    (value.focus)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.authorSerInner, it) }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.textSer, it) }
    (value.orderedBy)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.codeSer, it) }
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.authorSer, value.entry)
    (value.emptyReason)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it) }
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.sectionSer, value.section)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val authorSerInner: KSerializer<Reference> = Reference.serializer()

    public val authorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.authorSerInner)

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val sectionSerInner: KSerializer<Composition.Section> = Composition.Section.serializer()

    public val sectionSer: KSerializer<List<Composition.Section>> =
      ListSerializer(Hoisted.sectionSerInner)
  }
}

internal object CompositionSerializer : KSerializer<Composition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Composition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "attester",
        listSerialDescriptor(lazyDescriptor { Composition.Attester.serializer().descriptor }),
        isOptional = true,
      )
      element("custodian", Reference.serializer().descriptor, isOptional = true)
      element(
        "relatesTo",
        listSerialDescriptor(RelatedArtifact.serializer().descriptor),
        isOptional = true,
      )
      element(
        "event",
        listSerialDescriptor(lazyDescriptor { Composition.Event.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "section",
        listSerialDescriptor(lazyDescriptor { Composition.Section.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Composition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Composition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Composition {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> status = decoder.decodeStringElement(__desc, 16)
        17 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> type = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.typeSer, null)
        19 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.categorySer, null)
        20 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.subjectSerInner, null)
        22 -> date = decoder.decodeStringElement(__desc, 22)
        23 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.useContextSer, null)
        25 ->
          author = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.subjectSer, null)
        26 -> name = decoder.decodeStringElement(__desc, 26)
        27 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> title = decoder.decodeStringElement(__desc, 28)
        29 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> note = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.noteSer, null)
        31 ->
          attester =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.attesterSer, null)
        32 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.subjectSerInner, null)
        33 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.relatesToSer, null)
        34 -> event = decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.eventSer, null)
        35 ->
          section = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.sectionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Composition: " + __i)
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
      status = Enumeration.of(Composition.CompositionStatus.fromCode(status!!), _status),
      type = type!!,
      category = category ?: listOf(),
      subject = subject ?: listOf(),
      encounter = encounter,
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      useContext = useContext ?: listOf(),
      author = author ?: listOf(),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title)!!,
      note = note ?: listOf(),
      attester = attester ?: listOf(),
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      event = event ?: listOf(),
      section = section ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Composition")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.typeSer, it) }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19, Hoisted.categorySer, value.category)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, value.subject)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.subjectSerInner, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.useContextSer, value.useContext)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.subjectSer, value.author)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.title.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.noteSer, value.note)
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.attesterSer, value.attester)
    (value.custodian)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.subjectSerInner, it)
    }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.relatesToSer, value.relatesTo)
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 34, Hoisted.eventSer, value.event)
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.sectionSer, value.section)
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val attesterSerInner: KSerializer<Composition.Attester> =
      Composition.Attester.serializer()

    public val attesterSer: KSerializer<List<Composition.Attester>> =
      ListSerializer(Hoisted.attesterSerInner)

    public val relatesToSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatesToSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val eventSerInner: KSerializer<Composition.Event> = Composition.Event.serializer()

    public val eventSer: KSerializer<List<Composition.Event>> =
      ListSerializer(Hoisted.eventSerInner)

    public val sectionSerInner: KSerializer<Composition.Section> = Composition.Section.serializer()

    public val sectionSer: KSerializer<List<Composition.Section>> =
      ListSerializer(Hoisted.sectionSerInner)
  }
}
