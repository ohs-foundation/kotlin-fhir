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

package dev.ohs.fhir.model.r4.search

import dev.ohs.fhir.model.r4.Claim
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Claim] resource type. */
public sealed class ClaimSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Claim): List<T>

  public data object CareTeam : ClaimSearchParam<Reference>() {
    public override val paramName: String = "care-team"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.careTeam.provider"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: Claim): List<Reference> =
      resource.careTeam.map { it.provider }
  }

  public data object Created : ClaimSearchParam<DateTime>() {
    public override val paramName: String = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "Claim.created"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<DateTime> = listOf(resource.created)
  }

  public data object DetailUdi : ClaimSearchParam<Reference>() {
    public override val paramName: String = "detail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.udi }
  }

  public data object Encounter : ClaimSearchParam<Reference>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.encounter }
  }

  public data object Enterer : ClaimSearchParam<Reference>() {
    public override val paramName: String = "enterer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.enterer"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.enterer)
  }

  public data object Facility : ClaimSearchParam<Reference>() {
    public override val paramName: String = "facility"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.facility"

    public override val target: List<String> = listOf("Location")

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.facility)
  }

  public data object Identifier : ClaimSearchParam<dev.ohs.fhir.model.r4.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Insurer : ClaimSearchParam<Reference>() {
    public override val paramName: String = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.insurer"

    public override val target: List<String> = listOf("Organization")

    public override fun extract(resource: Claim): List<Reference> = listOfNotNull(resource.insurer)
  }

  public data object ItemUdi : ClaimSearchParam<Reference>() {
    public override val paramName: String = "item-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Reference> = resource.item.flatMap { it.udi }
  }

  public data object Patient : ClaimSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: Claim): List<Reference> = listOf(resource.patient)
  }

  public data object Payee : ClaimSearchParam<Reference>() {
    public override val paramName: String = "payee"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.payee.party"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "Patient", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Claim): List<Reference> =
      listOfNotNull(resource.payee?.party)
  }

  public data object Priority : ClaimSearchParam<CodeableConcept>() {
    public override val paramName: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.priority"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<CodeableConcept> = listOf(resource.priority)
  }

  public data object ProcedureUdi : ClaimSearchParam<Reference>() {
    public override val paramName: String = "procedure-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.procedure.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Reference> =
      resource.procedure.flatMap { it.udi }
  }

  public data object Provider : ClaimSearchParam<Reference>() {
    public override val paramName: String = "provider"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.provider"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: Claim): List<Reference> = listOf(resource.provider)
  }

  public data object Status : ClaimSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = listOf(resource.status)
  }

  public data object SubdetailUdi : ClaimSearchParam<Reference>() {
    public override val paramName: String = "subdetail-udi"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Claim.item.detail.subDetail.udi"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: Claim): List<Reference> =
      resource.item.flatMap { it.detail }.flatMap { it.subDetail }.flatMap { it.udi }
  }

  public data object Use : ClaimSearchParam<Any>() {
    public override val paramName: String = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Claim.use"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Claim): List<Any> = listOf(resource.use)
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
