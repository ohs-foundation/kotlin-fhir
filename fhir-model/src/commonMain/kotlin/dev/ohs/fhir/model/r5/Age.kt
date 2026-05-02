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

import com.google.fhir.model.r5.serializers.AgeSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** Age Type: A duration of time during which an organism (or a process) has existed. */
@Serializable(with = AgeSerializer::class)
public data class Age(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
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
   * The value of the measured amount. The value includes an implicit precision in the presentation
   * of the value.
   *
   * The implicit precision in the value should always be honored. Monetary values have their own
   * rules for handling precision (refer to standard accounting text books).
   */
  override val `value`: Decimal? = null,
  /**
   * How the value should be understood and represented - whether the actual value is greater or
   * less than the stated value due to measurement issues; e.g. if the comparator is "<" , then the
   * real value is < stated value.
   */
  override val comparator: Enumeration<Quantity.QuantityComparator>? = null,
  /** A human-readable form of the unit. */
  override val unit: String? = null,
  /** The identification of the system that provides the coded form of the unit. */
  override val system: Uri? = null,
  /**
   * A computer processable form of the unit in some unit representation system.
   *
   * The preferred system is UCUM, but SNOMED CT can also be used (for customary units) or ISO 4217
   * for currency. The context of use may additionally require a code from a particular system.
   */
  override val code: Code? = null,
) : Quantity() {
  open override fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        `value` = this@with.`value`?.toBuilder()
        comparator = this@with.comparator
        unit = this@with.unit?.toBuilder()
        system = this@with.system?.toBuilder()
        code = this@with.code?.toBuilder()
      }
    }

  public open class Builder() : Quantity.Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    open override var id: kotlin.String? = null

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
    open override var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * The value of the measured amount. The value includes an implicit precision in the
     * presentation of the value.
     *
     * The implicit precision in the value should always be honored. Monetary values have their own
     * rules for handling precision (refer to standard accounting text books).
     */
    open override var `value`: Decimal.Builder? = null

    /**
     * How the value should be understood and represented - whether the actual value is greater or
     * less than the stated value due to measurement issues; e.g. if the comparator is "<" , then
     * the real value is < stated value.
     */
    open override var comparator: Enumeration<Quantity.QuantityComparator>? = null

    /** A human-readable form of the unit. */
    open override var unit: String.Builder? = null

    /** The identification of the system that provides the coded form of the unit. */
    open override var system: Uri.Builder? = null

    /**
     * A computer processable form of the unit in some unit representation system.
     *
     * The preferred system is UCUM, but SNOMED CT can also be used (for customary units) or ISO
     * 4217 for currency. The context of use may additionally require a code from a particular
     * system.
     */
    open override var code: Code.Builder? = null

    open override fun build(): Age =
      Age(
        id = id,
        extension = extension.map { it.build() },
        `value` = `value`?.build(),
        comparator = comparator,
        unit = unit?.build(),
        system = system?.build(),
        code = code?.build(),
      )
  }

  /** How the Quantity should be understood and represented. */
  public enum class QuantityComparator(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    LessThan("<", "http://hl7.org/fhir/quantity-comparator", "Less than"),
    LessThanOrEqualTo("<=", "http://hl7.org/fhir/quantity-comparator", "Less or Equal to"),
    GreaterThanOrEqualTo(">=", "http://hl7.org/fhir/quantity-comparator", "Greater or Equal to"),
    GreaterThan(">", "http://hl7.org/fhir/quantity-comparator", "Greater than"),
    Ad(
      "ad",
      "http://hl7.org/fhir/quantity-comparator",
      "Sufficient to achieve this total quantity",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): QuantityComparator =
        when (code) {
          "<" -> LessThan
          "<=" -> LessThanOrEqualTo
          ">=" -> GreaterThanOrEqualTo
          ">" -> GreaterThan
          "ad" -> Ad
          else -> throw IllegalArgumentException("Unknown code $code for enum QuantityComparator")
        }
    }
  }
}
