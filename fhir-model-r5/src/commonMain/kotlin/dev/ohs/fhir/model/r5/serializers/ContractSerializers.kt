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
import dev.ohs.fhir.model.r5.FhirResourceSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("subType", CodeableConceptSerializer.descriptor)
      optionalElement("publisher", ReferenceSerializer.descriptor)
      optionalElement("publicationDate", KotlinString.serializer().descriptor)
      optionalElement("_publicationDate", ElementSerializer.descriptor)
      optionalElement("publicationStatus", KotlinString.serializer().descriptor)
      optionalElement("_publicationStatus", ElementSerializer.descriptor)
      optionalElement("copyright", KotlinString.serializer().descriptor)
      optionalElement("_copyright", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.ContentDefinition>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.ContentDefinition =
    decoder.decodeStructure(descriptor) {
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
          3 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            subType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            publisher = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> publicationDate = decodeStringElement(descriptor, i)
          7 ->
            _publicationDate =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> publicationStatus = decodeStringElement(descriptor, i)
          9 ->
            _publicationStatus =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 -> copyright = decodeStringElement(descriptor, i)
          11 ->
            _copyright = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ContentDefinition: " + i)
        }
      }
      Contract.ContentDefinition(
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
          DateTime.of(
            if (publicationDate != null) FhirDateTime.fromString(publicationDate) else null,
            _publicationDate,
          ),
        publicationStatus =
          Enumeration.of(
            if (publicationStatus != null)
              Contract.ContractResourcePublicationStatusCodes.fromCode(publicationStatus)
            else null,
            _publicationStatus,
          )
            ?: throw SerializationException(
              "Missing required property 'publicationStatus' on Contract.ContentDefinition"
            ),
        copyright = Markdown.of(copyright, _copyright),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.ContentDefinition) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.subType)
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.publisher)
      encodeStringIfNotNull(descriptor, 6, value.publicationDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.publicationDate)
      encodeStringIfNotNull(descriptor, 8, value.publicationStatus.value?.code)
      encodeElementIfNotNull(descriptor, 9, value.publicationStatus)
      encodeStringIfNotNull(descriptor, 10, value.copyright?.value)
      encodeElementIfNotNull(descriptor, 11, value.copyright)
    }
  }
}

internal object ContractTermSerializer : KSerializer<Contract.Term> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Term") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("issued", KotlinString.serializer().descriptor)
      optionalElement("_issued", ElementSerializer.descriptor)
      optionalElement("applies", PeriodSerializer.descriptor)
      optionalElement("topicCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("topicReference", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("subType", CodeableConceptSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement(
        "securityLabel",
        ContractTermSecurityLabelSerializer.listSerializer.descriptor,
      )
      optionalElement("offer", ContractTermOfferSerializer.descriptor)
      optionalElement("asset", ContractTermAssetSerializer.listSerializer.descriptor)
      optionalElement("action", ContractTermActionSerializer.listSerializer.descriptor)
      optionalElement(
        "group",
        listSerialDescriptor(lazyDescriptor { ContractTermSerializer.descriptor }),
      )
    }

  internal val listSerializer: KSerializer<List<Contract.Term>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term =
    decoder.decodeStructure(descriptor) {
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
          3 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          4 -> issued = decodeStringElement(descriptor, i)
          5 -> _issued = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> applies = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          7 ->
            topicCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            topicReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          10 ->
            subType =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 -> text = decodeStringElement(descriptor, i)
          12 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            securityLabel =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermSecurityLabelSerializer.listSerializer,
                null,
              )
          14 ->
            offer =
              decodeNullableSerializableElement(descriptor, i, ContractTermOfferSerializer, null)
          15 ->
            asset =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermAssetSerializer.listSerializer,
                null,
              )
          16 ->
            action =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermActionSerializer.listSerializer,
                null,
              )
          17 ->
            group =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Term: " + i)
        }
      }
      Contract.Term(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier,
        issued =
          DateTime.of(if (issued != null) FhirDateTime.fromString(issued) else null, _issued),
        applies = applies,
        topic = Contract.Term.Topic.from(topicCodeableConcept, topicReference),
        type = type,
        subType = subType,
        text = R5String.of(text, _text),
        securityLabel = securityLabel ?: listOf(),
        offer =
          offer
            ?: throw SerializationException("Missing required property 'offer' on Contract.Term"),
        asset = asset ?: listOf(),
        action = action ?: listOf(),
        group = group ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term) {
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
      encodeSerializableIfNotNull(descriptor, 3, IdentifierSerializer, value.identifier)
      encodeStringIfNotNull(descriptor, 4, value.issued?.value?.toString())
      encodeElementIfNotNull(descriptor, 5, value.issued)
      encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.applies)
      when (val choice = value.topic) {
        null -> {}
        is Contract.Term.Topic.CodeableConcept -> {
          encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, choice.value)
        }
        is Contract.Term.Topic.Reference -> {
          encodeSerializableElement(descriptor, 8, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 9, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 10, CodeableConceptSerializer, value.subType)
      encodeStringIfNotNull(descriptor, 11, value.text?.value)
      encodeElementIfNotNull(descriptor, 12, value.text)
      if (value.securityLabel.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          13,
          ContractTermSecurityLabelSerializer.listSerializer,
          value.securityLabel,
        )
      encodeSerializableElement(descriptor, 14, ContractTermOfferSerializer, value.offer)
      if (value.asset.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          15,
          ContractTermAssetSerializer.listSerializer,
          value.asset,
        )
      if (value.action.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          ContractTermActionSerializer.listSerializer,
          value.action,
        )
      if (value.group.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          17,
          ContractTermSerializer.listSerializer,
          value.group,
        )
    }
  }
}

internal object ContractTermSecurityLabelSerializer : KSerializer<Contract.Term.SecurityLabel> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SecurityLabel") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("number", intNullableListSerializer.descriptor)
      optionalElement("_number", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("classification", CodingSerializer.descriptor)
      optionalElement("category", CodingSerializer.listSerializer.descriptor)
      optionalElement("control", CodingSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.SecurityLabel>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.SecurityLabel =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var number: List<Int?>? = null
      var _number: List<Element?>? = null
      var classification: Coding? = null
      var category: List<Coding>? = null
      var control: List<Coding>? = null
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
          3 ->
            number =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          4 ->
            _number =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 ->
            classification =
              decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          6 ->
            category =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          7 ->
            control =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodingSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SecurityLabel: " + i)
        }
      }
      Contract.Term.SecurityLabel(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        number =
          (kotlin.collections.List(maxOf(number?.size ?: 0, _number?.size ?: 0)) { index ->
            UnsignedInt.of(number?.getOrNull(index), _number?.getOrNull(index))
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term.SecurityLabel) {
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
      if (value.number.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          intNullableListSerializer,
          value.number.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 4, value.number)
      }
      encodeSerializableElement(descriptor, 5, CodingSerializer, value.classification)
      if (value.category.isNotEmpty())
        encodeSerializableElement(descriptor, 6, CodingSerializer.listSerializer, value.category)
      if (value.control.isNotEmpty())
        encodeSerializableElement(descriptor, 7, CodingSerializer.listSerializer, value.control)
    }
  }
}

internal object ContractTermOfferSerializer : KSerializer<Contract.Term.Offer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Offer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("party", ContractTermOfferPartySerializer.listSerializer.descriptor)
      optionalElement("topic", ReferenceSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("decision", CodeableConceptSerializer.descriptor)
      optionalElement("decisionMode", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("answer", ContractTermOfferAnswerSerializer.listSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("linkId", stringNullableListSerializer.descriptor)
      optionalElement("_linkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("securityLabelNumber", intNullableListSerializer.descriptor)
      optionalElement("_securityLabelNumber", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer =
    decoder.decodeStructure(descriptor) {
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
          3 ->
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            party =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermOfferPartySerializer.listSerializer,
                null,
              )
          5 -> topic = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            decision =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            decisionMode =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          9 ->
            answer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermOfferAnswerSerializer.listSerializer,
                null,
              )
          10 -> text = decodeStringElement(descriptor, i)
          11 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            linkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _linkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          14 ->
            securityLabelNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          15 ->
            _securityLabelNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Offer: " + i)
        }
      }
      Contract.Term.Offer(
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
            R5String.of(linkId?.getOrNull(index), _linkId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'linkId' on Contract.Term.Offer has neither a value nor an id/extension"
              )
          }),
        securityLabelNumber =
          (kotlin.collections.List(
            maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
          ) { index ->
            UnsignedInt.of(
              securityLabelNumber?.getOrNull(index),
              _securityLabelNumber?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'securityLabelNumber' on Contract.Term.Offer has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      if (value.party.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ContractTermOfferPartySerializer.listSerializer,
          value.party,
        )
      encodeSerializableIfNotNull(descriptor, 5, ReferenceSerializer, value.topic)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.decision)
      if (value.decisionMode.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          CodeableConceptSerializer.listSerializer,
          value.decisionMode,
        )
      if (value.answer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          ContractTermOfferAnswerSerializer.listSerializer,
          value.answer,
        )
      encodeStringIfNotNull(descriptor, 10, value.text?.value)
      encodeElementIfNotNull(descriptor, 11, value.text)
      if (value.linkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.linkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.linkId)
      }
      if (value.securityLabelNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          14,
          intNullableListSerializer,
          value.securityLabelNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 15, value.securityLabelNumber)
      }
    }
  }
}

internal object ContractTermOfferPartySerializer : KSerializer<Contract.Term.Offer.Party> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Party") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer.Party>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Party =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: List<Reference>? = null
      var role: CodeableConcept? = null
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
          3 ->
            reference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Party: " + i)
        }
      }
      Contract.Term.Offer.Party(
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

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Party) {
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
      if (value.reference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ReferenceSerializer.listSerializer,
          value.reference,
        )
      encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, value.role)
    }
  }
}

internal object ContractTermOfferAnswerSerializer : KSerializer<Contract.Term.Offer.Answer> {
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
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Offer.Answer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Answer =
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
          else -> throw SerializationException("Unexpected index decoding Answer: " + i)
        }
      }
      Contract.Term.Offer.Answer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` =
          Contract.Term.Offer.Answer.Value.from(
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
              "Missing required property 'value' on Contract.Term.Offer.Answer"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Answer) {
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
        is Contract.Term.Offer.Answer.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 3, choice.value.value)
          encodeElementIfNotNull(descriptor, 4, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Decimal -> {
          encodeSerializableIfNotNull(descriptor, 5, FhirDecimalSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 6, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Integer -> {
          encodeIntIfNotNull(descriptor, 7, choice.value.value)
          encodeElementIfNotNull(descriptor, 8, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Date -> {
          encodeStringIfNotNull(descriptor, 9, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.DateTime -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Time -> {
          encodeSerializableIfNotNull(descriptor, 13, LocalTimeSerializer, choice.value.value)
          encodeElementIfNotNull(descriptor, 14, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.String -> {
          encodeStringIfNotNull(descriptor, 15, choice.value.value)
          encodeElementIfNotNull(descriptor, 16, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Uri -> {
          encodeStringIfNotNull(descriptor, 17, choice.value.value)
          encodeElementIfNotNull(descriptor, 18, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Attachment -> {
          encodeSerializableElement(descriptor, 19, AttachmentSerializer, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Coding -> {
          encodeSerializableElement(descriptor, 20, CodingSerializer, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Quantity -> {
          encodeSerializableElement(descriptor, 21, QuantitySerializer, choice.value)
        }
        is Contract.Term.Offer.Answer.Value.Reference -> {
          encodeSerializableElement(descriptor, 22, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ContractTermAssetSerializer : KSerializer<Contract.Term.Asset> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Asset") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("scope", CodeableConceptSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("typeReference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("subtype", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("relationship", CodingSerializer.descriptor)
      optionalElement("context", ContractTermAssetContextSerializer.listSerializer.descriptor)
      optionalElement("condition", KotlinString.serializer().descriptor)
      optionalElement("_condition", ElementSerializer.descriptor)
      optionalElement("periodType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("period", PeriodSerializer.listSerializer.descriptor)
      optionalElement("usePeriod", PeriodSerializer.listSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
      optionalElement("linkId", stringNullableListSerializer.descriptor)
      optionalElement("_linkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("answer", ContractTermOfferAnswerSerializer.listSerializer.descriptor)
      optionalElement("securityLabelNumber", intNullableListSerializer.descriptor)
      optionalElement("_securityLabelNumber", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("valuedItem", ContractTermAssetValuedItemSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset =
    decoder.decodeStructure(descriptor) {
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
          3 ->
            scope =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            type =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 ->
            typeReference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            subtype =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          7 ->
            relationship = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          8 ->
            context =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermAssetContextSerializer.listSerializer,
                null,
              )
          9 -> condition = decodeStringElement(descriptor, i)
          10 ->
            _condition = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 ->
            periodType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          12 ->
            period =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PeriodSerializer.listSerializer,
                null,
              )
          13 ->
            usePeriod =
              decodeNullableSerializableElement(
                descriptor,
                i,
                PeriodSerializer.listSerializer,
                null,
              )
          14 -> text = decodeStringElement(descriptor, i)
          15 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            linkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          17 ->
            _linkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          18 ->
            answer =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermOfferAnswerSerializer.listSerializer,
                null,
              )
          19 ->
            securityLabelNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          20 ->
            _securityLabelNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          21 ->
            valuedItem =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermAssetValuedItemSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Asset: " + i)
        }
      }
      Contract.Term.Asset(
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
            R5String.of(linkId?.getOrNull(index), _linkId?.getOrNull(index))
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
              securityLabelNumber?.getOrNull(index),
              _securityLabelNumber?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'securityLabelNumber' on Contract.Term.Asset has neither a value nor an id/extension"
              )
          }),
        valuedItem = valuedItem ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.scope)
      if (value.type.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.type,
        )
      if (value.typeReference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ReferenceSerializer.listSerializer,
          value.typeReference,
        )
      if (value.subtype.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          CodeableConceptSerializer.listSerializer,
          value.subtype,
        )
      encodeSerializableIfNotNull(descriptor, 7, CodingSerializer, value.relationship)
      if (value.context.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          ContractTermAssetContextSerializer.listSerializer,
          value.context,
        )
      encodeStringIfNotNull(descriptor, 9, value.condition?.value)
      encodeElementIfNotNull(descriptor, 10, value.condition)
      if (value.periodType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          11,
          CodeableConceptSerializer.listSerializer,
          value.periodType,
        )
      if (value.period.isNotEmpty())
        encodeSerializableElement(descriptor, 12, PeriodSerializer.listSerializer, value.period)
      if (value.usePeriod.isNotEmpty())
        encodeSerializableElement(descriptor, 13, PeriodSerializer.listSerializer, value.usePeriod)
      encodeStringIfNotNull(descriptor, 14, value.text?.value)
      encodeElementIfNotNull(descriptor, 15, value.text)
      if (value.linkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          16,
          stringNullableListSerializer,
          value.linkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 17, value.linkId)
      }
      if (value.answer.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ContractTermOfferAnswerSerializer.listSerializer,
          value.answer,
        )
      if (value.securityLabelNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          19,
          intNullableListSerializer,
          value.securityLabelNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 20, value.securityLabelNumber)
      }
      if (value.valuedItem.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
          ContractTermAssetValuedItemSerializer.listSerializer,
          value.valuedItem,
        )
    }
  }
}

internal object ContractTermAssetContextSerializer : KSerializer<Contract.Term.Asset.Context> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Context") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("text", KotlinString.serializer().descriptor)
      optionalElement("_text", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset.Context>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.Context =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: Reference? = null
      var code: List<CodeableConcept>? = null
      var text: KotlinString? = null
      var _text: Element? = null
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
          3 ->
            reference = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 ->
            code =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          5 -> text = decodeStringElement(descriptor, i)
          6 -> _text = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Context: " + i)
        }
      }
      Contract.Term.Asset.Context(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference = reference,
        code = code ?: listOf(),
        text = R5String.of(text, _text),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.Context) {
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
      encodeSerializableIfNotNull(descriptor, 3, ReferenceSerializer, value.reference)
      if (value.code.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          CodeableConceptSerializer.listSerializer,
          value.code,
        )
      encodeStringIfNotNull(descriptor, 5, value.text?.value)
      encodeElementIfNotNull(descriptor, 6, value.text)
    }
  }
}

internal object ContractTermAssetValuedItemSerializer :
  KSerializer<Contract.Term.Asset.ValuedItem> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ValuedItem") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("entityCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("entityReference", ReferenceSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.descriptor)
      optionalElement("effectiveTime", KotlinString.serializer().descriptor)
      optionalElement("_effectiveTime", ElementSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("points", FhirDecimalSerializer.descriptor)
      optionalElement("_points", ElementSerializer.descriptor)
      optionalElement("net", MoneySerializer.descriptor)
      optionalElement("payment", KotlinString.serializer().descriptor)
      optionalElement("_payment", ElementSerializer.descriptor)
      optionalElement("paymentDate", KotlinString.serializer().descriptor)
      optionalElement("_paymentDate", ElementSerializer.descriptor)
      optionalElement("responsible", ReferenceSerializer.descriptor)
      optionalElement("recipient", ReferenceSerializer.descriptor)
      optionalElement("linkId", stringNullableListSerializer.descriptor)
      optionalElement("_linkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("securityLabelNumber", intNullableListSerializer.descriptor)
      optionalElement("_securityLabelNumber", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Asset.ValuedItem>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Asset.ValuedItem =
    decoder.decodeStructure(descriptor) {
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
          3 ->
            entityCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            entityReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            identifier =
              decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          6 -> effectiveTime = decodeStringElement(descriptor, i)
          7 ->
            _effectiveTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          10 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          11 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          12 ->
            points = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          13 -> _points = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          14 -> net = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          15 -> payment = decodeStringElement(descriptor, i)
          16 -> _payment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          17 -> paymentDate = decodeStringElement(descriptor, i)
          18 ->
            _paymentDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            responsible =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          20 ->
            recipient = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          21 ->
            linkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          22 ->
            _linkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          23 ->
            securityLabelNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          24 ->
            _securityLabelNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding ValuedItem: " + i)
        }
      }
      Contract.Term.Asset.ValuedItem(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        entity = Contract.Term.Asset.ValuedItem.Entity.from(entityCodeableConcept, entityReference),
        identifier = identifier,
        effectiveTime =
          DateTime.of(
            if (effectiveTime != null) FhirDateTime.fromString(effectiveTime) else null,
            _effectiveTime,
          ),
        quantity = quantity,
        unitPrice = unitPrice,
        factor = Decimal.of(factor, _factor),
        points = Decimal.of(points, _points),
        net = net,
        payment = R5String.of(payment, _payment),
        paymentDate =
          DateTime.of(
            if (paymentDate != null) FhirDateTime.fromString(paymentDate) else null,
            _paymentDate,
          ),
        responsible = responsible,
        recipient = recipient,
        linkId =
          (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { index ->
            R5String.of(linkId?.getOrNull(index), _linkId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'linkId' on Contract.Term.Asset.ValuedItem has neither a value nor an id/extension"
              )
          }),
        securityLabelNumber =
          (kotlin.collections.List(
            maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
          ) { index ->
            UnsignedInt.of(
              securityLabelNumber?.getOrNull(index),
              _securityLabelNumber?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'securityLabelNumber' on Contract.Term.Asset.ValuedItem has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.ValuedItem) {
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
      when (val choice = value.entity) {
        null -> {}
        is Contract.Term.Asset.ValuedItem.Entity.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is Contract.Term.Asset.ValuedItem.Entity.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 5, IdentifierSerializer, value.identifier)
      encodeStringIfNotNull(descriptor, 6, value.effectiveTime?.value?.toString())
      encodeElementIfNotNull(descriptor, 7, value.effectiveTime)
      encodeSerializableIfNotNull(descriptor, 8, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 9, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 10, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 11, value.factor)
      encodeSerializableIfNotNull(descriptor, 12, FhirDecimalSerializer, value.points?.value)
      encodeElementIfNotNull(descriptor, 13, value.points)
      encodeSerializableIfNotNull(descriptor, 14, MoneySerializer, value.net)
      encodeStringIfNotNull(descriptor, 15, value.payment?.value)
      encodeElementIfNotNull(descriptor, 16, value.payment)
      encodeStringIfNotNull(descriptor, 17, value.paymentDate?.value?.toString())
      encodeElementIfNotNull(descriptor, 18, value.paymentDate)
      encodeSerializableIfNotNull(descriptor, 19, ReferenceSerializer, value.responsible)
      encodeSerializableIfNotNull(descriptor, 20, ReferenceSerializer, value.recipient)
      if (value.linkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          21,
          stringNullableListSerializer,
          value.linkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 22, value.linkId)
      }
      if (value.securityLabelNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          23,
          intNullableListSerializer,
          value.securityLabelNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 24, value.securityLabelNumber)
      }
    }
  }
}

internal object ContractTermActionSerializer : KSerializer<Contract.Term.Action> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Action") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("doNotPerform", KotlinBoolean.serializer().descriptor)
      optionalElement("_doNotPerform", ElementSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("subject", ContractTermActionSubjectSerializer.listSerializer.descriptor)
      optionalElement("intent", CodeableConceptSerializer.descriptor)
      optionalElement("linkId", stringNullableListSerializer.descriptor)
      optionalElement("_linkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
      optionalElement("context", ReferenceSerializer.descriptor)
      optionalElement("contextLinkId", stringNullableListSerializer.descriptor)
      optionalElement("_contextLinkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("occurrenceDateTime", KotlinString.serializer().descriptor)
      optionalElement("_occurrenceDateTime", ElementSerializer.descriptor)
      optionalElement("occurrencePeriod", PeriodSerializer.descriptor)
      optionalElement("occurrenceTiming", TimingSerializer.descriptor)
      optionalElement("requester", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("requesterLinkId", stringNullableListSerializer.descriptor)
      optionalElement("_requesterLinkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("performerType", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("performerRole", CodeableConceptSerializer.descriptor)
      optionalElement("performer", ReferenceSerializer.descriptor)
      optionalElement("performerLinkId", stringNullableListSerializer.descriptor)
      optionalElement("_performerLinkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("reason", CodeableReferenceSerializer.listSerializer.descriptor)
      optionalElement("reasonLinkId", stringNullableListSerializer.descriptor)
      optionalElement("_reasonLinkId", ElementSerializer.nullableListSerializer.descriptor)
      optionalElement("note", AnnotationSerializer.listSerializer.descriptor)
      optionalElement("securityLabelNumber", intNullableListSerializer.descriptor)
      optionalElement("_securityLabelNumber", ElementSerializer.nullableListSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Action>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Action =
    decoder.decodeStructure(descriptor) {
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
          3 -> doNotPerform = decodeBooleanElement(descriptor, i)
          4 ->
            _doNotPerform =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            subject =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContractTermActionSubjectSerializer.listSerializer,
                null,
              )
          7 ->
            intent =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            linkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          9 ->
            _linkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          10 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          11 ->
            context = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 ->
            contextLinkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          13 ->
            _contextLinkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          14 -> occurrenceDateTime = decodeStringElement(descriptor, i)
          15 ->
            _occurrenceDateTime =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          16 ->
            occurrencePeriod =
              decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          17 ->
            occurrenceTiming =
              decodeNullableSerializableElement(descriptor, i, TimingSerializer, null)
          18 ->
            requester =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          19 ->
            requesterLinkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          20 ->
            _requesterLinkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          21 ->
            performerType =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          22 ->
            performerRole =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          23 ->
            performer = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          24 ->
            performerLinkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          25 ->
            _performerLinkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          26 ->
            reason =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableReferenceSerializer.listSerializer,
                null,
              )
          27 ->
            reasonLinkId =
              decodeNullableSerializableElement(descriptor, i, stringNullableListSerializer, null)
          28 ->
            _reasonLinkId =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          29 ->
            note =
              decodeNullableSerializableElement(
                descriptor,
                i,
                AnnotationSerializer.listSerializer,
                null,
              )
          30 ->
            securityLabelNumber =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          31 ->
            _securityLabelNumber =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Action: " + i)
        }
      }
      Contract.Term.Action(
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
            R5String.of(linkId?.getOrNull(index), _linkId?.getOrNull(index))
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
          (kotlin.collections.List(maxOf(contextLinkId?.size ?: 0, _contextLinkId?.size ?: 0)) {
            index ->
            R5String.of(contextLinkId?.getOrNull(index), _contextLinkId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'contextLinkId' on Contract.Term.Action has neither a value nor an id/extension"
              )
          }),
        occurrence =
          Contract.Term.Action.Occurrence.from(
            DateTime.of(
              if (occurrenceDateTime != null) FhirDateTime.fromString(occurrenceDateTime) else null,
              _occurrenceDateTime,
            ),
            occurrencePeriod,
            occurrenceTiming,
          ),
        requester = requester ?: listOf(),
        requesterLinkId =
          (kotlin.collections.List(
            maxOf(requesterLinkId?.size ?: 0, _requesterLinkId?.size ?: 0)
          ) { index ->
            R5String.of(requesterLinkId?.getOrNull(index), _requesterLinkId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'requesterLinkId' on Contract.Term.Action has neither a value nor an id/extension"
              )
          }),
        performerType = performerType ?: listOf(),
        performerRole = performerRole,
        performer = performer,
        performerLinkId =
          (kotlin.collections.List(
            maxOf(performerLinkId?.size ?: 0, _performerLinkId?.size ?: 0)
          ) { index ->
            R5String.of(performerLinkId?.getOrNull(index), _performerLinkId?.getOrNull(index))
              ?: throw SerializationException(
                "An entry of 'performerLinkId' on Contract.Term.Action has neither a value nor an id/extension"
              )
          }),
        reason = reason ?: listOf(),
        reasonLinkId =
          (kotlin.collections.List(maxOf(reasonLinkId?.size ?: 0, _reasonLinkId?.size ?: 0)) { index
            ->
            R5String.of(reasonLinkId?.getOrNull(index), _reasonLinkId?.getOrNull(index))
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
              securityLabelNumber?.getOrNull(index),
              _securityLabelNumber?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'securityLabelNumber' on Contract.Term.Action has neither a value nor an id/extension"
              )
          }),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.doNotPerform?.value)
      encodeElementIfNotNull(descriptor, 4, value.doNotPerform)
      encodeSerializableElement(descriptor, 5, CodeableConceptSerializer, value.type)
      if (value.subject.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          ContractTermActionSubjectSerializer.listSerializer,
          value.subject,
        )
      encodeSerializableElement(descriptor, 7, CodeableConceptSerializer, value.intent)
      if (value.linkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          8,
          stringNullableListSerializer,
          value.linkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 9, value.linkId)
      }
      encodeSerializableElement(descriptor, 10, CodeableConceptSerializer, value.status)
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.context)
      if (value.contextLinkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          12,
          stringNullableListSerializer,
          value.contextLinkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 13, value.contextLinkId)
      }
      when (val choice = value.occurrence) {
        null -> {}
        is Contract.Term.Action.Occurrence.DateTime -> {
          encodeStringIfNotNull(descriptor, 14, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 15, choice.value)
        }
        is Contract.Term.Action.Occurrence.Period -> {
          encodeSerializableElement(descriptor, 16, PeriodSerializer, choice.value)
        }
        is Contract.Term.Action.Occurrence.Timing -> {
          encodeSerializableElement(descriptor, 17, TimingSerializer, choice.value)
        }
      }
      if (value.requester.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          18,
          ReferenceSerializer.listSerializer,
          value.requester,
        )
      if (value.requesterLinkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          19,
          stringNullableListSerializer,
          value.requesterLinkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 20, value.requesterLinkId)
      }
      if (value.performerType.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          21,
          CodeableConceptSerializer.listSerializer,
          value.performerType,
        )
      encodeSerializableIfNotNull(descriptor, 22, CodeableConceptSerializer, value.performerRole)
      encodeSerializableIfNotNull(descriptor, 23, ReferenceSerializer, value.performer)
      if (value.performerLinkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          24,
          stringNullableListSerializer,
          value.performerLinkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 25, value.performerLinkId)
      }
      if (value.reason.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          26,
          CodeableReferenceSerializer.listSerializer,
          value.reason,
        )
      if (value.reasonLinkId.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          27,
          stringNullableListSerializer,
          value.reasonLinkId.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 28, value.reasonLinkId)
      }
      if (value.note.isNotEmpty())
        encodeSerializableElement(descriptor, 29, AnnotationSerializer.listSerializer, value.note)
      if (value.securityLabelNumber.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          30,
          intNullableListSerializer,
          value.securityLabelNumber.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 31, value.securityLabelNumber)
      }
    }
  }
}

internal object ContractTermActionSubjectSerializer : KSerializer<Contract.Term.Action.Subject> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Subject") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("reference", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("role", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Term.Action.Subject>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Term.Action.Subject =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var reference: List<Reference>? = null
      var role: CodeableConcept? = null
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
          3 ->
            reference =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          4 ->
            role = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Subject: " + i)
        }
      }
      Contract.Term.Action.Subject(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        reference = reference ?: listOf(),
        role = role,
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action.Subject) {
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
      if (value.reference.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ReferenceSerializer.listSerializer,
          value.reference,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.role)
    }
  }
}

internal object ContractSignerSerializer : KSerializer<Contract.Signer> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Signer") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodingSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
      optionalElement("signature", SignatureSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Signer>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Signer =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: Coding? = null
      var party: Reference? = null
      var signature: List<Signature>? = null
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
          3 -> type = decodeNullableSerializableElement(descriptor, i, CodingSerializer, null)
          4 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          5 ->
            signature =
              decodeNullableSerializableElement(
                descriptor,
                i,
                SignatureSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Signer: " + i)
        }
      }
      Contract.Signer(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException("Missing required property 'type' on Contract.Signer"),
        party =
          party
            ?: throw SerializationException("Missing required property 'party' on Contract.Signer"),
        signature = signature ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Signer) {
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
      encodeSerializableElement(descriptor, 3, CodingSerializer, value.type)
      encodeSerializableElement(descriptor, 4, ReferenceSerializer, value.party)
      if (value.signature.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          SignatureSerializer.listSerializer,
          value.signature,
        )
    }
  }
}

internal object ContractFriendlySerializer : KSerializer<Contract.Friendly> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Friendly") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentAttachment", AttachmentSerializer.descriptor)
      optionalElement("contentReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Friendly>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Friendly =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var contentAttachment: Attachment? = null
      var contentReference: Reference? = null
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
          3 ->
            contentAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          4 ->
            contentReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Friendly: " + i)
        }
      }
      Contract.Friendly(
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

  override fun serialize(encoder: Encoder, `value`: Contract.Friendly) {
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
      when (val choice = value.content) {
        is Contract.Friendly.Content.Attachment -> {
          encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
        }
        is Contract.Friendly.Content.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ContractLegalSerializer : KSerializer<Contract.Legal> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Legal") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentAttachment", AttachmentSerializer.descriptor)
      optionalElement("contentReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Legal>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Legal =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var contentAttachment: Attachment? = null
      var contentReference: Reference? = null
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
          3 ->
            contentAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          4 ->
            contentReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Legal: " + i)
        }
      }
      Contract.Legal(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        content =
          Contract.Legal.Content.from(contentAttachment, contentReference)
            ?: throw SerializationException(
              "Missing required property 'content' on Contract.Legal"
            ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Legal) {
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
      when (val choice = value.content) {
        is Contract.Legal.Content.Attachment -> {
          encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
        }
        is Contract.Legal.Content.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ContractRuleSerializer : KSerializer<Contract.Rule> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Rule") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("contentAttachment", AttachmentSerializer.descriptor)
      optionalElement("contentReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Contract.Rule>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Contract.Rule =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var contentAttachment: Attachment? = null
      var contentReference: Reference? = null
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
          3 ->
            contentAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          4 ->
            contentReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Rule: " + i)
        }
      }
      Contract.Rule(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        content =
          Contract.Rule.Content.from(contentAttachment, contentReference)
            ?: throw SerializationException("Missing required property 'content' on Contract.Rule"),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Contract.Rule) {
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
      when (val choice = value.content) {
        is Contract.Rule.Content.Attachment -> {
          encodeSerializableElement(descriptor, 3, AttachmentSerializer, choice.value)
        }
        is Contract.Rule.Content.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object ContractSerializer : FhirResourceSerializer<Contract> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Contract")

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
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("url", KotlinString.serializer().descriptor)
    b.optionalElement("_url", ElementSerializer.descriptor)
    b.optionalElement("version", KotlinString.serializer().descriptor)
    b.optionalElement("_version", ElementSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("legalState", CodeableConceptSerializer.descriptor)
    b.optionalElement("instantiatesCanonical", ReferenceSerializer.descriptor)
    b.optionalElement("instantiatesUri", KotlinString.serializer().descriptor)
    b.optionalElement("_instantiatesUri", ElementSerializer.descriptor)
    b.optionalElement("contentDerivative", CodeableConceptSerializer.descriptor)
    b.optionalElement("issued", KotlinString.serializer().descriptor)
    b.optionalElement("_issued", ElementSerializer.descriptor)
    b.optionalElement("applies", PeriodSerializer.descriptor)
    b.optionalElement("expirationType", CodeableConceptSerializer.descriptor)
    b.optionalElement("subject", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("authority", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("domain", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("site", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("subtitle", KotlinString.serializer().descriptor)
    b.optionalElement("_subtitle", ElementSerializer.descriptor)
    b.optionalElement("alias", stringNullableListSerializer.descriptor)
    b.optionalElement("_alias", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("author", ReferenceSerializer.descriptor)
    b.optionalElement("scope", CodeableConceptSerializer.descriptor)
    b.optionalElement("topicCodeableConcept", CodeableConceptSerializer.descriptor)
    b.optionalElement("topicReference", ReferenceSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("subType", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("contentDefinition", ContractContentDefinitionSerializer.descriptor)
    b.optionalElement("term", ContractTermSerializer.listSerializer.descriptor)
    b.optionalElement("supportingInfo", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("relevantHistory", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("signer", ContractSignerSerializer.listSerializer.descriptor)
    b.optionalElement("friendly", ContractFriendlySerializer.listSerializer.descriptor)
    b.optionalElement("legal", ContractLegalSerializer.listSerializer.descriptor)
    b.optionalElement("rule", ContractRuleSerializer.listSerializer.descriptor)
    b.optionalElement("legallyBindingAttachment", AttachmentSerializer.descriptor)
    b.optionalElement("legallyBindingReference", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        Enumeration.of(
          if (status != null) Contract.ContractResourceStatusCodes.fromCode(status) else null,
          _status,
        ),
      legalState = legalState,
      instantiatesCanonical = instantiatesCanonical,
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      contentDerivative = contentDerivative,
      issued = DateTime.of(if (issued != null) FhirDateTime.fromString(issued) else null, _issued),
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
          R5String.of(alias?.getOrNull(index), _alias?.getOrNull(index))
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Contract,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.identifier,
      )
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.url?.value)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.url)
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.version?.value)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.version)
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.status)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      CodeableConceptSerializer,
      value.legalState,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.instantiatesCanonical,
    )
    encoder.encodeStringIfNotNull(descriptor, 19 + descriptorOffset, value.instantiatesUri?.value)
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.instantiatesUri)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer,
      value.contentDerivative,
    )
    encoder.encodeStringIfNotNull(
      descriptor,
      22 + descriptorOffset,
      value.issued?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 23 + descriptorOffset, value.issued)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      PeriodSerializer,
      value.applies,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      CodeableConceptSerializer,
      value.expirationType,
    )
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
    encoder.encodeStringIfNotNull(descriptor, 30 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.name)
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.title)
    encoder.encodeStringIfNotNull(descriptor, 34 + descriptorOffset, value.subtitle?.value)
    encoder.encodeElementIfNotNull(descriptor, 35 + descriptorOffset, value.subtitle)
    if (value.alias.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        36 + descriptorOffset,
        stringNullableListSerializer,
        value.alias.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 37 + descriptorOffset, value.alias)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      38 + descriptorOffset,
      ReferenceSerializer,
      value.author,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      39 + descriptorOffset,
      CodeableConceptSerializer,
      value.scope,
    )
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    if (value.subType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.subType,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      44 + descriptorOffset,
      ContractContentDefinitionSerializer,
      value.contentDefinition,
    )
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
