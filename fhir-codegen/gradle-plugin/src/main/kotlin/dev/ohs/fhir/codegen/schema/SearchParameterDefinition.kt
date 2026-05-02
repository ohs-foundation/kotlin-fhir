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

import kotlinx.serialization.Serializable

/**
 * Minimal representation of a FHIR SearchParameter resource definition, used during code generation
 * to produce typed search parameter constants on resource companion objects.
 */
@Serializable
data class SearchParameterDefinition(
  /** The parameter name used in search URLs (e.g., "name", "birthdate"). */
  val code: String,
  /** The resource type(s) this search parameter applies to (e.g., ["Patient"]). */
  val base: List<String> = emptyList(),
  /** The search parameter type (e.g., "string", "token", "date", "reference"). */
  val type: String,
  /** The FHIRPath expression that extracts values for this search parameter. */
  val expression: String? = null,
  /** The target resource types for reference search parameters. */
  val target: List<String> = emptyList(),
)
