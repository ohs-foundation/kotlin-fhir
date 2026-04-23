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
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Canonical
import dev.ohs.fhir.model.r4b.ChargeItemDefinition
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactDetail
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Decimal
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

internal object ChargeItemDefinitionApplicabilitySerializer :
  KSerializer<ChargeItemDefinition.Applicability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Applicability") {
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
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("expression", KotlinString.serializer().descriptor, isOptional = true)
      element("_expression", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.Applicability =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.Applicability) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition.Applicability {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var language: KotlinString? = null
    var _language: Element? = null
    var expression: KotlinString? = null
    var _expression: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> description = decoder.decodeStringElement(__desc, 3)
        4 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.descriptionSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.descriptionSer, null)
        7 -> expression = decoder.decodeStringElement(__desc, 7)
        8 ->
          _expression =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.descriptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Applicability: " + __i)
      }
    }
    return ChargeItemDefinition.Applicability(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      description = R4bString.of(description, _description),
      language = R4bString.of(language, _language),
      expression = R4bString.of(expression, _expression),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ChargeItemDefinition.Applicability,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.descriptionSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.descriptionSer, it)
    }
    ((value.expression?.value))?.let { encoder.encodeStringElement(__desc, 7, it) }
    (value.expression?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.descriptionSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val descriptionSer: KSerializer<Element> = Element.serializer()
  }
}

internal object ChargeItemDefinitionPropertyGroupSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PropertyGroup") {
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
        "applicability",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.Applicability.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "priceComponent",
        listSerialDescriptor(
          lazyDescriptor {
            ChargeItemDefinition.PropertyGroup.PriceComponent.serializer().descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.PropertyGroup) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition.PropertyGroup {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var applicability: List<ChargeItemDefinition.Applicability>? = null
    var priceComponent: List<ChargeItemDefinition.PropertyGroup.PriceComponent>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          applicability =
            decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.applicabilitySer, null)
        4 ->
          priceComponent =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.priceComponentSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PropertyGroup: " + __i)
      }
    }
    return ChargeItemDefinition.PropertyGroup(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      applicability = applicability ?: listOf(),
      priceComponent = priceComponent ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ChargeItemDefinition.PropertyGroup,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    if (value.applicability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 3, Hoisted.applicabilitySer, value.applicability)
    if (value.priceComponent.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 4, Hoisted.priceComponentSer, value.priceComponent)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val applicabilitySerInner: KSerializer<ChargeItemDefinition.Applicability> =
      ChargeItemDefinition.Applicability.serializer()

    public val applicabilitySer: KSerializer<List<ChargeItemDefinition.Applicability>> =
      ListSerializer(Hoisted.applicabilitySerInner)

    public val priceComponentSerInner:
      KSerializer<ChargeItemDefinition.PropertyGroup.PriceComponent> =
      ChargeItemDefinition.PropertyGroup.PriceComponent.serializer()

    public val priceComponentSer:
      KSerializer<List<ChargeItemDefinition.PropertyGroup.PriceComponent>> =
      ListSerializer(Hoisted.priceComponentSerInner)
  }
}

internal object ChargeItemDefinitionPropertyGroupPriceComponentSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup.PriceComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PriceComponent") {
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
      element("type", KotlinString.serializer().descriptor, isOptional = true)
      element("_type", Element.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("factor", BigDecimalSerializer.descriptor, isOptional = true)
      element("_factor", Element.serializer().descriptor, isOptional = true)
      element("amount", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup.PriceComponent =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: ChargeItemDefinition.PropertyGroup.PriceComponent,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): ChargeItemDefinition.PropertyGroup.PriceComponent {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: KotlinString? = null
    var _type: Element? = null
    var code: CodeableConcept? = null
    var factor: BigDecimal? = null
    var _factor: Element? = null
    var amount: Money? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeStringElement(__desc, 3)
        4 -> _type = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> code = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.codeSer, null)
        6 ->
          factor = decoder.decodeNullableSerializableElement(__desc, 6, BigDecimalSerializer, null)
        7 -> _factor = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 -> amount = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.amountSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PriceComponent: " + __i)
      }
    }
    return ChargeItemDefinition.PropertyGroup.PriceComponent(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = Enumeration.of(ChargeItemDefinition.InvoicePriceComponentType.fromCode(type!!), _type),
      code = code,
      factor = Decimal.of(factor, _factor),
      amount = amount,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: ChargeItemDefinition.PropertyGroup.PriceComponent,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.type.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.type.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it)
    }
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.codeSer, it) }
    ((value.factor?.value))?.let {
      encoder.encodeSerializableElement(__desc, 6, BigDecimalSerializer, it)
    }
    (value.factor?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it)
    }
    (value.amount)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.amountSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<Element> = Element.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val amountSer: KSerializer<Money> = Money.serializer()
  }
}

internal object ChargeItemDefinitionSerializer : KSerializer<ChargeItemDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("ChargeItemDefinition") {
      element("resourceType", KotlinString.serializer().descriptor, isOptional = false)
      element("id", KotlinString.serializer().descriptor, isOptional = true)
      element("meta", Meta.serializer().descriptor, isOptional = true)
      element("implicitRules", KotlinString.serializer().descriptor, isOptional = true)
      element("_implicitRules", Element.serializer().descriptor, isOptional = true)
      element("language", KotlinString.serializer().descriptor, isOptional = true)
      element("_language", Element.serializer().descriptor, isOptional = true)
      element("text", Narrative.serializer().descriptor, isOptional = true)
      element(
        "contained",
        listSerialDescriptor(Resource.serializer().descriptor),
        isOptional = true,
      )
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
      element("url", KotlinString.serializer().descriptor, isOptional = true)
      element("_url", Element.serializer().descriptor, isOptional = true)
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("version", KotlinString.serializer().descriptor, isOptional = true)
      element("_version", Element.serializer().descriptor, isOptional = true)
      element("title", KotlinString.serializer().descriptor, isOptional = true)
      element("_title", Element.serializer().descriptor, isOptional = true)
      element(
        "derivedFromUri",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_derivedFromUri",
        listSerialDescriptor(Element.serializer().descriptor),
        isOptional = true,
      )
      element(
        "partOf",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_partOf", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element(
        "replaces",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_replaces", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element("experimental", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_experimental", Element.serializer().descriptor, isOptional = true)
      element("date", KotlinString.serializer().descriptor, isOptional = true)
      element("_date", Element.serializer().descriptor, isOptional = true)
      element("publisher", KotlinString.serializer().descriptor, isOptional = true)
      element("_publisher", Element.serializer().descriptor, isOptional = true)
      element(
        "contact",
        listSerialDescriptor(ContactDetail.serializer().descriptor),
        isOptional = true,
      )
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element(
        "useContext",
        listSerialDescriptor(UsageContext.serializer().descriptor),
        isOptional = true,
      )
      element(
        "jurisdiction",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("copyright", KotlinString.serializer().descriptor, isOptional = true)
      element("_copyright", Element.serializer().descriptor, isOptional = true)
      element("approvalDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_approvalDate", Element.serializer().descriptor, isOptional = true)
      element("lastReviewDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_lastReviewDate", Element.serializer().descriptor, isOptional = true)
      element("effectivePeriod", Period.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "instance",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element(
        "applicability",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.Applicability.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "propertyGroup",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinition.PropertyGroup.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): ChargeItemDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): ChargeItemDefinition {
    val __desc = descriptor
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
    var title: KotlinString? = null
    var _title: Element? = null
    var derivedFromUri: List<KotlinString?>? = null
    var _derivedFromUri: List<Element?>? = null
    var partOf: List<KotlinString?>? = null
    var _partOf: List<Element?>? = null
    var replaces: List<KotlinString?>? = null
    var _replaces: List<Element?>? = null
    var status: KotlinString? = null
    var _status: Element? = null
    var experimental: KotlinBoolean? = null
    var _experimental: Element? = null
    var date: KotlinString? = null
    var _date: Element? = null
    var publisher: KotlinString? = null
    var _publisher: Element? = null
    var contact: List<ContactDetail>? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var useContext: List<UsageContext>? = null
    var jurisdiction: List<CodeableConcept>? = null
    var copyright: KotlinString? = null
    var _copyright: Element? = null
    var approvalDate: KotlinString? = null
    var _approvalDate: Element? = null
    var lastReviewDate: KotlinString? = null
    var _lastReviewDate: Element? = null
    var effectivePeriod: Period? = null
    var code: CodeableConcept? = null
    var instance: List<Reference>? = null
    var applicability: List<ChargeItemDefinition.Applicability>? = null
    var propertyGroup: List<ChargeItemDefinition.PropertyGroup>? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> decoder.decodeStringElement(__desc, 0)
        1 -> id = decoder.decodeStringElement(__desc, 1)
        2 -> meta = decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.metaSer, null)
        3 -> implicitRules = decoder.decodeStringElement(__desc, 3)
        4 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.implicitRulesSer, null)
        5 -> language = decoder.decodeStringElement(__desc, 5)
        6 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.implicitRulesSer, null)
        7 -> text = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.textSer, null)
        8 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.containedSer, null)
        9 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.extensionSer, null)
        10 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.extensionSer, null)
        11 -> url = decoder.decodeStringElement(__desc, 11)
        12 ->
          _url =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.implicitRulesSer, null)
        13 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.identifierSer, null)
        14 -> version = decoder.decodeStringElement(__desc, 14)
        15 ->
          _version =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 -> title = decoder.decodeStringElement(__desc, 16)
        17 ->
          _title =
            decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.implicitRulesSer, null)
        18 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.derivedFromUriSer, null)
        19 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.derivedFromUriSer2, null)
        20 ->
          partOf =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.derivedFromUriSer, null)
        21 ->
          _partOf =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.derivedFromUriSer2, null)
        22 ->
          replaces =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.derivedFromUriSer, null)
        23 ->
          _replaces =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.derivedFromUriSer2, null)
        24 -> status = decoder.decodeStringElement(__desc, 24)
        25 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> experimental = decoder.decodeBooleanElement(__desc, 26)
        27 ->
          _experimental =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 -> date = decoder.decodeStringElement(__desc, 28)
        29 ->
          _date =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> publisher = decoder.decodeStringElement(__desc, 30)
        31 ->
          _publisher =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          contact = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.contactSer, null)
        33 -> description = decoder.decodeStringElement(__desc, 33)
        34 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          useContext =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.useContextSer, null)
        36 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.jurisdictionSer, null)
        37 -> copyright = decoder.decodeStringElement(__desc, 37)
        38 ->
          _copyright =
            decoder.decodeNullableSerializableElement(__desc, 38, Hoisted.implicitRulesSer, null)
        39 -> approvalDate = decoder.decodeStringElement(__desc, 39)
        40 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(__desc, 40, Hoisted.implicitRulesSer, null)
        41 -> lastReviewDate = decoder.decodeStringElement(__desc, 41)
        42 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(__desc, 42, Hoisted.implicitRulesSer, null)
        43 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(__desc, 43, Hoisted.effectivePeriodSer, null)
        44 ->
          code =
            decoder.decodeNullableSerializableElement(
              __desc,
              44,
              Hoisted.jurisdictionSerInner,
              null,
            )
        45 ->
          instance =
            decoder.decodeNullableSerializableElement(__desc, 45, Hoisted.instanceSer, null)
        46 ->
          applicability =
            decoder.decodeNullableSerializableElement(__desc, 46, Hoisted.applicabilitySer, null)
        47 ->
          propertyGroup =
            decoder.decodeNullableSerializableElement(__desc, 47, Hoisted.propertyGroupSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding ChargeItemDefinition: " + __i)
      }
    }
    return ChargeItemDefinition(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      url = Uri.of(url, _url)!!,
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      title = R4bString.of(title, _title),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) { __i
          ->
          Uri.of(derivedFromUri?.getOrNull(__i)?.let { it }, _derivedFromUri?.getOrNull(__i))!!
        }),
      partOf =
        (kotlin.collections.List(maxOf(partOf?.size ?: 0, _partOf?.size ?: 0)) { __i ->
          Canonical.of(partOf?.getOrNull(__i)?.let { it }, _partOf?.getOrNull(__i))!!
        }),
      replaces =
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { __i ->
          Canonical.of(replaces?.getOrNull(__i)?.let { it }, _replaces?.getOrNull(__i))!!
        }),
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(FhirDateTime.fromString(date), _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      copyright = Markdown.of(copyright, _copyright),
      approvalDate = Date.of(FhirDate.fromString(approvalDate), _approvalDate),
      lastReviewDate = Date.of(FhirDate.fromString(lastReviewDate), _lastReviewDate),
      effectivePeriod = effectivePeriod,
      code = code,
      instance = instance ?: listOf(),
      applicability = applicability ?: listOf(),
      propertyGroup = propertyGroup ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: ChargeItemDefinition) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "ChargeItemDefinition")
    (value.id)?.let { encoder.encodeStringElement(__desc, 1, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 2, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 3, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.extensionSer, value.modifierExtension)
    ((value.url.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.url.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.implicitRulesSer, it)
    }
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.identifierSer, value.identifier)
    ((value.version?.value))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.version?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    ((value.title?.value))?.let { encoder.encodeStringElement(__desc, 16, it) }
    (value.title?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 17, Hoisted.implicitRulesSer, it)
    }
    (value.derivedFromUri.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.derivedFromUriSer, it)
    }
    (value.derivedFromUri.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.derivedFromUriSer2, it)
    }
    (value.partOf.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 20, Hoisted.derivedFromUriSer, it)
    }
    (value.partOf.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.derivedFromUriSer2, it)
    }
    (value.replaces.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.derivedFromUriSer, it)
    }
    (value.replaces.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.derivedFromUriSer2, it)
    }
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.experimental?.value))?.let { encoder.encodeBooleanElement(__desc, 26, it) }
    (value.experimental?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    ((value.date?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 28, it) }
    (value.date?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.publisher?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.publisher?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 32, Hoisted.contactSer, value.contact)
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 33, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.useContextSer, value.useContext)
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 36, Hoisted.jurisdictionSer, value.jurisdiction)
    ((value.copyright?.value))?.let { encoder.encodeStringElement(__desc, 37, it) }
    (value.copyright?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 38, Hoisted.implicitRulesSer, it)
    }
    ((value.approvalDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 39, it) }
    (value.approvalDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 40, Hoisted.implicitRulesSer, it)
    }
    ((value.lastReviewDate?.value?.toString()))?.let { encoder.encodeStringElement(__desc, 41, it) }
    (value.lastReviewDate?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 42, Hoisted.implicitRulesSer, it)
    }
    (value.effectivePeriod)?.let {
      encoder.encodeSerializableElement(__desc, 43, Hoisted.effectivePeriodSer, it)
    }
    (value.code)?.let {
      encoder.encodeSerializableElement(__desc, 44, Hoisted.jurisdictionSerInner, it)
    }
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 45, Hoisted.instanceSer, value.instance)
    if (value.applicability.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 46, Hoisted.applicabilitySer, value.applicability)
    if (value.propertyGroup.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 47, Hoisted.propertyGroupSer, value.propertyGroup)
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

    public val derivedFromUriSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val derivedFromUriSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.derivedFromUriSerInner).nullable)

    public val derivedFromUriSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val contactSerInner: KSerializer<ContactDetail> = ContactDetail.serializer()

    public val contactSer: KSerializer<List<ContactDetail>> =
      ListSerializer(Hoisted.contactSerInner)

    public val useContextSerInner: KSerializer<UsageContext> = UsageContext.serializer()

    public val useContextSer: KSerializer<List<UsageContext>> =
      ListSerializer(Hoisted.useContextSerInner)

    public val jurisdictionSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val jurisdictionSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.jurisdictionSerInner)

    public val effectivePeriodSer: KSerializer<Period> = Period.serializer()

    public val instanceSerInner: KSerializer<Reference> = Reference.serializer()

    public val instanceSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.instanceSerInner)

    public val applicabilitySerInner: KSerializer<ChargeItemDefinition.Applicability> =
      ChargeItemDefinition.Applicability.serializer()

    public val applicabilitySer: KSerializer<List<ChargeItemDefinition.Applicability>> =
      ListSerializer(Hoisted.applicabilitySerInner)

    public val propertyGroupSerInner: KSerializer<ChargeItemDefinition.PropertyGroup> =
      ChargeItemDefinition.PropertyGroup.serializer()

    public val propertyGroupSer: KSerializer<List<ChargeItemDefinition.PropertyGroup>> =
      ListSerializer(Hoisted.propertyGroupSerInner)
  }
}
