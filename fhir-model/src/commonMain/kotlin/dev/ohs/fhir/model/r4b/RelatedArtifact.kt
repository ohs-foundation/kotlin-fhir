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

import com.google.fhir.model.r4.serializers.RelatedArtifactSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for RelatedArtifact Type: Related artifacts such as additional
 * documentation, justification, or bibliographic references.
 */
@Serializable(with = RelatedArtifactSerializer::class)
public data class RelatedArtifact(
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
  /** The type of relationship to the related artifact. */
  public val type: Enumeration<RelatedArtifactType>,
  /**
   * A short label that can be used to reference the citation from elsewhere in the containing
   * artifact, such as a footnote index.
   */
  public val label: String? = null,
  /**
   * A brief description of the document or knowledge resource being referenced, suitable for
   * display to a consumer.
   */
  public val display: String? = null,
  /**
   * A bibliographic citation for the related artifact. This text SHOULD be formatted according to
   * an accepted citation format.
   *
   * Additional structured information about citations should be captured as extensions.
   */
  public val citation: Markdown? = null,
  /**
   * A url for the artifact that can be followed to access the actual content.
   *
   * If a document or resource element is present, this element SHALL NOT be provided (use the url
   * or reference in the Attachment or resource reference).
   */
  public val url: Url? = null,
  /**
   * The document being referenced, represented as an attachment. This is exclusive with the
   * resource element.
   */
  public val document: Attachment? = null,
  /**
   * The related resource, such as a library, value set, profile, or other knowledge resource.
   *
   * If the type is predecessor, this is a reference to the succeeding knowledge resource. If the
   * type is successor, this is a reference to the prior knowledge resource.
   */
  public val resource: Canonical? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(type).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        label = this@with.label?.toBuilder()
        display = this@with.display?.toBuilder()
        citation = this@with.citation?.toBuilder()
        url = this@with.url?.toBuilder()
        document = this@with.document?.toBuilder()
        resource = this@with.resource?.toBuilder()
      }
    }

  public open class Builder(
    /** The type of relationship to the related artifact. */
    public open var type: Enumeration<RelatedArtifactType>
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
     * A short label that can be used to reference the citation from elsewhere in the containing
     * artifact, such as a footnote index.
     */
    public open var label: String.Builder? = null

    /**
     * A brief description of the document or knowledge resource being referenced, suitable for
     * display to a consumer.
     */
    public open var display: String.Builder? = null

    /**
     * A bibliographic citation for the related artifact. This text SHOULD be formatted according to
     * an accepted citation format.
     *
     * Additional structured information about citations should be captured as extensions.
     */
    public open var citation: Markdown.Builder? = null

    /**
     * A url for the artifact that can be followed to access the actual content.
     *
     * If a document or resource element is present, this element SHALL NOT be provided (use the url
     * or reference in the Attachment or resource reference).
     */
    public open var url: Url.Builder? = null

    /**
     * The document being referenced, represented as an attachment. This is exclusive with the
     * resource element.
     */
    public open var document: Attachment.Builder? = null

    /**
     * The related resource, such as a library, value set, profile, or other knowledge resource.
     *
     * If the type is predecessor, this is a reference to the succeeding knowledge resource. If the
     * type is successor, this is a reference to the prior knowledge resource.
     */
    public open var resource: Canonical.Builder? = null

    public open fun build(): RelatedArtifact =
      RelatedArtifact(
        id = id,
        extension = extension.map { it.build() },
        type = type,
        label = label?.build(),
        display = display?.build(),
        citation = citation?.build(),
        url = url?.build(),
        document = document?.build(),
        resource = resource?.build(),
      )
  }

  /** The type of relationship to the related artifact. */
  public enum class RelatedArtifactType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Documentation("documentation", "http://hl7.org/fhir/related-artifact-type", "Documentation"),
    Justification("justification", "http://hl7.org/fhir/related-artifact-type", "Justification"),
    Citation("citation", "http://hl7.org/fhir/related-artifact-type", "Citation"),
    Predecessor("predecessor", "http://hl7.org/fhir/related-artifact-type", "Predecessor"),
    Successor("successor", "http://hl7.org/fhir/related-artifact-type", "Successor"),
    Derived_From("derived-from", "http://hl7.org/fhir/related-artifact-type", "Derived From"),
    Depends_On("depends-on", "http://hl7.org/fhir/related-artifact-type", "Depends On"),
    Composed_Of("composed-of", "http://hl7.org/fhir/related-artifact-type", "Composed Of");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RelatedArtifactType =
        when (code) {
          "documentation" -> Documentation
          "justification" -> Justification
          "citation" -> Citation
          "predecessor" -> Predecessor
          "successor" -> Successor
          "derived-from" -> Derived_From
          "depends-on" -> Depends_On
          "composed-of" -> Composed_Of
          else -> throw IllegalArgumentException("Unknown code $code for enum RelatedArtifactType")
        }
    }
  }
}
