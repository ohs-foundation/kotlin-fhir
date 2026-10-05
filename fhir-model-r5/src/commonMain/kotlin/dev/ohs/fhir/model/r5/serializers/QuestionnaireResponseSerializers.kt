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
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Decimal
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirDecimal
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Integer
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.QuestionnaireResponse
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Uri
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

  internal val listSerializer: KSerializer<List<QuestionnaireResponse.Item>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): QuestionnaireResponse.Item {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> linkId = decoder.decodeStringElement(descriptor, i)
        4 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 -> definition = decoder.decodeStringElement(descriptor, i)
        6 ->
          _definition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> text = decoder.decodeStringElement(descriptor, i)
        8 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 ->
          answer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemAnswerSerializer.listSerializer,
              null,
            )
        10 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return QuestionnaireResponse.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      linkId =
        R5String.of(linkId, _linkId)
          ?: throw SerializationException(
            "Missing required property 'linkId' on QuestionnaireResponse.Item"
          ),
      definition = Uri.of(definition, _definition),
      text = R5String.of(text, _text),
      answer = answer ?: listOf(),
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: QuestionnaireResponse.Item) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    ((value.linkId.value))?.let { encoder.encodeStringElement(descriptor, 3, it) }
    (value.linkId.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    ((value.definition?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.definition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
    }
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        QuestionnaireResponseItemAnswerSerializer.listSerializer,
        value.answer,
      )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
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
      element("valueDecimal", FhirDecimalSerializer.descriptor, isOptional = true)
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

  internal val listSerializer: KSerializer<List<QuestionnaireResponse.Item.Answer>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): QuestionnaireResponse.Item.Answer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse.Item.Answer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): QuestionnaireResponse.Item.Answer {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ExtensionSerializer.listSerializer,
              null,
            )
        3 -> valueBoolean = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        6 ->
          _valueDecimal =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        7 -> valueInteger = decoder.decodeIntElement(descriptor, i)
        8 ->
          _valueInteger =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        9 -> valueDate = decoder.decodeStringElement(descriptor, i)
        10 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 -> valueDateTime = decoder.decodeStringElement(descriptor, i)
        12 ->
          _valueDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, LocalTimeSerializer, null)
        14 ->
          _valueTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> valueString = decoder.decodeStringElement(descriptor, i)
        16 ->
          _valueString =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> valueUri = decoder.decodeStringElement(descriptor, i)
        18 ->
          _valueUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        20 ->
          valueCoding =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        21 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        22 ->
          valueReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuestionnaireResponseItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Answer: " + i)
      }
    }
    return QuestionnaireResponse.Item.Answer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        QuestionnaireResponse.Item.Answer.Value.from(
          R5Boolean.of(valueBoolean, _valueBoolean),
          Decimal.of(valueDecimal, _valueDecimal),
          Integer.of(valueInteger, _valueInteger),
          Date.of(valueDate?.let { FhirDate.fromString(it) }, _valueDate),
          DateTime.of(valueDateTime?.let { FhirDateTime.fromString(it) }, _valueDateTime),
          Time.of(valueTime, _valueTime),
          R5String.of(valueString, _valueString),
          Uri.of(valueUri, _valueUri),
          valueAttachment,
          valueCoding,
          valueQuantity,
          valueReference,
        )
          ?: throw SerializationException(
            "Missing required property 'value' on QuestionnaireResponse.Item.Answer"
          ),
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: QuestionnaireResponse.Item.Answer,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    when (val choice = value.`value`) {
      is QuestionnaireResponse.Item.Answer.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 13, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
        }
      }
      is QuestionnaireResponse.Item.Answer.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 19, AttachmentSerializer, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
      }
      is QuestionnaireResponse.Item.Answer.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
      }
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
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
    b.element(
      "identifier",
      listSerialDescriptor(Identifier.serializer().descriptor),
      isOptional = true,
    )
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
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "QuestionnaireResponse")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var identifier: List<Identifier>? = null
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
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          basedOn =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        12 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        13 -> questionnaire = decoder.decodeStringElement(descriptor, i)
        14 ->
          _questionnaire =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          encounter =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> authored = decoder.decodeStringElement(descriptor, i)
        20 ->
          _authored =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          source =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          item =
            decoder.decodeNullableSerializableElement(
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
      identifier = identifier ?: listOf(),
      basedOn = basedOn ?: listOf(),
      partOf = partOf ?: listOf(),
      questionnaire =
        Canonical.of(questionnaire, _questionnaire)
          ?: throw SerializationException(
            "Missing required property 'questionnaire' on QuestionnaireResponse"
          ),
      status =
        Enumeration.of(
          status?.let { QuestionnaireResponse.QuestionnaireResponseStatus.fromCode(it) },
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on QuestionnaireResponse"
          ),
      subject = subject,
      encounter = encounter,
      authored = DateTime.of(authored?.let { FhirDateTime.fromString(it) }, _authored),
      author = author,
      source = source,
      item = item ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: QuestionnaireResponse,
  ) {
    (value.id)?.let { encoder.encodeStringElement(descriptor, 0 + descriptorOffset, it) }
    (value.meta)?.let {
      encoder.encodeSerializableElement(descriptor, 1 + descriptorOffset, MetaSerializer, it)
    }
    ((value.implicitRules?.value))?.let {
      encoder.encodeStringElement(descriptor, 2 + descriptorOffset, it)
    }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 3 + descriptorOffset, ElementSerializer, it)
    }
    ((value.language?.value))?.let {
      encoder.encodeStringElement(descriptor, 4 + descriptorOffset, it)
    }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5 + descriptorOffset, ElementSerializer, it)
    }
    (value.text)?.let {
      encoder.encodeSerializableElement(descriptor, 6 + descriptorOffset, NarrativeSerializer, it)
    }
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.basedOn.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.basedOn,
      )
    if (value.partOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.partOf,
      )
    ((value.questionnaire.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.questionnaire.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    ((value.status.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    (value.subject)?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.encounter)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.authored?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.authored?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, ElementSerializer, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.source)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, ReferenceSerializer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        QuestionnaireResponseItemSerializer.listSerializer,
        value.item,
      )
  }
}

internal object QuestionnaireResponsePolymorphicSerializer : KSerializer<QuestionnaireResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("QuestionnaireResponse") {
      QuestionnaireResponseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: QuestionnaireResponse) {
    encoder.encodeStructure(descriptor) {
      QuestionnaireResponseSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): QuestionnaireResponse =
    decoder.decodeStructure(descriptor) {
      QuestionnaireResponseSerializer.deserializeInternal(this, descriptor, 0)
    }
}
