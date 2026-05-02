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

import com.google.fhir.model.r4b.DocumentReference
import com.google.fhir.model.r4b.surrogates.DocumentReferenceContentSurrogate
import com.google.fhir.model.r4b.surrogates.DocumentReferenceContextSurrogate
import com.google.fhir.model.r4b.surrogates.DocumentReferenceRelatesToSurrogate
import com.google.fhir.model.r4b.surrogates.DocumentReferenceSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object DocumentReferenceRelatesToSerializer : KSerializer<DocumentReference.RelatesTo> {
  internal val surrogateSerializer: KSerializer<DocumentReferenceRelatesToSurrogate> by lazy {
    DocumentReferenceRelatesToSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RelatesTo", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentReference.RelatesTo =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentReference.RelatesTo) {
    surrogateSerializer.serialize(encoder, DocumentReferenceRelatesToSurrogate.fromModel(value))
  }
}

public object DocumentReferenceContentSerializer : KSerializer<DocumentReference.Content> {
  internal val surrogateSerializer: KSerializer<DocumentReferenceContentSurrogate> by lazy {
    DocumentReferenceContentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Content", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentReference.Content =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Content) {
    surrogateSerializer.serialize(encoder, DocumentReferenceContentSurrogate.fromModel(value))
  }
}

public object DocumentReferenceContextSerializer : KSerializer<DocumentReference.Context> {
  internal val surrogateSerializer: KSerializer<DocumentReferenceContextSurrogate> by lazy {
    DocumentReferenceContextSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Context", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentReference.Context =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentReference.Context) {
    surrogateSerializer.serialize(encoder, DocumentReferenceContextSurrogate.fromModel(value))
  }
}

public object DocumentReferenceSerializer : KSerializer<DocumentReference> {
  internal val surrogateSerializer: KSerializer<DocumentReferenceSurrogate> by lazy {
    DocumentReferenceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("DocumentReference", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): DocumentReference =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: DocumentReference) {
    surrogateSerializer.serialize(encoder, DocumentReferenceSurrogate.fromModel(value))
  }
}
