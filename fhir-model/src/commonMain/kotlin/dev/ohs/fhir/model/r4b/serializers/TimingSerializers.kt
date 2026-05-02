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

package com.google.fhir.model.r4b.serializers

import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.Timing
import com.google.fhir.model.r4b.surrogates.TimingRepeatBoundsSurrogate
import com.google.fhir.model.r4b.surrogates.TimingRepeatSurrogate
import com.google.fhir.model.r4b.surrogates.TimingSurrogate
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

public object TimingRepeatSerializer : KSerializer<Timing.Repeat> {
  internal val surrogateSerializer: KSerializer<TimingRepeatSurrogate> by lazy {
    TimingRepeatSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("bounds")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Repeat", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Timing.Repeat {
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

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TimingRepeatSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TimingRepeatBoundsSerializer : KSerializer<Timing.Repeat.Bounds> {
  internal val surrogateSerializer: KSerializer<TimingRepeatBoundsSurrogate> by lazy {
    TimingRepeatBoundsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Bounds", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Timing.Repeat.Bounds =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Timing.Repeat.Bounds) {
    surrogateSerializer.serialize(encoder, TimingRepeatBoundsSurrogate.fromModel(value))
  }
}

public object TimingSerializer : KSerializer<Timing> {
  internal val surrogateSerializer: KSerializer<TimingSurrogate> by lazy {
    TimingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Timing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Timing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Timing) {
    surrogateSerializer.serialize(encoder, TimingSurrogate.fromModel(value))
  }
}
