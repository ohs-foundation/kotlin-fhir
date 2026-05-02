/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [MedicinalProductDefinition] resource type. */
public sealed class MedicinalProductDefinitionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: MedicinalProductDefinition): List<T>

  public data object Characteristic : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "characteristic"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.characteristic.value"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object CharacteristicType : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "characteristic-type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.characteristic.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Contact : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "contact"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductDefinition.contact.contact"

    public override val target: List<String> = listOf("Organization", "PractitionerRole")

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Domain : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "domain"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.domain"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Identifier : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Ingredient : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "ingredient"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.ingredient"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object MasterFile : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "master-file"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "MedicinalProductDefinition.masterFile"

    public override val target: List<String> = listOf("DocumentReference")

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Name : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: String = "MedicinalProductDefinition.name.productName"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object NameLanguage : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String =
      "MedicinalProductDefinition.name.countryLanguage.language"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object ProductClassification : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "product-classification"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.classification"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Status : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
  }

  public data object Type : MedicinalProductDefinitionSearchParam<Any>() {
    public override val paramName: String = "type"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "MedicinalProductDefinition.type"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: MedicinalProductDefinition): List<Any> = emptyList()
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
