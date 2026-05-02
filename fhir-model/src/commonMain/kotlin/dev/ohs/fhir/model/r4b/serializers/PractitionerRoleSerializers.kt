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

import com.google.fhir.model.r4b.PractitionerRole
import com.google.fhir.model.r4b.surrogates.PractitionerRoleAvailableTimeSurrogate
import com.google.fhir.model.r4b.surrogates.PractitionerRoleNotAvailableSurrogate
import com.google.fhir.model.r4b.surrogates.PractitionerRoleSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object PractitionerRoleAvailableTimeSerializer :
  KSerializer<PractitionerRole.AvailableTime> {
  internal val surrogateSerializer: KSerializer<PractitionerRoleAvailableTimeSurrogate> by lazy {
    PractitionerRoleAvailableTimeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AvailableTime", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PractitionerRole.AvailableTime =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.AvailableTime) {
    surrogateSerializer.serialize(encoder, PractitionerRoleAvailableTimeSurrogate.fromModel(value))
  }
}

public object PractitionerRoleNotAvailableSerializer : KSerializer<PractitionerRole.NotAvailable> {
  internal val surrogateSerializer: KSerializer<PractitionerRoleNotAvailableSurrogate> by lazy {
    PractitionerRoleNotAvailableSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NotAvailable", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PractitionerRole.NotAvailable =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PractitionerRole.NotAvailable) {
    surrogateSerializer.serialize(encoder, PractitionerRoleNotAvailableSurrogate.fromModel(value))
  }
}

public object PractitionerRoleSerializer : KSerializer<PractitionerRole> {
  internal val surrogateSerializer: KSerializer<PractitionerRoleSurrogate> by lazy {
    PractitionerRoleSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PractitionerRole", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PractitionerRole =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PractitionerRole) {
    surrogateSerializer.serialize(encoder, PractitionerRoleSurrogate.fromModel(value))
  }
}
