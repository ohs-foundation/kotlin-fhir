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

package com.google.fhir.model.r4.surrogates

import com.google.fhir.model.r4.Address
import com.google.fhir.model.r4.Attachment
import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.Coding
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Decimal
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
import com.google.fhir.model.r4.ExplanationOfBenefit
import com.google.fhir.model.r4.Extension
import com.google.fhir.model.r4.FhirDate
import com.google.fhir.model.r4.FhirDateTime
import com.google.fhir.model.r4.Identifier
import com.google.fhir.model.r4.Meta
import com.google.fhir.model.r4.Money
import com.google.fhir.model.r4.Narrative
import com.google.fhir.model.r4.Period
import com.google.fhir.model.r4.PositiveInt
import com.google.fhir.model.r4.Quantity
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.NoteType
import kotlin.Boolean as KotlinBoolean
import kotlin.Double
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class ExplanationOfBenefitRelatedSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var claim: Reference? = null,
  public var relationship: CodeableConcept? = null,
  public var reference: Identifier? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Related =
    ExplanationOfBenefit.Related(
      id = this@ExplanationOfBenefitRelatedSurrogate.id,
      extension = this@ExplanationOfBenefitRelatedSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitRelatedSurrogate.modifierExtension ?: listOf(),
      claim = this@ExplanationOfBenefitRelatedSurrogate.claim,
      relationship = this@ExplanationOfBenefitRelatedSurrogate.relationship,
      reference = this@ExplanationOfBenefitRelatedSurrogate.reference,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Related
    ): ExplanationOfBenefitRelatedSurrogate =
      with(model) {
        ExplanationOfBenefitRelatedSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          claim = this@with.claim,
          relationship = this@with.relationship,
          reference = this@with.reference,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitPayeeSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var party: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Payee =
    ExplanationOfBenefit.Payee(
      id = this@ExplanationOfBenefitPayeeSurrogate.id,
      extension = this@ExplanationOfBenefitPayeeSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitPayeeSurrogate.modifierExtension ?: listOf(),
      type = this@ExplanationOfBenefitPayeeSurrogate.type,
      party = this@ExplanationOfBenefitPayeeSurrogate.party,
    )

  public companion object {
    public fun fromModel(model: ExplanationOfBenefit.Payee): ExplanationOfBenefitPayeeSurrogate =
      with(model) {
        ExplanationOfBenefitPayeeSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          party = this@with.party,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitCareTeamSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var provider: Reference,
  public var responsible: KotlinBoolean? = null,
  public var _responsible: Element? = null,
  public var role: CodeableConcept? = null,
  public var qualification: CodeableConcept? = null,
) {
  public fun toModel(): ExplanationOfBenefit.CareTeam =
    ExplanationOfBenefit.CareTeam(
      id = this@ExplanationOfBenefitCareTeamSurrogate.id,
      extension = this@ExplanationOfBenefitCareTeamSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitCareTeamSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitCareTeamSurrogate.sequence,
          this@ExplanationOfBenefitCareTeamSurrogate._sequence,
        )!!,
      provider = this@ExplanationOfBenefitCareTeamSurrogate.provider,
      responsible =
        R4Boolean.of(
          this@ExplanationOfBenefitCareTeamSurrogate.responsible,
          this@ExplanationOfBenefitCareTeamSurrogate._responsible,
        ),
      role = this@ExplanationOfBenefitCareTeamSurrogate.role,
      qualification = this@ExplanationOfBenefitCareTeamSurrogate.qualification,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.CareTeam
    ): ExplanationOfBenefitCareTeamSurrogate =
      with(model) {
        ExplanationOfBenefitCareTeamSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          provider = this@with.provider,
          responsible = this@with.responsible?.value,
          _responsible = this@with.responsible?.toElement(),
          role = this@with.role,
          qualification = this@with.qualification,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitSupportingInfoSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var category: CodeableConcept,
  public var code: CodeableConcept? = null,
  public var timing: ExplanationOfBenefit.SupportingInfo.Timing? = null,
  public var `value`: ExplanationOfBenefit.SupportingInfo.Value? = null,
  public var reason: Coding? = null,
) {
  public fun toModel(): ExplanationOfBenefit.SupportingInfo =
    ExplanationOfBenefit.SupportingInfo(
      id = this@ExplanationOfBenefitSupportingInfoSurrogate.id,
      extension = this@ExplanationOfBenefitSupportingInfoSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitSupportingInfoSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitSupportingInfoSurrogate.sequence,
          this@ExplanationOfBenefitSupportingInfoSurrogate._sequence,
        )!!,
      category = this@ExplanationOfBenefitSupportingInfoSurrogate.category,
      code = this@ExplanationOfBenefitSupportingInfoSurrogate.code,
      timing = this@ExplanationOfBenefitSupportingInfoSurrogate.timing,
      `value` = this@ExplanationOfBenefitSupportingInfoSurrogate.`value`,
      reason = this@ExplanationOfBenefitSupportingInfoSurrogate.reason,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.SupportingInfo
    ): ExplanationOfBenefitSupportingInfoSurrogate =
      with(model) {
        ExplanationOfBenefitSupportingInfoSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          category = this@with.category,
          code = this@with.code,
          timing = this@with.timing,
          `value` = this@with.`value`,
          reason = this@with.reason,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitDiagnosisSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var diagnosis: ExplanationOfBenefit.Diagnosis.Diagnosis,
  public var type: List<CodeableConcept>? = null,
  public var onAdmission: CodeableConcept? = null,
  public var packageCode: CodeableConcept? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Diagnosis =
    ExplanationOfBenefit.Diagnosis(
      id = this@ExplanationOfBenefitDiagnosisSurrogate.id,
      extension = this@ExplanationOfBenefitDiagnosisSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitDiagnosisSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitDiagnosisSurrogate.sequence,
          this@ExplanationOfBenefitDiagnosisSurrogate._sequence,
        )!!,
      diagnosis = this@ExplanationOfBenefitDiagnosisSurrogate.diagnosis,
      type = this@ExplanationOfBenefitDiagnosisSurrogate.type ?: listOf(),
      onAdmission = this@ExplanationOfBenefitDiagnosisSurrogate.onAdmission,
      packageCode = this@ExplanationOfBenefitDiagnosisSurrogate.packageCode,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Diagnosis
    ): ExplanationOfBenefitDiagnosisSurrogate =
      with(model) {
        ExplanationOfBenefitDiagnosisSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          diagnosis = this@with.diagnosis,
          type = this@with.type.takeIf { it.isNotEmpty() },
          onAdmission = this@with.onAdmission,
          packageCode = this@with.packageCode,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitProcedureSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var type: List<CodeableConcept>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var procedure: ExplanationOfBenefit.Procedure.Procedure,
  public var udi: List<Reference>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Procedure =
    ExplanationOfBenefit.Procedure(
      id = this@ExplanationOfBenefitProcedureSurrogate.id,
      extension = this@ExplanationOfBenefitProcedureSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitProcedureSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitProcedureSurrogate.sequence,
          this@ExplanationOfBenefitProcedureSurrogate._sequence,
        )!!,
      type = this@ExplanationOfBenefitProcedureSurrogate.type ?: listOf(),
      date =
        DateTime.of(
          FhirDateTime.fromString(this@ExplanationOfBenefitProcedureSurrogate.date),
          this@ExplanationOfBenefitProcedureSurrogate._date,
        ),
      procedure = this@ExplanationOfBenefitProcedureSurrogate.procedure,
      udi = this@ExplanationOfBenefitProcedureSurrogate.udi ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Procedure
    ): ExplanationOfBenefitProcedureSurrogate =
      with(model) {
        ExplanationOfBenefitProcedureSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          type = this@with.type.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          procedure = this@with.procedure,
          udi = this@with.udi.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitInsuranceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var focal: KotlinBoolean? = null,
  public var _focal: Element? = null,
  public var coverage: Reference,
  public var preAuthRef: List<KotlinString?>? = null,
  public var _preAuthRef: List<Element?>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Insurance =
    ExplanationOfBenefit.Insurance(
      id = this@ExplanationOfBenefitInsuranceSurrogate.id,
      extension = this@ExplanationOfBenefitInsuranceSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitInsuranceSurrogate.modifierExtension ?: listOf(),
      focal =
        R4Boolean.of(
          this@ExplanationOfBenefitInsuranceSurrogate.focal,
          this@ExplanationOfBenefitInsuranceSurrogate._focal,
        )!!,
      coverage = this@ExplanationOfBenefitInsuranceSurrogate.coverage,
      preAuthRef =
        if (
          this@ExplanationOfBenefitInsuranceSurrogate.preAuthRef == null &&
            this@ExplanationOfBenefitInsuranceSurrogate._preAuthRef == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitInsuranceSurrogate.preAuthRef
              ?: List(this@ExplanationOfBenefitInsuranceSurrogate._preAuthRef!!.size) { null })
            .zip(
              this@ExplanationOfBenefitInsuranceSurrogate._preAuthRef
                ?: List(this@ExplanationOfBenefitInsuranceSurrogate.preAuthRef!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Insurance
    ): ExplanationOfBenefitInsuranceSurrogate =
      with(model) {
        ExplanationOfBenefitInsuranceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          focal = this@with.focal.value,
          _focal = this@with.focal.toElement(),
          coverage = this@with.coverage,
          preAuthRef =
            this@with.preAuthRef.map { it.value }.toList().takeUnless { it.all { it == null } },
          _preAuthRef =
            this@with.preAuthRef
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAccidentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var type: CodeableConcept? = null,
  public var location: ExplanationOfBenefit.Accident.Location? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Accident =
    ExplanationOfBenefit.Accident(
      id = this@ExplanationOfBenefitAccidentSurrogate.id,
      extension = this@ExplanationOfBenefitAccidentSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitAccidentSurrogate.modifierExtension ?: listOf(),
      date =
        Date.of(
          FhirDate.fromString(this@ExplanationOfBenefitAccidentSurrogate.date),
          this@ExplanationOfBenefitAccidentSurrogate._date,
        ),
      type = this@ExplanationOfBenefitAccidentSurrogate.type,
      location = this@ExplanationOfBenefitAccidentSurrogate.location,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Accident
    ): ExplanationOfBenefitAccidentSurrogate =
      with(model) {
        ExplanationOfBenefitAccidentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          type = this@with.type,
          location = this@with.location,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var careTeamSequence: List<Int?>? = null,
  public var _careTeamSequence: List<Element?>? = null,
  public var diagnosisSequence: List<Int?>? = null,
  public var _diagnosisSequence: List<Element?>? = null,
  public var procedureSequence: List<Int?>? = null,
  public var _procedureSequence: List<Element?>? = null,
  public var informationSequence: List<Int?>? = null,
  public var _informationSequence: List<Element?>? = null,
  public var revenue: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var programCode: List<CodeableConcept>? = null,
  public var serviced: ExplanationOfBenefit.Item.Serviced? = null,
  public var location: ExplanationOfBenefit.Item.Location? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var udi: List<Reference>? = null,
  public var bodySite: CodeableConcept? = null,
  public var subSite: List<CodeableConcept>? = null,
  public var encounter: List<Reference>? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
  public var detail: List<ExplanationOfBenefit.Item.Detail>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item =
    ExplanationOfBenefit.Item(
      id = this@ExplanationOfBenefitItemSurrogate.id,
      extension = this@ExplanationOfBenefitItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitItemSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitItemSurrogate.sequence,
          this@ExplanationOfBenefitItemSurrogate._sequence,
        )!!,
      careTeamSequence =
        if (
          this@ExplanationOfBenefitItemSurrogate.careTeamSequence == null &&
            this@ExplanationOfBenefitItemSurrogate._careTeamSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemSurrogate.careTeamSequence
              ?: List(this@ExplanationOfBenefitItemSurrogate._careTeamSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemSurrogate._careTeamSequence
                ?: List(this@ExplanationOfBenefitItemSurrogate.careTeamSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      diagnosisSequence =
        if (
          this@ExplanationOfBenefitItemSurrogate.diagnosisSequence == null &&
            this@ExplanationOfBenefitItemSurrogate._diagnosisSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemSurrogate.diagnosisSequence
              ?: List(this@ExplanationOfBenefitItemSurrogate._diagnosisSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemSurrogate._diagnosisSequence
                ?: List(this@ExplanationOfBenefitItemSurrogate.diagnosisSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      procedureSequence =
        if (
          this@ExplanationOfBenefitItemSurrogate.procedureSequence == null &&
            this@ExplanationOfBenefitItemSurrogate._procedureSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemSurrogate.procedureSequence
              ?: List(this@ExplanationOfBenefitItemSurrogate._procedureSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemSurrogate._procedureSequence
                ?: List(this@ExplanationOfBenefitItemSurrogate.procedureSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      informationSequence =
        if (
          this@ExplanationOfBenefitItemSurrogate.informationSequence == null &&
            this@ExplanationOfBenefitItemSurrogate._informationSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemSurrogate.informationSequence
              ?: List(this@ExplanationOfBenefitItemSurrogate._informationSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemSurrogate._informationSequence
                ?: List(this@ExplanationOfBenefitItemSurrogate.informationSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      revenue = this@ExplanationOfBenefitItemSurrogate.revenue,
      category = this@ExplanationOfBenefitItemSurrogate.category,
      productOrService = this@ExplanationOfBenefitItemSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitItemSurrogate.modifier ?: listOf(),
      programCode = this@ExplanationOfBenefitItemSurrogate.programCode ?: listOf(),
      serviced = this@ExplanationOfBenefitItemSurrogate.serviced,
      location = this@ExplanationOfBenefitItemSurrogate.location,
      quantity = this@ExplanationOfBenefitItemSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitItemSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitItemSurrogate.factor,
          this@ExplanationOfBenefitItemSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitItemSurrogate.net,
      udi = this@ExplanationOfBenefitItemSurrogate.udi ?: listOf(),
      bodySite = this@ExplanationOfBenefitItemSurrogate.bodySite,
      subSite = this@ExplanationOfBenefitItemSurrogate.subSite ?: listOf(),
      encounter = this@ExplanationOfBenefitItemSurrogate.encounter ?: listOf(),
      noteNumber =
        if (
          this@ExplanationOfBenefitItemSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitItemSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitItemSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemSurrogate._noteNumber
                ?: List(this@ExplanationOfBenefitItemSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ExplanationOfBenefitItemSurrogate.adjudication ?: listOf(),
      detail = this@ExplanationOfBenefitItemSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ExplanationOfBenefit.Item): ExplanationOfBenefitItemSurrogate =
      with(model) {
        ExplanationOfBenefitItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          careTeamSequence =
            this@with.careTeamSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _careTeamSequence =
            this@with.careTeamSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          diagnosisSequence =
            this@with.diagnosisSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _diagnosisSequence =
            this@with.diagnosisSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          procedureSequence =
            this@with.procedureSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _procedureSequence =
            this@with.procedureSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          informationSequence =
            this@with.informationSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _informationSequence =
            this@with.informationSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          revenue = this@with.revenue,
          category = this@with.category,
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          programCode = this@with.programCode.takeIf { it.isNotEmpty() },
          serviced = this@with.serviced,
          location = this@with.location,
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          udi = this@with.udi.takeIf { it.isNotEmpty() },
          bodySite = this@with.bodySite,
          subSite = this@with.subSite.takeIf { it.isNotEmpty() },
          encounter = this@with.encounter.takeIf { it.isNotEmpty() },
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemAdjudicationSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var reason: CodeableConcept? = null,
  public var amount: Money? = null,
  public var `value`: Double? = null,
  public var _value: Element? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item.Adjudication =
    ExplanationOfBenefit.Item.Adjudication(
      id = this@ExplanationOfBenefitItemAdjudicationSurrogate.id,
      extension = this@ExplanationOfBenefitItemAdjudicationSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitItemAdjudicationSurrogate.modifierExtension ?: listOf(),
      category = this@ExplanationOfBenefitItemAdjudicationSurrogate.category,
      reason = this@ExplanationOfBenefitItemAdjudicationSurrogate.reason,
      amount = this@ExplanationOfBenefitItemAdjudicationSurrogate.amount,
      `value` =
        Decimal.of(
          this@ExplanationOfBenefitItemAdjudicationSurrogate.`value`,
          this@ExplanationOfBenefitItemAdjudicationSurrogate._value,
        ),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Item.Adjudication
    ): ExplanationOfBenefitItemAdjudicationSurrogate =
      with(model) {
        ExplanationOfBenefitItemAdjudicationSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          reason = this@with.reason,
          amount = this@with.amount,
          `value` = this@with.`value`?.value?.toString()?.toDouble(),
          _value = this@with.`value`?.toElement(),
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var revenue: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var programCode: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var udi: List<Reference>? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
  public var subDetail: List<ExplanationOfBenefit.Item.Detail.SubDetail>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item.Detail =
    ExplanationOfBenefit.Item.Detail(
      id = this@ExplanationOfBenefitItemDetailSurrogate.id,
      extension = this@ExplanationOfBenefitItemDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitItemDetailSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitItemDetailSurrogate.sequence,
          this@ExplanationOfBenefitItemDetailSurrogate._sequence,
        )!!,
      revenue = this@ExplanationOfBenefitItemDetailSurrogate.revenue,
      category = this@ExplanationOfBenefitItemDetailSurrogate.category,
      productOrService = this@ExplanationOfBenefitItemDetailSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitItemDetailSurrogate.modifier ?: listOf(),
      programCode = this@ExplanationOfBenefitItemDetailSurrogate.programCode ?: listOf(),
      quantity = this@ExplanationOfBenefitItemDetailSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitItemDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitItemDetailSurrogate.factor,
          this@ExplanationOfBenefitItemDetailSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitItemDetailSurrogate.net,
      udi = this@ExplanationOfBenefitItemDetailSurrogate.udi ?: listOf(),
      noteNumber =
        if (
          this@ExplanationOfBenefitItemDetailSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitItemDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemDetailSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitItemDetailSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ExplanationOfBenefitItemDetailSurrogate._noteNumber
                ?: List(this@ExplanationOfBenefitItemDetailSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ExplanationOfBenefitItemDetailSurrogate.adjudication ?: listOf(),
      subDetail = this@ExplanationOfBenefitItemDetailSurrogate.subDetail ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Item.Detail
    ): ExplanationOfBenefitItemDetailSurrogate =
      with(model) {
        ExplanationOfBenefitItemDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          revenue = this@with.revenue,
          category = this@with.category,
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          programCode = this@with.programCode.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          udi = this@with.udi.takeIf { it.isNotEmpty() },
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          subDetail = this@with.subDetail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemDetailSubDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var revenue: CodeableConcept? = null,
  public var category: CodeableConcept? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var programCode: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var udi: List<Reference>? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item.Detail.SubDetail =
    ExplanationOfBenefit.Item.Detail.SubDetail(
      id = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.id,
      extension = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitItemDetailSubDetailSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@ExplanationOfBenefitItemDetailSubDetailSurrogate.sequence,
          this@ExplanationOfBenefitItemDetailSubDetailSurrogate._sequence,
        )!!,
      revenue = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.revenue,
      category = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.category,
      productOrService = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.modifier ?: listOf(),
      programCode = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.programCode ?: listOf(),
      quantity = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitItemDetailSubDetailSurrogate.factor,
          this@ExplanationOfBenefitItemDetailSubDetailSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.net,
      udi = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.udi ?: listOf(),
      noteNumber =
        if (
          this@ExplanationOfBenefitItemDetailSubDetailSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitItemDetailSubDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitItemDetailSubDetailSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitItemDetailSubDetailSurrogate._noteNumber!!.size) {
                null
              })
            .zip(
              this@ExplanationOfBenefitItemDetailSubDetailSurrogate._noteNumber
                ?: List(this@ExplanationOfBenefitItemDetailSubDetailSurrogate.noteNumber!!.size) {
                  null
                }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ExplanationOfBenefitItemDetailSubDetailSurrogate.adjudication ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Item.Detail.SubDetail
    ): ExplanationOfBenefitItemDetailSubDetailSurrogate =
      with(model) {
        ExplanationOfBenefitItemDetailSubDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          revenue = this@with.revenue,
          category = this@with.category,
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          programCode = this@with.programCode.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          udi = this@with.udi.takeIf { it.isNotEmpty() },
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAddItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var itemSequence: List<Int?>? = null,
  public var _itemSequence: List<Element?>? = null,
  public var detailSequence: List<Int?>? = null,
  public var _detailSequence: List<Element?>? = null,
  public var subDetailSequence: List<Int?>? = null,
  public var _subDetailSequence: List<Element?>? = null,
  public var provider: List<Reference>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var programCode: List<CodeableConcept>? = null,
  public var serviced: ExplanationOfBenefit.AddItem.Serviced? = null,
  public var location: ExplanationOfBenefit.AddItem.Location? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var bodySite: CodeableConcept? = null,
  public var subSite: List<CodeableConcept>? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
  public var detail: List<ExplanationOfBenefit.AddItem.Detail>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.AddItem =
    ExplanationOfBenefit.AddItem(
      id = this@ExplanationOfBenefitAddItemSurrogate.id,
      extension = this@ExplanationOfBenefitAddItemSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitAddItemSurrogate.modifierExtension ?: listOf(),
      itemSequence =
        if (
          this@ExplanationOfBenefitAddItemSurrogate.itemSequence == null &&
            this@ExplanationOfBenefitAddItemSurrogate._itemSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemSurrogate.itemSequence
              ?: List(this@ExplanationOfBenefitAddItemSurrogate._itemSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitAddItemSurrogate._itemSequence
                ?: List(this@ExplanationOfBenefitAddItemSurrogate.itemSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      detailSequence =
        if (
          this@ExplanationOfBenefitAddItemSurrogate.detailSequence == null &&
            this@ExplanationOfBenefitAddItemSurrogate._detailSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemSurrogate.detailSequence
              ?: List(this@ExplanationOfBenefitAddItemSurrogate._detailSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitAddItemSurrogate._detailSequence
                ?: List(this@ExplanationOfBenefitAddItemSurrogate.detailSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      subDetailSequence =
        if (
          this@ExplanationOfBenefitAddItemSurrogate.subDetailSequence == null &&
            this@ExplanationOfBenefitAddItemSurrogate._subDetailSequence == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemSurrogate.subDetailSequence
              ?: List(this@ExplanationOfBenefitAddItemSurrogate._subDetailSequence!!.size) { null })
            .zip(
              this@ExplanationOfBenefitAddItemSurrogate._subDetailSequence
                ?: List(this@ExplanationOfBenefitAddItemSurrogate.subDetailSequence!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      provider = this@ExplanationOfBenefitAddItemSurrogate.provider ?: listOf(),
      productOrService = this@ExplanationOfBenefitAddItemSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitAddItemSurrogate.modifier ?: listOf(),
      programCode = this@ExplanationOfBenefitAddItemSurrogate.programCode ?: listOf(),
      serviced = this@ExplanationOfBenefitAddItemSurrogate.serviced,
      location = this@ExplanationOfBenefitAddItemSurrogate.location,
      quantity = this@ExplanationOfBenefitAddItemSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitAddItemSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitAddItemSurrogate.factor,
          this@ExplanationOfBenefitAddItemSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitAddItemSurrogate.net,
      bodySite = this@ExplanationOfBenefitAddItemSurrogate.bodySite,
      subSite = this@ExplanationOfBenefitAddItemSurrogate.subSite ?: listOf(),
      noteNumber =
        if (
          this@ExplanationOfBenefitAddItemSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitAddItemSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitAddItemSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ExplanationOfBenefitAddItemSurrogate._noteNumber
                ?: List(this@ExplanationOfBenefitAddItemSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ExplanationOfBenefitAddItemSurrogate.adjudication ?: listOf(),
      detail = this@ExplanationOfBenefitAddItemSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.AddItem
    ): ExplanationOfBenefitAddItemSurrogate =
      with(model) {
        ExplanationOfBenefitAddItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          itemSequence =
            this@with.itemSequence.map { it.value }.toList().takeUnless { it.all { it == null } },
          _itemSequence =
            this@with.itemSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          detailSequence =
            this@with.detailSequence.map { it.value }.toList().takeUnless { it.all { it == null } },
          _detailSequence =
            this@with.detailSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          subDetailSequence =
            this@with.subDetailSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _subDetailSequence =
            this@with.subDetailSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          provider = this@with.provider.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          programCode = this@with.programCode.takeIf { it.isNotEmpty() },
          serviced = this@with.serviced,
          location = this@with.location,
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          bodySite = this@with.bodySite,
          subSite = this@with.subSite.takeIf { it.isNotEmpty() },
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAddItemDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
  public var subDetail: List<ExplanationOfBenefit.AddItem.Detail.SubDetail>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.AddItem.Detail =
    ExplanationOfBenefit.AddItem.Detail(
      id = this@ExplanationOfBenefitAddItemDetailSurrogate.id,
      extension = this@ExplanationOfBenefitAddItemDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitAddItemDetailSurrogate.modifierExtension ?: listOf(),
      productOrService = this@ExplanationOfBenefitAddItemDetailSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitAddItemDetailSurrogate.modifier ?: listOf(),
      quantity = this@ExplanationOfBenefitAddItemDetailSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitAddItemDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitAddItemDetailSurrogate.factor,
          this@ExplanationOfBenefitAddItemDetailSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitAddItemDetailSurrogate.net,
      noteNumber =
        if (
          this@ExplanationOfBenefitAddItemDetailSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitAddItemDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemDetailSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitAddItemDetailSurrogate._noteNumber!!.size) { null })
            .zip(
              this@ExplanationOfBenefitAddItemDetailSurrogate._noteNumber
                ?: List(this@ExplanationOfBenefitAddItemDetailSurrogate.noteNumber!!.size) { null }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication = this@ExplanationOfBenefitAddItemDetailSurrogate.adjudication ?: listOf(),
      subDetail = this@ExplanationOfBenefitAddItemDetailSurrogate.subDetail ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.AddItem.Detail
    ): ExplanationOfBenefitAddItemDetailSurrogate =
      with(model) {
        ExplanationOfBenefitAddItemDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          subDetail = this@with.subDetail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAddItemDetailSubDetailSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var productOrService: CodeableConcept,
  public var modifier: List<CodeableConcept>? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var factor: Double? = null,
  public var _factor: Element? = null,
  public var net: Money? = null,
  public var noteNumber: List<Int?>? = null,
  public var _noteNumber: List<Element?>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.AddItem.Detail.SubDetail =
    ExplanationOfBenefit.AddItem.Detail.SubDetail(
      id = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.id,
      extension = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.modifierExtension ?: listOf(),
      productOrService = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.productOrService,
      modifier = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.modifier ?: listOf(),
      quantity = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.quantity,
      unitPrice = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.unitPrice,
      factor =
        Decimal.of(
          this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.factor,
          this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate._factor,
        ),
      net = this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.net,
      noteNumber =
        if (
          this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.noteNumber == null &&
            this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate._noteNumber == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.noteNumber
              ?: List(this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate._noteNumber!!.size) {
                null
              })
            .zip(
              this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate._noteNumber
                ?: List(
                  this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.noteNumber!!.size
                ) {
                  null
                }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      adjudication =
        this@ExplanationOfBenefitAddItemDetailSubDetailSurrogate.adjudication ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.AddItem.Detail.SubDetail
    ): ExplanationOfBenefitAddItemDetailSubDetailSurrogate =
      with(model) {
        ExplanationOfBenefitAddItemDetailSubDetailSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          factor = this@with.factor?.value?.toString()?.toDouble(),
          _factor = this@with.factor?.toElement(),
          net = this@with.net,
          noteNumber =
            this@with.noteNumber.map { it.value }.toList().takeUnless { it.all { it == null } },
          _noteNumber =
            this@with.noteNumber
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitTotalSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var amount: Money,
) {
  public fun toModel(): ExplanationOfBenefit.Total =
    ExplanationOfBenefit.Total(
      id = this@ExplanationOfBenefitTotalSurrogate.id,
      extension = this@ExplanationOfBenefitTotalSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitTotalSurrogate.modifierExtension ?: listOf(),
      category = this@ExplanationOfBenefitTotalSurrogate.category,
      amount = this@ExplanationOfBenefitTotalSurrogate.amount,
    )

  public companion object {
    public fun fromModel(model: ExplanationOfBenefit.Total): ExplanationOfBenefitTotalSurrogate =
      with(model) {
        ExplanationOfBenefitTotalSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          amount = this@with.amount,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitPaymentSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept? = null,
  public var adjustment: Money? = null,
  public var adjustmentReason: CodeableConcept? = null,
  public var date: KotlinString? = null,
  public var _date: Element? = null,
  public var amount: Money? = null,
  public var identifier: Identifier? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Payment =
    ExplanationOfBenefit.Payment(
      id = this@ExplanationOfBenefitPaymentSurrogate.id,
      extension = this@ExplanationOfBenefitPaymentSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitPaymentSurrogate.modifierExtension ?: listOf(),
      type = this@ExplanationOfBenefitPaymentSurrogate.type,
      adjustment = this@ExplanationOfBenefitPaymentSurrogate.adjustment,
      adjustmentReason = this@ExplanationOfBenefitPaymentSurrogate.adjustmentReason,
      date =
        Date.of(
          FhirDate.fromString(this@ExplanationOfBenefitPaymentSurrogate.date),
          this@ExplanationOfBenefitPaymentSurrogate._date,
        ),
      amount = this@ExplanationOfBenefitPaymentSurrogate.amount,
      identifier = this@ExplanationOfBenefitPaymentSurrogate.identifier,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Payment
    ): ExplanationOfBenefitPaymentSurrogate =
      with(model) {
        ExplanationOfBenefitPaymentSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          adjustment = this@with.adjustment,
          adjustmentReason = this@with.adjustmentReason,
          date = this@with.date?.value?.toString(),
          _date = this@with.date?.toElement(),
          amount = this@with.amount,
          identifier = this@with.identifier,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitProcessNoteSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var number: Int? = null,
  public var _number: Element? = null,
  public var type: KotlinString? = null,
  public var _type: Element? = null,
  public var text: KotlinString? = null,
  public var _text: Element? = null,
  public var language: CodeableConcept? = null,
) {
  public fun toModel(): ExplanationOfBenefit.ProcessNote =
    ExplanationOfBenefit.ProcessNote(
      id = this@ExplanationOfBenefitProcessNoteSurrogate.id,
      extension = this@ExplanationOfBenefitProcessNoteSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitProcessNoteSurrogate.modifierExtension ?: listOf(),
      number =
        PositiveInt.of(
          this@ExplanationOfBenefitProcessNoteSurrogate.number,
          this@ExplanationOfBenefitProcessNoteSurrogate._number,
        ),
      type =
        this@ExplanationOfBenefitProcessNoteSurrogate.type?.let {
          Enumeration.of(NoteType.fromCode(it), this@ExplanationOfBenefitProcessNoteSurrogate._type)
        },
      text =
        R4String.of(
          this@ExplanationOfBenefitProcessNoteSurrogate.text,
          this@ExplanationOfBenefitProcessNoteSurrogate._text,
        ),
      language = this@ExplanationOfBenefitProcessNoteSurrogate.language,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.ProcessNote
    ): ExplanationOfBenefitProcessNoteSurrogate =
      with(model) {
        ExplanationOfBenefitProcessNoteSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          number = this@with.number?.value,
          _number = this@with.number?.toElement(),
          type = this@with.type?.value?.getCode(),
          _type = this@with.type?.toElement(),
          text = this@with.text?.value,
          _text = this@with.text?.toElement(),
          language = this@with.language,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitBenefitBalanceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept,
  public var excluded: KotlinBoolean? = null,
  public var _excluded: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var network: CodeableConcept? = null,
  public var unit: CodeableConcept? = null,
  public var term: CodeableConcept? = null,
  public var financial: List<ExplanationOfBenefit.BenefitBalance.Financial>? = null,
) {
  public fun toModel(): ExplanationOfBenefit.BenefitBalance =
    ExplanationOfBenefit.BenefitBalance(
      id = this@ExplanationOfBenefitBenefitBalanceSurrogate.id,
      extension = this@ExplanationOfBenefitBenefitBalanceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitBenefitBalanceSurrogate.modifierExtension ?: listOf(),
      category = this@ExplanationOfBenefitBenefitBalanceSurrogate.category,
      excluded =
        R4Boolean.of(
          this@ExplanationOfBenefitBenefitBalanceSurrogate.excluded,
          this@ExplanationOfBenefitBenefitBalanceSurrogate._excluded,
        ),
      name =
        R4String.of(
          this@ExplanationOfBenefitBenefitBalanceSurrogate.name,
          this@ExplanationOfBenefitBenefitBalanceSurrogate._name,
        ),
      description =
        R4String.of(
          this@ExplanationOfBenefitBenefitBalanceSurrogate.description,
          this@ExplanationOfBenefitBenefitBalanceSurrogate._description,
        ),
      network = this@ExplanationOfBenefitBenefitBalanceSurrogate.network,
      unit = this@ExplanationOfBenefitBenefitBalanceSurrogate.unit,
      term = this@ExplanationOfBenefitBenefitBalanceSurrogate.term,
      financial = this@ExplanationOfBenefitBenefitBalanceSurrogate.financial ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.BenefitBalance
    ): ExplanationOfBenefitBenefitBalanceSurrogate =
      with(model) {
        ExplanationOfBenefitBenefitBalanceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          excluded = this@with.excluded?.value,
          _excluded = this@with.excluded?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          network = this@with.network,
          unit = this@with.unit,
          term = this@with.term,
          financial = this@with.financial.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitBenefitBalanceFinancialSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var allowed: ExplanationOfBenefit.BenefitBalance.Financial.Allowed? = null,
  public var used: ExplanationOfBenefit.BenefitBalance.Financial.Used? = null,
) {
  public fun toModel(): ExplanationOfBenefit.BenefitBalance.Financial =
    ExplanationOfBenefit.BenefitBalance.Financial(
      id = this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.id,
      extension = this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.extension ?: listOf(),
      modifierExtension =
        this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.modifierExtension ?: listOf(),
      type = this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.type,
      allowed = this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.allowed,
      used = this@ExplanationOfBenefitBenefitBalanceFinancialSurrogate.used,
    )

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.BenefitBalance.Financial
    ): ExplanationOfBenefitBenefitBalanceFinancialSurrogate =
      with(model) {
        ExplanationOfBenefitBenefitBalanceFinancialSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          type = this@with.type,
          allowed = this@with.allowed,
          used = this@with.used,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitSupportingInfoTimingSurrogate(
  public var timingDate: KotlinString? = null,
  public var _timingDate: Element? = null,
  public var timingPeriod: Period? = null,
) {
  public fun toModel(): ExplanationOfBenefit.SupportingInfo.Timing =
    ExplanationOfBenefit.SupportingInfo.Timing.from(
      Date.of(
        FhirDate.fromString(this@ExplanationOfBenefitSupportingInfoTimingSurrogate.timingDate),
        this@ExplanationOfBenefitSupportingInfoTimingSurrogate._timingDate,
      ),
      this@ExplanationOfBenefitSupportingInfoTimingSurrogate.timingPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.SupportingInfo.Timing
    ): ExplanationOfBenefitSupportingInfoTimingSurrogate =
      with(model) {
        ExplanationOfBenefitSupportingInfoTimingSurrogate(
          timingDate = this@with.asDate()?.value?.value?.toString(),
          _timingDate = this@with.asDate()?.value?.toElement(),
          timingPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitSupportingInfoValueSurrogate(
  public var valueBoolean: KotlinBoolean? = null,
  public var _valueBoolean: Element? = null,
  public var valueString: KotlinString? = null,
  public var _valueString: Element? = null,
  public var valueQuantity: Quantity? = null,
  public var valueAttachment: Attachment? = null,
  public var valueReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.SupportingInfo.Value =
    ExplanationOfBenefit.SupportingInfo.Value.from(
      R4Boolean.of(
        this@ExplanationOfBenefitSupportingInfoValueSurrogate.valueBoolean,
        this@ExplanationOfBenefitSupportingInfoValueSurrogate._valueBoolean,
      ),
      R4String.of(
        this@ExplanationOfBenefitSupportingInfoValueSurrogate.valueString,
        this@ExplanationOfBenefitSupportingInfoValueSurrogate._valueString,
      ),
      this@ExplanationOfBenefitSupportingInfoValueSurrogate.valueQuantity,
      this@ExplanationOfBenefitSupportingInfoValueSurrogate.valueAttachment,
      this@ExplanationOfBenefitSupportingInfoValueSurrogate.valueReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.SupportingInfo.Value
    ): ExplanationOfBenefitSupportingInfoValueSurrogate =
      with(model) {
        ExplanationOfBenefitSupportingInfoValueSurrogate(
          valueBoolean = this@with.asBoolean()?.value?.value,
          _valueBoolean = this@with.asBoolean()?.value?.toElement(),
          valueString = this@with.asString()?.value?.value,
          _valueString = this@with.asString()?.value?.toElement(),
          valueQuantity = this@with.asQuantity()?.value,
          valueAttachment = this@with.asAttachment()?.value,
          valueReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitDiagnosisDiagnosisSurrogate(
  public var diagnosisCodeableConcept: CodeableConcept? = null,
  public var diagnosisReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Diagnosis.Diagnosis =
    ExplanationOfBenefit.Diagnosis.Diagnosis.from(
      this@ExplanationOfBenefitDiagnosisDiagnosisSurrogate.diagnosisCodeableConcept,
      this@ExplanationOfBenefitDiagnosisDiagnosisSurrogate.diagnosisReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Diagnosis.Diagnosis
    ): ExplanationOfBenefitDiagnosisDiagnosisSurrogate =
      with(model) {
        ExplanationOfBenefitDiagnosisDiagnosisSurrogate(
          diagnosisCodeableConcept = this@with.asCodeableConcept()?.value,
          diagnosisReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitProcedureProcedureSurrogate(
  public var procedureCodeableConcept: CodeableConcept? = null,
  public var procedureReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Procedure.Procedure =
    ExplanationOfBenefit.Procedure.Procedure.from(
      this@ExplanationOfBenefitProcedureProcedureSurrogate.procedureCodeableConcept,
      this@ExplanationOfBenefitProcedureProcedureSurrogate.procedureReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Procedure.Procedure
    ): ExplanationOfBenefitProcedureProcedureSurrogate =
      with(model) {
        ExplanationOfBenefitProcedureProcedureSurrogate(
          procedureCodeableConcept = this@with.asCodeableConcept()?.value,
          procedureReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAccidentLocationSurrogate(
  public var locationAddress: Address? = null,
  public var locationReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Accident.Location =
    ExplanationOfBenefit.Accident.Location.from(
      this@ExplanationOfBenefitAccidentLocationSurrogate.locationAddress,
      this@ExplanationOfBenefitAccidentLocationSurrogate.locationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Accident.Location
    ): ExplanationOfBenefitAccidentLocationSurrogate =
      with(model) {
        ExplanationOfBenefitAccidentLocationSurrogate(
          locationAddress = this@with.asAddress()?.value,
          locationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item.Serviced =
    ExplanationOfBenefit.Item.Serviced.from(
      Date.of(
        FhirDate.fromString(this@ExplanationOfBenefitItemServicedSurrogate.servicedDate),
        this@ExplanationOfBenefitItemServicedSurrogate._servicedDate,
      ),
      this@ExplanationOfBenefitItemServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Item.Serviced
    ): ExplanationOfBenefitItemServicedSurrogate =
      with(model) {
        ExplanationOfBenefitItemServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitItemLocationSurrogate(
  public var locationCodeableConcept: CodeableConcept? = null,
  public var locationAddress: Address? = null,
  public var locationReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.Item.Location =
    ExplanationOfBenefit.Item.Location.from(
      this@ExplanationOfBenefitItemLocationSurrogate.locationCodeableConcept,
      this@ExplanationOfBenefitItemLocationSurrogate.locationAddress,
      this@ExplanationOfBenefitItemLocationSurrogate.locationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.Item.Location
    ): ExplanationOfBenefitItemLocationSurrogate =
      with(model) {
        ExplanationOfBenefitItemLocationSurrogate(
          locationCodeableConcept = this@with.asCodeableConcept()?.value,
          locationAddress = this@with.asAddress()?.value,
          locationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAddItemServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): ExplanationOfBenefit.AddItem.Serviced =
    ExplanationOfBenefit.AddItem.Serviced.from(
      Date.of(
        FhirDate.fromString(this@ExplanationOfBenefitAddItemServicedSurrogate.servicedDate),
        this@ExplanationOfBenefitAddItemServicedSurrogate._servicedDate,
      ),
      this@ExplanationOfBenefitAddItemServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.AddItem.Serviced
    ): ExplanationOfBenefitAddItemServicedSurrogate =
      with(model) {
        ExplanationOfBenefitAddItemServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitAddItemLocationSurrogate(
  public var locationCodeableConcept: CodeableConcept? = null,
  public var locationAddress: Address? = null,
  public var locationReference: Reference? = null,
) {
  public fun toModel(): ExplanationOfBenefit.AddItem.Location =
    ExplanationOfBenefit.AddItem.Location.from(
      this@ExplanationOfBenefitAddItemLocationSurrogate.locationCodeableConcept,
      this@ExplanationOfBenefitAddItemLocationSurrogate.locationAddress,
      this@ExplanationOfBenefitAddItemLocationSurrogate.locationReference,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.AddItem.Location
    ): ExplanationOfBenefitAddItemLocationSurrogate =
      with(model) {
        ExplanationOfBenefitAddItemLocationSurrogate(
          locationCodeableConcept = this@with.asCodeableConcept()?.value,
          locationAddress = this@with.asAddress()?.value,
          locationReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate(
  public var allowedUnsignedInt: Int? = null,
  public var _allowedUnsignedInt: Element? = null,
  public var allowedString: KotlinString? = null,
  public var _allowedString: Element? = null,
  public var allowedMoney: Money? = null,
) {
  public fun toModel(): ExplanationOfBenefit.BenefitBalance.Financial.Allowed =
    ExplanationOfBenefit.BenefitBalance.Financial.Allowed.from(
      UnsignedInt.of(
        this@ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate.allowedUnsignedInt,
        this@ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate._allowedUnsignedInt,
      ),
      R4String.of(
        this@ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate.allowedString,
        this@ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate._allowedString,
      ),
      this@ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate.allowedMoney,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.BenefitBalance.Financial.Allowed
    ): ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate =
      with(model) {
        ExplanationOfBenefitBenefitBalanceFinancialAllowedSurrogate(
          allowedUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _allowedUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          allowedString = this@with.asString()?.value?.value,
          _allowedString = this@with.asString()?.value?.toElement(),
          allowedMoney = this@with.asMoney()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate(
  public var usedUnsignedInt: Int? = null,
  public var _usedUnsignedInt: Element? = null,
  public var usedMoney: Money? = null,
) {
  public fun toModel(): ExplanationOfBenefit.BenefitBalance.Financial.Used =
    ExplanationOfBenefit.BenefitBalance.Financial.Used.from(
      UnsignedInt.of(
        this@ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate.usedUnsignedInt,
        this@ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate._usedUnsignedInt,
      ),
      this@ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate.usedMoney,
    )!!

  public companion object {
    public fun fromModel(
      model: ExplanationOfBenefit.BenefitBalance.Financial.Used
    ): ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate =
      with(model) {
        ExplanationOfBenefitBenefitBalanceFinancialUsedSurrogate(
          usedUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _usedUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          usedMoney = this@with.asMoney()?.value,
        )
      }
  }
}

@Serializable
internal data class ExplanationOfBenefitSurrogate(
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
  public var type: CodeableConcept,
  public var subType: CodeableConcept? = null,
  public var use: KotlinString? = null,
  public var _use: Element? = null,
  public var patient: Reference,
  public var billablePeriod: Period? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var enterer: Reference? = null,
  public var insurer: Reference,
  public var provider: Reference,
  public var priority: CodeableConcept? = null,
  public var fundsReserveRequested: CodeableConcept? = null,
  public var fundsReserve: CodeableConcept? = null,
  public var related: List<ExplanationOfBenefit.Related>? = null,
  public var prescription: Reference? = null,
  public var originalPrescription: Reference? = null,
  public var payee: ExplanationOfBenefit.Payee? = null,
  public var referral: Reference? = null,
  public var facility: Reference? = null,
  public var claim: Reference? = null,
  public var claimResponse: Reference? = null,
  public var outcome: KotlinString? = null,
  public var _outcome: Element? = null,
  public var disposition: KotlinString? = null,
  public var _disposition: Element? = null,
  public var preAuthRef: List<KotlinString?>? = null,
  public var _preAuthRef: List<Element?>? = null,
  public var preAuthRefPeriod: List<Period>? = null,
  public var careTeam: List<ExplanationOfBenefit.CareTeam>? = null,
  public var supportingInfo: List<ExplanationOfBenefit.SupportingInfo>? = null,
  public var diagnosis: List<ExplanationOfBenefit.Diagnosis>? = null,
  public var procedure: List<ExplanationOfBenefit.Procedure>? = null,
  public var precedence: Int? = null,
  public var _precedence: Element? = null,
  public var insurance: List<ExplanationOfBenefit.Insurance>? = null,
  public var accident: ExplanationOfBenefit.Accident? = null,
  public var item: List<ExplanationOfBenefit.Item>? = null,
  public var addItem: List<ExplanationOfBenefit.AddItem>? = null,
  public var adjudication: List<ExplanationOfBenefit.Item.Adjudication>? = null,
  public var total: List<ExplanationOfBenefit.Total>? = null,
  public var payment: ExplanationOfBenefit.Payment? = null,
  public var formCode: CodeableConcept? = null,
  public var form: Attachment? = null,
  public var processNote: List<ExplanationOfBenefit.ProcessNote>? = null,
  public var benefitPeriod: Period? = null,
  public var benefitBalance: List<ExplanationOfBenefit.BenefitBalance>? = null,
) {
  public fun toModel(): ExplanationOfBenefit =
    ExplanationOfBenefit(
      id = this@ExplanationOfBenefitSurrogate.id,
      meta = this@ExplanationOfBenefitSurrogate.meta,
      implicitRules =
        Uri.of(
          this@ExplanationOfBenefitSurrogate.implicitRules,
          this@ExplanationOfBenefitSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@ExplanationOfBenefitSurrogate.language,
          this@ExplanationOfBenefitSurrogate._language,
        ),
      text = this@ExplanationOfBenefitSurrogate.text,
      contained = this@ExplanationOfBenefitSurrogate.contained ?: listOf(),
      extension = this@ExplanationOfBenefitSurrogate.extension ?: listOf(),
      modifierExtension = this@ExplanationOfBenefitSurrogate.modifierExtension ?: listOf(),
      identifier = this@ExplanationOfBenefitSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          ExplanationOfBenefit.ExplanationOfBenefitStatus.fromCode(
            this@ExplanationOfBenefitSurrogate.status!!
          ),
          this@ExplanationOfBenefitSurrogate._status,
        ),
      type = this@ExplanationOfBenefitSurrogate.type,
      subType = this@ExplanationOfBenefitSurrogate.subType,
      use =
        Enumeration.of(
          ExplanationOfBenefit.Use.fromCode(this@ExplanationOfBenefitSurrogate.use!!),
          this@ExplanationOfBenefitSurrogate._use,
        ),
      patient = this@ExplanationOfBenefitSurrogate.patient,
      billablePeriod = this@ExplanationOfBenefitSurrogate.billablePeriod,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@ExplanationOfBenefitSurrogate.created),
          this@ExplanationOfBenefitSurrogate._created,
        )!!,
      enterer = this@ExplanationOfBenefitSurrogate.enterer,
      insurer = this@ExplanationOfBenefitSurrogate.insurer,
      provider = this@ExplanationOfBenefitSurrogate.provider,
      priority = this@ExplanationOfBenefitSurrogate.priority,
      fundsReserveRequested = this@ExplanationOfBenefitSurrogate.fundsReserveRequested,
      fundsReserve = this@ExplanationOfBenefitSurrogate.fundsReserve,
      related = this@ExplanationOfBenefitSurrogate.related ?: listOf(),
      prescription = this@ExplanationOfBenefitSurrogate.prescription,
      originalPrescription = this@ExplanationOfBenefitSurrogate.originalPrescription,
      payee = this@ExplanationOfBenefitSurrogate.payee,
      referral = this@ExplanationOfBenefitSurrogate.referral,
      facility = this@ExplanationOfBenefitSurrogate.facility,
      claim = this@ExplanationOfBenefitSurrogate.claim,
      claimResponse = this@ExplanationOfBenefitSurrogate.claimResponse,
      outcome =
        Enumeration.of(
          ExplanationOfBenefit.ClaimProcessingCodes.fromCode(
            this@ExplanationOfBenefitSurrogate.outcome!!
          ),
          this@ExplanationOfBenefitSurrogate._outcome,
        ),
      disposition =
        R4String.of(
          this@ExplanationOfBenefitSurrogate.disposition,
          this@ExplanationOfBenefitSurrogate._disposition,
        ),
      preAuthRef =
        if (
          this@ExplanationOfBenefitSurrogate.preAuthRef == null &&
            this@ExplanationOfBenefitSurrogate._preAuthRef == null
        ) {
          listOf()
        } else {
          (this@ExplanationOfBenefitSurrogate.preAuthRef
              ?: List(this@ExplanationOfBenefitSurrogate._preAuthRef!!.size) { null })
            .zip(
              this@ExplanationOfBenefitSurrogate._preAuthRef
                ?: List(this@ExplanationOfBenefitSurrogate.preAuthRef!!.size) { null }
            )
            .map { (value, element) -> R4String.of(value, element)!! }
            .toList()
        },
      preAuthRefPeriod = this@ExplanationOfBenefitSurrogate.preAuthRefPeriod ?: listOf(),
      careTeam = this@ExplanationOfBenefitSurrogate.careTeam ?: listOf(),
      supportingInfo = this@ExplanationOfBenefitSurrogate.supportingInfo ?: listOf(),
      diagnosis = this@ExplanationOfBenefitSurrogate.diagnosis ?: listOf(),
      procedure = this@ExplanationOfBenefitSurrogate.procedure ?: listOf(),
      precedence =
        PositiveInt.of(
          this@ExplanationOfBenefitSurrogate.precedence,
          this@ExplanationOfBenefitSurrogate._precedence,
        ),
      insurance = this@ExplanationOfBenefitSurrogate.insurance ?: listOf(),
      accident = this@ExplanationOfBenefitSurrogate.accident,
      item = this@ExplanationOfBenefitSurrogate.item ?: listOf(),
      addItem = this@ExplanationOfBenefitSurrogate.addItem ?: listOf(),
      adjudication = this@ExplanationOfBenefitSurrogate.adjudication ?: listOf(),
      total = this@ExplanationOfBenefitSurrogate.total ?: listOf(),
      payment = this@ExplanationOfBenefitSurrogate.payment,
      formCode = this@ExplanationOfBenefitSurrogate.formCode,
      form = this@ExplanationOfBenefitSurrogate.form,
      processNote = this@ExplanationOfBenefitSurrogate.processNote ?: listOf(),
      benefitPeriod = this@ExplanationOfBenefitSurrogate.benefitPeriod,
      benefitBalance = this@ExplanationOfBenefitSurrogate.benefitBalance ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: ExplanationOfBenefit): ExplanationOfBenefitSurrogate =
      with(model) {
        ExplanationOfBenefitSurrogate(
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
          type = this@with.type,
          subType = this@with.subType,
          use = this@with.use.value?.getCode(),
          _use = this@with.use.toElement(),
          patient = this@with.patient,
          billablePeriod = this@with.billablePeriod,
          created = this@with.created.value?.toString(),
          _created = this@with.created.toElement(),
          enterer = this@with.enterer,
          insurer = this@with.insurer,
          provider = this@with.provider,
          priority = this@with.priority,
          fundsReserveRequested = this@with.fundsReserveRequested,
          fundsReserve = this@with.fundsReserve,
          related = this@with.related.takeIf { it.isNotEmpty() },
          prescription = this@with.prescription,
          originalPrescription = this@with.originalPrescription,
          payee = this@with.payee,
          referral = this@with.referral,
          facility = this@with.facility,
          claim = this@with.claim,
          claimResponse = this@with.claimResponse,
          outcome = this@with.outcome.value?.getCode(),
          _outcome = this@with.outcome.toElement(),
          disposition = this@with.disposition?.value,
          _disposition = this@with.disposition?.toElement(),
          preAuthRef =
            this@with.preAuthRef.map { it.value }.toList().takeUnless { it.all { it == null } },
          _preAuthRef =
            this@with.preAuthRef
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          preAuthRefPeriod = this@with.preAuthRefPeriod.takeIf { it.isNotEmpty() },
          careTeam = this@with.careTeam.takeIf { it.isNotEmpty() },
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          diagnosis = this@with.diagnosis.takeIf { it.isNotEmpty() },
          procedure = this@with.procedure.takeIf { it.isNotEmpty() },
          precedence = this@with.precedence?.value,
          _precedence = this@with.precedence?.toElement(),
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          accident = this@with.accident,
          item = this@with.item.takeIf { it.isNotEmpty() },
          addItem = this@with.addItem.takeIf { it.isNotEmpty() },
          adjudication = this@with.adjudication.takeIf { it.isNotEmpty() },
          total = this@with.total.takeIf { it.isNotEmpty() },
          payment = this@with.payment,
          formCode = this@with.formCode,
          form = this@with.form,
          processNote = this@with.processNote.takeIf { it.isNotEmpty() },
          benefitPeriod = this@with.benefitPeriod,
          benefitBalance = this@with.benefitBalance.takeIf { it.isNotEmpty() },
        )
      }
  }
}
