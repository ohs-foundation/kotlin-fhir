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

package dev.ohs.fhir.model.r5.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
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
 * Serializer for bignum `BigDecimal` — the in-memory type for FHIR's `decimal` primitive. On the
 * JSON wire the value is emitted as an unquoted number that preserves the original precision
 * (trailing zeros included); on other encoders it falls back to a plain decimal string.
 */
internal object BigDecimalSerializer : KSerializer<BigDecimal> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FhirBigDecimal", PrimitiveKind.STRING)

  @OptIn(ExperimentalSerializationApi::class)
  override fun serialize(encoder: Encoder, `value`: BigDecimal) {
    if (encoder is JsonEncoder) {
      encoder.encodeSerializableValue(
        JsonPrimitive.serializer(),
        JsonUnquotedLiteral(value.toPlainString()),
      )
    } else {
      encoder.encodeString(value.toPlainString())
    }
  }

  override fun deserialize(decoder: Decoder): BigDecimal =
    if (decoder is JsonDecoder) {
      BigDecimal.parseString(decoder.decodeJsonElement().jsonPrimitive.content)
    } else {
      BigDecimal.parseString(decoder.decodeString())
    }
}
