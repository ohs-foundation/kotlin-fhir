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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.PaymentReconciliation
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ClaimProcessingCodes
import dev.ohs.fhir.model.r4.terminologies.NoteType
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object PaymentReconciliationDetailSerializer : KSerializer<PaymentReconciliation.Detail> {
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("predecessor", Identifier.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("submitter", Reference.serializer().descriptor, isOptional = true)
      element("response", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("responsible", Reference.serializer().descriptor, isOptional = true)
      element("payee", Reference.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Detail =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Detail) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): PaymentReconciliation.Detail {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var predecessor: Identifier? = null
    var type: CodeableConcept? = null
    var request: Reference? = null
    var submitter: Reference? = null
    var response: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var responsible: Reference? = null
    var payee: Reference? = null
    var amount: Money? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 ->
          predecessor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          request = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        7 ->
          submitter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        8 ->
          response =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        9 -> date = decoder.decodeStringElement(__desc, __i)
        10 -> _date = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.dateSer, null)
        11 ->
          responsible =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        12 ->
          payee = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        13 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Detail: " + __i)
      }
    }
    return PaymentReconciliation.Detail(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      predecessor = predecessor,
      type = type!!,
      request = request,
      submitter = submitter,
      response = response,
      date = Date.of(FhirDate.fromString(date), _date),
      responsible = responsible,
      payee = payee,
      amount = amount,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: PaymentReconciliation.Detail) {
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
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    (value.request)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.requestSer, it) }
    (value.submitter)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.requestSer, it) }
    (value.response)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.requestSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.dateSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.requestSer, it)
    }
    (value.payee)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.requestSer, it) }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requestSer: KSerializer<Reference> = Reference.serializer()

    public val dateSer: KSerializer<Element> = Element.serializer()

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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, __i)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 -> text = decoder.decodeStringElement(__desc, __i)
        6 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ProcessNote: " + __i)
      }
    }
    return PaymentReconciliation.ProcessNote(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type?.let { Enumeration.of(NoteType.fromCode(it), _type) },
      text = R4String.of(text, _text),
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("paymentIssuer", Reference.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("requestor", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element("paymentDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_paymentDate", Element.serializer().descriptor, isOptional = true)
    b.element("paymentAmount", Money.serializer().descriptor, isOptional = true)
    b.element("paymentIdentifier", Identifier.serializer().descriptor, isOptional = true)
    b.element(
      "detail",
      listSerialDescriptor(lazyDescriptor { PaymentReconciliation.Detail.serializer().descriptor }),
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PaymentReconciliation")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): PaymentReconciliation {
    val __desc = desc
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
    var period: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var paymentIssuer: Reference? = null
    var request: Reference? = null
    var requestor: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var paymentDate: KotlinString? = null
    var _paymentDate: Element? = null
    var paymentAmount: Money? = null
    var paymentIdentifier: Identifier? = null
    var detail: List<PaymentReconciliation.Detail>? = null
    var formCode: CodeableConcept? = null
    var processNote: List<PaymentReconciliation.ProcessNote>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        14 -> created = decoder.decodeStringElement(__desc, __i)
        15 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        16 ->
          paymentIssuer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.paymentIssuerSer, null)
        17 ->
          request =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.paymentIssuerSer, null)
        18 ->
          requestor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.paymentIssuerSer, null)
        19 -> outcome = decoder.decodeStringElement(__desc, __i)
        20 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 -> disposition = decoder.decodeStringElement(__desc, __i)
        22 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        23 -> paymentDate = decoder.decodeStringElement(__desc, __i)
        24 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        25 ->
          paymentAmount =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.paymentAmountSer, null)
        26 ->
          paymentIdentifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSerInner, null)
        27 ->
          detail = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.detailSer, null)
        28 ->
          formCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.formCodeSer, null)
        29 ->
          processNote =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.processNoteSer, null)
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
      status =
        Enumeration.of(
          PaymentReconciliation.FinancialResourceStatusCodes.fromCode(status!!),
          _status,
        ),
      period = period,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      paymentIssuer = paymentIssuer,
      request = request,
      requestor = requestor,
      outcome = outcome?.let { Enumeration.of(ClaimProcessingCodes.fromCode(it), _outcome) },
      disposition = R4String.of(disposition, _disposition),
      paymentDate = Date.of(FhirDate.fromString(paymentDate), _paymentDate)!!,
      paymentAmount = paymentAmount!!,
      paymentIdentifier = paymentIdentifier,
      detail = detail ?: listOf(),
      formCode = formCode,
      processNote = processNote ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: PaymentReconciliation,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.periodSer, it)
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14 + __off, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.paymentIssuer)?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.paymentIssuerSer, it)
    }
    (value.request)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.paymentIssuerSer, it)
    }
    (value.requestor)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.paymentIssuerSer, it)
    }
    ((value.outcome?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.outcome?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 21 + __off, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.paymentDate.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 23 + __off, it)
    }
    (value.paymentDate.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.paymentAmount)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.paymentAmountSer, it)
    }
    (value.paymentIdentifier)?.let {
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.identifierSerInner, it)
    }
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.detailSer, value.detail)
    (value.formCode)?.let {
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.formCodeSer, it)
    }
    if (value.processNote.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        29 + __off,
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

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val paymentIssuerSer: KSerializer<Reference> = Reference.serializer()

    public val paymentAmountSer: KSerializer<Money> = Money.serializer()

    public val detailSerInner: KSerializer<PaymentReconciliation.Detail> =
      PaymentReconciliation.Detail.serializer()

    public val detailSer: KSerializer<List<PaymentReconciliation.Detail>> =
      ListSerializer(Hoisted.detailSerInner)

    public val formCodeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

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
      PaymentReconciliationSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    decoder.decodeStructure(descriptor) {
      PaymentReconciliationSerializer.deserializeJson(this, descriptor, 0)
    }
}
