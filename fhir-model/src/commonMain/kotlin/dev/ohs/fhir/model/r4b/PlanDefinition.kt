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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionConditionSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionDynamicValueSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionParticipantSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionRelatedActionOffsetSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionRelatedActionSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionSubjectSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionActionTimingSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionGoalSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionGoalTargetDetailSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionGoalTargetSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionSerializer
import dev.ohs.fhir.model.r4b.serializers.PlanDefinitionSubjectSerializer
import dev.ohs.fhir.model.r4b.terminologies.PublicationStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource allows for the definition of various types of plans as a sharable, consumable, and
 * executable artifact. The resource is general enough to support the description of a broad range
 * of clinical and non-clinical artifacts such as clinical decision support rules, order sets,
 * protocols, and drug quality specifications.
 */
@Serializable(with = PlanDefinitionSerializer::class)
@SerialName("PlanDefinition")
public data class PlanDefinition(
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
   * An absolute URI that is used to identify this plan definition when it is referenced in a
   * specification, model, design or an instance; also called its canonical identifier. This SHOULD
   * be globally unique and SHOULD be a literal address at which at which an authoritative instance
   * of this plan definition is (or will be) published. This URL can be the target of a canonical
   * reference. It SHALL remain the same when the plan definition is stored on different servers.
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
   * A formal identifier that is used to identify this plan definition when it is represented in
   * other formats, or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier) data
   * type, and can then identify this plan definition outside of FHIR, where it is not possible to
   * use the logical URI.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The identifier that is used to identify this version of the plan definition when it is
   * referenced in a specification, model, design or instance. This is an arbitrary value managed by
   * the plan definition author and is not expected to be globally unique. For example, it might be
   * a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation
   * that versions can be placed in a lexicographical sequence. To provide a version consistent with
   * the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0).
   * For more information on versioning knowledge assets, refer to the Decision Support Service
   * specification. Note that a version is required for non-experimental active artifacts.
   *
   * There may be different plan definition instances that have the same identifier but different
   * versions. The version can be appended to the url in a reference to allow a reference to a
   * particular business version of the plan definition with the format [url]|[version].
   */
  public val version: String? = null,
  /**
   * A natural language name identifying the plan definition. This name should be usable as an
   * identifier for the module by machine processing applications such as code generation.
   *
   * The name is not expected to be globally unique. The name should be a simple alphanumeric type
   * name to ensure that it is machine-processing friendly.
   */
  public val name: String? = null,
  /**
   * A short, descriptive, user-friendly title for the plan definition.
   *
   * This name does not need to be machine-processing friendly and may contain punctuation,
   * white-space, etc.
   */
  public val title: String? = null,
  /**
   * An explanatory or alternate title for the plan definition giving additional information about
   * its content.
   */
  public val subtitle: String? = null,
  /**
   * A high-level category for the plan definition that distinguishes the kinds of systems that
   * would be interested in the plan definition.
   */
  public val type: CodeableConcept? = null,
  /**
   * The status of this plan definition. Enables tracking the life-cycle of the content.
   *
   * Allows filtering of plan definitions that are appropriate for use versus not.
   */
  public val status: Enumeration<PublicationStatus>,
  /**
   * A Boolean value to indicate that this plan definition is authored for testing purposes (or
   * education/evaluation/marketing) and is not intended to be used for genuine usage.
   *
   * Allows filtering of plan definitions that are appropriate for use versus not.
   */
  public val experimental: Boolean? = null,
  /**
   * A code, group definition, or canonical reference that describes or identifies the intended
   * subject of the plan definition. Canonical references are allowed to support the definition of
   * protocols for drug and substance quality specifications, and is allowed to reference a
   * MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
   * ManufacturedItemDefinition, or PackagedProductDefinition resource.
   *
   * Note that the choice of canonical for the subject element was introduced in R4B to support
   * pharmaceutical quality use cases. To ensure as much backwards-compatibility as possible, it is
   * recommended to only use the new canonical type with these use cases.
   */
  public val subject: Subject? = null,
  /**
   * The date (and optionally time) when the plan definition was published. The date must change
   * when the business version changes and it must change if the status code changes. In addition,
   * it should change when the substantive content of the plan definition changes.
   *
   * Note that this is not the same as the resource last-modified-date, since the resource may be a
   * secondary representation of the plan definition. Additional specific dates may be added as
   * extensions or be found by consulting Provenances associated with past versions of the resource.
   */
  public val date: DateTime? = null,
  /**
   * The name of the organization or individual that published the plan definition.
   *
   * Usually an organization but may be an individual. The publisher (or steward) of the plan
   * definition is the organization or individual primarily responsible for the maintenance and
   * upkeep of the plan definition. This is not necessarily the same individual or organization that
   * developed and initially authored the content. The publisher is the primary point of contact for
   * questions or issues with the plan definition. This item SHOULD be populated unless the
   * information is available from context.
   */
  public val publisher: String? = null,
  /**
   * Contact details to assist a user in finding and communicating with the publisher.
   *
   * May be a web site, an email address, a telephone number, etc.
   */
  public val contact: List<ContactDetail> = listOf(),
  /**
   * A free text natural language description of the plan definition from a consumer's perspective.
   *
   * This description can be used to capture details such as why the plan definition was built,
   * comments about misuse, instructions for clinical use and interpretation, literature references,
   * examples from the paper world, etc. It is not a rendering of the plan definition as conveyed in
   * the 'text' field of the resource itself. This item SHOULD be populated unless the information
   * is available from context (e.g. the language of the plan definition is presumed to be the
   * predominant language in the place the plan definition was created).
   */
  public val description: Markdown? = null,
  /**
   * The content was developed with a focus and intent of supporting the contexts that are listed.
   * These contexts may be general categories (gender, age, ...) or may be references to specific
   * programs (insurance plans, studies, ...) and may be used to assist with indexing and searching
   * for appropriate plan definition instances.
   *
   * When multiple useContexts are specified, there is no expectation that all or any of the
   * contexts apply.
   */
  public val useContext: List<UsageContext> = listOf(),
  /**
   * A legal or geographic region in which the plan definition is intended to be used.
   *
   * It may be possible for the plan definition to be used in jurisdictions other than those for
   * which it was originally designed or intended.
   */
  public val jurisdiction: List<CodeableConcept> = listOf(),
  /**
   * Explanation of why this plan definition is needed and why it has been designed as it has.
   *
   * This element does not describe the usage of the plan definition. Instead, it provides
   * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
   * may be used to point to source materials or specifications that drove the structure of this
   * plan definition.
   */
  public val purpose: Markdown? = null,
  /** A detailed description of how the plan definition is used from a clinical perspective. */
  public val usage: String? = null,
  /**
   * A copyright statement relating to the plan definition and/or its contents. Copyright statements
   * are generally legal restrictions on the use and publishing of the plan definition.
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
   * The period during which the plan definition content was or is planned to be in active use.
   *
   * The effective period for a plan definition determines when the content is applicable for usage
   * and is independent of publication and review dates. For example, a measure intended to be used
   * for the year 2016 might be published in 2015.
   */
  public val effectivePeriod: Period? = null,
  /**
   * Descriptive topics related to the content of the plan definition. Topics provide a high-level
   * categorization of the definition that can be useful for filtering and searching.
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
  /** A reference to a Library resource containing any formal logic used by the plan definition. */
  public val library: List<Canonical> = listOf(),
  /**
   * A goal describes an expected outcome that activities within the plan are intended to achieve.
   * For example, weight loss, restoring an activity of daily living, obtaining herd immunity via
   * immunization, meeting a process improvement objective, meeting the acceptance criteria for a
   * test as specified by a quality specification, etc.
   */
  public val goal: List<Goal> = listOf(),
  /**
   * An action or group of actions to be taken as part of the plan. For example, in clinical care,
   * an action would be to prescribe a particular indicated medication, or perform a particular test
   * as appropriate. In pharmaceutical quality, an action would be the test that needs to be
   * performed on a drug product as defined in the quality specification.
   *
   * Note that there is overlap between many of the elements defined here and the ActivityDefinition
   * resource. When an ActivityDefinition is referenced (using the definition element), the
   * overlapping elements in the plan override the content of the referenced ActivityDefinition
   * unless otherwise documented in the specific elements. See the PlanDefinition resource for more
   * detailed information.
   */
  public val action: List<Action> = listOf(),
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
        subtitle = this@with.subtitle?.toBuilder()
        type = this@with.type?.toBuilder()
        experimental = this@with.experimental?.toBuilder()
        subject = this@with.subject
        date = this@with.date?.toBuilder()
        publisher = this@with.publisher?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        description = this@with.description?.toBuilder()
        useContext = this@with.useContext.map { it.toBuilder() }.toMutableList()
        jurisdiction = this@with.jurisdiction.map { it.toBuilder() }.toMutableList()
        purpose = this@with.purpose?.toBuilder()
        usage = this@with.usage?.toBuilder()
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
        library = this@with.library.map { it.toBuilder() }.toMutableList()
        goal = this@with.goal.map { it.toBuilder() }.toMutableList()
        action = this@with.action.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * A goal describes an expected outcome that activities within the plan are intended to achieve.
   * For example, weight loss, restoring an activity of daily living, obtaining herd immunity via
   * immunization, meeting a process improvement objective, meeting the acceptance criteria for a
   * test as specified by a quality specification, etc.
   */
  @Serializable(with = PlanDefinitionGoalSerializer::class)
  public data class Goal(
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
    /** Indicates a category the goal falls within. */
    public val category: CodeableConcept? = null,
    /**
     * Human-readable and/or coded description of a specific desired objective of care, such as
     * "control blood pressure" or "negotiate an obstacle course" or "dance with child at wedding".
     *
     * If no code is available, use CodeableConcept.text.
     */
    public val description: CodeableConcept,
    /**
     * Identifies the expected level of importance associated with reaching/sustaining the defined
     * goal.
     */
    public val priority: CodeableConcept? = null,
    /** The event after which the goal should begin being pursued. */
    public val start: CodeableConcept? = null,
    /** Identifies problems, conditions, issues, or concerns the goal is intended to address. */
    public val addresses: List<CodeableConcept> = listOf(),
    /**
     * Didactic or other informational resources associated with the goal that provide further
     * supporting information about the goal. Information resources can include inline text
     * commentary and links to web resources.
     */
    public val documentation: List<RelatedArtifact> = listOf(),
    /** Indicates what should be done and within what timeframe. */
    public val target: List<Target> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(description.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          category = this@with.category?.toBuilder()
          priority = this@with.priority?.toBuilder()
          start = this@with.start?.toBuilder()
          addresses = this@with.addresses.map { it.toBuilder() }.toMutableList()
          documentation = this@with.documentation.map { it.toBuilder() }.toMutableList()
          target = this@with.target.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Indicates what should be done and within what timeframe. */
    @Serializable(with = PlanDefinitionGoalTargetSerializer::class)
    public data class Target(
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
      /**
       * The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin
       * A1c level.
       */
      public val measure: CodeableConcept? = null,
      /**
       * The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150
       * pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc.
       * Either the high or low or both values of the range can be specified. When a low value is
       * missing, it indicates that the goal is achieved at any value at or below the high value.
       * Similarly, if the high value is missing, it indicates that the goal is achieved at any
       * value at or above the low value.
       */
      public val detail: Detail? = null,
      /** Indicates the timeframe after the start of the goal in which the goal should be met. */
      public val due: Duration? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            measure = this@with.measure?.toBuilder()
            detail = this@with.detail
            due = this@with.due?.toBuilder()
          }
        }

      @Serializable(with = PlanDefinitionGoalTargetDetailSerializer::class)
      public sealed interface Detail {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRange(): Range? = this as? Range

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r4b.Quantity) : Detail

        public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Detail

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
        ) : Detail

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r4b.Quantity?,
            rangeValue: dev.ohs.fhir.model.r4b.Range?,
            codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
          ): Detail? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (rangeValue != null) return Range(rangeValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            return null
          }
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

        /**
         * The parameter whose value is to be tracked, e.g. body weight, blood pressure, or
         * hemoglobin A1c level.
         */
        public var measure: CodeableConcept.Builder? = null

        /**
         * The target value of the measure to be achieved to signify fulfillment of the goal, e.g.
         * 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution,
         * etc. Either the high or low or both values of the range can be specified. When a low
         * value is missing, it indicates that the goal is achieved at any value at or below the
         * high value. Similarly, if the high value is missing, it indicates that the goal is
         * achieved at any value at or above the low value.
         */
        public var detail: Detail? = null

        /** Indicates the timeframe after the start of the goal in which the goal should be met. */
        public var due: Duration.Builder? = null

        public fun build(): Target =
          Target(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            measure = measure?.build(),
            detail = detail,
            due = due?.build(),
          )
      }
    }

    public class Builder(
      /**
       * Human-readable and/or coded description of a specific desired objective of care, such as
       * "control blood pressure" or "negotiate an obstacle course" or "dance with child at
       * wedding".
       *
       * If no code is available, use CodeableConcept.text.
       */
      public var description: CodeableConcept.Builder
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

      /** Indicates a category the goal falls within. */
      public var category: CodeableConcept.Builder? = null

      /**
       * Identifies the expected level of importance associated with reaching/sustaining the defined
       * goal.
       */
      public var priority: CodeableConcept.Builder? = null

      /** The event after which the goal should begin being pursued. */
      public var start: CodeableConcept.Builder? = null

      /** Identifies problems, conditions, issues, or concerns the goal is intended to address. */
      public var addresses: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Didactic or other informational resources associated with the goal that provide further
       * supporting information about the goal. Information resources can include inline text
       * commentary and links to web resources.
       */
      public var documentation: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /** Indicates what should be done and within what timeframe. */
      public var target: MutableList<Target.Builder> = mutableListOf()

      public fun build(): Goal =
        Goal(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          category = category?.build(),
          description = description.build(),
          priority = priority?.build(),
          start = start?.build(),
          addresses = addresses.map { it.build() },
          documentation = documentation.map { it.build() },
          target = target.map { it.build() },
        )
    }
  }

  /**
   * An action or group of actions to be taken as part of the plan. For example, in clinical care,
   * an action would be to prescribe a particular indicated medication, or perform a particular test
   * as appropriate. In pharmaceutical quality, an action would be the test that needs to be
   * performed on a drug product as defined in the quality specification.
   */
  @Serializable(with = PlanDefinitionActionSerializer::class)
  public data class Action(
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
    /** A user-visible prefix for the action. */
    public val prefix: String? = null,
    /**
     * The textual description of the action displayed to a user. For example, when the action is a
     * test to be performed, the title would be the title of the test such as Assay by HPLC.
     */
    public val title: String? = null,
    /** A brief description of the action used to provide a summary to display to the user. */
    public val description: String? = null,
    /**
     * A text equivalent of the action to be performed. This provides a human-interpretable
     * description of the action when the definition is consumed by a system that might not be
     * capable of interpreting it dynamically.
     */
    public val textEquivalent: String? = null,
    /** Indicates how quickly the action should be addressed with respect to other actions. */
    public val priority: Enumeration<RequestPriority>? = null,
    /**
     * A code that provides a meaning, grouping, or classification for the action or action group.
     * For example, a section may have a LOINC code for the section of a documentation template. In
     * pharmaceutical quality, an action (Test) such as pH could be classified as a physical
     * property.
     */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * A description of why this action is necessary or appropriate.
     *
     * This is different than the clinical evidence documentation, it's an actual business
     * description of the reason for performing the action.
     */
    public val reason: List<CodeableConcept> = listOf(),
    /**
     * Didactic or other informational resources associated with the action that can be provided to
     * the CDS recipient. Information resources can include inline text commentary and links to web
     * resources.
     */
    public val documentation: List<RelatedArtifact> = listOf(),
    /**
     * Identifies goals that this action supports. The reference must be to a goal element defined
     * within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria
     * (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal
     * element establishing the acceptance criteria for the action.
     */
    public val goalId: List<Id> = listOf(),
    /**
     * A code, group definition, or canonical reference that describes the intended subject of the
     * action and its children, if any. Canonical references are allowed to support the definition
     * of protocols for drug and substance quality specifications, and is allowed to reference a
     * MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
     * ManufacturedItemDefinition, or PackagedProductDefinition resource.
     *
     * The subject of an action overrides the subject at a parent action or on the root of the
     * PlanDefinition if specified.
     *
     * In addition, because the subject needs to be resolved during realization, use of subjects in
     * actions (or in the ActivityDefinition referenced by the action) resolves based on the set of
     * subjects supplied in context and by type (i.e. the patient subject would resolve to a
     * resource of type Patient).
     */
    public val subject: Subject? = null,
    /** A description of when the action should be triggered. */
    public val trigger: List<TriggerDefinition> = listOf(),
    /**
     * An expression that describes applicability criteria or start/stop conditions for the action.
     *
     * When multiple conditions of the same kind are present, the effects are combined using AND
     * semantics, so the overall condition is true only if all the conditions are true.
     */
    public val condition: List<Condition> = listOf(),
    /** Defines input data requirements for the action. */
    public val input: List<DataRequirement> = listOf(),
    /** Defines the outputs of the action, if any. */
    public val output: List<DataRequirement> = listOf(),
    /**
     * A relationship to another action such as "before" or "30-60 minutes after start of".
     *
     * When an action depends on multiple actions, the meaning is that all actions are dependencies,
     * rather than that any of the actions are a dependency.
     */
    public val relatedAction: List<RelatedAction> = listOf(),
    /** An optional value describing when the action should be performed. */
    public val timing: Timing? = null,
    /** Indicates who should participate in performing the action described. */
    public val participant: List<Participant> = listOf(),
    /** The type of action to perform (create, update, remove). */
    public val type: CodeableConcept? = null,
    /** Defines the grouping behavior for the action and its children. */
    public val groupingBehavior: Enumeration<ActionGroupingBehavior>? = null,
    /** Defines the selection behavior for the action and its children. */
    public val selectionBehavior: Enumeration<ActionSelectionBehavior>? = null,
    /** Defines the required behavior for the action. */
    public val requiredBehavior: Enumeration<ActionRequiredBehavior>? = null,
    /** Defines whether the action should usually be preselected. */
    public val precheckBehavior: Enumeration<ActionPrecheckBehavior>? = null,
    /** Defines whether the action can be selected multiple times. */
    public val cardinalityBehavior: Enumeration<ActionCardinalityBehavior>? = null,
    /**
     * A reference to an ActivityDefinition that describes the action to be taken in detail, or a
     * PlanDefinition that describes a series of actions to be taken.
     *
     * Note that the definition is optional, and if no definition is specified, a dynamicValue with
     * a root ($this) path can be used to define the entire resource dynamically.
     */
    public val definition: Definition? = null,
    /**
     * A reference to a StructureMap resource that defines a transform that can be executed to
     * produce the intent resource using the ActivityDefinition instance as the input.
     *
     * Note that when a referenced ActivityDefinition also defines a transform, the transform
     * specified here generally takes precedence. In addition, if both a transform and dynamic
     * values are specific, the dynamic values are applied to the result of the transform.
     */
    public val transform: Canonical? = null,
    /**
     * Customizations that should be applied to the statically defined resource. For example, if the
     * dosage of a medication must be computed based on the patient's weight, a customization would
     * be used to specify an expression that calculated the weight, and the path on the resource
     * that would contain the result.
     *
     * Dynamic values are applied in the order in which they are defined in the PlanDefinition
     * resource. Note that when dynamic values are also specified by a referenced
     * ActivityDefinition, the dynamicValues from the ActivityDefinition are applied first, followed
     * by the dynamicValues specified here. In addition, if both a transform and dynamic values are
     * specific, the dynamic values are applied to the result of the transform.
     */
    public val dynamicValue: List<DynamicValue> = listOf(),
    /**
     * Sub actions that are contained within the action. The behavior of this action determines the
     * functionality of the sub-actions. For example, a selection behavior of at-most-one indicates
     * that of the sub-actions, at most one may be chosen as part of realizing the action
     * definition.
     */
    public val action: List<Action> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          prefix = this@with.prefix?.toBuilder()
          title = this@with.title?.toBuilder()
          description = this@with.description?.toBuilder()
          textEquivalent = this@with.textEquivalent?.toBuilder()
          priority = this@with.priority
          code = this@with.code.map { it.toBuilder() }.toMutableList()
          reason = this@with.reason.map { it.toBuilder() }.toMutableList()
          documentation = this@with.documentation.map { it.toBuilder() }.toMutableList()
          goalId = this@with.goalId.map { it.toBuilder() }.toMutableList()
          subject = this@with.subject
          trigger = this@with.trigger.map { it.toBuilder() }.toMutableList()
          condition = this@with.condition.map { it.toBuilder() }.toMutableList()
          input = this@with.input.map { it.toBuilder() }.toMutableList()
          output = this@with.output.map { it.toBuilder() }.toMutableList()
          relatedAction = this@with.relatedAction.map { it.toBuilder() }.toMutableList()
          timing = this@with.timing
          participant = this@with.participant.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          groupingBehavior = this@with.groupingBehavior
          selectionBehavior = this@with.selectionBehavior
          requiredBehavior = this@with.requiredBehavior
          precheckBehavior = this@with.precheckBehavior
          cardinalityBehavior = this@with.cardinalityBehavior
          definition = this@with.definition
          transform = this@with.transform?.toBuilder()
          dynamicValue = this@with.dynamicValue.map { it.toBuilder() }.toMutableList()
          action = this@with.action.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * An expression that describes applicability criteria or start/stop conditions for the action.
     */
    @Serializable(with = PlanDefinitionActionConditionSerializer::class)
    public data class Condition(
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
      /**
       * The kind of condition.
       *
       * Applicability criteria are used to determine immediate applicability when a plan definition
       * is applied to a given context. Start and stop criteria are carried through application and
       * used to describe enter/exit criteria for an action.
       */
      public val kind: Enumeration<ActionConditionKind>,
      /**
       * An expression that returns true or false, indicating whether the condition is satisfied.
       *
       * The expression may be inlined or may be a reference to a named expression within a logic
       * library referenced by the library element.
       */
      public val expression: Expression? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(kind).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            expression = this@with.expression?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The kind of condition.
         *
         * Applicability criteria are used to determine immediate applicability when a plan
         * definition is applied to a given context. Start and stop criteria are carried through
         * application and used to describe enter/exit criteria for an action.
         */
        public var kind: Enumeration<ActionConditionKind>
      ) {
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

        /**
         * An expression that returns true or false, indicating whether the condition is satisfied.
         *
         * The expression may be inlined or may be a reference to a named expression within a logic
         * library referenced by the library element.
         */
        public var expression: Expression.Builder? = null

        public fun build(): Condition =
          Condition(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            kind = kind,
            expression = expression?.build(),
          )
      }
    }

    /** A relationship to another action such as "before" or "30-60 minutes after start of". */
    @Serializable(with = PlanDefinitionActionRelatedActionSerializer::class)
    public data class RelatedAction(
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
      /** The element id of the related action. */
      public val actionId: Id,
      /** The relationship of this action to the related action. */
      public val relationship: Enumeration<ActionRelationshipType>,
      /**
       * A duration or range of durations to apply to the relationship. For example, 30-60 minutes
       * before.
       */
      public val offset: Offset? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(actionId.toBuilder(), relationship).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            offset = this@with.offset
          }
        }

      @Serializable(with = PlanDefinitionActionRelatedActionOffsetSerializer::class)
      public sealed interface Offset {
        public fun asDuration(): Duration? = this as? Duration

        public fun asRange(): Range? = this as? Range

        public data class Duration(public val `value`: dev.ohs.fhir.model.r4b.Duration) : Offset

        public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Offset

        public companion object {
          internal fun from(
            durationValue: dev.ohs.fhir.model.r4b.Duration?,
            rangeValue: dev.ohs.fhir.model.r4b.Range?,
          ): Offset? {
            if (durationValue != null) return Duration(durationValue)
            if (rangeValue != null) return Range(rangeValue)
            return null
          }
        }
      }

      public class Builder(
        /** The element id of the related action. */
        public var actionId: Id.Builder,
        /** The relationship of this action to the related action. */
        public var relationship: Enumeration<ActionRelationshipType>,
      ) {
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

        /**
         * A duration or range of durations to apply to the relationship. For example, 30-60 minutes
         * before.
         */
        public var offset: Offset? = null

        public fun build(): RelatedAction =
          RelatedAction(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            actionId = actionId.build(),
            relationship = relationship,
            offset = offset,
          )
      }
    }

    /** Indicates who should participate in performing the action described. */
    @Serializable(with = PlanDefinitionActionParticipantSerializer::class)
    public data class Participant(
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
      /** The type of participant in the action. */
      public val type: Enumeration<ActionParticipantType>,
      /** The role the participant should play in performing the described action. */
      public val role: CodeableConcept? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            role = this@with.role?.toBuilder()
          }
        }

      public class Builder(
        /** The type of participant in the action. */
        public var type: Enumeration<ActionParticipantType>
      ) {
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

        /** The role the participant should play in performing the described action. */
        public var role: CodeableConcept.Builder? = null

        public fun build(): Participant =
          Participant(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type,
            role = role?.build(),
          )
      }
    }

    /**
     * Customizations that should be applied to the statically defined resource. For example, if the
     * dosage of a medication must be computed based on the patient's weight, a customization would
     * be used to specify an expression that calculated the weight, and the path on the resource
     * that would contain the result.
     */
    @Serializable(with = PlanDefinitionActionDynamicValueSerializer::class)
    public data class DynamicValue(
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
      /**
       * The path to the element to be customized. This is the path on the resource that will hold
       * the result of the calculation defined by the expression. The specified path SHALL be a
       * FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL
       * consist only of identifiers, constant indexers, and a restricted subset of functions. The
       * path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers
       * ([x]) to traverse multiple-cardinality sub-elements (see the
       * [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
       *
       * To specify the path to the current action being realized, the %action environment variable
       * is available in this path. For example, to specify the description element of the target
       * action, the path would be %action.description. The path attribute contains a
       * [Simple FHIRPath Subset](fhirpath.html#simple) that allows path traversal, but not
       * calculation.
       */
      public val path: String? = null,
      /**
       * An expression specifying the value of the customized element.
       *
       * The expression may be inlined or may be a reference to a named expression within a logic
       * library referenced by the library element.
       */
      public val expression: Expression? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            path = this@with.path?.toBuilder()
            expression = this@with.expression?.toBuilder()
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

        /**
         * The path to the element to be customized. This is the path on the resource that will hold
         * the result of the calculation defined by the expression. The specified path SHALL be a
         * FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL
         * consist only of identifiers, constant indexers, and a restricted subset of functions. The
         * path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers
         * ([x]) to traverse multiple-cardinality sub-elements (see the
         * [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         *
         * To specify the path to the current action being realized, the %action environment
         * variable is available in this path. For example, to specify the description element of
         * the target action, the path would be %action.description. The path attribute contains a
         * [Simple FHIRPath Subset](fhirpath.html#simple) that allows path traversal, but not
         * calculation.
         */
        public var path: String.Builder? = null

        /**
         * An expression specifying the value of the customized element.
         *
         * The expression may be inlined or may be a reference to a named expression within a logic
         * library referenced by the library element.
         */
        public var expression: Expression.Builder? = null

        public fun build(): DynamicValue =
          DynamicValue(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            path = path?.build(),
            expression = expression?.build(),
          )
      }
    }

    @Serializable(with = PlanDefinitionActionSubjectSerializer::class)
    public sealed interface Subject {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public fun asCanonical(): Canonical? = this as? Canonical

      public data class CodeableConcept(
        public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
      ) : Subject

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Subject

      public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Subject

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
          canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
        ): Subject? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          return null
        }
      }
    }

    @Serializable(with = PlanDefinitionActionTimingSerializer::class)
    public sealed interface Timing {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asAge(): Age? = this as? Age

      public fun asPeriod(): Period? = this as? Period

      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asTiming(): Timing? = this as? Timing

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) :
        Action.Timing

      public data class Age(public val `value`: dev.ohs.fhir.model.r4b.Age) : Action.Timing

      public data class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Action.Timing

      public data class Duration(public val `value`: dev.ohs.fhir.model.r4b.Duration) :
        Action.Timing

      public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Action.Timing

      public data class Timing(public val `value`: dev.ohs.fhir.model.r4b.Timing) : Action.Timing

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
          ageValue: dev.ohs.fhir.model.r4b.Age?,
          periodValue: dev.ohs.fhir.model.r4b.Period?,
          durationValue: dev.ohs.fhir.model.r4b.Duration?,
          rangeValue: dev.ohs.fhir.model.r4b.Range?,
          timingValue: dev.ohs.fhir.model.r4b.Timing?,
        ): Action.Timing? {
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (ageValue != null) return Age(ageValue)
          if (periodValue != null) return Period(periodValue)
          if (durationValue != null) return Duration(durationValue)
          if (rangeValue != null) return Range(rangeValue)
          if (timingValue != null) return Timing(timingValue)
          return null
        }
      }
    }

    @Serializable(with = PlanDefinitionActionDefinitionSerializer::class)
    public sealed interface Definition {
      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asUri(): Uri? = this as? Uri

      public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) :
        Definition

      public data class Uri(public val `value`: dev.ohs.fhir.model.r4b.Uri) : Definition

      public companion object {
        internal fun from(
          canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
          uriValue: dev.ohs.fhir.model.r4b.Uri?,
        ): Definition? {
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (uriValue != null) return Uri(uriValue)
          return null
        }
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

      /** A user-visible prefix for the action. */
      public var prefix: String.Builder? = null

      /**
       * The textual description of the action displayed to a user. For example, when the action is
       * a test to be performed, the title would be the title of the test such as Assay by HPLC.
       */
      public var title: String.Builder? = null

      /** A brief description of the action used to provide a summary to display to the user. */
      public var description: String.Builder? = null

      /**
       * A text equivalent of the action to be performed. This provides a human-interpretable
       * description of the action when the definition is consumed by a system that might not be
       * capable of interpreting it dynamically.
       */
      public var textEquivalent: String.Builder? = null

      /** Indicates how quickly the action should be addressed with respect to other actions. */
      public var priority: Enumeration<RequestPriority>? = null

      /**
       * A code that provides a meaning, grouping, or classification for the action or action group.
       * For example, a section may have a LOINC code for the section of a documentation template.
       * In pharmaceutical quality, an action (Test) such as pH could be classified as a physical
       * property.
       */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * A description of why this action is necessary or appropriate.
       *
       * This is different than the clinical evidence documentation, it's an actual business
       * description of the reason for performing the action.
       */
      public var reason: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Didactic or other informational resources associated with the action that can be provided
       * to the CDS recipient. Information resources can include inline text commentary and links to
       * web resources.
       */
      public var documentation: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /**
       * Identifies goals that this action supports. The reference must be to a goal element defined
       * within this plan definition. In pharmaceutical quality, a goal represents acceptance
       * criteria (Goal) for a given action (Test), so the goalId would be the unique id of a
       * defined goal element establishing the acceptance criteria for the action.
       */
      public var goalId: MutableList<Id.Builder> = mutableListOf()

      /**
       * A code, group definition, or canonical reference that describes the intended subject of the
       * action and its children, if any. Canonical references are allowed to support the definition
       * of protocols for drug and substance quality specifications, and is allowed to reference a
       * MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
       * ManufacturedItemDefinition, or PackagedProductDefinition resource.
       *
       * The subject of an action overrides the subject at a parent action or on the root of the
       * PlanDefinition if specified.
       *
       * In addition, because the subject needs to be resolved during realization, use of subjects
       * in actions (or in the ActivityDefinition referenced by the action) resolves based on the
       * set of subjects supplied in context and by type (i.e. the patient subject would resolve to
       * a resource of type Patient).
       */
      public var subject: Subject? = null

      /** A description of when the action should be triggered. */
      public var trigger: MutableList<TriggerDefinition.Builder> = mutableListOf()

      /**
       * An expression that describes applicability criteria or start/stop conditions for the
       * action.
       *
       * When multiple conditions of the same kind are present, the effects are combined using AND
       * semantics, so the overall condition is true only if all the conditions are true.
       */
      public var condition: MutableList<Condition.Builder> = mutableListOf()

      /** Defines input data requirements for the action. */
      public var input: MutableList<DataRequirement.Builder> = mutableListOf()

      /** Defines the outputs of the action, if any. */
      public var output: MutableList<DataRequirement.Builder> = mutableListOf()

      /**
       * A relationship to another action such as "before" or "30-60 minutes after start of".
       *
       * When an action depends on multiple actions, the meaning is that all actions are
       * dependencies, rather than that any of the actions are a dependency.
       */
      public var relatedAction: MutableList<RelatedAction.Builder> = mutableListOf()

      /** An optional value describing when the action should be performed. */
      public var timing: Timing? = null

      /** Indicates who should participate in performing the action described. */
      public var participant: MutableList<Participant.Builder> = mutableListOf()

      /** The type of action to perform (create, update, remove). */
      public var type: CodeableConcept.Builder? = null

      /** Defines the grouping behavior for the action and its children. */
      public var groupingBehavior: Enumeration<ActionGroupingBehavior>? = null

      /** Defines the selection behavior for the action and its children. */
      public var selectionBehavior: Enumeration<ActionSelectionBehavior>? = null

      /** Defines the required behavior for the action. */
      public var requiredBehavior: Enumeration<ActionRequiredBehavior>? = null

      /** Defines whether the action should usually be preselected. */
      public var precheckBehavior: Enumeration<ActionPrecheckBehavior>? = null

      /** Defines whether the action can be selected multiple times. */
      public var cardinalityBehavior: Enumeration<ActionCardinalityBehavior>? = null

      /**
       * A reference to an ActivityDefinition that describes the action to be taken in detail, or a
       * PlanDefinition that describes a series of actions to be taken.
       *
       * Note that the definition is optional, and if no definition is specified, a dynamicValue
       * with a root ($this) path can be used to define the entire resource dynamically.
       */
      public var definition: Definition? = null

      /**
       * A reference to a StructureMap resource that defines a transform that can be executed to
       * produce the intent resource using the ActivityDefinition instance as the input.
       *
       * Note that when a referenced ActivityDefinition also defines a transform, the transform
       * specified here generally takes precedence. In addition, if both a transform and dynamic
       * values are specific, the dynamic values are applied to the result of the transform.
       */
      public var transform: Canonical.Builder? = null

      /**
       * Customizations that should be applied to the statically defined resource. For example, if
       * the dosage of a medication must be computed based on the patient's weight, a customization
       * would be used to specify an expression that calculated the weight, and the path on the
       * resource that would contain the result.
       *
       * Dynamic values are applied in the order in which they are defined in the PlanDefinition
       * resource. Note that when dynamic values are also specified by a referenced
       * ActivityDefinition, the dynamicValues from the ActivityDefinition are applied first,
       * followed by the dynamicValues specified here. In addition, if both a transform and dynamic
       * values are specific, the dynamic values are applied to the result of the transform.
       */
      public var dynamicValue: MutableList<DynamicValue.Builder> = mutableListOf()

      /**
       * Sub actions that are contained within the action. The behavior of this action determines
       * the functionality of the sub-actions. For example, a selection behavior of at-most-one
       * indicates that of the sub-actions, at most one may be chosen as part of realizing the
       * action definition.
       */
      public var action: MutableList<Builder> = mutableListOf()

      public fun build(): Action =
        Action(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          prefix = prefix?.build(),
          title = title?.build(),
          description = description?.build(),
          textEquivalent = textEquivalent?.build(),
          priority = priority,
          code = code.map { it.build() },
          reason = reason.map { it.build() },
          documentation = documentation.map { it.build() },
          goalId = goalId.map { it.build() },
          subject = subject,
          trigger = trigger.map { it.build() },
          condition = condition.map { it.build() },
          input = input.map { it.build() },
          output = output.map { it.build() },
          relatedAction = relatedAction.map { it.build() },
          timing = timing,
          participant = participant.map { it.build() },
          type = type?.build(),
          groupingBehavior = groupingBehavior,
          selectionBehavior = selectionBehavior,
          requiredBehavior = requiredBehavior,
          precheckBehavior = precheckBehavior,
          cardinalityBehavior = cardinalityBehavior,
          definition = definition,
          transform = transform?.build(),
          dynamicValue = dynamicValue.map { it.build() },
          action = action.map { it.build() },
        )
    }
  }

  @Serializable(with = PlanDefinitionSubjectSerializer::class)
  public sealed interface Subject {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public fun asCanonical(): Canonical? = this as? Canonical

    public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept) :
      Subject

    public data class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Subject

    public data class Canonical(public val `value`: dev.ohs.fhir.model.r4b.Canonical) : Subject

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4b.Reference?,
        canonicalValue: dev.ohs.fhir.model.r4b.Canonical?,
      ): Subject? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (canonicalValue != null) return Canonical(canonicalValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The status of this plan definition. Enables tracking the life-cycle of the content.
     *
     * Allows filtering of plan definitions that are appropriate for use versus not.
     */
    public var status: Enumeration<PublicationStatus>
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
     * An absolute URI that is used to identify this plan definition when it is referenced in a
     * specification, model, design or an instance; also called its canonical identifier. This
     * SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative
     * instance of this plan definition is (or will be) published. This URL can be the target of a
     * canonical reference. It SHALL remain the same when the plan definition is stored on different
     * servers.
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
     * A formal identifier that is used to identify this plan definition when it is represented in
     * other formats, or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II (instance identifier)
     * data type, and can then identify this plan definition outside of FHIR, where it is not
     * possible to use the logical URI.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The identifier that is used to identify this version of the plan definition when it is
     * referenced in a specification, model, design or instance. This is an arbitrary value managed
     * by the plan definition author and is not expected to be globally unique. For example, it
     * might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no
     * expectation that versions can be placed in a lexicographical sequence. To provide a version
     * consistent with the Decision Support Service specification, use the format
     * Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer
     * to the Decision Support Service specification. Note that a version is required for
     * non-experimental active artifacts.
     *
     * There may be different plan definition instances that have the same identifier but different
     * versions. The version can be appended to the url in a reference to allow a reference to a
     * particular business version of the plan definition with the format [url]|[version].
     */
    public var version: String.Builder? = null

    /**
     * A natural language name identifying the plan definition. This name should be usable as an
     * identifier for the module by machine processing applications such as code generation.
     *
     * The name is not expected to be globally unique. The name should be a simple alphanumeric type
     * name to ensure that it is machine-processing friendly.
     */
    public var name: String.Builder? = null

    /**
     * A short, descriptive, user-friendly title for the plan definition.
     *
     * This name does not need to be machine-processing friendly and may contain punctuation,
     * white-space, etc.
     */
    public var title: String.Builder? = null

    /**
     * An explanatory or alternate title for the plan definition giving additional information about
     * its content.
     */
    public var subtitle: String.Builder? = null

    /**
     * A high-level category for the plan definition that distinguishes the kinds of systems that
     * would be interested in the plan definition.
     */
    public var type: CodeableConcept.Builder? = null

    /**
     * A Boolean value to indicate that this plan definition is authored for testing purposes (or
     * education/evaluation/marketing) and is not intended to be used for genuine usage.
     *
     * Allows filtering of plan definitions that are appropriate for use versus not.
     */
    public var experimental: Boolean.Builder? = null

    /**
     * A code, group definition, or canonical reference that describes or identifies the intended
     * subject of the plan definition. Canonical references are allowed to support the definition of
     * protocols for drug and substance quality specifications, and is allowed to reference a
     * MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition,
     * ManufacturedItemDefinition, or PackagedProductDefinition resource.
     *
     * Note that the choice of canonical for the subject element was introduced in R4B to support
     * pharmaceutical quality use cases. To ensure as much backwards-compatibility as possible, it
     * is recommended to only use the new canonical type with these use cases.
     */
    public var subject: Subject? = null

    /**
     * The date (and optionally time) when the plan definition was published. The date must change
     * when the business version changes and it must change if the status code changes. In addition,
     * it should change when the substantive content of the plan definition changes.
     *
     * Note that this is not the same as the resource last-modified-date, since the resource may be
     * a secondary representation of the plan definition. Additional specific dates may be added as
     * extensions or be found by consulting Provenances associated with past versions of the
     * resource.
     */
    public var date: DateTime.Builder? = null

    /**
     * The name of the organization or individual that published the plan definition.
     *
     * Usually an organization but may be an individual. The publisher (or steward) of the plan
     * definition is the organization or individual primarily responsible for the maintenance and
     * upkeep of the plan definition. This is not necessarily the same individual or organization
     * that developed and initially authored the content. The publisher is the primary point of
     * contact for questions or issues with the plan definition. This item SHOULD be populated
     * unless the information is available from context.
     */
    public var publisher: String.Builder? = null

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     *
     * May be a web site, an email address, a telephone number, etc.
     */
    public var contact: MutableList<ContactDetail.Builder> = mutableListOf()

    /**
     * A free text natural language description of the plan definition from a consumer's
     * perspective.
     *
     * This description can be used to capture details such as why the plan definition was built,
     * comments about misuse, instructions for clinical use and interpretation, literature
     * references, examples from the paper world, etc. It is not a rendering of the plan definition
     * as conveyed in the 'text' field of the resource itself. This item SHOULD be populated unless
     * the information is available from context (e.g. the language of the plan definition is
     * presumed to be the predominant language in the place the plan definition was created).
     */
    public var description: Markdown.Builder? = null

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed.
     * These contexts may be general categories (gender, age, ...) or may be references to specific
     * programs (insurance plans, studies, ...) and may be used to assist with indexing and
     * searching for appropriate plan definition instances.
     *
     * When multiple useContexts are specified, there is no expectation that all or any of the
     * contexts apply.
     */
    public var useContext: MutableList<UsageContext.Builder> = mutableListOf()

    /**
     * A legal or geographic region in which the plan definition is intended to be used.
     *
     * It may be possible for the plan definition to be used in jurisdictions other than those for
     * which it was originally designed or intended.
     */
    public var jurisdiction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Explanation of why this plan definition is needed and why it has been designed as it has.
     *
     * This element does not describe the usage of the plan definition. Instead, it provides
     * traceability of ''why'' the resource is either needed or ''why'' it is defined as it is. This
     * may be used to point to source materials or specifications that drove the structure of this
     * plan definition.
     */
    public var purpose: Markdown.Builder? = null

    /** A detailed description of how the plan definition is used from a clinical perspective. */
    public var usage: String.Builder? = null

    /**
     * A copyright statement relating to the plan definition and/or its contents. Copyright
     * statements are generally legal restrictions on the use and publishing of the plan definition.
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
     * The period during which the plan definition content was or is planned to be in active use.
     *
     * The effective period for a plan definition determines when the content is applicable for
     * usage and is independent of publication and review dates. For example, a measure intended to
     * be used for the year 2016 might be published in 2015.
     */
    public var effectivePeriod: Period.Builder? = null

    /**
     * Descriptive topics related to the content of the plan definition. Topics provide a high-level
     * categorization of the definition that can be useful for filtering and searching.
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

    /**
     * A reference to a Library resource containing any formal logic used by the plan definition.
     */
    public var library: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A goal describes an expected outcome that activities within the plan are intended to achieve.
     * For example, weight loss, restoring an activity of daily living, obtaining herd immunity via
     * immunization, meeting a process improvement objective, meeting the acceptance criteria for a
     * test as specified by a quality specification, etc.
     */
    public var goal: MutableList<Goal.Builder> = mutableListOf()

    /**
     * An action or group of actions to be taken as part of the plan. For example, in clinical care,
     * an action would be to prescribe a particular indicated medication, or perform a particular
     * test as appropriate. In pharmaceutical quality, an action would be the test that needs to be
     * performed on a drug product as defined in the quality specification.
     *
     * Note that there is overlap between many of the elements defined here and the
     * ActivityDefinition resource. When an ActivityDefinition is referenced (using the definition
     * element), the overlapping elements in the plan override the content of the referenced
     * ActivityDefinition unless otherwise documented in the specific elements. See the
     * PlanDefinition resource for more detailed information.
     */
    public var action: MutableList<Action.Builder> = mutableListOf()

    override fun build(): PlanDefinition =
      PlanDefinition(
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
        subtitle = subtitle?.build(),
        type = type?.build(),
        status = status,
        experimental = experimental?.build(),
        subject = subject,
        date = date?.build(),
        publisher = publisher?.build(),
        contact = contact.map { it.build() },
        description = description?.build(),
        useContext = useContext.map { it.build() },
        jurisdiction = jurisdiction.map { it.build() },
        purpose = purpose?.build(),
        usage = usage?.build(),
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
        library = library.map { it.build() },
        goal = goal.map { it.build() },
        action = action.map { it.build() },
      )
  }

  /** Identifies the level of importance to be assigned to actioning the request. */
  public enum class RequestPriority(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestPriority =
        when (code) {
          "routine" -> Routine
          "urgent" -> Urgent
          "asap" -> Asap
          "stat" -> Stat
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
        }
    }
  }

  /** Defines organization behavior of a group. */
  public enum class ActionGroupingBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Visual_Group("visual-group", "http://hl7.org/fhir/action-grouping-behavior", "Visual Group"),
    Logical_Group("logical-group", "http://hl7.org/fhir/action-grouping-behavior", "Logical Group"),
    Sentence_Group(
      "sentence-group",
      "http://hl7.org/fhir/action-grouping-behavior",
      "Sentence Group",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionGroupingBehavior =
        when (code) {
          "visual-group" -> Visual_Group
          "logical-group" -> Logical_Group
          "sentence-group" -> Sentence_Group
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionGroupingBehavior")
        }
    }
  }

  /** Defines selection behavior of a group. */
  public enum class ActionSelectionBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Any("any", "http://hl7.org/fhir/action-selection-behavior", "Any"),
    All("all", "http://hl7.org/fhir/action-selection-behavior", "All"),
    All_Or_None("all-or-none", "http://hl7.org/fhir/action-selection-behavior", "All Or None"),
    Exactly_One("exactly-one", "http://hl7.org/fhir/action-selection-behavior", "Exactly One"),
    At_Most_One("at-most-one", "http://hl7.org/fhir/action-selection-behavior", "At Most One"),
    One_Or_More("one-or-more", "http://hl7.org/fhir/action-selection-behavior", "One Or More");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionSelectionBehavior =
        when (code) {
          "any" -> Any
          "all" -> All
          "all-or-none" -> All_Or_None
          "exactly-one" -> Exactly_One
          "at-most-one" -> At_Most_One
          "one-or-more" -> One_Or_More
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionSelectionBehavior")
        }
    }
  }

  /** Defines expectations around whether an action or action group is required. */
  public enum class ActionRequiredBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Must("must", "http://hl7.org/fhir/action-required-behavior", "Must"),
    Could("could", "http://hl7.org/fhir/action-required-behavior", "Could"),
    Must_Unless_Documented(
      "must-unless-documented",
      "http://hl7.org/fhir/action-required-behavior",
      "Must Unless Documented",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionRequiredBehavior =
        when (code) {
          "must" -> Must
          "could" -> Could
          "must-unless-documented" -> Must_Unless_Documented
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionRequiredBehavior")
        }
    }
  }

  /** Defines selection frequency behavior for an action or group. */
  public enum class ActionPrecheckBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Yes("yes", "http://hl7.org/fhir/action-precheck-behavior", "Yes"),
    No("no", "http://hl7.org/fhir/action-precheck-behavior", "No");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionPrecheckBehavior =
        when (code) {
          "yes" -> Yes
          "no" -> No
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionPrecheckBehavior")
        }
    }
  }

  /** Defines behavior for an action or a group for how many times that item may be repeated. */
  public enum class ActionCardinalityBehavior(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Single("single", "http://hl7.org/fhir/action-cardinality-behavior", "Single"),
    Multiple("multiple", "http://hl7.org/fhir/action-cardinality-behavior", "Multiple");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionCardinalityBehavior =
        when (code) {
          "single" -> Single
          "multiple" -> Multiple
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionCardinalityBehavior")
        }
    }
  }

  /** Defines the kinds of conditions that can appear on actions. */
  public enum class ActionConditionKind(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Applicability("applicability", "http://hl7.org/fhir/action-condition-kind", "Applicability"),
    Start("start", "http://hl7.org/fhir/action-condition-kind", "Start"),
    Stop("stop", "http://hl7.org/fhir/action-condition-kind", "Stop");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionConditionKind =
        when (code) {
          "applicability" -> Applicability
          "start" -> Start
          "stop" -> Stop
          else -> throw IllegalArgumentException("Unknown code $code for enum ActionConditionKind")
        }
    }
  }

  /** Defines the types of relationships between actions. */
  public enum class ActionRelationshipType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Before_Start("before-start", "http://hl7.org/fhir/action-relationship-type", "Before Start"),
    Before("before", "http://hl7.org/fhir/action-relationship-type", "Before"),
    Before_End("before-end", "http://hl7.org/fhir/action-relationship-type", "Before End"),
    Concurrent_With_Start(
      "concurrent-with-start",
      "http://hl7.org/fhir/action-relationship-type",
      "Concurrent With Start",
    ),
    Concurrent("concurrent", "http://hl7.org/fhir/action-relationship-type", "Concurrent"),
    Concurrent_With_End(
      "concurrent-with-end",
      "http://hl7.org/fhir/action-relationship-type",
      "Concurrent With End",
    ),
    After_Start("after-start", "http://hl7.org/fhir/action-relationship-type", "After Start"),
    After("after", "http://hl7.org/fhir/action-relationship-type", "After"),
    After_End("after-end", "http://hl7.org/fhir/action-relationship-type", "After End");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionRelationshipType =
        when (code) {
          "before-start" -> Before_Start
          "before" -> Before
          "before-end" -> Before_End
          "concurrent-with-start" -> Concurrent_With_Start
          "concurrent" -> Concurrent
          "concurrent-with-end" -> Concurrent_With_End
          "after-start" -> After_Start
          "after" -> After
          "after-end" -> After_End
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionRelationshipType")
        }
    }
  }

  /** The type of participant for the action. */
  public enum class ActionParticipantType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Patient("patient", "http://hl7.org/fhir/action-participant-type", "Patient"),
    Practitioner("practitioner", "http://hl7.org/fhir/action-participant-type", "Practitioner"),
    Related_Person(
      "related-person",
      "http://hl7.org/fhir/action-participant-type",
      "Related Person",
    ),
    Device("device", "http://hl7.org/fhir/action-participant-type", "Device");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ActionParticipantType =
        when (code) {
          "patient" -> Patient
          "practitioner" -> Practitioner
          "related-person" -> Related_Person
          "device" -> Device
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ActionParticipantType")
        }
    }
  }
}
