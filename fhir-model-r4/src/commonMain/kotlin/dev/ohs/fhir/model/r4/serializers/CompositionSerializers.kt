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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("time", KotlinString.serializer().descriptor, isOptional = true)
      element("_time", Element.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Composition.Attester>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Attester =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Attester) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Composition.Attester {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var time: KotlinString? = null
    var _time: Element? = null
    var party: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> time = decoder.decodeStringElement(descriptor, i)
        6 ->
          _time = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          party =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attester: " + i)
      }
    }
    return Composition.Attester(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode =
        Enumeration.of(mode?.let { Composition.CompositionAttestationMode.fromCode(it) }, _mode)
          ?: throw SerializationException(
            "Missing required property 'mode' on Composition.Attester"
          ),
      time = DateTime.of(time?.let { FhirDateTime.fromString(it) }, _time),
      party = party,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Composition.Attester) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.mode.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, it) }
  }
}

internal object CompositionRelatesToSerializer : KSerializer<Composition.RelatesTo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatesTo") {
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
      element("code", KotlinString.serializer().descriptor, isOptional = true)
      element("_code", Element.serializer().descriptor, isOptional = true)
      element("targetIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("targetReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Composition.RelatesTo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.RelatesTo =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Composition.RelatesTo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var targetIdentifier: Identifier? = null
    var targetReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> code = decoder.decodeStringElement(descriptor, i)
        4 ->
          _code = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          targetIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        6 ->
          targetReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + i)
      }
    }
    return Composition.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        Enumeration.of(code?.let { Composition.DocumentRelationshipType.fromCode(it) }, _code)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Composition.RelatesTo) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.code.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    when (val choice = value.target) {
      is Composition.RelatesTo.Target.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 5, IdentifierSerializer, choice.value)
      }
      is Composition.RelatesTo.Target.Reference -> {
        encoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
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
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("period", Period.serializer().descriptor, isOptional = true)
      element("detail", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Composition.Event>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Event =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Event) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Composition.Event {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: List<CodeableConcept>? = null
    var period: Period? = null
    var detail: List<Reference>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        4 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        5 ->
          detail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + i)
      }
    }
    return Composition.Event(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code ?: listOf(),
      period = period,
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Composition.Event) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, PeriodSerializer, it) }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        ReferenceSerializer.listSerializer,
        value.detail,
      )
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("orderedBy", CodeableConcept.serializer().descriptor, isOptional = true)
      element("entry", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("emptyReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "section",
        listSerialDescriptor(lazyDescriptor { Composition.Section.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Composition.Section>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Composition.Section =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Composition.Section) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Composition.Section {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> title = decoder.decodeStringElement(descriptor, i)
        4 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        7 ->
          focus =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        8 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        9 -> mode = decoder.decodeStringElement(descriptor, i)
        10 ->
          _mode = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          orderedBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          entry =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 ->
          emptyReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          section =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CompositionSectionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Section: " + i)
      }
    }
    return Composition.Section(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R4String.of(title, _title),
      code = code,
      author = author ?: listOf(),
      focus = focus,
      text = text,
      mode = Enumeration.of(mode?.let { Composition.ListMode.fromCode(it) }, _mode),
      orderedBy = orderedBy,
      entry = entry ?: listOf(),
      emptyReason = emptyReason,
      section = section ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Composition.Section) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.title?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        ReferenceSerializer.listSerializer,
        value.author,
      )
    (value.focus)?.let { encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, it) }
    (value.text)?.let { encoder.encodeSerializableElement(descriptor, 8, NarrativeSerializer, it) }
    ((value.mode?.value?.code))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    (value.orderedBy)?.let {
      encoder.encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, it)
    }
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        ReferenceSerializer.listSerializer,
        value.entry,
      )
    (value.emptyReason)?.let {
      encoder.encodeSerializableElement(descriptor, 13, CodeableConceptSerializer, it)
    }
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14,
        CompositionSectionSerializer.listSerializer,
        value.section,
      )
  }
}

internal object CompositionSerializer : KSerializer<Composition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Composition") {
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
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("confidentiality", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_confidentiality", Element.serializer().descriptor, isOptional = true)
    b.element(
      "attester",
      listSerialDescriptor(lazyDescriptor { Composition.Attester.serializer().descriptor }),
      isOptional = true,
    )
    b.element("custodian", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "relatesTo",
      listSerialDescriptor(lazyDescriptor { Composition.RelatesTo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "event",
      listSerialDescriptor(lazyDescriptor { Composition.Event.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "section",
      listSerialDescriptor(lazyDescriptor { Composition.Section.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Composition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Composition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Composition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        Enumeration.of(status?.let { Composition.CompositionStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Composition"),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Composition"),
      category = category ?: listOf(),
      subject = subject,
      encounter = encounter,
      date =
        DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date)
          ?: throw SerializationException("Missing required property 'date' on Composition"),
      author = author ?: listOf(),
      title =
        R4String.of(title, _title)
          ?: throw SerializationException("Missing required property 'title' on Composition"),
      confidentiality =
        Enumeration.of(
          confidentiality?.let { Composition.V3ConfidentialityClassification.fromCode(it) },
          _confidentiality,
        ),
      attester = attester ?: listOf(),
      custodian = custodian,
      relatesTo = relatesTo ?: listOf(),
      event = event ?: listOf(),
      section = section ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Composition,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 10 + descriptorOffset, IdentifierSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
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
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.date.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ElementSerializer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.author,
      )
    ((value.title.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ElementSerializer, it)
    }
    ((value.confidentiality?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.confidentiality?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CompositionAttesterSerializer.listSerializer,
        value.attester,
      )
    (value.custodian)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, ReferenceSerializer, it)
    }
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

internal object CompositionPolymorphicSerializer : KSerializer<Composition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Composition") { CompositionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Composition) {
    encoder.encodeStructure(descriptor) {
      CompositionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Composition =
    decoder.decodeStructure(descriptor) {
      CompositionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
