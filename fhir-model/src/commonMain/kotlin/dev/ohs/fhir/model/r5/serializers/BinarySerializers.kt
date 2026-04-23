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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Base64Binary
import dev.ohs.fhir.model.r5.Binary
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Uri
import kotlin.String
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.serializer
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
      element("id", String.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", String.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", String.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("contentType", String.serializer().descriptor, isOptional = true)
      element("_contentType", Element.serializer().descriptor, isOptional = true)
      element("securityContext", Reference.serializer().descriptor, isOptional = true)
      element("data", String.serializer().descriptor, isOptional = true)
      element("_data", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Binary =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Binary) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Binary {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> contentType = decoder.decodeStringElement(__desc, 7)
        8 ->
          _contentType =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.implicitRulesSer, null)
        9 ->
          securityContext =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.securityContextSer, null)
        10 -> `data` = decoder.decodeStringElement(__desc, 10)
        11 ->
          _data =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.implicitRulesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Binary: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Binary) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Binary")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    ((value.contentType.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.contentType.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.implicitRulesSer, it)
    }
    (value.securityContext)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.securityContextSer, it)
    }
    ((value.`data`?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.`data`?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.implicitRulesSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val securityContextSer: KSerializer<Reference> = Reference.serializer()
  }
}
