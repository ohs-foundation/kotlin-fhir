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

import dev.ohs.fhir.model.r4b.DeviceUseStatement
import dev.ohs.fhir.model.r4b.Reference
import dev.ohs.fhir.model.r4b.terminologies.SearchParamType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/** Search parameters for the [DeviceUseStatement] resource type. */
public sealed class DeviceUseStatementSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: DeviceUseStatement): List<T>

  public data object Device : DeviceUseStatementSearchParam<Reference>() {
    public override val paramName: String = "device"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceUseStatement.device"

    public override val target: List<String> = listOf("Device")

    public override fun extract(resource: DeviceUseStatement): List<Reference> =
      listOf(resource.device)
  }

  public data object Identifier :
    DeviceUseStatementSearchParam<dev.ohs.fhir.model.r4b.Identifier>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "DeviceUseStatement.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(
      resource: DeviceUseStatement
    ): List<dev.ohs.fhir.model.r4b.Identifier> = resource.identifier
  }

  public data object Patient : DeviceUseStatementSearchParam<Reference>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String =
      "DeviceUseStatement.subject.where(resolve() is Patient)"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: DeviceUseStatement): List<Reference> =
      listOf(resource.subject).filter {
        it.reference?.value?.toString()?.contains("Patient/") == true
      }
  }

  public data object Subject : DeviceUseStatementSearchParam<Reference>() {
    public override val paramName: String = "subject"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "DeviceUseStatement.subject"

    public override val target: List<String> = listOf("Group", "Patient")

    public override fun extract(resource: DeviceUseStatement): List<Reference> =
      listOf(resource.subject)
  }

  public companion object {
    /** All search parameters for the DeviceUseStatement resource type. */
    public val ALL: List<DeviceUseStatementSearchParam<*>> =
      listOf(Device, Identifier, Patient, Subject)
  }
}
