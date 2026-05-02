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

package com.google.fhir.model.r4b.serializers

import com.google.fhir.model.r4b.VerificationResult
import com.google.fhir.model.r4b.surrogates.VerificationResultAttestationSurrogate
import com.google.fhir.model.r4b.surrogates.VerificationResultPrimarySourceSurrogate
import com.google.fhir.model.r4b.surrogates.VerificationResultSurrogate
import com.google.fhir.model.r4b.surrogates.VerificationResultValidatorSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object VerificationResultPrimarySourceSerializer :
  KSerializer<VerificationResult.PrimarySource> {
  internal val surrogateSerializer: KSerializer<VerificationResultPrimarySourceSurrogate> by lazy {
    VerificationResultPrimarySourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PrimarySource", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.PrimarySource =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VerificationResult.PrimarySource) {
    surrogateSerializer.serialize(
      encoder,
      VerificationResultPrimarySourceSurrogate.fromModel(value),
    )
  }
}

public object VerificationResultAttestationSerializer :
  KSerializer<VerificationResult.Attestation> {
  internal val surrogateSerializer: KSerializer<VerificationResultAttestationSurrogate> by lazy {
    VerificationResultAttestationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Attestation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.Attestation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Attestation) {
    surrogateSerializer.serialize(encoder, VerificationResultAttestationSurrogate.fromModel(value))
  }
}

public object VerificationResultValidatorSerializer : KSerializer<VerificationResult.Validator> {
  internal val surrogateSerializer: KSerializer<VerificationResultValidatorSurrogate> by lazy {
    VerificationResultValidatorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Validator", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult.Validator =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VerificationResult.Validator) {
    surrogateSerializer.serialize(encoder, VerificationResultValidatorSurrogate.fromModel(value))
  }
}

public object VerificationResultSerializer : KSerializer<VerificationResult> {
  internal val surrogateSerializer: KSerializer<VerificationResultSurrogate> by lazy {
    VerificationResultSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VerificationResult", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VerificationResult =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VerificationResult) {
    surrogateSerializer.serialize(encoder, VerificationResultSurrogate.fromModel(value))
  }
}
