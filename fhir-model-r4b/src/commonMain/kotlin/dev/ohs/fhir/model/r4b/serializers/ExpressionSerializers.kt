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

import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Expression
import dev.ohs.fhir.model.r4b.ExtensibleEnumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.Id
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object ExpressionSerializer : KSerializer<Expression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expression") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
      optionalElement("reference", KotlinString.serializer().descriptor)
      optionalElement("_reference", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Expression>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Expression =
    decoder.decodeStructure(descriptor) {
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
          2 -> description = decodeStringElement(descriptor, i)
          3 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> name = decodeStringElement(descriptor, i)
          5 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> language = decodeStringElement(descriptor, i)
          7 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> expression = decodeStringElement(descriptor, i)
          9 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> reference = decodeStringElement(descriptor, i)
          11 ->
            _reference = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Expression: " + i)
        }
      }
      Expression(
        id = id,
        extension = extension ?: listOf(),
        description = R4bString.of(description, _description),
        name = Id.of(name, _name),
        language =
          ExtensibleEnumeration.of<Expression.ExpressionLanguage>(language, _language)
            ?: throw SerializationException("Missing required property 'language' on Expression"),
        expression = R4bString.of(expression, _expression),
        reference = Uri.of(reference, _reference),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Expression) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.description?.value)
      encodeElementIfNotNull(descriptor, 3, value.description)
      encodeStringIfNotNull(descriptor, 4, value.name?.value)
      encodeElementIfNotNull(descriptor, 5, value.name)
      encodeStringElement(descriptor, 6, value.language.code)
      encodeElementIfNotNull(descriptor, 7, value.language)
      encodeStringIfNotNull(descriptor, 8, value.expression?.value)
      encodeElementIfNotNull(descriptor, 9, value.expression)
      encodeStringIfNotNull(descriptor, 10, value.reference?.value)
      encodeElementIfNotNull(descriptor, 11, value.reference)
    }
  }
}
