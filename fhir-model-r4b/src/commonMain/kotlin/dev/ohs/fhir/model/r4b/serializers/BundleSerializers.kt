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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Bundle
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Instant
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle.Link) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Bundle.Link {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: KotlinString? = null
    var _relation: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> relation = decoder.decodeStringElement(descriptor, i)
        4 ->
          _relation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationSer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    return Bundle.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relation =
        R4bString.of(relation, _relation)
          ?: throw SerializationException("Missing required property 'relation' on Bundle.Link"),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on Bundle.Link"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Bundle.Link) {
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
    ((value.relation.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.relation.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.relationSer, it)
    }
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.relationSer, it)
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
      element("resource", lazyDescriptor { Resource.serializer().descriptor }, isOptional = true)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Bundle.Entry {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        4 -> fullUrl = decoder.decodeStringElement(descriptor, i)
        5 ->
          _fullUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.fullUrlSer, null)
        6 ->
          resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resourceSer, null)
        7 ->
          search = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.searchSer, null)
        8 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requestSer, null)
        9 ->
          response =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.responseSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + i)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Bundle.Entry) {
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
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.linkSer, value.link)
    ((value.fullUrl?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.fullUrl?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.fullUrlSer, it)
    }
    (value.resource)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resourceSer, it)
    }
    (value.search)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.searchSer, it) }
    (value.request)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.requestSer, it)
    }
    (value.response)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.responseSer, it)
    }
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
      element("score", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_score", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Search =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Search) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Bundle.Entry.Search {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var score: FhirDecimal? = null
    var _score: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> mode = decoder.decodeStringElement(descriptor, i)
        4 -> _mode = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        5 ->
          score =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        6 ->
          _score = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Search: " + i)
      }
    }
    return Bundle.Entry.Search(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(mode?.let { Bundle.SearchEntryMode.fromCode(it) }, _mode),
      score = Decimal.of(score, _score),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Bundle.Entry.Search) {
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
    ((value.mode?.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.mode?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.modeSer, it)
    }
    ((value.score?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
    }
    (value.score?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.modeSer, it)
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Request) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Bundle.Entry.Request {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> method = decoder.decodeStringElement(descriptor, i)
        4 ->
          _method =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        5 -> url = decoder.decodeStringElement(descriptor, i)
        6 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        7 -> ifNoneMatch = decoder.decodeStringElement(descriptor, i)
        8 ->
          _ifNoneMatch =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        9 -> ifModifiedSince = decoder.decodeStringElement(descriptor, i)
        10 ->
          _ifModifiedSince =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        11 -> ifMatch = decoder.decodeStringElement(descriptor, i)
        12 ->
          _ifMatch =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        13 -> ifNoneExist = decoder.decodeStringElement(descriptor, i)
        14 ->
          _ifNoneExist =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.methodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Request: " + i)
      }
    }
    return Bundle.Entry.Request(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method =
        Enumeration.of(method?.let { Bundle.HTTPVerb.fromCode(it) }, _method)
          ?: throw SerializationException(
            "Missing required property 'method' on Bundle.Entry.Request"
          ),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on Bundle.Entry.Request"
          ),
      ifNoneMatch = R4bString.of(ifNoneMatch, _ifNoneMatch),
      ifModifiedSince =
        Instant.of(ifModifiedSince?.let { FhirDateTime.fromString(it) }, _ifModifiedSince),
      ifMatch = R4bString.of(ifMatch, _ifMatch),
      ifNoneExist = R4bString.of(ifNoneExist, _ifNoneExist),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Bundle.Entry.Request) {
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
    ((value.method.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.method.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.methodSer, it)
    }
    ((value.url.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.methodSer, it)
    }
    ((value.ifNoneMatch?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.ifNoneMatch?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.methodSer, it)
    }
    ((value.ifModifiedSince?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 9, it)
    }
    (value.ifModifiedSince?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.methodSer, it)
    }
    ((value.ifMatch?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.ifMatch?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.methodSer, it)
    }
    ((value.ifNoneExist?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.ifNoneExist?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.methodSer, it)
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
      element("outcome", lazyDescriptor { Resource.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Response =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Response) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Bundle.Entry.Response {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> status = decoder.decodeStringElement(descriptor, i)
        4 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        5 -> location = decoder.decodeStringElement(descriptor, i)
        6 ->
          _location =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        7 -> etag = decoder.decodeStringElement(descriptor, i)
        8 ->
          _etag = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        9 -> lastModified = decoder.decodeStringElement(descriptor, i)
        10 ->
          _lastModified =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.statusSer, null)
        11 ->
          outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.outcomeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + i)
      }
    }
    return Bundle.Entry.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        R4bString.of(status, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on Bundle.Entry.Response"
          ),
      location = Uri.of(location, _location),
      etag = R4bString.of(etag, _etag),
      lastModified = Instant.of(lastModified?.let { FhirDateTime.fromString(it) }, _lastModified),
      outcome = outcome,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Bundle.Entry.Response) {
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
    ((value.status.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.statusSer, it)
    }
    ((value.location?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.location?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.statusSer, it)
    }
    ((value.etag?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.etag?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.statusSer, it)
    }
    ((value.lastModified?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 9, it)
    }
    (value.lastModified?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.statusSer, it)
    }
    (value.outcome)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.outcomeSer, it)
    }
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
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("type", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_type", Element.serializer().descriptor, isOptional = true)
    b.element("timestamp", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_timestamp", Element.serializer().descriptor, isOptional = true)
    b.element("total", Int.serializer().descriptor, isOptional = true)
    b.element("_total", Element.serializer().descriptor, isOptional = true)
    b.element(
      "link",
      listSerialDescriptor(lazyDescriptor { Bundle.Link.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "entry",
      listSerialDescriptor(lazyDescriptor { Bundle.Entry.serializer().descriptor }),
      isOptional = true,
    )
    b.element("signature", Signature.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Bundle =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Bundle) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Bundle")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Bundle {
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
        6 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        7 -> type = decoder.decodeStringElement(descriptor, i)
        8 ->
          _type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        9 -> timestamp = decoder.decodeStringElement(descriptor, i)
        10 ->
          _timestamp =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        11 -> total = decoder.decodeIntElement(descriptor, i)
        12 ->
          _total =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> link = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkSer, null)
        14 ->
          entry = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.entrySer, null)
        15 ->
          signature =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.signatureSer, null)
        else -> throw SerializationException("Unexpected index decoding Bundle: " + i)
      }
    }
    return Bundle(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      identifier = identifier,
      type =
        Enumeration.of(type?.let { Bundle.BundleType.fromCode(it) }, _type)
          ?: throw SerializationException("Missing required property 'type' on Bundle"),
      timestamp = Instant.of(timestamp?.let { FhirDateTime.fromString(it) }, _timestamp),
      total = UnsignedInt.of(total, _total),
      link = link ?: listOf(),
      entry = entry ?: listOf(),
      signature = signature,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Bundle,
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.identifierSer, it)
    }
    ((value.type.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 7 + descriptorOffset, it)
    }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.timestamp?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 9 + descriptorOffset, it)
    }
    (value.timestamp?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.total?.value))?.let { encoder.encodeIntElement(descriptor, 11 + descriptorOffset, it) }
    (value.total?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.link.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.linkSer,
        value.link,
      )
    if (value.entry.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.entrySer,
        value.entry,
      )
    (value.signature)?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.signatureSer, it)
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

internal object BundlePolymorphicSerializer : KSerializer<Bundle> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Bundle") { BundleSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Bundle) {
    encoder.encodeStructure(descriptor) {
      BundleSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Bundle =
    decoder.decodeStructure(descriptor) {
      BundleSerializer.deserializeInternal(this, descriptor, 0)
    }
}
