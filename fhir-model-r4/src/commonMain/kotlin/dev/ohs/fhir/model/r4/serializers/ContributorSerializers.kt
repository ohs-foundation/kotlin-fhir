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

import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Contributor
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.String as R4String
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

internal object ContributorSerializer : KSerializer<Contributor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contributor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contributor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contributor =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var contact: List<ContactDetail>? = null
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
          2 -> type = decodeStringElement(descriptor, i)
          3 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> name = decodeStringElement(descriptor, i)
          5 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            contact =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContactDetailSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contributor: " + i)
        }
      }
      Contributor(
        id = id,
        extension = extension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) Contributor.ContributorType.fromCode(type) else null,
            _type,
          ) ?: throw SerializationException("Missing required property 'type' on Contributor"),
        name =
          R4String.of(name, _name)
            ?: throw SerializationException("Missing required property 'name' on Contributor"),
        contact = contact ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contributor) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 3, value.type)
      encodeStringIfNotNull(descriptor, 4, value.name.value)
      encodeElementIfNotNull(descriptor, 5, value.name)
      if (value.contact.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ContactDetailSerializer.listSerializer,
          value.contact,
        )
    }
  }
}
