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

import com.google.fhir.model.r5.SubstanceProtein
import com.google.fhir.model.r5.surrogates.SubstanceProteinSubunitSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceProteinSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubstanceProteinSubunitSerializer : KSerializer<SubstanceProtein.Subunit> {
  internal val surrogateSerializer: KSerializer<SubstanceProteinSubunitSurrogate> by lazy {
    SubstanceProteinSubunitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subunit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceProtein.Subunit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein.Subunit) {
    surrogateSerializer.serialize(encoder, SubstanceProteinSubunitSurrogate.fromModel(value))
  }
}

public object SubstanceProteinSerializer : KSerializer<SubstanceProtein> {
  internal val surrogateSerializer: KSerializer<SubstanceProteinSurrogate> by lazy {
    SubstanceProteinSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceProtein", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceProtein =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceProtein) {
    surrogateSerializer.serialize(encoder, SubstanceProteinSurrogate.fromModel(value))
  }
}
