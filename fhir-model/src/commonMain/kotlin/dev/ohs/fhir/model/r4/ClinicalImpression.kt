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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionEffectiveSerializer
import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionFindingSerializer
import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionInvestigationSerializer
import dev.ohs.fhir.model.r4.serializers.ClinicalImpressionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of a clinical assessment performed to determine what problem(s) may affect the patient
 * and before planning the treatments or management strategies that are best to manage a patient's
 * condition. Assessments are often 1:1 with a clinical consultation / encounter, but this varies
 * greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather
 * than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar
 * score.
 */
@Serializable(with = ClinicalImpressionSerializer::class)
@SerialName("ClinicalImpression")
public data class ClinicalImpression(
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
   * Business identifiers assigned to this clinical impression by the performer or other systems
   * which remain constant as the resource is updated and propagates from server to server.
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
   * Identifies the workflow status of the assessment.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that marks the clinical impression as not currently valid.
   */
  public val status: Enumeration<ClinicalImpressionStatus>,
  /**
   * Captures the reason for the current state of the ClinicalImpression.
   *
   * This is generally only used for "exception" statuses such as "not-done", "suspended" or
   * "cancelled".
   *
   * [distinct reason codes for different statuses can be enforced using invariants if they are
   * universal bindings].
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * Categorizes the type of clinical assessment performed.
   *
   * This is present as a place-holder only and may be removed based on feedback/work group opinion.
   */
  public val code: CodeableConcept? = null,
  /**
   * A summary of the context and/or cause of the assessment - why / where it was performed, and
   * what patient events/status prompted it.
   */
  public val description: String? = null,
  /** The patient or group of individuals assessed as part of this record. */
  public val subject: Reference,
  /**
   * The Encounter during which this ClinicalImpression was created or to which the creation of this
   * record is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: Reference? = null,
  /**
   * The point in time or period over which the subject was assessed.
   *
   * This SHOULD be accurate to at least the minute, though some assessments only have a known date.
   */
  public val effective: Effective? = null,
  /** Indicates when the documentation of the assessment was complete. */
  public val date: DateTime? = null,
  /** The clinician performing the assessment. */
  public val assessor: Reference? = null,
  /**
   * A reference to the last assessment that was conducted on this patient. Assessments are
   * often/usually ongoing in nature; a care provider (practitioner or team) will make new
   * assessments on an ongoing basis as new data arises or the patient's conditions changes.
   *
   * It is always likely that multiple previous assessments exist for a patient. The point of
   * quoting a previous assessment is that this assessment is relative to it (see resolved).
   */
  public val previous: Reference? = null,
  /**
   * A list of the relevant problems/conditions for a patient.
   *
   * e.g. The patient is a pregnant, has congestive heart failure, has an ‎Adenocarcinoma, and is
   * allergic to penicillin.
   */
  public val problem: List<Reference> = listOf(),
  /**
   * One or more sets of investigations (signs, symptoms, etc.). The actual grouping of
   * investigations varies greatly depending on the type and context of the assessment. These
   * investigations may include data generated during the assessment process, or data previously
   * generated and recorded that is pertinent to the outcomes.
   */
  public val investigation: List<Investigation> = listOf(),
  /**
   * Reference to a specific published clinical protocol that was followed during this assessment,
   * and/or that provides evidence in support of the diagnosis.
   */
  public val protocol: List<Uri> = listOf(),
  /** A text summary of the investigations and the diagnosis. */
  public val summary: String? = null,
  /**
   * Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.
   */
  public val finding: List<Finding> = listOf(),
  /** Estimate of likely outcome. */
  public val prognosisCodeableConcept: List<CodeableConcept> = listOf(),
  /** RiskAssessment expressing likely outcome. */
  public val prognosisReference: List<Reference> = listOf(),
  /** Information supporting the clinical impression. */
  public val supportingInfo: List<Reference> = listOf(),
  /**
   * Commentary about the impression, typically recorded after the impression itself was made,
   * though supplemental notes by the original author could also appear.
   *
   * Don't use this element for content that should more properly appear as one of the specific
   * elements of the impression.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, subject.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        statusReason = this@with.statusReason?.toBuilder()
        code = this@with.code?.toBuilder()
        description = this@with.description?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        effective = this@with.effective
        date = this@with.date?.toBuilder()
        assessor = this@with.assessor?.toBuilder()
        previous = this@with.previous?.toBuilder()
        problem = this@with.problem.map { it.toBuilder() }.toMutableList()
        investigation = this@with.investigation.map { it.toBuilder() }.toMutableList()
        protocol = this@with.protocol.map { it.toBuilder() }.toMutableList()
        summary = this@with.summary?.toBuilder()
        finding = this@with.finding.map { it.toBuilder() }.toMutableList()
        prognosisCodeableConcept =
          this@with.prognosisCodeableConcept.map { it.toBuilder() }.toMutableList()
        prognosisReference = this@with.prognosisReference.map { it.toBuilder() }.toMutableList()
        supportingInfo = this@with.supportingInfo.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * One or more sets of investigations (signs, symptoms, etc.). The actual grouping of
   * investigations varies greatly depending on the type and context of the assessment. These
   * investigations may include data generated during the assessment process, or data previously
   * generated and recorded that is pertinent to the outcomes.
   */
  @Serializable(with = ClinicalImpressionInvestigationSerializer::class)
  public data class Investigation(
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
     * A name/code for the group ("set") of investigations. Typically, this will be something like
     * "signs", "symptoms", "clinical", "diagnostic", but the list is not constrained, and others
     * such groups such as (exposure|family|travel|nutritional) history may be used.
     */
    public val code: CodeableConcept,
    /**
     * A record of a specific investigation that was undertaken.
     *
     * Most investigations are observations of one kind or another but some other specific types of
     * data collection resources can also be used.
     */
    public val item: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          item = this@with.item.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * A name/code for the group ("set") of investigations. Typically, this will be something like
       * "signs", "symptoms", "clinical", "diagnostic", but the list is not constrained, and others
       * such groups such as (exposure|family|travel|nutritional) history may be used.
       */
      public var code: CodeableConcept.Builder
    ) {
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
       * A record of a specific investigation that was undertaken.
       *
       * Most investigations are observations of one kind or another but some other specific types
       * of data collection resources can also be used.
       */
      public var item: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Investigation =
        Investigation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.build(),
          item = item.map { it.build() },
        )
    }
  }

  /**
   * Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.
   */
  @Serializable(with = ClinicalImpressionFindingSerializer::class)
  public data class Finding(
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
     * Specific text or code for finding or diagnosis, which may include ruled-out or resolved
     * conditions.
     */
    public val itemCodeableConcept: CodeableConcept? = null,
    /**
     * Specific reference for finding or diagnosis, which may include ruled-out or resolved
     * conditions.
     */
    public val itemReference: Reference? = null,
    /** Which investigations support finding or diagnosis. */
    public val basis: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          itemCodeableConcept = this@with.itemCodeableConcept?.toBuilder()
          itemReference = this@with.itemReference?.toBuilder()
          basis = this@with.basis?.toBuilder()
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
       * Specific text or code for finding or diagnosis, which may include ruled-out or resolved
       * conditions.
       */
      public var itemCodeableConcept: CodeableConcept.Builder? = null

      /**
       * Specific reference for finding or diagnosis, which may include ruled-out or resolved
       * conditions.
       */
      public var itemReference: Reference.Builder? = null

      /** Which investigations support finding or diagnosis. */
      public var basis: String.Builder? = null

      public fun build(): Finding =
        Finding(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          itemCodeableConcept = itemCodeableConcept?.build(),
          itemReference = itemReference?.build(),
          basis = basis?.build(),
        )
    }
  }

  @Serializable(with = ClinicalImpressionEffectiveSerializer::class)
  public sealed interface Effective {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Effective

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Effective

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
      ): Effective? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Identifies the workflow status of the assessment.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that marks the clinical impression as not currently valid.
     */
    public var status: Enumeration<ClinicalImpressionStatus>,
    /** The patient or group of individuals assessed as part of this record. */
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
     * Business identifiers assigned to this clinical impression by the performer or other systems
     * which remain constant as the resource is updated and propagates from server to server.
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
     * Captures the reason for the current state of the ClinicalImpression.
     *
     * This is generally only used for "exception" statuses such as "not-done", "suspended" or
     * "cancelled".
     *
     * [distinct reason codes for different statuses can be enforced using invariants if they are
     * universal bindings].
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * Categorizes the type of clinical assessment performed.
     *
     * This is present as a place-holder only and may be removed based on feedback/work group
     * opinion.
     */
    public var code: CodeableConcept.Builder? = null

    /**
     * A summary of the context and/or cause of the assessment - why / where it was performed, and
     * what patient events/status prompted it.
     */
    public var description: String.Builder? = null

    /**
     * The Encounter during which this ClinicalImpression was created or to which the creation of
     * this record is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: Reference.Builder? = null

    /**
     * The point in time or period over which the subject was assessed.
     *
     * This SHOULD be accurate to at least the minute, though some assessments only have a known
     * date.
     */
    public var effective: Effective? = null

    /** Indicates when the documentation of the assessment was complete. */
    public var date: DateTime.Builder? = null

    /** The clinician performing the assessment. */
    public var assessor: Reference.Builder? = null

    /**
     * A reference to the last assessment that was conducted on this patient. Assessments are
     * often/usually ongoing in nature; a care provider (practitioner or team) will make new
     * assessments on an ongoing basis as new data arises or the patient's conditions changes.
     *
     * It is always likely that multiple previous assessments exist for a patient. The point of
     * quoting a previous assessment is that this assessment is relative to it (see resolved).
     */
    public var previous: Reference.Builder? = null

    /**
     * A list of the relevant problems/conditions for a patient.
     *
     * e.g. The patient is a pregnant, has congestive heart failure, has an ‎Adenocarcinoma, and is
     * allergic to penicillin.
     */
    public var problem: MutableList<Reference.Builder> = mutableListOf()

    /**
     * One or more sets of investigations (signs, symptoms, etc.). The actual grouping of
     * investigations varies greatly depending on the type and context of the assessment. These
     * investigations may include data generated during the assessment process, or data previously
     * generated and recorded that is pertinent to the outcomes.
     */
    public var investigation: MutableList<Investigation.Builder> = mutableListOf()

    /**
     * Reference to a specific published clinical protocol that was followed during this assessment,
     * and/or that provides evidence in support of the diagnosis.
     */
    public var protocol: MutableList<Uri.Builder> = mutableListOf()

    /** A text summary of the investigations and the diagnosis. */
    public var summary: String.Builder? = null

    /**
     * Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.
     */
    public var finding: MutableList<Finding.Builder> = mutableListOf()

    /** Estimate of likely outcome. */
    public var prognosisCodeableConcept: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** RiskAssessment expressing likely outcome. */
    public var prognosisReference: MutableList<Reference.Builder> = mutableListOf()

    /** Information supporting the clinical impression. */
    public var supportingInfo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Commentary about the impression, typically recorded after the impression itself was made,
     * though supplemental notes by the original author could also appear.
     *
     * Don't use this element for content that should more properly appear as one of the specific
     * elements of the impression.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): ClinicalImpression =
      ClinicalImpression(
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
        statusReason = statusReason?.build(),
        code = code?.build(),
        description = description?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        effective = effective,
        date = date?.build(),
        assessor = assessor?.build(),
        previous = previous?.build(),
        problem = problem.map { it.build() },
        investigation = investigation.map { it.build() },
        protocol = protocol.map { it.build() },
        summary = summary?.build(),
        finding = finding.map { it.build() },
        prognosisCodeableConcept = prognosisCodeableConcept.map { it.build() },
        prognosisReference = prognosisReference.map { it.build() },
        supportingInfo = supportingInfo.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /** Codes that reflect the current state of a clinical impression within its overall lifecycle. */
  public enum class ClinicalImpressionStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    In_Progress("in-progress", "http://hl7.org/fhir/event-status", "In Progress"),
    Completed("completed", "http://hl7.org/fhir/event-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/event-status", "Entered in Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ClinicalImpressionStatus =
        when (code) {
          "in-progress" -> In_Progress
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum ClinicalImpressionStatus")
        }
    }
  }
}
