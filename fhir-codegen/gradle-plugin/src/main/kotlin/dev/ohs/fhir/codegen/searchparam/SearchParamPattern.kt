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

import dev.ohs.fhir.codegen.FhirPathExpressionResolver
import dev.ohs.fhir.codegen.ResolvedExpression

/**
 * Classification of a FHIRPath search-parameter expression after parsing.
 *
 * Each case carries the inputs needed by the renderer. Anything the parser cannot match collapses
 * to [Unsupported], which the renderer emits as `List<Any>` / `return emptyList()`.
 */
internal sealed interface SearchParamPattern {
  /** A simple dotted path like `Patient.name.given`. */
  data class SimplePath(val resolved: ResolvedExpression) : SearchParamPattern

  /** An element cast: `(Resource.path as Type)` or `Resource.path.as(Type)`. */
  data class ElementCast(val resolved: ResolvedExpression, val targetType: String) :
    SearchParamPattern

  /** A reference to an element with no type cast like `Patient.deceased`. */
  data class ElementNoCast(val resolved: ResolvedExpression) : SearchParamPattern

  /**
   * A `path.where(resolve() is Type)` expression. At codegen time the filter is approximated by
   * substring-matching `Reference.reference` against `Type/`, since the actual `resolve()` would
   * require fetching the referenced resource at runtime.
   */
  data class WhereResolve(val resolved: ResolvedExpression, val targetType: String) :
    SearchParamPattern

  /**
   * A `path.where(field='value')` expression with an optional post-`where` access path.
   *
   * @property resolved The path before `where(...)` (e.g. `Patient.telecom`).
   * @property field The field tested by the predicate (e.g. `system`).
   * @property value The string literal the field is matched against (e.g. `email`).
   * @property postPath The path applied after the filter, if any (e.g. `.value`); null when the
   *   `where(...)` is the whole expression.
   */
  data class WhereFilter(
    val resolved: ResolvedExpression,
    val field: String,
    val value: String,
    val postPath: ResolvedExpression?,
    val isFieldNullable: Boolean = true,
  ) : SearchParamPattern

  /** Anything not matched by the parsers above. Renders as `List<Any>` / `return emptyList()`. */
  data object Unsupported : SearchParamPattern
}

/**
 * Classifies [expression] into a [SearchParamPattern] by trying each shape in priority order.
 *
 * Order: simple dotted path → element cast → element (no cast) → `.where(resolve() is …)` →
 * `.where(field='…')` (with optional post-path) → [SearchParamPattern.Unsupported].
 */
internal fun parseSearchParamExpression(
  expression: String,
  resourceName: String,
  resolver: FhirPathExpressionResolver,
): SearchParamPattern {
  val unwrapped = unwrapOuterParentheses(expression)

  resolver.resolve(unwrapped, resourceName)?.let {
    return SearchParamPattern.SimplePath(it)
  }

  parseElementCastExpression(unwrapped)?.let { (path, target) ->
    val resolved = resolver.resolve(path, resourceName, allowChoiceAtLeaf = true)
    val leaf = resolved?.segments?.lastOrNull()
    if (leaf?.isChoiceType == true) {
      val validTypes = leaf.choiceTypeCodes ?: emptyList()
      if (validTypes.any { it.equals(target, ignoreCase = true) }) {
        return SearchParamPattern.ElementCast(resolved, target)
      }
    }
  }

  resolver.resolve(unwrapped, resourceName, allowChoiceAtLeaf = true)?.let { resolved ->
    if (resolved.segments.lastOrNull()?.isChoiceType == true) {
      return SearchParamPattern.ElementNoCast(resolved)
    }
  }

  parseWhereExpression(unwrapped)?.let { whereResult ->
    when (whereResult) {
      is WhereParseResult.Resolve ->
        resolver.resolve(whereResult.pathBeforeWhere, resourceName)?.let {
          return SearchParamPattern.WhereResolve(it, whereResult.resolveTargetType)
        }
      is WhereParseResult.Filter -> {
        val resolved = resolver.resolve(whereResult.pathBeforeWhere, resourceName)
        val elementType = resolved?.segments?.lastOrNull()?.leafTypeCode
        if (resolved != null && elementType != null) {
          val postPath =
            if (whereResult.pathAfterWhere != null) {
              resolver.resolve("$elementType.${whereResult.pathAfterWhere}", elementType)
                ?: return@let
            } else null
          val fieldSegment =
            resolver
              .resolve("$elementType.${whereResult.filterField}", elementType)
              ?.segments
              ?.lastOrNull()
          return SearchParamPattern.WhereFilter(
            resolved,
            whereResult.filterField,
            whereResult.filterValue,
            postPath,
            isFieldNullable = fieldSegment?.isNullable ?: true,
          )
        }
      }
    }
  }

  return SearchParamPattern.Unsupported
}

/**
 * Strips matching outer enclosing parentheses from [expression].
 *
 * For example:
 * - `"(Observation.value as Quantity)"` → `"Observation.value as Quantity"`
 * - `"(((Patient.name)))"` → `"Patient.name"`
 *
 * Parentheses that do not enclose the entire expression (e.g. `"(a) | (b)"` or `"(a and b) or (c
 * and d)"`) and internal parentheses (e.g. `"Patient.telecom.where(system='email')"`) are left
 * intact.
 */
internal fun unwrapOuterParentheses(expression: String): String {
  val trimmedExpression = expression.trim()
  if (!trimmedExpression.startsWith('(') || !trimmedExpression.endsWith(')'))
    return trimmedExpression

  var depth = 0
  var outerLayers = 0
  var readingLeadingOpens = true

  for (index in trimmedExpression.indices) {
    when (trimmedExpression[index]) {
      '(' -> {
        depth++
        if (readingLeadingOpens) outerLayers++
      }
      ')' -> {
        depth--
        if (depth < 0) return trimmedExpression // Unbalanced
        if (index < trimmedExpression.length - 1 - depth) {
          outerLayers = minOf(outerLayers, depth)
        }
      }
      else -> readingLeadingOpens = false
    }
  }

  if (depth != 0) return trimmedExpression // Unbalanced

  return trimmedExpression.substring(outerLayers, trimmedExpression.length - outerLayers).trim()
}

private fun parseElementCastExpression(expression: String): Pair<String, String>? {
  val trimmed = unwrapOuterParentheses(expression)
  Regex("""(.+)\s+as\s+(\w+)""").matchEntire(trimmed)?.let {
    return it.groupValues[1].trim() to it.groupValues[2].trim()
  }
  Regex("""(.+)\.as\((\w+)\)""").matchEntire(trimmed)?.let {
    return it.groupValues[1].trim() to it.groupValues[2].trim()
  }
  Regex("""(.+)\.ofType\((\w+)\)""").matchEntire(trimmed)?.let {
    return it.groupValues[1].trim() to it.groupValues[2].trim()
  }
  return null
}

private sealed interface WhereParseResult {
  val pathBeforeWhere: String

  data class Resolve(
    override val pathBeforeWhere: String,
    val resolveTargetType: String,
  ) : WhereParseResult

  data class Filter(
    override val pathBeforeWhere: String,
    val filterField: String,
    val filterValue: String,
    val pathAfterWhere: String?,
  ) : WhereParseResult
}

private fun parseWhereExpression(expression: String): WhereParseResult? {
  val trimmed = unwrapOuterParentheses(expression)

  Regex("""(.+)\.where\(resolve\(\)\s+is\s+(\w+)\)""").matchEntire(trimmed)?.let {
    return WhereParseResult.Resolve(
      pathBeforeWhere = it.groupValues[1],
      resolveTargetType = it.groupValues[2],
    )
  }

  Regex("""(.+)\.where\((\w+)='([^']+)'\)(?:\.(.+))?""").matchEntire(trimmed)?.let {
    return WhereParseResult.Filter(
      pathBeforeWhere = it.groupValues[1],
      filterField = it.groupValues[2],
      filterValue = it.groupValues[3],
      pathAfterWhere = it.groupValues[4].ifEmpty { null },
    )
  }

  return null
}
