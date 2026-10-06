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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PaymentReconciliation
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.NoteType
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

internal object PaymentReconciliationAllocationSerializer :
  KSerializer<PaymentReconciliation.Allocation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Allocation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("predecessor", IdentifierSerializer.descriptor)
      optionalElement("target", ReferenceSerializer.descriptor)
      optionalElement("targetItemString", KotlinString.serializer().descriptor)
      optionalElement("_targetItemString", ElementSerializer.descriptor)
      optionalElement("targetItemIdentifier", IdentifierSerializer.descriptor)
      optionalElement("targetItemPositiveInt", Int.serializer().descriptor)
      optionalElement("_targetItemPositiveInt", ElementSerializer.descriptor)
      optionalElement("encounter", ReferenceSerializer.descriptor)
      optionalElement("account", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("submitter", ReferenceSerializer.descriptor)
      optionalElement("response", ReferenceSerializer.descriptor)
      optionalElement("date", KotlinString.serializer().descriptor)
      optionalElement("_date", ElementSerializer.descriptor)
      optionalElement("responsible", ReferenceSerializer.descriptor)
      optionalElement("payee", ReferenceSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PaymentReconciliation.Allocation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: Identifier? = null
      var predecessor: Identifier? = null
      var target: Reference? = null
      var targetItemString: KotlinString? = null
      var _targetItemString: Element? = null
      var targetItemIdentifier: Identifier? = null
      var targetItemPositiveInt: Int? = null
      var _targetItemPositiveInt: Element? = null
      var encounter: Reference? = null
      var account: Reference? = null
      var type: CodeableConcept? = null
      var submitter: Reference? = null
      var response: Reference? = null
      var date: KotlinString? = null
      var _date: Element? = null
      var responsible: Reference? = null
      var payee: Reference? = null
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
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 ->
            predecessor =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 -> target = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> targetItemString = decodeStringElement(descriptor, i)
          7 ->
            _targetItemString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            targetItemIdentifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          9 -> targetItemPositiveInt = decodeIntElement(descriptor, i)
          10 ->
            _targetItemPositiveInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            encounter = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 ->
            account = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          13 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            submitter = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          15 ->
            response = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          16 -> date = decodeStringElement(descriptor, i)
          17 -> _date = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          18 ->
            responsible =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          19 -> payee = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          20 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Allocation: " + i)
        }
      }
      PaymentReconciliation.Allocation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        predecessor = predecessor,
        target = target,
        targetItem =
          PaymentReconciliation.Allocation.TargetItem.from(
            R5String.of(targetItemString, _targetItemString),
            targetItemIdentifier,
            PositiveInt.of(targetItemPositiveInt, _targetItemPositiveInt),
          ),
        encounter = encounter,
        account = account,
        type = type,
        submitter = submitter,
        response = response,
        date = Date.of(if (date != null) FhirDate.fromString(date) else null, _date),
        responsible = responsible,
        payee = payee,
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeSerializableIfNotNull(descriptor, 4, IdentifierSerializer, value.predecessor)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.target)
      when (val choice = value.targetItem) {
        null -> {}
        is PaymentReconciliation.Allocation.TargetItem.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is PaymentReconciliation.Allocation.TargetItem.Identifier -> {
          encodeSerializableElement(descriptor, 8, IdentifierSerializer, choice.value)
        }
        is PaymentReconciliation.Allocation.TargetItem.PositiveInt -> {
          encodeIntIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.encounter)
      encodeSerializableIfNotNull(descriptor, 12, ReferenceSerializer, value.account)
      encodeSerializableIfNotNull(descriptor, 13, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 14, ReferenceSerializer, value.submitter)
      encodeSerializableIfNotNull(descriptor, 15, ReferenceSerializer, value.response)
      encodeStringIfNotNull(descriptor, 16, value.date?.value?.toString())
      encodeElementIfNotNull(descriptor, 17, value.date)
      encodeSerializableIfNotNull(descriptor, 18, ReferenceSerializer, value.responsible)
      encodeSerializableIfNotNull(descriptor, 19, ReferenceSerializer, value.payee)
      encodeSerializableIfNotNull(descriptor, 20, MoneySerializer, value.amount)
    }
  }
}

internal object PaymentReconciliationProcessNoteSerializer :
  KSerializer<PaymentReconciliation.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<PaymentReconciliation.ProcessNote>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
        }
      }
      PaymentReconciliation.ProcessNote(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = Enumeration.of(if (type != null) NoteType.fromCode(type) else null, _type),
        text = R5String.of(text, _text),
      )
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
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
      encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.text?.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
    }
  }
}

internal object PaymentReconciliationSerializer : FhirResourceSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PaymentReconciliation")

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
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("kind", CodeableConceptSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
    b.optionalElement("issuerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("paymentIssuer", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.optionalElement("cardBrand", KotlinString.serializer().descriptor)
    b.optionalElement("_cardBrand", ElementSerializer.descriptor)
    b.optionalElement("accountNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_accountNumber", ElementSerializer.descriptor)
    b.optionalElement("expirationDate", KotlinString.serializer().descriptor)
    b.optionalElement("_expirationDate", ElementSerializer.descriptor)
    b.optionalElement("processor", KotlinString.serializer().descriptor)
    b.optionalElement("_processor", ElementSerializer.descriptor)
    b.optionalElement("referenceNumber", KotlinString.serializer().descriptor)
    b.optionalElement("_referenceNumber", ElementSerializer.descriptor)
    b.optionalElement("authorization", KotlinString.serializer().descriptor)
    b.optionalElement("_authorization", ElementSerializer.descriptor)
    b.optionalElement("tenderedAmount", MoneySerializer.descriptor)
    b.optionalElement("returnedAmount", MoneySerializer.descriptor)
    b.optionalElement("amount", MoneySerializer.descriptor)
    b.optionalElement("paymentIdentifier", IdentifierSerializer.descriptor)
    b.optionalElement(
      "allocation",
      PaymentReconciliationAllocationSerializer.listSerializer.descriptor,
    )
    b.optionalElement("formCode", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "processNote",
      PaymentReconciliationProcessNoteSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): PaymentReconciliation {
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
    var type: CodeableConcept? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var kind: CodeableConcept? = null
    var period: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var enterer: Reference? = null
    var issuerType: CodeableConcept? = null
    var paymentIssuer: Reference? = null
    var request: Reference? = null
    var requestor: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var location: Reference? = null
    var method: CodeableConcept? = null
    var cardBrand: KotlinString? = null
    var _cardBrand: Element? = null
    var accountNumber: KotlinString? = null
    var _accountNumber: Element? = null
    var expirationDate: KotlinString? = null
    var _expirationDate: Element? = null
    var processor: KotlinString? = null
    var _processor: Element? = null
    var referenceNumber: KotlinString? = null
    var _referenceNumber: Element? = null
    var authorization: KotlinString? = null
    var _authorization: Element? = null
    var tenderedAmount: Money? = null
    var returnedAmount: Money? = null
    var amount: Money? = null
    var paymentIdentifier: Identifier? = null
    var allocation: List<PaymentReconciliation.Allocation>? = null
    var formCode: CodeableConcept? = null
    var processNote: List<PaymentReconciliation.ProcessNote>? = null
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
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 ->
          kind =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        16 -> created = decoder.decodeStringElement(descriptor, i)
        17 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          issuerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 -> outcome = decoder.decodeStringElement(descriptor, i)
        24 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> disposition = decoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        30 ->
          method =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 -> cardBrand = decoder.decodeStringElement(descriptor, i)
        32 ->
          _cardBrand =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        33 -> accountNumber = decoder.decodeStringElement(descriptor, i)
        34 ->
          _accountNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        35 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        36 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 -> processor = decoder.decodeStringElement(descriptor, i)
        38 ->
          _processor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        39 -> referenceNumber = decoder.decodeStringElement(descriptor, i)
        40 ->
          _referenceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> authorization = decoder.decodeStringElement(descriptor, i)
        42 ->
          _authorization =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 ->
          tenderedAmount =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        44 ->
          returnedAmount =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        45 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        46 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        47 ->
          allocation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationAllocationSerializer.listSerializer,
              null,
            )
        48 ->
          formCode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          processNote =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationProcessNoteSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding PaymentReconciliation: " + i)
      }
    }
    return PaymentReconciliation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on PaymentReconciliation"
          ),
      status =
        Enumeration.of(
          if (status != null) PaymentReconciliation.FinancialResourceStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on PaymentReconciliation"
          ),
      kind = kind,
      period = period,
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on PaymentReconciliation"
          ),
      enterer = enterer,
      issuerType = issuerType,
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome =
        Enumeration.of(
          if (outcome != null) PaymentReconciliation.PaymentOutcome.fromCode(outcome) else null,
          _outcome,
        ),
      disposition = R5String.of(disposition, _disposition),
      date =
        Date.of(if (date != null) FhirDate.fromString(date) else null, _date)
          ?: throw SerializationException(
            "Missing required property 'date' on PaymentReconciliation"
          ),
      location = location,
      method = method,
      cardBrand = R5String.of(cardBrand, _cardBrand),
      accountNumber = R5String.of(accountNumber, _accountNumber),
      expirationDate =
        Date.of(
          if (expirationDate != null) FhirDate.fromString(expirationDate) else null,
          _expirationDate,
        ),
      processor = R5String.of(processor, _processor),
      referenceNumber = R5String.of(referenceNumber, _referenceNumber),
      authorization = R5String.of(authorization, _authorization),
      tenderedAmount = tenderedAmount,
      returnedAmount = returnedAmount,
      amount =
        amount
          ?: throw SerializationException(
            "Missing required property 'amount' on PaymentReconciliation"
          ),
      paymentIdentifier = paymentIdentifier,
      allocation = allocation ?: listOf(),
      formCode = formCode,
      processNote = processNote ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PaymentReconciliation,
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.kind,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.issuerType,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.paymentIssuer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.outcome?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.outcome)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.disposition?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.disposition)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.date.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    encoder.encodeStringIfNotNull(descriptor, 31 + descriptorOffset, value.cardBrand?.value)
    encoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.cardBrand)
    encoder.encodeStringIfNotNull(descriptor, 33 + descriptorOffset, value.accountNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.accountNumber)
    encoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.expirationDate)
    encoder.encodeStringIfNotNull(descriptor, 37 + descriptorOffset, value.processor?.value)
    encoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.processor)
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.referenceNumber?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.referenceNumber)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.authorization?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.authorization)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      MoneySerializer,
      value.tenderedAmount,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      MoneySerializer,
      value.returnedAmount,
    )
    encoder.encodeSerializableElement(
      descriptor,
      45 + descriptorOffset,
      MoneySerializer,
      value.amount,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      IdentifierSerializer,
      value.paymentIdentifier,
    )
    if (value.allocation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        PaymentReconciliationAllocationSerializer.listSerializer,
        value.allocation,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        PaymentReconciliationProcessNoteSerializer.listSerializer,
        value.processNote,
      )
  }
}
