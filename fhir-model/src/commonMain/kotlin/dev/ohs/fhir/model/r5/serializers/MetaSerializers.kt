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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Id
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Uri
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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

internal object MetaSerializer : KSerializer<Meta> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Meta") {
      element("id", String.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("versionId", String.serializer().descriptor, isOptional = true)
      element("_versionId", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("lastUpdated", String.serializer().descriptor, isOptional = true)
      element("_lastUpdated", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("source", String.serializer().descriptor, isOptional = true)
      element("_source", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("profile", listSerialDescriptor(String.serializer().descriptor), isOptional = true)
      element(
        "_profile",
        listSerialDescriptor(lazyDescriptor { Element.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "security",
        listSerialDescriptor(lazyDescriptor { Coding.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "tag",
        listSerialDescriptor(lazyDescriptor { Coding.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Meta =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Meta) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Meta {
    var id: String? = null
    var extension: List<Extension>? = null
    var versionId: String? = null
    var _versionId: Element? = null
    var lastUpdated: String? = null
    var _lastUpdated: Element? = null
    var source: String? = null
    var _source: Element? = null
    var profile: List<String?>? = null
    var _profile: List<Element?>? = null
    var security: List<Coding>? = null
    var tag: List<Coding>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> versionId = decoder.decodeStringElement(descriptor, i)
        3 ->
          _versionId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionIdSer, null)
        4 -> lastUpdated = decoder.decodeStringElement(descriptor, i)
        5 ->
          _lastUpdated =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionIdSer, null)
        6 -> source = decoder.decodeStringElement(descriptor, i)
        7 ->
          _source =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.versionIdSer, null)
        8 ->
          profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer, null)
        9 ->
          _profile =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.profileSer2, null)
        10 ->
          security =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securitySer, null)
        11 ->
          tag = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Meta: " + i)
      }
    }
    return Meta(
      id = id,
      extension = extension ?: listOf(),
      versionId = Id.of(versionId, _versionId),
      lastUpdated = Instant.of(FhirDateTime.fromString(lastUpdated), _lastUpdated),
      source = Uri.of(source, _source),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { index ->
          Canonical.of(profile?.getOrNull(index)?.let { it }, _profile?.getOrNull(index))!!
        }),
      security = security ?: listOf(),
      tag = tag ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Meta) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.versionId?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.versionId?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.versionIdSer, it)
    }
    ((value.lastUpdated?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.lastUpdated?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.versionIdSer, it)
    }
    ((value.source?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.versionIdSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.profileSer2, it)
    }
    if (value.security.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.securitySer, value.security)
    if (value.tag.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.securitySer, value.tag)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val versionIdSer: KSerializer<Element> = Element.serializer()

    public val profileSerInner: KSerializer<String> = String.serializer()

    public val profileSer: KSerializer<List<String?>> =
      ListSerializer((Hoisted.profileSerInner).nullable)

    public val profileSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.versionIdSer).nullable)

    public val securitySerInner: KSerializer<Coding> = Coding.serializer()

    public val securitySer: KSerializer<List<Coding>> = ListSerializer(Hoisted.securitySerInner)
  }
}
