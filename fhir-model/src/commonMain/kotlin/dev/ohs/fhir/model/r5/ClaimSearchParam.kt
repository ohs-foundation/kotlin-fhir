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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Claim] resource type. */
public sealed class ClaimSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Claim): List<T>

  public data object CareTeam : ClaimSearchParam<Any>() {
    public override val paramName: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.careTeam.provider"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Created : ClaimSearchParam<Any>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Claim.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object DetailUdi : ClaimSearchParam<Any>() {
    public override val paramName: String = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Encounter : ClaimSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Enterer : ClaimSearchParam<Any>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.enterer"

    public override val target: List<String> =
      listOf("RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Facility : ClaimSearchParam<Any>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.facility"

    public override val target: List<String> = listOf("Organization", "Location")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Identifier : ClaimSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Insurer : ClaimSearchParam<Any>() {
    public override val paramName: String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.insurer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object ItemUdi : ClaimSearchParam<Any>() {
    public override val paramName: String = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Patient : ClaimSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Payee : ClaimSearchParam<Any>() {
    public override val paramName: String = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.payee.party"

    public override val target: List<String> =
      listOf("Organization", "RelatedPerson", "PractitionerRole", "Practitioner", "Patient")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Priority : ClaimSearchParam<Any>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object ProcedureUdi : ClaimSearchParam<Any>() {
    public override val paramName: String = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.procedure.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Provider : ClaimSearchParam<Any>() {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.provider"

    public override val target: List<String> =
      listOf("Organization", "PractitionerRole", "Practitioner")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Status : ClaimSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object SubdetailUdi : ClaimSearchParam<Any>() {
    public override val paramName: String = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.subDetail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public data object Use : ClaimSearchParam<Any>() {
    public override val paramName: String = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the Claim resource type. */
    public val ALL: List<ClaimSearchParam<*>> =
      listOf(
        CareTeam,
        Created,
        DetailUdi,
        Encounter,
        Enterer,
        Facility,
        Identifier,
        Insurer,
        ItemUdi,
        Patient,
        Payee,
        Priority,
        ProcedureUdi,
        Provider,
        Status,
        SubdetailUdi,
        Use,
      )
  }
}
