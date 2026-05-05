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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.MolecularSequence
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Int
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

internal object MolecularSequenceRelativeSerializer : KSerializer<MolecularSequence.Relative> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Relative") {
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
      element("coordinateSystem", CodeableConcept.serializer().descriptor, isOptional = true)
      element("ordinalPosition", Int.serializer().descriptor, isOptional = true)
      element("_ordinalPosition", Element.serializer().descriptor, isOptional = true)
      element("sequenceRange", Range.serializer().descriptor, isOptional = true)
      element(
        "startingSequence",
        lazyDescriptor { MolecularSequence.Relative.StartingSequence.serializer().descriptor },
        isOptional = true,
      )
      element(
        "edit",
        listSerialDescriptor(
          lazyDescriptor { MolecularSequence.Relative.Edit.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MolecularSequence.Relative {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coordinateSystem: CodeableConcept? = null
    var ordinalPosition: Int? = null
    var _ordinalPosition: Element? = null
    var sequenceRange: Range? = null
    var startingSequence: MolecularSequence.Relative.StartingSequence? = null
    var edit: List<MolecularSequence.Relative.Edit>? = null
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
          coordinateSystem =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.coordinateSystemSer, null)
        4 -> ordinalPosition = decoder.decodeIntElement(__desc, 4)
        5 ->
          _ordinalPosition =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.ordinalPositionSer, null)
        6 ->
          sequenceRange =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sequenceRangeSer, null)
        7 ->
          startingSequence =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.startingSequenceSer, null)
        8 -> edit = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.editSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relative: " + __i)
      }
    }
    return MolecularSequence.Relative(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coordinateSystem = coordinateSystem!!,
      ordinalPosition = Integer.of(ordinalPosition, _ordinalPosition),
      sequenceRange = sequenceRange,
      startingSequence = startingSequence,
      edit = edit ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MolecularSequence.Relative) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.coordinateSystem)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.coordinateSystemSer, it)
    }
    ((value.ordinalPosition?.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
    (value.ordinalPosition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.ordinalPositionSer, it)
    }
    (value.sequenceRange)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.sequenceRangeSer, it)
    }
    (value.startingSequence)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.startingSequenceSer, it)
    }
    if (value.edit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.editSer, value.edit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val coordinateSystemSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val ordinalPositionSer: KSerializer<Element> = Element.serializer()

    public val sequenceRangeSer: KSerializer<Range> = Range.serializer()

    public val startingSequenceSer: KSerializer<MolecularSequence.Relative.StartingSequence> =
      MolecularSequence.Relative.StartingSequence.serializer()

    public val editSerInner: KSerializer<MolecularSequence.Relative.Edit> =
      MolecularSequence.Relative.Edit.serializer()

    public val editSer: KSerializer<List<MolecularSequence.Relative.Edit>> =
      ListSerializer(Hoisted.editSerInner)
  }
}

internal object MolecularSequenceRelativeStartingSequenceSerializer :
  KSerializer<MolecularSequence.Relative.StartingSequence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StartingSequence") {
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
      element("genomeAssembly", CodeableConcept.serializer().descriptor, isOptional = true)
      element("chromosome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("sequenceCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("sequenceString", KotlinString.serializer().descriptor, isOptional = true)
      element("_sequenceString", Element.serializer().descriptor, isOptional = true)
      element("sequenceReference", Reference.serializer().descriptor, isOptional = true)
      element("windowStart", Int.serializer().descriptor, isOptional = true)
      element("_windowStart", Element.serializer().descriptor, isOptional = true)
      element("windowEnd", Int.serializer().descriptor, isOptional = true)
      element("_windowEnd", Element.serializer().descriptor, isOptional = true)
      element("orientation", KotlinString.serializer().descriptor, isOptional = true)
      element("_orientation", Element.serializer().descriptor, isOptional = true)
      element("strand", KotlinString.serializer().descriptor, isOptional = true)
      element("_strand", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.StartingSequence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.StartingSequence) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MolecularSequence.Relative.StartingSequence {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var genomeAssembly: CodeableConcept? = null
    var chromosome: CodeableConcept? = null
    var sequenceCodeableConcept: CodeableConcept? = null
    var sequenceString: KotlinString? = null
    var _sequenceString: Element? = null
    var sequenceReference: Reference? = null
    var windowStart: Int? = null
    var _windowStart: Element? = null
    var windowEnd: Int? = null
    var _windowEnd: Element? = null
    var orientation: KotlinString? = null
    var _orientation: Element? = null
    var strand: KotlinString? = null
    var _strand: Element? = null
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
          genomeAssembly =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.genomeAssemblySer, null)
        4 ->
          chromosome =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.genomeAssemblySer, null)
        5 ->
          sequenceCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.genomeAssemblySer, null)
        6 -> sequenceString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _sequenceString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.sequenceStringSer, null)
        8 ->
          sequenceReference =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.sequenceReferenceSer, null)
        9 -> windowStart = decoder.decodeIntElement(__desc, 9)
        10 ->
          _windowStart =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.sequenceStringSer, null)
        11 -> windowEnd = decoder.decodeIntElement(__desc, 11)
        12 ->
          _windowEnd =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.sequenceStringSer, null)
        13 -> orientation = decoder.decodeStringElement(__desc, 13)
        14 ->
          _orientation =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.sequenceStringSer, null)
        15 -> strand = decoder.decodeStringElement(__desc, 15)
        16 ->
          _strand =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.sequenceStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StartingSequence: " + __i)
      }
    }
    return MolecularSequence.Relative.StartingSequence(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      genomeAssembly = genomeAssembly,
      chromosome = chromosome,
      sequence =
        MolecularSequence.Relative.StartingSequence.Sequence.from(
          sequenceCodeableConcept,
          R5String.of(sequenceString, _sequenceString),
          sequenceReference,
        ),
      windowStart = Integer.of(windowStart, _windowStart),
      windowEnd = Integer.of(windowEnd, _windowEnd),
      orientation =
        orientation?.let {
          Enumeration.of(MolecularSequence.OrientationType.fromCode(it), _orientation)
        },
      strand = strand?.let { Enumeration.of(MolecularSequence.StrandType.fromCode(it), _strand) },
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.Relative.StartingSequence,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.genomeAssembly)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.genomeAssemblySer, it)
    }
    (value.chromosome)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.genomeAssemblySer, it)
    }
    when (val __d = value.sequence) {
      null -> {}
      is MolecularSequence.Relative.StartingSequence.Sequence.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.genomeAssemblySer, __d.value)
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.sequenceStringSer, it)
        }
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.Reference -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.sequenceReferenceSer, __d.value)
      }
    }
    ((value.windowStart?.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
    (value.windowStart?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.sequenceStringSer, it)
    }
    ((value.windowEnd?.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
    (value.windowEnd?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.sequenceStringSer, it)
    }
    ((value.orientation?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.orientation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.sequenceStringSer, it)
    }
    ((value.strand?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.strand?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.sequenceStringSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val genomeAssemblySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val sequenceStringSer: KSerializer<Element> = Element.serializer()

    public val sequenceReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MolecularSequenceRelativeEditSerializer :
  KSerializer<MolecularSequence.Relative.Edit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Edit") {
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
      element("start", Int.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("end", Int.serializer().descriptor, isOptional = true)
      element("_end", Element.serializer().descriptor, isOptional = true)
      element("replacementSequence", KotlinString.serializer().descriptor, isOptional = true)
      element("_replacementSequence", Element.serializer().descriptor, isOptional = true)
      element("replacedSequence", KotlinString.serializer().descriptor, isOptional = true)
      element("_replacedSequence", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.Edit =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.Edit) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MolecularSequence.Relative.Edit {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
    var replacementSequence: KotlinString? = null
    var _replacementSequence: Element? = null
    var replacedSequence: KotlinString? = null
    var _replacedSequence: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> start = decoder.decodeIntElement(__desc, 3)
        4 -> _start = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.startSer, null)
        5 -> end = decoder.decodeIntElement(__desc, 5)
        6 -> _end = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.startSer, null)
        7 -> replacementSequence = decoder.decodeStringElement(__desc, 7)
        8 ->
          _replacementSequence =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.startSer, null)
        9 -> replacedSequence = decoder.decodeStringElement(__desc, 9)
        10 ->
          _replacedSequence =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.startSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Edit: " + __i)
      }
    }
    return MolecularSequence.Relative.Edit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
      replacementSequence = R5String.of(replacementSequence, _replacementSequence),
      replacedSequence = R5String.of(replacedSequence, _replacedSequence),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MolecularSequence.Relative.Edit) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.start?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.startSer, it)
    }
    ((value.end?.value))?.let { encoder.encodeIntElement(__desc, 5, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.startSer, it)
    }
    ((value.replacementSequence?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.replacementSequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.startSer, it)
    }
    ((value.replacedSequence?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.replacedSequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.startSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val startSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MolecularSequenceSerializer : KSerializer<MolecularSequence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MolecularSequence") {
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
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("focus", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("specimen", Reference.serializer().descriptor, isOptional = true)
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element("performer", Reference.serializer().descriptor, isOptional = true)
    b.element("literal", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_literal", Element.serializer().descriptor, isOptional = true)
    b.element(
      "formatted",
      listSerialDescriptor(Attachment.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relative",
      listSerialDescriptor(lazyDescriptor { MolecularSequence.Relative.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MolecularSequence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MolecularSequence")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MolecularSequence {
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
    var identifier: List<Identifier>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var subject: Reference? = null
    var focus: List<Reference>? = null
    var specimen: Reference? = null
    var device: Reference? = null
    var performer: Reference? = null
    var literal: KotlinString? = null
    var _literal: Element? = null
    var formatted: List<Attachment>? = null
    var relative: List<MolecularSequence.Relative>? = null
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
        12 -> type = decoder.decodeStringElement(__desc, 12)
        13 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.subjectSer, null)
        15 -> focus = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.focusSer, null)
        16 ->
          specimen = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.subjectSer, null)
        17 ->
          device = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 -> literal = decoder.decodeStringElement(__desc, 19)
        20 ->
          _literal =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          formatted =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.formattedSer, null)
        22 ->
          relative =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.relativeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MolecularSequence: " + __i)
      }
    }
    return MolecularSequence(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type = type?.let { Enumeration.of(MolecularSequence.SequenceType.fromCode(it), _type) },
      subject = subject,
      focus = focus ?: listOf(),
      specimen = specimen,
      device = device,
      performer = performer,
      literal = R5String.of(literal, _literal),
      formatted = formatted ?: listOf(),
      relative = relative ?: listOf(),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: MolecularSequence) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.subjectSer, it) }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.focusSer, value.focus)
    (value.specimen)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.subjectSer, it) }
    (value.device)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSer, it) }
    (value.performer)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    ((value.literal?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.literal?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    if (value.formatted.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.formattedSer, value.formatted)
    if (value.relative.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 22, Hoisted.relativeSer, value.relative)
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

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val focusSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.subjectSer)

    public val formattedSerInner: KSerializer<Attachment> = Attachment.serializer()

    public val formattedSer: KSerializer<List<Attachment>> =
      ListSerializer(Hoisted.formattedSerInner)

    public val relativeSerInner: KSerializer<MolecularSequence.Relative> =
      MolecularSequence.Relative.serializer()

    public val relativeSer: KSerializer<List<MolecularSequence.Relative>> =
      ListSerializer(Hoisted.relativeSerInner)
  }
}

internal object MolecularSequencePolymorphicSerializer : KSerializer<MolecularSequence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MolecularSequence") {
      MolecularSequenceSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence) {
    encoder.encodeStructure(descriptor) { MolecularSequenceSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): MolecularSequence =
    decoder.decodeStructure(descriptor) { MolecularSequenceSerializer.deserializeJson(this) }
}
