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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.ContributorSerializer
import dev.ohs.fhir.model.r4.terminologies.ContributorType
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Contributor Type: A contributor to the content of a knowledge asset,
 * including authors, editors, reviewers, and endorsers.
 */
@Serializable(with = ContributorSerializer::class)
public data class Contributor(
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
  /** The type of contributor. */
  public val type: Enumeration<ContributorType>,
  /** The name of the individual or organization responsible for the contribution. */
  public val name: String,
  /** Contact details to assist a user in finding and communicating with the contributor. */
  public val contact: List<ContactDetail> = listOf(),
) : Element(), FhirBuildable {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        type,
        name.toBuilder(),
      )
    builder.id = id
    builder.extension = extension.toBuilderList()
    builder.contact = contact.toBuilderList()
    return builder
  }

  public open class Builder(
    /** The type of contributor. */
    public open var type: Enumeration<ContributorType>,
    /** The name of the individual or organization responsible for the contribution. */
    public open var name: String.Builder,
  ) : FhirBuilder {
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

    /** Contact details to assist a user in finding and communicating with the contributor. */
    public open var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    open override fun build(): Contributor =
      Contributor(
        id = id,
        extension = extension.buildList(),
        type = type,
        name = name.build(),
        contact = contact.buildList(),
      )
  }
}
