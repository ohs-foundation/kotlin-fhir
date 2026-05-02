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

import com.google.fhir.model.r5.serializers.ProvenanceAgentSerializer
import com.google.fhir.model.r5.serializers.ProvenanceEntitySerializer
import com.google.fhir.model.r5.serializers.ProvenanceOccurredSerializer
import com.google.fhir.model.r5.serializers.ProvenanceSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Provenance of a resource is a record that describes entities and processes involved in producing
 * and delivering or otherwise influencing that resource. Provenance provides a critical foundation
 * for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions
 * are a form of contextual metadata and can themselves become important records with their own
 * provenance. Provenance statement indicates clinical significance in terms of confidence in
 * authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document
 * Completion - has the artifact been legally authenticated), all of which may impact security,
 * privacy, and trust policies.
 */
@Serializable(with = ProvenanceSerializer::class)
@SerialName("Provenance")
public data class Provenance(
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
  /**
   * The Reference(s) that were generated or updated by the activity described in this resource. A
   * provenance can point to more than one target if multiple resources were created/updated by the
   * same activity.
   *
   * Target references are usually version specific, but might not be, if a version has not been
   * assigned or if the provenance information is part of the set of resources being maintained
   * (i.e. a document). When using the RESTful API, the identity of the resource might not be known
   * (especially not the version specific one); the client may either submit the resource first, and
   * then the provenance, or it may submit both using a single transaction. See the notes on
   * transaction for further discussion.
   */
  public val target: List<Reference>,
  /**
   * The period during which the activity occurred.
   *
   * The period can be a little arbitrary; where possible, the time should correspond to human
   * assessment of the activity time.
   */
  public val occurred: Occurred? = null,
  /**
   * The instant of time at which the activity was recorded.
   *
   * This can be a little different from the time stamp on the resource if there is a delay between
   * recording the event and updating the provenance and target resource.
   */
  public val recorded: Instant? = null,
  /**
   * Policy or plan the activity was defined by. Typically, a single activity may have multiple
   * applicable policy documents, such as patient consent, guarantor funding, etc.
   *
   * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
   * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
   * unique policy identifier is placed into the policy element.
   */
  public val policy: List<Uri> = listOf(),
  /** Where the activity occurred, if relevant. */
  public val location: Reference? = null,
  /** The authorization (e.g., PurposeOfUse) that was used during the event being recorded. */
  public val authorization: List<CodeableReference> = listOf(),
  /**
   * An activity is something that occurs over a period of time and acts upon or with entities; it
   * may include consuming, processing, transforming, modifying, relocating, using, or generating
   * entities.
   */
  public val activity: CodeableConcept? = null,
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
   * An actor taking a role in an activity for which it can be assigned some degree of
   * responsibility for the activity taking place.
   *
   * Several agents may be associated (i.e. has some responsibility for an activity) with an
   * activity and vice-versa.
   */
  public val agent: List<Agent>,
  /** An entity used in this activity. */
  public val entity: List<Entity> = listOf(),
  /**
   * A digital signature on the target Reference(s). The signer should match a Provenance.agent. The
   * purpose of the signature is indicated.
   */
  public val signature: List<Signature> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(
          target.map { it.toBuilder() }.toMutableList(),
          agent.map { it.toBuilder() }.toMutableList(),
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
          occurred = this@with.occurred
          recorded = this@with.recorded?.toBuilder()
          policy = this@with.policy.map { it.toBuilder() }.toMutableList()
          location = this@with.location?.toBuilder()
          authorization = this@with.authorization.map { it.toBuilder() }.toMutableList()
          activity = this@with.activity?.toBuilder()
          basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
          patient = this@with.patient?.toBuilder()
          encounter = this@with.encounter?.toBuilder()
          entity = this@with.entity.map { it.toBuilder() }.toMutableList()
          signature = this@with.signature.map { it.toBuilder() }.toMutableList()
        }
    }

  /**
   * An actor taking a role in an activity for which it can be assigned some degree of
   * responsibility for the activity taking place.
   */
  @Serializable(with = ProvenanceAgentSerializer::class)
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
     * The Functional Role of the agent with respect to the activity.
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
    /** Indicates who or what performed in the event. */
    public val who: Reference,
    /**
     * The agent that delegated authority to perform the activity performed by the agent.who
     * element.
     */
    public val onBehalfOf: Reference? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(who.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          type = this@with.type?.toBuilder()
          role = this@with.role.map { it.toBuilder() }.toMutableList()
          onBehalfOf = this@with.onBehalfOf?.toBuilder()
        }
      }

    public class Builder(
      /** Indicates who or what performed in the event. */
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
       * The Functional Role of the agent with respect to the activity.
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
       * The agent that delegated authority to perform the activity performed by the agent.who
       * element.
       */
      public var onBehalfOf: Reference.Builder? = null

      public fun build(): Agent =
        Agent(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type?.build(),
          role = role.map { it.build() },
          who = who.build(),
          onBehalfOf = onBehalfOf?.build(),
        )
    }
  }

  /** An entity used in this activity. */
  @Serializable(with = ProvenanceEntitySerializer::class)
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
    /** How the entity was used during the activity. */
    public val role: Enumeration<ProvenanceEntityRole>,
    /**
     * Identity of the Entity used. May be a logical or physical uri and maybe absolute or relative.
     *
     * whatIdentity should be used for entities that are not a Resource type.
     */
    public val what: Reference,
    /**
     * The entity is attributed to an agent to express the agent's responsibility for that entity,
     * possibly along with other agents. This description can be understood as shorthand for saying
     * that the agent was responsible for the activity which used the entity.
     *
     * A usecase where one Provenance.entity.agent is used where the Entity that was used in the
     * creation/updating of the Target, is not in the context of the same custodianship as the
     * Target, and thus the meaning of Provenance.entity.agent is to say that the entity referenced
     * is managed elsewhere and that this Agent provided access to it. This would be similar to
     * where the Entity being referenced is managed outside FHIR, such as through HL7 V2, v3, or
     * XDS. This might be where the Entity being referenced is managed in another FHIR resource
     * server. Thus it explains the Provenance of that Entity's use in the context of this
     * Provenance activity.
     */
    public val agent: List<Agent> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(role, what.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          agent = this@with.agent.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** How the entity was used during the activity. */
      public var role: Enumeration<ProvenanceEntityRole>,
      /**
       * Identity of the Entity used. May be a logical or physical uri and maybe absolute or
       * relative.
       *
       * whatIdentity should be used for entities that are not a Resource type.
       */
      public var what: Reference.Builder,
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
       * The entity is attributed to an agent to express the agent's responsibility for that entity,
       * possibly along with other agents. This description can be understood as shorthand for
       * saying that the agent was responsible for the activity which used the entity.
       *
       * A usecase where one Provenance.entity.agent is used where the Entity that was used in the
       * creation/updating of the Target, is not in the context of the same custodianship as the
       * Target, and thus the meaning of Provenance.entity.agent is to say that the entity
       * referenced is managed elsewhere and that this Agent provided access to it. This would be
       * similar to where the Entity being referenced is managed outside FHIR, such as through HL7
       * V2, v3, or XDS. This might be where the Entity being referenced is managed in another FHIR
       * resource server. Thus it explains the Provenance of that Entity's use in the context of
       * this Provenance activity.
       */
      public var agent: MutableList<Agent.Builder> = mutableListOf()

      public fun build(): Entity =
        Entity(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          role = role,
          what = what.build(),
          agent = agent.map { it.build() },
        )
    }
  }

  @Serializable(with = ProvenanceOccurredSerializer::class)
  public sealed interface Occurred {
    public fun asPeriod(): Period? = this as? Period

    public fun asDateTime(): DateTime? = this as? DateTime

    public data class Period(public val `value`: com.google.fhir.model.r5.Period) : Occurred

    public data class DateTime(public val `value`: com.google.fhir.model.r5.DateTime) : Occurred

    public companion object {
      internal fun from(
        periodValue: com.google.fhir.model.r5.Period?,
        dateTimeValue: com.google.fhir.model.r5.DateTime?,
      ): Occurred? {
        if (periodValue != null) return Period(periodValue)
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        return null
      }
    }
  }

  public class Builder(
    /**
     * The Reference(s) that were generated or updated by the activity described in this resource. A
     * provenance can point to more than one target if multiple resources were created/updated by
     * the same activity.
     *
     * Target references are usually version specific, but might not be, if a version has not been
     * assigned or if the provenance information is part of the set of resources being maintained
     * (i.e. a document). When using the RESTful API, the identity of the resource might not be
     * known (especially not the version specific one); the client may either submit the resource
     * first, and then the provenance, or it may submit both using a single transaction. See the
     * notes on transaction for further discussion.
     */
    public var target: MutableList<Reference.Builder>,
    /**
     * An actor taking a role in an activity for which it can be assigned some degree of
     * responsibility for the activity taking place.
     *
     * Several agents may be associated (i.e. has some responsibility for an activity) with an
     * activity and vice-versa.
     */
    public var agent: MutableList<Agent.Builder>,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
     */
    public var id: String? = null

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

    /**
     * The period during which the activity occurred.
     *
     * The period can be a little arbitrary; where possible, the time should correspond to human
     * assessment of the activity time.
     */
    public var occurred: Occurred? = null

    /**
     * The instant of time at which the activity was recorded.
     *
     * This can be a little different from the time stamp on the resource if there is a delay
     * between recording the event and updating the provenance and target resource.
     */
    public var recorded: Instant.Builder? = null

    /**
     * Policy or plan the activity was defined by. Typically, a single activity may have multiple
     * applicable policy documents, such as patient consent, guarantor funding, etc.
     *
     * For example: Where an OAuth token authorizes, the unique identifier from the OAuth token is
     * placed into the policy element Where a policy engine (e.g. XACML) holds policy logic, the
     * unique policy identifier is placed into the policy element.
     */
    public var policy: MutableList<Uri.Builder> = mutableListOf()

    /** Where the activity occurred, if relevant. */
    public var location: Reference.Builder? = null

    /** The authorization (e.g., PurposeOfUse) that was used during the event being recorded. */
    public var authorization: MutableList<CodeableReference.Builder> = mutableListOf()

    /**
     * An activity is something that occurs over a period of time and acts upon or with entities; it
     * may include consuming, processing, transforming, modifying, relocating, using, or generating
     * entities.
     */
    public var activity: CodeableConcept.Builder? = null

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

    /** An entity used in this activity. */
    public var entity: MutableList<Entity.Builder> = mutableListOf()

    /**
     * A digital signature on the target Reference(s). The signer should match a Provenance.agent.
     * The purpose of the signature is indicated.
     */
    public var signature: MutableList<Signature.Builder> = mutableListOf()

    override fun build(): Provenance =
      Provenance(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        target = target.map { it.build() },
        occurred = occurred,
        recorded = recorded?.build(),
        policy = policy.map { it.build() },
        location = location?.build(),
        authorization = authorization.map { it.build() },
        activity = activity?.build(),
        basedOn = basedOn.map { it.build() },
        patient = patient?.build(),
        encounter = encounter?.build(),
        agent = agent.map { it.build() },
        entity = entity.map { it.build() },
        signature = signature.map { it.build() },
      )
  }

  /** How an entity was used in an activity. */
  public enum class ProvenanceEntityRole(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Revision("revision", "http://hl7.org/fhir/provenance-entity-role", "Revision"),
    Quotation("quotation", "http://hl7.org/fhir/provenance-entity-role", "Quotation"),
    Source("source", "http://hl7.org/fhir/provenance-entity-role", "Source"),
    Instantiates("instantiates", "http://hl7.org/fhir/provenance-entity-role", "Instantiates"),
    Removal("removal", "http://hl7.org/fhir/provenance-entity-role", "Removal");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): ProvenanceEntityRole =
        when (code) {
          "revision" -> Revision
          "quotation" -> Quotation
          "source" -> Source
          "instantiates" -> Instantiates
          "removal" -> Removal
          else -> throw IllegalArgumentException("Unknown code $code for enum ProvenanceEntityRole")
        }
    }
  }
}
