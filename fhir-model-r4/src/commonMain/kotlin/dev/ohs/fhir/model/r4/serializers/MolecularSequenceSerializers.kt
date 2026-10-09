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
import dev.ohs.fhir.model.r4.terminologies.OrientationType
import dev.ohs.fhir.model.r4.terminologies.QualityType
import dev.ohs.fhir.model.r4.terminologies.RepositoryType
import dev.ohs.fhir.model.r4.terminologies.SequenceType
import dev.ohs.fhir.model.r4.terminologies.StrandType
import kotlin.Boolean as KotlinBoolean
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

internal object MolecularSequenceReferenceSeqSerializer :
  FhirSerializer<MolecularSequence.ReferenceSeq> {
  override val descriptor: SerialDescriptor = buildDescriptor("ReferenceSeq", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.ReferenceSeq>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("chromosome", CodeableConceptSerializer.descriptor)
    b.strPrim("genomeBuild")
    b.strPrim("orientation")
    b.optionalElement("referenceSeqId", CodeableConceptSerializer.descriptor)
    b.optionalElement("referenceSeqPointer", ReferenceSerializer.descriptor)
    b.strPrim("referenceSeqString")
    b.strPrim("strand")
    b.intPrim("windowStart")
    b.intPrim("windowEnd")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.ReferenceSeq {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var chromosome: CodeableConcept? = null
    var genomeBuild: KotlinString? = null
    var _genomeBuild: Element? = null
    var orientation: OrientationType? = null
    var _orientation: Element? = null
    var referenceSeqId: CodeableConcept? = null
    var referenceSeqPointer: Reference? = null
    var referenceSeqString: KotlinString? = null
    var _referenceSeqString: Element? = null
    var strand: StrandType? = null
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
        6 ->
          orientation =
            OrientationType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        12 -> strand = StrandType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.ReferenceSeq(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      chromosome = chromosome,
      genomeBuild = R4String.of(genomeBuild, _genomeBuild),
      orientation = Enumeration.of(orientation, _orientation),
      referenceSeqId = referenceSeqId,
      referenceSeqPointer = referenceSeqPointer,
      referenceSeqString = R4String.of(referenceSeqString, _referenceSeqString),
      strand = Enumeration.of(strand, _strand),
      windowStart = Integer.of(windowStart, _windowStart),
      windowEnd = Integer.of(windowEnd, _windowEnd),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.ReferenceSeq) {
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

internal object MolecularSequenceVariantSerializer : FhirSerializer<MolecularSequence.Variant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Variant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Variant>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("start")
    b.intPrim("end")
    b.strPrim("observedAllele")
    b.strPrim("referenceAllele")
    b.strPrim("cigar")
    b.optionalElement("variantPointer", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Variant {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Variant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
      observedAllele = R4String.of(observedAllele, _observedAllele),
      referenceAllele = R4String.of(referenceAllele, _referenceAllele),
      cigar = R4String.of(cigar, _cigar),
      variantPointer = variantPointer,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Variant) {
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

internal object MolecularSequenceQualitySerializer : FhirSerializer<MolecularSequence.Quality> {
  override val descriptor: SerialDescriptor = buildDescriptor("Quality", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Quality>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.optionalElement("standardSequence", CodeableConceptSerializer.descriptor)
    b.intPrim("start")
    b.intPrim("end")
    b.optionalElement("score", QuantitySerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.prim("truthTP", FhirDecimalSerializer.descriptor)
    b.prim("queryTP", FhirDecimalSerializer.descriptor)
    b.prim("truthFN", FhirDecimalSerializer.descriptor)
    b.prim("queryFP", FhirDecimalSerializer.descriptor)
    b.prim("gtFP", FhirDecimalSerializer.descriptor)
    b.prim("precision", FhirDecimalSerializer.descriptor)
    b.prim("recall", FhirDecimalSerializer.descriptor)
    b.prim("fScore", FhirDecimalSerializer.descriptor)
    b.optionalElement("roc", MolecularSequenceQualityRocSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: QualityType? = null
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
        3 -> type = QualityType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Quality(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "MolecularSequence.Quality", "type"),
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

internal object MolecularSequenceQualityRocSerializer :
  FhirSerializer<MolecularSequence.Quality.Roc> {
  override val descriptor: SerialDescriptor = buildDescriptor("Roc", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Quality.Roc>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrimList("score")
    b.intPrimList("numTP")
    b.intPrimList("numFP")
    b.intPrimList("numFN")
    b.primList("precision", FhirDecimalSerializer.nullableListSerializer.descriptor)
    b.primList("sensitivity", FhirDecimalSerializer.nullableListSerializer.descriptor)
    b.primList("fMeasure", FhirDecimalSerializer.nullableListSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality.Roc {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val score_ =
      List(maxSize(score, _score)) { index ->
        entryRequired(
          Integer.of(at(score, index), at(_score, index)),
          "MolecularSequence.Quality.Roc",
          "score",
        )
      }
    val numTP_ =
      List(maxSize(numTP, _numTP)) { index ->
        entryRequired(
          Integer.of(at(numTP, index), at(_numTP, index)),
          "MolecularSequence.Quality.Roc",
          "numTP",
        )
      }
    val numFP_ =
      List(maxSize(numFP, _numFP)) { index ->
        entryRequired(
          Integer.of(at(numFP, index), at(_numFP, index)),
          "MolecularSequence.Quality.Roc",
          "numFP",
        )
      }
    val numFN_ =
      List(maxSize(numFN, _numFN)) { index ->
        entryRequired(
          Integer.of(at(numFN, index), at(_numFN, index)),
          "MolecularSequence.Quality.Roc",
          "numFN",
        )
      }
    val precision_ =
      List(maxSize(precision, _precision)) { index ->
        entryRequired(
          Decimal.of(at(precision, index), at(_precision, index)),
          "MolecularSequence.Quality.Roc",
          "precision",
        )
      }
    val sensitivity_ =
      List(maxSize(sensitivity, _sensitivity)) { index ->
        entryRequired(
          Decimal.of(at(sensitivity, index), at(_sensitivity, index)),
          "MolecularSequence.Quality.Roc",
          "sensitivity",
        )
      }
    val fMeasure_ =
      List(maxSize(fMeasure, _fMeasure)) { index ->
        entryRequired(
          Decimal.of(at(fMeasure, index), at(_fMeasure, index)),
          "MolecularSequence.Quality.Roc",
          "fMeasure",
        )
      }
    return MolecularSequence.Quality.Roc(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      score = score_,
      numTP = numTP_,
      numFP = numFP_,
      numFN = numFN_,
      precision = precision_,
      sensitivity = sensitivity_,
      fMeasure = fMeasure_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality.Roc) {
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
    if (!value.score.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        intNullableListSerializer,
        value.score.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.score)
    }
    if (!value.numTP.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.numTP.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.numTP)
    }
    if (!value.numFP.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        intNullableListSerializer,
        value.numFP.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.numFP)
    }
    if (!value.numFN.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        intNullableListSerializer,
        value.numFN.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.numFN)
    }
    if (!value.precision.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        FhirDecimalSerializer.nullableListSerializer,
        value.precision.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.precision)
    }
    if (!value.sensitivity.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13,
        FhirDecimalSerializer.nullableListSerializer,
        value.sensitivity.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 14, value.sensitivity)
    }
    if (!value.fMeasure.isEmpty()) {
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

internal object MolecularSequenceRepositorySerializer :
  FhirSerializer<MolecularSequence.Repository> {
  override val descriptor: SerialDescriptor = buildDescriptor("Repository", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.Repository>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("url")
    b.strPrim("name")
    b.strPrim("datasetId")
    b.strPrim("variantsetId")
    b.strPrim("readsetId")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Repository {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: RepositoryType? = null
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
        3 -> type = RepositoryType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.Repository(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "MolecularSequence.Repository", "type"),
      url = Uri.of(url, _url),
      name = R4String.of(name, _name),
      datasetId = R4String.of(datasetId, _datasetId),
      variantsetId = R4String.of(variantsetId, _variantsetId),
      readsetId = R4String.of(readsetId, _readsetId),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Repository) {
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
  FhirSerializer<MolecularSequence.StructureVariant> {
  override val descriptor: SerialDescriptor = buildDescriptor("StructureVariant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("variantType", CodeableConceptSerializer.descriptor)
    b.boolPrim("exact")
    b.intPrim("length")
    b.optionalElement("outer", MolecularSequenceStructureVariantOuterSerializer.descriptor)
    b.optionalElement("inner", MolecularSequenceStructureVariantInnerSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.StructureVariant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      variantType = variantType,
      exact = R4Boolean.of(exact, _exact),
      length = Integer.of(length, _length),
      outer = outer,
      `inner` = `inner`,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant) {
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
  FhirSerializer<MolecularSequence.StructureVariant.Outer> {
  override val descriptor: SerialDescriptor = buildDescriptor("Outer", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant.Outer>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("start")
    b.intPrim("end")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Outer {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.StructureVariant.Outer(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Outer) {
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
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MolecularSequenceStructureVariantInnerSerializer :
  FhirSerializer<MolecularSequence.StructureVariant.Inner> {
  override val descriptor: SerialDescriptor = buildDescriptor("Inner", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MolecularSequence.StructureVariant.Inner>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("start")
    b.intPrim("end")
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Inner {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MolecularSequence.StructureVariant.Inner(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      start = Integer.of(start, _start),
      end = Integer.of(end, _end),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Inner) {
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
    b.intPrim("coordinateSystem")
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("specimen", ReferenceSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("referenceSeq", MolecularSequenceReferenceSeqSerializer.descriptor)
    b.optionalElement("variant", MolecularSequenceVariantSerializer.listSerializer.descriptor)
    b.strPrim("observedSeq")
    b.optionalElement("quality", MolecularSequenceQualitySerializer.listSerializer.descriptor)
    b.intPrim("readCoverage")
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
    var type: SequenceType? = null
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
        11 -> type = SequenceType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
      coordinateSystem =
        required(
          Integer.of(coordinateSystem, _coordinateSystem),
          "MolecularSequence",
          "coordinateSystem",
        ),
      patient = patient,
      specimen = specimen,
      device = device,
      performer = performer,
      quantity = quantity,
      referenceSeq = referenceSeq,
      variant = listOrEmpty(variant),
      observedSeq = R4String.of(observedSeq, _observedSeq),
      quality = listOrEmpty(quality),
      readCoverage = Integer.of(readCoverage, _readCoverage),
      repository = listOrEmpty(repository),
      pointer = listOrEmpty(pointer),
      structureVariant = listOrEmpty(structureVariant),
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      MolecularSequenceRepositorySerializer.listSerializer,
      value.repository,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.pointer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      MolecularSequenceStructureVariantSerializer.listSerializer,
      value.structureVariant,
    )
  }
}
