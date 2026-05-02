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

import com.google.fhir.model.r4b.DocumentManifest
import com.google.fhir.model.r4b.surrogates.DocumentManifestRelatedSurrogate
import com.google.fhir.model.r4b.surrogates.DocumentManifestSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object DocumentManifestRelatedSerializer : KSerializer<DocumentManifest.Related> {
  internal val surrogateSerializer: KSerializer<DocumentManifestRelatedSurrogate> by lazy {
    DocumentManifestRelatedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Related", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentManifest.Related =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentManifest.Related) {
    surrogateSerializer.serialize(encoder, DocumentManifestRelatedSurrogate.fromModel(value))
  }
}

public object DocumentManifestSerializer : KSerializer<DocumentManifest> {
  internal val surrogateSerializer: KSerializer<DocumentManifestSurrogate> by lazy {
    DocumentManifestSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DocumentManifest", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentManifest =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentManifest) {
    surrogateSerializer.serialize(encoder, DocumentManifestSurrogate.fromModel(value))
  }
}
