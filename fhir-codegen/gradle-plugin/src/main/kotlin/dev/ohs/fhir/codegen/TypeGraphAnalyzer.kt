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

package dev.ohs.fhir.codegen

import dev.ohs.fhir.codegen.schema.StructureDefinition
import dev.ohs.fhir.codegen.schema.capitalized

/**
 * Computes the FHIR type-dependency graph and classifies cross-type references as either **cyclic**
 * (the target's descriptor depends, transitively, on the source) or **acyclic**.
 *
 * For an acyclic edge `A → B`, emitting `B.serializer().descriptor` at A's descriptor-build time is
 * safe: B's own init won't try to re-enter A. That lets codegen emit plain, non-lazy, real
 * descriptors for ~95% of FHIR references, matching the bytecode shape of kotlinx-serialization
 * plugin-generated code.
 *
 * For a cyclic edge (e.g. `Reference ↔ Identifier`), we still need lazy/placeholder handling to
 * avoid recursive class-initialization deadlock.
 */
class TypeGraphAnalyzer(structureDefinitions: List<StructureDefinition>) {
  /** Map from simple class name ("Patient", "Meta", …) to the set of class names it references. */
  private val outgoing: Map<String, Set<String>>

  /** Per-type strongly-connected-component id. Edges within the same SCC are cyclic. */
  private val sccId: Map<String, Int>

  init {
    val deps = mutableMapOf<String, MutableSet<String>>()
    for (sd in structureDefinitions) {
      val sourceName = sd.name.capitalized()
      val refs = deps.getOrPut(sourceName) { mutableSetOf() }
      sd.snapshot?.element?.forEach { el ->
        el.type?.forEach { type ->
          val code = type.code
          // Skip stdlib + FHIRPath URI types (they're all primitives and don't cycle through FHIR).
          if (code.startsWith("http://")) return@forEach
          val target = code.capitalized()
          if (target == sourceName || target.isBlank()) {
            // Self-reference — keep it; we want this in the graph so SCC detection flags it.
          }
          refs.add(target)
        }
      }
    }
    outgoing = deps

    sccId = tarjanSCC(deps)
  }

  /**
   * True iff emitting `target.serializer().descriptor` at `source`'s descriptor-build time would
   * cause recursive initialization. Use a lazy wrapper (or placeholder) in that case.
   */
  fun isCyclicReference(source: String, target: String): Boolean {
    val s = sccId[source] ?: return false
    val t = sccId[target] ?: return false
    if (s == t) return true // same SCC
    // Self-loop is also cyclic even if size-1 SCC (SCC id equal, handled above).
    return false
  }

  /**
   * True iff [typeName] participates in any cycle at all (member of a non-trivial SCC or
   * self-loop).
   */
  @Suppress("unused")
  fun isCyclicType(typeName: String): Boolean {
    val id = sccId[typeName] ?: return false
    val size = sccId.values.count { it == id }
    if (size > 1) return true
    return outgoing[typeName]?.contains(typeName) == true
  }

  // --- Tarjan's SCC algorithm -------------------------------------------------------------------

  private fun tarjanSCC(graph: Map<String, Set<String>>): Map<String, Int> {
    val index = mutableMapOf<String, Int>()
    val lowlink = mutableMapOf<String, Int>()
    val onStack = mutableSetOf<String>()
    val stack = ArrayDeque<String>()
    val result = mutableMapOf<String, Int>()
    var nextIndex = 0
    var nextScc = 0

    fun strongconnect(v: String) {
      index[v] = nextIndex
      lowlink[v] = nextIndex
      nextIndex++
      stack.addLast(v)
      onStack.add(v)
      for (w in graph[v].orEmpty()) {
        if (w !in index) {
          strongconnect(w)
          lowlink[v] = minOf(lowlink[v]!!, lowlink[w]!!)
        } else if (w in onStack) {
          lowlink[v] = minOf(lowlink[v]!!, index[w]!!)
        }
      }
      if (lowlink[v] == index[v]) {
        val id = nextScc++
        while (true) {
          val w = stack.removeLast()
          onStack.remove(w)
          result[w] = id
          if (w == v) break
        }
      }
    }

    for (v in graph.keys) {
      if (v !in index) strongconnect(v)
    }
    return result
  }
}
