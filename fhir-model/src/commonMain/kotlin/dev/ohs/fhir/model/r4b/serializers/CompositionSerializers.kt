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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Composition
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
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
    var mode: KotlinString? = null
    var _mode: Element? = null
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
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 -> time = decoder.decodeStringElement(__desc, 5)
        6 -> _time = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        7 -> party = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.partySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Attester: " + __i)
      }
    }
    return Composition.Attester(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(Composition.CompositionAttestationMode.fromCode(mode!!), _mode),
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
    ((value.mode.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.partySer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()

    public val partySer: KSerializer<Reference> = Reference.serializer()
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

  override fun deserialize(decoder: Decoder): Composition.RelatesTo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Composition.RelatesTo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: KotlinString? = null
    var _code: Element? = null
    var targetIdentifier: Identifier? = null
    var targetReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeStringElement(__desc, 3)
        4 -> _code = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        5 ->
          targetIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.targetIdentifierSer, null)
        6 ->
          targetReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.targetReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatesTo: " + __i)
      }
    }
    return Composition.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(Composition.DocumentRelationshipType.fromCode(code!!), _code),
      target = Composition.RelatesTo.Target.from(targetIdentifier, targetReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition.RelatesTo) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.code.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.code.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it)
    }
    when (val __d = value.target) {
      null -> {}
      is Composition.RelatesTo.Target.Identifier -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.targetIdentifierSer, __d.value)
      }
      is Composition.RelatesTo.Target.Reference -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.targetReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<Element> = Element.serializer()

    public val targetIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val targetReferenceSer: KSerializer<Reference> = Reference.serializer()
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
    var code: List<CodeableConcept>? = null
    var period: Period? = null
    var detail: List<Reference>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        5 -> detail = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Event: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Composition.Event) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, value.code)
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val detailSerInner: KSerializer<Reference> = Reference.serializer()

    public val detailSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.detailSerInner)
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
    var mode: KotlinString? = null
    var _mode: Element? = null
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
        9 -> mode = decoder.decodeStringElement(__desc, 9)
        10 -> _mode = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.titleSer, null)
        11 ->
          orderedBy = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 -> entry = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.authorSer, null)
        13 ->
          emptyReason = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.codeSer, null)
        14 ->
          section = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.sectionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Section: " + __i)
      }
    }
    return Composition.Section(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R4bString.of(title, _title),
      code = code,
      author = author ?: listOf(),
      focus = focus,
      text = text,
      mode = mode?.let { Enumeration.of(Composition.ListMode.fromCode(it), _mode) },
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
    ((value.mode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.titleSer, it)
    }
    (value.orderedBy)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, it) }
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.authorSer, value.entry)
    (value.emptyReason)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.codeSer, it) }
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.sectionSer, value.section)
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

internal object CompositionRelatesToTargetSerializer : KSerializer<Composition.RelatesTo.Target> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Composition.RelatesTo.Target") {
      element("targetIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("targetReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo.Target) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Composition.RelatesTo.Target.Identifier -> {
          encodeSerializableElement(__desc, 0, Hoisted.targetIdentifierSer, __d.value)
        }
        is Composition.RelatesTo.Target.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.targetReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Composition.RelatesTo.Target =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Composition.RelatesTo.Target {
    val __desc = descriptor
    var targetIdentifier: Identifier? = null
    var targetReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          targetIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.targetIdentifierSer, null)
        1 ->
          targetReference =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.targetReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Composition.RelatesTo.Target: " + __i
          )
      }
    }
    return Composition.RelatesTo.Target.from(targetIdentifier, targetReference)!!
  }

  private object Hoisted {
    public val targetIdentifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val targetReferenceSer: KSerializer<Reference> = Reference.serializer()
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "category",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element("confidentiality", KotlinString.serializer().descriptor, isOptional = true)
      element("_confidentiality", Element.serializer().descriptor, isOptional = true)
      element(
        "attester",
        listSerialDescriptor(lazyDescriptor { Composition.Attester.serializer().descriptor }),
        isOptional = true,
      )
      element("custodian", Reference.serializer().descriptor, isOptional = true)
      element(
        "relatesTo",
        listSerialDescriptor(lazyDescriptor { Composition.RelatesTo.serializer().descriptor }),
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
        14 -> type = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.typeSer, null)
        15 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSer, null)
        18 -> date = decoder.decodeStringElement(__desc, 18)
        19 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          author = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.authorSer, null)
        21 -> title = decoder.decodeStringElement(__desc, 21)
        22 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> confidentiality = decoder.decodeStringElement(__desc, 23)
        24 ->
          _confidentiality =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          attester =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.attesterSer, null)
        26 ->
          custodian =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.subjectSer, null)
        27 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.relatesToSer, null)
        28 -> event = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.eventSer, null)
        29 ->
          section = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.sectionSer, null)
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
      identifier = identifier,
      status = Enumeration.of(Composition.CompositionStatus.fromCode(status!!), _status),
      type = type!!,
      category = category ?: listOf(),
      subject = subject,
      encounter = encounter,
      date = DateTime.of(FhirDateTime.fromString(date), _date)!!,
      author = author ?: listOf(),
      title = R4bString.of(title, _title)!!,
      confidentiality =
        confidentiality?.let {
          Enumeration.of(Composition.Confidentiality.fromCode(it), _confidentiality)
        },
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it) }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, value.category)
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSer, it) }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.authorSer, value.author)
    ((value.title.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.title.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.confidentiality?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.confidentiality?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.attester.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.attesterSer, value.attester)
    (value.custodian)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.subjectSer, it) }
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.relatesToSer, value.relatesTo)
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.eventSer, value.event)
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.sectionSer, value.section)
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

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val categorySer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val authorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val attesterSerInner: KSerializer<Composition.Attester> =
      Composition.Attester.serializer()

    public val attesterSer: KSerializer<List<Composition.Attester>> =
      ListSerializer(Hoisted.attesterSerInner)

    public val relatesToSerInner: KSerializer<Composition.RelatesTo> =
      Composition.RelatesTo.serializer()

    public val relatesToSer: KSerializer<List<Composition.RelatesTo>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val eventSerInner: KSerializer<Composition.Event> = Composition.Event.serializer()

    public val eventSer: KSerializer<List<Composition.Event>> =
      ListSerializer(Hoisted.eventSerInner)

    public val sectionSerInner: KSerializer<Composition.Section> = Composition.Section.serializer()

    public val sectionSer: KSerializer<List<Composition.Section>> =
      ListSerializer(Hoisted.sectionSerInner)
  }
}
