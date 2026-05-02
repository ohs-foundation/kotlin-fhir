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
import com.google.fhir.model.r4.CoverageEligibilityResponse
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
import com.google.fhir.model.r4.Reference
import com.google.fhir.model.r4.Resource
import com.google.fhir.model.r4.String as R4String
import com.google.fhir.model.r4.UnsignedInt
import com.google.fhir.model.r4.Uri
import com.google.fhir.model.r4.serializers.DoubleSerializer
import com.google.fhir.model.r4.serializers.LocalTimeSerializer
import com.google.fhir.model.r4.terminologies.ClaimProcessingCodes
import kotlin.Boolean as KotlinBoolean
import kotlin.Int
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlinx.serialization.Serializable
import kotlinx.serialization.UseSerializers

@Serializable
internal data class CoverageEligibilityResponseInsuranceSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var coverage: Reference,
  public var inforce: KotlinBoolean? = null,
  public var _inforce: Element? = null,
  public var benefitPeriod: Period? = null,
  public var item: List<CoverageEligibilityResponse.Insurance.Item>? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Insurance =
    CoverageEligibilityResponse.Insurance(
      id = this@CoverageEligibilityResponseInsuranceSurrogate.id,
      extension = this@CoverageEligibilityResponseInsuranceSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityResponseInsuranceSurrogate.modifierExtension ?: listOf(),
      coverage = this@CoverageEligibilityResponseInsuranceSurrogate.coverage,
      inforce =
        R4Boolean.of(
          this@CoverageEligibilityResponseInsuranceSurrogate.inforce,
          this@CoverageEligibilityResponseInsuranceSurrogate._inforce,
        ),
      benefitPeriod = this@CoverageEligibilityResponseInsuranceSurrogate.benefitPeriod,
      item = this@CoverageEligibilityResponseInsuranceSurrogate.item ?: listOf(),
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Insurance
    ): CoverageEligibilityResponseInsuranceSurrogate =
      with(model) {
        CoverageEligibilityResponseInsuranceSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          coverage = this@with.coverage,
          inforce = this@with.inforce?.value,
          _inforce = this@with.inforce?.toElement(),
          benefitPeriod = this@with.benefitPeriod,
          item = this@with.item.takeIf { it.isNotEmpty() },
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityResponseInsuranceItemSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var category: CodeableConcept? = null,
  public var productOrService: CodeableConcept? = null,
  public var modifier: List<CodeableConcept>? = null,
  public var provider: Reference? = null,
  public var excluded: KotlinBoolean? = null,
  public var _excluded: Element? = null,
  public var name: KotlinString? = null,
  public var _name: Element? = null,
  public var description: KotlinString? = null,
  public var _description: Element? = null,
  public var network: CodeableConcept? = null,
  public var unit: CodeableConcept? = null,
  public var term: CodeableConcept? = null,
  public var benefit: List<CoverageEligibilityResponse.Insurance.Item.Benefit>? = null,
  public var authorizationRequired: KotlinBoolean? = null,
  public var _authorizationRequired: Element? = null,
  public var authorizationSupporting: List<CodeableConcept>? = null,
  public var authorizationUrl: KotlinString? = null,
  public var _authorizationUrl: Element? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Insurance.Item =
    CoverageEligibilityResponse.Insurance.Item(
      id = this@CoverageEligibilityResponseInsuranceItemSurrogate.id,
      extension = this@CoverageEligibilityResponseInsuranceItemSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityResponseInsuranceItemSurrogate.modifierExtension ?: listOf(),
      category = this@CoverageEligibilityResponseInsuranceItemSurrogate.category,
      productOrService = this@CoverageEligibilityResponseInsuranceItemSurrogate.productOrService,
      modifier = this@CoverageEligibilityResponseInsuranceItemSurrogate.modifier ?: listOf(),
      provider = this@CoverageEligibilityResponseInsuranceItemSurrogate.provider,
      excluded =
        R4Boolean.of(
          this@CoverageEligibilityResponseInsuranceItemSurrogate.excluded,
          this@CoverageEligibilityResponseInsuranceItemSurrogate._excluded,
        ),
      name =
        R4String.of(
          this@CoverageEligibilityResponseInsuranceItemSurrogate.name,
          this@CoverageEligibilityResponseInsuranceItemSurrogate._name,
        ),
      description =
        R4String.of(
          this@CoverageEligibilityResponseInsuranceItemSurrogate.description,
          this@CoverageEligibilityResponseInsuranceItemSurrogate._description,
        ),
      network = this@CoverageEligibilityResponseInsuranceItemSurrogate.network,
      unit = this@CoverageEligibilityResponseInsuranceItemSurrogate.unit,
      term = this@CoverageEligibilityResponseInsuranceItemSurrogate.term,
      benefit = this@CoverageEligibilityResponseInsuranceItemSurrogate.benefit ?: listOf(),
      authorizationRequired =
        R4Boolean.of(
          this@CoverageEligibilityResponseInsuranceItemSurrogate.authorizationRequired,
          this@CoverageEligibilityResponseInsuranceItemSurrogate._authorizationRequired,
        ),
      authorizationSupporting =
        this@CoverageEligibilityResponseInsuranceItemSurrogate.authorizationSupporting ?: listOf(),
      authorizationUrl =
        Uri.of(
          this@CoverageEligibilityResponseInsuranceItemSurrogate.authorizationUrl,
          this@CoverageEligibilityResponseInsuranceItemSurrogate._authorizationUrl,
        ),
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Insurance.Item
    ): CoverageEligibilityResponseInsuranceItemSurrogate =
      with(model) {
        CoverageEligibilityResponseInsuranceItemSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          category = this@with.category,
          productOrService = this@with.productOrService,
          modifier = this@with.modifier.takeIf { it.isNotEmpty() },
          provider = this@with.provider,
          excluded = this@with.excluded?.value,
          _excluded = this@with.excluded?.toElement(),
          name = this@with.name?.value,
          _name = this@with.name?.toElement(),
          description = this@with.description?.value,
          _description = this@with.description?.toElement(),
          network = this@with.network,
          unit = this@with.unit,
          term = this@with.term,
          benefit = this@with.benefit.takeIf { it.isNotEmpty() },
          authorizationRequired = this@with.authorizationRequired?.value,
          _authorizationRequired = this@with.authorizationRequired?.toElement(),
          authorizationSupporting = this@with.authorizationSupporting.takeIf { it.isNotEmpty() },
          authorizationUrl = this@with.authorizationUrl?.value,
          _authorizationUrl = this@with.authorizationUrl?.toElement(),
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityResponseInsuranceItemBenefitSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var type: CodeableConcept,
  public var allowed: CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed? = null,
  public var used: CoverageEligibilityResponse.Insurance.Item.Benefit.Used? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Insurance.Item.Benefit =
    CoverageEligibilityResponse.Insurance.Item.Benefit(
      id = this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.id,
      extension =
        this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.modifierExtension ?: listOf(),
      type = this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.type,
      allowed = this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.allowed,
      used = this@CoverageEligibilityResponseInsuranceItemBenefitSurrogate.used,
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Insurance.Item.Benefit
    ): CoverageEligibilityResponseInsuranceItemBenefitSurrogate =
      with(model) {
        CoverageEligibilityResponseInsuranceItemBenefitSurrogate(
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
internal data class CoverageEligibilityResponseErrorSurrogate(
  public var id: KotlinString? = null,
  public var extension: List<Extension>? = null,
  public var modifierExtension: List<Extension>? = null,
  public var code: CodeableConcept,
) {
  public fun toModel(): CoverageEligibilityResponse.Error =
    CoverageEligibilityResponse.Error(
      id = this@CoverageEligibilityResponseErrorSurrogate.id,
      extension = this@CoverageEligibilityResponseErrorSurrogate.extension ?: listOf(),
      modifierExtension =
        this@CoverageEligibilityResponseErrorSurrogate.modifierExtension ?: listOf(),
      code = this@CoverageEligibilityResponseErrorSurrogate.code,
    )

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Error
    ): CoverageEligibilityResponseErrorSurrogate =
      with(model) {
        CoverageEligibilityResponseErrorSurrogate(
          id = this@with.id,
          extension = this@with.extension.takeIf { it.isNotEmpty() },
          modifierExtension = this@with.modifierExtension.takeIf { it.isNotEmpty() },
          code = this@with.code,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityResponseServicedSurrogate(
  public var servicedDate: KotlinString? = null,
  public var _servicedDate: Element? = null,
  public var servicedPeriod: Period? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Serviced =
    CoverageEligibilityResponse.Serviced.from(
      Date.of(
        FhirDate.fromString(this@CoverageEligibilityResponseServicedSurrogate.servicedDate),
        this@CoverageEligibilityResponseServicedSurrogate._servicedDate,
      ),
      this@CoverageEligibilityResponseServicedSurrogate.servicedPeriod,
    )!!

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Serviced
    ): CoverageEligibilityResponseServicedSurrogate =
      with(model) {
        CoverageEligibilityResponseServicedSurrogate(
          servicedDate = this@with.asDate()?.value?.value?.toString(),
          _servicedDate = this@with.asDate()?.value?.toElement(),
          servicedPeriod = this@with.asPeriod()?.value,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate(
  public var allowedUnsignedInt: Int? = null,
  public var _allowedUnsignedInt: Element? = null,
  public var allowedString: KotlinString? = null,
  public var _allowedString: Element? = null,
  public var allowedMoney: Money? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed =
    CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed.from(
      UnsignedInt.of(
        this@CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate.allowedUnsignedInt,
        this@CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate._allowedUnsignedInt,
      ),
      R4String.of(
        this@CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate.allowedString,
        this@CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate._allowedString,
      ),
      this@CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate.allowedMoney,
    )!!

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Insurance.Item.Benefit.Allowed
    ): CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate =
      with(model) {
        CoverageEligibilityResponseInsuranceItemBenefitAllowedSurrogate(
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
internal data class CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate(
  public var usedUnsignedInt: Int? = null,
  public var _usedUnsignedInt: Element? = null,
  public var usedString: KotlinString? = null,
  public var _usedString: Element? = null,
  public var usedMoney: Money? = null,
) {
  public fun toModel(): CoverageEligibilityResponse.Insurance.Item.Benefit.Used =
    CoverageEligibilityResponse.Insurance.Item.Benefit.Used.from(
      UnsignedInt.of(
        this@CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate.usedUnsignedInt,
        this@CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate._usedUnsignedInt,
      ),
      R4String.of(
        this@CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate.usedString,
        this@CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate._usedString,
      ),
      this@CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate.usedMoney,
    )!!

  public companion object {
    public fun fromModel(
      model: CoverageEligibilityResponse.Insurance.Item.Benefit.Used
    ): CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate =
      with(model) {
        CoverageEligibilityResponseInsuranceItemBenefitUsedSurrogate(
          usedUnsignedInt = this@with.asUnsignedInt()?.value?.value,
          _usedUnsignedInt = this@with.asUnsignedInt()?.value?.toElement(),
          usedString = this@with.asString()?.value?.value,
          _usedString = this@with.asString()?.value?.toElement(),
          usedMoney = this@with.asMoney()?.value,
        )
      }
  }
}

@Serializable
internal data class CoverageEligibilityResponseSurrogate(
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
  public var purpose: List<KotlinString?>? = null,
  public var _purpose: List<Element?>? = null,
  public var patient: Reference,
  public var serviced: CoverageEligibilityResponse.Serviced? = null,
  public var created: KotlinString? = null,
  public var _created: Element? = null,
  public var requestor: Reference? = null,
  public var request: Reference,
  public var outcome: KotlinString? = null,
  public var _outcome: Element? = null,
  public var disposition: KotlinString? = null,
  public var _disposition: Element? = null,
  public var insurer: Reference,
  public var insurance: List<CoverageEligibilityResponse.Insurance>? = null,
  public var preAuthRef: KotlinString? = null,
  public var _preAuthRef: Element? = null,
  public var form: CodeableConcept? = null,
  public var error: List<CoverageEligibilityResponse.Error>? = null,
) {
  public fun toModel(): CoverageEligibilityResponse =
    CoverageEligibilityResponse(
      id = this@CoverageEligibilityResponseSurrogate.id,
      meta = this@CoverageEligibilityResponseSurrogate.meta,
      implicitRules =
        Uri.of(
          this@CoverageEligibilityResponseSurrogate.implicitRules,
          this@CoverageEligibilityResponseSurrogate._implicitRules,
        ),
      language =
        Code.of(
          this@CoverageEligibilityResponseSurrogate.language,
          this@CoverageEligibilityResponseSurrogate._language,
        ),
      text = this@CoverageEligibilityResponseSurrogate.text,
      contained = this@CoverageEligibilityResponseSurrogate.contained ?: listOf(),
      extension = this@CoverageEligibilityResponseSurrogate.extension ?: listOf(),
      modifierExtension = this@CoverageEligibilityResponseSurrogate.modifierExtension ?: listOf(),
      identifier = this@CoverageEligibilityResponseSurrogate.identifier ?: listOf(),
      status =
        Enumeration.of(
          CoverageEligibilityResponse.FinancialResourceStatusCodes.fromCode(
            this@CoverageEligibilityResponseSurrogate.status!!
          ),
          this@CoverageEligibilityResponseSurrogate._status,
        ),
      purpose =
        if (
          this@CoverageEligibilityResponseSurrogate.purpose == null &&
            this@CoverageEligibilityResponseSurrogate._purpose == null
        ) {
          listOf()
        } else {
          (this@CoverageEligibilityResponseSurrogate.purpose
              ?: List(this@CoverageEligibilityResponseSurrogate._purpose!!.size) { null })
            .zip(
              this@CoverageEligibilityResponseSurrogate._purpose
                ?: List(this@CoverageEligibilityResponseSurrogate.purpose!!.size) { null }
            )
            .map { (value, element) ->
              Enumeration.of(
                value.let { CoverageEligibilityResponse.EligibilityResponsePurpose.fromCode(it!!) },
                element,
              )
            }
            .toList()
        },
      patient = this@CoverageEligibilityResponseSurrogate.patient,
      serviced = this@CoverageEligibilityResponseSurrogate.serviced,
      created =
        DateTime.of(
          FhirDateTime.fromString(this@CoverageEligibilityResponseSurrogate.created),
          this@CoverageEligibilityResponseSurrogate._created,
        )!!,
      requestor = this@CoverageEligibilityResponseSurrogate.requestor,
      request = this@CoverageEligibilityResponseSurrogate.request,
      outcome =
        Enumeration.of(
          ClaimProcessingCodes.fromCode(this@CoverageEligibilityResponseSurrogate.outcome!!),
          this@CoverageEligibilityResponseSurrogate._outcome,
        ),
      disposition =
        R4String.of(
          this@CoverageEligibilityResponseSurrogate.disposition,
          this@CoverageEligibilityResponseSurrogate._disposition,
        ),
      insurer = this@CoverageEligibilityResponseSurrogate.insurer,
      insurance = this@CoverageEligibilityResponseSurrogate.insurance ?: listOf(),
      preAuthRef =
        R4String.of(
          this@CoverageEligibilityResponseSurrogate.preAuthRef,
          this@CoverageEligibilityResponseSurrogate._preAuthRef,
        ),
      form = this@CoverageEligibilityResponseSurrogate.form,
      error = this@CoverageEligibilityResponseSurrogate.error ?: listOf(),
    )

  public companion object {
    public fun fromModel(model: CoverageEligibilityResponse): CoverageEligibilityResponseSurrogate =
      with(model) {
        CoverageEligibilityResponseSurrogate(
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
          requestor = this@with.requestor,
          request = this@with.request,
          outcome = this@with.outcome.value?.getCode(),
          _outcome = this@with.outcome.toElement(),
          disposition = this@with.disposition?.value,
          _disposition = this@with.disposition?.toElement(),
          insurer = this@with.insurer,
          insurance = this@with.insurance.takeIf { it.isNotEmpty() },
          preAuthRef = this@with.preAuthRef?.value,
          _preAuthRef = this@with.preAuthRef?.toElement(),
          form = this@with.form,
          error = this@with.error.takeIf { it.isNotEmpty() },
        )
      }
  }
}
