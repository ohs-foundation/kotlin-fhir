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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.CarePlanActivityDetailSerializer
import dev.ohs.fhir.model.r4b.serializers.CarePlanActivitySerializer
import dev.ohs.fhir.model.r4b.serializers.CarePlanSerializer
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
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
  /** A care plan that is fulfilled in whole or in part by this care plan. */
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
   * actually applicable.
   */
  public val intent: Enumeration<CarePlanIntent>,
  /**
   * Identifies what "kind" of plan this is to support differentiation between multiple co-existing
   * plans; e.g. "Home health", "psychiatric", "asthma", "disease management", "wellness plan", etc.
   *
   * There may be multiple axes of categorization and one plan may serve multiple purposes. In some
   * cases, this may be redundant with references to CarePlan.concern.
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
   * When populated, the author is responsible for the care plan. The care plan is attributed to the
   * author.
   *
   * The author may also be a contributor. For example, an organization can be an author, but not
   * listed as a contributor.
   */
  public val author: Reference? = null,
  /**
   * Identifies the individual(s) or organization who provided the contents of the care plan.
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
   * When the diagnosis is related to an allergy or intolerance, the Condition and
   * AllergyIntolerance resources can both be used. However, to be actionable for decision support,
   * using Condition alone is not sufficient as the allergy or intolerance condition needs to be
   * represented as an AllergyIntolerance.
   */
  public val addresses: List<Reference> = listOf(),
  /**
   * Identifies portions of the patient's record that specifically influenced the formation of the
   * plan. These might include comorbidities, recent procedures, limitations, recent assessments,
   * etc.
   *
   * Use "concern" to identify specific conditions addressed by the care plan.
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
   * Identifies a planned action to occur as part of the plan. For example, a medication to be used,
   * lab tests to perform, self-monitoring, education, etc.
   */
  public val activity: List<Activity> = listOf(),
  /** General notes about the care plan not covered elsewhere. */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, intent, subject.toBuilder()).apply {
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
        author = this@with.author?.toBuilder()
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
   * Identifies a planned action to occur as part of the plan. For example, a medication to be used,
   * lab tests to perform, self-monitoring, education, etc.
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
    /**
     * Identifies the outcome at the point when the status of the activity is assessed. For example,
     * the outcome of an education activity could be patient understands (or not).
     *
     * Note that this should not duplicate the activity status (e.g. completed or in progress).
     */
    public val outcomeCodeableConcept: List<CodeableConcept> = listOf(),
    /**
     * Details of the outcome or action resulting from the activity. The reference to an "event"
     * resource, such as Procedure or Encounter or Observation, is the result/outcome of the
     * activity itself. The activity can be conveyed using CarePlan.activity.detail OR using the
     * CarePlan.activity.reference (a reference to a “request” resource).
     *
     * The activity outcome is independent of the outcome of the related goal(s). For example, if
     * the goal is to achieve a target body weight of 150 lbs and an activity is defined to diet,
     * then the activity outcome could be calories consumed whereas the goal outcome is an
     * observation for the actual body weight measured.
     */
    public val outcomeReference: List<Reference> = listOf(),
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
     * Standard extension exists ([resource-pertainsToGoal](extension-resource-pertainstogoal.html))
     * that allows goals to be referenced from any of the referenced resources in
     * CarePlan.activity.reference. The goal should be visible when the resource referenced by
     * CarePlan.activity.reference is viewed independently from the CarePlan. Requests that are
     * pointed to by a CarePlan using this element should *not* point to this CarePlan using the
     * "basedOn" element. i.e. Requests that are part of a CarePlan are not "based on" the CarePlan.
     */
    public val reference: Reference? = null,
    /**
     * A simple summary of a planned activity suitable for a general care plan system (e.g. form
     * driven) that doesn't know about specific resources such as procedure etc.
     */
    public val detail: Detail? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          outcomeCodeableConcept =
            this@with.outcomeCodeableConcept.map { it.toBuilder() }.toMutableList()
          outcomeReference = this@with.outcomeReference.map { it.toBuilder() }.toMutableList()
          progress = this@with.progress.map { it.toBuilder() }.toMutableList()
          reference = this@with.reference?.toBuilder()
          detail = this@with.detail?.toBuilder()
        }
      }

    /**
     * A simple summary of a planned activity suitable for a general care plan system (e.g. form
     * driven) that doesn't know about specific resources such as procedure etc.
     */
    @Serializable(with = CarePlanActivityDetailSerializer::class)
    public data class Detail(
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
       * A description of the kind of resource the in-line definition of a care plan activity is
       * representing. The CarePlan.activity.detail is an in-line definition when a resource is not
       * referenced using CarePlan.activity.reference. For example, a MedicationRequest, a
       * ServiceRequest, or a CommunicationRequest.
       */
      public val kind: Enumeration<CarePlanActivityKind>? = null,
      /**
       * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition
       * that is adhered to in whole or in part by this CarePlan activity.
       */
      public val instantiatesCanonical: List<Canonical> = listOf(),
      /**
       * The URL pointing to an externally maintained protocol, guideline, questionnaire or other
       * definition that is adhered to in whole or in part by this CarePlan activity.
       *
       * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
       */
      public val instantiatesUri: List<Uri> = listOf(),
      /**
       * Detailed description of the type of planned activity; e.g. what lab test, what procedure,
       * what kind of encounter.
       *
       * Tends to be less relevant for activities involving particular products. Codes should not
       * convey negation - use "prohibited" instead.
       */
      public val code: CodeableConcept? = null,
      /**
       * Provides the rationale that drove the inclusion of this particular activity as part of the
       * plan or the reason why the activity was prohibited.
       *
       * This could be a diagnosis code. If a full condition record exists or additional detail is
       * needed, use reasonCondition instead.
       */
      public val reasonCode: List<CodeableConcept> = listOf(),
      /**
       * Indicates another resource, such as the health condition(s), whose existence justifies this
       * request and drove the inclusion of this particular activity as part of the plan.
       *
       * Conditions can be identified at the activity level that are not identified as reasons for
       * the overall plan.
       */
      public val reasonReference: List<Reference> = listOf(),
      /**
       * Internal reference that identifies the goals that this activity is intended to contribute
       * towards meeting.
       */
      public val goal: List<Reference> = listOf(),
      /**
       * Identifies what progress is being made for the specific activity.
       *
       * Some aspects of status can be inferred based on the resources linked in actionTaken. Note
       * that "status" is only as current as the plan was most recently updated. The unknown code is
       * not to be used to convey other statuses. The unknown code should be used when one of the
       * statuses applies, but the authoring system doesn't know the current state of the activity.
       */
      public val status: Enumeration<CarePlanActivityStatus>,
      /**
       * Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.
       *
       * Will generally not be present if status is "complete". Be sure to prompt to update this (or
       * at least remove the existing value) if the status is changed.
       */
      public val statusReason: CodeableConcept? = null,
      /**
       * If true, indicates that the described activity is one that must NOT be engaged in when
       * following the plan. If false, or missing, indicates that the described activity is one that
       * should be engaged in when following the plan.
       *
       * This element is labeled as a modifier because it marks an activity as an activity that is
       * not to be performed.
       */
      public val doNotPerform: Boolean? = null,
      /** The period, timing or frequency upon which the described activity is to occur. */
      public val scheduled: Scheduled? = null,
      /**
       * Identifies the facility where the activity will occur; e.g. home, hospital, specific
       * clinic, etc.
       *
       * May reference a specific clinical location or may identify a type of location.
       */
      public val location: Reference? = null,
      /**
       * Identifies who's expected to be involved in the activity.
       *
       * A performer MAY also be a participant in the care plan.
       */
      public val performer: List<Reference> = listOf(),
      /** Identifies the food, drug or other product to be consumed or supplied in the activity. */
      public val product: Product? = null,
      /** Identifies the quantity expected to be consumed in a given day. */
      public val dailyAmount: Quantity? = null,
      /**
       * Identifies the quantity expected to be supplied, administered or consumed by the subject.
       */
      public val quantity: Quantity? = null,
      /**
       * This provides a textual description of constraints on the intended activity occurrence,
       * including relation to other activities. It may also include objectives, pre-conditions and
       * end-conditions. Finally, it may convey specifics about the activity such as body site,
       * method, route, etc.
       */
      public val description: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(status).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            kind = this@with.kind
            instantiatesCanonical =
              this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
            instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
            code = this@with.code?.toBuilder()
            reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
            reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
            goal = this@with.goal.map { it.toBuilder() }.toMutableList()
            statusReason = this@with.statusReason?.toBuilder()
            doNotPerform = this@with.doNotPerform?.toBuilder()
            scheduled = this@with.scheduled
            location = this@with.location?.toBuilder()
            performer = this@with.performer.map { it.toBuilder() }.toMutableList()
            product = this@with.product
            dailyAmount = this@with.dailyAmount?.toBuilder()
            quantity = this@with.quantity?.toBuilder()
            description = this@with.description?.toBuilder()
          }
        }

      public sealed interface Scheduled {
        public fun asTiming(): Timing? = this as? Timing

        public fun asPeriod(): Period? = this as? Period

        public fun asString(): String? = this as? String

        @JvmInline
        public value class Timing(public val `value`: dev.ohs.fhir.model.r4b.Timing) : Scheduled

        @JvmInline
        public value class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Scheduled

        @JvmInline
        public value class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Scheduled

        public companion object {
          internal fun from(
            timingValue: dev.ohs.fhir.model.r4b.Timing?,
            periodValue: dev.ohs.fhir.model.r4b.Period?,
            stringValue: dev.ohs.fhir.model.r4b.String?,
          ): Scheduled? {
            if (timingValue != null) return Timing(timingValue)
            if (periodValue != null) return Period(periodValue)
            if (stringValue != null) return String(stringValue)
            return null
          }
        }
      }

      public sealed interface Product {
        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asReference(): Reference? = this as? Reference

        @JvmInline
        public value class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r4b.CodeableConcept
        ) : Product

        @JvmInline
        public value class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) :
          Product

        public companion object {
          internal fun from(
            codeableConceptValue: dev.ohs.fhir.model.r4b.CodeableConcept?,
            referenceValue: dev.ohs.fhir.model.r4b.Reference?,
          ): Product? {
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (referenceValue != null) return Reference(referenceValue)
            return null
          }
        }
      }

      public class Builder(
        /**
         * Identifies what progress is being made for the specific activity.
         *
         * Some aspects of status can be inferred based on the resources linked in actionTaken. Note
         * that "status" is only as current as the plan was most recently updated. The unknown code
         * is not to be used to convey other statuses. The unknown code should be used when one of
         * the statuses applies, but the authoring system doesn't know the current state of the
         * activity.
         */
        public var status: Enumeration<CarePlanActivityStatus>
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
         * A description of the kind of resource the in-line definition of a care plan activity is
         * representing. The CarePlan.activity.detail is an in-line definition when a resource is
         * not referenced using CarePlan.activity.reference. For example, a MedicationRequest, a
         * ServiceRequest, or a CommunicationRequest.
         */
        public var kind: Enumeration<CarePlanActivityKind>? = null

        /**
         * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition
         * that is adhered to in whole or in part by this CarePlan activity.
         */
        public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

        /**
         * The URL pointing to an externally maintained protocol, guideline, questionnaire or other
         * definition that is adhered to in whole or in part by this CarePlan activity.
         *
         * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
         */
        public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

        /**
         * Detailed description of the type of planned activity; e.g. what lab test, what procedure,
         * what kind of encounter.
         *
         * Tends to be less relevant for activities involving particular products. Codes should not
         * convey negation - use "prohibited" instead.
         */
        public var code: CodeableConcept.Builder? = null

        /**
         * Provides the rationale that drove the inclusion of this particular activity as part of
         * the plan or the reason why the activity was prohibited.
         *
         * This could be a diagnosis code. If a full condition record exists or additional detail is
         * needed, use reasonCondition instead.
         */
        public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * Indicates another resource, such as the health condition(s), whose existence justifies
         * this request and drove the inclusion of this particular activity as part of the plan.
         *
         * Conditions can be identified at the activity level that are not identified as reasons for
         * the overall plan.
         */
        public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

        /**
         * Internal reference that identifies the goals that this activity is intended to contribute
         * towards meeting.
         */
        public var goal: MutableList<Reference.Builder> = mutableListOf()

        /**
         * Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.
         *
         * Will generally not be present if status is "complete". Be sure to prompt to update this
         * (or at least remove the existing value) if the status is changed.
         */
        public var statusReason: CodeableConcept.Builder? = null

        /**
         * If true, indicates that the described activity is one that must NOT be engaged in when
         * following the plan. If false, or missing, indicates that the described activity is one
         * that should be engaged in when following the plan.
         *
         * This element is labeled as a modifier because it marks an activity as an activity that is
         * not to be performed.
         */
        public var doNotPerform: Boolean.Builder? = null

        /** The period, timing or frequency upon which the described activity is to occur. */
        public var scheduled: Scheduled? = null

        /**
         * Identifies the facility where the activity will occur; e.g. home, hospital, specific
         * clinic, etc.
         *
         * May reference a specific clinical location or may identify a type of location.
         */
        public var location: Reference.Builder? = null

        /**
         * Identifies who's expected to be involved in the activity.
         *
         * A performer MAY also be a participant in the care plan.
         */
        public var performer: MutableList<Reference.Builder> = mutableListOf()

        /**
         * Identifies the food, drug or other product to be consumed or supplied in the activity.
         */
        public var product: Product? = null

        /** Identifies the quantity expected to be consumed in a given day. */
        public var dailyAmount: Quantity.Builder? = null

        /**
         * Identifies the quantity expected to be supplied, administered or consumed by the subject.
         */
        public var quantity: Quantity.Builder? = null

        /**
         * This provides a textual description of constraints on the intended activity occurrence,
         * including relation to other activities. It may also include objectives, pre-conditions
         * and end-conditions. Finally, it may convey specifics about the activity such as body
         * site, method, route, etc.
         */
        public var description: String.Builder? = null

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            kind = kind,
            instantiatesCanonical = instantiatesCanonical.map { it.build() },
            instantiatesUri = instantiatesUri.map { it.build() },
            code = code?.build(),
            reasonCode = reasonCode.map { it.build() },
            reasonReference = reasonReference.map { it.build() },
            goal = goal.map { it.build() },
            status = status,
            statusReason = statusReason?.build(),
            doNotPerform = doNotPerform?.build(),
            scheduled = scheduled,
            location = location?.build(),
            performer = performer.map { it.build() },
            product = product,
            dailyAmount = dailyAmount?.build(),
            quantity = quantity?.build(),
            description = description?.build(),
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

      /**
       * Identifies the outcome at the point when the status of the activity is assessed. For
       * example, the outcome of an education activity could be patient understands (or not).
       *
       * Note that this should not duplicate the activity status (e.g. completed or in progress).
       */
      public var outcomeCodeableConcept: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Details of the outcome or action resulting from the activity. The reference to an "event"
       * resource, such as Procedure or Encounter or Observation, is the result/outcome of the
       * activity itself. The activity can be conveyed using CarePlan.activity.detail OR using the
       * CarePlan.activity.reference (a reference to a “request” resource).
       *
       * The activity outcome is independent of the outcome of the related goal(s). For example, if
       * the goal is to achieve a target body weight of 150 lbs and an activity is defined to diet,
       * then the activity outcome could be calories consumed whereas the goal outcome is an
       * observation for the actual body weight measured.
       */
      public var outcomeReference: MutableList<Reference.Builder> = mutableListOf()

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
       * ([resource-pertainsToGoal](extension-resource-pertainstogoal.html)) that allows goals to be
       * referenced from any of the referenced resources in CarePlan.activity.reference. The goal
       * should be visible when the resource referenced by CarePlan.activity.reference is viewed
       * independently from the CarePlan. Requests that are pointed to by a CarePlan using this
       * element should *not* point to this CarePlan using the "basedOn" element. i.e. Requests that
       * are part of a CarePlan are not "based on" the CarePlan.
       */
      public var reference: Reference.Builder? = null

      /**
       * A simple summary of a planned activity suitable for a general care plan system (e.g. form
       * driven) that doesn't know about specific resources such as procedure etc.
       */
      public var detail: Detail.Builder? = null

      public fun build(): Activity =
        Activity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          outcomeCodeableConcept = outcomeCodeableConcept.map { it.build() },
          outcomeReference = outcomeReference.map { it.build() },
          progress = progress.map { it.build() },
          reference = reference?.build(),
          detail = detail?.build(),
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
     * actually applicable.
     */
    public var intent: Enumeration<CarePlanIntent>,
    /** Identifies the patient or group whose intended care is described by the plan. */
    public var subject: Reference.Builder,
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

    /** A care plan that is fulfilled in whole or in part by this care plan. */
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
     * some cases, this may be redundant with references to CarePlan.concern.
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
     * When populated, the author is responsible for the care plan. The care plan is attributed to
     * the author.
     *
     * The author may also be a contributor. For example, an organization can be an author, but not
     * listed as a contributor.
     */
    public var author: Reference.Builder? = null

    /**
     * Identifies the individual(s) or organization who provided the contents of the care plan.
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
     * When the diagnosis is related to an allergy or intolerance, the Condition and
     * AllergyIntolerance resources can both be used. However, to be actionable for decision
     * support, using Condition alone is not sufficient as the allergy or intolerance condition
     * needs to be represented as an AllergyIntolerance.
     */
    public var addresses: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Identifies portions of the patient's record that specifically influenced the formation of the
     * plan. These might include comorbidities, recent procedures, limitations, recent assessments,
     * etc.
     *
     * Use "concern" to identify specific conditions addressed by the care plan.
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
     * Identifies a planned action to occur as part of the plan. For example, a medication to be
     * used, lab tests to perform, self-monitoring, education, etc.
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
        author = author?.build(),
        contributor = contributor.map { it.build() },
        careTeam = careTeam.map { it.build() },
        addresses = addresses.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        goal = goal.map { it.build() },
        activity = activity.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /**
   * Resource types defined as part of FHIR that can be represented as in-line definitions of a care
   * plan activity.
   */
  public enum class CarePlanActivityKind(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Appointment("Appointment", "http://hl7.org/fhir/resource-types", "Appointment"),
    CommunicationRequest(
      "CommunicationRequest",
      "http://hl7.org/fhir/resource-types",
      "CommunicationRequest",
    ),
    DeviceRequest("DeviceRequest", "http://hl7.org/fhir/resource-types", "DeviceRequest"),
    MedicationRequest(
      "MedicationRequest",
      "http://hl7.org/fhir/resource-types",
      "MedicationRequest",
    ),
    NutritionOrder("NutritionOrder", "http://hl7.org/fhir/resource-types", "NutritionOrder"),
    Task("Task", "http://hl7.org/fhir/resource-types", "Task"),
    ServiceRequest("ServiceRequest", "http://hl7.org/fhir/resource-types", "ServiceRequest"),
    VisionPrescription(
      "VisionPrescription",
      "http://hl7.org/fhir/resource-types",
      "VisionPrescription",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CarePlanActivityKind =
        when (code) {
          "Appointment" -> Appointment
          "CommunicationRequest" -> CommunicationRequest
          "DeviceRequest" -> DeviceRequest
          "MedicationRequest" -> MedicationRequest
          "NutritionOrder" -> NutritionOrder
          "Task" -> Task
          "ServiceRequest" -> ServiceRequest
          "VisionPrescription" -> VisionPrescription
          else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanActivityKind")
        }
    }
  }

  /** Codes that reflect the current state of a care plan activity within its overall life cycle. */
  public enum class CarePlanActivityStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Not_Started("not-started", "http://hl7.org/fhir/care-plan-activity-status", "Not Started"),
    Scheduled("scheduled", "http://hl7.org/fhir/care-plan-activity-status", "Scheduled"),
    In_Progress("in-progress", "http://hl7.org/fhir/care-plan-activity-status", "In Progress"),
    On_Hold("on-hold", "http://hl7.org/fhir/care-plan-activity-status", "On Hold"),
    Completed("completed", "http://hl7.org/fhir/care-plan-activity-status", "Completed"),
    Cancelled("cancelled", "http://hl7.org/fhir/care-plan-activity-status", "Cancelled"),
    Stopped("stopped", "http://hl7.org/fhir/care-plan-activity-status", "Stopped"),
    Unknown("unknown", "http://hl7.org/fhir/care-plan-activity-status", "Unknown"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/care-plan-activity-status",
      "Entered in Error",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): CarePlanActivityStatus =
        when (code) {
          "not-started" -> Not_Started
          "scheduled" -> Scheduled
          "in-progress" -> In_Progress
          "on-hold" -> On_Hold
          "completed" -> Completed
          "cancelled" -> Cancelled
          "stopped" -> Stopped
          "unknown" -> Unknown
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum CarePlanActivityStatus")
        }
    }
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
    Option("option", "http://hl7.org/fhir/request-intent", "Option");

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
          else -> throw IllegalArgumentException("Unknown code $code for enum CarePlanIntent")
        }
    }
  }
}
