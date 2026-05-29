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

@file:Suppress("RedundantVisibilityModifier", "PropertyName")

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactAbstractSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactClassificationSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactContributorshipEntryContributionInstanceSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactContributorshipEntrySerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactContributorshipSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactContributorshipSummarySerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactPartSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactPublicationFormPublishedInSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactPublicationFormSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactRelatesToSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactStatusDateSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactTitleSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactVersionSerializer
import dev.ohs.fhir.model.r5.serializers.CitationCitedArtifactWebLocationSerializer
import dev.ohs.fhir.model.r5.serializers.CitationClassificationSerializer
import dev.ohs.fhir.model.r5.serializers.CitationSerializer
import dev.ohs.fhir.model.r5.serializers.CitationStatusDateSerializer
import dev.ohs.fhir.model.r5.serializers.CitationSummarySerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The Citation Resource enables reference to any knowledge artifact for purposes of identification
 * and attribution. The Citation Resource supports existing reference structures and developing
 * publication practices such as versioning, expressing complex contributorship roles, and
 * referencing computable resources.
 */
@Serializable(with = CitationSerializer::class)
@SerialName("Citation")
public data class Citation(
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
   * An absolute URI that is used to identify this citation record when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which an authoritative instance of this
   * summary is (or will be) published. This URL can be the target of a canonical reference. It
   * SHALL remain the same when the summary is stored on different servers.
   *
   * In some cases, the resource can no longer be found at the stated url, but the url itself cannot
   * change. Implementations can use the meta.source element to indicate where the current master
   * source of the resource can be found.
   */
  public val url: Uri? = null,
  /**
   * A formal identifier that is used to identify this citation record when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Use this element if you need to identify the citation record independently from identifying the
   * cited artifact.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the citation record when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the citation record author and is not expected to be globally unique. For example, it might be
   * a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence.
   *
   * There may be different citation record instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the citation record with the format [url]|[version]. The version
   * SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
   */
  public val version: String? = null,
  /**
   * Indicates the mechanism used to compare versions to determine which is more current.
   *
   * If set as a string, this is a FHIRPath expression that has two additional context variables
   * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
   * positive number if version2 is newer, and a 0 if the version ordering can't successfully be
   * determined.
   */
  public val versionAlgorithm: VersionAlgorithm? = null,
  /**
   * A natural language name identifying the citation record. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the citation record.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc. Use this element if you have a need for naming the citation record for human
   * use, such as a display name for the citation record that is used when selecting citations from
   * a list.
   */
  public val title: String? = null,
  /**
   * The status of this summary. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of summaries that are appropriate for use versus not. Use "active" when the
   * citation record is the version for others to actively use, "draft" while you are developing the
   * content, and "retired" when this record should no longer be used for any purpose.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this citation record is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of citation records that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * The date (and optionally time) when the citation record was last significantly changed. The
   * date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the citation record
   * changes.
   *
   * The date is often not tracked until the resource is published, but may be present on draft
   * content. Note that this is not the same as the resource last-modified-date, since the resource
   * may be a secondary representation of the citation record. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the citation record.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the citation
   * record is the organization or individual primarily responsible for the maintenance and upkeep
   * of the citation record. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the citation record. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the citation from a consumer's perspective.
   *
   * This description can be used to capture details such as comments about misuse, instructions for
   * clinical use and interpretation, literature references, examples from the paper world, etc. It
   * is not a rendering of the citation as conveyed in the 'text' field of the resource itself. This
   * item SHOULD be populated unless the information is available from context (e.g. the language of
   * the citation is presumed to be the predominant language in the place the citation was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate citation record instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the citation record is intended to be used.
   *
   * It may be possible for the citation record to be used in jurisdictions other than those for
   * which it was originally designed or intended.
   *
   * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
   * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
   * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
   * useContext.valueCodeableConcept indicating the jurisdiction.)
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this citation is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the citation. Instead, it provides traceability of
   * ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used to
   * point to source materials or specifications that drove the structure of this citation.
   */
  public val purpose: Markdown? = null,
  /** Use and/or publishing restrictions for the citation record, not for the cited artifact. */
  public val copyright: Markdown? = null,
  /**
   * A short string (<50 characters), suitable for inclusion in a page footer that identifies the
   * copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All
   * rights reserved', 'Some rights reserved').
   *
   * The (c) symbol should NOT be included in this string. It will be added by software when
   * rendering the notation. Full details about licensing, restrictions, warrantees, etc. goes in
   * the more general 'copyright' element.
   */
  public val copyrightLabel: String? = null,
  /**
   * The date on which the resource content was approved by the publisher. Approval happens once
   * when the content is officially approved for usage.
   *
   * The 'date' element may be more recent than the approval date because of minor changes or
   * editorial corrections.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val approvalDate: Date? = null,
  /**
   * The date on which the resource content was last reviewed. Review happens periodically after
   * approval but does not change the original approval date.
   *
   * If specified, this date follows the original approval date.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val lastReviewDate: Date? = null,
  /**
   * The period during which the citation record content was or is planned to be in active use.
   *
   * The effective period for a citation record determines when the content is applicable for usage
   * and is independent of publication and review dates. For example, a citation intended to be used
   * for the year 2016 might be published in 2015.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val effectivePeriod: Period? = null,
  /**
   * Who authored or created the citation record.
   *
   * The Citation.author element is structured to support a name (with a string datatype) and
   * contact point information for the author/creator, and is not structured to support unique
   * identifiers for the author. If detailed contributorship data is needed for the authorship of
   * the citation record, then one can create a Citation Resource for the Citation Resource.
   */
  public val author: List<ContactDetail> = listOf(),
  /**
   * Who edited or revised the citation record.
   *
   * The Citation.editor element is structured to support a name (with a string datatype) and
   * contact point information for the editor, and is not structured to support unique identifiers
   * for the editor. If detailed contributorship data is needed for the editing of the citation
   * record, then one can create a Citation Resource for the Citation Resource.
   */
  public val editor: List<ContactDetail> = listOf(),
  /**
   * Who reviewed the citation record.
   *
   * The Citation.reviewer element is structured to support a name (with a string datatype) and
   * contact point information for the reviewer, and is not structured to support unique identifiers
   * for the reviewer. If detailed contributorship data is needed for the review of the citation
   * record, then one can create a Citation Resource for the Citation Resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val reviewer: List<ContactDetail> = listOf(),
  /**
   * Who endorsed the citation record.
   *
   * The Citation.endorser element is structured to support a name (with a string datatype) and
   * contact point information for the endorser, and is not structured to support unique identifiers
   * for the endorser. If detailed contributorship data is needed for the endorsement of the
   * citation record, then one can create a Citation Resource for the Citation Resource.
   *
   * See guidance around (not) making local changes to elements
   * [here](canonicalresource.html#localization).
   */
  public val endorser: List<ContactDetail> = listOf(),
  /** A human-readable display of key concepts to represent the citation. */
  public val summary: List<Summary> = listOf(),
  /**
   * The assignment to an organizing scheme.
   *
   * Use this element if you need to classify the citation record independently from classifying the
   * cited artifact.
   */
  public val classification: List<Classification> = listOf(),
  /** Used for general notes and annotations not coded elsewhere. */
  public val note: List<Annotation> = listOf(),
  /**
   * The status of the citation record.
   *
   * Use this if needed for reporting the state or status of the citation record, NOT FOR reporting
   * the state or status of the cited article.
   */
  public val currentState: List<CodeableConcept> = listOf(),
  /**
   * The state or status of the citation record paired with an effective date or period for that
   * state.
   *
   * Use this if needed for reporting the state or status of the citation record, NOT FOR reporting
   * the state or status of the cited article.
   */
  public val statusDate: List<StatusDate> = listOf(),
  /**
   * Artifact related to the citation record.
   *
   * Use this if needed for reporting artifacts related to the citation record, NOT FOR reporting
   * artifacts related to the cited article. For example, one may use this element to report the
   * data source for generation of the Citation Resource instance if it was automatically generated,
   * such as conversion from a citation repository.
   */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /** The article or artifact being described. */
  public val citedArtifact: CitedArtifact? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        url = this@with.url?.toBuilder()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        version = this@with.version?.toBuilder()
        versionAlgorithm = this@with.versionAlgorithm
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        copyright = this@with.copyright?.toBuilder()
        copyrightLabel = this@with.copyrightLabel?.toBuilder()
        approvalDate = this@with.approvalDate?.toBuilder()
        lastReviewDate = this@with.lastReviewDate?.toBuilder()
        effectivePeriod = this@with.effectivePeriod?.toBuilder()
        author = this@with.author.map { it.toBuilder() }.toMutableList()
        editor = this@with.editor.map { it.toBuilder() }.toMutableList()
        reviewer = this@with.reviewer.map { it.toBuilder() }.toMutableList()
        endorser = this@with.endorser.map { it.toBuilder() }.toMutableList()
        summary = this@with.summary.map { it.toBuilder() }.toMutableList()
        classification = this@with.classification.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        currentState = this@with.currentState.map { it.toBuilder() }.toMutableList()
        statusDate = this@with.statusDate.map { it.toBuilder() }.toMutableList()
        relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
        citedArtifact = this@with.citedArtifact?.toBuilder()
      }
    }

  /** A human-readable display of key concepts to represent the citation. */
  @Serializable(with = CitationSummarySerializer::class)
  public data class Summary(
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
    /** Format for display of the citation summary. */
    public val style: CodeableConcept? = null,
    /** The human-readable display of the citation summary. */
    public val text: Markdown,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(text.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          style = this@with.style?.toBuilder()
        }
      }

    public class Builder(
      /** The human-readable display of the citation summary. */
      public var text: Markdown.Builder
    ) {
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

      /** Format for display of the citation summary. */
      public var style: CodeableConcept.Builder? = null

      public fun build(): Summary =
        Summary(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          style = style?.build(),
          text = text.build(),
        )
    }
  }

  /** The assignment to an organizing scheme. */
  @Serializable(with = CitationClassificationSerializer::class)
  public data class Classification(
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
    /** The kind of classifier (e.g. publication type, keyword). */
    public val type: CodeableConcept? = null,
    /** The specific classification value. */
    public val classifier: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
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

      /** The kind of classifier (e.g. publication type, keyword). */
      public var type: CodeableConcept.Builder? = null

      /** The specific classification value. */
      public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Classification =
        Classification(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          classifier = classifier.map { it.build() },
        )
    }
  }

  /**
   * The state or status of the citation record paired with an effective date or period for that
   * state.
   */
  @Serializable(with = CitationStatusDateSerializer::class)
  public data class StatusDate(
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
    /** The state or status of the citation record (that will be paired with the period). */
    public val activity: CodeableConcept,
    /** Whether the status date is actual (has occurred) or expected (estimated or anticipated). */
    public val `actual`: Boolean? = null,
    /**
     * When the status started and/or ended.
     *
     * For an instance, place the same value in both start and end elements.
     */
    public val period: Period,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(activity.toBuilder(), period.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `actual` = this@with.`actual`?.toBuilder()
        }
      }

    public class Builder(
      /** The state or status of the citation record (that will be paired with the period). */
      public var activity: CodeableConcept.Builder,
      /**
       * When the status started and/or ended.
       *
       * For an instance, place the same value in both start and end elements.
       */
      public var period: Period.Builder,
    ) {
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

      /**
       * Whether the status date is actual (has occurred) or expected (estimated or anticipated).
       */
      public var `actual`: Boolean.Builder? = null

      public fun build(): StatusDate =
        StatusDate(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          activity = activity.build(),
          `actual` = `actual`?.build(),
          period = period.build(),
        )
    }
  }

  /** The article or artifact being described. */
  @Serializable(with = CitationCitedArtifactSerializer::class)
  public data class CitedArtifact(
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
    /**
     * A formal identifier that is used to identify the cited artifact when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * This element will contain unique identifiers that support de-duplication of citations.
     * Commonly used identifiers for study citations include digital object identifier (DOI), PubMed
     * ID (PMID), and PubMed Central ID (PMCID). To maintain interoperability, the suggested
     * identifier.system values to use for these 3 identifiers are: DOI = "https://doi.org" PMID =
     * "https://pubmed.ncbi.nlm.nih.gov" PMCID = "https://www.ncbi.nlm.nih.gov/pmc/"
     */
    public val identifier: List<Identifier> = listOf(),
    /**
     * A formal identifier that is used to identify things closely related to the cited artifact.
     *
     * May include trial registry identifiers, e.g. NCT04372602 from clinicaltrials.gov. This
     * related identifier would not be used as unique identifier for the cited artifact itself.
     * Multiple published articles (each with their own unique identifier) may relate to the same
     * study record in a research registry. Commonly used related identifiers for study registries
     * include ClinicalTrials.gov identifier (NCTId) and PROSPERO identifier (used for registration
     * of systematic reviews). To maintain interoperability, the suggested identifier.system values
     * to use for these 2 identifiers are: ClinicalTrials.gov = "https://clinicaltrials.gov"
     * PROSPERO = "https://www.crd.york.ac.uk/prospero/"
     */
    public val relatedIdentifier: List<Identifier> = listOf(),
    /**
     * When the cited artifact was accessed.
     *
     * Use this element when citing an artifact from a potentially unstable source, such as a
     * webpage, to note the date (and time) the source was accessed.
     */
    public val dateAccessed: DateTime? = null,
    /** The defined version of the cited artifact. */
    public val version: Version? = null,
    /** The status of the cited artifact. */
    public val currentState: List<CodeableConcept> = listOf(),
    /**
     * An effective date or period, historical or future, actual or expected, for a status of the
     * cited artifact.
     */
    public val statusDate: List<StatusDate> = listOf(),
    /** The title details of the article or artifact. */
    public val title: List<Title> = listOf(),
    /**
     * The abstract may be used to convey article-contained abstracts, externally-created abstracts,
     * or other descriptive summaries.
     */
    public val `abstract`: List<Abstract> = listOf(),
    /** The component of the article or artifact. */
    public val part: Part? = null,
    /**
     * The artifact related to the cited artifact.
     *
     * The citedArtifact.relatesTo element uses a BackboneElement instead of the RelatedArtifact
     * Datatype to enable use of an extended value set for the required code for the type of
     * relationship.
     */
    public val relatesTo: List<RelatesTo> = listOf(),
    /**
     * If multiple, used to represent alternative forms of the article that are not separate
     * citations.
     *
     * A common use is a journal article with a publication date and pagination for a print version
     * and a different publication date for the online version of the same article.
     */
    public val publicationForm: List<PublicationForm> = listOf(),
    /** Used for any URL for the article or artifact cited. */
    public val webLocation: List<WebLocation> = listOf(),
    /** The assignment to an organizing scheme. */
    public val classification: List<Classification> = listOf(),
    /**
     * This element is used to list authors and other contributors, their contact information,
     * specific contributions, and summary statements.
     */
    public val contributorship: Contributorship? = null,
    /** Any additional information or content for the article or artifact. */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          relatedIdentifier = this@with.relatedIdentifier.map { it.toBuilder() }.toMutableList()
          dateAccessed = this@with.dateAccessed?.toBuilder()
          version = this@with.version?.toBuilder()
          currentState = this@with.currentState.map { it.toBuilder() }.toMutableList()
          statusDate = this@with.statusDate.map { it.toBuilder() }.toMutableList()
          title = this@with.title.map { it.toBuilder() }.toMutableList()
          `abstract` = this@with.`abstract`.map { it.toBuilder() }.toMutableList()
          part = this@with.part?.toBuilder()
          relatesTo = this@with.relatesTo.map { it.toBuilder() }.toMutableList()
          publicationForm = this@with.publicationForm.map { it.toBuilder() }.toMutableList()
          webLocation = this@with.webLocation.map { it.toBuilder() }.toMutableList()
          classification = this@with.classification.map { it.toBuilder() }.toMutableList()
          contributorship = this@with.contributorship?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    /** The defined version of the cited artifact. */
    @Serializable(with = CitationCitedArtifactVersionSerializer::class)
    public data class Version(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The version number or other version identifier. */
      public val `value`: String,
      /**
       * Citation for the main version of the cited artifact.
       *
       * When referencing a baseCitation, one may inherit any data from the referenced Citation
       * Resource and consider any data in the current Citation Resource as superceding to be
       * version-specific.
       */
      public val baseCitation: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(`value`.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            baseCitation = this@with.baseCitation?.toBuilder()
          }
        }

      public class Builder(
        /** The version number or other version identifier. */
        public var `value`: String.Builder
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /**
         * Citation for the main version of the cited artifact.
         *
         * When referencing a baseCitation, one may inherit any data from the referenced Citation
         * Resource and consider any data in the current Citation Resource as superceding to be
         * version-specific.
         */
        public var baseCitation: Reference.Builder? = null

        public fun build(): Version =
          Version(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            `value` = `value`.build(),
            baseCitation = baseCitation?.build(),
          )
      }
    }

    /**
     * An effective date or period, historical or future, actual or expected, for a status of the
     * cited artifact.
     */
    @Serializable(with = CitationCitedArtifactStatusDateSerializer::class)
    public data class StatusDate(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** A definition of the status associated with a date or period. */
      public val activity: CodeableConcept,
      /** Either occurred or expected. */
      public val `actual`: Boolean? = null,
      /**
       * When the status started and/or ended.
       *
       * For an instance, place the same value in both start and end elements.
       */
      public val period: Period,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(activity.toBuilder(), period.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            `actual` = this@with.`actual`?.toBuilder()
          }
        }

      public class Builder(
        /** A definition of the status associated with a date or period. */
        public var activity: CodeableConcept.Builder,
        /**
         * When the status started and/or ended.
         *
         * For an instance, place the same value in both start and end elements.
         */
        public var period: Period.Builder,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Either occurred or expected. */
        public var `actual`: Boolean.Builder? = null

        public fun build(): StatusDate =
          StatusDate(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            activity = activity.build(),
            `actual` = `actual`?.build(),
            period = period.build(),
          )
      }
    }

    /** The title details of the article or artifact. */
    @Serializable(with = CitationCitedArtifactTitleSerializer::class)
    public data class Title(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Used to express the reason for or classification of the title. */
      public val type: List<CodeableConcept> = listOf(),
      /** Used to express the specific language of the title. */
      public val language: CodeableConcept? = null,
      /** The title of the article or artifact. */
      public val text: Markdown,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(text.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type.map { it.toBuilder() }.toMutableList()
            language = this@with.language?.toBuilder()
          }
        }

      public class Builder(
        /** The title of the article or artifact. */
        public var text: Markdown.Builder
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Used to express the reason for or classification of the title. */
        public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** Used to express the specific language of the title. */
        public var language: CodeableConcept.Builder? = null

        public fun build(): Title =
          Title(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.map { it.build() },
            language = language?.build(),
            text = text.build(),
          )
      }
    }

    /**
     * The abstract may be used to convey article-contained abstracts, externally-created abstracts,
     * or other descriptive summaries.
     */
    @Serializable(with = CitationCitedArtifactAbstractSerializer::class)
    public data class Abstract(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** Used to express the reason for or classification of the abstract. */
      public val type: CodeableConcept? = null,
      /** Used to express the specific language of the abstract. */
      public val language: CodeableConcept? = null,
      /** Abstract content. */
      public val text: Markdown,
      /**
       * Copyright notice for the abstract.
       *
       * There is also a copyright element in the publicationForm element, so this copyright element
       * is intended for copyright of the abstract.
       */
      public val copyright: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(text.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            language = this@with.language?.toBuilder()
            copyright = this@with.copyright?.toBuilder()
          }
        }

      public class Builder(
        /** Abstract content. */
        public var text: Markdown.Builder
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Used to express the reason for or classification of the abstract. */
        public var type: CodeableConcept.Builder? = null

        /** Used to express the specific language of the abstract. */
        public var language: CodeableConcept.Builder? = null

        /**
         * Copyright notice for the abstract.
         *
         * There is also a copyright element in the publicationForm element, so this copyright
         * element is intended for copyright of the abstract.
         */
        public var copyright: Markdown.Builder? = null

        public fun build(): Abstract =
          Abstract(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            language = language?.build(),
            text = text.build(),
            copyright = copyright?.build(),
          )
      }
    }

    /** The component of the article or artifact. */
    @Serializable(with = CitationCitedArtifactPartSerializer::class)
    public data class Part(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The kind of component. */
      public val type: CodeableConcept? = null,
      /** The specification of the component. */
      public val `value`: String? = null,
      /**
       * The citation for the full article or artifact.
       *
       * When referencing a baseCitation, one may inherit any data from the referenced Citation
       * Resource and consider any data in the current Citation Resource as superceding to be
       * specific to the citation of the specified part. For example, the part-specific Citation may
       * have additional contributorship data that supercedes the contributorship data for the full
       * citation when there is a need to uniquely report the contributorship for an image or
       * supplement associated with the fuller citation record.
       */
      public val baseCitation: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            `value` = this@with.`value`?.toBuilder()
            baseCitation = this@with.baseCitation?.toBuilder()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** The kind of component. */
        public var type: CodeableConcept.Builder? = null

        /** The specification of the component. */
        public var `value`: String.Builder? = null

        /**
         * The citation for the full article or artifact.
         *
         * When referencing a baseCitation, one may inherit any data from the referenced Citation
         * Resource and consider any data in the current Citation Resource as superceding to be
         * specific to the citation of the specified part. For example, the part-specific Citation
         * may have additional contributorship data that supercedes the contributorship data for the
         * full citation when there is a need to uniquely report the contributorship for an image or
         * supplement associated with the fuller citation record.
         */
        public var baseCitation: Reference.Builder? = null

        public fun build(): Part =
          Part(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            `value` = `value`?.build(),
            baseCitation = baseCitation?.build(),
          )
      }
    }

    /** The artifact related to the cited artifact. */
    @Serializable(with = CitationCitedArtifactRelatesToSerializer::class)
    public data class RelatesTo(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The type of relationship to the related artifact. */
      public val type: Enumeration<RelatedArtifactTypeExpanded>,
      /** Provides additional classifiers of the related artifact. */
      public val classifier: List<CodeableConcept> = listOf(),
      /**
       * A short label that can be used to reference the related artifact from elsewhere in the
       * containing artifact, such as a footnote index.
       *
       * Though not commonly used in citation records, this could be used for referencing other
       * articles in the abstract or explanatory notes.
       */
      public val label: String? = null,
      /**
       * A brief description of the document or knowledge resource being referenced, suitable for
       * display to a consumer.
       */
      public val display: String? = null,
      /**
       * A bibliographic citation for the related artifact. This text SHOULD be formatted according
       * to an accepted citation format.
       */
      public val citation: Markdown? = null,
      /**
       * The document being referenced, represented as an attachment. Do not use this element if
       * using the resource element to provide the canonical to the related artifact.
       *
       * To refer to related artifacts by URL, the FHIR Attachment Datatype includes a url element,
       * so the path would be Citation.citedArtifact.relatesTo.document.url
       */
      public val document: Attachment? = null,
      /**
       * The related artifact, such as a library, value set, profile, or other knowledge resource.
       *
       * If the type is predecessor, this is a reference to the succeeding knowledge resource. If
       * the type is successor, this is a reference to the prior knowledge resource
       */
      public val resource: Canonical? = null,
      /**
       * The related artifact, if the artifact is not a canonical resource, or a resource reference
       * to a canonical resource.
       *
       * If both resource and resourceReference are present, they SHOULD be consistent and reference
       * the same resource. Although relatedArtifact is intended to support references to
       * definitional resources, there are cases where non-definitional resources can be
       * definitional (such as Location where the kind is mode). Related artifacts SHOULD be used to
       * reference definitional resources, and profiles SHOULD be used to make that explicit for
       * particular use cases.
       */
      public val resourceReference: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
            label = this@with.label?.toBuilder()
            display = this@with.display?.toBuilder()
            citation = this@with.citation?.toBuilder()
            document = this@with.document?.toBuilder()
            resource = this@with.resource?.toBuilder()
            resourceReference = this@with.resourceReference?.toBuilder()
          }
        }

      public class Builder(
        /** The type of relationship to the related artifact. */
        public var type: Enumeration<RelatedArtifactTypeExpanded>
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** Provides additional classifiers of the related artifact. */
        public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * A short label that can be used to reference the related artifact from elsewhere in the
         * containing artifact, such as a footnote index.
         *
         * Though not commonly used in citation records, this could be used for referencing other
         * articles in the abstract or explanatory notes.
         */
        public var label: String.Builder? = null

        /**
         * A brief description of the document or knowledge resource being referenced, suitable for
         * display to a consumer.
         */
        public var display: String.Builder? = null

        /**
         * A bibliographic citation for the related artifact. This text SHOULD be formatted
         * according to an accepted citation format.
         */
        public var citation: Markdown.Builder? = null

        /**
         * The document being referenced, represented as an attachment. Do not use this element if
         * using the resource element to provide the canonical to the related artifact.
         *
         * To refer to related artifacts by URL, the FHIR Attachment Datatype includes a url
         * element, so the path would be Citation.citedArtifact.relatesTo.document.url
         */
        public var document: Attachment.Builder? = null

        /**
         * The related artifact, such as a library, value set, profile, or other knowledge resource.
         *
         * If the type is predecessor, this is a reference to the succeeding knowledge resource. If
         * the type is successor, this is a reference to the prior knowledge resource
         */
        public var resource: Canonical.Builder? = null

        /**
         * The related artifact, if the artifact is not a canonical resource, or a resource
         * reference to a canonical resource.
         *
         * If both resource and resourceReference are present, they SHOULD be consistent and
         * reference the same resource. Although relatedArtifact is intended to support references
         * to definitional resources, there are cases where non-definitional resources can be
         * definitional (such as Location where the kind is mode). Related artifacts SHOULD be used
         * to reference definitional resources, and profiles SHOULD be used to make that explicit
         * for particular use cases.
         */
        public var resourceReference: Reference.Builder? = null

        public fun build(): RelatesTo =
          RelatesTo(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type,
            classifier = classifier.map { it.build() },
            label = label?.build(),
            display = display?.build(),
            citation = citation?.build(),
            document = document?.build(),
            resource = resource?.build(),
            resourceReference = resourceReference?.build(),
          )
      }
    }

    /**
     * If multiple, used to represent alternative forms of the article that are not separate
     * citations.
     */
    @Serializable(with = CitationCitedArtifactPublicationFormSerializer::class)
    public data class PublicationForm(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The collection the cited article or artifact is published in. */
      public val publishedIn: PublishedIn? = null,
      /**
       * Describes the form of the medium cited. Common codes are "Internet" or "Print". The
       * CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage
       * are the common codes for a typical publication form, though internet and print are more
       * common for study citations. Three additional codes (each appending one of the primary codes
       * with "-without-issue" are used for situations when a study is published both within an
       * issue (of a periodical release as commonly done for journals) AND is published separately
       * from the issue (as commonly done with early online publication), to represent specific
       * identification of the publication form not associated with the issue.
       */
      public val citedMedium: CodeableConcept? = null,
      /** Volume number of journal or other collection in which the article is published. */
      public val volume: String? = null,
      /**
       * Issue, part or supplement of journal or other collection in which the article is published.
       */
      public val issue: String? = null,
      /**
       * The date the article was added to the database, or the date the article was released.
       *
       * The articleDate is the preferred element for expressing the publication date as structured
       * data.
       */
      public val articleDate: DateTime? = null,
      /**
       * Text representation of the date on which the issue of the cited artifact was published.
       *
       * The publicationDateText element is prefererntially used when a date is not represented in a
       * form that can be handled as structured data in other elements.
       */
      public val publicationDateText: String? = null,
      /** Spring, Summer, Fall/Autumn, Winter. */
      public val publicationDateSeason: String? = null,
      /**
       * The date the article was last revised or updated in the database.
       *
       * The lastRevisionDate is used for the cited article and not the date the Citation Resource
       * is last revised.
       */
      public val lastRevisionDate: DateTime? = null,
      /** The language or languages in which this form of the article is published. */
      public val language: List<CodeableConcept> = listOf(),
      /**
       * Entry number or identifier for inclusion in a database.
       *
       * Accession numbers may be used instead of or in addition to page numbers. Accession numbers
       * are functionally identifiers when coupled with the identity of the database for which they
       * are accession numbers. Accession numbers which are used for indexing citations in a dataset
       * of citations should NOT be entered in
       * Citation.citedArtifact.publicationForm.accessionNumber -- this use would be a type of
       * Citation.identifier for the citation record itself.
       */
      public val accessionNumber: String? = null,
      /** Used for full display of pagination. */
      public val pageString: String? = null,
      /** Used for isolated representation of first page. */
      public val firstPage: String? = null,
      /** Used for isolated representation of last page. */
      public val lastPage: String? = null,
      /**
       * Actual or approximate number of pages or screens. Distinct from reporting the page numbers.
       */
      public val pageCount: String? = null,
      /**
       * Copyright notice for the full article or artifact.
       *
       * It is possible that different publication forms have different copyright notices.
       */
      public val copyright: Markdown? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            publishedIn = this@with.publishedIn?.toBuilder()
            citedMedium = this@with.citedMedium?.toBuilder()
            volume = this@with.volume?.toBuilder()
            issue = this@with.issue?.toBuilder()
            articleDate = this@with.articleDate?.toBuilder()
            publicationDateText = this@with.publicationDateText?.toBuilder()
            publicationDateSeason = this@with.publicationDateSeason?.toBuilder()
            lastRevisionDate = this@with.lastRevisionDate?.toBuilder()
            language = this@with.language.map { it.toBuilder() }.toMutableList()
            accessionNumber = this@with.accessionNumber?.toBuilder()
            pageString = this@with.pageString?.toBuilder()
            firstPage = this@with.firstPage?.toBuilder()
            lastPage = this@with.lastPage?.toBuilder()
            pageCount = this@with.pageCount?.toBuilder()
            copyright = this@with.copyright?.toBuilder()
          }
        }

      /** The collection the cited article or artifact is published in. */
      @Serializable(with = CitationCitedArtifactPublicationFormPublishedInSerializer::class)
      public data class PublishedIn(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * Kind of container (e.g. Periodical, database, or book).
         *
         * Journals and newspapers are coded as Periodical.
         */
        public val type: CodeableConcept? = null,
        /**
         * Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers
         * include ISBN.
         */
        public val identifier: List<Identifier> = listOf(),
        /**
         * Name of the database or title of the book or journal.
         *
         * ClinicalTrials.gov is a name of a database.
         */
        public val title: String? = null,
        /** Name of or resource describing the publisher. */
        public val publisher: Reference? = null,
        /** Geographic location of the publisher. */
        public val publisherLocation: String? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder().apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              type = this@with.type?.toBuilder()
              identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
              title = this@with.title?.toBuilder()
              publisher = this@with.publisher?.toBuilder()
              publisherLocation = this@with.publisherLocation?.toBuilder()
            }
          }

        public class Builder() {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * Kind of container (e.g. Periodical, database, or book).
           *
           * Journals and newspapers are coded as Periodical.
           */
          public var type: CodeableConcept.Builder? = null

          /**
           * Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID; Book identifiers
           * include ISBN.
           */
          public var identifier: MutableList<Identifier.Builder> = mutableListOf()

          /**
           * Name of the database or title of the book or journal.
           *
           * ClinicalTrials.gov is a name of a database.
           */
          public var title: String.Builder? = null

          /** Name of or resource describing the publisher. */
          public var publisher: Reference.Builder? = null

          /** Geographic location of the publisher. */
          public var publisherLocation: String.Builder? = null

          public fun build(): PublishedIn =
            PublishedIn(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              type = type?.build(),
              identifier = identifier.map { it.build() },
              title = title?.build(),
              publisher = publisher?.build(),
              publisherLocation = publisherLocation?.build(),
            )
        }
      }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** The collection the cited article or artifact is published in. */
        public var publishedIn: PublishedIn.Builder? = null

        /**
         * Describes the form of the medium cited. Common codes are "Internet" or "Print". The
         * CitedMedium value set has 6 codes. The codes internet, print, and offline-digital-storage
         * are the common codes for a typical publication form, though internet and print are more
         * common for study citations. Three additional codes (each appending one of the primary
         * codes with "-without-issue" are used for situations when a study is published both within
         * an issue (of a periodical release as commonly done for journals) AND is published
         * separately from the issue (as commonly done with early online publication), to represent
         * specific identification of the publication form not associated with the issue.
         */
        public var citedMedium: CodeableConcept.Builder? = null

        /** Volume number of journal or other collection in which the article is published. */
        public var volume: String.Builder? = null

        /**
         * Issue, part or supplement of journal or other collection in which the article is
         * published.
         */
        public var issue: String.Builder? = null

        /**
         * The date the article was added to the database, or the date the article was released.
         *
         * The articleDate is the preferred element for expressing the publication date as
         * structured data.
         */
        public var articleDate: DateTime.Builder? = null

        /**
         * Text representation of the date on which the issue of the cited artifact was published.
         *
         * The publicationDateText element is prefererntially used when a date is not represented in
         * a form that can be handled as structured data in other elements.
         */
        public var publicationDateText: String.Builder? = null

        /** Spring, Summer, Fall/Autumn, Winter. */
        public var publicationDateSeason: String.Builder? = null

        /**
         * The date the article was last revised or updated in the database.
         *
         * The lastRevisionDate is used for the cited article and not the date the Citation Resource
         * is last revised.
         */
        public var lastRevisionDate: DateTime.Builder? = null

        /** The language or languages in which this form of the article is published. */
        public var language: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Entry number or identifier for inclusion in a database.
         *
         * Accession numbers may be used instead of or in addition to page numbers. Accession
         * numbers are functionally identifiers when coupled with the identity of the database for
         * which they are accession numbers. Accession numbers which are used for indexing citations
         * in a dataset of citations should NOT be entered in
         * Citation.citedArtifact.publicationForm.accessionNumber -- this use would be a type of
         * Citation.identifier for the citation record itself.
         */
        public var accessionNumber: String.Builder? = null

        /** Used for full display of pagination. */
        public var pageString: String.Builder? = null

        /** Used for isolated representation of first page. */
        public var firstPage: String.Builder? = null

        /** Used for isolated representation of last page. */
        public var lastPage: String.Builder? = null

        /**
         * Actual or approximate number of pages or screens. Distinct from reporting the page
         * numbers.
         */
        public var pageCount: String.Builder? = null

        /**
         * Copyright notice for the full article or artifact.
         *
         * It is possible that different publication forms have different copyright notices.
         */
        public var copyright: Markdown.Builder? = null

        public fun build(): PublicationForm =
          PublicationForm(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            publishedIn = publishedIn?.build(),
            citedMedium = citedMedium?.build(),
            volume = volume?.build(),
            issue = issue?.build(),
            articleDate = articleDate?.build(),
            publicationDateText = publicationDateText?.build(),
            publicationDateSeason = publicationDateSeason?.build(),
            lastRevisionDate = lastRevisionDate?.build(),
            language = language.map { it.build() },
            accessionNumber = accessionNumber?.build(),
            pageString = pageString?.build(),
            firstPage = firstPage?.build(),
            lastPage = lastPage?.build(),
            pageCount = pageCount?.build(),
            copyright = copyright?.build(),
          )
      }
    }

    /** Used for any URL for the article or artifact cited. */
    @Serializable(with = CitationCitedArtifactWebLocationSerializer::class)
    public data class WebLocation(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * A characterization of the object expected at the web location.
       *
       * Categories that may be frequently used for study citations may include abstract, full-text,
       * supplement, webpage, and doi-based.
       */
      public val classifier: List<CodeableConcept> = listOf(),
      /**
       * The specific URL.
       *
       * Persistent URLs, like doi, are preferred.
       */
      public val url: Uri? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
            url = this@with.url?.toBuilder()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /**
         * A characterization of the object expected at the web location.
         *
         * Categories that may be frequently used for study citations may include abstract,
         * full-text, supplement, webpage, and doi-based.
         */
        public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * The specific URL.
         *
         * Persistent URLs, like doi, are preferred.
         */
        public var url: Uri.Builder? = null

        public fun build(): WebLocation =
          WebLocation(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            classifier = classifier.map { it.build() },
            url = url?.build(),
          )
      }
    }

    /** The assignment to an organizing scheme. */
    @Serializable(with = CitationCitedArtifactClassificationSerializer::class)
    public data class Classification(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The kind of classifier (e.g. publication type, keyword). */
      public val type: CodeableConcept? = null,
      /** The specific classification value. */
      public val classifier: List<CodeableConcept> = listOf(),
      /**
       * Complex or externally created classification.
       *
       * Examples relevant to study citations include MeSH Headings or Keywords that contain
       * qualifier codings or sub-classifications, and include risk of bias assessments created by
       * persons different from the creator of the citation record.
       */
      public val artifactAssessment: List<Reference> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
            artifactAssessment = this@with.artifactAssessment.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /** The kind of classifier (e.g. publication type, keyword). */
        public var type: CodeableConcept.Builder? = null

        /** The specific classification value. */
        public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Complex or externally created classification.
         *
         * Examples relevant to study citations include MeSH Headings or Keywords that contain
         * qualifier codings or sub-classifications, and include risk of bias assessments created by
         * persons different from the creator of the citation record.
         */
        public var artifactAssessment: MutableList<Reference.Builder> = mutableListOf()

        public fun build(): Classification =
          Classification(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            classifier = classifier.map { it.build() },
            artifactAssessment = artifactAssessment.map { it.build() },
          )
      }
    }

    /**
     * This element is used to list authors and other contributors, their contact information,
     * specific contributions, and summary statements.
     */
    @Serializable(with = CitationCitedArtifactContributorshipSerializer::class)
    public data class Contributorship(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * Indicates if the list includes all authors and/or contributors.
       *
       * If list is incomplete, "et al" can be appended to Contributorship.summary.value for display
       * purposes.
       */
      public val complete: Boolean? = null,
      /**
       * An individual entity named as a contributor, for example in the author list or contributor
       * list.
       *
       * Used to report contributorship in individualized ways.
       */
      public val entry: List<Entry> = listOf(),
      /**
       * Used to record a display of the author/contributor list without separate data element for
       * each list member.
       */
      public val summary: List<Summary> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            complete = this@with.complete?.toBuilder()
            entry = this@with.entry.map { it.toBuilder() }.toMutableList()
            summary = this@with.summary.map { it.toBuilder() }.toMutableList()
          }
        }

      /**
       * An individual entity named as a contributor, for example in the author list or contributor
       * list.
       */
      @Serializable(with = CitationCitedArtifactContributorshipEntrySerializer::class)
      public data class Entry(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The identity of the individual contributor.
         *
         * If naming a contributor without additional detail or further structured data, the display
         * element within the Reference datatype may be used for a simple string without referencing
         * another resource.
         */
        public val contributor: Reference,
        /**
         * For citation styles that use initials.
         *
         * This element is used to support a data element used for citations that is not otherwise
         * supported fully by FHIR HumanName datatype. In some citation summary styles (e.g.
         * Medline), authors are presented with full spelling of their last name (family name) and
         * initials for all forenames (first names, middle names, preceding names, given names). As
         * the FHIR HumanName Datatype does not have a specific element for forename initials and
         * this is common in citation usage, the element is added to contributorship.entry directly.
         */
        public val forenameInitials: String? = null,
        /**
         * Organization affiliated with the contributor.
         *
         * If naming an organization without additional detail or further structured data, the
         * display element within the Reference datatype may be used for a simple string without
         * referencing another resource.
         */
        public val affiliation: List<Reference> = listOf(),
        /**
         * This element identifies the specific nature of an individual’s contribution with respect
         * to the cited work.
         *
         * The CreDiT taxonomy provides a way to encode contribution information. The purpose of
         * CRediT is to provide transparency in contributions to scholarly published work, to enable
         * improved systems of attribution, credit, and accountability.
         */
        public val contributionType: List<CodeableConcept> = listOf(),
        /** The role of the contributor (e.g. author, editor, reviewer, funder). */
        public val role: CodeableConcept? = null,
        /** Contributions with accounting for time or number. */
        public val contributionInstance: List<ContributionInstance> = listOf(),
        /**
         * Whether the contributor is the corresponding contributor for the role.
         *
         * If there are multiple authors and one serves as the corresponding author, then that one
         * would have correspondingContact = true.
         */
        public val correspondingContact: Boolean? = null,
        /**
         * Provides a numerical ranking to represent the degree of contributorship relative to other
         * contributors, such as 1 for first author and 2 for second author.
         *
         * Used to retain order of authorship as structured data
         */
        public val rankingOrder: PositiveInt? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(contributor.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              forenameInitials = this@with.forenameInitials?.toBuilder()
              affiliation = this@with.affiliation.map { it.toBuilder() }.toMutableList()
              contributionType = this@with.contributionType.map { it.toBuilder() }.toMutableList()
              role = this@with.role?.toBuilder()
              contributionInstance =
                this@with.contributionInstance.map { it.toBuilder() }.toMutableList()
              correspondingContact = this@with.correspondingContact?.toBuilder()
              rankingOrder = this@with.rankingOrder?.toBuilder()
            }
          }

        /** Contributions with accounting for time or number. */
        @Serializable(
          with = CitationCitedArtifactContributorshipEntryContributionInstanceSerializer::class
        )
        public data class ContributionInstance(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: kotlin.String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val extension: List<Extension> = listOf(),
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val modifierExtension: List<Extension> = listOf(),
          /** The specific contribution. */
          public val type: CodeableConcept,
          /** The time that the contribution was made. */
          public val time: DateTime? = null,
        ) : BackboneElement() {
          public fun toBuilder(): Builder =
            with(this) {
              Builder(type.toBuilder()).apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                time = this@with.time?.toBuilder()
              }
            }

          public class Builder(
            /** The specific contribution. */
            public var type: CodeableConcept.Builder
          ) {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: kotlin.String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and managable, there is
             * a strict set of governance applied to the definition and use of extensions. Though
             * any implementer can define an extension, there is a set of requirements that SHALL be
             * met as part of the definition of the extension.
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var extension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element and that modifies the understanding of the element in which
             * it is contained and/or the understanding of the containing element's descendants.
             * Usually modifier elements provide negation or qualification. To make the use of
             * extensions safe and managable, there is a strict set of governance applied to the
             * definition and use of extensions. Though any implementer can define an extension,
             * there is a set of requirements that SHALL be met as part of the definition of the
             * extension. Applications processing a resource are required to check for modifier
             * extensions.
             *
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
             * DomainResource (including cannot change the meaning of modifierExtension itself).
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

            /** The time that the contribution was made. */
            public var time: DateTime.Builder? = null

            public fun build(): ContributionInstance =
              ContributionInstance(
                id = id,
                extension = extension.map { it.build() },
                modifierExtension = modifierExtension.map { it.build() },
                type = type.build(),
                time = time?.build(),
              )
          }
        }

        public class Builder(
          /**
           * The identity of the individual contributor.
           *
           * If naming a contributor without additional detail or further structured data, the
           * display element within the Reference datatype may be used for a simple string without
           * referencing another resource.
           */
          public var contributor: Reference.Builder
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * For citation styles that use initials.
           *
           * This element is used to support a data element used for citations that is not otherwise
           * supported fully by FHIR HumanName datatype. In some citation summary styles (e.g.
           * Medline), authors are presented with full spelling of their last name (family name) and
           * initials for all forenames (first names, middle names, preceding names, given names).
           * As the FHIR HumanName Datatype does not have a specific element for forename initials
           * and this is common in citation usage, the element is added to contributorship.entry
           * directly.
           */
          public var forenameInitials: String.Builder? = null

          /**
           * Organization affiliated with the contributor.
           *
           * If naming an organization without additional detail or further structured data, the
           * display element within the Reference datatype may be used for a simple string without
           * referencing another resource.
           */
          public var affiliation: MutableList<Reference.Builder> = mutableListOf()

          /**
           * This element identifies the specific nature of an individual’s contribution with
           * respect to the cited work.
           *
           * The CreDiT taxonomy provides a way to encode contribution information. The purpose of
           * CRediT is to provide transparency in contributions to scholarly published work, to
           * enable improved systems of attribution, credit, and accountability.
           */
          public var contributionType: MutableList<CodeableConcept.Builder> = mutableListOf()

          /** The role of the contributor (e.g. author, editor, reviewer, funder). */
          public var role: CodeableConcept.Builder? = null

          /** Contributions with accounting for time or number. */
          public var contributionInstance: MutableList<ContributionInstance.Builder> =
            mutableListOf()

          /**
           * Whether the contributor is the corresponding contributor for the role.
           *
           * If there are multiple authors and one serves as the corresponding author, then that one
           * would have correspondingContact = true.
           */
          public var correspondingContact: Boolean.Builder? = null

          /**
           * Provides a numerical ranking to represent the degree of contributorship relative to
           * other contributors, such as 1 for first author and 2 for second author.
           *
           * Used to retain order of authorship as structured data
           */
          public var rankingOrder: PositiveInt.Builder? = null

          public fun build(): Entry =
            Entry(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              contributor = contributor.build(),
              forenameInitials = forenameInitials?.build(),
              affiliation = affiliation.map { it.build() },
              contributionType = contributionType.map { it.build() },
              role = role?.build(),
              contributionInstance = contributionInstance.map { it.build() },
              correspondingContact = correspondingContact?.build(),
              rankingOrder = rankingOrder?.build(),
            )
        }
      }

      /**
       * Used to record a display of the author/contributor list without separate data element for
       * each list member.
       */
      @Serializable(with = CitationCitedArtifactContributorshipSummarySerializer::class)
      public data class Summary(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
         * define an extension, there is a set of requirements that SHALL be met as part of the
         * definition of the extension.
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val extension: List<Extension> = listOf(),
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
         *
         * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
         * DomainResource (including cannot change the meaning of modifierExtension itself).
         *
         * There can be no stigma associated with the use of extensions by any application, project,
         * or standard - regardless of the institution or jurisdiction that uses or defines the
         * extensions. The use of extensions is what allows the FHIR specification to retain a core
         * level of simplicity for everyone.
         */
        override val modifierExtension: List<Extension> = listOf(),
        /** Used most commonly to express an author list or a contributorship statement. */
        public val type: CodeableConcept? = null,
        /**
         * The format for the display string, such as author last name with first letter capitalized
         * followed by forename initials.
         */
        public val style: CodeableConcept? = null,
        /** Used to code the producer or rule for creating the display string. */
        public val source: CodeableConcept? = null,
        /**
         * The display string for the author list, contributor list, or contributorship statement.
         */
        public val `value`: Markdown,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder(`value`.toBuilder()).apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              type = this@with.type?.toBuilder()
              style = this@with.style?.toBuilder()
              source = this@with.source?.toBuilder()
            }
          }

        public class Builder(
          /**
           * The display string for the author list, contributor list, or contributorship statement.
           */
          public var `value`: Markdown.Builder
        ) {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /** Used most commonly to express an author list or a contributorship statement. */
          public var type: CodeableConcept.Builder? = null

          /**
           * The format for the display string, such as author last name with first letter
           * capitalized followed by forename initials.
           */
          public var style: CodeableConcept.Builder? = null

          /** Used to code the producer or rule for creating the display string. */
          public var source: CodeableConcept.Builder? = null

          public fun build(): Summary =
            Summary(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              type = type?.build(),
              style = style?.build(),
              source = source?.build(),
              `value` = `value`.build(),
            )
        }
      }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and managable, there is a strict set
         * of governance applied to the definition and use of extensions. Though any implementer can
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
         * May be used to represent additional information that is not part of the basic definition
         * of the element and that modifies the understanding of the element in which it is
         * contained and/or the understanding of the containing element's descendants. Usually
         * modifier elements provide negation or qualification. To make the use of extensions safe
         * and managable, there is a strict set of governance applied to the definition and use of
         * extensions. Though any implementer can define an extension, there is a set of
         * requirements that SHALL be met as part of the definition of the extension. Applications
         * processing a resource are required to check for modifier extensions.
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

        /**
         * Indicates if the list includes all authors and/or contributors.
         *
         * If list is incomplete, "et al" can be appended to Contributorship.summary.value for
         * display purposes.
         */
        public var complete: Boolean.Builder? = null

        /**
         * An individual entity named as a contributor, for example in the author list or
         * contributor list.
         *
         * Used to report contributorship in individualized ways.
         */
        public var entry: MutableList<Entry.Builder> = mutableListOf()

        /**
         * Used to record a display of the author/contributor list without separate data element for
         * each list member.
         */
        public var summary: MutableList<Summary.Builder> = mutableListOf()

        public fun build(): Contributorship =
          Contributorship(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            complete = complete?.build(),
            entry = entry.map { it.build() },
            summary = summary.map { it.build() },
          )
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

      /**
       * A formal identifier that is used to identify the cited artifact when it is represented in
       * other formats, or referenced in a specification, model, design or an instance.
       *
       * This element will contain unique identifiers that support de-duplication of citations.
       * Commonly used identifiers for study citations include digital object identifier (DOI),
       * PubMed ID (PMID), and PubMed Central ID (PMCID). To maintain interoperability, the
       * suggested identifier.system values to use for these 3 identifiers are: DOI =
       * "https://doi.org" PMID = "https://pubmed.ncbi.nlm.nih.gov" PMCID =
       * "https://www.ncbi.nlm.nih.gov/pmc/"
       */
      public var identifier: MutableList<Identifier.Builder> = mutableListOf()

      /**
       * A formal identifier that is used to identify things closely related to the cited artifact.
       *
       * May include trial registry identifiers, e.g. NCT04372602 from clinicaltrials.gov. This
       * related identifier would not be used as unique identifier for the cited artifact itself.
       * Multiple published articles (each with their own unique identifier) may relate to the same
       * study record in a research registry. Commonly used related identifiers for study registries
       * include ClinicalTrials.gov identifier (NCTId) and PROSPERO identifier (used for
       * registration of systematic reviews). To maintain interoperability, the suggested
       * identifier.system values to use for these 2 identifiers are: ClinicalTrials.gov =
       * "https://clinicaltrials.gov" PROSPERO = "https://www.crd.york.ac.uk/prospero/"
       */
      public var relatedIdentifier: MutableList<Identifier.Builder> = mutableListOf()

      /**
       * When the cited artifact was accessed.
       *
       * Use this element when citing an artifact from a potentially unstable source, such as a
       * webpage, to note the date (and time) the source was accessed.
       */
      public var dateAccessed: DateTime.Builder? = null

      /** The defined version of the cited artifact. */
      public var version: Version.Builder? = null

      /** The status of the cited artifact. */
      public var currentState: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * An effective date or period, historical or future, actual or expected, for a status of the
       * cited artifact.
       */
      public var statusDate: MutableList<StatusDate.Builder> = mutableListOf()

      /** The title details of the article or artifact. */
      public var title: MutableList<Title.Builder> = mutableListOf()

      /**
       * The abstract may be used to convey article-contained abstracts, externally-created
       * abstracts, or other descriptive summaries.
       */
      public var `abstract`: MutableList<Abstract.Builder> = mutableListOf()

      /** The component of the article or artifact. */
      public var part: Part.Builder? = null

      /**
       * The artifact related to the cited artifact.
       *
       * The citedArtifact.relatesTo element uses a BackboneElement instead of the RelatedArtifact
       * Datatype to enable use of an extended value set for the required code for the type of
       * relationship.
       */
      public var relatesTo: MutableList<RelatesTo.Builder> = mutableListOf()

      /**
       * If multiple, used to represent alternative forms of the article that are not separate
       * citations.
       *
       * A common use is a journal article with a publication date and pagination for a print
       * version and a different publication date for the online version of the same article.
       */
      public var publicationForm: MutableList<PublicationForm.Builder> = mutableListOf()

      /** Used for any URL for the article or artifact cited. */
      public var webLocation: MutableList<WebLocation.Builder> = mutableListOf()

      /** The assignment to an organizing scheme. */
      public var classification: MutableList<Classification.Builder> = mutableListOf()

      /**
       * This element is used to list authors and other contributors, their contact information,
       * specific contributions, and summary statements.
       */
      public var contributorship: Contributorship.Builder? = null

      /** Any additional information or content for the article or artifact. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): CitedArtifact =
        CitedArtifact(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          identifier = identifier.map { it.build() },
          relatedIdentifier = relatedIdentifier.map { it.build() },
          dateAccessed = dateAccessed?.build(),
          version = version?.build(),
          currentState = currentState.map { it.build() },
          statusDate = statusDate.map { it.build() },
          title = title.map { it.build() },
          `abstract` = `abstract`.map { it.build() },
          part = part?.build(),
          relatesTo = relatesTo.map { it.build() },
          publicationForm = publicationForm.map { it.build() },
          webLocation = webLocation.map { it.build() },
          classification = classification.map { it.build() },
          contributorship = contributorship?.build(),
          note = note.map { it.build() },
        )
    }
  }

  public sealed interface VersionAlgorithm {
    public fun asString(): String? = this as? String

    public fun asCoding(): Coding? = this as? Coding

    @JvmInline
    public value class String(public val `value`: dev.ohs.fhir.model.r5.String) : VersionAlgorithm

    @JvmInline
    public value class Coding(public val `value`: dev.ohs.fhir.model.r5.Coding) : VersionAlgorithm

    public companion object {
      internal fun from(
        stringValue: dev.ohs.fhir.model.r5.String?,
        codingValue: dev.ohs.fhir.model.r5.Coding?,
      ): VersionAlgorithm? {
        if (stringValue != null) return String(stringValue)
        if (codingValue != null) return Coding(codingValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of summaries that are appropriate for use versus not. Use "active" when the
     * citation record is the version for others to actively use, "draft" while you are developing
     * the content, and "retired" when this record should no longer be used for any purpose.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var status: Enumeration<PublicationStatus>
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
     * An absolute URI that is used to identify this citation record when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance
     * of this summary is (or will be) published. This URL can be the target of a canonical
     * reference. It SHALL remain the same when the summary is stored on different servers.
     *
     * In some cases, the resource can no longer be found at the stated url, but the url itself
     * cannot change. Implementations can use the meta.source element to indicate where the current
     * master source of the resource can be found.
     */
    public var url: Uri.Builder? = null

    /**
     * A formal identifier that is used to identify this citation record when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * Use this element if you need to identify the citation record independently from identifying
     * the cited artifact.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the citation record when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the citation record author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different citation record instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the citation record with the format [url]|[version]. The
     * version SHOULD NOT contain a '#' - see [Business Version](resource.html#bv-format).
     */
    public var version: String.Builder? = null

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     *
     * If set as a string, this is a FHIRPath expression that has two additional context variables
     * passed in - %version1 and %version2 and will return a negative number if version1 is newer, a
     * positive number if version2 is newer, and a 0 if the version ordering can't successfully be
     * determined.
     */
    public var versionAlgorithm: VersionAlgorithm? = null

    /**
     * A natural language name identifying the citation record. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the citation record.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc. Use this element if you have a need for naming the citation record for
     * human use, such as a display name for the citation record that is used when selecting
     * citations from a list.
     */
    public var title: String.Builder? = null

    /**
     * A Boolean value to indicate that this citation record is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of citation records that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * The date (and optionally time) when the citation record was last significantly changed. The
     * date must change when the business version changes and it must change if the status code
     * changes. In addition, it should change when the substantive content of the citation record
     * changes.
     *
     * The date is often not tracked until the resource is published, but may be present on draft
     * content. Note that this is not the same as the resource last-modified-date, since the
     * resource may be a secondary representation of the citation record. Additional specific dates
     * may be added as extensions or be found by consulting Provenances associated with past
     * versions of the resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the citation record.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the citation
     * record is the organization or individual primarily responsible for the maintenance and upkeep
     * of the citation record. This is not necessarily the same individual or organization that
     * developed and initially authored the content. The publisher is the primary point of contact
     * for questions or issues with the citation record. This item SHOULD be populated unless the
     * information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the citation from a consumer's perspective.
     *
     * This description can be used to capture details such as comments about misuse, instructions
     * for clinical use and interpretation, literature references, examples from the paper world,
     * etc. It is not a rendering of the citation as conveyed in the 'text' field of the resource
     * itself. This item SHOULD be populated unless the information is available from context (e.g.
     * the language of the citation is presumed to be the predominant language in the place the
     * citation was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate citation record instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the citation record is intended to be used.
     *
     * It may be possible for the citation record to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     *
     * DEPRECATION NOTE: For consistency, implementations are encouraged to migrate to using the new
     * 'jurisdiction' code in the useContext element. (I.e. useContext.code indicating
     * http://terminology.hl7.org/CodeSystem/usage-context-type#jurisdiction and
     * useContext.valueCodeableConcept indicating the jurisdiction.)
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this citation is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the citation. Instead, it provides traceability
     * of ''why'' the resource is either needed or ''why'' it is defined as it is. This may be used
     * to point to source materials or specifications that drove the structure of this citation.
     */
    public var purpose: Markdown.Builder? = null

    /** Use and/or publishing restrictions for the citation record, not for the cited artifact. */
    public var copyright: Markdown.Builder? = null

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the
     * copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All
     * rights reserved', 'Some rights reserved').
     *
     * The (c) symbol should NOT be included in this string. It will be added by software when
     * rendering the notation. Full details about licensing, restrictions, warrantees, etc. goes in
     * the more general 'copyright' element.
     */
    public var copyrightLabel: String.Builder? = null

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once
     * when the content is officially approved for usage.
     *
     * The 'date' element may be more recent than the approval date because of minor changes or
     * editorial corrections.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var approvalDate: Date.Builder? = null

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after
     * approval but does not change the original approval date.
     *
     * If specified, this date follows the original approval date.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var lastReviewDate: Date.Builder? = null

    /**
     * The period during which the citation record content was or is planned to be in active use.
     *
     * The effective period for a citation record determines when the content is applicable for
     * usage and is independent of publication and review dates. For example, a citation intended to
     * be used for the year 2016 might be published in 2015.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * Who authored or created the citation record.
     *
     * The Citation.author element is structured to support a name (with a string datatype) and
     * contact point information for the author/creator, and is not structured to support unique
     * identifiers for the author. If detailed contributorship data is needed for the authorship of
     * the citation record, then one can create a Citation Resource for the Citation Resource.
     */
    public var author: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Who edited or revised the citation record.
     *
     * The Citation.editor element is structured to support a name (with a string datatype) and
     * contact point information for the editor, and is not structured to support unique identifiers
     * for the editor. If detailed contributorship data is needed for the editing of the citation
     * record, then one can create a Citation Resource for the Citation Resource.
     */
    public var editor: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Who reviewed the citation record.
     *
     * The Citation.reviewer element is structured to support a name (with a string datatype) and
     * contact point information for the reviewer, and is not structured to support unique
     * identifiers for the reviewer. If detailed contributorship data is needed for the review of
     * the citation record, then one can create a Citation Resource for the Citation Resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var reviewer: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Who endorsed the citation record.
     *
     * The Citation.endorser element is structured to support a name (with a string datatype) and
     * contact point information for the endorser, and is not structured to support unique
     * identifiers for the endorser. If detailed contributorship data is needed for the endorsement
     * of the citation record, then one can create a Citation Resource for the Citation Resource.
     *
     * See guidance around (not) making local changes to elements
     * [here](canonicalresource.html#localization).
     */
    public var endorser: MutableList<ContactDetail.Builder> = mutableListOf()

    /** A human-readable display of key concepts to represent the citation. */
    public var summary: MutableList<Summary.Builder> = mutableListOf()

    /**
     * The assignment to an organizing scheme.
     *
     * Use this element if you need to classify the citation record independently from classifying
     * the cited artifact.
     */
    public var classification: MutableList<Classification.Builder> = mutableListOf()

    /** Used for general notes and annotations not coded elsewhere. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The status of the citation record.
     *
     * Use this if needed for reporting the state or status of the citation record, NOT FOR
     * reporting the state or status of the cited article.
     */
    public var currentState: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The state or status of the citation record paired with an effective date or period for that
     * state.
     *
     * Use this if needed for reporting the state or status of the citation record, NOT FOR
     * reporting the state or status of the cited article.
     */
    public var statusDate: MutableList<StatusDate.Builder> = mutableListOf()

    /**
     * Artifact related to the citation record.
     *
     * Use this if needed for reporting artifacts related to the citation record, NOT FOR reporting
     * artifacts related to the cited article. For example, one may use this element to report the
     * data source for generation of the Citation Resource instance if it was automatically
     * generated, such as conversion from a citation repository.
     */
    public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

    /** The article or artifact being described. */
    public var citedArtifact: CitedArtifact.Builder? = null

    override fun build(): Citation =
      Citation(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        url = url?.build(),
        identifier = identifier.map { it.build() },
        version = version?.build(),
        versionAlgorithm = versionAlgorithm,
        name = name?.build(),
        title = title?.build(),
        status = status,
        experimental = experimental?.build(),
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        copyright = copyright?.build(),
        copyrightLabel = copyrightLabel?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        author = author.map { it.build() },
        editor = editor.map { it.build() },
        reviewer = reviewer.map { it.build() },
        endorser = endorser.map { it.build() },
        summary = summary.map { it.build() },
        classification = classification.map { it.build() },
        note = note.map { it.build() },
        currentState = currentState.map { it.build() },
        statusDate = statusDate.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        citedArtifact = citedArtifact?.build(),
      )
  }

  /** The type of relationship to the cited artifact. */
  public enum class RelatedArtifactTypeExpanded(
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
    Cite_As("cite-as", "http://hl7.org/fhir/related-artifact-type", "Cite As"),
    Reprint("reprint", "http://hl7.org/fhir/related-artifact-type-expanded", "Reprint"),
    Reprint_Of("reprint-of", "http://hl7.org/fhir/related-artifact-type-expanded", "Reprint Of");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RelatedArtifactTypeExpanded =
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
          "reprint" -> Reprint
          "reprint-of" -> Reprint_Of
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum RelatedArtifactTypeExpanded"
            )
        }
    }
  }
}
