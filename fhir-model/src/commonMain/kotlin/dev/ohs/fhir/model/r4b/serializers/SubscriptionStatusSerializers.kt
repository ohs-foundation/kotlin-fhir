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

import com.google.fhir.model.r4b.SubscriptionStatus
import com.google.fhir.model.r4b.surrogates.SubscriptionStatusNotificationEventSurrogate
import com.google.fhir.model.r4b.surrogates.SubscriptionStatusSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object SubscriptionStatusNotificationEventSerializer :
  KSerializer<SubscriptionStatus.NotificationEvent> {
  internal val surrogateSerializer:
    KSerializer<SubscriptionStatusNotificationEventSurrogate> by lazy {
    SubscriptionStatusNotificationEventSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("NotificationEvent", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionStatus.NotificationEvent =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus.NotificationEvent) {
    surrogateSerializer.serialize(
      encoder,
      SubscriptionStatusNotificationEventSurrogate.fromModel(value),
    )
  }
}

public object SubscriptionStatusSerializer : KSerializer<SubscriptionStatus> {
  internal val surrogateSerializer: KSerializer<SubscriptionStatusSurrogate> by lazy {
    SubscriptionStatusSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubscriptionStatus", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubscriptionStatus =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubscriptionStatus) {
    surrogateSerializer.serialize(encoder, SubscriptionStatusSurrogate.fromModel(value))
  }
}
