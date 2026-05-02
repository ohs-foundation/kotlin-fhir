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
import com.google.fhir.model.r4b.PackagedProductDefinition
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionLegalStatusOfSupplySurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackageContainedItemSurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackagePropertySurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackagePropertyValueSurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackageShelfLifeStoragePeriodSurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackageShelfLifeStorageSurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionPackageSurrogate
import com.google.fhir.model.r4b.surrogates.PackagedProductDefinitionSurrogate
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

public object PackagedProductDefinitionLegalStatusOfSupplySerializer :
  KSerializer<PackagedProductDefinition.LegalStatusOfSupply> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionLegalStatusOfSupplySurrogate> by lazy {
    PackagedProductDefinitionLegalStatusOfSupplySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("LegalStatusOfSupply", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.LegalStatusOfSupply =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.LegalStatusOfSupply) {
    surrogateSerializer.serialize(
      encoder,
      PackagedProductDefinitionLegalStatusOfSupplySurrogate.fromModel(value),
    )
  }
}

public object PackagedProductDefinitionPackageSerializer :
  KSerializer<PackagedProductDefinition.Package> {
  internal val surrogateSerializer: KSerializer<PackagedProductDefinitionPackageSurrogate> by lazy {
    PackagedProductDefinitionPackageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Package", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package) {
    surrogateSerializer.serialize(
      encoder,
      PackagedProductDefinitionPackageSurrogate.fromModel(value),
    )
  }
}

public object PackagedProductDefinitionPackageShelfLifeStorageSerializer :
  KSerializer<PackagedProductDefinition.Package.ShelfLifeStorage> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionPackageShelfLifeStorageSurrogate> by lazy {
    PackagedProductDefinitionPackageShelfLifeStorageSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("period")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ShelfLifeStorage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ShelfLifeStorage {
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

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PackagedProductDefinitionPackageShelfLifeStorageSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object PackagedProductDefinitionPackagePropertySerializer :
  KSerializer<PackagedProductDefinition.Package.Property> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionPackagePropertySurrogate> by lazy {
    PackagedProductDefinitionPackagePropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.Property {
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

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition.Package.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PackagedProductDefinitionPackagePropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object PackagedProductDefinitionPackageContainedItemSerializer :
  KSerializer<PackagedProductDefinition.Package.ContainedItem> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionPackageContainedItemSurrogate> by lazy {
    PackagedProductDefinitionPackageContainedItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContainedItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.ContainedItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ContainedItem,
  ) {
    surrogateSerializer.serialize(
      encoder,
      PackagedProductDefinitionPackageContainedItemSurrogate.fromModel(value),
    )
  }
}

public object PackagedProductDefinitionPackageShelfLifeStoragePeriodSerializer :
  KSerializer<PackagedProductDefinition.Package.ShelfLifeStorage.Period> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionPackageShelfLifeStoragePeriodSurrogate> by lazy {
    PackagedProductDefinitionPackageShelfLifeStoragePeriodSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Period", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): PackagedProductDefinition.Package.ShelfLifeStorage.Period =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.ShelfLifeStorage.Period,
  ) {
    surrogateSerializer.serialize(
      encoder,
      PackagedProductDefinitionPackageShelfLifeStoragePeriodSurrogate.fromModel(value),
    )
  }
}

public object PackagedProductDefinitionPackagePropertyValueSerializer :
  KSerializer<PackagedProductDefinition.Package.Property.Value> {
  internal val surrogateSerializer:
    KSerializer<PackagedProductDefinitionPackagePropertyValueSurrogate> by lazy {
    PackagedProductDefinitionPackagePropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition.Package.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: PackagedProductDefinition.Package.Property.Value,
  ) {
    surrogateSerializer.serialize(
      encoder,
      PackagedProductDefinitionPackagePropertyValueSurrogate.fromModel(value),
    )
  }
}

public object PackagedProductDefinitionSerializer : KSerializer<PackagedProductDefinition> {
  internal val surrogateSerializer: KSerializer<PackagedProductDefinitionSurrogate> by lazy {
    PackagedProductDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PackagedProductDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PackagedProductDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PackagedProductDefinition) {
    surrogateSerializer.serialize(encoder, PackagedProductDefinitionSurrogate.fromModel(value))
  }
}
