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

import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.RiskAssessment
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("outcome", CodeableConceptSerializer.descriptor)
      optionalElement("probabilityDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_probabilityDecimal", ElementSerializer.descriptor)
      optionalElement("probabilityRange", RangeSerializer.descriptor)
      optionalElement("qualitativeRisk", CodeableConceptSerializer.descriptor)
      optionalElement("relativeRisk", FhirDecimalSerializer.descriptor)
      optionalElement("_relativeRisk", ElementSerializer.descriptor)
      optionalElement("whenPeriod", PeriodSerializer.descriptor)
      optionalElement("whenRange", RangeSerializer.descriptor)
      optionalElement("rationale", KotlinString.serializer().descriptor)
      optionalElement("_rationale", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RiskAssessment.Prediction>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RiskAssessment.Prediction =
    decoder.decodeStructure(descriptor) {
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
            outcome =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            probabilityDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          5 ->
            _probabilityDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            probabilityRange =
              decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          7 ->
            qualitativeRisk =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            relativeRisk =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          9 ->
            _relativeRisk =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            whenPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          11 -> whenRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          12 -> rationale = decodeStringElement(descriptor, i)
          13 ->
            _rationale = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Prediction: " + i)
        }
      }
      RiskAssessment.Prediction(
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
        rationale = R4String.of(rationale, _rationale),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RiskAssessment.Prediction) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.outcome)
      when (val choice = value.probability) {
        null -> {}
        is RiskAssessment.Prediction.Probability.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 4, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is RiskAssessment.Prediction.Probability.Range -> {
          encodeSerializableElement(descriptor, 6, RangeSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.qualitativeRisk)
      encodeSerializableIfNotNull(descriptor, 8, FhirDecimalSerializer, value.relativeRisk?.value)
      encodeElementIfNotNull(descriptor, 9, value.relativeRisk)
      when (val choice = value.`when`) {
        null -> {}
        is RiskAssessment.Prediction.When.Period -> {
          encodeSerializableElement(descriptor, 10, PeriodSerializer, choice.value)
        }
        is RiskAssessment.Prediction.When.Range -> {
          encodeSerializableElement(descriptor, 11, RangeSerializer, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 12, value.rationale?.value)
      encodeElementIfNotNull(descriptor, 13, value.rationale)
    }
  }
}

internal object RiskAssessmentSerializer : FhirResourceSerializer<RiskAssessment> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("RiskAssessment")

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
    b.optionalElement("basedOn", ReferenceSerializer.descriptor)
    b.optionalElement("parent", ReferenceSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
    b.optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
    b.optionalElement("condition", ReferenceSerializer.descriptor)
    b.optionalElement("performer", ReferenceSerializer.descriptor)
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("basis", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("prediction", RiskAssessmentPredictionSerializer.listSerializer.descriptor)
    b.optionalElement("mitigation", KotlinString.serializer().descriptor)
    b.optionalElement("_mitigation", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
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
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        12 ->
          parent =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        22 ->
          condition =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        25 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        26 ->
          basis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          prediction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              RiskAssessmentPredictionSerializer.listSerializer,
              null,
            )
        28 -> mitigation = decoder.decodeStringElement(descriptor, i)
        29 ->
          _mitigation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
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
        Enumeration.of(
          if (status != null) RiskAssessment.ObservationStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on RiskAssessment"),
      method = method,
      code = code,
      subject =
        subject
          ?: throw SerializationException("Missing required property 'subject' on RiskAssessment"),
      encounter = encounter,
      occurrence =
        RiskAssessment.Occurrence.from(
          DateTime.of(
            if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
            _occurrenceDateTime,
          ),
          occurrencePeriod,
        ),
      condition = condition,
      performer = performer,
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      basis = basis ?: listOf(),
      prediction = prediction ?: listOf(),
      mitigation = R4String.of(mitigation, _mitigation),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: RiskAssessment,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      11 + descriptorOffset,
      ReferenceSerializer,
      value.basedOn,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      ReferenceSerializer,
      value.parent,
    )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    when (val choice = value.occurrence) {
      null -> {}
      is RiskAssessment.Occurrence.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is RiskAssessment.Occurrence.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.condition,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.performer,
    )
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
      )
    if (value.basis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basis,
      )
    if (value.prediction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        RiskAssessmentPredictionSerializer.listSerializer,
        value.prediction,
      )
    encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, value.mitigation?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.mitigation)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
