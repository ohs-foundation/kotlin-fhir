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

import dev.ohs.fhir.model.r5.serializers.ConditionAbatementSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionOnsetSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionParticipantSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionSerializer
import dev.ohs.fhir.model.r5.serializers.ConditionStageSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept
 * that has risen to a level of concern.
 */
@Serializable(with = ConditionSerializer::class)
@SerialName("Condition")
public data class Condition(
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
   * Business identifiers assigned to this condition by the performer or other systems which remain
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
   * The clinical status of the condition.
   *
   * The data type is CodeableConcept because clinicalStatus has some clinical judgment involved,
   * such that there might need to be more specificity than the required FHIR value set allows. For
   * example, a SNOMED coding might allow for additional specificity. clinicalStatus is required
   * since it is a modifier element. For conditions that are problems list items, the clinicalStatus
   * should not be unknown. For conditions that are not problem list items, the clinicalStatus may
   * be unknown. For example, conditions derived from a claim are point in time, so those conditions
   * may have a clinicalStatus of unknown
   */
  public val clinicalStatus: CodeableConcept,
  /**
   * The verification status to support the clinical status of the condition. The verification
   * status pertains to the condition, itself, not to any specific condition attribute.
   *
   * verificationStatus is not required. For example, when a patient has abdominal pain in the ED,
   * there is not likely going to be a verification status. The data type is CodeableConcept because
   * verificationStatus has some clinical judgment involved, such that there might need to be more
   * specificity than the required FHIR value set allows. For example, a SNOMED coding might allow
   * for additional specificity.
   */
  public val verificationStatus: CodeableConcept? = null,
  /**
   * A category assigned to the condition.
   *
   * The categorization is often highly contextual and may appear poorly differentiated or not very
   * useful in other contexts.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * A subjective assessment of the severity of the condition as evaluated by the clinician.
   *
   * Coding of the severity with a terminology is preferred, where possible.
   */
  public val severity: CodeableConcept? = null,
  /** Identification of the condition, problem or diagnosis. */
  public val code: CodeableConcept? = null,
  /**
   * The anatomical location where this condition manifests itself.
   *
   * Only used if not implicit in code found in Condition.code. If the use case requires attributes
   * from the BodyStructure resource (e.g. to identify and track separately) then use the standard
   * extension
   * [http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extensions/StructureDefinition-bodySite.html).
   * May be a summary code, or a reference to a very precise definition of the location, or both.
   */
  public val bodySite: List<CodeableConcept> = listOf(),
  /** Indicates the patient or group who the condition record is associated with. */
  public val subject: Reference,
  /**
   * The Encounter during which this Condition was created or to which the creation of this record
   * is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter. This record indicates the encounter this particular record is
   * associated with. In the case of a "new" diagnosis reflecting ongoing/revised information about
   * the condition, this might be distinct from the first encounter in which the underlying
   * condition was first "known".
   */
  public val encounter: Reference? = null,
  /**
   * Estimated or actual date or date-time the condition began, in the opinion of the clinician.
   *
   * Age is generally used when the patient reports an age at which the Condition began to occur.
   * Period is generally used to convey an imprecise onset that occurred within the time period. For
   * example, Period is not intended to convey the transition period before the chronic bronchitis
   * or COPD condition was diagnosed, but Period can be used to convey an imprecise diagnosis date.
   * Range is generally used to convey an imprecise age range (e.g. 4 to 6 years old). Because a
   * Condition.code can represent multiple levels of granularity and can be modified over time, the
   * onset and abatement dates can have ambiguity whether those dates apply to the current
   * Condition.code or an earlier representation of that Condition.code. For example, if the
   * Condition.code was initially documented as severe asthma, then it is ambiguous whether the
   * onset and abatement dates apply to asthma (overall in that subject's lifetime) or when asthma
   * transitioned to become severe.
   */
  public val onset: Onset? = null,
  /**
   * The date or estimated date that the condition resolved or went into remission. This is called
   * "abatement" because of the many overloaded connotations associated with "remission" or
   * "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they
   * can abate.
   *
   * There is no explicit distinction between resolution and remission because in many cases the
   * distinction is not clear. Age is generally used when the patient reports an age at which the
   * Condition abated. If there is no abatement element, it is unknown whether the condition has
   * resolved or entered remission; applications and users should generally assume that the
   * condition is still valid. When abatementString exists, it implies the condition is abated.
   * Because a Condition.code can represent multiple levels of granularity and can be modified over
   * time, the onset and abatement dates can have ambiguity whether those dates apply to the current
   * Condition.code or an earlier representation of that Condition.code. For example, if the
   * Condition.code was initially documented as severe asthma, then it is ambiguous whether the
   * onset and abatement dates apply to asthma (overall in that subject's lifetime) or when asthma
   * transitioned to become severe.
   */
  public val abatement: Abatement? = null,
  /**
   * The recordedDate represents when this particular Condition record was created in the system,
   * which is often a system-generated date.
   *
   * When onset date is unknown, recordedDate can be used to establish if the condition was present
   * on or before a given date. If the recordedDate is known and provided by a sending system, it is
   * preferred that the receiving system preserve that recordedDate value. If the recordedDate is
   * not provided by the sending system, the receipt timestamp is sometimes used as the
   * recordedDate.
   */
  public val recordedDate: DateTime? = null,
  /**
   * Indicates who or what participated in the activities related to the condition and how they were
   * involved.
   */
  public val participant: List<Participant> = listOf(),
  /**
   * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the
   * stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases,
   * Alzheimer's, or Parkinson disease.
   */
  public val stage: List<Stage> = listOf(),
  /**
   * Supporting evidence / manifestations that are the basis of the Condition's verification status,
   * such as evidence that confirmed or refuted the condition.
   *
   * If the condition was confirmed, but subsequently refuted, then the evidence can be cumulative
   * including all evidence over time. The evidence may be a simple list of coded
   * symptoms/manifestations, or references to observations or formal assessments, or both. For
   * example, if the Condition.code is pneumonia, then there could be an evidence list where
   * Condition.evidence.concept = fever (CodeableConcept), Condition.evidence.concept = cough
   * (CodeableConcept), and Condition.evidence.reference = bronchitis (reference to Condition).
   */
  public val evidence: List<CodeableReference> = listOf(),
  /**
   * Additional information about the Condition. This is a general notes/comments entry for
   * description of the Condition, its diagnosis and prognosis.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(clinicalStatus.toBuilder(), subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        verificationStatus = this@with.verificationStatus?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        severity = this@with.severity?.toBuilder()
        code = this@with.code?.toBuilder()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        onset = this@with.onset
        abatement = this@with.abatement
        recordedDate = this@with.recordedDate?.toBuilder()
        participant = this@with.participant.map { it.toBuilder() }.toMutableList()
        stage = this@with.stage.map { it.toBuilder() }.toMutableList()
        evidence = this@with.evidence.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Indicates who or what participated in the activities related to the condition and how they were
   * involved.
   */
  @Serializable(with = ConditionParticipantSerializer::class)
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
     * Distinguishes the type of involvement of the actor in the activities related to the
     * condition.
     */
    public val function: CodeableConcept? = null,
    /** Indicates who or what participated in the activities related to the condition. */
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
      /** Indicates who or what participated in the activities related to the condition. */
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
       * Distinguishes the type of involvement of the actor in the activities related to the
       * condition.
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

  /**
   * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the
   * stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases,
   * Alzheimer's, or Parkinson disease.
   */
  @Serializable(with = ConditionStageSerializer::class)
  public data class Stage(
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
     * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the
     * stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases,
     * Alzheimer's, or Parkinson disease.
     */
    public val summary: CodeableConcept? = null,
    /** Reference to a formal record of the evidence on which the staging assessment is based. */
    public val assessment: List<Reference> = listOf(),
    /** The kind of staging, such as pathological or clinical staging. */
    public val type: CodeableConcept? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          summary = this@with.summary?.toBuilder()
          assessment = this@with.assessment.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
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
       * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the
       * stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases,
       * Alzheimer's, or Parkinson disease.
       */
      public var summary: CodeableConcept.Builder? = null

      /** Reference to a formal record of the evidence on which the staging assessment is based. */
      public var assessment: MutableList<Reference.Builder> = mutableListOf()

      /** The kind of staging, such as pathological or clinical staging. */
      public var type: CodeableConcept.Builder? = null

      public fun build(): Stage =
        Stage(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          summary = summary?.build(),
          assessment = assessment.map { it.build() },
          type = type?.build(),
        )
    }
  }

  @Serializable(with = ConditionOnsetSerializer::class)
  public sealed interface Onset {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Onset

    public data class Age(public val `value`: dev.ohs.fhir.model.r5.Age) : Onset

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Onset

    public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Onset

    public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Onset

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        ageValue: dev.ohs.fhir.model.r5.Age?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
        rangeValue: dev.ohs.fhir.model.r5.Range?,
        stringValue: dev.ohs.fhir.model.r5.String?,
      ): Onset? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (ageValue != null) return Age(ageValue)
        if (periodValue != null) return Period(periodValue)
        if (rangeValue != null) return Range(rangeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  @Serializable(with = ConditionAbatementSerializer::class)
  public sealed interface Abatement {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Abatement

    public data class Age(public val `value`: dev.ohs.fhir.model.r5.Age) : Abatement

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Abatement

    public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Abatement

    public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Abatement

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        ageValue: dev.ohs.fhir.model.r5.Age?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
        rangeValue: dev.ohs.fhir.model.r5.Range?,
        stringValue: dev.ohs.fhir.model.r5.String?,
      ): Abatement? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (ageValue != null) return Age(ageValue)
        if (periodValue != null) return Period(periodValue)
        if (rangeValue != null) return Range(rangeValue)
        if (stringValue != null) return String(stringValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The clinical status of the condition.
     *
     * The data type is CodeableConcept because clinicalStatus has some clinical judgment involved,
     * such that there might need to be more specificity than the required FHIR value set allows.
     * For example, a SNOMED coding might allow for additional specificity. clinicalStatus is
     * required since it is a modifier element. For conditions that are problems list items, the
     * clinicalStatus should not be unknown. For conditions that are not problem list items, the
     * clinicalStatus may be unknown. For example, conditions derived from a claim are point in
     * time, so those conditions may have a clinicalStatus of unknown
     */
    public var clinicalStatus: CodeableConcept.Builder,
    /** Indicates the patient or group who the condition record is associated with. */
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
    public var id: String? = null

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
     * Business identifiers assigned to this condition by the performer or other systems which
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
     * The verification status to support the clinical status of the condition. The verification
     * status pertains to the condition, itself, not to any specific condition attribute.
     *
     * verificationStatus is not required. For example, when a patient has abdominal pain in the ED,
     * there is not likely going to be a verification status. The data type is CodeableConcept
     * because verificationStatus has some clinical judgment involved, such that there might need to
     * be more specificity than the required FHIR value set allows. For example, a SNOMED coding
     * might allow for additional specificity.
     */
    public var verificationStatus: CodeableConcept.Builder? = null

    /**
     * A category assigned to the condition.
     *
     * The categorization is often highly contextual and may appear poorly differentiated or not
     * very useful in other contexts.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A subjective assessment of the severity of the condition as evaluated by the clinician.
     *
     * Coding of the severity with a terminology is preferred, where possible.
     */
    public var severity: CodeableConcept.Builder? = null

    /** Identification of the condition, problem or diagnosis. */
    public var code: CodeableConcept.Builder? = null

    /**
     * The anatomical location where this condition manifests itself.
     *
     * Only used if not implicit in code found in Condition.code. If the use case requires
     * attributes from the BodyStructure resource (e.g. to identify and track separately) then use
     * the standard extension
     * [http://hl7.org/fhir/StructureDefinition/bodySite](http://hl7.org/fhir/extensions/StructureDefinition-bodySite.html).
     * May be a summary code, or a reference to a very precise definition of the location, or both.
     */
    public var bodySite: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The Encounter during which this Condition was created or to which the creation of this record
     * is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter. This record indicates the encounter this particular record is
     * associated with. In the case of a "new" diagnosis reflecting ongoing/revised information
     * about the condition, this might be distinct from the first encounter in which the underlying
     * condition was first "known".
     */
    public var encounter: Reference.Builder? = null

    /**
     * Estimated or actual date or date-time the condition began, in the opinion of the clinician.
     *
     * Age is generally used when the patient reports an age at which the Condition began to occur.
     * Period is generally used to convey an imprecise onset that occurred within the time period.
     * For example, Period is not intended to convey the transition period before the chronic
     * bronchitis or COPD condition was diagnosed, but Period can be used to convey an imprecise
     * diagnosis date. Range is generally used to convey an imprecise age range (e.g. 4 to 6 years
     * old). Because a Condition.code can represent multiple levels of granularity and can be
     * modified over time, the onset and abatement dates can have ambiguity whether those dates
     * apply to the current Condition.code or an earlier representation of that Condition.code. For
     * example, if the Condition.code was initially documented as severe asthma, then it is
     * ambiguous whether the onset and abatement dates apply to asthma (overall in that subject's
     * lifetime) or when asthma transitioned to become severe.
     */
    public var onset: Onset? = null

    /**
     * The date or estimated date that the condition resolved or went into remission. This is called
     * "abatement" because of the many overloaded connotations associated with "remission" or
     * "resolution" - Some conditions, such as chronic conditions, are never really resolved, but
     * they can abate.
     *
     * There is no explicit distinction between resolution and remission because in many cases the
     * distinction is not clear. Age is generally used when the patient reports an age at which the
     * Condition abated. If there is no abatement element, it is unknown whether the condition has
     * resolved or entered remission; applications and users should generally assume that the
     * condition is still valid. When abatementString exists, it implies the condition is abated.
     * Because a Condition.code can represent multiple levels of granularity and can be modified
     * over time, the onset and abatement dates can have ambiguity whether those dates apply to the
     * current Condition.code or an earlier representation of that Condition.code. For example, if
     * the Condition.code was initially documented as severe asthma, then it is ambiguous whether
     * the onset and abatement dates apply to asthma (overall in that subject's lifetime) or when
     * asthma transitioned to become severe.
     */
    public var abatement: Abatement? = null

    /**
     * The recordedDate represents when this particular Condition record was created in the system,
     * which is often a system-generated date.
     *
     * When onset date is unknown, recordedDate can be used to establish if the condition was
     * present on or before a given date. If the recordedDate is known and provided by a sending
     * system, it is preferred that the receiving system preserve that recordedDate value. If the
     * recordedDate is not provided by the sending system, the receipt timestamp is sometimes used
     * as the recordedDate.
     */
    public var recordedDate: DateTime.Builder? = null

    /**
     * Indicates who or what participated in the activities related to the condition and how they
     * were involved.
     */
    public var participant: MutableList<Participant.Builder> = mutableListOf()

    /**
     * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the
     * stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases,
     * Alzheimer's, or Parkinson disease.
     */
    public var stage: MutableList<Stage.Builder> = mutableListOf()

    /**
     * Supporting evidence / manifestations that are the basis of the Condition's verification
     * status, such as evidence that confirmed or refuted the condition.
     *
     * If the condition was confirmed, but subsequently refuted, then the evidence can be cumulative
     * including all evidence over time. The evidence may be a simple list of coded
     * symptoms/manifestations, or references to observations or formal assessments, or both. For
     * example, if the Condition.code is pneumonia, then there could be an evidence list where
     * Condition.evidence.concept = fever (CodeableConcept), Condition.evidence.concept = cough
     * (CodeableConcept), and Condition.evidence.reference = bronchitis (reference to Condition).
     */
    public var evidence: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * Additional information about the Condition. This is a general notes/comments entry for
     * description of the Condition, its diagnosis and prognosis.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): Condition =
      Condition(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        clinicalStatus = clinicalStatus.build(),
        verificationStatus = verificationStatus?.build(),
        category = category.map { it.build() },
        severity = severity?.build(),
        code = code?.build(),
        bodySite = bodySite.map { it.build() },
        subject = subject.build(),
        encounter = encounter?.build(),
        onset = onset,
        abatement = abatement,
        recordedDate = recordedDate?.build(),
        participant = participant.map { it.build() },
        stage = stage.map { it.build() },
        evidence = evidence.map { it.build() },
        note = note.map { it.build() },
      )
  }
}
