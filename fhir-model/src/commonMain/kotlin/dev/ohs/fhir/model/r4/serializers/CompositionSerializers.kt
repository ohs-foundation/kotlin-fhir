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

import com.google.fhir.model.r4b.Composition
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.CompositionAttesterSurrogate
import com.google.fhir.model.r4b.surrogates.CompositionEventSurrogate
import com.google.fhir.model.r4b.surrogates.CompositionRelatesToSurrogate
import com.google.fhir.model.r4b.surrogates.CompositionRelatesToTargetSurrogate
import com.google.fhir.model.r4b.surrogates.CompositionSectionSurrogate
import com.google.fhir.model.r4b.surrogates.CompositionSurrogate
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

public object CompositionAttesterSerializer : KSerializer<Composition.Attester> {
  internal val surrogateSerializer: KSerializer<CompositionAttesterSurrogate> by lazy {
    CompositionAttesterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Attester", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Attester =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Attester) {
    surrogateSerializer.serialize(encoder, CompositionAttesterSurrogate.fromModel(value))
  }
}

public object CompositionRelatesToSerializer : KSerializer<Composition.RelatesTo> {
  internal val surrogateSerializer: KSerializer<CompositionRelatesToSurrogate> by lazy {
    CompositionRelatesToSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("target")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatesTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.RelatesTo {
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

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CompositionRelatesToSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CompositionEventSerializer : KSerializer<Composition.Event> {
  internal val surrogateSerializer: KSerializer<CompositionEventSurrogate> by lazy {
    CompositionEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Event =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Event) {
    surrogateSerializer.serialize(encoder, CompositionEventSurrogate.fromModel(value))
  }
}

public object CompositionSectionSerializer : KSerializer<Composition.Section> {
  internal val surrogateSerializer: KSerializer<CompositionSectionSurrogate> by lazy {
    CompositionSectionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Section", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Section =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Section) {
    surrogateSerializer.serialize(encoder, CompositionSectionSurrogate.fromModel(value))
  }
}

public object CompositionRelatesToTargetSerializer : KSerializer<Composition.RelatesTo.Target> {
  internal val surrogateSerializer: KSerializer<CompositionRelatesToTargetSurrogate> by lazy {
    CompositionRelatesToTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.RelatesTo.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.RelatesTo.Target) {
    surrogateSerializer.serialize(encoder, CompositionRelatesToTargetSurrogate.fromModel(value))
  }
}

public object CompositionSerializer : KSerializer<Composition> {
  internal val surrogateSerializer: KSerializer<CompositionSurrogate> by lazy {
    CompositionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Composition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition) {
    surrogateSerializer.serialize(encoder, CompositionSurrogate.fromModel(value))
  }
}
