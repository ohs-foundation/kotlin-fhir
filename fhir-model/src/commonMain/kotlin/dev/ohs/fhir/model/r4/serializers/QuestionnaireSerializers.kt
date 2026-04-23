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

package dev.ohs.fhir.model.r4.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4.Attachment
import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Coding
import dev.ohs.fhir.model.r4.ContactDetail
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Decimal
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Integer
import dev.ohs.fhir.model.r4.Markdown
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Questionnaire
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.UsageContext
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, 3)
        4 -> _linkId = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.linkIdSer, null)
        5 -> definition = decoder.decodeStringElement(__desc, 5)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.linkIdSer, null)
        7 -> code = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.codeSer, null)
        8 -> prefix = decoder.decodeStringElement(__desc, 8)
        9 -> _prefix = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.linkIdSer, null)
        10 -> text = decoder.decodeStringElement(__desc, 10)
        11 -> _text = decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.linkIdSer, null)
        12 -> type = decoder.decodeStringElement(__desc, 12)
        13 -> _type = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.linkIdSer, null)
        14 ->
          enableWhen =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.enableWhenSer, null)
        15 -> enableBehavior = decoder.decodeStringElement(__desc, 15)
        16 ->
          _enableBehavior =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.linkIdSer, null)
        17 -> required = decoder.decodeBooleanElement(__desc, 17)
        18 ->
          _required = decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.linkIdSer, null)
        19 -> repeats = decoder.decodeBooleanElement(__desc, 19)
        20 ->
          _repeats = decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.linkIdSer, null)
        21 -> readOnly = decoder.decodeBooleanElement(__desc, 21)
        22 ->
          _readOnly = decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.linkIdSer, null)
        23 -> maxLength = decoder.decodeIntElement(__desc, 23)
        24 ->
          _maxLength =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.linkIdSer, null)
        25 -> answerValueSet = decoder.decodeStringElement(__desc, 25)
        26 ->
          _answerValueSet =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.linkIdSer, null)
        27 ->
          answerOption =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.answerOptionSer, null)
        28 ->
          initial = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.initialSer, null)
        29 -> item = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return Questionnaire.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R4String.of(linkId, _linkId)!!,
      definition = Uri.of(definition, _definition),
      code = code ?: listOf(),
      prefix = R4String.of(prefix, _prefix),
      text = R4String.of(text, _text),
      type = Enumeration.of(Questionnaire.QuestionnaireItemType.fromCode(type!!), _type),
      enableWhen = enableWhen ?: listOf(),
      enableBehavior =
        enableBehavior?.let {
          Enumeration.of(Questionnaire.EnableWhenBehavior.fromCode(it), _enableBehavior)
        },
      required = R4Boolean.of(required, _required),
      repeats = R4Boolean.of(repeats, _repeats),
      readOnly = R4Boolean.of(readOnly, _readOnly),
      maxLength = Integer.of(maxLength, _maxLength),
      answerValueSet = Canonical.of(answerValueSet, _answerValueSet),
      answerOption = answerOption ?: listOf(),
      initial = initial ?: listOf(),
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Questionnaire.Item) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.linkId.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.linkId.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.linkIdSer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.linkIdSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.codeSer, value.code)
    ((value.prefix?.value))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.prefix?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.linkIdSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.linkIdSer, it)
    }
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.linkIdSer, it)
    }
    if (value.enableWhen.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.enableWhenSer, value.enableWhen)
    ((value.enableBehavior?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.enableBehavior?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.linkIdSer, it)
    }
    ((value.required?.value))?.let { encoder.encodeBooleanElement(__desc, 17, it) }
    (value.required?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.linkIdSer, it)
    }
    ((value.repeats?.value))?.let { encoder.encodeBooleanElement(__desc, 19, it) }
    (value.repeats?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.linkIdSer, it)
    }
    ((value.readOnly?.value))?.let { encoder.encodeBooleanElement(__desc, 21, it) }
    (value.readOnly?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.linkIdSer, it)
    }
    ((value.maxLength?.value))?.let { encoder.encodeIntElement(__desc, 23, it) }
    (value.maxLength?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.linkIdSer, it)
    }
    ((value.answerValueSet?.value))?.let { encoder.encodeStringElement(__desc, 25, it) }
    (value.answerValueSet?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.linkIdSer, it)
    }
    if (value.answerOption.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.answerOptionSer, value.answerOption)
    if (value.initial.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.initialSer, value.initial)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.itemSer, value.item)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.EnableWhen {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> question = decoder.decodeStringElement(__desc, 3)
        4 ->
          _question =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.questionSer, null)
        5 -> `operator` = decoder.decodeStringElement(__desc, 5)
        6 ->
          _operator =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.questionSer, null)
        7 -> answerBoolean = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _answerBoolean =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.questionSer, null)
        9 ->
          answerDecimal =
            decoder.decodeNullableSerializableElement(__desc, 9, BigDecimalSerializer, null)
        10 ->
          _answerDecimal =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.questionSer, null)
        11 -> answerInteger = decoder.decodeIntElement(__desc, 11)
        12 ->
          _answerInteger =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.questionSer, null)
        13 -> answerDate = decoder.decodeStringElement(__desc, 13)
        14 ->
          _answerDate =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.questionSer, null)
        15 -> answerDateTime = decoder.decodeStringElement(__desc, 15)
        16 ->
          _answerDateTime =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.questionSer, null)
        17 ->
          answerTime =
            decoder.decodeNullableSerializableElement(__desc, 17, LocalTimeSerializer, null)
        18 ->
          _answerTime =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.questionSer, null)
        19 -> answerString = decoder.decodeStringElement(__desc, 19)
        20 ->
          _answerString =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.questionSer, null)
        21 ->
          answerCoding =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.answerCodingSer, null)
        22 ->
          answerQuantity =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.answerQuantitySer, null)
        23 ->
          answerReference =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.answerReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding EnableWhen: " + __i)
      }
    }
    return Questionnaire.Item.EnableWhen(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      question = R4String.of(question, _question)!!,
      `operator` =
        Enumeration.of(Questionnaire.QuestionnaireItemOperator.fromCode(`operator`!!), _operator),
      answer =
        Questionnaire.Item.EnableWhen.Answer.from(
          R4Boolean.of(answerBoolean, _answerBoolean),
          Decimal.of(answerDecimal, _answerDecimal),
          Integer.of(answerInteger, _answerInteger),
          Date.of(FhirDate.fromString(answerDate), _answerDate),
          DateTime.of(FhirDateTime.fromString(answerDateTime), _answerDateTime),
          Time.of(answerTime, _answerTime),
          R4String.of(answerString, _answerString),
          answerCoding,
          answerQuantity,
          answerReference,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Questionnaire.Item.EnableWhen) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.question.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.question.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.questionSer, it)
    }
    ((value.`operator`.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.`operator`.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.questionSer, it)
    }
    when (val __d = value.answer) {
      null -> {}
      is Questionnaire.Item.EnableWhen.Answer.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 9, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 13, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 17, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 19, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 20, Hoisted.questionSer, it)
        }
      }
      is Questionnaire.Item.EnableWhen.Answer.Coding -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.answerCodingSer, __d.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Quantity -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.answerQuantitySer, __d.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Reference -> {
        encoder.encodeSerializableElement(__desc, 23, Hoisted.answerReferenceSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.AnswerOption {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> valueInteger = decoder.decodeIntElement(__desc, 3)
        4 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueIntegerSer, null)
        5 -> valueDate = decoder.decodeStringElement(__desc, 5)
        6 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueIntegerSer, null)
        7 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 7, LocalTimeSerializer, null)
        8 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueIntegerSer, null)
        9 -> valueString = decoder.decodeStringElement(__desc, 9)
        10 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueIntegerSer, null)
        11 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.valueCodingSer, null)
        12 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueReferenceSer, null)
        13 -> initialSelected = decoder.decodeBooleanElement(__desc, 13)
        14 ->
          _initialSelected =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueIntegerSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding AnswerOption: " + __i)
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
          R4String.of(valueString, _valueString),
          valueCoding,
          valueReference,
        )!!,
      initialSelected = R4Boolean.of(initialSelected, _initialSelected),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Questionnaire.Item.AnswerOption) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is Questionnaire.Item.AnswerOption.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 5, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 7, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueIntegerSer, it)
        }
      }
      is Questionnaire.Item.AnswerOption.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 11, Hoisted.valueCodingSer, __d.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 12, Hoisted.valueReferenceSer, __d.value)
      }
    }
    ((value.initialSelected?.value))?.let { encoder.encodeBooleanElement(__desc, 13, it) }
    (value.initialSelected?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.valueIntegerSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.Initial {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> valueBoolean = decoder.decodeBooleanElement(__desc, 3)
        4 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueBooleanSer, null)
        5 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 5, BigDecimalSerializer, null)
        6 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.valueBooleanSer, null)
        7 -> valueInteger = decoder.decodeIntElement(__desc, 7)
        8 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueBooleanSer, null)
        9 -> valueDate = decoder.decodeStringElement(__desc, 9)
        10 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.valueBooleanSer, null)
        11 -> valueDateTime = decoder.decodeStringElement(__desc, 11)
        12 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.valueBooleanSer, null)
        13 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 13, LocalTimeSerializer, null)
        14 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.valueBooleanSer, null)
        15 -> valueString = decoder.decodeStringElement(__desc, 15)
        16 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueBooleanSer, null)
        17 -> valueUri = decoder.decodeStringElement(__desc, 17)
        18 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valueBooleanSer, null)
        19 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.valueAttachmentSer, null)
        20 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.valueCodingSer, null)
        21 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.valueQuantitySer, null)
        22 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Initial: " + __i)
      }
    }
    return Questionnaire.Item.Initial(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        Questionnaire.Item.Initial.Value.from(
          R4Boolean.of(valueBoolean, _valueBoolean),
          Decimal.of(valueDecimal, _valueDecimal),
          Integer.of(valueInteger, _valueInteger),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Time.of(valueTime, _valueTime),
          R4String.of(valueString, _valueString),
          Uri.of(valueUri, _valueUri),
          valueAttachment,
          valueCoding,
          valueQuantity,
          valueReference,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Questionnaire.Item.Initial) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is Questionnaire.Item.Initial.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 13, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueBooleanSer, it)
        }
      }
      is Questionnaire.Item.Initial.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.valueAttachmentSer, __d.value)
      }
      is Questionnaire.Item.Initial.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.valueCodingSer, __d.value)
      }
      is Questionnaire.Item.Initial.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.valueQuantitySer, __d.value)
      }
      is Questionnaire.Item.Initial.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.valueReferenceSer, __d.value)
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

internal object QuestionnaireItemEnableWhenAnswerSerializer :
  KSerializer<Questionnaire.Item.EnableWhen.Answer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire.Item.EnableWhen.Answer") {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen.Answer) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Questionnaire.Item.EnableWhen.Answer.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 2, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 10, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 12, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.EnableWhen.Answer.Coding -> {
          encodeSerializableElement(__desc, 14, Hoisted.answerCodingSer, __d.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Quantity -> {
          encodeSerializableElement(__desc, 15, Hoisted.answerQuantitySer, __d.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Reference -> {
          encodeSerializableElement(__desc, 16, Hoisted.answerReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen.Answer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.EnableWhen.Answer {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> answerBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _answerBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          answerDecimal =
            decoder.decodeNullableSerializableElement(__desc, 2, BigDecimalSerializer, null)
        3 ->
          _answerDecimal =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> answerInteger = decoder.decodeIntElement(__desc, 4)
        5 ->
          _answerInteger =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> answerDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _answerDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> answerDateTime = decoder.decodeStringElement(__desc, 8)
        9 ->
          _answerDateTime =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 ->
          answerTime =
            decoder.decodeNullableSerializableElement(__desc, 10, LocalTimeSerializer, null)
        11 ->
          _answerTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 -> answerString = decoder.decodeStringElement(__desc, 12)
        13 ->
          _answerString =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 ->
          answerCoding =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.answerCodingSer, null)
        15 ->
          answerQuantity =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.answerQuantitySer, null)
        16 ->
          answerReference =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.answerReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Questionnaire.Item.EnableWhen.Answer: " + __i
          )
      }
    }
    return Questionnaire.Item.EnableWhen.Answer.from(
      R4Boolean.of(answerBoolean, _answerBoolean),
      Decimal.of(answerDecimal, _answerDecimal),
      Integer.of(answerInteger, _answerInteger),
      Date.of(FhirDate.fromString(answerDate), _answerDate),
      DateTime.of(FhirDateTime.fromString(answerDateTime), _answerDateTime),
      Time.of(answerTime, _answerTime),
      R4String.of(answerString, _answerString),
      answerCoding,
      answerQuantity,
      answerReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val answerCodingSer: KSerializer<Coding> = Coding.serializer()

    public val answerQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val answerReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object QuestionnaireItemAnswerOptionValueSerializer :
  KSerializer<Questionnaire.Item.AnswerOption.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire.Item.AnswerOption.Value") {
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
    }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Questionnaire.Item.AnswerOption.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.AnswerOption.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 2, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.AnswerOption.Value.Time -> {
          ((__d.value.value))?.let { encodeSerializableElement(__desc, 4, LocalTimeSerializer, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.AnswerOption.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.AnswerOption.Value.Coding -> {
          encodeSerializableElement(__desc, 8, Hoisted.valueCodingSer, __d.value)
        }
        is Questionnaire.Item.AnswerOption.Value.Reference -> {
          encodeSerializableElement(__desc, 9, Hoisted.valueReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.AnswerOption.Value {
    val __desc = descriptor
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
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> valueInteger = decoder.decodeIntElement(__desc, 0)
        1 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 -> valueDate = decoder.decodeStringElement(__desc, 2)
        3 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 4, LocalTimeSerializer, null)
        5 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueCodingSer, null)
        9 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Questionnaire.Item.AnswerOption.Value: " + __i
          )
      }
    }
    return Questionnaire.Item.AnswerOption.Value.from(
      Integer.of(valueInteger, _valueInteger),
      Date.of(FhirDate.fromString(valueDate), _valueDate),
      Time.of(valueTime, _valueTime),
      R4String.of(valueString, _valueString),
      valueCoding,
      valueReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val valueCodingSer: KSerializer<Coding> = Coding.serializer()

    public val valueReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object QuestionnaireItemInitialValueSerializer :
  KSerializer<Questionnaire.Item.Initial.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Questionnaire.Item.Initial.Value") {
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

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Questionnaire.Item.Initial.Value.Boolean -> {
          ((__d.value.value))?.let { encodeBooleanElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Decimal -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 2, BigDecimalSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 3, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Integer -> {
          ((__d.value.value))?.let { encodeIntElement(__desc, 4, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 5, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 6, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 7, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.DateTime -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 8, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 9, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Time -> {
          ((__d.value.value))?.let {
            encodeSerializableElement(__desc, 10, LocalTimeSerializer, it)
          }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 11, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.String -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 12, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 13, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Uri -> {
          ((__d.value.value))?.let { encodeStringElement(__desc, 14, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 15, Hoisted.elementSer, it)
          }
        }
        is Questionnaire.Item.Initial.Value.Attachment -> {
          encodeSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, __d.value)
        }
        is Questionnaire.Item.Initial.Value.Coding -> {
          encodeSerializableElement(__desc, 17, Hoisted.valueCodingSer, __d.value)
        }
        is Questionnaire.Item.Initial.Value.Quantity -> {
          encodeSerializableElement(__desc, 18, Hoisted.valueQuantitySer, __d.value)
        }
        is Questionnaire.Item.Initial.Value.Reference -> {
          encodeSerializableElement(__desc, 19, Hoisted.valueReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Questionnaire.Item.Initial.Value {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> valueBoolean = decoder.decodeBooleanElement(__desc, 0)
        1 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 2, BigDecimalSerializer, null)
        3 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.elementSer, null)
        4 -> valueInteger = decoder.decodeIntElement(__desc, 4)
        5 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.elementSer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, 6)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.elementSer, null)
        8 -> valueDateTime = decoder.decodeStringElement(__desc, 8)
        9 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.elementSer, null)
        10 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, 10, LocalTimeSerializer, null)
        11 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.elementSer, null)
        12 -> valueString = decoder.decodeStringElement(__desc, 12)
        13 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.elementSer, null)
        14 -> valueUri = decoder.decodeStringElement(__desc, 14)
        15 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.elementSer, null)
        16 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.valueAttachmentSer, null)
        17 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.valueCodingSer, null)
        18 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.valueQuantitySer, null)
        19 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.valueReferenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Questionnaire.Item.Initial.Value: " + __i
          )
      }
    }
    return Questionnaire.Item.Initial.Value.from(
      R4Boolean.of(valueBoolean, _valueBoolean),
      Decimal.of(valueDecimal, _valueDecimal),
      Integer.of(valueInteger, _valueInteger),
      Date.of(FhirDate.fromString(valueDate), _valueDate),
      DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
      Time.of(valueTime, _valueTime),
      R4String.of(valueString, _valueString),
      Uri.of(valueUri, _valueUri),
      valueAttachment,
      valueCoding,
      valueQuantity,
      valueReference,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "derivedFrom",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_derivedFrom",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element(
        "subjectType",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_subjectType",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("purpose", KotlinString.serializer().descriptor, isOptional = true)
      element("_purpose", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("code", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { Questionnaire.Item.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Questionnaire =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Questionnaire) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Questionnaire {
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
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> name = decoder.decodeStringElement(__desc, 16)
        17 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 -> title = decoder.decodeStringElement(__desc, 18)
        19 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.derivedFromSer, null)
        21 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.derivedFromSer2, null)
        22 -> status = decoder.decodeStringElement(__desc, 22)
        23 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 -> experimental = decoder.decodeBooleanElement(__desc, 24)
        25 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 ->
          subjectType =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.derivedFromSer, null)
        27 ->
          _subjectType =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.derivedFromSer2, null)
        28 -> date = decoder.decodeStringElement(__desc, 28)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, 30)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(__desc, 33)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.jurisdictionSer, null)
        37 -> purpose = decoder.decodeStringElement(__desc, 37)
        38 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 -> copyright = decoder.decodeStringElement(__desc, 39)
        40 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 -> approvalDate = decoder.decodeStringElement(__desc, 41)
        42 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.implicitRulesSer, null)
        43 -> lastReviewDate = decoder.decodeStringElement(__desc, 43)
        44 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 44, Hoisted.implicitRulesSer, null)
        45 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.effectivePeriodSer, null)
        46 -> code = decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.codeSer, null)
        47 -> item = decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Questionnaire: " + __i)
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
      version = R4String.of(version, _version),
      name = R4String.of(name, _name),
      title = R4String.of(title, _title),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { __i ->
          Canonical.of(derivedFrom?.getOrNull(__i)?.let { it }, _derivedFrom?.getOrNull(__i))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4Boolean.of(experimental, _experimental),
      subjectType =
        (kotlin.collections.List(maxOf(subjectType?.size ?: 0, _subjectType?.size ?: 0)) { __i ->
          Enumeration.of(
            ResourceType.fromCode(subjectType?.getOrNull(__i)!!),
            _subjectType?.getOrNull(__i),
          )
        }),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4String.of(publisher, _publisher),
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Questionnaire) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Questionnaire")
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
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 18, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
    }
    (value.derivedFrom.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.derivedFromSer, it)
    }
    (value.derivedFrom.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.derivedFromSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 24, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    (value.subjectType.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.derivedFromSer, it)
    }
    (value.subjectType.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.derivedFromSer2, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.purpose?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.purpose?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 43, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 45, Hoisted.effectivePeriodSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.codeSer, value.code)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.itemSer, value.item)
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
