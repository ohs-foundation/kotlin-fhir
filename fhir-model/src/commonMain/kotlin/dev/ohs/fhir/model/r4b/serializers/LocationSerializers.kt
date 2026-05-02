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

import com.google.fhir.model.r4b.Location
import com.google.fhir.model.r4b.surrogates.LocationHoursOfOperationSurrogate
import com.google.fhir.model.r4b.surrogates.LocationPositionSurrogate
import com.google.fhir.model.r4b.surrogates.LocationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object LocationPositionSerializer : KSerializer<Location.Position> {
  internal val surrogateSerializer: KSerializer<LocationPositionSurrogate> by lazy {
    LocationPositionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Position", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Location.Position =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Location.Position) {
    surrogateSerializer.serialize(encoder, LocationPositionSurrogate.fromModel(value))
  }
}

public object LocationHoursOfOperationSerializer : KSerializer<Location.HoursOfOperation> {
  internal val surrogateSerializer: KSerializer<LocationHoursOfOperationSurrogate> by lazy {
    LocationHoursOfOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("HoursOfOperation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Location.HoursOfOperation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Location.HoursOfOperation) {
    surrogateSerializer.serialize(encoder, LocationHoursOfOperationSurrogate.fromModel(value))
  }
}

public object LocationSerializer : KSerializer<Location> {
  internal val surrogateSerializer: KSerializer<LocationSurrogate> by lazy {
    LocationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Location", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Location =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Location) {
    surrogateSerializer.serialize(encoder, LocationSurrogate.fromModel(value))
  }
}
