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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object ExpressionSerializer : KSerializer<Expression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expression") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("reference", KotlinString.serializer().descriptor, isOptional = true)
      element("_reference", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Expression =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Expression) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Expression {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    var reference: KotlinString? = null
    var _reference: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> description = decoder.decodeStringElement(descriptor, i)
        3 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        4 -> name = decoder.decodeStringElement(descriptor, i)
        5 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        6 -> language = decoder.decodeStringElement(descriptor, i)
        7 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        8 -> expression = decoder.decodeStringElement(descriptor, i)
        9 ->
          _expression =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        10 -> reference = decoder.decodeStringElement(descriptor, i)
        11 ->
          _reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expression: " + i)
      }
    }
    return Expression(
      id = id,
      extension = extension ?: listOf(),
      description = R5String.of(description, _description),
      name = Code.of(name, _name),
      language =
        language?.let { Enumeration.of(Expression.ExpressionLanguage.fromCode(it), _language) },
      expression = R5String.of(expression, _expression),
      reference = Uri.of(reference, _reference),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Expression) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.descriptionSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.descriptionSer, it)
    }
    ((value.language?.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.descriptionSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.descriptionSer, it)
    }
    ((value.reference?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.reference?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}
