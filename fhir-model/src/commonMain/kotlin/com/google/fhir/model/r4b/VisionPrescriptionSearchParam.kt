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

/** Search parameters for the [VisionPrescription] resource type. */
public sealed class VisionPrescriptionSearchParam<T> : SearchParam {
  /** Extracts the values for this search parameter from the given [resource]. */
  public abstract fun extract(resource: VisionPrescription): List<T>

  public data object Datewritten : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "datewritten"

    public override val type: SearchParamType = SearchParamType.fromCode("date")

    public override val expression: String = "VisionPrescription.dateWritten"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public data object Encounter : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "encounter"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.encounter"

    public override val target: List<String> = listOf("Encounter")

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public data object Identifier : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "identifier"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VisionPrescription.identifier"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public data object Patient : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "patient"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.patient"

    public override val target: List<String> = listOf("Patient")

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public data object Prescriber : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "prescriber"

    public override val type: SearchParamType = SearchParamType.fromCode("reference")

    public override val expression: String = "VisionPrescription.prescriber"

    public override val target: List<String> = listOf("Practitioner", "PractitionerRole")

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public data object Status : VisionPrescriptionSearchParam<Any>() {
    public override val paramName: String = "status"

    public override val type: SearchParamType = SearchParamType.fromCode("token")

    public override val expression: String = "VisionPrescription.status"

    public override val target: List<String> = emptyList()

    public override fun extract(resource: VisionPrescription): List<Any> = emptyList()
  }

  public companion object {
    /** All search parameters for the VisionPrescription resource type. */
    public val ALL: List<VisionPrescriptionSearchParam<*>> =
      listOf(Datewritten, Encounter, Identifier, Patient, Prescriber, Status)
  }
}
