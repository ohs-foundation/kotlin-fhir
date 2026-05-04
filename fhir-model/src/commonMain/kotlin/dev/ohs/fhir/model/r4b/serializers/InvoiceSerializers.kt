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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Invoice
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object InvoiceParticipantSerializer : KSerializer<Invoice.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
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
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
      element("actor", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Invoice.Participant =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Invoice.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Invoice.Participant {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var role: CodeableConcept? = null
    var actor: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> role = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.roleSer, null)
        4 -> actor = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.actorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return Invoice.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      role = role,
      actor = actor!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Invoice.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.roleSer, it) }
    (value.actor)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.actorSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val actorSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object InvoiceLineItemSerializer : KSerializer<Invoice.LineItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("LineItem") {
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
      element("chargeItemReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "chargeItemCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "priceComponent",
        listSerialDescriptor(
          lazyDescriptor { Invoice.LineItem.PriceComponent.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Invoice.LineItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Invoice.LineItem {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var chargeItemReference: Reference? = null
    var chargeItemCodeableConcept: CodeableConcept? = null
    var priceComponent: List<Invoice.LineItem.PriceComponent>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          chargeItemReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.chargeItemReferenceSer,
              null,
            )
        6 ->
          chargeItemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.chargeItemCodeableConceptSer,
              null,
            )
        7 ->
          priceComponent =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.priceComponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LineItem: " + __i)
      }
    }
    return Invoice.LineItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      chargeItem =
        Invoice.LineItem.ChargeItem.from(chargeItemReference, chargeItemCodeableConcept)!!,
      priceComponent = priceComponent ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Invoice.LineItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence?.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    when (val __d = value.chargeItem) {
      null -> {}
      is Invoice.LineItem.ChargeItem.Reference -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.chargeItemReferenceSer, __d.value)
      }
      is Invoice.LineItem.ChargeItem.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          6,
          Hoisted.chargeItemCodeableConceptSer,
          __d.value,
        )
      }
    }
    if (value.priceComponent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.priceComponentSer, value.priceComponent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val chargeItemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val chargeItemCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val priceComponentSerInner: KSerializer<Invoice.LineItem.PriceComponent> =
      Invoice.LineItem.PriceComponent.serializer()

    public val priceComponentSer: KSerializer<List<Invoice.LineItem.PriceComponent>> =
      ListSerializer(Hoisted.priceComponentSerInner)
  }
}

internal object InvoiceLineItemPriceComponentSerializer :
  KSerializer<Invoice.LineItem.PriceComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PriceComponent") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Invoice.LineItem.PriceComponent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.PriceComponent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Invoice.LineItem.PriceComponent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var code: CodeableConcept? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
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
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 6, BigDecimalSerializer, null)
        7 -> _factor = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 -> amount = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PriceComponent: " + __i)
      }
    }
    return Invoice.LineItem.PriceComponent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(Invoice.InvoicePriceComponentType.fromCode(type!!), _type),
      code = code,
      factor = Decimal.of(factor, _factor),
      amount = amount,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Invoice.LineItem.PriceComponent) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object InvoiceSerializer : KSerializer<Invoice> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Invoice") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("cancelledReason", KotlinString.serializer().descriptor, isOptional = true)
      element("_cancelledReason", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subject", Reference.serializer().descriptor, isOptional = true)
      element("recipient", Reference.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(lazyDescriptor { Invoice.Participant.serializer().descriptor }),
        isOptional = true,
      )
      element("issuer", Reference.serializer().descriptor, isOptional = true)
      element("account", Reference.serializer().descriptor, isOptional = true)
      element(
        "lineItem",
        listSerialDescriptor(lazyDescriptor { Invoice.LineItem.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "totalPriceComponent",
        listSerialDescriptor(
          lazyDescriptor { Invoice.LineItem.PriceComponent.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("totalNet", Money.serializer().descriptor, isOptional = true)
      element("totalGross", Money.serializer().descriptor, isOptional = true)
      element("paymentTerms", KotlinString.serializer().descriptor, isOptional = true)
      element("_paymentTerms", Element.serializer().descriptor, isOptional = true)
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Invoice =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Invoice) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Invoice {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var cancelledReason: KotlinString? = null
    var _cancelledReason: Element? = null
    var type: CodeableConcept? = null
    var subject: Reference? = null
    var recipient: Reference? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var participant: List<Invoice.Participant>? = null
    var issuer: Reference? = null
    var account: Reference? = null
    var lineItem: List<Invoice.LineItem>? = null
    var totalPriceComponent: List<Invoice.LineItem.PriceComponent>? = null
    var totalNet: Money? = null
    var totalGross: Money? = null
    var paymentTerms: KotlinString? = null
    var _paymentTerms: Element? = null
    var note: List<Annotation>? = null
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
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> cancelledReason = decoder.decodeStringElement(__desc, 14)
        15 ->
          _cancelledReason =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> type = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.typeSer, null)
        17 ->
          subject = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.subjectSer, null)
        18 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subjectSer, null)
        19 -> date = decoder.decodeStringElement(__desc, 19)
        20 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.participantSer, null)
        22 ->
          issuer = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.subjectSer, null)
        23 ->
          account = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.subjectSer, null)
        24 ->
          lineItem =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.lineItemSer, null)
        25 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              25,
              Hoisted.totalPriceComponentSer,
              null,
            )
        26 ->
          totalNet =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.totalNetSer, null)
        27 ->
          totalGross =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.totalNetSer, null)
        28 -> paymentTerms = decoder.decodeStringElement(__desc, 28)
        29 ->
          _paymentTerms =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> note = decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.noteSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Invoice: " + __i)
      }
    }
    return Invoice(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status = Enumeration.of(Invoice.InvoiceStatus.fromCode(status!!), _status),
      cancelledReason = R4bString.of(cancelledReason, _cancelledReason),
      type = type,
      subject = subject,
      recipient = recipient,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      participant = participant ?: listOf(),
      issuer = issuer,
      account = account,
      lineItem = lineItem ?: listOf(),
      totalPriceComponent = totalPriceComponent ?: listOf(),
      totalNet = totalNet,
      totalGross = totalGross,
      paymentTerms = Markdown.of(paymentTerms, _paymentTerms),
      note = note ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Invoice) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Invoice")
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
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.cancelledReason?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.cancelledReason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.typeSer, it) }
    (value.subject)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.subjectSer, it) }
    (value.recipient)?.let { encoder.encodeSerializableElement(__desc, 18, Hoisted.subjectSer, it) }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.participantSer, value.participant)
    (value.issuer)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.subjectSer, it) }
    (value.account)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.subjectSer, it) }
    if (value.lineItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.lineItemSer, value.lineItem)
    if (value.totalPriceComponent.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        25,
        Hoisted.totalPriceComponentSer,
        value.totalPriceComponent,
      )
    (value.totalNet)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.totalNetSer, it) }
    (value.totalGross)?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.totalNetSer, it)
    }
    ((value.paymentTerms?.value))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.paymentTerms?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 30, Hoisted.noteSer, value.note)
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

    public val subjectSer: KSerializer<Reference> = Reference.serializer()

    public val participantSerInner: KSerializer<Invoice.Participant> =
      Invoice.Participant.serializer()

    public val participantSer: KSerializer<List<Invoice.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val lineItemSerInner: KSerializer<Invoice.LineItem> = Invoice.LineItem.serializer()

    public val lineItemSer: KSerializer<List<Invoice.LineItem>> =
      ListSerializer(Hoisted.lineItemSerInner)

    public val totalPriceComponentSerInner: KSerializer<Invoice.LineItem.PriceComponent> =
      Invoice.LineItem.PriceComponent.serializer()

    public val totalPriceComponentSer: KSerializer<List<Invoice.LineItem.PriceComponent>> =
      ListSerializer(Hoisted.totalPriceComponentSerInner)

    public val totalNetSer: KSerializer<Money> = Money.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
