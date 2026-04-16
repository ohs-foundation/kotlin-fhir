/*
 * Copyright 2025-2026 Google LLC
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

/**
 * Sanitizes the string for KDoc, replacing character sequences that could break the comment block.
 *
 * See also: https://github.com/square/kotlinpoet/issues/887.
 */
fun String.sanitizeKDoc(): String {
  return this.replace("/*", "&#47;*")
}

/**
 * Normalizes a string into PascalCase, making it suitable for enum class or constant names. It
 * removes all non-alphanumeric characters and converts fully uppercase parts to lowercase before
 * capitalizing them.
 *
 * Normalization is only applied if the input starts with a lowercase letter or is entirely
 * uppercase—this preserves names that are already in valid PascalCase.
 *
 * Example:
 *
 *   ```
 *   "v3.ObservationInterpretation" → "V3ObservationInterpretation"
 *   "UNKNOWN" → "Unknown"
 *   "AdministrativeGender" → "AdministrativeGender"
 *   ```
 */
fun String.normalizeEnumName() =
  this.split(Regex("[^a-zA-Z0-9]+"))
    .asSequence()
    .filter { it.isNotEmpty() }
    .map { if (it.all { letter -> letter.isUpperCase() }) it.lowercase() else it }
    .joinToString("") { it.capitalized() }

/** Converts the firs character of a string to uppercase */
fun String.capitalized() = this.replaceFirstChar(Char::uppercaseChar)
