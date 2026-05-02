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

package com.google.fhir.model.r4.serializers

import com.google.fhir.model.r4.AdverseEvent
import com.google.fhir.model.r4.surrogates.AdverseEventSurrogate
import com.google.fhir.model.r4.surrogates.AdverseEventSuspectEntityCausalitySurrogate
import com.google.fhir.model.r4.surrogates.AdverseEventSuspectEntitySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object AdverseEventSuspectEntitySerializer : KSerializer<AdverseEvent.SuspectEntity> {
  internal val surrogateSerializer: KSerializer<AdverseEventSuspectEntitySurrogate> by lazy {
    AdverseEventSuspectEntitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SuspectEntity", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity) {
    surrogateSerializer.serialize(encoder, AdverseEventSuspectEntitySurrogate.fromModel(value))
  }
}

public object AdverseEventSuspectEntityCausalitySerializer :
  KSerializer<AdverseEvent.SuspectEntity.Causality> {
  internal val surrogateSerializer:
    KSerializer<AdverseEventSuspectEntityCausalitySurrogate> by lazy {
    AdverseEventSuspectEntityCausalitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Causality", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent.SuspectEntity.Causality =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent.SuspectEntity.Causality) {
    surrogateSerializer.serialize(
      encoder,
      AdverseEventSuspectEntityCausalitySurrogate.fromModel(value),
    )
  }
}

public object AdverseEventSerializer : KSerializer<AdverseEvent> {
  internal val surrogateSerializer: KSerializer<AdverseEventSurrogate> by lazy {
    AdverseEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AdverseEvent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): AdverseEvent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: AdverseEvent) {
    surrogateSerializer.serialize(encoder, AdverseEventSurrogate.fromModel(value))
  }
}
