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

/** The type of link between this patient resource and another patient resource. */
public enum class LinkType(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Replaced_By("replaced-by", "http://hl7.org/fhir/link-type", "Replaced-by"),
  Replaces("replaces", "http://hl7.org/fhir/link-type", "Replaces"),
  Refer("refer", "http://hl7.org/fhir/link-type", "Refer"),
  Seealso("seealso", "http://hl7.org/fhir/link-type", "See also");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): LinkType =
      when (code) {
        "replaced-by" -> Replaced_By
        "replaces" -> Replaces
        "refer" -> Refer
        "seealso" -> Seealso
        else -> throw IllegalArgumentException("Unknown code $code for enum LinkType")
      }
  }
}
