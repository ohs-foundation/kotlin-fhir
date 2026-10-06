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

import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactPoint
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.ExtendedContactDetail
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Url
import dev.ohs.fhir.model.r5.VirtualServiceDetail
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
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object VirtualServiceDetailSerializer : KSerializer<VirtualServiceDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VirtualServiceDetail") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("channelType", CodingSerializer.descriptor)
      optionalElement("addressUrl", KotlinString.serializer().descriptor)
      optionalElement("_addressUrl", ElementSerializer.descriptor)
      optionalElement("addressString", KotlinString.serializer().descriptor)
      optionalElement("_addressString", ElementSerializer.descriptor)
      optionalElement("addressContactPoint", ContactPointSerializer.descriptor)
      optionalElement("addressExtendedContactDetail", ExtendedContactDetailSerializer.descriptor)
      optionalElement("additionalInfo", stringNullableListSerializer.descriptor)
      optionalElement("_additionalInfo", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("maxParticipants", Int.serializer().descriptor)
      optionalElement("_maxParticipants", ElementSerializer.descriptor)
      optionalElement("sessionKey", KotlinString.serializer().descriptor)
      optionalElement("_sessionKey", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<VirtualServiceDetail>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): VirtualServiceDetail {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var channelType: Coding? = null
    var addressUrl: KotlinString? = null
    var _addressUrl: Element? = null
    var addressString: KotlinString? = null
    var _addressString: Element? = null
    var addressContactPoint: ContactPoint? = null
    var addressExtendedContactDetail: ExtendedContactDetail? = null
    var additionalInfo: List<KotlinString?>? = null
    var _additionalInfo: List<Element?>? = null
    var maxParticipants: Int? = null
    var _maxParticipants: Element? = null
    var sessionKey: KotlinString? = null
    var _sessionKey: Element? = null
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
          channelType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        3 -> addressUrl = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _addressUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> addressString = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _addressString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          addressContactPoint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactPointSerializer,
              null,
            )
        8 ->
          addressExtendedContactDetail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtendedContactDetailSerializer,
              null,
            )
        9 ->
          additionalInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        10 ->
          _additionalInfo =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        11 -> maxParticipants = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _maxParticipants =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> sessionKey = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _sessionKey =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VirtualServiceDetail: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return VirtualServiceDetail(
      id = id,
      extension = extension ?: listOf(),
      channelType = channelType,
      address =
        VirtualServiceDetail.Address.from(
          Url.of(addressUrl, _addressUrl),
          R5String.of(addressString, _addressString),
          addressContactPoint,
          addressExtendedContactDetail,
        ),
      additionalInfo =
        (kotlin.collections.List(maxOf(additionalInfo?.size ?: 0, _additionalInfo?.size ?: 0)) {
          index ->
          Url.of(additionalInfo?.getOrNull(index), _additionalInfo?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'additionalInfo' on VirtualServiceDetail has neither a value nor an id/extension"
            )
        }),
      maxParticipants = PositiveInt.of(maxParticipants, _maxParticipants),
      sessionKey = R5String.of(sessionKey, _sessionKey),
    )
  }

  override fun serialize(encoder: Encoder, `value`: VirtualServiceDetail) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 2, CodingSerializer, value.channelType)
    when (val choice = value.address) {
      null -> {}
      is VirtualServiceDetail.Address.Url -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is VirtualServiceDetail.Address.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is VirtualServiceDetail.Address.ContactPoint -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          7,
          ContactPointSerializer,
          choice.value,
        )
      }
      is VirtualServiceDetail.Address.ExtendedContactDetail -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          8,
          ExtendedContactDetailSerializer,
          choice.value,
        )
      }
    }
    if (value.additionalInfo.isNotEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        9,
        stringNullableListSerializer,
        value.additionalInfo.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 10, value.additionalInfo)
    }
    compositeEncoder.encodeIntIfNotNull(descriptor, 11, value.maxParticipants?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.maxParticipants)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.sessionKey?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.sessionKey)
    compositeEncoder.endStructure(descriptor)
  }
}
