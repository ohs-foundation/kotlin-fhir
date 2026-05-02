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

import com.google.fhir.model.r4b.NamingSystem
import com.google.fhir.model.r4b.surrogates.NamingSystemSurrogate
import com.google.fhir.model.r4b.surrogates.NamingSystemUniqueIdSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object NamingSystemUniqueIdSerializer : KSerializer<NamingSystem.UniqueId> {
  internal val surrogateSerializer: KSerializer<NamingSystemUniqueIdSurrogate> by lazy {
    NamingSystemUniqueIdSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("UniqueId", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NamingSystem.UniqueId =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NamingSystem.UniqueId) {
    surrogateSerializer.serialize(encoder, NamingSystemUniqueIdSurrogate.fromModel(value))
  }
}

public object NamingSystemSerializer : KSerializer<NamingSystem> {
  internal val surrogateSerializer: KSerializer<NamingSystemSurrogate> by lazy {
    NamingSystemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NamingSystem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): NamingSystem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: NamingSystem) {
    surrogateSerializer.serialize(encoder, NamingSystemSurrogate.fromModel(value))
  }
}
