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

import com.google.fhir.model.r4.MedicinalProductIngredient
import com.google.fhir.model.r4.surrogates.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductIngredientSpecifiedSubstanceSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductIngredientSubstanceSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductIngredientSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MedicinalProductIngredientSpecifiedSubstanceSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductIngredientSpecifiedSubstanceSurrogate> by lazy {
    MedicinalProductIngredientSpecifiedSubstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SpecifiedSubstance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.SpecifiedSubstance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.SpecifiedSubstance) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductIngredientSpecifiedSubstanceSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductIngredientSpecifiedSubstanceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate> by lazy {
    MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Strength", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductIngredientSpecifiedSubstanceStrengthSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSerializer :
  KSerializer<MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength> {
  internal val surrogateSerializer:
    KSerializer<
      MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate
    > by lazy {
    MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferenceStrength", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductIngredient.SpecifiedSubstance.Strength.ReferenceStrength,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthSurrogate.fromModel(
        value
      ),
    )
  }
}

public object MedicinalProductIngredientSubstanceSerializer :
  KSerializer<MedicinalProductIngredient.Substance> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductIngredientSubstanceSurrogate> by lazy {
    MedicinalProductIngredientSubstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Substance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient.Substance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient.Substance) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductIngredientSubstanceSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductIngredientSerializer : KSerializer<MedicinalProductIngredient> {
  internal val surrogateSerializer: KSerializer<MedicinalProductIngredientSurrogate> by lazy {
    MedicinalProductIngredientSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductIngredient", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductIngredient =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductIngredient) {
    surrogateSerializer.serialize(encoder, MedicinalProductIngredientSurrogate.fromModel(value))
  }
}
