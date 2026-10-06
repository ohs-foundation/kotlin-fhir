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
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.List as R4bList
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List as CollectionsList
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

internal object ListEntrySerializer : KSerializer<R4bList.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("flag", CodeableConceptSerializer.descriptor)
      optionalElement("deleted", KotlinBoolean.serializer().descriptor)
      optionalElement("_deleted", ElementSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("item", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<CollectionsList<R4bList.Entry>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): R4bList.Entry =
    decoder.decodeStructure(descriptor) {
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
            flag = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> deleted = decodeBooleanElement(descriptor, i)
          5 -> _deleted = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> date = decodeStringElement(descriptor, i)
          7 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> item = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Entry: " + i)
        }
      }
      R4bList.Entry(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        flag = flag,
        deleted = R4bBoolean.of(deleted, _deleted),
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
        item =
          item ?: throw SerializationException("Missing required property 'item' on List.Entry"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: R4bList.Entry) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.flag)
      encodeBooleanIfNotNull(descriptor, 4, value.deleted?.value)
      encodeElementIfNotNull(descriptor, 5, value.deleted)
      encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.date)
      encodeSerializableElement(descriptor, 8, ReferenceSerializer, value.item)
    }
  }
}

internal object ListSerializer : FhirResourceSerializer<R4bList> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("List")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("mode", KotlinString.serializer().descriptor)
    b.optionalElement("_mode", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.descriptor)
    b.optionalElement("orderedBy", CodeableConceptSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("entry", ListEntrySerializer.listSerializer.descriptor)
    b.optionalElement("emptyReason", CodeableConceptSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): R4bList {
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
    var entry: CollectionsList<R4bList.Entry>? = null
    var emptyReason: CodeableConcept? = null
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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> mode = decoder.decodeStringElement(descriptor, i)
        14 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> title = decoder.decodeStringElement(descriptor, i)
        16 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 -> date = decoder.decodeStringElement(descriptor, i)
        21 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          source =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          orderedBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        25 ->
          entry =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ListEntrySerializer.listSerializer,
              null,
            )
        26 ->
          emptyReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding List: " + i)
      }
    }
    return R4bList(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(if (status != null) R4bList.ListStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on List"),
      mode =
        Enumeration.of(if (mode != null) R4bList.ListMode.fromCode(mode) else null, _mode)
          ?: throw SerializationException("Missing required property 'mode' on List"),
      title = R4bString.of(title, _title),
      code = code,
      subject = subject,
      encounter = encounter,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      source = source,
      orderedBy = orderedBy,
      note = note ?: listOf(),
      entry = entry ?: listOf(),
      emptyReason = emptyReason,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: R4bList,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.mode.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.mode)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.title)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.source,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.orderedBy,
    )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ListEntrySerializer.listSerializer,
        value.entry,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.emptyReason,
    )
  }
}
