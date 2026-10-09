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

import dev.ohs.fhir.model.r4b.serializers.EncounterClassHistorySerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterDiagnosisSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterHospitalizationSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterLocationSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterParticipantSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterSerializer
import dev.ohs.fhir.model.r4b.serializers.EncounterStatusHistorySerializer
import dev.ohs.fhir.model.r4b.terminologies.EncounterLocationStatus
import dev.ohs.fhir.model.r4b.terminologies.EncounterStatus
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An interaction between a patient and healthcare provider(s) for the purpose of providing
 * healthcare service(s) or assessing the health status of a patient.
 */
@Serializable(with = EncounterSerializer::class)
@SerialName("Encounter")
public data class Encounter(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
  /** Identifier(s) by which this encounter is known. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * planned | arrived | triaged | in-progress | onleave | finished | cancelled +.
   *
   * Note that internal business rules will determine the appropriate transitions that may occur
   * between statuses (and also classes).
   */
  public val status: Enumeration<EncounterStatus>,
  /**
   * The status history permits the encounter resource to contain the status history without needing
   * to read through the historical versions of the resource, or even have the server store them.
   *
   * The current status is always found in the current version of the resource, not the status
   * history.
   */
  public val statusHistory: List<StatusHistory> = listOf(),
  /**
   * Concepts representing classification of patient encounter such as ambulatory (outpatient),
   * inpatient, emergency, home health or others due to local variations.
   */
  public val `class`: Coding,
  /**
   * The class history permits the tracking of the encounters transitions without needing to go
   * through the resource history. This would be used for a case where an admission starts of as an
   * emergency encounter, then transitions into an inpatient scenario. Doing this and not restarting
   * a new encounter ensures that any lab/diagnostic results can more easily follow the patient and
   * not require re-processing and not get lost or cancelled during a kind of discharge from
   * emergency to inpatient.
   */
  public val classHistory: List<ClassHistory> = listOf(),
  /**
   * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing,
   * rehabilitation).
   *
   * Since there are many ways to further classify encounters, this element is 0..*.
   */
  public val type: List<CodeableConcept> = listOf(),
  /** Broad categorization of the service that is to be provided (e.g. cardiology). */
  public val serviceType: CodeableConcept? = null,
  /** Indicates the urgency of the encounter. */
  public val priority: CodeableConcept? = null,
  /**
   * The patient or group present at the encounter.
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
  /** The list of people responsible for providing the service. */
  public val participant: List<Participant> = listOf(),
  /** The appointment that scheduled this encounter. */
  public val appointment: List<Reference> = listOf(),
  /**
   * The start and end time of the encounter.
   *
   * If not (yet) known, the end of the Period may be omitted.
   */
  public val period: Period? = null,
  /**
   * Quantity of time the encounter lasted. This excludes the time during leaves of absence.
   *
   * May differ from the time the Encounter.period lasted because of leave of absence.
   */
  public val length: Duration? = null,
  /**
   * Reason the encounter takes place, expressed as a code. For admissions, this can be used for a
   * coded admission diagnosis.
   *
   * For systems that need to know which was the primary diagnosis, these will be marked with the
   * standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 = primary
   * diagnosis).
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /**
   * Reason the encounter takes place, expressed as a code. For admissions, this can be used for a
   * coded admission diagnosis.
   *
   * For systems that need to know which was the primary diagnosis, these will be marked with the
   * standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 = primary
   * diagnosis).
   */
  public val reasonReference: List<Reference> = listOf(),
  /** The list of diagnosis relevant to this encounter. */
  public val diagnosis: List<Diagnosis> = listOf(),
  /**
   * The set of accounts that may be used for billing for this Encounter.
   *
   * The billing system may choose to allocate billable items associated with the Encounter to
   * different referenced Accounts based on internal business rules.
   */
  public val account: List<Reference> = listOf(),
  /**
   * Details about the admission to a healthcare service.
   *
   * An Encounter may cover more than just the inpatient stay. Contexts such as outpatients,
   * community clinics, and aged care facilities are also included.
   *
   * The duration recorded in the period of this encounter covers the entire scope of this
   * hospitalization record.
   */
  public val hospitalization: Hospitalization? = null,
  /**
   * List of locations where the patient has been during this encounter.
   *
   * Virtual encounters can be recorded in the Encounter by specifying a location reference to a
   * location of type "kind" such as "client's home" and an encounter.class = "virtual".
   */
  public val location: List<Location> = listOf(),
  /**
   * The organization that is primarily responsible for this Encounter's services. This MAY be the
   * same as the organization on the Patient record, however it could be different, such as if the
   * actor performing the services was from an external organization (which may be billed
   * seperately) for an external consultation. Refer to the example bundle showing an abbreviated
   * set of Encounters for a colonoscopy.
   */
  public val serviceProvider: Reference? = null,
  /**
   * Another Encounter of which this encounter is a part of (administratively or in time).
   *
   * This is also used for associating a child's encounter back to the mother's encounter.
   *
   * Refer to the Notes section in the Patient resource for further details.
   */
  public val partOf: Reference? = null,
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        `class`.toBuilder(),
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
    builder.statusHistory = statusHistory.toBuilderList()
    builder.classHistory = classHistory.toBuilderList()
    builder.type = type.toBuilderList()
    builder.serviceType = serviceType?.toBuilder()
    builder.priority = priority?.toBuilder()
    builder.subject = subject?.toBuilder()
    builder.episodeOfCare = episodeOfCare.toBuilderList()
    builder.basedOn = basedOn.toBuilderList()
    builder.participant = participant.toBuilderList()
    builder.appointment = appointment.toBuilderList()
    builder.period = period?.toBuilder()
    builder.length = length?.toBuilder()
    builder.reasonCode = reasonCode.toBuilderList()
    builder.reasonReference = reasonReference.toBuilderList()
    builder.diagnosis = diagnosis.toBuilderList()
    builder.account = account.toBuilderList()
    builder.hospitalization = hospitalization?.toBuilder()
    builder.location = location.toBuilderList()
    builder.serviceProvider = serviceProvider?.toBuilder()
    builder.partOf = partOf?.toBuilder()
    return builder
  }

  /**
   * The status history permits the encounter resource to contain the status history without needing
   * to read through the historical versions of the resource, or even have the server store them.
   */
  @Serializable(with = EncounterStatusHistorySerializer::class)
  public data class StatusHistory(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** planned | arrived | triaged | in-progress | onleave | finished | cancelled +. */
    public val status: Enumeration<EncounterStatus>,
    /** The time that the episode was in the specified status. */
    public val period: Period,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder =
        Builder(
          status,
          period.toBuilder(),
        )
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public class Builder(
      /** planned | arrived | triaged | in-progress | onleave | finished | cancelled +. */
      public var status: Enumeration<EncounterStatus>,
      /** The time that the episode was in the specified status. */
      public var period: Period.Builder,
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      override fun build(): StatusHistory =
        StatusHistory(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          status = status,
          period = period.build(),
        )
    }
  }

  /**
   * The class history permits the tracking of the encounters transitions without needing to go
   * through the resource history. This would be used for a case where an admission starts of as an
   * emergency encounter, then transitions into an inpatient scenario. Doing this and not restarting
   * a new encounter ensures that any lab/diagnostic results can more easily follow the patient and
   * not require re-processing and not get lost or cancelled during a kind of discharge from
   * emergency to inpatient.
   */
  @Serializable(with = EncounterClassHistorySerializer::class)
  public data class ClassHistory(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** inpatient | outpatient | ambulatory | emergency +. */
    public val `class`: Coding,
    /** The time that the episode was in the specified class. */
    public val period: Period,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(`class`.toBuilder(), period.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      return builder
    }

    public class Builder(
      /** inpatient | outpatient | ambulatory | emergency +. */
      public var `class`: Coding.Builder,
      /** The time that the episode was in the specified class. */
      public var period: Period.Builder,
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      override fun build(): ClassHistory =
        ClassHistory(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          `class` = `class`.build(),
          period = period.build(),
        )
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
     * Role of participant in encounter.
     *
     * The participant type indicates how an individual participates in an encounter. It includes
     * non-practitioner participants, and for practitioners this is to describe the action type in
     * the context of this encounter (e.g. Admitting Dr, Attending Dr, Translator, Consulting Dr).
     * This is different to the practitioner roles which are functional roles, derived from terms of
     * employment, education, licensing, etc.
     */
    public val type: List<CodeableConcept> = listOf(),
    /**
     * The period of time that the specified participant participated in the encounter. These can
     * overlap or be sub-sets of the overall encounter's period.
     */
    public val period: Period? = null,
    /** Persons involved in the encounter other than the patient. */
    public val individual: Reference? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.type = type.toBuilderList()
      builder.period = period?.toBuilder()
      builder.individual = individual?.toBuilder()
      return builder
    }

    public class Builder() : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Role of participant in encounter.
       *
       * The participant type indicates how an individual participates in an encounter. It includes
       * non-practitioner participants, and for practitioners this is to describe the action type in
       * the context of this encounter (e.g. Admitting Dr, Attending Dr, Translator, Consulting Dr).
       * This is different to the practitioner roles which are functional roles, derived from terms
       * of employment, education, licensing, etc.
       */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The period of time that the specified participant participated in the encounter. These can
       * overlap or be sub-sets of the overall encounter's period.
       */
      public var period: Period.Builder? = null

      /** Persons involved in the encounter other than the patient. */
      public var individual: Reference.Builder? = null

      override fun build(): Participant =
        Participant(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          type = type.buildList(),
          period = period?.build(),
          individual = individual?.build(),
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
     * Reason the encounter takes place, as specified using information from another resource. For
     * admissions, this is the admission diagnosis. The indication will typically be a Condition
     * (with other resources referenced in the evidence.detail), or a Procedure.
     *
     * For systems that need to know which was the primary diagnosis, these will be marked with the
     * standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 =
     * primary diagnosis).
     */
    public val condition: Reference,
    /** Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …). */
    public val use: CodeableConcept? = null,
    /** Ranking of the diagnosis (for each role type). */
    public val rank: PositiveInt? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(condition.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.use = use?.toBuilder()
      builder.rank = rank?.toBuilder()
      return builder
    }

    public class Builder(
      /**
       * Reason the encounter takes place, as specified using information from another resource. For
       * admissions, this is the admission diagnosis. The indication will typically be a Condition
       * (with other resources referenced in the evidence.detail), or a Procedure.
       *
       * For systems that need to know which was the primary diagnosis, these will be marked with
       * the standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 =
       * primary diagnosis).
       */
      public var condition: Reference.Builder
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
       * Role that this diagnosis has within the encounter (e.g. admission, billing, discharge …).
       */
      public var use: CodeableConcept.Builder? = null

      /** Ranking of the diagnosis (for each role type). */
      public var rank: PositiveInt.Builder? = null

      override fun build(): Diagnosis =
        Diagnosis(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          condition = condition.build(),
          use = use?.build(),
          rank = rank?.build(),
        )
    }
  }

  /** Details about the admission to a healthcare service. */
  @Serializable(with = EncounterHospitalizationSerializer::class)
  public data class Hospitalization(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /** Pre-admission identifier. */
    public val preAdmissionIdentifier: Identifier? = null,
    /** The location/organization from which the patient came before admission. */
    public val origin: Reference? = null,
    /** From where patient was admitted (physician referral, transfer). */
    public val admitSource: CodeableConcept? = null,
    /** Whether this hospitalization is a readmission and why if known. */
    public val reAdmission: CodeableConcept? = null,
    /**
     * Diet preferences reported by the patient.
     *
     * For example, a patient may request both a dairy-free and nut-free diet preference (not
     * mutually exclusive).
     */
    public val dietPreference: List<CodeableConcept> = listOf(),
    /** Special courtesies (VIP, board member). */
    public val specialCourtesy: List<CodeableConcept> = listOf(),
    /**
     * Any special requests that have been made for this hospitalization encounter, such as the
     * provision of specific equipment or other things.
     */
    public val specialArrangement: List<CodeableConcept> = listOf(),
    /** Location/organization to which the patient is discharged. */
    public val destination: Reference? = null,
    /** Category or kind of location after discharge. */
    public val dischargeDisposition: CodeableConcept? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.preAdmissionIdentifier = preAdmissionIdentifier?.toBuilder()
      builder.origin = origin?.toBuilder()
      builder.admitSource = admitSource?.toBuilder()
      builder.reAdmission = reAdmission?.toBuilder()
      builder.dietPreference = dietPreference.toBuilderList()
      builder.specialCourtesy = specialCourtesy.toBuilderList()
      builder.specialArrangement = specialArrangement.toBuilderList()
      builder.destination = destination?.toBuilder()
      builder.dischargeDisposition = dischargeDisposition?.toBuilder()
      return builder
    }

    public class Builder() : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /** Pre-admission identifier. */
      public var preAdmissionIdentifier: Identifier.Builder? = null

      /** The location/organization from which the patient came before admission. */
      public var origin: Reference.Builder? = null

      /** From where patient was admitted (physician referral, transfer). */
      public var admitSource: CodeableConcept.Builder? = null

      /** Whether this hospitalization is a readmission and why if known. */
      public var reAdmission: CodeableConcept.Builder? = null

      /**
       * Diet preferences reported by the patient.
       *
       * For example, a patient may request both a dairy-free and nut-free diet preference (not
       * mutually exclusive).
       */
      public var dietPreference: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Special courtesies (VIP, board member). */
      public var specialCourtesy: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Any special requests that have been made for this hospitalization encounter, such as the
       * provision of specific equipment or other things.
       */
      public var specialArrangement: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Location/organization to which the patient is discharged. */
      public var destination: Reference.Builder? = null

      /** Category or kind of location after discharge. */
      public var dischargeDisposition: CodeableConcept.Builder? = null

      override fun build(): Hospitalization =
        Hospitalization(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          preAdmissionIdentifier = preAdmissionIdentifier?.build(),
          origin = origin?.build(),
          admitSource = admitSource?.build(),
          reAdmission = reAdmission?.build(),
          dietPreference = dietPreference.buildList(),
          specialCourtesy = specialCourtesy.buildList(),
          specialArrangement = specialArrangement.buildList(),
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
    public val physicalType: CodeableConcept? = null,
    /** Time period during which the patient was present at the location. */
    public val period: Period? = null,
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder(location.toBuilder())
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.status = status
      builder.physicalType = physicalType?.toBuilder()
      builder.period = period?.toBuilder()
      return builder
    }

    public class Builder(
      /** The location where the encounter takes place. */
      public var location: Reference.Builder
    ) : FhirBuilder {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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
      public var physicalType: CodeableConcept.Builder? = null

      /** Time period during which the patient was present at the location. */
      public var period: Period.Builder? = null

      override fun build(): Location =
        Location(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          location = location.build(),
          status = status,
          physicalType = physicalType?.build(),
          period = period?.build(),
        )
    }
  }

  public class Builder(
    /**
     * planned | arrived | triaged | in-progress | onleave | finished | cancelled +.
     *
     * Note that internal business rules will determine the appropriate transitions that may occur
     * between statuses (and also classes).
     */
    public var status: Enumeration<EncounterStatus>,
    /**
     * Concepts representing classification of patient encounter such as ambulatory (outpatient),
     * inpatient, emergency, home health or others due to local variations.
     */
    public var `class`: Coding.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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

    /** Identifier(s) by which this encounter is known. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The status history permits the encounter resource to contain the status history without
     * needing to read through the historical versions of the resource, or even have the server
     * store them.
     *
     * The current status is always found in the current version of the resource, not the status
     * history.
     */
    public var statusHistory: MutableList<StatusHistory.Builder> = mutableListOf()

    /**
     * The class history permits the tracking of the encounters transitions without needing to go
     * through the resource history. This would be used for a case where an admission starts of as
     * an emergency encounter, then transitions into an inpatient scenario. Doing this and not
     * restarting a new encounter ensures that any lab/diagnostic results can more easily follow the
     * patient and not require re-processing and not get lost or cancelled during a kind of
     * discharge from emergency to inpatient.
     */
    public var classHistory: MutableList<ClassHistory.Builder> = mutableListOf()

    /**
     * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing,
     * rehabilitation).
     *
     * Since there are many ways to further classify encounters, this element is 0..*.
     */
    public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Broad categorization of the service that is to be provided (e.g. cardiology). */
    public var serviceType: CodeableConcept.Builder? = null

    /** Indicates the urgency of the encounter. */
    public var priority: CodeableConcept.Builder? = null

    /**
     * The patient or group present at the encounter.
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

    /** The list of people responsible for providing the service. */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /** The appointment that scheduled this encounter. */
    public var appointment: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The start and end time of the encounter.
     *
     * If not (yet) known, the end of the Period may be omitted.
     */
    public var period: Period.Builder? = null

    /**
     * Quantity of time the encounter lasted. This excludes the time during leaves of absence.
     *
     * May differ from the time the Encounter.period lasted because of leave of absence.
     */
    public var length: Duration.Builder? = null

    /**
     * Reason the encounter takes place, expressed as a code. For admissions, this can be used for a
     * coded admission diagnosis.
     *
     * For systems that need to know which was the primary diagnosis, these will be marked with the
     * standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 =
     * primary diagnosis).
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Reason the encounter takes place, expressed as a code. For admissions, this can be used for a
     * coded admission diagnosis.
     *
     * For systems that need to know which was the primary diagnosis, these will be marked with the
     * standard extension primaryDiagnosis (which is a sequence value rather than a flag, 1 =
     * primary diagnosis).
     */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /** The list of diagnosis relevant to this encounter. */
    public var diagnosis: MutableList<Diagnosis.Builder> = mutableListOf()

    /**
     * The set of accounts that may be used for billing for this Encounter.
     *
     * The billing system may choose to allocate billable items associated with the Encounter to
     * different referenced Accounts based on internal business rules.
     */
    public var account: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Details about the admission to a healthcare service.
     *
     * An Encounter may cover more than just the inpatient stay. Contexts such as outpatients,
     * community clinics, and aged care facilities are also included.
     *
     * The duration recorded in the period of this encounter covers the entire scope of this
     * hospitalization record.
     */
    public var hospitalization: Hospitalization.Builder? = null

    /**
     * List of locations where the patient has been during this encounter.
     *
     * Virtual encounters can be recorded in the Encounter by specifying a location reference to a
     * location of type "kind" such as "client's home" and an encounter.class = "virtual".
     */
    public var location: MutableList<Location.Builder> = mutableListOf()

    /**
     * The organization that is primarily responsible for this Encounter's services. This MAY be the
     * same as the organization on the Patient record, however it could be different, such as if the
     * actor performing the services was from an external organization (which may be billed
     * seperately) for an external consultation. Refer to the example bundle showing an abbreviated
     * set of Encounters for a colonoscopy.
     */
    public var serviceProvider: Reference.Builder? = null

    /**
     * Another Encounter of which this encounter is a part of (administratively or in time).
     *
     * This is also used for associating a child's encounter back to the mother's encounter.
     *
     * Refer to the Notes section in the Patient resource for further details.
     */
    public var partOf: Reference.Builder? = null

    override fun build(): Encounter =
      Encounter(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.buildList(),
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        identifier = identifier.buildList(),
        status = status,
        statusHistory = statusHistory.buildList(),
        `class` = `class`.build(),
        classHistory = classHistory.buildList(),
        type = type.buildList(),
        serviceType = serviceType?.build(),
        priority = priority?.build(),
        subject = subject?.build(),
        episodeOfCare = episodeOfCare.buildList(),
        basedOn = basedOn.buildList(),
        participant = participant.buildList(),
        appointment = appointment.buildList(),
        period = period?.build(),
        length = length?.build(),
        reasonCode = reasonCode.buildList(),
        reasonReference = reasonReference.buildList(),
        diagnosis = diagnosis.buildList(),
        account = account.buildList(),
        hospitalization = hospitalization?.build(),
        location = location.buildList(),
        serviceProvider = serviceProvider?.build(),
        partOf = partOf?.build(),
      )
  }
}
