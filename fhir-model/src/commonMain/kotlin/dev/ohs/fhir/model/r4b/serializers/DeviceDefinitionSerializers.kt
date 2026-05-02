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

import com.google.fhir.model.r4b.DeviceDefinition
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionCapabilitySurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionDeviceNameSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionManufacturerSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionMaterialSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionPropertySurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionSpecializationSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceDefinitionUdiDeviceIdentifierSurrogate
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

public object DeviceDefinitionUdiDeviceIdentifierSerializer :
  KSerializer<DeviceDefinition.UdiDeviceIdentifier> {
  internal val surrogateSerializer:
    KSerializer<DeviceDefinitionUdiDeviceIdentifierSurrogate> by lazy {
    DeviceDefinitionUdiDeviceIdentifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("UdiDeviceIdentifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.UdiDeviceIdentifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.UdiDeviceIdentifier) {
    surrogateSerializer.serialize(
      encoder,
      DeviceDefinitionUdiDeviceIdentifierSurrogate.fromModel(value),
    )
  }
}

public object DeviceDefinitionDeviceNameSerializer : KSerializer<DeviceDefinition.DeviceName> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionDeviceNameSurrogate> by lazy {
    DeviceDefinitionDeviceNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceName", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.DeviceName =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.DeviceName) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionDeviceNameSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionSpecializationSerializer :
  KSerializer<DeviceDefinition.Specialization> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionSpecializationSurrogate> by lazy {
    DeviceDefinitionSpecializationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Specialization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Specialization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Specialization) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionSpecializationSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionCapabilitySerializer : KSerializer<DeviceDefinition.Capability> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionCapabilitySurrogate> by lazy {
    DeviceDefinitionCapabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Capability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Capability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Capability) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionCapabilitySurrogate.fromModel(value))
  }
}

public object DeviceDefinitionPropertySerializer : KSerializer<DeviceDefinition.Property> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionPropertySurrogate> by lazy {
    DeviceDefinitionPropertySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Property =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Property) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionPropertySurrogate.fromModel(value))
  }
}

public object DeviceDefinitionMaterialSerializer : KSerializer<DeviceDefinition.Material> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionMaterialSurrogate> by lazy {
    DeviceDefinitionMaterialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Material", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Material =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Material) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionMaterialSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionManufacturerSerializer : KSerializer<DeviceDefinition.Manufacturer> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionManufacturerSurrogate> by lazy {
    DeviceDefinitionManufacturerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Manufacturer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition.Manufacturer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition.Manufacturer) {
    surrogateSerializer.serialize(encoder, DeviceDefinitionManufacturerSurrogate.fromModel(value))
  }
}

public object DeviceDefinitionSerializer : KSerializer<DeviceDefinition> {
  internal val surrogateSerializer: KSerializer<DeviceDefinitionSurrogate> by lazy {
    DeviceDefinitionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("manufacturer")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceDefinition {
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

  override fun serialize(encoder: Encoder, `value`: DeviceDefinition) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DeviceDefinitionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
