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
import kotlin.Int
import kotlin.String as KotlinString
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus.NotificationEvent) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): SubscriptionStatus.NotificationEvent {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> eventNumber = decoder.decodeStringElement(descriptor, i)
        4 ->
          _eventNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventNumberSer, null)
        5 -> timestamp = decoder.decodeStringElement(descriptor, i)
        6 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.eventNumberSer, null)
        7 ->
          focus = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focusSer, null)
        8 ->
          additionalContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalContextSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding NotificationEvent: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: SubscriptionStatus.NotificationEvent,
  ) {
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
    ((value.eventNumber.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.eventNumber.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.eventNumberSer, it)
    }
    ((value.timestamp?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.timestamp?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.eventNumberSer, it)
    }
    (value.focus)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.focusSer, it) }
    if (value.additionalContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
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
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element(
      "eventsSinceSubscriptionStart",
      KotlinString.serializer().descriptor,
      isOptional = true,
    )
    b.element("_eventsSinceSubscriptionStart", Element.serializer().descriptor, isOptional = true)
    b.element(
      "notificationEvent",
      listSerialDescriptor(
        lazyDescriptor { SubscriptionStatus.NotificationEvent.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("subscription", Reference.serializer().descriptor, isOptional = true)
    b.element("topic", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_topic", Element.serializer().descriptor, isOptional = true)
    b.element(
      "error",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): SubscriptionStatus =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "SubscriptionStatus")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        12 -> type = decoder.decodeStringElement(descriptor, i)
        13 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        14 -> eventsSinceSubscriptionStart = decoder.decodeStringElement(descriptor, i)
        15 ->
          _eventsSinceSubscriptionStart =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          notificationEvent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.notificationEventSer,
              null,
            )
        17 ->
          subscription =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subscriptionSer, null)
        18 -> topic = decoder.decodeStringElement(descriptor, i)
        19 ->
          _topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          error = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.errorSer, null)
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: SubscriptionStatus,
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
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.type.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 12 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.eventsSinceSubscriptionStart?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.eventsSinceSubscriptionStart?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.notificationEvent.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.notificationEventSer,
        value.notificationEvent,
      )
    (value.subscription)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.subscriptionSer,
        it,
      )
    }
    ((value.topic?.value))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.topic?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.errorSer,
        value.error,
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

    public val notificationEventSerInner: KSerializer<SubscriptionStatus.NotificationEvent> =
      SubscriptionStatus.NotificationEvent.serializer()

    public val notificationEventSer: KSerializer<List<SubscriptionStatus.NotificationEvent>> =
      ListSerializer(Hoisted.notificationEventSerInner)

    public val subscriptionSer: KSerializer<Reference> = Reference.serializer()

    public val errorSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val errorSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.errorSerInner)
  }
}

internal object SubscriptionStatusPolymorphicSerializer : KSerializer<SubscriptionStatus> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SubscriptionStatus") {
      SubscriptionStatusSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus) {
    encoder.encodeStructure(descriptor) {
      SubscriptionStatusSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): SubscriptionStatus =
    decoder.decodeStructure(descriptor) {
      SubscriptionStatusSerializer.deserializeInternal(this, descriptor, 0)
    }
}
