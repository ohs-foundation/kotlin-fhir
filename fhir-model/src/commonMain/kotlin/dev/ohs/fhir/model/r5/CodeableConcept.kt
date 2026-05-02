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

import com.google.fhir.model.r5.serializers.CodeableConceptSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * CodeableConcept Type: A concept that may be defined by a formal reference to a terminology or
 * ontology or may be provided by text.
 */
@Serializable(with = CodeableConceptSerializer::class)
public data class CodeableConcept(
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
   * A reference to a code defined by a terminology system.
   *
   * Codes may be defined very casually in enumerations, or code lists, up to very formal
   * definitions such as SNOMED CT - see the HL7 v3 Core Principles for more information. Ordering
   * of codings is undefined and SHALL NOT be used to infer meaning. Generally, at most only one of
   * the coding values will be labeled as UserSelected = true.
   */
  public val coding: List<Coding> = listOf(),
  /**
   * A human language representation of the concept as seen/selected/uttered by the user who entered
   * the data and/or which represents the intended meaning of the user.
   *
   * Very often the text is the same as a displayName of one of the codings.
   */
  public val text: String? = null,
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        coding = this@with.coding.map { it.toBuilder() }.toMutableList()
        text = this@with.text?.toBuilder()
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
     * A reference to a code defined by a terminology system.
     *
     * Codes may be defined very casually in enumerations, or code lists, up to very formal
     * definitions such as SNOMED CT - see the HL7 v3 Core Principles for more information. Ordering
     * of codings is undefined and SHALL NOT be used to infer meaning. Generally, at most only one
     * of the coding values will be labeled as UserSelected = true.
     */
    public open var coding: MutableList<Coding.Builder> = mutableListOf()

    /**
     * A human language representation of the concept as seen/selected/uttered by the user who
     * entered the data and/or which represents the intended meaning of the user.
     *
     * Very often the text is the same as a displayName of one of the codings.
     */
    public open var text: String.Builder? = null

    public open fun build(): CodeableConcept =
      CodeableConcept(
        id = id,
        extension = extension.map { it.build() },
        coding = coding.map { it.build() },
        text = text?.build(),
      )
  }
}
