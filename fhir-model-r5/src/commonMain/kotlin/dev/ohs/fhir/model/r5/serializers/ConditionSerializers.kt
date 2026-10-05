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

import dev.ohs.fhir.model.r5.Age
import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Condition
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Range
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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

internal object ConditionParticipantSerializer : KSerializer<Condition.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element("function", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Condition.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Condition.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Condition.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Condition.Participant {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var function: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          function =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          actor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return Condition.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      function = function,
      actor =
        actor
          ?: throw SerializationException(
            "Missing required property 'actor' on Condition.Participant"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Condition.Participant) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.function)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
  }
}

internal object ConditionStageSerializer : KSerializer<Condition.Stage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Stage") {
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
      element("summary", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "assessment",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Condition.Stage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Condition.Stage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Condition.Stage) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Condition.Stage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var summary: CodeableConcept? = null
    var assessment: List<Reference>? = null
    var type: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          summary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          assessment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Stage: " + i)
      }
    }
    return Condition.Stage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      summary = summary,
      assessment = assessment ?: listOf(),
      type = type,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Condition.Stage) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    (value.summary)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    if (value.assessment.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        ReferenceSerializer.listSerializer,
        value.assessment,
      )
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
  }
}

internal object ConditionSerializer : KSerializer<Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
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
    b.element("clinicalStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("verificationStatus", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "category",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("severity", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "bodySite",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("onsetDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_onsetDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("onsetAge", Age.serializer().descriptor, isOptional = true)
    b.element("onsetPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("onsetRange", Range.serializer().descriptor, isOptional = true)
    b.element("onsetString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_onsetString", Element.serializer().descriptor, isOptional = true)
    b.element("abatementDateTime", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_abatementDateTime", Element.serializer().descriptor, isOptional = true)
    b.element("abatementAge", Age.serializer().descriptor, isOptional = true)
    b.element("abatementPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("abatementRange", Range.serializer().descriptor, isOptional = true)
    b.element("abatementString", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_abatementString", Element.serializer().descriptor, isOptional = true)
    b.element("recordedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_recordedDate", Element.serializer().descriptor, isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { Condition.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "stage",
      listSerialDescriptor(lazyDescriptor { Condition.Stage.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "evidence",
      listSerialDescriptor(CodeableReference.serializer().descriptor),
      isOptional = true,
    )
    b.element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Condition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Condition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Condition")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
    var participant: List<Condition.Participant>? = null
    var stage: List<Condition.Stage>? = null
    var evidence: List<CodeableReference>? = null
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
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionParticipantSerializer.listSerializer,
              null,
            )
        36 ->
          stage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ConditionStageSerializer.listSerializer,
              null,
            )
        37 ->
          evidence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        38 ->
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
      clinicalStatus =
        clinicalStatus
          ?: throw SerializationException(
            "Missing required property 'clinicalStatus' on Condition"
          ),
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
          DateTime.of(onsetDateTime?.let { FhirDateTime.fromString(it) }, _onsetDateTime),
          onsetAge,
          onsetPeriod,
          onsetRange,
          R5String.of(onsetString, _onsetString),
        ),
      abatement =
        Condition.Abatement.from(
          DateTime.of(abatementDateTime?.let { FhirDateTime.fromString(it) }, _abatementDateTime),
          abatementAge,
          abatementPeriod,
          abatementRange,
          R5String.of(abatementString, _abatementString),
        ),
      recordedDate = DateTime.of(recordedDate?.let { FhirDateTime.fromString(it) }, _recordedDate),
      participant = participant ?: listOf(),
      stage = stage ?: listOf(),
      evidence = evidence ?: listOf(),
      note = note ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Condition,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.clinicalStatus,
    )
    (value.verificationStatus)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.category,
      )
    (value.severity)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
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
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ReferenceSerializer, it)
    }
    when (val choice = value.onset) {
      null -> {}
      is Condition.Onset.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            20 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
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
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 24 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            25 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    when (val choice = value.abatement) {
      null -> {}
      is Condition.Abatement.DateTime -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 26 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            27 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
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
        ((choice.value.value))?.let {
          encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            32 + descriptorOffset,
            ElementSerializer,
            it,
          )
        }
      }
    }
    ((value.recordedDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.recordedDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 34 + descriptorOffset, ElementSerializer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ConditionParticipantSerializer.listSerializer,
        value.participant,
      )
    if (value.stage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ConditionStageSerializer.listSerializer,
        value.stage,
      )
    if (value.evidence.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.evidence,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}

internal object ConditionPolymorphicSerializer : KSerializer<Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") { ConditionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Condition) {
    encoder.encodeStructure(descriptor) {
      ConditionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Condition =
    decoder.decodeStructure(descriptor) {
      ConditionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
