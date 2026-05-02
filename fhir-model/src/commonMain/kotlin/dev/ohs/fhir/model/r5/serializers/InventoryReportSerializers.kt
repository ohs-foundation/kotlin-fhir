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

import com.google.fhir.model.r5.InventoryReport
import com.google.fhir.model.r5.surrogates.InventoryReportInventoryListingItemSurrogate
import com.google.fhir.model.r5.surrogates.InventoryReportInventoryListingSurrogate
import com.google.fhir.model.r5.surrogates.InventoryReportSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object InventoryReportInventoryListingSerializer :
  KSerializer<InventoryReport.InventoryListing> {
  internal val surrogateSerializer: KSerializer<InventoryReportInventoryListingSurrogate> by lazy {
    InventoryReportInventoryListingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("InventoryListing", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing) {
    surrogateSerializer.serialize(
      encoder,
      InventoryReportInventoryListingSurrogate.fromModel(value),
    )
  }
}

public object InventoryReportInventoryListingItemSerializer :
  KSerializer<InventoryReport.InventoryListing.Item> {
  internal val surrogateSerializer:
    KSerializer<InventoryReportInventoryListingItemSurrogate> by lazy {
    InventoryReportInventoryListingItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryReport.InventoryListing.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryReport.InventoryListing.Item) {
    surrogateSerializer.serialize(
      encoder,
      InventoryReportInventoryListingItemSurrogate.fromModel(value),
    )
  }
}

public object InventoryReportSerializer : KSerializer<InventoryReport> {
  internal val surrogateSerializer: KSerializer<InventoryReportSurrogate> by lazy {
    InventoryReportSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("InventoryReport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InventoryReport =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InventoryReport) {
    surrogateSerializer.serialize(encoder, InventoryReportSurrogate.fromModel(value))
  }
}
