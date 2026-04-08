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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.terminologies.SearchParamType
import kotlin.Any
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceAssociation] resource type. */
public sealed class DeviceAssociationSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceAssociation): List<T>

  public data object Device : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.device"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public data object Identifier : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceAssociation.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public data object Operator : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "operator"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.operation.operator"

    public override val target: List<String> = listOf("RelatedPerson", "Practitioner", "Patient")

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public data object Patient : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public data object Status : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceAssociation.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public data object Subject : DeviceAssociationSearchParam<Any>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceAssociation.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DeviceAssociation): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the DeviceAssociation resource type. */
    public val ALL: List<DeviceAssociationSearchParam<*>> =
      listOf(Device, Identifier, Operator, Patient, Status, Subject)
  }
}
