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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityResponse.Insurance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var inforce: KotlinBoolean? = null
    var _inforce: Element? = null
    var benefitPeriod: Period? = null
    var item: List<CoverageEligibilityResponse.Insurance.Item>? = null
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
          coverage = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.coverageSer, null)
        4 -> inforce = decoder.decodeBooleanElement(__desc, 4)
        5 ->
          _inforce = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.inforceSer, null)
        6 ->
          benefitPeriod =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.benefitPeriodSer, null)
        7 -> item = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + __i)
      }
    }
    return CoverageEligibilityResponse.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      coverage = coverage!!,
      inforce = R4Boolean.of(inforce, _inforce),
      benefitPeriod = benefitPeriod,
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.coverage)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.coverageSer, it) }
    ((value.inforce?.value))?.let { encoder.encodeBooleanElement(__desc, 4, it) }
    (value.inforce?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.inforceSer, it)
    }
    (value.benefitPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.benefitPeriodSer, it)
    }
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.itemSer, value.item)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CoverageEligibilityResponse.Insurance.Item {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          category = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.categorySer, null)
        4 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.categorySer, null)
        5 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.modifierSer, null)
        6 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.providerSer, null)
        7 -> excluded = decoder.decodeBooleanElement(__desc, 7)
        8 ->
          _excluded =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.excludedSer, null)
        9 -> name = decoder.decodeStringElement(__desc, 9)
        10 ->
          _name = decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.excludedSer, null)
        11 -> description = decoder.decodeStringElement(__desc, 11)
        12 ->
          _description =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.excludedSer, null)
        13 ->
          network = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.categorySer, null)
        14 ->
          unit = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.categorySer, null)
        15 ->
          term = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.categorySer, null)
        16 ->
          benefit = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.benefitSer, null)
        17 -> authorizationRequired = decoder.decodeBooleanElement(__desc, 17)
        18 ->
          _authorizationRequired =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.excludedSer, null)
        19 ->
          authorizationSupporting =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.modifierSer, null)
        20 -> authorizationUrl = decoder.decodeStringElement(__desc, 20)
        21 ->
          _authorizationUrl =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.excludedSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance.Item,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.categorySer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.categorySer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 5, Hoisted.modifierSer, value.modifier)
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.providerSer, it) }
    ((value.excluded?.value))?.let { encoder.encodeBooleanElement(__desc, 7, it) }
    (value.excluded?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.excludedSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 9, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.excludedSer, it)
    }
    ((value.description?.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
    (value.description?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.excludedSer, it)
    }
    (value.network)?.let { encoder.encodeSerializableElement(__desc, 13, Hoisted.categorySer, it) }
    (value.unit)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.categorySer, it) }
    (value.term)?.let { encoder.encodeSerializableElement(__desc, 15, Hoisted.categorySer, it) }
    if (value.benefit.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.benefitSer, value.benefit)
    ((value.authorizationRequired?.value))?.let { encoder.encodeBooleanElement(__desc, 17, it) }
    (value.authorizationRequired?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.excludedSer, it)
    }
    if (value.authorizationSupporting.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        19,
        Hoisted.modifierSer,
        value.authorizationSupporting,
      )
    ((value.authorizationUrl?.value))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.authorizationUrl?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.excludedSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CoverageEligibilityResponse.Insurance.Item.Benefit {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> allowedUnsignedInt = decoder.decodeIntElement(__desc, 4)
        5 ->
          _allowedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              5,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        6 -> allowedString = decoder.decodeStringElement(__desc, 6)
        7 ->
          _allowedString =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        8 ->
          allowedMoney =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.allowedMoneySer, null)
        9 -> usedUnsignedInt = decoder.decodeIntElement(__desc, 9)
        10 ->
          _usedUnsignedInt =
            decoder.decodeNullableSerializableElement(
              __desc,
              10,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        11 -> usedString = decoder.decodeStringElement(__desc, 11)
        12 ->
          _usedString =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.allowedUnsignedIntSer,
              null,
            )
        13 ->
          usedMoney =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.allowedMoneySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Benefit: " + __i)
      }
    }
    return CoverageEligibilityResponse.Insurance.Item.Benefit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.allowed) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 4, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 5, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.Money -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.allowedMoneySer, __d.value)
      }
    }
    when (val __d = value.used) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.UnsignedInt -> {
        ((__d.value.value))?.let { encoder.encodeIntElement(__desc, 9, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 10, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.String -> {
        ((__d.value.value))?.let { encoder.encodeStringElement(__desc, 11, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 12, Hoisted.allowedUnsignedIntSer, it)
        }
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.Money -> {
        encoder.encodeSerializableElement(__desc, 13, Hoisted.allowedMoneySer, __d.value)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Error) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityResponse.Error {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Error: " + __i)
      }
    }
    return CoverageEligibilityResponse.Error(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CoverageEligibilityResponse.Error) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
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
      element(
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("status", KotlinString.serializer().descriptor, isOptional = true)
      element("_status", Element.serializer().descriptor, isOptional = true)
      element(
        "purpose",
        listSerialDescriptor(KotlinString.serializer().descriptor),
        isOptional = true,
      )
      element("_purpose", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
      element("patient", Reference.serializer().descriptor, isOptional = true)
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
      element("created", KotlinString.serializer().descriptor, isOptional = true)
      element("_created", Element.serializer().descriptor, isOptional = true)
      element("requestor", Reference.serializer().descriptor, isOptional = true)
      element("request", Reference.serializer().descriptor, isOptional = true)
      element("outcome", KotlinString.serializer().descriptor, isOptional = true)
      element("_outcome", Element.serializer().descriptor, isOptional = true)
      element("disposition", KotlinString.serializer().descriptor, isOptional = true)
      element("_disposition", Element.serializer().descriptor, isOptional = true)
      element("insurer", Reference.serializer().descriptor, isOptional = true)
      element(
        "insurance",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityResponse.Insurance.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("preAuthRef", KotlinString.serializer().descriptor, isOptional = true)
      element("_preAuthRef", Element.serializer().descriptor, isOptional = true)
      element("form", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "error",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityResponse.Error.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityResponse {
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
        11 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.identifierSer, null)
        12 -> status = decoder.decodeStringElement(__desc, 12)
        13 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.implicitRulesSer, null)
        14 ->
          purpose = decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.purposeSer, null)
        15 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.purposeSer2, null)
        16 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.patientSer, null)
        17 -> servicedDate = decoder.decodeStringElement(__desc, 17)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.implicitRulesSer, null)
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, null)
        20 -> created = decoder.decodeStringElement(__desc, 20)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.implicitRulesSer, null)
        22 ->
          requestor =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.patientSer, null)
        23 ->
          request = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientSer, null)
        24 -> outcome = decoder.decodeStringElement(__desc, 24)
        25 ->
          _outcome =
            decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.implicitRulesSer, null)
        26 -> disposition = decoder.decodeStringElement(__desc, 26)
        27 ->
          _disposition =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.implicitRulesSer, null)
        28 ->
          insurer = decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.patientSer, null)
        29 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.insuranceSer, null)
        30 -> preAuthRef = decoder.decodeStringElement(__desc, 30)
        31 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 -> form = decoder.decodeNullableSerializableElement(__desc, 32, Hoisted.formSer, null)
        33 -> error = decoder.decodeNullableSerializableElement(__desc, 33, Hoisted.errorSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding CoverageEligibilityResponse: " + __i
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
          CoverageEligibilityResponse.FinancialResourceStatusCodes.fromCode(status!!),
          _status,
        ),
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { __i ->
          Enumeration.of(
            CoverageEligibilityResponse.EligibilityResponsePurpose.fromCode(
              purpose?.getOrNull(__i)!!
            ),
            _purpose?.getOrNull(__i),
          )
        }),
      patient = patient!!,
      serviced =
        CoverageEligibilityResponse.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
          servicedPeriod,
        ),
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      requestor = requestor,
      request = request!!,
      outcome = Enumeration.of(ClaimProcessingCodes.fromCode(outcome!!), _outcome),
      disposition = R4String.of(disposition, _disposition),
      insurer = insurer!!,
      insurance = insurance ?: listOf(),
      preAuthRef = R4String.of(preAuthRef, _preAuthRef),
      form = form,
      error = error ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CoverageEligibilityResponse) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CoverageEligibilityResponse")
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 11, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 12, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.implicitRulesSer, it)
    }
    (value.purpose.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 14, Hoisted.purposeSer, it)
    }
    (value.purpose.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.purposeSer2, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 16, Hoisted.patientSer, it) }
    when (val __d = value.serviced) {
      null -> {}
      is CoverageEligibilityResponse.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 17, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 18, Hoisted.implicitRulesSer, it)
        }
      }
      is CoverageEligibilityResponse.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 19, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 20, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.implicitRulesSer, it)
    }
    (value.requestor)?.let { encoder.encodeSerializableElement(__desc, 22, Hoisted.patientSer, it) }
    (value.request)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.patientSer, it) }
    ((value.outcome.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 24, it) }
    (value.outcome.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 25, Hoisted.implicitRulesSer, it)
    }
    ((value.disposition?.value))?.let { encoder.encodeStringElement(__desc, 26, it) }
    (value.disposition?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 27, Hoisted.implicitRulesSer, it)
    }
    (value.insurer)?.let { encoder.encodeSerializableElement(__desc, 28, Hoisted.patientSer, it) }
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.insuranceSer, value.insurance)
    ((value.preAuthRef?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.preAuthRef?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    (value.form)?.let { encoder.encodeSerializableElement(__desc, 32, Hoisted.formSer, it) }
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 33, Hoisted.errorSer, value.error)
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
