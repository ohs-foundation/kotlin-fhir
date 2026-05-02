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

import com.google.fhir.model.r4.serializers.UsageContextSerializer
import com.google.fhir.model.r4.serializers.UsageContextValueSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for UsageContext Type: Specifies clinical/business/etc. metadata that
 * can be used to retrieve, index and/or categorize an artifact. This metadata can either be
 * specific to the applicable population (e.g., age category, DRG) or the specific context of care
 * (e.g., venue, care setting, provider of care).
 */
@Serializable(with = UsageContextSerializer::class)
public data class UsageContext(
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
  /** A code that identifies the type of context being specified by this usage context. */
  public val code: Coding,
  /**
   * A value that defines the context specified in this context of use. The interpretation of the
   * value is defined by the code.
   */
  public val `value`: Value,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(code.toBuilder(), `value`).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
      }
    }

  @Serializable(with = UsageContextValueSerializer::class)
  public sealed interface Value {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asQuantity(): Quantity? = this as? Quantity

    public fun asRange(): Range? = this as? Range

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4.CodeableConcept
    ) : Value

    public data class Quantity(public val `value`: com.google.fhir.model.r4.Quantity) : Value

    public data class Range(public val `value`: com.google.fhir.model.r4.Range) : Value

    public data class Reference(public val `value`: com.google.fhir.model.r4.Reference) : Value

    public companion object {
      internal fun from(
        codeableConceptValue: com.google.fhir.model.r4.CodeableConcept?,
        quantityValue: com.google.fhir.model.r4.Quantity?,
        rangeValue: com.google.fhir.model.r4.Range?,
        referenceValue: com.google.fhir.model.r4.Reference?,
      ): Value? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (quantityValue != null) return Quantity(quantityValue)
        if (rangeValue != null) return Range(rangeValue)
        if (referenceValue != null) return Reference(referenceValue)
        return null
      }
    }
  }

  public open class Builder(
    /** A code that identifies the type of context being specified by this usage context. */
    public open var code: Coding.Builder,
    /**
     * A value that defines the context specified in this context of use. The interpretation of the
     * value is defined by the code.
     */
    public open var `value`: Value,
  ) {
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

    public open fun build(): UsageContext =
      UsageContext(
        id = id,
        extension = extension.map { it.build() },
        code = code.build(),
        `value` = `value`,
      )
  }
}
