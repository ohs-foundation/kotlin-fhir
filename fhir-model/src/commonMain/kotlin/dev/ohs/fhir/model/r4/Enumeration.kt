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

package com.google.fhir.model.r4b

import kotlin.Enum
import kotlin.String
import kotlin.collections.List

/**
 * A FHIR Enumeration type bound to a specific set of codes. It represents a constrained code value
 * from an enumerated list.
 *
 * @param id unique id for the element within a resource (for internal references)
 * @param extension May be used to represent additional information that is not part of the basic
 *   definition of the resource. To make the use of extensions safe and manageable, there is a
 *   strict set of governance applied to the definition and use of extensions.
 * @param value The actual value
 */
public data class Enumeration<T : Enum<*>>(
  /** unique id for the element within a resource (for internal references) */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions.
   */
  override val extension: List<Extension> = listOf(),
  /** The actual value */
  public val `value`: T? = null,
) : Element(id, extension) {
  public fun toElement(): Element? {
    if (id != null || extension.isNotEmpty()) {
      return Element(id, extension)
    }
    return null
  }

  public companion object {
    public fun <T : Enum<*>> of(`value`: T, element: Element?): Enumeration<T> =
      Enumeration(element?.id, element?.extension ?: listOf(), value = value)
  }
}
