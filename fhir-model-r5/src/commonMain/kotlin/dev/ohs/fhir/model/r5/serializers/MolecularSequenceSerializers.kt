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
import dev.ohs.fhir.model.r5.terminologies.OrientationType
import dev.ohs.fhir.model.r5.terminologies.SequenceType
import dev.ohs.fhir.model.r5.terminologies.StrandType
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MolecularSequenceRelativeSerializer : FhirSerializer<MolecularSequence.Relative> {
  override val descriptor: SerialDescriptor = buildDescriptor("Relative", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Relative>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("coordinateSystem", CodeableConceptSerializer.descriptor)
    b.intPrim("ordinalPosition")
    b.optionalElement("sequenceRange", RangeSerializer.descriptor)
    b.optionalElement(
      "startingSequence",
      MolecularSequenceRelativeStartingSequenceSerializer.descriptor,
    )
    b.optionalElement("edit", MolecularSequenceRelativeEditSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          coordinateSystem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> ordinalPosition = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _ordinalPosition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          sequenceRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        7 ->
          startingSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRelativeStartingSequenceSerializer,
              null,
            )
        8 ->
          edit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRelativeEditSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Relative(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      coordinateSystem =
        required(coordinateSystem, "MolecularSequence.Relative", "coordinateSystem"),
      ordinalPosition = Integer.of(ordinalPosition, _ordinalPosition),
      sequenceRange = sequenceRange,
      startingSequence = startingSequence,
      edit = listOrEmpty(edit),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.coordinateSystem,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.ordinalPosition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.ordinalPosition)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      RangeSerializer,
      value.sequenceRange,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      MolecularSequenceRelativeStartingSequenceSerializer,
      value.startingSequence,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8,
      MolecularSequenceRelativeEditSerializer.listSerializer,
      value.edit,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceRelativeStartingSequenceSerializer :
  FhirSerializer<MolecularSequence.Relative.StartingSequence> {
  override val descriptor: SerialDescriptor = buildDescriptor("StartingSequence", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Relative.StartingSequence>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("genomeAssembly", CodeableConceptSerializer.descriptor)
    b.optionalElement("chromosome", CodeableConceptSerializer.descriptor)
    b.optionalElement("sequenceCodeableConcept", CodeableConceptSerializer.descriptor)
    b.strPrim("sequenceString")
    b.optionalElement("sequenceReference", ReferenceSerializer.descriptor)
    b.intPrim("windowStart")
    b.intPrim("windowEnd")
    b.strPrim("orientation")
    b.strPrim("strand")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.StartingSequence {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var orientation: OrientationType? = null
    var _orientation: Element? = null
    var strand: StrandType? = null
    var _strand: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          genomeAssembly =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          chromosome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          sequenceCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> sequenceString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _sequenceString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          sequenceReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 -> windowStart = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _windowStart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> windowEnd = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _windowEnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          orientation =
            OrientationType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _orientation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> strand = StrandType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _strand =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Relative.StartingSequence(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      orientation = Enumeration.of(orientation, _orientation),
      strand = Enumeration.of(strand, _strand),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.StartingSequence) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.genomeAssembly,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.chromosome,
    )
    when (val choice = value.sequence) {
      null -> {}
      is MolecularSequence.Relative.StartingSequence.Sequence.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is MolecularSequence.Relative.StartingSequence.Sequence.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 9, value.windowStart?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.windowStart)
    compositeEncoder.encodeIntIfNotNull(descriptor, 11, value.windowEnd?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.windowEnd)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.orientation?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.orientation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.strand?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.strand)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceRelativeEditSerializer :
  FhirSerializer<MolecularSequence.Relative.Edit> {
  override val descriptor: SerialDescriptor = buildDescriptor("Edit", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Relative.Edit>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("start")
    b.intPrim("end")
    b.strPrim("replacementSequence")
    b.strPrim("replacedSequence")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Relative.Edit {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> start = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _start =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> end = compositeDecoder.decodeIntElement(descriptor, i)
        6 ->
          _end =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> replacementSequence = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _replacementSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> replacedSequence = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _replacedSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Relative.Edit(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
      replacementSequence = R5String.of(replacementSequence, _replacementSequence),
      replacedSequence = R5String.of(replacedSequence, _replacedSequence),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Relative.Edit) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.start?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.start)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.end?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.end)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.replacementSequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.replacementSequence)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.replacedSequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.replacedSequence)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceSerializer : FhirResourceSerializer<MolecularSequence> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MolecularSequence")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("focus", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.strPrim("literal")
    b.optionalElement("formatted", AttachmentSerializer.listSerializer.descriptor)
    b.optionalElement("relative", MolecularSequenceRelativeSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var type: SequenceType? = null
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> type = SequenceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        14 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          specimen =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 -> literal = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _literal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          formatted =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer.listSerializer,
              null,
            )
        21 ->
          relative =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRelativeSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MolecularSequence(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = Enumeration.of(type, _type),
      subject = subject,
      focus = listOrEmpty(focus),
      specimen = specimen,
      device = device,
      performer = performer,
      literal = R5String.of(literal, _literal),
      formatted = listOrEmpty(formatted),
      relative = listOrEmpty(relative),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MolecularSequence,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.type?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.type)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.focus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.literal?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.literal)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20 + descriptorOffset,
      AttachmentSerializer.listSerializer,
      value.formatted,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      21 + descriptorOffset,
      MolecularSequenceRelativeSerializer.listSerializer,
      value.relative,
    )
  }
}
