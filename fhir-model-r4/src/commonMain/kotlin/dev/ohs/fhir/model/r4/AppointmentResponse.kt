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

package dev.ohs.fhir.model.r4

import dev.ohs.fhir.model.r4.serializers.AppointmentResponseSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or
 * rejection.
 */
@Serializable(with = AppointmentResponseSerializer::class)
@SerialName("AppointmentResponse")
public data class AppointmentResponse(
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
  /**
   * This records identifiers associated with this appointment response concern that are defined by
   * business processes and/ or used to refer to it when a direct URL reference to the resource
   * itself is not appropriate.
   */
  public val identifier: List<Identifier> = listOf(),
  /** Appointment that this response is replying to. */
  public val appointment: Reference,
  /**
   * Date/Time that the appointment is to take place, or requested new start time.
   *
   * This may be either the same as the appointment request to confirm the details of the
   * appointment, or alternately a new time to request a re-negotiation of the start time.
   */
  public val start: Instant? = null,
  /**
   * This may be either the same as the appointment request to confirm the details of the
   * appointment, or alternately a new time to request a re-negotiation of the end time.
   */
  public val end: Instant? = null,
  /**
   * Role of participant in the appointment.
   *
   * The role of the participant can be used to declare what the actor will be doing in the scope of
   * the referenced appointment.
   *
   * If the actor is not specified, then it is expected that the actor will be filled in at a later
   * stage of planning.
   *
   * This value SHALL be the same as specified on the referenced Appointment so that they can be
   * matched, and subsequently updated.
   */
  public val participantType: List<CodeableConcept> = listOf(),
  /** A Person, Location, HealthcareService, or Device that is participating in the appointment. */
  public val actor: Reference? = null,
  /**
   * Participation status of the participant. When the status is declined or tentative if the
   * start/end times are different to the appointment, then these times should be interpreted as a
   * requested time change. When the status is accepted, the times can either be the time of the
   * appointment (as a confirmation of the time) or can be empty.
   *
   * This element is labeled as a modifier because the status contains the code entered-in-error
   * that marks the participant as not currently valid.
   */
  public val participantStatus: Enumeration<ParticipationStatus>,
  /**
   * Additional comments about the appointment.
   *
   * This comment is particularly important when the responder is declining, tentatively accepting
   * or requesting another time to indicate the reasons why.
   */
  public val comment: String? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(appointment.toBuilder(), participantStatus).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        start = this@with.start?.toBuilder()
        end = this@with.end?.toBuilder()
        participantType = this@with.participantType.map { it.toBuilder() }.toMutableList()
        actor = this@with.actor?.toBuilder()
        comment = this@with.comment?.toBuilder()
      }
    }

  public class Builder(
    /** Appointment that this response is replying to. */
    public var appointment: Reference.Builder,
    /**
     * Participation status of the participant. When the status is declined or tentative if the
     * start/end times are different to the appointment, then these times should be interpreted as a
     * requested time change. When the status is accepted, the times can either be the time of the
     * appointment (as a confirmation of the time) or can be empty.
     *
     * This element is labeled as a modifier because the status contains the code entered-in-error
     * that marks the participant as not currently valid.
     */
    public var participantStatus: Enumeration<ParticipationStatus>,
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

    /**
     * This records identifiers associated with this appointment response concern that are defined
     * by business processes and/ or used to refer to it when a direct URL reference to the resource
     * itself is not appropriate.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * Date/Time that the appointment is to take place, or requested new start time.
     *
     * This may be either the same as the appointment request to confirm the details of the
     * appointment, or alternately a new time to request a re-negotiation of the start time.
     */
    public var start: Instant.Builder? = null

    /**
     * This may be either the same as the appointment request to confirm the details of the
     * appointment, or alternately a new time to request a re-negotiation of the end time.
     */
    public var end: Instant.Builder? = null

    /**
     * Role of participant in the appointment.
     *
     * The role of the participant can be used to declare what the actor will be doing in the scope
     * of the referenced appointment.
     *
     * If the actor is not specified, then it is expected that the actor will be filled in at a
     * later stage of planning.
     *
     * This value SHALL be the same as specified on the referenced Appointment so that they can be
     * matched, and subsequently updated.
     */
    public var participantType: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * A Person, Location, HealthcareService, or Device that is participating in the appointment.
     */
    public var actor: Reference.Builder? = null

    /**
     * Additional comments about the appointment.
     *
     * This comment is particularly important when the responder is declining, tentatively accepting
     * or requesting another time to indicate the reasons why.
     */
    public var comment: String.Builder? = null

    override fun build(): AppointmentResponse =
      AppointmentResponse(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        appointment = appointment.build(),
        start = start?.build(),
        end = end?.build(),
        participantType = participantType.map { it.build() },
        actor = actor?.build(),
        participantStatus = participantStatus,
        comment = comment?.build(),
      )
  }

  /** The Participation status of an appointment. */
  public enum class ParticipationStatus(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Accepted("accepted", "http://hl7.org/fhir/participationstatus", "Accepted"),
    Declined("declined", "http://hl7.org/fhir/participationstatus", "Declined"),
    Tentative("tentative", "http://hl7.org/fhir/participationstatus", "Tentative"),
    Needs_Action("needs-action", "http://hl7.org/fhir/participationstatus", "Needs Action");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): ParticipationStatus =
        when (code) {
          "accepted" -> Accepted
          "declined" -> Declined
          "tentative" -> Tentative
          "needs-action" -> Needs_Action
          else -> throw IllegalArgumentException("Unknown code $code for enum ParticipationStatus")
        }
    }
  }
}
