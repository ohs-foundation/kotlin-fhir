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

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.RelatedArtifact
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Url
import dev.ohs.fhir.model.r4b.terminologies.RelatedArtifactType
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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object RelatedArtifactSerializer : KSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedArtifact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("citation", KotlinString.serializer().descriptor)
      optionalElement("_citation", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("document", lazyDescriptor { AttachmentSerializer.descriptor })
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<RelatedArtifact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RelatedArtifact {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
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
        2 -> type = compositeDecoder.decodeStringElement(descriptor, i)
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
        else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return RelatedArtifact(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(if (type != null) RelatedArtifactType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on RelatedArtifact"),
      label = R4bString.of(label, _label),
      display = R4bString.of(display, _display),
      citation = Markdown.of(citation, _citation),
      url = Url.of(url, _url),
      document = document,
      resource = Canonical.of(resource, _resource),
    )
  }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
