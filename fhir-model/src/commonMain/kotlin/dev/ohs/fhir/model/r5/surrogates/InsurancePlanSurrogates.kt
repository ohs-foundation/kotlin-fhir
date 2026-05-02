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

package com.google.fhir.model.r5.surrogates

import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.ExtendedContactDetail
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
import com.google.fhir.model.r5.InsurancePlan
import com.google.fhir.model.r5.Meta
import com.google.fhir.model.r5.Money
import com.google.fhir.model.r5.Narrative
import com.google.fhir.model.r5.Period
import com.google.fhir.model.r5.PositiveInt
import com.google.fhir.model.r5.Quantity
import com.google.fhir.model.r5.Reference
import com.google.fhir.model.r5.Resource
import com.google.fhir.model.r5.String as R5String
import com.google.fhir.model.r5.Uri
import com.google.fhir.model.r5.serializers.DoubleSerializer
import com.google.fhir.model.r5.serializers.LocalTimeSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class InsurancePlanCoverageSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var network: List<Reference>? = null,
  public var benefit: List<InsurancePlan.Coverage.Benefit>? = null,
) {
  public fun toModel(): InsurancePlan.Coverage =
    InsurancePlan.Coverage(
      id = this@InsurancePlanCoverageSurrogate.id,
      extension = this@InsurancePlanCoverageSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanCoverageSurrogate.modifierExtension ?: listOf(),
      type = this@InsurancePlanCoverageSurrogate.type,
      network = this@InsurancePlanCoverageSurrogate.network ?: listOf(),
      benefit = this@InsurancePlanCoverageSurrogate.benefit ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: InsurancePlan.Coverage): InsurancePlanCoverageSurrogate =
      with(model) {
        InsurancePlanCoverageSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          network = this@with.network.takeIf { it.isNotEmpty() },
          benefit = this@with.benefit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InsurancePlanCoverageBenefitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var requirement: KotlinString? = null,
  public var _requirement: Element? = null,
  public var limit: List<InsurancePlan.Coverage.Benefit.Limit>? = null,
) {
  public fun toModel(): InsurancePlan.Coverage.Benefit =
    InsurancePlan.Coverage.Benefit(
      id = this@InsurancePlanCoverageBenefitSurrogate.id,
      extension = this@InsurancePlanCoverageBenefitSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanCoverageBenefitSurrogate.modifierExtension ?: listOf(),
      type = this@InsurancePlanCoverageBenefitSurrogate.type,
      requirement =
        R5String.of(
          this@InsurancePlanCoverageBenefitSurrogate.requirement,
          this@InsurancePlanCoverageBenefitSurrogate._requirement,
        ),
      limit = this@InsurancePlanCoverageBenefitSurrogate.limit ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Coverage.Benefit
    ): InsurancePlanCoverageBenefitSurrogate =
      with(model) {
        InsurancePlanCoverageBenefitSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          requirement = this@with.requirement?.value,
          _requirement = this@with.requirement?.toElement(),
          limit = this@with.limit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InsurancePlanCoverageBenefitLimitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var `value`: Quantity? = null,
  public var code: CodeableConcept? = null,
) {
  public fun toModel(): InsurancePlan.Coverage.Benefit.Limit =
    InsurancePlan.Coverage.Benefit.Limit(
      id = this@InsurancePlanCoverageBenefitLimitSurrogate.id,
      extension = this@InsurancePlanCoverageBenefitLimitSurrogate.extension ?: listOf(),
      modifierExtension =
        this@InsurancePlanCoverageBenefitLimitSurrogate.modifierExtension ?: listOf(),
      `value` = this@InsurancePlanCoverageBenefitLimitSurrogate.`value`,
      code = this@InsurancePlanCoverageBenefitLimitSurrogate.code,
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Coverage.Benefit.Limit
    ): InsurancePlanCoverageBenefitLimitSurrogate =
      with(model) {
        InsurancePlanCoverageBenefitLimitSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
          code = this@with.code,
        )
      }
  }
}

@Serializable
internal data class InsurancePlanPlanSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var identifier: List<Identifier>? = null,
  public var type: CodeableConcept? = null,
  public var coverageArea: List<Reference>? = null,
  public var network: List<Reference>? = null,
  public var generalCost: List<InsurancePlan.Plan.GeneralCost>? = null,
  public var specificCost: List<InsurancePlan.Plan.SpecificCost>? = null,
) {
  public fun toModel(): InsurancePlan.Plan =
    InsurancePlan.Plan(
      id = this@InsurancePlanPlanSurrogate.id,
      extension = this@InsurancePlanPlanSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanPlanSurrogate.modifierExtension ?: listOf(),
      identifier = this@InsurancePlanPlanSurrogate.identifier ?: listOf(),
      type = this@InsurancePlanPlanSurrogate.type,
      coverageArea = this@InsurancePlanPlanSurrogate.coverageArea ?: listOf(),
      network = this@InsurancePlanPlanSurrogate.network ?: listOf(),
      generalCost = this@InsurancePlanPlanSurrogate.generalCost ?: listOf(),
      specificCost = this@InsurancePlanPlanSurrogate.specificCost ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: InsurancePlan.Plan): InsurancePlanPlanSurrogate =
      with(model) {
        InsurancePlanPlanSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          identifier = this@with.identifier.takeIf { it.isNotEmpty() },
          type = this@with.type,
          coverageArea = this@with.coverageArea.takeIf { it.isNotEmpty() },
          network = this@with.network.takeIf { it.isNotEmpty() },
          generalCost = this@with.generalCost.takeIf { it.isNotEmpty() },
          specificCost = this@with.specificCost.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InsurancePlanPlanGeneralCostSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var groupSize: Int? = null,
  public var _groupSize: Element? = null,
  public var cost: Money? = null,
  public var comment: KotlinString? = null,
  public var _comment: Element? = null,
) {
  public fun toModel(): InsurancePlan.Plan.GeneralCost =
    InsurancePlan.Plan.GeneralCost(
      id = this@InsurancePlanPlanGeneralCostSurrogate.id,
      extension = this@InsurancePlanPlanGeneralCostSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanPlanGeneralCostSurrogate.modifierExtension ?: listOf(),
      type = this@InsurancePlanPlanGeneralCostSurrogate.type,
      groupSize =
        PositiveInt.of(
          this@InsurancePlanPlanGeneralCostSurrogate.groupSize,
          this@InsurancePlanPlanGeneralCostSurrogate._groupSize,
        ),
      cost = this@InsurancePlanPlanGeneralCostSurrogate.cost,
      comment =
        R5String.of(
          this@InsurancePlanPlanGeneralCostSurrogate.comment,
          this@InsurancePlanPlanGeneralCostSurrogate._comment,
        ),
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Plan.GeneralCost
    ): InsurancePlanPlanGeneralCostSurrogate =
      with(model) {
        InsurancePlanPlanGeneralCostSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          groupSize = this@with.groupSize?.value,
          _groupSize = this@with.groupSize?.toElement(),
          cost = this@with.cost,
          comment = this@with.comment?.value,
          _comment = this@with.comment?.toElement(),
        )
      }
  }
}

@Serializable
internal data class InsurancePlanPlanSpecificCostSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var benefit: List<InsurancePlan.Plan.SpecificCost.Benefit>? = null,
) {
  public fun toModel(): InsurancePlan.Plan.SpecificCost =
    InsurancePlan.Plan.SpecificCost(
      id = this@InsurancePlanPlanSpecificCostSurrogate.id,
      extension = this@InsurancePlanPlanSpecificCostSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanPlanSpecificCostSurrogate.modifierExtension ?: listOf(),
      category = this@InsurancePlanPlanSpecificCostSurrogate.category,
      benefit = this@InsurancePlanPlanSpecificCostSurrogate.benefit ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Plan.SpecificCost
    ): InsurancePlanPlanSpecificCostSurrogate =
      with(model) {
        InsurancePlanPlanSpecificCostSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          benefit = this@with.benefit.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InsurancePlanPlanSpecificCostBenefitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var cost: List<InsurancePlan.Plan.SpecificCost.Benefit.Cost>? = null,
) {
  public fun toModel(): InsurancePlan.Plan.SpecificCost.Benefit =
    InsurancePlan.Plan.SpecificCost.Benefit(
      id = this@InsurancePlanPlanSpecificCostBenefitSurrogate.id,
      extension = this@InsurancePlanPlanSpecificCostBenefitSurrogate.extension ?: listOf(),
      modifierExtension =
        this@InsurancePlanPlanSpecificCostBenefitSurrogate.modifierExtension ?: listOf(),
      type = this@InsurancePlanPlanSpecificCostBenefitSurrogate.type,
      cost = this@InsurancePlanPlanSpecificCostBenefitSurrogate.cost ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Plan.SpecificCost.Benefit
    ): InsurancePlanPlanSpecificCostBenefitSurrogate =
      with(model) {
        InsurancePlanPlanSpecificCostBenefitSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          cost = this@with.cost.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class InsurancePlanPlanSpecificCostBenefitCostSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var applicability: CodeableConcept? = null,
  public var qualifiers: List<CodeableConcept>? = null,
  public var `value`: Quantity? = null,
) {
  public fun toModel(): InsurancePlan.Plan.SpecificCost.Benefit.Cost =
    InsurancePlan.Plan.SpecificCost.Benefit.Cost(
      id = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.id,
      extension = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.extension ?: listOf(),
      modifierExtension =
        this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.modifierExtension ?: listOf(),
      type = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.type,
      applicability = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.applicability,
      qualifiers = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.qualifiers ?: listOf(),
      `value` = this@InsurancePlanPlanSpecificCostBenefitCostSurrogate.`value`,
    )

  public companion object {
    public fun fromModel(
      model: InsurancePlan.Plan.SpecificCost.Benefit.Cost
    ): InsurancePlanPlanSpecificCostBenefitCostSurrogate =
      with(model) {
        InsurancePlanPlanSpecificCostBenefitCostSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          applicability = this@with.applicability,
          qualifiers = this@with.qualifiers.takeIf { it.isNotEmpty() },
          `value` = this@with.`value`,
        )
      }
  }
}

@Serializable
internal data class InsurancePlanSurrogate(
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
  public var type: List<CodeableConcept>? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var alias: List<KotlinString?>? = null,
  public var _alias: List<Element?>? = null,
  public var period: Period? = null,
  public var ownedBy: Reference? = null,
  public var administeredBy: Reference? = null,
  public var coverageArea: List<Reference>? = null,
  public var contact: List<ExtendedContactDetail>? = null,
  public var endpoint: List<Reference>? = null,
  public var network: List<Reference>? = null,
  public var coverage: List<InsurancePlan.Coverage>? = null,
  public var plan: List<InsurancePlan.Plan>? = null,
) {
  public fun toModel(): InsurancePlan =
    InsurancePlan(
      id = this@InsurancePlanSurrogate.id,
      meta = this@InsurancePlanSurrogate.meta,
      implicitRules =
        Uri.of(
          this@InsurancePlanSurrogate.implicitRules,
          this@InsurancePlanSurrogate._implicitRules,
        ),
      language =
        Code.of(this@InsurancePlanSurrogate.language, this@InsurancePlanSurrogate._language),
      text = this@InsurancePlanSurrogate.text,
      contained = this@InsurancePlanSurrogate.contained ?: listOf(),
      extension = this@InsurancePlanSurrogate.extension ?: listOf(),
      modifierExtension = this@InsurancePlanSurrogate.modifierExtension ?: listOf(),
      identifier = this@InsurancePlanSurrogate.identifier ?: listOf(),
      status =
        this@InsurancePlanSurrogate.status?.let {
          Enumeration.of(PublicationStatus.fromCode(it), this@InsurancePlanSurrogate._status)
        },
      type = this@InsurancePlanSurrogate.type ?: listOf(),
      name = R5String.of(this@InsurancePlanSurrogate.name, this@InsurancePlanSurrogate._name),
      alias =
        if (
          this@InsurancePlanSurrogate.alias == null && this@InsurancePlanSurrogate._alias == null
        ) {
          listOf()
        } else {
          (this@InsurancePlanSurrogate.alias
              ?: List(this@InsurancePlanSurrogate._alias!!.size) { null })
            .zip(
              this@InsurancePlanSurrogate._alias
                ?: List(this@InsurancePlanSurrogate.alias!!.size) { null }
            )
            .map { (value, element) -> R5String.of(value, element)!! }
            .toList()
        },
      period = this@InsurancePlanSurrogate.period,
      ownedBy = this@InsurancePlanSurrogate.ownedBy,
      administeredBy = this@InsurancePlanSurrogate.administeredBy,
      coverageArea = this@InsurancePlanSurrogate.coverageArea ?: listOf(),
      contact = this@InsurancePlanSurrogate.contact ?: listOf(),
      endpoint = this@InsurancePlanSurrogate.endpoint ?: listOf(),
      network = this@InsurancePlanSurrogate.network ?: listOf(),
      coverage = this@InsurancePlanSurrogate.coverage ?: listOf(),
      plan = this@InsurancePlanSurrogate.plan ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: InsurancePlan): InsurancePlanSurrogate =
      with(model) {
        InsurancePlanSurrogate(
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
          status = this@with.status?.value?.getCode(),
          _status = this@with.status?.toElement(),
          type = this@with.type.takeIf { it.isNotEmpty() },
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          alias = this@with.alias.map { it.value }.toList().takeUnless { it.all { it == null } },
          _alias =
            this@with.alias
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          period = this@with.period,
          ownedBy = this@with.ownedBy,
          administeredBy = this@with.administeredBy,
          coverageArea = this@with.coverageArea.takeIf { it.isNotEmpty() },
          contact = this@with.contact.takeIf { it.isNotEmpty() },
          endpoint = this@with.endpoint.takeIf { it.isNotEmpty() },
          network = this@with.network.takeIf { it.isNotEmpty() },
          coverage = this@with.coverage.takeIf { it.isNotEmpty() },
          plan = this@with.plan.takeIf { it.isNotEmpty() },
        )
      }
  }
}
