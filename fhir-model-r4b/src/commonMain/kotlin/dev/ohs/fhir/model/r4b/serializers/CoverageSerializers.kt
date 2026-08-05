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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Money
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Period
import dev.ohs.fhir.model.r4b.PositiveInt
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
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

internal object CoverageClassSerializer : KSerializer<Coverage.Class> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Class") {
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
      element("value", KotlinString.serializer().descriptor, isOptional = true)
      element("_value", Element.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Coverage.Class =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.Class) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Coverage.Class {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: KotlinString? = null
    var _value: Element? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        4 -> `value` = decoder.decodeStringElement(descriptor, i)
        5 ->
          _value = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        6 -> name = decoder.decodeStringElement(descriptor, i)
        7 ->
          _name = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Class: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Coverage.Class) {
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
    ((value.`value`.value))?.let { encoder.encodeStringElement(descriptor, 4, it) }
    (value.`value`.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueSer, it)
    }
    ((value.name?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.valueSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Element> = Element.serializer()
  }
}

internal object CoverageCostToBeneficiarySerializer : KSerializer<Coverage.CostToBeneficiary> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CostToBeneficiary") {
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
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueMoney", Money.serializer().descriptor, isOptional = true)
      element(
        "exception",
        listSerialDescriptor(
          lazyDescriptor { Coverage.CostToBeneficiary.Exception.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Coverage.CostToBeneficiary {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var valueQuantity: Quantity? = null
    var valueMoney: Money? = null
    var exception: List<Coverage.CostToBeneficiary.Exception>? = null
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
          valueQuantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueQuantitySer, null)
        5 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueMoneySer, null)
        6 ->
          exception =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.exceptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CostToBeneficiary: " + i)
      }
    }
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

  private fun serializeInternal(encoder: CompositeEncoder, `value`: Coverage.CostToBeneficiary) {
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
    when (val choice = value.`value`) {
      is Coverage.CostToBeneficiary.Value.Quantity -> {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueQuantitySer, choice.value)
      }
      is Coverage.CostToBeneficiary.Value.Money -> {
        encoder.encodeSerializableElement(descriptor, 5, Hoisted.valueMoneySer, choice.value)
      }
    }
    if (value.exception.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.exceptionSer, value.exception)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueMoneySer: KSerializer<Money> = Money.serializer()

    public val exceptionSerInner: KSerializer<Coverage.CostToBeneficiary.Exception> =
      Coverage.CostToBeneficiary.Exception.serializer()

    public val exceptionSer: KSerializer<List<Coverage.CostToBeneficiary.Exception>> =
      ListSerializer(Hoisted.exceptionSerInner)
  }
}

internal object CoverageCostToBeneficiaryExceptionSerializer :
  KSerializer<Coverage.CostToBeneficiary.Exception> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Exception") {
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
      element("period", Period.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Exception =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this)
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Exception) {
    encoder.encodeStructure(descriptor) {
      serializeInternal(this, value)
    }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): Coverage.CostToBeneficiary.Exception {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var period: Period? = null
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
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Exception: " + i)
      }
    }
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: Coverage.CostToBeneficiary.Exception,
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
    (value.period)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CoverageSerializer : KSerializer<Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
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
    b.element("type", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("policyHolder", Reference.serializer().descriptor, isOptional = true)
    b.element("subscriber", Reference.serializer().descriptor, isOptional = true)
    b.element("subscriberId", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_subscriberId", Element.serializer().descriptor, isOptional = true)
    b.element("beneficiary", Reference.serializer().descriptor, isOptional = true)
    b.element("dependent", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_dependent", Element.serializer().descriptor, isOptional = true)
    b.element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("period", Period.serializer().descriptor, isOptional = true)
    b.element("payor", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "class",
      listSerialDescriptor(lazyDescriptor { Coverage.Class.serializer().descriptor }),
      isOptional = true,
    )
    b.element("order", Int.serializer().descriptor, isOptional = true)
    b.element("_order", Element.serializer().descriptor, isOptional = true)
    b.element("network", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_network", Element.serializer().descriptor, isOptional = true)
    b.element(
      "costToBeneficiary",
      listSerialDescriptor(lazyDescriptor { Coverage.CostToBeneficiary.serializer().descriptor }),
      isOptional = true,
    )
    b.element("subrogation", KotlinBoolean.serializer().descriptor, isOptional = true)
    b.element("_subrogation", Element.serializer().descriptor, isOptional = true)
    b.element(
      "contract",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): Coverage =
    decoder.decodeStructure(descriptor) {
      deserializeInternal(this, descriptor, 1)
    }

  override fun serialize(encoder: Encoder, `value`: Coverage) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "Coverage")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        14 ->
          policyHolder =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policyHolderSer, null)
        15 ->
          subscriber =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policyHolderSer, null)
        16 -> subscriberId = decoder.decodeStringElement(descriptor, i)
        17 ->
          _subscriberId =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        18 ->
          beneficiary =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.policyHolderSer, null)
        19 -> dependent = decoder.decodeStringElement(descriptor, i)
        20 ->
          _dependent =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        21 ->
          relationship =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.typeSer, null)
        22 ->
          period = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.periodSer, null)
        23 ->
          payor = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.payorSer, null)
        24 ->
          `class` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.classSer, null)
        25 -> order = decoder.decodeIntElement(descriptor, i)
        26 ->
          _order =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        27 -> network = decoder.decodeStringElement(descriptor, i)
        28 ->
          _network =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        29 ->
          costToBeneficiary =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.costToBeneficiarySer,
              null,
            )
        30 -> subrogation = decoder.decodeBooleanElement(descriptor, i)
        31 ->
          _subrogation =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        32 ->
          contract =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.payorSer, null)
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
          Coverage.FinancialResourceStatusCodes.fromCode(
            status ?: throw SerializationException("Missing required property 'status' on Coverage")
          ),
          _status,
        ),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: Coverage,
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
    (value.type)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.policyHolder)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.policyHolderSer,
        it,
      )
    }
    (value.subscriber)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.policyHolderSer,
        it,
      )
    }
    ((value.subscriberId?.value))?.let {
      encoder.encodeStringElement(descriptor, 16 + descriptorOffset, it)
    }
    (value.subscriberId?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    encoder.encodeSerializableElement(
      descriptor,
      18 + descriptorOffset,
      Hoisted.policyHolderSer,
      value.beneficiary,
    )
    ((value.dependent?.value))?.let {
      encoder.encodeStringElement(descriptor, 19 + descriptorOffset, it)
    }
    (value.dependent?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.relationship)?.let {
      encoder.encodeSerializableElement(descriptor, 21 + descriptorOffset, Hoisted.typeSer, it)
    }
    (value.period)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.periodSer, it)
    }
    if (value.payor.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        23 + descriptorOffset,
        Hoisted.payorSer,
        value.payor,
      )
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        24 + descriptorOffset,
        Hoisted.classSer,
        value.`class`,
      )
    ((value.order?.value))?.let { encoder.encodeIntElement(descriptor, 25 + descriptorOffset, it) }
    (value.order?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    ((value.network?.value))?.let {
      encoder.encodeStringElement(descriptor, 27 + descriptorOffset, it)
    }
    (value.network?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.costToBeneficiary.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        29 + descriptorOffset,
        Hoisted.costToBeneficiarySer,
        value.costToBeneficiary,
      )
    ((value.subrogation?.value))?.let {
      encoder.encodeBooleanElement(descriptor, 30 + descriptorOffset, it)
    }
    (value.subrogation?.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        31 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    if (value.contract.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        32 + descriptorOffset,
        Hoisted.payorSer,
        value.contract,
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

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val policyHolderSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val payorSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.policyHolderSer)

    public val classSerInner: KSerializer<Coverage.Class> = Coverage.Class.serializer()

    public val classSer: KSerializer<List<Coverage.Class>> = ListSerializer(Hoisted.classSerInner)

    public val costToBeneficiarySerInner: KSerializer<Coverage.CostToBeneficiary> =
      Coverage.CostToBeneficiary.serializer()

    public val costToBeneficiarySer: KSerializer<List<Coverage.CostToBeneficiary>> =
      ListSerializer(Hoisted.costToBeneficiarySerInner)
  }
}

internal object CoveragePolymorphicSerializer : KSerializer<Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") { CoverageSerializer.buildDescriptor(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage) {
    encoder.encodeStructure(descriptor) {
      CoverageSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): Coverage =
    decoder.decodeStructure(descriptor) {
      CoverageSerializer.deserializeInternal(this, descriptor, 0)
    }
}
