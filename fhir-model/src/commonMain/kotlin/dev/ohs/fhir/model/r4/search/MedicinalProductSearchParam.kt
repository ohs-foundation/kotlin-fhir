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

import dev.ohs.fhir.model.r4.CodeableConcept
import dev.ohs.fhir.model.r4.MedicinalProduct
import dev.ohs.fhir.model.r4.Resource
import dev.ohs.fhir.model.r4.String as R4String
import dev.ohs.fhir.model.r4.terminologies.SearchParamType
import kotlin.String as KotlinString
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [MedicinalProduct] resource type. */
public object MedicinalProductSearchParam {
  /** All search parameters for the MedicinalProduct resource type. */
  public val ALL: List<SearchParam<MedicinalProduct, *>> = listOf(Identifier, Name, NameLanguage)

  public data object Identifier : SearchParam<MedicinalProduct, dev.ohs.fhir.model.r4.Identifier> {
    public override val name: KotlinString = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProduct.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(
      resource: MedicinalProduct
    ): List<dev.ohs.fhir.model.r4.Identifier> = resource.identifier
  }

  public data object Name : SearchParam<MedicinalProduct, R4String> {
    public override val name: KotlinString = "name"

    public override val type: SearchParamType = SearchParamType.fromCode("string")

    public override val expression: KotlinString = "MedicinalProduct.name.productName"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<R4String> =
      resource.name.map { it.productName }
  }

  public data object NameLanguage : SearchParam<MedicinalProduct, CodeableConcept> {
    public override val name: KotlinString = "name-language"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: KotlinString = "MedicinalProduct.name.countryLanguage.language"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: MedicinalProduct): List<CodeableConcept> =
      resource.name.flatMap { it.countryLanguage }.map { it.language }
  }
}
