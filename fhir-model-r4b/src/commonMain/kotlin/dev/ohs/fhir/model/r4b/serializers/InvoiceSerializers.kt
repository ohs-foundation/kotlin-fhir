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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Invoice
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object InvoiceParticipantSerializer : KSerializer<Invoice.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
      optionalElement("actor", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Invoice.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Invoice.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var role: CodeableConcept? = null
      var actor: Reference? = null
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
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> actor = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      Invoice.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        role = role,
        actor =
          actor
            ?: throw SerializationException(
              "Missing required property 'actor' on Invoice.Participant"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.Participant) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.role)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.actor)
    }
  }
}

internal object InvoiceLineItemSerializer : KSerializer<Invoice.LineItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("LineItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("chargeItemReference", ReferenceSerializer.descriptor)
      optionalElement("chargeItemCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement(
        "priceComponent",
        InvoiceLineItemPriceComponentSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Invoice.LineItem>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Invoice.LineItem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var chargeItemReference: Reference? = null
      var chargeItemCodeableConcept: CodeableConcept? = null
      var priceComponent: List<Invoice.LineItem.PriceComponent>? = null
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
            chargeItemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            chargeItemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            priceComponent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InvoiceLineItemPriceComponentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding LineItem: " + i)
        }
      }
      Invoice.LineItem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence = PositiveInt.of(sequence, _sequence),
        chargeItem =
          Invoice.LineItem.ChargeItem.from(chargeItemReference, chargeItemCodeableConcept)
            ?: throw SerializationException(
              "Missing required property 'chargeItem' on Invoice.LineItem"
            ),
        priceComponent = priceComponent ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem) {
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
      when (val choice = value.chargeItem) {
        is Invoice.LineItem.ChargeItem.Reference -> {
          encodeSerializableElement(descriptor, 5, ReferenceSerializer, choice.value)
        }
        is Invoice.LineItem.ChargeItem.CodeableConcept -> {
          encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, choice.value)
        }
      }
      if (value.priceComponent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          InvoiceLineItemPriceComponentSerializer.listSerializer,
          value.priceComponent,
        )
    }
  }
}

internal object InvoiceLineItemPriceComponentSerializer :
  KSerializer<Invoice.LineItem.PriceComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PriceComponent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Invoice.LineItem.PriceComponent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Invoice.LineItem.PriceComponent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var code: CodeableConcept? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          7 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PriceComponent: " + i)
        }
      }
      Invoice.LineItem.PriceComponent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) Invoice.InvoicePriceComponentType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on Invoice.LineItem.PriceComponent"
            ),
        code = code,
        factor = Decimal.of(factor, _factor),
        amount = amount,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.PriceComponent) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 6, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 7, value.factor)
      encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.amount)
    }
  }
}

internal object InvoiceSerializer : FhirResourceSerializer<Invoice> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Invoice")

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
    b.optionalElement("cancelledReason", KotlinString.serializer().descriptor)
    b.optionalElement("_cancelledReason", ElementSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("recipient", ReferenceSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("participant", InvoiceParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("issuer", ReferenceSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.descriptor)
    b.optionalElement("lineItem", InvoiceLineItemSerializer.listSerializer.descriptor)
    b.optionalElement(
      "totalPriceComponent",
      InvoiceLineItemPriceComponentSerializer.listSerializer.descriptor,
    )
    b.optionalElement("totalNet", MoneySerializer.descriptor)
    b.optionalElement("totalGross", MoneySerializer.descriptor)
    b.optionalElement("paymentTerms", KotlinString.serializer().descriptor)
    b.optionalElement("_paymentTerms", ElementSerializer.descriptor)
    b.optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Invoice {
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
        13 -> cancelledReason = decoder.decodeStringElement(descriptor, i)
        14 ->
          _cancelledReason =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 ->
          recipient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> date = decoder.decodeStringElement(descriptor, i)
        19 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InvoiceParticipantSerializer.listSerializer,
              null,
            )
        21 ->
          issuer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          lineItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InvoiceLineItemSerializer.listSerializer,
              null,
            )
        24 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InvoiceLineItemPriceComponentSerializer.listSerializer,
              null,
            )
        25 ->
          totalNet = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        26 ->
          totalGross =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        27 -> paymentTerms = decoder.decodeStringElement(descriptor, i)
        28 ->
          _paymentTerms =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Invoice: " + i)
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
      status =
        Enumeration.of(
          if (status != null) Invoice.InvoiceStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Invoice"),
      cancelledReason = R4bString.of(cancelledReason, _cancelledReason),
      type = type,
      subject = subject,
      recipient = recipient,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Invoice,
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
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.cancelledReason?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.cancelledReason)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.recipient,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.date)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        InvoiceParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.issuer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.account,
    )
    if (value.lineItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        InvoiceLineItemSerializer.listSerializer,
        value.lineItem,
      )
    if (value.totalPriceComponent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        InvoiceLineItemPriceComponentSerializer.listSerializer,
        value.totalPriceComponent,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      MoneySerializer,
      value.totalNet,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      MoneySerializer,
      value.totalGross,
    )
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.paymentTerms?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.paymentTerms)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
