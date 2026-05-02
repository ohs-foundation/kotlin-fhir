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

import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.SubstanceAmount
import com.google.fhir.model.r4.surrogates.SubstanceAmountAmountSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceAmountReferenceRangeSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceAmountSurrogate
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

public object SubstanceAmountReferenceRangeSerializer :
  KSerializer<SubstanceAmount.ReferenceRange> {
  internal val surrogateSerializer: KSerializer<SubstanceAmountReferenceRangeSurrogate> by lazy {
    SubstanceAmountReferenceRangeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ReferenceRange", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceAmount.ReferenceRange =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount.ReferenceRange) {
    surrogateSerializer.serialize(encoder, SubstanceAmountReferenceRangeSurrogate.fromModel(value))
  }
}

public object SubstanceAmountAmountSerializer : KSerializer<SubstanceAmount.Amount> {
  internal val surrogateSerializer: KSerializer<SubstanceAmountAmountSurrogate> by lazy {
    SubstanceAmountAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceAmount.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount.Amount) {
    surrogateSerializer.serialize(encoder, SubstanceAmountAmountSurrogate.fromModel(value))
  }
}

public object SubstanceAmountSerializer : KSerializer<SubstanceAmount> {
  internal val surrogateSerializer: KSerializer<SubstanceAmountSurrogate> by lazy {
    SubstanceAmountSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceAmount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceAmount {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceAmount) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceAmountSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
