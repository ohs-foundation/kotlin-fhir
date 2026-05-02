/*
 * Copyright 2026 Google LLC
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

package com.google.fhir.codegen

import com.google.fhir.codegen.schema.Element
import com.google.fhir.codegen.schema.getElementName
import com.google.fhir.codegen.schema.isBackboneElement

/**
 * A resolved segment of a FHIRPath expression, representing a single property access step.
 *
 * @param propertyName The Kotlin property name (e.g., "birthDate", "address", "city").
 * @param isList True if the element has max cardinality "*".
 * @param isNullable True if the element has min cardinality 0 and is not a list.
 * @param leafTypeCode The FHIR type code of this segment's type (e.g., "date", "Address").
 * @param isChoiceType True if the element has multiple types (e.g., `deceased[x]`).
 * @param isBackboneElement True if the element is a BackboneElement.
 */
internal data class ResolvedSegment(
  val propertyName: String,
  val isList: Boolean,
  val isNullable: Boolean,
  val leafTypeCode: String?,
  val isChoiceType: Boolean,
  val isBackboneElement: Boolean,
  val choiceTypeCodes: List<String>? = null,
)

/**
 * A fully resolved FHIRPath expression, containing the sequence of property access steps.
 *
 * @param segments The resolved segments in order.
 * @param resourceName The resource type this expression applies to (e.g., "Patient").
 */
internal data class ResolvedExpression(
  val segments: List<ResolvedSegment>,
  val resourceName: String,
)

/**
 * Resolves simple FHIRPath expressions (dotted property paths) into [ResolvedExpression]s by
 * looking up element definitions in StructureDefinition snapshots.
 *
 * Only handles simple dotted paths like `Patient.birthDate` or `Patient.address.city`. Returns
 * `null` for complex expressions involving type casts, where() filters, exists(), extensions, etc.
 *
 * @param elementsByType A map from StructureDefinition name (e.g., "Patient", "Address") to its
 *   snapshot elements.
 */
internal class FhirPathExpressionResolver(private val elementsByType: Map<String, List<Element>>) {

  /**
   * Resolves a FHIRPath expression into a [ResolvedExpression].
   *
   * @param expression The FHIRPath expression (e.g., "Patient.birthDate").
   * @param resourceName The resource type name (e.g., "Patient").
   * @return The resolved expression, or `null` if the expression is unsupported.
   */
  fun resolve(
    expression: String,
    resourceName: String,
    allowChoiceAtLeaf: Boolean = false,
  ): ResolvedExpression? {
    if (!isSimpleDottedPath(expression, resourceName)) return null

    val parts = expression.split(".")
    // First part should be the resource name
    if (parts.first() != resourceName) return null
    val pathParts = parts.drop(1)
    if (pathParts.isEmpty()) return null

    val segments = mutableListOf<ResolvedSegment>()
    // For backbone elements, we look up elements within the resource's own snapshot
    // using the full FHIR path. For external types, we switch to that type's snapshot.
    var currentTypeName = resourceName
    var currentPathPrefix = resourceName
    var isWithinResourceSnapshot = true

    for (segmentName in pathParts) {
      val element =
        findElement(currentTypeName, currentPathPrefix, segmentName, isWithinResourceSnapshot)
          ?: return null

      val isList = element.max == "*"
      val isNullable = element.min == 0 && !isList
      val isChoice = (element.type?.size ?: 0) > 1
      val isBackbone = element.isBackboneElement()
      val typeCode = element.type?.singleOrNull()?.code

      if (isChoice) {
        if (!allowChoiceAtLeaf || segmentName != pathParts.last()) return null
        segments.add(
          ResolvedSegment(
            propertyName = element.getElementName(),
            isList = isList,
            isNullable = isNullable,
            leafTypeCode = null,
            isChoiceType = true,
            isBackboneElement = false,
            choiceTypeCodes = element.type?.map { it.code },
          )
        )
        return ResolvedExpression(segments, resourceName)
      }

      segments.add(
        ResolvedSegment(
          propertyName = element.getElementName(),
          isList = isList,
          isNullable = isNullable,
          leafTypeCode = typeCode,
          isChoiceType = false,
          isBackboneElement = isBackbone,
        )
      )

      // Advance to the next type for the next segment
      if (isBackbone) {
        // Stay within the resource's snapshot, extend the path prefix
        currentPathPrefix = element.path
        isWithinResourceSnapshot = true
      } else if (typeCode != null) {
        // Switch to the external type's snapshot
        currentTypeName = typeCode
        currentPathPrefix = typeCode
        isWithinResourceSnapshot = false
      } else {
        // Can't determine the type — bail out
        return null
      }
    }

    return ResolvedExpression(segments, resourceName)
  }

  private fun findElement(
    typeName: String,
    pathPrefix: String,
    segmentName: String,
    isWithinResourceSnapshot: Boolean,
  ): Element? {
    val snapshotTypeName = if (isWithinResourceSnapshot) typeName else pathPrefix
    val elements = elementsByType[snapshotTypeName] ?: return null
    val targetPath = "$pathPrefix.$segmentName"
    // Try exact match first, then try with [x] suffix for choice types
    return elements.firstOrNull { it.path == targetPath }
      ?: elements.firstOrNull { it.path == "$targetPath[x]" }
  }

  companion object {
    /** Checks if the expression is a simple dotted path that we can resolve. */
    private fun isSimpleDottedPath(expression: String, resourceName: String): Boolean {
      if (expression.isBlank()) return false
      if (!expression.startsWith("$resourceName.")) return false
      val unsupported =
        listOf(
          " as ",
          ".where(",
          ".exists()",
          ".extension(",
          " and ",
          " or ",
          ".resolve(",
          ".ofType(",
          "(",
          ")",
        )
      return unsupported.none { expression.contains(it) }
    }
  }
}
