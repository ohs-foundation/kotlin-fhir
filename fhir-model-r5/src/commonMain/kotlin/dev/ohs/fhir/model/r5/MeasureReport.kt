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

import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupPopulationSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupStratifierSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupStratifierStratumComponentSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupStratifierStratumPopulationSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportGroupStratifierStratumSerializer
import dev.ohs.fhir.model.r5.serializers.MeasureReportSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The MeasureReport resource contains the results of the calculation of a measure; and optionally a
 * reference to the resources involved in that calculation.
 */
@Serializable(with = MeasureReportSerializer::class)
@SerialName("MeasureReport")
public data class MeasureReport(
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
   * A formal identifier that is used to identify this MeasureReport when it is represented in other
   * formats or referenced in a specification, model, design or an instance.
   *
   * Typically, this is used for identifiers that can go in an HL7 V3 II data type - e.g. to
   * identify this {{title}} outside of FHIR, where the logical URL is not possible to use.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The MeasureReport status. No data will be available until the MeasureReport status is complete.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<MeasureReportStatus>,
  /**
   * The type of measure report. This may be an individual report, which provides the score for the
   * measure for an individual member of the population; a subject-listing, which returns the list
   * of members that meet the various criteria in the measure; a summary report, which returns a
   * population count for each of the criteria in the measure; or a data-collection, which enables
   * the MeasureReport to be used to exchange the data-of-interest for a quality measure.
   *
   * Data-exchange reports are used only to communicate data-of-interest for a measure. They do not
   * necessarily include all the data for a particular subject or population, but they may.
   */
  public val type: Enumeration<MeasureReportType>,
  /**
   * Indicates whether the data submitted in a data-exchange report represents a snapshot or
   * incremental update. A snapshot update replaces all previously submitted data for the receiver,
   * whereas an incremental update represents only updated and/or changed data and should be applied
   * as a differential update to the existing submitted data for the receiver.
   *
   * This element only applies to Data-collection reports used to communicate the data-of-interest
   * for a measure
   */
  public val dataUpdateType: Enumeration<SubmitDataUpdateType>? = null,
  /** A reference to the Measure that was calculated to produce this report. */
  public val measure: Canonical? = null,
  /** Optional subject identifying the individual or individuals the report is for. */
  public val subject: Reference? = null,
  /** The date this measure was calculated. */
  public val date: DateTime? = null,
  /** The individual or organization that is reporting the data. */
  public val reporter: Reference? = null,
  /**
   * A reference to the vendor who queried the data, calculated results and/or generated the report.
   * The ‘reporting vendor’ is intended to represent the submitting entity when it is not the same
   * as the reporting entity. This extension is used when the Receiver is interested in getting
   * vendor information in the report.
   */
  public val reportingVendor: Reference? = null,
  /** A reference to the location for which the data is being reported. */
  public val location: Reference? = null,
  /** The reporting period for which the report was calculated. */
  public val period: Period,
  /**
   * A reference to a Parameters resource (typically represented using a contained resource) that
   * represents any input parameters that were provided to the operation that generated the report.
   *
   * Whenever an operation returns a MeasureReport, the IN parameters from that operation can be
   * returned to the caller of the operation using MeasureReport.inputParameters. Operations include
   * but are not limited to $evaluate-measure, $care-gaps, $data-requirements, and $collect-data.
   * The inputParameters can also be used in a MeasureReport used to define a test case (i.e., not
   * as a result of an operation).
   */
  public val inputParameters: Reference? = null,
  /**
   * Indicates how the calculation is performed for the measure, including proportion, ratio,
   * continuous-variable, and cohort. The value set is extensible, allowing additional measure
   * scoring types to be represented. It is expected to be the same as the scoring element on the
   * referenced Measure.
   */
  public val scoring: CodeableConcept? = null,
  /**
   * Whether improvement in the measure is noted by an increase or decrease in the measure score.
   *
   * This element is typically defined by the measure, but reproduced here to ensure the measure
   * score can be interpreted. The element is labeled as a modifier because it changes the
   * interpretation of the reported measure score. Note also that a MeasureReport instance includes
   * the improvementNotation as defined by the Measure being reported. It is duplicated in the
   * MeasureReport because it is a critical aspect of interpreting the measure score but it is not
   * intended to reflect whether the measure report is an increase or decrease. It helps interpret
   * if the measure score is an increase or decrease, I.e., moving in the direction of the desired
   * outcome.
   */
  public val improvementNotation: CodeableConcept? = null,
  /** The results of the calculation, one for each population group in the measure. */
  public val group: List<Group> = listOf(),
  /**
   * A reference to a Resource that represents additional information collected for the report. If
   * the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData
   * expression for this case in the measure results in a value that is not a FHIR Resource), it is
   * reported as a reference to a contained Observation resource.
   *
   * For individual measure reports, the supplementalData elements represent the direct result of
   * evaluating the supplementalData expression for the subject of the report. For summary reports,
   * supplementalData is reported as references to contained Observation resources that represent
   * the number of times each value appeared as a supplementalData result for members of the
   * population.
   */
  public val supplementalData: List<Reference> = listOf(),
  /**
   * Evaluated resources are used to capture what data was involved in the calculation of a measure.
   * This usage is only allowed for individual reports to ensure that the size of the MeasureReport
   * resource is bounded.
   *
   * Evaluated resources are only reported for individual reports.
   */
  public val evaluatedResource: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          status,
          type,
          period.toBuilder(),
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
          dataUpdateType = this@with.dataUpdateType
          measure = this@with.measure?.toBuilder()
          subject = this@with.subject?.toBuilder()
          date = this@with.date?.toBuilder()
          reporter = this@with.reporter?.toBuilder()
          reportingVendor = this@with.reportingVendor?.toBuilder()
          location = this@with.location?.toBuilder()
          inputParameters = this@with.inputParameters?.toBuilder()
          scoring = this@with.scoring?.toBuilder()
          improvementNotation = this@with.improvementNotation?.toBuilder()
          group = this@with.group.map { it.toBuilder() }.toMutableList()
          supplementalData = this@with.supplementalData.map { it.toBuilder() }.toMutableList()
          evaluatedResource = this@with.evaluatedResource.map { it.toBuilder() }.toMutableList()
        }
    }

  /** The results of the calculation, one for each population group in the measure. */
  @Serializable(with = MeasureReportGroupSerializer::class)
  public data class Group(
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
    /** The group from the Measure that corresponds to this group in the MeasureReport resource. */
    public val linkId: String? = null,
    /** The meaning of the population group as defined in the measure definition. */
    public val code: CodeableConcept? = null,
    /** Optional subject identifying the individual or individuals the report is for. */
    public val subject: Reference? = null,
    /**
     * The populations that make up the population group, one for each type of population
     * appropriate for the measure.
     */
    public val population: List<Population> = listOf(),
    /**
     * The measure score for this population group, calculated as appropriate for the measure type
     * and scoring method, and based on the contents of the populations defined in the group.
     */
    public val measureScore: MeasureScore? = null,
    /**
     * When a measure includes multiple stratifiers, there will be a stratifier group for each
     * stratifier defined by the measure.
     */
    public val stratifier: List<Stratifier> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          linkId = this@with.linkId?.toBuilder()
          code = this@with.code?.toBuilder()
          subject = this@with.subject?.toBuilder()
          population = this@with.population.map { it.toBuilder() }.toMutableList()
          measureScore = this@with.measureScore
          stratifier = this@with.stratifier.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * The populations that make up the population group, one for each type of population
     * appropriate for the measure.
     */
    @Serializable(with = MeasureReportGroupPopulationSerializer::class)
    public data class Population(
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
       * The population from the Measure that corresponds to this population in the MeasureReport
       * resource.
       */
      public val linkId: String? = null,
      /** The type of the population. */
      public val code: CodeableConcept? = null,
      /** The number of members of the population. */
      public val count: Integer? = null,
      /**
       * This element refers to a List of individual level MeasureReport resources, one for each
       * subject in this population.
       */
      public val subjectResults: Reference? = null,
      /**
       * A reference to an individual level MeasureReport resource for a member of the population.
       *
       * This element SHALL NOT be used in with subjectResults, either systems provide results as a
       * List of MeasureReport, or as references to individual MeasureReports. Note that using this
       * element introduces a constraint on the size of the subject-list MeasureReport;
       * implementations would be free to return a TOO-COSTLY response if a request is made for a
       * subject-list report with too many subjects.
       */
      public val subjectReport: List<Reference> = listOf(),
      /**
       * Optional Group identifying the individuals that make up the population.
       *
       * Note that this element can only be used for summary and subject-list reports where the
       * basis is of the same type as the populations (e.g. a Patient-based measure, rather than an
       * Encounter-based measure). In addition, the referenced Group resource SHALL be an actual (as
       * opposed to a definitional) group.
       */
      public val subjects: Reference? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            linkId = this@with.linkId?.toBuilder()
            code = this@with.code?.toBuilder()
            count = this@with.count?.toBuilder()
            subjectResults = this@with.subjectResults?.toBuilder()
            subjectReport = this@with.subjectReport.map { it.toBuilder() }.toMutableList()
            subjects = this@with.subjects?.toBuilder()
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

        /**
         * The population from the Measure that corresponds to this population in the MeasureReport
         * resource.
         */
        public var linkId: String.Builder? = null

        /** The type of the population. */
        public var code: CodeableConcept.Builder? = null

        /** The number of members of the population. */
        public var count: Integer.Builder? = null

        /**
         * This element refers to a List of individual level MeasureReport resources, one for each
         * subject in this population.
         */
        public var subjectResults: Reference.Builder? = null

        /**
         * A reference to an individual level MeasureReport resource for a member of the population.
         *
         * This element SHALL NOT be used in with subjectResults, either systems provide results as
         * a List of MeasureReport, or as references to individual MeasureReports. Note that using
         * this element introduces a constraint on the size of the subject-list MeasureReport;
         * implementations would be free to return a TOO-COSTLY response if a request is made for a
         * subject-list report with too many subjects.
         */
        public var subjectReport: MutableList<Reference.Builder> = mutableListOf()

        /**
         * Optional Group identifying the individuals that make up the population.
         *
         * Note that this element can only be used for summary and subject-list reports where the
         * basis is of the same type as the populations (e.g. a Patient-based measure, rather than
         * an Encounter-based measure). In addition, the referenced Group resource SHALL be an
         * actual (as opposed to a definitional) group.
         */
        public var subjects: Reference.Builder? = null

        public fun build(): Population =
          Population(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            linkId = linkId?.build(),
            code = code?.build(),
            count = count?.build(),
            subjectResults = subjectResults?.build(),
            subjectReport = subjectReport.map { it.build() },
            subjects = subjects?.build(),
          )
      }
    }

    /**
     * When a measure includes multiple stratifiers, there will be a stratifier group for each
     * stratifier defined by the measure.
     */
    @Serializable(with = MeasureReportGroupStratifierSerializer::class)
    public data class Stratifier(
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
       * The stratifier from the Measure that corresponds to this stratifier in the MeasureReport
       * resource.
       */
      public val linkId: String? = null,
      /** The meaning of this stratifier, as defined in the measure definition. */
      public val code: CodeableConcept? = null,
      /**
       * This element contains the results for a single stratum within the stratifier. For example,
       * when stratifying on administrative gender, there will be four strata, one for each possible
       * gender value.
       */
      public val stratum: List<Stratum> = listOf(),
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            linkId = this@with.linkId?.toBuilder()
            code = this@with.code?.toBuilder()
            stratum = this@with.stratum.map { it.toBuilder() }.toMutableList()
          }
        }

      /**
       * This element contains the results for a single stratum within the stratifier. For example,
       * when stratifying on administrative gender, there will be four strata, one for each possible
       * gender value.
       */
      @Serializable(with = MeasureReportGroupStratifierStratumSerializer::class)
      public data class Stratum(
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        override val id: kotlin.String? = null,
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
        override val extension: List<Extension> = listOf(),
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
        override val modifierExtension: List<Extension> = listOf(),
        /**
         * The value for this stratum, expressed as a CodeableConcept. When defining stratifiers on
         * complex values, the value must be rendered such that the value for each stratum within
         * the stratifier is unique.
         */
        public val `value`: Value? = null,
        /** A stratifier component value. */
        public val component: List<Component> = listOf(),
        /**
         * The populations that make up the stratum, one for each type of population appropriate to
         * the measure.
         */
        public val population: List<Population> = listOf(),
        /**
         * The measure score for this stratum, calculated as appropriate for the measure type and
         * scoring method, and based on only the members of this stratum.
         */
        public val measureScore: MeasureScore? = null,
      ) : BackboneElement() {
        public fun toBuilder(): Builder =
          with(this) {
            Builder().apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              `value` = this@with.`value`
              component = this@with.component.map { it.toBuilder() }.toMutableList()
              population = this@with.population.map { it.toBuilder() }.toMutableList()
              measureScore = this@with.measureScore
            }
          }

        /** A stratifier component value. */
        @Serializable(with = MeasureReportGroupStratifierStratumComponentSerializer::class)
        public data class Component(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: kotlin.String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val extension: List<Extension> = listOf(),
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val modifierExtension: List<Extension> = listOf(),
          /**
           * The stratifier component from the Measure that corresponds to this stratifier component
           * in the MeasureReport resource.
           */
          public val linkId: String? = null,
          /** The code for the stratum component value. */
          public val code: CodeableConcept,
          /** The stratum component value. */
          public val `value`: Value,
        ) : BackboneElement() {
          public fun toBuilder(): Builder =
            with(this) {
              Builder(
                  code.toBuilder(),
                  `value`,
                )
                .apply {
                  id = this@with.id
                  extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                  modifierExtension =
                    this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                  linkId = this@with.linkId?.toBuilder()
                }
            }

          public sealed interface Value {
            public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

            public fun asBoolean(): Boolean? = this as? Boolean

            public fun asQuantity(): Quantity? = this as? Quantity

            public fun asRange(): Range? = this as? Range

            public fun asReference(): Reference? = this as? Reference

            public data class CodeableConcept(
              public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
            ) : Value

            public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

            public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

            public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

            public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

            public companion object {
              internal fun from(
                codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
                booleanValue: dev.ohs.fhir.model.r5.Boolean?,
                quantityValue: dev.ohs.fhir.model.r5.Quantity?,
                rangeValue: dev.ohs.fhir.model.r5.Range?,
                referenceValue: dev.ohs.fhir.model.r5.Reference?,
              ): Value? {
                if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
                if (booleanValue != null) return Boolean(booleanValue)
                if (quantityValue != null) return Quantity(quantityValue)
                if (rangeValue != null) return Range(rangeValue)
                if (referenceValue != null) return Reference(referenceValue)
                return null
              }
            }
          }

          public class Builder(
            /** The code for the stratum component value. */
            public var code: CodeableConcept.Builder,
            /** The stratum component value. */
            public var `value`: Value,
          ) {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: kotlin.String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and managable, there is
             * a strict set of governance applied to the definition and use of extensions. Though
             * any implementer can define an extension, there is a set of requirements that SHALL be
             * met as part of the definition of the extension.
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var extension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element and that modifies the understanding of the element in which
             * it is contained and/or the understanding of the containing element's descendants.
             * Usually modifier elements provide negation or qualification. To make the use of
             * extensions safe and managable, there is a strict set of governance applied to the
             * definition and use of extensions. Though any implementer can define an extension,
             * there is a set of requirements that SHALL be met as part of the definition of the
             * extension. Applications processing a resource are required to check for modifier
             * extensions.
             *
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
             * DomainResource (including cannot change the meaning of modifierExtension itself).
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * The stratifier component from the Measure that corresponds to this stratifier
             * component in the MeasureReport resource.
             */
            public var linkId: String.Builder? = null

            public fun build(): Component =
              Component(
                id = id,
                extension = extension.map { it.build() },
                modifierExtension = modifierExtension.map { it.build() },
                linkId = linkId?.build(),
                code = code.build(),
                `value` = `value`,
              )
          }
        }

        /**
         * The populations that make up the stratum, one for each type of population appropriate to
         * the measure.
         */
        @Serializable(with = MeasureReportGroupStratifierStratumPopulationSerializer::class)
        public data class Population(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: kotlin.String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val extension: List<Extension> = listOf(),
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          override val modifierExtension: List<Extension> = listOf(),
          /**
           * The population from the Measure that corresponds to this population in the
           * MeasureReport resource.
           */
          public val linkId: String? = null,
          /** The type of the population. */
          public val code: CodeableConcept? = null,
          /** The number of members of the population in this stratum. */
          public val count: Integer? = null,
          /**
           * This element refers to a List of individual level MeasureReport resources, one for each
           * subject in this population in this stratum.
           */
          public val subjectResults: Reference? = null,
          /**
           * A reference to an individual level MeasureReport resource for a member of the
           * population.
           *
           * This element SHALL NOT be used in with subjectResults, either systems provide results
           * as a List of MeasureReport, or as references to individual MeasureReports. Note that
           * using this element introduces a constraint on the size of the subject-list
           * MeasureReport; implementations would be free to return a TOO-COSTLY response if a
           * request is made for a subject-list report with too many subjects.
           */
          public val subjectReport: List<Reference> = listOf(),
          /**
           * Optional Group identifying the individuals that make up the population.
           *
           * Note that this element can only be used for summary and subject-list reports where the
           * basis is of the same type as the populations (e.g. a Patient-based measure, rather than
           * an Encounter-based measure). In addition, the referenced Group SHALL be an actual (as
           * opposed to a definitional) group.
           */
          public val subjects: Reference? = null,
        ) : BackboneElement() {
          public fun toBuilder(): Builder =
            with(this) {
              Builder().apply {
                id = this@with.id
                extension = this@with.extension.map { it.toBuilder() }.toMutableList()
                modifierExtension =
                  this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
                linkId = this@with.linkId?.toBuilder()
                code = this@with.code?.toBuilder()
                count = this@with.count?.toBuilder()
                subjectResults = this@with.subjectResults?.toBuilder()
                subjectReport = this@with.subjectReport.map { it.toBuilder() }.toMutableList()
                subjects = this@with.subjects?.toBuilder()
              }
            }

          public class Builder() {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: kotlin.String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and managable, there is
             * a strict set of governance applied to the definition and use of extensions. Though
             * any implementer can define an extension, there is a set of requirements that SHALL be
             * met as part of the definition of the extension.
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var extension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element and that modifies the understanding of the element in which
             * it is contained and/or the understanding of the containing element's descendants.
             * Usually modifier elements provide negation or qualification. To make the use of
             * extensions safe and managable, there is a strict set of governance applied to the
             * definition and use of extensions. Though any implementer can define an extension,
             * there is a set of requirements that SHALL be met as part of the definition of the
             * extension. Applications processing a resource are required to check for modifier
             * extensions.
             *
             * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
             * DomainResource (including cannot change the meaning of modifierExtension itself).
             *
             * There can be no stigma associated with the use of extensions by any application,
             * project, or standard - regardless of the institution or jurisdiction that uses or
             * defines the extensions. The use of extensions is what allows the FHIR specification
             * to retain a core level of simplicity for everyone.
             */
            public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

            /**
             * The population from the Measure that corresponds to this population in the
             * MeasureReport resource.
             */
            public var linkId: String.Builder? = null

            /** The type of the population. */
            public var code: CodeableConcept.Builder? = null

            /** The number of members of the population in this stratum. */
            public var count: Integer.Builder? = null

            /**
             * This element refers to a List of individual level MeasureReport resources, one for
             * each subject in this population in this stratum.
             */
            public var subjectResults: Reference.Builder? = null

            /**
             * A reference to an individual level MeasureReport resource for a member of the
             * population.
             *
             * This element SHALL NOT be used in with subjectResults, either systems provide results
             * as a List of MeasureReport, or as references to individual MeasureReports. Note that
             * using this element introduces a constraint on the size of the subject-list
             * MeasureReport; implementations would be free to return a TOO-COSTLY response if a
             * request is made for a subject-list report with too many subjects.
             */
            public var subjectReport: MutableList<Reference.Builder> = mutableListOf()

            /**
             * Optional Group identifying the individuals that make up the population.
             *
             * Note that this element can only be used for summary and subject-list reports where
             * the basis is of the same type as the populations (e.g. a Patient-based measure,
             * rather than an Encounter-based measure). In addition, the referenced Group SHALL be
             * an actual (as opposed to a definitional) group.
             */
            public var subjects: Reference.Builder? = null

            public fun build(): Population =
              Population(
                id = id,
                extension = extension.map { it.build() },
                modifierExtension = modifierExtension.map { it.build() },
                linkId = linkId?.build(),
                code = code?.build(),
                count = count?.build(),
                subjectResults = subjectResults?.build(),
                subjectReport = subjectReport.map { it.build() },
                subjects = subjects?.build(),
              )
          }
        }

        public sealed interface Value {
          public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

          public fun asBoolean(): Boolean? = this as? Boolean

          public fun asQuantity(): Quantity? = this as? Quantity

          public fun asRange(): Range? = this as? Range

          public fun asReference(): Reference? = this as? Reference

          public data class CodeableConcept(
            public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
          ) : Value

          public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

          public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

          public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

          public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Value

          public companion object {
            internal fun from(
              codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
              booleanValue: dev.ohs.fhir.model.r5.Boolean?,
              quantityValue: dev.ohs.fhir.model.r5.Quantity?,
              rangeValue: dev.ohs.fhir.model.r5.Range?,
              referenceValue: dev.ohs.fhir.model.r5.Reference?,
            ): Value? {
              if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
              if (booleanValue != null) return Boolean(booleanValue)
              if (quantityValue != null) return Quantity(quantityValue)
              if (rangeValue != null) return Range(rangeValue)
              if (referenceValue != null) return Reference(referenceValue)
              return null
            }
          }
        }

        public sealed interface MeasureScore {
          public fun asQuantity(): Quantity? = this as? Quantity

          public fun asDateTime(): DateTime? = this as? DateTime

          public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

          public fun asPeriod(): Period? = this as? Period

          public fun asRange(): Range? = this as? Range

          public fun asDuration(): Duration? = this as? Duration

          public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) :
            MeasureScore

          public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) :
            MeasureScore

          public data class CodeableConcept(
            public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
          ) : MeasureScore

          public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : MeasureScore

          public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : MeasureScore

          public data class Duration(public val `value`: dev.ohs.fhir.model.r5.Duration) :
            MeasureScore

          public companion object {
            internal fun from(
              quantityValue: dev.ohs.fhir.model.r5.Quantity?,
              dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
              codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
              periodValue: dev.ohs.fhir.model.r5.Period?,
              rangeValue: dev.ohs.fhir.model.r5.Range?,
              durationValue: dev.ohs.fhir.model.r5.Duration?,
            ): MeasureScore? {
              if (quantityValue != null) return Quantity(quantityValue)
              if (dateTimeValue != null) return DateTime(dateTimeValue)
              if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
              if (periodValue != null) return Period(periodValue)
              if (rangeValue != null) return Range(rangeValue)
              if (durationValue != null) return Duration(durationValue)
              return null
            }
          }
        }

        public class Builder() {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: kotlin.String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and managable, there is a
           * strict set of governance applied to the definition and use of extensions. Though any
           * implementer can define an extension, there is a set of requirements that SHALL be met
           * as part of the definition of the extension.
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var extension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element and that modifies the understanding of the element in which
           * it is contained and/or the understanding of the containing element's descendants.
           * Usually modifier elements provide negation or qualification. To make the use of
           * extensions safe and managable, there is a strict set of governance applied to the
           * definition and use of extensions. Though any implementer can define an extension, there
           * is a set of requirements that SHALL be met as part of the definition of the extension.
           * Applications processing a resource are required to check for modifier extensions.
           *
           * Modifier extensions SHALL NOT change the meaning of any elements on Resource or
           * DomainResource (including cannot change the meaning of modifierExtension itself).
           *
           * There can be no stigma associated with the use of extensions by any application,
           * project, or standard - regardless of the institution or jurisdiction that uses or
           * defines the extensions. The use of extensions is what allows the FHIR specification to
           * retain a core level of simplicity for everyone.
           */
          public var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

          /**
           * The value for this stratum, expressed as a CodeableConcept. When defining stratifiers
           * on complex values, the value must be rendered such that the value for each stratum
           * within the stratifier is unique.
           */
          public var `value`: Value? = null

          /** A stratifier component value. */
          public var component: MutableList<Component.Builder> = mutableListOf()

          /**
           * The populations that make up the stratum, one for each type of population appropriate
           * to the measure.
           */
          public var population: MutableList<Population.Builder> = mutableListOf()

          /**
           * The measure score for this stratum, calculated as appropriate for the measure type and
           * scoring method, and based on only the members of this stratum.
           */
          public var measureScore: MeasureScore? = null

          public fun build(): Stratum =
            Stratum(
              id = id,
              extension = extension.map { it.build() },
              modifierExtension = modifierExtension.map { it.build() },
              `value` = `value`,
              component = component.map { it.build() },
              population = population.map { it.build() },
              measureScore = measureScore,
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
         * The stratifier from the Measure that corresponds to this stratifier in the MeasureReport
         * resource.
         */
        public var linkId: String.Builder? = null

        /** The meaning of this stratifier, as defined in the measure definition. */
        public var code: CodeableConcept.Builder? = null

        /**
         * This element contains the results for a single stratum within the stratifier. For
         * example, when stratifying on administrative gender, there will be four strata, one for
         * each possible gender value.
         */
        public var stratum: MutableList<Stratum.Builder> = mutableListOf()

        public fun build(): Stratifier =
          Stratifier(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            linkId = linkId?.build(),
            code = code?.build(),
            stratum = stratum.map { it.build() },
          )
      }
    }

    public sealed interface MeasureScore {
      public fun asQuantity(): Quantity? = this as? Quantity

      public fun asDateTime(): DateTime? = this as? DateTime

      public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

      public fun asPeriod(): Period? = this as? Period

      public fun asRange(): Range? = this as? Range

      public fun asDuration(): Duration? = this as? Duration

      public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : MeasureScore

      public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : MeasureScore

      public data class CodeableConcept(public val `value`: dev.ohs.fhir.model.r5.CodeableConcept) :
        MeasureScore

      public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : MeasureScore

      public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : MeasureScore

      public data class Duration(public val `value`: dev.ohs.fhir.model.r5.Duration) : MeasureScore

      public companion object {
        internal fun from(
          quantityValue: dev.ohs.fhir.model.r5.Quantity?,
          dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
          codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
          periodValue: dev.ohs.fhir.model.r5.Period?,
          rangeValue: dev.ohs.fhir.model.r5.Range?,
          durationValue: dev.ohs.fhir.model.r5.Duration?,
        ): MeasureScore? {
          if (quantityValue != null) return Quantity(quantityValue)
          if (dateTimeValue != null) return DateTime(dateTimeValue)
          if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
          if (periodValue != null) return Period(periodValue)
          if (rangeValue != null) return Range(rangeValue)
          if (durationValue != null) return Duration(durationValue)
          return null
        }
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
       * The group from the Measure that corresponds to this group in the MeasureReport resource.
       */
      public var linkId: String.Builder? = null

      /** The meaning of the population group as defined in the measure definition. */
      public var code: CodeableConcept.Builder? = null

      /** Optional subject identifying the individual or individuals the report is for. */
      public var subject: Reference.Builder? = null

      /**
       * The populations that make up the population group, one for each type of population
       * appropriate for the measure.
       */
      public var population: MutableList<Population.Builder> = mutableListOf()

      /**
       * The measure score for this population group, calculated as appropriate for the measure type
       * and scoring method, and based on the contents of the populations defined in the group.
       */
      public var measureScore: MeasureScore? = null

      /**
       * When a measure includes multiple stratifiers, there will be a stratifier group for each
       * stratifier defined by the measure.
       */
      public var stratifier: MutableList<Stratifier.Builder> = mutableListOf()

      public fun build(): Group =
        Group(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          linkId = linkId?.build(),
          code = code?.build(),
          subject = subject?.build(),
          population = population.map { it.build() },
          measureScore = measureScore,
          stratifier = stratifier.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The MeasureReport status. No data will be available until the MeasureReport status is
     * complete.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<MeasureReportStatus>,
    /**
     * The type of measure report. This may be an individual report, which provides the score for
     * the measure for an individual member of the population; a subject-listing, which returns the
     * list of members that meet the various criteria in the measure; a summary report, which
     * returns a population count for each of the criteria in the measure; or a data-collection,
     * which enables the MeasureReport to be used to exchange the data-of-interest for a quality
     * measure.
     *
     * Data-exchange reports are used only to communicate data-of-interest for a measure. They do
     * not necessarily include all the data for a particular subject or population, but they may.
     */
    public var type: Enumeration<MeasureReportType>,
    /** The reporting period for which the report was calculated. */
    public var period: Period.Builder,
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
     * A formal identifier that is used to identify this MeasureReport when it is represented in
     * other formats or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II data type - e.g. to
     * identify this {{title}} outside of FHIR, where the logical URL is not possible to use.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Indicates whether the data submitted in a data-exchange report represents a snapshot or
     * incremental update. A snapshot update replaces all previously submitted data for the
     * receiver, whereas an incremental update represents only updated and/or changed data and
     * should be applied as a differential update to the existing submitted data for the receiver.
     *
     * This element only applies to Data-collection reports used to communicate the data-of-interest
     * for a measure
     */
    public var dataUpdateType: Enumeration<SubmitDataUpdateType>? = null

    /** A reference to the Measure that was calculated to produce this report. */
    public var measure: Canonical.Builder? = null

    /** Optional subject identifying the individual or individuals the report is for. */
    public var subject: Reference.Builder? = null

    /** The date this measure was calculated. */
    public var date: DateTime.Builder? = null

    /** The individual or organization that is reporting the data. */
    public var reporter: Reference.Builder? = null

    /**
     * A reference to the vendor who queried the data, calculated results and/or generated the
     * report. The ‘reporting vendor’ is intended to represent the submitting entity when it is not
     * the same as the reporting entity. This extension is used when the Receiver is interested in
     * getting vendor information in the report.
     */
    public var reportingVendor: Reference.Builder? = null

    /** A reference to the location for which the data is being reported. */
    public var location: Reference.Builder? = null

    /**
     * A reference to a Parameters resource (typically represented using a contained resource) that
     * represents any input parameters that were provided to the operation that generated the
     * report.
     *
     * Whenever an operation returns a MeasureReport, the IN parameters from that operation can be
     * returned to the caller of the operation using MeasureReport.inputParameters. Operations
     * include but are not limited to $evaluate-measure, $care-gaps, $data-requirements, and
     * $collect-data. The inputParameters can also be used in a MeasureReport used to define a test
     * case (i.e., not as a result of an operation).
     */
    public var inputParameters: Reference.Builder? = null

    /**
     * Indicates how the calculation is performed for the measure, including proportion, ratio,
     * continuous-variable, and cohort. The value set is extensible, allowing additional measure
     * scoring types to be represented. It is expected to be the same as the scoring element on the
     * referenced Measure.
     */
    public var scoring: CodeableConcept.Builder? = null

    /**
     * Whether improvement in the measure is noted by an increase or decrease in the measure score.
     *
     * This element is typically defined by the measure, but reproduced here to ensure the measure
     * score can be interpreted. The element is labeled as a modifier because it changes the
     * interpretation of the reported measure score. Note also that a MeasureReport instance
     * includes the improvementNotation as defined by the Measure being reported. It is duplicated
     * in the MeasureReport because it is a critical aspect of interpreting the measure score but it
     * is not intended to reflect whether the measure report is an increase or decrease. It helps
     * interpret if the measure score is an increase or decrease, I.e., moving in the direction of
     * the desired outcome.
     */
    public var improvementNotation: CodeableConcept.Builder? = null

    /** The results of the calculation, one for each population group in the measure. */
    public var group: MutableList<Group.Builder> = mutableListOf()

    /**
     * A reference to a Resource that represents additional information collected for the report. If
     * the value of the supplemental data is not a Resource (i.e. evaluating the supplementalData
     * expression for this case in the measure results in a value that is not a FHIR Resource), it
     * is reported as a reference to a contained Observation resource.
     *
     * For individual measure reports, the supplementalData elements represent the direct result of
     * evaluating the supplementalData expression for the subject of the report. For summary
     * reports, supplementalData is reported as references to contained Observation resources that
     * represent the number of times each value appeared as a supplementalData result for members of
     * the population.
     */
    public var supplementalData: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Evaluated resources are used to capture what data was involved in the calculation of a
     * measure. This usage is only allowed for individual reports to ensure that the size of the
     * MeasureReport resource is bounded.
     *
     * Evaluated resources are only reported for individual reports.
     */
    public var evaluatedResource: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): MeasureReport =
      MeasureReport(
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
        type = type,
        dataUpdateType = dataUpdateType,
        measure = measure?.build(),
        subject = subject?.build(),
        date = date?.build(),
        reporter = reporter?.build(),
        reportingVendor = reportingVendor?.build(),
        location = location?.build(),
        period = period.build(),
        inputParameters = inputParameters?.build(),
        scoring = scoring?.build(),
        improvementNotation = improvementNotation?.build(),
        group = group.map { it.build() },
        supplementalData = supplementalData.map { it.build() },
        evaluatedResource = evaluatedResource.map { it.build() },
      )
  }

  /** The status of the measure report. */
  public enum class MeasureReportStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Complete("complete", "http://hl7.org/fhir/measure-report-status", "Complete"),
    Pending("pending", "http://hl7.org/fhir/measure-report-status", "Pending"),
    Error("error", "http://hl7.org/fhir/measure-report-status", "Error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): MeasureReportStatus =
        when (code) {
          "complete" -> Complete
          "pending" -> Pending
          "error" -> Error
          else -> throw IllegalArgumentException("Unknown code $code for enum MeasureReportStatus")
        }
    }
  }

  /** The type of the measure report. */
  public enum class MeasureReportType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Individual("individual", "http://hl7.org/fhir/measure-report-type", "Individual"),
    Subject_List("subject-list", "http://hl7.org/fhir/measure-report-type", "Subject List"),
    Summary("summary", "http://hl7.org/fhir/measure-report-type", "Summary"),
    Data_Exchange("data-exchange", "http://hl7.org/fhir/measure-report-type", "Data Exchange");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): MeasureReportType =
        when (code) {
          "individual" -> Individual
          "subject-list" -> Subject_List
          "summary" -> Summary
          "data-exchange" -> Data_Exchange
          else -> throw IllegalArgumentException("Unknown code $code for enum MeasureReportType")
        }
    }
  }

  /**
   * Concepts for how a measure report consumer and receiver coordinate data exchange updates. The
   * choices are snapshot or incremental updates
   */
  public enum class SubmitDataUpdateType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Incremental(
      "incremental",
      "http://hl7.org/fhir/CodeSystem/submit-data-update-type",
      "Incremental",
    ),
    Snapshot("snapshot", "http://hl7.org/fhir/CodeSystem/submit-data-update-type", "Snapshot");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SubmitDataUpdateType =
        when (code) {
          "incremental" -> Incremental
          "snapshot" -> Snapshot
          else -> throw IllegalArgumentException("Unknown code $code for enum SubmitDataUpdateType")
        }
    }
  }
}
