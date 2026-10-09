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

@file:Suppress("RedundantVisibilityModifier")

package dev.ohs.fhir.model.r4b

import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList

public interface FhirBuilder {
  public fun build(): Any
}

public interface FhirBuildable {
  public fun toBuilder(): FhirBuilder
}

@Suppress("UNCHECKED_CAST")
internal fun <T : Any> List<FhirBuilder>.buildList(): List<T> {
  if (isEmpty()) return emptyList()
  val destination = ArrayList<T>(size)
  for (item in this) destination.add(item.build() as T)
  return destination
}

@Suppress("UNCHECKED_CAST")
internal fun <B : FhirBuilder> List<FhirBuildable>.toBuilderList(): MutableList<B> {
  val destination = ArrayList<B>(size)
  for (item in this) destination.add(item.toBuilder() as B)
  return destination
}
