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

import dev.ohs.fhir.model.r5.Annotation
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
import dev.ohs.fhir.model.r5.Invoice
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.MonetaryComponent
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
      optionalElement("servicedDate", KotlinString.serializer().descriptor)
      optionalElement("_servicedDate", ElementSerializer.descriptor)
      optionalElement("servicedPeriod", PeriodSerializer.descriptor)
      optionalElement("chargeItemReference", ReferenceSerializer.descriptor)
      optionalElement("chargeItemCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("priceComponent", MonetaryComponentSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Invoice.LineItem>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Invoice.LineItem =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var servicedDate: KotlinString? = null
      var _servicedDate: Element? = null
      var servicedPeriod: Period? = null
      var chargeItemReference: Reference? = null
      var chargeItemCodeableConcept: CodeableConcept? = null
      var priceComponent: List<MonetaryComponent>? = null
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
          5 -> servicedDate = decodeStringElement(descriptor, i)
          6 ->
            _servicedDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            servicedPeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          8 ->
            chargeItemReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            chargeItemCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            priceComponent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MonetaryComponentSerializer.listSerializer,
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
        serviced =
          Invoice.LineItem.Serviced.from(
            Date.of(
              if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
              _servicedDate,
            ),
            servicedPeriod,
          ),
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
      when (val choice = value.serviced) {
        null -> {}
        is Invoice.LineItem.Serviced.Date -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Invoice.LineItem.Serviced.Period -> {
          encodeSerializableElement(descriptor, 7, PeriodSerializer, choice.value)
        }
      }
      when (val choice = value.chargeItem) {
        is Invoice.LineItem.ChargeItem.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
        is Invoice.LineItem.ChargeItem.CodeableConcept -> {
          encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, choice.value)
        }
      }
      if (value.priceComponent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          MonetaryComponentSerializer.listSerializer,
          value.priceComponent,
        )
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
    b.optionalElement("creation", KotlinString.serializer().descriptor)
    b.optionalElement("_creation", ElementSerializer.descriptor)
    b.optionalElement("periodDate", KotlinString.serializer().descriptor)
    b.optionalElement("_periodDate", ElementSerializer.descriptor)
    b.optionalElement("periodPeriod", PeriodSerializer.descriptor)
    b.optionalElement("participant", InvoiceParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("issuer", ReferenceSerializer.descriptor)
    b.optionalElement("account", ReferenceSerializer.descriptor)
    b.optionalElement("lineItem", InvoiceLineItemSerializer.listSerializer.descriptor)
    b.optionalElement("totalPriceComponent", MonetaryComponentSerializer.listSerializer.descriptor)
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
    var creation: KotlinString? = null
    var _creation: Element? = null
    var periodDate: KotlinString? = null
    var _periodDate: Element? = null
    var periodPeriod: Period? = null
    var participant: List<Invoice.Participant>? = null
    var issuer: Reference? = null
    var account: Reference? = null
    var lineItem: List<Invoice.LineItem>? = null
    var totalPriceComponent: List<MonetaryComponent>? = null
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
        20 -> creation = decoder.decodeStringElement(descriptor, i)
        21 ->
          _creation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> periodDate = decoder.decodeStringElement(descriptor, i)
        23 ->
          _periodDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          periodPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        25 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InvoiceParticipantSerializer.listSerializer,
              null,
            )
        26 ->
          issuer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        27 ->
          account =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          lineItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InvoiceLineItemSerializer.listSerializer,
              null,
            )
        29 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MonetaryComponentSerializer.listSerializer,
              null,
            )
        30 ->
          totalNet = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        31 ->
          totalGross =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        32 -> paymentTerms = decoder.decodeStringElement(descriptor, i)
        33 ->
          _paymentTerms =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
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
      cancelledReason = R5String.of(cancelledReason, _cancelledReason),
      type = type,
      subject = subject,
      recipient = recipient,
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      creation =
        DateTime.of(if (creation != null) FhirDateTime.fromString(creation) else null, _creation),
      period =
        Invoice.Period.from(
          Date.of(if (periodDate != null) FhirDate.fromString(periodDate) else null, _periodDate),
          periodPeriod,
        ),
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
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.creation?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.creation)
    when (val choice = value.period) {
      null -> {}
      is Invoice.Period.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          22 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, choice.value)
      }
      is Invoice.Period.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          24 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        InvoiceParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      ReferenceSerializer,
      value.issuer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.account,
    )
    if (value.lineItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        InvoiceLineItemSerializer.listSerializer,
        value.lineItem,
      )
    if (value.totalPriceComponent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        MonetaryComponentSerializer.listSerializer,
        value.totalPriceComponent,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      30 + descriptorOffset,
      MoneySerializer,
      value.totalNet,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      MoneySerializer,
      value.totalGross,
    )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.paymentTerms?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.paymentTerms)
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        AnnotationSerializer.listSerializer,
        value.note,
      )
  }
}
