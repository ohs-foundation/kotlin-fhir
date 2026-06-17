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

import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisCertaintySerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisEffectEstimateSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisResultsByExposureSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisSampleSizeSerializer
import dev.ohs.fhir.model.r4.serializers.EffectEvidenceSynthesisSerializer
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The EffectEvidenceSynthesis resource describes the difference in an outcome between exposures
 * states in a population where the effect estimate is derived from a combination of research
 * studies.
 */
@Serializable(with = EffectEvidenceSynthesisSerializer::class)
@SerialName("EffectEvidenceSynthesis")
public data class EffectEvidenceSynthesis(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
   * to an implementation guide that defines these special rules as part of it's narrative along
   * with other profiles, value sets, etc.
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
   * Contained resources do not have narrative. Resources that are not contained SHOULD have a
   * narrative. In some cases, a resource may only have text with little or no additional discrete
   * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
   * legacy systems where information is captured as a "text blob" or where text is additionally
   * entered raw or narrated and encoded information is added later.
   */
  override val text: Narrative? = null,
  /**
   * These resources do not have an independent existence apart from the resource that contains
   * them - they cannot be identified independently, and nor can they have their own independent
   * transaction scope.
   *
   * This should never be done when the content can be identified properly, as once identification
   * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
   * resources may have profiles and tags In their meta elements, but SHALL NOT have security
   * labels.
   */
  override val contained: List<Resource> = listOf(),
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * resource. To make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions. Though any implementer can define
   * an extension, there is a set of requirements that SHALL be met as part of the definition of the
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
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
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
   * An absolute URI that is used to identify this effect evidence synthesis when it is referenced
   * in a specification, model, design or an instance; also called its canonical identifier. This
   * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
   * instance of this effect evidence synthesis is (or will be) published. This URL can be the
   * target of a canonical reference. It SHALL remain the same when the effect evidence synthesis is
   * stored on different servers.
   *
   * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances may
   * share the same URL if they have a distinct version.
   *
   * The determination of when to create a new version of a resource (same url, new version) vs.
   * defining a new artifact is up to the author. Considerations for making this decision are found
   * in [Technical and Business Versions](resource.html#versions).
   *
   * In some cases, the resource can no longer be found at the stated url, but the url itself cannot
   * change. Implementations can use the [meta.source](resource.html#meta) element to indicate where
   * the current master source of the resource can be found.
   */
  public val url: Uri? = null,
  /**
   * A formal identifier that is used to identify this effect evidence synthesis when it is
   * represented in other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this effect evidence synthesis outside of FHIR, where it is not
   * possible to use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the effect evidence synthesis when it
   * is referenced in a specification, model, design or instance. This is an arbitrary value managed
   * by the effect evidence synthesis author and is not expected to be globally unique. For example,
   * it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
   * expectation that versions can be placed in a lexicographical sequence.
   *
   * There may be different effect evidence synthesis instances that have the same identifier but
   * different versions. The version can be appended to the url in a reference to allow a reference
   * to a particular business version of the effect evidence synthesis with the format
   * [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the effect evidence synthesis. This name should be usable
   * as an identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the effect evidence synthesis.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * The status of this effect evidence synthesis. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of effect evidence synthesiss that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * The date (and optionally time) when the effect evidence synthesis was published. The date must
   * change when the business version changes and it must change if the status code changes. In
   * addition, it should change when the substantive content of the effect evidence synthesis
   * changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the effect evidence synthesis. Additional specific dates may be
   * added as extensions or be found by consulting Provenances associated with past versions of the
   * resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the effect evidence synthesis.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the effect
   * evidence synthesis is the organization or individual primarily responsible for the maintenance
   * and upkeep of the effect evidence synthesis. This is not necessarily the same individual or
   * organization that developed and initially authored the content. The publisher is the primary
   * point of contact for questions or issues with the effect evidence synthesis. This item SHOULD
   * be populated unless the information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the effect evidence synthesis from a consumer's
   * perspective.
   *
   * This description can be used to capture details such as why the effect evidence synthesis was
   * built, comments about misuse, instructions for clinical use and interpretation, literature
   * references, examples from the paper world, etc. It is not a rendering of the effect evidence
   * synthesis as conveyed in the 'text' field of the resource itself. This item SHOULD be populated
   * unless the information is available from context (e.g. the language of the effect evidence
   * synthesis is presumed to be the predominant language in the place the effect evidence synthesis
   * was created).
   */
  public val description: Markdown? = null,
  /** A human-readable string to clarify or explain concepts about the resource. */
  public val note: List<Annotation> = listOf(),
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate effect evidence synthesis instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the effect evidence synthesis is intended to be used.
   *
   * It may be possible for the effect evidence synthesis to be used in jurisdictions other than
   * those for which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * A copyright statement relating to the effect evidence synthesis and/or its contents. Copyright
   * statements are generally legal restrictions on the use and publishing of the effect evidence
   * synthesis.
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
   * The period during which the effect evidence synthesis content was or is planned to be in active
   * use.
   *
   * The effective period for a effect evidence synthesis determines when the content is applicable
   * for usage and is independent of publication and review dates. For example, a measure intended
   * to be used for the year 2016 might be published in 2015.
   */
  public val effectivePeriod: Period? = null,
  /**
   * Descriptive topics related to the content of the EffectEvidenceSynthesis. Topics provide a
   * high-level categorization grouping types of EffectEvidenceSynthesiss that can be useful for
   * filtering and searching.
   */
  public val topic: List<CodeableConcept> = listOf(),
  /**
   * An individiual or organization primarily involved in the creation and maintenance of the
   * content.
   */
  public val author: List<ContactDetail> = listOf(),
  /** An individual or organization primarily responsible for internal coherence of the content. */
  public val editor: List<ContactDetail> = listOf(),
  /**
   * An individual or organization primarily responsible for review of some aspect of the content.
   */
  public val reviewer: List<ContactDetail> = listOf(),
  /**
   * An individual or organization responsible for officially endorsing the content for use in some
   * setting.
   */
  public val endorser: List<ContactDetail> = listOf(),
  /**
   * Related artifacts such as additional documentation, justification, or bibliographic references.
   *
   * Each related artifact is either an attachment, or a reference to another resource, but not
   * both.
   */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /** Type of synthesis eg meta-analysis. */
  public val synthesisType: CodeableConcept? = null,
  /** Type of study eg randomized trial. */
  public val studyType: CodeableConcept? = null,
  /** A reference to a EvidenceVariable resource that defines the population for the research. */
  public val population: Reference,
  /** A reference to a EvidenceVariable resource that defines the exposure for the research. */
  public val exposure: Reference,
  /**
   * A reference to a EvidenceVariable resource that defines the comparison exposure for the
   * research.
   */
  public val exposureAlternative: Reference,
  /** A reference to a EvidenceVariable resomece that defines the outcome for the research. */
  public val outcome: Reference,
  /** A description of the size of the sample involved in the synthesis. */
  public val sampleSize: SampleSize? = null,
  /** A description of the results for each exposure considered in the effect estimate. */
  public val resultsByExposure: List<ResultsByExposure> = listOf(),
  /** The estimated effect of the exposure variant. */
  public val effectEstimate: List<EffectEstimate> = listOf(),
  /** A description of the certainty of the effect estimate. */
  public val certainty: List<Certainty> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          population.toBuilder(),
          exposure.toBuilder(),
          exposureAlternative.toBuilder(),
          outcome.toBuilder(),
        )
        .apply {
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
          name = this@with.name?.toBuilder()
          title = this@with.title?.toBuilder()
          date = this@with.date?.toBuilder()
          publisher = this@with.publisher?.toBuilder()
          contact = this@with.contact.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
          jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
          copyright = this@with.copyright?.toBuilder()
          approvalDate = this@with.approvalDate?.toBuilder()
          lastReviewDate = this@with.lastReviewDate?.toBuilder()
          effectivePeriod = this@with.effectivePeriod?.toBuilder()
          topic = this@with.topic.map { it.toBuilder() }.toMutableList()
          author = this@with.author.map { it.toBuilder() }.toMutableList()
          editor = this@with.editor.map { it.toBuilder() }.toMutableList()
          reviewer = this@with.reviewer.map { it.toBuilder() }.toMutableList()
          endorser = this@with.endorser.map { it.toBuilder() }.toMutableList()
          relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
          synthesisType = this@with.synthesisType?.toBuilder()
          studyType = this@with.studyType?.toBuilder()
          sampleSize = this@with.sampleSize?.toBuilder()
          resultsByExposure = this@with.resultsByExposure.map { it.toBuilder() }.toMutableList()
          effectEstimate = this@with.effectEstimate.map { it.toBuilder() }.toMutableList()
          certainty = this@with.certainty.map { it.toBuilder() }.toMutableList()
        }
    }

  /** A description of the size of the sample involved in the synthesis. */
  @Serializable(with = EffectEvidenceSynthesisSampleSizeSerializer::class)
  public data class SampleSize(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Human-readable summary of sample size. */
    public val description: String? = null,
    /** Number of studies included in this evidence synthesis. */
    public val numberOfStudies: Integer? = null,
    /** Number of participants included in this evidence synthesis. */
    public val numberOfParticipants: Integer? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          numberOfStudies = this@with.numberOfStudies?.toBuilder()
          numberOfParticipants = this@with.numberOfParticipants?.toBuilder()
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
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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

      /** Human-readable summary of sample size. */
      public var description: String.Builder? = null

      /** Number of studies included in this evidence synthesis. */
      public var numberOfStudies: Integer.Builder? = null

      /** Number of participants included in this evidence synthesis. */
      public var numberOfParticipants: Integer.Builder? = null

      public fun build(): SampleSize =
        SampleSize(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          numberOfStudies = numberOfStudies?.build(),
          numberOfParticipants = numberOfParticipants?.build(),
        )
    }
  }

  /** A description of the results for each exposure considered in the effect estimate. */
  @Serializable(with = EffectEvidenceSynthesisResultsByExposureSerializer::class)
  public data class ResultsByExposure(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Human-readable summary of results by exposure state. */
    public val description: String? = null,
    /** Whether these results are for the exposure state or alternative exposure state. */
    public val exposureState: Enumeration<ExposureState>? = null,
    /** Used to define variant exposure states such as low-risk state. */
    public val variantState: CodeableConcept? = null,
    /** Reference to a RiskEvidenceSynthesis resource. */
    public val riskEvidenceSynthesis: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(riskEvidenceSynthesis.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          exposureState = this@with.exposureState
          variantState = this@with.variantState?.toBuilder()
        }
      }

    public class Builder(
      /** Reference to a RiskEvidenceSynthesis resource. */
      public var riskEvidenceSynthesis: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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

      /** Human-readable summary of results by exposure state. */
      public var description: String.Builder? = null

      /** Whether these results are for the exposure state or alternative exposure state. */
      public var exposureState: Enumeration<ExposureState>? = null

      /** Used to define variant exposure states such as low-risk state. */
      public var variantState: CodeableConcept.Builder? = null

      public fun build(): ResultsByExposure =
        ResultsByExposure(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          exposureState = exposureState,
          variantState = variantState?.build(),
          riskEvidenceSynthesis = riskEvidenceSynthesis.build(),
        )
    }
  }

  /** The estimated effect of the exposure variant. */
  @Serializable(with = EffectEvidenceSynthesisEffectEstimateSerializer::class)
  public data class EffectEstimate(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
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
    /** Human-readable summary of effect estimate. */
    public val description: String? = null,
    /** Examples include relative risk and mean difference. */
    public val type: CodeableConcept? = null,
    /** Used to define variant exposure states such as low-risk state. */
    public val variantState: CodeableConcept? = null,
    /** The point estimate of the effect estimate. */
    public val `value`: Decimal? = null,
    /** Specifies the UCUM unit for the outcome. */
    public val unitOfMeasure: CodeableConcept? = null,
    /** A description of the precision of the estimate for the effect. */
    public val precisionEstimate: List<PrecisionEstimate> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          type = this@with.type?.toBuilder()
          variantState = this@with.variantState?.toBuilder()
          `value` = this@with.`value`?.toBuilder()
          unitOfMeasure = this@with.unitOfMeasure?.toBuilder()
          precisionEstimate = this@with.precisionEstimate.map { it.toBuilder() }.toMutableList()
        }
      }

    /** A description of the precision of the estimate for the effect. */
    @Serializable(with = EffectEvidenceSynthesisEffectEstimatePrecisionEstimateSerializer::class)
    public data class PrecisionEstimate(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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
      /** Examples include confidence interval and interquartile range. */
      public val type: CodeableConcept? = null,
      /** Use 95 for a 95% confidence interval. */
      public val level: Decimal? = null,
      /** Lower bound of confidence interval. */
      public val from: Decimal? = null,
      /** Upper bound of confidence interval. */
      public val to: Decimal? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            level = this@with.level?.toBuilder()
            from = this@with.from?.toBuilder()
            to = this@with.to?.toBuilder()
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
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /** Examples include confidence interval and interquartile range. */
        public var type: CodeableConcept.Builder? = null

        /** Use 95 for a 95% confidence interval. */
        public var level: Decimal.Builder? = null

        /** Lower bound of confidence interval. */
        public var from: Decimal.Builder? = null

        /** Upper bound of confidence interval. */
        public var to: Decimal.Builder? = null

        public fun build(): PrecisionEstimate =
          PrecisionEstimate(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            level = level?.build(),
            from = from?.build(),
            to = to?.build(),
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
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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

      /** Human-readable summary of effect estimate. */
      public var description: String.Builder? = null

      /** Examples include relative risk and mean difference. */
      public var type: CodeableConcept.Builder? = null

      /** Used to define variant exposure states such as low-risk state. */
      public var variantState: CodeableConcept.Builder? = null

      /** The point estimate of the effect estimate. */
      public var `value`: Decimal.Builder? = null

      /** Specifies the UCUM unit for the outcome. */
      public var unitOfMeasure: CodeableConcept.Builder? = null

      /** A description of the precision of the estimate for the effect. */
      public var precisionEstimate: MutableList<PrecisionEstimate.Builder> = mutableListOf()

      public fun build(): EffectEstimate =
        EffectEstimate(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          description = description?.build(),
          type = type?.build(),
          variantState = variantState?.build(),
          `value` = `value`?.build(),
          unitOfMeasure = unitOfMeasure?.build(),
          precisionEstimate = precisionEstimate.map { it.build() },
        )
    }
  }

  /** A description of the certainty of the effect estimate. */
  @Serializable(with = EffectEvidenceSynthesisCertaintySerializer::class)
  public data class Certainty(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
    override val extension: List<Extension> = listOf(),
    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the element and that modifies the understanding of the element in which it is contained
     * and/or the understanding of the containing element's descendants. Usually modifier elements
     * provide negation or qualification. To make the use of extensions safe and manageable, there
     * is a strict set of governance applied to the definition and use of extensions. Though any
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
    /** A rating of the certainty of the effect estimate. */
    public val rating: List<CodeableConcept> = listOf(),
    /** A human-readable string to clarify or explain concepts about the resource. */
    public val note: List<Annotation> = listOf(),
    /** A description of a component of the overall certainty. */
    public val certaintySubcomponent: List<CertaintySubcomponent> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          rating = this@with.rating.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
          certaintySubcomponent =
            this@with.certaintySubcomponent.map { it.toBuilder() }.toMutableList()
        }
      }

    /** A description of a component of the overall certainty. */
    @Serializable(with = EffectEvidenceSynthesisCertaintyCertaintySubcomponentSerializer::class)
    public data class CertaintySubcomponent(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
      /**
       * May be used to represent additional information that is not part of the basic definition of
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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
      /** Type of subcomponent of certainty rating. */
      public val type: CodeableConcept? = null,
      /** A rating of a subcomponent of rating certainty. */
      public val rating: List<CodeableConcept> = listOf(),
      /** A human-readable string to clarify or explain concepts about the resource. */
      public val note: List<Annotation> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            type = this@with.type?.toBuilder()
            rating = this@with.rating.map { it.toBuilder() }.toMutableList()
            note = this@with.note.map { it.toBuilder() }.toMutableList()
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
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /** Type of subcomponent of certainty rating. */
        public var type: CodeableConcept.Builder? = null

        /** A rating of a subcomponent of rating certainty. */
        public var rating: MutableList<CodeableConcept.Builder> = mutableListOf()

        /** A human-readable string to clarify or explain concepts about the resource. */
        public var note: MutableList<Annotation.Builder> = mutableListOf()

        public fun build(): CertaintySubcomponent =
          CertaintySubcomponent(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type?.build(),
            rating = rating.map { it.build() },
            note = note.map { it.build() },
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
       * the element. To make the use of extensions safe and manageable, there is a strict set of
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
       * provide negation or qualification. To make the use of extensions safe and manageable, there
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

      /** A rating of the certainty of the effect estimate. */
      public var rating: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** A human-readable string to clarify or explain concepts about the resource. */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      /** A description of a component of the overall certainty. */
      public var certaintySubcomponent: MutableList<CertaintySubcomponent.Builder> = mutableListOf()

      public fun build(): Certainty =
        Certainty(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          rating = rating.map { it.build() },
          note = note.map { it.build() },
          certaintySubcomponent = certaintySubcomponent.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of this effect evidence synthesis. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of effect evidence synthesiss that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>,
    /** A reference to a EvidenceVariable resource that defines the population for the research. */
    public var population: Reference.Builder,
    /** A reference to a EvidenceVariable resource that defines the exposure for the research. */
    public var exposure: Reference.Builder,
    /**
     * A reference to a EvidenceVariable resource that defines the comparison exposure for the
     * research.
     */
    public var exposureAlternative: Reference.Builder,
    /** A reference to a EvidenceVariable resomece that defines the outcome for the research. */
    public var outcome: Reference.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * reference to an implementation guide that defines these special rules as part of it's
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
     * Contained resources do not have narrative. Resources that are not contained SHOULD have a
     * narrative. In some cases, a resource may only have text with little or no additional discrete
     * data (as long as all minOccurs=1 elements are satisfied). This may be necessary for data from
     * legacy systems where information is captured as a "text blob" or where text is additionally
     * entered raw or narrated and encoded information is added later.
     */
    public var text: Narrative.Builder? = null

    /**
     * These resources do not have an independent existence apart from the resource that contains
     * them - they cannot be identified independently, and nor can they have their own independent
     * transaction scope.
     *
     * This should never be done when the content can be identified properly, as once identification
     * is lost, it is extremely difficult (and context dependent) to restore it again. Contained
     * resources may have profiles and tags In their meta elements, but SHALL NOT have security
     * labels.
     */
    public var contained: MutableList<Resource.Builder> = mutableListOf()

    /**
     * May be used to represent additional information that is not part of the basic definition of
     * the resource. To make the use of extensions safe and manageable, there is a strict set of
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
     * negation or qualification. To make the use of extensions safe and manageable, there is a
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
     * An absolute URI that is used to identify this effect evidence synthesis when it is referenced
     * in a specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this effect evidence synthesis is (or will be) published. This URL can be the
     * target of a canonical reference. It SHALL remain the same when the effect evidence synthesis
     * is stored on different servers.
     *
     * Can be a urn:uuid: or a urn:oid: but real http: addresses are preferred. Multiple instances
     * may share the same URL if they have a distinct version.
     *
     * The determination of when to create a new version of a resource (same url, new version) vs.
     * defining a new artifact is up to the author. Considerations for making this decision are
     * found in [Technical and Business Versions](resource.html#versions).
     *
     * In some cases, the resource can no longer be found at the stated url, but the url itself
     * cannot change. Implementations can use the [meta.source](resource.html#meta) element to
     * indicate where the current master source of the resource can be found.
     */
    public var url: Uri.Builder? = null

    /**
     * A formal identifier that is used to identify this effect evidence synthesis when it is
     * represented in other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this effect evidence synthesis outside of FHIR, where it is
     * not possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the effect evidence synthesis when it
     * is referenced in a specification, model, design or instance. This is an arbitrary value
     * managed by the effect evidence synthesis author and is not expected to be globally unique.
     * For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available.
     * There is also no expectation that versions can be placed in a lexicographical sequence.
     *
     * There may be different effect evidence synthesis instances that have the same identifier but
     * different versions. The version can be appended to the url in a reference to allow a
     * reference to a particular business version of the effect evidence synthesis with the format
     * [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the effect evidence synthesis. This name should be usable
     * as an identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the effect evidence synthesis.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * The date (and optionally time) when the effect evidence synthesis was published. The date
     * must change when the business version changes and it must change if the status code changes.
     * In addition, it should change when the substantive content of the effect evidence synthesis
     * changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the effect evidence synthesis. Additional specific dates may be
     * added as extensions or be found by consulting Provenances associated with past versions of
     * the resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the effect evidence synthesis.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the effect
     * evidence synthesis is the organization or individual primarily responsible for the
     * maintenance and upkeep of the effect evidence synthesis. This is not necessarily the same
     * individual or organization that developed and initially authored the content. The publisher
     * is the primary point of contact for questions or issues with the effect evidence synthesis.
     * This item SHOULD be populated unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the effect evidence synthesis from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the effect evidence synthesis was
     * built, comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the effect evidence
     * synthesis as conveyed in the 'text' field of the resource itself. This item SHOULD be
     * populated unless the information is available from context (e.g. the language of the effect
     * evidence synthesis is presumed to be the predominant language in the place the effect
     * evidence synthesis was created).
     */
    public var description: Markdown.Builder? = null

    /** A human-readable string to clarify or explain concepts about the resource. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate effect evidence synthesis instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the effect evidence synthesis is intended to be used.
     *
     * It may be possible for the effect evidence synthesis to be used in jurisdictions other than
     * those for which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A copyright statement relating to the effect evidence synthesis and/or its contents.
     * Copyright statements are generally legal restrictions on the use and publishing of the effect
     * evidence synthesis.
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

    /**
     * The period during which the effect evidence synthesis content was or is planned to be in
     * active use.
     *
     * The effective period for a effect evidence synthesis determines when the content is
     * applicable for usage and is independent of publication and review dates. For example, a
     * measure intended to be used for the year 2016 might be published in 2015.
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * Descriptive topics related to the content of the EffectEvidenceSynthesis. Topics provide a
     * high-level categorization grouping types of EffectEvidenceSynthesiss that can be useful for
     * filtering and searching.
     */
    public var topic: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the
     * content.
     */
    public var author: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     */
    public var editor: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization primarily responsible for review of some aspect of the content.
     */
    public var reviewer: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * An individual or organization responsible for officially endorsing the content for use in
     * some setting.
     */
    public var endorser: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic
     * references.
     *
     * Each related artifact is either an attachment, or a reference to another resource, but not
     * both.
     */
    public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

    /** Type of synthesis eg meta-analysis. */
    public var synthesisType: CodeableConcept.Builder? = null

    /** Type of study eg randomized trial. */
    public var studyType: CodeableConcept.Builder? = null

    /** A description of the size of the sample involved in the synthesis. */
    public var sampleSize: SampleSize.Builder? = null

    /** A description of the results for each exposure considered in the effect estimate. */
    public var resultsByExposure: MutableList<ResultsByExposure.Builder> = mutableListOf()

    /** The estimated effect of the exposure variant. */
    public var effectEstimate: MutableList<EffectEstimate.Builder> = mutableListOf()

    /** A description of the certainty of the effect estimate. */
    public var certainty: MutableList<Certainty.Builder> = mutableListOf()

    override fun build(): EffectEvidenceSynthesis =
      EffectEvidenceSynthesis(
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
        name = name?.build(),
        title = title?.build(),
        status = status,
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        note = note.map { it.build() },
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        copyright = copyright?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        topic = topic.map { it.build() },
        author = author.map { it.build() },
        editor = editor.map { it.build() },
        reviewer = reviewer.map { it.build() },
        endorser = endorser.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        synthesisType = synthesisType?.build(),
        studyType = studyType?.build(),
        population = population.build(),
        exposure = exposure.build(),
        exposureAlternative = exposureAlternative.build(),
        outcome = outcome.build(),
        sampleSize = sampleSize?.build(),
        resultsByExposure = resultsByExposure.map { it.build() },
        effectEstimate = effectEstimate.map { it.build() },
        certainty = certainty.map { it.build() },
      )
  }

  /**
   * Whether the results by exposure is describing the results for the primary exposure of interest
   * (exposure) or the alternative state (exposureAlternative).
   */
  public enum class ExposureState(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Exposure("exposure", "http://hl7.org/fhir/exposure-state", "Exposure"),
    Exposure_Alternative(
      "exposure-alternative",
      "http://hl7.org/fhir/exposure-state",
      "Exposure Alternative",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ExposureState =
        when (code) {
          "exposure" -> Exposure
          "exposure-alternative" -> Exposure_Alternative
          else -> throw IllegalArgumentException("Unknown code $code for enum ExposureState")
        }
    }
  }
}
