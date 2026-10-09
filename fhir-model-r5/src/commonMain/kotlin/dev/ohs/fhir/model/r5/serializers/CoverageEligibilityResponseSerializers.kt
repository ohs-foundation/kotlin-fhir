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

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.CoverageEligibilityResponse
import dev.ohs.fhir.model.r5.Date
import dev.ohs.fhir.model.r5.DateTime
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirDate
import dev.ohs.fhir.model.r5.FhirDateTime
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.UnsignedInt
import dev.ohs.fhir.model.r5.Uri
import dev.ohs.fhir.model.r5.terminologies.EligibilityOutcome
import dev.ohs.fhir.model.r5.terminologies.EligibilityResponsePurpose
import dev.ohs.fhir.model.r5.terminologies.FinancialResourceStatusCodes
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object CoverageEligibilityResponseEventSerializer :
  FhirSerializer<CoverageEligibilityResponse.Event> {
  override val descriptor: SerialDescriptor = buildDescriptor("Event", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Event>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.strPrim("whenDateTime")
    b.optionalElement("whenPeriod", PeriodSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Event {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var whenDateTime: FhirDateTime? = null
    var _whenDateTime: Element? = null
    var whenPeriod: Period? = null
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
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          whenDateTime =
            FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        5 ->
          _whenDateTime =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          whenPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CoverageEligibilityResponse.Event(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "CoverageEligibilityResponse.Event", "type"),
      `when` =
        required(
          CoverageEligibilityResponse.Event.When.from(
            DateTime.of(whenDateTime, _whenDateTime),
            whenPeriod,
          ),
          "CoverageEligibilityResponse.Event",
          "when",
        ),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Event) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.`when`) {
      is CoverageEligibilityResponse.Event.When.DateTime -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 4, choice.value.value?.toString())
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is CoverageEligibilityResponse.Event.When.Period -> {
        compositeEncoder.encodeSerializableElement(descriptor, 6, PeriodSerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageEligibilityResponseInsuranceSerializer :
  FhirSerializer<CoverageEligibilityResponse.Insurance> {
  override val descriptor: SerialDescriptor = buildDescriptor("Insurance", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Insurance>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("coverage", ReferenceSerializer.descriptor)
    b.boolPrim("inforce")
    b.optionalElement("benefitPeriod", PeriodSerializer.descriptor)
    b.optionalElement(
      "item",
      CoverageEligibilityResponseInsuranceItemSerializer.listSerializer.descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var coverage: Reference? = null
    var inforce: KotlinBoolean? = null
    var _inforce: Element? = null
    var benefitPeriod: Period? = null
    var item: List<CoverageEligibilityResponse.Insurance.Item>? = null
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
        3 ->
          coverage =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        4 -> inforce = compositeDecoder.decodeBooleanElement(descriptor, i)
        5 ->
          _inforce =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 ->
          benefitPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        7 ->
          item =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseInsuranceItemSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CoverageEligibilityResponse.Insurance(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      coverage = required(coverage, "CoverageEligibilityResponse.Insurance", "coverage"),
      inforce = R5Boolean.of(inforce, _inforce),
      benefitPeriod = benefitPeriod,
      item = listOrEmpty(item),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.coverage)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 4, value.inforce?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.inforce)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      PeriodSerializer,
      value.benefitPeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7,
      CoverageEligibilityResponseInsuranceItemSerializer.listSerializer,
      value.item,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageEligibilityResponseInsuranceItemSerializer :
  FhirSerializer<CoverageEligibilityResponse.Insurance.Item> {
  override val descriptor: SerialDescriptor = buildDescriptor("Item", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Insurance.Item>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("category", CodeableConceptSerializer.descriptor)
    b.optionalElement("productOrService", CodeableConceptSerializer.descriptor)
    b.optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("provider", ReferenceSerializer.descriptor)
    b.boolPrim("excluded")
    b.strPrim("name")
    b.strPrim("description")
    b.optionalElement("network", CodeableConceptSerializer.descriptor)
    b.optionalElement("unit", CodeableConceptSerializer.descriptor)
    b.optionalElement("term", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "benefit",
      CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer.descriptor,
    )
    b.boolPrim("authorizationRequired")
    b.optionalElement(
      "authorizationSupporting",
      CodeableConceptSerializer.listSerializer.descriptor,
    )
    b.strPrim("authorizationUrl")
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 ->
          category =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          productOrService =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        5 ->
          modifier =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        6 ->
          provider =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        7 -> excluded = compositeDecoder.decodeBooleanElement(descriptor, i)
        8 ->
          _excluded =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        9 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        10 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> description = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _description =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          network =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          unit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          term =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          benefit =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer,
              null,
            )
        17 -> authorizationRequired = compositeDecoder.decodeBooleanElement(descriptor, i)
        18 ->
          _authorizationRequired =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          authorizationSupporting =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        20 -> authorizationUrl = compositeDecoder.decodeStringElement(descriptor, i)
        21 ->
          _authorizationUrl =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CoverageEligibilityResponse.Insurance.Item(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      category = category,
      productOrService = productOrService,
      modifier = listOrEmpty(modifier),
      provider = provider,
      excluded = R5Boolean.of(excluded, _excluded),
      name = R5String.of(name, _name),
      description = R5String.of(description, _description),
      network = network,
      unit = unit,
      term = term,
      benefit = listOrEmpty(benefit),
      authorizationRequired = R5Boolean.of(authorizationRequired, _authorizationRequired),
      authorizationSupporting = listOrEmpty(authorizationSupporting),
      authorizationUrl = Uri.of(authorizationUrl, _authorizationUrl),
    )
  }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance.Item) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.category,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.productOrService,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      5,
      CodeableConceptSerializer.listSerializer,
      value.modifier,
    )
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.provider)
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 7, value.excluded?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 8, value.excluded)
    compositeEncoder.encodeStringIfNotNull(descriptor, 9, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 10, value.name)
    compositeEncoder.encodeStringIfNotNull(descriptor, 11, value.description?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 12, value.description)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13,
      CodeableConceptSerializer,
      value.network,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14,
      CodeableConceptSerializer,
      value.unit,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15,
      CodeableConceptSerializer,
      value.term,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16,
      CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer,
      value.benefit,
    )
    compositeEncoder.encodeBooleanIfNotNull(descriptor, 17, value.authorizationRequired?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 18, value.authorizationRequired)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      19,
      CodeableConceptSerializer.listSerializer,
      value.authorizationSupporting,
    )
    compositeEncoder.encodeStringIfNotNull(descriptor, 20, value.authorizationUrl?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 21, value.authorizationUrl)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageEligibilityResponseInsuranceItemBenefitSerializer :
  FhirSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit> {
  override val descriptor: SerialDescriptor = buildDescriptor("Benefit", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<CoverageEligibilityResponse.Insurance.Item.Benefit>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.intPrim("allowedUnsignedInt")
    b.strPrim("allowedString")
    b.optionalElement("allowedMoney", MoneySerializer.descriptor)
    b.intPrim("usedUnsignedInt")
    b.strPrim("usedString")
    b.optionalElement("usedMoney", MoneySerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item.Benefit {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
        3 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 -> allowedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        5 ->
          _allowedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> allowedString = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _allowedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        8 ->
          allowedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        9 -> usedUnsignedInt = compositeDecoder.decodeIntElement(descriptor, i)
        10 ->
          _usedUnsignedInt =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        11 -> usedString = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _usedString =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          usedMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return CoverageEligibilityResponse.Insurance.Item.Benefit(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      type = required(type, "CoverageEligibilityResponse.Insurance.Item.Benefit", "type"),
      allowed =
        CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.from(
          UnsignedInt.of(allowedUnsignedInt, _allowedUnsignedInt),
          R5String.of(allowedString, _allowedString),
          allowedMoney,
        ),
      used =
        CoverageEligibilityResponse.Insurance.Item.Benefit.Used.from(
          UnsignedInt.of(usedUnsignedInt, _usedUnsignedInt),
          R5String.of(usedString, _usedString),
          usedMoney,
        ),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    when (val choice = value.allowed) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 4, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 5, choice.value)
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 6, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 7, choice.value)
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 8, MoneySerializer, choice.value)
      }
    }
    when (val choice = value.used) {
      null -> {}
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.UnsignedInt -> {
        compositeEncoder.encodeIntIfNotNull(descriptor, 9, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 10, choice.value)
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.String -> {
        compositeEncoder.encodeStringIfNotNull(descriptor, 11, choice.value.value)
        compositeEncoder.encodeElementIfNotNull(descriptor, 12, choice.value)
      }
      is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 13, MoneySerializer, choice.value)
      }
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageEligibilityResponseErrorSerializer :
  FhirSerializer<CoverageEligibilityResponse.Error> {
  override val descriptor: SerialDescriptor = buildDescriptor("Error", this)

  @JvmField
  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Error>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.strPrimList("expression")
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Error {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var expression: List<KotlinString?>? = null
    var _expression: List<Element?>? = null
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
        3 ->
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        5 ->
          _expression =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    val expression_ =
      List(maxSize(expression, _expression)) { index ->
        entryRequired(
          R5String.of(at(expression, index), at(_expression, index)),
          "CoverageEligibilityResponse.Error",
          "expression",
        )
      }
    return CoverageEligibilityResponse.Error(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "CoverageEligibilityResponse.Error", "code"),
      expression = expression_,
    )
  }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Error) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    if (!value.expression.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        4,
        stringNullableListSerializer,
        value.expression.map { it.value },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 5, value.expression)
    }
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageEligibilityResponseSerializer :
  FhirResourceSerializer<CoverageEligibilityResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CoverageEligibilityResponse")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.strPrim("status")
    b.strPrimList("purpose")
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("event", CoverageEligibilityResponseEventSerializer.listSerializer.descriptor)
    b.strPrim("servicedDate")
    b.optionalElement("servicedPeriod", PeriodSerializer.descriptor)
    b.strPrim("created")
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.strPrim("outcome")
    b.strPrim("disposition")
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
    b.optionalElement(
      "insurance",
      CoverageEligibilityResponseInsuranceSerializer.listSerializer.descriptor,
    )
    b.strPrim("preAuthRef")
    b.optionalElement("form", CodeableConceptSerializer.descriptor)
    b.optionalElement("error", CoverageEligibilityResponseErrorSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
    var status: FinancialResourceStatusCodes? = null
    var _status: Element? = null
    var purpose: List<KotlinString?>? = null
    var _purpose: List<Element?>? = null
    var patient: Reference? = null
    var event: List<CoverageEligibilityResponse.Event>? = null
    var servicedDate: FhirDate? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var created: FhirDateTime? = null
    var _created: Element? = null
    var requestor: Reference? = null
    var request: Reference? = null
    var outcome: EligibilityOutcome? = null
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
              IdentifierSerializer.listSerializer,
              null,
            )
        11 ->
          status =
            FinancialResourceStatusCodes.fromCode(
              compositeDecoder.decodeStringElement(descriptor, i)
            )
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _purpose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          patient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 ->
          event =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseEventSerializer.listSerializer,
              null,
            )
        17 ->
          servicedDate = FhirDate.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        18 ->
          _servicedDate =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        19 ->
          servicedPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        20 -> created = FhirDateTime.fromString(compositeDecoder.decodeStringElement(descriptor, i))
        21 ->
          _created =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        22 ->
          requestor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        23 ->
          request =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        24 ->
          outcome = EligibilityOutcome.fromCode(compositeDecoder.decodeStringElement(descriptor, i))
        25 ->
          _outcome =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        26 -> disposition = compositeDecoder.decodeStringElement(descriptor, i)
        27 ->
          _disposition =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        28 ->
          insurer =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        29 ->
          insurance =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseInsuranceSerializer.listSerializer,
              null,
            )
        30 -> preAuthRef = compositeDecoder.decodeStringElement(descriptor, i)
        31 ->
          _preAuthRef =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          form =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        33 ->
          error =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseErrorSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    val purpose_ =
      List(maxSize(purpose, _purpose)) { index ->
        entryRequired(
          Enumeration.of(
            at(purpose, index)?.let { EligibilityResponsePurpose.fromCode(it) },
            at(_purpose, index),
          ),
          "CoverageEligibilityResponse",
          "purpose",
        )
      }
    return CoverageEligibilityResponse(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      status = required(Enumeration.of(status, _status), "CoverageEligibilityResponse", "status"),
      purpose = purpose_,
      patient = required(patient, "CoverageEligibilityResponse", "patient"),
      event = listOrEmpty(event),
      serviced =
        CoverageEligibilityResponse.Serviced.from(
          Date.of(servicedDate, _servicedDate),
          servicedPeriod,
        ),
      created = required(DateTime.of(created, _created), "CoverageEligibilityResponse", "created"),
      requestor = requestor,
      request = required(request, "CoverageEligibilityResponse", "request"),
      outcome =
        required(Enumeration.of(outcome, _outcome), "CoverageEligibilityResponse", "outcome"),
      disposition = R5String.of(disposition, _disposition),
      insurer = required(insurer, "CoverageEligibilityResponse", "insurer"),
      insurance = listOrEmpty(insurance),
      preAuthRef = R5String.of(preAuthRef, _preAuthRef),
      form = form,
      error = listOrEmpty(error),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CoverageEligibilityResponse,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      11 + descriptorOffset,
      value.status.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (!value.purpose.isEmpty()) {
      compositeEncoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.purpose.map { it.value?.code },
      )
      compositeEncoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.purpose)
    }
    compositeEncoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      CoverageEligibilityResponseEventSerializer.listSerializer,
      value.event,
    )
    when (val choice = value.serviced) {
      null -> {}
      is CoverageEligibilityResponse.Serviced.Date -> {
        compositeEncoder.encodeStringIfNotNull(
          descriptor,
          17 + descriptorOffset,
          choice.value.value?.toString(),
        )
        compositeEncoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, choice.value)
      }
      is CoverageEligibilityResponse.Serviced.Period -> {
        compositeEncoder.encodeSerializableElement(
          descriptor,
          19 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.created.value?.toString(),
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.created)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      24 + descriptorOffset,
      value.outcome.value?.code,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 25 + descriptorOffset, value.outcome)
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      26 + descriptorOffset,
      value.disposition?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 27 + descriptorOffset, value.disposition)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      28 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      29 + descriptorOffset,
      CoverageEligibilityResponseInsuranceSerializer.listSerializer,
      value.insurance,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.preAuthRef?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.preAuthRef)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      32 + descriptorOffset,
      CodeableConceptSerializer,
      value.form,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      33 + descriptorOffset,
      CoverageEligibilityResponseErrorSerializer.listSerializer,
      value.error,
    )
  }
}
