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

import com.google.fhir.model.r4b.OperationDefinition
import com.google.fhir.model.r4b.surrogates.OperationDefinitionOverloadSurrogate
import com.google.fhir.model.r4b.surrogates.OperationDefinitionParameterBindingSurrogate
import com.google.fhir.model.r4b.surrogates.OperationDefinitionParameterReferencedFromSurrogate
import com.google.fhir.model.r4b.surrogates.OperationDefinitionParameterSurrogate
import com.google.fhir.model.r4b.surrogates.OperationDefinitionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object OperationDefinitionParameterSerializer : KSerializer<OperationDefinition.Parameter> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionParameterSurrogate> by lazy {
    OperationDefinitionParameterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter) {
    surrogateSerializer.serialize(encoder, OperationDefinitionParameterSurrogate.fromModel(value))
  }
}

public object OperationDefinitionParameterBindingSerializer :
  KSerializer<OperationDefinition.Parameter.Binding> {
  internal val surrogateSerializer:
    KSerializer<OperationDefinitionParameterBindingSurrogate> by lazy {
    OperationDefinitionParameterBindingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Binding", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.Binding =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.Binding) {
    surrogateSerializer.serialize(
      encoder,
      OperationDefinitionParameterBindingSurrogate.fromModel(value),
    )
  }
}

public object OperationDefinitionParameterReferencedFromSerializer :
  KSerializer<OperationDefinition.Parameter.ReferencedFrom> {
  internal val surrogateSerializer:
    KSerializer<OperationDefinitionParameterReferencedFromSurrogate> by lazy {
    OperationDefinitionParameterReferencedFromSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferencedFrom", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Parameter.ReferencedFrom =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Parameter.ReferencedFrom) {
    surrogateSerializer.serialize(
      encoder,
      OperationDefinitionParameterReferencedFromSurrogate.fromModel(value),
    )
  }
}

public object OperationDefinitionOverloadSerializer : KSerializer<OperationDefinition.Overload> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionOverloadSurrogate> by lazy {
    OperationDefinitionOverloadSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Overload", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition.Overload =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition.Overload) {
    surrogateSerializer.serialize(encoder, OperationDefinitionOverloadSurrogate.fromModel(value))
  }
}

public object OperationDefinitionSerializer : KSerializer<OperationDefinition> {
  internal val surrogateSerializer: KSerializer<OperationDefinitionSurrogate> by lazy {
    OperationDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("OperationDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): OperationDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: OperationDefinition) {
    surrogateSerializer.serialize(encoder, OperationDefinitionSurrogate.fromModel(value))
  }
}
