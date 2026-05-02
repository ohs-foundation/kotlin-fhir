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

import com.google.fhir.model.r4b.serializers.TriggerDefinitionSerializer
import com.google.fhir.model.r4b.serializers.TriggerDefinitionTimingSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.Serializable

/**
 * Base StructureDefinition for TriggerDefinition Type: A description of a triggering event.
 * Triggering events can be named events, data events, or periodic, as determined by the type
 * element.
 */
@Serializable(with = TriggerDefinitionSerializer::class)
public data class TriggerDefinition(
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
  /** The type of triggering event. */
  public val type: Enumeration<TriggerType>,
  /**
   * A formal name for the event. This may be an absolute URI that identifies the event formally
   * (e.g. from a trigger registry), or a simple relative URI that identifies the event in a local
   * context.
   *
   * An event name can be provided for all event types, but is required for named events. If a name
   * is provided for a type other than named events, it is considered to be a shorthand for the
   * semantics described by the formal description of the event.
   */
  public val name: String? = null,
  /** The timing of the event (if this is a periodic trigger). */
  public val timing: Timing? = null,
  /**
   * The triggering data of the event (if this is a data trigger). If more than one data is
   * requirement is specified, then all the data requirements must be true.
   *
   * This element shall be present for any data type trigger.
   */
  public val `data`: List<DataRequirement> = listOf(),
  /**
   * A boolean-valued expression that is evaluated in the context of the container of the trigger
   * definition and returns whether or not the trigger fires.
   *
   * This element can be only be specified for data type triggers and provides additional semantics
   * for the trigger. The context available within the condition is based on the type of data event.
   * For all events, the current resource will be available as context. In addition, for
   * modification events, the previous resource will also be available. The expression may be
   * inlined, or may be a simple absolute URI, which is a reference to a named expression within a
   * logic library referenced by a library element or extension within the containing resource. If
   * the expression is a FHIR Path expression, it evaluates in the context of a resource of one of
   * the type identified in the data requirement, and may also refer to the variable %previous for
   * delta comparisons on events of type data-changed, data-modified, and data-deleted which will
   * always have the same type.
   */
  public val condition: Expression? = null,
) : Element() {
  public open fun toBuilder(): Builder =
    with(this) {
      Builder(type).apply {
        id = this@with.id
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        timing = this@with.timing
        `data` = this@with.`data`.map { it.toBuilder() }.toMutableList()
        condition = this@with.condition?.toBuilder()
      }
    }

  @Serializable(with = TriggerDefinitionTimingSerializer::class)
  public sealed interface Timing {
    public fun asTiming(): Timing? = this as? Timing

    public fun asReference(): Reference? = this as? Reference

    public fun asDate(): Date? = this as? Date

    public fun asDateTime(): DateTime? = this as? DateTime

    public data class Timing(public val `value`: com.google.fhir.model.r4b.Timing) :
      TriggerDefinition.Timing

    public data class Reference(public val `value`: com.google.fhir.model.r4b.Reference) :
      TriggerDefinition.Timing

    public data class Date(public val `value`: com.google.fhir.model.r4b.Date) :
      TriggerDefinition.Timing

    public data class DateTime(public val `value`: com.google.fhir.model.r4b.DateTime) :
      TriggerDefinition.Timing

    public companion object {
      internal fun from(
        timingValue: com.google.fhir.model.r4b.Timing?,
        referenceValue: com.google.fhir.model.r4b.Reference?,
        dateValue: com.google.fhir.model.r4b.Date?,
        dateTimeValue: com.google.fhir.model.r4b.DateTime?,
      ): TriggerDefinition.Timing? {
        if (timingValue != null) return Timing(timingValue)
        if (referenceValue != null) return Reference(referenceValue)
        if (dateValue != null) return Date(dateValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        return null
      }
    }
  }

  public open class Builder(
    /** The type of triggering event. */
    public open var type: Enumeration<TriggerType>
  ) {
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
     * A formal name for the event. This may be an absolute URI that identifies the event formally
     * (e.g. from a trigger registry), or a simple relative URI that identifies the event in a local
     * context.
     *
     * An event name can be provided for all event types, but is required for named events. If a
     * name is provided for a type other than named events, it is considered to be a shorthand for
     * the semantics described by the formal description of the event.
     */
    public open var name: String.Builder? = null

    /** The timing of the event (if this is a periodic trigger). */
    public open var timing: Timing? = null

    /**
     * The triggering data of the event (if this is a data trigger). If more than one data is
     * requirement is specified, then all the data requirements must be true.
     *
     * This element shall be present for any data type trigger.
     */
    public open var `data`: MutableList<DataRequirement.Builder> = mutableListOf()

    /**
     * A boolean-valued expression that is evaluated in the context of the container of the trigger
     * definition and returns whether or not the trigger fires.
     *
     * This element can be only be specified for data type triggers and provides additional
     * semantics for the trigger. The context available within the condition is based on the type of
     * data event. For all events, the current resource will be available as context. In addition,
     * for modification events, the previous resource will also be available. The expression may be
     * inlined, or may be a simple absolute URI, which is a reference to a named expression within a
     * logic library referenced by a library element or extension within the containing resource. If
     * the expression is a FHIR Path expression, it evaluates in the context of a resource of one of
     * the type identified in the data requirement, and may also refer to the variable %previous for
     * delta comparisons on events of type data-changed, data-modified, and data-deleted which will
     * always have the same type.
     */
    public open var condition: Expression.Builder? = null

    public open fun build(): TriggerDefinition =
      TriggerDefinition(
        id = id,
        extension = extension.map { it.build() },
        type = type,
        name = name?.build(),
        timing = timing,
        `data` = `data`.map { it.build() },
        condition = condition?.build(),
      )
  }

  /** The type of trigger. */
  public enum class TriggerType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Named_Event("named-event", "http://hl7.org/fhir/trigger-type", "Named Event"),
    Periodic("periodic", "http://hl7.org/fhir/trigger-type", "Periodic"),
    Data_Changed("data-changed", "http://hl7.org/fhir/trigger-type", "Data Changed"),
    Data_Added("data-added", "http://hl7.org/fhir/trigger-type", "Data Added"),
    Data_Modified("data-modified", "http://hl7.org/fhir/trigger-type", "Data Updated"),
    Data_Removed("data-removed", "http://hl7.org/fhir/trigger-type", "Data Removed"),
    Data_Accessed("data-accessed", "http://hl7.org/fhir/trigger-type", "Data Accessed"),
    Data_Access_Ended("data-access-ended", "http://hl7.org/fhir/trigger-type", "Data Access Ended");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): TriggerType =
        when (code) {
          "named-event" -> Named_Event
          "periodic" -> Periodic
          "data-changed" -> Data_Changed
          "data-added" -> Data_Added
          "data-modified" -> Data_Modified
          "data-removed" -> Data_Removed
          "data-accessed" -> Data_Accessed
          "data-access-ended" -> Data_Access_Ended
          else -> throw IllegalArgumentException("Unknown code $code for enum TriggerType")
        }
    }
  }
}
