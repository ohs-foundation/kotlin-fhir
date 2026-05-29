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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.CommunicationPayloadSerializer
import dev.ohs.fhir.model.r4b.serializers.CommunicationSerializer
import kotlin.String
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.jvm.JvmInline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An occurrence of information being transmitted; e.g. an alert that was sent to a responsible
 * provider, a public health agency that was notified about a reportable condition.
 */
@Serializable(with = CommunicationSerializer::class)
@SerialName("Communication")
public data class Communication(
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
   * Business identifiers assigned to this communication by the performer or other systems which
   * remain constant as the resource is updated and propagates from server to server.
   *
   * This is a business identifier, not a resource identifier (see
   * [discussion](resource.html#identifiers)). It is best practice for the identifier to only appear
   * on a single resource instance, however business practices may occasionally dictate that
   * multiple resource instances with the same identifier can exist - possibly even with different
   * resource types. For example, multiple Patient and a Person resource instance might share the
   * same social insurance number.
   */
  public val identifier: List<Identifier> = listOf(),
  /**
   * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
   * adhered to in whole or in part by this Communication.
   */
  public val instantiatesCanonical: List<Canonical> = listOf(),
  /**
   * The URL pointing to an externally maintained protocol, guideline, orderset or other definition
   * that is adhered to in whole or in part by this Communication.
   *
   * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
   */
  public val instantiatesUri: List<Uri> = listOf(),
  /**
   * An order, proposal or plan fulfilled in whole or in part by this Communication.
   *
   * This must point to some sort of a 'Request' resource, such as CarePlan, CommunicationRequest,
   * ServiceRequest, MedicationRequest, etc.
   */
  public val basedOn: List<Reference> = listOf(),
  /** Part of this action. */
  public val partOf: List<Reference> = listOf(),
  /** Prior communication that this communication is in response to. */
  public val inResponseTo: List<Reference> = listOf(),
  /**
   * The status of the transmission.
   *
   * This element is labeled as a modifier because the status contains the codes aborted and
   * entered-in-error that mark the communication as not currently valid.
   */
  public val status: Enumeration<EventStatus>,
  /**
   * Captures the reason for the current state of the Communication.
   *
   * This is generally only used for "exception" statuses such as "not-done", "suspended" or
   * "aborted". The reason for performing the event at all is captured in reasonCode, not here.
   */
  public val statusReason: CodeableConcept? = null,
  /**
   * The type of message conveyed such as alert, notification, reminder, instruction, etc.
   *
   * There may be multiple axes of categorization and one communication may serve multiple purposes.
   */
  public val category: List<CodeableConcept> = listOf(),
  /**
   * Characterizes how quickly the planned or in progress communication must be addressed. Includes
   * concepts such as stat, urgent, routine.
   *
   * Used to prioritize workflow (such as which communication to read first) when the communication
   * is planned or in progress.
   */
  public val priority: Enumeration<RequestPriority>? = null,
  /** A channel that was used for this communication (e.g. email, fax). */
  public val medium: List<CodeableConcept> = listOf(),
  /** The patient or group that was the focus of this communication. */
  public val subject: Reference? = null,
  /**
   * Description of the purpose/content, similar to a subject line in an email.
   *
   * Communication.topic.text can be used without any codings.
   */
  public val topic: CodeableConcept? = null,
  /**
   * Other resources that pertain to this communication and to which this communication should be
   * associated.
   *
   * Don't use Communication.about element when a more specific element exists, such as basedOn or
   * reasonReference.
   */
  public val about: List<Reference> = listOf(),
  /**
   * The Encounter during which this Communication was created or to which the creation of this
   * record is tightly associated.
   *
   * This will typically be the encounter the event occurred within, but some activities may be
   * initiated prior to or after the official completion of an encounter but still be tied to the
   * context of the encounter.
   */
  public val encounter: Reference? = null,
  /** The time when this communication was sent. */
  public val sent: DateTime? = null,
  /** The time when this communication arrived at the destination. */
  public val received: DateTime? = null,
  /**
   * The entity (e.g. person, organization, clinical information system, care team or device) which
   * was the target of the communication. If receipts need to be tracked by an individual, a
   * separate resource instance will need to be created for each recipient. Multiple recipient
   * communications are intended where either receipts are not tracked (e.g. a mass mail-out) or a
   * receipt is captured in aggregate (all emails confirmed received by a particular time).
   */
  public val recipient: List<Reference> = listOf(),
  /**
   * The entity (e.g. person, organization, clinical information system, or device) which was the
   * source of the communication.
   */
  public val sender: Reference? = null,
  /**
   * The reason or justification for the communication.
   *
   * Textual reasons can be captured using reasonCode.text.
   */
  public val reasonCode: List<CodeableConcept> = listOf(),
  /** Indicates another resource whose existence justifies this communication. */
  public val reasonReference: List<Reference> = listOf(),
  /** Text, attachment(s), or resource(s) that was communicated to the recipient. */
  public val payload: List<Payload> = listOf(),
  /**
   * Additional notes or commentary about the communication by the sender, receiver or other
   * interested parties.
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
        instantiatesCanonical =
          this@with.instantiatesCanonical.map { it.toBuilder() }.toMutableList()
        instantiatesUri = this@with.instantiatesUri.map { it.toBuilder() }.toMutableList()
        basedOn = this@with.basedOn.map { it.toBuilder() }.toMutableList()
        partOf = this@with.partOf.map { it.toBuilder() }.toMutableList()
        inResponseTo = this@with.inResponseTo.map { it.toBuilder() }.toMutableList()
        statusReason = this@with.statusReason?.toBuilder()
        category = this@with.category.map { it.toBuilder() }.toMutableList()
        priority = this@with.priority
        medium = this@with.medium.map { it.toBuilder() }.toMutableList()
        subject = this@with.subject?.toBuilder()
        topic = this@with.topic?.toBuilder()
        about = this@with.about.map { it.toBuilder() }.toMutableList()
        encounter = this@with.encounter?.toBuilder()
        sent = this@with.sent?.toBuilder()
        received = this@with.received?.toBuilder()
        recipient = this@with.recipient.map { it.toBuilder() }.toMutableList()
        sender = this@with.sender?.toBuilder()
        reasonCode = this@with.reasonCode.map { it.toBuilder() }.toMutableList()
        reasonReference = this@with.reasonReference.map { it.toBuilder() }.toMutableList()
        payload = this@with.payload.map { it.toBuilder() }.toMutableList()
        note = this@with.note.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Text, attachment(s), or resource(s) that was communicated to the recipient. */
  @Serializable(with = CommunicationPayloadSerializer::class)
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
     * A communicated content (or for multi-part communications, one portion of the communication).
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

      @JvmInline
      public value class String(public val `value`: dev.ohs.fhir.model.r4b.String) : Content

      @JvmInline
      public value class Attachment(public val `value`: dev.ohs.fhir.model.r4b.Attachment) :
        Content

      @JvmInline
      public value class Reference(public val `value`: dev.ohs.fhir.model.r4b.Reference) : Content

      public companion object {
        internal fun from(
          stringValue: dev.ohs.fhir.model.r4b.String?,
          attachmentValue: dev.ohs.fhir.model.r4b.Attachment?,
          referenceValue: dev.ohs.fhir.model.r4b.Reference?,
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
       * A communicated content (or for multi-part communications, one portion of the
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

  public class Builder(
    /**
     * The status of the transmission.
     *
     * This element is labeled as a modifier because the status contains the codes aborted and
     * entered-in-error that mark the communication as not currently valid.
     */
    public var status: Enumeration<EventStatus>
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * The only time that a resource does not have an id is when it is being submitted to the server
     * using a create operation.
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
     * Business identifiers assigned to this communication by the performer or other systems which
     * remain constant as the resource is updated and propagates from server to server.
     *
     * This is a business identifier, not a resource identifier (see
     * [discussion](resource.html#identifiers)). It is best practice for the identifier to only
     * appear on a single resource instance, however business practices may occasionally dictate
     * that multiple resource instances with the same identifier can exist - possibly even with
     * different resource types. For example, multiple Patient and a Person resource instance might
     * share the same social insurance number.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is
     * adhered to in whole or in part by this Communication.
     */
    public var instantiatesCanonical: MutableList<Canonical.Builder> = mutableListOf()

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other
     * definition that is adhered to in whole or in part by this Communication.
     *
     * This might be an HTML page, PDF, etc. or could just be a non-resolvable URI identifier.
     */
    public var instantiatesUri: MutableList<Uri.Builder> = mutableListOf()

    /**
     * An order, proposal or plan fulfilled in whole or in part by this Communication.
     *
     * This must point to some sort of a 'Request' resource, such as CarePlan, CommunicationRequest,
     * ServiceRequest, MedicationRequest, etc.
     */
    public var basedOn: MutableList<Reference.Builder> = mutableListOf()

    /** Part of this action. */
    public var partOf: MutableList<Reference.Builder> = mutableListOf()

    /** Prior communication that this communication is in response to. */
    public var inResponseTo: MutableList<Reference.Builder> = mutableListOf()

    /**
     * Captures the reason for the current state of the Communication.
     *
     * This is generally only used for "exception" statuses such as "not-done", "suspended" or
     * "aborted". The reason for performing the event at all is captured in reasonCode, not here.
     */
    public var statusReason: CodeableConcept.Builder? = null

    /**
     * The type of message conveyed such as alert, notification, reminder, instruction, etc.
     *
     * There may be multiple axes of categorization and one communication may serve multiple
     * purposes.
     */
    public var category: MutableList<CodeableConcept.Builder> = mutableListOf()

    /**
     * Characterizes how quickly the planned or in progress communication must be addressed.
     * Includes concepts such as stat, urgent, routine.
     *
     * Used to prioritize workflow (such as which communication to read first) when the
     * communication is planned or in progress.
     */
    public var priority: Enumeration<RequestPriority>? = null

    /** A channel that was used for this communication (e.g. email, fax). */
    public var medium: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** The patient or group that was the focus of this communication. */
    public var subject: Reference.Builder? = null

    /**
     * Description of the purpose/content, similar to a subject line in an email.
     *
     * Communication.topic.text can be used without any codings.
     */
    public var topic: CodeableConcept.Builder? = null

    /**
     * Other resources that pertain to this communication and to which this communication should be
     * associated.
     *
     * Don't use Communication.about element when a more specific element exists, such as basedOn or
     * reasonReference.
     */
    public var about: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The Encounter during which this Communication was created or to which the creation of this
     * record is tightly associated.
     *
     * This will typically be the encounter the event occurred within, but some activities may be
     * initiated prior to or after the official completion of an encounter but still be tied to the
     * context of the encounter.
     */
    public var encounter: Reference.Builder? = null

    /** The time when this communication was sent. */
    public var sent: DateTime.Builder? = null

    /** The time when this communication arrived at the destination. */
    public var received: DateTime.Builder? = null

    /**
     * The entity (e.g. person, organization, clinical information system, care team or device)
     * which was the target of the communication. If receipts need to be tracked by an individual, a
     * separate resource instance will need to be created for each recipient. Multiple recipient
     * communications are intended where either receipts are not tracked (e.g. a mass mail-out) or a
     * receipt is captured in aggregate (all emails confirmed received by a particular time).
     */
    public var recipient: MutableList<Reference.Builder> = mutableListOf()

    /**
     * The entity (e.g. person, organization, clinical information system, or device) which was the
     * source of the communication.
     */
    public var sender: Reference.Builder? = null

    /**
     * The reason or justification for the communication.
     *
     * Textual reasons can be captured using reasonCode.text.
     */
    public var reasonCode: MutableList<CodeableConcept.Builder> = mutableListOf()

    /** Indicates another resource whose existence justifies this communication. */
    public var reasonReference: MutableList<Reference.Builder> = mutableListOf()

    /** Text, attachment(s), or resource(s) that was communicated to the recipient. */
    public var payload: MutableList<Payload.Builder> = mutableListOf()

    /**
     * Additional notes or commentary about the communication by the sender, receiver or other
     * interested parties.
     */
    public var note: MutableList<Annotation.Builder> = mutableListOf()

    override fun build(): Communication =
      Communication(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        identifier = identifier.map { it.build() },
        instantiatesCanonical = instantiatesCanonical.map { it.build() },
        instantiatesUri = instantiatesUri.map { it.build() },
        basedOn = basedOn.map { it.build() },
        partOf = partOf.map { it.build() },
        inResponseTo = inResponseTo.map { it.build() },
        status = status,
        statusReason = statusReason?.build(),
        category = category.map { it.build() },
        priority = priority,
        medium = medium.map { it.build() },
        subject = subject?.build(),
        topic = topic?.build(),
        about = about.map { it.build() },
        encounter = encounter?.build(),
        sent = sent?.build(),
        received = received?.build(),
        recipient = recipient.map { it.build() },
        sender = sender?.build(),
        reasonCode = reasonCode.map { it.build() },
        reasonReference = reasonReference.map { it.build() },
        payload = payload.map { it.build() },
        note = note.map { it.build() },
      )
  }

  /** Codes identifying the lifecycle stage of an event. */
  public enum class EventStatus(
    private val code: String,
    private val system: String,
    private val display: String?,
  ) {
    Preparation("preparation", "http://hl7.org/fhir/event-status", "Preparation"),
    In_Progress("in-progress", "http://hl7.org/fhir/event-status", "In Progress"),
    Not_Done("not-done", "http://hl7.org/fhir/event-status", "Not Done"),
    On_Hold("on-hold", "http://hl7.org/fhir/event-status", "On Hold"),
    Stopped("stopped", "http://hl7.org/fhir/event-status", "Stopped"),
    Completed("completed", "http://hl7.org/fhir/event-status", "Completed"),
    Entered_In_Error("entered-in-error", "http://hl7.org/fhir/event-status", "Entered in Error"),
    Unknown("unknown", "http://hl7.org/fhir/event-status", "Unknown");

    override fun toString(): String = code

    public fun getCode(): String = code

    public fun getSystem(): String = system

    public fun getDisplay(): String? = display

    public companion object {
      public fun fromCode(code: String): EventStatus =
        when (code) {
          "preparation" -> Preparation
          "in-progress" -> In_Progress
          "not-done" -> Not_Done
          "on-hold" -> On_Hold
          "stopped" -> Stopped
          "completed" -> Completed
          "entered-in-error" -> Entered_In_Error
          "unknown" -> Unknown
          else -> throw IllegalArgumentException("Unknown code $code for enum EventStatus")
        }
    }
  }

  /** Identifies the level of importance to be assigned to actioning the request. */
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
