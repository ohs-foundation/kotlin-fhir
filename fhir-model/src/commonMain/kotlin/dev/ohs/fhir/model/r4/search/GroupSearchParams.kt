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
public object GroupSearchParams {
  public val `actual`: SearchParam<Group, Boolean> =
    SearchParam(
      name = "actual",
      type = SearchParamType.Token,
      expression = "Group.actual",
      extractor = { resource -> listOf(resource.`actual`) },
    )

  public val characteristic: SearchParam<Group, CodeableConcept> =
    SearchParam(
      name = "characteristic",
      type = SearchParamType.Token,
      expression = "Group.characteristic.code",
      extractor = { resource -> resource.characteristic.map { it.code } },
    )

  public val characteristicValue: SearchParam<Group, Group.Characteristic> =
    SearchParam(
      name = "characteristic-value",
      type = SearchParamType.Composite,
      expression = "Group.characteristic",
      extractor = { resource -> resource.characteristic },
    )

  public val code: SearchParam<Group, CodeableConcept> =
    SearchParam(
      name = "code",
      type = SearchParamType.Token,
      expression = "Group.code",
      extractor = { resource -> listOfNotNull(resource.code) },
    )

  public val exclude: SearchParam<Group, Boolean> =
    SearchParam(
      name = "exclude",
      type = SearchParamType.Token,
      expression = "Group.characteristic.exclude",
      extractor = { resource -> resource.characteristic.map { it.exclude } },
    )

  public val identifier: SearchParam<Group, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.Token,
      expression = "Group.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val managingEntity: SearchParam<Group, Reference> =
    SearchParam(
      name = "managing-entity",
      type = SearchParamType.Reference,
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

  public val member: SearchParam<Group, Reference> =
    SearchParam(
      name = "member",
      type = SearchParamType.Reference,
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

  public val type: SearchParam<Group, Any> =
    SearchParam(
      name = "type",
      type = SearchParamType.Token,
      expression = "Group.type",
      extractor = { resource -> listOf(resource.type) },
    )

  public val `value`: SearchParam<Group, CodeableConcept> =
    SearchParam(
      name = "value",
      type = SearchParamType.Token,
      expression = "(Group.characteristic.value as CodeableConcept)",
      extractor = { resource ->
        resource.characteristic.mapNotNull {
          (it.`value` as? Group.Characteristic.Value.CodeableConcept)?.value
        }
      },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<Group, *>> = listOf()

  /**
   * Supported search parameters for the Group resource type. Iterating `all` and calling
   * `extractFrom` on each entry is safe; see [unsupported] for the parameters excluded from this
   * list.
   */
  public val all: List<SearchParam<Group, *>> =
    listOf(
      `actual`,
      characteristic,
      characteristicValue,
      code,
      exclude,
      identifier,
      managingEntity,
      member,
      type,
      `value`,
    )
}
