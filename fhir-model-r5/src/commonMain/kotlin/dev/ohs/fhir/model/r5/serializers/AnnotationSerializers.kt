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
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object AnnotationSerializer : KSerializer<Annotation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Annotation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("authorReference", ReferenceSerializer.descriptor)
      optionalElement("authorString", KotlinString.serializer().descriptor)
      optionalElement("_authorString", ElementSerializer.descriptor)
      optionalElement("time", KotlinString.serializer().descriptor)
      optionalElement("_time", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Annotation>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Annotation =
    decoder.decodeStructure(descriptor) {
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
          2 ->
            authorReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          3 -> authorString = decodeStringElement(descriptor, i)
          4 ->
            _authorString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> time = decodeStringElement(descriptor, i)
          6 -> _time = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> text = decodeStringElement(descriptor, i)
          8 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Annotation: " + i)
        }
      }
      Annotation(
        id = id,
        extension = extension ?: listOf(),
        author = Annotation.Author.from(authorReference, R5String.of(authorString, _authorString)),
        time = DateTime.of(if (time != null) FhirDateTime.fromString(time) else null, _time),
        text =
          Markdown.of(text, _text)
            ?: throw SerializationException("Missing required property 'text' on Annotation"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Annotation) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      when (val choice = value.author) {
        null -> {}
        is Annotation.Author.Reference -> {
          encodeSerializableElement(descriptor, 2, ReferenceSerializer, choice.value)
        }
        is Annotation.Author.String -> {
          encodeStringIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
      }
      encodeStringIfNotNull(descriptor, 5, value.time?.value?.toString())
      encodeElementIfNotNull(descriptor, 6, value.time)
      encodeStringIfNotNull(descriptor, 7, value.text.value)
      encodeElementIfNotNull(descriptor, 8, value.text)
    }
  }
}
