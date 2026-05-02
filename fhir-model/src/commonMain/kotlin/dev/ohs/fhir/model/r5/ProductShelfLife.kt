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

import com.google.fhir.model.r5.serializers.ProductShelfLifePeriodSerializer
import com.google.fhir.model.r5.serializers.ProductShelfLifeSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * ProductShelfLife Type: The shelf-life and storage information for a medicinal product item or
 * container can be described using this class.
 */
@Serializable(with = ProductShelfLifeSerializer::class)
public data class ProductShelfLife(
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
   * May be used to represent additional information that is not part of the basic definition of the
   * element and that modifies the understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and managable, there is a strict
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
   * This describes the shelf life, taking into account various scenarios such as shelf life of the
   * packaged Medicinal Product itself, shelf life after transformation where necessary and shelf
   * life after the first opening of a bottle, etc. The shelf life type shall be specified using an
   * appropriate controlled vocabulary The controlled term and the controlled term identifier shall
   * be specified.
   */
  public val type: CodeableConcept? = null,
  /**
   * The shelf life time period can be specified using a numerical value for the period of time and
   * its unit of time measurement The unit of measurement shall be specified in accordance with ISO
   * 11240 and the resulting terminology The symbol and the symbol identifier shall be used.
   */
  public val period: Period? = null,
  /**
   * Special precautions for storage, if any, can be specified using an appropriate controlled
   * vocabulary The controlled term and the controlled term identifier shall be specified.
   */
  public val specialPrecautionsForStorage: List<CodeableConcept> = listOf(),
) : BackboneType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        type = this@with.type?.toBuilder()
        period = this@with.period
        specialPrecautionsForStorage =
          this@with.specialPrecautionsForStorage.map { it.toBuilder() }.toMutableList()
      }
    }

  @Serializable(with = ProductShelfLifePeriodSerializer::class)
  public sealed interface Period {
    public fun asDuration(): Duration? = this as? Duration

    public fun asString(): String? = this as? String

    public data class Duration(public val `value`: com.google.fhir.model.r5.Duration) : Period

    public data class String(public val `value`: com.google.fhir.model.r5.String) : Period

    public companion object {
      internal fun from(
        durationValue: com.google.fhir.model.r5.Duration?,
        stringValue: com.google.fhir.model.r5.String?,
      ): Period? {
        if (durationValue != null) return Duration(durationValue)
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
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and managable, there is
     * a strict set of governance applied to the definition and use of extensions. Though any
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
     * This describes the shelf life, taking into account various scenarios such as shelf life of
     * the packaged Medicinal Product itself, shelf life after transformation where necessary and
     * shelf life after the first opening of a bottle, etc. The shelf life type shall be specified
     * using an appropriate controlled vocabulary The controlled term and the controlled term
     * identifier shall be specified.
     */
    public open var type: CodeableConcept.Builder? = null

    /**
     * The shelf life time period can be specified using a numerical value for the period of time
     * and its unit of time measurement The unit of measurement shall be specified in accordance
     * with ISO 11240 and the resulting terminology The symbol and the symbol identifier shall be
     * used.
     */
    public open var period: Period? = null

    /**
     * Special precautions for storage, if any, can be specified using an appropriate controlled
     * vocabulary The controlled term and the controlled term identifier shall be specified.
     */
    public open var specialPrecautionsForStorage: MutableList<CodeableConcept.Builder> =
      mutableListOf()

    public open fun build(): ProductShelfLife =
      ProductShelfLife(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        type = type?.build(),
        period = period,
        specialPrecautionsForStorage = specialPrecautionsForStorage.map { it.build() },
      )
  }
}
