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

import dev.ohs.fhir.model.r4.Canonical
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.DateTime
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.RequestGroup
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.Uri
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [RequestGroup] resource type. */
public object RequestGroupSearchParam {
  /** All search parameters for the RequestGroup resource type. */
  public val ALL: List<SearchParam<RequestGroup, *>> =
    listOf(
      Author,
      Authored,
      Code,
      Encounter,
      GroupIdentifier,
      Identifier,
      InstantiatesCanonical,
      InstantiatesUri,
      Intent,
      Participant,
      Patient,
      Priority,
      Status,
      Subject,
    )

  public data object Author : SearchParam<RequestGroup, Reference> {
    public override val name: String = "author"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.author"

    public override val target: List<KClass<out Resource>> =
      listOf(Practitioner::class, Device::class, PractitionerRole::class)

    public override fun extract(resource: RequestGroup): List<Reference> =
      listOfNotNull(resource.author)
  }

  public data object Authored : SearchParam<RequestGroup, DateTime> {
    public override val name: String = "authored"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "RequestGroup.authoredOn"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<DateTime> =
      listOfNotNull(resource.authoredOn)
  }

  public data object Code : SearchParam<RequestGroup, CodeableConcept> {
    public override val name: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Encounter : SearchParam<RequestGroup, Reference> {
    public override val name: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.encounter"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Encounter::class)

    public override fun extract(resource: RequestGroup): List<Reference> =
      listOfNotNull(resource.encounter)
  }

  public data object GroupIdentifier : SearchParam<RequestGroup, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "group-identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.groupIdentifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<dev.ohs.fhir.model.r4.Identifier> =
      listOfNotNull(resource.groupIdentifier)
  }

  public data object Identifier : SearchParam<RequestGroup, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<dev.ohs.fhir.model.r4.Identifier> =
      resource.identifier
  }

  public data object InstantiatesCanonical : SearchParam<RequestGroup, Canonical> {
    public override val name: String = "instantiates-canonical"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.instantiatesCanonical"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<Canonical> =
      resource.instantiatesCanonical
  }

  public data object InstantiatesUri : SearchParam<RequestGroup, Uri> {
    public override val name: String = "instantiates-uri"

    public override val type: SearchParamType = SearchParamType.fromCode("uri")

    public override val expression: String = "RequestGroup.instantiatesUri"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<Uri> = resource.instantiatesUri
  }

  public data object Intent : SearchParam<RequestGroup, Any> {
    public override val name: String = "intent"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.intent"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = listOf(resource.intent)
  }

  public data object Participant : SearchParam<RequestGroup, Reference> {
    public override val name: String = "participant"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.action.participant"

    public override val target: List<KClass<out Resource>> =
      listOf(
        Practitioner::class,
        Device::class,
        dev.ohs.fhir.model.r4.Patient::class,
        PractitionerRole::class,
        RelatedPerson::class,
      )

    public override fun extract(resource: RequestGroup): List<Reference> =
      resource.action.flatMap { it.participant }
  }

  public data object Patient : SearchParam<RequestGroup, Reference> {
    public override val name: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.subject.where(resolve() is Patient)"

    public override val target: List<KClass<out Resource>> =
      listOf(dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: RequestGroup): List<Reference> =
      listOfNotNull(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Priority : SearchParam<RequestGroup, Any> {
    public override val name: String = "priority"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.priority"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> =
      listOfNotNull(resource.priority)
  }

  public data object Status : SearchParam<RequestGroup, Any> {
    public override val name: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "RequestGroup.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: RequestGroup): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<RequestGroup, Reference> {
    public override val name: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "RequestGroup.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Group::class, dev.ohs.fhir.model.r4.Patient::class)

    public override fun extract(resource: RequestGroup): List<Reference> =
      listOfNotNull(resource.subject)
  }
}
