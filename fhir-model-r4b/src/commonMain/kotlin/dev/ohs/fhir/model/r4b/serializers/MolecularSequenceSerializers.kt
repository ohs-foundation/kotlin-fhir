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

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.MolecularSequence
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.OrientationType
import dev.ohs.fhir.model.r4b.terminologies.QualityType
import dev.ohs.fhir.model.r4b.terminologies.RepositoryType
import dev.ohs.fhir.model.r4b.terminologies.SequenceType
import dev.ohs.fhir.model.r4b.terminologies.StrandType
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
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MolecularSequenceReferenceSeqSerializer :
  KSerializer<MolecularSequence.ReferenceSeq> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReferenceSeq") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("chromosome", CodeableConceptSerializer.descriptor)
      optionalElement("genomeBuild", KotlinString.serializer().descriptor)
      optionalElement("_genomeBuild", ElementSerializer.descriptor)
      optionalElement("orientation", KotlinString.serializer().descriptor)
      optionalElement("_orientation", ElementSerializer.descriptor)
      optionalElement("referenceSeqId", CodeableConceptSerializer.descriptor)
      optionalElement("referenceSeqPointer", ReferenceSerializer.descriptor)
      optionalElement("referenceSeqString", KotlinString.serializer().descriptor)
      optionalElement("_referenceSeqString", ElementSerializer.descriptor)
      optionalElement("strand", KotlinString.serializer().descriptor)
      optionalElement("_strand", ElementSerializer.descriptor)
      optionalElement("windowStart", Int.serializer().descriptor)
      optionalElement("_windowStart", ElementSerializer.descriptor)
      optionalElement("windowEnd", Int.serializer().descriptor)
      optionalElement("_windowEnd", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.ReferenceSeq>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.ReferenceSeq {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          chromosome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> genomeBuild = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _genomeBuild =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> orientation = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _orientation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          referenceSeqId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          referenceSeqPointer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        10 -> referenceSeqString = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _referenceSeqString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> strand = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _strand =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> windowStart = compositeDecoder.decodeIntElement(descriptor, i)
        15 ->
          _windowStart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 -> windowEnd = compositeDecoder.decodeIntElement(descriptor, i)
        17 ->
          _windowEnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ReferenceSeq: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.ReferenceSeq(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      chromosome = chromosome,
      genomeBuild = R4bString.of(genomeBuild, _genomeBuild),
      orientation =
        Enumeration.of(
          if (orientation != null) OrientationType.fromCode(orientation) else null,
          _orientation,
        ),
      referenceSeqId = referenceSeqId,
      referenceSeqPointer = referenceSeqPointer,
      referenceSeqString = R4bString.of(referenceSeqString, _referenceSeqString),
      strand = Enumeration.of(if (strand != null) StrandType.fromCode(strand) else null, _strand),
      windowStart = Integer.of(windowStart, _windowStart),
      windowEnd = Integer.of(windowEnd, _windowEnd),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.ReferenceSeq) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.chromosome,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.genomeBuild?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.genomeBuild)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.orientation?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.orientation)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.referenceSeqId,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      ReferenceSerializer,
      value.referenceSeqPointer,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.referenceSeqString?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.referenceSeqString)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.strand?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.strand)
    compositeEncoder.encodeIntIfNotNull(descriptor, 14, value.windowStart?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.windowStart)
    compositeEncoder.encodeIntIfNotNull(descriptor, 16, value.windowEnd?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.windowEnd)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceVariantSerializer : KSerializer<MolecularSequence.Variant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Variant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("start", Int.serializer().descriptor)
      optionalElement("_start", ElementSerializer.descriptor)
      optionalElement("end", Int.serializer().descriptor)
      optionalElement("_end", ElementSerializer.descriptor)
      optionalElement("observedAllele", KotlinString.serializer().descriptor)
      optionalElement("_observedAllele", ElementSerializer.descriptor)
      optionalElement("referenceAllele", KotlinString.serializer().descriptor)
      optionalElement("_referenceAllele", ElementSerializer.descriptor)
      optionalElement("cigar", KotlinString.serializer().descriptor)
      optionalElement("_cigar", ElementSerializer.descriptor)
      optionalElement("variantPointer", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Variant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Variant {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        7 -> observedAllele = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _observedAllele =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> referenceAllele = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _referenceAllele =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> cigar = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _cigar =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          variantPointer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Variant: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Variant) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.start?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.start)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.end?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.end)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.observedAllele?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.observedAllele)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.referenceAllele?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.referenceAllele)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.cigar?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.cigar)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      ReferenceSerializer,
      value.variantPointer,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceQualitySerializer : KSerializer<MolecularSequence.Quality> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Quality") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("standardSequence", CodeableConceptSerializer.descriptor)
      optionalElement("start", Int.serializer().descriptor)
      optionalElement("_start", ElementSerializer.descriptor)
      optionalElement("end", Int.serializer().descriptor)
      optionalElement("_end", ElementSerializer.descriptor)
      optionalElement("score", QuantitySerializer.descriptor)
      optionalElement("method", CodeableConceptSerializer.descriptor)
      optionalElement("truthTP", FhirDecimalSerializer.descriptor)
      optionalElement("_truthTP", ElementSerializer.descriptor)
      optionalElement("queryTP", FhirDecimalSerializer.descriptor)
      optionalElement("_queryTP", ElementSerializer.descriptor)
      optionalElement("truthFN", FhirDecimalSerializer.descriptor)
      optionalElement("_truthFN", ElementSerializer.descriptor)
      optionalElement("queryFP", FhirDecimalSerializer.descriptor)
      optionalElement("_queryFP", ElementSerializer.descriptor)
      optionalElement("gtFP", FhirDecimalSerializer.descriptor)
      optionalElement("_gtFP", ElementSerializer.descriptor)
      optionalElement("precision", FhirDecimalSerializer.descriptor)
      optionalElement("_precision", ElementSerializer.descriptor)
      optionalElement("recall", FhirDecimalSerializer.descriptor)
      optionalElement("_recall", ElementSerializer.descriptor)
      optionalElement("fScore", FhirDecimalSerializer.descriptor)
      optionalElement("_fScore", ElementSerializer.descriptor)
      optionalElement("roc", MolecularSequenceQualityRocSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Quality>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var truthTP: FhirDecimal? = null
    var _truthTP: Element? = null
    var queryTP: FhirDecimal? = null
    var _queryTP: Element? = null
    var truthFN: FhirDecimal? = null
    var _truthFN: Element? = null
    var queryFP: FhirDecimal? = null
    var _queryFP: Element? = null
    var gtFP: FhirDecimal? = null
    var _gtFP: Element? = null
    var precision: FhirDecimal? = null
    var _precision: Element? = null
    var recall: FhirDecimal? = null
    var _recall: Element? = null
    var fScore: FhirDecimal? = null
    var _fScore: Element? = null
    var roc: MolecularSequence.Quality.Roc? = null
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          standardSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> start = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _start =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> end = compositeDecoder.decodeIntElement(descriptor, i)
        9 ->
          _end =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        11 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          truthTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        13 ->
          _truthTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          queryTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        15 ->
          _queryTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          truthFN =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        17 ->
          _truthFN =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          queryFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        19 ->
          _queryFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          gtFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        21 ->
          _gtFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          precision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        23 ->
          _precision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          recall =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        25 ->
          _recall =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 ->
          fScore =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        27 ->
          _fScore =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          roc =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceQualityRocSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Quality: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Quality(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(if (type != null) QualityType.fromCode(type) else null, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on MolecularSequence.Quality"
          ),
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

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.standardSequence,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.start?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.start)
    compositeEncoder.encodeIntIfNotNull(descriptor, 8, value.end?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.end)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, QuantitySerializer, value.score)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      FhirDecimalSerializer,
      value.truthTP?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.truthTP)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      FhirDecimalSerializer,
      value.queryTP?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.queryTP)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16,
      FhirDecimalSerializer,
      value.truthFN?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.truthFN)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18,
      FhirDecimalSerializer,
      value.queryFP?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19, value.queryFP)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20,
      FhirDecimalSerializer,
      value.gtFP?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.gtFP)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22,
      FhirDecimalSerializer,
      value.precision?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23, value.precision)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24,
      FhirDecimalSerializer,
      value.recall?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25, value.recall)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26,
      FhirDecimalSerializer,
      value.fScore?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27, value.fScore)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28,
      MolecularSequenceQualityRocSerializer,
      value.roc,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceQualityRocSerializer : KSerializer<MolecularSequence.Quality.Roc> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Roc") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("score", intNullableListSerializer.descriptor)
      optionalElement("_score", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("numTP", intNullableListSerializer.descriptor)
      optionalElement("_numTP", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("numFP", intNullableListSerializer.descriptor)
      optionalElement("_numFP", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("numFN", intNullableListSerializer.descriptor)
      optionalElement("_numFN", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("precision", FhirDecimalSerializer.nullableListSerializer.descriptor)
      optionalElement("_precision", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("sensitivity", FhirDecimalSerializer.nullableListSerializer.descriptor)
      optionalElement("_sensitivity", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("fMeasure", FhirDecimalSerializer.nullableListSerializer.descriptor)
      optionalElement("_fMeasure", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Quality.Roc>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality.Roc {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var precision: List<FhirDecimal?>? = null
    var _precision: List<Element?>? = null
    var sensitivity: List<FhirDecimal?>? = null
    var _sensitivity: List<Element?>? = null
    var fMeasure: List<FhirDecimal?>? = null
    var _fMeasure: List<Element?>? = null
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
          score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        4 ->
          _score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          numTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _numTP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          numFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _numFP =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          numFN =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        10 ->
          _numFN =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          precision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer.nullableListSerializer,
              null,
            )
        12 ->
          _precision =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          sensitivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer.nullableListSerializer,
              null,
            )
        14 ->
          _sensitivity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          fMeasure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer.nullableListSerializer,
              null,
            )
        16 ->
          _fMeasure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Roc: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Quality.Roc(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      score =
        (kotlin.collections.List(maxOf(score?.size ?: 0, _score?.size ?: 0)) { index ->
          Integer.of(score?.getOrNull(index), _score?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'score' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      numTP =
        (kotlin.collections.List(maxOf(numTP?.size ?: 0, _numTP?.size ?: 0)) { index ->
          Integer.of(numTP?.getOrNull(index), _numTP?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'numTP' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      numFP =
        (kotlin.collections.List(maxOf(numFP?.size ?: 0, _numFP?.size ?: 0)) { index ->
          Integer.of(numFP?.getOrNull(index), _numFP?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'numFP' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      numFN =
        (kotlin.collections.List(maxOf(numFN?.size ?: 0, _numFN?.size ?: 0)) { index ->
          Integer.of(numFN?.getOrNull(index), _numFN?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'numFN' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      precision =
        (kotlin.collections.List(maxOf(precision?.size ?: 0, _precision?.size ?: 0)) { index ->
          Decimal.of(precision?.getOrNull(index), _precision?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'precision' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      sensitivity =
        (kotlin.collections.List(maxOf(sensitivity?.size ?: 0, _sensitivity?.size ?: 0)) { index ->
          Decimal.of(sensitivity?.getOrNull(index), _sensitivity?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'sensitivity' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
      fMeasure =
        (kotlin.collections.List(maxOf(fMeasure?.size ?: 0, _fMeasure?.size ?: 0)) { index ->
          Decimal.of(fMeasure?.getOrNull(index), _fMeasure?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'fMeasure' on MolecularSequence.Quality.Roc has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality.Roc) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.score.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        intNullableListSerializer,
        value.score.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.score)
    }
    if (value.numTP.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.numTP.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.numTP)
    }
    if (value.numFP.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        intNullableListSerializer,
        value.numFP.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.numFP)
    }
    if (value.numFN.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        intNullableListSerializer,
        value.numFN.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.numFN)
    }
    if (value.precision.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        FhirDecimalSerializer.nullableListSerializer,
        value.precision.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.precision)
    }
    if (value.sensitivity.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13,
        FhirDecimalSerializer.nullableListSerializer,
        value.sensitivity.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 14, value.sensitivity)
    }
    if (value.fMeasure.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        15,
        FhirDecimalSerializer.nullableListSerializer,
        value.fMeasure.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 16, value.fMeasure)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceRepositorySerializer : KSerializer<MolecularSequence.Repository> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Repository") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("datasetId", KotlinString.serializer().descriptor)
      optionalElement("_datasetId", ElementSerializer.descriptor)
      optionalElement("variantsetId", KotlinString.serializer().descriptor)
      optionalElement("_variantsetId", ElementSerializer.descriptor)
      optionalElement("readsetId", KotlinString.serializer().descriptor)
      optionalElement("_readsetId", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.Repository>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.Repository {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> datasetId = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _datasetId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> variantsetId = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _variantsetId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> readsetId = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _readsetId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Repository: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Repository(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(if (type != null) RepositoryType.fromCode(type) else null, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on MolecularSequence.Repository"
          ),
      url = Uri.of(url, _url),
      name = R4bString.of(name, _name),
      datasetId = R4bString.of(datasetId, _datasetId),
      variantsetId = R4bString.of(variantsetId, _variantsetId),
      readsetId = R4bString.of(readsetId, _readsetId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Repository) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.datasetId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.datasetId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.variantsetId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.variantsetId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.readsetId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.readsetId)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceStructureVariantSerializer :
  KSerializer<MolecularSequence.StructureVariant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("StructureVariant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("variantType", CodeableConceptSerializer.descriptor)
      optionalElement("exact", KotlinBoolean.serializer().descriptor)
      optionalElement("_exact", ElementSerializer.descriptor)
      optionalElement("length", Int.serializer().descriptor)
      optionalElement("_length", ElementSerializer.descriptor)
      optionalElement("outer", MolecularSequenceStructureVariantOuterSerializer.descriptor)
      optionalElement("inner", MolecularSequenceStructureVariantInnerSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          variantType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> exact = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _exact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> length = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _length =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          outer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceStructureVariantOuterSerializer,
              null,
            )
        9 ->
          `inner` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceStructureVariantInnerSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding StructureVariant: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.variantType,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.exact?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.exact)
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.length?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.length)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      MolecularSequenceStructureVariantOuterSerializer,
      value.outer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      MolecularSequenceStructureVariantInnerSerializer,
      value.`inner`,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceStructureVariantOuterSerializer :
  KSerializer<MolecularSequence.StructureVariant.Outer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Outer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("start", Int.serializer().descriptor)
      optionalElement("_start", ElementSerializer.descriptor)
      optionalElement("end", Int.serializer().descriptor)
      optionalElement("_end", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant.Outer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Outer {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Outer: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.StructureVariant.Outer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Outer) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.start?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.start)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.end?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.end)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceStructureVariantInnerSerializer :
  KSerializer<MolecularSequence.StructureVariant.Inner> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Inner") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("start", Int.serializer().descriptor)
      optionalElement("_start", ElementSerializer.descriptor)
      optionalElement("end", Int.serializer().descriptor)
      optionalElement("_end", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant.Inner>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Inner {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var start: Int? = null
    var _start: Element? = null
    var end: Int? = null
    var _end: Element? = null
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Inner: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.StructureVariant.Inner(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Inner) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.start?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.start)
    compositeEncoder.encodeIntIfNotNull(descriptor, 5, value.end?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.end)
    compositeEncoder.endStructure(descriptor)
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
    b.optionalElement("coordinateSystem", Int.serializer().descriptor)
    b.optionalElement("_coordinateSystem", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("referenceSeq", MolecularSequenceReferenceSeqSerializer.descriptor)
    b.optionalElement("variant", MolecularSequenceVariantSerializer.listSerializer.descriptor)
    b.optionalElement("observedSeq", KotlinString.serializer().descriptor)
    b.optionalElement("_observedSeq", ElementSerializer.descriptor)
    b.optionalElement("quality", MolecularSequenceQualitySerializer.listSerializer.descriptor)
    b.optionalElement("readCoverage", Int.serializer().descriptor)
    b.optionalElement("_readCoverage", ElementSerializer.descriptor)
    b.optionalElement("repository", MolecularSequenceRepositorySerializer.listSerializer.descriptor)
    b.optionalElement("pointer", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "structureVariant",
      MolecularSequenceStructureVariantSerializer.listSerializer.descriptor,
    )
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
        11 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> coordinateSystem = compositeDecoder.decodeIntElement(descriptor, i)
        14 ->
          _coordinateSystem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          specimen =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          performer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        20 ->
          referenceSeq =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceReferenceSeqSerializer,
              null,
            )
        21 ->
          variant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceVariantSerializer.listSerializer,
              null,
            )
        22 -> observedSeq = compositeDecoder.decodeStringElement(descriptor, i)
        23 ->
          _observedSeq =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        24 ->
          quality =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceQualitySerializer.listSerializer,
              null,
            )
        25 -> readCoverage = compositeDecoder.decodeIntElement(descriptor, i)
        26 ->
          _readCoverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          repository =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRepositorySerializer.listSerializer,
              null,
            )
        28 ->
          pointer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          structureVariant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceStructureVariantSerializer.listSerializer,
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
      type = Enumeration.of(if (type != null) SequenceType.fromCode(type) else null, _type),
      coordinateSystem =
        Integer.of(coordinateSystem, _coordinateSystem)
          ?: throw SerializationException(
            "Missing required property 'coordinateSystem' on MolecularSequence"
          ),
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.coordinateSystem.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.coordinateSystem,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      MolecularSequenceReferenceSeqSerializer,
      value.referenceSeq,
    )
    if (value.variant.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        MolecularSequenceVariantSerializer.listSerializer,
        value.variant,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.observedSeq?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.observedSeq)
    if (value.quality.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        MolecularSequenceQualitySerializer.listSerializer,
        value.quality,
      )
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.readCoverage?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.readCoverage)
    if (value.repository.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MolecularSequenceRepositorySerializer.listSerializer,
        value.repository,
      )
    if (value.pointer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.pointer,
      )
    if (value.structureVariant.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MolecularSequenceStructureVariantSerializer.listSerializer,
        value.structureVariant,
      )
  }
}
