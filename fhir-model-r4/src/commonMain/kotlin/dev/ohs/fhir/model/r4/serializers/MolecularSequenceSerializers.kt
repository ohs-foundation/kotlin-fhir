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

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.MolecularSequence
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

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

  override fun deserialize(decoder: Decoder): MolecularSequence.ReferenceSeq =
    decoder.decodeStructure(descriptor) {
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
            chromosome =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> genomeBuild = decodeStringElement(descriptor, i)
          5 ->
            _genomeBuild = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> orientation = decodeStringElement(descriptor, i)
          7 ->
            _orientation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            referenceSeqId =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            referenceSeqPointer =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          10 -> referenceSeqString = decodeStringElement(descriptor, i)
          11 ->
            _referenceSeqString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> strand = decodeStringElement(descriptor, i)
          13 -> _strand = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> windowStart = decodeIntElement(descriptor, i)
          15 ->
            _windowStart = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 -> windowEnd = decodeIntElement(descriptor, i)
          17 ->
            _windowEnd = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReferenceSeq: " + i)
        }
      }
      MolecularSequence.ReferenceSeq(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        chromosome = chromosome,
        genomeBuild = R4String.of(genomeBuild, _genomeBuild),
        orientation =
          Enumeration.of(
            if (orientation != null) MolecularSequence.OrientationType.fromCode(orientation)
            else null,
            _orientation,
          ),
        referenceSeqId = referenceSeqId,
        referenceSeqPointer = referenceSeqPointer,
        referenceSeqString = R4String.of(referenceSeqString, _referenceSeqString),
        strand =
          Enumeration.of(
            if (strand != null) MolecularSequence.StrandType.fromCode(strand) else null,
            _strand,
          ),
        windowStart = Integer.of(windowStart, _windowStart),
        windowEnd = Integer.of(windowEnd, _windowEnd),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.ReferenceSeq) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.chromosome)
      encodeStringIfNotNull(descriptor, 4, value.genomeBuild?.value)
      encodeElementIfNotNull(descriptor, 5, value.genomeBuild)
      encodeStringIfNotNull(descriptor, 6, value.orientation?.value?.code)
      encodeElementIfNotNull(descriptor, 7, value.orientation)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.referenceSeqId)
      encodeSerializableIfNotNull(descriptor, 9, ReferenceSerializer, value.referenceSeqPointer)
      encodeStringIfNotNull(descriptor, 10, value.referenceSeqString?.value)
      encodeElementIfNotNull(descriptor, 11, value.referenceSeqString)
      encodeStringIfNotNull(descriptor, 12, value.strand?.value?.code)
      encodeElementIfNotNull(descriptor, 13, value.strand)
      encodeIntIfNotNull(descriptor, 14, value.windowStart?.value)
      encodeElementIfNotNull(descriptor, 15, value.windowStart)
      encodeIntIfNotNull(descriptor, 16, value.windowEnd?.value)
      encodeElementIfNotNull(descriptor, 17, value.windowEnd)
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.Variant =
    decoder.decodeStructure(descriptor) {
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
          7 -> observedAllele = decodeStringElement(descriptor, i)
          8 ->
            _observedAllele =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> referenceAllele = decodeStringElement(descriptor, i)
          10 ->
            _referenceAllele =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> cigar = decodeStringElement(descriptor, i)
          12 -> _cigar = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            variantPointer =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Variant: " + i)
        }
      }
      MolecularSequence.Variant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        start = Integer.of(start, _start),
        end = Integer.of(end, _end),
        observedAllele = R4String.of(observedAllele, _observedAllele),
        referenceAllele = R4String.of(referenceAllele, _referenceAllele),
        cigar = R4String.of(cigar, _cigar),
        variantPointer = variantPointer,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Variant) {
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
      encodeStringIfNotNull(descriptor, 7, value.observedAllele?.value)
      encodeElementIfNotNull(descriptor, 8, value.observedAllele)
      encodeStringIfNotNull(descriptor, 9, value.referenceAllele?.value)
      encodeElementIfNotNull(descriptor, 10, value.referenceAllele)
      encodeStringIfNotNull(descriptor, 11, value.cigar?.value)
      encodeElementIfNotNull(descriptor, 12, value.cigar)
      encodeSerializableIfNotNull(descriptor, 13, ReferenceSerializer, value.variantPointer)
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality =
    decoder.decodeStructure(descriptor) {
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            standardSequence =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> start = decodeIntElement(descriptor, i)
          7 -> _start = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> end = decodeIntElement(descriptor, i)
          9 -> _end = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> score = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          11 ->
            method =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            truthTP = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          13 -> _truthTP = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            queryTP = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          15 -> _queryTP = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            truthFN = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          17 -> _truthFN = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            queryFP = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          19 -> _queryFP = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          20 -> gtFP = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          21 -> _gtFP = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          22 ->
            precision =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          23 ->
            _precision = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          24 ->
            recall = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          25 -> _recall = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          26 ->
            fScore = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          27 -> _fScore = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 ->
            roc =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MolecularSequenceQualityRocSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Quality: " + i)
        }
      }
      MolecularSequence.Quality(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) MolecularSequence.QualityType.fromCode(type) else null,
            _type,
          )
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.standardSequence)
      encodeIntIfNotNull(descriptor, 6, value.start?.value)
      encodeElementIfNotNull(descriptor, 7, value.start)
      encodeIntIfNotNull(descriptor, 8, value.end?.value)
      encodeElementIfNotNull(descriptor, 9, value.end)
      encodeSerializableIfNotNull(descriptor, 10, QuantitySerializer, value.score)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.method)
      encodeSerializableIfNotNull(descriptor, 12, FhirDecimalSerializer, value.truthTP?.value)
      encodeElementIfNotNull(descriptor, 13, value.truthTP)
      encodeSerializableIfNotNull(descriptor, 14, FhirDecimalSerializer, value.queryTP?.value)
      encodeElementIfNotNull(descriptor, 15, value.queryTP)
      encodeSerializableIfNotNull(descriptor, 16, FhirDecimalSerializer, value.truthFN?.value)
      encodeElementIfNotNull(descriptor, 17, value.truthFN)
      encodeSerializableIfNotNull(descriptor, 18, FhirDecimalSerializer, value.queryFP?.value)
      encodeElementIfNotNull(descriptor, 19, value.queryFP)
      encodeSerializableIfNotNull(descriptor, 20, FhirDecimalSerializer, value.gtFP?.value)
      encodeElementIfNotNull(descriptor, 21, value.gtFP)
      encodeSerializableIfNotNull(descriptor, 22, FhirDecimalSerializer, value.precision?.value)
      encodeElementIfNotNull(descriptor, 23, value.precision)
      encodeSerializableIfNotNull(descriptor, 24, FhirDecimalSerializer, value.recall?.value)
      encodeElementIfNotNull(descriptor, 25, value.recall)
      encodeSerializableIfNotNull(descriptor, 26, FhirDecimalSerializer, value.fScore?.value)
      encodeElementIfNotNull(descriptor, 27, value.fScore)
      encodeSerializableIfNotNull(descriptor, 28, MolecularSequenceQualityRocSerializer, value.roc)
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality.Roc =
    decoder.decodeStructure(descriptor) {
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
            score =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          4 ->
            _score =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 ->
            numTP =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          6 ->
            _numTP =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            numFP =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          8 ->
            _numFP =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            numFN =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          10 ->
            _numFN =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          11 ->
            precision =
              decodeNullableSerializableElement(
                descriptor,
                i,
                FhirDecimalSerializer.nullableListSerializer,
                null,
              )
          12 ->
            _precision =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          13 ->
            sensitivity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                FhirDecimalSerializer.nullableListSerializer,
                null,
              )
          14 ->
            _sensitivity =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          15 ->
            fMeasure =
              decodeNullableSerializableElement(
                descriptor,
                i,
                FhirDecimalSerializer.nullableListSerializer,
                null,
              )
          16 ->
            _fMeasure =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Roc: " + i)
        }
      }
      MolecularSequence.Quality.Roc(
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
          (kotlin.collections.List(maxOf(sensitivity?.size ?: 0, _sensitivity?.size ?: 0)) { index
            ->
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
      if (value.score.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          intNullableListSerializer,
          value.score.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 4, value.score)
      }
      if (value.numTP.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          intNullableListSerializer,
          value.numTP.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.numTP)
      }
      if (value.numFP.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          intNullableListSerializer,
          value.numFP.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.numFP)
      }
      if (value.numFN.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          intNullableListSerializer,
          value.numFN.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.numFN)
      }
      if (value.precision.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          FhirDecimalSerializer.nullableListSerializer,
          value.precision.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 12, value.precision)
      }
      if (value.sensitivity.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          13,
          FhirDecimalSerializer.nullableListSerializer,
          value.sensitivity.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 14, value.sensitivity)
      }
      if (value.fMeasure.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          15,
          FhirDecimalSerializer.nullableListSerializer,
          value.fMeasure.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 16, value.fMeasure)
      }
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.Repository =
    decoder.decodeStructure(descriptor) {
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> url = decodeStringElement(descriptor, i)
          6 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> name = decodeStringElement(descriptor, i)
          8 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> datasetId = decodeStringElement(descriptor, i)
          10 ->
            _datasetId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> variantsetId = decodeStringElement(descriptor, i)
          12 ->
            _variantsetId =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> readsetId = decodeStringElement(descriptor, i)
          14 ->
            _readsetId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Repository: " + i)
        }
      }
      MolecularSequence.Repository(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) MolecularSequence.RepositoryType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on MolecularSequence.Repository"
            ),
        url = Uri.of(url, _url),
        name = R4String.of(name, _name),
        datasetId = R4String.of(datasetId, _datasetId),
        variantsetId = R4String.of(variantsetId, _variantsetId),
        readsetId = R4String.of(readsetId, _readsetId),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Repository) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.url?.value)
      encodeElementIfNotNull(descriptor, 6, value.url)
      encodeStringIfNotNull(descriptor, 7, value.name?.value)
      encodeElementIfNotNull(descriptor, 8, value.name)
      encodeStringIfNotNull(descriptor, 9, value.datasetId?.value)
      encodeElementIfNotNull(descriptor, 10, value.datasetId)
      encodeStringIfNotNull(descriptor, 11, value.variantsetId?.value)
      encodeElementIfNotNull(descriptor, 12, value.variantsetId)
      encodeStringIfNotNull(descriptor, 13, value.readsetId?.value)
      encodeElementIfNotNull(descriptor, 14, value.readsetId)
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant =
    decoder.decodeStructure(descriptor) {
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
            variantType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> exact = decodeBooleanElement(descriptor, i)
          5 -> _exact = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> length = decodeIntElement(descriptor, i)
          7 -> _length = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            outer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MolecularSequenceStructureVariantOuterSerializer,
                null,
              )
          9 ->
            `inner` =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MolecularSequenceStructureVariantInnerSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding StructureVariant: " + i)
        }
      }
      MolecularSequence.StructureVariant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        variantType = variantType,
        exact = R4Boolean.of(exact, _exact),
        length = Integer.of(length, _length),
        outer = outer,
        `inner` = `inner`,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.variantType)
      encodeBooleanIfNotNull(descriptor, 4, value.exact?.value)
      encodeElementIfNotNull(descriptor, 5, value.exact)
      encodeIntIfNotNull(descriptor, 6, value.length?.value)
      encodeElementIfNotNull(descriptor, 7, value.length)
      encodeSerializableIfNotNull(
        descriptor,
        8,
        MolecularSequenceStructureVariantOuterSerializer,
        value.outer,
      )
      encodeSerializableIfNotNull(
        descriptor,
        9,
        MolecularSequenceStructureVariantInnerSerializer,
        value.`inner`,
      )
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Outer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var start: Int? = null
      var _start: Element? = null
      var end: Int? = null
      var _end: Element? = null
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Outer: " + i)
        }
      }
      MolecularSequence.StructureVariant.Outer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        start = Integer.of(start, _start),
        end = Integer.of(end, _end),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Outer) {
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
    }
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

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Inner =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var start: Int? = null
      var _start: Element? = null
      var end: Int? = null
      var _end: Element? = null
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Inner: " + i)
        }
      }
      MolecularSequence.StructureVariant.Inner(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        start = Integer.of(start, _start),
        end = Integer.of(end, _end),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Inner) {
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
        13 -> coordinateSystem = decoder.decodeIntElement(descriptor, i)
        14 ->
          _coordinateSystem =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 ->
          specimen =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        20 ->
          referenceSeq =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceReferenceSeqSerializer,
              null,
            )
        21 ->
          variant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceVariantSerializer.listSerializer,
              null,
            )
        22 -> observedSeq = decoder.decodeStringElement(descriptor, i)
        23 ->
          _observedSeq =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          quality =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceQualitySerializer.listSerializer,
              null,
            )
        25 -> readCoverage = decoder.decodeIntElement(descriptor, i)
        26 ->
          _readCoverage =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          repository =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MolecularSequenceRepositorySerializer.listSerializer,
              null,
            )
        28 ->
          pointer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          structureVariant =
            decoder.decodeNullableSerializableElement(
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
      type =
        Enumeration.of(
          if (type != null) MolecularSequence.SequenceType.fromCode(type) else null,
          _type,
        ),
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
      observedSeq = R4String.of(observedSeq, _observedSeq),
      quality = quality ?: listOf(),
      readCoverage = Integer.of(readCoverage, _readCoverage),
      repository = repository ?: listOf(),
      pointer = pointer ?: listOf(),
      structureVariant = structureVariant ?: listOf(),
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
    encoder.encodeIntIfNotNull(descriptor, 13 + descriptorOffset, value.coordinateSystem.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.coordinateSystem)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.specimen,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      QuantitySerializer,
      value.quantity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      MolecularSequenceReferenceSeqSerializer,
      value.referenceSeq,
    )
    if (value.variant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        MolecularSequenceVariantSerializer.listSerializer,
        value.variant,
      )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.observedSeq?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.observedSeq)
    if (value.quality.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        MolecularSequenceQualitySerializer.listSerializer,
        value.quality,
      )
    encoder.encodeIntIfNotNull(descriptor, 25 + descriptorOffset, value.readCoverage?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.readCoverage)
    if (value.repository.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        MolecularSequenceRepositorySerializer.listSerializer,
        value.repository,
      )
    if (value.pointer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.pointer,
      )
    if (value.structureVariant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MolecularSequenceStructureVariantSerializer.listSerializer,
        value.structureVariant,
      )
  }
}
