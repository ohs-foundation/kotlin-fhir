/*
 * Copyright 2026 Open Health Stack Foundation
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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)
@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.TestReport
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.TestReportActionResult
import dev.ohs.fhir.model.r5.terminologies.TestReportParticipantType
import dev.ohs.fhir.model.r5.terminologies.TestReportResult
import dev.ohs.fhir.model.r5.terminologies.TestReportStatus
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object TestReportParticipantSerializer : FhirSerializer<TestReport.Participant> {
  override val descriptor: SerialDescriptor = buildDescriptor("Participant", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Participant>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("type")
    b.strPrim("uri")
    b.strPrim("display")
  }

  override fun deserialize(decoder: Decoder): TestReport.Participant {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: TestReportParticipantType? = null
    var _type: Element? = null
    var uri: KotlinString? = null
    var _uri: Element? = null
    var display: KotlinString? = null
    var _display: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          type =
            TestReportParticipantType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> uri = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _uri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> display = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _display =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Participant(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(Enumeration.of(type, _type), "TestReport.Participant", "type"),
      uri = required(Uri.of(uri, _uri), "TestReport.Participant", "uri"),
      display = R5String.of(display, _display),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Participant) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.uri.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.uri)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.display?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.display)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSetupSerializer : FhirSerializer<TestReport.Setup> {
  override val descriptor: SerialDescriptor = buildDescriptor("Setup", this)

  @JvmField internal val listSerializer: KSerializer<List<TestReport.Setup>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("action", TestReportSetupActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Setup.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Setup(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TestReportSetupActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSetupActionSerializer : FhirSerializer<TestReport.Setup.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Setup.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
    b.optionalElement("assert", TestReportSetupActionAssertSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionOperationSerializer,
              null,
            )
        4 ->
          assert =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionAssertSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Setup.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      TestReportSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      TestReportSetupActionAssertSerializer,
      value.assert,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSetupActionOperationSerializer :
  FhirSerializer<TestReport.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor = buildDescriptor("Operation", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Setup.Action.Operation>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("result")
    b.strPrim("message")
    b.strPrim("detail")
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Operation {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var result: TestReportActionResult? = null
    var _result: Element? = null
    var message: KotlinString? = null
    var _message: Element? = null
    var detail: KotlinString? = null
    var _detail: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          result =
            TestReportActionResult.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _result =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> message = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _message =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> detail = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Setup.Action.Operation(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      result =
        required(Enumeration.of(result, _result), "TestReport.Setup.Action.Operation", "result"),
      message = Markdown.of(message, _message),
      detail = Uri.of(detail, _detail),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Operation) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.result.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.result)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.message?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.message)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.detail?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.detail)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSetupActionAssertSerializer :
  FhirSerializer<TestReport.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor = buildDescriptor("Assert", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Setup.Action.Assert>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("result")
    b.strPrim("message")
    b.strPrim("detail")
    b.optionalElement(
      "requirement",
      TestReportSetupActionAssertRequirementSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var result: TestReportActionResult? = null
    var _result: Element? = null
    var message: KotlinString? = null
    var _message: Element? = null
    var detail: KotlinString? = null
    var _detail: Element? = null
    var requirement: List<TestReport.Setup.Action.Assert.Requirement>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          result =
            TestReportActionResult.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        4 ->
          _result =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> message = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _message =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> detail = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _detail =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          requirement =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionAssertRequirementSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Setup.Action.Assert(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      result =
        required(Enumeration.of(result, _result), "TestReport.Setup.Action.Assert", "result"),
      message = Markdown.of(message, _message),
      detail = R5String.of(detail, _detail),
      requirement = listOrEmpty(requirement),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.result.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.result)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.message?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.message)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.detail?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.detail)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      TestReportSetupActionAssertRequirementSerializer.listSerializer,
      value.requirement,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSetupActionAssertRequirementSerializer :
  FhirSerializer<TestReport.Setup.Action.Assert.Requirement> {
  override val descriptor: SerialDescriptor = buildDescriptor("Requirement", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Setup.Action.Assert.Requirement>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkUri")
    b.strPrim("linkCanonical")
  }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert.Requirement {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkUri: KotlinString? = null
    var _linkUri: Element? = null
    var linkCanonical: KotlinString? = null
    var _linkCanonical: Element? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> linkUri = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> linkCanonical = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _linkCanonical =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Setup.Action.Assert.Requirement(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      link =
        TestReport.Setup.Action.Assert.Requirement.Link.from(
          Uri.of(linkUri, _linkUri),
          Canonical.of(linkCanonical, _linkCanonical),
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert.Requirement) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    when (val choice = value.link) {
      null -> {}
      is TestReport.Setup.Action.Assert.Requirement.Link.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is TestReport.Setup.Action.Assert.Requirement.Link.Canonical -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportTestSerializer : FhirSerializer<TestReport.Test> {
  override val descriptor: SerialDescriptor = buildDescriptor("Test", this)

  @JvmField internal val listSerializer: KSerializer<List<TestReport.Test>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("description")
    b.optionalElement("action", TestReportTestActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Test {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestReport.Test.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTestActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Test(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      TestReportTestActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportTestActionSerializer : FhirSerializer<TestReport.Test.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Test.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
    b.optionalElement("assert", TestReportSetupActionAssertSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Test.Action {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionOperationSerializer,
              null,
            )
        4 ->
          assert =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionAssertSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Test.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = operation,
      assert = assert,
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      TestReportSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      TestReportSetupActionAssertSerializer,
      value.assert,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportTeardownSerializer : FhirSerializer<TestReport.Teardown> {
  override val descriptor: SerialDescriptor = buildDescriptor("Teardown", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Teardown>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("action", TestReportTeardownActionSerializer.listSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Teardown {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Teardown.Action>? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          action =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTeardownActionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Teardown(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      action = listOrEmpty(action),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      3,
      TestReportTeardownActionSerializer.listSerializer,
      value.action,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportTeardownActionSerializer : FhirSerializer<TestReport.Teardown.Action> {
  override val descriptor: SerialDescriptor = buildDescriptor("Action", this)

  @JvmField
  internal val listSerializer: KSerializer<List<TestReport.Teardown.Action>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): TestReport.Teardown.Action {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    while (true) {
      when (val i = compositeDecoder.decodeElementIndex(descriptor)) {
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 ->
          operation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupActionOperationSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return TestReport.Teardown.Action(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      operation = required(operation, "TestReport.Teardown.Action", "operation"),
    )
  }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown.Action) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      TestReportSetupActionOperationSerializer,
      value.operation,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object TestReportSerializer : FhirResourceSerializer<TestReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TestReport")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("status")
    b.strPrim("testScript")
    b.strPrim("result")
    b.prim("score", FhirDecimalSerializer.descriptor)
    b.strPrim("tester")
    b.strPrim("issued")
    b.optionalElement("participant", TestReportParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("setup", TestReportSetupSerializer.descriptor)
    b.optionalElement("test", TestReportTestSerializer.listSerializer.descriptor)
    b.optionalElement("teardown", TestReportTeardownSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): TestReport {
    var id: KotlinString? = null
    var meta: Meta? = null
    var implicitRules: KotlinString? = null
    var _implicitRules: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var text: Narrative? = null
    var contained: List<Resource>? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var status: TestReportStatus? = null
    var _status: Element? = null
    var testScript: KotlinString? = null
    var _testScript: Element? = null
    var result: TestReportResult? = null
    var _result: Element? = null
    var score: FhirDecimal? = null
    var _score: Element? = null
    var tester: KotlinString? = null
    var _tester: Element? = null
    var issued: FhirDateTime? = null
    var _issued: Element? = null
    var participant: List<TestReport.Participant>? = null
    var setup: TestReport.Setup? = null
    var test: List<TestReport.Test>? = null
    var teardown: TestReport.Teardown? = null
    while (true) {
      val i = compositeDecoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> compositeDecoder.decodeStringElement(descriptor, i)
        0 -> id = compositeDecoder.decodeStringElement(descriptor, i)
        1 ->
          meta =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = compositeDecoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        4 -> language = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              NarrativeSerializer,
              null,
            )
        7 ->
          contained =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer,
              null,
            )
        11 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          status = TestReportStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> testScript = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _testScript =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          result = TestReportResult.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _result =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        20 ->
          _score =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> tester = compositeDecoder.decodeStringElement(descriptor, i)
        22 ->
          _tester =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> issued = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        24 ->
          _issued =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 ->
          participant =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportParticipantSerializer.listSerializer,
              null,
            )
        26 ->
          setup =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupSerializer,
              null,
            )
        27 ->
          test =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTestSerializer.listSerializer,
              null,
            )
        28 ->
          teardown =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTeardownSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return TestReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = identifier,
      name = R5String.of(name, _name),
      status = required(Enumeration.of(status, _status), "TestReport", "status"),
      testScript = required(Canonical.of(testScript, _testScript), "TestReport", "testScript"),
      result = required(Enumeration.of(result, _result), "TestReport", "result"),
      score = Decimal.of(score, _score),
      tester = R5String.of(tester, _tester),
      issued = DateTime.of(issued, _issued),
      participant = listOrEmpty(participant),
      setup = setup,
      test = listOrEmpty(test),
      teardown = teardown,
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestReport,
  ) {
    compositeEncoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      2 + descriptorOffset,
      value.implicitRules?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.testScript.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.testScript)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      17 + descriptorOffset,
      value.result.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, value.result)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      FhirDecimalSerializer,
      value.score?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.score)
    compositeEncoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.tester?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.tester)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      23 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.issued)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      25 + descriptorOffset,
      TestReportParticipantSerializer.listSerializer,
      value.participant,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      26 + descriptorOffset,
      TestReportSetupSerializer,
      value.setup,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      27 + descriptorOffset,
      TestReportTestSerializer.listSerializer,
      value.test,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      28 + descriptorOffset,
      TestReportTeardownSerializer,
      value.teardown,
    )
  }
}
