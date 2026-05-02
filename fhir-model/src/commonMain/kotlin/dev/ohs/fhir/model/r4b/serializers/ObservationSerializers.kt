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
import com.google.fhir.model.r4b.Observation
import com.google.fhir.model.r4b.surrogates.ObservationComponentSurrogate
import com.google.fhir.model.r4b.surrogates.ObservationComponentValueSurrogate
import com.google.fhir.model.r4b.surrogates.ObservationEffectiveSurrogate
import com.google.fhir.model.r4b.surrogates.ObservationReferenceRangeSurrogate
import com.google.fhir.model.r4b.surrogates.ObservationSurrogate
import com.google.fhir.model.r4b.surrogates.ObservationValueSurrogate
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

public object ObservationReferenceRangeSerializer : KSerializer<Observation.ReferenceRange> {
  internal val surrogateSerializer: KSerializer<ObservationReferenceRangeSurrogate> by lazy {
    ObservationReferenceRangeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferenceRange", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation.ReferenceRange =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Observation.ReferenceRange) {
    surrogateSerializer.serialize(encoder, ObservationReferenceRangeSurrogate.fromModel(value))
  }
}

public object ObservationComponentSerializer : KSerializer<Observation.Component> {
  internal val surrogateSerializer: KSerializer<ObservationComponentSurrogate> by lazy {
    ObservationComponentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation.Component {
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

  override fun serialize(encoder: Encoder, `value`: Observation.Component) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ObservationComponentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ObservationEffectiveSerializer : KSerializer<Observation.Effective> {
  internal val surrogateSerializer: KSerializer<ObservationEffectiveSurrogate> by lazy {
    ObservationEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Effective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation.Effective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Observation.Effective) {
    surrogateSerializer.serialize(encoder, ObservationEffectiveSurrogate.fromModel(value))
  }
}

public object ObservationValueSerializer : KSerializer<Observation.Value> {
  internal val surrogateSerializer: KSerializer<ObservationValueSurrogate> by lazy {
    ObservationValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Observation.Value) {
    surrogateSerializer.serialize(encoder, ObservationValueSurrogate.fromModel(value))
  }
}

public object ObservationComponentValueSerializer : KSerializer<Observation.Component.Value> {
  internal val surrogateSerializer: KSerializer<ObservationComponentValueSurrogate> by lazy {
    ObservationComponentValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation.Component.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Observation.Component.Value) {
    surrogateSerializer.serialize(encoder, ObservationComponentValueSurrogate.fromModel(value))
  }
}

public object ObservationSerializer : KSerializer<Observation> {
  internal val surrogateSerializer: KSerializer<ObservationSurrogate> by lazy {
    ObservationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("effective", "value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Observation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Observation {
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

  override fun serialize(encoder: Encoder, `value`: Observation) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ObservationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
