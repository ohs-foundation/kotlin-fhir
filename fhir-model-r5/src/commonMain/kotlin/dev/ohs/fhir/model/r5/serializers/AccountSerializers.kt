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

  override fun deserialize(decoder: Decoder): Account.Coverage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var coverage: Reference? = null
      var priority: Int? = null
      var _priority: Element? = null
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
            coverage = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> priority = decodeIntElement(descriptor, i)
          5 -> _priority = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
        }
      }
      Account.Coverage(
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.coverage)
      encodeIntIfNotNull(descriptor, 4, value.priority?.value)
      encodeElementIfNotNull(descriptor, 5, value.priority)
    }
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

  override fun deserialize(decoder: Decoder): Account.Guarantor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var party: Reference? = null
      var onHold: KotlinBoolean? = null
      var _onHold: Element? = null
      var period: Period? = null
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
          3 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> onHold = decodeBooleanElement(descriptor, i)
          5 -> _onHold = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Guarantor: " + i)
        }
      }
      Account.Guarantor(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        party =
          party
            ?: throw SerializationException(
              "Missing required property 'party' on Account.Guarantor"
            ),
        onHold = R5Boolean.of(onHold, _onHold),
        period = period,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Account.Guarantor) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.party)
      encodeBooleanIfNotNull(descriptor, 4, value.onHold?.value)
      encodeElementIfNotNull(descriptor, 5, value.onHold)
      encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.period)
    }
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

  override fun deserialize(decoder: Decoder): Account.Diagnosis =
    decoder.decodeStructure(descriptor) {
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
            condition =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          6 -> dateOfDiagnosis = decodeStringElement(descriptor, i)
          7 ->
            _dateOfDiagnosis =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 -> onAdmission = decodeBooleanElement(descriptor, i)
          10 ->
            _onAdmission = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            packageCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
        }
      }
      Account.Diagnosis(
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
      encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeSerializableElement(descriptor, 5, CodeableReferenceSerializer, value.condition)
      encodeStringIfNotNull(descriptor, 6, value.dateOfDiagnosis?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.dateOfDiagnosis)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      encodeBooleanIfNotNull(descriptor, 9, value.onAdmission?.value)
      encodeElementIfNotNull(descriptor, 10, value.onAdmission)
      if (value.packageCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.packageCode,
        )
    }
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

  override fun deserialize(decoder: Decoder): Account.Procedure =
    decoder.decodeStructure(descriptor) {
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
            code =
              decodeNullableSerializableElement(descriptor, i, CodeableReferenceSerializer, null)
          6 -> dateOfService = decodeStringElement(descriptor, i)
          7 ->
            _dateOfService =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            packageCode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          10 ->
            device =
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
      Account.Procedure(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence = PositiveInt.of(sequence, _sequence),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on Account.Procedure"
            ),
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
      encodeIntIfNotNull(descriptor, 3, value.sequence?.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeSerializableElement(descriptor, 5, CodeableReferenceSerializer, value.code)
      encodeStringIfNotNull(descriptor, 6, value.dateOfService?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.dateOfService)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      if (value.packageCode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          CodeableConceptSerializer.listSerializer,
          value.packageCode,
        )
      if (value.device.isNotEmpty())
        encodeSerializableElement(descriptor, 10, ReferenceSerializer.listSerializer, value.device)
    }
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

  override fun deserialize(decoder: Decoder): Account.RelatedAccount =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var relationship: CodeableConcept? = null
      var account: Reference? = null
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
            relationship =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> account = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatedAccount: " + i)
        }
      }
      Account.RelatedAccount(
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.relationship)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.account)
    }
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

  override fun deserialize(decoder: Decoder): Account.Balance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var aggregate: CodeableConcept? = null
      var term: CodeableConcept? = null
      var estimate: KotlinBoolean? = null
      var _estimate: Element? = null
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
            aggregate =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            term = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 -> estimate = decodeBooleanElement(descriptor, i)
          6 -> _estimate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Balance: " + i)
        }
      }
      Account.Balance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        aggregate = aggregate,
        term = term,
        estimate = R5Boolean.of(estimate, _estimate),
        amount =
          amount
            ?: throw SerializationException(
              "Missing required property 'amount' on Account.Balance"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Account.Balance) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.aggregate)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.term)
      encodeBooleanIfNotNull(descriptor, 5, value.estimate?.value)
      encodeElementIfNotNull(descriptor, 6, value.estimate)
      encodeSerializableElement(descriptor, 7, MoneySerializer, value.amount)
    }
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
    decoder: CompositeDecoder,
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
          billingStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        18 ->
          servicePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        19 ->
          coverage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountCoverageSerializer.listSerializer,
              null,
            )
        20 ->
          owner =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> description = decoder.decodeStringElement(descriptor, i)
        22 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          guarantor =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountGuarantorSerializer.listSerializer,
              null,
            )
        24 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountDiagnosisSerializer.listSerializer,
              null,
            )
        25 ->
          procedure =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountProcedureSerializer.listSerializer,
              null,
            )
        26 ->
          relatedAccount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountRelatedAccountSerializer.listSerializer,
              null,
            )
        27 ->
          currency =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        28 ->
          balance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AccountBalanceSerializer.listSerializer,
              null,
            )
        29 -> calculatedAt = decoder.decodeStringElement(descriptor, i)
        30 ->
          _calculatedAt =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        Enumeration.of(
          if (status != null) Account.AccountStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Account"),
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
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Account,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.billingStatus,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.name)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      PeriodSerializer,
      value.servicePeriod,
    )
    if (value.coverage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        AccountCoverageSerializer.listSerializer,
        value.coverage,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.owner,
    )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.description)
    if (value.guarantor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        AccountGuarantorSerializer.listSerializer,
        value.guarantor,
      )
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        AccountDiagnosisSerializer.listSerializer,
        value.diagnosis,
      )
    if (value.procedure.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        AccountProcedureSerializer.listSerializer,
        value.procedure,
      )
    if (value.relatedAccount.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        AccountRelatedAccountSerializer.listSerializer,
        value.relatedAccount,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      CodeableConceptSerializer,
      value.currency,
    )
    if (value.balance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        AccountBalanceSerializer.listSerializer,
        value.balance,
      )
    encoder.encodeStringIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.calculatedAt?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.calculatedAt)
  }
}
