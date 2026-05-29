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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.ResearchStudyAssociatedPartySerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyComparisonGroupSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyLabelSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyObjectiveSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyOutcomeMeasureSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyProgressStatusSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudyRecruitmentSerializer
import dev.ohs.fhir.model.r5.serializers.ResearchStudySerializer
import dev.ohs.fhir.model.r5.terminologies.PublicationStatus
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A scientific study of nature that sometimes includes processes involved in health and disease.
 * For example, clinical trials are research studies that involve people. These studies may be
 * related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain
 * outcomes and certain groups of people by looking at data collected in the past or future.
 */
@Serializable(with = ResearchStudySerializer::class)
@SerialName("ResearchStudy")
public data class ResearchStudy(
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
  /** Canonical identifier for this study resource, represented as a globally unique URI. */
  public val url: Uri? = null,
  /** Identifiers assigned to this research study by the sponsor or other systems. */
  public val identifier: List<Identifier> = listOf(),
  /** The business version for the study record. */
  public val version: String? = null,
  /** Name for this study (computer friendly). */
  public val name: String? = null,
  /** The human readable name of the research study. */
  public val title: String? = null,
  /** Additional names for the study. */
  public val label: List<Label> = listOf(),
  /** The set of steps expected to be performed as part of the execution of the study. */
  public val protocol: List<Reference> = listOf(),
  /** A larger research study of which this particular study is a component or step. */
  public val partOf: List<Reference> = listOf(),
  /**
   * Citations, references, URLs and other related documents. When using relatedArtifact to share
   * URLs, the relatedArtifact.type will often be set to one of "documentation" or "supported-with"
   * and the URL value will often be in relatedArtifact.document.url but another possible location
   * is relatedArtifact.resource when it is a canonical URL.
   */
  public val relatedArtifact: List<RelatedArtifact> = listOf(),
  /**
   * The date (and optionally time) when the ResearchStudy Resource was last significantly changed.
   * The date must change when the business version changes and it must change if the status code
   * changes. In addition, it should change when the substantive content of the ResearchStudy
   * Resource changes.
   */
  public val date: DateTime? = null,
  /** The publication state of the resource (not of the study). */
  public val status: Enumeration<PublicationStatus>,
  /**
   * The type of study based upon the intent of the study activities. A classification of the intent
   * of the study.
   */
  public val primaryPurposeType: CodeableConcept? = null,
  /**
   * The stage in the progression of a therapy from initial experimental use in humans in clinical
   * trials to post-market evaluation.
   */
  public val phase: CodeableConcept? = null,
  /**
   * Codes categorizing the type of study such as investigational vs. observational, type of
   * blinding, type of randomization, safety vs. efficacy, etc.
   */
  public val studyDesign: List<CodeableConcept> = listOf(),
  /**
   * The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the
   * study is seeking to gain more information about.
   */
  public val focus: List<CodeableReference> = listOf(),
  /**
   * The condition that is the focus of the study. For example, In a study to examine risk factors
   * for Lupus, might have as an inclusion criterion "healthy volunteer", but the target condition
   * code would be a Lupus SNOMED code.
   */
  public val condition: List<CodeableConcept> = listOf(),
  /** Key terms to aid in searching for or filtering the study. */
  public val keyword: List<CodeableConcept> = listOf(),
  /**
   * A country, state or other area where the study is taking place rather than its precise
   * geographic location or address.
   */
  public val region: List<CodeableConcept> = listOf(),
  /** A brief text for explaining the study. */
  public val descriptionSummary: Markdown? = null,
  /** A detailed and human-readable narrative of the study. E.g., study abstract. */
  public val description: Markdown? = null,
  /**
   * Identifies the start date and the expected (or actual, depending on status) end date for the
   * study.
   */
  public val period: Period? = null,
  /** A facility in which study activities are conducted. */
  public val site: List<Reference> = listOf(),
  /** Comments made about the study by the performer, subject or other participants. */
  public val note: List<Annotation> = listOf(),
  /**
   * Additional grouping mechanism or categorization of a research study. Example: FDA regulated
   * device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc.
   * Implementation Note: do not use the classifier element to support existing semantics that are
   * already supported thru explicit elements in the resource.
   */
  public val classifier: List<CodeableConcept> = listOf(),
  /**
   * Sponsors, collaborators, and other parties.
   *
   * For a Sponsor or a PrincipalInvestigator use the dedicated attributes provided.
   */
  public val associatedParty: List<AssociatedParty> = listOf(),
  /** Status of study with time for that status. */
  public val progressStatus: List<ProgressStatus> = listOf(),
  /** A description and/or code explaining the premature termination of the study. */
  public val whyStopped: CodeableConcept? = null,
  /** Target or actual group of participants enrolled in study. */
  public val recruitment: Recruitment? = null,
  /**
   * Describes an expected event or sequence of events for one of the subjects of a study. E.g. for
   * a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g.
   * for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from
   * lot A at 40 degrees for 1 month}.
   *
   * In many clinical trials this is refered to as the ARM of the study, but such a term is not used
   * in other sorts of trials even when there is a comparison between two or more groups.
   */
  public val comparisonGroup: List<ComparisonGroup> = listOf(),
  /**
   * A goal that the study is aiming to achieve in terms of a scientific question to be answered by
   * the analysis of data collected during the study.
   */
  public val objective: List<Objective> = listOf(),
  /**
   * An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific
   * measurement or observation used to quantify the effect of experimental variables on the
   * participants in a study, or for observational studies, to describe patterns of diseases or
   * traits or associations with exposures, risk factors or treatment.
   *
   * A study may have multiple distinct outcome measures that can be used to assess the overall goal
   * for a study. The goal of a study is in the objective whereas the metric by which the goal is
   * assessed is the outcomeMeasure. Examples: Time to Local Recurrence (TLR), Disease-free Survival
   * (DFS), 30 Day Mortality, Systolic BP
   */
  public val outcomeMeasure: List<OutcomeMeasure> = listOf(),
  /**
   * Link to one or more sets of results generated by the study. Could also link to a research
   * registry holding the results such as ClinicalTrials.gov.
   */
  public val result: List<Reference> = listOf(),
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
        name = this@with.name?.toBuilder()
        title = this@with.title?.toBuilder()
        label = this@with.label.map { it.toBuilder() }.toMutableList()
        protocol = this@with.protocol.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        relatedArtifact = this@with.relatedArtifact.map { it.toBuilder() }.toMutableList()
        date = this@with.date?.toBuilder()
        primaryPurposeType = this@with.primaryPurposeType?.toBuilder()
        phase = this@with.phase?.toBuilder()
        studyDesign = this@with.studyDesign.map { it.toBuilder() }.toMutableList()
        focus = this@with.focus.map { it.toBuilder() }.toMutableList()
        condition = this@with.condition.map { it.toBuilder() }.toMutableList()
        keyword = this@with.keyword.map { it.toBuilder() }.toMutableList()
        region = this@with.region.map { it.toBuilder() }.toMutableList()
        descriptionSummary = this@with.descriptionSummary?.toBuilder()
        description = this@with.description?.toBuilder()
        period = this@with.period?.toBuilder()
        site = this@with.site.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
        associatedParty = this@with.associatedParty.map { it.toBuilder() }.toMutableList()
        progressStatus = this@with.progressStatus.map { it.toBuilder() }.toMutableList()
        whyStopped = this@with.whyStopped?.toBuilder()
        recruitment = this@with.recruitment?.toBuilder()
        comparisonGroup = this@with.comparisonGroup.map { it.toBuilder() }.toMutableList()
        objective = this@with.objective.map { it.toBuilder() }.toMutableList()
        outcomeMeasure = this@with.outcomeMeasure.map { it.toBuilder() }.toMutableList()
        result = this@with.result.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Additional names for the study. */
  @Serializable(with = ResearchStudyLabelSerializer::class)
  public data class Label(
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
    /** Kind of name. */
    public val type: CodeableConcept? = null,
    /** The name. */
    public val `value`: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          `value` = this@with.`value`?.toBuilder()
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

      /** Kind of name. */
      public var type: CodeableConcept.Builder? = null

      /** The name. */
      public var `value`: String.Builder? = null

      public fun build(): Label =
        Label(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          `value` = `value`?.build(),
        )
    }
  }

  /** Sponsors, collaborators, and other parties. */
  @Serializable(with = ResearchStudyAssociatedPartySerializer::class)
  public data class AssociatedParty(
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
    /** Name of associated party. */
    public val name: String? = null,
    /** Type of association. */
    public val role: CodeableConcept,
    /**
     * Identifies the start date and the end date of the associated party in the role.
     *
     * The cardinality is 0..* due to the fact that an associated party may be intermittently active
     * in a given role over multiple time periods.
     */
    public val period: List<Period> = listOf(),
    /** A categorization other than role for the associated party. */
    public val classifier: List<CodeableConcept> = listOf(),
    /**
     * Individual or organization associated with study (use practitionerRole to specify their
     * organisation).
     *
     * Suggestions of a better attribute name are appreciated
     */
    public val party: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(role.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          period = this@with.period.map { it.toBuilder() }.toMutableList()
          classifier = this@with.classifier.map { it.toBuilder() }.toMutableList()
          party = this@with.party?.toBuilder()
        }
      }

    public class Builder(
      /** Type of association. */
      public var role: CodeableConcept.Builder
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

      /** Name of associated party. */
      public var name: String.Builder? = null

      /**
       * Identifies the start date and the end date of the associated party in the role.
       *
       * The cardinality is 0..* due to the fact that an associated party may be intermittently
       * active in a given role over multiple time periods.
       */
      public var period: MutableList<Period.Builder> = mutableListOf()

      /** A categorization other than role for the associated party. */
      public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Individual or organization associated with study (use practitionerRole to specify their
       * organisation).
       *
       * Suggestions of a better attribute name are appreciated
       */
      public var party: Reference.Builder? = null

      public fun build(): AssociatedParty =
        AssociatedParty(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name?.build(),
          role = role.build(),
          period = period.map { it.build() },
          classifier = classifier.map { it.build() },
          party = party?.build(),
        )
    }
  }

  /** Status of study with time for that status. */
  @Serializable(with = ResearchStudyProgressStatusSerializer::class)
  public data class ProgressStatus(
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
    /** Label for status or state (e.g. recruitment status). */
    public val state: CodeableConcept,
    /**
     * An indication of whether or not the date is a known date when the state changed or will
     * change. A value of true indicates a known date. A value of false indicates an estimated date.
     */
    public val `actual`: Boolean? = null,
    /** Date range. */
    public val period: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(state.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          `actual` = this@with.`actual`?.toBuilder()
          period = this@with.period?.toBuilder()
        }
      }

    public class Builder(
      /** Label for status or state (e.g. recruitment status). */
      public var state: CodeableConcept.Builder
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
       * An indication of whether or not the date is a known date when the state changed or will
       * change. A value of true indicates a known date. A value of false indicates an estimated
       * date.
       */
      public var `actual`: Boolean.Builder? = null

      /** Date range. */
      public var period: Period.Builder? = null

      public fun build(): ProgressStatus =
        ProgressStatus(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          state = state.build(),
          `actual` = `actual`?.build(),
          period = period?.build(),
        )
    }
  }

  /** Target or actual group of participants enrolled in study. */
  @Serializable(with = ResearchStudyRecruitmentSerializer::class)
  public data class Recruitment(
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
    /** Estimated total number of participants to be enrolled. */
    public val targetNumber: UnsignedInt? = null,
    /** Actual total number of participants enrolled in study. */
    public val actualNumber: UnsignedInt? = null,
    /** Inclusion and exclusion criteria. */
    public val eligibility: Reference? = null,
    /** Group of participants who were enrolled in study. */
    public val actualGroup: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          targetNumber = this@with.targetNumber?.toBuilder()
          actualNumber = this@with.actualNumber?.toBuilder()
          eligibility = this@with.eligibility?.toBuilder()
          actualGroup = this@with.actualGroup?.toBuilder()
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

      /** Estimated total number of participants to be enrolled. */
      public var targetNumber: UnsignedInt.Builder? = null

      /** Actual total number of participants enrolled in study. */
      public var actualNumber: UnsignedInt.Builder? = null

      /** Inclusion and exclusion criteria. */
      public var eligibility: Reference.Builder? = null

      /** Group of participants who were enrolled in study. */
      public var actualGroup: Reference.Builder? = null

      public fun build(): Recruitment =
        Recruitment(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          targetNumber = targetNumber?.build(),
          actualNumber = actualNumber?.build(),
          eligibility = eligibility?.build(),
          actualGroup = actualGroup?.build(),
        )
    }
  }

  /**
   * Describes an expected event or sequence of events for one of the subjects of a study. E.g. for
   * a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g.
   * for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from
   * lot A at 40 degrees for 1 month}.
   */
  @Serializable(with = ResearchStudyComparisonGroupSerializer::class)
  public data class ComparisonGroup(
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
     * Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked
     * easily.
     */
    public val linkId: Id? = null,
    /** Unique, human-readable label for this comparisonGroup of the study. */
    public val name: String,
    /**
     * Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo
     * comparater.
     */
    public val type: CodeableConcept? = null,
    /**
     * A succinct description of the path through the study that would be followed by a subject
     * adhering to this comparisonGroup.
     */
    public val description: Markdown? = null,
    /** Interventions or exposures in this comparisonGroup or cohort. */
    public val intendedExposure: List<Reference> = listOf(),
    /** Group of participants who were enrolled in study comparisonGroup. */
    public val observedGroup: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          linkId = this@with.linkId?.toBuilder()
          type = this@with.type?.toBuilder()
          description = this@with.description?.toBuilder()
          intendedExposure = this@with.intendedExposure.map { it.toBuilder() }.toMutableList()
          observedGroup = this@with.observedGroup?.toBuilder()
        }
      }

    public class Builder(
      /** Unique, human-readable label for this comparisonGroup of the study. */
      public var name: String.Builder
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
       * Allows the comparisonGroup for the study and the comparisonGroup for the subject to be
       * linked easily.
       */
      public var linkId: Id.Builder? = null

      /**
       * Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo
       * comparater.
       */
      public var type: CodeableConcept.Builder? = null

      /**
       * A succinct description of the path through the study that would be followed by a subject
       * adhering to this comparisonGroup.
       */
      public var description: Markdown.Builder? = null

      /** Interventions or exposures in this comparisonGroup or cohort. */
      public var intendedExposure: MutableList<Reference.Builder> = mutableListOf()

      /** Group of participants who were enrolled in study comparisonGroup. */
      public var observedGroup: Reference.Builder? = null

      public fun build(): ComparisonGroup =
        ComparisonGroup(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          linkId = linkId?.build(),
          name = name.build(),
          type = type?.build(),
          description = description?.build(),
          intendedExposure = intendedExposure.map { it.build() },
          observedGroup = observedGroup?.build(),
        )
    }
  }

  /**
   * A goal that the study is aiming to achieve in terms of a scientific question to be answered by
   * the analysis of data collected during the study.
   */
  @Serializable(with = ResearchStudyObjectiveSerializer::class)
  public data class Objective(
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
    /** Unique, human-readable label for this objective of the study. */
    public val name: String? = null,
    /** The kind of study objective. */
    public val type: CodeableConcept? = null,
    /**
     * Free text description of the objective of the study. This is what the study is trying to
     * achieve rather than how it is going to achieve it (see ResearchStudy.description).
     */
    public val description: Markdown? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          type = this@with.type?.toBuilder()
          description = this@with.description?.toBuilder()
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

      /** Unique, human-readable label for this objective of the study. */
      public var name: String.Builder? = null

      /** The kind of study objective. */
      public var type: CodeableConcept.Builder? = null

      /**
       * Free text description of the objective of the study. This is what the study is trying to
       * achieve rather than how it is going to achieve it (see ResearchStudy.description).
       */
      public var description: Markdown.Builder? = null

      public fun build(): Objective =
        Objective(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name?.build(),
          type = type?.build(),
          description = description?.build(),
        )
    }
  }

  /**
   * An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific
   * measurement or observation used to quantify the effect of experimental variables on the
   * participants in a study, or for observational studies, to describe patterns of diseases or
   * traits or associations with exposures, risk factors or treatment.
   */
  @Serializable(with = ResearchStudyOutcomeMeasureSerializer::class)
  public data class OutcomeMeasure(
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
    /** Label for the outcome. */
    public val name: String? = null,
    /**
     * The parameter or characteristic being assessed as one of the values by which the study is
     * assessed.
     */
    public val type: List<CodeableConcept> = listOf(),
    /** Description of the outcome. */
    public val description: Markdown? = null,
    /** Structured outcome definition. */
    public val reference: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          reference = this@with.reference?.toBuilder()
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

      /** Label for the outcome. */
      public var name: String.Builder? = null

      /**
       * The parameter or characteristic being assessed as one of the values by which the study is
       * assessed.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Description of the outcome. */
      public var description: Markdown.Builder? = null

      /** Structured outcome definition. */
      public var reference: Reference.Builder? = null

      public fun build(): OutcomeMeasure =
        OutcomeMeasure(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name?.build(),
          type = type.map { it.build() },
          description = description?.build(),
          reference = reference?.build(),
        )
    }
  }

  public class Builder(
    /** The publication state of the resource (not of the study). */
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

    /** Canonical identifier for this study resource, represented as a globally unique URI. */
    public var url: Uri.Builder? = null

    /** Identifiers assigned to this research study by the sponsor or other systems. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** The business version for the study record. */
    public var version: String.Builder? = null

    /** Name for this study (computer friendly). */
    public var name: String.Builder? = null

    /** The human readable name of the research study. */
    public var title: String.Builder? = null

    /** Additional names for the study. */
    public var label: MutableList<Label.Builder> = mutableListOf()

    /** The set of steps expected to be performed as part of the execution of the study. */
    public var protocol: MutableList<Reference.Builder> = mutableListOf()

    /** A larger research study of which this particular study is a component or step. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Citations, references, URLs and other related documents. When using relatedArtifact to share
     * URLs, the relatedArtifact.type will often be set to one of "documentation" or
     * "supported-with" and the URL value will often be in relatedArtifact.document.url but another
     * possible location is relatedArtifact.resource when it is a canonical URL.
     */
    public var relatedArtifact: MutableList<RelatedArtifact.Builder> = mutableListOf()

    /**
     * The date (and optionally time) when the ResearchStudy Resource was last significantly
     * changed. The date must change when the business version changes and it must change if the
     * status code changes. In addition, it should change when the substantive content of the
     * ResearchStudy Resource changes.
     */
    public var date: DateTime.Builder? = null

    /**
     * The type of study based upon the intent of the study activities. A classification of the
     * intent of the study.
     */
    public var primaryPurposeType: CodeableConcept.Builder? = null

    /**
     * The stage in the progression of a therapy from initial experimental use in humans in clinical
     * trials to post-market evaluation.
     */
    public var phase: CodeableConcept.Builder? = null

    /**
     * Codes categorizing the type of study such as investigational vs. observational, type of
     * blinding, type of randomization, safety vs. efficacy, etc.
     */
    public var studyDesign: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that
     * the study is seeking to gain more information about.
     */
    public var focus: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * The condition that is the focus of the study. For example, In a study to examine risk factors
     * for Lupus, might have as an inclusion criterion "healthy volunteer", but the target condition
     * code would be a Lupus SNOMED code.
     */
    public var condition: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Key terms to aid in searching for or filtering the study. */
    public var keyword: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A country, state or other area where the study is taking place rather than its precise
     * geographic location or address.
     */
    public var region: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** A brief text for explaining the study. */
    public var descriptionSummary: Markdown.Builder? = null

    /** A detailed and human-readable narrative of the study. E.g., study abstract. */
    public var description: Markdown.Builder? = null

    /**
     * Identifies the start date and the expected (or actual, depending on status) end date for the
     * study.
     */
    public var period: Period.Builder? = null

    /** A facility in which study activities are conducted. */
    public var site: MutableList<Reference.Builder> = mutableListOf()

    /** Comments made about the study by the performer, subject or other participants. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Additional grouping mechanism or categorization of a research study. Example: FDA regulated
     * device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc.
     * Implementation Note: do not use the classifier element to support existing semantics that are
     * already supported thru explicit elements in the resource.
     */
    public var classifier: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Sponsors, collaborators, and other parties.
     *
     * For a Sponsor or a PrincipalInvestigator use the dedicated attributes provided.
     */
    public var associatedParty: MutableList<AssociatedParty.Builder> = mutableListOf()

    /** Status of study with time for that status. */
    public var progressStatus: MutableList<ProgressStatus.Builder> = mutableListOf()

    /** A description and/or code explaining the premature termination of the study. */
    public var whyStopped: CodeableConcept.Builder? = null

    /** Target or actual group of participants enrolled in study. */
    public var recruitment: Recruitment.Builder? = null

    /**
     * Describes an expected event or sequence of events for one of the subjects of a study. E.g.
     * for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up.
     * E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store
     * sample from lot A at 40 degrees for 1 month}.
     *
     * In many clinical trials this is refered to as the ARM of the study, but such a term is not
     * used in other sorts of trials even when there is a comparison between two or more groups.
     */
    public var comparisonGroup: MutableList<ComparisonGroup.Builder> = mutableListOf()

    /**
     * A goal that the study is aiming to achieve in terms of a scientific question to be answered
     * by the analysis of data collected during the study.
     */
    public var objective: MutableList<Objective.Builder> = mutableListOf()

    /**
     * An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific
     * measurement or observation used to quantify the effect of experimental variables on the
     * participants in a study, or for observational studies, to describe patterns of diseases or
     * traits or associations with exposures, risk factors or treatment.
     *
     * A study may have multiple distinct outcome measures that can be used to assess the overall
     * goal for a study. The goal of a study is in the objective whereas the metric by which the
     * goal is assessed is the outcomeMeasure. Examples: Time to Local Recurrence (TLR),
     * Disease-free Survival (DFS), 30 Day Mortality, Systolic BP
     */
    public var outcomeMeasure: MutableList<OutcomeMeasure.Builder> = mutableListOf()

    /**
     * Link to one or more sets of results generated by the study. Could also link to a research
     * registry holding the results such as ClinicalTrials.gov.
     */
    public var result: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): ResearchStudy =
      ResearchStudy(
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
        label = label.map { it.build() },
        protocol = protocol.map { it.build() },
        partOf = partOf.map { it.build() },
        relatedArtifact = relatedArtifact.map { it.build() },
        date = date?.build(),
        status = status,
        primaryPurposeType = primaryPurposeType?.build(),
        phase = phase?.build(),
        studyDesign = studyDesign.map { it.build() },
        focus = focus.map { it.build() },
        condition = condition.map { it.build() },
        keyword = keyword.map { it.build() },
        region = region.map { it.build() },
        descriptionSummary = descriptionSummary?.build(),
        description = description?.build(),
        period = period?.build(),
        site = site.map { it.build() },
        note = note.map { it.build() },
        classifier = classifier.map { it.build() },
        associatedParty = associatedParty.map { it.build() },
        progressStatus = progressStatus.map { it.build() },
        whyStopped = whyStopped?.build(),
        recruitment = recruitment?.build(),
        comparisonGroup = comparisonGroup.map { it.build() },
        objective = objective.map { it.build() },
        outcomeMeasure = outcomeMeasure.map { it.build() },
        result = result.map { it.build() },
      )
  }
}
