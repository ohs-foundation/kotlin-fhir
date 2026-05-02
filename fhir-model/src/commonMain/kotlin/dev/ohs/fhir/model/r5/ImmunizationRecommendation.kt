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

import dev.ohs.fhir.model.r5.serializers.ImmunizationRecommendationRecommendationDateCriterionSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationRecommendationRecommendationSerializer
import dev.ohs.fhir.model.r5.serializers.ImmunizationRecommendationSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published
 * schedule with optional supporting justification.
 */
@Serializable(with = ImmunizationRecommendationSerializer::class)
@SerialName("ImmunizationRecommendation")
public data class ImmunizationRecommendation(
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
  /** A unique identifier assigned to this particular recommendation record. */
  public val identifier: List<Identifier> = listOf(),
  /** The patient the recommendation(s) are for. */
  public val patient: Reference,
  /** The date the immunization recommendation(s) were created. */
  public val date: DateTime,
  /** Indicates the authority who published the protocol (e.g. ACIP). */
  public val authority: Reference? = null,
  /**
   * Vaccine administration recommendations.
   *
   * A given instance of the .recommendation backbone element should correspond to a single
   * recommended administration.
   */
  public val recommendation: List<Recommendation>,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          patient.toBuilder(),
          date.toBuilder(),
          recommendation.map { it.toBuilder() }.toMutableList(),
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
          authority = this@with.authority?.toBuilder()
        }
    }

  /** Vaccine administration recommendations. */
  @Serializable(with = ImmunizationRecommendationRecommendationSerializer::class)
  public data class Recommendation(
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
    /** Vaccine(s) or vaccine group that pertain to the recommendation. */
    public val vaccineCode: List<CodeableConcept> = listOf(),
    /**
     * The targeted disease for the recommendation.
     *
     * A given instance of the .recommendation backbone element should correspond to a single
     * recommended administration but sometimes that administration (e.g. MMR) will encompass
     * multiple diseases, thus the targetDisease element is allowed to repeat.
     */
    public val targetDisease: List<CodeableConcept> = listOf(),
    /** Vaccine(s) which should not be used to fulfill the recommendation. */
    public val contraindicatedVaccineCode: List<CodeableConcept> = listOf(),
    /** Indicates the patient status with respect to the path to immunity for the target disease. */
    public val forecastStatus: CodeableConcept,
    /** The reason for the assigned forecast status. */
    public val forecastReason: List<CodeableConcept> = listOf(),
    /**
     * Vaccine date recommendations. For example, earliest date to administer, latest date to
     * administer, etc.
     */
    public val dateCriterion: List<DateCriterion> = listOf(),
    /** Contains the description about the protocol under which the vaccine was administered. */
    public val description: Markdown? = null,
    /**
     * One possible path to achieve presumed immunity against a disease - within the context of an
     * authority.
     */
    public val series: String? = null,
    /**
     * Nominal position of the recommended dose in a series as determined by the evaluation and
     * forecasting process (e.g. dose 2 is the next recommended dose).
     *
     * The use of an integer is preferred if known. A string should only be used in cases where an
     * integer is not available (such as when documenting a recurring booster dose).
     */
    public val doseNumber: String? = null,
    /**
     * The recommended number of doses to achieve immunity as determined by the evaluation and
     * forecasting process.
     *
     * The use of an integer is preferred if known.
     */
    public val seriesDoses: String? = null,
    /** Immunization event history and/or evaluation that supports the status and recommendation. */
    public val supportingImmunization: List<Reference> = listOf(),
    /**
     * Patient Information that supports the status and recommendation. This includes patient
     * observations, adverse reactions and allergy/intolerance information.
     */
    public val supportingPatientInformation: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(forecastStatus.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          vaccineCode = this@with.vaccineCode.map { it.toBuilder() }.toMutableList()
          targetDisease = this@with.targetDisease.map { it.toBuilder() }.toMutableList()
          contraindicatedVaccineCode =
            this@with.contraindicatedVaccineCode.map { it.toBuilder() }.toMutableList()
          forecastReason = this@with.forecastReason.map { it.toBuilder() }.toMutableList()
          dateCriterion = this@with.dateCriterion.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          series = this@with.series?.toBuilder()
          doseNumber = this@with.doseNumber?.toBuilder()
          seriesDoses = this@with.seriesDoses?.toBuilder()
          supportingImmunization =
            this@with.supportingImmunization.map { it.toBuilder() }.toMutableList()
          supportingPatientInformation =
            this@with.supportingPatientInformation.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Vaccine date recommendations. For example, earliest date to administer, latest date to
     * administer, etc.
     */
    @Serializable(with = ImmunizationRecommendationRecommendationDateCriterionSerializer::class)
    public data class DateCriterion(
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
       * Date classification of recommendation. For example, earliest date to give, latest date to
       * give, etc.
       */
      public val code: CodeableConcept,
      /** The date whose meaning is specified by dateCriterion.code. */
      public val `value`: DateTime,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(code.toBuilder(), `value`.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public class Builder(
        /**
         * Date classification of recommendation. For example, earliest date to give, latest date to
         * give, etc.
         */
        public var code: CodeableConcept.Builder,
        /** The date whose meaning is specified by dateCriterion.code. */
        public var `value`: DateTime.Builder,
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

        public fun build(): DateCriterion =
          DateCriterion(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            code = code.build(),
            `value` = `value`.build(),
          )
      }
    }

    public class Builder(
      /**
       * Indicates the patient status with respect to the path to immunity for the target disease.
       */
      public var forecastStatus: CodeableConcept.Builder
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

      /** Vaccine(s) or vaccine group that pertain to the recommendation. */
      public var vaccineCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The targeted disease for the recommendation.
       *
       * A given instance of the .recommendation backbone element should correspond to a single
       * recommended administration but sometimes that administration (e.g. MMR) will encompass
       * multiple diseases, thus the targetDisease element is allowed to repeat.
       */
      public var targetDisease: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** Vaccine(s) which should not be used to fulfill the recommendation. */
      public var contraindicatedVaccineCode: MutableList<CodeableConcept.Builder> = mutableListOf()

      /** The reason for the assigned forecast status. */
      public var forecastReason: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Vaccine date recommendations. For example, earliest date to administer, latest date to
       * administer, etc.
       */
      public var dateCriterion: MutableList<DateCriterion.Builder> = mutableListOf()

      /** Contains the description about the protocol under which the vaccine was administered. */
      public var description: Markdown.Builder? = null

      /**
       * One possible path to achieve presumed immunity against a disease - within the context of an
       * authority.
       */
      public var series: String.Builder? = null

      /**
       * Nominal position of the recommended dose in a series as determined by the evaluation and
       * forecasting process (e.g. dose 2 is the next recommended dose).
       *
       * The use of an integer is preferred if known. A string should only be used in cases where an
       * integer is not available (such as when documenting a recurring booster dose).
       */
      public var doseNumber: String.Builder? = null

      /**
       * The recommended number of doses to achieve immunity as determined by the evaluation and
       * forecasting process.
       *
       * The use of an integer is preferred if known.
       */
      public var seriesDoses: String.Builder? = null

      /**
       * Immunization event history and/or evaluation that supports the status and recommendation.
       */
      public var supportingImmunization: MutableList<Reference.Builder> = mutableListOf()

      /**
       * Patient Information that supports the status and recommendation. This includes patient
       * observations, adverse reactions and allergy/intolerance information.
       */
      public var supportingPatientInformation: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): Recommendation =
        Recommendation(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          vaccineCode = vaccineCode.map { it.build() },
          targetDisease = targetDisease.map { it.build() },
          contraindicatedVaccineCode = contraindicatedVaccineCode.map { it.build() },
          forecastStatus = forecastStatus.build(),
          forecastReason = forecastReason.map { it.build() },
          dateCriterion = dateCriterion.map { it.build() },
          description = description?.build(),
          series = series?.build(),
          doseNumber = doseNumber?.build(),
          seriesDoses = seriesDoses?.build(),
          supportingImmunization = supportingImmunization.map { it.build() },
          supportingPatientInformation = supportingPatientInformation.map { it.build() },
        )
    }
  }

  public class Builder(
    /** The patient the recommendation(s) are for. */
    public var patient: Reference.Builder,
    /** The date the immunization recommendation(s) were created. */
    public var date: DateTime.Builder,
    /**
     * Vaccine administration recommendations.
     *
     * A given instance of the .recommendation backbone element should correspond to a single
     * recommended administration.
     */
    public var recommendation: MutableList<Recommendation.Builder>,
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

    /** A unique identifier assigned to this particular recommendation record. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** Indicates the authority who published the protocol (e.g. ACIP). */
    public var authority: Reference.Builder? = null

    override fun build(): ImmunizationRecommendation =
      ImmunizationRecommendation(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        patient = patient.build(),
        date = date.build(),
        authority = authority?.build(),
        recommendation = recommendation.map { it.build() },
      )
  }
}
