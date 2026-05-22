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

import dev.ohs.fhir.model.r4.Address
import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.ContactPoint
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Enumeration
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.HumanName
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.InsurancePlan
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Money
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Period
import dev.ohs.fhir.model.r4.PositiveInt
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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

internal object InsurancePlanContactSerializer : KSerializer<InsurancePlan.Contact> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Contact") {
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
      element("purpose", CodeableConcept.serializer().descriptor, isOptional = true)
      element("name", HumanName.serializer().descriptor, isOptional = true)
      element(
        "telecom",
        listSerialDescriptor(ContactPoint.serializer().descriptor),
        isOptional = true,
      )
      element("address", Address.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Contact =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Contact) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Contact {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var purpose: CodeableConcept? = null
    var name: HumanName? = null
    var telecom: List<ContactPoint>? = null
    var address: Address? = null
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
          purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.purposeSer, null)
        4 -> name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.nameSer, null)
        5 ->
          telecom =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.telecomSer, null)
        6 ->
          address =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.addressSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Contact: " + i)
      }
    }
    return InsurancePlan.Contact(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      purpose = purpose,
      name = name,
      telecom = telecom ?: listOf(),
      address = address,
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InsurancePlan.Contact) {
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
    (value.purpose)?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.purposeSer, it)
    }
    (value.name)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.nameSer, it) }
    if (value.telecom.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.telecomSer, value.telecom)
    (value.address)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.addressSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val purposeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val nameSer: KSerializer<HumanName> = HumanName.serializer()

    public val telecomSerInner: KSerializer<ContactPoint> = ContactPoint.serializer()

    public val telecomSer: KSerializer<List<ContactPoint>> = ListSerializer(Hoisted.telecomSerInner)

    public val addressSer: KSerializer<Address> = Address.serializer()
  }
}

internal object InsurancePlanCoverageSerializer : KSerializer<InsurancePlan.Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
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
      element("network", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "benefit",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Coverage.Benefit.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Coverage {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var network: List<Reference>? = null
    var benefit: List<InsurancePlan.Coverage.Benefit>? = null
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
        4 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.networkSer, null)
        5 ->
          benefit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.benefitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coverage: " + i)
      }
    }
    return InsurancePlan.Coverage(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      network = network ?: listOf(),
      benefit = benefit ?: listOf(),
    )
  }

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InsurancePlan.Coverage) {
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.network.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.networkSer, value.network)
    if (value.benefit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.benefitSer, value.benefit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val networkSerInner: KSerializer<Reference> = Reference.serializer()

    public val networkSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.networkSerInner)

    public val benefitSerInner: KSerializer<InsurancePlan.Coverage.Benefit> =
      InsurancePlan.Coverage.Benefit.serializer()

    public val benefitSer: KSerializer<List<InsurancePlan.Coverage.Benefit>> =
      ListSerializer(Hoisted.benefitSerInner)
  }
}

internal object InsurancePlanCoverageBenefitSerializer :
  KSerializer<InsurancePlan.Coverage.Benefit> {
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
      element("requirement", KotlinString.serializer().descriptor, isOptional = true)
      element("_requirement", Element.serializer().descriptor, isOptional = true)
      element(
        "limit",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Coverage.Benefit.Limit.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Coverage.Benefit {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var requirement: KotlinString? = null
    var _requirement: Element? = null
    var limit: List<InsurancePlan.Coverage.Benefit.Limit>? = null
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
        4 -> requirement = decoder.decodeStringElement(descriptor, i)
        5 ->
          _requirement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.requirementSer, null)
        6 ->
          limit = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.limitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
      }
    }
    return InsurancePlan.Coverage.Benefit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      requirement = R4String.of(requirement, _requirement),
      limit = limit ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Coverage.Benefit,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.requirement?.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.requirement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.requirementSer, it)
    }
    if (value.limit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.limitSer, value.limit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val requirementSer: KSerializer<Element> = Element.serializer()

    public val limitSerInner: KSerializer<InsurancePlan.Coverage.Benefit.Limit> =
      InsurancePlan.Coverage.Benefit.Limit.serializer()

    public val limitSer: KSerializer<List<InsurancePlan.Coverage.Benefit.Limit>> =
      ListSerializer(Hoisted.limitSerInner)
  }
}

internal object InsurancePlanCoverageBenefitLimitSerializer :
  KSerializer<InsurancePlan.Coverage.Benefit.Limit> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Limit") {
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
      element("value", Quantity.serializer().descriptor, isOptional = true)
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit.Limit =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit.Limit) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Coverage.Benefit.Limit {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var `value`: Quantity? = null
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
        3 ->
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        4 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Limit: " + i)
      }
    }
    return InsurancePlan.Coverage.Benefit.Limit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      `value` = `value`,
      code = code,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Coverage.Benefit.Limit,
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
    (value.`value`)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.valueSer, it) }
    (value.code)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val valueSer: KSerializer<Quantity> = Quantity.serializer()

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object InsurancePlanPlanSerializer : KSerializer<InsurancePlan.Plan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Plan") {
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
        "identifier",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "coverageArea",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("network", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "generalCost",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Plan.GeneralCost.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "specificCost",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Plan.SpecificCost.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Plan {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          identifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.identifierSer, null)
        4 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageAreaSer, null)
        6 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageAreaSer, null)
        7 ->
          generalCost =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.generalCostSer, null)
        8 ->
          specificCost =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.specificCostSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Plan: " + i)
      }
    }
    return InsurancePlan.Plan(
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: InsurancePlan.Plan) {
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
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.identifierSer, value.identifier)
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it) }
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.coverageAreaSer, value.coverageArea)
    if (value.network.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.coverageAreaSer, value.network)
    if (value.generalCost.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.generalCostSer, value.generalCost)
    if (value.specificCost.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.specificCostSer, value.specificCost)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val identifierSerInner: KSerializer<Identifier> = Identifier.serializer()

    public val identifierSer: KSerializer<List<Identifier>> =
      ListSerializer(Hoisted.identifierSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val coverageAreaSerInner: KSerializer<Reference> = Reference.serializer()

    public val coverageAreaSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.coverageAreaSerInner)

    public val generalCostSerInner: KSerializer<InsurancePlan.Plan.GeneralCost> =
      InsurancePlan.Plan.GeneralCost.serializer()

    public val generalCostSer: KSerializer<List<InsurancePlan.Plan.GeneralCost>> =
      ListSerializer(Hoisted.generalCostSerInner)

    public val specificCostSerInner: KSerializer<InsurancePlan.Plan.SpecificCost> =
      InsurancePlan.Plan.SpecificCost.serializer()

    public val specificCostSer: KSerializer<List<InsurancePlan.Plan.SpecificCost>> =
      ListSerializer(Hoisted.specificCostSerInner)
  }
}

internal object InsurancePlanPlanGeneralCostSerializer :
  KSerializer<InsurancePlan.Plan.GeneralCost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("GeneralCost") {
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
      element("groupSize", Int.serializer().descriptor, isOptional = true)
      element("_groupSize", Element.serializer().descriptor, isOptional = true)
      element("cost", Money.serializer().descriptor, isOptional = true)
      element("comment", KotlinString.serializer().descriptor, isOptional = true)
      element("_comment", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.GeneralCost =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.GeneralCost) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Plan.GeneralCost {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        4 -> groupSize = decoder.decodeIntElement(descriptor, i)
        5 ->
          _groupSize =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.groupSizeSer, null)
        6 -> cost = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.costSer, null)
        7 -> comment = decoder.decodeStringElement(descriptor, i)
        8 ->
          _comment =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.groupSizeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding GeneralCost: " + i)
      }
    }
    return InsurancePlan.Plan.GeneralCost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type,
      groupSize = PositiveInt.of(groupSize, _groupSize),
      cost = cost,
      comment = R4String.of(comment, _comment),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Plan.GeneralCost,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    ((value.groupSize?.value))?.let { encoder.encodeIntElement(descriptor, 4, it) }
    (value.groupSize?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.groupSizeSer, it)
    }
    (value.cost)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.costSer, it) }
    ((value.comment?.value))?.let { encoder.encodeStringElement(descriptor, 7, it) }
    (value.comment?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.groupSizeSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val groupSizeSer: KSerializer<Element> = Element.serializer()

    public val costSer: KSerializer<Money> = Money.serializer()
  }
}

internal object InsurancePlanPlanSpecificCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SpecificCost") {
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
      element(
        "benefit",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Plan.SpecificCost.Benefit.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): InsurancePlan.Plan.SpecificCost {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var category: CodeableConcept? = null
    var benefit: List<InsurancePlan.Plan.SpecificCost.Benefit>? = null
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
          benefit =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.benefitSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SpecificCost: " + i)
      }
    }
    return InsurancePlan.Plan.SpecificCost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      category = category!!,
      benefit = benefit ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Plan.SpecificCost,
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
    if (value.benefit.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.benefitSer, value.benefit)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val benefitSerInner: KSerializer<InsurancePlan.Plan.SpecificCost.Benefit> =
      InsurancePlan.Plan.SpecificCost.Benefit.serializer()

    public val benefitSer: KSerializer<List<InsurancePlan.Plan.SpecificCost.Benefit>> =
      ListSerializer(Hoisted.benefitSerInner)
  }
}

internal object InsurancePlanPlanSpecificCostBenefitSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit> {
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
      element(
        "cost",
        listSerialDescriptor(
          lazyDescriptor { InsurancePlan.Plan.SpecificCost.Benefit.Cost.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): InsurancePlan.Plan.SpecificCost.Benefit {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var cost: List<InsurancePlan.Plan.SpecificCost.Benefit.Cost>? = null
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
        4 -> cost = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.costSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Benefit: " + i)
      }
    }
    return InsurancePlan.Plan.SpecificCost.Benefit(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      cost = cost ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Plan.SpecificCost.Benefit,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    if (value.cost.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.costSer, value.cost)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val costSerInner: KSerializer<InsurancePlan.Plan.SpecificCost.Benefit.Cost> =
      InsurancePlan.Plan.SpecificCost.Benefit.Cost.serializer()

    public val costSer: KSerializer<List<InsurancePlan.Plan.SpecificCost.Benefit.Cost>> =
      ListSerializer(Hoisted.costSerInner)
  }
}

internal object InsurancePlanPlanSpecificCostBenefitCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit.Cost> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Cost") {
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
      element("applicability", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "qualifiers",
        listSerialDescriptor(CodeableConcept.serializer().descriptor),
        isOptional = true,
      )
      element("value", Quantity.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit.Cost =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit.Cost) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): InsurancePlan.Plan.SpecificCost.Benefit.Cost {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var applicability: CodeableConcept? = null
    var qualifiers: List<CodeableConcept>? = null
    var `value`: Quantity? = null
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
        4 ->
          applicability =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        5 ->
          qualifiers =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.qualifiersSer, null)
        6 ->
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Cost: " + i)
      }
    }
    return InsurancePlan.Plan.SpecificCost.Benefit.Cost(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      applicability = applicability,
      qualifiers = qualifiers ?: listOf(),
      `value` = `value`,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: InsurancePlan.Plan.SpecificCost.Benefit.Cost,
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
    (value.type)?.let { encoder.encodeSerializableElement(descriptor, 3, Hoisted.typeSer, it) }
    (value.applicability)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.typeSer, it)
    }
    if (value.qualifiers.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.qualifiersSer, value.qualifiers)
    (value.`value`)?.let { encoder.encodeSerializableElement(descriptor, 6, Hoisted.valueSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val qualifiersSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSer)

    public val valueSer: KSerializer<Quantity> = Quantity.serializer()
  }
}

internal object InsurancePlanSerializer : KSerializer<InsurancePlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InsurancePlan") {
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
      "type",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("name", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_name", Element.serializer().descriptor, isOptional = true)
    b.element(
      "alias",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_alias", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("ownedBy", Reference.serializer().descriptor, isOptional = true)
    b.element("administeredBy", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "coverageArea",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "contact",
      listSerialDescriptor(lazyDescriptor { InsurancePlan.Contact.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "endpoint",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("network", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "coverage",
      listSerialDescriptor(lazyDescriptor { InsurancePlan.Coverage.serializer().descriptor }),
      isOptional = true,
    )
    b.element(
      "plan",
      listSerialDescriptor(lazyDescriptor { InsurancePlan.Plan.serializer().descriptor }),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): InsurancePlan =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "InsurancePlan")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        13 -> type = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        14 -> name = decoder.decodeStringElement(descriptor, i)
        15 ->
          _name =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        16 ->
          alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer, null)
        17 ->
          _alias = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.aliasSer2, null)
        18 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        19 ->
          ownedBy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ownedBySer, null)
        20 ->
          administeredBy =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ownedBySer, null)
        21 ->
          coverageArea =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageAreaSer, null)
        22 ->
          contact =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.contactSer, null)
        23 ->
          endpoint =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageAreaSer, null)
        24 ->
          network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageAreaSer, null)
        25 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        26 -> plan = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.planSer, null)
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
      status = status?.let { Enumeration.of(PublicationStatus.fromCode(it), _status) },
      type = type ?: listOf(),
      name = R4String.of(name, _name),
      alias =
        (kotlin.collections.List(maxOf(alias?.size ?: 0, _alias?.size ?: 0)) { index ->
          R4String.of(alias?.getOrNull(index)?.let { it }, _alias?.getOrNull(index))!!
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: InsurancePlan,
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
    ((value.status?.value?.getCode()))?.let {
      encoder.encodeStringElement(descriptor, 11 + descriptorOffset, it)
    }
    (value.status?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.type.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.typeSer,
        value.type,
      )
    ((value.name?.value))?.let {
      encoder.encodeStringElement(descriptor, 14 + descriptorOffset, it)
    }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.alias.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 16 + descriptorOffset, Hoisted.aliasSer, it)
    }
    (value.alias.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 17 + descriptorOffset, Hoisted.aliasSer2, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 18 + descriptorOffset, Hoisted.periodSer, it)
    }
    (value.ownedBy)?.let {
      encoder.encodeSerializableElement(descriptor, 19 + descriptorOffset, Hoisted.ownedBySer, it)
    }
    (value.administeredBy)?.let {
      encoder.encodeSerializableElement(descriptor, 20 + descriptorOffset, Hoisted.ownedBySer, it)
    }
    if (value.coverageArea.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.coverageAreaSer,
        value.coverageArea,
      )
    if (value.contact.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        22 + descriptorOffset,
        Hoisted.contactSer,
        value.contact,
      )
    if (value.endpoint.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.coverageAreaSer,
        value.endpoint,
      )
    if (value.network.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.coverageAreaSer,
        value.network,
      )
    if (value.coverage.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        25 + descriptorOffset,
        Hoisted.coverageSer,
        value.coverage,
      )
    if (value.plan.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.planSer,
        value.plan,
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

    public val typeSerInner: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val typeSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.typeSerInner)

    public val aliasSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val aliasSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.aliasSerInner).nullable)

    public val aliasSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val ownedBySer: KSerializer<Reference> = Reference.serializer()

    public val coverageAreaSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.ownedBySer)

    public val contactSerInner: KSerializer<InsurancePlan.Contact> =
      InsurancePlan.Contact.serializer()

    public val contactSer: KSerializer<List<InsurancePlan.Contact>> =
      ListSerializer(Hoisted.contactSerInner)

    public val coverageSerInner: KSerializer<InsurancePlan.Coverage> =
      InsurancePlan.Coverage.serializer()

    public val coverageSer: KSerializer<List<InsurancePlan.Coverage>> =
      ListSerializer(Hoisted.coverageSerInner)

    public val planSerInner: KSerializer<InsurancePlan.Plan> = InsurancePlan.Plan.serializer()

    public val planSer: KSerializer<List<InsurancePlan.Plan>> = ListSerializer(Hoisted.planSerInner)
  }
}

internal object InsurancePlanPolymorphicSerializer : KSerializer<InsurancePlan> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("InsurancePlan") { InsurancePlanSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: InsurancePlan) {
    encoder.encodeStructure(descriptor) {
      InsurancePlanSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): InsurancePlan =
    decoder.decodeStructure(descriptor) {
      InsurancePlanSerializer.deserializeInternal(this, descriptor, 0)
    }
}
