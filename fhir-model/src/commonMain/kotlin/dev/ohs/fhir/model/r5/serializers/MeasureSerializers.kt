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
import com.google.fhir.model.r5.Measure
import com.google.fhir.model.r5.surrogates.MeasureGroupPopulationSurrogate
import com.google.fhir.model.r5.surrogates.MeasureGroupStratifierComponentSurrogate
import com.google.fhir.model.r5.surrogates.MeasureGroupStratifierSurrogate
import com.google.fhir.model.r5.surrogates.MeasureGroupSubjectSurrogate
import com.google.fhir.model.r5.surrogates.MeasureGroupSurrogate
import com.google.fhir.model.r5.surrogates.MeasureSubjectSurrogate
import com.google.fhir.model.r5.surrogates.MeasureSupplementalDataSurrogate
import com.google.fhir.model.r5.surrogates.MeasureSurrogate
import com.google.fhir.model.r5.surrogates.MeasureTermSurrogate
import com.google.fhir.model.r5.surrogates.MeasureVersionAlgorithmSurrogate
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

public object MeasureTermSerializer : KSerializer<Measure.Term> {
  internal val surrogateSerializer: KSerializer<MeasureTermSurrogate> by lazy {
    MeasureTermSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Term", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Term =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Term) {
    surrogateSerializer.serialize(encoder, MeasureTermSurrogate.fromModel(value))
  }
}

public object MeasureGroupSerializer : KSerializer<Measure.Group> {
  internal val surrogateSerializer: KSerializer<MeasureGroupSurrogate> by lazy {
    MeasureGroupSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("subject")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Group", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Group {
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

  override fun serialize(encoder: Encoder, `value`: Measure.Group) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MeasureGroupSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object MeasureGroupPopulationSerializer : KSerializer<Measure.Group.Population> {
  internal val surrogateSerializer: KSerializer<MeasureGroupPopulationSurrogate> by lazy {
    MeasureGroupPopulationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Population", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Group.Population =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Population) {
    surrogateSerializer.serialize(encoder, MeasureGroupPopulationSurrogate.fromModel(value))
  }
}

public object MeasureGroupStratifierSerializer : KSerializer<Measure.Group.Stratifier> {
  internal val surrogateSerializer: KSerializer<MeasureGroupStratifierSurrogate> by lazy {
    MeasureGroupStratifierSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Stratifier", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier) {
    surrogateSerializer.serialize(encoder, MeasureGroupStratifierSurrogate.fromModel(value))
  }
}

public object MeasureGroupStratifierComponentSerializer :
  KSerializer<Measure.Group.Stratifier.Component> {
  internal val surrogateSerializer: KSerializer<MeasureGroupStratifierComponentSurrogate> by lazy {
    MeasureGroupStratifierComponentSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Component", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Group.Stratifier.Component =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Stratifier.Component) {
    surrogateSerializer.serialize(
      encoder,
      MeasureGroupStratifierComponentSurrogate.fromModel(value),
    )
  }
}

public object MeasureSupplementalDataSerializer : KSerializer<Measure.SupplementalData> {
  internal val surrogateSerializer: KSerializer<MeasureSupplementalDataSurrogate> by lazy {
    MeasureSupplementalDataSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SupplementalData", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.SupplementalData =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.SupplementalData) {
    surrogateSerializer.serialize(encoder, MeasureSupplementalDataSurrogate.fromModel(value))
  }
}

public object MeasureVersionAlgorithmSerializer : KSerializer<Measure.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<MeasureVersionAlgorithmSurrogate> by lazy {
    MeasureVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, MeasureVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object MeasureSubjectSerializer : KSerializer<Measure.Subject> {
  internal val surrogateSerializer: KSerializer<MeasureSubjectSurrogate> by lazy {
    MeasureSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Subject) {
    surrogateSerializer.serialize(encoder, MeasureSubjectSurrogate.fromModel(value))
  }
}

public object MeasureGroupSubjectSerializer : KSerializer<Measure.Group.Subject> {
  internal val surrogateSerializer: KSerializer<MeasureGroupSubjectSurrogate> by lazy {
    MeasureGroupSubjectSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Subject", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure.Group.Subject =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: Measure.Group.Subject) {
    surrogateSerializer.serialize(encoder, MeasureGroupSubjectSurrogate.fromModel(value))
  }
}

public object MeasureSerializer : KSerializer<Measure> {
  internal val surrogateSerializer: KSerializer<MeasureSurrogate> by lazy {
    MeasureSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm", "subject")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Measure", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Measure {
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

  override fun serialize(encoder: Encoder, `value`: Measure) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = MeasureSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
