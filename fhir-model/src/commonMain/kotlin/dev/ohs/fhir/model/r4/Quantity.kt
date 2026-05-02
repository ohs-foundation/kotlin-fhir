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

import com.google.fhir.model.r4b.serializers.QuantitySerializer
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Quantity Type: A measured amount (or an amount that can potentially
 * be measured). Note that measured amounts include amounts that are not precisely quantified,
 * including amounts involving arbitrary units and floating currencies.
 */
@Serializable(with = QuantitySerializer::class)
public open class Quantity(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  open override val id: kotlin.String? = null,
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
  open override val extension: List<Extension> = listOf(),
  /**
   * The value of the measured amount. The value includes an implicit precision in the presentation
   * of the value.
   *
   * The implicit precision in the value should always be honored. Monetary values have their own
   * rules for handling precision (refer to standard accounting text books).
   */
  public open val `value`: Decimal? = null,
  /**
   * How the value should be understood and represented - whether the actual value is greater or
   * less than the stated value due to measurement issues; e.g. if the comparator is "<" , then the
   * real value is < stated value.
   */
  public open val comparator: Enumeration<QuantityComparator>? = null,
  /** A human-readable form of the unit. */
  public open val unit: String? = null,
  /** The identification of the system that provides the coded form of the unit. */
  public open val system: Uri? = null,
  /**
   * A computer processable form of the unit in some unit representation system.
   *
   * The preferred system is UCUM, but SNOMED CT can also be used (for customary units) or ISO 4217
   * for currency. The context of use may additionally require a code from a particular system.
   */
  public open val code: Code? = null,
) : Element() {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is Quantity) return false
    if (id != other.id) return false
    if (extension != other.extension) return false
    if (value != other.value) return false
    if (comparator != other.comparator) return false
    if (unit != other.unit) return false
    if (system != other.system) return false
    if (code != other.code) return false
    return true
  }

  override fun hashCode(): Int {
    // Using 31 improves hash distribution and reduces collisions in hash-based collections
    var result = id?.hashCode() ?: 0
    result = 31 * result + (extension?.hashCode() ?: 0)
    result = 31 * result + (value?.hashCode() ?: 0)
    result = 31 * result + (comparator?.hashCode() ?: 0)
    result = 31 * result + (unit?.hashCode() ?: 0)
    result = 31 * result + (system?.hashCode() ?: 0)
    result = 31 * result + (code?.hashCode() ?: 0)
    return result
  }

  public open fun toBuilder(): Builder =
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

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

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
     * The value of the measured amount. The value includes an implicit precision in the
     * presentation of the value.
     *
     * The implicit precision in the value should always be honored. Monetary values have their own
     * rules for handling precision (refer to standard accounting text books).
     */
    public open var `value`: Decimal.Builder? = null

    /**
     * How the value should be understood and represented - whether the actual value is greater or
     * less than the stated value due to measurement issues; e.g. if the comparator is "<" , then
     * the real value is < stated value.
     */
    public open var comparator: Enumeration<QuantityComparator>? = null

    /** A human-readable form of the unit. */
    public open var unit: String.Builder? = null

    /** The identification of the system that provides the coded form of the unit. */
    public open var system: Uri.Builder? = null

    /**
     * A computer processable form of the unit in some unit representation system.
     *
     * The preferred system is UCUM, but SNOMED CT can also be used (for customary units) or ISO
     * 4217 for currency. The context of use may additionally require a code from a particular
     * system.
     */
    public open var code: Code.Builder? = null

    public open fun build(): Quantity =
      Quantity(
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
    GreaterThan(">", "http://hl7.org/fhir/quantity-comparator", "Greater than");

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
          else -> throw IllegalArgumentException("Unknown code $code for enum QuantityComparator")
        }
    }
  }
}
