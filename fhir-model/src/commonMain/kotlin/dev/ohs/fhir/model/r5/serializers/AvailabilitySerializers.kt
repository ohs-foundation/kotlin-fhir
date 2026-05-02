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

import com.google.fhir.model.r5.Availability
import com.google.fhir.model.r5.surrogates.AvailabilityAvailableTimeSurrogate
import com.google.fhir.model.r5.surrogates.AvailabilityNotAvailableTimeSurrogate
import com.google.fhir.model.r5.surrogates.AvailabilitySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object AvailabilityAvailableTimeSerializer : KSerializer<Availability.AvailableTime> {
  internal val surrogateSerializer: KSerializer<AvailabilityAvailableTimeSurrogate> by lazy {
    AvailabilityAvailableTimeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AvailableTime", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Availability.AvailableTime =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Availability.AvailableTime) {
    surrogateSerializer.serialize(encoder, AvailabilityAvailableTimeSurrogate.fromModel(value))
  }
}

public object AvailabilityNotAvailableTimeSerializer : KSerializer<Availability.NotAvailableTime> {
  internal val surrogateSerializer: KSerializer<AvailabilityNotAvailableTimeSurrogate> by lazy {
    AvailabilityNotAvailableTimeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NotAvailableTime", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Availability.NotAvailableTime =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Availability.NotAvailableTime) {
    surrogateSerializer.serialize(encoder, AvailabilityNotAvailableTimeSurrogate.fromModel(value))
  }
}

public object AvailabilitySerializer : KSerializer<Availability> {
  internal val surrogateSerializer: KSerializer<AvailabilitySurrogate> by lazy {
    AvailabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Availability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Availability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Availability) {
    surrogateSerializer.serialize(encoder, AvailabilitySurrogate.fromModel(value))
  }
}
