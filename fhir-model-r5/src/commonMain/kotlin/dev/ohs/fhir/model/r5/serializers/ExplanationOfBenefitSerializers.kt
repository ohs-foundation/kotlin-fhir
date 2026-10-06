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

import dev.ohs.fhir.model.r5.Address
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.ExplanationOfBenefit
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Related =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var claim: Reference? = null
      var relationship: CodeableConcept? = null
      var reference: Identifier? = null
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
          3 -> claim = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            relationship =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            reference = decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Related: " + i)
        }
      }
      ExplanationOfBenefit.Related(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        claim = claim,
        relationship = relationship,
        reference = reference,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Related) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.claim)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.relationship)
      encodeSerializableIfNotNull(descriptor, 5, IdentifierSerializer, value.reference)
    }
  }
}

internal object ExplanationOfBenefitEventSerializer : KSerializer<ExplanationOfBenefit.Event> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Event") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("whenDateTime", KotlinString.serializer().descriptor)
      optionalElement("_whenDateTime", ElementSerializer.descriptor)
      optionalElement("whenPeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Event>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Event =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var whenDateTime: KotlinString? = null
      var _whenDateTime: Element? = null
      var whenPeriod: Period? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> whenDateTime = decodeStringElement(descriptor, i)
          5 ->
            _whenDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> whenPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Event: " + i)
        }
      }
      ExplanationOfBenefit.Event(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on ExplanationOfBenefit.Event"
            ),
        `when` =
          ExplanationOfBenefit.Event.When.from(
            DateTime.of(
              if (whenDateTime != null) FhirDateTime.fromString(whenDateTime) else null,
              _whenDateTime,
            ),
            whenPeriod,
          )
            ?: throw SerializationException(
              "Missing required property 'when' on ExplanationOfBenefit.Event"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Event) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.`when`) {
        is ExplanationOfBenefit.Event.When.DateTime -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is ExplanationOfBenefit.Event.When.Period -> {
          encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
        }
      }
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payee =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var party: Reference? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Payee: " + i)
        }
      }
      ExplanationOfBenefit.Payee(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        party = party,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Payee) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.party)
    }
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
      optionalElement("specialty", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.CareTeam>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.CareTeam =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var provider: Reference? = null
      var responsible: KotlinBoolean? = null
      var _responsible: Element? = null
      var role: CodeableConcept? = null
      var specialty: CodeableConcept? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            provider = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> responsible = decodeBooleanElement(descriptor, i)
          7 ->
            _responsible = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            specialty =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CareTeam: " + i)
        }
      }
      ExplanationOfBenefit.CareTeam(
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
        responsible = R5Boolean.of(responsible, _responsible),
        role = role,
        specialty = specialty,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.CareTeam) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.provider)
      encodeBooleanIfNotNull(descriptor, 6, value.responsible?.value)
      encodeElementIfNotNull(descriptor, 7, value.responsible)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.role)
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.specialty)
    }
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
      optionalElement("valueIdentifier", IdentifierSerializer.descriptor)
      optionalElement("reason", CodingSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.SupportingInfo>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.SupportingInfo =
    decoder.decodeStructure(descriptor) {
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
      var valueIdentifier: Identifier? = null
      var reason: Coding? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 -> timingDate = decodeStringElement(descriptor, i)
          8 ->
            _timingDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            timingPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          10 -> valueBoolean = decodeBooleanElement(descriptor, i)
          11 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> valueString = decodeStringElement(descriptor, i)
          13 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          15 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          16 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          17 ->
            valueIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          18 -> reason = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
        }
      }
      ExplanationOfBenefit.SupportingInfo(
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
            R5Boolean.of(valueBoolean, _valueBoolean),
            R5String.of(valueString, _valueString),
            valueQuantity,
            valueAttachment,
            valueReference,
            valueIdentifier,
          ),
        reason = reason,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.SupportingInfo) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.code)
      when (val choice = value.timing) {
        null -> {}
        is ExplanationOfBenefit.SupportingInfo.Timing.Date -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Timing.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.`value`) {
        null -> {}
        is ExplanationOfBenefit.SupportingInfo.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Value.String -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Value.Quantity -> {
          encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Value.Attachment -> {
          encodeSerializableElement(descriptor, 15, AttachmentSerializer, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Value.Reference -> {
          encodeSerializableElement(descriptor, 16, ReferenceSerializer, choice.value)
        }
        is ExplanationOfBenefit.SupportingInfo.Value.Identifier -> {
          encodeSerializableElement(descriptor, 17, IdentifierSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 18, CodingSerializer, value.reason)
    }
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
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Diagnosis>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Diagnosis =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var diagnosisCodeableConcept: CodeableConcept? = null
      var diagnosisReference: Reference? = null
      var type: List<CodeableConcept>? = null
      var onAdmission: CodeableConcept? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            diagnosisCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            diagnosisReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            onAdmission =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
        }
      }
      ExplanationOfBenefit.Diagnosis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on ExplanationOfBenefit.Diagnosis"
            ),
        diagnosis =
          ExplanationOfBenefit.Diagnosis.Diagnosis.from(
            diagnosisCodeableConcept,
            diagnosisReference,
          )
            ?: throw SerializationException(
              "Missing required property 'diagnosis' on ExplanationOfBenefit.Diagnosis"
            ),
        type = type ?: listOf(),
        onAdmission = onAdmission,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Diagnosis) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      when (val choice = value.diagnosis) {
        is ExplanationOfBenefit.Diagnosis.Diagnosis.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is ExplanationOfBenefit.Diagnosis.Diagnosis.Reference -> {
          encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
        }
      }
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.onAdmission)
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Procedure =
    decoder.decodeStructure(descriptor) {
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 -> date = decodeStringElement(descriptor, i)
          7 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            procedureCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            procedureReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          10 ->
            udi =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
        }
      }
      ExplanationOfBenefit.Procedure(
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
          ExplanationOfBenefit.Procedure.Procedure.from(
            procedureCodeableConcept,
            procedureReference,
          )
            ?: throw SerializationException(
              "Missing required property 'procedure' on ExplanationOfBenefit.Procedure"
            ),
        udi = udi ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Procedure) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.date)
      when (val choice = value.procedure) {
        is ExplanationOfBenefit.Procedure.Procedure.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
        is ExplanationOfBenefit.Procedure.Procedure.Reference -> {
          encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
        }
      }
      if (value.udi.isNotEmpty())
        encodeSerializableElement(descriptor, 10, ReferenceSerializer.listSerializer, value.udi)
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Insurance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var focal: KotlinBoolean? = null
      var _focal: Element? = null
      var coverage: Reference? = null
      var preAuthRef: List<KotlinString?>? = null
      var _preAuthRef: List<Element?>? = null
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
          3 -> focal = decodeBooleanElement(descriptor, i)
          4 -> _focal = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            coverage = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            preAuthRef =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          7 ->
            _preAuthRef =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
        }
      }
      ExplanationOfBenefit.Insurance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        focal =
          R5Boolean.of(focal, _focal)
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
            R5String.of(preAuthRef?.getOrNull(index), _preAuthRef?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'preAuthRef' on ExplanationOfBenefit.Insurance has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Insurance) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.focal.value)
      encodeElementIfNotNull(descriptor, 4, value.focal)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.coverage)
      if (value.preAuthRef.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          6,
          stringNullableListSerializer,
          value.preAuthRef.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 7, value.preAuthRef)
      }
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Accident =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var type: CodeableConcept? = null
      var locationAddress: Address? = null
      var locationReference: Reference? = null
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
          3 -> date = decodeStringElement(descriptor, i)
          4 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            locationAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          7 ->
            locationReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Accident: " + i)
        }
      }
      ExplanationOfBenefit.Accident(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
        type = type,
        location = ExplanationOfBenefit.Accident.Location.from(locationAddress, locationReference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Accident) {
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
      encodeStringIfNotNull(descriptor, 3, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.date)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      when (val choice = value.location) {
        null -> {}
        is ExplanationOfBenefit.Accident.Location.Address -> {
          encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
        }
        is ExplanationOfBenefit.Accident.Location.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
      }
    }
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
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("servicedDate", KotlinString.serializer().descriptor)
      optionalElement("_servicedDate", ElementSerializer.descriptor)
      optionalElement("servicedPeriod", PeriodSerializer.descriptor)
      optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("locationAddress", AddressSerializer.descriptor)
      optionalElement("locationReference", ReferenceSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "bodySite",
        ExplanationOfBenefitItemBodySiteSerializer.listSerializer.descriptor,
      )
      optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("reviewOutcome", ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor)
      optionalElement(
        "adjudication",
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer.descriptor,
      )
      optionalElement("detail", ExplanationOfBenefitItemDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item =
    decoder.decodeStructure(descriptor) {
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
      var traceNumber: List<Identifier>? = null
      var revenue: CodeableConcept? = null
      var category: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var request: List<Reference>? = null
      var modifier: List<CodeableConcept>? = null
      var programCode: List<CodeableConcept>? = null
      var servicedDate: KotlinString? = null
      var _servicedDate: Element? = null
      var servicedPeriod: Period? = null
      var locationCodeableConcept: CodeableConcept? = null
      var locationAddress: Address? = null
      var locationReference: Reference? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var udi: List<Reference>? = null
      var bodySite: List<ExplanationOfBenefit.Item.BodySite>? = null
      var encounter: List<Reference>? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
      var detail: List<ExplanationOfBenefit.Item.Detail>? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            careTeamSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          6 ->
            _careTeamSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            diagnosisSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          8 ->
            _diagnosisSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            procedureSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          10 ->
            _procedureSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          11 ->
            informationSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          12 ->
            _informationSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          13 ->
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          14 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          17 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          18 ->
            request =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          19 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          20 ->
            programCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          21 -> servicedDate = decodeStringElement(descriptor, i)
          22 ->
            _servicedDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 ->
            servicedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          24 ->
            locationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          25 ->
            locationAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          26 ->
            locationReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          27 ->
            patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          28 ->
            quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          29 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          30 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          31 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          32 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          33 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          34 ->
            udi =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          35 ->
            bodySite =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemBodySiteSerializer.listSerializer,
                null,
              )
          36 ->
            encounter =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          37 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          38 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          39 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          40 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          41 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      ExplanationOfBenefit.Item(
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
            PositiveInt.of(
              diagnosisSequence?.getOrNull(index),
              _diagnosisSequence?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'diagnosisSequence' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
              )
          }),
        procedureSequence =
          (kotlin.collections.List(
            maxOf(procedureSequence?.size ?: 0, _procedureSequence?.size ?: 0)
          ) { index ->
            PositiveInt.of(
              procedureSequence?.getOrNull(index),
              _procedureSequence?.getOrNull(index),
            )
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
        traceNumber = traceNumber ?: listOf(),
        revenue = revenue,
        category = category,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        request = request ?: listOf(),
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
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        udi = udi ?: listOf(),
        bodySite = bodySite ?: listOf(),
        encounter = encounter ?: listOf(),
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.Item has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      if (value.careTeamSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          intNullableListSerializer,
          value.careTeamSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.careTeamSequence)
      }
      if (value.diagnosisSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          intNullableListSerializer,
          value.diagnosisSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.diagnosisSequence)
      }
      if (value.procedureSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          intNullableListSerializer,
          value.procedureSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.procedureSequence)
      }
      if (value.informationSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          intNullableListSerializer,
          value.informationSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 12, value.informationSequence)
      }
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 16, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        17,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.request.isNotEmpty())
        encodeSerializableElement(descriptor, 18, ReferenceSerializer.listSerializer, value.request)
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      if (value.programCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          20,
          CodeableConceptSerializer.listSerializer,
          value.programCode,
        )
      when (val choice = value.serviced) {
        null -> {}
        is ExplanationOfBenefit.Item.Serviced.Date -> {
          encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 22, choice.value)
        }
        is ExplanationOfBenefit.Item.Serviced.Period -> {
          encodeSerializableElement(descriptor, 23, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.location) {
        null -> {}
        is ExplanationOfBenefit.Item.Location.CodeableConcept -> {
          encodeSerializableElement(descriptor, 24, CodeableConceptSerializer, choice.value)
        }
        is ExplanationOfBenefit.Item.Location.Address -> {
          encodeSerializableElement(descriptor, 25, AddressSerializer, choice.value)
        }
        is ExplanationOfBenefit.Item.Location.Reference -> {
          encodeSerializableElement(descriptor, 26, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 27, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 28, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 29, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 30, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 31, value.factor)
      encodeSerializableIfNotNull(descriptor, 32, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 33, MoneySerializer, value.net)
      if (value.udi.isNotEmpty())
        encodeSerializableElement(descriptor, 34, ReferenceSerializer.listSerializer, value.udi)
      if (value.bodySite.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          35,
          ExplanationOfBenefitItemBodySiteSerializer.listSerializer,
          value.bodySite,
        )
      if (value.encounter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          36,
          ReferenceSerializer.listSerializer,
          value.encounter,
        )
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          37,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 38, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        39,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          40,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          41,
          ExplanationOfBenefitItemDetailSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object ExplanationOfBenefitItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.Item.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("site", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.BodySite>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.BodySite =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var site: List<CodeableReference>? = null
      var subSite: List<CodeableConcept>? = null
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
            site =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            subSite =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding BodySite: " + i)
        }
      }
      ExplanationOfBenefit.Item.BodySite(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        site = site ?: listOf(),
        subSite = subSite ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.BodySite) {
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
      if (value.site.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableReferenceSerializer.listSerializer,
          value.site,
        )
      if (value.subSite.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.subSite,
        )
    }
  }
}

internal object ExplanationOfBenefitItemReviewOutcomeSerializer :
  KSerializer<ExplanationOfBenefit.Item.ReviewOutcome> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ReviewOutcome") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("decision", CodeableConceptSerializer.descriptor)
      optionalElement("reason", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("preAuthRef", KotlinString.serializer().descriptor)
      optionalElement("_preAuthRef", ElementSerializer.descriptor)
      optionalElement("preAuthPeriod", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.ReviewOutcome>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.ReviewOutcome =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var decision: CodeableConcept? = null
      var reason: List<CodeableConcept>? = null
      var preAuthRef: KotlinString? = null
      var _preAuthRef: Element? = null
      var preAuthPeriod: Period? = null
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
            decision =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reason =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> preAuthRef = decodeStringElement(descriptor, i)
          6 ->
            _preAuthRef = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            preAuthPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ReviewOutcome: " + i)
        }
      }
      ExplanationOfBenefit.Item.ReviewOutcome(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        decision = decision,
        reason = reason ?: listOf(),
        preAuthRef = R5String.of(preAuthRef, _preAuthRef),
        preAuthPeriod = preAuthPeriod,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.ReviewOutcome) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.decision)
      if (value.reason.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.reason,
        )
      encodeStringIfNotNull(descriptor, 5, value.preAuthRef?.value)
      encodeElementIfNotNull(descriptor, 6, value.preAuthRef)
      encodeSerializableIfNotNull(descriptor, 7, PeriodSerializer, value.preAuthPeriod)
    }
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
      optionalElement("quantity", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Adjudication>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Adjudication =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var reason: CodeableConcept? = null
      var amount: Money? = null
      var quantity: Quantity? = null
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            reason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          6 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Adjudication: " + i)
        }
      }
      ExplanationOfBenefit.Item.Adjudication(
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
        quantity = quantity,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Adjudication) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.reason)
      encodeSerializableIfNotNull(descriptor, 5, MoneySerializer, value.amount)
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.quantity)
    }
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
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor },
      )
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var traceNumber: List<Identifier>? = null
      var revenue: CodeableConcept? = null
      var category: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var modifier: List<CodeableConcept>? = null
      var programCode: List<CodeableConcept>? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var udi: List<Reference>? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
      var subDetail: List<ExplanationOfBenefit.Item.Detail.SubDetail>? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          6 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            programCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          12 ->
            patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          13 ->
            quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          14 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          15 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          16 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          18 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          19 ->
            udi =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          20 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          21 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          22 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          23 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          24 ->
            subDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      ExplanationOfBenefit.Item.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail"
            ),
        traceNumber = traceNumber ?: listOf(),
        revenue = revenue,
        category = category,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        modifier = modifier ?: listOf(),
        programCode = programCode ?: listOf(),
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        udi = udi ?: listOf(),
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
        subDetail = subDetail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        9,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      if (value.programCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.programCode,
        )
      encodeSerializableIfNotNull(descriptor, 12, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 13, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 15, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 16, value.factor)
      encodeSerializableIfNotNull(descriptor, 17, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 18, MoneySerializer, value.net)
      if (value.udi.isNotEmpty())
        encodeSerializableElement(descriptor, 19, ReferenceSerializer.listSerializer, value.udi)
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          20,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 21, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        22,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          23,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
      if (value.subDetail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          24,
          ExplanationOfBenefitItemDetailSubDetailSerializer.listSerializer,
          value.subDetail,
        )
    }
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
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor },
      )
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.Item.Detail.SubDetail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Item.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var traceNumber: List<Identifier>? = null
      var revenue: CodeableConcept? = null
      var category: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var modifier: List<CodeableConcept>? = null
      var programCode: List<CodeableConcept>? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var udi: List<Reference>? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          6 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          9 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          11 ->
            programCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          12 ->
            patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          13 ->
            quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          14 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          15 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          16 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          18 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          19 ->
            udi =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          20 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          21 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          22 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          23 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
        }
      }
      ExplanationOfBenefit.Item.Detail.SubDetail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on ExplanationOfBenefit.Item.Detail.SubDetail"
            ),
        traceNumber = traceNumber ?: listOf(),
        revenue = revenue,
        category = category,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        modifier = modifier ?: listOf(),
        programCode = programCode ?: listOf(),
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        udi = udi ?: listOf(),
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.Item.Detail.SubDetail has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.Item.Detail.SubDetail) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        9,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      if (value.programCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.programCode,
        )
      encodeSerializableIfNotNull(descriptor, 12, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 13, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 15, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 16, value.factor)
      encodeSerializableIfNotNull(descriptor, 17, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 18, MoneySerializer, value.net)
      if (value.udi.isNotEmpty())
        encodeSerializableElement(descriptor, 19, ReferenceSerializer.listSerializer, value.udi)
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          20,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 21, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        22,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          23,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
    }
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
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("provider", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("servicedDate", KotlinString.serializer().descriptor)
      optionalElement("_servicedDate", ElementSerializer.descriptor)
      optionalElement("servicedPeriod", PeriodSerializer.descriptor)
      optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("locationAddress", AddressSerializer.descriptor)
      optionalElement("locationReference", ReferenceSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement(
        "bodySite",
        ExplanationOfBenefitAddItemBodySiteSerializer.listSerializer.descriptor,
      )
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("reviewOutcome", ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor)
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var itemSequence: List<Int?>? = null
      var _itemSequence: List<Element?>? = null
      var detailSequence: List<Int?>? = null
      var _detailSequence: List<Element?>? = null
      var subDetailSequence: List<Int?>? = null
      var _subDetailSequence: List<Element?>? = null
      var traceNumber: List<Identifier>? = null
      var provider: List<Reference>? = null
      var revenue: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var request: List<Reference>? = null
      var modifier: List<CodeableConcept>? = null
      var programCode: List<CodeableConcept>? = null
      var servicedDate: KotlinString? = null
      var _servicedDate: Element? = null
      var servicedPeriod: Period? = null
      var locationCodeableConcept: CodeableConcept? = null
      var locationAddress: Address? = null
      var locationReference: Reference? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var bodySite: List<ExplanationOfBenefit.AddItem.BodySite>? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
      var detail: List<ExplanationOfBenefit.AddItem.Detail>? = null
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
            itemSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          4 ->
            _itemSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 ->
            detailSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          6 ->
            _detailSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          7 ->
            subDetailSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          8 ->
            _subDetailSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          9 ->
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          10 ->
            provider =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          11 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          13 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            request =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          15 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          16 ->
            programCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          17 -> servicedDate = decodeStringElement(descriptor, i)
          18 ->
            _servicedDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            servicedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          20 ->
            locationCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          21 ->
            locationAddress =
              decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          22 ->
            locationReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          23 ->
            patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          24 ->
            quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          25 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          26 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          27 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          28 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          29 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          30 ->
            bodySite =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitAddItemBodySiteSerializer.listSerializer,
                null,
              )
          31 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          32 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          33 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          34 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          35 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AddItem: " + i)
        }
      }
      ExplanationOfBenefit.AddItem(
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
            PositiveInt.of(
              subDetailSequence?.getOrNull(index),
              _subDetailSequence?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'subDetailSequence' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
              )
          }),
        traceNumber = traceNumber ?: listOf(),
        provider = provider ?: listOf(),
        revenue = revenue,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        request = request ?: listOf(),
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
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        bodySite = bodySite ?: listOf(),
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem) {
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
      if (value.itemSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          intNullableListSerializer,
          value.itemSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 4, value.itemSequence)
      }
      if (value.detailSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          5,
          intNullableListSerializer,
          value.detailSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 6, value.detailSequence)
      }
      if (value.subDetailSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          7,
          intNullableListSerializer,
          value.subDetailSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 8, value.subDetailSequence)
      }
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      if (value.provider.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          ReferenceSerializer.listSerializer,
          value.provider,
        )
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 12, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        13,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.request.isNotEmpty())
        encodeSerializableElement(descriptor, 14, ReferenceSerializer.listSerializer, value.request)
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      if (value.programCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CodeableConceptSerializer.listSerializer,
          value.programCode,
        )
      when (val choice = value.serviced) {
        null -> {}
        is ExplanationOfBenefit.AddItem.Serviced.Date -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is ExplanationOfBenefit.AddItem.Serviced.Period -> {
          encodeSerializableElement(descriptor, 19, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.location) {
        null -> {}
        is ExplanationOfBenefit.AddItem.Location.CodeableConcept -> {
          encodeSerializableElement(descriptor, 20, CodeableConceptSerializer, choice.value)
        }
        is ExplanationOfBenefit.AddItem.Location.Address -> {
          encodeSerializableElement(descriptor, 21, AddressSerializer, choice.value)
        }
        is ExplanationOfBenefit.AddItem.Location.Reference -> {
          encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 23, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 24, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 25, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 26, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 27, value.factor)
      encodeSerializableIfNotNull(descriptor, 28, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 29, MoneySerializer, value.net)
      if (value.bodySite.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          30,
          ExplanationOfBenefitAddItemBodySiteSerializer.listSerializer,
          value.bodySite,
        )
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          31,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 32, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        33,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          34,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          35,
          ExplanationOfBenefitAddItemDetailSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object ExplanationOfBenefitAddItemBodySiteSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("site", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.BodySite>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.BodySite =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var site: List<CodeableReference>? = null
      var subSite: List<CodeableConcept>? = null
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
            site =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            subSite =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding BodySite: " + i)
        }
      }
      ExplanationOfBenefit.AddItem.BodySite(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        site = site ?: listOf(),
        subSite = subSite ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.BodySite) {
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
      if (value.site.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          CodeableReferenceSerializer.listSerializer,
          value.site,
        )
      if (value.subSite.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.subSite,
        )
    }
  }
}

internal object ExplanationOfBenefitAddItemDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor },
      )
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var traceNumber: List<Identifier>? = null
      var revenue: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var modifier: List<CodeableConcept>? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
      var subDetail: List<ExplanationOfBenefit.AddItem.Detail.SubDetail>? = null
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
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          9 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          11 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          12 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          14 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          15 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          16 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          17 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          18 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          19 ->
            subDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      ExplanationOfBenefit.AddItem.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        traceNumber = traceNumber ?: listOf(),
        revenue = revenue,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        modifier = modifier ?: listOf(),
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
        subDetail = subDetail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail) {
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
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        6,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 9, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 10, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 11, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 12, value.factor)
      encodeSerializableIfNotNull(descriptor, 13, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.net)
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          15,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 16, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        17,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
      if (value.subDetail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          ExplanationOfBenefitAddItemDetailSubDetailSerializer.listSerializer,
          value.subDetail,
        )
    }
  }
}

internal object ExplanationOfBenefitAddItemDetailSubDetailSerializer :
  KSerializer<ExplanationOfBenefit.AddItem.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("revenue", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("patientPaid", MoneySerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("tax", MoneySerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("noteNumber", intNullableListSerializer.descriptor)
      optionalElement("_noteNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement(
        "reviewOutcome",
        lazyDescriptor { ExplanationOfBenefitItemReviewOutcomeSerializer.descriptor },
      )
      optionalElement(
        "adjudication",
        listSerialDescriptor(
          lazyDescriptor { ExplanationOfBenefitItemAdjudicationSerializer.descriptor }
        ),
      )
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.AddItem.Detail.SubDetail>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.AddItem.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var traceNumber: List<Identifier>? = null
      var revenue: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var productOrServiceEnd: CodeableConcept? = null
      var modifier: List<CodeableConcept>? = null
      var patientPaid: Money? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var tax: Money? = null
      var net: Money? = null
      var noteNumber: List<Int?>? = null
      var _noteNumber: List<Element?>? = null
      var reviewOutcome: ExplanationOfBenefit.Item.ReviewOutcome? = null
      var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null
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
            traceNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            revenue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            productOrServiceEnd =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 -> patientPaid = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          9 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          11 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          12 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> tax = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          14 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          15 ->
            noteNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          16 ->
            _noteNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          17 ->
            reviewOutcome =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemReviewOutcomeSerializer,
                null,
              )
          18 ->
            adjudication =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
        }
      }
      ExplanationOfBenefit.AddItem.Detail.SubDetail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        traceNumber = traceNumber ?: listOf(),
        revenue = revenue,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        modifier = modifier ?: listOf(),
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        noteNumber =
          (kotlin.collections.List(maxOf(noteNumber?.size ?: 0, _noteNumber?.size ?: 0)) { index ->
            PositiveInt.of(noteNumber?.getOrNull(index), _noteNumber?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'noteNumber' on ExplanationOfBenefit.AddItem.Detail.SubDetail has neither a value nor an id/extension"
              )
          }),
        reviewOutcome = reviewOutcome,
        adjudication = adjudication ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.AddItem.Detail.SubDetail) {
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
      if (value.traceNumber.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.traceNumber,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.revenue)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.productOrService)
      encodeSerializableIfNotNull(
        descriptor,
        6,
        CodeableConceptSerializer,
        value.productOrServiceEnd,
      )
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.patientPaid)
      encodeSerializableIfNotNull(descriptor, 9, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 10, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 11, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 12, value.factor)
      encodeSerializableIfNotNull(descriptor, 13, MoneySerializer, value.tax)
      encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.net)
      if (value.noteNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          15,
          intNullableListSerializer,
          value.noteNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 16, value.noteNumber)
      }
      encodeSerializableIfNotNull(
        descriptor,
        17,
        ExplanationOfBenefitItemReviewOutcomeSerializer,
        value.reviewOutcome,
      )
      if (value.adjudication.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
          value.adjudication,
        )
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Total =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var amount: Money? = null
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Total: " + i)
        }
      }
      ExplanationOfBenefit.Total(
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableElement(descriptor, 4, MoneySerializer, value.amount)
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.Payment =
    decoder.decodeStructure(descriptor) {
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> adjustment = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          5 ->
            adjustmentReason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> date = decodeStringElement(descriptor, i)
          7 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          9 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Payment: " + i)
        }
      }
      ExplanationOfBenefit.Payment(
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, MoneySerializer, value.adjustment)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.adjustmentReason)
      encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.date)
      encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.amount)
      encodeSerializableIfNotNull(descriptor, 9, IdentifierSerializer, value.identifier)
    }
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
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("language", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ExplanationOfBenefit.ProcessNote>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.ProcessNote =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var number: Int? = null
      var _number: Element? = null
      var type: CodeableConcept? = null
      var text: KotlinString? = null
      var _text: Element? = null
      var language: CodeableConcept? = null
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
          3 -> number = decodeIntElement(descriptor, i)
          4 -> _number = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 -> text = decodeStringElement(descriptor, i)
          7 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            language =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
        }
      }
      ExplanationOfBenefit.ProcessNote(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        number = PositiveInt.of(number, _number),
        type = type,
        text = R5String.of(text, _text),
        language = language,
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.ProcessNote) {
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
      encodeIntIfNotNull(descriptor, 3, value.number?.value)
      encodeElementIfNotNull(descriptor, 4, value.number)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      encodeStringIfNotNull(descriptor, 6, value.text?.value)
      encodeElementIfNotNull(descriptor, 7, value.text)
      encodeSerializableIfNotNull(descriptor, 8, CodeableConceptSerializer, value.language)
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance =
    decoder.decodeStructure(descriptor) {
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> excluded = decodeBooleanElement(descriptor, i)
          5 -> _excluded = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> name = decodeStringElement(descriptor, i)
          7 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> description = decodeStringElement(descriptor, i)
          9 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            network =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 ->
            unit = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          12 ->
            term = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          13 ->
            financial =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding BenefitBalance: " + i)
        }
      }
      ExplanationOfBenefit.BenefitBalance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category =
          category
            ?: throw SerializationException(
              "Missing required property 'category' on ExplanationOfBenefit.BenefitBalance"
            ),
        excluded = R5Boolean.of(excluded, _excluded),
        name = R5String.of(name, _name),
        description = R5String.of(description, _description),
        network = network,
        unit = unit,
        term = term,
        financial = financial ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ExplanationOfBenefit.BenefitBalance) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeBooleanIfNotNull(descriptor, 4, value.excluded?.value)
      encodeElementIfNotNull(descriptor, 5, value.excluded)
      encodeStringIfNotNull(descriptor, 6, value.name?.value)
      encodeElementIfNotNull(descriptor, 7, value.name)
      encodeStringIfNotNull(descriptor, 8, value.description?.value)
      encodeElementIfNotNull(descriptor, 9, value.description)
      encodeSerializableIfNotNull(descriptor, 10, CodeableConceptSerializer, value.network)
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.unit)
      encodeSerializableIfNotNull(descriptor, 12, CodeableConceptSerializer, value.term)
      if (value.financial.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ExplanationOfBenefitBenefitBalanceFinancialSerializer.listSerializer,
          value.financial,
        )
    }
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

  override fun deserialize(decoder: Decoder): ExplanationOfBenefit.BenefitBalance.Financial =
    decoder.decodeStructure(descriptor) {
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> allowedUnsignedInt = decodeIntElement(descriptor, i)
          5 ->
            _allowedUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> allowedString = decodeStringElement(descriptor, i)
          7 ->
            _allowedString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            allowedMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          9 -> usedUnsignedInt = decodeIntElement(descriptor, i)
          10 ->
            _usedUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> usedMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Financial: " + i)
        }
      }
      ExplanationOfBenefit.BenefitBalance.Financial(
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
            R5String.of(allowedString, _allowedString),
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.allowed) {
        null -> {}
        is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is ExplanationOfBenefit.BenefitBalance.Financial.Allowed.Money -> {
          encodeSerializableElement(descriptor, 8, MoneySerializer, choice.value)
        }
      }
      when (val choice = value.used) {
        null -> {}
        is ExplanationOfBenefit.BenefitBalance.Financial.Used.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is ExplanationOfBenefit.BenefitBalance.Financial.Used.Money -> {
          encodeSerializableElement(descriptor, 11, MoneySerializer, choice.value)
        }
      }
    }
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
    b.optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
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
    b.optionalElement("event", ExplanationOfBenefitEventSerializer.listSerializer.descriptor)
    b.optionalElement("payee", ExplanationOfBenefitPayeeSerializer.descriptor)
    b.optionalElement("referral", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("facility", ReferenceSerializer.descriptor)
    b.optionalElement("claim", ReferenceSerializer.descriptor)
    b.optionalElement("claimResponse", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("decision", CodeableConceptSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
    b.optionalElement("preAuthRef", stringNullableListSerializer.descriptor)
    b.optionalElement("_preAuthRef", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("preAuthRefPeriod", PeriodSerializer.listSerializer.descriptor)
    b.optionalElement("diagnosisRelatedGroup", CodeableConceptSerializer.descriptor)
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
    b.optionalElement("patientPaid", MoneySerializer.descriptor)
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
    decoder: CompositeDecoder,
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
    var traceNumber: List<Identifier>? = null
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
    var event: List<ExplanationOfBenefit.Event>? = null
    var payee: ExplanationOfBenefit.Payee? = null
    var referral: Reference? = null
    var encounter: List<Reference>? = null
    var facility: Reference? = null
    var claim: Reference? = null
    var claimResponse: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var decision: CodeableConcept? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var preAuthRef: List<KotlinString?>? = null
    var _preAuthRef: List<Element?>? = null
    var preAuthRefPeriod: List<Period>? = null
    var diagnosisRelatedGroup: CodeableConcept? = null
    var careTeam: List<ExplanationOfBenefit.CareTeam>? = null
    var supportingInfo: List<ExplanationOfBenefit.SupportingInfo>? = null
    var diagnosis: List<ExplanationOfBenefit.Diagnosis>? = null
    var procedure: List<ExplanationOfBenefit.Procedure>? = null
    var precedence: Int? = null
    var _precedence: Element? = null
    var insurance: List<ExplanationOfBenefit.Insurance>? = null
    var accident: ExplanationOfBenefit.Accident? = null
    var patientPaid: Money? = null
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
          traceNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> use = decoder.decodeStringElement(descriptor, i)
        17 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        20 -> created = decoder.decodeStringElement(descriptor, i)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          fundsReserveRequested =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          related =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitRelatedSerializer.listSerializer,
              null,
            )
        29 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitEventSerializer.listSerializer,
              null,
            )
        32 ->
          payee =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPayeeSerializer,
              null,
            )
        33 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        36 ->
          claim =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        37 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        38 -> outcome = decoder.decodeStringElement(descriptor, i)
        39 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 ->
          decision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        41 -> disposition = decoder.decodeStringElement(descriptor, i)
        42 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        44 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        45 ->
          preAuthRefPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        46 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        47 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitCareTeamSerializer.listSerializer,
              null,
            )
        48 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
              null,
            )
        49 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitDiagnosisSerializer.listSerializer,
              null,
            )
        50 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcedureSerializer.listSerializer,
              null,
            )
        51 -> precedence = decoder.decodeIntElement(descriptor, i)
        52 ->
          _precedence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        53 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitInsuranceSerializer.listSerializer,
              null,
            )
        54 ->
          accident =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAccidentSerializer,
              null,
            )
        55 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        56 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemSerializer.listSerializer,
              null,
            )
        57 ->
          addItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitAddItemSerializer.listSerializer,
              null,
            )
        58 ->
          adjudication =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
              null,
            )
        59 ->
          total =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitTotalSerializer.listSerializer,
              null,
            )
        60 ->
          payment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitPaymentSerializer,
              null,
            )
        61 ->
          formCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        62 ->
          form =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        63 ->
          processNote =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExplanationOfBenefitProcessNoteSerializer.listSerializer,
              null,
            )
        64 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        65 ->
          benefitBalance =
            decoder.decodeNullableSerializableElement(
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
      traceNumber = traceNumber ?: listOf(),
      status =
        Enumeration.of(
          if (status != null) ExplanationOfBenefit.ExplanationOfBenefitStatus.fromCode(status)
          else null,
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
        Enumeration.of(if (use != null) ExplanationOfBenefit.Use.fromCode(use) else null, _use)
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
      insurer = insurer,
      provider = provider,
      priority = priority,
      fundsReserveRequested = fundsReserveRequested,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      event = event ?: listOf(),
      payee = payee,
      referral = referral,
      encounter = encounter ?: listOf(),
      facility = facility,
      claim = claim,
      claimResponse = claimResponse,
      outcome =
        Enumeration.of(
          if (outcome != null) ExplanationOfBenefit.ClaimProcessingCodes.fromCode(outcome)
          else null,
          _outcome,
        )
          ?: throw SerializationException(
            "Missing required property 'outcome' on ExplanationOfBenefit"
          ),
      decision = decision,
      disposition = R5String.of(disposition, _disposition),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R5String.of(preAuthRef?.getOrNull(index), _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on ExplanationOfBenefit has neither a value nor an id/extension"
            )
        }),
      preAuthRefPeriod = preAuthRefPeriod ?: listOf(),
      diagnosisRelatedGroup = diagnosisRelatedGroup,
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      precedence = PositiveInt.of(precedence, _precedence),
      insurance = insurance ?: listOf(),
      accident = accident,
      patientPaid = patientPaid,
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ExplanationOfBenefit,
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
    if (value.traceNumber.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.traceNumber,
      )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.subType,
    )
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.use.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.use)
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      PeriodSerializer,
      value.billablePeriod,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.provider,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserveRequested,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserve,
    )
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ExplanationOfBenefitRelatedSerializer.listSerializer,
        value.related,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.prescription,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ReferenceSerializer,
      value.originalPrescription,
    )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ExplanationOfBenefitEventSerializer.listSerializer,
        value.event,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      ExplanationOfBenefitPayeeSerializer,
      value.payee,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.referral,
    )
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      ReferenceSerializer,
      value.facility,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      36 + descriptorOffset,
      ReferenceSerializer,
      value.claim,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      37 + descriptorOffset,
      ReferenceSerializer,
      value.claimResponse,
    )
    encoder.encodeStringIfNotNull(descriptor, 38 + descriptorOffset, value.outcome.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.outcome)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      40 + descriptorOffset,
      CodeableConceptSerializer,
      value.decision,
    )
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.disposition?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.disposition)
    if (value.preAuthRef.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        43 + descriptorOffset,
        stringNullableListSerializer,
        value.preAuthRef.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 44 + descriptorOffset, value.preAuthRef)
    }
    if (value.preAuthRefPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        PeriodSerializer.listSerializer,
        value.preAuthRefPeriod,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      CodeableConceptSerializer,
      value.diagnosisRelatedGroup,
    )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ExplanationOfBenefitCareTeamSerializer.listSerializer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ExplanationOfBenefitSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ExplanationOfBenefitDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ExplanationOfBenefitProcedureSerializer.listSerializer,
        value.procedure,
      )
    encoder.encodeIntIfNotNull(descriptor, 51 + descriptorOffset, value.precedence?.value)
    encoder.encodeElementIfNotNull(descriptor, 52 + descriptorOffset, value.precedence)
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        53 + descriptorOffset,
        ExplanationOfBenefitInsuranceSerializer.listSerializer,
        value.insurance,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      54 + descriptorOffset,
      ExplanationOfBenefitAccidentSerializer,
      value.accident,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      55 + descriptorOffset,
      MoneySerializer,
      value.patientPaid,
    )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        56 + descriptorOffset,
        ExplanationOfBenefitItemSerializer.listSerializer,
        value.item,
      )
    if (value.addItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        57 + descriptorOffset,
        ExplanationOfBenefitAddItemSerializer.listSerializer,
        value.addItem,
      )
    if (value.adjudication.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        58 + descriptorOffset,
        ExplanationOfBenefitItemAdjudicationSerializer.listSerializer,
        value.adjudication,
      )
    if (value.total.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        59 + descriptorOffset,
        ExplanationOfBenefitTotalSerializer.listSerializer,
        value.total,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      60 + descriptorOffset,
      ExplanationOfBenefitPaymentSerializer,
      value.payment,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      61 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      62 + descriptorOffset,
      AttachmentSerializer,
      value.form,
    )
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        63 + descriptorOffset,
        ExplanationOfBenefitProcessNoteSerializer.listSerializer,
        value.processNote,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      64 + descriptorOffset,
      PeriodSerializer,
      value.benefitPeriod,
    )
    if (value.benefitBalance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        65 + descriptorOffset,
        ExplanationOfBenefitBenefitBalanceSerializer.listSerializer,
        value.benefitBalance,
      )
  }
}
