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

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.ExplanationOfBenefit
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ClaimProcessingCodes
import dev.ohs.fhir.model.r4.terminologies.ExplanationOfBenefitStatus
import dev.ohs.fhir.model.r4.terminologies.NoteType
import dev.ohs.fhir.model.r4.terminologies.Use
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

internal object ExplanationOfBenefitRelatedSerializer : KSerializer<ExplanationOfBenefit.Related> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Related") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("claim", ReferenceSerializer.descriptor)
      optionalElement("relationship", CodeableConceptSerializer.descriptor)
      optionalElement("reference", IdentifierSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Related>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Related {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var claim: Reference? = null
    var relationship: CodeableConcept? = null
    var reference: Identifier? = null
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
          claim =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Related: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Related(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      claim = claim,
      relationship = relationship,
      reference = reference,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Related) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.claim)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.relationship,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      IdentifierSerializer,
      value.reference,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitPayeeSerializer : KSerializer<ExplanationOfBenefit.Payee> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payee") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Payee>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payee {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var party: Reference? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          party =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payee: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Payee(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      party = party,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payee) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.party)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitCareTeamSerializer :
  KSerializer<ExplanationOfBenefit.CareTeam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CareTeam") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("provider", ReferenceSerializer.descriptor)
      optionalElement("responsible", KotlinBoolean.serializer().descriptor)
      optionalElement("_responsible", ElementSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("qualification", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.CareTeam>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.CareTeam {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var provider: Reference? = null
    var responsible: KotlinBoolean? = null
    var _responsible: Element? = null
    var role: CodeableConcept? = null
    var qualification: CodeableConcept? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> responsible = compositeDecoder.decodeBooleanElement(descriptor, i)
        7 ->
          _responsible =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          role =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          qualification =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CareTeam: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.CareTeam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.CareTeam"
          ),
      provider =
        provider
          ?: throw SerializationException(
            "Missing required property 'provider' on ExplanationOfBenefit.CareTeam"
          ),
      responsible = R4Boolean.of(responsible, _responsible),
      role = role,
      qualification = qualification,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.CareTeam) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.provider)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 6, value.responsible?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.responsible)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.role,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.qualification,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitSupportingInfoSerializer :
  KSerializer<ExplanationOfBenefit.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("timingDate", KotlinString.serializer().descriptor)
      optionalElement("_timingDate", ElementSerializer.descriptor)
      optionalElement("timingPeriod", PeriodSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("reason", CodingSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.SupportingInfo>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var category: CodeableConcept? = null
    var code: CodeableConcept? = null
    var timingDate: KotlinString? = null
    var _timingDate: Element? = null
    var timingPeriod: Period? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueQuantity: Quantity? = null
    var valueAttachment: Attachment? = null
    var valueReference: Reference? = null
    var reason: Coding? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> timingDate = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _timingDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          timingPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        10 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        15 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        16 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        17 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.SupportingInfo"
          ),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.SupportingInfo"
          ),
      code = code,
      timing =
        ExplanationOfBenefit.SupportingInfo.Timing.from(
          Date.of(if (timingDate != null) FhirDate.fromString(timingDate) else null, _timingDate),
          timingPeriod,
        ),
      `value` =
        ExplanationOfBenefit.SupportingInfo.Value.from(
          R4Boolean.of(valueBoolean, _valueBoolean),
          R4String.of(valueString, _valueString),
          valueQuantity,
          valueAttachment,
          valueReference,
        ),
      reason = reason,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.code,
    )
    when (val choice = value.timing) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Timing.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is ExplanationOfBenefit.SupportingInfo.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          15,
          AttachmentSerializer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.SupportingInfo.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          16,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 17, CodingSerializer, value.reason)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitDiagnosisSerializer :
  KSerializer<ExplanationOfBenefit.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("diagnosisCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("diagnosisReference", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("onAdmission", CodeableConceptSerializer.descriptor)
      optionalElement("packageCode", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Diagnosis>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Diagnosis {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var diagnosisCodeableConcept: CodeableConcept? = null
    var diagnosisReference: Reference? = null
    var type: List<CodeableConcept>? = null
    var onAdmission: CodeableConcept? = null
    var packageCode: CodeableConcept? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          diagnosisCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          diagnosisReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          onAdmission =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          packageCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Diagnosis"
          ),
      diagnosis =
        ExplanationOfBenefit.Diagnosis.Diagnosis.from(diagnosisCodeableConcept, diagnosisReference)
          ?: throw SerializationException(
            "Missing required property 'diagnosis' on ExplanationOfBenefit.Diagnosis"
          ),
      type = type ?: listOf(),
      onAdmission = onAdmission,
      packageCode = packageCode,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    when (val choice = value.diagnosis) {
      is ExplanationOfBenefit.Diagnosis.Diagnosis.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.Diagnosis.Diagnosis.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.onAdmission,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.packageCode,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitProcedureSerializer :
  KSerializer<ExplanationOfBenefit.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("procedureCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("procedureReference", ReferenceSerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Procedure>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Procedure {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var type: List<CodeableConcept>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var procedureCodeableConcept: CodeableConcept? = null
    var procedureReference: Reference? = null
    var udi: List<Reference>? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          procedureCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          procedureReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        10 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Procedure"
          ),
      type = type ?: listOf(),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      procedure =
        ExplanationOfBenefit.Procedure.Procedure.from(procedureCodeableConcept, procedureReference)
          ?: throw SerializationException(
            "Missing required property 'procedure' on ExplanationOfBenefit.Procedure"
          ),
      udi = udi ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.date)
    when (val choice = value.procedure) {
      is ExplanationOfBenefit.Procedure.Procedure.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.Procedure.Procedure.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
      }
    }
    if (value.udi.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitInsuranceSerializer :
  KSerializer<ExplanationOfBenefit.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("focal", KotlinBoolean.serializer().descriptor)
      optionalElement("_focal", ElementSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("preAuthRef", stringNullableListSerializer.descriptor)
      optionalElement("_preAuthRef", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Insurance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Insurance {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
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
        3 -> focal = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _focal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 ->
          preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        7 ->
          _preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      focal =
        R4Boolean.of(focal, _focal)
          ?: throw SerializationException(
            "Missing required property 'focal' on ExplanationOfBenefit.Insurance"
          ),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on ExplanationOfBenefit.Insurance"
          ),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R4String.of(preAuthRef?.getOrNull(index), _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on ExplanationOfBenefit.Insurance has neither a value nor an id/extension"
            )
        }),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Insurance) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, value.focal.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.focal)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.coverage)
    if (value.preAuthRef.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        6,
        stringNullableListSerializer,
        value.preAuthRef.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 7, value.preAuthRef)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitAccidentSerializer :
  KSerializer<ExplanationOfBenefit.Accident> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Accident") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("locationAddress", AddressSerializer.descriptor)
      optionalElement("locationReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Accident>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Accident {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var type: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
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
        3 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          locationAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        7 ->
          locationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Accident: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Accident(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
      type = type,
      location = ExplanationOfBenefit.Accident.Location.from(locationAddress, locationReference),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.type,
    )
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Accident.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.Accident.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitItemSerializer : KSerializer<ExplanationOfBenefit.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("careTeamSequence", intNullableListSerializer.descriptor)
      optionalElement("_careTeamSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("diagnosisSequence", intNullableListSerializer.descriptor)
      optionalElement("_diagnosisSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("procedureSequence", intNullableListSerializer.descriptor)
      optionalElement("_procedureSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("informationSequence", intNullableListSerializer.descriptor)
      optionalElement("_informationSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("servicedDate", KotlinString.serializer().descriptor)
      optionalElement("_servicedDate", ElementSerializer.descriptor)
      optionalElement("servicedPeriod", PeriodSerializer.descriptor)
      optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("locationAddress", AddressSerializer.descriptor)
      optionalElement("locationReference", ReferenceSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("bodySite", CodeableConceptSerializer.descriptor)
      optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer.descriptor,
      )
      optionalElement("detail", ExplanationOfBenefitItemDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var careTeamSequence: List<Int?>? = null
    var _careTeamSequence: List<Element?>? = null
    var diagnosisSequence: List<Int?>? = null
    var _diagnosisSequence: List<Element?>? = null
    var procedureSequence: List<Int?>? = null
    var _procedureSequence: List<Element?>? = null
    var informationSequence: List<Int?>? = null
    var _informationSequence: List<Element?>? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var bodySite: CodeableConcept? = null
    var subSite: List<CodeableConcept>? = null
    var encounter: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var detail: List<ExplanationOfBenefit.Item.Detail>? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          careTeamSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _careTeamSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          diagnosisSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _diagnosisSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          procedureSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        10 ->
          _procedureSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          informationSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        12 ->
          _informationSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 -> servicedDate = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _servicedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          servicedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        21 ->
          locationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 ->
          locationAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        23 ->
          locationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        25 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        26 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        27 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        29 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 ->
          subSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        34 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        35 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        36 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item"
          ),
      careTeamSequence =
        (kotlin.collections.List(
          maxOf(careTeamSequence?.size ?: 0, _careTeamSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(careTeamSequence?.getOrNull(index), _careTeamSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'careTeamSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      diagnosisSequence =
        (kotlin.collections.List(
          maxOf(diagnosisSequence?.size ?: 0, _diagnosisSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(diagnosisSequence?.getOrNull(index), _diagnosisSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'diagnosisSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      procedureSequence =
        (kotlin.collections.List(
          maxOf(procedureSequence?.size ?: 0, _procedureSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(procedureSequence?.getOrNull(index), _procedureSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'procedureSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      informationSequence =
        (kotlin.collections.List(
          maxOf(informationSequence?.size ?: 0, _informationSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            informationSequence?.getOrNull(index),
            _informationSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'informationSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.Item"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ExplanationOfBenefit.Item.Serviced.from(
          Date.of(
            if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
            _servicedDate,
          ),
          servicedPeriod,
        ),
      location =
        ExplanationOfBenefit.Item.Location.from(
          locationCodeableConcept,
          locationAddress,
          locationReference,
        ),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      bodySite = bodySite,
      subSite = subSite ?: listOf(),
      encounter = encounter ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    if (value.careTeamSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.careTeamSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.careTeamSequence)
    }
    if (value.diagnosisSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        intNullableListSerializer,
        value.diagnosisSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.diagnosisSequence)
    }
    if (value.procedureSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        intNullableListSerializer,
        value.procedureSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.procedureSequence)
    }
    if (value.informationSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        intNullableListSerializer,
        value.informationSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.informationSequence)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      15,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.Item.Serviced.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 18, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 19, choice.value)
      }
      is ExplanationOfBenefit.Item.Serviced.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          21,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.Item.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 22, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.Item.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          23,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 24, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 25, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 28, MoneySerializer, value.net)
    if (value.udi.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30,
      CodeableConceptSerializer,
      value.bodySite,
    )
    if (value.subSite.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        31,
        CodeableConceptSerializer.listSerializer,
        value.subSite,
      )
    if (value.encounter.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        33,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 34, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        35,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.detail.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        36,
        ExplanationOfBenefitItemDetailSerializer.listSerializer,
        value.detail,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitItemAdjudicationSerializer :
  KSerializer<ExplanationOfBenefit.Item.Adjudication> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Adjudication") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
      optionalElement("value", FhirDecimalSerializer.descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Adjudication {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var reason: CodeableConcept? = null
    var amount: Money? = null
    var `value`: FhirDecimal? = null
    var _value: Element? = null
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        6 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        7 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Adjudication: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Item.Adjudication(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.Item.Adjudication"
          ),
      reason = reason,
      amount = amount,
      `value` = Decimal.of(`value`, _value),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Adjudication) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.reason,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, MoneySerializer, value.amount)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      FhirDecimalSerializer,
      value.`value`?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
      optionalElement(
        "subDetail",
        ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Detail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var subDetail: List<ExplanationOfBenefit.Item.Detail.SubDetail>? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        11 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        12 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        13 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        17 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        19 ->
          subDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail"
          ),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.Item.Detail"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 11, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.net)
    if (value.udi.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.subDetail.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19,
        ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
        value.subDetail,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Detail.SubDetail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail.SubDetail {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var revenue: CodeableConcept? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var udi: List<Reference>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
        3 -> sequence = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        11 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        12 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        13 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        17 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail.SubDetail"
          ),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.Item.Detail.SubDetail"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail.SubDetail has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail.SubDetail) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 10, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 11, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.net)
    if (value.udi.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        15,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        16,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 17, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        18,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitAddItemSerializer : KSerializer<ExplanationOfBenefit.AddItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AddItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("itemSequence", intNullableListSerializer.descriptor)
      optionalElement("_itemSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("detailSequence", intNullableListSerializer.descriptor)
      optionalElement("_detailSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("subDetailSequence", intNullableListSerializer.descriptor)
      optionalElement("_subDetailSequence", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("provider", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("servicedDate", KotlinString.serializer().descriptor)
      optionalElement("_servicedDate", ElementSerializer.descriptor)
      optionalElement("servicedPeriod", PeriodSerializer.descriptor)
      optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("locationAddress", AddressSerializer.descriptor)
      optionalElement("locationReference", ReferenceSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("bodySite", CodeableConceptSerializer.descriptor)
      optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "detail",
        ExplanationOfBenefitAddItemDetailSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var itemSequence: List<Int?>? = null
    var _itemSequence: List<Element?>? = null
    var detailSequence: List<Int?>? = null
    var _detailSequence: List<Element?>? = null
    var subDetailSequence: List<Int?>? = null
    var _subDetailSequence: List<Element?>? = null
    var provider: List<Reference>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var programCode: List<CodeableConcept>? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var locationCodeableConcept: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var bodySite: CodeableConcept? = null
    var subSite: List<CodeableConcept>? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var detail: List<ExplanationOfBenefit.AddItem.Detail>? = null
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
          itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        4 ->
          _itemSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _detailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          subDetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _subDetailSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        10 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        13 -> servicedDate = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _servicedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          servicedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        16 ->
          locationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          locationAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        18 ->
          locationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        20 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        21 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        22 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        24 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          subSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        26 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        27 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        28 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        29 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AddItem: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.AddItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      itemSequence =
        (kotlin.collections.List(maxOf(itemSequence?.size ?: 0, _itemSequence?.size ?: 0)) { index
          ->
          PositiveInt.of(itemSequence?.getOrNull(index), _itemSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'itemSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      detailSequence =
        (kotlin.collections.List(maxOf(detailSequence?.size ?: 0, _detailSequence?.size ?: 0)) {
          index ->
          PositiveInt.of(detailSequence?.getOrNull(index), _detailSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'detailSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      subDetailSequence =
        (kotlin.collections.List(
          maxOf(subDetailSequence?.size ?: 0, _subDetailSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(subDetailSequence?.getOrNull(index), _subDetailSequence?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'subDetailSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      provider = provider ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.AddItem"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        ExplanationOfBenefit.AddItem.Serviced.from(
          Date.of(
            if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
            _servicedDate,
          ),
          servicedPeriod,
        ),
      location =
        ExplanationOfBenefit.AddItem.Location.from(
          locationCodeableConcept,
          locationAddress,
          locationReference,
        ),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      bodySite = bodySite,
      subSite = subSite ?: listOf(),
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.itemSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        3,
        intNullableListSerializer,
        value.itemSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 4, value.itemSequence)
    }
    if (value.detailSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        5,
        intNullableListSerializer,
        value.detailSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 6, value.detailSequence)
    }
    if (value.subDetailSequence.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        7,
        intNullableListSerializer,
        value.subDetailSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 8, value.subDetailSequence)
    }
    if (value.provider.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        ReferenceSerializer.listSerializer,
        value.provider,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      10,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    when (val choice = value.serviced) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Serviced.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Serviced.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 15, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is ExplanationOfBenefit.AddItem.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 17, AddressSerializer, choice.value)
      }
      is ExplanationOfBenefit.AddItem.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          18,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 19, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 20, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 23, MoneySerializer, value.net)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24,
      CodeableConceptSerializer,
      value.bodySite,
    )
    if (value.subSite.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25,
        CodeableConceptSerializer.listSerializer,
        value.subSite,
      )
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        26,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 27, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.detail.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29,
        ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
        value.detail,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitAddItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
      optionalElement(
        "subDetail",
        ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var subDetail: List<ExplanationOfBenefit.AddItem.Detail.SubDetail>? = null
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
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        7 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        8 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        10 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        11 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        13 ->
          subDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.AddItem.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.AddItem.Detail"
          ),
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, MoneySerializer, value.net)
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.subDetail.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
        value.subDetail,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitAddItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail.SubDetail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail.SubDetail {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var net: Money? = null
    var noteNumber: List<Int?>? = null
    var _noteNumber: List<Element?>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        7 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        8 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        10 ->
          noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        11 ->
          _noteNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.AddItem.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on ExplanationOfBenefit.AddItem.Detail.SubDetail"
          ),
      modifier = modifier ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      noteNumber =
        (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
          PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail.SubDetail has neither a value nor an id/extension"
            )
        }),
      adjudication = adjudication ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 9, MoneySerializer, value.net)
    if (value.noteNumber.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        intNullableListSerializer,
        value.noteNumber.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.noteNumber)
    }
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitTotalSerializer : KSerializer<ExplanationOfBenefit.Total> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Total") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Total>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Total {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var amount: Money? = null
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Total: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Total(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.Total"
          ),
      amount =
        amount
          ?: throw SerializationException(
            "Missing required property 'amount' on ExplanationOfBenefit.Total"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Total) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, MoneySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitPaymentSerializer : KSerializer<ExplanationOfBenefit.Payment> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payment") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("adjustment", MoneySerializer.descriptor)
      optionalElement("adjustmentReason", CodeableConceptSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Payment>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payment {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var adjustment: Money? = null
    var adjustmentReason: CodeableConcept? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var amount: Money? = null
    var identifier: Identifier? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          adjustment =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        5 ->
          adjustmentReason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 -> date = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payment: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.Payment(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      adjustment = adjustment,
      adjustmentReason = adjustmentReason,
      date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
      amount = amount,
      identifier = identifier,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payment) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, MoneySerializer, value.adjustment)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.adjustmentReason,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.date)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.amount)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitProcessNoteSerializer :
  KSerializer<ExplanationOfBenefit.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("number", Int.serializer().descriptor)
      optionalElement("_number", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.ProcessNote>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.ProcessNote {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: Int? = null
    var _number: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var language: CodeableConcept? = null
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
        3 -> number = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _number =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number = PositiveInt.of(number, _number),
      type = Enumeration.of(if (type != null) NoteType.fromCode(type) else null, _type),
      text = R4String.of(text, _text),
      language = language,
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.ProcessNote) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.number?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.number)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.text)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.language,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitBenefitBalanceSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BenefitBalance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("excluded", KotlinBoolean.serializer().descriptor)
      optionalElement("_excluded", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("network", CodeableConceptSerializer.descriptor)
      optionalElement("unit", CodeableConceptSerializer.descriptor)
      optionalElement("term", CodeableConceptSerializer.descriptor)
      optionalElement(
        "financial",
        ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.BenefitBalance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var excluded: KotlinBoolean? = null
    var _excluded: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var network: CodeableConcept? = null
    var unit: CodeableConcept? = null
    var term: CodeableConcept? = null
    var financial: List<ExplanationOfBenefit.BenefitBalance.Financial>? = null
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
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> excluded = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _excluded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 ->
          network =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          term =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          financial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding BenefitBalance: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.BenefitBalance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category =
        category
          ?: throw SerializationException(
            "Missing required property 'category' on ExplanationOfBenefit.BenefitBalance"
          ),
      excluded = R4Boolean.of(excluded, _excluded),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      network = network,
      unit = unit,
      term = term,
      financial = financial ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.excluded?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.excluded)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10,
      CodeableConceptSerializer,
      value.network,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      CodeableConceptSerializer,
      value.unit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      CodeableConceptSerializer,
      value.term,
    )
    if (value.financial.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13,
        ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
        value.financial,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitBenefitBalanceFinancialSerializer :
  KSerializer<ExplanationOfBenefit.BenefitBalance.Financial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Financial") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("allowedUnsignedInt", Int.serializer().descriptor)
      optionalElement("_allowedUnsignedInt", ElementSerializer.descriptor)
      optionalElement("allowedString", KotlinString.serializer().descriptor)
      optionalElement("_allowedString", ElementSerializer.descriptor)
      optionalElement("allowedMoney", MoneySerializer.descriptor)
      optionalElement("usedUnsignedInt", Int.serializer().descriptor)
      optionalElement("_usedUnsignedInt", ElementSerializer.descriptor)
      optionalElement("usedMoney", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.BenefitBalance.Financial>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance.Financial {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowedUnsignedInt: Int? = null
    var _allowedUnsignedInt: Element? = null
    var allowedString: KotlinString? = null
    var _allowedString: Element? = null
    var allowedMoney: Money? = null
    var usedUnsignedInt: Int? = null
    var _usedUnsignedInt: Element? = null
    var usedMoney: Money? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> allowedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _allowedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> allowedString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _allowedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          allowedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 -> usedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _usedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          usedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Financial: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ExplanationOfBenefit.BenefitBalance.Financial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ExplanationOfBenefit.BenefitBalance.Financial"
          ),
      allowed =
        ExplanationOfBenefit.BenefitBalance.Financial.Allowed.from(
          UnsignedInt.of(allowedUnsignedInt, _allowedUnsignedInt),
          R4String.of(allowedString, _allowedString),
          allowedMoney,
        ),
      used =
        ExplanationOfBenefit.BenefitBalance.Financial.Used.from(
          UnsignedInt.of(usedUnsignedInt, _usedUnsignedInt),
          usedMoney,
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance.Financial) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.allowed) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, MoneySerializer, choice.value)
      }
    }
    when (val choice = value.used) {
      null -> {}
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is ExplanationOfBenefit.BenefitBalance.Financial.Used.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 11, MoneySerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ExplanationOfBenefitSerializer : FhirResourceSerializer<ExplanationOfBenefit> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ExplanationOfBenefit")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subType", CodeableConceptSerializer.descriptor)
    b.optionalElement("use", KotlinString.serializer().descriptor)
    b.optionalElement("_use", ElementSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("billablePeriod", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
    b.optionalElement("provider", ReferenceSerializer.descriptor)
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("fundsReserveRequested", CodeableConceptSerializer.descriptor)
    b.optionalElement("fundsReserve", CodeableConceptSerializer.descriptor)
    b.optionalElement("related", ExplanationOfBenefitRelatedSerializer.listSerializer.descriptor)
    b.optionalElement("prescription", ReferenceSerializer.descriptor)
    b.optionalElement("originalPrescription", ReferenceSerializer.descriptor)
    b.optionalElement("payee", ExplanationOfBenefitPayeeSerializer.descriptor)
    b.optionalElement("referral", ReferenceSerializer.descriptor)
    b.optionalElement("facility", ReferenceSerializer.descriptor)
    b.optionalElement("claim", ReferenceSerializer.descriptor)
    b.optionalElement("claimResponse", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
    b.optionalElement("preAuthRef", stringNullableListSerializer.descriptor)
    b.optionalElement("_preAuthRef", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("preAuthRefPeriod", PeriodSerializer.listSerializer.descriptor)
    b.optionalElement("careTeam", ExplanationOfBenefitCareTeamSerializer.listSerializer.descriptor)
    b.optionalElement(
      "supportingInfo",
      ExplanationOfBenefitSupportingInfoSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "diagnosis",
      ExplanationOfBenefitDiagnosisSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "procedure",
      ExplanationOfBenefitProcedureSerializer.listSerializer.descriptor,
    )
    b.optionalElement("precedence", Int.serializer().descriptor)
    b.optionalElement("_precedence", ElementSerializer.descriptor)
    b.optionalElement(
      "insurance",
      ExplanationOfBenefitInsuranceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("accident", ExplanationOfBenefitAccidentSerializer.descriptor)
    b.optionalElement("item", ExplanationOfBenefitItemSerializer.listSerializer.descriptor)
    b.optionalElement("addItem", ExplanationOfBenefitAddItemSerializer.listSerializer.descriptor)
    b.optionalElement(
      "adjudication",
      ExplanationOfBenefitItemAdjudicationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("total", ExplanationOfBenefitTotalSerializer.listSerializer.descriptor)
    b.optionalElement("payment", ExplanationOfBenefitPaymentSerializer.descriptor)
    b.optionalElement("formCode", CodeableConceptSerializer.descriptor)
    b.optionalElement("form", AttachmentSerializer.descriptor)
    b.optionalElement(
      "processNote",
      ExplanationOfBenefitProcessNoteSerializer.listSerializer.descriptor,
    )
    b.optionalElement("benefitPeriod", PeriodSerializer.descriptor)
    b.optionalElement(
      "benefitBalance",
      ExplanationOfBenefitBenefitBalanceSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ExplanationOfBenefit {
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
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var patient: Reference? = null
    var billablePeriod: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var enterer: Reference? = null
    var insurer: Reference? = null
    var provider: Reference? = null
    var priority: CodeableConcept? = null
    var fundsReserveRequested: CodeableConcept? = null
    var fundsReserve: CodeableConcept? = null
    var related: List<ExplanationOfBenefit.Related>? = null
    var prescription: Reference? = null
    var originalPrescription: Reference? = null
    var payee: ExplanationOfBenefit.Payee? = null
    var referral: Reference? = null
    var facility: Reference? = null
    var claim: Reference? = null
    var claimResponse: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    var preAuthRefPeriod: List<Period>? = null
    var careTeam: List<ExplanationOfBenefit.CareTeam>? = null
    var supportingInfo: List<ExplanationOfBenefit.SupportingInfo>? = null
    var diagnosis: List<ExplanationOfBenefit.Diagnosis>? = null
    var procedure: List<ExplanationOfBenefit.Procedure>? = null
    var precedence: Int? = null
    var _precedence: Element? = null
    var insurance: List<ExplanationOfBenefit.Insurance>? = null
    var accident: ExplanationOfBenefit.Accident? = null
    var item: List<ExplanationOfBenefit.Item>? = null
    var addItem: List<ExplanationOfBenefit.AddItem>? = null
    var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
    var total: List<ExplanationOfBenefit.Total>? = null
    var payment: ExplanationOfBenefit.Payment? = null
    var formCode: CodeableConcept? = null
    var form: Attachment? = null
    var processNote: List<ExplanationOfBenefit.ProcessNote>? = null
    var benefitPeriod: Period? = null
    var benefitBalance: List<ExplanationOfBenefit.BenefitBalance>? = null
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
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          subType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> use = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          billablePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        19 -> created = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          enterer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          insurer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          fundsReserveRequested =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          fundsReserve =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          related =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitRelatedSerializer.listSerializer,
              null,
            )
        28 ->
          prescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          originalPrescription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          payee =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPayeeSerializer,
              null,
            )
        31 ->
          referral =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        32 ->
          facility =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        33 ->
          claim =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        34 ->
          claimResponse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        35 -> outcome = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> disposition = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _disposition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 ->
          preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        40 ->
          _preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        41 ->
          preAuthRefPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        42 ->
          careTeam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitCareTeamSerializer.listSerializer,
              null,
            )
        43 ->
          supportingInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
              null,
            )
        44 ->
          diagnosis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitDiagnosisSerializer.listSerializer,
              null,
            )
        45 ->
          procedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcedureSerializer.listSerializer,
              null,
            )
        46 -> precedence = compositeDecoder.decodeIntElement(descriptor, i)
        47 ->
          _precedence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        48 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitInsuranceSerializer.listSerializer,
              null,
            )
        49 ->
          accident =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAccidentSerializer,
              null,
            )
        50 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemSerializer.listSerializer,
              null,
            )
        51 ->
          addItem =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemSerializer.listSerializer,
              null,
            )
        52 ->
          adjudication =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        53 ->
          total =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitTotalSerializer.listSerializer,
              null,
            )
        54 ->
          payment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPaymentSerializer,
              null,
            )
        55 ->
          formCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        56 ->
          form =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        57 ->
          processNote =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcessNoteSerializer.listSerializer,
              null,
            )
        58 ->
          benefitPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        59 ->
          benefitBalance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitBenefitBalanceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ExplanationOfBenefit: " + i)
      }
    }
    return ExplanationOfBenefit(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) ExplanationOfBenefitStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on ExplanationOfBenefit"
          ),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on ExplanationOfBenefit"
          ),
      subType = subType,
      use =
        Enumeration.of(if (use != null) Use.fromCode(use) else null, _use)
          ?: throw SerializationException(
            "Missing required property 'use' on ExplanationOfBenefit"
          ),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on ExplanationOfBenefit"
          ),
      billablePeriod = billablePeriod,
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on ExplanationOfBenefit"
          ),
      enterer = enterer,
      insurer =
        insurer
          ?: throw SerializationException(
            "Missing required property 'insurer' on ExplanationOfBenefit"
          ),
      provider =
        provider
          ?: throw SerializationException(
            "Missing required property 'provider' on ExplanationOfBenefit"
          ),
      priority = priority,
      fundsReserveRequested = fundsReserveRequested,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      facility = facility,
      claim = claim,
      claimResponse = claimResponse,
      outcome =
        Enumeration.of(
          if (outcome != null) ClaimProcessingCodes.fromCode(outcome) else null,
          _outcome,
        )
          ?: throw SerializationException(
            "Missing required property 'outcome' on ExplanationOfBenefit"
          ),
      disposition = R4String.of(disposition, _disposition),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R4String.of(preAuthRef?.getOrNull(index), _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on ExplanationOfBenefit has neither a value nor an id/extension"
            )
        }),
      preAuthRefPeriod = preAuthRefPeriod ?: listOf(),
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      precedence = PositiveInt.of(precedence, _precedence),
      insurance = insurance ?: listOf(),
      accident = accident,
      item = item ?: listOf(),
      addItem = addItem ?: listOf(),
      adjudication = adjudication ?: listOf(),
      total = total ?: listOf(),
      payment = payment,
      formCode = formCode,
      form = form,
      processNote = processNote ?: listOf(),
      benefitPeriod = benefitPeriod,
      benefitBalance = benefitBalance ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExplanationOfBenefit,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.subType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.use)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      PeriodSerializer,
      value.billablePeriod,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.provider,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserveRequested,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserve,
    )
    if (value.related.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ExplanationOfBenefitRelatedSerializer.listSerializer,
        value.related,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.prescription,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.originalPrescription,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ExplanationOfBenefitPayeeSerializer,
      value.payee,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.referral,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer,
      value.facility,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.claim,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      ReferenceSerializer,
      value.claimResponse,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.outcome.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.outcome)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.disposition?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.disposition)
    if (value.preAuthRef.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        39 + descriptorOffset,
        stringNullableListSerializer,
        value.preAuthRef.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        40 + descriptorOffset,
        value.preAuthRef,
      )
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        PeriodSerializer.listSerializer,
        value.preAuthRefPeriod,
      )
    if (value.careTeam.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        ExplanationOfBenefitCareTeamSerializer.listSerializer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ExplanationOfBenefitDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ExplanationOfBenefitProcedureSerializer.listSerializer,
        value.procedure,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 46 + descriptorOffset, value.precedence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 47 + descriptorOffset, value.precedence)
    if (value.insurance.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ExplanationOfBenefitInsuranceSerializer.listSerializer,
        value.insurance,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      ExplanationOfBenefitAccidentSerializer,
      value.accident,
    )
    if (value.item.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ExplanationOfBenefitItemSerializer.listSerializer,
        value.item,
      )
    if (value.addItem.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ExplanationOfBenefitAddItemSerializer.listSerializer,
        value.addItem,
      )
    if (value.adjudication.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        52 + descriptorOffset,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.total.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ExplanationOfBenefitTotalSerializer.listSerializer,
        value.total,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      ExplanationOfBenefitPaymentSerializer,
      value.payment,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      55 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      56 + descriptorOffset,
      AttachmentSerializer,
      value.form,
    )
    if (value.processNote.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        ExplanationOfBenefitProcessNoteSerializer.listSerializer,
        value.processNote,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      58 + descriptorOffset,
      PeriodSerializer,
      value.benefitPeriod,
    )
    if (value.benefitBalance.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        ExplanationOfBenefitBenefitBalanceSerializer.listSerializer,
        value.benefitBalance,
      )
  }
}
