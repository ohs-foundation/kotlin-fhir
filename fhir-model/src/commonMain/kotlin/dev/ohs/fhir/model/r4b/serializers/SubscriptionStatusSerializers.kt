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

import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.SubscriptionStatus
import dev.ohs.fhir.model.r4b.Uri
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

internal object SubscriptionStatusNotificationEventSerializer :
  KSerializer<SubscriptionStatus.NotificationEvent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("NotificationEvent") {
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
      element("eventNumber", KotlinString.serializer().descriptor, isOptional = true)
      element("_eventNumber", Element.serializer().descriptor, isOptional = true)
      element("timestamp", KotlinString.serializer().descriptor, isOptional = true)
      element("_timestamp", Element.serializer().descriptor, isOptional = true)
      element("focus", Reference.serializer().descriptor, isOptional = true)
      element(
        "additionalContext",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubscriptionStatus.NotificationEvent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus.NotificationEvent) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): SubscriptionStatus.NotificationEvent {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> eventNumber = decoder.decodeStringElement(__desc, 3)
        4 ->
          _eventNumber =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.eventNumberSer, null)
        5 -> timestamp = decoder.decodeStringElement(__desc, 5)
        6 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.eventNumberSer, null)
        7 -> focus = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.focusSer, null)
        8 ->
          additionalContext =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.additionalContextSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotificationEvent: " + __i)
      }
    }
    return SubscriptionStatus.NotificationEvent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      eventNumber = R4bString.of(eventNumber, _eventNumber)!!,
      timestamp = Instant.of(FhirDateTime.fromString(timestamp), _timestamp),
      focus = focus,
      additionalContext = additionalContext ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: SubscriptionStatus.NotificationEvent,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.eventNumber.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.eventNumber.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.eventNumberSer, it)
    }
    ((value.timestamp?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.timestamp?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.eventNumberSer, it)
    }
    (value.focus)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.focusSer, it) }
    if (value.additionalContext.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        8,
        Hoisted.additionalContextSer,
        value.additionalContext,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val eventNumberSer: KSerializer<Element> = Element.serializer()

    public val focusSer: KSerializer<Reference> = Reference.serializer()

    public val additionalContextSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.focusSer)
  }
}

internal object SubscriptionStatusSerializer : KSerializer<SubscriptionStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubscriptionStatus") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "eventsSinceSubscriptionStart",
        KotlinString.serializer().descriptor,
        isOptional = true,
      )
      element("_eventsSinceSubscriptionStart", Element.serializer().descriptor, isOptional = true)
      element(
        "notificationEvent",
        listSerialDescriptor(
          lazyDescriptor { SubscriptionStatus.NotificationEvent.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("subscription", Reference.serializer().descriptor, isOptional = true)
      element("topic", KotlinString.serializer().descriptor, isOptional = true)
      element("_topic", Element.serializer().descriptor, isOptional = true)
      element(
        "error",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): SubscriptionStatus =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): SubscriptionStatus {
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
        11 -> status = decoder.decodeStringElement(__desc, 11)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 -> type = decoder.decodeStringElement(__desc, 13)
        14 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.implicitRulesSer, null)
        15 -> eventsSinceSubscriptionStart = decoder.decodeStringElement(__desc, 15)
        16 ->
          _eventsSinceSubscriptionStart =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.implicitRulesSer, null)
        17 ->
          notificationEvent =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.notificationEventSer,
              null,
            )
        18 ->
          subscription =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.subscriptionSer, null)
        19 -> topic = decoder.decodeStringElement(__desc, 19)
        20 ->
          _topic =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> error = decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.errorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SubscriptionStatus: " + __i)
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
        status?.let {
          Enumeration.of(SubscriptionStatus.SubscriptionStatusCodes.fromCode(it), _status)
        },
      type =
        Enumeration.of(SubscriptionStatus.SubscriptionNotificationType.fromCode(type!!), _type),
      eventsSinceSubscriptionStart =
        R4bString.of(eventsSinceSubscriptionStart, _eventsSinceSubscriptionStart),
      notificationEvent = notificationEvent ?: listOf(),
      subscription = subscription!!,
      topic = Canonical.of(topic, _topic),
      error = error ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: SubscriptionStatus) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "SubscriptionStatus")
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
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.implicitRulesSer, it)
    }
    ((value.eventsSinceSubscriptionStart?.value))?.let {
      encoder.encodeStringElement(__desc, 15, it)
    }
    (value.eventsSinceSubscriptionStart?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.implicitRulesSer, it)
    }
    if (value.notificationEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        17,
        Hoisted.notificationEventSer,
        value.notificationEvent,
      )
    (value.subscription)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.subscriptionSer, it)
    }
    ((value.topic?.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.topic?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.errorSer, value.error)
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

    public val notificationEventSerInner: KSerializer<SubscriptionStatus.NotificationEvent> =
      SubscriptionStatus.NotificationEvent.serializer()

    public val notificationEventSer: KSerializer<List<SubscriptionStatus.NotificationEvent>> =
      ListSerializer(Hoisted.notificationEventSerInner)

    public val subscriptionSer: KSerializer<Reference> = Reference.serializer()

    public val errorSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val errorSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.errorSerInner)
  }
}
