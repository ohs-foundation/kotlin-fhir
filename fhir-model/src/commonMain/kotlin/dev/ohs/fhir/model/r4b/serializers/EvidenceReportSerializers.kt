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

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.EvidenceReport
import dev.ohs.fhir.model.r4b.Extension
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
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
        "characteristic",
        listSerialDescriptor(
          lazyDescriptor { EvidenceReport.Subject.Characteristic.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EvidenceReport.Subject =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Subject) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceReport.Subject {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var characteristic: List<EvidenceReport.Subject.Characteristic>? = null
    var note: List<Annotation>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          characteristic =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.characteristicSer, null)
        4 -> note = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subject: " + __i)
      }
    }
    return EvidenceReport.Subject(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      characteristic = characteristic ?: listOf(),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceReport.Subject) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.characteristic.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.characteristicSer, value.characteristic)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.noteSer, value.note)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val characteristicSerInner: KSerializer<EvidenceReport.Subject.Characteristic> =
      EvidenceReport.Subject.Characteristic.serializer()

    public val characteristicSer: KSerializer<List<EvidenceReport.Subject.Characteristic>> =
      ListSerializer(Hoisted.characteristicSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object EvidenceReportSubjectCharacteristicSerializer :
  KSerializer<EvidenceReport.Subject.Characteristic> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristic") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("exclude", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exclude", Element.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): EvidenceReport.Subject.Characteristic =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Subject.Characteristic) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceReport.Subject.Characteristic {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueReferenceSer, null)
        5 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 -> valueBoolean = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueBooleanSer, null)
        8 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueQuantitySer, null)
        9 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueRangeSer, null)
        10 -> exclude = decoder.decodeBooleanElement(__desc, 10)
        11 ->
          _exclude =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueBooleanSer, null)
        12 ->
          period = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristic: " + __i)
      }
    }
    return EvidenceReport.Subject.Characteristic(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      `value` =
        EvidenceReport.Subject.Characteristic.Value.from(
          valueReference,
          valueCodeableConcept,
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
        )!!,
      exclude = R4bBoolean.of(exclude, _exclude),
      period = period,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: EvidenceReport.Subject.Characteristic,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is EvidenceReport.Subject.Characteristic.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.valueReferenceSer, __d.value)
      }
      is EvidenceReport.Subject.Characteristic.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, __d.value)
      }
      is EvidenceReport.Subject.Characteristic.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueBooleanSer, it)
        }
      }
      is EvidenceReport.Subject.Characteristic.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.valueQuantitySer, __d.value)
      }
      is EvidenceReport.Subject.Characteristic.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueRangeSer, __d.value)
      }
    }
    ((value.exclude?.value))?.let { encoder.encodeBooleanElement(__desc, 10, it) }
    (value.exclude?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.valueBooleanSer, it)
    }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object EvidenceReportRelatesToSerializer : KSerializer<EvidenceReport.RelatesTo> {
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

  override fun deserialize(decoder: Decoder): EvidenceReport.RelatesTo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.RelatesTo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceReport.RelatesTo {
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
    return EvidenceReport.RelatesTo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = Enumeration.of(EvidenceReport.ReportRelationshipType.fromCode(code!!), _code),
      target = EvidenceReport.RelatesTo.Target.from(targetIdentifier, targetReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceReport.RelatesTo) {
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
      is EvidenceReport.RelatesTo.Target.Identifier -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.targetIdentifierSer, __d.value)
      }
      is EvidenceReport.RelatesTo.Target.Reference -> {
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

internal object EvidenceReportSectionSerializer : KSerializer<EvidenceReport.Section> {
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
      element("focus", CodeableConcept.serializer().descriptor, isOptional = true)
      element("focusReference", Reference.serializer().descriptor, isOptional = true)
      element("author", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("orderedBy", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "entryClassifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "entryReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "entryQuantity",
        listSerialDescriptor(Quantity.serializer().descriptor),
        isOptional = true,
      )
      element("emptyReason", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "section",
        listSerialDescriptor(lazyDescriptor { EvidenceReport.Section.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): EvidenceReport.Section =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport.Section) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): EvidenceReport.Section {
    val __desc = descriptor
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
        5 -> focus = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.focusSer, null)
        6 ->
          focusReference =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.focusReferenceSer, null)
        7 -> author = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.authorSer, null)
        8 -> text = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.textSer, null)
        9 -> mode = decoder.decodeStringElement(__desc, 9)
        10 -> _mode = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.titleSer, null)
        11 ->
          orderedBy = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.focusSer, null)
        12 ->
          entryClassifier =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.entryClassifierSer, null)
        13 ->
          entryReference =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.authorSer, null)
        14 ->
          entryQuantity =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.entryQuantitySer, null)
        15 ->
          emptyReason =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.focusSer, null)
        16 ->
          section = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.sectionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Section: " + __i)
      }
    }
    return EvidenceReport.Section(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      title = R4bString.of(title, _title),
      focus = focus,
      focusReference = focusReference,
      author = author ?: listOf(),
      text = text,
      mode = mode?.let { Enumeration.of(EvidenceReport.ListMode.fromCode(it), _mode) },
      orderedBy = orderedBy,
      entryClassifier = entryClassifier ?: listOf(),
      entryReference = entryReference ?: listOf(),
      entryQuantity = entryQuantity ?: listOf(),
      emptyReason = emptyReason,
      section = section ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceReport.Section) {
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
    (value.focus)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.focusSer, it) }
    (value.focusReference)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.focusReferenceSer, it)
    }
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.authorSer, value.author)
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.textSer, it) }
    ((value.mode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.titleSer, it)
    }
    (value.orderedBy)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.focusSer, it) }
    if (value.entryClassifier.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        12,
        Hoisted.entryClassifierSer,
        value.entryClassifier,
      )
    if (value.entryReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.authorSer, value.entryReference)
    if (value.entryQuantity.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.entryQuantitySer, value.entryQuantity)
    (value.emptyReason)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.focusSer, it) }
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.sectionSer, value.section)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val titleSer: KSerializer<Element> = Element.serializer()

    public val focusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val focusReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val authorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.focusReferenceSer)

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val entryClassifierSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.focusSer)

    public val entryQuantitySerInner: KSerializer<Quantity> = Quantity.serializer()

    public val entryQuantitySer: KSerializer<List<Quantity>> =
      ListSerializer(Hoisted.entryQuantitySerInner)

    public val sectionSerInner: KSerializer<EvidenceReport.Section> =
      EvidenceReport.Section.serializer()

    public val sectionSer: KSerializer<List<EvidenceReport.Section>> =
      ListSerializer(Hoisted.sectionSerInner)
  }
}

internal object EvidenceReportSerializer : KSerializer<EvidenceReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EvidenceReport") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatedIdentifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("citeAsReference", Reference.serializer().descriptor, isOptional = true)
    b.element("citeAsMarkdown", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_citeAsMarkdown", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    b.element(
      "relatedArtifact",
      listSerialDescriptor(RelatedArtifact.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "subject",
      lazyDescriptor { EvidenceReport.Subject.serializer().descriptor },
      isOptional = true,
    )
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "author",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "editor",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "reviewer",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "endorser",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relatesTo",
      listSerialDescriptor(lazyDescriptor { EvidenceReport.RelatesTo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "section",
      listSerialDescriptor(lazyDescriptor { EvidenceReport.Section.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): EvidenceReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "EvidenceReport")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): EvidenceReport {
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
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.useContextSer, null)
        16 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.identifierSer, null)
        17 ->
          relatedIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.identifierSer, null)
        18 ->
          citeAsReference =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.citeAsReferenceSer, null)
        19 -> citeAsMarkdown = decoder.decodeStringElement(__desc, 19)
        20 ->
          _citeAsMarkdown =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> type = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.typeSer, null)
        22 -> note = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.noteSer, null)
        23 ->
          relatedArtifact =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.relatedArtifactSer, null)
        24 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subjectSer, null)
        25 -> publisher = decoder.decodeStringElement(__desc, 25)
        26 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.implicitRulesSer, null)
        27 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.contactSer, null)
        28 ->
          author = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.contactSer, null)
        29 ->
          editor = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.contactSer, null)
        30 ->
          reviewer = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.contactSer, null)
        31 ->
          endorser = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.contactSer, null)
        32 ->
          relatesTo =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.relatesToSer, null)
        33 ->
          section = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.sectionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EvidenceReport: " + __i)
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      useContext = useContext ?: listOf(),
      identifier = identifier ?: listOf(),
      relatedIdentifier = relatedIdentifier ?: listOf(),
      citeAs =
        EvidenceReport.CiteAs.from(citeAsReference, Markdown.of(citeAsMarkdown, _citeAsMarkdown)),
      type = type,
      note = note ?: listOf(),
      relatedArtifact = relatedArtifact ?: listOf(),
      subject = subject!!,
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

  internal fun serializeJson(encoder: CompositeEncoder, `value`: EvidenceReport) {
    val __desc = descriptor
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.useContextSer, value.useContext)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.identifierSer, value.identifier)
    if (value.relatedIdentifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.identifierSer, value.relatedIdentifier)
    when (val __d = value.citeAs) {
      null -> {}
      is EvidenceReport.CiteAs.Reference -> {
        encoder.encodeSerializableElement(__desc, 18, Hoisted.citeAsReferenceSer, __d.value)
      }
      is EvidenceReport.CiteAs.Markdown -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
        }
      }
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 21, Hoisted.typeSer, it) }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.noteSer, value.note)
    if (value.relatedArtifact.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        23,
        Hoisted.relatedArtifactSer,
        value.relatedArtifact,
      )
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.subjectSer, it) }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.contactSer, value.contact)
    if (value.author.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.contactSer, value.author)
    if (value.editor.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.contactSer, value.editor)
    if (value.reviewer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.contactSer, value.reviewer)
    if (value.endorser.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.contactSer, value.endorser)
    if (value.relatesTo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.relatesToSer, value.relatesTo)
    if (value.section.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.sectionSer, value.section)
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

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val citeAsReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val relatedArtifactSerInner: KSerializer<RelatedArtifact> = RelatedArtifact.serializer()

    public val relatedArtifactSer: KSerializer<List<RelatedArtifact>> =
      ListSerializer(Hoisted.relatedArtifactSerInner)

    public val subjectSer: KSerializer<EvidenceReport.Subject> = EvidenceReport.Subject.serializer()

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val relatesToSerInner: KSerializer<EvidenceReport.RelatesTo> =
      EvidenceReport.RelatesTo.serializer()

    public val relatesToSer: KSerializer<List<EvidenceReport.RelatesTo>> =
      ListSerializer(Hoisted.relatesToSerInner)

    public val sectionSerInner: KSerializer<EvidenceReport.Section> =
      EvidenceReport.Section.serializer()

    public val sectionSer: KSerializer<List<EvidenceReport.Section>> =
      ListSerializer(Hoisted.sectionSerInner)
  }
}

internal object EvidenceReportPolymorphicSerializer : KSerializer<EvidenceReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EvidenceReport") { EvidenceReportSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: EvidenceReport) {
    encoder.encodeStructure(descriptor) { EvidenceReportSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): EvidenceReport =
    decoder.decodeStructure(descriptor) { EvidenceReportSerializer.deserializeJson(this) }
}
