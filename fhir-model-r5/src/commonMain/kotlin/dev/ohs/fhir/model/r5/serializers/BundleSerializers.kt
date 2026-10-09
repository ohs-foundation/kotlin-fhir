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

import dev.ohs.fhir.model.r5.Bundle
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Instant
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Signature
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.BundleType
import dev.ohs.fhir.model.r5.terminologies.HTTPVerb
import dev.ohs.fhir.model.r5.terminologies.LinkRelationTypes
import dev.ohs.fhir.model.r5.terminologies.SearchEntryMode
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

internal object BundleLinkSerializer : FhirSerializer<Bundle.Link> {
  override val descriptor: SerialDescriptor = buildDescriptor("Link", this)

  @JvmField internal val listSerializer: KSerializer<List<Bundle.Link>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("relation")
    b.strPrim("url")
  }

  override fun deserialize(decoder: Decoder): Bundle.Link {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var relation: LinkRelationTypes? = null
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
        3 ->
          relation = LinkRelationTypes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Link(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      relation = required(Enumeration.of(relation, _relation), "Bundle.Link", "relation"),
      url = required(Uri.of(url, _url), "Bundle.Link", "url"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Link) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.relation.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.relation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.url.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.url)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object BundleEntrySerializer : FhirSerializer<Bundle.Entry> {
  override val descriptor: SerialDescriptor = buildDescriptor("Entry", this)

  @JvmField internal val listSerializer: KSerializer<List<Bundle.Entry>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement(
      "link",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.BundleLinkSerializer)),
    )
    b.strPrim("fullUrl")
    b.optionalElement("resource", lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer))
    b.optionalElement("search", BundleEntrySearchSerializer.descriptor)
    b.optionalElement("request", BundleEntryRequestSerializer.descriptor)
    b.optionalElement("response", BundleEntryResponseSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry {
    val descriptor = this.descriptor
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      link = listOrEmpty(link),
      fullUrl = Uri.of(fullUrl, _fullUrl),
      resource = resource,
      search = search,
      request = request,
      response = response,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry) {
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
    compositeEncoder.encodeListIfNotEmpty(
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

internal object BundleEntrySearchSerializer : FhirSerializer<Bundle.Entry.Search> {
  override val descriptor: SerialDescriptor = buildDescriptor("Search", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Bundle.Entry.Search>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("mode")
    b.prim("score", FhirDecimalSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Search {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var mode: SearchEntryMode? = null
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
        3 -> mode = SearchEntryMode.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Search(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      mode = Enumeration.of(mode, _mode),
      score = Decimal.of(score, _score),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Search) {
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

internal object BundleEntryRequestSerializer : FhirSerializer<Bundle.Entry.Request> {
  override val descriptor: SerialDescriptor = buildDescriptor("Request", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Bundle.Entry.Request>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("method")
    b.strPrim("url")
    b.strPrim("ifNoneMatch")
    b.strPrim("ifModifiedSince")
    b.strPrim("ifMatch")
    b.strPrim("ifNoneExist")
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Request {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var method: HTTPVerb? = null
    var _method: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var ifNoneMatch: KotlinString? = null
    var _ifNoneMatch: Element? = null
    var ifModifiedSince: FhirDateTime? = null
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
        3 -> method = HTTPVerb.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
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
        9 ->
          ifModifiedSince =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Request(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      method = required(Enumeration.of(method, _method), "Bundle.Entry.Request", "method"),
      url = required(Uri.of(url, _url), "Bundle.Entry.Request", "url"),
      ifNoneMatch = R5String.of(ifNoneMatch, _ifNoneMatch),
      ifModifiedSince = Instant.of(ifModifiedSince, _ifModifiedSince),
      ifMatch = R5String.of(ifMatch, _ifMatch),
      ifNoneExist = R5String.of(ifNoneExist, _ifNoneExist),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Request) {
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

internal object BundleEntryResponseSerializer : FhirSerializer<Bundle.Entry.Response> {
  override val descriptor: SerialDescriptor = buildDescriptor("Response", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Bundle.Entry.Response>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.strPrim("location")
    b.strPrim("etag")
    b.strPrim("lastModified")
    b.optionalElement("outcome", lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer))
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Response {
    val descriptor = this.descriptor
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
    var lastModified: FhirDateTime? = null
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
        9 ->
          lastModified =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Bundle.Entry.Response(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      status = required(R5String.of(status, _status), "Bundle.Entry.Response", "status"),
      location = Uri.of(location, _location),
      etag = R5String.of(etag, _etag),
      lastModified = Instant.of(lastModified, _lastModified),
      outcome = outcome,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Response) {
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
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("timestamp")
    b.intPrim("total")
    b.optionalElement("link", BundleLinkSerializer.listSerializer.descriptor)
    b.optionalElement("entry", BundleEntrySerializer.listSerializer.descriptor)
    b.optionalElement("signature", SignatureSerializer.descriptor)
    b.optionalElement("issues", lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer))
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
    var type: BundleType? = null
    var _type: Element? = null
    var timestamp: FhirDateTime? = null
    var _timestamp: Element? = null
    var total: Int? = null
    var _total: Element? = null
    var link: List<Bundle.Link>? = null
    var entry: List<Bundle.Entry>? = null
    var signature: Signature? = null
    var issues: Resource? = null
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
        7 -> type = BundleType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        8 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          timestamp = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
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
        16 ->
          issues =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return Bundle(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      identifier = identifier,
      type = required(Enumeration.of(type, _type), "Bundle", "type"),
      timestamp = Instant.of(timestamp, _timestamp),
      total = UnsignedInt.of(total, _total),
      link = listOrEmpty(link),
      entry = listOrEmpty(entry),
      signature = signature,
      issues = issues,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13 + descriptorOffset,
      BundleLinkSerializer.listSerializer,
      value.link,
    )
    compositeEncoder.encodeListIfNotEmpty(
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      ResourcePolymorphicSerializer,
      value.issues,
    )
  }
}
