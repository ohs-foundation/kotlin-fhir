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
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("inforce", KotlinBoolean.serializer().descriptor)
      optionalElement("_inforce", ElementSerializer.descriptor)
      optionalElement("benefitPeriod", PeriodSerializer.descriptor)
      optionalElement(
        "item",
        CoverageEligibilityResponseInsuranceItemSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Insurance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var coverage: Reference? = null
      var inforce: KotlinBoolean? = null
      var _inforce: Element? = null
      var benefitPeriod: Period? = null
      var item: List<CoverageEligibilityResponse.Insurance.Item>? = null
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
            coverage = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> inforce = decodeBooleanElement(descriptor, i)
          5 -> _inforce = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            benefitPeriod = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          7 ->
            item =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CoverageEligibilityResponseInsuranceItemSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
        }
      }
      CoverageEligibilityResponse.Insurance(
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.coverage)
      encodeBooleanIfNotNull(descriptor, 4, value.inforce?.value)
      encodeElementIfNotNull(descriptor, 5, value.inforce)
      encodeSerializableIfNotNull(descriptor, 6, PeriodSerializer, value.benefitPeriod)
      if (value.item.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CoverageEligibilityResponseInsuranceItemSerializer.listSerializer,
          value.item,
        )
    }
  }
}

internal object CoverageEligibilityResponseInsuranceItemSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("provider", ReferenceSerializer.descriptor)
      optionalElement("excluded", KotlinBoolean.serializer().descriptor)
      optionalElement("_excluded", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
      optionalElement("description", KotlinString.serializer().descriptor)
      optionalElement("_description", ElementSerializer.descriptor)
      optionalElement("network", CodeableConceptSerializer.descriptor)
      optionalElement("unit", CodeableConceptSerializer.descriptor)
      optionalElement("term", CodeableConceptSerializer.descriptor)
      optionalElement(
        "benefit",
        CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer.descriptor,
      )
      optionalElement("authorizationRequired", KotlinBoolean.serializer().descriptor)
      optionalElement("_authorizationRequired", ElementSerializer.descriptor)
      optionalElement(
        "authorizationSupporting",
        CodeableConceptSerializer.listSerializer.descriptor,
      )
      optionalElement("authorizationUrl", KotlinString.serializer().descriptor)
      optionalElement("_authorizationUrl", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Insurance.Item>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item =
    decoder.decodeStructure(descriptor) {
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
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 ->
            provider = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          7 -> excluded = decodeBooleanElement(descriptor, i)
          8 -> _excluded = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          9 -> name = decodeStringElement(descriptor, i)
          10 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> description = decodeStringElement(descriptor, i)
          12 ->
            _description = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 ->
            network =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          14 ->
            unit = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          15 ->
            term = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          16 ->
            benefit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer,
                null,
              )
          17 -> authorizationRequired = decodeBooleanElement(descriptor, i)
          18 ->
            _authorizationRequired =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          19 ->
            authorizationSupporting =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          20 -> authorizationUrl = decodeStringElement(descriptor, i)
          21 ->
            _authorizationUrl =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      CoverageEligibilityResponse.Insurance.Item(
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Insurance.Item) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.productOrService)
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      encodeSerializableIfNotNull(descriptor, 6, ReferenceSerializer, value.provider)
      encodeBooleanIfNotNull(descriptor, 7, value.excluded?.value)
      encodeElementIfNotNull(descriptor, 8, value.excluded)
      encodeStringIfNotNull(descriptor, 9, value.name?.value)
      encodeElementIfNotNull(descriptor, 10, value.name)
      encodeStringIfNotNull(descriptor, 11, value.description?.value)
      encodeElementIfNotNull(descriptor, 12, value.description)
      encodeSerializableIfNotNull(descriptor, 13, CodeableConceptSerializer, value.network)
      encodeSerializableIfNotNull(descriptor, 14, CodeableConceptSerializer, value.unit)
      encodeSerializableIfNotNull(descriptor, 15, CodeableConceptSerializer, value.term)
      if (value.benefit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          16,
          CoverageEligibilityResponseInsuranceItemBenefitSerializer.listSerializer,
          value.benefit,
        )
      encodeBooleanIfNotNull(descriptor, 17, value.authorizationRequired?.value)
      encodeElementIfNotNull(descriptor, 18, value.authorizationRequired)
      if (value.authorizationSupporting.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          19,
          CodeableConceptSerializer.listSerializer,
          value.authorizationSupporting,
        )
      encodeStringIfNotNull(descriptor, 20, value.authorizationUrl?.value)
      encodeElementIfNotNull(descriptor, 21, value.authorizationUrl)
    }
  }
}

internal object CoverageEligibilityResponseInsuranceItemBenefitSerializer :
  KSerializer<CoverageEligibilityResponse.Insurance.Item.Benefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Benefit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("allowedUnsignedInt", Int.serializer().descriptor)
      optionalElement("_allowedUnsignedInt", ElementSerializer.descriptor)
      optionalElement("allowedString", KotlinString.serializer().descriptor)
      optionalElement("_allowedString", ElementSerializer.descriptor)
      optionalElement("allowedMoney", MoneySerializer.descriptor)
      optionalElement("usedUnsignedInt", Int.serializer().descriptor)
      optionalElement("_usedUnsignedInt", ElementSerializer.descriptor)
      optionalElement("usedString", KotlinString.serializer().descriptor)
      optionalElement("_usedString", ElementSerializer.descriptor)
      optionalElement("usedMoney", MoneySerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<List<CoverageEligibilityResponse.Insurance.Item.Benefit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Insurance.Item.Benefit =
    decoder.decodeStructure(descriptor) {
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
          4 -> allowedUnsignedInt = decodeIntElement(descriptor, i)
          5 ->
            _allowedUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> allowedString = decodeStringElement(descriptor, i)
          7 ->
            _allowedString =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 ->
            allowedMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          9 -> usedUnsignedInt = decodeIntElement(descriptor, i)
          10 ->
            _usedUnsignedInt =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          11 -> usedString = decodeStringElement(descriptor, i)
          12 ->
            _usedString = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          13 -> usedMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
        }
      }
      CoverageEligibilityResponse.Insurance.Item.Benefit(
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

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityResponse.Insurance.Item.Benefit,
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
      when (val choice = value.allowed) {
        null -> {}
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 4, choice.value.value)
          encodeElementIfNotNull(descriptor, 5, choice.value)
        }
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.String -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value)
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.Money -> {
          encodeSerializableElement(descriptor, 8, MoneySerializer, choice.value)
        }
      }
      when (val choice = value.used) {
        null -> {}
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.UnsignedInt -> {
          encodeIntIfNotNull(descriptor, 9, choice.value.value)
          encodeElementIfNotNull(descriptor, 10, choice.value)
        }
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.String -> {
          encodeStringIfNotNull(descriptor, 11, choice.value.value)
          encodeElementIfNotNull(descriptor, 12, choice.value)
        }
        is CoverageEligibilityResponse.Insurance.Item.Benefit.Used.Money -> {
          encodeSerializableElement(descriptor, 13, MoneySerializer, choice.value)
        }
      }
    }
  }
}

internal object CoverageEligibilityResponseErrorSerializer :
  KSerializer<CoverageEligibilityResponse.Error> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Error") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityResponse.Error>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityResponse.Error =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Error: " + i)
        }
      }
      CoverageEligibilityResponse.Error(
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

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityResponse.Error) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    }
  }
}

internal object CoverageEligibilityResponseSerializer :
  FhirResourceSerializer<CoverageEligibilityResponse> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CoverageEligibilityResponse")

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
    b.optionalElement("status", KotlinString.serializer().descriptor)
    b.optionalElement("_status", ElementSerializer.descriptor)
    b.optionalElement("purpose", stringNullableListSerializer.descriptor)
    b.optionalElement("_purpose", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("servicedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_servicedDate", ElementSerializer.descriptor)
    b.optionalElement("servicedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("requestor", ReferenceSerializer.descriptor)
    b.optionalElement("request", ReferenceSerializer.descriptor)
    b.optionalElement("outcome", KotlinString.serializer().descriptor)
    b.optionalElement("_outcome", ElementSerializer.descriptor)
    b.optionalElement("disposition", KotlinString.serializer().descriptor)
    b.optionalElement("_disposition", ElementSerializer.descriptor)
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
    b.optionalElement(
      "insurance",
      CoverageEligibilityResponseInsuranceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("preAuthRef", KotlinString.serializer().descriptor)
    b.optionalElement("_preAuthRef", ElementSerializer.descriptor)
    b.optionalElement("form", CodeableConceptSerializer.descriptor)
    b.optionalElement("error", CoverageEligibilityResponseErrorSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
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
        11 -> status = decoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        13 ->
          purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        14 ->
          _purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        15 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        16 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        17 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        18 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        19 -> created = decoder.decodeStringElement(descriptor, i)
        20 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        21 ->
          requestor =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        22 ->
          request =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 -> outcome = decoder.decodeStringElement(descriptor, i)
        24 ->
          _outcome =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        25 -> disposition = decoder.decodeStringElement(descriptor, i)
        26 ->
          _disposition =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        27 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        28 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseInsuranceSerializer.listSerializer,
              null,
            )
        29 -> preAuthRef = decoder.decodeStringElement(descriptor, i)
        30 ->
          _preAuthRef =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          form =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        32 ->
          error =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityResponseErrorSerializer.listSerializer,
              null,
            )
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
          if (status != null)
            CoverageEligibilityResponse.FinancialResourceStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on CoverageEligibilityResponse"
          ),
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { index ->
          Enumeration.of(
            purpose?.getOrNull(index)?.let {
              CoverageEligibilityResponse.EligibilityResponsePurpose.fromCode(it)
            },
            _purpose?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'purpose' on CoverageEligibilityResponse has neither a value nor an id/extension"
            )
        }),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on CoverageEligibilityResponse"
          ),
      serviced =
        CoverageEligibilityResponse.Serviced.from(
          Date.of(
            if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
            _servicedDate,
          ),
          servicedPeriod,
        ),
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
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
          if (outcome != null) ClaimProcessingCodes.fromCode(outcome) else null,
          _outcome,
        )
          ?: throw SerializationException(
            "Missing required property 'outcome' on CoverageEligibilityResponse"
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

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CoverageEligibilityResponse,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.purpose.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        13 + descriptorOffset,
        stringNullableListSerializer,
        value.purpose.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 14 + descriptorOffset, value.purpose)
    }
    encoder.encodeSerializableElement(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    when (val choice = value.serviced) {
      null -> {}
      is CoverageEligibilityResponse.Serviced.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          16 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, choice.value)
      }
      is CoverageEligibilityResponse.Serviced.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          18 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      ReferenceSerializer,
      value.requestor,
    )
    encoder.encodeSerializableElement(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.request,
    )
    encoder.encodeStringIfNotNull(descriptor, 23 + descriptorOffset, value.outcome.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 24 + descriptorOffset, value.outcome)
    encoder.encodeStringIfNotNull(descriptor, 25 + descriptorOffset, value.disposition?.value)
    encoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.disposition)
    encoder.encodeSerializableElement(
      descriptor,
      27 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CoverageEligibilityResponseInsuranceSerializer.listSerializer,
        value.insurance,
      )
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.preAuthRef?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.preAuthRef)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      31 + descriptorOffset,
      CodeableConceptSerializer,
      value.form,
    )
    if (value.error.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        CoverageEligibilityResponseErrorSerializer.listSerializer,
        value.error,
      )
  }
}
