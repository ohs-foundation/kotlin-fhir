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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          subType = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.publisherSer, null)
        6 -> publicationDate = decoder.decodeStringElement(descriptor, i)
        7 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.publicationDateSer,
              null,
            )
        8 -> publicationStatus = decoder.decodeStringElement(descriptor, i)
        9 ->
          _publicationStatus =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.publicationDateSer,
              null,
            )
        10 -> copyright = decoder.decodeStringElement(descriptor, i)
        11 ->
          _copyright =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.publicationDateSer,
              null,
            )
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    (value.subType)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    (value.publisher)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.publisherSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.publicationDateSer, it)
    }
    ((value.publicationStatus.value?.code))?.let { encoder.encodeStringElement(descriptor, 8, it) }
    (value.publicationStatus.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.publicationDateSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.publicationDateSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val publisherSer: KSerializer<Reference> = Reference.serializer()

    public val publicationDateSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> issued = decoder.decodeStringElement(descriptor, i)
        5 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.issuedSer, null)
        6 ->
          applies =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.appliesSer, null)
        7 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        8 ->
          topicReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.topicReferenceSer,
              null,
            )
        9 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        10 ->
          subType =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        11 -> text = decoder.decodeStringElement(descriptor, i)
        12 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.issuedSer, null)
        13 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.securityLabelSer, null)
        14 ->
          offer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.offerSer, null)
        15 ->
          asset = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.assetSer, null)
        16 ->
          action = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.actionSer, null)
        17 ->
          group = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.groupSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, it)
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.issuedSer, it)
    }
    (value.applies)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.appliesSer, it)
    }
    when (val choice = value.topic) {
      null -> {}
      is Contract.Term.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          7,
          Hoisted.topicCodeableConceptSer,
          choice.value,
        )
      }
      is Contract.Term.Topic.Reference -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.topicReferenceSer, choice.value)
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.topicCodeableConceptSer, it)
    }
    (value.subType)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.topicCodeableConceptSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.issuedSer, it)
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13,
        Hoisted.securityLabelSer,
        value.securityLabel,
      )
    encoder.encodeSerializableElement(descriptor, 14, Hoisted.offerSer, value.offer)
    if (value.asset.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.assetSer, value.asset)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.actionSer, value.action)
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.groupSer, value.group)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val issuedSer: KSerializer<Element> = Element.serializer()

    public val appliesSer: KSerializer<Period> = Period.serializer()

    public val topicCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val topicReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val securityLabelSerInner: KSerializer<Contract.Term.SecurityLabel> =
      Contract.Term.SecurityLabel.serializer()

    public val securityLabelSer: KSerializer<List<Contract.Term.SecurityLabel>> =
      ListSerializer(Hoisted.securityLabelSerInner)

    public val offerSer: KSerializer<Contract.Term.Offer> = Contract.Term.Offer.serializer()

    public val assetSerInner: KSerializer<Contract.Term.Asset> = Contract.Term.Asset.serializer()

    public val assetSer: KSerializer<List<Contract.Term.Asset>> =
      ListSerializer(Hoisted.assetSerInner)

    public val actionSerInner: KSerializer<Contract.Term.Action> = Contract.Term.Action.serializer()

    public val actionSer: KSerializer<List<Contract.Term.Action>> =
      ListSerializer(Hoisted.actionSerInner)

    public val groupSerInner: KSerializer<Contract.Term> = Contract.Term.serializer()

    public val groupSer: KSerializer<List<Contract.Term>> = ListSerializer(Hoisted.groupSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          number = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer, null)
        4 ->
          _number =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.numberSer2, null)
        5 ->
          classification =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.classificationSer,
              null,
            )
        6 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        7 ->
          control =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
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
          UnsignedInt.of(number?.getOrNull(index)?.let { it }, _number?.getOrNull(index))!!
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.number.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.numberSer, it)
    }
    (value.number.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.numberSer2, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      5,
      Hoisted.classificationSer,
      value.classification,
    )
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.categorySer, value.category)
    if (value.control.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.categorySer, value.control)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val numberSerInner: KSerializer<Int> = Int.serializer()

    public val numberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.numberSerInner).nullable)

    public val numberSerInner2: KSerializer<Element> = Element.serializer()

    public val numberSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.numberSerInner2).nullable)

    public val classificationSer: KSerializer<Coding> = Coding.serializer()

    public val categorySer: KSerializer<List<Coding>> = ListSerializer(Hoisted.classificationSer)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        5 ->
          topic = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.topicSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          decision = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 ->
          decisionMode =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.decisionModeSer, null)
        9 ->
          answer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.answerSer, null)
        10 -> text = decoder.decodeStringElement(descriptor, i)
        11 ->
          _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
        12 ->
          linkId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        13 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        14 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        15 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
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
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))!!
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Offer) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    if (value.party.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.partySer, value.party)
    (value.topic)?.let { encoder.encodeSerializableElement(descriptor, 5, Hoisted.topicSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, it) }
    (value.decision)?.let { encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, it) }
    if (value.decisionMode.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.decisionModeSer, value.decisionMode)
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.answerSer, value.answer)
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 10, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.textSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.linkIdSer2, it)
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.linkIdSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val partySerInner: KSerializer<Contract.Term.Offer.Party> =
      Contract.Term.Offer.Party.serializer()

    public val partySer: KSerializer<List<Contract.Term.Offer.Party>> =
      ListSerializer(Hoisted.partySerInner)

    public val topicSer: KSerializer<Reference> = Reference.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val decisionModeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val answerSerInner: KSerializer<Contract.Term.Offer.Answer> =
      Contract.Term.Offer.Answer.serializer()

    public val answerSer: KSerializer<List<Contract.Term.Offer.Answer>> =
      ListSerializer(Hoisted.answerSerInner)

    public val textSer: KSerializer<Element> = Element.serializer()

    public val linkIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val linkIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.linkIdSerInner).nullable)

    public val linkIdSer2: KSerializer<List<Element?>> = ListSerializer((Hoisted.textSer).nullable)

    public val securityLabelNumberSerInner: KSerializer<Int> = Int.serializer()

    public val securityLabelNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.securityLabelNumberSerInner).nullable)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, value.reference)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.roleSer, value.role)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val referenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.referenceSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.`value`) {
      is Contract.Term.Offer.Answer.Value.Boolean -> {
        ((choice.value.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Decimal -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 5, FhirDecimalSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Integer -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 7, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Date -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Time -> {
        ((choice.value.value))?.let {
          encoder.encodeSerializableElement(descriptor, 13, LocalTimeSerializer, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 16, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Uri -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 17, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 18, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 19, Hoisted.valueAttachmentSer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Coding -> {
        encoder.encodeSerializableElement(descriptor, 20, Hoisted.valueCodingSer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 21, Hoisted.valueQuantitySer, choice.value)
      }
      is Contract.Term.Offer.Answer.Value.Reference -> {
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          scope = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.scopeSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          typeReference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeReferenceSer, null)
        6 ->
          subtype = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        7 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.relationshipSer, null)
        8 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        9 -> condition = decoder.decodeStringElement(descriptor, i)
        10 ->
          _condition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        11 ->
          periodType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        12 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        13 ->
          usePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        14 -> text = decoder.decodeStringElement(descriptor, i)
        15 ->
          _text =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.conditionSer, null)
        16 ->
          linkId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        17 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        18 ->
          answer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.answerSer, null)
        19 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        20 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        21 ->
          valuedItem =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valuedItemSer, null)
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
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))!!
        }),
      answer = answer ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )!!
        }),
      valuedItem = valuedItem ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Asset) {
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
    (value.scope)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.scopeSer, it) }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, value.type)
    if (value.typeReference.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        5,
        Hoisted.typeReferenceSer,
        value.typeReference,
      )
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.typeSer, value.subtype)
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.relationshipSer, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.contextSer, value.context)
    ((value.condition?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.conditionSer, it)
    }
    if (value.periodType.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.typeSer, value.periodType)
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.periodSer, value.period)
    if (value.usePeriod.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.periodSer, value.usePeriod)
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 14, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 15, Hoisted.conditionSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17, Hoisted.linkIdSer2, it)
    }
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.answerSer, value.answer)
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.linkIdSer2, it)
    }
    if (value.valuedItem.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.valuedItemSer, value.valuedItem)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val scopeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.scopeSer)

    public val typeReferenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val typeReferenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.typeReferenceSerInner)

    public val relationshipSer: KSerializer<Coding> = Coding.serializer()

    public val contextSerInner: KSerializer<Contract.Term.Asset.Context> =
      Contract.Term.Asset.Context.serializer()

    public val contextSer: KSerializer<List<Contract.Term.Asset.Context>> =
      ListSerializer(Hoisted.contextSerInner)

    public val conditionSer: KSerializer<Element> = Element.serializer()

    public val periodSerInner: KSerializer<Period> = Period.serializer()

    public val periodSer: KSerializer<List<Period>> = ListSerializer(Hoisted.periodSerInner)

    public val linkIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val linkIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.linkIdSerInner).nullable)

    public val linkIdSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.conditionSer).nullable)

    public val answerSerInner: KSerializer<Contract.Term.Offer.Answer> =
      Contract.Term.Offer.Answer.serializer()

    public val answerSer: KSerializer<List<Contract.Term.Offer.Answer>> =
      ListSerializer(Hoisted.answerSerInner)

    public val securityLabelNumberSerInner: KSerializer<Int> = Int.serializer()

    public val securityLabelNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.securityLabelNumberSerInner).nullable)

    public val valuedItemSerInner: KSerializer<Contract.Term.Asset.ValuedItem> =
      Contract.Term.Asset.ValuedItem.serializer()

    public val valuedItemSer: KSerializer<List<Contract.Term.Asset.ValuedItem>> =
      ListSerializer(Hoisted.valuedItemSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        5 -> text = decoder.decodeStringElement(descriptor, i)
        6 -> _text = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.textSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    (value.reference)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, value.code)
    ((value.text?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.textSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSer: KSerializer<Reference> = Reference.serializer()

    public val codeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val codeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.codeSerInner)

    public val textSer: KSerializer<Element> = Element.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          entityCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.entityCodeableConceptSer,
              null,
            )
        4 ->
          entityReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.entityReferenceSer,
              null,
            )
        5 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        6 -> effectiveTime = decoder.decodeStringElement(descriptor, i)
        7 ->
          _effectiveTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectiveTimeSer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        9 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        10 ->
          factor =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        11 ->
          _factor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectiveTimeSer, null)
        12 ->
          points =
            decoder.decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
        13 ->
          _points =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectiveTimeSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        15 -> payment = decoder.decodeStringElement(descriptor, i)
        16 ->
          _payment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectiveTimeSer, null)
        17 -> paymentDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.effectiveTimeSer, null)
        19 ->
          responsible =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.entityReferenceSer,
              null,
            )
        20 ->
          recipient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.entityReferenceSer,
              null,
            )
        21 ->
          linkId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        22 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        23 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        24 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
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
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))!!
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )!!
        }),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Contract.Term.Asset.ValuedItem,
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
    when (val choice = value.entity) {
      null -> {}
      is Contract.Term.Asset.ValuedItem.Entity.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.entityCodeableConceptSer,
          choice.value,
        )
      }
      is Contract.Term.Asset.ValuedItem.Entity.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.entityReferenceSer, choice.value)
      }
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.identifierSer, it)
    }
    ((value.effectiveTime?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 6, it)
    }
    (value.effectiveTime?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.effectiveTimeSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 10, FhirDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.effectiveTimeSer, it)
    }
    ((value.points?.value))?.let {
      encoder.encodeSerializableElement(descriptor, 12, FhirDecimalSerializer, it)
    }
    (value.points?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.effectiveTimeSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(descriptor, 14, Hoisted.unitPriceSer, it) }
    ((value.payment?.value))?.let { encoder.encodeStringElement(descriptor, 15, it) }
    (value.payment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.effectiveTimeSer, it)
    }
    ((value.paymentDate?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 17, it)
    }
    (value.paymentDate?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.effectiveTimeSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.entityReferenceSer, it)
    }
    (value.recipient)?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.entityReferenceSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.linkIdSer2, it)
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.linkIdSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val entityCodeableConceptSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val entityReferenceSer: KSerializer<Reference> = Reference.serializer()

    public val identifierSer: KSerializer<Identifier> = Identifier.serializer()

    public val effectiveTimeSer: KSerializer<Element> = Element.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val linkIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val linkIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.linkIdSerInner).nullable)

    public val linkIdSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.effectiveTimeSer).nullable)

    public val securityLabelNumberSerInner: KSerializer<Int> = Int.serializer()

    public val securityLabelNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.securityLabelNumberSerInner).nullable)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> doNotPerform = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doNotPerformSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        6 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        7 ->
          intent = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        8 ->
          linkId = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        9 ->
          _linkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        10 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        11 ->
          context =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        12 ->
          contextLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        13 ->
          _contextLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        14 -> occurrenceDateTime = decoder.decodeStringElement(descriptor, i)
        15 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.doNotPerformSer, null)
        16 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        17 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        18 ->
          requester =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requesterSer, null)
        19 ->
          requesterLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        20 ->
          _requesterLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        21 ->
          performerType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.performerTypeSer, null)
        22 ->
          performerRole =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contextSer, null)
        24 ->
          performerLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        25 ->
          _performerLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        26 ->
          reason = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.reasonSer, null)
        27 ->
          reasonLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer, null)
        28 ->
          _reasonLinkId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
        29 -> note = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.noteSer, null)
        30 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        31 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.linkIdSer2, null)
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
          R5String.of(linkId?.getOrNull(index)?.let { it }, _linkId?.getOrNull(index))!!
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
          R5String.of(
            contextLinkId?.getOrNull(index)?.let { it },
            _contextLinkId?.getOrNull(index),
          )!!
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
          )!!
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
          )!!
        }),
      reason = reason ?: listOf(),
      reasonLinkId =
        (kotlin.collections.List(maxOf(reasonLinkId?.size ?: 0, _reasonLinkId?.size ?: 0)) { index
          ->
          R5String.of(reasonLinkId?.getOrNull(index)?.let { it }, _reasonLinkId?.getOrNull(index))!!
        }),
      note = note ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { index ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(index)?.let { it },
            _securityLabelNumber?.getOrNull(index),
          )!!
        }),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Contract.Term.Action) {
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
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.doNotPerformSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.typeSer, value.type)
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.subjectSer, value.subject)
    encoder.encodeSerializableElement(descriptor, 7, Hoisted.typeSer, value.intent)
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.linkIdSer2, it)
    }
    encoder.encodeSerializableElement(descriptor, 10, Hoisted.typeSer, value.status)
    (value.context)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.contextSer, it)
    }
    (value.contextLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.linkIdSer, it)
    }
    (value.contextLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.linkIdSer2, it)
    }
    when (val choice = value.occurrence) {
      null -> {}
      is Contract.Term.Action.Occurrence.DateTime -> {
        ((choice.value.value?.toString()))?.let { encoder.encodeStringElement(descriptor, 14, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 15, Hoisted.doNotPerformSer, it)
        }
      }
      is Contract.Term.Action.Occurrence.Period -> {
        encoder.encodeSerializableElement(descriptor, 16, Hoisted.occurrencePeriodSer, choice.value)
      }
      is Contract.Term.Action.Occurrence.Timing -> {
        encoder.encodeSerializableElement(descriptor, 17, Hoisted.occurrenceTimingSer, choice.value)
      }
    }
    if (value.requester.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.requesterSer, value.requester)
    (value.requesterLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 19, Hoisted.linkIdSer, it)
    }
    (value.requesterLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 20, Hoisted.linkIdSer2, it)
    }
    if (value.performerType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21,
        Hoisted.performerTypeSer,
        value.performerType,
      )
    (value.performerRole)?.let {
      encoder.encodeSerializableElement(descriptor, 22, Hoisted.typeSer, it)
    }
    (value.performer)?.let {
      encoder.encodeSerializableElement(descriptor, 23, Hoisted.contextSer, it)
    }
    (value.performerLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 24, Hoisted.linkIdSer, it)
    }
    (value.performerLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 25, Hoisted.linkIdSer2, it)
    }
    if (value.reason.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 26, Hoisted.reasonSer, value.reason)
    (value.reasonLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 27, Hoisted.linkIdSer, it)
    }
    (value.reasonLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 28, Hoisted.linkIdSer2, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 29, Hoisted.noteSer, value.note)
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 30, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 31, Hoisted.linkIdSer2, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val doNotPerformSer: KSerializer<Element> = Element.serializer()

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val subjectSerInner: KSerializer<Contract.Term.Action.Subject> =
      Contract.Term.Action.Subject.serializer()

    public val subjectSer: KSerializer<List<Contract.Term.Action.Subject>> =
      ListSerializer(Hoisted.subjectSerInner)

    public val linkIdSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val linkIdSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.linkIdSerInner).nullable)

    public val linkIdSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.doNotPerformSer).nullable)

    public val contextSer: KSerializer<Reference> = Reference.serializer()

    public val occurrencePeriodSer: KSerializer<Period> = Period.serializer()

    public val occurrenceTimingSer: KSerializer<Timing> = Timing.serializer()

    public val requesterSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.contextSer)

    public val performerTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.typeSer)

    public val reasonSerInner: KSerializer<CodeableReference> = CodeableReference.serializer()

    public val reasonSer: KSerializer<List<CodeableReference>> =
      ListSerializer(Hoisted.reasonSerInner)

    public val noteSerInner: KSerializer<Annotation> = Annotation.serializer()

    public val noteSer: KSerializer<List<Annotation>> = ListSerializer(Hoisted.noteSerInner)

    public val securityLabelNumberSerInner: KSerializer<Int> = Int.serializer()

    public val securityLabelNumberSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.securityLabelNumberSerInner).nullable)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.referenceSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.roleSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.referenceSer, value.reference)
    (value.role)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.roleSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val referenceSerInner: KSerializer<Reference> = Reference.serializer()

    public val referenceSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.referenceSerInner)

    public val roleSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 ->
          party = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.partySer, null)
        5 ->
          signature =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.signatureSer, null)
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.partySer, value.party)
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.signatureSer, value.signature)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Coding> = Coding.serializer()

    public val partySer: KSerializer<Reference> = Reference.serializer()

    public val signatureSerInner: KSerializer<Signature> = Signature.serializer()

    public val signatureSer: KSerializer<List<Signature>> =
      ListSerializer(Hoisted.signatureSerInner)
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentReferenceSer,
              null,
            )
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.content) {
      is Contract.Friendly.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.contentAttachmentSer, choice.value)
      }
      is Contract.Friendly.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.contentReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val contentReferenceSer: KSerializer<Reference> = Reference.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentReferenceSer,
              null,
            )
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.content) {
      is Contract.Legal.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.contentAttachmentSer, choice.value)
      }
      is Contract.Legal.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.contentReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val contentReferenceSer: KSerializer<Reference> = Reference.serializer()
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
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentReferenceSer,
              null,
            )
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
      encoder.encodeSerializableElement(descriptor, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        2,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    when (val choice = value.content) {
      is Contract.Rule.Content.Attachment -> {
        encoder.encodeSerializableElement(descriptor, 3, Hoisted.contentAttachmentSer, choice.value)
      }
      is Contract.Rule.Content.Reference -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.contentReferenceSer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val contentAttachmentSer: KSerializer<Attachment> = Attachment.serializer()

    public val contentReferenceSer: KSerializer<Reference> = Reference.serializer()
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
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        11 -> url = decoder.decodeStringElement(descriptor, i)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 -> version = decoder.decodeStringElement(descriptor, i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        15 -> status = decoder.decodeStringElement(descriptor, i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        17 ->
          legalState =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        18 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        19 -> instantiatesUri = decoder.decodeStringElement(descriptor, i)
        20 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          contentDerivative =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        22 -> issued = decoder.decodeStringElement(descriptor, i)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        24 ->
          applies =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.appliesSer, null)
        25 ->
          expirationType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        26 ->
          subject =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        27 ->
          authority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        28 ->
          domain =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        29 ->
          site = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        30 -> name = decoder.decodeStringElement(descriptor, i)
        31 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 -> title = decoder.decodeStringElement(descriptor, i)
        33 ->
          _title =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        34 -> subtitle = decoder.decodeStringElement(descriptor, i)
        35 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        36 ->
          alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer, null)
        37 ->
          _alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer2, null)
        38 ->
          author =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        39 ->
          scope =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        40 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        41 ->
          topicReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        42 ->
          type =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalStateSer, null)
        43 ->
          subType =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subTypeSer, null)
        44 ->
          contentDefinition =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.contentDefinitionSer,
              null,
            )
        45 -> term = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.termSer, null)
        46 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        47 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.subjectSer, null)
        48 ->
          signer = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.signerSer, null)
        49 ->
          friendly =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.friendlySer, null)
        50 ->
          legal = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.legalSer, null)
        51 -> rule = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ruleSer, null)
        52 ->
          legallyBindingAttachment =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.legallyBindingAttachmentSer,
              null,
            )
        53 ->
          legallyBindingReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
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
          R5String.of(alias?.getOrNull(index)?.let { it }, _alias?.getOrNull(index))!!
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        10 + descriptorOffset,
        Hoisted.identifierSer,
        value.identifier,
      )
    ((value.url?.value))?.let { encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
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
    ((value.status?.value?.code))?.let {
      encoder.encodeStringElement(descriptor, 15 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.legalState)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.legalStateSer,
        it,
      )
    }
    (value.instantiatesCanonical)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        18 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    ((value.instantiatesUri?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.contentDerivative)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.legalStateSer,
        it,
      )
    }
    ((value.issued?.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 22 + descriptorOffset, it)
    }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.applies)?.let {
      encoder.encodeSerializableElement(descriptor, 24 + descriptorOffset, Hoisted.appliesSer, it)
    }
    (value.expirationType)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.legalStateSer,
        it,
      )
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.subjectSer,
        value.subject,
      )
    if (value.authority.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.subjectSer,
        value.authority,
      )
    if (value.domain.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.subjectSer,
        value.domain,
      )
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.subjectSer,
        value.site,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.title?.value))?.let {
      encoder.encodeStringElement(descriptor, 32 + descriptorOffset, it)
    }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        33 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.subtitle?.value))?.let {
      encoder.encodeStringElement(descriptor, 34 + descriptorOffset, it)
    }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 36 + descriptorOffset, Hoisted.aliasSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 37 + descriptorOffset, Hoisted.aliasSer2, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        38 + descriptorOffset,
        Hoisted.instantiatesCanonicalSer,
        it,
      )
    }
    (value.scope)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        39 + descriptorOffset,
        Hoisted.legalStateSer,
        it,
      )
    }
    when (val choice = value.topic) {
      null -> {}
      is Contract.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          40 + descriptorOffset,
          Hoisted.legalStateSer,
          choice.value,
        )
      }
      is Contract.Topic.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          41 + descriptorOffset,
          Hoisted.instantiatesCanonicalSer,
          choice.value,
        )
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        42 + descriptorOffset,
        Hoisted.legalStateSer,
        it,
      )
    }
    if (value.subType.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        43 + descriptorOffset,
        Hoisted.subTypeSer,
        value.subType,
      )
    (value.contentDefinition)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        Hoisted.contentDefinitionSer,
        it,
      )
    }
    if (value.term.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        Hoisted.termSer,
        value.term,
      )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        Hoisted.subjectSer,
        value.supportingInfo,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        47 + descriptorOffset,
        Hoisted.subjectSer,
        value.relevantHistory,
      )
    if (value.signer.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        48 + descriptorOffset,
        Hoisted.signerSer,
        value.signer,
      )
    if (value.friendly.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        49 + descriptorOffset,
        Hoisted.friendlySer,
        value.friendly,
      )
    if (value.legal.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        50 + descriptorOffset,
        Hoisted.legalSer,
        value.legal,
      )
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        51 + descriptorOffset,
        Hoisted.ruleSer,
        value.rule,
      )
    when (val choice = value.legallyBinding) {
      null -> {}
      is Contract.LegallyBinding.Attachment -> {
        encoder.encodeSerializableElement(
          descriptor,
          52 + descriptorOffset,
          Hoisted.legallyBindingAttachmentSer,
          choice.value,
        )
      }
      is Contract.LegallyBinding.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          53 + descriptorOffset,
          Hoisted.instantiatesCanonicalSer,
          choice.value,
        )
      }
    }
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

    public val legalStateSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val instantiatesCanonicalSer: KSerializer<Reference> = Reference.serializer()

    public val appliesSer: KSerializer<Period> = Period.serializer()

    public val subjectSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.instantiatesCanonicalSer)

    public val aliasSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val aliasSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.aliasSerInner).nullable)

    public val aliasSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val subTypeSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.legalStateSer)

    public val contentDefinitionSer: KSerializer<Contract.ContentDefinition> =
      Contract.ContentDefinition.serializer()

    public val termSerInner: KSerializer<Contract.Term> = Contract.Term.serializer()

    public val termSer: KSerializer<List<Contract.Term>> = ListSerializer(Hoisted.termSerInner)

    public val signerSerInner: KSerializer<Contract.Signer> = Contract.Signer.serializer()

    public val signerSer: KSerializer<List<Contract.Signer>> =
      ListSerializer(Hoisted.signerSerInner)

    public val friendlySerInner: KSerializer<Contract.Friendly> = Contract.Friendly.serializer()

    public val friendlySer: KSerializer<List<Contract.Friendly>> =
      ListSerializer(Hoisted.friendlySerInner)

    public val legalSerInner: KSerializer<Contract.Legal> = Contract.Legal.serializer()

    public val legalSer: KSerializer<List<Contract.Legal>> = ListSerializer(Hoisted.legalSerInner)

    public val ruleSerInner: KSerializer<Contract.Rule> = Contract.Rule.serializer()

    public val ruleSer: KSerializer<List<Contract.Rule>> = ListSerializer(Hoisted.ruleSerInner)

    public val legallyBindingAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
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
