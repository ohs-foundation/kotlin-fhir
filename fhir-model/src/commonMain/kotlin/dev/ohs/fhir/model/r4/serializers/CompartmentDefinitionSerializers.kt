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

import com.google.fhir.model.r4b.CompartmentDefinition
import com.google.fhir.model.r4b.surrogates.CompartmentDefinitionResourceSurrogate
import com.google.fhir.model.r4b.surrogates.CompartmentDefinitionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object CompartmentDefinitionResourceSerializer :
  KSerializer<CompartmentDefinition.Resource> {
  internal val surrogateSerializer: KSerializer<CompartmentDefinitionResourceSurrogate> by lazy {
    CompartmentDefinitionResourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Resource", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CompartmentDefinition.Resource =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CompartmentDefinition.Resource) {
    surrogateSerializer.serialize(encoder, CompartmentDefinitionResourceSurrogate.fromModel(value))
  }
}

public object CompartmentDefinitionSerializer : KSerializer<CompartmentDefinition> {
  internal val surrogateSerializer: KSerializer<CompartmentDefinitionSurrogate> by lazy {
    CompartmentDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CompartmentDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CompartmentDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CompartmentDefinition) {
    surrogateSerializer.serialize(encoder, CompartmentDefinitionSurrogate.fromModel(value))
  }
}
