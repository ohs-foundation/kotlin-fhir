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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Id
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Uri
import kotlin.OptIn
import kotlin.String
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MetaSerializer : FhirSerializer<Meta> {
  override val descriptor: SerialDescriptor = buildDescriptor("Meta", this)

  @JvmField internal val listSerializer: KSerializer<List<Meta>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("versionId")
    b.strPrim("lastUpdated")
    b.strPrim("source")
    b.strPrimList("profile")
    b.optionalElement(
      "security",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.CodingSerializer)),
    )
    b.optionalElement(
      "tag",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.CodingSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): Meta {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var versionId: String? = null
    var _versionId: Element? = null
    var lastUpdated: FhirDateTime? = null
    var _lastUpdated: Element? = null
    var source: String? = null
    var _source: Element? = null
    var profile: List<String?>? = null
    var _profile: List<Element?>? = null
    var security: List<Coding>? = null
    var tag: List<Coding>? = null
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
        2 -> versionId = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _versionId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          lastUpdated = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _lastUpdated =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> source = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          security =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        11 ->
          tag =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val profile_ =
      List(maxSize(profile, _profile)) { index ->
        entryRequired(Canonical.of(at(profile, index), at(_profile, index)), "Meta", "profile")
      }
    return Meta(
      id = id,
      extension = listOrEmpty(extension),
      versionId = Id.of(versionId, _versionId),
      lastUpdated = Instant.of(lastUpdated, _lastUpdated),
      source = Uri.of(source, _source),
      profile = profile_,
      security = listOrEmpty(security),
      tag = listOrEmpty(tag),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Meta) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.versionId?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.versionId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.lastUpdated?.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.lastUpdated)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.source?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.source)
    if (!value.profile.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        8,
        stringNullableListSerializer,
        value.profile.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 9, value.profile)
    }
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10,
      CodingSerializer.listSerializer,
      value.security,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      11,
      CodingSerializer.listSerializer,
      value.tag,
    )
    compositeEncoder.endStructure(descriptor)
  }
}
