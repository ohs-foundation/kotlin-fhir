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

import com.google.fhir.model.r4.Bundle
import com.google.fhir.model.r4.surrogates.BundleEntryRequestSurrogate
import com.google.fhir.model.r4.surrogates.BundleEntryResponseSurrogate
import com.google.fhir.model.r4.surrogates.BundleEntrySearchSurrogate
import com.google.fhir.model.r4.surrogates.BundleEntrySurrogate
import com.google.fhir.model.r4.surrogates.BundleLinkSurrogate
import com.google.fhir.model.r4.surrogates.BundleSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object BundleLinkSerializer : KSerializer<Bundle.Link> {
  internal val surrogateSerializer: KSerializer<BundleLinkSurrogate> by lazy {
    BundleLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle.Link) {
    surrogateSerializer.serialize(encoder, BundleLinkSurrogate.fromModel(value))
  }
}

public object BundleEntrySerializer : KSerializer<Bundle.Entry> {
  internal val surrogateSerializer: KSerializer<BundleEntrySurrogate> by lazy {
    BundleEntrySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Entry", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry) {
    surrogateSerializer.serialize(encoder, BundleEntrySurrogate.fromModel(value))
  }
}

public object BundleEntrySearchSerializer : KSerializer<Bundle.Entry.Search> {
  internal val surrogateSerializer: KSerializer<BundleEntrySearchSurrogate> by lazy {
    BundleEntrySearchSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Search", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Search =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Search) {
    surrogateSerializer.serialize(encoder, BundleEntrySearchSurrogate.fromModel(value))
  }
}

public object BundleEntryRequestSerializer : KSerializer<Bundle.Entry.Request> {
  internal val surrogateSerializer: KSerializer<BundleEntryRequestSurrogate> by lazy {
    BundleEntryRequestSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Request", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Request =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Request) {
    surrogateSerializer.serialize(encoder, BundleEntryRequestSurrogate.fromModel(value))
  }
}

public object BundleEntryResponseSerializer : KSerializer<Bundle.Entry.Response> {
  internal val surrogateSerializer: KSerializer<BundleEntryResponseSurrogate> by lazy {
    BundleEntryResponseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Response", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle.Entry.Response =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle.Entry.Response) {
    surrogateSerializer.serialize(encoder, BundleEntryResponseSurrogate.fromModel(value))
  }
}

public object BundleSerializer : KSerializer<Bundle> {
  internal val surrogateSerializer: KSerializer<BundleSurrogate> by lazy {
    BundleSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Bundle", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Bundle =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Bundle) {
    surrogateSerializer.serialize(encoder, BundleSurrogate.fromModel(value))
  }
}
