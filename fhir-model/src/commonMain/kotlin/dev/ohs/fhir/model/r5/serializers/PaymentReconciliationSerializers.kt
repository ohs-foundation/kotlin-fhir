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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PaymentReconciliation.Allocation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.identifierSer, null)
        4 ->
          predecessor =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.identifierSer, null)
        5 -> target = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.targetSer, null)
        6 -> targetItemString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _targetItemString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.targetItemStringSer, null)
        8 ->
          targetItemIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.identifierSer, null)
        9 -> targetItemPositiveInt = decoder.decodeIntElement(__desc, 9)
        10 ->
          _targetItemPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.targetItemStringSer, null)
        11 ->
          encounter = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.targetSer, null)
        12 ->
          account = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.targetSer, null)
        13 -> type = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.typeSer, null)
        14 ->
          submitter = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.targetSer, null)
        15 ->
          response = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.targetSer, null)
        16 -> date = decoder.decodeStringElement(__desc, 16)
        17 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.targetItemStringSer, null)
        18 ->
          responsible =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.targetSer, null)
        19 -> payee = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.targetSer, null)
        20 ->
          amount = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Allocation: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: PaymentReconciliation.Allocation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    (value.predecessor)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.identifierSer, it)
    }
    (value.target)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.targetSer, it) }
    when (val __d = value.targetItem) {
      null -> {}
      is PaymentReconciliation.Allocation.TargetItem.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.targetItemStringSer, it)
        }
      }
      is PaymentReconciliation.Allocation.TargetItem.Identifier -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.identifierSer, __d.value)
      }
      is PaymentReconciliation.Allocation.TargetItem.PositiveInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.targetItemStringSer, it)
        }
      }
    }
    (value.encounter)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.targetSer, it) }
    (value.account)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.targetSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.typeSer, it) }
    (value.submitter)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.targetSer, it) }
    (value.response)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.targetSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.targetItemStringSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.targetSer, it)
    }
    (value.payee)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.targetSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.amountSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PaymentReconciliation.ProcessNote {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> text = decoder.decodeStringElement(__desc, 5)
        6 -> _text = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: PaymentReconciliation.ProcessNote) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object PaymentReconciliationAllocationTargetItemSerializer :
  KSerializer<PaymentReconciliation.Allocation.TargetItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation.Allocation.TargetItem") {
      element("targetItemString", KotlinString.serializer().descriptor, isOptional = true)
      element("_targetItemString", Element.serializer().descriptor, isOptional = true)
      element("targetItemIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element("targetItemPositiveInt", Int.serializer().descriptor, isOptional = true)
      element("_targetItemPositiveInt", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation.TargetItem) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is PaymentReconciliation.Allocation.TargetItem.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is PaymentReconciliation.Allocation.TargetItem.Identifier -> {
          encodeSerializableElement(__desc, 2, Hoisted.targetItemIdentifierSer, __d.value)
        }
        is PaymentReconciliation.Allocation.TargetItem.PositiveInt -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 3, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 4, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation.TargetItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): PaymentReconciliation.Allocation.TargetItem {
    val __desc = descriptor
    var targetItemString: KotlinString? = null
    var _targetItemString: Element? = null
    var targetItemIdentifier: Identifier? = null
    var targetItemPositiveInt: Int? = null
    var _targetItemPositiveInt: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> targetItemString = decoder.decodeStringElement(__desc, 0)
        1 ->
          _targetItemString =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          targetItemIdentifier =
            decoder.decodeNullableSerializableElement(
              __desc,
              2,
              Hoisted.targetItemIdentifierSer,
              null,
            )
        3 -> targetItemPositiveInt = decoder.decodeIntElement(__desc, 3)
        4 ->
          _targetItemPositiveInt =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding PaymentReconciliation.Allocation.TargetItem: " + __i
          )
      }
    }
    return PaymentReconciliation.Allocation.TargetItem.from(
      R5String.of(targetItemString, _targetItemString),
      targetItemIdentifier,
      PositiveInt.of(targetItemPositiveInt, _targetItemPositiveInt),
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val targetItemIdentifierSer: KSerializer<Identifier> = Identifier.serializer()
  }
}

internal object PaymentReconciliationSerializer : KSerializer<PaymentReconciliation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentReconciliation") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("kind", CodeableConcept.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("enterer", Reference.serializer().descriptor, isOptional = true)
      element("issuerType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("paymentIssuer", Reference.serializer().descriptor, isOptional = true)
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("requestor", Reference.serializer().descriptor, isOptional = true)
      element("outcome", KotlinString.serializer().descriptor, isOptional = true)
      element("_outcome", Element.serializer().descriptor, isOptional = true)
      element("disposition", KotlinString.serializer().descriptor, isOptional = true)
      element("_disposition", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("location", Reference.serializer().descriptor, isOptional = true)
      element("method", CodeableConcept.serializer().descriptor, isOptional = true)
      element("cardBrand", KotlinString.serializer().descriptor, isOptional = true)
      element("_cardBrand", Element.serializer().descriptor, isOptional = true)
      element("accountNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_accountNumber", Element.serializer().descriptor, isOptional = true)
      element("expirationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_expirationDate", Element.serializer().descriptor, isOptional = true)
      element("processor", KotlinString.serializer().descriptor, isOptional = true)
      element("_processor", Element.serializer().descriptor, isOptional = true)
      element("referenceNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_referenceNumber", Element.serializer().descriptor, isOptional = true)
      element("authorization", KotlinString.serializer().descriptor, isOptional = true)
      element("_authorization", Element.serializer().descriptor, isOptional = true)
      element("tenderedAmount", Money.serializer().descriptor, isOptional = true)
      element("returnedAmount", Money.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
      element("paymentIdentifier", Identifier.serializer().descriptor, isOptional = true)
      element(
        "allocation",
        listSerialDescriptor(
          lazyDescriptor { PaymentReconciliation.Allocation.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("formCode", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "processNote",
        listSerialDescriptor(
          lazyDescriptor { PaymentReconciliation.ProcessNote.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): PaymentReconciliation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> type = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.typeSer, null)
        13 -> status = decoder.decodeStringElement(__desc, 13)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> kind = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.typeSer, null)
        16 ->
          period = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.periodSer, null)
        17 -> created = decoder.decodeStringElement(__desc, 17)
        18 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          enterer = decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.entererSer, null)
        20 ->
          issuerType = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.typeSer, null)
        21 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.entererSer, null)
        22 ->
          request = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.entererSer, null)
        23 ->
          requestor =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.entererSer, null)
        24 -> outcome = decoder.decodeStringElement(__desc, 24)
        25 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> disposition = decoder.decodeStringElement(__desc, 26)
        27 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> date = decoder.decodeStringElement(__desc, 28)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 ->
          location = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.entererSer, null)
        31 -> method = decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.typeSer, null)
        32 -> cardBrand = decoder.decodeStringElement(__desc, 32)
        33 ->
          _cardBrand =
            decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.implicitRulesSer, null)
        34 -> accountNumber = decoder.decodeStringElement(__desc, 34)
        35 ->
          _accountNumber =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.implicitRulesSer, null)
        36 -> expirationDate = decoder.decodeStringElement(__desc, 36)
        37 ->
          _expirationDate =
            decoder.decodeNullableSerializableElement(__desc, 37, Hoisted.implicitRulesSer, null)
        38 -> processor = decoder.decodeStringElement(__desc, 38)
        39 ->
          _processor =
            decoder.decodeNullableSerializableElement(__desc, 39, Hoisted.implicitRulesSer, null)
        40 -> referenceNumber = decoder.decodeStringElement(__desc, 40)
        41 ->
          _referenceNumber =
            decoder.decodeNullableSerializableElement(__desc, 41, Hoisted.implicitRulesSer, null)
        42 -> authorization = decoder.decodeStringElement(__desc, 42)
        43 ->
          _authorization =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.implicitRulesSer, null)
        44 ->
          tenderedAmount =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.tenderedAmountSer, null)
        45 ->
          returnedAmount =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.tenderedAmountSer, null)
        46 ->
          amount =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.tenderedAmountSer, null)
        47 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.identifierSerInner, null)
        48 ->
          allocation =
            decoder.decodeNullableSerializableElement(__desc, 48, Hoisted.allocationSer, null)
        49 ->
          formCode = decoder.decodeNullableSerializableElement(__desc, 49, Hoisted.typeSer, null)
        50 ->
          processNote =
            decoder.decodeNullableSerializableElement(__desc, 50, Hoisted.processNoteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding PaymentReconciliation: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: PaymentReconciliation) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "PaymentReconciliation")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.typeSer, it) }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    (value.kind)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.typeSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.periodSer, it) }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let { encoder.encodeSerializableElement(__desc, 19, Hoisted.entererSer, it) }
    (value.issuerType)?.let { encoder.encodeSerializableElement(__desc, 20, Hoisted.typeSer, it) }
    (value.paymentIssuer)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.entererSer, it)
    }
    (value.request)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.entererSer, it) }
    (value.requestor)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.entererSer, it) }
    ((value.outcome?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.outcome?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.date.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.date.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    (value.location)?.let { encoder.encodeSerializableElement(__desc, 30, Hoisted.entererSer, it) }
    (value.method)?.let { encoder.encodeSerializableElement(__desc, 31, Hoisted.typeSer, it) }
    ((value.cardBrand?.value))?.let { encoder.encodeStringElement(__desc, 32, it) }
    (value.cardBrand?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.implicitRulesSer, it)
    }
    ((value.accountNumber?.value))?.let { encoder.encodeStringElement(__desc, 34, it) }
    (value.accountNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35, Hoisted.implicitRulesSer, it)
    }
    ((value.expirationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 36, it) }
    (value.expirationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 37, Hoisted.implicitRulesSer, it)
    }
    ((value.processor?.value))?.let { encoder.encodeStringElement(__desc, 38, it) }
    (value.processor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 39, Hoisted.implicitRulesSer, it)
    }
    ((value.referenceNumber?.value))?.let { encoder.encodeStringElement(__desc, 40, it) }
    (value.referenceNumber?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 41, Hoisted.implicitRulesSer, it)
    }
    ((value.authorization?.value))?.let { encoder.encodeStringElement(__desc, 42, it) }
    (value.authorization?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.implicitRulesSer, it)
    }
    (value.tenderedAmount)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.tenderedAmountSer, it)
    }
    (value.returnedAmount)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.tenderedAmountSer, it)
    }
    (value.amount)?.let {
      encoder.encodeSerializableElement(__desc, 46, Hoisted.tenderedAmountSer, it)
    }
    (value.paymentIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 47, Hoisted.identifierSerInner, it)
    }
    if (value.allocation.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48, Hoisted.allocationSer, value.allocation)
    (value.formCode)?.let { encoder.encodeSerializableElement(__desc, 49, Hoisted.typeSer, it) }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50, Hoisted.processNoteSer, value.processNote)
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
