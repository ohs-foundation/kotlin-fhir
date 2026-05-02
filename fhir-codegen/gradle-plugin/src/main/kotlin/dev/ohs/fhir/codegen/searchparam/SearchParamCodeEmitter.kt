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

package com.google.fhir.codegen.searchparam

import com.google.fhir.codegen.ResolvedExpression
import com.google.fhir.codegen.ResolvedSegment

/**
 * Emits the Kotlin source string for a search parameter's `extract()` body.
 *
 * One method per [SearchParamPattern] code shape. The accumulator state machine that walks resolved
 * segments and produces `listOf` / `listOfNotNull` / `map` / `mapNotNull` / `flatMap` chains is
 * private to this file.
 */
internal object SearchParamCodeEmitter {

  /** Body for a simple dotted path or a `where(resolve() is …)` (the filter is dropped). */
  fun forSegments(resolved: ResolvedExpression): String {
    val segments = resolved.segments
    if (segments.isEmpty()) return "return emptyList()"

    var state: AccumulatorState = AccumulatorState.ScalarNonNull("resource")
    for ((index, segment) in segments.withIndex()) {
      val prop = segment.propertyName.escapeIfKeyword()
      if (index == segments.lastIndex) return terminateExtraction(state, segment, prop)
      state = advanceState(state, segment, prop)
    }
    return "return emptyList()"
  }

  /** Body for an element cast like `(Resource.path as Type)` or `Resource.path.as(Type)`. */
  fun forElementCast(resolved: ResolvedExpression, sealedSubclassExpr: String): String {
    val segments = resolved.segments
    if (segments.isEmpty()) return "return emptyList()"

    var state: AccumulatorState = AccumulatorState.ScalarNonNull("resource")
    for ((index, segment) in segments.withIndex()) {
      val prop = segment.propertyName.escapeIfKeyword()
      if (index == segments.lastIndex) {
        return when (state) {
          is AccumulatorState.ScalarNonNull ->
            "return listOfNotNull((${state.expr}.$prop as? $sealedSubclassExpr)?.value)"
          is AccumulatorState.NullableScalar ->
            "return listOfNotNull((${state.expr}?.$prop as? $sealedSubclassExpr)?.value)"
          is AccumulatorState.ListAcc ->
            "return ${state.expr}.mapNotNull { (it.$prop as? $sealedSubclassExpr)?.value }"
        }
      }
      state = advanceState(state, segment, prop)
    }
    return "return emptyList()"
  }

  /**
   * Body for `path.where(field='value')` with optional post-`where` access path. The filter
   * predicate is built from [field] and [value] and emitted as `it.<field>?.value?.toString() ==
   * "<value>"`.
   */
  fun forWhereFilter(
    resolved: ResolvedExpression,
    field: String,
    value: String,
    postPath: ResolvedExpression?,
  ): String {
    val baseCode = buildAccessChainToList(resolved)
    val filterCode = "it.${field.escapeIfKeyword()}?.value?.toString() == \"$value\""
    val filtered = "$baseCode.filter { $filterCode }"

    if (postPath == null) return "return $filtered"

    val postSegments = postPath.segments
    if (postSegments.isEmpty()) return "return $filtered"

    var result = filtered
    for (segment in postSegments) {
      val prop = segment.propertyName.escapeIfKeyword()
      result =
        when {
          segment.isList -> "$result.flatMap { it.$prop }"
          segment.isNullable -> "$result.mapNotNull { it.$prop }"
          else -> "$result.map { it.$prop }"
        }
    }
    return "return $result"
  }

  /**
   * Body for `path.where(resolve() is Type)`. Approximates the runtime `resolve()` check by
   * substring-matching `Reference.reference` against `Type/`, which matches relative (`Type/id`)
   * and absolute (`http://…/Type/id`) URL forms. Misses URN-form (`urn:uuid:…`) and contained
   * (`#id`) references, and references that populate only `Reference.type`.
   */
  fun forWhereResolve(resolved: ResolvedExpression, targetType: String): String {
    val baseCode = buildAccessChainToList(resolved)
    return "return $baseCode.filter { it.reference?.value?.toString()?.contains(\"$targetType/\") == true }"
  }
}

private sealed interface AccumulatorState {
  data class ScalarNonNull(val expr: String) : AccumulatorState

  data class NullableScalar(val expr: String) : AccumulatorState

  data class ListAcc(val expr: String) : AccumulatorState
}

private fun advanceState(
  state: AccumulatorState,
  segment: ResolvedSegment,
  prop: String,
): AccumulatorState =
  when (state) {
    is AccumulatorState.ScalarNonNull -> {
      val accessor = "${state.expr}.$prop"
      when {
        segment.isList -> AccumulatorState.ListAcc(accessor)
        segment.isNullable -> AccumulatorState.NullableScalar(accessor)
        else -> AccumulatorState.ScalarNonNull(accessor)
      }
    }
    is AccumulatorState.NullableScalar ->
      when {
        segment.isList -> AccumulatorState.ListAcc("(${state.expr}?.$prop ?: emptyList())")
        else -> AccumulatorState.NullableScalar("${state.expr}?.$prop")
      }
    is AccumulatorState.ListAcc ->
      when {
        segment.isList -> AccumulatorState.ListAcc("${state.expr}.flatMap { it.$prop }")
        segment.isNullable -> AccumulatorState.ListAcc("${state.expr}.mapNotNull { it.$prop }")
        else -> AccumulatorState.ListAcc("${state.expr}.map { it.$prop }")
      }
  }

private fun terminateExtraction(
  state: AccumulatorState,
  segment: ResolvedSegment,
  prop: String,
): String =
  when (state) {
    is AccumulatorState.ScalarNonNull -> {
      val accessor = "${state.expr}.$prop"
      when {
        segment.isList -> "return $accessor"
        segment.isNullable -> "return listOfNotNull($accessor)"
        else -> "return listOf($accessor)"
      }
    }
    is AccumulatorState.NullableScalar ->
      when {
        segment.isList -> "return ${state.expr}?.$prop ?: emptyList()"
        else -> "return listOfNotNull(${state.expr}?.$prop)"
      }
    is AccumulatorState.ListAcc ->
      when {
        segment.isList -> "return ${state.expr}.flatMap { it.$prop }"
        segment.isNullable -> "return ${state.expr}.mapNotNull { it.$prop }"
        else -> "return ${state.expr}.map { it.$prop }"
      }
  }

private fun buildAccessChainToList(resolved: ResolvedExpression): String {
  val segments = resolved.segments
  if (segments.isEmpty()) return "emptyList()"

  var state: AccumulatorState = AccumulatorState.ScalarNonNull("resource")
  for (segment in segments) {
    val prop = segment.propertyName.escapeIfKeyword()
    state = advanceState(state, segment, prop)
  }
  return when (state) {
    is AccumulatorState.ListAcc -> state.expr
    is AccumulatorState.ScalarNonNull -> "listOf(${state.expr})"
    is AccumulatorState.NullableScalar -> "listOfNotNull(${state.expr})"
  }
}

/** Kotlin hard keywords that must be backtick-escaped when used as identifiers. */
private val KOTLIN_HARD_KEYWORDS =
  setOf(
    "as",
    "break",
    "class",
    "continue",
    "do",
    "else",
    "false",
    "for",
    "fun",
    "if",
    "in",
    "interface",
    "is",
    "null",
    "object",
    "package",
    "return",
    "super",
    "this",
    "throw",
    "true",
    "try",
    "typealias",
    "typeof",
    "val",
    "var",
    "when",
    "while",
  )

private fun String.escapeIfKeyword(): String = if (this in KOTLIN_HARD_KEYWORDS) "`$this`" else this
