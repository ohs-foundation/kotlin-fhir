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

package dev.ohs.fhir.model.r4

import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList

internal fun <T, R> List<T>.mapToMutableList(transform: (T) -> R): MutableList<R> {
  val destination = ArrayList<R>(size)
  for (item in this) destination.add(transform(item))
  return destination
}

internal fun <T, R> List<T>.mapToList(transform: (T) -> R): List<R> =
  if (isEmpty()) emptyList() else mapToMutableList(transform)
