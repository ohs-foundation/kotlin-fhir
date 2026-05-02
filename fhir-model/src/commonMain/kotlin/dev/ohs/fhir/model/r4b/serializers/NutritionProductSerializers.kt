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
import com.google.fhir.model.r4b.NutritionProduct
import com.google.fhir.model.r4b.surrogates.NutritionProductIngredientSurrogate
import com.google.fhir.model.r4b.surrogates.NutritionProductInstanceSurrogate
import com.google.fhir.model.r4b.surrogates.NutritionProductNutrientSurrogate
import com.google.fhir.model.r4b.surrogates.NutritionProductProductCharacteristicSurrogate
import com.google.fhir.model.r4b.surrogates.NutritionProductProductCharacteristicValueSurrogate
import com.google.fhir.model.r4b.surrogates.NutritionProductSurrogate
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

public object NutritionProductNutrientSerializer : KSerializer<NutritionProduct.Nutrient> {
  internal val surrogateSerializer: KSerializer<NutritionProductNutrientSurrogate> by lazy {
    NutritionProductNutrientSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Nutrient", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct.Nutrient =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Nutrient) {
    surrogateSerializer.serialize(encoder, NutritionProductNutrientSurrogate.fromModel(value))
  }
}

public object NutritionProductIngredientSerializer : KSerializer<NutritionProduct.Ingredient> {
  internal val surrogateSerializer: KSerializer<NutritionProductIngredientSurrogate> by lazy {
    NutritionProductIngredientSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Ingredient", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct.Ingredient =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Ingredient) {
    surrogateSerializer.serialize(encoder, NutritionProductIngredientSurrogate.fromModel(value))
  }
}

public object NutritionProductProductCharacteristicSerializer :
  KSerializer<NutritionProduct.ProductCharacteristic> {
  internal val surrogateSerializer:
    KSerializer<NutritionProductProductCharacteristicSurrogate> by lazy {
    NutritionProductProductCharacteristicSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ProductCharacteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct.ProductCharacteristic {
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

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.ProductCharacteristic) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = NutritionProductProductCharacteristicSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object NutritionProductInstanceSerializer : KSerializer<NutritionProduct.Instance> {
  internal val surrogateSerializer: KSerializer<NutritionProductInstanceSurrogate> by lazy {
    NutritionProductInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.Instance) {
    surrogateSerializer.serialize(encoder, NutritionProductInstanceSurrogate.fromModel(value))
  }
}

public object NutritionProductProductCharacteristicValueSerializer :
  KSerializer<NutritionProduct.ProductCharacteristic.Value> {
  internal val surrogateSerializer:
    KSerializer<NutritionProductProductCharacteristicValueSurrogate> by lazy {
    NutritionProductProductCharacteristicValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct.ProductCharacteristic.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionProduct.ProductCharacteristic.Value) {
    surrogateSerializer.serialize(
      encoder,
      NutritionProductProductCharacteristicValueSurrogate.fromModel(value),
    )
  }
}

public object NutritionProductSerializer : KSerializer<NutritionProduct> {
  internal val surrogateSerializer: KSerializer<NutritionProductSurrogate> by lazy {
    NutritionProductSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NutritionProduct", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NutritionProduct =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NutritionProduct) {
    surrogateSerializer.serialize(encoder, NutritionProductSurrogate.fromModel(value))
  }
}
