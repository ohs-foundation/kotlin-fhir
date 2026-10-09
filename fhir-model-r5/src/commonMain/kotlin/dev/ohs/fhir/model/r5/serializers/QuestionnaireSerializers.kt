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

import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Canonical
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.ContactDetail
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Questionnaire
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.UsageContext
import dev.ohs.fhir.model.r5.terminologies.EnableWhenBehavior
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.QuestionnaireAnswerConstraint
import dev.ohs.fhir.model.r5.terminologies.QuestionnaireItemDisabledDisplay
import dev.ohs.fhir.model.r5.terminologies.QuestionnaireItemOperator
import dev.ohs.fhir.model.r5.terminologies.QuestionnaireItemType
import dev.ohs.fhir.model.r5.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.datetime.LocalTime
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

internal object QuestionnaireItemSerializer : FhirSerializer<Questionnaire.Item> {
  override val descriptor: SerialDescriptor = buildDescriptor("Item", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Questionnaire.Item>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("linkId")
    b.strPrim("definition")
    b.optionalElement("code", CodingSerializer.listSerializer.descriptor)
    b.strPrim("prefix")
    b.strPrim("text")
    b.strPrim("type")
    b.optionalElement("enableWhen", QuestionnaireItemEnableWhenSerializer.listSerializer.descriptor)
    b.strPrim("enableBehavior")
    b.strPrim("disabledDisplay")
    b.boolPrim("required")
    b.boolPrim("repeats")
    b.boolPrim("readOnly")
    b.intPrim("maxLength")
    b.strPrim("answerConstraint")
    b.strPrim("answerValueSet")
    b.optionalElement(
      "answerOption",
      QuestionnaireItemAnswerOptionSerializer.listSerializer.descriptor,
    )
    b.optionalElement("initial", QuestionnaireItemInitialSerializer.listSerializer.descriptor)
    b.optionalElement(
      "item",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.QuestionnaireItemSerializer)),
    )
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
    var type: QuestionnaireItemType? = null
    var _type: Element? = null
    var enableWhen: List<Questionnaire.Item.EnableWhen>? = null
    var enableBehavior: EnableWhenBehavior? = null
    var _enableBehavior: Element? = null
    var disabledDisplay: QuestionnaireItemDisabledDisplay? = null
    var _disabledDisplay: Element? = null
    var required: KotlinBoolean? = null
    var _required: Element? = null
    var repeats: KotlinBoolean? = null
    var _repeats: Element? = null
    var readOnly: KotlinBoolean? = null
    var _readOnly: Element? = null
    var maxLength: Int? = null
    var _maxLength: Element? = null
    var answerConstraint: QuestionnaireAnswerConstraint? = null
    var _answerConstraint: Element? = null
    var answerValueSet: KotlinString? = null
    var _answerValueSet: Element? = null
    var answerOption: List<Questionnaire.Item.AnswerOption>? = null
    var initial: List<Questionnaire.Item.Initial>? = null
    var item: List<Questionnaire.Item>? = null
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
        3 -> linkId = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> definition = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        8 -> prefix = compositeDecoder.decodeStringElement(descriptor, i)
        9 ->
          _prefix =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        10 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          type = QuestionnaireItemType.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        13 ->
          _type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        14 ->
          enableWhen =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemEnableWhenSerializer.listSerializer,
              null,
            )
        15 ->
          enableBehavior =
            EnableWhenBehavior.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _enableBehavior =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          disabledDisplay =
            QuestionnaireItemDisabledDisplay.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        18 ->
          _disabledDisplay =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> required = compositeDecoder.decodeBooleanElement(descriptor, i)
        20 ->
          _required =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 -> repeats = compositeDecoder.decodeBooleanElement(descriptor, i)
        22 ->
          _repeats =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        23 -> readOnly = compositeDecoder.decodeBooleanElement(descriptor, i)
        24 ->
          _readOnly =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        25 -> maxLength = compositeDecoder.decodeIntElement(descriptor, i)
        26 ->
          _maxLength =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 ->
          answerConstraint =
            QuestionnaireAnswerConstraint.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        28 ->
          _answerConstraint =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 -> answerValueSet = compositeDecoder.decodeStringElement(descriptor, i)
        30 ->
          _answerValueSet =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        31 ->
          answerOption =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemAnswerOptionSerializer.listSerializer,
              null,
            )
        32 ->
          initial =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemInitialSerializer.listSerializer,
              null,
            )
        33 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Questionnaire.Item(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      linkId = required(R5String.of(linkId, _linkId), "Questionnaire.Item", "linkId"),
      definition = Uri.of(definition, _definition),
      code = listOrEmpty(code),
      prefix = R5String.of(prefix, _prefix),
      text = R5String.of(text, _text),
      type = required(Enumeration.of(type, _type), "Questionnaire.Item", "type"),
      enableWhen = listOrEmpty(enableWhen),
      enableBehavior = Enumeration.of(enableBehavior, _enableBehavior),
      disabledDisplay = Enumeration.of(disabledDisplay, _disabledDisplay),
      required = R5Boolean.of(required, _required),
      repeats = R5Boolean.of(repeats, _repeats),
      readOnly = R5Boolean.of(readOnly, _readOnly),
      maxLength = Integer.of(maxLength, _maxLength),
      answerConstraint = Enumeration.of(answerConstraint, _answerConstraint),
      answerValueSet = Canonical.of(answerValueSet, _answerValueSet),
      answerOption = listOrEmpty(answerOption),
      initial = listOrEmpty(initial),
      item = listOrEmpty(item),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.definition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.definition)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CodingSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 8, value.prefix?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 9, value.prefix)
    compositeEncoder.encodeStringIfNotNull(descriptor, 10, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11, value.text)
    compositeEncoder.encodeStringIfNotNull(descriptor, 12, value.type.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 13, value.type)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14,
      QuestionnaireItemEnableWhenSerializer.listSerializer,
      value.enableWhen,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 15, value.enableBehavior?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 16, value.enableBehavior)
    compositeEncoder.encodeStringIfNotNull(descriptor, 17, value.disabledDisplay?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.disabledDisplay)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 19, value.required?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 20, value.required)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 21, value.repeats?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 22, value.repeats)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 23, value.readOnly?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 24, value.readOnly)
    compositeEncoder.encodeIntIfNotNull(descriptor, 25, value.maxLength?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26, value.maxLength)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27, value.answerConstraint?.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28, value.answerConstraint)
    compositeEncoder.encodeStringIfNotNull(descriptor, 29, value.answerValueSet?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 30, value.answerValueSet)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      31,
      QuestionnaireItemAnswerOptionSerializer.listSerializer,
      value.answerOption,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      32,
      QuestionnaireItemInitialSerializer.listSerializer,
      value.initial,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33,
      QuestionnaireItemSerializer.listSerializer,
      value.item,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireItemEnableWhenSerializer :
  FhirSerializer<Questionnaire.Item.EnableWhen> {
  override val descriptor: SerialDescriptor = buildDescriptor("EnableWhen", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Questionnaire.Item.EnableWhen>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.strPrim("question")
    b.strPrim("operator")
    b.boolPrim("answerBoolean")
    b.prim("answerDecimal", FhirDecimalSerializer.descriptor)
    b.intPrim("answerInteger")
    b.strPrim("answerDate")
    b.strPrim("answerDateTime")
    b.prim("answerTime", LocalTimeSerializer.descriptor)
    b.strPrim("answerString")
    b.optionalElement("answerCoding", CodingSerializer.descriptor)
    b.optionalElement("answerQuantity", QuantitySerializer.descriptor)
    b.optionalElement("answerReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var question: KotlinString? = null
    var _question: Element? = null
    var `operator`: QuestionnaireItemOperator? = null
    var _operator: Element? = null
    var answerBoolean: KotlinBoolean? = null
    var _answerBoolean: Element? = null
    var answerDecimal: FhirDecimal? = null
    var _answerDecimal: Element? = null
    var answerInteger: Int? = null
    var _answerInteger: Element? = null
    var answerDate: FhirDate? = null
    var _answerDate: Element? = null
    var answerDateTime: FhirDateTime? = null
    var _answerDateTime: Element? = null
    var answerTime: LocalTime? = null
    var _answerTime: Element? = null
    var answerString: KotlinString? = null
    var _answerString: Element? = null
    var answerCoding: Coding? = null
    var answerQuantity: Quantity? = null
    var answerReference: Reference? = null
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
        3 -> question = compositeDecoder.decodeStringElement(descriptor, i)
        4 ->
          _question =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          `operator` =
            QuestionnaireItemOperator.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _operator =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> answerBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _answerBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          answerDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        10 ->
          _answerDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> answerInteger = compositeDecoder.decodeIntElement(descriptor, i)
        12 ->
          _answerInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 -> answerDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        14 ->
          _answerDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 ->
          answerDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        16 ->
          _answerDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          answerTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        18 ->
          _answerTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 -> answerString = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _answerString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          answerCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        22 ->
          answerQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        23 ->
          answerReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Questionnaire.Item.EnableWhen(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      question =
        required(R5String.of(question, _question), "Questionnaire.Item.EnableWhen", "question"),
      `operator` =
        required(
          Enumeration.of(`operator`, _operator),
          "Questionnaire.Item.EnableWhen",
          "operator",
        ),
      answer =
        required(
          Questionnaire.Item.EnableWhen.Answer.from(
            R5Boolean.of(answerBoolean, _answerBoolean),
            Decimal.of(answerDecimal, _answerDecimal),
            Integer.of(answerInteger, _answerInteger),
            Date.of(answerDate, _answerDate),
            DateTime.of(answerDateTime, _answerDateTime),
            Time.of(answerTime, _answerTime),
            R5String.of(answerString, _answerString),
            answerCoding,
            answerQuantity,
            answerReference,
          ),
          "Questionnaire.Item.EnableWhen",
          "answer",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen) {
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.question.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.question)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.`operator`.value?.code)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.`operator`)
    when (val choice = value.answer) {
      is Questionnaire.Item.EnableWhen.Answer.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          9,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          17,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 19, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 20, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, CodingSerializer, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 22, QuantitySerializer, choice.value)
      }
      is Questionnaire.Item.EnableWhen.Answer.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          23,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireItemAnswerOptionSerializer :
  FhirSerializer<Questionnaire.Item.AnswerOption> {
  override val descriptor: SerialDescriptor = buildDescriptor("AnswerOption", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Questionnaire.Item.AnswerOption>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.intPrim("valueInteger")
    b.strPrim("valueDate")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.strPrim("valueString")
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
    b.boolPrim("initialSelected")
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: FhirDate? = null
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
        3 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        4 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        6 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        8 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        12 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        13 -> initialSelected = compositeDecoder.decodeBooleanElement(descriptor, i)
        14 ->
          _initialSelected =
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
    return Questionnaire.Item.AnswerOption(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` =
        required(
          Questionnaire.Item.AnswerOption.Value.from(
            Integer.of(valueInteger, _valueInteger),
            Date.of(valueDate, _valueDate),
            Time.of(valueTime, _valueTime),
            R5String.of(valueString, _valueString),
            valueCoding,
            valueReference,
          ),
          "Questionnaire.Item.AnswerOption",
          "value",
        ),
      initialSelected = R5Boolean.of(initialSelected, _initialSelected),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption) {
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
    when (val choice = value.`value`) {
      is Questionnaire.Item.AnswerOption.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 5, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          7,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 11, CodingSerializer, choice.value)
      }
      is Questionnaire.Item.AnswerOption.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          12,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 13, value.initialSelected?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14, value.initialSelected)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireItemInitialSerializer : FhirSerializer<Questionnaire.Item.Initial> {
  override val descriptor: SerialDescriptor = buildDescriptor("Initial", this)

  @JvmField
  internal val listSerializer: KSerializer<List<Questionnaire.Item.Initial>> = ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.boolPrim("valueBoolean")
    b.prim("valueDecimal", FhirDecimalSerializer.descriptor)
    b.intPrim("valueInteger")
    b.strPrim("valueDate")
    b.strPrim("valueDateTime")
    b.prim("valueTime", LocalTimeSerializer.descriptor)
    b.strPrim("valueString")
    b.strPrim("valueUri")
    b.optionalElement("valueAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("valueCoding", CodingSerializer.descriptor)
    b.optionalElement("valueQuantity", QuantitySerializer.descriptor)
    b.optionalElement("valueReference", ReferenceSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var valueBoolean: KotlinBoolean? = null
    var _valueBoolean: Element? = null
    var valueDecimal: FhirDecimal? = null
    var _valueDecimal: Element? = null
    var valueInteger: Int? = null
    var _valueInteger: Element? = null
    var valueDate: FhirDate? = null
    var _valueDate: Element? = null
    var valueDateTime: FhirDateTime? = null
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
        3 -> valueBoolean = compositeDecoder.decodeBooleanElement(descriptor, i)
        4 ->
          _valueBoolean =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        5 ->
          valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              FhirDecimalSerializer,
              null,
            )
        6 ->
          _valueDecimal =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        7 -> valueInteger = compositeDecoder.decodeIntElement(descriptor, i)
        8 ->
          _valueInteger =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> valueDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        10 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 ->
          valueDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        12 ->
          _valueDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              LocalTimeSerializer,
              null,
            )
        14 ->
          _valueTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> valueString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _valueString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 -> valueUri = compositeDecoder.decodeStringElement(descriptor, i)
        18 ->
          _valueUri =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          valueAttachment =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AttachmentSerializer,
              null,
            )
        20 ->
          valueCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        21 ->
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        22 ->
          valueReference =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Questionnaire.Item.Initial(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      `value` =
        required(
          Questionnaire.Item.Initial.Value.from(
            R5Boolean.of(valueBoolean, _valueBoolean),
            Decimal.of(valueDecimal, _valueDecimal),
            Integer.of(valueInteger, _valueInteger),
            Date.of(valueDate, _valueDate),
            DateTime.of(valueDateTime, _valueDateTime),
            Time.of(valueTime, _valueTime),
            R5String.of(valueString, _valueString),
            Uri.of(valueUri, _valueUri),
            valueAttachment,
            valueCoding,
            valueQuantity,
            valueReference,
          ),
          "Questionnaire.Item.Initial",
          "value",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial) {
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
    when (val choice = value.`value`) {
      is Questionnaire.Item.Initial.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          5,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is Questionnaire.Item.Initial.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          13,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is Questionnaire.Item.Initial.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Questionnaire.Item.Initial.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
      }
      is Questionnaire.Item.Initial.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          22,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireSerializer : FhirResourceSerializer<Questionnaire> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Questionnaire")

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
    b.strPrim("url")
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("version")
    b.strPrim("versionAlgorithmString")
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.strPrim("name")
    b.strPrim("title")
    b.strPrimList("derivedFrom")
    b.strPrim("status")
    b.boolPrim("experimental")
    b.strPrimList("subjectType")
    b.strPrim("date")
    b.strPrim("publisher")
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.strPrim("description")
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.strPrim("purpose")
    b.strPrim("copyright")
    b.strPrim("copyrightLabel")
    b.strPrim("approvalDate")
    b.strPrim("lastReviewDate")
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("code", CodingSerializer.listSerializer.descriptor)
    b.optionalElement("item", QuestionnaireItemSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var derivedFrom: List<KotlinString?>? = null
    var _derivedFrom: List<Element?>? = null
    var status: PublicationStatus? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var subjectType: List<KotlinString?>? = null
    var _subjectType: List<Element?>? = null
    var date: FhirDateTime? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
    var approvalDate: FhirDate? = null
    var _approvalDate: Element? = null
    var lastReviewDate: FhirDate? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var code: List<Coding>? = null
    var item: List<Questionnaire.Item>? = null
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
        10 -> url = compositeDecoder.decodeStringElement(descriptor, i)
        11 ->
          _url =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        12 ->
          identifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> versionAlgorithmString = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          versionAlgorithmCoding =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer,
              null,
            )
        18 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        19 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        20 -> title = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _title =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          derivedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        23 ->
          _derivedFrom =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        24 ->
          status = PublicationStatus.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> experimental = compositeDecoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          subjectType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        29 ->
          _subjectType =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        30 -> date = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        31 ->
          _date =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 -> publisher = compositeDecoder.decodeStringElement(descriptor, i)
        33 ->
          _publisher =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        34 ->
          contact =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        35 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        36 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        37 ->
          useContext =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        38 ->
          jurisdiction =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        39 -> purpose = compositeDecoder.decodeStringElement(descriptor, i)
        40 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        41 -> copyright = compositeDecoder.decodeStringElement(descriptor, i)
        42 ->
          _copyright =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        43 -> copyrightLabel = compositeDecoder.decodeStringElement(descriptor, i)
        44 ->
          _copyrightLabel =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        45 ->
          approvalDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        46 ->
          _approvalDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        47 ->
          lastReviewDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        48 ->
          _lastReviewDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        49 ->
          effectivePeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        50 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        51 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val derivedFrom_ =
      List(maxSize(derivedFrom, _derivedFrom)) { index ->
        entryRequired(
          Canonical.of(at(derivedFrom, index), at(_derivedFrom, index)),
          "Questionnaire",
          "derivedFrom",
        )
      }
    val subjectType_ =
      List(maxSize(subjectType, _subjectType)) { index ->
        entryRequired(
          Enumeration.of(
            at(subjectType, index)?.let { ResourceType.fromCode(it) },
            at(_subjectType, index),
          ),
          "Questionnaire",
          "subjectType",
        )
      }
    return Questionnaire(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      url = Uri.of(url, _url),
      identifier = listOrEmpty(identifier),
      version = R5String.of(version, _version),
      versionAlgorithm =
        Questionnaire.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      derivedFrom = derivedFrom_,
      status = required(Enumeration.of(status, _status), "Questionnaire", "status"),
      experimental = R5Boolean.of(experimental, _experimental),
      subjectType = subjectType_,
      date = DateTime.of(date, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = listOrEmpty(contact),
      description = Markdown.of(description, _description),
      useContext = listOrEmpty(useContext),
      jurisdiction = listOrEmpty(jurisdiction),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate = Date.of(approvalDate, _approvalDate),
      lastReviewDate = Date.of(lastReviewDate, _lastReviewDate),
      effectivePeriod = effectivePeriod,
      code = listOrEmpty(code),
      item = listOrEmpty(item),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Questionnaire,
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
    compositeEncoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      12 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Questionnaire.VersionAlgorithm.String -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          15 + descriptorOffset,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is Questionnaire.VersionAlgorithm.Coding -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    if (!value.derivedFrom.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFrom.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        23 + descriptorOffset,
        value.derivedFrom,
      )
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.experimental?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    if (!value.subjectType.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        28 + descriptorOffset,
        stringNullableListSerializer,
        value.subjectType.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(
        descriptor,
        29 + descriptorOffset,
        value.subjectType,
      )
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.date?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.date)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      32 + descriptorOffset,
      value.publisher?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.publisher)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      34 + descriptorOffset,
      ContactDetailSerializer.listSerializer,
      value.contact,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      35 + descriptorOffset,
      value.description?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.description)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      37 + descriptorOffset,
      UsageContextSerializer.listSerializer,
      value.useContext,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      38 + descriptorOffset,
      CodeableConceptSerializer.listSerializer,
      value.jurisdiction,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.purpose?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.purpose)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      41 + descriptorOffset,
      value.copyright?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyright)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      43 + descriptorOffset,
      value.copyrightLabel?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.copyrightLabel)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.approvalDate)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      47 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.lastReviewDate)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      50 + descriptorOffset,
      CodingSerializer.listSerializer,
      value.code,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      51 + descriptorOffset,
      QuestionnaireItemSerializer.listSerializer,
      value.item,
    )
  }
}
