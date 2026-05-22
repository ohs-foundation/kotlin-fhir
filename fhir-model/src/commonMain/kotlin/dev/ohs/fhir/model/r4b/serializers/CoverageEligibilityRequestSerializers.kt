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
@file:OptIn(ExperimentalSerializationApi::class)

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
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.SupportingInfo) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CoverageEligibilityRequest.SupportingInfo {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var sequence: Int? = null
    var _sequence: Element? = null
    var information: Reference? = null
    var appliesToAll: KotlinBoolean? = null
    var _appliesToAll: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> sequence = decoder.decodeIntElement(descriptor, i)
        4 ->
          _sequence =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        5 ->
          information =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.informationSer, null)
        6 -> appliesToAll = decoder.decodeBooleanElement(descriptor, i)
        7 ->
          _appliesToAll =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.sequenceSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding SupportingInfo: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.SupportingInfo,
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
    ((value.sequence.value))?.let { encoder.encodeIntElement(descriptor, 3, it) }
    (value.sequence.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.sequenceSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.informationSer, value.information)
    ((value.appliesToAll?.value))?.let { encoder.encodeBooleanElement(descriptor, 6, it) }
    (value.appliesToAll?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.sequenceSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Insurance) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CoverageEligibilityRequest.Insurance {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var focal: KotlinBoolean? = null
    var _focal: Element? = null
    var coverage: Reference? = null
    var businessArrangement: KotlinString? = null
    var _businessArrangement: Element? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> focal = decoder.decodeBooleanElement(descriptor, i)
        4 ->
          _focal = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focalSer, null)
        5 ->
          coverage =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.coverageSer, null)
        6 -> businessArrangement = decoder.decodeStringElement(descriptor, i)
        7 ->
          _businessArrangement =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.focalSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Insurance: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.Insurance,
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
    ((value.focal?.value))?.let { encoder.encodeBooleanElement(descriptor, 3, it) }
    (value.focal?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.focalSer, it)
    }
    encoder.encodeSerializableElement(descriptor, 5, Hoisted.coverageSer, value.coverage)
    ((value.businessArrangement?.value))?.let { encoder.encodeStringElement(descriptor, 6, it) }
    (value.businessArrangement?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.focalSer, it)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(decoder: CompositeDecoder): CoverageEligibilityRequest.Item {
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
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 ->
          supportingInfoSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSequenceSer,
              null,
            )
        4 ->
          _supportingInfoSequence =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSequenceSer2,
              null,
            )
        5 ->
          category =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        6 ->
          productOrService =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.categorySer, null)
        7 ->
          modifier =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.modifierSer, null)
        8 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        9 ->
          quantity =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.quantitySer, null)
        10 ->
          unitPrice =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.unitPriceSer, null)
        11 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.providerSer, null)
        12 ->
          diagnosis =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.diagnosisSer, null)
        13 ->
          detail = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.detailSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Item: " + i)
      }
    }
    return CoverageEligibilityRequest.Item(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      supportingInfoSequence =
        (kotlin.collections.List(
          maxOf(supportingInfoSequence?.size ?: 0, _supportingInfoSequence?.size ?: 0)
        ) { index ->
          PositiveInt.of(
            supportingInfoSequence?.getOrNull(index)?.let { it },
            _supportingInfoSequence?.getOrNull(index),
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.Item,
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
    (value.supportingInfoSequence.map { it.value }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 3, Hoisted.supportingInfoSequenceSer, it)
    }
    (value.supportingInfoSequence.map { it.toElement() }.takeUnless { it.all { it == null } })
      ?.let {
        encoder.encodeSerializableElement(descriptor, 4, Hoisted.supportingInfoSequenceSer2, it)
      }
    (value.category)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.categorySer, it)
    }
    (value.productOrService)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.categorySer, it)
    }
    if (value.modifier.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.modifierSer, value.modifier)
    (value.provider)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.providerSer, it)
    }
    (value.quantity)?.let {
      encoder.encodeSerializableElement(descriptor, 9, Hoisted.quantitySer, it)
    }
    (value.unitPrice)?.let {
      encoder.encodeSerializableElement(descriptor, 10, Hoisted.unitPriceSer, it)
    }
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 11, Hoisted.providerSer, it)
    }
    if (value.diagnosis.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 12, Hoisted.diagnosisSer, value.diagnosis)
    if (value.detail.isNotEmpty())
      encoder.encodeSerializableElement(descriptor, 13, Hoisted.detailSer, value.detail)
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
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest.Item.Diagnosis) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): CoverageEligibilityRequest.Item.Diagnosis {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var diagnosisCodeableConcept: CodeableConcept? = null
    var diagnosisReference: Reference? = null
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
          diagnosisCodeableConcept =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diagnosisCodeableConceptSer,
              null,
            )
        4 ->
          diagnosisReference =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.diagnosisReferenceSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Diagnosis: " + i)
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

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: CoverageEligibilityRequest.Item.Diagnosis,
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
    when (val choice = value.diagnosis) {
      null -> {}
      is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.CodeableConcept -> {
        encoder.encodeSerializableElement(
          descriptor,
          3,
          Hoisted.diagnosisCodeableConceptSer,
          choice.value,
        )
      }
      is CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.Reference -> {
        encoder.encodeSerializableElement(
          descriptor,
          4,
          Hoisted.diagnosisReferenceSer,
          choice.value,
        )
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

internal object CoverageEligibilityRequestSerializer : KSerializer<CoverageEligibilityRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityRequest") {
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
    b.element("priority", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "purpose",
      listSerialDescriptor(KotlinString.serializer().descriptor),
      isOptional = true,
    )
    b.element("_purpose", listSerialDescriptor(Element.serializer().descriptor), isOptional = true)
    b.element("patient", Reference.serializer().descriptor, isOptional = true)
    b.element("servicedDate", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_servicedDate", Element.serializer().descriptor, isOptional = true)
    b.element("servicedPeriod", Period.serializer().descriptor, isOptional = true)
    b.element("created", KotlinString.serializer().descriptor, isOptional = true)
    b.element("_created", Element.serializer().descriptor, isOptional = true)
    b.element("enterer", Reference.serializer().descriptor, isOptional = true)
    b.element("provider", Reference.serializer().descriptor, isOptional = true)
    b.element("insurer", Reference.serializer().descriptor, isOptional = true)
    b.element("facility", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "supportingInfo",
      listSerialDescriptor(
        lazyDescriptor { CoverageEligibilityRequest.SupportingInfo.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "insurance",
      listSerialDescriptor(
        lazyDescriptor { CoverageEligibilityRequest.Insurance.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "item",
      listSerialDescriptor(
        lazyDescriptor { CoverageEligibilityRequest.Item.serializer().descriptor }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "CoverageEligibilityRequest")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
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
        13 ->
          priority =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.prioritySer, null)
        14 ->
          purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.purposeSer, null)
        15 ->
          _purpose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.purposeSer2, null)
        16 ->
          patient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        17 -> servicedDate = decoder.decodeStringElement(descriptor, i)
        18 ->
          _servicedDate =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        19 ->
          servicedPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.servicedPeriodSer,
              null,
            )
        20 -> created = decoder.decodeStringElement(descriptor, i)
        21 ->
          _created =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.implicitRulesSer, null)
        22 ->
          enterer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        23 ->
          provider =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        24 ->
          insurer =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        25 ->
          facility =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.patientSer, null)
        26 ->
          supportingInfo =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInfoSer,
              null,
            )
        27 ->
          insurance =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.insuranceSer, null)
        28 -> item = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.itemSer, null)
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
          CoverageEligibilityRequest.FinancialResourceStatusCodes.fromCode(status!!),
          _status,
        ),
      priority = priority,
      purpose =
        (kotlin.collections.List(maxOf(purpose?.size ?: 0, _purpose?.size ?: 0)) { index ->
          Enumeration.of(
            CoverageEligibilityRequest.EligibilityRequestPurpose.fromCode(
              purpose?.getOrNull(index)!!
            ),
            _purpose?.getOrNull(index),
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

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: CoverageEligibilityRequest,
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
    (value.priority)?.let {
      encoder.encodeSerializableElement(descriptor, 13 + descriptorOffset, Hoisted.prioritySer, it)
    }
    (value.purpose.map { it.value?.getCode() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 14 + descriptorOffset, Hoisted.purposeSer, it)
    }
    (value.purpose.map { it.toElement() }.takeUnless { it.all { it == null } })?.let {
      encoder.encodeSerializableElement(descriptor, 15 + descriptorOffset, Hoisted.purposeSer2, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      16 + descriptorOffset,
      Hoisted.patientSer,
      value.patient,
    )
    when (val choice = value.serviced) {
      null -> {}
      is CoverageEligibilityRequest.Serviced.Date -> {
        ((choice.value.value?.toString()))?.let {
          encoder.encodeStringElement(descriptor, 17 + descriptorOffset, it)
        }
        (choice.value.toElement())?.let {
          encoder.encodeSerializableElement(
            descriptor,
            18 + descriptorOffset,
            Hoisted.implicitRulesSer,
            it,
          )
        }
      }
      is CoverageEligibilityRequest.Serviced.Period -> {
        encoder.encodeSerializableElement(
          descriptor,
          19 + descriptorOffset,
          Hoisted.servicedPeriodSer,
          choice.value,
        )
      }
    }
    ((value.created.value?.toString()))?.let {
      encoder.encodeStringElement(descriptor, 20 + descriptorOffset, it)
    }
    (value.created.toElement())?.let {
      encoder.encodeSerializableElement(
        descriptor,
        21 + descriptorOffset,
        Hoisted.implicitRulesSer,
        it,
      )
    }
    (value.enterer)?.let {
      encoder.encodeSerializableElement(descriptor, 22 + descriptorOffset, Hoisted.patientSer, it)
    }
    (value.provider)?.let {
      encoder.encodeSerializableElement(descriptor, 23 + descriptorOffset, Hoisted.patientSer, it)
    }
    encoder.encodeSerializableElement(
      descriptor,
      24 + descriptorOffset,
      Hoisted.patientSer,
      value.insurer,
    )
    (value.facility)?.let {
      encoder.encodeSerializableElement(descriptor, 25 + descriptorOffset, Hoisted.patientSer, it)
    }
    if (value.supportingInfo.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        26 + descriptorOffset,
        Hoisted.supportingInfoSer,
        value.supportingInfo,
      )
    if (value.insurance.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        27 + descriptorOffset,
        Hoisted.insuranceSer,
        value.insurance,
      )
    if (value.item.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        28 + descriptorOffset,
        Hoisted.itemSer,
        value.item,
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

internal object CoverageEligibilityRequestPolymorphicSerializer :
  KSerializer<CoverageEligibilityRequest> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("CoverageEligibilityRequest") {
      CoverageEligibilityRequestSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: CoverageEligibilityRequest) {
    encoder.encodeStructure(descriptor) {
      CoverageEligibilityRequestSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): CoverageEligibilityRequest =
    decoder.decodeStructure(descriptor) {
      CoverageEligibilityRequestSerializer.deserializeInternal(this, descriptor, 0)
    }
}
