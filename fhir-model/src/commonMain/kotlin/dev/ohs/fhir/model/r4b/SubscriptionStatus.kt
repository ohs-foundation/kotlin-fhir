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

import com.google.fhir.model.r4b.serializers.SubscriptionStatusNotificationEventSerializer
import com.google.fhir.model.r4b.serializers.SubscriptionStatusSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** The SubscriptionStatus resource describes the state of a Subscription during notifications. */
@Serializable(with = SubscriptionStatusSerializer::class)
@SerialName("SubscriptionStatus")
public data class SubscriptionStatus(
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
  /** The status of the subscription, which marks the server state for managing the subscription. */
  public val status: Enumeration<SubscriptionStatusCodes>? = null,
  /** The type of event being conveyed with this notificaiton. */
  public val type: Enumeration<SubscriptionNotificationType>,
  /**
   * The total number of actual events which have been generated since the Subscription was created
   * (inclusive of this notification) - regardless of how many have been successfully communicated.
   * This number is NOT incremented for handshake and heartbeat notifications.
   */
  public val eventsSinceSubscriptionStart: String? = null,
  /** Detailed information about events relevant to this subscription notification. */
  public val notificationEvent: List<NotificationEvent> = listOf(),
  /** The reference to the Subscription which generated this notification. */
  public val subscription: Reference,
  /**
   * The reference to the SubscriptionTopic for the Subscription which generated this notification.
   *
   * This value SHOULD NOT be present when using `empty` payloads, MAY be present when using
   * `id-only` payloads, and SHOULD be present when using `full-resource` payloads.
   */
  public val topic: Canonical? = null,
  /**
   * A record of errors that occurred when the server processed a notification.
   *
   * Recommended practice: clear errors when status is updated.
   */
  public val error: List<CodeableConcept> = listOf(),
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(type, subscription.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        status = this@with.status
        eventsSinceSubscriptionStart = this@with.eventsSinceSubscriptionStart?.toBuilder()
        notificationEvent = this@with.notificationEvent.map { it.toBuilder() }.toMutableList()
        topic = this@with.topic?.toBuilder()
        error = this@with.error.map { it.toBuilder() }.toMutableList()
      }
    }

  /** Detailed information about events relevant to this subscription notification. */
  @Serializable(with = SubscriptionStatusNotificationEventSerializer::class)
  public data class NotificationEvent(
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
     * The sequential number of this event in this subscription context. Note that this value is a
     * 64-bit integer value, encoded as a string.
     */
    public val eventNumber: String,
    /** The actual time this event occured on the server. */
    public val timestamp: Instant? = null,
    /**
     * The focus of this event. While this will usually be a reference to the focus resource of the
     * event, it MAY contain a reference to a non-FHIR object.
     */
    public val focus: Reference? = null,
    /**
     * Additional context information for this event. Generally, this will contain references to
     * additional resources included with the event (e.g., the Patient relevant to an Encounter),
     * however it MAY refer to non-FHIR objects.
     */
    public val additionalContext: List<Reference> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(eventNumber.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          timestamp = this@with.timestamp?.toBuilder()
          focus = this@with.focus?.toBuilder()
          additionalContext = this@with.additionalContext.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * The sequential number of this event in this subscription context. Note that this value is a
       * 64-bit integer value, encoded as a string.
       */
      public var eventNumber: String.Builder
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

      /** The actual time this event occured on the server. */
      public var timestamp: Instant.Builder? = null

      /**
       * The focus of this event. While this will usually be a reference to the focus resource of
       * the event, it MAY contain a reference to a non-FHIR object.
       */
      public var focus: Reference.Builder? = null

      /**
       * Additional context information for this event. Generally, this will contain references to
       * additional resources included with the event (e.g., the Patient relevant to an Encounter),
       * however it MAY refer to non-FHIR objects.
       */
      public var additionalContext: MutableList<Reference.Builder> = mutableListOf()

      public fun build(): NotificationEvent =
        NotificationEvent(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          eventNumber = eventNumber.build(),
          timestamp = timestamp?.build(),
          focus = focus?.build(),
          additionalContext = additionalContext.map { it.build() },
        )
    }
  }

  public class Builder(
    /** The type of event being conveyed with this notificaiton. */
    public var type: Enumeration<SubscriptionNotificationType>,
    /** The reference to the Subscription which generated this notification. */
    public var subscription: Reference.Builder,
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
     * The status of the subscription, which marks the server state for managing the subscription.
     */
    public var status: Enumeration<SubscriptionStatusCodes>? = null

    /**
     * The total number of actual events which have been generated since the Subscription was
     * created (inclusive of this notification) - regardless of how many have been successfully
     * communicated. This number is NOT incremented for handshake and heartbeat notifications.
     */
    public var eventsSinceSubscriptionStart: String.Builder? = null

    /** Detailed information about events relevant to this subscription notification. */
    public var notificationEvent: MutableList<NotificationEvent.Builder> = mutableListOf()

    /**
     * The reference to the SubscriptionTopic for the Subscription which generated this
     * notification.
     *
     * This value SHOULD NOT be present when using `empty` payloads, MAY be present when using
     * `id-only` payloads, and SHOULD be present when using `full-resource` payloads.
     */
    public var topic: Canonical.Builder? = null

    /**
     * A record of errors that occurred when the server processed a notification.
     *
     * Recommended practice: clear errors when status is updated.
     */
    public var error: MutableList<CodeableConcept.Builder> = mutableListOf()

    override fun build(): SubscriptionStatus =
      SubscriptionStatus(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        status = status,
        type = type,
        eventsSinceSubscriptionStart = eventsSinceSubscriptionStart?.build(),
        notificationEvent = notificationEvent.map { it.build() },
        subscription = subscription.build(),
        topic = topic?.build(),
        error = error.map { it.build() },
      )
  }

  /** The status of a subscription. */
  public enum class SubscriptionStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Requested("requested", "http://hl7.org/fhir/subscription-status", "Requested"),
    Active("active", "http://hl7.org/fhir/subscription-status", "Active"),
    Error("error", "http://hl7.org/fhir/subscription-status", "Error"),
    Off("off", "http://hl7.org/fhir/subscription-status", "Off");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SubscriptionStatusCodes =
        when (code) {
          "requested" -> Requested
          "active" -> Active
          "error" -> Error
          "off" -> Off
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SubscriptionStatusCodes")
        }
    }
  }

  /** The type of notification represented by the status message. */
  public enum class SubscriptionNotificationType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Handshake("handshake", "http://hl7.org/fhir/subscription-notification-type", "Handshake"),
    Heartbeat("heartbeat", "http://hl7.org/fhir/subscription-notification-type", "Heartbeat"),
    Event_Notification(
      "event-notification",
      "http://hl7.org/fhir/subscription-notification-type",
      "Event Notification",
    ),
    Query_Status(
      "query-status",
      "http://hl7.org/fhir/subscription-notification-type",
      "Query Status",
    ),
    Query_Event("query-event", "http://hl7.org/fhir/subscription-notification-type", "Query Event");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SubscriptionNotificationType =
        when (code) {
          "handshake" -> Handshake
          "heartbeat" -> Heartbeat
          "event-notification" -> Event_Notification
          "query-status" -> Query_Status
          "query-event" -> Query_Event
          else ->
            throw IllegalArgumentException(
              "Unknown code $code for enum SubscriptionNotificationType"
            )
        }
    }
  }
}
