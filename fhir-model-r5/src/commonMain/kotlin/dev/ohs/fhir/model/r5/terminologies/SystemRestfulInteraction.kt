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

package dev.ohs.fhir.model.r5.terminologies

import dev.ohs.fhir.model.r5.FhirEnum
import kotlin.String

/** Operations supported by REST at the system level. */
public enum class SystemRestfulInteraction(
  override val code: String,
  override val system: String,
  override val display: String?,
) : FhirEnum {
  Transaction("transaction", "http://hl7.org/fhir/restful-interaction", "transaction"),
  Batch("batch", "http://hl7.org/fhir/restful-interaction", "batch"),
  Search_System("search-system", "http://hl7.org/fhir/restful-interaction", "search-system"),
  History_System("history-system", "http://hl7.org/fhir/restful-interaction", "history-system");

  override fun toString(): String = code

  public companion object {
    public fun fromCode(code: String): SystemRestfulInteraction =
      when (code) {
        "transaction" -> Transaction
        "batch" -> Batch
        "search-system" -> Search_System
        "history-system" -> History_System
        else ->
          throw IllegalArgumentException("Unknown code $code for enum SystemRestfulInteraction")
      }
  }
}
