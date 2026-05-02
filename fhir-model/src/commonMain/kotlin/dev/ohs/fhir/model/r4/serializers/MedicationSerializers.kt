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
import com.google.fhir.model.r4b.Medication
import com.google.fhir.model.r4b.surrogates.MedicationBatchSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationIngredientItemSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationIngredientSurrogate
import com.google.fhir.model.r4b.surrogates.MedicationSurrogate
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

public object MedicationIngredientSerializer : KSerializer<Medication.Ingredient> {
  internal val surrogateSerializer: KSerializer<MedicationIngredientSurrogate> by lazy {
    MedicationIngredientSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("item")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Ingredient", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Medication.Ingredient {
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

  override fun serialize(encoder: Encoder, `value`: Medication.Ingredient) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MedicationIngredientSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MedicationBatchSerializer : KSerializer<Medication.Batch> {
  internal val surrogateSerializer: KSerializer<MedicationBatchSurrogate> by lazy {
    MedicationBatchSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Batch", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Medication.Batch =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Medication.Batch) {
    surrogateSerializer.serialize(encoder, MedicationBatchSurrogate.fromModel(value))
  }
}

public object MedicationIngredientItemSerializer : KSerializer<Medication.Ingredient.Item> {
  internal val surrogateSerializer: KSerializer<MedicationIngredientItemSurrogate> by lazy {
    MedicationIngredientItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Medication.Ingredient.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Medication.Ingredient.Item) {
    surrogateSerializer.serialize(encoder, MedicationIngredientItemSurrogate.fromModel(value))
  }
}

public object MedicationSerializer : KSerializer<Medication> {
  internal val surrogateSerializer: KSerializer<MedicationSurrogate> by lazy {
    MedicationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Medication", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Medication =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Medication) {
    surrogateSerializer.serialize(encoder, MedicationSurrogate.fromModel(value))
  }
}
