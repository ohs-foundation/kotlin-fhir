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

package dev.ohs.fhir.model.r4b

import dev.ohs.fhir.model.r4b.serializers.SubscriptionChannelSerializer
import dev.ohs.fhir.model.r4b.serializers.SubscriptionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The subscription resource is used to define a push-based subscription from a server to another
 * system. Once a subscription is registered with the server, the server checks every resource that
 * is created or updated, and if the resource matches the given criteria, it sends a message on the
 * defined "channel" so that another system can take an appropriate action.
 */
@Serializable(with = SubscriptionSerializer::class)
@SerialName("Subscription")
public data class Subscription(
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
   * The status of the subscription, which marks the server state for managing the subscription.
   *
   * A client can only submit subscription resources in the requested or off state. Only the server
   * can move a subscription from requested to active, and then to error. Either the server or the
   * client can turn a subscription off.
   *
   * This element is labeled as a modifier because the status contains codes that mark the resource
   * as not currently valid.
   */
  public val status: Enumeration<SubscriptionStatusCodes>,
  /**
   * Contact details for a human to contact about the subscription. The primary use of this for
   * system administrator troubleshooting.
   */
  public val contact: List<ContactPoint> = listOf(),
  /**
   * The time for the server to turn the subscription off.
   *
   * The server is permitted to deviate from this time but should observe it.
   */
  public val end: Instant? = null,
  /** A description of why this subscription is defined. */
  public val reason: String,
  /**
   * The rules that the server should use to determine when to generate notifications for this
   * subscription.
   *
   * The rules are search criteria (without the [base] part). Like Bundle.entry.request.url, it has
   * no leading "/".
   */
  public val criteria: String,
  /** A record of the last error that occurred when the server processed a notification. */
  public val error: String? = null,
  /** Details where to send notifications when resources are received that meet the criteria. */
  public val channel: Channel,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, reason.toBuilder(), criteria.toBuilder(), channel.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        end = this@with.end?.toBuilder()
        error = this@with.error?.toBuilder()
      }
    }

  /** Details where to send notifications when resources are received that meet the criteria. */
  @Serializable(with = SubscriptionChannelSerializer::class)
  public data class Channel(
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
    /** The type of channel to send notifications on. */
    public val type: Enumeration<SubscriptionChannelType>,
    /**
     * The url that describes the actual end-point to send messages to.
     *
     * For rest-hook, and websocket, the end-point must be an http: or https: URL; for email, a
     * mailto: url, for sms, a tel: url, and for message the endpoint can be in any form of url the
     * server understands (usually, http: or mllp:). The URI is allowed to be relative; in which
     * case, it is relative to the server end-point (since there may be more than one, clients
     * should avoid using relative URIs).
     */
    public val endpoint: Url? = null,
    /**
     * The mime type to send the payload in - either application/fhir+xml, or application/fhir+json.
     * If the payload is not present, then there is no payload in the notification, just a
     * notification. The mime type "text/plain" may also be used for Email and SMS subscriptions.
     *
     * Sending the payload has obvious security implications. The server is responsible for ensuring
     * that the content is appropriately secured.
     */
    public val payload: Code? = null,
    /**
     * Additional headers / information to send as part of the notification.
     *
     * Exactly what these mean depend on the channel type. They can convey additional information to
     * the recipient and/or meet security requirements; for example, support of multiple headers in
     * the outgoing notifications for rest-hook type subscriptions.
     */
    public val `header`: List<String> = listOf(),
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(type).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          endpoint = this@with.endpoint?.toBuilder()
          payload = this@with.payload?.toBuilder()
          `header` = this@with.`header`.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /** The type of channel to send notifications on. */
      public var type: Enumeration<SubscriptionChannelType>
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
       * The url that describes the actual end-point to send messages to.
       *
       * For rest-hook, and websocket, the end-point must be an http: or https: URL; for email, a
       * mailto: url, for sms, a tel: url, and for message the endpoint can be in any form of url
       * the server understands (usually, http: or mllp:). The URI is allowed to be relative; in
       * which case, it is relative to the server end-point (since there may be more than one,
       * clients should avoid using relative URIs).
       */
      public var endpoint: Url.Builder? = null

      /**
       * The mime type to send the payload in - either application/fhir+xml, or
       * application/fhir+json. If the payload is not present, then there is no payload in the
       * notification, just a notification. The mime type "text/plain" may also be used for Email
       * and SMS subscriptions.
       *
       * Sending the payload has obvious security implications. The server is responsible for
       * ensuring that the content is appropriately secured.
       */
      public var payload: Code.Builder? = null

      /**
       * Additional headers / information to send as part of the notification.
       *
       * Exactly what these mean depend on the channel type. They can convey additional information
       * to the recipient and/or meet security requirements; for example, support of multiple
       * headers in the outgoing notifications for rest-hook type subscriptions.
       */
      public var `header`: MutableList<String.Builder> = mutableListOf()

      public fun build(): Channel =
        Channel(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          type = type,
          endpoint = endpoint?.build(),
          payload = payload?.build(),
          `header` = `header`.map { it.build() },
        )
    }
  }

  public class Builder(
    /**
     * The status of the subscription, which marks the server state for managing the subscription.
     *
     * A client can only submit subscription resources in the requested or off state. Only the
     * server can move a subscription from requested to active, and then to error. Either the server
     * or the client can turn a subscription off.
     *
     * This element is labeled as a modifier because the status contains codes that mark the
     * resource as not currently valid.
     */
    public var status: Enumeration<SubscriptionStatusCodes>,
    /** A description of why this subscription is defined. */
    public var reason: String.Builder,
    /**
     * The rules that the server should use to determine when to generate notifications for this
     * subscription.
     *
     * The rules are search criteria (without the [base] part). Like Bundle.entry.request.url, it
     * has no leading "/".
     */
    public var criteria: String.Builder,
    /** Details where to send notifications when resources are received that meet the criteria. */
    public var channel: Channel.Builder,
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

    /**
     * Contact details for a human to contact about the subscription. The primary use of this for
     * system administrator troubleshooting.
     */
    public var contact: MutableList<ContactPoint.Builder> = mutableListOf()

    /**
     * The time for the server to turn the subscription off.
     *
     * The server is permitted to deviate from this time but should observe it.
     */
    public var end: Instant.Builder? = null

    /** A record of the last error that occurred when the server processed a notification. */
    public var error: String.Builder? = null

    override fun build(): Subscription =
      Subscription(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        text = text?.build(),
        contained = contained.map { it.build() },
        extension = extension.map { it.build() },
        modifierExtension = modifierExtension.map { it.build() },
        status = status,
        contact = contact.map { it.build() },
        end = end?.build(),
        reason = reason.build(),
        criteria = criteria.build(),
        error = error?.build(),
        channel = channel.build(),
      )
  }

  /** The type of method used to execute a subscription. */
  public enum class SubscriptionChannelType(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Rest_Hook("rest-hook", "http://hl7.org/fhir/subscription-channel-type", "Rest Hook"),
    Websocket("websocket", "http://hl7.org/fhir/subscription-channel-type", "Websocket"),
    Email("email", "http://hl7.org/fhir/subscription-channel-type", "Email"),
    Sms("sms", "http://hl7.org/fhir/subscription-channel-type", "SMS"),
    Message("message", "http://hl7.org/fhir/subscription-channel-type", "Message");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SubscriptionChannelType =
        when (code) {
          "rest-hook" -> Rest_Hook
          "websocket" -> Websocket
          "email" -> Email
          "sms" -> Sms
          "message" -> Message
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SubscriptionChannelType")
        }
    }
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
}
