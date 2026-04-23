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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.Characteristics {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var status: CodeableConcept? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 -> status = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.codeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Characteristics: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.codeSer, it) }
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          firstDose =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.firstDoseSer, null)
        5 ->
          maxSingleDose =
            decoder.decodeNullableSerializableElement(__desc, 5, Hoisted.firstDoseSer, null)
        6 ->
          maxDosePerDay =
            decoder.decodeNullableSerializableElement(__desc, 6, Hoisted.firstDoseSer, null)
        7 ->
          maxDosePerTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              7,
              Hoisted.maxDosePerTreatmentPeriodSer,
              null,
            )
        8 ->
          maxTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              8,
              Hoisted.maxTreatmentPeriodSer,
              null,
            )
        9 ->
          targetSpecies =
            decoder.decodeNullableSerializableElement(__desc, 9, Hoisted.targetSpeciesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RouteOfAdministration: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    (value.firstDose)?.let {
      encoder.encodeSerializableElement(__desc, 4, Hoisted.firstDoseSer, it)
    }
    (value.maxSingleDose)?.let {
      encoder.encodeSerializableElement(__desc, 5, Hoisted.firstDoseSer, it)
    }
    (value.maxDosePerDay)?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.firstDoseSer, it)
    }
    (value.maxDosePerTreatmentPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 7, Hoisted.maxDosePerTreatmentPeriodSer, it)
    }
    (value.maxTreatmentPeriod)?.let {
      encoder.encodeSerializableElement(__desc, 8, Hoisted.maxTreatmentPeriodSer, it)
    }
    if (value.targetSpecies.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 9, Hoisted.targetSpeciesSer, value.targetSpecies)
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var withdrawalPeriod:
      List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
      null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.codeSer, null)
        4 ->
          withdrawalPeriod =
            decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.withdrawalPeriodSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TargetSpecies: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.code)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.codeSer, it) }
    if (value.withdrawalPeriod.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var tissue: CodeableConcept? = null
    var `value`: Quantity? = null
    var supportingInformation: KotlinString? = null
    var _supportingInformation: Element? = null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, 0)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, 1, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, 2, Hoisted.extensionSer, null)
        3 -> tissue = decoder.decodeNullableSerializableElement(__desc, 3, Hoisted.tissueSer, null)
        4 -> `value` = decoder.decodeNullableSerializableElement(__desc, 4, Hoisted.valueSer, null)
        5 -> supportingInformation = decoder.decodeStringElement(__desc, 5)
        6 ->
          _supportingInformation =
            decoder.decodeNullableSerializableElement(
              __desc,
              6,
              Hoisted.supportingInformationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WithdrawalPeriod: " + __i)
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

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.tissue)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.tissueSer, it) }
    (value.`value`)?.let { encoder.encodeSerializableElement(__desc, 4, Hoisted.valueSer, it) }
    ((value.supportingInformation?.value))?.let { encoder.encodeStringElement(__desc, 5, it) }
    (value.supportingInformation?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 6, Hoisted.supportingInformationSer, it)
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
      element("administrableDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
      element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
      element(
        "ingredient",
        listSerialDescriptor(Reference.serializer().descriptor),
        isOptional = true,
      )
      element("device", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
      element(
        "characteristics",
        listSerialDescriptor(
          lazyDescriptor { MedicinalProductPharmaceutical.Characteristics.serializer().descriptor }
        ),
        isOptional = true,
      )
      element(
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
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: MedicinalProductPharmaceutical) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  internal fun deserializeJson(decoder: CompositeDecoder): MedicinalProductPharmaceutical {
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
    var administrableDoseForm: CodeableConcept? = null
    var unitOfPresentation: CodeableConcept? = null
    var ingredient: List<Reference>? = null
    var device: List<Reference>? = null
    var characteristics: List<MedicinalProductPharmaceutical.Characteristics>? = null
    var routeOfAdministration: List<MedicinalProductPharmaceutical.RouteOfAdministration>? = null
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
        12 ->
          administrableDoseForm =
            decoder.decodeNullableSerializableElement(
              __desc,
              12,
              Hoisted.administrableDoseFormSer,
              null,
            )
        13 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              13,
              Hoisted.administrableDoseFormSer,
              null,
            )
        14 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, 14, Hoisted.ingredientSer, null)
        15 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, 15, Hoisted.ingredientSer, null)
        16 ->
          characteristics =
            decoder.decodeNullableSerializableElement(__desc, 16, Hoisted.characteristicsSer, null)
        17 ->
          routeOfAdministration =
            decoder.decodeNullableSerializableElement(
              __desc,
              17,
              Hoisted.routeOfAdministrationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException(
            "Unexpected index decoding MedicinalProductPharmaceutical: " + __i
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

  private fun serializeJson(encoder: CompositeEncoder, `value`: MedicinalProductPharmaceutical) {
    val __desc = descriptor
    encoder.encodeStringElement(__desc, 0, "MedicinalProductPharmaceutical")
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
    (value.administrableDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 12, Hoisted.administrableDoseFormSer, it)
    }
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(__desc, 13, Hoisted.administrableDoseFormSer, it)
    }
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 14, Hoisted.ingredientSer, value.ingredient)
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 15, Hoisted.ingredientSer, value.device)
    if (value.characteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        16,
        Hoisted.characteristicsSer,
        value.characteristics,
      )
    if (value.routeOfAdministration.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        17,
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
