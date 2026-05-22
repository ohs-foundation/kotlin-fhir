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
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object VirtualServiceDetailSerializer : KSerializer<VirtualServiceDetail> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("VirtualServiceDetail") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("channelType", Coding.serializer().descriptor, isOptional = true)
      element("addressUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_addressUrl", Element.serializer().descriptor, isOptional = true)
      element("addressString", KotlinString.serializer().descriptor, isOptional = true)
      element("_addressString", Element.serializer().descriptor, isOptional = true)
      element("addressContactPoint", ContactPoint.serializer().descriptor, isOptional = true)
      element(
        "addressExtendedContactDetail",
        ExtendedContactDetail.serializer().descriptor,
        isOptional = true,
      )
      element(
        "additionalInfo",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_additionalInfo",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("maxParticipants", Int.serializer().descriptor, isOptional = true)
      element("_maxParticipants", Element.serializer().descriptor, isOptional = true)
      element("sessionKey", KotlinString.serializer().descriptor, isOptional = true)
      element("_sessionKey", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): VirtualServiceDetail =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: VirtualServiceDetail) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): VirtualServiceDetail {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          channelType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.channelTypeSer, null)
        3 -> addressUrl = decoder.decodeStringElement(descriptor, i)
        4 ->
          _addressUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressUrlSer, null)
        5 -> addressString = decoder.decodeStringElement(descriptor, i)
        6 ->
          _addressString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressUrlSer, null)
        7 ->
          addressContactPoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.addressContactPointSer,
              null,
            )
        8 ->
          addressExtendedContactDetail =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.addressExtendedContactDetailSer,
              null,
            )
        9 ->
          additionalInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInfoSer,
              null,
            )
        10 ->
          _additionalInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.additionalInfoSer2,
              null,
            )
        11 -> maxParticipants = decoder.decodeIntElement(descriptor, i)
        12 ->
          _maxParticipants =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressUrlSer, null)
        13 -> sessionKey = decoder.decodeStringElement(descriptor, i)
        14 ->
          _sessionKey =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressUrlSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding VirtualServiceDetail: " + i)
      }
    }
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
          Url.of(additionalInfo?.getOrNull(index)?.let { it }, _additionalInfo?.getOrNull(index))!!
        }),
      maxParticipants = PositiveInt.of(maxParticipants, _maxParticipants),
      sessionKey = R5String.of(sessionKey, _sessionKey),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: VirtualServiceDetail) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    (value.channelType)?.let {
      encoder.encodeSerializableElement(descriptor, 2, Hoisted.channelTypeSer, it)
    }
    when (val choice = value.address) {
      null -> {}
      is VirtualServiceDetail.Address.Url -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.addressUrlSer, it)
        }
      }
      is VirtualServiceDetail.Address.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.addressUrlSer, it)
        }
      }
      is VirtualServiceDetail.Address.ContactPoint -> {
        encoder.encodeSerializableElement(
          descriptor,
          7,
          Hoisted.addressContactPointSer,
          choice.value,
        )
      }
      is VirtualServiceDetail.Address.ExtendedContactDetail -> {
        encoder.encodeSerializableElement(
          descriptor,
          8,
          Hoisted.addressExtendedContactDetailSer,
          choice.value,
        )
      }
    }
    (value.additionalInfo.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.additionalInfoSer, it)
    }
    (value.additionalInfo.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.additionalInfoSer2, it)
    }
    ((value.maxParticipants?.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
    (value.maxParticipants?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.addressUrlSer, it)
    }
    ((value.sessionKey?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.sessionKey?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.addressUrlSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val channelTypeSer: KSerializer<Coding> = Coding.serializer()

    public val addressUrlSer: KSerializer<Element> = Element.serializer()

    public val addressContactPointSer: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val addressExtendedContactDetailSer: KSerializer<ExtendedContactDetail> =
      ExtendedContactDetail.serializer()

    public val additionalInfoSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val additionalInfoSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.additionalInfoSerInner).nullable)

    public val additionalInfoSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.addressUrlSer).nullable)
  }
}
