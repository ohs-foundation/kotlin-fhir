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

import com.google.fhir.model.r4.ChargeItemDefinition
import com.google.fhir.model.r4.surrogates.ChargeItemDefinitionApplicabilitySurrogate
import com.google.fhir.model.r4.surrogates.ChargeItemDefinitionPropertyGroupPriceComponentSurrogate
import com.google.fhir.model.r4.surrogates.ChargeItemDefinitionPropertyGroupSurrogate
import com.google.fhir.model.r4.surrogates.ChargeItemDefinitionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ChargeItemDefinitionApplicabilitySerializer :
  KSerializer<ChargeItemDefinition.Applicability> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionApplicabilitySurrogate> by lazy {
    ChargeItemDefinitionApplicabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Applicability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.Applicability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.Applicability) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionApplicabilitySurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionPropertyGroupSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionPropertyGroupSurrogate> by lazy {
    ChargeItemDefinitionPropertyGroupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PropertyGroup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.PropertyGroup) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionPropertyGroupSurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionPropertyGroupPriceComponentSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup.PriceComponent> {
  internal val surrogateSerializer:
    KSerializer<ChargeItemDefinitionPropertyGroupPriceComponentSurrogate> by lazy {
    ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PriceComponent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup.PriceComponent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: ChargeItemDefinition.PropertyGroup.PriceComponent,
  ) {
    surrogateSerializer.serialize(
      encoder,
      ChargeItemDefinitionPropertyGroupPriceComponentSurrogate.fromModel(value),
    )
  }
}

public object ChargeItemDefinitionSerializer : KSerializer<ChargeItemDefinition> {
  internal val surrogateSerializer: KSerializer<ChargeItemDefinitionSurrogate> by lazy {
    ChargeItemDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ChargeItemDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition) {
    surrogateSerializer.serialize(encoder, ChargeItemDefinitionSurrogate.fromModel(value))
  }
}
