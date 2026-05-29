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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.MolecularSequence
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object MolecularSequenceReferenceSeqSerializer :
  KSerializer<MolecularSequence.ReferenceSeq> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceSeq") {
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
      element("chromosome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("genomeBuild", KotlinString.serializer().descriptor, isOptional = true)
      element("_genomeBuild", Element.serializer().descriptor, isOptional = true)
      element("orientation", KotlinString.serializer().descriptor, isOptional = true)
      element("_orientation", Element.serializer().descriptor, isOptional = true)
      element("referenceSeqId", CodeableConcept.serializer().descriptor, isOptional = true)
      element("referenceSeqPointer", Reference.serializer().descriptor, isOptional = true)
      element("referenceSeqString", KotlinString.serializer().descriptor, isOptional = true)
      element("_referenceSeqString", Element.serializer().descriptor, isOptional = true)
      element("strand", KotlinString.serializer().descriptor, isOptional = true)
      element("_strand", Element.serializer().descriptor, isOptional = true)
      element("windowStart", Int.serializer().descriptor, isOptional = true)
      element("_windowStart", Element.serializer().descriptor, isOptional = true)
      element("windowEnd", Int.serializer().descriptor, isOptional = true)
      element("_windowEnd", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.ReferenceSeq =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.ReferenceSeq) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.ReferenceSeq {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var chromosome: CodeableConcept? = null
    var genomeBuild: KotlinString? = null
    var _genomeBuild: Element? = null
    var orientation: KotlinString? = null
    var _orientation: Element? = null
    var referenceSeqId: CodeableConcept? = null
    var referenceSeqPointer: Reference? = null
    var referenceSeqString: KotlinString? = null
    var _referenceSeqString: Element? = null
    var strand: KotlinString? = null
    var _strand: Element? = null
    var windowStart: Int? = null
    var _windowStart: Element? = null
    var windowEnd: Int? = null
    var _windowEnd: Element? = null
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
          chromosome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.chromosomeSer, null)
        4 -> genomeBuild = decoder.decodeStringElement(descriptor, i)
        5 ->
          _genomeBuild =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        6 -> orientation = decoder.decodeStringElement(descriptor, i)
        7 ->
          _orientation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        8 ->
          referenceSeqId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.chromosomeSer, null)
        9 ->
          referenceSeqPointer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.referenceSeqPointerSer,
              null,
            )
        10 -> referenceSeqString = decoder.decodeStringElement(descriptor, i)
        11 ->
          _referenceSeqString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        12 -> strand = decoder.decodeStringElement(descriptor, i)
        13 ->
          _strand =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        14 -> windowStart = decoder.decodeIntElement(descriptor, i)
        15 ->
          _windowStart =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        16 -> windowEnd = decoder.decodeIntElement(descriptor, i)
        17 ->
          _windowEnd =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.genomeBuildSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceSeq: " + i)
      }
    }
    return MolecularSequence.ReferenceSeq(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      chromosome = chromosome,
      genomeBuild = R4bString.of(genomeBuild, _genomeBuild),
      orientation =
        orientation?.let {
          Enumeration.of(MolecularSequence.OrientationType.fromCode(it), _orientation)
        },
      referenceSeqId = referenceSeqId,
      referenceSeqPointer = referenceSeqPointer,
      referenceSeqString = R4bString.of(referenceSeqString, _referenceSeqString),
      strand = strand?.let { Enumeration.of(MolecularSequence.StrandType.fromCode(it), _strand) },
      windowStart = Integer.of(windowStart, _windowStart),
      windowEnd = Integer.of(windowEnd, _windowEnd),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.ReferenceSeq,
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
    (value.chromosome)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.chromosomeSer, it)
    }
    ((value.genomeBuild?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.genomeBuild?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.genomeBuildSer, it)
    }
    ((value.orientation?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.orientation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.genomeBuildSer, it)
    }
    (value.referenceSeqId)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.chromosomeSer, it)
    }
    (value.referenceSeqPointer)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.referenceSeqPointerSer, it)
    }
    ((value.referenceSeqString?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.referenceSeqString?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.genomeBuildSer, it)
    }
    ((value.strand?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.strand?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.genomeBuildSer, it)
    }
    ((value.windowStart?.value))?.let { encoder.encodeIntElement(descriptor, 14, it) }
    (value.windowStart?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.genomeBuildSer, it)
    }
    ((value.windowEnd?.value))?.let { encoder.encodeIntElement(descriptor, 16, it) }
    (value.windowEnd?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.genomeBuildSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val chromosomeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val genomeBuildSer: KSerializer<Element> = Element.serializer()

    public val referenceSeqPointerSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MolecularSequenceVariantSerializer : KSerializer<MolecularSequence.Variant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variant") {
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
      element("observedAllele", KotlinString.serializer().descriptor, isOptional = true)
      element("_observedAllele", Element.serializer().descriptor, isOptional = true)
      element("referenceAllele", KotlinString.serializer().descriptor, isOptional = true)
      element("_referenceAllele", Element.serializer().descriptor, isOptional = true)
      element("cigar", KotlinString.serializer().descriptor, isOptional = true)
      element("_cigar", Element.serializer().descriptor, isOptional = true)
      element("variantPointer", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Variant =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Variant) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Variant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
    var observedAllele: KotlinString? = null
    var _observedAllele: Element? = null
    var referenceAllele: KotlinString? = null
    var _referenceAllele: Element? = null
    var cigar: KotlinString? = null
    var _cigar: Element? = null
    var variantPointer: Reference? = null
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
        7 -> observedAllele = decoder.decodeStringElement(descriptor, i)
        8 ->
          _observedAllele =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        9 -> referenceAllele = decoder.decodeStringElement(descriptor, i)
        10 ->
          _referenceAllele =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        11 -> cigar = decoder.decodeStringElement(descriptor, i)
        12 ->
          _cigar = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.startSer, null)
        13 ->
          variantPointer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.variantPointerSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variant: " + i)
      }
    }
    return MolecularSequence.Variant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
      observedAllele = R4bString.of(observedAllele, _observedAllele),
      referenceAllele = R4bString.of(referenceAllele, _referenceAllele),
      cigar = R4bString.of(cigar, _cigar),
      variantPointer = variantPointer,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MolecularSequence.Variant) {
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
    ((value.observedAllele?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.observedAllele?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.startSer, it)
    }
    ((value.referenceAllele?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.referenceAllele?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.startSer, it)
    }
    ((value.cigar?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.cigar?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.startSer, it)
    }
    (value.variantPointer)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.variantPointerSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val startSer: KSerializer<Element> = Element.serializer()

    public val variantPointerSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MolecularSequenceQualitySerializer : KSerializer<MolecularSequence.Quality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Quality") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("standardSequence", CodeableConcept.serializer().descriptor, isOptional = true)
      element("start", Int.serializer().descriptor, isOptional = true)
      element("_start", Element.serializer().descriptor, isOptional = true)
      element("end", Int.serializer().descriptor, isOptional = true)
      element("_end", Element.serializer().descriptor, isOptional = true)
      element("score", Quantity.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("truthTP", BigDecimalSerializer.descriptor, isOptional = true)
      element("_truthTP", Element.serializer().descriptor, isOptional = true)
      element("queryTP", BigDecimalSerializer.descriptor, isOptional = true)
      element("_queryTP", Element.serializer().descriptor, isOptional = true)
      element("truthFN", BigDecimalSerializer.descriptor, isOptional = true)
      element("_truthFN", Element.serializer().descriptor, isOptional = true)
      element("queryFP", BigDecimalSerializer.descriptor, isOptional = true)
      element("_queryFP", Element.serializer().descriptor, isOptional = true)
      element("gtFP", BigDecimalSerializer.descriptor, isOptional = true)
      element("_gtFP", Element.serializer().descriptor, isOptional = true)
      element("precision", BigDecimalSerializer.descriptor, isOptional = true)
      element("_precision", Element.serializer().descriptor, isOptional = true)
      element("recall", BigDecimalSerializer.descriptor, isOptional = true)
      element("_recall", Element.serializer().descriptor, isOptional = true)
      element("fScore", BigDecimalSerializer.descriptor, isOptional = true)
      element("_fScore", Element.serializer().descriptor, isOptional = true)
      element(
        "roc",
        lazyDescriptor { MolecularSequence.Quality.Roc.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Quality {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var standardSequence: CodeableConcept? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
    var score: Quantity? = null
    var method: CodeableConcept? = null
    var truthTP: BigDecimal? = null
    var _truthTP: Element? = null
    var queryTP: BigDecimal? = null
    var _queryTP: Element? = null
    var truthFN: BigDecimal? = null
    var _truthFN: Element? = null
    var queryFP: BigDecimal? = null
    var _queryFP: Element? = null
    var gtFP: BigDecimal? = null
    var _gtFP: Element? = null
    var precision: BigDecimal? = null
    var _precision: Element? = null
    var recall: BigDecimal? = null
    var _recall: Element? = null
    var fScore: BigDecimal? = null
    var _fScore: Element? = null
    var roc: MolecularSequence.Quality.Roc? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          standardSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.standardSequenceSer,
              null,
            )
        6 -> start = decoder.decodeIntElement(descriptor, i)
        7 ->
          _start = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> end = decoder.decodeIntElement(descriptor, i)
        9 -> _end = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        10 ->
          score = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer, null)
        11 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.standardSequenceSer,
              null,
            )
        12 ->
          truthTP =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        13 ->
          _truthTP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 ->
          queryTP =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        15 ->
          _queryTP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        16 ->
          truthFN =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        17 ->
          _truthFN = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        18 ->
          queryFP =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        19 ->
          _queryFP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        20 ->
          gtFP =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        21 ->
          _gtFP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        22 ->
          precision =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        23 ->
          _precision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        24 ->
          recall =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        25 ->
          _recall = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        26 ->
          fScore =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        27 ->
          _fScore = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        28 -> roc = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.rocSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Quality: " + i)
      }
    }
    return MolecularSequence.Quality(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(MolecularSequence.QualityType.fromCode(type!!), _type),
      standardSequence = standardSequence,
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
      score = score,
      method = method,
      truthTP = Decimal.of(truthTP, _truthTP),
      queryTP = Decimal.of(queryTP, _queryTP),
      truthFN = Decimal.of(truthFN, _truthFN),
      queryFP = Decimal.of(queryFP, _queryFP),
      gtFP = Decimal.of(gtFP, _gtFP),
      precision = Decimal.of(precision, _precision),
      recall = Decimal.of(recall, _recall),
      fScore = Decimal.of(fScore, _fScore),
      roc = roc,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MolecularSequence.Quality) {
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    (value.standardSequence)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.standardSequenceSer, it)
    }
    ((value.start?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.start?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it)
    }
    ((value.end?.value))?.let { encoder.encodeIntElement(descriptor, 8, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.typeSer, it)
    }
    (value.score)?.let { encoder.encodeSerializableElement(descriptor, 10, Hoisted.scoreSer, it) }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.standardSequenceSer, it)
    }
    ((value.truthTP?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 12, BigDecimalSerializer, it)
    }
    (value.truthTP?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.typeSer, it)
    }
    ((value.queryTP?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 14, BigDecimalSerializer, it)
    }
    (value.queryTP?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.typeSer, it)
    }
    ((value.truthFN?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 16, BigDecimalSerializer, it)
    }
    (value.truthFN?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.typeSer, it)
    }
    ((value.queryFP?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 18, BigDecimalSerializer, it)
    }
    (value.queryFP?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.typeSer, it)
    }
    ((value.gtFP?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 20, BigDecimalSerializer, it)
    }
    (value.gtFP?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.typeSer, it)
    }
    ((value.precision?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 22, BigDecimalSerializer, it)
    }
    (value.precision?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.typeSer, it)
    }
    ((value.recall?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 24, BigDecimalSerializer, it)
    }
    (value.recall?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.typeSer, it)
    }
    ((value.fScore?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 26, BigDecimalSerializer, it)
    }
    (value.fScore?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.typeSer, it)
    }
    (value.roc)?.let { encoder.encodeSerializableElement(descriptor, 28, Hoisted.rocSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val standardSequenceSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val scoreSer: KSerializer<Quantity> = Quantity.serializer()

    public val rocSer: KSerializer<MolecularSequence.Quality.Roc> =
      MolecularSequence.Quality.Roc.serializer()
  }
}

internal object MolecularSequenceQualityRocSerializer : KSerializer<MolecularSequence.Quality.Roc> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Roc") {
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
      element("score", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_score", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("numTP", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_numTP", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("numFP", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_numFP", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("numFN", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_numFN", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("precision", listSerialDescriptor(BigDecimalSerializer.descriptor), isOptional = true)
      element(
        "_precision",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "sensitivity",
        listSerialDescriptor(BigDecimalSerializer.descriptor),
        isOptional = true,
      )
      element(
        "_sensitivity",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("fMeasure", listSerialDescriptor(BigDecimalSerializer.descriptor), isOptional = true)
      element("_fMeasure", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality.Roc =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality.Roc) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Quality.Roc {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var score: List<Int?>? = null
    var _score: List<Element?>? = null
    var numTP: List<Int?>? = null
    var _numTP: List<Element?>? = null
    var numFP: List<Int?>? = null
    var _numFP: List<Element?>? = null
    var numFN: List<Int?>? = null
    var _numFN: List<Element?>? = null
    var precision: List<BigDecimal?>? = null
    var _precision: List<Element?>? = null
    var sensitivity: List<BigDecimal?>? = null
    var _sensitivity: List<Element?>? = null
    var fMeasure: List<BigDecimal?>? = null
    var _fMeasure: List<Element?>? = null
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
          score = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer, null)
        4 ->
          _score = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        5 ->
          numTP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer, null)
        6 ->
          _numTP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        7 ->
          numFP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer, null)
        8 ->
          _numFP = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        9 ->
          numFN = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer, null)
        10 ->
          _numFN = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        11 ->
          precision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.precisionSer, null)
        12 ->
          _precision =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        13 ->
          sensitivity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.precisionSer, null)
        14 ->
          _sensitivity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        15 ->
          fMeasure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.precisionSer, null)
        16 ->
          _fMeasure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoreSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Roc: " + i)
      }
    }
    return MolecularSequence.Quality.Roc(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      score =
        (kotlin.collections.List(maxOf(score?.size ?: 0, _score?.size ?: 0)) { index ->
          Integer.of(score?.getOrNull(index)?.let { it }, _score?.getOrNull(index))!!
        }),
      numTP =
        (kotlin.collections.List(maxOf(numTP?.size ?: 0, _numTP?.size ?: 0)) { index ->
          Integer.of(numTP?.getOrNull(index)?.let { it }, _numTP?.getOrNull(index))!!
        }),
      numFP =
        (kotlin.collections.List(maxOf(numFP?.size ?: 0, _numFP?.size ?: 0)) { index ->
          Integer.of(numFP?.getOrNull(index)?.let { it }, _numFP?.getOrNull(index))!!
        }),
      numFN =
        (kotlin.collections.List(maxOf(numFN?.size ?: 0, _numFN?.size ?: 0)) { index ->
          Integer.of(numFN?.getOrNull(index)?.let { it }, _numFN?.getOrNull(index))!!
        }),
      precision =
        (kotlin.collections.List(maxOf(precision?.size ?: 0, _precision?.size ?: 0)) { index ->
          Decimal.of(precision?.getOrNull(index)?.let { it }, _precision?.getOrNull(index))!!
        }),
      sensitivity =
        (kotlin.collections.List(maxOf(sensitivity?.size ?: 0, _sensitivity?.size ?: 0)) { index ->
          Decimal.of(sensitivity?.getOrNull(index)?.let { it }, _sensitivity?.getOrNull(index))!!
        }),
      fMeasure =
        (kotlin.collections.List(maxOf(fMeasure?.size ?: 0, _fMeasure?.size ?: 0)) { index ->
          Decimal.of(fMeasure?.getOrNull(index)?.let { it }, _fMeasure?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MolecularSequence.Quality.Roc) {
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
    (value.score.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.scoreSer, it)
    }
    (value.score.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.scoreSer2, it)
    }
    (value.numTP.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.scoreSer, it)
    }
    (value.numTP.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.scoreSer2, it)
    }
    (value.numFP.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.scoreSer, it)
    }
    (value.numFP.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.scoreSer2, it)
    }
    (value.numFN.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.scoreSer, it)
    }
    (value.numFN.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.scoreSer2, it)
    }
    (value.precision.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.precisionSer, it)
    }
    (value.precision.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.scoreSer2, it)
    }
    (value.sensitivity.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.precisionSer, it)
    }
    (value.sensitivity.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.scoreSer2, it)
    }
    (value.fMeasure.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.precisionSer, it)
    }
    (value.fMeasure.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.scoreSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val scoreSerInner: KSerializer<Int> = Int.serializer()

    public val scoreSer: KSerializer<List<Int?>> = ListSerializer((Hoisted.scoreSerInner).nullable)

    public val scoreSerInner2: KSerializer<Element> = Element.serializer()

    public val scoreSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.scoreSerInner2).nullable)

    public val precisionSer: KSerializer<List<BigDecimal?>> =
      ListSerializer((BigDecimalSerializer).nullable)
  }
}

internal object MolecularSequenceRepositorySerializer : KSerializer<MolecularSequence.Repository> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repository") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("datasetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_datasetId", Element.serializer().descriptor, isOptional = true)
      element("variantsetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_variantsetId", Element.serializer().descriptor, isOptional = true)
      element("readsetId", KotlinString.serializer().descriptor, isOptional = true)
      element("_readsetId", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.Repository =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Repository) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.Repository {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var datasetId: KotlinString? = null
    var _datasetId: Element? = null
    var variantsetId: KotlinString? = null
    var _variantsetId: Element? = null
    var readsetId: KotlinString? = null
    var _readsetId: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 -> _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> name = decoder.decodeStringElement(descriptor, i)
        8 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 -> datasetId = decoder.decodeStringElement(descriptor, i)
        10 ->
          _datasetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        11 -> variantsetId = decoder.decodeStringElement(descriptor, i)
        12 ->
          _variantsetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        13 -> readsetId = decoder.decodeStringElement(descriptor, i)
        14 ->
          _readsetId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repository: " + i)
      }
    }
    return MolecularSequence.Repository(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(MolecularSequence.RepositoryType.fromCode(type!!), _type),
      url = Uri.of(url, _url),
      name = R4bString.of(name, _name),
      datasetId = R4bString.of(datasetId, _datasetId),
      variantsetId = R4bString.of(variantsetId, _variantsetId),
      readsetId = R4bString.of(readsetId, _readsetId),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MolecularSequence.Repository) {
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
    ((value.datasetId?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.datasetId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.typeSer, it)
    }
    ((value.variantsetId?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.variantsetId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.typeSer, it)
    }
    ((value.readsetId?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.readsetId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MolecularSequenceStructureVariantSerializer :
  KSerializer<MolecularSequence.StructureVariant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureVariant") {
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
      element("variantType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("exact", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_exact", Element.serializer().descriptor, isOptional = true)
      element("length", Int.serializer().descriptor, isOptional = true)
      element("_length", Element.serializer().descriptor, isOptional = true)
      element(
        "outer",
        lazyDescriptor { MolecularSequence.StructureVariant.Outer.serializer().descriptor },
        isOptional = true,
      )
      element(
        "inner",
        lazyDescriptor { MolecularSequence.StructureVariant.Inner.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MolecularSequence.StructureVariant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var variantType: CodeableConcept? = null
    var exact: KotlinBoolean? = null
    var _exact: Element? = null
    var length: Int? = null
    var _length: Element? = null
    var outer: MolecularSequence.StructureVariant.Outer? = null
    var `inner`: MolecularSequence.StructureVariant.Inner? = null
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
          variantType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variantTypeSer, null)
        4 -> exact = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _exact = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.exactSer, null)
        6 -> length = decoder.decodeIntElement(descriptor, i)
        7 ->
          _length = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.exactSer, null)
        8 ->
          outer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outerSer, null)
        9 ->
          `inner` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.innerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StructureVariant: " + i)
      }
    }
    return MolecularSequence.StructureVariant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      variantType = variantType,
      exact = R4bBoolean.of(exact, _exact),
      length = Integer.of(length, _length),
      outer = outer,
      `inner` = `inner`,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.StructureVariant,
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
    (value.variantType)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.variantTypeSer, it)
    }
    ((value.exact?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.exact?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.exactSer, it)
    }
    ((value.length?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.length?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.exactSer, it)
    }
    (value.outer)?.let { encoder.encodeSerializableElement(descriptor, 8, Hoisted.outerSer, it) }
    (value.`inner`)?.let { encoder.encodeSerializableElement(descriptor, 9, Hoisted.innerSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val variantTypeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val exactSer: KSerializer<Element> = Element.serializer()

    public val outerSer: KSerializer<MolecularSequence.StructureVariant.Outer> =
      MolecularSequence.StructureVariant.Outer.serializer()

    public val innerSer: KSerializer<MolecularSequence.StructureVariant.Inner> =
      MolecularSequence.StructureVariant.Inner.serializer()
  }
}

internal object MolecularSequenceStructureVariantOuterSerializer :
  KSerializer<MolecularSequence.StructureVariant.Outer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Outer") {
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
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Outer =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Outer) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MolecularSequence.StructureVariant.Outer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Outer: " + i)
      }
    }
    return MolecularSequence.StructureVariant.Outer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.StructureVariant.Outer,
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
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val startSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MolecularSequenceStructureVariantInnerSerializer :
  KSerializer<MolecularSequence.StructureVariant.Inner> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Inner") {
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
    }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Inner =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Inner) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MolecularSequence.StructureVariant.Inner {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Inner: " + i)
      }
    }
    return MolecularSequence.StructureVariant.Inner(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MolecularSequence.StructureVariant.Inner,
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
    b.element("coordinateSystem", Int.serializer().descriptor, isOptional = true)
    b.element("_coordinateSystem", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("specimen", Reference.serializer().descriptor, isOptional = true)
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element("performer", Reference.serializer().descriptor, isOptional = true)
    b.element("quantity", Quantity.serializer().descriptor, isOptional = true)
    b.element(
      "referenceSeq",
      lazyDescriptor { MolecularSequence.ReferenceSeq.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "variant",
      listSerialDescriptor(lazyDescriptor { MolecularSequence.Variant.serializer().descriptor }),
      isOptional = true,
    )
    b.element("observedSeq", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_observedSeq", Element.serializer().descriptor, isOptional = true)
    b.element(
      "quality",
      listSerialDescriptor(lazyDescriptor { MolecularSequence.Quality.serializer().descriptor }),
      isOptional = true,
    )
    b.element("readCoverage", Int.serializer().descriptor, isOptional = true)
    b.element("_readCoverage", Element.serializer().descriptor, isOptional = true)
    b.element(
      "repository",
      listSerialDescriptor(lazyDescriptor { MolecularSequence.Repository.serializer().descriptor }),
      isOptional = true,
    )
    b.element("pointer", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "structureVariant",
      listSerialDescriptor(
        lazyDescriptor { MolecularSequence.StructureVariant.serializer().descriptor }
      ),
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
    var coordinateSystem: Int? = null
    var _coordinateSystem: Element? = null
    var patient: Reference? = null
    var specimen: Reference? = null
    var device: Reference? = null
    var performer: Reference? = null
    var quantity: Quantity? = null
    var referenceSeq: MolecularSequence.ReferenceSeq? = null
    var variant: List<MolecularSequence.Variant>? = null
    var observedSeq: KotlinString? = null
    var _observedSeq: Element? = null
    var quality: List<MolecularSequence.Quality>? = null
    var readCoverage: Int? = null
    var _readCoverage: Element? = null
    var repository: List<MolecularSequence.Repository>? = null
    var pointer: List<Reference>? = null
    var structureVariant: List<MolecularSequence.StructureVariant>? = null
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
        13 -> coordinateSystem = decoder.decodeIntElement(descriptor, i)
        14 ->
          _coordinateSystem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        16 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        17 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        19 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        20 ->
          referenceSeq =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSeqSer, null)
        21 ->
          variant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.variantSer, null)
        22 -> observedSeq = decoder.decodeStringElement(descriptor, i)
        23 ->
          _observedSeq =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          quality =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.qualitySer, null)
        25 -> readCoverage = decoder.decodeIntElement(descriptor, i)
        26 ->
          _readCoverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          repository =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.repositorySer, null)
        28 ->
          pointer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.pointerSer, null)
        29 ->
          structureVariant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.structureVariantSer,
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
      type = type?.let { Enumeration.of(MolecularSequence.SequenceType.fromCode(it), _type) },
      coordinateSystem = Integer.of(coordinateSystem, _coordinateSystem)!!,
      patient = patient,
      specimen = specimen,
      device = device,
      performer = performer,
      quantity = quantity,
      referenceSeq = referenceSeq,
      variant = variant ?: listOf(),
      observedSeq = R4bString.of(observedSeq, _observedSeq),
      quality = quality ?: listOf(),
      readCoverage = Integer.of(readCoverage, _readCoverage),
      repository = repository ?: listOf(),
      pointer = pointer ?: listOf(),
      structureVariant = structureVariant ?: listOf(),
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
    ((value.coordinateSystem.value))?.let {
      encoder.encodeIntElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.coordinateSystem.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.patient)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.specimen)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.device)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.quantitySer, it)
    }
    (value.referenceSeq)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.referenceSeqSer,
        it,
      )
    }
    if (value.variant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.variantSer,
        value.variant,
      )
    ((value.observedSeq?.value))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.observedSeq?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.quality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.qualitySer,
        value.quality,
      )
    ((value.readCoverage?.value))?.let {
      encoder.encodeIntElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.readCoverage?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.repository.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.repositorySer,
        value.repository,
      )
    if (value.pointer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.pointerSer,
        value.pointer,
      )
    if (value.structureVariant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.structureVariantSer,
        value.structureVariant,
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

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val referenceSeqSer: KSerializer<MolecularSequence.ReferenceSeq> =
      MolecularSequence.ReferenceSeq.serializer()

    public val variantSerInner: KSerializer<MolecularSequence.Variant> =
      MolecularSequence.Variant.serializer()

    public val variantSer: KSerializer<List<MolecularSequence.Variant>> =
      ListSerializer(Hoisted.variantSerInner)

    public val qualitySerInner: KSerializer<MolecularSequence.Quality> =
      MolecularSequence.Quality.serializer()

    public val qualitySer: KSerializer<List<MolecularSequence.Quality>> =
      ListSerializer(Hoisted.qualitySerInner)

    public val repositorySerInner: KSerializer<MolecularSequence.Repository> =
      MolecularSequence.Repository.serializer()

    public val repositorySer: KSerializer<List<MolecularSequence.Repository>> =
      ListSerializer(Hoisted.repositorySerInner)

    public val pointerSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.patientSer)

    public val structureVariantSerInner: KSerializer<MolecularSequence.StructureVariant> =
      MolecularSequence.StructureVariant.serializer()

    public val structureVariantSer: KSerializer<List<MolecularSequence.StructureVariant>> =
      ListSerializer(Hoisted.structureVariantSerInner)
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
