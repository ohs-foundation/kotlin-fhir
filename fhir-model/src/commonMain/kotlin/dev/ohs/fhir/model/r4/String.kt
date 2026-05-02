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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package com.google.fhir.model.r4b

import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList

/** Base StructureDefinition for string Type: A sequence of Unicode characters */
public open class String(
  /** unique id for the element within a resource (for internal references) */
  open override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions. Though any implementer can define
   * an extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  open override val extension: List<Extension> = listOf(),
  /** The actual value */
  public open val `value`: kotlin.String? = null,
) : Element(id, extension) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is String) return false
    if (id != other.id) return false
    if (extension != other.extension) return false
    if (value != other.value) return false
    return true
  }

  override fun hashCode(): Int {
    // Using 31 improves hash distribution and reduces collisions in hash-based collections
    var result = id?.hashCode() ?: 0
    result = 31 * result + (extension?.hashCode() ?: 0)
    result = 31 * result + (value?.hashCode() ?: 0)
    return result
  }

  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        `value` = this@with.`value`
      }
    }

  public open fun toElement(): Element? {
    if (id != null || extension.isNotEmpty()) {
      return Element(id, extension)
    }
    return null
  }

  public open class Builder() {
    /** unique id for the element within a resource (for internal references) */
    public open var id: kotlin.String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and manageable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    /** The actual value */
    public open var `value`: kotlin.String? = null

    public open fun build(): String =
      String(id = id, extension = extension.map { it.build() }, `value` = `value`)
  }

  public companion object {
    public fun of(`value`: kotlin.String?, element: Element?): String? =
      if (value != null || element?.id != null || element?.extension?.isEmpty() == false) {
        String(element?.id, element?.extension ?: mutableListOf(), value)
      } else {
        null
      }
  }
}
