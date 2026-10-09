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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.RequestGroupActionConditionSerializer
import dev.ohs.fhir.model.r4b.serializers.RequestGroupActionRelatedActionSerializer
import dev.ohs.fhir.model.r4b.serializers.RequestGroupActionSerializer
import dev.ohs.fhir.model.r4b.serializers.RequestGroupSerializer
import dev.ohs.fhir.model.r4b.terminologies.ActionCardinalityBehavior
import dev.ohs.fhir.model.r4b.terminologies.ActionConditionKind
import dev.ohs.fhir.model.r4b.terminologies.ActionGroupingBehavior
import dev.ohs.fhir.model.r4b.terminologies.ActionPrecheckBehavior
import dev.ohs.fhir.model.r4b.terminologies.ActionRelationshipType
import dev.ohs.fhir.model.r4b.terminologies.ActionRequiredBehavior
import dev.ohs.fhir.model.r4b.terminologies.ActionSelectionBehavior
import dev.ohs.fhir.model.r4b.terminologies.RequestIntent
import dev.ohs.fhir.model.r4b.terminologies.RequestPriority
import dev.ohs.fhir.model.r4b.terminologies.RequestStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A group of related requests that can be used to capture intended activities that have
 * inter-dependencies such as "give this medication after that one".
 */
@Serializable(with = RequestGroupSerializer::class)
@SerialName("RequestGroup")
public data class RequestGroup(
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
   * A shared identifier common to all requests that were authorized more or less simultaneously by
   * a single author, representing the identifier of the requisition, prescription or similar form.
   *
   * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling another)
   * or by having a common requisition. Requests that are part of the same requisition are generally
   * treated independently from the perspective of changing their state or maintaining them after
   * initial creation.
   */
  public val groupIdentifier: Identifier? = null,
  /**
   * The current state of the request. For request groups, the status reflects the status of all the
   * requests in the group.
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
   * A code that identifies what the overall request group is.
   *
   * This element can be used to provide a code that captures the meaning of the request group as a
   * whole, as opposed to the code of the action element, which captures the meaning of the
   * individual actions within the request group.
   */
  public val code: CodeableConcept? = null,
  /** The subject for which the request group was created. */
  public val subject: Reference? = null,
  /** Describes the context of the request group, if any. */
  public val encounter: Reference? = null,
  /** Indicates when the request group was created. */
  public val authoredOn: DateTime? = null,
  /** Provides a reference to the author of the request group. */
  public val author: Reference? = null,
  /** Describes the reason for the request group in coded or textual form. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Indicates another resource whose existence justifies this request group. */
  public val reasonReference: List<Reference> = listOf(),
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
    builder.reasonCode = reasonCode.toBuilderList()
    builder.reasonReference = reasonReference.toBuilderList()
    builder.note = note.toBuilderList()
    builder.action = action.toBuilderList()
    return builder
  }

  /** The actions, if any, produced by the evaluation of the artifact. */
  @Serializable(with = RequestGroupActionSerializer::class)
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
    /** A short description of the action used to provide a summary to display to the user. */
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
     * a LOINC code for a section of a documentation template.
     */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * Didactic or other informational resources associated with the action that can be provided to
     * the CDS recipient. Information resources can include inline text commentary and links to web
     * resources.
     */
    public val documentation: List<RelatedArtifact> = listOf(),
    /**
     * An expression that describes applicability criteria, or start/stop conditions for the action.
     *
     * When multiple conditions of the same kind are present, the effects are combined using AND
     * semantics, so the overall condition is true only if all of the conditions are true.
     */
    public val condition: List<Condition> = listOf(),
    /** A relationship to another action such as "before" or "30-60 minutes after start of". */
    public val relatedAction: List<RelatedAction> = listOf(),
    /** An optional value describing when the action should be performed. */
    public val timing: Timing? = null,
    /** The participant that should perform or be responsible for this action. */
    public val participant: List<Reference> = listOf(),
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
    /** Sub actions. */
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
      builder.documentation = documentation.toBuilderList()
      builder.condition = condition.toBuilderList()
      builder.relatedAction = relatedAction.toBuilderList()
      builder.timing = timing
      builder.participant = participant.toBuilderList()
      builder.type = type?.toBuilder()
      builder.groupingBehavior = groupingBehavior
      builder.selectionBehavior = selectionBehavior
      builder.requiredBehavior = requiredBehavior
      builder.precheckBehavior = precheckBehavior
      builder.cardinalityBehavior = cardinalityBehavior
      builder.resource = resource?.toBuilder()
      builder.action = action.toBuilderList()
      return builder
    }

    /**
     * An expression that describes applicability criteria, or start/stop conditions for the action.
     */
    @Serializable(with = RequestGroupActionConditionSerializer::class)
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

    /** A relationship to another action such as "before" or "30-60 minutes after start of". */
    @Serializable(with = RequestGroupActionRelatedActionSerializer::class)
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
      /** The element id of the action this is related to. */
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

        public data class Duration(override val `value`: dev.ohs.fhir.model.r4b.Duration) : Offset

        public data class Range(override val `value`: dev.ohs.fhir.model.r4b.Range) : Offset

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
        /** The element id of the action this is related to. */
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

    public sealed interface Timing : FhirChoice {
      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asAge(): Age? = this as? Age

      public fun asPeriod(): Period? = this as? Period

      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asTiming(): Timing? = this as? Timing

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r4b.DateTime) :
        Action.Timing

      public data class Age(override val `value`: dev.ohs.fhir.model.r4b.Age) : Action.Timing

      public data class Period(override val `value`: dev.ohs.fhir.model.r4b.Period) : Action.Timing

      public data class Duration(override val `value`: dev.ohs.fhir.model.r4b.Duration) :
        Action.Timing

      public data class Range(override val `value`: dev.ohs.fhir.model.r4b.Range) : Action.Timing

      public data class Timing(override val `value`: dev.ohs.fhir.model.r4b.Timing) : Action.Timing

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

      /** A short description of the action used to provide a summary to display to the user. */
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
       * have a LOINC code for a section of a documentation template.
       */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Didactic or other informational resources associated with the action that can be provided
       * to the CDS recipient. Information resources can include inline text commentary and links to
       * web resources.
       */
      public var documentation: MutableList<RelatedArtifact.Builder> = mutableListOf()

      /**
       * An expression that describes applicability criteria, or start/stop conditions for the
       * action.
       *
       * When multiple conditions of the same kind are present, the effects are combined using AND
       * semantics, so the overall condition is true only if all of the conditions are true.
       */
      public var condition: MutableList<Condition.Builder> = mutableListOf()

      /** A relationship to another action such as "before" or "30-60 minutes after start of". */
      public var relatedAction: MutableList<RelatedAction.Builder> = mutableListOf()

      /** An optional value describing when the action should be performed. */
      public var timing: Timing? = null

      /** The participant that should perform or be responsible for this action. */
      public var participant: MutableList<Reference.Builder> = mutableListOf()

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

      /** Sub actions. */
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
          documentation = documentation.buildList(),
          condition = condition.buildList(),
          relatedAction = relatedAction.buildList(),
          timing = timing,
          participant = participant.buildList(),
          type = type?.build(),
          groupingBehavior = groupingBehavior,
          selectionBehavior = selectionBehavior,
          requiredBehavior = requiredBehavior,
          precheckBehavior = precheckBehavior,
          cardinalityBehavior = cardinalityBehavior,
          resource = resource?.build(),
          action = action.buildList(),
        )
    }
  }

  public class Builder(
    /**
     * The current state of the request. For request groups, the status reflects the status of all
     * the requests in the group.
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
     * A shared identifier common to all requests that were authorized more or less simultaneously
     * by a single author, representing the identifier of the requisition, prescription or similar
     * form.
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
     * A code that identifies what the overall request group is.
     *
     * This element can be used to provide a code that captures the meaning of the request group as
     * a whole, as opposed to the code of the action element, which captures the meaning of the
     * individual actions within the request group.
     */
    public var code: CodeableConcept.Builder? = null

    /** The subject for which the request group was created. */
    public var subject: Reference.Builder? = null

    /** Describes the context of the request group, if any. */
    public var encounter: Reference.Builder? = null

    /** Indicates when the request group was created. */
    public var authoredOn: DateTime.Builder? = null

    /** Provides a reference to the author of the request group. */
    public var author: Reference.Builder? = null

    /** Describes the reason for the request group in coded or textual form. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates another resource whose existence justifies this request group. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /** Provides a mechanism to communicate additional information about the response. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /** The actions, if any, produced by the evaluation of the artifact. */
    public var action: MutableList<Action.Builder> = mutableListOf()

    override fun build(): RequestGroup =
      RequestGroup(
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
        reasonCode = reasonCode.buildList(),
        reasonReference = reasonReference.buildList(),
        note = note.buildList(),
        action = action.buildList(),
      )
  }
}
