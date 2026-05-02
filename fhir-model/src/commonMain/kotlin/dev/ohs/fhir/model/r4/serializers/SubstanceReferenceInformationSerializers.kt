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
import com.google.fhir.model.r4.SubstanceReferenceInformation
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationClassificationSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationGeneElementSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationGeneSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationTargetAmountSurrogate
import com.google.fhir.model.r4.surrogates.SubstanceReferenceInformationTargetSurrogate
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

public object SubstanceReferenceInformationGeneSerializer :
  KSerializer<SubstanceReferenceInformation.Gene> {
  internal val surrogateSerializer:
    KSerializer<SubstanceReferenceInformationGeneSurrogate> by lazy {
    SubstanceReferenceInformationGeneSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Gene", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Gene =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Gene) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceReferenceInformationGeneSurrogate.fromModel(value),
    )
  }
}

public object SubstanceReferenceInformationGeneElementSerializer :
  KSerializer<SubstanceReferenceInformation.GeneElement> {
  internal val surrogateSerializer:
    KSerializer<SubstanceReferenceInformationGeneElementSurrogate> by lazy {
    SubstanceReferenceInformationGeneElementSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("GeneElement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.GeneElement =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.GeneElement) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceReferenceInformationGeneElementSurrogate.fromModel(value),
    )
  }
}

public object SubstanceReferenceInformationClassificationSerializer :
  KSerializer<SubstanceReferenceInformation.Classification> {
  internal val surrogateSerializer:
    KSerializer<SubstanceReferenceInformationClassificationSurrogate> by lazy {
    SubstanceReferenceInformationClassificationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Classification", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Classification =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Classification) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceReferenceInformationClassificationSurrogate.fromModel(value),
    )
  }
}

public object SubstanceReferenceInformationTargetSerializer :
  KSerializer<SubstanceReferenceInformation.Target> {
  internal val surrogateSerializer:
    KSerializer<SubstanceReferenceInformationTargetSurrogate> by lazy {
    SubstanceReferenceInformationTargetSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("amount")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Target", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Target {
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

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = SubstanceReferenceInformationTargetSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object SubstanceReferenceInformationTargetAmountSerializer :
  KSerializer<SubstanceReferenceInformation.Target.Amount> {
  internal val surrogateSerializer:
    KSerializer<SubstanceReferenceInformationTargetAmountSurrogate> by lazy {
    SubstanceReferenceInformationTargetAmountSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Amount", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation.Target.Amount =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation.Target.Amount) {
    surrogateSerializer.serialize(
      encoder,
      SubstanceReferenceInformationTargetAmountSurrogate.fromModel(value),
    )
  }
}

public object SubstanceReferenceInformationSerializer : KSerializer<SubstanceReferenceInformation> {
  internal val surrogateSerializer: KSerializer<SubstanceReferenceInformationSurrogate> by lazy {
    SubstanceReferenceInformationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SubstanceReferenceInformation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): SubstanceReferenceInformation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: SubstanceReferenceInformation) {
    surrogateSerializer.serialize(encoder, SubstanceReferenceInformationSurrogate.fromModel(value))
  }
}
