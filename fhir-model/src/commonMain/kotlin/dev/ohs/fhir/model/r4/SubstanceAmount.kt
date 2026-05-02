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

package com.google.fhir.model.r4

import com.google.fhir.model.r4.serializers.SubstanceAmountAmountSerializer
import com.google.fhir.model.r4.serializers.SubstanceAmountReferenceRangeSerializer
import com.google.fhir.model.r4.serializers.SubstanceAmountSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for SubstanceAmount Type: Chemical substances are a single substance
 * type whose primary defining element is the molecular structure. Chemical substances shall be
 * defined on the basis of their complete covalent molecular structure; the presence of a salt
 * (counter-ion) and/or solvates (water, alcohols) is also captured. Purity, grade, physical form or
 * particle size are not taken into account in the definition of a chemical substance or in the
 * assignment of a Substance ID.
 */
@Serializable(with = SubstanceAmountSerializer::class)
public data class SubstanceAmount(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
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
   * May be used to represent additional information that is not part of the basic definition of the
   * element and that modifies the understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met as part of the definition
   * of the extension. Applications processing a resource are required to check for modifier
   * extensions.
   *
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource
   * (including cannot change the meaning of modifierExtension itself).
   *
   * There can be no stigma associated with the use of extensions by any application, project, or
   * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
   * The use of extensions is what allows the FHIR specification to retain a core level of
   * simplicity for everyone.
   */
  override val modifierExtension: List<Extension> = listOf(),
  /**
   * Used to capture quantitative values for a variety of elements. If only limits are given, the
   * arithmetic mean would be the average. If only a single definite value for a given element is
   * given, it would be captured in this field.
   */
  public val amount: Amount? = null,
  /**
   * Most elements that require a quantitative value will also have a field called amount type.
   * Amount type should always be specified because the actual value of the amount is often
   * dependent on it. EXAMPLE: In capturing the actual relative amounts of substances or molecular
   * fragments it is essential to indicate whether the amount refers to a mole ratio or weight
   * ratio. For any given element an effort should be made to use same the amount type for all
   * related definitional elements.
   */
  public val amountType: CodeableConcept? = null,
  /** A textual comment on a numeric value. */
  public val amountText: String? = null,
  /** Reference range of possible or expected values. */
  public val referenceRange: ReferenceRange? = null,
) : BackboneElement() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        amount = this@with.amount
        amountType = this@with.amountType?.toBuilder()
        amountText = this@with.amountText?.toBuilder()
        referenceRange = this@with.referenceRange?.toBuilder()
      }
    }

  /** Reference range of possible or expected values. */
  @Serializable(with = SubstanceAmountReferenceRangeSerializer::class)
  public data class ReferenceRange(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /** Lower limit possible or expected. */
    public val lowLimit: Quantity? = null,
    /** Upper limit possible or expected. */
    public val highLimit: Quantity? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          lowLimit = this@with.lowLimit?.toBuilder()
          highLimit = this@with.highLimit?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
       * governance applied to the definition and use of extensions. Though any implementer can
       * define an extension, there is a set of requirements that SHALL be met as part of the
       * definition of the extension.
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var extension: MutableList<Extension.Builder> = mutableListOf()

      /** Lower limit possible or expected. */
      public var lowLimit: Quantity.Builder? = null

      /** Upper limit possible or expected. */
      public var highLimit: Quantity.Builder? = null

      public fun build(): ReferenceRange =
        ReferenceRange(
          id = id,
          extension = extension.map { it.build() },
          lowLimit = lowLimit?.build(),
          highLimit = highLimit?.build(),
        )
    }
  }

  @Serializable(with = SubstanceAmountAmountSerializer::class)
  public sealed interface Amount {
    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Amount

    public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Amount

    public data class String(public val `value`: com.google.fhir.model.r4.String) : Amount

    public companion object {
      internal fun from(
        quantityValue: com.google.fhir.model.r4.Quantity?,
        rangeValue: com.google.fhir.model.r4.Range?,
        stringValue: com.google.fhir.model.r4.String?,
      ): Amount? {
        if (quantityValue != null) return Quantity(quantityValue)
        if (rangeValue != null) return Range(rangeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
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
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
     * implementer can define an extension, there is a set of requirements that SHALL be met as part
     * of the definition of the extension. Applications processing a resource are required to check
     * for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public open var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * Used to capture quantitative values for a variety of elements. If only limits are given, the
     * arithmetic mean would be the average. If only a single definite value for a given element is
     * given, it would be captured in this field.
     */
    public open var amount: Amount? = null

    /**
     * Most elements that require a quantitative value will also have a field called amount type.
     * Amount type should always be specified because the actual value of the amount is often
     * dependent on it. EXAMPLE: In capturing the actual relative amounts of substances or molecular
     * fragments it is essential to indicate whether the amount refers to a mole ratio or weight
     * ratio. For any given element an effort should be made to use same the amount type for all
     * related definitional elements.
     */
    public open var amountType: CodeableConcept.Builder? = null

    /** A textual comment on a numeric value. */
    public open var amountText: String.Builder? = null

    /** Reference range of possible or expected values. */
    public open var referenceRange: ReferenceRange.Builder? = null

    public open fun build(): SubstanceAmount =
      SubstanceAmount(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        amount = amount,
        amountType = amountType?.build(),
        amountText = amountText?.build(),
        referenceRange = referenceRange?.build(),
      )
  }
}
