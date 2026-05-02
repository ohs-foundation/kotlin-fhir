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

import com.google.fhir.model.r4.EffectEvidenceSynthesis
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisCertaintySurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisEffectEstimateSurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisResultsByExposureSurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisSampleSizeSurrogate
import com.google.fhir.model.r4.surrogates.EffectEvidenceSynthesisSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object EffectEvidenceSynthesisSampleSizeSerializer :
  KSerializer<EffectEvidenceSynthesis.SampleSize> {
  internal val surrogateSerializer:
    KSerializer<EffectEvidenceSynthesisSampleSizeSurrogate> by lazy {
    EffectEvidenceSynthesisSampleSizeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SampleSize", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.SampleSize =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.SampleSize) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisSampleSizeSurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisResultsByExposureSerializer :
  KSerializer<EffectEvidenceSynthesis.ResultsByExposure> {
  internal val surrogateSerializer:
    KSerializer<EffectEvidenceSynthesisResultsByExposureSurrogate> by lazy {
    EffectEvidenceSynthesisResultsByExposureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ResultsByExposure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.ResultsByExposure =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.ResultsByExposure) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisResultsByExposureSurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisEffectEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate> {
  internal val surrogateSerializer:
    KSerializer<EffectEvidenceSynthesisEffectEstimateSurrogate> by lazy {
    EffectEvidenceSynthesisEffectEstimateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EffectEstimate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.EffectEstimate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.EffectEstimate) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisEffectEstimateSurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer :
  KSerializer<EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate> {
  internal val surrogateSerializer:
    KSerializer<EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate> by lazy {
    EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PrecisionEstimate", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.EffectEstimate.PrecisionEstimate,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisCertaintySerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty> {
  internal val surrogateSerializer: KSerializer<EffectEvidenceSynthesisCertaintySurrogate> by lazy {
    EffectEvidenceSynthesisCertaintySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Certainty", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis.Certainty =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis.Certainty) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisCertaintySurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer :
  KSerializer<EffectEvidenceSynthesis.Certainty.CertaintySubcomponent> {
  internal val surrogateSerializer:
    KSerializer<EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate> by lazy {
    EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CertaintySubcomponent", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): EffectEvidenceSynthesis.Certainty.CertaintySubcomponent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: EffectEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EffectEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.fromModel(value),
    )
  }
}

public object EffectEvidenceSynthesisSerializer : KSerializer<EffectEvidenceSynthesis> {
  internal val surrogateSerializer: KSerializer<EffectEvidenceSynthesisSurrogate> by lazy {
    EffectEvidenceSynthesisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("EffectEvidenceSynthesis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): EffectEvidenceSynthesis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: EffectEvidenceSynthesis) {
    surrogateSerializer.serialize(encoder, EffectEvidenceSynthesisSurrogate.fromModel(value))
  }
}
