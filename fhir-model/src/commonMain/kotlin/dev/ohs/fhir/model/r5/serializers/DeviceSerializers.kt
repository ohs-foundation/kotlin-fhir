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

import com.google.fhir.model.r5.Device
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.DeviceConformsToSurrogate
import com.google.fhir.model.r5.surrogates.DeviceNameSurrogate
import com.google.fhir.model.r5.surrogates.DevicePropertySurrogate
import com.google.fhir.model.r5.surrogates.DevicePropertyValueSurrogate
import com.google.fhir.model.r5.surrogates.DeviceSurrogate
import com.google.fhir.model.r5.surrogates.DeviceUdiCarrierSurrogate
import com.google.fhir.model.r5.surrogates.DeviceVersionSurrogate
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

public object DeviceUdiCarrierSerializer : KSerializer<Device.UdiCarrier> {
  internal val surrogateSerializer: KSerializer<DeviceUdiCarrierSurrogate> by lazy {
    DeviceUdiCarrierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("UdiCarrier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.UdiCarrier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.UdiCarrier) {
    surrogateSerializer.serialize(encoder, DeviceUdiCarrierSurrogate.fromModel(value))
  }
}

public object DeviceNameSerializer : KSerializer<Device.Name> {
  internal val surrogateSerializer: KSerializer<DeviceNameSurrogate> by lazy {
    DeviceNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Name", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Name =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.Name) {
    surrogateSerializer.serialize(encoder, DeviceNameSurrogate.fromModel(value))
  }
}

public object DeviceVersionSerializer : KSerializer<Device.Version> {
  internal val surrogateSerializer: KSerializer<DeviceVersionSurrogate> by lazy {
    DeviceVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.Version) {
    surrogateSerializer.serialize(encoder, DeviceVersionSurrogate.fromModel(value))
  }
}

public object DeviceConformsToSerializer : KSerializer<Device.ConformsTo> {
  internal val surrogateSerializer: KSerializer<DeviceConformsToSurrogate> by lazy {
    DeviceConformsToSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ConformsTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.ConformsTo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.ConformsTo) {
    surrogateSerializer.serialize(encoder, DeviceConformsToSurrogate.fromModel(value))
  }
}

public object DevicePropertySerializer : KSerializer<Device.Property> {
  internal val surrogateSerializer: KSerializer<DevicePropertySurrogate> by lazy {
    DevicePropertySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Property {
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

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = DevicePropertySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object DevicePropertyValueSerializer : KSerializer<Device.Property.Value> {
  internal val surrogateSerializer: KSerializer<DevicePropertyValueSurrogate> by lazy {
    DevicePropertyValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Property.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.Property.Value) {
    surrogateSerializer.serialize(encoder, DevicePropertyValueSurrogate.fromModel(value))
  }
}

public object DeviceSerializer : KSerializer<Device> {
  internal val surrogateSerializer: KSerializer<DeviceSurrogate> by lazy {
    DeviceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Device", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device) {
    surrogateSerializer.serialize(encoder, DeviceSurrogate.fromModel(value))
  }
}
