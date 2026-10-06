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

import dev.ohs.fhir.model.r4b.AdministrableProductDefinition
import dev.ohs.fhir.model.r4b.Attachment
import dev.ohs.fhir.model.r4b.Boolean as R4bBoolean
import dev.ohs.fhir.model.r4b.Code
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Date
import dev.ohs.fhir.model.r4b.Duration
import dev.ohs.fhir.model.r4b.Element
import dev.ohs.fhir.model.r4b.Enumeration
import dev.ohs.fhir.model.r4b.Extension
import dev.ohs.fhir.model.r4b.FhirDate
import dev.ohs.fhir.model.r4b.FhirResourceSerializer
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.ResourcePolymorphicSerializer
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
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

internal object AdministrableProductDefinitionPropertySerializer :
  KSerializer<AdministrableProductDefinition.Property> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("Property") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("type", CodeableConceptSerializer.descriptor)
      optionalElement("valueCodeableConcept", CodeableConceptSerializer.descriptor)
      optionalElement("valueQuantity", QuantitySerializer.descriptor)
      optionalElement("valueDate", KotlinString.serializer().descriptor)
      optionalElement("_valueDate", ElementSerializer.descriptor)
      optionalElement("valueBoolean", KotlinBoolean.serializer().descriptor)
      optionalElement("_valueBoolean", ElementSerializer.descriptor)
      optionalElement("valueAttachment", AttachmentSerializer.descriptor)
      optionalElement("status", CodeableConceptSerializer.descriptor)
    }

  internal val listSerializer: KSerializer<List<AdministrableProductDefinition.Property>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition.Property =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var type: CodeableConcept? = null
      var valueCodeableConcept: CodeableConcept? = null
      var valueQuantity: Quantity? = null
      var valueDate: KotlinString? = null
      var _valueDate: Element? = null
      var valueBoolean: KotlinBoolean? = null
      var _valueBoolean: Element? = null
      var valueAttachment: Attachment? = null
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
            type = decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          4 ->
            valueCodeableConcept =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          5 ->
            valueQuantity =
              decodeNullableSerializableElement(descriptor, i, QuantitySerializer, null)
          6 -> valueDate = decodeStringElement(descriptor, i)
          7 ->
            _valueDate = decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          8 -> valueBoolean = decodeBooleanElement(descriptor, i)
          9 ->
            _valueBoolean =
              decodeNullableSerializableElement(descriptor, i, ElementSerializer, null)
          10 ->
            valueAttachment =
              decodeNullableSerializableElement(descriptor, i, AttachmentSerializer, null)
          11 ->
            status =
              decodeNullableSerializableElement(descriptor, i, CodeableConceptSerializer, null)
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding Property: " + i)
        }
      }
      AdministrableProductDefinition.Property(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        type =
          type
            ?: throw SerializationException(
              "Missing required property 'type' on AdministrableProductDefinition.Property"
            ),
        `value` =
          AdministrableProductDefinition.Property.Value.from(
            valueCodeableConcept,
            valueQuantity,
            Date.of(if (valueDate != null) FhirDate.fromString(valueDate) else null, _valueDate),
            R4bBoolean.of(valueBoolean, _valueBoolean),
            valueAttachment,
          ),
        status = status,
      )
    }

  override fun serialize(encoder: Encoder, `value`: AdministrableProductDefinition.Property) {
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
      when (val choice = value.`value`) {
        null -> {}
        is AdministrableProductDefinition.Property.Value.CodeableConcept -> {
          encodeSerializableElement(descriptor, 4, CodeableConceptSerializer, choice.value)
        }
        is AdministrableProductDefinition.Property.Value.Quantity -> {
          encodeSerializableElement(descriptor, 5, QuantitySerializer, choice.value)
        }
        is AdministrableProductDefinition.Property.Value.Date -> {
          encodeStringIfNotNull(descriptor, 6, choice.value.value?.toString())
          encodeElementIfNotNull(descriptor, 7, choice.value)
        }
        is AdministrableProductDefinition.Property.Value.Boolean -> {
          encodeBooleanIfNotNull(descriptor, 8, choice.value.value)
          encodeElementIfNotNull(descriptor, 9, choice.value)
        }
        is AdministrableProductDefinition.Property.Value.Attachment -> {
          encodeSerializableElement(descriptor, 10, AttachmentSerializer, choice.value)
        }
      }
      encodeSerializableIfNotNull(descriptor, 11, CodeableConceptSerializer, value.status)
    }
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration> {
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
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer.listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<AdministrableProductDefinition.RouteOfAdministration>> =
    ListSerializer(this)

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition.RouteOfAdministration =
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
      var targetSpecies: List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies>? =
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
                AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else ->
            throw SerializationException("Unexpected index decoding RouteOfAdministration: " + i)
        }
      }
      AdministrableProductDefinition.RouteOfAdministration(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on AdministrableProductDefinition.RouteOfAdministration"
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
    `value`: AdministrableProductDefinition.RouteOfAdministration,
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
          AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer.listSerializer,
          value.targetSpecies,
        )
    }
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("TargetSpecies") {
      optionalElement("id", KotlinString.serializer().descriptor)
      optionalElement("extension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("modifierExtension", ExtensionSerializer.listSerializer.descriptor)
      optionalElement("code", CodeableConceptSerializer.descriptor)
      optionalElement(
        "withdrawalPeriod",
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
          .listSerializer
          .descriptor,
      )
    }

  internal val listSerializer:
    KSerializer<List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies>> =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies =
    decoder.decodeStructure(descriptor) {
      var id: KotlinString? = null
      var extension: List<Extension>? = null
      var modifierExtension: List<Extension>? = null
      var code: CodeableConcept? = null
      var withdrawalPeriod:
        List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
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
                AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
                  .listSerializer,
                null,
              )
          CompositeDecoder.DECODE_DONE -> break
          else -> throw SerializationException("Unexpected index decoding TargetSpecies: " + i)
        }
      }
      AdministrableProductDefinition.RouteOfAdministration.TargetSpecies(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        code =
          code
            ?: throw SerializationException(
              "Missing required property 'code' on AdministrableProductDefinition.RouteOfAdministration.TargetSpecies"
            ),
        withdrawalPeriod = withdrawalPeriod ?: listOf(),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies,
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
          AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer
            .listSerializer,
          value.withdrawalPeriod,
        )
    }
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod> {
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
      List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>
    > =
    ListSerializer(this)

  override fun deserialize(
    decoder: Decoder
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
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
      AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
        id = id,
        extension = extension ?: listOf(),
        modifierExtension = modifierExtension ?: listOf(),
        tissue =
          tissue
            ?: throw SerializationException(
              "Missing required property 'tissue' on AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod"
            ),
        `value` =
          `value`
            ?: throw SerializationException(
              "Missing required property 'value' on AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod"
            ),
        supportingInformation = R4bString.of(supportingInformation, _supportingInformation),
      )
    }

  override fun serialize(
    encoder: Encoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
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

internal object AdministrableProductDefinitionSerializer :
  FhirResourceSerializer<AdministrableProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildResourceDescriptor("AdministrableProductDefinition")

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
    b.optionalElement("formOf", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("administrableDoseForm", CodeableConceptSerializer.descriptor)
    b.optionalElement("unitOfPresentation", CodeableConceptSerializer.descriptor)
    b.optionalElement("producedFrom", ReferenceSerializer.listSerializer.descriptor)
    b.optionalElement("ingredient", CodeableConceptSerializer.listSerializer.descriptor)
    b.optionalElement("device", ReferenceSerializer.descriptor)
    b.optionalElement(
      "property",
      AdministrableProductDefinitionPropertySerializer.listSerializer.descriptor,
    )
    b.optionalElement(
      "routeOfAdministration",
      AdministrableProductDefinitionRouteOfAdministrationSerializer.listSerializer.descriptor,
    )
  }

  override fun deserializeInternal(
    decoder: CompositeDecoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
  ): AdministrableProductDefinition {
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
    var formOf: List<Reference>? = null
    var administrableDoseForm: CodeableConcept? = null
    var unitOfPresentation: CodeableConcept? = null
    var producedFrom: List<Reference>? = null
    var ingredient: List<CodeableConcept>? = null
    var device: Reference? = null
    var `property`: List<AdministrableProductDefinition.Property>? = null
    var routeOfAdministration: List<AdministrableProductDefinition.RouteOfAdministration>? = null
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
          formOf =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        14 ->
          administrableDoseForm =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        15 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer,
              null,
            )
        16 ->
          producedFrom =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              ReferenceSerializer.listSerializer,
              null,
            )
        17 ->
          ingredient =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              CodeableConceptSerializer.listSerializer,
              null,
            )
        18 ->
          device =
            decoder.decodeNullableSerializableElement(descriptor, i, ReferenceSerializer, null)
        19 ->
          `property` =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdministrableProductDefinitionPropertySerializer.listSerializer,
              null,
            )
        20 ->
          routeOfAdministration =
            decoder.decodeNullableSerializableElement(
              descriptor,
              i,
              AdministrableProductDefinitionRouteOfAdministrationSerializer.listSerializer,
              null,
            )
        else ->
          throw SerializationException(
            "Unexpected index decoding AdministrableProductDefinition: " + i
          )
      }
    }
    return AdministrableProductDefinition(
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
        Enumeration.of(if (status != null) PublicationStatus.fromCode(status) else null, _status)
          ?: throw SerializationException(
            "Missing required property 'status' on AdministrableProductDefinition"
          ),
      formOf = formOf ?: listOf(),
      administrableDoseForm = administrableDoseForm,
      unitOfPresentation = unitOfPresentation,
      producedFrom = producedFrom ?: listOf(),
      ingredient = ingredient ?: listOf(),
      device = device,
      `property` = `property` ?: listOf(),
      routeOfAdministration = routeOfAdministration ?: listOf(),
    )
  }

  override fun serializeInternal(
    encoder: CompositeEncoder,
    descriptor: SerialDescriptor,
    descriptorOffset: Int,
    `value`: AdministrableProductDefinition,
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
    encoder.encodeStringIfNotNull(descriptor, 11 + descriptorOffset, value.status.value?.code)
    encoder.encodeElementIfNotNull(descriptor, 12 + descriptorOffset, value.status)
    if (value.formOf.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        13 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.formOf,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      14 + descriptorOffset,
      CodeableConceptSerializer,
      value.administrableDoseForm,
    )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      15 + descriptorOffset,
      CodeableConceptSerializer,
      value.unitOfPresentation,
    )
    if (value.producedFrom.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        16 + descriptorOffset,
        ReferenceSerializer.listSerializer,
        value.producedFrom,
      )
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        17 + descriptorOffset,
        CodeableConceptSerializer.listSerializer,
        value.ingredient,
      )
    encoder.encodeSerializableIfNotNull(
      descriptor,
      18 + descriptorOffset,
      ReferenceSerializer,
      value.device,
    )
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        19 + descriptorOffset,
        AdministrableProductDefinitionPropertySerializer.listSerializer,
        value.`property`,
      )
    if (value.routeOfAdministration.isNotEmpty())
      encoder.encodeSerializableElement(
        descriptor,
        20 + descriptorOffset,
        AdministrableProductDefinitionRouteOfAdministrationSerializer.listSerializer,
        value.routeOfAdministration,
      )
  }
}
