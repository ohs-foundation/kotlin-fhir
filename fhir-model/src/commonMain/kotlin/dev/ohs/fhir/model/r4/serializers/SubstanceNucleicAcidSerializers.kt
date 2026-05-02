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

import com.google.fhir.model.r5.SubstanceNucleicAcid
import com.google.fhir.model.r5.surrogates.SubstanceNucleicAcidSubunitLinkageSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceNucleicAcidSubunitSugarSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceNucleicAcidSubunitSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceNucleicAcidSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubstanceNucleicAcidSubunitSerializer : KSerializer<SubstanceNucleicAcid.Subunit> {
  internal val surrogateSerializer: KSerializer<SubstanceNucleicAcidSubunitSurrogate> by lazy {
    SubstanceNucleicAcidSubunitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subunit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit) {
    surrogateSerializer.serialize(encoder, SubstanceNucleicAcidSubunitSurrogate.fromModel(value))
  }
}

public object SubstanceNucleicAcidSubunitLinkageSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Linkage> {
  internal val surrogateSerializer:
    KSerializer<SubstanceNucleicAcidSubunitLinkageSurrogate> by lazy {
    SubstanceNucleicAcidSubunitLinkageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Linkage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Linkage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Linkage) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceNucleicAcidSubunitLinkageSurrogate.fromModel(value),
    )
  }
}

public object SubstanceNucleicAcidSubunitSugarSerializer :
  KSerializer<SubstanceNucleicAcid.Subunit.Sugar> {
  internal val surrogateSerializer: KSerializer<SubstanceNucleicAcidSubunitSugarSurrogate> by lazy {
    SubstanceNucleicAcidSubunitSugarSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Sugar", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid.Subunit.Sugar =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid.Subunit.Sugar) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceNucleicAcidSubunitSugarSurrogate.fromModel(value),
    )
  }
}

public object SubstanceNucleicAcidSerializer : KSerializer<SubstanceNucleicAcid> {
  internal val surrogateSerializer: KSerializer<SubstanceNucleicAcidSurrogate> by lazy {
    SubstanceNucleicAcidSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceNucleicAcid", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceNucleicAcid =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceNucleicAcid) {
    surrogateSerializer.serialize(encoder, SubstanceNucleicAcidSurrogate.fromModel(value))
  }
}
