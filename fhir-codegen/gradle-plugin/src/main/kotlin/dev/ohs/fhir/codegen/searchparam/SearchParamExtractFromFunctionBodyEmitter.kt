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
import com.squareup.kotlinpoet.CodeBlock
import dev.ohs.fhir.codegen.ResolvedExpression
import dev.ohs.fhir.codegen.ResolvedSegment

/**
 * Builds the body of a generated `extract(resource): List<T>` for a resolved FHIRPath.
 *
 * It walks the path one segment at a time, tracking whether the value so far is a single value
 * ([PathExpr.Single]) or a list ([PathExpr.Listed]), and finally coerces it to a `List<T>` with
 * [asList]. Identifiers, types, and strings are emitted via KotlinPoet's `%N` / `%T` / `%S`, so
 * keyword escaping (e.g. a FHIR `class` field) is handled automatically.
 *
 * Each method returns a bare expression; the caller wraps it in the extractor lambda.
 */
internal object SearchParamExtractFromFunctionBodyEmitter {

  /** A simple dotted path (`Patient.address.city`), or a `where(resolve() is …)` base. */
  fun forSegments(resolved: ResolvedExpression): CodeBlock = walkToList(resolved.segments)

  /** An element cast `(X.path as Type)` / `X.path.as(Type)` → `(… as? <subclass>)?.value`. */
  fun forElementCast(resolved: ResolvedExpression, sealedSubclass: ClassName): CodeBlock {
    val segments = resolved.segments
    if (segments.isEmpty()) return EMPTY_LIST
    val leaf = segments.last().propertyName
    return when (val parent = walk(segments.dropLast(1))) {
      is PathExpr.Single ->
        if (parent.nullable)
          CodeBlock.of("listOfNotNull((%L?.%N as? %T)?.value)", parent.code, leaf, sealedSubclass)
        else CodeBlock.of("listOfNotNull((%L.%N as? %T)?.value)", parent.code, leaf, sealedSubclass)
      is PathExpr.Listed ->
        CodeBlock.of(
          "%L.mapNotNull { (it.%N as? %T)?.value }",
          parent.memberBase,
          leaf,
          sealedSubclass,
        )
    }
  }

  /** A `path.where(field='value')` filter with an optional post-`where` access path. */
  fun forWhereFilter(
    resolved: ResolvedExpression,
    field: String,
    value: String,
    postPath: ResolvedExpression?,
  ): CodeBlock {
    val filtered =
      CodeBlock.of(
        "%L.filter { it.%N?.value?.toString() == %S }",
        filterBase(resolved.segments),
        field,
        value,
      )
    var state: PathExpr = PathExpr.Listed(filtered)
    postPath?.segments?.forEach { state = step(state, it) }
    return asList(state)
  }

  /**
   * A `path.where(resolve() is Type)` filter. Approximates the runtime `resolve()` by
   * substring-matching `Reference.reference` against `Type/`, which covers relative (`Type/id`) and
   * absolute (`http://…/Type/id`) URL forms. Misses URN-form (`urn:uuid:…`) and contained (`#id`)
   * references, and references that populate only `Reference.type`.
   */
  fun forWhereResolve(resolved: ResolvedExpression, targetType: String): CodeBlock =
    CodeBlock.of(
      "%L.filter { it.reference?.value?.toString()?.contains(%S) == true }",
      filterBase(resolved.segments),
      "$targetType/",
    )

  // -- state machine ----------------------------------------------------------------------------

  private val EMPTY_LIST = CodeBlock.of("emptyList()")

  private sealed interface PathExpr {
    val code: CodeBlock

    /** A single value; [nullable] tracks whether the chain so far can be null. */
    data class Single(override val code: CodeBlock, val nullable: Boolean) : PathExpr

    /**
     * A `List<T>` value. [parenthesize] is true when [code] is a low-precedence expression (`… ?:
     * emptyList()`) that must be wrapped in parens before a `.member` access is appended.
     */
    data class Listed(override val code: CodeBlock, val parenthesize: Boolean = false) : PathExpr {
      /** [code] in a form safe to append `.member` to. */
      val memberBase: CodeBlock
        get() = if (parenthesize) CodeBlock.of("(%L)", code) else code
    }
  }

  /** A `List<T>` for use as a *terminal* expression (no `.member` appended) — see [asList]. */
  private fun walkToList(segments: List<ResolvedSegment>): CodeBlock =
    if (segments.isEmpty()) EMPTY_LIST else asList(walk(segments))

  /**
   * A `List<T>` that a `.filter { … }` (or other `.member`) will be appended to, so it must be safe
   * at member-access precedence. Differs from [walkToList] only for the `… ?: emptyList()` shape,
   * which [asList] leaves bare but here must be parenthesized.
   */
  private fun filterBase(segments: List<ResolvedSegment>): CodeBlock =
    if (segments.isEmpty()) EMPTY_LIST
    else
      when (val state = walk(segments)) {
        is PathExpr.Single -> asList(state) // listOf(..) / listOfNotNull(..) — safe to append to
        is PathExpr.Listed -> state.memberBase
      }

  /** Folds [step] over [segments] starting from the non-null `resource` root. */
  private fun walk(segments: List<ResolvedSegment>): PathExpr {
    var state: PathExpr = PathExpr.Single(CodeBlock.of("resource"), nullable = false)
    for (segment in segments) state = step(state, segment)
    return state
  }

  /** Appends one property access to [state], returning the new shape. */
  private fun step(state: PathExpr, segment: ResolvedSegment): PathExpr {
    val prop = segment.propertyName
    return when (state) {
      is PathExpr.Single -> {
        val access =
          if (state.nullable) CodeBlock.of("%L?.%N", state.code, prop)
          else CodeBlock.of("%L.%N", state.code, prop)
        when {
          segment.isList && state.nullable ->
            PathExpr.Listed(CodeBlock.of("%L ?: emptyList()", access), parenthesize = true)
          segment.isList -> PathExpr.Listed(access)
          else -> PathExpr.Single(access, nullable = state.nullable || segment.isNullable)
        }
      }
      is PathExpr.Listed -> {
        val base = state.memberBase
        when {
          segment.isList -> PathExpr.Listed(CodeBlock.of("%L.flatMap { it.%N }", base, prop))
          segment.isNullable -> PathExpr.Listed(CodeBlock.of("%L.mapNotNull { it.%N }", base, prop))
          else -> PathExpr.Listed(CodeBlock.of("%L.map { it.%N }", base, prop))
        }
      }
    }
  }

  /** Coerces a walked [state] into a `List<T>` expression. */
  private fun asList(state: PathExpr): CodeBlock =
    when (state) {
      is PathExpr.Single ->
        if (state.nullable) CodeBlock.of("listOfNotNull(%L)", state.code)
        else CodeBlock.of("listOf(%L)", state.code)
      is PathExpr.Listed -> state.code
    }
}
