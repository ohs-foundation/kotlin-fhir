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

import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.MedicinalProductInteraction
import com.google.fhir.model.r4.surrogates.MedicinalProductInteractionInteractantItemSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductInteractionInteractantSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductInteractionSurrogate
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

public object MedicinalProductInteractionInteractantSerializer :
  KSerializer<MedicinalProductInteraction.Interactant> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductInteractionInteractantSurrogate> by lazy {
    MedicinalProductInteractionInteractantSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Interactant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductInteraction.Interactant {
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

  override fun serialize(encoder: Encoder, `value`: MedicinalProductInteraction.Interactant) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicinalProductInteractionInteractantSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MedicinalProductInteractionInteractantItemSerializer :
  KSerializer<MedicinalProductInteraction.Interactant.Item> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductInteractionInteractantItemSurrogate> by lazy {
    MedicinalProductInteractionInteractantItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductInteraction.Interactant.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductInteraction.Interactant.Item) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductInteractionInteractantItemSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductInteractionSerializer : KSerializer<MedicinalProductInteraction> {
  internal val surrogateSerializer: KSerializer<MedicinalProductInteractionSurrogate> by lazy {
    MedicinalProductInteractionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductInteraction", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductInteraction =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductInteraction) {
    surrogateSerializer.serialize(encoder, MedicinalProductInteractionSurrogate.fromModel(value))
  }
}
