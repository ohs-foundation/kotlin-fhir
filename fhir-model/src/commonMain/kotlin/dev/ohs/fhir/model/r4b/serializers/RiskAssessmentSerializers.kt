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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.RiskAssessment
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object RiskAssessmentPredictionSerializer : KSerializer<RiskAssessment.Prediction> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Prediction") {
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
      element("outcome", CodeableConcept.serializer().descriptor, isOptional = true)
      element("probabilityDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_probabilityDecimal", Element.serializer().descriptor, isOptional = true)
      element("probabilityRange", Range.serializer().descriptor, isOptional = true)
      element("qualitativeRisk", CodeableConcept.serializer().descriptor, isOptional = true)
      element("relativeRisk", BigDecimalSerializer.descriptor, isOptional = true)
      element("_relativeRisk", Element.serializer().descriptor, isOptional = true)
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
      element("whenRange", Range.serializer().descriptor, isOptional = true)
      element("rationale", KotlinString.serializer().descriptor, isOptional = true)
      element("_rationale", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RiskAssessment.Prediction {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outcome: CodeableConcept? = null
    var probabilityDecimal: BigDecimal? = null
    var _probabilityDecimal: Element? = null
    var probabilityRange: Range? = null
    var qualitativeRisk: CodeableConcept? = null
    var relativeRisk: BigDecimal? = null
    var _relativeRisk: Element? = null
    var whenPeriod: Period? = null
    var whenRange: Range? = null
    var rationale: KotlinString? = null
    var _rationale: Element? = null
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
          outcome = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.outcomeSer, null)
        4 ->
          probabilityDecimal =
            decoder.decodeNullableSerializableElement(__desc, 4, BigDecimalSerializer, null)
        5 ->
          _probabilityDecimal =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.probabilityDecimalSer,
              null,
            )
        6 ->
          probabilityRange =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.probabilityRangeSer, null)
        7 ->
          qualitativeRisk =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.outcomeSer, null)
        8 ->
          relativeRisk =
            decoder.decodeNullableSerializableElement(__desc, 8, BigDecimalSerializer, null)
        9 ->
          _relativeRisk =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.probabilityDecimalSer,
              null,
            )
        10 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.whenPeriodSer, null)
        11 ->
          whenRange =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.probabilityRangeSer, null)
        12 -> rationale = decoder.decodeStringElement(__desc, 12)
        13 ->
          _rationale =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.probabilityDecimalSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Prediction: " + __i)
      }
    }
    return RiskAssessment.Prediction(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      outcome = outcome,
      probability =
        RiskAssessment.Prediction.Probability.from(
          Decimal.of(probabilityDecimal, _probabilityDecimal),
          probabilityRange,
        ),
      qualitativeRisk = qualitativeRisk,
      relativeRisk = Decimal.of(relativeRisk, _relativeRisk),
      `when` = RiskAssessment.Prediction.When.from(whenPeriod, whenRange),
      rationale = R4bString.of(rationale, _rationale),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RiskAssessment.Prediction) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.outcome)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.outcomeSer, it) }
    when (val __d = value.probability) {
      null -> {}
      is RiskAssessment.Prediction.Probability.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 4, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.probabilityDecimalSer, it)
        }
      }
      is RiskAssessment.Prediction.Probability.Range -> {
        encoder.encodeSerializableElement(__desc, 6, Hoisted.probabilityRangeSer, __d.value)
      }
    }
    (value.qualitativeRisk)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.outcomeSer, it)
    }
    ((value.relativeRisk?.value))?.let {
      encoder.encodeSerializableElement(__desc, 8, BigDecimalSerializer, it)
    }
    (value.relativeRisk?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.probabilityDecimalSer, it)
    }
    when (val __d = value.`when`) {
      null -> {}
      is RiskAssessment.Prediction.When.Period -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.whenPeriodSer, __d.value)
      }
      is RiskAssessment.Prediction.When.Range -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.probabilityRangeSer, __d.value)
      }
    }
    ((value.rationale?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.rationale?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.probabilityDecimalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val outcomeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val probabilityDecimalSer: KSerializer<Element> = Element.serializer()

    public val probabilityRangeSer: KSerializer<Range> = Range.serializer()

    public val whenPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object RiskAssessmentOccurrenceSerializer : KSerializer<RiskAssessment.Occurrence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment.Occurrence") {
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Occurrence) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is RiskAssessment.Occurrence.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is RiskAssessment.Occurrence.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Occurrence =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): RiskAssessment.Occurrence {
    val __desc = descriptor
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 0)
        1 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.occurrencePeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding RiskAssessment.Occurrence: " + __i
          )
      }
    }
    return RiskAssessment.Occurrence.from(
      DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
      occurrencePeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object RiskAssessmentPredictionProbabilitySerializer :
  KSerializer<RiskAssessment.Prediction.Probability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment.Prediction.Probability") {
      element("probabilityDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_probabilityDecimal", Element.serializer().descriptor, isOptional = true)
      element("probabilityRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction.Probability) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is RiskAssessment.Prediction.Probability.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 0, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is RiskAssessment.Prediction.Probability.Range -> {
          encodeSerializableElement(__desc, 2, Hoisted.probabilityRangeSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction.Probability =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): RiskAssessment.Prediction.Probability {
    val __desc = descriptor
    var probabilityDecimal: BigDecimal? = null
    var _probabilityDecimal: Element? = null
    var probabilityRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          probabilityDecimal =
            decoder.decodeNullableSerializableElement(__desc, 0, BigDecimalSerializer, null)
        1 ->
          _probabilityDecimal =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          probabilityRange =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.probabilityRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding RiskAssessment.Prediction.Probability: " + __i
          )
      }
    }
    return RiskAssessment.Prediction.Probability.from(
      Decimal.of(probabilityDecimal, _probabilityDecimal),
      probabilityRange,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val probabilityRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object RiskAssessmentPredictionWhenSerializer :
  KSerializer<RiskAssessment.Prediction.When> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment.Prediction.When") {
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
      element("whenRange", Range.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction.When) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is RiskAssessment.Prediction.When.Period -> {
          encodeSerializableElement(__desc, 0, Hoisted.whenPeriodSer, __d.value)
        }
        is RiskAssessment.Prediction.When.Range -> {
          encodeSerializableElement(__desc, 1, Hoisted.whenRangeSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction.When =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): RiskAssessment.Prediction.When {
    val __desc = descriptor
    var whenPeriod: Period? = null
    var whenRange: Range? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.whenPeriodSer, null)
        1 ->
          whenRange =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.whenRangeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding RiskAssessment.Prediction.When: " + __i
          )
      }
    }
    return RiskAssessment.Prediction.When.from(whenPeriod, whenRange)!!
  }

  private object Hoisted {
    public val whenPeriodSer: KSerializer<Period> = Period.serializer()

    public val whenRangeSer: KSerializer<Range> = Range.serializer()
  }
}

internal object RiskAssessmentSerializer : KSerializer<RiskAssessment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment") {
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
      element("basedOn", Reference.serializer().descriptor, isOptional = true)
      element("parent", Reference.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("condition", Reference.serializer().descriptor, isOptional = true)
      element("performer", Reference.serializer().descriptor, isOptional = true)
      element(
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("basis", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "prediction",
        listSerialDescriptor(lazyDescriptor { RiskAssessment.Prediction.serializer().descriptor }),
        isOptional = true,
      )
      element("mitigation", KotlinString.serializer().descriptor, isOptional = true)
      element("_mitigation", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RiskAssessment =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): RiskAssessment {
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
    var basedOn: Reference? = null
    var parent: Reference? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var method: CodeableConcept? = null
    var code: CodeableConcept? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var condition: Reference? = null
    var performer: Reference? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var basis: List<Reference>? = null
    var prediction: List<RiskAssessment.Prediction>? = null
    var mitigation: KotlinString? = null
    var _mitigation: Element? = null
    var note: List<Annotation>? = null
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
        12 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.basedOnSer, null)
        13 ->
          parent = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.basedOnSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          method = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.methodSer, null)
        17 -> code = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.methodSer, null)
        18 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.basedOnSer, null)
        19 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.basedOnSer, null)
        20 -> occurrenceDateTime = decoder.decodeStringElement(__desc, 20)
        21 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.occurrencePeriodSer, null)
        23 ->
          condition =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.basedOnSer, null)
        24 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.basedOnSer, null)
        25 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.reasonCodeSer, null)
        26 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.reasonReferenceSer, null)
        27 ->
          basis =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.reasonReferenceSer, null)
        28 ->
          prediction =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.predictionSer, null)
        29 -> mitigation = decoder.decodeStringElement(__desc, 29)
        30 ->
          _mitigation =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> note = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RiskAssessment: " + __i)
      }
    }
    return RiskAssessment(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      basedOn = basedOn,
      parent = parent,
      status = Enumeration.of(RiskAssessment.ObservationStatus.fromCode(status!!), _status),
      method = method,
      code = code,
      subject = subject!!,
      encounter = encounter,
      occurrence =
        RiskAssessment.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
        ),
      condition = condition,
      performer = performer,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      basis = basis ?: listOf(),
      prediction = prediction ?: listOf(),
      mitigation = R4bString.of(mitigation, _mitigation),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RiskAssessment) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "RiskAssessment")
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
    (value.basedOn)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.basedOnSer, it) }
    (value.parent)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.basedOnSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.methodSer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.methodSer, it) }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.basedOnSer, it) }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.basedOnSer, it) }
    when (val __d = value.occurrence) {
      null -> {}
      is RiskAssessment.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
        }
      }
      is RiskAssessment.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.occurrencePeriodSer, __d.value)
      }
    }
    (value.condition)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.basedOnSer, it) }
    (value.performer)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.basedOnSer, it) }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.reasonCodeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        26,
        Hoisted.reasonReferenceSer,
        value.reasonReference,
      )
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.reasonReferenceSer, value.basis)
    if (value.prediction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.predictionSer, value.prediction)
    ((value.mitigation?.value))?.let { encoder.encodeStringElement(__desc, 29, it) }
    (value.mitigation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 31, Hoisted.noteSer, value.note)
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

    public val basedOnSer: KSerializer<Reference> = Reference.serializer()

    public val methodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val reasonCodeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.methodSer)

    public val reasonReferenceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSer)

    public val predictionSerInner: KSerializer<RiskAssessment.Prediction> =
      RiskAssessment.Prediction.serializer()

    public val predictionSer: KSerializer<List<RiskAssessment.Prediction>> =
      ListSerializer(Hoisted.predictionSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
