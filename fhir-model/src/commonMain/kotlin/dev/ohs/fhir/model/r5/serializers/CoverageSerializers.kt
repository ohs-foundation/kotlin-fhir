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

package dev.ohs.fhir.model.r5.serializers

import dev.ohs.fhir.model.r5.Boolean as R5Boolean
import dev.ohs.fhir.model.r5.Code
import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.Coverage
import dev.ohs.fhir.model.r5.Element
import dev.ohs.fhir.model.r5.Enumeration
import dev.ohs.fhir.model.r5.Extension
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.Meta
import dev.ohs.fhir.model.r5.Money
import dev.ohs.fhir.model.r5.Narrative
import dev.ohs.fhir.model.r5.Period
import dev.ohs.fhir.model.r5.PositiveInt
import dev.ohs.fhir.model.r5.Quantity
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.Uri
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.builtins.ListSerializer
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

internal object CoveragePaymentBySerializer : KSerializer<Coverage.PaymentBy> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("PaymentBy") {
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
      element("party", Reference.serializer().descriptor, isOptional = true)
      element("responsibility", KotlinString.serializer().descriptor, isOptional = true)
      element("_responsibility", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Coverage.PaymentBy =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage.PaymentBy) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Coverage.PaymentBy {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var party: Reference? = null
    var responsibility: KotlinString? = null
    var _responsibility: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> party = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.partySer, null)
        4 -> responsibility = decoder.decodeStringElement(__desc, 4)
        5 ->
          _responsibility =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.responsibilitySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding PaymentBy: " + __i)
      }
    }
    return Coverage.PaymentBy(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      party = party!!,
      responsibility = R5String.of(responsibility, _responsibility),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Coverage.PaymentBy) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.party)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.partySer, it) }
    ((value.responsibility?.value))?.let { encoder.encodeStringElement(__desc, 4, it) }
    (value.responsibility?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.responsibilitySer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val partySer: KSerializer<Reference> = Reference.serializer()

    public val responsibilitySer: KSerializer<Element> = Element.serializer()
  }
}

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
      element("value", Identifier.serializer().descriptor, isOptional = true)
      element("name", KotlinString.serializer().descriptor, isOptional = true)
      element("_name", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Coverage.Class =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage.Class) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Coverage.Class {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var `value`: Identifier? = null
    var name: KotlinString? = null
    var _name: Element? = null
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
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        5 -> name = decoder.decodeStringElement(__desc, 5)
        6 -> _name = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.nameSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Class: " + __i)
      }
    }
    return Coverage.Class(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` = `value`!!,
      name = R5String.of(name, _name),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: Coverage.Class) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.`value`)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, it) }
    ((value.name?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.name?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.nameSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Identifier> = Identifier.serializer()

    public val nameSer: KSerializer<Element> = Element.serializer()
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
      element("category", CodeableConcept.serializer().descriptor, isOptional = true)
      element("network", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unit", CodeableConcept.serializer().descriptor, isOptional = true)
      element("term", CodeableConcept.serializer().descriptor, isOptional = true)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Coverage.CostToBeneficiary {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.typeSer, null)
        4 -> category = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.typeSer, null)
        5 -> network = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.typeSer, null)
        6 -> unit = decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.typeSer, null)
        7 -> term = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.typeSer, null)
        8 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.valueQuantitySer, null)
        9 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.valueMoneySer, null)
        10 ->
          exception =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.exceptionSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding CostToBeneficiary: " + __i)
      }
    }
    return Coverage.CostToBeneficiary(
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Coverage.CostToBeneficiary) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, it) }
    (value.network)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.typeSer, it) }
    (value.unit)?.let { encoder.encodeSerializableElement(__desc, 6, Hoisted.typeSer, it) }
    (value.term)?.let { encoder.encodeSerializableElement(__desc, 7, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is Coverage.CostToBeneficiary.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 8, Hoisted.valueQuantitySer, __d.value)
      }
      is Coverage.CostToBeneficiary.Value.Money -> {
        encoder.encodeSerializableElement(__desc, 9, Hoisted.valueMoneySer, __d.value)
      }
    }
    if (value.exception.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10, Hoisted.exceptionSer, value.exception)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Exception) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): Coverage.CostToBeneficiary.Exception {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var type: CodeableConcept? = null
    var period: Period? = null
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
        4 -> period = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.periodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Exception: " + __i)
      }
    }
    return Coverage.CostToBeneficiary.Exception(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      period = period,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: Coverage.CostToBeneficiary.Exception,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.periodSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CoverageCostToBeneficiaryValueSerializer :
  KSerializer<Coverage.CostToBeneficiary.Value> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage.CostToBeneficiary.Value") {
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueMoney", Money.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: Coverage.CostToBeneficiary.Value) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is Coverage.CostToBeneficiary.Value.Quantity -> {
          encodeSerializableElement(__desc, 0, Hoisted.valueQuantitySer, __d.value)
        }
        is Coverage.CostToBeneficiary.Value.Money -> {
          encodeSerializableElement(__desc, 1, Hoisted.valueMoneySer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): Coverage.CostToBeneficiary.Value =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): Coverage.CostToBeneficiary.Value {
    val __desc = descriptor
    var valueQuantity: Quantity? = null
    var valueMoney: Money? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, 0, Hoisted.valueQuantitySer, null)
        1 ->
          valueMoney =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.valueMoneySer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding Coverage.CostToBeneficiary.Value: " + __i
          )
      }
    }
    return Coverage.CostToBeneficiary.Value.from(valueQuantity, valueMoney)!!
  }

  private object Hoisted {
    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueMoneySer: KSerializer<Money> = Money.serializer()
  }
}

internal object CoverageSerializer : KSerializer<Coverage> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Coverage") {
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
      element("kind", KotlinString.serializer().descriptor, isOptional = true)
      element("_kind", Element.serializer().descriptor, isOptional = true)
      element(
        "paymentBy",
        listSerialDescriptor(lazyDescriptor { Coverage.PaymentBy.serializer().descriptor }),
        isOptional = true,
      )
      element("type", CodeableConcept.serializer().descriptor, isOptional = true)
      element("policyHolder", Reference.serializer().descriptor, isOptional = true)
      element("subscriber", Reference.serializer().descriptor, isOptional = true)
      element(
        "subscriberId",
        listSerialDescriptor(Identifier.serializer().descriptor),
        isOptional = true,
      )
      element("beneficiary", Reference.serializer().descriptor, isOptional = true)
      element("dependent", KotlinString.serializer().descriptor, isOptional = true)
      element("_dependent", Element.serializer().descriptor, isOptional = true)
      element("relationship", CodeableConcept.serializer().descriptor, isOptional = true)
      element("period", Period.serializer().descriptor, isOptional = true)
      element("insurer", Reference.serializer().descriptor, isOptional = true)
      element(
        "class",
        listSerialDescriptor(lazyDescriptor { Coverage.Class.serializer().descriptor }),
        isOptional = true,
      )
      element("order", Int.serializer().descriptor, isOptional = true)
      element("_order", Element.serializer().descriptor, isOptional = true)
      element("network", KotlinString.serializer().descriptor, isOptional = true)
      element("_network", Element.serializer().descriptor, isOptional = true)
      element(
        "costToBeneficiary",
        listSerialDescriptor(lazyDescriptor { Coverage.CostToBeneficiary.serializer().descriptor }),
        isOptional = true,
      )
      element("subrogation", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_subrogation", Element.serializer().descriptor, isOptional = true)
      element(
        "contract",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("insurancePlan", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): Coverage =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: Coverage) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): Coverage {
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
        14 -> kind = decoder.decodeStringElement(__desc, 14)
        15 ->
          _kind =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.implicitRulesSer, null)
        16 ->
          paymentBy =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.paymentBySer, null)
        17 -> type = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.typeSer, null)
        18 ->
          policyHolder =
            decoder.decodeNullableSerializableElement(__desc, 18, Hoisted.policyHolderSer, null)
        19 ->
          subscriber =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.policyHolderSer, null)
        20 ->
          subscriberId =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.identifierSer, null)
        21 ->
          beneficiary =
            decoder.decodeNullableSerializableElement(__desc, 21, Hoisted.policyHolderSer, null)
        22 -> dependent = decoder.decodeStringElement(__desc, 22)
        23 ->
          _dependent =
            decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.implicitRulesSer, null)
        24 ->
          relationship =
            decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.typeSer, null)
        25 ->
          period = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.periodSer, null)
        26 ->
          insurer =
            decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.policyHolderSer, null)
        27 ->
          `class` = decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.classSer, null)
        28 -> order = decoder.decodeIntElement(__desc, 28)
        29 ->
          _order =
            decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.implicitRulesSer, null)
        30 -> network = decoder.decodeStringElement(__desc, 30)
        31 ->
          _network =
            decoder.decodeNullableSerializableElement(__desc, 31, Hoisted.implicitRulesSer, null)
        32 ->
          costToBeneficiary =
            decoder.decodeNullableSerializableElement(
              __desc,
              32,
              Hoisted.costToBeneficiarySer,
              null,
            )
        33 -> subrogation = decoder.decodeBooleanElement(__desc, 33)
        34 ->
          _subrogation =
            decoder.decodeNullableSerializableElement(__desc, 34, Hoisted.implicitRulesSer, null)
        35 ->
          contract =
            decoder.decodeNullableSerializableElement(__desc, 35, Hoisted.contractSer, null)
        36 ->
          insurancePlan =
            decoder.decodeNullableSerializableElement(__desc, 36, Hoisted.policyHolderSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Coverage: " + __i)
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
      status = Enumeration.of(Coverage.FinancialResourceStatusCodes.fromCode(status!!), _status),
      kind = Enumeration.of(Coverage.Kind.fromCode(kind!!), _kind),
      paymentBy = paymentBy ?: listOf(),
      type = type,
      policyHolder = policyHolder,
      subscriber = subscriber,
      subscriberId = subscriberId ?: listOf(),
      beneficiary = beneficiary!!,
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: Coverage) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "Coverage")
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
    ((value.kind.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 14, it) }
    (value.kind.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.implicitRulesSer, it)
    }
    if (value.paymentBy.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16, Hoisted.paymentBySer, value.paymentBy)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.typeSer, it) }
    (value.policyHolder)?.let {
      encoder.encodeSerializableElement(__desc, 18, Hoisted.policyHolderSer, it)
    }
    (value.subscriber)?.let {
      encoder.encodeSerializableElement(__desc, 19, Hoisted.policyHolderSer, it)
    }
    if (value.subscriberId.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 20, Hoisted.identifierSer, value.subscriberId)
    (value.beneficiary)?.let {
      encoder.encodeSerializableElement(__desc, 21, Hoisted.policyHolderSer, it)
    }
    ((value.dependent?.value))?.let { encoder.encodeStringElement(__desc, 22, it) }
    (value.dependent?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 23, Hoisted.implicitRulesSer, it)
    }
    (value.relationship)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.typeSer, it) }
    (value.period)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.periodSer, it) }
    (value.insurer)?.let {
      encoder.encodeSerializableElement(__desc, 26, Hoisted.policyHolderSer, it)
    }
    if (value.`class`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.classSer, value.`class`)
    ((value.order?.value))?.let { encoder.encodeIntElement(__desc, 28, it) }
    (value.order?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 29, Hoisted.implicitRulesSer, it)
    }
    ((value.network?.value))?.let { encoder.encodeStringElement(__desc, 30, it) }
    (value.network?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 31, Hoisted.implicitRulesSer, it)
    }
    if (value.costToBeneficiary.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        32,
        Hoisted.costToBeneficiarySer,
        value.costToBeneficiary,
      )
    ((value.subrogation?.value))?.let { encoder.encodeBooleanElement(__desc, 33, it) }
    (value.subrogation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 34, Hoisted.implicitRulesSer, it)
    }
    if (value.contract.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 35, Hoisted.contractSer, value.contract)
    (value.insurancePlan)?.let {
      encoder.encodeSerializableElement(__desc, 36, Hoisted.policyHolderSer, it)
    }
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

    public val paymentBySerInner: KSerializer<Coverage.PaymentBy> = Coverage.PaymentBy.serializer()

    public val paymentBySer: KSerializer<List<Coverage.PaymentBy>> =
      ListSerializer(Hoisted.paymentBySerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val policyHolderSer: KSerializer<Reference> = Reference.serializer()

    public val periodSer: KSerializer<Period> = Period.serializer()

    public val classSerInner: KSerializer<Coverage.Class> = Coverage.Class.serializer()

    public val classSer: KSerializer<List<Coverage.Class>> = ListSerializer(Hoisted.classSerInner)

    public val costToBeneficiarySerInner: KSerializer<Coverage.CostToBeneficiary> =
      Coverage.CostToBeneficiary.serializer()

    public val costToBeneficiarySer: KSerializer<List<Coverage.CostToBeneficiary>> =
      ListSerializer(Hoisted.costToBeneficiarySerInner)

    public val contractSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.policyHolderSer)
  }
}
