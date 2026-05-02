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
import com.google.fhir.model.r5.TestScript
import com.google.fhir.model.r5.surrogates.TestScriptDestinationSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptFixtureSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptMetadataCapabilitySurrogate
import com.google.fhir.model.r5.surrogates.TestScriptMetadataLinkSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptMetadataSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptOriginSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptScopeSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionAssertRequirementLinkSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionAssertRequirementSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionAssertSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionOperationRequestHeaderSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionOperationSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupActionSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSetupSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptTeardownActionSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptTeardownSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptTestActionSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptTestSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptVariableSurrogate
import com.google.fhir.model.r5.surrogates.TestScriptVersionAlgorithmSurrogate
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

public object TestScriptOriginSerializer : KSerializer<TestScript.Origin> {
  internal val surrogateSerializer: KSerializer<TestScriptOriginSurrogate> by lazy {
    TestScriptOriginSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Origin", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Origin =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Origin) {
    surrogateSerializer.serialize(encoder, TestScriptOriginSurrogate.fromModel(value))
  }
}

public object TestScriptDestinationSerializer : KSerializer<TestScript.Destination> {
  internal val surrogateSerializer: KSerializer<TestScriptDestinationSurrogate> by lazy {
    TestScriptDestinationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Destination", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Destination =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Destination) {
    surrogateSerializer.serialize(encoder, TestScriptDestinationSurrogate.fromModel(value))
  }
}

public object TestScriptMetadataSerializer : KSerializer<TestScript.Metadata> {
  internal val surrogateSerializer: KSerializer<TestScriptMetadataSurrogate> by lazy {
    TestScriptMetadataSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Metadata", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata) {
    surrogateSerializer.serialize(encoder, TestScriptMetadataSurrogate.fromModel(value))
  }
}

public object TestScriptMetadataLinkSerializer : KSerializer<TestScript.Metadata.Link> {
  internal val surrogateSerializer: KSerializer<TestScriptMetadataLinkSurrogate> by lazy {
    TestScriptMetadataLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Link) {
    surrogateSerializer.serialize(encoder, TestScriptMetadataLinkSurrogate.fromModel(value))
  }
}

public object TestScriptMetadataCapabilitySerializer : KSerializer<TestScript.Metadata.Capability> {
  internal val surrogateSerializer: KSerializer<TestScriptMetadataCapabilitySurrogate> by lazy {
    TestScriptMetadataCapabilitySurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Capability", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Metadata.Capability =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Metadata.Capability) {
    surrogateSerializer.serialize(encoder, TestScriptMetadataCapabilitySurrogate.fromModel(value))
  }
}

public object TestScriptScopeSerializer : KSerializer<TestScript.Scope> {
  internal val surrogateSerializer: KSerializer<TestScriptScopeSurrogate> by lazy {
    TestScriptScopeSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Scope", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Scope =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Scope) {
    surrogateSerializer.serialize(encoder, TestScriptScopeSurrogate.fromModel(value))
  }
}

public object TestScriptFixtureSerializer : KSerializer<TestScript.Fixture> {
  internal val surrogateSerializer: KSerializer<TestScriptFixtureSurrogate> by lazy {
    TestScriptFixtureSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Fixture", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Fixture =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Fixture) {
    surrogateSerializer.serialize(encoder, TestScriptFixtureSurrogate.fromModel(value))
  }
}

public object TestScriptVariableSerializer : KSerializer<TestScript.Variable> {
  internal val surrogateSerializer: KSerializer<TestScriptVariableSurrogate> by lazy {
    TestScriptVariableSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Variable", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Variable =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Variable) {
    surrogateSerializer.serialize(encoder, TestScriptVariableSurrogate.fromModel(value))
  }
}

public object TestScriptSetupSerializer : KSerializer<TestScript.Setup> {
  internal val surrogateSerializer: KSerializer<TestScriptSetupSurrogate> by lazy {
    TestScriptSetupSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Setup", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup) {
    surrogateSerializer.serialize(encoder, TestScriptSetupSurrogate.fromModel(value))
  }
}

public object TestScriptSetupActionSerializer : KSerializer<TestScript.Setup.Action> {
  internal val surrogateSerializer: KSerializer<TestScriptSetupActionSurrogate> by lazy {
    TestScriptSetupActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action) {
    surrogateSerializer.serialize(encoder, TestScriptSetupActionSurrogate.fromModel(value))
  }
}

public object TestScriptSetupActionOperationSerializer :
  KSerializer<TestScript.Setup.Action.Operation> {
  internal val surrogateSerializer: KSerializer<TestScriptSetupActionOperationSurrogate> by lazy {
    TestScriptSetupActionOperationSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Operation", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Operation) {
    surrogateSerializer.serialize(encoder, TestScriptSetupActionOperationSurrogate.fromModel(value))
  }
}

public object TestScriptSetupActionOperationRequestHeaderSerializer :
  KSerializer<TestScript.Setup.Action.Operation.RequestHeader> {
  internal val surrogateSerializer:
    KSerializer<TestScriptSetupActionOperationRequestHeaderSurrogate> by lazy {
    TestScriptSetupActionOperationRequestHeaderSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("RequestHeader", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Operation.RequestHeader =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Operation.RequestHeader,
  ) {
    surrogateSerializer.serialize(
      encoder,
      TestScriptSetupActionOperationRequestHeaderSurrogate.fromModel(value),
    )
  }
}

public object TestScriptSetupActionAssertSerializer : KSerializer<TestScript.Setup.Action.Assert> {
  internal val surrogateSerializer: KSerializer<TestScriptSetupActionAssertSurrogate> by lazy {
    TestScriptSetupActionAssertSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Assert", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert) {
    surrogateSerializer.serialize(encoder, TestScriptSetupActionAssertSurrogate.fromModel(value))
  }
}

public object TestScriptSetupActionAssertRequirementSerializer :
  KSerializer<TestScript.Setup.Action.Assert.Requirement> {
  internal val surrogateSerializer:
    KSerializer<TestScriptSetupActionAssertRequirementSurrogate> by lazy {
    TestScriptSetupActionAssertRequirementSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("link")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Requirement", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert.Requirement {
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

  override fun serialize(encoder: Encoder, `value`: TestScript.Setup.Action.Assert.Requirement) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestScriptSetupActionAssertRequirementSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}

public object TestScriptTestSerializer : KSerializer<TestScript.Test> {
  internal val surrogateSerializer: KSerializer<TestScriptTestSurrogate> by lazy {
    TestScriptTestSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Test", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Test =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Test) {
    surrogateSerializer.serialize(encoder, TestScriptTestSurrogate.fromModel(value))
  }
}

public object TestScriptTestActionSerializer : KSerializer<TestScript.Test.Action> {
  internal val surrogateSerializer: KSerializer<TestScriptTestActionSurrogate> by lazy {
    TestScriptTestActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Test.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Test.Action) {
    surrogateSerializer.serialize(encoder, TestScriptTestActionSurrogate.fromModel(value))
  }
}

public object TestScriptTeardownSerializer : KSerializer<TestScript.Teardown> {
  internal val surrogateSerializer: KSerializer<TestScriptTeardownSurrogate> by lazy {
    TestScriptTeardownSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Teardown", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Teardown =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown) {
    surrogateSerializer.serialize(encoder, TestScriptTeardownSurrogate.fromModel(value))
  }
}

public object TestScriptTeardownActionSerializer : KSerializer<TestScript.Teardown.Action> {
  internal val surrogateSerializer: KSerializer<TestScriptTeardownActionSurrogate> by lazy {
    TestScriptTeardownActionSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Action", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Teardown.Action =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.Teardown.Action) {
    surrogateSerializer.serialize(encoder, TestScriptTeardownActionSurrogate.fromModel(value))
  }
}

public object TestScriptVersionAlgorithmSerializer : KSerializer<TestScript.VersionAlgorithm> {
  internal val surrogateSerializer: KSerializer<TestScriptVersionAlgorithmSurrogate> by lazy {
    TestScriptVersionAlgorithmSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("VersionAlgorithm", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.VersionAlgorithm =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: TestScript.VersionAlgorithm) {
    surrogateSerializer.serialize(encoder, TestScriptVersionAlgorithmSurrogate.fromModel(value))
  }
}

public object TestScriptSetupActionAssertRequirementLinkSerializer :
  KSerializer<TestScript.Setup.Action.Assert.Requirement.Link> {
  internal val surrogateSerializer:
    KSerializer<TestScriptSetupActionAssertRequirementLinkSurrogate> by lazy {
    TestScriptSetupActionAssertRequirementLinkSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Link", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript.Setup.Action.Assert.Requirement.Link =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(
    encoder: Encoder,
    `value`: TestScript.Setup.Action.Assert.Requirement.Link,
  ) {
    surrogateSerializer.serialize(
      encoder,
      TestScriptSetupActionAssertRequirementLinkSurrogate.fromModel(value),
    )
  }
}

public object TestScriptSerializer : KSerializer<TestScript> {
  internal val surrogateSerializer: KSerializer<TestScriptSurrogate> by lazy {
    TestScriptSurrogate.serializer()
  }

  private val multiChoiceProperties: List<String> = listOf("versionAlgorithm")

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("TestScript", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestScript {
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

  override fun serialize(encoder: Encoder, `value`: TestScript) {
    val jsonEncoder =
      encoder as? JsonEncoder ?: error("This serializer only supports JSON encoding")
    val surrogate = TestScriptSurrogate.fromModel(value)
    val oldJsonObject =
      jsonEncoder.json.encodeToJsonElement(surrogateSerializer, surrogate).jsonObject
    val flattenedJsonObject = FhirJsonTransformer.flatten(oldJsonObject, multiChoiceProperties)
    jsonEncoder.encodeJsonElement(flattenedJsonObject)
  }
}
