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

import dev.ohs.fhir.model.r4.Age
import dev.ohs.fhir.model.r4.Annotation
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Condition
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Range
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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

internal object ConditionStageSerializer : KSerializer<Condition.Stage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("summary", CodeableConceptSerializer.descriptor)
      optionalElement("assessment", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Condition.Stage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Condition.Stage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var summary: CodeableConcept? = null
      var assessment: List<Reference>? = null
      var type: CodeableConcept? = null
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
            summary =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            assessment =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Stage: " + i)
        }
      }
      Condition.Stage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        summary = summary,
        assessment = assessment ?: listOf(),
        type = type,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Condition.Stage) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.summary)
      if (value.assessment.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ReferenceSerializer.listSerializer,
          value.assessment,
        )
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
    }
  }
}

internal object ConditionEvidenceSerializer : KSerializer<Condition.Evidence> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Evidence") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("detail", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Condition.Evidence>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Condition.Evidence =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: List<CodeableConcept>? = null
      var detail: List<Reference>? = null
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
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          4 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Evidence: " + i)
        }
      }
      Condition.Evidence(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code = code ?: listOf(),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Condition.Evidence) {
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
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      if (value.detail.isNotEmpty())
        encodeSerializableElement(descriptor, 4, ReferenceSerializer.listSerializer, value.detail)
    }
  }
}

internal object ConditionSerializer : FhirResourceSerializer<Condition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Condition")

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
    b.optionalElement("clinicalStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("verificationStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("severity", CodeableConceptSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("bodySite", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("onsetDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_onsetDateTime", ElementSerializer.descriptor)
    b.optionalElement("onsetAge", AgeSerializer.descriptor)
    b.optionalElement("onsetPeriod", PeriodSerializer.descriptor)
    b.optionalElement("onsetRange", RangeSerializer.descriptor)
    b.optionalElement("onsetString", KotlinString.serializer().descriptor)
    b.optionalElement("_onsetString", ElementSerializer.descriptor)
    b.optionalElement("abatementDateTime", KotlinString.serializer().descriptor)
    b.optionalElement("_abatementDateTime", ElementSerializer.descriptor)
    b.optionalElement("abatementAge", AgeSerializer.descriptor)
    b.optionalElement("abatementPeriod", PeriodSerializer.descriptor)
    b.optionalElement("abatementRange", RangeSerializer.descriptor)
    b.optionalElement("abatementString", KotlinString.serializer().descriptor)
    b.optionalElement("_abatementString", ElementSerializer.descriptor)
    b.optionalElement("recordedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_recordedDate", ElementSerializer.descriptor)
    b.optionalElement("recorder", ReferenceSerializer.descriptor)
    b.optionalElement("asserter", ReferenceSerializer.descriptor)
    b.optionalElement("stage", ConditionStageSerializer.listSerializer.descriptor)
    b.optionalElement("evidence", ConditionEvidenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Condition {
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
    var clinicalStatus: CodeableConcept? = null
    var verificationStatus: CodeableConcept? = null
    var category: List<CodeableConcept>? = null
    var severity: CodeableConcept? = null
    var code: CodeableConcept? = null
    var bodySite: List<CodeableConcept>? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var onsetDateTime: KotlinString? = null
    var _onsetDateTime: Element? = null
    var onsetAge: Age? = null
    var onsetPeriod: Period? = null
    var onsetRange: Range? = null
    var onsetString: KotlinString? = null
    var _onsetString: Element? = null
    var abatementDateTime: KotlinString? = null
    var _abatementDateTime: Element? = null
    var abatementAge: Age? = null
    var abatementPeriod: Period? = null
    var abatementRange: Range? = null
    var abatementString: KotlinString? = null
    var _abatementString: Element? = null
    var recordedDate: KotlinString? = null
    var _recordedDate: Element? = null
    var recorder: Reference? = null
    var asserter: Reference? = null
    var stage: List<Condition.Stage>? = null
    var evidence: List<Condition.Evidence>? = null
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
          clinicalStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          verificationStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 ->
          severity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> onsetDateTime = decoder.decodeStringElement(descriptor, i)
        20 ->
          _onsetDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          onsetAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        22 ->
          onsetPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        23 ->
          onsetRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        24 -> onsetString = decoder.decodeStringElement(descriptor, i)
        25 ->
          _onsetString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> abatementDateTime = decoder.decodeStringElement(descriptor, i)
        27 ->
          _abatementDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          abatementAge =
            decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        29 ->
          abatementPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        30 ->
          abatementRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        31 -> abatementString = decoder.decodeStringElement(descriptor, i)
        32 ->
          _abatementString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> recordedDate = decoder.decodeStringElement(descriptor, i)
        34 ->
          _recordedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 ->
          recorder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        36 ->
          asserter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        37 ->
          stage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionStageSerializer.listSerializer,
              null,
            )
        38 ->
          evidence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionEvidenceSerializer.listSerializer,
              null,
            )
        39 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Condition: " + i)
      }
    }
    return Condition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      clinicalStatus = clinicalStatus,
      verificationStatus = verificationStatus,
      category = category ?: listOf(),
      severity = severity,
      code = code,
      bodySite = bodySite ?: listOf(),
      subject =
        subject ?: throw SerializationException("Missing required property 'subject' on Condition"),
      encounter = encounter,
      onset =
        Condition.Onset.from(
          DateTime.of(
            if (onsetDateTime != null) FhirDateTime.fromString(onsetDateTime) else null,
            _onsetDateTime,
          ),
          onsetAge,
          onsetPeriod,
          onsetRange,
          R4String.of(onsetString, _onsetString),
        ),
      abatement =
        Condition.Abatement.from(
          DateTime.of(
            if (abatementDateTime != null) FhirDateTime.fromString(abatementDateTime) else null,
            _abatementDateTime,
          ),
          abatementAge,
          abatementPeriod,
          abatementRange,
          R4String.of(abatementString, _abatementString),
        ),
      recordedDate =
        DateTime.of(
          if (recordedDate != null) FhirDateTime.fromString(recordedDate) else null,
          _recordedDate,
        ),
      recorder = recorder,
      asserter = asserter,
      stage = stage ?: listOf(),
      evidence = evidence ?: listOf(),
      note = note ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Condition,
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
      CodeableConceptSerializer,
      value.clinicalStatus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.verificationStatus,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.severity,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.bodySite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.bodySite,
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
    when (val choice = value.onset) {
      null -> {}
      is Condition.Onset.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          19 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, choice.value)
      }
      is Condition.Onset.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          21 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is Condition.Onset.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          22 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Condition.Onset.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          23 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is Condition.Onset.String -> {
        encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.abatement) {
      null -> {}
      is Condition.Abatement.DateTime -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          26 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, choice.value)
      }
      is Condition.Abatement.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          28 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is Condition.Abatement.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          29 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is Condition.Abatement.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is Condition.Abatement.String -> {
        encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.recordedDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.recordedDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      ReferenceSerializer,
      value.recorder,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer,
      value.asserter,
    )
    if (value.stage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ConditionStageSerializer.listSerializer,
        value.stage,
      )
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ConditionEvidenceSerializer.listSerializer,
        value.evidence,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
