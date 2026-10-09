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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Duration
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.MeasureReport
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.MeasureReportStatus
import dev.ohs.fhir.model.r5.terminologies.MeasureReportType
import dev.ohs.fhir.model.r5.terminologies.SubmitDataUpdateType
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

internal object MeasureReportGroupSerializer : FhirSerializer<MeasureReport.Group> {
  override val descriptor: SerialDescriptor = buildDescriptor("Group", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MeasureReport.Group>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement(
      "population",
      MeasureReportGroupPopulationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("measureScoreQuantity", QuantitySerializer.descriptor)
    b.strPrim("measureScoreDateTime")
    b.optionalElement("measureScoreCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("measureScorePeriod", PeriodSerializer.descriptor)
    b.optionalElement("measureScoreRange", RangeSerializer.descriptor)
    b.optionalElement("measureScoreDuration", DurationSerializer.descriptor)
    b.optionalElement(
      "stratifier",
      MeasureReportGroupStratifierSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var population: List<MeasureReport.Group.Population>? = null
    var measureScoreQuantity: Quantity? = null
    var measureScoreDateTime: FhirDateTime? = null
    var _measureScoreDateTime: Element? = null
    var measureScoreCodeableConcept: CodeableConcept? = null
    var measureScorePeriod: Period? = null
    var measureScoreRange: Range? = null
    var measureScoreDuration: Duration? = null
    var stratifier: List<MeasureReport.Group.Stratifier>? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 ->
          population =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupPopulationSerializer.listSerializer,
              null,
            )
        8 ->
          measureScoreQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        9 ->
          measureScoreDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _measureScoreDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          measureScoreCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          measureScorePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        13 ->
          measureScoreRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        14 ->
          measureScoreDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        15 ->
          stratifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupStratifierSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MeasureReport.Group(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      code = code,
      subject = subject,
      population = listOrEmpty(population),
      measureScore =
        MeasureReport.Group.MeasureScore.from(
          measureScoreQuantity,
          DateTime.of(measureScoreDateTime, _measureScoreDateTime),
          measureScoreCodeableConcept,
          measureScorePeriod,
          measureScoreRange,
          measureScoreDuration,
        ),
      stratifier = listOrEmpty(stratifier),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.subject)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      MeasureReportGroupPopulationSerializer.listSerializer,
      value.population,
    )
    when (val choice = value.measureScore) {
      null -> {}
      is MeasureReport.Group.MeasureScore.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
      }
      is MeasureReport.Group.MeasureScore.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is MeasureReport.Group.MeasureScore.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MeasureReport.Group.MeasureScore.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 12, PeriodSerializer, choice.value)
      }
      is MeasureReport.Group.MeasureScore.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 13, RangeSerializer, choice.value)
      }
      is MeasureReport.Group.MeasureScore.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 14, DurationSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15,
      MeasureReportGroupStratifierSerializer.listSerializer,
      value.stratifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportGroupPopulationSerializer :
  FhirSerializer<MeasureReport.Group.Population> {
  override val descriptor: SerialDescriptor = buildDescriptor("Population", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MeasureReport.Group.Population>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.intPrim("count")
    b.optionalElement("subjectResults", ReferenceSerializer.descriptor)
    b.optionalElement("subjectReport", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subjects", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var count: Int? = null
    var _count: Element? = null
    var subjectResults: Reference? = null
    var subjectReport: List<Reference>? = null
    var subjects: Reference? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          subjectResults =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          subjectReport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        10 ->
          subjects =
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
    return MeasureReport.Group.Population(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      code = code,
      count = Integer.of(count, _count),
      subjectResults = subjectResults,
      subjectReport = listOrEmpty(subjectReport),
      subjects = subjects,
    )
  }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.count)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      ReferenceSerializer,
      value.subjectResults,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ReferenceSerializer.listSerializer,
      value.subjectReport,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.subjects,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportGroupStratifierSerializer :
  FhirSerializer<MeasureReport.Group.Stratifier> {
  override val descriptor: SerialDescriptor = buildDescriptor("Stratifier", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "stratum",
      MeasureReportGroupStratifierStratumSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          stratum =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupStratifierStratumSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MeasureReport.Group.Stratifier(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      code = code,
      stratum = listOrEmpty(stratum),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      6,
      MeasureReportGroupStratifierStratumSerializer.listSerializer,
      value.stratum,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportGroupStratifierStratumSerializer :
  FhirSerializer<MeasureReport.Group.Stratifier.Stratum> {
  override val descriptor: SerialDescriptor = buildDescriptor("Stratum", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.boolPrim("valueBoolean")
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement(
      "component",
      MeasureReportGroupStratifierStratumComponentSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "population",
      MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("measureScoreQuantity", QuantitySerializer.descriptor)
    b.strPrim("measureScoreDateTime")
    b.optionalElement("measureScoreCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("measureScorePeriod", PeriodSerializer.descriptor)
    b.optionalElement("measureScoreRange", RangeSerializer.descriptor)
    b.optionalElement("measureScoreDuration", DurationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
    var component: List<MeasureReport.Group.Stratifier.Stratum.Component>? = null
    var population: List<MeasureReport.Group.Stratifier.Stratum.Population>? = null
    var measureScoreQuantity: Quantity? = null
    var measureScoreDateTime: FhirDateTime? = null
    var _measureScoreDateTime: Element? = null
    var measureScoreCodeableConcept: CodeableConcept? = null
    var measureScorePeriod: Period? = null
    var measureScoreRange: Range? = null
    var measureScoreDuration: Duration? = null
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
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        8 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          component =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
              null,
            )
        10 ->
          population =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
              null,
            )
        11 ->
          measureScoreQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        12 ->
          measureScoreDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _measureScoreDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          measureScoreCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          measureScorePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        16 ->
          measureScoreRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        17 ->
          measureScoreDuration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MeasureReport.Group.Stratifier.Stratum(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` =
        MeasureReport.Group.Stratifier.Stratum.Value.from(
          valueCodeableConcept,
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
          valueReference,
        ),
      component = listOrEmpty(component),
      population = listOrEmpty(population),
      measureScore =
        MeasureReport.Group.Stratifier.Stratum.MeasureScore.from(
          measureScoreQuantity,
          DateTime.of(measureScoreDateTime, _measureScoreDateTime),
          measureScoreCodeableConcept,
          measureScorePeriod,
          measureScoreRange,
          measureScoreDuration,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
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
    when (val choice = value.`value`) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
      value.component,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
      value.population,
    )
    when (val choice = value.measureScore) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          14,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 15, PeriodSerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 16, RangeSerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Duration -> {
        compositeEncoder.encodeSerializableElement(descriptor, 17, DurationSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportGroupStratifierStratumComponentSerializer :
  FhirSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  override val descriptor: SerialDescriptor = buildDescriptor("Component", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Component>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
    b.boolPrim("valueBoolean")
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueRange", RangeSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var valueCodeableConcept: CodeableConcept? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueQuantity: Quantity? = null
    var valueRange: Range? = null
    var valueReference: Reference? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          valueCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        10 ->
          valueRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        11 ->
          valueReference =
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
    return MeasureReport.Group.Stratifier.Stratum.Component(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      code = required(code, "MeasureReport.Group.Stratifier.Stratum.Component", "code"),
      `value` =
        required(
          MeasureReport.Group.Stratifier.Stratum.Component.Value.from(
            valueCodeableConcept,
            R5Boolean.of(valueBoolean, _valueBoolean),
            valueQuantity,
            valueRange,
            valueReference,
          ),
          "MeasureReport.Group.Stratifier.Stratum.Component",
          "value",
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.code)
    when (val choice = value.`value`) {
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          11,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportGroupStratifierStratumPopulationSerializer :
  FhirSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  override val descriptor: SerialDescriptor = buildDescriptor("Population", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Population>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.intPrim("count")
    b.optionalElement("subjectResults", ReferenceSerializer.descriptor)
    b.optionalElement("subjectReport", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subjects", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var count: Int? = null
    var _count: Element? = null
    var subjectResults: Reference? = null
    var subjectReport: List<Reference>? = null
    var subjects: Reference? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> count = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _count =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          subjectResults =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 ->
          subjectReport =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        10 ->
          subjects =
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
    return MeasureReport.Group.Stratifier.Stratum.Population(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = R5String.of(linkId, _linkId),
      code = code,
      count = Integer.of(count, _count),
      subjectResults = subjectResults,
      subjectReport = listOrEmpty(subjectReport),
      subjects = subjects,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.code,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.count?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.count)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      ReferenceSerializer,
      value.subjectResults,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      ReferenceSerializer.listSerializer,
      value.subjectReport,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      ReferenceSerializer,
      value.subjects,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MeasureReportSerializer : FhirResourceSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MeasureReport")

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
    b.strPrim("status")
    b.strPrim("type")
    b.strPrim("dataUpdateType")
    b.strPrim("measure")
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("reporter", ReferenceSerializer.descriptor)
    b.optionalElement("reportingVendor", ReferenceSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("inputParameters", ReferenceSerializer.descriptor)
    b.optionalElement("scoring", CodeableConceptSerializer.descriptor)
    b.optionalElement("improvementNotation", CodeableConceptSerializer.descriptor)
    b.optionalElement("group", MeasureReportGroupSerializer.listSerializer.descriptor)
    b.optionalElement("supplementalData", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("evaluatedResource", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MeasureReport {
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
    var status: MeasureReportStatus? = null
    var _status: Element? = null
    var type: MeasureReportType? = null
    var _type: Element? = null
    var dataUpdateType: SubmitDataUpdateType? = null
    var _dataUpdateType: Element? = null
    var measure: KotlinString? = null
    var _measure: Element? = null
    var subject: Reference? = null
    var date: FhirDateTime? = null
    var _date: Element? = null
    var reporter: Reference? = null
    var reportingVendor: Reference? = null
    var location: Reference? = null
    var period: Period? = null
    var inputParameters: Reference? = null
    var scoring: CodeableConcept? = null
    var improvementNotation: CodeableConcept? = null
    var group: List<MeasureReport.Group>? = null
    var supplementalData: List<Reference>? = null
    var evaluatedResource: List<Reference>? = null
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
        11 ->
          status = MeasureReportStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> type = MeasureReportType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          dataUpdateType =
            SubmitDataUpdateType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _dataUpdateType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> measure = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _measure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          reporter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          reportingVendor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        26 ->
          inputParameters =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 ->
          scoring =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          improvementNotation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 ->
          group =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupSerializer.listSerializer,
              null,
            )
        30 ->
          supplementalData =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          evaluatedResource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MeasureReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "MeasureReport", "status"),
      type = required(Enumeration.of(type, _type), "MeasureReport", "type"),
      dataUpdateType = Enumeration.of(dataUpdateType, _dataUpdateType),
      measure = Canonical.of(measure, _measure),
      subject = subject,
      date = DateTime.of(date, _date),
      reporter = reporter,
      reportingVendor = reportingVendor,
      location = location,
      period = required(period, "MeasureReport", "period"),
      inputParameters = inputParameters,
      scoring = scoring,
      improvementNotation = improvementNotation,
      group = listOrEmpty(group),
      supplementalData = listOrEmpty(supplementalData),
      evaluatedResource = listOrEmpty(evaluatedResource),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MeasureReport,
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
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.type)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.dataUpdateType?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.dataUpdateType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.measure?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.measure)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.reporter,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.reportingVendor,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.inputParameters,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.scoring,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.improvementNotation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      MeasureReportGroupSerializer.listSerializer,
      value.group,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.supplementalData,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.evaluatedResource,
    )
  }
}
