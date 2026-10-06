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

internal object MeasureReportGroupSerializer : KSerializer<MeasureReport.Group> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Group") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("subject", ReferenceSerializer.descriptor)
      optionalElement(
        "population",
        MeasureReportGroupPopulationSerializer.listSerializer.descriptor,
      )
      optionalElement("measureScoreQuantity", QuantitySerializer.descriptor)
      optionalElement("measureScoreDateTime", KotlinString.serializer().descriptor)
      optionalElement("_measureScoreDateTime", ElementSerializer.descriptor)
      optionalElement("measureScoreCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("measureScorePeriod", PeriodSerializer.descriptor)
      optionalElement("measureScoreRange", RangeSerializer.descriptor)
      optionalElement("measureScoreDuration", DurationSerializer.descriptor)
      optionalElement(
        "stratifier",
        MeasureReportGroupStratifierSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var linkId: KotlinString? = null
      var _linkId: Element? = null
      var code: CodeableConcept? = null
      var subject: Reference? = null
      var population: List<MeasureReport.Group.Population>? = null
      var measureScoreQuantity: Quantity? = null
      var measureScoreDateTime: KotlinString? = null
      var _measureScoreDateTime: Element? = null
      var measureScoreCodeableConcept: CodeableConcept? = null
      var measureScorePeriod: Period? = null
      var measureScoreRange: Range? = null
      var measureScoreDuration: Duration? = null
      var stratifier: List<MeasureReport.Group.Stratifier>? = null
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> subject = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            population =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupPopulationSerializer.listSerializer,
                null,
              )
          8 ->
            measureScoreQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> measureScoreDateTime = decodeStringElement(descriptor, i)
          10 ->
            _measureScoreDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            measureScoreCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            measureScorePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          13 ->
            measureScoreRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          14 ->
            measureScoreDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          15 ->
            stratifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Group: " + i)
        }
      }
      MeasureReport.Group(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        code = code,
        subject = subject,
        population = population ?: listOf(),
        measureScore =
          MeasureReport.Group.MeasureScore.from(
            measureScoreQuantity,
            DateTime.of(
              if (measureScoreDateTime != null) FhirDateTime.fromString(measureScoreDateTime)
              else null,
              _measureScoreDateTime,
            ),
            measureScoreCodeableConcept,
            measureScorePeriod,
            measureScoreRange,
            measureScoreDuration,
          ),
        stratifier = stratifier ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.subject)
      if (value.population.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          MeasureReportGroupPopulationSerializer.listSerializer,
          value.population,
        )
      when (val choice = value.measureScore) {
        null -> {}
        is MeasureReport.Group.MeasureScore.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is MeasureReport.Group.MeasureScore.DateTime -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is MeasureReport.Group.MeasureScore.CodeableConcept -> {
          encodeSerializableElement(descriptor, 11, CodeableConceptSerializer, choice.value)
        }
        is MeasureReport.Group.MeasureScore.Period -> {
          encodeSerializableElement(descriptor, 12, PeriodSerializer, choice.value)
        }
        is MeasureReport.Group.MeasureScore.Range -> {
          encodeSerializableElement(descriptor, 13, RangeSerializer, choice.value)
        }
        is MeasureReport.Group.MeasureScore.Duration -> {
          encodeSerializableElement(descriptor, 14, DurationSerializer, choice.value)
        }
      }
      if (value.stratifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          MeasureReportGroupStratifierSerializer.listSerializer,
          value.stratifier,
        )
    }
  }
}

internal object MeasureReportGroupPopulationSerializer :
  KSerializer<MeasureReport.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
      optionalElement("subjectResults", ReferenceSerializer.descriptor)
      optionalElement("subjectReport", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("subjects", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Population>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    decoder.decodeStructure(descriptor) {
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> count = decodeIntElement(descriptor, i)
          7 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            subjectResults =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            subjectReport =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          10 ->
            subjects = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Population: " + i)
        }
      }
      MeasureReport.Group.Population(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        code = code,
        count = Integer.of(count, _count),
        subjectResults = subjectResults,
        subjectReport = subjectReport ?: listOf(),
        subjects = subjects,
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      encodeIntIfNotNull(descriptor, 6, value.count?.value)
      encodeElementIfNotNull(descriptor, 7, value.count)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.subjectResults)
      if (value.subjectReport.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          ReferenceSerializer.listSerializer,
          value.subjectReport,
        )
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.subjects)
    }
  }
}

internal object MeasureReportGroupStratifierSerializer :
  KSerializer<MeasureReport.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement(
        "stratum",
        MeasureReportGroupStratifierStratumSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var linkId: KotlinString? = null
      var _linkId: Element? = null
      var code: CodeableConcept? = null
      var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            stratum =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stratifier: " + i)
        }
      }
      MeasureReport.Group.Stratifier(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        code = code,
        stratum = stratum ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      if (value.stratum.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          MeasureReportGroupStratifierStratumSerializer.listSerializer,
          value.stratum,
        )
    }
  }
}

internal object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratum") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement(
        "component",
        MeasureReportGroupStratifierStratumComponentSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "population",
        MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer.descriptor,
      )
      optionalElement("measureScoreQuantity", QuantitySerializer.descriptor)
      optionalElement("measureScoreDateTime", KotlinString.serializer().descriptor)
      optionalElement("_measureScoreDateTime", ElementSerializer.descriptor)
      optionalElement("measureScoreCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("measureScorePeriod", PeriodSerializer.descriptor)
      optionalElement("measureScoreRange", RangeSerializer.descriptor)
      optionalElement("measureScoreDuration", DurationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum =
    decoder.decodeStructure(descriptor) {
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
      var measureScoreDateTime: KotlinString? = null
      var _measureScoreDateTime: Element? = null
      var measureScoreCodeableConcept: CodeableConcept? = null
      var measureScorePeriod: Period? = null
      var measureScoreRange: Range? = null
      var measureScoreDuration: Duration? = null
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
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> valueBoolean = decodeBooleanElement(descriptor, i)
          5 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          8 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            component =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
                null,
              )
          10 ->
            population =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
                null,
              )
          11 ->
            measureScoreQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          12 -> measureScoreDateTime = decodeStringElement(descriptor, i)
          13 ->
            _measureScoreDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            measureScoreCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
            measureScorePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          16 ->
            measureScoreRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          17 ->
            measureScoreDuration =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stratum: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          MeasureReport.Group.Stratifier.Stratum.Value.from(
            valueCodeableConcept,
            R5Boolean.of(valueBoolean, _valueBoolean),
            valueQuantity,
            valueRange,
            valueReference,
          ),
        component = component ?: listOf(),
        population = population ?: listOf(),
        measureScore =
          MeasureReport.Group.Stratifier.Stratum.MeasureScore.from(
            measureScoreQuantity,
            DateTime.of(
              if (measureScoreDateTime != null) FhirDateTime.fromString(measureScoreDateTime)
              else null,
              _measureScoreDateTime,
            ),
            measureScoreCodeableConcept,
            measureScorePeriod,
            measureScoreRange,
            measureScoreDuration,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
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
      when (val choice = value.`value`) {
        null -> {}
        is MeasureReport.Group.Stratifier.Stratum.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Value.Quantity -> {
          encodeSerializableElement(descriptor, 6, QuantitySerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Value.Range -> {
          encodeSerializableElement(descriptor, 7, RangeSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Value.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
      }
      if (value.component.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          MeasureReportGroupStratifierStratumComponentSerializer.listSerializer,
          value.component,
        )
      if (value.population.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          MeasureReportGroupStratifierStratumPopulationSerializer.listSerializer,
          value.population,
        )
      when (val choice = value.measureScore) {
        null -> {}
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Quantity -> {
          encodeSerializableElement(descriptor, 11, QuantitySerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.DateTime -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.CodeableConcept -> {
          encodeSerializableElement(descriptor, 14, CodeableConceptSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Period -> {
          encodeSerializableElement(descriptor, 15, PeriodSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Range -> {
          encodeSerializableElement(descriptor, 16, RangeSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Duration -> {
          encodeSerializableElement(descriptor, 17, DurationSerializer, choice.value)
        }
      }
    }
  }
}

internal object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueRange", RangeSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Component>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component =
    decoder.decodeStructure(descriptor) {
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> valueBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> valueRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          11 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Component: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum.Component(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MeasureReport.Group.Stratifier.Stratum.Component"
            ),
        `value` =
          MeasureReport.Group.Stratifier.Stratum.Component.Value.from(
            valueCodeableConcept,
            R5Boolean.of(valueBoolean, _valueBoolean),
            valueQuantity,
            valueRange,
            valueReference,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on MeasureReport.Group.Stratifier.Stratum.Component"
            ),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.code)
      when (val choice = value.`value`) {
        is MeasureReport.Group.Stratifier.Stratum.Component.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Component.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Component.Value.Quantity -> {
          encodeSerializableElement(descriptor, 9, QuantitySerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Component.Value.Range -> {
          encodeSerializableElement(descriptor, 10, RangeSerializer, choice.value)
        }
        is MeasureReport.Group.Stratifier.Stratum.Component.Value.Reference -> {
          encodeSerializableElement(descriptor, 11, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("count", Int.serializer().descriptor)
      optionalElement("_count", ElementSerializer.descriptor)
      optionalElement("subjectResults", ReferenceSerializer.descriptor)
      optionalElement("subjectReport", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("subjects", ReferenceSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Population>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    decoder.decodeStructure(descriptor) {
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> count = decodeIntElement(descriptor, i)
          7 -> _count = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            subjectResults =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            subjectReport =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          10 ->
            subjects = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Population: " + i)
        }
      }
      MeasureReport.Group.Stratifier.Stratum.Population(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId = R5String.of(linkId, _linkId),
        code = code,
        count = Integer.of(count, _count),
        subjectResults = subjectResults,
        subjectReport = subjectReport ?: listOf(),
        subjects = subjects,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId?.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      encodeIntIfNotNull(descriptor, 6, value.count?.value)
      encodeElementIfNotNull(descriptor, 7, value.count)
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.subjectResults)
      if (value.subjectReport.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          ReferenceSerializer.listSerializer,
          value.subjectReport,
        )
      encodeSerializableIfNotNull(descriptor, 10, ReferenceSerializer, value.subjects)
    }
  }
}

internal object MeasureReportSerializer : FhirResourceSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("MeasureReport")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("dataUpdateType", KotlinString.serializer().descriptor)
    b.optionalElement("_dataUpdateType", ElementSerializer.descriptor)
    b.optionalElement("measure", KotlinString.serializer().descriptor)
    b.optionalElement("_measure", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
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
    decoder: CompositeDecoder,
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
    var status: KotlinString? = null
    var _status: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var dataUpdateType: KotlinString? = null
    var _dataUpdateType: Element? = null
    var measure: KotlinString? = null
    var _measure: Element? = null
    var subject: Reference? = null
    var date: KotlinString? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> type = decoder.decodeStringElement(descriptor, i)
        14 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> dataUpdateType = decoder.decodeStringElement(descriptor, i)
        16 ->
          _dataUpdateType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> measure = decoder.decodeStringElement(descriptor, i)
        18 ->
          _measure =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 -> date = decoder.decodeStringElement(descriptor, i)
        21 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          reporter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          reportingVendor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        26 ->
          inputParameters =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          scoring =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        29 ->
          group =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MeasureReportGroupSerializer.listSerializer,
              null,
            )
        30 ->
          supplementalData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        31 ->
          evaluatedResource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding MeasureReport: " + i)
      }
    }
    return MeasureReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) MeasureReport.MeasureReportStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on MeasureReport"),
      type =
        Enumeration.of(
          if (type != null) MeasureReport.MeasureReportType.fromCode(type) else null,
          _type,
        ) ?: throw SerializationException("Missing required property 'type' on MeasureReport"),
      dataUpdateType =
        Enumeration.of(
          if (dataUpdateType != null) MeasureReport.SubmitDataUpdateType.fromCode(dataUpdateType)
          else null,
          _dataUpdateType,
        ),
      measure = Canonical.of(measure, _measure),
      subject = subject,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      reporter = reporter,
      reportingVendor = reportingVendor,
      location = location,
      period =
        period
          ?: throw SerializationException("Missing required property 'period' on MeasureReport"),
      inputParameters = inputParameters,
      scoring = scoring,
      improvementNotation = improvementNotation,
      group = group ?: listOf(),
      supplementalData = supplementalData ?: listOf(),
      evaluatedResource = evaluatedResource ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MeasureReport,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.dataUpdateType?.value?.code,
    )
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.dataUpdateType)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.measure?.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.measure)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.reporter,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.reportingVendor,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableElement(
      descriptor,
      25 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.inputParameters,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.scoring,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      CodeableConceptSerializer,
      value.improvementNotation,
    )
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MeasureReportGroupSerializer.listSerializer,
        value.group,
      )
    if (value.supplementalData.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supplementalData,
      )
    if (value.evaluatedResource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.evaluatedResource,
      )
  }
}
