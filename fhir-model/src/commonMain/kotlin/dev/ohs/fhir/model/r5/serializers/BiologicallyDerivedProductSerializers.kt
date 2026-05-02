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

import com.google.fhir.model.r5.BiologicallyDerivedProduct
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.BiologicallyDerivedProductCollectionCollectedSurrogate
import com.google.fhir.model.r5.surrogates.BiologicallyDerivedProductCollectionSurrogate
import com.google.fhir.model.r5.surrogates.BiologicallyDerivedProductPropertySurrogate
import com.google.fhir.model.r5.surrogates.BiologicallyDerivedProductPropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.BiologicallyDerivedProductSurrogate
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

public object BiologicallyDerivedProductPropertySerializer :
  KSerializer<BiologicallyDerivedProduct.Property> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductPropertySurrogate> by lazy {
    BiologicallyDerivedProductPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Property {
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

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = BiologicallyDerivedProductPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
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

public object BiologicallyDerivedProductPropertyValueSerializer :
  KSerializer<BiologicallyDerivedProduct.Property.Value> {
  internal val surrogateSerializer:
    KSerializer<BiologicallyDerivedProductPropertyValueSurrogate> by lazy {
    BiologicallyDerivedProductPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BiologicallyDerivedProduct.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BiologicallyDerivedProduct.Property.Value) {
    surrogateSerializer.serialize(
      encoder,
      BiologicallyDerivedProductPropertyValueSurrogate.fromModel(value),
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
