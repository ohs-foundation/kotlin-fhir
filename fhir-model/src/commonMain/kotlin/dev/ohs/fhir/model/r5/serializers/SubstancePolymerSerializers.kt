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

import com.google.fhir.model.r4.SubstancePolymer
import com.google.fhir.model.r4.surrogates.SubstancePolymerMonomerSetStartingMaterialSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerMonomerSetSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerRepeatRepeatUnitSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerRepeatSurrogate
import com.google.fhir.model.r4.surrogates.SubstancePolymerSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubstancePolymerMonomerSetSerializer : KSerializer<SubstancePolymer.MonomerSet> {
  internal val surrogateSerializer: KSerializer<SubstancePolymerMonomerSetSurrogate> by lazy {
    SubstancePolymerMonomerSetSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MonomerSet", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet) {
    surrogateSerializer.serialize(encoder, SubstancePolymerMonomerSetSurrogate.fromModel(value))
  }
}

public object SubstancePolymerMonomerSetStartingMaterialSerializer :
  KSerializer<SubstancePolymer.MonomerSet.StartingMaterial> {
  internal val surrogateSerializer:
    KSerializer<SubstancePolymerMonomerSetStartingMaterialSurrogate> by lazy {
    SubstancePolymerMonomerSetStartingMaterialSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StartingMaterial", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.MonomerSet.StartingMaterial =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.MonomerSet.StartingMaterial) {
    surrogateSerializer.serialize(
      encoder,
      SubstancePolymerMonomerSetStartingMaterialSurrogate.fromModel(value),
    )
  }
}

public object SubstancePolymerRepeatSerializer : KSerializer<SubstancePolymer.Repeat> {
  internal val surrogateSerializer: KSerializer<SubstancePolymerRepeatSurrogate> by lazy {
    SubstancePolymerRepeatSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Repeat", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat) {
    surrogateSerializer.serialize(encoder, SubstancePolymerRepeatSurrogate.fromModel(value))
  }
}

public object SubstancePolymerRepeatRepeatUnitSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit> {
  internal val surrogateSerializer: KSerializer<SubstancePolymerRepeatRepeatUnitSurrogate> by lazy {
    SubstancePolymerRepeatRepeatUnitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RepeatUnit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer.Repeat.RepeatUnit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer.Repeat.RepeatUnit) {
    surrogateSerializer.serialize(
      encoder,
      SubstancePolymerRepeatRepeatUnitSurrogate.fromModel(value),
    )
  }
}

public object SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation> {
  internal val surrogateSerializer:
    KSerializer<SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate> by lazy {
    SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DegreeOfPolymerisation", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.DegreeOfPolymerisation,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationSurrogate.fromModel(value),
    )
  }
}

public object SubstancePolymerRepeatRepeatUnitStructuralRepresentationSerializer :
  KSerializer<SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation> {
  internal val surrogateSerializer:
    KSerializer<SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate> by lazy {
    SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StructuralRepresentation", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: SubstancePolymer.Repeat.RepeatUnit.StructuralRepresentation,
  ) {
    surrogateSerializer.serialize(
      encoder,
      SubstancePolymerRepeatRepeatUnitStructuralRepresentationSurrogate.fromModel(value),
    )
  }
}

public object SubstancePolymerSerializer : KSerializer<SubstancePolymer> {
  internal val surrogateSerializer: KSerializer<SubstancePolymerSurrogate> by lazy {
    SubstancePolymerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstancePolymer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstancePolymer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstancePolymer) {
    surrogateSerializer.serialize(encoder, SubstancePolymerSurrogate.fromModel(value))
  }
}
