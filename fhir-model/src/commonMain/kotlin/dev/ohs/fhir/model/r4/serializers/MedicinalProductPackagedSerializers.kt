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

import com.google.fhir.model.r4.MedicinalProductPackaged
import com.google.fhir.model.r4.surrogates.MedicinalProductPackagedBatchIdentifierSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPackagedPackageItemSurrogate
import com.google.fhir.model.r4.surrogates.MedicinalProductPackagedSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object MedicinalProductPackagedBatchIdentifierSerializer :
  KSerializer<MedicinalProductPackaged.BatchIdentifier> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductPackagedBatchIdentifierSurrogate> by lazy {
    MedicinalProductPackagedBatchIdentifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("BatchIdentifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.BatchIdentifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.BatchIdentifier) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPackagedBatchIdentifierSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductPackagedPackageItemSerializer :
  KSerializer<MedicinalProductPackaged.PackageItem> {
  internal val surrogateSerializer:
    KSerializer<MedicinalProductPackagedPackageItemSurrogate> by lazy {
    MedicinalProductPackagedPackageItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PackageItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged.PackageItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged.PackageItem) {
    surrogateSerializer.serialize(
      encoder,
      MedicinalProductPackagedPackageItemSurrogate.fromModel(value),
    )
  }
}

public object MedicinalProductPackagedSerializer : KSerializer<MedicinalProductPackaged> {
  internal val surrogateSerializer: KSerializer<MedicinalProductPackagedSurrogate> by lazy {
    MedicinalProductPackagedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MedicinalProductPackaged", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPackaged =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPackaged) {
    surrogateSerializer.serialize(encoder, MedicinalProductPackagedSurrogate.fromModel(value))
  }
}
