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

import dev.ohs.fhir.model.r5.serializers.AppointmentParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentRecurrenceTemplateMonthlyTemplateSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentRecurrenceTemplateSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentRecurrenceTemplateWeeklyTemplateSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentRecurrenceTemplateYearlyTemplateSerializer
import dev.ohs.fhir.model.r5.serializers.AppointmentSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or
 * device(s) for a specific date/time. This may result in one or more Encounter(s).
 */
@Serializable(with = AppointmentSerializer::class)
@SerialName("Appointment")
public data class Appointment(
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
   * This records identifiers associated with this appointment concern that are defined by business
   * processes and/or used to refer to it when a direct URL reference to the resource itself is not
   * appropriate (e.g. in CDA documents, or in written / printed documentation).
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The overall status of the Appointment. Each of the participants has their own participation
   * status which indicates their involvement in the process, however this status indicates the
   * shared status.
   *
   * If the Appointment's status is "cancelled" then all participants are expected to have their
   * calendars released for the appointment period, and as such any Slots that were marked as BUSY
   * can be re-set to FREE.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that mark the Appointment as not currently valid.
   */
  public val status: Enumeration<AppointmentStatus>,
  /**
   * The coded reason for the appointment being cancelled. This is often used in
   * reporting/billing/futher processing to determine if further actions are required, or specific
   * fees apply.
   */
  public val cancellationReason: CodeableConcept? = null,
  /**
   * Concepts representing classification of patient encounter such as ambulatory (outpatient),
   * inpatient, emergency, home health or others due to local variations.
   */
  public val `class`: List<CodeableConcept> = listOf(),
  /** A broad categorization of the service that is to be performed during this appointment. */
  public val serviceCategory: List<CodeableConcept> = listOf(),
  /**
   * The specific service that is to be performed during this appointment.
   *
   * For a provider to provider appointment the code "FOLLOWUP" may be appropriate, as this is
   * expected to be discussing some patient that was seen in the past.
   */
  public val serviceType: List<CodeableReference> = listOf(),
  /**
   * The specialty of a practitioner that would be required to perform the service requested in this
   * appointment.
   */
  public val specialty: List<CodeableConcept> = listOf(),
  /** The style of appointment or patient that has been booked in the slot (not service type). */
  public val appointmentType: CodeableConcept? = null,
  /**
   * The reason that this appointment is being scheduled. This is more clinical than administrative.
   * This can be coded, or as specified using information from another resource. When the patient
   * arrives and the encounter begins it may be used as the admission diagnosis. The indication will
   * typically be a Condition (with other resources referenced in the evidence.detail), or a
   * Procedure.
   */
  public val reason: List<CodeableReference> = listOf(),
  /**
   * The priority of the appointment. Can be used to make informed decisions if needing to
   * re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as
   * lowest priority).
   *
   * Seeking implementer feedback on this property and how interoperable it is.
   *
   * Using an extension to record a CodeableConcept for named values may be tested at a future
   * connectathon.
   */
  public val priority: CodeableConcept? = null,
  /**
   * The brief description of the appointment as would be shown on a subject line in a meeting
   * request, or appointment list. Detailed or expanded information should be put in the note field.
   */
  public val description: String? = null,
  /**
   * Appointment replaced by this Appointment in cases where there is a cancellation, the details of
   * the cancellation can be found in the cancellationReason property (on the referenced resource).
   */
  public val replaces: List<Reference> = listOf(),
  /**
   * Connection details of a virtual service (e.g. conference call).
   *
   * There are two types of virtual meetings that often exist:
   *
   * a persistent, virtual meeting room that can only be used for a single purpose at a time, and a
   * dynamic virtual meeting room that is generated on demand for a specific purpose.
   *
   * Implementers may consider using Location.virtualService for persistent meeting rooms.
   *
   * If each participant would have a different meeting link, an extension using the
   * VirtualServiceContactDetail can be applied to the Appointment.participant BackboneElement.
   */
  public val virtualService: List<VirtualServiceDetail> = listOf(),
  /** Additional information to support the appointment provided when making the appointment. */
  public val supportingInformation: List<Reference> = listOf(),
  /**
   * The previous appointment in a series of related appointments.
   *
   * This property is intended for use when representing a series of related appointments. For
   * example, in a nuclear medicine procedure, where there is an appointment for the injection of
   * the isotopes, and then a subsequent appointment for the scan, the scan appointment would refer
   * to the injection appointment via Appointment.previousAppointment. For representing recurring
   * appointments, see the guidance on recurring vs. series appointments.
   */
  public val previousAppointment: Reference? = null,
  /**
   * The originating appointment in a recurring set of related appointments.
   *
   * This property is intended for use when representing a recurring set of related appointments.
   *
   * For example, a patient undergoing physical therapy may have a recurring appointment every
   * Tuesday and Thursday. Each occurrence of the set will refer to the originating appointment,
   * which contains the recurring template information. For representing appointment series, see the
   * guidance on recurring vs. series appointments.
   */
  public val originatingAppointment: Reference? = null,
  /**
   * Date/Time that the appointment is to take place.
   *
   * If actual start/end times are not known then the requested period start/end can be used.
   */
  public val start: Instant? = null,
  /**
   * Date/Time that the appointment is to conclude.
   *
   * If actual start/end times are not known then the requested period start/end can be used.
   */
  public val end: Instant? = null,
  /**
   * Number of minutes that the appointment is to take. This can be less than the duration between
   * the start and end times. For example, where the actual time of appointment is only an estimate
   * or if a 30 minute appointment is being requested, but any time would work. Also, if there is,
   * for example, a planned 15 minute break in the middle of a long appointment, the duration may be
   * 15 minutes less than the difference between the start and end.
   */
  public val minutesDuration: PositiveInt? = null,
  /**
   * A set of date ranges (potentially including times) that the appointment is preferred to be
   * scheduled within.
   *
   * The duration (usually in minutes) could also be provided to indicate the length of the
   * appointment to fill and populate the start/end times for the actual allocated time. However, in
   * other situations the duration may be calculated by the scheduling system.
   *
   * This does not introduce a capacity for recurring appointments.
   */
  public val requestedPeriod: List<Period> = listOf(),
  /** The slots from the participants' schedules that will be filled by the appointment. */
  public val slot: List<Reference> = listOf(),
  /**
   * The set of accounts that is expected to be used for billing the activities that result from
   * this Appointment.
   *
   * The specified account(s) could be those identified during pre-registration workflows in
   * preparation for an upcoming Encounter.
   */
  public val account: List<Reference> = listOf(),
  /**
   * The date that this appointment was initially created. This could be different to the
   * meta.lastModified value on the initial entry, as this could have been before the resource was
   * created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
   *
   * This property is required for many use cases where the age of an appointment is considered in
   * processing workflows for scheduling and billing of appointments.
   */
  public val created: DateTime? = null,
  /**
   * The date/time describing when the appointment was cancelled.
   *
   * If the appointment was cancelled multiple times, this would reflect the most recent
   * cancellation.
   */
  public val cancellationDate: DateTime? = null,
  /**
   * Additional notes/comments about the appointment.
   *
   * Additional text to aid in facilitating the appointment. For instance, a note might be, "patient
   * should proceed immediately to infusion room upon arrival"
   *
   * Where this is a planned appointment and the start/end dates are not set then this field can be
   * used to provide additional guidance on the details of the appointment request, including any
   * restrictions on when to book it.
   *
   * Typically only the concept.text will be used, however occasionally a reference to some generic
   * documentation (or specific) and also supports coded instructions if/when they are required.
   */
  public val note: List<Annotation> = listOf(),
  /**
   * While Appointment.note contains information for internal use, Appointment.patientInstructions
   * is used to capture patient facing information about the Appointment (e.g. please bring your
   * referral or fast from 8pm night before).
   */
  public val patientInstruction: List<CodeableReference> = listOf(),
  /**
   * The request this appointment is allocated to assess (e.g. incoming referral or procedure
   * request).
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * The patient or group associated with the appointment, if they are to be present (usually) then
   * they should also be included in the participant backbone element.
   */
  public val subject: Reference? = null,
  /** List of participants involved in the appointment. */
  public val participant: List<Participant>,
  /** The sequence number that identifies a specific appointment in a recurring pattern. */
  public val recurrenceId: PositiveInt? = null,
  /**
   * This appointment varies from the recurring pattern.
   *
   * For example, if a patient has physical therapy appointments every Tuesday and Thursday, but due
   * to a national holiday, a single occurrence was rescheduled to a different day, while the rest
   * of the recurring series remained on Tuesday / Thursday.
   */
  public val occurrenceChanged: Boolean? = null,
  /**
   * The details of the recurrence pattern or template that is used to generate recurring
   * appointments.
   */
  public val recurrenceTemplate: List<RecurrenceTemplate> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, participant.map { it.toBuilder() }.toMutableList()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        cancellationReason = this@with.cancellationReason?.toBuilder()
        `class` = this@with.`class`.map { it.toBuilder() }.toMutableList()
        serviceCategory = this@with.serviceCategory.map { it.toBuilder() }.toMutableList()
        serviceType = this@with.serviceType.map { it.toBuilder() }.toMutableList()
        specialty = this@with.specialty.map { it.toBuilder() }.toMutableList()
        appointmentType = this@with.appointmentType?.toBuilder()
        reason = this@with.reason.map { it.toBuilder() }.toMutableList()
        priority = this@with.priority?.toBuilder()
        description = this@with.description?.toBuilder()
        replaces = this@with.replaces.map { it.toBuilder() }.toMutableList()
        virtualService = this@with.virtualService.map { it.toBuilder() }.toMutableList()
        supportingInformation =
          this@with.supportingInformation.map { it.toBuilder() }.toMutableList()
        previousAppointment = this@with.previousAppointment?.toBuilder()
        originatingAppointment = this@with.originatingAppointment?.toBuilder()
        start = this@with.start?.toBuilder()
        end = this@with.end?.toBuilder()
        minutesDuration = this@with.minutesDuration?.toBuilder()
        requestedPeriod = this@with.requestedPeriod.map { it.toBuilder() }.toMutableList()
        slot = this@with.slot.map { it.toBuilder() }.toMutableList()
        account = this@with.account.map { it.toBuilder() }.toMutableList()
        created = this@with.created?.toBuilder()
        cancellationDate = this@with.cancellationDate?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
        patientInstruction = this@with.patientInstruction.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        recurrenceId = this@with.recurrenceId?.toBuilder()
        occurrenceChanged = this@with.occurrenceChanged?.toBuilder()
        recurrenceTemplate = this@with.recurrenceTemplate.map { it.toBuilder() }.toMutableList()
      }
    }

  /** List of participants involved in the appointment. */
  @Serializable(with = AppointmentParticipantSerializer::class)
  public data class Participant(
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
     * Role of participant in the appointment.
     *
     * The role of the participant can be used to declare what the actor will be doing in the scope
     * of this appointment.
     *
     * If the actor is not specified, then it is expected that the actor will be filled in at a
     * later stage of planning.
     *
     * This value SHALL be the same when creating an AppointmentResponse so that they can be
     * matched, and subsequently update the Appointment.
     */
    public val type: List<CodeableConcept> = listOf(),
    /** Participation period of the actor. */
    public val period: Period? = null,
    /**
     * The individual, device, location, or service participating in the appointment.
     *
     * Where a CareTeam is provided, this does not imply that the entire team is included, just a
     * single member from the group with the appropriate role. Where multiple members are required,
     * please include the CareTeam the required number of times.
     */
    public val actor: Reference? = null,
    /**
     * Whether this participant is required to be present at the meeting. If false, the participant
     * is optional.
     *
     * For the use-case where two doctors need to meet to discuss the results for a specific
     * patient, and the patient is not required to be present include the patient in the subject
     * field, but do not include them as a participant - this was formerly done prior to R5 with
     * required='information-only'.
     */
    public val required: Boolean? = null,
    /** Participation status of the actor. */
    public val status: Enumeration<ParticipationStatus>,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(status).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          actor = this@with.actor?.toBuilder()
          required = this@with.required?.toBuilder()
        }
      }

    public class Builder(
      /** Participation status of the actor. */
      public var status: Enumeration<ParticipationStatus>
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
       * Role of participant in the appointment.
       *
       * The role of the participant can be used to declare what the actor will be doing in the
       * scope of this appointment.
       *
       * If the actor is not specified, then it is expected that the actor will be filled in at a
       * later stage of planning.
       *
       * This value SHALL be the same when creating an AppointmentResponse so that they can be
       * matched, and subsequently update the Appointment.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Participation period of the actor. */
      public var period: Period.Builder? = null

      /**
       * The individual, device, location, or service participating in the appointment.
       *
       * Where a CareTeam is provided, this does not imply that the entire team is included, just a
       * single member from the group with the appropriate role. Where multiple members are
       * required, please include the CareTeam the required number of times.
       */
      public var actor: Reference.Builder? = null

      /**
       * Whether this participant is required to be present at the meeting. If false, the
       * participant is optional.
       *
       * For the use-case where two doctors need to meet to discuss the results for a specific
       * patient, and the patient is not required to be present include the patient in the subject
       * field, but do not include them as a participant - this was formerly done prior to R5 with
       * required='information-only'.
       */
      public var required: Boolean.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.map { it.build() },
          period = period?.build(),
          actor = actor?.build(),
          required = required?.build(),
          status = status,
        )
    }
  }

  /**
   * The details of the recurrence pattern or template that is used to generate recurring
   * appointments.
   */
  @Serializable(with = AppointmentRecurrenceTemplateSerializer::class)
  public data class RecurrenceTemplate(
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
    /** The timezone of the recurring appointment occurrences. */
    public val timezone: CodeableConcept? = null,
    /** How often the appointment series should recur. */
    public val recurrenceType: CodeableConcept,
    /** Recurring appointments will not occur after this date. */
    public val lastOccurrenceDate: Date? = null,
    /** How many appointments are planned in the recurrence. */
    public val occurrenceCount: PositiveInt? = null,
    /** The list of specific dates that will have appointments generated. */
    public val occurrenceDate: List<Date> = listOf(),
    /** Information about weekly recurring appointments. */
    public val weeklyTemplate: WeeklyTemplate? = null,
    /** Information about monthly recurring appointments. */
    public val monthlyTemplate: MonthlyTemplate? = null,
    /** Information about yearly recurring appointments. */
    public val yearlyTemplate: YearlyTemplate? = null,
    /**
     * Any dates, such as holidays, that should be excluded from the recurrence.
     *
     * excludingDate is an alternative to excludingRecurrenceId. You may say either that 12/25/XXXX
     * should be excluded using excludingDate, or you may indicate the recurrenceId of the
     * appointment that would fall on the excluded date in the excludingRecurrenceId property.
     */
    public val excludingDate: List<Date> = listOf(),
    /**
     * Any dates, such as holidays, that should be excluded from the recurrence.
     *
     * excludingRecurrenceId is an alternative to excludingDate. You may say either that 12/25/XXXX
     * should be excluded using excludingDate, or you may indicate the recurrenceId of the
     * appointment that would fall on the excluded date in the excludingRecurrenceId property.
     */
    public val excludingRecurrenceId: List<PositiveInt> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(recurrenceType.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          timezone = this@with.timezone?.toBuilder()
          lastOccurrenceDate = this@with.lastOccurrenceDate?.toBuilder()
          occurrenceCount = this@with.occurrenceCount?.toBuilder()
          occurrenceDate = this@with.occurrenceDate.map { it.toBuilder() }.toMutableList()
          weeklyTemplate = this@with.weeklyTemplate?.toBuilder()
          monthlyTemplate = this@with.monthlyTemplate?.toBuilder()
          yearlyTemplate = this@with.yearlyTemplate?.toBuilder()
          excludingDate = this@with.excludingDate.map { it.toBuilder() }.toMutableList()
          excludingRecurrenceId =
            this@with.excludingRecurrenceId.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Information about weekly recurring appointments. */
    @Serializable(with = AppointmentRecurrenceTemplateWeeklyTemplateSerializer::class)
    public data class WeeklyTemplate(
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
      /** Indicates that recurring appointments should occur on Mondays. */
      public val monday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Tuesdays. */
      public val tuesday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Wednesdays. */
      public val wednesday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Thursdays. */
      public val thursday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Fridays. */
      public val friday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Saturdays. */
      public val saturday: Boolean? = null,
      /** Indicates that recurring appointments should occur on Sundays. */
      public val sunday: Boolean? = null,
      /**
       * The interval defines if the recurrence is every nth week. The default is every week, so it
       * is expected that this value will be 2 or more.
       *
       * e.g. For recurring every second week this interval would be 2, or every third week the
       * interval would be 3.
       */
      public val weekInterval: PositiveInt? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            monday = this@with.monday?.toBuilder()
            tuesday = this@with.tuesday?.toBuilder()
            wednesday = this@with.wednesday?.toBuilder()
            thursday = this@with.thursday?.toBuilder()
            friday = this@with.friday?.toBuilder()
            saturday = this@with.saturday?.toBuilder()
            sunday = this@with.sunday?.toBuilder()
            weekInterval = this@with.weekInterval?.toBuilder()
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

        /** Indicates that recurring appointments should occur on Mondays. */
        public var monday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Tuesdays. */
        public var tuesday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Wednesdays. */
        public var wednesday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Thursdays. */
        public var thursday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Fridays. */
        public var friday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Saturdays. */
        public var saturday: Boolean.Builder? = null

        /** Indicates that recurring appointments should occur on Sundays. */
        public var sunday: Boolean.Builder? = null

        /**
         * The interval defines if the recurrence is every nth week. The default is every week, so
         * it is expected that this value will be 2 or more.
         *
         * e.g. For recurring every second week this interval would be 2, or every third week the
         * interval would be 3.
         */
        public var weekInterval: PositiveInt.Builder? = null

        public fun build(): WeeklyTemplate =
          WeeklyTemplate(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            monday = monday?.build(),
            tuesday = tuesday?.build(),
            wednesday = wednesday?.build(),
            thursday = thursday?.build(),
            friday = friday?.build(),
            saturday = saturday?.build(),
            sunday = sunday?.build(),
            weekInterval = weekInterval?.build(),
          )
      }
    }

    /** Information about monthly recurring appointments. */
    @Serializable(with = AppointmentRecurrenceTemplateMonthlyTemplateSerializer::class)
    public data class MonthlyTemplate(
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
       * Indicates that appointments in the series of recurring appointments should occur on a
       * specific day of the month.
       */
      public val dayOfMonth: PositiveInt? = null,
      /**
       * Indicates which week within a month the appointments in the series of recurring
       * appointments should occur on.
       */
      public val nthWeekOfMonth: Coding? = null,
      /**
       * Indicates which day of the week the recurring appointments should occur each nth week.
       *
       * This property is intended to be used with Appointment.recurrenceTemplate.monthly.nthWeek.
       */
      public val dayOfWeek: Coding? = null,
      /** Indicates that recurring appointments should occur every nth month. */
      public val monthInterval: PositiveInt,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(monthInterval.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            dayOfMonth = this@with.dayOfMonth?.toBuilder()
            nthWeekOfMonth = this@with.nthWeekOfMonth?.toBuilder()
            dayOfWeek = this@with.dayOfWeek?.toBuilder()
          }
        }

      public class Builder(
        /** Indicates that recurring appointments should occur every nth month. */
        public var monthInterval: PositiveInt.Builder
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
         * Indicates that appointments in the series of recurring appointments should occur on a
         * specific day of the month.
         */
        public var dayOfMonth: PositiveInt.Builder? = null

        /**
         * Indicates which week within a month the appointments in the series of recurring
         * appointments should occur on.
         */
        public var nthWeekOfMonth: Coding.Builder? = null

        /**
         * Indicates which day of the week the recurring appointments should occur each nth week.
         *
         * This property is intended to be used with Appointment.recurrenceTemplate.monthly.nthWeek.
         */
        public var dayOfWeek: Coding.Builder? = null

        public fun build(): MonthlyTemplate =
          MonthlyTemplate(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            dayOfMonth = dayOfMonth?.build(),
            nthWeekOfMonth = nthWeekOfMonth?.build(),
            dayOfWeek = dayOfWeek?.build(),
            monthInterval = monthInterval.build(),
          )
      }
    }

    /** Information about yearly recurring appointments. */
    @Serializable(with = AppointmentRecurrenceTemplateYearlyTemplateSerializer::class)
    public data class YearlyTemplate(
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
      /** Appointment recurs every nth year. */
      public val yearInterval: PositiveInt,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(yearInterval.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /** Appointment recurs every nth year. */
        public var yearInterval: PositiveInt.Builder
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

        public fun build(): YearlyTemplate =
          YearlyTemplate(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            yearInterval = yearInterval.build(),
          )
      }
    }

    public class Builder(
      /** How often the appointment series should recur. */
      public var recurrenceType: CodeableConcept.Builder
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

      /** The timezone of the recurring appointment occurrences. */
      public var timezone: CodeableConcept.Builder? = null

      /** Recurring appointments will not occur after this date. */
      public var lastOccurrenceDate: Date.Builder? = null

      /** How many appointments are planned in the recurrence. */
      public var occurrenceCount: PositiveInt.Builder? = null

      /** The list of specific dates that will have appointments generated. */
      public var occurrenceDate: MutableList<Date.Builder> = mutableListOf()

      /** Information about weekly recurring appointments. */
      public var weeklyTemplate: WeeklyTemplate.Builder? = null

      /** Information about monthly recurring appointments. */
      public var monthlyTemplate: MonthlyTemplate.Builder? = null

      /** Information about yearly recurring appointments. */
      public var yearlyTemplate: YearlyTemplate.Builder? = null

      /**
       * Any dates, such as holidays, that should be excluded from the recurrence.
       *
       * excludingDate is an alternative to excludingRecurrenceId. You may say either that
       * 12/25/XXXX should be excluded using excludingDate, or you may indicate the recurrenceId of
       * the appointment that would fall on the excluded date in the excludingRecurrenceId property.
       */
      public var excludingDate: MutableList<Date.Builder> = mutableListOf()

      /**
       * Any dates, such as holidays, that should be excluded from the recurrence.
       *
       * excludingRecurrenceId is an alternative to excludingDate. You may say either that
       * 12/25/XXXX should be excluded using excludingDate, or you may indicate the recurrenceId of
       * the appointment that would fall on the excluded date in the excludingRecurrenceId property.
       */
      public var excludingRecurrenceId: MutableList<PositiveInt.Builder> = mutableListOf()

      public fun build(): RecurrenceTemplate =
        RecurrenceTemplate(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          timezone = timezone?.build(),
          recurrenceType = recurrenceType.build(),
          lastOccurrenceDate = lastOccurrenceDate?.build(),
          occurrenceCount = occurrenceCount?.build(),
          occurrenceDate = occurrenceDate.map { it.build() },
          weeklyTemplate = weeklyTemplate?.build(),
          monthlyTemplate = monthlyTemplate?.build(),
          yearlyTemplate = yearlyTemplate?.build(),
          excludingDate = excludingDate.map { it.build() },
          excludingRecurrenceId = excludingRecurrenceId.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The overall status of the Appointment. Each of the participants has their own participation
     * status which indicates their involvement in the process, however this status indicates the
     * shared status.
     *
     * If the Appointment's status is "cancelled" then all participants are expected to have their
     * calendars released for the appointment period, and as such any Slots that were marked as BUSY
     * can be re-set to FREE.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that mark the Appointment as not currently valid.
     */
    public var status: Enumeration<AppointmentStatus>,
    /** List of participants involved in the appointment. */
    public var participant: MutableList<Participant.Builder>,
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
     * This records identifiers associated with this appointment concern that are defined by
     * business processes and/or used to refer to it when a direct URL reference to the resource
     * itself is not appropriate (e.g. in CDA documents, or in written / printed documentation).
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The coded reason for the appointment being cancelled. This is often used in
     * reporting/billing/futher processing to determine if further actions are required, or specific
     * fees apply.
     */
    public var cancellationReason: CodeableConcept.Builder? = null

    /**
     * Concepts representing classification of patient encounter such as ambulatory (outpatient),
     * inpatient, emergency, home health or others due to local variations.
     */
    public var `class`: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** A broad categorization of the service that is to be performed during this appointment. */
    public var serviceCategory: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The specific service that is to be performed during this appointment.
     *
     * For a provider to provider appointment the code "FOLLOWUP" may be appropriate, as this is
     * expected to be discussing some patient that was seen in the past.
     */
    public var serviceType: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * The specialty of a practitioner that would be required to perform the service requested in
     * this appointment.
     */
    public var specialty: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The style of appointment or patient that has been booked in the slot (not service type). */
    public var appointmentType: CodeableConcept.Builder? = null

    /**
     * The reason that this appointment is being scheduled. This is more clinical than
     * administrative. This can be coded, or as specified using information from another resource.
     * When the patient arrives and the encounter begins it may be used as the admission diagnosis.
     * The indication will typically be a Condition (with other resources referenced in the
     * evidence.detail), or a Procedure.
     */
    public var reason: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * The priority of the appointment. Can be used to make informed decisions if needing to
     * re-prioritize appointments. (The iCal Standard specifies 0 as undefined, 1 as highest, 9 as
     * lowest priority).
     *
     * Seeking implementer feedback on this property and how interoperable it is.
     *
     * Using an extension to record a CodeableConcept for named values may be tested at a future
     * connectathon.
     */
    public var priority: CodeableConcept.Builder? = null

    /**
     * The brief description of the appointment as would be shown on a subject line in a meeting
     * request, or appointment list. Detailed or expanded information should be put in the note
     * field.
     */
    public var description: String.Builder? = null

    /**
     * Appointment replaced by this Appointment in cases where there is a cancellation, the details
     * of the cancellation can be found in the cancellationReason property (on the referenced
     * resource).
     */
    public var replaces: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Connection details of a virtual service (e.g. conference call).
     *
     * There are two types of virtual meetings that often exist:
     *
     * a persistent, virtual meeting room that can only be used for a single purpose at a time, and
     * a dynamic virtual meeting room that is generated on demand for a specific purpose.
     *
     * Implementers may consider using Location.virtualService for persistent meeting rooms.
     *
     * If each participant would have a different meeting link, an extension using the
     * VirtualServiceContactDetail can be applied to the Appointment.participant BackboneElement.
     */
    public var virtualService: MutableList<VirtualServiceDetail.Builder> = mutableListOf()

    /** Additional information to support the appointment provided when making the appointment. */
    public var supportingInformation: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The previous appointment in a series of related appointments.
     *
     * This property is intended for use when representing a series of related appointments. For
     * example, in a nuclear medicine procedure, where there is an appointment for the injection of
     * the isotopes, and then a subsequent appointment for the scan, the scan appointment would
     * refer to the injection appointment via Appointment.previousAppointment. For representing
     * recurring appointments, see the guidance on recurring vs. series appointments.
     */
    public var previousAppointment: Reference.Builder? = null

    /**
     * The originating appointment in a recurring set of related appointments.
     *
     * This property is intended for use when representing a recurring set of related appointments.
     *
     * For example, a patient undergoing physical therapy may have a recurring appointment every
     * Tuesday and Thursday. Each occurrence of the set will refer to the originating appointment,
     * which contains the recurring template information. For representing appointment series, see
     * the guidance on recurring vs. series appointments.
     */
    public var originatingAppointment: Reference.Builder? = null

    /**
     * Date/Time that the appointment is to take place.
     *
     * If actual start/end times are not known then the requested period start/end can be used.
     */
    public var start: Instant.Builder? = null

    /**
     * Date/Time that the appointment is to conclude.
     *
     * If actual start/end times are not known then the requested period start/end can be used.
     */
    public var end: Instant.Builder? = null

    /**
     * Number of minutes that the appointment is to take. This can be less than the duration between
     * the start and end times. For example, where the actual time of appointment is only an
     * estimate or if a 30 minute appointment is being requested, but any time would work. Also, if
     * there is, for example, a planned 15 minute break in the middle of a long appointment, the
     * duration may be 15 minutes less than the difference between the start and end.
     */
    public var minutesDuration: PositiveInt.Builder? = null

    /**
     * A set of date ranges (potentially including times) that the appointment is preferred to be
     * scheduled within.
     *
     * The duration (usually in minutes) could also be provided to indicate the length of the
     * appointment to fill and populate the start/end times for the actual allocated time. However,
     * in other situations the duration may be calculated by the scheduling system.
     *
     * This does not introduce a capacity for recurring appointments.
     */
    public var requestedPeriod: MutableList<Period.Builder> = mutableListOf()

    /** The slots from the participants' schedules that will be filled by the appointment. */
    public var slot: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The set of accounts that is expected to be used for billing the activities that result from
     * this Appointment.
     *
     * The specified account(s) could be those identified during pre-registration workflows in
     * preparation for an upcoming Encounter.
     */
    public var account: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The date that this appointment was initially created. This could be different to the
     * meta.lastModified value on the initial entry, as this could have been before the resource was
     * created on the FHIR server, and should remain unchanged over the lifespan of the appointment.
     *
     * This property is required for many use cases where the age of an appointment is considered in
     * processing workflows for scheduling and billing of appointments.
     */
    public var created: DateTime.Builder? = null

    /**
     * The date/time describing when the appointment was cancelled.
     *
     * If the appointment was cancelled multiple times, this would reflect the most recent
     * cancellation.
     */
    public var cancellationDate: DateTime.Builder? = null

    /**
     * Additional notes/comments about the appointment.
     *
     * Additional text to aid in facilitating the appointment. For instance, a note might be,
     * "patient should proceed immediately to infusion room upon arrival"
     *
     * Where this is a planned appointment and the start/end dates are not set then this field can
     * be used to provide additional guidance on the details of the appointment request, including
     * any restrictions on when to book it.
     *
     * Typically only the concept.text will be used, however occasionally a reference to some
     * generic documentation (or specific) and also supports coded instructions if/when they are
     * required.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    /**
     * While Appointment.note contains information for internal use, Appointment.patientInstructions
     * is used to capture patient facing information about the Appointment (e.g. please bring your
     * referral or fast from 8pm night before).
     */
    public var patientInstruction: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * The request this appointment is allocated to assess (e.g. incoming referral or procedure
     * request).
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The patient or group associated with the appointment, if they are to be present (usually)
     * then they should also be included in the participant backbone element.
     */
    public var subject: Reference.Builder? = null

    /** The sequence number that identifies a specific appointment in a recurring pattern. */
    public var recurrenceId: PositiveInt.Builder? = null

    /**
     * This appointment varies from the recurring pattern.
     *
     * For example, if a patient has physical therapy appointments every Tuesday and Thursday, but
     * due to a national holiday, a single occurrence was rescheduled to a different day, while the
     * rest of the recurring series remained on Tuesday / Thursday.
     */
    public var occurrenceChanged: Boolean.Builder? = null

    /**
     * The details of the recurrence pattern or template that is used to generate recurring
     * appointments.
     */
    public var recurrenceTemplate: MutableList<RecurrenceTemplate.Builder> = mutableListOf()

    override fun build(): Appointment =
      Appointment(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        status = status,
        cancellationReason = cancellationReason?.build(),
        `class` = `class`.map { it.build() },
        serviceCategory = serviceCategory.map { it.build() },
        serviceType = serviceType.map { it.build() },
        specialty = specialty.map { it.build() },
        appointmentType = appointmentType?.build(),
        reason = reason.map { it.build() },
        priority = priority?.build(),
        description = description?.build(),
        replaces = replaces.map { it.build() },
        virtualService = virtualService.map { it.build() },
        supportingInformation = supportingInformation.map { it.build() },
        previousAppointment = previousAppointment?.build(),
        originatingAppointment = originatingAppointment?.build(),
        start = start?.build(),
        end = end?.build(),
        minutesDuration = minutesDuration?.build(),
        requestedPeriod = requestedPeriod.map { it.build() },
        slot = slot.map { it.build() },
        account = account.map { it.build() },
        created = created?.build(),
        cancellationDate = cancellationDate?.build(),
        note = note.map { it.build() },
        patientInstruction = patientInstruction.map { it.build() },
        basedOn = basedOn.map { it.build() },
        subject = subject?.build(),
        participant = participant.map { it.build() },
        recurrenceId = recurrenceId?.build(),
        occurrenceChanged = occurrenceChanged?.build(),
        recurrenceTemplate = recurrenceTemplate.map { it.build() },
      )
  }

  /** The Participation status of an appointment. */
  public enum class ParticipationStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Accepted("accepted", "http://hl7.org/fhir/participationstatus", "Accepted"),
    Declined("declined", "http://hl7.org/fhir/participationstatus", "Declined"),
    Tentative("tentative", "http://hl7.org/fhir/participationstatus", "Tentative"),
    Needs_Action("needs-action", "http://hl7.org/fhir/participationstatus", "Needs Action");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ParticipationStatus =
        when (code) {
          "accepted" -> Accepted
          "declined" -> Declined
          "tentative" -> Tentative
          "needs-action" -> Needs_Action
          else -> throw IllegalArgumentException("Unknown code $code for enum ParticipationStatus")
        }
    }
  }

  /** The free/busy status of an appointment. */
  public enum class AppointmentStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Proposed("proposed", "http://hl7.org/fhir/appointmentstatus", "Proposed"),
    Pending("pending", "http://hl7.org/fhir/appointmentstatus", "Pending"),
    Booked("booked", "http://hl7.org/fhir/appointmentstatus", "Booked"),
    Arrived("arrived", "http://hl7.org/fhir/appointmentstatus", "Arrived"),
    Fulfilled("fulfilled", "http://hl7.org/fhir/appointmentstatus", "Fulfilled"),
    Cancelled("cancelled", "http://hl7.org/fhir/appointmentstatus", "Cancelled"),
    Noshow("noshow", "http://hl7.org/fhir/appointmentstatus", "No Show"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/appointmentstatus",
      "Entered in error",
    ),
    Checked_In("checked-in", "http://hl7.org/fhir/appointmentstatus", "Checked In"),
    Waitlist("waitlist", "http://hl7.org/fhir/appointmentstatus", "Waitlisted");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AppointmentStatus =
        when (code) {
          "proposed" -> Proposed
          "pending" -> Pending
          "booked" -> Booked
          "arrived" -> Arrived
          "fulfilled" -> Fulfilled
          "cancelled" -> Cancelled
          "noshow" -> Noshow
          "entered-in-error" -> Entered_In_Error
          "checked-in" -> Checked_In
          "waitlist" -> Waitlist
          else -> throw IllegalArgumentException("Unknown code $code for enum AppointmentStatus")
        }
    }
  }
}
