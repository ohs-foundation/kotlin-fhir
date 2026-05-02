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
import com.google.fhir.model.r5.MeasureReport
import com.google.fhir.model.r5.surrogates.MeasureReportGroupMeasureScoreSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupPopulationSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumComponentSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumComponentValueSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumMeasureScoreSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumPopulationSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierStratumValueSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupStratifierSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportGroupSurrogate
import com.google.fhir.model.r5.surrogates.MeasureReportSurrogate
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

public object MeasureReportGroupSerializer : KSerializer<MeasureReport.Group> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupSurrogate> by lazy {
    MeasureReportGroupSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("measureScore")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Group", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group {
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

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MeasureReportGroupSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MeasureReportGroupPopulationSerializer : KSerializer<MeasureReport.Group.Population> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupPopulationSurrogate> by lazy {
    MeasureReportGroupPopulationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Population", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Population =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Population) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupPopulationSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupStratifierSerializer : KSerializer<MeasureReport.Group.Stratifier> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupStratifierSurrogate> by lazy {
    MeasureReportGroupStratifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stratifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupStratifierSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupStratifierStratumSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumSurrogate> by lazy {
    MeasureReportGroupStratifierStratumSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value", "measureScore")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stratum", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum {
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

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MeasureReportGroupStratifierStratumSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MeasureReportGroupStratifierStratumComponentSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumComponentSurrogate> by lazy {
    MeasureReportGroupStratifierStratumComponentSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("value")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Component {
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

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component,
  ) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MeasureReportGroupStratifierStratumComponentSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MeasureReportGroupStratifierStratumPopulationSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Population> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumPopulationSurrogate> by lazy {
    MeasureReportGroupStratifierStratumPopulationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Population", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Population =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Population,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumPopulationSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportGroupMeasureScoreSerializer :
  KSerializer<MeasureReport.Group.MeasureScore> {
  internal val surrogateSerializer: KSerializer<MeasureReportGroupMeasureScoreSurrogate> by lazy {
    MeasureReportGroupMeasureScoreSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MeasureScore", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.MeasureScore =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.MeasureScore) {
    surrogateSerializer.serialize(encoder, MeasureReportGroupMeasureScoreSurrogate.fromModel(value))
  }
}

public object MeasureReportGroupStratifierStratumValueSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Value> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumValueSurrogate> by lazy {
    MeasureReportGroupStratifierStratumValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport.Group.Stratifier.Stratum.Value) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumValueSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportGroupStratifierStratumComponentValueSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.Component.Value> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumComponentValueSurrogate> by lazy {
    MeasureReportGroupStratifierStratumComponentValueSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Value", surrogateSerializer.descriptor)
  }

  override fun deserialize(
    decoder: Decoder
  ): MeasureReport.Group.Stratifier.Stratum.Component.Value =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.Component.Value,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumComponentValueSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportGroupStratifierStratumMeasureScoreSerializer :
  KSerializer<MeasureReport.Group.Stratifier.Stratum.MeasureScore> {
  internal val surrogateSerializer:
    KSerializer<MeasureReportGroupStratifierStratumMeasureScoreSurrogate> by lazy {
    MeasureReportGroupStratifierStratumMeasureScoreSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MeasureScore", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport.Group.Stratifier.Stratum.MeasureScore =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: MeasureReport.Group.Stratifier.Stratum.MeasureScore,
  ) {
    surrogateSerializer.serialize(
      encoder,
      MeasureReportGroupStratifierStratumMeasureScoreSurrogate.fromModel(value),
    )
  }
}

public object MeasureReportSerializer : KSerializer<MeasureReport> {
  internal val surrogateSerializer: KSerializer<MeasureReportSurrogate> by lazy {
    MeasureReportSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("MeasureReport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MeasureReport =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: MeasureReport) {
    surrogateSerializer.serialize(encoder, MeasureReportSurrogate.fromModel(value))
  }
}
