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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Uri
import kotlin.String
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Meta) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Meta {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> versionId = decoder.decodeStringElement(__desc, __i)
        3 ->
          _versionId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionIdSer, null)
        4 -> lastUpdated = decoder.decodeStringElement(__desc, __i)
        5 ->
          _lastUpdated =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionIdSer, null)
        6 -> source = decoder.decodeStringElement(__desc, __i)
        7 ->
          _source =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.versionIdSer, null)
        8 ->
          profile = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.profileSer, null)
        9 ->
          _profile =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.profileSer2, null)
        10 ->
          security =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.securitySer, null)
        11 ->
          tag = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.securitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Meta: " + __i)
      }
    }
    return Meta(
      id = id,
      extension = extension ?: listOf(),
      versionId = Id.of(versionId, _versionId),
      lastUpdated = Instant.of(FhirDateTime.fromString(lastUpdated), _lastUpdated),
      source = Uri.of(source, _source),
      profile =
        (kotlin.collections.List(maxOf(profile?.size ?: 0, _profile?.size ?: 0)) { __i ->
          Canonical.of(profile?.getOrNull(__i)?.let { it }, _profile?.getOrNull(__i))!!
        }),
      security = security ?: listOf(),
      tag = tag ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Meta) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.versionId?.value))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.versionId?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.versionIdSer, it)
    }
    ((value.lastUpdated?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.lastUpdated?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.versionIdSer, it)
    }
    ((value.source?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.source?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.versionIdSer, it)
    }
    (value.profile.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.profileSer, it)
    }
    (value.profile.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.profileSer2, it)
    }
    if (value.security.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.securitySer, value.security)
    if (value.tag.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.securitySer, value.tag)
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
