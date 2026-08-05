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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Subscription
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.Url
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object SubscriptionChannelSerializer : KSerializer<Subscription.Channel> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Channel") {
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
      element("endpoint", KotlinString.serializer().descriptor, isOptional = true)
      element("_endpoint", Element.serializer().descriptor, isOptional = true)
      element("payload", KotlinString.serializer().descriptor, isOptional = true)
      element("_payload", Element.serializer().descriptor, isOptional = true)
      element(
        "header",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_header", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Subscription.Channel =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Subscription.Channel) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Subscription.Channel {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var endpoint: KotlinString? = null
    var _endpoint: Element? = null
    var payload: KotlinString? = null
    var _payload: Element? = null
    var `header`: List<KotlinString?>? = null
    var _header: List<Element?>? = null
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
        5 -> endpoint = decoder.decodeStringElement(descriptor, i)
        6 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> payload = decoder.decodeStringElement(descriptor, i)
        8 ->
          _payload = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        9 ->
          `header` =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.headerSer, null)
        10 ->
          _header =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.headerSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Channel: " + i)
      }
    }
    return Subscription.Channel(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(
          Subscription.SubscriptionChannelType.fromCode(
            type
              ?: throw SerializationException(
                "Missing required property 'type' on Subscription.Channel"
              )
          ),
          _type,
        ),
      endpoint = Url.of(endpoint, _endpoint),
      payload = Code.of(payload, _payload),
      `header` =
        (kotlin.collections.List(maxOf(`header`?.size ?: 0, _header?.size ?: 0)) { index ->
          R4String.of(`header`?.getOrNull(index)?.let { it }, _header?.getOrNull(index))!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Subscription.Channel) {
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
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.endpoint?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.endpoint?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    ((value.payload?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.payload?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
    (value.`header`.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.headerSer, it)
    }
    (value.`header`.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.headerSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val headerSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val headerSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.headerSerInner).nullable)

    public val headerSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.typeSer).nullable)
  }
}

internal object SubscriptionSerializer : KSerializer<Subscription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subscription") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("end", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_end", Element.serializer().descriptor, isOptional = true)
    b.element("reason", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_reason", Element.serializer().descriptor, isOptional = true)
    b.element("criteria", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_criteria", Element.serializer().descriptor, isOptional = true)
    b.element("error", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_error", Element.serializer().descriptor, isOptional = true)
    b.element(
      "channel",
      lazyDescriptor { Subscription.Channel.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Subscription =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Subscription) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Subscription")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Subscription {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var contact: List<ContactPoint>? = null
    var end: KotlinString? = null
    var _end: Element? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
    var criteria: KotlinString? = null
    var _criteria: Element? = null
    var error: KotlinString? = null
    var _error: Element? = null
    var channel: Subscription.Channel? = null
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
        10 -> status = decoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        13 -> end = decoder.decodeStringElement(descriptor, i)
        14 ->
          _end =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> reason = decoder.decodeStringElement(descriptor, i)
        16 ->
          _reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> criteria = decoder.decodeStringElement(descriptor, i)
        18 ->
          _criteria =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 -> error = decoder.decodeStringElement(descriptor, i)
        20 ->
          _error =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          channel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.channelSer, null)
        else -> throw SerializationException("Unexpected index decoding Subscription: " + i)
      }
    }
    return Subscription(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        Enumeration.of(
          Subscription.SubscriptionStatus.fromCode(
            status
              ?: throw SerializationException("Missing required property 'status' on Subscription")
          ),
          _status,
        ),
      contact = contact ?: listOf(),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      reason =
        R4String.of(reason, _reason)
          ?: throw SerializationException("Missing required property 'reason' on Subscription"),
      criteria =
        R4String.of(criteria, _criteria)
          ?: throw SerializationException("Missing required property 'criteria' on Subscription"),
      error = R4String.of(error, _error),
      channel =
        channel
          ?: throw SerializationException("Missing required property 'channel' on Subscription"),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Subscription,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.end?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.reason.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.reason.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.criteria.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.criteria.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.error?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.error?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      21 + descriptorOffset,
      Hoisted.channelSer,
      value.channel,
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

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val channelSer: KSerializer<Subscription.Channel> = Subscription.Channel.serializer()
  }
}

internal object SubscriptionPolymorphicSerializer : KSerializer<Subscription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subscription") { SubscriptionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Subscription) {
    encoder.encodeStructure(descriptor) {
      SubscriptionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Subscription =
    decoder.decodeStructure(descriptor) {
      SubscriptionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
