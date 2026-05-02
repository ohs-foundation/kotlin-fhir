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

import com.google.fhir.model.r4.MolecularSequence
import com.google.fhir.model.r4.surrogates.MolecularSequenceQualityRocSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceQualitySurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceReferenceSeqSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceRepositorySurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceStructureVariantInnerSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceStructureVariantOuterSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceStructureVariantSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceSurrogate
import com.google.fhir.model.r4.surrogates.MolecularSequenceVariantSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MolecularSequenceReferenceSeqSerializer :
  KSerializer<MolecularSequence.ReferenceSeq> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceReferenceSeqSurrogate> by lazy {
    MolecularSequenceReferenceSeqSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferenceSeq", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.ReferenceSeq =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.ReferenceSeq) {
    surrogateSerializer.serialize(encoder, MolecularSequenceReferenceSeqSurrogate.fromModel(value))
  }
}

public object MolecularSequenceVariantSerializer : KSerializer<MolecularSequence.Variant> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceVariantSurrogate> by lazy {
    MolecularSequenceVariantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Variant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Variant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Variant) {
    surrogateSerializer.serialize(encoder, MolecularSequenceVariantSurrogate.fromModel(value))
  }
}

public object MolecularSequenceQualitySerializer : KSerializer<MolecularSequence.Quality> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceQualitySurrogate> by lazy {
    MolecularSequenceQualitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Quality", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality) {
    surrogateSerializer.serialize(encoder, MolecularSequenceQualitySurrogate.fromModel(value))
  }
}

public object MolecularSequenceQualityRocSerializer : KSerializer<MolecularSequence.Quality.Roc> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceQualityRocSurrogate> by lazy {
    MolecularSequenceQualityRocSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Roc", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Quality.Roc =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Quality.Roc) {
    surrogateSerializer.serialize(encoder, MolecularSequenceQualityRocSurrogate.fromModel(value))
  }
}

public object MolecularSequenceRepositorySerializer : KSerializer<MolecularSequence.Repository> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceRepositorySurrogate> by lazy {
    MolecularSequenceRepositorySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Repository", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.Repository =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.Repository) {
    surrogateSerializer.serialize(encoder, MolecularSequenceRepositorySurrogate.fromModel(value))
  }
}

public object MolecularSequenceStructureVariantSerializer :
  KSerializer<MolecularSequence.StructureVariant> {
  internal val surrogateSerializer:
    KSerializer<MolecularSequenceStructureVariantSurrogate> by lazy {
    MolecularSequenceStructureVariantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StructureVariant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant) {
    surrogateSerializer.serialize(
      encoder,
      MolecularSequenceStructureVariantSurrogate.fromModel(value),
    )
  }
}

public object MolecularSequenceStructureVariantOuterSerializer :
  KSerializer<MolecularSequence.StructureVariant.Outer> {
  internal val surrogateSerializer:
    KSerializer<MolecularSequenceStructureVariantOuterSurrogate> by lazy {
    MolecularSequenceStructureVariantOuterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Outer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Outer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Outer) {
    surrogateSerializer.serialize(
      encoder,
      MolecularSequenceStructureVariantOuterSurrogate.fromModel(value),
    )
  }
}

public object MolecularSequenceStructureVariantInnerSerializer :
  KSerializer<MolecularSequence.StructureVariant.Inner> {
  internal val surrogateSerializer:
    KSerializer<MolecularSequenceStructureVariantInnerSurrogate> by lazy {
    MolecularSequenceStructureVariantInnerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Inner", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence.StructureVariant.Inner =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence.StructureVariant.Inner) {
    surrogateSerializer.serialize(
      encoder,
      MolecularSequenceStructureVariantInnerSurrogate.fromModel(value),
    )
  }
}

public object MolecularSequenceSerializer : KSerializer<MolecularSequence> {
  internal val surrogateSerializer: KSerializer<MolecularSequenceSurrogate> by lazy {
    MolecularSequenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MolecularSequence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MolecularSequence =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MolecularSequence) {
    surrogateSerializer.serialize(encoder, MolecularSequenceSurrogate.fromModel(value))
  }
}
