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

import dev.ohs.fhir.model.r4b.Address
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.ContactPoint
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.HumanName
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.InsurancePlan
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
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object InsurancePlanContactSerializer : KSerializer<InsurancePlan.Contact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contact") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("purpose", CodeableConceptSerializer.descriptor)
      optionalElement("name", HumanNameSerializer.descriptor)
      optionalElement("telecom", ContactPointSerializer.listSerializer.descriptor)
      optionalElement("address", AddressSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Contact>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Contact =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var purpose: CodeableConcept? = null
      var name: HumanName? = null
      var telecom: List<ContactPoint>? = null
      var address: Address? = null
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
            purpose =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> name = decodeNullableSerializableElement(descriptor, i, HumanNameSerializer, null)
          5 ->
            telecom =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ContactPointSerializer.listSerializer,
                null,
              )
          6 -> address = decodeNullableSerializableElement(descriptor, i, AddressSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Contact: " + i)
        }
      }
      InsurancePlan.Contact(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        purpose = purpose,
        name = name,
        telecom = telecom ?: listOf(),
        address = address,
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Contact) {
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
      encodeSerializableIfNotNull(descriptor, 3, CodeableConceptSerializer, value.purpose)
      encodeSerializableIfNotNull(descriptor, 4, HumanNameSerializer, value.name)
      if (value.telecom.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ContactPointSerializer.listSerializer,
          value.telecom,
        )
      encodeSerializableIfNotNull(descriptor, 6, AddressSerializer, value.address)
    }
  }
}

internal object InsurancePlanCoverageSerializer : KSerializer<InsurancePlan.Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("network", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("benefit", InsurancePlanCoverageBenefitSerializer.listSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Coverage>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var network: List<Reference>? = null
      var benefit: List<InsurancePlan.Coverage.Benefit>? = null
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
            network =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          5 ->
            benefit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanCoverageBenefitSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
        }
      }
      InsurancePlan.Coverage(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on InsurancePlan.Coverage"
            ),
        network = network ?: listOf(),
        benefit = benefit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage) {
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
      if (value.network.isNotEmpty())
        encodeSerializableElement(descriptor, 4, ReferenceSerializer.listSerializer, value.network)
      if (value.benefit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          InsurancePlanCoverageBenefitSerializer.listSerializer,
          value.benefit,
        )
    }
  }
}

internal object InsurancePlanCoverageBenefitSerializer :
  KSerializer<InsurancePlan.Coverage.Benefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Benefit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("requirement", KotlinString.serializer().descriptor)
      optionalElement("_requirement", ElementSerializer.descriptor)
      optionalElement(
        "limit",
        InsurancePlanCoverageBenefitLimitSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Coverage.Benefit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var requirement: KotlinString? = null
      var _requirement: Element? = null
      var limit: List<InsurancePlan.Coverage.Benefit.Limit>? = null
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
          4 -> requirement = decodeStringElement(descriptor, i)
          5 ->
            _requirement = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 ->
            limit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanCoverageBenefitLimitSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
        }
      }
      InsurancePlan.Coverage.Benefit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on InsurancePlan.Coverage.Benefit"
            ),
        requirement = R4bString.of(requirement, _requirement),
        limit = limit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit) {
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
      encodeStringIfNotNull(descriptor, 4, value.requirement?.value)
      encodeElementIfNotNull(descriptor, 5, value.requirement)
      if (value.limit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          6,
          InsurancePlanCoverageBenefitLimitSerializer.listSerializer,
          value.limit,
        )
    }
  }
}

internal object InsurancePlanCoverageBenefitLimitSerializer :
  KSerializer<InsurancePlan.Coverage.Benefit.Limit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Limit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("value", QuantitySerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Coverage.Benefit.Limit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit.Limit =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var `value`: Quantity? = null
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
          3 -> `value` = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          4 ->
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Limit: " + i)
        }
      }
      InsurancePlan.Coverage.Benefit.Limit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        `value` = `value`,
        code = code,
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit.Limit) {
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
      encodeSerializableIfNotNull(descriptor, 3, QuantitySerializer, value.`value`)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.code)
    }
  }
}

internal object InsurancePlanPlanSerializer : KSerializer<InsurancePlan.Plan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Plan") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("coverageArea", ReferenceSerializer.listSerializer.descriptor)
      optionalElement("network", ReferenceSerializer.listSerializer.descriptor)
      optionalElement(
        "generalCost",
        InsurancePlanPlanGeneralCostSerializer.listSerializer.descriptor,
      )
      optionalElement(
        "specificCost",
        InsurancePlanPlanSpecificCostSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Plan>> = ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var identifier: List<Identifier>? = null
      var type: CodeableConcept? = null
      var coverageArea: List<Reference>? = null
      var network: List<Reference>? = null
      var generalCost: List<InsurancePlan.Plan.GeneralCost>? = null
      var specificCost: List<InsurancePlan.Plan.SpecificCost>? = null
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
            identifier =
              decodeNullableSerializableElement(
                descriptor,
                i,
                IdentifierSerializer.listSerializer,
                null,
              )
          4 ->
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            coverageArea =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          6 ->
            network =
              decodeNullableSerializableElement(
                descriptor,
                i,
                ReferenceSerializer.listSerializer,
                null,
              )
          7 ->
            generalCost =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanPlanGeneralCostSerializer.listSerializer,
                null,
              )
          8 ->
            specificCost =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanPlanSpecificCostSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Plan: " + i)
        }
      }
      InsurancePlan.Plan(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        identifier = identifier ?: listOf(),
        type = type,
        coverageArea = coverageArea ?: listOf(),
        network = network ?: listOf(),
        generalCost = generalCost ?: listOf(),
        specificCost = specificCost ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan) {
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
      if (value.identifier.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          3,
          IdentifierSerializer.listSerializer,
          value.identifier,
        )
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.type)
      if (value.coverageArea.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          ReferenceSerializer.listSerializer,
          value.coverageArea,
        )
      if (value.network.isNotEmpty())
        encodeSerializableElement(descriptor, 6, ReferenceSerializer.listSerializer, value.network)
      if (value.generalCost.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          7,
          InsurancePlanPlanGeneralCostSerializer.listSerializer,
          value.generalCost,
        )
      if (value.specificCost.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          8,
          InsurancePlanPlanSpecificCostSerializer.listSerializer,
          value.specificCost,
        )
    }
  }
}

internal object InsurancePlanPlanGeneralCostSerializer :
  KSerializer<InsurancePlan.Plan.GeneralCost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GeneralCost") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("groupSize", Int.serializer().descriptor)
      optionalElement("_groupSize", ElementSerializer.descriptor)
      optionalElement("cost", MoneySerializer.descriptor)
      optionalElement("comment", KotlinString.serializer().descriptor)
      optionalElement("_comment", ElementSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Plan.GeneralCost>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.GeneralCost =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var groupSize: Int? = null
      var _groupSize: Element? = null
      var cost: Money? = null
      var comment: KotlinString? = null
      var _comment: Element? = null
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
          4 -> groupSize = decodeIntElement(descriptor, i)
          5 ->
            _groupSize = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          6 -> cost = decodeNullableSerializableElement(descriptor, i, MoneySerializer, null)
          7 -> comment = decodeStringElement(descriptor, i)
          8 -> _comment = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding GeneralCost: " + i)
        }
      }
      InsurancePlan.Plan.GeneralCost(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type = type,
        groupSize = PositiveInt.of(groupSize, _groupSize),
        cost = cost,
        comment = R4bString.of(comment, _comment),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.GeneralCost) {
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
      encodeIntIfNotNull(descriptor, 4, value.groupSize?.value)
      encodeElementIfNotNull(descriptor, 5, value.groupSize)
      encodeSerializableIfNotNull(descriptor, 6, MoneySerializer, value.cost)
      encodeStringIfNotNull(descriptor, 7, value.comment?.value)
      encodeElementIfNotNull(descriptor, 8, value.comment)
    }
  }
}

internal object InsurancePlanPlanSpecificCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecificCost") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("category", CodeableConceptSerializer.descriptor)
      optionalElement(
        "benefit",
        InsurancePlanPlanSpecificCostBenefitSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Plan.SpecificCost>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var category: CodeableConcept? = null
      var benefit: List<InsurancePlan.Plan.SpecificCost.Benefit>? = null
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
            benefit =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanPlanSpecificCostBenefitSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding SpecificCost: " + i)
        }
      }
      InsurancePlan.Plan.SpecificCost(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        category =
          category
            ?: throw SerializationException(
              "Missing required property 'category' on InsurancePlan.Plan.SpecificCost"
            ),
        benefit = benefit ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.category)
      if (value.benefit.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          InsurancePlanPlanSpecificCostBenefitSerializer.listSerializer,
          value.benefit,
        )
    }
  }
}

internal object InsurancePlanPlanSpecificCostBenefitSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Benefit") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement(
        "cost",
        InsurancePlanPlanSpecificCostBenefitCostSerializer.listSerializer.descriptor,
      )
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Plan.SpecificCost.Benefit>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var cost: List<InsurancePlan.Plan.SpecificCost.Benefit.Cost>? = null
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
            cost =
              decodeNullableSerializableElement(
                descriptor,
                i,
                InsurancePlanPlanSpecificCostBenefitCostSerializer.listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
        }
      }
      InsurancePlan.Plan.SpecificCost.Benefit(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on InsurancePlan.Plan.SpecificCost.Benefit"
            ),
        cost = cost ?: listOf(),
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit) {
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
      if (value.cost.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          InsurancePlanPlanSpecificCostBenefitCostSerializer.listSerializer,
          value.cost,
        )
    }
  }
}

internal object InsurancePlanPlanSpecificCostBenefitCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit.Cost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Cost") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("applicability", CodeableConceptSerializer.descriptor)
      optionalElement("qualifiers", CodeableConceptSerializer.listSerializer.descriptor)
      optionalElement("value", QuantitySerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<InsurancePlan.Plan.SpecificCost.Benefit.Cost>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit.Cost =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var applicability: CodeableConcept? = null
      var qualifiers: List<CodeableConcept>? = null
      var `value`: Quantity? = null
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
            applicability =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            qualifiers =
              decodeNullableSerializableElement(
                descriptor,
                i,
                CodeableConceptSerializer.listSerializer,
                null,
              )
          6 -> `value` = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Cost: " + i)
        }
      }
      InsurancePlan.Plan.SpecificCost.Benefit.Cost(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on InsurancePlan.Plan.SpecificCost.Benefit.Cost"
            ),
        applicability = applicability,
        qualifiers = qualifiers ?: listOf(),
        `value` = `value`,
      )
    }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit.Cost) {
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
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.applicability)
      if (value.qualifiers.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          5,
          CodeableConceptSerializer.listSerializer,
          value.qualifiers,
        )
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.`value`)
    }
  }
}

internal object InsurancePlanSerializer : FhirResourceSerializer<InsurancePlan> {
  override val descriptor: SerialDescriptor = buildResourceDescriptor("InsurancePlan")

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
    b.optionalElement("type", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("name", KotlinString.serializer().descriptor)
    b.optionalElement("_name", ElementSerializer.descriptor)
    b.optionalElement("alias", stringNullableListSerializer.descriptor)
    b.optionalElement("_alias", ElementSerializer.nullableListSerializer.descriptor)
    b.optionalElement("period", PeriodSerializer.descriptor)
    b.optionalElement("ownedBy", ReferenceSerializer.descriptor)
    b.optionalElement("administeredBy", ReferenceSerializer.descriptor)
    b.optionalElement("coverageArea", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("contact", InsurancePlanContactSerializer.listSerializer.descriptor)
    b.optionalElement("endpoint", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("network", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("coverage", InsurancePlanCoverageSerializer.listSerializer.descriptor)
    b.optionalElement("plan", InsurancePlanPlanSerializer.listSerializer.descriptor)
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): InsurancePlan {
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
    var type: List<CodeableConcept>? = null
    var name: KotlinString? = null
    var _name: Element? = null
    var alias: List<KotlinString?>? = null
    var _alias: List<Element?>? = null
    var period: Period? = null
    var ownedBy: Reference? = null
    var administeredBy: Reference? = null
    var coverageArea: List<Reference>? = null
    var contact: List<InsurancePlan.Contact>? = null
    var endpoint: List<Reference>? = null
    var network: List<Reference>? = null
    var coverage: List<InsurancePlan.Coverage>? = null
    var plan: List<InsurancePlan.Plan>? = null
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
          type =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
        16 ->
          alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              stringNullableListSerializer,
              null,
            )
        17 ->
          _alias =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer.nullableListSerializer,
              null,
            )
        18 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, PeriodSerializer, null)
        19 ->
          ownedBy =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        20 ->
          administeredBy =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        21 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        22 ->
          contact =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InsurancePlanContactSerializer.listSerializer,
              null,
            )
        23 ->
          endpoint =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        24 ->
          network =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        25 ->
          coverage =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InsurancePlanCoverageSerializer.listSerializer,
              null,
            )
        26 ->
          plan =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              InsurancePlanPlanSerializer.listSerializer,
              null,
            )
        else -> throw SerializationException("Unexpected index decoding InsurancePlan: " + i)
      }
    }
    return InsurancePlan(
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
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status),
      type = type ?: listOf(),
      name = R4bString.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R4bString.of(alias?.getOrNull(index), _alias?.getOrNull(index))
            ?: throw SerializationException(
              "An entry of 'alias' on InsurancePlan has neither a value nor an id/extension"
            )
        }),
      period = period,
      ownedBy = ownedBy,
      administeredBy = administeredBy,
      coverageArea = coverageArea ?: listOf(),
      contact = contact ?: listOf(),
      endpoint = endpoint ?: listOf(),
      network = network ?: listOf(),
      coverage = coverage ?: listOf(),
      plan = plan ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InsurancePlan,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status?.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.type,
      )
    encoder.encodeStringIfNotNull(descriptor, 14 + descriptorOffset, value.name?.value)
    encoder.encodeElementIfNotNull(descriptor, 15 + descriptorOffset, value.name)
    if (value.alias.isNotEmpty()) {
      encoder.encodeNullableListIfNotNull(
        descriptor,
        16 + descriptorOffset,
        stringNullableListSerializer,
        value.alias.map { it.value },
      )
      encoder.encodePrimitiveElementList(descriptor, 17 + descriptorOffset, value.alias)
    }
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      PeriodSerializer,
      value.period,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      19 + descriptorOffset,
      ReferenceSerializer,
      value.ownedBy,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      20 + descriptorOffset,
      ReferenceSerializer,
      value.administeredBy,
    )
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.coverageArea,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        InsurancePlanContactSerializer.listSerializer,
        value.contact,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.endpoint,
      )
    if (value.network.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.network,
      )
    if (value.coverage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        InsurancePlanCoverageSerializer.listSerializer,
        value.coverage,
      )
    if (value.plan.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        InsurancePlanPlanSerializer.listSerializer,
        value.plan,
      )
  }
}
