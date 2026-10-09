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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionConditionSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionDynamicValueSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionInputSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionOutputSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionRelatedActionSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationActionSerializer
import dev.ohs.fhir.model.r5.serializers.RequestOrchestrationSerializer
import dev.ohs.fhir.model.r5.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r5.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionParticipantType
import dev.ohs.fhir.model.r5.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r5.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r5.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r5.terminologies.RequestIntent
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.RequestStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A set of related requests that can be used to capture intended activities that have
 * inter-dependencies such as "give this medication after that one".
 */
@Serializable(with = RequestOrchestrationSerializer::class)
@SerialName("RequestOrchestration")
public data class RequestOrchestration(
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
  /** Allows a service to provide a unique, business identifier for the request. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this request.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * A URL referencing an externally defined protocol, guideline, orderset or other definition that
   * is adhered to in whole or in part by this request.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /** A plan, proposal or order that is fulfilled in whole or in part by this request. */
  public val basedOn: List<Reference> = listOf(),
  /**
   * Completed or terminated request(s) whose function is taken by this new request.
   *
   * The replacement could be because the initial request was immediately rejected (due to an issue)
   * or because the previous request was completed, but the need for the action described by the
   * request remains ongoing.
   */
  public val replaces: List<Reference> = listOf(),
  /**
   * A shared identifier common to multiple independent Request instances that were
   * activated/authorized more or less simultaneously by a single author. The presence of the same
   * identifier on each request ties those requests together and may have business ramifications in
   * terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of lab
   * tests ordered together, or a prescription number shared by all meds ordered at one time.
   *
   * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling another)
   * or by having a common requisition. Requests that are part of the same requisition are generally
   * treated independently from the perspective of changing their state or maintaining them after
   * initial creation.
   */
  public val groupIdentifier: Identifier? = null,
  /**
   * The current state of the request. For request orchestrations, the status reflects the status of
   * all the requests in the orchestration.
   */
  public val status: Enumeration<RequestStatus>,
  /**
   * Indicates the level of authority/intentionality associated with the request and where the
   * request fits into the workflow chain.
   */
  public val intent: Enumeration<RequestIntent>,
  /** Indicates how quickly the request should be addressed with respect to other requests. */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * A code that identifies what the overall request orchestration is.
   *
   * This element can be used to provide a code that captures the meaning of the request
   * orchestration as a whole, as opposed to the code of the action element, which captures the
   * meaning of the individual actions within the request orchestration.
   */
  public val code: CodeableConcept? = null,
  /** The subject for which the request orchestration was created. */
  public val subject: Reference? = null,
  /** Describes the context of the request orchestration, if any. */
  public val encounter: Reference? = null,
  /** Indicates when the request orchestration was created. */
  public val authoredOn: DateTime? = null,
  /** Provides a reference to the author of the request orchestration. */
  public val author: Reference? = null,
  /** Describes the reason for the request orchestration in coded or textual form. */
  public val reason: List<CodeableReference> = listOf(),
  /**
   * Goals that are intended to be achieved by following the requests in this RequestOrchestration.
   */
  public val goal: List<Reference> = listOf(),
  /** Provides a mechanism to communicate additional information about the response. */
  public val note: List<Annotation> = listOf(),
  /** The actions, if any, produced by the evaluation of the artifact. */
  public val action: List<Action> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        intent,
      )
    builder.id = id
    builder.meta = meta?.toBuilder()
    builder.implicitRules = implicitRules?.toBuilder()
    builder.language = language?.toBuilder()
    builder.text = text?.toBuilder()
    builder.contained = contained.toBuilderList()
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.identifier = identifier.toBuilderList()
    builder.instantiatesCanonical = instantiatesCanonical.toBuilderList()
    builder.instantiatesUri = instantiatesUri.toBuilderList()
    builder.basedOn = basedOn.toBuilderList()
    builder.replaces = replaces.toBuilderList()
    builder.groupIdentifier = groupIdentifier?.toBuilder()
    builder.priority = priority
    builder.code = code?.toBuilder()
    builder.subject = subject?.toBuilder()
    builder.encounter = encounter?.toBuilder()
    builder.authoredOn = authoredOn?.toBuilder()
    builder.author = author?.toBuilder()
    builder.reason = reason.toBuilderList()
    builder.goal = goal.toBuilderList()
    builder.note = note.toBuilderList()
    builder.action = action.toBuilderList()
    return builder
  }

  /** The actions, if any, produced by the evaluation of the artifact. */
  @Serializable(with = RequestOrchestrationActionSerializer::class)
  public data class Action(
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
     * The linkId of the action from the PlanDefinition that corresponds to this action in the
     * RequestOrchestration resource.
     */
    public val linkId: String? = null,
    /**
     * A user-visible prefix for the action. For example a section or item numbering such as 1. or
     * A.
     */
    public val prefix: String? = null,
    /** The title of the action displayed to a user. */
    public val title: String? = null,
    /** A short description of the action used to provide a summary to display to the user. */
    public val description: Markdown? = null,
    /**
     * A text equivalent of the action to be performed. This provides a human-interpretable
     * description of the action when the definition is consumed by a system that might not be
     * capable of interpreting it dynamically.
     */
    public val textEquivalent: Markdown? = null,
    /** Indicates how quickly the action should be addressed with respect to other actions. */
    public val priority: Enumeration<RequestPriority>? = null,
    /**
     * A code that provides meaning for the action or action group. For example, a section may have
     * a LOINC code for a section of a documentation template.
     */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * Didactic or other informational resources associated with the action that can be provided to
     * the CDS recipient. Information resources can include inline text commentary and links to web
     * resources.
     */
    public val documentation: List<RelatedArtifact> = listOf(),
    /** Goals that are intended to be achieved by following the requests in this action. */
    public val goal: List<Reference> = listOf(),
    /**
     * An expression that describes applicability criteria, or start/stop conditions for the action.
     *
     * When multiple conditions of the same kind are present, the effects are combined using AND
     * semantics, so the overall condition is true only if all of the conditions are true.
     */
    public val condition: List<Condition> = listOf(),
    /** Defines input data requirements for the action. */
    public val input: List<Input> = listOf(),
    /** Defines the outputs of the action, if any. */
    public val output: List<Output> = listOf(),
    /** A relationship to another action such as "before" or "30-60 minutes after start of". */
    public val relatedAction: List<RelatedAction> = listOf(),
    /**
     * An optional value describing when the action should be performed.
     *
     * The intent of the timing element is to provide timing for when the action should be
     * performed. The timing may be absolute (specified as a dateTime or Period) or relative
     * (specified as an Age, Duration, or Range), or it may be a more complex, potentially repeating
     * timing specified using Timing.
     */
    public val timing: Timing? = null,
    /**
     * Identifies the facility where the action will occur; e.g. home, hospital, specific clinic,
     * etc.
     *
     * May reference a specific clinical location or may just identify a type of location.
     */
    public val location: CodeableReference? = null,
    /**
     * The participant that should perform or be responsible for this action.
     *
     * Because request orchestrations represent potential options for performing activities, some
     * specific participants may still be unknown, so this element allows for both definitional
     * participants (in the same way they are specified in ActivityDefinition and PlanDefinition
     * resources) as well as identifying specific participants when they are known.
     */
    public val participant: List<Participant> = listOf(),
    /** The type of action to perform (create, update, remove). */
    public val type: CodeableConcept? = null,
    /** Defines the grouping behavior for the action and its children. */
    public val groupingBehavior: Enumeration<ActionGroupingBehavior>? = null,
    /** Defines the selection behavior for the action and its children. */
    public val selectionBehavior: Enumeration<ActionSelectionBehavior>? = null,
    /** Defines expectations around whether an action is required. */
    public val requiredBehavior: Enumeration<ActionRequiredBehavior>? = null,
    /** Defines whether the action should usually be preselected. */
    public val precheckBehavior: Enumeration<ActionPrecheckBehavior>? = null,
    /** Defines whether the action can be selected multiple times. */
    public val cardinalityBehavior: Enumeration<ActionCardinalityBehavior>? = null,
    /**
     * The resource that is the target of the action (e.g. CommunicationRequest).
     *
     * The target resource SHALL be a [Request](request.html) resource with a Request.intent set to
     * "option".
     */
    public val resource: Reference? = null,
    /**
     * A reference to an ActivityDefinition that describes the action to be taken in detail, a
     * PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be
     * filled out, a SpecimenDefinition describing a specimen to be collected, or an
     * ObservationDefinition that specifies what observation should be captured.
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
     * Dynamic values are applied in the order in which they are defined in the RequestOrchestration
     * resource. Note that when dynamic values are also specified by a referenced
     * ActivityDefinition, the dynamicValues from the ActivityDefinition are applied first, followed
     * by the dynamicValues specified here. In addition, if both a transform and dynamic values are
     * specific, the dynamic values are applied to the result of the transform.
     */
    public val dynamicValue: List<DynamicValue> = listOf(),
    /** Sub actions. */
    public val action: List<Action> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.linkId = linkId?.toBuilder()
      builder.prefix = prefix?.toBuilder()
      builder.title = title?.toBuilder()
      builder.description = description?.toBuilder()
      builder.textEquivalent = textEquivalent?.toBuilder()
      builder.priority = priority
      builder.code = code.toBuilderList()
      builder.documentation = documentation.toBuilderList()
      builder.goal = goal.toBuilderList()
      builder.condition = condition.toBuilderList()
      builder.input = input.toBuilderList()
      builder.output = output.toBuilderList()
      builder.relatedAction = relatedAction.toBuilderList()
      builder.timing = timing
      builder.location = location?.toBuilder()
      builder.participant = participant.toBuilderList()
      builder.type = type?.toBuilder()
      builder.groupingBehavior = groupingBehavior
      builder.selectionBehavior = selectionBehavior
      builder.requiredBehavior = requiredBehavior
      builder.precheckBehavior = precheckBehavior
      builder.cardinalityBehavior = cardinalityBehavior
      builder.resource = resource?.toBuilder()
      builder.definition = definition
      builder.transform = transform?.toBuilder()
      builder.dynamicValue = dynamicValue.toBuilderList()
      builder.action = action.toBuilderList()
      return builder
    }

    /**
     * An expression that describes applicability criteria, or start/stop conditions for the action.
     */
    @Serializable(with = RequestOrchestrationActionConditionSerializer::class)
    public data class Condition(
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
       * The kind of condition.
       *
       * Applicability criteria are used to determine immediate applicability when a plan definition
       * is applied to a given context. Start and stop criteria are carried through application and
       * used to describe enter/exit criteria for an action.
       */
      public val kind: Enumeration<ActionConditionKind>,
      /**
       * An expression that returns true or false, indicating whether or not the condition is
       * satisfied.
       *
       * The expression may be inlined, or may be a reference to a named expression within a logic
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
         * An expression that returns true or false, indicating whether or not the condition is
         * satisfied.
         *
         * The expression may be inlined, or may be a reference to a named expression within a logic
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

    /** Defines input data requirements for the action. */
    @Serializable(with = RequestOrchestrationActionInputSerializer::class)
    public data class Input(
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
       * A human-readable label for the data requirement used to label data flows in BPMN or similar
       * diagrams. Also provides a human readable label when rendering the data requirement that
       * conveys its purpose to human readers.
       */
      public val title: String? = null,
      /** Defines the data that is to be provided as input to the action. */
      public val requirement: DataRequirement? = null,
      /**
       * Points to an existing input or output element that provides data to this input.
       *
       * The relatedData element allows indicating that an input to a parent action is an input to
       * specific child actions. It also allows the output of one action to be identified as the
       * input to a different action
       */
      public val relatedData: Id? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.title = title?.toBuilder()
        builder.requirement = requirement?.toBuilder()
        builder.relatedData = relatedData?.toBuilder()
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
         * A human-readable label for the data requirement used to label data flows in BPMN or
         * similar diagrams. Also provides a human readable label when rendering the data
         * requirement that conveys its purpose to human readers.
         */
        public var title: String.Builder? = null

        /** Defines the data that is to be provided as input to the action. */
        public var requirement: DataRequirement.Builder? = null

        /**
         * Points to an existing input or output element that provides data to this input.
         *
         * The relatedData element allows indicating that an input to a parent action is an input to
         * specific child actions. It also allows the output of one action to be identified as the
         * input to a different action
         */
        public var relatedData: Id.Builder? = null

        override fun build(): Input =
          Input(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            title = title?.build(),
            requirement = requirement?.build(),
            relatedData = relatedData?.build(),
          )
      }
    }

    /** Defines the outputs of the action, if any. */
    @Serializable(with = RequestOrchestrationActionOutputSerializer::class)
    public data class Output(
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
       * A human-readable label for the data requirement used to label data flows in BPMN or similar
       * diagrams. Also provides a human readable label when rendering the data requirement that
       * conveys its purpose to human readers.
       */
      public val title: String? = null,
      /** Defines the data that results as output from the action. */
      public val requirement: DataRequirement? = null,
      /**
       * Points to an existing input or output element that is results as output from the action.
       *
       * The relatedData element allows indicating that the output of child action is also the
       * output of a parent action. It also allows the input of one action to be identified as the
       * output of a different action
       */
      public val relatedData: String? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.title = title?.toBuilder()
        builder.requirement = requirement?.toBuilder()
        builder.relatedData = relatedData?.toBuilder()
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
         * A human-readable label for the data requirement used to label data flows in BPMN or
         * similar diagrams. Also provides a human readable label when rendering the data
         * requirement that conveys its purpose to human readers.
         */
        public var title: String.Builder? = null

        /** Defines the data that results as output from the action. */
        public var requirement: DataRequirement.Builder? = null

        /**
         * Points to an existing input or output element that is results as output from the action.
         *
         * The relatedData element allows indicating that the output of child action is also the
         * output of a parent action. It also allows the input of one action to be identified as the
         * output of a different action
         */
        public var relatedData: String.Builder? = null

        override fun build(): Output =
          Output(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            title = title?.build(),
            requirement = requirement?.build(),
            relatedData = relatedData?.build(),
          )
      }
    }

    /** A relationship to another action such as "before" or "30-60 minutes after start of". */
    @Serializable(with = RequestOrchestrationActionRelatedActionSerializer::class)
    public data class RelatedAction(
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
      /** The element id of the target related action. */
      public val targetId: Id,
      /** The relationship of this action to the related action. */
      public val relationship: Enumeration<ActionRelationshipType>,
      /** The relationship of the end of this action to the related action. */
      public val endRelationship: Enumeration<ActionRelationshipType>? = null,
      /**
       * A duration or range of durations to apply to the relationship. For example, 30-60 minutes
       * before.
       */
      public val offset: Offset? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder =
          Builder(
            targetId.toBuilder(),
            relationship,
          )
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.endRelationship = endRelationship
        builder.offset = offset
        return builder
      }

      public sealed interface Offset : FhirChoice {
        public fun asDuration(): Duration? = this as? Duration

        public fun asRange(): Range? = this as? Range

        public data class Duration(override val `value`: dev.ohs.fhir.model.r5.Duration) : Offset

        public data class Range(override val `value`: dev.ohs.fhir.model.r5.Range) : Offset

        public companion object {
          internal fun from(
            durationValue: dev.ohs.fhir.model.r5.Duration?,
            rangeValue: dev.ohs.fhir.model.r5.Range?,
          ): Offset? {
            if (durationValue != null) return Duration(durationValue)
            if (rangeValue != null) return Range(rangeValue)
            return null
          }
        }
      }

      public class Builder(
        /** The element id of the target related action. */
        public var targetId: Id.Builder,
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

        /** The relationship of the end of this action to the related action. */
        public var endRelationship: Enumeration<ActionRelationshipType>? = null

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
            targetId = targetId.build(),
            relationship = relationship,
            endRelationship = endRelationship,
            offset = offset,
          )
      }
    }

    /** The participant that should perform or be responsible for this action. */
    @Serializable(with = RequestOrchestrationActionParticipantSerializer::class)
    public data class Participant(
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
      /** The type of participant in the action. */
      public val type: Enumeration<ActionParticipantType>? = null,
      /** The type of participant in the action. */
      public val typeCanonical: Canonical? = null,
      /**
       * The type of participant in the action.
       *
       * When this element is a reference, it SHOULD be a reference to a definitional resource (for
       * example, a location type, rather than a specific location).
       */
      public val typeReference: Reference? = null,
      /** The role the participant should play in performing the described action. */
      public val role: CodeableConcept? = null,
      /**
       * Indicates how the actor will be involved in the action - author, reviewer, witness, etc.
       */
      public val function: CodeableConcept? = null,
      /** A reference to the actual participant. */
      public val actor: Actor? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.type = type
        builder.typeCanonical = typeCanonical?.toBuilder()
        builder.typeReference = typeReference?.toBuilder()
        builder.role = role?.toBuilder()
        builder.function = function?.toBuilder()
        builder.actor = actor
        return builder
      }

      public sealed interface Actor : FhirChoice {
        public fun asCanonical(): Canonical? = this as? Canonical

        public fun asReference(): Reference? = this as? Reference

        public data class Canonical(override val `value`: dev.ohs.fhir.model.r5.Canonical) : Actor

        public data class Reference(override val `value`: dev.ohs.fhir.model.r5.Reference) : Actor

        public companion object {
          internal fun from(
            canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
            referenceValue: dev.ohs.fhir.model.r5.Reference?,
          ): Actor? {
            if (canonicalValue != null) return Canonical(canonicalValue)
            if (referenceValue != null) return Reference(referenceValue)
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

        /** The type of participant in the action. */
        public var type: Enumeration<ActionParticipantType>? = null

        /** The type of participant in the action. */
        public var typeCanonical: Canonical.Builder? = null

        /**
         * The type of participant in the action.
         *
         * When this element is a reference, it SHOULD be a reference to a definitional resource
         * (for example, a location type, rather than a specific location).
         */
        public var typeReference: Reference.Builder? = null

        /** The role the participant should play in performing the described action. */
        public var role: CodeableConcept.Builder? = null

        /**
         * Indicates how the actor will be involved in the action - author, reviewer, witness, etc.
         */
        public var function: CodeableConcept.Builder? = null

        /** A reference to the actual participant. */
        public var actor: Actor? = null

        override fun build(): Participant =
          Participant(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            type = type,
            typeCanonical = typeCanonical?.build(),
            typeReference = typeReference?.build(),
            role = role?.build(),
            function = function?.build(),
            actor = actor,
          )
      }
    }

    /**
     * Customizations that should be applied to the statically defined resource. For example, if the
     * dosage of a medication must be computed based on the patient's weight, a customization would
     * be used to specify an expression that calculated the weight, and the path on the resource
     * that would contain the result.
     */
    @Serializable(with = RequestOrchestrationActionDynamicValueSerializer::class)
    public data class DynamicValue(
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
       * The path to the element to be customized. This is the path on the resource that will hold
       * the result of the calculation defined by the expression. The specified path SHALL be a
       * FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL
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
         * The path to the element to be customized. This is the path on the resource that will hold
         * the result of the calculation defined by the expression. The specified path SHALL be a
         * FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL
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

    public sealed interface Timing : FhirChoice {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asAge(): Age? = this as? Age

      public fun asPeriod(): Period? = this as? Period

      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asTiming(): Timing? = this as? Timing

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r5.DateTime) :
        Action.Timing

      public data class Age(override val `value`: dev.ohs.fhir.model.r5.Age) : Action.Timing

      public data class Period(override val `value`: dev.ohs.fhir.model.r5.Period) : Action.Timing

      public data class Duration(override val `value`: dev.ohs.fhir.model.r5.Duration) :
        Action.Timing

      public data class Range(override val `value`: dev.ohs.fhir.model.r5.Range) : Action.Timing

      public data class Timing(override val `value`: dev.ohs.fhir.model.r5.Timing) : Action.Timing

      public companion object {
        internal fun from(
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          ageValue: dev.ohs.fhir.model.r5.Age?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          timingValue: dev.ohs.fhir.model.r5.Timing?,
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

      public data class Canonical(override val `value`: dev.ohs.fhir.model.r5.Canonical) :
        Definition

      public data class Uri(override val `value`: dev.ohs.fhir.model.r5.Uri) : Definition

      public companion object {
        internal fun from(
          canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
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
       * The linkId of the action from the PlanDefinition that corresponds to this action in the
       * RequestOrchestration resource.
       */
      public var linkId: String.Builder? = null

      /**
       * A user-visible prefix for the action. For example a section or item numbering such as 1. or
       * A.
       */
      public var prefix: String.Builder? = null

      /** The title of the action displayed to a user. */
      public var title: String.Builder? = null

      /** A short description of the action used to provide a summary to display to the user. */
      public var description: Markdown.Builder? = null

      /**
       * A text equivalent of the action to be performed. This provides a human-interpretable
       * description of the action when the definition is consumed by a system that might not be
       * capable of interpreting it dynamically.
       */
      public var textEquivalent: Markdown.Builder? = null

      /** Indicates how quickly the action should be addressed with respect to other actions. */
      public var priority: Enumeration<RequestPriority>? = null

      /**
       * A code that provides meaning for the action or action group. For example, a section may
       * have a LOINC code for a section of a documentation template.
       */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Didactic or other informational resources associated with the action that can be provided
       * to the CDS recipient. Information resources can include inline text commentary and links to
       * web resources.
       */
      public var documentation: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /** Goals that are intended to be achieved by following the requests in this action. */
      public var goal: MutableList<Reference.Builder> = mutableListOf()

      /**
       * An expression that describes applicability criteria, or start/stop conditions for the
       * action.
       *
       * When multiple conditions of the same kind are present, the effects are combined using AND
       * semantics, so the overall condition is true only if all of the conditions are true.
       */
      public var condition: MutableList<Condition.Builder> = mutableListOf()

      /** Defines input data requirements for the action. */
      public var input: MutableList<Input.Builder> = mutableListOf()

      /** Defines the outputs of the action, if any. */
      public var output: MutableList<Output.Builder> = mutableListOf()

      /** A relationship to another action such as "before" or "30-60 minutes after start of". */
      public var relatedAction: MutableList<RelatedAction.Builder> = mutableListOf()

      /**
       * An optional value describing when the action should be performed.
       *
       * The intent of the timing element is to provide timing for when the action should be
       * performed. The timing may be absolute (specified as a dateTime or Period) or relative
       * (specified as an Age, Duration, or Range), or it may be a more complex, potentially
       * repeating timing specified using Timing.
       */
      public var timing: Timing? = null

      /**
       * Identifies the facility where the action will occur; e.g. home, hospital, specific clinic,
       * etc.
       *
       * May reference a specific clinical location or may just identify a type of location.
       */
      public var location: CodeableReference.Builder? = null

      /**
       * The participant that should perform or be responsible for this action.
       *
       * Because request orchestrations represent potential options for performing activities, some
       * specific participants may still be unknown, so this element allows for both definitional
       * participants (in the same way they are specified in ActivityDefinition and PlanDefinition
       * resources) as well as identifying specific participants when they are known.
       */
      public var participant: MutableList<Participant.Builder> = mutableListOf()

      /** The type of action to perform (create, update, remove). */
      public var type: CodeableConcept.Builder? = null

      /** Defines the grouping behavior for the action and its children. */
      public var groupingBehavior: Enumeration<ActionGroupingBehavior>? = null

      /** Defines the selection behavior for the action and its children. */
      public var selectionBehavior: Enumeration<ActionSelectionBehavior>? = null

      /** Defines expectations around whether an action is required. */
      public var requiredBehavior: Enumeration<ActionRequiredBehavior>? = null

      /** Defines whether the action should usually be preselected. */
      public var precheckBehavior: Enumeration<ActionPrecheckBehavior>? = null

      /** Defines whether the action can be selected multiple times. */
      public var cardinalityBehavior: Enumeration<ActionCardinalityBehavior>? = null

      /**
       * The resource that is the target of the action (e.g. CommunicationRequest).
       *
       * The target resource SHALL be a [Request](request.html) resource with a Request.intent set
       * to "option".
       */
      public var resource: Reference.Builder? = null

      /**
       * A reference to an ActivityDefinition that describes the action to be taken in detail, a
       * PlanDefinition that describes a series of actions to be taken, a Questionnaire that should
       * be filled out, a SpecimenDefinition describing a specimen to be collected, or an
       * ObservationDefinition that specifies what observation should be captured.
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
       * Dynamic values are applied in the order in which they are defined in the
       * RequestOrchestration resource. Note that when dynamic values are also specified by a
       * referenced ActivityDefinition, the dynamicValues from the ActivityDefinition are applied
       * first, followed by the dynamicValues specified here. In addition, if both a transform and
       * dynamic values are specific, the dynamic values are applied to the result of the transform.
       */
      public var dynamicValue: MutableList<DynamicValue.Builder> = mutableListOf()

      /** Sub actions. */
      public var action: MutableList<Builder> = mutableListOf()

      override fun build(): Action =
        Action(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          linkId = linkId?.build(),
          prefix = prefix?.build(),
          title = title?.build(),
          description = description?.build(),
          textEquivalent = textEquivalent?.build(),
          priority = priority,
          code = code.buildList(),
          documentation = documentation.buildList(),
          goal = goal.buildList(),
          condition = condition.buildList(),
          input = input.buildList(),
          output = output.buildList(),
          relatedAction = relatedAction.buildList(),
          timing = timing,
          location = location?.build(),
          participant = participant.buildList(),
          type = type?.build(),
          groupingBehavior = groupingBehavior,
          selectionBehavior = selectionBehavior,
          requiredBehavior = requiredBehavior,
          precheckBehavior = precheckBehavior,
          cardinalityBehavior = cardinalityBehavior,
          resource = resource?.build(),
          definition = definition,
          transform = transform?.build(),
          dynamicValue = dynamicValue.buildList(),
          action = action.buildList(),
        )
    }
  }

  public class Builder(
    /**
     * The current state of the request. For request orchestrations, the status reflects the status
     * of all the requests in the orchestration.
     */
    public var status: Enumeration<RequestStatus>,
    /**
     * Indicates the level of authority/intentionality associated with the request and where the
     * request fits into the workflow chain.
     */
    public var intent: Enumeration<RequestIntent>,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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

    /** Allows a service to provide a unique, business identifier for the request. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition
     * that is adhered to in whole or in part by this request.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * A URL referencing an externally defined protocol, guideline, orderset or other definition
     * that is adhered to in whole or in part by this request.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /** A plan, proposal or order that is fulfilled in whole or in part by this request. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Completed or terminated request(s) whose function is taken by this new request.
     *
     * The replacement could be because the initial request was immediately rejected (due to an
     * issue) or because the previous request was completed, but the need for the action described
     * by the request remains ongoing.
     */
    public var replaces: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to multiple independent Request instances that were
     * activated/authorized more or less simultaneously by a single author. The presence of the same
     * identifier on each request ties those requests together and may have business ramifications
     * in terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of
     * lab tests ordered together, or a prescription number shared by all meds ordered at one time.
     *
     * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling
     * another) or by having a common requisition. Requests that are part of the same requisition
     * are generally treated independently from the perspective of changing their state or
     * maintaining them after initial creation.
     */
    public var groupIdentifier: Identifier.Builder? = null

    /** Indicates how quickly the request should be addressed with respect to other requests. */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * A code that identifies what the overall request orchestration is.
     *
     * This element can be used to provide a code that captures the meaning of the request
     * orchestration as a whole, as opposed to the code of the action element, which captures the
     * meaning of the individual actions within the request orchestration.
     */
    public var code: CodeableConcept.Builder? = null

    /** The subject for which the request orchestration was created. */
    public var subject: Reference.Builder? = null

    /** Describes the context of the request orchestration, if any. */
    public var encounter: Reference.Builder? = null

    /** Indicates when the request orchestration was created. */
    public var authoredOn: DateTime.Builder? = null

    /** Provides a reference to the author of the request orchestration. */
    public var author: Reference.Builder? = null

    /** Describes the reason for the request orchestration in coded or textual form. */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Goals that are intended to be achieved by following the requests in this
     * RequestOrchestration.
     */
    public var goal: MutableList<Reference.Builder> = mutableListOf()

    /** Provides a mechanism to communicate additional information about the response. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** The actions, if any, produced by the evaluation of the artifact. */
    public var action: MutableList<Action.Builder> = mutableListOf()

    override fun build(): RequestOrchestration =
      RequestOrchestration(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        instantiatesCanonical = instantiatesCanonical.buildList(),
        instantiatesUri = instantiatesUri.buildList(),
        basedOn = basedOn.buildList(),
        replaces = replaces.buildList(),
        groupIdentifier = groupIdentifier?.build(),
        status = status,
        intent = intent,
        priority = priority,
        code = code?.build(),
        subject = subject?.build(),
        encounter = encounter?.build(),
        authoredOn = authoredOn?.build(),
        author = author?.build(),
        reason = reason.buildList(),
        goal = goal.buildList(),
        note = note.buildList(),
        action = action.buildList(),
      )
  }
}
