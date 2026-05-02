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

import com.google.fhir.model.r4b.serializers.CodingSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Coding Type: A reference to a code defined by a terminology system.
 */
@Serializable(with = CodingSerializer::class)
public data class Coding(
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
   * The identification of the code system that defines the meaning of the symbol in the code.
   *
   * The URI may be an OID (urn:oid:...) or a UUID (urn:uuid:...). OIDs and UUIDs SHALL be
   * references to the HL7 OID registry. Otherwise, the URI should come from HL7's list of FHIR
   * defined special URIs or it should reference to some definition that establishes the system
   * clearly and unambiguously.
   */
  public val system: Uri? = null,
  /**
   * The version of the code system which was used when choosing this code. Note that a
   * well-maintained code system does not need the version reported, because the meaning of codes is
   * consistent across versions. However this cannot consistently be assured, and when the meaning
   * is not guaranteed to be consistent, the version SHOULD be exchanged.
   *
   * Where the terminology does not clearly define what string should be used to identify code
   * system versions, the recommendation is to use the date (expressed in FHIR date format) on which
   * that version was officially published as the version date.
   */
  public val version: String? = null,
  /**
   * A symbol in syntax defined by the system. The symbol may be a predefined code or an expression
   * in a syntax defined by the coding system (e.g. post-coordination).
   */
  public val code: Code? = null,
  /**
   * A representation of the meaning of the code in the system, following the rules of the system.
   */
  public val display: String? = null,
  /**
   * Indicates that this coding was chosen by a user directly - e.g. off a pick list of available
   * items (codes or displays).
   *
   * Amongst a set of alternatives, a directly chosen code is the most appropriate starting point
   * for new translations. There is some ambiguity about what exactly 'directly chosen' implies, and
   * trading partner agreement may be needed to clarify the use of this element and its consequences
   * more completely.
   */
  public val userSelected: Boolean? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        system = this@with.system?.toBuilder()
        version = this@with.version?.toBuilder()
        code = this@with.code?.toBuilder()
        display = this@with.display?.toBuilder()
        userSelected = this@with.userSelected?.toBuilder()
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
     * The identification of the code system that defines the meaning of the symbol in the code.
     *
     * The URI may be an OID (urn:oid:...) or a UUID (urn:uuid:...). OIDs and UUIDs SHALL be
     * references to the HL7 OID registry. Otherwise, the URI should come from HL7's list of FHIR
     * defined special URIs or it should reference to some definition that establishes the system
     * clearly and unambiguously.
     */
    public open var system: Uri.Builder? = null

    /**
     * The version of the code system which was used when choosing this code. Note that a
     * well-maintained code system does not need the version reported, because the meaning of codes
     * is consistent across versions. However this cannot consistently be assured, and when the
     * meaning is not guaranteed to be consistent, the version SHOULD be exchanged.
     *
     * Where the terminology does not clearly define what string should be used to identify code
     * system versions, the recommendation is to use the date (expressed in FHIR date format) on
     * which that version was officially published as the version date.
     */
    public open var version: String.Builder? = null

    /**
     * A symbol in syntax defined by the system. The symbol may be a predefined code or an
     * expression in a syntax defined by the coding system (e.g. post-coordination).
     */
    public open var code: Code.Builder? = null

    /**
     * A representation of the meaning of the code in the system, following the rules of the system.
     */
    public open var display: String.Builder? = null

    /**
     * Indicates that this coding was chosen by a user directly - e.g. off a pick list of available
     * items (codes or displays).
     *
     * Amongst a set of alternatives, a directly chosen code is the most appropriate starting point
     * for new translations. There is some ambiguity about what exactly 'directly chosen' implies,
     * and trading partner agreement may be needed to clarify the use of this element and its
     * consequences more completely.
     */
    public open var userSelected: Boolean.Builder? = null

    public open fun build(): Coding =
      Coding(
        id = id,
        extension = extension.map { it.build() },
        system = system?.build(),
        version = version?.build(),
        code = code?.build(),
        display = display?.build(),
        userSelected = userSelected?.build(),
      )
  }
}
