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
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PaymentReconciliation
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.NoteType
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("predecessor", Identifier.serializer().descriptor, isOptional = true)
      element("target", Reference.serializer().descriptor, isOptional = true)
      element("targetItemString", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetItemString", Element.serializer().descriptor, isOptional = true)
      element("targetItemIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("targetItemPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_targetItemPositiveInt", Element.serializer().descriptor, isOptional = true)
      element("encounter", Reference.serializer().descriptor, isOptional = true)
      element("account", Reference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("submitter", Reference.serializer().descriptor, isOptional = true)
      element("response", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("responsible", Reference.serializer().descriptor, isOptional = true)
      element("payee", Reference.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PaymentReconciliation.Allocation {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 ->
          predecessor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        5 ->
          target = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        6 -> targetItemString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _targetItemString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.targetItemStringSer,
              null,
            )
        8 ->
          targetItemIdentifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        9 -> targetItemPositiveInt = decoder.decodeIntElement(descriptor, i)
        10 ->
          _targetItemPositiveInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.targetItemStringSer,
              null,
            )
        11 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        12 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        13 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 ->
          submitter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        15 ->
          response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        16 -> date = decoder.decodeStringElement(descriptor, i)
        17 ->
          _date =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.targetItemStringSer,
              null,
            )
        18 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        19 ->
          payee = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSer, null)
        20 ->
          amount = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Allocation: " + i)
      }
    }
    return PaymentReconciliation.Allocation(
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
      date = Date.of(FhirDate.fromString(date), _date),
      responsible = responsible,
      payee = payee,
      amount = amount,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PaymentReconciliation.Allocation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.identifierSer, it)
    }
    (value.target)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.targetSer, it) }
    when (val choice = value.targetItem) {
      null -> {}
      is PaymentReconciliation.Allocation.TargetItem.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.targetItemStringSer, it)
        }
      }
      is PaymentReconciliation.Allocation.TargetItem.Identifier -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.identifierSer, choice.value)
      }
      is PaymentReconciliation.Allocation.TargetItem.PositiveInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.targetItemStringSer, it)
        }
      }
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.targetSer, it)
    }
    (value.account)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.targetSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 13, Hoisted.typeSer, it) }
    (value.submitter)?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.targetSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.targetSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 16, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.targetItemStringSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.targetSer, it)
    }
    (value.payee)?.let { encoder.encodeSerializableElement(descriptor, 19, Hoisted.targetSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(descriptor, 20, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val targetSer: KSerializer<Reference> = Reference.serializer()

    public val targetItemStringSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object PaymentReconciliationProcessNoteSerializer :
  KSerializer<PaymentReconciliation.ProcessNote> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ProcessNote") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): PaymentReconciliation.ProcessNote {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + i)
      }
    }
    return PaymentReconciliation.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type?.let { Enumeration.of(NoteType.fromCode(it), _type) },
      text = R5String.of(text, _text),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: PaymentReconciliation.ProcessNote,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PaymentReconciliationSerializer : KSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation") {
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
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("kind", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("issuerType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("paymentIssuer", Reference.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("requestor", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("location", Reference.serializer().descriptor, isOptional = true)
    b.element("method", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("cardBrand", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_cardBrand", Element.serializer().descriptor, isOptional = true)
    b.element("accountNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_accountNumber", Element.serializer().descriptor, isOptional = true)
    b.element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_expirationDate", Element.serializer().descriptor, isOptional = true)
    b.element("processor", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_processor", Element.serializer().descriptor, isOptional = true)
    b.element("referenceNumber", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_referenceNumber", Element.serializer().descriptor, isOptional = true)
    b.element("authorization", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authorization", Element.serializer().descriptor, isOptional = true)
    b.element("tenderedAmount", Money.serializer().descriptor, isOptional = true)
    b.element("returnedAmount", Money.serializer().descriptor, isOptional = true)
    b.element("amount", Money.serializer().descriptor, isOptional = true)
    b.element("paymentIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "allocation",
      listSerialDescriptor(
        lazyDescriptor { PaymentReconciliation.Allocation.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "processNote",
      listSerialDescriptor(
        lazyDescriptor { PaymentReconciliation.ProcessNote.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PaymentReconciliation")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 -> status = decoder.decodeStringElement(descriptor, i)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> kind = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        15 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        16 -> created = decoder.decodeStringElement(descriptor, i)
        17 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entererSer, null)
        19 ->
          issuerType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        20 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entererSer, null)
        21 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entererSer, null)
        22 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entererSer, null)
        23 -> outcome = decoder.decodeStringElement(descriptor, i)
        24 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> disposition = decoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entererSer, null)
        30 ->
          method = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        31 -> cardBrand = decoder.decodeStringElement(descriptor, i)
        32 ->
          _cardBrand =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        33 -> accountNumber = decoder.decodeStringElement(descriptor, i)
        34 ->
          _accountNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        35 -> expirationDate = decoder.decodeStringElement(descriptor, i)
        36 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        37 -> processor = decoder.decodeStringElement(descriptor, i)
        38 ->
          _processor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        39 -> referenceNumber = decoder.decodeStringElement(descriptor, i)
        40 ->
          _referenceNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        41 -> authorization = decoder.decodeStringElement(descriptor, i)
        42 ->
          _authorization =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        43 ->
          tenderedAmount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.tenderedAmountSer,
              null,
            )
        44 ->
          returnedAmount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.tenderedAmountSer,
              null,
            )
        45 ->
          amount =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.tenderedAmountSer,
              null,
            )
        46 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.identifierSerInner,
              null,
            )
        47 ->
          allocation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allocationSer, null)
        48 ->
          formCode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        49 ->
          processNote =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.processNoteSer, null)
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
      type = type!!,
      status =
        Enumeration.of(
          PaymentReconciliation.FinancialResourceStatusCodes.fromCode(status!!),
          _status,
        ),
      kind = kind,
      period = period,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      enterer = enterer,
      issuerType = issuerType,
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome =
        outcome?.let {
          Enumeration.of(PaymentReconciliation.PaymentOutcome.fromCode(it), _outcome)
        },
      disposition = R5String.of(disposition, _disposition),
      date = Date.of(FhirDate.fromString(date), _date)!!,
      location = location,
      method = method,
      cardBrand = R5String.of(cardBrand, _cardBrand),
      accountNumber = R5String.of(accountNumber, _accountNumber),
      expirationDate = Date.of(FhirDate.fromString(expirationDate), _expirationDate),
      processor = R5String.of(processor, _processor),
      referenceNumber = R5String.of(referenceNumber, _referenceNumber),
      authorization = R5String.of(authorization, _authorization),
      tenderedAmount = tenderedAmount,
      returnedAmount = returnedAmount,
      amount = amount!!,
      paymentIdentifier = paymentIdentifier,
      allocation = allocation ?: listOf(),
      formCode = formCode,
      processNote = processNote ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: PaymentReconciliation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      Hoisted.typeSer,
      value.type,
    )
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.kind)?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.periodSer, it)
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.entererSer, it)
    }
    (value.issuerType)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.paymentIssuer)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.entererSer, it)
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.entererSer, it)
    }
    (value.requestor)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.entererSer, it)
    }
    ((value.outcome?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.outcome?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.date.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.location)?.let {
      encoder.encodeSerializableElement(descriptor, 29 + descriptorOffset, Hoisted.entererSer, it)
    }
    (value.method)?.let {
      encoder.encodeSerializableElement(descriptor, 30 + descriptorOffset, Hoisted.typeSer, it)
    }
    ((value.cardBrand?.value))?.let {
      encoder.encodeStringElement(descriptor, 31 + descriptorOffset, it)
    }
    (value.cardBrand?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.accountNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 33 + descriptorOffset, it)
    }
    (value.accountNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.expirationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 35 + descriptorOffset, it)
    }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.processor?.value))?.let {
      encoder.encodeStringElement(descriptor, 37 + descriptorOffset, it)
    }
    (value.processor?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.referenceNumber?.value))?.let {
      encoder.encodeStringElement(descriptor, 39 + descriptorOffset, it)
    }
    (value.referenceNumber?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        40 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.authorization?.value))?.let {
      encoder.encodeStringElement(descriptor, 41 + descriptorOffset, it)
    }
    (value.authorization?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.tenderedAmount)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.tenderedAmountSer,
        it,
      )
    }
    (value.returnedAmount)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.tenderedAmountSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      45 + descriptorOffset,
      Hoisted.tenderedAmountSer,
      value.amount,
    )
    (value.paymentIdentifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.identifierSerInner,
        it,
      )
    }
    if (value.allocation.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.allocationSer,
        value.allocation,
      )
    (value.formCode)?.let {
      encoder.encodeSerializableElement(descriptor, 48 + descriptorOffset, Hoisted.typeSer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.processNoteSer,
        value.processNote,
      )
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val entererSer: KSerializer<Reference> = Reference.serializer()

    public val tenderedAmountSer: KSerializer<Money> = Money.serializer()

    public val allocationSerInner: KSerializer<PaymentReconciliation.Allocation> =
      PaymentReconciliation.Allocation.serializer()

    public val allocationSer: KSerializer<List<PaymentReconciliation.Allocation>> =
      ListSerializer(Hoisted.allocationSerInner)

    public val processNoteSerInner: KSerializer<PaymentReconciliation.ProcessNote> =
      PaymentReconciliation.ProcessNote.serializer()

    public val processNoteSer: KSerializer<List<PaymentReconciliation.ProcessNote>> =
      ListSerializer(Hoisted.processNoteSerInner)
  }
}

internal object PaymentReconciliationPolymorphicSerializer : KSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation") {
      PaymentReconciliationSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) {
      PaymentReconciliationSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) {
      PaymentReconciliationSerializer.deserializeInternal(this, descriptor, 0)
    }
}
