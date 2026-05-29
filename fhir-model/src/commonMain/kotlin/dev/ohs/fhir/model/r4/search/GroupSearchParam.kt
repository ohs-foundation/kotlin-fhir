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

import dev.ohs.fhir.model.r4.Boolean
import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.Device
import dev.ohs.fhir.model.r4.Group
import dev.ohs.fhir.model.r4.Identifier
import dev.ohs.fhir.model.r4.Medication
import dev.ohs.fhir.model.r4.Organization
import dev.ohs.fhir.model.r4.Patient
import dev.ohs.fhir.model.r4.Practitioner
import dev.ohs.fhir.model.r4.PractitionerRole
import dev.ohs.fhir.model.r4.Reference
import dev.ohs.fhir.model.r4.RelatedPerson
import dev.ohs.fhir.model.r4.Substance
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [Group] resource type. */
public object GroupSearchParam {
  public val Actual: SearchParam<Group, Boolean> =
    SimpleSearchParam<Group, Boolean>(
      name = "actual",
      type = SearchParamType.fromCode("token"),
      expression = "Group.actual",
      extractor = { resource -> listOf(resource.`actual`) },
    )

  public val Characteristic: SearchParam<Group, CodeableConcept> =
    SimpleSearchParam<Group, CodeableConcept>(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "Group.characteristic.code",
      extractor = { resource -> resource.characteristic.map { it.code } },
    )

  public val CharacteristicValue: SearchParam<Group, Group.Characteristic> =
    SimpleSearchParam<Group, Group.Characteristic>(
      name = "characteristic-value",
      type = SearchParamType.fromCode("composite"),
      expression = "Group.characteristic",
      extractor = { resource -> resource.characteristic },
    )

  public val Code: SearchParam<Group, CodeableConcept> =
    SimpleSearchParam<Group, CodeableConcept>(
      name = "code",
      type = SearchParamType.fromCode("token"),
      expression = "Group.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val Exclude: SearchParam<Group, Boolean> =
    SimpleSearchParam<Group, Boolean>(
      name = "exclude",
      type = SearchParamType.fromCode("token"),
      expression = "Group.characteristic.exclude",
      extractor = { resource -> resource.characteristic.map { it.exclude } },
    )

  public val Identifier: SearchParam<Group, Identifier> =
    SimpleSearchParam<Group, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "Group.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ManagingEntity: SearchParam<Group, Reference> =
    SimpleSearchParam<Group, Reference>(
      name = "managing-entity",
      type = SearchParamType.fromCode("reference"),
      expression = "Group.managingEntity",
      target =
        listOf(
          Practitioner::class,
          Organization::class,
          PractitionerRole::class,
          RelatedPerson::class,
        ),
      extractor = { resource -> listOfNotNull(resource.managingEntity) },
    )

  public val Member: SearchParam<Group, Reference> =
    SimpleSearchParam<Group, Reference>(
      name = "member",
      type = SearchParamType.fromCode("reference"),
      expression = "Group.member.entity",
      target =
        listOf(
          Practitioner::class,
          Group::class,
          Device::class,
          Medication::class,
          Patient::class,
          Substance::class,
          PractitionerRole::class,
        ),
      extractor = { resource -> resource.member.map { it.entity } },
    )

  public val Type: SearchParam<Group, Any> =
    SimpleSearchParam<Group, Any>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "Group.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val Value: SearchParam<Group, CodeableConcept> =
    SimpleSearchParam<Group, CodeableConcept>(
      name = "value",
      type = SearchParamType.fromCode("token"),
      expression = "(Group.characteristic.value as CodeableConcept)",
      extractor = { resource ->
        resource.characteristic.mapNotNull {
          (it.`value` as? Group.Characteristic.Value.CodeableConcept)?.value
        }
      },
    )

  /** All search parameters for the Group resource type. */
  public val ALL: List<SearchParam<Group, *>> =
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
