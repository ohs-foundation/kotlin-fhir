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

import dev.ohs.fhir.model.r5.CodeableConcept
import dev.ohs.fhir.model.r5.DocumentReference
import dev.ohs.fhir.model.r5.Identifier
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.PractitionerRole
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductDefinition] resource type. */
public object MedicinalProductDefinitionSearchParams {
  public val Characteristic: SearchParam<MedicinalProductDefinition, Any> =
    SimpleSearchParam<MedicinalProductDefinition, Any>(
      name = "characteristic",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.characteristic.value.ofType(Quantity)",
      extractor = { emptyList() },
    )

  public val CharacteristicType: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "characteristic-type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.characteristic.type",
      extractor = { resource -> resource.characteristic.map { it.type } },
    )

  public val Contact: SearchParam<MedicinalProductDefinition, Reference> =
    SimpleSearchParam<MedicinalProductDefinition, Reference>(
      name = "contact",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductDefinition.contact.contact",
      target = listOf(Organization::class, PractitionerRole::class),
      extractor = { resource -> resource.contact.map { it.contact } },
    )

  public val Domain: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "domain",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.domain",
      extractor = { resource -> listOfNotNull(resource.domain) },
    )

  public val Identifier: SearchParam<MedicinalProductDefinition, Identifier> =
    SimpleSearchParam<MedicinalProductDefinition, Identifier>(
      name = "identifier",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.identifier",
      extractor = { resource -> resource.identifier },
    )

  public val Ingredient: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "ingredient",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.ingredient",
      extractor = { resource -> resource.ingredient },
    )

  public val MasterFile: SearchParam<MedicinalProductDefinition, Reference> =
    SimpleSearchParam<MedicinalProductDefinition, Reference>(
      name = "master-file",
      type = SearchParamType.fromCode("reference"),
      expression = "MedicinalProductDefinition.masterFile",
      target = listOf(DocumentReference::class),
      extractor = { resource -> resource.masterFile },
    )

  public val Name: SearchParam<MedicinalProductDefinition, String> =
    SimpleSearchParam<MedicinalProductDefinition, String>(
      name = "name",
      type = SearchParamType.fromCode("string"),
      expression = "MedicinalProductDefinition.name.productName",
      extractor = { resource -> resource.name.map { it.productName } },
    )

  public val NameLanguage: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "name-language",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.name.usage.language",
      extractor = { resource -> resource.name.flatMap { it.usage }.map { it.language } },
    )

  public val ProductClassification: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "product-classification",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.classification",
      extractor = { resource -> resource.classification },
    )

  public val Status: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "status",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.status",
      extractor = { resource -> listOfNotNull(resource.status) },
    )

  public val Type: SearchParam<MedicinalProductDefinition, CodeableConcept> =
    SimpleSearchParam<MedicinalProductDefinition, CodeableConcept>(
      name = "type",
      type = SearchParamType.fromCode("token"),
      expression = "MedicinalProductDefinition.type",
      extractor = { resource -> listOfNotNull(resource.type) },
    )

  /** All search parameters for the MedicinalProductDefinition resource type. */
  public val ALL: List<SearchParam<MedicinalProductDefinition, *>> =
    listOf(
      Characteristic,
      CharacteristicType,
      Contact,
      Domain,
      Identifier,
      Ingredient,
      MasterFile,
      Name,
      NameLanguage,
      ProductClassification,
      Status,
      Type,
    )
}
