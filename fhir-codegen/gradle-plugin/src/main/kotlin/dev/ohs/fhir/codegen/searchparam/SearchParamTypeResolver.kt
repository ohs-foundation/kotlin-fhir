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

package dev.ohs.fhir.codegen.searchparam

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeName
import dev.ohs.fhir.codegen.ResolvedExpression
import dev.ohs.fhir.codegen.schema.capitalized

/**
 * Resolves the KotlinPoet [TypeName] used as the type parameter `T` of `SearchParam<R, T>` for a
 * given [SearchParamPattern], plus the sealed-element subclass referenced by an element-cast
 * extraction.
 *
 * Owns the rules for mapping a resolved FHIRPath leaf to a model class — handling backbone
 * elements, the special `code` enum case, URL-shaped type codes, and choice-type sealed interfaces.
 */
internal object SearchParamTypeResolver {

  /** Resolves the [TypeName] used as `T` of `SearchParam<R, T>` for [pattern]. */
  fun resolve(pattern: SearchParamPattern, packageName: String, resourceName: String): TypeName =
    when (pattern) {
      is SearchParamPattern.SimplePath ->
        forResolvedPath(pattern.resolved, packageName, resourceName)
      is SearchParamPattern.WhereResolve ->
        forResolvedPath(pattern.resolved, packageName, resourceName)
      is SearchParamPattern.ElementNoCast ->
        buildSealedInterfaceClassName(pattern.resolved, packageName)
      is SearchParamPattern.ElementCast -> forElementCastTarget(pattern.targetType, packageName)
      is SearchParamPattern.WhereFilter ->
        if (pattern.postPath != null) forResolvedPath(pattern.postPath, packageName, resourceName)
        else ClassName(packageName, pattern.resolved.segments.last().leafTypeCode!!.capitalized())
      SearchParamPattern.Unsupported -> ClassName("kotlin", "Any")
    }

  /** Nested sealed-subclass class name for an element cast (e.g. `Observation.Value.Quantity`). */
  fun elementSubclass(
    resolved: ResolvedExpression,
    targetType: String,
    packageName: String,
  ): ClassName =
    buildSealedInterfaceClassName(resolved, packageName).nestedClass(targetType.capitalized())

  // -- private helpers --------------------------------------------------------------------------

  /**
   * Type for a simple dotted path or a `where(resolve() is …)` (the filter is dropped). Falls back
   * to `kotlin.Any` for `code`-typed leaves and for type codes containing `/` or `:`.
   */
  private fun forResolvedPath(
    resolved: ResolvedExpression,
    packageName: String,
    resourceName: String,
  ): TypeName {
    val lastSegment = resolved.segments.lastOrNull() ?: return ClassName("kotlin", "Any")
    val typeCode = lastSegment.leafTypeCode ?: return ClassName("kotlin", "Any")

    if (lastSegment.isBackboneElement) {
      return buildBackboneClassName(resolved, packageName, resourceName)
    }

    // Elements of type "code" may be generated as Enumeration<X> depending on value set bindings
    if (typeCode == "code") return ClassName("kotlin", "Any")

    // Type codes containing special characters (e.g., FHIRPath URIs) can't be used as class names
    if (typeCode.contains("/") || typeCode.contains(":")) return ClassName("kotlin", "Any")

    return ClassName(packageName, typeCode.capitalized())
  }

  /** Type for the target of an element cast. Falls back to `kotlin.Any` for URL-shaped types. */
  private fun forElementCastTarget(targetType: String, packageName: String): TypeName {
    if (targetType.contains("/") || targetType.contains(":")) {
      return ClassName("kotlin", "Any")
    }
    return ClassName(packageName, targetType.capitalized())
  }
}

/**
 * Builds the [ClassName] for a backbone element type by tracing the path through the resolved
 * segments.
 *
 * For example, for `Patient.contact.relationship` (leaf is `relationship`, a `CodeableConcept`),
 * this produces `ClassName(packageName, "Patient", "Contact")` — the nearest enclosing backbone.
 */
private fun buildBackboneClassName(
  resolved: ResolvedExpression,
  packageName: String,
  resourceName: String,
): ClassName {
  val names = mutableListOf(resourceName)
  for (segment in resolved.segments) {
    if (segment.isBackboneElement) {
      names.add(segment.propertyName.capitalized())
    }
  }
  return ClassName(packageName, names)
}

private fun buildSealedInterfaceClassName(
  resolved: ResolvedExpression,
  packageName: String,
): ClassName {
  val names = mutableListOf(resolved.resourceName)

  for (segment in resolved.segments) {
    if (segment.isChoiceType) {
      names.add(segment.propertyName.capitalized())
      break
    }
    if (segment.isBackboneElement) {
      names.add(segment.propertyName.capitalized())
    } else {
      val typeCode = segment.leafTypeCode ?: continue
      names.clear()
      names.add(typeCode.capitalized())
    }
  }
  return ClassName(packageName, names)
}
