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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubscriptionStatus
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

internal object SubscriptionStatusNotificationEventSerializer :
  KSerializer<SubscriptionStatus.NotificationEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotificationEvent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("eventNumber", KotlinString.serializer().descriptor)
      optionalElement("_eventNumber", ElementSerializer.descriptor)
      optionalElement("timestamp", KotlinString.serializer().descriptor)
      optionalElement("_timestamp", ElementSerializer.descriptor)
      optionalElement("focus", ReferenceSerializer.descriptor)
      optionalElement("additionalContext", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<SubscriptionStatus.NotificationEvent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): SubscriptionStatus.NotificationEvent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var eventNumber: KotlinString? = null
      var _eventNumber: Element? = null
      var timestamp: KotlinString? = null
      var _timestamp: Element? = null
      var focus: Reference? = null
      var additionalContext: List<Reference>? = null
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
          3 -> eventNumber = decodeStringElement(descriptor, i)
          4 ->
            _eventNumber = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> timestamp = decodeStringElement(descriptor, i)
          6 ->
            _timestamp = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> focus = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          8 ->
            additionalContext =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding NotificationEvent: " + i)
        }
      }
      SubscriptionStatus.NotificationEvent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        eventNumber =
          R4bString.of(eventNumber, _eventNumber)
            ?: throw SerializationException(
              "Missing required property 'eventNumber' on SubscriptionStatus.NotificationEvent"
            ),
        timestamp =
          Instant.of(
            if (timestamp != null) FhirDateTime.fromString(timestamp) else null,
            _timestamp,
          ),
        focus = focus,
        additionalContext = additionalContext ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus.NotificationEvent) {
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
      encodeStringIfNotNull(descriptor, 3, value.eventNumber.value)
      encodeElementIfNotNull(descriptor, 4, value.eventNumber)
      encodeStringIfNotNull(descriptor, 5, value.timestamp?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.timestamp)
      encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.focus)
      if (value.additionalContext.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ReferenceSerializer.listSerializer,
          value.additionalContext,
        )
    }
  }
}

internal object SubscriptionStatusSerializer : FhirResourceSerializer<SubscriptionStatus> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("SubscriptionStatus")

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
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("eventsSinceSubscriptionStart", KotlinString.serializer().descriptor)
    b.optionalElement("_eventsSinceSubscriptionStart", ElementSerializer.descriptor)
    b.optionalElement(
      "notificationEvent",
      SubscriptionStatusNotificationEventSerializer.listSerializer.descriptor,
    )
    b.optionalElement("subscription", ReferenceSerializer.descriptor)
    b.optionalElement("topic", KotlinString.serializer().descriptor)
    b.optionalElement("_topic", ElementSerializer.descriptor)
    b.optionalElement("error", CodeableConceptSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): SubscriptionStatus {
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
    var type: KotlinString? = null
    var _type: Element? = null
    var eventsSinceSubscriptionStart: KotlinString? = null
    var _eventsSinceSubscriptionStart: Element? = null
    var notificationEvent: List<SubscriptionStatus.NotificationEvent>? = null
    var subscription: Reference? = null
    var topic: KotlinString? = null
    var _topic: Element? = null
    var error: List<CodeableConcept>? = null
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
        12 -> type = decoder.decodeStringElement(descriptor, i)
        13 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> eventsSinceSubscriptionStart = decoder.decodeStringElement(descriptor, i)
        15 ->
          _eventsSinceSubscriptionStart =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          notificationEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionStatusNotificationEventSerializer.listSerializer,
              null,
            )
        17 ->
          subscription =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 -> topic = decoder.decodeStringElement(descriptor, i)
        19 ->
          _topic = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          error =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding SubscriptionStatus: " + i)
      }
    }
    return SubscriptionStatus(
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
          if (status != null) SubscriptionStatus.SubscriptionStatusCodes.fromCode(status) else null,
          _status,
        ),
      type =
        Enumeration.of(
          if (type != null) SubscriptionStatus.SubscriptionNotificationType.fromCode(type)
          else null,
          _type,
        ) ?: throw SerializationException("Missing required property 'type' on SubscriptionStatus"),
      eventsSinceSubscriptionStart =
        R4bString.of(eventsSinceSubscriptionStart, _eventsSinceSubscriptionStart),
      notificationEvent = notificationEvent ?: listOf(),
      subscription =
        subscription
          ?: throw SerializationException(
            "Missing required property 'subscription' on SubscriptionStatus"
          ),
      topic = Canonical.of(topic, _topic),
      error = error ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubscriptionStatus,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 12 + descriptorOffset, value.type.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.type)
    encoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.eventsSinceSubscriptionStart?.value,
    )
    encoder.encodeElementIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.eventsSinceSubscriptionStart,
    )
    if (value.notificationEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SubscriptionStatusNotificationEventSerializer.listSerializer,
        value.notificationEvent,
      )
    encoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subscription,
    )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.topic?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.topic)
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.error,
      )
  }
}
