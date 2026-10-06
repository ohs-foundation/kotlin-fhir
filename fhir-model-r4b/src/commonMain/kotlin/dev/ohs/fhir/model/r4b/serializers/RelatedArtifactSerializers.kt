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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object RelatedArtifactSerializer : KSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedArtifact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("label", KotlinString.serializer().descriptor)
      optionalElement("_label", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
      optionalElement("citation", KotlinString.serializer().descriptor)
      optionalElement("_citation", ElementSerializer.descriptor)
      optionalElement("url", KotlinString.serializer().descriptor)
      optionalElement("_url", ElementSerializer.descriptor)
      optionalElement("document", AttachmentSerializer.descriptor)
      optionalElement("resource", KotlinString.serializer().descriptor)
      optionalElement("_resource", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<RelatedArtifact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): RelatedArtifact =
    decoder.decodeStructure(descriptor) {
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
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> label = decodeStringElement(descriptor, i)
          5 -> _label = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> display = decodeStringElement(descriptor, i)
          7 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> citation = decodeStringElement(descriptor, i)
          9 -> _citation = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> url = decodeStringElement(descriptor, i)
          11 -> _url = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            document = decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          13 -> resource = decodeStringElement(descriptor, i)
          14 ->
            _resource = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + i)
        }
      }
      RelatedArtifact(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) RelatedArtifact.RelatedArtifactType.fromCode(type) else null,
            _type,
          ) ?: throw SerializationException("Missing required property 'type' on RelatedArtifact"),
        label = R4bString.of(label, _label),
        display = R4bString.of(display, _display),
        citation = Markdown.of(citation, _citation),
        url = Url.of(url, _url),
        document = document,
        resource = Canonical.of(resource, _resource),
      )
    }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      encodeStringIfNotNull(descriptor, 4, value.label?.value)
      encodeElementIfNotNull(descriptor, 5, value.label)
      encodeStringIfNotNull(descriptor, 6, value.display?.value)
      encodeElementIfNotNull(descriptor, 7, value.display)
      encodeStringIfNotNull(descriptor, 8, value.citation?.value)
      encodeElementIfNotNull(descriptor, 9, value.citation)
      encodeStringIfNotNull(descriptor, 10, value.url?.value)
      encodeElementIfNotNull(descriptor, 11, value.url)
      encodeSerializableIfNotNull(descriptor, 12, AttachmentSerializer, value.document)
      encodeStringIfNotNull(descriptor, 13, value.resource?.value)
      encodeElementIfNotNull(descriptor, 14, value.resource)
    }
  }
}
