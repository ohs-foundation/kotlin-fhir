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

import com.squareup.kotlinpoet.ClassName
import java.io.File

/**
 * Writes `LazySerialDescriptor.kt`: a [kotlinx.serialization.descriptors.SerialDescriptor] that
 * resolves its delegate on first use, plus the `LazyDescriptorId` constants and the
 * `resolveLazyDescriptor(id)` dispatch over every serializer referenced lazily by the generated
 * code ([CodegenContext.lazyDescriptorTargets]).
 *
 * Generated serializers call `lazyDescriptor(LazyDescriptorId.XSerializer)` instead of
 * `lazyDescriptor { XSerializer.descriptor }`: the int-keyed dispatch avoids one `invokedynamic`
 * site, bootstrap-method entry and synthetic lambda method per cyclic reference, and still never
 * touches `XSerializer` during the referencing serializer's class initialization.
 */
object LazySerialDescriptorFileSpecGenerator {
  fun writeTo(outputDir: File, serializersPackageName: String, targets: Collection<ClassName>) {
    val packagePath = serializersPackageName.replace('.', '/')
    val target = File(outputDir, "$packagePath/LazySerialDescriptor.kt")
    target.parentFile.mkdirs()
    val sortedTargets = targets.sortedBy { it.canonicalName }
    val imports =
      sortedTargets
        .filter { it.packageName != serializersPackageName }
        .map { "import ${it.canonicalName}" }
        .sorted()
        .joinToString("\n")
    val ids =
      sortedTargets.withIndex().joinToString("\n") { (index, cls) ->
        "  const val ${cls.simpleName}: Int = $index"
      }
    val cases =
      sortedTargets.withIndex().joinToString("\n") { (index, cls) ->
        "    $index -> ${cls.simpleName}.descriptor"
      }
    target.writeText(
      """
@file:Suppress("RedundantVisibilityModifier")

package $serializersPackageName

$imports
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SealedSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind

@OptIn(ExperimentalSerializationApi::class, SealedSerializationApi::class)
internal class LazySerialDescriptor(id: Int) : SerialDescriptor {
  // Uses PUBLICATION for lock-free thread safety, avoiding race conditions (unlike NONE)
  // and mutex locks/deadlocks during cyclic resolution (unlike SYNCHRONIZED).
  private val delegate by lazy(LazyThreadSafetyMode.PUBLICATION) { resolveLazyDescriptor(id) }
  override val serialName: String get() = delegate.serialName
  override val kind: SerialKind get() = delegate.kind
  override val elementsCount: Int get() = delegate.elementsCount
  override val isInline: Boolean get() = delegate.isInline
  override val isNullable: Boolean get() = delegate.isNullable
  override val annotations: List<Annotation> get() = delegate.annotations
  override fun getElementName(index: Int): String = delegate.getElementName(index)
  override fun getElementIndex(name: String): Int = delegate.getElementIndex(name)
  override fun getElementAnnotations(index: Int): List<Annotation> =
    delegate.getElementAnnotations(index)
  override fun getElementDescriptor(index: Int): SerialDescriptor =
    delegate.getElementDescriptor(index)
  override fun isElementOptional(index: Int): Boolean = delegate.isElementOptional(index)
  override fun equals(other: Any?): Boolean = delegate == other
  override fun hashCode(): Int = delegate.hashCode()
  override fun toString(): String = delegate.toString()
}

/** Descriptor for the serializer identified by [id] (a `LazyDescriptorId`), resolved on first use. */
internal fun lazyDescriptor(id: Int): SerialDescriptor = LazySerialDescriptor(id)

/** Ids of serializers whose descriptors are referenced lazily to break descriptor cycles. */
internal object LazyDescriptorId {
$ids
}

internal fun resolveLazyDescriptor(id: Int): SerialDescriptor =
  when (id) {
$cases
    else -> throw IllegalArgumentException("Unknown lazy descriptor id " + id)
  }
"""
        .trimStart()
    )
  }
}
