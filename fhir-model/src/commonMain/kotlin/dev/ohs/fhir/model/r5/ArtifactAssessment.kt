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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentArtifactSerializer
import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentCiteAsSerializer
import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentContentSerializer
import dev.ohs.fhir.model.r5.serializers.ArtifactAssessmentSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This Resource provides one or more comments, classifiers or ratings about a Resource and supports
 * attribution and rights management metadata for the added content.
 */
@Serializable(with = ArtifactAssessmentSerializer::class)
@SerialName("ArtifactAssessment")
public data class ArtifactAssessment(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: kotlin.String? = null,
  /**
   * The metadata about the resource. This is content that is maintained by the infrastructure.
   * Changes to the content might not always be associated with version changes to the resource.
   */
  override val meta: Meta? = null,
  /**
   * A reference to a set of rules that were followed when the resource was constructed, and which
   * must be understood when processing the content. Often, this is a reference to an implementation
   * guide that defines the special rules along with other profiles etc.
   *
   * Asserting this rule set restricts the content to be only understood by a limited set of trading
   * partners. This inherently limits the usefulness of the data in the long term. However, the
   * existing health eco-system is highly fractured, and not yet ready to define, collect, and
   * exchange data in a generally computable sense. Wherever possible, implementers and/or
   * specification writers should avoid using this element. Often, when used, the URL is a reference
   * to an implementation guide that defines these special rules as part of its narrative along with
   * other profiles, value sets, etc.
   */
  override val implicitRules: Uri? = null,
  /**
   * The base language in which the resource is written.
   *
   * Language is provided to support indexing and accessibility (typically, services such as text to
   * speech use the language tag). The html language tag in the narrative applies to the narrative.
   * The language tag on the resource may be used to specify the language of other presentations
   * generated from the data in the resource. Not all the content has to be in the base language.
   * The Resource.language should not be assumed to apply to the narrative automatically. If a
   * language is specified, it should it also be specified on the div element in the html (see rules
   * in HTML5 for information about the relationship between xml:lang and the html lang attribute).
   */
  override val language: Code? = null,
  /**
   * A human-readable narrative that contains a summary of the resource and can be used to represent
   * the content of the resource to a human. The narrative need not encode all the structured data,
   * but is required to contain sufficient detail to make it "clinically safe" for a human to just
   * read the narrative. Resource definitions may define what content should be represented in the
   * narrative to ensure clinical safety.
   *
   * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, nor can they have their own independent
   * transaction scope. This is allowed to be a Parameters resource if and only if it is referenced
   * by a resource that provides context/meaning.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags in their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and managable, there is a strict set of governance
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
   * resource and that modifies the understanding of the element that contains it and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and managable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer is
   * allowed to define an extension, there is a set of requirements that SHALL be met as part of the
   * definition of the extension. Applications processing a resource are required to check for
   * modifier extensions.
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
   * A formal identifier that is used to identify this artifact assessment when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this activity definition outside of FHIR, where it is not possible
   * to use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /** A short title for the assessment for use in displaying and selecting. */
  public val title: String? = null,
  /**
   * Display of or reference to the bibliographic citation of the comment, classifier, or rating.
   */
  public val citeAs: CiteAs? = null,
  /**
   * The date (and optionally time) when the artifact assessment was published. The date must change
   * when the disposition changes and it must change if the workflow status code changes. In
   * addition, it should change when the substantive content of the artifact assessment changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the artifact assessment. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   */
  public val date: DateTime? = null,
  /**
   * A copyright statement relating to the artifact assessment and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the artifact
   * assessment.
   */
  public val copyright: Markdown? = null,
  /**
   * The date on which the resource content was approved by the publisher. Approval happens once
   * when the content is officially approved for usage.
   *
   * The 'date' element may be more recent than the approval date because of minor changes or
   * editorial corrections.
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the resource content was last reviewed. Review happens periodically after
   * approval but does not change the original approval date.
   *
   * If specified, this date follows the original approval date.
   */
  public val lastReviewDate: Date? = null,
  /**
   * A reference to a resource, canonical resource, or non-FHIR resource which the comment or
   * assessment is about.
   */
  public val artifact: Artifact,
  /** A component comment, classifier, or rating of the artifact. */
  public val content: List<Content> = listOf(),
  /** Indicates the workflow status of the comment or change request. */
  public val workflowStatus: Enumeration<ArtifactAssessmentWorkflowStatus>? = null,
  /** Indicates the disposition of the responsible party to the comment or change request. */
  public val disposition: Enumeration<ArtifactAssessmentDisposition>? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(artifact).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        title = this@with.title?.toBuilder()
        citeAs = this@with.citeAs
        date = this@with.date?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        content = this@with.content.map { it.toBuilder() }.toMutableList()
        workflowStatus = this@with.workflowStatus
        disposition = this@with.disposition
      }
    }

  /** A component comment, classifier, or rating of the artifact. */
  @Serializable(with = ArtifactAssessmentContentSerializer::class)
  public data class Content(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
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
    override val modifierExtension: List<Extension> = listOf(),
    /** The type of information this component of the content represents. */
    public val informationType: Enumeration<ArtifactAssessmentInformationType>? = null,
    /** A brief summary of the content of this component. */
    public val summary: Markdown? = null,
    /** Indicates what type of content this component represents. */
    public val type: CodeableConcept? = null,
    /** Represents a rating, classifier, or assessment of the artifact. */
    public val classifier: List<CodeableConcept> = listOf(),
    /** A quantitative rating of the artifact. */
    public val quantity: Quantity? = null,
    /** Indicates who or what authored the content. */
    public val author: Reference? = null,
    /**
     * A URI that points to what the comment is about, such as a line of text in the CQL, or a
     * specific element in a resource.
     *
     * The target element is used to point the comment to aspect of the artifact, such as a text
     * range within a CQL library (e.g. #content?0:0-120:80).
     */
    public val path: List<Uri> = listOf(),
    /**
     * Additional related artifacts that provide supporting documentation, additional evidence, or
     * further information related to the content.
     */
    public val relatedArtifact: List<RelatedArtifact> = listOf(),
    /** Acceptable to publicly share the comment, classifier or rating. */
    public val freeToShare: Boolean? = null,
    /** If the informationType is container, the components of the content. */
    public val component: List<Content> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          informationType = this@with.informationType
          summary = this@with.summary?.toBuilder()
          type = this@with.type?.toBuilder()
          classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
          quantity = this@with.quantity?.toBuilder()
          author = this@with.author?.toBuilder()
          path = this@with.path.map { it.toBuilder() }.toMutableList()
          relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
          freeToShare = this@with.freeToShare?.toBuilder()
          component = this@with.component.map { it.toBuilder() }.toMutableList()
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
       * the element. To make the use of extensions safe and managable, there is a strict set of
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

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element and that modifies the understanding of the element in which it is contained
       * and/or the understanding of the containing element's descendants. Usually modifier elements
       * provide negation or qualification. To make the use of extensions safe and managable, there
       * is a strict set of governance applied to the definition and use of extensions. Though any
       * implementer can define an extension, there is a set of requirements that SHALL be met as
       * part of the definition of the extension. Applications processing a resource are required to
       * check for modifier extensions.
       *
       * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
       * DomainResource (including cannot change the meaning of modifierExtension itself).
       *
       * There can be no stigma associated with the use of extensions by any application, project,
       * or standard - regardless of the institution or jurisdiction that uses or defines the
       * extensions. The use of extensions is what allows the FHIR specification to retain a core
       * level of simplicity for everyone.
       */
      public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

      /** The type of information this component of the content represents. */
      public var informationType: Enumeration<ArtifactAssessmentInformationType>? = null

      /** A brief summary of the content of this component. */
      public var summary: Markdown.Builder? = null

      /** Indicates what type of content this component represents. */
      public var type: CodeableConcept.Builder? = null

      /** Represents a rating, classifier, or assessment of the artifact. */
      public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A quantitative rating of the artifact. */
      public var quantity: Quantity.Builder? = null

      /** Indicates who or what authored the content. */
      public var author: Reference.Builder? = null

      /**
       * A URI that points to what the comment is about, such as a line of text in the CQL, or a
       * specific element in a resource.
       *
       * The target element is used to point the comment to aspect of the artifact, such as a text
       * range within a CQL library (e.g. #content?0:0-120:80).
       */
      public var path: MutableList<Uri.Builder> = mutableListOf()

      /**
       * Additional related artifacts that provide supporting documentation, additional evidence, or
       * further information related to the content.
       */
      public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /** Acceptable to publicly share the comment, classifier or rating. */
      public var freeToShare: Boolean.Builder? = null

      /** If the informationType is container, the components of the content. */
      public var component: MutableList<Builder> = mutableListOf()

      public fun build(): Content =
        Content(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          informationType = informationType,
          summary = summary?.build(),
          type = type?.build(),
          classifier = classifier.map { it.build() },
          quantity = quantity?.build(),
          author = author?.build(),
          path = path.map { it.build() },
          relatedArtifact = relatedArtifact.map { it.build() },
          freeToShare = freeToShare?.build(),
          component = component.map { it.build() },
        )
    }
  }

  @Serializable(with = ArtifactAssessmentCiteAsSerializer::class)
  public sealed interface CiteAs {
    public fun asReference(): Reference? = this as? Reference

    public fun asMarkdown(): Markdown? = this as? Markdown

    public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : CiteAs

    public data class Markdown(public val `value`: dev.ohs.fhir.model.r5.Markdown) : CiteAs

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r5.Reference?,
        markdownValue: dev.ohs.fhir.model.r5.Markdown?,
      ): CiteAs? {
        if (referenceValue != null) return Reference(referenceValue)
        if (markdownValue != null) return Markdown(markdownValue)
        return null
      }
    }
  }

  @Serializable(with = ArtifactAssessmentArtifactSerializer::class)
  public sealed interface Artifact {
    public fun asReference(): Reference? = this as? Reference

    public fun asCanonical(): Canonical? = this as? Canonical

    public fun asUri(): Uri? = this as? Uri

    public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Artifact

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r5.Canonical) : Artifact

    public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Artifact

    public companion object {
      internal fun from(
        referenceValue: dev.ohs.fhir.model.r5.Reference?,
        canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
        uriValue: dev.ohs.fhir.model.r5.Uri?,
      ): Artifact? {
        if (referenceValue != null) return Reference(referenceValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        if (uriValue != null) return Uri(uriValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * A reference to a resource, canonical resource, or non-FHIR resource which the comment or
     * assessment is about.
     */
    public var artifact: Artifact
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: kotlin.String? = null

    /**
     * The metadata about the resource. This is content that is maintained by the infrastructure.
     * Changes to the content might not always be associated with version changes to the resource.
     */
    public var meta: Meta.Builder? = null

    /**
     * A reference to a set of rules that were followed when the resource was constructed, and which
     * must be understood when processing the content. Often, this is a reference to an
     * implementation guide that defines the special rules along with other profiles etc.
     *
     * Asserting this rule set restricts the content to be only understood by a limited set of
     * trading partners. This inherently limits the usefulness of the data in the long term.
     * However, the existing health eco-system is highly fractured, and not yet ready to define,
     * collect, and exchange data in a generally computable sense. Wherever possible, implementers
     * and/or specification writers should avoid using this element. Often, when used, the URL is a
     * reference to an implementation guide that defines these special rules as part of its
     * narrative along with other profiles, value sets, etc.
     */
    public var implicitRules: Uri.Builder? = null

    /**
     * The base language in which the resource is written.
     *
     * Language is provided to support indexing and accessibility (typically, services such as text
     * to speech use the language tag). The html language tag in the narrative applies to the
     * narrative. The language tag on the resource may be used to specify the language of other
     * presentations generated from the data in the resource. Not all the content has to be in the
     * base language. The Resource.language should not be assumed to apply to the narrative
     * automatically. If a language is specified, it should it also be specified on the div element
     * in the html (see rules in HTML5 for information about the relationship between xml:lang and
     * the html lang attribute).
     */
    public var language: Code.Builder? = null

    /**
     * A human-readable narrative that contains a summary of the resource and can be used to
     * represent the content of the resource to a human. The narrative need not encode all the
     * structured data, but is required to contain sufficient detail to make it "clinically safe"
     * for a human to just read the narrative. Resource definitions may define what content should
     * be represented in the narrative to ensure clinical safety.
     *
     * Contained resources do not have a narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, nor can they have their own independent
     * transaction scope. This is allowed to be a Parameters resource if and only if it is
     * referenced by a resource that provides context/meaning.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags in their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and managable, there is a strict set of
     * governance applied to the definition and use of extensions. Though any implementer can define
     * an extension, there is a set of requirements that SHALL be met as part of the definition of
     * the extension.
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var extension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource and that modifies the understanding of the element that contains it and/or the
     * understanding of the containing element's descendants. Usually modifier elements provide
     * negation or qualification. To make the use of extensions safe and managable, there is a
     * strict set of governance applied to the definition and use of extensions. Though any
     * implementer is allowed to define an extension, there is a set of requirements that SHALL be
     * met as part of the definition of the extension. Applications processing a resource are
     * required to check for modifier extensions.
     *
     * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
     * DomainResource (including cannot change the meaning of modifierExtension itself).
     *
     * There can be no stigma associated with the use of extensions by any application, project, or
     * standard - regardless of the institution or jurisdiction that uses or defines the extensions.
     * The use of extensions is what allows the FHIR specification to retain a core level of
     * simplicity for everyone.
     */
    public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /**
     * A formal identifier that is used to identify this artifact assessment when it is represented
     * in other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this activity definition outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A short title for the assessment for use in displaying and selecting. */
    public var title: String.Builder? = null

    /**
     * Display of or reference to the bibliographic citation of the comment, classifier, or rating.
     */
    public var citeAs: CiteAs? = null

    /**
     * The date (and optionally time) when the artifact assessment was published. The date must
     * change when the disposition changes and it must change if the workflow status code changes.
     * In addition, it should change when the substantive content of the artifact assessment
     * changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the artifact assessment. Additional specific
     * dates may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * A copyright statement relating to the artifact assessment and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the artifact
     * assessment.
     */
    public var copyright: Markdown.Builder? = null

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once
     * when the content is officially approved for usage.
     *
     * The 'date' element may be more recent than the approval date because of minor changes or
     * editorial corrections.
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after
     * approval but does not change the original approval date.
     *
     * If specified, this date follows the original approval date.
     */
    public var lastReviewDate: Date.Builder? = null

    /** A component comment, classifier, or rating of the artifact. */
    public var content: MutableList<Content.Builder> = mutableListOf()

    /** Indicates the workflow status of the comment or change request. */
    public var workflowStatus: Enumeration<ArtifactAssessmentWorkflowStatus>? = null

    /** Indicates the disposition of the responsible party to the comment or change request. */
    public var disposition: Enumeration<ArtifactAssessmentDisposition>? = null

    override fun build(): ArtifactAssessment =
      ArtifactAssessment(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        title = title?.build(),
        citeAs = citeAs,
        date = date?.build(),
        copyright = copyright?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        artifact = artifact,
        content = content.map { it.build() },
        workflowStatus = workflowStatus,
        disposition = disposition,
      )
  }

  /** The type of information contained in a component of an artifact assessment. */
  public enum class ArtifactAssessmentInformationType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Comment("comment", "http://hl7.org/fhir/artifactassessment-information-type", "Comment"),
    Classifier(
      "classifier",
      "http://hl7.org/fhir/artifactassessment-information-type",
      "Classifier",
    ),
    Rating("rating", "http://hl7.org/fhir/artifactassessment-information-type", "Rating"),
    Container("container", "http://hl7.org/fhir/artifactassessment-information-type", "Container"),
    Response("response", "http://hl7.org/fhir/artifactassessment-information-type", "Response"),
    Change_Request(
      "change-request",
      "http://hl7.org/fhir/artifactassessment-information-type",
      "Change Request",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ArtifactAssessmentInformationType =
        when (code) {
          "comment" -> Comment
          "classifier" -> Classifier
          "rating" -> Rating
          "container" -> Container
          "response" -> Response
          "change-request" -> Change_Request
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ArtifactAssessmentInformationType"
            )
        }
    }
  }

  /**
   * Possible values for the workflow status of the comment or assessment, typically used to
   * coordinate workflow around the process of accepting and rejecting changes and comments on the
   * artifact.
   */
  public enum class ArtifactAssessmentWorkflowStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Submitted("submitted", "http://hl7.org/fhir/artifactassessment-workflow-status", "Submitted"),
    Triaged("triaged", "http://hl7.org/fhir/artifactassessment-workflow-status", "Triaged"),
    Waiting_For_Input(
      "waiting-for-input",
      "http://hl7.org/fhir/artifactassessment-workflow-status",
      "Waiting for Input",
    ),
    Resolved_No_Change(
      "resolved-no-change",
      "http://hl7.org/fhir/artifactassessment-workflow-status",
      "Resolved - No Change",
    ),
    Resolved_Change_Required(
      "resolved-change-required",
      "http://hl7.org/fhir/artifactassessment-workflow-status",
      "Resolved - Change Required",
    ),
    Deferred("deferred", "http://hl7.org/fhir/artifactassessment-workflow-status", "Deferred"),
    Duplicate("duplicate", "http://hl7.org/fhir/artifactassessment-workflow-status", "Duplicate"),
    Applied("applied", "http://hl7.org/fhir/artifactassessment-workflow-status", "Applied"),
    Published("published", "http://hl7.org/fhir/artifactassessment-workflow-status", "Published"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/artifactassessment-workflow-status",
      "Entered in Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ArtifactAssessmentWorkflowStatus =
        when (code) {
          "submitted" -> Submitted
          "triaged" -> Triaged
          "waiting-for-input" -> Waiting_For_Input
          "resolved-no-change" -> Resolved_No_Change
          "resolved-change-required" -> Resolved_Change_Required
          "deferred" -> Deferred
          "duplicate" -> Duplicate
          "applied" -> Applied
          "published" -> Published
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ArtifactAssessmentWorkflowStatus"
            )
        }
    }
  }

  /**
   * Possible values for the disposition of a comment or change request, typically used for comments
   * and change requests, to indicate the disposition of the responsible party towards the changes
   * suggested by the comment or change request.
   */
  public enum class ArtifactAssessmentDisposition(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Unresolved("unresolved", "http://hl7.org/fhir/artifactassessment-disposition", "Unresolved"),
    Not_Persuasive(
      "not-persuasive",
      "http://hl7.org/fhir/artifactassessment-disposition",
      "Not Persuasive",
    ),
    Persuasive("persuasive", "http://hl7.org/fhir/artifactassessment-disposition", "Persuasive"),
    Persuasive_With_Modification(
      "persuasive-with-modification",
      "http://hl7.org/fhir/artifactassessment-disposition",
      "Persuasive with Modification",
    ),
    Not_Persuasive_With_Modification(
      "not-persuasive-with-modification",
      "http://hl7.org/fhir/artifactassessment-disposition",
      "Not Persuasive with Modification",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ArtifactAssessmentDisposition =
        when (code) {
          "unresolved" -> Unresolved
          "not-persuasive" -> Not_Persuasive
          "persuasive" -> Persuasive
          "persuasive-with-modification" -> Persuasive_With_Modification
          "not-persuasive-with-modification" -> Not_Persuasive_With_Modification
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum ArtifactAssessmentDisposition"
            )
        }
    }
  }
}
