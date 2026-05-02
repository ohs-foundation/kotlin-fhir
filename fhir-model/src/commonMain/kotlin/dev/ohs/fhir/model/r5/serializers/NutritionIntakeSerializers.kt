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
import com.google.fhir.model.r5.NutritionIntake
import com.google.fhir.model.r5.surrogates.NutritionIntakeConsumedItemSurrogate
import com.google.fhir.model.r5.surrogates.NutritionIntakeIngredientLabelSurrogate
import com.google.fhir.model.r5.surrogates.NutritionIntakeOccurrenceSurrogate
import com.google.fhir.model.r5.surrogates.NutritionIntakePerformerSurrogate
import com.google.fhir.model.r5.surrogates.NutritionIntakeReportedSurrogate
import com.google.fhir.model.r5.surrogates.NutritionIntakeSurrogate
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

public object NutritionIntakeConsumedItemSerializer : KSerializer<NutritionIntake.ConsumedItem> {
  internal val surrogateSerializer: KSerializer<NutritionIntakeConsumedItemSurrogate> by lazy {
    NutritionIntakeConsumedItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ConsumedItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.ConsumedItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.ConsumedItem) {
    surrogateSerializer.serialize(encoder, NutritionIntakeConsumedItemSurrogate.fromModel(value))
  }
}

public object NutritionIntakeIngredientLabelSerializer :
  KSerializer<NutritionIntake.IngredientLabel> {
  internal val surrogateSerializer: KSerializer<NutritionIntakeIngredientLabelSurrogate> by lazy {
    NutritionIntakeIngredientLabelSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("IngredientLabel", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.IngredientLabel =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.IngredientLabel) {
    surrogateSerializer.serialize(encoder, NutritionIntakeIngredientLabelSurrogate.fromModel(value))
  }
}

public object NutritionIntakePerformerSerializer : KSerializer<NutritionIntake.Performer> {
  internal val surrogateSerializer: KSerializer<NutritionIntakePerformerSurrogate> by lazy {
    NutritionIntakePerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Performer) {
    surrogateSerializer.serialize(encoder, NutritionIntakePerformerSurrogate.fromModel(value))
  }
}

public object NutritionIntakeOccurrenceSerializer : KSerializer<NutritionIntake.Occurrence> {
  internal val surrogateSerializer: KSerializer<NutritionIntakeOccurrenceSurrogate> by lazy {
    NutritionIntakeOccurrenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Occurrence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.Occurrence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Occurrence) {
    surrogateSerializer.serialize(encoder, NutritionIntakeOccurrenceSurrogate.fromModel(value))
  }
}

public object NutritionIntakeReportedSerializer : KSerializer<NutritionIntake.Reported> {
  internal val surrogateSerializer: KSerializer<NutritionIntakeReportedSurrogate> by lazy {
    NutritionIntakeReportedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Reported", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake.Reported =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionIntake.Reported) {
    surrogateSerializer.serialize(encoder, NutritionIntakeReportedSurrogate.fromModel(value))
  }
}

public object NutritionIntakeSerializer : KSerializer<NutritionIntake> {
  internal val surrogateSerializer: KSerializer<NutritionIntakeSurrogate> by lazy {
    NutritionIntakeSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("occurrence", "reported")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NutritionIntake", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionIntake {
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

  override fun serialize(encoder: Encoder, `value`: NutritionIntake) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = NutritionIntakeSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
