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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.MolecularSequence
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("coordinateSystem", CodeableConceptSerializer.descriptor)
      optionalElement("ordinalPosition", Int.serializer().descriptor)
      optionalElement("_ordinalPosition", ElementSerializer.descriptor)
      optionalElement("sequenceRange", RangeSerializer.descriptor)
      optionalElement(
        "startingSequence",
        MolecularSequenceRelativeStartingSequenceSerializer.descriptor,
      )
      optionalElement("edit", MolecularSequenceRelativeEditSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Relative>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative =
    decoder.decodeStructure(descriptor) {
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
            coordinateSystem =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> ordinalPosition = decodeIntElement(descriptor, i)
          5 ->
            _ordinalPosition =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            sequenceRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 ->
            startingSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MolecularSequenceRelativeStartingSequenceSerializer,
                null,
              )
          8 ->
            edit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MolecularSequenceRelativeEditSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Relative: " + i)
        }
      }
      MolecularSequence.Relative(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        coordinateSystem =
          coordinateSystem
            ?: throw SerializationException(
              "Missing required property 'coordinateSystem' on MolecularSequence.Relative"
            ),
        ordinalPosition = Integer.of(ordinalPosition, _ordinalPosition),
        sequenceRange = sequenceRange,
        startingSequence = startingSequence,
        edit = edit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.coordinateSystem)
      encodeIntIfNotNull(descriptor, 4, value.ordinalPosition?.value)
      encodeElementIfNotNull(descriptor, 5, value.ordinalPosition)
      encodeSerializableIfNotNull(descriptor, 6, RangeSerializer, value.sequenceRange)
      encodeSerializableIfNotNull(
        descriptor,
        7,
        MolecularSequenceRelativeStartingSequenceSerializer,
        value.startingSequence,
      )
      if (value.edit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          MolecularSequenceRelativeEditSerializer.listSerializer,
          value.edit,
        )
    }
  }
}

internal object MolecularSequenceRelativeStartingSequenceSerializer :
  KSerializer<MolecularSequence.Relative.StartingSequence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StartingSequence") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("genomeAssembly", CodeableConceptSerializer.descriptor)
      optionalElement("chromosome", CodeableConceptSerializer.descriptor)
      optionalElement("sequenceCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("sequenceString", KotlinString.serializer().descriptor)
      optionalElement("_sequenceString", ElementSerializer.descriptor)
      optionalElement("sequenceReference", ReferenceSerializer.descriptor)
      optionalElement("windowStart", Int.serializer().descriptor)
      optionalElement("_windowStart", ElementSerializer.descriptor)
      optionalElement("windowEnd", Int.serializer().descriptor)
      optionalElement("_windowEnd", ElementSerializer.descriptor)
      optionalElement("orientation", KotlinString.serializer().descriptor)
      optionalElement("_orientation", ElementSerializer.descriptor)
      optionalElement("strand", KotlinString.serializer().descriptor)
      optionalElement("_strand", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Relative.StartingSequence>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.StartingSequence =
    decoder.decodeStructure(descriptor) {
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
            genomeAssembly =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            chromosome =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            sequenceCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> sequenceString = decodeStringElement(descriptor, i)
          7 ->
            _sequenceString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            sequenceReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 -> windowStart = decodeIntElement(descriptor, i)
          10 ->
            _windowStart = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> windowEnd = decodeIntElement(descriptor, i)
          12 ->
            _windowEnd = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> orientation = decodeStringElement(descriptor, i)
          14 ->
            _orientation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> strand = decodeStringElement(descriptor, i)
          16 -> _strand = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StartingSequence: " + i)
        }
      }
      MolecularSequence.Relative.StartingSequence(
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
          Enumeration.of(
            if (orientation != null) MolecularSequence.OrientationType.fromCode(orientation)
            else null,
            _orientation,
          ),
        strand =
          Enumeration.of(
            if (strand != null) MolecularSequence.StrandType.fromCode(strand) else null,
            _strand,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.StartingSequence) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.genomeAssembly)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.chromosome)
      when (val choice = value.sequence) {
        null -> {}
        is MolecularSequence.Relative.StartingSequence.Sequence.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is MolecularSequence.Relative.StartingSequence.Sequence.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is MolecularSequence.Relative.StartingSequence.Sequence.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
      }
      encodeIntIfNotNull(descriptor, 9, value.windowStart?.value)
      encodeElementIfNotNull(descriptor, 10, value.windowStart)
      encodeIntIfNotNull(descriptor, 11, value.windowEnd?.value)
      encodeElementIfNotNull(descriptor, 12, value.windowEnd)
      encodeStringIfNotNull(descriptor, 13, value.orientation?.value?.code)
      encodeElementIfNotNull(descriptor, 14, value.orientation)
      encodeStringIfNotNull(descriptor, 15, value.strand?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.strand)
    }
  }
}

internal object MolecularSequenceRelativeEditSerializer :
  KSerializer<MolecularSequence.Relative.Edit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Edit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("start", Int.serializer().descriptor)
      optionalElement("_start", ElementSerializer.descriptor)
      optionalElement("end", Int.serializer().descriptor)
      optionalElement("_end", ElementSerializer.descriptor)
      optionalElement("replacementSequence", KotlinString.serializer().descriptor)
      optionalElement("_replacementSequence", ElementSerializer.descriptor)
      optionalElement("replacedSequence", KotlinString.serializer().descriptor)
      optionalElement("_replacedSequence", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Relative.Edit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.Edit =
    decoder.decodeStructure(descriptor) {
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
          3 -> start = decodeIntElement(descriptor, i)
          4 -> _start = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> end = decodeIntElement(descriptor, i)
          6 -> _end = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> replacementSequence = decodeStringElement(descriptor, i)
          8 ->
            _replacementSequence =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> replacedSequence = decodeStringElement(descriptor, i)
          10 ->
            _replacedSequence =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Edit: " + i)
        }
      }
      MolecularSequence.Relative.Edit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        start = Integer.of(start, _start),
        end = Integer.of(end, _end),
        replacementSequence = R5String.of(replacementSequence, _replacementSequence),
        replacedSequence = R5String.of(replacedSequence, _replacedSequence),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.Edit) {
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
      encodeIntIfNotNull(descriptor, 3, value.start?.value)
      encodeElementIfNotNull(descriptor, 4, value.start)
      encodeIntIfNotNull(descriptor, 5, value.end?.value)
      encodeElementIfNotNull(descriptor, 6, value.end)
      encodeStringIfNotNull(descriptor, 7, value.replacementSequence?.value)
      encodeElementIfNotNull(descriptor, 8, value.replacementSequence)
      encodeStringIfNotNull(descriptor, 9, value.replacedSequence?.value)
      encodeElementIfNotNull(descriptor, 10, value.replacedSequence)
    }
  }
}

internal object MolecularSequenceSerializer : FhirResourceSerializer<MolecularSequence> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MolecularSequence")

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
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("literal", KotlinString.serializer().descriptor)
    b.optionalElement("_literal", ElementSerializer.descriptor)
    b.optionalElement("formatted", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("relative", MolecularSequenceRelativeSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        11 -> type = decoder.decodeStringElement(descriptor, i)
        12 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        14 ->
          focus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> literal = decoder.decodeStringElement(descriptor, i)
        19 ->
          _literal =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          formatted =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        21 ->
          relative =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRelativeSerializer.listSerializer,
              null,
            )
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
      type =
        Enumeration.of(
          if (type != null) MolecularSequence.SequenceType.fromCode(type) else null,
          _type,
        ),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MolecularSequence,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.type?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.type)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    if (value.focus.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.focus,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.literal?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.literal)
    if (value.formatted.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AttachmentSerializer.listSerializer,
        value.formatted,
      )
    if (value.relative.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        MolecularSequenceRelativeSerializer.listSerializer,
        value.relative,
      )
  }
}
