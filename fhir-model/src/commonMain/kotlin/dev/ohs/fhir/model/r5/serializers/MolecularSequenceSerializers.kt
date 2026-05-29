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
@file:OptIn(ExperimentalSerializationApi::class)

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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Relative {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          coordinateSystem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.coordinateSystemSer,
              null,
            )
        4 -> ordinalPosition = decoder.decodeIntElement(descriptor, i)
        5 ->
          _ordinalPosition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.ordinalPositionSer,
              null,
            )
        6 ->
          sequenceRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceRangeSer, null)
        7 ->
          startingSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.startingSequenceSer,
              null,
            )
        8 -> edit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.editSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Relative: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MolecularSequence.Relative) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(
      descriptor,
      3,
      Hoisted.coordinateSystemSer,
      value.coordinateSystem,
    )
    ((value.ordinalPosition?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.ordinalPosition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.ordinalPositionSer, it)
    }
    (value.sequenceRange)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.sequenceRangeSer, it)
    }
    (value.startingSequence)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.startingSequenceSer, it)
    }
    if (value.edit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.editSer, value.edit)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.StartingSequence) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MolecularSequence.Relative.StartingSequence {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          genomeAssembly =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.genomeAssemblySer,
              null,
            )
        4 ->
          chromosome =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.genomeAssemblySer,
              null,
            )
        5 ->
          sequenceCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.genomeAssemblySer,
              null,
            )
        6 -> sequenceString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _sequenceString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceStringSer,
              null,
            )
        8 ->
          sequenceReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceReferenceSer,
              null,
            )
        9 -> windowStart = decoder.decodeIntElement(descriptor, i)
        10 ->
          _windowStart =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceStringSer,
              null,
            )
        11 -> windowEnd = decoder.decodeIntElement(descriptor, i)
        12 ->
          _windowEnd =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceStringSer,
              null,
            )
        13 -> orientation = decoder.decodeStringElement(descriptor, i)
        14 ->
          _orientation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceStringSer,
              null,
            )
        15 -> strand = decoder.decodeStringElement(descriptor, i)
        16 ->
          _strand =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.sequenceStringSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StartingSequence: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.Relative.StartingSequence,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.genomeAssembly)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.genomeAssemblySer, it)
    }
    (value.chromosome)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.genomeAssemblySer, it)
    }
    when (val choice = value.sequence) {
      null -> {}
      is MolecularSequence.Relative.StartingSequence.Sequence.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.genomeAssemblySer, choice.value)
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceStringSer, it)
        }
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.Reference -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.sequenceReferenceSer, choice.value)
      }
    }
    ((value.windowStart?.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
    (value.windowStart?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.sequenceStringSer, it)
    }
    ((value.windowEnd?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.windowEnd?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.sequenceStringSer, it)
    }
    ((value.orientation?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.orientation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.sequenceStringSer, it)
    }
    ((value.strand?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.strand?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.sequenceStringSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.Edit) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Relative.Edit {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> start = decoder.decodeIntElement(descriptor, i)
        4 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        5 -> end = decoder.decodeIntElement(descriptor, i)
        6 -> _end = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        7 -> replacementSequence = decoder.decodeStringElement(descriptor, i)
        8 ->
          _replacementSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        9 -> replacedSequence = decoder.decodeStringElement(descriptor, i)
        10 ->
          _replacedSequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Edit: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.Relative.Edit,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.start?.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.startSer, it)
    }
    ((value.end?.value))?.let { encoder.encodeIntElement(descriptor, 5, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.startSer, it)
    }
    ((value.replacementSequence?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.replacementSequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.startSer, it)
    }
    ((value.replacedSequence?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.replacedSequence?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.startSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MolecularSequence")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MolecularSequence {
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
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeStringElement(descriptor, i)
        12 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        14 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focusSer, null)
        15 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        16 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        17 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        18 -> literal = decoder.decodeStringElement(descriptor, i)
        19 ->
          _literal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          formatted =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formattedSer, null)
        21 ->
          relative =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relativeSer, null)
        else -> throw SerializationException("Unexpected index decoding MolecularSequence: " + i)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MolecularSequence,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.type?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.subjectSer, it)
    }
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.focusSer,
        value.focus,
      )
    (value.specimen)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.literal?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.literal?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.formatted.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.formattedSer,
        value.formatted,
      )
    if (value.relative.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.relativeSer,
        value.relative,
      )
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
    encoder.encodeStructure(descriptor) {
      MolecularSequenceSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MolecularSequence =
    decoder.decodeStructure(descriptor) {
      MolecularSequenceSerializer.deserializeInternal(this, descriptor, 0)
    }
}
