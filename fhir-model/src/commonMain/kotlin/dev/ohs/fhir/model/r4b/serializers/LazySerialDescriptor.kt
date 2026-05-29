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

package dev.ohs.fhir.model.r4b.serializers

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SealedSerializationApi
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.SerialKind

/**
 * [SerialDescriptor] that forwards all operations to a lazily-resolved delegate. Used to break
 * construction-time cycles between serializers whose descriptors reference one another (e.g.
 * `Reference` ↔ `Identifier`).
 */
@OptIn(ExperimentalSerializationApi::class, SealedSerializationApi::class)
internal class LazySerialDescriptor(provider: () -> SerialDescriptor) : SerialDescriptor {
  private val delegate by lazy(LazyThreadSafetyMode.NONE, provider)
  override val serialName: String
    get() = delegate.serialName

  override val kind: SerialKind
    get() = delegate.kind

  override val elementsCount: Int
    get() = delegate.elementsCount

  override val isInline: Boolean
    get() = delegate.isInline

  override val isNullable: Boolean
    get() = delegate.isNullable

  override val annotations: List<Annotation>
    get() = delegate.annotations

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

/** Convenience factory. */
@OptIn(ExperimentalSerializationApi::class, SealedSerializationApi::class)
internal fun lazyDescriptor(provider: () -> SerialDescriptor): SerialDescriptor =
  LazySerialDescriptor(provider)
