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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Age
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FamilyMemberHistory
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Range
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.FamilyHistoryStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object FamilyMemberHistoryConditionSerializer :
  FhirSerializer<FamilyMemberHistory.Condition> {
  override val descriptor: SerialDescriptor = buildDescriptor("Condition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<FamilyMemberHistory.Condition>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("outcome", CodeableConceptSerializer.descriptor)
    b.boolPrim("contributedToDeath")
    b.optionalElement("onsetAge", AgeSerializer.descriptor)
    b.optionalElement("onsetRange", RangeSerializer.descriptor)
    b.optionalElement("onsetPeriod", PeriodSerializer.descriptor)
    b.strPrim("onsetString")
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): FamilyMemberHistory.Condition {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> contributedToDeath = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _contributedToDeath =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          onsetAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        8 ->
          onsetRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        9 ->
          onsetPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        10 -> onsetString = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _onsetString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return FamilyMemberHistory.Condition(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "FamilyMemberHistory.Condition", "code"),
      outcome = outcome,
      contributedToDeath = R4bBoolean.of(contributedToDeath, _contributedToDeath),
      onset =
        FamilyMemberHistory.Condition.Onset.from(
          onsetAge,
          onsetRange,
          onsetPeriod,
          R4bString.of(onsetString, _onsetString),
        ),
      note = listOrEmpty(note),
    )
  }

  override fun serialize(encoder: Encoder, `value`: FamilyMemberHistory.Condition) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.outcome,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.contributedToDeath?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.contributedToDeath)
    when (val choice = value.onset) {
      null -> {}
      is FamilyMemberHistory.Condition.Onset.Age -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, AgeSerializer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.Range -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, RangeSerializer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
      is FamilyMemberHistory.Condition.Onset.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object FamilyMemberHistorySerializer : FhirResourceSerializer<FamilyMemberHistory> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("FamilyMemberHistory")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrimList("instantiatesCanonical")
    b.strPrimList("instantiatesUri")
    b.strPrim("status")
    b.optionalElement("dataAbsentReason", CodeableConceptSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.strPrim("name")
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.optionalElement("sex", CodeableConceptSerializer.descriptor)
    b.optionalElement("bornPeriod", PeriodSerializer.descriptor)
    b.strPrim("bornDate")
    b.strPrim("bornString")
    b.optionalElement("ageAge", AgeSerializer.descriptor)
    b.optionalElement("ageRange", RangeSerializer.descriptor)
    b.strPrim("ageString")
    b.boolPrim("estimatedAge")
    b.boolPrim("deceasedBoolean")
    b.optionalElement("deceasedAge", AgeSerializer.descriptor)
    b.optionalElement("deceasedRange", RangeSerializer.descriptor)
    b.strPrim("deceasedDate")
    b.strPrim("deceasedString")
    b.optionalElement("reasonCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("reasonReference", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
    b.optionalElement("condition", FamilyMemberHistoryConditionSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: FamilyHistoryStatus? = null
    var _status: Element? = null
    var dataAbsentReason: CodeableConcept? = null
    var patient: Reference? = null
    var date: FhirDateTime? = null
    var _date: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var relationship: CodeableConcept? = null
    var sex: CodeableConcept? = null
    var bornPeriod: Period? = null
    var bornDate: FhirDate? = null
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
    var deceasedDate: FhirDate? = null
    var _deceasedDate: Element? = null
    var deceasedString: KotlinString? = null
    var _deceasedString: Element? = null
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var note: List<Annotation>? = null
    var condition: List<FamilyMemberHistory.Condition>? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _instantiatesCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _instantiatesUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          status = FamilyHistoryStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          dataAbsentReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        20 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          sex =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          bornPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        26 -> bornDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        27 ->
          _bornDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 -> bornString = compositeDecoder.decodeStringElement(descriptor, i)
        29 ->
          _bornString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 ->
          ageAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        31 ->
          ageRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        32 -> ageString = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _ageString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 -> estimatedAge = compositeDecoder.decodeBooleanElement(descriptor, i)
        35 ->
          _estimatedAge =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> deceasedBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        37 ->
          _deceasedBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        38 ->
          deceasedAge =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, AgeSerializer, null)
        39 ->
          deceasedRange =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RangeSerializer, null)
        40 ->
          deceasedDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        41 ->
          _deceasedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        42 -> deceasedString = compositeDecoder.decodeStringElement(descriptor, i)
        43 ->
          _deceasedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        44 ->
          reasonCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        45 ->
          reasonReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        46 ->
          note =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        47 ->
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FamilyMemberHistoryConditionSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val instantiatesCanonical_ =
      List(maxSize(instantiatesCanonical, _instantiatesCanonical)) { index ->
        entryRequired(
          Canonical.of(at(instantiatesCanonical, index), at(_instantiatesCanonical, index)),
          "FamilyMemberHistory",
          "instantiatesCanonical",
        )
      }
    val instantiatesUri_ =
      List(maxSize(instantiatesUri, _instantiatesUri)) { index ->
        entryRequired(
          Uri.of(at(instantiatesUri, index), at(_instantiatesUri, index)),
          "FamilyMemberHistory",
          "instantiatesUri",
        )
      }
    return FamilyMemberHistory(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      instantiatesCanonical = instantiatesCanonical_,
      instantiatesUri = instantiatesUri_,
      status = required(Enumeration.of(status, _status), "FamilyMemberHistory", "status"),
      dataAbsentReason = dataAbsentReason,
      patient = required(patient, "FamilyMemberHistory", "patient"),
      date = DateTime.of(date, _date),
      name = R4bString.of(name, _name),
      relationship = required(relationship, "FamilyMemberHistory", "relationship"),
      sex = sex,
      born =
        FamilyMemberHistory.Born.from(
          bornPeriod,
          Date.of(bornDate, _bornDate),
          R4bString.of(bornString, _bornString),
        ),
      age = FamilyMemberHistory.Age.from(ageAge, ageRange, R4bString.of(ageString, _ageString)),
      estimatedAge = R4bBoolean.of(estimatedAge, _estimatedAge),
      deceased =
        FamilyMemberHistory.Deceased.from(
          R4bBoolean.of(deceasedBoolean, _deceasedBoolean),
          deceasedAge,
          deceasedRange,
          Date.of(deceasedDate, _deceasedDate),
          R4bString.of(deceasedString, _deceasedString),
        ),
      reasonCode = listOrEmpty(reasonCode),
      reasonReference = listOrEmpty(reasonReference),
      note = listOrEmpty(note),
      condition = listOrEmpty(condition),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: FamilyMemberHistory,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    if (!value.instantiatesCanonical.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesCanonical.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        12 + descriptorOffset,
        value.instantiatesCanonical,
      )
    }
    if (!value.instantiatesUri.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.instantiatesUri.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        14 + descriptorOffset,
        value.instantiatesUri,
      )
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.dataAbsentReason,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.name)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.relationship,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.sex,
    )
    when (val choice = value.born) {
      null -> {}
      is FamilyMemberHistory.Born.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          25 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Born.Date -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          26 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Born.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          28 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, choice.value)
      }
    }
    when (val choice = value.age) {
      null -> {}
      is FamilyMemberHistory.Age.Age -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          30 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.Range -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          31 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Age.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          32 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.estimatedAge?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.estimatedAge)
    when (val choice = value.deceased) {
      null -> {}
      is FamilyMemberHistory.Deceased.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(
          descriptor,
          36 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.Age -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          38 + descriptorOffset,
          AgeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Range -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          39 + descriptorOffset,
          RangeSerializer,
          choice.value,
        )
      }
      is FamilyMemberHistory.Deceased.Date -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          40 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, choice.value)
      }
      is FamilyMemberHistory.Deceased.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          42 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 43 + descriptorOffset, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      44 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.reasonCode,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      45 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.reasonReference,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      46 + descriptorOffset,
      AnnotationSerializer.listSerializer,
      value.note,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      FamilyMemberHistoryConditionSerializer.listSerializer,
      value.condition,
    )
  }
}
