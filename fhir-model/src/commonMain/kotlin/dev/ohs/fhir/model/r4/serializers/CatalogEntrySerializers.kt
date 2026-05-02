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

import com.google.fhir.model.r4b.CatalogEntry
import com.google.fhir.model.r4b.surrogates.CatalogEntryRelatedEntrySurrogate
import com.google.fhir.model.r4b.surrogates.CatalogEntrySurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object CatalogEntryRelatedEntrySerializer : KSerializer<CatalogEntry.RelatedEntry> {
  internal val surrogateSerializer: KSerializer<CatalogEntryRelatedEntrySurrogate> by lazy {
    CatalogEntryRelatedEntrySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatedEntry", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CatalogEntry.RelatedEntry =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CatalogEntry.RelatedEntry) {
    surrogateSerializer.serialize(encoder, CatalogEntryRelatedEntrySurrogate.fromModel(value))
  }
}

public object CatalogEntrySerializer : KSerializer<CatalogEntry> {
  internal val surrogateSerializer: KSerializer<CatalogEntrySurrogate> by lazy {
    CatalogEntrySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CatalogEntry", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CatalogEntry =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: CatalogEntry) {
    surrogateSerializer.serialize(encoder, CatalogEntrySurrogate.fromModel(value))
  }
}
