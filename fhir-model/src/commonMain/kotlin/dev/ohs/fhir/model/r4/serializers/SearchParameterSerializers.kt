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

import com.google.fhir.model.r4.SearchParameter
import com.google.fhir.model.r4.surrogates.SearchParameterComponentSurrogate
import com.google.fhir.model.r4.surrogates.SearchParameterSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SearchParameterComponentSerializer : KSerializer<SearchParameter.Component> {
  internal val surrogateSerializer: KSerializer<SearchParameterComponentSurrogate> by lazy {
    SearchParameterComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SearchParameter.Component =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SearchParameter.Component) {
    surrogateSerializer.serialize(encoder, SearchParameterComponentSurrogate.fromModel(value))
  }
}

public object SearchParameterSerializer : KSerializer<SearchParameter> {
  internal val surrogateSerializer: KSerializer<SearchParameterSurrogate> by lazy {
    SearchParameterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SearchParameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SearchParameter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SearchParameter) {
    surrogateSerializer.serialize(encoder, SearchParameterSurrogate.fromModel(value))
  }
}
