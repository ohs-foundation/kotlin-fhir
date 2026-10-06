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
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FamilyMemberHistory
import dev.ohs.fhir.model.r4.FhirDate
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
        contributedToDeath = R4Boolean.of(contributedToDeath, _contributedToDeath),
        onset =
          FamilyMemberHistory.Condition.Onset.from(
            onsetAge,
            onsetRange,
            onsetPeriod,
            R4String.of(onsetString, _onsetString),
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
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("condition", FamilyMemberHistoryConditionSerializer.listSerializer.descriptor)
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
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var condition: List<FamilyMemberHistory.Condition>? = null
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
        21 -> name = decoder.decodeStringElement(descriptor, i)
        22 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          sex =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          bornPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        26 -> bornDate = decoder.decodeStringElement(descriptor, i)
        27 ->
          _bornDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> bornString = decoder.decodeStringElement(descriptor, i)
        29 ->
          _bornString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> ageAge = decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        31 ->
          ageRange = decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        32 -> ageString = decoder.decodeStringElement(descriptor, i)
        33 ->
          _ageString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> estimatedAge = decoder.decodeBooleanElement(descriptor, i)
        35 ->
          _estimatedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> deceasedBoolean = decoder.decodeBooleanElement(descriptor, i)
        37 ->
          _deceasedBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 ->
          deceasedAge =
            decoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        39 ->
          deceasedRange =
            decoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        40 -> deceasedDate = decoder.decodeStringElement(descriptor, i)
        41 ->
          _deceasedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 -> deceasedString = decoder.decodeStringElement(descriptor, i)
        43 ->
          _deceasedString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        44 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        45 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
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
      name = R4String.of(name, _name),
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
          R4String.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R4String.of(ageString, _ageString)),
      estimatedAge = R4Boolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R4Boolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(
            if (deceasedDate != null) FhirDate.fromString(deceasedDate) else null,
            _deceasedDate,
          ),
          R4String.of(deceasedString, _deceasedString),
        ),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      note = note ?: listOf(),
      condition = condition ?: listOf(),
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
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.name)
    encoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.relationship,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.sex,
    )
    when (val choice = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Born.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          26 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Born.String -> {
        encoder.encodeStringIfNotNull(descriptor, 28 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.String -> {
        encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, choice.value)
      }
    }
    encoder.encodeBooleanIfNotNull(descriptor, 34 + descriptorOffset, value.estimatedAge?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.estimatedAge)
    when (val choice = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        encoder.encodeBooleanIfNotNull(descriptor, 36 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.Age -> {
        encoder.encodeSerializableElement(
          descriptor,
          38 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Range -> {
        encoder.encodeSerializableElement(
          descriptor,
          39 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          40 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.String -> {
        encoder.encodeStringIfNotNull(descriptor, 42 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, choice.value)
      }
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.reasonCode,
      )
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.reasonReference,
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
  }
}
