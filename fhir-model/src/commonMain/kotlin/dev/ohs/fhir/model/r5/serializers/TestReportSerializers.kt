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
import com.google.fhir.model.r5.TestReport
import com.google.fhir.model.r5.surrogates.TestReportParticipantSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupActionAssertRequirementLinkSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupActionAssertRequirementSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupActionAssertSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupActionOperationSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupActionSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSetupSurrogate
import com.google.fhir.model.r5.surrogates.TestReportSurrogate
import com.google.fhir.model.r5.surrogates.TestReportTeardownActionSurrogate
import com.google.fhir.model.r5.surrogates.TestReportTeardownSurrogate
import com.google.fhir.model.r5.surrogates.TestReportTestActionSurrogate
import com.google.fhir.model.r5.surrogates.TestReportTestSurrogate
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

public object TestReportParticipantSerializer : KSerializer<TestReport.Participant> {
  internal val surrogateSerializer: KSerializer<TestReportParticipantSurrogate> by lazy {
    TestReportParticipantSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Participant", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Participant =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Participant) {
    surrogateSerializer.serialize(encoder, TestReportParticipantSurrogate.fromModel(value))
  }
}

public object TestReportSetupSerializer : KSerializer<TestReport.Setup> {
  internal val surrogateSerializer: KSerializer<TestReportSetupSurrogate> by lazy {
    TestReportSetupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Setup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup) {
    surrogateSerializer.serialize(encoder, TestReportSetupSurrogate.fromModel(value))
  }
}

public object TestReportSetupActionSerializer : KSerializer<TestReport.Setup.Action> {
  internal val surrogateSerializer: KSerializer<TestReportSetupActionSurrogate> by lazy {
    TestReportSetupActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action) {
    surrogateSerializer.serialize(encoder, TestReportSetupActionSurrogate.fromModel(value))
  }
}

public object TestReportSetupActionOperationSerializer :
  KSerializer<TestReport.Setup.Action.Operation> {
  internal val surrogateSerializer: KSerializer<TestReportSetupActionOperationSurrogate> by lazy {
    TestReportSetupActionOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Operation) {
    surrogateSerializer.serialize(encoder, TestReportSetupActionOperationSurrogate.fromModel(value))
  }
}

public object TestReportSetupActionAssertSerializer : KSerializer<TestReport.Setup.Action.Assert> {
  internal val surrogateSerializer: KSerializer<TestReportSetupActionAssertSurrogate> by lazy {
    TestReportSetupActionAssertSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Assert", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert) {
    surrogateSerializer.serialize(encoder, TestReportSetupActionAssertSurrogate.fromModel(value))
  }
}

public object TestReportSetupActionAssertRequirementSerializer :
  KSerializer<TestReport.Setup.Action.Assert.Requirement> {
  internal val surrogateSerializer:
    KSerializer<TestReportSetupActionAssertRequirementSurrogate> by lazy {
    TestReportSetupActionAssertRequirementSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("link")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Requirement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert.Requirement {
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

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert.Requirement) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestReportSetupActionAssertRequirementSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TestReportTestSerializer : KSerializer<TestReport.Test> {
  internal val surrogateSerializer: KSerializer<TestReportTestSurrogate> by lazy {
    TestReportTestSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Test", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Test =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Test) {
    surrogateSerializer.serialize(encoder, TestReportTestSurrogate.fromModel(value))
  }
}

public object TestReportTestActionSerializer : KSerializer<TestReport.Test.Action> {
  internal val surrogateSerializer: KSerializer<TestReportTestActionSurrogate> by lazy {
    TestReportTestActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Test.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Test.Action) {
    surrogateSerializer.serialize(encoder, TestReportTestActionSurrogate.fromModel(value))
  }
}

public object TestReportTeardownSerializer : KSerializer<TestReport.Teardown> {
  internal val surrogateSerializer: KSerializer<TestReportTeardownSurrogate> by lazy {
    TestReportTeardownSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Teardown", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Teardown =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown) {
    surrogateSerializer.serialize(encoder, TestReportTeardownSurrogate.fromModel(value))
  }
}

public object TestReportTeardownActionSerializer : KSerializer<TestReport.Teardown.Action> {
  internal val surrogateSerializer: KSerializer<TestReportTeardownActionSurrogate> by lazy {
    TestReportTeardownActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Teardown.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown.Action) {
    surrogateSerializer.serialize(encoder, TestReportTeardownActionSurrogate.fromModel(value))
  }
}

public object TestReportSetupActionAssertRequirementLinkSerializer :
  KSerializer<TestReport.Setup.Action.Assert.Requirement.Link> {
  internal val surrogateSerializer:
    KSerializer<TestReportSetupActionAssertRequirementLinkSurrogate> by lazy {
    TestReportSetupActionAssertRequirementLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert.Requirement.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: TestReport.Setup.Action.Assert.Requirement.Link,
  ) {
    surrogateSerializer.serialize(
      encoder,
      TestReportSetupActionAssertRequirementLinkSurrogate.fromModel(value),
    )
  }
}

public object TestReportSerializer : KSerializer<TestReport> {
  internal val surrogateSerializer: KSerializer<TestReportSurrogate> by lazy {
    TestReportSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestReport", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestReport) {
    surrogateSerializer.serialize(encoder, TestReportSurrogate.fromModel(value))
  }
}
