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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.FhirDecimal
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.TestReport
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object TestReportParticipantSerializer : KSerializer<TestReport.Participant> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Participant") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("uri", KotlinString.serializer().descriptor)
      optionalElement("_uri", ElementSerializer.descriptor)
      optionalElement("display", KotlinString.serializer().descriptor)
      optionalElement("_display", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Participant>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Participant =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var uri: KotlinString? = null
      var _uri: Element? = null
      var display: KotlinString? = null
      var _display: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> uri = decodeStringElement(descriptor, i)
          6 -> _uri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> display = decodeStringElement(descriptor, i)
          8 -> _display = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Participant: " + i)
        }
      }
      TestReport.Participant(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) TestReport.TestReportParticipantType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on TestReport.Participant"
            ),
        uri =
          Uri.of(uri, _uri)
            ?: throw SerializationException(
              "Missing required property 'uri' on TestReport.Participant"
            ),
        display = R4String.of(display, _display),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Participant) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeStringIfNotNull(descriptor, 5, value.uri.value)
      encodeElementIfNotNull(descriptor, 6, value.uri)
      encodeStringIfNotNull(descriptor, 7, value.display?.value)
      encodeElementIfNotNull(descriptor, 8, value.display)
    }
  }
}

internal object TestReportSetupSerializer : KSerializer<TestReport.Setup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Setup") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("action", TestReportSetupActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Setup>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Setup =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var action: List<TestReport.Setup.Action>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Setup: " + i)
        }
      }
      TestReport.Setup(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          TestReportSetupActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object TestReportSetupActionSerializer : KSerializer<TestReport.Setup.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
      optionalElement("assert", TestReportSetupActionAssertSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Setup.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var operation: TestReport.Setup.Action.Operation? = null
      var assert: TestReport.Setup.Action.Assert? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionOperationSerializer,
                null,
              )
          4 ->
            assert =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionAssertSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      TestReport.Setup.Action(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        operation = operation,
        assert = assert,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(
        descriptor,
        3,
        TestReportSetupActionOperationSerializer,
        value.operation,
      )
      encodeSerializableIfNotNull(
        descriptor,
        4,
        TestReportSetupActionAssertSerializer,
        value.assert,
      )
    }
  }
}

internal object TestReportSetupActionOperationSerializer :
  KSerializer<TestReport.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("result", KotlinString.serializer().descriptor)
      optionalElement("_result", ElementSerializer.descriptor)
      optionalElement("message", KotlinString.serializer().descriptor)
      optionalElement("_message", ElementSerializer.descriptor)
      optionalElement("detail", KotlinString.serializer().descriptor)
      optionalElement("_detail", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Setup.Action.Operation>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Operation =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var result: KotlinString? = null
      var _result: Element? = null
      var message: KotlinString? = null
      var _message: Element? = null
      var detail: KotlinString? = null
      var _detail: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> result = decodeStringElement(descriptor, i)
          4 -> _result = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> message = decodeStringElement(descriptor, i)
          6 -> _message = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> detail = decodeStringElement(descriptor, i)
          8 -> _detail = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Operation: " + i)
        }
      }
      TestReport.Setup.Action.Operation(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        result =
          Enumeration.of(
            if (result != null) TestReport.TestReportActionResult.fromCode(result) else null,
            _result,
          )
            ?: throw SerializationException(
              "Missing required property 'result' on TestReport.Setup.Action.Operation"
            ),
        message = Markdown.of(message, _message),
        detail = Uri.of(detail, _detail),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Operation) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.result.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.result)
      encodeStringIfNotNull(descriptor, 5, value.message?.value)
      encodeElementIfNotNull(descriptor, 6, value.message)
      encodeStringIfNotNull(descriptor, 7, value.detail?.value)
      encodeElementIfNotNull(descriptor, 8, value.detail)
    }
  }
}

internal object TestReportSetupActionAssertSerializer :
  KSerializer<TestReport.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assert") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("result", KotlinString.serializer().descriptor)
      optionalElement("_result", ElementSerializer.descriptor)
      optionalElement("message", KotlinString.serializer().descriptor)
      optionalElement("_message", ElementSerializer.descriptor)
      optionalElement("detail", KotlinString.serializer().descriptor)
      optionalElement("_detail", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Setup.Action.Assert>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var result: KotlinString? = null
      var _result: Element? = null
      var message: KotlinString? = null
      var _message: Element? = null
      var detail: KotlinString? = null
      var _detail: Element? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> result = decodeStringElement(descriptor, i)
          4 -> _result = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> message = decodeStringElement(descriptor, i)
          6 -> _message = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> detail = decodeStringElement(descriptor, i)
          8 -> _detail = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Assert: " + i)
        }
      }
      TestReport.Setup.Action.Assert(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        result =
          Enumeration.of(
            if (result != null) TestReport.TestReportActionResult.fromCode(result) else null,
            _result,
          )
            ?: throw SerializationException(
              "Missing required property 'result' on TestReport.Setup.Action.Assert"
            ),
        message = Markdown.of(message, _message),
        detail = R4String.of(detail, _detail),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.result.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.result)
      encodeStringIfNotNull(descriptor, 5, value.message?.value)
      encodeElementIfNotNull(descriptor, 6, value.message)
      encodeStringIfNotNull(descriptor, 7, value.detail?.value)
      encodeElementIfNotNull(descriptor, 8, value.detail)
    }
  }
}

internal object TestReportTestSerializer : KSerializer<TestReport.Test> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Test") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("action", TestReportTestActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Test>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Test =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var name: KotlinString? = null
      var _name: Element? = null
      var description: KotlinString? = null
      var _description: Element? = null
      var action: List<TestReport.Test.Action>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 -> name = decodeStringElement(descriptor, i)
          4 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> description = decodeStringElement(descriptor, i)
          6 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportTestActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Test: " + i)
        }
      }
      TestReport.Test(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        name = R4String.of(name, _name),
        description = R4String.of(description, _description),
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeStringIfNotNull(descriptor, 3, value.name?.value)
      encodeElementIfNotNull(descriptor, 4, value.name)
      encodeStringIfNotNull(descriptor, 5, value.description?.value)
      encodeElementIfNotNull(descriptor, 6, value.description)
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          TestReportTestActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object TestReportTestActionSerializer : KSerializer<TestReport.Test.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
      optionalElement("assert", TestReportSetupActionAssertSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Test.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Test.Action =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var operation: TestReport.Setup.Action.Operation? = null
      var assert: TestReport.Setup.Action.Assert? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionOperationSerializer,
                null,
              )
          4 ->
            assert =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionAssertSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      TestReport.Test.Action(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        operation = operation,
        assert = assert,
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test.Action) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableIfNotNull(
        descriptor,
        3,
        TestReportSetupActionOperationSerializer,
        value.operation,
      )
      encodeSerializableIfNotNull(
        descriptor,
        4,
        TestReportSetupActionAssertSerializer,
        value.assert,
      )
    }
  }
}

internal object TestReportTeardownSerializer : KSerializer<TestReport.Teardown> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Teardown") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("action", TestReportTeardownActionSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Teardown>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Teardown =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var action: List<TestReport.Teardown.Action>? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportTeardownActionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Teardown: " + i)
        }
      }
      TestReport.Teardown(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        action = action ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          TestReportTeardownActionSerializer.listSerializer,
          value.action,
        )
    }
  }
}

internal object TestReportTeardownActionSerializer : KSerializer<TestReport.Teardown.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("operation", TestReportSetupActionOperationSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<TestReport.Teardown.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): TestReport.Teardown.Action =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var operation: TestReport.Setup.Action.Operation? = null
      while (true) {
        when (val i = decodeElementIndex(descriptor)) {
          0 -> id = decodeStringElement(descriptor, i)
          1 ->
            extension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          2 ->
            modifierExtension =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ExtensionSerializer.listSerializer,
                null,
              )
          3 ->
            operation =
              decodeNullableSerializableElement(
                descriptor,
                i,
                TestReportSetupActionOperationSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      TestReport.Teardown.Action(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        operation =
          operation
            ?: throw SerializationException(
              "Missing required property 'operation' on TestReport.Teardown.Action"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown.Action) {
    encoder.encodeStructure(descriptor) {
      encodeStringIfNotNull(descriptor, 0, value.id)
      if (value.extension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          1,
          ExtensionSerializer.listSerializer,
          value.extension,
        )
      if (value.modifierExtension.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          2,
          ExtensionSerializer.listSerializer,
          value.modifierExtension,
        )
      encodeSerializableElement(
        descriptor,
        3,
        TestReportSetupActionOperationSerializer,
        value.operation,
      )
    }
  }
}

internal object TestReportSerializer : FhirResourceSerializer<TestReport> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("TestReport")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.optionalElement("id", KotlinString.serializer().descriptor)
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.optionalElement("implicitRules", KotlinString.serializer().descriptor)
    b.optionalElement("_implicitRules", ElementSerializer.descriptor)
    b.optionalElement("language", KotlinString.serializer().descriptor)
    b.optionalElement("_language", ElementSerializer.descriptor)
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor { ResourcePolymorphicSerializer.descriptor }),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("testScript", ReferenceSerializer.descriptor)
    b.optionalElement("result", KotlinString.serializer().descriptor)
    b.optionalElement("_result", ElementSerializer.descriptor)
    b.optionalElement("score", FhirDecimalSerializer.descriptor)
    b.optionalElement("_score", ElementSerializer.descriptor)
    b.optionalElement("tester", KotlinString.serializer().descriptor)
    b.optionalElement("_tester", ElementSerializer.descriptor)
    b.optionalElement("issued", KotlinString.serializer().descriptor)
    b.optionalElement("_issued", ElementSerializer.descriptor)
    b.optionalElement("participant", TestReportParticipantSerializer.listSerializer.descriptor)
    b.optionalElement("setup", TestReportSetupSerializer.descriptor)
    b.optionalElement("test", TestReportTestSerializer.listSerializer.descriptor)
    b.optionalElement("teardown", TestReportTeardownSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var status: KotlinString? = null
    var _status: Element? = null
    var testScript: Reference? = null
    var result: KotlinString? = null
    var _result: Element? = null
    var score: FhirDecimal? = null
    var _score: Element? = null
    var tester: KotlinString? = null
    var _tester: Element? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var participant: List<TestReport.Participant>? = null
    var setup: TestReport.Setup? = null
    var test: List<TestReport.Test>? = null
    var teardown: TestReport.Teardown? = null
    while (true) {
      val i = decoder.decodeElementIndex(descriptor)
      if (i == CompositeDecoder.DECODE_DONE) break
      when (i - descriptorOffset) {
        -1 -> decoder.decodeStringElement(descriptor, i)
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, MetaSerializer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          text = decoder.decodeNullableSerializableElement(descriptor, i, NarrativeSerializer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ResourcePolymorphicSerializer.listSerializer,
              null,
            )
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          testScript =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> result = decoder.decodeStringElement(descriptor, i)
        17 ->
          _result =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          score =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        19 ->
          _score = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> tester = decoder.decodeStringElement(descriptor, i)
        21 ->
          _tester =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 -> issued = decoder.decodeStringElement(descriptor, i)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          participant =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportParticipantSerializer.listSerializer,
              null,
            )
        25 ->
          setup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportSetupSerializer,
              null,
            )
        26 ->
          test =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTestSerializer.listSerializer,
              null,
            )
        27 ->
          teardown =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              TestReportTeardownSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding TestReport: " + i)
      }
    }
    return TestReport(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      name = R4String.of(name, _name),
      status =
        Enumeration.of(
          if (status != null) TestReport.TestReportStatus.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on TestReport"),
      testScript =
        testScript
          ?: throw SerializationException("Missing required property 'testScript' on TestReport"),
      result =
        Enumeration.of(
          if (result != null) TestReport.TestReportResult.fromCode(result) else null,
          _result,
        ) ?: throw SerializationException("Missing required property 'result' on TestReport"),
      score = Decimal.of(score, _score),
      tester = R4String.of(tester, _tester),
      issued = DateTime.of(if (issued != null) FhirDateTime.fromString(issued) else null, _issued),
      participant = participant ?: listOf(),
      setup = setup,
      test = test ?: listOf(),
      teardown = teardown,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestReport,
  ) {
    encoder.encodeStringIfNotNull(descriptor, 0 + descriptorOffset, value.id)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      1 + descriptorOffset,
      MetaSerializer,
      value.meta,
    )
    encoder.encodeStringIfNotNull(descriptor, 2 + descriptorOffset, value.implicitRules?.value)
    encoder.encodeElementIfNotNull(descriptor, 3 + descriptorOffset, value.implicitRules)
    encoder.encodeStringIfNotNull(descriptor, 4 + descriptorOffset, value.language?.value)
    encoder.encodeElementIfNotNull(descriptor, 5 + descriptorOffset, value.language)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      6 + descriptorOffset,
      NarrativeSerializer,
      value.text,
    )
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer,
      value.identifier,
    )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.status)
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.testScript,
    )
    encoder.encodeStringIfNotNull(descriptor, 16 + descriptorOffset, value.result.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.result)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      FhirDecimalSerializer,
      value.score?.value,
    )
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.score)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.tester?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.tester)
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.issued)
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        TestReportParticipantSerializer.listSerializer,
        value.participant,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      TestReportSetupSerializer,
      value.setup,
    )
    if (value.test.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        TestReportTestSerializer.listSerializer,
        value.test,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      27 + descriptorOffset,
      TestReportTeardownSerializer,
      value.teardown,
    )
  }
}
