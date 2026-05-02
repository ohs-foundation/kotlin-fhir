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

package com.google.fhir.model.r4.serializers

import com.google.fhir.model.r4.ConceptMap
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.ConceptMapGroupElementSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapGroupElementTargetDependsOnSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapGroupElementTargetSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapGroupSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapGroupUnmappedSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapSourceSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapSurrogate
import com.google.fhir.model.r4.surrogates.ConceptMapTargetSurrogate
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

public object ConceptMapGroupSerializer : KSerializer<ConceptMap.Group> {
  internal val surrogateSerializer: KSerializer<ConceptMapGroupSurrogate> by lazy {
    ConceptMapGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Group", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group) {
    surrogateSerializer.serialize(encoder, ConceptMapGroupSurrogate.fromModel(value))
  }
}

public object ConceptMapGroupElementSerializer : KSerializer<ConceptMap.Group.Element> {
  internal val surrogateSerializer: KSerializer<ConceptMapGroupElementSurrogate> by lazy {
    ConceptMapGroupElementSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Element", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element) {
    surrogateSerializer.serialize(encoder, ConceptMapGroupElementSurrogate.fromModel(value))
  }
}

public object ConceptMapGroupElementTargetSerializer :
  KSerializer<ConceptMap.Group.Element.Target> {
  internal val surrogateSerializer: KSerializer<ConceptMapGroupElementTargetSurrogate> by lazy {
    ConceptMapGroupElementTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target) {
    surrogateSerializer.serialize(encoder, ConceptMapGroupElementTargetSurrogate.fromModel(value))
  }
}

public object ConceptMapGroupElementTargetDependsOnSerializer :
  KSerializer<ConceptMap.Group.Element.Target.DependsOn> {
  internal val surrogateSerializer:
    KSerializer<ConceptMapGroupElementTargetDependsOnSurrogate> by lazy {
    ConceptMapGroupElementTargetDependsOnSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DependsOn", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Element.Target.DependsOn =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Element.Target.DependsOn) {
    surrogateSerializer.serialize(
      encoder,
      ConceptMapGroupElementTargetDependsOnSurrogate.fromModel(value),
    )
  }
}

public object ConceptMapGroupUnmappedSerializer : KSerializer<ConceptMap.Group.Unmapped> {
  internal val surrogateSerializer: KSerializer<ConceptMapGroupUnmappedSurrogate> by lazy {
    ConceptMapGroupUnmappedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Unmapped", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Group.Unmapped =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Group.Unmapped) {
    surrogateSerializer.serialize(encoder, ConceptMapGroupUnmappedSurrogate.fromModel(value))
  }
}

public object ConceptMapSourceSerializer : KSerializer<ConceptMap.Source> {
  internal val surrogateSerializer: KSerializer<ConceptMapSourceSurrogate> by lazy {
    ConceptMapSourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Source", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Source =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Source) {
    surrogateSerializer.serialize(encoder, ConceptMapSourceSurrogate.fromModel(value))
  }
}

public object ConceptMapTargetSerializer : KSerializer<ConceptMap.Target> {
  internal val surrogateSerializer: KSerializer<ConceptMapTargetSurrogate> by lazy {
    ConceptMapTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ConceptMap.Target) {
    surrogateSerializer.serialize(encoder, ConceptMapTargetSurrogate.fromModel(value))
  }
}

public object ConceptMapSerializer : KSerializer<ConceptMap> {
  internal val surrogateSerializer: KSerializer<ConceptMapSurrogate> by lazy {
    ConceptMapSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("source", "target")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ConceptMap", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ConceptMap {
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

  override fun serialize(encoder: Encoder, `value`: ConceptMap) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ConceptMapSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
