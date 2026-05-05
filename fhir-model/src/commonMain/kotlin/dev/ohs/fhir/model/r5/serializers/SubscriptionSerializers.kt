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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Subscription
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.Url
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

internal object SubscriptionFilterBySerializer : KSerializer<Subscription.FilterBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("FilterBy") {
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
      element("resourceType", KotlinString.serializer().descriptor, isOptional = true)
      element("_resourceType", Element.serializer().descriptor, isOptional = true)
      element("filterParameter", KotlinString.serializer().descriptor, isOptional = true)
      element("_filterParameter", Element.serializer().descriptor, isOptional = true)
      element("comparator", KotlinString.serializer().descriptor, isOptional = true)
      element("_comparator", Element.serializer().descriptor, isOptional = true)
      element("modifier", KotlinString.serializer().descriptor, isOptional = true)
      element("_modifier", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Subscription.FilterBy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Subscription.FilterBy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Subscription.FilterBy {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resourceType: KotlinString? = null
    var _resourceType: Element? = null
    var filterParameter: KotlinString? = null
    var _filterParameter: Element? = null
    var comparator: KotlinString? = null
    var _comparator: Element? = null
    var modifier: KotlinString? = null
    var _modifier: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> resourceType = decoder.decodeStringElement(__desc, 3)
        4 ->
          _resourceType =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.resourceTypeSer, null)
        5 -> filterParameter = decoder.decodeStringElement(__desc, 5)
        6 ->
          _filterParameter =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.resourceTypeSer, null)
        7 -> comparator = decoder.decodeStringElement(__desc, 7)
        8 ->
          _comparator =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.resourceTypeSer, null)
        9 -> modifier = decoder.decodeStringElement(__desc, 9)
        10 ->
          _modifier =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.resourceTypeSer, null)
        11 -> `value` = decoder.decodeStringElement(__desc, 11)
        12 ->
          _value =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.resourceTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding FilterBy: " + __i)
      }
    }
    return Subscription.FilterBy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resourceType = Uri.of(resourceType, _resourceType),
      filterParameter = R5String.of(filterParameter, _filterParameter)!!,
      comparator =
        comparator?.let { Enumeration.of(Subscription.SearchComparator.fromCode(it), _comparator) },
      modifier =
        modifier?.let { Enumeration.of(Subscription.SearchModifierCode.fromCode(it), _modifier) },
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Subscription.FilterBy) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.resourceType?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.resourceType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.resourceTypeSer, it)
    }
    ((value.filterParameter.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.filterParameter.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.resourceTypeSer, it)
    }
    ((value.comparator?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.comparator?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.resourceTypeSer, it)
    }
    ((value.modifier?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.modifier?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.resourceTypeSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.resourceTypeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resourceTypeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object SubscriptionParameterSerializer : KSerializer<Subscription.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
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
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Subscription.Parameter =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Subscription.Parameter) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Subscription.Parameter {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> `value` = decoder.decodeStringElement(__desc, 5)
        6 -> _value = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + __i)
      }
    }
    return Subscription.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R5String.of(name, _name)!!,
      `value` = R5String.of(`value`, _value)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Subscription.Parameter) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("topic", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_topic", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactPoint.serializer().descriptor),
      isOptional = true,
    )
    b.element("end", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_end", Element.serializer().descriptor, isOptional = true)
    b.element("managingEntity", Reference.serializer().descriptor, isOptional = true)
    b.element("reason", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_reason", Element.serializer().descriptor, isOptional = true)
    b.element(
      "filterBy",
      listSerialDescriptor(lazyDescriptor { Subscription.FilterBy.serializer().descriptor }),
      isOptional = true,
    )
    b.element("channelType", Coding.serializer().descriptor, isOptional = true)
    b.element("endpoint", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_endpoint", Element.serializer().descriptor, isOptional = true)
    b.element(
      "parameter",
      listSerialDescriptor(lazyDescriptor { Subscription.Parameter.serializer().descriptor }),
      isOptional = true,
    )
    b.element("heartbeatPeriod", Int.serializer().descriptor, isOptional = true)
    b.element("_heartbeatPeriod", Element.serializer().descriptor, isOptional = true)
    b.element("timeout", Int.serializer().descriptor, isOptional = true)
    b.element("_timeout", Element.serializer().descriptor, isOptional = true)
    b.element("contentType", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_contentType", Element.serializer().descriptor, isOptional = true)
    b.element("content", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_content", Element.serializer().descriptor, isOptional = true)
    b.element("maxCount", Int.serializer().descriptor, isOptional = true)
    b.element("_maxCount", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Subscription =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Subscription) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Subscription")
      serializeJson(this, value)
    }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Subscription {
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
    var name: KotlinString? = null
    var _name: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var topic: KotlinString? = null
    var _topic: Element? = null
    var contact: List<ContactPoint>? = null
    var end: KotlinString? = null
    var _end: Element? = null
    var managingEntity: Reference? = null
    var reason: KotlinString? = null
    var _reason: Element? = null
    var filterBy: List<Subscription.FilterBy>? = null
    var channelType: Coding? = null
    var endpoint: KotlinString? = null
    var _endpoint: Element? = null
    var parameter: List<Subscription.Parameter>? = null
    var heartbeatPeriod: Int? = null
    var _heartbeatPeriod: Element? = null
    var timeout: Int? = null
    var _timeout: Element? = null
    var contentType: KotlinString? = null
    var _contentType: Element? = null
    var content: KotlinString? = null
    var _content: Element? = null
    var maxCount: Int? = null
    var _maxCount: Element? = null
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
        12 -> name = decoder.decodeStringElement(__desc, 12)
        13 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> topic = decoder.decodeStringElement(__desc, 16)
        17 ->
          _topic =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.contactSer, null)
        19 -> end = decoder.decodeStringElement(__desc, 19)
        20 ->
          _end =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 ->
          managingEntity =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.managingEntitySer, null)
        22 -> reason = decoder.decodeStringElement(__desc, 22)
        23 ->
          _reason =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          filterBy =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.filterBySer, null)
        25 ->
          channelType =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.channelTypeSer, null)
        26 -> endpoint = decoder.decodeStringElement(__desc, 26)
        27 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          parameter =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.parameterSer, null)
        29 -> heartbeatPeriod = decoder.decodeIntElement(__desc, 29)
        30 ->
          _heartbeatPeriod =
            decoder.decodeNullableSerializableElement(__desc, 30, Hoisted.implicitRulesSer, null)
        31 -> timeout = decoder.decodeIntElement(__desc, 31)
        32 ->
          _timeout =
            decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.implicitRulesSer, null)
        33 -> contentType = decoder.decodeStringElement(__desc, 33)
        34 ->
          _contentType =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 -> content = decoder.decodeStringElement(__desc, 35)
        36 ->
          _content =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.implicitRulesSer, null)
        37 -> maxCount = decoder.decodeIntElement(__desc, 37)
        38 ->
          _maxCount =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subscription: " + __i)
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
      identifier = identifier ?: listOf(),
      name = R5String.of(name, _name),
      status = Enumeration.of(Subscription.SubscriptionStatusCodes.fromCode(status!!), _status),
      topic = Canonical.of(topic, _topic)!!,
      contact = contact ?: listOf(),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      managingEntity = managingEntity,
      reason = R5String.of(reason, _reason),
      filterBy = filterBy ?: listOf(),
      channelType = channelType!!,
      endpoint = Url.of(endpoint, _endpoint),
      parameter = parameter ?: listOf(),
      heartbeatPeriod = UnsignedInt.of(heartbeatPeriod, _heartbeatPeriod),
      timeout = UnsignedInt.of(timeout, _timeout),
      contentType = Code.of(contentType, _contentType),
      content =
        content?.let {
          Enumeration.of(Subscription.SubscriptionPayloadContent.fromCode(it), _content)
        },
      maxCount = PositiveInt.of(maxCount, _maxCount),
    )
  }

  internal fun serializeJson(encoder: CompositeEncoder, `value`: Subscription) {
    val __desc = descriptor
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
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.topic.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.topic.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.contactSer, value.contact)
    ((value.end?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 19, it) }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    (value.managingEntity)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.managingEntitySer, it)
    }
    ((value.reason?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.reason?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    if (value.filterBy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 24, Hoisted.filterBySer, value.filterBy)
    (value.channelType)?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.channelTypeSer, it)
    }
    ((value.endpoint?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.endpoint?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.parameterSer, value.parameter)
    ((value.heartbeatPeriod?.value))?.let { encoder.encodeIntElement(__desc, 29, it) }
    (value.heartbeatPeriod?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.implicitRulesSer, it)
    }
    ((value.timeout?.value))?.let { encoder.encodeIntElement(__desc, 31, it) }
    (value.timeout?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 32, Hoisted.implicitRulesSer, it)
    }
    ((value.contentType?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    ((value.content?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 35, it) }
    (value.content?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.implicitRulesSer, it)
    }
    ((value.maxCount?.value))?.let { encoder.encodeIntElement(__desc, 37, it) }
    (value.maxCount?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
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

    public val contactSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val contactSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.contactSerInner)

    public val managingEntitySer: KSerializer<Reference> = Reference.serializer()

    public val filterBySerInner: KSerializer<Subscription.FilterBy> =
      Subscription.FilterBy.serializer()

    public val filterBySer: KSerializer<List<Subscription.FilterBy>> =
      ListSerializer(Hoisted.filterBySerInner)

    public val channelTypeSer: KSerializer<Coding> = Coding.serializer()

    public val parameterSerInner: KSerializer<Subscription.Parameter> =
      Subscription.Parameter.serializer()

    public val parameterSer: KSerializer<List<Subscription.Parameter>> =
      ListSerializer(Hoisted.parameterSerInner)
  }
}

internal object SubscriptionPolymorphicSerializer : KSerializer<Subscription> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subscription") { SubscriptionSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Subscription) {
    encoder.encodeStructure(descriptor) { SubscriptionSerializer.serializeJson(this, value) }
  }

  override fun deserialize(decoder: Decoder): Subscription =
    decoder.decodeStructure(descriptor) { SubscriptionSerializer.deserializeJson(this) }
}
