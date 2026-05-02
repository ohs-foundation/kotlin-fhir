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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r5.serializers

import com.google.fhir.model.r5.InsurancePlan
import com.google.fhir.model.r5.surrogates.InsurancePlanCoverageBenefitLimitSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanCoverageBenefitSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanCoverageSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanPlanGeneralCostSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanPlanSpecificCostBenefitCostSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanPlanSpecificCostBenefitSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanPlanSpecificCostSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanPlanSurrogate
import com.google.fhir.model.r5.surrogates.InsurancePlanSurrogate
import kotlin.Suppress
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

public object InsurancePlanCoverageSerializer : KSerializer<InsurancePlan.Coverage> {
  internal val surrogateSerializer: KSerializer<InsurancePlanCoverageSurrogate> by lazy {
    InsurancePlanCoverageSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Coverage", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage) {
    surrogateSerializer.serialize(encoder, InsurancePlanCoverageSurrogate.fromModel(value))
  }
}

public object InsurancePlanCoverageBenefitSerializer : KSerializer<InsurancePlan.Coverage.Benefit> {
  internal val surrogateSerializer: KSerializer<InsurancePlanCoverageBenefitSurrogate> by lazy {
    InsurancePlanCoverageBenefitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Benefit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit) {
    surrogateSerializer.serialize(encoder, InsurancePlanCoverageBenefitSurrogate.fromModel(value))
  }
}

public object InsurancePlanCoverageBenefitLimitSerializer :
  KSerializer<InsurancePlan.Coverage.Benefit.Limit> {
  internal val surrogateSerializer:
    KSerializer<InsurancePlanCoverageBenefitLimitSurrogate> by lazy {
    InsurancePlanCoverageBenefitLimitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Limit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Coverage.Benefit.Limit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Coverage.Benefit.Limit) {
    surrogateSerializer.serialize(
      encoder,
      InsurancePlanCoverageBenefitLimitSurrogate.fromModel(value),
    )
  }
}

public object InsurancePlanPlanSerializer : KSerializer<InsurancePlan.Plan> {
  internal val surrogateSerializer: KSerializer<InsurancePlanPlanSurrogate> by lazy {
    InsurancePlanPlanSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Plan", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan) {
    surrogateSerializer.serialize(encoder, InsurancePlanPlanSurrogate.fromModel(value))
  }
}

public object InsurancePlanPlanGeneralCostSerializer : KSerializer<InsurancePlan.Plan.GeneralCost> {
  internal val surrogateSerializer: KSerializer<InsurancePlanPlanGeneralCostSurrogate> by lazy {
    InsurancePlanPlanGeneralCostSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("GeneralCost", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.GeneralCost =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.GeneralCost) {
    surrogateSerializer.serialize(encoder, InsurancePlanPlanGeneralCostSurrogate.fromModel(value))
  }
}

public object InsurancePlanPlanSpecificCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost> {
  internal val surrogateSerializer: KSerializer<InsurancePlanPlanSpecificCostSurrogate> by lazy {
    InsurancePlanPlanSpecificCostSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("SpecificCost", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost) {
    surrogateSerializer.serialize(encoder, InsurancePlanPlanSpecificCostSurrogate.fromModel(value))
  }
}

public object InsurancePlanPlanSpecificCostBenefitSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit> {
  internal val surrogateSerializer:
    KSerializer<InsurancePlanPlanSpecificCostBenefitSurrogate> by lazy {
    InsurancePlanPlanSpecificCostBenefitSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Benefit", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit) {
    surrogateSerializer.serialize(
      encoder,
      InsurancePlanPlanSpecificCostBenefitSurrogate.fromModel(value),
    )
  }
}

public object InsurancePlanPlanSpecificCostBenefitCostSerializer :
  KSerializer<InsurancePlan.Plan.SpecificCost.Benefit.Cost> {
  internal val surrogateSerializer:
    KSerializer<InsurancePlanPlanSpecificCostBenefitCostSurrogate> by lazy {
    InsurancePlanPlanSpecificCostBenefitCostSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("Cost", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan.Plan.SpecificCost.Benefit.Cost =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan.Plan.SpecificCost.Benefit.Cost) {
    surrogateSerializer.serialize(
      encoder,
      InsurancePlanPlanSpecificCostBenefitCostSurrogate.fromModel(value),
    )
  }
}

public object InsurancePlanSerializer : KSerializer<InsurancePlan> {
  internal val surrogateSerializer: KSerializer<InsurancePlanSurrogate> by lazy {
    InsurancePlanSurrogate.serializer()
  }

  override val descriptor: SerialDescriptor by lazy {
    SerialDescriptor("InsurancePlan", surrogateSerializer.descriptor)
  }

  override fun deserialize(decoder: Decoder): InsurancePlan =
    surrogateSerializer.deserialize(decoder).toModel()

  override fun serialize(encoder: Encoder, `value`: InsurancePlan) {
    surrogateSerializer.serialize(encoder, InsurancePlanSurrogate.fromModel(value))
  }
}
