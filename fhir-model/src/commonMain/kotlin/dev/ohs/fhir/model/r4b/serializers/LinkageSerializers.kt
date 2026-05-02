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

import com.google.fhir.model.r5.Linkage
import com.google.fhir.model.r5.surrogates.LinkageItemSurrogate
import com.google.fhir.model.r5.surrogates.LinkageSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object LinkageItemSerializer : KSerializer<Linkage.Item> {
  internal val surrogateSerializer: KSerializer<LinkageItemSurrogate> by lazy {
    LinkageItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Item", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Linkage.Item =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Linkage.Item) {
    surrogateSerializer.serialize(encoder, LinkageItemSurrogate.fromModel(value))
  }
}

public object LinkageSerializer : KSerializer<Linkage> {
  internal val surrogateSerializer: KSerializer<LinkageSurrogate> by lazy {
    LinkageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Linkage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Linkage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Linkage) {
    surrogateSerializer.serialize(encoder, LinkageSurrogate.fromModel(value))
  }
}
