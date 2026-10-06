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
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import dev.ohs.fhir.model.r5.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object QuestionnaireItemSerializer : KSerializer<Questionnaire.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("code", CodingSerializer.listSerializer.descriptor)
      optionalElement("prefix", KotlinString.serializer().descriptor)
      optionalElement("_prefix", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("enableWhen", QuestionnaireItemEnableWhenSerializer.listSerializer.descriptor)
      optionalElement("enableBehavior", KotlinString.serializer().descriptor)
      optionalElement("_enableBehavior", ElementSerializer.descriptor)
      optionalElement("disabledDisplay", KotlinString.serializer().descriptor)
      optionalElement("_disabledDisplay", ElementSerializer.descriptor)
      optionalElement("required", KotlinBoolean.serializer().descriptor)
      optionalElement("_required", ElementSerializer.descriptor)
      optionalElement("repeats", KotlinBoolean.serializer().descriptor)
      optionalElement("_repeats", ElementSerializer.descriptor)
      optionalElement("readOnly", KotlinBoolean.serializer().descriptor)
      optionalElement("_readOnly", ElementSerializer.descriptor)
      optionalElement("maxLength", Int.serializer().descriptor)
      optionalElement("_maxLength", ElementSerializer.descriptor)
      optionalElement("answerConstraint", KotlinString.serializer().descriptor)
      optionalElement("_answerConstraint", ElementSerializer.descriptor)
      optionalElement("answerValueSet", KotlinString.serializer().descriptor)
      optionalElement("_answerValueSet", ElementSerializer.descriptor)
      optionalElement(
        "answerOption",
        QuestionnaireItemAnswerOptionSerializer.listSerializer.descriptor,
      )
      optionalElement("initial", QuestionnaireItemInitialSerializer.listSerializer.descriptor)
      optionalElement(
        "item",
        listSerialDescriptor(lazyDescriptor { QuestionnaireItemSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Questionnaire.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Questionnaire.Item =
    decoder.decodeStructure(descriptor) {
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
      var disabledDisplay: KotlinString? = null
      var _disabledDisplay: Element? = null
      var required: KotlinBoolean? = null
      var _required: Element? = null
      var repeats: KotlinBoolean? = null
      var _repeats: Element? = null
      var readOnly: KotlinBoolean? = null
      var _readOnly: Element? = null
      var maxLength: Int? = null
      var _maxLength: Element? = null
      var answerConstraint: KotlinString? = null
      var _answerConstraint: Element? = null
      var answerValueSet: KotlinString? = null
      var _answerValueSet: Element? = null
      var answerOption: List<Questionnaire.Item.AnswerOption>? = null
      var initial: List<Questionnaire.Item.Initial>? = null
      var item: List<Questionnaire.Item>? = null
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
          3 -> linkId = decodeStringElement(descriptor, i)
          4 -> _linkId = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> definition = decodeStringElement(descriptor, i)
          6 ->
            _definition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          8 -> prefix = decodeStringElement(descriptor, i)
          9 -> _prefix = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> text = decodeStringElement(descriptor, i)
          11 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 -> type = decodeStringElement(descriptor, i)
          13 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 ->
            enableWhen =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuestionnaireItemEnableWhenSerializer.listSerializer,
                null,
              )
          15 -> enableBehavior = decodeStringElement(descriptor, i)
          16 ->
            _enableBehavior =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> disabledDisplay = decodeStringElement(descriptor, i)
          18 ->
            _disabledDisplay =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> required = decodeBooleanElement(descriptor, i)
          20 ->
            _required = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 -> repeats = decodeBooleanElement(descriptor, i)
          22 -> _repeats = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          23 -> readOnly = decodeBooleanElement(descriptor, i)
          24 ->
            _readOnly = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          25 -> maxLength = decodeIntElement(descriptor, i)
          26 ->
            _maxLength = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          27 -> answerConstraint = decodeStringElement(descriptor, i)
          28 ->
            _answerConstraint =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          29 -> answerValueSet = decodeStringElement(descriptor, i)
          30 ->
            _answerValueSet =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          31 ->
            answerOption =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuestionnaireItemAnswerOptionSerializer.listSerializer,
                null,
              )
          32 ->
            initial =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuestionnaireItemInitialSerializer.listSerializer,
                null,
              )
          33 ->
            item =
              decodeNullableSerializableElement(
                descriptor,
                i,
                QuestionnaireItemSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      Questionnaire.Item(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        linkId =
          R5String.of(linkId, _linkId)
            ?: throw SerializationException(
              "Missing required property 'linkId' on Questionnaire.Item"
            ),
        definition = Uri.of(definition, _definition),
        code = code ?: listOf(),
        prefix = R5String.of(prefix, _prefix),
        text = R5String.of(text, _text),
        type =
          Enumeration.of(
            if (type != null) Questionnaire.QuestionnaireItemType.fromCode(type) else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on Questionnaire.Item"
            ),
        enableWhen = enableWhen ?: listOf(),
        enableBehavior =
          Enumeration.of(
            if (enableBehavior != null) Questionnaire.EnableWhenBehavior.fromCode(enableBehavior)
            else null,
            _enableBehavior,
          ),
        disabledDisplay =
          Enumeration.of(
            if (disabledDisplay != null)
              Questionnaire.QuestionnaireItemDisabledDisplay.fromCode(disabledDisplay)
            else null,
            _disabledDisplay,
          ),
        required = R5Boolean.of(required, _required),
        repeats = R5Boolean.of(repeats, _repeats),
        readOnly = R5Boolean.of(readOnly, _readOnly),
        maxLength = Integer.of(maxLength, _maxLength),
        answerConstraint =
          Enumeration.of(
            if (answerConstraint != null)
              Questionnaire.QuestionnaireAnswerConstraint.fromCode(answerConstraint)
            else null,
            _answerConstraint,
          ),
        answerValueSet = Canonical.of(answerValueSet, _answerValueSet),
        answerOption = answerOption ?: listOf(),
        initial = initial ?: listOf(),
        item = item ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item) {
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
      encodeStringIfNotNull(descriptor, 3, value.linkId.value)
      encodeElementIfNotNull(descriptor, 4, value.linkId)
      encodeStringIfNotNull(descriptor, 5, value.definition?.value)
      encodeElementIfNotNull(descriptor, 6, value.definition)
      if (value.code.isNotEmpty())
        encodeSerializableElement(descriptor, 7, CodingSerializer.listSerializer, value.code)
      encodeStringIfNotNull(descriptor, 8, value.prefix?.value)
      encodeElementIfNotNull(descriptor, 9, value.prefix)
      encodeStringIfNotNull(descriptor, 10, value.text?.value)
      encodeElementIfNotNull(descriptor, 11, value.text)
      encodeStringIfNotNull(descriptor, 12, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 13, value.type)
      if (value.enableWhen.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          14,
          QuestionnaireItemEnableWhenSerializer.listSerializer,
          value.enableWhen,
        )
      encodeStringIfNotNull(descriptor, 15, value.enableBehavior?.value?.code)
      encodeElementIfNotNull(descriptor, 16, value.enableBehavior)
      encodeStringIfNotNull(descriptor, 17, value.disabledDisplay?.value?.code)
      encodeElementIfNotNull(descriptor, 18, value.disabledDisplay)
      encodeBooleanIfNotNull(descriptor, 19, value.required?.value)
      encodeElementIfNotNull(descriptor, 20, value.required)
      encodeBooleanIfNotNull(descriptor, 21, value.repeats?.value)
      encodeElementIfNotNull(descriptor, 22, value.repeats)
      encodeBooleanIfNotNull(descriptor, 23, value.readOnly?.value)
      encodeElementIfNotNull(descriptor, 24, value.readOnly)
      encodeIntIfNotNull(descriptor, 25, value.maxLength?.value)
      encodeElementIfNotNull(descriptor, 26, value.maxLength)
      encodeStringIfNotNull(descriptor, 27, value.answerConstraint?.value?.code)
      encodeElementIfNotNull(descriptor, 28, value.answerConstraint)
      encodeStringIfNotNull(descriptor, 29, value.answerValueSet?.value)
      encodeElementIfNotNull(descriptor, 30, value.answerValueSet)
      if (value.answerOption.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          31,
          QuestionnaireItemAnswerOptionSerializer.listSerializer,
          value.answerOption,
        )
      if (value.initial.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          32,
          QuestionnaireItemInitialSerializer.listSerializer,
          value.initial,
        )
      if (value.item.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          33,
          QuestionnaireItemSerializer.listSerializer,
          value.item,
        )
    }
  }
}

internal object QuestionnaireItemEnableWhenSerializer : KSerializer<Questionnaire.Item.EnableWhen> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("EnableWhen") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("question", KotlinString.serializer().descriptor)
      optionalElement("_question", ElementSerializer.descriptor)
      optionalElement("operator", KotlinString.serializer().descriptor)
      optionalElement("_operator", ElementSerializer.descriptor)
      optionalElement("answerBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_answerBoolean", ElementSerializer.descriptor)
      optionalElement("answerDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_answerDecimal", ElementSerializer.descriptor)
      optionalElement("answerInteger", Int.serializer().descriptor)
      optionalElement("_answerInteger", ElementSerializer.descriptor)
      optionalElement("answerDate", KotlinString.serializer().descriptor)
      optionalElement("_answerDate", ElementSerializer.descriptor)
      optionalElement("answerDateTime", KotlinString.serializer().descriptor)
      optionalElement("_answerDateTime", ElementSerializer.descriptor)
      optionalElement("answerTime", LocalTimeSerializer.descriptor)
      optionalElement("_answerTime", ElementSerializer.descriptor)
      optionalElement("answerString", KotlinString.serializer().descriptor)
      optionalElement("_answerString", ElementSerializer.descriptor)
      optionalElement("answerCoding", CodingSerializer.descriptor)
      optionalElement("answerQuantity", QuantitySerializer.descriptor)
      optionalElement("answerReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Questionnaire.Item.EnableWhen>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Questionnaire.Item.EnableWhen =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var question: KotlinString? = null
      var _question: Element? = null
      var `operator`: KotlinString? = null
      var _operator: Element? = null
      var answerBoolean: KotlinBoolean? = null
      var _answerBoolean: Element? = null
      var answerDecimal: FhirDecimal? = null
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
          3 -> question = decodeStringElement(descriptor, i)
          4 -> _question = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> `operator` = decodeStringElement(descriptor, i)
          6 -> _operator = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> answerBoolean = decodeBooleanElement(descriptor, i)
          8 ->
            _answerBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 ->
            answerDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          10 ->
            _answerDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> answerInteger = decodeIntElement(descriptor, i)
          12 ->
            _answerInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> answerDate = decodeStringElement(descriptor, i)
          14 ->
            _answerDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> answerDateTime = decodeStringElement(descriptor, i)
          16 ->
            _answerDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 ->
            answerTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          18 ->
            _answerTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 -> answerString = decodeStringElement(descriptor, i)
          20 ->
            _answerString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          21 ->
            answerCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          22 ->
            answerQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          23 ->
            answerReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding EnableWhen: " + i)
        }
      }
      Questionnaire.Item.EnableWhen(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        question =
          R5String.of(question, _question)
            ?: throw SerializationException(
              "Missing required property 'question' on Questionnaire.Item.EnableWhen"
            ),
        `operator` =
          Enumeration.of(
            if (`operator` != null) Questionnaire.QuestionnaireItemOperator.fromCode(`operator`)
            else null,
            _operator,
          )
            ?: throw SerializationException(
              "Missing required property 'operator' on Questionnaire.Item.EnableWhen"
            ),
        answer =
          Questionnaire.Item.EnableWhen.Answer.from(
            R5Boolean.of(answerBoolean, _answerBoolean),
            Decimal.of(answerDecimal, _answerDecimal),
            Integer.of(answerInteger, _answerInteger),
            Date.of(if (answerDate != null) FhirDate.fromString(answerDate) else null, _answerDate),
            DateTime.of(
              if (answerDateTime != null) FhirDateTime.fromString(answerDateTime) else null,
              _answerDateTime,
            ),
            Time.of(answerTime, _answerTime),
            R5String.of(answerString, _answerString),
            answerCoding,
            answerQuantity,
            answerReference,
          )
            ?: throw SerializationException(
              "Missing required property 'answer' on Questionnaire.Item.EnableWhen"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.EnableWhen) {
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
      encodeStringIfNotNull(descriptor, 3, value.question.value)
      encodeElementIfNotNull(descriptor, 4, value.question)
      encodeStringIfNotNull(descriptor, 5, value.`operator`.value?.code)
      encodeElementIfNotNull(descriptor, 6, value.`operator`)
      when (val choice = value.answer) {
        is Questionnaire.Item.EnableWhen.Answer.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 9, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Integer -> {
          encodeIntIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Date -> {
          encodeStringIfNotNull(descriptor, 13, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.DateTime -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Time -> {
          encodeSerializableIfNotNull(descriptor, 17, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.String -> {
          encodeStringIfNotNull(descriptor, 19, choice.value.value)
          encodeElementIfNotNull(descriptor, 20, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Coding -> {
          encodeSerializableElement(descriptor, 21, CodingSerializer, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Quantity -> {
          encodeSerializableElement(descriptor, 22, QuantitySerializer, choice.value)
        }
        is Questionnaire.Item.EnableWhen.Answer.Reference -> {
          encodeSerializableElement(descriptor, 23, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object QuestionnaireItemAnswerOptionSerializer :
  KSerializer<Questionnaire.Item.AnswerOption> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AnswerOption") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueCoding", CodingSerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
      optionalElement("initialSelected", KotlinBoolean.serializer().descriptor)
      optionalElement("_initialSelected", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Questionnaire.Item.AnswerOption>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Questionnaire.Item.AnswerOption =
    decoder.decodeStructure(descriptor) {
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
          3 -> valueInteger = decodeIntElement(descriptor, i)
          4 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> valueDate = decodeStringElement(descriptor, i)
          6 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          8 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueString = decodeStringElement(descriptor, i)
          10 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          12 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          13 -> initialSelected = decodeBooleanElement(descriptor, i)
          14 ->
            _initialSelected =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding AnswerOption: " + i)
        }
      }
      Questionnaire.Item.AnswerOption(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          Questionnaire.Item.AnswerOption.Value.from(
            Integer.of(valueInteger, _valueInteger),
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            Time.of(valueTime, _valueTime),
            R5String.of(valueString, _valueString),
            valueCoding,
            valueReference,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on Questionnaire.Item.AnswerOption"
            ),
        initialSelected = R5Boolean.of(initialSelected, _initialSelected),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.AnswerOption) {
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
      when (val choice = value.`value`) {
        is Questionnaire.Item.AnswerOption.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is Questionnaire.Item.AnswerOption.Value.Date -> {
          encodeStringIfNotNull(descriptor, 5, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Questionnaire.Item.AnswerOption.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 7, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Questionnaire.Item.AnswerOption.Value.String -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Questionnaire.Item.AnswerOption.Value.Coding -> {
          encodeSerializableElement(descriptor, 11, CodingSerializer, choice.value)
        }
        is Questionnaire.Item.AnswerOption.Value.Reference -> {
          encodeSerializableElement(descriptor, 12, ReferenceSerializer, choice.value)
        }
      }
      encodeBooleanIfNotNull(descriptor, 13, value.initialSelected?.value)
      encodeElementIfNotNull(descriptor, 14, value.initialSelected)
    }
  }
}

internal object QuestionnaireItemInitialSerializer : KSerializer<Questionnaire.Item.Initial> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Initial") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueDecimal", FhirDecimalSerializer.descriptor)
      optionalElement("_valueDecimal", ElementSerializer.descriptor)
      optionalElement("valueInteger", Int.serializer().descriptor)
      optionalElement("_valueInteger", ElementSerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueDateTime", KotlinString.serializer().descriptor)
      optionalElement("_valueDateTime", ElementSerializer.descriptor)
      optionalElement("valueTime", LocalTimeSerializer.descriptor)
      optionalElement("_valueTime", ElementSerializer.descriptor)
      optionalElement("valueString", KotlinString.serializer().descriptor)
      optionalElement("_valueString", ElementSerializer.descriptor)
      optionalElement("valueUri", KotlinString.serializer().descriptor)
      optionalElement("_valueUri", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("valueCoding", CodingSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Questionnaire.Item.Initial>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Questionnaire.Item.Initial =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueDecimal: FhirDecimal? = null
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
          3 -> valueBoolean = decodeBooleanElement(descriptor, i)
          4 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            valueDecimal =
              decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          6 ->
            _valueDecimal =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> valueInteger = decodeIntElement(descriptor, i)
          8 ->
            _valueInteger =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> valueDate = decodeStringElement(descriptor, i)
          10 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> valueDateTime = decodeStringElement(descriptor, i)
          12 ->
            _valueDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            valueTime = decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
          14 ->
            _valueTime = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          15 -> valueString = decodeStringElement(descriptor, i)
          16 ->
            _valueString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> valueUri = decodeStringElement(descriptor, i)
          18 ->
            _valueUri = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          20 ->
            valueCoding = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          21 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          22 ->
            valueReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Initial: " + i)
        }
      }
      Questionnaire.Item.Initial(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          Questionnaire.Item.Initial.Value.from(
            R5Boolean.of(valueBoolean, _valueBoolean),
            Decimal.of(valueDecimal, _valueDecimal),
            Integer.of(valueInteger, _valueInteger),
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            DateTime.of(
              if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
              _valueDateTime,
            ),
            Time.of(valueTime, _valueTime),
            R5String.of(valueString, _valueString),
            Uri.of(valueUri, _valueUri),
            valueAttachment,
            valueCoding,
            valueQuantity,
            valueReference,
          )
            ?: throw SerializationException(
              "Missing required property 'value' on Questionnaire.Item.Initial"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Questionnaire.Item.Initial) {
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
      when (val choice = value.`value`) {
        is Questionnaire.Item.Initial.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 5, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Date -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Questionnaire.Item.Initial.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 13, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is Questionnaire.Item.Initial.Value.String -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Attachment -> {
          encodeSerializableElement(descriptor, 19, AttachmentSerializer, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Coding -> {
          encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Quantity -> {
          encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
        }
        is Questionnaire.Item.Initial.Value.Reference -> {
          encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object QuestionnaireSerializer : FhirResourceSerializer<Questionnaire> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Questionnaire")

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
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmString", KotlinString.serializer().descriptor)
    b.optionalElement("_versionAlgorithmString", ElementSerializer.descriptor)
    b.optionalElement("versionAlgorithmCoding", CodingSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("derivedFrom", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFrom", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("subjectType", stringNullableListSerializer.descriptor)
    b.optionalElement("_subjectType", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("purpose", KotlinString.serializer().descriptor)
    b.optionalElement("_purpose", ElementSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("copyrightLabel", KotlinString.serializer().descriptor)
    b.optionalElement("_copyrightLabel", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("code", CodingSerializer.listSerializer.descriptor)
    b.optionalElement("item", QuestionnaireItemSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
    var versionAlgorithmString: KotlinString? = null
    var _versionAlgorithmString: Element? = null
    var versionAlgorithmCoding: Coding? = null
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
    var copyrightLabel: KotlinString? = null
    var _copyrightLabel: Element? = null
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
        10 -> url = decoder.decodeStringElement(descriptor, i)
        11 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> versionAlgorithmString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _versionAlgorithmString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          versionAlgorithmCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        18 -> name = decoder.decodeStringElement(descriptor, i)
        19 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        20 -> title = decoder.decodeStringElement(descriptor, i)
        21 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        23 ->
          _derivedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        24 -> status = decoder.decodeStringElement(descriptor, i)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        26 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        28 ->
          subjectType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        29 ->
          _subjectType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        30 -> date = decoder.decodeStringElement(descriptor, i)
        31 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> publisher = decoder.decodeStringElement(descriptor, i)
        33 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        35 -> description = decoder.decodeStringElement(descriptor, i)
        36 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        37 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        38 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        39 -> purpose = decoder.decodeStringElement(descriptor, i)
        40 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        41 -> copyright = decoder.decodeStringElement(descriptor, i)
        42 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        43 -> copyrightLabel = decoder.decodeStringElement(descriptor, i)
        44 ->
          _copyrightLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        45 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        46 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        47 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        48 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        49 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        50 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        51 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireItemSerializer.listSerializer,
              null,
            )
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
      version = R5String.of(version, _version),
      versionAlgorithm =
        Questionnaire.VersionAlgorithm.from(
          R5String.of(versionAlgorithmString, _versionAlgorithmString),
          versionAlgorithmCoding,
        ),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      derivedFrom =
        (kotlin.collections.List(maxOf(derivedFrom?.size ?: 0, _derivedFrom?.size ?: 0)) { index ->
          Canonical.of(derivedFrom?.getOrNull(index), _derivedFrom?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFrom' on Questionnaire has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException("Missing required property 'status' on Questionnaire"),
      experimental = R5Boolean.of(experimental, _experimental),
      subjectType =
        (kotlin.collections.List(maxOf(subjectType?.size ?: 0, _subjectType?.size ?: 0)) { index ->
          Enumeration.of(
            subjectType?.getOrNull(index)?.let { ResourceType.fromCode(it) },
            _subjectType?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'subjectType' on Questionnaire has neither a value nor an id/extension"
            )
        }),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R5String.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      purpose = Markdown.of(purpose, _purpose),
      copyright = Markdown.of(copyright, _copyright),
      copyrightLabel = R5String.of(copyrightLabel, _copyrightLabel),
      approvalDate =
        Date.of(
          if (approvalDate != null) FhirDate.fromString(approvalDate) else null,
          _approvalDate,
        ),
      lastReviewDate =
        Date.of(
          if (lastReviewDate != null) FhirDate.fromString(lastReviewDate) else null,
          _lastReviewDate,
        ),
      effectivePeriod = effectivePeriod,
      code = code ?: listOf(),
      item = item ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Questionnaire,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 11 + descriptorOffset, value.url)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    when (val choice = value.versionAlgorithm) {
      null -> {}
      is Questionnaire.VersionAlgorithm.String -> {
        encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, choice.value.value)
        encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, choice.value)
      }
      is Questionnaire.VersionAlgorithm.Coding -> {
        encoder.encodeSerializableElement(
          descriptor,
          17 + descriptorOffset,
          CodingSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(descriptor, 18 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 19 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 20 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.title)
    if (value.derivedFrom.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        22 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFrom.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 23 + descriptorOffset, value.derivedFrom)
    }
    encoder.encodeStringIfNotNull(descriptor, 24 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 26 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.experimental)
    if (value.subjectType.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        28 + descriptorOffset,
        stringNullableListSerializer,
        value.subjectType.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 29 + descriptorOffset, value.subjectType)
    }
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 35 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 36 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 39 + descriptorOffset, value.purpose?.value)
    encoder.encodeElementIfNotNull(descriptor, 40 + descriptorOffset, value.purpose)
    encoder.encodeStringIfNotNull(descriptor, 41 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 42 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(descriptor, 43 + descriptorOffset, value.copyrightLabel?.value)
    encoder.encodeElementIfNotNull(descriptor, 44 + descriptorOffset, value.copyrightLabel)
    encoder.encodeStringIfNotNull(
      descriptor,
      45 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 46 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      47 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 48 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      49 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        CodingSerializer.listSerializer,
        value.code,
      )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        QuestionnaireItemSerializer.listSerializer,
        value.item,
      )
  }
}
