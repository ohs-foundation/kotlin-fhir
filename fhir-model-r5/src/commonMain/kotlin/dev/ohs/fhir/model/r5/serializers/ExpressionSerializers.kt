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

import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Expression
import dev.ohs.fhir.model.r5.ExtensibleEnumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ExpressionSerializer : KSerializer<Expression> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Expression") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("reference", KotlinString.serializer().descriptor)
      optionalElement("_reference", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Expression>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Expression {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> expression = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> reference = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _reference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Expression: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Expression(
      id = id,
      extension = extension ?: listOf(),
      description = R5String.of(description, _description),
      name = Code.of(name, _name),
      language = ExtensibleEnumeration.of<Expression.ExpressionLanguage>(language, _language),
      expression = R5String.of(expression, _expression),
      reference = Uri.of(reference, _reference),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Expression) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.description)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.language?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.language)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.expression?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.expression)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.reference?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.reference)
    compositeEncoder.endStructure(descriptor)
  }
}
