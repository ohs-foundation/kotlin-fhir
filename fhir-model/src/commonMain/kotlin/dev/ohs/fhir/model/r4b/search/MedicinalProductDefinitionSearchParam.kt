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
import dev.ohs.fhir.model.r4b.MedicinalProductDefinition
import dev.ohs.fhir.model.r4b.Organization
import dev.ohs.fhir.model.r4b.PractitionerRole
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.Resource
import dev.ohs.fhir.model.r4b.String as R4bString
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicinalProductDefinition] resource type. */
public object MedicinalProductDefinitionSearchParam {
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

  public data object Characteristic :
    SearchParam<MedicinalProductDefinition, MedicinalProductDefinition.Characteristic.Value> {
    public override val name: KotlinString = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.characteristic.value"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicinalProductDefinition
    ): List<MedicinalProductDefinition.Characteristic.Value> =
      resource.characteristic.mapNotNull { it.value }
  }

  public data object CharacteristicType : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "characteristic-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.characteristic.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.characteristic.map { it.type }
  }

  public data object Contact : SearchParam<MedicinalProductDefinition, Reference> {
    public override val name: KotlinString = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MedicinalProductDefinition.contact.contact"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, PractitionerRole::class)

    public override fun extract(resource: MedicinalProductDefinition): List<Reference> =
      resource.contact.map { it.contact }
  }

  public data object Domain : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.domain"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.domain)
  }

  public data object Identifier :
    SearchParam<MedicinalProductDefinition, dev.ohs.fhir.model.r4b.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicinalProductDefinition
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Ingredient : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.ingredient"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.ingredient
  }

  public data object MasterFile : SearchParam<MedicinalProductDefinition, Reference> {
    public override val name: KotlinString = "master-file"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MedicinalProductDefinition.masterFile"

    public override val target: List<KClass<out Resource>> = listOf(DocumentReference::class)

    public override fun extract(resource: MedicinalProductDefinition): List<Reference> =
      resource.masterFile
  }

  public data object Name : SearchParam<MedicinalProductDefinition, R4bString> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MedicinalProductDefinition.name.productName"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<R4bString> =
      resource.name.map { it.productName }
  }

  public data object NameLanguage : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "MedicinalProductDefinition.name.countryLanguage.language"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.name.flatMap { it.countryLanguage }.map { it.language }
  }

  public data object ProductClassification :
    SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "product-classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.classification"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.classification
  }

  public data object Status : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Type : SearchParam<MedicinalProductDefinition, CodeableConcept> {
    public override val name: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.type"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }
}
