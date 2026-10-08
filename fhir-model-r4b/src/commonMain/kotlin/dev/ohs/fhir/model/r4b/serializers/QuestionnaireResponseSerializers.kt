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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.QuestionnaireResponse
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.QuestionnaireResponseStatus
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

internal object QuestionnaireResponseItemSerializer : KSerializer<QuestionnaireResponse.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("linkId", KotlinString.serializer().descriptor)
      optionalElement("_linkId", ElementSerializer.descriptor)
      optionalElement("definition", KotlinString.serializer().descriptor)
      optionalElement("_definition", ElementSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("answer", QuestionnaireResponseItemAnswerSerializer.listSerializer.descriptor)
      optionalElement(
        "item",
        listSerialDescriptor(lazyDescriptor { QuestionnaireResponseItemSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<QuestionnaireResponse.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item {
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        7 -> text = compositeDecoder.decodeStringElement(descriptor, i)
        8 ->
          _text =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 ->
          answer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemAnswerSerializer.listSerializer,
              null,
            )
        10 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return QuestionnaireResponse.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId =
        R4bString.of(linkId, _linkId)
          ?: throw SerializationException(
            "Missing required property 'linkId' on QuestionnaireResponse.Item"
          ),
      definition = Uri.of(definition, _definition),
      text = R4bString.of(text, _text),
      answer = answer ?: listOf(),
      item = item ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeStringIfNotNull(descriptor, 3, value.linkId.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 4, value.linkId)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.definition?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.definition)
    compositeEncoder.encodeStringIfNotNull(descriptor, 7, value.text?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.text)
    if (value.answer.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9,
        QuestionnaireResponseItemAnswerSerializer.listSerializer,
        value.answer,
      )
    if (value.item.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        10,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireResponseItemAnswerSerializer :
  KSerializer<QuestionnaireResponse.Item.Answer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Answer") {
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
      optionalElement(
        "item",
        listSerialDescriptor(lazyDescriptor { QuestionnaireResponseItemSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<QuestionnaireResponse.Item.Answer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item.Answer {
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
        9 -> valueDate = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _valueDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> valueDateTime = compositeDecoder.decodeStringElement(descriptor, i)
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
        23 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Answer: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return QuestionnaireResponse.Item.Answer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        QuestionnaireResponse.Item.Answer.Value.from(
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Decimal.of(valueDecimal, _valueDecimal),
          Integer.of(valueInteger, _valueInteger),
          Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
          DateTime.of(
            if (valueDateTime != null) FhirDateTime.fromString(valueDateTime) else null,
            _valueDateTime,
          ),
          Time.of(valueTime, _valueTime),
          R4bString.of(valueString, _valueString),
          Uri.of(valueUri, _valueUri),
          valueAttachment,
          valueCoding,
          valueQuantity,
          valueReference,
        ),
      item = item ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item.Answer) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.`value`) {
      null -> {}
      is QuestionnaireResponse.Item.Answer.Value.Boolean -> {
        compositeEncoder.encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 4, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Decimal -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          5,
          FhirDecimalSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 6, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Integer -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 7, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 8, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Date -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Time -> {
        compositeEncoder.encodeSerializableIfNotNull(
          descriptor,
          13,
          LocalTimeSerializer,
          choice.value.value,
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 14, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 15, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 16, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Uri -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 17, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 18, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Attachment -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19,
          AttachmentSerializer,
          choice.value,
        )
      }
      is QuestionnaireResponse.Item.Answer.Value.Coding -> {
        compositeEncoder.encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Reference -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          22,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    if (value.item.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object QuestionnaireResponseSerializer : FhirResourceSerializer<QuestionnaireResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("QuestionnaireResponse")

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
    b.optionalElement("basedOn", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("partOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("questionnaire", KotlinString.serializer().descriptor)
    b.optionalElement("_questionnaire", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.descriptor)
    b.optionalElement("encounter", ReferenceSerializer.descriptor)
    b.optionalElement("authored", KotlinString.serializer().descriptor)
    b.optionalElement("_authored", ElementSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("source", ReferenceSerializer.descriptor)
    b.optionalElement("item", QuestionnaireResponseItemSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): QuestionnaireResponse {
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
        11 ->
          basedOn =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          partOf =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 -> questionnaire = compositeDecoder.decodeStringElement(descriptor, i)
        14 ->
          _questionnaire =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        15 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        17 ->
          subject =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        18 ->
          encounter =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 -> authored = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _authored =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          author =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        22 ->
          source =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding QuestionnaireResponse: " + i)
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
          if (status != null) QuestionnaireResponseStatus.fromCode(status) else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on QuestionnaireResponse"
          ),
      subject = subject,
      encounter = encounter,
      authored =
        DateTime.of(if (authored != null) FhirDateTime.fromString(authored) else null, _authored),
      author = author,
      source = source,
      item = item ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: QuestionnaireResponse,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    if (value.basedOn.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      13 + descriptorOffset,
      value.questionnaire?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.questionnaire)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      15 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.subject,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.encounter,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.authored?.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.authored)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.source,
    )
    if (value.item.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
  }
}
