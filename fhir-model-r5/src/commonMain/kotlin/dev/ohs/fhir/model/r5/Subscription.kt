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

package dev.ohs.fhir.model.r5

import dev.ohs.fhir.model.r5.serializers.SubscriptionFilterBySerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionParameterSerializer
import dev.ohs.fhir.model.r5.serializers.SubscriptionSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The subscription resource describes a particular client's request to be notified about a
 * SubscriptionTopic.
 */
@Serializable(with = SubscriptionSerializer::class)
@SerialName("Subscription")
public data class Subscription(
  /**
   * The logical id of the resource, as used in the URL for the resource. Once assigned, this value
   * never changes.
   *
   * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
   * like the create and conditional update. Otherwise, the use of the resouce id depends on the
   * given use case.
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
   * A formal identifier that is used to identify this code system when it is represented in other
   * formats, or referenced in a specification, model, design or an instance.
   */
  public val identifier: List<Identifier> = listOf(),
  /** A natural language name identifying the subscription. */
  public val name: String? = null,
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
  /** The reference to the subscription topic to be notified about. */
  public val topic: Canonical,
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
  /**
   * Entity with authorization to make subsequent revisions to the Subscription and also determines
   * what data the subscription is authorized to disclose.
   */
  public val managingEntity: Reference? = null,
  /** A description of why this subscription is defined. */
  public val reason: String? = null,
  /**
   * The filter properties to be applied to narrow the subscription topic stream. When multiple
   * filters are applied, evaluates to true if all the conditions applicable to that resource are
   * met; otherwise it returns false (i.e., logical AND).
   */
  public val filterBy: List<FilterBy> = listOf(),
  /** The type of channel to send notifications on. */
  public val channelType: Coding,
  /**
   * The url that describes the actual end-point to send notifications to.
   *
   * For rest-hook the end-point must be an `http:` or `https:` URL; for websockets, `ws:` or
   * `wss:`; for email, a `mailto:` url; and for message the endpoint can be in any form of url the
   * server understands (usually, `http/s`: or `mllp:`). The URI is allowed to be relative; in which
   * case, it is relative to the server end-point (since there may be more than one, clients should
   * avoid using relative URIs).
   */
  public val endpoint: Url? = null,
  /**
   * Channel-dependent information to send as part of the notification (e.g., HTTP Headers).
   *
   * Exactly what these mean depend on the channel type. They can convey additional information to
   * the server or recipient and/or meet security requirements; for example, support of multiple
   * headers in the outgoing notifications for rest-hook type subscriptions. Note that names are not
   * required to be unique, but channel definitions can impose restrictions.
   */
  public val parameter: List<Parameter> = listOf(),
  /**
   * If present, a 'heartbeat' notification (keep-alive) is sent via this channel with an interval
   * period equal to this elements integer value in seconds. If not present, a heartbeat
   * notification is not sent.
   */
  public val heartbeatPeriod: UnsignedInt? = null,
  /**
   * If present, the maximum amount of time a server will allow before failing a notification
   * attempt.
   */
  public val timeout: UnsignedInt? = null,
  /**
   * The MIME type to send the payload in - e.g., `application/fhir+xml` or `application/fhir+json`.
   * Note that:
   * * clients may request notifications in a specific FHIR version by using the [FHIR Version
   *   Parameter](http.html#version-parameter) - e.g., `application/fhir+json; fhirVersion=4.0`.
   * * additional MIME types can be allowed by channels - e.g., `text/plain` and `text/html` are
   *   defined by the Email channel.
   */
  public val contentType: Code? = null,
  /**
   * How much of the resource content to deliver in the notification payload. The choices are an
   * empty payload, only the resource id, or the full resource content.
   *
   * Sending the payload has obvious security implications. The server is responsible for ensuring
   * that the content is appropriately secured.
   */
  public val content: Enumeration<SubscriptionPayloadContent>? = null,
  /**
   * If present, the maximum number of events that will be included in a notification bundle. Note
   * that this is not a strict limit on the number of entries in a bundle, as dependent resources
   * can be included.
   */
  public val maxCount: PositiveInt? = null,
) : DomainResource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(status, topic.toBuilder(), channelType.toBuilder()).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        text = this@with.text?.toBuilder()
        contained = this@with.contained.map { it.toBuilder() }.toMutableList()
        extension = this@with.extension.map { it.toBuilder() }.toMutableList()
        modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        identifier = this@with.identifier.map { it.toBuilder() }.toMutableList()
        name = this@with.name?.toBuilder()
        contact = this@with.contact.map { it.toBuilder() }.toMutableList()
        end = this@with.end?.toBuilder()
        managingEntity = this@with.managingEntity?.toBuilder()
        reason = this@with.reason?.toBuilder()
        filterBy = this@with.filterBy.map { it.toBuilder() }.toMutableList()
        endpoint = this@with.endpoint?.toBuilder()
        parameter = this@with.parameter.map { it.toBuilder() }.toMutableList()
        heartbeatPeriod = this@with.heartbeatPeriod?.toBuilder()
        timeout = this@with.timeout?.toBuilder()
        contentType = this@with.contentType?.toBuilder()
        content = this@with.content
        maxCount = this@with.maxCount?.toBuilder()
      }
    }

  /**
   * The filter properties to be applied to narrow the subscription topic stream. When multiple
   * filters are applied, evaluates to true if all the conditions applicable to that resource are
   * met; otherwise it returns false (i.e., logical AND).
   */
  @Serializable(with = SubscriptionFilterBySerializer::class)
  public data class FilterBy(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
     * A resource listed in the `SubscriptionTopic` this `Subscription` references
     * (`SubscriptionTopic.canFilterBy.resource`). This element can be used to differentiate filters
     * for topics that include more than one resource type.
     */
    public val resourceType: Uri? = null,
    /** The filter as defined in the `SubscriptionTopic.canFilterBy.filterParameter` element. */
    public val filterParameter: String,
    /**
     * Comparator applied to this filter parameter.
     *
     * Must be a comparator allowed by the SubscriptionTopic relevant to this Subscription filter.
     */
    public val comparator: Enumeration<SearchComparator>? = null,
    /**
     * Modifier applied to this filter parameter.
     *
     * Must be a modifier allowed by the SubscriptionTopic relevant to this Subscription filter.
     */
    public val modifier: Enumeration<SearchModifierCode>? = null,
    /**
     * The literal value or resource path as is legal in search - for example, `Patient/123` or
     * `le1950`.
     */
    public val `value`: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(filterParameter.toBuilder(), `value`.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          resourceType = this@with.resourceType?.toBuilder()
          comparator = this@with.comparator
          modifier = this@with.modifier
        }
      }

    public class Builder(
      /** The filter as defined in the `SubscriptionTopic.canFilterBy.filterParameter` element. */
      public var filterParameter: String.Builder,
      /**
       * The literal value or resource path as is legal in search - for example, `Patient/123` or
       * `le1950`.
       */
      public var `value`: String.Builder,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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
       * A resource listed in the `SubscriptionTopic` this `Subscription` references
       * (`SubscriptionTopic.canFilterBy.resource`). This element can be used to differentiate
       * filters for topics that include more than one resource type.
       */
      public var resourceType: Uri.Builder? = null

      /**
       * Comparator applied to this filter parameter.
       *
       * Must be a comparator allowed by the SubscriptionTopic relevant to this Subscription filter.
       */
      public var comparator: Enumeration<SearchComparator>? = null

      /**
       * Modifier applied to this filter parameter.
       *
       * Must be a modifier allowed by the SubscriptionTopic relevant to this Subscription filter.
       */
      public var modifier: Enumeration<SearchModifierCode>? = null

      public fun build(): FilterBy =
        FilterBy(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          resourceType = resourceType?.build(),
          filterParameter = filterParameter.build(),
          comparator = comparator,
          modifier = modifier,
          `value` = `value`.build(),
        )
    }
  }

  /** Channel-dependent information to send as part of the notification (e.g., HTTP Headers). */
  @Serializable(with = SubscriptionParameterSerializer::class)
  public data class Parameter(
    /**
     * Unique id for the element within a resource (for internal references). This may be any string
     * value that does not contain spaces.
     */
    override val id: kotlin.String? = null,
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
     * Parameter name for information passed to the channel for notifications, for example in the
     * case of a REST hook wanting to pass through an authorization header, the name would be
     * Authorization.
     */
    public val name: String,
    /**
     * Parameter value for information passed to the channel for notifications, for example in the
     * case of a REST hook wanting to pass through an authorization header, the value would be
     * `Bearer 0193...`.
     */
    public val `value`: String,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(name.toBuilder(), `value`.toBuilder()).apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
        }
      }

    public class Builder(
      /**
       * Parameter name for information passed to the channel for notifications, for example in the
       * case of a REST hook wanting to pass through an authorization header, the name would be
       * Authorization.
       */
      public var name: String.Builder,
      /**
       * Parameter value for information passed to the channel for notifications, for example in the
       * case of a REST hook wanting to pass through an authorization header, the value would be
       * `Bearer 0193...`.
       */
      public var `value`: String.Builder,
    ) {
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      public var id: kotlin.String? = null

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

      public fun build(): Parameter =
        Parameter(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          name = name.build(),
          `value` = `value`.build(),
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
    /** The reference to the subscription topic to be notified about. */
    public var topic: Canonical.Builder,
    /** The type of channel to send notifications on. */
    public var channelType: Coding.Builder,
  ) : DomainResource.Builder() {
    /**
     * The logical id of the resource, as used in the URL for the resource. Once assigned, this
     * value never changes.
     *
     * Within the context of the FHIR RESTful interactions, the resource has an id except for cases
     * like the create and conditional update. Otherwise, the use of the resouce id depends on the
     * given use case.
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
     * A formal identifier that is used to identify this code system when it is represented in other
     * formats, or referenced in a specification, model, design or an instance.
     */
    public var identifier: MutableList<Identifier.Builder> = mutableListOf()

    /** A natural language name identifying the subscription. */
    public var name: String.Builder? = null

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

    /**
     * Entity with authorization to make subsequent revisions to the Subscription and also
     * determines what data the subscription is authorized to disclose.
     */
    public var managingEntity: Reference.Builder? = null

    /** A description of why this subscription is defined. */
    public var reason: String.Builder? = null

    /**
     * The filter properties to be applied to narrow the subscription topic stream. When multiple
     * filters are applied, evaluates to true if all the conditions applicable to that resource are
     * met; otherwise it returns false (i.e., logical AND).
     */
    public var filterBy: MutableList<FilterBy.Builder> = mutableListOf()

    /**
     * The url that describes the actual end-point to send notifications to.
     *
     * For rest-hook the end-point must be an `http:` or `https:` URL; for websockets, `ws:` or
     * `wss:`; for email, a `mailto:` url; and for message the endpoint can be in any form of url
     * the server understands (usually, `http/s`: or `mllp:`). The URI is allowed to be relative; in
     * which case, it is relative to the server end-point (since there may be more than one, clients
     * should avoid using relative URIs).
     */
    public var endpoint: Url.Builder? = null

    /**
     * Channel-dependent information to send as part of the notification (e.g., HTTP Headers).
     *
     * Exactly what these mean depend on the channel type. They can convey additional information to
     * the server or recipient and/or meet security requirements; for example, support of multiple
     * headers in the outgoing notifications for rest-hook type subscriptions. Note that names are
     * not required to be unique, but channel definitions can impose restrictions.
     */
    public var parameter: MutableList<Parameter.Builder> = mutableListOf()

    /**
     * If present, a 'heartbeat' notification (keep-alive) is sent via this channel with an interval
     * period equal to this elements integer value in seconds. If not present, a heartbeat
     * notification is not sent.
     */
    public var heartbeatPeriod: UnsignedInt.Builder? = null

    /**
     * If present, the maximum amount of time a server will allow before failing a notification
     * attempt.
     */
    public var timeout: UnsignedInt.Builder? = null

    /**
     * The MIME type to send the payload in - e.g., `application/fhir+xml` or
     * `application/fhir+json`. Note that:
     * * clients may request notifications in a specific FHIR version by using the [FHIR Version
     *   Parameter](http.html#version-parameter) - e.g., `application/fhir+json; fhirVersion=4.0`.
     * * additional MIME types can be allowed by channels - e.g., `text/plain` and `text/html` are
     *   defined by the Email channel.
     */
    public var contentType: Code.Builder? = null

    /**
     * How much of the resource content to deliver in the notification payload. The choices are an
     * empty payload, only the resource id, or the full resource content.
     *
     * Sending the payload has obvious security implications. The server is responsible for ensuring
     * that the content is appropriately secured.
     */
    public var content: Enumeration<SubscriptionPayloadContent>? = null

    /**
     * If present, the maximum number of events that will be included in a notification bundle. Note
     * that this is not a strict limit on the number of entries in a bundle, as dependent resources
     * can be included.
     */
    public var maxCount: PositiveInt.Builder? = null

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
        identifier = identifier.map { it.build() },
        name = name?.build(),
        status = status,
        topic = topic.build(),
        contact = contact.map { it.build() },
        end = end?.build(),
        managingEntity = managingEntity?.build(),
        reason = reason?.build(),
        filterBy = filterBy.map { it.build() },
        channelType = channelType.build(),
        endpoint = endpoint?.build(),
        parameter = parameter.map { it.build() },
        heartbeatPeriod = heartbeatPeriod?.build(),
        timeout = timeout?.build(),
        contentType = contentType?.build(),
        content = content,
        maxCount = maxCount?.build(),
      )
  }

  /** What Search Comparator Codes are supported in search. */
  public enum class SearchComparator(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Eq("eq", "http://hl7.org/fhir/search-comparator", "Equals"),
    Ne("ne", "http://hl7.org/fhir/search-comparator", "Not Equals"),
    Gt("gt", "http://hl7.org/fhir/search-comparator", "Greater Than"),
    Lt("lt", "http://hl7.org/fhir/search-comparator", "Less Than"),
    Ge("ge", "http://hl7.org/fhir/search-comparator", "Greater or Equals"),
    Le("le", "http://hl7.org/fhir/search-comparator", "Less of Equal"),
    Sa("sa", "http://hl7.org/fhir/search-comparator", "Starts After"),
    Eb("eb", "http://hl7.org/fhir/search-comparator", "Ends Before"),
    Ap("ap", "http://hl7.org/fhir/search-comparator", "Approximately");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SearchComparator =
        when (code) {
          "eq" -> Eq
          "ne" -> Ne
          "gt" -> Gt
          "lt" -> Lt
          "ge" -> Ge
          "le" -> Le
          "sa" -> Sa
          "eb" -> Eb
          "ap" -> Ap
          else -> throw IllegalArgumentException("Unknown code $code for enum SearchComparator")
        }
    }
  }

  /** A supported modifier for a search parameter. */
  public enum class SearchModifierCode(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Missing("missing", "http://hl7.org/fhir/search-modifier-code", "Missing"),
    Exact("exact", "http://hl7.org/fhir/search-modifier-code", "Exact"),
    Contains("contains", "http://hl7.org/fhir/search-modifier-code", "Contains"),
    Not("not", "http://hl7.org/fhir/search-modifier-code", "Not"),
    Text("text", "http://hl7.org/fhir/search-modifier-code", "Text"),
    In("in", "http://hl7.org/fhir/search-modifier-code", "In"),
    Not_In("not-in", "http://hl7.org/fhir/search-modifier-code", "Not In"),
    Below("below", "http://hl7.org/fhir/search-modifier-code", "Below"),
    Above("above", "http://hl7.org/fhir/search-modifier-code", "Above"),
    Type("type", "http://hl7.org/fhir/search-modifier-code", "Type"),
    Identifier("identifier", "http://hl7.org/fhir/search-modifier-code", "Identifier"),
    Of_Type("of-type", "http://hl7.org/fhir/search-modifier-code", "Of Type"),
    Code_Text("code-text", "http://hl7.org/fhir/search-modifier-code", "Code Text"),
    Text_Advanced("text-advanced", "http://hl7.org/fhir/search-modifier-code", "Text Advanced"),
    Iterate("iterate", "http://hl7.org/fhir/search-modifier-code", "Iterate");

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SearchModifierCode =
        when (code) {
          "missing" -> Missing
          "exact" -> Exact
          "contains" -> Contains
          "not" -> Not
          "text" -> Text
          "in" -> In
          "not-in" -> Not_In
          "below" -> Below
          "above" -> Above
          "type" -> Type
          "identifier" -> Identifier
          "of-type" -> Of_Type
          "code-text" -> Code_Text
          "text-advanced" -> Text_Advanced
          "iterate" -> Iterate
          else -> throw IllegalArgumentException("Unknown code $code for enum SearchModifierCode")
        }
    }
  }

  /** State values for FHIR Subscriptions. */
  public enum class SubscriptionStatusCodes(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Requested("requested", "http://hl7.org/fhir/subscription-status", "Requested"),
    Active("active", "http://hl7.org/fhir/subscription-status", "Active"),
    Error("error", "http://hl7.org/fhir/subscription-status", "Error"),
    Off("off", "http://hl7.org/fhir/subscription-status", "Off"),
    Entered_In_Error(
      "entered-in-error",
      "http://hl7.org/fhir/subscription-status",
      "Entered in Error",
    );

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
          "entered-in-error" -> Entered_In_Error
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SubscriptionStatusCodes")
        }
    }
  }

  /** Codes to represent how much resource content to send in the notification payload. */
  public enum class SubscriptionPayloadContent(
    private val code: kotlin.String,
    private val system: kotlin.String,
    private val display: kotlin.String?,
  ) {
    Empty("empty", "http://hl7.org/fhir/subscription-payload-content", "Empty"),
    Id_Only("id-only", "http://hl7.org/fhir/subscription-payload-content", "Id-only"),
    Full_Resource(
      "full-resource",
      "http://hl7.org/fhir/subscription-payload-content",
      "Full-resource",
    );

    override fun toString(): kotlin.String = code

    public fun getCode(): kotlin.String = code

    public fun getSystem(): kotlin.String = system

    public fun getDisplay(): kotlin.String? = display

    public companion object {
      public fun fromCode(code: kotlin.String): SubscriptionPayloadContent =
        when (code) {
          "empty" -> Empty
          "id-only" -> Id_Only
          "full-resource" -> Full_Resource
          else ->
            throw IllegalArgumentException("Unknown code $code for enum SubscriptionPayloadContent")
        }
    }
  }
}
