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

import com.google.fhir.model.r4b.ClinicalImpression
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.ClinicalImpressionEffectiveSurrogate
import com.google.fhir.model.r4b.surrogates.ClinicalImpressionFindingSurrogate
import com.google.fhir.model.r4b.surrogates.ClinicalImpressionInvestigationSurrogate
import com.google.fhir.model.r4b.surrogates.ClinicalImpressionSurrogate
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

public object ClinicalImpressionInvestigationSerializer :
  KSerializer<ClinicalImpression.Investigation> {
  internal val surrogateSerializer: KSerializer<ClinicalImpressionInvestigationSurrogate> by lazy {
    ClinicalImpressionInvestigationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Investigation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Investigation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Investigation) {
    surrogateSerializer.serialize(
      encoder,
      ClinicalImpressionInvestigationSurrogate.fromModel(value),
    )
  }
}

public object ClinicalImpressionFindingSerializer : KSerializer<ClinicalImpression.Finding> {
  internal val surrogateSerializer: KSerializer<ClinicalImpressionFindingSurrogate> by lazy {
    ClinicalImpressionFindingSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Finding", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Finding =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Finding) {
    surrogateSerializer.serialize(encoder, ClinicalImpressionFindingSurrogate.fromModel(value))
  }
}

public object ClinicalImpressionEffectiveSerializer : KSerializer<ClinicalImpression.Effective> {
  internal val surrogateSerializer: KSerializer<ClinicalImpressionEffectiveSurrogate> by lazy {
    ClinicalImpressionEffectiveSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Effective", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression.Effective =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression.Effective) {
    surrogateSerializer.serialize(encoder, ClinicalImpressionEffectiveSurrogate.fromModel(value))
  }
}

public object ClinicalImpressionSerializer : KSerializer<ClinicalImpression> {
  internal val surrogateSerializer: KSerializer<ClinicalImpressionSurrogate> by lazy {
    ClinicalImpressionSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("effective")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ClinicalImpression", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ClinicalImpression {
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

  override fun serialize(encoder: Encoder, `value`: ClinicalImpression) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ClinicalImpressionSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
