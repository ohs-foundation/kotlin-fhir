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

import com.google.fhir.model.r5.List
import com.google.fhir.model.r5.surrogates.ListEntrySurrogate
import com.google.fhir.model.r5.surrogates.ListSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object ListEntrySerializer : KSerializer<List.Entry> {
  internal val surrogateSerializer: KSerializer<ListEntrySurrogate> by lazy {
    ListEntrySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Entry", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): List.Entry =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: List.Entry) {
    surrogateSerializer.serialize(encoder, ListEntrySurrogate.fromModel(value))
  }
}

public object ListSerializer : KSerializer<List> {
  internal val surrogateSerializer: KSerializer<ListSurrogate> by lazy {
    ListSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("List", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): List =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: List) {
    surrogateSerializer.serialize(encoder, ListSurrogate.fromModel(value))
  }
}
