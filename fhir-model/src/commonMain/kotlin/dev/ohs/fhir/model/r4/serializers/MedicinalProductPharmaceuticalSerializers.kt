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

@file:OptIn(ExperimentalSerializationApi::class)

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductPharmaceutical
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
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

internal object MedicinalProductPharmaceuticalCharacteristicsSerializer :
  KSerializer<MedicinalProductPharmaceutical.Characteristics> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Characteristics") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.Characteristics =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.Characteristics {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var status: CodeableConcept? = null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          status = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristics: " + i)
      }
    }
    return MedicinalProductPharmaceutical.Characteristics(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      status = status,
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    (value.status)?.let { encoder.encodeSerializableElement(descriptor, 4, Hoisted.codeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RouteOfAdministration") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element("firstDose", Quantity.serializer().descriptor, isOptional = true)
      element("maxSingleDose", Quantity.serializer().descriptor, isOptional = true)
      element("maxDosePerDay", Quantity.serializer().descriptor, isOptional = true)
      element("maxDosePerTreatmentPeriod", Ratio.serializer().descriptor, isOptional = true)
      element("maxTreatmentPeriod", Duration.serializer().descriptor, isOptional = true)
      element(
        "targetSpecies",
        listSerialDescriptor(
          lazyDescriptor {
            MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.RouteOfAdministration =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var firstDose: Quantity? = null
    var maxSingleDose: Quantity? = null
    var maxDosePerDay: Quantity? = null
    var maxDosePerTreatmentPeriod: Ratio? = null
    var maxTreatmentPeriod: Duration? = null
    var targetSpecies: List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies>? =
      null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          firstDose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.firstDoseSer, null)
        5 ->
          maxSingleDose =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.firstDoseSer, null)
        6 ->
          maxDosePerDay =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.firstDoseSer, null)
        7 ->
          maxDosePerTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maxDosePerTreatmentPeriodSer,
              null,
            )
        8 ->
          maxTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.maxTreatmentPeriodSer,
              null,
            )
        9 ->
          targetSpecies =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.targetSpeciesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RouteOfAdministration: " + i)
      }
    }
    return MedicinalProductPharmaceutical.RouteOfAdministration(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      firstDose = firstDose,
      maxSingleDose = maxSingleDose,
      maxDosePerDay = maxDosePerDay,
      maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod,
      maxTreatmentPeriod = maxTreatmentPeriod,
      targetSpecies = targetSpecies ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    (value.firstDose)?.let {
      encoder.encodeSerializableElement(descriptor, 4, Hoisted.firstDoseSer, it)
    }
    (value.maxSingleDose)?.let {
      encoder.encodeSerializableElement(descriptor, 5, Hoisted.firstDoseSer, it)
    }
    (value.maxDosePerDay)?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.firstDoseSer, it)
    }
    (value.maxDosePerTreatmentPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 7, Hoisted.maxDosePerTreatmentPeriodSer, it)
    }
    (value.maxTreatmentPeriod)?.let {
      encoder.encodeSerializableElement(descriptor, 8, Hoisted.maxTreatmentPeriodSer, it)
    }
    if (value.targetSpecies.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        9,
        Hoisted.targetSpeciesSer,
        value.targetSpecies,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val firstDoseSer: KSerializer<Quantity> = Quantity.serializer()

    public val maxDosePerTreatmentPeriodSer: KSerializer<Ratio> = Ratio.serializer()

    public val maxTreatmentPeriodSer: KSerializer<Duration> = Duration.serializer()

    public val targetSpeciesSerInner:
      KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies> =
      MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.serializer()

    public val targetSpeciesSer:
      KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies>> =
      ListSerializer(Hoisted.targetSpeciesSerInner)
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TargetSpecies") {
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
      element("code", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "withdrawalPeriod",
        listSerialDescriptor(
          lazyDescriptor {
            MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
              .serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var withdrawalPeriod:
      List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
      null
    while (true) {
      when (val i = decoder.decodeElementIndex(descriptor)) {
        0 -> id = decoder.decodeStringElement(descriptor, i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.codeSer, null)
        4 ->
          withdrawalPeriod =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.withdrawalPeriodSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TargetSpecies: " + i)
      }
    }
    return MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      withdrawalPeriod = withdrawalPeriod ?: listOf(),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.codeSer, value.code)
    if (value.withdrawalPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        4,
        Hoisted.withdrawalPeriodSer,
        value.withdrawalPeriod,
      )
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val codeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val withdrawalPeriodSerInner:
      KSerializer<
        MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
      > =
      MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
        .serializer()

    public val withdrawalPeriodSer:
      KSerializer<
        List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>
      > =
      ListSerializer(Hoisted.withdrawalPeriodSerInner)
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WithdrawalPeriod") {
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
      element("tissue", CodeableConcept.serializer().descriptor, isOptional = true)
      element("value", Quantity.serializer().descriptor, isOptional = true)
      element("supportingInformation", KotlinString.serializer().descriptor, isOptional = true)
      element("_supportingInformation", Element.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
    decoder.decodeStructure(descriptor) { deserializeInternal(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    encoder.encodeStructure(descriptor) { serializeInternal(this, value) }
  }

  private fun deserializeInternal(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod {
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var tissue: CodeableConcept? = null
    var `value`: Quantity? = null
    var supportingInformation: KotlinString? = null
    var _supportingInformation: Element? = null
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
          tissue = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.tissueSer, null)
        4 ->
          `value` = decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.valueSer, null)
        5 -> supportingInformation = decoder.decodeStringElement(descriptor, i)
        6 ->
          _supportingInformation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.supportingInformationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WithdrawalPeriod: " + i)
      }
    }
    return MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      tissue = tissue!!,
      `value` = `value`!!,
      supportingInformation = R4String.of(supportingInformation, _supportingInformation),
    )
  }

  private fun serializeInternal(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
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
    encoder.encodeSerializableElement(descriptor, 3, Hoisted.tissueSer, value.tissue)
    encoder.encodeSerializableElement(descriptor, 4, Hoisted.valueSer, value.`value`)
    ((value.supportingInformation?.value))?.let { encoder.encodeStringElement(descriptor, 5, it) }
    (value.supportingInformation?.toElement())?.let {
      encoder.encodeSerializableElement(descriptor, 6, Hoisted.supportingInformationSer, it)
    }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val tissueSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueSer: KSerializer<Quantity> = Quantity.serializer()

    public val supportingInformationSer: KSerializer<Element> = Element.serializer()
  }
}

internal object MedicinalProductPharmaceuticalSerializer :
  KSerializer<MedicinalProductPharmaceutical> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductPharmaceutical") {
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
    b.element("administrableDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "ingredient",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element(
      "characteristics",
      listSerialDescriptor(
        lazyDescriptor { MedicinalProductPharmaceutical.Characteristics.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "routeOfAdministration",
      listSerialDescriptor(
        lazyDescriptor {
          MedicinalProductPharmaceutical.RouteOfAdministration.serializer().descriptor
        }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical =
    decoder.decodeStructure(descriptor) { deserializeInternal(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPharmaceutical) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "MedicinalProductPharmaceutical")
      serializeInternal(this, descriptor, 1, value)
    }
  }

  internal fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): MedicinalProductPharmaceutical {
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
    var administrableDoseForm: CodeableConcept? = null
    var unitOfPresentation: CodeableConcept? = null
    var ingredient: List<Reference>? = null
    var device: List<Reference>? = null
    var characteristics: List<MedicinalProductPharmaceutical.Characteristics>? = null
    var routeOfAdministration: List<MedicinalProductPharmaceutical.RouteOfAdministration>? = null
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
        11 ->
          administrableDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.administrableDoseFormSer,
              null,
            )
        12 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.administrableDoseFormSer,
              null,
            )
        13 ->
          ingredient =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        14 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, Hoisted.ingredientSer, null)
        15 ->
          characteristics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.characteristicsSer,
              null,
            )
        16 ->
          routeOfAdministration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              Hoisted.routeOfAdministrationSer,
              null,
            )
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductPharmaceutical: " + i
          )
      }
    }
    return MedicinalProductPharmaceutical(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = contained ?: listOf(),
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      identifier = identifier ?: listOf(),
      administrableDoseForm = administrableDoseForm!!,
      unitOfPresentation = unitOfPresentation,
      ingredient = ingredient ?: listOf(),
      device = device ?: listOf(),
      characteristics = characteristics ?: listOf(),
      routeOfAdministration = routeOfAdministration ?: listOf(),
    )
  }

  internal fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPharmaceutical,
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      Hoisted.administrableDoseFormSer,
      value.administrableDoseForm,
    )
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(
        descriptor,
        12 + descriptorOffset,
        Hoisted.administrableDoseFormSer,
        it,
      )
    }
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        Hoisted.ingredientSer,
        value.ingredient,
      )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        Hoisted.ingredientSer,
        value.device,
      )
    if (value.characteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        Hoisted.characteristicsSer,
        value.characteristics,
      )
    if (value.routeOfAdministration.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        Hoisted.routeOfAdministrationSer,
        value.routeOfAdministration,
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

    public val administrableDoseFormSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val ingredientSerInner: KSerializer<Reference> = Reference.serializer()

    public val ingredientSer: KSerializer<List<Reference>> =
      ListSerializer(Hoisted.ingredientSerInner)

    public val characteristicsSerInner:
      KSerializer<MedicinalProductPharmaceutical.Characteristics> =
      MedicinalProductPharmaceutical.Characteristics.serializer()

    public val characteristicsSer:
      KSerializer<List<MedicinalProductPharmaceutical.Characteristics>> =
      ListSerializer(Hoisted.characteristicsSerInner)

    public val routeOfAdministrationSerInner:
      KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration> =
      MedicinalProductPharmaceutical.RouteOfAdministration.serializer()

    public val routeOfAdministrationSer:
      KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration>> =
      ListSerializer(Hoisted.routeOfAdministrationSerInner)
  }
}

internal object MedicinalProductPharmaceuticalPolymorphicSerializer :
  KSerializer<MedicinalProductPharmaceutical> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("MedicinalProductPharmaceutical") {
      MedicinalProductPharmaceuticalSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPharmaceutical) {
    encoder.encodeStructure(descriptor) {
      MedicinalProductPharmaceuticalSerializer.serializeInternal(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical =
    decoder.decodeStructure(descriptor) {
      MedicinalProductPharmaceuticalSerializer.deserializeInternal(this, descriptor, 0)
    }
}
