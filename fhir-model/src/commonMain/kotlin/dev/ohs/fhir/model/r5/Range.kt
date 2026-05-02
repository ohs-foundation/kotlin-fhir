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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.serializers.RangeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** Range Type: A set of ordered Quantities defined by a low and high limit. */
@Serializable(with = RangeSerializer::class)
public data class Range(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and managable, there is a strict set of governance
   * applied to the definition and use of extensions. Though any implementer can define an
   * extension, there is a set of requirements that SHALL be met as part of the definition of the
   * extension.
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val extension: List<Extension> = listOf(),
  /**
   * The low limit. The boundary is inclusive.
   *
   * If the low element is missing, the low boundary is not known.
   */
  public val low: Quantity? = null,
  /**
   * The high limit. The boundary is inclusive.
   *
   * If the high element is missing, the high boundary is not known.
   */
  public val high: Quantity? = null,
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        low = this@with.low?.toBuilder()
        high = this@with.high?.toBuilder()
      }
    }

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element. To make the use of extensions safe and managable, there is a strict set of
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

    /**
     * The low limit. The boundary is inclusive.
     *
     * If the low element is missing, the low boundary is not known.
     */
    public open var low: Quantity.Builder? = null

    /**
     * The high limit. The boundary is inclusive.
     *
     * If the high element is missing, the high boundary is not known.
     */
    public open var high: Quantity.Builder? = null

    public open fun build(): Range =
      Range(
        id = id,
        extension = extension.map { it.build() },
        low = low?.build(),
        high = high?.build(),
      )
  }
}
