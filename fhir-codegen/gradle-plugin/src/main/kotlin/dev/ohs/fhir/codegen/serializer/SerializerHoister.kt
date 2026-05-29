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

package dev.ohs.fhir.codegen.serializer

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asClassName
import kotlinx.serialization.KSerializer

/**
 * Collects non-trivial serializer expressions (List, Nullable, etc.) used by the encode/decode
 * functions and emits them as `private val` singletons on the serializer object. Avoids
 * re-allocating `ListSerializer(...)` / `NullableSerializer(...)` on every decode call.
 */
internal class SerializerHoister {
  private data class Entry(
    val name: String,
    val expression: CodeBlock,
    val resultType: TypeName,
    /**
     * If true, emit this entry on a nested `private object Hoisted { ... }` instead of directly on
     * the outer serializer object. Nested objects initialize via JVM class-init on first property
     * access (not with the enclosing object), so expressions that eagerly dereference a
     * still-initializing sibling's `descriptor` (e.g. `ListSerializer(Extension.serializer())` from
     * inside `ExtensionSerializer`'s own init — `ArrayListSerializer`'s constructor reads
     * `element.descriptor`, which is null during our own init) are deferred until encode/decode
     * starts. No `Lazy` monitor — just a `getstatic` after the one-time init.
     */
    val deferred: Boolean,
  )

  private val byKey = linkedMapOf<String, Entry>()

  /**
   * Return a [CodeBlock] referencing a private val whose value is [expression]. [resultType] is the
   * T in `KSerializer<T>` — used so the emitted val has a concrete type, letting the compiler infer
   * types at call sites without `UNCHECKED_CAST`.
   */
  fun ref(expression: CodeBlock, preferredName: String, resultType: TypeName): CodeBlock =
    refInternal(expression, preferredName, resultType, deferred = false)

  /**
   * Variant of [ref] that places the val on a nested `Hoisted` object so its expression runs lazily
   * (first access). Use for wrappers that would trigger a class-init cycle if evaluated during the
   * outer serializer's own init.
   */
  fun refLazy(expression: CodeBlock, preferredName: String, resultType: TypeName): CodeBlock =
    refInternal(expression, preferredName, resultType, deferred = true)

  private fun refInternal(
    expression: CodeBlock,
    preferredName: String,
    resultType: TypeName,
    deferred: Boolean,
  ): CodeBlock {
    val key = expression.toString() + if (deferred) "@deferred" else ""
    val entry =
      byKey.getOrPut(key) {
        val base = sanitizeName(preferredName)
        var candidate = base
        var suffix = 2
        val existingNames = byKey.values.map { it.name }.toSet()
        while (candidate in existingNames) {
          candidate = "$base$suffix"
          suffix++
        }
        Entry(candidate, expression, resultType, deferred)
      }
    return if (deferred) CodeBlock.of("Hoisted.%N", entry.name) else CodeBlock.of("%N", entry.name)
  }

  private fun sanitizeName(name: String): String {
    val cleaned = name.replace(Regex("[^A-Za-z0-9]"), "")
    return cleaned.ifEmpty { "ser" }
  }

  /** Eager hoisted props — placed directly on the outer serializer object. */
  fun eagerPropertyDefinitions(): List<PropertySpec> {
    val kserializer = KSerializer::class.asClassName()
    return byKey.values
      .filterNot { it.deferred }
      .map { (name, expr, resultType, _) ->
        PropertySpec.builder(name, kserializer.parameterizedBy(resultType))
          .addModifiers(KModifier.PRIVATE)
          .initializer(expr)
          .build()
      }
  }

  /**
   * Nested `private object Hoisted { ... }` holding deferred entries. Returns null if no deferred
   * entries are hoisted (keep the outer object tidy).
   */
  fun deferredObjectTypeSpec(): TypeSpec? {
    val deferred = byKey.values.filter { it.deferred }
    if (deferred.isEmpty()) return null
    val kserializer = KSerializer::class.asClassName()
    val builder = TypeSpec.objectBuilder("Hoisted").addModifiers(KModifier.PRIVATE)
    for ((name, expr, resultType, _) in deferred) {
      builder.addProperty(
        PropertySpec.builder(name, kserializer.parameterizedBy(resultType))
          .initializer(expr)
          .build()
      )
    }
    return builder.build()
  }
}
