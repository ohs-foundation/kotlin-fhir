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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MeasureReport.Group {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        7 ->
          population =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.populationSer, null)
        8 ->
          measureScoreQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScoreQuantitySer,
              null,
            )
        9 -> measureScoreDateTime = decoder.decodeStringElement(descriptor, i)
        10 ->
          _measureScoreDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        11 ->
          measureScoreCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        12 ->
          measureScorePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScorePeriodSer,
              null,
            )
        13 ->
          measureScoreRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScoreRangeSer,
              null,
            )
        14 ->
          measureScoreDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScoreDurationSer,
              null,
            )
        15 ->
          stratifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.stratifierSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Group: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: MeasureReport.Group) {
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.subjectSer, it)
    }
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.populationSer, value.population)
    when (val choice = value.measureScore) {
      null -> {}
      is MeasureReport.Group.MeasureScore.Quantity -> {
        encoder.encodeSerializableElement(
          descriptor,
          8,
          Hoisted.measureScoreQuantitySer,
          choice.value,
        )
      }
      is MeasureReport.Group.MeasureScore.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.linkIdSer, it)
        }
      }
      is MeasureReport.Group.MeasureScore.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.codeSer, choice.value)
      }
      is MeasureReport.Group.MeasureScore.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          12,
          Hoisted.measureScorePeriodSer,
          choice.value,
        )
      }
      is MeasureReport.Group.MeasureScore.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          13,
          Hoisted.measureScoreRangeSer,
          choice.value,
        )
      }
      is MeasureReport.Group.MeasureScore.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          14,
          Hoisted.measureScoreDurationSer,
          choice.value,
        )
      }
    }
    if (value.stratifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.stratifierSer, value.stratifier)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MeasureReport.Group.Population {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 -> count = decoder.decodeIntElement(descriptor, i)
        7 ->
          _count = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        8 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectResultsSer,
              null,
            )
        9 ->
          subjectReport =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectReportSer, null)
        10 ->
          subjects =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectResultsSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Population,
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.linkIdSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.subjectResultsSer, it)
    }
    if (value.subjectReport.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.subjectReportSer,
        value.subjectReport,
      )
    (value.subjects)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.subjectResultsSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): MeasureReport.Group.Stratifier {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var code: CodeableConcept? = null
    var stratum: List<MeasureReport.Group.Stratifier.Stratum>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 ->
          stratum =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.stratumSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratifier: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier,
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
    if (value.stratum.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.stratumSer, value.stratum)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        4 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        6 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        7 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        8 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        9 ->
          component =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.componentSer, null)
        10 ->
          population =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.populationSer, null)
        11 ->
          measureScoreQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        12 -> measureScoreDateTime = decoder.decodeStringElement(descriptor, i)
        13 ->
          _measureScoreDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        14 ->
          measureScoreCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueCodeableConceptSer,
              null,
            )
        15 ->
          measureScorePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScorePeriodSer,
              null,
            )
        16 ->
          measureScoreRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        17 ->
          measureScoreDuration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.measureScoreDurationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stratum: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum,
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
    when (val choice = value.`value`) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.valueCodeableConceptSer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueBooleanSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueQuantitySer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueRangeSer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueReferenceSer, choice.value)
      }
    }
    if (value.component.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.componentSer, value.component)
    if (value.population.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.populationSer, value.population)
    when (val choice = value.measureScore) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueQuantitySer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, Hoisted.valueBooleanSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          14,
          Hoisted.valueCodeableConceptSer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          15,
          Hoisted.measureScorePeriodSer,
          choice.value,
        )
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Range -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueRangeSer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.MeasureScore.Duration -> {
        encoder.encodeSerializableElement(
          descriptor,
          17,
          Hoisted.measureScoreDurationSer,
          choice.value,
        )
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Component {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        7 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        9 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        10 ->
          valueRange =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueRangeSer, null)
        11 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Component: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
    when (val choice = value.`value`) {
      null -> {}
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.codeSer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.linkIdSer, it)
        }
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 9, Hoisted.valueQuantitySer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Range -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueRangeSer, choice.value)
      }
      is MeasureReport.Group.Stratifier.Stratum.Component.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueReferenceSer, choice.value)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MeasureReport.Group.Stratifier.Stratum.Population {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        6 -> count = decoder.decodeIntElement(descriptor, i)
        7 ->
          _count = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        8 ->
          subjectResults =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectResultsSer,
              null,
            )
        9 ->
          subjectReport =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectReportSer, null)
        10 ->
          subjects =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.subjectResultsSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Population: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
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
    ((value.linkId?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.codeSer, it) }
    ((value.count?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.count?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.linkIdSer, it)
    }
    (value.subjectResults)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.subjectResultsSer, it)
    }
    if (value.subjectReport.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.subjectReportSer,
        value.subjectReport,
      )
    (value.subjects)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.subjectResultsSer, it)
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("dataUpdateType", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_dataUpdateType", Element.serializer().descriptor, isOptional = true)
    b.element("measure", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_measure", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("reporter", Reference.serializer().descriptor, isOptional = true)
    b.element("reportingVendor", Reference.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("inputParameters", Reference.serializer().descriptor, isOptional = true)
    b.element("scoring", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("improvementNotation", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "group",
      listSerialDescriptor(lazyDescriptor { MeasureReport.Group.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "supplementalData",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "evaluatedResource",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MeasureReport")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> type = decoder.decodeStringElement(descriptor, i)
        14 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> dataUpdateType = decoder.decodeStringElement(descriptor, i)
        16 ->
          _dataUpdateType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> measure = decoder.decodeStringElement(descriptor, i)
        18 ->
          _measure =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        20 -> date = decoder.decodeStringElement(descriptor, i)
        21 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          reporter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        23 ->
          reportingVendor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        24 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        25 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        26 ->
          inputParameters =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        27 ->
          scoring =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoringSer, null)
        28 ->
          improvementNotation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scoringSer, null)
        29 ->
          group = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.groupSer, null)
        30 ->
          supplementalData =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supplementalDataSer,
              null,
            )
        31 ->
          evaluatedResource =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supplementalDataSer,
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MeasureReport,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.type.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.dataUpdateType?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.dataUpdateType?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.measure?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.measure?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.subjectSer, it)
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.reporter)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.reportingVendor)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.periodSer, it)
    }
    (value.inputParameters)?.let {
      encoder.encodeSerializableElement(descriptor, 26 + descriptorOffset, Hoisted.subjectSer, it)
    }
    (value.scoring)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.scoringSer, it)
    }
    (value.improvementNotation)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, Hoisted.scoringSer, it)
    }
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.groupSer,
        value.group,
      )
    if (value.supplementalData.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.supplementalDataSer,
        value.supplementalData,
      )
    if (value.evaluatedResource.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
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

internal object MeasureReportPolymorphicSerializer : KSerializer<MeasureReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MeasureReport") { MeasureReportSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    encoder.encodeStructure(descriptor) {
      MeasureReportSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    decoder.decodeStructure(descriptor) {
      MeasureReportSerializer.deserializeInternal(this, descriptor, 0)
    }
}
