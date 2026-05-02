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

import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.PaymentReconciliation
import com.google.fhir.model.r5.surrogates.PaymentReconciliationAllocationSurrogate
import com.google.fhir.model.r5.surrogates.PaymentReconciliationAllocationTargetItemSurrogate
import com.google.fhir.model.r5.surrogates.PaymentReconciliationProcessNoteSurrogate
import com.google.fhir.model.r5.surrogates.PaymentReconciliationSurrogate
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject

public object PaymentReconciliationAllocationSerializer :
  KSerializer<PaymentReconciliation.Allocation> {
  internal val surrogateSerializer: KSerializer<PaymentReconciliationAllocationSurrogate> by lazy {
    PaymentReconciliationAllocationSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("targetItem")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Allocation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation {
    val jsonDecoder =
      decoder as? JsonDecoder ?: error("This serializer only supports JSON decoding")
    val oldJsonObject =
      JsonObject(
        jsonDecoder.decodeJsonElement().jsonObject.toMutableMap().apply { remove("resourceType") }
      )
    val unflattenedJsonObject = FhirJsonTransformer.unflatten(oldJsonObject, multiChoiceProperties)
    val surrogate =
      jsonDecoder.json.decodeFromJsonElement(surrogateSerializer, unflattenedJsonObject)
    return surrogate.toModel()
  }

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = PaymentReconciliationAllocationSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
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

public object PaymentReconciliationAllocationTargetItemSerializer :
  KSerializer<PaymentReconciliation.Allocation.TargetItem> {
  internal val surrogateSerializer:
    KSerializer<PaymentReconciliationAllocationTargetItemSurrogate> by lazy {
    PaymentReconciliationAllocationTargetItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TargetItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): PaymentReconciliation.Allocation.TargetItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: PaymentReconciliation.Allocation.TargetItem) {
    surrogateSerializer.serialize(
      encoder,
      PaymentReconciliationAllocationTargetItemSurrogate.fromModel(value),
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
