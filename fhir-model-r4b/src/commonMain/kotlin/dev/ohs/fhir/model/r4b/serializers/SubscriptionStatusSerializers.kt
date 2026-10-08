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
import dev.ohs.fhir.model.r4b.terminologies.SubscriptionNotificationType
import dev.ohs.fhir.model.r4b.terminologies.SubscriptionStatusCodes
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

  override fun deserialize(decoder: Decoder): SubscriptionStatus.NotificationEvent {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> eventNumber = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _eventNumber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> timestamp = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _timestamp =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          focus =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        8 ->
          additionalContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotificationEvent: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return SubscriptionStatus.NotificationEvent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      eventNumber =
        R4bString.of(eventNumber, _eventNumber)
          ?: throw SerializationException(
            "Missing required property 'eventNumber' on SubscriptionStatus.NotificationEvent"
          ),
      timestamp =
        Instant.of(if (timestamp != null) FhirDateTime.fromString(timestamp) else null, _timestamp),
      focus = focus,
      additionalContext = additionalContext ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus.NotificationEvent) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.eventNumber.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.eventNumber)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.timestamp?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.timestamp)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 7, ReferenceSerializer, value.focus)
    if (value.additionalContext.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8,
        ReferenceSerializer.listSerializer,
        value.additionalContext,
      )
    compositeEncoder.endStructure(descriptor)
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
    compositeDecoder: CompositeDecoder,
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
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        13 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> eventsSinceSubscriptionStart = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _eventsSinceSubscriptionStart =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        16 ->
          notificationEvent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionStatusNotificationEventSerializer.listSerializer,
              null,
            )
        17 ->
          subscription =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 -> topic = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          error =
            compositeDecoder.decodeNullableSerializableElement(
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
          if (status != null) SubscriptionStatusCodes.fromCode(status) else null,
          _status,
        ),
      type =
        Enumeration.of(
          if (type != null) SubscriptionNotificationType.fromCode(type) else null,
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
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubscriptionStatus,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      10 + descriptorOffset,
      value.status?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      12 + descriptorOffset,
      value.type.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 13 + descriptorOffset, value.type)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      14 + descriptorOffset,
      value.eventsSinceSubscriptionStart?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.eventsSinceSubscriptionStart,
    )
    if (value.notificationEvent.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        SubscriptionStatusNotificationEventSerializer.listSerializer,
        value.notificationEvent,
      )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subscription,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.topic?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.topic)
    if (value.error.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.error,
      )
  }
}
