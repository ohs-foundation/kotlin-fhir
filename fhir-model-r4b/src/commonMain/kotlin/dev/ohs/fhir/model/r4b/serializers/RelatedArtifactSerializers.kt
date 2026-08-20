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
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object RelatedArtifactSerializer : KSerializer<RelatedArtifact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RelatedArtifact") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("label", KotlinString.serializer().descriptor, isOptional = true)
      element("_label", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("citation", KotlinString.serializer().descriptor, isOptional = true)
      element("_citation", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("document", lazyDescriptor { Attachment.serializer().descriptor }, isOptional = true)
      element("resource", KotlinString.serializer().descriptor, isOptional = true)
      element("_resource", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): RelatedArtifact =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): RelatedArtifact {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(descriptor, i)
        3 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> label = decoder.decodeStringElement(descriptor, i)
        5 ->
          _label = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 -> display = decoder.decodeStringElement(descriptor, i)
        7 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 -> citation = decoder.decodeStringElement(descriptor, i)
        9 ->
          _citation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 -> _url = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 ->
          document =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.documentSer, null)
        13 -> resource = decoder.decodeStringElement(descriptor, i)
        14 ->
          _resource =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + i)
      }
    }
    return RelatedArtifact(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(type?.let { RelatedArtifact.RelatedArtifactType.fromCode(it) }, _type)
          ?: throw SerializationException("Missing required property 'type' on RelatedArtifact"),
      label = R4bString.of(label, _label),
      display = R4bString.of(display, _display),
      citation = Markdown.of(citation, _citation),
      url = Url.of(url, _url),
      document = document,
      resource = Canonical.of(resource, _resource),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: RelatedArtifact) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it)
    }
    ((value.citation?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.citation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.typeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.typeSer, it)
    }
    (value.document)?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.documentSer, it)
    }
    ((value.resource?.value))?.let { encoder.encodeStringElement(descriptor, 13, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val documentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}
