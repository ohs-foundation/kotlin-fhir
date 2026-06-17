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

import dev.ohs.fhir.model.r5.serializers.CarePlanActivitySerializer
import dev.ohs.fhir.model.r5.serializers.CarePlanSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the intention of how one or more practitioners intend to deliver care for a particular
 * patient, group or community for a period of time, possibly limited to care for a specific
 * condition or set of conditions.
 */
@Serializable(with = CarePlanSerializer::class)
@SerialName("CarePlan")
public data class CarePlan(
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
   * Business identifiers assigned to this care plan by the performer or other systems which remain
   * constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that
   * is adhered to in whole or in part by this CarePlan.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, questionnaire or other
   * definition that is adhered to in whole or in part by this CarePlan.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /**
   * A higher-level request resource (i.e. a plan, proposal or order) that is fulfilled in whole or
   * in part by this care plan.
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * Completed or terminated care plan whose function is taken by this new care plan.
   *
   * The replacement could be because the initial care plan was immediately rejected (due to an
   * issue) or because the previous care plan was completed, but the need for the action described
   * by the care plan remains ongoing.
   */
  public val replaces: List<Reference> = listOf(),
  /**
   * A larger care plan of which this particular care plan is a component or step.
   *
   * Each care plan is an independent request, such that having a care plan be part of another care
   * plan can cause issues with cascading statuses. As such, this element is still being discussed.
   */
  public val partOf: List<Reference> = listOf(),
  /**
   * Indicates whether the plan is currently being acted upon, represents future intentions or is
   * now a historical record.
   *
   * The unknown code is not to be used to convey other statuses. The unknown code should be used
   * when one of the statuses applies, but the authoring system doesn't know the current state of
   * the care plan.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that marks the plan as not currently valid.
   */
  public val status: Enumeration<RequestStatus>,
  /**
   * Indicates the level of authority/intentionality associated with the care plan and where the
   * care plan fits into the workflow chain.
   *
   * This element is labeled as a modifier because the intent alters when and how the resource is
   * actually applicable. This element is expected to be immutable. E.g. A "proposal" instance
   * should never change to be a "plan" instance or "order" instance. Instead, a new instance
   * 'basedOn' the prior instance should be created with the new 'intent' value.
   */
  public val intent: Enumeration<CarePlanIntent>,
  /**
   * Identifies what "kind" of plan this is to support differentiation between multiple co-existing
   * plans; e.g. "Home health", "psychiatric", "asthma", "disease management", "wellness plan", etc.
   *
   * There may be multiple axes of categorization and one plan may serve multiple purposes. In some
   * cases, this may be redundant with references to CarePlan.addresses.
   */
  public val category: List<CodeableConcept> = listOf(),
  /** Human-friendly name for the care plan. */
  public val title: String? = null,
  /** A description of the scope and nature of the plan. */
  public val description: String? = null,
  /** Identifies the patient or group whose intended care is described by the plan. */
  public val subject: Reference,
  /**
   * The Encounter during which this CarePlan was created or to which the creation of this record is
   * tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter. CarePlan activities conducted as a result of the care plan may well
   * occur as part of other encounters.
   */
  public val encounter: Reference? = null,
  /**
   * Indicates when the plan did (or is intended to) come into effect and end.
   *
   * Any activities scheduled as part of the plan should be constrained to the specified period
   * regardless of whether the activities are planned within a single encounter/episode or across
   * multiple encounters/episodes (e.g. the longitudinal management of a chronic condition).
   */
  public val period: Period? = null,
  /**
   * Represents when this particular CarePlan record was created in the system, which is often a
   * system-generated date.
   */
  public val created: DateTime? = null,
  /**
   * When populated, the custodian is responsible for the care plan. The care plan is attributed to
   * the custodian.
   *
   * The custodian might or might not be a contributor.
   */
  public val custodian: Reference? = null,
  /**
   * Identifies the individual(s), organization or device who provided the contents of the care
   * plan.
   *
   * Collaborative care plans may have multiple contributors.
   */
  public val contributor: List<Reference> = listOf(),
  /**
   * Identifies all people and organizations who are expected to be involved in the care envisioned
   * by this plan.
   */
  public val careTeam: List<Reference> = listOf(),
  /**
   * Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation
   * are handled by this plan.
   *
   * Use CarePlan.addresses.concept when a code sufficiently describes the concern (e.g. condition,
   * problem, diagnosis, risk). Use CarePlan.addresses.reference when referencing a resource, which
   * allows more information to be conveyed, such as onset date. CarePlan.addresses.concept and
   * CarePlan.addresses.reference are not meant to be duplicative. For a single concern, either
   * CarePlan.addresses.concept or CarePlan.addresses.reference can be used.
   * CarePlan.addresses.concept may be a summary code, or CarePlan.addresses.reference may be used
   * to reference a very precise definition of the concern using Condition. Both
   * CarePlan.addresses.concept and CarePlan.addresses.reference can be used if they are describing
   * different concerns for the care plan.
   */
  public val addresses: List<CodeableReference> = listOf(),
  /**
   * Identifies portions of the patient's record that specifically influenced the formation of the
   * plan. These might include comorbidities, recent procedures, limitations, recent assessments,
   * etc.
   *
   * Use "concern" to identify specific conditions addressed by the care plan. supportingInfo can be
   * used to convey one or more Advance Directives or Medical Treatment Consent Directives by
   * referencing Consent or any other request resource with intent = directive.
   */
  public val supportingInfo: List<Reference> = listOf(),
  /**
   * Describes the intended objective(s) of carrying out the care plan.
   *
   * Goal can be achieving a particular change or merely maintaining a current state or even slowing
   * a decline.
   */
  public val goal: List<Reference> = listOf(),
  /**
   * Identifies an action that has occurred or is a planned action to occur as part of the plan. For
   * example, a medication to be used, lab tests to perform, self-monitoring that has occurred,
   * education etc.
   */
  public val activity: List<Activity> = listOf(),
  /** General notes about the care plan not covered elsewhere. */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          intent,
          subject.toBuilder(),
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
          identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
          instantiatesCanonical =
            this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
          instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
          basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
          replaces = this@with.replaces.map { it.toBuilder() }.toMutableList()
          partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
          category = this@with.category.map { it.toBuilder() }.toMutableList()
          title = this@with.title?.toBuilder()
          description = this@with.description?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          period = this@with.period?.toBuilder()
          created = this@with.created?.toBuilder()
          custodian = this@with.custodian?.toBuilder()
          contributor = this@with.contributor.map { it.toBuilder() }.toMutableList()
          careTeam = this@with.careTeam.map { it.toBuilder() }.toMutableList()
          addresses = this@with.addresses.map { it.toBuilder() }.toMutableList()
          supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
          goal = this@with.goal.map { it.toBuilder() }.toMutableList()
          activity = this@with.activity.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * Identifies an action that has occurred or is a planned action to occur as part of the plan. For
   * example, a medication to be used, lab tests to perform, self-monitoring that has occurred,
   * education etc.
   */
  @Serializable(with = CarePlanActivitySerializer::class)
  public data class Activity(
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
     * Identifies the activity that was performed. For example, an activity could be patient
     * education, exercise, or a medication administration. The reference to an "event" resource,
     * such as Procedure or Encounter or Observation, represents the activity that was performed.
     * The requested activity can be conveyed using the CarePlan.activity.plannedActivityReference
     * (a reference to a “request” resource).
     *
     * Note that this should not duplicate the activity status (e.g. completed or in progress). The
     * activity performed is independent of the outcome of the related goal(s). For example, if the
     * goal is to achieve a target body weight of 150 lbs and an activity is defined to exercise,
     * then the activity performed could be amount and intensity of exercise performed whereas the
     * goal outcome is an observation for the actual body weight measured.
     */
    public val performedActivity: List<CodeableReference> = listOf(),
    /**
     * Notes about the adherence/status/progress of the activity.
     *
     * This element should NOT be used to describe the activity to be performed - that occurs either
     * within the resource pointed to by activity.detail.reference or in
     * activity.detail.description.
     */
    public val progress: List<Annotation> = listOf(),
    /**
     * The details of the proposed activity represented in a specific resource.
     *
     * Standard extension exists
     * ([http://hl7.org/fhir/StructureDefinition/resource-pertainsToGoal](http://hl7.org/fhir/extensions/StructureDefinition-resource-pertainsToGoal.html))
     * that allows goals to be referenced from any of the referenced resources in
     * CarePlan.activity.plannedActivityReference. The goal should be visible when the resource
     * referenced by CarePlan.activity.plannedActivityReference is viewed independently from the
     * CarePlan. Requests that are pointed to by a CarePlan using this element should *not* point to
     * this CarePlan using the "basedOn" element. i.e. Requests that are part of a CarePlan are not
     * "based on" the CarePlan.
     */
    public val plannedActivityReference: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          performedActivity = this@with.performedActivity.map { it.toBuilder() }.toMutableList()
          progress = this@with.progress.map { it.toBuilder() }.toMutableList()
          plannedActivityReference = this@with.plannedActivityReference?.toBuilder()
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
       * Identifies the activity that was performed. For example, an activity could be patient
       * education, exercise, or a medication administration. The reference to an "event" resource,
       * such as Procedure or Encounter or Observation, represents the activity that was performed.
       * The requested activity can be conveyed using the CarePlan.activity.plannedActivityReference
       * (a reference to a “request” resource).
       *
       * Note that this should not duplicate the activity status (e.g. completed or in progress).
       * The activity performed is independent of the outcome of the related goal(s). For example,
       * if the goal is to achieve a target body weight of 150 lbs and an activity is defined to
       * exercise, then the activity performed could be amount and intensity of exercise performed
       * whereas the goal outcome is an observation for the actual body weight measured.
       */
      public var performedActivity: MutableList<CodeableReference.Builder> = mutableListOf()

      /**
       * Notes about the adherence/status/progress of the activity.
       *
       * This element should NOT be used to describe the activity to be performed - that occurs
       * either within the resource pointed to by activity.detail.reference or in
       * activity.detail.description.
       */
      public var progress: MutableList<Annotation.Builder> = mutableListOf()

      /**
       * The details of the proposed activity represented in a specific resource.
       *
       * Standard extension exists
       * ([http://hl7.org/fhir/StructureDefinition/resource-pertainsToGoal](http://hl7.org/fhir/extensions/StructureDefinition-resource-pertainsToGoal.html))
       * that allows goals to be referenced from any of the referenced resources in
       * CarePlan.activity.plannedActivityReference. The goal should be visible when the resource
       * referenced by CarePlan.activity.plannedActivityReference is viewed independently from the
       * CarePlan. Requests that are pointed to by a CarePlan using this element should *not* point
       * to this CarePlan using the "basedOn" element. i.e. Requests that are part of a CarePlan are
       * not "based on" the CarePlan.
       */
      public var plannedActivityReference: Reference.Builder? = null

      public fun build(): Activity =
        Activity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          performedActivity = performedActivity.map { it.build() },
          progress = progress.map { it.build() },
          plannedActivityReference = plannedActivityReference?.build(),
        )
    }
  }

  public class Builder(
    /**
     * Indicates whether the plan is currently being acted upon, represents future intentions or is
     * now a historical record.
     *
     * The unknown code is not to be used to convey other statuses. The unknown code should be used
     * when one of the statuses applies, but the authoring system doesn't know the current state of
     * the care plan.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that marks the plan as not currently valid.
     */
    public var status: Enumeration<RequestStatus>,
    /**
     * Indicates the level of authority/intentionality associated with the care plan and where the
     * care plan fits into the workflow chain.
     *
     * This element is labeled as a modifier because the intent alters when and how the resource is
     * actually applicable. This element is expected to be immutable. E.g. A "proposal" instance
     * should never change to be a "plan" instance or "order" instance. Instead, a new instance
     * 'basedOn' the prior instance should be created with the new 'intent' value.
     */
    public var intent: Enumeration<CarePlanIntent>,
    /** Identifies the patient or group whose intended care is described by the plan. */
    public var subject: Reference.Builder,
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
     * Business identifiers assigned to this care plan by the performer or other systems which
     * remain constant as the resource is updated and propagates from server to server.
     *
     * This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition
     * that is adhered to in whole or in part by this CarePlan.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, questionnaire or other
     * definition that is adhered to in whole or in part by this CarePlan.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * A higher-level request resource (i.e. a plan, proposal or order) that is fulfilled in whole
     * or in part by this care plan.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Completed or terminated care plan whose function is taken by this new care plan.
     *
     * The replacement could be because the initial care plan was immediately rejected (due to an
     * issue) or because the previous care plan was completed, but the need for the action described
     * by the care plan remains ongoing.
     */
    public var replaces: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A larger care plan of which this particular care plan is a component or step.
     *
     * Each care plan is an independent request, such that having a care plan be part of another
     * care plan can cause issues with cascading statuses. As such, this element is still being
     * discussed.
     */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies what "kind" of plan this is to support differentiation between multiple
     * co-existing plans; e.g. "Home health", "psychiatric", "asthma", "disease management",
     * "wellness plan", etc.
     *
     * There may be multiple axes of categorization and one plan may serve multiple purposes. In
     * some cases, this may be redundant with references to CarePlan.addresses.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Human-friendly name for the care plan. */
    public var title: String.Builder? = null

    /** A description of the scope and nature of the plan. */
    public var description: String.Builder? = null

    /**
     * The Encounter during which this CarePlan was created or to which the creation of this record
     * is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter. CarePlan activities conducted as a result of the care plan may well
     * occur as part of other encounters.
     */
    public var encounter: Reference.Builder? = null

    /**
     * Indicates when the plan did (or is intended to) come into effect and end.
     *
     * Any activities scheduled as part of the plan should be constrained to the specified period
     * regardless of whether the activities are planned within a single encounter/episode or across
     * multiple encounters/episodes (e.g. the longitudinal management of a chronic condition).
     */
    public var period: Period.Builder? = null

    /**
     * Represents when this particular CarePlan record was created in the system, which is often a
     * system-generated date.
     */
    public var created: DateTime.Builder? = null

    /**
     * When populated, the custodian is responsible for the care plan. The care plan is attributed
     * to the custodian.
     *
     * The custodian might or might not be a contributor.
     */
    public var custodian: Reference.Builder? = null

    /**
     * Identifies the individual(s), organization or device who provided the contents of the care
     * plan.
     *
     * Collaborative care plans may have multiple contributors.
     */
    public var contributor: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies all people and organizations who are expected to be involved in the care
     * envisioned by this plan.
     */
    public var careTeam: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation
     * are handled by this plan.
     *
     * Use CarePlan.addresses.concept when a code sufficiently describes the concern (e.g.
     * condition, problem, diagnosis, risk). Use CarePlan.addresses.reference when referencing a
     * resource, which allows more information to be conveyed, such as onset date.
     * CarePlan.addresses.concept and CarePlan.addresses.reference are not meant to be duplicative.
     * For a single concern, either CarePlan.addresses.concept or CarePlan.addresses.reference can
     * be used. CarePlan.addresses.concept may be a summary code, or CarePlan.addresses.reference
     * may be used to reference a very precise definition of the concern using Condition. Both
     * CarePlan.addresses.concept and CarePlan.addresses.reference can be used if they are
     * describing different concerns for the care plan.
     */
    public var addresses: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Identifies portions of the patient's record that specifically influenced the formation of the
     * plan. These might include comorbidities, recent procedures, limitations, recent assessments,
     * etc.
     *
     * Use "concern" to identify specific conditions addressed by the care plan. supportingInfo can
     * be used to convey one or more Advance Directives or Medical Treatment Consent Directives by
     * referencing Consent or any other request resource with intent = directive.
     */
    public var supportingInfo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Describes the intended objective(s) of carrying out the care plan.
     *
     * Goal can be achieving a particular change or merely maintaining a current state or even
     * slowing a decline.
     */
    public var goal: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies an action that has occurred or is a planned action to occur as part of the plan.
     * For example, a medication to be used, lab tests to perform, self-monitoring that has
     * occurred, education etc.
     */
    public var activity: MutableList<Activity.Builder> = mutableListOf()

    /** General notes about the care plan not covered elsewhere. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): CarePlan =
      CarePlan(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        basedOn = basedOn.map { it.build() },
        replaces = replaces.map { it.build() },
        partOf = partOf.map { it.build() },
        status = status,
        intent = intent,
        category = category.map { it.build() },
        title = title?.build(),
        description = description?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        period = period?.build(),
        created = created?.build(),
        custodian = custodian?.build(),
        contributor = contributor.map { it.build() },
        careTeam = careTeam.map { it.build() },
        addresses = addresses.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        goal = goal.map { it.build() },
        activity = activity.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a request. */
  public enum class RequestStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
    Active("active", "http://hl7.org/fhir/request-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
    Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
    Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): RequestStatus =
        when (code) {
          "draft" -> Draft
          "active" -> Active
          "on-hold" -> On_Hold
          "revoked" -> Revoked
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
        }
    }
  }

  /** Codes indicating the degree of authority/intentionality associated with a care plan. */
  public enum class CarePlanIntent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Proposal("proposal", "http://hl7.org/fhir/request-intent", "Proposal"),
    Plan("plan", "http://hl7.org/fhir/request-intent", "Plan"),
    Order("order", "http://hl7.org/fhir/request-intent", "Order"),
    Option("option", "http://hl7.org/fhir/request-intent", "Option"),
    Directive("directive", "http://hl7.org/fhir/request-intent", "Directive");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CarePlanIntent =
        when (code) {
          "proposal" -> Proposal
          "plan" -> Plan
          "order" -> Order
          "option" -> Option
          "directive" -> Directive
          else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanIntent")
        }
    }
  }
}
