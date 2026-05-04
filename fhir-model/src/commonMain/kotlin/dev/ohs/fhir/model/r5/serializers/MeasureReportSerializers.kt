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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element(
        "population",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Population.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("measureScoreQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("measureScoreDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_measureScoreDateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "measureScoreCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("measureScorePeriod", Period.serializer().descriptor, isOptional = true)
      element("measureScoreRange", Range.serializer().descriptor, isOptional = true)
      element("measureScoreDuration", Duration.serializer().descriptor, isOptional = true)
      element(
        "stratifier",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Stratifier.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.subjectSer, null)
        7 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.populationSer, null)
        8 ->
          measureScoreQuantity =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.measureScoreQuantitySer,
              null,
            )
        9 -> measureScoreDateTime = decoder.decodeStringElement(__desc, 9)
        10 ->
          _measureScoreDateTime =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.linkIdSer, null)
        11 ->
          measureScoreCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.codeSer, null)
        12 ->
          measureScorePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.measureScorePeriodSer,
              null,
            )
        13 ->
          measureScoreRange =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.measureScoreRangeSer,
              null,
            )
        14 ->
          measureScoreDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.measureScoreDurationSer,
              null,
            )
        15 ->
          stratifier =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.stratifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + __i)
      }
    }
    return MeasureReport.Group(
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
          DateTime.of(FhirDateTime.fromString(measureScoreDateTime), _measureScoreDateTime),
          measureScoreCodeableConcept,
          measureScorePeriod,
          measureScoreRange,
          measureScoreDuration,
        ),
      stratifier = stratifier ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.subjectSer, it) }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.populationSer, value.population)
    when (val __d = value.measureScore) {
      null -> {}
      is MeasureReport.Group.MeasureScore.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.measureScoreQuantitySer, __d.value)
      }
      is MeasureReport.Group.MeasureScore.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.linkIdSer, it)
        }
      }
      is MeasureReport.Group.MeasureScore.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.codeSer, __d.value)
      }
      is MeasureReport.Group.MeasureScore.Period -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.measureScorePeriodSer, __d.value)
      }
      is MeasureReport.Group.MeasureScore.Range -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.measureScoreRangeSer, __d.value)
      }
      is MeasureReport.Group.MeasureScore.Duration -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.measureScoreDurationSer, __d.value)
      }
    }
    if (value.stratifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.stratifierSer, value.stratifier)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val populationSerInner: KSerializer<MeasureReport.Group.Population> =
      MeasureReport.Group.Population.serializer()

    public val populationSer: KSerializer<List<MeasureReport.Group.Population>> =
      ListSerializer(Hoisted.populationSerInner)

    public val measureScoreQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val measureScorePeriodSer: KSerializer<Period> = Period.serializer()

    public val measureScoreRangeSer: KSerializer<Range> = Range.serializer()

    public val measureScoreDurationSer: KSerializer<Duration> = Duration.serializer()

    public val stratifierSerInner: KSerializer<MeasureReport.Group.Stratifier> =
      MeasureReport.Group.Stratifier.serializer()

    public val stratifierSer: KSerializer<List<MeasureReport.Group.Stratifier>> =
      ListSerializer(Hoisted.stratifierSerInner)
  }
}

internal object MeasureReportGroupPopulationSerializer :
  KSerializer<MeasureReport.Group.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element("subjectResults", Reference.serializer().descriptor, isOptional = true)
      element(
        "subjectReport",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("subjects", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Population {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 -> count = decoder.decodeIntElement(__desc, 6)
        7 -> _count = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.linkIdSer, null)
        8 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.subjectResultsSer, null)
        9 ->
          subjectReport =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.subjectReportSer, null)
        10 ->
          subjects =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.subjectResultsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return MeasureReport.Group.Population(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group.Population) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.linkIdSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.subjectResultsSer, it)
    }
    if (value.subjectReport.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.subjectReportSer, value.subjectReport)
    (value.subjects)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.subjectResultsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectResultsSer: KSerializer<Reference> = Reference.serializer()

    public val subjectReportSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectResultsSer)
  }
}

internal object MeasureReportGroupStratifierSerializer :
  KSerializer<MeasureReport.Group.Stratifier> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratifier") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "stratum",
        listSerialDescriptor(
          lazyDescriptor { MeasureReport.Group.Stratifier.Stratum.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Stratifier {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          stratum = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.stratumSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratifier: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R5String.of(linkId, _linkId),
      code = code,
      stratum = stratum ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport.Group.Stratifier) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    if (value.stratum.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.stratumSer, value.stratum)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val stratumSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum> =
      MeasureReport.Group.Stratifier.Stratum.serializer()

    public val stratumSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum>> =
      ListSerializer(Hoisted.stratumSerInner)
  }
}

internal object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stratum") {
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
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "component",
        listSerialDescriptor(
          lazyDescriptor {
            MeasureReport.Group.Stratifier.Stratum.Component.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element(
        "population",
        listSerialDescriptor(
          lazyDescriptor {
            MeasureReport.Group.Stratifier.Stratum.Population.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element("measureScoreQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("measureScoreDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_measureScoreDateTime", Element.serializer().descriptor, isOptional = true)
      element(
        "measureScoreCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("measureScorePeriod", Period.serializer().descriptor, isOptional = true)
      element("measureScoreRange", Range.serializer().descriptor, isOptional = true)
      element("measureScoreDuration", Duration.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): MeasureReport.Group.Stratifier.Stratum {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        4 -> valueBoolean = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.valueBooleanSer, null)
        6 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueQuantitySer, null)
        7 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.valueRangeSer, null)
        8 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueReferenceSer, null)
        9 ->
          component =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.componentSer, null)
        10 ->
          population =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.populationSer, null)
        11 ->
          measureScoreQuantity =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueQuantitySer, null)
        12 -> measureScoreDateTime = decoder.decodeStringElement(__desc, 12)
        13 ->
          _measureScoreDateTime =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.valueBooleanSer, null)
        14 ->
          measureScoreCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              14,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        15 ->
          measureScorePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              15,
              Hoisted.measureScorePeriodSer,
              null,
            )
        16 ->
          measureScoreRange =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueRangeSer, null)
        17 ->
          measureScoreDuration =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.measureScoreDurationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratum: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum(
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
          DateTime.of(FhirDateTime.fromString(measureScoreDateTime), _measureScoreDateTime),
          measureScoreCodeableConcept,
          measureScorePeriod,
          measureScoreRange,
          measureScoreDuration,
        ),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.valueBooleanSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.valueQuantitySer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.valueRangeSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.valueReferenceSer, __d.value)
      }
    }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.componentSer, value.component)
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.populationSer, value.population)
    when (val __d = value.measureScore) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Quantity -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.valueQuantitySer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 12, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 13, Hoisted.valueBooleanSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 14, Hoisted.valueCodeableConceptSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Period -> {
        encoder.encodeSerializableElement(__desc, 15, Hoisted.measureScorePeriodSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Range -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.valueRangeSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Duration -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.measureScoreDurationSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val componentSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> =
      MeasureReport.Group.Stratifier.Stratum.Component.serializer()

    public val componentSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Component>> =
      ListSerializer(Hoisted.componentSerInner)

    public val populationSerInner: KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> =
      MeasureReport.Group.Stratifier.Stratum.Population.serializer()

    public val populationSer: KSerializer<List<MeasureReport.Group.Stratifier.Stratum.Population>> =
      ListSerializer(Hoisted.populationSerInner)

    public val measureScorePeriodSer: KSerializer<Period> = Period.serializer()

    public val measureScoreDurationSer: KSerializer<Duration> = Duration.serializer()
  }
}

internal object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Component") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueRange", Range.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Component {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.codeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.linkIdSer, null)
        9 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueQuantitySer, null)
        10 ->
          valueRange =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueRangeSer, null)
        11 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum.Component(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R5String.of(linkId, _linkId),
      code = code!!,
      `value` =
        MeasureReport.Group.Stratifier.Stratum.Component.Value.from(
          valueCodeableConcept,
          R5Boolean.of(valueBoolean, _valueBoolean),
          valueQuantity,
          valueRange,
          valueReference,
        )!!,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.codeSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.linkIdSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueQuantitySer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Range -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueRangeSer, __d.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.valueReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueRangeSer: KSerializer<Range> = Range.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Population") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("count", Int.serializer().descriptor, isOptional = true)
      element("_count", Element.serializer().descriptor, isOptional = true)
      element("subjectResults", Reference.serializer().descriptor, isOptional = true)
      element(
        "subjectReport",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("subjects", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Population {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 -> count = decoder.decodeIntElement(__desc, 6)
        7 -> _count = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.linkIdSer, null)
        8 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.subjectResultsSer, null)
        9 ->
          subjectReport =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.subjectReportSer, null)
        10 ->
          subjects =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.subjectResultsSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + __i)
      }
    }
    return MeasureReport.Group.Stratifier.Stratum.Population(
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(__desc, 6, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.linkIdSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.subjectResultsSer, it)
    }
    if (value.subjectReport.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.subjectReportSer, value.subjectReport)
    (value.subjects)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.subjectResultsSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectResultsSer: KSerializer<Reference> = Reference.serializer()

    public val subjectReportSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectResultsSer)
  }
}

internal object MeasureReportSerializer : KSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MeasureReport") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("dataUpdateType", KotlinString.serializer().descriptor, isOptional = true)
      element("_dataUpdateType", Element.serializer().descriptor, isOptional = true)
      element("measure", KotlinString.serializer().descriptor, isOptional = true)
      element("_measure", Element.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("reporter", Reference.serializer().descriptor, isOptional = true)
      element("reportingVendor", Reference.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("inputParameters", Reference.serializer().descriptor, isOptional = true)
      element("scoring", CodeableConcept.serializer().descriptor, isOptional = true)
      element("improvementNotation", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "group",
        listSerialDescriptor(lazyDescriptor { MeasureReport.Group.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "supplementalData",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "evaluatedResource",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MeasureReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MeasureReport {
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> type = decoder.decodeStringElement(__desc, 14)
        15 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> dataUpdateType = decoder.decodeStringElement(__desc, 16)
        17 ->
          _dataUpdateType =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> measure = decoder.decodeStringElement(__desc, 18)
        19 ->
          _measure =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.subjectSer, null)
        21 -> date = decoder.decodeStringElement(__desc, 21)
        22 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          reporter = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.subjectSer, null)
        24 ->
          reportingVendor =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.subjectSer, null)
        25 ->
          location = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.subjectSer, null)
        26 ->
          period = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.periodSer, null)
        27 ->
          inputParameters =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectSer, null)
        28 ->
          scoring = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.scoringSer, null)
        29 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.scoringSer, null)
        30 -> group = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.groupSer, null)
        31 ->
          supplementalData =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.supplementalDataSer, null)
        32 ->
          evaluatedResource =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.supplementalDataSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding MeasureReport: " + __i)
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
      status = Enumeration.of(MeasureReport.MeasureReportStatus.fromCode(status!!), _status),
      type = Enumeration.of(MeasureReport.MeasureReportType.fromCode(type!!), _type),
      dataUpdateType =
        dataUpdateType?.let {
          Enumeration.of(MeasureReport.SubmitDataUpdateType.fromCode(it), _dataUpdateType)
        },
      measure = Canonical.of(measure, _measure),
      subject = subject,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      reporter = reporter,
      reportingVendor = reportingVendor,
      location = location,
      period = period!!,
      inputParameters = inputParameters,
      scoring = scoring,
      improvementNotation = improvementNotation,
      group = group ?: listOf(),
      supplementalData = supplementalData ?: listOf(),
      evaluatedResource = evaluatedResource ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: MeasureReport) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MeasureReport")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.dataUpdateType?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.dataUpdateType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.measure?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.measure?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.reporter)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.subjectSer, it) }
    (value.reportingVendor)?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.subjectSer, it)
    }
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.subjectSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.periodSer, it) }
    (value.inputParameters)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectSer, it)
    }
    (value.scoring)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.scoringSer, it) }
    (value.improvementNotation)?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.scoringSer, it)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.groupSer, value.group)
    if (value.supplementalData.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        31,
        Hoisted.supplementalDataSer,
        value.supplementalData,
      )
    if (value.evaluatedResource.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32,
        Hoisted.supplementalDataSer,
        value.evaluatedResource,
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

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val scoringSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val groupSerInner: KSerializer<MeasureReport.Group> = MeasureReport.Group.serializer()

    public val groupSer: KSerializer<List<MeasureReport.Group>> =
      ListSerializer(Hoisted.groupSerInner)

    public val supplementalDataSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.subjectSer)
  }
}
