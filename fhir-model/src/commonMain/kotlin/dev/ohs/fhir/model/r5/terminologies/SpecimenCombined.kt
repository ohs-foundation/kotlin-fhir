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

package com.google.fhir.model.r5.terminologies

import kotlin.String

/** Codes providing the combined status of a specimen. */
public enum class SpecimenCombined(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Grouped("grouped", "http://hl7.org/fhir/specimen-combined", "Grouped"),
  Pooled("pooled", "http://hl7.org/fhir/specimen-combined", "Pooled");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): SpecimenCombined =
      when (code) {
        "grouped" -> Grouped
        "pooled" -> Pooled
        else -> throw IllegalArgumentException("Unknown code $code for enum SpecimenCombined")
      }
  }
}
