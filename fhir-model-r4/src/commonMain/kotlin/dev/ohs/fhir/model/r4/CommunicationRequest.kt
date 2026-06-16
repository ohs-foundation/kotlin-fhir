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

import dev.ohs.fhir.model.r4.serializers.CommunicationRequestPayloadSerializer
import dev.ohs.fhir.model.r4.serializers.CommunicationRequestSerializer
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A request to convey information; e.g. the CDS system proposes that an alert be sent to a
 * responsible provider, the CDS system proposes that the public health agency be notified about a
 * reportable condition.
 */
@Serializable(with = CommunicationRequestSerializer::class)
@SerialName("CommunicationRequest")
public data class CommunicationRequest(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * The only time that a resource does not have an id is when it is being submitted to the server
   * using a create operation.
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
   * Business identifiers assigned to this communication request by the performer or other systems
   * which remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val identifier: List<Identifier> = listOf(),
  /** A plan or proposal that is fulfilled in whole or in part by this request. */
  public val basedOn: List<Reference> = listOf(),
  /**
   * Completed or terminated request(s) whose function is taken by this new request.
   *
   * The replacement could be because the initial request was immediately rejected (due to an issue)
   * or because the previous request was completed, but the need for the action described by the
   * request remains ongoing.
   */
  public val replaces: List<Reference> = listOf(),
  /**
   * A shared identifier common to all requests that were authorized more or less simultaneously by
   * a single author, representing the identifier of the requisition, prescription or similar form.
   *
   * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling another)
   * or by having a common requisition. Requests that are part of the same requisition are generally
   * treated independently from the perspective of changing their state or maintaining them after
   * initial creation.
   */
  public val groupIdentifier: Identifier? = null,
  /** The status of the proposal or order. */
  public val status: Enumeration<RequestStatus>,
  /**
   * Captures the reason for the current state of the CommunicationRequest.
   *
   * This is generally only used for "exception" statuses such as "suspended" or "cancelled". The
   * reason why the CommunicationRequest was created at all is captured in reasonCode, not here.
   * [distinct reason codes for different statuses can be enforced using invariants if they are universal bindings].
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * The type of message to be sent such as alert, notification, reminder, instruction, etc.
   *
   * There may be multiple axes of categorization and one communication request may serve multiple
   * purposes.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat,
   * urgent, routine.
   */
  public val priority: Enumeration<RequestPriority>? = null,
  /**
   * If true indicates that the CommunicationRequest is asking for the specified action to *not*
   * occur.
   *
   * The attributes provided with the request qualify what is not to be done.
   */
  public val doNotPerform: Boolean? = null,
  /** A channel that was used for this communication (e.g. email, fax). */
  public val medium: List<CodeableConcept> = listOf(),
  /** The patient or group that is the focus of this communication request. */
  public val subject: Reference? = null,
  /**
   * Other resources that pertain to this communication request and to which this communication
   * request should be associated.
   *
   * Don't use CommunicationRequest.about element when a more specific element exists, such as
   * basedOn, reasonReference, or replaces.
   */
  public val about: List<Reference> = listOf(),
  /**
   * The Encounter during which this CommunicationRequest was created or to which the creation of
   * this record is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: Reference? = null,
  /** Text, attachment(s), or resource(s) to be communicated to the recipient. */
  public val payload: List<Payload> = listOf(),
  /** The time when this communication is to occur. */
  public val occurrence: Occurrence? = null,
  /**
   * For draft requests, indicates the date of initial creation. For requests with other statuses,
   * indicates the date of activation.
   */
  public val authoredOn: DateTime? = null,
  /**
   * The device, individual, or organization who initiated the request and has responsibility for
   * its activation.
   */
  public val requester: Reference? = null,
  /**
   * The entity (e.g. person, organization, clinical information system, device, group, or care
   * team) which is the intended target of the communication.
   */
  public val recipient: List<Reference> = listOf(),
  /**
   * The entity (e.g. person, organization, clinical information system, or device) which is to be
   * the source of the communication.
   */
  public val sender: Reference? = null,
  /**
   * Describes why the request is being made in coded or textual form.
   *
   * Textual reasons can be captured using reasonCode.text.
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Indicates another resource whose existence justifies this request. */
  public val reasonReference: List<Reference> = listOf(),
  /**
   * Comments made about the request by the requester, sender, recipient, subject or other
   * participants.
   */
  public val note: List<Annotation> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        replaces = this@with.replaces.map { it.toBuilder() }.toMutableList()
        groupIdentifier = this@with.groupIdentifier?.toBuilder()
        statusReason = this@with.statusReason?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        priority = this@with.priority
        doNotPerform = this@with.doNotPerform?.toBuilder()
        medium = this@with.medium.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        about = this@with.about.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        payload = this@with.payload.map { it.toBuilder() }.toMutableList()
        occurrence = this@with.occurrence
        authoredOn = this@with.authoredOn?.toBuilder()
        requester = this@with.requester?.toBuilder()
        recipient = this@with.recipient.map { it.toBuilder() }.toMutableList()
        sender = this@with.sender?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Text, attachment(s), or resource(s) to be communicated to the recipient. */
  @Serializable(with = CommunicationRequestPayloadSerializer::class)
  public data class Payload(
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
     * The communicated content (or for multi-part communications, one portion of the
     * communication).
     */
    public val content: Content,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(content).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public sealed interface Content {
      public fun asString(): String? = this as? String

      public fun asAttachment(): Attachment? = this as? Attachment

      public fun asReference(): Reference? = this as? Reference

      public data class String(public val `value`: dev.ohs.fhir.model.r4.String) : Content

      public data class Attachment(public val `value`: dev.ohs.fhir.model.r4.Attachment) : Content

      public data class Reference(public val `value`: dev.ohs.fhir.model.r4.Reference) : Content

      public companion object {
        internal fun from(
          stringValue: dev.ohs.fhir.model.r4.String?,
          attachmentValue: dev.ohs.fhir.model.r4.Attachment?,
          referenceValue: dev.ohs.fhir.model.r4.Reference?,
        ): Content? {
          if (stringValue != null) return String(stringValue)
          if (attachmentValue != null) return Attachment(attachmentValue)
          if (referenceValue != null) return Reference(referenceValue)
          return null
        }
      }
    }

    public class Builder(
      /**
       * The communicated content (or for multi-part communications, one portion of the
       * communication).
       */
      public var content: Content
    ) {
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

      public fun build(): Payload =
        Payload(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          content = content,
        )
    }
  }

  public sealed interface Occurrence {
    public fun asDateTime(): DateTime? = this as? DateTime

    public fun asPeriod(): Period? = this as? Period

    public data class DateTime(public val `value`: dev.ohs.fhir.model.r4.DateTime) : Occurrence

    public data class Period(public val `value`: dev.ohs.fhir.model.r4.Period) : Occurrence

    public companion object {
      internal fun from(
        dateTimeValue: dev.ohs.fhir.model.r4.DateTime?,
        periodValue: dev.ohs.fhir.model.r4.Period?,
      ): Occurrence? {
        if (dateTimeValue != null) return DateTime(dateTimeValue)
        if (periodValue != null) return Period(periodValue)
        return null
      }
    }
  }

  public class Builder(
    /** The status of the proposal or order. */
    public var status: Enumeration<RequestStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * Business identifiers assigned to this communication request by the performer or other systems
     * which remain constant as the resource is updated and propagates from server to server.
     *
     * This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A plan or proposal that is fulfilled in whole or in part by this request. */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Completed or terminated request(s) whose function is taken by this new request.
     *
     * The replacement could be because the initial request was immediately rejected (due to an
     * issue) or because the previous request was completed, but the need for the action described
     * by the request remains ongoing.
     */
    public var replaces: MutableList<Reference.Builder> = mutableListOf()

    /**
     * A shared identifier common to all requests that were authorized more or less simultaneously
     * by a single author, representing the identifier of the requisition, prescription or similar
     * form.
     *
     * Requests are linked either by a "basedOn" relationship (i.e. one request is fulfilling
     * another) or by having a common requisition. Requests that are part of the same requisition
     * are generally treated independently from the perspective of changing their state or
     * maintaining them after initial creation.
     */
    public var groupIdentifier: Identifier.Builder? = null

    /**
     * Captures the reason for the current state of the CommunicationRequest.
     *
     * This is generally only used for "exception" statuses such as "suspended" or "cancelled". The
     * reason why the CommunicationRequest was created at all is captured in reasonCode, not here.
     * [distinct reason codes for different statuses can be enforced using invariants if they are universal bindings].
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * The type of message to be sent such as alert, notification, reminder, instruction, etc.
     *
     * There may be multiple axes of categorization and one communication request may serve multiple
     * purposes.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat,
     * urgent, routine.
     */
    public var priority: Enumeration<RequestPriority>? = null

    /**
     * If true indicates that the CommunicationRequest is asking for the specified action to *not*
     * occur.
     *
     * The attributes provided with the request qualify what is not to be done.
     */
    public var doNotPerform: Boolean.Builder? = null

    /** A channel that was used for this communication (e.g. email, fax). */
    public var medium: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The patient or group that is the focus of this communication request. */
    public var subject: Reference.Builder? = null

    /**
     * Other resources that pertain to this communication request and to which this communication
     * request should be associated.
     *
     * Don't use CommunicationRequest.about element when a more specific element exists, such as
     * basedOn, reasonReference, or replaces.
     */
    public var about: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The Encounter during which this CommunicationRequest was created or to which the creation of
     * this record is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: Reference.Builder? = null

    /** Text, attachment(s), or resource(s) to be communicated to the recipient. */
    public var payload: MutableList<Payload.Builder> = mutableListOf()

    /** The time when this communication is to occur. */
    public var occurrence: Occurrence? = null

    /**
     * For draft requests, indicates the date of initial creation. For requests with other statuses,
     * indicates the date of activation.
     */
    public var authoredOn: DateTime.Builder? = null

    /**
     * The device, individual, or organization who initiated the request and has responsibility for
     * its activation.
     */
    public var requester: Reference.Builder? = null

    /**
     * The entity (e.g. person, organization, clinical information system, device, group, or care
     * team) which is the intended target of the communication.
     */
    public var recipient: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The entity (e.g. person, organization, clinical information system, or device) which is to be
     * the source of the communication.
     */
    public var sender: Reference.Builder? = null

    /**
     * Describes why the request is being made in coded or textual form.
     *
     * Textual reasons can be captured using reasonCode.text.
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates another resource whose existence justifies this request. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Comments made about the request by the requester, sender, recipient, subject or other
     * participants.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): CommunicationRequest =
      CommunicationRequest(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        basedOn = basedOn.map { it.build() },
        replaces = replaces.map { it.build() },
        groupIdentifier = groupIdentifier?.build(),
        status = status,
        statusReason = statusReason?.build(),
        category = category.map { it.build() },
        priority = priority,
        doNotPerform = doNotPerform?.build(),
        medium = medium.map { it.build() },
        subject = subject?.build(),
        about = about.map { it.build() },
        encounter = encounter?.build(),
        payload = payload.map { it.build() },
        occurrence = occurrence,
        authoredOn = authoredOn?.build(),
        requester = requester?.build(),
        recipient = recipient.map { it.build() },
        sender = sender?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of a request. */
  public enum class RequestStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Draft("draft", "http://hl7.org/fhir/request-status", "Draft"),
    Active("active", "http://hl7.org/fhir/request-status", "Active"),
    On_Hold("on-hold", "http://hl7.org/fhir/request-status", "On Hold"),
    Revoked("revoked", "http://hl7.org/fhir/request-status", "Revoked"),
    Completed("completed", "http://hl7.org/fhir/request-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/request-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/request-status", "Unknown");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestStatus =
        when (code) {
          "draft" -> Draft
          "active" -> Active
          "on-hold" -> On_Hold
          "revoked" -> Revoked
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestStatus")
        }
    }
  }

  /** The clinical priority of a diagnostic order. */
  public enum class RequestPriority(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Routine("routine", "http://hl7.org/fhir/request-priority", "Routine"),
    Urgent("urgent", "http://hl7.org/fhir/request-priority", "Urgent"),
    Asap("asap", "http://hl7.org/fhir/request-priority", "ASAP"),
    Stat("stat", "http://hl7.org/fhir/request-priority", "STAT");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): RequestPriority =
        when (code) {
          "routine" -> Routine
          "urgent" -> Urgent
          "asap" -> Asap
          "stat" -> Stat
          else -> throw IllegalArgumentException("Unknown code $code for enum RequestPriority")
        }
    }
  }
}
