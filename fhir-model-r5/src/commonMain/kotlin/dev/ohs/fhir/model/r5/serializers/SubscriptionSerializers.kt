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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Subscription.FilterBy) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Subscription.FilterBy {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> resourceType = decoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceTypeSer, null)
        5 -> filterParameter = decoder.decodeStringElement(descriptor, i)
        6 ->
          _filterParameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceTypeSer, null)
        7 -> comparator = decoder.decodeStringElement(descriptor, i)
        8 ->
          _comparator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceTypeSer, null)
        9 -> modifier = decoder.decodeStringElement(descriptor, i)
        10 ->
          _modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceTypeSer, null)
        11 -> `value` = decoder.decodeStringElement(descriptor, i)
        12 ->
          _value =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceTypeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding FilterBy: " + i)
      }
    }
    return Subscription.FilterBy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      resourceType = Uri.of(resourceType, _resourceType),
      filterParameter =
        R5String.of(filterParameter, _filterParameter)
          ?: throw SerializationException(
            "Missing required property 'filterParameter' on Subscription.FilterBy"
          ),
      comparator =
        Enumeration.of(comparator?.let { Subscription.SearchComparator.fromCode(it) }, _comparator),
      modifier =
        Enumeration.of(modifier?.let { Subscription.SearchModifierCode.fromCode(it) }, _modifier),
      `value` =
        R5String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on Subscription.FilterBy"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Subscription.FilterBy) {
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
    ((value.resourceType?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.resourceType?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resourceTypeSer, it)
    }
    ((value.filterParameter.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.filterParameter.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resourceTypeSer, it)
    }
    ((value.comparator?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.comparator?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.resourceTypeSer, it)
    }
    ((value.modifier?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.modifier?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.resourceTypeSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.resourceTypeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Subscription.Parameter) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Subscription.Parameter {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> `value` = decoder.decodeStringElement(descriptor, i)
        6 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
      }
    }
    return Subscription.Parameter(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name =
        R5String.of(name, _name)
          ?: throw SerializationException(
            "Missing required property 'name' on Subscription.Parameter"
          ),
      `value` =
        R5String.of(`value`, _value)
          ?: throw SerializationException(
            "Missing required property 'value' on Subscription.Parameter"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Subscription.Parameter) {
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
    ((value.name.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> topic = decoder.decodeStringElement(descriptor, i)
        16 ->
          _topic =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        18 -> end = decoder.decodeStringElement(descriptor, i)
        19 ->
          _end =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 ->
          managingEntity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.managingEntitySer,
              null,
            )
        21 -> reason = decoder.decodeStringElement(descriptor, i)
        22 ->
          _reason =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 ->
          filterBy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.filterBySer, null)
        24 ->
          channelType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.channelTypeSer, null)
        25 -> endpoint = decoder.decodeStringElement(descriptor, i)
        26 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          parameter =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.parameterSer, null)
        28 -> heartbeatPeriod = decoder.decodeIntElement(descriptor, i)
        29 ->
          _heartbeatPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        30 -> timeout = decoder.decodeIntElement(descriptor, i)
        31 ->
          _timeout =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 -> contentType = decoder.decodeStringElement(descriptor, i)
        33 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> content = decoder.decodeStringElement(descriptor, i)
        35 ->
          _content =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 -> maxCount = decoder.decodeIntElement(descriptor, i)
        37 ->
          _maxCount =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
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
      identifier = identifier ?: listOf(),
      name = R5String.of(name, _name),
      status =
        Enumeration.of(status?.let { Subscription.SubscriptionStatusCodes.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on Subscription"),
      topic =
        Canonical.of(topic, _topic)
          ?: throw SerializationException("Missing required property 'topic' on Subscription"),
      contact = contact ?: listOf(),
      end = Instant.of(FhirDateTime.fromString(end), _end),
      managingEntity = managingEntity,
      reason = R5String.of(reason, _reason),
      filterBy = filterBy ?: listOf(),
      channelType =
        channelType
          ?: throw SerializationException(
            "Missing required property 'channelType' on Subscription"
          ),
      endpoint = Url.of(endpoint, _endpoint),
      parameter = parameter ?: listOf(),
      heartbeatPeriod = UnsignedInt.of(heartbeatPeriod, _heartbeatPeriod),
      timeout = UnsignedInt.of(timeout, _timeout),
      contentType = Code.of(contentType, _contentType),
      content =
        Enumeration.of(
          content?.let { Subscription.SubscriptionPayloadContent.fromCode(it) },
          _content,
        ),
      maxCount = PositiveInt.of(maxCount, _maxCount),
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.topic.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.topic.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.end?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 18 + descriptorOffset, it)
    }
    (value.end?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.managingEntity)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.managingEntitySer,
        it,
      )
    }
    ((value.reason?.value))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.reason?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.filterBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.filterBySer,
        value.filterBy,
      )
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      Hoisted.channelTypeSer,
      value.channelType,
    )
    ((value.endpoint?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.endpoint?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.parameterSer,
        value.parameter,
      )
    ((value.heartbeatPeriod?.value))?.let {
      encoder.encodeIntElement(descriptor, 28 + descriptorOffset, it)
    }
    (value.heartbeatPeriod?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.timeout?.value))?.let {
      encoder.encodeIntElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.timeout?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.contentType?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.contentType?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.content?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.content?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.maxCount?.value))?.let {
      encoder.encodeIntElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.maxCount?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
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
    encoder.encodeStructure(descriptor) {
      SubscriptionSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Subscription =
    decoder.decodeStructure(descriptor) {
      SubscriptionSerializer.deserializeInternal(this, descriptor, 0)
    }
}
