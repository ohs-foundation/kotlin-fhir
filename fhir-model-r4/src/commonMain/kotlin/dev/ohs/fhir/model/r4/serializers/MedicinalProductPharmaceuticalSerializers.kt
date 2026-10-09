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

package dev.ohs.fhir.model.r4.serializers

import dev.ohs.fhir.model.r4.Code
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Duration
import dev.ohs.fhir.model.r4.Element
import dev.ohs.fhir.model.r4.Extension
import dev.ohs.fhir.model.r4.FhirResourceSerializer
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.MedicinalProductPharmaceutical
import dev.ohs.fhir.model.r4.Meta
import dev.ohs.fhir.model.r4.Narrative
import dev.ohs.fhir.model.r4.Quantity
import dev.ohs.fhir.model.r4.Ratio
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.Uri
import kotlin.Int
import kotlin.OptIn
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.jvm.JvmField
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.listSerialDescriptor
import kotlinx.serialization.encoding.CompositeDecoder
import kotlinx.serialization.encoding.CompositeEncoder
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

internal object MedicinalProductPharmaceuticalCharacteristicsSerializer :
  FhirSerializer<MedicinalProductPharmaceutical.Characteristics> {
  override val descriptor: SerialDescriptor = buildDescriptor("Characteristics", this)

  @JvmField
  internal val listSerializer: KSerializer<List<MedicinalProductPharmaceutical.Characteristics>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("status", CodeableConceptSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.Characteristics {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var status: CodeableConcept? = null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          status =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPharmaceutical.Characteristics(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "MedicinalProductPharmaceutical.Characteristics", "code"),
      status = status,
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      4,
      CodeableConceptSerializer,
      value.status,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationSerializer :
  FhirSerializer<MedicinalProductPharmaceutical.RouteOfAdministration> {
  override val descriptor: SerialDescriptor = buildDescriptor("RouteOfAdministration", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement("firstDose", QuantitySerializer.descriptor)
    b.optionalElement("maxSingleDose", QuantitySerializer.descriptor)
    b.optionalElement("maxDosePerDay", QuantitySerializer.descriptor)
    b.optionalElement("maxDosePerTreatmentPeriod", RatioSerializer.descriptor)
    b.optionalElement("maxTreatmentPeriod", DurationSerializer.descriptor)
    b.optionalElement(
      "targetSpecies",
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer.listSerializer
        .descriptor,
    )
  }

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.RouteOfAdministration {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          firstDose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 ->
          maxSingleDose =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        6 ->
          maxDosePerDay =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        7 ->
          maxDosePerTreatmentPeriod =
            compositeDecoder.decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
        8 ->
          maxTreatmentPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              DurationSerializer,
              null,
            )
        9 ->
          targetSpecies =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer
                .listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPharmaceutical.RouteOfAdministration(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code = required(code, "MedicinalProductPharmaceutical.RouteOfAdministration", "code"),
      firstDose = firstDose,
      maxSingleDose = maxSingleDose,
      maxDosePerDay = maxDosePerDay,
      maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod,
      maxTreatmentPeriod = maxTreatmentPeriod,
      targetSpecies = listOrEmpty(targetSpecies),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.firstDose)
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      5,
      QuantitySerializer,
      value.maxSingleDose,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      6,
      QuantitySerializer,
      value.maxDosePerDay,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      7,
      RatioSerializer,
      value.maxDosePerTreatmentPeriod,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      8,
      DurationSerializer,
      value.maxTreatmentPeriod,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9,
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer.listSerializer,
      value.targetSpecies,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer :
  FhirSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies> {
  override val descriptor: SerialDescriptor = buildDescriptor("TargetSpecies", this)

  @JvmField
  internal val listSerializer:
    KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies>> =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("code", CodeableConceptSerializer.descriptor)
    b.optionalElement(
      "withdrawalPeriod",
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
        .listSerializer
        .descriptor,
    )
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var withdrawalPeriod:
      List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
      null
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
          code =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          withdrawalPeriod =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
                .listSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      code =
        required(
          code,
          "MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies",
          "code",
        ),
      withdrawalPeriod = listOrEmpty(withdrawalPeriod),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      4,
      MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
        .listSerializer,
      value.withdrawalPeriod,
    )
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  FhirSerializer<
    MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
  > {
  override val descriptor: SerialDescriptor = buildDescriptor("WithdrawalPeriod", this)

  @JvmField
  internal val listSerializer:
    KSerializer<
      List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>
    > =
    ListSerializer(this)

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("tissue", CodeableConceptSerializer.descriptor)
    b.optionalElement("value", QuantitySerializer.descriptor)
    b.strPrim("supportingInformation")
  }

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod {
    val descriptor = this.descriptor
    val compositeDecoder = decoder.beginStructure(descriptor)
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var tissue: CodeableConcept? = null
    var `value`: Quantity? = null
    var supportingInformation: KotlinString? = null
    var _supportingInformation: Element? = null
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
          tissue =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        4 ->
          `value` =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              QuantitySerializer,
              null,
            )
        5 -> supportingInformation = compositeDecoder.decodeStringElement(descriptor, i)
        6 ->
          _supportingInformation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ElementSerializer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> unknownIndex(descriptor, i)
      }
    }
    compositeDecoder.endStructure(descriptor)
    return MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
      id = id,
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      tissue =
        required(
          tissue,
          "MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod",
          "tissue",
        ),
      `value` =
        required(
          `value`,
          "MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod",
          "value",
        ),
      supportingInformation = R4String.of(supportingInformation, _supportingInformation),
    )
  }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    val descriptor = this.descriptor
    val compositeEncoder = encoder.beginStructure(descriptor)
    compositeEncoder.encodeStringIfNotNull(descriptor, 0, value.id)
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      1,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      2,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      3,
      CodeableConceptSerializer,
      value.tissue,
    )
    compositeEncoder.encodeSerializableElement(descriptor, 4, QuantitySerializer, value.`value`)
    compositeEncoder.encodeStringIfNotNull(descriptor, 5, value.supportingInformation?.value)
    compositeEncoder.encodeElementIfNotNull(descriptor, 6, value.supportingInformation)
    compositeEncoder.endStructure(descriptor)
  }
}

internal object MedicinalProductPharmaceuticalSerializer :
  FhirResourceSerializer<MedicinalProductPharmaceutical> {
  override val descriptor: SerialDescriptor =
    buildResourceDescriptor("MedicinalProductPharmaceutical")

  override fun buildDescriptor(b: ClassSerialDescriptorBuilder) {
    b.str("id")
    b.optionalElement("meta", MetaSerializer.descriptor)
    b.strPrim("implicitRules")
    b.strPrim("language")
    b.optionalElement("text", NarrativeSerializer.descriptor)
    b.optionalElement(
      "contained",
      listSerialDescriptor(lazyDescriptor(LazyDescriptorId.ResourcePolymorphicSerializer)),
    )
    b.optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
    b.optionalElement("identifier", IdentifierSerializer.listSerializer.descriptor)
    b.optionalElement("administrableDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("unitOfPresentation", CodeableConceptSerializer.descriptor)
    b.optionalElement("ingredient", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement(
      "characteristics",
      MedicinalProductPharmaceuticalCharacteristicsSerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "routeOfAdministration",
      MedicinalProductPharmaceuticalRouteOfAdministrationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    compositeDecoder: CompositeDecoder,
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
        11 ->
          administrableDoseForm =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          unitOfPresentation =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          ingredient =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          device =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          characteristics =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalCharacteristicsSerializer.listSerializer,
              null,
            )
        16 ->
          routeOfAdministration =
            compositeDecoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalRouteOfAdministrationSerializer.listSerializer,
              null,
            )
        else -> unknownIndex(descriptor, i)
      }
    }
    return MedicinalProductPharmaceutical(
      id = id,
      meta = meta,
      implicitRules = Uri.of(implicitRules, _implicitRules),
      language = Code.of(language, _language),
      text = text,
      contained = listOrEmpty(contained),
      extension = listOrEmpty(extension),
      modifierExtension = listOrEmpty(modifierExtension),
      identifier = listOrEmpty(identifier),
      administrableDoseForm =
        required(administrableDoseForm, "MedicinalProductPharmaceutical", "administrableDoseForm"),
      unitOfPresentation = unitOfPresentation,
      ingredient = listOrEmpty(ingredient),
      device = listOrEmpty(device),
      characteristics = listOrEmpty(characteristics),
      routeOfAdministration = listOrEmpty(routeOfAdministration),
    )
  }

  override fun serializeInternal(
    compositeEncoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPharmaceutical,
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
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      7 + descriptorOffset,
      ResourcePolymorphicSerializer.listSerializer,
      value.contained,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      8 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.extension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      9 + descriptorOffset,
      ExtensionSerializer.listSerializer,
      value.modifierExtension,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      10 + descriptorOffset,
      IdentifierSerializer.listSerializer,
      value.identifier,
    )
    compositeEncoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.administrableDoseForm,
    )
    compositeEncoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.unitOfPresentation,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      13 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.ingredient,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      14 + descriptorOffset,
      ReferenceSerializer.listSerializer,
      value.device,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      15 + descriptorOffset,
      MedicinalProductPharmaceuticalCharacteristicsSerializer.listSerializer,
      value.characteristics,
    )
    compositeEncoder.encodeListIfNotEmpty(
      descriptor,
      16 + descriptorOffset,
      MedicinalProductPharmaceuticalRouteOfAdministrationSerializer.listSerializer,
      value.routeOfAdministration,
    )
  }
}
