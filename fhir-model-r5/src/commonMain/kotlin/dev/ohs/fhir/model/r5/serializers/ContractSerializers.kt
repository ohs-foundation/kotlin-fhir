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

import dev.ohs.fhir.model.r5.Annotation
import dev.ohs.fhir.model.r5.Attachment
import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CodeableReference
import dev.ohs.fhir.model.r5.Coding
import dev.ohs.fhir.model.r5.Contract
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
import dev.ohs.fhir.model.r5.Markdown
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.Signature
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Time
import dev.ohs.fhir.model.r5.Timing
import dev.ohs.fhir.model.r5.UnsignedInt
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

internal object ContractContentDefinitionSerializer : KSerializer<Contract.ContentDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ContentDefinition") {
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
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("publisher", Reference.serializer().descriptor, isOptional = true)
      element("publicationDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_publicationDate", Element.serializer().descriptor, isOptional = true)
      element("publicationStatus", KotlinString.serializer().descriptor, isOptional = true)
      element("_publicationStatus", Element.serializer().descriptor, isOptional = true)
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.ContentDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.ContentDefinition =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.ContentDefinition) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.ContentDefinition {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var publisher: Reference? = null
    var publicationDate: KotlinString? = null
    var _publicationDate: Element? = null
    var publicationStatus: KotlinString? = null
    var _publicationStatus: Element? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
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
        3 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 -> publicationDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 -> publicationStatus = decoder.decodeStringElement(descriptor, i)
        9 ->
          _publicationStatus =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        10 -> copyright = decoder.decodeStringElement(descriptor, i)
        11 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContentDefinition: " + i)
      }
    }
    return Contract.ContentDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on Contract.ContentDefinition"
          ),
      subType = subType,
      publisher = publisher,
      publicationDate =
        DateTime.of(publicationDate?.let { FhirDateTime.fromString(it) }, _publicationDate),
      publicationStatus =
        Enumeration.of(
          publicationStatus?.let { Contract.ContractResourcePublicationStatusCodes.fromCode(it) },
          _publicationStatus,
        )
          ?: throw SerializationException(
            "Missing required property 'publicationStatus' on Contract.ContentDefinition"
          ),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.ContentDefinition) {
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
    encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    (value.subType)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
    (value.publisher)?.let {
      encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    ((value.publicationStatus.value?.code))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.publicationStatus.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
  }
}

internal object ContractTermSerializer : KSerializer<Contract.Term> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Term") {
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
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("issued", KotlinString.serializer().descriptor, isOptional = true)
      element("_issued", Element.serializer().descriptor, isOptional = true)
      element("applies", Period.serializer().descriptor, isOptional = true)
      element("topicCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("topicReference", Reference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("subType", CodeableConcept.serializer().descriptor, isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element(
        "securityLabel",
        listSerialDescriptor(
          lazyDescriptor { Contract.Term.SecurityLabel.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "offer",
        lazyDescriptor { Contract.Term.Offer.serializer().descriptor },
        isOptional = true,
      )
      element(
        "asset",
        listSerialDescriptor(lazyDescriptor { Contract.Term.Asset.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "action",
        listSerialDescriptor(lazyDescriptor { Contract.Term.Action.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "group",
        listSerialDescriptor(lazyDescriptor { Contract.Term.serializer().descriptor }),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: Identifier? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var applies: Period? = null
    var topicCodeableConcept: CodeableConcept? = null
    var topicReference: Reference? = null
    var type: CodeableConcept? = null
    var subType: CodeableConcept? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var securityLabel: List<Contract.Term.SecurityLabel>? = null
    var offer: Contract.Term.Offer? = null
    var asset: List<Contract.Term.Asset>? = null
    var action: List<Contract.Term.Action>? = null
    var group: List<Contract.Term>? = null
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
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        4 -> issued = decoder.decodeStringElement(descriptor, i)
        5 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        6 ->
          applies = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        7 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          topicReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        9 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        10 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 -> text = decoder.decodeStringElement(descriptor, i)
        12 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermSecurityLabelSerializer.listSerializer,
              null,
            )
        14 ->
          offer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermOfferSerializer,
              null,
            )
        15 ->
          asset =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermAssetSerializer.listSerializer,
              null,
            )
        16 ->
          action =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermActionSerializer.listSerializer,
              null,
            )
        17 ->
          group =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Term: " + i)
      }
    }
    return Contract.Term(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      issued = DateTime.of(issued?.let { FhirDateTime.fromString(it) }, _issued),
      applies = applies,
      topic = Contract.Term.Topic.from(topicCodeableConcept, topicReference),
      type = type,
      subType = subType,
      text = R5String.of(text, _text),
      securityLabel = securityLabel ?: listOf(),
      offer =
        offer ?: throw SerializationException("Missing required property 'offer' on Contract.Term"),
      asset = asset ?: listOf(),
      action = action ?: listOf(),
      group = group ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term) {
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
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, IdentifierSerializer, it)
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, ElementSerializer, it)
    }
    (value.applies)?.let { encoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, it) }
    when (val choice = value.topic) {
      null -> {}
      is Contract.Term.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, choice.value)
      }
      is Contract.Term.Topic.Reference -> {
        encoder.encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 9, CodeableConceptSerializer, it)
    }
    (value.subType)?.let {
      encoder.encodeSerializableElement(descriptor, 10, CodeableConceptSerializer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        ContractTermSecurityLabelSerializer.listSerializer,
        value.securityLabel,
      )
    encoder.encodeSerializableElement(descriptor, 14, ContractTermOfferSerializer, value.offer)
    if (value.asset.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15,
        ContractTermAssetSerializer.listSerializer,
        value.asset,
      )
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16,
        ContractTermActionSerializer.listSerializer,
        value.action,
      )
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17,
        ContractTermSerializer.listSerializer,
        value.group,
      )
  }
}

internal object ContractTermSecurityLabelSerializer : KSerializer<Contract.Term.SecurityLabel> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SecurityLabel") {
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
      element("number", listSerialDescriptor(Int.serializer().descriptor), isOptional = true)
      element("_number", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("classification", Coding.serializer().descriptor, isOptional = true)
      element("category", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
      element("control", listSerialDescriptor(Coding.serializer().descriptor), isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.SecurityLabel>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.SecurityLabel =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.SecurityLabel) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.SecurityLabel {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: List<Int?>? = null
    var _number: List<Element?>? = null
    var classification: Coding? = null
    var category: List<Coding>? = null
    var control: List<Coding>? = null
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
        3 ->
          number =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        5 ->
          classification =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        6 ->
          category =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        7 ->
          control =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodingSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SecurityLabel: " + i)
      }
    }
    return Contract.Term.SecurityLabel(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number =
        (kotlin.collections.List(maxOf(number?.size ?: 0, _number?.size ?: 0)) { index ->
          UnsignedInt.of(number?.getOrNull(index)?.let { it }, _number?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'number' on Contract.Term.SecurityLabel has neither a value nor an id/extension"
            )
        }),
      classification =
        classification
          ?: throw SerializationException(
            "Missing required property 'classification' on Contract.Term.SecurityLabel"
          ),
      category = category ?: listOf(),
      control = control ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.SecurityLabel) {
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
    (value.number.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, intNullableListSerializer, it)
    }
    (value.number.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer.nullableListSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodingSerializer, value.classification)
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        CodingSerializer.listSerializer,
        value.category,
      )
    if (value.control.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        7,
        CodingSerializer.listSerializer,
        value.control,
      )
  }
}

internal object ContractTermOfferSerializer : KSerializer<Contract.Term.Offer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Offer") {
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element(
        "party",
        listSerialDescriptor(lazyDescriptor { Contract.Term.Offer.Party.serializer().descriptor }),
        isOptional = true,
      )
      element("topic", Reference.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("decision", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "decisionMode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "answer",
        listSerialDescriptor(lazyDescriptor { Contract.Term.Offer.Answer.serializer().descriptor }),
        isOptional = true,
      )
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element(
        "linkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_linkId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "securityLabelNumber",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_securityLabelNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Offer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var identifier: List<Identifier>? = null
    var party: List<Contract.Term.Offer.Party>? = null
    var topic: Reference? = null
    var type: CodeableConcept? = null
    var decision: CodeableConcept? = null
    var decisionMode: List<CodeableConcept>? = null
    var answer: List<Contract.Term.Offer.Answer>? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var linkId: List<KotlinString?>? = null
    var _linkId: List<Element?>? = null
    var securityLabelNumber: List<Int?>? = null
    var _securityLabelNumber: List<Element?>? = null
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
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        4 ->
          party =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermOfferPartySerializer.listSerializer,
              null,
            )
        5 ->
          topic =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        6 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        7 ->
          decision =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          decisionMode =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        9 ->
          answer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermOfferAnswerSerializer.listSerializer,
              null,
            )
        10 -> text = decoder.decodeStringElement(descriptor, i)
        11 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        14 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        15 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Offer: " + i)
      }
    }
    return Contract.Term.Offer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      party = party ?: listOf(),
      topic = topic,
      type = type,
      decision = decision,
      decisionMode = decisionMode ?: listOf(),
      answer = answer ?: listOf(),
      text = R5String.of(text, _text),
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { index ->
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'linkId' on Contract.Term.Offer has neither a value nor an id/extension"
            )
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'securityLabelNumber' on Contract.Term.Offer has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Offer) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    if (value.party.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        ContractTermOfferPartySerializer.listSerializer,
        value.party,
      )
    (value.topic)?.let { encoder.encodeSerializableElement(descriptor, 5, ReferenceSerializer, it) }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 6, CodeableConceptSerializer, it)
    }
    (value.decision)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, it)
    }
    if (value.decisionMode.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        CodeableConceptSerializer.listSerializer,
        value.decisionMode,
      )
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        ContractTermOfferAnswerSerializer.listSerializer,
        value.answer,
      )
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, stringNullableListSerializer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, intNullableListSerializer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
  }
}

internal object ContractTermOfferPartySerializer : KSerializer<Contract.Term.Offer.Party> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Party") {
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
        "reference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer.Party>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Party =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Party) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Offer.Party {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: List<Reference>? = null
    var role: CodeableConcept? = null
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
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Party: " + i)
      }
    }
    return Contract.Term.Offer.Party(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference ?: listOf(),
      role =
        role
          ?: throw SerializationException(
            "Missing required property 'role' on Contract.Term.Offer.Party"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Offer.Party) {
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
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        ReferenceSerializer.listSerializer,
        value.reference,
      )
    encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.role)
  }
}

internal object ContractTermOfferAnswerSerializer : KSerializer<Contract.Term.Offer.Answer> {
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
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer.Answer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Answer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Answer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Offer.Answer {
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Answer: " + i)
      }
    }
    return Contract.Term.Offer.Answer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        Contract.Term.Offer.Answer.Value.from(
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
            "Missing required property 'value' on Contract.Term.Offer.Answer"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Offer.Answer) {
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
      is Contract.Term.Offer.Answer.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 13, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 19, AttachmentSerializer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Reference -> {
        encoder.encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object ContractTermAssetSerializer : KSerializer<Contract.Term.Asset> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Asset") {
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
      element("scope", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "type",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "typeReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "subtype",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("relationship", Coding.serializer().descriptor, isOptional = true)
      element(
        "context",
        listSerialDescriptor(
          lazyDescriptor { Contract.Term.Asset.Context.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("condition", KotlinString.serializer().descriptor, isOptional = true)
      element("_condition", Element.serializer().descriptor, isOptional = true)
      element(
        "periodType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("period", listSerialDescriptor(Period.serializer().descriptor), isOptional = true)
      element("usePeriod", listSerialDescriptor(Period.serializer().descriptor), isOptional = true)
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
      element(
        "linkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_linkId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "answer",
        listSerialDescriptor(lazyDescriptor { Contract.Term.Offer.Answer.serializer().descriptor }),
        isOptional = true,
      )
      element(
        "securityLabelNumber",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_securityLabelNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "valuedItem",
        listSerialDescriptor(
          lazyDescriptor { Contract.Term.Asset.ValuedItem.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Asset {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var scope: CodeableConcept? = null
    var type: List<CodeableConcept>? = null
    var typeReference: List<Reference>? = null
    var subtype: List<CodeableConcept>? = null
    var relationship: Coding? = null
    var context: List<Contract.Term.Asset.Context>? = null
    var condition: KotlinString? = null
    var _condition: Element? = null
    var periodType: List<CodeableConcept>? = null
    var period: List<Period>? = null
    var usePeriod: List<Period>? = null
    var text: KotlinString? = null
    var _text: Element? = null
    var linkId: List<KotlinString?>? = null
    var _linkId: List<Element?>? = null
    var answer: List<Contract.Term.Offer.Answer>? = null
    var securityLabelNumber: List<Int?>? = null
    var _securityLabelNumber: List<Element?>? = null
    var valuedItem: List<Contract.Term.Asset.ValuedItem>? = null
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
        3 ->
          scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 ->
          typeReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        6 ->
          subtype =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        7 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        8 ->
          context =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermAssetContextSerializer.listSerializer,
              null,
            )
        9 -> condition = decoder.decodeStringElement(descriptor, i)
        10 ->
          _condition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        11 ->
          periodType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        12 ->
          period =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        13 ->
          usePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer.listSerializer,
              null,
            )
        14 -> text = decoder.decodeStringElement(descriptor, i)
        15 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          answer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermOfferAnswerSerializer.listSerializer,
              null,
            )
        19 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        20 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 ->
          valuedItem =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermAssetValuedItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Asset: " + i)
      }
    }
    return Contract.Term.Asset(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      scope = scope,
      type = type ?: listOf(),
      typeReference = typeReference ?: listOf(),
      subtype = subtype ?: listOf(),
      relationship = relationship,
      context = context ?: listOf(),
      condition = R5String.of(condition, _condition),
      periodType = periodType ?: listOf(),
      period = period ?: listOf(),
      usePeriod = usePeriod ?: listOf(),
      text = R5String.of(text, _text),
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { index ->
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'linkId' on Contract.Term.Asset has neither a value nor an id/extension"
            )
        }),
      answer = answer ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'securityLabelNumber' on Contract.Term.Asset has neither a value nor an id/extension"
            )
        }),
      valuedItem = valuedItem ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Asset) {
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
    (value.scope)?.let {
      encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, it)
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    if (value.typeReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        ReferenceSerializer.listSerializer,
        value.typeReference,
      )
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        CodeableConceptSerializer.listSerializer,
        value.subtype,
      )
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 7, CodingSerializer, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        8,
        ContractTermAssetContextSerializer.listSerializer,
        value.context,
      )
    ((value.condition?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, ElementSerializer, it)
    }
    if (value.periodType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        11,
        CodeableConceptSerializer.listSerializer,
        value.periodType,
      )
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        12,
        PeriodSerializer.listSerializer,
        value.period,
      )
    if (value.usePeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        PeriodSerializer.listSerializer,
        value.usePeriod,
      )
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, ElementSerializer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, stringNullableListSerializer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ContractTermOfferAnswerSerializer.listSerializer,
        value.answer,
      )
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, intNullableListSerializer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.valuedItem.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21,
        ContractTermAssetValuedItemSerializer.listSerializer,
        value.valuedItem,
      )
  }
}

internal object ContractTermAssetContextSerializer : KSerializer<Contract.Term.Asset.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
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
      element("reference", Reference.serializer().descriptor, isOptional = true)
      element(
        "code",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("text", KotlinString.serializer().descriptor, isOptional = true)
      element("_text", Element.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset.Context>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.Context =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.Context) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Asset.Context {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var code: List<CodeableConcept>? = null
    var text: KotlinString? = null
    var _text: Element? = null
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
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        4 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + i)
      }
    }
    return Contract.Term.Asset.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference,
      code = code ?: listOf(),
      text = R5String.of(text, _text),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Asset.Context) {
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
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        CodeableConceptSerializer.listSerializer,
        value.code,
      )
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, ElementSerializer, it)
    }
  }
}

internal object ContractTermAssetValuedItemSerializer :
  KSerializer<Contract.Term.Asset.ValuedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValuedItem") {
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
      element("entityCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("entityReference", Reference.serializer().descriptor, isOptional = true)
      element("identifier", Identifier.serializer().descriptor, isOptional = true)
      element("effectiveTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_effectiveTime", Element.serializer().descriptor, isOptional = true)
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("factor", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("points", FhirDecimalSerializer.descriptor, isOptional = true)
      element("_points", Element.serializer().descriptor, isOptional = true)
      element("net", Money.serializer().descriptor, isOptional = true)
      element("payment", KotlinString.serializer().descriptor, isOptional = true)
      element("_payment", Element.serializer().descriptor, isOptional = true)
      element("paymentDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_paymentDate", Element.serializer().descriptor, isOptional = true)
      element("responsible", Reference.serializer().descriptor, isOptional = true)
      element("recipient", Reference.serializer().descriptor, isOptional = true)
      element(
        "linkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_linkId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "securityLabelNumber",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_securityLabelNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset.ValuedItem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.ValuedItem =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.ValuedItem) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Asset.ValuedItem {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var entityCodeableConcept: CodeableConcept? = null
    var entityReference: Reference? = null
    var identifier: Identifier? = null
    var effectiveTime: KotlinString? = null
    var _effectiveTime: Element? = null
    var quantity: Quantity? = null
    var unitPrice: Money? = null
    var factor: FhirDecimal? = null
    var _factor: Element? = null
    var points: FhirDecimal? = null
    var _points: Element? = null
    var net: Money? = null
    var payment: KotlinString? = null
    var _payment: Element? = null
    var paymentDate: KotlinString? = null
    var _paymentDate: Element? = null
    var responsible: Reference? = null
    var recipient: Reference? = null
    var linkId: List<KotlinString?>? = null
    var _linkId: List<Element?>? = null
    var securityLabelNumber: List<Int?>? = null
    var _securityLabelNumber: List<Element?>? = null
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
        3 ->
          entityCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          entityReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        5 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
        6 -> effectiveTime = decoder.decodeStringElement(descriptor, i)
        7 ->
          _effectiveTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
        9 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        10 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        11 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        12 ->
          points =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        13 ->
          _points =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        14 -> net = decoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        15 -> payment = decoder.decodeStringElement(descriptor, i)
        16 ->
          _payment =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 -> paymentDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          responsible =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          recipient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        22 ->
          _linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        23 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        24 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValuedItem: " + i)
      }
    }
    return Contract.Term.Asset.ValuedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      entity = Contract.Term.Asset.ValuedItem.Entity.from(entityCodeableConcept, entityReference),
      identifier = identifier,
      effectiveTime =
        DateTime.of(effectiveTime?.let { FhirDateTime.fromString(it) }, _effectiveTime),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      points = Decimal.of(points, _points),
      net = net,
      payment = R5String.of(payment, _payment),
      paymentDate = DateTime.of(paymentDate?.let { FhirDateTime.fromString(it) }, _paymentDate),
      responsible = responsible,
      recipient = recipient,
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { index ->
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'linkId' on Contract.Term.Asset.ValuedItem has neither a value nor an id/extension"
            )
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'securityLabelNumber' on Contract.Term.Asset.ValuedItem has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Contract.Term.Asset.ValuedItem,
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
    when (val choice = value.entity) {
      null -> {}
      is Contract.Term.Asset.ValuedItem.Entity.CodeableConcept -> {
        encoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
      }
      is Contract.Term.Asset.ValuedItem.Entity.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 5, IdentifierSerializer, it)
    }
    ((value.effectiveTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.effectiveTime?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, ElementSerializer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, QuantitySerializer, it)
    }
    (value.unitPrice)?.let { encoder.encodeSerializableElement(descriptor, 9, MoneySerializer, it) }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 10, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, ElementSerializer, it)
    }
    ((value.points?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 12, FhirDecimalSerializer, it)
    }
    (value.points?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, ElementSerializer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, MoneySerializer, it) }
    ((value.payment?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.payment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, ElementSerializer, it)
    }
    ((value.paymentDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17, it)
    }
    (value.paymentDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, ElementSerializer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 19, ReferenceSerializer, it)
    }
    (value.recipient)?.let {
      encoder.encodeSerializableElement(descriptor, 20, ReferenceSerializer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 21, stringNullableListSerializer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        22,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 23, intNullableListSerializer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
  }
}

internal object ContractTermActionSerializer : KSerializer<Contract.Term.Action> {
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
      element("doNotPerform", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_doNotPerform", Element.serializer().descriptor, isOptional = true)
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "subject",
        listSerialDescriptor(
          lazyDescriptor { Contract.Term.Action.Subject.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("intent", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "linkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_linkId", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
      element("context", Reference.serializer().descriptor, isOptional = true)
      element(
        "contextLinkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_contextLinkId",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("occurrenceDateTime", KotlinString.serializer().descriptor, isOptional = true)
      element("_occurrenceDateTime", Element.serializer().descriptor, isOptional = true)
      element("occurrencePeriod", Period.serializer().descriptor, isOptional = true)
      element("occurrenceTiming", Timing.serializer().descriptor, isOptional = true)
      element(
        "requester",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "requesterLinkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_requesterLinkId",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "performerType",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("performerRole", CodeableConcept.serializer().descriptor, isOptional = true)
      element("performer", Reference.serializer().descriptor, isOptional = true)
      element(
        "performerLinkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_performerLinkId",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(CodeableReference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonLinkId",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_reasonLinkId",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element("note", listSerialDescriptor(Annotation.serializer().descriptor), isOptional = true)
      element(
        "securityLabelNumber",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_securityLabelNumber",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Action =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Action {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var doNotPerform: KotlinBoolean? = null
    var _doNotPerform: Element? = null
    var type: CodeableConcept? = null
    var subject: List<Contract.Term.Action.Subject>? = null
    var intent: CodeableConcept? = null
    var linkId: List<KotlinString?>? = null
    var _linkId: List<Element?>? = null
    var status: CodeableConcept? = null
    var context: Reference? = null
    var contextLinkId: List<KotlinString?>? = null
    var _contextLinkId: List<Element?>? = null
    var occurrenceDateTime: KotlinString? = null
    var _occurrenceDateTime: Element? = null
    var occurrencePeriod: Period? = null
    var occurrenceTiming: Timing? = null
    var requester: List<Reference>? = null
    var requesterLinkId: List<KotlinString?>? = null
    var _requesterLinkId: List<Element?>? = null
    var performerType: List<CodeableConcept>? = null
    var performerRole: CodeableConcept? = null
    var performer: Reference? = null
    var performerLinkId: List<KotlinString?>? = null
    var _performerLinkId: List<Element?>? = null
    var reason: List<CodeableReference>? = null
    var reasonLinkId: List<KotlinString?>? = null
    var _reasonLinkId: List<Element?>? = null
    var note: List<Annotation>? = null
    var securityLabelNumber: List<Int?>? = null
    var _securityLabelNumber: List<Element?>? = null
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
        3 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        5 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        6 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermActionSubjectSerializer.listSerializer,
              null,
            )
        7 ->
          intent =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        8 ->
          linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        9 ->
          _linkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        10 ->
          status =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        11 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        12 ->
          contextLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        13 ->
          _contextLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        14 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        17 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
        18 ->
          requester =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        19 ->
          requesterLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        20 ->
          _requesterLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 ->
          performerType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        22 ->
          performerRole =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          performerLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        25 ->
          _performerLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        26 ->
          reason =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          reasonLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        28 ->
          _reasonLinkId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        29 ->
          note =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AnnotationSerializer.listSerializer,
              null,
            )
        30 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              intNullableListSerializer,
              null,
            )
        31 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + i)
      }
    }
    return Contract.Term.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      doNotPerform = R5Boolean.of(doNotPerform, _doNotPerform),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on Contract.Term.Action"
          ),
      subject = subject ?: listOf(),
      intent =
        intent
          ?: throw SerializationException(
            "Missing required property 'intent' on Contract.Term.Action"
          ),
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { index ->
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'linkId' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
      status =
        status
          ?: throw SerializationException(
            "Missing required property 'status' on Contract.Term.Action"
          ),
      context = context,
      contextLinkId =
        (kotlin.collections.List(maxOf(contextLinkId?.size ?: 0, _contextLinkId?.size ?: 0)) { index
          ->
          R5String.of(contextLinkId?.getOrNull(index)?.let { it }, _contextLinkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'contextLinkId' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
      occurrence =
        Contract.Term.Action.Occurrence.from(
          DateTime.of(occurrenceDateTime?.let { FhirDateTime.fromString(it) }, _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      requester = requester ?: listOf(),
      requesterLinkId =
        (kotlin.collections.List(maxOf(requesterLinkId?.size ?: 0, _requesterLinkId?.size ?: 0)) {
          index ->
          R5String.of(
            requesterLinkId?.getOrNull(index)?.let { it },
            _requesterLinkId?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'requesterLinkId' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
      performerType = performerType ?: listOf(),
      performerRole = performerRole,
      performer = performer,
      performerLinkId =
        (kotlin.collections.List(maxOf(performerLinkId?.size ?: 0, _performerLinkId?.size ?: 0)) {
          index ->
          R5String.of(
            performerLinkId?.getOrNull(index)?.let { it },
            _performerLinkId?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'performerLinkId' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
      reason = reason ?: listOf(),
      reasonLinkId =
        (kotlin.collections.List(maxOf(reasonLinkId?.size ?: 0, _reasonLinkId?.size ?: 0)) { index
          ->
          R5String.of(reasonLinkId?.getOrNull(index)?.let { it }, _reasonLinkId?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'reasonLinkId' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
      note = note ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'securityLabelNumber' on Contract.Term.Action has neither a value nor an id/extension"
            )
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Action) {
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
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, ElementSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        6,
        ContractTermActionSubjectSerializer.listSerializer,
        value.subject,
      )
    encoder.encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, value.intent)
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, stringNullableListSerializer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, ElementSerializer.nullableListSerializer, it)
    }
    encoder.encodeSerializableElement(descriptor, 10, CodeableConceptSerializer, value.status)
    (value.context)?.let {
      encoder.encodeSerializableElement(descriptor, 11, ReferenceSerializer, it)
    }
    (value.contextLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, stringNullableListSerializer, it)
    }
    (value.contextLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        13,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    when (val choice = value.occurrence) {
      null -> {}
      is Contract.Term.Action.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, ElementSerializer, it)
        }
      }
      is Contract.Term.Action.Occurrence.Period -> {
        encoder.encodeSerializableElement(descriptor, 16, PeriodSerializer, choice.value)
      }
      is Contract.Term.Action.Occurrence.Timing -> {
        encoder.encodeSerializableElement(descriptor, 17, TimingSerializer, choice.value)
      }
    }
    if (value.requester.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        18,
        ReferenceSerializer.listSerializer,
        value.requester,
      )
    (value.requesterLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, stringNullableListSerializer, it)
    }
    (value.requesterLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.performerType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21,
        CodeableConceptSerializer.listSerializer,
        value.performerType,
      )
    (value.performerRole)?.let {
      encoder.encodeSerializableElement(descriptor, 22, CodeableConceptSerializer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 23, ReferenceSerializer, it)
    }
    (value.performerLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 24, stringNullableListSerializer, it)
    }
    (value.performerLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26,
        CodeableReferenceSerializer.listSerializer,
        value.reason,
      )
    (value.reasonLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 27, stringNullableListSerializer, it)
    }
    (value.reasonLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29,
        AnnotationSerializer.listSerializer,
        value.note,
      )
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 30, intNullableListSerializer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
  }
}

internal object ContractTermActionSubjectSerializer : KSerializer<Contract.Term.Action.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subject") {
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
        "reference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("role", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Action.Subject>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Action.Subject =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action.Subject) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Term.Action.Subject {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: List<Reference>? = null
    var role: CodeableConcept? = null
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
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        4 ->
          role =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subject: " + i)
      }
    }
    return Contract.Term.Action.Subject(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference ?: listOf(),
      role = role,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Action.Subject) {
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
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        3,
        ReferenceSerializer.listSerializer,
        value.reference,
      )
    (value.role)?.let {
      encoder.encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, it)
    }
  }
}

internal object ContractSignerSerializer : KSerializer<Contract.Signer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Signer") {
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
      element("type", Coding.serializer().descriptor, isOptional = true)
      element("party", Reference.serializer().descriptor, isOptional = true)
      element(
        "signature",
        listSerialDescriptor(Signature.serializer().descriptor),
        isOptional = true,
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Signer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Signer =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Signer) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Signer {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: Coding? = null
    var party: Reference? = null
    var signature: List<Signature>? = null
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
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
        4 ->
          party =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        5 ->
          signature =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              SignatureSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Signer: " + i)
      }
    }
    return Contract.Signer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Contract.Signer"),
      party =
        party
          ?: throw SerializationException("Missing required property 'party' on Contract.Signer"),
      signature = signature ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Signer) {
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
    encoder.encodeSerializableElement(descriptor, 3, CodingSerializer, value.type)
    encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.party)
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        SignatureSerializer.listSerializer,
        value.signature,
      )
  }
}

internal object ContractFriendlySerializer : KSerializer<Contract.Friendly> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Friendly") {
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
      element("contentAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("contentReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Friendly>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Friendly =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Friendly) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Friendly {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
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
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Friendly: " + i)
      }
    }
    return Contract.Friendly(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        Contract.Friendly.Content.from(contentAttachment, contentReference)
          ?: throw SerializationException(
            "Missing required property 'content' on Contract.Friendly"
          ),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Friendly) {
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
    when (val choice = value.content) {
      is Contract.Friendly.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
      }
      is Contract.Friendly.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object ContractLegalSerializer : KSerializer<Contract.Legal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Legal") {
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
      element("contentAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("contentReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Legal>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Legal =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Legal) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Legal {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
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
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Legal: " + i)
      }
    }
    return Contract.Legal(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        Contract.Legal.Content.from(contentAttachment, contentReference)
          ?: throw SerializationException("Missing required property 'content' on Contract.Legal"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Legal) {
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
    when (val choice = value.content) {
      is Contract.Legal.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
      }
      is Contract.Legal.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object ContractRuleSerializer : KSerializer<Contract.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
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
      element("contentAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("contentReference", Reference.serializer().descriptor, isOptional = true)
    }

  internal val listSerializer: KSerializer<List<Contract.Rule>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Rule =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Rule) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Contract.Rule {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
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
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + i)
      }
    }
    return Contract.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content =
        Contract.Rule.Content.from(contentAttachment, contentReference)
          ?: throw SerializationException("Missing required property 'content' on Contract.Rule"),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Rule) {
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
    when (val choice = value.content) {
      is Contract.Rule.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
      }
      is Contract.Rule.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
      }
    }
  }
}

internal object ContractSerializer : KSerializer<Contract> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contract") {
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
    b.element("url", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_url", Element.serializer().descriptor, isOptional = true)
    b.element("version", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_version", Element.serializer().descriptor, isOptional = true)
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element("legalState", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("instantiatesCanonical", Reference.serializer().descriptor, isOptional = true)
    b.element("instantiatesUri", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_instantiatesUri", Element.serializer().descriptor, isOptional = true)
    b.element("contentDerivative", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("issued", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_issued", Element.serializer().descriptor, isOptional = true)
    b.element("applies", Period.serializer().descriptor, isOptional = true)
    b.element("expirationType", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("subject", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "authority",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("domain", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("site", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element("title", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_title", Element.serializer().descriptor, isOptional = true)
    b.element("subtitle", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subtitle", Element.serializer().descriptor, isOptional = true)
    b.element(
      "alias",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_alias", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("author", Reference.serializer().descriptor, isOptional = true)
    b.element("scope", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("topicCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("topicReference", Reference.serializer().descriptor, isOptional = true)
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "subType",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "contentDefinition",
      lazyDescriptor { Contract.ContentDefinition.serializer().descriptor },
      isOptional = true,
    )
    b.element(
      "term",
      listSerialDescriptor(lazyDescriptor { Contract.Term.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "supportingInfo",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "relevantHistory",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "signer",
      listSerialDescriptor(lazyDescriptor { Contract.Signer.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "friendly",
      listSerialDescriptor(lazyDescriptor { Contract.Friendly.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "legal",
      listSerialDescriptor(lazyDescriptor { Contract.Legal.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "rule",
      listSerialDescriptor(lazyDescriptor { Contract.Rule.serializer().descriptor }),
      isOptional = true,
    )
    b.element("legallyBindingAttachment", Attachment.serializer().descriptor, isOptional = true)
    b.element("legallyBindingReference", Reference.serializer().descriptor, isOptional = true)
  }

  override fun deserialize(decoder: Decoder): Contract =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Contract) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Contract")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Contract {
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
    var url: KotlinString? = null
    var _url: Element? = null
    var version: KotlinString? = null
    var _version: Element? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var legalState: CodeableConcept? = null
    var instantiatesCanonical: Reference? = null
    var instantiatesUri: KotlinString? = null
    var _instantiatesUri: Element? = null
    var contentDerivative: CodeableConcept? = null
    var issued: KotlinString? = null
    var _issued: Element? = null
    var applies: Period? = null
    var expirationType: CodeableConcept? = null
    var subject: List<Reference>? = null
    var authority: List<Reference>? = null
    var domain: List<Reference>? = null
    var site: List<Reference>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var title: KotlinString? = null
    var _title: Element? = null
    var subtitle: KotlinString? = null
    var _subtitle: Element? = null
    var alias: List<KotlinString?>? = null
    var _alias: List<Element?>? = null
    var author: Reference? = null
    var scope: CodeableConcept? = null
    var topicCodeableConcept: CodeableConcept? = null
    var topicReference: Reference? = null
    var type: CodeableConcept? = null
    var subType: List<CodeableConcept>? = null
    var contentDefinition: Contract.ContentDefinition? = null
    var term: List<Contract.Term>? = null
    var supportingInfo: List<Reference>? = null
    var relevantHistory: List<Reference>? = null
    var signer: List<Contract.Signer>? = null
    var friendly: List<Contract.Friendly>? = null
    var legal: List<Contract.Legal>? = null
    var rule: List<Contract.Rule>? = null
    var legallyBindingAttachment: Attachment? = null
    var legallyBindingReference: Reference? = null
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
        11 -> url = decoder.decodeStringElement(descriptor, i)
        12 ->
          _url = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          legalState =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        18 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 -> instantiatesUri = decoder.decodeStringElement(descriptor, i)
        20 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          contentDerivative =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 -> issued = decoder.decodeStringElement(descriptor, i)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        24 ->
          applies = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        25 ->
          expirationType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        27 ->
          authority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        28 ->
          domain =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        29 ->
          site =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        30 -> name = decoder.decodeStringElement(descriptor, i)
        31 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        32 -> title = decoder.decodeStringElement(descriptor, i)
        33 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 -> subtitle = decoder.decodeStringElement(descriptor, i)
        35 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        36 ->
          alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        37 ->
          _alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        38 ->
          author =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        39 ->
          scope =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        40 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        41 ->
          topicReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        42 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        43 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        44 ->
          contentDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractContentDefinitionSerializer,
              null,
            )
        45 ->
          term =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractTermSerializer.listSerializer,
              null,
            )
        46 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        47 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        48 ->
          signer =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractSignerSerializer.listSerializer,
              null,
            )
        49 ->
          friendly =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractFriendlySerializer.listSerializer,
              null,
            )
        50 ->
          legal =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractLegalSerializer.listSerializer,
              null,
            )
        51 ->
          rule =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContractRuleSerializer.listSerializer,
              null,
            )
        52 ->
          legallyBindingAttachment =
            decoder.decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
        53 ->
          legallyBindingReference =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        else -> throw SerializationException("Unexpected index decoding Contract: " + i)
      }
    }
    return Contract(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      url = Uri.of(url, _url),
      version = R5String.of(version, _version),
      status =
        Enumeration.of(status?.let { Contract.ContractResourceStatusCodes.fromCode(it) }, _status),
      legalState = legalState,
      instantiatesCanonical = instantiatesCanonical,
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      contentDerivative = contentDerivative,
      issued = DateTime.of(issued?.let { FhirDateTime.fromString(it) }, _issued),
      applies = applies,
      expirationType = expirationType,
      subject = subject ?: listOf(),
      authority = authority ?: listOf(),
      domain = domain ?: listOf(),
      site = site ?: listOf(),
      name = R5String.of(name, _name),
      title = R5String.of(title, _title),
      subtitle = R5String.of(subtitle, _subtitle),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R5String.of(alias?.getOrNull(index)?.let { it }, _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on Contract has neither a value nor an id/extension"
            )
        }),
      author = author,
      scope = scope,
      topic = Contract.Topic.from(topicCodeableConcept, topicReference),
      type = type,
      subType = subType ?: listOf(),
      contentDefinition = contentDefinition,
      term = term ?: listOf(),
      supportingInfo = supportingInfo ?: listOf(),
      relevantHistory = relevantHistory ?: listOf(),
      signer = signer ?: listOf(),
      friendly = friendly ?: listOf(),
      legal = legal ?: listOf(),
      rule = rule ?: listOf(),
      legallyBinding =
        Contract.LegallyBinding.from(legallyBindingAttachment, legallyBindingReference),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Contract,
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
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12 + descriptorOffset, ElementSerializer, it)
    }
    ((value.version?.value))?.let {
      encoder.encodeStringElement(descriptor, 13 + descriptorOffset, it)
    }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, ElementSerializer, it)
    }
    ((value.status?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, ElementSerializer, it)
    }
    (value.legalState)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    (value.instantiatesCanonical)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, ReferenceSerializer, it)
    }
    ((value.instantiatesUri?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, ElementSerializer, it)
    }
    (value.contentDerivative)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, ElementSerializer, it)
    }
    (value.applies)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, PeriodSerializer, it)
    }
    (value.expirationType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.subject,
      )
    if (value.authority.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.authority,
      )
    if (value.domain.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.domain,
      )
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.site,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, ElementSerializer, it)
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 33 + descriptorOffset, ElementSerializer, it)
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 35 + descriptorOffset, ElementSerializer, it)
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        36 + descriptorOffset,
        stringNullableListSerializer,
        it,
      )
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(
        descriptor,
        37 + descriptorOffset,
        ElementSerializer.nullableListSerializer,
        it,
      )
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(descriptor, 38 + descriptorOffset, ReferenceSerializer, it)
    }
    (value.scope)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    when (val choice = value.topic) {
      null -> {}
      is Contract.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          40 + descriptorOffset,
          CodeableConceptSerializer,
          choice.value,
        )
      }
      is Contract.Topic.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        CodeableConceptSerializer,
        it,
      )
    }
    if (value.subType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.subType,
      )
    (value.contentDefinition)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ContractContentDefinitionSerializer,
        it,
      )
    }
    if (value.term.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ContractTermSerializer.listSerializer,
        value.term,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.relevantHistory,
      )
    if (value.signer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        ContractSignerSerializer.listSerializer,
        value.signer,
      )
    if (value.friendly.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        ContractFriendlySerializer.listSerializer,
        value.friendly,
      )
    if (value.legal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        ContractLegalSerializer.listSerializer,
        value.legal,
      )
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        ContractRuleSerializer.listSerializer,
        value.rule,
      )
    when (val choice = value.legallyBinding) {
      null -> {}
      is Contract.LegallyBinding.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          52 + descriptorOffset,
          AttachmentSerializer,
          choice.value,
        )
      }
      is Contract.LegallyBinding.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          53 + descriptorOffset,
          ReferenceSerializer,
          choice.value,
        )
      }
    }
  }
}

internal object ContractPolymorphicSerializer : KSerializer<Contract> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contract") { ContractSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Contract) {
    encoder.encodeStructure(descriptor) {
      ContractSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Contract =
    decoder.decodeStructure(descriptor) {
      ContractSerializer.deserializeInternal(this, descriptor, 0)
    }
}
