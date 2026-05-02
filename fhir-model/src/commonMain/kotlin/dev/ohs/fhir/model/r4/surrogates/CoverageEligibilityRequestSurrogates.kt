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

import com.google.fhir.model.r4.Boolean as R4Boolean
import com.google.fhir.model.r4.Code
import com.google.fhir.model.r4.CodeableConcept
import com.google.fhir.model.r4.CoverageEligibilityRequest
import com.google.fhir.model.r4.Date
import com.google.fhir.model.r4.DateTime
import com.google.fhir.model.r4.Element
import com.google.fhir.model.r4.Enumeration
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
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CoverageEligibilityRequestSupportingInfoSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var sequence: Int? = null,
  public var _sequence: Element? = null,
  public var information: Reference,
  public var appliesToAll: KotlinBoolean? = null,
  public var _appliesToAll: Element? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.SupportingInfo =
    CoverageEligibilityRequest.SupportingInfo(
      id = this@CoverageEligibilityRequestSupportingInfoSurrogate.id,
      extension = this@CoverageEligibilityRequestSupportingInfoSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityRequestSupportingInfoSurrogate.modifierExtension ?: listOf(),
      sequence =
        PositiveInt.of(
          this@CoverageEligibilityRequestSupportingInfoSurrogate.sequence,
          this@CoverageEligibilityRequestSupportingInfoSurrogate._sequence,
        )!!,
      information = this@CoverageEligibilityRequestSupportingInfoSurrogate.information,
      appliesToAll =
        R4Boolean.of(
          this@CoverageEligibilityRequestSupportingInfoSurrogate.appliesToAll,
          this@CoverageEligibilityRequestSupportingInfoSurrogate._appliesToAll,
        ),
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.SupportingInfo
    ): CoverageEligibilityRequestSupportingInfoSurrogate =
      with(model) {
        CoverageEligibilityRequestSupportingInfoSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          sequence = this@with.sequence.value,
          _sequence = this@with.sequence.toElement(),
          information = this@with.information,
          appliesToAll = this@with.appliesToAll?.value,
          _appliesToAll = this@with.appliesToAll?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestInsuranceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var focal: KotlinBoolean? = null,
  public var _focal: Element? = null,
  public var coverage: Reference,
  public var businessArrangement: KotlinString? = null,
  public var _businessArrangement: Element? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.Insurance =
    CoverageEligibilityRequest.Insurance(
      id = this@CoverageEligibilityRequestInsuranceSurrogate.id,
      extension = this@CoverageEligibilityRequestInsuranceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityRequestInsuranceSurrogate.modifierExtension ?: listOf(),
      focal =
        R4Boolean.of(
          this@CoverageEligibilityRequestInsuranceSurrogate.focal,
          this@CoverageEligibilityRequestInsuranceSurrogate._focal,
        ),
      coverage = this@CoverageEligibilityRequestInsuranceSurrogate.coverage,
      businessArrangement =
        R4String.of(
          this@CoverageEligibilityRequestInsuranceSurrogate.businessArrangement,
          this@CoverageEligibilityRequestInsuranceSurrogate._businessArrangement,
        ),
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.Insurance
    ): CoverageEligibilityRequestInsuranceSurrogate =
      with(model) {
        CoverageEligibilityRequestInsuranceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          focal = this@with.focal?.value,
          _focal = this@with.focal?.toElement(),
          coverage = this@with.coverage,
          businessArrangement = this@with.businessArrangement?.value,
          _businessArrangement = this@with.businessArrangement?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var supportingInfoSequence: List<Int?>? = null,
  public var _supportingInfoSequence: List<Element?>? = null,
  public var category: CodeableConcept? = null,
  public var productOrService: CodeableConcept? = null,
  public var modifier: List<CodeableConcept>? = null,
  public var provider: Reference? = null,
  public var quantity: Quantity? = null,
  public var unitPrice: Money? = null,
  public var facility: Reference? = null,
  public var diagnosis: List<CoverageEligibilityRequest.Item.Diagnosis>? = null,
  public var detail: List<Reference>? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.Item =
    CoverageEligibilityRequest.Item(
      id = this@CoverageEligibilityRequestItemSurrogate.id,
      extension = this@CoverageEligibilityRequestItemSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityRequestItemSurrogate.modifierExtension ?: listOf(),
      supportingInfoSequence =
        if (
          this@CoverageEligibilityRequestItemSurrogate.supportingInfoSequence == null &&
            this@CoverageEligibilityRequestItemSurrogate._supportingInfoSequence == null
        ) {
          listOf()
        } else {
          (this@CoverageEligibilityRequestItemSurrogate.supportingInfoSequence
              ?: List(this@CoverageEligibilityRequestItemSurrogate._supportingInfoSequence!!.size) {
                null
              })
            .zip(
              this@CoverageEligibilityRequestItemSurrogate._supportingInfoSequence
                ?: List(
                  this@CoverageEligibilityRequestItemSurrogate.supportingInfoSequence!!.size
                ) {
                  null
                }
            )
            .map { (value, element) -> PositiveInt.of(value, element)!! }
            .toList()
        },
      category = this@CoverageEligibilityRequestItemSurrogate.category,
      productOrService = this@CoverageEligibilityRequestItemSurrogate.productOrService,
      modifier = this@CoverageEligibilityRequestItemSurrogate.modifier ?: listOf(),
      provider = this@CoverageEligibilityRequestItemSurrogate.provider,
      quantity = this@CoverageEligibilityRequestItemSurrogate.quantity,
      unitPrice = this@CoverageEligibilityRequestItemSurrogate.unitPrice,
      facility = this@CoverageEligibilityRequestItemSurrogate.facility,
      diagnosis = this@CoverageEligibilityRequestItemSurrogate.diagnosis ?: listOf(),
      detail = this@CoverageEligibilityRequestItemSurrogate.detail ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.Item
    ): CoverageEligibilityRequestItemSurrogate =
      with(model) {
        CoverageEligibilityRequestItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          supportingInfoSequence =
            this@with.supportingInfoSequence
              .map { it.value }
              .toList()
              .takeUnless { it.all { it == null } },
          _supportingInfoSequence =
            this@with.supportingInfoSequence
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          category = this@with.category,
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          provider = this@with.provider,
          quantity = this@with.quantity,
          unitPrice = this@with.unitPrice,
          facility = this@with.facility,
          diagnosis = this@with.diagnosis.takeIf { it.isNotEmpty() },
          detail = this@with.detail.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestItemDiagnosisSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var diagnosis: CoverageEligibilityRequest.Item.Diagnosis.Diagnosis? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.Item.Diagnosis =
    CoverageEligibilityRequest.Item.Diagnosis(
      id = this@CoverageEligibilityRequestItemDiagnosisSurrogate.id,
      extension = this@CoverageEligibilityRequestItemDiagnosisSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityRequestItemDiagnosisSurrogate.modifierExtension ?: listOf(),
      diagnosis = this@CoverageEligibilityRequestItemDiagnosisSurrogate.diagnosis,
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.Item.Diagnosis
    ): CoverageEligibilityRequestItemDiagnosisSurrogate =
      with(model) {
        CoverageEligibilityRequestItemDiagnosisSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          diagnosis = this@with.diagnosis,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.Serviced =
    CoverageEligibilityRequest.Serviced.from(
      Date.of(
        FhirDate.fromString(this@CoverageEligibilityRequestServicedSurrogate.servicedDate),
        this@CoverageEligibilityRequestServicedSurrogate._servicedDate,
      ),
      this@CoverageEligibilityRequestServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.Serviced
    ): CoverageEligibilityRequestServicedSurrogate =
      with(model) {
        CoverageEligibilityRequestServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate(
  public var diagnosisCodeableConcept: CodeableConcept? = null,
  public var diagnosisReference: Reference? = null,
) {
  public fun toModel(): CoverageEligibilityRequest.Item.Diagnosis.Diagnosis =
    CoverageEligibilityRequest.Item.Diagnosis.Diagnosis.from(
      this@CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate.diagnosisCodeableConcept,
      this@CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate.diagnosisReference,
    )!!

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityRequest.Item.Diagnosis.Diagnosis
    ): CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate =
      with(model) {
        CoverageEligibilityRequestItemDiagnosisDiagnosisSurrogate(
          diagnosisCodeableConcept = this@with.asCodeableConcept()?.value,
          diagnosisReference = this@with.asReference()?.value,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityRequestSurrogate(
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
  public var priority: CodeableConcept? = null,
  public var purpose: List<KotlinString?>? = null,
  public var _purpose: List<Element?>? = null,
  public var patient: Reference,
  public var serviced: CoverageEligibilityRequest.Serviced? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var enterer: Reference? = null,
  public var provider: Reference? = null,
  public var insurer: Reference,
  public var facility: Reference? = null,
  public var supportingInfo: List<CoverageEligibilityRequest.SupportingInfo>? = null,
  public var insurance: List<CoverageEligibilityRequest.Insurance>? = null,
  public var item: List<CoverageEligibilityRequest.Item>? = null,
) {
  public fun toModel(): CoverageEligibilityRequest =
    CoverageEligibilityRequest(
      id = this@CoverageEligibilityRequestSurrogate.id,
      meta = this@CoverageEligibilityRequestSurrogate.meta,
      implicitRules =
        Uri.of(
          this@CoverageEligibilityRequestSurrogate.implicitRules,
          this@CoverageEligibilityRequestSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@CoverageEligibilityRequestSurrogate.language,
          this@CoverageEligibilityRequestSurrogate._language,
        ),
      text = this@CoverageEligibilityRequestSurrogate.text,
      contained = this@CoverageEligibilityRequestSurrogate.contained ?: listOf(),
      extension = this@CoverageEligibilityRequestSurrogate.extension ?: listOf(),
      modifierExtension = this@CoverageEligibilityRequestSurrogate.modifierExtension ?: listOf(),
      identifier = this@CoverageEligibilityRequestSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          CoverageEligibilityRequest.FinancialResourceStatusCodes.fromCode(
            this@CoverageEligibilityRequestSurrogate.status!!
          ),
          this@CoverageEligibilityRequestSurrogate._status,
        ),
      priority = this@CoverageEligibilityRequestSurrogate.priority,
      purpose =
        if (
          this@CoverageEligibilityRequestSurrogate.purpose == null &&
            this@CoverageEligibilityRequestSurrogate._purpose == null
        ) {
          listOf()
        } else {
          (this@CoverageEligibilityRequestSurrogate.purpose
              ?: List(this@CoverageEligibilityRequestSurrogate._purpose!!.size) { null })
            .zip(
              this@CoverageEligibilityRequestSurrogate._purpose
                ?: List(this@CoverageEligibilityRequestSurrogate.purpose!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { CoverageEligibilityRequest.EligibilityRequestPurpose.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      patient = this@CoverageEligibilityRequestSurrogate.patient,
      serviced = this@CoverageEligibilityRequestSurrogate.serviced,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@CoverageEligibilityRequestSurrogate.created),
          this@CoverageEligibilityRequestSurrogate._created,
        )!!,
      enterer = this@CoverageEligibilityRequestSurrogate.enterer,
      provider = this@CoverageEligibilityRequestSurrogate.provider,
      insurer = this@CoverageEligibilityRequestSurrogate.insurer,
      facility = this@CoverageEligibilityRequestSurrogate.facility,
      supportingInfo = this@CoverageEligibilityRequestSurrogate.supportingInfo ?: listOf(),
      insurance = this@CoverageEligibilityRequestSurrogate.insurance ?: listOf(),
      item = this@CoverageEligibilityRequestSurrogate.item ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CoverageEligibilityRequest): CoverageEligibilityRequestSurrogate =
      with(model) {
        CoverageEligibilityRequestSurrogate(
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
          priority = this@with.priority,
          purpose =
            this@with.purpose
              .map { it.value?.getCode() }
              .toList()
              .takeUnless { it.all { it == null } },
          _purpose =
            this@with.purpose
              .map { it.toElement() }
              .takeUnless { it.all { it == null } }
              ?.map { it ?: Element() }
              ?.toList(),
          patient = this@with.patient,
          serviced = this@with.serviced,
          created = this@with.created.value?.toString(),
          _created = this@with.created.toElement(),
          enterer = this@with.enterer,
          provider = this@with.provider,
          insurer = this@with.insurer,
          facility = this@with.facility,
          supportingInfo = this@with.supportingInfo.takeIf { it.isNotEmpty() },
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          item = this@with.item.takeIf { it.isNotEmpty() },
        )
      }
  }
}
