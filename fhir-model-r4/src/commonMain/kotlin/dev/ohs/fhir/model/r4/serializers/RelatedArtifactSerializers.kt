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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Url
import dev.ohs.fhir.model.r4.terminologies.RelatedArtifactType
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object RelatedArtifactSerializer : FhirSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor = buildDescriptor("RelatedArtifact", this)

  @JvmField internal val listSerializer: KSerializer<List<RelatedArtifact>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("type")
    b.strPrim("label")
    b.strPrim("display")
    b.strPrim("citation")
    b.strPrim("url")
    b.optionalElement("document", lazyDescriptor(LazyDescriptorId.AttachmentSerializer))
    b.strPrim("resource")
  }

  override fun deserialize(decoder: Decoder): RelatedArtifact {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: RelatedArtifactType? = null
    var _type: Element? = null
    var label: KotlinString? = null
    var _label: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    var citation: KotlinString? = null
    var _citation: Element? = null
    var url: KotlinString? = null
    var _url: Element? = null
    var document: Attachment? = null
    var resource: KotlinString? = null
    var _resource: Element? = null
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
          type = RelatedArtifactType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        3 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> label = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _label =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> citation = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _citation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          document =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        13 -> resource = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _resource =
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
    return RelatedArtifact(
      id = id,
      extension = listOrEmpty(extension),
      type = required(Enumeration.of(type, _type), "RelatedArtifact", "type"),
      label = R4String.of(label, _label),
      display = R4String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      url = Url.of(url, _url),
      document = document,
      resource = Canonical.of(resource, _resource),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.label?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.label)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.display)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.citation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.citation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.url)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12,
      AttachmentSerializer,
      value.document,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13, value.resource?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.resource)
    compositeEncoder.endStructure(descriptor)
  }
}
