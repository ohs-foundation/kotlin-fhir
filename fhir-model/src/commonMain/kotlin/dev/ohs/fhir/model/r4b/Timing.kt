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

import com.google.fhir.model.r4b.serializers.TimingRepeatBoundsSerializer
import com.google.fhir.model.r4b.serializers.TimingRepeatSerializer
import com.google.fhir.model.r4b.serializers.TimingSerializer
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
) : BackboneElement() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        event = this@with.event.map { it.toBuilder() }.toMutableList()
        repeat = this@with.repeat?.toBuilder()
        code = this@with.code?.toBuilder()
      }
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
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          bounds = this@with.bounds
          count = this@with.count?.toBuilder()
          countMax = this@with.countMax?.toBuilder()
          duration = this@with.duration?.toBuilder()
          durationMax = this@with.durationMax?.toBuilder()
          durationUnit = this@with.durationUnit
          frequency = this@with.frequency?.toBuilder()
          frequencyMax = this@with.frequencyMax?.toBuilder()
          period = this@with.period?.toBuilder()
          periodMax = this@with.periodMax?.toBuilder()
          periodUnit = this@with.periodUnit
          dayOfWeek = this@with.dayOfWeek.toMutableList()
          timeOfDay = this@with.timeOfDay.map { it.toBuilder() }.toMutableList()
          `when` = this@with.`when`.toMutableList()
          offset = this@with.offset?.toBuilder()
        }
      }

    @Serializable(with = TimingRepeatBoundsSerializer::class)
    public sealed interface Bounds {
      public fun asDuration(): Duration? = this as? Duration

      public fun asRange(): Range? = this as? Range

      public fun asPeriod(): Period? = this as? Period

      public data class Duration(public val `value`: com.google.fhir.model.r4b.Duration) : Bounds

      public data class Range(public val `value`: com.google.fhir.model.r4b.Range) : Bounds

      public data class Period(public val `value`: com.google.fhir.model.r4b.Period) : Bounds

      public companion object {
        internal fun from(
          durationValue: com.google.fhir.model.r4b.Duration?,
          rangeValue: com.google.fhir.model.r4b.Range?,
          periodValue: com.google.fhir.model.r4b.Period?,
        ): Bounds? {
          if (durationValue != null) return Duration(durationValue)
          if (rangeValue != null) return Range(rangeValue)
          if (periodValue != null) return Period(periodValue)
          return null
        }
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

      public fun build(): Repeat =
        Repeat(
          id = id,
          extension = extension.map { it.build() },
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
          timeOfDay = timeOfDay.map { it.build() },
          `when` = `when`,
          offset = offset?.build(),
        )
    }
  }

  public open class Builder() {
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

    public open fun build(): Timing =
      Timing(
        id = id,
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        event = event.map { it.build() },
        repeat = repeat?.build(),
        code = code?.build(),
      )
  }

  /** A unit of time (units from UCUM). */
  public enum class UnitsOfTime(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    S("s", "http://unitsofmeasure.org", "秒"),
    Min("min", "http://unitsofmeasure.org", "分钟"),
    H("h", "http://unitsofmeasure.org", "小时"),
    D("d", "http://unitsofmeasure.org", "天"),
    Wk("wk", "http://unitsofmeasure.org", "星期"),
    Mo("mo", "http://unitsofmeasure.org", "月"),
    A("a", "http://unitsofmeasure.org", "年");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): UnitsOfTime =
        when (code) {
          "s" -> S
          "min" -> Min
          "h" -> H
          "d" -> D
          "wk" -> Wk
          "mo" -> Mo
          "a" -> A
          else -> throw IllegalArgumentException("Unknown code $code for enum UnitsOfTime")
        }
    }
  }

  /** The days of the week. */
  public enum class DaysOfWeek(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Mon("mon", "http://hl7.org/fhir/days-of-week", "Monday"),
    Tue("tue", "http://hl7.org/fhir/days-of-week", "Tuesday"),
    Wed("wed", "http://hl7.org/fhir/days-of-week", "Wednesday"),
    Thu("thu", "http://hl7.org/fhir/days-of-week", "Thursday"),
    Fri("fri", "http://hl7.org/fhir/days-of-week", "Friday"),
    Sat("sat", "http://hl7.org/fhir/days-of-week", "Saturday"),
    Sun("sun", "http://hl7.org/fhir/days-of-week", "Sunday");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): DaysOfWeek =
        when (code) {
          "mon" -> Mon
          "tue" -> Tue
          "wed" -> Wed
          "thu" -> Thu
          "fri" -> Fri
          "sat" -> Sat
          "sun" -> Sun
          else -> throw IllegalArgumentException("Unknown code $code for enum DaysOfWeek")
        }
    }
  }

  /** Real world event relating to the schedule. */
  public enum class EventTiming(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Morn("MORN", "http://hl7.org/fhir/event-timing", "Morning"),
    Morn_Early("MORN.early", "http://hl7.org/fhir/event-timing", "Early Morning"),
    Morn_Late("MORN.late", "http://hl7.org/fhir/event-timing", "Late Morning"),
    Noon("NOON", "http://hl7.org/fhir/event-timing", "Noon"),
    Aft("AFT", "http://hl7.org/fhir/event-timing", "Afternoon"),
    Aft_Early("AFT.early", "http://hl7.org/fhir/event-timing", "Early Afternoon"),
    Aft_Late("AFT.late", "http://hl7.org/fhir/event-timing", "Late Afternoon"),
    Eve("EVE", "http://hl7.org/fhir/event-timing", "Evening"),
    Eve_Early("EVE.early", "http://hl7.org/fhir/event-timing", "Early Evening"),
    Eve_Late("EVE.late", "http://hl7.org/fhir/event-timing", "Late Evening"),
    Night("NIGHT", "http://hl7.org/fhir/event-timing", "Night"),
    Phs("PHS", "http://hl7.org/fhir/event-timing", "After Sleep"),
    Hs("HS", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "HS"),
    Wake("WAKE", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "WAKE"),
    C("C", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "C"),
    Cm("CM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CM"),
    Cd("CD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CD"),
    Cv("CV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "CV"),
    Ac("AC", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "AC"),
    Acm("ACM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACM"),
    Acd("ACD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACD"),
    Acv("ACV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "ACV"),
    Pc("PC", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PC"),
    Pcm("PCM", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCM"),
    Pcd("PCD", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCD"),
    Pcv("PCV", "http://terminology.hl7.org/CodeSystem/v3-TimingEvent", "PCV");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): EventTiming =
        when (code) {
          "MORN" -> Morn
          "MORN.early" -> Morn_Early
          "MORN.late" -> Morn_Late
          "NOON" -> Noon
          "AFT" -> Aft
          "AFT.early" -> Aft_Early
          "AFT.late" -> Aft_Late
          "EVE" -> Eve
          "EVE.early" -> Eve_Early
          "EVE.late" -> Eve_Late
          "NIGHT" -> Night
          "PHS" -> Phs
          "HS" -> Hs
          "WAKE" -> Wake
          "C" -> C
          "CM" -> Cm
          "CD" -> Cd
          "CV" -> Cv
          "AC" -> Ac
          "ACM" -> Acm
          "ACD" -> Acd
          "ACV" -> Acv
          "PC" -> Pc
          "PCM" -> Pcm
          "PCD" -> Pcd
          "PCV" -> Pcv
          else -> throw IllegalArgumentException("Unknown code $code for enum EventTiming")
        }
    }
  }
}
