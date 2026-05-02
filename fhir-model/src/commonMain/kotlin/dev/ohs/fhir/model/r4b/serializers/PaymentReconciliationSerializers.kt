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

import com.google.fhir.model.r4b.PaymentReconciliation
import com.google.fhir.model.r4b.surrogates.PaymentReconciliationDetailSurrogate
import com.google.fhir.model.r4b.surrogates.PaymentReconciliationProcessNoteSurrogate
import com.google.fhir.model.r4b.surrogates.PaymentReconciliationSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object PaymentReconciliationDetailSerializer : KSerializer<PaymentReconciliation.Detail> {
  internal val surrogateSerializer: KSerializer<PaymentReconciliationDetailSurrogate> by lazy {
    PaymentReconciliationDetailSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Detail", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Detail =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Detail) {
    surrogateSerializer.serialize(encoder, PaymentReconciliationDetailSurrogate.fromModel(value))
  }
}

public object PaymentReconciliationProcessNoteSerializer :
  KSerializer<PaymentReconciliation.ProcessNote> {
  internal val surrogateSerializer: KSerializer<PaymentReconciliationProcessNoteSurrogate> by lazy {
    PaymentReconciliationProcessNoteSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ProcessNote", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.ProcessNote =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.ProcessNote) {
    surrogateSerializer.serialize(
      encoder,
      PaymentReconciliationProcessNoteSurrogate.fromModel(value),
    )
  }
}

public object PaymentReconciliationSerializer : KSerializer<PaymentReconciliation> {
  internal val surrogateSerializer: KSerializer<PaymentReconciliationSurrogate> by lazy {
    PaymentReconciliationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("PaymentReconciliation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation) {
    surrogateSerializer.serialize(encoder, PaymentReconciliationSurrogate.fromModel(value))
  }
}
