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

import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.RelatedArtifact
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Url
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: RelatedArtifact) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): RelatedArtifact {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 -> type = decoder.decodeStringElement(__desc, __i)
        3 -> _type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> label = decoder.decodeStringElement(__desc, __i)
        5 -> _label = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 -> display = decoder.decodeStringElement(__desc, __i)
        7 ->
          _display = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        8 -> citation = decoder.decodeStringElement(__desc, __i)
        9 ->
          _citation = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        10 -> url = decoder.decodeStringElement(__desc, __i)
        11 -> _url = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        12 ->
          document =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.documentSer, null)
        13 -> resource = decoder.decodeStringElement(__desc, __i)
        14 ->
          _resource = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding RelatedArtifact: " + __i)
      }
    }
    return RelatedArtifact(
      id = id,
      extension = extension ?: listOf(),
      type = Enumeration.of(RelatedArtifact.RelatedArtifactType.fromCode(type!!), _type),
      label = R4String.of(label, _label),
      display = R4String.of(display, _display),
      citation = Markdown.of(citation, _citation),
      url = Url.of(url, _url),
      document = document,
      resource = Canonical.of(resource, _resource),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: RelatedArtifact) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 2, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it)
    }
    ((value.label?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.label?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it)
    }
    ((value.citation?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.citation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.typeSer, it)
    }
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, it)
    }
    (value.document)?.let { encoder.encodeSerializableElement(__desc, 12, Hoisted.documentSer, it) }
    ((value.resource?.value))?.let { encoder.encodeStringElement(__desc, 13, it) }
    (value.resource?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.typeSer, it)
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
