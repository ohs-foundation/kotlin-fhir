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

package dev.ohs.fhir.model.r4.terminologies

import dev.ohs.fhir.model.r4.FhirEnum
import kotlin.String

/** Use of contact point. */
public enum class ContactPointUse(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Home("home", "http://hl7.org/fhir/contact-point-use", "Home"),
  Work("work", "http://hl7.org/fhir/contact-point-use", "Work"),
  Temp("temp", "http://hl7.org/fhir/contact-point-use", "Temp"),
  Old("old", "http://hl7.org/fhir/contact-point-use", "Old"),
  Mobile("mobile", "http://hl7.org/fhir/contact-point-use", "Mobile");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ContactPointUse =
      when (code) {
        "home" -> Home
        "work" -> Work
        "temp" -> Temp
        "old" -> Old
        "mobile" -> Mobile
        else -> throw IllegalArgumentException("Unknown code $code for enum ContactPointUse")
      }
  }
}
