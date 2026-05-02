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

import com.google.fhir.model.r4.MedicinalProductPharmaceutical
import com.google.fhir.model.r4.surrogates.MedicinalProductPharmaceuticalCharacteristicsSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPharmaceuticalRouteOfAdministrationSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPharmaceuticalSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MedicinalProductPharmaceuticalCharacteristicsSerializer :
  KSerializer<MedicinalProductPharmaceutical.Characteristics> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductPharmaceuticalCharacteristicsSurrogate> by lazy {
    MedicinalProductPharmaceuticalCharacteristicsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Characteristics", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.Characteristics =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPharmaceuticalCharacteristicsSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductPharmaceuticalRouteOfAdministrationSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductPharmaceuticalRouteOfAdministrationSurrogate> by lazy {
    MedicinalProductPharmaceuticalRouteOfAdministrationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RouteOfAdministration", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.RouteOfAdministration =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPharmaceuticalRouteOfAdministrationSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSurrogate> by lazy {
    MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TargetSpecies", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod> {
  internal val surrogateSerializer:
    KSerializer<
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
    > by lazy {
    MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
      .serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("WithdrawalPeriod", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
        .fromModel(value),
    )
  }
}

public object MedicinalProductPharmaceuticalSerializer :
  KSerializer<MedicinalProductPharmaceutical> {
  internal val surrogateSerializer: KSerializer<MedicinalProductPharmaceuticalSurrogate> by lazy {
    MedicinalProductPharmaceuticalSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductPharmaceutical", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPharmaceutical) {
    surrogateSerializer.serialize(encoder, MedicinalProductPharmaceuticalSurrogate.fromModel(value))
  }
}
