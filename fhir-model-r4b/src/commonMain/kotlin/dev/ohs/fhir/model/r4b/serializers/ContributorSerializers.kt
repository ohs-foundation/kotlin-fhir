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

import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Contributor
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.ContributorType
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

internal object ContributorSerializer : KSerializer<Contributor> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contributor") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement(
        "contact",
        listSerialDescriptor(lazyDescriptor { ContactDetailSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Contributor>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contributor {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var contact: List<ContactDetail>? = null
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
        2 -> type = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _type =
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
        6 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contributor: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Contributor(
      id = id,
      extension = extension ?: listOf(),
      type =
        Enumeration.of(if (type != null) ContributorType.fromCode(type) else null, _type)
          ?: throw SerializationException("Missing required property 'type' on Contributor"),
      name =
        R4bString.of(name, _name)
          ?: throw SerializationException("Missing required property 'name' on Contributor"),
      contact = contact ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Contributor) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.name.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.name)
    if (value.contact.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    compositeEncoder.endStructure(descriptor)
  }
}
