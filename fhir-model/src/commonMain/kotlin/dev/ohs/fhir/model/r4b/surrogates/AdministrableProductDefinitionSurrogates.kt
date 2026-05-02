/*
 * Copyright 2026 Google LLC
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

@file:UseSerializers(DoubleSerializer::class, LocalTimeSerializer::class)
@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b.surrogates

import com.google.fhir.model.r4b.AdministrableProductDefinition
import com.google.fhir.model.r4b.Attachment
import com.google.fhir.model.r4b.Boolean as R4bBoolean
import com.google.fhir.model.r4b.Code
import com.google.fhir.model.r4b.CodeableConcept
import com.google.fhir.model.r4b.Date
import com.google.fhir.model.r4b.Duration
import com.google.fhir.model.r4b.Element
import com.google.fhir.model.r4b.Enumeration
import com.google.fhir.model.r4b.Extension
import com.google.fhir.model.r4b.FhirDate
import com.google.fhir.model.r4b.Identifier
import com.google.fhir.model.r4b.Meta
import com.google.fhir.model.r4b.Narrative
import com.google.fhir.model.r4b.Quantity
import com.google.fhir.model.r4b.Ratio
import com.google.fhir.model.r4b.Reference
import com.google.fhir.model.r4b.Resource
import com.google.fhir.model.r4b.String as R4bString
import com.google.fhir.model.r4b.Uri
import com.google.fhir.model.r4b.serializers.DoubleSerializer
import com.google.fhir.model.r4b.serializers.LocalTimeSerializer
import com.google.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Boolean as KotlinBoolean
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class AdministrableProductDefinitionPropertySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: AdministrableProductDefinition.Property.Value? = null,
  public var status: CodeableConcept? = null,
) {
  public fun toModel(): AdministrableProductDefinition.Property =
    AdministrableProductDefinition.Property(
      id = this@AdministrableProductDefinitionPropertySurrogate.id,
      extension = this@AdministrableProductDefinitionPropertySurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdministrableProductDefinitionPropertySurrogate.modifierExtension ?: listOf(),
      type = this@AdministrableProductDefinitionPropertySurrogate.type,
      `value` = this@AdministrableProductDefinitionPropertySurrogate.`value`,
      status = this@AdministrableProductDefinitionPropertySurrogate.status,
    )

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition.Property
    ): AdministrableProductDefinitionPropertySurrogate =
      with(model) {
        AdministrableProductDefinitionPropertySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
          status = this@with.status,
        )
      }
  }
}

@Serializable
internal data class AdministrableProductDefinitionRouteOfAdministrationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var firstDose: Quantity? = null,
  public var maxSingleDose: Quantity? = null,
  public var maxDosePerDay: Quantity? = null,
  public var maxDosePerTreatmentPeriod: Ratio? = null,
  public var maxTreatmentPeriod: Duration? = null,
  public var targetSpecies:
    List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies>? =
    null,
) {
  public fun toModel(): AdministrableProductDefinition.RouteOfAdministration =
    AdministrableProductDefinition.RouteOfAdministration(
      id = this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.id,
      extension =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.modifierExtension
          ?: listOf(),
      code = this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.code,
      firstDose = this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.firstDose,
      maxSingleDose =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.maxSingleDose,
      maxDosePerDay =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.maxDosePerDay,
      maxDosePerTreatmentPeriod =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.maxDosePerTreatmentPeriod,
      maxTreatmentPeriod =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.maxTreatmentPeriod,
      targetSpecies =
        this@AdministrableProductDefinitionRouteOfAdministrationSurrogate.targetSpecies ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition.RouteOfAdministration
    ): AdministrableProductDefinitionRouteOfAdministrationSurrogate =
      with(model) {
        AdministrableProductDefinitionRouteOfAdministrationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          firstDose = this@with.firstDose,
          maxSingleDose = this@with.maxSingleDose,
          maxDosePerDay = this@with.maxDosePerDay,
          maxDosePerTreatmentPeriod = this@with.maxDosePerTreatmentPeriod,
          maxTreatmentPeriod = this@with.maxTreatmentPeriod,
          targetSpecies = this@with.targetSpecies.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
  public var withdrawalPeriod:
    List<AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod>? =
    null,
) {
  public fun toModel(): AdministrableProductDefinition.RouteOfAdministration.TargetSpecies =
    AdministrableProductDefinition.RouteOfAdministration.TargetSpecies(
      id = this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate.id,
      extension =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate.extension
          ?: listOf(),
      modifierExtension =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate
          .modifierExtension ?: listOf(),
      code = this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate.code,
      withdrawalPeriod =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate
          .withdrawalPeriod ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies
    ): AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate =
      with(model) {
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
          withdrawalPeriod = this@with.withdrawalPeriod.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var tissue: CodeableConcept,
  public var `value`: Quantity,
  public var supportingInformation: KotlinString? = null,
  public var _supportingInformation: Element? = null,
) {
  public fun toModel():
    AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod =
    AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod(
      id =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
          .id,
      extension =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
          .extension ?: listOf(),
      modifierExtension =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
          .modifierExtension ?: listOf(),
      tissue =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
          .tissue,
      `value` =
        this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
          .`value`,
      supportingInformation =
        R4bString.of(
          this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
            .supportingInformation,
          this@AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate
            ._supportingInformation,
        ),
    )

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition.RouteOfAdministration.TargetSpecies.WithdrawalPeriod
    ): AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate =
      with(model) {
        AdministrableProductDefinitionRouteOfAdministrationTargetSpeciesWithdrawalPeriodSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          tissue = this@with.tissue,
          `value` = this@with.`value`,
          supportingInformation = this@with.supportingInformation?.value,
          _supportingInformation = this@with.supportingInformation?.toElement(),
        )
      }
  }
}

@Serializable
internal data class AdministrableProductDefinitionPropertyValueSurrogate(
  public var valueCodeableConcept: CodeableConcept? = null,
  public var valueQuantity: Quantity? = null,
  public var valueDate: KotlinString? = null,
  public var _valueDate: Element? = null,
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueAttachment: Attachment? = null,
) {
  public fun toModel(): AdministrableProductDefinition.Property.Value =
    AdministrableProductDefinition.Property.Value.from(
      this@AdministrableProductDefinitionPropertyValueSurrogate.valueCodeableConcept,
      this@AdministrableProductDefinitionPropertyValueSurrogate.valueQuantity,
      Date.of(
        FhirDate.fromString(this@AdministrableProductDefinitionPropertyValueSurrogate.valueDate),
        this@AdministrableProductDefinitionPropertyValueSurrogate._valueDate,
      ),
      R4bBoolean.of(
        this@AdministrableProductDefinitionPropertyValueSurrogate.valueBoolean,
        this@AdministrableProductDefinitionPropertyValueSurrogate._valueBoolean,
      ),
      this@AdministrableProductDefinitionPropertyValueSurrogate.valueAttachment,
    )!!

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition.Property.Value
    ): AdministrableProductDefinitionPropertyValueSurrogate =
      with(model) {
        AdministrableProductDefinitionPropertyValueSurrogate(
          valueCodeableConcept = this@with.asCodeableConcept()?.value,
          valueQuantity = this@with.asQuantity()?.value,
          valueDate = this@with.asDate()?.value?.value?.toString(),
          _valueDate = this@with.asDate()?.value?.toElement(),
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueAttachment = this@with.asAttachment()?.value,
        )
      }
  }
}

@Serializable
internal data class AdministrableProductDefinitionSurrogate(
  public var id: KotlinString? = null,
  public var meta: Meta? = null,
  public var implicitRules: KotlinString? = null,
  public var _implicitRules: Element? = null,
  public var language: KotlinString? = null,
  public var _language: Element? = null,
  public var text: Narrative? = null,
  public var contained: List<Resource>? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var status: KotlinString? = null,
  public var _status: Element? = null,
  public var formOf: List<Reference>? = null,
  public var administrableDoseForm: CodeableConcept? = null,
  public var unitOfPresentation: CodeableConcept? = null,
  public var producedFrom: List<Reference>? = null,
  public var ingredient: List<CodeableConcept>? = null,
  public var device: Reference? = null,
  public var `property`: List<AdministrableProductDefinition.Property>? = null,
  public var routeOfAdministration: List<AdministrableProductDefinition.RouteOfAdministration>? =
    null,
) {
  public fun toModel(): AdministrableProductDefinition =
    AdministrableProductDefinition(
      id = this@AdministrableProductDefinitionSurrogate.id,
      meta = this@AdministrableProductDefinitionSurrogate.meta,
      implicitRules =
        Uri.of(
          this@AdministrableProductDefinitionSurrogate.implicitRules,
          this@AdministrableProductDefinitionSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@AdministrableProductDefinitionSurrogate.language,
          this@AdministrableProductDefinitionSurrogate._language,
        ),
      text = this@AdministrableProductDefinitionSurrogate.text,
      contained = this@AdministrableProductDefinitionSurrogate.contained ?: listOf(),
      extension = this@AdministrableProductDefinitionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@AdministrableProductDefinitionSurrogate.modifierExtension ?: listOf(),
      identifier = this@AdministrableProductDefinitionSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          PublicationStatus.fromCode(this@AdministrableProductDefinitionSurrogate.status!!),
          this@AdministrableProductDefinitionSurrogate._status,
        ),
      formOf = this@AdministrableProductDefinitionSurrogate.formOf ?: listOf(),
      administrableDoseForm = this@AdministrableProductDefinitionSurrogate.administrableDoseForm,
      unitOfPresentation = this@AdministrableProductDefinitionSurrogate.unitOfPresentation,
      producedFrom = this@AdministrableProductDefinitionSurrogate.producedFrom ?: listOf(),
      ingredient = this@AdministrableProductDefinitionSurrogate.ingredient ?: listOf(),
      device = this@AdministrableProductDefinitionSurrogate.device,
      `property` = this@AdministrableProductDefinitionSurrogate.`property` ?: listOf(),
      routeOfAdministration =
        this@AdministrableProductDefinitionSurrogate.routeOfAdministration ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: AdministrableProductDefinition
    ): AdministrableProductDefinitionSurrogate =
      with(model) {
        AdministrableProductDefinitionSurrogate(
          id = this@with.id,
          meta = this@with.meta,
          implicitRules = this@with.implicitRules?.value,
          _implicitRules = this@with.implicitRules?.toElement(),
          language = this@with.language?.value,
          _language = this@with.language?.toElement(),
          text = this@with.text,
          contained = this@with.contained.takeIf { it.isNotEmpty() },
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          status = this@with.status.value?.getCode(),
          _status = this@with.status.toElement(),
          formOf = this@with.formOf.takeIf { it.isNotEmpty() },
          administrableDoseForm = this@with.administrableDoseForm,
          unitOfPresentation = this@with.unitOfPresentation,
          producedFrom = this@with.producedFrom.takeIf { it.isNotEmpty() },
          ingredient = this@with.ingredient.takeIf { it.isNotEmpty() },
          device = this@with.device,
          `property` = this@with.`property`.takeIf { it.isNotEmpty() },
          routeOfAdministration = this@with.routeOfAdministration.takeIf { it.isNotEmpty() },
        )
      }
  }
}
