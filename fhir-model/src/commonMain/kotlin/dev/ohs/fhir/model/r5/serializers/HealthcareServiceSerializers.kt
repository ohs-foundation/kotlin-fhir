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

import com.google.fhir.model.r5.HealthcareService
import com.google.fhir.model.r5.surrogates.HealthcareServiceEligibilitySurrogate
import com.google.fhir.model.r5.surrogates.HealthcareServiceSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object HealthcareServiceEligibilitySerializer : KSerializer<HealthcareService.Eligibility> {
  internal val surrogateSerializer: KSerializer<HealthcareServiceEligibilitySurrogate> by lazy {
    HealthcareServiceEligibilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Eligibility", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): HealthcareService.Eligibility =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: HealthcareService.Eligibility) {
    surrogateSerializer.serialize(encoder, HealthcareServiceEligibilitySurrogate.fromModel(value))
  }
}

public object HealthcareServiceSerializer : KSerializer<HealthcareService> {
  internal val surrogateSerializer: KSerializer<HealthcareServiceSurrogate> by lazy {
    HealthcareServiceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("HealthcareService", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): HealthcareService =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: HealthcareService) {
    surrogateSerializer.serialize(encoder, HealthcareServiceSurrogate.fromModel(value))
  }
}
