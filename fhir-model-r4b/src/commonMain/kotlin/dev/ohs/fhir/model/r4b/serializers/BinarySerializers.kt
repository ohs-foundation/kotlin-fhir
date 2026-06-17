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

import dev.ohs.fhir.model.r4b.Base64Binary
import dev.ohs.fhir.model.r4b.Binary
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object BinarySerializer : KSerializer<Binary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binary") {
      element("resourceType", String.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", String.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", String.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", String.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("contentType", String.serializer().descriptor, isOptional = true)
    b.element("_contentType", Element.serializer().descriptor, isOptional = true)
    b.element("securityContext", Reference.serializer().descriptor, isOptional = true)
    b.element("data", String.serializer().descriptor, isOptional = true)
    b.element("_data", Element.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Binary =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Binary) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Binary")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Binary {
    var id: String? = null
    var meta: Meta? = null
    var implicitRules: String? = null
    var _implicitRules: Element? = null
    var language: String? = null
    var _language: Element? = null
    var contentType: String? = null
    var _contentType: Element? = null
    var securityContext: Reference? = null
    var `data`: String? = null
    var _data: Element? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> contentType = decoder.decodeStringElement(descriptor, i)
        7 ->
          _contentType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        8 ->
          securityContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.securityContextSer,
              null,
            )
        9 -> `data` = decoder.decodeStringElement(descriptor, i)
        10 ->
          _data =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        else -> throw SerializationException("Unexpected index decoding Binary: " + i)
      }
    }
    return Binary(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      contentType = Code.of(contentType, _contentType)!!,
      securityContext = securityContext,
      `data` = Base64Binary.of(`data`, _data),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Binary,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.contentType.value))?.let {
      encoder.encodeStringElement(descriptor, 6 + descriptorOffset, it)
    }
    (value.contentType.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.securityContext)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.securityContextSer,
        it,
      )
    }
    ((value.`data`?.value))?.let {
      encoder.encodeStringElement(descriptor, 9 + descriptorOffset, it)
    }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val securityContextSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object BinaryPolymorphicSerializer : KSerializer<Binary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Binary") { BinarySerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Binary) {
    encoder.encodeStructure(descriptor) {
      BinarySerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Binary =
    decoder.decodeStructure(descriptor) {
      BinarySerializer.deserializeInternal(this, descriptor, 0)
    }
}
