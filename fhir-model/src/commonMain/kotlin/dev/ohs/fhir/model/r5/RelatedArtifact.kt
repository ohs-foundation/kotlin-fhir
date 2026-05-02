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

import com.google.fhir.model.r5.serializers.RelatedArtifactSerializer
import com.google.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * RelatedArtifact Type: Related artifacts such as additional documentation, justification, or
 * bibliographic references.
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
   * The type of relationship to the related artifact.
   *
   * The presence of both sides of a relationship type (e.g. successor and predecessor) is required
   * to support use cases where one side of a relationship is not represented in FHIR. However, this
   * feature SHALL NOT be used to create bi-directional resource links in FHIR instances.
   * Specifically, following the methodology of "new points to old" and "many points to one", when
   * using related artifact elements to describe and reference FHIR resources, the type element
   * SHALL be drawn from the fhir-related-artifact-type ValueSet.
   */
  public val type: Enumeration<RelatedArtifactType>,
  /** Provides additional classifiers of the related artifact. */
  public val classifier: List<CodeableConcept> = listOf(),
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
   * The document being referenced, represented as an attachment. This is exclusive with the
   * resource element.
   */
  public val document: Attachment? = null,
  /**
   * The related artifact, such as a library, value set, profile, or other knowledge resource.
   *
   * If the type is predecessor, this is a reference to the succeeding knowledge resource. If the
   * type is successor, this is a reference to the prior knowledge resource.
   */
  public val resource: Canonical? = null,
  /**
   * The related artifact, if the artifact is not a canonical resource, or a resource reference to a
   * canonical resource.
   *
   * If both resource and resourceReference are present, they SHOULD be consistent and reference the
   * same resource. Although relatedArtifact is intended to support references to definitional
   * resources, there are cases where non-definitional resources can be definitional (such as
   * Location where the kind is mode). Related artifacts SHOULD be used to reference definitional
   * resources, and profiles SHOULD be used to make that explicit for particular use cases.
   */
  public val resourceReference: Reference? = null,
  /** The publication status of the artifact being referred to. */
  public val publicationStatus: Enumeration<PublicationStatus>? = null,
  /** The date of publication of the artifact being referred to. */
  public val publicationDate: Date? = null,
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(type).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
        label = this@with.label?.toBuilder()
        display = this@with.display?.toBuilder()
        citation = this@with.citation?.toBuilder()
        document = this@with.document?.toBuilder()
        resource = this@with.resource?.toBuilder()
        resourceReference = this@with.resourceReference?.toBuilder()
        publicationStatus = this@with.publicationStatus
        publicationDate = this@with.publicationDate?.toBuilder()
      }
    }

  public open class Builder(
    /**
     * The type of relationship to the related artifact.
     *
     * The presence of both sides of a relationship type (e.g. successor and predecessor) is
     * required to support use cases where one side of a relationship is not represented in FHIR.
     * However, this feature SHALL NOT be used to create bi-directional resource links in FHIR
     * instances. Specifically, following the methodology of "new points to old" and "many points to
     * one", when using related artifact elements to describe and reference FHIR resources, the type
     * element SHALL be drawn from the fhir-related-artifact-type ValueSet.
     */
    public open var type: Enumeration<RelatedArtifactType>
  ) {
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

    /** Provides additional classifiers of the related artifact. */
    public open var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

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
     * The document being referenced, represented as an attachment. This is exclusive with the
     * resource element.
     */
    public open var document: Attachment.Builder? = null

    /**
     * The related artifact, such as a library, value set, profile, or other knowledge resource.
     *
     * If the type is predecessor, this is a reference to the succeeding knowledge resource. If the
     * type is successor, this is a reference to the prior knowledge resource.
     */
    public open var resource: Canonical.Builder? = null

    /**
     * The related artifact, if the artifact is not a canonical resource, or a resource reference to
     * a canonical resource.
     *
     * If both resource and resourceReference are present, they SHOULD be consistent and reference
     * the same resource. Although relatedArtifact is intended to support references to definitional
     * resources, there are cases where non-definitional resources can be definitional (such as
     * Location where the kind is mode). Related artifacts SHOULD be used to reference definitional
     * resources, and profiles SHOULD be used to make that explicit for particular use cases.
     */
    public open var resourceReference: Reference.Builder? = null

    /** The publication status of the artifact being referred to. */
    public open var publicationStatus: Enumeration<PublicationStatus>? = null

    /** The date of publication of the artifact being referred to. */
    public open var publicationDate: Date.Builder? = null

    public open fun build(): RelatedArtifact =
      RelatedArtifact(
        id = id,
        extension = extension.map { it.build() },
        type = type,
        classifier = classifier.map { it.build() },
        label = label?.build(),
        display = display?.build(),
        citation = citation?.build(),
        document = document?.build(),
        resource = resource?.build(),
        resourceReference = resourceReference?.build(),
        publicationStatus = publicationStatus,
        publicationDate = publicationDate?.build(),
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
    Composed_Of("composed-of", "http://hl7.org/fhir/related-artifact-type", "Composed Of"),
    Part_Of("part-of", "http://hl7.org/fhir/related-artifact-type", "Part Of"),
    Amends("amends", "http://hl7.org/fhir/related-artifact-type", "Amends"),
    Amended_With("amended-with", "http://hl7.org/fhir/related-artifact-type", "Amended With"),
    Appends("appends", "http://hl7.org/fhir/related-artifact-type", "Appends"),
    Appended_With("appended-with", "http://hl7.org/fhir/related-artifact-type", "Appended With"),
    Cites("cites", "http://hl7.org/fhir/related-artifact-type", "Cites"),
    Cited_By("cited-by", "http://hl7.org/fhir/related-artifact-type", "Cited By"),
    Comments_On("comments-on", "http://hl7.org/fhir/related-artifact-type", "Is Comment On"),
    Comment_In("comment-in", "http://hl7.org/fhir/related-artifact-type", "Has Comment In"),
    Contains("contains", "http://hl7.org/fhir/related-artifact-type", "Contains"),
    Contained_In("contained-in", "http://hl7.org/fhir/related-artifact-type", "Contained In"),
    Corrects("corrects", "http://hl7.org/fhir/related-artifact-type", "Corrects"),
    Correction_In("correction-in", "http://hl7.org/fhir/related-artifact-type", "Correction In"),
    Replaces("replaces", "http://hl7.org/fhir/related-artifact-type", "Replaces"),
    Replaced_With("replaced-with", "http://hl7.org/fhir/related-artifact-type", "Replaced With"),
    Retracts("retracts", "http://hl7.org/fhir/related-artifact-type", "Retracts"),
    Retracted_By("retracted-by", "http://hl7.org/fhir/related-artifact-type", "Retracted By"),
    Signs("signs", "http://hl7.org/fhir/related-artifact-type", "Signs"),
    Similar_To("similar-to", "http://hl7.org/fhir/related-artifact-type", "Similar To"),
    Supports("supports", "http://hl7.org/fhir/related-artifact-type", "Supports"),
    Supported_With("supported-with", "http://hl7.org/fhir/related-artifact-type", "Supported With"),
    Transforms("transforms", "http://hl7.org/fhir/related-artifact-type", "Transforms"),
    Transformed_Into(
      "transformed-into",
      "http://hl7.org/fhir/related-artifact-type",
      "Transformed Into",
    ),
    Transformed_With(
      "transformed-with",
      "http://hl7.org/fhir/related-artifact-type",
      "Transformed With",
    ),
    Documents("documents", "http://hl7.org/fhir/related-artifact-type", "Documents"),
    Specification_Of(
      "specification-of",
      "http://hl7.org/fhir/related-artifact-type",
      "Specification Of",
    ),
    Created_With("created-with", "http://hl7.org/fhir/related-artifact-type", "Created With"),
    Cite_As("cite-as", "http://hl7.org/fhir/related-artifact-type", "Cite As");

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
          "part-of" -> Part_Of
          "amends" -> Amends
          "amended-with" -> Amended_With
          "appends" -> Appends
          "appended-with" -> Appended_With
          "cites" -> Cites
          "cited-by" -> Cited_By
          "comments-on" -> Comments_On
          "comment-in" -> Comment_In
          "contains" -> Contains
          "contained-in" -> Contained_In
          "corrects" -> Corrects
          "correction-in" -> Correction_In
          "replaces" -> Replaces
          "replaced-with" -> Replaced_With
          "retracts" -> Retracts
          "retracted-by" -> Retracted_By
          "signs" -> Signs
          "similar-to" -> Similar_To
          "supports" -> Supports
          "supported-with" -> Supported_With
          "transforms" -> Transforms
          "transformed-into" -> Transformed_Into
          "transformed-with" -> Transformed_With
          "documents" -> Documents
          "specification-of" -> Specification_Of
          "created-with" -> Created_With
          "cite-as" -> Cite_As
          else -> throw IllegalArgumentException("Unknown code $code for enum RelatedArtifactType")
        }
    }
  }
}
