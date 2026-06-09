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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.FhirDateTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/** A Serializer for `FhirDateTime` using the FHIR dateTime string form. */
internal object FhirDateTimeSerializer : KSerializer<FhirDateTime> {
  override val descriptor: SerialDescriptor =
    PrimitiveSerialDescriptor("FhirDateTime", PrimitiveKind.STRING)

  override fun serialize(encoder: Encoder, `value`: FhirDateTime) {
    encoder.encodeString(value.toString())
  }

  override fun deserialize(decoder: Decoder): FhirDateTime =
    FhirDateTime.fromString(decoder.decodeString())!!
}
