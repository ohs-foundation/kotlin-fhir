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

import com.google.fhir.model.r4b.Device
import com.google.fhir.model.r4b.surrogates.DeviceDeviceNameSurrogate
import com.google.fhir.model.r4b.surrogates.DevicePropertySurrogate
import com.google.fhir.model.r4b.surrogates.DeviceSpecializationSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceUdiCarrierSurrogate
import com.google.fhir.model.r4b.surrogates.DeviceVersionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

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

public object DeviceDeviceNameSerializer : KSerializer<Device.DeviceName> {
  internal val surrogateSerializer: KSerializer<DeviceDeviceNameSurrogate> by lazy {
    DeviceDeviceNameSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceName", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.DeviceName =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.DeviceName) {
    surrogateSerializer.serialize(encoder, DeviceDeviceNameSurrogate.fromModel(value))
  }
}

public object DeviceSpecializationSerializer : KSerializer<Device.Specialization> {
  internal val surrogateSerializer: KSerializer<DeviceSpecializationSurrogate> by lazy {
    DeviceSpecializationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Specialization", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Specialization =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.Specialization) {
    surrogateSerializer.serialize(encoder, DeviceSpecializationSurrogate.fromModel(value))
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

public object DevicePropertySerializer : KSerializer<Device.Property> {
  internal val surrogateSerializer: KSerializer<DevicePropertySurrogate> by lazy {
    DevicePropertySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Property", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Device.Property =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Device.Property) {
    surrogateSerializer.serialize(encoder, DevicePropertySurrogate.fromModel(value))
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
