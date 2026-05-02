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

import com.google.fhir.model.r4b.Evidence
import com.google.fhir.model.r4b.FhirJsonTransformer
import com.google.fhir.model.r4b.surrogates.EvidenceCertaintySurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceCiteAsSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceStatisticAttributeEstimateSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceStatisticModelCharacteristicSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceStatisticModelCharacteristicVariableSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceStatisticSampleSizeSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceStatisticSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceSurrogate
import com.google.fhir.model.r4b.surrogates.EvidenceVariableDefinitionSurrogate
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

public object EvidenceVariableDefinitionSerializer : KSerializer<Evidence.VariableDefinition> {
  internal val surrogateSerializer: KSerializer<EvidenceVariableDefinitionSurrogate> by lazy {
    EvidenceVariableDefinitionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VariableDefinition", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.VariableDefinition =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.VariableDefinition) {
    surrogateSerializer.serialize(encoder, EvidenceVariableDefinitionSurrogate.fromModel(value))
  }
}

public object EvidenceStatisticSerializer : KSerializer<Evidence.Statistic> {
  internal val surrogateSerializer: KSerializer<EvidenceStatisticSurrogate> by lazy {
    EvidenceStatisticSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Statistic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Statistic =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic) {
    surrogateSerializer.serialize(encoder, EvidenceStatisticSurrogate.fromModel(value))
  }
}

public object EvidenceStatisticSampleSizeSerializer : KSerializer<Evidence.Statistic.SampleSize> {
  internal val surrogateSerializer: KSerializer<EvidenceStatisticSampleSizeSurrogate> by lazy {
    EvidenceStatisticSampleSizeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SampleSize", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.SampleSize =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.SampleSize) {
    surrogateSerializer.serialize(encoder, EvidenceStatisticSampleSizeSurrogate.fromModel(value))
  }
}

public object EvidenceStatisticAttributeEstimateSerializer :
  KSerializer<Evidence.Statistic.AttributeEstimate> {
  internal val surrogateSerializer:
    KSerializer<EvidenceStatisticAttributeEstimateSurrogate> by lazy {
    EvidenceStatisticAttributeEstimateSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("AttributeEstimate", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.AttributeEstimate =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.AttributeEstimate) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceStatisticAttributeEstimateSurrogate.fromModel(value),
    )
  }
}

public object EvidenceStatisticModelCharacteristicSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic> {
  internal val surrogateSerializer:
    KSerializer<EvidenceStatisticModelCharacteristicSurrogate> by lazy {
    EvidenceStatisticModelCharacteristicSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ModelCharacteristic", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.Statistic.ModelCharacteristic) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceStatisticModelCharacteristicSurrogate.fromModel(value),
    )
  }
}

public object EvidenceStatisticModelCharacteristicVariableSerializer :
  KSerializer<Evidence.Statistic.ModelCharacteristic.Variable> {
  internal val surrogateSerializer:
    KSerializer<EvidenceStatisticModelCharacteristicVariableSurrogate> by lazy {
    EvidenceStatisticModelCharacteristicVariableSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Variable", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Statistic.ModelCharacteristic.Variable =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: Evidence.Statistic.ModelCharacteristic.Variable,
  ) {
    surrogateSerializer.serialize(
      encoder,
      EvidenceStatisticModelCharacteristicVariableSurrogate.fromModel(value),
    )
  }
}

public object EvidenceCertaintySerializer : KSerializer<Evidence.Certainty> {
  internal val surrogateSerializer: KSerializer<EvidenceCertaintySurrogate> by lazy {
    EvidenceCertaintySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Certainty", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.Certainty =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.Certainty) {
    surrogateSerializer.serialize(encoder, EvidenceCertaintySurrogate.fromModel(value))
  }
}

public object EvidenceCiteAsSerializer : KSerializer<Evidence.CiteAs> {
  internal val surrogateSerializer: KSerializer<EvidenceCiteAsSurrogate> by lazy {
    EvidenceCiteAsSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("CiteAs", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence.CiteAs =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Evidence.CiteAs) {
    surrogateSerializer.serialize(encoder, EvidenceCiteAsSurrogate.fromModel(value))
  }
}

public object EvidenceSerializer : KSerializer<Evidence> {
  internal val surrogateSerializer: KSerializer<EvidenceSurrogate> by lazy {
    EvidenceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("citeAs")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Evidence", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Evidence {
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

  override fun serialize(encoder: Encoder, `value`: Evidence) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = EvidenceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
