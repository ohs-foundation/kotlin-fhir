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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Bundle
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.Signature
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.BundleType
import dev.ohs.fhir.model.r4.terminologies.HTTPVerb
import dev.ohs.fhir.model.r4.terminologies.SearchEntryMode
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

internal object BundleLinkSerializer : KSerializer<Bundle.Link> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Link") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("relation", KotlinString.serializer().descriptor)
      optionalElement("_relation", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Bundle.Link>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Bundle.Link {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: KotlinString? = null
    var _relation: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
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
        3 -> relation = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _relation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Link: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Link(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      relation =
        R4String.of(relation, _relation)
          ?: throw SerializationException("Missing required property 'relation' on Bundle.Link"),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException("Missing required property 'url' on Bundle.Link"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Link) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.relation.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.relation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleEntrySerializer : KSerializer<Bundle.Entry> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Entry") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "link",
        listSerialDescriptor(lazyDescriptor { BundleLinkSerializer.descriptor }),
      )
      optionalElement("fullUrl", KotlinString.serializer().descriptor)
      optionalElement("_fullUrl", ElementSerializer.descriptor)
      optionalElement("resource", lazyDescriptor { ResourcePolymorphicSerializer.descriptor })
      optionalElement("search", BundleEntrySearchSerializer.descriptor)
      optionalElement("request", BundleEntryRequestSerializer.descriptor)
      optionalElement("response", BundleEntryResponseSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Bundle.Entry>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Bundle.Entry {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleLinkSerializer.listSerializer,
              null,
            )
        4 -> fullUrl = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _fullUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          resource =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer,
              null,
            )
        7 ->
          search =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleEntrySearchSerializer,
              null,
            )
        8 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleEntryRequestSerializer,
              null,
            )
        9 ->
          response =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleEntryResponseSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Entry: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
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

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.link.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        3,
        BundleLinkSerializer.listSerializer,
        value.link,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.fullUrl?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.fullUrl)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ResourcePolymorphicSerializer,
      value.resource,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      BundleEntrySearchSerializer,
      value.search,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      BundleEntryRequestSerializer,
      value.request,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      9,
      BundleEntryResponseSerializer,
      value.response,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleEntrySearchSerializer : KSerializer<Bundle.Entry.Search> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Search") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("mode", KotlinString.serializer().descriptor)
      optionalElement("_mode", ElementSerializer.descriptor)
      optionalElement("score", FhirDecimalSerializer.descriptor)
      optionalElement("_score", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Bundle.Entry.Search>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Bundle.Entry.Search {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: KotlinString? = null
    var _mode: Element? = null
    var score: FhirDecimal? = null
    var _score: Element? = null
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
        3 -> mode = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _mode =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        6 ->
          _score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Search: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Search(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      mode = Enumeration.of(if (mode != null) SearchEntryMode.fromCode(mode) else null, _mode),
      score = Decimal.of(score, _score),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Search) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.mode?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.mode)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      FhirDecimalSerializer,
      value.score?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.score)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleEntryRequestSerializer : KSerializer<Bundle.Entry.Request> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Request") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("method", KotlinString.serializer().descriptor)
      optionalElement("_method", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("ifNoneMatch", KotlinString.serializer().descriptor)
      optionalElement("_ifNoneMatch", ElementSerializer.descriptor)
      optionalElement("ifModifiedSince", KotlinString.serializer().descriptor)
      optionalElement("_ifModifiedSince", ElementSerializer.descriptor)
      optionalElement("ifMatch", KotlinString.serializer().descriptor)
      optionalElement("_ifMatch", ElementSerializer.descriptor)
      optionalElement("ifNoneExist", KotlinString.serializer().descriptor)
      optionalElement("_ifNoneExist", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Bundle.Entry.Request>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Bundle.Entry.Request {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> method = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _method =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> ifNoneMatch = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _ifNoneMatch =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> ifModifiedSince = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _ifModifiedSince =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> ifMatch = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _ifMatch =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> ifNoneExist = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _ifNoneExist =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Request: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Request(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      method =
        Enumeration.of(if (method != null) HTTPVerb.fromCode(method) else null, _method)
          ?: throw SerializationException(
            "Missing required property 'method' on Bundle.Entry.Request"
          ),
      url =
        Uri.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on Bundle.Entry.Request"
          ),
      ifNoneMatch = R4String.of(ifNoneMatch, _ifNoneMatch),
      ifModifiedSince =
        Instant.of(
          if (ifModifiedSince != null) FhirDateTime.fromString(ifModifiedSince) else null,
          _ifModifiedSince,
        ),
      ifMatch = R4String.of(ifMatch, _ifMatch),
      ifNoneExist = R4String.of(ifNoneExist, _ifNoneExist),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Request) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.method.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.method)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.ifNoneMatch?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.ifNoneMatch)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.ifModifiedSince?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.ifModifiedSince)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.ifMatch?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.ifMatch)
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.ifNoneExist?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.ifNoneExist)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleEntryResponseSerializer : KSerializer<Bundle.Entry.Response> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Response") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("status", KotlinString.serializer().descriptor)
      optionalElement("_status", ElementSerializer.descriptor)
      optionalElement("location", KotlinString.serializer().descriptor)
      optionalElement("_location", ElementSerializer.descriptor)
      optionalElement("etag", KotlinString.serializer().descriptor)
      optionalElement("_etag", ElementSerializer.descriptor)
      optionalElement("lastModified", KotlinString.serializer().descriptor)
      optionalElement("_lastModified", ElementSerializer.descriptor)
      optionalElement("outcome", lazyDescriptor { ResourcePolymorphicSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Bundle.Entry.Response>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Bundle.Entry.Response {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> location = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _location =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> etag = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _etag =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> lastModified = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _lastModified =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Response: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Response(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      status =
        R4String.of(status, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on Bundle.Entry.Response"
          ),
      location = Uri.of(location, _location),
      etag = R4String.of(etag, _etag),
      lastModified =
        Instant.of(
          if (lastModified != null) FhirDateTime.fromString(lastModified) else null,
          _lastModified,
        ),
      outcome = outcome,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Response) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.status.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.status)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.location?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.location)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.etag?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.etag)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.lastModified?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.lastModified)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      11,
      ResourcePolymorphicSerializer,
      value.outcome,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleSerializer : FhirResourceSerializer<Bundle> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Bundle")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("type", KotlinString.serializer().descriptor)
    b.optionalElement("_type", ElementSerializer.descriptor)
    b.optionalElement("timestamp", KotlinString.serializer().descriptor)
    b.optionalElement("_timestamp", ElementSerializer.descriptor)
    b.optionalElement("total", Int.serializer().descriptor)
    b.optionalElement("_total", ElementSerializer.descriptor)
    b.optionalElement("link", BundleLinkSerializer.listSerializer.descriptor)
    b.optionalElement("entry", BundleEntrySerializer.listSerializer.descriptor)
    b.optionalElement("signature", SignatureSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        7 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> timestamp = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _timestamp =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> total = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _total =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          link =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleLinkSerializer.listSerializer,
              null,
            )
        14 ->
          entry =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              BundleEntrySerializer.listSerializer,
              null,
            )
        15 ->
          signature =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer,
              null,
            )
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
        Enumeration.of(if (type != null) BundleType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on Bundle"),
      timestamp =
        Instant.of(if (timestamp != null) FhirDateTime.fromString(timestamp) else null, _timestamp),
      total = UnsignedInt.of(total, _total),
      link = link ?: listOf(),
      entry = entry ?: listOf(),
      signature = signature,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Bundle,
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
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 7 + descriptorOffset, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8 + descriptorOffset, value.type)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      9 + descriptorOffset,
      value.timestamp?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 10 + descriptorOffset, value.timestamp)
    compositeEncoder.encodeIntIfNotNull(descriptor, 11 + descriptorOffset, value.total?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.total)
    if (value.link.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        BundleLinkSerializer.listSerializer,
        value.link,
      )
    if (value.entry.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        BundleEntrySerializer.listSerializer,
        value.entry,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      SignatureSerializer,
      value.signature,
    )
  }
}
