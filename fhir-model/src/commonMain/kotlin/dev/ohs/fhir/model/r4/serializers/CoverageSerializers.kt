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

import com.google.fhir.model.r4.Coverage
import com.google.fhir.model.r4.FhirJsonTransformer
import com.google.fhir.model.r4.surrogates.CoverageClassSurrogate
import com.google.fhir.model.r4.surrogates.CoverageCostToBeneficiaryExceptionSurrogate
import com.google.fhir.model.r4.surrogates.CoverageCostToBeneficiarySurrogate
import com.google.fhir.model.r4.surrogates.CoverageCostToBeneficiaryValueSurrogate
import com.google.fhir.model.r4.surrogates.CoverageSurrogate
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

public object CoverageClassSerializer : KSerializer<Coverage.Class> {
  internal val surrogateSerializer: KSerializer<CoverageClassSurrogate> by lazy {
    CoverageClassSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Class", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Coverage.Class =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Coverage.Class) {
    surrogateSerializer.serialize(encoder, CoverageClassSurrogate.fromModel(value))
  }
}

public object CoverageCostToBeneficiarySerializer : KSerializer<Coverage.CostToBeneficiary> {
  internal val surrogateSerializer: KSerializer<CoverageCostToBeneficiarySurrogate> by lazy {
    CoverageCostToBeneficiarySurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CostToBeneficiary", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary {
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

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = CoverageCostToBeneficiarySurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object CoverageCostToBeneficiaryExceptionSerializer :
  KSerializer<Coverage.CostToBeneficiary.Exception> {
  internal val surrogateSerializer:
    KSerializer<CoverageCostToBeneficiaryExceptionSurrogate> by lazy {
    CoverageCostToBeneficiaryExceptionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Exception", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Exception =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Exception) {
    surrogateSerializer.serialize(
      encoder,
      CoverageCostToBeneficiaryExceptionSurrogate.fromModel(value),
    )
  }
}

public object CoverageCostToBeneficiaryValueSerializer :
  KSerializer<Coverage.CostToBeneficiary.Value> {
  internal val surrogateSerializer: KSerializer<CoverageCostToBeneficiaryValueSurrogate> by lazy {
    CoverageCostToBeneficiaryValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Value) {
    surrogateSerializer.serialize(encoder, CoverageCostToBeneficiaryValueSurrogate.fromModel(value))
  }
}

public object CoverageSerializer : KSerializer<Coverage> {
  internal val surrogateSerializer: KSerializer<CoverageSurrogate> by lazy {
    CoverageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Coverage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Coverage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Coverage) {
    surrogateSerializer.serialize(encoder, CoverageSurrogate.fromModel(value))
  }
}
