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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupPopulationSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupStratifierSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupStratifierStratumComponentSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupStratifierStratumPopulationSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportGroupStratifierStratumSerializer
import dev.ohs.fhir.model.r4.serializers.MeasureReportSerializer
import dev.ohs.fhir.model.r4.terminologies.MeasureReportStatus
import dev.ohs.fhir.model.r4.terminologies.MeasureReportType
import kotlin.String
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
   * Data-collection reports are used only to communicate data-of-interest for a measure. They do
   * not necessarily include all the data for a particular subject or population, but they may.
   */
  public val type: Enumeration<MeasureReportType>,
  /** A reference to the Measure that was calculated to produce this report. */
  public val measure: Canonical,
  /** Optional subject identifying the individual or individuals the report is for. */
  public val subject: Reference? = null,
  /** The date this measure report was generated. */
  public val date: DateTime? = null,
  /** The individual, location, or organization that is reporting the data. */
  public val reporter: Reference? = null,
  /** The reporting period for which the report was calculated. */
  public val period: Period,
  /**
   * Whether improvement in the measure is noted by an increase or decrease in the measure score.
   *
   * This element is typically defined by the measure, but reproduced here to ensure the measure
   * score can be interpreted. The element is labeled as a modifier because it changes the
   * interpretation of the reported measure score.
   */
  public val improvementNotation: CodeableConcept? = null,
  /** The results of the calculation, one for each population group in the measure. */
  public val group: List<Group> = listOf(),
  /**
   * A reference to a Bundle containing the Resources that were used in the calculation of this
   * measure.
   */
  public val evaluatedResource: List<Reference> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder {
    val builder =
      Builder(
        status,
        type,
        measure.toBuilder(),
        period.toBuilder(),
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
    builder.subject = subject?.toBuilder()
    builder.date = date?.toBuilder()
    builder.reporter = reporter?.toBuilder()
    builder.improvementNotation = improvementNotation?.toBuilder()
    builder.group = group.toBuilderList()
    builder.evaluatedResource = evaluatedResource.toBuilderList()
    return builder
  }

  /** The results of the calculation, one for each population group in the measure. */
  @Serializable(with = MeasureReportGroupSerializer::class)
  public data class Group(
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
    /** The meaning of the population group as defined in the measure definition. */
    public val code: CodeableConcept? = null,
    /**
     * The populations that make up the population group, one for each type of population
     * appropriate for the measure.
     */
    public val population: List<Population> = listOf(),
    /**
     * The measure score for this population group, calculated as appropriate for the measure type
     * and scoring method, and based on the contents of the populations defined in the group.
     */
    public val measureScore: Quantity? = null,
    /**
     * When a measure includes multiple stratifiers, there will be a stratifier group for each
     * stratifier defined by the measure.
     */
    public val stratifier: List<Stratifier> = listOf(),
  ) : BackboneElement(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.modifierExtension = modifierExtension.toBuilderList()
      builder.code = code?.toBuilder()
      builder.population = population.toBuilderList()
      builder.measureScore = measureScore?.toBuilder()
      builder.stratifier = stratifier.toBuilderList()
      return builder
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
      override val id: String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The type of the population. */
      public val code: CodeableConcept? = null,
      /** The number of members of the population. */
      public val count: Integer? = null,
      /**
       * This element refers to a List of subject level MeasureReport resources, one for each
       * subject in this population.
       */
      public val subjectResults: Reference? = null,
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.code = code?.toBuilder()
        builder.count = count?.toBuilder()
        builder.subjectResults = subjectResults?.toBuilder()
        return builder
      }

      public class Builder() : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /** The type of the population. */
        public var code: CodeableConcept.Builder? = null

        /** The number of members of the population. */
        public var count: Integer.Builder? = null

        /**
         * This element refers to a List of subject level MeasureReport resources, one for each
         * subject in this population.
         */
        public var subjectResults: Reference.Builder? = null

        override fun build(): Population =
          Population(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            code = code?.build(),
            count = count?.build(),
            subjectResults = subjectResults?.build(),
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
      override val id: String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The meaning of this stratifier, as defined in the measure definition. */
      public val code: List<CodeableConcept> = listOf(),
      /**
       * This element contains the results for a single stratum within the stratifier. For example,
       * when stratifying on administrative gender, there will be four strata, one for each possible
       * gender value.
       */
      public val stratum: List<Stratum> = listOf(),
    ) : BackboneElement(), FhirBuildable {
      override fun toBuilder(): Builder {
        val builder = Builder()
        builder.id = id
        builder.extension = extension.toBuilderList()
        builder.modifierExtension = modifierExtension.toBuilderList()
        builder.code = code.toBuilderList()
        builder.stratum = stratum.toBuilderList()
        return builder
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
        override val id: String? = null,
        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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
        public val `value`: CodeableConcept? = null,
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
        public val measureScore: Quantity? = null,
      ) : BackboneElement(), FhirBuildable {
        override fun toBuilder(): Builder {
          val builder = Builder()
          builder.id = id
          builder.extension = extension.toBuilderList()
          builder.modifierExtension = modifierExtension.toBuilderList()
          builder.`value` = `value`?.toBuilder()
          builder.component = component.toBuilderList()
          builder.population = population.toBuilderList()
          builder.measureScore = measureScore?.toBuilder()
          return builder
        }

        /** A stratifier component value. */
        @Serializable(with = MeasureReportGroupStratifierStratumComponentSerializer::class)
        public data class Component(
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          override val id: String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and manageable, there is a strict set of governance applied to the
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
          /** The code for the stratum component value. */
          public val code: CodeableConcept,
          /** The stratum component value. */
          public val `value`: CodeableConcept,
        ) : BackboneElement(), FhirBuildable {
          override fun toBuilder(): Builder {
            val builder = Builder(code.toBuilder(), `value`.toBuilder())
            builder.id = id
            builder.extension = extension.toBuilderList()
            builder.modifierExtension = modifierExtension.toBuilderList()
            return builder
          }

          public class Builder(
            /** The code for the stratum component value. */
            public var code: CodeableConcept.Builder,
            /** The stratum component value. */
            public var `value`: CodeableConcept.Builder,
          ) : FhirBuilder {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and manageable, there
             * is a strict set of governance applied to the definition and use of extensions. Though
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
             * extensions safe and manageable, there is a strict set of governance applied to the
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

            override fun build(): Component =
              Component(
                id = id,
                extension = extension.buildList(),
                modifierExtension = modifierExtension.buildList(),
                code = code.build(),
                `value` = `value`.build(),
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
          override val id: String? = null,
          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and manageable, there is a strict set of governance applied to the
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
          /** The type of the population. */
          public val code: CodeableConcept? = null,
          /** The number of members of the population in this stratum. */
          public val count: Integer? = null,
          /**
           * This element refers to a List of subject level MeasureReport resources, one for each
           * subject in this population in this stratum.
           */
          public val subjectResults: Reference? = null,
        ) : BackboneElement(), FhirBuildable {
          override fun toBuilder(): Builder {
            val builder = Builder()
            builder.id = id
            builder.extension = extension.toBuilderList()
            builder.modifierExtension = modifierExtension.toBuilderList()
            builder.code = code?.toBuilder()
            builder.count = count?.toBuilder()
            builder.subjectResults = subjectResults?.toBuilder()
            return builder
          }

          public class Builder() : FhirBuilder {
            /**
             * Unique id for the element within a resource (for internal references). This may be
             * any string value that does not contain spaces.
             */
            public var id: String? = null

            /**
             * May be used to represent additional information that is not part of the basic
             * definition of the element. To make the use of extensions safe and manageable, there
             * is a strict set of governance applied to the definition and use of extensions. Though
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
             * extensions safe and manageable, there is a strict set of governance applied to the
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

            /** The type of the population. */
            public var code: CodeableConcept.Builder? = null

            /** The number of members of the population in this stratum. */
            public var count: Integer.Builder? = null

            /**
             * This element refers to a List of subject level MeasureReport resources, one for each
             * subject in this population in this stratum.
             */
            public var subjectResults: Reference.Builder? = null

            override fun build(): Population =
              Population(
                id = id,
                extension = extension.buildList(),
                modifierExtension = modifierExtension.buildList(),
                code = code?.build(),
                count = count?.build(),
                subjectResults = subjectResults?.build(),
              )
          }
        }

        public class Builder() : FhirBuilder {
          /**
           * Unique id for the element within a resource (for internal references). This may be any
           * string value that does not contain spaces.
           */
          public var id: String? = null

          /**
           * May be used to represent additional information that is not part of the basic
           * definition of the element. To make the use of extensions safe and manageable, there is
           * a strict set of governance applied to the definition and use of extensions. Though any
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
           * extensions safe and manageable, there is a strict set of governance applied to the
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
          public var `value`: CodeableConcept.Builder? = null

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
          public var measureScore: Quantity.Builder? = null

          override fun build(): Stratum =
            Stratum(
              id = id,
              extension = extension.buildList(),
              modifierExtension = modifierExtension.buildList(),
              `value` = `value`?.build(),
              component = component.buildList(),
              population = population.buildList(),
              measureScore = measureScore?.build(),
            )
        }
      }

      public class Builder() : FhirBuilder {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /** The meaning of this stratifier, as defined in the measure definition. */
        public var code: MutableList<CodeableConcept.Builder> = mutableListOf()

        /**
         * This element contains the results for a single stratum within the stratifier. For
         * example, when stratifying on administrative gender, there will be four strata, one for
         * each possible gender value.
         */
        public var stratum: MutableList<Stratum.Builder> = mutableListOf()

        override fun build(): Stratifier =
          Stratifier(
            id = id,
            extension = extension.buildList(),
            modifierExtension = modifierExtension.buildList(),
            code = code.buildList(),
            stratum = stratum.buildList(),
          )
      }
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

      /** The meaning of the population group as defined in the measure definition. */
      public var code: CodeableConcept.Builder? = null

      /**
       * The populations that make up the population group, one for each type of population
       * appropriate for the measure.
       */
      public var population: MutableList<Population.Builder> = mutableListOf()

      /**
       * The measure score for this population group, calculated as appropriate for the measure type
       * and scoring method, and based on the contents of the populations defined in the group.
       */
      public var measureScore: Quantity.Builder? = null

      /**
       * When a measure includes multiple stratifiers, there will be a stratifier group for each
       * stratifier defined by the measure.
       */
      public var stratifier: MutableList<Stratifier.Builder> = mutableListOf()

      override fun build(): Group =
        Group(
          id = id,
          extension = extension.buildList(),
          modifierExtension = modifierExtension.buildList(),
          code = code?.build(),
          population = population.buildList(),
          measureScore = measureScore?.build(),
          stratifier = stratifier.buildList(),
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
     * Data-collection reports are used only to communicate data-of-interest for a measure. They do
     * not necessarily include all the data for a particular subject or population, but they may.
     */
    public var type: Enumeration<MeasureReportType>,
    /** A reference to the Measure that was calculated to produce this report. */
    public var measure: Canonical.Builder,
    /** The reporting period for which the report was calculated. */
    public var period: Period.Builder,
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

    /**
     * A formal identifier that is used to identify this MeasureReport when it is represented in
     * other formats or referenced in a specification, model, design or an instance.
     *
     * Typically, this is used for identifiers that can go in an HL7 V3 II data type - e.g. to
     * identify this {{title}} outside of FHIR, where the logical URL is not possible to use.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Optional subject identifying the individual or individuals the report is for. */
    public var subject: Reference.Builder? = null

    /** The date this measure report was generated. */
    public var date: DateTime.Builder? = null

    /** The individual, location, or organization that is reporting the data. */
    public var reporter: Reference.Builder? = null

    /**
     * Whether improvement in the measure is noted by an increase or decrease in the measure score.
     *
     * This element is typically defined by the measure, but reproduced here to ensure the measure
     * score can be interpreted. The element is labeled as a modifier because it changes the
     * interpretation of the reported measure score.
     */
    public var improvementNotation: CodeableConcept.Builder? = null

    /** The results of the calculation, one for each population group in the measure. */
    public var group: MutableList<Group.Builder> = mutableListOf()

    /**
     * A reference to a Bundle containing the Resources that were used in the calculation of this
     * measure.
     */
    public var evaluatedResource: MutableList<Reference.Builder> = mutableListOf()

    override fun build(): MeasureReport =
      MeasureReport(
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
        type = type,
        measure = measure.build(),
        subject = subject?.build(),
        date = date?.build(),
        reporter = reporter?.build(),
        period = period.build(),
        improvementNotation = improvementNotation?.build(),
        group = group.buildList(),
        evaluatedResource = evaluatedResource.buildList(),
      )
  }
}
