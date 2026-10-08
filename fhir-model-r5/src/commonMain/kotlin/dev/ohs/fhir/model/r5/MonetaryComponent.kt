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

@file:Suppress(
  "RedundantVisibilityModifier",
  "PropertyName",
)

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.MonetaryComponentSerializer
import dev.ohs.fhir.model.r5.terminologies.PriceComponentType
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** MonetaryComponent Type: Availability data for an {item}. */
@Serializable(with = MonetaryComponentSerializer::class)
public data class MonetaryComponent(
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
  /** base | surcharge | deduction | discount | tax | informational. */
  public val type: Enumeration<PriceComponentType>,
  /** Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc. */
  public val code: CodeableConcept? = null,
  /** Factor used for calculating this component. */
  public val factor: Decimal? = null,
  /** Explicit value amount to be used. */
  public val amount: Money? = null,
) : DataType() {
  public fun toBuilder(): Builder {
    val builder = Builder(type)
    builder.id = id
    builder.extension = extension.mapToMutableList { it.toBuilder() }
    builder.code = code?.toBuilder()
    builder.factor = factor?.toBuilder()
    builder.amount = amount?.toBuilder()
    return builder
  }

  public open class Builder(
    /** base | surcharge | deduction | discount | tax | informational. */
    public open var type: Enumeration<PriceComponentType>
  ) {
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

    /** Codes may be used to differentiate between kinds of taxes, surcharges, discounts etc. */
    public open var code: CodeableConcept.Builder? = null

    /** Factor used for calculating this component. */
    public open var factor: Decimal.Builder? = null

    /** Explicit value amount to be used. */
    public open var amount: Money.Builder? = null

    public open fun build(): MonetaryComponent =
      MonetaryComponent(
        id = id,
        extension = extension.mapToList { it.build() },
        type = type,
        code = code?.build(),
        factor = factor?.build(),
        amount = amount?.build(),
      )
  }
}
