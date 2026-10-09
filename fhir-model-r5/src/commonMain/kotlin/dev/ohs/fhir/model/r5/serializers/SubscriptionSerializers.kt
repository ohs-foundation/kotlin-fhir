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
import dev.ohs.fhir.model.r5.terminologies.SearchComparator
import dev.ohs.fhir.model.r5.terminologies.SearchModifierCode
import dev.ohs.fhir.model.r5.terminologies.SubscriptionPayloadContent
import dev.ohs.fhir.model.r5.terminologies.SubscriptionStatusCodes
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object SubscriptionFilterBySerializer : FhirSerializer<Subscription.FilterBy> {
  override val descriptor: SerialDescriptor = buildDescriptor("FilterBy", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Subscription.FilterBy>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("resourceType")
    b.strPrim("filterParameter")
    b.strPrim("comparator")
    b.strPrim("modifier")
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): Subscription.FilterBy {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var resourceType: KotlinString? = null
    var _resourceType: Element? = null
    var filterParameter: KotlinString? = null
    var _filterParameter: Element? = null
    var comparator: SearchComparator? = null
    var _comparator: Element? = null
    var modifier: SearchModifierCode? = null
    var _modifier: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> resourceType = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _resourceType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> filterParameter = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _filterParameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          comparator =
            SearchComparator.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _comparator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          modifier =
            SearchModifierCode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Subscription.FilterBy(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      resourceType = Uri.of(resourceType, _resourceType),
      filterParameter =
        required(
          R5String.of(filterParameter, _filterParameter),
          "Subscription.FilterBy",
          "filterParameter",
        ),
      comparator = Enumeration.of(comparator, _comparator),
      modifier = Enumeration.of(modifier, _modifier),
      `value` = required(R5String.of(`value`, _value), "Subscription.FilterBy", "value"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Subscription.FilterBy) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.resourceType?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.resourceType)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.filterParameter.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.filterParameter)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.comparator?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.comparator)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.modifier?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.modifier)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubscriptionParameterSerializer : FhirSerializer<Subscription.Parameter> {
  override val descriptor: SerialDescriptor = buildDescriptor("Parameter", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Subscription.Parameter>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("value")
  }

  override fun deserialize(decoder: Decoder): Subscription.Parameter {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
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
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Subscription.Parameter(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = required(R5String.of(name, _name), "Subscription.Parameter", "name"),
      `value` = required(R5String.of(`value`, _value), "Subscription.Parameter", "value"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Subscription.Parameter) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`value`)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object SubscriptionSerializer : FhirResourceSerializer<Subscription> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Subscription")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("status")
    b.strPrim("topic")
    b.optionalElement("contact", ContactPointSerializer.listSerializer.descriptor)
    b.strPrim("end")
    b.optionalElement("managingEntity", ReferenceSerializer.descriptor)
    b.strPrim("reason")
    b.optionalElement("filterBy", SubscriptionFilterBySerializer.listSerializer.descriptor)
    b.optionalElement("channelType", CodingSerializer.descriptor)
    b.strPrim("endpoint")
    b.optionalElement("parameter", SubscriptionParameterSerializer.listSerializer.descriptor)
    b.intPrim("heartbeatPeriod")
    b.intPrim("timeout")
    b.strPrim("contentType")
    b.strPrim("content")
    b.intPrim("maxCount")
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: SubscriptionStatusCodes? = null
    var _status: Element? = null
    var topic: KotlinString? = null
    var _topic: Element? = null
    var contact: List<ContactPoint>? = null
    var end: FhirDateTime? = null
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
    var content: SubscriptionPayloadContent? = null
    var _content: Element? = null
    var maxCount: Int? = null
    var _maxCount: Element? = null
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
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          status =
            SubscriptionStatusCodes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> topic = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _topic =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer.listSerializer,
              null,
            )
        18 -> end = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        19 ->
          _end =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 ->
          managingEntity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        21 -> reason = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _reason =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 ->
          filterBy =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionFilterBySerializer.listSerializer,
              null,
            )
        24 ->
          channelType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        25 -> endpoint = compositeDecoder.decodeStringElement(descriptor, i)
        26 ->
          _endpoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          parameter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SubscriptionParameterSerializer.listSerializer,
              null,
            )
        28 -> heartbeatPeriod = compositeDecoder.decodeIntElement(descriptor, i)
        29 ->
          _heartbeatPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        30 -> timeout = compositeDecoder.decodeIntElement(descriptor, i)
        31 ->
          _timeout =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> contentType = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _contentType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          content =
            SubscriptionPayloadContent.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        35 ->
          _content =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        36 -> maxCount = compositeDecoder.decodeIntElement(descriptor, i)
        37 ->
          _maxCount =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Subscription(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      name = R5String.of(name, _name),
      status = required(Enumeration.of(status, _status), "Subscription", "status"),
      topic = required(Canonical.of(topic, _topic), "Subscription", "topic"),
      contact = listOrEmpty(contact),
      end = Instant.of(end, _end),
      managingEntity = managingEntity,
      reason = R5String.of(reason, _reason),
      filterBy = listOrEmpty(filterBy),
      channelType = required(channelType, "Subscription", "channelType"),
      endpoint = Url.of(endpoint, _endpoint),
      parameter = listOrEmpty(parameter),
      heartbeatPeriod = UnsignedInt.of(heartbeatPeriod, _heartbeatPeriod),
      timeout = UnsignedInt.of(timeout, _timeout),
      contentType = Code.of(contentType, _contentType),
      content = Enumeration.of(content, _content),
      maxCount = PositiveInt.of(maxCount, _maxCount),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Subscription,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.topic.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.topic)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      17 + descriptorOffset,
      ContactPointSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      18 + descriptorOffset,
      value.end?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.end)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.managingEntity,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.reason?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.reason)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      23 + descriptorOffset,
      SubscriptionFilterBySerializer.listSerializer,
      value.filterBy,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      CodingSerializer,
      value.channelType,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.endpoint?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.endpoint)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      SubscriptionParameterSerializer.listSerializer,
      value.parameter,
    )
    compositeEncoder.encodeIntIfNotNull(
      descriptor,
      28 + descriptorOffset,
      value.heartbeatPeriod?.value,
    )
    compositeEncoder.encodeElementIfNotNull(
      descriptor,
      29 + descriptorOffset,
      value.heartbeatPeriod,
    )
    compositeEncoder.encodeIntIfNotNull(descriptor, 30 + descriptorOffset, value.timeout?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.timeout)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.contentType?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.contentType)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      34 + descriptorOffset,
      value.content?.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.content)
    compositeEncoder.encodeIntIfNotNull(descriptor, 36 + descriptorOffset, value.maxCount?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.maxCount)
  }
}
