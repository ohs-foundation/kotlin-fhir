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

import dev.ohs.fhir.model.r5.serializers.BundleEntryRequestSerializer
import dev.ohs.fhir.model.r5.serializers.BundleEntryResponseSerializer
import dev.ohs.fhir.model.r5.serializers.BundleEntrySearchSerializer
import dev.ohs.fhir.model.r5.serializers.BundleEntrySerializer
import dev.ohs.fhir.model.r5.serializers.BundleLinkSerializer
import dev.ohs.fhir.model.r5.serializers.BundleSerializer
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/** A container for a collection of resources. */
@Serializable(with = BundleSerializer::class)
@SerialName("Bundle")
public data class Bundle(
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
   * A persistent identifier for the bundle that won't change as a bundle is copied from server to
   * server.
   *
   * Persistent identity generally only matters for batches of type Document, Message, and
   * Collection. It would not normally be populated for search and history results and servers
   * ignore Bundle.identifier when processing batches and transactions. For Documents the
   * .identifier SHALL be populated such that the .identifier is globally unique.
   */
  public val identifier: Identifier? = null,
  /**
   * Indicates the purpose of this bundle - how it is intended to be used.
   *
   * It's possible to use a bundle for other purposes (e.g. a document can be accepted as a
   * transaction). This is primarily defined so that there can be specific rules for some of the
   * bundle types.
   */
  public val type: Enumeration<BundleType>,
  /**
   * The date/time that the bundle was assembled - i.e. when the resources were placed in the
   * bundle.
   *
   * For many bundles, the timestamp is equal to .meta.lastUpdated, because they are not stored
   * (e.g. search results). When a bundle is placed in a persistent store, .meta.lastUpdated will be
   * usually be changed by the server. When the bundle is a message, a middleware agent altering the
   * message (even if not stored) SHOULD update .meta.lastUpdated. .timestamp is used to track the
   * original time of the Bundle, and SHOULD be populated.
   *
   * Usage:
   *
   * * document : the date the document was created. Note: the composition may predate the document,
   *   or be associated with multiple documents. The date of the composition - the authoring time -
   *   may be earlier than the document assembly time
   * * message : the date that the content of the message was assembled. This date is not changed by
   *   middleware engines unless they add additional data that changes the meaning of the time of
   *   the message
   * * history : the date that the history was assembled. This time would be used as the _since time
   *   to ask for subsequent updates
   * * searchset : the time that the search set was assembled. Note that different pages MAY have
   *   different timestamps but need not. Having different timestamps does not imply that subsequent
   *   pages will represent or include changes made since the initial query
   * * transaction | transaction-response | batch | batch-response | collection : no particular
   *   assigned meaning
   *
   * The timestamp value should be greater than the lastUpdated and other timestamps in the
   * resources in the bundle, and it should be equal or earlier than the .meta.lastUpdated on the
   * Bundle itself.
   */
  public val timestamp: Instant? = null,
  /**
   * If a set of search matches, this is the (potentially estimated) total number of entries of type
   * 'match' across all pages in the search. It does not include search.mode = 'include' or
   * 'outcome' entries and it does not provide a count of the number of entries in the Bundle.
   *
   * Only used if the bundle is a search result set. The total does not include resources such as
   * OperationOutcome and included resources, only the total number of matching resources.
   */
  public val total: UnsignedInt? = null,
  /**
   * A series of links that provide context to this bundle.
   *
   * Both Bundle.link and Bundle.entry.link are defined to support providing additional context when
   * Bundles are used (e.g. [HATEOAS](http://en.wikipedia.org/wiki/HATEOAS)).
   *
   * Bundle.entry.link corresponds to links found in the HTTP header if the resource in the entry
   * was [read](http.html#read) directly.
   *
   * This specification defines some specific uses of Bundle.link for
   * [searching](search.html#conformance) and [paging](http.html#paging), but no specific uses for
   * Bundle.entry.link, and no defined function in a transaction - the meaning is implementation
   * specific. The behavior of navigation link types (next/prev/first/last) are well defined for
   * searchset and history Bundles but are not currently defined for other types. Implementers who
   * choose to use such link relationships for other bundle types will need to negotiate behavior
   * with their interoperability partners.
   */
  public val link: List<Link> = listOf(),
  /**
   * An entry in a bundle resource - will either contain a resource or information about a resource
   * (transactions and history only).
   */
  public val entry: List<Entry> = listOf(),
  /**
   * Digital Signature - base64 encoded. XML-DSig or a JWS.
   *
   * The signature could be created by the "author" of the bundle or by the originating device.
   * Requirements around inclusion of a signature, verification of signatures and treatment of
   * signed/non-signed bundles is implementation-environment specific.
   */
  public val signature: Signature? = null,
  /**
   * Captures issues and warnings that relate to the construction of the Bundle and the content
   * within it.
   *
   * Usage notes: These issues and warnings must apply to the Bundle as a whole, not to individual
   * entries.Messages relating to the processing of individual entries (e.g. in a batch or
   * transaction) SHALL be reported in the entry.response.outcome for that entry. If there are
   * errors that arise in the creation of the Bundle, then that should be handled by an
   * OperationOutcome being returned instead of the Bundle.
   */
  public val issues: Resource? = null,
) : Resource() {
  override fun toBuilder(): Builder =
    with(this) {
      Builder(type).apply {
        id = this@with.id
        meta = this@with.meta?.toBuilder()
        implicitRules = this@with.implicitRules?.toBuilder()
        language = this@with.language?.toBuilder()
        identifier = this@with.identifier?.toBuilder()
        timestamp = this@with.timestamp?.toBuilder()
        total = this@with.total?.toBuilder()
        link = this@with.link.map { it.toBuilder() }.toMutableList()
        entry = this@with.entry.map { it.toBuilder() }.toMutableList()
        signature = this@with.signature?.toBuilder()
        issues = this@with.issues?.toBuilder()
      }
    }

  /** A series of links that provide context to this bundle. */
  @Serializable(with = BundleLinkSerializer::class)
  public data class Link(
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
     * A name which details the functional use for this link - see
     * [http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1](http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1).
     */
    public val relation: Enumeration<LinkRelationTypes>,
    /** The reference details for the link. */
    public val url: Uri,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder(
            relation,
            url.toBuilder(),
          )
          .apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          }
      }

    public class Builder(
      /**
       * A name which details the functional use for this link - see
       * [http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1](http://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1).
       */
      public var relation: Enumeration<LinkRelationTypes>,
      /** The reference details for the link. */
      public var url: Uri.Builder,
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

      public fun build(): Link =
        Link(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          relation = relation,
          url = url.build(),
        )
    }
  }

  /**
   * An entry in a bundle resource - will either contain a resource or information about a resource
   * (transactions and history only).
   */
  @Serializable(with = BundleEntrySerializer::class)
  public data class Entry(
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
    /** A series of links that provide context to this entry. */
    public val link: List<Link> = listOf(),
    /**
     * The Absolute URL for the resource. Except for transactions and batches, each entry in a
     * Bundle must have a fullUrl. The fullUrl SHALL NOT disagree with the id in the resource - i.e.
     * if the fullUrl is not a urn:uuid, the URL shall be version-independent URL consistent with
     * the Resource.id. The fullUrl is a version independent reference to the resource. Even when
     * not required, fullUrl MAY be set to a urn:uuid to allow referencing entries in a transaction.
     * The fullUrl can be an arbitrary URI and is not limited to urn:uuid, urn:oid, http, and https.
     * The fullUrl element SHALL have a value except when:
     * * invoking a create
     * * invoking or responding to an operation where the body is not a single identified resource
     * * invoking or returning the results of a search or history operation.
     *
     * fullUrl might not be [unique in the context of a resource](bundle.html#bundle-unique). Note
     * that since [FHIR resources do not need to be served through the FHIR API](references.html),
     * the fullURL might be a URN or an absolute URL that does not end with the logical id of the
     * resource (Resource.id). However, but if the fullUrl does look like a RESTful server URL (e.g.
     * meets the [regex](references.html#regex), then the 'id' portion of the fullUrl SHALL end with
     * the Resource.id.
     *
     * Note that the fullUrl is not the same as the canonical URL - it's an absolute url for an
     * endpoint serving the resource (these will happen to have the same value on the canonical
     * server for the resource with the canonical URL).
     */
    public val fullUrl: Uri? = null,
    /**
     * The Resource for the entry. The purpose/meaning of the resource is determined by the
     * Bundle.type. This is allowed to be a Parameters resource if and only if it is referenced by
     * something else within the Bundle that provides context/meaning.
     */
    public val resource: Resource? = null,
    /** Information about the search process that lead to the creation of this entry. */
    public val search: Search? = null,
    /**
     * Additional information about how this entry should be processed as part of a transaction or
     * batch. For history, it shows how the entry was processed to create the version contained in
     * the entry.
     */
    public val request: Request? = null,
    /**
     * Indicates the results of processing the corresponding 'request' entry in the batch or
     * transaction being responded to or what the results of an operation where when returning
     * history.
     */
    public val response: Response? = null,
  ) : BackboneElement() {
    public fun toBuilder(): Builder =
      with(this) {
        Builder().apply {
          id = this@with.id
          extension = this@with.extension.map { it.toBuilder() }.toMutableList()
          modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
          link = this@with.link.map { it.toBuilder() }.toMutableList()
          fullUrl = this@with.fullUrl?.toBuilder()
          resource = this@with.resource?.toBuilder()
          search = this@with.search?.toBuilder()
          request = this@with.request?.toBuilder()
          response = this@with.response?.toBuilder()
        }
      }

    /** Information about the search process that lead to the creation of this entry. */
    @Serializable(with = BundleEntrySearchSerializer::class)
    public data class Search(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      /**
       * Why this entry is in the result set - whether it's included as a match or because of an
       * _include requirement, or to convey information or warning information about the search
       * process.
       *
       * There is only one mode. In some corner cases, a resource may be included because it is both
       * a match and an include. In these circumstances, 'match' takes precedence.
       */
      public val mode: Enumeration<SearchEntryMode>? = null,
      /**
       * When searching, the server's search ranking score for the entry.
       *
       * Servers are not required to return a ranking score. 1 is most relevant, and 0 is least
       * relevant. Often, search results are sorted by score, but the client may specify a different
       * sort order.
       *
       * See [Patient Match](patient-operation-match.html) for the EMPI search which relates to this
       * element.
       */
      public val score: Decimal? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder().apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            mode = this@with.mode
            score = this@with.score?.toBuilder()
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

        /**
         * Why this entry is in the result set - whether it's included as a match or because of an
         * _include requirement, or to convey information or warning information about the search
         * process.
         *
         * There is only one mode. In some corner cases, a resource may be included because it is
         * both a match and an include. In these circumstances, 'match' takes precedence.
         */
        public var mode: Enumeration<SearchEntryMode>? = null

        /**
         * When searching, the server's search ranking score for the entry.
         *
         * Servers are not required to return a ranking score. 1 is most relevant, and 0 is least
         * relevant. Often, search results are sorted by score, but the client may specify a
         * different sort order.
         *
         * See [Patient Match](patient-operation-match.html) for the EMPI search which relates to
         * this element.
         */
        public var score: Decimal.Builder? = null

        public fun build(): Search =
          Search(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            mode = mode,
            score = score?.build(),
          )
      }
    }

    /**
     * Additional information about how this entry should be processed as part of a transaction or
     * batch. For history, it shows how the entry was processed to create the version contained in
     * the entry.
     */
    @Serializable(with = BundleEntryRequestSerializer::class)
    public data class Request(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      /**
       * In a transaction or batch, this is the HTTP action to be executed for this entry. In a
       * history bundle, this indicates the HTTP action that occurred.
       */
      public val method: Enumeration<HTTPVerb>,
      /**
       * The URL for this entry, relative to the root (the address to which the request is posted).
       *
       * E.g. for a Patient Create, the method would be "POST" and the URL would be "Patient". For a
       * Patient Update, the method would be PUT and the URL would be "Patient/[id]".
       */
      public val url: Uri,
      /**
       * If the ETag values match, return a 304 Not Modified status. See the API documentation for
       * ["Conditional Read"](http.html#cread).
       */
      public val ifNoneMatch: String? = null,
      /**
       * Only perform the operation if the last updated date matches. See the API documentation for
       * ["Conditional Read"](http.html#cread).
       */
      public val ifModifiedSince: Instant? = null,
      /**
       * Only perform the operation if the Etag value matches. For more information, see the API
       * section ["Managing Resource Contention"](http.html#concurrency).
       */
      public val ifMatch: String? = null,
      /**
       * Instruct the server not to perform the create if a specified resource already exists. For
       * further information, see the API documentation for
       * ["Conditional Create"](http.html#ccreate). This is just the query portion of the URL - what
       * follows the "?" (not including the "?").
       */
      public val ifNoneExist: String? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(
              method,
              url.toBuilder(),
            )
            .apply {
              id = this@with.id
              extension = this@with.extension.map { it.toBuilder() }.toMutableList()
              modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
              ifNoneMatch = this@with.ifNoneMatch?.toBuilder()
              ifModifiedSince = this@with.ifModifiedSince?.toBuilder()
              ifMatch = this@with.ifMatch?.toBuilder()
              ifNoneExist = this@with.ifNoneExist?.toBuilder()
            }
        }

      public class Builder(
        /**
         * In a transaction or batch, this is the HTTP action to be executed for this entry. In a
         * history bundle, this indicates the HTTP action that occurred.
         */
        public var method: Enumeration<HTTPVerb>,
        /**
         * The URL for this entry, relative to the root (the address to which the request is
         * posted).
         *
         * E.g. for a Patient Create, the method would be "POST" and the URL would be "Patient". For
         * a Patient Update, the method would be PUT and the URL would be "Patient/[id]".
         */
        public var url: Uri.Builder,
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

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

        /**
         * If the ETag values match, return a 304 Not Modified status. See the API documentation for
         * ["Conditional Read"](http.html#cread).
         */
        public var ifNoneMatch: String.Builder? = null

        /**
         * Only perform the operation if the last updated date matches. See the API documentation
         * for ["Conditional Read"](http.html#cread).
         */
        public var ifModifiedSince: Instant.Builder? = null

        /**
         * Only perform the operation if the Etag value matches. For more information, see the API
         * section ["Managing Resource Contention"](http.html#concurrency).
         */
        public var ifMatch: String.Builder? = null

        /**
         * Instruct the server not to perform the create if a specified resource already exists. For
         * further information, see the API documentation for
         * ["Conditional Create"](http.html#ccreate). This is just the query portion of the URL -
         * what follows the "?" (not including the "?").
         */
        public var ifNoneExist: String.Builder? = null

        public fun build(): Request =
          Request(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            method = method,
            url = url.build(),
            ifNoneMatch = ifNoneMatch?.build(),
            ifModifiedSince = ifModifiedSince?.build(),
            ifMatch = ifMatch?.build(),
            ifNoneExist = ifNoneExist?.build(),
          )
      }
    }

    /**
     * Indicates the results of processing the corresponding 'request' entry in the batch or
     * transaction being responded to or what the results of an operation where when returning
     * history.
     */
    @Serializable(with = BundleEntryResponseSerializer::class)
    public data class Response(
      /**
       * Unique id for the element within a resource (for internal references). This may be any
       * string value that does not contain spaces.
       */
      override val id: kotlin.String? = null,
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
      /**
       * The status code returned by processing this entry. The status SHALL start with a 3 digit
       * HTTP code (e.g. 404) and may contain the standard HTTP description associated with the
       * status code.
       */
      public val status: String,
      /**
       * The location header created by processing this operation, populated if the operation
       * returns a location.
       */
      public val location: Uri? = null,
      /**
       * The Etag for the resource, if the operation for the entry produced a versioned resource
       * (see [Resource Metadata and Versioning](http.html#versioning) and
       * [Managing Resource Contention](http.html#concurrency)).
       *
       * Etags match the Resource.meta.versionId. The ETag has to match the version id in the header
       * if a resource is included.
       */
      public val etag: String? = null,
      /**
       * The date/time that the resource was modified on the server.
       *
       * This has to match the same time in the meta header (meta.lastUpdated) if a resource is
       * included.
       */
      public val lastModified: Instant? = null,
      /**
       * An OperationOutcome containing hints and warnings produced as part of processing this entry
       * in a batch or transaction.
       *
       * For a POST/PUT operation, this is the equivalent outcome that would be returned for prefer
       * = operationoutcome - except that the resource is always returned whether or not the outcome
       * is returned.
       *
       * This outcome is not used for error responses in batch/transaction, only for hints and
       * warnings. In a batch operation, the error will be in Bundle.entry.response, and for
       * transaction, there will be a single OperationOutcome instead of a bundle in the case of an
       * error.
       */
      public val outcome: Resource? = null,
    ) : BackboneElement() {
      public fun toBuilder(): Builder =
        with(this) {
          Builder(status.toBuilder()).apply {
            id = this@with.id
            extension = this@with.extension.map { it.toBuilder() }.toMutableList()
            modifierExtension = this@with.modifierExtension.map { it.toBuilder() }.toMutableList()
            location = this@with.location?.toBuilder()
            etag = this@with.etag?.toBuilder()
            lastModified = this@with.lastModified?.toBuilder()
            outcome = this@with.outcome?.toBuilder()
          }
        }

      public class Builder(
        /**
         * The status code returned by processing this entry. The status SHALL start with a 3 digit
         * HTTP code (e.g. 404) and may contain the standard HTTP description associated with the
         * status code.
         */
        public var status: String.Builder
      ) {
        /**
         * Unique id for the element within a resource (for internal references). This may be any
         * string value that does not contain spaces.
         */
        public var id: kotlin.String? = null

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

        /**
         * The location header created by processing this operation, populated if the operation
         * returns a location.
         */
        public var location: Uri.Builder? = null

        /**
         * The Etag for the resource, if the operation for the entry produced a versioned resource
         * (see [Resource Metadata and Versioning](http.html#versioning) and
         * [Managing Resource Contention](http.html#concurrency)).
         *
         * Etags match the Resource.meta.versionId. The ETag has to match the version id in the
         * header if a resource is included.
         */
        public var etag: String.Builder? = null

        /**
         * The date/time that the resource was modified on the server.
         *
         * This has to match the same time in the meta header (meta.lastUpdated) if a resource is
         * included.
         */
        public var lastModified: Instant.Builder? = null

        /**
         * An OperationOutcome containing hints and warnings produced as part of processing this
         * entry in a batch or transaction.
         *
         * For a POST/PUT operation, this is the equivalent outcome that would be returned for
         * prefer = operationoutcome - except that the resource is always returned whether or not
         * the outcome is returned.
         *
         * This outcome is not used for error responses in batch/transaction, only for hints and
         * warnings. In a batch operation, the error will be in Bundle.entry.response, and for
         * transaction, there will be a single OperationOutcome instead of a bundle in the case of
         * an error.
         */
        public var outcome: Resource.Builder? = null

        public fun build(): Response =
          Response(
            id = id,
            extension = extension.map { it.build() },
            modifierExtension = modifierExtension.map { it.build() },
            status = status.build(),
            location = location?.build(),
            etag = etag?.build(),
            lastModified = lastModified?.build(),
            outcome = outcome?.build(),
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

      /** A series of links that provide context to this entry. */
      public var link: MutableList<Link.Builder> = mutableListOf()

      /**
       * The Absolute URL for the resource. Except for transactions and batches, each entry in a
       * Bundle must have a fullUrl. The fullUrl SHALL NOT disagree with the id in the resource -
       * i.e. if the fullUrl is not a urn:uuid, the URL shall be version-independent URL consistent
       * with the Resource.id. The fullUrl is a version independent reference to the resource. Even
       * when not required, fullUrl MAY be set to a urn:uuid to allow referencing entries in a
       * transaction. The fullUrl can be an arbitrary URI and is not limited to urn:uuid, urn:oid,
       * http, and https. The fullUrl element SHALL have a value except when:
       * * invoking a create
       * * invoking or responding to an operation where the body is not a single identified resource
       * * invoking or returning the results of a search or history operation.
       *
       * fullUrl might not be [unique in the context of a resource](bundle.html#bundle-unique). Note
       * that since [FHIR resources do not need to be served through the FHIR API](references.html),
       * the fullURL might be a URN or an absolute URL that does not end with the logical id of the
       * resource (Resource.id). However, but if the fullUrl does look like a RESTful server URL
       * (e.g. meets the [regex](references.html#regex), then the 'id' portion of the fullUrl SHALL
       * end with the Resource.id.
       *
       * Note that the fullUrl is not the same as the canonical URL - it's an absolute url for an
       * endpoint serving the resource (these will happen to have the same value on the canonical
       * server for the resource with the canonical URL).
       */
      public var fullUrl: Uri.Builder? = null

      /**
       * The Resource for the entry. The purpose/meaning of the resource is determined by the
       * Bundle.type. This is allowed to be a Parameters resource if and only if it is referenced by
       * something else within the Bundle that provides context/meaning.
       */
      public var resource: Resource.Builder? = null

      /** Information about the search process that lead to the creation of this entry. */
      public var search: Search.Builder? = null

      /**
       * Additional information about how this entry should be processed as part of a transaction or
       * batch. For history, it shows how the entry was processed to create the version contained in
       * the entry.
       */
      public var request: Request.Builder? = null

      /**
       * Indicates the results of processing the corresponding 'request' entry in the batch or
       * transaction being responded to or what the results of an operation where when returning
       * history.
       */
      public var response: Response.Builder? = null

      public fun build(): Entry =
        Entry(
          id = id,
          extension = extension.map { it.build() },
          modifierExtension = modifierExtension.map { it.build() },
          link = link.map { it.build() },
          fullUrl = fullUrl?.build(),
          resource = resource?.build(),
          search = search?.build(),
          request = request?.build(),
          response = response?.build(),
        )
    }
  }

  public class Builder(
    /**
     * Indicates the purpose of this bundle - how it is intended to be used.
     *
     * It's possible to use a bundle for other purposes (e.g. a document can be accepted as a
     * transaction). This is primarily defined so that there can be specific rules for some of the
     * bundle types.
     */
    public var type: Enumeration<BundleType>
  ) : Resource.Builder() {
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
     * A persistent identifier for the bundle that won't change as a bundle is copied from server to
     * server.
     *
     * Persistent identity generally only matters for batches of type Document, Message, and
     * Collection. It would not normally be populated for search and history results and servers
     * ignore Bundle.identifier when processing batches and transactions. For Documents the
     * .identifier SHALL be populated such that the .identifier is globally unique.
     */
    public var identifier: Identifier.Builder? = null

    /**
     * The date/time that the bundle was assembled - i.e. when the resources were placed in the
     * bundle.
     *
     * For many bundles, the timestamp is equal to .meta.lastUpdated, because they are not stored
     * (e.g. search results). When a bundle is placed in a persistent store, .meta.lastUpdated will
     * be usually be changed by the server. When the bundle is a message, a middleware agent
     * altering the message (even if not stored) SHOULD update .meta.lastUpdated. .timestamp is used
     * to track the original time of the Bundle, and SHOULD be populated.
     *
     * Usage:
     *
     * * document : the date the document was created. Note: the composition may predate the
     *   document, or be associated with multiple documents. The date of the composition - the
     *   authoring time - may be earlier than the document assembly time
     * * message : the date that the content of the message was assembled. This date is not changed
     *   by middleware engines unless they add additional data that changes the meaning of the time
     *   of the message
     * * history : the date that the history was assembled. This time would be used as the _since
     *   time to ask for subsequent updates
     * * searchset : the time that the search set was assembled. Note that different pages MAY have
     *   different timestamps but need not. Having different timestamps does not imply that
     *   subsequent pages will represent or include changes made since the initial query
     * * transaction | transaction-response | batch | batch-response | collection : no particular
     *   assigned meaning
     *
     * The timestamp value should be greater than the lastUpdated and other timestamps in the
     * resources in the bundle, and it should be equal or earlier than the .meta.lastUpdated on the
     * Bundle itself.
     */
    public var timestamp: Instant.Builder? = null

    /**
     * If a set of search matches, this is the (potentially estimated) total number of entries of
     * type 'match' across all pages in the search. It does not include search.mode = 'include' or
     * 'outcome' entries and it does not provide a count of the number of entries in the Bundle.
     *
     * Only used if the bundle is a search result set. The total does not include resources such as
     * OperationOutcome and included resources, only the total number of matching resources.
     */
    public var total: UnsignedInt.Builder? = null

    /**
     * A series of links that provide context to this bundle.
     *
     * Both Bundle.link and Bundle.entry.link are defined to support providing additional context
     * when Bundles are used (e.g. [HATEOAS](http://en.wikipedia.org/wiki/HATEOAS)).
     *
     * Bundle.entry.link corresponds to links found in the HTTP header if the resource in the entry
     * was [read](http.html#read) directly.
     *
     * This specification defines some specific uses of Bundle.link for
     * [searching](search.html#conformance) and [paging](http.html#paging), but no specific uses for
     * Bundle.entry.link, and no defined function in a transaction - the meaning is implementation
     * specific. The behavior of navigation link types (next/prev/first/last) are well defined for
     * searchset and history Bundles but are not currently defined for other types. Implementers who
     * choose to use such link relationships for other bundle types will need to negotiate behavior
     * with their interoperability partners.
     */
    public var link: MutableList<Link.Builder> = mutableListOf()

    /**
     * An entry in a bundle resource - will either contain a resource or information about a
     * resource (transactions and history only).
     */
    public var entry: MutableList<Entry.Builder> = mutableListOf()

    /**
     * Digital Signature - base64 encoded. XML-DSig or a JWS.
     *
     * The signature could be created by the "author" of the bundle or by the originating device.
     * Requirements around inclusion of a signature, verification of signatures and treatment of
     * signed/non-signed bundles is implementation-environment specific.
     */
    public var signature: Signature.Builder? = null

    /**
     * Captures issues and warnings that relate to the construction of the Bundle and the content
     * within it.
     *
     * Usage notes: These issues and warnings must apply to the Bundle as a whole, not to individual
     * entries.Messages relating to the processing of individual entries (e.g. in a batch or
     * transaction) SHALL be reported in the entry.response.outcome for that entry. If there are
     * errors that arise in the creation of the Bundle, then that should be handled by an
     * OperationOutcome being returned instead of the Bundle.
     */
    public var issues: Resource.Builder? = null

    override fun build(): Bundle =
      Bundle(
        id = id,
        meta = meta?.build(),
        implicitRules = implicitRules?.build(),
        language = language?.build(),
        identifier = identifier?.build(),
        type = type,
        timestamp = timestamp?.build(),
        total = total?.build(),
        link = link.map { it.build() },
        entry = entry.map { it.build() },
        signature = signature?.build(),
        issues = issues?.build(),
      )
  }

  /**
   * Link Relation Types defined at
   * https://www.iana.org/assignments/link-relations/link-relations.xhtml#link-relations-1
   */
  public enum class LinkRelationTypes(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    About(
      "about",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a resource that is the subject of the link's context.",
    ),
    Acl(
      "acl",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Asserts that the link target provides an access control description for the link context.",
    ),
    Alternate(
      "alternate",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a substitute for this context",
    ),
    Amphtml(
      "amphtml",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Used to reference alternative content that uses the AMP profile of the HTML format.",
    ),
    Appendix(
      "appendix",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to an appendix.",
    ),
    Apple_Touch_Icon(
      "apple-touch-icon",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to an icon for the context. Synonym for icon.",
    ),
    Apple_Touch_Startup_Image(
      "apple-touch-startup-image",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a launch screen for the context.",
    ),
    Archives(
      "archives",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a collection of records, documents, or other
      |      materials of historical interest.
      """
        .trimMargin(),
    ),
    Author(
      "author",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to the context's author.",
    ),
    Blocked_By(
      "blocked-by",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies the entity that blocks access to a resource
      |      following receipt of a legal demand.
      """
        .trimMargin(),
    ),
    Bookmark(
      "bookmark",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Gives a permanent link to use for bookmarking purposes.",
    ),
    Canonical(
      "canonical",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Designates the preferred version of a resource (the IRI and its contents).",
    ),
    Chapter(
      "chapter",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a chapter in a collection of resources.",
    ),
    Cite_As(
      "cite-as",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates that the link target is preferred over the link context for the purpose of permanent citation.",
    ),
    Collection(
      "collection",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The target IRI points to a resource which represents the collection resource for the context IRI.",
    ),
    Contents(
      "contents",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a table of contents.",
    ),
    ConvertedFrom(
      "convertedFrom",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The document linked to was later converted to the
      |      document that contains this link relation.  For example, an RFC can
      |      have a link to the Internet-Draft that became the RFC; in that case,
      |      the link relation would be "convertedFrom".
      """
        .trimMargin(),
    ),
    Copyright(
      "copyright",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a copyright statement that applies to the
      |    link's context.
      """
        .trimMargin(),
    ),
    Create_Form(
      "create-form",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The target IRI points to a resource where a submission form can be obtained.",
    ),
    Current(
      "current",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource containing the most recent
      |      item(s) in a collection of resources.
      """
        .trimMargin(),
    ),
    Describedby(
      "describedby",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource providing information about the
      |      link's context.
      """
        .trimMargin(),
    ),
    Describes(
      "describes",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The relationship A 'describes' B asserts that
      |      resource A provides a description of resource B. There are no
      |      constraints on the format or representation of either A or B,
      |      neither are there any further constraints on either resource.
      """
        .trimMargin(),
    ),
    Disclosure(
      "disclosure",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a list of patent disclosures made with respect to 
      |      material for which 'disclosure' relation is specified.
      """
        .trimMargin(),
    ),
    Dns_Prefetch(
      "dns-prefetch",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Used to indicate an origin that will be used to fetch required 
      |      resources for the link context, and that the user agent ought to resolve 
      |      as early as possible.
      """
        .trimMargin(),
    ),
    Duplicate(
      "duplicate",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource whose available representations
      |      are byte-for-byte identical with the corresponding representations of
      |      the context IRI.
      """
        .trimMargin(),
    ),
    Edit(
      "edit",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that can be used to edit the
      |      link's context.
      """
        .trimMargin(),
    ),
    Edit_Form(
      "edit-form",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The target IRI points to a resource where a submission form for
      |      editing associated resource can be obtained.
      """
        .trimMargin(),
    ),
    Edit_Media(
      "edit-media",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that can be used to edit media
      |      associated with the link's context.
      """
        .trimMargin(),
    ),
    Enclosure(
      "enclosure",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a related resource that is potentially
      |      large and might require special handling.
      """
        .trimMargin(),
    ),
    External(
      "external",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a resource that is not part of the same site as the current context.",
    ),
    First(
      "first",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |An IRI that refers to the furthest preceding resource
      |    in a series of resources.
      """
        .trimMargin(),
    ),
    Glossary(
      "glossary",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a glossary of terms.",
    ),
    Help(
      "help",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to context-sensitive help.",
    ),
    Hosts(
      "hosts",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource hosted by the server indicated by
      |      the link context.
      """
        .trimMargin(),
    ),
    Hub(
      "hub",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a hub that enables registration for
      |    notification of updates to the context.
      """
        .trimMargin(),
    ),
    Icon(
      "icon",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to an icon representing the link's context.",
    ),
    Index("index", "http://hl7.org/fhir/CodeSystem/iana-link-relations", "Refers to an index."),
    IntervalAfter(
      "intervalAfter",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that ends before the beginning of the time interval associated with the context resource",
    ),
    IntervalBefore(
      "intervalBefore",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource",
    ),
    IntervalContains(
      "intervalContains",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource",
    ),
    IntervalDisjoint(
      "intervalDisjoint",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins after the end of the time interval associated with the context resource, or ends before the beginning of the time interval associated with the context resource",
    ),
    IntervalDuring(
      "intervalDuring",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
    ),
    IntervalEquals(
      "intervalEquals",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
    ),
    IntervalFinishedBy(
      "intervalFinishedBy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins after the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
    ),
    IntervalFinishes(
      "intervalFinishes",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and whose end coincides with the end of the time interval associated with the context resource",
    ),
    IntervalIn(
      "intervalIn",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins before or is coincident with the beginning of the time interval associated with the context resource, and ends after or is coincident with the end of the time interval associated with the context resource",
    ),
    IntervalMeets(
      "intervalMeets",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval whose beginning coincides with the end of the time interval associated with the context resource",
    ),
    IntervalMetBy(
      "intervalMetBy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval whose end coincides with the beginning of the time interval associated with the context resource",
    ),
    IntervalOverlappedBy(
      "intervalOverlappedBy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins before the beginning of the time interval associated with the context resource, and ends after the beginning of the time interval associated with the context resource",
    ),
    IntervalOverlaps(
      "intervalOverlaps",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval that begins before the end of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
    ),
    IntervalStartedBy(
      "intervalStartedBy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends before the end of the time interval associated with the context resource",
    ),
    IntervalStarts(
      "intervalStarts",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "refers to a resource associated with a time interval whose beginning coincides with the beginning of the time interval associated with the context resource, and ends after the end of the time interval associated with the context resource",
    ),
    Item(
      "item",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The target IRI points to a resource that is a member of the collection represented by the context IRI.",
    ),
    Last(
      "last",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |An IRI that refers to the furthest following resource
      |      in a series of resources.
      """
        .trimMargin(),
    ),
    Latest_Version(
      "latest-version",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Points to a resource containing the latest (e.g.,
      |      current) version of the context.
      """
        .trimMargin(),
    ),
    License(
      "license",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a license associated with this context.",
    ),
    Linkset(
      "linkset",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The link target of a link with the "linkset" relation
      |      type provides a set of links, including links in which the link
      |      context of the link participates.
      |    
      """
        .trimMargin(),
    ),
    Lrdd(
      "lrdd",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to further information about the link's context,
      |      expressed as a LRDD ("Link-based Resource Descriptor Document")
      |      resource.  See  for information about
      |      processing this relation type in host-meta documents. When used
      |      elsewhere, it refers to additional links and other metadata.
      |      Multiple instances indicate additional LRDD resources. LRDD
      |      resources MUST have an "application/xrd+xml" representation, and
      |      MAY have others.
      """
        .trimMargin(),
    ),
    Manifest(
      "manifest",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Links to a manifest file for the context.",
    ),
    Mask_Icon(
      "mask-icon",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a mask that can be applied to the icon for the context.",
    ),
    Media_Feed(
      "media-feed",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a feed of personalised media recommendations relevant to the link context.",
    ),
    Memento(
      "memento",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The Target IRI points to a Memento, a fixed resource that will not change state anymore.",
    ),
    Micropub(
      "micropub",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Links to the context's Micropub endpoint.",
    ),
    Modulepreload(
      "modulepreload",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a module that the user agent is to preemptively fetch and store for use in the current context.",
    ),
    Monitor(
      "monitor",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that can be used to monitor changes in an HTTP resource.
      |    
      """
        .trimMargin(),
    ),
    Monitor_Group(
      "monitor-group",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that can be used to monitor changes in a specified group of HTTP resources.
      |    
      """
        .trimMargin(),
    ),
    Next(
      "next",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Indicates that the link's context is a part of a series, and
      |      that the next in the series is the link target.
      |    
      """
        .trimMargin(),
    ),
    Next_Archive(
      "next-archive",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to the immediately following archive resource.",
    ),
    Nofollow(
      "nofollow",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates that the context’s original author or publisher does not endorse the link target.",
    ),
    Noopener(
      "noopener",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates that any newly created top-level browsing context which results from following the link will not be an auxiliary browsing context.",
    ),
    Noreferrer(
      "noreferrer",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates that no referrer information is to be leaked when following the link.",
    ),
    Opener(
      "opener",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates that any newly created top-level browsing context which results from following the link will be an auxiliary browsing context.",
    ),
    Openid2_Local_Id(
      "openid2.local_id",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to an OpenID Authentication server on which the context relies for an assertion that the end user controls an Identifier.",
    ),
    Openid2_Provider(
      "openid2.provider",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a resource which accepts OpenID Authentication protocol messages for the context.",
    ),
    Original(
      "original",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The Target IRI points to an Original Resource.",
    ),
    P3Pv1(
      "P3Pv1",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a P3P privacy policy for the context.",
    ),
    Payment(
      "payment",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Indicates a resource where payment is accepted.",
    ),
    Pingback(
      "pingback",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Gives the address of the pingback resource for the link context.",
    ),
    Preconnect(
      "preconnect",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Used to indicate an origin that will be used to fetch required 
      |      resources for the link context. Initiating an early connection, which 
      |      includes the DNS lookup, TCP handshake, and optional TLS negotiation, 
      |      allows the user agent to mask the high latency costs of establishing a 
      |      connection.
      """
        .trimMargin(),
    ),
    Predecessor_Version(
      "predecessor-version",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Points to a resource containing the predecessor
      |      version in the version history.
      |    
      """
        .trimMargin(),
    ),
    Prefetch(
      "prefetch",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The prefetch link relation type is used to identify a resource 
      |      that might be required by the next navigation from the link context, and 
      |      that the user agent ought to fetch, such that the user agent can deliver a 
      |      faster response once the resource is requested in the future.
      """
        .trimMargin(),
    ),
    Preload(
      "preload",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that should be loaded early in the 
      |      processing of the link's context, without blocking rendering.
      """
        .trimMargin(),
    ),
    Prerender(
      "prerender",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Used to identify a resource that might be required by the next 
      |      navigation from the link context, and that the user agent ought to fetch 
      |      and execute, such that the user agent can deliver a faster response once 
      |      the resource is requested in the future.
      """
        .trimMargin(),
    ),
    Prev(
      "prev",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Indicates that the link's context is a part of a series, and
      |      that the previous in the series is the link target.
      |    
      """
        .trimMargin(),
    ),
    Preview(
      "preview",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a resource that provides a preview of the link's context.",
    ),
    Previous(
      "previous",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to the previous resource in an ordered series
      |      of resources.  Synonym for "prev".
      """
        .trimMargin(),
    ),
    Prev_Archive(
      "prev-archive",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to the immediately preceding archive resource.",
    ),
    Privacy_Policy(
      "privacy-policy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a privacy policy associated with the link's context.",
    ),
    Profile(
      "profile",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifying that a resource representation conforms
      |to a certain profile, without affecting the non-profile semantics
      |of the resource representation.
      """
        .trimMargin(),
    ),
    Publication(
      "publication",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Links to a publication manifest. A manifest represents 
      |      structured information about a publication, such as informative metadata, 
      |      a list of resources, and a default reading order.
      """
        .trimMargin(),
    ),
    Related(
      "related",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Identifies a related resource.",
    ),
    Restconf(
      "restconf",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies the root of RESTCONF API as configured on this HTTP server.
      |      The "restconf" relation defines the root of the API defined in RFC8040.
      |      Subsequent revisions of RESTCONF will use alternate relation values to support 
      |      protocol versioning.
      """
        .trimMargin(),
    ),
    Replies(
      "replies",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a resource that is a reply to the context
      |      of the link.
      |    
      """
        .trimMargin(),
    ),
    Ruleinput(
      "ruleinput",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |The resource identified by the link target provides an input value to an 
      |    instance of a rule, where the resource which represents the rule instance is 
      |    identified by the link context.
      |    
      """
        .trimMargin(),
    ),
    Search(
      "search",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that can be used to search through
      |      the link's context and related resources.
      """
        .trimMargin(),
    ),
    Section(
      "section",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a section in a collection of resources.",
    ),
    Self(
      "self",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Conveys an identifier for the link's context.
      |    
      """
        .trimMargin(),
    ),
    Service(
      "service",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Indicates a URI that can be used to retrieve a
      |      service document.
      """
        .trimMargin(),
    ),
    Service_Desc(
      "service-desc",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies service description for the context that
      |      is primarily intended for consumption by machines.
      """
        .trimMargin(),
    ),
    Service_Doc(
      "service-doc",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies service documentation for the context that
      |      is primarily intended for human consumption.
      """
        .trimMargin(),
    ),
    Service_Meta(
      "service-meta",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies general metadata for the context that is
      |      primarily intended for consumption by machines.
      """
        .trimMargin(),
    ),
    Sponsored(
      "sponsored",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that is within a context that is 
      |		sponsored (such as advertising or another compensation agreement).
      """
        .trimMargin(),
    ),
    Start(
      "start",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to the first resource in a collection of
      |      resources.
      """
        .trimMargin(),
    ),
    Status(
      "status",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a resource that represents the context's
      |      status.
      """
        .trimMargin(),
    ),
    Stylesheet(
      "stylesheet",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a stylesheet.",
    ),
    Subsection(
      "subsection",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource serving as a subsection in a
      |      collection of resources.
      """
        .trimMargin(),
    ),
    Successor_Version(
      "successor-version",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Points to a resource containing the successor version
      |      in the version history.
      |    
      """
        .trimMargin(),
    ),
    Sunset(
      "sunset",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a resource that provides information about
      |      the context's retirement policy.
      |    
      """
        .trimMargin(),
    ),
    Tag(
      "tag",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Gives a tag (identified by the given address) that applies to
      |      the current document.
      |    
      """
        .trimMargin(),
    ),
    Terms_Of_Service(
      "terms-of-service",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to the terms of service associated with the link's context.",
    ),
    Timegate(
      "timegate",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The Target IRI points to a TimeGate for an Original Resource.",
    ),
    Timemap(
      "timemap",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "The Target IRI points to a TimeMap for an Original Resource.",
    ),
    Type(
      "type",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Refers to a resource identifying the abstract semantic type of which the link's context is considered to be an instance.",
    ),
    Ugc(
      "ugc",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a resource that is within a context that is User Generated Content.
      |    
      """
        .trimMargin(),
    ),
    Up(
      "up",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Refers to a parent document in a hierarchy of
      |      documents.
      |    
      """
        .trimMargin(),
    ),
    Version_History(
      "version-history",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Points to a resource containing the version history
      |      for the context.
      |    
      """
        .trimMargin(),
    ),
    Via(
      "via",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a resource that is the source of the
      |      information in the link's context.
      |    
      """
        .trimMargin(),
    ),
    Webmention(
      "webmention",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Identifies a target URI that supports the Webmention protocol.
      |    This allows clients that mention a resource in some form of publishing process
      |    to contact that endpoint and inform it that this resource has been mentioned.
      """
        .trimMargin(),
    ),
    Working_Copy(
      "working-copy",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      "Points to a working copy for this resource.",
    ),
    Working_Copy_Of(
      "working-copy-of",
      "http://hl7.org/fhir/CodeSystem/iana-link-relations",
      """
      |Points to the versioned resource from which this
      |      working copy was obtained.
      |    
      """
        .trimMargin(),
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): LinkRelationTypes =
        when (code) {
          "about" -> About
          "acl" -> Acl
          "alternate" -> Alternate
          "amphtml" -> Amphtml
          "appendix" -> Appendix
          "apple-touch-icon" -> Apple_Touch_Icon
          "apple-touch-startup-image" -> Apple_Touch_Startup_Image
          "archives" -> Archives
          "author" -> Author
          "blocked-by" -> Blocked_By
          "bookmark" -> Bookmark
          "canonical" -> Canonical
          "chapter" -> Chapter
          "cite-as" -> Cite_As
          "collection" -> Collection
          "contents" -> Contents
          "convertedFrom" -> ConvertedFrom
          "copyright" -> Copyright
          "create-form" -> Create_Form
          "current" -> Current
          "describedby" -> Describedby
          "describes" -> Describes
          "disclosure" -> Disclosure
          "dns-prefetch" -> Dns_Prefetch
          "duplicate" -> Duplicate
          "edit" -> Edit
          "edit-form" -> Edit_Form
          "edit-media" -> Edit_Media
          "enclosure" -> Enclosure
          "external" -> External
          "first" -> First
          "glossary" -> Glossary
          "help" -> Help
          "hosts" -> Hosts
          "hub" -> Hub
          "icon" -> Icon
          "index" -> Index
          "intervalAfter" -> IntervalAfter
          "intervalBefore" -> IntervalBefore
          "intervalContains" -> IntervalContains
          "intervalDisjoint" -> IntervalDisjoint
          "intervalDuring" -> IntervalDuring
          "intervalEquals" -> IntervalEquals
          "intervalFinishedBy" -> IntervalFinishedBy
          "intervalFinishes" -> IntervalFinishes
          "intervalIn" -> IntervalIn
          "intervalMeets" -> IntervalMeets
          "intervalMetBy" -> IntervalMetBy
          "intervalOverlappedBy" -> IntervalOverlappedBy
          "intervalOverlaps" -> IntervalOverlaps
          "intervalStartedBy" -> IntervalStartedBy
          "intervalStarts" -> IntervalStarts
          "item" -> Item
          "last" -> Last
          "latest-version" -> Latest_Version
          "license" -> License
          "linkset" -> Linkset
          "lrdd" -> Lrdd
          "manifest" -> Manifest
          "mask-icon" -> Mask_Icon
          "media-feed" -> Media_Feed
          "memento" -> Memento
          "micropub" -> Micropub
          "modulepreload" -> Modulepreload
          "monitor" -> Monitor
          "monitor-group" -> Monitor_Group
          "next" -> Next
          "next-archive" -> Next_Archive
          "nofollow" -> Nofollow
          "noopener" -> Noopener
          "noreferrer" -> Noreferrer
          "opener" -> Opener
          "openid2.local_id" -> Openid2_Local_Id
          "openid2.provider" -> Openid2_Provider
          "original" -> Original
          "P3Pv1" -> P3Pv1
          "payment" -> Payment
          "pingback" -> Pingback
          "preconnect" -> Preconnect
          "predecessor-version" -> Predecessor_Version
          "prefetch" -> Prefetch
          "preload" -> Preload
          "prerender" -> Prerender
          "prev" -> Prev
          "preview" -> Preview
          "previous" -> Previous
          "prev-archive" -> Prev_Archive
          "privacy-policy" -> Privacy_Policy
          "profile" -> Profile
          "publication" -> Publication
          "related" -> Related
          "restconf" -> Restconf
          "replies" -> Replies
          "ruleinput" -> Ruleinput
          "search" -> Search
          "section" -> Section
          "self" -> Self
          "service" -> Service
          "service-desc" -> Service_Desc
          "service-doc" -> Service_Doc
          "service-meta" -> Service_Meta
          "sponsored" -> Sponsored
          "start" -> Start
          "status" -> Status
          "stylesheet" -> Stylesheet
          "subsection" -> Subsection
          "successor-version" -> Successor_Version
          "sunset" -> Sunset
          "tag" -> Tag
          "terms-of-service" -> Terms_Of_Service
          "timegate" -> Timegate
          "timemap" -> Timemap
          "type" -> Type
          "ugc" -> Ugc
          "up" -> Up
          "version-history" -> Version_History
          "via" -> Via
          "webmention" -> Webmention
          "working-copy" -> Working_Copy
          "working-copy-of" -> Working_Copy_Of
          else -> throw IllegalArgumentException("Unknown code $code for enum LinkRelationTypes")
        }
    }
  }

  /**
   * Why an entry is in the result set - whether it's included as a match or because of an _include
   * requirement, or to convey information or warning information about the search process.
   */
  public enum class SearchEntryMode(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Match("match", "http://hl7.org/fhir/search-entry-mode", "Match"),
    Include("include", "http://hl7.org/fhir/search-entry-mode", "Include"),
    Outcome("outcome", "http://hl7.org/fhir/search-entry-mode", "Outcome");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): SearchEntryMode =
        when (code) {
          "match" -> Match
          "include" -> Include
          "outcome" -> Outcome
          else -> throw IllegalArgumentException("Unknown code $code for enum SearchEntryMode")
        }
    }
  }

  /**
   * HTTP verbs (in the HTTP command line). See [HTTP rfc](https://tools.ietf.org/html/rfc7231) for
   * details.
   */
  public enum class HTTPVerb(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Get("GET", "http://hl7.org/fhir/http-verb", "GET"),
    Head("HEAD", "http://hl7.org/fhir/http-verb", "HEAD"),
    Post("POST", "http://hl7.org/fhir/http-verb", "POST"),
    Put("PUT", "http://hl7.org/fhir/http-verb", "PUT"),
    Delete("DELETE", "http://hl7.org/fhir/http-verb", "DELETE"),
    Patch("PATCH", "http://hl7.org/fhir/http-verb", "PATCH");

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): HTTPVerb =
        when (code) {
          "GET" -> Get
          "HEAD" -> Head
          "POST" -> Post
          "PUT" -> Put
          "DELETE" -> Delete
          "PATCH" -> Patch
          else -> throw IllegalArgumentException("Unknown code $code for enum HTTPVerb")
        }
    }
  }

  /** Indicates the purpose of a bundle - how it is intended to be used. */
  public enum class BundleType(
    override val code: kotlin.String,
    override val system: kotlin.String,
    override val display: kotlin.String?,
  ) : FhirEnum {
    Document("document", "http://hl7.org/fhir/bundle-type", "Document"),
    Message("message", "http://hl7.org/fhir/bundle-type", "Message"),
    Transaction("transaction", "http://hl7.org/fhir/bundle-type", "Transaction"),
    Transaction_Response(
      "transaction-response",
      "http://hl7.org/fhir/bundle-type",
      "Transaction Response",
    ),
    Batch("batch", "http://hl7.org/fhir/bundle-type", "Batch"),
    Batch_Response("batch-response", "http://hl7.org/fhir/bundle-type", "Batch Response"),
    History("history", "http://hl7.org/fhir/bundle-type", "History List"),
    Searchset("searchset", "http://hl7.org/fhir/bundle-type", "Search Results"),
    Collection("collection", "http://hl7.org/fhir/bundle-type", "Collection"),
    Subscription_Notification(
      "subscription-notification",
      "http://hl7.org/fhir/bundle-type",
      "Subscription Notification",
    );

    override fun toString(): kotlin.String = code

    public companion object {
      public fun fromCode(code: kotlin.String): BundleType =
        when (code) {
          "document" -> Document
          "message" -> Message
          "transaction" -> Transaction
          "transaction-response" -> Transaction_Response
          "batch" -> Batch
          "batch-response" -> Batch_Response
          "history" -> History
          "searchset" -> Searchset
          "collection" -> Collection
          "subscription-notification" -> Subscription_Notification
          else -> throw IllegalArgumentException("Unknown code $code for enum BundleType")
        }
    }
  }
}
