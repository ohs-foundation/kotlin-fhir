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

import dev.ohs.fhir.model.r5.Account
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.AccountStatus
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

internal object AccountCoverageSerializer : KSerializer<Account.Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("priority", Int.serializer().descriptor)
      optionalElement("_priority", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Coverage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Coverage {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var priority: Int? = null
    var _priority: Element? = null
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
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> priority = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _priority =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Coverage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on Account.Coverage"
          ),
      priority = PositiveInt.of(priority, _priority),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Coverage) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.coverage)
    compositeEncoder.encodeIntIfNotNull(descriptor, 4, value.priority?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.priority)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountGuarantorSerializer : KSerializer<Account.Guarantor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Guarantor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
      optionalElement("onHold", KotlinBoolean.serializer().descriptor)
      optionalElement("_onHold", ElementSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Guarantor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Guarantor {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var party: Reference? = null
    var onHold: KotlinBoolean? = null
    var _onHold: Element? = null
    var period: Period? = null
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
          party =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> onHold = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _onHold =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Guarantor: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Guarantor(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      party =
        party
          ?: throw SerializationException("Missing required property 'party' on Account.Guarantor"),
      onHold = R5Boolean.of(onHold, _onHold),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Guarantor) {
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
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.party)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.onHold?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.onHold)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountDiagnosisSerializer : KSerializer<Account.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("condition", CodeableReferenceSerializer.descriptor)
      optionalElement("dateOfDiagnosis", KotlinString.serializer().descriptor)
      optionalElement("_dateOfDiagnosis", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("onAdmission", KotlinBoolean.serializer().descriptor)
      optionalElement("_onAdmission", ElementSerializer.descriptor)
      optionalElement("packageCode", CodeableConceptSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Diagnosis>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Diagnosis {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var condition: CodeableReference? = null
    var dateOfDiagnosis: KotlinString? = null
    var _dateOfDiagnosis: Element? = null
    var type: List<CodeableConcept>? = null
    var onAdmission: KotlinBoolean? = null
    var _onAdmission: Element? = null
    var packageCode: List<CodeableConcept>? = null
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
          condition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        6 -> dateOfDiagnosis = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _dateOfDiagnosis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 -> onAdmission = compositeDecoder.decodeBooleanElement(descriptor, i)
        10 ->
          _onAdmission =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          packageCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Diagnosis(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      condition =
        condition
          ?: throw SerializationException(
            "Missing required property 'condition' on Account.Diagnosis"
          ),
      dateOfDiagnosis =
        DateTime.of(
          if (dateOfDiagnosis != null) FhirDateTime.fromString(dateOfDiagnosis) else null,
          _dateOfDiagnosis,
        ),
      type = type ?: listOf(),
      onAdmission = R5Boolean.of(onAdmission, _onAdmission),
      packageCode = packageCode ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Diagnosis) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      CodeableReferenceSerializer,
      value.condition,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.dateOfDiagnosis?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.dateOfDiagnosis)
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 9, value.onAdmission?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.onAdmission)
    if (value.packageCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.packageCode,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountProcedureSerializer : KSerializer<Account.Procedure> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Procedure") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("code", CodeableReferenceSerializer.descriptor)
      optionalElement("dateOfService", KotlinString.serializer().descriptor)
      optionalElement("_dateOfService", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("packageCode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("device", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Procedure>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Procedure {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var code: CodeableReference? = null
    var dateOfService: KotlinString? = null
    var _dateOfService: Element? = null
    var type: List<CodeableConcept>? = null
    var packageCode: List<CodeableConcept>? = null
    var device: List<Reference>? = null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer,
              null,
            )
        6 -> dateOfService = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _dateOfService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          packageCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        10 ->
          device =
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
    return Account.Procedure(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      code =
        code
          ?: throw SerializationException("Missing required property 'code' on Account.Procedure"),
      dateOfService =
        DateTime.of(
          if (dateOfService != null) FhirDateTime.fromString(dateOfService) else null,
          _dateOfService,
        ),
      type = type ?: listOf(),
      packageCode = packageCode ?: listOf(),
      device = device ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Procedure) {
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
    compositeEncoder.encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.sequence)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      5,
      CodeableReferenceSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.dateOfService?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.dateOfService)
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.packageCode.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        CodeableConceptSerializer.listSerializer,
        value.packageCode,
      )
    if (value.device.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        ReferenceSerializer.listSerializer,
        value.device,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountRelatedAccountSerializer : KSerializer<Account.RelatedAccount> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedAccount") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relationship", CodeableConceptSerializer.descriptor)
      optionalElement("account", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.RelatedAccount>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.RelatedAccount {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relationship: CodeableConcept? = null
    var account: Reference? = null
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
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          account =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedAccount: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.RelatedAccount(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relationship = relationship,
      account =
        account
          ?: throw SerializationException(
            "Missing required property 'account' on Account.RelatedAccount"
          ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.RelatedAccount) {
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
      value.relationship,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.account)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountBalanceSerializer : KSerializer<Account.Balance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Balance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("aggregate", CodeableConceptSerializer.descriptor)
      optionalElement("term", CodeableConceptSerializer.descriptor)
      optionalElement("estimate", KotlinBoolean.serializer().descriptor)
      optionalElement("_estimate", ElementSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Account.Balance>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Account.Balance {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var aggregate: CodeableConcept? = null
    var term: CodeableConcept? = null
    var estimate: KotlinBoolean? = null
    var _estimate: Element? = null
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
          aggregate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          term =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 -> estimate = compositeDecoder.decodeBooleanElement(descriptor, i)
        6 ->
          _estimate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Balance: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Account.Balance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      aggregate = aggregate,
      term = term,
      estimate = R5Boolean.of(estimate, _estimate),
      amount =
        amount
          ?: throw SerializationException("Missing required property 'amount' on Account.Balance"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Account.Balance) {
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
      value.aggregate,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.term,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 5, value.estimate?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.estimate)
    compositeEncoder.encodeSerializableElement(descriptor, 7, MoneySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object AccountSerializer : FhirResourceSerializer<Account> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Account")

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
    b.optionalElement("billingStatus", CodeableConceptSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("servicePeriod", PeriodSerializer.descriptor)
    b.optionalElement("coverage", AccountCoverageSerializer.listSerializer.descriptor)
    b.optionalElement("owner", ReferenceSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("guarantor", AccountGuarantorSerializer.listSerializer.descriptor)
    b.optionalElement("diagnosis", AccountDiagnosisSerializer.listSerializer.descriptor)
    b.optionalElement("procedure", AccountProcedureSerializer.listSerializer.descriptor)
    b.optionalElement("relatedAccount", AccountRelatedAccountSerializer.listSerializer.descriptor)
    b.optionalElement("currency", CodeableConceptSerializer.descriptor)
    b.optionalElement("balance", AccountBalanceSerializer.listSerializer.descriptor)
    b.optionalElement("calculatedAt", KotlinString.serializer().descriptor)
    b.optionalElement("_calculatedAt", ElementSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Account {
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
    var billingStatus: CodeableConcept? = null
    var type: CodeableConcept? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var subject: List<Reference>? = null
    var servicePeriod: Period? = null
    var coverage: List<Account.Coverage>? = null
    var owner: Reference? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var guarantor: List<Account.Guarantor>? = null
    var diagnosis: List<Account.Diagnosis>? = null
    var procedure: List<Account.Procedure>? = null
    var relatedAccount: List<Account.RelatedAccount>? = null
    var currency: CodeableConcept? = null
    var balance: List<Account.Balance>? = null
    var calculatedAt: KotlinString? = null
    var _calculatedAt: Element? = null
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
          billingStatus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
        15 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          servicePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        19 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountCoverageSerializer.listSerializer,
              null,
            )
        20 ->
          owner =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          guarantor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountGuarantorSerializer.listSerializer,
              null,
            )
        24 ->
          diagnosis =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountDiagnosisSerializer.listSerializer,
              null,
            )
        25 ->
          procedure =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountProcedureSerializer.listSerializer,
              null,
            )
        26 ->
          relatedAccount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountRelatedAccountSerializer.listSerializer,
              null,
            )
        27 ->
          currency =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          balance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountBalanceSerializer.listSerializer,
              null,
            )
        29 -> calculatedAt = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _calculatedAt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Account: " + i)
      }
    }
    return Account(
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
        Enumeration.of(if (status != null) AccountStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Account"),
      billingStatus = billingStatus,
      type = type,
      name = R5String.of(name, _name),
      subject = subject ?: listOf(),
      servicePeriod = servicePeriod,
      coverage = coverage ?: listOf(),
      owner = owner,
      description = Markdown.of(description, _description),
      guarantor = guarantor ?: listOf(),
      diagnosis = diagnosis ?: listOf(),
      procedure = procedure ?: listOf(),
      relatedAccount = relatedAccount ?: listOf(),
      currency = currency,
      balance = balance ?: listOf(),
      calculatedAt =
        Instant.of(
          if (calculatedAt != null) FhirDateTime.fromString(calculatedAt) else null,
          _calculatedAt,
        ),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Account,
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.billingStatus,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    if (value.subject.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      PeriodSerializer,
      value.servicePeriod,
    )
    if (value.coverage.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        AccountCoverageSerializer.listSerializer,
        value.coverage,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      21 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.description)
    if (value.guarantor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        AccountGuarantorSerializer.listSerializer,
        value.guarantor,
      )
    if (value.diagnosis.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        AccountDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        AccountProcedureSerializer.listSerializer,
        value.procedure,
      )
    if (value.relatedAccount.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        AccountRelatedAccountSerializer.listSerializer,
        value.relatedAccount,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.currency,
    )
    if (value.balance.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AccountBalanceSerializer.listSerializer,
        value.balance,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.calculatedAt?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.calculatedAt)
  }
}
