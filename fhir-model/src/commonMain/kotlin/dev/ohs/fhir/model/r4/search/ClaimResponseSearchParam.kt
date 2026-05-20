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

import dev.ohs.fhir.model.r4.ClaimResponse
import dev.ohs.fhir.model.r4.Date
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [ClaimResponse] resource type. */
public object ClaimResponseSearchParam {
  /** All search parameters for the ClaimResponse resource type. */
  public val ALL: List<SearchParam<ClaimResponse, *>> =
    listOf(
      Created,
      Disposition,
      Identifier,
      Insurer,
      Outcome,
      Patient,
      PaymentDate,
      Request,
      Requestor,
      Status,
      Use,
    )

  public data object Created : SearchParam<ClaimResponse, DateTime> {
    public override val paramName: KotlinString = "created"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ClaimResponse.created"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<DateTime> = listOf(resource.created)
  }

  public data object Disposition : SearchParam<ClaimResponse, R4String> {
    public override val paramName: KotlinString = "disposition"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "ClaimResponse.disposition"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<R4String> =
      listOfNotNull(resource.disposition)
  }

  public data object Identifier : SearchParam<ClaimResponse, dev.ohs.fhir.model.r4.Identifier> {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ClaimResponse.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object Insurer : SearchParam<ClaimResponse, Reference> {
    public override val paramName: KotlinString = "insurer"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ClaimResponse.insurer"

    public override val target: List<KotlinString> = listOf("Organization")

    public override fun extract(resource: ClaimResponse): List<Reference> = listOf(resource.insurer)
  }

  public data object Outcome : SearchParam<ClaimResponse, Any> {
    public override val paramName: KotlinString = "outcome"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ClaimResponse.outcome"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.outcome)
  }

  public data object Patient : SearchParam<ClaimResponse, Reference> {
    public override val paramName: KotlinString = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ClaimResponse.patient"

    public override val target: List<KotlinString> = listOf("Patient")

    public override fun extract(resource: ClaimResponse): List<Reference> = listOf(resource.patient)
  }

  public data object PaymentDate : SearchParam<ClaimResponse, Date> {
    public override val paramName: KotlinString = "payment-date"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: KotlinString = "ClaimResponse.payment.date"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Date> =
      listOfNotNull(resource.payment?.date)
  }

  public data object Request : SearchParam<ClaimResponse, Reference> {
    public override val paramName: KotlinString = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ClaimResponse.request"

    public override val target: List<KotlinString> = listOf("Claim")

    public override fun extract(resource: ClaimResponse): List<Reference> =
      listOfNotNull(resource.request)
  }

  public data object Requestor : SearchParam<ClaimResponse, Reference> {
    public override val paramName: KotlinString = "requestor"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "ClaimResponse.requestor"

    public override val target: List<KotlinString> =
      listOf("Practitioner", "Organization", "PractitionerRole")

    public override fun extract(resource: ClaimResponse): List<Reference> =
      listOfNotNull(resource.requestor)
  }

  public data object Status : SearchParam<ClaimResponse, Any> {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ClaimResponse.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.status)
  }

  public data object Use : SearchParam<ClaimResponse, Any> {
    public override val paramName: KotlinString = "use"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "ClaimResponse.use"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: ClaimResponse): List<Any> = listOf(resource.use)
  }
}
