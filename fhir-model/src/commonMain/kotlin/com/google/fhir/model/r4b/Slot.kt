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

import com.google.fhir.model.r4b.serializers.SlotSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A slot of time on a schedule that may be available for booking appointments. */
@Serializable(with = SlotSerializer::class)
@SerialName("Slot")
public data class Slot(
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
  /** External Ids for this item. */
  public val identifier: List<Identifier> = listOf(),
  /** A broad categorization of the service that is to be performed during this appointment. */
  public val serviceCategory: List<CodeableConcept> = listOf(),
  /**
   * The type of appointments that can be booked into this slot (ideally this would be an
   * identifiable service - which is at a location, rather than the location itself). If provided
   * then this overrides the value provided on the availability resource.
   */
  public val serviceType: List<CodeableConcept> = listOf(),
  /**
   * The specialty of a practitioner that would be required to perform the service requested in this
   * appointment.
   */
  public val specialty: List<CodeableConcept> = listOf(),
  /** The style of appointment or patient that may be booked in the slot (not service type). */
  public val appointmentType: CodeableConcept? = null,
  /** The schedule resource that this slot defines an interval of status information. */
  public val schedule: Reference,
  /** busy | free | busy-unavailable | busy-tentative | entered-in-error. */
  public val status: Enumeration<SlotStatus>,
  /** Date/Time that the slot is to begin. */
  public val start: Instant,
  /** Date/Time that the slot is to conclude. */
  public val end: Instant,
  /**
   * This slot has already been overbooked, appointments are unlikely to be accepted for this time.
   */
  public val overbooked: Boolean? = null,
  /**
   * Comments on the slot to describe any extended information. Such as custom constraints on the
   * slot.
   */
  public val comment: String? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(schedule.toBuilder(), status, start.toBuilder(), end.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        serviceCategory = this@with.serviceCategory.map { it.toBuilder() }.toMutableList()
        serviceType = this@with.serviceType.map { it.toBuilder() }.toMutableList()
        specialty = this@with.specialty.map { it.toBuilder() }.toMutableList()
        appointmentType = this@with.appointmentType?.toBuilder()
        overbooked = this@with.overbooked?.toBuilder()
        comment = this@with.comment?.toBuilder()
      }
    }

  public class Builder(
    /** The schedule resource that this slot defines an interval of status information. */
    public var schedule: Reference.Builder,
    /** busy | free | busy-unavailable | busy-tentative | entered-in-error. */
    public var status: Enumeration<SlotStatus>,
    /** Date/Time that the slot is to begin. */
    public var start: Instant.Builder,
    /** Date/Time that the slot is to conclude. */
    public var end: Instant.Builder,
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

    /** External Ids for this item. */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A broad categorization of the service that is to be performed during this appointment. */
    public var serviceCategory: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The type of appointments that can be booked into this slot (ideally this would be an
     * identifiable service - which is at a location, rather than the location itself). If provided
     * then this overrides the value provided on the availability resource.
     */
    public var serviceType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * The specialty of a practitioner that would be required to perform the service requested in
     * this appointment.
     */
    public var specialty: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The style of appointment or patient that may be booked in the slot (not service type). */
    public var appointmentType: CodeableConcept.Builder? = null

    /**
     * This slot has already been overbooked, appointments are unlikely to be accepted for this
     * time.
     */
    public var overbooked: Boolean.Builder? = null

    /**
     * Comments on the slot to describe any extended information. Such as custom constraints on the
     * slot.
     */
    public var comment: String.Builder? = null

    override fun build(): Slot =
      Slot(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        serviceCategory = serviceCategory.map { it.build() },
        serviceType = serviceType.map { it.build() },
        specialty = specialty.map { it.build() },
        appointmentType = appointmentType?.build(),
        schedule = schedule.build(),
        status = status,
        start = start.build(),
        end = end.build(),
        overbooked = overbooked?.build(),
        comment = comment?.build(),
      )
  }

  /** The free/busy status of the slot. */
  public enum class SlotStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Busy("busy", "http://hl7.org/fhir/slotstatus", "Busy"),
    Free("free", "http://hl7.org/fhir/slotstatus", "Free"),
    Busy_Unavailable("busy-unavailable", "http://hl7.org/fhir/slotstatus", "Busy (Unavailable)"),
    Busy_Tentative("busy-tentative", "http://hl7.org/fhir/slotstatus", "Busy (Tentative)"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/slotstatus", "Entered in error");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SlotStatus =
        when (code) {
          "busy" -> Busy
          "free" -> Free
          "busy-unavailable" -> Busy_Unavailable
          "busy-tentative" -> Busy_Tentative
          "entered-in-error" -> Entered_In_Error
          else -> throw IllegalArgumentException("Unknown code $code for enum SlotStatus")
        }
    }
  }
}
