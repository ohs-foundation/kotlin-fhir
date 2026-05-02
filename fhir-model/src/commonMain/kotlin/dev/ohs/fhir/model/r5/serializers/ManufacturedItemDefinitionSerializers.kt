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
import com.google.fhir.model.r5.ManufacturedItemDefinition
import com.google.fhir.model.r5.surrogates.ManufacturedItemDefinitionComponentConstituentSurrogate
import com.google.fhir.model.r5.surrogates.ManufacturedItemDefinitionComponentSurrogate
import com.google.fhir.model.r5.surrogates.ManufacturedItemDefinitionPropertySurrogate
import com.google.fhir.model.r5.surrogates.ManufacturedItemDefinitionPropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.ManufacturedItemDefinitionSurrogate
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

public object ManufacturedItemDefinitionPropertySerializer :
  KSerializer<ManufacturedItemDefinition.Property> {
  internal val surrogateSerializer:
    KSerializer<ManufacturedItemDefinitionPropertySurrogate> by lazy {
    ManufacturedItemDefinitionPropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property {
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

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ManufacturedItemDefinitionPropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ManufacturedItemDefinitionComponentSerializer :
  KSerializer<ManufacturedItemDefinition.Component> {
  internal val surrogateSerializer:
    KSerializer<ManufacturedItemDefinitionComponentSurrogate> by lazy {
    ManufacturedItemDefinitionComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Component) {
    surrogateSerializer.serialize(
      encoder,
      ManufacturedItemDefinitionComponentSurrogate.fromModel(value),
    )
  }
}

public object ManufacturedItemDefinitionComponentConstituentSerializer :
  KSerializer<ManufacturedItemDefinition.Component.Constituent> {
  internal val surrogateSerializer:
    KSerializer<ManufacturedItemDefinitionComponentConstituentSurrogate> by lazy {
    ManufacturedItemDefinitionComponentConstituentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Constituent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Component.Constituent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ManufacturedItemDefinition.Component.Constituent,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ManufacturedItemDefinitionComponentConstituentSurrogate.fromModel(value),
    )
  }
}

public object ManufacturedItemDefinitionPropertyValueSerializer :
  KSerializer<ManufacturedItemDefinition.Property.Value> {
  internal val surrogateSerializer:
    KSerializer<ManufacturedItemDefinitionPropertyValueSurrogate> by lazy {
    ManufacturedItemDefinitionPropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition.Property.Value) {
    surrogateSerializer.serialize(
      encoder,
      ManufacturedItemDefinitionPropertyValueSurrogate.fromModel(value),
    )
  }
}

public object ManufacturedItemDefinitionSerializer : KSerializer<ManufacturedItemDefinition> {
  internal val surrogateSerializer: KSerializer<ManufacturedItemDefinitionSurrogate> by lazy {
    ManufacturedItemDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ManufacturedItemDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ManufacturedItemDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ManufacturedItemDefinition) {
    surrogateSerializer.serialize(encoder, ManufacturedItemDefinitionSurrogate.fromModel(value))
  }
}
