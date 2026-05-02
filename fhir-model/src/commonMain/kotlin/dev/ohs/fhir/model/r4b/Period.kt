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

import com.google.fhir.model.r4b.serializers.PeriodSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Period Type: A time period defined by a start and end date and
 * optionally time.
 */
@Serializable(with = PeriodSerializer::class)
public data class Period(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
   * The start of the period. The boundary is inclusive.
   *
   * If the low element is missing, the meaning is that the low boundary is not known.
   */
  public val start: DateTime? = null,
  /**
   * The end of the period. If the end of the period is missing, it means no end was known or
   * planned at the time the instance was created. The start may be in the past, and the end date in
   * the future, which means that period is expected/planned to end at that time.
   *
   * The high value includes any matching date/time. i.e. 2012-02-03T10:00:00 is in a period that
   * has an end value of 2012-02-03.
   */
  public val end: DateTime? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        start = this@with.start?.toBuilder()
        end = this@with.end?.toBuilder()
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
     * the element. To make the use of extensions safe and manageable, there is a strict set of
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
     * The start of the period. The boundary is inclusive.
     *
     * If the low element is missing, the meaning is that the low boundary is not known.
     */
    public open var start: DateTime.Builder? = null

    /**
     * The end of the period. If the end of the period is missing, it means no end was known or
     * planned at the time the instance was created. The start may be in the past, and the end date
     * in the future, which means that period is expected/planned to end at that time.
     *
     * The high value includes any matching date/time. i.e. 2012-02-03T10:00:00 is in a period that
     * has an end value of 2012-02-03.
     */
    public open var end: DateTime.Builder? = null

    public open fun build(): Period =
      Period(
        id = id,
        extension = extension.map { it.build() },
        start = start?.build(),
        end = end?.build(),
      )
  }
}
