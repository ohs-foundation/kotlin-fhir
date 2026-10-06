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
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.FhirResourceSerializer
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
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

internal object CoveragePaymentBySerializer : KSerializer<Coverage.PaymentBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentBy") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("party", ReferenceSerializer.descriptor)
      optionalElement("responsibility", KotlinString.serializer().descriptor)
      optionalElement("_responsibility", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Coverage.PaymentBy>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.PaymentBy =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var party: Reference? = null
      var responsibility: KotlinString? = null
      var _responsibility: Element? = null
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
          3 -> party = decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
          4 -> responsibility = decodeStringElement(descriptor, i)
          5 ->
            _responsibility =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding PaymentBy: " + i)
        }
      }
      Coverage.PaymentBy(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        party =
          party
            ?: throw SerializationException(
              "Missing required property 'party' on Coverage.PaymentBy"
            ),
        responsibility = R5String.of(responsibility, _responsibility),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.PaymentBy) {
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
      encodeSerializableElement(descriptor, 3, ReferenceSerializer, value.party)
      encodeStringIfNotNull(descriptor, 4, value.responsibility?.value)
      encodeElementIfNotNull(descriptor, 5, value.responsibility)
    }
  }
}

internal object CoverageClassSerializer : KSerializer<Coverage.Class> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Class") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("value", IdentifierSerializer.descriptor)
      optionalElement("name", KotlinString.serializer().descriptor)
      optionalElement("_name", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<Coverage.Class>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.Class =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var `value`: Identifier? = null
      var name: KotlinString? = null
      var _name: Element? = null
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
          4 ->
            `value` = decodeNullableSerializableElement(descriptor, i, IdentifierSerializer, null)
          5 -> name = decodeStringElement(descriptor, i)
          6 -> _name = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Class: " + i)
        }
      }
      Coverage.Class(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException("Missing required property 'type' on Coverage.Class"),
        `value` =
          `value`
            ?: throw SerializationException("Missing required property 'value' on Coverage.Class"),
        name = R5String.of(name, _name),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.Class) {
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
      encodeSerializableElement(descriptor, 4, IdentifierSerializer, value.`value`)
      encodeStringIfNotNull(descriptor, 5, value.name?.value)
      encodeElementIfNotNull(descriptor, 6, value.name)
    }
  }
}

internal object CoverageCostToBeneficiarySerializer : KSerializer<Coverage.CostToBeneficiary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CostToBeneficiary") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement("network", CodeableConceptSerializer.descriptor)
      optionalElement("unit", CodeableConceptSerializer.descriptor)
      optionalElement("term", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueMoney", MoneySerializer.descriptor)
      optionalElement(
        "exception",
        CoverageCostToBeneficiaryExceptionSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<Coverage.CostToBeneficiary>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var category: CodeableConcept? = null
      var network: CodeableConcept? = null
      var unit: CodeableConcept? = null
      var term: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueMoney: Money? = null
      var exception: List<Coverage.CostToBeneficiary.Exception>? = null
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
          4 ->
            category =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            network =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          6 ->
            unit = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          7 ->
            term = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          8 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          9 -> valueMoney = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          10 ->
            exception =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CoverageCostToBeneficiaryExceptionSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding CostToBeneficiary: " + i)
        }
      }
      Coverage.CostToBeneficiary(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        category = category,
        network = network,
        unit = unit,
        term = term,
        `value` = Coverage.CostToBeneficiary.Value.from(valueQuantity, valueMoney),
        exception = exception ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.type)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.category)
      encodeSerializableIfNotNull(descriptor, 5, CodeableConceptSerializer, value.network)
      encodeSerializableIfNotNull(descriptor, 6, CodeableConceptSerializer, value.unit)
      encodeSerializableIfNotNull(descriptor, 7, CodeableConceptSerializer, value.term)
      when (val choice = value.`value`) {
        null -> {}
        is Coverage.CostToBeneficiary.Value.Quantity -> {
          encodeSerializableElement(descriptor, 8, QuantitySerializer, choice.value)
        }
        is Coverage.CostToBeneficiary.Value.Money -> {
          encodeSerializableElement(descriptor, 9, MoneySerializer, choice.value)
        }
      }
      if (value.exception.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          10,
          CoverageCostToBeneficiaryExceptionSerializer.listSerializer,
          value.exception,
        )
    }
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

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Exception =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var period: Period? = null
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
          4 -> period = decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Exception: " + i)
        }
      }
      Coverage.CostToBeneficiary.Exception(
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
      encodeSerializableIfNotNull(descriptor, 4, PeriodSerializer, value.period)
    }
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
    b.optionalElement("kind", KotlinString.serializer().descriptor)
    b.optionalElement("_kind", ElementSerializer.descriptor)
    b.optionalElement("paymentBy", CoveragePaymentBySerializer.listSerializer.descriptor)
    b.optionalElement("type", CodeableConceptSerializer.descriptor)
    b.optionalElement("policyHolder", ReferenceSerializer.descriptor)
    b.optionalElement("subscriber", ReferenceSerializer.descriptor)
    b.optionalElement("subscriberId", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("beneficiary", ReferenceSerializer.descriptor)
    b.optionalElement("dependent", KotlinString.serializer().descriptor)
    b.optionalElement("_dependent", ElementSerializer.descriptor)
    b.optionalElement("relationship", CodeableConceptSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("insurer", ReferenceSerializer.descriptor)
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
    b.optionalElement("insurancePlan", ReferenceSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
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
    var kind: KotlinString? = null
    var _kind: Element? = null
    var paymentBy: List<Coverage.PaymentBy>? = null
    var type: CodeableConcept? = null
    var policyHolder: Reference? = null
    var subscriber: Reference? = null
    var subscriberId: List<Identifier>? = null
    var beneficiary: Reference? = null
    var dependent: KotlinString? = null
    var _dependent: Element? = null
    var relationship: CodeableConcept? = null
    var period: Period? = null
    var insurer: Reference? = null
    var `class`: List<Coverage.Class>? = null
    var order: Int? = null
    var _order: Element? = null
    var network: KotlinString? = null
    var _network: Element? = null
    var costToBeneficiary: List<Coverage.CostToBeneficiary>? = null
    var subrogation: KotlinBoolean? = null
    var _subrogation: Element? = null
    var contract: List<Reference>? = null
    var insurancePlan: Reference? = null
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
        13 -> kind = decoder.decodeStringElement(descriptor, i)
        14 ->
          _kind = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        15 ->
          paymentBy =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoveragePaymentBySerializer.listSerializer,
              null,
            )
        16 ->
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        17 ->
          policyHolder =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        18 ->
          subscriber =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          subscriberId =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              IdentifierSerializer.listSerializer,
              null,
            )
        20 ->
          beneficiary =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 -> dependent = decoder.decodeStringElement(descriptor, i)
        22 ->
          _dependent =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        23 ->
          relationship =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        24 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        25 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        26 ->
          `class` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageClassSerializer.listSerializer,
              null,
            )
        27 -> order = decoder.decodeIntElement(descriptor, i)
        28 ->
          _order = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        29 -> network = decoder.decodeStringElement(descriptor, i)
        30 ->
          _network =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        31 ->
          costToBeneficiary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CoverageCostToBeneficiarySerializer.listSerializer,
              null,
            )
        32 -> subrogation = decoder.decodeBooleanElement(descriptor, i)
        33 ->
          _subrogation =
            decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        34 ->
          contract =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        35 ->
          insurancePlan =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
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
          if (status != null) Coverage.FinancialResourceStatusCodes.fromCode(status) else null,
          _status,
        ) ?: throw SerializationException("Missing required property 'status' on Coverage"),
      kind =
        Enumeration.of(if (kind != null) Coverage.Kind.fromCode(kind) else null, _kind)
          ?: throw SerializationException("Missing required property 'kind' on Coverage"),
      paymentBy = paymentBy ?: listOf(),
      type = type,
      policyHolder = policyHolder,
      subscriber = subscriber,
      subscriberId = subscriberId ?: listOf(),
      beneficiary =
        beneficiary
          ?: throw SerializationException("Missing required property 'beneficiary' on Coverage"),
      dependent = R5String.of(dependent, _dependent),
      relationship = relationship,
      period = period,
      insurer = insurer,
      `class` = `class` ?: listOf(),
      order = PositiveInt.of(order, _order),
      network = R5String.of(network, _network),
      costToBeneficiary = costToBeneficiary ?: listOf(),
      subrogation = R5Boolean.of(subrogation, _subrogation),
      contract = contract ?: listOf(),
      insurancePlan = insurancePlan,
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Coverage,
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
    encoder.encodeStringIfNotNull(descriptor, 13 + descriptorOffset, value.kind.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 14 + descriptorOffset, value.kind)
    if (value.paymentBy.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        CoveragePaymentBySerializer.listSerializer,
        value.paymentBy,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      16 + descriptorOffset,
      CodeableConceptSerializer,
      value.type,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      17 + descriptorOffset,
      ReferenceSerializer,
      value.policyHolder,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.subscriber,
    )
    if (value.subscriberId.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        IdentifierSerializer.listSerializer,
        value.subscriberId,
      )
    encoder.encodeSerializableElement(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.beneficiary,
    )
    encoder.encodeStringIfNotNull(descriptor, 21 + descriptorOffset, value.dependent?.value)
    encoder.encodeElementIfNotNull(descriptor, 22 + descriptorOffset, value.dependent)
    encoder.encodeSerializableIfNotNull(
      descriptor,
      23 + descriptorOffset,
      CodeableConceptSerializer,
      value.relationship,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      24 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      25 + descriptorOffset,
      ReferenceSerializer,
      value.insurer,
    )
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        CoverageClassSerializer.listSerializer,
        value.`class`,
      )
    encoder.encodeIntIfNotNull(descriptor, 27 + descriptorOffset, value.order?.value)
    encoder.encodeElementIfNotNull(descriptor, 28 + descriptorOffset, value.order)
    encoder.encodeStringIfNotNull(descriptor, 29 + descriptorOffset, value.network?.value)
    encoder.encodeElementIfNotNull(descriptor, 30 + descriptorOffset, value.network)
    if (value.costToBeneficiary.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        CoverageCostToBeneficiarySerializer.listSerializer,
        value.costToBeneficiary,
      )
    encoder.encodeBooleanIfNotNull(descriptor, 32 + descriptorOffset, value.subrogation?.value)
    encoder.encodeElementIfNotNull(descriptor, 33 + descriptorOffset, value.subrogation)
    if (value.contract.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        34 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.contract,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      35 + descriptorOffset,
      ReferenceSerializer,
      value.insurancePlan,
    )
  }
}
