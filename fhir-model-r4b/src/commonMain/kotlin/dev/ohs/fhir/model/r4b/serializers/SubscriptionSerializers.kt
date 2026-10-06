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

import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Subscription
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.Url
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

internal object SubscriptionChannelSerializer : KSerializer<Subscription.Channel> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Channel") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("endpoint", KotlinString.serializer().descriptor)
      optionalElement("_endpoint", ElementSerializer.descriptor)
      optionalElement("payload", KotlinString.serializer().descriptor)
      optionalElement("_payload", ElementSerializer.descriptor)
      optionalElement("header", stringNullableListSerializer.descriptor)
      optionalElement("_header", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Subscription.Channel>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Subscription.Channel =
    decoder.decodeStructure(descriptor) {
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
          5 -> endpoint = decodeStringElement(descriptor, i)
          6 -> _endpoint = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> payload = decodeStringElement(descriptor, i)
          8 -> _payload = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            `header` =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          10 ->
            _header =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Channel: " + i)
        }
      }
      Subscription.Channel(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) Subscription.SubscriptionChannelType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on Subscription.Channel"
            ),
        endpoint = Url.of(endpoint, _endpoint),
        payload = Code.of(payload, _payload),
        `header` =
          (kotlin.collections.List(maxOf(`header`?.size ?: 0, _header?.size ?: 0)) { index ->
            R4bString.of(`header`?.getOrNull(index), _header?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'header' on Subscription.Channel has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Subscription.Channel) {
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
      encodeStringIfNotNull(descriptor, 5, value.endpoint?.value)
      encodeElementIfNotNull(descriptor, 6, value.endpoint)
      encodeStringIfNotNull(descriptor, 7, value.payload?.value)
      encodeElementIfNotNull(descriptor, 8, value.payload)
      if (value.`header`.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          9,
          stringNullableListSerializer,
          value.`header`.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 10, value.`header`)
      }
    }
  }
}

internal object SubscriptionSerializer : FhirResourceSerializer<Subscription> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Subscription")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("end", KotlinString.serializer().descriptor)
    b.optionalElement("_end", ElementSerializer.descriptor)
    b.optionalElement("reason", KotlinString.serializer().descriptor)
    b.optionalElement("_reason", ElementSerializer.descriptor)
    b.optionalElement("criteria", KotlinString.serializer().descriptor)
    b.optionalElement("_criteria", ElementSerializer.descriptor)
    b.optionalElement("error", KotlinString.serializer().descriptor)
    b.optionalElement("_error", ElementSerializer.descriptor)
    b.optionalElement("channel", SubscriptionChannelSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        10 -> status = decoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        13 -> end = decoder.decodeStringElement(descriptor, i)
        14 ->
          _end = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> reason = decoder.decodeStringElement(descriptor, i)
        16 ->
          _reason =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> criteria = decoder.decodeStringElement(descriptor, i)
        18 ->
          _criteria =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 -> error = decoder.decodeStringElement(descriptor, i)
        20 ->
          _error = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          channel =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionChannelSerializer,
              null,
            )
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
          if (status != null) Subscription.SubscriptionStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Subscription"),
      contact = contact ?: listOf(),
      end = Instant.of(if (end != null) FhirDateTime.fromString(end) else null, _end),
      reason =
        R4bString.of(reason, _reason)
          ?: throw SerializationException("Missing required property 'reason' on Subscription"),
      criteria =
        R4bString.of(criteria, _criteria)
          ?: throw SerializationException("Missing required property 'criteria' on Subscription"),
      error = R4bString.of(error, _error),
      channel =
        channel
          ?: throw SerializationException("Missing required property 'channel' on Subscription"),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Subscription,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.status)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.end?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.end)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.reason.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.reason)
    encoder.encodeStringIfNotNull(descriptor, 17 + descriptorOffset, value.criteria.value)
    encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.criteria)
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.error?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.error)
    encoder.encodeSerializableElement(
      descriptor,
      21 + descriptorOffset,
      SubscriptionChannelSerializer,
      value.channel,
    )
  }
}
