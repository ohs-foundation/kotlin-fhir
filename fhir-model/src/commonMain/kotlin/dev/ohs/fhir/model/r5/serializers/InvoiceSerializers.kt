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
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("chargeItemReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "chargeItemCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element(
        "priceComponent",
        listSerialDescriptor(MonetaryComponent.serializer().descriptor),
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
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var chargeItemReference: Reference? = null
    var chargeItemCodeableConcept: CodeableConcept? = null
    var priceComponent: List<MonetaryComponent>? = null
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
        5 -> servicedDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.sequenceSer, null)
        7 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.servicedPeriodSer, null)
        8 ->
          chargeItemReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.chargeItemReferenceSer,
              null,
            )
        9 ->
          chargeItemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              9,
              Hoisted.chargeItemCodeableConceptSer,
              null,
            )
        10 ->
          priceComponent =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.priceComponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding LineItem: " + __i)
      }
    }
    return Invoice.LineItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence),
      serviced =
        Invoice.LineItem.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
          servicedPeriod,
        ),
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
    when (val __d = value.serviced) {
      null -> {}
      is Invoice.LineItem.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.sequenceSer, it)
        }
      }
      is Invoice.LineItem.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    when (val __d = value.chargeItem) {
      null -> {}
      is Invoice.LineItem.ChargeItem.Reference -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.chargeItemReferenceSer, __d.value)
      }
      is Invoice.LineItem.ChargeItem.CodeableConcept -> {
        encoder.encodeSerializableElement(
          __desc,
          9,
          Hoisted.chargeItemCodeableConceptSer,
          __d.value,
        )
      }
    }
    if (value.priceComponent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.priceComponentSer, value.priceComponent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val chargeItemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val chargeItemCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val priceComponentSerInner: KSerializer<MonetaryComponent> =
      MonetaryComponent.serializer()

    public val priceComponentSer: KSerializer<List<MonetaryComponent>> =
      ListSerializer(Hoisted.priceComponentSerInner)
  }
}

internal object InvoicePeriodSerializer : KSerializer<Invoice.Period> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Invoice.Period") {
      element("periodDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_periodDate", Element.serializer().descriptor, isOptional = true)
      element("periodPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.Period) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Invoice.Period.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Invoice.Period.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.periodPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Invoice.Period =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Invoice.Period {
    val __desc = descriptor
    var periodDate: KotlinString? = null
    var _periodDate: Element? = null
    var periodPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> periodDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _periodDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          periodPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.periodPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Invoice.Period: " + __i)
      }
    }
    return Invoice.Period.from(
      Date.of(FhirDate.fromString(periodDate), _periodDate),
      periodPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val periodPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object InvoiceLineItemServicedSerializer : KSerializer<Invoice.LineItem.Serviced> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Invoice.LineItem.Serviced") {
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.Serviced) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Invoice.LineItem.Serviced.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Invoice.LineItem.Serviced.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Invoice.LineItem.Serviced =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Invoice.LineItem.Serviced {
    val __desc = descriptor
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> servicedDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Invoice.LineItem.Serviced: " + __i
          )
      }
    }
    return Invoice.LineItem.Serviced.from(
      Date.of(FhirDate.fromString(servicedDate), _servicedDate),
      servicedPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object InvoiceLineItemChargeItemSerializer : KSerializer<Invoice.LineItem.ChargeItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Invoice.LineItem.ChargeItem") {
      element("chargeItemReference", Reference.serializer().descriptor, isOptional = true)
      element(
        "chargeItemCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.ChargeItem) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Invoice.LineItem.ChargeItem.Reference -> {
          encodeSerializableElement(__desc, 0, Hoisted.chargeItemReferenceSer, __d.value)
        }
        is Invoice.LineItem.ChargeItem.CodeableConcept -> {
          encodeSerializableElement(__desc, 1, Hoisted.chargeItemCodeableConceptSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Invoice.LineItem.ChargeItem =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Invoice.LineItem.ChargeItem {
    val __desc = descriptor
    var chargeItemReference: Reference? = null
    var chargeItemCodeableConcept: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          chargeItemReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.chargeItemReferenceSer,
              null,
            )
        1 ->
          chargeItemCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.chargeItemCodeableConceptSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Invoice.LineItem.ChargeItem: " + __i
          )
      }
    }
    return Invoice.LineItem.ChargeItem.from(chargeItemReference, chargeItemCodeableConcept)!!
  }

  private object Hoisted {
    public val chargeItemReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val chargeItemCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()
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
      element("creation", KotlinString.serializer().descriptor, isOptional = true)
      element("_creation", Element.serializer().descriptor, isOptional = true)
      element("periodDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_periodDate", Element.serializer().descriptor, isOptional = true)
      element("periodPeriod", Period.serializer().descriptor, isOptional = true)
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
        listSerialDescriptor(MonetaryComponent.serializer().descriptor),
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
        21 -> creation = decoder.decodeStringElement(__desc, 21)
        22 ->
          _creation =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> periodDate = decoder.decodeStringElement(__desc, 23)
        24 ->
          _periodDate =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          periodPeriod =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.periodPeriodSer, null)
        26 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.participantSer, null)
        27 ->
          issuer = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.subjectSer, null)
        28 ->
          account = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.subjectSer, null)
        29 ->
          lineItem =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.lineItemSer, null)
        30 ->
          totalPriceComponent =
            decoder.decodeNullableSerializableElement(
              __desc,
              30,
              Hoisted.totalPriceComponentSer,
              null,
            )
        31 ->
          totalNet =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.totalNetSer, null)
        32 ->
          totalGross =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.totalNetSer, null)
        33 -> paymentTerms = decoder.decodeStringElement(__desc, 33)
        34 ->
          _paymentTerms =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> note = decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.noteSer, null)
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
      cancelledReason = R5String.of(cancelledReason, _cancelledReason),
      type = type,
      subject = subject,
      recipient = recipient,
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      creation = DateTime.of(FhirDateTime.fromString(creation), _creation),
      period =
        Invoice.Period.from(Date.of(FhirDate.fromString(periodDate), _periodDate), periodPeriod),
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
    ((value.creation?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.creation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    when (val __d = value.period) {
      null -> {}
      is Invoice.Period.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
        }
      }
      is Invoice.Period.Period -> {
        encoder.encodeSerializableElement(__desc, 25, Hoisted.periodPeriodSer, __d.value)
      }
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.participantSer, value.participant)
    (value.issuer)?.let { encoder.encodeSerializableElement(__desc, 27, Hoisted.subjectSer, it) }
    (value.account)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.subjectSer, it) }
    if (value.lineItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.lineItemSer, value.lineItem)
    if (value.totalPriceComponent.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        30,
        Hoisted.totalPriceComponentSer,
        value.totalPriceComponent,
      )
    (value.totalNet)?.let { encoder.encodeSerializableElement(__desc, 31, Hoisted.totalNetSer, it) }
    (value.totalGross)?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.totalNetSer, it)
    }
    ((value.paymentTerms?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.paymentTerms?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.noteSer, value.note)
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

    public val periodPeriodSer: KSerializer<Period> = Period.serializer()

    public val participantSerInner: KSerializer<Invoice.Participant> =
      Invoice.Participant.serializer()

    public val participantSer: KSerializer<List<Invoice.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val lineItemSerInner: KSerializer<Invoice.LineItem> = Invoice.LineItem.serializer()

    public val lineItemSer: KSerializer<List<Invoice.LineItem>> =
      ListSerializer(Hoisted.lineItemSerInner)

    public val totalPriceComponentSerInner: KSerializer<MonetaryComponent> =
      MonetaryComponent.serializer()

    public val totalPriceComponentSer: KSerializer<List<MonetaryComponent>> =
      ListSerializer(Hoisted.totalPriceComponentSerInner)

    public val totalNetSer: KSerializer<Money> = Money.serializer()

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)
  }
}
