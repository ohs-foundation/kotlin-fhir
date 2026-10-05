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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
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

internal object AnnotationSerializer : KSerializer<Annotation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Annotation") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "authorReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("authorString", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_authorString",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("time", KotlinString.serializer().descriptor, isOptional = true)
      element("_time", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Annotation>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Annotation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Annotation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Annotation {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var authorReference: Reference? = null
    var authorString: KotlinString? = null
    var _authorString: Element? = null
    var time: KotlinString? = null
    var _time: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          authorReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        3 -> authorString = decoder.decodeStringElement(descriptor, i)
        4 ->
          _authorString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> time = decoder.decodeStringElement(descriptor, i)
        6 ->
          _time = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> text = decoder.decodeStringElement(descriptor, i)
        8 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Annotation: " + i)
      }
    }
    return Annotation(
      id = id,
      extension = extension ?: listOf(),
      author = Annotation.Author.from(authorReference, R5String.of(authorString, _authorString)),
      time = DateTime.of(time?.let { FhirDateTime.fromString(it) }, _time),
      text =
        Markdown.of(text, _text)
          ?: throw SerializationException("Missing required property 'text' on Annotation"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Annotation) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    when (val choice = value.author) {
      null -> {}
      is Annotation.Author.Reference -> {
        encoder.encodeSerializableElement(descriptor, 2, ReferenceSerializer, choice.value)
      }
      is Annotation.Author.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
        }
      }
    }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.text.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
  }
}
