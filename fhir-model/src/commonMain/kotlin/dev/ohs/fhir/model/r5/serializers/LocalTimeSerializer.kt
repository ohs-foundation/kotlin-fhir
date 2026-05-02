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

package com.google.fhir.model.r4.serializers

import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * A Serializer for `LocalTime` that always include seconds, even if they are zero. Fractional parts
 * of the second are included if non-zero.
 */
public object LocalTimeSerializer : KSerializer<LocalTime> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FormattedLocalTime", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, `value`: LocalTime) {
    encoder.encodeString(LocalTime.Formats.ISO.format(value))
  }

  override fun deserialize(decoder: Decoder): LocalTime = LocalTime.parse(decoder.decodeString())
}
