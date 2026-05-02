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

import com.google.fhir.model.r5.Boolean as R5Boolean
import com.google.fhir.model.r5.Code
import com.google.fhir.model.r5.CodeableConcept
import com.google.fhir.model.r5.Coverage
import com.google.fhir.model.r5.Element
import com.google.fhir.model.r5.Enumeration
import com.google.fhir.model.r5.Extension
import com.google.fhir.model.r5.Identifier
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
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CoveragePaymentBySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var party: Reference,
  public var responsibility: KotlinString? = null,
  public var _responsibility: Element? = null,
) {
  public fun toModel(): Coverage.PaymentBy =
    Coverage.PaymentBy(
      id = this@CoveragePaymentBySurrogate.id,
      extension = this@CoveragePaymentBySurrogate.extension ?: listOf(),
      modifierExtension = this@CoveragePaymentBySurrogate.modifierExtension ?: listOf(),
      party = this@CoveragePaymentBySurrogate.party,
      responsibility =
        R5String.of(
          this@CoveragePaymentBySurrogate.responsibility,
          this@CoveragePaymentBySurrogate._responsibility,
        ),
    )

  public companion object {
    public fun fromModel(model: Coverage.PaymentBy): CoveragePaymentBySurrogate =
      with(model) {
        CoveragePaymentBySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          party = this@with.party,
          responsibility = this@with.responsibility?.value,
          _responsibility = this@with.responsibility?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CoverageClassSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var `value`: Identifier,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
) {
  public fun toModel(): Coverage.Class =
    Coverage.Class(
      id = this@CoverageClassSurrogate.id,
      extension = this@CoverageClassSurrogate.extension ?: listOf(),
      modifierExtension = this@CoverageClassSurrogate.modifierExtension ?: listOf(),
      type = this@CoverageClassSurrogate.type,
      `value` = this@CoverageClassSurrogate.`value`,
      name = R5String.of(this@CoverageClassSurrogate.name, this@CoverageClassSurrogate._name),
    )

  public companion object {
    public fun fromModel(model: Coverage.Class): CoverageClassSurrogate =
      with(model) {
        CoverageClassSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          `value` = this@with.`value`,
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CoverageCostToBeneficiarySurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var network: CodeableConcept? = null,
  public var unit: CodeableConcept? = null,
  public var term: CodeableConcept? = null,
  public var `value`: Coverage.CostToBeneficiary.Value? = null,
  public var exception: List<Coverage.CostToBeneficiary.Exception>? = null,
) {
  public fun toModel(): Coverage.CostToBeneficiary =
    Coverage.CostToBeneficiary(
      id = this@CoverageCostToBeneficiarySurrogate.id,
      extension = this@CoverageCostToBeneficiarySurrogate.extension ?: listOf(),
      modifierExtension = this@CoverageCostToBeneficiarySurrogate.modifierExtension ?: listOf(),
      type = this@CoverageCostToBeneficiarySurrogate.type,
      category = this@CoverageCostToBeneficiarySurrogate.category,
      network = this@CoverageCostToBeneficiarySurrogate.network,
      unit = this@CoverageCostToBeneficiarySurrogate.unit,
      term = this@CoverageCostToBeneficiarySurrogate.term,
      `value` = this@CoverageCostToBeneficiarySurrogate.`value`,
      exception = this@CoverageCostToBeneficiarySurrogate.exception ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: Coverage.CostToBeneficiary): CoverageCostToBeneficiarySurrogate =
      with(model) {
        CoverageCostToBeneficiarySurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          category = this@with.category,
          network = this@with.network,
          unit = this@with.unit,
          term = this@with.term,
          `value` = this@with.`value`,
          exception = this@with.exception.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CoverageCostToBeneficiaryExceptionSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var period: Period? = null,
) {
  public fun toModel(): Coverage.CostToBeneficiary.Exception =
    Coverage.CostToBeneficiary.Exception(
      id = this@CoverageCostToBeneficiaryExceptionSurrogate.id,
      extension = this@CoverageCostToBeneficiaryExceptionSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageCostToBeneficiaryExceptionSurrogate.modifierExtension ?: listOf(),
      type = this@CoverageCostToBeneficiaryExceptionSurrogate.type,
      period = this@CoverageCostToBeneficiaryExceptionSurrogate.period,
    )

  public companion object {
    public fun fromModel(
      model: Coverage.CostToBeneficiary.Exception
    ): CoverageCostToBeneficiaryExceptionSurrogate =
      with(model) {
        CoverageCostToBeneficiaryExceptionSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          period = this@with.period,
        )
      }
  }
}

@Serializable
internal data class CoverageCostToBeneficiaryValueSurrogate(
  public var valueQuantity: Quantity? = null,
  public var valueMoney: Money? = null,
) {
  public fun toModel(): Coverage.CostToBeneficiary.Value =
    Coverage.CostToBeneficiary.Value.from(
      this@CoverageCostToBeneficiaryValueSurrogate.valueQuantity,
      this@CoverageCostToBeneficiaryValueSurrogate.valueMoney,
    )!!

  public companion object {
    public fun fromModel(
      model: Coverage.CostToBeneficiary.Value
    ): CoverageCostToBeneficiaryValueSurrogate =
      with(model) {
        CoverageCostToBeneficiaryValueSurrogate(
          valueQuantity = this@with.asQuantity()?.value,
          valueMoney = this@with.asMoney()?.value,
        )
      }
  }
}

@Serializable
internal data class CoverageSurrogate(
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
  public var kind: KotlinString? = null,
  public var _kind: Element? = null,
  public var paymentBy: List<Coverage.PaymentBy>? = null,
  public var type: CodeableConcept? = null,
  public var policyHolder: Reference? = null,
  public var subscriber: Reference? = null,
  public var subscriberId: List<Identifier>? = null,
  public var beneficiary: Reference,
  public var dependent: KotlinString? = null,
  public var _dependent: Element? = null,
  public var relationship: CodeableConcept? = null,
  public var period: Period? = null,
  public var insurer: Reference? = null,
  public var `class`: List<Coverage.Class>? = null,
  public var order: Int? = null,
  public var _order: Element? = null,
  public var network: KotlinString? = null,
  public var _network: Element? = null,
  public var costToBeneficiary: List<Coverage.CostToBeneficiary>? = null,
  public var subrogation: KotlinBoolean? = null,
  public var _subrogation: Element? = null,
  public var contract: List<Reference>? = null,
  public var insurancePlan: Reference? = null,
) {
  public fun toModel(): Coverage =
    Coverage(
      id = this@CoverageSurrogate.id,
      meta = this@CoverageSurrogate.meta,
      implicitRules =
        Uri.of(this@CoverageSurrogate.implicitRules, this@CoverageSurrogate._implicitRules),
      language = Code.of(this@CoverageSurrogate.language, this@CoverageSurrogate._language),
      text = this@CoverageSurrogate.text,
      contained = this@CoverageSurrogate.contained ?: listOf(),
      extension = this@CoverageSurrogate.extension ?: listOf(),
      modifierExtension = this@CoverageSurrogate.modifierExtension ?: listOf(),
      identifier = this@CoverageSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          Coverage.FinancialResourceStatusCodes.fromCode(this@CoverageSurrogate.status!!),
          this@CoverageSurrogate._status,
        ),
      kind =
        Enumeration.of(
          Coverage.Kind.fromCode(this@CoverageSurrogate.kind!!),
          this@CoverageSurrogate._kind,
        ),
      paymentBy = this@CoverageSurrogate.paymentBy ?: listOf(),
      type = this@CoverageSurrogate.type,
      policyHolder = this@CoverageSurrogate.policyHolder,
      subscriber = this@CoverageSurrogate.subscriber,
      subscriberId = this@CoverageSurrogate.subscriberId ?: listOf(),
      beneficiary = this@CoverageSurrogate.beneficiary,
      dependent = R5String.of(this@CoverageSurrogate.dependent, this@CoverageSurrogate._dependent),
      relationship = this@CoverageSurrogate.relationship,
      period = this@CoverageSurrogate.period,
      insurer = this@CoverageSurrogate.insurer,
      `class` = this@CoverageSurrogate.`class` ?: listOf(),
      order = PositiveInt.of(this@CoverageSurrogate.order, this@CoverageSurrogate._order),
      network = R5String.of(this@CoverageSurrogate.network, this@CoverageSurrogate._network),
      costToBeneficiary = this@CoverageSurrogate.costToBeneficiary ?: listOf(),
      subrogation =
        R5Boolean.of(this@CoverageSurrogate.subrogation, this@CoverageSurrogate._subrogation),
      contract = this@CoverageSurrogate.contract ?: listOf(),
      insurancePlan = this@CoverageSurrogate.insurancePlan,
    )

  public companion object {
    public fun fromModel(model: Coverage): CoverageSurrogate =
      with(model) {
        CoverageSurrogate(
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
          kind = this@with.kind.value?.getCode(),
          _kind = this@with.kind.toElement(),
          paymentBy = this@with.paymentBy.takeIf { it.isNotEmpty() },
          type = this@with.type,
          policyHolder = this@with.policyHolder,
          subscriber = this@with.subscriber,
          subscriberId = this@with.subscriberId.takeIf { it.isNotEmpty() },
          beneficiary = this@with.beneficiary,
          dependent = this@with.dependent?.value,
          _dependent = this@with.dependent?.toElement(),
          relationship = this@with.relationship,
          period = this@with.period,
          insurer = this@with.insurer,
          `class` = this@with.`class`.takeIf { it.isNotEmpty() },
          order = this@with.order?.value,
          _order = this@with.order?.toElement(),
          network = this@with.network?.value,
          _network = this@with.network?.toElement(),
          costToBeneficiary = this@with.costToBeneficiary.takeIf { it.isNotEmpty() },
          subrogation = this@with.subrogation?.value,
          _subrogation = this@with.subrogation?.toElement(),
          contract = this@with.contract.takeIf { it.isNotEmpty() },
          insurancePlan = this@with.insurancePlan,
        )
      }
  }
}
