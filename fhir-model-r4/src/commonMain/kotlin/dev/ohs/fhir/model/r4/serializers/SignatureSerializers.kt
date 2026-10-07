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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Base64Binary
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Instant
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Signature
import kotlin.OptIn
import kotlin.String
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

internal object SignatureSerializer : KSerializer<Signature> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Signature") {
      optionalElement("id", String.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("type", listSerialDescriptor(lazyDescriptor { CodingSerializer.descriptor }))
      optionalElement("when", String.serializer().descriptor)
      optionalElement("_when", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("who", lazyDescriptor { ReferenceSerializer.descriptor })
      optionalElement("onBehalfOf", lazyDescriptor { ReferenceSerializer.descriptor })
      optionalElement("targetFormat", String.serializer().descriptor)
      optionalElement("_targetFormat", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("sigFormat", String.serializer().descriptor)
      optionalElement("_sigFormat", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("data", String.serializer().descriptor)
      optionalElement("_data", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<Signature>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Signature {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: String? = null
    var extension: List<Extension>? = null
    var type: List<Coding>? = null
    var `when`: String? = null
    var _when: Element? = null
    var who: Reference? = null
    var onBehalfOf: Reference? = null
    var targetFormat: String? = null
    var _targetFormat: Element? = null
    var sigFormat: String? = null
    var _sigFormat: Element? = null
    var `data`: String? = null
    var _data: Element? = null
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
        2 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        3 -> `when` = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _when =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          who =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        6 ->
          onBehalfOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 -> targetFormat = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _targetFormat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> sigFormat = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _sigFormat =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> `data` = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _data =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Signature: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Signature(
      id = id,
      extension = extension ?: listOf(),
      type = type ?: listOf(),
      `when` =
        Instant.of(if (`when` != null) FhirDateTime.fromString(`when`) else null, _when)
          ?: throw SerializationException("Missing required property 'when' on Signature"),
      who = who ?: throw SerializationException("Missing required property 'who' on Signature"),
      onBehalfOf = onBehalfOf,
      targetFormat = Code.of(targetFormat, _targetFormat),
      sigFormat = Code.of(sigFormat, _sigFormat),
      `data` = Base64Binary.of(`data`, _data),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Signature) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.type.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        CodingSerializer.listSerializer,
        value.type,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.`when`.value?.toString())
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.`when`)
    compositeEncoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.who)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      ReferenceSerializer,
      value.onBehalfOf,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.targetFormat?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.targetFormat)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.sigFormat?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.sigFormat)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.`data`?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.`data`)
    compositeEncoder.endStructure(descriptor)
  }
}
