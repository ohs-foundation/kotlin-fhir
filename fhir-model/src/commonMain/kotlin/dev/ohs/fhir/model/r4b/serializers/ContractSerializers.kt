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

package dev.ohs.fhir.model.r4b.serializers

import com.ionspin.kotlin.bignum.decimal.BigDecimal
import dev.ohs.fhir.model.r4b.Annotation
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coding
import dev.ohs.fhir.model.r4b.Contract
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Integer
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.Signature
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Time
import dev.ohs.fhir.model.r4b.Timing
import dev.ohs.fhir.model.r4b.UnsignedInt
import dev.ohs.fhir.model.r4b.Uri
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.ContentDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.ContentDefinition {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> subType = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          publisher =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.publisherSer, null)
        6 -> publicationDate = decoder.decodeStringElement(__desc, __i)
        7 ->
          _publicationDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.publicationDateSer, null)
        8 -> publicationStatus = decoder.decodeStringElement(__desc, __i)
        9 ->
          _publicationStatus =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.publicationDateSer, null)
        10 -> copyright = decoder.decodeStringElement(__desc, __i)
        11 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.publicationDateSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ContentDefinition: " + __i)
      }
    }
    return Contract.ContentDefinition(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      subType = subType,
      publisher = publisher,
      publicationDate = DateTime.of(FhirDateTime.fromString(publicationDate), _publicationDate),
      publicationStatus =
        Enumeration.of(
          Contract.ContractResourcePublicationStatusCodes.fromCode(publicationStatus!!),
          _publicationStatus,
        ),
      copyright = Markdown.of(copyright, _copyright),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.ContentDefinition) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.subType)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.publisher)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.publisherSer, it)
    }
    ((value.publicationDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.publicationDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.publicationDateSer, it)
    }
    ((value.publicationStatus.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 8, it) }
    (value.publicationStatus.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.publicationDateSer, it)
    }
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.publicationDateSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 -> issued = decoder.decodeStringElement(__desc, __i)
        5 ->
          _issued = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.issuedSer, null)
        6 ->
          applies = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.appliesSer, null)
        7 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        8 ->
          topicReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.topicReferenceSer, null)
        9 ->
          type =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        10 ->
          subType =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.topicCodeableConceptSer,
              null,
            )
        11 -> text = decoder.decodeStringElement(__desc, __i)
        12 ->
          _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.issuedSer, null)
        13 ->
          securityLabel =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.securityLabelSer, null)
        14 -> offer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.offerSer, null)
        15 -> asset = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.assetSer, null)
        16 ->
          action = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.actionSer, null)
        17 -> group = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.groupSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Term: " + __i)
      }
    }
    return Contract.Term(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier,
      issued = DateTime.of(FhirDateTime.fromString(issued), _issued),
      applies = applies,
      topic = Contract.Term.Topic.from(topicCodeableConcept, topicReference),
      type = type,
      subType = subType,
      text = R4bString.of(text, _text),
      securityLabel = securityLabel ?: listOf(),
      offer = offer!!,
      asset = asset ?: listOf(),
      action = action ?: listOf(),
      group = group ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, it)
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.issuedSer, it)
    }
    (value.applies)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.appliesSer, it) }
    when (val __d = value.topic) {
      null -> {}
      is Contract.Term.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 7, Hoisted.topicCodeableConceptSer, __d.value)
      }
      is Contract.Term.Topic.Reference -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.topicReferenceSer, __d.value)
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.topicCodeableConceptSer, it)
    }
    (value.subType)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.topicCodeableConceptSer, it)
    }
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.issuedSer, it)
    }
    if (value.securityLabel.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.securityLabelSer, value.securityLabel)
    (value.offer)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.offerSer, it) }
    if (value.asset.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.assetSer, value.asset)
    if (value.action.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.actionSer, value.action)
    if (value.group.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17, Hoisted.groupSer, value.group)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.SecurityLabel) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.SecurityLabel {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var number: List<Int?>? = null
    var _number: List<Element?>? = null
    var classification: Coding? = null
    var category: List<Coding>? = null
    var control: List<Coding>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          number = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.numberSer, null)
        4 ->
          _number = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.numberSer2, null)
        5 ->
          classification =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.classificationSer, null)
        6 ->
          category =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        7 ->
          control =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.categorySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SecurityLabel: " + __i)
      }
    }
    return Contract.Term.SecurityLabel(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      number =
        (kotlin.collections.List(maxOf(number?.size ?: 0, _number?.size ?: 0)) { __i ->
          UnsignedInt.of(number?.getOrNull(__i)?.let { it }, _number?.getOrNull(__i))!!
        }),
      classification = classification!!,
      category = category ?: listOf(),
      control = control ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.SecurityLabel) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.number.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.numberSer, it)
    }
    (value.number.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.numberSer2, it)
    }
    (value.classification)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.classificationSer, it)
    }
    if (value.category.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.categorySer, value.category)
    if (value.control.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.categorySer, value.control)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Offer {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        4 -> party = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partySer, null)
        5 -> topic = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.topicSer, null)
        6 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        7 ->
          decision = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        8 ->
          decisionMode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.decisionModeSer, null)
        9 ->
          answer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.answerSer, null)
        10 -> text = decoder.decodeStringElement(__desc, __i)
        11 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        12 ->
          linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        13 ->
          _linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        14 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        15 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Offer: " + __i)
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
      text = R4bString.of(text, _text),
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { __i ->
          R4bString.of(linkId?.getOrNull(__i)?.let { it }, _linkId?.getOrNull(__i))!!
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { __i ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(__i)?.let { it },
            _securityLabelNumber?.getOrNull(__i),
          )!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Offer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.identifierSer, value.identifier)
    if (value.party.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.partySer, value.party)
    (value.topic)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.topicSer, it) }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.decision)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    if (value.decisionMode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.decisionModeSer, value.decisionMode)
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.answerSer, value.answer)
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 10, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.textSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.linkIdSer2, it)
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.linkIdSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Party) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Offer.Party {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: List<Reference>? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Party: " + __i)
      }
    }
    return Contract.Term.Offer.Party(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference ?: listOf(),
      role = role!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Offer.Party) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, value.reference)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it) }
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

  override fun deserialize(decoder: Decoder): Contract.Term.Offer.Answer =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Offer.Answer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Offer.Answer {
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
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Answer: " + __i)
      }
    }
    return Contract.Term.Offer.Answer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` =
        Contract.Term.Offer.Answer.Value.from(
          R4bBoolean.of(valueBoolean, _valueBoolean),
          Decimal.of(valueDecimal, _valueDecimal),
          Integer.of(valueInteger, _valueInteger),
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          DateTime.of(FhirDateTime.fromString(valueDateTime), _valueDateTime),
          Time.of(valueTime, _valueTime),
          R4bString.of(valueString, _valueString),
          Uri.of(valueUri, _valueUri),
          valueAttachment,
          valueCoding,
          valueQuantity,
          valueReference,
        )!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Offer.Answer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.`value`) {
      null -> {}
      is Contract.Term.Offer.Answer.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 4, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Decimal -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 5, BigDecimalSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 6, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Integer -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 7, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 8, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Time -> {
        ((__d.value.value))?.let {
          encoder.encodeSerializableElement(__desc, 13, LocalTimeSerializer, it)
        }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 14, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 16, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Uri -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.valueBooleanSer, it)
        }
      }
      is Contract.Term.Offer.Answer.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.valueAttachmentSer, __d.value)
      }
      is Contract.Term.Offer.Answer.Value.Coding -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.valueCodingSer, __d.value)
      }
      is Contract.Term.Offer.Answer.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 21, Hoisted.valueQuantitySer, __d.value)
      }
      is Contract.Term.Offer.Answer.Value.Reference -> {
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Asset {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> scope = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.scopeSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          typeReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeReferenceSer, null)
        6 -> subtype = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        7 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.relationshipSer, null)
        8 ->
          context = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        9 -> condition = decoder.decodeStringElement(__desc, __i)
        10 ->
          _condition =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conditionSer, null)
        11 ->
          periodType = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        12 ->
          period = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        13 ->
          usePeriod =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.periodSer, null)
        14 -> text = decoder.decodeStringElement(__desc, __i)
        15 ->
          _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.conditionSer, null)
        16 ->
          linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        17 ->
          _linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        18 ->
          answer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.answerSer, null)
        19 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        20 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        21 ->
          valuedItem =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valuedItemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Asset: " + __i)
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
      condition = R4bString.of(condition, _condition),
      periodType = periodType ?: listOf(),
      period = period ?: listOf(),
      usePeriod = usePeriod ?: listOf(),
      text = R4bString.of(text, _text),
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { __i ->
          R4bString.of(linkId?.getOrNull(__i)?.let { it }, _linkId?.getOrNull(__i))!!
        }),
      answer = answer ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { __i ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(__i)?.let { it },
            _securityLabelNumber?.getOrNull(__i),
          )!!
        }),
      valuedItem = valuedItem ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Asset) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.scope)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.scopeSer, it) }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, value.type)
    if (value.typeReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.typeReferenceSer, value.typeReference)
    if (value.subtype.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, value.subtype)
    (value.relationship)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.relationshipSer, it)
    }
    if (value.context.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.contextSer, value.context)
    ((value.condition?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.condition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.conditionSer, it)
    }
    if (value.periodType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, value.periodType)
    if (value.period.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.periodSer, value.period)
    if (value.usePeriod.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.periodSer, value.usePeriod)
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.conditionSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.linkIdSer2, it)
    }
    if (value.answer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.answerSer, value.answer)
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.linkIdSer2, it)
    }
    if (value.valuedItem.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.valuedItemSer, value.valuedItem)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.Context) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Asset.Context {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: Reference? = null
    var code: List<CodeableConcept>? = null
    var text: KotlinString? = null
    var _text: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        4 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        5 -> text = decoder.decodeStringElement(__desc, __i)
        6 -> _text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Context: " + __i)
      }
    }
    return Contract.Term.Asset.Context(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      reference = reference,
      code = code ?: listOf(),
      text = R4bString.of(text, _text),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Asset.Context) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.reference)?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, it)
    }
    if (value.code.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, value.code)
    ((value.text?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.text?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.textSer, it)
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
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("points", BigDecimalSerializer.descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Asset.ValuedItem) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Asset.ValuedItem {
    val __desc = descriptor
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
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var points: BigDecimal? = null
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          entityCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.entityCodeableConceptSer,
              null,
            )
        4 ->
          entityReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.entityReferenceSer, null)
        5 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        6 -> effectiveTime = decoder.decodeStringElement(__desc, __i)
        7 ->
          _effectiveTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimeSer, null)
        8 ->
          quantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.quantitySer, null)
        9 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.unitPriceSer, null)
        10 ->
          factor =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        11 ->
          _factor =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimeSer, null)
        12 ->
          points =
            decoder.decodeNullableSerializableElement(__desc, __i, BigDecimalSerializer, null)
        13 ->
          _points =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimeSer, null)
        14 ->
          net = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.unitPriceSer, null)
        15 -> payment = decoder.decodeStringElement(__desc, __i)
        16 ->
          _payment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimeSer, null)
        17 -> paymentDate = decoder.decodeStringElement(__desc, __i)
        18 ->
          _paymentDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.effectiveTimeSer, null)
        19 ->
          responsible =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.entityReferenceSer, null)
        20 ->
          recipient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.entityReferenceSer, null)
        21 ->
          linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        22 ->
          _linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        23 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        24 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding ValuedItem: " + __i)
      }
    }
    return Contract.Term.Asset.ValuedItem(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      entity = Contract.Term.Asset.ValuedItem.Entity.from(entityCodeableConcept, entityReference),
      identifier = identifier,
      effectiveTime = DateTime.of(FhirDateTime.fromString(effectiveTime), _effectiveTime),
      quantity = quantity,
      unitPrice = unitPrice,
      factor = Decimal.of(factor, _factor),
      points = Decimal.of(points, _points),
      net = net,
      payment = R4bString.of(payment, _payment),
      paymentDate = DateTime.of(FhirDateTime.fromString(paymentDate), _paymentDate),
      responsible = responsible,
      recipient = recipient,
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { __i ->
          R4bString.of(linkId?.getOrNull(__i)?.let { it }, _linkId?.getOrNull(__i))!!
        }),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { __i ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(__i)?.let { it },
            _securityLabelNumber?.getOrNull(__i),
          )!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Asset.ValuedItem) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.entity) {
      null -> {}
      is Contract.Term.Asset.ValuedItem.Entity.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.entityCodeableConceptSer, __d.value)
      }
      is Contract.Term.Asset.ValuedItem.Entity.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.entityReferenceSer, __d.value)
      }
    }
    (value.identifier)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.identifierSer, it)
    }
    ((value.effectiveTime?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.effectiveTime?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.effectiveTimeSer, it)
    }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.unitPriceSer, it)
    }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 10, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 11, Hoisted.effectiveTimeSer, it)
    }
    ((value.points?.value))?.let {
      encoder.encodeSerializableElement(__desc, 12, BigDecimalSerializer, it)
    }
    (value.points?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.effectiveTimeSer, it)
    }
    (value.net)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.unitPriceSer, it) }
    ((value.payment?.value))?.let { encoder.encodeStringElement(__desc, 15, it) }
    (value.payment?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.effectiveTimeSer, it)
    }
    ((value.paymentDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
    (value.paymentDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.effectiveTimeSer, it)
    }
    (value.responsible)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.entityReferenceSer, it)
    }
    (value.recipient)?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.entityReferenceSer, it)
    }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.linkIdSer2, it)
    }
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.linkIdSer2, it)
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
        "reasonCode",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reasonReference",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "reason",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_reason", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Action {
    val __desc = descriptor
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
    var reasonCode: List<CodeableConcept>? = null
    var reasonReference: List<Reference>? = null
    var reason: List<KotlinString?>? = null
    var _reason: List<Element?>? = null
    var reasonLinkId: List<KotlinString?>? = null
    var _reasonLinkId: List<Element?>? = null
    var note: List<Annotation>? = null
    var securityLabelNumber: List<Int?>? = null
    var _securityLabelNumber: List<Element?>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> doNotPerform = decoder.decodeBooleanElement(__desc, __i)
        4 ->
          _doNotPerform =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doNotPerformSer, null)
        5 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        6 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        7 -> intent = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        8 ->
          linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        9 ->
          _linkId = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        10 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        11 ->
          context = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        12 ->
          contextLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        13 ->
          _contextLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        14 -> occurrenceDateTime = decoder.decodeStringElement(__desc, __i)
        15 ->
          _occurrenceDateTime =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.doNotPerformSer, null)
        16 ->
          occurrencePeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrencePeriodSer,
              null,
            )
        17 ->
          occurrenceTiming =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.occurrenceTimingSer,
              null,
            )
        18 ->
          requester =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requesterSer, null)
        19 ->
          requesterLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        20 ->
          _requesterLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        21 ->
          performerType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerTypeSer, null)
        22 ->
          performerRole =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        23 ->
          performer =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.contextSer, null)
        24 ->
          performerLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        25 ->
          _performerLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        26 ->
          reasonCode =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.performerTypeSer, null)
        27 ->
          reasonReference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.requesterSer, null)
        28 ->
          reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        29 ->
          _reason = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        30 ->
          reasonLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer, null)
        31 ->
          _reasonLinkId =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        32 -> note = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.noteSer, null)
        33 ->
          securityLabelNumber =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.securityLabelNumberSer,
              null,
            )
        34 ->
          _securityLabelNumber =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.linkIdSer2, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Action: " + __i)
      }
    }
    return Contract.Term.Action(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      doNotPerform = R4bBoolean.of(doNotPerform, _doNotPerform),
      type = type!!,
      subject = subject ?: listOf(),
      intent = intent!!,
      linkId =
        (kotlin.collections.List(maxOf(linkId?.size ?: 0, _linkId?.size ?: 0)) { __i ->
          R4bString.of(linkId?.getOrNull(__i)?.let { it }, _linkId?.getOrNull(__i))!!
        }),
      status = status!!,
      context = context,
      contextLinkId =
        (kotlin.collections.List(maxOf(contextLinkId?.size ?: 0, _contextLinkId?.size ?: 0)) { __i
          ->
          R4bString.of(contextLinkId?.getOrNull(__i)?.let { it }, _contextLinkId?.getOrNull(__i))!!
        }),
      occurrence =
        Contract.Term.Action.Occurrence.from(
          DateTime.of(FhirDateTime.fromString(occurrenceDateTime), _occurrenceDateTime),
          occurrencePeriod,
          occurrenceTiming,
        ),
      requester = requester ?: listOf(),
      requesterLinkId =
        (kotlin.collections.List(maxOf(requesterLinkId?.size ?: 0, _requesterLinkId?.size ?: 0)) {
          __i ->
          R4bString.of(
            requesterLinkId?.getOrNull(__i)?.let { it },
            _requesterLinkId?.getOrNull(__i),
          )!!
        }),
      performerType = performerType ?: listOf(),
      performerRole = performerRole,
      performer = performer,
      performerLinkId =
        (kotlin.collections.List(maxOf(performerLinkId?.size ?: 0, _performerLinkId?.size ?: 0)) {
          __i ->
          R4bString.of(
            performerLinkId?.getOrNull(__i)?.let { it },
            _performerLinkId?.getOrNull(__i),
          )!!
        }),
      reasonCode = reasonCode ?: listOf(),
      reasonReference = reasonReference ?: listOf(),
      reason =
        (kotlin.collections.List(maxOf(reason?.size ?: 0, _reason?.size ?: 0)) { __i ->
          R4bString.of(reason?.getOrNull(__i)?.let { it }, _reason?.getOrNull(__i))!!
        }),
      reasonLinkId =
        (kotlin.collections.List(maxOf(reasonLinkId?.size ?: 0, _reasonLinkId?.size ?: 0)) { __i ->
          R4bString.of(reasonLinkId?.getOrNull(__i)?.let { it }, _reasonLinkId?.getOrNull(__i))!!
        }),
      note = note ?: listOf(),
      securityLabelNumber =
        (kotlin.collections.List(
          maxOf(securityLabelNumber?.size ?: 0, _securityLabelNumber?.size ?: 0)
        ) { __i ->
          UnsignedInt.of(
            securityLabelNumber?.getOrNull(__i)?.let { it },
            _securityLabelNumber?.getOrNull(__i),
          )!!
        }),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Action) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.doNotPerform?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.doNotPerform?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.doNotPerformSer, it)
    }
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 6, Hoisted.subjectSer, value.subject)
    (value.intent)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    (value.linkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.linkIdSer, it)
    }
    (value.linkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 9, Hoisted.linkIdSer2, it)
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 10, Hoisted.typeSer, it) }
    (value.context)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.contextSer, it) }
    (value.contextLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.linkIdSer, it)
    }
    (value.contextLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.linkIdSer2, it)
    }
    when (val __d = value.occurrence) {
      null -> {}
      is Contract.Term.Action.Occurrence.DateTime -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 14, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 15, Hoisted.doNotPerformSer, it)
        }
      }
      is Contract.Term.Action.Occurrence.Period -> {
        encoder.encodeSerializableElement(__desc, 16, Hoisted.occurrencePeriodSer, __d.value)
      }
      is Contract.Term.Action.Occurrence.Timing -> {
        encoder.encodeSerializableElement(__desc, 17, Hoisted.occurrenceTimingSer, __d.value)
      }
    }
    if (value.requester.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 18, Hoisted.requesterSer, value.requester)
    (value.requesterLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.linkIdSer, it)
    }
    (value.requesterLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.linkIdSer2, it)
    }
    if (value.performerType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 21, Hoisted.performerTypeSer, value.performerType)
    (value.performerRole)?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.typeSer, it)
    }
    (value.performer)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.contextSer, it) }
    (value.performerLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 24, Hoisted.linkIdSer, it)
    }
    (value.performerLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.linkIdSer2, it)
    }
    if (value.reasonCode.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26, Hoisted.performerTypeSer, value.reasonCode)
    if (value.reasonReference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.requesterSer, value.reasonReference)
    (value.reason.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 28, Hoisted.linkIdSer, it)
    }
    (value.reason.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.linkIdSer2, it)
    }
    (value.reasonLinkId.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 30, Hoisted.linkIdSer, it)
    }
    (value.reasonLinkId.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.linkIdSer2, it)
    }
    if (value.note.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.noteSer, value.note)
    (value.securityLabelNumber.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 33, Hoisted.securityLabelNumberSer, it)
    }
    (value.securityLabelNumber.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.linkIdSer2, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Term.Action.Subject) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Term.Action.Subject {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var reference: List<Reference>? = null
    var role: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          reference =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.referenceSer, null)
        4 -> role = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.roleSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Subject: " + __i)
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Term.Action.Subject) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.reference.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.referenceSer, value.reference)
    (value.role)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.roleSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Signer) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Signer {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: Coding? = null
    var party: Reference? = null
    var signature: List<Signature>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 -> party = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.partySer, null)
        5 ->
          signature =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.signatureSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Signer: " + __i)
      }
    }
    return Contract.Signer(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      party = party!!,
      signature = signature ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Signer) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.partySer, it) }
    if (value.signature.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.signatureSer, value.signature)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Friendly) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Friendly {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Friendly: " + __i)
      }
    }
    return Contract.Friendly(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content = Contract.Friendly.Content.from(contentAttachment, contentReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Friendly) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.content) {
      null -> {}
      is Contract.Friendly.Content.Attachment -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.contentAttachmentSer, __d.value)
      }
      is Contract.Friendly.Content.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.contentReferenceSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Legal) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Legal {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Legal: " + __i)
      }
    }
    return Contract.Legal(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content = Contract.Legal.Content.from(contentAttachment, contentReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Legal) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.content) {
      null -> {}
      is Contract.Legal.Content.Attachment -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.contentAttachmentSer, __d.value)
      }
      is Contract.Legal.Content.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.contentReferenceSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Contract.Rule) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Contract.Rule {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var contentAttachment: Attachment? = null
    var contentReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          contentAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentAttachmentSer,
              null,
            )
        4 ->
          contentReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Rule: " + __i)
      }
    }
    return Contract.Rule(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      content = Contract.Rule.Content.from(contentAttachment, contentReference)!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Contract.Rule) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.content) {
      null -> {}
      is Contract.Rule.Content.Attachment -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.contentAttachmentSer, __d.value)
      }
      is Contract.Rule.Content.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.contentReferenceSer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: Contract) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Contract")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): Contract {
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
        11 -> url = decoder.decodeStringElement(__desc, __i)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 -> version = decoder.decodeStringElement(__desc, __i)
        14 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        15 -> status = decoder.decodeStringElement(__desc, __i)
        16 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        17 ->
          legalState =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        18 ->
          instantiatesCanonical =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        19 -> instantiatesUri = decoder.decodeStringElement(__desc, __i)
        20 ->
          _instantiatesUri =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        21 ->
          contentDerivative =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        22 -> issued = decoder.decodeStringElement(__desc, __i)
        23 ->
          _issued =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        24 ->
          applies = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.appliesSer, null)
        25 ->
          expirationType =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        26 ->
          subject = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        27 ->
          authority =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        28 ->
          domain = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        29 ->
          site = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        30 -> name = decoder.decodeStringElement(__desc, __i)
        31 ->
          _name =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        32 -> title = decoder.decodeStringElement(__desc, __i)
        33 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        34 -> subtitle = decoder.decodeStringElement(__desc, __i)
        35 ->
          _subtitle =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        36 -> alias = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.aliasSer, null)
        37 ->
          _alias = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.aliasSer2, null)
        38 ->
          author =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        39 ->
          scope =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        40 ->
          topicCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        41 ->
          topicReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        42 ->
          type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalStateSer, null)
        43 ->
          subType = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subTypeSer, null)
        44 ->
          contentDefinition =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.contentDefinitionSer,
              null,
            )
        45 -> term = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.termSer, null)
        46 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        47 ->
          relevantHistory =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.subjectSer, null)
        48 ->
          signer = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.signerSer, null)
        49 ->
          friendly =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.friendlySer, null)
        50 -> legal = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.legalSer, null)
        51 -> rule = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ruleSer, null)
        52 ->
          legallyBindingAttachment =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.legallyBindingAttachmentSer,
              null,
            )
        53 ->
          legallyBindingReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.instantiatesCanonicalSer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Contract: " + __i)
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
      version = R4bString.of(version, _version),
      status =
        status?.let { Enumeration.of(Contract.ContractResourceStatusCodes.fromCode(it), _status) },
      legalState = legalState,
      instantiatesCanonical = instantiatesCanonical,
      instantiatesUri = Uri.of(instantiatesUri, _instantiatesUri),
      contentDerivative = contentDerivative,
      issued = DateTime.of(FhirDateTime.fromString(issued), _issued),
      applies = applies,
      expirationType = expirationType,
      subject = subject ?: listOf(),
      authority = authority ?: listOf(),
      domain = domain ?: listOf(),
      site = site ?: listOf(),
      name = R4bString.of(name, _name),
      title = R4bString.of(title, _title),
      subtitle = R4bString.of(subtitle, _subtitle),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { __i ->
          R4bString.of(alias?.getOrNull(__i)?.let { it }, _alias?.getOrNull(__i))!!
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: Contract,
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.url?.value))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.url?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 13 + __off, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.status?.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 15 + __off, it) }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.legalState)?.let {
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.legalStateSer, it)
    }
    (value.instantiatesCanonical)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    ((value.instantiatesUri?.value))?.let { encoder.encodeStringElement(__desc, 19 + __off, it) }
    (value.instantiatesUri?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 20 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.contentDerivative)?.let {
      encoder.encodeSerializableElement(__desc, 21 + __off, Hoisted.legalStateSer, it)
    }
    ((value.issued?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 22 + __off, it) }
    (value.issued?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.applies)?.let {
      encoder.encodeSerializableElement(__desc, 24 + __off, Hoisted.appliesSer, it)
    }
    (value.expirationType)?.let {
      encoder.encodeSerializableElement(__desc, 25 + __off, Hoisted.legalStateSer, it)
    }
    if (value.subject.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 26 + __off, Hoisted.subjectSer, value.subject)
    if (value.authority.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27 + __off, Hoisted.subjectSer, value.authority)
    if (value.domain.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28 + __off, Hoisted.subjectSer, value.domain)
    if (value.site.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29 + __off, Hoisted.subjectSer, value.site)
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 30 + __off, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 32 + __off, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 33 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.subtitle?.value))?.let { encoder.encodeStringElement(__desc, 34 + __off, it) }
    (value.subtitle?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 35 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 36 + __off, Hoisted.aliasSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 37 + __off, Hoisted.aliasSer2, it)
    }
    (value.author)?.let {
      encoder.encodeSerializableElement(__desc, 38 + __off, Hoisted.instantiatesCanonicalSer, it)
    }
    (value.scope)?.let {
      encoder.encodeSerializableElement(__desc, 39 + __off, Hoisted.legalStateSer, it)
    }
    when (val __d = value.topic) {
      null -> {}
      is Contract.Topic.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 40 + __off, Hoisted.legalStateSer, __d.value)
      }
      is Contract.Topic.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          41 + __off,
          Hoisted.instantiatesCanonicalSer,
          __d.value,
        )
      }
    }
    (value.type)?.let {
      encoder.encodeSerializableElement(__desc, 42 + __off, Hoisted.legalStateSer, it)
    }
    if (value.subType.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 43 + __off, Hoisted.subTypeSer, value.subType)
    (value.contentDefinition)?.let {
      encoder.encodeSerializableElement(__desc, 44 + __off, Hoisted.contentDefinitionSer, it)
    }
    if (value.term.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45 + __off, Hoisted.termSer, value.term)
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        46 + __off,
        Hoisted.subjectSer,
        value.supportingInfo,
      )
    if (value.relevantHistory.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        47 + __off,
        Hoisted.subjectSer,
        value.relevantHistory,
      )
    if (value.signer.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 48 + __off, Hoisted.signerSer, value.signer)
    if (value.friendly.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 49 + __off, Hoisted.friendlySer, value.friendly)
    if (value.legal.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 50 + __off, Hoisted.legalSer, value.legal)
    if (value.rule.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 51 + __off, Hoisted.ruleSer, value.rule)
    when (val __d = value.legallyBinding) {
      null -> {}
      is Contract.LegallyBinding.Attachment -> {
        encoder.encodeSerializableElement(
          __desc,
          52 + __off,
          Hoisted.legallyBindingAttachmentSer,
          __d.value,
        )
      }
      is Contract.LegallyBinding.Reference -> {
        encoder.encodeSerializableElement(
          __desc,
          53 + __off,
          Hoisted.instantiatesCanonicalSer,
          __d.value,
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
      ContractSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Contract =
    decoder.decodeStructure(descriptor) { ContractSerializer.deserializeJson(this, descriptor, 0) }
}
