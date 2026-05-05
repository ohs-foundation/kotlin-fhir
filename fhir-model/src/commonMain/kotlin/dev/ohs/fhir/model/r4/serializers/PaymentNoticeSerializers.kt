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
import dev.ohs.fhir.model.r4.PaymentNotice
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.String
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

internal object PaymentNoticeSerializer : KSerializer<PaymentNotice> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentNotice") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
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
    b.element("status", String.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("response", Reference.serializer().descriptor, isOptional = true)
    b.element("created", String.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("provider", Reference.serializer().descriptor, isOptional = true)
    b.element("payment", Reference.serializer().descriptor, isOptional = true)
    b.element("paymentDate", String.serializer().descriptor, isOptional = true)
    b.element("_paymentDate", Element.serializer().descriptor, isOptional = true)
    b.element("payee", Reference.serializer().descriptor, isOptional = true)
    b.element("recipient", Reference.serializer().descriptor, isOptional = true)
    b.element("amount", Money.serializer().descriptor, isOptional = true)
    b.element("paymentStatus", CodeableConcept.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): PaymentNotice =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: PaymentNotice) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "PaymentNotice")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): PaymentNotice {
    val __desc = desc
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var status: String? = null
    var _status: Element? = null
    var request: Reference? = null
    var response: Reference? = null
    var created: String? = null
    var _created: Element? = null
    var provider: Reference? = null
    var payment: Reference? = null
    var paymentDate: String? = null
    var _paymentDate: Element? = null
    var payee: Reference? = null
    var recipient: Reference? = null
    var amount: Money? = null
    var paymentStatus: CodeableConcept? = null
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
          request = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        14 ->
          response =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        15 -> created = decoder.decodeStringElement(__desc, __i)
        16 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          provider =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        18 ->
          payment = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        19 -> paymentDate = decoder.decodeStringElement(__desc, __i)
        20 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          payee = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        22 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requestSer, null)
        23 ->
          amount = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.amountSer, null)
        24 ->
          paymentStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.paymentStatusSer, null)
        else -> throw SerializationException("Unexpected index decoding PaymentNotice: " + __i)
      }
    }
    return PaymentNotice(
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
        Enumeration.of(PaymentNotice.FinancialResourceStatusCodes.fromCode(status!!), _status),
      request = request,
      response = response,
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      provider = provider,
      payment = payment!!,
      paymentDate = Date.of(FhirDate.fromString(paymentDate), _paymentDate),
      payee = payee,
      recipient = recipient!!,
      amount = amount!!,
      paymentStatus = paymentStatus,
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: PaymentNotice,
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
    (value.request)?.let {
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.requestSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.requestSer, it)
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.provider)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.requestSer, it)
    }
    (value.payment)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.requestSer, it)
    }
    ((value.paymentDate?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 19 + __off, it)
    }
    (value.paymentDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.payee)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.requestSer, it)
    }
    (value.recipient)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.requestSer, it)
    }
    (value.amount)?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.amountSer, it)
    }
    (value.paymentStatus)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.paymentStatusSer, it)
    }
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

    public val requestSer: KSerializer<Reference> = Reference.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()

    public val paymentStatusSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object PaymentNoticePolymorphicSerializer : KSerializer<PaymentNotice> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentNotice") { PaymentNoticeSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: PaymentNotice) {
    encoder.encodeStructure(descriptor) {
      PaymentNoticeSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): PaymentNotice =
    decoder.decodeStructure(descriptor) {
      PaymentNoticeSerializer.deserializeJson(this, descriptor, 0)
    }
}
