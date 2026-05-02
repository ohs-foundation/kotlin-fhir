/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r5.serializers

import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.Group
import com.google.fhir.model.r5.surrogates.GroupCharacteristicSurrogate
import com.google.fhir.model.r5.surrogates.GroupCharacteristicValueSurrogate
import com.google.fhir.model.r5.surrogates.GroupMemberSurrogate
import com.google.fhir.model.r5.surrogates.GroupSurrogate
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

public object GroupCharacteristicSerializer : KSerializer<Group.Characteristic> {
  internal val surrogateSerializer: KSerializer<GroupCharacteristicSurrogate> by lazy {
    GroupCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Group.Characteristic {
    val jsonDecoder =
      decoder as? JsonDecoder ?: error("This serializer only supports JSON decoding")
    val oldJsonObject =
      JsonObject(
        jsonDecoder.decodeJsonElement().jsonObject.toMutableMap().apply { remove("resourceType") }
      )
    val unflattenedJsonObject = FhirJsonTransformer.unflatten(oldJsonObject, multiChoiceProperties)
    val surrogate =
      jsonDecoder.json.decodeFromJsonElement(surrogateSerializer, unflattenedJsonObject)
    return surrogate.toModel()
  }

  override fun serialize(encoder: Encoder, `value`: Group.Characteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = GroupCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object GroupMemberSerializer : KSerializer<Group.Member> {
  internal val surrogateSerializer: KSerializer<GroupMemberSurrogate> by lazy {
    GroupMemberSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Member", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Group.Member =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Group.Member) {
    surrogateSerializer.serialize(encoder, GroupMemberSurrogate.fromModel(value))
  }
}

public object GroupCharacteristicValueSerializer : KSerializer<Group.Characteristic.Value> {
  internal val surrogateSerializer: KSerializer<GroupCharacteristicValueSurrogate> by lazy {
    GroupCharacteristicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Group.Characteristic.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Group.Characteristic.Value) {
    surrogateSerializer.serialize(encoder, GroupCharacteristicValueSurrogate.fromModel(value))
  }
}

public object GroupSerializer : KSerializer<Group> {
  internal val surrogateSerializer: KSerializer<GroupSurrogate> by lazy {
    GroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Group", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Group =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Group) {
    surrogateSerializer.serialize(encoder, GroupSurrogate.fromModel(value))
  }
}
