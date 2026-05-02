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

import com.google.fhir.model.r5.SubstanceSourceMaterial
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialFractionDescriptionSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialOrganismAuthorSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialOrganismHybridSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialOrganismOrganismGeneralSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialOrganismSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialPartDescriptionSurrogate
import com.google.fhir.model.r5.surrogates.SubstanceSourceMaterialSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubstanceSourceMaterialFractionDescriptionSerializer :
  KSerializer<SubstanceSourceMaterial.FractionDescription> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSourceMaterialFractionDescriptionSurrogate> by lazy {
    SubstanceSourceMaterialFractionDescriptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("FractionDescription", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.FractionDescription =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.FractionDescription) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialFractionDescriptionSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialOrganismSerializer :
  KSerializer<SubstanceSourceMaterial.Organism> {
  internal val surrogateSerializer: KSerializer<SubstanceSourceMaterialOrganismSurrogate> by lazy {
    SubstanceSourceMaterialOrganismSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Organism", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialOrganismSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialOrganismAuthorSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Author> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSourceMaterialOrganismAuthorSurrogate> by lazy {
    SubstanceSourceMaterialOrganismAuthorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Author", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Author =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Author) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialOrganismAuthorSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialOrganismHybridSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.Hybrid> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSourceMaterialOrganismHybridSurrogate> by lazy {
    SubstanceSourceMaterialOrganismHybridSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Hybrid", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.Hybrid =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.Organism.Hybrid) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialOrganismHybridSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialOrganismOrganismGeneralSerializer :
  KSerializer<SubstanceSourceMaterial.Organism.OrganismGeneral> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSourceMaterialOrganismOrganismGeneralSurrogate> by lazy {
    SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("OrganismGeneral", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.Organism.OrganismGeneral =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstanceSourceMaterial.Organism.OrganismGeneral,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialOrganismOrganismGeneralSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialPartDescriptionSerializer :
  KSerializer<SubstanceSourceMaterial.PartDescription> {
  internal val surrogateSerializer:
    KSerializer<SubstanceSourceMaterialPartDescriptionSurrogate> by lazy {
    SubstanceSourceMaterialPartDescriptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PartDescription", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial.PartDescription =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial.PartDescription) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceSourceMaterialPartDescriptionSurrogate.fromModel(value),
    )
  }
}

public object SubstanceSourceMaterialSerializer : KSerializer<SubstanceSourceMaterial> {
  internal val surrogateSerializer: KSerializer<SubstanceSourceMaterialSurrogate> by lazy {
    SubstanceSourceMaterialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceSourceMaterial", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceSourceMaterial =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceSourceMaterial) {
    surrogateSerializer.serialize(encoder, SubstanceSourceMaterialSurrogate.fromModel(value))
  }
}
