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

package dev.ohs.fhir.model.r4b.search

import dev.ohs.fhir.model.r4b.EnrollmentRequest
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [EnrollmentRequest] resource type. */
public object EnrollmentRequestSearchParam {
  /** All search parameters for the EnrollmentRequest resource type. */
  public val ALL: List<SearchParam<EnrollmentRequest, *>> =
    listOf(Identifier, Patient, Status, Subject)

  public data object Identifier :
    SearchParam<EnrollmentRequest, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EnrollmentRequest.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: EnrollmentRequest
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<EnrollmentRequest, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EnrollmentRequest.candidate"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: EnrollmentRequest): List<Reference> =
      listOfNotNull(resource.candidate)
  }

  public data object Status : SearchParam<EnrollmentRequest, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "EnrollmentRequest.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: EnrollmentRequest): List<Any> =
      listOfNotNull(resource.status)
  }

  public data object Subject : SearchParam<EnrollmentRequest, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "EnrollmentRequest.candidate"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4b.Patient::class)

    public override fun extract(resource: EnrollmentRequest): List<Reference> =
      listOfNotNull(resource.candidate)
  }
}
