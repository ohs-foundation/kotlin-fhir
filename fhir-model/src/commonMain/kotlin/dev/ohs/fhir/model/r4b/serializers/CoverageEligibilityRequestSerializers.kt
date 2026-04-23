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

package dev.ohs.fhir.model.r4b.serializers

import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.CoverageEligibilityRequest
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.DateTime
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirDateTime
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

internal object CoverageEligibilityRequestSupportingInfoSerializer :
  KSerializer<CoverageEligibilityRequest.SupportingInfo> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("SupportingInfo") {
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
      element("sequence", Int.serializer().descriptor, isOptional = true)
      element("_sequence", Element.serializer().descriptor, isOptional = true)
      element("information", Reference.serializer().descriptor, isOptional = true)
      element("appliesToAll", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_appliesToAll", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.SupportingInfo =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CoverageEligibilityRequest.SupportingInfo {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var information: Reference? = null
    var appliesToAll: KotlinBoolean? = null
    var _appliesToAll: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(__desc, 3)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.sequenceSer, null)
        5 ->
          information =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.informationSer, null)
        6 -> appliesToAll = decoder.decodeBooleanElement(__desc, 6)
        7 ->
          _appliesToAll =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.sequenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + __i)
      }
    }
    return CoverageEligibilityRequest.SupportingInfo(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      sequence = PositiveInt.of(sequence, _sequence)!!,
      information = information!!,
      appliesToAll = R4bBoolean.of(appliesToAll, _appliesToAll),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.SupportingInfo,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.sequence.value))?.let { encoder.encodeIntElement(__desc, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.sequenceSer, it)
    }
    (value.information)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.informationSer, it)
    }
    ((value.appliesToAll?.value))?.let { encoder.encodeBooleanElement(__desc, 6, it) }
    (value.appliesToAll?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.sequenceSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val sequenceSer: KSerializer<Element> = Element.serializer()

    public val informationSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CoverageEligibilityRequestInsuranceSerializer :
  KSerializer<CoverageEligibilityRequest.Insurance> {
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
      element("focal", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_focal", Element.serializer().descriptor, isOptional = true)
      element("coverage", Reference.serializer().descriptor, isOptional = true)
      element("businessArrangement", KotlinString.serializer().descriptor, isOptional = true)
      element("_businessArrangement", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Insurance =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Insurance) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityRequest.Insurance {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var businessArrangement: KotlinString? = null
    var _businessArrangement: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> focal = decoder.decodeBooleanElement(__desc, 3)
        4 -> _focal = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.focalSer, null)
        5 ->
          coverage = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.coverageSer, null)
        6 -> businessArrangement = decoder.decodeStringElement(__desc, 6)
        7 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.focalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + __i)
      }
    }
    return CoverageEligibilityRequest.Insurance(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      focal = R4bBoolean.of(focal, _focal),
      coverage = coverage!!,
      businessArrangement = R4bString.of(businessArrangement, _businessArrangement),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.Insurance,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    ((value.focal?.value))?.let { encoder.encodeBooleanElement(__desc, 3, it) }
    (value.focal?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.focalSer, it)
    }
    (value.coverage)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.coverageSer, it) }
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(__desc, 6, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.focalSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val focalSer: KSerializer<Element> = Element.serializer()

    public val coverageSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CoverageEligibilityRequestItemSerializer :
  KSerializer<CoverageEligibilityRequest.Item> {
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
      element(
        "supportingInfoSequence",
        listSerialDescriptor(Int.serializer().descriptor),
        isOptional = true,
      )
      element(
        "_supportingInfoSequence",
        listSerialDescriptor(Element.serializer().descriptor),
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
      element("quantity", Quantity.serializer().descriptor, isOptional = true)
      element("unitPrice", Money.serializer().descriptor, isOptional = true)
      element("facility", Reference.serializer().descriptor, isOptional = true)
      element(
        "diagnosis",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityRequest.Item.Diagnosis.serializer().descriptor }
        ),
        isOptional = true,
      )
      element("detail", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityRequest.Item {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 ->
          supportingInfoSequence =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.supportingInfoSequenceSer,
              null,
            )
        4 ->
          _supportingInfoSequence =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.supportingInfoSequenceSer2,
              null,
            )
        5 ->
          category = decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.categorySer, null)
        6 ->
          productOrService =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.categorySer, null)
        7 ->
          modifier = decoder.decodeNullableSerializableElement(__desc, 7, Hoisted.modifierSer, null)
        8 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 8, Hoisted.providerSer, null)
        9 ->
          quantity = decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(__desc, 10, Hoisted.unitPriceSer, null)
        11 ->
          facility =
            decoder.decodeNullableSerializableElement(__desc, 11, Hoisted.providerSer, null)
        12 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(__desc, 12, Hoisted.diagnosisSer, null)
        13 ->
          detail = decoder.decodeNullableSerializableElement(__desc, 13, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + __i)
      }
    }
    return CoverageEligibilityRequest.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      supportingInfoSequence =
        (kotlin.collections.List(
          maxOf(supportingInfoSequence?.size ?: 0, _supportingInfoSequence?.size ?: 0)
        ) { __i ->
          PositiveInt.of(
            supportingInfoSequence?.getOrNull(__i)?.let { it },
            _supportingInfoSequence?.getOrNull(__i),
          )!!
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: CoverageEligibilityRequest.Item) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.supportingInfoSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 3, Hoisted.supportingInfoSequenceSer, it)
    }
    (value.supportingInfoSequence.map { it.toElement() }.takeUnless { it.all { it == null } })
      ?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.supportingInfoSequenceSer2, it) }
    (value.category)?.let { encoder.encodeSerializableElement(__desc, 5, Hoisted.categorySer, it) }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.categorySer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7, Hoisted.modifierSer, value.modifier)
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 8, Hoisted.providerSer, it) }
    (value.quantity)?.let { encoder.encodeSerializableElement(__desc, 9, Hoisted.quantitySer, it) }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(__desc, 10, Hoisted.unitPriceSer, it)
    }
    (value.facility)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.providerSer, it) }
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 12, Hoisted.diagnosisSer, value.diagnosis)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13, Hoisted.detailSer, value.detail)
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val supportingInfoSequenceSerInner: KSerializer<Int> = Int.serializer()

    public val supportingInfoSequenceSer: KSerializer<List<Int?>> =
      ListSerializer((Hoisted.supportingInfoSequenceSerInner).nullable)

    public val supportingInfoSequenceSerInner2: KSerializer<Element> = Element.serializer()

    public val supportingInfoSequenceSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.supportingInfoSequenceSerInner2).nullable)

    public val categorySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val modifierSer: KSerializer<List<CodeableConcept>> = ListSerializer(Hoisted.categorySer)

    public val providerSer: KSerializer<Reference> = Reference.serializer()

    public val quantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val unitPriceSer: KSerializer<Money> = Money.serializer()

    public val diagnosisSerInner: KSerializer<CoverageEligibilityRequest.Item.Diagnosis> =
      CoverageEligibilityRequest.Item.Diagnosis.serializer()

    public val diagnosisSer: KSerializer<List<CoverageEligibilityRequest.Item.Diagnosis>> =
      ListSerializer(Hoisted.diagnosisSerInner)

    public val detailSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.providerSer)
  }
}

internal object CoverageEligibilityRequestItemDiagnosisSerializer :
  KSerializer<CoverageEligibilityRequest.Item.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Diagnosis") {
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
        "diagnosisCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("diagnosisReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item.Diagnosis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item.Diagnosis) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): CoverageEligibilityRequest.Item.Diagnosis {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diagnosisCodeableConcept: CodeableConcept? = null
    var diagnosisReference: Reference? = null
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
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              3,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        4 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              4,
              Hoisted.diagnosisReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + __i)
      }
    }
    return CoverageEligibilityRequest.Item.Diagnosis(
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.Item.Diagnosis,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    when (val __d = value.diagnosis) {
      null -> {}
      is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 3, Hoisted.diagnosisCodeableConceptSer, __d.value)
      }
      is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.diagnosisReferenceSer, __d.value)
      }
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val diagnosisCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val diagnosisReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CoverageEligibilityRequestServicedSerializer :
  KSerializer<CoverageEligibilityRequest.Serviced> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityRequest.Serviced") {
      element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_servicedDate", Element.serializer().descriptor, isOptional = true)
      element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Serviced) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is CoverageEligibilityRequest.Serviced.Date -> {
          ((__d.value.value?.toString()))?.let { encodeStringElement(__desc, 0, it) }
          (__d.value.toElement())?.let {
            encodeSerializableElement(__desc, 1, Hoisted.elementSer, it)
          }
        }
        is CoverageEligibilityRequest.Serviced.Period -> {
          encodeSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Serviced =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityRequest.Serviced {
    val __desc = descriptor
    var servicedDate: KotlinString? = null
    var _servicedDate: Element? = null
    var servicedPeriod: Period? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> servicedDate = decoder.decodeStringElement(__desc, 0)
        1 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.elementSer, null)
        2 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.servicedPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding CoverageEligibilityRequest.Serviced: " + __i
          )
      }
    }
    return CoverageEligibilityRequest.Serviced.from(
      Date.of(FhirDate.fromString(servicedDate), _servicedDate),
      servicedPeriod,
    )!!
  }

  private object Hoisted {
    public val elementSer: KSerializer<Element> = Element.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()
  }
}

internal object CoverageEligibilityRequestItemDiagnosisDiagnosisSerializer :
  KSerializer<CoverageEligibilityRequest.Item.Diagnosis.Diagnosis> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityRequest.Item.Diagnosis.Diagnosis") {
      element(
        "diagnosisCodeableConcept",
        CodeableConcept.serializer().descriptor,
        isOptional = true,
      )
      element("diagnosisReference", Reference.serializer().descriptor, isOptional = true)
    }

  override fun serialize(
    encoder: Encoder,
    `value`: CoverageEligibilityRequest.Item.Diagnosis.Diagnosis,
  ) {
    encoder.encodeStructure(descriptor) {
      val __desc = descriptor
      when (val __d = value) {
        is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.CodeableConcept -> {
          encodeSerializableElement(__desc, 0, Hoisted.diagnosisCodeableConceptSer, __d.value)
        }
        is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.Reference -> {
          encodeSerializableElement(__desc, 1, Hoisted.diagnosisReferenceSer, __d.value)
        }
      }
    }
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest.Item.Diagnosis.Diagnosis =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  internal fun deserializeJson(
    decoder: CompositeDecoder
  ): CoverageEligibilityRequest.Item.Diagnosis.Diagnosis {
    val __desc = descriptor
    var diagnosisCodeableConcept: CodeableConcept? = null
    var diagnosisReference: Reference? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 ->
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              __desc,
              0,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        1 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(
              __desc,
              1,
              Hoisted.diagnosisReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding CoverageEligibilityRequest.Item.Diagnosis.Diagnosis: " + __i
          )
      }
    }
    return CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.from(
      diagnosisCodeableConcept,
      diagnosisReference,
    )!!
  }

  private object Hoisted {
    public val diagnosisCodeableConceptSer: KSerializer<CodeableConcept> =
      CodeableConcept.serializer()

    public val diagnosisReferenceSer: KSerializer<Reference> = Reference.serializer()
  }
}

internal object CoverageEligibilityRequestSerializer : KSerializer<CoverageEligibilityRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityRequest") {
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
      element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
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
      element("enterer", Reference.serializer().descriptor, isOptional = true)
      element("provider", Reference.serializer().descriptor, isOptional = true)
      element("insurer", Reference.serializer().descriptor, isOptional = true)
      element("facility", Reference.serializer().descriptor, isOptional = true)
      element(
        "supportingInfo",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityRequest.SupportingInfo.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "insurance",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityRequest.Insurance.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
        "item",
        listSerialDescriptor(
          lazyDescriptor { CoverageEligibilityRequest.Item.serializer().descriptor }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): CoverageEligibilityRequest {
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
          priority =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.prioritySer, null)
        15 ->
          purpose = decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.purposeSer, null)
        16 ->
          _purpose =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.purposeSer2, null)
        17 ->
          patient = decoder.decodeNullableSerializableElement(__desc, 17, Hoisted.patientSer, null)
        18 -> servicedDate = decoder.decodeStringElement(__desc, 18)
        19 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(__desc, 19, Hoisted.implicitRulesSer, null)
        20 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(__desc, 20, Hoisted.servicedPeriodSer, null)
        21 -> created = decoder.decodeStringElement(__desc, 21)
        22 ->
          _created =
            decoder.decodeNullableSerializableElement(__desc, 22, Hoisted.implicitRulesSer, null)
        23 ->
          enterer = decoder.decodeNullableSerializableElement(__desc, 23, Hoisted.patientSer, null)
        24 ->
          provider = decoder.decodeNullableSerializableElement(__desc, 24, Hoisted.patientSer, null)
        25 ->
          insurer = decoder.decodeNullableSerializableElement(__desc, 25, Hoisted.patientSer, null)
        26 ->
          facility = decoder.decodeNullableSerializableElement(__desc, 26, Hoisted.patientSer, null)
        27 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(__desc, 27, Hoisted.supportingInfoSer, null)
        28 ->
          insurance =
            decoder.decodeNullableSerializableElement(__desc, 28, Hoisted.insuranceSer, null)
        29 -> item = decoder.decodeNullableSerializableElement(__desc, 29, Hoisted.itemSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding CoverageEligibilityRequest: " + __i
          )
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
          CoverageEligibilityRequest.FinancialResourceStatusCodes.fromCode(status!!),
          _status,
        ),
      priority = priority,
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { __i ->
          Enumeration.of(
            CoverageEligibilityRequest.EligibilityRequestPurpose.fromCode(
              purpose?.getOrNull(__i)!!
            ),
            _purpose?.getOrNull(__i),
          )
        }),
      patient = patient!!,
      serviced =
        CoverageEligibilityRequest.Serviced.from(
          Date.of(FhirDate.fromString(servicedDate), _servicedDate),
          servicedPeriod,
        ),
      created = DateTime.of(FhirDateTime.fromString(created), _created)!!,
      enterer = enterer,
      provider = provider,
      insurer = insurer!!,
      facility = facility,
      supportingInfo = supportingInfo ?: listOf(),
      insurance = insurance ?: listOf(),
      item = item ?: listOf(),
    )
  }

  private fun serializeJson(encoder: CompositeEncoder, `value`: CoverageEligibilityRequest) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "CoverageEligibilityRequest")
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
    (value.priority)?.let { encoder.encodeSerializableElement(__desc, 14, Hoisted.prioritySer, it) }
    (value.purpose.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 15, Hoisted.purposeSer, it)
    }
    (value.purpose.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(__desc, 16, Hoisted.purposeSer2, it)
    }
    (value.patient)?.let { encoder.encodeSerializableElement(__desc, 17, Hoisted.patientSer, it) }
    when (val __d = value.serviced) {
      null -> {}
      is CoverageEligibilityRequest.Serviced.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 18, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 19, Hoisted.implicitRulesSer, it)
        }
      }
      is CoverageEligibilityRequest.Serviced.Period -> {
        encoder.encodeSerializableElement(__desc, 20, Hoisted.servicedPeriodSer, __d.value)
      }
    }
    ((value.created.value?.toString()))?.let { encoder.encodeStringElement(__desc, 21, it) }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 22, Hoisted.implicitRulesSer, it)
    }
    (value.enterer)?.let { encoder.encodeSerializableElement(__desc, 23, Hoisted.patientSer, it) }
    (value.provider)?.let { encoder.encodeSerializableElement(__desc, 24, Hoisted.patientSer, it) }
    (value.insurer)?.let { encoder.encodeSerializableElement(__desc, 25, Hoisted.patientSer, it) }
    (value.facility)?.let { encoder.encodeSerializableElement(__desc, 26, Hoisted.patientSer, it) }
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 27, Hoisted.supportingInfoSer, value.supportingInfo)
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 28, Hoisted.insuranceSer, value.insurance)
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 29, Hoisted.itemSer, value.item)
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

    public val prioritySer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val purposeSerInner: KSerializer<KotlinString> = KotlinString.serializer()

    public val purposeSer: KSerializer<List<KotlinString?>> =
      ListSerializer((Hoisted.purposeSerInner).nullable)

    public val purposeSer2: KSerializer<List<Element?>> =
      ListSerializer((Hoisted.implicitRulesSer).nullable)

    public val patientSer: KSerializer<Reference> = Reference.serializer()

    public val servicedPeriodSer: KSerializer<Period> = Period.serializer()

    public val supportingInfoSerInner: KSerializer<CoverageEligibilityRequest.SupportingInfo> =
      CoverageEligibilityRequest.SupportingInfo.serializer()

    public val supportingInfoSer: KSerializer<List<CoverageEligibilityRequest.SupportingInfo>> =
      ListSerializer(Hoisted.supportingInfoSerInner)

    public val insuranceSerInner: KSerializer<CoverageEligibilityRequest.Insurance> =
      CoverageEligibilityRequest.Insurance.serializer()

    public val insuranceSer: KSerializer<List<CoverageEligibilityRequest.Insurance>> =
      ListSerializer(Hoisted.insuranceSerInner)

    public val itemSerInner: KSerializer<CoverageEligibilityRequest.Item> =
      CoverageEligibilityRequest.Item.serializer()

    public val itemSer: KSerializer<List<CoverageEligibilityRequest.Item>> =
      ListSerializer(Hoisted.itemSerInner)
  }
}
