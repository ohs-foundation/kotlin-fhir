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
import dev.ohs.fhir.model.r5.terminologies.FinancialResourceStatusCodes
import dev.ohs.fhir.model.r5.terminologies.Use
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

internal object ClaimRelatedSerializer : FhirSerializer<Claim.Related> {
  override val descriptor: SerialDescriptor = buildDescriptor("Related", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Related>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("claim", ReferenceSerializer.descriptor)
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.optionalElement("reference", IdentifierSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Related {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Related(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      claim = claim,
      relationship = relationship,
      reference = reference,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Related) {
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

internal object ClaimPayeeSerializer : FhirSerializer<Claim.Payee> {
  override val descriptor: SerialDescriptor = buildDescriptor("Payee", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Payee>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("party", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Payee {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Payee(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "Claim.Payee", "type"),
      party = party,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Payee) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, ReferenceSerializer, value.party)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimEventSerializer : FhirSerializer<Claim.Event> {
  override val descriptor: SerialDescriptor = buildDescriptor("Event", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Event>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("whenDateTime")
    b.optionalElement("whenPeriod", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Event {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var whenDateTime: FhirDateTime? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
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
          whenDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _whenDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          whenPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Event(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "Claim.Event", "type"),
      `when` =
        required(
          Claim.Event.When.from(DateTime.of(whenDateTime, _whenDateTime), whenPeriod),
          "Claim.Event",
          "when",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Event) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`when`) {
      is Claim.Event.When.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is Claim.Event.When.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimCareTeamSerializer : FhirSerializer<Claim.CareTeam> {
  override val descriptor: SerialDescriptor = buildDescriptor("CareTeam", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.CareTeam>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("provider", ReferenceSerializer.descriptor)
    b.boolPrim("responsible")
    b.optionalElement("role", CodeableConceptSerializer.descriptor)
    b.optionalElement("specialty", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.CareTeam {
    val descriptor = this.descriptor
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
    var specialty: CodeableConcept? = null
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
          specialty =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.CareTeam(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.CareTeam", "sequence"),
      provider = required(provider, "Claim.CareTeam", "provider"),
      responsible = R5Boolean.of(responsible, _responsible),
      role = role,
      specialty = specialty,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.CareTeam) {
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
      value.specialty,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimSupportingInfoSerializer : FhirSerializer<Claim.SupportingInfo> {
  override val descriptor: SerialDescriptor = buildDescriptor("SupportingInfo", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Claim.SupportingInfo>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrim("timingDate")
    b.optionalElement("timingPeriod", PeriodSerializer.descriptor)
    b.boolPrim("valueBoolean")
    b.strPrim("valueString")
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.optionalElement("valueIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement("reason", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.SupportingInfo {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var category: CodeableConcept? = null
    var code: CodeableConcept? = null
    var timingDate: FhirDate? = null
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
        7 -> timingDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
          valueIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        18 ->
          reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.SupportingInfo(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.SupportingInfo", "sequence"),
      category = required(category, "Claim.SupportingInfo", "category"),
      code = code,
      timing = Claim.SupportingInfo.Timing.from(Date.of(timingDate, _timingDate), timingPeriod),
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
      is Claim.SupportingInfo.Timing.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 7, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Claim.SupportingInfo.Timing.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.`value`) {
      null -> {}
      is Claim.SupportingInfo.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 10, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 11, choice.value)
      }
      is Claim.SupportingInfo.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 12, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 13, choice.value)
      }
      is Claim.SupportingInfo.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 14, QuantitySerializer, choice.value)
      }
      is Claim.SupportingInfo.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          15,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Claim.SupportingInfo.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          16,
          ReferenceSerializer,
          choice.value,
        )
      }
      is Claim.SupportingInfo.Value.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17,
          IdentifierSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18,
      CodeableConceptSerializer,
      value.reason,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimDiagnosisSerializer : FhirSerializer<Claim.Diagnosis> {
  override val descriptor: SerialDescriptor = buildDescriptor("Diagnosis", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Diagnosis>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("diagnosisCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("diagnosisReference", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("onAdmission", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Diagnosis {
    val descriptor = this.descriptor
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
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Diagnosis(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.Diagnosis", "sequence"),
      diagnosis =
        required(
          Claim.Diagnosis.Diagnosis.from(diagnosisCodeableConcept, diagnosisReference),
          "Claim.Diagnosis",
          "diagnosis",
        ),
      type = listOrEmpty(type),
      onAdmission = onAdmission,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Diagnosis) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    when (val choice = value.diagnosis) {
      is Claim.Diagnosis.Diagnosis.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Claim.Diagnosis.Diagnosis.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimProcedureSerializer : FhirSerializer<Claim.Procedure> {
  override val descriptor: SerialDescriptor = buildDescriptor("Procedure", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Procedure>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("procedureCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("procedureReference", ReferenceSerializer.descriptor)
    b.optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Procedure {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var type: List<CodeableConcept>? = null
    var date: FhirDateTime? = null
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
        6 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Procedure(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.Procedure", "sequence"),
      type = listOrEmpty(type),
      date = DateTime.of(date, _date),
      procedure =
        required(
          Claim.Procedure.Procedure.from(procedureCodeableConcept, procedureReference),
          "Claim.Procedure",
          "procedure",
        ),
      udi = listOrEmpty(udi),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Procedure) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableConceptSerializer.listSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.date)
    when (val choice = value.procedure) {
      is Claim.Procedure.Procedure.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Claim.Procedure.Procedure.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 9, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      ReferenceSerializer.listSerializer,
      value.udi,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimInsuranceSerializer : FhirSerializer<Claim.Insurance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Insurance", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Insurance>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.boolPrim("focal")
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("coverage", ReferenceSerializer.descriptor)
    b.strPrim("businessArrangement")
    b.strPrimList("preAuthRef")
    b.optionalElement("claimResponse", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Insurance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        5 -> focal = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _focal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        8 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        9 -> businessArrangement = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _businessArrangement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        12 ->
          _preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        13 ->
          claimResponse =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val preAuthRef_ =
      List(maxSize(preAuthRef, _preAuthRef)) { index ->
        entryRequired(
          R5String.of(at(preAuthRef, index), at(_preAuthRef, index)),
          "Claim.Insurance",
          "preAuthRef",
        )
      }
    return Claim.Insurance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.Insurance", "sequence"),
      focal = required(R5Boolean.of(focal, _focal), "Claim.Insurance", "focal"),
      identifier = identifier,
      coverage = required(coverage, "Claim.Insurance", "coverage"),
      businessArrangement = R5String.of(businessArrangement, _businessArrangement),
      preAuthRef = preAuthRef_,
      claimResponse = claimResponse,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Insurance) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.focal.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.focal)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, value.coverage)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.businessArrangement?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.businessArrangement)
    if (!value.preAuthRef.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        11,
        stringNullableListSerializer,
        value.preAuthRef.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 12, value.preAuthRef)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      ReferenceSerializer,
      value.claimResponse,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimAccidentSerializer : FhirSerializer<Claim.Accident> {
  override val descriptor: SerialDescriptor = buildDescriptor("Accident", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Accident>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("locationAddress", AddressSerializer.descriptor)
    b.optionalElement("locationReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Accident {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var date: FhirDate? = null
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
        3 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Accident(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      date = required(Date.of(date, _date), "Claim.Accident", "date"),
      type = type,
      location = Claim.Accident.Location.from(locationAddress, locationReference),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Accident) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.date.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      CodeableConceptSerializer,
      value.type,
    )
    when (val choice = value.location) {
      null -> {}
      is Claim.Accident.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, AddressSerializer, choice.value)
      }
      is Claim.Accident.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(descriptor, 7, ReferenceSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimItemSerializer : FhirSerializer<Claim.Item> {
  override val descriptor: SerialDescriptor = buildDescriptor("Item", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Item>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
    b.intPrimList("careTeamSequence")
    b.intPrimList("diagnosisSequence")
    b.intPrimList("procedureSequence")
    b.intPrimList("informationSequence")
    b.optionalElement("revenue", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("servicedDate")
    b.optionalElement("servicedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("locationCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("locationAddress", AddressSerializer.descriptor)
    b.optionalElement("locationReference", ReferenceSerializer.descriptor)
    b.optionalElement("patientPaid", MoneySerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("tax", MoneySerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("bodySite", ClaimItemBodySiteSerializer.listSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("detail", ClaimItemDetailSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var servicedDate: FhirDate? = null
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
          traceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        6 ->
          careTeamSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        7 ->
          _careTeamSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        8 ->
          diagnosisSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        9 ->
          _diagnosisSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          procedureSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        11 ->
          _procedureSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        12 ->
          informationSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        13 ->
          _informationSequence =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        14 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          productOrServiceEnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        21 ->
          servicedDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        22 ->
          _servicedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          servicedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        24 ->
          locationCodeableConcept =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        25 ->
          locationAddress =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AddressSerializer,
              null,
            )
        26 ->
          locationReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        27 ->
          patientPaid =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        28 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        29 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        30 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        31 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          tax =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        33 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        34 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          bodySite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemBodySiteSerializer.listSerializer,
              null,
            )
        36 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        37 ->
          detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val careTeamSequence_ =
      List(maxSize(careTeamSequence, _careTeamSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(careTeamSequence, index), at(_careTeamSequence, index)),
          "Claim.Item",
          "careTeamSequence",
        )
      }
    val diagnosisSequence_ =
      List(maxSize(diagnosisSequence, _diagnosisSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(diagnosisSequence, index), at(_diagnosisSequence, index)),
          "Claim.Item",
          "diagnosisSequence",
        )
      }
    val procedureSequence_ =
      List(maxSize(procedureSequence, _procedureSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(procedureSequence, index), at(_procedureSequence, index)),
          "Claim.Item",
          "procedureSequence",
        )
      }
    val informationSequence_ =
      List(maxSize(informationSequence, _informationSequence)) { index ->
        entryRequired(
          PositiveInt.of(at(informationSequence, index), at(_informationSequence, index)),
          "Claim.Item",
          "informationSequence",
        )
      }
    return Claim.Item(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.Item", "sequence"),
      traceNumber = listOrEmpty(traceNumber),
      careTeamSequence = careTeamSequence_,
      diagnosisSequence = diagnosisSequence_,
      procedureSequence = procedureSequence_,
      informationSequence = informationSequence_,
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      request = listOrEmpty(request),
      modifier = listOrEmpty(modifier),
      programCode = listOrEmpty(programCode),
      serviced = Claim.Item.Serviced.from(Date.of(servicedDate, _servicedDate), servicedPeriod),
      location =
        Claim.Item.Location.from(locationCodeableConcept, locationAddress, locationReference),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = listOrEmpty(udi),
      bodySite = listOrEmpty(bodySite),
      encounter = listOrEmpty(encounter),
      detail = listOrEmpty(detail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Item) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      IdentifierSerializer.listSerializer,
      value.traceNumber,
    )
    if (!value.careTeamSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        6,
        intNullableListSerializer,
        value.careTeamSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 7, value.careTeamSequence)
    }
    if (!value.diagnosisSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        intNullableListSerializer,
        value.diagnosisSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.diagnosisSequence)
    }
    if (!value.procedureSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        10,
        intNullableListSerializer,
        value.procedureSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 11, value.procedureSequence)
    }
    if (!value.informationSequence.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        12,
        intNullableListSerializer,
        value.informationSequence.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 13, value.informationSequence)
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17,
      CodeableConceptSerializer,
      value.productOrServiceEnd,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      18,
      ReferenceSerializer.listSerializer,
      value.request,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20,
      CodeableConceptSerializer.listSerializer,
      value.programCode,
    )
    when (val choice = value.serviced) {
      null -> {}
      is Claim.Item.Serviced.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 21, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 22, choice.value)
      }
      is Claim.Item.Serviced.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 23, PeriodSerializer, choice.value)
      }
    }
    when (val choice = value.location) {
      null -> {}
      is Claim.Item.Location.CodeableConcept -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          24,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Claim.Item.Location.Address -> {
        compositeEncoder.encodeSerializableElement(descriptor, 25, AddressSerializer, choice.value)
      }
      is Claim.Item.Location.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          26,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 27, MoneySerializer, value.patientPaid)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 28, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 29, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 32, MoneySerializer, value.tax)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 33, MoneySerializer, value.net)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34,
      ReferenceSerializer.listSerializer,
      value.udi,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35,
      ClaimItemBodySiteSerializer.listSerializer,
      value.bodySite,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36,
      ReferenceSerializer.listSerializer,
      value.encounter,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37,
      ClaimItemDetailSerializer.listSerializer,
      value.detail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimItemBodySiteSerializer : FhirSerializer<Claim.Item.BodySite> {
  override val descriptor: SerialDescriptor = buildDescriptor("BodySite", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Claim.Item.BodySite>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("site", CodeableReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subSite", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.BodySite {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var site: List<CodeableReference>? = null
    var subSite: List<CodeableConcept>? = null
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
          site =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          subSite =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Item.BodySite(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      site = listOrEmpty(site),
      subSite = listOrEmpty(subSite),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.BodySite) {
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      CodeableReferenceSerializer.listSerializer,
      value.site,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      CodeableConceptSerializer.listSerializer,
      value.subSite,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimItemDetailSerializer : FhirSerializer<Claim.Item.Detail> {
  override val descriptor: SerialDescriptor = buildDescriptor("Detail", this)

  @JvmField internal val listSerializer: KSerializer<List<Claim.Item.Detail>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("revenue", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("patientPaid", MoneySerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("tax", MoneySerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("subDetail", ClaimItemDetailSubDetailSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          traceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        6 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          productOrServiceEnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          patientPaid =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        13 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        14 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        16 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          tax =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        18 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        19 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        20 ->
          subDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemDetailSubDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Item.Detail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence = required(PositiveInt.of(sequence, _sequence), "Claim.Item.Detail", "sequence"),
      traceNumber = listOrEmpty(traceNumber),
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = listOrEmpty(modifier),
      programCode = listOrEmpty(programCode),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = listOrEmpty(udi),
      subDetail = listOrEmpty(subDetail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      IdentifierSerializer.listSerializer,
      value.traceNumber,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.productOrServiceEnd,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CodeableConceptSerializer.listSerializer,
      value.programCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, MoneySerializer, value.patientPaid)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 13, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 17, MoneySerializer, value.tax)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 18, MoneySerializer, value.net)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      ReferenceSerializer.listSerializer,
      value.udi,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      20,
      ClaimItemDetailSubDetailSerializer.listSerializer,
      value.subDetail,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimItemDetailSubDetailSerializer : FhirSerializer<Claim.Item.Detail.SubDetail> {
  override val descriptor: SerialDescriptor = buildDescriptor("SubDetail", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Claim.Item.Detail.SubDetail>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("sequence")
    b.optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("revenue", CodeableConceptSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrServiceEnd", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("programCode", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("patientPaid", MoneySerializer.descriptor)
    b.optionalElement("quantity", QuantitySerializer.descriptor)
    b.optionalElement("unitPrice", MoneySerializer.descriptor)
    b.prim("factor", FhirDecimalSerializer.descriptor)
    b.optionalElement("tax", MoneySerializer.descriptor)
    b.optionalElement("net", MoneySerializer.descriptor)
    b.optionalElement("udi", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Claim.Item.Detail.SubDetail {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          traceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        6 ->
          revenue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        9 ->
          productOrServiceEnd =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        11 ->
          programCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          patientPaid =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        13 ->
          quantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        14 ->
          unitPrice =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 ->
          factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        16 ->
          _factor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          tax =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        18 ->
          net =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        19 ->
          udi =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Claim.Item.Detail.SubDetail(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      sequence =
        required(PositiveInt.of(sequence, _sequence), "Claim.Item.Detail.SubDetail", "sequence"),
      traceNumber = listOrEmpty(traceNumber),
      revenue = revenue,
      category = category,
      productOrService = productOrService,
      productOrServiceEnd = productOrServiceEnd,
      modifier = listOrEmpty(modifier),
      programCode = listOrEmpty(programCode),
      patientPaid = patientPaid,
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      tax = tax,
      net = net,
      udi = listOrEmpty(udi),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Claim.Item.Detail.SubDetail) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      IdentifierSerializer.listSerializer,
      value.traceNumber,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      CodeableConceptSerializer,
      value.revenue,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      CodeableConceptSerializer,
      value.productOrServiceEnd,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CodeableConceptSerializer.listSerializer,
      value.programCode,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, MoneySerializer, value.patientPaid)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 13, QuantitySerializer, value.quantity)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.unitPrice)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      FhirDecimalSerializer,
      value.factor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.factor)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 17, MoneySerializer, value.tax)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 18, MoneySerializer, value.net)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      ReferenceSerializer.listSerializer,
      value.udi,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object ClaimSerializer : FhirResourceSerializer<Claim> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Claim")

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
    b.optionalElement("traceNumber", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subType", CodeableConceptSerializer.descriptor)
    b.strPrim("use")
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("billablePeriod", PeriodSerializer.descriptor)
    b.strPrim("created")
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
    compositeDecoder: CompositeDecoder,
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
    var status: FinancialResourceStatusCodes? = null
    var _status: Element? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var use: Use? = null
    var _use: Element? = null
    var patient: Reference? = null
    var billablePeriod: Period? = null
    var created: FhirDateTime? = null
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
          traceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        12 ->
          status =
            FinancialResourceStatusCodes.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        13 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          subType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 -> use = Use.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
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
        19 ->
          billablePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        20 -> created = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          enterer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          insurer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        25 ->
          priority =
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
              ClaimRelatedSerializer.listSerializer,
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
              ClaimPayeeSerializer,
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
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        33 ->
          facility =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        34 ->
          diagnosisRelatedGroup =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        35 ->
          event =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimEventSerializer.listSerializer,
              null,
            )
        36 ->
          careTeam =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimCareTeamSerializer.listSerializer,
              null,
            )
        37 ->
          supportingInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimSupportingInfoSerializer.listSerializer,
              null,
            )
        38 ->
          diagnosis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimDiagnosisSerializer.listSerializer,
              null,
            )
        39 ->
          procedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimProcedureSerializer.listSerializer,
              null,
            )
        40 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimInsuranceSerializer.listSerializer,
              null,
            )
        41 ->
          accident =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimAccidentSerializer,
              null,
            )
        42 ->
          patientPaid =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        43 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ClaimItemSerializer.listSerializer,
              null,
            )
        44 ->
          total =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        else -> unknownIndex(descriptor, i)
      }
    }
    return Claim(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      traceNumber = listOrEmpty(traceNumber),
      status = required(Enumeration.of(status, _status), "Claim", "status"),
      type = required(type, "Claim", "type"),
      subType = subType,
      use = required(Enumeration.of(use, _use), "Claim", "use"),
      patient = required(patient, "Claim", "patient"),
      billablePeriod = billablePeriod,
      created = required(DateTime.of(created, _created), "Claim", "created"),
      enterer = enterer,
      insurer = insurer,
      provider = provider,
      priority = priority,
      fundsReserve = fundsReserve,
      related = listOrEmpty(related),
      prescription = prescription,
      originalPrescription = originalPrescription,
      payee = payee,
      referral = referral,
      encounter = listOrEmpty(encounter),
      facility = facility,
      diagnosisRelatedGroup = diagnosisRelatedGroup,
      event = listOrEmpty(event),
      careTeam = listOrEmpty(careTeam),
      supportingInfo = listOrEmpty(supportingInfo),
      diagnosis = listOrEmpty(diagnosis),
      procedure = listOrEmpty(procedure),
      insurance = listOrEmpty(insurance),
      accident = accident,
      patientPaid = patientPaid,
      item = listOrEmpty(item),
      total = total,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Claim,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.traceNumber,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.subType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.use)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      PeriodSerializer,
      value.billablePeriod,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.provider,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      CodeableConceptSerializer,
      value.fundsReserve,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      ClaimRelatedSerializer.listSerializer,
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
      ClaimPayeeSerializer,
      value.payee,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      ReferenceSerializer,
      value.referral,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.encounter,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      33 + descriptorOffset,
      ReferenceSerializer,
      value.facility,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      34 + descriptorOffset,
      CodeableConceptSerializer,
      value.diagnosisRelatedGroup,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      35 + descriptorOffset,
      ClaimEventSerializer.listSerializer,
      value.event,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      36 + descriptorOffset,
      ClaimCareTeamSerializer.listSerializer,
      value.careTeam,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37 + descriptorOffset,
      ClaimSupportingInfoSerializer.listSerializer,
      value.supportingInfo,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      38 + descriptorOffset,
      ClaimDiagnosisSerializer.listSerializer,
      value.diagnosis,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      39 + descriptorOffset,
      ClaimProcedureSerializer.listSerializer,
      value.procedure,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      40 + descriptorOffset,
      ClaimInsuranceSerializer.listSerializer,
      value.insurance,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      41 + descriptorOffset,
      ClaimAccidentSerializer,
      value.accident,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      MoneySerializer,
      value.patientPaid,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      43 + descriptorOffset,
      ClaimItemSerializer.listSerializer,
      value.item,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      MoneySerializer,
      value.total,
    )
  }
}
