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

import com.google.fhir.model.r4.serializers.ParameterDefinitionSerializer
import com.google.fhir.model.r4.terminologies.FHIRAllTypes
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for ParameterDefinition Type: The parameters to the module. This
 * collection specifies both the input and output parameters. Input parameters are provided by the
 * caller as part of the $evaluate operation. Output parameters are included in the
 * GuidanceResponse.
 */
@Serializable(with = ParameterDefinitionSerializer::class)
public data class ParameterDefinition(
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
   * The name of the parameter used to allow access to the value of the parameter in evaluation
   * contexts.
   */
  public val name: Code? = null,
  /** Whether the parameter is input or output for the module. */
  public val use: Enumeration<OperationParameterUse>,
  /** The minimum number of times this parameter SHALL appear in the request or response. */
  public val min: Integer? = null,
  /** The maximum number of times this element is permitted to appear in the request or response. */
  public val max: String? = null,
  /** A brief discussion of what the parameter is for and how it is used by the module. */
  public val documentation: String? = null,
  /** The type of the parameter. */
  public val type: Enumeration<FHIRAllTypes>,
  /**
   * If specified, this indicates a profile that the input data must conform to, or that the output
   * data will conform to.
   */
  public val profile: Canonical? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(use, type).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        min = this@with.min?.toBuilder()
        max = this@with.max?.toBuilder()
        documentation = this@with.documentation?.toBuilder()
        profile = this@with.profile?.toBuilder()
      }
    }

  public open class Builder(
    /** Whether the parameter is input or output for the module. */
    public open var use: Enumeration<OperationParameterUse>,
    /** The type of the parameter. */
    public open var type: Enumeration<FHIRAllTypes>,
  ) {
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
     * The name of the parameter used to allow access to the value of the parameter in evaluation
     * contexts.
     */
    public open var name: Code.Builder? = null

    /** The minimum number of times this parameter SHALL appear in the request or response. */
    public open var min: Integer.Builder? = null

    /**
     * The maximum number of times this element is permitted to appear in the request or response.
     */
    public open var max: String.Builder? = null

    /** A brief discussion of what the parameter is for and how it is used by the module. */
    public open var documentation: String.Builder? = null

    /**
     * If specified, this indicates a profile that the input data must conform to, or that the
     * output data will conform to.
     */
    public open var profile: Canonical.Builder? = null

    public open fun build(): ParameterDefinition =
      ParameterDefinition(
        id = id,
        extension = extension.map { it.build() },
        name = name?.build(),
        use = use,
        min = min?.build(),
        max = max?.build(),
        documentation = documentation?.build(),
        type = type,
        profile = profile?.build(),
      )
  }

  /** Whether an operation parameter is an input or an output parameter. */
  public enum class OperationParameterUse(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    In("in", "http://hl7.org/fhir/operation-parameter-use", "In"),
    Out("out", "http://hl7.org/fhir/operation-parameter-use", "Out");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): OperationParameterUse =
        when (code) {
          "in" -> In
          "out" -> Out
          else ->
            throw IllegalArgumentException("Unknown code $code for enum OperationParameterUse")
        }
    }
  }
}
