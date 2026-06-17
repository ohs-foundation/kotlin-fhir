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

import dev.ohs.fhir.model.r4b.serializers.ConditionEvidenceSerializer
import dev.ohs.fhir.model.r4b.serializers.ConditionSerializer
import dev.ohs.fhir.model.r4b.serializers.ConditionStageSerializer
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
   * example, a SNOMED coding might allow for additional specificity.
   */
  public val clinicalStatus: CodeableConcept? = null,
  /**
   * The verification status to support the clinical status of the condition.
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
   * from the BodySite resource (e.g. to identify and track separately) then use the standard
   * extension [bodySite](extension-bodysite.html). May be a summary code, or a reference to a very
   * precise definition of the location, or both.
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
   */
  public val onset: Onset? = null,
  /**
   * The date or estimated date that the condition resolved or went into remission. This is called
   * "abatement" because of the many overloaded connotations associated with "remission" or
   * "resolution" - Conditions are never really resolved, but they can abate.
   *
   * There is no explicit distinction between resolution and remission because in many cases the
   * distinction is not clear. Age is generally used when the patient reports an age at which the
   * Condition abated. If there is no abatement element, it is unknown whether the condition has
   * resolved or entered remission; applications and users should generally assume that the
   * condition is still valid. When abatementString exists, it implies the condition is abated.
   */
  public val abatement: Abatement? = null,
  /**
   * The recordedDate represents when this particular Condition record was created in the system,
   * which is often a system-generated date.
   */
  public val recordedDate: DateTime? = null,
  /** Individual who recorded the record and takes responsibility for its content. */
  public val recorder: Reference? = null,
  /** Individual who is making the condition statement. */
  public val asserter: Reference? = null,
  /** Clinical stage or grade of a condition. May include formal severity assessments. */
  public val stage: List<Stage> = listOf(),
  /**
   * Supporting evidence / manifestations that are the basis of the Condition's verification status,
   * such as evidence that confirmed or refuted the condition.
   *
   * The evidence may be a simple list of coded symptoms/manifestations, or references to
   * observations or formal assessments, or both.
   */
  public val evidence: List<Evidence> = listOf(),
  /**
   * Additional information about the Condition. This is a general notes/comments entry for
   * description of the Condition, its diagnosis and prognosis.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        clinicalStatus = this@with.clinicalStatus?.toBuilder()
        verificationStatus = this@with.verificationStatus?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        severity = this@with.severity?.toBuilder()
        code = this@with.code?.toBuilder()
        bodySite = this@with.bodySite.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        onset = this@with.onset
        abatement = this@with.abatement
        recordedDate = this@with.recordedDate?.toBuilder()
        recorder = this@with.recorder?.toBuilder()
        asserter = this@with.asserter?.toBuilder()
        stage = this@with.stage.map { it.toBuilder() }.toMutableList()
        evidence = this@with.evidence.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Clinical stage or grade of a condition. May include formal severity assessments. */
  @Serializable(with = ConditionStageSerializer::class)
  public data class Stage(
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
     * A simple summary of the stage such as "Stage 3". The determination of the stage is
     * disease-specific.
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
       * A simple summary of the stage such as "Stage 3". The determination of the stage is
       * disease-specific.
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

  /**
   * Supporting evidence / manifestations that are the basis of the Condition's verification status,
   * such as evidence that confirmed or refuted the condition.
   */
  @Serializable(with = ConditionEvidenceSerializer::class)
  public data class Evidence(
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
    /** A manifestation or symptom that led to the recording of this condition. */
    public val code: List<CodeableConcept> = listOf(),
    /** Links to other relevant information, including pathology reports. */
    public val detail: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          code = this@with.code.map { it.toBuilder() }.toMutableList()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
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

      /** A manifestation or symptom that led to the recording of this condition. */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Links to other relevant information, including pathology reports. */
      public var detail: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Evidence =
        Evidence(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.map { it.build() },
          detail = detail.map { it.build() },
        )
    }
  }

  public sealed interface Onset {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) : Onset

    public data class Age(public val `value`: dev.ohs.fhir.model.r4b.Age) : Onset

    public data class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Onset

    public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Onset

    public data class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Onset

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
        ageValue: dev.ohs.fhir.model.r4b.Age?,
        periodValue: dev.ohs.fhir.model.r4b.Period?,
        rangeValue: dev.ohs.fhir.model.r4b.Range?,
        stringValue: dev.ohs.fhir.model.r4b.String?,
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

  public sealed interface Abatement {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asAge(): Age? = this as? Age

    public fun asPeriod(): Period? = this as? Period

    public fun asRange(): Range? = this as? Range

    public fun asString(): String? = this as? String

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4b.DateTime) : Abatement

    public data class Age(public val `value`: dev.ohs.fhir.model.r4b.Age) : Abatement

    public data class Period(public val `value`: dev.ohs.fhir.model.r4b.Period) : Abatement

    public data class Range(public val `value`: dev.ohs.fhir.model.r4b.Range) : Abatement

    public data class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Abatement

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4b.DateTime?,
        ageValue: dev.ohs.fhir.model.r4b.Age?,
        periodValue: dev.ohs.fhir.model.r4b.Period?,
        rangeValue: dev.ohs.fhir.model.r4b.Range?,
        stringValue: dev.ohs.fhir.model.r4b.String?,
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
    /** Indicates the patient or group who the condition record is associated with. */
    public var subject: Reference.Builder
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * The clinical status of the condition.
     *
     * The data type is CodeableConcept because clinicalStatus has some clinical judgment involved,
     * such that there might need to be more specificity than the required FHIR value set allows.
     * For example, a SNOMED coding might allow for additional specificity.
     */
    public var clinicalStatus: CodeableConcept.Builder? = null

    /**
     * The verification status to support the clinical status of the condition.
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
     * attributes from the BodySite resource (e.g. to identify and track separately) then use the
     * standard extension [bodySite](extension-bodysite.html). May be a summary code, or a reference
     * to a very precise definition of the location, or both.
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
     */
    public var onset: Onset? = null

    /**
     * The date or estimated date that the condition resolved or went into remission. This is called
     * "abatement" because of the many overloaded connotations associated with "remission" or
     * "resolution" - Conditions are never really resolved, but they can abate.
     *
     * There is no explicit distinction between resolution and remission because in many cases the
     * distinction is not clear. Age is generally used when the patient reports an age at which the
     * Condition abated. If there is no abatement element, it is unknown whether the condition has
     * resolved or entered remission; applications and users should generally assume that the
     * condition is still valid. When abatementString exists, it implies the condition is abated.
     */
    public var abatement: Abatement? = null

    /**
     * The recordedDate represents when this particular Condition record was created in the system,
     * which is often a system-generated date.
     */
    public var recordedDate: DateTime.Builder? = null

    /** Individual who recorded the record and takes responsibility for its content. */
    public var recorder: Reference.Builder? = null

    /** Individual who is making the condition statement. */
    public var asserter: Reference.Builder? = null

    /** Clinical stage or grade of a condition. May include formal severity assessments. */
    public var stage: MutableList<Stage.Builder> = mutableListOf()

    /**
     * Supporting evidence / manifestations that are the basis of the Condition's verification
     * status, such as evidence that confirmed or refuted the condition.
     *
     * The evidence may be a simple list of coded symptoms/manifestations, or references to
     * observations or formal assessments, or both.
     */
    public var evidence: MutableList<Evidence.Builder> = mutableListOf()

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
        clinicalStatus = clinicalStatus?.build(),
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
        recorder = recorder?.build(),
        asserter = asserter?.build(),
        stage = stage.map { it.build() },
        evidence = evidence.map { it.build() },
        note = note.map { it.build() },
      )
  }
}
