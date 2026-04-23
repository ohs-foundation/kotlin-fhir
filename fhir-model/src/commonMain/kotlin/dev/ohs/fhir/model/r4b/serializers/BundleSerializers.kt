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

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Bundle
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
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

internal object BundleLinkSerializer : KSerializer<Bundle.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
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
      element("relation", KotlinString.serializer().descriptor, isOptional = true)
      element("_relation", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Link =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle.Link) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Bundle.Link {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: KotlinString? = null
    var _relation: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> relation = decoder.decodeStringElement(__desc, 3)
        4 ->
          _relation =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.relationSer, null)
        5 -> url = decoder.decodeStringElement(__desc, 5)
        6 -> _url = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.relationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + __i)
      }
    }
    return Bundle.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relation = R4bString.of(relation, _relation)!!,
      url = Uri.of(url, _url)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle.Link) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.relation.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.relation.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.relationSer, it)
    }
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.relationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val relationSer: KSerializer<Element> = Element.serializer()
  }
}

internal object BundleEntrySerializer : KSerializer<Bundle.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
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
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { Bundle.Link.serializer().descriptor }),
        isOptional = true,
      )
      element("fullUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_fullUrl", Element.serializer().descriptor, isOptional = true)
      element("resource", Resource.serializer().descriptor, isOptional = true)
      element(
        "search",
        lazyDescriptor { Bundle.Entry.Search.serializer().descriptor },
        isOptional = true,
      )
      element(
        "request",
        lazyDescriptor { Bundle.Entry.Request.serializer().descriptor },
        isOptional = true,
      )
      element(
        "response",
        lazyDescriptor { Bundle.Entry.Response.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Bundle.Entry {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var link: List<Bundle.Link>? = null
    var fullUrl: KotlinString? = null
    var _fullUrl: Element? = null
    var resource: Resource? = null
    var search: Bundle.Entry.Search? = null
    var request: Bundle.Entry.Request? = null
    var response: Bundle.Entry.Response? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> link = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.linkSer, null)
        4 -> fullUrl = decoder.decodeStringElement(__desc, 4)
        5 ->
          _fullUrl = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.fullUrlSer, null)
        6 ->
          resource = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.resourceSer, null)
        7 -> search = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.searchSer, null)
        8 ->
          request = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.requestSer, null)
        9 ->
          response = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.responseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + __i)
      }
    }
    return Bundle.Entry(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      link = link ?: listOf(),
      fullUrl = Uri.of(fullUrl, _fullUrl),
      resource = resource,
      search = search,
      request = request,
      response = response,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle.Entry) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.linkSer, value.link)
    ((value.fullUrl?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.fullUrl?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.fullUrlSer, it)
    }
    (value.resource)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.resourceSer, it) }
    (value.search)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.searchSer, it) }
    (value.request)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.requestSer, it) }
    (value.response)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.responseSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkSerInner: KSerializer<Bundle.Link> = Bundle.Link.serializer()

    public val linkSer: KSerializer<List<Bundle.Link>> = ListSerializer(Hoisted.linkSerInner)

    public val fullUrlSer: KSerializer<Element> = Element.serializer()

    public val resourceSer: KSerializer<Resource> = Resource.serializer()

    public val searchSer: KSerializer<Bundle.Entry.Search> = Bundle.Entry.Search.serializer()

    public val requestSer: KSerializer<Bundle.Entry.Request> = Bundle.Entry.Request.serializer()

    public val responseSer: KSerializer<Bundle.Entry.Response> = Bundle.Entry.Response.serializer()
  }
}

internal object BundleEntrySearchSerializer : KSerializer<Bundle.Entry.Search> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Search") {
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
      element("mode", KotlinString.serializer().descriptor, isOptional = true)
      element("_mode", Element.serializer().descriptor, isOptional = true)
      element("score", BigDecimalSerializer.descriptor, isOptional = true)
      element("_score", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Search =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Search) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Bundle.Entry.Search {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var score: BigDecimal? = null
    var _score: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(__desc, 3)
        4 -> _mode = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.modeSer, null)
        5 ->
          score = decoder.decodeNullableSerializableElement(__desc, 5, BigDecimalSerializer, null)
        6 -> _score = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Search: " + __i)
      }
    }
    return Bundle.Entry.Search(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = mode?.let { Enumeration.of(Bundle.SearchEntryMode.fromCode(it), _mode) },
      score = Decimal.of(score, _score),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle.Entry.Search) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.mode?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.modeSer, it)
    }
    ((value.score?.value))?.let {
      encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
    }
    (value.score?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.modeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val modeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object BundleEntryRequestSerializer : KSerializer<Bundle.Entry.Request> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Request") {
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
      element("method", KotlinString.serializer().descriptor, isOptional = true)
      element("_method", Element.serializer().descriptor, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element("ifNoneMatch", KotlinString.serializer().descriptor, isOptional = true)
      element("_ifNoneMatch", Element.serializer().descriptor, isOptional = true)
      element("ifModifiedSince", KotlinString.serializer().descriptor, isOptional = true)
      element("_ifModifiedSince", Element.serializer().descriptor, isOptional = true)
      element("ifMatch", KotlinString.serializer().descriptor, isOptional = true)
      element("_ifMatch", Element.serializer().descriptor, isOptional = true)
      element("ifNoneExist", KotlinString.serializer().descriptor, isOptional = true)
      element("_ifNoneExist", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Request =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Request) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Bundle.Entry.Request {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var method: KotlinString? = null
    var _method: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var ifNoneMatch: KotlinString? = null
    var _ifNoneMatch: Element? = null
    var ifModifiedSince: KotlinString? = null
    var _ifModifiedSince: Element? = null
    var ifMatch: KotlinString? = null
    var _ifMatch: Element? = null
    var ifNoneExist: KotlinString? = null
    var _ifNoneExist: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> method = decoder.decodeStringElement(__desc, 3)
        4 -> _method = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.methodSer, null)
        5 -> url = decoder.decodeStringElement(__desc, 5)
        6 -> _url = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.methodSer, null)
        7 -> ifNoneMatch = decoder.decodeStringElement(__desc, 7)
        8 ->
          _ifNoneMatch =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.methodSer, null)
        9 -> ifModifiedSince = decoder.decodeStringElement(__desc, 9)
        10 ->
          _ifModifiedSince =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.methodSer, null)
        11 -> ifMatch = decoder.decodeStringElement(__desc, 11)
        12 ->
          _ifMatch = decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.methodSer, null)
        13 -> ifNoneExist = decoder.decodeStringElement(__desc, 13)
        14 ->
          _ifNoneExist =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.methodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Request: " + __i)
      }
    }
    return Bundle.Entry.Request(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method = Enumeration.of(Bundle.HTTPVerb.fromCode(method!!), _method),
      url = Uri.of(url, _url)!!,
      ifNoneMatch = R4bString.of(ifNoneMatch, _ifNoneMatch),
      ifModifiedSince = Instant.of(FhirDateTime.fromString(ifModifiedSince), _ifModifiedSince),
      ifMatch = R4bString.of(ifMatch, _ifMatch),
      ifNoneExist = R4bString.of(ifNoneExist, _ifNoneExist),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle.Entry.Request) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.method.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.method.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.methodSer, it)
    }
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.methodSer, it)
    }
    ((value.ifNoneMatch?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.ifNoneMatch?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.methodSer, it)
    }
    ((value.ifModifiedSince?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.ifModifiedSince?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.methodSer, it)
    }
    ((value.ifMatch?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.ifMatch?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.methodSer, it)
    }
    ((value.ifNoneExist?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.ifNoneExist?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.methodSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val methodSer: KSerializer<Element> = Element.serializer()
  }
}

internal object BundleEntryResponseSerializer : KSerializer<Bundle.Entry.Response> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Response") {
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
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("location", KotlinString.serializer().descriptor, isOptional = true)
      element("_location", Element.serializer().descriptor, isOptional = true)
      element("etag", KotlinString.serializer().descriptor, isOptional = true)
      element("_etag", Element.serializer().descriptor, isOptional = true)
      element("lastModified", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastModified", Element.serializer().descriptor, isOptional = true)
      element("outcome", Resource.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Response =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Response) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Bundle.Entry.Response {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var location: KotlinString? = null
    var _location: Element? = null
    var etag: KotlinString? = null
    var _etag: Element? = null
    var lastModified: KotlinString? = null
    var _lastModified: Element? = null
    var outcome: Resource? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> status = decoder.decodeStringElement(__desc, 3)
        4 -> _status = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.statusSer, null)
        5 -> location = decoder.decodeStringElement(__desc, 5)
        6 ->
          _location = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.statusSer, null)
        7 -> etag = decoder.decodeStringElement(__desc, 7)
        8 -> _etag = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.statusSer, null)
        9 -> lastModified = decoder.decodeStringElement(__desc, 9)
        10 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.statusSer, null)
        11 ->
          outcome = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.outcomeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + __i)
      }
    }
    return Bundle.Entry.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status = R4bString.of(status, _status)!!,
      location = Uri.of(location, _location),
      etag = R4bString.of(etag, _etag),
      lastModified = Instant.of(FhirDateTime.fromString(lastModified), _lastModified),
      outcome = outcome,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle.Entry.Response) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.status.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.statusSer, it)
    }
    ((value.location?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.location?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.statusSer, it)
    }
    ((value.etag?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.etag?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.statusSer, it)
    }
    ((value.lastModified?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.lastModified?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.statusSer, it)
    }
    (value.outcome)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.outcomeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val statusSer: KSerializer<Element> = Element.serializer()

    public val outcomeSer: KSerializer<Resource> = Resource.serializer()
  }
}

internal object BundleSerializer : KSerializer<Bundle> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Bundle") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("timestamp", KotlinString.serializer().descriptor, isOptional = true)
      element("_timestamp", Element.serializer().descriptor, isOptional = true)
      element("total", Int.serializer().descriptor, isOptional = true)
      element("_total", Element.serializer().descriptor, isOptional = true)
      element(
        "link",
        listSerialDescriptor(lazyDescriptor { Bundle.Link.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "entry",
        listSerialDescriptor(lazyDescriptor { Bundle.Entry.serializer().descriptor }),
        isOptional = true,
      )
      element("signature", Signature.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Bundle {
    val __desc = descriptor
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var identifier: Identifier? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var timestamp: KotlinString? = null
    var _timestamp: Element? = null
    var total: Int? = null
    var _total: Element? = null
    var link: List<Bundle.Link>? = null
    var entry: List<Bundle.Entry>? = null
    var signature: Signature? = null
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
        7 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.identifierSer, null)
        8 -> type = decoder.decodeStringElement(__desc, 8)
        9 ->
          _type =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.implicitRulesSer, null)
        10 -> timestamp = decoder.decodeStringElement(__desc, 10)
        11 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.implicitRulesSer, null)
        12 -> total = decoder.decodeIntElement(__desc, 12)
        13 ->
          _total =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> link = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.linkSer, null)
        15 -> entry = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.entrySer, null)
        16 ->
          signature =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.signatureSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Bundle: " + __i)
      }
    }
    return Bundle(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      identifier = identifier,
      type = Enumeration.of(Bundle.BundleType.fromCode(type!!), _type),
      timestamp = Instant.of(FhirDateTime.fromString(timestamp), _timestamp),
      total = UnsignedInt.of(total, _total),
      link = link ?: listOf(),
      entry = entry ?: listOf(),
      signature = signature,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Bundle) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Bundle")
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.identifierSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.implicitRulesSer, it)
    }
    ((value.timestamp?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.timestamp?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.implicitRulesSer, it)
    }
    ((value.total?.value))?.let { encoder.encodeIntElement(__desc, 12, it) }
    (value.total?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.linkSer, value.link)
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.entrySer, value.entry)
    (value.signature)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.signatureSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val linkSerInner: KSerializer<Bundle.Link> = Bundle.Link.serializer()

    public val linkSer: KSerializer<List<Bundle.Link>> = ListSerializer(Hoisted.linkSerInner)

    public val entrySerInner: KSerializer<Bundle.Entry> = Bundle.Entry.serializer()

    public val entrySer: KSerializer<List<Bundle.Entry>> = ListSerializer(Hoisted.entrySerInner)

    public val signatureSer: KSerializer<Signature> = Signature.serializer()
  }
}
