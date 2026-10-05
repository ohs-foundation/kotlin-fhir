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
import dev.ohs.fhir.model.r4.Claim
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
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

internal object ClaimRelatedSerializer : KSerializer<Claim.Related> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Related") {
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
      element("claim", Reference.serializer().descriptor, isOptional = true)
      element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
      element("reference", Identifier.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Related>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Related =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Related) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Related {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var claim: Reference? = null
    var relationship: CodeableConcept? = null
    var reference: Identifier? = null
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
          claim =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Related: " + i)
      }
    }
    return Claim.Related(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      claim = claim,
      relationship = relationship,
      reference = reference,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Related) {
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
    (value.claim)?.let { encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, it) }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 5, IdentifierSerializer, it)
    }
  }
}

internal object ClaimPayeeSerializer : KSerializer<Claim.Payee> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Payee") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Payee>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Payee =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Payee) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Payee {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var party: Reference? = null
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
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          party =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Payee: " + i)
      }
    }
    return Claim.Payee(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Claim.Payee"),
      party = party,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Payee) {
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
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    (value.party)?.let { encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, it) }
  }
}

internal object ClaimCareTeamSerializer : KSerializer<Claim.CareTeam> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CareTeam") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("provider", Reference.serializer().descriptor, isOptional = true)
      element("responsible", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_responsible", Element.serializer().descriptor, isOptional = true)
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("qualification", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.CareTeam>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.CareTeam =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.CareTeam) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.CareTeam {
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 -> responsible = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          qualification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CareTeam: " + i)
      }
    }
    return Claim.CareTeam(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException("Missing required property 'sequence' on Claim.CareTeam"),
      provider =
        provider
          ?: throw SerializationException("Missing required property 'provider' on Claim.CareTeam"),
      responsible = R4Boolean.of(responsible, _responsible),
      role = role,
      qualification = qualification,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.CareTeam) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.provider)
    ((value.responsible?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.responsible?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.role)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
    (value.qualification)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
  }
}

internal object ClaimSupportingInfoSerializer : KSerializer<Claim.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("timingDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_timingDate", Element.serializer().descriptor, isOptional = true)
      element("timingPeriod", Period.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("reason", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.SupportingInfo>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.SupportingInfo) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.SupportingInfo {
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
    var reason: CodeableConcept? = null
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 -> timingDate = decoder.decodeStringElement(descriptor, i)
        8 ->
          _timingDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          timingPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        10 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        11 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 -> valueString = decoder.decodeStringElement(descriptor, i)
        13 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        15 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        16 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
      }
    }
    return Claim.SupportingInfo(
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
          Date.of(timingDate?.let { FhirDate.fromString(it) }, _timingDate),
          timingPeriod,
        ),
      `value` =
        Claim.SupportingInfo.Value.from(
          R4Boolean.of(valueBoolean, _valueBoolean),
          R4String.of(valueString, _valueString),
          valueQuantity,
          valueAttachment,
          valueReference,
        ),
      reason = reason,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.SupportingInfo) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.category)
    (value.code)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    when (val choice = value.timing) {
      null -> {}
      is Claim.SupportingInfo.Timing.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is Claim.SupportingInfo.Timing.Period -> {
        encoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is Claim.SupportingInfo.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 10, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
        }
      }
      is Claim.SupportingInfo.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 12, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
        }
      }
      is Claim.SupportingInfo.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
      }
      is Claim.SupportingInfo.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 15, AttachmentSerializer, choice.value)
      }
      is Claim.SupportingInfo.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 16, ReferenceSerializer, choice.value)
      }
    }
    (value.reason)?.let {
      encoder.encodeSerializableElement(descriptor, 17, CodeableConceptSerializer, it)
    }
  }
}

internal object ClaimDiagnosisSerializer : KSerializer<Claim.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element(
        "diagnosisCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("diagnosisReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("onAdmission", CodeableConcept.serializer().descriptor, isOptional = true)
      element("packageCode", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Diagnosis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Diagnosis =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Diagnosis {
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        7 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        8 ->
          onAdmission =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          packageCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    return Claim.Diagnosis(
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
      packageCode = packageCode,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Diagnosis) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    when (val choice = value.diagnosis) {
      is Claim.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, choice.value)
      }
      is Claim.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    (value.onAdmission)?.let {
      encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, it)
    }
    (value.packageCode)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
  }
}

internal object ClaimProcedureSerializer : KSerializer<Claim.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element(
        "procedureCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("procedureReference", Reference.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Procedure>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Procedure =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Procedure {
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 -> date = decoder.decodeStringElement(descriptor, i)
        7 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          procedureCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          procedureReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        10 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Procedure: " + i)
      }
    }
    return Claim.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Procedure"
          ),
      type = type ?: listOf(),
      date = DateTime.of(date?.let { FhirDateTime.fromString(it) }, _date),
      procedure =
        Claim.Procedure.Procedure.from(procedureCodeableConcept, procedureReference)
          ?: throw SerializationException(
            "Missing required property 'procedure' on Claim.Procedure"
          ),
      udi = udi ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Procedure) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    when (val choice = value.procedure) {
      is Claim.Procedure.Procedure.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 8, CodeableConceptSerializer, choice.value)
      }
      is Claim.Procedure.Procedure.Reference -> {
        encoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
      }
    }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
  }
}

internal object ClaimInsuranceSerializer : KSerializer<Claim.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("focal", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_focal", Element.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("businessArrangement", KotlinString.serializer().descriptor, isOptional = true)
      element("_businessArrangement", Element.serializer().descriptor, isOptional = true)
      element(
        "preAuthRef",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_preAuthRef",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("claimResponse", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Insurance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Insurance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Insurance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Insurance {
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> focal = decoder.decodeBooleanElement(descriptor, i)
        6 ->
          _focal = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        8 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        9 -> businessArrangement = decoder.decodeStringElement(descriptor, i)
        10 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          claimResponse =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    return Claim.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Insurance"
          ),
      focal =
        R4Boolean.of(focal, _focal)
          ?: throw SerializationException("Missing required property 'focal' on Claim.Insurance"),
      identifier = identifier,
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on Claim.Insurance"
          ),
      businessArrangement = R4String.of(businessArrangement, _businessArrangement),
      preAuthRef =
        (kotlin.collections.List(maxOf(preAuthRef?.size ?: 0, _preAuthRef?.size ?: 0)) { index ->
          R4String.of(preAuthRef?.getOrNull(index)?.let { it }, _preAuthRef?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'preAuthRef' on Claim.Insurance has neither a value nor an id/extension"
            )
        }),
      claimResponse = claimResponse,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Insurance) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.focal.value))?.let { encoder.encodeBooleanElement(descriptor, 5, it) }
    (value.focal.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 7, IdentifierSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, value.coverage)
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    (value.preAuthRef.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, stringNullableListSerializer, it)
    }
    (value.preAuthRef.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.claimResponse)?.let {
      encoder.encodeSerializableElement(descriptor, 13, ReferenceSerializer, it)
    }
  }
}

internal object ClaimAccidentSerializer : KSerializer<Claim.Accident> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Accident") {
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
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Accident>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Accident =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Accident) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Accident {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var type: CodeableConcept? = null
    var locationAddress: Address? = null
    var locationReference: Reference? = null
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
        3 -> date = decoder.decodeStringElement(descriptor, i)
        4 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        7 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Accident: " + i)
      }
    }
    return Claim.Accident(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      date =
        Date.of(date?.let { FhirDate.fromString(it) }, _date)
          ?: throw SerializationException("Missing required property 'date' on Claim.Accident"),
      type = type,
      location = Claim.Accident.Location.from(locationAddress, locationReference),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Accident) {
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
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    when (val choice = value.location) {
      null -> {}
      is Claim.Accident.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
      }
      is Claim.Accident.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object ClaimItemSerializer : KSerializer<Claim.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element(
        "careTeamSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_careTeamSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "diagnosisSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_diagnosisSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "procedureSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_procedureSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "informationSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_informationSequence",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("locationCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("locationAddress", Address.serializer().descriptor, isOptional = true)
      element("locationReference", Reference.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element("bodySite", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subSite",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "encounter",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "detail",
        listSerialDescriptor(lazyDescriptor { Claim.Item.Detail.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Claim.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item {
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
    var detail: List<Claim.Item.Detail>? = null
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        6 ->
          _careTeamSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        7 ->
          diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        8 ->
          _diagnosisSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        9 ->
          procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        10 ->
          _procedureSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 ->
          informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        12 ->
          _informationSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        17 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        19 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        21 ->
          locationCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 ->
          locationAddress =
            decoder.decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
        23 ->
          locationReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        25 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        26 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        27 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        29 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 ->
          bodySite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 ->
          subSite =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        32 ->
          encounter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          detail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return Claim.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException("Missing required property 'sequence' on Claim.Item"),
      careTeamSequence =
        (kotlin.collections.List(
          maxOf(careTeamSequence?.size ?: 0, _careTeamSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            careTeamSequence?.getOrNull(index)?.let { it },
            _careTeamSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'careTeamSequence' on Claim.Item has neither a value nor an id/extension"
            )
        }),
      diagnosisSequence =
        (kotlin.collections.List(
          maxOf(diagnosisSequence?.size ?: 0, _diagnosisSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            diagnosisSequence?.getOrNull(index)?.let { it },
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
            procedureSequence?.getOrNull(index)?.let { it },
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
            informationSequence?.getOrNull(index)?.let { it },
            _informationSequence?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'informationSequence' on Claim.Item has neither a value nor an id/extension"
            )
        }),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on Claim.Item"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      serviced =
        Claim.Item.Serviced.from(
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
          servicedPeriod,
        ),
      location =
        Claim.Item.Location.from(locationCodeableConcept, locationAddress, locationReference),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      bodySite = bodySite,
      subSite = subSite ?: listOf(),
      encounter = encounter ?: listOf(),
      detail = detail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.careTeamSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 5, intNullableListSerializer, it)
    }
    (value.careTeamSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer.nullableListSerializer, it)
    }
    (value.diagnosisSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 7, intNullableListSerializer, it)
    }
    (value.diagnosisSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer.nullableListSerializer, it)
    }
    (value.procedureSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, intNullableListSerializer, it)
    }
    (value.procedureSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.informationSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 11, intNullableListSerializer, it)
    }
    (value.informationSequence.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 13, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 14, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      15,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    when (val choice = value.serviced) {
      null -> {}
      is Claim.Item.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 18, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 19, ElementSerializer, it)
        }
      }
      is Claim.Item.Serviced.Period -> {
        encoder.encodeSerializableElement(descriptor, 20, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is Claim.Item.Location.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 21, CodeableConceptSerializer, choice.value)
      }
      is Claim.Item.Location.Address -> {
        encoder.encodeSerializableElement(descriptor, 22, AddressSerializer, choice.value)
      }
      is Claim.Item.Location.Reference -> {
        encoder.encodeSerializableElement(descriptor, 23, ReferenceSerializer, choice.value)
      }
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 24, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 25, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 26, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 27, ElementSerializer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 28, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    (value.bodySite)?.let {
      encoder.encodeSerializableElement(descriptor, 30, CodeableConceptSerializer, it)
    }
    if (value.subSite.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31,
        CodeableConceptSerializer.listSerializer,
        value.subSite,
      )
    if (value.encounter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32,
        ReferenceSerializer.listSerializer,
        value.encounter,
      )
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33,
        ClaimItemDetailSerializer.listSerializer,
        value.detail,
      )
  }
}

internal object ClaimItemDetailSerializer : KSerializer<Claim.Item.Detail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Detail") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "subDetail",
        listSerialDescriptor(
          lazyDescriptor { Claim.Item.Detail.SubDetail.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Claim.Item.Detail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item.Detail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item.Detail {
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
    var subDetail: List<Claim.Item.Detail.SubDetail>? = null
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        11 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        12 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        13 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        16 ->
          subDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + i)
      }
    }
    return Claim.Item.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Item.Detail"
          ),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on Claim.Item.Detail"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
      subDetail = subDetail ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item.Detail) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 10, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 11, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 12, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
    if (value.subDetail.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        ClaimItemDetailSubDetailSerializer.listSerializer,
        value.subDetail,
      )
  }
}

internal object ClaimItemDetailSubDetailSerializer : KSerializer<Claim.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubDetail") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("revenue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "programCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("udi", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Claim.Item.Detail.SubDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Claim.Item.Detail.SubDetail =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail.SubDetail) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Claim.Item.Detail.SubDetail {
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
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          revenue =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          productOrService =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          modifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          programCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        11 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        12 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        13 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          udi =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubDetail: " + i)
      }
    }
    return Claim.Item.Detail.SubDetail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(sequence, _sequence)
          ?: throw SerializationException(
            "Missing required property 'sequence' on Claim.Item.Detail.SubDetail"
          ),
      revenue = revenue,
      category = category,
      productOrService =
        productOrService
          ?: throw SerializationException(
            "Missing required property 'productOrService' on Claim.Item.Detail.SubDetail"
          ),
      modifier = modifier ?: listOf(),
      programCode = programCode ?: listOf(),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      net = net,
      udi = udi ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Claim.Item.Detail.SubDetail) {
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    (value.revenue)?.let {
      encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, it)
    }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.productOrService,
    )
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.modifier,
      )
    if (value.programCode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        CodeableConceptSerializer.listSerializer,
        value.programCode,
      )
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 10, QuantitySerializer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 11, MoneySerializer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 12, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it) }
    if (value.udi.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        ReferenceSerializer.listSerializer,
        value.udi,
      )
  }
}

internal object ClaimSerializer : KSerializer<Claim> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Claim") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("use", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_use", Element.serializer().descriptor, isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("billablePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("insurer", Reference.serializer().descriptor, isOptional = true)
    b.element("provider", Reference.serializer().descriptor, isOptional = true)
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("fundsReserve", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "related",
      listSerialDescriptor(lazyDescriptor { Claim.Related.serializer().descriptor }),
      isOptional = true,
    )
    b.element("prescription", Reference.serializer().descriptor, isOptional = true)
    b.element("originalPrescription", Reference.serializer().descriptor, isOptional = true)
    b.element("payee", lazyDescriptor { Claim.Payee.serializer().descriptor }, isOptional = true)
    b.element("referral", Reference.serializer().descriptor, isOptional = true)
    b.element("facility", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "careTeam",
      listSerialDescriptor(lazyDescriptor { Claim.CareTeam.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(lazyDescriptor { Claim.SupportingInfo.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "diagnosis",
      listSerialDescriptor(lazyDescriptor { Claim.Diagnosis.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "procedure",
      listSerialDescriptor(lazyDescriptor { Claim.Procedure.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "insurance",
      listSerialDescriptor(lazyDescriptor { Claim.Insurance.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "accident",
      lazyDescriptor { Claim.Accident.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { Claim.Item.serializer().descriptor }),
      isOptional = true,
    )
    b.element("total", Money.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Claim =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Claim) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Claim")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
    var facility: Reference? = null
    var careTeam: List<Claim.CareTeam>? = null
    var supportingInfo: List<Claim.SupportingInfo>? = null
    var diagnosis: List<Claim.Diagnosis>? = null
    var procedure: List<Claim.Procedure>? = null
    var insurance: List<Claim.Insurance>? = null
    var accident: Claim.Accident? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> use = decoder.decodeStringElement(descriptor, i)
        16 ->
          _use = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          billablePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        19 -> created = decoder.decodeStringElement(descriptor, i)
        20 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          fundsReserve =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          related =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimRelatedSerializer.listSerializer,
              null,
            )
        27 ->
          prescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          originalPrescription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        29 ->
          payee =
            decoder.decodeNullableSerializableElement(descriptor, i, ClaimPayeeSerializer, null)
        30 ->
          referral =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        31 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        32 ->
          careTeam =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimCareTeamSerializer.listSerializer,
              null,
            )
        33 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimSupportingInfoSerializer.listSerializer,
              null,
            )
        34 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimDiagnosisSerializer.listSerializer,
              null,
            )
        35 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimProcedureSerializer.listSerializer,
              null,
            )
        36 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimInsuranceSerializer.listSerializer,
              null,
            )
        37 ->
          accident =
            decoder.decodeNullableSerializableElement(descriptor, i, ClaimAccidentSerializer, null)
        38 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemSerializer.listSerializer,
              null,
            )
        39 ->
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
      status =
        Enumeration.of(status?.let { Claim.FinancialResourceStatusCodes.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Claim"),
      type = type ?: throw SerializationException("Missing required property 'type' on Claim"),
      subType = subType,
      use =
        Enumeration.of(use?.let { Claim.Use.fromCode(it) }, _use)
          ?: throw SerializationException("Missing required property 'use' on Claim"),
      patient =
        patient ?: throw SerializationException("Missing required property 'patient' on Claim"),
      billablePeriod = billablePeriod,
      created =
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
          ?: throw SerializationException("Missing required property 'created' on Claim"),
      enterer = enterer,
      insurer = insurer,
      provider =
        provider ?: throw SerializationException("Missing required property 'provider' on Claim"),
      priority =
        priority ?: throw SerializationException("Missing required property 'priority' on Claim"),
      fundsReserve = fundsReserve,
      related = related ?: listOf(),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      facility = facility,
      careTeam = careTeam ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      insurance = insurance ?: listOf(),
      accident = accident,
      item = item ?: listOf(),
      total = total,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Claim,
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
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    (value.subType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.use.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    (value.billablePeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, PeriodSerializer, it)
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, ElementSerializer, it)
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.insurer)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, ReferenceSerializer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.provider,
    )
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    (value.fundsReserve)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.related.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ClaimRelatedSerializer.listSerializer,
        value.related,
      )
    (value.prescription)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.originalPrescription)?.let {
      encoder.encodeSerializableElement(descriptor, 28 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.payee)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, ClaimPayeeSerializer, it)
    }
    (value.referral)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.careTeam.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ClaimCareTeamSerializer.listSerializer,
        value.careTeam,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        ClaimSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ClaimDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        ClaimProcedureSerializer.listSerializer,
        value.procedure,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        ClaimInsuranceSerializer.listSerializer,
        value.insurance,
      )
    (value.accident)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ClaimAccidentSerializer,
        it,
      )
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        ClaimItemSerializer.listSerializer,
        value.item,
      )
    (value.total)?.let {
      encoder.encodeSerializableElement(descriptor, 39 + descriptorOffset, MoneySerializer, it)
    }
  }
}

internal object ClaimPolymorphicSerializer : KSerializer<Claim> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Claim") { ClaimSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Claim) {
    encoder.encodeStructure(descriptor) {
      ClaimSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Claim =
    decoder.decodeStructure(descriptor) {
      ClaimSerializer.deserializeInternal(this, descriptor, 0)
    }
}
