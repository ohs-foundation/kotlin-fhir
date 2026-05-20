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
import dev.ohs.fhir.model.r5.MedicinalProductDefinition
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.String as R5String
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductDefinition] resource type. */
public sealed class MedicinalProductDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProductDefinition): List<T>

  public data object Characteristic : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: KotlinString = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString =
      "MedicinalProductDefinition.characteristic.value.ofType(Quantity)"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object CharacteristicType : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "characteristic-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.characteristic.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.characteristic.map { it.type }
  }

  public data object Contact : MedicinalProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MedicinalProductDefinition.contact.contact"

    public override val target: List<KotlinString> = listOf("Organization", "PractitionerRole")

    public override fun extract(resource: MedicinalProductDefinition): List<Reference> =
      resource.contact.map { it.contact }
  }

  public data object Domain : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.domain"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.domain)
  }

  public data object Identifier :
    MedicinalProductDefinitionSearchParam<dev.ohs.fhir.model.r5.Identifier>() {
    public override val paramName: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.identifier"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(
      resource: MedicinalProductDefinition
    ): List<dev.ohs.fhir.model.r5.Identifier> = resource.identifier
  }

  public data object Ingredient : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.ingredient"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.ingredient
  }

  public data object MasterFile : MedicinalProductDefinitionSearchParam<Reference>() {
    public override val paramName: KotlinString = "master-file"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: KotlinString = "MedicinalProductDefinition.masterFile"

    public override val target: List<KotlinString> = listOf("DocumentReference")

    public override fun extract(resource: MedicinalProductDefinition): List<Reference> =
      resource.masterFile
  }

  public data object Name : MedicinalProductDefinitionSearchParam<R5String>() {
    public override val paramName: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MedicinalProductDefinition.name.productName"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<R5String> =
      resource.name.map { it.productName }
  }

  public data object NameLanguage : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.name.usage.language"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.name.flatMap { it.usage }.map { it.language }
  }

  public data object ProductClassification :
    MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "product-classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.classification"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      resource.classification
  }

  public data object Status : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.status"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.status)
  }

  public data object Type : MedicinalProductDefinitionSearchParam<CodeableConcept>() {
    public override val paramName: KotlinString = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProductDefinition.type"

    public override val target: List<KotlinString> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<CodeableConcept> =
      listOfNotNull(resource.type)
  }

  public companion object {
    /** All search parameters for the MedicinalProductDefinition resource type. */
    public val ALL: List<MedicinalProductDefinitionSearchParam<*>> =
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
}
