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

import dev.ohs.fhir.model.r4.serializers.AuditEventAgentNetworkSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventAgentSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventEntityDetailSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventEntitySerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventSerializer
import dev.ohs.fhir.model.r4.serializers.AuditEventSourceSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A record of an event made for purposes of maintaining a security log. Typical uses include
 * detection of intrusion attempts and monitoring for inappropriate usage.
 */
@Serializable(with = AuditEventSerializer::class)
@SerialName("AuditEvent")
public data class AuditEvent(
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
   * Identifier for a family of the event. For example, a menu item, program, rule, policy, function
   * code, application name or URL. It identifies the performed function.
   */
  public val type: Coding,
  /** Identifier for the category of event. */
  public val subtype: List<Coding> = listOf(),
  /** Indicator for type of action performed during the event that generated the audit. */
  public val action: Enumeration<AuditEventAction>? = null,
  /**
   * The period during which the activity occurred.
   *
   * The period can be a little arbitrary; where possible, the time should correspond to human
   * assessment of the activity time.
   */
  public val period: Period? = null,
  /**
   * The time when the event was recorded.
   *
   * In a distributed system, some sort of common time base (e.g. an NTP [RFC1305] server) is a good
   * implementation tactic.
   */
  public val recorded: Instant,
  /**
   * Indicates whether the event succeeded or failed.
   *
   * In some cases a "success" may be partial, for example, an incomplete or interrupted transfer of
   * a radiological study. For the purpose of establishing accountability, these distinctions are
   * not relevant.
   */
  public val outcome: Enumeration<AuditEventOutcome>? = null,
  /** A free text description of the outcome of the event. */
  public val outcomeDesc: String? = null,
  /**
   * The purposeOfUse (reason) that was used during the event being recorded.
   *
   * Use AuditEvent.agent.purposeOfUse when you know that it is specific to the agent, otherwise use
   * AuditEvent.purposeOfEvent. For example, during a machine-to-machine transfer it might not be
   * obvious to the audit system who caused the event, but it does know why.
   */
  public val purposeOfEvent: List<CodeableConcept> = listOf(),
  /**
   * An actor taking an active role in the event or activity that is logged.
   *
   * Several agents may be associated (i.e. have some responsibility for an activity) with an event
   * or activity.
   *
   * For example, an activity may be initiated by one user for other users or involve more than one
   * user. However, only one user may be the initiator/requestor for the activity.
   */
  public val agent: List<Agent>,
  /**
   * The system that is reporting the event.
   *
   * Since multi-tier, distributed, or composite applications make source identification ambiguous,
   * this collection of fields may repeat for each application or process actively involved in the
   * event. For example, multiple value-sets can identify participating web servers, application
   * processes, and database server threads in an n-tier distributed application. Passive event
   * participants (e.g. low-level network transports) need not be identified.
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
          type.toBuilder(),
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
          subtype = this@with.subtype.map { it.toBuilder() }.toMutableList()
          action = this@with.action
          period = this@with.period?.toBuilder()
          outcome = this@with.outcome
          outcomeDesc = this@with.outcomeDesc?.toBuilder()
          purposeOfEvent = this@with.purposeOfEvent.map { it.toBuilder() }.toMutableList()
          entity = this@with.entity.map { it.toBuilder() }.toMutableList()
        }
    }

  /** An actor taking an active role in the event or activity that is logged. */
  @Serializable(with = AuditEventAgentSerializer::class)
  public data class Agent(
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
    /** Specification of the participation type the user plays when performing the event. */
    public val type: CodeableConcept? = null,
    /**
     * The security role that the user was acting under, that come from local codes defined by the
     * access control security system (e.g. RBAC, ABAC) used in the local context.
     *
     * Should be roles relevant to the event. Should not be an exhaustive list of roles.
     */
    public val role: List<CodeableConcept> = listOf(),
    /**
     * Reference to who this agent is that was involved in the event.
     *
     * Where a User ID is available it will go into who.identifier.
     */
    public val who: Reference? = null,
    /**
     * Alternative agent Identifier. For a human, this should be a user identifier text string from
     * authentication system. This identifier would be one known to a common authentication system
     * (e.g. single sign-on), if available.
     */
    public val altId: String? = null,
    /** Human-meaningful name for the agent. */
    public val name: String? = null,
    /**
     * Indicator that the user is or is not the requestor, or initiator, for the event being
     * audited.
     *
     * There can only be one initiator. If the initiator is not clear, then do not choose any one
     * agent as the initiator.
     */
    public val requestor: Boolean,
    /** Where the event occurred. */
    public val location: Reference? = null,
    /**
     * The policy or plan that authorized the activity being recorded. Typically, a single activity
     * may have multiple applicable policies, such as patient consent, guarantor funding, etc. The
     * policy would also indicate the security token used.
     *
     * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
     * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
     * unique policy identifier is placed into the policy element.
     */
    public val policy: List<Uri> = listOf(),
    /** Type of media involved. Used when the event is about exporting/importing onto media. */
    public val media: Coding? = null,
    /**
     * Logical network location for application activity, if the activity has a network location.
     */
    public val network: Network? = null,
    /**
     * The reason (purpose of use), specific to this agent, that was used during the event being
     * recorded.
     *
     * Use AuditEvent.agent.purposeOfUse when you know that is specific to the agent, otherwise use
     * AuditEvent.purposeOfEvent. For example, during a machine-to-machine transfer it might not be
     * obvious to the audit system who caused the event, but it does know why.
     */
    public val purposeOfUse: List<CodeableConcept> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(requestor.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          role = this@with.role.map { it.toBuilder() }.toMutableList()
          who = this@with.who?.toBuilder()
          altId = this@with.altId?.toBuilder()
          name = this@with.name?.toBuilder()
          location = this@with.location?.toBuilder()
          policy = this@with.policy.map { it.toBuilder() }.toMutableList()
          media = this@with.media?.toBuilder()
          network = this@with.network?.toBuilder()
          purposeOfUse = this@with.purposeOfUse.map { it.toBuilder() }.toMutableList()
        }
      }

    /**
     * Logical network location for application activity, if the activity has a network location.
     */
    @Serializable(with = AuditEventAgentNetworkSerializer::class)
    public data class Network(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /**
       * An identifier for the network access point of the user device for the audit event.
       *
       * This could be a device id, IP address or some other identifier associated with a device.
       */
      public val address: String? = null,
      /** An identifier for the type of network access point that originated the audit event. */
      public val type: Enumeration<AuditEventAgentNetworkType>? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            address = this@with.address?.toBuilder()
            type = this@with.type
          }
        }

      public class Builder() {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

        /**
         * An identifier for the network access point of the user device for the audit event.
         *
         * This could be a device id, IP address or some other identifier associated with a device.
         */
        public var address: String.Builder? = null

        /** An identifier for the type of network access point that originated the audit event. */
        public var type: Enumeration<AuditEventAgentNetworkType>? = null

        public fun build(): Network =
          Network(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            address = address?.build(),
            type = type,
          )
      }
    }

    public class Builder(
      /**
       * Indicator that the user is or is not the requestor, or initiator, for the event being
       * audited.
       *
       * There can only be one initiator. If the initiator is not clear, then do not choose any one
       * agent as the initiator.
       */
      public var requestor: Boolean.Builder
    ) {
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

      /** Specification of the participation type the user plays when performing the event. */
      public var type: CodeableConcept.Builder? = null

      /**
       * The security role that the user was acting under, that come from local codes defined by the
       * access control security system (e.g. RBAC, ABAC) used in the local context.
       *
       * Should be roles relevant to the event. Should not be an exhaustive list of roles.
       */
      public var role: MutableList<CodeableConcept.Builder> = mutableListOf()

      /**
       * Reference to who this agent is that was involved in the event.
       *
       * Where a User ID is available it will go into who.identifier.
       */
      public var who: Reference.Builder? = null

      /**
       * Alternative agent Identifier. For a human, this should be a user identifier text string
       * from authentication system. This identifier would be one known to a common authentication
       * system (e.g. single sign-on), if available.
       */
      public var altId: String.Builder? = null

      /** Human-meaningful name for the agent. */
      public var name: String.Builder? = null

      /** Where the event occurred. */
      public var location: Reference.Builder? = null

      /**
       * The policy or plan that authorized the activity being recorded. Typically, a single
       * activity may have multiple applicable policies, such as patient consent, guarantor funding,
       * etc. The policy would also indicate the security token used.
       *
       * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
       * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
       * unique policy identifier is placed into the policy element.
       */
      public var policy: MutableList<Uri.Builder> = mutableListOf()

      /** Type of media involved. Used when the event is about exporting/importing onto media. */
      public var media: Coding.Builder? = null

      /**
       * Logical network location for application activity, if the activity has a network location.
       */
      public var network: Network.Builder? = null

      /**
       * The reason (purpose of use), specific to this agent, that was used during the event being
       * recorded.
       *
       * Use AuditEvent.agent.purposeOfUse when you know that is specific to the agent, otherwise
       * use AuditEvent.purposeOfEvent. For example, during a machine-to-machine transfer it might
       * not be obvious to the audit system who caused the event, but it does know why.
       */
      public var purposeOfUse: MutableList<CodeableConcept.Builder> = mutableListOf()

      public fun build(): Agent =
        Agent(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          role = role.map { it.build() },
          who = who?.build(),
          altId = altId?.build(),
          name = name?.build(),
          requestor = requestor.build(),
          location = location?.build(),
          policy = policy.map { it.build() },
          media = media?.build(),
          network = network?.build(),
          purposeOfUse = purposeOfUse.map { it.build() },
        )
    }
  }

  /** The system that is reporting the event. */
  @Serializable(with = AuditEventSourceSerializer::class)
  public data class Source(
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
     * Logical source location within the healthcare enterprise network. For example, a hospital or
     * other provider location within a multi-entity provider group.
     */
    public val site: String? = null,
    /** Identifier of the source where the event was detected. */
    public val observer: Reference,
    /** Code specifying the type of source where event originated. */
    public val type: List<Coding> = listOf(),
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
       * Logical source location within the healthcare enterprise network. For example, a hospital
       * or other provider location within a multi-entity provider group.
       */
      public var site: String.Builder? = null

      /** Code specifying the type of source where event originated. */
      public var type: MutableList<Coding.Builder> = mutableListOf()

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
    /** Identifies a specific instance of the entity. The reference should be version specific. */
    public val what: Reference? = null,
    /**
     * The type of the object that was involved in this audit event.
     *
     * This value is distinct from the user's role or any user relationship to the entity.
     */
    public val type: Coding? = null,
    /** Code representing the role the entity played in the event being audited. */
    public val role: Coding? = null,
    /**
     * Identifier for the data life-cycle stage for the entity.
     *
     * This can be used to provide an audit trail for data, over time, as it passes through the
     * system.
     */
    public val lifecycle: Coding? = null,
    /**
     * Security labels for the identified entity.
     *
     * Copied from entity meta security tags.
     */
    public val securityLabel: List<Coding> = listOf(),
    /**
     * A name of the entity in the audit event.
     *
     * This field may be used in a query/report to identify audit events for a specific person. For
     * example, where multiple synonymous entity identifiers (patient number, medical record number,
     * encounter number, etc.) have been used.
     */
    public val name: String? = null,
    /** Text that describes the entity in more detail. */
    public val description: String? = null,
    /**
     * The query parameters for a query-type entities.
     *
     * The meaning and secondary-encoding of the content of base64 encoded blob is specific to the
     * AuditEvent.type, AuditEvent.subtype, AuditEvent.entity.type, and AuditEvent.entity.role. The
     * base64 is a general-use and safe container for event specific data blobs regardless of the
     * encoding used by the transaction being recorded. An AuditEvent consuming application must
     * understand the event it is consuming and the formats used by the event. For example, if
     * auditing an Oracle network database access, the Oracle formats must be understood as they
     * will be simply encoded in the base64binary blob.
     */
    public val query: Base64Binary? = null,
    /** Tagged value pairs for conveying additional information about the entity. */
    public val detail: List<Detail> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          what = this@with.what?.toBuilder()
          type = this@with.type?.toBuilder()
          role = this@with.role?.toBuilder()
          lifecycle = this@with.lifecycle?.toBuilder()
          securityLabel = this@with.securityLabel.map { it.toBuilder() }.toMutableList()
          name = this@with.name?.toBuilder()
          description = this@with.description?.toBuilder()
          query = this@with.query?.toBuilder()
          detail = this@with.detail.map { it.toBuilder() }.toMutableList()
        }
      }

    /** Tagged value pairs for conveying additional information about the entity. */
    @Serializable(with = AuditEventEntityDetailSerializer::class)
    public data class Detail(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      override val extension: List<Extension> = listOf(),
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
      override val modifierExtension: List<Extension> = listOf(),
      /** The type of extra detail provided in the value. */
      public val type: String,
      /**
       * The value of the extra detail.
       *
       * The value can be string when known to be a string, else base64 encoding should be used to
       * protect binary or undefined content. The meaning and secondary-encoding of the content of
       * base64 encoded blob is specific to the AuditEvent.type, AuditEvent.subtype,
       * AuditEvent.entity.type, and AuditEvent.entity.role. The base64 is a general-use and safe
       * container for event specific data blobs regardless of the encoding used by the transaction
       * being recorded. An AuditEvent consuming application must understand the event it is
       * consuming and the formats used by the event. For example if auditing an Oracle network
       * database access, the Oracle formats must be understood as they will be simply encoded in
       * the base64binary blob.
       */
      public val `value`: Value,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(type.toBuilder(), `value`).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
        }

      public sealed interface Value {
        public fun asString(): String? = this as? String

        public fun asBase64Binary(): Base64Binary? = this as? Base64Binary

        public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Value

        public data class Base64Binary(public val `value`: dev.ohs.fhir.model.r4.Base64Binary) :
          Value

        public companion object {
          internal fun from(
            stringValue: dev.ohs.fhir.model.r4.String?,
            base64BinaryValue: dev.ohs.fhir.model.r4.Base64Binary?,
          ): Value? {
            if (stringValue != null) return String(stringValue)
            if (base64BinaryValue != null) return Base64Binary(base64BinaryValue)
            return null
          }
        }
      }

      public class Builder(
        /** The type of extra detail provided in the value. */
        public var type: String.Builder,
        /**
         * The value of the extra detail.
         *
         * The value can be string when known to be a string, else base64 encoding should be used to
         * protect binary or undefined content. The meaning and secondary-encoding of the content of
         * base64 encoded blob is specific to the AuditEvent.type, AuditEvent.subtype,
         * AuditEvent.entity.type, and AuditEvent.entity.role. The base64 is a general-use and safe
         * container for event specific data blobs regardless of the encoding used by the
         * transaction being recorded. An AuditEvent consuming application must understand the event
         * it is consuming and the formats used by the event. For example if auditing an Oracle
         * network database access, the Oracle formats must be understood as they will be simply
         * encoded in the base64binary blob.
         */
        public var `value`: Value,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

        /**
         * May be used to represent additional information that is not part of the basic definition
         * of the element. To make the use of extensions safe and manageable, there is a strict set
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
         * and manageable, there is a strict set of governance applied to the definition and use of
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

      /** Identifies a specific instance of the entity. The reference should be version specific. */
      public var what: Reference.Builder? = null

      /**
       * The type of the object that was involved in this audit event.
       *
       * This value is distinct from the user's role or any user relationship to the entity.
       */
      public var type: Coding.Builder? = null

      /** Code representing the role the entity played in the event being audited. */
      public var role: Coding.Builder? = null

      /**
       * Identifier for the data life-cycle stage for the entity.
       *
       * This can be used to provide an audit trail for data, over time, as it passes through the
       * system.
       */
      public var lifecycle: Coding.Builder? = null

      /**
       * Security labels for the identified entity.
       *
       * Copied from entity meta security tags.
       */
      public var securityLabel: MutableList<Coding.Builder> = mutableListOf()

      /**
       * A name of the entity in the audit event.
       *
       * This field may be used in a query/report to identify audit events for a specific person.
       * For example, where multiple synonymous entity identifiers (patient number, medical record
       * number, encounter number, etc.) have been used.
       */
      public var name: String.Builder? = null

      /** Text that describes the entity in more detail. */
      public var description: String.Builder? = null

      /**
       * The query parameters for a query-type entities.
       *
       * The meaning and secondary-encoding of the content of base64 encoded blob is specific to the
       * AuditEvent.type, AuditEvent.subtype, AuditEvent.entity.type, and AuditEvent.entity.role.
       * The base64 is a general-use and safe container for event specific data blobs regardless of
       * the encoding used by the transaction being recorded. An AuditEvent consuming application
       * must understand the event it is consuming and the formats used by the event. For example,
       * if auditing an Oracle network database access, the Oracle formats must be understood as
       * they will be simply encoded in the base64binary blob.
       */
      public var query: Base64Binary.Builder? = null

      /** Tagged value pairs for conveying additional information about the entity. */
      public var detail: MutableList<Detail.Builder> = mutableListOf()

      public fun build(): Entity =
        Entity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          what = what?.build(),
          type = type?.build(),
          role = role?.build(),
          lifecycle = lifecycle?.build(),
          securityLabel = securityLabel.map { it.build() },
          name = name?.build(),
          description = description?.build(),
          query = query?.build(),
          detail = detail.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * Identifier for a family of the event. For example, a menu item, program, rule, policy,
     * function code, application name or URL. It identifies the performed function.
     */
    public var type: Coding.Builder,
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
     */
    public var agent: MutableList<Agent.Builder>,
    /**
     * The system that is reporting the event.
     *
     * Since multi-tier, distributed, or composite applications make source identification
     * ambiguous, this collection of fields may repeat for each application or process actively
     * involved in the event. For example, multiple value-sets can identify participating web
     * servers, application processes, and database server threads in an n-tier distributed
     * application. Passive event participants (e.g. low-level network transports) need not be
     * identified.
     */
    public var source: Source.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
     */
    override var id: kotlin.String? = null

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

    /** Identifier for the category of event. */
    public var subtype: MutableList<Coding.Builder> = mutableListOf()

    /** Indicator for type of action performed during the event that generated the audit. */
    public var action: Enumeration<AuditEventAction>? = null

    /**
     * The period during which the activity occurred.
     *
     * The period can be a little arbitrary; where possible, the time should correspond to human
     * assessment of the activity time.
     */
    public var period: Period.Builder? = null

    /**
     * Indicates whether the event succeeded or failed.
     *
     * In some cases a "success" may be partial, for example, an incomplete or interrupted transfer
     * of a radiological study. For the purpose of establishing accountability, these distinctions
     * are not relevant.
     */
    public var outcome: Enumeration<AuditEventOutcome>? = null

    /** A free text description of the outcome of the event. */
    public var outcomeDesc: String.Builder? = null

    /**
     * The purposeOfUse (reason) that was used during the event being recorded.
     *
     * Use AuditEvent.agent.purposeOfUse when you know that it is specific to the agent, otherwise
     * use AuditEvent.purposeOfEvent. For example, during a machine-to-machine transfer it might not
     * be obvious to the audit system who caused the event, but it does know why.
     */
    public var purposeOfEvent: MutableList<CodeableConcept.Builder> = mutableListOf()

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
        type = type.build(),
        subtype = subtype.map { it.build() },
        action = action,
        period = period?.build(),
        recorded = recorded.build(),
        outcome = outcome,
        outcomeDesc = outcomeDesc?.build(),
        purposeOfEvent = purposeOfEvent.map { it.build() },
        agent = agent.map { it.build() },
        source = source.build(),
        entity = entity.map { it.build() },
      )
  }

  /** The type of network access point of this agent in the audit event. */
  public enum class AuditEventAgentNetworkType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    _1("1", "http://hl7.org/fhir/network-type", "Machine Name"),
    _2("2", "http://hl7.org/fhir/network-type", "IP Address"),
    _3("3", "http://hl7.org/fhir/network-type", "Telephone Number"),
    _4("4", "http://hl7.org/fhir/network-type", "Email address"),
    _5("5", "http://hl7.org/fhir/network-type", "URI");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AuditEventAgentNetworkType =
        when (code) {
          "1" -> _1
          "2" -> _2
          "3" -> _3
          "4" -> _4
          "5" -> _5
          else ->
            throw IllegalArgumentException("Unknown code $code for enum AuditEventAgentNetworkType")
        }
    }
  }

  /** Indicator for type of action performed during the event that generated the event. */
  public enum class AuditEventAction(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    C("C", "http://hl7.org/fhir/audit-event-action", "Create"),
    R("R", "http://hl7.org/fhir/audit-event-action", "Read/View/Print"),
    U("U", "http://hl7.org/fhir/audit-event-action", "Update"),
    D("D", "http://hl7.org/fhir/audit-event-action", "Delete"),
    E("E", "http://hl7.org/fhir/audit-event-action", "Execute");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AuditEventAction =
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

  /** Indicates whether the event succeeded or failed. */
  public enum class AuditEventOutcome(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    _0("0", "http://hl7.org/fhir/audit-event-outcome", "Success"),
    _4("4", "http://hl7.org/fhir/audit-event-outcome", "Minor failure"),
    _8("8", "http://hl7.org/fhir/audit-event-outcome", "Serious failure"),
    _12("12", "http://hl7.org/fhir/audit-event-outcome", "Major failure");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): AuditEventOutcome =
        when (code) {
          "0" -> _0
          "4" -> _4
          "8" -> _8
          "12" -> _12
          else -> throw IllegalArgumentException("Unknown code $code for enum AuditEventOutcome")
        }
    }
  }
}
