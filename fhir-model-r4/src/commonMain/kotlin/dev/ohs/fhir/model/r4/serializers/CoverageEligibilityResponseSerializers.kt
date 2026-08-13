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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Boolean as R4Boolean
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.CoverageEligibilityResponse
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirDate
import dev.ohs.fhir.model.r4.FhirDateTime
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.UnsignedInt
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.ClaimProcessingCodes
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

internal object CoverageEligibilityResponseInsuranceSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
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
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("inforce", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_inforce", Element.serializer().descriptor, isOptional = true)
      element("benefitPeriod", Period.serializer().descriptor, isOptional = true)
      element(
        "item",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityResponse.Insurance.Item.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CoverageEligibilityResponse.Insurance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var inforce: KotlinBoolean? = null
    var _inforce: Element? = null
    var benefitPeriod: Period? = null
    var item: List<CoverageEligibilityResponse.Insurance.Item>? = null
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
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        4 -> inforce = decoder.decodeBooleanElement(descriptor, i)
        5 ->
          _inforce =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.inforceSer, null)
        6 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.benefitPeriodSer, null)
        7 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
      }
    }
    return CoverageEligibilityResponse.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coverage =
        coverage
          ?: throw SerializationException(
            "Missing required property 'coverage' on CoverageEligibilityResponse.Insurance"
          ),
      inforce = R4Boolean.of(inforce, _inforce),
      benefitPeriod = benefitPeriod,
      item = item ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.coverageSer, value.coverage)
    ((value.inforce?.value))?.let { encoder.encodeBooleanElement(descriptor, 4, it) }
    (value.inforce?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.inforceSer, it)
    }
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.benefitPeriodSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.itemSer, value.item)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val coverageSer: KSerializer<Reference> = Reference.serializer()

    public val inforceSer: KSerializer<Element> = Element.serializer()

    public val benefitPeriodSer: KSerializer<Period> = Period.serializer()

    public val itemSerInner: KSerializer<CoverageEligibilityResponse.Insurance.Item> =
      CoverageEligibilityResponse.Insurance.Item.serializer()

    public val itemSer: KSerializer<List<CoverageEligibilityResponse.Insurance.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}

internal object CoverageEligibilityResponseInsuranceItemSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item> {
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("productOrService", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "modifier",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("provider", Reference.serializer().descriptor, isOptional = true)
      element("excluded", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_excluded", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
      element("description", KotlinString.serializer().descriptor, isOptional = true)
      element("_description", Element.serializer().descriptor, isOptional = true)
      element("network", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("term", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "benefit",
        listSerialDescriptor(
          lazyDescriptor {
            CoverageEligibilityResponse.Insurance.Item.Benefit.serializer().descriptor
          }
        ),
        isOptional = true,
      )
      element("authorizationRequired", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_authorizationRequired", Element.serializer().descriptor, isOptional = true)
      element(
        "authorizationSupporting",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("authorizationUrl", KotlinString.serializer().descriptor, isOptional = true)
      element("_authorizationUrl", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance.Item) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CoverageEligibilityResponse.Insurance.Item {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var productOrService: CodeableConcept? = null
    var modifier: List<CodeableConcept>? = null
    var provider: Reference? = null
    var excluded: KotlinBoolean? = null
    var _excluded: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var description: KotlinString? = null
    var _description: Element? = null
    var network: CodeableConcept? = null
    var unit: CodeableConcept? = null
    var term: CodeableConcept? = null
    var benefit: List<CoverageEligibilityResponse.Insurance.Item.Benefit>? = null
    var authorizationRequired: KotlinBoolean? = null
    var _authorizationRequired: Element? = null
    var authorizationSupporting: List<CodeableConcept>? = null
    var authorizationUrl: KotlinString? = null
    var _authorizationUrl: Element? = null
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
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        4 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        5 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        6 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        7 -> excluded = decoder.decodeBooleanElement(descriptor, i)
        8 ->
          _excluded =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        9 -> name = decoder.decodeStringElement(descriptor, i)
        10 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        11 -> description = decoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        13 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        14 ->
          unit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        15 ->
          term = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        16 ->
          benefit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.benefitSer, null)
        17 -> authorizationRequired = decoder.decodeBooleanElement(descriptor, i)
        18 ->
          _authorizationRequired =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        19 ->
          authorizationSupporting =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        20 -> authorizationUrl = decoder.decodeStringElement(descriptor, i)
        21 ->
          _authorizationUrl =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.excludedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return CoverageEligibilityResponse.Insurance.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category,
      productOrService = productOrService,
      modifier = modifier ?: listOf(),
      provider = provider,
      excluded = R4Boolean.of(excluded, _excluded),
      name = R4String.of(name, _name),
      description = R4String.of(description, _description),
      network = network,
      unit = unit,
      term = term,
      benefit = benefit ?: listOf(),
      authorizationRequired = R4Boolean.of(authorizationRequired, _authorizationRequired),
      authorizationSupporting = authorizationSupporting ?: listOf(),
      authorizationUrl = Uri.of(authorizationUrl, _authorizationUrl),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance.Item,
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
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.categorySer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.categorySer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.modifierSer, value.modifier)
    (value.provider)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.providerSer, it)
    }
    ((value.excluded?.value))?.let { encoder.encodeBooleanElement(descriptor, 7, it) }
    (value.excluded?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.excludedSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 9, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.excludedSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.excludedSer, it)
    }
    (value.network)?.let {
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.categorySer, it)
    }
    (value.unit)?.let { encoder.encodeSerializableElement(descriptor, 14, Hoisted.categorySer, it) }
    (value.term)?.let { encoder.encodeSerializableElement(descriptor, 15, Hoisted.categorySer, it) }
    if (value.benefit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 16, Hoisted.benefitSer, value.benefit)
    ((value.authorizationRequired?.value))?.let { encoder.encodeBooleanElement(descriptor, 17, it) }
    (value.authorizationRequired?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 18, Hoisted.excludedSer, it)
    }
    if (value.authorizationSupporting.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19,
        Hoisted.modifierSer,
        value.authorizationSupporting,
      )
    ((value.authorizationUrl?.value))?.let { encoder.encodeStringElement(descriptor, 20, it) }
    (value.authorizationUrl?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 21, Hoisted.excludedSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.categorySer)

    public val providerSer: KSerializer<Reference> = Reference.serializer()

    public val excludedSer: KSerializer<Element> = Element.serializer()

    public val benefitSerInner: KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit> =
      CoverageEligibilityResponse.Insurance.Item.Benefit.serializer()

    public val benefitSer: KSerializer<List<CoverageEligibilityResponse.Insurance.Item.Benefit>> =
      ListSerializer(Hoisted.benefitSerInner)
  }
}

internal object CoverageEligibilityResponseInsuranceItemBenefitSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Benefit") {
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
      element("allowedUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_allowedUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("allowedString", KotlinString.serializer().descriptor, isOptional = true)
      element("_allowedString", Element.serializer().descriptor, isOptional = true)
      element("allowedMoney", Money.serializer().descriptor, isOptional = true)
      element("usedUnsignedInt", Int.serializer().descriptor, isOptional = true)
      element("_usedUnsignedInt", Element.serializer().descriptor, isOptional = true)
      element("usedString", KotlinString.serializer().descriptor, isOptional = true)
      element("_usedString", Element.serializer().descriptor, isOptional = true)
      element("usedMoney", Money.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item.Benefit =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
  ) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CoverageEligibilityResponse.Insurance.Item.Benefit {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var allowedUnsignedInt: Int? = null
    var _allowedUnsignedInt: Element? = null
    var allowedString: KotlinString? = null
    var _allowedString: Element? = null
    var allowedMoney: Money? = null
    var usedUnsignedInt: Int? = null
    var _usedUnsignedInt: Element? = null
    var usedString: KotlinString? = null
    var _usedString: Element? = null
    var usedMoney: Money? = null
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
        4 -> allowedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        5 ->
          _allowedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        6 -> allowedString = decoder.decodeStringElement(descriptor, i)
        7 ->
          _allowedString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        8 ->
          allowedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allowedMoneySer, null)
        9 -> usedUnsignedInt = decoder.decodeIntElement(descriptor, i)
        10 ->
          _usedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        11 -> usedString = decoder.decodeStringElement(descriptor, i)
        12 ->
          _usedString =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        13 ->
          usedMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.allowedMoneySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
      }
    }
    return CoverageEligibilityResponse.Insurance.Item.Benefit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on CoverageEligibilityResponse.Insurance.Item.Benefit"
          ),
      allowed =
        CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.from(
          UnsignedInt.of(allowedUnsignedInt, _allowedUnsignedInt),
          R4String.of(allowedString, _allowedString),
          allowedMoney,
        ),
      used =
        CoverageEligibilityResponse.Insurance.Item.Benefit.Used.from(
          UnsignedInt.of(usedUnsignedInt, _usedUnsignedInt),
          R4String.of(usedString, _usedString),
          usedMoney,
        ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, value.type)
    when (val choice = value.allowed) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 5, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 7, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.Money -> {
        encoder.encodeSerializableElement(descriptor, 8, Hoisted.allowedMoneySer, choice.value)
      }
    }
    when (val choice = value.used) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.UnsignedInt -> {
        ((choice.value.value))?.let { encoder.encodeIntElement(descriptor, 9, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 10, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.String -> {
        ((choice.value.value))?.let { encoder.encodeStringElement(descriptor, 11, it) }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(descriptor, 12, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.Money -> {
        encoder.encodeSerializableElement(descriptor, 13, Hoisted.allowedMoneySer, choice.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val allowedUnsignedIntSer: KSerializer<Element> = Element.serializer()

    public val allowedMoneySer: KSerializer<Money> = Money.serializer()
  }
}

internal object CoverageEligibilityResponseErrorSerializer :
  KSerializer<CoverageEligibilityResponse.Error> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Error") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Error =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Error) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CoverageEligibilityResponse.Error {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Error: " + i)
      }
    }
    return CoverageEligibilityResponse.Error(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code =
        code
          ?: throw SerializationException(
            "Missing required property 'code' on CoverageEligibilityResponse.Error"
          ),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Error,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object CoverageEligibilityResponseSerializer : KSerializer<CoverageEligibilityResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityResponse") {
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
    b.element("status", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_status", Element.serializer().descriptor, isOptional = true)
    b.element(
      "purpose",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_purpose", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_servicedDate", Element.serializer().descriptor, isOptional = true)
    b.element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("requestor", Reference.serializer().descriptor, isOptional = true)
    b.element("request", Reference.serializer().descriptor, isOptional = true)
    b.element("outcome", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_outcome", Element.serializer().descriptor, isOptional = true)
    b.element("disposition", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_disposition", Element.serializer().descriptor, isOptional = true)
    b.element("insurer", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "insurance",
      listSerialDescriptor(
        lazyDescriptor { CoverageEligibilityResponse.Insurance.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
    b.element("form", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "error",
      listSerialDescriptor(
        lazyDescriptor { CoverageEligibilityResponse.Error.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CoverageEligibilityResponse")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CoverageEligibilityResponse {
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
    var status: KotlinString? = null
    var _status: Element? = null
    var purpose: List<KotlinString?>? = null
    var _purpose: List<Element?>? = null
    var patient: Reference? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var requestor: Reference? = null
    var request: Reference? = null
    var outcome: KotlinString? = null
    var _outcome: Element? = null
    var disposition: KotlinString? = null
    var _disposition: Element? = null
    var insurer: Reference? = null
    var insurance: List<CoverageEligibilityResponse.Insurance>? = null
    var preAuthRef: KotlinString? = null
    var _preAuthRef: Element? = null
    var form: CodeableConcept? = null
    var error: List<CoverageEligibilityResponse.Error>? = null
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        13 ->
          purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.purposeSer, null)
        14 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.purposeSer2, null)
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        16 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.servicedPeriodSer,
              null,
            )
        19 -> created = decoder.decodeStringElement(descriptor, i)
        20 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        22 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        23 -> outcome = decoder.decodeStringElement(descriptor, i)
        24 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        25 -> disposition = decoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        28 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.insuranceSer, null)
        29 -> preAuthRef = decoder.decodeStringElement(descriptor, i)
        30 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        31 -> form = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.formSer, null)
        32 ->
          error = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.errorSer, null)
        else ->
          throw SerializationException(
            "Unexpected index decoding CoverageEligibilityResponse: " + i
          )
      }
    }
    return CoverageEligibilityResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      status =
        Enumeration.of(
          CoverageEligibilityResponse.FinancialResourceStatusCodes.fromCode(
            status
              ?: throw SerializationException(
                "Missing required property 'status' on CoverageEligibilityResponse"
              )
          ),
          _status,
        ),
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { index ->
          Enumeration.of(
            CoverageEligibilityResponse.EligibilityResponsePurpose.fromCode(
              purpose?.getOrNull(index)!!
            ),
            _purpose?.getOrNull(index),
          )
        }),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on CoverageEligibilityResponse"
          ),
      serviced =
        CoverageEligibilityResponse.Serviced.from(
          Date.of(servicedDate?.let { FhirDate.fromString(it) }, _servicedDate),
          servicedPeriod,
        ),
      created =
        DateTime.of(created?.let { FhirDateTime.fromString(it) }, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on CoverageEligibilityResponse"
          ),
      requestor = requestor,
      request =
        request
          ?: throw SerializationException(
            "Missing required property 'request' on CoverageEligibilityResponse"
          ),
      outcome =
        Enumeration.of(
          ClaimProcessingCodes.fromCode(
            outcome
              ?: throw SerializationException(
                "Missing required property 'outcome' on CoverageEligibilityResponse"
              )
          ),
          _outcome,
        ),
      disposition = R4String.of(disposition, _disposition),
      insurer =
        insurer
          ?: throw SerializationException(
            "Missing required property 'insurer' on CoverageEligibilityResponse"
          ),
      insurance = insurance ?: listOf(),
      preAuthRef = R4String.of(preAuthRef, _preAuthRef),
      form = form,
      error = error ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CoverageEligibilityResponse,
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
    ((value.status.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.purpose.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.purposeSer, it)
    }
    (value.purpose.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.purposeSer2, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    when (val choice = value.serviced) {
      null -> {}
      is CoverageEligibilityResponse.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            17 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is CoverageEligibilityResponse.Serviced.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          Hoisted.servicedPeriodSer,
          choice.value,
        )
      }
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.requestor)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.patientSer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      Hoisted.patientSer,
      value.request,
    )
    ((value.outcome.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 23 + descriptorOffset, it)
    }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.disposition?.value))?.let {
      encoder.encodeStringElement(descriptor, 25 + descriptorOffset, it)
    }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      Hoisted.patientSer,
      value.insurer,
    )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.insuranceSer,
        value.insurance,
      )
    ((value.preAuthRef?.value))?.let {
      encoder.encodeStringElement(descriptor, 29 + descriptorOffset, it)
    }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        30 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.form)?.let {
      encoder.encodeSerializableElement(descriptor, 31 + descriptorOffset, Hoisted.formSer, it)
    }
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.errorSer,
        value.error,
      )
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

    public val purposeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val purposeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.purposeSerInner).nullable)

    public val purposeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val insuranceSerInner: KSerializer<CoverageEligibilityResponse.Insurance> =
      CoverageEligibilityResponse.Insurance.serializer()

    public val insuranceSer: KSerializer<List<CoverageEligibilityResponse.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val formSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val errorSerInner: KSerializer<CoverageEligibilityResponse.Error> =
      CoverageEligibilityResponse.Error.serializer()

    public val errorSer: KSerializer<List<CoverageEligibilityResponse.Error>> =
      ListSerializer(Hoisted.errorSerInner)
  }
}

internal object CoverageEligibilityResponsePolymorphicSerializer :
  KSerializer<CoverageEligibilityResponse> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityResponse") {
      CoverageEligibilityResponseSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse) {
    encoder.encodeStructure(descriptor) {
      CoverageEligibilityResponseSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse =
    decoder.decodeStructure(descriptor) {
      CoverageEligibilityResponseSerializer.deserializeInternal(this, descriptor, 0)
    }
}
