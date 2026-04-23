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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.TestReport
import dev.ohs.fhir.model.r4b.Uri
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Participant) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Participant {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> uri = decoder.decodeStringElement(__desc, 5)
        6 -> _uri = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> display = decoder.decodeStringElement(__desc, 7)
        8 -> _display = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Participant: " + __i)
      }
    }
    return TestReport.Participant(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(TestReport.TestReportParticipantType.fromCode(type!!), _type),
      uri = Uri.of(uri, _uri)!!,
      display = R4bString.of(display, _display),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Participant) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    ((value.uri.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.uri.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it)
    }
    ((value.display?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.display?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.typeSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Setup {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Setup.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> action = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Setup: " + __i)
      }
    }
    return TestReport.Setup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Setup) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Setup.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        4 -> assert = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Setup.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.assertSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Operation) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Setup.Action.Operation {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> result = decoder.decodeStringElement(__desc, 3)
        4 -> _result = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.resultSer, null)
        5 -> message = decoder.decodeStringElement(__desc, 5)
        6 ->
          _message = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.resultSer, null)
        7 -> detail = decoder.decodeStringElement(__desc, 7)
        8 -> _detail = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.resultSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Operation: " + __i)
      }
    }
    return TestReport.Setup.Action.Operation(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      result = Enumeration.of(TestReport.TestReportActionResult.fromCode(result!!), _result),
      message = Markdown.of(message, _message),
      detail = Uri.of(detail, _detail),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Setup.Action.Operation) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.result.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.resultSer, it)
    }
    ((value.message?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.message?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.resultSer, it)
    }
    ((value.detail?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.resultSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Setup.Action.Assert) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Setup.Action.Assert {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> result = decoder.decodeStringElement(__desc, 3)
        4 -> _result = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.resultSer, null)
        5 -> message = decoder.decodeStringElement(__desc, 5)
        6 ->
          _message = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.resultSer, null)
        7 -> detail = decoder.decodeStringElement(__desc, 7)
        8 -> _detail = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.resultSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Assert: " + __i)
      }
    }
    return TestReport.Setup.Action.Assert(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      result = Enumeration.of(TestReport.TestReportActionResult.fromCode(result!!), _result),
      message = Markdown.of(message, _message),
      detail = R4bString.of(detail, _detail),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Setup.Action.Assert) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.result.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.resultSer, it)
    }
    ((value.message?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.message?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.resultSer, it)
    }
    ((value.detail?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.detail?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.resultSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Test {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var action: List<TestReport.Test.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> name = decoder.decodeStringElement(__desc, 3)
        4 -> _name = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.nameSer, null)
        5 -> description = decoder.decodeStringElement(__desc, 5)
        6 ->
          _description = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        7 -> action = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Test: " + __i)
      }
    }
    return TestReport.Test(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      name = R4bString.of(name, _name),
      description = R4bString.of(description, _description),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Test) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.nameSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Test.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Test.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    var assert: TestReport.Setup.Action.Assert? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        4 -> assert = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.assertSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Test.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
    (value.assert)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.assertSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Teardown {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var action: List<TestReport.Teardown.Action>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> action = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.actionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Teardown: " + __i)
      }
    }
    return TestReport.Teardown(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      action = action ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Teardown) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.actionSer, value.action)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport.Teardown.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): TestReport.Teardown.Action {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var operation: TestReport.Setup.Action.Operation? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          operation =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.operationSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return TestReport.Teardown.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      operation = operation!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport.Teardown.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.operation)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.operationSer, it)
    }
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
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("testScript", Reference.serializer().descriptor, isOptional = true)
      element("result", KotlinString.serializer().descriptor, isOptional = true)
      element("_result", Element.serializer().descriptor, isOptional = true)
      element("score", BigDecimalSerializer.descriptor, isOptional = true)
      element("_score", Element.serializer().descriptor, isOptional = true)
      element("tester", KotlinString.serializer().descriptor, isOptional = true)
      element("_tester", Element.serializer().descriptor, isOptional = true)
      element("issued", KotlinString.serializer().descriptor, isOptional = true)
      element("_issued", Element.serializer().descriptor, isOptional = true)
      element(
        "participant",
        listSerialDescriptor(lazyDescriptor { TestReport.Participant.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "setup",
        lazyDescriptor { TestReport.Setup.serializer().descriptor },
        isOptional = true,
      )
      element(
        "test",
        listSerialDescriptor(lazyDescriptor { TestReport.Test.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "teardown",
        lazyDescriptor { TestReport.Teardown.serializer().descriptor },
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): TestReport =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: TestReport) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): TestReport {
    val __desc = descriptor
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
    var score: BigDecimal? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> name = decoder.decodeStringElement(__desc, 12)
        13 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 -> status = decoder.decodeStringElement(__desc, 14)
        15 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          testScript =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.testScriptSer, null)
        17 -> result = decoder.decodeStringElement(__desc, 17)
        18 ->
          _result =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          score = decoder.decodeNullableSerializableElement(__desc, 19, BigDecimalSerializer, null)
        20 ->
          _score =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.implicitRulesSer, null)
        21 -> tester = decoder.decodeStringElement(__desc, 21)
        22 ->
          _tester =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 -> issued = decoder.decodeStringElement(__desc, 23)
        24 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.implicitRulesSer, null)
        25 ->
          participant =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.participantSer, null)
        26 -> setup = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.setupSer, null)
        27 -> test = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.testSer, null)
        28 ->
          teardown =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.teardownSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TestReport: " + __i)
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
      name = R4bString.of(name, _name),
      status = Enumeration.of(TestReport.TestReportStatus.fromCode(status!!), _status),
      testScript = testScript!!,
      result = Enumeration.of(TestReport.TestReportResult.fromCode(result!!), _result),
      score = Decimal.of(score, _score),
      tester = R4bString.of(tester, _tester),
      issued = DateTime.of(FhirDateTime.fromString(issued), _issued),
      participant = participant ?: listOf(),
      setup = setup,
      test = test ?: listOf(),
      teardown = teardown,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: TestReport) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "TestReport")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    (value.testScript)?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.testScriptSer, it)
    }
    ((value.result.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.result.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
    }
    ((value.score?.value))?.let {
      encoder.encodeSerializableElement(__desc, 19, BigDecimalSerializer, it)
    }
    (value.score?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.implicitRulesSer, it)
    }
    ((value.tester?.value))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.tester?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 23, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.implicitRulesSer, it)
    }
    if (value.participant.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 25, Hoisted.participantSer, value.participant)
    (value.setup)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.setupSer, it) }
    if (value.test.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.testSer, value.test)
    (value.teardown)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.teardownSer, it) }
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
