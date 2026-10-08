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
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Coverage
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.FinancialResourceStatusCodes
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

internal object CoverageClassSerializer : KSerializer<Coverage.Class> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Class") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("value", KotlinString.serializer().descriptor)
      optionalElement("_value", ElementSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Coverage.Class>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.Class {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        4 -> `value` = compositeDecoder.decodeStringElement(descriptor, i)
        5 ->
          _value =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        6 -> name = compositeDecoder.decodeStringElement(descriptor, i)
        7 ->
          _name =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Class: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Coverage.Class(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type ?: throw SerializationException("Missing required property 'type' on Coverage.Class"),
      `value` =
        R4bString.of(`value`, _value)
          ?: throw SerializationException("Missing required property 'value' on Coverage.Class"),
      name = R4bString.of(name, _name),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Coverage.Class) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeStringIfNotNull(descriptor, 4, value.`value`.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 5, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 6, value.name?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 7, value.name)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageCostToBeneficiarySerializer : KSerializer<Coverage.CostToBeneficiary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CostToBeneficiary") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueMoney", MoneySerializer.descriptor)
      optionalElement(
        "exception",
        CoverageCostToBeneficiaryExceptionSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Coverage.CostToBeneficiary>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueMoney: Money? = null
    var exception: List<Coverage.CostToBeneficiary.Exception>? = null
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
          valueQuantity =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          valueMoney =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
        6 ->
          exception =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageCostToBeneficiaryExceptionSerializer.listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CostToBeneficiary: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Coverage.CostToBeneficiary(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      `value` =
        Coverage.CostToBeneficiary.Value.from(valueQuantity, valueMoney)
          ?: throw SerializationException(
            "Missing required property 'value' on Coverage.CostToBeneficiary"
          ),
      exception = exception ?: listOf(),
    )
  }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.type,
    )
    when (val choice = value.`value`) {
      is Coverage.CostToBeneficiary.Value.Quantity -> {
        compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, choice.value)
      }
      is Coverage.CostToBeneficiary.Value.Money -> {
        compositeEncoder.encodeSerializableElement(descriptor, 5, MoneySerializer, choice.value)
      }
    }
    if (value.exception.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        6,
        CoverageCostToBeneficiaryExceptionSerializer.listSerializer,
        value.exception,
      )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageCostToBeneficiaryExceptionSerializer :
  KSerializer<Coverage.CostToBeneficiary.Exception> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Exception") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("period", PeriodSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Coverage.CostToBeneficiary.Exception>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Exception {
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var period: Period? = null
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
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Exception: " + i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return Coverage.CostToBeneficiary.Exception(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type =
        type
          ?: throw SerializationException(
            "Missing required property 'type' on Coverage.CostToBeneficiary.Exception"
          ),
      period = period,
    )
  }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Exception) {
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        1,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        2,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.type)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object CoverageSerializer : FhirResourceSerializer<Coverage> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("Coverage")

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
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("policyHolder", ReferenceSerializer.descriptor)
    b.optionalElement("subscriber", ReferenceSerializer.descriptor)
    b.optionalElement("subscriberId", KotlinString.serializer().descriptor)
    b.optionalElement("_subscriberId", ElementSerializer.descriptor)
    b.optionalElement("beneficiary", ReferenceSerializer.descriptor)
    b.optionalElement("dependent", KotlinString.serializer().descriptor)
    b.optionalElement("_dependent", ElementSerializer.descriptor)
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("payor", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("class", CoverageClassSerializer.listSerializer.descriptor)
    b.optionalElement("order", Int.serializer().descriptor)
    b.optionalElement("_order", ElementSerializer.descriptor)
    b.optionalElement("network", KotlinString.serializer().descriptor)
    b.optionalElement("_network", ElementSerializer.descriptor)
    b.optionalElement(
      "costToBeneficiary",
      CoverageCostToBeneficiarySerializer.listSerializer.descriptor,
    )
    b.optionalElement("subrogation", KotlinBoolean.serializer().descriptor)
    b.optionalElement("_subrogation", ElementSerializer.descriptor)
    b.optionalElement("contract", ReferenceSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): Coverage {
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
    var type: CodeableConcept? = null
    var policyHolder: Reference? = null
    var subscriber: Reference? = null
    var subscriberId: KotlinString? = null
    var _subscriberId: Element? = null
    var beneficiary: Reference? = null
    var dependent: KotlinString? = null
    var _dependent: Element? = null
    var relationship: CodeableConcept? = null
    var period: Period? = null
    var payor: List<Reference>? = null
    var `class`: List<Coverage.Class>? = null
    var order: Int? = null
    var _order: Element? = null
    var network: KotlinString? = null
    var _network: Element? = null
    var costToBeneficiary: List<Coverage.CostToBeneficiary>? = null
    var subrogation: KotlinBoolean? = null
    var _subrogation: Element? = null
    var contract: List<Reference>? = null
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
        11 -> status = compositeDecoder.decodeStringElement(descriptor, i)
        12 ->
          _status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        13 ->
          type =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        14 ->
          policyHolder =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        15 ->
          subscriber =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        16 -> subscriberId = compositeDecoder.decodeStringElement(descriptor, i)
        17 ->
          _subscriberId =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        18 ->
          beneficiary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer,
              null,
            )
        19 -> dependent = compositeDecoder.decodeStringElement(descriptor, i)
        20 ->
          _dependent =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        21 ->
          relationship =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        22 ->
          period =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              PeriodSerializer,
              null,
            )
        23 ->
          payor =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          `class` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageClassSerializer.listSerializer,
              null,
            )
        25 -> order = compositeDecoder.decodeIntElement(descriptor, i)
        26 ->
          _order =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        27 -> network = compositeDecoder.decodeStringElement(descriptor, i)
        28 ->
          _network =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        29 ->
          costToBeneficiary =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageCostToBeneficiarySerializer.listSerializer,
              null,
            )
        30 -> subrogation = compositeDecoder.decodeBooleanElement(descriptor, i)
        31 ->
          _subrogation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        32 ->
          contract =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
      }
    }
    return Coverage(
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
          if (status != null) FinancialResourceStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Coverage"),
      type = type,
      policyHolder = policyHolder,
      subscriber = subscriber,
      subscriberId = R4bString.of(subscriberId, _subscriberId),
      beneficiary =
        beneficiary
          ?: throw SerializationException("Missing required property 'beneficiary' on Coverage"),
      dependent = R4bString.of(dependent, _dependent),
      relationship = relationship,
      period = period,
      payor = payor ?: listOf(),
      `class` = `class` ?: listOf(),
      order = PositiveInt.of(order, _order),
      network = R4bString.of(network, _network),
      costToBeneficiary = costToBeneficiary ?: listOf(),
      subrogation = R4bBoolean.of(subrogation, _subrogation),
      contract = contract ?: listOf(),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Coverage,
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
    if (value.contained.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        7 + descriptorOffset,
        ResourcePolymorphicSerializer.listSerializer,
        value.contained,
      )
    if (value.extension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        8 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.extension,
      )
    if (value.modifierExtension.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        9 + descriptorOffset,
        ExtensionSerializer.listSerializer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
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
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      13 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer,
      value.policyHolder,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      ReferenceSerializer,
      value.subscriber,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      16 + descriptorOffset,
      value.subscriberId?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 17 + descriptorOffset, value.subscriberId)
    compositeEncoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.beneficiary,
    )
    compositeEncoder.encodeStringIfNotNull(
      descriptor,
      19 + descriptorOffset,
      value.dependent?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 20 + descriptorOffset, value.dependent)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      21 + descriptorOffset,
      CodeableConceptSerializer,
      value.relationship,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      22 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    if (value.payor.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.payor,
      )
    if (value.`class`.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        CoverageClassSerializer.listSerializer,
        value.`class`,
      )
    compositeEncoder.encodeIntIfNotNull(descriptor, 25 + descriptorOffset, value.order?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 26 + descriptorOffset, value.order)
    compositeEncoder.encodeStringIfNotNull(descriptor, 27 + descriptorOffset, value.network?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.network)
    if (value.costToBeneficiary.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        CoverageCostToBeneficiarySerializer.listSerializer,
        value.costToBeneficiary,
      )
    compositeEncoder.encodeBooleanIfNotNull(
      descriptor,
      30 + descriptorOffset,
      value.subrogation?.value,
    )
    compositeEncoder.encodeElementIfNotNull(descriptor, 31 + descriptorOffset, value.subrogation)
    if (value.contract.isNotEmpty())
      compositeEncoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contract,
      )
  }
}
