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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.ParameterDefinition
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.FHIRAllTypes
import kotlin.Int
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
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ParameterDefinitionSerializer : KSerializer<ParameterDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ParameterDefinition") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(lazyDescriptor { Extension.serializer().descriptor }),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("use", KotlinString.serializer().descriptor, isOptional = true)
      element("_use", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("min", Int.serializer().descriptor, isOptional = true)
      element("_min", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("max", KotlinString.serializer().descriptor, isOptional = true)
      element("_max", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("documentation", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "_documentation",
        lazyDescriptor { Element.serializer().descriptor },
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
      element("profile", KotlinString.serializer().descriptor, isOptional = true)
      element("_profile", lazyDescriptor { Element.serializer().descriptor }, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ParameterDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: ParameterDefinition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): ParameterDefinition {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var use: KotlinString? = null
    var _use: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 -> name = decoder.decodeStringElement(descriptor, i)
        3 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        4 -> use = decoder.decodeStringElement(descriptor, i)
        5 -> _use = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        6 -> min = decoder.decodeIntElement(descriptor, i)
        7 -> _min = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        8 -> max = decoder.decodeStringElement(descriptor, i)
        9 -> _max = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        10 -> documentation = decoder.decodeStringElement(descriptor, i)
        11 ->
          _documentation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        12 -> type = decoder.decodeStringElement(descriptor, i)
        13 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        14 -> profile = decoder.decodeStringElement(descriptor, i)
        15 ->
          _profile = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ParameterDefinition: " + i)
      }
    }
    return ParameterDefinition(
      id = id,
      extension = extension ?: listOf(),
      name = Code.of(name, _name),
      use =
        Enumeration.of(use?.let { ParameterDefinition.OperationParameterUse.fromCode(it) }, _use)
          ?: throw SerializationException("Missing required property 'use' on ParameterDefinition"),
      min = Integer.of(min, _min),
      max = R4String.of(max, _max),
      documentation = R4String.of(documentation, _documentation),
      type =
        Enumeration.of(type?.let { FHIRAllTypes.fromCode(it) }, _type)
          ?: throw SerializationException(
            "Missing required property 'type' on ParameterDefinition"
          ),
      profile = Canonical.of(profile, _profile),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: ParameterDefinition) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 2, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.nameSer, it)
    }
    ((value.use.value?.code))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.use.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.nameSer, it)
    }
    ((value.min?.value))?.let { encoder.encodeIntElement(descriptor, 6, it) }
    (value.min?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.nameSer, it)
    }
    ((value.max?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.max?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.nameSer, it)
    }
    ((value.documentation?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.documentation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.nameSer, it)
    }
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.nameSer, it)
    }
    ((value.profile?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.profile?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()
  }
}
