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
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("uri", KotlinString.serializer().descriptor, isOptional = true)
      element("_uri", Element.serializer().descriptor, isOptional = true)
      element("display", KotlinString.serializer().descriptor, isOptional = true)
      element("_display", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestReport.Participant =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Participant) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Participant {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(descriptor, i)
        4 -> _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 -> uri = decoder.decodeStringElement(descriptor, i)
        6 -> _uri = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 -> display = decoder.decodeStringElement(descriptor, i)
        8 ->
          _display = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + i)
      }
    }
    return TestReport.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        Enumeration.of(type?.let { TestReport.TestReportParticipantType.fromCode(it) }, _type)
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Participant) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.type.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    ((value.uri.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.uri.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.typeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestReportSetupSerializer : KSerializer<TestReport.Setup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Setup") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestReport.Setup.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Setup =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Setup {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Setup.Action>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Setup: " + i)
      }
    }
    return TestReport.Setup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Setup) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSerInner: KSerializer<TestReport.Setup.Action> =
      TestReport.Setup.Action.serializer()

    public val actionSer: KSerializer<List<TestReport.Setup.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestReportSetupActionSerializer : KSerializer<TestReport.Setup.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "operation",
        lazyDescriptor { TestReport.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "assert",
        lazyDescriptor { TestReport.Setup.Action.Assert.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Setup.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        4 ->
          assert = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestReport.Setup.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Setup.Action) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.assertSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestReport.Setup.Action.Operation> =
      TestReport.Setup.Action.Operation.serializer()

    public val assertSer: KSerializer<TestReport.Setup.Action.Assert> =
      TestReport.Setup.Action.Assert.serializer()
  }
}

internal object TestReportSetupActionOperationSerializer :
  KSerializer<TestReport.Setup.Action.Operation> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Operation") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("result", KotlinString.serializer().descriptor, isOptional = true)
      element("_result", Element.serializer().descriptor, isOptional = true)
      element("message", KotlinString.serializer().descriptor, isOptional = true)
      element("_message", Element.serializer().descriptor, isOptional = true)
      element("detail", KotlinString.serializer().descriptor, isOptional = true)
      element("_detail", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Operation =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Operation) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Setup.Action.Operation {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> result = decoder.decodeStringElement(descriptor, i)
        4 ->
          _result =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        5 -> message = decoder.decodeStringElement(descriptor, i)
        6 ->
          _message =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        7 -> detail = decoder.decodeStringElement(descriptor, i)
        8 ->
          _detail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + i)
      }
    }
    return TestReport.Setup.Action.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      result =
        Enumeration.of(result?.let { TestReport.TestReportActionResult.fromCode(it) }, _result)
          ?: throw SerializationException(
            "Missing required property 'result' on TestReport.Setup.Action.Operation"
          ),
      message = Markdown.of(message, _message),
      detail = Uri.of(detail, _detail),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestReport.Setup.Action.Operation,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.result.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resultSer, it)
    }
    ((value.message?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.message?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resultSer, it)
    }
    ((value.detail?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.resultSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resultSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestReportSetupActionAssertSerializer :
  KSerializer<TestReport.Setup.Action.Assert> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Assert") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("result", KotlinString.serializer().descriptor, isOptional = true)
      element("_result", Element.serializer().descriptor, isOptional = true)
      element("message", KotlinString.serializer().descriptor, isOptional = true)
      element("_message", Element.serializer().descriptor, isOptional = true)
      element("detail", KotlinString.serializer().descriptor, isOptional = true)
      element("_detail", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): TestReport.Setup.Action.Assert =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Setup.Action.Assert {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> result = decoder.decodeStringElement(descriptor, i)
        4 ->
          _result =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        5 -> message = decoder.decodeStringElement(descriptor, i)
        6 ->
          _message =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        7 -> detail = decoder.decodeStringElement(descriptor, i)
        8 ->
          _detail =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.resultSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assert: " + i)
      }
    }
    return TestReport.Setup.Action.Assert(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      result =
        Enumeration.of(result?.let { TestReport.TestReportActionResult.fromCode(it) }, _result)
          ?: throw SerializationException(
            "Missing required property 'result' on TestReport.Setup.Action.Assert"
          ),
      message = Markdown.of(message, _message),
      detail = R4String.of(detail, _detail),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: TestReport.Setup.Action.Assert,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.result.value?.code))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.resultSer, it)
    }
    ((value.message?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.message?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.resultSer, it)
    }
    ((value.detail?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.resultSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val resultSer: KSerializer<Element> = Element.serializer()
  }
}

internal object TestReportTestSerializer : KSerializer<TestReport.Test> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Test") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestReport.Test.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Test =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Test {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestReport.Test.Action>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(descriptor, i)
        4 -> _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(descriptor, i)
        6 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        7 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Test: " + i)
      }
    }
    return TestReport.Test(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Test) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.nameSer, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val nameSer: KSerializer<Element> = Element.serializer()

    public val actionSerInner: KSerializer<TestReport.Test.Action> =
      TestReport.Test.Action.serializer()

    public val actionSer: KSerializer<List<TestReport.Test.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestReportTestActionSerializer : KSerializer<TestReport.Test.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "operation",
        lazyDescriptor { TestReport.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
      element(
        "assert",
        lazyDescriptor { TestReport.Setup.Action.Assert.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Test.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Test.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        4 ->
          assert = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestReport.Test.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation,
      assert = assert,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Test.Action) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.operation)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.assertSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestReport.Setup.Action.Operation> =
      TestReport.Setup.Action.Operation.serializer()

    public val assertSer: KSerializer<TestReport.Setup.Action.Assert> =
      TestReport.Setup.Action.Assert.serializer()
  }
}

internal object TestReportTeardownSerializer : KSerializer<TestReport.Teardown> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Teardown") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { TestReport.Teardown.Action.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Teardown =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Teardown {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Teardown.Action>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Teardown: " + i)
      }
    }
    return TestReport.Teardown(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Teardown) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.actionSer, value.action)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val actionSerInner: KSerializer<TestReport.Teardown.Action> =
      TestReport.Teardown.Action.serializer()

    public val actionSer: KSerializer<List<TestReport.Teardown.Action>> =
      ListSerializer(Hoisted.actionSerInner)
  }
}

internal object TestReportTeardownActionSerializer : KSerializer<TestReport.Teardown.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element(
        "extension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "modifierExtension",
        listSerialDescriptor(Extension.serializer().descriptor),
        isOptional = true,
      )
      element(
        "operation",
        lazyDescriptor { TestReport.Setup.Action.Operation.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport.Teardown.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): TestReport.Teardown.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.operationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return TestReport.Teardown.Action(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: TestReport.Teardown.Action) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.operationSer, value.operation)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val operationSer: KSerializer<TestReport.Setup.Action.Operation> =
      TestReport.Setup.Action.Operation.serializer()
  }
}

internal object TestReportSerializer : KSerializer<TestReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestReport") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      buildDescriptor(this)
    }

  internal fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.element("id", KotlinString.serializer().descriptor, isOptional = true)
    b.element("meta", Meta.serializer().descriptor, isOptional = true)
    b.element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_implicitRules", Element.serializer().descriptor, isOptional = true)
    b.element("language", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_language", Element.serializer().descriptor, isOptional = true)
    b.element("text", Narrative.serializer().descriptor, isOptional = true)
    b.element(
      "contained",
      listSerialDescriptor(lazyDescriptor { Resource.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "extension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "modifierExtension",
      listSerialDescriptor(Extension.serializer().descriptor),
      isOptional = true,
    )
    b.element("identifier", Identifier.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("testScript", Reference.serializer().descriptor, isOptional = true)
    b.element("result", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_result", Element.serializer().descriptor, isOptional = true)
    b.element("score", FhirDecimalSerializer.descriptor, isOptional = true)
    b.element("_score", Element.serializer().descriptor, isOptional = true)
    b.element("tester", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_tester", Element.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element(
      "participant",
      listSerialDescriptor(lazyDescriptor { TestReport.Participant.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "setup",
      lazyDescriptor { TestReport.Setup.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "test",
      listSerialDescriptor(lazyDescriptor { TestReport.Test.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "teardown",
      lazyDescriptor { TestReport.Teardown.serializer().descriptor },
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): TestReport =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: TestReport) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "TestReport")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        1 -> meta = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(descriptor, i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(descriptor, i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> name = decoder.decodeStringElement(descriptor, i)
        12 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> status = decoder.decodeStringElement(descriptor, i)
        14 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 ->
          testScript =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testScriptSer, null)
        16 -> result = decoder.decodeStringElement(descriptor, i)
        17 ->
          _result =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          score =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        19 ->
          _score =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        20 -> tester = decoder.decodeStringElement(descriptor, i)
        21 ->
          _tester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 -> issued = decoder.decodeStringElement(descriptor, i)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          participant =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.participantSer, null)
        25 ->
          setup = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.setupSer, null)
        26 -> test = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.testSer, null)
        27 ->
          teardown =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.teardownSer, null)
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
        Enumeration.of(status?.let { TestReport.TestReportStatus.fromCode(it) }, _status)
          ?: throw SerializationException("Missing required property 'status' on TestReport"),
      testScript =
        testScript
          ?: throw SerializationException("Missing required property 'testScript' on TestReport"),
      result =
        Enumeration.of(result?.let { TestReport.TestReportResult.fromCode(it) }, _result)
          ?: throw SerializationException("Missing required property 'result' on TestReport"),
      score = Decimal.of(score, _score),
      tester = R4String.of(tester, _tester),
      issued = DateTime.of(FhirDateTime.fromString(issued), _issued),
      participant = participant ?: listOf(),
      setup = setup,
      test = test ?: listOf(),
      teardown = teardown,
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: TestReport,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, Hoisted.metaSer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        3 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        5 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, Hoisted.textSer, it)
    }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        Hoisted.containedSer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        Hoisted.extensionSer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.testScriptSer,
      value.testScript,
    )
    ((value.result.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.score?.value))?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        FhirDecimalSerializer,
        it,
      )
    }
    (value.score?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.tester?.value))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.tester?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.participantSer,
        value.participant,
      )
    (value.setup)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.setupSer, it)
    }
    if (value.test.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.testSer,
        value.test,
      )
    (value.teardown)?.let {
      encoder.encodeSerializableElement(descriptor, 27 + descriptorOffset, Hoisted.teardownSer, it)
    }
  }

  private object Hoisted {
    public val metaSer: KSerializer<Meta> = Meta.serializer()

    public val implicitRulesSer: KSerializer<Element> = Element.serializer()

    public val textSer: KSerializer<Narrative> = Narrative.serializer()

    public val containedSerInner: KSerializer<Resource> = Resource.serializer()

    public val containedSer: KSerializer<List<Resource>> = ListSerializer(Hoisted.containedSerInner)

    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val testScriptSer: KSerializer<Reference> = Reference.serializer()

    public val participantSerInner: KSerializer<TestReport.Participant> =
      TestReport.Participant.serializer()

    public val participantSer: KSerializer<List<TestReport.Participant>> =
      ListSerializer(Hoisted.participantSerInner)

    public val setupSer: KSerializer<TestReport.Setup> = TestReport.Setup.serializer()

    public val testSerInner: KSerializer<TestReport.Test> = TestReport.Test.serializer()

    public val testSer: KSerializer<List<TestReport.Test>> = ListSerializer(Hoisted.testSerInner)

    public val teardownSer: KSerializer<TestReport.Teardown> = TestReport.Teardown.serializer()
  }
}

internal object TestReportPolymorphicSerializer : KSerializer<TestReport> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TestReport") { TestReportSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport) {
    encoder.encodeStructure(descriptor) {
      TestReportSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): TestReport =
    decoder.decodeStructure(descriptor) {
      TestReportSerializer.deserializeInternal(this, descriptor, 0)
    }
}
