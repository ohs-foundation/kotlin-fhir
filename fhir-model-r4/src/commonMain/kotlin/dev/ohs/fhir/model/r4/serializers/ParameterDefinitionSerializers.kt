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
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ParameterDefinitionSerializer : KSerializer<ParameterDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ParameterDefinition") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement(
        "extension",
        listSerialDescriptor(lazyDescriptor { ExtensionSerializer.descriptor }),
      )
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("use", KotlinString.serializer().descriptor)
      optionalElement("_use", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("min", Int.serializer().descriptor)
      optionalElement("_min", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("max", KotlinString.serializer().descriptor)
      optionalElement("_max", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("documentation", KotlinString.serializer().descriptor)
      optionalElement("_documentation", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", lazyDescriptor { ElementSerializer.descriptor })
      optionalElement("profile", KotlinString.serializer().descriptor)
      optionalElement("_profile", lazyDescriptor { ElementSerializer.descriptor })
    }

  internal val listSerializer: KSerializer<List<ParameterDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): ParameterDefinition =
    decoder.decodeStructure(descriptor) {
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
          2 -> name = decodeStringElement(descriptor, i)
          3 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          4 -> use = decodeStringElement(descriptor, i)
          5 -> _use = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> min = decodeIntElement(descriptor, i)
          7 -> _min = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> max = decodeStringElement(descriptor, i)
          9 -> _max = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> documentation = decodeStringElement(descriptor, i)
          11 ->
            _documentation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> type = decodeStringElement(descriptor, i)
          13 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> profile = decodeStringElement(descriptor, i)
          15 -> _profile = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding ParameterDefinition: " + i)
        }
      }
      ParameterDefinition(
        id = id,
        extension = extension ?: listOf(),
        name = Code.of(name, _name),
        use =
          Enumeration.of(
            if (use != null) ParameterDefinition.OperationParameterUse.fromCode(use) else null,
            _use,
          )
            ?: throw SerializationException(
              "Missing required property 'use' on ParameterDefinition"
            ),
        min = Integer.of(min, _min),
        max = R4String.of(max, _max),
        documentation = R4String.of(documentation, _documentation),
        type =
          Enumeration.of(if (type != null) FHIRAllTypes.fromCode(type) else null, _type)
            ?: throw SerializationException(
              "Missing required property 'type' on ParameterDefinition"
            ),
        profile = Canonical.of(profile, _profile),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ParameterDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      encodeStringIfNotNull(descriptor, 2, value.name?.value)
      encodeElementIfNotNull(descriptor, 3, value.name)
      encodeStringIfNotNull(descriptor, 4, value.use.value?.code)
      encodeElementIfNotNull(descriptor, 5, value.use)
      encodeIntIfNotNull(descriptor, 6, value.min?.value)
      encodeElementIfNotNull(descriptor, 7, value.min)
      encodeStringIfNotNull(descriptor, 8, value.max?.value)
      encodeElementIfNotNull(descriptor, 9, value.max)
      encodeStringIfNotNull(descriptor, 10, value.documentation?.value)
      encodeElementIfNotNull(descriptor, 11, value.documentation)
      encodeStringIfNotNull(descriptor, 12, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 13, value.type)
      encodeStringIfNotNull(descriptor, 14, value.profile?.value)
      encodeElementIfNotNull(descriptor, 15, value.profile)
    }
  }
}
