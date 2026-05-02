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

import com.google.fhir.model.r5.Subscription
import com.google.fhir.model.r5.surrogates.SubscriptionFilterBySurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionParameterSurrogate
import com.google.fhir.model.r5.surrogates.SubscriptionSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubscriptionFilterBySerializer : KSerializer<Subscription.FilterBy> {
  internal val surrogateSerializer: KSerializer<SubscriptionFilterBySurrogate> by lazy {
    SubscriptionFilterBySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("FilterBy", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Subscription.FilterBy =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Subscription.FilterBy) {
    surrogateSerializer.serialize(encoder, SubscriptionFilterBySurrogate.fromModel(value))
  }
}

public object SubscriptionParameterSerializer : KSerializer<Subscription.Parameter> {
  internal val surrogateSerializer: KSerializer<SubscriptionParameterSurrogate> by lazy {
    SubscriptionParameterSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Parameter", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Subscription.Parameter =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Subscription.Parameter) {
    surrogateSerializer.serialize(encoder, SubscriptionParameterSurrogate.fromModel(value))
  }
}

public object SubscriptionSerializer : KSerializer<Subscription> {
  internal val surrogateSerializer: KSerializer<SubscriptionSurrogate> by lazy {
    SubscriptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subscription", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Subscription =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Subscription) {
    surrogateSerializer.serialize(encoder, SubscriptionSurrogate.fromModel(value))
  }
}
