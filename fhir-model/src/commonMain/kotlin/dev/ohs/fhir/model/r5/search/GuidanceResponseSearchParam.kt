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

package dev.ohs.fhir.model.r5.search

import dev.ohs.fhir.model.r5.Group
import dev.ohs.fhir.model.r5.GuidanceResponse
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [GuidanceResponse] resource type. */
public object GuidanceResponseSearchParam {
  /** All search parameters for the GuidanceResponse resource type. */
  public val ALL: List<SearchParam<GuidanceResponse, *>> =
    listOf(Identifier, Patient, Request, Status, Subject)

  public data object Identifier : SearchParam<GuidanceResponse, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GuidanceResponse.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: GuidanceResponse
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Patient : SearchParam<GuidanceResponse, Reference> {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "GuidanceResponse.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: GuidanceResponse): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Request : SearchParam<GuidanceResponse, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "request"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GuidanceResponse.requestIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: GuidanceResponse
    ): List<dev.ohs.fhir.model.r5.Identifier> = listOfNotNull(resource.requestIdentifier)
  }

  public data object Status : SearchParam<GuidanceResponse, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "GuidanceResponse.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: GuidanceResponse): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<GuidanceResponse, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "GuidanceResponse.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r5.Patient::class)

    public override fun extract(resource: GuidanceResponse): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
