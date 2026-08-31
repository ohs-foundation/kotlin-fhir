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

import dev.ohs.fhir.model.r5.serializers.AdverseEventContributingFactorSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventMitigatingActionSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventPreventiveActionSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventSupportingInfoSerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventSuspectEntityCausalitySerializer
import dev.ohs.fhir.model.r5.serializers.AdverseEventSuspectEntitySerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An event (i.e. any change to current patient status) that may be related to unintended effects on
 * a patient or research participant. The unintended effects may require additional monitoring,
 * treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to
 * potential or avoided events that could have had such effects. There are two major domains where
 * the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events
 * and the other is in reporting adverse events in clinical research trial management. Adverse
 * events can be reported by healthcare providers, patients, caregivers or by medical products
 * manufacturers. Given the differences between these two concepts, we recommend consulting the
 * domain specific implementation guides when implementing the AdverseEvent Resource. The
 * implementation guides include specific extensions, value sets and constraints.
 */
@Serializable(with = AdverseEventSerializer::class)
@SerialName("AdverseEvent")
public data class AdverseEvent(
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
  /**
   * Business identifiers assigned to this adverse event by the performer or other systems which
   * remain constant as the resource is updated and propagates from server to server.
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
   * The current state of the adverse event or potential adverse event.
   *
   * This is not the reporting of the event to any regulatory or quality organization. This is not
   * the outcome of the patient's condition.
   */
  public val status: Enumeration<AdverseEventStatus>,
  /**
   * Whether the event actually happened or was a near miss. Note that this is independent of
   * whether anyone was affected or harmed or how severely.
   *
   * AllergyIntolerance should be used for the initial capture or recording of the individual's
   * propensity to an adverse reaction to a substance. If an AllergyIntolerance does not exist, then
   * an adverse reaction should be recorded as an AllergyIntolerance. If an AllergyIntolerance does
   * exist and the substance was given, then an adverse reaction should be recorded as an
   * AdverseEvent due to the aberrant workflow.
   */
  public val actuality: Enumeration<AdverseEventActuality>,
  /** The overall type of event, intended for search and filtering purposes. */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or
   * wrong blood transfused.
   */
  public val code: CodeableConcept? = null,
  /**
   * This subject or group impacted by the event.
   *
   * If AdverseEvent.resultingEffect differs among members of the group, then use Patient as the
   * subject.
   */
  public val subject: Reference,
  /**
   * The Encounter associated with the start of the AdverseEvent.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter. For example, if a medication administration was considered an adverse
   * event because it resulted in a rash, then the encounter when the medication administration was
   * given is the associated encounter. If the patient reports the AdverseEvent during a second
   * encounter, that second encounter is not the associated encounter.
   */
  public val encounter: Reference? = null,
  /** The date (and perhaps time) when the adverse event occurred. */
  public val occurrence: Occurrence? = null,
  /** Estimated or actual date the AdverseEvent began, in the opinion of the reporter. */
  public val detected: DateTime? = null,
  /**
   * The date on which the existence of the AdverseEvent was first recorded.
   *
   * The recordedDate represents the date when this particular AdverseEvent record was created in
   * the system, not the date of the most recent update. The date of the last record modification
   * can be retrieved from the resource metadata.
   */
  public val recordedDate: DateTime? = null,
  /**
   * Information about the condition that occurred as a result of the adverse event, such as hives
   * due to the exposure to a substance (for example, a drug or a chemical) or a broken leg as a
   * result of the fall.
   */
  public val resultingEffect: List<Reference> = listOf(),
  /** The information about where the adverse event occurred. */
  public val location: Reference? = null,
  /**
   * Assessment whether this event, or averted event, was of clinical importance.
   *
   * Using an example, a rash can have an AdverseEvent.resultingEffect.severity = severe, yet an
   * AdverseEvent.seriousness = non-serious. Alternatively, a medication given with the wrong dose
   * (chemotherapy given with too low of a dose) can have an AdverseEvent.resultingEffect.severity =
   * mild, yet an adverseEvent.seriousness = serious. Another example would be a beta blocker
   * clinical trial where patients with asthma should be excluded, yet a patient with asthma was
   * included and had an asthmatic episode where AdverseEvent.resultingEffect.severity = mild, yet
   * an adverseEvent.seriousness = serious.
   */
  public val seriousness: CodeableConcept? = null,
  /**
   * Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing,
   * resolved-with-sequelae, or fatal.
   */
  public val outcome: List<CodeableConcept> = listOf(),
  /** Information on who recorded the adverse event. May be the patient or a practitioner. */
  public val recorder: Reference? = null,
  /** Indicates who or what participated in the adverse event and how they were involved. */
  public val participant: List<Participant> = listOf(),
  /** The research study that the subject is enrolled in. */
  public val study: List<Reference> = listOf(),
  /**
   * Considered likely or probable or anticipated in the research study. Whether the reported event
   * matches any of the outcomes for the patient that are considered by the study as known or
   * likely.
   */
  public val expectedInResearchStudy: Boolean? = null,
  /** Describes the entity that is suspected to have caused the adverse event. */
  public val suspectEntity: List<SuspectEntity> = listOf(),
  /**
   * The contributing factors suspected to have increased the probability or severity of the adverse
   * event.
   */
  public val contributingFactor: List<ContributingFactor> = listOf(),
  /** Preventive actions that contributed to avoiding the adverse event. */
  public val preventiveAction: List<PreventiveAction> = listOf(),
  /**
   * The ameliorating action taken after the adverse event occured in order to reduce the extent of
   * harm.
   */
  public val mitigatingAction: List<MitigatingAction> = listOf(),
  /** Supporting information relevant to the event. */
  public val supportingInfo: List<SupportingInfo> = listOf(),
  /** Comments made about the adverse event by the performer, subject or other participants. */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          actuality,
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
          category = this@with.category.map { it.toBuilder() }.toMutableList()
          code = this@with.code?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          occurrence = this@with.occurrence
          detected = this@with.detected?.toBuilder()
          recordedDate = this@with.recordedDate?.toBuilder()
          resultingEffect = this@with.resultingEffect.map { it.toBuilder() }.toMutableList()
          location = this@with.location?.toBuilder()
          seriousness = this@with.seriousness?.toBuilder()
          outcome = this@with.outcome.map { it.toBuilder() }.toMutableList()
          recorder = this@with.recorder?.toBuilder()
          participant = this@with.participant.map { it.toBuilder() }.toMutableList()
          study = this@with.study.map { it.toBuilder() }.toMutableList()
          expectedInResearchStudy = this@with.expectedInResearchStudy?.toBuilder()
          suspectEntity = this@with.suspectEntity.map { it.toBuilder() }.toMutableList()
          contributingFactor = this@with.contributingFactor.map { it.toBuilder() }.toMutableList()
          preventiveAction = this@with.preventiveAction.map { it.toBuilder() }.toMutableList()
          mitigatingAction = this@with.mitigatingAction.map { it.toBuilder() }.toMutableList()
          supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
    }

  /** Indicates who or what participated in the adverse event and how they were involved. */
  @Serializable(with = AdverseEventParticipantSerializer::class)
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
     * Distinguishes the type of involvement of the actor in the adverse event, such as contributor
     * or informant.
     */
    public val function: CodeableConcept? = null,
    /**
     * Indicates who or what participated in the event.
     *
     * For example, the physician prescribing a drug, a nurse administering the drug, a device that
     * administered the drug, a witness to the event, or an informant of clinical history.
     */
    public val actor: Reference,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(actor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          function = this@with.function?.toBuilder()
        }
      }

    public class Builder(
      /**
       * Indicates who or what participated in the event.
       *
       * For example, the physician prescribing a drug, a nurse administering the drug, a device
       * that administered the drug, a witness to the event, or an informant of clinical history.
       */
      public var actor: Reference.Builder
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
       * Distinguishes the type of involvement of the actor in the adverse event, such as
       * contributor or informant.
       */
      public var function: CodeableConcept.Builder? = null

      public fun build(): Participant =
        Participant(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          function = function?.build(),
          actor = actor.build(),
        )
    }
  }

  /** Describes the entity that is suspected to have caused the adverse event. */
  @Serializable(with = AdverseEventSuspectEntitySerializer::class)
  public data class SuspectEntity(
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
     * Identifies the actual instance of what caused the adverse event. May be a substance,
     * medication, medication administration, medication statement or a device.
     */
    public val instance: Instance,
    /** Information on the possible cause of the event. */
    public val causality: Causality? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(instance).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          causality = this@with.causality?.toBuilder()
        }
      }

    /** Information on the possible cause of the event. */
    @Serializable(with = AdverseEventSuspectEntityCausalitySerializer::class)
    public data class Causality(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: String? = null,
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
      /** The method of evaluating the relatedness of the suspected entity to the event. */
      public val assessmentMethod: CodeableConcept? = null,
      /**
       * The result of the assessment regarding the relatedness of the suspected entity to the
       * event.
       */
      public val entityRelatedness: CodeableConcept? = null,
      /** The author of the information on the possible cause of the event. */
      public val author: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            assessmentMethod = this@with.assessmentMethod?.toBuilder()
            entityRelatedness = this@with.entityRelatedness?.toBuilder()
            author = this@with.author?.toBuilder()
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

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

        /** The method of evaluating the relatedness of the suspected entity to the event. */
        public var assessmentMethod: CodeableConcept.Builder? = null

        /**
         * The result of the assessment regarding the relatedness of the suspected entity to the
         * event.
         */
        public var entityRelatedness: CodeableConcept.Builder? = null

        /** The author of the information on the possible cause of the event. */
        public var author: Reference.Builder? = null

        public fun build(): Causality =
          Causality(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            assessmentMethod = assessmentMethod?.build(),
            entityRelatedness = entityRelatedness?.build(),
            author = author?.build(),
          )
      }
    }

    public sealed interface Instance {
      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asReference(): Reference? = this as? Reference

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Instance

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Instance

      public companion object {
        internal fun from(
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
        ): Instance? {
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * Identifies the actual instance of what caused the adverse event. May be a substance,
       * medication, medication administration, medication statement or a device.
       */
      public var instance: Instance
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

      /** Information on the possible cause of the event. */
      public var causality: Causality.Builder? = null

      public fun build(): SuspectEntity =
        SuspectEntity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          instance = instance,
          causality = causality?.build(),
        )
    }
  }

  /**
   * The contributing factors suspected to have increased the probability or severity of the adverse
   * event.
   */
  @Serializable(with = AdverseEventContributingFactorSerializer::class)
  public data class ContributingFactor(
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
     * The item that is suspected to have increased the probability or severity of the adverse
     * event.
     */
    public val item: Item,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Item {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Item

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Item

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Item? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The item that is suspected to have increased the probability or severity of the adverse
       * event.
       */
      public var item: Item
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

      public fun build(): ContributingFactor =
        ContributingFactor(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          item = item,
        )
    }
  }

  /** Preventive actions that contributed to avoiding the adverse event. */
  @Serializable(with = AdverseEventPreventiveActionSerializer::class)
  public data class PreventiveAction(
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
    /** The action that contributed to avoiding the adverse event. */
    public val item: Item,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Item {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Item

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Item

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Item? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /** The action that contributed to avoiding the adverse event. */
      public var item: Item
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

      public fun build(): PreventiveAction =
        PreventiveAction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          item = item,
        )
    }
  }

  /**
   * The ameliorating action taken after the adverse event occured in order to reduce the extent of
   * harm.
   */
  @Serializable(with = AdverseEventMitigatingActionSerializer::class)
  public data class MitigatingAction(
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
     * The ameliorating action taken after the adverse event occured in order to reduce the extent
     * of harm.
     */
    public val item: Item,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Item {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Item

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Item

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Item? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The ameliorating action taken after the adverse event occured in order to reduce the extent
       * of harm.
       */
      public var item: Item
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

      public fun build(): MitigatingAction =
        MitigatingAction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          item = item,
        )
    }
  }

  /** Supporting information relevant to the event. */
  @Serializable(with = AdverseEventSupportingInfoSerializer::class)
  public data class SupportingInfo(
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
     * Relevant past history for the subject. In a clinical care context, an example being a patient
     * had an adverse event following a pencillin administration and the patient had a previously
     * documented penicillin allergy. In a clinical trials context, an example is a bunion or rash
     * that was present prior to the study. Additionally, the supporting item can be a document that
     * is relevant to this instance of the adverse event that is not part of the subject's medical
     * history. For example, a clinical note, staff list, or material safety data sheet (MSDS).
     * Supporting information is not a contributing factor, preventive action, or mitigating action.
     */
    public val item: Item,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(item).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Item {
      public fun asReference(): Reference? = this as? Reference

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Item

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        Item

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
        ): Item? {
          if (referenceValue != null) return Reference(referenceValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * Relevant past history for the subject. In a clinical care context, an example being a
       * patient had an adverse event following a pencillin administration and the patient had a
       * previously documented penicillin allergy. In a clinical trials context, an example is a
       * bunion or rash that was present prior to the study. Additionally, the supporting item can
       * be a document that is relevant to this instance of the adverse event that is not part of
       * the subject's medical history. For example, a clinical note, staff list, or material safety
       * data sheet (MSDS). Supporting information is not a contributing factor, preventive action,
       * or mitigating action.
       */
      public var item: Item
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

      public fun build(): SupportingInfo =
        SupportingInfo(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          item = item,
        )
    }
  }

  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public fun asTiming(): Timing? = this as? Timing

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Occurrence

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Occurrence

    public data class Timing(public val `value`: dev.ohs.fhir.model.r5.Timing) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
        timingValue: dev.ohs.fhir.model.r5.Timing?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        if (timingValue != null) return Timing(timingValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The current state of the adverse event or potential adverse event.
     *
     * This is not the reporting of the event to any regulatory or quality organization. This is not
     * the outcome of the patient's condition.
     */
    public var status: Enumeration<AdverseEventStatus>,
    /**
     * Whether the event actually happened or was a near miss. Note that this is independent of
     * whether anyone was affected or harmed or how severely.
     *
     * AllergyIntolerance should be used for the initial capture or recording of the individual's
     * propensity to an adverse reaction to a substance. If an AllergyIntolerance does not exist,
     * then an adverse reaction should be recorded as an AllergyIntolerance. If an
     * AllergyIntolerance does exist and the substance was given, then an adverse reaction should be
     * recorded as an AdverseEvent due to the aberrant workflow.
     */
    public var actuality: Enumeration<AdverseEventActuality>,
    /**
     * This subject or group impacted by the event.
     *
     * If AdverseEvent.resultingEffect differs among members of the group, then use Patient as the
     * subject.
     */
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

    /**
     * Business identifiers assigned to this adverse event by the performer or other systems which
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

    /** The overall type of event, intended for search and filtering purposes. */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Specific event that occurred or that was averted, such as patient fall, wrong organ removed,
     * or wrong blood transfused.
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * The Encounter associated with the start of the AdverseEvent.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter. For example, if a medication administration was considered an
     * adverse event because it resulted in a rash, then the encounter when the medication
     * administration was given is the associated encounter. If the patient reports the AdverseEvent
     * during a second encounter, that second encounter is not the associated encounter.
     */
    public var encounter: Reference.Builder? = null

    /** The date (and perhaps time) when the adverse event occurred. */
    public var occurrence: Occurrence? = null

    /** Estimated or actual date the AdverseEvent began, in the opinion of the reporter. */
    public var detected: DateTime.Builder? = null

    /**
     * The date on which the existence of the AdverseEvent was first recorded.
     *
     * The recordedDate represents the date when this particular AdverseEvent record was created in
     * the system, not the date of the most recent update. The date of the last record modification
     * can be retrieved from the resource metadata.
     */
    public var recordedDate: DateTime.Builder? = null

    /**
     * Information about the condition that occurred as a result of the adverse event, such as hives
     * due to the exposure to a substance (for example, a drug or a chemical) or a broken leg as a
     * result of the fall.
     */
    public var resultingEffect: MutableList<Reference.Builder> = mutableListOf()

    /** The information about where the adverse event occurred. */
    public var location: Reference.Builder? = null

    /**
     * Assessment whether this event, or averted event, was of clinical importance.
     *
     * Using an example, a rash can have an AdverseEvent.resultingEffect.severity = severe, yet an
     * AdverseEvent.seriousness = non-serious. Alternatively, a medication given with the wrong dose
     * (chemotherapy given with too low of a dose) can have an AdverseEvent.resultingEffect.severity
     * = mild, yet an adverseEvent.seriousness = serious. Another example would be a beta blocker
     * clinical trial where patients with asthma should be excluded, yet a patient with asthma was
     * included and had an asthmatic episode where AdverseEvent.resultingEffect.severity = mild, yet
     * an adverseEvent.seriousness = serious.
     */
    public var seriousness: CodeableConcept.Builder? = null

    /**
     * Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing,
     * resolved-with-sequelae, or fatal.
     */
    public var outcome: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Information on who recorded the adverse event. May be the patient or a practitioner. */
    public var recorder: Reference.Builder? = null

    /** Indicates who or what participated in the adverse event and how they were involved. */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /** The research study that the subject is enrolled in. */
    public var study: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Considered likely or probable or anticipated in the research study. Whether the reported
     * event matches any of the outcomes for the patient that are considered by the study as known
     * or likely.
     */
    public var expectedInResearchStudy: Boolean.Builder? = null

    /** Describes the entity that is suspected to have caused the adverse event. */
    public var suspectEntity: MutableList<SuspectEntity.Builder> = mutableListOf()

    /**
     * The contributing factors suspected to have increased the probability or severity of the
     * adverse event.
     */
    public var contributingFactor: MutableList<ContributingFactor.Builder> = mutableListOf()

    /** Preventive actions that contributed to avoiding the adverse event. */
    public var preventiveAction: MutableList<PreventiveAction.Builder> = mutableListOf()

    /**
     * The ameliorating action taken after the adverse event occured in order to reduce the extent
     * of harm.
     */
    public var mitigatingAction: MutableList<MitigatingAction.Builder> = mutableListOf()

    /** Supporting information relevant to the event. */
    public var supportingInfo: MutableList<SupportingInfo.Builder> = mutableListOf()

    /** Comments made about the adverse event by the performer, subject or other participants. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): AdverseEvent =
      AdverseEvent(
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
        actuality = actuality,
        category = category.map { it.build() },
        code = code?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        occurrence = occurrence,
        detected = detected?.build(),
        recordedDate = recordedDate?.build(),
        resultingEffect = resultingEffect.map { it.build() },
        location = location?.build(),
        seriousness = seriousness?.build(),
        outcome = outcome.map { it.build() },
        recorder = recorder?.build(),
        participant = participant.map { it.build() },
        study = study.map { it.build() },
        expectedInResearchStudy = expectedInResearchStudy?.build(),
        suspectEntity = suspectEntity.map { it.build() },
        contributingFactor = contributingFactor.map { it.build() },
        preventiveAction = preventiveAction.map { it.build() },
        mitigatingAction = mitigatingAction.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of an adverse event. */
  public enum class AdverseEventStatus(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    In_Progress("in-progress", "http://hl7.org/fhir/event-status", "In Progress"),
    Completed("completed", "http://hl7.org/fhir/event-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/event-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/event-status", "Unknown");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): AdverseEventStatus =
        when (code) {
          "in-progress" -> In_Progress
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum AdverseEventStatus")
        }
    }
  }

  /** Overall nature of the adverse event, e.g. real or potential. */
  public enum class AdverseEventActuality(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    Actual("actual", "http://hl7.org/fhir/adverse-event-actuality", "Adverse Event"),
    Potential(
      "potential",
      "http://hl7.org/fhir/adverse-event-actuality",
      "Potential Adverse Event",
    );

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): AdverseEventActuality =
        when (code) {
          "actual" -> Actual
          "potential" -> Potential
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AdverseEventActuality")
        }
    }
  }
}
