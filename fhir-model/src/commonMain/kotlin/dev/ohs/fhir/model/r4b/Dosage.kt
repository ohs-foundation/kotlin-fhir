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

package com.google.fhir.model.r4b

import com.google.fhir.model.r4b.serializers.DosageAsNeededSerializer
import com.google.fhir.model.r4b.serializers.DosageDoseAndRateDoseSerializer
import com.google.fhir.model.r4b.serializers.DosageDoseAndRateRateSerializer
import com.google.fhir.model.r4b.serializers.DosageDoseAndRateSerializer
import com.google.fhir.model.r4b.serializers.DosageSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Dosage Type: Indicates how the medication is/was taken or should be
 * taken by the patient.
 */
@Serializable(with = DosageSerializer::class)
public data class Dosage(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and manageable, there is a strict set of governance
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
   * element and that modifies the understanding of the element in which it is contained and/or the
   * understanding of the containing element's descendants. Usually modifier elements provide
   * negation or qualification. To make the use of extensions safe and manageable, there is a strict
   * set of governance applied to the definition and use of extensions. Though any implementer can
   * define an extension, there is a set of requirements that SHALL be met as part of the definition
   * of the extension. Applications processing a resource are required to check for modifier
   * extensions.
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
  /** Indicates the order in which the dosage instructions should be applied or interpreted. */
  public val sequence: Integer? = null,
  /** Free text dosage instructions e.g. SIG. */
  public val text: String? = null,
  /**
   * Supplemental instructions to the patient on how to take the medication (e.g. "with meals"
   * or"take half to one hour before food") or warnings for the patient about the medication (e.g.
   * "may cause drowsiness" or "avoid exposure of skin to direct sunlight or sunlamps").
   *
   * Information about administration or preparation of the medication (e.g. "infuse as rapidly as
   * possibly via intraperitoneal port" or "immediately following drug x") should be populated in
   * dosage.text.
   */
  public val additionalInstruction: List<CodeableConcept> = listOf(),
  /** Instructions in terms that are understood by the patient or consumer. */
  public val patientInstruction: String? = null,
  /**
   * When medication should be administered.
   *
   * This attribute might not always be populated while the Dosage.text is expected to be populated.
   * If both are populated, then the Dosage.text should reflect the content of the Dosage.timing.
   */
  public val timing: Timing? = null,
  /**
   * Indicates whether the Medication is only taken when needed within a specific dosing schedule
   * (Boolean option), or it indicates the precondition for taking the Medication (CodeableConcept).
   *
   * Can express "as needed" without a reason by setting the Boolean = True. In this case the
   * CodeableConcept is not populated. Or you can express "as needed" with a reason by including the
   * CodeableConcept. In this case the Boolean is assumed to be True. If you set the Boolean to
   * False, then the dose is given according to the schedule and is not "prn" or "as needed".
   */
  public val asNeeded: AsNeeded? = null,
  /**
   * Body site to administer to.
   *
   * If the use case requires attributes from the BodySite resource (e.g. to identify and track
   * separately) then use the standard extension [bodySite](extension-bodysite.html). May be a
   * summary code, or a reference to a very precise definition of the location, or both.
   */
  public val site: CodeableConcept? = null,
  /** How drug should enter body. */
  public val route: CodeableConcept? = null,
  /**
   * Technique for administering medication.
   *
   * Terminologies used often pre-coordinate this term with the route and or form of administration.
   */
  public val method: CodeableConcept? = null,
  /** The amount of medication administered. */
  public val doseAndRate: List<DoseAndRate> = listOf(),
  /**
   * Upper limit on medication per unit of time.
   *
   * This is intended for use as an adjunct to the dosage when there is an upper cap. For example "2
   * tablets every 4 hours to a maximum of 8/day".
   */
  public val maxDosePerPeriod: Ratio? = null,
  /**
   * Upper limit on medication per administration.
   *
   * This is intended for use as an adjunct to the dosage when there is an upper cap. For example, a
   * body surface area related dose with a maximum amount, such as 1.5 mg/m2 (maximum 2 mg) IV over
   * 5 – 10 minutes would have doseQuantity of 1.5 mg/m2 and maxDosePerAdministration of 2 mg.
   */
  public val maxDosePerAdministration: Quantity? = null,
  /** Upper limit on medication per lifetime of the patient. */
  public val maxDosePerLifetime: Quantity? = null,
) : BackboneElement() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        sequence = this@with.sequence?.toBuilder()
        text = this@with.text?.toBuilder()
        additionalInstruction =
          this@with.additionalInstruction.map { it.toBuilder() }.toMutableList()
        patientInstruction = this@with.patientInstruction?.toBuilder()
        timing = this@with.timing?.toBuilder()
        asNeeded = this@with.asNeeded
        site = this@with.site?.toBuilder()
        route = this@with.route?.toBuilder()
        method = this@with.method?.toBuilder()
        doseAndRate = this@with.doseAndRate.map { it.toBuilder() }.toMutableList()
        maxDosePerPeriod = this@with.maxDosePerPeriod?.toBuilder()
        maxDosePerAdministration = this@with.maxDosePerAdministration?.toBuilder()
        maxDosePerLifetime = this@with.maxDosePerLifetime?.toBuilder()
      }
    }

  /** The amount of medication administered. */
  @Serializable(with = DosageDoseAndRateSerializer::class)
  public data class DoseAndRate(
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
    /** The kind of dose or rate specified, for example, ordered or calculated. */
    public val type: CodeableConcept? = null,
    /**
     * Amount of medication per dose.
     *
     * Note that this specifies the quantity of the specified medication, not the quantity for each
     * active ingredient(s). Each ingredient amount can be communicated in the Medication resource.
     * For example, if one wants to communicate that a tablet was 375 mg, where the dose was one
     * tablet, you can use the Medication resource to document that the tablet was comprised of 375
     * mg of drug XYZ. Alternatively if the dose was 375 mg, then you may only need to use the
     * Medication resource to indicate this was a tablet. If the example were an IV such as dopamine
     * and you wanted to communicate that 400mg of dopamine was mixed in 500 ml of some IV solution,
     * then this would all be communicated in the Medication resource. If the administration is not
     * intended to be instantaneous (rate is present or timing has a duration), this can be
     * specified to convey the total amount to be administered over the period of time as indicated
     * by the schedule e.g. 500 ml in dose, with timing used to convey that this should be done over
     * 4 hours.
     */
    public val dose: Dose? = null,
    /**
     * Amount of medication per unit of time.
     *
     * It is possible to supply both a rate and a doseQuantity to provide full details about how the
     * medication is to be administered and supplied. If the rate is intended to change over time,
     * depending on local rules/regulations, each change should be captured as a new version of the
     * MedicationRequest with an updated rate, or captured with a new MedicationRequest with the new
     * rate.
     *
     * It is possible to specify a rate over time (for example, 100 ml/hour) using either the
     * rateRatio and rateQuantity. The rateQuantity approach requires systems to have the capability
     * to parse UCUM grammer where ml/hour is included rather than a specific ratio where the time
     * is specified as the denominator. Where a rate such as 500ml over 2 hours is specified, the
     * use of rateRatio may be more semantically correct than specifying using a rateQuantity of 250
     * mg/hour.
     */
    public val rate: Rate? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          dose = this@with.dose
          rate = this@with.rate
        }
      }

    @Serializable(with = DosageDoseAndRateDoseSerializer::class)
    public sealed interface Dose {
      public fun asRange(): Range? = this as? Range

      public fun asQuantity(): Quantity? = this as? Quantity

      public data class Range(public val `value`: com.google.fhir.model.r4b.Range) : Dose

      public data class Quantity(public val `value`: com.google.fhir.model.r4b.Quantity) : Dose

      public companion object {
        internal fun from(
          rangeValue: com.google.fhir.model.r4b.Range?,
          quantityValue: com.google.fhir.model.r4b.Quantity?,
        ): Dose? {
          if (rangeValue != null) return Range(rangeValue)
          if (quantityValue != null) return Quantity(quantityValue)
          return null
        }
      }
    }

    @Serializable(with = DosageDoseAndRateRateSerializer::class)
    public sealed interface Rate {
      public fun asRatio(): Ratio? = this as? Ratio

      public fun asRange(): Range? = this as? Range

      public fun asQuantity(): Quantity? = this as? Quantity

      public data class Ratio(public val `value`: com.google.fhir.model.r4b.Ratio) : Rate

      public data class Range(public val `value`: com.google.fhir.model.r4b.Range) : Rate

      public data class Quantity(public val `value`: com.google.fhir.model.r4b.Quantity) : Rate

      public companion object {
        internal fun from(
          ratioValue: com.google.fhir.model.r4b.Ratio?,
          rangeValue: com.google.fhir.model.r4b.Range?,
          quantityValue: com.google.fhir.model.r4b.Quantity?,
        ): Rate? {
          if (ratioValue != null) return Ratio(ratioValue)
          if (rangeValue != null) return Range(rangeValue)
          if (quantityValue != null) return Quantity(quantityValue)
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

      /** The kind of dose or rate specified, for example, ordered or calculated. */
      public var type: CodeableConcept.Builder? = null

      /**
       * Amount of medication per dose.
       *
       * Note that this specifies the quantity of the specified medication, not the quantity for
       * each active ingredient(s). Each ingredient amount can be communicated in the Medication
       * resource. For example, if one wants to communicate that a tablet was 375 mg, where the dose
       * was one tablet, you can use the Medication resource to document that the tablet was
       * comprised of 375 mg of drug XYZ. Alternatively if the dose was 375 mg, then you may only
       * need to use the Medication resource to indicate this was a tablet. If the example were an
       * IV such as dopamine and you wanted to communicate that 400mg of dopamine was mixed in 500
       * ml of some IV solution, then this would all be communicated in the Medication resource. If
       * the administration is not intended to be instantaneous (rate is present or timing has a
       * duration), this can be specified to convey the total amount to be administered over the
       * period of time as indicated by the schedule e.g. 500 ml in dose, with timing used to convey
       * that this should be done over 4 hours.
       */
      public var dose: Dose? = null

      /**
       * Amount of medication per unit of time.
       *
       * It is possible to supply both a rate and a doseQuantity to provide full details about how
       * the medication is to be administered and supplied. If the rate is intended to change over
       * time, depending on local rules/regulations, each change should be captured as a new version
       * of the MedicationRequest with an updated rate, or captured with a new MedicationRequest
       * with the new rate.
       *
       * It is possible to specify a rate over time (for example, 100 ml/hour) using either the
       * rateRatio and rateQuantity. The rateQuantity approach requires systems to have the
       * capability to parse UCUM grammer where ml/hour is included rather than a specific ratio
       * where the time is specified as the denominator. Where a rate such as 500ml over 2 hours is
       * specified, the use of rateRatio may be more semantically correct than specifying using a
       * rateQuantity of 250 mg/hour.
       */
      public var rate: Rate? = null

      public fun build(): DoseAndRate =
        DoseAndRate(
          id = id,
          extension = extension.map { it.build() },
          type = type?.build(),
          dose = dose,
          rate = rate,
        )
    }
  }

  @Serializable(with = DosageAsNeededSerializer::class)
  public sealed interface AsNeeded {
    public fun asBoolean(): Boolean? = this as? Boolean

    public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

    public data class Boolean(public val `value`: com.google.fhir.model.r4b.Boolean) : AsNeeded

    public data class CodeableConcept(
      public val `value`: com.google.fhir.model.r4b.CodeableConcept
    ) : AsNeeded

    public companion object {
      internal fun from(
        booleanValue: com.google.fhir.model.r4b.Boolean?,
        codeableConceptValue: com.google.fhir.model.r4b.CodeableConcept?,
      ): AsNeeded? {
        if (booleanValue != null) return Boolean(booleanValue)
        if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
        return null
      }
    }
  }

  public open class Builder() {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: kotlin.String? = null

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
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

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
    public open var modifierExtension: MutableList<Extension.Builder> = mutableListOf()

    /** Indicates the order in which the dosage instructions should be applied or interpreted. */
    public open var sequence: Integer.Builder? = null

    /** Free text dosage instructions e.g. SIG. */
    public open var text: String.Builder? = null

    /**
     * Supplemental instructions to the patient on how to take the medication (e.g. "with meals"
     * or"take half to one hour before food") or warnings for the patient about the medication (e.g.
     * "may cause drowsiness" or "avoid exposure of skin to direct sunlight or sunlamps").
     *
     * Information about administration or preparation of the medication (e.g. "infuse as rapidly as
     * possibly via intraperitoneal port" or "immediately following drug x") should be populated in
     * dosage.text.
     */
    public open var additionalInstruction: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Instructions in terms that are understood by the patient or consumer. */
    public open var patientInstruction: String.Builder? = null

    /**
     * When medication should be administered.
     *
     * This attribute might not always be populated while the Dosage.text is expected to be
     * populated. If both are populated, then the Dosage.text should reflect the content of the
     * Dosage.timing.
     */
    public open var timing: Timing.Builder? = null

    /**
     * Indicates whether the Medication is only taken when needed within a specific dosing schedule
     * (Boolean option), or it indicates the precondition for taking the Medication
     * (CodeableConcept).
     *
     * Can express "as needed" without a reason by setting the Boolean = True. In this case the
     * CodeableConcept is not populated. Or you can express "as needed" with a reason by including
     * the CodeableConcept. In this case the Boolean is assumed to be True. If you set the Boolean
     * to False, then the dose is given according to the schedule and is not "prn" or "as needed".
     */
    public open var asNeeded: AsNeeded? = null

    /**
     * Body site to administer to.
     *
     * If the use case requires attributes from the BodySite resource (e.g. to identify and track
     * separately) then use the standard extension [bodySite](extension-bodysite.html). May be a
     * summary code, or a reference to a very precise definition of the location, or both.
     */
    public open var site: CodeableConcept.Builder? = null

    /** How drug should enter body. */
    public open var route: CodeableConcept.Builder? = null

    /**
     * Technique for administering medication.
     *
     * Terminologies used often pre-coordinate this term with the route and or form of
     * administration.
     */
    public open var method: CodeableConcept.Builder? = null

    /** The amount of medication administered. */
    public open var doseAndRate: MutableList<DoseAndRate.Builder> = mutableListOf()

    /**
     * Upper limit on medication per unit of time.
     *
     * This is intended for use as an adjunct to the dosage when there is an upper cap. For example
     * "2 tablets every 4 hours to a maximum of 8/day".
     */
    public open var maxDosePerPeriod: Ratio.Builder? = null

    /**
     * Upper limit on medication per administration.
     *
     * This is intended for use as an adjunct to the dosage when there is an upper cap. For example,
     * a body surface area related dose with a maximum amount, such as 1.5 mg/m2 (maximum 2 mg) IV
     * over 5 – 10 minutes would have doseQuantity of 1.5 mg/m2 and maxDosePerAdministration of 2
     * mg.
     */
    public open var maxDosePerAdministration: Quantity.Builder? = null

    /** Upper limit on medication per lifetime of the patient. */
    public open var maxDosePerLifetime: Quantity.Builder? = null

    public open fun build(): Dosage =
      Dosage(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        sequence = sequence?.build(),
        text = text?.build(),
        additionalInstruction = additionalInstruction.map { it.build() },
        patientInstruction = patientInstruction?.build(),
        timing = timing?.build(),
        asNeeded = asNeeded,
        site = site?.build(),
        route = route?.build(),
        method = method?.build(),
        doseAndRate = doseAndRate.map { it.build() },
        maxDosePerPeriod = maxDosePerPeriod?.build(),
        maxDosePerAdministration = maxDosePerAdministration?.build(),
        maxDosePerLifetime = maxDosePerLifetime?.build(),
      )
  }
}
