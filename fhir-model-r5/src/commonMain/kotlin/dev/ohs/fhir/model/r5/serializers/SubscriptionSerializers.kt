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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("resourceType", KotlinString.serializer().descriptor)
      optionalElement("_resourceType", ElementSerializer.descriptor)
      optionalElement("filterParameter", KotlinString.serializer().descriptor)
      optionalElement("_filterParameter", ElementSerializer.descriptor)
      optionalElement("comparator", KotlinString.serializer().descriptor)
      optionalElement("_comparator", ElementSerializer.descriptor)
      optionalElement("modifier", KotlinString.serializer().descriptor)
      optionalElement("_modifier", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Subscription.FilterBy>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Subscription.FilterBy =
    decoder.decodeStructure(descriptor) {
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
          3 -> resourceType = decodeStringElement(descriptor, i)
          4 ->
            _resourceType =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> filterParameter = decodeStringElement(descriptor, i)
          6 ->
            _filterParameter =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> comparator = decodeStringElement(descriptor, i)
          8 ->
            _comparator = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> modifier = decodeStringElement(descriptor, i)
          10 ->
            _modifier = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> `value` = decodeStringElement(descriptor, i)
          12 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding FilterBy: " + i)
        }
      }
      Subscription.FilterBy(
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
          Enumeration.of(
            if (comparator != null) Subscription.SearchComparator.fromCode(comparator) else null,
            _comparator,
          ),
        modifier =
          Enumeration.of(
            if (modifier != null) Subscription.SearchModifierCode.fromCode(modifier) else null,
            _modifier,
          ),
        `value` =
          R5String.of(`value`, _value)
            ?: throw SerializationException(
              "Missing required property 'value' on Subscription.FilterBy"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Subscription.FilterBy) {
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
      encodeStringIfNotNull(descriptor, 3, value.resourceType?.value)
      encodeElementIfNotNull(descriptor, 4, value.resourceType)
      encodeStringIfNotNull(descriptor, 5, value.filterParameter.value)
      encodeElementIfNotNull(descriptor, 6, value.filterParameter)
      encodeStringIfNotNull(descriptor, 7, value.comparator?.value?.code)
      encodeElementIfNotNull(descriptor, 8, value.comparator)
      encodeStringIfNotNull(descriptor, 9, value.modifier?.value?.code)
      encodeElementIfNotNull(descriptor, 10, value.modifier)
      encodeStringIfNotNull(descriptor, 11, value.`value`.value)
      encodeElementIfNotNull(descriptor, 12, value.`value`)
    }
  }
}

internal object SubscriptionParameterSerializer : KSerializer<Subscription.Parameter> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Parameter") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Subscription.Parameter>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Subscription.Parameter =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var `value`: KotlinString? = null
      var _value: Element? = null
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
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> `value` = decodeStringElement(descriptor, i)
          6 -> _value = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Parameter: " + i)
        }
      }
      Subscription.Parameter(
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

  override fun serialize(encoder: Encoder, `value`: Subscription.Parameter) {
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
      encodeStringIfNotNull(descriptor, 3, value.name.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.`value`.value)
      encodeElementIfNotNull(descriptor, 6, value.`value`)
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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("topic", KotlinString.serializer().descriptor)
    b.optionalElement("_topic", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.optionalElement("end", KotlinString.serializer().descriptor)
    b.optionalElement("_end", ElementSerializer.descriptor)
    b.optionalElement("managingEntity", ReferenceSerializer.descriptor)
    b.optionalElement("reason", KotlinString.serializer().descriptor)
    b.optionalElement("_reason", ElementSerializer.descriptor)
    b.optionalElement("filterBy", SubscriptionFilterBySerializer.listSerializer.descriptor)
    b.optionalElement("channelType", CodingSerializer.descriptor)
    b.optionalElement("endpoint", KotlinString.serializer().descriptor)
    b.optionalElement("_endpoint", ElementSerializer.descriptor)
    b.optionalElement("parameter", SubscriptionParameterSerializer.listSerializer.descriptor)
    b.optionalElement("heartbeatPeriod", Int.serializer().descriptor)
    b.optionalElement("_heartbeatPeriod", ElementSerializer.descriptor)
    b.optionalElement("timeout", Int.serializer().descriptor)
    b.optionalElement("_timeout", ElementSerializer.descriptor)
    b.optionalElement("contentType", KotlinString.serializer().descriptor)
    b.optionalElement("_contentType", ElementSerializer.descriptor)
    b.optionalElement("content", KotlinString.serializer().descriptor)
    b.optionalElement("_content", ElementSerializer.descriptor)
    b.optionalElement("maxCount", Int.serializer().descriptor)
    b.optionalElement("_maxCount", ElementSerializer.descriptor)
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> topic = decoder.decodeStringElement(descriptor, i)
        16 ->
          _topic = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        18 -> end = decoder.decodeStringElement(descriptor, i)
        19 ->
          _end = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 ->
          managingEntity =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> reason = decoder.decodeStringElement(descriptor, i)
        22 ->
          _reason =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          filterBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionFilterBySerializer.listSerializer,
              null,
            )
        24 ->
          channelType =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        25 -> endpoint = decoder.decodeStringElement(descriptor, i)
        26 ->
          _endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          parameter =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionParameterSerializer.listSerializer,
              null,
            )
        28 -> heartbeatPeriod = decoder.decodeIntElement(descriptor, i)
        29 ->
          _heartbeatPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        30 -> timeout = decoder.decodeIntElement(descriptor, i)
        31 ->
          _timeout =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> contentType = decoder.decodeStringElement(descriptor, i)
        33 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> content = decoder.decodeStringElement(descriptor, i)
        35 ->
          _content =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 -> maxCount = decoder.decodeIntElement(descriptor, i)
        37 ->
          _maxCount =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
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
        Enumeration.of(
          if (status != null) Subscription.SubscriptionStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Subscription"),
      topic =
        Canonical.of(topic, _topic)
          ?: throw SerializationException("Missing required property 'topic' on Subscription"),
      contact = contact ?: listOf(),
      end = Instant.of(if (end != null) FhirDateTime.fromString(end) else null, _end),
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
          if (content != null) Subscription.SubscriptionPayloadContent.fromCode(content) else null,
          _content,
        ),
      maxCount = PositiveInt.of(maxCount, _maxCount),
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.topic.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.topic)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        ContactPointSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.end?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.end)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.managingEntity,
    )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.reason?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.reason)
    if (value.filterBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        SubscriptionFilterBySerializer.listSerializer,
        value.filterBy,
      )
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      CodingSerializer,
      value.channelType,
    )
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.endpoint?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.endpoint)
    if (value.parameter.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        SubscriptionParameterSerializer.listSerializer,
        value.parameter,
      )
    encoder.encodeIntIfNotNull(descriptor, 28 + descriptorOffset, value.heartbeatPeriod?.value)
    encoder.encodeElementIfNotNull(descriptor, 29 + descriptorOffset, value.heartbeatPeriod)
    encoder.encodeIntIfNotNull(descriptor, 30 + descriptorOffset, value.timeout?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.timeout)
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.contentType?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.contentType)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.content?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.content)
    encoder.encodeIntIfNotNull(descriptor, 36 + descriptorOffset, value.maxCount?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.maxCount)
  }
}
