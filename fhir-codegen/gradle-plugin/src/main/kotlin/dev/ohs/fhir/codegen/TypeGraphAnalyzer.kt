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
  /** Per-type strongly-connected-component id. Edges within the same SCC are cyclic. */
  private val sccId: Map<String, Int>

  init {
    val deps = mutableMapOf<String, MutableSet<String>>()
    for (structureDefinition in structureDefinitions) {
      val sourceName = structureDefinition.name.capitalized()
      val refs = deps.getOrPut(sourceName) { mutableSetOf() }
      structureDefinition.snapshot?.element?.forEach { element ->
        element.type?.forEach { type ->
          val code = type.code
          // Skip stdlib + FHIRPath URI types (they're all primitives and don't cycle through FHIR).
          if (code.startsWith("http://")) return@forEach
          val target = code.capitalized()
          if (target.isBlank()) return@forEach
          // Self-references are kept so SCC detection flags them.
          refs.add(target)
        }
      }
    }
    sccId = findStronglyConnectedComponents(deps)
  }

  /**
   * True iff emitting `target.serializer().descriptor` at `source`'s descriptor-build time would
   * cause recursive initialization. Use a lazy wrapper (or placeholder) in that case.
   */
  fun isCyclicReference(source: String, target: String): Boolean {
    val sourceScc = sccId[source] ?: return false
    val targetScc = sccId[target] ?: return false
    return sourceScc == targetScc
  }

  /**
   * [Tarjan's strongly-connected-components
   * algorithm](https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm).
   * Returns a map from each vertex to its SCC id; two vertices share an SCC id iff each is
   * reachable from the other.
   */
  private fun findStronglyConnectedComponents(graph: Map<String, Set<String>>): Map<String, Int> {
    val index = mutableMapOf<String, Int>()
    val onStack = mutableSetOf<String>()
    val stack = ArrayDeque<String>()
    val result = mutableMapOf<String, Int>()
    var nextIndex = 0
    var nextScc = 0

    fun strongconnect(vertex: String): Int {
      val vertexIndex = nextIndex++
      var lowLink = vertexIndex
      index[vertex] = vertexIndex
      stack.addLast(vertex)
      onStack.add(vertex)
      for (neighbor in graph[vertex].orEmpty()) {
        val neighborIndex = index[neighbor]
        if (neighborIndex == null) {
          lowLink = minOf(lowLink, strongconnect(neighbor))
        } else if (neighbor in onStack) {
          lowLink = minOf(lowLink, neighborIndex)
        }
      }
      if (lowLink == vertexIndex) {
        while (true) {
          val popped = stack.removeLast()
          onStack.remove(popped)
          result[popped] = nextScc
          if (popped == vertex) break
        }
        nextScc++
      }
      return lowLink
    }

    for (vertex in graph.keys) {
      if (vertex !in index) strongconnect(vertex)
    }
    return result
  }
}
