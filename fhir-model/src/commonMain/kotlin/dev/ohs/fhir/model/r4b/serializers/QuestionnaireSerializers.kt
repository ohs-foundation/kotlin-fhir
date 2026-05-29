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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Questionnaire
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4b.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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

internal object QuestionnaireItemSerializer : KSerializer<Questionnaire.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
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
      element("linkId", KotlinString.serializer().descriptor, isOptional = true)
      element("_linkId", Element.serializer().descriptor, isOptional = true)
      element("definition", KotlinString.serializer().descriptor, isOptional = true)
      element("_definition", Element.serializer().descriptor, isOptional = true)
      element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("prefix", KotlinString.serializer().descriptor, isOptional = true)
      element("_prefix", Element.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element(
        "enableWhen",
        listSerialDescriptor(
          lazyDescriptor { Questionnaire.Item.EnableWhen.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("enableBehavior", KotlinString.serializer().descriptor, isOptional = true)
      element("_enableBehavior", Element.serializer().descriptor, isOptional = true)
      element("required", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_required", Element.serializer().descriptor, isOptional = true)
      element("repeats", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_repeats", Element.serializer().descriptor, isOptional = true)
      element("readOnly", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_readOnly", Element.serializer().descriptor, isOptional = true)
      element("maxLength", Int.serializer().descriptor, isOptional = true)
      element("_maxLength", Element.serializer().descriptor, isOptional = true)
      element("answerValueSet", KotlinString.serializer().descriptor, isOptional = true)
      element("_answerValueSet", Element.serializer().descriptor, isOptional = true)
      element(
        "answerOption",
        listSerialDescriptor(
          lazyDescriptor { Questionnaire.Item.AnswerOption.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "initial",
        listSerialDescriptor(lazyDescriptor { Questionnaire.Item.Initial.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { Questionnaire.Item.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Questionnaire.Item =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Questionnaire.Item {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var code: List<Coding>? = null
    var prefix: KotlinString? = null
    var _prefix: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var enableWhen: List<Questionnaire.Item.EnableWhen>? = null
    var enableBehavior: KotlinString? = null
    var _enableBehavior: Element? = null
    var required: KotlinBoolean? = null
    var _required: Element? = null
    var repeats: KotlinBoolean? = null
    var _repeats: Element? = null
    var readOnly: KotlinBoolean? = null
    var _readOnly: Element? = null
    var maxLength: Int? = null
    var _maxLength: Element? = null
    var answerValueSet: KotlinString? = null
    var _answerValueSet: Element? = null
    var answerOption: List<Questionnaire.Item.AnswerOption>? = null
    var initial: List<Questionnaire.Item.Initial>? = null
    var item: List<Questionnaire.Item>? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        7 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        8 -> prefix = decoder.decodeStringElement(descriptor, i)
        9 ->
          _prefix =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        10 -> text = decoder.decodeStringElement(descriptor, i)
        11 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        12 -> type = decoder.decodeStringElement(descriptor, i)
        13 ->
          _type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        14 ->
          enableWhen =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.enableWhenSer, null)
        15 -> enableBehavior = decoder.decodeStringElement(descriptor, i)
        16 ->
          _enableBehavior =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        17 -> required = decoder.decodeBooleanElement(descriptor, i)
        18 ->
          _required =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        19 -> repeats = decoder.decodeBooleanElement(descriptor, i)
        20 ->
          _repeats =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        21 -> readOnly = decoder.decodeBooleanElement(descriptor, i)
        22 ->
          _readOnly =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        23 -> maxLength = decoder.decodeIntElement(descriptor, i)
        24 ->
          _maxLength =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        25 -> answerValueSet = decoder.decodeStringElement(descriptor, i)
        26 ->
          _answerValueSet =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        27 ->
          answerOption =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.answerOptionSer, null)
        28 ->
          initial =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.initialSer, null)
        29 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return Questionnaire.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R4bString.of(linkId, _linkId)!!,
      definition = Uri.of(definition, _definition),
      code = code ?: listOf(),
      prefix = R4bString.of(prefix, _prefix),
      text = R4bString.of(text, _text),
      type = Enumeration.of(Questionnaire.QuestionnaireItemType.fromCode(type!!), _type),
      enableWhen = enableWhen ?: listOf(),
      enableBehavior =
        enableBehavior?.let {
          Enumeration.of(Questionnaire.EnableWhenBehavior.fromCode(it), _enableBehavior)
        },
      required = R4bBoolean.of(required, _required),
      repeats = R4bBoolean.of(repeats, _repeats),
      readOnly = R4bBoolean.of(readOnly, _readOnly),
      maxLength = Integer.of(maxLength, _maxLength),
      answerValueSet = Canonical.of(answerValueSet, _answerValueSet),
      answerOption = answerOption ?: listOf(),
      initial = initial ?: listOf(),
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Questionnaire.Item) {
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
    ((value.linkId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.linkIdSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.linkIdSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.codeSer, value.code)
    ((value.prefix?.value))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.linkIdSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.linkIdSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 12, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.linkIdSer, it)
    }
    if (value.enableWhen.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.enableWhenSer, value.enableWhen)
    ((value.enableBehavior?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 15, it)
    }
    (value.enableBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.linkIdSer, it)
    }
    ((value.required?.value))?.let { encoder.encodeBooleanElement(descriptor, 17, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.linkIdSer, it)
    }
    ((value.repeats?.value))?.let { encoder.encodeBooleanElement(descriptor, 19, it) }
    (value.repeats?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.linkIdSer, it)
    }
    ((value.readOnly?.value))?.let { encoder.encodeBooleanElement(descriptor, 21, it) }
    (value.readOnly?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.linkIdSer, it)
    }
    ((value.maxLength?.value))?.let { encoder.encodeIntElement(descriptor, 23, it) }
    (value.maxLength?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.linkIdSer, it)
    }
    ((value.answerValueSet?.value))?.let { encoder.encodeStringElement(descriptor, 25, it) }
    (value.answerValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.linkIdSer, it)
    }
    if (value.answerOption.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.answerOptionSer, value.answerOption)
    if (value.initial.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.initialSer, value.initial)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.itemSer, value.item)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val codeSerInner: KSerializer<Coding> = Coding.serializer()

    public val codeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codeSerInner)

    public val enableWhenSerInner: KSerializer<Questionnaire.Item.EnableWhen> =
      Questionnaire.Item.EnableWhen.serializer()

    public val enableWhenSer: KSerializer<List<Questionnaire.Item.EnableWhen>> =
      ListSerializer(Hoisted.enableWhenSerInner)

    public val answerOptionSerInner: KSerializer<Questionnaire.Item.AnswerOption> =
      Questionnaire.Item.AnswerOption.serializer()

    public val answerOptionSer: KSerializer<List<Questionnaire.Item.AnswerOption>> =
      ListSerializer(Hoisted.answerOptionSerInner)

    public val initialSerInner: KSerializer<Questionnaire.Item.Initial> =
      Questionnaire.Item.Initial.serializer()

    public val initialSer: KSerializer<List<Questionnaire.Item.Initial>> =
      ListSerializer(Hoisted.initialSerInner)

    public val itemSerInner: KSerializer<Questionnaire.Item> = Questionnaire.Item.serializer()

    public val itemSer: KSerializer<List<Questionnaire.Item>> = ListSerializer(Hoisted.itemSerInner)
  }
}

internal object QuestionnaireItemEnableWhenSerializer : KSerializer<Questionnaire.Item.EnableWhen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnableWhen") {
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
      element("question", KotlinString.serializer().descriptor, isOptional = true)
      element("_question", Element.serializer().descriptor, isOptional = true)
      element("operator", KotlinString.serializer().descriptor, isOptional = true)
      element("_operator", Element.serializer().descriptor, isOptional = true)
      element("answerBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_answerBoolean", Element.serializer().descriptor, isOptional = true)
      element("answerDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_answerDecimal", Element.serializer().descriptor, isOptional = true)
      element("answerInteger", Int.serializer().descriptor, isOptional = true)
      element("_answerInteger", Element.serializer().descriptor, isOptional = true)
      element("answerDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_answerDate", Element.serializer().descriptor, isOptional = true)
      element("answerDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_answerDateTime", Element.serializer().descriptor, isOptional = true)
      element("answerTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_answerTime", Element.serializer().descriptor, isOptional = true)
      element("answerString", KotlinString.serializer().descriptor, isOptional = true)
      element("_answerString", Element.serializer().descriptor, isOptional = true)
      element("answerCoding", Coding.serializer().descriptor, isOptional = true)
      element("answerQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("answerReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Questionnaire.Item.EnableWhen {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var question: KotlinString? = null
    var _question: Element? = null
    var `operator`: KotlinString? = null
    var _operator: Element? = null
    var answerBoolean: KotlinBoolean? = null
    var _answerBoolean: Element? = null
    var answerDecimal: BigDecimal? = null
    var _answerDecimal: Element? = null
    var answerInteger: Int? = null
    var _answerInteger: Element? = null
    var answerDate: KotlinString? = null
    var _answerDate: Element? = null
    var answerDateTime: KotlinString? = null
    var _answerDateTime: Element? = null
    var answerTime: LocalTime? = null
    var _answerTime: Element? = null
    var answerString: KotlinString? = null
    var _answerString: Element? = null
    var answerCoding: Coding? = null
    var answerQuantity: Quantity? = null
    var answerReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> question = decoder.decodeStringElement(descriptor, i)
        4 ->
          _question =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        5 -> `operator` = decoder.decodeStringElement(descriptor, i)
        6 ->
          _operator =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        7 -> answerBoolean = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _answerBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        9 ->
          answerDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        10 ->
          _answerDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        11 -> answerInteger = decoder.decodeIntElement(descriptor, i)
        12 ->
          _answerInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        13 -> answerDate = decoder.decodeStringElement(descriptor, i)
        14 ->
          _answerDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        15 -> answerDateTime = decoder.decodeStringElement(descriptor, i)
        16 ->
          _answerDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        17 ->
          answerTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        18 ->
          _answerTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        19 -> answerString = decoder.decodeStringElement(descriptor, i)
        20 ->
          _answerString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.questionSer, null)
        21 ->
          answerCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.answerCodingSer, null)
        22 ->
          answerQuantity =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.answerQuantitySer,
              null,
            )
        23 ->
          answerReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.answerReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EnableWhen: " + i)
      }
    }
    return Questionnaire.Item.EnableWhen(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      question = R4bString.of(question, _question)!!,
      `operator` =
        Enumeration.of(Questionnaire.QuestionnaireItemOperator.fromCode(`operator`!!), _operator),
      answer =
        Questionnaire.Item.EnableWhen.Answer.from(
          R4bBoolean.of(answerBoolean, _answerBoolean),
          Decimal.of(answerDecimal, _answerDecimal),
          Integer.of(answerInteger, _answerInteger),
          Date.of(FhirDate.fromString(answerDate), _answerDate),
          DateTime.of(FhirDateTime.fromString(answerDateTime), _answerDateTime),
          Time.of(answerTime, _answerTime),
          R4bString.of(answerString, _answerString),
          answerCoding,
          answerQuantity,
          answerReference,
        )!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Questionnaire.Item.EnableWhen) {
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
    ((value.question.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.question.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.questionSer, it)
    }
    ((value.`operator`.value?.getCode()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.`operator`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.questionSer, it)
    }
    when (val choice = value.answer) {
      is Questionnaire.Item.EnableWhen.Answer.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 9, BigDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 13, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 17, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 19, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 20, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Coding -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.answerCodingSer, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 22, Hoisted.answerQuantitySer, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Reference -> {
        encoder.encodeSerializableElement(descriptor, 23, Hoisted.answerReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val questionSer: KSerializer<Element> = Element.serializer()

    public val answerCodingSer: KSerializer<Coding> = Coding.serializer()

    public val answerQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val answerReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object QuestionnaireItemAnswerOptionSerializer :
  KSerializer<Questionnaire.Item.AnswerOption> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AnswerOption") {
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
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
      element("initialSelected", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_initialSelected", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Questionnaire.Item.AnswerOption {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueCoding: Coding? = null
    var valueReference: Reference? = null
    var initialSelected: KotlinBoolean? = null
    var _initialSelected: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        4 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueIntegerSer, null)
        5 -> valueDate = decoder.decodeStringElement(descriptor, i)
        6 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueIntegerSer, null)
        7 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        8 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueIntegerSer, null)
        9 -> valueString = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueIntegerSer, null)
        11 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        12 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        13 -> initialSelected = decoder.decodeBooleanElement(descriptor, i)
        14 ->
          _initialSelected =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueIntegerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AnswerOption: " + i)
      }
    }
    return Questionnaire.Item.AnswerOption(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        Questionnaire.Item.AnswerOption.Value.from(
          Integer.of(valueInteger, _valueInteger),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          Time.of(valueTime, _valueTime),
          R4bString.of(valueString, _valueString),
          valueCoding,
          valueReference,
        )!!,
      initialSelected = R4bBoolean.of(initialSelected, _initialSelected),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Questionnaire.Item.AnswerOption,
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
    when (val choice = value.`value`) {
      is Questionnaire.Item.AnswerOption.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 5, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 7, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 11, Hoisted.valueCodingSer, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueReferenceSer, choice.value)
      }
    }
    ((value.initialSelected?.value))?.let { encoder.encodeBooleanElement(descriptor, 13, it) }
    (value.initialSelected?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueIntegerSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueIntegerSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object QuestionnaireItemInitialSerializer : KSerializer<Questionnaire.Item.Initial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Initial") {
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
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueDecimal", BigDecimalSerializer.descriptor, isOptional = true)
      element("_valueDecimal", Element.serializer().descriptor, isOptional = true)
      element("valueInteger", Int.serializer().descriptor, isOptional = true)
      element("_valueInteger", Element.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDateTime", Element.serializer().descriptor, isOptional = true)
      element("valueTime", LocalTimeSerializer.descriptor, isOptional = true)
      element("_valueTime", Element.serializer().descriptor, isOptional = true)
      element("valueString", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueString", Element.serializer().descriptor, isOptional = true)
      element("valueUri", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueUri", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("valueCoding", Coding.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Questionnaire.Item.Initial {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueDecimal: BigDecimal? = null
    var _valueDecimal: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: KotlinString? = null
    var _valueDate: Element? = null
    var valueDateTime: KotlinString? = null
    var _valueDateTime: Element? = null
    var valueTime: LocalTime? = null
    var _valueTime: Element? = null
    var valueString: KotlinString? = null
    var _valueString: Element? = null
    var valueUri: KotlinString? = null
    var _valueUri: Element? = null
    var valueAttachment: Attachment? = null
    var valueCoding: Coding? = null
    var valueQuantity: Quantity? = null
    var valueReference: Reference? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        5 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, BigDecimalSerializer, null)
        6 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        7 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        8 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        9 -> valueDate = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        11 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        13 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        14 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        15 -> valueString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        17 -> valueUri = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueBooleanSer, null)
        19 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueAttachmentSer,
              null,
            )
        20 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueCodingSer, null)
        21 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        22 ->
          valueReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.valueReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Initial: " + i)
      }
    }
    return Questionnaire.Item.Initial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        Questionnaire.Item.Initial.Value.from(
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Decimal.of(valueDecimal, _valueDecimal),
          Integer.of(valueInteger, _valueInteger),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Time.of(valueTime, _valueTime),
          R4bString.of(valueString, _valueString),
          Uri.of(valueUri, _valueUri),
          valueAttachment,
          valueCoding,
          valueQuantity,
          valueReference,
        )!!,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Questionnaire.Item.Initial) {
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
    when (val choice = value.`value`) {
      is Questionnaire.Item.Initial.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 5, BigDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 13, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.valueAttachmentSer, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueCodingSer, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.valueQuantitySer, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 22, Hoisted.valueReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueBooleanSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object QuestionnaireSerializer : KSerializer<Questionnaire> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element(
      "derivedFrom",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_derivedFrom",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_experimental", Element.serializer().descriptor, isOptional = true)
    b.element(
      "subjectType",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "_subjectType",
      listSerialDescriptor(Element.serializer().descriptor),
      isOptional = true,
    )
    b.element("date", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_date", Element.serializer().descriptor, isOptional = true)
    b.element("publisher", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_publisher", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contact",
      listSerialDescriptor(ContactDetail.serializer().descriptor),
      isOptional = true,
    )
    b.element("description", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_description", Element.serializer().descriptor, isOptional = true)
    b.element(
      "useContext",
      listSerialDescriptor(UsageContext.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "jurisdiction",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("purpose", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_purpose", Element.serializer().descriptor, isOptional = true)
    b.element("copyright", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_copyright", Element.serializer().descriptor, isOptional = true)
    b.element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_approvalDate", Element.serializer().descriptor, isOptional = true)
    b.element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
    b.element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
    b.element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { Questionnaire.Item.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Questionnaire =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Questionnaire")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Questionnaire {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var identifier: List<Identifier>? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var derivedFrom: List<KotlinString?>? = null
    var _derivedFrom: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectType: List<KotlinString?>? = null
    var _subjectType: List<Element?>? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var purpose: KotlinString? = null
    var _purpose: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var code: List<Coding>? = null
    var item: List<Questionnaire.Item>? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> name = decoder.decodeStringElement(descriptor, i)
        16 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 -> title = decoder.decodeStringElement(descriptor, i)
        18 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer, null)
        20 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer2, null)
        21 -> status = decoder.decodeStringElement(descriptor, i)
        22 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        23 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        24 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 ->
          subjectType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer, null)
        26 ->
          _subjectType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.derivedFromSer2, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 -> publisher = decoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        32 -> description = decoder.decodeStringElement(descriptor, i)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.useContextSer, null)
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.jurisdictionSer, null)
        36 -> purpose = decoder.decodeStringElement(descriptor, i)
        37 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        38 -> copyright = decoder.decodeStringElement(descriptor, i)
        39 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        40 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        41 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        42 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        43 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        44 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.effectivePeriodSer,
              null,
            )
        45 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        46 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        else -> throw SerializationException("Unexpected index decoding Questionnaire: " + i)
      }
    }
    return Questionnaire(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { index ->
          Canonical.of(derivedFrom?.getOrNull(index)?.let { it }, _derivedFrom?.getOrNull(index))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      subjectType =
        (kotlin.collections.List(maxOf(subjectType?.size ?: 0, _subjectType?.size ?: 0)) { index ->
          Enumeration.of(
            ResourceType.fromCode(subjectType?.getOrNull(index)!!),
            _subjectType?.getOrNull(index),
          )
        }),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      code = code ?: listOf(),
      item = item ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Questionnaire,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 10 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.derivedFrom.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        Hoisted.derivedFromSer,
        it,
      )
    }
    (value.derivedFrom.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.derivedFromSer2,
        it,
      )
    }
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 21 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.experimental?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.subjectType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.derivedFromSer,
        it,
      )
    }
    (value.subjectType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.derivedFromSer2,
        it,
      )
    }
    ((value.date?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.publisher?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    ((value.description?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        Hoisted.useContextSer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.jurisdictionSer,
        value.jurisdiction,
      )
    ((value.purpose?.value))?.let {
      encoder.encodeStringElement(descriptor, 36 + descriptorOffset, it)
    }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.copyright?.value))?.let {
      encoder.encodeStringElement(descriptor, 38 + descriptorOffset, it)
    }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.approvalDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 40 + descriptorOffset, it)
    }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        41 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.lastReviewDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 42 + descriptorOffset, it)
    }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.effectivePeriodSer,
        it,
      )
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.codeSer,
        value.code,
      )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.itemSer,
        value.item,
      )
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

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val derivedFromSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromSerInner).nullable)

    public val derivedFromSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val codeSerInner: KSerializer<Coding> = Coding.serializer()

    public val codeSer: KSerializer<List<Coding>> = ListSerializer(Hoisted.codeSerInner)

    public val itemSerInner: KSerializer<Questionnaire.Item> = Questionnaire.Item.serializer()

    public val itemSer: KSerializer<List<Questionnaire.Item>> = ListSerializer(Hoisted.itemSerInner)
  }
}

internal object QuestionnairePolymorphicSerializer : KSerializer<Questionnaire> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire") { QuestionnaireSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire) {
    encoder.encodeStructure(descriptor) {
      QuestionnaireSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Questionnaire =
    decoder.decodeStructure(descriptor) {
      QuestionnaireSerializer.deserializeInternal(this, descriptor, 0)
    }
}
