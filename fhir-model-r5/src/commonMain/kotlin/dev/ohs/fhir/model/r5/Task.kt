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

import dev.ohs.fhir.model.r5.serializers.TaskInputSerializer
import dev.ohs.fhir.model.r5.serializers.TaskOutputSerializer
import dev.ohs.fhir.model.r5.serializers.TaskPerformerSerializer
import dev.ohs.fhir.model.r5.serializers.TaskRestrictionSerializer
import dev.ohs.fhir.model.r5.serializers.TaskSerializer
import dev.ohs.fhir.model.r5.terminologies.RequestPriority
import dev.ohs.fhir.model.r5.terminologies.TaskIntent
import dev.ohs.fhir.model.r5.terminologies.TaskStatus
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A task to be performed. */
@Serializable(with = TaskSerializer::class)
@SerialName("Task")
public data class Task(
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
  /** The business identifier for this task. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this Task.
   */
  public val instantiatesCanonical: Canonical? = null,
  /**
   * The URL pointing to an *externally* maintained protocol, guideline, orderset or other
   * definition that is adhered to in whole or in part by this Task.
   */
  public val instantiatesUri: Uri? = null,
  /**
   * BasedOn refers to a higher-level authorization that triggered the creation of the task. It
   * references a "request" resource such as a ServiceRequest, MedicationRequest, CarePlan, etc.
   * which is distinct from the "request" resource the task is seeking to fulfill. This latter
   * resource is referenced by focus. For example, based on a CarePlan (= basedOn), a task is
   * created to fulfill a ServiceRequest ( = focus ) to collect a specimen from a patient.
   *
   * Task.basedOn is never the same as Task.focus. Task.basedOn will typically not be present for
   * 'please fulfill' Tasks as a distinct authorization is rarely needed to request fulfillment. If
   * the Task is seeking fulfillment of an order, the order to be fulfilled is always communicated
   * using `focus`, never basedOn. However, authorization may be needed to perform other types of
   * Task actions. As an example of when both would be present, a Task seeking suspension of a
   * prescription might have a Task.basedOn pointing to the ServiceRequest ordering surgery (which
   * is the driver for suspending the MedicationRequest - which would be the Task.focus).
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * A shared identifier common to multiple independent Task and Request instances that were
   * activated/authorized more or less simultaneously by a single author. The presence of the same
   * identifier on each request ties those requests together and may have business ramifications in
   * terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of lab
   * tests ordered together, or a prescription number shared by all meds ordered at one time.
   */
  public val groupIdentifier: Identifier? = null,
  /**
   * Task that this particular task is part of.
   *
   * This should usually be 0..1.
   */
  public val partOf: List<Reference> = listOf(),
  /** The current status of the task. */
  public val status: Enumeration<TaskStatus>,
  /**
   * An explanation as to why this task is held, failed, was refused, etc.
   *
   * This applies to the current status. Look at the history of the task to see reasons for past
   * statuses.
   */
  public val statusReason: CodeableReference? = null,
  /** Contains business-specific nuances of the business state. */
  public val businessStatus: CodeableConcept? = null,
  /**
   * Indicates the "level" of actionability associated with the Task, i.e. i+R[9]Cs this a proposed
   * task, a planned task, an actionable task, etc.
   *
   * This element is immutable. Proposed tasks, planned tasks, etc. must be distinct instances.
   *
   * In most cases, Tasks will have an intent of "order".
   */
  public val intent: Enumeration<TaskIntent>,
  /** Indicates how quickly the Task should be addressed with respect to other requests. */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * If true indicates that the Task is asking for the specified action to *not* occur.
   *
   * The attributes provided with the Task qualify what is not to be done. For example, if a
   * requestedPeriod is provided, the 'do not' request only applies within the specified time. If a
   * requestedPerformer is specified then the 'do not' request only applies to performers of that
   * type. Qualifiers include: code, subject, occurrence, requestedPerformer and performer.
   *
   * In some cases, the Request.code may pre-coordinate prohibition into the requested action. E.g.
   * 'NPO' (nothing by mouth), 'DNR' (do not recussitate). If this happens, doNotPerform SHALL NOT
   * be set to true. I.e. The resource shall not have double negation. (E.g. 'Do not DNR').
   *
   * doNotPerform should ONLY be used with Tasks that are tightly bounded in time or process phase.
   * E.g. 'Do not fulfill the midnight dose of medication X tonight due to the early morning
   * scheduled procedure, where the nurse could reasonably check off 'Med X not given at midnight as
   * instructed'. Similarly, a decision support proposal that a patient should not be given a
   * standard intake questionnaire (because the patient is cognitively impaired) would be marked as
   * 'complete' or 'rejected' when the clinician preps the CarePlan or order set after reviewing the
   * decision support results. If there is a need to create a standing order to not do something
   * that can't be satisfied by a single 'non-action', but rather an ongoing refusal to perform the
   * function, MedicationRequest, ServiceRequest or some other form of authorization should be used.
   */
  public val doNotPerform: Boolean? = null,
  /**
   * A name or code (or both) briefly describing what the task involves.
   *
   * The title (eg "My Tasks", "Outstanding Tasks for Patient X") should go into the code.
   */
  public val code: CodeableConcept? = null,
  /** A free-text description of what is to be performed. */
  public val description: String? = null,
  /**
   * The request being fulfilled or the resource being manipulated (changed, suspended, etc.) by
   * this task.
   *
   * If multiple resources need to be manipulated, use sub-tasks. (This ensures that status can be
   * tracked independently for each referenced resource.).
   */
  public val focus: Reference? = null,
  /**
   * The entity who benefits from the performance of the service specified in the task (e.g., the
   * patient).
   */
  public val `for`: Reference? = null,
  /**
   * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
   * task was created.
   */
  public val encounter: Reference? = null,
  /**
   * Indicates the start and/or end of the period of time when completion of the task is desired to
   * take place.
   *
   * This is typically used when the Task is *not* seeking fulfillment of a focus Request, as in
   * that case the period would be specified on the Request and/or in the Task.restriction.period.
   * Instead, it is used for stand-alone tasks.
   */
  public val requestedPeriod: Period? = null,
  /**
   * Identifies the time action was first taken against the task (start) and/or the time final
   * action was taken against the task prior to marking it as completed (end).
   */
  public val executionPeriod: Period? = null,
  /** The date and time this task was created. */
  public val authoredOn: DateTime? = null,
  /** The date and time of last modification to this task. */
  public val lastModified: DateTime? = null,
  /** The creator of the task. */
  public val requester: Reference? = null,
  /** The kind of participant or specific participant that should perform the task. */
  public val requestedPerformer: List<CodeableReference> = listOf(),
  /**
   * Party responsible for managing task execution.
   *
   * Tasks may be created with an owner not yet identified.
   */
  public val owner: Reference? = null,
  /** The entity who performed the requested task. */
  public val performer: List<Performer> = listOf(),
  /**
   * Principal physical location where this task is performed.
   *
   * This should only be specified when the Task to be/being performed happens or is expected to
   * happen primarily within the bounds of a single Location. Other locations (e.g. source,
   * destination, etc.) would either be reflected on the 'basedOn' Request or be conveyed as
   * distinct Task.input values.
   */
  public val location: Reference? = null,
  /**
   * A description, code, or reference indicating why this task needs to be performed.
   *
   * This will typically not be present for Tasks with a code of 'please fulfill' as, for those, the
   * reason for action is conveyed on the Request pointed to by Task.focus. Some types of tasks will
   * not need a 'reason'. E.g. a request to discharge a patient can be inferred to be 'because the
   * patient is ready' and this would not need a reason to be stated on the Task.
   */
  public val reason: List<CodeableReference> = listOf(),
  /**
   * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be
   * relevant to the Task.
   */
  public val insurance: List<Reference> = listOf(),
  /** Free-text information captured about the task as it progresses. */
  public val note: List<Annotation> = listOf(),
  /**
   * Links to Provenance records for past versions of this Task that identify key state transitions
   * or updates that are likely to be relevant to a user looking at the current version of the task.
   *
   * This element does not point to the Provenance associated with the *current* version of the
   * resource - as it would be created after this version existed. The Provenance for the current
   * version can be retrieved with a _revinclude.
   */
  public val relevantHistory: List<Reference> = listOf(),
  /**
   * If the Task.focus is a request resource and the task is seeking fulfillment (i.e. is asking for
   * the request to be actioned), this element identifies any limitations on what parts of the
   * referenced request should be actioned.
   *
   * Task.restriction can only be present if the Task is seeking fulfillment of another Request
   * resource, and the restriction identifies what subset of the authorization conveyed by the
   * request is supposed to be fulfilled by this Task. A possible example could be a standing order
   * (the request) covering a significant time period and/or individuals, while the Task seeks
   * fulfillment for only a subset of that time-period and a single individual.
   */
  public val restriction: Restriction? = null,
  /** Additional information that may be needed in the execution of the task. */
  public val input: List<Input> = listOf(),
  /** Outputs produced by the Task. */
  public val output: List<Output> = listOf(),
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
    builder.instantiatesCanonical = instantiatesCanonical?.toBuilder()
    builder.instantiatesUri = instantiatesUri?.toBuilder()
    builder.basedOn = basedOn.toBuilderList()
    builder.groupIdentifier = groupIdentifier?.toBuilder()
    builder.partOf = partOf.toBuilderList()
    builder.statusReason = statusReason?.toBuilder()
    builder.businessStatus = businessStatus?.toBuilder()
    builder.priority = priority
    builder.doNotPerform = doNotPerform?.toBuilder()
    builder.code = code?.toBuilder()
    builder.description = description?.toBuilder()
    builder.focus = focus?.toBuilder()
    builder.`for` = `for`?.toBuilder()
    builder.encounter = encounter?.toBuilder()
    builder.requestedPeriod = requestedPeriod?.toBuilder()
    builder.executionPeriod = executionPeriod?.toBuilder()
    builder.authoredOn = authoredOn?.toBuilder()
    builder.lastModified = lastModified?.toBuilder()
    builder.requester = requester?.toBuilder()
    builder.requestedPerformer = requestedPerformer.toBuilderList()
    builder.owner = owner?.toBuilder()
    builder.performer = performer.toBuilderList()
    builder.location = location?.toBuilder()
    builder.reason = reason.toBuilderList()
    builder.insurance = insurance.toBuilderList()
    builder.note = note.toBuilderList()
    builder.relevantHistory = relevantHistory.toBuilderList()
    builder.restriction = restriction?.toBuilder()
    builder.input = input.toBuilderList()
    builder.output = output.toBuilderList()
    return builder
  }

  /** The entity who performed the requested task. */
  @Serializable(with = TaskPerformerSerializer::class)
  public data class Performer(
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
    /** A code or description of the performer of the task. */
    public val function: CodeableConcept? = null,
    /** The actor or entity who performed the task. */
    public val actor: Reference,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(actor.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.function = function?.toBuilder()
      return builder
    }

    public class Builder(
      /** The actor or entity who performed the task. */
      public var actor: Reference.Builder
    ) : FhirBuilder {
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

      /** A code or description of the performer of the task. */
      public var function: CodeableConcept.Builder? = null

      override fun build(): Performer =
        Performer(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  /**
   * If the Task.focus is a request resource and the task is seeking fulfillment (i.e. is asking for
   * the request to be actioned), this element identifies any limitations on what parts of the
   * referenced request should be actioned.
   */
  @Serializable(with = TaskRestrictionSerializer::class)
  public data class Restriction(
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
    /** Indicates the number of times the requested action should occur. */
    public val repetitions: PositiveInt? = null,
    /**
     * The time-period for which fulfillment is sought. This must fall within the overall time
     * period authorized in the referenced request. E.g. ServiceRequest.occurance[x].
     *
     * This is distinct from Task.executionPeriod. ExecutionPeriod indicates when the task needs to
     * be initiated, while Task.restriction.period specifies the subset of the overall authorization
     * that this period covers. For example, a MedicationRequest with an overall effective period of
     * 1 year might have a Task whose restriction.period is 2 months (i.e. satisfy 2 months of
     * medication therapy), while the execution period might be 'between now and 5 days from now' -
     * i.e. If you say yes to this, then you're agreeing to supply medication for that 2 month
     * period within the next 5 days.
     *
     * Note that period.high is the due date representing the time by which the task should be
     * completed.
     */
    public val period: Period? = null,
    /**
     * For requests that are targeted to more than one potential recipient/target, to identify who
     * is fulfillment is sought for.
     */
    public val recipient: List<Reference> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.repetitions = repetitions?.toBuilder()
      builder.period = period?.toBuilder()
      builder.recipient = recipient.toBuilderList()
      return builder
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

      /** Indicates the number of times the requested action should occur. */
      public var repetitions: PositiveInt.Builder? = null

      /**
       * The time-period for which fulfillment is sought. This must fall within the overall time
       * period authorized in the referenced request. E.g. ServiceRequest.occurance[x].
       *
       * This is distinct from Task.executionPeriod. ExecutionPeriod indicates when the task needs
       * to be initiated, while Task.restriction.period specifies the subset of the overall
       * authorization that this period covers. For example, a MedicationRequest with an overall
       * effective period of 1 year might have a Task whose restriction.period is 2 months (i.e.
       * satisfy 2 months of medication therapy), while the execution period might be 'between now
       * and 5 days from now' - i.e. If you say yes to this, then you're agreeing to supply
       * medication for that 2 month period within the next 5 days.
       *
       * Note that period.high is the due date representing the time by which the task should be
       * completed.
       */
      public var period: Period.Builder? = null

      /**
       * For requests that are targeted to more than one potential recipient/target, to identify who
       * is fulfillment is sought for.
       */
      public var recipient: MutableList<Reference.Builder> = mutableListOf()

      override fun build(): Restriction =
        Restriction(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          repetitions = repetitions?.build(),
          period = period?.build(),
          recipient = recipient.buildList(),
        )
    }
  }

  /** Additional information that may be needed in the execution of the task. */
  @Serializable(with = TaskInputSerializer::class)
  public data class Input(
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
     * A code or description indicating how the input is intended to be used as part of the task
     * execution.
     *
     * If referencing a BPMN workflow or Protocol, the "system" is the URL for the workflow
     * definition and the code is the "name" of the required input.
     */
    public val type: CodeableConcept,
    /** The value of the input parameter as a basic type. */
    public val `value`: Value,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          type.toBuilder(),
          `value`,
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public sealed interface Value : FhirChoice {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asInteger64(): Integer64? = this as? Integer64

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCodeableReference(): CodeableReference? = this as? CodeableReference

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asRatioRange(): RatioRange? = this as? RatioRange

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asAvailability(): Availability? = this as? Availability

      public fun asExtendedContactDetail(): ExtendedContactDetail? = this as? ExtendedContactDetail

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(override val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
        Value

      public data class Boolean(override val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Canonical(override val `value`: dev.ohs.fhir.model.r5.Canonical) : Value

      public data class Code(override val `value`: dev.ohs.fhir.model.r5.Code) : Value

      public data class Date(override val `value`: dev.ohs.fhir.model.r5.Date) : Value

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

      public data class Decimal(override val `value`: dev.ohs.fhir.model.r5.Decimal) : Value

      public data class Id(override val `value`: dev.ohs.fhir.model.r5.Id) : Value

      public data class Instant(override val `value`: dev.ohs.fhir.model.r5.Instant) : Value

      public data class Integer(override val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Integer64(override val `value`: dev.ohs.fhir.model.r5.Integer64) : Value

      public data class Markdown(override val `value`: dev.ohs.fhir.model.r5.Markdown) : Value

      public data class Oid(override val `value`: dev.ohs.fhir.model.r5.Oid) : Value

      public data class PositiveInt(override val `value`: dev.ohs.fhir.model.r5.PositiveInt) : Value

      public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Time(override val `value`: dev.ohs.fhir.model.r5.Time) : Value

      public data class UnsignedInt(override val `value`: dev.ohs.fhir.model.r5.UnsignedInt) : Value

      public data class Uri(override val `value`: dev.ohs.fhir.model.r5.Uri) : Value

      public data class Url(override val `value`: dev.ohs.fhir.model.r5.Url) : Value

      public data class Uuid(override val `value`: dev.ohs.fhir.model.r5.Uuid) : Value

      public data class Address(override val `value`: dev.ohs.fhir.model.r5.Address) : Value

      public data class Age(override val `value`: dev.ohs.fhir.model.r5.Age) : Value

      public data class Annotation(override val `value`: dev.ohs.fhir.model.r5.Annotation) : Value

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      public data class CodeableReference(
        override val `value`: dev.ohs.fhir.model.r5.CodeableReference
      ) : Value

      public data class Coding(override val `value`: dev.ohs.fhir.model.r5.Coding) : Value

      public data class ContactPoint(override val `value`: dev.ohs.fhir.model.r5.ContactPoint) :
        Value

      public data class Count(override val `value`: dev.ohs.fhir.model.r5.Count) : Value

      public data class Distance(override val `value`: dev.ohs.fhir.model.r5.Distance) : Value

      public data class Duration(override val `value`: dev.ohs.fhir.model.r5.Duration) : Value

      public data class HumanName(override val `value`: dev.ohs.fhir.model.r5.HumanName) : Value

      public data class Identifier(override val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

      public data class Money(override val `value`: dev.ohs.fhir.model.r5.Money) : Value

      public data class Period(override val `value`: dev.ohs.fhir.model.r5.Period) : Value

      public data class Quantity(override val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(override val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Ratio(override val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

      public data class RatioRange(override val `value`: dev.ohs.fhir.model.r5.RatioRange) : Value

      public data class Reference(override val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public data class SampledData(override val `value`: dev.ohs.fhir.model.r5.SampledData) : Value

      public data class Signature(override val `value`: dev.ohs.fhir.model.r5.Signature) : Value

      public data class Timing(override val `value`: dev.ohs.fhir.model.r5.Timing) : Value

      public data class ContactDetail(override val `value`: dev.ohs.fhir.model.r5.ContactDetail) :
        Value

      public data class DataRequirement(
        override val `value`: dev.ohs.fhir.model.r5.DataRequirement
      ) : Value

      public data class Expression(override val `value`: dev.ohs.fhir.model.r5.Expression) : Value

      public data class ParameterDefinition(
        override val `value`: dev.ohs.fhir.model.r5.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(
        override val `value`: dev.ohs.fhir.model.r5.RelatedArtifact
      ) : Value

      public data class TriggerDefinition(
        override val `value`: dev.ohs.fhir.model.r5.TriggerDefinition
      ) : Value

      public data class UsageContext(override val `value`: dev.ohs.fhir.model.r5.UsageContext) :
        Value

      public data class Availability(override val `value`: dev.ohs.fhir.model.r5.Availability) :
        Value

      public data class ExtendedContactDetail(
        override val `value`: dev.ohs.fhir.model.r5.ExtendedContactDetail
      ) : Value

      public data class Dosage(override val `value`: dev.ohs.fhir.model.r5.Dosage) : Value

      public data class Meta(override val `value`: dev.ohs.fhir.model.r5.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          codeValue: dev.ohs.fhir.model.r5.Code?,
          dateValue: dev.ohs.fhir.model.r5.Date?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          decimalValue: dev.ohs.fhir.model.r5.Decimal?,
          idValue: dev.ohs.fhir.model.r5.Id?,
          instantValue: dev.ohs.fhir.model.r5.Instant?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          integer64Value: dev.ohs.fhir.model.r5.Integer64?,
          markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          oidValue: dev.ohs.fhir.model.r5.Oid?,
          positiveIntValue: dev.ohs.fhir.model.r5.PositiveInt?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          timeValue: dev.ohs.fhir.model.r5.Time?,
          unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
          urlValue: dev.ohs.fhir.model.r5.Url?,
          uuidValue: dev.ohs.fhir.model.r5.Uuid?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          ageValue: dev.ohs.fhir.model.r5.Age?,
          annotationValue: dev.ohs.fhir.model.r5.Annotation?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          codeableReferenceValue: dev.ohs.fhir.model.r5.CodeableReference?,
          codingValue: dev.ohs.fhir.model.r5.Coding?,
          contactPointValue: dev.ohs.fhir.model.r5.ContactPoint?,
          countValue: dev.ohs.fhir.model.r5.Count?,
          distanceValue: dev.ohs.fhir.model.r5.Distance?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          humanNameValue: dev.ohs.fhir.model.r5.HumanName?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
          moneyValue: dev.ohs.fhir.model.r5.Money?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          ratioRangeValue: dev.ohs.fhir.model.r5.RatioRange?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          sampledDataValue: dev.ohs.fhir.model.r5.SampledData?,
          signatureValue: dev.ohs.fhir.model.r5.Signature?,
          timingValue: dev.ohs.fhir.model.r5.Timing?,
          contactDetailValue: dev.ohs.fhir.model.r5.ContactDetail?,
          dataRequirementValue: dev.ohs.fhir.model.r5.DataRequirement?,
          expressionValue: dev.ohs.fhir.model.r5.Expression?,
          parameterDefinitionValue: dev.ohs.fhir.model.r5.ParameterDefinition?,
          relatedArtifactValue: dev.ohs.fhir.model.r5.RelatedArtifact?,
          triggerDefinitionValue: dev.ohs.fhir.model.r5.TriggerDefinition?,
          usageContextValue: dev.ohs.fhir.model.r5.UsageContext?,
          availabilityValue: dev.ohs.fhir.model.r5.Availability?,
          extendedContactDetailValue: dev.ohs.fhir.model.r5.ExtendedContactDetail?,
          dosageValue: dev.ohs.fhir.model.r5.Dosage?,
          metaValue: dev.ohs.fhir.model.r5.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (integer64Value != null) return Integer64(integer64Value)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codeableReferenceValue != null) return CodeableReference(codeableReferenceValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (ratioRangeValue != null) return RatioRange(ratioRangeValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (availabilityValue != null) return Availability(availabilityValue)
          if (extendedContactDetailValue != null)
            return ExtendedContactDetail(extendedContactDetailValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * A code or description indicating how the input is intended to be used as part of the task
       * execution.
       *
       * If referencing a BPMN workflow or Protocol, the "system" is the URL for the workflow
       * definition and the code is the "name" of the required input.
       */
      public var type: CodeableConcept.Builder,
      /** The value of the input parameter as a basic type. */
      public var `value`: Value,
    ) : FhirBuilder {
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

      override fun build(): Input =
        Input(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  /** Outputs produced by the Task. */
  @Serializable(with = TaskOutputSerializer::class)
  public data class Output(
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
    /** The name of the Output parameter. */
    public val type: CodeableConcept,
    /** The value of the Output parameter as a basic type. */
    public val `value`: Value,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          type.toBuilder(),
          `value`,
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public sealed interface Value : FhirChoice {
      public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

      public fun asBoolean(): Boolean? = this as? Boolean

      public fun asCanonical(): Canonical? = this as? Canonical

      public fun asCode(): Code? = this as? Code

      public fun asDate(): Date? = this as? Date

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asId(): Id? = this as? Id

      public fun asInstant(): Instant? = this as? Instant

      public fun asInteger(): Integer? = this as? Integer

      public fun asInteger64(): Integer64? = this as? Integer64

      public fun asMarkdown(): Markdown? = this as? Markdown

      public fun asOid(): Oid? = this as? Oid

      public fun asPositiveInt(): PositiveInt? = this as? PositiveInt

      public fun asString(): String? = this as? String

      public fun asTime(): Time? = this as? Time

      public fun asUnsignedInt(): UnsignedInt? = this as? UnsignedInt

      public fun asUri(): Uri? = this as? Uri

      public fun asUrl(): Url? = this as? Url

      public fun asUuid(): Uuid? = this as? Uuid

      public fun asAddress(): Address? = this as? Address

      public fun asAge(): Age? = this as? Age

      public fun asAnnotation(): Annotation? = this as? Annotation

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asCodeableReference(): CodeableReference? = this as? CodeableReference

      public fun asCoding(): Coding? = this as? Coding

      public fun asContactPoint(): ContactPoint? = this as? ContactPoint

      public fun asCount(): Count? = this as? Count

      public fun asDistance(): Distance? = this as? Distance

      public fun asDuration(): Duration? = this as? Duration

      public fun asHumanName(): HumanName? = this as? HumanName

      public fun asIdentifier(): Identifier? = this as? Identifier

      public fun asMoney(): Money? = this as? Money

      public fun asPeriod(): Period? = this as? Period

      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asRange(): Range? = this as? Range

      public fun asRatio(): Ratio? = this as? Ratio

      public fun asRatioRange(): RatioRange? = this as? RatioRange

      public fun asReference(): Reference? = this as? Reference

      public fun asSampledData(): SampledData? = this as? SampledData

      public fun asSignature(): Signature? = this as? Signature

      public fun asTiming(): Timing? = this as? Timing

      public fun asContactDetail(): ContactDetail? = this as? ContactDetail

      public fun asDataRequirement(): DataRequirement? = this as? DataRequirement

      public fun asExpression(): Expression? = this as? Expression

      public fun asParameterDefinition(): ParameterDefinition? = this as? ParameterDefinition

      public fun asRelatedArtifact(): RelatedArtifact? = this as? RelatedArtifact

      public fun asTriggerDefinition(): TriggerDefinition? = this as? TriggerDefinition

      public fun asUsageContext(): UsageContext? = this as? UsageContext

      public fun asAvailability(): Availability? = this as? Availability

      public fun asExtendedContactDetail(): ExtendedContactDetail? = this as? ExtendedContactDetail

      public fun asDosage(): Dosage? = this as? Dosage

      public fun asMeta(): Meta? = this as? Meta

      public data class Base64Binary(override val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
        Value

      public data class Boolean(override val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

      public data class Canonical(override val `value`: dev.ohs.fhir.model.r5.Canonical) : Value

      public data class Code(override val `value`: dev.ohs.fhir.model.r5.Code) : Value

      public data class Date(override val `value`: dev.ohs.fhir.model.r5.Date) : Value

      public data class DateTime(override val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

      public data class Decimal(override val `value`: dev.ohs.fhir.model.r5.Decimal) : Value

      public data class Id(override val `value`: dev.ohs.fhir.model.r5.Id) : Value

      public data class Instant(override val `value`: dev.ohs.fhir.model.r5.Instant) : Value

      public data class Integer(override val `value`: dev.ohs.fhir.model.r5.Integer) : Value

      public data class Integer64(override val `value`: dev.ohs.fhir.model.r5.Integer64) : Value

      public data class Markdown(override val `value`: dev.ohs.fhir.model.r5.Markdown) : Value

      public data class Oid(override val `value`: dev.ohs.fhir.model.r5.Oid) : Value

      public data class PositiveInt(override val `value`: dev.ohs.fhir.model.r5.PositiveInt) : Value

      public data class String(override val `value`: dev.ohs.fhir.model.r5.String) : Value

      public data class Time(override val `value`: dev.ohs.fhir.model.r5.Time) : Value

      public data class UnsignedInt(override val `value`: dev.ohs.fhir.model.r5.UnsignedInt) : Value

      public data class Uri(override val `value`: dev.ohs.fhir.model.r5.Uri) : Value

      public data class Url(override val `value`: dev.ohs.fhir.model.r5.Url) : Value

      public data class Uuid(override val `value`: dev.ohs.fhir.model.r5.Uuid) : Value

      public data class Address(override val `value`: dev.ohs.fhir.model.r5.Address) : Value

      public data class Age(override val `value`: dev.ohs.fhir.model.r5.Age) : Value

      public data class Annotation(override val `value`: dev.ohs.fhir.model.r5.Annotation) : Value

      public data class Attachment(override val `value`: dev.ohs.fhir.model.r5.Attachment) : Value

      public data class CodeableConcept(
        override val `value`: dev.ohs.fhir.model.r5.CodeableConcept
      ) : Value

      public data class CodeableReference(
        override val `value`: dev.ohs.fhir.model.r5.CodeableReference
      ) : Value

      public data class Coding(override val `value`: dev.ohs.fhir.model.r5.Coding) : Value

      public data class ContactPoint(override val `value`: dev.ohs.fhir.model.r5.ContactPoint) :
        Value

      public data class Count(override val `value`: dev.ohs.fhir.model.r5.Count) : Value

      public data class Distance(override val `value`: dev.ohs.fhir.model.r5.Distance) : Value

      public data class Duration(override val `value`: dev.ohs.fhir.model.r5.Duration) : Value

      public data class HumanName(override val `value`: dev.ohs.fhir.model.r5.HumanName) : Value

      public data class Identifier(override val `value`: dev.ohs.fhir.model.r5.Identifier) : Value

      public data class Money(override val `value`: dev.ohs.fhir.model.r5.Money) : Value

      public data class Period(override val `value`: dev.ohs.fhir.model.r5.Period) : Value

      public data class Quantity(override val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

      public data class Range(override val `value`: dev.ohs.fhir.model.r5.Range) : Value

      public data class Ratio(override val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

      public data class RatioRange(override val `value`: dev.ohs.fhir.model.r5.RatioRange) : Value

      public data class Reference(override val `value`: dev.ohs.fhir.model.r5.Reference) : Value

      public data class SampledData(override val `value`: dev.ohs.fhir.model.r5.SampledData) : Value

      public data class Signature(override val `value`: dev.ohs.fhir.model.r5.Signature) : Value

      public data class Timing(override val `value`: dev.ohs.fhir.model.r5.Timing) : Value

      public data class ContactDetail(override val `value`: dev.ohs.fhir.model.r5.ContactDetail) :
        Value

      public data class DataRequirement(
        override val `value`: dev.ohs.fhir.model.r5.DataRequirement
      ) : Value

      public data class Expression(override val `value`: dev.ohs.fhir.model.r5.Expression) : Value

      public data class ParameterDefinition(
        override val `value`: dev.ohs.fhir.model.r5.ParameterDefinition
      ) : Value

      public data class RelatedArtifact(
        override val `value`: dev.ohs.fhir.model.r5.RelatedArtifact
      ) : Value

      public data class TriggerDefinition(
        override val `value`: dev.ohs.fhir.model.r5.TriggerDefinition
      ) : Value

      public data class UsageContext(override val `value`: dev.ohs.fhir.model.r5.UsageContext) :
        Value

      public data class Availability(override val `value`: dev.ohs.fhir.model.r5.Availability) :
        Value

      public data class ExtendedContactDetail(
        override val `value`: dev.ohs.fhir.model.r5.ExtendedContactDetail
      ) : Value

      public data class Dosage(override val `value`: dev.ohs.fhir.model.r5.Dosage) : Value

      public data class Meta(override val `value`: dev.ohs.fhir.model.r5.Meta) : Value

      public companion object {
        internal fun from(
          base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          booleanValue: dev.ohs.fhir.model.r5.Boolean?,
          canonicalValue: dev.ohs.fhir.model.r5.Canonical?,
          codeValue: dev.ohs.fhir.model.r5.Code?,
          dateValue: dev.ohs.fhir.model.r5.Date?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          decimalValue: dev.ohs.fhir.model.r5.Decimal?,
          idValue: dev.ohs.fhir.model.r5.Id?,
          instantValue: dev.ohs.fhir.model.r5.Instant?,
          integerValue: dev.ohs.fhir.model.r5.Integer?,
          integer64Value: dev.ohs.fhir.model.r5.Integer64?,
          markdownValue: dev.ohs.fhir.model.r5.Markdown?,
          oidValue: dev.ohs.fhir.model.r5.Oid?,
          positiveIntValue: dev.ohs.fhir.model.r5.PositiveInt?,
          stringValue: dev.ohs.fhir.model.r5.String?,
          timeValue: dev.ohs.fhir.model.r5.Time?,
          unsignedIntValue: dev.ohs.fhir.model.r5.UnsignedInt?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
          urlValue: dev.ohs.fhir.model.r5.Url?,
          uuidValue: dev.ohs.fhir.model.r5.Uuid?,
          addressValue: dev.ohs.fhir.model.r5.Address?,
          ageValue: dev.ohs.fhir.model.r5.Age?,
          annotationValue: dev.ohs.fhir.model.r5.Annotation?,
          attachmentValue: dev.ohs.fhir.model.r5.Attachment?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          codeableReferenceValue: dev.ohs.fhir.model.r5.CodeableReference?,
          codingValue: dev.ohs.fhir.model.r5.Coding?,
          contactPointValue: dev.ohs.fhir.model.r5.ContactPoint?,
          countValue: dev.ohs.fhir.model.r5.Count?,
          distanceValue: dev.ohs.fhir.model.r5.Distance?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
          humanNameValue: dev.ohs.fhir.model.r5.HumanName?,
          identifierValue: dev.ohs.fhir.model.r5.Identifier?,
          moneyValue: dev.ohs.fhir.model.r5.Money?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          ratioValue: dev.ohs.fhir.model.r5.Ratio?,
          ratioRangeValue: dev.ohs.fhir.model.r5.RatioRange?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          sampledDataValue: dev.ohs.fhir.model.r5.SampledData?,
          signatureValue: dev.ohs.fhir.model.r5.Signature?,
          timingValue: dev.ohs.fhir.model.r5.Timing?,
          contactDetailValue: dev.ohs.fhir.model.r5.ContactDetail?,
          dataRequirementValue: dev.ohs.fhir.model.r5.DataRequirement?,
          expressionValue: dev.ohs.fhir.model.r5.Expression?,
          parameterDefinitionValue: dev.ohs.fhir.model.r5.ParameterDefinition?,
          relatedArtifactValue: dev.ohs.fhir.model.r5.RelatedArtifact?,
          triggerDefinitionValue: dev.ohs.fhir.model.r5.TriggerDefinition?,
          usageContextValue: dev.ohs.fhir.model.r5.UsageContext?,
          availabilityValue: dev.ohs.fhir.model.r5.Availability?,
          extendedContactDetailValue: dev.ohs.fhir.model.r5.ExtendedContactDetail?,
          dosageValue: dev.ohs.fhir.model.r5.Dosage?,
          metaValue: dev.ohs.fhir.model.r5.Meta?,
        ): Value? {
          if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
          if (booleanValue != null) return Boolean(booleanValue)
          if (canonicalValue != null) return Canonical(canonicalValue)
          if (codeValue != null) return Code(codeValue)
          if (dateValue != null) return Date(dateValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (decimalValue != null) return Decimal(decimalValue)
          if (idValue != null) return Id(idValue)
          if (instantValue != null) return Instant(instantValue)
          if (integerValue != null) return Integer(integerValue)
          if (integer64Value != null) return Integer64(integer64Value)
          if (markdownValue != null) return Markdown(markdownValue)
          if (oidValue != null) return Oid(oidValue)
          if (positiveIntValue != null) return PositiveInt(positiveIntValue)
          if (stringValue != null) return String(stringValue)
          if (timeValue != null) return Time(timeValue)
          if (unsignedIntValue != null) return UnsignedInt(unsignedIntValue)
          if (uriValue != null) return Uri(uriValue)
          if (urlValue != null) return Url(urlValue)
          if (uuidValue != null) return Uuid(uuidValue)
          if (addressValue != null) return Address(addressValue)
          if (ageValue != null) return Age(ageValue)
          if (annotationValue != null) return Annotation(annotationValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (codeableReferenceValue != null) return CodeableReference(codeableReferenceValue)
          if (codingValue != null) return Coding(codingValue)
          if (contactPointValue != null) return ContactPoint(contactPointValue)
          if (countValue != null) return Count(countValue)
          if (distanceValue != null) return Distance(distanceValue)
          if (durationValue != null) return Duration(durationValue)
          if (humanNameValue != null) return HumanName(humanNameValue)
          if (identifierValue != null) return Identifier(identifierValue)
          if (moneyValue != null) return Money(moneyValue)
          if (periodValue != null) return Period(periodValue)
          if (quantityValue != null) return Quantity(quantityValue)
          if (rangeValue != null) return Range(rangeValue)
          if (ratioValue != null) return Ratio(ratioValue)
          if (ratioRangeValue != null) return RatioRange(ratioRangeValue)
          if (referenceValue != null) return Reference(referenceValue)
          if (sampledDataValue != null) return SampledData(sampledDataValue)
          if (signatureValue != null) return Signature(signatureValue)
          if (timingValue != null) return Timing(timingValue)
          if (contactDetailValue != null) return ContactDetail(contactDetailValue)
          if (dataRequirementValue != null) return DataRequirement(dataRequirementValue)
          if (expressionValue != null) return Expression(expressionValue)
          if (parameterDefinitionValue != null) return ParameterDefinition(parameterDefinitionValue)
          if (relatedArtifactValue != null) return RelatedArtifact(relatedArtifactValue)
          if (triggerDefinitionValue != null) return TriggerDefinition(triggerDefinitionValue)
          if (usageContextValue != null) return UsageContext(usageContextValue)
          if (availabilityValue != null) return Availability(availabilityValue)
          if (extendedContactDetailValue != null)
            return ExtendedContactDetail(extendedContactDetailValue)
          if (dosageValue != null) return Dosage(dosageValue)
          if (metaValue != null) return Meta(metaValue)
          return null
        }
      }
    }

    public class Builder(
      /** The name of the Output parameter. */
      public var type: CodeableConcept.Builder,
      /** The value of the Output parameter as a basic type. */
      public var `value`: Value,
    ) : FhirBuilder {
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

      override fun build(): Output =
        Output(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.build(),
          `value` = `value`,
        )
    }
  }

  public class Builder(
    /** The current status of the task. */
    public var status: Enumeration<TaskStatus>,
    /**
     * Indicates the "level" of actionability associated with the Task, i.e. i+R[9]Cs this a
     * proposed task, a planned task, an actionable task, etc.
     *
     * This element is immutable. Proposed tasks, planned tasks, etc. must be distinct instances.
     *
     * In most cases, Tasks will have an intent of "order".
     */
    public var intent: Enumeration<TaskIntent>,
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

    /** The business identifier for this task. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a *FHIR*-defined protocol, guideline, orderset or other definition that
     * is adhered to in whole or in part by this Task.
     */
    public var instantiatesCanonical: Canonical.Builder? = null

    /**
     * The URL pointing to an *externally* maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this Task.
     */
    public var instantiatesUri: Uri.Builder? = null

    /**
     * BasedOn refers to a higher-level authorization that triggered the creation of the task. It
     * references a "request" resource such as a ServiceRequest, MedicationRequest, CarePlan, etc.
     * which is distinct from the "request" resource the task is seeking to fulfill. This latter
     * resource is referenced by focus. For example, based on a CarePlan (= basedOn), a task is
     * created to fulfill a ServiceRequest ( = focus ) to collect a specimen from a patient.
     *
     * Task.basedOn is never the same as Task.focus. Task.basedOn will typically not be present for
     * 'please fulfill' Tasks as a distinct authorization is rarely needed to request fulfillment.
     * If the Task is seeking fulfillment of an order, the order to be fulfilled is always
     * communicated using `focus`, never basedOn. However, authorization may be needed to perform
     * other types of Task actions. As an example of when both would be present, a Task seeking
     * suspension of a prescription might have a Task.basedOn pointing to the ServiceRequest
     * ordering surgery (which is the driver for suspending the MedicationRequest - which would be
     * the Task.focus).
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to multiple independent Task and Request instances that were
     * activated/authorized more or less simultaneously by a single author. The presence of the same
     * identifier on each request ties those requests together and may have business ramifications
     * in terms of reporting of results, billing, etc. E.g. a requisition number shared by a set of
     * lab tests ordered together, or a prescription number shared by all meds ordered at one time.
     */
    public var groupIdentifier: Identifier.Builder? = null

    /**
     * Task that this particular task is part of.
     *
     * This should usually be 0..1.
     */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /**
     * An explanation as to why this task is held, failed, was refused, etc.
     *
     * This applies to the current status. Look at the history of the task to see reasons for past
     * statuses.
     */
    public var statusReason: CodeableReference.Builder? = null

    /** Contains business-specific nuances of the business state. */
    public var businessStatus: CodeableConcept.Builder? = null

    /** Indicates how quickly the Task should be addressed with respect to other requests. */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * If true indicates that the Task is asking for the specified action to *not* occur.
     *
     * The attributes provided with the Task qualify what is not to be done. For example, if a
     * requestedPeriod is provided, the 'do not' request only applies within the specified time. If
     * a requestedPerformer is specified then the 'do not' request only applies to performers of
     * that type. Qualifiers include: code, subject, occurrence, requestedPerformer and performer.
     *
     * In some cases, the Request.code may pre-coordinate prohibition into the requested action.
     * E.g. 'NPO' (nothing by mouth), 'DNR' (do not recussitate). If this happens, doNotPerform
     * SHALL NOT be set to true. I.e. The resource shall not have double negation. (E.g. 'Do not
     * DNR').
     *
     * doNotPerform should ONLY be used with Tasks that are tightly bounded in time or process
     * phase. E.g. 'Do not fulfill the midnight dose of medication X tonight due to the early
     * morning scheduled procedure, where the nurse could reasonably check off 'Med X not given at
     * midnight as instructed'. Similarly, a decision support proposal that a patient should not be
     * given a standard intake questionnaire (because the patient is cognitively impaired) would be
     * marked as 'complete' or 'rejected' when the clinician preps the CarePlan or order set after
     * reviewing the decision support results. If there is a need to create a standing order to not
     * do something that can't be satisfied by a single 'non-action', but rather an ongoing refusal
     * to perform the function, MedicationRequest, ServiceRequest or some other form of
     * authorization should be used.
     */
    public var doNotPerform: Boolean.Builder? = null

    /**
     * A name or code (or both) briefly describing what the task involves.
     *
     * The title (eg "My Tasks", "Outstanding Tasks for Patient X") should go into the code.
     */
    public var code: CodeableConcept.Builder? = null

    /** A free-text description of what is to be performed. */
    public var description: String.Builder? = null

    /**
     * The request being fulfilled or the resource being manipulated (changed, suspended, etc.) by
     * this task.
     *
     * If multiple resources need to be manipulated, use sub-tasks. (This ensures that status can be
     * tracked independently for each referenced resource.).
     */
    public var focus: Reference.Builder? = null

    /**
     * The entity who benefits from the performance of the service specified in the task (e.g., the
     * patient).
     */
    public var `for`: Reference.Builder? = null

    /**
     * The healthcare event (e.g. a patient and healthcare provider interaction) during which this
     * task was created.
     */
    public var encounter: Reference.Builder? = null

    /**
     * Indicates the start and/or end of the period of time when completion of the task is desired
     * to take place.
     *
     * This is typically used when the Task is *not* seeking fulfillment of a focus Request, as in
     * that case the period would be specified on the Request and/or in the Task.restriction.period.
     * Instead, it is used for stand-alone tasks.
     */
    public var requestedPeriod: Period.Builder? = null

    /**
     * Identifies the time action was first taken against the task (start) and/or the time final
     * action was taken against the task prior to marking it as completed (end).
     */
    public var executionPeriod: Period.Builder? = null

    /** The date and time this task was created. */
    public var authoredOn: DateTime.Builder? = null

    /** The date and time of last modification to this task. */
    public var lastModified: DateTime.Builder? = null

    /** The creator of the task. */
    public var requester: Reference.Builder? = null

    /** The kind of participant or specific participant that should perform the task. */
    public var requestedPerformer: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Party responsible for managing task execution.
     *
     * Tasks may be created with an owner not yet identified.
     */
    public var owner: Reference.Builder? = null

    /** The entity who performed the requested task. */
    public var performer: MutableList<Performer.Builder> = mutableListOf()

    /**
     * Principal physical location where this task is performed.
     *
     * This should only be specified when the Task to be/being performed happens or is expected to
     * happen primarily within the bounds of a single Location. Other locations (e.g. source,
     * destination, etc.) would either be reflected on the 'basedOn' Request or be conveyed as
     * distinct Task.input values.
     */
    public var location: Reference.Builder? = null

    /**
     * A description, code, or reference indicating why this task needs to be performed.
     *
     * This will typically not be present for Tasks with a code of 'please fulfill' as, for those,
     * the reason for action is conveyed on the Request pointed to by Task.focus. Some types of
     * tasks will not need a 'reason'. E.g. a request to discharge a patient can be inferred to be
     * 'because the patient is ready' and this would not need a reason to be stated on the Task.
     */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may
     * be relevant to the Task.
     */
    public var insurance: MutableList<Reference.Builder> = mutableListOf()

    /** Free-text information captured about the task as it progresses. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * Links to Provenance records for past versions of this Task that identify key state
     * transitions or updates that are likely to be relevant to a user looking at the current
     * version of the task.
     *
     * This element does not point to the Provenance associated with the *current* version of the
     * resource - as it would be created after this version existed. The Provenance for the current
     * version can be retrieved with a _revinclude.
     */
    public var relevantHistory: MutableList<Reference.Builder> = mutableListOf()

    /**
     * If the Task.focus is a request resource and the task is seeking fulfillment (i.e. is asking
     * for the request to be actioned), this element identifies any limitations on what parts of the
     * referenced request should be actioned.
     *
     * Task.restriction can only be present if the Task is seeking fulfillment of another Request
     * resource, and the restriction identifies what subset of the authorization conveyed by the
     * request is supposed to be fulfilled by this Task. A possible example could be a standing
     * order (the request) covering a significant time period and/or individuals, while the Task
     * seeks fulfillment for only a subset of that time-period and a single individual.
     */
    public var restriction: Restriction.Builder? = null

    /** Additional information that may be needed in the execution of the task. */
    public var input: MutableList<Input.Builder> = mutableListOf()

    /** Outputs produced by the Task. */
    public var output: MutableList<Output.Builder> = mutableListOf()

    override fun build(): Task =
      Task(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        instantiatesCanonical = instantiatesCanonical?.build(),
        instantiatesUri = instantiatesUri?.build(),
        basedOn = basedOn.buildList(),
        groupIdentifier = groupIdentifier?.build(),
        partOf = partOf.buildList(),
        status = status,
        statusReason = statusReason?.build(),
        businessStatus = businessStatus?.build(),
        intent = intent,
        priority = priority,
        doNotPerform = doNotPerform?.build(),
        code = code?.build(),
        description = description?.build(),
        focus = focus?.build(),
        `for` = `for`?.build(),
        encounter = encounter?.build(),
        requestedPeriod = requestedPeriod?.build(),
        executionPeriod = executionPeriod?.build(),
        authoredOn = authoredOn?.build(),
        lastModified = lastModified?.build(),
        requester = requester?.build(),
        requestedPerformer = requestedPerformer.buildList(),
        owner = owner?.build(),
        performer = performer.buildList(),
        location = location?.build(),
        reason = reason.buildList(),
        insurance = insurance.buildList(),
        note = note.buildList(),
        relevantHistory = relevantHistory.buildList(),
        restriction = restriction?.build(),
        input = input.buildList(),
        output = output.buildList(),
      )
  }
}
