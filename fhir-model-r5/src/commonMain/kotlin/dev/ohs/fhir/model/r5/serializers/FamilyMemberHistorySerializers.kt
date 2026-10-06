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
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FamilyMemberHistory
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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

internal object FamilyMemberHistoryParticipantSerializer :
  KSerializer<FamilyMemberHistory.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("function", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<FamilyMemberHistory.Participant>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var function: CodeableConcept? = null
      var actor: Reference? = null
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
            function =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      FamilyMemberHistory.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        function = function,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on FamilyMemberHistory.Participant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.function)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object FamilyMemberHistoryConditionSerializer :
  KSerializer<FamilyMemberHistory.Condition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Condition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("outcome", CodeableConceptSerializer.descriptor)
      optionalElement("contributedToDeath", KotlinBoolean.serializer().descriptor)
      optionalElement("_contributedToDeath", ElementSerializer.descriptor)
      optionalElement("onsetAge", AgeSerializer.descriptor)
      optionalElement("onsetRange", RangeSerializer.descriptor)
      optionalElement("onsetPeriod", PeriodSerializer.descriptor)
      optionalElement("onsetString", KotlinString.serializer().descriptor)
      optionalElement("_onsetString", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<FamilyMemberHistory.Condition>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Condition =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var outcome: CodeableConcept? = null
      var contributedToDeath: KotlinBoolean? = null
      var _contributedToDeath: Element? = null
      var onsetAge: Age? = null
      var onsetRange: Range? = null
      var onsetPeriod: Period? = null
      var onsetString: KotlinString? = null
      var _onsetString: Element? = null
      var note: List<Annotation>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            outcome =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> contributedToDeath = decodeBooleanElement(descriptor, i)
          6 ->
            _contributedToDeath =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> onsetAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          8 -> onsetRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          9 ->
            onsetPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          10 -> onsetString = decodeStringElement(descriptor, i)
          11 ->
            _onsetString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Condition: " + i)
        }
      }
      FamilyMemberHistory.Condition(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on FamilyMemberHistory.Condition"
            ),
        outcome = outcome,
        contributedToDeath = R5Boolean.of(contributedToDeath, _contributedToDeath),
        onset =
          FamilyMemberHistory.Condition.Onset.from(
            onsetAge,
            onsetRange,
            onsetPeriod,
            R5String.of(onsetString, _onsetString),
          ),
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Condition) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.outcome)
      encodeBooleanIfNotNull(descriptor, 5, value.contributedToDeath?.value)
      encodeElementIfNotNull(descriptor, 6, value.contributedToDeath)
      when (val choice = value.onset) {
        null -> {}
        is FamilyMemberHistory.Condition.Onset.Age -> {
          encodeSerializableElement(descriptor, 7, AgeSerializer, choice.value)
        }
        is FamilyMemberHistory.Condition.Onset.Range -> {
          encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
        }
        is FamilyMemberHistory.Condition.Onset.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
        is FamilyMemberHistory.Condition.Onset.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
      }
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 12, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object FamilyMemberHistoryProcedureSerializer :
  KSerializer<FamilyMemberHistory.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("outcome", CodeableConceptSerializer.descriptor)
      optionalElement("contributedToDeath", KotlinBoolean.serializer().descriptor)
      optionalElement("_contributedToDeath", ElementSerializer.descriptor)
      optionalElement("performedAge", AgeSerializer.descriptor)
      optionalElement("performedRange", RangeSerializer.descriptor)
      optionalElement("performedPeriod", PeriodSerializer.descriptor)
      optionalElement("performedString", KotlinString.serializer().descriptor)
      optionalElement("_performedString", ElementSerializer.descriptor)
      optionalElement("performedDateTime", KotlinString.serializer().descriptor)
      optionalElement("_performedDateTime", ElementSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<FamilyMemberHistory.Procedure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Procedure =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var outcome: CodeableConcept? = null
      var contributedToDeath: KotlinBoolean? = null
      var _contributedToDeath: Element? = null
      var performedAge: Age? = null
      var performedRange: Range? = null
      var performedPeriod: Period? = null
      var performedString: KotlinString? = null
      var _performedString: Element? = null
      var performedDateTime: KotlinString? = null
      var _performedDateTime: Element? = null
      var note: List<Annotation>? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            outcome =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> contributedToDeath = decodeBooleanElement(descriptor, i)
          6 ->
            _contributedToDeath =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> performedAge = decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
          8 ->
            performedRange = decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
          9 ->
            performedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          10 -> performedString = decodeStringElement(descriptor, i)
          11 ->
            _performedString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> performedDateTime = decodeStringElement(descriptor, i)
          13 ->
            _performedDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
        }
      }
      FamilyMemberHistory.Procedure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on FamilyMemberHistory.Procedure"
            ),
        outcome = outcome,
        contributedToDeath = R5Boolean.of(contributedToDeath, _contributedToDeath),
        performed =
          FamilyMemberHistory.Procedure.Performed.from(
            performedAge,
            performedRange,
            performedPeriod,
            R5String.of(performedString, _performedString),
            DateTime.of(
              if (performedDateTime != null) FhirDateTime.fromString(performedDateTime) else null,
              _performedDateTime,
            ),
          ),
        note = note ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Procedure) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.outcome)
      encodeBooleanIfNotNull(descriptor, 5, value.contributedToDeath?.value)
      encodeElementIfNotNull(descriptor, 6, value.contributedToDeath)
      when (val choice = value.performed) {
        null -> {}
        is FamilyMemberHistory.Procedure.Performed.Age -> {
          encodeSerializableElement(descriptor, 7, AgeSerializer, choice.value)
        }
        is FamilyMemberHistory.Procedure.Performed.Range -> {
          encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
        }
        is FamilyMemberHistory.Procedure.Performed.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
        is FamilyMemberHistory.Procedure.Performed.String -> {
          encodeStringIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is FamilyMemberHistory.Procedure.Performed.DateTime -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
      }
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 14, AnnotationSerializer.listSerializer, value.note)
    }
  }
}

internal object FamilyMemberHistorySerializer : FhirResourceSerializer<FamilyMemberHistory> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("FamilyMemberHistory")

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
    b.optionalElement("instantiatesCanonical", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesCanonical", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("instantiatesUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement(
      "participant",
      FamilyMemberHistoryParticipantSerializer.listSerializer.descriptor,
    )
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.optionalElement("sex", CodeableConceptSerializer.descriptor)
    b.optionalElement("bornPeriod", PeriodSerializer.descriptor)
    b.optionalElement("bornDate", KotlinString.serializer().descriptor)
    b.optionalElement("_bornDate", ElementSerializer.descriptor)
    b.optionalElement("bornString", KotlinString.serializer().descriptor)
    b.optionalElement("_bornString", ElementSerializer.descriptor)
    b.optionalElement("ageAge", AgeSerializer.descriptor)
    b.optionalElement("ageRange", RangeSerializer.descriptor)
    b.optionalElement("ageString", KotlinString.serializer().descriptor)
    b.optionalElement("_ageString", ElementSerializer.descriptor)
    b.optionalElement("estimatedAge", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_estimatedAge", ElementSerializer.descriptor)
    b.optionalElement("deceasedBoolean", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_deceasedBoolean", ElementSerializer.descriptor)
    b.optionalElement("deceasedAge", AgeSerializer.descriptor)
    b.optionalElement("deceasedRange", RangeSerializer.descriptor)
    b.optionalElement("deceasedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_deceasedDate", ElementSerializer.descriptor)
    b.optionalElement("deceasedString", KotlinString.serializer().descriptor)
    b.optionalElement("_deceasedString", ElementSerializer.descriptor)
    b.optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("condition", FamilyMemberHistoryConditionSerializer.listSerializer.descriptor)
    b.optionalElement("procedure", FamilyMemberHistoryProcedureSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): FamilyMemberHistory {
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
    var instantiatesCanonical: List<KotlinString?>? = null
    var _instantiatesCanonical: List<Element?>? = null
    var instantiatesUri: List<KotlinString?>? = null
    var _instantiatesUri: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var dataAbsentReason: CodeableConcept? = null
    var patient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var participant: List<FamilyMemberHistory.Participant>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var relationship: CodeableConcept? = null
    var sex: CodeableConcept? = null
    var bornPeriod: Period? = null
    var bornDate: KotlinString? = null
    var _bornDate: Element? = null
    var bornString: KotlinString? = null
    var _bornString: Element? = null
    var ageAge: Age? = null
    var ageRange: Range? = null
    var ageString: KotlinString? = null
    var _ageString: Element? = null
    var estimatedAge: KotlinBoolean? = null
    var _estimatedAge: Element? = null
    var deceasedBoolean: KotlinBoolean? = null
    var _deceasedBoolean: Element? = null
    var deceasedAge: Age? = null
    var deceasedRange: Range? = null
    var deceasedDate: KotlinString? = null
    var _deceasedDate: Element? = null
    var deceasedString: KotlinString? = null
    var _deceasedString: Element? = null
    var reason: List<CodeableReference>? = null
    var note: List<Annotation>? = null
    var condition: List<FamilyMemberHistory.Condition>? = null
    var procedure: List<FamilyMemberHistory.Procedure>? = null
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
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          dataAbsentReason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> date = decoder.decodeStringElement(descriptor, i)
        20 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FamilyMemberHistoryParticipantSerializer.listSerializer,
              null,
            )
        22 -> name = decoder.decodeStringElement(descriptor, i)
        23 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          sex =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          bornPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        27 -> bornDate = decoder.decodeStringElement(descriptor, i)
        28 ->
          _bornDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> bornString = decoder.decodeStringElement(descriptor, i)
        30 ->
          _bornString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 -> ageAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        32 ->
          ageRange = decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        33 -> ageString = decoder.decodeStringElement(descriptor, i)
        34 ->
          _ageString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> estimatedAge = decoder.decodeBooleanElement(descriptor, i)
        36 ->
          _estimatedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> deceasedBoolean = decoder.decodeBooleanElement(descriptor, i)
        38 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 ->
          deceasedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        40 ->
          deceasedRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        41 -> deceasedDate = decoder.decodeStringElement(descriptor, i)
        42 ->
          _deceasedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> deceasedString = decoder.decodeStringElement(descriptor, i)
        44 ->
          _deceasedString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        46 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        47 ->
          condition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FamilyMemberHistoryConditionSerializer.listSerializer,
              null,
            )
        48 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FamilyMemberHistoryProcedureSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding FamilyMemberHistory: " + i)
      }
    }
    return FamilyMemberHistory(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      instantiatesCanonical =
        (kotlin.collections.List(
          maxOf(instantiatesCanonical?.size ?: 0, _instantiatesCanonical?.size ?: 0)
        ) { index ->
          Canonical.of(
            instantiatesCanonical?.getOrNull(index),
            _instantiatesCanonical?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'instantiatesCanonical' on FamilyMemberHistory has neither a value nor an id/extension"
            )
        }),
      instantiatesUri =
        (kotlin.collections.List(maxOf(instantiatesUri?.size ?: 0, _instantiatesUri?.size ?: 0)) {
          index ->
          Uri.of(instantiatesUri?.getOrNull(index), _instantiatesUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'instantiatesUri' on FamilyMemberHistory has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(
          if (status != null) FamilyMemberHistory.FamilyHistoryStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on FamilyMemberHistory"
          ),
      dataAbsentReason = dataAbsentReason,
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on FamilyMemberHistory"
          ),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      participant = participant ?: listOf(),
      name = R5String.of(name, _name),
      relationship =
        relationship
          ?: throw SerializationException(
            "Missing required property 'relationship' on FamilyMemberHistory"
          ),
      sex = sex,
      born =
        FamilyMemberHistory.Born.from(
          bornPeriod,
          Date.of(if (bornDate != null) FhirDate.fromString(bornDate) else null, _bornDate),
          R5String.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R5String.of(ageString, _ageString)),
      estimatedAge = R5Boolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R5Boolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(
            if (deceasedDate != null) FhirDate.fromString(deceasedDate) else null,
            _deceasedDate,
          ),
          R5String.of(deceasedString, _deceasedString),
        ),
      reason = reason ?: listOf(),
      note = note ?: listOf(),
      condition = condition ?: listOf(),
      procedure = procedure ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: FamilyMemberHistory,
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
    if (value.instantiatesCanonical.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      encoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (value.instantiatesUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.instantiatesUri)
    }
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.date)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        FamilyMemberHistoryParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeStringIfNotNull(descriptor, 22 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.name)
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.relationship,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.sex,
    )
    when (val choice = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          26 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Born.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          27 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Born.String -> {
        encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          32 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.String -> {
        encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeBooleanIfNotNull(descriptor, 35 + descriptorOffset, value.estimatedAge?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.estimatedAge)
    when (val choice = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 37 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          39 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          40 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          41 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.String -> {
        encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, choice.value)
      }
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    if (value.condition.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        FamilyMemberHistoryConditionSerializer.listSerializer,
        value.condition,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        FamilyMemberHistoryProcedureSerializer.listSerializer,
        value.procedure,
      )
  }
}
