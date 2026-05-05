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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.List as R5List
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer as builtinsListSerializer
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

internal object ListEntrySerializer : KSerializer<R5List.Entry> {
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

  override fun deserialize(decoder: Decoder): R5List.Entry =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: R5List.Entry) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): R5List.Entry {
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> flag = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.flagSer, null)
        4 -> deleted = decoder.decodeBooleanElement(__desc, __i)
        5 ->
          _deleted =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deletedSer, null)
        6 -> date = decoder.decodeStringElement(__desc, __i)
        7 ->
          _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.deletedSer, null)
        8 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + __i)
      }
    }
    return R5List.Entry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      flag = flag,
      deleted = R5Boolean.of(deleted, _deleted),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      item = item!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: R5List.Entry) {
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
      builtinsListSerializer(Hoisted.extensionSerInner)

    public val flagSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val deletedSer: KSerializer<Element> = Element.serializer()

    public val itemSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object ListSerializer : KSerializer<R5List> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("List") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("mode", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_mode", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("source", Reference.serializer().descriptor, isOptional = true)
    b.element("orderedBy", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "entry",
      listSerialDescriptor(lazyDescriptor { R5List.Entry.serializer().descriptor }),
      isOptional = true,
    )
    b.element("emptyReason", CodeableConcept.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): R5List =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: R5List) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "List")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): R5List {
    val __desc = desc
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
    var subject: CollectionsList<Reference>? = null
    var encounter: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var source: Reference? = null
    var orderedBy: CodeableConcept? = null
    var note: CollectionsList<Annotation>? = null
    var entry: CollectionsList<R5List.Entry>? = null
    var emptyReason: CodeableConcept? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> mode = decoder.decodeStringElement(__desc, __i)
        14 ->
          _mode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> title = decoder.decodeStringElement(__desc, __i)
        16 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSerInner, null)
        20 -> date = decoder.decodeStringElement(__desc, __i)
        21 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        22 ->
          source =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSerInner, null)
        23 ->
          orderedBy = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        24 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        25 -> entry = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.entrySer, null)
        26 ->
          emptyReason =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        else -> throw SerializationException("Unexpected index decoding List: " + __i)
      }
    }
    return R5List(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(R5List.ListStatus.fromCode(status!!), _status),
      mode = Enumeration.of(R5List.ListMode.fromCode(mode!!), _mode),
      title = R5String.of(title, _title),
      code = code,
      subject = subject ?: listOf(),
      encounter = encounter,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      source = source,
      orderedBy = orderedBy,
      note = note ?: listOf(),
      entry = entry ?: listOf(),
      emptyReason = emptyReason,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: R5List,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.codeSer, it) }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.subjectSer, value.subject)
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.subjectSerInner, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20 + __off, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.subjectSerInner, it)
    }
    (value.orderedBy)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.codeSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.noteSer, value.note)
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.entrySer, value.entry)
    (value.emptyReason)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.codeSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<CollectionsList<Resource>> =
      builtinsListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<CollectionsList<Extension>> =
      builtinsListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<CollectionsList<Identifier>> =
      builtinsListSerializer(Hoisted.identifierSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSerInner: KSerializer<Reference> = Reference.serializer()

    public val subjectSer: KSerializer<CollectionsList<Reference>> =
      builtinsListSerializer(Hoisted.subjectSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<CollectionsList<Annotation>> =
      builtinsListSerializer(Hoisted.noteSerInner)

    public val entrySerInner: KSerializer<R5List.Entry> = R5List.Entry.serializer()

    public val entrySer: KSerializer<CollectionsList<R5List.Entry>> =
      builtinsListSerializer(Hoisted.entrySerInner)
  }
}

internal object ListPolymorphicSerializer : KSerializer<R5List> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("List") { ListSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: R5List) {
    encoder.encodeStructure(descriptor) { ListSerializer.serializeJson(this, descriptor, 0, value) }
  }

  override fun deserialize(decoder: Decoder): R5List =
    decoder.decodeStructure(descriptor) { ListSerializer.deserializeJson(this, descriptor, 0) }
}
