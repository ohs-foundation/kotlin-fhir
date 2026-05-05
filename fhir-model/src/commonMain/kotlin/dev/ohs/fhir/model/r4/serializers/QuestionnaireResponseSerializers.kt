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
import dev.ohs.fhir.model.r4.Coding
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
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.QuestionnaireResponse
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Time
import dev.ohs.fhir.model.r4.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.datetime.LocalTime
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

internal object QuestionnaireResponseItemSerializer : KSerializer<QuestionnaireResponse.Item> {
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
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element(
        "answer",
        listSerialDescriptor(
          lazyDescriptor { QuestionnaireResponse.Item.Answer.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { QuestionnaireResponse.Item.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): QuestionnaireResponse.Item {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var linkId: KotlinString? = null
    var _linkId: Element? = null
    var definition: KotlinString? = null
    var _definition: Element? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var answer: List<QuestionnaireResponse.Item.Answer>? = null
    var item: List<QuestionnaireResponse.Item>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> linkId = decoder.decodeStringElement(__desc, __i)
        4 ->
          _linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        5 -> definition = decoder.decodeStringElement(__desc, __i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        7 -> text = decoder.decodeStringElement(__desc, __i)
        8 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        9 ->
          answer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.answerSer, null)
        10 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return QuestionnaireResponse.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId = R4String.of(linkId, _linkId)!!,
      definition = Uri.of(definition, _definition),
      text = R4String.of(text, _text),
      answer = answer ?: listOf(),
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: QuestionnaireResponse.Item) {
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
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.linkIdSer, it)
    }
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.answerSer, value.answer)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.itemSer, value.item)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val linkIdSer: KSerializer<Element> = Element.serializer()

    public val answerSerInner: KSerializer<QuestionnaireResponse.Item.Answer> =
      QuestionnaireResponse.Item.Answer.serializer()

    public val answerSer: KSerializer<List<QuestionnaireResponse.Item.Answer>> =
      ListSerializer(Hoisted.answerSerInner)

    public val itemSerInner: KSerializer<QuestionnaireResponse.Item> =
      QuestionnaireResponse.Item.serializer()

    public val itemSer: KSerializer<List<QuestionnaireResponse.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}

internal object QuestionnaireResponseItemAnswerSerializer :
  KSerializer<QuestionnaireResponse.Item.Answer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Answer") {
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
      element(
        "item",
        listSerialDescriptor(lazyDescriptor { QuestionnaireResponse.Item.serializer().descriptor }),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item.Answer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item.Answer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): QuestionnaireResponse.Item.Answer {
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
    var item: List<QuestionnaireResponse.Item>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        4 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        5 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        6 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        7 -> valueInteger = decoder.decodeIntElement(__desc, __i)
        8 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        9 -> valueDate = decoder.decodeStringElement(__desc, __i)
        10 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        11 -> valueDateTime = decoder.decodeStringElement(__desc, __i)
        12 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        13 ->
          valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, LocalTimeSerializer, null)
        14 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        15 -> valueString = decoder.decodeStringElement(__desc, __i)
        16 ->
          _valueString =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        17 -> valueUri = decoder.decodeStringElement(__desc, __i)
        18 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueBooleanSer, null)
        19 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        20 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueCodingSer, null)
        21 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        22 ->
          valueReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueReferenceSer, null)
        23 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Answer: " + __i)
      }
    }
    return QuestionnaireResponse.Item.Answer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        QuestionnaireResponse.Item.Answer.Value.from(
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
        ),
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: QuestionnaireResponse.Item.Answer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is QuestionnaireResponse.Item.Answer.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 13, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueBooleanSer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.valueAttachmentSer, __d.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.valueCodingSer, __d.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.valueQuantitySer, __d.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Reference -> {
        encoder.encodeSerializableElement(__desc, 22, Hoisted.valueReferenceSer, __d.value)
      }
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23, Hoisted.itemSer, value.item)
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

    public val itemSerInner: KSerializer<QuestionnaireResponse.Item> =
      QuestionnaireResponse.Item.serializer()

    public val itemSer: KSerializer<List<QuestionnaireResponse.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}

internal object QuestionnaireResponseSerializer : KSerializer<QuestionnaireResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QuestionnaireResponse") {
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
    b.element("basedOn", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("partOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("questionnaire", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_questionnaire", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("subject", Reference.serializer().descriptor, isOptional = true)
    b.element("encounter", Reference.serializer().descriptor, isOptional = true)
    b.element("authored", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_authored", Element.serializer().descriptor, isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element("source", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "item",
      listSerialDescriptor(lazyDescriptor { QuestionnaireResponse.Item.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "QuestionnaireResponse")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): QuestionnaireResponse {
    val __desc = desc
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
    var basedOn: List<Reference>? = null
    var partOf: List<Reference>? = null
    var questionnaire: KotlinString? = null
    var _questionnaire: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var subject: Reference? = null
    var encounter: Reference? = null
    var authored: KotlinString? = null
    var _authored: Element? = null
    var author: Reference? = null
    var source: Reference? = null
    var item: List<QuestionnaireResponse.Item>? = null
    while (true) {
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 ->
          basedOn = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        12 ->
          partOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSer, null)
        13 -> questionnaire = decoder.decodeStringElement(__desc, __i)
        14 ->
          _questionnaire =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> status = decoder.decodeStringElement(__desc, __i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        19 -> authored = decoder.decodeStringElement(__desc, __i)
        20 ->
          _authored =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          author =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        22 ->
          source =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.basedOnSerInner, null)
        23 -> item = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.itemSer, null)
        else ->
          throw SerializationException("Unexpected index decoding QuestionnaireResponse: " + __i)
      }
    }
    return QuestionnaireResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      questionnaire = Canonical.of(questionnaire, _questionnaire),
      status =
        Enumeration.of(
          QuestionnaireResponse.QuestionnaireResponseStatus.fromCode(status!!),
          _status,
        ),
      subject = subject,
      encounter = encounter,
      authored = DateTime.of(FhirDateTime.fromString(authored), _authored),
      author = author,
      source = source,
      item = item ?: listOf(),
    )
  }

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: QuestionnaireResponse,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, it)
    }
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11 + __off, Hoisted.basedOnSer, value.basedOn)
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.basedOnSer, value.partOf)
    ((value.questionnaire?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.questionnaire?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.basedOnSerInner, it)
    }
    ((value.authored?.value?.toString()))?.let {
      encoder.encodeStringElement(__desc, 19 + __off, it)
    }
    (value.authored?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.basedOnSerInner, it)
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(__desc, 22 + __off, Hoisted.basedOnSerInner, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.itemSer, value.item)
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

    public val basedOnSerInner: KSerializer<Reference> = Reference.serializer()

    public val basedOnSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.basedOnSerInner)

    public val itemSerInner: KSerializer<QuestionnaireResponse.Item> =
      QuestionnaireResponse.Item.serializer()

    public val itemSer: KSerializer<List<QuestionnaireResponse.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}

internal object QuestionnaireResponsePolymorphicSerializer : KSerializer<QuestionnaireResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QuestionnaireResponse") {
      QuestionnaireResponseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse) {
    encoder.encodeStructure(descriptor) {
      QuestionnaireResponseSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse =
    decoder.decodeStructure(descriptor) {
      QuestionnaireResponseSerializer.deserializeJson(this, descriptor, 0)
    }
}
