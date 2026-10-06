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
import dev.ohs.fhir.model.r5.Claim
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
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

internal object ClaimRelatedSerializer : KSerializer<Claim.Related> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Related") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("claim", ReferenceSerializer.descriptor)
      optionalElement("relationship", CodeableConceptSerializer.descriptor)
      optionalElement("reference", IdentifierSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Related>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Related =
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
      Claim.Related(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        claim = claim,
        relationship = relationship,
        reference = reference,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Related) {
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

internal object ClaimPayeeSerializer : KSerializer<Claim.Payee> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payee") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Payee>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Payee =
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
      Claim.Payee(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type ?: throw SerializationException("Missing required property 'type' on Claim.Payee"),
        party = party,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Payee) {
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
      encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.party)
    }
  }
}

internal object ClaimEventSerializer : KSerializer<Claim.Event> {
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

  internal val listSerializer: KSerializer<List<Claim.Event>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Event =
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
      Claim.Event(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type ?: throw SerializationException("Missing required property 'type' on Claim.Event"),
        `when` =
          Claim.Event.When.from(
            DateTime.of(
              if (whenDateTime != null) FhirDateTime.fromString(whenDateTime) else null,
              _whenDateTime,
            ),
            whenPeriod,
          ) ?: throw SerializationException("Missing required property 'when' on Claim.Event"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Event) {
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
        is Claim.Event.When.DateTime -> {
          encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is Claim.Event.When.Period -> {
          encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
        }
      }
    }
  }
}

internal object ClaimCareTeamSerializer : KSerializer<Claim.CareTeam> {
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

  internal val listSerializer: KSerializer<List<Claim.CareTeam>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.CareTeam =
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
      Claim.CareTeam(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.CareTeam"
            ),
        provider =
          provider
            ?: throw SerializationException(
              "Missing required property 'provider' on Claim.CareTeam"
            ),
        responsible = R5Boolean.of(responsible, _responsible),
        role = role,
        specialty = specialty,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.CareTeam) {
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

internal object ClaimSupportingInfoSerializer : KSerializer<Claim.SupportingInfo> {
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
      optionalElement("reason", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.SupportingInfo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo =
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
      var reason: CodeableConcept? = null
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
          18 ->
            reason =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
        }
      }
      Claim.SupportingInfo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.SupportingInfo"
            ),
        category =
          category
            ?: throw SerializationException(
              "Missing required property 'category' on Claim.SupportingInfo"
            ),
        code = code,
        timing =
          Claim.SupportingInfo.Timing.from(
            Date.of(if (timingDate != null) FhirDate.fromString(timingDate) else null, _timingDate),
            timingPeriod,
          ),
        `value` =
          Claim.SupportingInfo.Value.from(
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

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo) {
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
        is Claim.SupportingInfo.Timing.Date -> {
          encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Claim.SupportingInfo.Timing.Period -> {
          encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.`value`) {
        null -> {}
        is Claim.SupportingInfo.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
          encodeElementIfNotNull(descriptor, 11, choice.value)
        }
        is Claim.SupportingInfo.Value.String -> {
          encodeStringIfNotNull(descriptor, 12, choice.value.value)
          encodeElementIfNotNull(descriptor, 13, choice.value)
        }
        is Claim.SupportingInfo.Value.Quantity -> {
          encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
        }
        is Claim.SupportingInfo.Value.Attachment -> {
          encodeSerializableElement(descriptor, 15, AttachmentSerializer, choice.value)
        }
        is Claim.SupportingInfo.Value.Reference -> {
          encodeSerializableElement(descriptor, 16, ReferenceSerializer, choice.value)
        }
        is Claim.SupportingInfo.Value.Identifier -> {
          encodeSerializableElement(descriptor, 17, IdentifierSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 18, CodeableConceptSerializer, value.reason)
    }
  }
}

internal object ClaimDiagnosisSerializer : KSerializer<Claim.Diagnosis> {
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

  internal val listSerializer: KSerializer<List<Claim.Diagnosis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Diagnosis =
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
      Claim.Diagnosis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.Diagnosis"
            ),
        diagnosis =
          Claim.Diagnosis.Diagnosis.from(diagnosisCodeableConcept, diagnosisReference)
            ?: throw SerializationException(
              "Missing required property 'diagnosis' on Claim.Diagnosis"
            ),
        type = type ?: listOf(),
        onAdmission = onAdmission,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis) {
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
        is Claim.Diagnosis.Diagnosis.CodeableConcept -> {
          encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
        }
        is Claim.Diagnosis.Diagnosis.Reference -> {
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

internal object ClaimProcedureSerializer : KSerializer<Claim.Procedure> {
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

  internal val listSerializer: KSerializer<List<Claim.Procedure>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Procedure =
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
      Claim.Procedure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.Procedure"
            ),
        type = type ?: listOf(),
        date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
        procedure =
          Claim.Procedure.Procedure.from(procedureCodeableConcept, procedureReference)
            ?: throw SerializationException(
              "Missing required property 'procedure' on Claim.Procedure"
            ),
        udi = udi ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure) {
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
        is Claim.Procedure.Procedure.CodeableConcept -> {
          encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
        }
        is Claim.Procedure.Procedure.Reference -> {
          encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
        }
      }
      if (value.udi.isNotEmpty())
        encodeSerializableElement(descriptor, 10, ReferenceSerializer.listSerializer, value.udi)
    }
  }
}

internal object ClaimInsuranceSerializer : KSerializer<Claim.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("focal", KotlinBoolean.serializer().descriptor)
      optionalElement("_focal", ElementSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("businessArrangement", KotlinString.serializer().descriptor)
      optionalElement("_businessArrangement", ElementSerializer.descriptor)
      optionalElement("preAuthRef", stringNullableListSerializer.descriptor)
      optionalElement("_preAuthRef", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("claimResponse", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Insurance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Insurance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var focal: KotlinBoolean? = null
      var _focal: Element? = null
      var identifier: Identifier? = null
      var coverage: Reference? = null
      var businessArrangement: KotlinString? = null
      var _businessArrangement: Element? = null
      var preAuthRef: List<KotlinString?>? = null
      var _preAuthRef: List<Element?>? = null
      var claimResponse: Reference? = null
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
          5 -> focal = decodeBooleanElement(descriptor, i)
          6 -> _focal = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          8 ->
            coverage = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 -> businessArrangement = decodeStringElement(descriptor, i)
          10 ->
            _businessArrangement =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            preAuthRef =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          12 ->
            _preAuthRef =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          13 ->
            claimResponse =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
        }
      }
      Claim.Insurance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.Insurance"
            ),
        focal =
          R5Boolean.of(focal, _focal)
            ?: throw SerializationException("Missing required property 'focal' on Claim.Insurance"),
        identifier = identifier,
        coverage =
          coverage
            ?: throw SerializationException(
              "Missing required property 'coverage' on Claim.Insurance"
            ),
        businessArrangement = R5String.of(businessArrangement, _businessArrangement),
        preAuthRef =
          (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
            R5String.of(preAuthRef?.getOrNull(index), _preAuthRef?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'preAuthRef' on Claim.Insurance has neither a value nor an id/extension"
              )
          }),
        claimResponse = claimResponse,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Insurance) {
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
      encodeBooleanIfNotNull(descriptor, 5, value.focal.value)
      encodeElementIfNotNull(descriptor, 6, value.focal)
      encodeSerializableIfNotNull(descriptor, 7, IdentifierSerializer, value.identifier)
      encodeSerializableElement(descriptor, 8, ReferenceSerializer, value.coverage)
      encodeStringIfNotNull(descriptor, 9, value.businessArrangement?.value)
      encodeElementIfNotNull(descriptor, 10, value.businessArrangement)
      if (value.preAuthRef.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          11,
          stringNullableListSerializer,
          value.preAuthRef.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 12, value.preAuthRef)
      }
      encodeSerializableIfNotNull(descriptor, 13, ReferenceSerializer, value.claimResponse)
    }
  }
}

internal object ClaimAccidentSerializer : KSerializer<Claim.Accident> {
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

  internal val listSerializer: KSerializer<List<Claim.Accident>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Accident =
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
      Claim.Accident(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        date =
          Date.of(if (date != null) FhirDate.fromString(date) else null, _date)
            ?: throw SerializationException("Missing required property 'date' on Claim.Accident"),
        type = type,
        location = Claim.Accident.Location.from(locationAddress, locationReference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Accident) {
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
      encodeStringIfNotNull(descriptor, 3, value.date.value?.toString())
      encodeElementIfNotNull(descriptor, 4, value.date)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.type)
      when (val choice = value.location) {
        null -> {}
        is Claim.Accident.Location.Address -> {
          encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
        }
        is Claim.Accident.Location.Reference -> {
          encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ClaimItemSerializer : KSerializer<Claim.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
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
      optionalElement("bodySite", ClaimItemBodySiteSerializer.listSerializer.descriptor)
      optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("detail", ClaimItemDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var traceNumber: List<Identifier>? = null
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
      var bodySite: List<Claim.Item.BodySite>? = null
      var encounter: List<Reference>? = null
      var detail: List<Claim.Item.Detail>? = null
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
            careTeamSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          7 ->
            _careTeamSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          8 ->
            diagnosisSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          9 ->
            _diagnosisSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 ->
            procedureSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          11 ->
            _procedureSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          12 ->
            informationSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          13 ->
            _informationSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
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
                ClaimItemBodySiteSerializer.listSerializer,
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
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ClaimItemDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      Claim.Item(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException("Missing required property 'sequence' on Claim.Item"),
        traceNumber = traceNumber ?: listOf(),
        careTeamSequence =
          (kotlin.collections.List(
            maxOf(careTeamSequence?.size ?: 0, _careTeamSequence?.size ?: 0)
          ) { index ->
            PositiveInt.of(careTeamSequence?.getOrNull(index), _careTeamSequence?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'careTeamSequence' on Claim.Item has neither a value nor an id/extension"
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
                "An entry of 'diagnosisSequence' on Claim.Item has neither a value nor an id/extension"
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
                "An entry of 'procedureSequence' on Claim.Item has neither a value nor an id/extension"
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
                "An entry of 'informationSequence' on Claim.Item has neither a value nor an id/extension"
              )
          }),
        revenue = revenue,
        category = category,
        productOrService = productOrService,
        productOrServiceEnd = productOrServiceEnd,
        request = request ?: listOf(),
        modifier = modifier ?: listOf(),
        programCode = programCode ?: listOf(),
        serviced =
          Claim.Item.Serviced.from(
            Date.of(
              if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
              _servicedDate,
            ),
            servicedPeriod,
          ),
        location =
          Claim.Item.Location.from(locationCodeableConcept, locationAddress, locationReference),
        patientPaid = patientPaid,
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        tax = tax,
        net = net,
        udi = udi ?: listOf(),
        bodySite = bodySite ?: listOf(),
        encounter = encounter ?: listOf(),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item) {
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
      if (value.careTeamSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          6,
          intNullableListSerializer,
          value.careTeamSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 7, value.careTeamSequence)
      }
      if (value.diagnosisSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          intNullableListSerializer,
          value.diagnosisSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 9, value.diagnosisSequence)
      }
      if (value.procedureSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          10,
          intNullableListSerializer,
          value.procedureSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 11, value.procedureSequence)
      }
      if (value.informationSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          intNullableListSerializer,
          value.informationSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.informationSequence)
      }
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
        is Claim.Item.Serviced.Date -> {
          encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 22, choice.value)
        }
        is Claim.Item.Serviced.Period -> {
          encodeSerializableElement(descriptor, 23, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.location) {
        null -> {}
        is Claim.Item.Location.CodeableConcept -> {
          encodeSerializableElement(descriptor, 24, CodeableConceptSerializer, choice.value)
        }
        is Claim.Item.Location.Address -> {
          encodeSerializableElement(descriptor, 25, AddressSerializer, choice.value)
        }
        is Claim.Item.Location.Reference -> {
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
          ClaimItemBodySiteSerializer.listSerializer,
          value.bodySite,
        )
      if (value.encounter.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          36,
          ReferenceSerializer.listSerializer,
          value.encounter,
        )
      if (value.detail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          37,
          ClaimItemDetailSerializer.listSerializer,
          value.detail,
        )
    }
  }
}

internal object ClaimItemBodySiteSerializer : KSerializer<Claim.Item.BodySite> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("BodySite") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("site", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Item.BodySite>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item.BodySite =
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
      Claim.Item.BodySite(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        site = site ?: listOf(),
        subSite = subSite ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.BodySite) {
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

internal object ClaimItemDetailSerializer : KSerializer<Claim.Item.Detail> {
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
      optionalElement("subDetail", ClaimItemDetailSubDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Claim.Item.Detail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item.Detail =
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
      var subDetail: List<Claim.Item.Detail.SubDetail>? = null
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
            subDetail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ClaimItemDetailSubDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Detail: " + i)
        }
      }
      Claim.Item.Detail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.Item.Detail"
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
        subDetail = subDetail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail) {
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
      if (value.subDetail.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          20,
          ClaimItemDetailSubDetailSerializer.listSerializer,
          value.subDetail,
        )
    }
  }
}

internal object ClaimItemDetailSubDetailSerializer : KSerializer<Claim.Item.Detail.SubDetail> {
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
    }

  internal val listSerializer: KSerializer<List<Claim.Item.Detail.SubDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item.Detail.SubDetail =
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
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
        }
      }
      Claim.Item.Detail.SubDetail(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on Claim.Item.Detail.SubDetail"
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
      )
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail.SubDetail) {
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
    }
  }
}

internal object ClaimSerializer : FhirResourceSerializer<Claim> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Claim")

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
    b.optionalElement("fundsReserve", CodeableConceptSerializer.descriptor)
    b.optionalElement("related", ClaimRelatedSerializer.listSerializer.descriptor)
    b.optionalElement("prescription", ReferenceSerializer.descriptor)
    b.optionalElement("originalPrescription", ReferenceSerializer.descriptor)
    b.optionalElement("payee", ClaimPayeeSerializer.descriptor)
    b.optionalElement("referral", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("facility", ReferenceSerializer.descriptor)
    b.optionalElement("diagnosisRelatedGroup", CodeableConceptSerializer.descriptor)
    b.optionalElement("event", ClaimEventSerializer.listSerializer.descriptor)
    b.optionalElement("careTeam", ClaimCareTeamSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", ClaimSupportingInfoSerializer.listSerializer.descriptor)
    b.optionalElement("diagnosis", ClaimDiagnosisSerializer.listSerializer.descriptor)
    b.optionalElement("procedure", ClaimProcedureSerializer.listSerializer.descriptor)
    b.optionalElement("insurance", ClaimInsuranceSerializer.listSerializer.descriptor)
    b.optionalElement("accident", ClaimAccidentSerializer.descriptor)
    b.optionalElement("patientPaid", MoneySerializer.descriptor)
    b.optionalElement("item", ClaimItemSerializer.listSerializer.descriptor)
    b.optionalElement("total", MoneySerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Claim {
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
    var fundsReserve: CodeableConcept? = null
    var related: List<Claim.Related>? = null
    var prescription: Reference? = null
    var originalPrescription: Reference? = null
    var payee: Claim.Payee? = null
    var referral: Reference? = null
    var encounter: List<Reference>? = null
    var facility: Reference? = null
    var diagnosisRelatedGroup: CodeableConcept? = null
    var event: List<Claim.Event>? = null
    var careTeam: List<Claim.CareTeam>? = null
    var supportingInfo: List<Claim.SupportingInfo>? = null
    var diagnosis: List<Claim.Diagnosis>? = null
    var procedure: List<Claim.Procedure>? = null
    var insurance: List<Claim.Insurance>? = null
    var accident: Claim.Accident? = null
    var patientPaid: Money? = null
    var item: List<Claim.Item>? = null
    var total: Money? = null
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
          fundsReserve =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        27 ->
          related =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimRelatedSerializer.listSerializer,
              null,
            )
        28 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          payee =
            decoder.decodeNullableSerializableElement(descriptor, i, ClaimPayeeSerializer, null)
        31 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        34 ->
          diagnosisRelatedGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        35 ->
          event =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimEventSerializer.listSerializer,
              null,
            )
        36 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimCareTeamSerializer.listSerializer,
              null,
            )
        37 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimSupportingInfoSerializer.listSerializer,
              null,
            )
        38 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimDiagnosisSerializer.listSerializer,
              null,
            )
        39 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimProcedureSerializer.listSerializer,
              null,
            )
        40 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimInsuranceSerializer.listSerializer,
              null,
            )
        41 ->
          accident =
            decoder.decodeNullableSerializableElement(descriptor, i, ClaimAccidentSerializer, null)
        42 ->
          patientPaid =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        43 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemSerializer.listSerializer,
              null,
            )
        44 ->
          total = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        else -> throw SerializationException("Unexpected index decoding Claim: " + i)
      }
    }
    return Claim(
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
          if (status != null) Claim.FinancialResourceStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Claim"),
      type = type ?: throw SerializationException("Missing required property 'type' on Claim"),
      subType = subType,
      use =
        Enumeration.of(if (use != null) Claim.Use.fromCode(use) else null, _use)
          ?: throw SerializationException("Missing required property 'use' on Claim"),
      patient =
        patient ?: throw SerializationException("Missing required property 'patient' on Claim"),
      billablePeriod = billablePeriod,
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException("Missing required property 'created' on Claim"),
      enterer = enterer,
      insurer = insurer,
      provider = provider,
      priority = priority,
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      encounter = encounter ?: listOf(),
      facility = facility,
      diagnosisRelatedGroup = diagnosisRelatedGroup,
      event = event ?: listOf(),
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      insurance = insurance ?: listOf(),
      accident = accident,
      patientPaid = patientPaid,
      item = item ?: listOf(),
      total = total,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Claim,
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
      value.fundsReserve,
    )
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ClaimRelatedSerializer.listSerializer,
        value.related,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.prescription,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.originalPrescription,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      ClaimPayeeSerializer,
      value.payee,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.referral,
    )
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.facility,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer,
      value.diagnosisRelatedGroup,
    )
    if (value.event.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ClaimEventSerializer.listSerializer,
        value.event,
      )
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ClaimCareTeamSerializer.listSerializer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ClaimSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ClaimDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        ClaimProcedureSerializer.listSerializer,
        value.procedure,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        ClaimInsuranceSerializer.listSerializer,
        value.insurance,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      ClaimAccidentSerializer,
      value.accident,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      MoneySerializer,
      value.patientPaid,
    )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        ClaimItemSerializer.listSerializer,
        value.item,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      MoneySerializer,
      value.total,
    )
  }
}
