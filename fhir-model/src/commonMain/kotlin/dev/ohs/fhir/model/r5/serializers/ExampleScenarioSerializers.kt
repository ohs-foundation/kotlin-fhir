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

import com.google.fhir.model.r5.ExampleScenario
import com.google.fhir.model.r5.FhirJsonTransformer
import com.google.fhir.model.r5.surrogates.ExampleScenarioActorSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioInstanceContainedInstanceSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioInstanceStructureProfileSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioInstanceSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioInstanceVersionSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioProcessStepAlternativeSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioProcessStepOperationSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioProcessStepSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioProcessSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioSurrogate
import com.google.fhir.model.r5.surrogates.ExampleScenarioVersionAlgorithmSurrogate
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

public object ExampleScenarioActorSerializer : KSerializer<ExampleScenario.Actor> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioActorSurrogate> by lazy {
    ExampleScenarioActorSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Actor", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Actor =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Actor) {
    surrogateSerializer.serialize(encoder, ExampleScenarioActorSurrogate.fromModel(value))
  }
}

public object ExampleScenarioInstanceSerializer : KSerializer<ExampleScenario.Instance> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioInstanceSurrogate> by lazy {
    ExampleScenarioInstanceSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("structureProfile")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Instance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance {
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

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExampleScenarioInstanceSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object ExampleScenarioInstanceVersionSerializer :
  KSerializer<ExampleScenario.Instance.Version> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioInstanceVersionSurrogate> by lazy {
    ExampleScenarioInstanceVersionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Version", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.Version =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.Version) {
    surrogateSerializer.serialize(encoder, ExampleScenarioInstanceVersionSurrogate.fromModel(value))
  }
}

public object ExampleScenarioInstanceContainedInstanceSerializer :
  KSerializer<ExampleScenario.Instance.ContainedInstance> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioInstanceContainedInstanceSurrogate> by lazy {
    ExampleScenarioInstanceContainedInstanceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ContainedInstance", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.ContainedInstance =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.ContainedInstance) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioInstanceContainedInstanceSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioProcessSerializer : KSerializer<ExampleScenario.Process> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioProcessSurrogate> by lazy {
    ExampleScenarioProcessSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Process", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process) {
    surrogateSerializer.serialize(encoder, ExampleScenarioProcessSurrogate.fromModel(value))
  }
}

public object ExampleScenarioProcessStepSerializer : KSerializer<ExampleScenario.Process.Step> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioProcessStepSurrogate> by lazy {
    ExampleScenarioProcessStepSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Step", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step) {
    surrogateSerializer.serialize(encoder, ExampleScenarioProcessStepSurrogate.fromModel(value))
  }
}

public object ExampleScenarioProcessStepOperationSerializer :
  KSerializer<ExampleScenario.Process.Step.Operation> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioProcessStepOperationSurrogate> by lazy {
    ExampleScenarioProcessStepOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Operation) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioProcessStepOperationSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioProcessStepAlternativeSerializer :
  KSerializer<ExampleScenario.Process.Step.Alternative> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioProcessStepAlternativeSurrogate> by lazy {
    ExampleScenarioProcessStepAlternativeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Alternative", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Process.Step.Alternative =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Process.Step.Alternative) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioProcessStepAlternativeSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioVersionAlgorithmSerializer :
  KSerializer<ExampleScenario.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioVersionAlgorithmSurrogate> by lazy {
    ExampleScenarioVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.VersionAlgorithm) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioVersionAlgorithmSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioInstanceStructureProfileSerializer :
  KSerializer<ExampleScenario.Instance.StructureProfile> {
  internal val surrogateSerializer:
    KSerializer<ExampleScenarioInstanceStructureProfileSurrogate> by lazy {
    ExampleScenarioInstanceStructureProfileSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("StructureProfile", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario.Instance.StructureProfile =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: ExampleScenario.Instance.StructureProfile) {
    surrogateSerializer.serialize(
      encoder,
      ExampleScenarioInstanceStructureProfileSurrogate.fromModel(value),
    )
  }
}

public object ExampleScenarioSerializer : KSerializer<ExampleScenario> {
  internal val surrogateSerializer: KSerializer<ExampleScenarioSurrogate> by lazy {
    ExampleScenarioSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("ExampleScenario", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): ExampleScenario {
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

  override fun serialize(encoder: Encoder, `value`: ExampleScenario) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = ExampleScenarioSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
