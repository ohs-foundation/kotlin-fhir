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

package com.google.fhir.model.r4.terminologies

import kotlin.String

/** Indication of the degree of conformance expectations associated with a binding. */
public enum class BindingStrength(
  private val code: String,
  private val system: String,
  private val display: String?,
) {
  Required("required", "http://hl7.org/fhir/binding-strength", "Required"),
  Extensible("extensible", "http://hl7.org/fhir/binding-strength", "Extensible"),
  Preferred("preferred", "http://hl7.org/fhir/binding-strength", "Preferred"),
  Example("example", "http://hl7.org/fhir/binding-strength", "Example");

  override fun toString(): String = code

  public fun getCode(): String = code

  public fun getSystem(): String = system

  public fun getDisplay(): String? = display

  public companion object {
    public fun fromCode(code: String): BindingStrength =
      when (code) {
        "required" -> Required
        "extensible" -> Extensible
        "preferred" -> Preferred
        "example" -> Example
        else -> throw IllegalArgumentException("Unknown code $code for enum BindingStrength")
      }
  }
}
