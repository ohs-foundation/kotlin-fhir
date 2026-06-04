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
 * to produce typed search parameters in the per-resource `{Resource}SearchParams` containers.
 *
 * @property code The parameter name used in search URLs (e.g., "name", "birthdate").
 * @property base The resource type(s) this search parameter applies to (e.g., ["Patient"]).
 * @property type The search parameter type (e.g., "string", "token", "date", "reference").
 * @property expression The FHIRPath expression that extracts values for this search parameter.
 * @property target The target resource types for reference search parameters.
 */
@Serializable
data class SearchParameterDefinition(
  val code: String,
  val base: List<String> = emptyList(),
  val type: String,
  val expression: String? = null,
  val target: List<String> = emptyList(),
)
