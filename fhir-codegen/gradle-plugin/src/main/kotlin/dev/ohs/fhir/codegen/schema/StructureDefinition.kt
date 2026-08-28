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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StructureDefinition(
  val resourceType: String,
  val id: String,
  val url: String,
  val version: String? = null,
  val name: String,
  val status: String,
  val description: String,
  val fhirVersion: String,
  val kind: Kind,
  val abstract: Boolean,
  val type: String,
  val baseDefinition: String? = null,
  val derivation: String? = null,
  val snapshot: Snapshot? = null,
) {
  enum class Kind {
    @SerialName("primitive-type") PRIMITIVE_TYPE,
    @SerialName("complex-type") COMPLEX_TYPE,
    @SerialName("resource") RESOURCE,
    @SerialName("logical") LOGICAL,
  }
}

@Serializable data class Snapshot(val element: List<Element>)

@Serializable
data class Element(
  val id: String,
  val path: String,
  val short: String? = null,
  val definition: String,
  val comment: String? = null,
  val alias: List<String>? = null,
  val min: Int,
  val max: String,
  val base: Base? = null,
  val contentReference: String? = null,
  val isModifier: Boolean,
  val requirements: String? = null,
  val meaningWhenMissing: String? = null,
  val type: List<Type>? = null,
  val isModifierReason: String? = null,
  val representation: List<String>? = null,
  val condition: List<String>? = null,
  val binding: Binding? = null,
)

@Serializable
data class Binding(
  val extension: List<Extension>? = null,
  val strength: String? = null,
  val description: String? = null,
  val valueSet: String? = null,
)

@Serializable data class Base(val path: String, val min: Int, val max: String)

@Serializable data class Type(val code: String, val extension: List<Extension>? = null)
