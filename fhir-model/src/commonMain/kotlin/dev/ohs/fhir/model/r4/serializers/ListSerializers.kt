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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.List as R4List
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
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

internal object ListEntrySerializer : KSerializer<R4List.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
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
      element("flag", CodeableConcept.serializer().descriptor, isOptional = true)
      element("deleted", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_deleted", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("item", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): R4List.Entry =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: R4List.Entry) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): R4List.Entry {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: CollectionsList<Extension>? = null
    var modifierExtension: CollectionsList<Extension>? = null
    var flag: CodeableConcept? = null
    var deleted: KotlinBoolean? = null
    var _deleted: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var item: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> flag = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.flagSer, null)
        4 -> deleted = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _deleted = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.deletedSer, null)
        6 -> date = decoder.decodeStringElement(__desc, 6)
        7 -> _date = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.deletedSer, null)
        8 -> item = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + __i)
      }
    }
    return R4List.Entry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      flag = flag,
      deleted = R4Boolean.of(deleted, _deleted),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      item = item!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: R4List.Entry) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.flag)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.flagSer, it) }
    ((value.deleted?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.deleted?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.deletedSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.deletedSer, it)
    }
    (value.item)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.itemSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<CollectionsList<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val flagSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val deletedSer: KSerializer<Element> = Element.serializer()

    public val itemSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ListSerializer : KSerializer<R4List> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("List") {
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("source", Reference.serializer().descriptor, isOptional = true)
      element("orderedBy", CodeableConcept.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "entry",
        listSerialDescriptor(lazyDescriptor { R4List.Entry.serializer().descriptor }),
        isOptional = true,
      )
      element("emptyReason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): R4List =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: R4List) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): R4List {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: CollectionsList<Resource>? = null
    var extension: CollectionsList<Extension>? = null
    var modifierExtension: CollectionsList<Extension>? = null
    var identifier: CollectionsList<Identifier>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var source: Reference? = null
    var orderedBy: CodeableConcept? = null
    var note: CollectionsList<Annotation>? = null
    var entry: CollectionsList<R4List.Entry>? = null
    var emptyReason: CodeableConcept? = null
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> mode = decoder.decodeStringElement(__desc, 14)
        15 ->
          _mode =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(__desc, 16)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> code = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.codeSer, null)
        19 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.subjectSer, null)
        20 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 -> date = decoder.decodeStringElement(__desc, 21)
        22 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          source = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.subjectSer, null)
        24 ->
          orderedBy = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.codeSer, null)
        25 -> note = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.noteSer, null)
        26 -> entry = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.entrySer, null)
        27 ->
          emptyReason = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding List: " + __i)
      }
    }
    return R4List(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(R4List.ListStatus.fromCode(status!!), _status),
      mode = Enumeration.of(R4List.ListMode.fromCode(mode!!), _mode),
      title = R4String.of(title, _title),
      code = code,
      subject = subject,
      encounter = encounter,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      source = source,
      orderedBy = orderedBy,
      note = note ?: listOf(),
      entry = entry ?: listOf(),
      emptyReason = emptyReason,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: R4List) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "List")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.codeSer, it) }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.source)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.subjectSer, it) }
    (value.orderedBy)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.codeSer, it) }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.noteSer, value.note)
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.entrySer, value.entry)
    (value.emptyReason)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<CollectionsList<Resource>> =
      ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<CollectionsList<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<CollectionsList<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<CollectionsList<Annotation>> =
      ListSerializer(Hoisted.noteSerInner)

    public val entrySerInner: KSerializer<R4List.Entry> = R4List.Entry.serializer()

    public val entrySer: KSerializer<CollectionsList<R4List.Entry>> =
      ListSerializer(Hoisted.entrySerInner)
  }
}
