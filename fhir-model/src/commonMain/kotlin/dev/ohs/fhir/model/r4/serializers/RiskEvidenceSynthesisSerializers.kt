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

import com.google.fhir.model.r4.RiskEvidenceSynthesis
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisCertaintySurrogate
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSurrogate
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisRiskEstimateSurrogate
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisSampleSizeSurrogate
import com.google.fhir.model.r4.surrogates.RiskEvidenceSynthesisSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object RiskEvidenceSynthesisSampleSizeSerializer :
  KSerializer<RiskEvidenceSynthesis.SampleSize> {
  internal val surrogateSerializer: KSerializer<RiskEvidenceSynthesisSampleSizeSurrogate> by lazy {
    RiskEvidenceSynthesisSampleSizeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SampleSize", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.SampleSize =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.SampleSize) {
    surrogateSerializer.serialize(
      encoder,
      RiskEvidenceSynthesisSampleSizeSurrogate.fromModel(value),
    )
  }
}

public object RiskEvidenceSynthesisRiskEstimateSerializer :
  KSerializer<RiskEvidenceSynthesis.RiskEstimate> {
  internal val surrogateSerializer:
    KSerializer<RiskEvidenceSynthesisRiskEstimateSurrogate> by lazy {
    RiskEvidenceSynthesisRiskEstimateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RiskEstimate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.RiskEstimate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.RiskEstimate) {
    surrogateSerializer.serialize(
      encoder,
      RiskEvidenceSynthesisRiskEstimateSurrogate.fromModel(value),
    )
  }
}

public object RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSerializer :
  KSerializer<RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate> {
  internal val surrogateSerializer:
    KSerializer<RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSurrogate> by lazy {
    RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PrecisionEstimate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: RiskEvidenceSynthesis.RiskEstimate.PrecisionEstimate,
  ) {
    surrogateSerializer.serialize(
      encoder,
      RiskEvidenceSynthesisRiskEstimatePrecisionEstimateSurrogate.fromModel(value),
    )
  }
}

public object RiskEvidenceSynthesisCertaintySerializer :
  KSerializer<RiskEvidenceSynthesis.Certainty> {
  internal val surrogateSerializer: KSerializer<RiskEvidenceSynthesisCertaintySurrogate> by lazy {
    RiskEvidenceSynthesisCertaintySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Certainty", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis.Certainty =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis.Certainty) {
    surrogateSerializer.serialize(encoder, RiskEvidenceSynthesisCertaintySurrogate.fromModel(value))
  }
}

public object RiskEvidenceSynthesisCertaintyCertaintySubcomponentSerializer :
  KSerializer<RiskEvidenceSynthesis.Certainty.CertaintySubcomponent> {
  internal val surrogateSerializer:
    KSerializer<RiskEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate> by lazy {
    RiskEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CertaintySubcomponent", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): RiskEvidenceSynthesis.Certainty.CertaintySubcomponent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: RiskEvidenceSynthesis.Certainty.CertaintySubcomponent,
  ) {
    surrogateSerializer.serialize(
      encoder,
      RiskEvidenceSynthesisCertaintyCertaintySubcomponentSurrogate.fromModel(value),
    )
  }
}

public object RiskEvidenceSynthesisSerializer : KSerializer<RiskEvidenceSynthesis> {
  internal val surrogateSerializer: KSerializer<RiskEvidenceSynthesisSurrogate> by lazy {
    RiskEvidenceSynthesisSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RiskEvidenceSynthesis", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): RiskEvidenceSynthesis =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: RiskEvidenceSynthesis) {
    surrogateSerializer.serialize(encoder, RiskEvidenceSynthesisSurrogate.fromModel(value))
  }
}
