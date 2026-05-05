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
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.Meta
import dev.ohs.fhir.model.r4b.Narrative
import dev.ohs.fhir.model.r4b.Quantity
import dev.ohs.fhir.model.r4b.Ratio
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.Uri
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
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
      element("valueCodeableConcept", CodeableConcept.serializer().descriptor, isOptional = true)
      element("valueQuantity", Quantity.serializer().descriptor, isOptional = true)
      element("valueDate", KotlinString.serializer().descriptor, isOptional = true)
      element("_valueDate", Element.serializer().descriptor, isOptional = true)
      element("valueBoolean", KotlinBoolean.serializer().descriptor, isOptional = true)
      element("_valueBoolean", Element.serializer().descriptor, isOptional = true)
      element("valueAttachment", Attachment.serializer().descriptor, isOptional = true)
      element("status", CodeableConcept.serializer().descriptor, isOptional = true)
    }

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition.Property =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(encoder: Encoder, `value`: AdministrableProductDefinition.Property) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(decoder: CompositeDecoder): AdministrableProductDefinition.Property {
    val __desc = descriptor
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
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> type = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        4 ->
          valueCodeableConcept =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        5 ->
          valueQuantity =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueQuantitySer, null)
        6 -> valueDate = decoder.decodeStringElement(__desc, __i)
        7 ->
          _valueDate =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        8 -> valueBoolean = decoder.decodeBooleanElement(__desc, __i)
        9 ->
          _valueBoolean =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueDateSer, null)
        10 ->
          valueAttachment =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueAttachmentSer, null)
        11 -> status = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.typeSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding Property: " + __i)
      }
    }
    return AdministrableProductDefinition.Property(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      type = type!!,
      `value` =
        AdministrableProductDefinition.Property.Value.from(
          valueCodeableConcept,
          valueQuantity,
          Date.of(FhirDate.fromString(valueDate), _valueDate),
          R4bBoolean.of(valueBoolean, _valueBoolean),
          valueAttachment,
        ),
      status = status,
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: AdministrableProductDefinition.Property,
  ) {
    val __desc = descriptor
    (value.id)?.let { encoder.encodeStringElement(__desc, 0, it) }
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 1, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 2, Hoisted.extensionSer, value.modifierExtension)
    (value.type)?.let { encoder.encodeSerializableElement(__desc, 3, Hoisted.typeSer, it) }
    when (val __d = value.`value`) {
      null -> {}
      is AdministrableProductDefinition.Property.Value.CodeableConcept -> {
        encoder.encodeSerializableElement(__desc, 4, Hoisted.typeSer, __d.value)
      }
      is AdministrableProductDefinition.Property.Value.Quantity -> {
        encoder.encodeSerializableElement(__desc, 5, Hoisted.valueQuantitySer, __d.value)
      }
      is AdministrableProductDefinition.Property.Value.Date -> {
        ((__d.value.value?.toString()))?.let { encoder.encodeStringElement(__desc, 6, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 7, Hoisted.valueDateSer, it)
        }
      }
      is AdministrableProductDefinition.Property.Value.Boolean -> {
        ((__d.value.value))?.let { encoder.encodeBooleanElement(__desc, 8, it) }
        (__d.value.toElement())?.let {
          encoder.encodeSerializableElement(__desc, 9, Hoisted.valueDateSer, it)
        }
      }
      is AdministrableProductDefinition.Property.Value.Attachment -> {
        encoder.encodeSerializableElement(__desc, 10, Hoisted.valueAttachmentSer, __d.value)
      }
    }
    (value.status)?.let { encoder.encodeSerializableElement(__desc, 11, Hoisted.typeSer, it) }
  }

  private object Hoisted {
    public val extensionSerInner: KSerializer<Extension> = Extension.serializer()

    public val extensionSer: KSerializer<List<Extension>> =
      ListSerializer(Hoisted.extensionSerInner)

    public val typeSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val valueQuantitySer: KSerializer<Quantity> = Quantity.serializer()

    public val valueDateSer: KSerializer<Element> = Element.serializer()

    public val valueAttachmentSer: KSerializer<Attachment> = Attachment.serializer()
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration> {
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
            AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition.RouteOfAdministration =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): AdministrableProductDefinition.RouteOfAdministration {
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
    var targetSpecies: List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies>? =
      null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          firstDose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.firstDoseSer, null)
        5 ->
          maxSingleDose =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.firstDoseSer, null)
        6 ->
          maxDosePerDay =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.firstDoseSer, null)
        7 ->
          maxDosePerTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.maxDosePerTreatmentPeriodSer,
              null,
            )
        8 ->
          maxTreatmentPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.maxTreatmentPeriodSer,
              null,
            )
        9 ->
          targetSpecies =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.targetSpeciesSer, null)
        CompositeDecoder.DECODE_DONE -> break
        else ->
          throw SerializationException("Unexpected index decoding RouteOfAdministration: " + __i)
      }
    }
    return AdministrableProductDefinition.RouteOfAdministration(
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
    `value`: AdministrableProductDefinition.RouteOfAdministration,
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
      KSerializer<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies> =
      AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.serializer()

    public val targetSpeciesSer:
      KSerializer<List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies>> =
      ListSerializer(Hoisted.targetSpeciesSerInner)
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies> {
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
            AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
              .serializer()
              .descriptor
          }
        ),
        isOptional = true,
      )
    }

  override fun deserialize(
    decoder: Decoder
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies {
    val __desc = descriptor
    var id: KotlinString? = null
    var extension: List<Extension>? = null
    var modifierExtension: List<Extension>? = null
    var code: CodeableConcept? = null
    var withdrawalPeriod:
      List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
      null
    while (true) {
      when (val __i = decoder.decodeElementIndex(__desc)) {
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 -> code = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.codeSer, null)
        4 ->
          withdrawalPeriod =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.withdrawalPeriodSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding TargetSpecies: " + __i)
      }
    }
    return AdministrableProductDefinition.RouteOfAdministration.TargetSpecies(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      code = code!!,
      withdrawalPeriod = withdrawalPeriod ?: listOf(),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies,
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
        AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
      > =
      AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
        .serializer()

    public val withdrawalPeriodSer:
      KSerializer<
        List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>
      > =
      ListSerializer(Hoisted.withdrawalPeriodSerInner)
  }
}

internal object AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSerializer :
  KSerializer<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod> {
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
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
    decoder.decodeStructure(descriptor) { deserializeJson(this) }

  override fun serialize(
    encoder: Encoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
  ) {
    encoder.encodeStructure(descriptor) { serializeJson(this, value) }
  }

  private fun deserializeJson(
    decoder: CompositeDecoder
  ): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod {
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
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        2 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        3 ->
          tissue = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.tissueSer, null)
        4 ->
          `value` = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.valueSer, null)
        5 -> supportingInformation = decoder.decodeStringElement(__desc, __i)
        6 ->
          _supportingInformation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.supportingInformationSer,
              null,
            )
        CompositeDecoder.DECODE_DONE -> break
        else -> throw SerializationException("Unexpected index decoding WithdrawalPeriod: " + __i)
      }
    }
    return AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
      id = id,
      extension = extension ?: listOf(),
      modifierExtension = modifierExtension ?: listOf(),
      tissue = tissue!!,
      `value` = `value`!!,
      supportingInformation = R4bString.of(supportingInformation, _supportingInformation),
    )
  }

  private fun serializeJson(
    encoder: CompositeEncoder,
    `value`: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod,
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

internal object AdministrableProductDefinitionSerializer :
  KSerializer<AdministrableProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdministrableProductDefinition") {
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
    b.element("formOf", listSerialDescriptor(Reference.serializer().descriptor), isOptional = true)
    b.element("administrableDoseForm", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element("unitOfPresentation", CodeableConcept.serializer().descriptor, isOptional = true)
    b.element(
      "producedFrom",
      listSerialDescriptor(Reference.serializer().descriptor),
      isOptional = true,
    )
    b.element(
      "ingredient",
      listSerialDescriptor(CodeableConcept.serializer().descriptor),
      isOptional = true,
    )
    b.element("device", Reference.serializer().descriptor, isOptional = true)
    b.element(
      "property",
      listSerialDescriptor(
        lazyDescriptor { AdministrableProductDefinition.Property.serializer().descriptor }
      ),
      isOptional = true,
    )
    b.element(
      "routeOfAdministration",
      listSerialDescriptor(
        lazyDescriptor {
          AdministrableProductDefinition.RouteOfAdministration.serializer().descriptor
        }
      ),
      isOptional = true,
    )
  }

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition =
    decoder.decodeStructure(descriptor) { deserializeJson(this, descriptor, 1) }

  override fun serialize(encoder: Encoder, `value`: AdministrableProductDefinition) {
    encoder.encodeStructure(descriptor) {
      encodeStringElement(descriptor, 0, "AdministrableProductDefinition")
      serializeJson(this, descriptor, 1, value)
    }
  }

  internal fun deserializeJson(
    decoder: CompositeDecoder,
    desc: SerialDescriptor,
    __off: Int,
  ): AdministrableProductDefinition {
    val __desc = desc
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
      val __i = decoder.decodeElementIndex(__desc)
      if (__i == CompositeDecoder.DECODE_DONE) break
      when (__i - __off) {
        -1 -> decoder.decodeStringElement(__desc, __i)
        0 -> id = decoder.decodeStringElement(__desc, __i)
        1 -> meta = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.metaSer, null)
        2 -> implicitRules = decoder.decodeStringElement(__desc, __i)
        3 ->
          _implicitRules =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        4 -> language = decoder.decodeStringElement(__desc, __i)
        5 ->
          _language =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        6 -> text = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.textSer, null)
        7 ->
          contained =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.containedSer, null)
        8 ->
          extension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        9 ->
          modifierExtension =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.extensionSer, null)
        10 ->
          identifier =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.identifierSer, null)
        11 -> status = decoder.decodeStringElement(__desc, __i)
        12 ->
          _status =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.implicitRulesSer, null)
        13 ->
          formOf = decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.formOfSer, null)
        14 ->
          administrableDoseForm =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.administrableDoseFormSer,
              null,
            )
        15 ->
          unitOfPresentation =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.administrableDoseFormSer,
              null,
            )
        16 ->
          producedFrom =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.formOfSer, null)
        17 ->
          ingredient =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.ingredientSer, null)
        18 ->
          device =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.formOfSerInner, null)
        19 ->
          `property` =
            decoder.decodeNullableSerializableElement(__desc, __i, Hoisted.propertySer, null)
        20 ->
          routeOfAdministration =
            decoder.decodeNullableSerializableElement(
              __desc,
              __i,
              Hoisted.routeOfAdministrationSer,
              null,
            )
        else ->
          throw SerializationException(
            "Unexpected index decoding AdministrableProductDefinition: " + __i
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
      status = Enumeration.of(PublicationStatus.fromCode(status!!), _status),
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

  internal fun serializeJson(
    encoder: CompositeEncoder,
    desc: SerialDescriptor,
    __off: Int,
    `value`: AdministrableProductDefinition,
  ) {
    val __desc = desc
    (value.id)?.let { encoder.encodeStringElement(__desc, 0 + __off, it) }
    (value.meta)?.let { encoder.encodeSerializableElement(__desc, 1 + __off, Hoisted.metaSer, it) }
    ((value.implicitRules?.value))?.let { encoder.encodeStringElement(__desc, 2 + __off, it) }
    (value.implicitRules?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 3 + __off, Hoisted.implicitRulesSer, it)
    }
    ((value.language?.value))?.let { encoder.encodeStringElement(__desc, 4 + __off, it) }
    (value.language?.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 5 + __off, Hoisted.implicitRulesSer, it)
    }
    (value.text)?.let { encoder.encodeSerializableElement(__desc, 6 + __off, Hoisted.textSer, it) }
    if (value.contained.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 7 + __off, Hoisted.containedSer, value.contained)
    if (value.extension.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 8 + __off, Hoisted.extensionSer, value.extension)
    if (value.modifierExtension.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        9 + __off,
        Hoisted.extensionSer,
        value.modifierExtension,
      )
    if (value.identifier.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 10 + __off, Hoisted.identifierSer, value.identifier)
    ((value.status.value?.getCode()))?.let { encoder.encodeStringElement(__desc, 11 + __off, it) }
    (value.status.toElement())?.let {
      encoder.encodeSerializableElement(__desc, 12 + __off, Hoisted.implicitRulesSer, it)
    }
    if (value.formOf.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 13 + __off, Hoisted.formOfSer, value.formOf)
    (value.administrableDoseForm)?.let {
      encoder.encodeSerializableElement(__desc, 14 + __off, Hoisted.administrableDoseFormSer, it)
    }
    (value.unitOfPresentation)?.let {
      encoder.encodeSerializableElement(__desc, 15 + __off, Hoisted.administrableDoseFormSer, it)
    }
    if (value.producedFrom.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 16 + __off, Hoisted.formOfSer, value.producedFrom)
    if (value.ingredient.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 17 + __off, Hoisted.ingredientSer, value.ingredient)
    (value.device)?.let {
      encoder.encodeSerializableElement(__desc, 18 + __off, Hoisted.formOfSerInner, it)
    }
    if (value.`property`.isNotEmpty())
      encoder.encodeSerializableElement(__desc, 19 + __off, Hoisted.propertySer, value.`property`)
    if (value.routeOfAdministration.isNotEmpty())
      encoder.encodeSerializableElement(
        __desc,
        20 + __off,
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

    public val formOfSerInner: KSerializer<Reference> = Reference.serializer()

    public val formOfSer: KSerializer<List<Reference>> = ListSerializer(Hoisted.formOfSerInner)

    public val administrableDoseFormSer: KSerializer<CodeableConcept> = CodeableConcept.serializer()

    public val ingredientSer: KSerializer<List<CodeableConcept>> =
      ListSerializer(Hoisted.administrableDoseFormSer)

    public val propertySerInner: KSerializer<AdministrableProductDefinition.Property> =
      AdministrableProductDefinition.Property.serializer()

    public val propertySer: KSerializer<List<AdministrableProductDefinition.Property>> =
      ListSerializer(Hoisted.propertySerInner)

    public val routeOfAdministrationSerInner:
      KSerializer<AdministrableProductDefinition.RouteOfAdministration> =
      AdministrableProductDefinition.RouteOfAdministration.serializer()

    public val routeOfAdministrationSer:
      KSerializer<List<AdministrableProductDefinition.RouteOfAdministration>> =
      ListSerializer(Hoisted.routeOfAdministrationSerInner)
  }
}

internal object AdministrableProductDefinitionPolymorphicSerializer :
  KSerializer<AdministrableProductDefinition> {
  override val descriptor: SerialDescriptor =
    buildClassSerialDescriptor("AdministrableProductDefinition") {
      AdministrableProductDefinitionSerializer.buildDescriptor(this)
    }

  override fun serialize(encoder: Encoder, `value`: AdministrableProductDefinition) {
    encoder.encodeStructure(descriptor) {
      AdministrableProductDefinitionSerializer.serializeJson(this, descriptor, 0, value)
    }
  }

  override fun deserialize(decoder: Decoder): AdministrableProductDefinition =
    decoder.decodeStructure(descriptor) {
      AdministrableProductDefinitionSerializer.deserializeJson(this, descriptor, 0)
    }
}
