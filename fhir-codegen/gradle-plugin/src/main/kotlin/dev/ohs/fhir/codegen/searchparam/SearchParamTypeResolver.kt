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
import dev.ohs.fhir.codegen.PropertyMapper
import dev.ohs.fhir.codegen.ResolvedExpression
import dev.ohs.fhir.codegen.choiceTypeExpansionName
import dev.ohs.fhir.codegen.schema.capitalized
import dev.ohs.fhir.codegen.schema.valueset.ValueSet

/**
 * Resolves the KotlinPoet [TypeName] used as the type parameter `T` of `SearchParam<R, T>` for a
 * given [SearchParamPattern], plus the sealed-element subclass referenced by an element-cast
 * extraction.
 *
 * Delegates element and choice-expansion type mapping to [PropertyMapper] so search parameters
 * always resolve to the same Kotlin types as the generated model properties.
 */
internal object SearchParamTypeResolver {

  /** Resolves the [TypeName] used as `T` of `SearchParam<R, T>` for [pattern]. */
  fun resolve(
    pattern: SearchParamPattern,
    packageName: String,
    valueSetMap: Map<String, ValueSet> = emptyMap(),
  ): TypeName =
    when (pattern) {
      is SearchParamPattern.SimplePath ->
        forResolvedPath(pattern.resolved, packageName, valueSetMap)
      is SearchParamPattern.WhereResolve ->
        forResolvedPath(pattern.resolved, packageName, valueSetMap)
      is SearchParamPattern.ElementNoCast ->
        forResolvedPath(pattern.resolved, packageName, valueSetMap)
      is SearchParamPattern.ElementCast ->
        forElementCastTarget(pattern.resolved, pattern.targetType, packageName, valueSetMap)
      is SearchParamPattern.WhereFilter ->
        forResolvedPath(pattern.postPath ?: pattern.resolved, packageName, valueSetMap)
      // If all branches produce the same value type, use it. Otherwise fall back to Any: e.g.
      // `ofType(dateTime) | ofType(Period)` produces two different types.
      is SearchParamPattern.Union ->
        pattern.branches.map { resolve(it, packageName, valueSetMap) }.distinct().singleOrNull()
          ?: ClassName("kotlin", "Any")
      SearchParamPattern.Unsupported -> ClassName("kotlin", "Any")
    }

  /** Nested sealed-subclass class name for an element cast (e.g. `Observation.Value.Quantity`). */
  fun elementSubclass(
    resolved: ResolvedExpression,
    targetType: String,
    packageName: String,
  ): ClassName {
    val sealedInterface = forResolvedPath(resolved, packageName, emptyMap()) as ClassName
    val leafElement = resolved.segments.lastOrNull()?.element
    val matchedType =
      leafElement?.type?.firstOrNull { it.code.equals(targetType, ignoreCase = true) }
    val expansionName =
      if (matchedType != null) choiceTypeExpansionName(matchedType) else targetType.capitalized()
    return sealedInterface.nestedClass(expansionName)
  }

  // -- private helpers --------------------------------------------------------------------------

  private fun forResolvedPath(
    resolved: ResolvedExpression,
    packageName: String,
    valueSetMap: Map<String, ValueSet>,
  ): TypeName {
    val leafElement = resolved.segments.lastOrNull()?.element ?: return ClassName("kotlin", "Any")
    val enclosingClass = enclosingModelClassName(resolved, packageName)
    return PropertyMapper(PropertyMapper.MappingContext.MODEL, enclosingClass, valueSetMap)
      .mapToModelType(leafElement)
  }

  private fun forElementCastTarget(
    resolved: ResolvedExpression,
    targetType: String,
    packageName: String,
    valueSetMap: Map<String, ValueSet>,
  ): TypeName {
    val leafElement = resolved.segments.lastOrNull()?.element ?: return ClassName("kotlin", "Any")
    val matchedType =
      leafElement.type?.firstOrNull { it.code.equals(targetType, ignoreCase = true) }
        ?: return ClassName("kotlin", "Any")
    val enclosingClass = enclosingModelClassName(resolved, packageName)
    return PropertyMapper(PropertyMapper.MappingContext.MODEL, enclosingClass, valueSetMap)
      .mapTypeToClassName(matchedType)
  }
}

/**
 * Builds the [ClassName] of the model class that immediately encloses the leaf segment of
 * [resolved].
 *
 * For example:
 * - `Patient.gender` -> `ClassName(packageName, "Patient")`
 * - `Patient.contact.relationship` -> `ClassName(packageName, "Patient", "Contact")`
 * - `Patient.address.use` -> `ClassName(packageName, "Address")`
 */
private fun enclosingModelClassName(resolved: ResolvedExpression, packageName: String): ClassName {
  val names = mutableListOf(resolved.resourceName.capitalized())
  for (segment in resolved.segments.dropLast(1)) {
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
