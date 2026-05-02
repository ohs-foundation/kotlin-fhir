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

import com.google.fhir.model.r4.GraphDefinition
import com.google.fhir.model.r4.surrogates.GraphDefinitionLinkSurrogate
import com.google.fhir.model.r4.surrogates.GraphDefinitionLinkTargetCompartmentSurrogate
import com.google.fhir.model.r4.surrogates.GraphDefinitionLinkTargetSurrogate
import com.google.fhir.model.r4.surrogates.GraphDefinitionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object GraphDefinitionLinkSerializer : KSerializer<GraphDefinition.Link> {
  internal val surrogateSerializer: KSerializer<GraphDefinitionLinkSurrogate> by lazy {
    GraphDefinitionLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link) {
    surrogateSerializer.serialize(encoder, GraphDefinitionLinkSurrogate.fromModel(value))
  }
}

public object GraphDefinitionLinkTargetSerializer : KSerializer<GraphDefinition.Link.Target> {
  internal val surrogateSerializer: KSerializer<GraphDefinitionLinkTargetSurrogate> by lazy {
    GraphDefinitionLinkTargetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target) {
    surrogateSerializer.serialize(encoder, GraphDefinitionLinkTargetSurrogate.fromModel(value))
  }
}

public object GraphDefinitionLinkTargetCompartmentSerializer :
  KSerializer<GraphDefinition.Link.Target.Compartment> {
  internal val surrogateSerializer:
    KSerializer<GraphDefinitionLinkTargetCompartmentSurrogate> by lazy {
    GraphDefinitionLinkTargetCompartmentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Compartment", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): GraphDefinition.Link.Target.Compartment =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: GraphDefinition.Link.Target.Compartment) {
    surrogateSerializer.serialize(
      encoder,
      GraphDefinitionLinkTargetCompartmentSurrogate.fromModel(value),
    )
  }
}

public object GraphDefinitionSerializer : KSerializer<GraphDefinition> {
  internal val surrogateSerializer: KSerializer<GraphDefinitionSurrogate> by lazy {
    GraphDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("GraphDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): GraphDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: GraphDefinition) {
    surrogateSerializer.serialize(encoder, GraphDefinitionSurrogate.fromModel(value))
  }
}
