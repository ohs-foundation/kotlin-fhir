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
import com.google.fhir.model.r5.Invoice
import com.google.fhir.model.r5.surrogates.InvoiceLineItemChargeItemSurrogate
import com.google.fhir.model.r5.surrogates.InvoiceLineItemServicedSurrogate
import com.google.fhir.model.r5.surrogates.InvoiceLineItemSurrogate
import com.google.fhir.model.r5.surrogates.InvoiceParticipantSurrogate
import com.google.fhir.model.r5.surrogates.InvoicePeriodSurrogate
import com.google.fhir.model.r5.surrogates.InvoiceSurrogate
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

public object InvoiceParticipantSerializer : KSerializer<Invoice.Participant> {
  internal val surrogateSerializer: KSerializer<InvoiceParticipantSurrogate> by lazy {
    InvoiceParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Invoice.Participant) {
    surrogateSerializer.serialize(encoder, InvoiceParticipantSurrogate.fromModel(value))
  }
}

public object InvoiceLineItemSerializer : KSerializer<Invoice.LineItem> {
  internal val surrogateSerializer: KSerializer<InvoiceLineItemSurrogate> by lazy {
    InvoiceLineItemSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("serviced", "chargeItem")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("LineItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice.LineItem {
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

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = InvoiceLineItemSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object InvoicePeriodSerializer : KSerializer<Invoice.Period> {
  internal val surrogateSerializer: KSerializer<InvoicePeriodSurrogate> by lazy {
    InvoicePeriodSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Period", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice.Period =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Invoice.Period) {
    surrogateSerializer.serialize(encoder, InvoicePeriodSurrogate.fromModel(value))
  }
}

public object InvoiceLineItemServicedSerializer : KSerializer<Invoice.LineItem.Serviced> {
  internal val surrogateSerializer: KSerializer<InvoiceLineItemServicedSurrogate> by lazy {
    InvoiceLineItemServicedSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Serviced", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice.LineItem.Serviced =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.Serviced) {
    surrogateSerializer.serialize(encoder, InvoiceLineItemServicedSurrogate.fromModel(value))
  }
}

public object InvoiceLineItemChargeItemSerializer : KSerializer<Invoice.LineItem.ChargeItem> {
  internal val surrogateSerializer: KSerializer<InvoiceLineItemChargeItemSurrogate> by lazy {
    InvoiceLineItemChargeItemSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ChargeItem", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice.LineItem.ChargeItem =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Invoice.LineItem.ChargeItem) {
    surrogateSerializer.serialize(encoder, InvoiceLineItemChargeItemSurrogate.fromModel(value))
  }
}

public object InvoiceSerializer : KSerializer<Invoice> {
  internal val surrogateSerializer: KSerializer<InvoiceSurrogate> by lazy {
    InvoiceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("period")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Invoice", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Invoice {
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

  override fun serialize(encoder: Encoder, `value`: Invoice) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = InvoiceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
