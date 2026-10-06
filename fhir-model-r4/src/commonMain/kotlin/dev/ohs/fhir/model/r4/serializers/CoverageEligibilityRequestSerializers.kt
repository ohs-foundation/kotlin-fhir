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
import dev.ohs.fhir.model.r4.CoverageEligibilityRequest
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
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
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

internal object CoverageEligibilityRequestSupportingInfoSerializer :
  KSerializer<CoverageEligibilityRequest.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("sequence", Int.serializer().descriptor)
      optionalElement("_sequence", ElementSerializer.descriptor)
      optionalElement("information", ReferenceSerializer.descriptor)
      optionalElement("appliesToAll", KotlinBoolean.serializer().descriptor)
      optionalElement("_appliesToAll", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityRequest.SupportingInfo>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.SupportingInfo =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var sequence: Int? = null
      var _sequence: Element? = null
      var information: Reference? = null
      var appliesToAll: KotlinBoolean? = null
      var _appliesToAll: Element? = null
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
          3 -> sequence = decodeIntElement(descriptor, i)
          4 -> _sequence = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            information =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> appliesToAll = decodeBooleanElement(descriptor, i)
          7 ->
            _appliesToAll =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
        }
      }
      CoverageEligibilityRequest.SupportingInfo(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        sequence =
          PositiveInt.of(sequence, _sequence)
            ?: throw SerializationException(
              "Missing required property 'sequence' on CoverageEligibilityRequest.SupportingInfo"
            ),
        information =
          information
            ?: throw SerializationException(
              "Missing required property 'information' on CoverageEligibilityRequest.SupportingInfo"
            ),
        appliesToAll = R4Boolean.of(appliesToAll, _appliesToAll),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.SupportingInfo) {
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
      encodeIntIfNotNull(descriptor, 3, value.sequence.value)
      encodeElementIfNotNull(descriptor, 4, value.sequence)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.information)
      encodeBooleanIfNotNull(descriptor, 6, value.appliesToAll?.value)
      encodeElementIfNotNull(descriptor, 7, value.appliesToAll)
    }
  }
}

internal object CoverageEligibilityRequestInsuranceSerializer :
  KSerializer<CoverageEligibilityRequest.Insurance> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Insurance") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("focal", KotlinBoolean.serializer().descriptor)
      optionalElement("_focal", ElementSerializer.descriptor)
      optionalElement("coverage", ReferenceSerializer.descriptor)
      optionalElement("businessArrangement", KotlinString.serializer().descriptor)
      optionalElement("_businessArrangement", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityRequest.Insurance>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Insurance =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var focal: KotlinBoolean? = null
      var _focal: Element? = null
      var coverage: Reference? = null
      var businessArrangement: KotlinString? = null
      var _businessArrangement: Element? = null
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
          3 -> focal = decodeBooleanElement(descriptor, i)
          4 -> _focal = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          5 ->
            coverage = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          6 -> businessArrangement = decodeStringElement(descriptor, i)
          7 ->
            _businessArrangement =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
        }
      }
      CoverageEligibilityRequest.Insurance(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        focal = R4Boolean.of(focal, _focal),
        coverage =
          coverage
            ?: throw SerializationException(
              "Missing required property 'coverage' on CoverageEligibilityRequest.Insurance"
            ),
        businessArrangement = R4String.of(businessArrangement, _businessArrangement),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Insurance) {
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
      encodeBooleanIfNotNull(descriptor, 3, value.focal?.value)
      encodeElementIfNotNull(descriptor, 4, value.focal)
      encodeSerializableElement(descriptor, 5, ReferenceSerializer, value.coverage)
      encodeStringIfNotNull(descriptor, 6, value.businessArrangement?.value)
      encodeElementIfNotNull(descriptor, 7, value.businessArrangement)
    }
  }
}

internal object CoverageEligibilityRequestItemSerializer :
  KSerializer<CoverageEligibilityRequest.Item> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Item") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("supportingInfoSequence", intNullableListSerializer.descriptor)
      optionalElement(
        "_supportingInfoSequence",
        ElementSerializer.nullableListSerializer.descriptor,
      )
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("productOrService", CodeableConceptSerializer.descriptor)
      optionalElement("modifier", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("provider", ReferenceSerializer.descriptor)
      optionalElement("quantity", QuantitySerializer.descriptor)
      optionalElement("unitPrice", MoneySerializer.descriptor)
      optionalElement("facility", ReferenceSerializer.descriptor)
      optionalElement(
        "diagnosis",
        CoverageEligibilityRequestItemDiagnosisSerializer.listSerializer.descriptor,
      )
      optionalElement("detail", ReferenceSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityRequest.Item>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var supportingInfoSequence: List<Int?>? = null
      var _supportingInfoSequence: List<Element?>? = null
      var category: CodeableConcept? = null
      var productOrService: CodeableConcept? = null
      var modifier: List<CodeableConcept>? = null
      var provider: Reference? = null
      var quantity: Quantity? = null
      var unitPrice: Money? = null
      var facility: Reference? = null
      var diagnosis: List<CoverageEligibilityRequest.Item.Diagnosis>? = null
      var detail: List<Reference>? = null
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
            supportingInfoSequence =
              decodeNullableSerializableElement(descriptor, i, intNullableListSerializer, null)
          4 ->
            _supportingInfoSequence =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ElementSerializer.nullableListSerializer,
                null,
              )
          5 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            productOrService =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            modifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          8 ->
            provider = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          9 -> quantity = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          10 -> unitPrice = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          11 ->
            facility = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          12 ->
            diagnosis =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CoverageEligibilityRequestItemDiagnosisSerializer.listSerializer,
                null,
              )
          13 ->
            detail =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Item: " + i)
        }
      }
      CoverageEligibilityRequest.Item(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        supportingInfoSequence =
          (kotlin.collections.List(
            maxOf(supportingInfoSequence?.size ?: 0, _supportingInfoSequence?.size ?: 0)
          ) { index ->
            PositiveInt.of(
              supportingInfoSequence?.getOrNull(index),
              _supportingInfoSequence?.getOrNull(index),
            )
              ?: throw SerializationException(
                "An entry of 'supportingInfoSequence' on CoverageEligibilityRequest.Item has neither a value nor an id/extension"
              )
          }),
        category = category,
        productOrService = productOrService,
        modifier = modifier ?: listOf(),
        provider = provider,
        quantity = quantity,
        unitPrice = unitPrice,
        facility = facility,
        diagnosis = diagnosis ?: listOf(),
        detail = detail ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item) {
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
      if (value.supportingInfoSequence.isNotEmpty()) {
        encodeNullableListIfNotNull(
          descriptor,
          3,
          intNullableListSerializer,
          value.supportingInfoSequence.map { it.value },
        )
        encodePrimitiveElementList(descriptor, 4, value.supportingInfoSequence)
      }
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.productOrService)
      if (value.modifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          CodeableConceptSerializer.listSerializer,
          value.modifier,
        )
      encodeSerializableIfNotNull(descriptor, 8, ReferenceSerializer, value.provider)
      encodeSerializableIfNotNull(descriptor, 9, QuantitySerializer, value.quantity)
      encodeSerializableIfNotNull(descriptor, 10, MoneySerializer, value.unitPrice)
      encodeSerializableIfNotNull(descriptor, 11, ReferenceSerializer, value.facility)
      if (value.diagnosis.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          12,
          CoverageEligibilityRequestItemDiagnosisSerializer.listSerializer,
          value.diagnosis,
        )
      if (value.detail.isNotEmpty())
        encodeSerializableElement(descriptor, 13, ReferenceSerializer.listSerializer, value.detail)
    }
  }
}

internal object CoverageEligibilityRequestItemDiagnosisSerializer :
  KSerializer<CoverageEligibilityRequest.Item.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("diagnosisCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("diagnosisReference", ReferenceSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<CoverageEligibilityRequest.Item.Diagnosis>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item.Diagnosis =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var diagnosisCodeableConcept: CodeableConcept? = null
      var diagnosisReference: Reference? = null
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
            diagnosisCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            diagnosisReference =
              decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
        }
      }
      CoverageEligibilityRequest.Item.Diagnosis(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        diagnosis =
          CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.from(
            diagnosisCodeableConcept,
            diagnosisReference,
          ),
      )
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item.Diagnosis) {
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
      when (val choice = value.diagnosis) {
        null -> {}
        is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.CodeableConcept -> {
          encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, choice.value)
        }
        is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.Reference -> {
          encodeSerializableElement(descriptor, 4, ReferenceSerializer, choice.value)
        }
      }
    }
  }
}

internal object CoverageEligibilityRequestSerializer :
  FhirResourceSerializer<CoverageEligibilityRequest> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("CoverageEligibilityRequest")

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
    b.optionalElement("priority", CodeableConceptSerializer.descriptor)
    b.optionalElement("purpose", stringNullableListSerializer.descriptor)
    b.optionalElement("_purpose", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("patient", ReferenceSerializer.descriptor)
    b.optionalElement("servicedDate", KotlinString.serializer().descriptor)
    b.optionalElement("_servicedDate", ElementSerializer.descriptor)
    b.optionalElement("servicedPeriod", PeriodSerializer.descriptor)
    b.optionalElement("created", KotlinString.serializer().descriptor)
    b.optionalElement("_created", ElementSerializer.descriptor)
    b.optionalElement("enterer", ReferenceSerializer.descriptor)
    b.optionalElement("provider", ReferenceSerializer.descriptor)
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
    b.optionalElement("facility", ReferenceSerializer.descriptor)
    b.optionalElement(
      "supportingInfo",
      CoverageEligibilityRequestSupportingInfoSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "insurance",
      CoverageEligibilityRequestInsuranceSerializer.listSerializer.descriptor,
    )
    b.optionalElement("item", CoverageEligibilityRequestItemSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): CoverageEligibilityRequest {
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
    var priority: CodeableConcept? = null
    var purpose: List<KotlinString?>? = null
    var _purpose: List<Element?>? = null
    var patient: Reference? = null
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    var created: KotlinString? = null
    var _created: Element? = null
    var enterer: Reference? = null
    var provider: Reference? = null
    var insurer: Reference? = null
    var facility: Reference? = null
    var supportingInfo: List<CoverageEligibilityRequest.SupportingInfo>? = null
    var insurance: List<CoverageEligibilityRequest.Insurance>? = null
    var item: List<CoverageEligibilityRequest.Item>? = null
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
          priority =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        15 ->
          _purpose =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        16 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        17 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        20 -> created = decoder.decodeStringElement(descriptor, i)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        22 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        23 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        24 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        25 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityRequestSupportingInfoSerializer.listSerializer,
              null,
            )
        27 ->
          insurance =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityRequestInsuranceSerializer.listSerializer,
              null,
            )
        28 ->
          item =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageEligibilityRequestItemSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException("Unexpected index decoding CoverageEligibilityRequest: " + i)
      }
    }
    return CoverageEligibilityRequest(
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
            CoverageEligibilityRequest.FinancialResourceStatusCodes.fromCode(status)
          else null,
          _status,
        )
          ?: throw SerializationException(
            "Missing required property 'status' on CoverageEligibilityRequest"
          ),
      priority = priority,
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { index ->
          Enumeration.of(
            purpose?.getOrNull(index)?.let {
              CoverageEligibilityRequest.EligibilityRequestPurpose.fromCode(it)
            },
            _purpose?.getOrNull(index),
          )
            ?: throw SerializationException(
              "An entry of 'purpose' on CoverageEligibilityRequest has neither a value nor an id/extension"
            )
        }),
      patient =
        patient
          ?: throw SerializationException(
            "Missing required property 'patient' on CoverageEligibilityRequest"
          ),
      serviced =
        CoverageEligibilityRequest.Serviced.from(
          Date.of(
            if (servicedDate != null) FhirDate.fromString(servicedDate) else null,
            _servicedDate,
          ),
          servicedPeriod,
        ),
      created =
        DateTime.of(if (created != null) FhirDateTime.fromString(created) else null, _created)
          ?: throw SerializationException(
            "Missing required property 'created' on CoverageEligibilityRequest"
          ),
      enterer = enterer,
      provider = provider,
      insurer =
        insurer
          ?: throw SerializationException(
            "Missing required property 'insurer' on CoverageEligibilityRequest"
          ),
      facility = facility,
      supportingInfo = supportingInfo ?: listOf(),
      insurance = insurance ?: listOf(),
      item = item ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CoverageEligibilityRequest,
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
    encoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.priority,
    )
    if (value.purpose.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        14 + descriptorOffset,
        stringNullableListSerializer,
        value.purpose.map { it.value?.code },
      )
      encoder.encodePrimitiveElementList(descriptor, 15 + descriptorOffset, value.purpose)
    }
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      ReferenceSerializer,
      value.patient,
    )
    when (val choice = value.serviced) {
      null -> {}
      is CoverageEligibilityRequest.Serviced.Date -> {
        encoder.encodeStringIfNotNull(
          descriptor,
          17 + descriptorOffset,
          choice.value.value?.toString(),
        )
        encoder.encodeElementIfNotNull(descriptor, 18 + descriptorOffset, choice.value)
      }
      is CoverageEligibilityRequest.Serviced.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          19 + descriptorOffset,
          PeriodSerializer,
          choice.value,
        )
      }
    }
    encoder.encodeStringIfNotNull(
      descriptor,
      20 + descriptorOffset,
      value.created.value?.toString(),
    )
    encoder.encodeElementIfNotNull(descriptor, 21 + descriptorOffset, value.created)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      ReferenceSerializer,
      value.enterer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      ReferenceSerializer,
      value.provider,
    )
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.facility,
    )
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CoverageEligibilityRequestSupportingInfoSerializer.listSerializer,
        value.supportingInfo,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        CoverageEligibilityRequestInsuranceSerializer.listSerializer,
        value.insurance,
      )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        CoverageEligibilityRequestItemSerializer.listSerializer,
        value.item,
      )
  }
}
