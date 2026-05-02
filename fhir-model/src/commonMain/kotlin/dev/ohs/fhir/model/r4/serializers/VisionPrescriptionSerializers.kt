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

import com.google.fhir.model.r5.VisionPrescription
import com.google.fhir.model.r5.surrogates.VisionPrescriptionLensSpecificationPrismSurrogate
import com.google.fhir.model.r5.surrogates.VisionPrescriptionLensSpecificationSurrogate
import com.google.fhir.model.r5.surrogates.VisionPrescriptionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object VisionPrescriptionLensSpecificationSerializer :
  KSerializer<VisionPrescription.LensSpecification> {
  internal val surrogateSerializer:
    KSerializer<VisionPrescriptionLensSpecificationSurrogate> by lazy {
    VisionPrescriptionLensSpecificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("LensSpecification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification) {
    surrogateSerializer.serialize(
      encoder,
      VisionPrescriptionLensSpecificationSurrogate.fromModel(value),
    )
  }
}

public object VisionPrescriptionLensSpecificationPrismSerializer :
  KSerializer<VisionPrescription.LensSpecification.Prism> {
  internal val surrogateSerializer:
    KSerializer<VisionPrescriptionLensSpecificationPrismSurrogate> by lazy {
    VisionPrescriptionLensSpecificationPrismSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Prism", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VisionPrescription.LensSpecification.Prism =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VisionPrescription.LensSpecification.Prism) {
    surrogateSerializer.serialize(
      encoder,
      VisionPrescriptionLensSpecificationPrismSurrogate.fromModel(value),
    )
  }
}

public object VisionPrescriptionSerializer : KSerializer<VisionPrescription> {
  internal val surrogateSerializer: KSerializer<VisionPrescriptionSurrogate> by lazy {
    VisionPrescriptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VisionPrescription", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): VisionPrescription =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: VisionPrescription) {
    surrogateSerializer.serialize(encoder, VisionPrescriptionSurrogate.fromModel(value))
  }
}
