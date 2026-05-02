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

import com.google.fhir.model.r4.ImagingStudy
import com.google.fhir.model.r4.surrogates.ImagingStudySeriesInstanceSurrogate
import com.google.fhir.model.r4.surrogates.ImagingStudySeriesPerformerSurrogate
import com.google.fhir.model.r4.surrogates.ImagingStudySeriesSurrogate
import com.google.fhir.model.r4.surrogates.ImagingStudySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ImagingStudySeriesSerializer : KSerializer<ImagingStudy.Series> {
  internal val surrogateSerializer: KSerializer<ImagingStudySeriesSurrogate> by lazy {
    ImagingStudySeriesSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Series", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series) {
    surrogateSerializer.serialize(encoder, ImagingStudySeriesSurrogate.fromModel(value))
  }
}

public object ImagingStudySeriesPerformerSerializer : KSerializer<ImagingStudy.Series.Performer> {
  internal val surrogateSerializer: KSerializer<ImagingStudySeriesPerformerSurrogate> by lazy {
    ImagingStudySeriesPerformerSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Performer", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Performer =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Performer) {
    surrogateSerializer.serialize(encoder, ImagingStudySeriesPerformerSurrogate.fromModel(value))
  }
}

public object ImagingStudySeriesInstanceSerializer : KSerializer<ImagingStudy.Series.Instance> {
  internal val surrogateSerializer: KSerializer<ImagingStudySeriesInstanceSurrogate> by lazy {
    ImagingStudySeriesInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingStudy.Series.Instance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingStudy.Series.Instance) {
    surrogateSerializer.serialize(encoder, ImagingStudySeriesInstanceSurrogate.fromModel(value))
  }
}

public object ImagingStudySerializer : KSerializer<ImagingStudy> {
  internal val surrogateSerializer: KSerializer<ImagingStudySurrogate> by lazy {
    ImagingStudySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ImagingStudy", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ImagingStudy =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ImagingStudy) {
    surrogateSerializer.serialize(encoder, ImagingStudySurrogate.fromModel(value))
  }
}
