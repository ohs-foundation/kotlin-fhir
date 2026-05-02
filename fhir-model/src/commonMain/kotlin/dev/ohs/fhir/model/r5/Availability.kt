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

package com.google.fhir.model.r5

import com.google.fhir.model.r5.serializers.AvailabilityAvailableTimeSerializer
import com.google.fhir.model.r5.serializers.AvailabilityNotAvailableTimeSerializer
import com.google.fhir.model.r5.serializers.AvailabilitySerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/** Availability Type: Availability data for an {item}. */
@Serializable(with = AvailabilitySerializer::class)
public data class Availability(
  /**
   * Unique id for the element within a resource (for internal references). This may be any string
   * value that does not contain spaces.
   */
  override val id: kotlin.String? = null,
  /**
   * May be used to represent additional information that is not part of the basic definition of the
   * element. To make the use of extensions safe and managable, there is a strict set of governance
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
  /** Times the {item} is available. */
  public val availableTime: List<AvailableTime> = listOf(),
  /** Not available during this time due to provided reason. */
  public val notAvailableTime: List<NotAvailableTime> = listOf(),
) : DataType() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder().apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        availableTime = this@with.availableTime.map { it.toBuilder() }.toMutableList()
        notAvailableTime = this@with.notAvailableTime.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Times the {item} is available. */
  @Serializable(with = AvailabilityAvailableTimeSerializer::class)
  public data class AvailableTime(
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
    /** mon | tue | wed | thu | fri | sat | sun. */
    public val daysOfWeek: List<Enumeration<DaysOfWeek>> = listOf(),
    /** Always available? i.e. 24 hour service. */
    public val allDay: Boolean? = null,
    /**
     * Opening time of day (ignored if allDay = true).
     *
     * The timezone is expected to be specified or implied by the context this datatype is used.
     */
    public val availableStartTime: Time? = null,
    /**
     * Closing time of day (ignored if allDay = true).
     *
     * The timezone is expected to be specified or implied by the context this datatype is used.
     */
    public val availableEndTime: Time? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          daysOfWeek = this@with.daysOfWeek.toMutableList()
          allDay = this@with.allDay?.toBuilder()
          availableStartTime = this@with.availableStartTime?.toBuilder()
          availableEndTime = this@with.availableEndTime?.toBuilder()
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

      /** mon | tue | wed | thu | fri | sat | sun. */
      public var daysOfWeek: MutableList<Enumeration<DaysOfWeek>> = mutableListOf()

      /** Always available? i.e. 24 hour service. */
      public var allDay: Boolean.Builder? = null

      /**
       * Opening time of day (ignored if allDay = true).
       *
       * The timezone is expected to be specified or implied by the context this datatype is used.
       */
      public var availableStartTime: Time.Builder? = null

      /**
       * Closing time of day (ignored if allDay = true).
       *
       * The timezone is expected to be specified or implied by the context this datatype is used.
       */
      public var availableEndTime: Time.Builder? = null

      public fun build(): AvailableTime =
        AvailableTime(
          id = id,
          extension = extension.map { it.build() },
          daysOfWeek = daysOfWeek,
          allDay = allDay?.build(),
          availableStartTime = availableStartTime?.build(),
          availableEndTime = availableEndTime?.build(),
        )
    }
  }

  /** Not available during this time due to provided reason. */
  @Serializable(with = AvailabilityNotAvailableTimeSerializer::class)
  public data class NotAvailableTime(
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
     * Reason presented to the user explaining why time not available.
     *
     * The reason will generally be provided to give the textual reason for displaying when the
     * {item} is not available, e.g. 'Closed public holidays' or 'Independence Day'. In cases such
     * as this, the `during` might not be included and local knowledge would be required in such
     * cases (as don't desire to keep updating when the holiday occurs each year).
     *
     * e.g.2: 'Closed for maintenance over the summer' for this example you would want to include
     * the `during` period, unless this was a university hospital and the "summer" period was well
     * known, but would recommend its inclusion anyway.
     */
    public val description: String? = null,
    /** Service not available during this period. */
    public val during: Period? = null,
  ) : Element() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          description = this@with.description?.toBuilder()
          during = this@with.during?.toBuilder()
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
       * Reason presented to the user explaining why time not available.
       *
       * The reason will generally be provided to give the textual reason for displaying when the
       * {item} is not available, e.g. 'Closed public holidays' or 'Independence Day'. In cases such
       * as this, the `during` might not be included and local knowledge would be required in such
       * cases (as don't desire to keep updating when the holiday occurs each year).
       *
       * e.g.2: 'Closed for maintenance over the summer' for this example you would want to include
       * the `during` period, unless this was a university hospital and the "summer" period was well
       * known, but would recommend its inclusion anyway.
       */
      public var description: String.Builder? = null

      /** Service not available during this period. */
      public var during: Period.Builder? = null

      public fun build(): NotAvailableTime =
        NotAvailableTime(
          id = id,
          extension = extension.map { it.build() },
          description = description?.build(),
          during = during?.build(),
        )
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
    public open var extension: MutableList<Extension.Builder> = mutableListOf()

    /** Times the {item} is available. */
    public open var availableTime: MutableList<AvailableTime.Builder> = mutableListOf()

    /** Not available during this time due to provided reason. */
    public open var notAvailableTime: MutableList<NotAvailableTime.Builder> = mutableListOf()

    public open fun build(): Availability =
      Availability(
        id = id,
        extension = extension.map { it.build() },
        availableTime = availableTime.map { it.build() },
        notAvailableTime = notAvailableTime.map { it.build() },
      )
  }

  /** The days of the week. */
  public enum class DaysOfWeek(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Mon("mon", "http://hl7.org/fhir/days-of-week", "Monday"),
    Tue("tue", "http://hl7.org/fhir/days-of-week", "Tuesday"),
    Wed("wed", "http://hl7.org/fhir/days-of-week", "Wednesday"),
    Thu("thu", "http://hl7.org/fhir/days-of-week", "Thursday"),
    Fri("fri", "http://hl7.org/fhir/days-of-week", "Friday"),
    Sat("sat", "http://hl7.org/fhir/days-of-week", "Saturday"),
    Sun("sun", "http://hl7.org/fhir/days-of-week", "Sunday");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): DaysOfWeek =
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
}
