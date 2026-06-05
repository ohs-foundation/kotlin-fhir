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

import dev.ohs.fhir.model.r4b.CodeableConcept
import dev.ohs.fhir.model.r4b.DocumentReference
import dev.ohs.fhir.model.r4b.Identifier
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.String
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductDefinition] resource type. */
public object MedicinalProductDefinitionSearchParams {
  public val characteristic:
    SearchParam<MedicinalProductDefinition, MedicinalProductDefinition.Characteristic.Value> =
    SearchParam(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.characteristic.value",
      extractor = { resource -> resource.characteristic.mapNotNull { it.`value` } },
    )

  public val characteristicType: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "characteristic-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.characteristic.type",
      extractor = { resource -> resource.characteristic.map { it.type } },
    )

  public val contact: SearchParam<MedicinalProductDefinition, Reference> =
    SearchParam(
      name = "contact",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductDefinition.contact.contact",
      target = listOf(Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.contact.map { it.contact } },
    )

  public val domain: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "domain",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.domain",
      extractor = { resource -> listOfNotNull(resource.domain) },
    )

  public val identifier: SearchParam<MedicinalProductDefinition, Identifier> =
    SearchParam(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val ingredient: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "ingredient",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.ingredient",
      extractor = { resource -> resource.ingredient },
    )

  public val masterFile: SearchParam<MedicinalProductDefinition, Reference> =
    SearchParam(
      name = "master-file",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductDefinition.masterFile",
      target = listOf(DocumentReference::class),
      extractor = { resource -> resource.masterFile },
    )

  public val name: SearchParam<MedicinalProductDefinition, String> =
    SearchParam(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MedicinalProductDefinition.name.productName",
      extractor = { resource -> resource.name.map { it.productName } },
    )

  public val nameLanguage: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "name-language",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.name.countryLanguage.language",
      extractor = { resource -> resource.name.flatMap { it.countryLanguage }.map { it.language } },
    )

  public val productClassification: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "product-classification",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.classification",
      extractor = { resource -> resource.classification },
    )

  public val status: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val type: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SearchParam(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /**
   * Search parameters whose FHIRPath isn't supported yet. Calling `extractFrom` on any of these
   * throws `NotImplementedError`. Listed here so the unsupported set is visible at a glance, and
   * subtracted from [all].
   */
  public val unsupported: List<SearchParam<MedicinalProductDefinition, *>> = listOf()

  /**
   * Supported search parameters for the MedicinalProductDefinition resource type. Entries in
   * [unsupported] are excluded so iterating `all` and calling `extractFrom` on each entry is safe.
   */
  public val all: List<SearchParam<MedicinalProductDefinition, *>> =
    listOf(
      characteristic,
      characteristicType,
      contact,
      domain,
      identifier,
      ingredient,
      masterFile,
      name,
      nameLanguage,
      productClassification,
      status,
      type,
    ) - unsupported.toSet()
}
