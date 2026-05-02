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

import com.google.fhir.model.r5.MedicationDispense
import com.google.fhir.model.r5.surrogates.MedicationDispensePerformerSurrogate
import com.google.fhir.model.r5.surrogates.MedicationDispenseSubstitutionSurrogate
import com.google.fhir.model.r5.surrogates.MedicationDispenseSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MedicationDispensePerformerSerializer : KSerializer<MedicationDispense.Performer> {
  internal val surrogateSerializer: KSerializer<MedicationDispensePerformerSurrogate> by lazy {
    MedicationDispensePerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Performer) {
    surrogateSerializer.serialize(encoder, MedicationDispensePerformerSurrogate.fromModel(value))
  }
}

public object MedicationDispenseSubstitutionSerializer :
  KSerializer<MedicationDispense.Substitution> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseSubstitutionSurrogate> by lazy {
    MedicationDispenseSubstitutionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Substitution", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense.Substitution =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense.Substitution) {
    surrogateSerializer.serialize(encoder, MedicationDispenseSubstitutionSurrogate.fromModel(value))
  }
}

public object MedicationDispenseSerializer : KSerializer<MedicationDispense> {
  internal val surrogateSerializer: KSerializer<MedicationDispenseSurrogate> by lazy {
    MedicationDispenseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicationDispense", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicationDispense =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicationDispense) {
    surrogateSerializer.serialize(encoder, MedicationDispenseSurrogate.fromModel(value))
  }
}
