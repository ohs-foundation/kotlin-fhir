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
import dev.ohs.fhir.model.r5.InventoryItem
import dev.ohs.fhir.model.r5.Organization
import dev.ohs.fhir.model.r5.Patient
import dev.ohs.fhir.model.r5.Reference
import dev.ohs.fhir.model.r5.Resource
import dev.ohs.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.reflect.KClass

/** Search parameters for the [InventoryItem] resource type. */
public object InventoryItemSearchParam {
  /** All search parameters for the InventoryItem resource type. */
  public val ALL: List<SearchParam<InventoryItem, *>> = listOf(Code, Identifier, Status, Subject)

  public data object Code : SearchParam<InventoryItem, CodeableConcept> {
    public override val paramName: String = "code"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryItem.code"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InventoryItem): List<CodeableConcept> = resource.code
  }

  public data object Identifier : SearchParam<InventoryItem, dev.ohs.fhir.model.r5.Identifier> {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryItem.identifier"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InventoryItem): List<dev.ohs.fhir.model.r5.Identifier> =
      resource.identifier
  }

  public data object Status : SearchParam<InventoryItem, Any> {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "InventoryItem.status"

    public override val target: List<KClass<out Resource>> = emptyList()

    public override fun extract(resource: InventoryItem): List<Any> = listOf(resource.status)
  }

  public data object Subject : SearchParam<InventoryItem, Reference> {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "InventoryItem.instance.subject"

    public override val target: List<KClass<out Resource>> =
      listOf(Organization::class, Patient::class)

    public override fun extract(resource: InventoryItem): List<Reference> =
      listOfNotNull(resource.instance?.subject)
  }
}
