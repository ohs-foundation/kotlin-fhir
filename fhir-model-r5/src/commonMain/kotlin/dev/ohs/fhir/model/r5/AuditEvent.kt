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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.AuditEventAgentSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventEntityDetailSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventEntitySerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventOutcomeSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventSerializer
import dev.ohs.fhir.model.r5.serializers.AuditEventSourceSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of an event relevant for purposes such as operations, privacy, security, maintenance,
 * and performance analysis.
 */
@Serializable(with = AuditEventSerializer::class)
@SerialName("AuditEvent")
public data class AuditEvent(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
  /** Classification of the type of event. */
  public val category: List<CodeableConcept> = listOf(),
  /** Describes what happened. The most specific code for the event. */
  public val code: CodeableConcept,
  /** Indicator for type of action performed during the event that generated the audit. */
  public val action: Enumeration<AuditEventAction>? = null,
  /**
   * Indicates and enables segmentation of various severity including debugging from critical.
   *
   * ATNA will map this to the SYSLOG PRI element.
   */
  public val severity: Enumeration<AuditEventSeverity>? = null,
  /**
   * The time or period during which the activity occurred.
   *
   * The time or period can be a little arbitrary; where possible, the time should correspond to
   * human assessment of the activity time.
   */
  public val occurred: Occurred? = null,
  /**
   * The time when the event was recorded.
   *
   * In a distributed system, some sort of common time base (e.g. an NTP [RFC1305] server) is a good
   * implementation tactic.
   */
  public val recorded: Instant,
  /**
   * Indicates whether the event succeeded or failed. A free text descripiton can be given in
   * outcome.text.
   *
   * In some cases a "success" may be partial, for example, an incomplete or interrupted transfer of
   * a radiological study. For the purpose of establishing accountability, these distinctions are
   * not relevant.
   */
  public val outcome: Outcome? = null,
  /**
   * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
   *
   * Use AuditEvent.agent.authorization when you know that it is specific to the agent, otherwise
   * use AuditEvent.authorization. For example, during a machine-to-machine transfer it might not be
   * obvious to the audit system who caused the event, but it does know why.
   */
  public val authorization: List<CodeableConcept> = listOf(),
  /**
   * Allows tracing of authorizatino for the events and tracking whether proposals/recommendations
   * were acted upon.
   */
  public val basedOn: List<Reference> = listOf(),
  /**
   * The patient element is available to enable deterministic tracking of activities that involve
   * the patient as the subject of the data used in an activity.
   */
  public val patient: Reference? = null,
  /**
   * This will typically be the encounter the event occurred, but some events may be initiated prior
   * to or after the official completion of an encounter but still be tied to the context of the
   * encounter (e.g. pre-admission lab tests).
   */
  public val encounter: Reference? = null,
  /**
   * An actor taking an active role in the event or activity that is logged.
   *
   * Several agents may be associated (i.e. have some responsibility for an activity) with an event
   * or activity.
   *
   * For example, an activity may be initiated by one user for other users or involve more than one
   * user. However, only one user may be the initiator/requestor for the activity.
   *
   * When a network are used in an event being recorded, there should be distinct agent elements for
   * the known actors using the network. The agent with a network detail would be the responsible
   * agent for use of that network.
   */
  public val agent: List<Agent>,
  /**
   * The actor that is reporting the event.
   *
   * Events are reported by the actor that detected them. This may be one of the participating
   * actors, but may also be different. The actor may be a human such as a medical-records clerk
   * disclosing data manually, that clerk would be the source for the record of disclosure.
   */
  public val source: Source,
  /**
   * Specific instances of data or objects that have been accessed.
   *
   * Required unless the values for event identification, agent identification, and audit source
   * identification are sufficient to document the entire auditable event. Because events may have
   * more than one entity, this group can be a repeating set of values.
   */
  public val entity: List<Entity> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          code.toBuilder(),
          recorded.toBuilder(),
          agent.map { it.toBuilder() }.toMutableList(),
          source.toBuilder(),
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
          category = this@with.category.map { it.toBuilder() }.toMutableList()
          action = this@with.action
          severity = this@with.severity
          occurred = this@with.occurred
          outcome = this@with.outcome?.toBuilder()
          authorization = this@with.authorization.map { it.toBuilder() }.toMutableList()
          basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
          patient = this@with.patient?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          entity = this@with.entity.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * Indicates whether the event succeeded or failed. A free text descripiton can be given in
   * outcome.text.
   */
  @Serializable(with = AuditEventOutcomeSerializer::class)
  public data class Outcome(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * Indicates whether the event succeeded or failed.
     *
     * In some cases a "success" may be partial, for example, an incomplete or interrupted transfer
     * of a radiological study. For the purpose of establishing accountability, these distinctions
     * are not relevant.
     */
    public val code: Coding,
    /**
     * Additional details about the error. This may be a text description of the error or a system
     * code that identifies the error.
     *
     * A human readable description of the error issue SHOULD be placed in details.text.
     */
    public val detail: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(code.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Indicates whether the event succeeded or failed.
       *
       * In some cases a "success" may be partial, for example, an incomplete or interrupted
       * transfer of a radiological study. For the purpose of establishing accountability, these
       * distinctions are not relevant.
       */
      public var code: Coding.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /**
       * Additional details about the error. This may be a text description of the error or a system
       * code that identifies the error.
       *
       * A human readable description of the error issue SHOULD be placed in details.text.
       */
      public var detail: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Outcome =
        Outcome(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          code = code.build(),
          detail = detail.map { it.build() },
        )
    }
  }

  /** An actor taking an active role in the event or activity that is logged. */
  @Serializable(with = AuditEventAgentSerializer::class)
  public data class Agent(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * The Functional Role of the user when performing the event.
     *
     * For example: assembler, author, prescriber, signer, investigator, etc.
     */
    public val type: CodeableConcept? = null,
    /**
     * The structural roles of the agent indicating the agent's competency. The security role
     * enabling the agent with respect to the activity.
     *
     * For example: Chief-of-Radiology, Nurse, Physician, Medical-Student, etc.
     */
    public val role: List<CodeableConcept> = listOf(),
    /**
     * Reference to who this agent is that was involved in the event.
     *
     * Where a User ID is available it will go into who.identifier. Where a name of the user (human
     * readable) it will go into who.display.
     */
    public val who: Reference,
    /**
     * Indicator that the user is or is not the requestor, or initiator, for the event being
     * audited.
     *
     * There can only be one initiator. If the initiator is not clear, then do not choose any one
     * agent as the initiator.
     */
    public val requestor: Boolean? = null,
    /** Where the agent location is known, the agent location when the event occurred. */
    public val location: Reference? = null,
    /**
     * Where the policy(ies) are known that authorized the agent participation in the event.
     * Typically, a single activity may have multiple applicable policies, such as patient consent,
     * guarantor funding, etc. The policy would also indicate the security token used.
     *
     * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
     * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
     * unique policy identifier is placed into the policy element.
     */
    public val policy: List<Uri> = listOf(),
    /**
     * When the event utilizes a network there should be an agent describing the local system, and
     * an agent describing remote system, with the network interface details.
     *
     * When remote network endpoint is known, another agent representing the remote agent would
     * indicate the remote network endpoint used. Convention is to indicate data flowing from Source
     * to Destination. The convention for Search, given data flows both ways (query parameters vs
     * results), is to have the Source as the initiator of the Search Transaction, and the
     * Destination the responder to the Search transaction.
     */
    public val network: Network? = null,
    /**
     * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
     *
     * Use AuditEvent.agent.authorization when you know that is specific to the agent, otherwise use
     * AuditEvent.authorization. For example, during a machine-to-machine transfer it might not be
     * obvious to the audit system who caused the event, but it does know why.
     */
    public val authorization: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(who.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          role = this@with.role.map { it.toBuilder() }.toMutableList()
          requestor = this@with.requestor?.toBuilder()
          location = this@with.location?.toBuilder()
          policy = this@with.policy.map { it.toBuilder() }.toMutableList()
          network = this@with.network
          authorization = this@with.authorization.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Network {
      public fun asReference(): Reference? = this as? Reference

      public fun asUri(): Uri? = this as? Uri

      public fun asString(): String? = this as? String

      public data class Reference(public val `value`: dev.ohs.fhir.model.r5.Reference) : Network

      public data class Uri(public val `value`: dev.ohs.fhir.model.r5.Uri) : Network

      public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Network

      public companion object {
        internal fun from(
          referenceValue: dev.ohs.fhir.model.r5.Reference?,
          uriValue: dev.ohs.fhir.model.r5.Uri?,
          stringValue: dev.ohs.fhir.model.r5.String?,
        ): Network? {
          if (referenceValue != null) return Reference(referenceValue)
          if (uriValue != null) return Uri(uriValue)
          if (stringValue != null) return String(stringValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * Reference to who this agent is that was involved in the event.
       *
       * Where a User ID is available it will go into who.identifier. Where a name of the user
       * (human readable) it will go into who.display.
       */
      public var who: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /**
       * The Functional Role of the user when performing the event.
       *
       * For example: assembler, author, prescriber, signer, investigator, etc.
       */
      public var type: CodeableConcept.Builder? = null

      /**
       * The structural roles of the agent indicating the agent's competency. The security role
       * enabling the agent with respect to the activity.
       *
       * For example: Chief-of-Radiology, Nurse, Physician, Medical-Student, etc.
       */
      public var role: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Indicator that the user is or is not the requestor, or initiator, for the event being
       * audited.
       *
       * There can only be one initiator. If the initiator is not clear, then do not choose any one
       * agent as the initiator.
       */
      public var requestor: Boolean.Builder? = null

      /** Where the agent location is known, the agent location when the event occurred. */
      public var location: Reference.Builder? = null

      /**
       * Where the policy(ies) are known that authorized the agent participation in the event.
       * Typically, a single activity may have multiple applicable policies, such as patient
       * consent, guarantor funding, etc. The policy would also indicate the security token used.
       *
       * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
       * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
       * unique policy identifier is placed into the policy element.
       */
      public var policy: MutableList<Uri.Builder> = mutableListOf()

      /**
       * When the event utilizes a network there should be an agent describing the local system, and
       * an agent describing remote system, with the network interface details.
       *
       * When remote network endpoint is known, another agent representing the remote agent would
       * indicate the remote network endpoint used. Convention is to indicate data flowing from
       * Source to Destination. The convention for Search, given data flows both ways (query
       * parameters vs results), is to have the Source as the initiator of the Search Transaction,
       * and the Destination the responder to the Search transaction.
       */
      public var network: Network? = null

      /**
       * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
       *
       * Use AuditEvent.agent.authorization when you know that is specific to the agent, otherwise
       * use AuditEvent.authorization. For example, during a machine-to-machine transfer it might
       * not be obvious to the audit system who caused the event, but it does know why.
       */
      public var authorization: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Agent =
        Agent(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          role = role.map { it.build() },
          who = who.build(),
          requestor = requestor?.build(),
          location = location?.build(),
          policy = policy.map { it.build() },
          network = network,
          authorization = authorization.map { it.build() },
        )
    }
  }

  /** The actor that is reporting the event. */
  @Serializable(with = AuditEventSourceSerializer::class)
  public data class Source(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * Logical source location within the healthcare enterprise network. For example, a hospital or
     * other provider location within a multi-entity provider group.
     */
    public val site: Reference? = null,
    /** Identifier of the source where the event was detected. */
    public val observer: Reference,
    /** Code specifying the type of source where event originated. */
    public val type: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(observer.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          site = this@with.site?.toBuilder()
          type = this@with.type.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** Identifier of the source where the event was detected. */
      public var observer: Reference.Builder
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: String? = null

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

      /**
       * Logical source location within the healthcare enterprise network. For example, a hospital
       * or other provider location within a multi-entity provider group.
       */
      public var site: Reference.Builder? = null

      /** Code specifying the type of source where event originated. */
      public var type: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Source =
        Source(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          site = site?.build(),
          observer = observer.build(),
          type = type.map { it.build() },
        )
    }
  }

  /** Specific instances of data or objects that have been accessed. */
  @Serializable(with = AuditEventEntitySerializer::class)
  public data class Entity(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: String? = null,
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
    /**
     * Identifies a specific instance of the entity. The reference should be version specific. This
     * is allowed to be a Parameters resource.
     *
     * Use .what.display when all you have is a string (e.g. ParticipantObjectName).
     */
    public val what: Reference? = null,
    /** Code representing the role the entity played in the event being audited. */
    public val role: CodeableConcept? = null,
    /**
     * Security labels for the identified entity.
     *
     * Copied from entity meta security tags.
     */
    public val securityLabel: List<CodeableConcept> = listOf(),
    /**
     * The query parameters for a query-type entities.
     *
     * The meaning and secondary-encoding of the content of base64 encoded blob is specific to the
     * AuditEvent.type, AuditEvent.subtype, and AuditEvent.entity.role. The base64 is a general-use
     * and safe container for event specific data blobs regardless of the encoding used by the
     * transaction being recorded. An AuditEvent consuming application must understand the event it
     * is consuming and the formats used by the event. For example, if auditing an Oracle network
     * database access, the Oracle formats must be understood as they will be simply encoded in the
     * base64binary blob.
     *
     * The DICOM AuditMessage schema does not support both .name and .query being populated.
     */
    public val query: Base64Binary? = null,
    /** Tagged value pairs for conveying additional information about the entity. */
    public val detail: List<Detail> = listOf(),
    /**
     * The entity is attributed to an agent to express the agent's responsibility for that entity in
     * the activity. This is most used to indicate when persistence media (the entity) are used by
     * an agent. For example when importing data from a device, the device would be described in an
     * entity, and the user importing data from that media would be indicated as the entity.agent.
     *
     * A usecase where one AuditEvent.entity.agent is used where the Entity that was used in the
     * creation/updating of a target resource, is not in the context of the same custodianship as
     * the target resource, and thus the meaning of AuditEvent.entity.agent is to say that the
     * entity referenced is managed elsewhere and that this Agent provided access to it. This would
     * be similar to where the Entity being referenced is managed outside FHIR, such as through HL7
     * V2, v3, or XDS. This might be where the Entity being referenced is managed in another FHIR
     * resource server. Thus it explains the provenance of that Entity's use in the context of this
     * AuditEvent activity.
     */
    public val agent: List<Agent> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          what = this@with.what?.toBuilder()
          role = this@with.role?.toBuilder()
          securityLabel = this@with.securityLabel.map { it.toBuilder() }.toMutableList()
          query = this@with.query?.toBuilder()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
          agent = this@with.agent.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Tagged value pairs for conveying additional information about the entity. */
    @Serializable(with = AuditEventEntityDetailSerializer::class)
    public data class Detail(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: String? = null,
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
      /** The type of extra detail provided in the value. */
      public val type: CodeableConcept,
      /** The value of the extra detail. */
      public val `value`: Value,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              type.toBuilder(),
              `value`,
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            }
        }

      public sealed interface Value {
        public fun asQuantity(): Quantity? = this as? Quantity

        public fun asCodeableConcept(): CodeableConcept? = this as? CodeableConcept

        public fun asString(): String? = this as? String

        public fun asBoolean(): Boolean? = this as? Boolean

        public fun asInteger(): Integer? = this as? Integer

        public fun asRange(): Range? = this as? Range

        public fun asRatio(): Ratio? = this as? Ratio

        public fun asTime(): Time? = this as? Time

        public fun asDateTime(): DateTime? = this as? DateTime

        public fun asPeriod(): Period? = this as? Period

        public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

        public data class Quantity(public val `value`: dev.ohs.fhir.model.r5.Quantity) : Value

        public data class CodeableConcept(
          public val `value`: dev.ohs.fhir.model.r5.CodeableConcept
        ) : Value

        public data class String(public val `value`: dev.ohs.fhir.model.r5.String) : Value

        public data class Boolean(public val `value`: dev.ohs.fhir.model.r5.Boolean) : Value

        public data class Integer(public val `value`: dev.ohs.fhir.model.r5.Integer) : Value

        public data class Range(public val `value`: dev.ohs.fhir.model.r5.Range) : Value

        public data class Ratio(public val `value`: dev.ohs.fhir.model.r5.Ratio) : Value

        public data class Time(public val `value`: dev.ohs.fhir.model.r5.Time) : Value

        public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Value

        public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Value

        public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r5.Base64Binary) :
          Value

        public companion object {
          internal fun from(
            quantityValue: dev.ohs.fhir.model.r5.Quantity?,
            codeableConceptValue: dev.ohs.fhir.model.r5.CodeableConcept?,
            stringValue: dev.ohs.fhir.model.r5.String?,
            booleanValue: dev.ohs.fhir.model.r5.Boolean?,
            integerValue: dev.ohs.fhir.model.r5.Integer?,
            rangeValue: dev.ohs.fhir.model.r5.Range?,
            ratioValue: dev.ohs.fhir.model.r5.Ratio?,
            timeValue: dev.ohs.fhir.model.r5.Time?,
            dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
            periodValue: dev.ohs.fhir.model.r5.Period?,
            base64BinaryValue: dev.ohs.fhir.model.r5.Base64Binary?,
          ): Value? {
            if (quantityValue != null) return Quantity(quantityValue)
            if (codeableConceptValue != null) return CodeableConcept(codeableConceptValue)
            if (stringValue != null) return String(stringValue)
            if (booleanValue != null) return Boolean(booleanValue)
            if (integerValue != null) return Integer(integerValue)
            if (rangeValue != null) return Range(rangeValue)
            if (ratioValue != null) return Ratio(ratioValue)
            if (timeValue != null) return Time(timeValue)
            if (dateTimeValue != null) return DateTime(dateTimeValue)
            if (periodValue != null) return Period(periodValue)
            if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
            return null
          }
        }
      }

      public class Builder(
        /** The type of extra detail provided in the value. */
        public var type: CodeableConcept.Builder,
        /** The value of the extra detail. */
        public var `value`: Value,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: String? = null

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

        public fun build(): Detail =
          Detail(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            type = type.build(),
            `value` = `value`,
          )
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

      /**
       * Identifies a specific instance of the entity. The reference should be version specific.
       * This is allowed to be a Parameters resource.
       *
       * Use .what.display when all you have is a string (e.g. ParticipantObjectName).
       */
      public var what: Reference.Builder? = null

      /** Code representing the role the entity played in the event being audited. */
      public var role: CodeableConcept.Builder? = null

      /**
       * Security labels for the identified entity.
       *
       * Copied from entity meta security tags.
       */
      public var securityLabel: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * The query parameters for a query-type entities.
       *
       * The meaning and secondary-encoding of the content of base64 encoded blob is specific to the
       * AuditEvent.type, AuditEvent.subtype, and AuditEvent.entity.role. The base64 is a
       * general-use and safe container for event specific data blobs regardless of the encoding
       * used by the transaction being recorded. An AuditEvent consuming application must understand
       * the event it is consuming and the formats used by the event. For example, if auditing an
       * Oracle network database access, the Oracle formats must be understood as they will be
       * simply encoded in the base64binary blob.
       *
       * The DICOM AuditMessage schema does not support both .name and .query being populated.
       */
      public var query: Base64Binary.Builder? = null

      /** Tagged value pairs for conveying additional information about the entity. */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      /**
       * The entity is attributed to an agent to express the agent's responsibility for that entity
       * in the activity. This is most used to indicate when persistence media (the entity) are used
       * by an agent. For example when importing data from a device, the device would be described
       * in an entity, and the user importing data from that media would be indicated as the
       * entity.agent.
       *
       * A usecase where one AuditEvent.entity.agent is used where the Entity that was used in the
       * creation/updating of a target resource, is not in the context of the same custodianship as
       * the target resource, and thus the meaning of AuditEvent.entity.agent is to say that the
       * entity referenced is managed elsewhere and that this Agent provided access to it. This
       * would be similar to where the Entity being referenced is managed outside FHIR, such as
       * through HL7 V2, v3, or XDS. This might be where the Entity being referenced is managed in
       * another FHIR resource server. Thus it explains the provenance of that Entity's use in the
       * context of this AuditEvent activity.
       */
      public var agent: MutableList<Agent.Builder> = mutableListOf()

      public fun build(): Entity =
        Entity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          what = what?.build(),
          role = role?.build(),
          securityLabel = securityLabel.map { it.build() },
          query = query?.build(),
          detail = detail.map { it.build() },
          agent = agent.map { it.build() },
        )
    }
  }

  public sealed interface Occurred {
    public fun asPeriod(): Period? = this as? Period

    public fun asDateTime(): DateTime? = this as? DateTime

    public data class Period(public val `value`: dev.ohs.fhir.model.r5.Period) : Occurred

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r5.DateTime) : Occurred

    public companion object {
      internal fun from(
        periodValue: dev.ohs.fhir.model.r5.Period?,
        dateTimeValue: dev.ohs.fhir.model.r5.DateTime?,
      ): Occurred? {
        if (periodValue != null) return Period(periodValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        return null
      }
    }
  }

  public class Builder(
    /** Describes what happened. The most specific code for the event. */
    public var code: CodeableConcept.Builder,
    /**
     * The time when the event was recorded.
     *
     * In a distributed system, some sort of common time base (e.g. an NTP [RFC1305] server) is a
     * good implementation tactic.
     */
    public var recorded: Instant.Builder,
    /**
     * An actor taking an active role in the event or activity that is logged.
     *
     * Several agents may be associated (i.e. have some responsibility for an activity) with an
     * event or activity.
     *
     * For example, an activity may be initiated by one user for other users or involve more than
     * one user. However, only one user may be the initiator/requestor for the activity.
     *
     * When a network are used in an event being recorded, there should be distinct agent elements
     * for the known actors using the network. The agent with a network detail would be the
     * responsible agent for use of that network.
     */
    public var agent: MutableList<Agent.Builder>,
    /**
     * The actor that is reporting the event.
     *
     * Events are reported by the actor that detected them. This may be one of the participating
     * actors, but may also be different. The actor may be a human such as a medical-records clerk
     * disclosing data manually, that clerk would be the source for the record of disclosure.
     */
    public var source: Source.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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

    /** Classification of the type of event. */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicator for type of action performed during the event that generated the audit. */
    public var action: Enumeration<AuditEventAction>? = null

    /**
     * Indicates and enables segmentation of various severity including debugging from critical.
     *
     * ATNA will map this to the SYSLOG PRI element.
     */
    public var severity: Enumeration<AuditEventSeverity>? = null

    /**
     * The time or period during which the activity occurred.
     *
     * The time or period can be a little arbitrary; where possible, the time should correspond to
     * human assessment of the activity time.
     */
    public var occurred: Occurred? = null

    /**
     * Indicates whether the event succeeded or failed. A free text descripiton can be given in
     * outcome.text.
     *
     * In some cases a "success" may be partial, for example, an incomplete or interrupted transfer
     * of a radiological study. For the purpose of establishing accountability, these distinctions
     * are not relevant.
     */
    public var outcome: Outcome.Builder? = null

    /**
     * The authorization (e.g., PurposeOfUse) that was used during the event being recorded.
     *
     * Use AuditEvent.agent.authorization when you know that it is specific to the agent, otherwise
     * use AuditEvent.authorization. For example, during a machine-to-machine transfer it might not
     * be obvious to the audit system who caused the event, but it does know why.
     */
    public var authorization: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Allows tracing of authorizatino for the events and tracking whether proposals/recommendations
     * were acted upon.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The patient element is available to enable deterministic tracking of activities that involve
     * the patient as the subject of the data used in an activity.
     */
    public var patient: Reference.Builder? = null

    /**
     * This will typically be the encounter the event occurred, but some events may be initiated
     * prior to or after the official completion of an encounter but still be tied to the context of
     * the encounter (e.g. pre-admission lab tests).
     */
    public var encounter: Reference.Builder? = null

    /**
     * Specific instances of data or objects that have been accessed.
     *
     * Required unless the values for event identification, agent identification, and audit source
     * identification are sufficient to document the entire auditable event. Because events may have
     * more than one entity, this group can be a repeating set of values.
     */
    public var entity: MutableList<Entity.Builder> = mutableListOf()

    override fun build(): AuditEvent =
      AuditEvent(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        category = category.map { it.build() },
        code = code.build(),
        action = action,
        severity = severity,
        occurred = occurred,
        recorded = recorded.build(),
        outcome = outcome?.build(),
        authorization = authorization.map { it.build() },
        basedOn = basedOn.map { it.build() },
        patient = patient?.build(),
        encounter = encounter?.build(),
        agent = agent.map { it.build() },
        source = source.build(),
        entity = entity.map { it.build() },
      )
  }

  /** Indicator for type of action performed during the event that generated the event. */
  public enum class AuditEventAction(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    C("C", "http://hl7.org/fhir/audit-event-action", "Create"),
    R("R", "http://hl7.org/fhir/audit-event-action", "Read"),
    U("U", "http://hl7.org/fhir/audit-event-action", "Update"),
    D("D", "http://hl7.org/fhir/audit-event-action", "Delete"),
    E("E", "http://hl7.org/fhir/audit-event-action", "Execute");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): AuditEventAction =
        when (code) {
          "C" -> C
          "R" -> R
          "U" -> U
          "D" -> D
          "E" -> E
          else -> throw IllegalArgumentException("Unknown code $code for enum AuditEventAction")
        }
    }
  }

  /** The severity of the audit entry. */
  public enum class AuditEventSeverity(
    override val code: String,
    override val system: String,
    override val display: String?,
  ) : FhirEnum {
    Emergency("emergency", "http://hl7.org/fhir/audit-event-severity", "Emergency"),
    Alert("alert", "http://hl7.org/fhir/audit-event-severity", "Alert"),
    Critical("critical", "http://hl7.org/fhir/audit-event-severity", "Critical"),
    Error("error", "http://hl7.org/fhir/audit-event-severity", "Error"),
    Warning("warning", "http://hl7.org/fhir/audit-event-severity", "Warning"),
    Notice("notice", "http://hl7.org/fhir/audit-event-severity", "Notice"),
    Informational("informational", "http://hl7.org/fhir/audit-event-severity", "Informational"),
    Debug("debug", "http://hl7.org/fhir/audit-event-severity", "Debug");

    override fun toString(): String = code

    public companion object {
      public fun fromCode(code: String): AuditEventSeverity =
        when (code) {
          "emergency" -> Emergency
          "alert" -> Alert
          "critical" -> Critical
          "error" -> Error
          "warning" -> Warning
          "notice" -> Notice
          "informational" -> Informational
          "debug" -> Debug
          else -> throw IllegalArgumentException("Unknown code $code for enum AuditEventSeverity")
        }
    }
  }
}
