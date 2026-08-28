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

import dev.ohs.fhir.model.r5.serializers.DetectedIssueEvidenceSerializer
import dev.ohs.fhir.model.r5.serializers.DetectedIssueMitigationSerializer
import dev.ohs.fhir.model.r5.serializers.DetectedIssueSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates an actual or potential clinical issue with or between one or more active or proposed
 * clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency,
 * Procedure-condition conflict, gaps in care, etc.
 */
@Serializable(with = DetectedIssueSerializer::class)
@SerialName("DetectedIssue")
public data class DetectedIssue(
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
  /** Business identifier associated with the detected issue record. */
  public val identifier: List<Identifier> = listOf(),
  /**
   * Indicates the status of the detected issue.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that marks the issue as not currently valid.
   */
  public val status: Enumeration<DetectedIssueStatus>,
  /**
   * A code that classifies the general type of detected issue.
   *
   * In addition to the required category valueset, this element allows various categorization
   * schemes based on the owner’s definition of the category and effectively multiple categories can
   * be used at once. The level of granularity is defined by the category concepts in the value set.
   */
  public val category: List<CodeableConcept> = listOf(),
  /** Identifies the specific type of issue identified. */
  public val code: CodeableConcept? = null,
  /**
   * Indicates the degree of importance associated with the identified issue based on the potential
   * impact on the patient.
   */
  public val severity: Enumeration<DetectedIssueSeverity>? = null,
  /** Indicates the subject whose record the detected issue is associated with. */
  public val subject: Reference? = null,
  /**
   * The encounter during which this issue was detected.
   *
   * This will typically be the encounter the DetectedIssue was created during, but some
   * DetectedIssues may be initiated prior to or after the official completion of an encounter but
   * still be tied to the context of the encounter (e.g. pre-admission lab tests).
   */
  public val encounter: Reference? = null,
  /** The date or period when the detected issue was initially identified. */
  public val identified: Identified? = null,
  /**
   * Individual or device responsible for the issue being raised. For example, a decision support
   * application or a pharmacist conducting a medication review.
   */
  public val author: Reference? = null,
  /**
   * Indicates the resource representing the current activity or proposed activity that is
   * potentially problematic.
   *
   * There's an implicit constraint on the number of implicated resources based on
   * DetectedIssue.type; e.g. For drug-drug, there would be more than one. For timing, there would
   * typically only be one.
   */
  public val implicated: List<Reference> = listOf(),
  /**
   * Supporting evidence or manifestations that provide the basis for identifying the detected issue
   * such as a GuidanceResponse or MeasureReport.
   */
  public val evidence: List<Evidence> = listOf(),
  /**
   * A textual explanation of the detected issue.
   *
   * Should focus on information not covered elsewhere as discrete data - no need to duplicate the
   * narrative.
   */
  public val detail: Markdown? = null,
  /**
   * The literature, knowledge-base or similar reference that describes the propensity for the
   * detected issue identified.
   */
  public val reference: Uri? = null,
  /**
   * Indicates an action that has been taken or is committed to reduce or eliminate the likelihood
   * of the risk identified by the detected issue from manifesting. Can also reflect an observation
   * of known mitigating factors that may reduce/eliminate the need for any action.
   */
  public val mitigation: List<Mitigation> = listOf(),
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
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        code = this@with.code?.toBuilder()
        severity = this@with.severity
        subject = this@with.subject?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        identified = this@with.identified
        author = this@with.author?.toBuilder()
        implicated = this@with.implicated.map { it.toBuilder() }.toMutableList()
        evidence = this@with.evidence.map { it.toBuilder() }.toMutableList()
        detail = this@with.detail?.toBuilder()
        reference = this@with.reference?.toBuilder()
        mitigation = this@with.mitigation.map { it.toBuilder() }.toMutableList()
      }
    }

  /**
   * Supporting evidence or manifestations that provide the basis for identifying the detected issue
   * such as a GuidanceResponse or MeasureReport.
   */
  @Serializable(with = DetectedIssueEvidenceSerializer::class)
  public data class Evidence(
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
    /** A manifestation that led to the recording of this detected issue. */
    public val code: List<CodeableConcept> = listOf(),
    /**
     * Links to resources that constitute evidence for the detected issue such as a GuidanceResponse
     * or MeasureReport.
     */
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

      /** A manifestation that led to the recording of this detected issue. */
      public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Links to resources that constitute evidence for the detected issue such as a
       * GuidanceResponse or MeasureReport.
       */
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

  /**
   * Indicates an action that has been taken or is committed to reduce or eliminate the likelihood
   * of the risk identified by the detected issue from manifesting. Can also reflect an observation
   * of known mitigating factors that may reduce/eliminate the need for any action.
   */
  @Serializable(with = DetectedIssueMitigationSerializer::class)
  public data class Mitigation(
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
     * Describes the action that was taken or the observation that was made that reduces/eliminates
     * the risk associated with the identified issue.
     *
     * The "text" component can be used for detail or when no appropriate code exists.
     */
    public val action: CodeableConcept,
    /**
     * Indicates when the mitigating action was documented.
     *
     * This might not be the same as when the mitigating step was actually taken.
     */
    public val date: DateTime? = null,
    /**
     * Identifies the practitioner who determined the mitigation and takes responsibility for the
     * mitigation step occurring.
     */
    public val author: Reference? = null,
    /**
     * Clinicians may add additional notes or justifications about the mitigation action. For
     * example, patient can have this drug because they have had it before without any issues.
     * Multiple justifications may be provided.
     */
    public val note: List<Annotation> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(action.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          date = this@with.date?.toBuilder()
          author = this@with.author?.toBuilder()
          note = this@with.note.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Describes the action that was taken or the observation that was made that
       * reduces/eliminates the risk associated with the identified issue.
       *
       * The "text" component can be used for detail or when no appropriate code exists.
       */
      public var action: CodeableConcept.Builder
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
       * Indicates when the mitigating action was documented.
       *
       * This might not be the same as when the mitigating step was actually taken.
       */
      public var date: DateTime.Builder? = null

      /**
       * Identifies the practitioner who determined the mitigation and takes responsibility for the
       * mitigation step occurring.
       */
      public var author: Reference.Builder? = null

      /**
       * Clinicians may add additional notes or justifications about the mitigation action. For
       * example, patient can have this drug because they have had it before without any issues.
       * Multiple justifications may be provided.
       */
      public var note: MutableList<Annotation.Builder> = mutableListOf()

      public fun build(): Mitigation =
        Mitigation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          action = action.build(),
          date = date?.build(),
          author = author?.build(),
          note = note.map { it.build() },
        )
    }
  }

  public sealed interface Identified {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Identified

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Identified

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
        periodValue: dev.ohs.fhir.model.r5.Period?,
      ): Identified? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * Indicates the status of the detected issue.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that marks the issue as not currently valid.
     */
    public var status: Enumeration<DetectedIssueStatus>
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

    /** Business identifier associated with the detected issue record. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * A code that classifies the general type of detected issue.
     *
     * In addition to the required category valueset, this element allows various categorization
     * schemes based on the owner’s definition of the category and effectively multiple categories
     * can be used at once. The level of granularity is defined by the category concepts in the
     * value set.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Identifies the specific type of issue identified. */
    public var code: CodeableConcept.Builder? = null

    /**
     * Indicates the degree of importance associated with the identified issue based on the
     * potential impact on the patient.
     */
    public var severity: Enumeration<DetectedIssueSeverity>? = null

    /** Indicates the subject whose record the detected issue is associated with. */
    public var subject: Reference.Builder? = null

    /**
     * The encounter during which this issue was detected.
     *
     * This will typically be the encounter the DetectedIssue was created during, but some
     * DetectedIssues may be initiated prior to or after the official completion of an encounter but
     * still be tied to the context of the encounter (e.g. pre-admission lab tests).
     */
    public var encounter: Reference.Builder? = null

    /** The date or period when the detected issue was initially identified. */
    public var identified: Identified? = null

    /**
     * Individual or device responsible for the issue being raised. For example, a decision support
     * application or a pharmacist conducting a medication review.
     */
    public var author: Reference.Builder? = null

    /**
     * Indicates the resource representing the current activity or proposed activity that is
     * potentially problematic.
     *
     * There's an implicit constraint on the number of implicated resources based on
     * DetectedIssue.type; e.g. For drug-drug, there would be more than one. For timing, there would
     * typically only be one.
     */
    public var implicated: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Supporting evidence or manifestations that provide the basis for identifying the detected
     * issue such as a GuidanceResponse or MeasureReport.
     */
    public var evidence: MutableList<Evidence.Builder> = mutableListOf()

    /**
     * A textual explanation of the detected issue.
     *
     * Should focus on information not covered elsewhere as discrete data - no need to duplicate the
     * narrative.
     */
    public var detail: Markdown.Builder? = null

    /**
     * The literature, knowledge-base or similar reference that describes the propensity for the
     * detected issue identified.
     */
    public var reference: Uri.Builder? = null

    /**
     * Indicates an action that has been taken or is committed to reduce or eliminate the likelihood
     * of the risk identified by the detected issue from manifesting. Can also reflect an
     * observation of known mitigating factors that may reduce/eliminate the need for any action.
     */
    public var mitigation: MutableList<Mitigation.Builder> = mutableListOf()

    override fun build(): DetectedIssue =
      DetectedIssue(
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
        category = category.map { it.build() },
        code = code?.build(),
        severity = severity,
        subject = subject?.build(),
        encounter = encounter?.build(),
        identified = identified,
        author = author?.build(),
        implicated = implicated.map { it.build() },
        evidence = evidence.map { it.build() },
        detail = detail?.build(),
        reference = reference?.build(),
        mitigation = mitigation.map { it.build() },
      )
  }

  /** Indicates the status of a detected issue */
  public enum class DetectedIssueStatus(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    Preliminary("preliminary", "http://hl7.org/fhir/observation-status", "Preliminary"),
    Final("final", "http://hl7.org/fhir/observation-status", "Final"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/observation-status",
      "Entered in Error",
    ),
    Mitigated("mitigated", "http://hl7.org/fhir/detectedissue-status", "Mitigated");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): DetectedIssueStatus =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException("Unknown code $code for enum DetectedIssueStatus")

      public fun fromCodeOrNull(code: String?): DetectedIssueStatus? =
        when (code) {
          "preliminary" -> Preliminary
          "final" -> Final
          "entered-in-error" -> Entered_In_Error
          "mitigated" -> Mitigated
          else -> null
        }
    }
  }

  /** Indicates the potential degree of impact of the identified issue on the patient. */
  public enum class DetectedIssueSeverity(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    High("high", "http://hl7.org/fhir/detectedissue-severity", "High"),
    Moderate("moderate", "http://hl7.org/fhir/detectedissue-severity", "Moderate"),
    Low("low", "http://hl7.org/fhir/detectedissue-severity", "Low");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): DetectedIssueSeverity =
        fromCodeOrNull(code)
          ?: throw IllegalArgumentException("Unknown code $code for enum DetectedIssueSeverity")

      public fun fromCodeOrNull(code: String?): DetectedIssueSeverity? =
        when (code) {
          "high" -> High
          "moderate" -> Moderate
          "low" -> Low
          else -> null
        }
    }
  }
}
