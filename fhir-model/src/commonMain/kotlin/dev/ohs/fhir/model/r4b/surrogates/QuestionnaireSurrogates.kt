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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Canonical
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Coding
import com.google.fhir.model.r4b.ContactDetail
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.DateTime
import com.google.fhir.model.r4b.Decimal
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.FhirDateTime
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Integer
import com.google.fhir.model.r4b.Markdown
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Period
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Questionnaire
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Time
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.UsageContext
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import com.google.fhir.model.r4b.terminologies.ResourceType
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class QuestionnaireItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var linkId: KotlinString? = null,
  public var _linkId: Element? = null,
  public var definition: KotlinString? = null,
  public var _definition: Element? = null,
  public var code: List<Coding>? = null,
  public var prefix: KotlinString? = null,
  public var _prefix: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var enableWhen: List<Questionnaire.Item.EnableWhen>? = null,
  public var enableBehavior: KotlinString? = null,
  public var _enableBehavior: Element? = null,
  public var required: KotlinBoolean? = null,
  public var _required: Element? = null,
  public var repeats: KotlinBoolean? = null,
  public var _repeats: Element? = null,
  public var readOnly: KotlinBoolean? = null,
  public var _readOnly: Element? = null,
  public var maxLength: Int? = null,
  public var _maxLength: Element? = null,
  public var answerValueSet: KotlinString? = null,
  public var _answerValueSet: Element? = null,
  public var answerOption: List<Questionnaire.Item.AnswerOption>? = null,
  public var initial: List<Questionnaire.Item.Initial>? = null,
  public var item: List<Questionnaire.Item>? = null,
) {
  public fun toModel(): Questionnaire.Item =
    Questionnaire.Item(
      id = this@QuestionnaireItemSurrogate.id,
      extension = this@QuestionnaireItemSurrogate.extension ?: listOf(),
      modifierExtension = this@QuestionnaireItemSurrogate.modifierExtension ?: listOf(),
      linkId =
        R4bString.of(
          this@QuestionnaireItemSurrogate.linkId,
          this@QuestionnaireItemSurrogate._linkId,
        )!!,
      definition =
        Uri.of(
          this@QuestionnaireItemSurrogate.definition,
          this@QuestionnaireItemSurrogate._definition,
        ),
      code = this@QuestionnaireItemSurrogate.code ?: listOf(),
      prefix =
        R4bString.of(
          this@QuestionnaireItemSurrogate.prefix,
          this@QuestionnaireItemSurrogate._prefix,
        ),
      text =
        R4bString.of(this@QuestionnaireItemSurrogate.text, this@QuestionnaireItemSurrogate._text),
      type =
        Enumeration.of(
          Questionnaire.QuestionnaireItemType.fromCode(this@QuestionnaireItemSurrogate.type!!),
          this@QuestionnaireItemSurrogate._type,
        ),
      enableWhen = this@QuestionnaireItemSurrogate.enableWhen ?: listOf(),
      enableBehavior =
        this@QuestionnaireItemSurrogate.enableBehavior?.let {
          Enumeration.of(
            Questionnaire.EnableWhenBehavior.fromCode(it),
            this@QuestionnaireItemSurrogate._enableBehavior,
          )
        },
      required =
        R4bBoolean.of(
          this@QuestionnaireItemSurrogate.required,
          this@QuestionnaireItemSurrogate._required,
        ),
      repeats =
        R4bBoolean.of(
          this@QuestionnaireItemSurrogate.repeats,
          this@QuestionnaireItemSurrogate._repeats,
        ),
      readOnly =
        R4bBoolean.of(
          this@QuestionnaireItemSurrogate.readOnly,
          this@QuestionnaireItemSurrogate._readOnly,
        ),
      maxLength =
        Integer.of(
          this@QuestionnaireItemSurrogate.maxLength,
          this@QuestionnaireItemSurrogate._maxLength,
        ),
      answerValueSet =
        Canonical.of(
          this@QuestionnaireItemSurrogate.answerValueSet,
          this@QuestionnaireItemSurrogate._answerValueSet,
        ),
      answerOption = this@QuestionnaireItemSurrogate.answerOption ?: listOf(),
      initial = this@QuestionnaireItemSurrogate.initial ?: listOf(),
      item = this@QuestionnaireItemSurrogate.item ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Questionnaire.Item): QuestionnaireItemSurrogate =
      with(model) {
        QuestionnaireItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          linkId = this@with.linkId.value,
          _linkId = this@with.linkId.toElement(),
          definition = this@with.definition?.value,
          _definition = this@with.definition?.toElement(),
          code = this@with.code.takeIf { it.isNotEmpty() },
          prefix = this@with.prefix?.value,
          _prefix = this@with.prefix?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          type = this@with.type.value?.getCode(),
          _type = this@with.type.toElement(),
          enableWhen = this@with.enableWhen.takeIf { it.isNotEmpty() },
          enableBehavior = this@with.enableBehavior?.value?.getCode(),
          _enableBehavior = this@with.enableBehavior?.toElement(),
          required = this@with.required?.value,
          _required = this@with.required?.toElement(),
          repeats = this@with.repeats?.value,
          _repeats = this@with.repeats?.toElement(),
          readOnly = this@with.readOnly?.value,
          _readOnly = this@with.readOnly?.toElement(),
          maxLength = this@with.maxLength?.value,
          _maxLength = this@with.maxLength?.toElement(),
          answerValueSet = this@with.answerValueSet?.value,
          _answerValueSet = this@with.answerValueSet?.toElement(),
          answerOption = this@with.answerOption.takeIf { it.isNotEmpty() },
          initial = this@with.initial.takeIf { it.isNotEmpty() },
          item = this@with.item.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemEnableWhenSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var question: KotlinString? = null,
  public var _question: Element? = null,
  public var `operator`: KotlinString? = null,
  public var _operator: Element? = null,
  public var answer: Questionnaire.Item.EnableWhen.Answer,
) {
  public fun toModel(): Questionnaire.Item.EnableWhen =
    Questionnaire.Item.EnableWhen(
      id = this@QuestionnaireItemEnableWhenSurrogate.id,
      extension = this@QuestionnaireItemEnableWhenSurrogate.extension ?: listOf(),
      modifierExtension = this@QuestionnaireItemEnableWhenSurrogate.modifierExtension ?: listOf(),
      question =
        R4bString.of(
          this@QuestionnaireItemEnableWhenSurrogate.question,
          this@QuestionnaireItemEnableWhenSurrogate._question,
        )!!,
      `operator` =
        Enumeration.of(
          Questionnaire.QuestionnaireItemOperator.fromCode(
            this@QuestionnaireItemEnableWhenSurrogate.`operator`!!
          ),
          this@QuestionnaireItemEnableWhenSurrogate._operator,
        ),
      answer = this@QuestionnaireItemEnableWhenSurrogate.answer,
    )

  public companion object {
    public fun fromModel(
      model: Questionnaire.Item.EnableWhen
    ): QuestionnaireItemEnableWhenSurrogate =
      with(model) {
        QuestionnaireItemEnableWhenSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          question = this@with.question.value,
          _question = this@with.question.toElement(),
          `operator` = this@with.`operator`.value?.getCode(),
          _operator = this@with.`operator`.toElement(),
          answer = this@with.answer,
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemAnswerOptionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: Questionnaire.Item.AnswerOption.Value,
  public var initialSelected: KotlinBoolean? = null,
  public var _initialSelected: Element? = null,
) {
  public fun toModel(): Questionnaire.Item.AnswerOption =
    Questionnaire.Item.AnswerOption(
      id = this@QuestionnaireItemAnswerOptionSurrogate.id,
      extension = this@QuestionnaireItemAnswerOptionSurrogate.extension ?: listOf(),
      modifierExtension = this@QuestionnaireItemAnswerOptionSurrogate.modifierExtension ?: listOf(),
      `value` = this@QuestionnaireItemAnswerOptionSurrogate.`value`,
      initialSelected =
        R4bBoolean.of(
          this@QuestionnaireItemAnswerOptionSurrogate.initialSelected,
          this@QuestionnaireItemAnswerOptionSurrogate._initialSelected,
        ),
    )

  public companion object {
    public fun fromModel(
      model: Questionnaire.Item.AnswerOption
    ): QuestionnaireItemAnswerOptionSurrogate =
      with(model) {
        QuestionnaireItemAnswerOptionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
          initialSelected = this@with.initialSelected?.value,
          _initialSelected = this@with.initialSelected?.toElement(),
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemInitialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: Questionnaire.Item.Initial.Value,
) {
  public fun toModel(): Questionnaire.Item.Initial =
    Questionnaire.Item.Initial(
      id = this@QuestionnaireItemInitialSurrogate.id,
      extension = this@QuestionnaireItemInitialSurrogate.extension ?: listOf(),
      modifierExtension = this@QuestionnaireItemInitialSurrogate.modifierExtension ?: listOf(),
      `value` = this@QuestionnaireItemInitialSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(model: Questionnaire.Item.Initial): QuestionnaireItemInitialSurrogate =
      with(model) {
        QuestionnaireItemInitialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemEnableWhenAnswerSurrogate(
  public var answerBoolean: KotlinBoolean? = null,
  public var _answerBoolean: Element? = null,
  public var answerDecimal: Double? = null,
  public var _answerDecimal: Element? = null,
  public var answerInteger: Int? = null,
  public var _answerInteger: Element? = null,
  public var answerDate: KotlinString? = null,
  public var _answerDate: Element? = null,
  public var answerDateTime: KotlinString? = null,
  public var _answerDateTime: Element? = null,
  public var answerTime: LocalTime? = null,
  public var _answerTime: Element? = null,
  public var answerString: KotlinString? = null,
  public var _answerString: Element? = null,
  public var answerCoding: Coding? = null,
  public var answerQuantity: Quantity? = null,
  public var answerReference: Reference? = null,
) {
  public fun toModel(): Questionnaire.Item.EnableWhen.Answer =
    Questionnaire.Item.EnableWhen.Answer.from(
      R4bBoolean.of(
        this@QuestionnaireItemEnableWhenAnswerSurrogate.answerBoolean,
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerBoolean,
      ),
      Decimal.of(
        this@QuestionnaireItemEnableWhenAnswerSurrogate.answerDecimal,
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerDecimal,
      ),
      Integer.of(
        this@QuestionnaireItemEnableWhenAnswerSurrogate.answerInteger,
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerInteger,
      ),
      Date.of(
        FhirDate.fromString(this@QuestionnaireItemEnableWhenAnswerSurrogate.answerDate),
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@QuestionnaireItemEnableWhenAnswerSurrogate.answerDateTime),
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerDateTime,
      ),
      Time.of(
        this@QuestionnaireItemEnableWhenAnswerSurrogate.answerTime,
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerTime,
      ),
      R4bString.of(
        this@QuestionnaireItemEnableWhenAnswerSurrogate.answerString,
        this@QuestionnaireItemEnableWhenAnswerSurrogate._answerString,
      ),
      this@QuestionnaireItemEnableWhenAnswerSurrogate.answerCoding,
      this@QuestionnaireItemEnableWhenAnswerSurrogate.answerQuantity,
      this@QuestionnaireItemEnableWhenAnswerSurrogate.answerReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Questionnaire.Item.EnableWhen.Answer
    ): QuestionnaireItemEnableWhenAnswerSurrogate =
      with(model) {
        QuestionnaireItemEnableWhenAnswerSurrogate(
          answerBoolean = this@with.asBoolean()?.value?.value,
          _answerBoolean = this@with.asBoolean()?.value?.toElement(),
          answerDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _answerDecimal = this@with.asDecimal()?.value?.toElement(),
          answerInteger = this@with.asInteger()?.value?.value,
          _answerInteger = this@with.asInteger()?.value?.toElement(),
          answerDate = this@with.asDate()?.value?.value?.toString(),
          _answerDate = this@with.asDate()?.value?.toElement(),
          answerDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _answerDateTime = this@with.asDateTime()?.value?.toElement(),
          answerTime = this@with.asTime()?.value?.value,
          _answerTime = this@with.asTime()?.value?.toElement(),
          answerString = this@with.asString()?.value?.value,
          _answerString = this@with.asString()?.value?.toElement(),
          answerCoding = this@with.asCoding()?.value,
          answerQuantity = this@with.asQuantity()?.value,
          answerReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemAnswerOptionValueSurrogate(
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueCoding: Coding? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): Questionnaire.Item.AnswerOption.Value =
    Questionnaire.Item.AnswerOption.Value.from(
      Integer.of(
        this@QuestionnaireItemAnswerOptionValueSurrogate.valueInteger,
        this@QuestionnaireItemAnswerOptionValueSurrogate._valueInteger,
      ),
      Date.of(
        FhirDate.fromString(this@QuestionnaireItemAnswerOptionValueSurrogate.valueDate),
        this@QuestionnaireItemAnswerOptionValueSurrogate._valueDate,
      ),
      Time.of(
        this@QuestionnaireItemAnswerOptionValueSurrogate.valueTime,
        this@QuestionnaireItemAnswerOptionValueSurrogate._valueTime,
      ),
      R4bString.of(
        this@QuestionnaireItemAnswerOptionValueSurrogate.valueString,
        this@QuestionnaireItemAnswerOptionValueSurrogate._valueString,
      ),
      this@QuestionnaireItemAnswerOptionValueSurrogate.valueCoding,
      this@QuestionnaireItemAnswerOptionValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Questionnaire.Item.AnswerOption.Value
    ): QuestionnaireItemAnswerOptionValueSurrogate =
      with(model) {
        QuestionnaireItemAnswerOptionValueSurrogate(
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueCoding = this@with.asCoding()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class QuestionnaireItemInitialValueSurrogate(
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueDecimal: Double? = null,
  public var _valueDecimal: Element? = null,
  public var valueInteger: Int? = null,
  public var _valueInteger: Element? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueDateTime: KotlinString? = null,
  public var _valueDateTime: Element? = null,
  public var valueTime: LocalTime? = null,
  public var _valueTime: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueUri: KotlinString? = null,
  public var _valueUri: Element? = null,
  public var valueAttachment: Attachment? = null,
  public var valueCoding: Coding? = null,
  public var valueQuantity: Quantity? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): Questionnaire.Item.Initial.Value =
    Questionnaire.Item.Initial.Value.from(
      R4bBoolean.of(
        this@QuestionnaireItemInitialValueSurrogate.valueBoolean,
        this@QuestionnaireItemInitialValueSurrogate._valueBoolean,
      ),
      Decimal.of(
        this@QuestionnaireItemInitialValueSurrogate.valueDecimal,
        this@QuestionnaireItemInitialValueSurrogate._valueDecimal,
      ),
      Integer.of(
        this@QuestionnaireItemInitialValueSurrogate.valueInteger,
        this@QuestionnaireItemInitialValueSurrogate._valueInteger,
      ),
      Date.of(
        FhirDate.fromString(this@QuestionnaireItemInitialValueSurrogate.valueDate),
        this@QuestionnaireItemInitialValueSurrogate._valueDate,
      ),
      DateTime.of(
        FhirDateTime.fromString(this@QuestionnaireItemInitialValueSurrogate.valueDateTime),
        this@QuestionnaireItemInitialValueSurrogate._valueDateTime,
      ),
      Time.of(
        this@QuestionnaireItemInitialValueSurrogate.valueTime,
        this@QuestionnaireItemInitialValueSurrogate._valueTime,
      ),
      R4bString.of(
        this@QuestionnaireItemInitialValueSurrogate.valueString,
        this@QuestionnaireItemInitialValueSurrogate._valueString,
      ),
      Uri.of(
        this@QuestionnaireItemInitialValueSurrogate.valueUri,
        this@QuestionnaireItemInitialValueSurrogate._valueUri,
      ),
      this@QuestionnaireItemInitialValueSurrogate.valueAttachment,
      this@QuestionnaireItemInitialValueSurrogate.valueCoding,
      this@QuestionnaireItemInitialValueSurrogate.valueQuantity,
      this@QuestionnaireItemInitialValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: Questionnaire.Item.Initial.Value
    ): QuestionnaireItemInitialValueSurrogate =
      with(model) {
        QuestionnaireItemInitialValueSurrogate(
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueDecimal = this@with.asDecimal()?.value?.value?.toString()?.toDouble(),
          _valueDecimal = this@with.asDecimal()?.value?.toElement(),
          valueInteger = this@with.asInteger()?.value?.value,
          _valueInteger = this@with.asInteger()?.value?.toElement(),
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueDateTime = this@with.asDateTime()?.value?.value?.toString(),
          _valueDateTime = this@with.asDateTime()?.value?.toElement(),
          valueTime = this@with.asTime()?.value?.value,
          _valueTime = this@with.asTime()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueUri = this@with.asUri()?.value?.value,
          _valueUri = this@with.asUri()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
          valueCoding = this@with.asCoding()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class QuestionnaireSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var url: KotlinString? = null,
  public var _url: Element? = null,
  public var identifier: List<Identifier>? = null,
  public var version: KotlinString? = null,
  public var _version: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var title: KotlinString? = null,
  public var _title: Element? = null,
  public var derivedFrom: List<KotlinString?>? = null,
  public var _derivedFrom: List<Element?>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var experimental: KotlinBoolean? = null,
  public var _experimental: Element? = null,
  public var subjectType: List<KotlinString?>? = null,
  public var _subjectType: List<Element?>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var publisher: KotlinString? = null,
  public var _publisher: Element? = null,
  public var contact: List<ContactDetail>? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var useContext: List<UsageContext>? = null,
  public var jurisdiction: List<CodeableConcept>? = null,
  public var purpose: KotlinString? = null,
  public var _purpose: Element? = null,
  public var copyright: KotlinString? = null,
  public var _copyright: Element? = null,
  public var approvalDate: KotlinString? = null,
  public var _approvalDate: Element? = null,
  public var lastReviewDate: KotlinString? = null,
  public var _lastReviewDate: Element? = null,
  public var effectivePeriod: Period? = null,
  public var code: List<Coding>? = null,
  public var item: List<Questionnaire.Item>? = null,
) {
  public fun toModel(): Questionnaire =
    Questionnaire(
      id = this@QuestionnaireSurrogate.id,
      meta = this@QuestionnaireSurrogate.meta,
      implicitRules =
        Uri.of(
          this@QuestionnaireSurrogate.implicitRules,
          this@QuestionnaireSurrogate._implicitRules,
        ),
      language =
        Code.of(this@QuestionnaireSurrogate.language, this@QuestionnaireSurrogate._language),
      text = this@QuestionnaireSurrogate.text,
      contained = this@QuestionnaireSurrogate.contained ?: listOf(),
      extension = this@QuestionnaireSurrogate.extension ?: listOf(),
      modifierExtension = this@QuestionnaireSurrogate.modifierExtension ?: listOf(),
      url = Uri.of(this@QuestionnaireSurrogate.url, this@QuestionnaireSurrogate._url),
      identifier = this@QuestionnaireSurrogate.identifier ?: listOf(),
      version =
        R4bString.of(this@QuestionnaireSurrogate.version, this@QuestionnaireSurrogate._version),
      name = R4bString.of(this@QuestionnaireSurrogate.name, this@QuestionnaireSurrogate._name),
      title = R4bString.of(this@QuestionnaireSurrogate.title, this@QuestionnaireSurrogate._title),
      derivedFrom =
        if (
          this@QuestionnaireSurrogate.derivedFrom == null &&
            this@QuestionnaireSurrogate._derivedFrom == null
        ) {
          listOf()
        } else {
          (this@QuestionnaireSurrogate.derivedFrom
              ?: List(this@QuestionnaireSurrogate._derivedFrom!!.size) { null })
            .zip(
              this@QuestionnaireSurrogate._derivedFrom
                ?: List(this@QuestionnaireSurrogate.derivedFrom!!.size) { null }
            )
            .map { (value, element) -> Canonical.of(value, element)!! }
            .toList()
        },
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@QuestionnaireSurrogate.status!!),
          this@QuestionnaireSurrogate._status,
        ),
      experimental =
        R4bBoolean.of(
          this@QuestionnaireSurrogate.experimental,
          this@QuestionnaireSurrogate._experimental,
        ),
      subjectType =
        if (
          this@QuestionnaireSurrogate.subjectType == null &&
            this@QuestionnaireSurrogate._subjectType == null
        ) {
          listOf()
        } else {
          (this@QuestionnaireSurrogate.subjectType
              ?: List(this@QuestionnaireSurrogate._subjectType!!.size) { null })
            .zip(
              this@QuestionnaireSurrogate._subjectType
                ?: List(this@QuestionnaireSurrogate.subjectType!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(value.let { ResourceType.fromCode(it!!) }, element)
            }
            .toList()
        },
      date =
        DateTime.of(
          FhirDateTime.fromString(this@QuestionnaireSurrogate.date),
          this@QuestionnaireSurrogate._date,
        ),
      publisher =
        R4bString.of(this@QuestionnaireSurrogate.publisher, this@QuestionnaireSurrogate._publisher),
      contact = this@QuestionnaireSurrogate.contact ?: listOf(),
      description =
        Markdown.of(
          this@QuestionnaireSurrogate.description,
          this@QuestionnaireSurrogate._description,
        ),
      useContext = this@QuestionnaireSurrogate.useContext ?: listOf(),
      jurisdiction = this@QuestionnaireSurrogate.jurisdiction ?: listOf(),
      purpose =
        Markdown.of(this@QuestionnaireSurrogate.purpose, this@QuestionnaireSurrogate._purpose),
      copyright =
        Markdown.of(this@QuestionnaireSurrogate.copyright, this@QuestionnaireSurrogate._copyright),
      approvalDate =
        Date.of(
          FhirDate.fromString(this@QuestionnaireSurrogate.approvalDate),
          this@QuestionnaireSurrogate._approvalDate,
        ),
      lastReviewDate =
        Date.of(
          FhirDate.fromString(this@QuestionnaireSurrogate.lastReviewDate),
          this@QuestionnaireSurrogate._lastReviewDate,
        ),
      effectivePeriod = this@QuestionnaireSurrogate.effectivePeriod,
      code = this@QuestionnaireSurrogate.code ?: listOf(),
      item = this@QuestionnaireSurrogate.item ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Questionnaire): QuestionnaireSurrogate =
      with(model) {
        QuestionnaireSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          url = this@with.url?.value,
          _url = this@with.url?.toElement(),
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          version = this@with.version?.value,
          _version = this@with.version?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          title = this@with.title?.value,
          _title = this@with.title?.toElement(),
          derivedFrom =
            this@with.derivedFrom.map { it.value }.toList().takeUnless { it.all { it == null } },
          _derivedFrom =
            this@with.derivedFrom
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          experimental = this@with.experimental?.value,
          _experimental = this@with.experimental?.toElement(),
          subjectType =
            this@with.subjectType
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _subjectType =
            this@with.subjectType
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          publisher = this@with.publisher?.value,
          _publisher = this@with.publisher?.toElement(),
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          useContext = this@with.useContext.takeIf { it.isNotEmpty() },
          jurisdiction = this@with.jurisdiction.takeIf { it.isNotEmpty() },
          purpose = this@with.purpose?.value,
          _purpose = this@with.purpose?.toElement(),
          copyright = this@with.copyright?.value,
          _copyright = this@with.copyright?.toElement(),
          approvalDate = this@with.approvalDate?.value?.toString(),
          _approvalDate = this@with.approvalDate?.toElement(),
          lastReviewDate = this@with.lastReviewDate?.value?.toString(),
          _lastReviewDate = this@with.lastReviewDate?.toElement(),
          effectivePeriod = this@with.effectivePeriod,
          code = this@with.code.takeIf { it.isNotEmpty() },
          item = this@with.item.takeIf { it.isNotEmpty() },
        )
      }
  }
}
