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

import dev.ohs.fhir.model.r4.serializers.NarrativeSerializer
import dev.ohs.fhir.model.r4.terminologies.NarrativeStatus
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Narrative Type: A human-readable summary of the resource conveying
 * the essential clinical and business information for the resource.
 */
@Serializable(with = NarrativeSerializer::class)
public data class Narrative(
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
  /**
   * The status of the narrative - whether it's entirely generated (from just the defined data or
   * the extensions too), or whether a human authored it and it may contain additional data.
   */
  public val status: Enumeration<NarrativeStatus>,
  /**
   * The actual narrative content, a stripped down version of XHTML.
   *
   * The contents of the html element are an XHTML fragment containing only the basic html
   * formatting elements described in chapters 7-11 and 15 of the HTML 4.0 standard, <a> elements
   * (either name or href), images and internally contained stylesheets. The XHTML content SHALL NOT
   * contain a head, a body, external stylesheet references, scripts, forms, base/link/xlink,
   * frames, iframes and objects.
   */
  public val div: Xhtml,
) : Element(), FhirBuildable {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        div.toBuilder(),
      )
    builder.id = id
    builder.extension = extension.toBuilderList()
    return builder
  }

  public open class Builder(
    /**
     * The status of the narrative - whether it's entirely generated (from just the defined data or
     * the extensions too), or whether a human authored it and it may contain additional data.
     */
    public open var status: Enumeration<NarrativeStatus>,
    /**
     * The actual narrative content, a stripped down version of XHTML.
     *
     * The contents of the html element are an XHTML fragment containing only the basic html
     * formatting elements described in chapters 7-11 and 15 of the HTML 4.0 standard, <a> elements
     * (either name or href), images and internally contained stylesheets. The XHTML content SHALL
     * NOT contain a head, a body, external stylesheet references, scripts, forms, base/link/xlink,
     * frames, iframes and objects.
     */
    public open var div: Xhtml.Builder,
  ) : FhirBuilder {
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

    open override fun build(): Narrative =
      Narrative(
        id = id,
        extension = extension.buildList(),
        status = status,
        div = div.build(),
      )
  }
}
