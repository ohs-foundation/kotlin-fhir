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

import com.google.fhir.model.r5.BodyStructure
import com.google.fhir.model.r5.surrogates.BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
import com.google.fhir.model.r5.surrogates.BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate
import com.google.fhir.model.r5.surrogates.BodyStructureIncludedStructureSurrogate
import com.google.fhir.model.r5.surrogates.BodyStructureSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object BodyStructureIncludedStructureSerializer :
  KSerializer<BodyStructure.IncludedStructure> {
  internal val surrogateSerializer: KSerializer<BodyStructureIncludedStructureSurrogate> by lazy {
    BodyStructureIncludedStructureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("IncludedStructure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BodyStructure.IncludedStructure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BodyStructure.IncludedStructure) {
    surrogateSerializer.serialize(encoder, BodyStructureIncludedStructureSurrogate.fromModel(value))
  }
}

public object BodyStructureIncludedStructureBodyLandmarkOrientationSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation> {
  internal val surrogateSerializer:
    KSerializer<BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate> by lazy {
    BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BodyLandmarkOrientation", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation,
  ) {
    surrogateSerializer.serialize(
      encoder,
      BodyStructureIncludedStructureBodyLandmarkOrientationSurrogate.fromModel(value),
    )
  }
}

public object BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSerializer :
  KSerializer<BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark> {
  internal val surrogateSerializer:
    KSerializer<
      BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate
    > by lazy {
    BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DistanceFromLandmark", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: BodyStructure.IncludedStructure.BodyLandmarkOrientation.DistanceFromLandmark,
  ) {
    surrogateSerializer.serialize(
      encoder,
      BodyStructureIncludedStructureBodyLandmarkOrientationDistanceFromLandmarkSurrogate.fromModel(
        value
      ),
    )
  }
}

public object BodyStructureSerializer : KSerializer<BodyStructure> {
  internal val surrogateSerializer: KSerializer<BodyStructureSurrogate> by lazy {
    BodyStructureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BodyStructure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): BodyStructure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: BodyStructure) {
    surrogateSerializer.serialize(encoder, BodyStructureSurrogate.fromModel(value))
  }
}
