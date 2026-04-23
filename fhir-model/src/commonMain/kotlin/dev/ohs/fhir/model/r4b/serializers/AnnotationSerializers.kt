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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String as R4bString
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

internal object AnnotationAuthorSerializer : KSerializer<Annotation.Author> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Annotation.Author") {
      element(
        "authorReference",
        lazyDescriptor { Reference.serializer().descriptor },
        isOptional = true,
      )
      element("authorString", KotlinString.serializer().descriptor, isOptional = true)
      element("_authorString", Element.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Annotation.Author) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Annotation.Author.Reference -> {
          encodeSerializableElement(__desc, 0, Hoisted.authorReferenceSer, __d.value)
        }
        is Annotation.Author.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 1, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 2, Hoisted.elementSer, it)
          }
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Annotation.Author =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Annotation.Author {
    val __desc = descriptor
    var authorReference: Reference? = null
    var authorString: KotlinString? = null
    var _authorString: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          authorReference =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.authorReferenceSer, null)
        1 -> authorString = decoder.decodeStringElement(__desc, 1)
        2 ->
          _authorString =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.elementSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Annotation.Author: " + __i)
      }
    }
    return Annotation.Author.from(authorReference, R4bString.of(authorString, _authorString))!!
  }

  private object Hoisted {
    public val authorReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val elementSer: KSerializer<Element> = Element.serializer()
  }
}

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

  override fun deserialize(decoder: Decoder): Annotation =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Annotation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Annotation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          authorReference =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.authorReferenceSer, null)
        3 -> authorString = decoder.decodeStringElement(__desc, 3)
        4 ->
          _authorString =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.authorStringSer, null)
        5 -> time = decoder.decodeStringElement(__desc, 5)
        6 ->
          _time =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.authorStringSer, null)
        7 -> text = decoder.decodeStringElement(__desc, 7)
        8 ->
          _text =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.authorStringSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Annotation: " + __i)
      }
    }
    return Annotation(
      id = id,
      extension = extension ?: listOf(),
      author = Annotation.Author.from(authorReference, R4bString.of(authorString, _authorString)),
      time = DateTime.of(FhirDateTime.fromString(time), _time),
      text = Markdown.of(text, _text)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Annotation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    when (val __d = value.author) {
      null -> {}
      is Annotation.Author.Reference -> {
        encoder.encodeSerializableElement(__desc, 2, Hoisted.authorReferenceSer, __d.value)
      }
      is Annotation.Author.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.authorStringSer, it)
        }
      }
    }
    ((value.time?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.time?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.authorStringSer, it)
    }
    ((value.text.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.text.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.authorStringSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val authorReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val authorStringSer: KSerializer<Element> = Element.serializer()
  }
}
