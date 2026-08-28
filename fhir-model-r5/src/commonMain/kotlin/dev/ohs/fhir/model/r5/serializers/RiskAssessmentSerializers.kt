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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.RiskAssessment
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
      element("probabilityDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_probabilityDecimal", Element.serializer().descriptor, isOptional = true)
      element("probabilityRange", Range.serializer().descriptor, isOptional = true)
      element("qualitativeRisk", CodeableConcept.serializer().descriptor, isOptional = true)
      element("relativeRisk", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_relativeRisk", Element.serializer().descriptor, isOptional = true)
      element("whenPeriod", Period.serializer().descriptor, isOptional = true)
      element("whenRange", Range.serializer().descriptor, isOptional = true)
      element("rationale", KotlinString.serializer().descriptor, isOptional = true)
      element("_rationale", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RiskAssessment.Prediction {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var outcome: CodeableConcept? = null
    var probabilityDecimal: FhirDecimal? = null
    var _probabilityDecimal: Element? = null
    var probabilityRange: Range? = null
    var qualitativeRisk: CodeableConcept? = null
    var relativeRisk: FhirDecimal? = null
    var _relativeRisk: Element? = null
    var whenPeriod: Period? = null
    var whenRange: Range? = null
    var rationale: KotlinString? = null
    var _rationale: Element? = null
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
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outcomeSer, null)
        4 ->
          probabilityDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        5 ->
          _probabilityDecimal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.probabilityDecimalSer,
              null,
            )
        6 ->
          probabilityRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.probabilityRangeSer,
              null,
            )
        7 ->
          qualitativeRisk =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outcomeSer, null)
        8 ->
          relativeRisk =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        9 ->
          _relativeRisk =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.probabilityDecimalSer,
              null,
            )
        10 ->
          whenPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.whenPeriodSer, null)
        11 ->
          whenRange =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.probabilityRangeSer,
              null,
            )
        12 -> rationale = decoder.decodeStringElement(descriptor, i)
        13 ->
          _rationale =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.probabilityDecimalSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Prediction: " + i)
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
      rationale = R5String.of(rationale, _rationale),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: RiskAssessment.Prediction) {
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
    (value.outcome)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.outcomeSer, it)
    }
    when (val choice = value.probability) {
      null -> {}
      is RiskAssessment.Prediction.Probability.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 4, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.probabilityDecimalSer, it)
        }
      }
      is RiskAssessment.Prediction.Probability.Range -> {
        encoder.encodeSerializableElement(descriptor, 6, Hoisted.probabilityRangeSer, choice.value)
      }
    }
    (value.qualitativeRisk)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.outcomeSer, it)
    }
    ((value.relativeRisk?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 8, FhirDecimalSerializer, it)
    }
    (value.relativeRisk?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.probabilityDecimalSer, it)
    }
    when (val choice = value.`when`) {
      null -> {}
      is RiskAssessment.Prediction.When.Period -> {
        encoder.encodeSerializableElement(descriptor, 10, Hoisted.whenPeriodSer, choice.value)
      }
      is RiskAssessment.Prediction.When.Range -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.probabilityRangeSer, choice.value)
      }
    }
    ((value.rationale?.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.rationale?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.probabilityDecimalSer, it)
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

internal object RiskAssessmentSerializer : KSerializer<RiskAssessment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment") {
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
    b.element("basedOn", Reference.serializer().descriptor, isOptional = true)
    b.element("parent", Reference.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("condition", Reference.serializer().descriptor, isOptional = true)
    b.element("performer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "reason",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("basis", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "prediction",
      listSerialDescriptor(lazyDescriptor { RiskAssessment.Prediction.serializer().descriptor }),
      isOptional = true,
    )
    b.element("mitigation", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_mitigation", Element.serializer().descriptor, isOptional = true)
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): RiskAssessment =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "RiskAssessment")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): RiskAssessment {
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
    var reason: List<CodeableReference>? = null
    var basis: List<Reference>? = null
    var prediction: List<RiskAssessment.Prediction>? = null
    var mitigation: KotlinString? = null
    var _mitigation: Element? = null
    var note: List<Annotation>? = null
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        12 ->
          parent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        16 ->
          code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        19 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        22 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basedOnSer, null)
        24 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        25 ->
          basis = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.basisSer, null)
        26 ->
          prediction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.predictionSer, null)
        27 -> mitigation = decoder.decodeStringElement(descriptor, i)
        28 ->
          _mitigation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        else -> throw SerializationException("Unexpected index decoding RiskAssessment: " + i)
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
      status =
        Enumeration.of(status?.let { RiskAssessment.ObservationStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on RiskAssessment"),
      method = method,
      code = code,
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on RiskAssessment"),
      encounter = encounter,
      occurrence =
        RiskAssessment.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
        ),
      condition = condition,
      performer = performer,
      reason = reason ?: listOf(),
      basis = basis ?: listOf(),
      prediction = prediction ?: listOf(),
      mitigation = R5String.of(mitigation, _mitigation),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RiskAssessment,
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
    (value.basedOn)?.let {
      encoder.encodeSerializableElement(descriptor, 11 + descriptorOffset, Hoisted.basedOnSer, it)
    }
    (value.parent)?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, Hoisted.basedOnSer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.methodSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.methodSer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      Hoisted.basedOnSer,
      value.subject,
    )
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.basedOnSer, it)
    }
    when (val choice = value.occurrence) {
      null -> {}
      is RiskAssessment.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is RiskAssessment.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          Hoisted.occurrencePeriodSer,
          choice.value,
        )
      }
    }
    (value.condition)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.basedOnSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.basedOnSer, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.reasonSer,
        value.reason,
      )
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.basisSer,
        value.basis,
      )
    if (value.prediction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.predictionSer,
        value.prediction,
      )
    ((value.mitigation?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.mitigation?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.noteSer,
        value.note,
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

    public val basedOnSer: KSerializer<Reference> = Reference.serializer()

    public val methodSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val basisSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSer)

    public val predictionSerInner: KSerializer<RiskAssessment.Prediction> =
      RiskAssessment.Prediction.serializer()

    public val predictionSer: KSerializer<List<RiskAssessment.Prediction>> =
      ListSerializer(Hoisted.predictionSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}

internal object RiskAssessmentPolymorphicSerializer : KSerializer<RiskAssessment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RiskAssessment") { RiskAssessmentSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment) {
    encoder.encodeStructure(descriptor) {
      RiskAssessmentSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): RiskAssessment =
    decoder.decodeStructure(descriptor) {
      RiskAssessmentSerializer.deserializeInternal(this, descriptor, 0)
    }
}
