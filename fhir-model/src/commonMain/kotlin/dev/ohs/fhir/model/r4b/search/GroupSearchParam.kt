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

import dev.ohs.fhir.model.r4b.Boolean
import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.Group
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Group] resource type. */
public sealed class GroupSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: Group): List<T>

  public data object Actual : GroupSearchParam<Boolean>() {
    public override val paramName: String = "actual"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.actual"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<Boolean> = listOf(resource.actual)
  }

  public data object Characteristic : GroupSearchParam<CodeableConcept>() {
    public override val paramName: String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.characteristic.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<CodeableConcept> =
      resource.characteristic.map { it.code }
  }

  public data object CharacteristicValue : GroupSearchParam<Group.Characteristic>() {
    public override val paramName: String = "characteristic-value"

    public override val type: SearchParamType = SearchParamType.fromCode("composite")

    public override val expression: String = "Group.characteristic"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<Group.Characteristic> =
      resource.characteristic
  }

  public data object Code : GroupSearchParam<CodeableConcept>() {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.code"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<CodeableConcept> =
      listOfNotNull(resource.code)
  }

  public data object Exclude : GroupSearchParam<Boolean>() {
    public override val paramName: String = "exclude"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.characteristic.exclude"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<Boolean> =
      resource.characteristic.map { it.exclude }
  }

  public data object Identifier : GroupSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<dev.ohs.fhir.model.r4b.Identifier> =
      resource.identifier
  }

  public data object ManagingEntity : GroupSearchParam<Reference>() {
    public override val paramName: String = "managing-entity"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Group.managingEntity"

    public override val target: List<String> =
      listOf("Practitioner", "Organization", "PractitionerRole", "RelatedPerson")

    public override fun extract(resource: Group): List<Reference> =
      listOfNotNull(resource.managingEntity)
  }

  public data object Member : GroupSearchParam<Reference>() {
    public override val paramName: String = "member"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "Group.member.entity"

    public override val target: List<String> =
      listOf(
        "Practitioner",
        "Group",
        "Device",
        "Medication",
        "Patient",
        "Substance",
        "PractitionerRole",
        "RelatedPerson",
      )

    public override fun extract(resource: Group): List<Reference> =
      resource.member.map { it.entity }
  }

  public data object Type : GroupSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "Group.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<Any> = listOf(resource.type)
  }

  public data object Value : GroupSearchParam<CodeableConcept>() {
    public override val paramName: String = "value"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "(Group.characteristic.value as CodeableConcept)"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: Group): List<CodeableConcept> =
      resource.characteristic.mapNotNull {
        (it.value as? Group.Characteristic.Value.CodeableConcept)?.value
      }
  }

  public companion object {
    /** All search parameters for the Group resource type. */
    public val ALL: List<GroupSearchParam<*>> =
      listOf(
        Actual,
        Characteristic,
        CharacteristicValue,
        Code,
        Exclude,
        Identifier,
        ManagingEntity,
        Member,
        Type,
        Value,
      )
  }
}
