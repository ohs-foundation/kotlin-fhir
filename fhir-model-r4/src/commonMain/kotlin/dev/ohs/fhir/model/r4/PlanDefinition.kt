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

import dev.ohs.fhir.model.r4.serializers.PlanDefinitionActionConditionSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionActionDynamicValueSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionActionParticipantSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionActionRelatedActionSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionActionSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionGoalSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionGoalTargetSerializer
import dev.ohs.fhir.model.r4.serializers.PlanDefinitionSerializer
import dev.ohs.fhir.model.r4.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r4.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionParticipantType
import dev.ohs.fhir.model.r4.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r4.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r4.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r4.terminologies.PublicationStatus
import dev.ohs.fhir.model.r4.terminologies.RequestPriority
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This resource allows for the definition of various types of plans as a sharable, consumable, and
 * executable artifact. The resource is general enough to support the description of a broad range
 * of clinical artifacts such as clinical decision support rules, order sets and protocols.
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
  /** A code or group definition that describes the intended subject of the plan definition. */
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
   * Goals that describe what the activities within the plan are intended to achieve. For example,
   * weight loss, restoring an activity of daily living, obtaining herd immunity via immunization,
   * meeting a process improvement objective, etc.
   */
  public val goal: List<Goal> = listOf(),
  /**
   * An action or group of actions to be taken as part of the plan.
   *
   * Note that there is overlap between many of the elements defined here and the ActivityDefinition
   * resource. When an ActivityDefinition is referenced (using the definition element), the
   * overlapping elements in the plan override the content of the referenced ActivityDefinition
   * unless otherwise documented in the specific elements. See the PlanDefinition resource for more
   * detailed information.
   */
  public val action: List<Action> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder = Builder(status)
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.url = url?.toBuilder()
    builder.identifier = identifier.toBuilderList()
    builder.version = version?.toBuilder()
    builder.name = name?.toBuilder()
    builder.title = title?.toBuilder()
    builder.subtitle = subtitle?.toBuilder()
    builder.type = type?.toBuilder()
    builder.experimental = experimental?.toBuilder()
    builder.subject = subject
    builder.date = date?.toBuilder()
    builder.publisher = publisher?.toBuilder()
    builder.contact = contact.toBuilderList()
    builder.description = description?.toBuilder()
    builder.useContext = useContext.toBuilderList()
    builder.jurisdiction = jurisdiction.toBuilderList()
    builder.purpose = purpose?.toBuilder()
    builder.usage = usage?.toBuilder()
    builder.copyright = copyright?.toBuilder()
    builder.approvalDate = approvalDate?.toBuilder()
    builder.lastReviewDate = lastReviewDate?.toBuilder()
    builder.effectivePeriod = effectivePeriod?.toBuilder()
    builder.topic = topic.toBuilderList()
    builder.author = author.toBuilderList()
    builder.editor = editor.toBuilderList()
    builder.reviewer = reviewer.toBuilderList()
    builder.endorser = endorser.toBuilderList()
    builder.relatedArtifact = relatedArtifact.toBuilderList()
    builder.library = library.toBuilderList()
    builder.goal = goal.toBuilderList()
    builder.action = action.toBuilderList()
    return builder
  }

  /**
   * Goals that describe what the activities within the plan are intended to achieve. For example,
   * weight loss, restoring an activity of daily living, obtaining herd immunity via immunization,
   * meeting a process improvement objective, etc.
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
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(description.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.category = category?.toBuilder()
      builder.priority = priority?.toBuilder()
      builder.start = start?.toBuilder()
      builder.addresses = addresses.toBuilderList()
      builder.documentation = documentation.toBuilderList()
      builder.target = target.toBuilderList()
      return builder
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
       * pounds or 7.0%. Either the high or low or both values of the range can be specified. When a
       * low value is missing, it indicates that the goal is achieved at any value at or below the
       * high value. Similarly, if the high value is missing, it indicates that the goal is achieved
       * at any value at or above the low value.
       */
      public val detail: Detail? = null,
      /** Indicates the timeframe after the start of the goal in which the goal should be met. */
      public val due: Duration? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.measure = measure?.toBuilder()
        builder.detail = detail
        builder.due = due?.toBuilder()
        return builder
      }

      public sealed interface Detail : FhirChoice {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asRange(): Range? = this as? Range

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public data class Quantity(override val `value`: dev.ohs.fhir.model.r4.Quantity) : Detail

        public data class Range(override val `value`: dev.ohs.fhir.model.r4.Range) : Detail

        public data class CodeableConcept(
          override val `value`: dev.ohs.fhir.model.r4.CodeableConcept
        ) : Detail

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r4.Quantity?,
            rangeValue: dev.ohs.fhir.model.r4.Range?,
            codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          ): Detail? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (rangeValue != null) return Range(rangeValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            return null
          }
        }
      }

      public class Builder() : FhirBuilder {
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
         * 150 pounds or 7.0%. Either the high or low or both values of the range can be specified.
         * When a low value is missing, it indicates that the goal is achieved at any value at or
         * below the high value. Similarly, if the high value is missing, it indicates that the goal
         * is achieved at any value at or above the low value.
         */
        public var detail: Detail? = null

        /** Indicates the timeframe after the start of the goal in which the goal should be met. */
        public var due: Duration.Builder? = null

        override fun build(): Target =
          Target(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
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
    ) : FhirBuilder {
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

      override fun build(): Goal =
        Goal(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          category = category?.build(),
          description = description.build(),
          priority = priority?.build(),
          start = start?.build(),
          addresses = addresses.buildList(),
          documentation = documentation.buildList(),
          target = target.buildList(),
        )
    }
  }

  /** An action or group of actions to be taken as part of the plan. */
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
    /** The title of the action displayed to a user. */
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
     * A code that provides meaning for the action or action group. For example, a section may have
     * a LOINC code for the section of a documentation template.
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
     * within this plan definition.
     */
    public val goalId: List<Id> = listOf(),
    /**
     * A code or group definition that describes the intended subject of the action and its
     * children, if any.
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
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.prefix = prefix?.toBuilder()
      builder.title = title?.toBuilder()
      builder.description = description?.toBuilder()
      builder.textEquivalent = textEquivalent?.toBuilder()
      builder.priority = priority
      builder.code = code.toBuilderList()
      builder.reason = reason.toBuilderList()
      builder.documentation = documentation.toBuilderList()
      builder.goalId = goalId.toBuilderList()
      builder.subject = subject
      builder.trigger = trigger.toBuilderList()
      builder.condition = condition.toBuilderList()
      builder.input = input.toBuilderList()
      builder.output = output.toBuilderList()
      builder.relatedAction = relatedAction.toBuilderList()
      builder.timing = timing
      builder.participant = participant.toBuilderList()
      builder.type = type?.toBuilder()
      builder.groupingBehavior = groupingBehavior
      builder.selectionBehavior = selectionBehavior
      builder.requiredBehavior = requiredBehavior
      builder.precheckBehavior = precheckBehavior
      builder.cardinalityBehavior = cardinalityBehavior
      builder.definition = definition
      builder.transform = transform?.toBuilder()
      builder.dynamicValue = dynamicValue.toBuilderList()
      builder.action = action.toBuilderList()
      return builder
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
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(kind)
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.expression = expression?.toBuilder()
        return builder
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
      ) : FhirBuilder {
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

        override fun build(): Condition =
          Condition(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
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
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder =
          Builder(
            actionId.toBuilder(),
            relationship,
          )
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.offset = offset
        return builder
      }

      public sealed interface Offset : FhirChoice {
        public fun asDuration(): Duration? = this as? Duration

        public fun asRange(): Range? = this as? Range

        public data class Duration(override val `value`: dev.ohs.fhir.model.r4.Duration) : Offset

        public data class Range(override val `value`: dev.ohs.fhir.model.r4.Range) : Offset

        public companion object {
          internal fun from(
            durationValue: dev.ohs.fhir.model.r4.Duration?,
            rangeValue: dev.ohs.fhir.model.r4.Range?,
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
      ) : FhirBuilder {
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

        override fun build(): RelatedAction =
          RelatedAction(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
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
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder(type)
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.role = role?.toBuilder()
        return builder
      }

      public class Builder(
        /** The type of participant in the action. */
        public var type: Enumeration<ActionParticipantType>
      ) : FhirBuilder {
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

        override fun build(): Participant =
          Participant(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
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
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.path = path?.toBuilder()
        builder.expression = expression?.toBuilder()
        return builder
      }

      public class Builder() : FhirBuilder {
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

        override fun build(): DynamicValue =
          DynamicValue(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            path = path?.build(),
            expression = expression?.build(),
          )
      }
    }

    public sealed interface Subject : FhirChoice {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r4.CodeableConcept
      ) : Subject

      public data class Reference(override val `value`: dev.ohs.fhir.model.r4.Reference) : Subject

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Subject? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public sealed interface Timing : FhirChoice {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asAge(): Age? = this as? Age

      public fun asPeriod(): Period? = this as? Period

      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asTiming(): Timing? = this as? Timing

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r4.DateTime) :
        Action.Timing

      public data class Age(override val `value`: dev.ohs.fhir.model.r4.Age) : Action.Timing

      public data class Period(override val `value`: dev.ohs.fhir.model.r4.Period) : Action.Timing

      public data class Duration(override val `value`: dev.ohs.fhir.model.r4.Duration) :
        Action.Timing

      public data class Range(override val `value`: dev.ohs.fhir.model.r4.Range) : Action.Timing

      public data class Timing(override val `value`: dev.ohs.fhir.model.r4.Timing) : Action.Timing

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
          ageValue: dev.ohs.fhir.model.r4.Age?,
          periodValue: dev.ohs.fhir.model.r4.Period?,
          durationValue: dev.ohs.fhir.model.r4.Duration?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
          timingValue: dev.ohs.fhir.model.r4.Timing?,
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

    public sealed interface Definition : FhirChoice {
      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asUri(): Uri? = this as? Uri

      public data class Canonical(override val `value`: dev.ohs.fhir.model.r4.Canonical) :
        Definition

      public data class Uri(override val `value`: dev.ohs.fhir.model.r4.Uri) : Definition

      public companion object {
        internal fun from(
          canonicalValue: dev.ohs.fhir.model.r4.Canonical?,
          uriValue: dev.ohs.fhir.model.r4.Uri?,
        ): Definition? {
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (uriValue != null) return Uri(uriValue)
          return null
        }
      }
    }

    public class Builder() : FhirBuilder {
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

      /** The title of the action displayed to a user. */
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
       * A code that provides meaning for the action or action group. For example, a section may
       * have a LOINC code for the section of a documentation template.
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
       * within this plan definition.
       */
      public var goalId: MutableList<Id.Builder> = mutableListOf()

      /**
       * A code or group definition that describes the intended subject of the action and its
       * children, if any.
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

      override fun build(): Action =
        Action(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          prefix = prefix?.build(),
          title = title?.build(),
          description = description?.build(),
          textEquivalent = textEquivalent?.build(),
          priority = priority,
          code = code.buildList(),
          reason = reason.buildList(),
          documentation = documentation.buildList(),
          goalId = goalId.buildList(),
          subject = subject,
          trigger = trigger.buildList(),
          condition = condition.buildList(),
          input = input.buildList(),
          output = output.buildList(),
          relatedAction = relatedAction.buildList(),
          timing = timing,
          participant = participant.buildList(),
          type = type?.build(),
          groupingBehavior = groupingBehavior,
          selectionBehavior = selectionBehavior,
          requiredBehavior = requiredBehavior,
          precheckBehavior = precheckBehavior,
          cardinalityBehavior = cardinalityBehavior,
          definition = definition,
          transform = transform?.build(),
          dynamicValue = dynamicValue.buildList(),
          action = action.buildList(),
        )
    }
  }

  public sealed interface Subject : FhirChoice {
    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public fun asReference(): Reference? = this as? Reference

    public data class CodeableConcept(override val `value`: dev.ohs.fhir.model.r4.CodeableConcept) :
      Subject

    public data class Reference(override val `value`: dev.ohs.fhir.model.r4.Reference) : Subject

    public companion object {
      internal fun from(
        codeableConceptValue: dev.ohs.fhir.model.r4.CodeableConcept?,
        referenceValue: dev.ohs.fhir.model.r4.Reference?,
      ): Subject? {
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        if (referenceValue != null) return Reference(referenceValue)
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
    override var id: kotlin.String? = null

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

    /** A code or group definition that describes the intended subject of the plan definition. */
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
     * Goals that describe what the activities within the plan are intended to achieve. For example,
     * weight loss, restoring an activity of daily living, obtaining herd immunity via immunization,
     * meeting a process improvement objective, etc.
     */
    public var goal: MutableList<Goal.Builder> = mutableListOf()

    /**
     * An action or group of actions to be taken as part of the plan.
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
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        url = url?.build(),
        identifier = identifier.buildList(),
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
        contact = contact.buildList(),
        description = description?.build(),
        useContext = useContext.buildList(),
        jurisdiction = jurisdiction.buildList(),
        purpose = purpose?.build(),
        usage = usage?.build(),
        copyright = copyright?.build(),
        approvalDate = approvalDate?.build(),
        lastReviewDate = lastReviewDate?.build(),
        effectivePeriod = effectivePeriod?.build(),
        topic = topic.buildList(),
        author = author.buildList(),
        editor = editor.buildList(),
        reviewer = reviewer.buildList(),
        endorser = endorser.buildList(),
        relatedArtifact = relatedArtifact.buildList(),
        library = library.buildList(),
        goal = goal.buildList(),
        action = action.buildList(),
      )
  }
}
