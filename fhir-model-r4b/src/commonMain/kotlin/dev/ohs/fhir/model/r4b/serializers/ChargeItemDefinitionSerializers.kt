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
import dev.ohs.fhir.model.r4b.FhirDecimal
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Markdown
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.UsageContext
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object ChargeItemDefinitionApplicabilitySerializer :
  KSerializer<ChargeItemDefinition.Applicability> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Applicability") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("language", KotlinString.serializer().descriptor)
      optionalElement("_language", ElementSerializer.descriptor)
      optionalElement("expression", KotlinString.serializer().descriptor)
      optionalElement("_expression", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<ChargeItemDefinition.Applicability>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.Applicability =
    decoder.decodeStructure(descriptor) {
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
          3 -> description = decodeStringElement(descriptor, i)
          4 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 -> language = decodeStringElement(descriptor, i)
          6 -> _language = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          7 -> expression = decodeStringElement(descriptor, i)
          8 ->
            _expression = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Applicability: " + i)
        }
      }
      ChargeItemDefinition.Applicability(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        description = R4bString.of(description, _description),
        language = R4bString.of(language, _language),
        expression = R4bString.of(expression, _expression),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.Applicability) {
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
      encodeStringIfNotNull(descriptor, 3, value.description?.value)
      encodeElementIfNotNull(descriptor, 4, value.description)
      encodeStringIfNotNull(descriptor, 5, value.language?.value)
      encodeElementIfNotNull(descriptor, 6, value.language)
      encodeStringIfNotNull(descriptor, 7, value.expression?.value)
      encodeElementIfNotNull(descriptor, 8, value.expression)
    }
  }
}

internal object ChargeItemDefinitionPropertyGroupSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PropertyGroup") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement(
        "applicability",
        listSerialDescriptor(
          lazyDescriptor { ChargeItemDefinitionApplicabilitySerializer.descriptor }
        ),
      )
      optionalElement(
        "priceComponent",
        ChargeItemDefinitionPropertyGroupPriceComponentSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<ChargeItemDefinition.PropertyGroup>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var applicability: List<ChargeItemDefinition.Applicability>? = null
      var priceComponent: List<ChargeItemDefinition.PropertyGroup.PriceComponent>? = null
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
            applicability =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ChargeItemDefinitionApplicabilitySerializer.listSerializer,
                null,
              )
          4 ->
            priceComponent =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ChargeItemDefinitionPropertyGroupPriceComponentSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PropertyGroup: " + i)
        }
      }
      ChargeItemDefinition.PropertyGroup(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        applicability = applicability ?: listOf(),
        priceComponent = priceComponent ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: ChargeItemDefinition.PropertyGroup) {
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
      if (value.applicability.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          ChargeItemDefinitionApplicabilitySerializer.listSerializer,
          value.applicability,
        )
      if (value.priceComponent.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          ChargeItemDefinitionPropertyGroupPriceComponentSerializer.listSerializer,
          value.priceComponent,
        )
    }
  }
}

internal object ChargeItemDefinitionPropertyGroupPriceComponentSerializer :
  KSerializer<ChargeItemDefinition.PropertyGroup.PriceComponent> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PriceComponent") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", KotlinString.serializer().descriptor)
      optionalElement("_type", ElementSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("factor", FhirDecimalSerializer.descriptor)
      optionalElement("_factor", ElementSerializer.descriptor)
      optionalElement("amount", MoneySerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<ChargeItemDefinition.PropertyGroup.PriceComponent>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): ChargeItemDefinition.PropertyGroup.PriceComponent =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: KotlinString? = null
      var _type: Element? = null
      var code: CodeableConcept? = null
      var factor: FhirDecimal? = null
      var _factor: Element? = null
      var amount: Money? = null
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
          3 -> type = decodeStringElement(descriptor, i)
          4 -> _type = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            factor = decodeNullableSerializableElement(descriptor, i, FhirDecimalSerializer, null)
          7 -> _factor = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> amount = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PriceComponent: " + i)
        }
      }
      ChargeItemDefinition.PropertyGroup.PriceComponent(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          Enumeration.of(
            if (type != null) ChargeItemDefinition.InvoicePriceComponentType.fromCode(type)
            else null,
            _type,
          )
            ?: throw SerializationException(
              "Missing required property 'type' on ChargeItemDefinition.PropertyGroup.PriceComponent"
            ),
        code = code,
        factor = Decimal.of(factor, _factor),
        amount = amount,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: ChargeItemDefinition.PropertyGroup.PriceComponent,
  ) {
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
      encodeStringIfNotNull(descriptor, 3, value.type.value?.code)
      encodeElementIfNotNull(descriptor, 4, value.type)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 6, FhirDecimalSerializer, value.factor?.value)
      encodeElementIfNotNull(descriptor, 7, value.factor)
      encodeSerializableIfNotNull(descriptor, 8, MoneySerializer, value.amount)
    }
  }
}

internal object ChargeItemDefinitionSerializer : FhirResourceSerializer<ChargeItemDefinition> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("ChargeItemDefinition")

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
    b.optionalElement("title", KotlinString.serializer().descriptor)
    b.optionalElement("_title", ElementSerializer.descriptor)
    b.optionalElement("derivedFromUri", stringNullableListSerializer.descriptor)
    b.optionalElement("_derivedFromUri", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("partOf", stringNullableListSerializer.descriptor)
    b.optionalElement("_partOf", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("replaces", stringNullableListSerializer.descriptor)
    b.optionalElement("_replaces", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("experimental", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_experimental", ElementSerializer.descriptor)
    b.optionalElement("date", KotlinString.serializer().descriptor)
    b.optionalElement("_date", ElementSerializer.descriptor)
    b.optionalElement("publisher", KotlinString.serializer().descriptor)
    b.optionalElement("_publisher", ElementSerializer.descriptor)
    b.optionalElement("contact", ContactDetailSerializer.listSerializer.descriptor)
    b.optionalElement("description", KotlinString.serializer().descriptor)
    b.optionalElement("_description", ElementSerializer.descriptor)
    b.optionalElement("useContext", UsageContextSerializer.listSerializer.descriptor)
    b.optionalElement("jurisdiction", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("copyright", KotlinString.serializer().descriptor)
    b.optionalElement("_copyright", ElementSerializer.descriptor)
    b.optionalElement("approvalDate", KotlinString.serializer().descriptor)
    b.optionalElement("_approvalDate", ElementSerializer.descriptor)
    b.optionalElement("lastReviewDate", KotlinString.serializer().descriptor)
    b.optionalElement("_lastReviewDate", ElementSerializer.descriptor)
    b.optionalElement("effectivePeriod", PeriodSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("instance", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "applicability",
      ChargeItemDefinitionApplicabilitySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "propertyGroup",
      ChargeItemDefinitionPropertyGroupSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): ChargeItemDefinition {
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
        15 -> title = decoder.decodeStringElement(descriptor, i)
        16 ->
          _title = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        17 ->
          derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        18 ->
          _derivedFromUri =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        19 ->
          partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        20 ->
          _partOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        21 ->
          replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        22 ->
          _replaces =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        23 -> status = decoder.decodeStringElement(descriptor, i)
        24 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> experimental = decoder.decodeBooleanElement(descriptor, i)
        26 ->
          _experimental =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 -> date = decoder.decodeStringElement(descriptor, i)
        28 ->
          _date = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> publisher = decoder.decodeStringElement(descriptor, i)
        30 ->
          _publisher =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ContactDetailSerializer.listSerializer,
              null,
            )
        32 -> description = decoder.decodeStringElement(descriptor, i)
        33 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          useContext =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              UsageContextSerializer.listSerializer,
              null,
            )
        35 ->
          jurisdiction =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        36 -> copyright = decoder.decodeStringElement(descriptor, i)
        37 ->
          _copyright =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        38 -> approvalDate = decoder.decodeStringElement(descriptor, i)
        39 ->
          _approvalDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        40 -> lastReviewDate = decoder.decodeStringElement(descriptor, i)
        41 ->
          _lastReviewDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        42 ->
          effectivePeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        43 ->
          code =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        44 ->
          instance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        45 ->
          applicability =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ChargeItemDefinitionApplicabilitySerializer.listSerializer,
              null,
            )
        46 ->
          propertyGroup =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ChargeItemDefinitionPropertyGroupSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding ChargeItemDefinition: " + i)
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
      url =
        Uri.of(url, _url)
          ?: throw SerializationException(
            "Missing required property 'url' on ChargeItemDefinition"
          ),
      identifier = identifier ?: listOf(),
      version = R4bString.of(version, _version),
      title = R4bString.of(title, _title),
      derivedFromUri =
        (kotlin.collections.List(maxOf(derivedFromUri?.size ?: 0, _derivedFromUri?.size ?: 0)) {
          index ->
          Uri.of(derivedFromUri?.getOrNull(index), _derivedFromUri?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'derivedFromUri' on ChargeItemDefinition has neither a value nor an id/extension"
            )
        }),
      partOf =
        (kotlin.collections.List(maxOf(partOf?.size ?: 0, _partOf?.size ?: 0)) { index ->
          Canonical.of(partOf?.getOrNull(index), _partOf?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'partOf' on ChargeItemDefinition has neither a value nor an id/extension"
            )
        }),
      replaces =
        (kotlin.collections.List(maxOf(replaces?.size ?: 0, _replaces?.size ?: 0)) { index ->
          Canonical.of(replaces?.getOrNull(index), _replaces?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'replaces' on ChargeItemDefinition has neither a value nor an id/extension"
            )
        }),
      status =
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on ChargeItemDefinition"
          ),
      experimental = R4bBoolean.of(experimental, _experimental),
      date = DateTime.of(if (date != null) FhirDateTime.fromString(date) else null, _date),
      publisher = R4bString.of(publisher, _publisher),
      contact = contact ?: listOf(),
      description = Markdown.of(description, _description),
      useContext = useContext ?: listOf(),
      jurisdiction = jurisdiction ?: listOf(),
      copyright = Markdown.of(copyright, _copyright),
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
      code = code,
      instance = instance ?: listOf(),
      applicability = applicability ?: listOf(),
      propertyGroup = propertyGroup ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: ChargeItemDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 10 + descriptorOffset, value.url.value)
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
    encoder.encodeStringIfNotNull(descriptor, 15 + descriptorOffset, value.title?.value)
    encoder.encodeElementIfNotNull(descriptor, 16 + descriptorOffset, value.title)
    if (value.derivedFromUri.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        17 + descriptorOffset,
        stringNullableListSerializer,
        value.derivedFromUri.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 18 + descriptorOffset, value.derivedFromUri)
    }
    if (value.partOf.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        19 + descriptorOffset,
        stringNullableListSerializer,
        value.partOf.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 20 + descriptorOffset, value.partOf)
    }
    if (value.replaces.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        21 + descriptorOffset,
        stringNullableListSerializer,
        value.replaces.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 22 + descriptorOffset, value.replaces)
    }
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.status)
    encoder.encodeBooleanIfNotNull(descriptor, 25 + descriptorOffset, value.experimental?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.experimental)
    encoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.date?.value?.toString())
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.date)
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.publisher?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.publisher)
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        ContactDetailSerializer.listSerializer,
        value.contact,
      )
    encoder.encodeStringIfNotNull(descriptor, 32 + descriptorOffset, value.description?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.description)
    if (value.useContext.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        UsageContextSerializer.listSerializer,
        value.useContext,
      )
    if (value.jurisdiction.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        35 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.jurisdiction,
      )
    encoder.encodeStringIfNotNull(descriptor, 36 + descriptorOffset, value.copyright?.value)
    encoder.encodeElementIfNotNull(descriptor, 37 + descriptorOffset, value.copyright)
    encoder.encodeStringIfNotNull(
      descriptor,
      38 + descriptorOffset,
      value.approvalDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 39 + descriptorOffset, value.approvalDate)
    encoder.encodeStringIfNotNull(
      descriptor,
      40 + descriptorOffset,
      value.lastReviewDate?.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 41 + descriptorOffset, value.lastReviewDate)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      42 + descriptorOffset,
      PeriodSerializer,
      value.effectivePeriod,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      43 + descriptorOffset,
      CodeableConceptSerializer,
      value.code,
    )
    if (value.instance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        44 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.instance,
      )
    if (value.applicability.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        45 + descriptorOffset,
        ChargeItemDefinitionApplicabilitySerializer.listSerializer,
        value.applicability,
      )
    if (value.propertyGroup.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        46 + descriptorOffset,
        ChargeItemDefinitionPropertyGroupSerializer.listSerializer,
        value.propertyGroup,
      )
  }
}
