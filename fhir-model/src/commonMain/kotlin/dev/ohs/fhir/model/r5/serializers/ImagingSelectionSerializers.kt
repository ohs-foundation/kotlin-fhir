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

import com.google.fhir.model.r5.ImagingSelection
import com.google.fhir.model.r5.surrogates.ImagingSelectionInstanceImageRegion2DSurrogate
import com.google.fhir.model.r5.surrogates.ImagingSelectionInstanceImageRegion3DSurrogate
import com.google.fhir.model.r5.surrogates.ImagingSelectionInstanceSurrogate
import com.google.fhir.model.r5.surrogates.ImagingSelectionPerformerSurrogate
import com.google.fhir.model.r5.surrogates.ImagingSelectionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ImagingSelectionPerformerSerializer : KSerializer<ImagingSelection.Performer> {
  internal val surrogateSerializer: KSerializer<ImagingSelectionPerformerSurrogate> by lazy {
    ImagingSelectionPerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Performer) {
    surrogateSerializer.serialize(encoder, ImagingSelectionPerformerSurrogate.fromModel(value))
  }
}

public object ImagingSelectionInstanceSerializer : KSerializer<ImagingSelection.Instance> {
  internal val surrogateSerializer: KSerializer<ImagingSelectionInstanceSurrogate> by lazy {
    ImagingSelectionInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance) {
    surrogateSerializer.serialize(encoder, ImagingSelectionInstanceSurrogate.fromModel(value))
  }
}

public object ImagingSelectionInstanceImageRegion2DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion2D> {
  internal val surrogateSerializer:
    KSerializer<ImagingSelectionInstanceImageRegion2DSurrogate> by lazy {
    ImagingSelectionInstanceImageRegion2DSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ImageRegion2D", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion2D =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion2D) {
    surrogateSerializer.serialize(
      encoder,
      ImagingSelectionInstanceImageRegion2DSurrogate.fromModel(value),
    )
  }
}

public object ImagingSelectionInstanceImageRegion3DSerializer :
  KSerializer<ImagingSelection.Instance.ImageRegion3D> {
  internal val surrogateSerializer:
    KSerializer<ImagingSelectionInstanceImageRegion3DSurrogate> by lazy {
    ImagingSelectionInstanceImageRegion3DSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ImageRegion3D", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection.Instance.ImageRegion3D =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingSelection.Instance.ImageRegion3D) {
    surrogateSerializer.serialize(
      encoder,
      ImagingSelectionInstanceImageRegion3DSurrogate.fromModel(value),
    )
  }
}

public object ImagingSelectionSerializer : KSerializer<ImagingSelection> {
  internal val surrogateSerializer: KSerializer<ImagingSelectionSurrogate> by lazy {
    ImagingSelectionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ImagingSelection", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingSelection =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingSelection) {
    surrogateSerializer.serialize(encoder, ImagingSelectionSurrogate.fromModel(value))
  }
}
