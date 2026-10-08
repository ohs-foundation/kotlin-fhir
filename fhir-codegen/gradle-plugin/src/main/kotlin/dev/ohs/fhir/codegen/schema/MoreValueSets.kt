/*
 * Copyright 2025-2026 Open Health Stack Foundation
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

package dev.ohs.fhir.codegen.schema

import dev.ohs.fhir.codegen.schema.valueset.ValueSet

val ValueSet.urlPart
  get() = url.substringBeforeLast("|")

/**
 * Returns the Kotlin enum class name for this [ValueSet].
 *
 * In FHIR R4, both `medication-status` and `medication-statement-status` share the name
 * `"Medication Status Codes"` (a spec typo fixed in R4B to `"MedicationStatement Status Codes"`).
 */
val ValueSet.enumName: String
  get() =
    when (urlPart) {
      "http://hl7.org/fhir/ValueSet/medication-statement-status" -> "MedicationStatementStatusCodes"
      else -> name.normalizeEnumName()
    }
