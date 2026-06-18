/*
 * Copyright 2026 Open Health Stack Foundation
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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.FhirDecimal
import kotlin.OptIn
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonUnquotedLiteral
import kotlinx.serialization.json.jsonPrimitive

/**
 * Serializer for `FhirDecimal` — FHIR's `decimal` primitive. Emits the value's exact lexical wire
 * form (precision and trailing zeros preserved) as an unquoted JSON number, and captures the raw
 * token verbatim on the way back in.
 */
internal object FhirDecimalSerializer : KSerializer<FhirDecimal> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FhirDecimal", PrimitiveKind.STRING)

  @OptIn(ExperimentalSerializationApi::class)
  override fun serialize(encoder: Encoder, `value`: FhirDecimal) {
    if (encoder is JsonEncoder) {
      encoder.encodeSerializableValue(JsonPrimitive.serializer(), JsonUnquotedLiteral(value.wire))
    } else {
      encoder.encodeString(value.wire)
    }
  }

  override fun deserialize(decoder: Decoder): FhirDecimal =
    if (decoder is JsonDecoder) {
      FhirDecimal.fromString(decoder.decodeJsonElement().jsonPrimitive.content)
    } else {
      FhirDecimal.fromString(decoder.decodeString())
    }
}
