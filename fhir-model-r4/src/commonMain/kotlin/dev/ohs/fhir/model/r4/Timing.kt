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

import dev.ohs.fhir.model.r4.serializers.TimingRepeatSerializer
import dev.ohs.fhir.model.r4.serializers.TimingSerializer
import dev.ohs.fhir.model.r4.terminologies.DaysOfWeek
import dev.ohs.fhir.model.r4.terminologies.EventTiming
import dev.ohs.fhir.model.r4.terminologies.UnitsOfTime
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for Timing Type: Specifies an event that may occur multiple times.
 * Timing schedules are used to record when things are planned, expected or requested to occur. The
 * most common usage is in dosage instructions for medications. They are also used when planning
 * care of various kinds, and may be used for reporting the schedule to which past regular
 * activities were carried out.
 */
@Serializable(with = TimingSerializer::class)
public data class Timing(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: String? = null,
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
  /** Identifies specific times when the event occurs. */
  public val event: List<DateTime> = listOf(),
  /** A set of rules that describe when the event is scheduled. */
  public val repeat: Repeat? = null,
  /**
   * A code for the timing schedule (or just text in code.text). Some codes such as BID are
   * ubiquitous, but many institutions define their own additional codes. If a code is provided, the
   * code is understood to be a complete statement of whatever is specified in the structured timing
   * data, and either the code or the data may be used to interpret the Timing, with the exception
   * that .repeat.bounds still applies over the code (and is not contained in the code).
   *
   * BID etc. are defined as 'at institutionally specified times'. For example, an institution may
   * choose that BID is "always at 7am and 6pm". If it is inappropriate for this choice to be made,
   * the code BID should not be used. Instead, a distinct organization-specific code should be used
   * in place of the HL7-defined BID code and/or a structured representation should be used (in this
   * case, specifying the two event times).
   */
  public val code: CodeableConcept? = null,
) : BackboneElement(), FhirBuildable {
  override fun toBuilder(): Builder {
    val builder = Builder()
    builder.id = id
    builder.extension = extension.toBuilderList()
    builder.modifierExtension = modifierExtension.toBuilderList()
    builder.event = event.toBuilderList()
    builder.repeat = repeat?.toBuilder()
    builder.code = code?.toBuilder()
    return builder
  }

  /** A set of rules that describe when the event is scheduled. */
  @Serializable(with = TimingRepeatSerializer::class)
  public data class Repeat(
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
     * Either a duration for the length of the timing schedule, a range of possible length, or outer
     * bounds for start and/or end limits of the timing schedule.
     */
    public val bounds: Bounds? = null,
    /**
     * A total count of the desired number of repetitions across the duration of the entire timing
     * specification. If countMax is present, this element indicates the lower bound of the allowed
     * range of count values.
     *
     * If you have both bounds and count, then this should be understood as within the bounds
     * period, until count times happens.
     */
    public val count: PositiveInt? = null,
    /**
     * If present, indicates that the count is a range - so to perform the action between [count]
     * and [countMax] times.
     */
    public val countMax: PositiveInt? = null,
    /**
     * How long this thing happens for when it happens. If durationMax is present, this element
     * indicates the lower bound of the allowed range of the duration.
     *
     * For some events the duration is part of the definition of the event (e.g. IV infusions, where
     * the duration is implicit in the specified quantity and rate). For others, it's part of the
     * timing specification (e.g. exercise).
     */
    public val duration: Decimal? = null,
    /**
     * If present, indicates that the duration is a range - so to perform the action between
     * [duration] and [durationMax] time length.
     *
     * For some events the duration is part of the definition of the event (e.g. IV infusions, where
     * the duration is implicit in the specified quantity and rate). For others, it's part of the
     * timing specification (e.g. exercise).
     */
    public val durationMax: Decimal? = null,
    /** The units of time for the duration, in UCUM units. */
    public val durationUnit: Enumeration<UnitsOfTime>? = null,
    /**
     * The number of times to repeat the action within the specified period. If frequencyMax is
     * present, this element indicates the lower bound of the allowed range of the frequency.
     */
    public val frequency: PositiveInt? = null,
    /**
     * If present, indicates that the frequency is a range - so to repeat between [frequency] and
     * [frequencyMax] times within the period or period range.
     */
    public val frequencyMax: PositiveInt? = null,
    /**
     * Indicates the duration of time over which repetitions are to occur; e.g. to express "3 times
     * per day", 3 would be the frequency and "1 day" would be the period. If periodMax is present,
     * this element indicates the lower bound of the allowed range of the period length.
     */
    public val period: Decimal? = null,
    /**
     * If present, indicates that the period is a range from [period] to [periodMax], allowing
     * expressing concepts such as "do this once every 3-5 days.
     */
    public val periodMax: Decimal? = null,
    /** The units of time for the period in UCUM units. */
    public val periodUnit: Enumeration<UnitsOfTime>? = null,
    /**
     * If one or more days of week is provided, then the action happens only on the specified
     * day(s).
     *
     * If no days are specified, the action is assumed to happen every day as otherwise specified.
     * The elements frequency and period cannot be used as well as dayOfWeek.
     */
    public val dayOfWeek: List<Enumeration<DaysOfWeek>> = listOf(),
    /**
     * Specified time of day for action to take place.
     *
     * When time of day is specified, it is inferred that the action happens every day (as filtered
     * by dayofWeek) on the specified times. The elements when, frequency and period cannot be used
     * as well as timeOfDay.
     */
    public val timeOfDay: List<Time> = listOf(),
    /**
     * An approximate time period during the day, potentially linked to an event of daily living
     * that indicates when the action should occur.
     *
     * When more than one event is listed, the event is tied to the union of the specified events.
     */
    public val `when`: List<Enumeration<EventTiming>> = listOf(),
    /**
     * The number of minutes from the event. If the event code does not indicate whether the minutes
     * is before or after the event, then the offset is assumed to be after the event.
     */
    public val offset: UnsignedInt? = null,
  ) : Element(), FhirBuildable {
    override fun toBuilder(): Builder {
      val builder = Builder()
      builder.id = id
      builder.extension = extension.toBuilderList()
      builder.bounds = bounds
      builder.count = count?.toBuilder()
      builder.countMax = countMax?.toBuilder()
      builder.duration = duration?.toBuilder()
      builder.durationMax = durationMax?.toBuilder()
      builder.durationUnit = durationUnit
      builder.frequency = frequency?.toBuilder()
      builder.frequencyMax = frequencyMax?.toBuilder()
      builder.period = period?.toBuilder()
      builder.periodMax = periodMax?.toBuilder()
      builder.periodUnit = periodUnit
      builder.dayOfWeek = dayOfWeek.toMutableList()
      builder.timeOfDay = timeOfDay.toBuilderList()
      builder.`when` = `when`.toMutableList()
      builder.offset = offset?.toBuilder()
      return builder
    }

    public sealed interface Bounds : FhirChoice {
      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asPeriod(): Period? = this as? Period

      public data class Duration(override val `value`: dev.ohs.fhir.model.r4.Duration) : Bounds

      public data class Range(override val `value`: dev.ohs.fhir.model.r4.Range) : Bounds

      public data class Period(override val `value`: dev.ohs.fhir.model.r4.Period) : Bounds

      public companion object {
        internal fun from(
          durationValue: dev.ohs.fhir.model.r4.Duration?,
          rangeValue: dev.ohs.fhir.model.r4.Range?,
          periodValue: dev.ohs.fhir.model.r4.Period?,
        ): Bounds? {
          if (durationValue != null) return Duration(durationValue)
          if (rangeValue != null) return Range(rangeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
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
       * Either a duration for the length of the timing schedule, a range of possible length, or
       * outer bounds for start and/or end limits of the timing schedule.
       */
      public var bounds: Bounds? = null

      /**
       * A total count of the desired number of repetitions across the duration of the entire timing
       * specification. If countMax is present, this element indicates the lower bound of the
       * allowed range of count values.
       *
       * If you have both bounds and count, then this should be understood as within the bounds
       * period, until count times happens.
       */
      public var count: PositiveInt.Builder? = null

      /**
       * If present, indicates that the count is a range - so to perform the action between [count]
       * and [countMax] times.
       */
      public var countMax: PositiveInt.Builder? = null

      /**
       * How long this thing happens for when it happens. If durationMax is present, this element
       * indicates the lower bound of the allowed range of the duration.
       *
       * For some events the duration is part of the definition of the event (e.g. IV infusions,
       * where the duration is implicit in the specified quantity and rate). For others, it's part
       * of the timing specification (e.g. exercise).
       */
      public var duration: Decimal.Builder? = null

      /**
       * If present, indicates that the duration is a range - so to perform the action between
       * [duration] and [durationMax] time length.
       *
       * For some events the duration is part of the definition of the event (e.g. IV infusions,
       * where the duration is implicit in the specified quantity and rate). For others, it's part
       * of the timing specification (e.g. exercise).
       */
      public var durationMax: Decimal.Builder? = null

      /** The units of time for the duration, in UCUM units. */
      public var durationUnit: Enumeration<UnitsOfTime>? = null

      /**
       * The number of times to repeat the action within the specified period. If frequencyMax is
       * present, this element indicates the lower bound of the allowed range of the frequency.
       */
      public var frequency: PositiveInt.Builder? = null

      /**
       * If present, indicates that the frequency is a range - so to repeat between [frequency] and
       * [frequencyMax] times within the period or period range.
       */
      public var frequencyMax: PositiveInt.Builder? = null

      /**
       * Indicates the duration of time over which repetitions are to occur; e.g. to express "3
       * times per day", 3 would be the frequency and "1 day" would be the period. If periodMax is
       * present, this element indicates the lower bound of the allowed range of the period length.
       */
      public var period: Decimal.Builder? = null

      /**
       * If present, indicates that the period is a range from [period] to [periodMax], allowing
       * expressing concepts such as "do this once every 3-5 days.
       */
      public var periodMax: Decimal.Builder? = null

      /** The units of time for the period in UCUM units. */
      public var periodUnit: Enumeration<UnitsOfTime>? = null

      /**
       * If one or more days of week is provided, then the action happens only on the specified
       * day(s).
       *
       * If no days are specified, the action is assumed to happen every day as otherwise specified.
       * The elements frequency and period cannot be used as well as dayOfWeek.
       */
      public var dayOfWeek: MutableList<Enumeration<DaysOfWeek>> = mutableListOf()

      /**
       * Specified time of day for action to take place.
       *
       * When time of day is specified, it is inferred that the action happens every day (as
       * filtered by dayofWeek) on the specified times. The elements when, frequency and period
       * cannot be used as well as timeOfDay.
       */
      public var timeOfDay: MutableList<Time.Builder> = mutableListOf()

      /**
       * An approximate time period during the day, potentially linked to an event of daily living
       * that indicates when the action should occur.
       *
       * When more than one event is listed, the event is tied to the union of the specified events.
       */
      public var `when`: MutableList<Enumeration<EventTiming>> = mutableListOf()

      /**
       * The number of minutes from the event. If the event code does not indicate whether the
       * minutes is before or after the event, then the offset is assumed to be after the event.
       */
      public var offset: UnsignedInt.Builder? = null

      override fun build(): Repeat =
        Repeat(
          id = id,
          extension = extension.buildList(),
          bounds = bounds,
          count = count?.build(),
          countMax = countMax?.build(),
          duration = duration?.build(),
          durationMax = durationMax?.build(),
          durationUnit = durationUnit,
          frequency = frequency?.build(),
          frequencyMax = frequencyMax?.build(),
          period = period?.build(),
          periodMax = periodMax?.build(),
          periodUnit = periodUnit,
          dayOfWeek = dayOfWeek,
          timeOfDay = timeOfDay.buildList(),
          `when` = `when`,
          offset = offset?.build(),
        )
    }
  }

  public open class Builder() : FhirBuilder {
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    public open var id: String? = null

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

    /** Identifies specific times when the event occurs. */
    public open var event: MutableList<DateTime.Builder> = mutableListOf()

    /** A set of rules that describe when the event is scheduled. */
    public open var repeat: Repeat.Builder? = null

    /**
     * A code for the timing schedule (or just text in code.text). Some codes such as BID are
     * ubiquitous, but many institutions define their own additional codes. If a code is provided,
     * the code is understood to be a complete statement of whatever is specified in the structured
     * timing data, and either the code or the data may be used to interpret the Timing, with the
     * exception that .repeat.bounds still applies over the code (and is not contained in the code).
     *
     * BID etc. are defined as 'at institutionally specified times'. For example, an institution may
     * choose that BID is "always at 7am and 6pm". If it is inappropriate for this choice to be
     * made, the code BID should not be used. Instead, a distinct organization-specific code should
     * be used in place of the HL7-defined BID code and/or a structured representation should be
     * used (in this case, specifying the two event times).
     */
    public open var code: CodeableConcept.Builder? = null

    open override fun build(): Timing =
      Timing(
        id = id,
        extension = extension.buildList(),
        modifierExtension = modifierExtension.buildList(),
        event = event.buildList(),
        repeat = repeat?.build(),
        code = code?.build(),
      )
  }
}
