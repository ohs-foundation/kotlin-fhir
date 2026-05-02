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

import com.google.fhir.model.r5.DeviceMetric
import com.google.fhir.model.r5.surrogates.DeviceMetricCalibrationSurrogate
import com.google.fhir.model.r5.surrogates.DeviceMetricSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object DeviceMetricCalibrationSerializer : KSerializer<DeviceMetric.Calibration> {
  internal val surrogateSerializer: KSerializer<DeviceMetricCalibrationSurrogate> by lazy {
    DeviceMetricCalibrationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Calibration", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceMetric.Calibration =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceMetric.Calibration) {
    surrogateSerializer.serialize(encoder, DeviceMetricCalibrationSurrogate.fromModel(value))
  }
}

public object DeviceMetricSerializer : KSerializer<DeviceMetric> {
  internal val surrogateSerializer: KSerializer<DeviceMetricSurrogate> by lazy {
    DeviceMetricSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DeviceMetric", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DeviceMetric =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DeviceMetric) {
    surrogateSerializer.serialize(encoder, DeviceMetricSurrogate.fromModel(value))
  }
}
