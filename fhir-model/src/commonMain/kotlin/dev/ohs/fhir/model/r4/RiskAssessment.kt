/*
 * Copyright 2026 Google LLC
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

import dev.ohs.fhir.model.r4.serializers.RiskAssessmentOccurrenceSerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentPredictionProbabilitySerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentPredictionSerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentPredictionWhenSerializer
import dev.ohs.fhir.model.r4.serializers.RiskAssessmentSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood
 * of each outcome.
 */
@Serializable(with = RiskAssessmentSerializer::class)
@SerialName("RiskAssessment")
public data class RiskAssessment(
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
  /** Business identifier assigned to the risk assessment. */
  public val identifier: List<Identifier> = listOf(),
  /** A reference to the request that is fulfilled by this risk assessment. */
  public val basedOn: Reference? = null,
  /** A reference to a resource that this risk assessment is part of, such as a Procedure. */
  public val parent: Reference? = null,
  /** The status of the RiskAssessment, using the same statuses as an Observation. */
  public val status: Enumeration<ObservationStatus>,
  /** The algorithm, process or mechanism used to evaluate the risk. */
  public val method: CodeableConcept? = null,
  /** The type of the risk assessment performed. */
  public val code: CodeableConcept? = null,
  /** The patient or group the risk assessment applies to. */
  public val subject: Reference,
  /** The encounter where the assessment was performed. */
  public val encounter: Reference? = null,
  /** The date (and possibly time) the risk assessment was performed. */
  public val occurrence: Occurrence? = null,
  /**
   * For assessments or prognosis specific to a particular condition, indicates the condition being
   * assessed.
   */
  public val condition: Reference? = null,
  /** The provider or software application that performed the assessment. */
  public val performer: Reference? = null,
  /** The reason the risk assessment was performed. */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Resources supporting the reason the risk assessment was performed. */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Indicates the source data considered as part of the assessment (for example, FamilyHistory,
   * Observations, Procedures, Conditions, etc.).
   */
  public val basis: List<Reference> = listOf(),
  /**
   * Describes the expected outcome for the subject.
   *
   * Multiple repetitions can be used to identify the same type of outcome in different timeframes
   * as well as different types of outcomes.
   */
  public val prediction: List<Prediction> = listOf(),
  /** A description of the steps that might be taken to reduce the identified risk(s). */
  public val mitigation: String? = null,
  /** Additional comments about the risk assessment. */
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
        basedOn = this@with.basedOn?.toBuilder()
        parent = this@with.parent?.toBuilder()
        method = this@with.method?.toBuilder()
        code = this@with.code?.toBuilder()
        encounter = this@with.encounter?.toBuilder()
        occurrence = this@with.occurrence
        condition = this@with.condition?.toBuilder()
        performer = this@with.performer?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        basis = this@with.basis.map { it.toBuilder() }.toMutableList()
        prediction = this@with.prediction.map { it.toBuilder() }.toMutableList()
        mitigation = this@with.mitigation?.toBuilder()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Describes the expected outcome for the subject. */
  @Serializable(with = RiskAssessmentPredictionSerializer::class)
  public data class Prediction(
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
     * One of the potential outcomes for the patient (e.g. remission, death, a particular
     * condition).
     */
    public val outcome: CodeableConcept? = null,
    /**
     * Indicates how likely the outcome is (in the specified timeframe).
     *
     * If range is used, it represents the lower and upper bounds of certainty; e.g. 40-60% Decimal
     * values are expressed as percentages as well (max = 100).
     */
    public val probability: Probability? = null,
    /**
     * Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative
     * value (e.g. low, medium, or high).
     */
    public val qualitativeRisk: CodeableConcept? = null,
    /**
     * Indicates the risk for this particular subject (with their specific characteristics) divided
     * by the risk of the population in general. (Numbers greater than 1 = higher risk than the
     * population, numbers less than 1 = lower risk.).
     */
    public val relativeRisk: Decimal? = null,
    /**
     * Indicates the period of time or age range of the subject to which the specified probability
     * applies.
     *
     * If not specified, the risk applies "over the subject's lifespan".
     */
    public val `when`: When? = null,
    /** Additional information explaining the basis for the prediction. */
    public val rationale: String? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          outcome = this@with.outcome?.toBuilder()
          probability = this@with.probability
          qualitativeRisk = this@with.qualitativeRisk?.toBuilder()
          relativeRisk = this@with.relativeRisk?.toBuilder()
          `when` = this@with.`when`
          rationale = this@with.rationale?.toBuilder()
        }
      }

    @Serializable(with = RiskAssessmentPredictionProbabilitySerializer::class)
    public sealed interface Probability {
      public fun asDecimal(): Decimal? = this as? Decimal

      public fun asRange(): Range? = this as? Range

      public data class Decimal(public val `value`: dev.ohs.fhir.model.r4.Decimal) : Probability

      public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) : Probability

      public companion object {
        internal fun from(
          decimalValue: dev.ohs.fhir.model.r4.Decimal?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
        ): Probability? {
          if (decimalValue != null) return Decimal(decimalValue)
          if (rangeValue != null) return Range(rangeValue)
          return null
        }
      }
    }

    @Serializable(with = RiskAssessmentPredictionWhenSerializer::class)
    public sealed interface When {
      public fun asPeriod(): Period? = this as? Period

      public fun asRange(): Range? = this as? Range

      public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : When

      public data class Range(public val `value`: dev.ohs.fhir.model.r4.Range) : When

      public companion object {
        internal fun from(
          periodValue: dev.ohs.fhir.model.r4.Period?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
        ): When? {
          if (periodValue != null) return Period(periodValue)
          if (rangeValue != null) return Range(rangeValue)
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
       * One of the potential outcomes for the patient (e.g. remission, death, a particular
       * condition).
       */
      public var outcome: CodeableConcept.Builder? = null

      /**
       * Indicates how likely the outcome is (in the specified timeframe).
       *
       * If range is used, it represents the lower and upper bounds of certainty; e.g. 40-60%
       * Decimal values are expressed as percentages as well (max = 100).
       */
      public var probability: Probability? = null

      /**
       * Indicates how likely the outcome is (in the specified timeframe), expressed as a
       * qualitative value (e.g. low, medium, or high).
       */
      public var qualitativeRisk: CodeableConcept.Builder? = null

      /**
       * Indicates the risk for this particular subject (with their specific characteristics)
       * divided by the risk of the population in general. (Numbers greater than 1 = higher risk
       * than the population, numbers less than 1 = lower risk.).
       */
      public var relativeRisk: Decimal.Builder? = null

      /**
       * Indicates the period of time or age range of the subject to which the specified probability
       * applies.
       *
       * If not specified, the risk applies "over the subject's lifespan".
       */
      public var `when`: When? = null

      /** Additional information explaining the basis for the prediction. */
      public var rationale: String.Builder? = null

      public fun build(): Prediction =
        Prediction(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          outcome = outcome?.build(),
          probability = probability,
          qualitativeRisk = qualitativeRisk?.build(),
          relativeRisk = relativeRisk?.build(),
          `when` = `when`,
          rationale = rationale?.build(),
        )
    }
  }

  @Serializable(with = RiskAssessmentOccurrenceSerializer::class)
  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Occurrence

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public class Builder(
    /** The status of the RiskAssessment, using the same statuses as an Observation. */
    public var status: Enumeration<ObservationStatus>,
    /** The patient or group the risk assessment applies to. */
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

    /** Business identifier assigned to the risk assessment. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A reference to the request that is fulfilled by this risk assessment. */
    public var basedOn: Reference.Builder? = null

    /** A reference to a resource that this risk assessment is part of, such as a Procedure. */
    public var parent: Reference.Builder? = null

    /** The algorithm, process or mechanism used to evaluate the risk. */
    public var method: CodeableConcept.Builder? = null

    /** The type of the risk assessment performed. */
    public var code: CodeableConcept.Builder? = null

    /** The encounter where the assessment was performed. */
    public var encounter: Reference.Builder? = null

    /** The date (and possibly time) the risk assessment was performed. */
    public var occurrence: Occurrence? = null

    /**
     * For assessments or prognosis specific to a particular condition, indicates the condition
     * being assessed.
     */
    public var condition: Reference.Builder? = null

    /** The provider or software application that performed the assessment. */
    public var performer: Reference.Builder? = null

    /** The reason the risk assessment was performed. */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Resources supporting the reason the risk assessment was performed. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Indicates the source data considered as part of the assessment (for example, FamilyHistory,
     * Observations, Procedures, Conditions, etc.).
     */
    public var basis: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Describes the expected outcome for the subject.
     *
     * Multiple repetitions can be used to identify the same type of outcome in different timeframes
     * as well as different types of outcomes.
     */
    public var prediction: MutableList<Prediction.Builder> = mutableListOf()

    /** A description of the steps that might be taken to reduce the identified risk(s). */
    public var mitigation: String.Builder? = null

    /** Additional comments about the risk assessment. */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): RiskAssessment =
      RiskAssessment(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        basedOn = basedOn?.build(),
        parent = parent?.build(),
        status = status,
        method = method?.build(),
        code = code?.build(),
        subject = subject.build(),
        encounter = encounter?.build(),
        occurrence = occurrence,
        condition = condition?.build(),
        performer = performer?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        basis = basis.map { it.build() },
        prediction = prediction.map { it.build() },
        mitigation = mitigation?.build(),
        note = note.map { it.build() },
      )
  }

  /** Codes providing the status of an observation. */
  public enum class ObservationStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Registered("registered", "http://hl7.org/fhir/observation-status", "Registered"),
    Preliminary("preliminary", "http://hl7.org/fhir/observation-status", "Preliminary"),
    Final("final", "http://hl7.org/fhir/observation-status", "Final"),
    Amended("amended", "http://hl7.org/fhir/observation-status", "Amended"),
    Corrected("corrected", "http://hl7.org/fhir/observation-status", "Corrected"),
    Cancelled("cancelled", "http://hl7.org/fhir/observation-status", "Cancelled"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/observation-status",
      "Entered in Error",
    ),
    Unknown("unknown", "http://hl7.org/fhir/observation-status", "Unknown");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ObservationStatus =
        when (code) {
          "registered" -> Registered
          "preliminary" -> Preliminary
          "final" -> Final
          "amended" -> Amended
          "corrected" -> Corrected
          "cancelled" -> Cancelled
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum ObservationStatus")
        }
    }
  }
}
