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

import com.google.fhir.model.r4.BiologicallyDerivedProduct
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductCollectionCollectedSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductCollectionSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductManipulationSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductManipulationTimeSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductProcessingSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductProcessingTimeSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductStorageSurrogate
import com.google.fhir.model.r4.surrogates.BiologicallyDerivedProductSurrogate
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

public object BiologicallyDerivedProductCollectionSerializer :
  KSerializer<BiologicallyDerivedProduct.Collection> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductCollectionSurrogate> by lazy {
    BiologicallyDerivedProductCollectionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("collected")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Collection", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection {
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

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Collection) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = BiologicallyDerivedProductCollectionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object BiologicallyDerivedProductProcessingSerializer :
  KSerializer<BiologicallyDerivedProduct.Processing> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductProcessingSurrogate> by lazy {
    BiologicallyDerivedProductProcessingSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("time")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Processing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Processing {
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

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Processing) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = BiologicallyDerivedProductProcessingSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object BiologicallyDerivedProductManipulationSerializer :
  KSerializer<BiologicallyDerivedProduct.Manipulation> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductManipulationSurrogate> by lazy {
    BiologicallyDerivedProductManipulationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("time")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Manipulation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Manipulation {
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

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Manipulation) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = BiologicallyDerivedProductManipulationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object BiologicallyDerivedProductStorageSerializer :
  KSerializer<BiologicallyDerivedProduct.Storage> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductStorageSurrogate> by lazy {
    BiologicallyDerivedProductStorageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Storage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Storage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Storage) {
    surrogateSerializer.serialize(
      encoder,
      BiologicallyDerivedProductStorageSurrogate.fromModel(value),
    )
  }
}

public object BiologicallyDerivedProductCollectionCollectedSerializer :
  KSerializer<BiologicallyDerivedProduct.Collection.Collected> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductCollectionCollectedSurrogate> by lazy {
    BiologicallyDerivedProductCollectionCollectedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Collected", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Collection.Collected =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: BiologicallyDerivedProduct.Collection.Collected,
  ) {
    surrogateSerializer.serialize(
      encoder,
      BiologicallyDerivedProductCollectionCollectedSurrogate.fromModel(value),
    )
  }
}

public object BiologicallyDerivedProductProcessingTimeSerializer :
  KSerializer<BiologicallyDerivedProduct.Processing.Time> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductProcessingTimeSurrogate> by lazy {
    BiologicallyDerivedProductProcessingTimeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Time", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Processing.Time =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Processing.Time) {
    surrogateSerializer.serialize(
      encoder,
      BiologicallyDerivedProductProcessingTimeSurrogate.fromModel(value),
    )
  }
}

public object BiologicallyDerivedProductManipulationTimeSerializer :
  KSerializer<BiologicallyDerivedProduct.Manipulation.Time> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductManipulationTimeSurrogate> by lazy {
    BiologicallyDerivedProductManipulationTimeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Time", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Manipulation.Time =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Manipulation.Time) {
    surrogateSerializer.serialize(
      encoder,
      BiologicallyDerivedProductManipulationTimeSurrogate.fromModel(value),
    )
  }
}

public object BiologicallyDerivedProductSerializer : KSerializer<BiologicallyDerivedProduct> {
  internal val surrogateSerializer: KSerializer<BiologicallyDerivedProductSurrogate> by lazy {
    BiologicallyDerivedProductSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BiologicallyDerivedProduct", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct) {
    surrogateSerializer.serialize(encoder, BiologicallyDerivedProductSurrogate.fromModel(value))
  }
}
