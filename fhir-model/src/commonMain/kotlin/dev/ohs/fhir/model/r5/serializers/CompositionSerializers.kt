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

import com.google.fhir.model.r5.Composition
import com.google.fhir.model.r5.surrogates.CompositionAttesterSurrogate
import com.google.fhir.model.r5.surrogates.CompositionEventSurrogate
import com.google.fhir.model.r5.surrogates.CompositionSectionSurrogate
import com.google.fhir.model.r5.surrogates.CompositionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object CompositionAttesterSerializer : KSerializer<Composition.Attester> {
  internal val surrogateSerializer: KSerializer<CompositionAttesterSurrogate> by lazy {
    CompositionAttesterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Attester", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Attester =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Attester) {
    surrogateSerializer.serialize(encoder, CompositionAttesterSurrogate.fromModel(value))
  }
}

public object CompositionEventSerializer : KSerializer<Composition.Event> {
  internal val surrogateSerializer: KSerializer<CompositionEventSurrogate> by lazy {
    CompositionEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Event", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Event =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Event) {
    surrogateSerializer.serialize(encoder, CompositionEventSurrogate.fromModel(value))
  }
}

public object CompositionSectionSerializer : KSerializer<Composition.Section> {
  internal val surrogateSerializer: KSerializer<CompositionSectionSurrogate> by lazy {
    CompositionSectionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Section", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition.Section =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition.Section) {
    surrogateSerializer.serialize(encoder, CompositionSectionSurrogate.fromModel(value))
  }
}

public object CompositionSerializer : KSerializer<Composition> {
  internal val surrogateSerializer: KSerializer<CompositionSurrogate> by lazy {
    CompositionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Composition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Composition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Composition) {
    surrogateSerializer.serialize(encoder, CompositionSurrogate.fromModel(value))
  }
}
