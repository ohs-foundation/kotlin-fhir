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
import dev.ohs.fhir.model.r5.terminologies.FinancialResourceStatusCodes
import dev.ohs.fhir.model.r5.terminologies.NoteType
import dev.ohs.fhir.model.r5.terminologies.PaymentOutcome
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

internal object PaymentReconciliationAllocationSerializer :
  FhirSerializer<PaymentReconciliation.Allocation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Allocation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PaymentReconciliation.Allocation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("predecessor", IdentifierSerializer.descriptor)
    b.optionalElement("target", ReferenceSerializer.descriptor)
    b.strPrim("targetItemString")
    b.optionalElement("targetItemIdentifier", IdentifierSerializer.descriptor)
    b.intPrim("targetItemPositiveInt")
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("submitter", ReferenceSerializer.descriptor)
    b.optionalElement("response", ReferenceSerializer.descriptor)
    b.strPrim("date")
    b.optionalElement("responsible", ReferenceSerializer.descriptor)
    b.optionalElement("payee", ReferenceSerializer.descriptor)
    b.optionalElement("amount", MoneySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var date: FhirDate? = null
    var _date: Element? = null
    var responsible: Reference? = null
    var payee: Reference? = null
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        4 ->
          predecessor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        5 ->
          target =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 -> targetItemString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _targetItemString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          targetItemIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        9 -> targetItemPositiveInt = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _targetItemPositiveInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        12 ->
          account =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
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
          submitter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          response =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          responsible =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          payee =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        20 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PaymentReconciliation.Allocation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
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
      date = Date.of(date, _date),
      responsible = responsible,
      payee = payee,
      amount = amount,
    )
  }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation) {
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      IdentifierSerializer,
      value.predecessor,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.target)
    when (val choice = value.targetItem) {
      null -> {}
      is PaymentReconciliation.Allocation.TargetItem.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is PaymentReconciliation.Allocation.TargetItem.Identifier -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          8,
          IdentifierSerializer,
          choice.value,
        )
      }
      is PaymentReconciliation.Allocation.TargetItem.PositiveInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
    }
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 12, ReferenceSerializer, value.account)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      ReferenceSerializer,
      value.submitter,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      ReferenceSerializer,
      value.response,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 16, value.date?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 17, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18,
      ReferenceSerializer,
      value.responsible,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 19, ReferenceSerializer, value.payee)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 20, MoneySerializer, value.amount)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PaymentReconciliationProcessNoteSerializer :
  FhirSerializer<PaymentReconciliation.ProcessNote> {
  override val descriptor: SerialDescriptor = buildDescriptor("ProcessNote", this)

  @JvmField
  internal val listSerializer: KSerializer<List<PaymentReconciliation.ProcessNote>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("text")
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: NoteType? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
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
        3 -> type = NoteType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return PaymentReconciliation.ProcessNote(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = Enumeration.of(type, _type),
      text = R5String.of(text, _text),
    )
  }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.text)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object PaymentReconciliationSerializer : FhirResourceSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("PaymentReconciliation")

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
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("status")
    b.optionalElement("kind", CodeableConceptSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.strPrim("created")
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
    b.optionalElement("issuerType", CodeableConceptSerializer.descriptor)
    b.optionalElement("paymentIssuer", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.strPrim("outcome")
    b.strPrim("disposition")
    b.strPrim("date")
    b.optionalElement("location", ReferenceSerializer.descriptor)
    b.optionalElement("method", CodeableConceptSerializer.descriptor)
    b.strPrim("cardBrand")
    b.strPrim("accountNumber")
    b.strPrim("expirationDate")
    b.strPrim("processor")
    b.strPrim("referenceNumber")
    b.strPrim("authorization")
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
    compositeDecoder: CompositeDecoder,
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
    var status: FinancialResourceStatusCodes? = null
    var _status: Element? = null
    var kind: CodeableConcept? = null
    var period: Period? = null
    var created: FhirDateTime? = null
    var _created: Element? = null
    var enterer: Reference? = null
    var issuerType: CodeableConcept? = null
    var paymentIssuer: Reference? = null
    var request: Reference? = null
    var requestor: Reference? = null
    var outcome: PaymentOutcome? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var date: FhirDate? = null
    var _date: Element? = null
    var location: Reference? = null
    var method: CodeableConcept? = null
    var cardBrand: KotlinString? = null
    var _cardBrand: Element? = null
    var accountNumber: KotlinString? = null
    var _accountNumber: Element? = null
    var expirationDate: FhirDate? = null
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
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
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
          kind =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        16 -> created = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        17 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          enterer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 ->
          issuerType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        20 ->
          paymentIssuer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          requestor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 -> outcome = PaymentOutcome.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> disposition = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> date = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        28 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        30 ->
          method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        31 -> cardBrand = compositeDecoder.decodeStringElement(descriptor, i)
        32 ->
          _cardBrand =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        33 -> accountNumber = compositeDecoder.decodeStringElement(descriptor, i)
        34 ->
          _accountNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        35 ->
          expirationDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        36 ->
          _expirationDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 -> processor = compositeDecoder.decodeStringElement(descriptor, i)
        38 ->
          _processor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        39 -> referenceNumber = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _referenceNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> authorization = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _authorization =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 ->
          tenderedAmount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        44 ->
          returnedAmount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        45 ->
          amount =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        46 ->
          paymentIdentifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        47 ->
          allocation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationAllocationSerializer.listSerializer,
              null,
            )
        48 ->
          formCode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        49 ->
          processNote =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PaymentReconciliationProcessNoteSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return PaymentReconciliation(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      type = required(type, "PaymentReconciliation", "type"),
      status = required(Enumeration.of(status, _status), "PaymentReconciliation", "status"),
      kind = kind,
      period = period,
      created = required(DateTime.of(created, _created), "PaymentReconciliation", "created"),
      enterer = enterer,
      issuerType = issuerType,
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome = Enumeration.of(outcome, _outcome),
      disposition = R5String.of(disposition, _disposition),
      date = required(Date.of(date, _date), "PaymentReconciliation", "date"),
      location = location,
      method = method,
      cardBrand = R5String.of(cardBrand, _cardBrand),
      accountNumber = R5String.of(accountNumber, _accountNumber),
      expirationDate = Date.of(expirationDate, _expirationDate),
      processor = R5String.of(processor, _processor),
      referenceNumber = R5String.of(referenceNumber, _referenceNumber),
      authorization = R5String.of(authorization, _authorization),
      tenderedAmount = tenderedAmount,
      returnedAmount = returnedAmount,
      amount = required(amount, "PaymentReconciliation", "amount"),
      paymentIdentifier = paymentIdentifier,
      allocation = listOrEmpty(allocation),
      formCode = formCode,
      processNote = listOrEmpty(processNote),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PaymentReconciliation,
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
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.kind,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      CodeableConceptSerializer,
      value.issuerType,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.paymentIssuer,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.outcome?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.outcome)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      25 + descriptorOffset,
      value.disposition?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.disposition)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      27 + descriptorOffset,
      value.date.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      29 + descriptorOffset,
      ReferenceSerializer,
      value.location,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      CodeableConceptSerializer,
      value.method,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      31 + descriptorOffset,
      value.cardBrand?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 32 + descriptorOffset, value.cardBrand)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      33 + descriptorOffset,
      value.accountNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 34 + descriptorOffset, value.accountNumber)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.expirationDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.expirationDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      37 + descriptorOffset,
      value.processor?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 38 + descriptorOffset, value.processor)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      39 + descriptorOffset,
      value.referenceNumber?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      40 + descriptorOffset,
      value.referenceNumber,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.authorization?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.authorization)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      MoneySerializer,
      value.tenderedAmount,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      MoneySerializer,
      value.returnedAmount,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      45 + descriptorOffset,
      MoneySerializer,
      value.amount,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      46 + descriptorOffset,
      IdentifierSerializer,
      value.paymentIdentifier,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      47 + descriptorOffset,
      PaymentReconciliationAllocationSerializer.listSerializer,
      value.allocation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      48 + descriptorOffset,
      CodeableConceptSerializer,
      value.formCode,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      49 + descriptorOffset,
      PaymentReconciliationProcessNoteSerializer.listSerializer,
      value.processNote,
    )
  }
}
