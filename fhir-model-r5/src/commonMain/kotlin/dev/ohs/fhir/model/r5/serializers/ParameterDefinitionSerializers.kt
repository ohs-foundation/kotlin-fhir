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

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.ParameterDefinition
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.FHIRTypes
import dev.ohs.fhir.model.r5.terminologies.OperationParameterUse
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object ParameterDefinitionSerializer : FhirSerializer<ParameterDefinition> {
  override val descriptor: SerialDescriptor = buildDescriptor("ParameterDefinition", this)

  @JvmField
  internal val listSerializer: KSerializer<List<ParameterDefinition>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement(
      "extension",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ExtensionSerializer)),
    )
    b.strPrim("name")
    b.strPrim("use")
    b.intPrim("min")
    b.strPrim("max")
    b.strPrim("documentation")
    b.strPrim("type")
    b.strPrim("profile")
  }

  override fun deserialize(decoder: Decoder): ParameterDefinition {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var use: OperationParameterUse? = null
    var _use: Element? = null
    var min: Int? = null
    var _min: Element? = null
    var max: KotlinString? = null
    var _max: Element? = null
    var documentation: KotlinString? = null
    var _documentation: Element? = null
    var type: FHIRTypes? = null
    var _type: Element? = null
    var profile: KotlinString? = null
    var _profile: Element? = null
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
        2 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 ->
          use = OperationParameterUse.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _use =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> min = compositeDecoder.decodeIntElement(descriptor, i)
        7 ->
          _min =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 -> max = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _max =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> documentation = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _documentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 -> type = FHIRTypes.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 -> profile = compositeDecoder.decodeStringElement(descriptor, i)
        15 ->
          _profile =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return ParameterDefinition(
      id = id,
      extension = listOrEmpty(extension),
      name = Code.of(name, _name),
      use = required(Enumeration.of(use, _use), "ParameterDefinition", "use"),
      min = Integer.of(min, _min),
      max = R5String.of(max, _max),
      documentation = R5String.of(documentation, _documentation),
      type = required(Enumeration.of(type, _type), "ParameterDefinition", "type"),
      profile = Canonical.of(profile, _profile),
    )
  }

  override fun serialize(encoder: Encoder, `value`: ParameterDefinition) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 2, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 3, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.use.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.use)
    compositeEncoder.encodeIntIfNotNull(descriptor, 6, value.min?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.min)
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.max?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.max)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.documentation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.documentation)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 14, value.profile?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 15, value.profile)
    compositeEncoder.endStructure(descriptor)
  }
}
