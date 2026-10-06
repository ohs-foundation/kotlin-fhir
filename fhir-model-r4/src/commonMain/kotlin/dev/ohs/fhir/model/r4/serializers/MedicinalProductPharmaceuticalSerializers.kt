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
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<MedicinalProductPharmaceutical.Characteristics>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.Characteristics =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var status: CodeableConcept? = null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Characteristics: " + i)
        }
      }
      MedicinalProductPharmaceutical.Characteristics(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicinalProductPharmaceutical.Characteristics"
            ),
        status = status,
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.Characteristics,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, CodeableConceptSerializer, value.status)
    }
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("RouteOfAdministration") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement("firstDose", QuantitySerializer.descriptor)
      optionalElement("maxSingleDose", QuantitySerializer.descriptor)
      optionalElement("maxDosePerDay", QuantitySerializer.descriptor)
      optionalElement("maxDosePerTreatmentPeriod", RatioSerializer.descriptor)
      optionalElement("maxTreatmentPeriod", DurationSerializer.descriptor)
      optionalElement(
        "targetSpecies",
        MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer.listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): MedicinalProductPharmaceutical.RouteOfAdministration =
    decoder.decodeStructure(descriptor) {
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            firstDose = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 ->
            maxSingleDose =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 ->
            maxDosePerDay =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          7 ->
            maxDosePerTreatmentPeriod =
              decodeNullableSerializableElement(descriptor, i, RatioSerializer, null)
          8 ->
            maxTreatmentPeriod =
              decodeNullableSerializableElement(descriptor, i, DurationSerializer, null)
          9 ->
            targetSpecies =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding RouteOfAdministration: " + i)
        }
      }
      MedicinalProductPharmaceutical.RouteOfAdministration(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicinalProductPharmaceutical.RouteOfAdministration"
            ),
        firstDose = firstDose,
        maxSingleDose = maxSingleDose,
        maxDosePerDay = maxDosePerDay,
        maxDosePerTreatmentPeriod = maxDosePerTreatmentPeriod,
        maxTreatmentPeriod = maxTreatmentPeriod,
        targetSpecies = targetSpecies ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      encodeSerializableIfNotNull(descriptor, 4, QuantitySerializer, value.firstDose)
      encodeSerializableIfNotNull(descriptor, 5, QuantitySerializer, value.maxSingleDose)
      encodeSerializableIfNotNull(descriptor, 6, QuantitySerializer, value.maxDosePerDay)
      encodeSerializableIfNotNull(descriptor, 7, RatioSerializer, value.maxDosePerTreatmentPeriod)
      encodeSerializableIfNotNull(descriptor, 8, DurationSerializer, value.maxTreatmentPeriod)
      if (value.targetSpecies.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          9,
          MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer.listSerializer,
          value.targetSpecies,
        )
    }
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TargetSpecies") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement(
        "withdrawalPeriod",
        MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
          .listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var withdrawalPeriod:
        List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
        null
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
            code = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            withdrawalPeriod =
              decodeNullableSerializableElement(
                descriptor,
                i,
                MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TargetSpecies: " + i)
        }
      }
      MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies"
            ),
        withdrawalPeriod = withdrawalPeriod ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.code)
      if (value.withdrawalPeriod.isNotEmpty())
        encodeSerializableElement(
          descriptor,
          4,
          MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
            .listSerializer,
          value.withdrawalPeriod,
        )
    }
  }
}

internal object MedicinalProductPharmaceuticalRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  KSerializer<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("WithdrawalPeriod") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("tissue", CodeableConceptSerializer.descriptor)
      optionalElement("value", QuantitySerializer.descriptor)
      optionalElement("supportingInformation", KotlinString.serializer().descriptor)
      optionalElement("_supportingInformation", ElementSerializer.descriptor)
    }

  internal val listSerializer:
    KSerializer<
      List<MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>
    > =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var tissue: CodeableConcept? = null
      var `value`: Quantity? = null
      var supportingInformation: KotlinString? = null
      var _supportingInformation: Element? = null
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
            tissue =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 -> `value` = decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          5 -> supportingInformation = decodeStringElement(descriptor, i)
          6 ->
            _supportingInformation =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding WithdrawalPeriod: " + i)
        }
      }
      MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        tissue =
          tissue
            ?: throw SerializationException(
              "Missing required property 'tissue' on MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod"
            ),
        `value` =
          `value`
            ?: throw SerializationException(
              "Missing required property 'value' on MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod"
            ),
        supportingInformation = R4String.of(supportingInformation, _supportingInformation),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: MedicinalProductPharmaceutical.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
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
      encodeSerializableElement(descriptor, 3, CodeableConceptSerializer, value.tissue)
      encodeSerializableElement(descriptor, 4, QuantitySerializer, value.`value`)
      encodeStringIfNotNull(descriptor, 5, value.supportingInformation?.value)
      encodeElementIfNotNull(descriptor, 6, value.supportingInformation)
    }
  }
}

internal object MedicinalProductPharmaceuticalSerializer :
  FhirResourceSerializer<MedicinalProductPharmaceutical> {
  override val descriptor: SerialDescriptor =
    buildResourceDescriptor("MedicinalProductPharmaceutical")

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
        11 ->
          administrableDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        12 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        13 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          device =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        15 ->
          characteristics =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalCharacteristicsSerializer.listSerializer,
              null,
            )
        16 ->
          routeOfAdministration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              MedicinalProductPharmaceuticalRouteOfAdministrationSerializer.listSerializer,
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
      administrableDoseForm =
        administrableDoseForm
          ?: throw SerializationException(
            "Missing required property 'administrableDoseForm' on MedicinalProductPharmaceutical"
          ),
      unitOfPresentation = unitOfPresentation,
      ingredient = ingredient ?: listOf(),
      device = device ?: listOf(),
      characteristics = characteristics ?: listOf(),
      routeOfAdministration = routeOfAdministration ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: MedicinalProductPharmaceutical,
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
    encoder.encodeSerializableElement(
      descriptor,
      11 + descriptorOffset,
      CodeableConceptSerializer,
      value.administrableDoseForm,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      12 + descriptorOffset,
      CodeableConceptSerializer,
      value.unitOfPresentation,
    )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.ingredient,
      )
    if (value.device.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        14 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.device,
      )
    if (value.characteristics.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        15 + descriptorOffset,
        MedicinalProductPharmaceuticalCharacteristicsSerializer.listSerializer,
        value.characteristics,
      )
    if (value.routeOfAdministration.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        MedicinalProductPharmaceuticalRouteOfAdministrationSerializer.listSerializer,
        value.routeOfAdministration,
      )
  }
}
