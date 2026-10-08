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

package dev.ohs.fhir.model.r4b.terminologies

import dev.ohs.fhir.model.r4b.FhirEnum
import kotlin.String

/** Telecommunications form for contact point. */
public enum class ContactPointSystem(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Phone("phone", "http://hl7.org/fhir/contact-point-system", "Phone"),
  Fax("fax", "http://hl7.org/fhir/contact-point-system", "Fax"),
  Email("email", "http://hl7.org/fhir/contact-point-system", "Email"),
  Pager("pager", "http://hl7.org/fhir/contact-point-system", "Pager"),
  Url("url", "http://hl7.org/fhir/contact-point-system", "URL"),
  Sms("sms", "http://hl7.org/fhir/contact-point-system", "SMS"),
  Other("other", "http://hl7.org/fhir/contact-point-system", "Other");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): ContactPointSystem =
      when (code) {
        "phone" -> Phone
        "fax" -> Fax
        "email" -> Email
        "pager" -> Pager
        "url" -> Url
        "sms" -> Sms
        "other" -> Other
        else -> throw IllegalArgumentException("Unknown code $code for enum ContactPointSystem")
      }
  }
}
