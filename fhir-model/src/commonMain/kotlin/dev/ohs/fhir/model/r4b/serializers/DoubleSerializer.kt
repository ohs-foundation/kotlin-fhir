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

package com.google.fhir.model.r4b.serializers

import kotlin.Double
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonUnquotedLiteral

public object DoubleSerializer : KSerializer<Double> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FormattedDouble", PrimitiveKind.DOUBLE)

  @ExperimentalSerializationApi
  override fun serialize(encoder: Encoder, `value`: Double) {
    encoder.encodeSerializableValue(
      JsonPrimitive.serializer(),
      JsonUnquotedLiteral(
        value.toString().let {
          if (it.contains('.')) {
            it
          } else {
            "$it.0"
          }
        }
      ),
    )
  }

  override fun deserialize(decoder: Decoder): Double = decoder.decodeDouble()
}
