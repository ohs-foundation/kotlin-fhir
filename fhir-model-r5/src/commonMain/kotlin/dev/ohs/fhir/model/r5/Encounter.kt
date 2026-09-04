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

import dev.ohs.fhir.model.r5.serializers.EncounterAdmissionSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterDiagnosisSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterLocationSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterReasonSerializer
import dev.ohs.fhir.model.r5.serializers.EncounterSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing
 * healthcare service(s) or assessing the health status of patient(s).
 */
@Serializable(with = EncounterSerializer::class)
@SerialName("Encounter")
public data class Encounter(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
   */
  override val id: String? = null,
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
  /** Identifier(s) by which this encounter is known. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The current state of the encounter (not the state of the patient within the encounter - that is
   * subjectState).
   *
   * Note that internal business rules will determine the appropriate transitions that may occur
   * between statuses (and also classes).
   */
  public val status: Enumeration<EncounterStatus>,
  /**
   * Concepts representing classification of patient encounter such as ambulatory (outpatient),
   * inpatient, emergency, home health or others due to local variations.
   */
  public val `class`: List<CodeableConcept> = listOf(),
  /** Indicates the urgency of the encounter. */
  public val priority: CodeableConcept? = null,
  /**
   * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing,
   * rehabilitation).
   *
   * Since there are many ways to further classify encounters, this element is 0..*.
   */
  public val type: List<CodeableConcept> = listOf(),
  /** Broad categorization of the service that is to be provided (e.g. cardiology). */
  public val serviceType: List<CodeableReference> = listOf(),
  /**
   * The patient or group related to this encounter. In some use-cases the patient MAY not be
   * present, such as a case meeting about a patient between several practitioners or a careteam.
   *
   * While the encounter is always about the patient, the patient might not actually be known in all
   * contexts of use, and there may be a group of patients that could be anonymous (such as in a
   * group therapy for Alcoholics Anonymous - where the recording of the encounter could be used for
   * billing on the number of people/staff and not important to the context of the specific
   * patients) or alternately in veterinary care a herd of sheep receiving treatment (where the
   * animals are not individually tracked).
   */
  public val subject: Reference? = null,
  /**
   * The subjectStatus value can be used to track the patient's status within the encounter. It
   * details whether the patient has arrived or departed, has been triaged or is currently in a
   * waiting status.
   *
   * Different use-cases are likely to have different permitted transitions between states, such as
   * an Emergency department could use `arrived` when the patient first presents, then `triaged`
   * once has been assessed by a nurse, then `receiving-care` once treatment begins, however other
   * sectors may use a different set of these values, or their own custom set in place of this
   * example valueset provided.
   */
  public val subjectStatus: CodeableConcept? = null,
  /**
   * Where a specific encounter should be classified as a part of a specific episode(s) of care this
   * field should be used. This association can facilitate grouping of related encounters together
   * for a specific purpose, such as government reporting, issue tracking, association via a common
   * problem. The association is recorded on the encounter as these are typically created after the
   * episode of care and grouped on entry rather than editing the episode of care to append another
   * encounter to it (the episode of care could span years).
   */
  public val episodeOfCare: List<Reference> = listOf(),
  /** The request this encounter satisfies (e.g. incoming referral or procedure request). */
  public val basedOn: List<Reference> = listOf(),
  /**
   * The group(s) of individuals, organizations that are allocated to participate in this encounter.
   * The participants backbone will record the actuals of when these individuals participated during
   * the encounter.
   */
  public val careTeam: List<Reference> = listOf(),
  /**
   * Another Encounter of which this encounter is a part of (administratively or in time).
   *
   * This is also used for associating a child's encounter back to the mother's encounter.
   *
   * Refer to the Notes section in the Patient resource for further details.
   */
  public val partOf: Reference? = null,
  /**
   * The organization that is primarily responsible for this Encounter's services. This MAY be the
   * same as the organization on the Patient record, however it could be different, such as if the
   * actor performing the services was from an external organization (which may be billed
   * seperately) for an external consultation. Refer to the colonoscopy example on the Encounter
   * examples tab.
   */
  public val serviceProvider: Reference? = null,
  /**
   * The list of people responsible for providing the service.
   *
   * Any Patient or Group present in the participation.actor must also be the subject, though the
   * subject may be absent from the participation.actor for cases where the patient (or group) is
   * not present, such as during a case review conference.
   */
  public val participant: List<Participant> = listOf(),
  /** The appointment that scheduled this encounter. */
  public val appointment: List<Reference> = listOf(),
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
   * VirtualServiceContactDetail can be applied to the Encounter.participant BackboneElement.
   */
  public val virtualService: List<VirtualServiceDetail> = listOf(),
  /**
   * The actual start and end time of the encounter.
   *
   * If not (yet) known, the end of the Period may be omitted.
   */
  public val actualPeriod: Period? = null,
  /** The planned start date/time (or admission date) of the encounter. */
  public val plannedStartDate: DateTime? = null,
  /** The planned end date/time (or discharge date) of the encounter. */
  public val plannedEndDate: DateTime? = null,
  /**
   * Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.
   *
   * When missing it is the time in between the start and end values.
   *
   * If the precision on these values is low (e.g. to the day only) then this may be considered was
   * an all day (or multi-day) encounter, unless the duration is included, where that amount of time
   * occurred sometime during the interval.
   *
   * May differ from the time in `Encounter.period` due to leave of absence(s).
   */
  public val length: Duration? = null,
  /**
   * The list of medical reasons that are expected to be addressed during the episode of care.
   *
   * The reason communicates what medical problem the patient has that should be addressed during
   * the episode of care. This reason could be patient reported complaint, a clinical indication
   * that was determined in a previous encounter or episode of care, or some planned care such as an
   * immunization recommendation. In the case where you have a primary reason, but are expecting to
   * also address other problems, you can list the primary reason with a use code of 'Chief
   * Complaint', while the other problems being addressed would have a use code of 'Reason for
   * Visit'.
   *
   * Examples: pregnancy would use HealthcareService or a coding as the reason patient home
   * monitoring could use Condition as the reason
   */
  public val reason: List<Reason> = listOf(),
  /**
   * The list of diagnosis relevant to this encounter.
   *
   * Also note that for the purpose of billing, the diagnoses are recorded in the account where they
   * can be ranked appropriately for how the invoicing/claiming documentation needs to be prepared.
   */
  public val diagnosis: List<Diagnosis> = listOf(),
  /**
   * The set of accounts that may be used for billing for this Encounter.
   *
   * The billing system may choose to allocate billable items associated with the Encounter to
   * different referenced Accounts based on internal business rules.
   */
  public val account: List<Reference> = listOf(),
  /**
   * Diet preferences reported by the patient.
   *
   * For example, a patient may request both a dairy-free and nut-free diet preference (not mutually
   * exclusive).
   */
  public val dietPreference: List<CodeableConcept> = listOf(),
  /**
   * Any special requests that have been made for this encounter, such as the provision of specific
   * equipment or other things.
   */
  public val specialArrangement: List<CodeableConcept> = listOf(),
  /**
   * Special courtesies that may be provided to the patient during the encounter (VIP, board member,
   * professional courtesy).
   *
   * Although the specialCourtesy property can contain values like VIP, the purpose of this field is
   * intended to be used for flagging additional `benefits` that might occur for the patient during
   * the encounter.
   *
   * It could include things like the patient is to have a private room, special room features,
   * receive a friendly visit from hospital adminisitration, or should be briefed on treatment by
   * senior staff during the stay.
   *
   * It is not specifically intended to be used for securing the specific record - that is the
   * purpose of the security meta tag, and where appropriate, both fields could be used.
   */
  public val specialCourtesy: List<CodeableConcept> = listOf(),
  /**
   * Details about the stay during which a healthcare service is provided.
   *
   * This does not describe the event of admitting the patient, but rather any information that is
   * relevant from the time of admittance until the time of discharge.
   *
   * An Encounter may cover more than just the inpatient stay. Contexts such as outpatients,
   * community clinics, and aged care facilities are also included.
   *
   * The duration recorded in the period of this encounter covers the entire scope of this admission
   * record.
   */
  public val admission: Admission? = null,
  /**
   * List of locations where the patient has been during this encounter.
   *
   * Virtual encounters can be recorded in the Encounter by specifying a location reference to a
   * location of type "kind" such as "client's home" and an encounter.class = "virtual".
   */
  public val location: List<Location> = listOf(),
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
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        `class` = this@with.`class`.map { it.toBuilder() }.toMutableList()
        priority = this@with.priority?.toBuilder()
        type = this@with.type.map { it.toBuilder() }.toMutableList()
        serviceType = this@with.serviceType.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        subjectStatus = this@with.subjectStatus?.toBuilder()
        episodeOfCare = this@with.episodeOfCare.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        careTeam = this@with.careTeam.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf?.toBuilder()
        serviceProvider = this@with.serviceProvider?.toBuilder()
        participant = this@with.participant.map { it.toBuilder() }.toMutableList()
        appointment = this@with.appointment.map { it.toBuilder() }.toMutableList()
        virtualService = this@with.virtualService.map { it.toBuilder() }.toMutableList()
        actualPeriod = this@with.actualPeriod?.toBuilder()
        plannedStartDate = this@with.plannedStartDate?.toBuilder()
        plannedEndDate = this@with.plannedEndDate?.toBuilder()
        length = this@with.length?.toBuilder()
        reason = this@with.reason.map { it.toBuilder() }.toMutableList()
        diagnosis = this@with.diagnosis.map { it.toBuilder() }.toMutableList()
        account = this@with.account.map { it.toBuilder() }.toMutableList()
        dietPreference = this@with.dietPreference.map { it.toBuilder() }.toMutableList()
        specialArrangement = this@with.specialArrangement.map { it.toBuilder() }.toMutableList()
        specialCourtesy = this@with.specialCourtesy.map { it.toBuilder() }.toMutableList()
        admission = this@with.admission?.toBuilder()
        location = this@with.location.map { it.toBuilder() }.toMutableList()
      }
    }

  /** The list of people responsible for providing the service. */
  @Serializable(with = EncounterParticipantSerializer::class)
  public data class Participant(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * Role of participant in encounter.
     *
     * The participant type indicates how an individual actor participates in an encounter. It
     * includes non-practitioner participants, and for practitioners this is to describe the action
     * type in the context of this encounter (e.g. Admitting Dr, Attending Dr, Translator,
     * Consulting Dr). This is different to the practitioner roles which are functional roles,
     * derived from terms of employment, education, licensing, etc.
     */
    public val type: List<CodeableConcept> = listOf(),
    /**
     * The period of time that the specified participant participated in the encounter. These can
     * overlap or be sub-sets of the overall encounter's period.
     */
    public val period: Period? = null,
    /**
     * Person involved in the encounter, the patient/group is also included here to indicate that
     * the patient was actually participating in the encounter. Not including the patient here
     * covers use cases such as a case meeting between practitioners about a patient - non contact
     * times.
     *
     * For planning purposes, Appointments may include a CareTeam participant to indicate that one
     * specific person from the CareTeam will be assigned, but that assignment might not happen
     * until the Encounter begins. Hence CareTeam is not included in Encounter.participant, as the
     * specific individual should be assigned and represented as a Practitioner or other person
     * resource.
     *
     * Similarly, Location can be included in Appointment.participant to assist with planning.
     * However, the patient location is tracked on the Encounter in the Encounter.location property
     * to allow for additional metadata and history to be recorded.
     *
     * The role of the participant can be used to declare what the actor will be doing in the scope
     * of this encounter participation.
     *
     * If the individual is not specified during planning, then it is expected that the individual
     * will be filled in at a later stage prior to the encounter commencing.
     */
    public val actor: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
          period = this@with.period?.toBuilder()
          actor = this@with.actor?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Role of participant in encounter.
       *
       * The participant type indicates how an individual actor participates in an encounter. It
       * includes non-practitioner participants, and for practitioners this is to describe the
       * action type in the context of this encounter (e.g. Admitting Dr, Attending Dr, Translator,
       * Consulting Dr). This is different to the practitioner roles which are functional roles,
       * derived from terms of employment, education, licensing, etc.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The period of time that the specified participant participated in the encounter. These can
       * overlap or be sub-sets of the overall encounter's period.
       */
      public var period: Period.Builder? = null

      /**
       * Person involved in the encounter, the patient/group is also included here to indicate that
       * the patient was actually participating in the encounter. Not including the patient here
       * covers use cases such as a case meeting between practitioners about a patient - non contact
       * times.
       *
       * For planning purposes, Appointments may include a CareTeam participant to indicate that one
       * specific person from the CareTeam will be assigned, but that assignment might not happen
       * until the Encounter begins. Hence CareTeam is not included in Encounter.participant, as the
       * specific individual should be assigned and represented as a Practitioner or other person
       * resource.
       *
       * Similarly, Location can be included in Appointment.participant to assist with planning.
       * However, the patient location is tracked on the Encounter in the Encounter.location
       * property to allow for additional metadata and history to be recorded.
       *
       * The role of the participant can be used to declare what the actor will be doing in the
       * scope of this encounter participation.
       *
       * If the individual is not specified during planning, then it is expected that the individual
       * will be filled in at a later stage prior to the encounter commencing.
       */
      public var actor: Reference.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type.map { it.build() },
          period = period?.build(),
          actor = actor?.build(),
        )
    }
  }

  /** The list of medical reasons that are expected to be addressed during the episode of care. */
  @Serializable(with = EncounterReasonSerializer::class)
  public data class Reason(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * What the reason value should be used as e.g. Chief Complaint, Health Concern, Health
     * Maintenance (including screening).
     */
    public val use: List<CodeableConcept> = listOf(),
    /**
     * Reason the encounter takes place, expressed as a code or a reference to another resource. For
     * admissions, this can be used for a coded admission diagnosis.
     */
    public val `value`: List<CodeableReference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          use = this@with.use.map { it.toBuilder() }.toMutableList()
          `value` = this@with.`value`.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * What the reason value should be used as e.g. Chief Complaint, Health Concern, Health
       * Maintenance (including screening).
       */
      public var use: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Reason the encounter takes place, expressed as a code or a reference to another resource.
       * For admissions, this can be used for a coded admission diagnosis.
       */
      public var `value`: MutableList<CodeableReference.Builder> = mutableListOf()

      public fun build(): Reason =
        Reason(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          use = use.map { it.build() },
          `value` = `value`.map { it.build() },
        )
    }
  }

  /** The list of diagnosis relevant to this encounter. */
  @Serializable(with = EncounterDiagnosisSerializer::class)
  public data class Diagnosis(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
     * The coded diagnosis or a reference to a Condition (with other resources referenced in the
     * evidence.detail), the use property will indicate the purpose of this specific diagnosis.
     */
    public val condition: List<CodeableReference> = listOf(),
    /** Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …). */
    public val use: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          condition = this@with.condition.map { it.toBuilder() }.toMutableList()
          use = this@with.use.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * The coded diagnosis or a reference to a Condition (with other resources referenced in the
       * evidence.detail), the use property will indicate the purpose of this specific diagnosis.
       */
      public var condition: MutableList<CodeableReference.Builder> = mutableListOf()

      /**
       * Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).
       */
      public var use: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Diagnosis =
        Diagnosis(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          condition = condition.map { it.build() },
          use = use.map { it.build() },
        )
    }
  }

  /**
   * Details about the stay during which a healthcare service is provided.
   *
   * This does not describe the event of admitting the patient, but rather any information that is
   * relevant from the time of admittance until the time of discharge.
   */
  @Serializable(with = EncounterAdmissionSerializer::class)
  public data class Admission(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** Pre-admission identifier. */
    public val preAdmissionIdentifier: Identifier? = null,
    /** The location/organization from which the patient came before admission. */
    public val origin: Reference? = null,
    /** From where patient was admitted (physician referral, transfer). */
    public val admitSource: CodeableConcept? = null,
    /**
     * Indicates that this encounter is directly related to a prior admission, often because the
     * conditions addressed in the prior admission were not fully addressed.
     */
    public val reAdmission: CodeableConcept? = null,
    /** Location/organization to which the patient is discharged. */
    public val destination: Reference? = null,
    /** Category or kind of location after discharge. */
    public val dischargeDisposition: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          preAdmissionIdentifier = this@with.preAdmissionIdentifier?.toBuilder()
          origin = this@with.origin?.toBuilder()
          admitSource = this@with.admitSource?.toBuilder()
          reAdmission = this@with.reAdmission?.toBuilder()
          destination = this@with.destination?.toBuilder()
          dischargeDisposition = this@with.dischargeDisposition?.toBuilder()
        }
      }

    public class Builder() {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** Pre-admission identifier. */
      public var preAdmissionIdentifier: Identifier.Builder? = null

      /** The location/organization from which the patient came before admission. */
      public var origin: Reference.Builder? = null

      /** From where patient was admitted (physician referral, transfer). */
      public var admitSource: CodeableConcept.Builder? = null

      /**
       * Indicates that this encounter is directly related to a prior admission, often because the
       * conditions addressed in the prior admission were not fully addressed.
       */
      public var reAdmission: CodeableConcept.Builder? = null

      /** Location/organization to which the patient is discharged. */
      public var destination: Reference.Builder? = null

      /** Category or kind of location after discharge. */
      public var dischargeDisposition: CodeableConcept.Builder? = null

      public fun build(): Admission =
        Admission(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          preAdmissionIdentifier = preAdmissionIdentifier?.build(),
          origin = origin?.build(),
          admitSource = admitSource?.build(),
          reAdmission = reAdmission?.build(),
          destination = destination?.build(),
          dischargeDisposition = dischargeDisposition?.build(),
        )
    }
  }

  /** List of locations where the patient has been during this encounter. */
  @Serializable(with = EncounterLocationSerializer::class)
  public data class Location(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** The location where the encounter takes place. */
    public val location: Reference,
    /**
     * The status of the participants' presence at the specified location during the period
     * specified. If the participant is no longer at the location, then the period will have an end
     * date/time.
     *
     * When the patient is no longer active at a location, then the period end date is entered, and
     * the status may be changed to completed.
     */
    public val status: Enumeration<EncounterLocationStatus>? = null,
    /**
     * This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded
     * to simplify either messaging or query.
     *
     * This information is de-normalized from the Location resource to support the easier
     * understanding of the encounter resource and processing in messaging or query.
     *
     * There may be many levels in the hierachy, and this may only pic specific levels that are
     * required for a specific usage scenario.
     */
    public val form: CodeableConcept? = null,
    /** Time period during which the patient was present at the location. */
    public val period: Period? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(location.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          status = this@with.status
          form = this@with.form?.toBuilder()
          period = this@with.period?.toBuilder()
        }
      }

    public class Builder(
      /** The location where the encounter takes place. */
      public var location: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * The status of the participants' presence at the specified location during the period
       * specified. If the participant is no longer at the location, then the period will have an
       * end date/time.
       *
       * When the patient is no longer active at a location, then the period end date is entered,
       * and the status may be changed to completed.
       */
      public var status: Enumeration<EncounterLocationStatus>? = null

      /**
       * This will be used to specify the required levels (bed/ward/room/etc.) desired to be
       * recorded to simplify either messaging or query.
       *
       * This information is de-normalized from the Location resource to support the easier
       * understanding of the encounter resource and processing in messaging or query.
       *
       * There may be many levels in the hierachy, and this may only pic specific levels that are
       * required for a specific usage scenario.
       */
      public var form: CodeableConcept.Builder? = null

      /** Time period during which the patient was present at the location. */
      public var period: Period.Builder? = null

      public fun build(): Location =
        Location(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          location = location.build(),
          status = status,
          form = form?.build(),
          period = period?.build(),
        )
    }
  }

  public class Builder(
    /**
     * The current state of the encounter (not the state of the patient within the encounter - that
     * is subjectState).
     *
     * Note that internal business rules will determine the appropriate transitions that may occur
     * between statuses (and also classes).
     */
    public var status: Enumeration<EncounterStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    override var id: String? = null

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

    /** Identifier(s) by which this encounter is known. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Concepts representing classification of patient encounter such as ambulatory (outpatient),
     * inpatient, emergency, home health or others due to local variations.
     */
    public var `class`: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates the urgency of the encounter. */
    public var priority: CodeableConcept.Builder? = null

    /**
     * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing,
     * rehabilitation).
     *
     * Since there are many ways to further classify encounters, this element is 0..*.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Broad categorization of the service that is to be provided (e.g. cardiology). */
    public var serviceType: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * The patient or group related to this encounter. In some use-cases the patient MAY not be
     * present, such as a case meeting about a patient between several practitioners or a careteam.
     *
     * While the encounter is always about the patient, the patient might not actually be known in
     * all contexts of use, and there may be a group of patients that could be anonymous (such as in
     * a group therapy for Alcoholics Anonymous - where the recording of the encounter could be used
     * for billing on the number of people/staff and not important to the context of the specific
     * patients) or alternately in veterinary care a herd of sheep receiving treatment (where the
     * animals are not individually tracked).
     */
    public var subject: Reference.Builder? = null

    /**
     * The subjectStatus value can be used to track the patient's status within the encounter. It
     * details whether the patient has arrived or departed, has been triaged or is currently in a
     * waiting status.
     *
     * Different use-cases are likely to have different permitted transitions between states, such
     * as an Emergency department could use `arrived` when the patient first presents, then
     * `triaged` once has been assessed by a nurse, then `receiving-care` once treatment begins,
     * however other sectors may use a different set of these values, or their own custom set in
     * place of this example valueset provided.
     */
    public var subjectStatus: CodeableConcept.Builder? = null

    /**
     * Where a specific encounter should be classified as a part of a specific episode(s) of care
     * this field should be used. This association can facilitate grouping of related encounters
     * together for a specific purpose, such as government reporting, issue tracking, association
     * via a common problem. The association is recorded on the encounter as these are typically
     * created after the episode of care and grouped on entry rather than editing the episode of
     * care to append another encounter to it (the episode of care could span years).
     */
    public var episodeOfCare: MutableList<Reference.Builder> = mutableListOf()

    /** The request this encounter satisfies (e.g. incoming referral or procedure request). */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The group(s) of individuals, organizations that are allocated to participate in this
     * encounter. The participants backbone will record the actuals of when these individuals
     * participated during the encounter.
     */
    public var careTeam: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Another Encounter of which this encounter is a part of (administratively or in time).
     *
     * This is also used for associating a child's encounter back to the mother's encounter.
     *
     * Refer to the Notes section in the Patient resource for further details.
     */
    public var partOf: Reference.Builder? = null

    /**
     * The organization that is primarily responsible for this Encounter's services. This MAY be the
     * same as the organization on the Patient record, however it could be different, such as if the
     * actor performing the services was from an external organization (which may be billed
     * seperately) for an external consultation. Refer to the colonoscopy example on the Encounter
     * examples tab.
     */
    public var serviceProvider: Reference.Builder? = null

    /**
     * The list of people responsible for providing the service.
     *
     * Any Patient or Group present in the participation.actor must also be the subject, though the
     * subject may be absent from the participation.actor for cases where the patient (or group) is
     * not present, such as during a case review conference.
     */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /** The appointment that scheduled this encounter. */
    public var appointment: MutableList<Reference.Builder> = mutableListOf()

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
     * VirtualServiceContactDetail can be applied to the Encounter.participant BackboneElement.
     */
    public var virtualService: MutableList<VirtualServiceDetail.Builder> = mutableListOf()

    /**
     * The actual start and end time of the encounter.
     *
     * If not (yet) known, the end of the Period may be omitted.
     */
    public var actualPeriod: Period.Builder? = null

    /** The planned start date/time (or admission date) of the encounter. */
    public var plannedStartDate: DateTime.Builder? = null

    /** The planned end date/time (or discharge date) of the encounter. */
    public var plannedEndDate: DateTime.Builder? = null

    /**
     * Actual quantity of time the encounter lasted. This excludes the time during leaves of
     * absence.
     *
     * When missing it is the time in between the start and end values.
     *
     * If the precision on these values is low (e.g. to the day only) then this may be considered
     * was an all day (or multi-day) encounter, unless the duration is included, where that amount
     * of time occurred sometime during the interval.
     *
     * May differ from the time in `Encounter.period` due to leave of absence(s).
     */
    public var length: Duration.Builder? = null

    /**
     * The list of medical reasons that are expected to be addressed during the episode of care.
     *
     * The reason communicates what medical problem the patient has that should be addressed during
     * the episode of care. This reason could be patient reported complaint, a clinical indication
     * that was determined in a previous encounter or episode of care, or some planned care such as
     * an immunization recommendation. In the case where you have a primary reason, but are
     * expecting to also address other problems, you can list the primary reason with a use code of
     * 'Chief Complaint', while the other problems being addressed would have a use code of 'Reason
     * for Visit'.
     *
     * Examples: pregnancy would use HealthcareService or a coding as the reason patient home
     * monitoring could use Condition as the reason
     */
    public var reason: MutableList<Reason.Builder> = mutableListOf()

    /**
     * The list of diagnosis relevant to this encounter.
     *
     * Also note that for the purpose of billing, the diagnoses are recorded in the account where
     * they can be ranked appropriately for how the invoicing/claiming documentation needs to be
     * prepared.
     */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /**
     * The set of accounts that may be used for billing for this Encounter.
     *
     * The billing system may choose to allocate billable items associated with the Encounter to
     * different referenced Accounts based on internal business rules.
     */
    public var account: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Diet preferences reported by the patient.
     *
     * For example, a patient may request both a dairy-free and nut-free diet preference (not
     * mutually exclusive).
     */
    public var dietPreference: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Any special requests that have been made for this encounter, such as the provision of
     * specific equipment or other things.
     */
    public var specialArrangement: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Special courtesies that may be provided to the patient during the encounter (VIP, board
     * member, professional courtesy).
     *
     * Although the specialCourtesy property can contain values like VIP, the purpose of this field
     * is intended to be used for flagging additional `benefits` that might occur for the patient
     * during the encounter.
     *
     * It could include things like the patient is to have a private room, special room features,
     * receive a friendly visit from hospital adminisitration, or should be briefed on treatment by
     * senior staff during the stay.
     *
     * It is not specifically intended to be used for securing the specific record - that is the
     * purpose of the security meta tag, and where appropriate, both fields could be used.
     */
    public var specialCourtesy: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Details about the stay during which a healthcare service is provided.
     *
     * This does not describe the event of admitting the patient, but rather any information that is
     * relevant from the time of admittance until the time of discharge.
     *
     * An Encounter may cover more than just the inpatient stay. Contexts such as outpatients,
     * community clinics, and aged care facilities are also included.
     *
     * The duration recorded in the period of this encounter covers the entire scope of this
     * admission record.
     */
    public var admission: Admission.Builder? = null

    /**
     * List of locations where the patient has been during this encounter.
     *
     * Virtual encounters can be recorded in the Encounter by specifying a location reference to a
     * location of type "kind" such as "client's home" and an encounter.class = "virtual".
     */
    public var location: MutableList<Location.Builder> = mutableListOf()

    override fun build(): Encounter =
      Encounter(
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
        `class` = `class`.map { it.build() },
        priority = priority?.build(),
        type = type.map { it.build() },
        serviceType = serviceType.map { it.build() },
        subject = subject?.build(),
        subjectStatus = subjectStatus?.build(),
        episodeOfCare = episodeOfCare.map { it.build() },
        basedOn = basedOn.map { it.build() },
        careTeam = careTeam.map { it.build() },
        partOf = partOf?.build(),
        serviceProvider = serviceProvider?.build(),
        participant = participant.map { it.build() },
        appointment = appointment.map { it.build() },
        virtualService = virtualService.map { it.build() },
        actualPeriod = actualPeriod?.build(),
        plannedStartDate = plannedStartDate?.build(),
        plannedEndDate = plannedEndDate?.build(),
        length = length?.build(),
        reason = reason.map { it.build() },
        diagnosis = diagnosis.map { it.build() },
        account = account.map { it.build() },
        dietPreference = dietPreference.map { it.build() },
        specialArrangement = specialArrangement.map { it.build() },
        specialCourtesy = specialCourtesy.map { it.build() },
        admission = admission?.build(),
        location = location.map { it.build() },
      )
  }

  /** The status of the location. */
  public enum class EncounterLocationStatus(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    Planned("planned", "http://hl7.org/fhir/encounter-location-status", "Planned"),
    Active("active", "http://hl7.org/fhir/encounter-location-status", "Active"),
    Reserved("reserved", "http://hl7.org/fhir/encounter-location-status", "Reserved"),
    Completed("completed", "http://hl7.org/fhir/encounter-location-status", "Completed");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): EncounterLocationStatus =
        when (code) {
          "planned" -> Planned
          "active" -> Active
          "reserved" -> Reserved
          "completed" -> Completed
          else ->
            throw IllegalArgumentException("Unknown code $code for enum EncounterLocationStatus")
        }
    }
  }

  /** Current state of the encounter. */
  public enum class EncounterStatus(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    Planned("planned", "http://hl7.org/fhir/encounter-status", "Planned"),
    In_Progress("in-progress", "http://hl7.org/fhir/encounter-status", "In Progress"),
    On_Hold("on-hold", "http://hl7.org/fhir/encounter-status", "On Hold"),
    Discharged("discharged", "http://hl7.org/fhir/encounter-status", "Discharged"),
    Completed("completed", "http://hl7.org/fhir/encounter-status", "Completed"),
    Cancelled("cancelled", "http://hl7.org/fhir/encounter-status", "Cancelled"),
    Discontinued("discontinued", "http://hl7.org/fhir/encounter-status", "Discontinued"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/encounter-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/encounter-status", "Unknown");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): EncounterStatus =
        when (code) {
          "planned" -> Planned
          "in-progress" -> In_Progress
          "on-hold" -> On_Hold
          "discharged" -> Discharged
          "completed" -> Completed
          "cancelled" -> Cancelled
          "discontinued" -> Discontinued
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum EncounterStatus")
        }
    }
  }
}
