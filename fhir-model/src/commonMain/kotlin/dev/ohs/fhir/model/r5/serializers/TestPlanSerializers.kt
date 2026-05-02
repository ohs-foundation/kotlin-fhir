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
import com.google.fhir.model.r5.TestPlan
import com.google.fhir.model.r5.surrogates.TestPlanDependencySurrogate
import com.google.fhir.model.r5.surrogates.TestPlanSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseAssertionSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseDependencySurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseTestDataSourceSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseTestDataSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseTestRunScriptSourceSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseTestRunScriptSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanTestCaseTestRunSurrogate
import com.google.fhir.model.r5.surrogates.TestPlanVersionAlgorithmSurrogate
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

public object TestPlanDependencySerializer : KSerializer<TestPlan.Dependency> {
  internal val surrogateSerializer: KSerializer<TestPlanDependencySurrogate> by lazy {
    TestPlanDependencySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Dependency", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.Dependency =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.Dependency) {
    surrogateSerializer.serialize(encoder, TestPlanDependencySurrogate.fromModel(value))
  }
}

public object TestPlanTestCaseSerializer : KSerializer<TestPlan.TestCase> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseSurrogate> by lazy {
    TestPlanTestCaseSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestCase", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase) {
    surrogateSerializer.serialize(encoder, TestPlanTestCaseSurrogate.fromModel(value))
  }
}

public object TestPlanTestCaseDependencySerializer : KSerializer<TestPlan.TestCase.Dependency> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseDependencySurrogate> by lazy {
    TestPlanTestCaseDependencySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Dependency", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Dependency =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Dependency) {
    surrogateSerializer.serialize(encoder, TestPlanTestCaseDependencySurrogate.fromModel(value))
  }
}

public object TestPlanTestCaseTestRunSerializer : KSerializer<TestPlan.TestCase.TestRun> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseTestRunSurrogate> by lazy {
    TestPlanTestCaseTestRunSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestRun", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun) {
    surrogateSerializer.serialize(encoder, TestPlanTestCaseTestRunSurrogate.fromModel(value))
  }
}

public object TestPlanTestCaseTestRunScriptSerializer :
  KSerializer<TestPlan.TestCase.TestRun.Script> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseTestRunScriptSurrogate> by lazy {
    TestPlanTestCaseTestRunScriptSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("source")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Script", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun.Script {
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

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun.Script) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestPlanTestCaseTestRunScriptSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TestPlanTestCaseTestDataSerializer : KSerializer<TestPlan.TestCase.TestData> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseTestDataSurrogate> by lazy {
    TestPlanTestCaseTestDataSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("source")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestData", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestData {
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

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestData) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestPlanTestCaseTestDataSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TestPlanTestCaseAssertionSerializer : KSerializer<TestPlan.TestCase.Assertion> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseAssertionSurrogate> by lazy {
    TestPlanTestCaseAssertionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Assertion", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.Assertion =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.Assertion) {
    surrogateSerializer.serialize(encoder, TestPlanTestCaseAssertionSurrogate.fromModel(value))
  }
}

public object TestPlanVersionAlgorithmSerializer : KSerializer<TestPlan.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<TestPlanVersionAlgorithmSurrogate> by lazy {
    TestPlanVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, TestPlanVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object TestPlanTestCaseTestRunScriptSourceSerializer :
  KSerializer<TestPlan.TestCase.TestRun.Script.Source> {
  internal val surrogateSerializer:
    KSerializer<TestPlanTestCaseTestRunScriptSourceSurrogate> by lazy {
    TestPlanTestCaseTestRunScriptSourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Source", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestRun.Script.Source =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestRun.Script.Source) {
    surrogateSerializer.serialize(
      encoder,
      TestPlanTestCaseTestRunScriptSourceSurrogate.fromModel(value),
    )
  }
}

public object TestPlanTestCaseTestDataSourceSerializer :
  KSerializer<TestPlan.TestCase.TestData.Source> {
  internal val surrogateSerializer: KSerializer<TestPlanTestCaseTestDataSourceSurrogate> by lazy {
    TestPlanTestCaseTestDataSourceSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Source", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan.TestCase.TestData.Source =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestPlan.TestCase.TestData.Source) {
    surrogateSerializer.serialize(encoder, TestPlanTestCaseTestDataSourceSurrogate.fromModel(value))
  }
}

public object TestPlanSerializer : KSerializer<TestPlan> {
  internal val surrogateSerializer: KSerializer<TestPlanSurrogate> by lazy {
    TestPlanSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestPlan", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestPlan {
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

  override fun serialize(encoder: Encoder, `value`: TestPlan) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestPlanSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
