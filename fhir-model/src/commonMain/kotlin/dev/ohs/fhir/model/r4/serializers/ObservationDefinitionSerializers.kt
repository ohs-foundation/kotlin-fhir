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

import com.google.fhir.model.r4.ObservationDefinition
import com.google.fhir.model.r4.surrogates.ObservationDefinitionQualifiedIntervalSurrogate
import com.google.fhir.model.r4.surrogates.ObservationDefinitionQuantitativeDetailsSurrogate
import com.google.fhir.model.r4.surrogates.ObservationDefinitionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ObservationDefinitionQuantitativeDetailsSerializer :
  KSerializer<ObservationDefinition.QuantitativeDetails> {
  internal val surrogateSerializer:
    KSerializer<ObservationDefinitionQuantitativeDetailsSurrogate> by lazy {
    ObservationDefinitionQuantitativeDetailsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("QuantitativeDetails", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QuantitativeDetails =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QuantitativeDetails) {
    surrogateSerializer.serialize(
      encoder,
      ObservationDefinitionQuantitativeDetailsSurrogate.fromModel(value),
    )
  }
}

public object ObservationDefinitionQualifiedIntervalSerializer :
  KSerializer<ObservationDefinition.QualifiedInterval> {
  internal val surrogateSerializer:
    KSerializer<ObservationDefinitionQualifiedIntervalSurrogate> by lazy {
    ObservationDefinitionQualifiedIntervalSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("QualifiedInterval", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition.QualifiedInterval =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition.QualifiedInterval) {
    surrogateSerializer.serialize(
      encoder,
      ObservationDefinitionQualifiedIntervalSurrogate.fromModel(value),
    )
  }
}

public object ObservationDefinitionSerializer : KSerializer<ObservationDefinition> {
  internal val surrogateSerializer: KSerializer<ObservationDefinitionSurrogate> by lazy {
    ObservationDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ObservationDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ObservationDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ObservationDefinition) {
    surrogateSerializer.serialize(encoder, ObservationDefinitionSurrogate.fromModel(value))
  }
}
